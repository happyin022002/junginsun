/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0335Event.java
*@FileTitle : EsmMas0335Event
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.01.05 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.mas.common.vo.MasCodeComboVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.vo.AverageUCVesselUtDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_MAS_0335 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0335HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jong-Ock KIM
 * @see ESM_MAS_0335HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmMas0335Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasCodeComboVO masCodeComboVO = null;
	private SearchConditionVO searchConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */		
	private AverageUCVesselUtDetailVO[] AverageUCVesselUtDetailVOs = null;
	
	public EsmMas0335Event(){}

	public MasCodeComboVO getMasCodeComboVO() {
		return masCodeComboVO;
	}

	public void setMasCodeComboVO(MasCodeComboVO masCodeComboVO) {
		this.masCodeComboVO = masCodeComboVO;
	}
	
	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

	public AverageUCVesselUtDetailVO[] getAverageUCVesselUtDetailVOs() {
		return AverageUCVesselUtDetailVOs;
	}

	public void setAverageUCVesselUtDetailVOs(AverageUCVesselUtDetailVO[] AverageUCVesselUtDetailVOs) {
		this.AverageUCVesselUtDetailVOs = AverageUCVesselUtDetailVOs;
	}
}
