/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 		: EesCgm1156Event.java
*@FileTitle 	: Performance by S/C No
*Open Issues 	: 
*Change history :
*@LastModifyDate: 2014.03.03
*@LastModifier 	: 신용찬
*@LastVersion 	: 1.0
* 2014.03.03 신용찬
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSSCNOReportINVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ees_cgm_1156 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_cgm_1156HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 신용찬
 * @see EES_CGM_1156HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesCgm1156Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CHSSCNOReportINVO chsSCNOReportINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CHSSCNOReportINVO[] chsSCNOReportINVOS = null;

	public EesCgm1156Event(){}

	public CHSSCNOReportINVO getChsSCNOReportINVO() {
		return chsSCNOReportINVO;
	}

	public void setChsSCNOReportINVO(
			CHSSCNOReportINVO chsSCNOReportINVO) {
		this.chsSCNOReportINVO = chsSCNOReportINVO;
	}

	public CHSSCNOReportINVO[] getChsSCNOReportINVOS() {
		return chsSCNOReportINVOS;
	}

	public void setChsSCNOReportINVOS(
			CHSSCNOReportINVO[] chsSCNOReportINVOS) {
		this.chsSCNOReportINVOS = chsSCNOReportINVOS;
	}
	
	
}