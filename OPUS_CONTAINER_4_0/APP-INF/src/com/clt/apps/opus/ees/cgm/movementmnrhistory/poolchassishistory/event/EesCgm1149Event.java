/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EesCgm1149Event.java
*@FileTitle : Import Error Report (Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.21 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.event;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolUseddysMGTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1149 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1149HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1149HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1149Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PoolUseddysMGTVO poolUseddysMGTVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PoolUseddysMGTVO[] poolUseddysMGTVOs = null;

	public EesCgm1149Event(){}
	
	public void setPoolUseddysMGTVO(PoolUseddysMGTVO poolUseddysMGTVO){
		this. poolUseddysMGTVO = poolUseddysMGTVO;
	}

	public void setPoolUseddysMGTVOS(PoolUseddysMGTVO[] poolUseddysMGTVOs){
		if(poolUseddysMGTVOs != null){
			PoolUseddysMGTVO[] tmpVOs = java.util.Arrays.copyOf(poolUseddysMGTVOs, poolUseddysMGTVOs.length);
			this.poolUseddysMGTVOs = tmpVOs;
		}
	}

	public PoolUseddysMGTVO getPoolUseddysMGTVO(){
		return poolUseddysMGTVO;
	}

	public PoolUseddysMGTVO[] getPoolUseddysMGTVOS(){
		PoolUseddysMGTVO[] rtnVOs = null;
		if (this.poolUseddysMGTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(poolUseddysMGTVOs, poolUseddysMGTVOs.length);
		}
		return rtnVOs;
	}

}