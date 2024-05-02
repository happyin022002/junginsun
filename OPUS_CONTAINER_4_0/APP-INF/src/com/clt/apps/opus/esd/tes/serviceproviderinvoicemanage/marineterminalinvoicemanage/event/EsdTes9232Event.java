/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_923_1Event.java
*@FileTitle : Total Amount PopUp 화면 - Marine Terminal
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-23
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-23 parkyeonjin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ESD_TES_9232 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_9232HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9232Event extends EventSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//DB에 성능LOG 남기기 위해서 필요한 변수들이다.
	private String				pageURL		= null;
	private String				perfParams	= null;
	
	private TesCommonVO 		tesCommonVO 	= null;	
	private TesTmlSoHdrVO		tesTmlSoHdrVO	= null;
	private TesTmlSoDtlVO		tesTmlSoDtlVO	= null;
	private TesTmlSoCntrListVO  tesTmlSoCntrListVO = null;
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null;
	private MarineTerminalInvoiceCommonVO [] marineTerminalInvoiceCommonVOs = null;
	
	private TesN3rdPtyIfVO[] 	tesN3rdPtyIfVOs = null;
	
	public EsdTes9232Event(){}

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


	/**
	 * @return the tesCommonVO
	 */
	public TesCommonVO getTesCommonVO() {
		return tesCommonVO;
	}


	/**
	 * @param tesCommonVO the tesCommonVO to set
	 */
	public void setTesCommonVO(TesCommonVO tesCommonVO) {
		this.tesCommonVO = tesCommonVO;
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
	 * @return the tesTmlSoCntrListVO
	 */
	public TesTmlSoCntrListVO getTesTmlSoCntrListVO() {
		return tesTmlSoCntrListVO;
	}


	/**
	 * @param tesTmlSoCntrListVO the tesTmlSoCntrListVO to set
	 */
	public void setTesTmlSoCntrListVO(TesTmlSoCntrListVO tesTmlSoCntrListVO) {
		this.tesTmlSoCntrListVO = tesTmlSoCntrListVO;
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
	 * @return the tesN3rdPtyIfVOs
	 */
	public TesN3rdPtyIfVO[] getTesN3rdPtyIfVOs() {
		TesN3rdPtyIfVO[] rtnVOs = null;
		if (this.tesN3rdPtyIfVOs != null) {
			rtnVOs = Arrays.copyOf(tesN3rdPtyIfVOs, tesN3rdPtyIfVOs.length);
		}
		return rtnVOs;
	}


	/**
	 * @param tesN3rdPtyIfVOs the tesN3rdPtyIfVOs to set
	 */
	public void setTesN3rdPtyIfVOs(TesN3rdPtyIfVO[] tesN3rdPtyIfVOs){
		if(tesN3rdPtyIfVOs != null){
			TesN3rdPtyIfVO[] tmpVOs = Arrays.copyOf(tesN3rdPtyIfVOs, tesN3rdPtyIfVOs.length);
			this.tesN3rdPtyIfVOs = tmpVOs;
		}
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
	 *  getMarineTerminalInvoiceCommonVOs
	 * @return MarineTerminalInvoiceCommonVO[]
	 */
	public MarineTerminalInvoiceCommonVO[] getMarineTerminalInvoiceCommonVOs() {
		MarineTerminalInvoiceCommonVO[] rtnVOs = null;
		if (this.marineTerminalInvoiceCommonVOs != null) {
			rtnVOs = new MarineTerminalInvoiceCommonVO[marineTerminalInvoiceCommonVOs.length];
			System.arraycopy(marineTerminalInvoiceCommonVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * 
	 * @param marineTerminalInvoiceCommonVOs
	 */
	public void setMarineTerminalInvoiceCommonVOs(MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs){
		if(marineTerminalInvoiceCommonVOs != null){
			MarineTerminalInvoiceCommonVO[] tmpVOs = new MarineTerminalInvoiceCommonVO[marineTerminalInvoiceCommonVOs.length];
			System.arraycopy(marineTerminalInvoiceCommonVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.marineTerminalInvoiceCommonVOs = tmpVOs;
		}
	}


}
