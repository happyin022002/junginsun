/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0234Event.java
*@FileTitle : ESM_BKG-0234
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.19 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgMarkVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchVvdDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-0234 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0234HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author  LIM JAE TAEK
 * @see ESM_BKG-0234HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0234Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ManilaManifestListCondVO manilaManifestListCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private ManilaManifestListCondVO[] manilaManifestListCondVOs = null;

	private ManifestListDetailVO manifestListDetailVO = null;
	private ManifestListDetailVO[] manifestListDetailVOs = null;
	private String sheetgubun = null;
	private String[] sheetData = null;

	// Download
	private ManilaSearchVvdDtlVO[] manilasearchVvdDtlVOs = null;
	private ManilaSearchBlInfoVO[] manilaSearchBlInfoVOs = null;
	private ManilaSearchPkgDescVO[] manilaSearchPkgDescVOs = null;
	private ManilaSearchPkgMarkVO[] manilaSearchPkgMarkVOs = null;

	public EsmBkg0234Event(){}

	public String getSheetgubun() {
		return sheetgubun;
	}
	public void setSheetgubun(String sheetgubun) {
		this.sheetgubun = sheetgubun;
	}
	public String[] getsheetData() {
		String[] rtnVOs = null;
		if (this.sheetData != null) {
			rtnVOs = Arrays.copyOf(sheetData, sheetData.length);
		}
		return rtnVOs;
	}
	public void setsheetData(String[] sheetData) {
		if (sheetData != null) {
			String[] tmpVOs = Arrays.copyOf(sheetData, sheetData.length);
			this.sheetData = tmpVOs;
		}
	}

	public void setManilaManifestListCondVO(ManilaManifestListCondVO manilaManifestListCondVO){
		this. manilaManifestListCondVO = manilaManifestListCondVO;
	}

	public void setManilaManifestListCondVOS(ManilaManifestListCondVO[] manilaManifestListCondVOs) {
		if (manilaManifestListCondVOs != null) {
			ManilaManifestListCondVO[] tmpVOs = Arrays.copyOf(manilaManifestListCondVOs, manilaManifestListCondVOs.length);
			this.manilaManifestListCondVOs = tmpVOs;
		}
	}

	public void setManifestListDetailVO(ManifestListDetailVO manifestListDetailVO){
		this. manifestListDetailVO = manifestListDetailVO;
	}

	public void setManifestListDetailVOS(ManifestListDetailVO[] manifestListDetailVOs) {
		if (manifestListDetailVOs != null) {
			ManifestListDetailVO[] tmpVOs = Arrays.copyOf(manifestListDetailVOs, manifestListDetailVOs.length);
			this.manifestListDetailVOs = tmpVOs;
		}
	}

	public ManilaManifestListCondVO getManilaManifestListCondVO(){
		return manilaManifestListCondVO;
	}

	public ManilaManifestListCondVO[] getManilaManifestListCondVOS(){
		ManilaManifestListCondVO[] rtnVOs = null;
		if (this.manilaManifestListCondVOs != null) {
			rtnVOs = Arrays.copyOf(manilaManifestListCondVOs, manilaManifestListCondVOs.length);
		}
		return rtnVOs;
	}

	public ManifestListDetailVO getManifestListDetailVO(){
		return manifestListDetailVO;
	}

	public ManifestListDetailVO[] getManifestListDetailVOS(){
		ManifestListDetailVO[] rtnVOs = null;
		if (this.manifestListDetailVOs != null) {
			rtnVOs = Arrays.copyOf(manifestListDetailVOs, manifestListDetailVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @return the manilasearchVvdDtlVOs
	 */
	public ManilaSearchVvdDtlVO[] getManilasearchVvdDtlVOs() {
		ManilaSearchVvdDtlVO[] rtnVOs = null;
		if (this.manilasearchVvdDtlVOs != null) {
			rtnVOs = Arrays.copyOf(manilasearchVvdDtlVOs, manilasearchVvdDtlVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param manilasearchVvdDtlVOs the manilasearchVvdDtlVOs to set
	 */
	public void setManilasearchVvdDtlVOs(ManilaSearchVvdDtlVO[] manilasearchVvdDtlVOs) {
		if (manilasearchVvdDtlVOs != null) {
			ManilaSearchVvdDtlVO[] tmpVOs = Arrays.copyOf(manilasearchVvdDtlVOs, manilasearchVvdDtlVOs.length);
			this.manilasearchVvdDtlVOs = tmpVOs;
		}
	}

	/**
	 * @return the manilaSearchBlInfoVOs
	 */
	public ManilaSearchBlInfoVO[] getManilaSearchBlInfoVOs() {
		ManilaSearchBlInfoVO[] rtnVOs = null;
		if (this.manilaSearchBlInfoVOs != null) {
			rtnVOs = Arrays.copyOf(manilaSearchBlInfoVOs, manilaSearchBlInfoVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param manilaSearchBlInfoVOs the manilaSearchBlInfoVOs to set
	 */
	public void setManilaSearchBlInfoVOs(ManilaSearchBlInfoVO[] manilaSearchBlInfoVOs) {
		if (manilaSearchBlInfoVOs != null) {
			ManilaSearchBlInfoVO[] tmpVOs = Arrays.copyOf(manilaSearchBlInfoVOs, manilaSearchBlInfoVOs.length);
			this.manilaSearchBlInfoVOs = tmpVOs;
		}
	}

	/**
	 * @return the manilaSearchPkgDescVOs
	 */
	public ManilaSearchPkgDescVO[] getManilaSearchPkgDescVOs() {
		ManilaSearchPkgDescVO[] rtnVOs = null;
		if (this.manilaSearchPkgDescVOs != null) {
			rtnVOs = Arrays.copyOf(manilaSearchPkgDescVOs, manilaSearchPkgDescVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param manilaSearchPkgDescVOs the manilaSearchPkgDescVOs to set
	 */
	public void setManilaSearchPkgDescVOs(ManilaSearchPkgDescVO[] manilaSearchPkgDescVOs) {
		if (manilaSearchPkgDescVOs != null) {
			ManilaSearchPkgDescVO[] tmpVOs = Arrays.copyOf(manilaSearchPkgDescVOs, manilaSearchPkgDescVOs.length);
			this.manilaSearchPkgDescVOs = tmpVOs;
		}
	}

	/**
	 * @return the manilaSearchPkgMarkVOs
	 */
	public ManilaSearchPkgMarkVO[] getManilaSearchPkgMarkVOs() {
		ManilaSearchPkgMarkVO[] rtnVOs = null;
		if (this.manilaSearchPkgMarkVOs != null) {
			rtnVOs = Arrays.copyOf(manilaSearchPkgMarkVOs, manilaSearchPkgMarkVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param manilaSearchPkgMarkVOs the manilaSearchPkgMarkVOs to set
	 */
	public void setManilaSearchPkgMarkVOs(ManilaSearchPkgMarkVO[] manilaSearchPkgMarkVOs) {
		if (manilaSearchPkgMarkVOs != null) {
			ManilaSearchPkgMarkVO[] tmpVOs = Arrays.copyOf(manilaSearchPkgMarkVOs, manilaSearchPkgMarkVOs.length);
			this.manilaSearchPkgMarkVOs = tmpVOs;
		}
	}

}
