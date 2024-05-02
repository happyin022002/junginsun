/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas001Event.java
*@FileTitle : Set List Box To Set Key Business Rule
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 박은주
*@LastVersion : 1.0
* 2009.07.10 박은주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.event;

import com.hanjin.apps.alps.esm.mas.stdunitcost.coststructure.vo.SpclRepoCntrVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasSpclRepoCntrRgstVO;


/**
 * ESM_MAS_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park eun ju
 * @see ESM_MAS_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Select VO Value Object 조회 조건 및 단건 처리  */
	private SpclRepoCntrVO spclRepoCntrVO = null;
	
//	/** Table Value Object Multi Data 처리 */
//	private SpclRepoCntrVO[] spclRepoCntrVOs = null;
	
	/** Table Value Object Multi Data 처리*/
	private MasSpclRepoCntrRgstVO[] masSpclRepoCntrRgstVOs = null;
	

	public EsmMas0001Event(){}
	
	public void setSpclRepoCntrVO(SpclRepoCntrVO spclRepoCntrVO){
		this. spclRepoCntrVO = spclRepoCntrVO;
	}

	public void setMasSpclRepoCntrRgstVOS(MasSpclRepoCntrRgstVO[] masSpclRepoCntrRgstVOs){
		this. masSpclRepoCntrRgstVOs = masSpclRepoCntrRgstVOs;
	}

	public SpclRepoCntrVO getSpclRepoCntrVO(){
		return spclRepoCntrVO;
	}

	public MasSpclRepoCntrRgstVO[] getMasSpclRepoCntrRgstVOS(){
		return masSpclRepoCntrRgstVOs;
	}
	
	public String getEventName(){
		return "EsmMas0001Event";
	}

}