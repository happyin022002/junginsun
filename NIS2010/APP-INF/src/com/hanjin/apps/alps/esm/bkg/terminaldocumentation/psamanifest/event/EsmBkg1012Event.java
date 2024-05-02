/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1012Event.java
*@FileTitle : EsmBkg1012Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 4. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.ImpStsSpclCgoVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaVvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_1012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박상훈
 * @see ESM_BKG_1012HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String portCd = null;
	private String etbDt1 = null;
	private String etbDt2 = null;
	private PsaVvdVO[] psaVvdVOs = null;
	private ImpStsSpclCgoVO impStsSpclCgoVO = null;
	
	/**
	 * @return the impStsSpclCgoVO
	 */
	public ImpStsSpclCgoVO getImpStsSpclCgoVO() {
		return impStsSpclCgoVO;
	}
	/**
	 * @param impStsSpclCgoVO the impStsSpclCgoVO to set
	 */
	public void setImpStsSpclCgoVO(ImpStsSpclCgoVO impStsSpclCgoVO) {
		this.impStsSpclCgoVO = impStsSpclCgoVO;
	}
	/**
	 * @return the psaVvdVOs
	 */
	public PsaVvdVO[] getPsaVvdVOs() {
		return psaVvdVOs;
	}
	/**
	 * @param psaVvdVOs the psaVvdVOs to set
	 */
	public void setPsaVvdVOs(PsaVvdVO[] psaVvdVOs) {
		this.psaVvdVOs = psaVvdVOs;
	}
	/**
	 * @return the portCd
	 */
	public String getPortCd() {
		return portCd;
	}
	/**
	 * @param portCd the portCd to set
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	/**
	 * @return the etbDt1
	 */
	public String getEtbDt1() {
		return etbDt1;
	}
	/**
	 * @param etbDt1 the etbDt1 to set
	 */
	public void setEtbDt1(String etbDt1) {
		this.etbDt1 = etbDt1;
	}
	/**
	 * @return the etbDt2
	 */
	public String getEtbDt2() {
		return etbDt2;
	}
	/**
	 * @param etbDt2 the etbDt2 to set
	 */
	public void setEtbDt2(String etbDt2) {
		this.etbDt2 = etbDt2;
	}
	
}
