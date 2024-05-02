/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EsmSpc0091Event.java
*@FileTitle : SMP History
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.17 진마리아
* 1.0 Creation
* 2013.01.17 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.vo.SearchModelManageListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.SpcMdlVerMstVO;


/**
 * ESM_SPC_0030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see ESM_SPC_0090HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0091Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchModelManageListVO searchModelManageListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchModelManageListVO[] searchModelManageListVOs = null;

	public EsmSpc0091Event(){}
	
	
	public SearchModelManageListVO getSearchModelManageListVO() {
		return searchModelManageListVO;
	}

	public void setSearchModelManageListVO(
			SearchModelManageListVO searchModelManageListVO) {
		this.searchModelManageListVO = searchModelManageListVO;
	}

	public SearchModelManageListVO[] getSearchModelManageListVOs() {
		return searchModelManageListVOs;
	}

	public void setSearchModelManageListVOs(
			SearchModelManageListVO[] searchModelManageListVOs) {
		this.searchModelManageListVOs = searchModelManageListVOs;
	}


	private ConditionVO conditionVO = null;
	private ConditionVO[] conditionVOs = null;
	private SpcMdlVerMstVO spcMdlVerMstVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	public ConditionVO[] getConditionVOs() {
		return conditionVOs;
	}


	public void setConditionVOs(ConditionVO[] conditionVOs) {
		this.conditionVOs = conditionVOs;
	}

	public SpcMdlVerMstVO getSpcMdlVerMstVO() {
		return spcMdlVerMstVO;
	}


	public void setSpcMdlVerMstVO(SpcMdlVerMstVO spcMdlVerMstVO) {
		this.spcMdlVerMstVO = spcMdlVerMstVO;
	}

	private String slsRhqCd = null;
	private String slsRgnOfcCd = null;
	private String trdCd = null;
	private String subTrdCd = null;
	private String rlaneCd = null;

	public String getSlsRhqCd() {
		return slsRhqCd;
	}

	public void setSlsRhqCd(String slsRhqCd) {
		this.slsRhqCd = slsRhqCd;
	}

	public String getSlsRgnOfcCd() {
		return slsRgnOfcCd;
	}

	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
	}

	public String getTrdCd() {
		return trdCd;
	}

	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}

	public String getSubTrdCd() {
		return subTrdCd;
	}

	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}

	public String getRlaneCd() {
		return rlaneCd;
	}

	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
}