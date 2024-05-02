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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see ManifestListDetailVO
 */
public class RocsManifestListTransmitDetailVO  extends ManifestTransmitDetailVO{
	private static final long serialVersionUID = 1L;
	
	private String fliatFile = null;
	private List<RocsManifestTransmitVO> rocsManifestTransmitVOs;
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public RocsManifestListTransmitDetailVO() {}
	
	public List<RocsManifestTransmitVO> getRocsManifestTransmitVOs() {
		return rocsManifestTransmitVOs;
	}
	
	public void setRocsManifestTransmitVOs(List<RocsManifestTransmitVO> rocsManifestTransmitVOs) {
		this.rocsManifestTransmitVOs = rocsManifestTransmitVOs;
	}	
	
	public String getFliatFile() {
		return fliatFile;
	}
	
	public void setFliatFile(String fliatFile) {
		this.fliatFile = fliatFile;
	}
}
