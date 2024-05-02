/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_018Event.java
*@FileTitle : Brokerage AP Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-22
*@LastModifier : Jung-Hyung, Kim
*@LastVersion : 1.0
* 2007-01-22 Jung-Hyung, Kim
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.event;

import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtApPayInvVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceDetailForBRKGVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceMasterForBRKGVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrint2VO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrintVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoListForPrintVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BrogApPayInvVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ApPayInvVO;


/**
 * ESM_AGT_018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Junghyung_kim
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0018Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Agt_Agn_Comm Table Value Object 조회 조건 및 단건 처리  */
	private APActualInterfaceVO apActualInterfaceVO = null;
	/** Agt_Agn_Comm Table Value Object 조회 조건 및 단건 처리  */
	private APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO = null;
	
	 /** Agt_Agn_Comm_Dtl Table Value Object 조회 조건 및 단건 처리  */
	private APActualInterfaceDetailForBRKGVO apActualInterfaceDetailForBRKGVO = null;
	
	/** Agt_Agn_Comm Table Value Object Multi Data 처리 */
	private APActualInterfaceVO[] apActualInterfaceVOs = null;
	
	/** Agt_Agn_Comm Table Value Object Multi Data 처리 */
	private APActualInterfaceMasterForBRKGVO[] apActualInterfaceMasterForBRKGVOs = null;
	
	/** Agt_Agn_Comm_Dtl Table Value Object Multi Data 처리 */
	private APActualInterfaceDetailForBRKGVO[] apActualInterfaceDetailForBRKGVOs = null;

	private BRKGInfoListForPrintVO brkgInfoListForPrintVO = null;
	
	private BRKGInfoListForPrintVO[] brkgInfoListForPrintVOs = null;
	
	private BRKGInfoForPrintVO brkgInfoForPrintVO = null;
	
	private BRKGInfoForPrintVO[] brkgInfoForPrintVOs = null;
	
	private BRKGInfoForPrint2VO brkgInfoForPrint2VO = null;
	
	private BRKGInfoForPrint2VO[] brkgInfoForPrint2VOs = null;
	
	private BrogApPayInvVO brogApPayInvVO = null;
	
	private BrogApPayInvVO[] brogApPayInvVOs = null;
	
	private ApPayInvVO apPayInvVO	= null;
	
	public EsmAgt0018Event(){}
	
	public void setAPActualInterfaceVO(APActualInterfaceVO apActualInterfaceVO){
		this. apActualInterfaceVO = apActualInterfaceVO;
	}

	public void setAPActualInterfaceVOs(APActualInterfaceVO[] apActualInterfaceVOs){
		this. apActualInterfaceVOs = apActualInterfaceVOs;
	}

	public void setAPActualInterfaceMasterForBRKGVO(APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO){
		this. apActualInterfaceMasterForBRKGVO = apActualInterfaceMasterForBRKGVO;
	}

	public void setAPActualInterfaceMasterForBRKGVOs(APActualInterfaceMasterForBRKGVO[] apActualInterfaceMasterForBRKGVOs){
		this. apActualInterfaceMasterForBRKGVOs = apActualInterfaceMasterForBRKGVOs;
	}

	public APActualInterfaceVO getAPActualInterfaceVO(){
		return apActualInterfaceVO;
	}

	public APActualInterfaceVO[] getAPActualInterfaceVOs(){
		return apActualInterfaceVOs;
	}
	
	public APActualInterfaceMasterForBRKGVO getAPActualInterfaceMasterForBRKGVO(){
		return apActualInterfaceMasterForBRKGVO;
	}

	public APActualInterfaceMasterForBRKGVO[] getAPActualInterfaceMasterForBRKGVOs(){
		return apActualInterfaceMasterForBRKGVOs;
	}
	
	
	public void setAPActualInterfaceDetailForBRKGVO(APActualInterfaceDetailForBRKGVO apActualInterfaceDetailForBRKGVO){
		this. apActualInterfaceDetailForBRKGVO = apActualInterfaceDetailForBRKGVO;
	}

	public void setAPActualInterfaceDetailForBRKGVOs(APActualInterfaceDetailForBRKGVO[] apActualInterfaceDetailForBRKGVOs){
		this. apActualInterfaceDetailForBRKGVOs = apActualInterfaceDetailForBRKGVOs;
	}

	public APActualInterfaceDetailForBRKGVO getAPActualInterfaceDetailForBRKGVO(){
		return apActualInterfaceDetailForBRKGVO;
	}

	public APActualInterfaceDetailForBRKGVO[] getAPActualInterfaceDetailForBRKGVOs(){
		return apActualInterfaceDetailForBRKGVOs;
	}

	public BRKGInfoListForPrintVO getBrkgInfoListForPrintVO() {
    	return brkgInfoListForPrintVO;
    }

	public void setBrkgInfoListForPrintVO(BRKGInfoListForPrintVO brkgInfoListForPrintVO) {
    	this.brkgInfoListForPrintVO = brkgInfoListForPrintVO;
    }

	public BRKGInfoListForPrintVO[] getBrkgInfoListForPrintVOs() {
    	return brkgInfoListForPrintVOs;
    }

	public void setBrkgInfoListForPrintVOs(BRKGInfoListForPrintVO[] brkgInfoListForPrintVOs) {
    	this.brkgInfoListForPrintVOs = brkgInfoListForPrintVOs;
    }

	public BRKGInfoForPrintVO getBrkgInfoForPrintVO() {
    	return brkgInfoForPrintVO;
    }

	public void setBrkgInfoForPrintVO(BRKGInfoForPrintVO brkgInfoForPrintVO) {
    	this.brkgInfoForPrintVO = brkgInfoForPrintVO;
    }

	public BRKGInfoForPrintVO[] getBrkgInfoForPrintVOs() {
    	return brkgInfoForPrintVOs;
    }

	public void setBrkgInfoForPrintVOs(BRKGInfoForPrintVO[] brkgInfoForPrintVOs) {
    	this.brkgInfoForPrintVOs = brkgInfoForPrintVOs;
    }

	public BRKGInfoForPrint2VO getBrkgInfoForPrint2VO() {
    	return brkgInfoForPrint2VO;
    }

	public void setBrkgInfoForPrint2VO(BRKGInfoForPrint2VO brkgInfoForPrint2VO) {
    	this.brkgInfoForPrint2VO = brkgInfoForPrint2VO;
    }

	public BRKGInfoForPrint2VO[] getBrkgInfoForPrint2VOs() {
    	return brkgInfoForPrint2VOs;
    }

	public void setBrgkInfoForPrint2VOs(BRKGInfoForPrint2VO[] brkgInfoForPrint2VOs) {
    	this.brkgInfoForPrint2VOs = brkgInfoForPrint2VOs;
    }

	/**
	 * @param brogApPayInvVO the brogApPayInvVO to set
	 */
	public void setBrogApPayInvVO(BrogApPayInvVO brogApPayInvVO) {
		this.brogApPayInvVO = brogApPayInvVO;
	}

	/**
	 * @return the brogApPayInvVO
	 */
	public BrogApPayInvVO getBrogApPayInvVO() {
		return brogApPayInvVO;
	}

	/**
	 * @param brogApPayInvVOs the brogApPayInvVOs to set
	 */
	public void setBrogApPayInvVOs(BrogApPayInvVO[] brogApPayInvVOs) {
		this.brogApPayInvVOs = brogApPayInvVOs;
	}

	/**
	 * @return the brogApPayInvVOs
	 */
	public BrogApPayInvVO[] getBrogApPayInvVOs() {
		return brogApPayInvVOs;
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
	
}
