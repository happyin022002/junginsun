/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg022901Event.java
*@FileTitle : e-Booking & SI Process Top
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.15 전용진
* 1.0 Creation
* -------------------------------------------------------
* HISTORY
* 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0229_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0229_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0229HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0229Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private XterRqstNoVO xterRqstNoVO = null;
	
	/** 전체 탭을 저장하기 위해 추가적으로 사용되는 VO */
	private BkgBlNoVO bkgBlNoVO = null;
	
	/** 저장용 탭 플래그 */
	private String saveBkgFlag = null;
	private String saveCustFlag = null;
	private String saveCntrFlag = null;
	private String saveMndFlag = null;
	private String saveCmFlag = null;
	private String saveTroFlag = null;
	private String saveRfFlag = null;
	private String saveDgFlag = null;
	private String saveAkFlag = null;
	private String saveHblFlag = null;
	private String saveHbl2Flag = null;
	private String xterBkgRqstStsCd = null;
	
	private String closeBkgFlag = null;
	private String cbfBkgFlag = null;
	
	/* 각 탭의 Event를 가지고 있음 */
	private EsmBkg022901Event esmBkg022901Event = null;
	private EsmBkg022902Event esmBkg022902Event = null;
	private EsmBkg022903Event esmBkg022903Event = null;
	private EsmBkg022904Event esmBkg022904Event = null;
	private EsmBkg022905Event esmBkg022905Event = null;
	private EsmBkg022906Event esmBkg022906Event = null;
	private EsmBkg022907Event esmBkg022907Event = null;
	private EsmBkg022908Event esmBkg022908Event = null;
	private EsmBkg022909Event esmBkg022909Event = null;
	private EsmBkg022910Event esmBkg022910Event = null;
	private EsmBkg022911Event esmBkg022911Event = null;

	public EsmBkg0229Event(){}

	public XterRqstNoVO getXterRqstNoVO() {
		return xterRqstNoVO;
	}

	public void setXterRqstNoVO(XterRqstNoVO xterRqstNoVO) {
		this.xterRqstNoVO = xterRqstNoVO;
	}

	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public String getSaveBkgFlag() {
		return saveBkgFlag;
	}

	public void setSaveBkgFlag(String saveBkgFlag) {
		this.saveBkgFlag = saveBkgFlag;
	}

	public String getSaveCustFlag() {
		return saveCustFlag;
	}

	public void setSaveCustFlag(String saveCustFlag) {
		this.saveCustFlag = saveCustFlag;
	}

	public String getSaveCntrFlag() {
		return saveCntrFlag;
	}

	public void setSaveCntrFlag(String saveCntrFlag) {
		this.saveCntrFlag = saveCntrFlag;
	}

	public String getSaveMndFlag() {
		return saveMndFlag;
	}

	public void setSaveMndFlag(String saveMndFlag) {
		this.saveMndFlag = saveMndFlag;
	}

	public String getSaveCmFlag() {
		return saveCmFlag;
	}

	public void setSaveCmFlag(String saveCmFlag) {
		this.saveCmFlag = saveCmFlag;
	}

	public String getSaveTroFlag() {
		return saveTroFlag;
	}

	public void setSaveTroFlag(String saveTroFlag) {
		this.saveTroFlag = saveTroFlag;
	}

	public String getSaveRfFlag() {
		return saveRfFlag;
	}

	public void setSaveRfFlag(String saveRfFlag) {
		this.saveRfFlag = saveRfFlag;
	}

	public String getSaveDgFlag() {
		return saveDgFlag;
	}

	public void setSaveDgFlag(String saveDgFlag) {
		this.saveDgFlag = saveDgFlag;
	}

	public String getSaveAkFlag() {
		return saveAkFlag;
	}

	public void setSaveAkFlag(String saveAkFlag) {
		this.saveAkFlag = saveAkFlag;
	}

	public String getSaveHblFlag() {
		return saveHblFlag;
	}

	public void setSaveHblFlag(String saveHblFlag) {
		this.saveHblFlag = saveHblFlag;
	}

	public String getSaveHbl2Flag() {
		return saveHbl2Flag;
	}

	public void setSaveHbl2Flag(String saveHbl2Flag) {
		this.saveHbl2Flag = saveHbl2Flag;
	}

	public String getXterBkgRqstStsCd() {
		return xterBkgRqstStsCd;
	}

	public void setXterBkgRqstStsCd(String xterBkgRqstStsCd) {
		this.xterBkgRqstStsCd = xterBkgRqstStsCd;
	}

	public String getCloseBkgFlag() {
		return closeBkgFlag;
	}

	public void setCloseBkgFlag(String closeBkgFlag) {
		this.closeBkgFlag = closeBkgFlag;
	}

	public EsmBkg022901Event getEsmBkg022901Event() {
		return esmBkg022901Event;
	}

	public void setEsmBkg022901Event(EsmBkg022901Event esmBkg022901Event) {
		this.esmBkg022901Event = esmBkg022901Event;
	}

	public EsmBkg022902Event getEsmBkg022902Event() {
		return esmBkg022902Event;
	}

	public void setEsmBkg022902Event(EsmBkg022902Event esmBkg022902Event) {
		this.esmBkg022902Event = esmBkg022902Event;
	}

	public EsmBkg022903Event getEsmBkg022903Event() {
		return esmBkg022903Event;
	}

	public void setEsmBkg022903Event(EsmBkg022903Event esmBkg022903Event) {
		this.esmBkg022903Event = esmBkg022903Event;
	}

	public EsmBkg022904Event getEsmBkg022904Event() {
		return esmBkg022904Event;
	}

	public void setEsmBkg022904Event(EsmBkg022904Event esmBkg022904Event) {
		this.esmBkg022904Event = esmBkg022904Event;
	}

	public EsmBkg022905Event getEsmBkg022905Event() {
		return esmBkg022905Event;
	}

	public void setEsmBkg022905Event(EsmBkg022905Event esmBkg022905Event) {
		this.esmBkg022905Event = esmBkg022905Event;
	}

	public EsmBkg022906Event getEsmBkg022906Event() {
		return esmBkg022906Event;
	}

	public void setEsmBkg022906Event(EsmBkg022906Event esmBkg022906Event) {
		this.esmBkg022906Event = esmBkg022906Event;
	}

	public EsmBkg022907Event getEsmBkg022907Event() {
		return esmBkg022907Event;
	}

	public void setEsmBkg022907Event(EsmBkg022907Event esmBkg022907Event) {
		this.esmBkg022907Event = esmBkg022907Event;
	}

	public EsmBkg022908Event getEsmBkg022908Event() {
		return esmBkg022908Event;
	}

	public void setEsmBkg022908Event(EsmBkg022908Event esmBkg022908Event) {
		this.esmBkg022908Event = esmBkg022908Event;
	}

	public EsmBkg022909Event getEsmBkg022909Event() {
		return esmBkg022909Event;
	}

	public void setEsmBkg022909Event(EsmBkg022909Event esmBkg022909Event) {
		this.esmBkg022909Event = esmBkg022909Event;
	}

	public EsmBkg022910Event getEsmBkg022910Event() {
		return esmBkg022910Event;
	}

	public void setEsmBkg022910Event(EsmBkg022910Event esmBkg022910Event) {
		this.esmBkg022910Event = esmBkg022910Event;
	}

	public EsmBkg022911Event getEsmBkg022911Event() {
		return esmBkg022911Event;
	}

	public void setEsmBkg022911Event(EsmBkg022911Event esmBkg022911Event) {
		this.esmBkg022911Event = esmBkg022911Event;
	}

	public String getCbfBkgFlag() {
		return cbfBkgFlag;
	}

	public void setCbfBkgFlag(String cbfBkgFlag) {
		this.cbfBkgFlag = cbfBkgFlag;
	}

}