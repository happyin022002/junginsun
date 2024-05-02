/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0117Event.java
*@FileTitle : SMU Cost (RA) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2006.12.07 김종범 최초 생성
* 2009.09.11 0115 화면 New Framework 적용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchSeasonalSMUCostPopListVO;
import com.hanjin.syscommon.common.table.CoaLaneDirConvVO;


/**
 * ESM_COA_0121 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0121HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHKIM
 * @see ESM_COA_0121HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0121Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSeasonalSMUCostPopListVO searchSeasonalSMUCostPopListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSeasonalSMUCostPopListVO[] searchSeasonalSMUCostPopListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaLaneDirConvVO coaLaneDirConvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaLaneDirConvVO[] coaLaneDirConvVOs = null;
	
	/** 입력 Data 처리 */
	private SearchConditionVO searchConditionVO = null;

	public EsmCoa0121Event(){}
	
	public void setSearchSeasonalSMUCostPopListVO(SearchSeasonalSMUCostPopListVO searchSeasonalSMUCostListVO){
		this. searchSeasonalSMUCostPopListVO = searchSeasonalSMUCostPopListVO;
	}

	public void setSearchSeasonalSMUCostPopListVOS(SearchSeasonalSMUCostPopListVO[] searchSeasonalSMUCostListVOs){
		this. searchSeasonalSMUCostPopListVOs = searchSeasonalSMUCostListVOs;
	}

	public void setCoaLaneDirConvVO(CoaLaneDirConvVO coaLaneDirConvVO){
		this. coaLaneDirConvVO = coaLaneDirConvVO;
	}

	public void setCoaLaneDirConvVOS(CoaLaneDirConvVO[] coaLaneDirConvVOs){
		this. coaLaneDirConvVOs = coaLaneDirConvVOs;
	}
	
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this. searchConditionVO = searchConditionVO;
	}	

	public SearchSeasonalSMUCostPopListVO getSearchSeasonalSMUCostPopListVO(){
		return searchSeasonalSMUCostPopListVO;
	}

	public SearchSeasonalSMUCostPopListVO[] getSearchSeasonalSMUCostPopListVOS(){
		return searchSeasonalSMUCostPopListVOs;
	}

	public CoaLaneDirConvVO getCoaLaneDirConvVO(){
		return coaLaneDirConvVO;
	}

	public CoaLaneDirConvVO[] getCoaLaneDirConvVOS(){
		return coaLaneDirConvVOs;
	}
	
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}

}