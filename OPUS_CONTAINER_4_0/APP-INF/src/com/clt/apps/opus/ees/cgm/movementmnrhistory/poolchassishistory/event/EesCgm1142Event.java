/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1142Event.java
*@FileTitle : Pool Chassis Comparison Detailed
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.05 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.event;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtCompareSmryMGTVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMvmtINVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1142 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1142HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1142HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1142Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EesCgm1142Event(){}
	
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
		PoolMvmtCompareSmryMGTVO[] rtnVOs = null;
		if (this.poolMvmtMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(poolMvmtMGTVOs, poolMvmtMGTVOs.length);
		}
		return rtnVOs;
	}
	/**
	 * @param poolMvmtMGTVOs the poolMvmtMGTVOs to set
	 */
	public void setPoolMvmtMGTVOs(PoolMvmtCompareSmryMGTVO[] poolMvmtMGTVOs){
		if(poolMvmtMGTVOs != null){
			PoolMvmtCompareSmryMGTVO[] tmpVOs = java.util.Arrays.copyOf(poolMvmtMGTVOs, poolMvmtMGTVOs.length);
			this.poolMvmtMGTVOs = tmpVOs;
		}
	}
	


}