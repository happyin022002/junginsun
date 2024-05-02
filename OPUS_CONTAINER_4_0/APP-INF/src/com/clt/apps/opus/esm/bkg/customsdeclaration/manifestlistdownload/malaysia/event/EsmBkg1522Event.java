/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsmBkg1522Event.java
*@FileTitle : EsmBkg1522Event
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaImpStsVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * esm_bkg_1522 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1522HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1522HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmBkg1522Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private MalaysiaImpStsVO malaysiaImpStsVO = null;
	private MalaysiaImpStsVO[] malaysiaImpStsVOs = null;
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
	 * @return the malaysiaImpStsVOs
	 */
	public MalaysiaImpStsVO[] getMalaysiaImpStsVOs() {
		MalaysiaImpStsVO[] rtnVOs = null;
		if (this.malaysiaImpStsVOs != null) {
			rtnVOs = new MalaysiaImpStsVO[malaysiaImpStsVOs.length];
			System.arraycopy(malaysiaImpStsVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param malaysiaImpStsVOs the malaysiaImpStsVOs to set
	 */
	public void setMalaysiaImpStsVOs(MalaysiaImpStsVO[] malaysiaImpStsVOs) {
		if (malaysiaImpStsVOs != null) {
			MalaysiaImpStsVO[] tmpVOs = new MalaysiaImpStsVO[malaysiaImpStsVOs.length];
			System.arraycopy(malaysiaImpStsVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.malaysiaImpStsVOs = tmpVOs;
		}
	}

	/**
	 * @return the malaysiaImpStsVO
	 */
	public MalaysiaImpStsVO getMalaysiaImpStsVO() {
		return malaysiaImpStsVO;
	}

	/**
	 * @param malaysiaImpStsVO the malaysiaImpStsVO to set
	 */
	public void setMalaysiaImpStsVO(MalaysiaImpStsVO malaysiaImpStsVO) {
		this.malaysiaImpStsVO = malaysiaImpStsVO;
	}


}
