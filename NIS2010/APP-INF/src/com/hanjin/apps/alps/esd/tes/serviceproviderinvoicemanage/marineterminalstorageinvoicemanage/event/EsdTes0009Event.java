/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_009Event.java
*@FileTitle : Marine Terminal Strorage Invoice관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-27
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-27 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.vo.MarineTerminalStorageInvoiceManageVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_009HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0009Event extends EventSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MarineTerminalStorageInvoiceManageVO marineTerminalStorageInvoiceManageVO = null;
	private TesTmlSoHdrVO tesTmlSoHdrVO = null;
	private TesTmlSoDtlVO[] tesTmlSoDtlVOs = null; 
	private TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = null; 
	
	public EsdTes0009Event(){}
	
	public MarineTerminalStorageInvoiceManageVO getMarineTerminalStorageInvoiceManageVO() {
		return marineTerminalStorageInvoiceManageVO;
	}

	public void setMarineTerminalStorageInvoiceManageVO(
			MarineTerminalStorageInvoiceManageVO marineTerminalStorageInvoiceManageVO) {
		this.marineTerminalStorageInvoiceManageVO = marineTerminalStorageInvoiceManageVO;
	}
	
	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}

	public TesTmlSoDtlVO[] getTesTmlSoDtlVOs() {
		return tesTmlSoDtlVOs;
	}

	public void setTesTmlSoDtlVOs(TesTmlSoDtlVO[] tesTmlSoDtlVOs) {
		this.tesTmlSoDtlVOs = tesTmlSoDtlVOs;
	}

	public TesTmlSoCntrListVO[] getTesTmlSoCntrListVOs() {
		return tesTmlSoCntrListVOs;
	}

	public void setTesTmlSoCntrListVOs(TesTmlSoCntrListVO[] tesTmlSoCntrListVOs) {
		this.tesTmlSoCntrListVOs = tesTmlSoCntrListVOs;
	}
}
