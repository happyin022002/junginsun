/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdTrs302302Event.java
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

import com.hanjin.apps.alps.esd.trs.report.pnlreport.vo.PnLBkgDtlListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_TRS_302302 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_302302HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs302302Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdTrs302302Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PnLBkgDtlListVO pnLBkgDtlListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PnLBkgDtlListVO[] pnLBkgDtlListVOs = null;

	public PnLBkgDtlListVO getPnLBkgDtlListVO() {
		return pnLBkgDtlListVO;
	}

	public void setPnLBkgDtlListVO(PnLBkgDtlListVO pnLBkgDtlListVO) {
		this.pnLBkgDtlListVO = pnLBkgDtlListVO;
	}

	public PnLBkgDtlListVO[] getPnLBkgDtlListVOs() {
		return pnLBkgDtlListVOs;
	}

	public void setPnLBkgDtlListVOs(PnLBkgDtlListVO[] pnLBkgDtlListVOs) {
		this.pnLBkgDtlListVOs = pnLBkgDtlListVOs;
	}
	
}
