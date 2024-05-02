/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0048ConditionVO.java
*@FileTitle : EesEqr0048ConditionVO
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	Lee Byoung Hun	2009.09.15		1.0 최초 생성
*
*@LastModifyDate : 2009.09.15
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0048ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0048ConditionVO> models = new ArrayList<EesEqr0048ConditionVO>();
	
	/* Column Info */
	private String fmecccd5 = null;
	/* Column Info */
	private String statusType = null;
	/* Column Info */
	private String atfmplnyr5 = null;
	/* Column Info */
	private String atecccd5 = null;
	/* Column Info */
	private String fmtypeby5 = null;
	/* Column Info */
	private String totype5 = null;
	/* Column Info */
	private String cntrtpszcd5 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String totypeby5 = null;
	/* Column Info */
	private String fmtype5 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmtoat5 = null;
	/* Column Info */
	private String fmfmplnwk5 = null;
	/* Column Info */
	private String repoRmk = null;
	/* Column Info */
	private String totoplnwk5 = null;
	/* Column Info */
	private String tofmplnyr5 = null;
	/* Column Info */
	private String lane5 = null;
	/* Column Info */
	private String scnrId = null;
	/* Column Info */
	private String fmtoplnyr5 = null;
	/* Column Info */
	private String totoplnyr5 = null;
	/* Column Info */
	private String attoplnwk5 = null;
	/* Column Info */
	private String tpszall = null;
	/* Column Info */
	private String attype5 = null;
	/* Column Info */
	private String toecccd5 = null;
	/* Column Info */
	private String repoPlnId = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String vvd5 = null;
	/* Column Info */
	private String fmtoplnwk5 = null;
	/* Column Info */
	private String item5 = null;
	/* Column Info */
	private String rlatype5 = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String tofmplnwk5 = null;
	/* Column Info */
	private String fmfmplnyr5 = null;
	/* Column Info */
	private String attoplnyr5 = null;
	/* Column Info */
	private String atfmplnwk5 = null;
	/* Column Info */
	private String attypeby5 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0048ConditionVO() {}

	public EesEqr0048ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String statusType, String scnrId, String repoRmk, String repoPlnId, String tpszall, String rlatype5, String fmtoat5, String fmtype5, String fmecccd5, String fmtypeby5, String fmfmplnyr5, String fmfmplnwk5, String fmtoplnyr5, String fmtoplnwk5, String totype5, String toecccd5, String totypeby5, String tofmplnyr5, String tofmplnwk5, String totoplnyr5, String totoplnwk5, String attype5, String atecccd5, String attypeby5, String atfmplnyr5, String atfmplnwk5, String attoplnyr5, String attoplnwk5, String cntrtpszcd5, String item5, String lane5, String vvd5) {
		this.fmecccd5 = fmecccd5;
		this.statusType = statusType;
		this.atfmplnyr5 = atfmplnyr5;
		this.atecccd5 = atecccd5;
		this.fmtypeby5 = fmtypeby5;
		this.totype5 = totype5;
		this.cntrtpszcd5 = cntrtpszcd5;
		this.pagerows = pagerows;
		this.totypeby5 = totypeby5;
		this.fmtype5 = fmtype5;
		this.ibflag = ibflag;
		this.fmtoat5 = fmtoat5;
		this.fmfmplnwk5 = fmfmplnwk5;
		this.repoRmk = repoRmk;
		this.totoplnwk5 = totoplnwk5;
		this.tofmplnyr5 = tofmplnyr5;
		this.lane5 = lane5;
		this.scnrId = scnrId;
		this.fmtoplnyr5 = fmtoplnyr5;
		this.totoplnyr5 = totoplnyr5;
		this.attoplnwk5 = attoplnwk5;
		this.tpszall = tpszall;
		this.attype5 = attype5;
		this.toecccd5 = toecccd5;
		this.repoPlnId = repoPlnId;
		this.yyyyww = yyyyww;
		this.vvd5 = vvd5;
		this.fmtoplnwk5 = fmtoplnwk5;
		this.item5 = item5;
		this.rlatype5 = rlatype5;
		this.seq = seq;
		this.tofmplnwk5 = tofmplnwk5;
		this.fmfmplnyr5 = fmfmplnyr5;
		this.attoplnyr5 = attoplnyr5;
		this.atfmplnwk5 = atfmplnwk5;
		this.attypeby5 = attypeby5;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fmecccd_5", getFmecccd5());
		this.hashColumns.put("status_type", getStatusType());
		this.hashColumns.put("atfmplnyr_5", getAtfmplnyr5());
		this.hashColumns.put("atecccd_5", getAtecccd5());
		this.hashColumns.put("fmtypeby_5", getFmtypeby5());
		this.hashColumns.put("totype_5", getTotype5());
		this.hashColumns.put("cntrtpszcd_5", getCntrtpszcd5());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("totypeby_5", getTotypeby5());
		this.hashColumns.put("fmtype_5", getFmtype5());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fmtoat5", getFmtoat5());
		this.hashColumns.put("fmfmplnwk_5", getFmfmplnwk5());
		this.hashColumns.put("repo_rmk", getRepoRmk());
		this.hashColumns.put("totoplnwk_5", getTotoplnwk5());
		this.hashColumns.put("tofmplnyr_5", getTofmplnyr5());
		this.hashColumns.put("lane_5", getLane5());
		this.hashColumns.put("scnr_id", getScnrId());
		this.hashColumns.put("fmtoplnyr_5", getFmtoplnyr5());
		this.hashColumns.put("totoplnyr_5", getTotoplnyr5());
		this.hashColumns.put("attoplnwk_5", getAttoplnwk5());
		this.hashColumns.put("tpszall", getTpszall());
		this.hashColumns.put("attype_5", getAttype5());
		this.hashColumns.put("toecccd_5", getToecccd5());
		this.hashColumns.put("repo_pln_id", getRepoPlnId());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("vvd_5", getVvd5());
		this.hashColumns.put("fmtoplnwk_5", getFmtoplnwk5());
		this.hashColumns.put("item_5", getItem5());
		this.hashColumns.put("rlatype_5", getRlatype5());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("tofmplnwk_5", getTofmplnwk5());
		this.hashColumns.put("fmfmplnyr_5", getFmfmplnyr5());
		this.hashColumns.put("attoplnyr_5", getAttoplnyr5());
		this.hashColumns.put("atfmplnwk_5", getAtfmplnwk5());
		this.hashColumns.put("attypeby_5", getAttypeby5());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fmecccd_5", "fmecccd5");
		this.hashFields.put("status_type", "statusType");
		this.hashFields.put("atfmplnyr_5", "atfmplnyr5");
		this.hashFields.put("atecccd_5", "atecccd5");
		this.hashFields.put("fmtypeby_5", "fmtypeby5");
		this.hashFields.put("totype_5", "totype5");
		this.hashFields.put("cntrtpszcd_5", "cntrtpszcd5");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("totypeby_5", "totypeby5");
		this.hashFields.put("fmtype_5", "fmtype5");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fmtoat5", "fmtoat5");
		this.hashFields.put("fmfmplnwk_5", "fmfmplnwk5");
		this.hashFields.put("repo_rmk", "repoRmk");
		this.hashFields.put("totoplnwk_5", "totoplnwk5");
		this.hashFields.put("tofmplnyr_5", "tofmplnyr5");
		this.hashFields.put("lane_5", "lane5");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("fmtoplnyr_5", "fmtoplnyr5");
		this.hashFields.put("totoplnyr_5", "totoplnyr5");
		this.hashFields.put("attoplnwk_5", "attoplnwk5");
		this.hashFields.put("tpszall", "tpszall");
		this.hashFields.put("attype_5", "attype5");
		this.hashFields.put("toecccd_5", "toecccd5");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("vvd_5", "vvd5");
		this.hashFields.put("fmtoplnwk_5", "fmtoplnwk5");
		this.hashFields.put("item_5", "item5");
		this.hashFields.put("rlatype_5", "rlatype5");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("tofmplnwk_5", "tofmplnwk5");
		this.hashFields.put("fmfmplnyr_5", "fmfmplnyr5");
		this.hashFields.put("attoplnyr_5", "attoplnyr5");
		this.hashFields.put("atfmplnwk_5", "atfmplnwk5");
		this.hashFields.put("attypeby_5", "attypeby5");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmecccd5
	 */
	public String getFmecccd5() {
		return this.fmecccd5;
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
	 * @return atfmplnyr5
	 */
	public String getAtfmplnyr5() {
		return this.atfmplnyr5;
	}
	
	/**
	 * Column Info
	 * @return atecccd5
	 */
	public String getAtecccd5() {
		return this.atecccd5;
	}
	
	/**
	 * Column Info
	 * @return fmtypeby5
	 */
	public String getFmtypeby5() {
		return this.fmtypeby5;
	}
	
	/**
	 * Column Info
	 * @return totype5
	 */
	public String getTotype5() {
		return this.totype5;
	}
	
	/**
	 * Column Info
	 * @return cntrtpszcd5
	 */
	public String getCntrtpszcd5() {
		return this.cntrtpszcd5;
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
	 * @return totypeby5
	 */
	public String getTotypeby5() {
		return this.totypeby5;
	}
	
	/**
	 * Column Info
	 * @return fmtype5
	 */
	public String getFmtype5() {
		return this.fmtype5;
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
	 * @return fmtoat5
	 */
	public String getFmtoat5() {
		return this.fmtoat5;
	}
	
	/**
	 * Column Info
	 * @return fmfmplnwk5
	 */
	public String getFmfmplnwk5() {
		return this.fmfmplnwk5;
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
	 * @return totoplnwk5
	 */
	public String getTotoplnwk5() {
		return this.totoplnwk5;
	}
	
	/**
	 * Column Info
	 * @return tofmplnyr5
	 */
	public String getTofmplnyr5() {
		return this.tofmplnyr5;
	}
	
	/**
	 * Column Info
	 * @return lane5
	 */
	public String getLane5() {
		return this.lane5;
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
	 * @return fmtoplnyr5
	 */
	public String getFmtoplnyr5() {
		return this.fmtoplnyr5;
	}
	
	/**
	 * Column Info
	 * @return totoplnyr5
	 */
	public String getTotoplnyr5() {
		return this.totoplnyr5;
	}
	
	/**
	 * Column Info
	 * @return attoplnwk5
	 */
	public String getAttoplnwk5() {
		return this.attoplnwk5;
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
	 * @return attype5
	 */
	public String getAttype5() {
		return this.attype5;
	}
	
	/**
	 * Column Info
	 * @return toecccd5
	 */
	public String getToecccd5() {
		return this.toecccd5;
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
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
	}
	
	/**
	 * Column Info
	 * @return vvd5
	 */
	public String getVvd5() {
		return this.vvd5;
	}
	
	/**
	 * Column Info
	 * @return fmtoplnwk5
	 */
	public String getFmtoplnwk5() {
		return this.fmtoplnwk5;
	}
	
	/**
	 * Column Info
	 * @return item5
	 */
	public String getItem5() {
		return this.item5;
	}
	
	/**
	 * Column Info
	 * @return rlatype5
	 */
	public String getRlatype5() {
		return this.rlatype5;
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
	 * @return tofmplnwk5
	 */
	public String getTofmplnwk5() {
		return this.tofmplnwk5;
	}
	
	/**
	 * Column Info
	 * @return fmfmplnyr5
	 */
	public String getFmfmplnyr5() {
		return this.fmfmplnyr5;
	}
	
	/**
	 * Column Info
	 * @return attoplnyr5
	 */
	public String getAttoplnyr5() {
		return this.attoplnyr5;
	}
	
	/**
	 * Column Info
	 * @return atfmplnwk5
	 */
	public String getAtfmplnwk5() {
		return this.atfmplnwk5;
	}
	
	/**
	 * Column Info
	 * @return attypeby5
	 */
	public String getAttypeby5() {
		return this.attypeby5;
	}
	

	/**
	 * Column Info
	 * @param fmecccd5
	 */
	public void setFmecccd5(String fmecccd5) {
		this.fmecccd5 = fmecccd5;
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
	 * @param atfmplnyr5
	 */
	public void setAtfmplnyr5(String atfmplnyr5) {
		this.atfmplnyr5 = atfmplnyr5;
	}
	
	/**
	 * Column Info
	 * @param atecccd5
	 */
	public void setAtecccd5(String atecccd5) {
		this.atecccd5 = atecccd5;
	}
	
	/**
	 * Column Info
	 * @param fmtypeby5
	 */
	public void setFmtypeby5(String fmtypeby5) {
		this.fmtypeby5 = fmtypeby5;
	}
	
	/**
	 * Column Info
	 * @param totype5
	 */
	public void setTotype5(String totype5) {
		this.totype5 = totype5;
	}
	
	/**
	 * Column Info
	 * @param cntrtpszcd5
	 */
	public void setCntrtpszcd5(String cntrtpszcd5) {
		this.cntrtpszcd5 = cntrtpszcd5;
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
	 * @param totypeby5
	 */
	public void setTotypeby5(String totypeby5) {
		this.totypeby5 = totypeby5;
	}
	
	/**
	 * Column Info
	 * @param fmtype5
	 */
	public void setFmtype5(String fmtype5) {
		this.fmtype5 = fmtype5;
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
	 * @param fmtoat5
	 */
	public void setFmtoat5(String fmtoat5) {
		this.fmtoat5 = fmtoat5;
	}
	
	/**
	 * Column Info
	 * @param fmfmplnwk5
	 */
	public void setFmfmplnwk5(String fmfmplnwk5) {
		this.fmfmplnwk5 = fmfmplnwk5;
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
	 * @param totoplnwk5
	 */
	public void setTotoplnwk5(String totoplnwk5) {
		this.totoplnwk5 = totoplnwk5;
	}
	
	/**
	 * Column Info
	 * @param tofmplnyr5
	 */
	public void setTofmplnyr5(String tofmplnyr5) {
		this.tofmplnyr5 = tofmplnyr5;
	}
	
	/**
	 * Column Info
	 * @param lane5
	 */
	public void setLane5(String lane5) {
		this.lane5 = lane5;
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
	 * @param fmtoplnyr5
	 */
	public void setFmtoplnyr5(String fmtoplnyr5) {
		this.fmtoplnyr5 = fmtoplnyr5;
	}
	
	/**
	 * Column Info
	 * @param totoplnyr5
	 */
	public void setTotoplnyr5(String totoplnyr5) {
		this.totoplnyr5 = totoplnyr5;
	}
	
	/**
	 * Column Info
	 * @param attoplnwk5
	 */
	public void setAttoplnwk5(String attoplnwk5) {
		this.attoplnwk5 = attoplnwk5;
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
	 * @param attype5
	 */
	public void setAttype5(String attype5) {
		this.attype5 = attype5;
	}
	
	/**
	 * Column Info
	 * @param toecccd5
	 */
	public void setToecccd5(String toecccd5) {
		this.toecccd5 = toecccd5;
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
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}
	
	/**
	 * Column Info
	 * @param vvd5
	 */
	public void setVvd5(String vvd5) {
		this.vvd5 = vvd5;
	}
	
	/**
	 * Column Info
	 * @param fmtoplnwk5
	 */
	public void setFmtoplnwk5(String fmtoplnwk5) {
		this.fmtoplnwk5 = fmtoplnwk5;
	}
	
	/**
	 * Column Info
	 * @param item5
	 */
	public void setItem5(String item5) {
		this.item5 = item5;
	}
	
	/**
	 * Column Info
	 * @param rlatype5
	 */
	public void setRlatype5(String rlatype5) {
		this.rlatype5 = rlatype5;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param tofmplnwk5
	 */
	public void setTofmplnwk5(String tofmplnwk5) {
		this.tofmplnwk5 = tofmplnwk5;
	}
	
	/**
	 * Column Info
	 * @param fmfmplnyr5
	 */
	public void setFmfmplnyr5(String fmfmplnyr5) {
		this.fmfmplnyr5 = fmfmplnyr5;
	}
	
	/**
	 * Column Info
	 * @param attoplnyr5
	 */
	public void setAttoplnyr5(String attoplnyr5) {
		this.attoplnyr5 = attoplnyr5;
	}
	
	/**
	 * Column Info
	 * @param atfmplnwk5
	 */
	public void setAtfmplnwk5(String atfmplnwk5) {
		this.atfmplnwk5 = atfmplnwk5;
	}
	
	/**
	 * Column Info
	 * @param attypeby5
	 */
	public void setAttypeby5(String attypeby5) {
		this.attypeby5 = attypeby5;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmecccd5(JSPUtil.getParameter(request, "fmEccCd_5", ""));
		setStatusType(JSPUtil.getParameter(request, "status_type", ""));
		setAtfmplnyr5(JSPUtil.getParameter(request, "atFmPlnYr_5", ""));
		setAtecccd5(JSPUtil.getParameter(request, "atEccCd_5", ""));
		setFmtypeby5(JSPUtil.getParameter(request, "fmTypeBy_5", ""));
		setTotype5(JSPUtil.getParameter(request, "toType_5", ""));
		setCntrtpszcd5(JSPUtil.getParameter(request, "cntrTpszCd_5", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTotypeby5(JSPUtil.getParameter(request, "toTypeBy_5", ""));
		setFmtype5(JSPUtil.getParameter(request, "fmType_5", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmtoat5(JSPUtil.getParameter(request, "fmToAt5", ""));
		setFmfmplnwk5(JSPUtil.getParameter(request, "fmFmPlnWk_5", ""));
		setRepoRmk(JSPUtil.getParameter(request, "repo_rmk", ""));
		setTotoplnwk5(JSPUtil.getParameter(request, "toToPlnWk_5", ""));
		setTofmplnyr5(JSPUtil.getParameter(request, "toFmPlnYr_5", ""));
		setLane5(JSPUtil.getParameter(request, "lane_5", ""));
		setScnrId(JSPUtil.getParameter(request, "scnr_id", ""));
		setFmtoplnyr5(JSPUtil.getParameter(request, "fmToPlnYr_5", ""));
		setTotoplnyr5(JSPUtil.getParameter(request, "toToPlnYr_5", ""));
		setAttoplnwk5(JSPUtil.getParameter(request, "atToPlnWk_5", ""));
		setTpszall(JSPUtil.getParameter(request, "tpszall", ""));
		setAttype5(JSPUtil.getParameter(request, "atType_5", ""));
		setToecccd5(JSPUtil.getParameter(request, "toEccCd_5", ""));
		setRepoPlnId(JSPUtil.getParameter(request, "repo_pln_id", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setVvd5(JSPUtil.getParameter(request, "vvd_5", ""));
		setFmtoplnwk5(JSPUtil.getParameter(request, "fmToPlnWk_5", ""));
		setItem5(JSPUtil.getParameter(request, "item_5", ""));
		setRlatype5(JSPUtil.getParameter(request, "rlaType_5", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setTofmplnwk5(JSPUtil.getParameter(request, "toFmPlnWk_5", ""));
		setFmfmplnyr5(JSPUtil.getParameter(request, "fmFmPlnYr_5", ""));
		setAttoplnyr5(JSPUtil.getParameter(request, "atToPlnYr_5", ""));
		setAtfmplnwk5(JSPUtil.getParameter(request, "atFmPlnWk_5", ""));
		setAttypeby5(JSPUtil.getParameter(request, "atTypeBy_5", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0048ConditionVO[]
	 */
	public EesEqr0048ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0048ConditionVO[]
	 */
	public EesEqr0048ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0048ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmecccd5 = (JSPUtil.getParameter(request, prefix	+ "fmecccd_5", length));
			String[] statusType = (JSPUtil.getParameter(request, prefix	+ "status_type", length));
			String[] atfmplnyr5 = (JSPUtil.getParameter(request, prefix	+ "atfmplnyr_5", length));
			String[] atecccd5 = (JSPUtil.getParameter(request, prefix	+ "atecccd_5", length));
			String[] fmtypeby5 = (JSPUtil.getParameter(request, prefix	+ "fmtypeby_5", length));
			String[] totype5 = (JSPUtil.getParameter(request, prefix	+ "totype_5", length));
			String[] cntrtpszcd5 = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd_5", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] totypeby5 = (JSPUtil.getParameter(request, prefix	+ "totypeby_5", length));
			String[] fmtype5 = (JSPUtil.getParameter(request, prefix	+ "fmtype_5", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmtoat5 = (JSPUtil.getParameter(request, prefix	+ "fmtoat5", length));
			String[] fmfmplnwk5 = (JSPUtil.getParameter(request, prefix	+ "fmfmplnwk_5", length));
			String[] repoRmk = (JSPUtil.getParameter(request, prefix	+ "repo_rmk", length));
			String[] totoplnwk5 = (JSPUtil.getParameter(request, prefix	+ "totoplnwk_5", length));
			String[] tofmplnyr5 = (JSPUtil.getParameter(request, prefix	+ "tofmplnyr_5", length));
			String[] lane5 = (JSPUtil.getParameter(request, prefix	+ "lane_5", length));
			String[] scnrId = (JSPUtil.getParameter(request, prefix	+ "scnr_id", length));
			String[] fmtoplnyr5 = (JSPUtil.getParameter(request, prefix	+ "fmtoplnyr_5", length));
			String[] totoplnyr5 = (JSPUtil.getParameter(request, prefix	+ "totoplnyr_5", length));
			String[] attoplnwk5 = (JSPUtil.getParameter(request, prefix	+ "attoplnwk_5", length));
			String[] tpszall = (JSPUtil.getParameter(request, prefix	+ "tpszall", length));
			String[] attype5 = (JSPUtil.getParameter(request, prefix	+ "attype_5", length));
			String[] toecccd5 = (JSPUtil.getParameter(request, prefix	+ "toecccd_5", length));
			String[] repoPlnId = (JSPUtil.getParameter(request, prefix	+ "repo_pln_id", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] vvd5 = (JSPUtil.getParameter(request, prefix	+ "vvd_5", length));
			String[] fmtoplnwk5 = (JSPUtil.getParameter(request, prefix	+ "fmtoplnwk_5", length));
			String[] item5 = (JSPUtil.getParameter(request, prefix	+ "item_5", length));
			String[] rlatype5 = (JSPUtil.getParameter(request, prefix	+ "rlatype_5", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] tofmplnwk5 = (JSPUtil.getParameter(request, prefix	+ "tofmplnwk_5", length));
			String[] fmfmplnyr5 = (JSPUtil.getParameter(request, prefix	+ "fmfmplnyr_5", length));
			String[] attoplnyr5 = (JSPUtil.getParameter(request, prefix	+ "attoplnyr_5", length));
			String[] atfmplnwk5 = (JSPUtil.getParameter(request, prefix	+ "atfmplnwk_5", length));
			String[] attypeby5 = (JSPUtil.getParameter(request, prefix	+ "attypeby_5", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0048ConditionVO();
				if (fmecccd5[i] != null)
					model.setFmecccd5(fmecccd5[i]);
				if (statusType[i] != null)
					model.setStatusType(statusType[i]);
				if (atfmplnyr5[i] != null)
					model.setAtfmplnyr5(atfmplnyr5[i]);
				if (atecccd5[i] != null)
					model.setAtecccd5(atecccd5[i]);
				if (fmtypeby5[i] != null)
					model.setFmtypeby5(fmtypeby5[i]);
				if (totype5[i] != null)
					model.setTotype5(totype5[i]);
				if (cntrtpszcd5[i] != null)
					model.setCntrtpszcd5(cntrtpszcd5[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (totypeby5[i] != null)
					model.setTotypeby5(totypeby5[i]);
				if (fmtype5[i] != null)
					model.setFmtype5(fmtype5[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmtoat5[i] != null)
					model.setFmtoat5(fmtoat5[i]);
				if (fmfmplnwk5[i] != null)
					model.setFmfmplnwk5(fmfmplnwk5[i]);
				if (repoRmk[i] != null)
					model.setRepoRmk(repoRmk[i]);
				if (totoplnwk5[i] != null)
					model.setTotoplnwk5(totoplnwk5[i]);
				if (tofmplnyr5[i] != null)
					model.setTofmplnyr5(tofmplnyr5[i]);
				if (lane5[i] != null)
					model.setLane5(lane5[i]);
				if (scnrId[i] != null)
					model.setScnrId(scnrId[i]);
				if (fmtoplnyr5[i] != null)
					model.setFmtoplnyr5(fmtoplnyr5[i]);
				if (totoplnyr5[i] != null)
					model.setTotoplnyr5(totoplnyr5[i]);
				if (attoplnwk5[i] != null)
					model.setAttoplnwk5(attoplnwk5[i]);
				if (tpszall[i] != null)
					model.setTpszall(tpszall[i]);
				if (attype5[i] != null)
					model.setAttype5(attype5[i]);
				if (toecccd5[i] != null)
					model.setToecccd5(toecccd5[i]);
				if (repoPlnId[i] != null)
					model.setRepoPlnId(repoPlnId[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (vvd5[i] != null)
					model.setVvd5(vvd5[i]);
				if (fmtoplnwk5[i] != null)
					model.setFmtoplnwk5(fmtoplnwk5[i]);
				if (item5[i] != null)
					model.setItem5(item5[i]);
				if (rlatype5[i] != null)
					model.setRlatype5(rlatype5[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (tofmplnwk5[i] != null)
					model.setTofmplnwk5(tofmplnwk5[i]);
				if (fmfmplnyr5[i] != null)
					model.setFmfmplnyr5(fmfmplnyr5[i]);
				if (attoplnyr5[i] != null)
					model.setAttoplnyr5(attoplnyr5[i]);
				if (atfmplnwk5[i] != null)
					model.setAtfmplnwk5(atfmplnwk5[i]);
				if (attypeby5[i] != null)
					model.setAttypeby5(attypeby5[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0048ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0048ConditionVO[]
	 */
	public EesEqr0048ConditionVO[] getEesEqr0048ConditionVOs(){
		EesEqr0048ConditionVO[] vos = (EesEqr0048ConditionVO[])models.toArray(new EesEqr0048ConditionVO[models.size()]);
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
		this.fmecccd5 = this.fmecccd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusType = this.statusType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfmplnyr5 = this.atfmplnyr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atecccd5 = this.atecccd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtypeby5 = this.fmtypeby5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totype5 = this.totype5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd5 = this.cntrtpszcd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totypeby5 = this.totypeby5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtype5 = this.fmtype5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoat5 = this.fmtoat5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmfmplnwk5 = this.fmfmplnwk5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoRmk = this.repoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totoplnwk5 = this.totoplnwk5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tofmplnyr5 = this.tofmplnyr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane5 = this.lane5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId = this.scnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoplnyr5 = this.fmtoplnyr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totoplnyr5 = this.totoplnyr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attoplnwk5 = this.attoplnwk5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszall = this.tpszall .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attype5 = this.attype5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toecccd5 = this.toecccd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId = this.repoPlnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd5 = this.vvd5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoplnwk5 = this.fmtoplnwk5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item5 = this.item5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlatype5 = this.rlatype5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tofmplnwk5 = this.tofmplnwk5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmfmplnyr5 = this.fmfmplnyr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attoplnyr5 = this.attoplnyr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfmplnwk5 = this.atfmplnwk5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attypeby5 = this.attypeby5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
