/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ProductCatalogInterfaceVO.java
 *@FileTitle : ProductCatalogInterfaceVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo;

import java.util.HashMap;

import com.clt.framework.component.common.AbstractValueObject;

public class PrdPriSetParamVO extends AbstractValueObject {

	private static final long serialVersionUID = -3163157169357968507L;

	private String cgoTpCd;

	private String eqTpCd;

	private String svcScpCd;

	private String socFlg;

	private String gohCd;

	private String cmdtCd;

	private String custCntCd;

	private String custSeq;

	private String ctrtTp;

	private String ctrtNo;

	private String pctlNo;

	private String creUsrId;

	private String updUsrId;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public String getCgoTpCd() {
		return cgoTpCd;
	}

	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}

	public String getEqTpCd() {
		return eqTpCd;
	}

	public void setEqTpCd(String eqTpCd) {
		this.eqTpCd = eqTpCd;
	}

	public String getSvcScpCd() {
		return svcScpCd;
	}

	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}

	public String getSocFlg() {
		return socFlg;
	}

	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}

	public String getGohCd() {
		return gohCd;
	}

	public void setGohCd(String gohCd) {
		this.gohCd = gohCd;
	}

	public String getCmdtCd() {
		return cmdtCd;
	}

	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	public String getCustCntCd() {
		return custCntCd;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	public String getCustSeq() {
		return custSeq;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	public String getCtrtTp() {
		return ctrtTp;
	}

	public void setCtrtTp(String ctrtTp) {
		this.ctrtTp = ctrtTp;
	}

	public String getCtrtNo() {
		return ctrtNo;
	}

	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}

	public String getPctlNo() {
		return pctlNo;
	}

	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}

	public String getCreUsrId() {
		return creUsrId;
	}

	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	public HashMap<String, String> getHashColumns() {
		return hashColumns;
	}

	public void setHashColumns(HashMap<String, String> hashColumns) {
		this.hashColumns = hashColumns;
	}

	public HashMap<String, String> getHashFields() {
		return hashFields;
	}

	public void setHashFields(HashMap<String, String> hashFields) {
		this.hashFields = hashFields;
	}

	@Override
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("eq_tp_cd", getEqTpCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("goh_cd", getGohCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ctrt_tp", getCtrtTp());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}

	@Override
	public HashMap<String, String> getFieldNames() {

		return this.hashFields;
	}
}
