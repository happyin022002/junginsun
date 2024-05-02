/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0103Event.java
*@FileTitle : Booking Status Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportInVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0103 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0103HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭 
 * @see ESM_BKG_0103HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EsmBkg0103Event extends EventSupport {

	/** Table Value Object 조회 조건 및 단건 처리  */
	private StatusReportInVO infoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private StatusReportInVO[] infoVOs = null;
	
	
	public StatusReportInVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(StatusReportInVO infoVO) {
		this.infoVO = infoVO;
	}

//	public StatusReportInVO[] getInfoVOs() {
//		return infoVOs;
//	}

//	public void setInfoVOs(StatusReportInVO[] infoVOs) {
//		this.infoVOs = infoVOs;
//	}

	public EsmBkg0103Event(){}
	
	private static final long serialVersionUID = 1L;
	
	//2015.03.01 Secure Coding 적용 [CWE-495]
	public StatusReportInVO[] getInfoVOs() {
		StatusReportInVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = new StatusReportInVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	//2015.03.01 Secure Coding 적용[CWE-496]
	public void setInfoVOs(StatusReportInVO[] infoVOs) {
		if (infoVOs != null) {
			StatusReportInVO[] tmpVOs = new StatusReportInVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.infoVOs = tmpVOs;
		}
	}
	
}