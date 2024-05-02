/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BIS_0001.jsp
*@FileTitle : BIS-B/L Information
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 김태경
*@LastVersion : 1.0
*2010.01.22 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BisMonitorListVO;


/**
 * ESM_BIS_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BIS_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BIS_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBis0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BisMonitorListVO bisMonitorListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BisMonitorListVO[] bisMonitorListVOs = null;
	
	private String fromDt	= null;
	private String toDt 	= null;

	public EsmBis0001Event(){}
	
	public void setBisMonitorListVO(BisMonitorListVO bisMonitorListVO){
		this. bisMonitorListVO = bisMonitorListVO;
	}

	public void setBisMonitorListVOS(BisMonitorListVO[] bisMonitorListVOs){
		this. bisMonitorListVOs = bisMonitorListVOs;
	}

	public BisMonitorListVO getCaSummaryReportInVO(){
		return bisMonitorListVO;
	}

	public BisMonitorListVO[] getCaSummaryReportInVOS(){
		return bisMonitorListVOs;
	}
	public void setFromDt(String fromDt){
		this.fromDt = fromDt;
	}	
	public void setToDt(String toDt){
		this.toDt = toDt;
	}
	public String getFromDt(){
		return fromDt;
	}
	public String getToDt(){
		return toDt;
	}

}