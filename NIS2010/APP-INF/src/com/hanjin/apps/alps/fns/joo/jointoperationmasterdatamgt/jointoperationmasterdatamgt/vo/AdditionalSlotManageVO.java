/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AdditionalSlotManageVO.java
*@FileTitle : AdditionalSlotManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AdditionalSlotManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AdditionalSlotManageVO> models = new ArrayList<AdditionalSlotManageVO>();
	
	/* Column Info */
	private String legFport = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String legTport = null;
	/* Column Info */
	private String stlFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String ousQty = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String creDtTo = null;
	/* Column Info */
	private String joN2ndCrrCd = null;
	/* Column Info */
	private String relOfcCd = null;
	/* Column Info */
	private String revDivr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String joN1stCrrCd = null;
	/* Column Info */
	private String joBsa = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dateDt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String controlCd = null;
	/* Column Info */
	private String joRemark = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String attachFlg = null;
	/* Column Info */
	private String settleDt = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String joPrice = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String delChk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String acctgCrrCd = null;
	/* Column Info */
	private String term = null;
	/* Column Info */
	private String joWeight = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String creDtFr = null;
	/* Column Info */
	private String atchFileId = null;
	
	private String picUsrId = null;
	
	private String picUsrNm = null;
	
	private String creDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AdditionalSlotManageVO() {}

	public AdditionalSlotManageVO(String ibflag, String pagerows, String delChk, String ofcCd, String relOfcCd, String revDivr, String term, String acctgCrrCd, String dateDt, String trdCd, String rlaneCd, String joN1stCrrCd, String joN2ndCrrCd, String vvdCd, String legFport, String legTport, String joBsa, String joWeight, String joPrice, String joRemark, String settleDt, String ousQty, String attachFlg, String deltFlg, String joCrrCd, String reDivrCd, String creDtFr, String creDtTo, String vslCd, String skdVoyNo, String skdDirCd, String controlCd, String agmtSeq, String stlFlg, String creUsrId, String updUsrId, String atchFileId, String picUsrId, String picUsrNm, String creDt) {
		this.legFport = legFport;
		this.vslCd = vslCd;
		this.legTport = legTport;
		this.stlFlg = stlFlg;
		this.deltFlg = deltFlg;
		this.ousQty = ousQty;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.creDtTo = creDtTo;
		this.joN2ndCrrCd = joN2ndCrrCd;
		this.relOfcCd = relOfcCd;
		this.revDivr = revDivr;
		this.pagerows = pagerows;
		this.joN1stCrrCd = joN1stCrrCd;
		this.joBsa = joBsa;
		this.ibflag = ibflag;
		this.dateDt = dateDt;
		this.vvdCd = vvdCd;
		this.controlCd = controlCd;
		this.joRemark = joRemark;
		this.updUsrId = updUsrId;
		this.attachFlg = attachFlg;
		this.settleDt = settleDt;
		this.agmtSeq = agmtSeq;
		this.skdVoyNo = skdVoyNo;
		this.joCrrCd = joCrrCd;
		this.skdDirCd = skdDirCd;
		this.joPrice = joPrice;
		this.ofcCd = ofcCd;
		this.delChk = delChk;
		this.creUsrId = creUsrId;
		this.acctgCrrCd = acctgCrrCd;
		this.term = term;
		this.joWeight = joWeight;
		this.reDivrCd = reDivrCd;
		this.creDtFr = creDtFr;
		this.atchFileId = atchFileId;
		this.picUsrId = picUsrId;
		this.picUsrNm = picUsrNm;
		this.creDt = creDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("leg_fport", getLegFport());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("leg_tport", getLegTport());
		this.hashColumns.put("stl_flg", getStlFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("ous_qty", getOusQty());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("cre_dt_to", getCreDtTo());
		this.hashColumns.put("jo_n2nd_crr_cd", getJoN2ndCrrCd());
		this.hashColumns.put("rel_ofc_cd", getRelOfcCd());
		this.hashColumns.put("rev_divr", getRevDivr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("jo_n1st_crr_cd", getJoN1stCrrCd());
		this.hashColumns.put("jo_bsa", getJoBsa());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("date_dt", getDateDt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("control_cd", getControlCd());
		this.hashColumns.put("jo_remark", getJoRemark());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("attach_flg", getAttachFlg());
		this.hashColumns.put("settle_dt", getSettleDt());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("jo_price", getJoPrice());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("acctg_crr_cd", getAcctgCrrCd());
		this.hashColumns.put("term", getTerm());
		this.hashColumns.put("jo_weight", getJoWeight());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("cre_dt_fr", getCreDtFr());
		this.hashColumns.put("atch_file_id", getAtchFileId());
		this.hashColumns.put("pic_usr_id", getPicUsrId());
		this.hashColumns.put("pic_usr_nm", getPicUsrNm());
		this.hashColumns.put("cre_dt", getCreDt());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("leg_fport", "legFport");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("leg_tport", "legTport");
		this.hashFields.put("stl_flg", "stlFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("ous_qty", "ousQty");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("cre_dt_to", "creDtTo");
		this.hashFields.put("jo_n2nd_crr_cd", "joN2ndCrrCd");
		this.hashFields.put("rel_ofc_cd", "relOfcCd");
		this.hashFields.put("rev_divr", "revDivr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("jo_n1st_crr_cd", "joN1stCrrCd");
		this.hashFields.put("jo_bsa", "joBsa");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("date_dt", "dateDt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("control_cd", "controlCd");
		this.hashFields.put("jo_remark", "joRemark");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("attach_flg", "attachFlg");
		this.hashFields.put("settle_dt", "settleDt");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("jo_price", "joPrice");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("acctg_crr_cd", "acctgCrrCd");
		this.hashFields.put("term", "term");
		this.hashFields.put("jo_weight", "joWeight");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("cre_dt_fr", "creDtFr");
		this.hashFields.put("atch_file_id", "atchFileId");
		this.hashFields.put("pic_usr_id", "picUsrId");
		this.hashFields.put("pic_usr_nm", "picUsrNm");
		this.hashFields.put("cre_dt", "creDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return legFport
	 */
	public String getLegFport() {
		return this.legFport;
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
	 * @return legTport
	 */
	public String getLegTport() {
		return this.legTport;
	}
	
	/**
	 * Column Info
	 * @return stlFlg
	 */
	public String getStlFlg() {
		return this.stlFlg;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return ousQty
	 */
	public String getOusQty() {
		return this.ousQty;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return creDtTo
	 */
	public String getCreDtTo() {
		return this.creDtTo;
	}
	
	/**
	 * Column Info
	 * @return joN2ndCrrCd
	 */
	public String getJoN2ndCrrCd() {
		return this.joN2ndCrrCd;
	}
	
	/**
	 * Column Info
	 * @return relOfcCd
	 */
	public String getRelOfcCd() {
		return this.relOfcCd;
	}
	
	/**
	 * Column Info
	 * @return revDivr
	 */
	public String getRevDivr() {
		return this.revDivr;
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
	 * @return joN1stCrrCd
	 */
	public String getJoN1stCrrCd() {
		return this.joN1stCrrCd;
	}
	
	/**
	 * Column Info
	 * @return joBsa
	 */
	public String getJoBsa() {
		return this.joBsa;
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
	 * @return dateDt
	 */
	public String getDateDt() {
		return this.dateDt;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return controlCd
	 */
	public String getControlCd() {
		return this.controlCd;
	}
	
	/**
	 * Column Info
	 * @return joRemark
	 */
	public String getJoRemark() {
		return this.joRemark;
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
	 * @return attachFlg
	 */
	public String getAttachFlg() {
		return this.attachFlg;
	}
	
	/**
	 * Column Info
	 * @return settleDt
	 */
	public String getSettleDt() {
		return this.settleDt;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
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
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
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
	 * @return joPrice
	 */
	public String getJoPrice() {
		return this.joPrice;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return delChk
	 */
	public String getDelChk() {
		return this.delChk;
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
	 * @return acctgCrrCd
	 */
	public String getAcctgCrrCd() {
		return this.acctgCrrCd;
	}
	
	/**
	 * Column Info
	 * @return term
	 */
	public String getTerm() {
		return this.term;
	}
	
	/**
	 * Column Info
	 * @return joWeight
	 */
	public String getJoWeight() {
		return this.joWeight;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return creDtFr
	 */
	public String getCreDtFr() {
		return this.creDtFr;
	}
	
	/**
	 * Column Info
	 * @return atchFileId
	 */
	public String getAtchFileId() {
		return this.atchFileId;
	}
	

	/**
	 * Column Info
	 * @param legFport
	 */
	public void setLegFport(String legFport) {
		this.legFport = legFport;
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
	 * @param legTport
	 */
	public void setLegTport(String legTport) {
		this.legTport = legTport;
	}
	
	/**
	 * Column Info
	 * @param stlFlg
	 */
	public void setStlFlg(String stlFlg) {
		this.stlFlg = stlFlg;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param ousQty
	 */
	public void setOusQty(String ousQty) {
		this.ousQty = ousQty;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param creDtTo
	 */
	public void setCreDtTo(String creDtTo) {
		this.creDtTo = creDtTo;
	}
	
	/**
	 * Column Info
	 * @param joN2ndCrrCd
	 */
	public void setJoN2ndCrrCd(String joN2ndCrrCd) {
		this.joN2ndCrrCd = joN2ndCrrCd;
	}
	
	/**
	 * Column Info
	 * @param relOfcCd
	 */
	public void setRelOfcCd(String relOfcCd) {
		this.relOfcCd = relOfcCd;
	}
	
	/**
	 * Column Info
	 * @param revDivr
	 */
	public void setRevDivr(String revDivr) {
		this.revDivr = revDivr;
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
	 * @param joN1stCrrCd
	 */
	public void setJoN1stCrrCd(String joN1stCrrCd) {
		this.joN1stCrrCd = joN1stCrrCd;
	}
	
	/**
	 * Column Info
	 * @param joBsa
	 */
	public void setJoBsa(String joBsa) {
		this.joBsa = joBsa;
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
	 * @param dateDt
	 */
	public void setDateDt(String dateDt) {
		this.dateDt = dateDt;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param controlCd
	 */
	public void setControlCd(String controlCd) {
		this.controlCd = controlCd;
	}
	
	/**
	 * Column Info
	 * @param joRemark
	 */
	public void setJoRemark(String joRemark) {
		this.joRemark = joRemark;
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
	 * @param attachFlg
	 */
	public void setAttachFlg(String attachFlg) {
		this.attachFlg = attachFlg;
	}
	
	/**
	 * Column Info
	 * @param settleDt
	 */
	public void setSettleDt(String settleDt) {
		this.settleDt = settleDt;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
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
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
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
	 * @param joPrice
	 */
	public void setJoPrice(String joPrice) {
		this.joPrice = joPrice;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param delChk
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
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
	 * @param acctgCrrCd
	 */
	public void setAcctgCrrCd(String acctgCrrCd) {
		this.acctgCrrCd = acctgCrrCd;
	}
	
	/**
	 * Column Info
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term;
	}
	
	/**
	 * Column Info
	 * @param joWeight
	 */
	public void setJoWeight(String joWeight) {
		this.joWeight = joWeight;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param creDtFr
	 */
	public void setCreDtFr(String creDtFr) {
		this.creDtFr = creDtFr;
	}
	
	/**
	 * Column Info
	 * @param atchFileId
	 */
	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}
	
	/**
	 * Column Info
	 * @return picUsrId
	 */
	public String getPicUsrId() {
		return picUsrId;
	}
	/**
	 * Column Info
	 * @param picUsrId
	 */
	public void setPicUsrId(String picUsrId) {
		this.picUsrId = picUsrId;
	}
	/**
	 * Column Info
	 * @return picUsrNm
	 */
	public String getPicUsrNm() {
		return picUsrNm;
	}
	/**
	 * Column Info
	 * @param picUsrNm
	 */
	public void setPicUsrNm(String picUsrNm) {
		this.picUsrNm = picUsrNm;
	}
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return creDt;
	}
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setLegFport(JSPUtil.getParameter(request, prefix + "leg_fport", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setLegTport(JSPUtil.getParameter(request, prefix + "leg_tport", ""));
		setStlFlg(JSPUtil.getParameter(request, prefix + "stl_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setOusQty(JSPUtil.getParameter(request, prefix + "ous_qty", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setCreDtTo(JSPUtil.getParameter(request, prefix + "cre_dt_to", ""));
		setJoN2ndCrrCd(JSPUtil.getParameter(request, prefix + "jo_n2nd_crr_cd", ""));
		setRelOfcCd(JSPUtil.getParameter(request, prefix + "rel_ofc_cd", ""));
		setRevDivr(JSPUtil.getParameter(request, prefix + "rev_divr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setJoN1stCrrCd(JSPUtil.getParameter(request, prefix + "jo_n1st_crr_cd", ""));
		setJoBsa(JSPUtil.getParameter(request, prefix + "jo_bsa", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDateDt(JSPUtil.getParameter(request, prefix + "date_dt", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setControlCd(JSPUtil.getParameter(request, prefix + "control_cd", ""));
		setJoRemark(JSPUtil.getParameter(request, prefix + "jo_remark", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAttachFlg(JSPUtil.getParameter(request, prefix + "attach_flg", ""));
		setSettleDt(JSPUtil.getParameter(request, prefix + "settle_dt", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setJoPrice(JSPUtil.getParameter(request, prefix + "jo_price", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setDelChk(JSPUtil.getParameter(request, prefix + "del_chk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAcctgCrrCd(JSPUtil.getParameter(request, prefix + "acctg_crr_cd", ""));
		setTerm(JSPUtil.getParameter(request, prefix + "term", ""));
		setJoWeight(JSPUtil.getParameter(request, prefix + "jo_weight", ""));
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setCreDtFr(JSPUtil.getParameter(request, prefix + "cre_dt_fr", ""));
		setAtchFileId(JSPUtil.getParameter(request, prefix + "atch_file_id", ""));
		setPicUsrId(JSPUtil.getParameter(request, prefix + "pic_usr_id", ""));
		setPicUsrNm(JSPUtil.getParameter(request, prefix + "pic_usr_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdditionalSlotManageVO[]
	 */
	public AdditionalSlotManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AdditionalSlotManageVO[]
	 */
	public AdditionalSlotManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AdditionalSlotManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] legFport = (JSPUtil.getParameter(request, prefix	+ "leg_fport", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] legTport = (JSPUtil.getParameter(request, prefix	+ "leg_tport", length));
			String[] stlFlg = (JSPUtil.getParameter(request, prefix	+ "stl_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] ousQty = (JSPUtil.getParameter(request, prefix	+ "ous_qty", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] creDtTo = (JSPUtil.getParameter(request, prefix	+ "cre_dt_to", length));
			String[] joN2ndCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_n2nd_crr_cd", length));
			String[] relOfcCd = (JSPUtil.getParameter(request, prefix	+ "rel_ofc_cd", length));
			String[] revDivr = (JSPUtil.getParameter(request, prefix	+ "rev_divr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] joN1stCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_n1st_crr_cd", length));
			String[] joBsa = (JSPUtil.getParameter(request, prefix	+ "jo_bsa", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dateDt = (JSPUtil.getParameter(request, prefix	+ "date_dt", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] controlCd = (JSPUtil.getParameter(request, prefix	+ "control_cd", length));
			String[] joRemark = (JSPUtil.getParameter(request, prefix	+ "jo_remark", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] attachFlg = (JSPUtil.getParameter(request, prefix	+ "attach_flg", length));
			String[] settleDt = (JSPUtil.getParameter(request, prefix	+ "settle_dt", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] joPrice = (JSPUtil.getParameter(request, prefix	+ "jo_price", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] acctgCrrCd = (JSPUtil.getParameter(request, prefix	+ "acctg_crr_cd", length));
			String[] term = (JSPUtil.getParameter(request, prefix	+ "term", length));
			String[] joWeight = (JSPUtil.getParameter(request, prefix	+ "jo_weight", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] creDtFr = (JSPUtil.getParameter(request, prefix	+ "cre_dt_fr", length));
			String[] atchFileId = (JSPUtil.getParameter(request, prefix	+ "atch_file_id", length));
			String[] picUsrId = (JSPUtil.getParameter(request, prefix	+ "pic_usr_id", length));
			String[] picUsrNm = (JSPUtil.getParameter(request, prefix	+ "pic_usr_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new AdditionalSlotManageVO();
				if (legFport[i] != null)
					model.setLegFport(legFport[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (legTport[i] != null)
					model.setLegTport(legTport[i]);
				if (stlFlg[i] != null)
					model.setStlFlg(stlFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (ousQty[i] != null)
					model.setOusQty(ousQty[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (creDtTo[i] != null)
					model.setCreDtTo(creDtTo[i]);
				if (joN2ndCrrCd[i] != null)
					model.setJoN2ndCrrCd(joN2ndCrrCd[i]);
				if (relOfcCd[i] != null)
					model.setRelOfcCd(relOfcCd[i]);
				if (revDivr[i] != null)
					model.setRevDivr(revDivr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (joN1stCrrCd[i] != null)
					model.setJoN1stCrrCd(joN1stCrrCd[i]);
				if (joBsa[i] != null)
					model.setJoBsa(joBsa[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dateDt[i] != null)
					model.setDateDt(dateDt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (controlCd[i] != null)
					model.setControlCd(controlCd[i]);
				if (joRemark[i] != null)
					model.setJoRemark(joRemark[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (attachFlg[i] != null)
					model.setAttachFlg(attachFlg[i]);
				if (settleDt[i] != null)
					model.setSettleDt(settleDt[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (joPrice[i] != null)
					model.setJoPrice(joPrice[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (acctgCrrCd[i] != null)
					model.setAcctgCrrCd(acctgCrrCd[i]);
				if (term[i] != null)
					model.setTerm(term[i]);
				if (joWeight[i] != null)
					model.setJoWeight(joWeight[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (creDtFr[i] != null)
					model.setCreDtFr(creDtFr[i]);
				if (atchFileId[i] != null)
					model.setAtchFileId(atchFileId[i]);
				if (picUsrId[i] != null)
					model.setPicUsrId(picUsrId[i]);
				if (picUsrNm[i] != null)
					model.setPicUsrNm(picUsrNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAdditionalSlotManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AdditionalSlotManageVO[]
	 */
	public AdditionalSlotManageVO[] getAdditionalSlotManageVOs(){
		AdditionalSlotManageVO[] vos = (AdditionalSlotManageVO[])models.toArray(new AdditionalSlotManageVO[models.size()]);
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
		this.legFport = this.legFport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.legTport = this.legTport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg = this.stlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ousQty = this.ousQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtTo = this.creDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joN2ndCrrCd = this.joN2ndCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.relOfcCd = this.relOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDivr = this.revDivr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joN1stCrrCd = this.joN1stCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBsa = this.joBsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateDt = this.dateDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.controlCd = this.controlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRemark = this.joRemark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attachFlg = this.attachFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.settleDt = this.settleDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joPrice = this.joPrice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgCrrCd = this.acctgCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.term = this.term .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joWeight = this.joWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtFr = this.creDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileId = this.atchFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picUsrId = this.picUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picUsrNm = this.picUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
