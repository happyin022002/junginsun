/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchRouteConstraintVO.java
*@FileTitle : SearchRouteConstraintVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.02
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.03.02 박만건 
* 1.0 Creation
* 2012.06.07 이준근 [CHM-201217814-01] Constraint Management 입력 Data Validation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo;

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
 * @author 박만건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRouteConstraintVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRouteConstraintVO> models = new ArrayList<SearchRouteConstraintVO>();
	
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n2ndTsPortCd = null;
	/* Column Info */
	private String n1stLaneCd = null;
	/* Column Info */
	private String n1stTsPortCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpCd = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String routCnstRmk = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n2ndLaneCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String routCnstSeq = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String svcUseFlg = null;
	/* Column Info */
	private String trnkLaneCd = null;
	/* Column Info */
	private String n3rdLaneCd = null;
	/* Column Info */
	private String chkField = null;
	/* Column Info */
	private String rowNum = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRouteConstraintVO() {}

	public SearchRouteConstraintVO(String ibflag, String pagerows, String deltFlg, String trnkLaneCd, String dirCd, String polCd, String polNodCd, String routCnstSeq, String n1stLaneCd, String n1stTsPortCd, String n2ndLaneCd, String n2ndTsPortCd, String n3rdLaneCd, String podCd, String podNodCd, String delCd, String delNodCd, String svcUseFlg, String routCnstRmk, String creDt, String creOfcCd, String creUsrId, String updDt, String updOfcCd, String updUsrId, String cntrTpCd, String cmdtCd, String cmdtNm, String vvd, String rowNum) {
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.n2ndTsPortCd = n2ndTsPortCd;
		this.n1stLaneCd = n1stLaneCd;
		this.n1stTsPortCd = n1stTsPortCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cntrTpCd = cntrTpCd;
		this.cmdtCd = cmdtCd;
		this.routCnstRmk = routCnstRmk;
		this.creOfcCd = creOfcCd;
		this.dirCd = dirCd;
		this.delNodCd = delNodCd;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.n2ndLaneCd = n2ndLaneCd;
		this.delCd = delCd;
		this.polNodCd = polNodCd;
		this.cmdtNm = cmdtNm;
		this.vvd = vvd;
		this.routCnstSeq = routCnstSeq;
		this.podCd = podCd;
		this.podNodCd = podNodCd;
		this.creUsrId = creUsrId;
		this.svcUseFlg = svcUseFlg;
		this.trnkLaneCd = trnkLaneCd;
		this.n3rdLaneCd = n3rdLaneCd;
		this.rowNum = rowNum;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("n2nd_ts_port_cd", getN2ndTsPortCd());
		this.hashColumns.put("n1st_lane_cd", getN1stLaneCd());
		this.hashColumns.put("n1st_ts_port_cd", getN1stTsPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tp_cd", getCntrTpCd());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("rout_cnst_rmk", getRoutCnstRmk());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n2nd_lane_cd", getN2ndLaneCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("rout_cnst_seq", getRoutCnstSeq());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("svc_use_flg", getSvcUseFlg());
		this.hashColumns.put("trnk_lane_cd", getTrnkLaneCd());
		this.hashColumns.put("n3rd_lane_cd", getN3rdLaneCd());
		this.hashColumns.put("chk_field", getChkField());
		this.hashColumns.put("row_num", getRowNum());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n2nd_ts_port_cd", "n2ndTsPortCd");
		this.hashFields.put("n1st_lane_cd", "n1stLaneCd");
		this.hashFields.put("n1st_ts_port_cd", "n1stTsPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tp_cd", "cntrTpCd");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("rout_cnst_rmk", "routCnstRmk");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n2nd_lane_cd", "n2ndLaneCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("rout_cnst_seq", "routCnstSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("svc_use_flg", "svcUseFlg");
		this.hashFields.put("trnk_lane_cd", "trnkLaneCd");
		this.hashFields.put("n3rd_lane_cd", "n3rdLaneCd");
		this.hashFields.put("chk_field", "chkField");
		this.hashFields.put("row_num", "rowNum");
		return this.hashFields;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return n2ndTsPortCd
	 */
	public String getN2ndTsPortCd() {
		return this.n2ndTsPortCd;
	}
	
	/**
	 * Column Info
	 * @return n1stLaneCd
	 */
	public String getN1stLaneCd() {
		return this.n1stLaneCd;
	}
	
	/**
	 * Column Info
	 * @return n1stTsPortCd
	 */
	public String getN1stTsPortCd() {
		return this.n1stTsPortCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cntrTpCd
	 */
	public String getCntrTpCd() {
		return this.cntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return routCnstRmk
	 */
	public String getRoutCnstRmk() {
		return this.routCnstRmk;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return n2ndLaneCd
	 */
	public String getN2ndLaneCd() {
		return this.n2ndLaneCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return routCnstSeq
	 */
	public String getRoutCnstSeq() {
		return this.routCnstSeq;
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
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
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
	 * @return svcUseFlg
	 */
	public String getSvcUseFlg() {
		return this.svcUseFlg;
	}
	
	/**
	 * Column Info
	 * @return trnkLaneCd
	 */
	public String getTrnkLaneCd() {
		return this.trnkLaneCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdLaneCd
	 */
	public String getN3rdLaneCd() {
		return this.n3rdLaneCd;
	}
	
	/**
	 * Column Info
	 * @return chkField
	 */
	public String getChkField() {
		return this.chkField;
	}
	
	/**
	 * Column Info
	 * @return rowNum
	 */
	public String getRowNum() {
		return rowNum;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param n2ndTsPortCd
	 */
	public void setN2ndTsPortCd(String n2ndTsPortCd) {
		this.n2ndTsPortCd = n2ndTsPortCd;
	}
	
	/**
	 * Column Info
	 * @param n1stLaneCd
	 */
	public void setN1stLaneCd(String n1stLaneCd) {
		this.n1stLaneCd = n1stLaneCd;
	}
	
	/**
	 * Column Info
	 * @param n1stTsPortCd
	 */
	public void setN1stTsPortCd(String n1stTsPortCd) {
		this.n1stTsPortCd = n1stTsPortCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cntrTpCd
	 */
	public void setCntrTpCd(String cntrTpCd) {
		this.cntrTpCd = cntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param routCnstRmk
	 */
	public void setRoutCnstRmk(String routCnstRmk) {
		this.routCnstRmk = routCnstRmk;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param n2ndLaneCd
	 */
	public void setN2ndLaneCd(String n2ndLaneCd) {
		this.n2ndLaneCd = n2ndLaneCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param routCnstSeq
	 */
	public void setRoutCnstSeq(String routCnstSeq) {
		this.routCnstSeq = routCnstSeq;
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
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
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
	 * @param svcUseFlg
	 */
	public void setSvcUseFlg(String svcUseFlg) {
		this.svcUseFlg = svcUseFlg;
	}
	
	/**
	 * Column Info
	 * @param trnkLaneCd
	 */
	public void setTrnkLaneCd(String trnkLaneCd) {
		this.trnkLaneCd = trnkLaneCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdLaneCd
	 */
	public void setN3rdLaneCd(String n3rdLaneCd) {
		this.n3rdLaneCd = n3rdLaneCd;
	}
	
	/**
	 * Column Info
	 * @param chkField
	 */
	public void setChkField(String chkField) {
		this.chkField = chkField;
	}
	
	/**
	 * Column Info
	 * @param rowNum
	 */
	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setN2ndTsPortCd(JSPUtil.getParameter(request, prefix + "n2nd_ts_port_cd", ""));
		setN1stLaneCd(JSPUtil.getParameter(request, prefix + "n1st_lane_cd", ""));
		setN1stTsPortCd(JSPUtil.getParameter(request, prefix + "n1st_ts_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrTpCd(JSPUtil.getParameter(request, prefix + "cntr_tp_cd", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setRoutCnstRmk(JSPUtil.getParameter(request, prefix + "rout_cnst_rmk", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, prefix + "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setN2ndLaneCd(JSPUtil.getParameter(request, prefix + "n2nd_lane_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setRoutCnstSeq(JSPUtil.getParameter(request, prefix + "rout_cnst_seq", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSvcUseFlg(JSPUtil.getParameter(request, prefix + "svc_use_flg", ""));
		setTrnkLaneCd(JSPUtil.getParameter(request, prefix + "trnk_lane_cd", ""));
		setN3rdLaneCd(JSPUtil.getParameter(request, prefix + "n3rd_lane_cd", ""));
		setChkField(JSPUtil.getParameter(request, prefix + "chk_field", ""));
		setRowNum(JSPUtil.getParameter(request, prefix + "row_num", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRouteConstraintVO[]
	 */
	public SearchRouteConstraintVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRouteConstraintVO[]
	 */
	public SearchRouteConstraintVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRouteConstraintVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] n2ndTsPortCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_port_cd", length));
			String[] n1stLaneCd = (JSPUtil.getParameter(request, prefix	+ "n1st_lane_cd", length));
			String[] n1stTsPortCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_cd", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] routCnstRmk = (JSPUtil.getParameter(request, prefix	+ "rout_cnst_rmk", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n2ndLaneCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_lane_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] routCnstSeq = (JSPUtil.getParameter(request, prefix	+ "rout_cnst_seq", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] svcUseFlg = (JSPUtil.getParameter(request, prefix	+ "svc_use_flg", length));
			String[] trnkLaneCd = (JSPUtil.getParameter(request, prefix	+ "trnk_lane_cd", length));
			String[] n3rdLaneCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_lane_cd", length));
			String[] chkField = (JSPUtil.getParameter(request, prefix	+ "chk_field", length));
			String[] rowNum = (JSPUtil.getParameter(request, prefix	+ "row_num", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRouteConstraintVO();
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n2ndTsPortCd[i] != null)
					model.setN2ndTsPortCd(n2ndTsPortCd[i]);
				if (n1stLaneCd[i] != null)
					model.setN1stLaneCd(n1stLaneCd[i]);
				if (n1stTsPortCd[i] != null)
					model.setN1stTsPortCd(n1stTsPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpCd[i] != null)
					model.setCntrTpCd(cntrTpCd[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (routCnstRmk[i] != null)
					model.setRoutCnstRmk(routCnstRmk[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n2ndLaneCd[i] != null)
					model.setN2ndLaneCd(n2ndLaneCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (routCnstSeq[i] != null)
					model.setRoutCnstSeq(routCnstSeq[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (svcUseFlg[i] != null)
					model.setSvcUseFlg(svcUseFlg[i]);
				if (trnkLaneCd[i] != null)
					model.setTrnkLaneCd(trnkLaneCd[i]);
				if (n3rdLaneCd[i] != null)
					model.setN3rdLaneCd(n3rdLaneCd[i]);
				if (chkField[i] != null)
					model.setChkField(chkField[i]);
				if (rowNum[i] != null)
					model.setRowNum(rowNum[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRouteConstraintVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRouteConstraintVO[]
	 */
	public SearchRouteConstraintVO[] getSearchRouteConstraintVOs(){
		SearchRouteConstraintVO[] vos = (SearchRouteConstraintVO[])models.toArray(new SearchRouteConstraintVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsPortCd = this.n2ndTsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stLaneCd = this.n1stLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPortCd = this.n1stTsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpCd = this.cntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCnstRmk = this.routCnstRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndLaneCd = this.n2ndLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCnstSeq = this.routCnstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcUseFlg = this.svcUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkLaneCd = this.trnkLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdLaneCd = this.n3rdLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkField = this.chkField .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowNum = this.rowNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
