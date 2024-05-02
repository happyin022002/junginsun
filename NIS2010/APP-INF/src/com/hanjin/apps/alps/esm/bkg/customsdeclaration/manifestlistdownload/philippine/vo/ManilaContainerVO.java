/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManilaContainerVO.java
*@FileTitle : ACP Cargo Declaration – VVD Info 화면에서 계약정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.19 임재택
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.event.EsmBkg0234Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

/**
 * HTTP Parser<br>
 * - 각 탭의 정보를 담을 통합 컨테이너 VO<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author LIM JAE TAEK
 * @see EsmBkg0234Event 참조
 * @since J2EE 1.5
 */
public class ManilaContainerVO extends ManifestListDetailVO {
	
	private static final long serialVersionUID = 1L;
	
	
	private List<ManilaSearchCheckPodVO> manilaSearchCheckPodVOs;
	private List<ManilaSearchCheckPolVO> manilaSearchCheckPolVOs;
	private List<ManilaSearchCheckVvdVO> manilaSearchCheckVvdVOs;
	
	private List<ManilaSearchVvdDtlVO> manilasearchVvdDtlVOs;
	private List<ManilaSearchBlInfoVO> manilaSearchBlInfoVOs;
	private List<ManilaSearchCntrInfoVO> manilaSearchCntrInfoVOs;
	private List<ManilaSearchPkgDescVO> manilaSearchPkgDescVOs;
	private List<ManilaSearchPkgDescTempVO> manilaSearchPkgDescTempVOs;
	private List<ManilaSearchPkgMarkVO> manilaSearchPkgMarkVOs;
	private List<ManilaSearchPkgMarkTempVO> manilaSearchPkgMarkTempVOs;
	
	private List<ManilaSearchCtnVO> manilaSearchCtnVOS;
	private List<ManilaSearchGenVO> manilaSearchGenVOS;
	private List<ManilaSearchBolVO> manilaSearchBolVOS;
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public ManilaContainerVO() {}
	
	public List<ManilaSearchCheckPodVO> getManilaSearchCheckPodVOs() {
		return manilaSearchCheckPodVOs;
	}
	public List<ManilaSearchCheckPolVO> getManilaSearchCheckPolVOs() {
		return manilaSearchCheckPolVOs;
	}
	public List<ManilaSearchCheckVvdVO> getManilaSearchCheckVvdVOs() {
		return manilaSearchCheckVvdVOs;
	}
	
	public List<ManilaSearchVvdDtlVO> getManilasearchVvdDtlVOs() {
		return manilasearchVvdDtlVOs;
	}
	public List<ManilaSearchBlInfoVO> getManilaSearchBlInfoVOs() {
		return manilaSearchBlInfoVOs;
	}
	public List<ManilaSearchCntrInfoVO> getManilaSearchCntrInfoVOs() {
		return manilaSearchCntrInfoVOs;
	}
	public List<ManilaSearchPkgDescVO> getManilaSearchPkgDescVOs() {
		return manilaSearchPkgDescVOs;
	}
	public List<ManilaSearchPkgDescTempVO> getManilaSearchPkgDescTempVOs() {
		return manilaSearchPkgDescTempVOs;
	}
	public List<ManilaSearchPkgMarkVO> getManilaSearchPkgMarkVOs() {
		return manilaSearchPkgMarkVOs;
	}
	public List<ManilaSearchPkgMarkTempVO> getManilaSearchPkgMarkTempVOs() {
		return manilaSearchPkgMarkTempVOs;
	}
	
	
	public void setManilaSearchCheckPodVOs(List<ManilaSearchCheckPodVO> manilaSearchCheckPodVOs) {
		this.manilaSearchCheckPodVOs = manilaSearchCheckPodVOs;
	}
	public void setManilaSearchCheckPolVOs(List<ManilaSearchCheckPolVO> manilaSearchCheckPolVOs) {
		this.manilaSearchCheckPolVOs = manilaSearchCheckPolVOs;
	}
	public void setManilaSearchCheckVvdVOs(List<ManilaSearchCheckVvdVO> manilaSearchCheckVvdVOs) {
		this.manilaSearchCheckVvdVOs = manilaSearchCheckVvdVOs;
	}
	
	public void setManilasearchVvdDtlVOs(List<ManilaSearchVvdDtlVO> manilasearchVvdDtlVOs) {
		this.manilasearchVvdDtlVOs = manilasearchVvdDtlVOs;
	}
	public void setManilaSearchBlInfoVOs(List<ManilaSearchBlInfoVO> manilaSearchBlInfoVOs) {
		this.manilaSearchBlInfoVOs = manilaSearchBlInfoVOs;
	}
	public void setManilaSearchCntrInfoVOs(List<ManilaSearchCntrInfoVO> manilaSearchCntrInfoVOs) {
		this.manilaSearchCntrInfoVOs = manilaSearchCntrInfoVOs;
	}
	public void setManilaSearchPkgDescVOs(List<ManilaSearchPkgDescVO> manilaSearchPkgDescVOs) {
		this.manilaSearchPkgDescVOs = manilaSearchPkgDescVOs;
	}
	public void setManilaSearchPkgDescTempVOs(List<ManilaSearchPkgDescTempVO> manilaSearchPkgDescTempVOs) {
		this.manilaSearchPkgDescTempVOs = manilaSearchPkgDescTempVOs;
	}
	public void setManilaSearchPkgMarkVOs(List<ManilaSearchPkgMarkVO> manilaSearchPkgMarkVOs) {
		this.manilaSearchPkgMarkVOs = manilaSearchPkgMarkVOs;
	}
	public void setManilaSearchPkgTempMarkVOs(List<ManilaSearchPkgMarkTempVO> manilaSearchPkgMarkTempVOs) {
		this.manilaSearchPkgMarkTempVOs = manilaSearchPkgMarkTempVOs;
	}
	
	public List<ManilaSearchCtnVO> getManilaSearchCtnVOS() {
		return manilaSearchCtnVOS;
	}

	public void setManilaSearchCtnVOS(List<ManilaSearchCtnVO> manilaSearchCtnVOS) {
		this.manilaSearchCtnVOS = manilaSearchCtnVOS;
	}

	public List<ManilaSearchGenVO> getManilaSearchGenVOS() {
		return manilaSearchGenVOS;
	}

	public void setManilaSearchGenVOS(List<ManilaSearchGenVO> manilaSearchGenVOS) {
		this.manilaSearchGenVOS = manilaSearchGenVOS;
	}

	public List<ManilaSearchBolVO> getManilaSearchBolVOS() {
		return manilaSearchBolVOS;
	}

	public void setManilaSearchBolVOS(List<ManilaSearchBolVO> manilaSearchBolVOS) {
		this.manilaSearchBolVOS = manilaSearchBolVOS;
	}
	
}
