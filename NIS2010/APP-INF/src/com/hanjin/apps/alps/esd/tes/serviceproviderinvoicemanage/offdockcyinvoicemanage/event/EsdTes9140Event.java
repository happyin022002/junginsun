/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_914Event.java
*@FileTitle : Off-dock CY Invoice의 ByPool fileupload 및 verify
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-24
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-24 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesFileImpTmpVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;



/**
 * ESD_TES_914 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_914HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9140Event extends EventSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//DB에 성능LOG 남기기 위해서 필요한 변수들이다.
	private String pageURL = null;
	private String perfParams = null;
	
	private TesTmlSoHdrVO tesTmlSoHdrVO = null; 
	private TesFileImpTmpVO[] tesFileImpTmpVOs = null;	
	
	private com.hanjin.framework.component.rowset.DBRowSet rowSet = null;
	
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
	public TesFileImpTmpVO[] getTesFileImpTmpVOs() {
		return tesFileImpTmpVOs;
	}
	public void setTesFileImpTmpVOs(TesFileImpTmpVO[] tesFileImpTmpVOs) {
		this.tesFileImpTmpVOs = tesFileImpTmpVOs;
	}

	public com.hanjin.framework.component.rowset.DBRowSet getRowSet() {
		return rowSet;
	}

	public void setRowSet(com.hanjin.framework.component.rowset.DBRowSet rowSet) {
		this.rowSet = rowSet;
	}
	
}
