(ns rich4clojure.easy.problem-028
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Flatten a Sequence =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs core-functions]
;; 
;; Write a function which flattens a sequence.

(def restricted [flatten])

(def __ (fn fl
          [s]
          (if (or (seq? s) (vector? s))
           (loop [s s
                  flattened []]
             (let [f (first s)
                   flattened-f (if (or (seq? f) (vector? f))
                                (fl f)
                                [f])
                   r (rest s)]
               (if (nil? f)
                 flattened
                 (recur r (apply conj flattened flattened-f)) )
               ))
           [s])))

(comment
  
  )

(tests
  (__ '((1 2) 3 [4 [5 6]])) := '(1 2 3 4 5 6)
  (__ ["a" ["b"] "c"]) := '("a" "b" "c")
  (__ '((((:a))))) := '(:a))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/0c6e3c48cac7434882ca4b2c71ebfce1