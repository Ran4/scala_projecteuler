println(
  (1 to 999)
    .filter(n => n % 3 == 0 || n % 5 == 0)
    .sum
)
