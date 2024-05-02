/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrAccuracyTrendBC.java
*@FileTitle : Accuracy Trend
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.automtbkgmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.eqr.automtbkgmgt.vo.AutoMtBkgVO;

import com.clt.framework.core.layer.event.EventException;
//import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 *
 * @author 
 * @see EES_EQR_1025EventResponse 
 * @since J2EE 1.6
 */
public interface AutoMtBkgMgtBC {
	/**
	 * BCM_CCD_0032 : Retrieve <br>
	 * Office should look up the information you entered.<br>
	 * 
	 * @return List<AutoMtBkgVO>
	 * @exception EventException 
	 */ 
	public List<AutoMtBkgVO> searchAutoMtBkg() throws EventException;   
	
	
	
}