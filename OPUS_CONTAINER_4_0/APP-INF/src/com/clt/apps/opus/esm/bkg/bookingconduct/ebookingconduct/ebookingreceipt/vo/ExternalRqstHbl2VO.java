/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExternalRqstHbl2VO.java
*@FileTitle : ExternalRqstHbl2VO
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

public class ExternalRqstHbl2VO {

	private List<BkgUsaCstmsFileNoVO> bkgUsaCstmsFileNoVO = null;
	private List<XterUsaCstmsFileNoVO> xterUsaCstmsFileNoVO = null;

	public List<BkgUsaCstmsFileNoVO> getBkgUsaCstmsFileNoVO() {
		return bkgUsaCstmsFileNoVO;
	}
	public void setBkgUsaCstmsFileNoVO(List<BkgUsaCstmsFileNoVO> bkgUsaCstmsFileNoVO) {
		this.bkgUsaCstmsFileNoVO = bkgUsaCstmsFileNoVO;
	}
	public List<XterUsaCstmsFileNoVO> getXterUsaCstmsFileNoVO() {
		return xterUsaCstmsFileNoVO;
	}
	public void setXterUsaCstmsFileNoVO(
			List<XterUsaCstmsFileNoVO> xterUsaCstmsFileNoVO) {
		this.xterUsaCstmsFileNoVO = xterUsaCstmsFileNoVO;
	}

}
