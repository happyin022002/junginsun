/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EsdEas0323Event.java
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
import com.hanjin.apps.alps.esd.eas.expnaud.mnraud.vo.HbarInquiryByHistoryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0323 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0323HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0323HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0323Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	HbarInquiryByHistoryVO hbarInquiryByHistoryVO = null;
	
	public EsdEas0323Event(){}
	
	// HbarInquiryByHistoryVO
	public HbarInquiryByHistoryVO getHbarInquiryByHistoryVO() {
		return hbarInquiryByHistoryVO;
	}

	public void setHbarInquiryByHistoryVO(HbarInquiryByHistoryVO hbarInquiryByHistoryVO) {
		this.hbarInquiryByHistoryVO = hbarInquiryByHistoryVO;
	}

}