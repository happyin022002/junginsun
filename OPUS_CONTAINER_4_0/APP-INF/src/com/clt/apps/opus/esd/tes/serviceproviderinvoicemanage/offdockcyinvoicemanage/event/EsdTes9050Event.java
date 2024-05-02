/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_905Event.java
*@FileTitle : Off-dock CY Invoice의 Total Amount 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-13
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-13 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event;

import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.vo.OffdockCYInvoiceManageVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_905 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_905HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9050Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 조회 조건 및 단건 처리  */
	private OffdockCYInvoiceManageVO offdockCYInvoiceManageVO = null;
	
	/** TES_TML_SO_HDR Table  Value Object */
	private TesTmlSoHdrVO tesTmlSoHdrVO = null;

	public void setOffdockCYInvoiceManageVO(OffdockCYInvoiceManageVO offdockCYInvoiceManageVO){
		this.offdockCYInvoiceManageVO = offdockCYInvoiceManageVO;
	}
	
	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO){
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}	

	public OffdockCYInvoiceManageVO getOffdockCYInvoiceManageVO(){
		return offdockCYInvoiceManageVO;
	}	
	
	public TesTmlSoHdrVO getTesTmlSoHdrVO(){
		return tesTmlSoHdrVO;
	}	
}
