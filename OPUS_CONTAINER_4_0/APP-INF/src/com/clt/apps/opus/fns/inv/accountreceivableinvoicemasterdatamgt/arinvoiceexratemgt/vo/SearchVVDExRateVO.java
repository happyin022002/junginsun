/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SearchVVDExRateVO.java
 *@FileTitle : SearchVVDExRateVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.18
 *@LastModifier : 최도순
 *@LastVersion : 1.0
 * 2009.08.18 최도순 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 * 
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchVVDExRateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchVVDExRateVO> models = new ArrayList<SearchVVDExRateVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String xchRtTpCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String etdaDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String optType = null;
	/* Column Info */
	private String chgCurrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String ivsXchRt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String acctXchRtYrmon = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String xchRtRvsFlg = null;
	
	//CUST_CNT_CD
	//CUST_SEQ
	//XCH_RT_RVS_FLG

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchVVDExRateVO() {
	}

	public SearchVVDExRateVO(String ibflag, String pagerows, String vvdCd, String vslCd, String skdVoyNo, String skdDirCd, String portCd, String svcScpCd,
			String ioBndCd, String loclCurrCd, String chgCurrCd, String arOfcCd, String invXchRt, String ivsXchRt, String optType, String updUsrId,
			String updDt, String xchRtTpCd, String etdaDt, String fromDt, String toDt, String acctXchRtYrmon, String custCntCd, String custSeq, String xchRtRvsFlg) {
		this.updDt = updDt;
		this.xchRtTpCd = xchRtTpCd;
		this.vslCd = vslCd;
		this.svcScpCd = svcScpCd;
		this.loclCurrCd = loclCurrCd;
		this.skdVoyNo = skdVoyNo;
		this.ioBndCd = ioBndCd;
		this.skdDirCd = skdDirCd;
		this.arOfcCd = arOfcCd;
		this.etdaDt = etdaDt;
		this.pagerows = pagerows;
		this.optType = optType;
		this.chgCurrCd = chgCurrCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.portCd = portCd;
		this.ivsXchRt = ivsXchRt;
		this.updUsrId = updUsrId;
		this.invXchRt = invXchRt;
		this.fromDt = fromDt;
		this.toDt = toDt;
		this.acctXchRtYrmon = acctXchRtYrmon;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.xchRtRvsFlg = xchRtRvsFlg;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("etda_dt", getEtdaDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("opt_type", getOptType());
		this.hashColumns.put("chg_curr_cd", getChgCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("ivs_xch_rt", getIvsXchRt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("acct_xch_rt_yrmon", getAcctXchRtYrmon());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("xch_rt_rvs_flg", getXchRtRvsFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("etda_dt", "etdaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("opt_type", "optType");
		this.hashFields.put("chg_curr_cd", "chgCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("ivs_xch_rt", "ivsXchRt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("acct_xch_rt_yrmon", "acctXchRtYrmon");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("xch_rt_rvs_flg", "xchRtRvsFlg");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}

	/**
	 * Column Info
	 * 
	 * @return xchRtTpCd
	 */
	public String getXchRtTpCd() {
		return this.xchRtTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}

	/**
	 * Column Info
	 * 
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}

	/**
	 * Column Info
	 * 
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}

	/**
	 * Column Info
	 * 
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}

	/**
	 * Column Info
	 * 
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}

	/**
	 * Column Info
	 * 
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}

	/**
	 * Column Info
	 * 
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @return etdaDt
	 */
	public String getEtdaDt() {
		return this.etdaDt;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return optType
	 */
	public String getOptType() {
		return this.optType;
	}

	/**
	 * Column Info
	 * 
	 * @return chgCurrCd
	 */
	public String getChgCurrCd() {
		return this.chgCurrCd;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}

	/**
	 * Column Info
	 * 
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}

	/**
	 * Column Info
	 * 
	 * @return ivsXchRt
	 */
	public String getIvsXchRt() {
		return this.ivsXchRt;
	}

	/**
	 * Column Info
	 * 
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}

	/**
	 * Column Info
	 * 
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * 
	 * @param xchRtTpCd
	 */
	public void setXchRtTpCd(String xchRtTpCd) {
		this.xchRtTpCd = xchRtTpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * Column Info
	 * 
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}

	/**
	 * Column Info
	 * 
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}

	/**
	 * Column Info
	 * 
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	/**
	 * Column Info
	 * 
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * Column Info
	 * 
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	/**
	 * Column Info
	 * 
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	/**
	 * Column Info
	 * 
	 * @param etdaDt
	 */
	public void setEtdaDt(String etdaDt) {
		this.etdaDt = etdaDt;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param optType
	 */
	public void setOptType(String optType) {
		this.optType = optType;
	}

	/**
	 * Column Info
	 * 
	 * @param chgCurrCd
	 */
	public void setChgCurrCd(String chgCurrCd) {
		this.chgCurrCd = chgCurrCd;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}

	/**
	 * Column Info
	 * 
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * Column Info
	 * 
	 * @param ivsXchRt
	 */
	public void setIvsXchRt(String ivsXchRt) {
		this.ivsXchRt = ivsXchRt;
	}

	/**
	 * Column Info
	 * 
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}

	public String getFromDt() {
		return fromDt;
	}

	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}

	public String getToDt() {
		return toDt;
	}

	public void setToDt(String toDt) {
		this.toDt = toDt;
	}

	public String getAcctXchRtYrmon() {
		return acctXchRtYrmon;
	}

	public void setAcctXchRtYrmon(String acctXchRtYrmon) {
		this.acctXchRtYrmon = acctXchRtYrmon;
	}

	public String getCustCntCd() {
		return custCntCd;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	public String getCustSeq() {
		return custSeq;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	public String getXchRtRvsFlg() {
		return xchRtRvsFlg;
	}

	public void setXchRtRvsFlg(String xchRtRvsFlg) {
		this.xchRtRvsFlg = xchRtRvsFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setXchRtTpCd(JSPUtil.getParameter(request, "xch_rt_tp_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
		setEtdaDt(JSPUtil.getParameter(request, "etda_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOptType(JSPUtil.getParameter(request, "opt_type", ""));
		setChgCurrCd(JSPUtil.getParameter(request, "chg_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setIvsXchRt(JSPUtil.getParameter(request, "ivs_xch_rt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setAcctXchRtYrmon(JSPUtil.getParameter(request, "acct_xch_rt_yrmon", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setXchRtRvsFlg(JSPUtil.getParameter(request, "xch_rt_rvs_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return SearchVVDExRateVO[]
	 */
	public SearchVVDExRateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return SearchVVDExRateVO[]
	 */
	public SearchVVDExRateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchVVDExRateVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));
			String[] xchRtTpCd = (JSPUtil.getParameter(request, prefix + "xch_rt_tp_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix + "svc_scp_cd", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix + "locl_curr_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix + "io_bnd_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix + "ar_ofc_cd", length));
			String[] etdaDt = (JSPUtil.getParameter(request, prefix + "etda_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] optType = (JSPUtil.getParameter(request, prefix + "opt_type", length));
			String[] chgCurrCd = (JSPUtil.getParameter(request, prefix + "chg_curr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix + "port_cd", length));
			String[] ivsXchRt = (JSPUtil.getParameter(request, prefix + "ivs_xch_rt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix + "inv_xch_rt", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix + "from_dt", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix + "to_dt", length));
			String[] acctXchRtYrmon = (JSPUtil.getParameter(request, prefix + "acct_xch_rt_yrmon", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
			String[] xchRtRvsFlg = (JSPUtil.getParameter(request, prefix + "xch_rt_rvs_flg", length));

			for (int i = 0; i < length; i++) {
				model = new SearchVVDExRateVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (xchRtTpCd[i] != null)
					model.setXchRtTpCd(xchRtTpCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (etdaDt[i] != null)
					model.setEtdaDt(etdaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (optType[i] != null)
					model.setOptType(optType[i]);
				if (chgCurrCd[i] != null)
					model.setChgCurrCd(chgCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (ivsXchRt[i] != null)
					model.setIvsXchRt(ivsXchRt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (acctXchRtYrmon[i] != null)
					model.setAcctXchRtYrmon(acctXchRtYrmon[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (xchRtRvsFlg[i] != null)
					model.setXchRtRvsFlg(xchRtRvsFlg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchVVDExRateVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return SearchVVDExRateVO[]
	 */
	public SearchVVDExRateVO[] getSearchVVDExRateVOs() {
		SearchVVDExRateVO[] vos = (SearchVVDExRateVO[]) models.toArray(new SearchVVDExRateVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try {
			for (int i = 0; i < field.length; i++) {
				String[] arr = null;
				arr = getField(field, i);
				if (arr != null) {
					for (int j = 0; j < arr.length; j++) {
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
	 * 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try {
			arr = (String[]) field[i].get(this);
		} catch (Exception ex) {
			arr = null;
		}
		return arr;
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpCd = this.xchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdaDt = this.etdaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optType = this.optType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurrCd = this.chgCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ivsXchRt = this.ivsXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctXchRtYrmon = this.acctXchRtYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtRvsFlg = this.xchRtRvsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
