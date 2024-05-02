/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0401Event.java
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

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0401 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0401HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kim Min Jeong
 * @see ESM_BKG_0401HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0401Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	private BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = null;
	private BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs = null;

	public EsmBkg0401Event() {
	}

	public void setBkgHrdCdgCtntListCondVO(BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO) {
		this.bkgHrdCdgCtntListCondVO = bkgHrdCdgCtntListCondVO;
	}

	public BkgHrdCdgCtntListCondVO getBkgHrdCdgCtntListCondVO() {
		return bkgHrdCdgCtntListCondVO;
	}

	public void setBkgHrdCdgCtntVOs(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs) {
		if (bkgHrdCdgCtntVOs != null)
			this.bkgHrdCdgCtntVOs = Arrays.copyOf(bkgHrdCdgCtntVOs, bkgHrdCdgCtntVOs.length);
	}

	public BkgHrdCdgCtntVO[] getBkgHrdCdgCtntVOs() {
		BkgHrdCdgCtntVO[] rtnVOs = null;
		if (bkgHrdCdgCtntVOs != null)
			rtnVOs = Arrays.copyOf(bkgHrdCdgCtntVOs, bkgHrdCdgCtntVOs.length);
		return rtnVOs;
	}
}