/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1701Event.java
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

import com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo.ReportTemplateListVO;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.CmBkgRptVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1704 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1704HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SJH.20150202.ADD 
 * @see ESM_BKG_1704HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg1704Event extends EventSupport {
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CmBkgRptVO infoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CmBkgRptVO[] infoVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReportTemplateListVO rinfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ReportTemplateListVO[] rinfoVOs = null;		
	
	
	public CmBkgRptVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(CmBkgRptVO infoVO) {
		this.infoVO = infoVO;
	}

	
	public ReportTemplateListVO getrInfoVO() {
		return rinfoVO;
	}

	public void setrInfoVO(ReportTemplateListVO rinfoVO) {		
		this.rinfoVO = rinfoVO;
	}

	public CmBkgRptVO[] getInfoVOs() {
		CmBkgRptVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}

	public void setInfoVOs(CmBkgRptVO[] infoVOs) {
		if (infoVOs != null) {
			CmBkgRptVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}

	public ReportTemplateListVO[] getRinfoVOs() {
		ReportTemplateListVO[] rtnVOs = null;
		if (this.rinfoVOs != null) {
			rtnVOs = Arrays.copyOf(rinfoVOs, rinfoVOs.length);
		}
		return rtnVOs;
	}

	public void setRinfoVOs(ReportTemplateListVO[] rinfoVOs) {
		if (rinfoVOs != null) {
			ReportTemplateListVO[] tmpVOs = Arrays.copyOf(rinfoVOs, rinfoVOs.length);
			this.rinfoVOs = tmpVOs;
		}
	}

	public EsmBkg1704Event(){}
	
	private static final long serialVersionUID = 1L;
	
	
}