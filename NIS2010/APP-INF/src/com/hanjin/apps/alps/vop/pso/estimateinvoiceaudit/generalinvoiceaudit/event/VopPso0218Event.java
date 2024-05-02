/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VopPso0216Event.java
*@FileTitle : TPB Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.11.12 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.event;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.PortTariffListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_PSO_0218 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO_0218HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see VOP_PSO_0218HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0218Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  입력VO   */
	private PortTariffListVO portTariffListVO = null;
	

	private String ydCd;
	private String vndrSeq;
	private String lgsCostCd;
	
	/**
	 * @return the portTariffListVO
	 */
	public PortTariffListVO getPortTariffListVO() {
		return portTariffListVO;
	}
	/**
	 * @param portTariffListVO the portTariffListVO to set
	 */
	public void setPortTariffListVO(PortTariffListVO portTariffListVO) {
		this.portTariffListVO = portTariffListVO;
	}
	
	public String getVndrSeq() {
		return vndrSeq;
	}
	

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq ;
	}
	
	public String getYdCd() {
		return ydCd;
	}


	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	public String getLgsCostCd() {
		return lgsCostCd;
	}

	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	
	
}