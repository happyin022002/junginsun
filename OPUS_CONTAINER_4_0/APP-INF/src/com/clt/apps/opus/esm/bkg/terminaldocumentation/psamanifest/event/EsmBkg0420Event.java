/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0420Event.java
*@FileTitle : EsmBkg0420Event
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

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImpStsVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0420 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0420HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0420HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0420Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private PsaImpStsVO psaImpStsVO = null;
	private PsaImpStsVO[] psaImpStsVOs = null;
	private String vslCd = null;
	private String skdVoyNo = null;
	private String skdDirCd = null;

	/**
	 * @return the vslCd
	 */
	public String getVslCd() {
		return vslCd;
	}

	/**
	 * @param vslCd the vslCd to set
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * @return the skdVoyNo
	 */
	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	/**
	 * @param skdVoyNo the skdVoyNo to set
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	/**
	 * @return the skdDirCd
	 */
	public String getSkdDirCd() {
		return skdDirCd;
	}

	/**
	 * @param skdDirCd the skdDirCd to set
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	/**
	 * @return the psaImpStsVOs
	 */
	public PsaImpStsVO[] getPsaImpStsVOs() {
		PsaImpStsVO[] rtnVOs = null;
		if (this.psaImpStsVOs != null) {
			rtnVOs = Arrays.copyOf(psaImpStsVOs, psaImpStsVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param psaImpStsVOs the psaImpStsVOs to set
	 */
	public void setPsaImpStsVOs(PsaImpStsVO[] psaImpStsVOs) {
		if (psaImpStsVOs != null) {
			PsaImpStsVO[] tmpVOs = Arrays.copyOf(psaImpStsVOs, psaImpStsVOs.length);
			this.psaImpStsVOs = tmpVOs;
		}
	}

	/**
	 * @return the psaImpStsVO
	 */
	public PsaImpStsVO getPsaImpStsVO() {
		return psaImpStsVO;
	}

	/**
	 * @param psaImpStsVO the psaImpStsVO to set
	 */
	public void setPsaImpStsVO(PsaImpStsVO psaImpStsVO) {
		this.psaImpStsVO = psaImpStsVO;
	}


}
