package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo;

import java.util.ArrayList;
import java.util.List;

public class JooCodeInfoGrpVO {
	private List<JooCodeInfoVO> jooCodeInfoVO1s = null;
	private List<JooCodeInfoVO> jooCodeInfoVO2s = null;
	private List<JooCodeInfoVO> jooCodeInfoVO3s = null;
	
	public JooCodeInfoGrpVO(){
		jooCodeInfoVO1s = new ArrayList<JooCodeInfoVO>();
		jooCodeInfoVO2s = new ArrayList<JooCodeInfoVO>();
		jooCodeInfoVO3s = new ArrayList<JooCodeInfoVO>();
	}

	public List<JooCodeInfoVO> getJooCodeInfoVO1s() {
		return jooCodeInfoVO1s;
	}

	public void setJooCodeInfoVO1s(List<JooCodeInfoVO> jooCodeInfoVO1s) {
		this.jooCodeInfoVO1s = jooCodeInfoVO1s;
	}

	public List<JooCodeInfoVO> getJooCodeInfoVO2s() {
		return jooCodeInfoVO2s;
	}

	public void setJooCodeInfoVO2s(List<JooCodeInfoVO> jooCodeInfoVO2s) {
		this.jooCodeInfoVO2s = jooCodeInfoVO2s;
	}

	public List<JooCodeInfoVO> getJooCodeInfoVO3s() {
		return jooCodeInfoVO3s;
	}

	public void setJooCodeInfoVO3s(List<JooCodeInfoVO> jooCodeInfoVO3s) {
		this.jooCodeInfoVO3s = jooCodeInfoVO3s;
	}
}
