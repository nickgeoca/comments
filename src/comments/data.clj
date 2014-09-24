(ns comments.data
  (:require [clojure.set :refer (index)]))

;; Stubs by Nick G.
(defn put-message-in-history [person data] true)
(defn clear-chat-history [] "") ;; Debug tool, maybe remove later?
(defn get-chat-history [url] (list "client1: msg1" "client2: msg2...")) ;; Return list/array/whatever of history, then will map over it sending each message to new client

;; Add?
;; (defn get-lastest-chat-history (get-chat-history))  ;; Gets last 20 messages
