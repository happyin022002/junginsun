/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OptmRoutPassSmryVO.java
*@FileTitle : OptmRoutPassSmryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.28
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2012.06.28 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.report.optimumroutepassusa.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OptmRoutPassSmryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OptmRoutPassSmryVO> models = new ArrayList<OptmRoutPassSmryVO>();
	
	/* Column Info */
	private String nonPassNRatio = null;
	/* Column Info */
	private String inToDate = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String qryOfcCd = null;
	/* Column Info */
	private String dscrRsnMap = null;
	/* Column Info */
	private String woCreOfcCd = null;
	/* Column Info */
	private String trspModCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String nonPassTRatio = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String nonPassTCnt = null;
	/* Column Info */
	private String totSoCnt = null;
	/* Column Info */
	private String nonPassORatio = null;
	/* Column Info */
	private String nonPassRCnt = null;
	/* Column Info */
	private String cpyNo = null;
	/* Column Info */
	private String passCnt = null;
	/* Column Info */
	private String nonPassRatio = null;
	/* Column Info */
	private String nonPassRRatio = null;
	/* Column Info */
	private String nonPassNCnt = null;
	/* Column Info */
	private String inFromDate = null;
	/* Column Info */
	private String nonPassOCnt = null;
	/* Column Info */
	private String qryTrspModCd = null;
	/* Column Info */
	private String grpNo = null;
	/* Column Info */
	private String nonPassCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OptmRoutPassSmryVO() {}

	public OptmRoutPassSmryVO(String ibflag, String pagerows, String inToDate, String trspBndCd, String qryOfcCd, String dscrRsnMap, String woCreOfcCd, String trspModCd, String totSoCnt, String cpyNo, String passCnt, String inFromDate, String grpNo, String qryTrspModCd, String nonPassCnt, String nonPassRatio, String nonPassTCnt, String nonPassRCnt, String nonPassNCnt, String nonPassOCnt, String nonPassTRatio, String nonPassRRatio, String nonPassNRatio, String nonPassORatio) {
		this.nonPassNRatio = nonPassNRatio;
		this.inToDate = inToDate;
		this.trspBndCd = trspBndCd;
		this.qryOfcCd = qryOfcCd;
		this.dscrRsnMap = dscrRsnMap;
		this.woCreOfcCd = woCreOfcCd;
		this.trspModCd = trspModCd;
		this.pagerows = pagerows;
		this.nonPassTRatio = nonPassTRatio;
		this.ibflag = ibflag;
		this.nonPassTCnt = nonPassTCnt;
		this.totSoCnt = totSoCnt;
		this.nonPassORatio = nonPassORatio;
		this.nonPassRCnt = nonPassRCnt;
		this.cpyNo = cpyNo;
		this.passCnt = passCnt;
		this.nonPassRatio = nonPassRatio;
		this.nonPassRRatio = nonPassRRatio;
		this.nonPassNCnt = nonPassNCnt;
		this.inFromDate = inFromDate;
		this.nonPassOCnt = nonPassOCnt;
		this.qryTrspModCd = qryTrspModCd;
		this.grpNo = grpNo;
		this.nonPassCnt = nonPassCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("non_pass_n_ratio", getNonPassNRatio());
		this.hashColumns.put("in_to_date", getInToDate());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("qry_ofc_cd", getQryOfcCd());
		this.hashColumns.put("dscr_rsn_map", getDscrRsnMap());
		this.hashColumns.put("wo_cre_ofc_cd", getWoCreOfcCd());
		this.hashColumns.put("trsp_mod_cd", getTrspModCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("non_pass_t_ratio", getNonPassTRatio());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("non_pass_t_cnt", getNonPassTCnt());
		this.hashColumns.put("tot_so_cnt", getTotSoCnt());
		this.hashColumns.put("non_pass_o_ratio", getNonPassORatio());
		this.hashColumns.put("non_pass_r_cnt", getNonPassRCnt());
		this.hashColumns.put("cpy_no", getCpyNo());
		this.hashColumns.put("pass_cnt", getPassCnt());
		this.hashColumns.put("non_pass_ratio", getNonPassRatio());
		this.hashColumns.put("non_pass_r_ratio", getNonPassRRatio());
		this.hashColumns.put("non_pass_n_cnt", getNonPassNCnt());
		this.hashColumns.put("in_from_date", getInFromDate());
		this.hashColumns.put("non_pass_o_cnt", getNonPassOCnt());
		this.hashColumns.put("qry_trsp_mod_cd", getQryTrspModCd());
		this.hashColumns.put("grp_no", getGrpNo());
		this.hashColumns.put("non_pass_cnt", getNonPassCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("non_pass_n_ratio", "nonPassNRatio");
		this.hashFields.put("in_to_date", "inToDate");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("qry_ofc_cd", "qryOfcCd");
		this.hashFields.put("dscr_rsn_map", "dscrRsnMap");
		this.hashFields.put("wo_cre_ofc_cd", "woCreOfcCd");
		this.hashFields.put("trsp_mod_cd", "trspModCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("non_pass_t_ratio", "nonPassTRatio");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("non_pass_t_cnt", "nonPassTCnt");
		this.hashFields.put("tot_so_cnt", "totSoCnt");
		this.hashFields.put("non_pass_o_ratio", "nonPassORatio");
		this.hashFields.put("non_pass_r_cnt", "nonPassRCnt");
		this.hashFields.put("cpy_no", "cpyNo");
		this.hashFields.put("pass_cnt", "passCnt");
		this.hashFields.put("non_pass_ratio", "nonPassRatio");
		this.hashFields.put("non_pass_r_ratio", "nonPassRRatio");
		this.hashFields.put("non_pass_n_cnt", "nonPassNCnt");
		this.hashFields.put("in_from_date", "inFromDate");
		this.hashFields.put("non_pass_o_cnt", "nonPassOCnt");
		this.hashFields.put("qry_trsp_mod_cd", "qryTrspModCd");
		this.hashFields.put("grp_no", "grpNo");
		this.hashFields.put("non_pass_cnt", "nonPassCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return nonPassNRatio
	 */
	public String getNonPassNRatio() {
		return this.nonPassNRatio;
	}
	
	/**
	 * Column Info
	 * @return inToDate
	 */
	public String getInToDate() {
		return this.inToDate;
	}
	
	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}
	
	/**
	 * Column Info
	 * @return qryOfcCd
	 */
	public String getQryOfcCd() {
		return this.qryOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dscrRsnMap
	 */
	public String getDscrRsnMap() {
		return this.dscrRsnMap;
	}
	
	/**
	 * Column Info
	 * @return woCreOfcCd
	 */
	public String getWoCreOfcCd() {
		return this.woCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @return trspModCd
	 */
	public String getTrspModCd() {
		return this.trspModCd;
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
	 * @return nonPassTRatio
	 */
	public String getNonPassTRatio() {
		return this.nonPassTRatio;
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
	 * @return nonPassTCnt
	 */
	public String getNonPassTCnt() {
		return this.nonPassTCnt;
	}
	
	/**
	 * Column Info
	 * @return totSoCnt
	 */
	public String getTotSoCnt() {
		return this.totSoCnt;
	}
	
	/**
	 * Column Info
	 * @return nonPassORatio
	 */
	public String getNonPassORatio() {
		return this.nonPassORatio;
	}
	
	/**
	 * Column Info
	 * @return nonPassRCnt
	 */
	public String getNonPassRCnt() {
		return this.nonPassRCnt;
	}
	
	/**
	 * Column Info
	 * @return cpyNo
	 */
	public String getCpyNo() {
		return this.cpyNo;
	}
	
	/**
	 * Column Info
	 * @return passCnt
	 */
	public String getPassCnt() {
		return this.passCnt;
	}
	
	/**
	 * Column Info
	 * @return nonPassRatio
	 */
	public String getNonPassRatio() {
		return this.nonPassRatio;
	}
	
	/**
	 * Column Info
	 * @return nonPassRRatio
	 */
	public String getNonPassRRatio() {
		return this.nonPassRRatio;
	}
	
	/**
	 * Column Info
	 * @return nonPassNCnt
	 */
	public String getNonPassNCnt() {
		return this.nonPassNCnt;
	}
	
	/**
	 * Column Info
	 * @return inFromDate
	 */
	public String getInFromDate() {
		return this.inFromDate;
	}
	
	/**
	 * Column Info
	 * @return nonPassOCnt
	 */
	public String getNonPassOCnt() {
		return this.nonPassOCnt;
	}
	
	/**
	 * Column Info
	 * @return qryTrspModCd
	 */
	public String getQryTrspModCd() {
		return this.qryTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return grpNo
	 */
	public String getGrpNo() {
		return this.grpNo;
	}
	
	/**
	 * Column Info
	 * @return nonPassCnt
	 */
	public String getNonPassCnt() {
		return this.nonPassCnt;
	}
	

	/**
	 * Column Info
	 * @param nonPassNRatio
	 */
	public void setNonPassNRatio(String nonPassNRatio) {
		this.nonPassNRatio = nonPassNRatio;
	}
	
	/**
	 * Column Info
	 * @param inToDate
	 */
	public void setInToDate(String inToDate) {
		this.inToDate = inToDate;
	}
	
	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Column Info
	 * @param qryOfcCd
	 */
	public void setQryOfcCd(String qryOfcCd) {
		this.qryOfcCd = qryOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dscrRsnMap
	 */
	public void setDscrRsnMap(String dscrRsnMap) {
		this.dscrRsnMap = dscrRsnMap;
	}
	
	/**
	 * Column Info
	 * @param woCreOfcCd
	 */
	public void setWoCreOfcCd(String woCreOfcCd) {
		this.woCreOfcCd = woCreOfcCd;
	}
	
	/**
	 * Column Info
	 * @param trspModCd
	 */
	public void setTrspModCd(String trspModCd) {
		this.trspModCd = trspModCd;
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
	 * @param nonPassTRatio
	 */
	public void setNonPassTRatio(String nonPassTRatio) {
		this.nonPassTRatio = nonPassTRatio;
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
	 * @param nonPassTCnt
	 */
	public void setNonPassTCnt(String nonPassTCnt) {
		this.nonPassTCnt = nonPassTCnt;
	}
	
	/**
	 * Column Info
	 * @param totSoCnt
	 */
	public void setTotSoCnt(String totSoCnt) {
		this.totSoCnt = totSoCnt;
	}
	
	/**
	 * Column Info
	 * @param nonPassORatio
	 */
	public void setNonPassORatio(String nonPassORatio) {
		this.nonPassORatio = nonPassORatio;
	}
	
	/**
	 * Column Info
	 * @param nonPassRCnt
	 */
	public void setNonPassRCnt(String nonPassRCnt) {
		this.nonPassRCnt = nonPassRCnt;
	}
	
	/**
	 * Column Info
	 * @param cpyNo
	 */
	public void setCpyNo(String cpyNo) {
		this.cpyNo = cpyNo;
	}
	
	/**
	 * Column Info
	 * @param passCnt
	 */
	public void setPassCnt(String passCnt) {
		this.passCnt = passCnt;
	}
	
	/**
	 * Column Info
	 * @param nonPassRatio
	 */
	public void setNonPassRatio(String nonPassRatio) {
		this.nonPassRatio = nonPassRatio;
	}
	
	/**
	 * Column Info
	 * @param nonPassRRatio
	 */
	public void setNonPassRRatio(String nonPassRRatio) {
		this.nonPassRRatio = nonPassRRatio;
	}
	
	/**
	 * Column Info
	 * @param nonPassNCnt
	 */
	public void setNonPassNCnt(String nonPassNCnt) {
		this.nonPassNCnt = nonPassNCnt;
	}
	
	/**
	 * Column Info
	 * @param inFromDate
	 */
	public void setInFromDate(String inFromDate) {
		this.inFromDate = inFromDate;
	}
	
	/**
	 * Column Info
	 * @param nonPassOCnt
	 */
	public void setNonPassOCnt(String nonPassOCnt) {
		this.nonPassOCnt = nonPassOCnt;
	}
	
	/**
	 * Column Info
	 * @param qryTrspModCd
	 */
	public void setQryTrspModCd(String qryTrspModCd) {
		this.qryTrspModCd = qryTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param grpNo
	 */
	public void setGrpNo(String grpNo) {
		this.grpNo = grpNo;
	}
	
	/**
	 * Column Info
	 * @param nonPassCnt
	 */
	public void setNonPassCnt(String nonPassCnt) {
		this.nonPassCnt = nonPassCnt;
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
		setNonPassNRatio(JSPUtil.getParameter(request, prefix + "non_pass_n_ratio", ""));
		setInToDate(JSPUtil.getParameter(request, prefix + "in_to_date", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setQryOfcCd(JSPUtil.getParameter(request, prefix + "qry_ofc_cd", ""));
		setDscrRsnMap(JSPUtil.getParameter(request, prefix + "dscr_rsn_map", ""));
		setWoCreOfcCd(JSPUtil.getParameter(request, prefix + "wo_cre_ofc_cd", ""));
		setTrspModCd(JSPUtil.getParameter(request, prefix + "trsp_mod_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNonPassTRatio(JSPUtil.getParameter(request, prefix + "non_pass_t_ratio", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNonPassTCnt(JSPUtil.getParameter(request, prefix + "non_pass_t_cnt", ""));
		setTotSoCnt(JSPUtil.getParameter(request, prefix + "tot_so_cnt", ""));
		setNonPassORatio(JSPUtil.getParameter(request, prefix + "non_pass_o_ratio", ""));
		setNonPassRCnt(JSPUtil.getParameter(request, prefix + "non_pass_r_cnt", ""));
		setCpyNo(JSPUtil.getParameter(request, prefix + "cpy_no", ""));
		setPassCnt(JSPUtil.getParameter(request, prefix + "pass_cnt", ""));
		setNonPassRatio(JSPUtil.getParameter(request, prefix + "non_pass_ratio", ""));
		setNonPassRRatio(JSPUtil.getParameter(request, prefix + "non_pass_r_ratio", ""));
		setNonPassNCnt(JSPUtil.getParameter(request, prefix + "non_pass_n_cnt", ""));
		setInFromDate(JSPUtil.getParameter(request, prefix + "in_from_date", ""));
		setNonPassOCnt(JSPUtil.getParameter(request, prefix + "non_pass_o_cnt", ""));
		setQryTrspModCd(JSPUtil.getParameter(request, prefix + "qry_trsp_mod_cd", ""));
		setGrpNo(JSPUtil.getParameter(request, prefix + "grp_no", ""));
		setNonPassCnt(JSPUtil.getParameter(request, prefix + "non_pass_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OptmRoutPassSmryVO[]
	 */
	public OptmRoutPassSmryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OptmRoutPassSmryVO[]
	 */
	public OptmRoutPassSmryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OptmRoutPassSmryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] nonPassNRatio = (JSPUtil.getParameter(request, prefix	+ "non_pass_n_ratio", length));
			String[] inToDate = (JSPUtil.getParameter(request, prefix	+ "in_to_date", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] qryOfcCd = (JSPUtil.getParameter(request, prefix	+ "qry_ofc_cd", length));
			String[] dscrRsnMap = (JSPUtil.getParameter(request, prefix	+ "dscr_rsn_map", length));
			String[] woCreOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_cre_ofc_cd", length));
			String[] trspModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_mod_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] nonPassTRatio = (JSPUtil.getParameter(request, prefix	+ "non_pass_t_ratio", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] nonPassTCnt = (JSPUtil.getParameter(request, prefix	+ "non_pass_t_cnt", length));
			String[] totSoCnt = (JSPUtil.getParameter(request, prefix	+ "tot_so_cnt", length));
			String[] nonPassORatio = (JSPUtil.getParameter(request, prefix	+ "non_pass_o_ratio", length));
			String[] nonPassRCnt = (JSPUtil.getParameter(request, prefix	+ "non_pass_r_cnt", length));
			String[] cpyNo = (JSPUtil.getParameter(request, prefix	+ "cpy_no", length));
			String[] passCnt = (JSPUtil.getParameter(request, prefix	+ "pass_cnt", length));
			String[] nonPassRatio = (JSPUtil.getParameter(request, prefix	+ "non_pass_ratio", length));
			String[] nonPassRRatio = (JSPUtil.getParameter(request, prefix	+ "non_pass_r_ratio", length));
			String[] nonPassNCnt = (JSPUtil.getParameter(request, prefix	+ "non_pass_n_cnt", length));
			String[] inFromDate = (JSPUtil.getParameter(request, prefix	+ "in_from_date", length));
			String[] nonPassOCnt = (JSPUtil.getParameter(request, prefix	+ "non_pass_o_cnt", length));
			String[] qryTrspModCd = (JSPUtil.getParameter(request, prefix	+ "qry_trsp_mod_cd", length));
			String[] grpNo = (JSPUtil.getParameter(request, prefix	+ "grp_no", length));
			String[] nonPassCnt = (JSPUtil.getParameter(request, prefix	+ "non_pass_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new OptmRoutPassSmryVO();
				if (nonPassNRatio[i] != null)
					model.setNonPassNRatio(nonPassNRatio[i]);
				if (inToDate[i] != null)
					model.setInToDate(inToDate[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (qryOfcCd[i] != null)
					model.setQryOfcCd(qryOfcCd[i]);
				if (dscrRsnMap[i] != null)
					model.setDscrRsnMap(dscrRsnMap[i]);
				if (woCreOfcCd[i] != null)
					model.setWoCreOfcCd(woCreOfcCd[i]);
				if (trspModCd[i] != null)
					model.setTrspModCd(trspModCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (nonPassTRatio[i] != null)
					model.setNonPassTRatio(nonPassTRatio[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (nonPassTCnt[i] != null)
					model.setNonPassTCnt(nonPassTCnt[i]);
				if (totSoCnt[i] != null)
					model.setTotSoCnt(totSoCnt[i]);
				if (nonPassORatio[i] != null)
					model.setNonPassORatio(nonPassORatio[i]);
				if (nonPassRCnt[i] != null)
					model.setNonPassRCnt(nonPassRCnt[i]);
				if (cpyNo[i] != null)
					model.setCpyNo(cpyNo[i]);
				if (passCnt[i] != null)
					model.setPassCnt(passCnt[i]);
				if (nonPassRatio[i] != null)
					model.setNonPassRatio(nonPassRatio[i]);
				if (nonPassRRatio[i] != null)
					model.setNonPassRRatio(nonPassRRatio[i]);
				if (nonPassNCnt[i] != null)
					model.setNonPassNCnt(nonPassNCnt[i]);
				if (inFromDate[i] != null)
					model.setInFromDate(inFromDate[i]);
				if (nonPassOCnt[i] != null)
					model.setNonPassOCnt(nonPassOCnt[i]);
				if (qryTrspModCd[i] != null)
					model.setQryTrspModCd(qryTrspModCd[i]);
				if (grpNo[i] != null)
					model.setGrpNo(grpNo[i]);
				if (nonPassCnt[i] != null)
					model.setNonPassCnt(nonPassCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOptmRoutPassSmryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OptmRoutPassSmryVO[]
	 */
	public OptmRoutPassSmryVO[] getOptmRoutPassSmryVOs(){
		OptmRoutPassSmryVO[] vos = (OptmRoutPassSmryVO[])models.toArray(new OptmRoutPassSmryVO[models.size()]);
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
		this.nonPassNRatio = this.nonPassNRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inToDate = this.inToDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qryOfcCd = this.qryOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dscrRsnMap = this.dscrRsnMap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woCreOfcCd = this.woCreOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspModCd = this.trspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonPassTRatio = this.nonPassTRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonPassTCnt = this.nonPassTCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totSoCnt = this.totSoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonPassORatio = this.nonPassORatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonPassRCnt = this.nonPassRCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cpyNo = this.cpyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.passCnt = this.passCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonPassRatio = this.nonPassRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonPassRRatio = this.nonPassRRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonPassNCnt = this.nonPassNCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inFromDate = this.inFromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonPassOCnt = this.nonPassOCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qryTrspModCd = this.qryTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpNo = this.grpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonPassCnt = this.nonPassCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
