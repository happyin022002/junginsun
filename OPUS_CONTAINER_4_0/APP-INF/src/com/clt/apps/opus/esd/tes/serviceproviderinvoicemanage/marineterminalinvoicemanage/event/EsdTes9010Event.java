/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTes9010Event.java
*@FileTitle : Get Container List Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-18
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-10-18 parkyeonjin
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesFileImpTmpVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;

/**
 * EsdTes9010Event 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_9010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9010Event extends EventSupport {
	
	private TesTmlSoCntrListVO 		tesTmlSoCntrListVO 	= null;
	private TesTmlSoCntrListVO[] 	tesTmlSoCntrListVOs = null;
	
	private TesTmlSoHdrVO			tesTmlSoHdrVO		= null;
	private TesCommonVO				tesCommonVO			= null;
	
	private TesFileImpTmpVO			tesFileImpTmpVO		= null;
	private TesFileImpTmpVO[]		tesFileImpTmpVOs	= null;
	                        
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null;

	private DBRowSet rowSet = null;

	//DB에 성능LOG 남기기 위해서 필요한 변수들이다.
	private String pageURL 		= null;			
	private String perfParams 	= null;

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
	 * @return the tesTmlSoCntrListVOs
	 */
	public TesTmlSoCntrListVO[] getTesTmlSoCntrListVOs() {
		TesTmlSoCntrListVO[] rtnVOs = null;
		if (this.tesTmlSoCntrListVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoCntrListVOs, tesTmlSoCntrListVOs.length);
		}
		return rtnVOs;
	}


	/**
	 * @param tesTmlSoCntrListVOs the tesTmlSoCntrListVOs to set
	 */
	public void setTesTmlSoCntrListVOs(TesTmlSoCntrListVO[] tesTmlSoCntrListVOs){
		if(tesTmlSoCntrListVOs != null){
			TesTmlSoCntrListVO[] tmpVOs = Arrays.copyOf(tesTmlSoCntrListVOs, tesTmlSoCntrListVOs.length);
			this.tesTmlSoCntrListVOs = tmpVOs;
		}
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
	 * @return the rowSet
	 */
	public DBRowSet getRowSet() {
		return rowSet;
	}

	/**
	 * @param rowSet the rowSet to set
	 */
	public void setRowSet(DBRowSet rowSet) {
		this.rowSet = rowSet;
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
	 * @return the tesFileImpTmpVO
	 */
	public TesFileImpTmpVO getTesFileImpTmpVO() {
		return tesFileImpTmpVO;
	}

	/**
	 * @param tesFileImpTmpVO the tesFileImpTmpVO to set
	 */
	public void setTesFileImpTmpVO(TesFileImpTmpVO tesFileImpTmpVO) {
		this.tesFileImpTmpVO = tesFileImpTmpVO;
	}

	/**
	 * @return the tesFileImpTmpVOs
	 */
	public TesFileImpTmpVO[] getTesFileImpTmpVOs() {
		TesFileImpTmpVO[] rtnVOs = null;
		if (this.tesFileImpTmpVOs != null) {
			rtnVOs = Arrays.copyOf(tesFileImpTmpVOs, tesFileImpTmpVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesFileImpTmpVOs the tesFileImpTmpVOs to set
	 */
	public void setTesFileImpTmpVOs(TesFileImpTmpVO[] tesFileImpTmpVOs){
		if(tesFileImpTmpVOs != null){
			TesFileImpTmpVO[] tmpVOs = Arrays.copyOf(tesFileImpTmpVOs, tesFileImpTmpVOs.length);
			this.tesFileImpTmpVOs = tmpVOs;
		}
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
	

	/** bkg_booking Table  Value Object */
//	private TES_TML_SO_CNTR_LIST tes_tml_so_cntr_list = null;

	/** bkg_bookings Multi Action을 위한 Collection */
//	private Collection tes_tml_so_cntr_lists = null;
	
}
