/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsGem000101Event.java
 *@FileTitle : Expense Request init , additional
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.22
 *@LastModifier : 최정미
 *@LastVersion : 1.0
 * 2009.04.22 최정미
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event;


import com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.vo.PlanningVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 *[UI_GEM-0001-01] Expense Request init , additional
 * @author choijungmi
 * @see CPS_GEM_0001_01HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsGem000101Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String plnYrmon = "";
	private  String genExpnRqstNo = "";
	private  String ofcCd = "";
	private  String genExpnCd = "";
	private  String ticCd = "";
	private  String genExpnGroupCd = "";
	private String genExpnRqstSeq = "";
	
    public String getGenExpnRqstSeq() {
		return genExpnRqstSeq;
	}

	public void setGenExpnRqstSeq(String genExpnRqstSeq) {
		this.genExpnRqstSeq = genExpnRqstSeq;
	}
	
    public String getGenExpnGroupCd() {
		return genExpnGroupCd;
	}

	public void setGenExpnGroupCd(String genExpnGroupCd) {
		this.genExpnGroupCd = genExpnGroupCd;
	}

	public String getTicCd() {
		return ticCd;
	}

	public void setTicCd(String ticCd) {
		this.ticCd = ticCd;
	}

	private PlanningVO planningVO ;

	public PlanningVO getPlanningVO() {
		return planningVO;
	}

	public void setPlanningVO(PlanningVO planningVO) {
		this.planningVO = planningVO;
	}

	public String getPlnYrmon() {
		return plnYrmon;
	}

	public void setPlnYrmon(String plnYrmon) {
		this.plnYrmon = plnYrmon;
	}

	public String getGenExpnRqstNo() {
		return genExpnRqstNo;
	}

	public void setGenExpnRqstNo(String genExpnRqstNo) {
		this.genExpnRqstNo = genExpnRqstNo;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getGenExpnCd() {
		return genExpnCd;
	}

	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}

		
	
	



}