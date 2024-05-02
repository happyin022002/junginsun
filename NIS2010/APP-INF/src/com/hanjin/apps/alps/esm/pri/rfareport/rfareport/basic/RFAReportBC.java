/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAReportBC.java
*@FileTitle : RFA Proposal Creation – Draft
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.09.15 변영주
* 1.0 Creation
=========================================================
2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나
조회 가능토록 수정 - searchRFARateSearchListDoStart,searchRFAList SignOnUserAccount parameter 추가
* 2014.11.25 [CHM-201432700] 최성환 Retroactive RFA Minimization관련 시스템 개발요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.MasterRFAConditionVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriCopiedRFAVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriMasterRFAOnlyVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriRFABlVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriRpRetroInfoVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltRFARetRDInfoVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltSearchRFAListVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltSearchRFARateSearchListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpMnVO;

/**
 * ALPS-Rfareport Business Logic Command Interface<br>
 * - ALPS-Rfareport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Byeon Young Joo
 * @see UI_PRI_2039, 2052 EventReponse 참조
 * @since J2EE 1.6
 */

public interface RFAReportBC {

	/**
	 * 조회 이벤트 처리<br>
	 * RFAReport의 Report 관련 정보 조회 이벤트 처리<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltRFARetRDInfoVO>
	 * @exception EventException
	 */
	public List<RsltRFARetRDInfoVO> searchRFARetrievalRDInfo(PriRpMnVO priRpMnVO) throws EventException;
	
	/**
	 * RFA Search - RFA Retrieval 리스트를 조회한다. <br>
     *
	 * @param RsltSearchRFAListVO rsltSearchRFAListVO
	 * @param SignOnUserAccount account
	 * @return List<RsltSearchRFAListVO>
	 * @exception EventException
	 */
	public List<RsltSearchRFAListVO> searchRFAList(RsltSearchRFAListVO rsltSearchRFAListVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * RFA Search - Rate Retrieval 리스트를 조회 위해 BackEndJob을 실행한다.<br>
     *
	 * @param SignOnUserAccount account
	 * @param RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchRFARateSearchListDoStart(SignOnUserAccount account, RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO) throws EventException;

	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String object
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String object) throws EventException;
	
	/**
	 * Retroactive RFA Search -Retroactive RFA Retrieval 리스트를 조회한다.<br>
     *
	 * @param RsltPriRpRetroInfoVO rsltPriRpRetroInfoVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPriRpRetroInfoVO>
	 * @exception EventException
	 */
	public List<RsltPriRpRetroInfoVO> searchRetroactiveRFAList(RsltPriRpRetroInfoVO rsltPriRpRetroInfoVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_PRI_2219_01 - Retrieve
	 * 
	 * @param MasterRFAConditionVO masterRFAConditionVO
	 * @return List<RsltPriMasterRFAOnlyVO>
	 * @exception EventException
	 */
	public List<RsltPriMasterRFAOnlyVO> searchMasterRFAOnlyList(MasterRFAConditionVO masterRFAConditionVO) throws EventException;
	
	/**
	 * ESM_PRI_2219_02 - Retrieve
	 * 
	 * @param MasterRFAConditionVO masterRFAConditionVO
	 * @return List<RsltPriCopiedRFAVO>
	 * @exception EventException
	 */
	public List<RsltPriCopiedRFAVO> searchCopiedRFAList(MasterRFAConditionVO masterRFAConditionVO) throws EventException;
	
	/**
	 * ESM_PRI_2211 - Retrieve
	 * 
	 * @param MasterRFAConditionVO masterRFAConditionVO
	 * @return List<RsltPriRFABlVO>
	 * @exception EventException
	 */
	public List<RsltPriRFABlVO> searchRFABlList(MasterRFAConditionVO masterRFAConditionVO) throws EventException;
	
}