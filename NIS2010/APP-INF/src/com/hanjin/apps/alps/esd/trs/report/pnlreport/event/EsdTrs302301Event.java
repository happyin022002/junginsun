/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdTrs302301Event.java
*@FileTitle : Profit & Loss Report for Europe Inland BIZ
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.07.17 변종건 [CHM-201217633] Profit & Loss Report for Europe Inland BIZ 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.pnlreport.event;

import com.hanjin.apps.alps.esd.trs.report.pnlreport.vo.PnLRptOptionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_302301 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_302301HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs302301Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdTrs302301Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PnLRptOptionVO pnLRptOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PnLRptOptionVO[] pnLRptOptionVOs = null;

	public PnLRptOptionVO getPnLRptOptionVO() {
		return pnLRptOptionVO;
	}

	public void setPnLRptOptionVO(PnLRptOptionVO pnLRptOptionVO) {
		this.pnLRptOptionVO = pnLRptOptionVO;
	}

	public PnLRptOptionVO[] getPnLRptOptionVOs() {
		return pnLRptOptionVOs;
	}

	public void setPnLRptOptionVOs(PnLRptOptionVO[] pnLRptOptionVOs) {
		this.pnLRptOptionVOs = pnLRptOptionVOs;
	}
	
}
