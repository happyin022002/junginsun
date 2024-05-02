/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0091Event.java
*@FileTitle : Agreement No. Selection
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.28 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event;

import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRegistrationVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_LSE_0091 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0091HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Nho Jung Yong
 * @see EES_LSE_0091HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesLse0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String expFromDt     = null;
	private String expToDt       = null;
	private String vndrSeq       = null;
	private String lstmCd        = null;
	private String orgCntrTpszCd = null;
	private String ofcCd         = null;
	private String allLstmCd     = null;
	private String lsePayTpCd     = null;
	private AgreementRegistrationVO agreementRegistrationVO = null;

	public void setExpFromDt(String expFromDt) {
		this.expFromDt = expFromDt;
	}
	public String getExpFromDt() {
		return expFromDt;
	}
	public void setExpToDt(String expToDt) {
		this.expToDt = expToDt;
	}
	public String getExpToDt() {
		return expToDt;
	}
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	public String getVndrSeq() {
		return vndrSeq;
	}
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	public String getLstmCd() {
		return lstmCd;
	}
	public void setOrgCntrTpszCd(String orgCntrTpszCd) {
		this.orgCntrTpszCd = orgCntrTpszCd;
	}
	public String getOrgCntrTpszCd() {
		return orgCntrTpszCd;
	}
	public void setAgreementRegistrationVO(AgreementRegistrationVO agreementRegistrationVO) {
		this.agreementRegistrationVO = agreementRegistrationVO;
	}
	public AgreementRegistrationVO getAgreementRegistrationVO() {
		return agreementRegistrationVO;
	}
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	public String getOfcCd() {
		return ofcCd;
	}
	public void setAllLstmCd(String allLstmCd) {
		this.allLstmCd = allLstmCd;
	}
	public String getAllLstmCd() {
		return allLstmCd;
	}
	public void setLsePayTpCd(String lsePayTpCd) {
		this.lsePayTpCd = lsePayTpCd;
	}
	public String getLsePayTpCd() {
		return lsePayTpCd;
	}
}