(ns rich4clojure.easy.problem-030
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Compress a Sequence =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs]
;; 
;; Write a function which removes consecutive duplicates
;; from a sequence.

(def __ (fn [s]
          (loop [prev-char (first s)
                 current-char (second s)
                 s (nthrest s 2)
                 result [prev-char]]
            (if (empty? s)
              (if (= prev-char current-char)
                result
                (conj result current-char))
                (if (= prev-char current-char)
                  (recur prev-char (first s) (rest s) result)
                  (recur current-char (first s) (rest s) (conj result current-char)))))))

(comment
  
  )

(tests
  (apply str (__ "Leeeeeerrroyyy")) := "Leroy"
  (__ [1 1 2 3 3 2 2 3]) := '(1 2 3 2 3)
  (__ [[1 2] [1 2] [3 4] [1 2]]) := '([1 2] [3 4] [1 2]))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/92a4bd13aaa6bffb80d7724de2c8e64d