/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_013_1Event.java
*@FileTitle : TerminalInvoiceSummary
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2006-10-30 kimjinjoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_013_1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_013_1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimjinjoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0014Event extends EventSupport {

	public EsdTes0014Event(){}
	
	private TesTmlSoHdrVO 	tesTmlSoHdrVO 	= null;
	private TesTmlSoDtlVO 	tesTmlSoDtlVO	= null;
	private TesCommonVO 	tesCommonVo 	= null;	
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null;

	// DB에 성능LOG 남기기 위해서 필요한 변수들이다.
	private String pageURL 		= null;			
	private String perfParams 	= null;
	
	private int iPage 			= 0;
	
	public int getiPage() {
		return iPage;
	}
	
	public void setiPage(int iPage) {
		this.iPage = iPage;
	}
	
	/**
	 * @return the tesTmlSoHdrVO
	 */
	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}


	/**
	 * @param tesTmlSoHdrVO the tesTmlSoHdrVO to set
	 */
	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}


	/**
	 * @return the tesTmlSoDtlVO
	 */
	public TesTmlSoDtlVO getTesTmlSoDtlVO() {
		return tesTmlSoDtlVO;
	}


	/**
	 * @param tesTmlSoDtlVO the tesTmlSoDtlVO to set
	 */
	public void setTesTmlSoDtlVO(TesTmlSoDtlVO tesTmlSoDtlVO) {
		this.tesTmlSoDtlVO = tesTmlSoDtlVO;
	}


	/**
	 * @return the tesCommonVo
	 */
	public TesCommonVO getTesCommonVo() {
		return tesCommonVo;
	}


	/**
	 * @param tesCommonVo the tesCommonVo to set
	 */
	public void setTesCommonVo(TesCommonVO tesCommonVo) {
		this.tesCommonVo = tesCommonVo;
	}

	/**
	 * @return the marineTerminalInvoiceCommonVO
	 */
	public MarineTerminalInvoiceCommonVO getMarineTerminalInvoiceCommonVO() {
		return marineTerminalInvoiceCommonVO;
	}

	/**
	 * @param marineTerminalInvoiceCommonVO the marineTerminalInvoiceCommonVO to set
	 */
	public void setMarineTerminalInvoiceCommonVO(
			MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO) {
		this.marineTerminalInvoiceCommonVO = marineTerminalInvoiceCommonVO;
	}


	/**
	 * @return the pageURL
	 */
	public String getPageURL() {
		return pageURL;
	}


	/**
	 * @param pageURL the pageURL to set
	 */
	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}


	/**
	 * @return the perfParams
	 */
	public String getPerfParams() {
		return perfParams;
	}


	/**
	 * @param perfParams the perfParams to set
	 */
	public void setPerfParams(String perfParams) {
		this.perfParams = perfParams;
	} 
	
	/** 조회조건(Inv Date, VVD 등)을 담기위한 HashMap */	//20061031HashMap
//	private java.util.HashMap param_map = null;

	/** tes_tml_so_dtl Table  Value Object */
//	private TES_TML_SO_DTL tes_tml_so_dtl = null;

	/** tes_tml_so_dtls Multi Action을 위한 Collection */
//	private Collection tes_tml_so_dtls = null;

	/** tes_tml_so_hdr Table  Value Object */
//	private TES_TML_SO_HDR tes_tml_so_hdr = null;

	/** tes_tml_so_hdrs Multi Action을 위한 Collection */
//	private Collection tes_tml_so_hdrs = null;


}
