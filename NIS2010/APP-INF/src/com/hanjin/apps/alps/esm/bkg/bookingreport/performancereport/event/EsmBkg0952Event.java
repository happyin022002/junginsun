/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0952Event.java
*@FileTitle : C/A Summary Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.10.15 이남경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaSummaryReportInVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0952 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0952HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee NamKyung
 * @see ESM_BKG_0952HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0952Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CaSummaryReportInVO caSummaryReportInVO = null;	

	public EsmBkg0952Event(){}

	/**
	 * @return the caSummaryReportInVO
	 */
	public CaSummaryReportInVO getCaSummaryReportInVO() {
		return caSummaryReportInVO;
	}

	/**
	 * @param caSummaryReportInVO the caSummaryReportInVO to set
	 */
	public void setCaSummaryReportInVO(CaSummaryReportInVO caSummaryReportInVO) {
		this.caSummaryReportInVO = caSummaryReportInVO;
	}

}