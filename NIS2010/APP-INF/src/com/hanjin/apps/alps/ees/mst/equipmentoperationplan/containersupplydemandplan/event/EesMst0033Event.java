/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0033Event.java
*@FileTitle : Equipment Procurement by Year
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.07.10 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.ProcurementDetailVO;


/**
 * EES_MST_0033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MST_0033HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0033Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ProcurementDetailVO procurementDetailVO = null;
	
	public EesMst0033Event(){}
	
	/**
	 * @return the procurementOptionVO
	 */		
	public ProcurementDetailVO getProcurementDetailVO(){
		return procurementDetailVO;
	}	
	
	/**
	 * @param procurementOptionVO the procurementOptionVO to set
	 */	
	public void setProcurementDetailVO(ProcurementDetailVO procurementDetailVO){
		this. procurementDetailVO = procurementDetailVO;
	}
}