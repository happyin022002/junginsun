/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0025Event.java
 *@FileTitle : ManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.29
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.AvcNoteSetUpInfoVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0025HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0025Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	private CndCstmsReportCondVO cndCstmsReportCondVO = null;
	private CndCstmsReportVO cndCstmsReportVO = null;
	private CndCstmsReportVO[] cndCstmsReportVOs = null;
	private AvcNoteSetUpInfoVO[] avcNoteSetUpInfoVOs = null;

	public EsmBkg0025Event() {
	}

	public void setCndCstmsReportCondVO(CndCstmsReportCondVO cndCstmsReportCondVO) {
		this.cndCstmsReportCondVO = cndCstmsReportCondVO;
	}

	public void setCndCstmsReportVO(CndCstmsReportVO cndCstmsReportVO) {
		this.cndCstmsReportVO = cndCstmsReportVO;
	}

	public void setCndCstmsReportVOs(CndCstmsReportVO[] cndCstmsReportVOs) {
		if (cndCstmsReportVOs != null)
			this.cndCstmsReportVOs = Arrays.copyOf(cndCstmsReportVOs, cndCstmsReportVOs.length);
	}

	public void setAvcNoteSetUpInfoVOs(AvcNoteSetUpInfoVO[] avcNoteSetUpInfoVOs) {
		if (avcNoteSetUpInfoVOs != null)
			this.avcNoteSetUpInfoVOs = Arrays.copyOf(avcNoteSetUpInfoVOs, avcNoteSetUpInfoVOs.length);
	}

	public CndCstmsReportCondVO getCndCstmsReportCondVO() {
		return cndCstmsReportCondVO;
	}

	public CndCstmsReportVO getCndCstmsReportVO() {
		return cndCstmsReportVO;
	}

	public CndCstmsReportVO[] getCndCstmsReportVOs() {
		CndCstmsReportVO[] rtnVOs = null;
		if (cndCstmsReportVOs != null)
			rtnVOs = Arrays.copyOf(cndCstmsReportVOs, cndCstmsReportVOs.length);
		return rtnVOs;
	}

	public AvcNoteSetUpInfoVO[] getAvcNoteSetUpInfoVOs() {
		AvcNoteSetUpInfoVO[] rtnVOs = null;
		if (avcNoteSetUpInfoVOs != null)
			rtnVOs = Arrays.copyOf(avcNoteSetUpInfoVOs, avcNoteSetUpInfoVOs.length);
		return rtnVOs;
	}
}