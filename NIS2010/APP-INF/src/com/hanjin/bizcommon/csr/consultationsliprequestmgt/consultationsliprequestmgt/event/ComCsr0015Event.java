/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComCsr0001Event.java
*@FileTitle : CSR Creation - Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : kim young shin
*@LastVersion : 1.0
* 2014.12.18 kim young shin
* 1.0 Creation
* 2014.03.24 심성윤 - [COM_CSR_0015] 복수 VO 추가
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.event;

import java.util.Arrays;

import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.IfCsrListInputVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_CSR_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  COM_CSR_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kim young shin
 * @see COM_CSR_0015HTMLAction 참조
 * @since J2EE 1.6
 */

public class ComCsr0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private IfCsrListInputVO ifCsrListInputVO = null;
	private IfCsrListInputVO[] ifCsrListInputVOs = null;
	
	public ComCsr0015Event(){}

	/**
	 * @return the ifCsrListInputVO
	 */
	public IfCsrListInputVO getIfCsrListInputVO() {
		return ifCsrListInputVO;
	}

	/**
	 * @param ifCsrListInputVO the ifCsrListInputVO to set
	 */
	public void setIfCsrListInputVO(IfCsrListInputVO ifCsrListInputVO) {
		this.ifCsrListInputVO = ifCsrListInputVO;
	}
	/**
	 * @return the ifCsrListInputVOs
	 */
	public IfCsrListInputVO[] getIfCsrListInputVOs() {
		IfCsrListInputVO[] rtnVOs = null;
		if (this.ifCsrListInputVOs != null) {
			rtnVOs = new IfCsrListInputVO[ifCsrListInputVOs.length];
			System.arraycopy(ifCsrListInputVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param ifCsrListInputVO[] the ifCsrListInputVOs to set
	 */
	public void setIfCsrListInputVOs(IfCsrListInputVO[] ifCsrListInputVOs){
		if(ifCsrListInputVOs != null){
			IfCsrListInputVO[] tmpVOs = Arrays.copyOf(ifCsrListInputVOs, ifCsrListInputVOs.length);
			this.ifCsrListInputVOs = tmpVOs;
		}
	}
	
	
	
}