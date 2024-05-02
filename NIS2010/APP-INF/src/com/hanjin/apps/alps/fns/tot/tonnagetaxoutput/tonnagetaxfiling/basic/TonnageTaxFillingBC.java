/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxFillingBC.java
*@FileTitle : TonnageTaxFilling
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.25
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 2010.11.25 이병훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.FnsTot0027ConditionVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchActualBsaSummaryVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchBasicBsaSummaryVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchHiringOutAndLayingUpSummaryVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxfiling.vo.SearchSummaryCreationBatchVO;
/**
 * ALPS-Tonnagetaxoutput Business Logic Command Interface<br>
 * - ALPS-Tonnagetaxoutput에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Byoung Hun
 * @see EventException 참조
 * @since J2EE 1.6
 */

public interface TonnageTaxFillingBC {
	
	/**
	 * FNS_TOT_0024 : SEARCHLIST<br>
	 * 운항중인 모든 선박(피더선박 제외)들의 기본 BSA 변동별 내역을 조회한다.<br>
	 *
	 * @param year String
	 * @return List<SearchBasicBsaSummaryVO>
	 * @exception EventException
	 */
	public List<SearchBasicBsaSummaryVO> searchBasicBsaSummary(String year) throws EventException;
	
	/**
	 * FNS_TOT_0025 : SEARCH <br>
	 * 운항중인 모든 선박(피더선박 제외)들의 초과 BSA 변동별 내역을 조회한다.<br>
	 * 
	 * @param year String
	 * @return List<SearchActualBsaSummaryVO>
	 * @exception EventException
	 */
	public List<SearchActualBsaSummaryVO> searchActualBsaSummary(String year) throws EventException;

	/**
	 * FNS_TOT_0026 : SEARCH <br>
	 * 대선선박과 계선선박의 내역을 조회한다.<br>
	 * 
	 * @param year String
	 * @return List<SearchHiringOutAndLayingUpSummaryVO>
	 * @exception EventException
	 */
	public List<SearchHiringOutAndLayingUpSummaryVO> searchHiringOutAndLayingUpSummary(String year) throws EventException;
	
	/**
	 * 운항중인 모든 선박(피더선박 제외)들의 최신 Update Date 조회한다.<br>
	 * 
	 * @param year String
	 * @return String
	 * @exception EventException
	 */
	public String searchBasicBsaSummaryUpdate(String year) throws EventException;
	
	/**
	 * FNS_TOT_0027 : Retrive <br>
	 * 해당기간의 배치정보를 조회한다. <br>
	 * 
	 * @param conditionVO FnsTot0027ConditionVO
	 * @param hisType String
	 * @return List<SearchSummaryCreationBatchVO>
	 * @exception EventException
	 */
	public List<SearchSummaryCreationBatchVO> searchSummaryCreationBatch(FnsTot0027ConditionVO conditionVO, String hisType) throws EventException;

	/**
	 * FNS_TOT_0027 : Submit <br>
	 * 해당기간의 배치 history정보를 저장한다. <br>
	 * 
	 * @param conditionVO FnsTot0027ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createSummaryCreationBatch(FnsTot0027ConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * FNS_TOT_0027 : Cancel <br>
	 * 해당년월의 배치정보로 스케쥴정보를 삭제한다. <br>
	 * 
	 * @param jobID String
	 * @exception EventException
	 */
	public void removeSummaryCreationBatch(String jobID) throws EventException;
	
	/**
	 * 배치 실행 여부 확인 <br>
	 * 
	 * @param String pgmNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isRunningBatch(String pgmNo) throws EventException;	
}