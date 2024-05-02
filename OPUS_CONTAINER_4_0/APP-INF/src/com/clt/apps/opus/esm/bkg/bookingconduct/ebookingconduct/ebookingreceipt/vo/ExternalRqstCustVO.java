/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalRqstCustVO.java
*@FileTitle : ExternalRqstCustVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.08 전용진
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExternalRqstCustVO {

//	private BlDocCustVO blDocCustVO = null;
	private BkgXterCustVO bkgXterCustVO = null;

//	public BlDocCustVO getBlDocCustVO() {
//		return blDocCustVO;
//	}
//	public void setBlDocCustVO(BlDocCustVO blDocCustVO) {
//		this.blDocCustVO = blDocCustVO;
//	}
	public BkgXterCustVO getBkgXterCustVO() {
		return bkgXterCustVO;
	}
	public void setBkgXterCustVO(BkgXterCustVO bkgXterCustVO) {
		this.bkgXterCustVO = bkgXterCustVO;
	}
	
//	/* CustEtcVO Start  */
//	private CustEtcVO custEtcVO = null;
//
//
//	public void setCustEtcVO(CustEtcVO custEtcVO) {
//		this.custEtcVO = custEtcVO;
//	}
//
//	public CustEtcVO getCustEtcVO() {
//		return custEtcVO;
//	}
	/* CustEtcVO End  */	
}
