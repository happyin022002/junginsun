/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0070ConditionVO.java
*@FileTitle : EesEqr0070ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.10.19 채창호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.vo;

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
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0070ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0070ConditionVO> models = new ArrayList<EesEqr0070ConditionVO>();
	
	/* Column Info */
	private String totoplnmn = null;
	/* Column Info */
	private String fmtoplnmn = null;
	/* Column Info */
	private String matched = null;
	/* Column Info */
	private String toplnwk = null;
	/* Column Info */
	private String atfmplnmn = null;
	/* Column Info */
	private String attypeby = null;
	/* Column Info */
	private String fmtypeby = null;
	/* Column Info */
	private String cntrtpszcd = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmecccd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String compared = null;
	/* Column Info */
	private String toplnyr = null;
	/* Column Info */
	private String fmplnmn = null;
	/* Column Info */
	private String totoplnwk = null;
	/* Column Info */
	private String toplnmn = null;
	/* Column Info */
	private String attoplnmn = null;
	/* Column Info */
	private String atfmplnyr = null;
	/* Column Info */
	private String atecccd = null;
	/* Column Info */
	private String toecccd = null;
	/* Column Info */
	private String fmtoplnwk = null;
	/* Column Info */
	private String fmtype = null;
	/* Column Info */
	private String totoplnyr = null;
	/* Column Info */
	private String fmtoplnyr = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String attype = null;
	/* Column Info */
	private String planid = null;
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String attoplnwk = null;
	/* Column Info */
	private String atfmplnwk = null;
	/* Column Info */
	private String fmplnyr = null;
	/* Column Info */
	private String attoplnyr = null;
	/* Column Info */
	private String fmtoat = null;
	/* Column Info */
	private String totype = null;
	/* Column Info */
	private String totypeby = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String statustype = null;
	/* Column Info */
	private String oddtype = null;
	/* Column Info */
	private String fmplnwk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0070ConditionVO() {}

	public EesEqr0070ConditionVO(String ibflag, String pagerows, String yyyyww, String seq, String statustype, String compared, String matched, String planid, String fmtoat, String fmtype, String fmtypeby, String fmecccd, String fmplnyr, String fmplnmn, String fmplnwk, String toplnyr, String toplnmn, String toplnwk, String fmtoplnyr, String fmtoplnmn, String fmtoplnwk, String totoplnyr, String totoplnmn, String totoplnwk, String totype, String toecccd, String totypeby, String attype, String atecccd, String attypeby, String atfmplnyr, String atfmplnmn, String atfmplnwk, String attoplnyr, String attoplnmn, String attoplnwk, String cntrtpszcd, String oddtype, String item, String lane, String vvd) {
		this.totoplnmn = totoplnmn;
		this.fmtoplnmn = fmtoplnmn;
		this.matched = matched;
		this.toplnwk = toplnwk;
		this.atfmplnmn = atfmplnmn;
		this.attypeby = attypeby;
		this.fmtypeby = fmtypeby;
		this.cntrtpszcd = cntrtpszcd;
		this.lane = lane;
		this.pagerows = pagerows;
		this.fmecccd = fmecccd;
		this.ibflag = ibflag;
		this.compared = compared;
		this.toplnyr = toplnyr;
		this.fmplnmn = fmplnmn;
		this.totoplnwk = totoplnwk;
		this.toplnmn = toplnmn;
		this.attoplnmn = attoplnmn;
		this.atfmplnyr = atfmplnyr;
		this.atecccd = atecccd;
		this.toecccd = toecccd;
		this.fmtoplnwk = fmtoplnwk;
		this.fmtype = fmtype;
		this.totoplnyr = totoplnyr;
		this.fmtoplnyr = fmtoplnyr;
		this.vvd = vvd;
		this.attype = attype;
		this.planid = planid;
		this.yyyyww = yyyyww;
		this.attoplnwk = attoplnwk;
		this.atfmplnwk = atfmplnwk;
		this.fmplnyr = fmplnyr;
		this.attoplnyr = attoplnyr;
		this.fmtoat = fmtoat;
		this.totype = totype;
		this.totypeby = totypeby;
		this.item = item;
		this.seq = seq;
		this.statustype = statustype;
		this.oddtype = oddtype;
		this.fmplnwk = fmplnwk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("totoplnmn", getTotoplnmn());
		this.hashColumns.put("fmtoplnmn", getFmtoplnmn());
		this.hashColumns.put("matched", getMatched());
		this.hashColumns.put("toplnwk", getToplnwk());
		this.hashColumns.put("atfmplnmn", getAtfmplnmn());
		this.hashColumns.put("attypeby", getAttypeby());
		this.hashColumns.put("fmtypeby", getFmtypeby());
		this.hashColumns.put("cntrtpszcd", getCntrtpszcd());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fmecccd", getFmecccd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("compared", getCompared());
		this.hashColumns.put("toplnyr", getToplnyr());
		this.hashColumns.put("fmplnmn", getFmplnmn());
		this.hashColumns.put("totoplnwk", getTotoplnwk());
		this.hashColumns.put("toplnmn", getToplnmn());
		this.hashColumns.put("attoplnmn", getAttoplnmn());
		this.hashColumns.put("atfmplnyr", getAtfmplnyr());
		this.hashColumns.put("atecccd", getAtecccd());
		this.hashColumns.put("toecccd", getToecccd());
		this.hashColumns.put("fmtoplnwk", getFmtoplnwk());
		this.hashColumns.put("fmtype", getFmtype());
		this.hashColumns.put("totoplnyr", getTotoplnyr());
		this.hashColumns.put("fmtoplnyr", getFmtoplnyr());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("attype", getAttype());
		this.hashColumns.put("planid", getPlanid());
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("attoplnwk", getAttoplnwk());
		this.hashColumns.put("atfmplnwk", getAtfmplnwk());
		this.hashColumns.put("fmplnyr", getFmplnyr());
		this.hashColumns.put("attoplnyr", getAttoplnyr());
		this.hashColumns.put("fmtoat", getFmtoat());
		this.hashColumns.put("totype", getTotype());
		this.hashColumns.put("totypeby", getTotypeby());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("statustype", getStatustype());
		this.hashColumns.put("oddtype", getOddtype());
		this.hashColumns.put("fmplnwk", getFmplnwk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("totoplnmn", "totoplnmn");
		this.hashFields.put("fmtoplnmn", "fmtoplnmn");
		this.hashFields.put("matched", "matched");
		this.hashFields.put("toplnwk", "toplnwk");
		this.hashFields.put("atfmplnmn", "atfmplnmn");
		this.hashFields.put("attypeby", "attypeby");
		this.hashFields.put("fmtypeby", "fmtypeby");
		this.hashFields.put("cntrtpszcd", "cntrtpszcd");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fmecccd", "fmecccd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("compared", "compared");
		this.hashFields.put("toplnyr", "toplnyr");
		this.hashFields.put("fmplnmn", "fmplnmn");
		this.hashFields.put("totoplnwk", "totoplnwk");
		this.hashFields.put("toplnmn", "toplnmn");
		this.hashFields.put("attoplnmn", "attoplnmn");
		this.hashFields.put("atfmplnyr", "atfmplnyr");
		this.hashFields.put("atecccd", "atecccd");
		this.hashFields.put("toecccd", "toecccd");
		this.hashFields.put("fmtoplnwk", "fmtoplnwk");
		this.hashFields.put("fmtype", "fmtype");
		this.hashFields.put("totoplnyr", "totoplnyr");
		this.hashFields.put("fmtoplnyr", "fmtoplnyr");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("attype", "attype");
		this.hashFields.put("planid", "planid");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("attoplnwk", "attoplnwk");
		this.hashFields.put("atfmplnwk", "atfmplnwk");
		this.hashFields.put("fmplnyr", "fmplnyr");
		this.hashFields.put("attoplnyr", "attoplnyr");
		this.hashFields.put("fmtoat", "fmtoat");
		this.hashFields.put("totype", "totype");
		this.hashFields.put("totypeby", "totypeby");
		this.hashFields.put("item", "item");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("statustype", "statustype");
		this.hashFields.put("oddtype", "oddtype");
		this.hashFields.put("fmplnwk", "fmplnwk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return totoplnmn
	 */
	public String getTotoplnmn() {
		return this.totoplnmn;
	}
	
	/**
	 * Column Info
	 * @return fmtoplnmn
	 */
	public String getFmtoplnmn() {
		return this.fmtoplnmn;
	}
	
	/**
	 * Column Info
	 * @return matched
	 */
	public String getMatched() {
		return this.matched;
	}
	
	/**
	 * Column Info
	 * @return toplnwk
	 */
	public String getToplnwk() {
		return this.toplnwk;
	}
	
	/**
	 * Column Info
	 * @return atfmplnmn
	 */
	public String getAtfmplnmn() {
		return this.atfmplnmn;
	}
	
	/**
	 * Column Info
	 * @return attypeby
	 */
	public String getAttypeby() {
		return this.attypeby;
	}
	
	/**
	 * Column Info
	 * @return fmtypeby
	 */
	public String getFmtypeby() {
		return this.fmtypeby;
	}
	
	/**
	 * Column Info
	 * @return cntrtpszcd
	 */
	public String getCntrtpszcd() {
		return this.cntrtpszcd;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return fmecccd
	 */
	public String getFmecccd() {
		return this.fmecccd;
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
	 * @return compared
	 */
	public String getCompared() {
		return this.compared;
	}
	
	/**
	 * Column Info
	 * @return toplnyr
	 */
	public String getToplnyr() {
		return this.toplnyr;
	}
	
	/**
	 * Column Info
	 * @return fmplnmn
	 */
	public String getFmplnmn() {
		return this.fmplnmn;
	}
	
	/**
	 * Column Info
	 * @return totoplnwk
	 */
	public String getTotoplnwk() {
		return this.totoplnwk;
	}
	
	/**
	 * Column Info
	 * @return toplnmn
	 */
	public String getToplnmn() {
		return this.toplnmn;
	}
	
	/**
	 * Column Info
	 * @return attoplnmn
	 */
	public String getAttoplnmn() {
		return this.attoplnmn;
	}
	
	/**
	 * Column Info
	 * @return atfmplnyr
	 */
	public String getAtfmplnyr() {
		return this.atfmplnyr;
	}
	
	/**
	 * Column Info
	 * @return atecccd
	 */
	public String getAtecccd() {
		return this.atecccd;
	}
	
	/**
	 * Column Info
	 * @return toecccd
	 */
	public String getToecccd() {
		return this.toecccd;
	}
	
	/**
	 * Column Info
	 * @return fmtoplnwk
	 */
	public String getFmtoplnwk() {
		return this.fmtoplnwk;
	}
	
	/**
	 * Column Info
	 * @return fmtype
	 */
	public String getFmtype() {
		return this.fmtype;
	}
	
	/**
	 * Column Info
	 * @return totoplnyr
	 */
	public String getTotoplnyr() {
		return this.totoplnyr;
	}
	
	/**
	 * Column Info
	 * @return fmtoplnyr
	 */
	public String getFmtoplnyr() {
		return this.fmtoplnyr;
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
	 * @return attype
	 */
	public String getAttype() {
		return this.attype;
	}
	
	/**
	 * Column Info
	 * @return planid
	 */
	public String getPlanid() {
		return this.planid;
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
	 * @return attoplnwk
	 */
	public String getAttoplnwk() {
		return this.attoplnwk;
	}
	
	/**
	 * Column Info
	 * @return atfmplnwk
	 */
	public String getAtfmplnwk() {
		return this.atfmplnwk;
	}
	
	/**
	 * Column Info
	 * @return fmplnyr
	 */
	public String getFmplnyr() {
		return this.fmplnyr;
	}
	
	/**
	 * Column Info
	 * @return attoplnyr
	 */
	public String getAttoplnyr() {
		return this.attoplnyr;
	}
	
	/**
	 * Column Info
	 * @return fmtoat
	 */
	public String getFmtoat() {
		return this.fmtoat;
	}
	
	/**
	 * Column Info
	 * @return totype
	 */
	public String getTotype() {
		return this.totype;
	}
	
	/**
	 * Column Info
	 * @return totypeby
	 */
	public String getTotypeby() {
		return this.totypeby;
	}
	
	/**
	 * Column Info
	 * @return item
	 */
	public String getItem() {
		return this.item;
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
	 * @return statustype
	 */
	public String getStatustype() {
		return this.statustype;
	}
	
	/**
	 * Column Info
	 * @return oddtype
	 */
	public String getOddtype() {
		return this.oddtype;
	}
	
	/**
	 * Column Info
	 * @return fmplnwk
	 */
	public String getFmplnwk() {
		return this.fmplnwk;
	}
	

	/**
	 * Column Info
	 * @param totoplnmn
	 */
	public void setTotoplnmn(String totoplnmn) {
		this.totoplnmn = totoplnmn;
	}
	
	/**
	 * Column Info
	 * @param fmtoplnmn
	 */
	public void setFmtoplnmn(String fmtoplnmn) {
		this.fmtoplnmn = fmtoplnmn;
	}
	
	/**
	 * Column Info
	 * @param matched
	 */
	public void setMatched(String matched) {
		this.matched = matched;
	}
	
	/**
	 * Column Info
	 * @param toplnwk
	 */
	public void setToplnwk(String toplnwk) {
		this.toplnwk = toplnwk;
	}
	
	/**
	 * Column Info
	 * @param atfmplnmn
	 */
	public void setAtfmplnmn(String atfmplnmn) {
		this.atfmplnmn = atfmplnmn;
	}
	
	/**
	 * Column Info
	 * @param attypeby
	 */
	public void setAttypeby(String attypeby) {
		this.attypeby = attypeby;
	}
	
	/**
	 * Column Info
	 * @param fmtypeby
	 */
	public void setFmtypeby(String fmtypeby) {
		this.fmtypeby = fmtypeby;
	}
	
	/**
	 * Column Info
	 * @param cntrtpszcd
	 */
	public void setCntrtpszcd(String cntrtpszcd) {
		this.cntrtpszcd = cntrtpszcd;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param fmecccd
	 */
	public void setFmecccd(String fmecccd) {
		this.fmecccd = fmecccd;
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
	 * @param compared
	 */
	public void setCompared(String compared) {
		this.compared = compared;
	}
	
	/**
	 * Column Info
	 * @param toplnyr
	 */
	public void setToplnyr(String toplnyr) {
		this.toplnyr = toplnyr;
	}
	
	/**
	 * Column Info
	 * @param fmplnmn
	 */
	public void setFmplnmn(String fmplnmn) {
		this.fmplnmn = fmplnmn;
	}
	
	/**
	 * Column Info
	 * @param totoplnwk
	 */
	public void setTotoplnwk(String totoplnwk) {
		this.totoplnwk = totoplnwk;
	}
	
	/**
	 * Column Info
	 * @param toplnmn
	 */
	public void setToplnmn(String toplnmn) {
		this.toplnmn = toplnmn;
	}
	
	/**
	 * Column Info
	 * @param attoplnmn
	 */
	public void setAttoplnmn(String attoplnmn) {
		this.attoplnmn = attoplnmn;
	}
	
	/**
	 * Column Info
	 * @param atfmplnyr
	 */
	public void setAtfmplnyr(String atfmplnyr) {
		this.atfmplnyr = atfmplnyr;
	}
	
	/**
	 * Column Info
	 * @param atecccd
	 */
	public void setAtecccd(String atecccd) {
		this.atecccd = atecccd;
	}
	
	/**
	 * Column Info
	 * @param toecccd
	 */
	public void setToecccd(String toecccd) {
		this.toecccd = toecccd;
	}
	
	/**
	 * Column Info
	 * @param fmtoplnwk
	 */
	public void setFmtoplnwk(String fmtoplnwk) {
		this.fmtoplnwk = fmtoplnwk;
	}
	
	/**
	 * Column Info
	 * @param fmtype
	 */
	public void setFmtype(String fmtype) {
		this.fmtype = fmtype;
	}
	
	/**
	 * Column Info
	 * @param totoplnyr
	 */
	public void setTotoplnyr(String totoplnyr) {
		this.totoplnyr = totoplnyr;
	}
	
	/**
	 * Column Info
	 * @param fmtoplnyr
	 */
	public void setFmtoplnyr(String fmtoplnyr) {
		this.fmtoplnyr = fmtoplnyr;
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
	 * @param attype
	 */
	public void setAttype(String attype) {
		this.attype = attype;
	}
	
	/**
	 * Column Info
	 * @param planid
	 */
	public void setPlanid(String planid) {
		this.planid = planid;
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
	 * @param attoplnwk
	 */
	public void setAttoplnwk(String attoplnwk) {
		this.attoplnwk = attoplnwk;
	}
	
	/**
	 * Column Info
	 * @param atfmplnwk
	 */
	public void setAtfmplnwk(String atfmplnwk) {
		this.atfmplnwk = atfmplnwk;
	}
	
	/**
	 * Column Info
	 * @param fmplnyr
	 */
	public void setFmplnyr(String fmplnyr) {
		this.fmplnyr = fmplnyr;
	}
	
	/**
	 * Column Info
	 * @param attoplnyr
	 */
	public void setAttoplnyr(String attoplnyr) {
		this.attoplnyr = attoplnyr;
	}
	
	/**
	 * Column Info
	 * @param fmtoat
	 */
	public void setFmtoat(String fmtoat) {
		this.fmtoat = fmtoat;
	}
	
	/**
	 * Column Info
	 * @param totype
	 */
	public void setTotype(String totype) {
		this.totype = totype;
	}
	
	/**
	 * Column Info
	 * @param totypeby
	 */
	public void setTotypeby(String totypeby) {
		this.totypeby = totypeby;
	}
	
	/**
	 * Column Info
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
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
	 * @param statustype
	 */
	public void setStatustype(String statustype) {
		this.statustype = statustype;
	}
	
	/**
	 * Column Info
	 * @param oddtype
	 */
	public void setOddtype(String oddtype) {
		this.oddtype = oddtype;
	}
	
	/**
	 * Column Info
	 * @param fmplnwk
	 */
	public void setFmplnwk(String fmplnwk) {
		this.fmplnwk = fmplnwk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotoplnmn(JSPUtil.getParameter(request, "totoplnmn", ""));
		setFmtoplnmn(JSPUtil.getParameter(request, "fmtoplnmn", ""));
		setMatched(JSPUtil.getParameter(request, "matched", ""));
		setToplnwk(JSPUtil.getParameter(request, "toplnwk", ""));
		setAtfmplnmn(JSPUtil.getParameter(request, "atfmplnmn", ""));
		setAttypeby(JSPUtil.getParameter(request, "attypeby", ""));
		setFmtypeby(JSPUtil.getParameter(request, "fmtypeby", ""));
		setCntrtpszcd(JSPUtil.getParameter(request, "cntrtpszcd", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFmecccd(JSPUtil.getParameter(request, "fmecccd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCompared(JSPUtil.getParameter(request, "compared", ""));
		setToplnyr(JSPUtil.getParameter(request, "toplnyr", ""));
		setFmplnmn(JSPUtil.getParameter(request, "fmplnmn", ""));
		setTotoplnwk(JSPUtil.getParameter(request, "totoplnwk", ""));
		setToplnmn(JSPUtil.getParameter(request, "toplnmn", ""));
		setAttoplnmn(JSPUtil.getParameter(request, "attoplnmn", ""));
		setAtfmplnyr(JSPUtil.getParameter(request, "atfmplnyr", ""));
		setAtecccd(JSPUtil.getParameter(request, "atecccd", ""));
		setToecccd(JSPUtil.getParameter(request, "toecccd", ""));
		setFmtoplnwk(JSPUtil.getParameter(request, "fmtoplnwk", ""));
		setFmtype(JSPUtil.getParameter(request, "fmtype", ""));
		setTotoplnyr(JSPUtil.getParameter(request, "totoplnyr", ""));
		setFmtoplnyr(JSPUtil.getParameter(request, "fmtoplnyr", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setAttype(JSPUtil.getParameter(request, "attype", ""));
		setPlanid(JSPUtil.getParameter(request, "planid", ""));
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setAttoplnwk(JSPUtil.getParameter(request, "attoplnwk", ""));
		setAtfmplnwk(JSPUtil.getParameter(request, "atfmplnwk", ""));
		setFmplnyr(JSPUtil.getParameter(request, "fmplnyr", ""));
		setAttoplnyr(JSPUtil.getParameter(request, "attoplnyr", ""));
		setFmtoat(JSPUtil.getParameter(request, "fmtoat", ""));
		setTotype(JSPUtil.getParameter(request, "totype", ""));
		setTotypeby(JSPUtil.getParameter(request, "totypeby", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setStatustype(JSPUtil.getParameter(request, "statustype", ""));
		setOddtype(JSPUtil.getParameter(request, "oddtype", ""));
		setFmplnwk(JSPUtil.getParameter(request, "fmplnwk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0070ConditionVO[]
	 */
	public EesEqr0070ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0070ConditionVO[]
	 */
	public EesEqr0070ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0070ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] totoplnmn = (JSPUtil.getParameter(request, prefix	+ "totoplnmn", length));
			String[] fmtoplnmn = (JSPUtil.getParameter(request, prefix	+ "fmtoplnmn", length));
			String[] matched = (JSPUtil.getParameter(request, prefix	+ "matched", length));
			String[] toplnwk = (JSPUtil.getParameter(request, prefix	+ "toplnwk", length));
			String[] atfmplnmn = (JSPUtil.getParameter(request, prefix	+ "atfmplnmn", length));
			String[] attypeby = (JSPUtil.getParameter(request, prefix	+ "attypeby", length));
			String[] fmtypeby = (JSPUtil.getParameter(request, prefix	+ "fmtypeby", length));
			String[] cntrtpszcd = (JSPUtil.getParameter(request, prefix	+ "cntrtpszcd", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmecccd = (JSPUtil.getParameter(request, prefix	+ "fmecccd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] compared = (JSPUtil.getParameter(request, prefix	+ "compared", length));
			String[] toplnyr = (JSPUtil.getParameter(request, prefix	+ "toplnyr", length));
			String[] fmplnmn = (JSPUtil.getParameter(request, prefix	+ "fmplnmn", length));
			String[] totoplnwk = (JSPUtil.getParameter(request, prefix	+ "totoplnwk", length));
			String[] toplnmn = (JSPUtil.getParameter(request, prefix	+ "toplnmn", length));
			String[] attoplnmn = (JSPUtil.getParameter(request, prefix	+ "attoplnmn", length));
			String[] atfmplnyr = (JSPUtil.getParameter(request, prefix	+ "atfmplnyr", length));
			String[] atecccd = (JSPUtil.getParameter(request, prefix	+ "atecccd", length));
			String[] toecccd = (JSPUtil.getParameter(request, prefix	+ "toecccd", length));
			String[] fmtoplnwk = (JSPUtil.getParameter(request, prefix	+ "fmtoplnwk", length));
			String[] fmtype = (JSPUtil.getParameter(request, prefix	+ "fmtype", length));
			String[] totoplnyr = (JSPUtil.getParameter(request, prefix	+ "totoplnyr", length));
			String[] fmtoplnyr = (JSPUtil.getParameter(request, prefix	+ "fmtoplnyr", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] attype = (JSPUtil.getParameter(request, prefix	+ "attype", length));
			String[] planid = (JSPUtil.getParameter(request, prefix	+ "planid", length));
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] attoplnwk = (JSPUtil.getParameter(request, prefix	+ "attoplnwk", length));
			String[] atfmplnwk = (JSPUtil.getParameter(request, prefix	+ "atfmplnwk", length));
			String[] fmplnyr = (JSPUtil.getParameter(request, prefix	+ "fmplnyr", length));
			String[] attoplnyr = (JSPUtil.getParameter(request, prefix	+ "attoplnyr", length));
			String[] fmtoat = (JSPUtil.getParameter(request, prefix	+ "fmtoat", length));
			String[] totype = (JSPUtil.getParameter(request, prefix	+ "totype", length));
			String[] totypeby = (JSPUtil.getParameter(request, prefix	+ "totypeby", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] statustype = (JSPUtil.getParameter(request, prefix	+ "statustype", length));
			String[] oddtype = (JSPUtil.getParameter(request, prefix	+ "oddtype", length));
			String[] fmplnwk = (JSPUtil.getParameter(request, prefix	+ "fmplnwk", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0070ConditionVO();
				if (totoplnmn[i] != null)
					model.setTotoplnmn(totoplnmn[i]);
				if (fmtoplnmn[i] != null)
					model.setFmtoplnmn(fmtoplnmn[i]);
				if (matched[i] != null)
					model.setMatched(matched[i]);
				if (toplnwk[i] != null)
					model.setToplnwk(toplnwk[i]);
				if (atfmplnmn[i] != null)
					model.setAtfmplnmn(atfmplnmn[i]);
				if (attypeby[i] != null)
					model.setAttypeby(attypeby[i]);
				if (fmtypeby[i] != null)
					model.setFmtypeby(fmtypeby[i]);
				if (cntrtpszcd[i] != null)
					model.setCntrtpszcd(cntrtpszcd[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmecccd[i] != null)
					model.setFmecccd(fmecccd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (compared[i] != null)
					model.setCompared(compared[i]);
				if (toplnyr[i] != null)
					model.setToplnyr(toplnyr[i]);
				if (fmplnmn[i] != null)
					model.setFmplnmn(fmplnmn[i]);
				if (totoplnwk[i] != null)
					model.setTotoplnwk(totoplnwk[i]);
				if (toplnmn[i] != null)
					model.setToplnmn(toplnmn[i]);
				if (attoplnmn[i] != null)
					model.setAttoplnmn(attoplnmn[i]);
				if (atfmplnyr[i] != null)
					model.setAtfmplnyr(atfmplnyr[i]);
				if (atecccd[i] != null)
					model.setAtecccd(atecccd[i]);
				if (toecccd[i] != null)
					model.setToecccd(toecccd[i]);
				if (fmtoplnwk[i] != null)
					model.setFmtoplnwk(fmtoplnwk[i]);
				if (fmtype[i] != null)
					model.setFmtype(fmtype[i]);
				if (totoplnyr[i] != null)
					model.setTotoplnyr(totoplnyr[i]);
				if (fmtoplnyr[i] != null)
					model.setFmtoplnyr(fmtoplnyr[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (attype[i] != null)
					model.setAttype(attype[i]);
				if (planid[i] != null)
					model.setPlanid(planid[i]);
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (attoplnwk[i] != null)
					model.setAttoplnwk(attoplnwk[i]);
				if (atfmplnwk[i] != null)
					model.setAtfmplnwk(atfmplnwk[i]);
				if (fmplnyr[i] != null)
					model.setFmplnyr(fmplnyr[i]);
				if (attoplnyr[i] != null)
					model.setAttoplnyr(attoplnyr[i]);
				if (fmtoat[i] != null)
					model.setFmtoat(fmtoat[i]);
				if (totype[i] != null)
					model.setTotype(totype[i]);
				if (totypeby[i] != null)
					model.setTotypeby(totypeby[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (statustype[i] != null)
					model.setStatustype(statustype[i]);
				if (oddtype[i] != null)
					model.setOddtype(oddtype[i]);
				if (fmplnwk[i] != null)
					model.setFmplnwk(fmplnwk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0070ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0070ConditionVO[]
	 */
	public EesEqr0070ConditionVO[] getEesEqr0070ConditionVOs(){
		EesEqr0070ConditionVO[] vos = (EesEqr0070ConditionVO[])models.toArray(new EesEqr0070ConditionVO[models.size()]);
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
		this.totoplnmn = this.totoplnmn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoplnmn = this.fmtoplnmn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matched = this.matched .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnwk = this.toplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfmplnmn = this.atfmplnmn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attypeby = this.attypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtypeby = this.fmtypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd = this.cntrtpszcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmecccd = this.fmecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compared = this.compared .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnyr = this.toplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnmn = this.fmplnmn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totoplnwk = this.totoplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnmn = this.toplnmn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attoplnmn = this.attoplnmn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfmplnyr = this.atfmplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atecccd = this.atecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toecccd = this.toecccd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoplnwk = this.fmtoplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtype = this.fmtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totoplnyr = this.totoplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoplnyr = this.fmtoplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attype = this.attype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.planid = this.planid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attoplnwk = this.attoplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfmplnwk = this.atfmplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnyr = this.fmplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attoplnyr = this.attoplnyr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoat = this.fmtoat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totype = this.totype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totypeby = this.totypeby .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statustype = this.statustype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oddtype = this.oddtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnwk = this.fmplnwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
