/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0226Event.java
*@FileTitle : e-BKG And S/I Upload Status Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.07.20 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.EBkgSiUploadStsReportInVO;


/**
 * ESM_BKG_0226 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0226HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0226HTMLAction 참조
 * @since J2EE 1.6 
 */

public class EsmBkg0226Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EBkgSiUploadStsReportInVO eBkgSiUploadStsReportInVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private EBkgSiUploadStsReportInVO[] eBkgSiUploadStsReportInVOs = null;

	public EsmBkg0226Event(){}
	
	public void setEBkgSiUploadStsReportInVO(EBkgSiUploadStsReportInVO eBkgSiUploadStsReportInVO){
		this. eBkgSiUploadStsReportInVO = eBkgSiUploadStsReportInVO;
	}

	public void setEBkgSiUploadStsReportInVOS(EBkgSiUploadStsReportInVO[] eBkgSiUploadStsReportInVOs){
		if(eBkgSiUploadStsReportInVOs != null){
			EBkgSiUploadStsReportInVO[] tmpVOs = new EBkgSiUploadStsReportInVO[eBkgSiUploadStsReportInVOs.length];
			System.arraycopy(eBkgSiUploadStsReportInVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eBkgSiUploadStsReportInVOs = tmpVOs;
		}
	}

	public EBkgSiUploadStsReportInVO getEBkgSiUploadStsReportInVO(){
		return eBkgSiUploadStsReportInVO;
	}

	public EBkgSiUploadStsReportInVO[] getEBkgSiUploadStsReportInVOS(){
		EBkgSiUploadStsReportInVO[] rtnVOs = null;
		if (this.eBkgSiUploadStsReportInVOs != null) {
			rtnVOs = new EBkgSiUploadStsReportInVO[eBkgSiUploadStsReportInVOs.length];
			System.arraycopy(eBkgSiUploadStsReportInVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}