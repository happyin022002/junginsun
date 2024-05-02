/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0015Event.java
*@FileTitle : CndManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.05.25 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.event;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.ScacReportCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ScacReportDetailVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0574 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0574HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김도완
 * @see ESM_BKG_0574HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0574Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Scac Report 정보 조회조건 */
	private ScacReportCondVO condVO = null;
	/** Scac Report 정보 단건  */
	private ScacReportDetailVO infoVO = null;
	
	public EsmBkg0574Event(){}

	/** Set Method **/
	public void setCondVO(ScacReportCondVO condVO){
		this. condVO = condVO;
	}
	public void setScacReportDetailVO(ScacReportDetailVO infoVO){
		this. infoVO = infoVO;
	}
	

	/** Get Method **/
	public ScacReportCondVO getScacReportCondVO(){
		return condVO;
	}
	public ScacReportDetailVO getScacReportDetailVO(){
		return infoVO;
	}
}