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
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.vo.OffdockCYInvoiceManageVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.syscommon.common.table.TesTmlSoRvisListVO;


/**
 * ESD_TES_903Event에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_903HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9030Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OffdockCYInvoiceManageVO offdockCYInvoiceManageVO = null;
	
	private TesTmlSoHdrVO tesTmlSoHdrVO = null;
	
	private TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
	private TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = null;
	
	private TesTmlSoRvisListVO[] tesTmlSoRvisListVOs = null;
	
	public EsdTes9030Event(){}

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

	public TesTmlSoCntrListVO[] getTesTmlSoCntrListVOs() {
		TesTmlSoCntrListVO[] rtnVOs = null;
		if (this.tesTmlSoCntrListVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoCntrListVOs, tesTmlSoCntrListVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlSoCntrListVOs(TesTmlSoCntrListVO[] tesTmlSoCntrListVOs){
		if(tesTmlSoCntrListVOs != null){
			TesTmlSoCntrListVO[] tmpVOs = Arrays.copyOf(tesTmlSoCntrListVOs, tesTmlSoCntrListVOs.length);
			this.tesTmlSoCntrListVOs = tmpVOs;
		}
	}

	public TesTmlSoRvisListVO[] getTesTmlSoRvisListVOs() {
		TesTmlSoRvisListVO[] rtnVOs = null;
		if (this.tesTmlSoRvisListVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoRvisListVOs, tesTmlSoRvisListVOs.length);
		}
		return rtnVOs;
	}

	public void setTesTmlSoRvisListVOs(TesTmlSoRvisListVO[] tesTmlSoRvisListVOs){
		if(tesTmlSoRvisListVOs != null){
			TesTmlSoRvisListVO[] tmpVOs = Arrays.copyOf(tesTmlSoRvisListVOs, tesTmlSoRvisListVOs.length);
			this.tesTmlSoRvisListVOs = tmpVOs;
		}
	}

	
}
