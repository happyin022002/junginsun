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
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;
/**
 * ESD_TES_004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0004Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/** 조회 조건 및 단건 처리  */
	private OffdockCYInvoiceManageVO offdockCYInvoiceManageVO = null;
	
	private TesTmlSoHdrVO tesTmlSoHdrVO = null;
	private TesTmlSoHdrVO[] tesTmlSoHdrVOs = null;	
	
	private TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
	private TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = null;
	
	private TesTmlSoDtlVO tesTmlSoDtlVO = null;
	private TesTmlSoDtlVO[] tesTmlSoDtlVOs = null;
	
	public OffdockCYInvoiceManageVO getOffdockCYInvoiceManageVO() {
		return offdockCYInvoiceManageVO;
	}

	public void setOffdockCYInvoiceManageVO(
			OffdockCYInvoiceManageVO offdockCYInvoiceManageVO) {
		this.offdockCYInvoiceManageVO = offdockCYInvoiceManageVO;
	}

	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}

	public TesTmlSoCntrListVO getTesTmlSoCntrListVO() {
		return tesTmlSoCntrListVO;
	}

	public void setTesTmlSoCntrListVO(TesTmlSoCntrListVO tesTmlSoCntrListVO) {
		this.tesTmlSoCntrListVO = tesTmlSoCntrListVO;
	}

	public TesTmlSoDtlVO getTesTmlSoDtlVO() {
		return tesTmlSoDtlVO;
	}

	public void setTesTmlSoDtlVO(TesTmlSoDtlVO tesTmlSoDtlVO) {
		this.tesTmlSoDtlVO = tesTmlSoDtlVO;
	}

	public TesTmlSoHdrVO[] getTesTmlSoHdrVOs() {
		return tesTmlSoHdrVOs;
	}

	public void setTesTmlSoHdrVOs(TesTmlSoHdrVO[] tesTmlSoHdrVOs) {
		this.tesTmlSoHdrVOs = tesTmlSoHdrVOs;
	}

	public TesTmlSoCntrListVO[] getTesTmlSoCntrListVOs() {
		return tesTmlSoCntrListVOs;
	}

	public void setTesTmlSoCntrListVOs(TesTmlSoCntrListVO[] tesTmlSoCntrListVOs) {
		this.tesTmlSoCntrListVOs = tesTmlSoCntrListVOs;
	}

	public TesTmlSoDtlVO[] getTesTmlSoDtlVOs() {
		return tesTmlSoDtlVOs;
	}

	public void setTesTmlSoDtlVOs(TesTmlSoDtlVO[] tesTmlSoDtlVOs) {
		this.tesTmlSoDtlVOs = tesTmlSoDtlVOs;
	}

}	
