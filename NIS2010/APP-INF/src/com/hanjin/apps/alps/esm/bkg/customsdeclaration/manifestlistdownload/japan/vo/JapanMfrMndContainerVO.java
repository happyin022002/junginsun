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
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrMndModificationVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see MfrMndModificationVO
 */
public class JapanMfrMndContainerVO  extends MfrMndModificationVO{
	private static final long serialVersionUID = 1L;
	
	private JapanMfrMndModificationVO[] japanMfrMndModificationVOs;
	private JapanMfrMndCondVO  japanMfrMndCondVO;
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public JapanMfrMndContainerVO() {}
	
	public JapanMfrMndModificationVO[] getJapanMfrMndModificationVOs() {
		return japanMfrMndModificationVOs;
	}
	
	public void setJapanMfrMndModificationVOs(JapanMfrMndModificationVO[] japanMfrMndModificationVOs) {
		this.japanMfrMndModificationVOs = japanMfrMndModificationVOs;
	}	
	
	public JapanMfrMndCondVO getJapanMfrMndCondVO() {
		return japanMfrMndCondVO;
	}
	
	public void setJapanMfrMndCondVO(JapanMfrMndCondVO japanMfrMndCondVO) {
		this.japanMfrMndCondVO = japanMfrMndCondVO;
	}	
}
