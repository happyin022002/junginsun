/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BlkVygSttsVO.java
*@FileTitle : BlkVygSttsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.02  
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

public class BlkVygSttsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlkVygSttsVO> models = new ArrayList<BlkVygSttsVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bsaQty = null;
	/* Column Info */
	private String cmpnAgmtRmk = null;
	/* Column Info */
	private String cmpnAgmtYrmon = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String stlFlg = null;
	/* Column Info */
	private String cmpnAgmtSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String atchFileFlag = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String stlVoyNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String joCmpnKndCd = null;
	/* Column Info */
	private String agmtOfcCd = null;
	/* Column Info */
	private String stlVslCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stlDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String cmpnAgmtYrwk = null;
	/* Column Info */
	private String stlVvdCd = null;
	/* Column Info */
	private String agmtTtlAmt = null;
	/* Column Info */
	private String fmPrd1 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String atchFileId = null;
	/* Column Info */
	private String stlDirCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bsaSltPrc = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String toPrd2 = null;
	/* Column Info */
	private String sttlCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BlkVygSttsVO() {}

	public BlkVygSttsVO(String ibflag, String pagerows, String joCrrCd, String trdCd, String rlaneCd, String reDivrCd, String cmpnAgmtSeq, String ofcCd, String agmtOfcCd, String joCmpnKndCd, String cmpnAgmtYrmon, String cmpnAgmtYrwk, String vslCd, String skdVoyNo, String skdDirCd, String bsaQty, String bsaSltPrc, String agmtTtlAmt, String atchFileFlag, String atchFileId, String cmpnAgmtRmk, String stlFlg, String stlVslCd, String stlVoyNo, String stlDirCd, String stlDt, String deltFlg, String creDt, String creUsrId, String updDt, String updUsrId, String fmPrd1, String toPrd2, String sttlCd, String vvdCd, String stlVvdCd) {
		this.vslCd = vslCd;
		this.bsaQty = bsaQty;
		this.cmpnAgmtRmk = cmpnAgmtRmk;
		this.cmpnAgmtYrmon = cmpnAgmtYrmon;
		this.deltFlg = deltFlg;
		this.stlFlg = stlFlg;
		this.cmpnAgmtSeq = cmpnAgmtSeq;
		this.creDt = creDt;
		this.atchFileFlag = atchFileFlag;
		this.trdCd = trdCd;
		this.stlVoyNo = stlVoyNo;
		this.rlaneCd = rlaneCd;
		this.joCmpnKndCd = joCmpnKndCd;
		this.agmtOfcCd = agmtOfcCd;
		this.stlVslCd = stlVslCd;
		this.pagerows = pagerows;
		this.stlDt = stlDt;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.cmpnAgmtYrwk = cmpnAgmtYrwk;
		this.stlVvdCd = stlVvdCd;
		this.agmtTtlAmt = agmtTtlAmt;
		this.fmPrd1 = fmPrd1;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.joCrrCd = joCrrCd;
		this.skdVoyNo = skdVoyNo;
		this.atchFileId = atchFileId;
		this.stlDirCd = stlDirCd;
		this.skdDirCd = skdDirCd;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.bsaSltPrc = bsaSltPrc;
		this.reDivrCd = reDivrCd;
		this.toPrd2 = toPrd2;
		this.sttlCd = sttlCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bsa_qty", getBsaQty());
		this.hashColumns.put("cmpn_agmt_rmk", getCmpnAgmtRmk());
		this.hashColumns.put("cmpn_agmt_yrmon", getCmpnAgmtYrmon());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("stl_flg", getStlFlg());
		this.hashColumns.put("cmpn_agmt_seq", getCmpnAgmtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("atch_file_flag", getAtchFileFlag());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("stl_voy_no", getStlVoyNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("jo_cmpn_knd_cd", getJoCmpnKndCd());
		this.hashColumns.put("agmt_ofc_cd", getAgmtOfcCd());
		this.hashColumns.put("stl_vsl_cd", getStlVslCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("stl_dt", getStlDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cmpn_agmt_yrwk", getCmpnAgmtYrwk());
		this.hashColumns.put("stl_vvd_cd", getStlVvdCd());
		this.hashColumns.put("agmt_ttl_amt", getAgmtTtlAmt());
		this.hashColumns.put("fm_prd1", getFmPrd1());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("atch_file_id", getAtchFileId());
		this.hashColumns.put("stl_dir_cd", getStlDirCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bsa_slt_prc", getBsaSltPrc());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("to_prd2", getToPrd2());
		this.hashColumns.put("sttl_cd", getSttlCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bsa_qty", "bsaQty");
		this.hashFields.put("cmpn_agmt_rmk", "cmpnAgmtRmk");
		this.hashFields.put("cmpn_agmt_yrmon", "cmpnAgmtYrmon");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("stl_flg", "stlFlg");
		this.hashFields.put("cmpn_agmt_seq", "cmpnAgmtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("atch_file_flag", "atchFileFlag");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("stl_voy_no", "stlVoyNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("jo_cmpn_knd_cd", "joCmpnKndCd");
		this.hashFields.put("agmt_ofc_cd", "agmtOfcCd");
		this.hashFields.put("stl_vsl_cd", "stlVslCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("stl_dt", "stlDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cmpn_agmt_yrwk", "cmpnAgmtYrwk");
		this.hashFields.put("stl_vvd_cd", "stlVvdCd");
		this.hashFields.put("agmt_ttl_amt", "agmtTtlAmt");
		this.hashFields.put("fm_prd1", "fmPrd1");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("atch_file_id", "atchFileId");
		this.hashFields.put("stl_dir_cd", "stlDirCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bsa_slt_prc", "bsaSltPrc");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("to_prd2", "toPrd2");
		this.hashFields.put("sttl_cd", "sttlCd");
		return this.hashFields;
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
	 * @return bsaQty
	 */
	public String getBsaQty() {
		return this.bsaQty;
	}
	
	/**
	 * Column Info
	 * @return cmpnAgmtRmk
	 */
	public String getCmpnAgmtRmk() {
		return this.cmpnAgmtRmk;
	}
	
	/**
	 * Column Info
	 * @return cmpnAgmtYrmon
	 */
	public String getCmpnAgmtYrmon() {
		return this.cmpnAgmtYrmon;
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
	 * @return stlFlg
	 */
	public String getStlFlg() {
		return this.stlFlg;
	}
	
	/**
	 * Column Info
	 * @return cmpnAgmtSeq
	 */
	public String getCmpnAgmtSeq() {
		return this.cmpnAgmtSeq;
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
	 * @return atchFileFlag
	 */
	public String getAtchFileFlag() {
		return this.atchFileFlag;
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
	 * @return stlVoyNo
	 */
	public String getStlVoyNo() {
		return this.stlVoyNo;
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
	 * @return joCmpnKndCd
	 */
	public String getJoCmpnKndCd() {
		return this.joCmpnKndCd;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCd
	 */
	public String getAgmtOfcCd() {
		return this.agmtOfcCd;
	}
	
	/**
	 * Column Info
	 * @return stlVslCd
	 */
	public String getStlVslCd() {
		return this.stlVslCd;
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
	 * @return stlDt
	 */
	public String getStlDt() {
		return this.stlDt;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return cmpnAgmtYrwk
	 */
	public String getCmpnAgmtYrwk() {
		return this.cmpnAgmtYrwk;
	}
	
	/**
	 * Column Info
	 * @return stlVvdCd
	 */
	public String getStlVvdCd() {
		return this.stlVvdCd;
	}
	
	/**
	 * Column Info
	 * @return agmtTtlAmt
	 */
	public String getAgmtTtlAmt() {
		return this.agmtTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return fmPrd1
	 */
	public String getFmPrd1() {
		return this.fmPrd1;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
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
	 * @return stlDirCd
	 */
	public String getStlDirCd() {
		return this.stlDirCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return bsaSltPrc
	 */
	public String getBsaSltPrc() {
		return this.bsaSltPrc;
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
	 * @return toPrd2
	 */
	public String getToPrd2() {
		return this.toPrd2;
	}
	
	/**
	 * Column Info
	 * @return sttlCd
	 */
	public String getSttlCd() {
		return this.sttlCd;
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
	 * @param bsaQty
	 */
	public void setBsaQty(String bsaQty) {
		this.bsaQty = bsaQty;
	}
	
	/**
	 * Column Info
	 * @param cmpnAgmtRmk
	 */
	public void setCmpnAgmtRmk(String cmpnAgmtRmk) {
		this.cmpnAgmtRmk = cmpnAgmtRmk;
	}
	
	/**
	 * Column Info
	 * @param cmpnAgmtYrmon
	 */
	public void setCmpnAgmtYrmon(String cmpnAgmtYrmon) {
		this.cmpnAgmtYrmon = cmpnAgmtYrmon;
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
	 * @param stlFlg
	 */
	public void setStlFlg(String stlFlg) {
		this.stlFlg = stlFlg;
	}
	
	/**
	 * Column Info
	 * @param cmpnAgmtSeq
	 */
	public void setCmpnAgmtSeq(String cmpnAgmtSeq) {
		this.cmpnAgmtSeq = cmpnAgmtSeq;
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
	 * @param atchFileFlag
	 */
	public void setAtchFileFlag(String atchFileFlag) {
		this.atchFileFlag = atchFileFlag;
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
	 * @param stlVoyNo
	 */
	public void setStlVoyNo(String stlVoyNo) {
		this.stlVoyNo = stlVoyNo;
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
	 * @param joCmpnKndCd
	 */
	public void setJoCmpnKndCd(String joCmpnKndCd) {
		this.joCmpnKndCd = joCmpnKndCd;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCd
	 */
	public void setAgmtOfcCd(String agmtOfcCd) {
		this.agmtOfcCd = agmtOfcCd;
	}
	
	/**
	 * Column Info
	 * @param stlVslCd
	 */
	public void setStlVslCd(String stlVslCd) {
		this.stlVslCd = stlVslCd;
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
	 * @param stlDt
	 */
	public void setStlDt(String stlDt) {
		this.stlDt = stlDt;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param cmpnAgmtYrwk
	 */
	public void setCmpnAgmtYrwk(String cmpnAgmtYrwk) {
		this.cmpnAgmtYrwk = cmpnAgmtYrwk;
	}
	
	/**
	 * Column Info
	 * @param stlVvdCd
	 */
	public void setStlVvdCd(String stlVvdCd) {
		this.stlVvdCd = stlVvdCd;
	}
	
	/**
	 * Column Info
	 * @param agmtTtlAmt
	 */
	public void setAgmtTtlAmt(String agmtTtlAmt) {
		this.agmtTtlAmt = agmtTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param fmPrd1
	 */
	public void setFmPrd1(String fmPrd1) {
		this.fmPrd1 = fmPrd1;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	 * @param stlDirCd
	 */
	public void setStlDirCd(String stlDirCd) {
		this.stlDirCd = stlDirCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param bsaSltPrc
	 */
	public void setBsaSltPrc(String bsaSltPrc) {
		this.bsaSltPrc = bsaSltPrc;
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
	 * @param toPrd2
	 */
	public void setToPrd2(String toPrd2) {
		this.toPrd2 = toPrd2;
	}
	
	/**
	 * Column Info
	 * @param sttlCd
	 */
	public void setSttlCd(String sttlCd) {
		this.sttlCd = sttlCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setBsaQty(JSPUtil.getParameter(request, prefix + "bsa_qty", ""));
		setCmpnAgmtRmk(JSPUtil.getParameter(request, prefix + "cmpn_agmt_rmk", ""));
		setCmpnAgmtYrmon(JSPUtil.getParameter(request, prefix + "cmpn_agmt_yrmon", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setStlFlg(JSPUtil.getParameter(request, prefix + "stl_flg", ""));
		setCmpnAgmtSeq(JSPUtil.getParameter(request, prefix + "cmpn_agmt_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAtchFileFlag(JSPUtil.getParameter(request, prefix + "atch_file_flag", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setStlVoyNo(JSPUtil.getParameter(request, prefix + "stl_voy_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setJoCmpnKndCd(JSPUtil.getParameter(request, prefix + "jo_cmpn_knd_cd", ""));
		setAgmtOfcCd(JSPUtil.getParameter(request, prefix + "agmt_ofc_cd", ""));
		setStlVslCd(JSPUtil.getParameter(request, prefix + "stl_vsl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStlDt(JSPUtil.getParameter(request, prefix + "stl_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCmpnAgmtYrwk(JSPUtil.getParameter(request, prefix + "cmpn_agmt_yrwk", ""));
		setStlVvdCd(JSPUtil.getParameter(request, prefix + "stl_vvd_cd", ""));
		setAgmtTtlAmt(JSPUtil.getParameter(request, prefix + "agmt_ttl_amt", ""));
		setFmPrd1(JSPUtil.getParameter(request, prefix + "fm_prd1", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setAtchFileId(JSPUtil.getParameter(request, prefix + "atch_file_id", ""));
		setStlDirCd(JSPUtil.getParameter(request, prefix + "stl_dir_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBsaSltPrc(JSPUtil.getParameter(request, prefix + "bsa_slt_prc", ""));
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setToPrd2(JSPUtil.getParameter(request, prefix + "to_prd2", ""));
		setSttlCd(JSPUtil.getParameter(request, prefix + "sttl_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlkVygSttsVO[]
	 */
	public BlkVygSttsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlkVygSttsVO[]
	 */
	public BlkVygSttsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlkVygSttsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bsaQty = (JSPUtil.getParameter(request, prefix	+ "bsa_qty", length));
			String[] cmpnAgmtRmk = (JSPUtil.getParameter(request, prefix	+ "cmpn_agmt_rmk", length));
			String[] cmpnAgmtYrmon = (JSPUtil.getParameter(request, prefix	+ "cmpn_agmt_yrmon", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] stlFlg = (JSPUtil.getParameter(request, prefix	+ "stl_flg", length));
			String[] cmpnAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "cmpn_agmt_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] atchFileFlag = (JSPUtil.getParameter(request, prefix	+ "atch_file_flag", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] stlVoyNo = (JSPUtil.getParameter(request, prefix	+ "stl_voy_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] joCmpnKndCd = (JSPUtil.getParameter(request, prefix	+ "jo_cmpn_knd_cd", length));
			String[] agmtOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cd", length));
			String[] stlVslCd = (JSPUtil.getParameter(request, prefix	+ "stl_vsl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stlDt = (JSPUtil.getParameter(request, prefix	+ "stl_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cmpnAgmtYrwk = (JSPUtil.getParameter(request, prefix	+ "cmpn_agmt_yrwk", length));
			String[] stlVvdCd = (JSPUtil.getParameter(request, prefix	+ "stl_vvd_cd", length));
			String[] agmtTtlAmt = (JSPUtil.getParameter(request, prefix	+ "agmt_ttl_amt", length));
			String[] fmPrd1 = (JSPUtil.getParameter(request, prefix	+ "fm_prd1", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] atchFileId = (JSPUtil.getParameter(request, prefix	+ "atch_file_id", length));
			String[] stlDirCd = (JSPUtil.getParameter(request, prefix	+ "stl_dir_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "bsa_slt_prc", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] toPrd2 = (JSPUtil.getParameter(request, prefix	+ "to_prd2", length));
			String[] sttlCd = (JSPUtil.getParameter(request, prefix	+ "sttl_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlkVygSttsVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bsaQty[i] != null)
					model.setBsaQty(bsaQty[i]);
				if (cmpnAgmtRmk[i] != null)
					model.setCmpnAgmtRmk(cmpnAgmtRmk[i]);
				if (cmpnAgmtYrmon[i] != null)
					model.setCmpnAgmtYrmon(cmpnAgmtYrmon[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (stlFlg[i] != null)
					model.setStlFlg(stlFlg[i]);
				if (cmpnAgmtSeq[i] != null)
					model.setCmpnAgmtSeq(cmpnAgmtSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (atchFileFlag[i] != null)
					model.setAtchFileFlag(atchFileFlag[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (stlVoyNo[i] != null)
					model.setStlVoyNo(stlVoyNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (joCmpnKndCd[i] != null)
					model.setJoCmpnKndCd(joCmpnKndCd[i]);
				if (agmtOfcCd[i] != null)
					model.setAgmtOfcCd(agmtOfcCd[i]);
				if (stlVslCd[i] != null)
					model.setStlVslCd(stlVslCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stlDt[i] != null)
					model.setStlDt(stlDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cmpnAgmtYrwk[i] != null)
					model.setCmpnAgmtYrwk(cmpnAgmtYrwk[i]);
				if (stlVvdCd[i] != null)
					model.setStlVvdCd(stlVvdCd[i]);
				if (agmtTtlAmt[i] != null)
					model.setAgmtTtlAmt(agmtTtlAmt[i]);
				if (fmPrd1[i] != null)
					model.setFmPrd1(fmPrd1[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (atchFileId[i] != null)
					model.setAtchFileId(atchFileId[i]);
				if (stlDirCd[i] != null)
					model.setStlDirCd(stlDirCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bsaSltPrc[i] != null)
					model.setBsaSltPrc(bsaSltPrc[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (toPrd2[i] != null)
					model.setToPrd2(toPrd2[i]);
				if (sttlCd[i] != null)
					model.setSttlCd(sttlCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlkVygSttsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlkVygSttsVO[]
	 */
	public BlkVygSttsVO[] getBlkVygSttsVOs(){
		BlkVygSttsVO[] vos = (BlkVygSttsVO[])models.toArray(new BlkVygSttsVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaQty = this.bsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnAgmtRmk = this.cmpnAgmtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnAgmtYrmon = this.cmpnAgmtYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg = this.stlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnAgmtSeq = this.cmpnAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileFlag = this.atchFileFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlVoyNo = this.stlVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCmpnKndCd = this.joCmpnKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCd = this.agmtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlVslCd = this.stlVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlDt = this.stlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnAgmtYrwk = this.cmpnAgmtYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlVvdCd = this.stlVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtTtlAmt = this.agmtTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrd1 = this.fmPrd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileId = this.atchFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlDirCd = this.stlDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSltPrc = this.bsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrd2 = this.toPrd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sttlCd = this.sttlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
