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
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.vo.MarineTerminalStorageInvoiceManageVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


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
		TesN3rdPtyIfVO[] rtnVOs = null;
		if (this.tesN3rdPtyIfVOs != null) {
			rtnVOs = Arrays.copyOf(tesN3rdPtyIfVOs, tesN3rdPtyIfVOs.length);
		}
		return rtnVOs;
	}

	public void setTesN3rdPtyIfVOs(TesN3rdPtyIfVO[] tesN3rdPtyIfVOs){
		if(tesN3rdPtyIfVOs != null){
			TesN3rdPtyIfVO[] tmpVOs = Arrays.copyOf(tesN3rdPtyIfVOs, tesN3rdPtyIfVOs.length);
			this.tesN3rdPtyIfVOs = tmpVOs;
		}
	}

	public MarineTerminalStorageInvoiceManageVO getMarineTerminalStorageInvoiceManageVO() {
		return marineTerminalStorageInvoiceManageVO;
	}

	public void setMarineTerminalStorageInvoiceManageVO(
			MarineTerminalStorageInvoiceManageVO marineTerminalStorageInvoiceManageVO) {
		this.marineTerminalStorageInvoiceManageVO = marineTerminalStorageInvoiceManageVO;
	}
	
	public MarineTerminalStorageInvoiceManageVO[] getMarineTerminalStorageInvoiceManageVOs() {
		MarineTerminalStorageInvoiceManageVO[] rtnVOs = null;
		if (this.marineTerminalStorageInvoiceManageVOs != null) {
			rtnVOs = Arrays.copyOf(marineTerminalStorageInvoiceManageVOs, marineTerminalStorageInvoiceManageVOs.length);
		}
		return rtnVOs;
	}

	public void setMarineTerminalStorageInvoiceManageVOs(MarineTerminalStorageInvoiceManageVO[] marineTerminalStorageInvoiceManageVOs){
		if(marineTerminalStorageInvoiceManageVOs != null){
			MarineTerminalStorageInvoiceManageVO[] tmpVOs = Arrays.copyOf(marineTerminalStorageInvoiceManageVOs, marineTerminalStorageInvoiceManageVOs.length);
			this.marineTerminalStorageInvoiceManageVOs = tmpVOs;
		}
	}
	
}
