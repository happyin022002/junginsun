/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0056Event.java
*@FileTitle : SDMS Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.01 이선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsReportVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_0056 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0056HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Sunyoung
 * @see VOP_OPF_0056HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0056Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SdmsReportVO sdmsReportVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SdmsReportVO[] sdmsReportVOs = null;
	

	public VopOpf0056Event(){}
	
	public void setSdmsReportVO(SdmsReportVO sdmsReportVO){
		this. sdmsReportVO = sdmsReportVO;
	}

	public void setSdmsReportVOS(SdmsReportVO[] sdmsReportVOs){
		if (sdmsReportVOs != null) {
			SdmsReportVO[] tmpVOs = Arrays.copyOf(sdmsReportVOs, sdmsReportVOs.length);
			this.sdmsReportVOs = tmpVOs;
		} // end if
	}
	
	public SdmsReportVO getSdmsReportVO(){
		return sdmsReportVO;
	}

	public SdmsReportVO[] getSdmsReportVOS(){
		SdmsReportVO[] rtnVOs = null;
		if (this.sdmsReportVOs != null) {
			rtnVOs = Arrays.copyOf(this.sdmsReportVOs, this.sdmsReportVOs.length);
		} // end if
		return rtnVOs;
	}

}