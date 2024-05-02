/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1143Event.java
*@FileTitle : Pool Chassis Expense Trend
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.12 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.event;

import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolExpenseTrendMGTVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtINVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1143 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1143HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1143HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1143Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PoolMvmtINVO poolMvmtINVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PoolExpenseTrendMGTVO[] poolExpenseTrendMGTVOs = null;
	
	/**
	 * @return the poolExpenseTrendMGTVOs
	 */
	public PoolExpenseTrendMGTVO[] getPoolExpenseTrendMGTVOs() {
		return poolExpenseTrendMGTVOs;
	}

	/**
	 * @param poolExpenseTrendMGTVOs the poolExpenseTrendMGTVOs to set
	 */
	public void setPoolExpenseTrendMGTVOs(
			PoolExpenseTrendMGTVO[] poolExpenseTrendMGTVOs) {
		this.poolExpenseTrendMGTVOs = poolExpenseTrendMGTVOs;
	}

	/**
	 * @return the poolExpenseTrendMGTVO
	 */
	public PoolExpenseTrendMGTVO getPoolExpenseTrendMGTVO() {
		return poolExpenseTrendMGTVO;
	}

	/**
	 * @param poolExpenseTrendMGTVO the poolExpenseTrendMGTVO to set
	 */
	public void setPoolExpenseTrendMGTVO(PoolExpenseTrendMGTVO poolExpenseTrendMGTVO) {
		this.poolExpenseTrendMGTVO = poolExpenseTrendMGTVO;
	}



	/** Table Value Object 조회 조건 및 단건 처리  */
	private PoolExpenseTrendMGTVO poolExpenseTrendMGTVO  = null;
	
 
	public EesCgm1143Event(){}
	
	public void setPoolMvmtINVO(PoolMvmtINVO poolMvmtINVO){
		this. poolMvmtINVO = poolMvmtINVO;
	}

 

	public PoolMvmtINVO getPoolMvmtINVO(){
		return poolMvmtINVO;
	}

 

}