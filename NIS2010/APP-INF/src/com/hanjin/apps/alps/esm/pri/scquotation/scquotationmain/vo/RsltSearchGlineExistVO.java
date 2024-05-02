/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltSearchGlineExistVO.java
*@FileTitle : RsltSearchGlineExistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.23
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.23 이승준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo;

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
 * @author 이승준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchGlineExistVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchGlineExistVO> models = new ArrayList<RsltSearchGlineExistVO>();
	
	/* Column Info */
	private String cmdtTpwChk = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String cmdtTpwDtl = null;
	/* Column Info */
	private String glineSeq = null;
	/* Column Info */
	private String newGrpCmdtDtlSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cmdtTpwMst = null;
	/* Column Info */
	private String grpCmdtDtlSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String locChk = null;
	/* Column Info */
	private String qttnVerNo = null;
	/* Column Info */
	private String qttnNo = null;
	/* Column Info */
	private String cmdtChk = null;
	/* Column Info */
	private String rateChk = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String prcCustTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String newGrpCmdtSeq = null;
	/* Column Info */
	private String grpCmdtSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchGlineExistVO() {}

	public RsltSearchGlineExistVO(String ibflag, String pagerows, String svcScpCd, String glineSeq, String locChk, String cmdtChk, String cmdtTpwChk, String rateChk, String cmdtTpwMst, String grpCmdtDtlSeq, String effDt, String expDt, String prcCustTpCd, String newGrpCmdtSeq, String updUsrId, String cmdtHdrSeq, String cmdtTpwDtl, String newGrpCmdtDtlSeq, String creUsrId, String grpCmdtSeq, String qttnNo, String qttnVerNo) {
		this.cmdtTpwChk = cmdtTpwChk;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.svcScpCd = svcScpCd;
		this.cmdtTpwDtl = cmdtTpwDtl;
		this.glineSeq = glineSeq;
		this.newGrpCmdtDtlSeq = newGrpCmdtDtlSeq;
		this.pagerows = pagerows;
		this.cmdtTpwMst = cmdtTpwMst;
		this.grpCmdtDtlSeq = grpCmdtDtlSeq;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.locChk = locChk;
		this.qttnVerNo = qttnVerNo;
		this.qttnNo = qttnNo;
		this.cmdtChk = cmdtChk;
		this.rateChk = rateChk;
		this.expDt = expDt;
		this.prcCustTpCd = prcCustTpCd;
		this.updUsrId = updUsrId;
		this.newGrpCmdtSeq = newGrpCmdtSeq;
		this.grpCmdtSeq = grpCmdtSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cmdt_tpw_chk", getCmdtTpwChk());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cmdt_tpw_dtl", getCmdtTpwDtl());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("new_grp_cmdt_dtl_seq", getNewGrpCmdtDtlSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cmdt_tpw_mst", getCmdtTpwMst());
		this.hashColumns.put("grp_cmdt_dtl_seq", getGrpCmdtDtlSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("loc_chk", getLocChk());
		this.hashColumns.put("qttn_ver_no", getQttnVerNo());
		this.hashColumns.put("qttn_no", getQttnNo());
		this.hashColumns.put("cmdt_chk", getCmdtChk());
		this.hashColumns.put("rate_chk", getRateChk());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("prc_cust_tp_cd", getPrcCustTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("new_grp_cmdt_seq", getNewGrpCmdtSeq());
		this.hashColumns.put("grp_cmdt_seq", getGrpCmdtSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cmdt_tpw_chk", "cmdtTpwChk");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cmdt_tpw_dtl", "cmdtTpwDtl");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("new_grp_cmdt_dtl_seq", "newGrpCmdtDtlSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cmdt_tpw_mst", "cmdtTpwMst");
		this.hashFields.put("grp_cmdt_dtl_seq", "grpCmdtDtlSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("loc_chk", "locChk");
		this.hashFields.put("qttn_ver_no", "qttnVerNo");
		this.hashFields.put("qttn_no", "qttnNo");
		this.hashFields.put("cmdt_chk", "cmdtChk");
		this.hashFields.put("rate_chk", "rateChk");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("prc_cust_tp_cd", "prcCustTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("new_grp_cmdt_seq", "newGrpCmdtSeq");
		this.hashFields.put("grp_cmdt_seq", "grpCmdtSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cmdtTpwChk
	 */
	public String getCmdtTpwChk() {
		return this.cmdtTpwChk;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtTpwDtl
	 */
	public String getCmdtTpwDtl() {
		return this.cmdtTpwDtl;
	}
	
	/**
	 * Column Info
	 * @return glineSeq
	 */
	public String getGlineSeq() {
		return this.glineSeq;
	}
	
	/**
	 * Column Info
	 * @return newGrpCmdtDtlSeq
	 */
	public String getNewGrpCmdtDtlSeq() {
		return this.newGrpCmdtDtlSeq;
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
	 * @return cmdtTpwMst
	 */
	public String getCmdtTpwMst() {
		return this.cmdtTpwMst;
	}
	
	/**
	 * Column Info
	 * @return grpCmdtDtlSeq
	 */
	public String getGrpCmdtDtlSeq() {
		return this.grpCmdtDtlSeq;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return locChk
	 */
	public String getLocChk() {
		return this.locChk;
	}
	
	/**
	 * Column Info
	 * @return qttnVerNo
	 */
	public String getQttnVerNo() {
		return this.qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @return qttnNo
	 */
	public String getQttnNo() {
		return this.qttnNo;
	}
	
	/**
	 * Column Info
	 * @return cmdtChk
	 */
	public String getCmdtChk() {
		return this.cmdtChk;
	}
	
	/**
	 * Column Info
	 * @return rateChk
	 */
	public String getRateChk() {
		return this.rateChk;
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
	 * @return prcCustTpCd
	 */
	public String getPrcCustTpCd() {
		return this.prcCustTpCd;
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
	 * @return newGrpCmdtSeq
	 */
	public String getNewGrpCmdtSeq() {
		return this.newGrpCmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return grpCmdtSeq
	 */
	public String getGrpCmdtSeq() {
		return this.grpCmdtSeq;
	}
	

	/**
	 * Column Info
	 * @param cmdtTpwChk
	 */
	public void setCmdtTpwChk(String cmdtTpwChk) {
		this.cmdtTpwChk = cmdtTpwChk;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtTpwDtl
	 */
	public void setCmdtTpwDtl(String cmdtTpwDtl) {
		this.cmdtTpwDtl = cmdtTpwDtl;
	}
	
	/**
	 * Column Info
	 * @param glineSeq
	 */
	public void setGlineSeq(String glineSeq) {
		this.glineSeq = glineSeq;
	}
	
	/**
	 * Column Info
	 * @param newGrpCmdtDtlSeq
	 */
	public void setNewGrpCmdtDtlSeq(String newGrpCmdtDtlSeq) {
		this.newGrpCmdtDtlSeq = newGrpCmdtDtlSeq;
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
	 * @param cmdtTpwMst
	 */
	public void setCmdtTpwMst(String cmdtTpwMst) {
		this.cmdtTpwMst = cmdtTpwMst;
	}
	
	/**
	 * Column Info
	 * @param grpCmdtDtlSeq
	 */
	public void setGrpCmdtDtlSeq(String grpCmdtDtlSeq) {
		this.grpCmdtDtlSeq = grpCmdtDtlSeq;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param locChk
	 */
	public void setLocChk(String locChk) {
		this.locChk = locChk;
	}
	
	/**
	 * Column Info
	 * @param qttnVerNo
	 */
	public void setQttnVerNo(String qttnVerNo) {
		this.qttnVerNo = qttnVerNo;
	}
	
	/**
	 * Column Info
	 * @param qttnNo
	 */
	public void setQttnNo(String qttnNo) {
		this.qttnNo = qttnNo;
	}
	
	/**
	 * Column Info
	 * @param cmdtChk
	 */
	public void setCmdtChk(String cmdtChk) {
		this.cmdtChk = cmdtChk;
	}
	
	/**
	 * Column Info
	 * @param rateChk
	 */
	public void setRateChk(String rateChk) {
		this.rateChk = rateChk;
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
	 * @param prcCustTpCd
	 */
	public void setPrcCustTpCd(String prcCustTpCd) {
		this.prcCustTpCd = prcCustTpCd;
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
	 * @param newGrpCmdtSeq
	 */
	public void setNewGrpCmdtSeq(String newGrpCmdtSeq) {
		this.newGrpCmdtSeq = newGrpCmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param grpCmdtSeq
	 */
	public void setGrpCmdtSeq(String grpCmdtSeq) {
		this.grpCmdtSeq = grpCmdtSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCmdtTpwChk(JSPUtil.getParameter(request, "cmdt_tpw_chk", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCmdtTpwDtl(JSPUtil.getParameter(request, "cmdt_tpw_dtl", ""));
		setGlineSeq(JSPUtil.getParameter(request, "gline_seq", ""));
		setNewGrpCmdtDtlSeq(JSPUtil.getParameter(request, "new_grp_cmdt_dtl_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCmdtTpwMst(JSPUtil.getParameter(request, "cmdt_tpw_mst", ""));
		setGrpCmdtDtlSeq(JSPUtil.getParameter(request, "grp_cmdt_dtl_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setLocChk(JSPUtil.getParameter(request, "loc_chk", ""));
		setQttnVerNo(JSPUtil.getParameter(request, "qttn_ver_no", ""));
		setQttnNo(JSPUtil.getParameter(request, "qttn_no", ""));
		setCmdtChk(JSPUtil.getParameter(request, "cmdt_chk", ""));
		setRateChk(JSPUtil.getParameter(request, "rate_chk", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setPrcCustTpCd(JSPUtil.getParameter(request, "prc_cust_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setNewGrpCmdtSeq(JSPUtil.getParameter(request, "new_grp_cmdt_seq", ""));
		setGrpCmdtSeq(JSPUtil.getParameter(request, "grp_cmdt_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchGlineExistVO[]
	 */
	public RsltSearchGlineExistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchGlineExistVO[]
	 */
	public RsltSearchGlineExistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchGlineExistVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cmdtTpwChk = (JSPUtil.getParameter(request, prefix	+ "cmdt_tpw_chk", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] cmdtTpwDtl = (JSPUtil.getParameter(request, prefix	+ "cmdt_tpw_dtl", length));
			String[] glineSeq = (JSPUtil.getParameter(request, prefix	+ "gline_seq", length));
			String[] newGrpCmdtDtlSeq = (JSPUtil.getParameter(request, prefix	+ "new_grp_cmdt_dtl_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cmdtTpwMst = (JSPUtil.getParameter(request, prefix	+ "cmdt_tpw_mst", length));
			String[] grpCmdtDtlSeq = (JSPUtil.getParameter(request, prefix	+ "grp_cmdt_dtl_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] locChk = (JSPUtil.getParameter(request, prefix	+ "loc_chk", length));
			String[] qttnVerNo = (JSPUtil.getParameter(request, prefix	+ "qttn_ver_no", length));
			String[] qttnNo = (JSPUtil.getParameter(request, prefix	+ "qttn_no", length));
			String[] cmdtChk = (JSPUtil.getParameter(request, prefix	+ "cmdt_chk", length));
			String[] rateChk = (JSPUtil.getParameter(request, prefix	+ "rate_chk", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] prcCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cust_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] newGrpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "new_grp_cmdt_seq", length));
			String[] grpCmdtSeq = (JSPUtil.getParameter(request, prefix	+ "grp_cmdt_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchGlineExistVO();
				if (cmdtTpwChk[i] != null)
					model.setCmdtTpwChk(cmdtTpwChk[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (cmdtTpwDtl[i] != null)
					model.setCmdtTpwDtl(cmdtTpwDtl[i]);
				if (glineSeq[i] != null)
					model.setGlineSeq(glineSeq[i]);
				if (newGrpCmdtDtlSeq[i] != null)
					model.setNewGrpCmdtDtlSeq(newGrpCmdtDtlSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cmdtTpwMst[i] != null)
					model.setCmdtTpwMst(cmdtTpwMst[i]);
				if (grpCmdtDtlSeq[i] != null)
					model.setGrpCmdtDtlSeq(grpCmdtDtlSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (locChk[i] != null)
					model.setLocChk(locChk[i]);
				if (qttnVerNo[i] != null)
					model.setQttnVerNo(qttnVerNo[i]);
				if (qttnNo[i] != null)
					model.setQttnNo(qttnNo[i]);
				if (cmdtChk[i] != null)
					model.setCmdtChk(cmdtChk[i]);
				if (rateChk[i] != null)
					model.setRateChk(rateChk[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (prcCustTpCd[i] != null)
					model.setPrcCustTpCd(prcCustTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (newGrpCmdtSeq[i] != null)
					model.setNewGrpCmdtSeq(newGrpCmdtSeq[i]);
				if (grpCmdtSeq[i] != null)
					model.setGrpCmdtSeq(grpCmdtSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchGlineExistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchGlineExistVO[]
	 */
	public RsltSearchGlineExistVO[] getRsltSearchGlineExistVOs(){
		RsltSearchGlineExistVO[] vos = (RsltSearchGlineExistVO[])models.toArray(new RsltSearchGlineExistVO[models.size()]);
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
		this.cmdtTpwChk = this.cmdtTpwChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTpwDtl = this.cmdtTpwDtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq = this.glineSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newGrpCmdtDtlSeq = this.newGrpCmdtDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTpwMst = this.cmdtTpwMst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCmdtDtlSeq = this.grpCmdtDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locChk = this.locChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNo = this.qttnVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNo = this.qttnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtChk = this.cmdtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateChk = this.rateChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCustTpCd = this.prcCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newGrpCmdtSeq = this.newGrpCmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpCmdtSeq = this.grpCmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
