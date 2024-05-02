/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_AGT_007Event.java
*@FileTitle : 미주 Brokerage 계약 요율 Creation/Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-30
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-11-30 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.AgtScsAgmtRtVO;

/**
 * ESM_AGT_007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang GyeongNam
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0057Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AgtScsAgmtRtVO agtScsAgmtRtVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AgtScsAgmtRtVO[] agtScsAgmtRtVOs = null;

	public EsmAgt0057Event(){}
	
	public void setAgtScsAgmtRtVO(AgtScsAgmtRtVO agtScsAgmtRtVO){
		this. agtScsAgmtRtVO = agtScsAgmtRtVO;
	}

	public void setAgtScsAgmtRtVOS(AgtScsAgmtRtVO[] agtScsAgmtRtVOs){
		this. agtScsAgmtRtVOs = agtScsAgmtRtVOs;
	}

	public AgtScsAgmtRtVO getAgtScsAgmtRtVO(){
		return agtScsAgmtRtVO;
	}

	public AgtScsAgmtRtVO[] getAgtScsAgmtRtVOS(){
		return agtScsAgmtRtVOs;
	}

}