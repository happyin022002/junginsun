/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmCoa0107Event.java
*@FileTitle : Allocation Result(Internal Pricing)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.14
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.10.12 이행지
* 1.0 Creation
*=========================================================
* History
* 2010.10.22 이행지 [CHM-201006375-01][COA] Trunk IPC와 Ocean간 내부거래 신규 추가 
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.event;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_COA_0107 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0107HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see ESM_COA_0107HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0107Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** 단건처리 */
	private SearchConditionVO searchConditionVO = null;

	public EsmCoa0107Event(){}
	
	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

}