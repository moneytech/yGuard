package com.yworks.yshrink.ant;

import com.yworks.yshrink.util.Logger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;

/**
 * @author Michael Schroeder, yWorks GmbH http://www.yworks.com
 */
public class AntLogger extends Logger {

  private final Task task;
  private final Project project;

  public AntLogger( final Project project, final Task task ) {
    this.project = project;
    this.task = task;
    register();
  }

  public void doLog( final String s ) {
    project.log( task, s, Project.MSG_INFO );
  }

  public void doErr( final String s ) {
    project.log( task, "ERROR: "+s, Project.MSG_ERR );
  }

  public void doWarn( String s ) {
    //project.log( task, "WARNING: "+s, Project.MSG_WARN );
  }

  public void doWarnToLog( String s ) {
  }

  public void doShrinkLog( String s ) {
//    project.log( s, Project.MSG_INFO );
  }

  public void doErr( String s, Throwable ex ) {
    project.log( task, "ERROR: "+s + "\n" + ex.getMessage(), Project.MSG_ERR );
  }

  public void doShrinkLog( String s, Logger.ShrinkType type ) {
  }

  public void close() {
    unregister();
  }
}
