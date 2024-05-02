/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireApprovalBC.java
*@FileTitle : On Hire Approval inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.basic; 

import java.util.List;

import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalOwnListVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.LseOnhAproVO;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
/**
 * Containerleasemgt Business Logic Command Interface<br>
 * Containerleasemgt Biz Logic Interface<br>
 *
 * @author 
 * @see Ees_lse_0031EventResponse 
 * @since J2EE 1.6
 */

public interface OnhireApprovalBC { 
	
	/**
	 * Handling Retrieving Event<br>
	 * Retrieving Approval number of Equipment which is going to be Onhire<br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return List<OnhireApprovalVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalVO> searchOnhireApprovalNumberBasic(OnhireApprovalVO onhireApprovalVO) throws EventException;
	
	/**
	 * Hnadling Auth No Retrieving Event<br>
	 * Handling Auth No Retrieving Event about OnHireApproval Screen<br>
	 * 
	 * @param  String pOnhLocCd
	 * @param  String pLstmCd
	 * @param  String cntrOnhAuthNo
	 * @return List<LseOnhAproVO>
	 * @exception EventException
	 */
	public List<LseOnhAproVO> searchOnhireApprovalNumberBrieflyBasic(String pOnhLocCd , String pLstmCd , String cntrOnhAuthNo) throws EventException;
	
	/**
	 *  Handling Saving Event<br>
	 *  Saving detail pick-up Approval after Hire Contract of hiring Containers(Long-term, Short-term, OF)<br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @param  OnhireApprovalVO[] onhireApprovalVOs
	 * @param  SignOnUserAccount account
	 * @param  List<MdmCntrTpSzVO> cntrList
	 * @return String
	 * @exception EventException
	 */
	public String createOnhireApprovalNumberBasic( OnhireApprovalVO onhireApprovalVO ,  OnhireApprovalVO[] onhireApprovalVOs , SignOnUserAccount account, List<MdmCntrTpSzVO> cntrList) throws EventException;
	    
	/**
	 * Handling Modifying and Retrieving Event<br>
	 * Retrieving detail pick-up Approval modifying information of hiring Container<br>
	 * 
	 * @param  String authNo
	 * @param  String tysz
	 * @return List<OnhireApprovalVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalVO> searchOnhireApprovalNumber2Basic(String authNo , String tysz) throws EventException; 
	
	/**
	 * Handling Modifying Event<br>
	 * Cancelling pick-up Approval modifying information of hiring Container<br>
	 * 
	 * @param  String authNo
	 * @param  String agmtCtyCd
	 * @param  String agmtSeq
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelOnhireApprovalNumberBasic(String authNo , String agmtCtyCd ,String agmtSeq , SignOnUserAccount account) throws EventException;

	/**
	 * save Event Handling<br>
	 * After Long/Short term Container hiring Contract, when there is change in detail pick-up Approval, Updating <br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @param  SignOnUserAccount account
	 * @param  OnhireApprovalVO[] onhireApprovalVOs
	 * @param  List<MdmCntrTpSzVO> cntrList
	 * @return String
	 * @exception EventException
	 */
	public String modifyOnhireApprovalNumberBasic( OnhireApprovalVO onhireApprovalVO , SignOnUserAccount account,  OnhireApprovalVO[] onhireApprovalVOs, List<MdmCntrTpSzVO> cntrList) throws EventException;
	
	/**
	 * Handling Retrieving Event<br>
	 * Retrieving picked up Own Containers to give Auth No  <br>
	 * 
	 * @param  String locCd
	 * @param  String locTp
	 * @return List<OnhireApprovalOwnListVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalOwnListVO> searchApprovalOwnListBasic(String locCd ,String locTp ) throws EventException;

	/**
	 * Handling Retrieving Event<br>
	 *  Handling Retrieving Own Equipment Sum Event for OnhireApproval Screen <br>
	 *
	 * Sum List hidden Sheet Retrieving
	 * @param String locCd
	 * @param String locTp
	 * @return List<OnhireApprovalOwnListVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalOwnListVO> searchApprovalOwnSumListBasic(String locCd ,String locTp ) throws EventException;

	/**
	 * Handling Retrieving Own Container pick-up Event<br>
	 * After Long/Short term Container hiring Contract, Retrieving pick-up amount about pick-up Approval<br>
	 * 
	 * Sum List hidden Sheet Retrieving
	 * @param  SearchApprovalVO searchApprovalVO
	 * @return List<SearchApprovalVO>
	 * @exception EventException
	 */
	public List<SearchApprovalVO> searchPickupStatusSummaryBasic(SearchApprovalVO searchApprovalVO ) throws EventException;
		
	/**
	 * Handling Retrieving Event<br>
	 * After Long/Short term Container hiring Contract, Retrieving pick-up amount about pick-up Approval in dettail<br>
	 * 
	 * Sum List hidden Sheet Retrieving
	 * @param  SearchApprovalDetailVO searchApprovalDetailVO
	 * @return List<SearchApprovalDetailVO>
	 * @exception EventException
	 */
	public List<SearchApprovalDetailVO> searchPickupStatusDetailBasic(SearchApprovalDetailVO searchApprovalDetailVO ) throws EventException;
	
	/**
	 * Handling Modifying and Retrieving Event<br>
	 * Handling Event retrieving Lift On Charge information of Equipment which is going to be Onhire<br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return List<OnhireApprovalVO>
	 * @exception EventException
	 */
	public List<OnhireApprovalVO> searchOnhireApprovalLiftOnChargeBasic(OnhireApprovalVO onhireApprovalVO) throws EventException;
	
	/**
	 * <br>
	 * Checking AGMT TP/SZ<br>
	 * 
	 * @param  OnhireApprovalVO onhireApprovalVO
	 * @return String
	 * @exception EventException
	 */
    public String searchValidaionAgmtTpsz(OnhireApprovalVO onhireApprovalVO) throws EventException;
}