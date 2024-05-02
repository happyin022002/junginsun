package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo;

import java.util.HashMap;

import com.clt.framework.component.common.AbstractValueObject;

public class TrsChgMgmtBkgVO extends AbstractValueObject {
	private static final long serialVersionUID = -7538186595102665651L;

	private String cateSepCd;
	private String chageFlg;
	private String bkNo;
	private String bndCd;
	private String rtnPrdFlg;
	private String troSeq;
	private String troSubSeq;
	private String spclSeq;
	private String vslSeq;
	private String deltFlg;
	private String usrId;
	private String usrOffCd;

	public String getCateSepCd() {
		return cateSepCd;
	}

	public void setCateSepCd(String cateSepCd) {
		this.cateSepCd = cateSepCd;
	}

	public String getChageFlg() {
		return chageFlg;
	}

	public void setChageFlg(String chageFlg) {
		this.chageFlg = chageFlg;
	}

	public String getBkNo() {
		return bkNo;
	}

	public void setBkNo(String bkNo) {
		this.bkNo = bkNo;
	}

	public String getBndCd() {
		return bndCd;
	}

	public void setBndCd(String bndCd) {
		this.bndCd = bndCd;
	}

	public String getRtnPrdFlg() {
		return rtnPrdFlg;
	}

	public void setRtnPrdFlg(String rtnPrdFlg) {
		this.rtnPrdFlg = rtnPrdFlg;
	}

	public String getTroSeq() {
		return troSeq;
	}

	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}

	public String getTroSubSeq() {
		return troSubSeq;
	}

	public void setTroSubSeq(String troSubSeq) {
		this.troSubSeq = troSubSeq;
	}

	public String getSpclSeq() {
		return spclSeq;
	}

	public void setSpclSeq(String spclSeq) {
		this.spclSeq = spclSeq;
	}

	public String getVslSeq() {
		return vslSeq;
	}

	public void setVslSeq(String vslSeq) {
		this.vslSeq = vslSeq;
	}

	public String getDeltFlg() {
		return deltFlg;
	}

	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getUsrOffCd() {
		return usrOffCd;
	}

	public void setUsrOffCd(String usrOffCd) {
		this.usrOffCd = usrOffCd;
	}

	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	@Override
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("in_cate_sep_cd", this.getCateSepCd());
		this.hashColumns.put("in_chage_flg", this.getChageFlg());
		this.hashColumns.put("in_bkg_no", this.getBkNo());
		this.hashColumns.put("in_bnd_cd", this.getBndCd());
		this.hashColumns.put("in_rtn_pre_flg", this.getRtnPrdFlg());
		this.hashColumns.put("in_tro_seq", this.getTroSeq());
		this.hashColumns.put("in_tro_sub_seq", this.getTroSubSeq());
		this.hashColumns.put("in_spcl_seq", this.getSpclSeq());
		this.hashColumns.put("in_vsl_seq", this.getVslSeq());
		this.hashColumns.put("in_delt_flg", this.getDeltFlg());
		this.hashColumns.put("in_usr_id", this.getUsrId());
		this.hashColumns.put("in_usr_off_cd", this.getUsrOffCd());
		return this.hashColumns;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		return null;
	}

}
