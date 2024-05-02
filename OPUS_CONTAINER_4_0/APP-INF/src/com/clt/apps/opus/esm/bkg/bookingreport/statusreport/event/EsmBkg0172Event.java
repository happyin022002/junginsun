/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EsmBkg0172Event.java
*@FileTitle : VGM EDI (Multi)
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.06
*@LastModifier : 문경일
*@LastVersion : 1.0
* 2016.07.06 문경일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.VgmEdiSupVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0172 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0172HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KyoungIl Moon
 * @see ESM_BKG_0172HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0172Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private String ntcKndCd = null;
	private String receiveType = null; 	
	private String polCd = null;
	private String docType=null;
	private String signFlag=null;
	private String bkgNo = null;
	private String slctFlg = null;
	private String refCode = null;
	private String ediReceiveId = null;
	private String ediSndId = null;
	private String cntrNos	= null;
	
	private VgmEdiSupVO vgmEdiSupVO = null;
	
	private VgmEdiSupVO[] vgmEdiSupVOs = null;

	public EsmBkg0172Event(){}

	public String getNtcKndCd() {
		return ntcKndCd;
	}

	public void setNtcKndCd(String ntcKndCd) {
		this.ntcKndCd = ntcKndCd;
	}

	public String getReceiveType(){
		return receiveType;
	}

	public void setReceiveType(String receiveType) {
		this.receiveType = receiveType;
	}
	
	public String getBkgNo(){
		return bkgNo;
	}
	
	public void setBkgNo(String bkgNo){
		this.bkgNo = bkgNo;
	}

	public String getPolCd() {
		return polCd;
	}

	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getSignFlag() {
		return signFlag;
	}

	public void setSignFlag(String signFlag) {
		this.signFlag = signFlag;
	}
	
	public String getSlctFlg() {
		return slctFlg;
	}

	public void setSlctFlg(String slctFlg) {
		this.slctFlg = slctFlg;
	}
	
	public String getRefCode() {
		return refCode;
	}

	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}
	
	public String getEdiReceiveId() {
		return ediReceiveId;
	}

	public void setEdiReceiveId(String ediReceiveId) {
		this.ediReceiveId = ediReceiveId;
	}
	
	public String getEdiSndId(){
		return ediSndId;
	}
	
	public void setEdiSndId(String ediSndId){
		this.ediSndId = ediSndId;
	}
	
	public String getCntrNos(){
		return cntrNos;
	}
	
	public void setCntrNos(String cntrNos){
		this.cntrNos = cntrNos;
	}
	
	public VgmEdiSupVO getVgmEdiSupVO(){
		return vgmEdiSupVO;
	}
	
	public void setVgmEdiSupVO(VgmEdiSupVO vgmEdiSupVO){
		this.vgmEdiSupVO = vgmEdiSupVO;
	}
	
	public void setVgmEdiSupVOS(VgmEdiSupVO[] vgmEdiSupVOs){
		if (vgmEdiSupVOs != null) {
			VgmEdiSupVO[] tmpVOs = Arrays.copyOf(vgmEdiSupVOs, vgmEdiSupVOs .length);
			this. vgmEdiSupVOs = tmpVOs;
		}
	}
	
	public VgmEdiSupVO[] getVgmEdiSupVOS(){
		VgmEdiSupVO[] tmpVOs = null;
		if (this. vgmEdiSupVOs != null) {
			tmpVOs = Arrays.copyOf(vgmEdiSupVOs, vgmEdiSupVOs .length);
		}
		return tmpVOs;
	}
}