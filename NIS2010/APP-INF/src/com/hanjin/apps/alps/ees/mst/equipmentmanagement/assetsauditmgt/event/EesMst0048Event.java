/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMst0035Event.java
*@FileTitle : Container Check Digit and Container Checking Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.11 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.event;

import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.event.EES_MST_0035HTMLAction;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqMftPlanListVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.vo.EqMftPlanOptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_MST_0035 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MST_0035HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Lee Ho Sun
 * @see EES_MST_0035HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMst0048Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqMftPlanOptionVO eqMftPlanOptionVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqMftPlanListVO eqMftPlanListVO = null;

	/** Table Value Object Multi Data 처리 */
	public EqMftPlanListVO[] eqMftPlanListVOs = null;

	public EqMftPlanOptionVO getEqMftPlanOptionVO() {
		return eqMftPlanOptionVO;
	}

	public void setEqMftPlanOptionVO(EqMftPlanOptionVO eqMftPlanOptionVO) {
		this.eqMftPlanOptionVO = eqMftPlanOptionVO;
	}

	public EqMftPlanListVO getEqMftPlanListVO() {
		return eqMftPlanListVO;
	}

	public void setEqMftPlanListVO(EqMftPlanListVO eqMftPlanListVO) {
		this.eqMftPlanListVO = eqMftPlanListVO;
	}

	public EqMftPlanListVO[] getEqMftPlanListVOs() {
		return eqMftPlanListVOs;
	}

	public void setEqMftPlanListVOs(EqMftPlanListVO[] eqMftPlanListVOs) {
		this.eqMftPlanListVOs = eqMftPlanListVOs;
	}
	
	
	
}