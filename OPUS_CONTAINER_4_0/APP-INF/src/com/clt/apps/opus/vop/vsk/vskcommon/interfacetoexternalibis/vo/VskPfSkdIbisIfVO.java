/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VskPfSkdIbisIfVO.java
*@FileTitle : VskPfSkdIbisIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class VskPfSkdIbisIfVO extends AbstractValueObject {

private static final long serialVersionUID = 1L;
	
	private Collection<VskPfSkdIbisIfVO> models = new ArrayList<VskPfSkdIbisIfVO>();
	
	/* Column Info */
	private String ttlDist = null;
	/* Column Info */
	private String n1stVslClssKnt = null;
	/* Column Info */
	private String stndSvcSpd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String insfDvCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String simDt = null;
	/* Column Info */
	private String simNo = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String insfId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String maxSpd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String svcDurDys = null;
	/* Column Info */
	private String pfSvcTpCd = null;
	/* Column Info */
	private String pfSkdRmk = null;
	/* Column Info */
	private String slanStndFlg = null;
	/* Column Info */
	private String mmlUsdFlg = null;
	/* Column Info */
	private String n3rdVslClssCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ifMnplCd = null;
	/* Column Info */
	private String insfCnqeVal = null;
	/* Column Info */
	private String brthItvalDys = null;
	/* Column Info */
	private String n3rdVslClssKnt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String insfDttm = null;
	/* Column Info */
	private String insfPrsId = null;
	/* Column Info */
	private String avgSpd = null;
	/* Column Info */
	private String n2ndVslClssKnt = null;
	/* Column Info */
	private String ibisIfSeq = null;
	/* Column Info */
	private String n2ndVslClssCd = null;
	/* Column Info */
	private String n1stVslClssCd = null;
	/* Column Info */
	private String clptKnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VskPfSkdIbisIfVO() {}

	public VskPfSkdIbisIfVO(String ibflag, String pagerows, String vslSlanCd, String pfSvcTpCd, String ibisIfSeq, String insfId, String insfPrsId, String insfDttm, String insfCnqeVal, String insfDvCd, String ifMnplCd, String slanStndFlg, String svcDurDys, String stndSvcSpd, String brthItvalDys, String mmlUsdFlg, String simDt, String simNo, String n1stVslClssCd, String n1stVslClssKnt, String n2ndVslClssCd, String n2ndVslClssKnt, String n3rdVslClssCd, String n3rdVslClssKnt, String clptKnt, String ttlDist, String maxSpd, String avgSpd, String deltFlg, String pfSkdRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.ttlDist = ttlDist;
		this.n1stVslClssKnt = n1stVslClssKnt;
		this.stndSvcSpd = stndSvcSpd;
		this.deltFlg = deltFlg;
		this.insfDvCd = insfDvCd;
		this.creDt = creDt;
		this.simDt = simDt;
		this.simNo = simNo;
		this.vslSlanCd = vslSlanCd;
		this.insfId = insfId;
		this.pagerows = pagerows;
		this.maxSpd = maxSpd;
		this.ibflag = ibflag;
		this.svcDurDys = svcDurDys;
		this.pfSvcTpCd = pfSvcTpCd;
		this.pfSkdRmk = pfSkdRmk;
		this.slanStndFlg = slanStndFlg;
		this.mmlUsdFlg = mmlUsdFlg;
		this.n3rdVslClssCd = n3rdVslClssCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.ifMnplCd = ifMnplCd;
		this.insfCnqeVal = insfCnqeVal;
		this.brthItvalDys = brthItvalDys;
		this.n3rdVslClssKnt = n3rdVslClssKnt;
		this.creUsrId = creUsrId;
		this.insfDttm = insfDttm;
		this.insfPrsId = insfPrsId;
		this.avgSpd = avgSpd;
		this.n2ndVslClssKnt = n2ndVslClssKnt;
		this.ibisIfSeq = ibisIfSeq;
		this.n2ndVslClssCd = n2ndVslClssCd;
		this.n1stVslClssCd = n1stVslClssCd;
		this.clptKnt = clptKnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ttl_dist", getTtlDist());
		this.hashColumns.put("n1st_vsl_clss_knt", getN1stVslClssKnt());
		this.hashColumns.put("stnd_svc_spd", getStndSvcSpd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("insf_dv_cd", getInsfDvCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sim_dt", getSimDt());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("insf_id", getInsfId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("max_spd", getMaxSpd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("svc_dur_dys", getSvcDurDys());
		this.hashColumns.put("pf_svc_tp_cd", getPfSvcTpCd());
		this.hashColumns.put("pf_skd_rmk", getPfSkdRmk());
		this.hashColumns.put("slan_stnd_flg", getSlanStndFlg());
		this.hashColumns.put("mml_usd_flg", getMmlUsdFlg());
		this.hashColumns.put("n3rd_vsl_clss_cd", getN3rdVslClssCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("if_mnpl_cd", getIfMnplCd());
		this.hashColumns.put("insf_cnqe_val", getInsfCnqeVal());
		this.hashColumns.put("brth_itval_dys", getBrthItvalDys());
		this.hashColumns.put("n3rd_vsl_clss_knt", getN3rdVslClssKnt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("insf_dttm", getInsfDttm());
		this.hashColumns.put("insf_prs_id", getInsfPrsId());
		this.hashColumns.put("avg_spd", getAvgSpd());
		this.hashColumns.put("n2nd_vsl_clss_knt", getN2ndVslClssKnt());
		this.hashColumns.put("ibis_if_seq", getIbisIfSeq());
		this.hashColumns.put("n2nd_vsl_clss_cd", getN2ndVslClssCd());
		this.hashColumns.put("n1st_vsl_clss_cd", getN1stVslClssCd());
		this.hashColumns.put("clpt_knt", getClptKnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ttl_dist", "ttlDist");
		this.hashFields.put("n1st_vsl_clss_knt", "n1stVslClssKnt");
		this.hashFields.put("stnd_svc_spd", "stndSvcSpd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("insf_dv_cd", "insfDvCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sim_dt", "simDt");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("insf_id", "insfId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("max_spd", "maxSpd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("svc_dur_dys", "svcDurDys");
		this.hashFields.put("pf_svc_tp_cd", "pfSvcTpCd");
		this.hashFields.put("pf_skd_rmk", "pfSkdRmk");
		this.hashFields.put("slan_stnd_flg", "slanStndFlg");
		this.hashFields.put("mml_usd_flg", "mmlUsdFlg");
		this.hashFields.put("n3rd_vsl_clss_cd", "n3rdVslClssCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("if_mnpl_cd", "ifMnplCd");
		this.hashFields.put("insf_cnqe_val", "insfCnqeVal");
		this.hashFields.put("brth_itval_dys", "brthItvalDys");
		this.hashFields.put("n3rd_vsl_clss_knt", "n3rdVslClssKnt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("insf_dttm", "insfDttm");
		this.hashFields.put("insf_prs_id", "insfPrsId");
		this.hashFields.put("avg_spd", "avgSpd");
		this.hashFields.put("n2nd_vsl_clss_knt", "n2ndVslClssKnt");
		this.hashFields.put("ibis_if_seq", "ibisIfSeq");
		this.hashFields.put("n2nd_vsl_clss_cd", "n2ndVslClssCd");
		this.hashFields.put("n1st_vsl_clss_cd", "n1stVslClssCd");
		this.hashFields.put("clpt_knt", "clptKnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ttlDist
	 */
	public String getTtlDist() {
		return this.ttlDist;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssKnt
	 */
	public String getN1stVslClssKnt() {
		return this.n1stVslClssKnt;
	}
	
	/**
	 * Column Info
	 * @return stndSvcSpd
	 */
	public String getStndSvcSpd() {
		return this.stndSvcSpd;
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
	 * @return insfDvCd
	 */
	public String getInsfDvCd() {
		return this.insfDvCd;
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
	 * @return simDt
	 */
	public String getSimDt() {
		return this.simDt;
	}
	
	/**
	 * Column Info
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return insfId
	 */
	public String getInsfId() {
		return this.insfId;
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
	 * @return maxSpd
	 */
	public String getMaxSpd() {
		return this.maxSpd;
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
	 * @return svcDurDys
	 */
	public String getSvcDurDys() {
		return this.svcDurDys;
	}
	
	/**
	 * Column Info
	 * @return pfSvcTpCd
	 */
	public String getPfSvcTpCd() {
		return this.pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return pfSkdRmk
	 */
	public String getPfSkdRmk() {
		return this.pfSkdRmk;
	}
	
	/**
	 * Column Info
	 * @return slanStndFlg
	 */
	public String getSlanStndFlg() {
		return this.slanStndFlg;
	}
	
	/**
	 * Column Info
	 * @return mmlUsdFlg
	 */
	public String getMmlUsdFlg() {
		return this.mmlUsdFlg;
	}
	
	/**
	 * Column Info
	 * @return n3rdVslClssCd
	 */
	public String getN3rdVslClssCd() {
		return this.n3rdVslClssCd;
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
	 * @return ifMnplCd
	 */
	public String getIfMnplCd() {
		return this.ifMnplCd;
	}
	
	/**
	 * Column Info
	 * @return insfCnqeVal
	 */
	public String getInsfCnqeVal() {
		return this.insfCnqeVal;
	}
	
	/**
	 * Column Info
	 * @return brthItvalDys
	 */
	public String getBrthItvalDys() {
		return this.brthItvalDys;
	}
	
	/**
	 * Column Info
	 * @return n3rdVslClssKnt
	 */
	public String getN3rdVslClssKnt() {
		return this.n3rdVslClssKnt;
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
	 * @return insfDttm
	 */
	public String getInsfDttm() {
		return this.insfDttm;
	}
	
	/**
	 * Column Info
	 * @return insfPrsId
	 */
	public String getInsfPrsId() {
		return this.insfPrsId;
	}
	
	/**
	 * Column Info
	 * @return avgSpd
	 */
	public String getAvgSpd() {
		return this.avgSpd;
	}
	
	/**
	 * Column Info
	 * @return n2ndVslClssKnt
	 */
	public String getN2ndVslClssKnt() {
		return this.n2ndVslClssKnt;
	}
	
	/**
	 * Column Info
	 * @return ibisIfSeq
	 */
	public String getIbisIfSeq() {
		return this.ibisIfSeq;
	}
	
	/**
	 * Column Info
	 * @return n2ndVslClssCd
	 */
	public String getN2ndVslClssCd() {
		return this.n2ndVslClssCd;
	}
	
	/**
	 * Column Info
	 * @return n1stVslClssCd
	 */
	public String getN1stVslClssCd() {
		return this.n1stVslClssCd;
	}
	
	/**
	 * Column Info
	 * @return clptKnt
	 */
	public String getClptKnt() {
		return this.clptKnt;
	}
	

	/**
	 * Column Info
	 * @param ttlDist
	 */
	public void setTtlDist(String ttlDist) {
		this.ttlDist = ttlDist;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssKnt
	 */
	public void setN1stVslClssKnt(String n1stVslClssKnt) {
		this.n1stVslClssKnt = n1stVslClssKnt;
	}
	
	/**
	 * Column Info
	 * @param stndSvcSpd
	 */
	public void setStndSvcSpd(String stndSvcSpd) {
		this.stndSvcSpd = stndSvcSpd;
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
	 * @param insfDvCd
	 */
	public void setInsfDvCd(String insfDvCd) {
		this.insfDvCd = insfDvCd;
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
	 * @param simDt
	 */
	public void setSimDt(String simDt) {
		this.simDt = simDt;
	}
	
	/**
	 * Column Info
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param insfId
	 */
	public void setInsfId(String insfId) {
		this.insfId = insfId;
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
	 * @param maxSpd
	 */
	public void setMaxSpd(String maxSpd) {
		this.maxSpd = maxSpd;
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
	 * @param svcDurDys
	 */
	public void setSvcDurDys(String svcDurDys) {
		this.svcDurDys = svcDurDys;
	}
	
	/**
	 * Column Info
	 * @param pfSvcTpCd
	 */
	public void setPfSvcTpCd(String pfSvcTpCd) {
		this.pfSvcTpCd = pfSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param pfSkdRmk
	 */
	public void setPfSkdRmk(String pfSkdRmk) {
		this.pfSkdRmk = pfSkdRmk;
	}
	
	/**
	 * Column Info
	 * @param slanStndFlg
	 */
	public void setSlanStndFlg(String slanStndFlg) {
		this.slanStndFlg = slanStndFlg;
	}
	
	/**
	 * Column Info
	 * @param mmlUsdFlg
	 */
	public void setMmlUsdFlg(String mmlUsdFlg) {
		this.mmlUsdFlg = mmlUsdFlg;
	}
	
	/**
	 * Column Info
	 * @param n3rdVslClssCd
	 */
	public void setN3rdVslClssCd(String n3rdVslClssCd) {
		this.n3rdVslClssCd = n3rdVslClssCd;
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
	 * @param ifMnplCd
	 */
	public void setIfMnplCd(String ifMnplCd) {
		this.ifMnplCd = ifMnplCd;
	}
	
	/**
	 * Column Info
	 * @param insfCnqeVal
	 */
	public void setInsfCnqeVal(String insfCnqeVal) {
		this.insfCnqeVal = insfCnqeVal;
	}
	
	/**
	 * Column Info
	 * @param brthItvalDys
	 */
	public void setBrthItvalDys(String brthItvalDys) {
		this.brthItvalDys = brthItvalDys;
	}
	
	/**
	 * Column Info
	 * @param n3rdVslClssKnt
	 */
	public void setN3rdVslClssKnt(String n3rdVslClssKnt) {
		this.n3rdVslClssKnt = n3rdVslClssKnt;
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
	 * @param insfDttm
	 */
	public void setInsfDttm(String insfDttm) {
		this.insfDttm = insfDttm;
	}
	
	/**
	 * Column Info
	 * @param insfPrsId
	 */
	public void setInsfPrsId(String insfPrsId) {
		this.insfPrsId = insfPrsId;
	}
	
	/**
	 * Column Info
	 * @param avgSpd
	 */
	public void setAvgSpd(String avgSpd) {
		this.avgSpd = avgSpd;
	}
	
	/**
	 * Column Info
	 * @param n2ndVslClssKnt
	 */
	public void setN2ndVslClssKnt(String n2ndVslClssKnt) {
		this.n2ndVslClssKnt = n2ndVslClssKnt;
	}
	
	/**
	 * Column Info
	 * @param ibisIfSeq
	 */
	public void setIbisIfSeq(String ibisIfSeq) {
		this.ibisIfSeq = ibisIfSeq;
	}
	
	/**
	 * Column Info
	 * @param n2ndVslClssCd
	 */
	public void setN2ndVslClssCd(String n2ndVslClssCd) {
		this.n2ndVslClssCd = n2ndVslClssCd;
	}
	
	/**
	 * Column Info
	 * @param n1stVslClssCd
	 */
	public void setN1stVslClssCd(String n1stVslClssCd) {
		this.n1stVslClssCd = n1stVslClssCd;
	}
	
	/**
	 * Column Info
	 * @param clptKnt
	 */
	public void setClptKnt(String clptKnt) {
		this.clptKnt = clptKnt;
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
		setTtlDist(JSPUtil.getParameter(request, prefix + "ttl_dist", ""));
		setN1stVslClssKnt(JSPUtil.getParameter(request, prefix + "n1st_vsl_clss_knt", ""));
		setStndSvcSpd(JSPUtil.getParameter(request, prefix + "stnd_svc_spd", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setInsfDvCd(JSPUtil.getParameter(request, prefix + "insf_dv_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSimDt(JSPUtil.getParameter(request, prefix + "sim_dt", ""));
		setSimNo(JSPUtil.getParameter(request, prefix + "sim_no", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setInsfId(JSPUtil.getParameter(request, prefix + "insf_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMaxSpd(JSPUtil.getParameter(request, prefix + "max_spd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSvcDurDys(JSPUtil.getParameter(request, prefix + "svc_dur_dys", ""));
		setPfSvcTpCd(JSPUtil.getParameter(request, prefix + "pf_svc_tp_cd", ""));
		setPfSkdRmk(JSPUtil.getParameter(request, prefix + "pf_skd_rmk", ""));
		setSlanStndFlg(JSPUtil.getParameter(request, prefix + "slan_stnd_flg", ""));
		setMmlUsdFlg(JSPUtil.getParameter(request, prefix + "mml_usd_flg", ""));
		setN3rdVslClssCd(JSPUtil.getParameter(request, prefix + "n3rd_vsl_clss_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIfMnplCd(JSPUtil.getParameter(request, prefix + "if_mnpl_cd", ""));
		setInsfCnqeVal(JSPUtil.getParameter(request, prefix + "insf_cnqe_val", ""));
		setBrthItvalDys(JSPUtil.getParameter(request, prefix + "brth_itval_dys", ""));
		setN3rdVslClssKnt(JSPUtil.getParameter(request, prefix + "n3rd_vsl_clss_knt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setInsfDttm(JSPUtil.getParameter(request, prefix + "insf_dttm", ""));
		setInsfPrsId(JSPUtil.getParameter(request, prefix + "insf_prs_id", ""));
		setAvgSpd(JSPUtil.getParameter(request, prefix + "avg_spd", ""));
		setN2ndVslClssKnt(JSPUtil.getParameter(request, prefix + "n2nd_vsl_clss_knt", ""));
		setIbisIfSeq(JSPUtil.getParameter(request, prefix + "ibis_if_seq", ""));
		setN2ndVslClssCd(JSPUtil.getParameter(request, prefix + "n2nd_vsl_clss_cd", ""));
		setN1stVslClssCd(JSPUtil.getParameter(request, prefix + "n1st_vsl_clss_cd", ""));
		setClptKnt(JSPUtil.getParameter(request, prefix + "clpt_knt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskPfSkdIbisIfVO[]
	 */
	public VskPfSkdIbisIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskPfSkdIbisIfVO[]
	 */
	public VskPfSkdIbisIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskPfSkdIbisIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ttlDist = (JSPUtil.getParameter(request, prefix	+ "ttl_dist", length));
			String[] n1stVslClssKnt = (JSPUtil.getParameter(request, prefix	+ "n1st_vsl_clss_knt", length));
			String[] stndSvcSpd = (JSPUtil.getParameter(request, prefix	+ "stnd_svc_spd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] insfDvCd = (JSPUtil.getParameter(request, prefix	+ "insf_dv_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] simDt = (JSPUtil.getParameter(request, prefix	+ "sim_dt", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] insfId = (JSPUtil.getParameter(request, prefix	+ "insf_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] maxSpd = (JSPUtil.getParameter(request, prefix	+ "max_spd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] svcDurDys = (JSPUtil.getParameter(request, prefix	+ "svc_dur_dys", length));
			String[] pfSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_svc_tp_cd", length));
			String[] pfSkdRmk = (JSPUtil.getParameter(request, prefix	+ "pf_skd_rmk", length));
			String[] slanStndFlg = (JSPUtil.getParameter(request, prefix	+ "slan_stnd_flg", length));
			String[] mmlUsdFlg = (JSPUtil.getParameter(request, prefix	+ "mml_usd_flg", length));
			String[] n3rdVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_vsl_clss_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ifMnplCd = (JSPUtil.getParameter(request, prefix	+ "if_mnpl_cd", length));
			String[] insfCnqeVal = (JSPUtil.getParameter(request, prefix	+ "insf_cnqe_val", length));
			String[] brthItvalDys = (JSPUtil.getParameter(request, prefix	+ "brth_itval_dys", length));
			String[] n3rdVslClssKnt = (JSPUtil.getParameter(request, prefix	+ "n3rd_vsl_clss_knt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] insfDttm = (JSPUtil.getParameter(request, prefix	+ "insf_dttm", length));
			String[] insfPrsId = (JSPUtil.getParameter(request, prefix	+ "insf_prs_id", length));
			String[] avgSpd = (JSPUtil.getParameter(request, prefix	+ "avg_spd", length));
			String[] n2ndVslClssKnt = (JSPUtil.getParameter(request, prefix	+ "n2nd_vsl_clss_knt", length));
			String[] ibisIfSeq = (JSPUtil.getParameter(request, prefix	+ "ibis_if_seq", length));
			String[] n2ndVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_vsl_clss_cd", length));
			String[] n1stVslClssCd = (JSPUtil.getParameter(request, prefix	+ "n1st_vsl_clss_cd", length));
			String[] clptKnt = (JSPUtil.getParameter(request, prefix	+ "clpt_knt", length));
			
			for (int i = 0; i < length; i++) {
				model = new VskPfSkdIbisIfVO();
				if (ttlDist[i] != null)
					model.setTtlDist(ttlDist[i]);
				if (n1stVslClssKnt[i] != null)
					model.setN1stVslClssKnt(n1stVslClssKnt[i]);
				if (stndSvcSpd[i] != null)
					model.setStndSvcSpd(stndSvcSpd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (insfDvCd[i] != null)
					model.setInsfDvCd(insfDvCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (simDt[i] != null)
					model.setSimDt(simDt[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (insfId[i] != null)
					model.setInsfId(insfId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (maxSpd[i] != null)
					model.setMaxSpd(maxSpd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (svcDurDys[i] != null)
					model.setSvcDurDys(svcDurDys[i]);
				if (pfSvcTpCd[i] != null)
					model.setPfSvcTpCd(pfSvcTpCd[i]);
				if (pfSkdRmk[i] != null)
					model.setPfSkdRmk(pfSkdRmk[i]);
				if (slanStndFlg[i] != null)
					model.setSlanStndFlg(slanStndFlg[i]);
				if (mmlUsdFlg[i] != null)
					model.setMmlUsdFlg(mmlUsdFlg[i]);
				if (n3rdVslClssCd[i] != null)
					model.setN3rdVslClssCd(n3rdVslClssCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ifMnplCd[i] != null)
					model.setIfMnplCd(ifMnplCd[i]);
				if (insfCnqeVal[i] != null)
					model.setInsfCnqeVal(insfCnqeVal[i]);
				if (brthItvalDys[i] != null)
					model.setBrthItvalDys(brthItvalDys[i]);
				if (n3rdVslClssKnt[i] != null)
					model.setN3rdVslClssKnt(n3rdVslClssKnt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (insfDttm[i] != null)
					model.setInsfDttm(insfDttm[i]);
				if (insfPrsId[i] != null)
					model.setInsfPrsId(insfPrsId[i]);
				if (avgSpd[i] != null)
					model.setAvgSpd(avgSpd[i]);
				if (n2ndVslClssKnt[i] != null)
					model.setN2ndVslClssKnt(n2ndVslClssKnt[i]);
				if (ibisIfSeq[i] != null)
					model.setIbisIfSeq(ibisIfSeq[i]);
				if (n2ndVslClssCd[i] != null)
					model.setN2ndVslClssCd(n2ndVslClssCd[i]);
				if (n1stVslClssCd[i] != null)
					model.setN1stVslClssCd(n1stVslClssCd[i]);
				if (clptKnt[i] != null)
					model.setClptKnt(clptKnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskPfSkdIbisIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskPfSkdIbisIfVO[]
	 */
	public VskPfSkdIbisIfVO[] getVskPfSkdIbisIfVOs(){
		VskPfSkdIbisIfVO[] vos = (VskPfSkdIbisIfVO[])models.toArray(new VskPfSkdIbisIfVO[models.size()]);
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
		this.ttlDist = this.ttlDist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVslClssKnt = this.n1stVslClssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stndSvcSpd = this.stndSvcSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfDvCd = this.insfDvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simDt = this.simDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfId = this.insfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxSpd = this.maxSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcDurDys = this.svcDurDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSvcTpCd = this.pfSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSkdRmk = this.pfSkdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanStndFlg = this.slanStndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mmlUsdFlg = this.mmlUsdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVslClssCd = this.n3rdVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifMnplCd = this.ifMnplCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfCnqeVal = this.insfCnqeVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brthItvalDys = this.brthItvalDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdVslClssKnt = this.n3rdVslClssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfDttm = this.insfDttm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfPrsId = this.insfPrsId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgSpd = this.avgSpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVslClssKnt = this.n2ndVslClssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibisIfSeq = this.ibisIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndVslClssCd = this.n2ndVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stVslClssCd = this.n1stVslClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptKnt = this.clptKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
