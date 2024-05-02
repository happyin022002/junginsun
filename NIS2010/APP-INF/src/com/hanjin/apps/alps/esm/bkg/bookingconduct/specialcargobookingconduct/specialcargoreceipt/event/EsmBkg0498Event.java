/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0498Event.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrTypzQtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfAproInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0498 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0498HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byung Kyu
 * @see ESM_BKG_0498HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0498Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RfCgoApplVO rfCgoApplVO = null;
	private RfBkgInfoVO rfBkgInfoVO = null;
	private BkgRfCgoVO bkgRfCgoVO = null;
	private RfAproInfoVO rfAproInfoVO = null;
	private CntrTypzQtyVO cntrTypzQtyVO = null;
	private BkgComboVO bkgcombovo = null;
	private SpclReqInVO spclReqInVO =  null;
	
	
	private String bkgNo = null;
    private String blNo = null;
    private String evntUsrId = null;
    private String evntDt = null;
    private String cmdtCd = null;
    private String button = null;
    private String rfChkFlg = null;
  
	/** Table Value Object Multi Data 처리 */
	private RfCgoApplVO[] rfCgoApplVOs = null;
	private RfBkgInfoVO[] rfBkgInfoVOs = null;
	private BkgRfCgoVO[] bkgRfCgoVOs = null;
	private RfAproInfoVO[] rfAproInfoVOs = null;
	private CntrTypzQtyVO[] cntrTypzQtyVOs = null;
	private BkgComboVO[] bkgcombovos = null;
	private SpclReqInVO[] spclReqInVOs =  null;
	
	public EsmBkg0498Event(){}

	/**
	 * @return the rfCgoApplVO
	 */
	public RfCgoApplVO getRfCgoApplVO() {
		return rfCgoApplVO;
	}

	/**
	 * @param rfCgoApplVO the rfCgoApplVO to set
	 */
	public void setRfCgoApplVO(RfCgoApplVO rfCgoApplVO) {
		this.rfCgoApplVO = rfCgoApplVO;
	}

	/**
	 * @return the rfBkgInfoVO
	 */
	public RfBkgInfoVO getRfBkgInfoVO() {
		return rfBkgInfoVO;
	}

	/**
	 * @param rfBkgInfoVO the rfBkgInfoVO to set
	 */
	public void setRfBkgInfoVO(RfBkgInfoVO rfBkgInfoVO) {
		this.rfBkgInfoVO = rfBkgInfoVO;
	}

	/**
	 * @return the bkgRfCgoVO
	 */
	public BkgRfCgoVO getBkgRfCgoVO() {
		return bkgRfCgoVO;
	}

	/**
	 * @param bkgRfCgoVO the bkgRfCgoVO to set
	 */
	public void setBkgRfCgoVO(BkgRfCgoVO bkgRfCgoVO) {
		this.bkgRfCgoVO = bkgRfCgoVO;
	}

	/**
	 * @return the rfAproInfoVO
	 */
	public RfAproInfoVO getRfAproInfoVO() {
		return rfAproInfoVO;
	}

	/**
	 * @param rfAproInfoVO the rfAproInfoVO to set
	 */
	public void setRfAproInfoVO(RfAproInfoVO rfAproInfoVO) {
		this.rfAproInfoVO = rfAproInfoVO;
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
	 * @return the rfCgoApplVOs
	 */
	public RfCgoApplVO[] getRfCgoApplVOs() {
		return rfCgoApplVOs;
	}

	/**
	 * @param rfCgoApplVOs the rfCgoApplVOs to set
	 */
	public void setRfCgoApplVOs(RfCgoApplVO[] rfCgoApplVOs) {
		this.rfCgoApplVOs = rfCgoApplVOs;
	}

	/**
	 * @return the rfBkgInfoVOs
	 */
	public RfBkgInfoVO[] getRfBkgInfoVOs() {
		return rfBkgInfoVOs;
	}

	/**
	 * @param rfBkgInfoVOs the rfBkgInfoVOs to set
	 */
	public void setRfBkgInfoVOs(RfBkgInfoVO[] rfBkgInfoVOs) {
		this.rfBkgInfoVOs = rfBkgInfoVOs;
	}

	/**
	 * @return the bkgRfCgoVOs
	 */
	public BkgRfCgoVO[] getBkgRfCgoVOs() {
		return bkgRfCgoVOs;
	}

	/**
	 * @param bkgRfCgoVOs the bkgRfCgoVOs to set
	 */
	public void setBkgRfCgoVOs(BkgRfCgoVO[] bkgRfCgoVOs) {
		this.bkgRfCgoVOs = bkgRfCgoVOs;
	}

	/**
	 * @return the rfAproInfoVOs
	 */
	public RfAproInfoVO[] getRfAproInfoVOs() {
		return rfAproInfoVOs;
	}

	/**
	 * @param rfAproInfoVOs the rfAproInfoVOs to set
	 */
	public void setRfAproInfoVOs(RfAproInfoVO[] rfAproInfoVOs) {
		this.rfAproInfoVOs = rfAproInfoVOs;
	}

	/**
	 * @return the cntrTypzQtyVOs
	 */
	public CntrTypzQtyVO[] getCntrTypzQtyVOs() {
		return cntrTypzQtyVOs;
	}

	/**
	 * @param cntrTypzQtyVOs the cntrTypzQtyVOs to set
	 */
	public void setCntrTypzQtyVOs(CntrTypzQtyVO[] cntrTypzQtyVOs) {
		this.cntrTypzQtyVOs = cntrTypzQtyVOs;
	}

	/**
	 * @return the bkgcombovos
	 */
	public BkgComboVO[] getBkgcombovos() {
		return bkgcombovos;
	}

	/**
	 * @param bkgcombovos the bkgcombovos to set
	 */
	public void setBkgcombovos(BkgComboVO[] bkgcombovos) {
		this.bkgcombovos = bkgcombovos;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
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
		return spclReqInVOs;
	}

	/**
	 * @param spclReqInVOs the spclReqInVOs to set
	 */
	public void setSpclReqInVOs(SpclReqInVO[] spclReqInVOs) {
		this.spclReqInVOs = spclReqInVOs;
	}

	
	/**
	 * @return the cmdtCd
	 */
	public String getCmdtCd() {
		return cmdtCd;
	}

	/**
	 * @param cmdtCd the cmdtCd to set
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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

	public String getRfChkFlg() {
		return rfChkFlg;
	}

	public void setRfChkFlg(String rfChkFlg) {
		this.rfChkFlg = rfChkFlg;
	}

}