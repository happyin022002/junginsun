/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmMas0221Event.java
*@FileTitle : EMU Credit Table
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.29
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2014.07.29 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.MasEMUCreditListVO;


/**
 * ESM_MAS_0221 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0221HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_MAS_0221HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0221Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	MasEMUCreditListVO masEMUCreditListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	MasEMUCreditListVO[] masEMUCreditListVOs = null;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;	


	public EsmMas0221Event(){}
	
	public void setMasEMUCreditListVO(MasEMUCreditListVO masEMUCreditListVO){
		this. masEMUCreditListVO = masEMUCreditListVO;
	}

	public void setMasEMUCreditListVOS(MasEMUCreditListVO[] masEMUCreditListVOs){
		this. masEMUCreditListVOs = masEMUCreditListVOs;
	}

	public MasEMUCreditListVO getMasEMUCreditListVO(){
		return masEMUCreditListVO;
	}

	public MasEMUCreditListVO[] getMasEMUCreditListVOS(){
		return masEMUCreditListVOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

}