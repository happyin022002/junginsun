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

public class ExternalRqstDgVO {

	private List<AlpsDgVO> nisDgVO = null;
	private List<BkgXterDgCgoVO> bkgXterDgCgoVO = null;
	private List<AlpsCntrTpszVO> alpsCntrTpszVO = null;

	public List<AlpsDgVO> getNisDgVO() {
		return nisDgVO;
	}
	public void setNisDgVO(List<AlpsDgVO> nisDgVO) {
		this.nisDgVO = nisDgVO;
	}
	public List<BkgXterDgCgoVO> getBkgXterDgCgoVO() {
		return bkgXterDgCgoVO;
	}
	public void setBkgXterDgCgoVO(List<BkgXterDgCgoVO> bkgXterDgCgoVO) {
		this.bkgXterDgCgoVO = bkgXterDgCgoVO;
	}
	public List<AlpsCntrTpszVO> getAlpsCntrTpszVO() {
		return alpsCntrTpszVO;
	}
	public void setAlpsCntrTpszVO(List<AlpsCntrTpszVO> alpsCntrTpszVO) {
		this.alpsCntrTpszVO = alpsCntrTpszVO;
	}

}
