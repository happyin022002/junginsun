/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0052ConditionVO.java
*@FileTitle : EesEqr0052ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.08.21		1.0 최초 생성
*
*@LastModifyDate : 2009.08.21
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0052ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0052ConditionVO> models = new ArrayList<EesEqr0052ConditionVO>();
	
	/* Column Info */
	private String item2 = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String col = null;
	/* Column Info */
	private String cntrtpszcd2 = null;
	/* Column Info */
	private String statusType = null;
	/* Column Info */
	private String fmtypeby2 = null;
	/* Column Info */
	private String atfmplnyr2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslLaneCd = null;
	/* Column Info */
	private String repoRmk = null;
	/* Column Info */
	private String totypeby2 = null;
	/* Column Info */
	private String totoplnyr2 = null;
	/* Column Info */
	private String attypeby2 = null;
	/* Column Info */
	private String toecccd2 = null;
	/* Column Info */
	private String attype2 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vvd2 = null;
	/* Column Info */
	private String fmtoplnwk2 = null;
	/* Column Info */
	private String row = null;
	/* Column Info */
	private String atecccd2 = null;
	/* Column Info */
	private String atfmplnwk2 = null;
	/* Column Info */
	private String attoplnyr2 = null;
	/* Column Info */
	private String atfmplnyrwk2 = null;
	/* Column Info */
	private String fmfmplnyrwk2 = null;
	/* Column Info */
	private String fmecccd2 = null;
	/* Column Info */
	private String vvdYrwk = null;
	/* Column Info */
	private String totoplnyrwk2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmfmplnwk2 = null;
	/* Column Info */
	private String attoplnyrwk2 = null;
	/* Column Info */
	private String fmtype2 = null;
	/* Column Info */
	private String repoId = null;
	/* Column Info */
	private String tofmplnyr2 = null;
	/* Column Info */
	private String totoplnwk2 = null;
	/* Column Info */
	private String fmtoplnyr2 = null;
	/* Column Info */
	private String poscol = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String fmtoplnyrwk2 = null;
	/* Column Info */
	private String tofmplnwk2 = null;
	/* Column Info */
	private String fmtoat2 = null;
	/* Column Info */
	private String attoplnwk2 = null;
	/* Column Info */
	private String lane2 = null;
	/* Column Info */
	private String tpszall = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String tofmplnyrwk2 = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String fmfmplnyr2 = null;
	/* Column Info */
	private String totype2 = null;
	/* Column Info */
	private String seq = null;
	/* 추가변수 */
	private String searchFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0052ConditionVO() {}

	public EesEqr0052ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String statusType, String scnrId, String repoRmk, String repoPlnId, String tpszall, String repoId, String vslCd, String skdVoyNo, String skdDirCd, String vslLaneCd, String row, String col, String vvdYrwk, String fmtoat2, String fmfmplnyrwk2, String fmtoplnyrwk2, String tofmplnyrwk2, String totoplnyrwk2, String atfmplnyrwk2, String attoplnyrwk2, String poscol, String fmtype2, String fmecccd2, String fmtypeby2, String fmfmplnyr2, String fmfmplnwk2, String fmtoplnyr2, String fmtoplnwk2, String totype2, String toecccd2, String totypeby2, String tofmplnyr2, String tofmplnwk2, String totoplnyr2, String totoplnwk2, String attype2, String atecccd2, String attypeby2, String atfmplnyr2, String atfmplnwk2, String attoplnyr2, String attoplnwk2, String cntrtpszcd2, String item2, String lane2, String vvd2) {
		this.item2 = item2;
		this.vslCd = vslCd;
		this.col = col;
		this.cntrtpszcd2 = cntrtpszcd2;
		this.statusType = statusType;
		this.fmtypeby2 = fmtypeby2;
		this.atfmplnyr2 = atfmplnyr2;
		this.pagerows = pagerows;
		this.vslLaneCd = vslLaneCd;
		this.repoRmk = repoRmk;
		this.totypeby2 = totypeby2;
		this.totoplnyr2 = totoplnyr2;
		this.attypeby2 = attypeby2;
		this.toecccd2 = toecccd2;
		this.attype2 = attype2;
		this.skdVoyNo = skdVoyNo;
		this.vvd2 = vvd2;
		this.fmtoplnwk2 = fmtoplnwk2;
		this.row = row;
		this.atecccd2 = atecccd2;
		this.atfmplnwk2 = atfmplnwk2;
		this.attoplnyr2 = attoplnyr2;
		this.atfmplnyrwk2 = atfmplnyrwk2;
		this.fmfmplnyrwk2 = fmfmplnyrwk2;
		this.fmecccd2 = fmecccd2;
		this.vvdYrwk = vvdYrwk;
		this.totoplnyrwk2 = totoplnyrwk2;
		this.ibflag = ibflag;
		this.fmfmplnwk2 = fmfmplnwk2;
		this.attoplnyrwk2 = attoplnyrwk2;
		this.fmtype2 = fmtype2;
		this.repoId = repoId;
		this.tofmplnyr2 = tofmplnyr2;
		this.totoplnwk2 = totoplnwk2;
		this.fmtoplnyr2 = fmtoplnyr2;
		this.poscol = poscol;
		this.scnrId = scnrId;
		this.fmtoplnyrwk2 = fmtoplnyrwk2;
		this.tofmplnwk2 = tofmplnwk2;
		this.fmtoat2 = fmtoat2;
		this.attoplnwk2 = attoplnwk2;
		this.lane2 = lane2;
		this.tpszall = tpszall;
		this.skdDirCd = skdDirCd;
		this.tofmplnyrwk2 = tofmplnyrwk2;
		this.yyyyww = yyyyww;
		this.repoPlnId = repoPlnId;
		this.fmfmplnyr2 = fmfmplnyr2;
		this.totype2 = totype2;
		this.seq = seq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("item_2", getItem2());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("col", getCol());
		this.hashColumns.put("cntrtpszcd_2", getCntrtpszcd2());
		this.hashColumns.put("status_type", getStatusType());
		this.hashColumns.put("fmtypeby_2", getFmtypeby2());
		this.hashColumns.put("atfmplnyr_2", getAtfmplnyr2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());
		this.hashColumns.put("repo_rmk", getRepoRmk());
		this.hashColumns.put("totypeby_2", getTotypeby2());
		this.hashColumns.put("totoplnyr_2", getTotoplnyr2());
		this.hashColumns.put("attypeby_2", getAttypeby2());
		this.hashColumns.put("toecccd_2", getToecccd2());
		this.hashColumns.put("attype_2", getAttype2());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vvd_2", getVvd2());
		this.hashColumns.put("fmtoplnwk_2", getFmtoplnwk2());
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("atecccd_2", getAtecccd2());
		this.hashColumns.put("atfmplnwk_2", getAtfmplnwk2());
		this.hashColumns.put("attoplnyr_2", getAttoplnyr2());
		this.hashColumns.put("atfmplnyrwk_2", getAtfmplnyrwk2());
		this.hashColumns.put("fmfmplnyrwk_2", getFmfmplnyrwk2());
		this.hashColumns.put("fmecccd_2", getFmecccd2());
		this.hashColumns.put("vvd_yrwk", getVvdYrwk());
		this.hashColumns.put("totoplnyrwk_2", getTotoplnyrwk2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fmfmplnwk_2", getFmfmplnwk2());
		this.hashColumns.put("attoplnyrwk_2", getAttoplnyrwk2());
		this.hashColumns.put("fmtype_2", getFmtype2());
		this.hashColumns.put("repo_id", getRepoId());
		this.hashColumns.put("tofmplnyr_2", getTofmplnyr2());
		this.hashColumns.put("totoplnwk_2", getTotoplnwk2());
		this.hashColumns.put("fmtoplnyr_2", getFmtoplnyr2());
		this.hashColumns.put("poscol", getPoscol());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("fmtoplnyrwk_2", getFmtoplnyrwk2());
		this.hashColumns.put("tofmplnwk_2", getTofmplnwk2());
		this.hashColumns.put("fmtoat2", getFmtoat2());
		this.hashColumns.put("attoplnwk_2", getAttoplnwk2());
		this.hashColumns.put("lane_2", getLane2());
		this.hashColumns.put("tpszall", getTpszall());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("tofmplnyrwk_2", getTofmplnyrwk2());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("fmfmplnyr_2", getFmfmplnyr2());
		this.hashColumns.put("totype_2", getTotype2());
		this.hashColumns.put("seq", getSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("item_2", "item2");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("col", "col");
		this.hashFields.put("cntrtpszcd_2", "cntrtpszcd2");
		this.hashFields.put("status_type", "statusType");
		this.hashFields.put("fmtypeby_2", "fmtypeby2");
		this.hashFields.put("atfmplnyr_2", "atfmplnyr2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("repo_rmk", "repoRmk");
		this.hashFields.put("totypeby_2", "totypeby2");
		this.hashFields.put("totoplnyr_2", "totoplnyr2");
		this.hashFields.put("attypeby_2", "attypeby2");
		this.hashFields.put("toecccd_2", "toecccd2");
		this.hashFields.put("attype_2", "attype2");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vvd_2", "vvd2");
		this.hashFields.put("fmtoplnwk_2", "fmtoplnwk2");
		this.hashFields.put("row", "row");
		this.hashFields.put("atecccd_2", "atecccd2");
		this.hashFields.put("atfmplnwk_2", "atfmplnwk2");
		this.hashFields.put("attoplnyr_2", "attoplnyr2");
		this.hashFields.put("atfmplnyrwk_2", "atfmplnyrwk2");
		this.hashFields.put("fmfmplnyrwk_2", "fmfmplnyrwk2");
		this.hashFields.put("fmecccd_2", "fmecccd2");
		this.hashFields.put("vvd_yrwk", "vvdYrwk");
		this.hashFields.put("totoplnyrwk_2", "totoplnyrwk2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fmfmplnwk_2", "fmfmplnwk2");
		this.hashFields.put("attoplnyrwk_2", "attoplnyrwk2");
		this.hashFields.put("fmtype_2", "fmtype2");
		this.hashFields.put("repo_id", "repoId");
		this.hashFields.put("tofmplnyr_2", "tofmplnyr2");
		this.hashFields.put("totoplnwk_2", "totoplnwk2");
		this.hashFields.put("fmtoplnyr_2", "fmtoplnyr2");
		this.hashFields.put("poscol", "poscol");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("fmtoplnyrwk_2", "fmtoplnyrwk2");
		this.hashFields.put("tofmplnwk_2", "tofmplnwk2");
		this.hashFields.put("fmtoat2", "fmtoat2");
		this.hashFields.put("attoplnwk_2", "attoplnwk2");
		this.hashFields.put("lane_2", "lane2");
		this.hashFields.put("tpszall", "tpszall");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("tofmplnyrwk_2", "tofmplnyrwk2");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("fmfmplnyr_2", "fmfmplnyr2");
		this.hashFields.put("totype_2", "totype2");
		this.hashFields.put("seq", "seq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return item2
	 */
	public String getItem2() {
		return this.item2;
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
	 * @return col
	 */
	public String getCol() {
		return this.col;
	}
	
	/**
	 * Column Info
	 * @return cntrtpszcd2
	 */
	public String getCntrtpszcd2() {
		return this.cntrtpszcd2;
	}
	
	/**
	 * Column Info
	 * @return statusType
	 */
	public String getStatusType() {
		return this.statusType;
	}
	
	/**
	 * Column Info
	 * @return fmtypeby2
	 */
	public String getFmtypeby2() {
		return this.fmtypeby2;
	}
	
	/**
	 * Column Info
	 * @return atfmplnyr2
	 */
	public String getAtfmplnyr2() {
		return this.atfmplnyr2;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return vslLaneCd
	 */
	public String getVslLaneCd() {
		return this.vslLaneCd;
	}
	
	/**
	 * Column Info
	 * @return repoRmk
	 */
	public String getRepoRmk() {
		return this.repoRmk;
	}
	
	/**
	 * Column Info
	 * @return totypeby2
	 */
	public String getTotypeby2() {
		return this.totypeby2;
	}
	
	/**
	 * Column Info
	 * @return totoplnyr2
	 */
	public String getTotoplnyr2() {
		return this.totoplnyr2;
	}
	
	/**
	 * Column Info
	 * @return attypeby2
	 */
	public String getAttypeby2() {
		return this.attypeby2;
	}
	
	/**
	 * Column Info
	 * @return toecccd2
	 */
	public String getToecccd2() {
		return this.toecccd2;
	}
	
	/**
	 * Column Info
	 * @return attype2
	 */
	public String getAttype2() {
		return this.attype2;
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
	 * @return vvd2
	 */
	public String getVvd2() {
		return this.vvd2;
	}
	
	/**
	 * Column Info
	 * @return fmtoplnwk2
	 */
	public String getFmtoplnwk2() {
		return this.fmtoplnwk2;
	}
	
	/**
	 * Column Info
	 * @return row
	 */
	public String getRow() {
		return this.row;
	}
	
	/**
	 * Column Info
	 * @return atecccd2
	 */
	public String getAtecccd2() {
		return this.atecccd2;
	}
	
	/**
	 * Column Info
	 * @return atfmplnwk2
	 */
	public String getAtfmplnwk2() {
		return this.atfmplnwk2;
	}
	
	/**
	 * Column Info
	 * @return attoplnyr2
	 */
	public String getAttoplnyr2() {
		return this.attoplnyr2;
	}
	
	/**
	 * Column Info
	 * @return atfmplnyrwk2
	 */
	public String getAtfmplnyrwk2() {
		return this.atfmplnyrwk2;
	}
	
	/**
	 * Column Info
	 * @return fmfmplnyrwk2
	 */
	public String getFmfmplnyrwk2() {
		return this.fmfmplnyrwk2;
	}
	
	/**
	 * Column Info
	 * @return fmecccd2
	 */
	public String getFmecccd2() {
		return this.fmecccd2;
	}
	
	/**
	 * Column Info
	 * @return vvdYrwk
	 */
	public String getVvdYrwk() {
		return this.vvdYrwk;
	}
	
	/**
	 * Column Info
	 * @return totoplnyrwk2
	 */
	public String getTotoplnyrwk2() {
		return this.totoplnyrwk2;
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
	 * @return fmfmplnwk2
	 */
	public String getFmfmplnwk2() {
		return this.fmfmplnwk2;
	}
	
	/**
	 * Column Info
	 * @return attoplnyrwk2
	 */
	public String getAttoplnyrwk2() {
		return this.attoplnyrwk2;
	}
	
	/**
	 * Column Info
	 * @return fmtype2
	 */
	public String getFmtype2() {
		return this.fmtype2;
	}
	
	/**
	 * Column Info
	 * @return repoId
	 */
	public String getRepoId() {
		return this.repoId;
	}
	
	/**
	 * Column Info
	 * @return tofmplnyr2
	 */
	public String getTofmplnyr2() {
		return this.tofmplnyr2;
	}
	
	/**
	 * Column Info
	 * @return totoplnwk2
	 */
	public String getTotoplnwk2() {
		return this.totoplnwk2;
	}
	
	/**
	 * Column Info
	 * @return fmtoplnyr2
	 */
	public String getFmtoplnyr2() {
		return this.fmtoplnyr2;
	}
	
	/**
	 * Column Info
	 * @return poscol
	 */
	public String getPoscol() {
		return this.poscol;
	}
	
	/**
	 * Column Info
	 * @return scnrId
	 */
	public String getScnrId() {
		return this.scnrId;
	}
	
	/**
	 * Column Info
	 * @return fmtoplnyrwk2
	 */
	public String getFmtoplnyrwk2() {
		return this.fmtoplnyrwk2;
	}
	
	/**
	 * Column Info
	 * @return tofmplnwk2
	 */
	public String getTofmplnwk2() {
		return this.tofmplnwk2;
	}
	
	/**
	 * Column Info
	 * @return fmtoat2
	 */
	public String getFmtoat2() {
		return this.fmtoat2;
	}
	
	/**
	 * Column Info
	 * @return attoplnwk2
	 */
	public String getAttoplnwk2() {
		return this.attoplnwk2;
	}
	
	/**
	 * Column Info
	 * @return lane2
	 */
	public String getLane2() {
		return this.lane2;
	}
	
	/**
	 * Column Info
	 * @return tpszall
	 */
	public String getTpszall() {
		return this.tpszall;
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
	 * @return tofmplnyrwk2
	 */
	public String getTofmplnyrwk2() {
		return this.tofmplnyrwk2;
	}
	
	/**
	 * Column Info
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
	}
	
	/**
	 * Column Info
	 * @return repoPlnId
	 */
	public String getRepoPlnId() {
		return this.repoPlnId;
	}
	
	/**
	 * Column Info
	 * @return fmfmplnyr2
	 */
	public String getFmfmplnyr2() {
		return this.fmfmplnyr2;
	}
	
	/**
	 * Column Info
	 * @return totype2
	 */
	public String getTotype2() {
		return this.totype2;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	

	/**
	 * Column Info
	 * @param item2
	 */
	public void setItem2(String item2) {
		this.item2 = item2;
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
	 * @param col
	 */
	public void setCol(String col) {
		this.col = col;
	}
	
	/**
	 * Column Info
	 * @param cntrtpszcd2
	 */
	public void setCntrtpszcd2(String cntrtpszcd2) {
		this.cntrtpszcd2 = cntrtpszcd2;
	}
	
	/**
	 * Column Info
	 * @param statusType
	 */
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
	/**
	 * Column Info
	 * @param fmtypeby2
	 */
	public void setFmtypeby2(String fmtypeby2) {
		this.fmtypeby2 = fmtypeby2;
	}
	
	/**
	 * Column Info
	 * @param atfmplnyr2
	 */
	public void setAtfmplnyr2(String atfmplnyr2) {
		this.atfmplnyr2 = atfmplnyr2;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param vslLaneCd
	 */
	public void setVslLaneCd(String vslLaneCd) {
		this.vslLaneCd = vslLaneCd;
	}
	
	/**
	 * Column Info
	 * @param repoRmk
	 */
	public void setRepoRmk(String repoRmk) {
		this.repoRmk = repoRmk;
	}
	
	/**
	 * Column Info
	 * @param totypeby2
	 */
	public void setTotypeby2(String totypeby2) {
		this.totypeby2 = totypeby2;
	}
	
	/**
	 * Column Info
	 * @param totoplnyr2
	 */
	public void setTotoplnyr2(String totoplnyr2) {
		this.totoplnyr2 = totoplnyr2;
	}
	
	/**
	 * Column Info
	 * @param attypeby2
	 */
	public void setAttypeby2(String attypeby2) {
		this.attypeby2 = attypeby2;
	}
	
	/**
	 * Column Info
	 * @param toecccd2
	 */
	public void setToecccd2(String toecccd2) {
		this.toecccd2 = toecccd2;
	}
	
	/**
	 * Column Info
	 * @param attype2
	 */
	public void setAttype2(String attype2) {
		this.attype2 = attype2;
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
	 * @param vvd2
	 */
	public void setVvd2(String vvd2) {
		this.vvd2 = vvd2;
	}
	
	/**
	 * Column Info
	 * @param fmtoplnwk2
	 */
	public void setFmtoplnwk2(String fmtoplnwk2) {
		this.fmtoplnwk2 = fmtoplnwk2;
	}
	
	/**
	 * Column Info
	 * @param row
	 */
	public void setRow(String row) {
		this.row = row;
	}
	
	/**
	 * Column Info
	 * @param atecccd2
	 */
	public void setAtecccd2(String atecccd2) {
		this.atecccd2 = atecccd2;
	}
	
	/**
	 * Column Info
	 * @param atfmplnwk2
	 */
	public void setAtfmplnwk2(String atfmplnwk2) {
		this.atfmplnwk2 = atfmplnwk2;
	}
	
	/**
	 * Column Info
	 * @param attoplnyr2
	 */
	public void setAttoplnyr2(String attoplnyr2) {
		this.attoplnyr2 = attoplnyr2;
	}
	
	/**
	 * Column Info
	 * @param atfmplnyrwk2
	 */
	public void setAtfmplnyrwk2(String atfmplnyrwk2) {
		this.atfmplnyrwk2 = atfmplnyrwk2;
	}
	
	/**
	 * Column Info
	 * @param fmfmplnyrwk2
	 */
	public void setFmfmplnyrwk2(String fmfmplnyrwk2) {
		this.fmfmplnyrwk2 = fmfmplnyrwk2;
	}
	
	/**
	 * Column Info
	 * @param fmecccd2
	 */
	public void setFmecccd2(String fmecccd2) {
		this.fmecccd2 = fmecccd2;
	}
	
	/**
	 * Column Info
	 * @param vvdYrwk
	 */
	public void setVvdYrwk(String vvdYrwk) {
		this.vvdYrwk = vvdYrwk;
	}
	
	/**
	 * Column Info
	 * @param totoplnyrwk2
	 */
	public void setTotoplnyrwk2(String totoplnyrwk2) {
		this.totoplnyrwk2 = totoplnyrwk2;
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
	 * @param fmfmplnwk2
	 */
	public void setFmfmplnwk2(String fmfmplnwk2) {
		this.fmfmplnwk2 = fmfmplnwk2;
	}
	
	/**
	 * Column Info
	 * @param attoplnyrwk2
	 */
	public void setAttoplnyrwk2(String attoplnyrwk2) {
		this.attoplnyrwk2 = attoplnyrwk2;
	}
	
	/**
	 * Column Info
	 * @param fmtype2
	 */
	public void setFmtype2(String fmtype2) {
		this.fmtype2 = fmtype2;
	}
	
	/**
	 * Column Info
	 * @param repoId
	 */
	public void setRepoId(String repoId) {
		this.repoId = repoId;
	}
	
	/**
	 * Column Info
	 * @param tofmplnyr2
	 */
	public void setTofmplnyr2(String tofmplnyr2) {
		this.tofmplnyr2 = tofmplnyr2;
	}
	
	/**
	 * Column Info
	 * @param totoplnwk2
	 */
	public void setTotoplnwk2(String totoplnwk2) {
		this.totoplnwk2 = totoplnwk2;
	}
	
	/**
	 * Column Info
	 * @param fmtoplnyr2
	 */
	public void setFmtoplnyr2(String fmtoplnyr2) {
		this.fmtoplnyr2 = fmtoplnyr2;
	}
	
	/**
	 * Column Info
	 * @param poscol
	 */
	public void setPoscol(String poscol) {
		this.poscol = poscol;
	}
	
	/**
	 * Column Info
	 * @param scnrId
	 */
	public void setScnrId(String scnrId) {
		this.scnrId = scnrId;
	}
	
	/**
	 * Column Info
	 * @param fmtoplnyrwk2
	 */
	public void setFmtoplnyrwk2(String fmtoplnyrwk2) {
		this.fmtoplnyrwk2 = fmtoplnyrwk2;
	}
	
	/**
	 * Column Info
	 * @param tofmplnwk2
	 */
	public void setTofmplnwk2(String tofmplnwk2) {
		this.tofmplnwk2 = tofmplnwk2;
	}
	
	/**
	 * Column Info
	 * @param fmtoat2
	 */
	public void setFmtoat2(String fmtoat2) {
		this.fmtoat2 = fmtoat2;
	}
	
	/**
	 * Column Info
	 * @param attoplnwk2
	 */
	public void setAttoplnwk2(String attoplnwk2) {
		this.attoplnwk2 = attoplnwk2;
	}
	
	/**
	 * Column Info
	 * @param lane2
	 */
	public void setLane2(String lane2) {
		this.lane2 = lane2;
	}
	
	/**
	 * Column Info
	 * @param tpszall
	 */
	public void setTpszall(String tpszall) {
		this.tpszall = tpszall;
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
	 * @param tofmplnyrwk2
	 */
	public void setTofmplnyrwk2(String tofmplnyrwk2) {
		this.tofmplnyrwk2 = tofmplnyrwk2;
	}
	
	/**
	 * Column Info
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}
	
	/**
	 * Column Info
	 * @param repoPlnId
	 */
	public void setRepoPlnId(String repoPlnId) {
		this.repoPlnId = repoPlnId;
	}
	
	/**
	 * Column Info
	 * @param fmfmplnyr2
	 */
	public void setFmfmplnyr2(String fmfmplnyr2) {
		this.fmfmplnyr2 = fmfmplnyr2;
	}
	
	/**
	 * Column Info
	 * @param totype2
	 */
	public void setTotype2(String totype2) {
		this.totype2 = totype2;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setItem2(JSPUtil.getParameter(request, "item_2", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCol(JSPUtil.getParameter(request, "col", ""));
		setCntrtpszcd2(JSPUtil.getParameter(request, "cntrTpszCd_2", ""));
		setStatusType(JSPUtil.getParameter(request, "status_type", ""));
		setFmtypeby2(JSPUtil.getParameter(request, "fmTypeBy_2", ""));
		setAtfmplnyr2(JSPUtil.getParameter(request, "atFmPlnYr_2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVslLaneCd(JSPUtil.getParameter(request, "vsl_lane_cd", ""));
		setRepoRmk(JSPUtil.getParameter(request, "repo_rmk", ""));
		setTotypeby2(JSPUtil.getParameter(request, "toTypeBy_2", ""));
		setTotoplnyr2(JSPUtil.getParameter(request, "toToPlnYr_2", ""));
		setAttypeby2(JSPUtil.getParameter(request, "atTypeBy_2", ""));
		setToecccd2(JSPUtil.getParameter(request, "toEccCd_2", ""));
		setAttype2(JSPUtil.getParameter(request, "atType_2", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVvd2(JSPUtil.getParameter(request, "vvd_2", ""));
		setFmtoplnwk2(JSPUtil.getParameter(request, "fmToPlnWk_2", ""));
		setRow(JSPUtil.getParameter(request, "row", ""));
		setAtecccd2(JSPUtil.getParameter(request, "atEccCd_2", ""));
		setAtfmplnwk2(JSPUtil.getParameter(request, "atFmPlnWk_2", ""));
		setAttoplnyr2(JSPUtil.getParameter(request, "atToPlnYr_2", ""));
		setAtfmplnyrwk2(JSPUtil.getParameter(request, "atFmPlnYrWk_2", ""));
		setFmfmplnyrwk2(JSPUtil.getParameter(request, "fmFmPlnYrWk_2", ""));
		setFmecccd2(JSPUtil.getParameter(request, "fmEccCd_2", ""));
		setVvdYrwk(JSPUtil.getParameter(request, "vvd_yrwk", ""));
		setTotoplnyrwk2(JSPUtil.getParameter(request, "toToPlnYrWk_2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmfmplnwk2(JSPUtil.getParameter(request, "fmFmPlnWk_2", ""));
		setAttoplnyrwk2(JSPUtil.getParameter(request, "atToPlnYrWk_2", ""));
		setFmtype2(JSPUtil.getParameter(request, "fmType_2", ""));
		setRepoId(JSPUtil.getParameter(request, "repo_id", ""));
		setTofmplnyr2(JSPUtil.getParameter(request, "toFmPlnYr_2", ""));
		setTotoplnwk2(JSPUtil.getParameter(request, "toToPlnWk_2", ""));
		setFmtoplnyr2(JSPUtil.getParameter(request, "fmToPlnYr_2", ""));
		setPoscol(JSPUtil.getParameter(request, "posCol", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setFmtoplnyrwk2(JSPUtil.getParameter(request, "fmToPlnYrWk_2", ""));
		setTofmplnwk2(JSPUtil.getParameter(request, "toFmPlnWk_2", ""));
		setFmtoat2(JSPUtil.getParameter(request, "fmToAt2", ""));
		setAttoplnwk2(JSPUtil.getParameter(request, "atToPlnWk_2", ""));
		setLane2(JSPUtil.getParameter(request, "lane_2", ""));
		setTpszall(JSPUtil.getParameter(request, "tpszall", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setTofmplnyrwk2(JSPUtil.getParameter(request, "toFmPlnYrWk_2", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setFmfmplnyr2(JSPUtil.getParameter(request, "fmFmPlnYr_2", ""));
		setTotype2(JSPUtil.getParameter(request, "toType_2", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0052ConditionVO[]
	 */
	public EesEqr0052ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0052ConditionVO[]
	 */
	public EesEqr0052ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0052ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] item2 = (JSPUtil.getParameter(request, prefix	+ "item_2", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] col = (JSPUtil.getParameter(request, prefix	+ "col", length));
			String[] cntrtpszcd2 = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd_2", length));
			String[] statusType = (JSPUtil.getParameter(request, prefix	+ "status_type", length));
			String[] fmtypeby2 = (JSPUtil.getParameter(request, prefix	+ "fmtypeby_2", length));
			String[] atfmplnyr2 = (JSPUtil.getParameter(request, prefix	+ "atfmplnyr_2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslLaneCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_cd", length));
			String[] repoRmk = (JSPUtil.getParameter(request, prefix	+ "repo_rmk", length));
			String[] totypeby2 = (JSPUtil.getParameter(request, prefix	+ "totypeby_2", length));
			String[] totoplnyr2 = (JSPUtil.getParameter(request, prefix	+ "totoplnyr_2", length));
			String[] attypeby2 = (JSPUtil.getParameter(request, prefix	+ "attypeby_2", length));
			String[] toecccd2 = (JSPUtil.getParameter(request, prefix	+ "toecccd_2", length));
			String[] attype2 = (JSPUtil.getParameter(request, prefix	+ "attype_2", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vvd2 = (JSPUtil.getParameter(request, prefix	+ "vvd_2", length));
			String[] fmtoplnwk2 = (JSPUtil.getParameter(request, prefix	+ "fmtoplnwk_2", length));
			String[] row = (JSPUtil.getParameter(request, prefix	+ "row", length));
			String[] atecccd2 = (JSPUtil.getParameter(request, prefix	+ "atecccd_2", length));
			String[] atfmplnwk2 = (JSPUtil.getParameter(request, prefix	+ "atfmplnwk_2", length));
			String[] attoplnyr2 = (JSPUtil.getParameter(request, prefix	+ "attoplnyr_2", length));
			String[] atfmplnyrwk2 = (JSPUtil.getParameter(request, prefix	+ "atfmplnyrwk_2", length));
			String[] fmfmplnyrwk2 = (JSPUtil.getParameter(request, prefix	+ "fmfmplnyrwk_2", length));
			String[] fmecccd2 = (JSPUtil.getParameter(request, prefix	+ "fmecccd_2", length));
			String[] vvdYrwk = (JSPUtil.getParameter(request, prefix	+ "vvd_yrwk", length));
			String[] totoplnyrwk2 = (JSPUtil.getParameter(request, prefix	+ "totoplnyrwk_2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmfmplnwk2 = (JSPUtil.getParameter(request, prefix	+ "fmfmplnwk_2", length));
			String[] attoplnyrwk2 = (JSPUtil.getParameter(request, prefix	+ "attoplnyrwk_2", length));
			String[] fmtype2 = (JSPUtil.getParameter(request, prefix	+ "fmtype_2", length));
			String[] repoId = (JSPUtil.getParameter(request, prefix	+ "repo_id", length));
			String[] tofmplnyr2 = (JSPUtil.getParameter(request, prefix	+ "tofmplnyr_2", length));
			String[] totoplnwk2 = (JSPUtil.getParameter(request, prefix	+ "totoplnwk_2", length));
			String[] fmtoplnyr2 = (JSPUtil.getParameter(request, prefix	+ "fmtoplnyr_2", length));
			String[] poscol = (JSPUtil.getParameter(request, prefix	+ "poscol", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] fmtoplnyrwk2 = (JSPUtil.getParameter(request, prefix	+ "fmtoplnyrwk_2", length));
			String[] tofmplnwk2 = (JSPUtil.getParameter(request, prefix	+ "tofmplnwk_2", length));
			String[] fmtoat2 = (JSPUtil.getParameter(request, prefix	+ "fmtoat2", length));
			String[] attoplnwk2 = (JSPUtil.getParameter(request, prefix	+ "attoplnwk_2", length));
			String[] lane2 = (JSPUtil.getParameter(request, prefix	+ "lane_2", length));
			String[] tpszall = (JSPUtil.getParameter(request, prefix	+ "tpszall", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] tofmplnyrwk2 = (JSPUtil.getParameter(request, prefix	+ "tofmplnyrwk_2", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] fmfmplnyr2 = (JSPUtil.getParameter(request, prefix	+ "fmfmplnyr_2", length));
			String[] totype2 = (JSPUtil.getParameter(request, prefix	+ "totype_2", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0052ConditionVO();
				if (item2[i] != null)
					model.setItem2(item2[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (col[i] != null)
					model.setCol(col[i]);
				if (cntrtpszcd2[i] != null)
					model.setCntrtpszcd2(cntrtpszcd2[i]);
				if (statusType[i] != null)
					model.setStatusType(statusType[i]);
				if (fmtypeby2[i] != null)
					model.setFmtypeby2(fmtypeby2[i]);
				if (atfmplnyr2[i] != null)
					model.setAtfmplnyr2(atfmplnyr2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslLaneCd[i] != null)
					model.setVslLaneCd(vslLaneCd[i]);
				if (repoRmk[i] != null)
					model.setRepoRmk(repoRmk[i]);
				if (totypeby2[i] != null)
					model.setTotypeby2(totypeby2[i]);
				if (totoplnyr2[i] != null)
					model.setTotoplnyr2(totoplnyr2[i]);
				if (attypeby2[i] != null)
					model.setAttypeby2(attypeby2[i]);
				if (toecccd2[i] != null)
					model.setToecccd2(toecccd2[i]);
				if (attype2[i] != null)
					model.setAttype2(attype2[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vvd2[i] != null)
					model.setVvd2(vvd2[i]);
				if (fmtoplnwk2[i] != null)
					model.setFmtoplnwk2(fmtoplnwk2[i]);
				if (row[i] != null)
					model.setRow(row[i]);
				if (atecccd2[i] != null)
					model.setAtecccd2(atecccd2[i]);
				if (atfmplnwk2[i] != null)
					model.setAtfmplnwk2(atfmplnwk2[i]);
				if (attoplnyr2[i] != null)
					model.setAttoplnyr2(attoplnyr2[i]);
				if (atfmplnyrwk2[i] != null)
					model.setAtfmplnyrwk2(atfmplnyrwk2[i]);
				if (fmfmplnyrwk2[i] != null)
					model.setFmfmplnyrwk2(fmfmplnyrwk2[i]);
				if (fmecccd2[i] != null)
					model.setFmecccd2(fmecccd2[i]);
				if (vvdYrwk[i] != null)
					model.setVvdYrwk(vvdYrwk[i]);
				if (totoplnyrwk2[i] != null)
					model.setTotoplnyrwk2(totoplnyrwk2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmfmplnwk2[i] != null)
					model.setFmfmplnwk2(fmfmplnwk2[i]);
				if (attoplnyrwk2[i] != null)
					model.setAttoplnyrwk2(attoplnyrwk2[i]);
				if (fmtype2[i] != null)
					model.setFmtype2(fmtype2[i]);
				if (repoId[i] != null)
					model.setRepoId(repoId[i]);
				if (tofmplnyr2[i] != null)
					model.setTofmplnyr2(tofmplnyr2[i]);
				if (totoplnwk2[i] != null)
					model.setTotoplnwk2(totoplnwk2[i]);
				if (fmtoplnyr2[i] != null)
					model.setFmtoplnyr2(fmtoplnyr2[i]);
				if (poscol[i] != null)
					model.setPoscol(poscol[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (fmtoplnyrwk2[i] != null)
					model.setFmtoplnyrwk2(fmtoplnyrwk2[i]);
				if (tofmplnwk2[i] != null)
					model.setTofmplnwk2(tofmplnwk2[i]);
				if (fmtoat2[i] != null)
					model.setFmtoat2(fmtoat2[i]);
				if (attoplnwk2[i] != null)
					model.setAttoplnwk2(attoplnwk2[i]);
				if (lane2[i] != null)
					model.setLane2(lane2[i]);
				if (tpszall[i] != null)
					model.setTpszall(tpszall[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (tofmplnyrwk2[i] != null)
					model.setTofmplnyrwk2(tofmplnyrwk2[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (fmfmplnyr2[i] != null)
					model.setFmfmplnyr2(fmfmplnyr2[i]);
				if (totype2[i] != null)
					model.setTotype2(totype2[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0052ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0052ConditionVO[]
	 */
	public EesEqr0052ConditionVO[] getEesEqr0052ConditionVOs(){
		EesEqr0052ConditionVO[] vos = (EesEqr0052ConditionVO[])models.toArray(new EesEqr0052ConditionVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.item2 = this.item2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col = this.col .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd2 = this.cntrtpszcd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusType = this.statusType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtypeby2 = this.fmtypeby2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfmplnyr2 = this.atfmplnyr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd = this.vslLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoRmk = this.repoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totypeby2 = this.totypeby2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totoplnyr2 = this.totoplnyr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attypeby2 = this.attypeby2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toecccd2 = this.toecccd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attype2 = this.attype2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 = this.vvd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoplnwk2 = this.fmtoplnwk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row = this.row .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atecccd2 = this.atecccd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfmplnwk2 = this.atfmplnwk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attoplnyr2 = this.attoplnyr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfmplnyrwk2 = this.atfmplnyrwk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmfmplnyrwk2 = this.fmfmplnyrwk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmecccd2 = this.fmecccd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdYrwk = this.vvdYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totoplnyrwk2 = this.totoplnyrwk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmfmplnwk2 = this.fmfmplnwk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attoplnyrwk2 = this.attoplnyrwk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtype2 = this.fmtype2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoId = this.repoId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tofmplnyr2 = this.tofmplnyr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totoplnwk2 = this.totoplnwk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoplnyr2 = this.fmtoplnyr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poscol = this.poscol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoplnyrwk2 = this.fmtoplnyrwk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tofmplnwk2 = this.tofmplnwk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoat2 = this.fmtoat2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attoplnwk2 = this.attoplnwk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane2 = this.lane2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszall = this.tpszall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tofmplnyrwk2 = this.tofmplnyrwk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmfmplnyr2 = this.fmfmplnyr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totype2 = this.totype2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @return the searchFlag
	 */
	public String getSearchFlag() {
		return searchFlag;
	}

	/**
	 * @param searchFlag the searchFlag to set
	 */
	public void setSearchFlag(String searchFlag) {
		this.searchFlag = searchFlag;
	}
}
