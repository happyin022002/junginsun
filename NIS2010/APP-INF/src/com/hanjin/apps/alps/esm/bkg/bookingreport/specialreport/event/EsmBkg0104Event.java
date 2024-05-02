/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0104Event.java
*@FileTitle : Report Template
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.28 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.event;

import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.ReportTemplateListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Gyoung Sub
 * @see ESM_BKG_0104HTMLAction 참조
 * @since J2EE 1.6 
 */
 
public class EsmBkg0104Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ReportTemplateListVO infoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ReportTemplateListVO[] infoVOs = null;
	
	/** Table Value Object 조회 조건  */
	private String usrId 			= null;
	private String rptId 			= null;
	private String bkgRptKndCd 		= null;
	private String ofcCd 		    = null;
	private String ofcGubun         = null;

	public String getOfcGubun() {
		return ofcGubun;
	}

	public void setOfcGubun(String ofcGubun) {
		this.ofcGubun = ofcGubun;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public EsmBkg0104Event(){}

	public ReportTemplateListVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(ReportTemplateListVO infoVO) {
		this.infoVO = infoVO;
	}

	public ReportTemplateListVO[] getInfoVOs() {
		ReportTemplateListVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = new ReportTemplateListVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setInfoVOs(ReportTemplateListVO[] infoVOs){
		if(infoVOs != null){
			ReportTemplateListVO[] tmpVOs = new ReportTemplateListVO[infoVOs.length];
			System.arraycopy(infoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.infoVOs = tmpVOs;
		}
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getRptId() {
		return rptId;
	}

	public void setRptId(String rptId) {
		this.rptId = rptId;
	}

	public String getBkgRptKndCd() {
		return bkgRptKndCd;
	}

	public void setBkgRptKndCd(String bkgRptKndCd) {
		this.bkgRptKndCd = bkgRptKndCd;
	}
	
	


}