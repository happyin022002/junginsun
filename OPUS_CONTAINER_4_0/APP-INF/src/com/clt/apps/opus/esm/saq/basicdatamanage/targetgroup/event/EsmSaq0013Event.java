/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSaq0013Event.java
*@FileTitle      : Sales Quota Scope 판매목표 수립대상 및 할당 우선순위 관리
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.saq.basicdatamanage.targetgroup.vo.SearchTargetGroupTrade0013ListVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ModelConditionVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.SaqMonTgtVvdVO;
import com.clt.syscommon.common.table.SaqTgtGrpTrdVO;


/**
 * ESM_SAQ_0013 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAQ_0013HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jong-Ho Kim
 * @see ESM_SAQ_0013HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSaq0013Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SaqTgtGrpTrdVO saqTgtGrpTrdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SaqTgtGrpTrdVO[] saqTgtGrpTrdVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ModelConditionVO modelConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ModelConditionVO[] modelConditionVOs = null;	
	
	private SearchTargetGroupTrade0013ListVO searchTargetGroupTrade0013ListVO = null;
	
	private SearchTargetGroupTrade0013ListVO[] searchTargetGroupTrade0013ListVOs = null;	

	public EsmSaq0013Event(){}
	
	public void setSaqTgtGrpTrdVO(SaqTgtGrpTrdVO saqTgtGrpTrdVO){
		this.saqTgtGrpTrdVO = saqTgtGrpTrdVO;
	}

	public ModelConditionVO getModelConditionVO() {
		return modelConditionVO;
	}

	public void setModelConditionVO(ModelConditionVO modelConditionVO) {
		this.modelConditionVO = modelConditionVO;
	}

	public SaqTgtGrpTrdVO getSaqTgtGrpTrdVO(){
		return saqTgtGrpTrdVO;
	}

	public SaqTgtGrpTrdVO[] getSaqTgtGrpTrdVOS(){
		SaqTgtGrpTrdVO[] rtnVOs = null;
		if (this.saqTgtGrpTrdVOs != null) {
			rtnVOs = Arrays.copyOf(saqTgtGrpTrdVOs, saqTgtGrpTrdVOs.length);
		}
		return rtnVOs;
	}
	
	public void setSaqTgtGrpTrdVOS(SaqTgtGrpTrdVO[] saqTgtGrpTrdVOs){
		if(saqTgtGrpTrdVOs != null){
			SaqTgtGrpTrdVO[] tmpVOs = Arrays.copyOf(saqTgtGrpTrdVOs, saqTgtGrpTrdVOs.length);
			this.saqTgtGrpTrdVOs  = tmpVOs;
		}
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

	public SearchTargetGroupTrade0013ListVO getSearchTargetGroupTrade0013ListVO() {
		return searchTargetGroupTrade0013ListVO;
	}

	public void setSearchTargetGroupTrade0013ListVO(SearchTargetGroupTrade0013ListVO searchTargetGroupTrade0013ListVO) {
		this.searchTargetGroupTrade0013ListVO = searchTargetGroupTrade0013ListVO;
	}

	public SearchTargetGroupTrade0013ListVO[] getSearchTargetGroupTrade0013ListVOs() {
		SearchTargetGroupTrade0013ListVO[] rtnVOs = null;
		if (this.searchTargetGroupTrade0013ListVOs != null) {
			rtnVOs = Arrays.copyOf(searchTargetGroupTrade0013ListVOs, searchTargetGroupTrade0013ListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchTargetGroupTrade0013ListVOs(SearchTargetGroupTrade0013ListVO[] searchTargetGroupTrade0013ListVOs) {
		if(searchTargetGroupTrade0013ListVOs != null){
			SearchTargetGroupTrade0013ListVO[] tmpVOs = Arrays.copyOf(searchTargetGroupTrade0013ListVOs, searchTargetGroupTrade0013ListVOs.length);
			this.searchTargetGroupTrade0013ListVOs  = tmpVOs;
		}
	}
}