/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RfaInformVO.java
*@FileTitle : RfaInformVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.30 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * UI_BKG_0739
 * RFA Information
 * RFA에 입력된 운임 정보(UI_BKG-0262 )
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class RfaInformOutVO {

	private RfaBkgInformVO rfaBkgInformVO = null;
	private RfaCustInformVO rfaCustInformVO = null;
	private List<RfaInformListVO> rfaInformListVOs = null;

	/**
	 * @return the rfaInformListVOs
	 */
	public List<RfaInformListVO> getRfaInformListVOs() {
		return rfaInformListVOs;
	}
	/**
	 * @param rfaInformListVOs the rfaInformListVOs to set
	 */
	public void setRfaInformListVOs(List<RfaInformListVO> rfaInformListVOs) {
		this.rfaInformListVOs = rfaInformListVOs;
	}
	/**
	 * @return the rfaBkgInformVO
	 */
	public RfaBkgInformVO getRfaBkgInformVO() {
		return rfaBkgInformVO;
	}
	/**
	 * @param rfaBkgInformVO the rfaBkgInformVO to set
	 */
	public void setRfaBkgInformVO(RfaBkgInformVO rfaBkgInformVO) {
		this.rfaBkgInformVO = rfaBkgInformVO;
	}
	/**
	 * @return the rfaCustInformVO
	 */
	public RfaCustInformVO getRfaCustInformVO() {
		return rfaCustInformVO;
	}
	/**
	 * @param rfaCustInformVO the rfaCustInformVO to set
	 */
	public void setRfaCustInformVO(RfaCustInformVO rfaCustInformVO) {
		this.rfaCustInformVO = rfaCustInformVO;
	}
}

