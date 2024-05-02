/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EesCgm1145Event.java
*@FileTitle : Invoice File Import(Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.15 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.event;

import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolUseddysINVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.vo.PoolUseddysMGTVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_CGM_1145 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_CGM_1145HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI MIN HOI
 * @see EES_CGM_1145HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesCgm1145Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PoolUseddysINVO poolUseddysINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PoolUseddysMGTVO[] poolUseddysMGTVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private PoolUseddysMGTVO poolUseddysMGTVO = null;

	/**
	 * @return the poolUseddysINVO
	 */
	public PoolUseddysINVO getPoolUseddysINVO() {
		return poolUseddysINVO;
	}

	/**
	 * @param poolUseddysINVO the poolUseddysINVO to set
	 */
	public void setPoolUseddysINVO(PoolUseddysINVO poolUseddysINVO) {
		this.poolUseddysINVO = poolUseddysINVO;
	}

	/**
	 * @return the poolUseddysMGTVOs
	 */
	public PoolUseddysMGTVO[] getPoolUseddysMGTVOs() {
		return poolUseddysMGTVOs;
	}

	/**
	 * @param poolUseddysMGTVOs the poolUseddysMGTVOs to set
	 */
	public void setPoolUseddysMGTVOs(PoolUseddysMGTVO[] poolUseddysMGTVOs) {
		this.poolUseddysMGTVOs = poolUseddysMGTVOs;
	}

	/**
	 * @return the poolUseddysMGTVO
	 */
	public PoolUseddysMGTVO getPoolUseddysMGTVO() {
		return poolUseddysMGTVO;
	}

	/**
	 * @param poolUseddysMGTVO the poolUseddysMGTVO to set
	 */
	public void setPoolUseddysMGTVO(PoolUseddysMGTVO poolUseddysMGTVO) {
		this.poolUseddysMGTVO = poolUseddysMGTVO;
	}


}