/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : organizationBC.java
*@FileTitle : organization
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.organization.basic;

import java.util.List;

import com.clt.apps.opus.bcm.ccd.commoncode.organization.vo.OfcAccGrpMapVO;
import com.clt.apps.opus.bcm.ccd.commoncode.organization.vo.OfcAccGrpVO;
import com.clt.apps.opus.bcm.ccd.commoncode.organization.vo.OfficeVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Organization Business Logic Command Interface<br>
 * An interface to the business logic for organization<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */

public interface OrganizationBC {
	
	/**
	 * BCM_CCD_0032 : Retrieve <br>
	 * Office should look up the information you entered.<br>
	 * 
	 * @param String ofcCd
	 * @return OfficeVO
	 * @exception EventException 
	 */ 
	public List<OfficeVO> searchOfcCode(String ofcCd) throws EventException;  
	
	/**
	 * BCM_CCD_0032 : Save <br>
	 * Input and retrieved Office will add and modify information
	 * 
	 * @param OfficeVO ofcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */  
	public void manageOfcCode(OfficeVO ofcVO,SignOnUserAccount account) throws EventException;  
	
	/**
	 * BCM_CCD_0041 : Retrieve <br>
	 * Office access group should look up the information you entered<br>
	 * 
	 * @param String sybSysCd
	 * @param String accGrpId
	 * @return List<OfcAccGrpVO>
	 * @exception EventException
	 */
	public List<OfcAccGrpVO> searchOfcAccGrp(String sybSysCd, String accGrpId) throws EventException;  
	
	/**
	 * BCM_CCD_0041 : Save <br>
	 * Input and retrieved Office Access Group Creation will add and modify information.<br>
	 * 
	 * @param OfcAccGrpVO[] ofcAccGrpVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void manageOfcAccGrp(OfcAccGrpVO[] ofcAccGrpVOs,SignOnUserAccount account) throws EventException;  
	 
	/**
	 * BCM_CCD_0042 : Retrieve <br>
	 *  Office Access Group Mapping(Pop-up) should look up the information you entered.<br>
	 * 
	 * @param String sybSysCd
	 * @param String ofcGrpId
	 * @return List<OfcAccGrpMapVO>
	 * @exception EventException
	 */ 
	public List<OfcAccGrpMapVO> searchOfcAccGrpMap(String sybSysCd, String ofcGrpId) throws EventException;  
	 
	/**
	 * BCM_CCD_0042 : Save <br>
	 * Input and retrieved Office Access Group Mapping(Pop-up will add and modify information<br>
	 * 
	 * @param OfcAccGrpMapVO[] ofcAccGrpMapVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOfcAccGrpMap(OfcAccGrpMapVO[] ofcAccGrpMapVOs, SignOnUserAccount account) throws EventException;  
}