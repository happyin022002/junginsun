/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestListContainerVO.java
*@FileTitle : Customs Data Download
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.05.20 이수빈
* 1.0 최초 생성
* 
* 2011.06.01 민정호 [CHM-201111028] AMS - Customs Data Download (D/L) 화면 validation추가
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0210Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

/**
 * HTTP Parser<br>
 * - 여러 개의 시트 정보를 담을 통합 컨테이너 VO<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Subin
 * @see EsmBkg0210Event 참조
 * @since J2EE 1.5
 */
public class UsaManifestListContainerVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 1L;

	public UsaManifestListContainerVO() {}
	
	List<UsaDownloadSummaryVO> usaManifestListDownloadVO = null;
	List<UsaManifestListDetailVO> usaManifestListDownloadDetailVO = null;
	List<UsaManifestListDownloadCntrVO> usaManifestListDownloadCntrVO = null;
	
	List<UsaManifestSearchDetailVO> usaManifestSearchDetailVO = null;
	List<UsaManifestSummaryVO> usaManifestSummaryVO = null;
	List<UsaBkgCmVO> usaBkgCmVO = null;
	
	public List<UsaDownloadSummaryVO> getUsaManifestListDownloadVO() {
		return usaManifestListDownloadVO;
	}
	public void setUsaManifestListDownloadVO(
			List<UsaDownloadSummaryVO> usaManifestListDownloadVO) {
		this.usaManifestListDownloadVO = usaManifestListDownloadVO;
	}
	public List<UsaManifestListDetailVO> getUsaManifestListDownloadDetailVO() {
		return usaManifestListDownloadDetailVO;
	}
	public void setUsaManifestListDownloadDetailVO(
			List<UsaManifestListDetailVO> usaManifestListDownloadDetailVO) {
		this.usaManifestListDownloadDetailVO = usaManifestListDownloadDetailVO;
	}
	/**
	 * @return the usaManifestListDownloadCntrVO
	 */
	public List<UsaManifestListDownloadCntrVO> getUsaManifestListDownloadCntrVO() {
		return usaManifestListDownloadCntrVO;
	}
	/**
	 * @param usaManifestListDownloadCntrVO the usaManifestListDownloadCntrVO to set
	 */
	public void setUsaManifestListDownloadCntrVO(
			List<UsaManifestListDownloadCntrVO> usaManifestListDownloadCntrVO) {
		this.usaManifestListDownloadCntrVO = usaManifestListDownloadCntrVO;
	}
	public List<UsaManifestSearchDetailVO> getUsaManifestSearchDetailVO() {
		return usaManifestSearchDetailVO;
	}
	public void setUsaManifestSearchDetailVO(
			List<UsaManifestSearchDetailVO> usaManifestSearchDetailVO) {
		this.usaManifestSearchDetailVO = usaManifestSearchDetailVO;
	}
	public List<UsaManifestSummaryVO> getUsaManifestSummaryVO() {
		return usaManifestSummaryVO;
	}
	public void setUsaManifestSummaryVO(
			List<UsaManifestSummaryVO> usaManifestSummaryVO) {
		this.usaManifestSummaryVO = usaManifestSummaryVO;
	}
	
	
	public List<UsaBkgCmVO> getUsaBkgCmVO() {
		return usaBkgCmVO;
	}	
	public void setUsaBkgCmVO(
			List<UsaBkgCmVO> usaBkgCmVO ) {
		this.usaBkgCmVO = usaBkgCmVO;
	}	
}
