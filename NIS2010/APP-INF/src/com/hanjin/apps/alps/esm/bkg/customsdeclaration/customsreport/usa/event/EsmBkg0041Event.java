/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0041Event.java
*@FileTitle : Ams Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.24 김도완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaAmsReportListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaAmsReportListDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_0041 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0041HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김도완
 * @see ESM_BKG_0041HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0041Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Ams Report 정보 조회조건 */
	private UsaAmsReportListCondVO condVO = null;
	/** Ams Report 정보 복수 */
	private UsaAmsReportListDetailVO[] infoVOs = null;
	
	public EsmBkg0041Event(){}

	/** Set Method **/
	public void setCondVO(UsaAmsReportListCondVO condVO){
		this. condVO = condVO;
	}
	public void setDetailVOS(UsaAmsReportListDetailVO[] infoVOs){
		this. infoVOs = infoVOs;
	}
	

	/** Get Method **/
	public UsaAmsReportListCondVO getCondVO(){
		return condVO;
	}
	public UsaAmsReportListDetailVO[] getDetailVOS(){
		return infoVOs;
	}

}