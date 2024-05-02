/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VskVslSkdIbisIfVO.java
*@FileTitle : VskVslSkdIbisIfVO
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

public class VskVslSkdIbisIfVO extends AbstractValueObject {

private static final long serialVersionUID = 1L;
	
	private Collection<VskVslSkdIbisIfVO> models = new ArrayList<VskVslSkdIbisIfVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String insfDvCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String pfSkdTpCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String insfId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String skdStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String skdVoyTpCd = null;
	/* Column Info */
	private String skdRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ifMnplCd = null;
	/* Column Info */
	private String insfCnqeVal = null;
	/* Column Info */
	private String n1stPortBrthDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String skdStsMnlFlg = null;
	/* Column Info */
	private String insfDttm = null;
	/* Column Info */
	private String actCrrCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String insfPrsId = null;
	/* Column Info */
	private String stPortCd = null;
	/* Column Info */
	private String ibisIfSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VskVslSkdIbisIfVO() {}

	public VskVslSkdIbisIfVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String ibisIfSeq, String insfId, String insfPrsId, String insfDttm, String insfCnqeVal, String insfDvCd, String ifMnplCd, String vslSlanCd, String skdStsCd, String skdStsMnlFlg, String skdVoyTpCd, String pfSkdTpCd, String stPortCd, String n1stPortBrthDt, String actCrrCd, String skdRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vslCd = vslCd;
		this.insfDvCd = insfDvCd;
		this.creDt = creDt;
		this.pfSkdTpCd = pfSkdTpCd;
		this.vslSlanCd = vslSlanCd;
		this.insfId = insfId;
		this.pagerows = pagerows;
		this.skdStsCd = skdStsCd;
		this.ibflag = ibflag;
		this.skdVoyTpCd = skdVoyTpCd;
		this.skdRmk = skdRmk;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.ifMnplCd = ifMnplCd;
		this.insfCnqeVal = insfCnqeVal;
		this.n1stPortBrthDt = n1stPortBrthDt;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.skdStsMnlFlg = skdStsMnlFlg;
		this.insfDttm = insfDttm;
		this.actCrrCd = actCrrCd;
		this.creUsrId = creUsrId;
		this.insfPrsId = insfPrsId;
		this.stPortCd = stPortCd;
		this.ibisIfSeq = ibisIfSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("insf_dv_cd", getInsfDvCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pf_skd_tp_cd", getPfSkdTpCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("insf_id", getInsfId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("skd_sts_cd", getSkdStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("skd_voy_tp_cd", getSkdVoyTpCd());
		this.hashColumns.put("skd_rmk", getSkdRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("if_mnpl_cd", getIfMnplCd());
		this.hashColumns.put("insf_cnqe_val", getInsfCnqeVal());
		this.hashColumns.put("n1st_port_brth_dt", getN1stPortBrthDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("skd_sts_mnl_flg", getSkdStsMnlFlg());
		this.hashColumns.put("insf_dttm", getInsfDttm());
		this.hashColumns.put("act_crr_cd", getActCrrCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("insf_prs_id", getInsfPrsId());
		this.hashColumns.put("st_port_cd", getStPortCd());
		this.hashColumns.put("ibis_if_seq", getIbisIfSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("insf_dv_cd", "insfDvCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pf_skd_tp_cd", "pfSkdTpCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("insf_id", "insfId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("skd_sts_cd", "skdStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("skd_voy_tp_cd", "skdVoyTpCd");
		this.hashFields.put("skd_rmk", "skdRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("if_mnpl_cd", "ifMnplCd");
		this.hashFields.put("insf_cnqe_val", "insfCnqeVal");
		this.hashFields.put("n1st_port_brth_dt", "n1stPortBrthDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("skd_sts_mnl_flg", "skdStsMnlFlg");
		this.hashFields.put("insf_dttm", "insfDttm");
		this.hashFields.put("act_crr_cd", "actCrrCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("insf_prs_id", "insfPrsId");
		this.hashFields.put("st_port_cd", "stPortCd");
		this.hashFields.put("ibis_if_seq", "ibisIfSeq");
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
	 * @return pfSkdTpCd
	 */
	public String getPfSkdTpCd() {
		return this.pfSkdTpCd;
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
	 * @return skdStsCd
	 */
	public String getSkdStsCd() {
		return this.skdStsCd;
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
	 * @return skdVoyTpCd
	 */
	public String getSkdVoyTpCd() {
		return this.skdVoyTpCd;
	}
	
	/**
	 * Column Info
	 * @return skdRmk
	 */
	public String getSkdRmk() {
		return this.skdRmk;
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
	 * @return n1stPortBrthDt
	 */
	public String getN1stPortBrthDt() {
		return this.n1stPortBrthDt;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return skdStsMnlFlg
	 */
	public String getSkdStsMnlFlg() {
		return this.skdStsMnlFlg;
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
	 * @return actCrrCd
	 */
	public String getActCrrCd() {
		return this.actCrrCd;
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
	 * @return insfPrsId
	 */
	public String getInsfPrsId() {
		return this.insfPrsId;
	}
	
	/**
	 * Column Info
	 * @return stPortCd
	 */
	public String getStPortCd() {
		return this.stPortCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param pfSkdTpCd
	 */
	public void setPfSkdTpCd(String pfSkdTpCd) {
		this.pfSkdTpCd = pfSkdTpCd;
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
	 * @param skdStsCd
	 */
	public void setSkdStsCd(String skdStsCd) {
		this.skdStsCd = skdStsCd;
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
	 * @param skdVoyTpCd
	 */
	public void setSkdVoyTpCd(String skdVoyTpCd) {
		this.skdVoyTpCd = skdVoyTpCd;
	}
	
	/**
	 * Column Info
	 * @param skdRmk
	 */
	public void setSkdRmk(String skdRmk) {
		this.skdRmk = skdRmk;
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
	 * @param n1stPortBrthDt
	 */
	public void setN1stPortBrthDt(String n1stPortBrthDt) {
		this.n1stPortBrthDt = n1stPortBrthDt;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param skdStsMnlFlg
	 */
	public void setSkdStsMnlFlg(String skdStsMnlFlg) {
		this.skdStsMnlFlg = skdStsMnlFlg;
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
	 * @param actCrrCd
	 */
	public void setActCrrCd(String actCrrCd) {
		this.actCrrCd = actCrrCd;
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
	 * @param insfPrsId
	 */
	public void setInsfPrsId(String insfPrsId) {
		this.insfPrsId = insfPrsId;
	}
	
	/**
	 * Column Info
	 * @param stPortCd
	 */
	public void setStPortCd(String stPortCd) {
		this.stPortCd = stPortCd;
	}
	
	/**
	 * Column Info
	 * @param ibisIfSeq
	 */
	public void setIbisIfSeq(String ibisIfSeq) {
		this.ibisIfSeq = ibisIfSeq;
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
		setInsfDvCd(JSPUtil.getParameter(request, prefix + "insf_dv_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPfSkdTpCd(JSPUtil.getParameter(request, prefix + "pf_skd_tp_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setInsfId(JSPUtil.getParameter(request, prefix + "insf_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSkdStsCd(JSPUtil.getParameter(request, prefix + "skd_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSkdVoyTpCd(JSPUtil.getParameter(request, prefix + "skd_voy_tp_cd", ""));
		setSkdRmk(JSPUtil.getParameter(request, prefix + "skd_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIfMnplCd(JSPUtil.getParameter(request, prefix + "if_mnpl_cd", ""));
		setInsfCnqeVal(JSPUtil.getParameter(request, prefix + "insf_cnqe_val", ""));
		setN1stPortBrthDt(JSPUtil.getParameter(request, prefix + "n1st_port_brth_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setSkdStsMnlFlg(JSPUtil.getParameter(request, prefix + "skd_sts_mnl_flg", ""));
		setInsfDttm(JSPUtil.getParameter(request, prefix + "insf_dttm", ""));
		setActCrrCd(JSPUtil.getParameter(request, prefix + "act_crr_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setInsfPrsId(JSPUtil.getParameter(request, prefix + "insf_prs_id", ""));
		setStPortCd(JSPUtil.getParameter(request, prefix + "st_port_cd", ""));
		setIbisIfSeq(JSPUtil.getParameter(request, prefix + "ibis_if_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VskVslSkdIbisIfVO[]
	 */
	public VskVslSkdIbisIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VskVslSkdIbisIfVO[]
	 */
	public VskVslSkdIbisIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VskVslSkdIbisIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] insfDvCd = (JSPUtil.getParameter(request, prefix	+ "insf_dv_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pfSkdTpCd = (JSPUtil.getParameter(request, prefix	+ "pf_skd_tp_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] insfId = (JSPUtil.getParameter(request, prefix	+ "insf_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] skdStsCd = (JSPUtil.getParameter(request, prefix	+ "skd_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] skdVoyTpCd = (JSPUtil.getParameter(request, prefix	+ "skd_voy_tp_cd", length));
			String[] skdRmk = (JSPUtil.getParameter(request, prefix	+ "skd_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ifMnplCd = (JSPUtil.getParameter(request, prefix	+ "if_mnpl_cd", length));
			String[] insfCnqeVal = (JSPUtil.getParameter(request, prefix	+ "insf_cnqe_val", length));
			String[] n1stPortBrthDt = (JSPUtil.getParameter(request, prefix	+ "n1st_port_brth_dt", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] skdStsMnlFlg = (JSPUtil.getParameter(request, prefix	+ "skd_sts_mnl_flg", length));
			String[] insfDttm = (JSPUtil.getParameter(request, prefix	+ "insf_dttm", length));
			String[] actCrrCd = (JSPUtil.getParameter(request, prefix	+ "act_crr_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] insfPrsId = (JSPUtil.getParameter(request, prefix	+ "insf_prs_id", length));
			String[] stPortCd = (JSPUtil.getParameter(request, prefix	+ "st_port_cd", length));
			String[] ibisIfSeq = (JSPUtil.getParameter(request, prefix	+ "ibis_if_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new VskVslSkdIbisIfVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (insfDvCd[i] != null)
					model.setInsfDvCd(insfDvCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pfSkdTpCd[i] != null)
					model.setPfSkdTpCd(pfSkdTpCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (insfId[i] != null)
					model.setInsfId(insfId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (skdStsCd[i] != null)
					model.setSkdStsCd(skdStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (skdVoyTpCd[i] != null)
					model.setSkdVoyTpCd(skdVoyTpCd[i]);
				if (skdRmk[i] != null)
					model.setSkdRmk(skdRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ifMnplCd[i] != null)
					model.setIfMnplCd(ifMnplCd[i]);
				if (insfCnqeVal[i] != null)
					model.setInsfCnqeVal(insfCnqeVal[i]);
				if (n1stPortBrthDt[i] != null)
					model.setN1stPortBrthDt(n1stPortBrthDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (skdStsMnlFlg[i] != null)
					model.setSkdStsMnlFlg(skdStsMnlFlg[i]);
				if (insfDttm[i] != null)
					model.setInsfDttm(insfDttm[i]);
				if (actCrrCd[i] != null)
					model.setActCrrCd(actCrrCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (insfPrsId[i] != null)
					model.setInsfPrsId(insfPrsId[i]);
				if (stPortCd[i] != null)
					model.setStPortCd(stPortCd[i]);
				if (ibisIfSeq[i] != null)
					model.setIbisIfSeq(ibisIfSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVskVslSkdIbisIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VskVslSkdIbisIfVO[]
	 */
	public VskVslSkdIbisIfVO[] getVskVslSkdIbisIfVOs(){
		VskVslSkdIbisIfVO[] vos = (VskVslSkdIbisIfVO[])models.toArray(new VskVslSkdIbisIfVO[models.size()]);
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
		this.insfDvCd = this.insfDvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pfSkdTpCd = this.pfSkdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfId = this.insfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdStsCd = this.skdStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyTpCd = this.skdVoyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdRmk = this.skdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifMnplCd = this.ifMnplCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfCnqeVal = this.insfCnqeVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPortBrthDt = this.n1stPortBrthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdStsMnlFlg = this.skdStsMnlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfDttm = this.insfDttm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCrrCd = this.actCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insfPrsId = this.insfPrsId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stPortCd = this.stPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibisIfSeq = this.ibisIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
