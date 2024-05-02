/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0309Event.java
*@FileTitle : Rehandling(BKG COD)
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 김현주
*@LastVersion : 1.0
* 2015.03.12 김현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.mnraud.event;
import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.vo.HbarInquiryByBkgVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0309 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0309HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0309HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0309Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	HbarInquiryByBkgVO hbarInquiryByBkgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	HbarInquiryByBkgVO[] hbarInquiryByBkgVOs = null;

	public EsdEas0309Event(){}
	
	// HbarInquiryByBkgVO
	public HbarInquiryByBkgVO getHbarInquiryByBkgVO() {
		return hbarInquiryByBkgVO;
	}

	public void setHbarInquiryByBkgVO(HbarInquiryByBkgVO hbarInquiryByBkgVO) {
		this.hbarInquiryByBkgVO = hbarInquiryByBkgVO;
	}

	public HbarInquiryByBkgVO[] getHbarInquiryByBkgVOs() {
		return hbarInquiryByBkgVOs;
	}

	public void setHbarInquiryByBkgVOs(HbarInquiryByBkgVO[] hbarInquiryByBkgVOs) {
		this.hbarInquiryByBkgVOs = hbarInquiryByBkgVOs;
	}
}