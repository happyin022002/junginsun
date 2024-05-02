/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PanamaContainerVO.java
*@FileTitle : ACP Cargo Declaration – VVD Info 화면에서 계약정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.04.23 김승민
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

/**
 * HTTP Parser<br>
 * - 각 탭의 정보를 담을 통합 컨테이너 VO<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIMSEUNGMIN
 * @see EsmBkg0017Event 참조
 * @since J2EE 1.5
 */
public class PanamaContainerVO extends ManifestListDetailVO {
	
	private static final long serialVersionUID = 1L;
	
	private List<PanamaManifestListGeneralCargoDetailVO> panamaManifestListGeneralCargoDetailVOs;
	private List<PanamaManifestListEmptyCargoDetailVO> panamaManifestListEmptyCargoDetailVOs;
	private List<PanamaManifestListHazardousCargoDetailVO> panamaManifestListHazardCargoDetailVOs;
	private PanamaVesselVO panamaVesselVO;    
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public PanamaContainerVO() {}
	
	public List<PanamaManifestListGeneralCargoDetailVO> getPanamaManifestListGeneralCargoDetailVOs() {
		return panamaManifestListGeneralCargoDetailVOs;
	}
	
	public void setPanamaManifestListGeneralCargoDetailVOs(List<PanamaManifestListGeneralCargoDetailVO> panamaManifestListGeneralCargoDetailVOs) {
		this.panamaManifestListGeneralCargoDetailVOs = panamaManifestListGeneralCargoDetailVOs;
	}
	
	public List<PanamaManifestListEmptyCargoDetailVO> getPanamaManifestListEmptyCargoDetailVOs() {
		return panamaManifestListEmptyCargoDetailVOs;
	}
	
	public void setPanamaManifestListEmptyCargoDetailVOs(List<PanamaManifestListEmptyCargoDetailVO> panamaManifestListEmptyCargoDetailVOs) {
		this.panamaManifestListEmptyCargoDetailVOs = panamaManifestListEmptyCargoDetailVOs;
	}
	
	public List<PanamaManifestListHazardousCargoDetailVO> getPanamaManifestListHazardCargoDetailVOs() {
		return panamaManifestListHazardCargoDetailVOs;
	}
	
	public void setPanamaManifestListHazardCargoDetailVOs(List<PanamaManifestListHazardousCargoDetailVO> panamaManifestListHazardCargoDetailVOs) {
		this.panamaManifestListHazardCargoDetailVOs = panamaManifestListHazardCargoDetailVOs;
	}
	
	public PanamaVesselVO getPanamaVesselVO() {
		return panamaVesselVO;
	}
	
	public void setPanamaVesselVO(PanamaVesselVO panamaVesselVO) {
		this.panamaVesselVO = panamaVesselVO;
	}


}
