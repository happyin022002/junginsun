/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_041Event.java
*@FileTitle : Customized Report Form
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-15
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2007-03-15 Hwang GyeongNam
* 1.0 최초 생성
* 2009-10-05 : Ho-Jin Lee Alps 전환
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.event;

import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AgtRptItmInfoMstDtlVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_AGT_041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang GyeongNam
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0041Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private AgtRptItmInfoMstDtlVO agtRptItmInfoMstDtlVO = null;
	
	private AgtRptItmInfoMstDtlVO[] agtRptItmInfoMstDtlVOS = null;
	
	public EsmAgt0041Event(){}

	public AgtRptItmInfoMstDtlVO getAgtRptItmInfoMstDtlVO() {
    	return agtRptItmInfoMstDtlVO;
    }

	public void setAgtRptItmInfoMstDtlVO(AgtRptItmInfoMstDtlVO agtRptItmInfoMstDtlVO) {
    	this.agtRptItmInfoMstDtlVO = agtRptItmInfoMstDtlVO;
    }

	public AgtRptItmInfoMstDtlVO[] getAgtRptItmInfoMstDtlVOS() {
    	return agtRptItmInfoMstDtlVOS;
    }

	public void setAgtRptItmInfoMstDtlVOS(AgtRptItmInfoMstDtlVO[] agtRptItmInfoMstDtlVOS) {
    	this.agtRptItmInfoMstDtlVOS = agtRptItmInfoMstDtlVOS;
    }
	
	

}
