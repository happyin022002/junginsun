/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_EQR_1050HTMLAction.java
*@FileTitle : Empty ROB Bkg VVD List
*Open Issues :
*Change history : 1. 2014-03-07, CHM-201429123, ROB booking 기능 추가, YongChan Shin
*@LastModifyDate : 2014.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event;

import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1050ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1050 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1050HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_1050HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1050Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private EesEqr1050ConditionVO eesEqr1050ConditionVO = null;
	

	public EesEqr1050Event(){}
	
	public EesEqr1050ConditionVO getEesEqr1050ConditionVO() {
		return eesEqr1050ConditionVO;
	}

	public void setEesEqr1050ConditionVO(EesEqr1050ConditionVO eesEqr1050ConditionVO) {
		this.eesEqr1050ConditionVO = eesEqr1050ConditionVO;
	}

	
}