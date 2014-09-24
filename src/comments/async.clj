(ns comments.async
  (:require [org.httpkit.server :refer [with-channel on-close on-receive send!]]
            [cheshire.core :refer [generate-string]]))

(def clients (atom {}))

(defn ws [req]
  (with-channel req channel
    (swap! clients assoc channel true)
    (println channel "connected")
    (on-close channel
              (fn [status]
                (swap! clients dissoc channel)
                (println channel "disconnected. status: " status)))))

;; ;; Important!!
;; (defn chat-ws [req]
;;   (with-channel req channel
;;     (swap! chat-clients assoc channel {:name nil :email nil :room nil})
;;     (println channel "connected")
;;     (on-close channel
;;               (fn [status]
;;                 (swap! chat-clients dissoc channel)
;;                 (println channel "disconnected. status: " status)))
;;     (on-receive channel (fn [data]
;;                          (println "on-receive channel:" channel " data:" data)
;;                          (swap! chat-clients assoc-in [channel] (read-string data))
;;                          (println "chat-ws chat-clients" @chat-clients)))))

;;(defn noun-container (rand-nth  ["bowl" "barrel" "trunk" "pool" "bathtub" "shoe" "house"]))
;;(defn noun-subj (rand-nth ["cherries" "apples" "beef-jerky" "raman-noodles" "headphones"]))
;;(defn adj-subj (rand-nth ["bitter" "sweet" "fun" "half-eaten" "ripe" "a " "cunning"]))
;; (def adj-subj "ab")
;; (def noun-subj "cd")
;; (def adj-subj "ef")
;;(defn generate-life-qoute  (str "Life is like a " noun-container " of " adj-subj " " noun-subj "... eese nice!"))
(def generate-life-qoute "test345")

(defn send-life-qoute []
  (let [life-qoute     (generate-life-qoute)
        message        life-qoute
        active-clients (keys @clients)]
    (when (seq active-clients)
      (println "sending the life qoute \"" life-qoute "\" to" (count active-clients) "clients")
      (doseq [client active-clients]
        (send! client message false)))))

;; TODO this should be core.async
(defn send-loop []
  (future (loop []
            (send-life-qoute)
            (Thread/sleep 5000)
            (recur))))
