/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AgencyCommissionBC.java
*@FileTitle : Agency Commission 단가 조회/수정
*Open Issues :
*@LastModifyDate : 2009-09-21
*@LastModifier : JEON SUNGJIN
*@LastVersion : 1.1
* 2007-07-03 JEON SUNGJIN
* 1.0 최초 생성
* Change history :
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.vo.AvgAgencyCommissionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * opus-Stdunitcost Business Logic Command Interface<br>
 * - opus-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Yeong-seok
 * @see ESM_COA_4014EventResponse 참조
 * @since J2EE 1.6
 */
public interface AvgAgencyCommissionBC {

	/**
	 * Office Average Agency Commission 정보를 조회 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<AvgAgencyCommissionVO>
	 * @exception EventException
	 */
	public List<AvgAgencyCommissionVO> searchAvgAgencyCommissionOfficeList(SearchConditionVO searchConditionVO) throws EventException;

	
	/**
	 * Country Average Agency Commission 정보를 조회 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<AvgAgencyCommissionVO>
	 * @exception EventException
	 */
	public List<AvgAgencyCommissionVO> searchAvgAgencyCommissionCountryList(SearchConditionVO searchConditionVO) throws EventException;

	
	/**
	 * [Office Average Agency Commission 입력,수정,삭제<br>
	 * 
	 * @param AvgAgencyCommissionVO[] avgAgencyCommissionVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageAvgAgencyCommissionOffice(AvgAgencyCommissionVO[] avgAgencyCommissionVOs, SignOnUserAccount account) throws EventException;

	
	/**
	 * [Country Average Agency Commission 입력,수정,삭제<br>
	 * 
	 * @param AvgAgencyCommissionVO[] avgAgencyCommissionVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageAvgAgencyCommissionCountry(AvgAgencyCommissionVO[] avgAgencyCommissionVOs, SignOnUserAccount account) throws EventException;
}