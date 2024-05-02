/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EesMnr0211Event.java
 *@FileTitle : Tire Purchase W/O Inquiry - Popup
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.07
 *@LastModifier : 정영훈 
 *@LastVersion : 1.0
 * 2009.07.07 정영훈
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.WONoInquiryListGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESS_MNR_0211 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESS_MNR_0211HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author 정영훈
 * @see EES_MNR_0211HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesMnr0211Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private WONoInquiryListGRPVO wONoInquiryListGRPVO = null;

	public EesMnr0211Event() {
	}

	public WONoInquiryListGRPVO getWONoInquiryListGRPVO() {
		return wONoInquiryListGRPVO;
	}

	public void setWONoInquiryListGRPVO(WONoInquiryListGRPVO noInquiryListGRPVO) {
		wONoInquiryListGRPVO = noInquiryListGRPVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
}