/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanContainterVO.java
*@FileTitle : SEA-NACCS: Manifest Data Download _ B/L List 화면에서 계약정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.05.18 김승민
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see ManifestListDetailVO
 */
public class KorCllSpclCgoContainerVO  extends ManifestListDetailVO{
	private static final long serialVersionUID = 1L;
	
	private List<CLLCDLManifestSpclCgoTotalByPodDetailVO> cLLCDLManifestSpclCgoTotalByPodDetailVOs;
	private List<KorCllSpclCgoDetailVO> korCllSpclCgoDetailVOs;
	private List<CLLCDLManifestVslSkdInfoVO>  cLLCDLManifestVslSkdInfoVOs;
	private List<SpclCgoEtcDetailVO>  spclCgoEtcDetailVOs;
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public KorCllSpclCgoContainerVO() {}
	
	public List<CLLCDLManifestSpclCgoTotalByPodDetailVO> getCLLCDLManifestSpclCgoTotalByPodDetailVOs() {
		return cLLCDLManifestSpclCgoTotalByPodDetailVOs;
	}
	
	public void setCLLCDLManifestSpclCgoTotalByPodDetailVOs(List<CLLCDLManifestSpclCgoTotalByPodDetailVO> cLLCDLManifestSpclCgoTotalByPodDetailVOs) {
		this.cLLCDLManifestSpclCgoTotalByPodDetailVOs = cLLCDLManifestSpclCgoTotalByPodDetailVOs;
	}	
	
	public List<KorCllSpclCgoDetailVO> getKorCllSpclCgoDetailVOs() {
		return korCllSpclCgoDetailVOs;
	}
	
	public void setKorCllSpclCgoDetailVO(List<KorCllSpclCgoDetailVO> korCllSpclCgoDetailVOs) {
		this.korCllSpclCgoDetailVOs = korCllSpclCgoDetailVOs;
	}
	
	public List<CLLCDLManifestVslSkdInfoVO> getCLLCDLManifestVslSkdInfoVOs() {
		return cLLCDLManifestVslSkdInfoVOs;
	}
	
	public void setCLLCDLManifestVslSkdInfoVOs(List<CLLCDLManifestVslSkdInfoVO> cLLCDLManifestVslSkdInfoVOs) {
		this.cLLCDLManifestVslSkdInfoVOs = cLLCDLManifestVslSkdInfoVOs;
	}	
	
	public List<SpclCgoEtcDetailVO> getSpclCgoEtcDetailVOs() {
		return spclCgoEtcDetailVOs;
	}
	
	public void setSpclCgoEtcDetailVOs(List<SpclCgoEtcDetailVO> spclCgoEtcDetailVOs) {
		this.spclCgoEtcDetailVOs = spclCgoEtcDetailVOs;
	}
}
