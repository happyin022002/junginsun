/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAO.java
*@FileTitle : Container Guideline Manage
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
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.event;
 
import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo.EesEqr1013ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo.EesEqr1013MtRepoPlanVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_EQR_1008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHIN DONG IL
 * @see EES_EQR_1013HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private EesEqr1013ConditionVO eesEqr1013ConditionVO = null;
	
	public EesEqr1013MtRepoPlanVO[] eesEqr1013MtRepoPlanVOs = null;
	
//	String all_cntr_tpsz_cd = null;
//	
//	
//	public String getAll_cntr_tpsz_cd() {
//		return all_cntr_tpsz_cd;
//	}
//
//	public void setAll_cntr_tpsz_cd(String all_cntr_tpsz_cd) {
//		this.all_cntr_tpsz_cd = all_cntr_tpsz_cd;
//	}

	public EesEqr1013ConditionVO getEesEqr1013ConditionVO() {
		return eesEqr1013ConditionVO;
	}

	public void setEesEqr1013ConditionVO(EesEqr1013ConditionVO eesEqr1013ConditionVO) {
		this.eesEqr1013ConditionVO = eesEqr1013ConditionVO;
	}

	public EesEqr1013MtRepoPlanVO[] getEesEqr1013MtRepoPlanVO() {
		return eesEqr1013MtRepoPlanVOs;
	}

	public void setEesEqr1013MtRepoPlanVO(EesEqr1013MtRepoPlanVO[] eesEqr1013MtRepoPlanVOs) {
		this.eesEqr1013MtRepoPlanVOs = eesEqr1013MtRepoPlanVOs;
	}

}