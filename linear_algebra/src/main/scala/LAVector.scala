case class LAVector (coordinates: Double*) {
  private def assertSameDimensions(vector: LAVector): Unit = {
    if (vector.coordinates.size != coordinates.size) {
      throw new IllegalArgumentException("LAVector must have same number of dimensions")
    }
  }
  def +(vector: LAVector): LAVector = {
    assertSameDimensions(vector)
    new LAVector(coordinates.zip(vector.coordinates).map{case (i1, i2) => i1 + i2}: _*)
  }

  def -(vector: LAVector): LAVector = {
    assertSameDimensions(vector)
    new LAVector(coordinates.zip(vector.coordinates).map{case (i1, i2) => i1 - i2}: _*)
  }

  def *(d: Double): LAVector = {
    new LAVector(coordinates.map(_ * d): _*)
  }

  def *:(d: Double): LAVector = {
    * (d)
  }

  //Inner product
  def dot(vector: LAVector) = {
    coordinates
      .zip(vector.coordinates)
      .map{case (i1, i2) => i1 * i2}
      .sum
  }

  def theta(vector: LAVector, inDegrees: Boolean=false) = {
    val theta = math.acos(dot(vector) / (this.magnitude * vector.magnitude) )
    if (inDegrees) math.toDegrees(theta)
    else theta
  }

  def parallelTo(vector: LAVector) = {
    val multiplicator =  vector.coordinates.head / coordinates.head
    coordinates.zip(vector.coordinates).forall{ case (a, b) => a * multiplicator == b}
  }

  def orthogonalTo(vector: LAVector, tolerance: Double = 1E-10): Boolean = {
    dot(vector) < tolerance
  }

  lazy val magnitude = math.sqrt(coordinates.map(math.pow(_, 2)).sum)


  lazy val normalize = (1 / magnitude) *: this
  override def toString: String = s"LAVector(${coordinates.mkString(", ")})"
}
