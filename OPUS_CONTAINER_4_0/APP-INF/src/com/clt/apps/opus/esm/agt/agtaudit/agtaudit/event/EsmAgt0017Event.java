/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_017Event.java
*@FileTitle : Agent Commission AP Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-14
*@LastModifier : Junghyung_kim
*@LastVersion : 1.0
* 2006-12-14 Junghyung_kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event;

import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AGTCommInfoForPrint2VO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AGTCommInfoForPrintVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.APActualInterfaceDetailVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.APActualInterfaceMasterVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtApPayInvVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ApPayInvVO;

/**
 * ESM_AGT_017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Junghyung_kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0017Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	private String csrCd = "";
	
	/**
     * csr_cd<br>
     * @param csr_cd
     */
    public EsmAgt0017Event(String csr_cd) {
        this.csrCd 	= csr_cd;
    }
    
    
	public String getCsrCd() {
		return csrCd;
	}

	public void setCsrCd(String csrCd) {
		this.csrCd = csrCd;
	}


	/** Agt_Agn_Comm Table Value Object 조회 조건 및 단건 처리  */
	private APActualInterfaceMasterVO apActualInterfaceMasterVO = null;
	
	 /** Agt_Agn_Comm_Dtl Table Value Object 조회 조건 및 단건 처리  */
	private APActualInterfaceDetailVO apActualInterfaceDetailVO = null;
	
	/** Agt_Agn_Comm Table Value Object Multi Data 처리 */
	private APActualInterfaceMasterVO[] apActualInterfaceMasterVOs = null;
	
	/** Agt_Agn_Comm_Dtl Table Value Object Multi Data 처리 */
	private APActualInterfaceDetailVO[] apActualInterfaceDetailVOs = null;
	
	private AGTCommInfoForPrintVO agtCommInfoForPrintVO = null;
	
	private AGTCommInfoForPrintVO[] agtCommInfoForPrintVOs = null;
	
	private AGTCommInfoForPrint2VO agtCommInfoForPrint2VO = null;
	
	private AGTCommInfoForPrint2VO[] agtCommInfoForPrint2VOs = null;
	
	private AgtApPayInvVO agtApPayInvVO = null;
	
	private AgtApPayInvVO[] agtApPayInvVOs = null;
	
	private ApPayInvVO apPayInvVO	= null;
	
	private ApPayInvVO[] apPayInvVOs	= null;
		
	public EsmAgt0017Event(){}
	
	public void setAPActualInterfaceMasterVO(APActualInterfaceMasterVO apActualInterfaceMasterVO){
		this. apActualInterfaceMasterVO = apActualInterfaceMasterVO;
	}

	public void setAPActualInterfaceMasterVOS(APActualInterfaceMasterVO[] apActualInterfaceMasterVOs){
		this. apActualInterfaceMasterVOs = apActualInterfaceMasterVOs;
	}

	public APActualInterfaceMasterVO getAPActualInterfaceMasterVO(){
		return apActualInterfaceMasterVO;
	}

	public APActualInterfaceMasterVO[] getAPActualInterfaceMasterVOS(){
		return apActualInterfaceMasterVOs;
	}
		
	public void setAPActualInterfaceDetailVO(APActualInterfaceDetailVO apActualInterfaceDetailVO){
		this. apActualInterfaceDetailVO = apActualInterfaceDetailVO;
	}

	public void setAPActualInterfaceDetailVOS(APActualInterfaceDetailVO[] apActualInterfaceDetailVOs){
		this. apActualInterfaceDetailVOs = apActualInterfaceDetailVOs;
	}

	public APActualInterfaceDetailVO getAPActualInterfaceDetailVO(){
		return apActualInterfaceDetailVO;
	}

	public APActualInterfaceDetailVO[] getAPActualInterfaceDetailVOS(){
		return apActualInterfaceDetailVOs;
	}

	public AGTCommInfoForPrintVO getAgtCommInfoForPrintVO() {
    	return agtCommInfoForPrintVO;
    }

	public void setAgtCommInfoForPrintVO(AGTCommInfoForPrintVO agtCommInfoForPrintVO) {
    	this.agtCommInfoForPrintVO = agtCommInfoForPrintVO;
    }

	public AGTCommInfoForPrintVO[] getAgtCommInfoForPrintVOs() {
    	return agtCommInfoForPrintVOs;
    }

	public void setAgtCommInfoForPrintVOs(AGTCommInfoForPrintVO[] agtCommInfoForPrintVOs) {
    	this.agtCommInfoForPrintVOs = agtCommInfoForPrintVOs;
    }

	public AGTCommInfoForPrint2VO getAgtCommInfoForPrint2VO() {
    	return agtCommInfoForPrint2VO;
    }

	public void setAgtCommInfoForPrint2VO(AGTCommInfoForPrint2VO agtCommInfoForPrint2VO) {
    	this.agtCommInfoForPrint2VO = agtCommInfoForPrint2VO;
    }

	public AGTCommInfoForPrint2VO[] getAgtCommInfoForPrint2VOs() {
    	return agtCommInfoForPrint2VOs;
    }

	public void setAgtCommInfoForPrint2VOs(AGTCommInfoForPrint2VO[] agtCommInfoForPrint2VOs) {
    	this.agtCommInfoForPrint2VOs = agtCommInfoForPrint2VOs;
    }


	/**
	 * @param agtApPayInvVO the agtApPayInvVO to set
	 */
	public void setAgtApPayInvVO(AgtApPayInvVO agtApPayInvVO) {
		this.agtApPayInvVO = agtApPayInvVO;
	}


	/**
	 * @return the agtApPayInvVO
	 */
	public AgtApPayInvVO getAgtApPayInvVO() {
		return agtApPayInvVO;
	}


	/**
	 * @param agtApPayInvVOs the agtApPayInvVOs to set
	 */
	public void setAgtApPayInvVOs(AgtApPayInvVO[] agtApPayInvVOs) {
		this.agtApPayInvVOs = agtApPayInvVOs;
	}


	/**
	 * @return the agtApPayInvVOs
	 */
	public AgtApPayInvVO[] getAgtApPayInvVOs() {
		return agtApPayInvVOs;
	}


	/**
	 * @param apPayInvVO the apPayInvVO to set
	 */
	public void setApPayInvVO(ApPayInvVO apPayInvVO) {
		this.apPayInvVO = apPayInvVO;
	}


	/**
	 * @return the apPayInvVO
	 */
	public ApPayInvVO getApPayInvVO() {
		return apPayInvVO;
	}


	/**
	 * @param apPayInvVOs the apPayInvVOs to set
	 */
	public void setApPayInvVOs(ApPayInvVO[] apPayInvVOs) {
		this.apPayInvVOs = apPayInvVOs;
	}


	/**
	 * @return the apPayInvVOs
	 */
	public ApPayInvVO[] getApPayInvVOs() {
		return apPayInvVOs;
	}
	
	
}
