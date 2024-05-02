/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa2007Event.java
*@FileTitle : Week Period
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.CoaWkPrdVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_2007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_2007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chang Hun Kim
 * @see ESM_COA_2007HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmCoa2007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CoaWkPrdVO coaWkPrdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CoaWkPrdVO[] coaWkPrdVOs = null;
	
	private String costYr = null;
	private String costWkFm = null;
	private String costWkTo = null;

	public EsmCoa2007Event(){}
	
	public void setCoaWkPrdVO(CoaWkPrdVO coaWkPrdVO){
		this. coaWkPrdVO = coaWkPrdVO;
	}
	//SJH.20150508.소스품질
	public void setCoaWkPrdVOS(CoaWkPrdVO[] coaWkPrdVOs){
		if(coaWkPrdVOs != null){
			CoaWkPrdVO[] tmpVOs = Arrays.copyOf(coaWkPrdVOs, coaWkPrdVOs.length);
			this.coaWkPrdVOs = tmpVOs;
		}
	}

	public CoaWkPrdVO getCoaWkPrdVO(){
		return coaWkPrdVO;
	}
	//SJH.20150508.소스품질
	public CoaWkPrdVO[] getCoaWkPrdVOS(){
		CoaWkPrdVO[] rtnVOs = null;
		if (this.coaWkPrdVOs != null) {
			rtnVOs = Arrays.copyOf(coaWkPrdVOs, coaWkPrdVOs.length);
		}
		return rtnVOs;
	}

	public String getCostYr(){
		return costYr;
	}

	public String getCostWkFm(){
		return costWkFm;
	}

	public String getCostWkTo(){
		return costWkTo;
	}

	public void setCostYr(String costYr){
		this. costYr = costYr;
	}

	public void setCostWkFm(String costWkFm){
		this. costWkFm = costWkFm;
	}

	public void setCostWkTo(String costWkTo){
		this. costWkTo = costWkTo;
	}
}