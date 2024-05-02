/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BrazilContainerVO.java
*@FileTitle : Manifest Generation 화면에서 배정보, bl정보, 컨테이너 정보를 담는 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.06
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.04.23 경종윤
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0296Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;

/**
 * HTTP Parser<br>
 * - 각 탭의 정보를 담을 통합 컨테이너 VO<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kyoung Jong Yun
 * @see EsmBkg0296Event 참조
 * @since J2EE 1.6
 */
public class IndiaContainerSaveVO extends ManifestModificationVO {

	private static final long serialVersionUID = 1L;

	private IndiaIgmModiVO[] indiaIgmModiVOList = null;
	private IndiaIgmCntrModiVO[] indiaIgmCntrModiVOList = null;
	/**
	 * @return the indiaIgmModiVOList
	 */
	public IndiaIgmModiVO[] getIndiaIgmModiVOList() {
		return indiaIgmModiVOList;
	}
	/**
	 * @param indiaIgmModiVOList the indiaIgmModiVOList to set
	 */
	public void setIndiaIgmModiVOList(IndiaIgmModiVO[] indiaIgmModiVOList) {
		this.indiaIgmModiVOList = indiaIgmModiVOList;
	}
	/**
	 * @return the indiaIgmCntrModiVOList
	 */
	public IndiaIgmCntrModiVO[] getIndiaIgmCntrModiVOList() {
		return indiaIgmCntrModiVOList;
	}
	/**
	 * @param indiaIgmCntrModiVOList the indiaIgmCntrModiVOList to set
	 */
	public void setIndiaIgmCntrModiVOList(
			IndiaIgmCntrModiVO[] indiaIgmCntrModiVOList) {
		this.indiaIgmCntrModiVOList = indiaIgmCntrModiVOList;
	}
	
	

	
	
	
}
