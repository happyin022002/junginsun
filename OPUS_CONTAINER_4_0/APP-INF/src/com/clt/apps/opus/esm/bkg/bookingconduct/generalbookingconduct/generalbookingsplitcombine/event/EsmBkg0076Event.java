/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0076Event.java
*@FileTitle : Booking Combine
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.25 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForCombineVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByBkgInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByRouteInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineCommonInputVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0076 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0076HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0076HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0076Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CombineCommonInputVO combineCommonInputVO = null;
	private CombineByBkgInputVO combineByBkgInputVO = null;
	private CombineByRouteInputVO combineByRouteInputVO = null;
	private String mstBkgNo = null;
	private String hitchmentYn = null;

	/** Table Value Object Multi Data 처리 */
	private CombineByBkgInputVO[] combineByBkgInputVOs = null;
	private CombineByRouteInputVO[] combineByRouteInputVOs = null;
	private BkgListForCombineVO[] bkgListForCombineVOs = null;
	private BkgBlNoVO[] bkgBlNoVOs = null;
	private String caRsnCd = null;
	private String caRmk = null;
	private String message = null;
	
	public EsmBkg0076Event(){}

	public CombineCommonInputVO getCombineCommonInputVO() {
		return combineCommonInputVO;
	}

	public void setCombineCommonInputVO(CombineCommonInputVO combineCommonInputVO) {
		this.combineCommonInputVO = combineCommonInputVO;
	}

	public CombineByBkgInputVO getCombineByBkgInputVO() {
		return combineByBkgInputVO;
	}

	public void setCombineByBkgInputVO(CombineByBkgInputVO combineByBkgInputVO) {
		this.combineByBkgInputVO = combineByBkgInputVO;
	}

	public CombineByRouteInputVO getCombineByRouteInputVO() {
		return combineByRouteInputVO;
	}

	public void setCombineByRouteInputVO(CombineByRouteInputVO combineByRouteInputVO) {
		this.combineByRouteInputVO = combineByRouteInputVO;
	}

	public CombineByBkgInputVO[] getCombineByBkgInputVOs() {
		CombineByBkgInputVO[] tmpVOs = null;
		if (this. combineByBkgInputVOs != null) {
			tmpVOs = Arrays.copyOf(combineByBkgInputVOs, combineByBkgInputVOs .length);
		}
		return tmpVOs;
	}

	public void setCombineByBkgInputVOs(CombineByBkgInputVO[] combineByBkgInputVOs) {
		if (combineByBkgInputVOs != null) {
			CombineByBkgInputVO[] tmpVOs = Arrays.copyOf(combineByBkgInputVOs, combineByBkgInputVOs .length);
			this. combineByBkgInputVOs = tmpVOs;
		}
	}

	public CombineByRouteInputVO[] getCombineByRouteInputVOs() {
		CombineByRouteInputVO[] tmpVOs = null;
		if (this. combineByRouteInputVOs != null) {
			tmpVOs = Arrays.copyOf(combineByRouteInputVOs, combineByRouteInputVOs .length);
		}
		return tmpVOs;
	}

	public void setCombineByRouteInputVOs(CombineByRouteInputVO[] combineByRouteInputVOs) {		
		if (combineByRouteInputVOs != null) {
			CombineByRouteInputVO[] tmpVOs = Arrays.copyOf(combineByRouteInputVOs, combineByRouteInputVOs .length);
			this. combineByRouteInputVOs = tmpVOs;
		}
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

	public BkgListForCombineVO[] getBkgListForCombineVOs() {
		BkgListForCombineVO[] tmpVOs = null;
		if (this. bkgListForCombineVOs != null) {
			tmpVOs = Arrays.copyOf(bkgListForCombineVOs, bkgListForCombineVOs .length);
		}
		return tmpVOs;
	}

	public void setBkgListForCombineVOs(BkgListForCombineVO[] bkgListForCombineVOs) {
		if (bkgListForCombineVOs != null) {
			BkgListForCombineVO[] tmpVOs = Arrays.copyOf(bkgListForCombineVOs, bkgListForCombineVOs .length);
			this. bkgListForCombineVOs = tmpVOs;
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