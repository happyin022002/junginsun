/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt7007Event.java
*@FileTitle : Daily Batch Job Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.05.12 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.event;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo.BatHistParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo.DmtBatHisVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ees_dmt_7007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_dmt_7007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Sung Hwan
 * @see ees_dmt_7007HTMLAction 참조
 * @since J2EE 1.4
 */

public class EesDmt7007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private BatHistParmVO batHistParmVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DmtBatHisVO dmtBatHisVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DmtBatHisVO[] dmtBatHisVOs = null;

	public EesDmt7007Event(){}
	
	public void setBatHistParmVO(BatHistParmVO batHistParmVO){
		this.batHistParmVO = batHistParmVO;
	}
	
	public void setDmtBatHisVO(DmtBatHisVO dmtBatHisVO){
		this. dmtBatHisVO = dmtBatHisVO;
	}

	public void setDmtBatHisVOS(DmtBatHisVO[] dmtBatHisVOs){
		this. dmtBatHisVOs = dmtBatHisVOs;
	}

	public BatHistParmVO getBatHistParmVO(){
		return batHistParmVO;
	}
	
	public DmtBatHisVO getDmtBatHisVO(){
		return dmtBatHisVO;
	}

	public DmtBatHisVO[] getDmtBatHisVOS(){
		return dmtBatHisVOs;
	}

}