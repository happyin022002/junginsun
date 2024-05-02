/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesDmt6011Event.java
*@FileTitle : Uncollected status by Aging
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.26
*@LastModifier : 정 운
*@LastVersion : 1.0
* 2013.11.26 정 운
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.YearlyCollectionByRHQVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_6011 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_6011HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Un
 * @see EES_DMT_6011HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt6011Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private YearlyCollectionByRHQVO yearlyCollectionByRHQVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private YearlyCollectionByRHQVO[] yearlyCollectionByRHQVOs = null;

	public EesDmt6011Event(){}
	
	public void setYearlyCollectionByRHQVO(YearlyCollectionByRHQVO yearlyCollectionByRHQVO){
		this. yearlyCollectionByRHQVO = yearlyCollectionByRHQVO;
	}

	public void setYearlyCollectionByRHQVOS(YearlyCollectionByRHQVO[] yearlyCollectionByRHQVOs){
		this. yearlyCollectionByRHQVOs = yearlyCollectionByRHQVOs;
	}

	public YearlyCollectionByRHQVO getYearlyCollectionByRHQVO(){
		return yearlyCollectionByRHQVO;
	}

	public YearlyCollectionByRHQVO[] getYearlyCollectionByRHQVOS(){
		return yearlyCollectionByRHQVOs;
	}

}