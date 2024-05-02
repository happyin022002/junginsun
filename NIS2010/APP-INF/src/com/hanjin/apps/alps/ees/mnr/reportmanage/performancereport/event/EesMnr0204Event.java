/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0204Event.java
*@FileTitle : Tire Replacement Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.01 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TireReplacementINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.TireReplacementHistoryVO;


/**
 * EES_MNR_0204 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0204HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MNR_0204HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0204Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TireReplacementINVO tireReplacementINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TireReplacementHistoryVO[] tireReplacementHistoryVOs = null;

	public EesMnr0204Event(){}
	
	public void setTireReplacementINVO(TireReplacementINVO tireReplacementINVO){
		this. tireReplacementINVO = tireReplacementINVO;
	}

	public void setTireReplacementHistoryVOS(TireReplacementHistoryVO[] tireReplacementHistoryVOs){
		this. tireReplacementHistoryVOs = tireReplacementHistoryVOs;
	}

	public TireReplacementINVO getTireReplacementINVO(){
		return tireReplacementINVO;
	}

	public TireReplacementHistoryVO[] getTireReplacementHistoryVOS(){
		return tireReplacementHistoryVOs;
	}

}