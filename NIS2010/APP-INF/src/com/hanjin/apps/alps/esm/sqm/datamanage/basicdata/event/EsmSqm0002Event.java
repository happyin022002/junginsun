/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0002Event.java
*@FileTitle      : Basic Data Creation
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.13
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.13 SQM USER
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SqmDirConvVO;


/**
 * ESM_SQM_0002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0002Event(){}
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SqmDirConvVO sqmDirConvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SqmDirConvVO[] sqmDirConvVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	public void setSqmDirConvVO(SqmDirConvVO sqmDirConvVO){
		this. sqmDirConvVO = sqmDirConvVO;
	}

	public void setSqmDirConvVOS(SqmDirConvVO[] sqmDirConvVOs){
		this. sqmDirConvVOs = sqmDirConvVOs;
	}

	public SqmDirConvVO getSqmDirConvVO(){
		return sqmDirConvVO;
	}

	public SqmDirConvVO[] getSqmDirConvVOS(){
		return sqmDirConvVOs;
	}
}