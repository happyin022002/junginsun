/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTpb0804Event.java
*@FileTitle : AdjustmentManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.10.01 최 선 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.event;

import com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo.SearchROCToOfficeListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TPB_0804 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TPB_0804HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sun, CHOI
 * @see ESD_TPB_0804HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdTpb0804Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchROCToOfficeListVO searchROCToOfficeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchROCToOfficeListVO[] searchROCToOfficeListVOs = null;

	public EsdTpb0804Event(){}

	public SearchROCToOfficeListVO getSearchROCToOfficeListVO() {
		return searchROCToOfficeListVO;
	}

	public void setSearchROCToOfficeListVO(
			SearchROCToOfficeListVO searchROCToOfficeListVO) {
		this.searchROCToOfficeListVO = searchROCToOfficeListVO;
	}

	public SearchROCToOfficeListVO[] getSearchROCToOfficeListVOs() {
		return searchROCToOfficeListVOs;
	}

	public void setSearchROCToOfficeListVOs(
			SearchROCToOfficeListVO[] searchROCToOfficeListVOs) {
		this.searchROCToOfficeListVOs = searchROCToOfficeListVOs;
	}
	

}