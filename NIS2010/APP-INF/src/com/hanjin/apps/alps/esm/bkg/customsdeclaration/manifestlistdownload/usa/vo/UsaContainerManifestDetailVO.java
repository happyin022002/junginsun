/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaContainerManifestDetailVO.java
*@FileTitle : UsaContainerManifestDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0036Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

/**
 * HTTP Parser<br>
 * - 여러 개의 시트 정보를 담을 통합 컨테이너 VO<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Subin
 * @see EsmBkg0036Event 참조
 * @since J2EE 1.5
 */
public class UsaContainerManifestDetailVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 1L;

	public UsaContainerManifestDetailVO() {}
	
	String blNo = null;

	List<UsaContainerManifestInfoVO> usaCntrManifestInfoVOs = null;
	List<UsaContainerListVO> UsaContainerListVOs = null;
	List<UsaContainerManifestListVO> UsaCntrManifestListVOs = null;
	
	public String getBlNo() {
		return blNo;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	/**
	 * @return the usaCntrManifestInfoVO
	 */
	public List<UsaContainerManifestInfoVO> getUsaCntrManifestInfoVOs() {
		return usaCntrManifestInfoVOs;
	}
	/**
	 * @param usaCntrManifestInfoVO the usaCntrManifestInfoVO to set
	 */
	public void setUsaCntrManifestInfoVOs(
			List<UsaContainerManifestInfoVO> usaCntrManifestInfoVOs) {
		this.usaCntrManifestInfoVOs = usaCntrManifestInfoVOs;
	}
	/**
	 * @return the usaContainerListVOs
	 */
	public List<UsaContainerListVO> getUsaContainerListVOs() {
		return UsaContainerListVOs;
	}
	/**
	 * @param usaContainerListVOs the usaContainerListVOs to set
	 */
	public void setUsaContainerListVOs(List<UsaContainerListVO> usaContainerListVOs) {
		UsaContainerListVOs = usaContainerListVOs;
	}
	/**
	 * @return the usaCntrManifestListVOs
	 */
	public List<UsaContainerManifestListVO> getUsaCntrManifestListVOs() {
		return UsaCntrManifestListVOs;
	}
	/**
	 * @param usaCntrManifestListVOs the usaCntrManifestListVOs to set
	 */
	public void setUsaCntrManifestListVOs(
			List<UsaContainerManifestListVO> usaCntrManifestListVOs) {
		UsaCntrManifestListVOs = usaCntrManifestListVOs;
	}

}
