/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_923_3Event.java
*@FileTitle : Off-dock CY Invoice 3rd 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-27
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-11-27 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.vo.MarineTerminalStorageInvoiceManageVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesN3rdPtyIfVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_923_4 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_923_4HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9234Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//DB에 성능LOG 남기기 위해서 필요한 변수들이다.
	private String				pageURL		= null;
	private String				perfParams	= null;
	
	private TesTmlSoHdrVO tesTmlSoHdrVO = null; 
	private TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null; 
	private MarineTerminalStorageInvoiceManageVO marineTerminalStorageInvoiceManageVO = null;
	private MarineTerminalStorageInvoiceManageVO[] marineTerminalStorageInvoiceManageVOs = null;
	
	public EsdTes9234Event(){}
	
	public String getPageURL() {
		return pageURL;
	}

	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}

	public String getPerfParams() {
		return perfParams;
	}

	public void setPerfParams(String perfParams) {
		this.perfParams = perfParams;
	}

	
	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}

	public TesN3rdPtyIfVO[] getTesN3rdPtyIfVOs() {
		return tesN3rdPtyIfVOs;
	}

	public void setTesN3rdPtyIfVOs(TesN3rdPtyIfVO[] tesN3rdPtyIfVOs) {
		this.tesN3rdPtyIfVOs = tesN3rdPtyIfVOs;
	}

	public MarineTerminalStorageInvoiceManageVO getMarineTerminalStorageInvoiceManageVO() {
		return marineTerminalStorageInvoiceManageVO;
	}

	public void setMarineTerminalStorageInvoiceManageVO(
			MarineTerminalStorageInvoiceManageVO marineTerminalStorageInvoiceManageVO) {
		this.marineTerminalStorageInvoiceManageVO = marineTerminalStorageInvoiceManageVO;
	}
	
	public MarineTerminalStorageInvoiceManageVO[] getMarineTerminalStorageInvoiceManageVOs() {
		return marineTerminalStorageInvoiceManageVOs;
	}

	public void setMarineTerminalStorageInvoiceManageVOs(
			MarineTerminalStorageInvoiceManageVO[] marineTerminalStorageInvoiceManageVOs) {
		this.marineTerminalStorageInvoiceManageVOs = marineTerminalStorageInvoiceManageVOs;
	}
	
}
