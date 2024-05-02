/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0035Event.java
*@FileTitle : EsmBsa0035Event
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-10
*@LastModifier : 김용습
*@LastVersion : 1.0
* 2009.07.14 김용습
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event;

import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.BsaTableSaveVO;
import com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BSA_0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Yongseup
 * @see ESM_BSA_0035HTMLAction 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class EsmBsa0035Event extends EventSupport {
	/** 조회 조건 단건처리 */
	private SearchBsaConditionVO searchBsaConditionVO = null;	

	/** Constructor */
	public EsmBsa0035Event(){}	
	
	/** Search Condition Getter */
	public SearchBsaConditionVO getSearchBsaConditionVO() {
		return searchBsaConditionVO;
	}

	/** Search Condition Setter */
	public void setSearchBsaConditionVO(SearchBsaConditionVO searchBsaConditionVO) {
		this.searchBsaConditionVO = searchBsaConditionVO;
	}

}
