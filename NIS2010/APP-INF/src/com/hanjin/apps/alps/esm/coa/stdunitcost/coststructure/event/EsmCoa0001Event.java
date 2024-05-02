/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa001Event.java
*@FileTitle : Set List Box To Set Key Business Rule
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 박은주
*@LastVersion : 1.0
* 2009.07.10 박은주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.event;

import com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.vo.SpclRepoCntrVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CoaSpclRepoCntrRgstVO;


/**
 * ESM_COA_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park eun ju
 * @see ESM_COA_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Select VO Value Object 조회 조건 및 단건 처리  */
	private SpclRepoCntrVO spclRepoCntrVO = null;
	
//	/** Table Value Object Multi Data 처리 */
//	private SpclRepoCntrVO[] spclRepoCntrVOs = null;
	
	/** Table Value Object Multi Data 처리*/
	private CoaSpclRepoCntrRgstVO[] coaSpclRepoCntrRgstVOs = null;
	

	public EsmCoa0001Event(){}
	
	public void setSpclRepoCntrVO(SpclRepoCntrVO spclRepoCntrVO){
		this. spclRepoCntrVO = spclRepoCntrVO;
	}

	public void setCoaSpclRepoCntrRgstVOS(CoaSpclRepoCntrRgstVO[] coaSpclRepoCntrRgstVOs){
		this. coaSpclRepoCntrRgstVOs = coaSpclRepoCntrRgstVOs;
	}

	public SpclRepoCntrVO getSpclRepoCntrVO(){
		return spclRepoCntrVO;
	}

	public CoaSpclRepoCntrRgstVO[] getCoaSpclRepoCntrRgstVOS(){
		return coaSpclRepoCntrRgstVOs;
	}
	
	public String getEventName(){
		return "EsmCoa0001Event";
	}

}