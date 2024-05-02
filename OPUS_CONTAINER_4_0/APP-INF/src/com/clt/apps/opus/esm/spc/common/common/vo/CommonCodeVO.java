/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonCodeVO.java
*@FileTitle : CommonCodeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.05.17 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.spc.common.common.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CommonCodeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CommonCodeVO> models = new ArrayList<CommonCodeVO>();
	
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String isRepTrade = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String isAll = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String year = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String key = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String sn = null;
	/* Column Info */
	private String module = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String typCd = null;
	/* Column Info */
	private String ipc = null;
	/* Column Info */
	private String month = null;
	/* Column Info */
	private String method = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String week = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CommonCodeVO() {}

	public CommonCodeVO(String ibflag, String pagerows, String typCd, String rhqCd, String vslCd, String subTrdCd, String trdCd, String rlaneCd, String laneCd, String year, String week, String month, String dirCd, String iocCd, String skdVoyNo, String skdDirCd, String vvd, String podCd, String ofcCd, String method, String key, String code, String name, String del, String isRepTrade, String isAll, String ipc, String custCntCd, String custSeq, String module, String sn) {
		this.laneCd = laneCd;
		this.vslCd = vslCd;
		this.trdCd = trdCd;
		this.isRepTrade = isRepTrade;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.name = name;
		this.isAll = isAll;
		this.dirCd = dirCd;
		this.year = year;
		this.del = del;
		this.custCntCd = custCntCd;
		this.key = key;
		this.iocCd = iocCd;
		this.sn = sn;
		this.module = module;
		this.rhqCd = rhqCd;
		this.skdVoyNo = skdVoyNo;
		this.code = code;
		this.custSeq = custSeq;
		this.skdDirCd = skdDirCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.typCd = typCd;
		this.ipc = ipc;
		this.month = month;
		this.method = method;
		this.subTrdCd = subTrdCd;
		this.week = week;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("is_rep_trade", getIsRepTrade());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("is_all", getIsAll());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("year", getYear());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("key", getKey());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("sn", getSn());
		this.hashColumns.put("module", getModule());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("typ_cd", getTypCd());
		this.hashColumns.put("ipc", getIpc());
		this.hashColumns.put("month", getMonth());
		this.hashColumns.put("method", getMethod());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("week", getWeek());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("is_rep_trade", "isRepTrade");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("name", "name");
		this.hashFields.put("is_all", "isAll");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("year", "year");
		this.hashFields.put("del", "del");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("key", "key");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("sn", "sn");
		this.hashFields.put("module", "module");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("code", "code");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("typ_cd", "typCd");
		this.hashFields.put("ipc", "ipc");
		this.hashFields.put("month", "month");
		this.hashFields.put("method", "method");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("week", "week");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return isRepTrade
	 */
	public String getIsRepTrade() {
		return this.isRepTrade;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Column Info
	 * @return isAll
	 */
	public String getIsAll() {
		return this.isAll;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return year
	 */
	public String getYear() {
		return this.year;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return key
	 */
	public String getKey() {
		return this.key;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return sn
	 */
	public String getSn() {
		return this.sn;
	}
	
	/**
	 * Column Info
	 * @return module
	 */
	public String getModule() {
		return this.module;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
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
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return typCd
	 */
	public String getTypCd() {
		return this.typCd;
	}
	
	/**
	 * Column Info
	 * @return ipc
	 */
	public String getIpc() {
		return this.ipc;
	}
	
	/**
	 * Column Info
	 * @return month
	 */
	public String getMonth() {
		return this.month;
	}
	
	/**
	 * Column Info
	 * @return method
	 */
	public String getMethod() {
		return this.method;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return week
	 */
	public String getWeek() {
		return this.week;
	}
	

	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param isRepTrade
	 */
	public void setIsRepTrade(String isRepTrade) {
		this.isRepTrade = isRepTrade;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Column Info
	 * @param isAll
	 */
	public void setIsAll(String isAll) {
		this.isAll = isAll;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param sn
	 */
	public void setSn(String sn) {
		this.sn = sn;
	}
	
	/**
	 * Column Info
	 * @param module
	 */
	public void setModule(String module) {
		this.module = module;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
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
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param typCd
	 */
	public void setTypCd(String typCd) {
		this.typCd = typCd;
	}
	
	/**
	 * Column Info
	 * @param ipc
	 */
	public void setIpc(String ipc) {
		this.ipc = ipc;
	}
	
	/**
	 * Column Info
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * Column Info
	 * @param method
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param week
	 */
	public void setWeek(String week) {
		this.week = week;
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
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setIsRepTrade(JSPUtil.getParameter(request, prefix + "is_rep_trade", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setIsAll(JSPUtil.getParameter(request, prefix + "is_all", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setYear(JSPUtil.getParameter(request, prefix + "year", ""));
		setDel(JSPUtil.getParameter(request, prefix + "del", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setKey(JSPUtil.getParameter(request, prefix + "key", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setSn(JSPUtil.getParameter(request, prefix + "sn", ""));
		setModule(JSPUtil.getParameter(request, prefix + "module", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setTypCd(JSPUtil.getParameter(request, prefix + "typ_cd", ""));
		setIpc(JSPUtil.getParameter(request, prefix + "ipc", ""));
		setMonth(JSPUtil.getParameter(request, prefix + "month", ""));
		setMethod(JSPUtil.getParameter(request, prefix + "method", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setWeek(JSPUtil.getParameter(request, prefix + "week", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CommonCodeVO[]
	 */
	public CommonCodeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CommonCodeVO[]
	 */
	public CommonCodeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CommonCodeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] isRepTrade = (JSPUtil.getParameter(request, prefix	+ "is_rep_trade", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] isAll = (JSPUtil.getParameter(request, prefix	+ "is_all", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] year = (JSPUtil.getParameter(request, prefix	+ "year", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] key = (JSPUtil.getParameter(request, prefix	+ "key", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] sn = (JSPUtil.getParameter(request, prefix	+ "sn", length));
			String[] module = (JSPUtil.getParameter(request, prefix	+ "module", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] typCd = (JSPUtil.getParameter(request, prefix	+ "typ_cd", length));
			String[] ipc = (JSPUtil.getParameter(request, prefix	+ "ipc", length));
			String[] month = (JSPUtil.getParameter(request, prefix	+ "month", length));
			String[] method = (JSPUtil.getParameter(request, prefix	+ "method", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] week = (JSPUtil.getParameter(request, prefix	+ "week", length));
			
			for (int i = 0; i < length; i++) {
				model = new CommonCodeVO();
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (isRepTrade[i] != null)
					model.setIsRepTrade(isRepTrade[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (isAll[i] != null)
					model.setIsAll(isAll[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (year[i] != null)
					model.setYear(year[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (key[i] != null)
					model.setKey(key[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (sn[i] != null)
					model.setSn(sn[i]);
				if (module[i] != null)
					model.setModule(module[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (typCd[i] != null)
					model.setTypCd(typCd[i]);
				if (ipc[i] != null)
					model.setIpc(ipc[i]);
				if (month[i] != null)
					model.setMonth(month[i]);
				if (method[i] != null)
					model.setMethod(method[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (week[i] != null)
					model.setWeek(week[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCommonCodeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CommonCodeVO[]
	 */
	public CommonCodeVO[] getCommonCodeVOs(){
		CommonCodeVO[] vos = (CommonCodeVO[])models.toArray(new CommonCodeVO[models.size()]);
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
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isRepTrade = this.isRepTrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isAll = this.isAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.year = this.year .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.key = this.key .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sn = this.sn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.module = this.module .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typCd = this.typCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ipc = this.ipc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.month = this.month .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.method = this.method .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week = this.week .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
