/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBsa0120Event.java
*@FileTitle : Carrier's Infomation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.09.29 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event;

import com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo.SearchBsaConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BSA_0120 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BSA_0120HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONG Jin Ho
 * @see ESM_BSA_0120HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBsa0120Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchBsaConditionVO searchBsaConditionVO=null;
	

	public EsmBsa0120Event(){}


	public SearchBsaConditionVO getSearchBsaConditionVO() {
		return searchBsaConditionVO;
	}


	public void setSearchBsaConditionVO(SearchBsaConditionVO searchBsaConditionVO) {
		this.searchBsaConditionVO = searchBsaConditionVO;
	}

	
	

}