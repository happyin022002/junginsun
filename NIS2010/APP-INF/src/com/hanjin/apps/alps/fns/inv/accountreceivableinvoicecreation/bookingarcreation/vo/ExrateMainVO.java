/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExrateMainVO.java
*@FileTitle : ExrateMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.28 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ExrateMainVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExrateMainVO> models = new ArrayList<ExrateMainVO>();
	
	/* Column Info */
	private String xchRtDt = null;
	/* Column Info */
	private String glEffDt = null;
	/* Column Info */
	private String xchRtN3rdTpCd = null;
	/* Column Info */
	private String invTtlLoclAmt = null;
	/* Column Info */
	private String usdXchRt = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sailDt = null;
	/* Column Info */
	private String obrdDt = null;
	/* Column Info */
	private String blInvCfmDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String xchRtUsdTpCd = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String dueDt = null;
	/* Column Info */
	private String custCrFlg = null;
	/* Column Info */
	private String crTermDys = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String revSrcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String revVvd = null;
	/* Column Info */
	private String rlaneCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExrateMainVO() {}

	public ExrateMainVO(String ibflag, String pagerows, String arIfNo, String arOfcCd, String sailDt, String usdXchRt, String xchRtUsdTpCd, String xchRtN3rdTpCd, String xchRtDt, String obrdDt, String glEffDt, String blInvCfmDt, String invTtlLoclAmt, String updUsrId, String sailArrDt, String vvd, String port, String dueDt,String custCrFlg, String crTermDys, String revTpCd,String revSrcCd, String bkgNo,String revVvd,String rlaneCd) {
		this.xchRtDt = xchRtDt;
		this.glEffDt = glEffDt;
		this.xchRtN3rdTpCd = xchRtN3rdTpCd;
		this.invTtlLoclAmt = invTtlLoclAmt;
		this.usdXchRt = usdXchRt;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.sailDt = sailDt;
		this.obrdDt = obrdDt;
		this.blInvCfmDt = blInvCfmDt;
		this.ibflag = ibflag;
		this.xchRtUsdTpCd = xchRtUsdTpCd;
		this.arIfNo = arIfNo;
		this.updUsrId = updUsrId;
		this.sailArrDt = sailArrDt;
		this.vvd = vvd;
		this.port = port;
		this.dueDt = dueDt;
		this.custCrFlg = custCrFlg;
		this.crTermDys = crTermDys;
		this.revTpCd = revTpCd;
		this.revSrcCd = revSrcCd;
		this.bkgNo = bkgNo;
		this.revVvd = revVvd;
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xch_rt_dt", getXchRtDt());
		this.hashColumns.put("gl_eff_dt", getGlEffDt());
		this.hashColumns.put("xch_rt_n3rd_tp_cd", getXchRtN3rdTpCd());
		this.hashColumns.put("inv_ttl_locl_amt", getInvTtlLoclAmt());
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sail_dt", getSailDt());
		this.hashColumns.put("obrd_dt", getObrdDt());
		this.hashColumns.put("bl_inv_cfm_dt", getBlInvCfmDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("xch_rt_usd_tp_cd", getXchRtUsdTpCd());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("due_dt", getDueDt());
		this.hashColumns.put("cust_cr_flg", getCustCrFlg());
		this.hashColumns.put("cr_term_dys", getCrTermDys());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("rev_src_cd", getRevSrcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rev_vvd", getRevVvd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("xch_rt_n3rd_tp_cd", "xchRtN3rdTpCd");
		this.hashFields.put("inv_ttl_locl_amt", "invTtlLoclAmt");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("obrd_dt", "obrdDt");
		this.hashFields.put("bl_inv_cfm_dt", "blInvCfmDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("xch_rt_usd_tp_cd", "xchRtUsdTpCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("port", "port");
		this.hashFields.put("due_dt", "due_dt");
		this.hashFields.put("cust_cr_flg", "custCrFlg");
		this.hashFields.put("cr_term_dys", "crTermDys");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		return this.hashFields;
	}
	
	
	/**
	 * @return the revVvd
	 */
	public String getRevVvd() {
		return revVvd;
	}

	/**
	 * @param revVvd the revVvd to set
	 */
	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
	}

	/**
	 * @return the rlaneCd
	 */
	public String getRlaneCd() {
		return rlaneCd;
	}

	/**
	 * @param rlaneCd the rlaneCd to set
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}

	/**
	 * @return the bkgNo
	 */
	public String getBkgNo() {
		return bkgNo;
	}

	/**
	 * @param bkgNo the bkgNo to set
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * @return the revTpCd
	 */
	public String getRevTpCd() {
		return revTpCd;
	}

	/**
	 * @param revTpCd the revTpCd to set
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}

	/**
	 * @return the revSrcCd
	 */
	public String getRevSrcCd() {
		return revSrcCd;
	}

	/**
	 * @param revSrcCd the revSrcCd to set
	 */
	public void setRevSrcCd(String revSrcCd) {
		this.revSrcCd = revSrcCd;
	}

	/**
	 * @return the dueDt
	 */
	public String getDueDt() {
		return dueDt;
	}

	/**
	 * @param dueDt the dueDt to set
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}

	/**
	 * @return the custCrFlg
	 */
	public String getCustCrFlg() {
		return custCrFlg;
	}

	/**
	 * @param custCrFlg the custCrFlg to set
	 */
	public void setCustCrFlg(String custCrFlg) {
		this.custCrFlg = custCrFlg;
	}

	/**
	 * @return the crTermDys
	 */
	public String getCrTermDys() {
		return crTermDys;
	}

	/**
	 * @param crTermDys the crTermDys to set
	 */
	public void setCrTermDys(String crTermDys) {
		this.crTermDys = crTermDys;
	}

	/**
	 * @return the sailArrDt
	 */
	public String getSailArrDt() {
		return sailArrDt;
	}

	/**
	 * @param sailArrDt the sailArrDt to set
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}

	/**
	 * @return the vvd
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd the vvd to set
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * Column Info
	 * @return xchRtDt
	 */
	public String getXchRtDt() {
		return this.xchRtDt;
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
	 * @return xchRtN3rdTpCd
	 */
	public String getXchRtN3rdTpCd() {
		return this.xchRtN3rdTpCd;
	}
	
	/**
	 * Column Info
	 * @return invTtlLoclAmt
	 */
	public String getInvTtlLoclAmt() {
		return this.invTtlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return usdXchRt
	 */
	public String getUsdXchRt() {
		return this.usdXchRt;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return sailDt
	 */
	public String getSailDt() {
		return this.sailDt;
	}
	
	/**
	 * Column Info
	 * @return obrdDt
	 */
	public String getObrdDt() {
		return this.obrdDt;
	}
	
	/**
	 * Column Info
	 * @return blInvCfmDt
	 */
	public String getBlInvCfmDt() {
		return this.blInvCfmDt;
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
	 * @return xchRtUsdTpCd
	 */
	public String getXchRtUsdTpCd() {
		return this.xchRtUsdTpCd;
	}
	
	/**
	 * Column Info
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
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
	 * @param xchRtDt
	 */
	public void setXchRtDt(String xchRtDt) {
		this.xchRtDt = xchRtDt;
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
	 * @param xchRtN3rdTpCd
	 */
	public void setXchRtN3rdTpCd(String xchRtN3rdTpCd) {
		this.xchRtN3rdTpCd = xchRtN3rdTpCd;
	}
	
	/**
	 * Column Info
	 * @param invTtlLoclAmt
	 */
	public void setInvTtlLoclAmt(String invTtlLoclAmt) {
		this.invTtlLoclAmt = invTtlLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param usdXchRt
	 */
	public void setUsdXchRt(String usdXchRt) {
		this.usdXchRt = usdXchRt;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param sailDt
	 */
	public void setSailDt(String sailDt) {
		this.sailDt = sailDt;
	}
	
	/**
	 * Column Info
	 * @param obrdDt
	 */
	public void setObrdDt(String obrdDt) {
		this.obrdDt = obrdDt;
	}
	
	/**
	 * Column Info
	 * @param blInvCfmDt
	 */
	public void setBlInvCfmDt(String blInvCfmDt) {
		this.blInvCfmDt = blInvCfmDt;
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
	 * @param xchRtUsdTpCd
	 */
	public void setXchRtUsdTpCd(String xchRtUsdTpCd) {
		this.xchRtUsdTpCd = xchRtUsdTpCd;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXchRtDt(JSPUtil.getParameter(request, "xch_rt_dt", ""));
		setGlEffDt(JSPUtil.getParameter(request, "gl_eff_dt", ""));
		setXchRtN3rdTpCd(JSPUtil.getParameter(request, "xch_rt_n3rd_tp_cd", ""));
		setInvTtlLoclAmt(JSPUtil.getParameter(request, "inv_ttl_locl_amt", ""));
		setUsdXchRt(JSPUtil.getParameter(request, "usd_xch_rt", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSailDt(JSPUtil.getParameter(request, "sail_dt", ""));
		setObrdDt(JSPUtil.getParameter(request, "obrd_dt", ""));
		setBlInvCfmDt(JSPUtil.getParameter(request, "bl_inv_cfm_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setXchRtUsdTpCd(JSPUtil.getParameter(request, "xch_rt_usd_tp_cd", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sailArrDt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPort(JSPUtil.getParameter(request, "port", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
		setCustCrFlg(JSPUtil.getParameter(request, "cust_cr_Flg", ""));
		setCrTermDys(JSPUtil.getParameter(request, "cr_term_dys", ""));
		setRevTpCd(JSPUtil.getParameter(request, "rev_tp_cd", ""));
		setRevSrcCd(JSPUtil.getParameter(request, "rev_src_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExrateMainVO[]
	 */
	public ExrateMainVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExrateMainVO[]
	 */
	public ExrateMainVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExrateMainVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xchRtDt = (JSPUtil.getParameter(request, prefix	+ "xch_rt_dt", length));
			String[] glEffDt = (JSPUtil.getParameter(request, prefix	+ "gl_eff_dt", length));
			String[] xchRtN3rdTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_n3rd_tp_cd", length));
			String[] invTtlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "inv_ttl_locl_amt", length));
			String[] usdXchRt = (JSPUtil.getParameter(request, prefix	+ "usd_xch_rt", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sailDt = (JSPUtil.getParameter(request, prefix	+ "sail_dt", length));
			String[] obrdDt = (JSPUtil.getParameter(request, prefix	+ "obrd_dt", length));
			String[] blInvCfmDt = (JSPUtil.getParameter(request, prefix	+ "bl_inv_cfm_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] xchRtUsdTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_usd_tp_cd", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			String[] custCrFlg = (JSPUtil.getParameter(request, prefix	+ "cust_cr_flg", length));
			String[] crTermDys = (JSPUtil.getParameter(request, prefix	+ "cr_term_dys", length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd", length));
			String[] revSrcCd = (JSPUtil.getParameter(request, prefix	+ "rev_src_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExrateMainVO();
				if (xchRtDt[i] != null)
					model.setXchRtDt(xchRtDt[i]);
				if (glEffDt[i] != null)
					model.setGlEffDt(glEffDt[i]);
				if (xchRtN3rdTpCd[i] != null)
					model.setXchRtN3rdTpCd(xchRtN3rdTpCd[i]);
				if (invTtlLoclAmt[i] != null)
					model.setInvTtlLoclAmt(invTtlLoclAmt[i]);
				if (usdXchRt[i] != null)
					model.setUsdXchRt(usdXchRt[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sailDt[i] != null)
					model.setSailDt(sailDt[i]);
				if (obrdDt[i] != null)
					model.setObrdDt(obrdDt[i]);
				if (blInvCfmDt[i] != null)
					model.setBlInvCfmDt(blInvCfmDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (xchRtUsdTpCd[i] != null)
					model.setXchRtUsdTpCd(xchRtUsdTpCd[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				if (custCrFlg[i] != null)
					model.setCustCrFlg(custCrFlg[i]);
				if (crTermDys[i] != null)
					model.setCrTermDys(crTermDys[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (revSrcCd[i] != null)
					model.setRevSrcCd(revSrcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExrateMainVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExrateMainVO[]
	 */
	public ExrateMainVO[] getExrateMainVOs(){
		ExrateMainVO[] vos = (ExrateMainVO[])models.toArray(new ExrateMainVO[models.size()]);
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
		this.xchRtDt = this.xchRtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt = this.glEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtN3rdTpCd = this.xchRtN3rdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTtlLoclAmt = this.invTtlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt = this.usdXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt = this.sailDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obrdDt = this.obrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvCfmDt = this.blInvCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtUsdTpCd = this.xchRtUsdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCrFlg = this.custCrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crTermDys = this.crTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd = this.revSrcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
