/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0078Event.java
*@FileTitle : Offhire Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.05.20 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireSelectionListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_FMS_0078 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0078HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGYOONTAE
 * @see ESM_FMS_0078HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0078Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** FletCtrlNo 계약번호 */
	private String fletCtrtNo = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchOffhireSelectionListVO searchOffhireSelectionListVO = null;

	public EsmFms0078Event(){}
	
	public void setCustomSendEmailVO(SearchOffhireSelectionListVO searchOffhireSelectionListVO){
		this.searchOffhireSelectionListVO = searchOffhireSelectionListVO;
	}
	
	public SearchOffhireSelectionListVO getSearchOffhireSelectionListVO(){
		return searchOffhireSelectionListVO;
	}
	
	public String getFletCtrtNo() {
		return fletCtrtNo;
	}

	public void setFletCtrtNo(String fletCtrtNo) {
		this.fletCtrtNo = fletCtrtNo;
	}
}
