/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSam0007Event.java
*@FileTitle : Sales Activity Management
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

import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamActivityInfoVO;
import com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo.SamActivityInputVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SAM_0007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LEEKUANSIAN
 * @see ESM_SAM_0007HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmSam0007Event extends EventSupport {

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


	public EsmSam0007Event(){}


	public SamActivityInputVO getSamActivityInputVO() {
		return samActivityInputVO;
	}

	public void setSamActivityInputVO(SamActivityInputVO samActivityInputVO) {
		this.samActivityInputVO = samActivityInputVO;
	}

	public SamActivityInputVO[] getSamActivityInputVOs() {
		SamActivityInputVO[] rtnVOs = null;
		if (this.samActivityInputVOs != null) {
			rtnVOs = Arrays.copyOf(samActivityInputVOs, samActivityInputVOs.length);
		}
		return rtnVOs;
	}

	public void setSamActivityInputVOs(SamActivityInputVO[] samActivityInputVOs) {
		if(samActivityInputVOs != null){
			SamActivityInputVO[] tmpVOs = Arrays.copyOf(samActivityInputVOs, samActivityInputVOs.length);
			this.samActivityInputVOs = tmpVOs;
		}
	}

	public SamActivityInfoVO getSamActivityInfoVO() {
		return samActivityInfoVO;
	}

	public void setSamActivityInfoVO(SamActivityInfoVO samActivityInfoVO) {
		this.samActivityInfoVO = samActivityInfoVO;
	}

	public SamActivityInfoVO[] getSamActivityInfoVOs() {
		SamActivityInfoVO[] rtnVOs = null;
		if (this.samActivityInfoVOs != null) {
			rtnVOs = Arrays.copyOf(samActivityInfoVOs, samActivityInfoVOs.length);
		}
		return rtnVOs;
	}

	public void setSamActivityInfoVOs(SamActivityInfoVO[] samActivityInfoVOs) {
		if(samActivityInfoVOs != null){
			SamActivityInfoVO[] tmpVOs = Arrays.copyOf(samActivityInfoVOs, samActivityInfoVOs.length);
			this.samActivityInfoVOs = tmpVOs;
		}
	}


	/** Table Value Object 조회 조건 및 단건 처리  */
	private SamActivityInfoVO samActivityInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SamActivityInfoVO[] samActivityInfoVOs = null;

	

	
	

}