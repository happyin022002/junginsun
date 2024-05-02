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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgMarkVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchVvdDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
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
		return sheetData;
	}
	public void setsheetData(String[] sheetData) {
		this.sheetData = sheetData;
	}
	
	public void setManilaManifestListCondVO(ManilaManifestListCondVO manilaManifestListCondVO){
		this. manilaManifestListCondVO = manilaManifestListCondVO;
	}

	public void setManilaManifestListCondVOS(ManilaManifestListCondVO[] manilaManifestListCondVOs){
		this. manilaManifestListCondVOs = manilaManifestListCondVOs;
	}
	
	public void setManifestListDetailVO(ManifestListDetailVO manifestListDetailVO){
		this. manifestListDetailVO = manifestListDetailVO;
	}

	public void setManifestListDetailVOS(ManifestListDetailVO[] manifestListDetailVOs){
		this. manifestListDetailVOs = manifestListDetailVOs;
	}	
	
	public ManilaManifestListCondVO getManilaManifestListCondVO(){
		return manilaManifestListCondVO;
	}
 
	public ManilaManifestListCondVO[] getManilaManifestListCondVOS(){
		return manilaManifestListCondVOs;
	}	
	
	public ManifestListDetailVO getManifestListDetailVO(){
		return manifestListDetailVO;
	}

	public ManifestListDetailVO[] getManifestListDetailVOS(){
		return manifestListDetailVOs;
	}

	/**
	 * @return the manilasearchVvdDtlVOs
	 */
	public ManilaSearchVvdDtlVO[] getManilasearchVvdDtlVOs() {
		return manilasearchVvdDtlVOs;
	}

	/**
	 * @param manilasearchVvdDtlVOs the manilasearchVvdDtlVOs to set
	 */
	public void setManilasearchVvdDtlVOs(
			ManilaSearchVvdDtlVO[] manilasearchVvdDtlVOs) {
		this.manilasearchVvdDtlVOs = manilasearchVvdDtlVOs;
	}

	/**
	 * @return the manilaSearchBlInfoVOs
	 */
	public ManilaSearchBlInfoVO[] getManilaSearchBlInfoVOs() {
		return manilaSearchBlInfoVOs;
	}

	/**
	 * @param manilaSearchBlInfoVOs the manilaSearchBlInfoVOs to set
	 */
	public void setManilaSearchBlInfoVOs(
			ManilaSearchBlInfoVO[] manilaSearchBlInfoVOs) {
		this.manilaSearchBlInfoVOs = manilaSearchBlInfoVOs;
	}

	/**
	 * @return the manilaSearchPkgDescVOs
	 */
	public ManilaSearchPkgDescVO[] getManilaSearchPkgDescVOs() {
		return manilaSearchPkgDescVOs;
	}

	/**
	 * @param manilaSearchPkgDescVOs the manilaSearchPkgDescVOs to set
	 */
	public void setManilaSearchPkgDescVOs(
			ManilaSearchPkgDescVO[] manilaSearchPkgDescVOs) {
		this.manilaSearchPkgDescVOs = manilaSearchPkgDescVOs;
	}

	/**
	 * @return the manilaSearchPkgMarkVOs
	 */
	public ManilaSearchPkgMarkVO[] getManilaSearchPkgMarkVOs() {
		return manilaSearchPkgMarkVOs;
	}

	/**
	 * @param manilaSearchPkgMarkVOs the manilaSearchPkgMarkVOs to set
	 */
	public void setManilaSearchPkgMarkVOs(
			ManilaSearchPkgMarkVO[] manilaSearchPkgMarkVOs) {
		this.manilaSearchPkgMarkVOs = manilaSearchPkgMarkVOs;
	}

}
