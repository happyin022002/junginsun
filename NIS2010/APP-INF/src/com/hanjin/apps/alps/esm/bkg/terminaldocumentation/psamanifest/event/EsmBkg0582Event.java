/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0582Event.java
*@FileTitle : EsmBkg0582Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 4. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaPortVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_0582 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0582HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박상훈
 * @see ESM_BKG_0582HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0582Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String portCd = null;
	private PsaPortVO[] psaPortVOs = null;

	/**
	 * @return the psaPortVOs
	 */
	public PsaPortVO[] getPsaPortVOs() {
		return psaPortVOs;
	}

	/**
	 * @param psaPortVOs the psaPortVOs to set
	 */
	public void setPsaPortVOs(PsaPortVO[] psaPortVOs) {
		this.psaPortVOs = psaPortVOs;
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
	
}
