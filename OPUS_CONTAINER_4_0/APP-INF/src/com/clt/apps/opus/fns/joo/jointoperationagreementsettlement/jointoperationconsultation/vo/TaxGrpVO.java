package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo;

import java.util.ArrayList;
import java.util.List;

import com.clt.syscommon.common.table.JooTaxDtlVO;
import com.clt.syscommon.common.table.JooTaxVO;

public class TaxGrpVO {
	private JooTaxVO          jooTaxVO     = null;
	private List<JooTaxVO>    jooTaxVOs    = null;
	private List<JooTaxDtlVO> jooTaxDtlVOs = null;
	
	public TaxGrpVO(){
		jooTaxVO     = new JooTaxVO();
		jooTaxVOs    = new ArrayList<JooTaxVO>();
		jooTaxDtlVOs = new ArrayList<JooTaxDtlVO>();
	}

	public JooTaxVO getJooTaxVO() {
		return jooTaxVO;
	}
	public void setJooTaxVO(JooTaxVO jooTaxVO) {
		this.jooTaxVO = jooTaxVO;
	}
	public List<JooTaxVO> getJooTaxVOs() {
		return jooTaxVOs;
	}
	public void setJooTaxVOs(List<JooTaxVO> jooTaxVOs) {
		this.jooTaxVOs = jooTaxVOs;
	}
	public List<JooTaxDtlVO> getJooTaxDtlVOs() {
		return jooTaxDtlVOs;
	}
	public void setJooTaxDtlVOs(List<JooTaxDtlVO> jooTaxDtlVOs) {
		this.jooTaxDtlVOs = jooTaxDtlVOs;
	}
}
