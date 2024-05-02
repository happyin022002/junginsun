/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_004Event.java
*@FileTitle : Off-dock CY Invoice 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-22
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-09-22 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.vo.OffdockCYInvoiceManageVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_903Event에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_903HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9075Event extends EventSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 조회 조건 및 단건 처리  */
	private OffdockCYInvoiceManageVO offdockCYInvoiceManageVO = null;
	
	/** TES_TML_SO_HDR Table  Value Object */
	private TesTmlSoHdrVO tesTmlSoHdrVO = null;	
		
	public OffdockCYInvoiceManageVO getOffdockCYInvoiceManageVO() {
		return offdockCYInvoiceManageVO;
	}

	public void setOffdockCYInvoiceManageVO(OffdockCYInvoiceManageVO offdockCYInvoiceManageVO) {
		this.offdockCYInvoiceManageVO = offdockCYInvoiceManageVO;
	}

	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}	

}