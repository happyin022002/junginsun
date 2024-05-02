/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr122ConditionVO.java
*@FileTitle : EesEqr122ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrrepoplanoptiexecute.vo;
import java.util.HashMap;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0049ConditionVO extends AbstractValueObject {
	
	private static final long serialVersionUID = 1L;
	
	/* Condition Info */
	private String scnryrwk = null;

	/* Condition Info */
	private String scnrseq = null;
	
	/* Condition Info */
	private String inclu_onh_flg = null;
	
	/* Condition Info */
	private String inclu_offh_flg = null;

	/* Condition Info */
	private String repo_auto_gen_flg = null;
	
	/* Condition Info */
	private String sold_flg = null;
	
	/* Condition Info */
	private String duration = null;
	
	/* Condition Info */
	private String cntrTpszCd = null;
	
	/* Condition Info */
	private String flag = null;
	
	/* Condition Info */
	private String styear = null;
	
	/* Condition Info */
	private String stmonth = null;
	
	/* Condition Info */
	private String stweekly = null;
	
	/* Condition Info */
	private String endyear = null;
	
	/* Condition Info */
	private String endmonth = null;
	
	/* Condition Info */
	private String endweekly = null;
	
	/* Condition Info */
	private String scnrid = null;
	
	/* Condition Info */
	private String repo_pln_rmk = null;
	
	/* Condition Info */
	private String repo_plan_id = null;
	
	/* Condition Info */
	private String sim_pln_id = null;
	
	/* Condition Info */
	private String sensitivity_code = null;
	
	/* Condition Info */
	private String object_code = null;
	
	/* Condition Info */
	private String run_id_no = null;
	
	/* Condition Info */
	private String repo_pln_dtrb_flg =null;
	
	/* Condition Info */
	private String delt_flg =null;
	
	/* Condition Info */
	private String user_id =null;
	
	/* Condition Info */
	private String old_scnr_id = null;
	
	public EesEqr0049ConditionVO() {}

	

	/**
	 * @return the scnryrwk
	 */
	public String getScnrYrWk() {
		return scnryrwk;
	}



	/**
	 * @param scnryrwk the scnryrwk to set
	 */
	public void setScnrYrWk(String scnryrwk) {
		this.scnryrwk = scnryrwk;
	}



	/**
	 * @return the scnrseq
	 */
	public String getScnrSeq() {
		return scnrseq;
	}



	/**
	 * @param scnrseq the scnrseq to set
	 */
	public void setScnrSeq(String scnrseq) {
		this.scnrseq = scnrseq;
	}



	/**
	 * @return the inclu_onh_flg
	 */
	public String getInclu_onh_flg() {
		return inclu_onh_flg;
	}





	/**
	 * @param inclu_onh_flg the inclu_onh_flg to set
	 */
	public void setInclu_onh_flg(String inclu_onh_flg) {
		this.inclu_onh_flg = inclu_onh_flg;
	}





	/**
	 * @return the inclu_offh_flg
	 */
	public String getInclu_offh_flg() {
		return inclu_offh_flg;
	}





	/**
	 * @param inclu_offh_flg the inclu_offh_flg to set
	 */
	public void setInclu_offh_flg(String inclu_offh_flg) {
		this.inclu_offh_flg = inclu_offh_flg;
	}





	/**
	 * @return the repo_auto_gen_flg
	 */
	public String getRepo_auto_gen_flg() {
		return repo_auto_gen_flg;
	}





	/**
	 * @param repo_auto_gen_flg the repo_auto_gen_flg to set
	 */
	public void setRepo_auto_gen_flg(String repo_auto_gen_flg) {
		this.repo_auto_gen_flg = repo_auto_gen_flg;
	}





	/**
	 * @return the sold_flg
	 */
	public String getSold_flg() {
		return sold_flg;
	}





	/**
	 * @param sold_flg the sold_flg to set
	 */
	public void setSold_flg(String sold_flg) {
		this.sold_flg = sold_flg;
	}





	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}





	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}





	/**
	 * @return the cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return cntrTpszCd;
	}





	/**
	 * @param cntrTpszCd the cntrTpszCd to set
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}





	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}





	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @return the scnrseq
	 */
	public String getScnrseq() {
		return scnrseq;
	}



	/**
	 * @param scnrseq the scnrseq to set
	 */
	public void setScnrseq(String scnrseq) {
		this.scnrseq = scnrseq;
	}



	/**
	 * @return the styear
	 */
	public String getStyear() {
		return styear;
	}



	/**
	 * @param styear the styear to set
	 */
	public void setStyear(String styear) {
		this.styear = styear;
	}



	/**
	 * @return the stmonth
	 */
	public String getStmonth() {
		return stmonth;
	}



	/**
	 * @param stmonth the stmonth to set
	 */
	public void setStmonth(String stmonth) {
		this.stmonth = stmonth;
	}



	/**
	 * @return the stweekly
	 */
	public String getStweekly() {
		return stweekly;
	}



	/**
	 * @param stweekly the stweekly to set
	 */
	public void setStweekly(String stweekly) {
		this.stweekly = stweekly;
	}



	/**
	 * @return the endyear
	 */
	public String getEndyear() {
		return endyear;
	}



	/**
	 * @param endyear the endyear to set
	 */
	public void setEndyear(String endyear) {
		this.endyear = endyear;
	}



	/**
	 * @return the endmonth
	 */
	public String getEndmonth() {
		return endmonth;
	}



	/**
	 * @param endmonth the endmonth to set
	 */
	public void setEndmonth(String endmonth) {
		this.endmonth = endmonth;
	}



	/**
	 * @return the endweekly
	 */
	public String getEndweekly() {
		return endweekly;
	}



	/**
	 * @param endweekly the endweekly to set
	 */
	public void setEndweekly(String endweekly) {
		this.endweekly = endweekly;
	}



	/**
	 * @return the scnrid
	 */
	public String getScnrid() {
		return scnrid;
	}



	/**
	 * @param scnrid the scnrid to set
	 */
	public void setScnrid(String scnrid) {
		this.scnrid = scnrid;
	}



	/**
	 * @return the repo_pln_rmk
	 */
	public String getRepo_pln_rmk() {
		return repo_pln_rmk;
	}



	/**
	 * @param repo_pln_rmk the repo_pln_rmk to set
	 */
	public void setRepo_pln_rmk(String repo_pln_rmk) {
		this.repo_pln_rmk = repo_pln_rmk;
	}



	/**
	 * @return the repo_plan_id
	 */
	public String getRepo_plan_id() {
		return repo_plan_id;
	}



	/**
	 * @param repo_plan_id the repo_plan_id to set
	 */
	public void setRepo_plan_id(String repo_plan_id) {
		this.repo_plan_id = repo_plan_id;
	}



	/**
	 * @return the sim_pln_id
	 */
	public String getSim_pln_id() {
		return sim_pln_id;
	}



	/**
	 * @param sim_pln_id the sim_pln_id to set
	 */
	public void setSim_pln_id(String sim_pln_id) {
		this.sim_pln_id = sim_pln_id;
	}



	/**
	 * @return the sensitivity_code
	 */
	public String getSensitivity_code() {
		return sensitivity_code;
	}



	/**
	 * @param sensitivity_code the sensitivity_code to set
	 */
	public void setSensitivity_code(String sensitivity_code) {
		this.sensitivity_code = sensitivity_code;
	}



	/**
	 * @return the object_code
	 */
	public String getObject_code() {
		return object_code;
	}



	/**
	 * @param object_code the object_code to set
	 */
	public void setObject_code(String object_code) {
		this.object_code = object_code;
	}



	/**
	 * @return the run_id_no
	 */
	public String getRun_id_no() {
		return run_id_no;
	}



	/**
	 * @param run_id_no the run_id_no to set
	 */
	public void setRun_id_no(String run_id_no) {
		this.run_id_no = run_id_no;
	}



	/**
	 * @return the repo_pln_dtrb_flg
	 */
	public String getRepo_pln_dtrb_flg() {
		return repo_pln_dtrb_flg;
	}



	/**
	 * @param repo_pln_dtrb_flg the repo_pln_dtrb_flg to set
	 */
	public void setRepo_pln_dtrb_flg(String repo_pln_dtrb_flg) {
		this.repo_pln_dtrb_flg = repo_pln_dtrb_flg;
	}



	/**
	 * @return the delt_flg
	 */
	public String getDelt_flg() {
		return delt_flg;
	}



	/**
	 * @param delt_flg the delt_flg to set
	 */
	public void setDelt_flg(String delt_flg) {
		this.delt_flg = delt_flg;
	}



	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}



	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}



	/**
	 * @return the old_scnr_id
	 */
	public String getOld_scnr_id() {
		return old_scnr_id;
	}



	/**
	 * @param old_scnr_id the old_scnr_id to set
	 */
	public void setOld_scnr_id(String old_scnr_id) {
		this.old_scnr_id = old_scnr_id;
	}



	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
