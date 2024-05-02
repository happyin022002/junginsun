/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmCoa0221Event.java
*@FileTitle : EMU Credit Table
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.29
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2014.07.29 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.CoaEMUCreditListVO;


/**
 * ESM_COA_0221 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0221HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_COA_0221HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0221Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	CoaEMUCreditListVO coaEMUCreditListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	CoaEMUCreditListVO[] coaEMUCreditListVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	


	public EsmCoa0221Event(){}
	
	public void setCoaEMUCreditListVO(CoaEMUCreditListVO coaEMUCreditListVO){
		this. coaEMUCreditListVO = coaEMUCreditListVO;
	}

	public void setCoaEMUCreditListVOS(CoaEMUCreditListVO[] coaEMUCreditListVOs){
		this. coaEMUCreditListVOs = coaEMUCreditListVOs;
	}

	public CoaEMUCreditListVO getCoaEMUCreditListVO(){
		return coaEMUCreditListVO;
	}

	public CoaEMUCreditListVO[] getCoaEMUCreditListVOS(){
		return coaEMUCreditListVOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

}