/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0231Event.java
*@FileTitle : e-Booking & SI Process - Copy Option
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.07.03 전용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0231 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0231HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0231HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0231Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private XterRqstNoVO xterRqstNoVO= null;

	public EsmBkg0231Event(){}

	public XterRqstNoVO getXterRqstNoVO() {
		return xterRqstNoVO;
	}

	public void setXterRqstNoVO(XterRqstNoVO xterRqstNoVO) {
		this.xterRqstNoVO = xterRqstNoVO;
	}

}