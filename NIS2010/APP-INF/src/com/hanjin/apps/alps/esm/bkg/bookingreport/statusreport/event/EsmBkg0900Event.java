/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg0369Event.java
*@FileTitle : B/L Rider
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.16 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.event.ESM_BKG_0742HTMLAction;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.AttachFileInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.AttachFileOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.WarningReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.WarningReportOutVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_BKG_0742 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG_0742HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Jin Seo
 * @see ESM_BKG_0742HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0900Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmBkg0900Event(){}

	/** Table Value Object 조회 조건 및 단건 처리  입력VO   */
	private WarningReportInVO warningReportInVO = null;

	/** Table Value Object 조회 조건 및 단건 처리  출력VO   */
	private WarningReportOutVO warningReportOutVO = null;

	/**
	 * @return the warningReportInVO
	 */
	public WarningReportInVO getWarningReportInVO() {
		return warningReportInVO;
	}
	/**
	 * @param warningReportInVO the warningReportInVO to set
	 */
	public void setWarningReportInVO(WarningReportInVO warningReportInVO) {
		this.warningReportInVO = warningReportInVO;
	}
	
	/**
	 * @return the warningReportInVO
	 */
	public WarningReportOutVO getWarningReportOutVO() {
		return warningReportOutVO;
	}
	/**
	 * @param warningReportInVO the warningReportInVO to set
	 */
	public void setWarningReportOutVO(WarningReportOutVO warningReportOutVO) {
		this.warningReportOutVO = warningReportOutVO;
	}


}