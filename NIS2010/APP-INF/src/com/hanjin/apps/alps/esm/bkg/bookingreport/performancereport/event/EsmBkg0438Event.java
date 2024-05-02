/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0438Event.java
*@FileTitle : Queue Detail List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0438 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0438HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_0438HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0438Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DocQueueDetailListVO infoVO = null;

	/** Table Value Object Multi Data 처리 */
	private DocQueueDetailListVO[] infoVOs = null;
	
	private  String userPartCd;
	private  String bkgNo;
	private  String srNo;
	private  String userId;
	private  String srKind;
	private  String srKndCd;
	private  String callPgmType;

	public String getUserPartCd() {
		return userPartCd;
	}


	public void setUserPartCd(String userPartCd) {
		this.userPartCd = userPartCd;
	}


	public String getBkgNo() {
		return bkgNo;
	}


	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}


	public String getSrNo() {
		return srNo;
	}


	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getSrKind() {
		return srKind;
	}


	public void setSrKind(String srKind) {
		this.srKind = srKind;
	}
	
	public String getSrKndCd() {
		return srKndCd;
	}


	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
	}


	public EsmBkg0438Event(){}


	public DocQueueDetailListVO getInfoVO() {
		return infoVO;
	}


	public void setInfoVO(DocQueueDetailListVO infoVO) {
		this.infoVO = infoVO;
	}


	public DocQueueDetailListVO[] getInfoVOs() {
		DocQueueDetailListVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}


	public void setInfoVOs(DocQueueDetailListVO[] infoVOs){
		if(infoVOs != null){
			DocQueueDetailListVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}


	public String getCallPgmType() {
		return callPgmType;
	}


	public void setCallPgmType(String callPgmType) {
		this.callPgmType = callPgmType;
	}
	
}