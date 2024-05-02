/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VskEmailSendBC.java
*@FileTitle : VskEmailSend
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.26
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.07.26 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.emailjobmanage.vskemailsend.basic;

import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Emailjobmanage Business Logic Command Interface<br>
 * - ALPS-Emailjobmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Jun Yong 
 * @see 
 * @since J2EE 1.6
 */

public interface VskEmailSendBC {

	/**
	 * @param eml_jb_id String
	 * @throws EventException ...
	 */
	public void sendVslSkdEmail(String eml_jb_id) throws EventException;
}