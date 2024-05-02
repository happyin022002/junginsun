/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0027Event.java
*@FileTitle : Container Status Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.06.26 민정호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.event;

import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusOptionVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusReportListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_MST_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MST_0027HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0027Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CntrStatusOptionVO cntrStatusOptionVO = null;
	private CntrStatusReportListVO cntrStatusReportListVO = null;
	
	/** Table Value Object Multi Data 처리 */
//	private CntrStatusOptionVO[] cntrStatusOptionVOs = null;	
//	private CntrStatusReportListVO[] cntrStatusReportListVOs = null;
	
	public EesMst0027Event(){}
	
	/**
	 * @param cntrStatusOptionVO the cntrStatusOptionVO to set
	 */
	public void setCntrStatusOptionVO(CntrStatusOptionVO cntrStatusOptionVO) {
		this.cntrStatusOptionVO = cntrStatusOptionVO;
	}

	/**
	 * @return the cntrStatusOptionVO
	 */
	public CntrStatusOptionVO getCntrStatusOptionVO() {
		return cntrStatusOptionVO;
	}

	/**
	 * @param cntrStatusReportListVO the cntrStatusReportListVO to set
	 */
	public void setCntrStatusReportListVO(CntrStatusReportListVO cntrStatusReportListVO) {
		this.cntrStatusReportListVO = cntrStatusReportListVO;
	}

	/**
	 * @return the cntrStatusReportListVO
	 */
	public CntrStatusReportListVO getCntrStatusReportListVO() {
		return cntrStatusReportListVO;
	}	
	
	
	
}