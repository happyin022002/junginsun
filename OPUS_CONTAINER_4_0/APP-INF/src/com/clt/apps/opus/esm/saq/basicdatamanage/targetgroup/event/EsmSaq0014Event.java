/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0014Event.java
*@FileTitle      : TargetGroup
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchTargetGroup0014ListVO;
import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchTargetGroupTrade0013ListVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ModelConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqTgtGrpVO;


/**
 * ESM_SAQ_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jong-Ho Kim
 * @see ESM_SAQ_0014HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0014Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchTargetGroup0014ListVO searchTargetGroup0014ListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchTargetGroup0014ListVO[] searchTargetGroup0014ListVOs = null;
	
	
	private SaqTgtGrpVO saqTgtGrpVO = null;
	
	private SaqTgtGrpVO[] saqTgtGrpVOs = null;

	
	private ModelConditionVO modelConditionVO = null;
	
	private ModelConditionVO[] modelConditionVOs = null;
	
	
	public EsmSaq0014Event(){}

	public SearchTargetGroup0014ListVO getSearchTargetGroup0014ListVO() {
		return searchTargetGroup0014ListVO;
	}

	public void setSearchTargetGroup0014ListVO(
			SearchTargetGroup0014ListVO searchTargetGroup0014ListVO) {
		this.searchTargetGroup0014ListVO = searchTargetGroup0014ListVO;
	}

	public SearchTargetGroup0014ListVO[] getSearchTargetGroup0014ListVOs() {
		SearchTargetGroup0014ListVO[] rtnVOs = null;
		if (this.searchTargetGroup0014ListVOs != null) {
			rtnVOs = Arrays.copyOf(searchTargetGroup0014ListVOs, searchTargetGroup0014ListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchTargetGroup0014ListVOs(SearchTargetGroup0014ListVO[] searchTargetGroup0014ListVOs) {
		if(searchTargetGroup0014ListVOs != null){
			SearchTargetGroup0014ListVO[] tmpVOs = Arrays.copyOf(searchTargetGroup0014ListVOs, searchTargetGroup0014ListVOs.length);
			this.searchTargetGroup0014ListVOs  = tmpVOs;
		}
	}	
	
	public void setSaqTgtGrpVO(SaqTgtGrpVO saqTgtGrpVO){
		this. saqTgtGrpVO = saqTgtGrpVO;
	}

	public SaqTgtGrpVO getSaqTgtGrpVO(){
		return saqTgtGrpVO;
	}

	public SaqTgtGrpVO[] getSaqTgtGrpVOS(){
		SaqTgtGrpVO[] rtnVOs = null;
		if (this.saqTgtGrpVOs != null) {
			rtnVOs = Arrays.copyOf(saqTgtGrpVOs, saqTgtGrpVOs.length);
		}
		return rtnVOs;
	}
	
	public void setSaqTgtGrpVOS(SaqTgtGrpVO[] saqTgtGrpVOs){
		if(saqTgtGrpVOs != null){
			SaqTgtGrpVO[] tmpVOs = Arrays.copyOf(saqTgtGrpVOs, saqTgtGrpVOs.length);
			this.saqTgtGrpVOs  = tmpVOs;
		}
	}	
	
	public ModelConditionVO getModelConditionVO() {
		return modelConditionVO;
	}

	public void setModelConditionVO(ModelConditionVO modelConditionVO) {
		this.modelConditionVO = modelConditionVO;
	}

	public ModelConditionVO[] getModelConditionVOs() {
		ModelConditionVO[] rtnVOs = null;
		if (this.modelConditionVOs != null) {
			rtnVOs = Arrays.copyOf(modelConditionVOs, modelConditionVOs.length);
		}
		return rtnVOs;
	}

	public void setModelConditionVOs(ModelConditionVO[] modelConditionVOs) {
		if(modelConditionVOs != null){
			ModelConditionVO[] tmpVOs = Arrays.copyOf(modelConditionVOs, modelConditionVOs.length);
			this.modelConditionVOs  = tmpVOs;
		}
	}
}