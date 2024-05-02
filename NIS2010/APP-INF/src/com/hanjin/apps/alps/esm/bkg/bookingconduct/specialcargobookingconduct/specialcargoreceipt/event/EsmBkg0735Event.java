/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0735Event.java
*@FileTitle : Awakward Cargo Application
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.10 이병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkDimVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrTypzQtyVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0735 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0735HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Byung Kyu
 * @see ESM_BKG_0735HTMLAction에서 참조
 * @since J2EE 1.6
 */

public class EsmBkg0735Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AwkCgoApplVO awkCgoApplVO = null;
	private BkgAwkCgoVO bkgAwkCgoVO = null;
	private CntrTypzQtyVO cntrTypzQtyVO = null;
	private BkgComboVO bkgcombovo = null;
	private BkgAwkDimVO bkgAwkDimVO = null;
	private String bkgNo = null;
    private String blNo = null;
    private String evntUsrId = null;
    private String evntDt = null;
    private String awkCgoSeq = null;
    private String pckTpCd = null;

	/** Table Value Object Multi Data 처리 */
	private AwkCgoApplVO[] awkCgoApplVOs = null;
	private BkgAwkCgoVO[] bkgAwkCgoVOs = null;
	private CntrTypzQtyVO[] cntrTypzQtyVOs = null;
	private BkgComboVO[] bkgcombovos = null;
	private BkgAwkDimVO[] bkgAwkDimVOs = null;



	public EsmBkg0735Event(){}

	/**
	 * @param awkCgoApplVO the awkCgoApplVO to set
	 */
	public void setAwkCgoApplVO(AwkCgoApplVO awkCgoApplVO){
		this. awkCgoApplVO = awkCgoApplVO;
	}

	/**
	 * @param awkCgoApplVOs the awkCgoApplVOs to set
	 */
	public void setAwkCgoApplVOs(AwkCgoApplVO[] awkCgoApplVOs){
		this. awkCgoApplVOs = awkCgoApplVOs;
	}

	/**
	 * @return the awkCgoApplVO
	 */
	public AwkCgoApplVO getAwkCgoApplVO(){
		return awkCgoApplVO;
	}

	/**
	 * @return the awkCgoApplVOs
	 */
	public AwkCgoApplVO[] getAwkCgoApplVOs(){
		return awkCgoApplVOs;
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
	 * @return the bkgAwkCgoVO
	 */
	public BkgAwkCgoVO getBkgAwkCgoVO() {
		return bkgAwkCgoVO;
	}

	/**
	 * @param bkgAwkCgoVO the bkgAwkCgoVO to set
	 */
	public void setBkgAwkCgoVO(BkgAwkCgoVO bkgAwkCgoVO) {
		this.bkgAwkCgoVO = bkgAwkCgoVO;
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
	 * @return the bkgAwkCgoVOs
	 */
	public BkgAwkCgoVO[] getBkgAwkCgoVOs() {
		return bkgAwkCgoVOs;
	}

	/**
	 * @param bkgAwkCgoVOs the bkgAwkCgoVOs to set
	 */
	public void setBkgAwkCgoVOs(BkgAwkCgoVO[] bkgAwkCgoVOs) {
		this.bkgAwkCgoVOs = bkgAwkCgoVOs;
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
	 * @return the bkgAwkDimVO
	 */
	public BkgAwkDimVO getBkgAwkDimVO() {
		return bkgAwkDimVO;
	}

	/**
	 * @param bkgAwkDimVO the bkgAwkDimVO to set
	 */
	public void setBkgAwkDimVO(BkgAwkDimVO bkgAwkDimVO) {
		this.bkgAwkDimVO = bkgAwkDimVO;
	}

	/**
	 * @return the bkgAwkDimVOs
	 */
	public BkgAwkDimVO[] getBkgAwkDimVOs() {
		return bkgAwkDimVOs;
	}

	/**
	 * @param bkgAwkDimVOs the bkgAwkDimVOs to set
	 */
	public void setBkgAwkDimVOs(BkgAwkDimVO[] bkgAwkDimVOs) {
		this.bkgAwkDimVOs = bkgAwkDimVOs;
	}

	/**
	 * @return the awkCgoSeq
	 */
	public String getAwkCgoSeq() {
		return awkCgoSeq;
	}

	/**
	 * @param awkCgoSeq the awkCgoSeq to set
	 */
	public void setAwkCgoSeq(String awkCgoSeq) {
		this.awkCgoSeq = awkCgoSeq;
	}

	/**
	 * @return the pckTpCd
	 */
	public String getPckTpCd() {
		return pckTpCd;
	}

	/**
	 * @param pckTpCd the pckTpCd to set
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}




}