/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingListSearchBC.java
*@FileTitle : Compulsory Firm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.26 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.cancellationmessage.basic;

import com.clt.framework.core.layer.event.EventException;


/**
 * 
 * @author c9014850
 * @see CancellationMessageBC 참조
 * @since J2EE 1.6
 */
public interface CancellationMessageBC {
	

	/**
	 * 
	 * @param bkgNo
	 * @param type
	 * @return
	 * @throws EventException
	 */
	public int sned301UEdiCheck(String bkgNo, String type) throws EventException;
}