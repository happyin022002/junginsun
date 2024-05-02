/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalRqstBkgVO.java
*@FileTitle : ExternalRqstBkgVO
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

//import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExternalRqstBkgVO {

	private XterRqstMstVO xterRqstMstVO = null;
	private List<BkgXterQtyVO> bkgXterQtyVO = null;
	private XterRqstTabVO xterRqstTabVO = null;
	
	public XterRqstMstVO getXterRqstMstVO() {
		return xterRqstMstVO;
	}
	public void setXterRqstMstVO(XterRqstMstVO xterRqstMstVO) {
		this.xterRqstMstVO = xterRqstMstVO;
	}
	public List<BkgXterQtyVO> getBkgXterQtyVO() {
		return bkgXterQtyVO;
	}
	public void setBkgXterQtyVO(List<BkgXterQtyVO> bkgXterQtyVO) {
		this.bkgXterQtyVO = bkgXterQtyVO;
	}
	public XterRqstTabVO getXterRqstTabVO() {
		return xterRqstTabVO;
	}
	public void setXterRqstTabVO(XterRqstTabVO xterRqstTabVO) {
		this.xterRqstTabVO = xterRqstTabVO;
	}
}
