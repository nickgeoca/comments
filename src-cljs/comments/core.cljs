(ns comments.core
  (:require ;;[clojure.browser.repl]
            [figwheel.client :as fw :include-macros true]))
 
(enable-console-print!)

;; define your app data so that it doesn't get over-written on reload
;; (defonce app-data (atom {}))

(println "Test Container")
(defn default-action [action]
  (fn [e]
  (.preventDefault e)
  (action)))
(def ws-url (str "ws://" (.-host js/location) "/comments/ws"))
(def socket (js/WebSocket. ws-url))
(defn send-message [] (.send socket {:msg (.-value (.getElementById js/document "comment")) }))
(.preventDefault (.onClick (.getElementById js/document "send") send-message))
(fw/watch-and-reload
  :websocket-url   "ws://localhost:3449/figwheel-ws"
  :jsload-callback (fn [] (print "reloaded")))
(.send socket {:msg "this is message!"})
