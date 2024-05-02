/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSam0009Event.java
*@FileTitle : Performance by Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : 이관샨
*@LastVersion : 1.0
* 2011.06.15 이관샨
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamPFMCbyCustInputVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_SAM_0009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEEKUANSIAN
 * @see ESM_SAM_0009HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSam0009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SamPFMCbyCustInputVO samPFMCbyCustInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SamPFMCbyCustInputVO[] samPFMCbyCustInputVOs = null;
	
	private String hiddenOfcCd = null;


	public String getHiddenOfcCd() {
		return hiddenOfcCd;
	}

	public void setHiddenOfcCd(String hiddenOfcCd) {
		this.hiddenOfcCd = hiddenOfcCd;
	}

	public EsmSam0009Event(){}
	
	public void setSamPFMCbyCustInputVO(SamPFMCbyCustInputVO samPFMCbyCustInputVO){
		this. samPFMCbyCustInputVO = samPFMCbyCustInputVO;
	}

	public void setSamPFMCbyCustInputVOS(SamPFMCbyCustInputVO[] samPFMCbyCustInputVOs){
		if(samPFMCbyCustInputVOs != null){
			SamPFMCbyCustInputVO[] tmpVOs = Arrays.copyOf(samPFMCbyCustInputVOs, samPFMCbyCustInputVOs.length);
			this.samPFMCbyCustInputVOs = tmpVOs;
		}
	}

	public SamPFMCbyCustInputVO getSamPFMCbyCustInputVO(){
		return samPFMCbyCustInputVO;
	}

	public SamPFMCbyCustInputVO[] getSamPFMCbyCustInputVOS(){
		SamPFMCbyCustInputVO[] rtnVOs = null;
		if (this.samPFMCbyCustInputVOs != null) {
			rtnVOs = Arrays.copyOf(samPFMCbyCustInputVOs, samPFMCbyCustInputVOs.length);
		}
		return rtnVOs;
	}

	public String getCustCd() {
		// TODO Auto-generated method stub
		return null;
	}

}