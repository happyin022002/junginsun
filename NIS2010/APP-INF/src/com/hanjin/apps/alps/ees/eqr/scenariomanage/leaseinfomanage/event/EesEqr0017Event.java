/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0017Event.java
*@FileTitle : ST On-Hire
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.27 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.event;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0017ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrScnrShrtTermOnhCondVO;


/**
 * EES_EQR_0017 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0017HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0017HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0017Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrScnrShrtTermOnhCondVO eqrScnrShrtTermOnhCondVO = null;
	private CommonRsVO commonRsVO = null;							// ReturnVO
	private EesEqr0017ConditionVO eesEqr0017ConditionVO = null;		// ConditionVO
	
	/** Table Value Object Multi Data 처리 */
	public EqrScnrShrtTermOnhCondVO[] eqrScnrShrtTermOnhCondVOs = null;

	public EesEqr0017Event(){}
	
	public void setEqrScnrShrtTermOnhCondVO(EqrScnrShrtTermOnhCondVO eqrScnrShrtTermOnhCondVO){
		this. eqrScnrShrtTermOnhCondVO = eqrScnrShrtTermOnhCondVO;
	}

	public void setEqrScnrShrtTermOnhCondVOS(EqrScnrShrtTermOnhCondVO[] eqrScnrShrtTermOnhCondVOs){
		this. eqrScnrShrtTermOnhCondVOs = eqrScnrShrtTermOnhCondVOs;
	}

	public EqrScnrShrtTermOnhCondVO getEqrScnrShrtTermOnhCondVO(){
		return eqrScnrShrtTermOnhCondVO;
	}

	public EqrScnrShrtTermOnhCondVO[] getEqrScnrShrtTermOnhCondVOS(){
		return eqrScnrShrtTermOnhCondVOs;
	}
	public CommonRsVO getCommonRsVO() {
		return commonRsVO;
	}

	public void setCommonRsVO(CommonRsVO commonRsVO) {
		this.commonRsVO = commonRsVO;
	}
	
	public EesEqr0017ConditionVO getEesEqr0017ConditionVO() {
		return eesEqr0017ConditionVO;
	}

	public void setEesEqr0017ConditionVO(
			EesEqr0017ConditionVO eesEqr0017ConditionVO) {
		this.eesEqr0017ConditionVO = eesEqr0017ConditionVO;
	}

}