/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BrazilContainerVO.java
*@FileTitle : Manifest Generation 화면에서  정보를 담는 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.06
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.23 임재택
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;

/**
 * HTTP Parser<br>
 * - 각 탭의 정보를 담을 통합 컨테이너 VO<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lim Jae taek
 * @see EsmBkg0296Event 참조
 * @since J2EE 1.6
 */
public class RocsContainerSaveVO extends ManifestModificationVO {

	private static final long serialVersionUID = 1L;

	private RocsSearchCntrListVO[] RocsSearchCntrListVOList = null;
	private RocsSearchCargoDetailVO[] RocsSearchCargoDetailVOList = null;
	
	private RocsBlModificationVO RocsBlModificationVO = null;
	 
	public RocsSearchCntrListVO[] getRocsSearchCntrListVOList() {
		return RocsSearchCntrListVOList;
	}
	public RocsBlModificationVO getRocsBlModificationVO() {
		return RocsBlModificationVO;
	}
	 
	public void setRocsSearchCntrListVOList(RocsSearchCntrListVO[] rocsSearchCntrListVOList) {
		RocsSearchCntrListVOList = rocsSearchCntrListVOList;
	}
	public void setRocsBlModificationVO(RocsBlModificationVO rocsBlModificationVO) {
		RocsBlModificationVO = rocsBlModificationVO;
	}
	 
	public RocsSearchCargoDetailVO[] getRocsSearchCargoDetailVOList() {
		return RocsSearchCargoDetailVOList;
	}
	 
	public void setRocsSearchCargoDetailVOList(
			RocsSearchCargoDetailVO[] rocsSearchCargoDetailVOList) {
		RocsSearchCargoDetailVOList = rocsSearchCargoDetailVOList;
	}

	
	
	
}
