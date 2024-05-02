/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0241Event.java
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

import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SIWebServiceVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0241 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0241HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jun Yong Jin
 * @see ESM_BKG_0241HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0241Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SIWebServiceVO sIWebServiceVO = null; 
	private String bkgRtFlg = null;
	

	public EsmBkg0241Event(){}

	public SIWebServiceVO getSIWebServiceVO() {
		return sIWebServiceVO;
	}

	public void setSIWebServiceVO(SIWebServiceVO sIWebServiceVO) {
		this.sIWebServiceVO = sIWebServiceVO;
	}

	public String getBkgRtFlg() {
		return bkgRtFlg;
	}

	public void setBkgRtFlg(String bkgRtFlg) {
		this.bkgRtFlg = bkgRtFlg;
	}
	
    

}