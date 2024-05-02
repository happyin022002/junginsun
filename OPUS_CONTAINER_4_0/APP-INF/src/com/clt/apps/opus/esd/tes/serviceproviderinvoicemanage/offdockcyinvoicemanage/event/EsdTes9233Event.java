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
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.vo.OffdockCYInvoiceManageVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.syscommon.common.table.TesTmlSoRvisListVO;


/**
 * ESD_TES_923_3 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_923_3HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9233Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//DB에 성능LOG 남기기 위해서 필요한 변수들이다.
	private String				pageURL		= null;
	private String				perfParams	= null;
	
	private OffdockCYInvoiceManageVO offdockCYInvoiceManageVO = null;
	private OffdockCYInvoiceManageVO[] offdockCYInvoiceManageVOs = null;
	private TesN3rdPtyIfVO tesN3rdPtyIfVO = null;
	private TesN3rdPtyIfVO[] tesN3rdPtyIfVOs = null;
	
	private TesTmlSoHdrVO tesTmlSoHdrVO = null;
	private TesTmlSoRvisListVO[] tesTmlSoRvisListVOs = null;
	private TesTmlSoCntrListVO[] tesTmlSoCntrListVOs = null;
	private MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs	= null;
	
	private TesTmlSoCntrListVO tesTmlSoCntrListVO = null;
	
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

	public OffdockCYInvoiceManageVO getOffdockCYInvoiceManageVO() {
		return offdockCYInvoiceManageVO;
	}
	public void setOffdockCYInvoiceManageVO(
			OffdockCYInvoiceManageVO offdockCYInvoiceManageVO) {
		this.offdockCYInvoiceManageVO = offdockCYInvoiceManageVO;
	}
	public OffdockCYInvoiceManageVO[] getOffdockCYInvoiceManageVOs() {
		OffdockCYInvoiceManageVO[] rtnVOs = null;
		if (this.offdockCYInvoiceManageVOs != null) {
			rtnVOs = Arrays.copyOf(offdockCYInvoiceManageVOs, offdockCYInvoiceManageVOs.length);
		}
		return rtnVOs;
	}
	public void setOffdockCYInvoiceManageVOs(OffdockCYInvoiceManageVO[] offdockCYInvoiceManageVOs){
		if(offdockCYInvoiceManageVOs != null){
			OffdockCYInvoiceManageVO[] tmpVOs = Arrays.copyOf(offdockCYInvoiceManageVOs, offdockCYInvoiceManageVOs.length);
			this.offdockCYInvoiceManageVOs = tmpVOs;
		}
	}
	public TesN3rdPtyIfVO getTesN3rdPtyIfVO() {
		return tesN3rdPtyIfVO;
	}
	public void setTesN3rdPtyIfVO(TesN3rdPtyIfVO tesN3rdPtyIfVO) {
		this.tesN3rdPtyIfVO = tesN3rdPtyIfVO;
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

	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
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

	public MarineTerminalInvoiceCommonVO[] getMarineTerminalInvoiceCommonVOs() {
		MarineTerminalInvoiceCommonVO[] rtnVOs = null;
		if (this.marineTerminalInvoiceCommonVOs != null) {
			rtnVOs = Arrays.copyOf(marineTerminalInvoiceCommonVOs, marineTerminalInvoiceCommonVOs.length);
		}
		return rtnVOs;
	}

	public void setMarineTerminalInvoiceCommonVOs(MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs){
		if(marineTerminalInvoiceCommonVOs != null){
			MarineTerminalInvoiceCommonVO[] tmpVOs = Arrays.copyOf(marineTerminalInvoiceCommonVOs, marineTerminalInvoiceCommonVOs.length);
			this.marineTerminalInvoiceCommonVOs = tmpVOs;
		}
	}

	public TesTmlSoCntrListVO getTesTmlSoCntrListVO() {
		return tesTmlSoCntrListVO;
	}

	public void setTesTmlSoCntrListVO(TesTmlSoCntrListVO tesTmlSoCntrListVO) {
		this.tesTmlSoCntrListVO = tesTmlSoCntrListVO;
	}
}
