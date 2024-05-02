/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1028Event.java
*@FileTitle : EsmBkg1028Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier :
*@LastVersion : 1.0
* 2009. 9. 4.
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaVvdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_1028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1028HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1028Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String portCd = null;
	private String etbDt1 = null;
	private String etbDt2 = null;
	private PsaVvdVO[] psaVvdVOs = null;

	/**
	 * @return the psaVvdVOs
	 */
	public PsaVvdVO[] getPsaVvdVOs() {
		PsaVvdVO[] rtnVOs = null;
		if (this.psaVvdVOs != null) {
			rtnVOs = Arrays.copyOf(psaVvdVOs, psaVvdVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param psaVvdVOs the psaVvdVOs to set
	 */
	public void setPsaVvdVOs(PsaVvdVO[] psaVvdVOs) {
		if (psaVvdVOs != null) {
			PsaVvdVO[] tmpVOs = Arrays.copyOf(psaVvdVOs, psaVvdVOs.length);
			this.psaVvdVOs = tmpVOs;
		}
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
