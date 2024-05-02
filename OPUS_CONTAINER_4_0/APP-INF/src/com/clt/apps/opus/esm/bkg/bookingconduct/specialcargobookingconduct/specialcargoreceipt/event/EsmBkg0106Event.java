/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0106Event.java
*@FileTitle : Break Bulk Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.09.23 이병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbAproInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbBkgInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbCgoApplVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbCntrListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgBbCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrTypzQtyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.clt.framework.support.layer.event.EventSupport;



/**
 * ESM_BKG_0106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0106HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byung Kyu 
 * @see ESM_BKG_0106HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0106Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BbCgoApplVO bbCgoApplVO = null;
	private BbBkgInfoVO bbBkgInfoVO = null;
	private BkgBbCgoVO bkgBbCgoVO = null;
	private BbAproInfoVO bbAproInfoVO = null;
	private BbCntrListVO bbCntrListVO = null;
	private CntrTypzQtyVO cntrTypzQtyVO = null;
	private BkgComboVO bkgcombovo = null;
	private SpclReqInVO spclReqInVO =  null;
	
	private String bkgNo = null;
	private String ovrVoidSltQty = null;
	private String rowCnt = null;
    private String blNo = null;
    private String evntUsrId = null;
    private String evntDt = null;  
	private String button =  null;
	private String bbChkFlg =  null;
	
  
	/** Table Value Object Multi Data 처리 */
	private BbCgoApplVO[] bbCgoApplVOs = null;
	private BbBkgInfoVO[] bbBkgInfoVOs = null;
	private BkgBbCgoVO[] bkgBbCgoVOs = null;
	private BbAproInfoVO[] bbAproInfoVOs = null;
	private BbCntrListVO[] bbCntrListVOs = null;
	private CntrTypzQtyVO[] cntrTypzQtyVOs = null;
	private BkgComboVO[] bkgcombovos = null;
	private SpclReqInVO[] spclReqInVOs =  null;

	
	public EsmBkg0106Event(){}

	/**
	 * @return the bbCgoApplVO
	 */
	public BbCgoApplVO getBbCgoApplVO() {
		return bbCgoApplVO;
	}

	/**
	 * @param bbCgoApplVO the bbCgoApplVO to set
	 */
	public void setBbCgoApplVO(BbCgoApplVO bbCgoApplVO) {
		this.bbCgoApplVO = bbCgoApplVO;
	}

	/**
	 * @return the bbBkgInfoVO
	 */
	public BbBkgInfoVO getBbBkgInfoVO() {
		return bbBkgInfoVO;
	}

	/**
	 * @param bbBkgInfoVO the bbBkgInfoVO to set
	 */
	public void setBbBkgInfoVO(BbBkgInfoVO bbBkgInfoVO) {
		this.bbBkgInfoVO = bbBkgInfoVO;
	}

	/**
	 * @return the bkgBbCgoVO
	 */
	public BkgBbCgoVO getBkgBbCgoVO() {
		return bkgBbCgoVO;
	}

	/**
	 * @param bkgBbCgoVO the bkgBbCgoVO to set
	 */
	public void setBkgBbCgoVO(BkgBbCgoVO bkgBbCgoVO) {
		this.bkgBbCgoVO = bkgBbCgoVO;
	}

	/**
	 * @return the bbAproInfoVO
	 */
	public BbAproInfoVO getBbAproInfoVO() {
		return bbAproInfoVO;
	}

	/**
	 * @param bbAproInfoVO the bbAproInfoVO to set
	 */
	public void setBbAproInfoVO(BbAproInfoVO bbAproInfoVO) {
		this.bbAproInfoVO = bbAproInfoVO;
	}

	/**
	 * @return the bbCntrListVO
	 */
	public BbCntrListVO getBbCntrListVO() {
		return bbCntrListVO;
	}

	/**
	 * @param bbCntrListVO the bbCntrListVO to set
	 */
	public void setBbCntrListVO(BbCntrListVO bbCntrListVO) {
		this.bbCntrListVO = bbCntrListVO;
	}

	/**
	 * @return the cntrTypzQtyVO
	 */
	public CntrTypzQtyVO getCntrTypzQtyVO() {
		return cntrTypzQtyVO;
	}

	/**
	 * @param cntrTypzQtyVO the cntrTypzQtyVO to set
	 */
	public void setCntrTypzQtyVO(CntrTypzQtyVO cntrTypzQtyVO) {
		this.cntrTypzQtyVO = cntrTypzQtyVO;
	}

	/**
	 * @return the bkgcombovo
	 */
	public BkgComboVO getBkgcombovo() {
		return bkgcombovo;
	}

	/**
	 * @param bkgcombovo the bkgcombovo to set
	 */
	public void setBkgcombovo(BkgComboVO bkgcombovo) {
		this.bkgcombovo = bkgcombovo;
	}

	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * @return the blNo
	 */
	public String getBlNo() {
		return blNo;
	}

	/**
	 * @param blNo the blNo to set
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * @return the evntUsrId
	 */
	public String getEvntUsrId() {
		return evntUsrId;
	}

	/**
	 * @param evntUsrId the evntUsrId to set
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}

	/**
	 * @return the evntDt
	 */
	public String getEvntDt() {
		return evntDt;
	}

	/**
	 * @param evntDt the evntDt to set
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}

	/**
	 * @return the bbCgoApplVOs
	 */
	public BbCgoApplVO[] getBbCgoApplVOs() {
		BbCgoApplVO[] rtnVOs = null;
		if (this.bbCgoApplVOs != null) {
			rtnVOs = Arrays.copyOf(bbCgoApplVOs, bbCgoApplVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param bbCgoApplVOs the bbCgoApplVOs to set
	 */
	public void setBbCgoApplVOs(BbCgoApplVO[] bbCgoApplVOs) {
		if(spclReqInVOs != null){
			SpclReqInVO[] tmpVOs = Arrays.copyOf(spclReqInVOs, spclReqInVOs.length);
			this.spclReqInVOs = tmpVOs;
		}
	}

	/**
	 * @return the bbBkgInfoVOs
	 */
	public BbBkgInfoVO[] getBbBkgInfoVOs() {
		BbBkgInfoVO[] rtnVOs = null;
		if (this.bbBkgInfoVOs != null) {
			rtnVOs = Arrays.copyOf(bbBkgInfoVOs, bbBkgInfoVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param bbBkgInfoVOs the bbBkgInfoVOs to set
	 */
	public void setBbBkgInfoVOs(BbBkgInfoVO[] bbBkgInfoVOs) {
		if(bbBkgInfoVOs != null){
			BbBkgInfoVO[] tmpVOs = Arrays.copyOf(bbBkgInfoVOs, bbBkgInfoVOs.length);
			this.bbBkgInfoVOs = tmpVOs;
		}
	}

	/**
	 * @return the bkgBbCgoVOs
	 */
	public BkgBbCgoVO[] getBkgBbCgoVOs() {
		BkgBbCgoVO[] rtnVOs = null;
		if (this.bkgBbCgoVOs != null) {
			rtnVOs = Arrays.copyOf(bkgBbCgoVOs, bkgBbCgoVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param bkgBbCgoVOs the bkgBbCgoVOs to set
	 */
	public void setBkgBbCgoVOs(BkgBbCgoVO[] bkgBbCgoVOs) {
		if(bkgBbCgoVOs != null){
			BkgBbCgoVO[] tmpVOs = Arrays.copyOf(bkgBbCgoVOs, bkgBbCgoVOs.length);
			this.bkgBbCgoVOs = tmpVOs;
		}
	}

	/**
	 * @return the bbAproInfoVOs
	 */
	public BbAproInfoVO[] getBbAproInfoVOs() {
		BbAproInfoVO[] rtnVOs = null;
		if (this.bbAproInfoVOs != null) {
			rtnVOs = Arrays.copyOf(bbAproInfoVOs, bbAproInfoVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param bbAproInfoVOs the bbAproInfoVOs to set
	 */
	public void setBbAproInfoVOs(BbAproInfoVO[] bbAproInfoVOs) {
		if(bbAproInfoVOs != null){
			BbAproInfoVO[] tmpVOs = Arrays.copyOf(bbAproInfoVOs, bbAproInfoVOs.length);
			this.bbAproInfoVOs = tmpVOs;
		}
	}

	/**
	 * @return the bbCntrListVOs
	 */
	public BbCntrListVO[] getBbCntrListVOs() {
		BbCntrListVO[] rtnVOs = null;
		if (this.bbCntrListVOs != null) {
			rtnVOs = Arrays.copyOf(bbCntrListVOs, bbCntrListVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param bbCntrListVOs the bbCntrListVOs to set
	 */
	public void setBbCntrListVOs(BbCntrListVO[] bbCntrListVOs) {
		if(bbCntrListVOs != null){
			BbCntrListVO[] tmpVOs = Arrays.copyOf(bbCntrListVOs, bbCntrListVOs.length);
			this.bbCntrListVOs = tmpVOs;
		}
	}

	/**
	 * @return the cntrTypzQtyVOs
	 */
	public CntrTypzQtyVO[] getCntrTypzQtyVOs() {
		CntrTypzQtyVO[] rtnVOs = null;
		if (this.cntrTypzQtyVOs != null) {
			rtnVOs = Arrays.copyOf(cntrTypzQtyVOs, cntrTypzQtyVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param cntrTypzQtyVOs the cntrTypzQtyVOs to set
	 */
	public void setCntrTypzQtyVOs(CntrTypzQtyVO[] cntrTypzQtyVOs) {
		if(cntrTypzQtyVOs != null){
			CntrTypzQtyVO[] tmpVOs = Arrays.copyOf(cntrTypzQtyVOs, cntrTypzQtyVOs.length);
			this.cntrTypzQtyVOs = tmpVOs;
		}
	}

	/**
	 * @return the bkgcombovos
	 */
	public BkgComboVO[] getBkgcombovos() {
		BkgComboVO[] rtnVOs = null;
		if (this.bkgcombovos != null) {
			rtnVOs = Arrays.copyOf(bkgcombovos, bkgcombovos.length);
		}
		return rtnVOs;
	}

	/**
	 * @param bkgcombovos the bkgcombovos to set
	 */
	public void setBkgcombovos(BkgComboVO[] bkgcombovos) {
		if(bkgcombovos != null){
			BkgComboVO[] tmpVOs = Arrays.copyOf(bkgcombovos, bkgcombovos.length);
			this.bkgcombovos = tmpVOs;
		}
	}

	/**
	 * @return the spclReqInVO
	 */
	public SpclReqInVO getSpclReqInVO() {
		return spclReqInVO;
	}

	/**
	 * @param spclReqInVO the spclReqInVO to set
	 */
	public void setSpclReqInVO(SpclReqInVO spclReqInVO) {
		this.spclReqInVO = spclReqInVO;
	}

	/**
	 * @return the spclReqInVOs
	 */
	public SpclReqInVO[] getSpclReqInVOs() {
		SpclReqInVO[] rtnVOs = null;
		if (this.spclReqInVOs != null) {
			rtnVOs = Arrays.copyOf(spclReqInVOs, spclReqInVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param spclReqInVOs the spclReqInVOs to set
	 */
	public void setSpclReqInVOs(SpclReqInVO[] spclReqInVOs) {
		if(spclReqInVOs != null){
			SpclReqInVO[] tmpVOs = Arrays.copyOf(spclReqInVOs, spclReqInVOs.length);
			this.spclReqInVOs = tmpVOs;
		}
	}

	/**
	 * @return the rowCnt
	 */
	public String getRowCnt() {
		return rowCnt;
	}

	/**
	 * @param rowCnt the rowCnt to set
	 */
	public void setRowCnt(String rowCnt) {
		this.rowCnt = rowCnt;
	}

	/**
	 * @return the ovrVoidSltQty
	 */
	public String getOvrVoidSltQty() {
		return ovrVoidSltQty;
	}

	/**
	 * @param ovrVoidSltQty the ovrVoidSltQty to set
	 */
	public void setOvrVoidSltQty(String ovrVoidSltQty) {
		this.ovrVoidSltQty = ovrVoidSltQty;
	}	
	
	/**
	 * @return the button
	 */
	public String getButton() {
		return button;
	}

	/**
	 * @param button the button to set
	 */
	public void setButton(String button) {
		this.button = button;
	}

	public String getBbChkFlg() {
		return bbChkFlg;
	}

	public void setBbChkFlg(String bbChkFlg) {
		this.bbChkFlg = bbChkFlg;
	}	

}