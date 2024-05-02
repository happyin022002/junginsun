/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CgmEdiInterfaceMgtBC.java
*@FileTitle : common EDI Send
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : P.K.S
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.basic;


import com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.vo.ChassisShipMentFlatFileVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-Operationmanage Business Logic Command Interface<br>
 *
 * @author 
 * @see reference for File Upload 
 * @since J2EE 1.6
 */

public interface CgmEdiInterfaceMgtBC {

	/**
	 * <br>
	 *
	 * @return String
	 * @exception EventException
	 */
	public String chaShipmentSendBasic() throws EventException;	
}