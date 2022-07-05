(ns rich4clojure.easy.problem-066
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Greatest Common Divisor =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; 
;; Given two integers, write a function which returns the
;; greatest common divisor.


(defn __ [a b]
  (loop [a a b b]
    (if (= (mod a b) 0)
      b
      (recur b (mod a b)))))

(comment)

(tests
 (__ 2 4) := 2
 (__ 10 5) := 5
 (__ 5 7) := 1
 (__ 1023 858) := 33)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/4aa85a5a1d6e6962548e6dc69a02a55e