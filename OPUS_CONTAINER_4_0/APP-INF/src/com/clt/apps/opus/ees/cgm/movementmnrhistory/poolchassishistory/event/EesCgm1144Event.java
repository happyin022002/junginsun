/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesCgm1144Event.java
*@FileTitle : Pool Chassis M&R Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.13 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.event;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMnrHistoryINVO;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolMnrHistoryMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1144 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1144HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1144HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1144Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PoolMnrHistoryINVO poolMnrHistoryINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PoolMnrHistoryMGTVO[] poolMnrHistoryMGTVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private PoolMnrHistoryMGTVO poolMnrHistoryMGTVO = null;

	public EesCgm1144Event(){}

	/**
	 * @return the poolMnrHistoryINVO
	 */
	public PoolMnrHistoryINVO getPoolMnrHistoryINVO() {
		return poolMnrHistoryINVO;
	}

	/**
	 * @param poolMnrHistoryINVO the poolMnrHistoryINVO to set
	 */
	public void setPoolMnrHistoryINVO(PoolMnrHistoryINVO poolMnrHistoryINVO) {
		this.poolMnrHistoryINVO = poolMnrHistoryINVO;
	}

	/**
	 * @return the poolMnrHistoryMGTVOs
	 */
	public PoolMnrHistoryMGTVO[] getPoolMnrHistoryMGTVOs() {
		PoolMnrHistoryMGTVO[] rtnVOs = null;
		if (this.poolMnrHistoryMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(poolMnrHistoryMGTVOs, poolMnrHistoryMGTVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param poolMnrHistoryMGTVOs the poolMnrHistoryMGTVOs to set
	 */
	public void setPoolMnrHistoryMGTVOs(PoolMnrHistoryMGTVO[] poolMnrHistoryMGTVOs){
		if(poolMnrHistoryMGTVOs != null){
			PoolMnrHistoryMGTVO[] tmpVOs = java.util.Arrays.copyOf(poolMnrHistoryMGTVOs, poolMnrHistoryMGTVOs.length);
			this.poolMnrHistoryMGTVOs = tmpVOs;
		}
	}

	/**
	 * @return the poolMnrHistoryMGTVO
	 */
	public PoolMnrHistoryMGTVO getPoolMnrHistoryMGTVO() {
		return poolMnrHistoryMGTVO;
	}

	/**
	 * @param poolMnrHistoryMGTVO the poolMnrHistoryMGTVO to set
	 */
	public void setPoolMnrHistoryMGTVO(PoolMnrHistoryMGTVO poolMnrHistoryMGTVO) {
		this.poolMnrHistoryMGTVO = poolMnrHistoryMGTVO;
	}
	

}