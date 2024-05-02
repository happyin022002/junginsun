/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SlipPerfVO.java
*@FileTitle : SlipPerfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.01.08 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemcommon.gemcommon.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SlipPerfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SlipPerfVO> models = new ArrayList<SlipPerfVO>();
	
	/* Column Info */
	private String rsltYrmon = null;
	/* Column Info */
	private String prprUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String slpCurrCd = null;
	/* Column Info */
	private String slpCtrCd = null;
	/* Column Info */
	private String slpDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slpVndrCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String ofcCurrCd = null;
	/* Column Info */
	private String slpTjNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String slpAmt = null;
	/* Column Info */
	private String glEffDt = null;
	/* Column Info */
	private String genExpnFnlLoclAmt = null;
	/* Column Info */
	private String subOfcCd = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String slpSeqNo = null;
	/* Column Info */
	private String slpPerfAmt = null;
	/* Column Info */
	private String subGenExpnCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String aproUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SlipPerfVO() {}

	public SlipPerfVO(String ibflag, String pagerows, String slpTjNo, String slpSeqNo, String rsltYrmon, String ofcCd, String ofcCurrCd, String subOfcCd, String genExpnCd, String subGenExpnCd, String acctCd, String slpCtrCd, String slpCurrCd, String slpAmt, String slpVndrCd, String glEffDt, String genExpnFnlLoclAmt, String slpPerfAmt, String slpDesc, String prprUsrId, String aproUsrId, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.rsltYrmon = rsltYrmon;
		this.prprUsrId = prprUsrId;
		this.creDt = creDt;
		this.slpCurrCd = slpCurrCd;
		this.slpCtrCd = slpCtrCd;
		this.slpDesc = slpDesc;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.slpVndrCd = slpVndrCd;
		this.acctCd = acctCd;
		this.ofcCurrCd = ofcCurrCd;
		this.slpTjNo = slpTjNo;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.slpAmt = slpAmt;
		this.glEffDt = glEffDt;
		this.genExpnFnlLoclAmt = genExpnFnlLoclAmt;
		this.subOfcCd = subOfcCd;
		this.genExpnCd = genExpnCd;
		this.slpSeqNo = slpSeqNo;
		this.slpPerfAmt = slpPerfAmt;
		this.subGenExpnCd = subGenExpnCd;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rslt_yrmon", getRsltYrmon());
		this.hashColumns.put("prpr_usr_id", getPrprUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("slp_curr_cd", getSlpCurrCd());
		this.hashColumns.put("slp_ctr_cd", getSlpCtrCd());
		this.hashColumns.put("slp_desc", getSlpDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slp_vndr_cd", getSlpVndrCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("ofc_curr_cd", getOfcCurrCd());
		this.hashColumns.put("slp_tj_no", getSlpTjNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("slp_amt", getSlpAmt());
		this.hashColumns.put("gl_eff_dt", getGlEffDt());
		this.hashColumns.put("gen_expn_fnl_locl_amt", getGenExpnFnlLoclAmt());
		this.hashColumns.put("sub_ofc_cd", getSubOfcCd());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());
		this.hashColumns.put("slp_perf_amt", getSlpPerfAmt());
		this.hashColumns.put("sub_gen_expn_cd", getSubGenExpnCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rslt_yrmon", "rsltYrmon");
		this.hashFields.put("prpr_usr_id", "prprUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("slp_curr_cd", "slpCurrCd");
		this.hashFields.put("slp_ctr_cd", "slpCtrCd");
		this.hashFields.put("slp_desc", "slpDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slp_vndr_cd", "slpVndrCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("ofc_curr_cd", "ofcCurrCd");
		this.hashFields.put("slp_tj_no", "slpTjNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("slp_amt", "slpAmt");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("gen_expn_fnl_locl_amt", "genExpnFnlLoclAmt");
		this.hashFields.put("sub_ofc_cd", "subOfcCd");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("slp_perf_amt", "slpPerfAmt");
		this.hashFields.put("sub_gen_expn_cd", "subGenExpnCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rsltYrmon
	 */
	public String getRsltYrmon() {
		return this.rsltYrmon;
	}
	
	/**
	 * Column Info
	 * @return prprUsrId
	 */
	public String getPrprUsrId() {
		return this.prprUsrId;
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
	 * @return slpCurrCd
	 */
	public String getSlpCurrCd() {
		return this.slpCurrCd;
	}
	
	/**
	 * Column Info
	 * @return slpCtrCd
	 */
	public String getSlpCtrCd() {
		return this.slpCtrCd;
	}
	
	/**
	 * Column Info
	 * @return slpDesc
	 */
	public String getSlpDesc() {
		return this.slpDesc;
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
	 * @return slpVndrCd
	 */
	public String getSlpVndrCd() {
		return this.slpVndrCd;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCurrCd
	 */
	public String getOfcCurrCd() {
		return this.ofcCurrCd;
	}
	
	/**
	 * Column Info
	 * @return slpTjNo
	 */
	public String getSlpTjNo() {
		return this.slpTjNo;
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
	 * @return slpAmt
	 */
	public String getSlpAmt() {
		return this.slpAmt;
	}
	
	/**
	 * Column Info
	 * @return glEffDt
	 */
	public String getGlEffDt() {
		return this.glEffDt;
	}
	
	/**
	 * Column Info
	 * @return genExpnFnlLoclAmt
	 */
	public String getGenExpnFnlLoclAmt() {
		return this.genExpnFnlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return subOfcCd
	 */
	public String getSubOfcCd() {
		return this.subOfcCd;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	
	/**
	 * Column Info
	 * @return slpSeqNo
	 */
	public String getSlpSeqNo() {
		return this.slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @return slpPerfAmt
	 */
	public String getSlpPerfAmt() {
		return this.slpPerfAmt;
	}
	
	/**
	 * Column Info
	 * @return subGenExpnCd
	 */
	public String getSubGenExpnCd() {
		return this.subGenExpnCd;
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
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	

	/**
	 * Column Info
	 * @param rsltYrmon
	 */
	public void setRsltYrmon(String rsltYrmon) {
		this.rsltYrmon = rsltYrmon;
	}
	
	/**
	 * Column Info
	 * @param prprUsrId
	 */
	public void setPrprUsrId(String prprUsrId) {
		this.prprUsrId = prprUsrId;
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
	 * @param slpCurrCd
	 */
	public void setSlpCurrCd(String slpCurrCd) {
		this.slpCurrCd = slpCurrCd;
	}
	
	/**
	 * Column Info
	 * @param slpCtrCd
	 */
	public void setSlpCtrCd(String slpCtrCd) {
		this.slpCtrCd = slpCtrCd;
	}
	
	/**
	 * Column Info
	 * @param slpDesc
	 */
	public void setSlpDesc(String slpDesc) {
		this.slpDesc = slpDesc;
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
	 * @param slpVndrCd
	 */
	public void setSlpVndrCd(String slpVndrCd) {
		this.slpVndrCd = slpVndrCd;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCurrCd
	 */
	public void setOfcCurrCd(String ofcCurrCd) {
		this.ofcCurrCd = ofcCurrCd;
	}
	
	/**
	 * Column Info
	 * @param slpTjNo
	 */
	public void setSlpTjNo(String slpTjNo) {
		this.slpTjNo = slpTjNo;
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
	 * @param slpAmt
	 */
	public void setSlpAmt(String slpAmt) {
		this.slpAmt = slpAmt;
	}
	
	/**
	 * Column Info
	 * @param glEffDt
	 */
	public void setGlEffDt(String glEffDt) {
		this.glEffDt = glEffDt;
	}
	
	/**
	 * Column Info
	 * @param genExpnFnlLoclAmt
	 */
	public void setGenExpnFnlLoclAmt(String genExpnFnlLoclAmt) {
		this.genExpnFnlLoclAmt = genExpnFnlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param subOfcCd
	 */
	public void setSubOfcCd(String subOfcCd) {
		this.subOfcCd = subOfcCd;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}
	
	/**
	 * Column Info
	 * @param slpSeqNo
	 */
	public void setSlpSeqNo(String slpSeqNo) {
		this.slpSeqNo = slpSeqNo;
	}
	
	/**
	 * Column Info
	 * @param slpPerfAmt
	 */
	public void setSlpPerfAmt(String slpPerfAmt) {
		this.slpPerfAmt = slpPerfAmt;
	}
	
	/**
	 * Column Info
	 * @param subGenExpnCd
	 */
	public void setSubGenExpnCd(String subGenExpnCd) {
		this.subGenExpnCd = subGenExpnCd;
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
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
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
		setRsltYrmon(JSPUtil.getParameter(request, prefix + "rslt_yrmon", ""));
		setPrprUsrId(JSPUtil.getParameter(request, prefix + "prpr_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSlpCurrCd(JSPUtil.getParameter(request, prefix + "slp_curr_cd", ""));
		setSlpCtrCd(JSPUtil.getParameter(request, prefix + "slp_ctr_cd", ""));
		setSlpDesc(JSPUtil.getParameter(request, prefix + "slp_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlpVndrCd(JSPUtil.getParameter(request, prefix + "slp_vndr_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setOfcCurrCd(JSPUtil.getParameter(request, prefix + "ofc_curr_cd", ""));
		setSlpTjNo(JSPUtil.getParameter(request, prefix + "slp_tj_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSlpAmt(JSPUtil.getParameter(request, prefix + "slp_amt", ""));
		setGlEffDt(JSPUtil.getParameter(request, prefix + "gl_eff_dt", ""));
		setGenExpnFnlLoclAmt(JSPUtil.getParameter(request, prefix + "gen_expn_fnl_locl_amt", ""));
		setSubOfcCd(JSPUtil.getParameter(request, prefix + "sub_ofc_cd", ""));
		setGenExpnCd(JSPUtil.getParameter(request, prefix + "gen_expn_cd", ""));
		setSlpSeqNo(JSPUtil.getParameter(request, prefix + "slp_seq_no", ""));
		setSlpPerfAmt(JSPUtil.getParameter(request, prefix + "slp_perf_amt", ""));
		setSubGenExpnCd(JSPUtil.getParameter(request, prefix + "sub_gen_expn_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SlipPerfVO[]
	 */
	public SlipPerfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SlipPerfVO[]
	 */
	public SlipPerfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SlipPerfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rsltYrmon = (JSPUtil.getParameter(request, prefix	+ "rslt_yrmon", length));
			String[] prprUsrId = (JSPUtil.getParameter(request, prefix	+ "prpr_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] slpCurrCd = (JSPUtil.getParameter(request, prefix	+ "slp_curr_cd", length));
			String[] slpCtrCd = (JSPUtil.getParameter(request, prefix	+ "slp_ctr_cd", length));
			String[] slpDesc = (JSPUtil.getParameter(request, prefix	+ "slp_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slpVndrCd = (JSPUtil.getParameter(request, prefix	+ "slp_vndr_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] ofcCurrCd = (JSPUtil.getParameter(request, prefix	+ "ofc_curr_cd", length));
			String[] slpTjNo = (JSPUtil.getParameter(request, prefix	+ "slp_tj_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] slpAmt = (JSPUtil.getParameter(request, prefix	+ "slp_amt", length));
			String[] glEffDt = (JSPUtil.getParameter(request, prefix	+ "gl_eff_dt", length));
			String[] genExpnFnlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "gen_expn_fnl_locl_amt", length));
			String[] subOfcCd = (JSPUtil.getParameter(request, prefix	+ "sub_ofc_cd", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] slpSeqNo = (JSPUtil.getParameter(request, prefix	+ "slp_seq_no", length));
			String[] slpPerfAmt = (JSPUtil.getParameter(request, prefix	+ "slp_perf_amt", length));
			String[] subGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "sub_gen_expn_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SlipPerfVO();
				if (rsltYrmon[i] != null)
					model.setRsltYrmon(rsltYrmon[i]);
				if (prprUsrId[i] != null)
					model.setPrprUsrId(prprUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (slpCurrCd[i] != null)
					model.setSlpCurrCd(slpCurrCd[i]);
				if (slpCtrCd[i] != null)
					model.setSlpCtrCd(slpCtrCd[i]);
				if (slpDesc[i] != null)
					model.setSlpDesc(slpDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slpVndrCd[i] != null)
					model.setSlpVndrCd(slpVndrCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (ofcCurrCd[i] != null)
					model.setOfcCurrCd(ofcCurrCd[i]);
				if (slpTjNo[i] != null)
					model.setSlpTjNo(slpTjNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (slpAmt[i] != null)
					model.setSlpAmt(slpAmt[i]);
				if (glEffDt[i] != null)
					model.setGlEffDt(glEffDt[i]);
				if (genExpnFnlLoclAmt[i] != null)
					model.setGenExpnFnlLoclAmt(genExpnFnlLoclAmt[i]);
				if (subOfcCd[i] != null)
					model.setSubOfcCd(subOfcCd[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (slpSeqNo[i] != null)
					model.setSlpSeqNo(slpSeqNo[i]);
				if (slpPerfAmt[i] != null)
					model.setSlpPerfAmt(slpPerfAmt[i]);
				if (subGenExpnCd[i] != null)
					model.setSubGenExpnCd(subGenExpnCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSlipPerfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SlipPerfVO[]
	 */
	public SlipPerfVO[] getSlipPerfVOs(){
		SlipPerfVO[] vos = (SlipPerfVO[])models.toArray(new SlipPerfVO[models.size()]);
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
		this.rsltYrmon = this.rsltYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prprUsrId = this.prprUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpCurrCd = this.slpCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpCtrCd = this.slpCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpDesc = this.slpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpVndrCd = this.slpVndrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCurrCd = this.ofcCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTjNo = this.slpTjNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpAmt = this.slpAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt = this.glEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnFnlLoclAmt = this.genExpnFnlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subOfcCd = this.subOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo = this.slpSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpPerfAmt = this.slpPerfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subGenExpnCd = this.subGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
