/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsmSpc0122Event.java
*@FileTitle : Estimated CMPB
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.31
*@LastModifier : 
*@LastVersion : 1.2
* 1.0 Creation
* 
* 2015.07.06 ESM_BKG_1182 COPY  [CHM-201536749]Mastertable Import기능 오류 수정 CR에 반영(Revenue Management System 추가 보완 개발 요청 선반영 포함 - CMPB 팝업 연결 추가)
* 
=========================================================*/
package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.EstimatedCMPBVO;
import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * ESM_SPC_0122 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0122HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yang Dong Hun
 * @see ESM_SPC_0122HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmSpc0122Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	public EsmSpc0122Event(){}
	
	private EstimatedCMPBVO estimatedCMPBVO = null;
	private String bkgNo = null;
	
	public String getBkgNo() {
		return bkgNo;
	}
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	public EstimatedCMPBVO getEstimatedCMPBVO() {
		return estimatedCMPBVO;
	}
	public void setEstimatedCMPBVO(EstimatedCMPBVO estimatedCMPBVO) {
		this.estimatedCMPBVO = estimatedCMPBVO;
	}
}
