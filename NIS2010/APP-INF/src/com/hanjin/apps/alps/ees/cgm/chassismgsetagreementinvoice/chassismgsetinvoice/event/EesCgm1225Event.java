/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1225Event.java
*@FileTitle : Estimated Pool Chassis Expense(Co-Pool N/P)
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.23
*@LastModifier : Chang-Young Kim
*@LastVersion : 1.0
* 2015.07.23 Chang-Young Kim
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1225 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1225HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1225HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1225Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PoolEstmExpenseINVO poolEstmExpenseINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PoolEstmExpenseMGTVO[] poolEstmExpenseMGTVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PoolEstmExpenseMGTVO  poolEstmExpenseMGTVO = null;

	public EesCgm1225Event(){}

	/**
	 * @return the poolEstmExpenseINVO
	 */
	public PoolEstmExpenseINVO getPoolEstmExpenseINVO() {
		return poolEstmExpenseINVO;
	}

	/**
	 * @param poolEstmExpenseINVO the poolEstmExpenseINVO to set
	 */
	public void setPoolEstmExpenseINVO(PoolEstmExpenseINVO poolEstmExpenseINVO) {
		this.poolEstmExpenseINVO = poolEstmExpenseINVO;
	}

	/**
	 * @return the poolEstmExpenseMGTVOs
	 */
	public PoolEstmExpenseMGTVO[] getPoolEstmExpenseMGTVOs() {
		PoolEstmExpenseMGTVO[] rtnVOs = null;
		if (this.poolEstmExpenseMGTVOs != null) {
			rtnVOs = new PoolEstmExpenseMGTVO[poolEstmExpenseMGTVOs.length];
			System.arraycopy(poolEstmExpenseMGTVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param poolEstmExpenseMGTVOs the poolEstmExpenseMGTVOs to set
	 */
	public void setPoolEstmExpenseMGTVOs(PoolEstmExpenseMGTVO[] poolEstmExpenseMGTVOs){
		if(poolEstmExpenseMGTVOs != null){
			PoolEstmExpenseMGTVO[] tmpVOs = Arrays.copyOf(poolEstmExpenseMGTVOs, poolEstmExpenseMGTVOs.length);
			this.poolEstmExpenseMGTVOs = tmpVOs;
		}
	}

	/**
	 * @return the poolEstmExpenseMGTVO
	 */
	public PoolEstmExpenseMGTVO getPoolEstmExpenseMGTVO() {
		return poolEstmExpenseMGTVO;
	}

	/**
	 * @param poolEstmExpenseMGTVO the poolEstmExpenseMGTVO to set
	 */
	public void setPoolEstmExpenseMGTVO(PoolEstmExpenseMGTVO poolEstmExpenseMGTVO) {
		this.poolEstmExpenseMGTVO = poolEstmExpenseMGTVO;
	}
	
	
	
	
	 

}