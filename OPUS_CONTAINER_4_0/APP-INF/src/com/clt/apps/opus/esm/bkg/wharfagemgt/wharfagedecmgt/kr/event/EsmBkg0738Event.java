/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmBkg0738Event.java
 *@FileTitle : EsmBkg0738Event
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.21
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.07.21 정재엽
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;


/**
 * ESM_BKG_0738 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_0738HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jae yoeb jeong
 * @see ESM_BKG_0738HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0738Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** 조회조건 */
	private BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO  = null;

	/** 입력,삭제 */
	private BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs = null;

	public BkgHrdCdgCtntListCondVO getBkgHrdCdgCtntListCondVO() {
		return bkgHrdCdgCtntListCondVO;
	}

	public void setBkgHrdCdgCtntListCondVO(BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO) {
		this.bkgHrdCdgCtntListCondVO = bkgHrdCdgCtntListCondVO;
	}

	public BkgHrdCdgCtntVO[] getBkgHrdCdgCtntVOs() {
		BkgHrdCdgCtntVO[] rtnVOs = null;
		if (this.bkgHrdCdgCtntVOs != null) {
			rtnVOs = Arrays.copyOf(bkgHrdCdgCtntVOs, bkgHrdCdgCtntVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgHrdCdgCtntVOs(BkgHrdCdgCtntVO[] bkgHrdCdgCtntVOs) {
		if (bkgHrdCdgCtntVOs != null) {
			BkgHrdCdgCtntVO[] tmpVOs = Arrays.copyOf(bkgHrdCdgCtntVOs, bkgHrdCdgCtntVOs.length);
			this.bkgHrdCdgCtntVOs = tmpVOs;
		}
	}

}