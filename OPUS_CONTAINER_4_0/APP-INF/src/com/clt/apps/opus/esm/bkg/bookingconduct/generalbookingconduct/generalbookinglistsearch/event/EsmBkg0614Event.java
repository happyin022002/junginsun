/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0614Event.java
*@FileTitle : Work With Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.20 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForWorkWithBkgInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForWorkWithBkgVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0614 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0614HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0614HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0614Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputVO = null;
	private String mstBkgNo = null;
	private String hitchmentYn = null;
	private BkgBlNoVO[] bkgBlNoVOs = null;
	private BkgListForWorkWithBkgVO[] bkgListForWorkWithBkgVOs = null;
	private String caRsnCd = null;
	private String caRmk = null;
	private String message = null;
	
	public EsmBkg0614Event(){}

	public BkgListForWorkWithBkgInputVO getBkgListForWorkWithBkgInputVO() {
		return bkgListForWorkWithBkgInputVO;
	}

	public void setBkgListForWorkWithBkgInputVO(
			BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputVO) {
		this.bkgListForWorkWithBkgInputVO = bkgListForWorkWithBkgInputVO;
	}

	public String getMstBkgNo() {
		return mstBkgNo;
	}

	public void setMstBkgNo(String mstBkgNo) {
		this.mstBkgNo = mstBkgNo;
	}

	public String getHitchmentYn() {
		return hitchmentYn;
	}

	public void setHitchmentYn(String hitchmentYn) {
		this.hitchmentYn = hitchmentYn;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		BkgBlNoVO[] tmpVOs = null;
		if (this. bkgBlNoVOs != null) {
			tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		if (bkgBlNoVOs != null) {
			BkgBlNoVO[] tmpVOs = Arrays.copyOf(bkgBlNoVOs, bkgBlNoVOs .length);
			this. bkgBlNoVOs = tmpVOs;
		}
	}

	public BkgListForWorkWithBkgVO[] getBkgListForWorkWithBkgVOs() {
		BkgListForWorkWithBkgVO[] tmpVOs = null;
		if (this. bkgListForWorkWithBkgVOs != null) {
			tmpVOs = Arrays.copyOf(bkgListForWorkWithBkgVOs, bkgListForWorkWithBkgVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgListForWorkWithBkgVOs(BkgListForWorkWithBkgVO[] bkgListForWorkWithBkgVOs) {
		if (bkgListForWorkWithBkgVOs != null) {
			BkgListForWorkWithBkgVO[] tmpVOs = Arrays.copyOf(bkgListForWorkWithBkgVOs, bkgListForWorkWithBkgVOs .length);
			this. bkgListForWorkWithBkgVOs = tmpVOs;
		}
	}

	public String getCaRsnCd() {
		return caRsnCd;
	}

	public void setCaRsnCd(String caRsnCd) {
		this.caRsnCd = caRsnCd;
	}

	public String getCaRmk() {
		return caRmk;
	}

	public void setCaRmk(String caRmk) {
		this.caRmk = caRmk;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}