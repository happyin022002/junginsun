/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0389Event.java
*@FileTitle : EsmBkg0389Event
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

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImportVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaJurongIfVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * esm_bkg_0389 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0389HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0389HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg0389Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String rlyPort = null;
	private String etdDt   = null;
	private String transTp = null;
	private String[] vvds  = null;
	private String 	vvd		= null;
	private String fileKey = null;

	private PsaUnmatchListVO psaUnmatchListVO = null;

	private PsaJurongIfVO psaJurongIfVO = null;
	private PsaJurongIfVO[] psaJurongIfVOs = null;
	private PsaImportVO psaImportVO = null;


	/**
	 * @return the transTp
	 */
	public String getTransTp() {
		return transTp;
	}

	/**
	 * @param transTp the transTp to set
	 */
	public void setTransTp(String transTp) {
		this.transTp = transTp;
	}

	/**
	 * @return the psaImportVO
	 */
	public PsaImportVO getPsaImportVO() {
		return psaImportVO;
	}

	/**
	 * @param psaImportVO the psaImportVO to set
	 */
	public void setPsaImportVO(PsaImportVO psaImportVO) {
		this.psaImportVO = psaImportVO;
	}

	/**
	 * @return the vvd
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd the vvd to set
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * @return the psaJurongIfVOs
	 */
	public PsaJurongIfVO[] getPsaJurongIfVOs() {
		PsaJurongIfVO[] rtnVOs = null;
		if (this.psaJurongIfVOs != null) {
			rtnVOs = Arrays.copyOf(psaJurongIfVOs, psaJurongIfVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param psaJurongIfVOs the psaJurongIfVOs to set
	 */
	public void setPsaJurongIfVOs(PsaJurongIfVO[] psaJurongIfVOs) {
		if (psaJurongIfVOs != null) {
			PsaJurongIfVO[] tmpVOs = Arrays.copyOf(psaJurongIfVOs, psaJurongIfVOs.length);
			this.psaJurongIfVOs = tmpVOs;
		}
	}

	/**
	 * @return the psaJurongIfVO
	 */
	public PsaJurongIfVO getPsaJurongIfVO() {
		return psaJurongIfVO;
	}

	/**
	 * @param psaJurongIfVO the psaJurongIfVO to set
	 */
	public void setPsaJurongIfVO(PsaJurongIfVO psaJurongIfVO) {
		this.psaJurongIfVO = psaJurongIfVO;
	}

	/**
	 * @return the fileKey
	 */
	public String getFileKey() {
		return fileKey;
	}

	/**
	 * @param fileKey the fileKey to set
	 */
	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

	/**
	 * @return the psaUnmatchListVO
	 */
	public PsaUnmatchListVO getPsaUnmatchListVO() {
		return psaUnmatchListVO;
	}

	/**
	 * @param psaUnmatchListVO the psaUnmatchListVO to set
	 */
	public void setPsaUnmatchListVO(PsaUnmatchListVO psaUnmatchListVO) {
		this.psaUnmatchListVO = psaUnmatchListVO;
	}

	/**
	 * @return the rlyPort
	 */
	public String getRlyPort() {
		return rlyPort;
	}

	/**
	 * @param rlyPort the rlyPort to set
	 */
	public void setRlyPort(String rlyPort) {
		this.rlyPort = rlyPort;
	}

	/**
	 * @return the etdDt
	 */
	public String getEtdDt() {
		return etdDt;
	}

	/**
	 * @param etdDt the etdDt to set
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}

	/**
	 * @return the vvds
	 */
	public String[] getVvds() {
		String[] rtnVOs = null;
		if (this.vvds != null) {
			rtnVOs = Arrays.copyOf(vvds, vvds.length);
		}
		return rtnVOs;
	}

	/**
	 * @param vvds the vvds to set
	 */
	public void setVvds(String[] vvds) {
		if (vvds != null) {
			String[] tmpVOs = Arrays.copyOf(vvds, vvds.length);
			this.vvds = tmpVOs;
		}
	}


}
