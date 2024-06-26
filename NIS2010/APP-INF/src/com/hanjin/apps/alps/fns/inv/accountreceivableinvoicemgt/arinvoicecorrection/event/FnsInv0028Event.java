/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0028Event.java
*@FileTitle : Invoice Data Manual Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.07 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BkgNoCaNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ManualInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0028HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author DoSoon Choi
 * @see FNS_INV_0028HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String arOfcCd = "";
	private String vvdCd = "";
	private String polCd = "";
	private String podCd = "";
	private String blSrcNo = "";
	private String bkgNo = "";
	private String manDivInd = "";
	private String backEndJobKey = "";
	private String arIfNo = "";
	private String vvd = "";
	private String pol = "";
	private String pod = "";
	
	
	/**
	 * @return the pol
	 */
	public String getPol() {
		return pol;
	}

	/**
	 * @param pol the pol to set
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}

	/**
	 * @return the pod
	 */
	public String getPod() {
		return pod;
	}

	/**
	 * @param pod the pod to set
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}

	/**
	 * @return the vvd
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd the vvd to set
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * @return the backEndJobKey
	 */
	public String getBackEndJobKey() {
		return backEndJobKey;
	}

	/**
	 * @param backEndJobKey the backEndJobKey to set
	 */
	public void setBackEndJobKey(String backEndJobKey) {
		this.backEndJobKey = backEndJobKey;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ManualInputVO manualInputVO = null;
	
	/** Table Value Object Multi Data 처리 */	
	private ManualInputVO[] manualInputVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgNoCaNoVO bkgNoCaNoVO = null;
	
	/** Table Value Object Multi Data 처리 */	
	private BkgNoCaNoVO[] bkgNoCaNoVOs = null;	
	
	public FnsInv0028Event(){}
	
	
	
	/**
	 * @return the arIfNo
	 */
	public String getArIfNo() {
		return arIfNo;
	}

	/**
	 * @param arIfNo the arIfNo to set
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}

	/**
	 * @return the arOfcCd
	 */
	public String getArOfcCd() {
		return arOfcCd;
	}

	/**
	 * @param arOfcCd the arOfcCd to set
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @return the manDivInd
	 */
	public String getManDivInd() {
		return manDivInd;
	}

	/**
	 * @param manDivInd the manDivInd to set
	 */
	public void setManDivInd(String manDivInd) {
		this.manDivInd = manDivInd;
	}


	/**
	 * @return the vvdCd
	 */
	public String getVvdCd() {
		return vvdCd;
	}

	/**
	 * @param vvdCd the vvdCd to set
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	

	/**
	 * @return the polCd
	 */
	public String getPolCd() {
		return polCd;
	}

	/**
	 * @param polCd the polCd to set
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * @return the podCd
	 */
	public String getPodCd() {
		return podCd;
	}

	/**
	 * @param podCd the podCd to set
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	/**
	 * @return the blSrcNo
	 */
	public String getBlSrcNo() {
		return blSrcNo;
	}

	/**
	 * @param blSrcNo the blSrcNo to set
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}

	/**
	 * @return the manualInputVO
	 */
	public ManualInputVO getManualInputVO() {
		return manualInputVO;
	}

	/**
	 * @param manualInputVO the manualInputVO to set
	 */
	public void setManualInputVO(ManualInputVO manualInputVO) {
		this.manualInputVO = manualInputVO;
	}

	/**
	 * @return the manualInputVOs
	 */
	public ManualInputVO[] getManualInputVOs() {
		return manualInputVOs;
	}

	/**
	 * @param manualInputVOs the manualInputVOs to set
	 */
	public void setManualInputVOs(ManualInputVO[] manualInputVOs) {
		this.manualInputVOs = manualInputVOs;
	}

	/**
	 * @return the bkgNoCaNoVO
	 */
	public BkgNoCaNoVO getBkgNoCaNoVO() {
		return bkgNoCaNoVO;
	}

	/**
	 * @param bkgNoCaNoVO the bkgNoCaNoVO to set
	 */
	public void setBkgNoCaNoVO(BkgNoCaNoVO bkgNoCaNoVO) {
		this.bkgNoCaNoVO = bkgNoCaNoVO;
	}

	/**
	 * @return the bkgNoCaNoVOs
	 */
	public BkgNoCaNoVO[] getBkgNoCaNoVOs() {
		return bkgNoCaNoVOs;
	}

	/**
	 * @param bkgNoCaNoVOs the bkgNoCaNoVOs to set
	 */
	public void setBkgNoCaNoVOs(BkgNoCaNoVO[] bkgNoCaNoVOs) {
		this.bkgNoCaNoVOs = bkgNoCaNoVOs;
	}

	
	
}