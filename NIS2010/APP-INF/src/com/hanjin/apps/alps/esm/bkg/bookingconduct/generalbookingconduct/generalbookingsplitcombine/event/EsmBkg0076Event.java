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
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForCombineVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByBkgInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByRouteInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineCommonInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;

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
		return combineByBkgInputVOs;
	}

	public void setCombineByBkgInputVOs(CombineByBkgInputVO[] combineByBkgInputVOs) {
		this.combineByBkgInputVOs = combineByBkgInputVOs;
	}

	public CombineByRouteInputVO[] getCombineByRouteInputVOs() {
		return combineByRouteInputVOs;
	}

	public void setCombineByRouteInputVOs(
			CombineByRouteInputVO[] combineByRouteInputVOs) {
		this.combineByRouteInputVOs = combineByRouteInputVOs;
	}

	public BkgBlNoVO[] getBkgBlNoVOs() {
		return bkgBlNoVOs;
	}

	public void setBkgBlNoVOs(BkgBlNoVO[] bkgBlNoVOs) {
		this.bkgBlNoVOs = bkgBlNoVOs;
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
		return bkgListForCombineVOs;
	}

	public void setBkgListForCombineVOs(BkgListForCombineVO[] bkgListForCombineVOs) {
		this.bkgListForCombineVOs = bkgListForCombineVOs;
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
}