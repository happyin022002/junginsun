/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAO.java
*@FileTitle : Guideline Add/Amend Event
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1     1.0      	SHIN DONG IL						2013.05.27		 Creation
*
*@LastModifyDate : 2013.05.27
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.05.27 SHIN DONG IL
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.event;


import com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1009ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_EQR_1009 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * EES_EQR_1009HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * @author SHIN DONG IL
 * @see EES_EQR_1009HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr1009Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	String cntr_tpsz_cd = null;
	
	private EesEqr1009ConditionVO eesEqr1009ConditionVO = null;

	
	public String getCntr_tpsz_cd() {
		return cntr_tpsz_cd;
	}
	
	public void setCntr_tpsz_cd(String cntr_tpsz_cd) {
		this.cntr_tpsz_cd = cntr_tpsz_cd;
	}
	
	public EesEqr1009ConditionVO getEesEqr1009ConditionVO() {
		return eesEqr1009ConditionVO;
	}
	public void setEesEqr1009ConditionVO(EesEqr1009ConditionVO eesEqr1009ConditionVO) {
		this.eesEqr1009ConditionVO = eesEqr1009ConditionVO;
	}
		
}