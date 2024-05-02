/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CpsCni0401Event.java
*@FileTitle : Insurance Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.13 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.insurance.insurance.event;

import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.CustomInsuranceVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.CustomPremiumInstallmentVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.CustomPremiumVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * CPS_CNI_0401 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  CPS_CNI_0401HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yoon, Seyeong
 * @see CPS_CNI_0401HTMLAction 참조
 * @since J2EE 1.6
 */

public class CpsCni0401Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomInsuranceVO customInsuranceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomInsuranceVO[] customInsuranceVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomPremiumVO customPremiumVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomPremiumInstallmentVO[] customPremiumInstallmentVOs = null;
	
	/** Type of Insurance */
	private String insurTpCd  = "";
	
	/** Policy Year */
	private String insurPlcyYr = "";
	
	/** Insurer */
	private String insurClmPtyNo  = "";
	
	/** Type of Premium */
	private String insurPrmTpCd  = "";
	
	/** File Type Code */
	private String clmFileTpCd  = "";

	public CpsCni0401Event(){}
	
	public void setCustomInsuranceVO(CustomInsuranceVO customInsuranceVO){
		this. customInsuranceVO = customInsuranceVO;
	}

	public void setCustomInsuranceVOS(CustomInsuranceVO[] customInsuranceVOs){
		this. customInsuranceVOs = customInsuranceVOs;
	}
	
	public void setCustomPremiumVO(CustomPremiumVO customPremiumVO){
		this. customPremiumVO = customPremiumVO;
	}

	public void setCustomPremiumInstallmentVOS(CustomPremiumInstallmentVO[] customPremiumInstallmentVOs){
		this. customPremiumInstallmentVOs = customPremiumInstallmentVOs;
	}

	public void setInsurTpCd(String insurTpCd) {
		this.insurTpCd = insurTpCd;
	}

	public void setInsurPlcyYr(String insurPlcyYr) {
		this.insurPlcyYr = insurPlcyYr;
	}

	public void setInsurClmPtyNo(String insurClmPtyNo) {
		this.insurClmPtyNo = insurClmPtyNo;
	}

	public void setInsurPrmTpCd(String insurPrmTpCd) {
		this.insurPrmTpCd = insurPrmTpCd;
	}

	public void setClmFileTpCd(String clmFileTpCd) {
		this.clmFileTpCd = clmFileTpCd;
	}

	public CustomInsuranceVO getCustomInsuranceVO(){
		return customInsuranceVO;
	}

	public CustomInsuranceVO[] getCustomInsuranceVOS(){
		return customInsuranceVOs;
	}

	public CustomPremiumVO getCustomPremiumVO(){
		return customPremiumVO;
	}

	public CustomPremiumInstallmentVO[] getCustomPremiumInstallmentVOS(){
		return customPremiumInstallmentVOs;
	}
	
	public String getInsurTpCd() {
		return insurTpCd;
	}
	
	public String getInsurPlcyYr() {
		return insurPlcyYr;
	}
	
	public String getInsurClmPtyNo() {
		return insurClmPtyNo;
	}
	
	public String getInsurPrmTpCd() {
		return insurPrmTpCd;
	}
	
	public String getClmFileTpCd() {
		return clmFileTpCd;
	}

}