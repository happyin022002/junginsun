/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltSearchSCListVO.java
*@FileTitle : RsltSearchSCListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 류선우
*@LastVersion : 1.0
* 2010.04.09 류선우 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 류선우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchSCListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchSCListVO> models = new ArrayList<RsltSearchSCListVO>();
	
	/* Column Info */
	private String rfFlg = null;
	/* Column Info */
	private String fileDt = null;
	/* Column Info */
	private String fnlMqcQty = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String lgcyIfFlg = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String gamtFlg = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String ctrtCustSlsOfcCd = null;
	/* Column Info */
	private String propAproOfcCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ctrtCustSrepCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String ctrtExpDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchSCListVO() {}

	public RsltSearchSCListVO(String ibflag, String pagerows, String scNo, String propNo, String amdtSeq, String svcScpCd, String ctrtPtyNm, String prcCtrtCustTpCd, String fnlMqcQty, String propAproOfcCd, String ctrtCustSlsOfcCd, String ctrtCustSrepCd, String ctrtEffDt, String ctrtExpDt, String fileDt, String lgcyIfFlg, String rfFlg, String gamtFlg, String effDt, String expDt) {
		this.rfFlg = rfFlg;
		this.fileDt = fileDt;
		this.fnlMqcQty = fnlMqcQty;
		this.ctrtEffDt = ctrtEffDt;
		this.lgcyIfFlg = lgcyIfFlg;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.pagerows = pagerows;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.gamtFlg = gamtFlg;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.ctrtPtyNm = ctrtPtyNm;
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
		this.propAproOfcCd = propAproOfcCd;
		this.propNo = propNo;
		this.scNo = scNo;
		this.ctrtCustSrepCd = ctrtCustSrepCd;
		this.expDt = expDt;
		this.ctrtExpDt = ctrtExpDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rf_flg", getRfFlg());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("fnl_mqc_qty", getFnlMqcQty());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("lgcy_if_flg", getLgcyIfFlg());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("gamt_flg", getGamtFlg());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("ctrt_cust_sls_ofc_cd", getCtrtCustSlsOfcCd());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ctrt_cust_srep_cd", getCtrtCustSrepCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rf_flg", "rfFlg");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("fnl_mqc_qty", "fnlMqcQty");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("lgcy_if_flg", "lgcyIfFlg");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("gamt_flg", "gamtFlg");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("ctrt_cust_sls_ofc_cd", "ctrtCustSlsOfcCd");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ctrt_cust_srep_cd", "ctrtCustSrepCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rfFlg
	 */
	public String getRfFlg() {
		return this.rfFlg;
	}
	
	/**
	 * Column Info
	 * @return fileDt
	 */
	public String getFileDt() {
		return this.fileDt;
	}
	
	/**
	 * Column Info
	 * @return fnlMqcQty
	 */
	public String getFnlMqcQty() {
		return this.fnlMqcQty;
	}
	
	/**
	 * Column Info
	 * @return ctrtEffDt
	 */
	public String getCtrtEffDt() {
		return this.ctrtEffDt;
	}
	
	/**
	 * Column Info
	 * @return lgcyIfFlg
	 */
	public String getLgcyIfFlg() {
		return this.lgcyIfFlg;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return prcCtrtCustTpCd
	 */
	public String getPrcCtrtCustTpCd() {
		return this.prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return gamtFlg
	 */
	public String getGamtFlg() {
		return this.gamtFlg;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return ctrtPtyNm
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSlsOfcCd
	 */
	public String getCtrtCustSlsOfcCd() {
		return this.ctrtCustSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return propAproOfcCd
	 */
	public String getPropAproOfcCd() {
		return this.propAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSrepCd
	 */
	public String getCtrtCustSrepCd() {
		return this.ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
	}
	

	/**
	 * Column Info
	 * @param rfFlg
	 */
	public void setRfFlg(String rfFlg) {
		this.rfFlg = rfFlg;
	}
	
	/**
	 * Column Info
	 * @param fileDt
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
	}
	
	/**
	 * Column Info
	 * @param fnlMqcQty
	 */
	public void setFnlMqcQty(String fnlMqcQty) {
		this.fnlMqcQty = fnlMqcQty;
	}
	
	/**
	 * Column Info
	 * @param ctrtEffDt
	 */
	public void setCtrtEffDt(String ctrtEffDt) {
		this.ctrtEffDt = ctrtEffDt;
	}
	
	/**
	 * Column Info
	 * @param lgcyIfFlg
	 */
	public void setLgcyIfFlg(String lgcyIfFlg) {
		this.lgcyIfFlg = lgcyIfFlg;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param prcCtrtCustTpCd
	 */
	public void setPrcCtrtCustTpCd(String prcCtrtCustTpCd) {
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param gamtFlg
	 */
	public void setGamtFlg(String gamtFlg) {
		this.gamtFlg = gamtFlg;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param ctrtPtyNm
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSlsOfcCd
	 */
	public void setCtrtCustSlsOfcCd(String ctrtCustSlsOfcCd) {
		this.ctrtCustSlsOfcCd = ctrtCustSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param propAproOfcCd
	 */
	public void setPropAproOfcCd(String propAproOfcCd) {
		this.propAproOfcCd = propAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSrepCd
	 */
	public void setCtrtCustSrepCd(String ctrtCustSrepCd) {
		this.ctrtCustSrepCd = ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
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
		setRfFlg(JSPUtil.getParameter(request, prefix + "rf_flg", ""));
		setFileDt(JSPUtil.getParameter(request, prefix + "file_dt", ""));
		setFnlMqcQty(JSPUtil.getParameter(request, prefix + "fnl_mqc_qty", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setLgcyIfFlg(JSPUtil.getParameter(request, prefix + "lgcy_if_flg", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_cd", ""));
		setGamtFlg(JSPUtil.getParameter(request, prefix + "gamt_flg", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_nm", ""));
		setCtrtCustSlsOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_sls_ofc_cd", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request, prefix + "prop_apro_ofc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCtrtCustSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_srep_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchSCListVO[]
	 */
	public RsltSearchSCListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchSCListVO[]
	 */
	public RsltSearchSCListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchSCListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rfFlg = (JSPUtil.getParameter(request, prefix	+ "rf_flg", length));
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt", length));
			String[] fnlMqcQty = (JSPUtil.getParameter(request, prefix	+ "fnl_mqc_qty", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] lgcyIfFlg = (JSPUtil.getParameter(request, prefix	+ "lgcy_if_flg", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] gamtFlg = (JSPUtil.getParameter(request, prefix	+ "gamt_flg", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] ctrtCustSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_sls_ofc_cd", length));
			String[] propAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_apro_ofc_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ctrtCustSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchSCListVO();
				if (rfFlg[i] != null)
					model.setRfFlg(rfFlg[i]);
				if (fileDt[i] != null)
					model.setFileDt(fileDt[i]);
				if (fnlMqcQty[i] != null)
					model.setFnlMqcQty(fnlMqcQty[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (lgcyIfFlg[i] != null)
					model.setLgcyIfFlg(lgcyIfFlg[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (gamtFlg[i] != null)
					model.setGamtFlg(gamtFlg[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (ctrtCustSlsOfcCd[i] != null)
					model.setCtrtCustSlsOfcCd(ctrtCustSlsOfcCd[i]);
				if (propAproOfcCd[i] != null)
					model.setPropAproOfcCd(propAproOfcCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ctrtCustSrepCd[i] != null)
					model.setCtrtCustSrepCd(ctrtCustSrepCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchSCListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchSCListVO[]
	 */
	public RsltSearchSCListVO[] getRsltSearchSCListVOs(){
		RsltSearchSCListVO[] vos = (RsltSearchSCListVO[])models.toArray(new RsltSearchSCListVO[models.size()]);
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
		this.rfFlg = this.rfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlMqcQty = this.fnlMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgcyIfFlg = this.lgcyIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gamtFlg = this.gamtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSlsOfcCd = this.ctrtCustSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd = this.propAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepCd = this.ctrtCustSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
