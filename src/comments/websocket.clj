(ns comments.websocket
  (:require [org.httpkit.server :refer [with-channel on-close on-receive send!]]
            [comments.data :as data]
            [cheshire.core :refer [generate-string]]))

(def clients (atom {}))
(def comment-box (atom {}))

(defn send-message-to-clients [msg]
  (let [clients (keys @comment-box)]
    (when (seq clients)
      (doseq [client clients]
        (send! client msg false)))))

(defn comments-ws [req]
  (with-channel req channel
    (swap! comment-box assoc channel {:name nil :email nil :room nil})  ;; Keep track of new client. Add to data-struct
    (doseq [msg (data/get-chat-history "http://c0mment.com")] (send! channel msg false))     ;; Send new client chat history
    (println channel "connected")
    (on-close channel
              (fn [status]
                (swap! comment-box dissoc channel)
                (println channel "disconnected. status: " status)))
    (on-receive channel (fn [data]
                          (let [sender-msg  (read-string data)
                                sender-info (channel comment-box)]
                            ;;;;
                            ;; Dar, revise w/ own data.clj
                            (data/put-message-in-history sender-info sender-msg) ;; Put message in history
                            (send-message-to-clients sender-msg)                 ;; Send all clients the message
                            ;;;;
                            (println "on-receive channel:" channel " data:" data)
                            (println "chat-ws comment-box" @comment-box))))) 
  )
