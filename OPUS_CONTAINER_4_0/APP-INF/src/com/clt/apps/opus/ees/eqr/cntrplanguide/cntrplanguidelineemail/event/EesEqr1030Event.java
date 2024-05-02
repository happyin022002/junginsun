/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_EQR_1030HTMLAction.java
*@FileTitle : Guideline Email
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.03
*@LastModifier : YONGCHAN SHIN
*@LastVersion : 1.0
* 2014.01.03 YONGCHAN SHIN
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.event;

import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1030ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1030MultiVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_EQR_1030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author YONGCHAN SHIN
 * @see EES_EQR_1030HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr1030Event extends EventSupport {

	private static final long serialVersionUID = 1L;	
	private EesEqr1030ConditionVO eesEqr1030ConditionVO = null;
	private EesEqr1030MultiVO eesEqr1030MultiVO = null;
	private EesEqr1030MultiVO[] eesEqr1030MultiVOs = null;	
	
	public EesEqr1030ConditionVO getEesEqr1030ConditionVO() {
		return eesEqr1030ConditionVO;
	}

	public void setEesEqr1030ConditionVO(EesEqr1030ConditionVO eesEqr1030ConditionVO) {
		this.eesEqr1030ConditionVO = eesEqr1030ConditionVO;
	}
	
	public EesEqr1030MultiVO getEesEqr1030MultiVO() {
		return eesEqr1030MultiVO;
	}

	public void setEesEqr1030MultiVO(EesEqr1030MultiVO eesEqr1030MultiVO) {
		this.eesEqr1030MultiVO = eesEqr1030MultiVO;
	}

	public EesEqr1030MultiVO[] getEesEqr1030MultiVOs() {
		EesEqr1030MultiVO[] tmpVOs = null;
		if (this.eesEqr1030MultiVOs != null) {
			tmpVOs = new EesEqr1030MultiVO[eesEqr1030MultiVOs.length];
			System.arraycopy(eesEqr1030MultiVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setEesEqr1030MultiVOs(EesEqr1030MultiVO[] eesEqr1030MultiVOs) {
		if (eesEqr1030MultiVOs != null) {
			EesEqr1030MultiVO[] tmpVOs = new EesEqr1030MultiVO[eesEqr1030MultiVOs.length];
			System.arraycopy(eesEqr1030MultiVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eesEqr1030MultiVOs = tmpVOs;
		}
	}		



}