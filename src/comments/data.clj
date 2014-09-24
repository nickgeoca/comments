(ns groops.data
  (:require [clojure.set :refer (index)]
            [groops.async :as async]))

;; Stubs by Nick G.
(defn put-message-in-history [person data]
  "")
(defn clear-chat-history "")  ;; Debug tool, maybe remove later?
(defn get-chat-history ["client1: msg1" "client2: msg2..."]) ;; Return list/array/whatever of history, then will map over it sending each message to new client
