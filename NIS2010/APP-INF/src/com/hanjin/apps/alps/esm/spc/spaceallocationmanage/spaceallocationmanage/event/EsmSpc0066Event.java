/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0066Event.java
*@FileTitle : Temporary Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.08.25 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageTempListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcAlocPolPodVO;


/**
 * ESM_SPC_0066 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0066HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI Yun Sung
 * @see ESM_SPC_0066HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0066Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpcAlocPolPodVO spcAlocPolPodVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpcAlocPolPodVO[] spcAlocPolPodVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SpaceAllocationManageTempListVO spaceAllocationManageTempListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SpaceAllocationManageTempListVO[] spaceAllocationManageTempListVOs = null;

	public EsmSpc0066Event(){}
	
	public void setSpcAlocPolPodVO(SpcAlocPolPodVO spcAlocPolPodVO){
		this. spcAlocPolPodVO = spcAlocPolPodVO;
	}

	public void setSpcAlocPolPodVOS(SpcAlocPolPodVO[] spcAlocPolPodVOs){
		if (spcAlocPolPodVOs != null) {
			SpcAlocPolPodVO[] tmpVOs = new SpcAlocPolPodVO[spcAlocPolPodVOs.length];
			System.arraycopy(spcAlocPolPodVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spcAlocPolPodVOs = tmpVOs;
		}
	}

	public void setSpaceAllocationManageTempListVO(SpaceAllocationManageTempListVO spaceAllocationManageTempListVO){
		this. spaceAllocationManageTempListVO = spaceAllocationManageTempListVO;
	}

	public void setSpaceAllocationManageTempListVOS(SpaceAllocationManageTempListVO[] spaceAllocationManageTempListVOs){
		if (spaceAllocationManageTempListVOs != null) {
			SpaceAllocationManageTempListVO[] tmpVOs = new SpaceAllocationManageTempListVO[spaceAllocationManageTempListVOs.length];
			System.arraycopy(spaceAllocationManageTempListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.spaceAllocationManageTempListVOs = tmpVOs;
		}
	}

	public SpcAlocPolPodVO getSpcAlocPolPodVO(){
		return spcAlocPolPodVO;
	}

	public SpcAlocPolPodVO[] getSpcAlocPolPodVOS(){
		SpcAlocPolPodVO[] rtnVOs = null;
		if (this.spcAlocPolPodVOs != null) {
			rtnVOs = new SpcAlocPolPodVO[spcAlocPolPodVOs.length];
			System.arraycopy(spcAlocPolPodVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SpaceAllocationManageTempListVO getSpaceAllocationManageTempListVO(){
		return spaceAllocationManageTempListVO;
	}

	public SpaceAllocationManageTempListVO[] getSpaceAllocationManageTempListVOS(){
		SpaceAllocationManageTempListVO[] rtnVOs = null;
		if (this.spaceAllocationManageTempListVOs != null) {
			rtnVOs = new SpaceAllocationManageTempListVO[spaceAllocationManageTempListVOs.length];
			System.arraycopy(spaceAllocationManageTempListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}