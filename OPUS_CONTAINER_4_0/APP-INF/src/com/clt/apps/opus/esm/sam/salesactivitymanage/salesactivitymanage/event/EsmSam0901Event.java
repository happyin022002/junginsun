/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSam0901Event.java
*@FileTitle : Sales Activity List
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

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamActivityInputVO;

/**
 * ESM_SAM_0901 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0901HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONGJINHO
 * @see ESM_SAM_0901HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSam0901Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SamActivityInputVO samActivityInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SamActivityInputVO[] samActivityInputVOs = null;
	
	private String hiddenOfcCd = null;

	public String getHiddenOfcCd() {
		return hiddenOfcCd;
	}

	public void setHiddenOfcCd(String hiddenOfcCd) {
		this.hiddenOfcCd = hiddenOfcCd;
	}

	public EsmSam0901Event(){}
	
	public void setSamActivityInputVO(SamActivityInputVO samActivityInputVO){
		this. samActivityInputVO = samActivityInputVO;
	}

	public void setSamActivityInputVOS(SamActivityInputVO[] samActivityInputVOs){
		if(samActivityInputVOs != null){
			SamActivityInputVO[] tmpVOs = Arrays.copyOf(samActivityInputVOs, samActivityInputVOs.length);
			this.samActivityInputVOs = tmpVOs;
		}
	}

	public SamActivityInputVO getSamActivityInputVO(){
		return samActivityInputVO;
	}

	public SamActivityInputVO[] getSamActivityInputVOS(){
		SamActivityInputVO[] rtnVOs = null;
		if (this.samActivityInputVOs != null) {
			rtnVOs = Arrays.copyOf(samActivityInputVOs, samActivityInputVOs.length);
		}
		return rtnVOs;
	}

}