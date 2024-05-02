/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortStlAmtVO.java
*@FileTitle : PortStlAmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.11.19 장창수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장창수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortStlAmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortStlAmtVO> models = new ArrayList<PortStlAmtVO>();
	
	/* Column Info */
	private String vslDzndCapa = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String stlYrmon = null;
	/* Column Info */
	private String eStlYrmon = null;
	/* Column Info */
	private String totalVoyDys = null;
	/* Column Info */
	private String bsaCapaModiFlg = null;
	/* Column Info */
	private String dysDiff = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lastRowYn = null;
	/* Column Info */
	private String totalTaxAmt = null;
	/* Column Info */
	private String ldbCapaQty = null;
	/* Column Info */
	private String capaDiff = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String oldVoyDys = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String tongStlBatJbSeq = null;
	/* Column Info */
	private String usgRt = null;
	/* Column Info */
	private String toVvdStlDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String actBsaCapa = null;
	/* Column Info */
	private String bsaCapa = null;
	/* Column Info */
	private String tongFletTpCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String voyDys = null;
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String chtrBsaCapa = null;
	/* Column Info */
	private String perTonRev = null;
	/* Column Info */
	private String tongTaxAmt = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* Column Info */
	private String sExpTurn = null;
	/* Column Info */
	private String sExpPort = null;
	/* Column Info */
	private String vslSvcTpNm = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortStlAmtVO() {}

	public PortStlAmtVO(String ibflag, String pagerows, String vslDzndCapa, String vslCd, String stlYrmon, String totalVoyDys, String bsaCapaModiFlg, String dysDiff, String creDt, String trdCd, String lastRowYn, String totalTaxAmt, String ldbCapaQty, String capaDiff, String portCd, String updUsrId, String oldVoyDys, String updDt, String tongStlBatJbSeq, String usgRt, String toVvdStlDt, String skdVoyNo, String etdDt, String skdDirCd, String actBsaCapa, String vvd, String tongFletTpCd, String bsaCapa, String portSeq, String voyDys, String creUsrId, String slanCd, String chtrBsaCapa, String tongTaxAmt, String perTonRev, String eStlYrmon, String turnPortIndCd, String sExpPort, String sExpTurn, String vslSvcTpNm) {
		this.vslDzndCapa = vslDzndCapa;
		this.vslCd = vslCd;
		this.stlYrmon = stlYrmon;
		this.eStlYrmon = eStlYrmon;
		this.totalVoyDys = totalVoyDys;
		this.bsaCapaModiFlg = bsaCapaModiFlg;
		this.dysDiff = dysDiff;
		this.creDt = creDt;
		this.trdCd = trdCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.lastRowYn = lastRowYn;
		this.totalTaxAmt = totalTaxAmt;
		this.ldbCapaQty = ldbCapaQty;
		this.capaDiff = capaDiff;
		this.portCd = portCd;
		this.updUsrId = updUsrId;
		this.oldVoyDys = oldVoyDys;
		this.updDt = updDt;
		this.tongStlBatJbSeq = tongStlBatJbSeq;
		this.usgRt = usgRt;
		this.toVvdStlDt = toVvdStlDt;
		this.skdVoyNo = skdVoyNo;
		this.etdDt = etdDt;
		this.skdDirCd = skdDirCd;
		this.actBsaCapa = actBsaCapa;
		this.bsaCapa = bsaCapa;
		this.tongFletTpCd = tongFletTpCd;
		this.vvd = vvd;
		this.voyDys = voyDys;
		this.portSeq = portSeq;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.chtrBsaCapa = chtrBsaCapa;
		this.perTonRev = perTonRev;
		this.tongTaxAmt = tongTaxAmt;
		this.turnPortIndCd = turnPortIndCd;
		this.sExpPort = sExpPort;
		this.sExpTurn = sExpTurn;
		this.vslSvcTpNm = vslSvcTpNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_dznd_capa", getVslDzndCapa());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("stl_yrmon", getStlYrmon());
		this.hashColumns.put("e_stl_yrmon", getEStlYrmon());
		this.hashColumns.put("total_voy_dys", getTotalVoyDys());
		this.hashColumns.put("bsa_capa_modi_flg", getBsaCapaModiFlg());
		this.hashColumns.put("dys_diff", getDysDiff());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("last_row_yn", getLastRowYn());
		this.hashColumns.put("total_tax_amt", getTotalTaxAmt());
		this.hashColumns.put("ldb_capa_qty", getLdbCapaQty());
		this.hashColumns.put("capa_diff", getCapaDiff());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("old_voy_dys", getOldVoyDys());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tong_stl_bat_jb_seq", getTongStlBatJbSeq());
		this.hashColumns.put("usg_rt", getUsgRt());
		this.hashColumns.put("to_vvd_stl_dt", getToVvdStlDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("act_bsa_capa", getActBsaCapa());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("tong_flet_tp_cd", getTongFletTpCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("voy_dys", getVoyDys());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("chtr_bsa_capa", getChtrBsaCapa());
		this.hashColumns.put("per_ton_rev", getPerTonRev());
		this.hashColumns.put("tong_tax_amt", getTongTaxAmt());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("s_exp_port", getSExpPort());
		this.hashColumns.put("s_exp_turn", getSExpTurn());
		this.hashColumns.put("vsl_svc_tp_nm", getVslSvcTpNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_dznd_capa", "vslDzndCapa");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("stl_yrmon", "stlYrmon");
		this.hashFields.put("e_stl_yrmon", "eStlYrmon");
		this.hashFields.put("total_voy_dys", "totalVoyDys");
		this.hashFields.put("bsa_capa_modi_flg", "bsaCapaModiFlg");
		this.hashFields.put("dys_diff", "dysDiff");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("last_row_yn", "lastRowYn");
		this.hashFields.put("total_tax_amt", "totalTaxAmt");
		this.hashFields.put("ldb_capa_qty", "ldbCapaQty");
		this.hashFields.put("capa_diff", "capaDiff");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("old_voy_dys", "oldVoyDys");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tong_stl_bat_jb_seq", "tongStlBatJbSeq");
		this.hashFields.put("usg_rt", "usgRt");
		this.hashFields.put("to_vvd_stl_dt", "toVvdStlDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("act_bsa_capa", "actBsaCapa");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("tong_flet_tp_cd", "tongFletTpCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("voy_dys", "voyDys");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("chtr_bsa_capa", "chtrBsaCapa");
		this.hashFields.put("per_ton_rev", "perTonRev");
		this.hashFields.put("tong_tax_amt", "tongTaxAmt");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("s_exp_port", "sExpPort");
		this.hashFields.put("s_exp_turn", "sExpTurn");
		this.hashFields.put("vsl_svc_tp_nm", "vslSvcTpNm");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslDzndCapa
	 */
	public String getVslDzndCapa() {
		return this.vslDzndCapa;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return stlYrmon
	 */
	public String getStlYrmon() {
		return this.stlYrmon;
	}
	
	/**
	 * Column Info
	 * @return eStlYrmon
	 */
	public String getEStlYrmon() {
		return this.eStlYrmon;
	}
	
	/**
	 * Column Info
	 * @return totalVoyDys
	 */
	public String getTotalVoyDys() {
		return this.totalVoyDys;
	}
	
	/**
	 * Column Info
	 * @return bsaCapaModiFlg
	 */
	public String getBsaCapaModiFlg() {
		return this.bsaCapaModiFlg;
	}
	
	/**
	 * Column Info
	 * @return dysDiff
	 */
	public String getDysDiff() {
		return this.dysDiff;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return lastRowYn
	 */
	public String getLastRowYn() {
		return this.lastRowYn;
	}
	
	/**
	 * Column Info
	 * @return totalTaxAmt
	 */
	public String getTotalTaxAmt() {
		return this.totalTaxAmt;
	}
	
	/**
	 * Column Info
	 * @return ldbCapaQty
	 */
	public String getLdbCapaQty() {
		return this.ldbCapaQty;
	}
	
	/**
	 * Column Info
	 * @return capaDiff
	 */
	public String getCapaDiff() {
		return this.capaDiff;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return oldVoyDys
	 */
	public String getOldVoyDys() {
		return this.oldVoyDys;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return tongStlBatJbSeq
	 */
	public String getTongStlBatJbSeq() {
		return this.tongStlBatJbSeq;
	}
	
	/**
	 * Column Info
	 * @return usgRt
	 */
	public String getUsgRt() {
		return this.usgRt;
	}
	
	/**
	 * Column Info
	 * @return toVvdStlDt
	 */
	public String getToVvdStlDt() {
		return this.toVvdStlDt;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return actBsaCapa
	 */
	public String getActBsaCapa() {
		return this.actBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return bsaCapa
	 */
	public String getBsaCapa() {
		return this.bsaCapa;
	}
	
	/**
	 * Column Info
	 * @return tongFletTpCd
	 */
	public String getTongFletTpCd() {
		return this.tongFletTpCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return voyDys
	 */
	public String getVoyDys() {
		return this.voyDys;
	}
	
	/**
	 * Column Info
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return chtrBsaCapa
	 */
	public String getChtrBsaCapa() {
		return this.chtrBsaCapa;
	}
	
	/**
	 * Column Info
	 * @return perTonRev
	 */
	public String getPerTonRev() {
		return this.perTonRev;
	}
	
	/**
	 * Column Info
	 * @return tongTaxAmt
	 */
	public String getTongTaxAmt() {
		return this.tongTaxAmt;
	}

	/**
	 * Column Info
	 * @return turnPortIndCd
	 */
	public String getTurnPortIndCd() {
		return this.turnPortIndCd;
	}

	/**
	 * Column Info
	 * @return sExpPort
	 */
	public String getSExpPort() {
		return this.sExpPort;
	}

	/**
	 * Column Info
	 * @return sExpTurn
	 */
	public String getSExpTurn() {
		return this.sExpTurn;
	}
	
	/**
	 * Column Info
	 * @return vslSvcTpNm
	 */
	public String getVslSvcTpNm() {
		return this.vslSvcTpNm;
	}
	
	/**
	 * Column Info
	 * @param vslDzndCapa
	 */
	public void setVslDzndCapa(String vslDzndCapa) {
		this.vslDzndCapa = vslDzndCapa;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param stlYrmon
	 */
	public void setStlYrmon(String stlYrmon) {
		this.stlYrmon = stlYrmon;
	}
	
	/**
	 * Column Info
	 * @param eStlYrmon
	 */
	public void setEStlYrmon(String eStlYrmon) {
		this.eStlYrmon = eStlYrmon;
	}
	
	/**
	 * Column Info
	 * @param totalVoyDys
	 */
	public void setTotalVoyDys(String totalVoyDys) {
		this.totalVoyDys = totalVoyDys;
	}
	
	/**
	 * Column Info
	 * @param bsaCapaModiFlg
	 */
	public void setBsaCapaModiFlg(String bsaCapaModiFlg) {
		this.bsaCapaModiFlg = bsaCapaModiFlg;
	}
	
	/**
	 * Column Info
	 * @param dysDiff
	 */
	public void setDysDiff(String dysDiff) {
		this.dysDiff = dysDiff;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param lastRowYn
	 */
	public void setLastRowYn(String lastRowYn) {
		this.lastRowYn = lastRowYn;
	}
	
	/**
	 * Column Info
	 * @param totalTaxAmt
	 */
	public void setTotalTaxAmt(String totalTaxAmt) {
		this.totalTaxAmt = totalTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param ldbCapaQty
	 */
	public void setLdbCapaQty(String ldbCapaQty) {
		this.ldbCapaQty = ldbCapaQty;
	}
	
	/**
	 * Column Info
	 * @param capaDiff
	 */
	public void setCapaDiff(String capaDiff) {
		this.capaDiff = capaDiff;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param oldVoyDys
	 */
	public void setOldVoyDys(String oldVoyDys) {
		this.oldVoyDys = oldVoyDys;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param tongStlBatJbSeq
	 */
	public void setTongStlBatJbSeq(String tongStlBatJbSeq) {
		this.tongStlBatJbSeq = tongStlBatJbSeq;
	}
	
	/**
	 * Column Info
	 * @param usgRt
	 */
	public void setUsgRt(String usgRt) {
		this.usgRt = usgRt;
	}
	
	/**
	 * Column Info
	 * @param toVvdStlDt
	 */
	public void setToVvdStlDt(String toVvdStlDt) {
		this.toVvdStlDt = toVvdStlDt;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param actBsaCapa
	 */
	public void setActBsaCapa(String actBsaCapa) {
		this.actBsaCapa = actBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param bsaCapa
	 */
	public void setBsaCapa(String bsaCapa) {
		this.bsaCapa = bsaCapa;
	}
	
	/**
	 * Column Info
	 * @param tongFletTpCd
	 */
	public void setTongFletTpCd(String tongFletTpCd) {
		this.tongFletTpCd = tongFletTpCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param voyDys
	 */
	public void setVoyDys(String voyDys) {
		this.voyDys = voyDys;
	}
	
	/**
	 * Column Info
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param chtrBsaCapa
	 */
	public void setChtrBsaCapa(String chtrBsaCapa) {
		this.chtrBsaCapa = chtrBsaCapa;
	}
	
	/**
	 * Column Info
	 * @param perTonRev
	 */
	public void setPerTonRev(String perTonRev) {
		this.perTonRev = perTonRev;
	}
	
	/**
	 * Column Info
	 * @param tongTaxAmt
	 */
	public void setTongTaxAmt(String tongTaxAmt) {
		this.tongTaxAmt = tongTaxAmt;
	}
	
	/**
	 * Column Info
	 * @param turnPortIndCd
	 */
	public void setTurnPortIndCd(String turnPortIndCd) {
		this.turnPortIndCd = turnPortIndCd;
	}
	
	/**
	 * Column Info
	 * @param sExpPort
	 */
	public void setSExpPort(String sExpPort) {
		this.sExpPort = sExpPort;
	}
	
	/**
	 * Column Info
	 * @param sExpTurn
	 */
	public void setSExpTurn(String sExpTurn) {
		this.sExpTurn = sExpTurn;
	}	
	
	/**
	 * Column Info
	 * @param vslSvcTpNm
	 */
	public void setVslSvcTpNm(String vslSvcTpNm) {
		this.vslSvcTpNm = vslSvcTpNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	
	public void fromRequest(HttpServletRequest request) {
		setVslDzndCapa(JSPUtil.getParameter(request, "vsl_dznd_capa", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setStlYrmon(JSPUtil.getParameter(request, "stl_yrmon", ""));
		setEStlYrmon(JSPUtil.getParameter(request, "e_stl_yrmon", ""));
		setTotalVoyDys(JSPUtil.getParameter(request, "total_voy_dys", ""));
		setBsaCapaModiFlg(JSPUtil.getParameter(request, "bsa_capa_modi_flg", ""));
		setDysDiff(JSPUtil.getParameter(request, "dys_diff", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLastRowYn(JSPUtil.getParameter(request, "last_row_yn", ""));
		setTotalTaxAmt(JSPUtil.getParameter(request, "total_tax_amt", ""));
		setLdbCapaQty(JSPUtil.getParameter(request, "ldb_capa_qty", ""));
		setCapaDiff(JSPUtil.getParameter(request, "capa_diff", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setOldVoyDys(JSPUtil.getParameter(request, "old_voy_dys", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setTongStlBatJbSeq(JSPUtil.getParameter(request, "tong_stl_bat_jb_seq", ""));
		setUsgRt(JSPUtil.getParameter(request, "usg_rt", ""));
		setToVvdStlDt(JSPUtil.getParameter(request, "to_vvd_stl_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setActBsaCapa(JSPUtil.getParameter(request, "act_bsa_capa", ""));
		setBsaCapa(JSPUtil.getParameter(request, "bsa_capa", ""));
		setTongFletTpCd(JSPUtil.getParameter(request, "tong_flet_tp_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setVoyDys(JSPUtil.getParameter(request, "voy_dys", ""));
		setPortSeq(JSPUtil.getParameter(request, "port_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setChtrBsaCapa(JSPUtil.getParameter(request, "chtr_bsa_capa", ""));
		setPerTonRev(JSPUtil.getParameter(request, "per_ton_rev", ""));
		setTongTaxAmt(JSPUtil.getParameter(request, "tong_tax_amt", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, "turn_port_ind_cd", ""));
		setSExpPort(JSPUtil.getParameter(request, "s_exp_port", ""));
		setSExpTurn(JSPUtil.getParameter(request, "s_exp_turn", ""));	
		setVslSvcTpNm(JSPUtil.getParameter(request, "vsl_svc_tp_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortStlAmtVO[]
	 */
	public PortStlAmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortStlAmtVO[]
	 */
	public PortStlAmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortStlAmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslDzndCapa = (JSPUtil.getParameter(request, prefix	+ "vsl_dznd_capa", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] stlYrmon = (JSPUtil.getParameter(request, prefix	+ "stl_yrmon", length));
			String[] eStlYrmon = (JSPUtil.getParameter(request, prefix	+ "e_stl_yrmon", length));
			String[] totalVoyDys = (JSPUtil.getParameter(request, prefix	+ "total_voy_dys", length));
			String[] bsaCapaModiFlg = (JSPUtil.getParameter(request, prefix	+ "bsa_capa_modi_flg", length));
			String[] dysDiff = (JSPUtil.getParameter(request, prefix	+ "dys_diff", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lastRowYn = (JSPUtil.getParameter(request, prefix	+ "last_row_yn", length));
			String[] totalTaxAmt = (JSPUtil.getParameter(request, prefix	+ "total_tax_amt", length));
			String[] ldbCapaQty = (JSPUtil.getParameter(request, prefix	+ "ldb_capa_qty", length));
			String[] capaDiff = (JSPUtil.getParameter(request, prefix	+ "capa_diff", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] oldVoyDys = (JSPUtil.getParameter(request, prefix	+ "old_voy_dys", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] tongStlBatJbSeq = (JSPUtil.getParameter(request, prefix	+ "tong_stl_bat_jb_seq", length));
			String[] usgRt = (JSPUtil.getParameter(request, prefix	+ "usg_rt", length));
			String[] toVvdStlDt = (JSPUtil.getParameter(request, prefix	+ "to_vvd_stl_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] actBsaCapa = (JSPUtil.getParameter(request, prefix	+ "act_bsa_capa", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] tongFletTpCd = (JSPUtil.getParameter(request, prefix	+ "tong_flet_tp_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] voyDys = (JSPUtil.getParameter(request, prefix	+ "voy_dys", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] chtrBsaCapa = (JSPUtil.getParameter(request, prefix	+ "chtr_bsa_capa", length));
			String[] perTonRev = (JSPUtil.getParameter(request, prefix	+ "per_ton_rev", length));
			String[] tongTaxAmt = (JSPUtil.getParameter(request, prefix	+ "tong_tax_amt", length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd", length));
			String[] sExpPort = (JSPUtil.getParameter(request, prefix	+ "s_exp_port", length));
			String[] sExpTurn = (JSPUtil.getParameter(request, prefix	+ "s_exp_trun", length));
			String[] vslSvcTpNm = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_tp_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortStlAmtVO();
				if (vslDzndCapa[i] != null)
					model.setVslDzndCapa(vslDzndCapa[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (stlYrmon[i] != null)
					model.setStlYrmon(stlYrmon[i]);
				if (eStlYrmon[i] != null)
					model.setEStlYrmon(eStlYrmon[i]);
				if (totalVoyDys[i] != null)
					model.setTotalVoyDys(totalVoyDys[i]);
				if (bsaCapaModiFlg[i] != null)
					model.setBsaCapaModiFlg(bsaCapaModiFlg[i]);
				if (dysDiff[i] != null)
					model.setDysDiff(dysDiff[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lastRowYn[i] != null)
					model.setLastRowYn(lastRowYn[i]);
				if (totalTaxAmt[i] != null)
					model.setTotalTaxAmt(totalTaxAmt[i]);
				if (ldbCapaQty[i] != null)
					model.setLdbCapaQty(ldbCapaQty[i]);
				if (capaDiff[i] != null)
					model.setCapaDiff(capaDiff[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (oldVoyDys[i] != null)
					model.setOldVoyDys(oldVoyDys[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (tongStlBatJbSeq[i] != null)
					model.setTongStlBatJbSeq(tongStlBatJbSeq[i]);
				if (usgRt[i] != null)
					model.setUsgRt(usgRt[i]);
				if (toVvdStlDt[i] != null)
					model.setToVvdStlDt(toVvdStlDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (actBsaCapa[i] != null)
					model.setActBsaCapa(actBsaCapa[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (tongFletTpCd[i] != null)
					model.setTongFletTpCd(tongFletTpCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (voyDys[i] != null)
					model.setVoyDys(voyDys[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (chtrBsaCapa[i] != null)
					model.setChtrBsaCapa(chtrBsaCapa[i]);
				if (perTonRev[i] != null)
					model.setPerTonRev(perTonRev[i]);
				if (tongTaxAmt[i] != null)
					model.setTongTaxAmt(tongTaxAmt[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);	
				if (sExpPort[i] != null)
					model.setSExpPort(sExpPort[i]);
				if (sExpTurn[i] != null)
					model.setSExpTurn(sExpTurn[i]);	
				if (vslSvcTpNm[i] != null)
					model.setVslSvcTpNm(vslSvcTpNm[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortStlAmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortStlAmtVO[]
	 */
	public PortStlAmtVO[] getPortStlAmtVOs(){
		PortStlAmtVO[] vos = (PortStlAmtVO[])models.toArray(new PortStlAmtVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.vslDzndCapa = this.vslDzndCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlYrmon = this.stlYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eStlYrmon = this.eStlYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalVoyDys = this.totalVoyDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapaModiFlg = this.bsaCapaModiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dysDiff = this.dysDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastRowYn = this.lastRowYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalTaxAmt = this.totalTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldbCapaQty = this.ldbCapaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capaDiff = this.capaDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldVoyDys = this.oldVoyDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tongStlBatJbSeq = this.tongStlBatJbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usgRt = this.usgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toVvdStlDt = this.toVvdStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBsaCapa = this.actBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tongFletTpCd = this.tongFletTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyDys = this.voyDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtrBsaCapa = this.chtrBsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTonRev = this.perTonRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tongTaxAmt = this.tongTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sExpPort = this.sExpPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sExpTurn = this.sExpTurn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSvcTpNm = this.vslSvcTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
