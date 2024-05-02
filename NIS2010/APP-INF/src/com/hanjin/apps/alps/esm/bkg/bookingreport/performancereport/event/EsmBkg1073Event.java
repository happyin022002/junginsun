/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1073Event.java
*@FileTitle : Customer EDI ID Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailReturnInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchEDIGrpIDVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1073 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1073HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_1073HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1073Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchEDIGrpIDVO infoVO = null;

	/** Table Value Object Multi Data 처리 */
	private SearchEDIGrpIDVO[] infoVOs = null;
	
	
	public EsmBkg1073Event(){}


	public SearchEDIGrpIDVO getInfoVO() {
		return infoVO;
	}


	public void setInfoVO(SearchEDIGrpIDVO infoVO) {
		this.infoVO = infoVO;
	}


	public SearchEDIGrpIDVO[] getInfoVOs() {
		return infoVOs;
	}


	public void setInfoVOs(SearchEDIGrpIDVO[] infoVOs) {
		this.infoVOs = infoVOs;
	}


	
	
}