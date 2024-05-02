/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EesEqr0008Event.java
*@FileTitle : Manage EQR Week
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.06
*@LastModifier : 김성락
*@LastVersion : 1.0
* 2012.04.06 김성락
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.event;

import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrWkPrdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Sung Rak
 * @see EES_EQR_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private EqrWkPrdVO eqrWkPrdVO;
	private EqrWkPrdVO[] eqrWkPrdVOs;
	private String plnYr;


	public String getPlnYr() {
		return plnYr;
	}


	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}


	public EesEqr0008Event(){}


	/**
	 * Get EQRWkPrdVO
	 * @return EqrWkPrdVO
	 */
	public EqrWkPrdVO getEqrWkPrdVO() {
		return eqrWkPrdVO;
	}

	/**
	 * Set EQRWkPrdVO
	 * @param EqrWkPrdVO eqrWkPrdVO
	 */
	public void setEqrWkPrdVO(EqrWkPrdVO eqrWkPrdVO) {
		this.eqrWkPrdVO = eqrWkPrdVO;
	}

	/**
	 * Get the array of EQRWkPrdVO
	 * @return EqrWkPrdVO[]
	 */
	public EqrWkPrdVO[] getEqrWkPrdVOs() {
		EqrWkPrdVO[] tmpVOs = null;
		if (this.eqrWkPrdVOs != null) {
			tmpVOs = new EqrWkPrdVO[eqrWkPrdVOs.length];
			System.arraycopy(eqrWkPrdVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * Set the array of EQRWkPrdVO
	 * @param EqrWkPrdVO[] eqrWkPrdVOs
	 */
	public void setEqrWkPrdVOs(EqrWkPrdVO[] eqrWkPrdVOs) {
		if (eqrWkPrdVOs != null) {
			EqrWkPrdVO[] tmpVOs = new EqrWkPrdVO[eqrWkPrdVOs.length];
			System.arraycopy(eqrWkPrdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eqrWkPrdVOs = tmpVOs;
		}
	}

}