/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmBkg1081Event.java
*@FileTitle : Autorating Accuracy Monitoring Report
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.02.04 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo.AutoratingReportVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1081 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1081HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_1081HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1081Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AutoratingReportVO autoratingReportVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private AutoratingReportVO[] autoratingReportVOs = null;

	public EsmBkg1081Event(){}
	
	public void setAutoratingReportVO(AutoratingReportVO autoratingReportVO){
		this. autoratingReportVO = autoratingReportVO;
	}

	public void setAutoratingReportVOS(AutoratingReportVO[] autoratingReportVOs){
		if(autoratingReportVOs != null){
			AutoratingReportVO[] tmpVOs = Arrays.copyOf(autoratingReportVOs, autoratingReportVOs.length);
			this.autoratingReportVOs = tmpVOs;
		}
	}

	public AutoratingReportVO getAutoratingReportVO(){
		return autoratingReportVO;
	}

	public AutoratingReportVO[] getAutoratingReportVOS(){
		AutoratingReportVO[] rtnVOs = null;
		if(this.autoratingReportVOs != null){
			rtnVOs= Arrays.copyOf(autoratingReportVOs, autoratingReportVOs.length);
		}
		return rtnVOs;
	}

}