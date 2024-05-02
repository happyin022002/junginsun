/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalRqstMndVO.java
*@FileTitle : ExternalRqstMndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.08 전용진
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.util.List;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExternalRqstMndVO {

	private List<XterMndVO> xterMndVO = null;
	private XterXptLicVO xterXptLicVO = null;
	private List<KrXptLicNoVO> krXptLicNoVOs = null;
	private List<XptLicNoVO> IdXptLicNoVOs = null;
	
	private List<AlpsXptImpLicListVO> alpsXptImpLicListVOs = null;	

	private List<XterCntrPoNoVO> xterCntrPoNoVOs = null;
	private List<XterPoDtlVO> xterPoDtlVOs = null;
	
	private List<XterRefDtlVO> XterRefDtlVOs = null;
	
	public List<XterRefDtlVO> getXterRefDtlVOs() {
		return XterRefDtlVOs;
	}
	public void setXterRefDtlVOs(List<XterRefDtlVO> xterRefDtlVOs) {
		XterRefDtlVOs = xterRefDtlVOs;
	}
	public List<XterCntrPoNoVO> getXterCntrPoNoVOs() {
		return xterCntrPoNoVOs;
	}
	public void setXterCntrPoNoVOs(List<XterCntrPoNoVO> xterCntrPoNoVOs) {
		this.xterCntrPoNoVOs = xterCntrPoNoVOs;
	}
	public List<XterPoDtlVO> getXterPoDtlVOs() {
		return xterPoDtlVOs;
	}
	public void setXterPoDtlVOs(List<XterPoDtlVO> xterPoDtlVOs) {
		this.xterPoDtlVOs = xterPoDtlVOs;
	}
	public List<XterMndVO> getXterMndVO() {
		return xterMndVO;
	}
	public void setXterMndVO(List<XterMndVO> xterMndVO) {
		this.xterMndVO = xterMndVO;
	}	
	public XterXptLicVO getXterXptLicVO() {
		return xterXptLicVO;
	}
	public void setXterXptLicVO(XterXptLicVO xterXptLicVO) {
		this.xterXptLicVO = xterXptLicVO;
	}
	public List<KrXptLicNoVO> getKrXptLicNoVOs() {
		return krXptLicNoVOs;
	}
	public void setKrXptLicNoVOs(List<KrXptLicNoVO> krXptLicNoVOs) {
		this.krXptLicNoVOs = krXptLicNoVOs;
	}	
	public List<AlpsXptImpLicListVO> getAlpsXptImpLicListVOs() {
		return alpsXptImpLicListVOs;
	}
	public void setAlpsXptImpLicListVOs(
			List<AlpsXptImpLicListVO> alpsXptImpLicListVOs) {
		this.alpsXptImpLicListVOs = alpsXptImpLicListVOs;
	}
	public List<XptLicNoVO> getIdXptLicNoVOs() {
		return IdXptLicNoVOs;
	}
	public void setIdXptLicNoVOs(List<XptLicNoVO> idXptLicNoVOs) {
		IdXptLicNoVOs = idXptLicNoVOs;
	}

	
}
