/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1141Event.java
*@FileTitle : Pool Chassis Comparison Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.04
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.04 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.event;

import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtCompareSmryMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1141 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1141HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1141HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1141Event extends EventSupport {

	private static final long serialVersionUID = 1L;


	

	public EesCgm1141Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PoolMvmtCompareSmryMGTVO poolMvmtMGTVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PoolMvmtINVO poolMvmtINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PoolMvmtCompareSmryMGTVO[] poolMvmtMGTVOs = null;




	/**
	 * @return the poolMvmtMGTVO
	 */
	public PoolMvmtCompareSmryMGTVO getPoolMvmtMGTVO() {
		return poolMvmtMGTVO;
	}

	/**
	 * @param poolMvmtMGTVO the poolMvmtMGTVO to set
	 */
	public void setPoolMvmtMGTVO(PoolMvmtCompareSmryMGTVO poolMvmtMGTVO) {
		this.poolMvmtMGTVO = poolMvmtMGTVO;
	}

	/**
	 * @return the poolMvmtINVO
	 */
	public PoolMvmtINVO getPoolMvmtINVO() {
		return poolMvmtINVO;
	}

	/**
	 * @param poolMvmtINVO the poolMvmtINVO to set
	 */
	public void setPoolMvmtINVO(PoolMvmtINVO poolMvmtINVO) {
		this.poolMvmtINVO = poolMvmtINVO;
	}

	/**
	 * @return the poolMvmtMGTVOs
	 */
	public PoolMvmtCompareSmryMGTVO[] getPoolMvmtMGTVOs() {
		return poolMvmtMGTVOs;
	}

	/**
	 * @param poolMvmtMGTVOs the poolMvmtMGTVOs to set
	 */
	public void setPoolMvmtMGTVOs(PoolMvmtCompareSmryMGTVO[] poolMvmtMGTVOs) {
		this.poolMvmtMGTVOs = poolMvmtMGTVOs;
	}
	
	

}