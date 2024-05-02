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
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.StatusReportInVO;
import com.clt.framework.support.layer.event.EventSupport;


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

	public StatusReportInVO[] getInfoVOs() {
		StatusReportInVO[] rtnVOs = null;
		if(this.infoVOs != null){
			rtnVOs= Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}

	public void setInfoVOs(StatusReportInVO[] infoVOs) {
		if(infoVOs != null){
			StatusReportInVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}

	public EsmBkg0103Event(){}
	
	private static final long serialVersionUID = 1L;
	
	
}