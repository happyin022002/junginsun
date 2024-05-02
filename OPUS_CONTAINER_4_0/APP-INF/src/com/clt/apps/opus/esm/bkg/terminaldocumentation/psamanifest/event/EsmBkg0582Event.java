/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0582Event.java
*@FileTitle : EsmBkg0582Event
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

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaPortVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0582 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0582HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
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
		PsaPortVO[] rtnVOs = null;
		if (this.psaPortVOs != null) {
			rtnVOs = Arrays.copyOf(psaPortVOs, psaPortVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param psaPortVOs the psaPortVOs to set
	 */
	public void setPsaPortVOs(PsaPortVO[] psaPortVOs) {
		if (psaPortVOs != null) {
			PsaPortVO[] tmpVOs = Arrays.copyOf(psaPortVOs, psaPortVOs.length);
			this.psaPortVOs = tmpVOs;
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

}
