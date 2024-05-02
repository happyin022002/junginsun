/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0013Event.java
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.05.20 손윤석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event;

import java.util.Arrays;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgCstmsKrDlHisVO;


/**
 * ESM_BKG_0215 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0215HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author charves
 * @see ESM_BKG_0215HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0215Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private BkgCstmsKrDlHisVO[] customsReportVOs = null;
	private BkgCstmsKrDlHisVO customsReportVO = null;

	public EsmBkg0215Event() {}

	public void setCstmsVvdInfoVOs(BkgCstmsKrDlHisVO[] cstmsVvdInfoVOs) {
		if (cstmsVvdInfoVOs != null) {
			BkgCstmsKrDlHisVO[] tmpVOs = Arrays.copyOf(cstmsVvdInfoVOs, cstmsVvdInfoVOs.length);
			this.customsReportVOs = tmpVOs;
		}
	}

	public void setCstmsVvdInfoVO(BkgCstmsKrDlHisVO cstmsVvdInfoVOs) {
		this. customsReportVO = cstmsVvdInfoVOs;
	}

	public BkgCstmsKrDlHisVO[] getCstmsVvdInfoVOS() {
		BkgCstmsKrDlHisVO[] rtnVOs = null;
		if (this.customsReportVOs != null) {
			rtnVOs = Arrays.copyOf(customsReportVOs, customsReportVOs.length);
		}
		return rtnVOs;
	}

	public BkgCstmsKrDlHisVO getCstmsVvdInfoVO() {
		return customsReportVO;
	}
}