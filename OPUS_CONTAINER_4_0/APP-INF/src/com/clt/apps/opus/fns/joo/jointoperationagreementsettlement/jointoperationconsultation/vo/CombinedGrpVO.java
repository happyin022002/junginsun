package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo;

import com.clt.syscommon.common.table.JooSettlementVO;

import java.util.ArrayList;
import java.util.List;

public class CombinedGrpVO {
	private CombinedVO combinedVO = null;
	private JooSettlementVO jooSettlementVO = null;
	private List<CombinedVO> combinedVOs = null;
	private List<JooSettlementVO> jooSettlementVOs = null;
	
	public CombinedGrpVO(){
		combinedVO = new CombinedVO();
		jooSettlementVO = new JooSettlementVO();
		combinedVOs = new ArrayList<CombinedVO>();
		jooSettlementVOs = new ArrayList<JooSettlementVO>();
	}
	
	public CombinedVO getCombinedVO() {
		return combinedVO;
	}

	public void setCombinedVO(CombinedVO combinedVO) {
		this.combinedVO = combinedVO;
	}

	public JooSettlementVO getJooSettlementVO() {
		return jooSettlementVO;
	}

	public void setJooSettlementVO(JooSettlementVO jooSettlementVO) {
		this.jooSettlementVO = jooSettlementVO;
	}

	public List<CombinedVO> getCombinedVOs() {
		return combinedVOs;
	}

	public void setCombinedVOs(List<CombinedVO> combinedVOs) {
		this.combinedVOs = combinedVOs;
	}

	public List<JooSettlementVO> getJooSettlementVOs() {
		return jooSettlementVOs;
	}

	public void setJooSettlementVOs(List<JooSettlementVO> jooSettlementVOs) {
		this.jooSettlementVOs = jooSettlementVOs;
	}
}
