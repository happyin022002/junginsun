/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffRateVO.java
*@FileTitle : TariffRateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.06.25 김태균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo;

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
 * @author 김태균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TariffRateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TariffRateVO> models = new ArrayList<TariffRateVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntrHcRtAmt = null;
	/* Column Info */
	private String trfRtSeq = null;
	/* Column Info */
	private String cntr20ftRtAmt = null;
	/* Column Info */
	private String cntr45ftRtAmt = null;
	/* Column Info */
	private String ftOvrDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cntr40ftRtAmt = null;
	/* Column Info */
	private String ftUndDys = null;
	/* Column Info */
	private String trfGrpSeq = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String trfSeq = null;
	/* Column Info */
	private String cntrR9RtAmt = null;
	/* Column Info */
	private String dmdtDeTermCd = null;
	/* Column Info */
	private String dmdtDeTermNm = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TariffRateVO() {}

	public TariffRateVO(String ibflag, String pagerows, String svrId, String dmdtTrfCd, String trfSeq, String trfGrpSeq, String trfRtSeq, String ftOvrDys, String ftUndDys, String cntr20ftRtAmt, String cntr40ftRtAmt, String cntrHcRtAmt, String cntr45ftRtAmt, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String usrId, String ofcCd, String cntrR9RtAmt, String dmdtDeTermCd, String dmdtDeTermNm) {
		this.updDt = updDt;
		this.creDt = creDt;
		this.cntrHcRtAmt = cntrHcRtAmt;
		this.trfRtSeq = trfRtSeq;
		this.cntr20ftRtAmt = cntr20ftRtAmt;
		this.cntr45ftRtAmt = cntr45ftRtAmt;
		this.ftOvrDys = ftOvrDys;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.svrId = svrId;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.creOfcCd = creOfcCd;
		this.cntr40ftRtAmt = cntr40ftRtAmt;
		this.ftUndDys = ftUndDys;
		this.trfGrpSeq = trfGrpSeq;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.dmdtTrfCd = dmdtTrfCd;
		this.trfSeq = trfSeq;
		this.cntrR9RtAmt = cntrR9RtAmt;
		this.dmdtDeTermCd = dmdtDeTermCd;
		this.dmdtDeTermNm = dmdtDeTermNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntr_hc_rt_amt", getCntrHcRtAmt());
		this.hashColumns.put("trf_rt_seq", getTrfRtSeq());
		this.hashColumns.put("cntr_20ft_rt_amt", getCntr20ftRtAmt());
		this.hashColumns.put("cntr_45ft_rt_amt", getCntr45ftRtAmt());
		this.hashColumns.put("ft_ovr_dys", getFtOvrDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cntr_40ft_rt_amt", getCntr40ftRtAmt());
		this.hashColumns.put("ft_und_dys", getFtUndDys());
		this.hashColumns.put("trf_grp_seq", getTrfGrpSeq());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("trf_seq", getTrfSeq());
		this.hashColumns.put("cntr_r9_rt_amt", getCntrR9RtAmt());
		this.hashColumns.put("dmdt_de_term_cd", getDmdtDeTermCd());
		this.hashColumns.put("dmdt_de_term_nm", getDmdtDeTermNm());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntr_hc_rt_amt", "cntrHcRtAmt");
		this.hashFields.put("trf_rt_seq", "trfRtSeq");
		this.hashFields.put("cntr_20ft_rt_amt", "cntr20ftRtAmt");
		this.hashFields.put("cntr_45ft_rt_amt", "cntr45ftRtAmt");
		this.hashFields.put("ft_ovr_dys", "ftOvrDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cntr_40ft_rt_amt", "cntr40ftRtAmt");
		this.hashFields.put("ft_und_dys", "ftUndDys");
		this.hashFields.put("trf_grp_seq", "trfGrpSeq");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("trf_seq", "trfSeq");
		this.hashFields.put("cntr_r9_rt_amt", "cntrR9RtAmt");
		this.hashFields.put("dmdt_de_term_cd", "dmdtDeTermCd");
		this.hashFields.put("dmdt_de_term_nm", "dmdtDeTermNm");
		
		return this.hashFields;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return cntrHcRtAmt
	 */
	public String getCntrHcRtAmt() {
		return this.cntrHcRtAmt;
	}
	
	/**
	 * Column Info
	 * @return trfRtSeq
	 */
	public String getTrfRtSeq() {
		return this.trfRtSeq;
	}
	
	/**
	 * Column Info
	 * @return cntr20ftRtAmt
	 */
	public String getCntr20ftRtAmt() {
		return this.cntr20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cntr45ftRtAmt
	 */
	public String getCntr45ftRtAmt() {
		return this.cntr45ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ftOvrDys
	 */
	public String getFtOvrDys() {
		return this.ftOvrDys;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntr40ftRtAmt
	 */
	public String getCntr40ftRtAmt() {
		return this.cntr40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ftUndDys
	 */
	public String getFtUndDys() {
		return this.ftUndDys;
	}
	
	/**
	 * Column Info
	 * @return trfGrpSeq
	 */
	public String getTrfGrpSeq() {
		return this.trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return trfSeq
	 */
	public String getTrfSeq() {
		return this.trfSeq;
	}
	
	/**
	 * Column Info
	 * @return trfSeq
	 */	

	public String getCntrR9RtAmt() {
		return cntrR9RtAmt;
	}

	/**
	 * Column Info
	 * @return dmdtDeTermCd
	 */	

	public String getDmdtDeTermCd() {
		return dmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeTermNm
	 */	

	public String getDmdtDeTermNm() {
		return dmdtDeTermNm;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param cntrHcRtAmt
	 */
	public void setCntrHcRtAmt(String cntrHcRtAmt) {
		this.cntrHcRtAmt = cntrHcRtAmt;
	}
	
	/**
	 * Column Info
	 * @param trfRtSeq
	 */
	public void setTrfRtSeq(String trfRtSeq) {
		this.trfRtSeq = trfRtSeq;
	}
	
	/**
	 * Column Info
	 * @param cntr20ftRtAmt
	 */
	public void setCntr20ftRtAmt(String cntr20ftRtAmt) {
		this.cntr20ftRtAmt = cntr20ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cntr45ftRtAmt
	 */
	public void setCntr45ftRtAmt(String cntr45ftRtAmt) {
		this.cntr45ftRtAmt = cntr45ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ftOvrDys
	 */
	public void setFtOvrDys(String ftOvrDys) {
		this.ftOvrDys = ftOvrDys;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntr40ftRtAmt
	 */
	public void setCntr40ftRtAmt(String cntr40ftRtAmt) {
		this.cntr40ftRtAmt = cntr40ftRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ftUndDys
	 */
	public void setFtUndDys(String ftUndDys) {
		this.ftUndDys = ftUndDys;
	}
	
	/**
	 * Column Info
	 * @param trfGrpSeq
	 */
	public void setTrfGrpSeq(String trfGrpSeq) {
		this.trfGrpSeq = trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param trfSeq
	 */
	public void setTrfSeq(String trfSeq) {
		this.trfSeq = trfSeq;
	}
	
	/**
	 * Column Info
	 * @return trfSeq
	 */	
	public void setCntrR9RtAmt(String cntrR9RtAmt) {
		this.cntrR9RtAmt = cntrR9RtAmt;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeTermCd
	 */	
	public void setDmdtDeTermCd(String dmdtDeTermCd) {
		this.dmdtDeTermCd = dmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtDeTermNm
	 */	
	public void setDmdtDeTermNm(String dmdtDeTermNm) {
		this.dmdtDeTermNm = dmdtDeTermNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCntrHcRtAmt(JSPUtil.getParameter(request, "cntr_hc_rt_amt", ""));
		setTrfRtSeq(JSPUtil.getParameter(request, "trf_rt_seq", ""));
		setCntr20ftRtAmt(JSPUtil.getParameter(request, "cntr_20ft_rt_amt", ""));
		setCntr45ftRtAmt(JSPUtil.getParameter(request, "cntr_45ft_rt_amt", ""));
		setFtOvrDys(JSPUtil.getParameter(request, "ft_ovr_dys", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCntr40ftRtAmt(JSPUtil.getParameter(request, "cntr_40ft_rt_amt", ""));
		setFtUndDys(JSPUtil.getParameter(request, "ft_und_dys", ""));
		setTrfGrpSeq(JSPUtil.getParameter(request, "trf_grp_seq", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setTrfSeq(JSPUtil.getParameter(request, "trf_seq", ""));
		setCntrR9RtAmt(JSPUtil.getParameter(request, "cntr_r9_rt_amt", ""));
		setDmdtDeTermCd(JSPUtil.getParameter(request, "dmdt_de_term_cd", ""));
		setDmdtDeTermNm(JSPUtil.getParameter(request, "dmdt_de_term_nm", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TariffRateVO[]
	 */
	public TariffRateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TariffRateVO[]
	 */
	public TariffRateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TariffRateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntrHcRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_hc_rt_amt", length));
			String[] trfRtSeq = (JSPUtil.getParameter(request, prefix	+ "trf_rt_seq", length));
			String[] cntr20ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_20ft_rt_amt", length));
			String[] cntr45ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_45ft_rt_amt", length));
			String[] ftOvrDys = (JSPUtil.getParameter(request, prefix	+ "ft_ovr_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cntr40ftRtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_40ft_rt_amt", length));
			String[] ftUndDys = (JSPUtil.getParameter(request, prefix	+ "ft_und_dys", length));
			String[] trfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "trf_grp_seq", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] trfSeq = (JSPUtil.getParameter(request, prefix	+ "trf_seq", length));
			String[] cntrR9RtAmt = (JSPUtil.getParameter(request, prefix	+ "cntr_r9_rt_amt", length));
			String[] dmdtDeTermCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_cd", length));
			String[] dmdtDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new TariffRateVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntrHcRtAmt[i] != null)
					model.setCntrHcRtAmt(cntrHcRtAmt[i]);
				if (trfRtSeq[i] != null)
					model.setTrfRtSeq(trfRtSeq[i]);
				if (cntr20ftRtAmt[i] != null)
					model.setCntr20ftRtAmt(cntr20ftRtAmt[i]);
				if (cntr45ftRtAmt[i] != null)
					model.setCntr45ftRtAmt(cntr45ftRtAmt[i]);
				if (ftOvrDys[i] != null)
					model.setFtOvrDys(ftOvrDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cntr40ftRtAmt[i] != null)
					model.setCntr40ftRtAmt(cntr40ftRtAmt[i]);
				if (ftUndDys[i] != null)
					model.setFtUndDys(ftUndDys[i]);
				if (trfGrpSeq[i] != null)
					model.setTrfGrpSeq(trfGrpSeq[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (trfSeq[i] != null)
					model.setTrfSeq(trfSeq[i]);
				if (cntrR9RtAmt[i] != null)
					model.setCntrR9RtAmt(cntrR9RtAmt[i]);
				if (dmdtDeTermCd[i] != null)
					model.setDmdtDeTermCd(dmdtDeTermCd[i]);
				if (dmdtDeTermNm[i] != null)
					model.setDmdtDeTermNm(dmdtDeTermNm[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTariffRateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TariffRateVO[]
	 */
	public TariffRateVO[] getTariffRateVOs(){
		TariffRateVO[] vos = (TariffRateVO[])models.toArray(new TariffRateVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHcRtAmt = this.cntrHcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtSeq = this.trfRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20ftRtAmt = this.cntr20ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""); 
		this.cntr45ftRtAmt = this.cntr45ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftOvrDys = this.ftOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr40ftRtAmt = this.cntr40ftRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftUndDys = this.ftUndDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfGrpSeq = this.trfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfSeq = this.trfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrR9RtAmt = this.cntrR9RtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermCd = this.dmdtDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermNm = this.dmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
