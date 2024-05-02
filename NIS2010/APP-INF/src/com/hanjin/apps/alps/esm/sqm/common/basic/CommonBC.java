/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CommonBC.java
*@FileTitle      : Common
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.06
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.06 SQM USER
* 1.0 Creation
* 2016.08.11 Basic CMCB (CM Cost Per Box) 화면 Add Creation 버튼 추가
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.common.basic;

import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.CommonVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.SearchCommonCodeVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Common Business Logic Command Interface<br>
 * - ALPS-Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
 * @see
 * @since J2EE 1.6
 */

public interface CommonBC {
	
	/**
     * default combo, ibsheet codelist를 return <p>
     * 
     * @param String codeItem
     * @param String code
     * @return List<GetCodeSelectVO>
     * @throws EventException
     */
	public List<SearchCommonCodeVO> getCodeSelectList(String codeItem, String code) throws EventException ;
	
	/**
     * default combo, ibsheet codelist를 return <p>
     * 
     * @param GeneralEventResponse eventResponse
     * @param String[][] array
     * @return GeneralEventResponse
     * @throws EventException
     */
	public GeneralEventResponse getMakeCodeSelectList(GeneralEventResponse eventResponse, String[][] array) throws EventException ;
	
	/**
	 * 계정에 따른 combo, ibsheet codelist 를 return <p>
	 * 
	 * @param codeItem  	업무 구분
	 *  					01. Trade 권한제어		: tradeControl
	 *  					02. lane 권한제어			: rLaneControl
	 *  
	 * @param ConditionVO conditionVO                     
	 * @param String codeItem		Where 절에 들어갈 코드그룹
	 * @param String code			Where 절에 들어갈 코드조건값
	 * @return List<SearchCommonCodeVO>
	 * @throws EventException
	 */
	public List<SearchCommonCodeVO> getCodeSelectListForPlanning(ConditionVO conditionVO,String codeItem, String code) throws EventException;
	
	/**
	 * 계정에 따른 combo, ibsheet codelist를 return <p>
	 * 
	 * <br><b>Example : </b>
	 * <pre>
	 *     String array[][] = {{"trade","",""}};
	 *     eventResponse = CodeUtil.getMakeCodeSelectList(eventResponse,array);
	 * </pre>
	 * 
	 * @param ConditionVO conditionVO    
	 * @param SignOnUserAccount account
	 * @param String[][] array
	 * @return GeneralEventResponse
	 * @throws EventException
	 */
	public GeneralEventResponse getMakeCodeSelectListForPlanning(ConditionVO conditionVO, SignOnUserAccount account, String[][] array) throws EventException;

	   /**
		 * IBSheet의 동적 콤보가 있을경우 Retrieve시 각각의 콤보를 세팅해 주어야 할때 사용한다.
		 * 
		 * @param codeItem      반환할 업무 대상
		 *                      01. 노선별 VVD List        : controlVvdList(f_bse_tp_cd|f_bse_yr|f_bse_qta_cd|trd_cd|sub_trd_cd)
		 *                      
		 * @param searchCode Where 절의 조건
		 * @return
		 * @throws EventException
		 */
	public HashMap<String, String> getCodeIbCombo(String codeItem, String searchCode) throws EventException ;


	/**
	 * BATCH status 를 생성한다. <br>
	 *
	 * @param CommonVO commonVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void addBatchStatus(CommonVO commonVO, SignOnUserAccount account) throws EventException;

	/**
	 * BATCH의 STATUS를 알아본다.
	 * 
	 * @paramCommonVO commonVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBatchStatus(CommonVO commonVO) throws EventException;
}