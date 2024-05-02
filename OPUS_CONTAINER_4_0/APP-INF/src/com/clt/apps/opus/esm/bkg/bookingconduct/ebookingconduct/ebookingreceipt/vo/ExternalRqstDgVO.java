/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalRqstDgVO.java
*@FileTitle : ExternalRqstDgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.08 전용진
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.util.List;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExternalRqstDgVO {

	private List<OpusDgVO> opusDgVO = null;
	private List<BkgXterDgCgoVO> bkgXterDgCgoVO = null;
	private List<OpusCntrTpszVO> opusCntrTpszVO = null;

	public List<OpusDgVO> getOpusDgVO() {
		return opusDgVO;
	}
	public void setOpusDgVO(List<OpusDgVO> opusDgVO) {
		this.opusDgVO = opusDgVO;
	}
	public List<BkgXterDgCgoVO> getBkgXterDgCgoVO() {
		return bkgXterDgCgoVO;
	}
	public void setBkgXterDgCgoVO(List<BkgXterDgCgoVO> bkgXterDgCgoVO) {
		this.bkgXterDgCgoVO = bkgXterDgCgoVO;
	}
	public List<OpusCntrTpszVO> getOpusCntrTpszVO() {
		return opusCntrTpszVO;
	}
	public void setOpusCntrTpszVO(List<OpusCntrTpszVO> opusCntrTpszVO) {
		this.opusCntrTpszVO = opusCntrTpszVO;
	}

}
