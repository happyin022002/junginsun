/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : salesrepresentativeBC.java
*@FileTitle : sales rep.
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.basic;
 
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.vo.SalesRepVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Sales representative Business Logic Command Interface<br>
 * An interface to the business logic for Sales representative<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */

public interface SalesRepresentativeBC {

	/**
	 * sls rep code should look up the detailed information.<br>
	 * 
	 * @param String srepCd
	 * @return SalesRepVO
	 * @exception EventException
	 */
	public SalesRepVO searchSlsRepCode(String srepCd) throws EventException;
	
	/**
	 * sls rep code should look up the detailed information.<br>
	 * 
	 * @param String rqstNo
	 * @return SalesRepVO
	 * @exception EventException
	 */
	/*public SalesRepVO searchSlsRepRqst(String rqstNo) throws EventException;*/
	
	/**
	 * Sls rep code generation, and queried the new sls rep code to modify the details.<br>
	 * 
	 * @param SalesRepVO salesRepVO
	 * @exception EventException
	 */
	public void manageSlsRepCode(SalesRepVO salesRepVO) throws EventException;
	
	/**
	 * Sls rep code generation, and queried the new sls rep code to modify the details.<br>
	 * 
	 * @param SalesRepVO salesRepVO
	 * @exception EventException
	 */
	public void manageSlsRepRqst(SalesRepVO salesRepVO) throws EventException;
	
	/**
	 * sls rep code to query the last seq .<br>
	 * 
	 * @param String cntCd
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchSlsRepMaxSeq(String cntCd, SignOnUserAccount account) throws EventException;
	
	/**
	 * Srep Code 정보를 EAI로 전송한다. <BR>
	 * @param String srepCd
	 * @param String usrId
	 * @param String creFlag
	 */
	public void sendSrepCdToMdm(String srepCd, String usrId, String creFlag) throws EventException;
	
}