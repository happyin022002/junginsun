/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOContractVO.java
*@FileTitle : Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.24 정윤태
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.event.ESM_FMS_0001HTMLAction;

/**
 * NIS2010-ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * - NIS2010-각 테이블의 vo정보를 담는다.
 *
 * @author jungyoontae
 * @see ESM_FMS_0001HTMLAction
 * @since J2EE 1.5
 */
 
public class TCharterIOContractVO {
	
	private CustomContractVO customContractVO;
	
	private CustomHireVO[] customHireVOs;
	
	private CustomPayTermVO[] customPayTermVOs;
	
	private CustomOtrExpnVO[] customOtrExpnVOs;
	
	private CustomChtrPtyFileVO[] customChtrPtyFileVOs;
	
	private CustomChtrPtyCfFileVO[] customChtrPtyCfFileVOs;
	
	private CustomIdVslVO[] customIdVslVOs;

	public CustomContractVO getCustomContract() {
		return customContractVO;
	}

	public void setCustomContract(CustomContractVO customContractVO) {
		this.customContractVO = customContractVO;
	}

	public CustomHireVO[] getCustomHires() {
		return customHireVOs;
	}

	public void setCustomHires(CustomHireVO[] customHireVOs) {
		this.customHireVOs = customHireVOs;
	}

	public CustomPayTermVO[] getCustomPayTerms() {
		return customPayTermVOs;
	}

	public void setCustomPayTerms(CustomPayTermVO[] customPayTermVOs) {
		this.customPayTermVOs = customPayTermVOs;
	}

	public CustomOtrExpnVO[] getCustomOtrExpns() {
		return customOtrExpnVOs;
	}

	public void setCustomOtrExpns(CustomOtrExpnVO[] customOtrExpnVOs) {
		this.customOtrExpnVOs = customOtrExpnVOs;
	}

	public CustomChtrPtyFileVO[] getCustomChtrPtyFiles() {
		return customChtrPtyFileVOs;
	}

	public void setCustomChtrPtyFiles(CustomChtrPtyFileVO[] customChtrPtyFileVOs) {
		this.customChtrPtyFileVOs = customChtrPtyFileVOs;
	}

	public CustomChtrPtyCfFileVO[] getCustomChtrPtyCfFiles() {
		return customChtrPtyCfFileVOs;
	}

	public void setCustomChtrPtyCfFiles(CustomChtrPtyCfFileVO[] customChtrPtyCfFileVOs) {
		this.customChtrPtyCfFileVOs = customChtrPtyCfFileVOs;
	}

	public CustomIdVslVO[] getCustomIdVsls() {
		return customIdVslVOs;
	}

	public void setCustomIdVsls(CustomIdVslVO[] customIdVslVOs) {
		this.customIdVslVOs = customIdVslVOs;
	}
}