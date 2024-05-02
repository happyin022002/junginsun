/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_018Event.java
*@FileTitle : Off-dock CY Container List - Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-10
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2007-01-10 jongbaemoon
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.vo.OffdockCYInvoiceManageVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;

/**
 * ESD_TES_018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jongbaemoon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0018Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 조회 조건 및 단건 처리  */
	private OffdockCYInvoiceManageVO offdockCYInvoiceManageVO = null;
	
	/** TES_TML_SO_HDR Table  Value Object */
	private TesTmlSoHdrVO tesTmlSoHdrVO = null;	
	
	
	public EsdTes0018Event(){
	}
		
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
