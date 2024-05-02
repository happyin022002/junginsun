/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0020Event.java
 *@FileTitle : Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0020HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0020Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	private CndCstmsReportCondVO cndCstmsReportCondVO = null;
	private CndCstmsReportVO cndCstmsReportVO = null;
	private CndCstmsReportVO[] cndCstmsReportVOs = null;

	public EsmBkg0020Event() {
	}

	public void setCndCstmsReportCondVO(CndCstmsReportCondVO cndCstmsReportCondVO) {
		this.cndCstmsReportCondVO = cndCstmsReportCondVO;
	}

	public void setCndCstmsReportVO(CndCstmsReportVO cndCstmsReportVO) {
		this.cndCstmsReportVO = cndCstmsReportVO;
	}

	public void setCndCstmsReportVOs(CndCstmsReportVO[] cndCstmsReportVOs) {
		this.cndCstmsReportVOs = cndCstmsReportVOs;
	}

	public CndCstmsReportCondVO getCndCstmsReportCondVO() {
		return cndCstmsReportCondVO;
	}

	public CndCstmsReportVO getCndCstmsReportVO() {
		return cndCstmsReportVO;
	}

	public CndCstmsReportVO[] getCndCstmsReportVOs() {
		return cndCstmsReportVOs;
	}
}