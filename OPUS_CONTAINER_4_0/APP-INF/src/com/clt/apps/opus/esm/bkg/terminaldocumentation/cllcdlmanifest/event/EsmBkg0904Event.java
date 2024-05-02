/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0904Event.java
*@FileTitle : ESM_BKG_0904
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.29
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.ExCntrTransmitCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0904 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0904HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Les Subin
 * @see ESM_BKG_0904HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0904Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private String bkgNo = null;
	private String polCd = null;
	private String rcvId = null;

	/** Table Value Object Multi Data 처리 */
	private ExCntrTransmitVO exCntrTransmitVO = null;

	private ExCntrTransmitCondVO exCntrTransmitCondVO = null;


	public EsmBkg0904Event(){}

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
	 * @return the rcvId
	 */
	public String getRcvId() {
		return rcvId;
	}

	/**
	 * @param rcvId the rcvId to set
	 */
	public void setRcvId(String rcvId) {
		this.rcvId = rcvId;
	}

	/**
	 * @return the exCntrTransmitVO
	 */
	public ExCntrTransmitVO getExCntrTransmitVO() {
		return exCntrTransmitVO;
	}

	/**
	 * @return the exCntrTransmitCondVO
	 */
	public ExCntrTransmitCondVO getExCntrTransmitCondVO() {
		return exCntrTransmitCondVO;
	}

	/**
	 * @param exCntrTransmitVO the exCntrTransmitVO to set
	 */
	public void setExCntrTransmitCondVO(ExCntrTransmitCondVO exCntrTransmitCondVO) {
		this.exCntrTransmitCondVO  = exCntrTransmitCondVO;
	}


}