/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PrdHinterlandInfoVO.java
*@FileTitle : PrdHinterlandInfoVO
*Open Issues :a
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo;

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

public class PrdHinterlandInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrdHinterlandInfoVO> models = new ArrayList<PrdHinterlandInfoVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String d2PstPctlNo = null;
	/* Column Info */
	private String d4PctlNo = null;
	/* Column Info */
	private String d7PctlNo = null;
	/* Column Info */
	private String pctlNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hdPctlNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String r5PctlNo = null;
	/* Column Info */
	private String r2PctlNo = null;
	/* Column Info */
	private String runTm = null;
	/* Column Info */
	private String d2PctlNo = null;
	/* Column Info */
	private String errCd = null;
	/* Column Info */
	private String r5PstPctlNo = null;
	/* Column Info */
	private String pctlIoBndCd = null;
	/* Column Info */
	private String r2PstPctlNo = null;
	/* Column Info */
	private String d4PstPctlNo = null;
	/* Column Info */
	private String r7PstPctlNo = null;
	/* Column Info */
	private String d7PstPctlNo = null;
	/* Column Info */
	private String r7PctlNo = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String errDesc = null;
	/* Column Info */
	private String d5PctlNo = null;
	/* Column Info */
	private String termCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PrdHinterlandInfoVO() {}

	public PrdHinterlandInfoVO(String ibflag, String pagerows, String fmNodCd, String toNodCd, String pctlIoBndCd, String creUsrId, String errCd, String errDesc, String runTm, String termCd, String pctlNo, String hdPctlNo, String d2PctlNo, String d4PctlNo, String d2PstPctlNo, String d4PstPctlNo, String d5PctlNo, String d7PctlNo, String d7PstPctlNo, String r2PctlNo, String r5PctlNo, String r7PctlNo, String r2PstPctlNo, String r5PstPctlNo, String r7PstPctlNo) {
		this.toNodCd = toNodCd;
		this.d2PstPctlNo = d2PstPctlNo;
		this.d4PctlNo = d4PctlNo;
		this.d7PctlNo = d7PctlNo;
		this.pctlNo = pctlNo;
		this.pagerows = pagerows;
		this.hdPctlNo = hdPctlNo;
		this.ibflag = ibflag;
		this.r5PctlNo = r5PctlNo;
		this.r2PctlNo = r2PctlNo;
		this.runTm = runTm;
		this.d2PctlNo = d2PctlNo;
		this.errCd = errCd;
		this.r5PstPctlNo = r5PstPctlNo;
		this.pctlIoBndCd = pctlIoBndCd;
		this.r2PstPctlNo = r2PstPctlNo;
		this.d4PstPctlNo = d4PstPctlNo;
		this.r7PstPctlNo = r7PstPctlNo;
		this.d7PstPctlNo = d7PstPctlNo;
		this.r7PctlNo = r7PctlNo;
		this.fmNodCd = fmNodCd;
		this.creUsrId = creUsrId;
		this.errDesc = errDesc;
		this.d5PctlNo = d5PctlNo;
		this.termCd = termCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("d2_pst_pctl_no", getD2PstPctlNo());
		this.hashColumns.put("d4_pctl_no", getD4PctlNo());
		this.hashColumns.put("d7_pctl_no", getD7PctlNo());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hd_pctl_no", getHdPctlNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("r5_pctl_no", getR5PctlNo());
		this.hashColumns.put("r2_pctl_no", getR2PctlNo());
		this.hashColumns.put("run_tm", getRunTm());
		this.hashColumns.put("d2_pctl_no", getD2PctlNo());
		this.hashColumns.put("err_cd", getErrCd());
		this.hashColumns.put("r5_pst_pctl_no", getR5PstPctlNo());
		this.hashColumns.put("pctl_io_bnd_cd", getPctlIoBndCd());
		this.hashColumns.put("r2_pst_pctl_no", getR2PstPctlNo());
		this.hashColumns.put("d4_pst_pctl_no", getD4PstPctlNo());
		this.hashColumns.put("r7_pst_pctl_no", getR7PstPctlNo());
		this.hashColumns.put("d7_pst_pctl_no", getD7PstPctlNo());
		this.hashColumns.put("r7_pctl_no", getR7PctlNo());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("err_desc", getErrDesc());
		this.hashColumns.put("d5_pctl_no", getD5PctlNo());
		this.hashColumns.put("term_cd", getTermCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("d2_pst_pctl_no", "d2PstPctlNo");
		this.hashFields.put("d4_pctl_no", "d4PctlNo");
		this.hashFields.put("d7_pctl_no", "d7PctlNo");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hd_pctl_no", "hdPctlNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("r5_pctl_no", "r5PctlNo");
		this.hashFields.put("r2_pctl_no", "r2PctlNo");
		this.hashFields.put("run_tm", "runTm");
		this.hashFields.put("d2_pctl_no", "d2PctlNo");
		this.hashFields.put("err_cd", "errCd");
		this.hashFields.put("r5_pst_pctl_no", "r5PstPctlNo");
		this.hashFields.put("pctl_io_bnd_cd", "pctlIoBndCd");
		this.hashFields.put("r2_pst_pctl_no", "r2PstPctlNo");
		this.hashFields.put("d4_pst_pctl_no", "d4PstPctlNo");
		this.hashFields.put("r7_pst_pctl_no", "r7PstPctlNo");
		this.hashFields.put("d7_pst_pctl_no", "d7PstPctlNo");
		this.hashFields.put("r7_pctl_no", "r7PctlNo");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("err_desc", "errDesc");
		this.hashFields.put("d5_pctl_no", "d5PctlNo");
		this.hashFields.put("term_cd", "termCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return d2PstPctlNo
	 */
	public String getD2PstPctlNo() {
		return this.d2PstPctlNo;
	}
	
	/**
	 * Column Info
	 * @return d4PctlNo
	 */
	public String getD4PctlNo() {
		return this.d4PctlNo;
	}
	
	/**
	 * Column Info
	 * @return d7PctlNo
	 */
	public String getD7PctlNo() {
		return this.d7PctlNo;
	}
	
	/**
	 * Column Info
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
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
	 * @return hdPctlNo
	 */
	public String getHdPctlNo() {
		return this.hdPctlNo;
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
	 * @return r5PctlNo
	 */
	public String getR5PctlNo() {
		return this.r5PctlNo;
	}
	
	/**
	 * Column Info
	 * @return r2PctlNo
	 */
	public String getR2PctlNo() {
		return this.r2PctlNo;
	}
	
	/**
	 * Column Info
	 * @return runTm
	 */
	public String getRunTm() {
		return this.runTm;
	}
	
	/**
	 * Column Info
	 * @return d2PctlNo
	 */
	public String getD2PctlNo() {
		return this.d2PctlNo;
	}
	
	/**
	 * Column Info
	 * @return errCd
	 */
	public String getErrCd() {
		return this.errCd;
	}
	
	/**
	 * Column Info
	 * @return r5PstPctlNo
	 */
	public String getR5PstPctlNo() {
		return this.r5PstPctlNo;
	}
	
	/**
	 * Column Info
	 * @return pctlIoBndCd
	 */
	public String getPctlIoBndCd() {
		return this.pctlIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return r2PstPctlNo
	 */
	public String getR2PstPctlNo() {
		return this.r2PstPctlNo;
	}
	
	/**
	 * Column Info
	 * @return d4PstPctlNo
	 */
	public String getD4PstPctlNo() {
		return this.d4PstPctlNo;
	}
	
	/**
	 * Column Info
	 * @return r7PstPctlNo
	 */
	public String getR7PstPctlNo() {
		return this.r7PstPctlNo;
	}
	
	/**
	 * Column Info
	 * @return d7PstPctlNo
	 */
	public String getD7PstPctlNo() {
		return this.d7PstPctlNo;
	}
	
	/**
	 * Column Info
	 * @return r7PctlNo
	 */
	public String getR7PctlNo() {
		return this.r7PctlNo;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
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
	 * @return errDesc
	 */
	public String getErrDesc() {
		return this.errDesc;
	}
	
	/**
	 * Column Info
	 * @return d5PctlNo
	 */
	public String getD5PctlNo() {
		return this.d5PctlNo;
	}
	
	/**
	 * Column Info
	 * @return termCd
	 */
	public String getTermCd() {
		return this.termCd;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param d2PstPctlNo
	 */
	public void setD2PstPctlNo(String d2PstPctlNo) {
		this.d2PstPctlNo = d2PstPctlNo;
	}
	
	/**
	 * Column Info
	 * @param d4PctlNo
	 */
	public void setD4PctlNo(String d4PctlNo) {
		this.d4PctlNo = d4PctlNo;
	}
	
	/**
	 * Column Info
	 * @param d7PctlNo
	 */
	public void setD7PctlNo(String d7PctlNo) {
		this.d7PctlNo = d7PctlNo;
	}
	
	/**
	 * Column Info
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
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
	 * @param hdPctlNo
	 */
	public void setHdPctlNo(String hdPctlNo) {
		this.hdPctlNo = hdPctlNo;
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
	 * @param r5PctlNo
	 */
	public void setR5PctlNo(String r5PctlNo) {
		this.r5PctlNo = r5PctlNo;
	}
	
	/**
	 * Column Info
	 * @param r2PctlNo
	 */
	public void setR2PctlNo(String r2PctlNo) {
		this.r2PctlNo = r2PctlNo;
	}
	
	/**
	 * Column Info
	 * @param runTm
	 */
	public void setRunTm(String runTm) {
		this.runTm = runTm;
	}
	
	/**
	 * Column Info
	 * @param d2PctlNo
	 */
	public void setD2PctlNo(String d2PctlNo) {
		this.d2PctlNo = d2PctlNo;
	}
	
	/**
	 * Column Info
	 * @param errCd
	 */
	public void setErrCd(String errCd) {
		this.errCd = errCd;
	}
	
	/**
	 * Column Info
	 * @param r5PstPctlNo
	 */
	public void setR5PstPctlNo(String r5PstPctlNo) {
		this.r5PstPctlNo = r5PstPctlNo;
	}
	
	/**
	 * Column Info
	 * @param pctlIoBndCd
	 */
	public void setPctlIoBndCd(String pctlIoBndCd) {
		this.pctlIoBndCd = pctlIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param r2PstPctlNo
	 */
	public void setR2PstPctlNo(String r2PstPctlNo) {
		this.r2PstPctlNo = r2PstPctlNo;
	}
	
	/**
	 * Column Info
	 * @param d4PstPctlNo
	 */
	public void setD4PstPctlNo(String d4PstPctlNo) {
		this.d4PstPctlNo = d4PstPctlNo;
	}
	
	/**
	 * Column Info
	 * @param r7PstPctlNo
	 */
	public void setR7PstPctlNo(String r7PstPctlNo) {
		this.r7PstPctlNo = r7PstPctlNo;
	}
	
	/**
	 * Column Info
	 * @param d7PstPctlNo
	 */
	public void setD7PstPctlNo(String d7PstPctlNo) {
		this.d7PstPctlNo = d7PstPctlNo;
	}
	
	/**
	 * Column Info
	 * @param r7PctlNo
	 */
	public void setR7PctlNo(String r7PctlNo) {
		this.r7PctlNo = r7PctlNo;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
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
	 * @param errDesc
	 */
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
	
	/**
	 * Column Info
	 * @param d5PctlNo
	 */
	public void setD5PctlNo(String d5PctlNo) {
		this.d5PctlNo = d5PctlNo;
	}
	
	/**
	 * Column Info
	 * @param termCd
	 */
	public void setTermCd(String termCd) {
		this.termCd = termCd;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setD2PstPctlNo(JSPUtil.getParameter(request, prefix + "d2_pst_pctl_no", ""));
		setD4PctlNo(JSPUtil.getParameter(request, prefix + "d4_pctl_no", ""));
		setD7PctlNo(JSPUtil.getParameter(request, prefix + "d7_pctl_no", ""));
		setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setHdPctlNo(JSPUtil.getParameter(request, prefix + "hd_pctl_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setR5PctlNo(JSPUtil.getParameter(request, prefix + "r5_pctl_no", ""));
		setR2PctlNo(JSPUtil.getParameter(request, prefix + "r2_pctl_no", ""));
		setRunTm(JSPUtil.getParameter(request, prefix + "run_tm", ""));
		setD2PctlNo(JSPUtil.getParameter(request, prefix + "d2_pctl_no", ""));
		setErrCd(JSPUtil.getParameter(request, prefix + "err_cd", ""));
		setR5PstPctlNo(JSPUtil.getParameter(request, prefix + "r5_pst_pctl_no", ""));
		setPctlIoBndCd(JSPUtil.getParameter(request, prefix + "pctl_io_bnd_cd", ""));
		setR2PstPctlNo(JSPUtil.getParameter(request, prefix + "r2_pst_pctl_no", ""));
		setD4PstPctlNo(JSPUtil.getParameter(request, prefix + "d4_pst_pctl_no", ""));
		setR7PstPctlNo(JSPUtil.getParameter(request, prefix + "r7_pst_pctl_no", ""));
		setD7PstPctlNo(JSPUtil.getParameter(request, prefix + "d7_pst_pctl_no", ""));
		setR7PctlNo(JSPUtil.getParameter(request, prefix + "r7_pctl_no", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setErrDesc(JSPUtil.getParameter(request, prefix + "err_desc", ""));
		setD5PctlNo(JSPUtil.getParameter(request, prefix + "d5_pctl_no", ""));
		setTermCd(JSPUtil.getParameter(request, prefix + "term_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrdHinterlandInfoVO[]
	 */
	public PrdHinterlandInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrdHinterlandInfoVO[]
	 */
	public PrdHinterlandInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdHinterlandInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] d2PstPctlNo = (JSPUtil.getParameter(request, prefix	+ "d2_pst_pctl_no", length));
			String[] d4PctlNo = (JSPUtil.getParameter(request, prefix	+ "d4_pctl_no", length));
			String[] d7PctlNo = (JSPUtil.getParameter(request, prefix	+ "d7_pctl_no", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hdPctlNo = (JSPUtil.getParameter(request, prefix	+ "hd_pctl_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] r5PctlNo = (JSPUtil.getParameter(request, prefix	+ "r5_pctl_no", length));
			String[] r2PctlNo = (JSPUtil.getParameter(request, prefix	+ "r2_pctl_no", length));
			String[] runTm = (JSPUtil.getParameter(request, prefix	+ "run_tm", length));
			String[] d2PctlNo = (JSPUtil.getParameter(request, prefix	+ "d2_pctl_no", length));
			String[] errCd = (JSPUtil.getParameter(request, prefix	+ "err_cd", length));
			String[] r5PstPctlNo = (JSPUtil.getParameter(request, prefix	+ "r5_pst_pctl_no", length));
			String[] pctlIoBndCd = (JSPUtil.getParameter(request, prefix	+ "pctl_io_bnd_cd", length));
			String[] r2PstPctlNo = (JSPUtil.getParameter(request, prefix	+ "r2_pst_pctl_no", length));
			String[] d4PstPctlNo = (JSPUtil.getParameter(request, prefix	+ "d4_pst_pctl_no", length));
			String[] r7PstPctlNo = (JSPUtil.getParameter(request, prefix	+ "r7_pst_pctl_no", length));
			String[] d7PstPctlNo = (JSPUtil.getParameter(request, prefix	+ "d7_pst_pctl_no", length));
			String[] r7PctlNo = (JSPUtil.getParameter(request, prefix	+ "r7_pctl_no", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] errDesc = (JSPUtil.getParameter(request, prefix	+ "err_desc", length));
			String[] d5PctlNo = (JSPUtil.getParameter(request, prefix	+ "d5_pctl_no", length));
			String[] termCd = (JSPUtil.getParameter(request, prefix	+ "term_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrdHinterlandInfoVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (d2PstPctlNo[i] != null)
					model.setD2PstPctlNo(d2PstPctlNo[i]);
				if (d4PctlNo[i] != null)
					model.setD4PctlNo(d4PctlNo[i]);
				if (d7PctlNo[i] != null)
					model.setD7PctlNo(d7PctlNo[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hdPctlNo[i] != null)
					model.setHdPctlNo(hdPctlNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (r5PctlNo[i] != null)
					model.setR5PctlNo(r5PctlNo[i]);
				if (r2PctlNo[i] != null)
					model.setR2PctlNo(r2PctlNo[i]);
				if (runTm[i] != null)
					model.setRunTm(runTm[i]);
				if (d2PctlNo[i] != null)
					model.setD2PctlNo(d2PctlNo[i]);
				if (errCd[i] != null)
					model.setErrCd(errCd[i]);
				if (r5PstPctlNo[i] != null)
					model.setR5PstPctlNo(r5PstPctlNo[i]);
				if (pctlIoBndCd[i] != null)
					model.setPctlIoBndCd(pctlIoBndCd[i]);
				if (r2PstPctlNo[i] != null)
					model.setR2PstPctlNo(r2PstPctlNo[i]);
				if (d4PstPctlNo[i] != null)
					model.setD4PstPctlNo(d4PstPctlNo[i]);
				if (r7PstPctlNo[i] != null)
					model.setR7PstPctlNo(r7PstPctlNo[i]);
				if (d7PstPctlNo[i] != null)
					model.setD7PstPctlNo(d7PstPctlNo[i]);
				if (r7PctlNo[i] != null)
					model.setR7PctlNo(r7PctlNo[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (errDesc[i] != null)
					model.setErrDesc(errDesc[i]);
				if (d5PctlNo[i] != null)
					model.setD5PctlNo(d5PctlNo[i]);
				if (termCd[i] != null)
					model.setTermCd(termCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrdHinterlandInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrdHinterlandInfoVO[]
	 */
	public PrdHinterlandInfoVO[] getPrdHinterlandInfoVOs(){
		PrdHinterlandInfoVO[] vos = (PrdHinterlandInfoVO[])models.toArray(new PrdHinterlandInfoVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2PstPctlNo = this.d2PstPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4PctlNo = this.d4PctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7PctlNo = this.d7PctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdPctlNo = this.hdPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5PctlNo = this.r5PctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2PctlNo = this.r2PctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.runTm = this.runTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2PctlNo = this.d2PctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCd = this.errCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r5PstPctlNo = this.r5PstPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlIoBndCd = this.pctlIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2PstPctlNo = this.r2PstPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4PstPctlNo = this.d4PstPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r7PstPctlNo = this.r7PstPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7PstPctlNo = this.d7PstPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r7PctlNo = this.r7PctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errDesc = this.errDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5PctlNo = this.d5PctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCd = this.termCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
