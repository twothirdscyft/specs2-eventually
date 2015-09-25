name                  := """specs2-eventually"""

scalaVersion          := "2.11.7"

lazy val root = (project in file("."))

lazy val specsVersion  = "3.6.4"

resolvers ++= Seq[Resolver](
  "spray repo"     at "http://repo.spray.io",
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
)

libraryDependencies ++= Seq(
  "org.scalaz"             %% "scalaz-core"                         % "7.1.1",
  "org.specs2"             %% "specs2-core"                         % specsVersion          % "test",
  "org.specs2"             %% "specs2-mock"                         % specsVersion          % "test",
  "org.specs2"             %% "specs2-junit"                        % specsVersion          % "test",
  "org.specs2"             %% "specs2-matcher-extra"                % specsVersion          % "test",
  "com.novocode"            % "junit-interface"                     % "0.11"                % "test->default"
)

scalacOptions ++= Seq(
  "-language:_",
  "-target:jvm-1.7",
  "-deprecation",           
  "-encoding", "UTF-8",       // yes, this is 2 args
  "-feature",                
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xfatal-warnings",       
  "-Xlint",
  "-Yno-adapted-args",       
  "-Ywarn-dead-code",        // N.B. doesn't work well with the ??? hole
  "-Ywarn-numeric-widen",   
  "-Ywarn-value-discard",
  "-Xfuture",
  "-Ywarn-unused-import",     // 2.11 only
  "-Xmax-classfile-name", "144" // due to "File name too long" when using ecryptfs (see https://bugs.launchpad.net/ecryptfs/+bug/344878)
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")

