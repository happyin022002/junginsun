/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBis0743Event.java
*@FileTitle : B/L Print Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgUsrDfltSetVO;


/**
 * ESM_BIS_0743 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0743HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BIS_0743HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBis0743Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	


	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgUsrDfltSetVO infoVO = null;
	
	/* BKG_BL_ISS 관련 Object */
	private BlIssInfoVO infoVO2 = null;

	public BlIssInfoVO getInfoVO2() {
		return infoVO2;
	}


	public void setInfoVO2(BlIssInfoVO infoVO2) {
		this.infoVO2 = infoVO2;
	}


	/** Table Value Object Multi Data 처리 */
	private BkgUsrDfltSetVO[] infoVOs = null;

	private String bkgNo ="";
	
	private String corrNo ="";
	
	private String chargeTp ="";
	
	private String containerTp ="";
	
	private String hiddenData ="";

	public String getHiddenData() {
		return hiddenData;
	}


	public void setHiddenData(String hiddenData) {
		this.hiddenData = hiddenData;
	}


	public String getChargeTp() {
		return chargeTp;
	}


	public void setChargeTp(String chargeTp) {
		this.chargeTp = chargeTp;
	}


	public String getContainerTp() {
		return containerTp;
	}


	public void setContainerTp(String containerTp) {
		this.containerTp = containerTp;
	}


	public String getCorrNo() {
		return corrNo;
	}


	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
	}


	public EsmBis0743Event(){}


	public String getBkgNo() {
		return bkgNo;
	}


	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}


	public BkgUsrDfltSetVO getInfoVO() {
		return infoVO;
	}


	public void setInfoVO(BkgUsrDfltSetVO infoVO) {
		this.infoVO = infoVO;
	}


	public BkgUsrDfltSetVO[] getInfoVOs() {
		return infoVOs;
	}


	public void setInfoVOs(BkgUsrDfltSetVO[] infoVOs) {
		this.infoVOs = infoVOs;
	}
	
	

	
	
}