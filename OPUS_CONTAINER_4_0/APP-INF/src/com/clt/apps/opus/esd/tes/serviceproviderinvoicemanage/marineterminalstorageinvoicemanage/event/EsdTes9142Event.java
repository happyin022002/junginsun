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
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TesFileImpTmpVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;



/**
 * ESD_TES_9142 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_9142HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9142Event extends EventSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TesTmlSoHdrVO  tesTmlSoHdrVO = null;
	private TesFileImpTmpVO[] tesFileImpTmpVOs = null;
	
	private TesTmlSoCntrListVO 		tesTmlSoCntrListVO 	= null;
	private TesCommonVO				tesCommonVO			= null;

	private com.clt.framework.component.rowset.DBRowSet rowSet = null;
	
	//DB에 성능LOG 남기기 위해서 필요한 변수들이다.
	private String pageURL = null;			
	private String perfParams = null;
	
	public EsdTes9142Event(){}

	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}

	public TesFileImpTmpVO[] getTesFileImpTmpVOs() {
		TesFileImpTmpVO[] rtnVOs = null;
		if (this.tesFileImpTmpVOs != null) {
			rtnVOs = Arrays.copyOf(tesFileImpTmpVOs, tesFileImpTmpVOs.length);
		}
		return rtnVOs;
	}

	public void setTesFileImpTmpVOs(TesFileImpTmpVO[] tesFileImpTmpVOs){
		if(tesFileImpTmpVOs != null){
			TesFileImpTmpVO[] tmpVOs = Arrays.copyOf(tesFileImpTmpVOs, tesFileImpTmpVOs.length);
			this.tesFileImpTmpVOs = tmpVOs;
		}
	}

	public com.clt.framework.component.rowset.DBRowSet getRowSet() {
		return rowSet;
	}

	public void setRowSet(com.clt.framework.component.rowset.DBRowSet rowSet) {
		this.rowSet = rowSet;
	}

	public String getPerfParams() {
		return perfParams;
	}

	public void setPerfParams(String perfParams) {
		this.perfParams = perfParams;
	}

	public String getPageURL() {
		return pageURL;
	}

	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}

	public TesTmlSoCntrListVO getTesTmlSoCntrListVO() {
		return tesTmlSoCntrListVO;
	}

	public void setTesTmlSoCntrListVO(TesTmlSoCntrListVO tesTmlSoCntrListVO) {
		this.tesTmlSoCntrListVO = tesTmlSoCntrListVO;
	}

	public TesCommonVO getTesCommonVO() {
		return tesCommonVO;
	}

	public void setTesCommonVO(TesCommonVO tesCommonVO) {
		this.tesCommonVO = tesCommonVO;
	}
}
