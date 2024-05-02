/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_913Event.java
*@FileTitle : On-dock Rail Charge Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-29
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-29 parkyeonjin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesFileImpTmpVO;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;

/**
 * ESD_TES_913 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_913HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9130Event extends EventSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//DB에 성능LOG 남기기 위해서 필요한 변수들이다.
	private String					pageURL				= null;
	private String					perfParams			= null;

	private TesFileImpTmpVO[]		tesFileImpTmpVOs	= null;
	private TesTmlSoHdrVO			tesTmlSoHdrVO		= null;		
	
	private TesTmlSoCntrListVO 		tesTmlSoCntrListVO 	= null;
	private TesTmlSoCntrListVO[] 	tesTmlSoCntrListVOs = null;
	
	private DBRowSet				rowSet				= null;
	
	
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
	 * @return the tesFileImpTmpVOs
	 */
	public TesFileImpTmpVO[] getTesFileImpTmpVOs() {
		return tesFileImpTmpVOs;
	}
	/**
	 * @param tesFileImpTmpVOs the tesFileImpTmpVOs to set
	 */
	public void setTesFileImpTmpVOs(TesFileImpTmpVO[] tesFileImpTmpVOs) {
		this.tesFileImpTmpVOs = tesFileImpTmpVOs;
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
		return tesTmlSoCntrListVOs;
	}
	/**
	 * @param tesTmlSoCntrListVOs the tesTmlSoCntrListVOs to set
	 */
	public void setTesTmlSoCntrListVOs(TesTmlSoCntrListVO[] tesTmlSoCntrListVOs) {
		this.tesTmlSoCntrListVOs = tesTmlSoCntrListVOs;
	}
}
