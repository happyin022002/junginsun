/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SalesRepInfoManageBC.java
*@FileTitle : Sales Rep List
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.basic;

import java.util.List;

import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.vo.CustomsCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.vo.SamCustSRepVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Generalinfomanage Business Logic Command Interface<br>
 * - OPUS-Generalinfomanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author LEECHANGWON
 * @see 
 * @since J2EE 1.6
 */

public interface SalesRepInfoManageBC {

	/**
	 * ESM_SAM_0006
	 * account를 통해 srep_cd 조회를 통해 페이지 로드<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return void
	 * @exception EventException
	 */
	
	public String searchSRepNameByUser(SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SAM_0006	 
	 * Srep_cd 로 on_change<br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return List<CntrSpecListBrieflyVO>
	 * @exception EventException
	 */
	
	public List<SearchCustomerVO> searchCustomerBySalesRep(SearchCustomerVO searchCustomerVO) throws EventException;
	
	/** ESM_SAM_0006, ESM_SAM_0900 <br>
	 * S.Rep Code 별 데이타를 조회합니다.<br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return List<CntrSpecListBrieflyVO>
	 * @exception EventException
	 * 
	 */
	public String searchSRepName(SearchCustomerVO searchCustomerVO)throws EventException;
	
	
	/**
	 * ESM_SAM_0005 : Retrieve<br>
	 * 
	 * @param SamCustSRepVO	samCustSRepVO
	 * @return List<SamCustSRepVO>
	 * @exception EventException
	 * 
	 */
	public List<SamCustSRepVO> searchSRepList(SamCustSRepVO samCustSRepVO) throws EventException;
	
	/** ESM_SAM_0006, ESM_SAM_0900 <br>
	 * S.Rep Code 별 데이타를 조회합니다.<br>
	 *
	 * @param SearchCustomerVO searchCustomerVO
	 * @return List<CntrSpecListBrieflyVO>
	 * @exception EventException
	 * 
	 */
	public SearchCustomerVO searchPrmyKey(SearchCustomerVO searchCustomerVO) throws EventException;	

	/**
	 * ESM_SAM_0900 <br>
	 * 변경된 SrepFlg를 저장r>
	 * 
	 * @param CustomsCustomerVO customsCustomerVO
     * @param SignOnUserAccount account
     * @param String key
	 * @exception EventException
	 * 
	 */
	public void manageCustSRep(CustomsCustomerVO customsCustomerVO, SignOnUserAccount account, String key) throws EventException;

	/** ESM_SAM_0001 <br>
	 * Sales Office의 소속된 Sales Rep Code정보를 combo로 조회한다.<br>
	 *
	 * @param String sls_ofc_cd
	 * @return List<SamCustSRepVO>
	 * @exception EventException
	 * 
	 */
	public List<SamCustSRepVO> searchSalesRepBySalesOffice(String sls_ofc_cd) throws EventException;	

}