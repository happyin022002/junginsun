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
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
* 2014.08.22 최도순[CHM-201431653] e-BKG cancel request 업로드 시에도 remark란 입력 및 저장 기능 활성화
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SIWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
	
	private SIWebServiceVO sIWebServiceVO = null; 
	
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
	private String saveBbFlag = null;
	private String saveHblFlag = null;
	private String saveHbl2Flag = null;
	private String xterBkgRqstStsCd = null;
	
	private String closeBkgFlag = null;
	private String cbfBkgFlag = null;
	private String bccExistFlg = null;
	
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
	private EsmBkg022912Event esmBkg022912Event = null;
	
	private String faxLogRefNo = null;
	private String rqstNo = null;
	private String senderId = null;
	private String interRmk = null;
	private String xterRmk = null;
	private String siCntcPsonEml =null;

	public EsmBkg0229Event(){}

	/**
	 * @return the xterRqstNoVO
	 */
	public XterRqstNoVO getXterRqstNoVO() {
		return xterRqstNoVO;
	}

	/**
	 * @param xterRqstNoVO the xterRqstNoVO to set
	 */
	public void setXterRqstNoVO(XterRqstNoVO xterRqstNoVO) {
		this.xterRqstNoVO = xterRqstNoVO;
	}

	/**
	 * @return the bkgBlNoVO
	 */
	public BkgBlNoVO getBkgBlNoVO() {
		return bkgBlNoVO;
	}

	/**
	 * @param bkgBlNoVO the bkgBlNoVO to set
	 */
	public void setBkgBlNoVO(BkgBlNoVO bkgBlNoVO) {
		this.bkgBlNoVO = bkgBlNoVO;
	}

	public SIWebServiceVO getSIWebServiceVO() {
		return sIWebServiceVO;
	}

	public void setSIWebServiceVO(SIWebServiceVO sIWebServiceVO) {
		this.sIWebServiceVO = sIWebServiceVO;
	}

	public String getSiCntcPsonEml() {
		return siCntcPsonEml;
	}

	public void setSiCntcPsonEml(String siCntcPsonEml) {
		this.siCntcPsonEml = siCntcPsonEml;
	}

	/**
	 * @return the saveBkgFlag
	 */
	public String getSaveBkgFlag() {
		return saveBkgFlag;
	}

	/**
	 * @param saveBkgFlag the saveBkgFlag to set
	 */
	public void setSaveBkgFlag(String saveBkgFlag) {
		this.saveBkgFlag = saveBkgFlag;
	}

	/**
	 * @return the saveCustFlag
	 */
	public String getSaveCustFlag() {
		return saveCustFlag;
	}

	/**
	 * @param saveCustFlag the saveCustFlag to set
	 */
	public void setSaveCustFlag(String saveCustFlag) {
		this.saveCustFlag = saveCustFlag;
	}

	/**
	 * @return the saveCntrFlag
	 */
	public String getSaveCntrFlag() {
		return saveCntrFlag;
	}

	/**
	 * @param saveCntrFlag the saveCntrFlag to set
	 */
	public void setSaveCntrFlag(String saveCntrFlag) {
		this.saveCntrFlag = saveCntrFlag;
	}

	/**
	 * @return the saveMndFlag
	 */
	public String getSaveMndFlag() {
		return saveMndFlag;
	}

	/**
	 * @param saveMndFlag the saveMndFlag to set
	 */
	public void setSaveMndFlag(String saveMndFlag) {
		this.saveMndFlag = saveMndFlag;
	}

	/**
	 * @return the saveCmFlag
	 */
	public String getSaveCmFlag() {
		return saveCmFlag;
	}

	/**
	 * @param saveCmFlag the saveCmFlag to set
	 */
	public void setSaveCmFlag(String saveCmFlag) {
		this.saveCmFlag = saveCmFlag;
	}

	/**
	 * @return the saveTroFlag
	 */
	public String getSaveTroFlag() {
		return saveTroFlag;
	}

	/**
	 * @param saveTroFlag the saveTroFlag to set
	 */
	public void setSaveTroFlag(String saveTroFlag) {
		this.saveTroFlag = saveTroFlag;
	}

	/**
	 * @return the saveRfFlag
	 */
	public String getSaveRfFlag() {
		return saveRfFlag;
	}

	/**
	 * @param saveRfFlag the saveRfFlag to set
	 */
	public void setSaveRfFlag(String saveRfFlag) {
		this.saveRfFlag = saveRfFlag;
	}

	/**
	 * @return the saveDgFlag
	 */
	public String getSaveDgFlag() {
		return saveDgFlag;
	}

	/**
	 * @param saveDgFlag the saveDgFlag to set
	 */
	public void setSaveDgFlag(String saveDgFlag) {
		this.saveDgFlag = saveDgFlag;
	}

	/**
	 * @return the saveAkFlag
	 */
	public String getSaveAkFlag() {
		return saveAkFlag;
	}

	/**
	 * @param saveAkFlag the saveAkFlag to set
	 */
	public void setSaveAkFlag(String saveAkFlag) {
		this.saveAkFlag = saveAkFlag;
	}

	/**
	 * @return the saveBbFlag
	 */
	public String getSaveBbFlag() {
		return saveBbFlag;
	}

	/**
	 * @param saveBbFlag the saveBbFlag to set
	 */
	public void setSaveBbFlag(String saveBbFlag) {
		this.saveBbFlag = saveBbFlag;
	}

	/**
	 * @return the saveHblFlag
	 */
	public String getSaveHblFlag() {
		return saveHblFlag;
	}

	/**
	 * @param saveHblFlag the saveHblFlag to set
	 */
	public void setSaveHblFlag(String saveHblFlag) {
		this.saveHblFlag = saveHblFlag;
	}

	/**
	 * @return the saveHbl2Flag
	 */
	public String getSaveHbl2Flag() {
		return saveHbl2Flag;
	}

	/**
	 * @param saveHbl2Flag the saveHbl2Flag to set
	 */
	public void setSaveHbl2Flag(String saveHbl2Flag) {
		this.saveHbl2Flag = saveHbl2Flag;
	}

	/**
	 * @return the xterBkgRqstStsCd
	 */
	public String getXterBkgRqstStsCd() {
		return xterBkgRqstStsCd;
	}

	/**
	 * @param xterBkgRqstStsCd the xterBkgRqstStsCd to set
	 */
	public void setXterBkgRqstStsCd(String xterBkgRqstStsCd) {
		this.xterBkgRqstStsCd = xterBkgRqstStsCd;
	}

	/**
	 * @return the closeBkgFlag
	 */
	public String getCloseBkgFlag() {
		return closeBkgFlag;
	}

	/**
	 * @param closeBkgFlag the closeBkgFlag to set
	 */
	public void setCloseBkgFlag(String closeBkgFlag) {
		this.closeBkgFlag = closeBkgFlag;
	}

	/**
	 * @return the cbfBkgFlag
	 */
	public String getCbfBkgFlag() {
		return cbfBkgFlag;
	}

	/**
	 * @param cbfBkgFlag the cbfBkgFlag to set
	 */
	public void setCbfBkgFlag(String cbfBkgFlag) {
		this.cbfBkgFlag = cbfBkgFlag;
	}

	/**
	 * @return the esmBkg022901Event
	 */
	public EsmBkg022901Event getEsmBkg022901Event() {
		return esmBkg022901Event;
	}

	/**
	 * @param esmBkg022901Event the esmBkg022901Event to set
	 */
	public void setEsmBkg022901Event(EsmBkg022901Event esmBkg022901Event) {
		this.esmBkg022901Event = esmBkg022901Event;
	}

	/**
	 * @return the esmBkg022902Event
	 */
	public EsmBkg022902Event getEsmBkg022902Event() {
		return esmBkg022902Event;
	}

	/**
	 * @param esmBkg022902Event the esmBkg022902Event to set
	 */
	public void setEsmBkg022902Event(EsmBkg022902Event esmBkg022902Event) {
		this.esmBkg022902Event = esmBkg022902Event;
	}

	/**
	 * @return the esmBkg022903Event
	 */
	public EsmBkg022903Event getEsmBkg022903Event() {
		return esmBkg022903Event;
	}

	/**
	 * @param esmBkg022903Event the esmBkg022903Event to set
	 */
	public void setEsmBkg022903Event(EsmBkg022903Event esmBkg022903Event) {
		this.esmBkg022903Event = esmBkg022903Event;
	}

	/**
	 * @return the esmBkg022904Event
	 */
	public EsmBkg022904Event getEsmBkg022904Event() {
		return esmBkg022904Event;
	}

	/**
	 * @param esmBkg022904Event the esmBkg022904Event to set
	 */
	public void setEsmBkg022904Event(EsmBkg022904Event esmBkg022904Event) {
		this.esmBkg022904Event = esmBkg022904Event;
	}

	/**
	 * @return the esmBkg022905Event
	 */
	public EsmBkg022905Event getEsmBkg022905Event() {
		return esmBkg022905Event;
	}

	/**
	 * @param esmBkg022905Event the esmBkg022905Event to set
	 */
	public void setEsmBkg022905Event(EsmBkg022905Event esmBkg022905Event) {
		this.esmBkg022905Event = esmBkg022905Event;
	}

	/**
	 * @return the esmBkg022906Event
	 */
	public EsmBkg022906Event getEsmBkg022906Event() {
		return esmBkg022906Event;
	}

	/**
	 * @param esmBkg022906Event the esmBkg022906Event to set
	 */
	public void setEsmBkg022906Event(EsmBkg022906Event esmBkg022906Event) {
		this.esmBkg022906Event = esmBkg022906Event;
	}

	/**
	 * @return the esmBkg022907Event
	 */
	public EsmBkg022907Event getEsmBkg022907Event() {
		return esmBkg022907Event;
	}

	/**
	 * @param esmBkg022907Event the esmBkg022907Event to set
	 */
	public void setEsmBkg022907Event(EsmBkg022907Event esmBkg022907Event) {
		this.esmBkg022907Event = esmBkg022907Event;
	}

	/**
	 * @return the esmBkg022908Event
	 */
	public EsmBkg022908Event getEsmBkg022908Event() {
		return esmBkg022908Event;
	}

	/**
	 * @param esmBkg022908Event the esmBkg022908Event to set
	 */
	public void setEsmBkg022908Event(EsmBkg022908Event esmBkg022908Event) {
		this.esmBkg022908Event = esmBkg022908Event;
	}

	/**
	 * @return the esmBkg022909Event
	 */
	public EsmBkg022909Event getEsmBkg022909Event() {
		return esmBkg022909Event;
	}

	/**
	 * @param esmBkg022909Event the esmBkg022909Event to set
	 */
	public void setEsmBkg022909Event(EsmBkg022909Event esmBkg022909Event) {
		this.esmBkg022909Event = esmBkg022909Event;
	}

	/**
	 * @return the esmBkg022910Event
	 */
	public EsmBkg022910Event getEsmBkg022910Event() {
		return esmBkg022910Event;
	}

	/**
	 * @param esmBkg022910Event the esmBkg022910Event to set
	 */
	public void setEsmBkg022910Event(EsmBkg022910Event esmBkg022910Event) {
		this.esmBkg022910Event = esmBkg022910Event;
	}

	/**
	 * @return the esmBkg022911Event
	 */
	public EsmBkg022911Event getEsmBkg022911Event() {
		return esmBkg022911Event;
	}

	/**
	 * @param esmBkg022911Event the esmBkg022911Event to set
	 */
	public void setEsmBkg022911Event(EsmBkg022911Event esmBkg022911Event) {
		this.esmBkg022911Event = esmBkg022911Event;
	}

	/**
	 * @return the esmBkg022912Event
	 */
	public EsmBkg022912Event getEsmBkg022912Event() {
		return esmBkg022912Event;
	}

	/**
	 * @param esmBkg022912Event the esmBkg022912Event to set
	 */
	public void setEsmBkg022912Event(EsmBkg022912Event esmBkg022912Event) {
		this.esmBkg022912Event = esmBkg022912Event;
	}

	/**
	 * @return the faxLogRefNo
	 */
	public String getFaxLogRefNo() {
		return faxLogRefNo;
	}

	/**
	 * @param faxLogRefNo the faxLogRefNo to set
	 */
	public void setFaxLogRefNo(String faxLogRefNo) {
		this.faxLogRefNo = faxLogRefNo;
	}

	/**
	 * @return the rqstNo
	 */
	public String getRqstNo() {
		return rqstNo;
	}

	/**
	 * @param rqstNo the rqstNo to set
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}

	/**
	 * @return the senderId
	 */
	public String getSenderId() {
		return senderId;
	}

	/**
	 * @param senderId the senderId to set
	 */
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getInterRmk() {
		return interRmk;
	}

	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}

	public String getXterRmk() {
		return xterRmk;
	}

	public void setXterRmk(String xterRmk) {
		this.xterRmk = xterRmk;
	}

	public String getBccExistFlg() {
		return bccExistFlg;
	}

	public void setBccExistFlg(String bccExistFlg) {
		this.bccExistFlg = bccExistFlg;
	}
	
	

}