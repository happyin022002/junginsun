/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManilaContainerSaveVO.java
*@FileTitle : ACP Cargo Declaration – VVD Info 화면에서 계약정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.19 임재택
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.philippine.event.EsmBkg0234Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

/**
 * HTTP Parser<br>
 * - 각 탭의 정보를 담을 통합 컨테이너 VO<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author LIM JAE TAEK
 * @see EsmBkg0234Event 참조
 * @since J2EE 1.5
 */
public class ManilaContainerSaveVO extends ManifestListDetailVO {
	
	private static final long serialVersionUID = 1L;
	
	private ManilaManifestListCondVO manilaManifestListCondVO = null;
	private ManilaSearchVvdDtlVO[] manilasearchVvdDtlVOs = null;
	private ManilaSearchBlInfoVO[] manilaSearchBlInfoVOs = null;
	private ManilaSearchCntrInfoVO[] manilaSearchCntrInfoVOs = null;
	private ManilaSearchPkgDescVO[] manilaSearchPkgDescVOs = null;
	private ManilaSearchPkgMarkVO[] manilaSearchPkgMarkVOs = null;
	
	/**
	 * @return the manilaManifestListCondVO
	 */
	public ManilaManifestListCondVO getManilaManifestListCondVO() {
		return manilaManifestListCondVO;
	}
	/**
	 * @param manilaManifestListCondVO the manilaManifestListCondVO to set
	 */
	public void setManilaManifestListCondVO(
			ManilaManifestListCondVO manilaManifestListCondVO) {
		this.manilaManifestListCondVO = manilaManifestListCondVO;
	}
	/**
	 * @return the manilasearchVvdDtlVO
	 */
	public ManilaSearchVvdDtlVO[] getManilasearchVvdDtlVO() {
		return manilasearchVvdDtlVOs;
	}
	/**
	 * @param manilasearchVvdDtlVO the manilasearchVvdDtlVO to set
	 */
	public void setManilasearchVvdDtlVO(ManilaSearchVvdDtlVO[] manilasearchVvdDtlVO) {
		this.manilasearchVvdDtlVOs = manilasearchVvdDtlVO;
	}
	/**
	 * @return the manilaSearchBlInfoVO
	 */
	public ManilaSearchBlInfoVO[] getManilaSearchBlInfoVO() {
		return manilaSearchBlInfoVOs;
	}
	/**
	 * @param manilaSearchBlInfoVO the manilaSearchBlInfoVO to set
	 */
	public void setManilaSearchBlInfoVO(ManilaSearchBlInfoVO[] manilaSearchBlInfoVO) {
		this.manilaSearchBlInfoVOs = manilaSearchBlInfoVO;
	}
	/**
	 * @return the manilaSearchCntrInfoVO
	 */
	public ManilaSearchCntrInfoVO[] getManilaSearchCntrInfoVO() {
		return manilaSearchCntrInfoVOs;
	}
	/**
	 * @param manilaSearchCntrInfoVO the manilaSearchCntrInfoVO to set
	 */
	public void setManilaSearchCntrInfoVO(
			ManilaSearchCntrInfoVO[] manilaSearchCntrInfoVO) {
		this.manilaSearchCntrInfoVOs = manilaSearchCntrInfoVO;
	}
	/**
	 * @return the manilaSearchPkgDescVO
	 */
	public ManilaSearchPkgDescVO[] getManilaSearchPkgDescVO() {
		return manilaSearchPkgDescVOs;
	}
	/**
	 * @param manilaSearchPkgDescVO the manilaSearchPkgDescVO to set
	 */
	public void setManilaSearchPkgDescVO(
			ManilaSearchPkgDescVO[] manilaSearchPkgDescVO) {
		this.manilaSearchPkgDescVOs = manilaSearchPkgDescVO;
	}
	/**
	 * @return the manilaSearchPkgMarkVO
	 */
	public ManilaSearchPkgMarkVO[] getManilaSearchPkgMarkVO() {
		return manilaSearchPkgMarkVOs;
	}
	/**
	 * @param manilaSearchPkgMarkVO the manilaSearchPkgMarkVO to set
	 */
	public void setManilaSearchPkgMarkVO(
			ManilaSearchPkgMarkVO[] manilaSearchPkgMarkVO) {
		this.manilaSearchPkgMarkVOs = manilaSearchPkgMarkVO;
	}
	 
}
