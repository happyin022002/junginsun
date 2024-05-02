/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_035Event.java
*@FileTitle : FAC Location info Pop-up 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-30
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-11-30 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.event;

import com.clt.apps.opus.esm.agt.common.event.AGTEvent;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.AgtFacAgmtGrpLocListVO;

/**
 * ESM_AGT_035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang GyeongNam
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0035Event extends EventSupport {
	
	
	private static final long	serialVersionUID	= 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리 */
	private AgtFacAgmtGrpLocListVO	  agtFacAgmtGrpLocVO	 = null;

	/** Table Value Object Multi Data 처리 */
	private AgtFacAgmtGrpLocListVO[]	agtFacAgmtGrpLocVOs	= null;

	/**
	 * Default 생성자<br>
	 */
	public EsmAgt0035Event(){}

	public AgtFacAgmtGrpLocListVO getAgtFacAgmtGrpLocVO() {
		return agtFacAgmtGrpLocVO;
	}

	public void setAgtFacAgmtGrpLocVO(AgtFacAgmtGrpLocListVO agtFacAgmtGrpLocVO) {
		this.agtFacAgmtGrpLocVO = agtFacAgmtGrpLocVO;
	}

	public AgtFacAgmtGrpLocListVO[] getAgtFacAgmtGrpLocVOs() {
		return agtFacAgmtGrpLocVOs;
	}

	public void setAgtFacAgmtGrpLocVOs(AgtFacAgmtGrpLocListVO[] agtFacAgmtGrpLocVOs) {
		this.agtFacAgmtGrpLocVOs = agtFacAgmtGrpLocVOs;
	}
	
	

}
