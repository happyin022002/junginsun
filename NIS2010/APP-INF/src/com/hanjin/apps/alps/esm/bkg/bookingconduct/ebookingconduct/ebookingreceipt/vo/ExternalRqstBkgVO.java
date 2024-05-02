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

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.util.List;

//import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;

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
//	private AlpsBkgVO alpsBkgVO = null;
//	private List<AlpsQtyVO> alpsQtyVO = null;
//	private List<VslSkdVO> vslSkdVO = null;
//	private List<AlpsQtyDtlVO> alpsQtyDtlVO = null;
	
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
//	public AlpsBkgVO getAlpsBkgVO() {
//		return alpsBkgVO;
//	}
//	public void setAlpsBkgVO(AlpsBkgVO alpsBkgVO) {
//		this.alpsBkgVO = alpsBkgVO;
//	}
//	public List<AlpsQtyVO> getAlpsQtyVO() {
//		return alpsQtyVO;
//	}
//	public void setAlpsQtyVO(List<AlpsQtyVO> alpsQtyVO) {
//		this.alpsQtyVO = alpsQtyVO;
//	}
//	public List<VslSkdVO> getVslSkdVO() {
//		return vslSkdVO;
//	}
//	public void setVslSkdVO(List<VslSkdVO> vslSkdVO) {
//		this.vslSkdVO = vslSkdVO;
//	}
//	public List<AlpsQtyDtlVO> getAlpsQtyDtlVO() {
//		return alpsQtyDtlVO;
//	}
//	public void setAlpsQtyDtlVO(List<AlpsQtyDtlVO> alpsQtyDtlVO) {
//		this.alpsQtyDtlVO = alpsQtyDtlVO;
//	}
}
