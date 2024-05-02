/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv9999Event.java
*@FileTitle : Manual Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.13
*@LastModifier : 박성용
*@LastVersion : 1.0
* 2015.08.13 박성용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BkgNoCaNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ManualInputVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_9999 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_9999HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SY PARK
 * @see FNS_INV_9999HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv9999Event extends EventSupport {

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
	private String srcIfDt = null;
	private String srcIfSeq = null;
	
	
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
	
	public FnsInv9999Event(){}
	
	
	
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
		ManualInputVO[] rtnVOs = null;
		if (this.manualInputVOs != null) {
			rtnVOs = new ManualInputVO[manualInputVOs.length];
			System.arraycopy(manualInputVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param manualInputVOs the manualInputVOs to set
	 */
	public void setManualInputVOs(ManualInputVO[] manualInputVOs){
		if(manualInputVOs != null){
			ManualInputVO[] tmpVOs = new ManualInputVO[manualInputVOs.length];
			System.arraycopy(manualInputVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.manualInputVOs = tmpVOs;
		}
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
		BkgNoCaNoVO[] rtnVOs = null;
		if (this.bkgNoCaNoVOs != null) {
			rtnVOs = new BkgNoCaNoVO[bkgNoCaNoVOs.length];
			System.arraycopy(bkgNoCaNoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param bkgNoCaNoVOs the bkgNoCaNoVOs to set
	 */
	public void setBkgNoCaNoVOs(BkgNoCaNoVO[] bkgNoCaNoVOs){
		if(bkgNoCaNoVOs != null){
			BkgNoCaNoVO[] tmpVOs = new BkgNoCaNoVO[bkgNoCaNoVOs.length];
			System.arraycopy(bkgNoCaNoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgNoCaNoVOs = tmpVOs;
		}
	}

	public String getSrcIfDt() {
		return srcIfDt;
	}

	public void setSrcIfDt(String srcIfDt) {
		this.srcIfDt = srcIfDt;
	}
	
	public String getSrcIfSeq() {
		return srcIfSeq;
	}

	public void setSrcIfSeq(String srcIfSeq) {
		this.srcIfSeq = srcIfSeq;
	}
	
}