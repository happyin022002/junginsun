/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_EQR_1031HTMLAction.java
*@FileTitle : Guideline Mailing
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.03
*@LastModifier : YONGCHAN SHIN
*@LastVersion : 1.0
* 2014.01.03 YONGCHAN SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.event;

import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1031ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_EQR_1031 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1031HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author YONGCHAN SHIN
 * @see EES_EQR_1031HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr1031Event extends EventSupport {

	private static final long serialVersionUID = 1L;	
	private EesEqr1031ConditionVO eesEqr1031ConditionVO = null;
	
	public EesEqr1031ConditionVO getEesEqr1031ConditionVO() {
		return eesEqr1031ConditionVO;
	}

	public void setEesEqr1031ConditionVO(EesEqr1031ConditionVO eesEqr1031ConditionVO) {
		this.eesEqr1031ConditionVO = eesEqr1031ConditionVO;
	}

}