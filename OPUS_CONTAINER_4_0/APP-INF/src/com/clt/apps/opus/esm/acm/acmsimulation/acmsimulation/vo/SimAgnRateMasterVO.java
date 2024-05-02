/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SimAgnRateMasterVO.java
*@FileTitle : SimAgnRateMasterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.06.05 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SimAgnRateMasterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SimAgnRateMasterVO> models = new ArrayList<SimAgnRateMasterVO>();

	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String newAgmtNo = null;
	/* Column Info */
	private String agmtFmDtCd = null;
	/* Column Info */
	private String agmtFmDt = null;
	/* Column Info */
	private String agmtToDtCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnAgmtNo = null;
	/* Column Info */
	private String agnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agnAgmtRmk = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String dateErrChk = null;
	/* Column Info */
	private String updDtLcl = null;
	/* Column Info */
	private String updDtGmt = null;
	/* Column Info */
	private String agmtToDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SimAgnRateMasterVO() {}

	public SimAgnRateMasterVO(String ibflag, String pagerows, String newAgmtNo, String dateErrChk, String agnAgmtNo, String agmtFmDtCd, String agmtFmDt, String agmtToDtCd, String agmtToDt, String agnAgmtRmk, String updDtLcl, String updDtGmt, String usrId, String deltFlg, String agnCd) {
		this.deltFlg = deltFlg;
		this.newAgmtNo = newAgmtNo;
		this.agmtFmDtCd = agmtFmDtCd;
		this.agmtFmDt = agmtFmDt;
		this.agmtToDtCd = agmtToDtCd;
		this.pagerows = pagerows;
		this.agnAgmtNo = agnAgmtNo;
		this.agnCd = agnCd;
		this.ibflag = ibflag;
		this.agnAgmtRmk = agnAgmtRmk;
		this.usrId = usrId;
		this.dateErrChk = dateErrChk;
		this.updDtLcl = updDtLcl;
		this.updDtGmt = updDtGmt;
		this.agmtToDt = agmtToDt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("new_agmt_no", getNewAgmtNo());
		this.hashColumns.put("agmt_fm_dt_cd", getAgmtFmDtCd());
		this.hashColumns.put("agmt_fm_dt", getAgmtFmDt());
		this.hashColumns.put("agmt_to_dt_cd", getAgmtToDtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_agmt_no", getAgnAgmtNo());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agn_agmt_rmk", getAgnAgmtRmk());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("date_err_chk", getDateErrChk());
		this.hashColumns.put("upd_dt_lcl", getUpdDtLcl());
		this.hashColumns.put("upd_dt_gmt", getUpdDtGmt());
		this.hashColumns.put("agmt_to_dt", getAgmtToDt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("new_agmt_no", "newAgmtNo");
		this.hashFields.put("agmt_fm_dt_cd", "agmtFmDtCd");
		this.hashFields.put("agmt_fm_dt", "agmtFmDt");
		this.hashFields.put("agmt_to_dt_cd", "agmtToDtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_agmt_no", "agnAgmtNo");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agn_agmt_rmk", "agnAgmtRmk");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("date_err_chk", "dateErrChk");
		this.hashFields.put("upd_dt_lcl", "updDtLcl");
		this.hashFields.put("upd_dt_gmt", "updDtGmt");
		this.hashFields.put("agmt_to_dt", "agmtToDt");
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
	 * @return newAgmtNo
	 */
	public String getNewAgmtNo() {
		return this.newAgmtNo;
	}

	/**
	 * Column Info
	 * @return agmtFmDtCd
	 */
	public String getAgmtFmDtCd() {
		return this.agmtFmDtCd;
	}

	/**
	 * Column Info
	 * @return agmtFmDt
	 */
	public String getAgmtFmDt() {
		return this.agmtFmDt;
	}

	/**
	 * Column Info
	 * @return agmtToDtCd
	 */
	public String getAgmtToDtCd() {
		return this.agmtToDtCd;
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
	 * @return agnAgmtNo
	 */
	public String getAgnAgmtNo() {
		return this.agnAgmtNo;
	}

	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
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
	 * @return agnAgmtRmk
	 */
	public String getAgnAgmtRmk() {
		return this.agnAgmtRmk;
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
	 * @return dateErrChk
	 */
	public String getDateErrChk() {
		return this.dateErrChk;
	}

	/**
	 * Column Info
	 * @return updDtLcl
	 */
	public String getUpdDtLcl() {
		return this.updDtLcl;
	}

	/**
	 * Column Info
	 * @return updDtGmt
	 */
	public String getUpdDtGmt() {
		return this.updDtGmt;
	}

	/**
	 * Column Info
	 * @return agmtToDt
	 */
	public String getAgmtToDt() {
		return this.agmtToDt;
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
	 * @param newAgmtNo
	 */
	public void setNewAgmtNo(String newAgmtNo) {
		this.newAgmtNo = newAgmtNo;
	}

	/**
	 * Column Info
	 * @param agmtFmDtCd
	 */
	public void setAgmtFmDtCd(String agmtFmDtCd) {
		this.agmtFmDtCd = agmtFmDtCd;
	}

	/**
	 * Column Info
	 * @param agmtFmDt
	 */
	public void setAgmtFmDt(String agmtFmDt) {
		this.agmtFmDt = agmtFmDt;
	}

	/**
	 * Column Info
	 * @param agmtToDtCd
	 */
	public void setAgmtToDtCd(String agmtToDtCd) {
		this.agmtToDtCd = agmtToDtCd;
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
	 * @param agnAgmtNo
	 */
	public void setAgnAgmtNo(String agnAgmtNo) {
		this.agnAgmtNo = agnAgmtNo;
	}

	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
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
	 * @param agnAgmtRmk
	 */
	public void setAgnAgmtRmk(String agnAgmtRmk) {
		this.agnAgmtRmk = agnAgmtRmk;
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
	 * @param dateErrChk
	 */
	public void setDateErrChk(String dateErrChk) {
		this.dateErrChk = dateErrChk;
	}

	/**
	 * Column Info
	 * @param updDtLcl
	 */
	public void setUpdDtLcl(String updDtLcl) {
		this.updDtLcl = updDtLcl;
	}

	/**
	 * Column Info
	 * @param updDtGmt
	 */
	public void setUpdDtGmt(String updDtGmt) {
		this.updDtGmt = updDtGmt;
	}

	/**
	 * Column Info
	 * @param agmtToDt
	 */
	public void setAgmtToDt(String agmtToDt) {
		this.agmtToDt = agmtToDt;
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
		setNewAgmtNo(JSPUtil.getParameter(request, prefix + "new_agmt_no", ""));
		setAgmtFmDtCd(JSPUtil.getParameter(request, prefix + "agmt_fm_dt_cd", ""));
		setAgmtFmDt(JSPUtil.getParameter(request, prefix + "agmt_fm_dt", ""));
		setAgmtToDtCd(JSPUtil.getParameter(request, prefix + "agmt_to_dt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnAgmtNo(JSPUtil.getParameter(request, prefix + "agn_agmt_no", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAgnAgmtRmk(JSPUtil.getParameter(request, prefix + "agn_agmt_rmk", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setDateErrChk(JSPUtil.getParameter(request, prefix + "date_err_chk", ""));
		setUpdDtLcl(JSPUtil.getParameter(request, prefix + "upd_dt_lcl", ""));
		setUpdDtGmt(JSPUtil.getParameter(request, prefix + "upd_dt_gmt", ""));
		setAgmtToDt(JSPUtil.getParameter(request, prefix + "agmt_to_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SimAgnRateMasterVO[]
	 */
	public SimAgnRateMasterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SimAgnRateMasterVO[]
	 */
	public SimAgnRateMasterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SimAgnRateMasterVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] newAgmtNo = (JSPUtil.getParameter(request, prefix	+ "new_agmt_no", length));
			String[] agmtFmDtCd = (JSPUtil.getParameter(request, prefix	+ "agmt_fm_dt_cd", length));
			String[] agmtFmDt = (JSPUtil.getParameter(request, prefix	+ "agmt_fm_dt", length));
			String[] agmtToDtCd = (JSPUtil.getParameter(request, prefix	+ "agmt_to_dt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnAgmtNo = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_no", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] agnAgmtRmk = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_rmk", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] dateErrChk = (JSPUtil.getParameter(request, prefix	+ "date_err_chk", length));
			String[] updDtLcl = (JSPUtil.getParameter(request, prefix	+ "upd_dt_lcl", length));
			String[] updDtGmt = (JSPUtil.getParameter(request, prefix	+ "upd_dt_gmt", length));
			String[] agmtToDt = (JSPUtil.getParameter(request, prefix	+ "agmt_to_dt", length));

			for (int i = 0; i < length; i++) {
				model = new SimAgnRateMasterVO();
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (newAgmtNo[i] != null)
					model.setNewAgmtNo(newAgmtNo[i]);
				if (agmtFmDtCd[i] != null)
					model.setAgmtFmDtCd(agmtFmDtCd[i]);
				if (agmtFmDt[i] != null)
					model.setAgmtFmDt(agmtFmDt[i]);
				if (agmtToDtCd[i] != null)
					model.setAgmtToDtCd(agmtToDtCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnAgmtNo[i] != null)
					model.setAgnAgmtNo(agnAgmtNo[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agnAgmtRmk[i] != null)
					model.setAgnAgmtRmk(agnAgmtRmk[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (dateErrChk[i] != null)
					model.setDateErrChk(dateErrChk[i]);
				if (updDtLcl[i] != null)
					model.setUpdDtLcl(updDtLcl[i]);
				if (updDtGmt[i] != null)
					model.setUpdDtGmt(updDtGmt[i]);
				if (agmtToDt[i] != null)
					model.setAgmtToDt(agmtToDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSimAgnRateMasterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SimAgnRateMasterVO[]
	 */
	public SimAgnRateMasterVO[] getSimAgnRateMasterVOs(){
		SimAgnRateMasterVO[] vos = (SimAgnRateMasterVO[])models.toArray(new SimAgnRateMasterVO[models.size()]);
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
		this.newAgmtNo = this.newAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtFmDtCd = this.agmtFmDtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtFmDt = this.agmtFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtToDtCd = this.agmtToDtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtNo = this.agnAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtRmk = this.agnAgmtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateErrChk = this.dateErrChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDtLcl = this.updDtLcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDtGmt = this.updDtGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtToDt = this.agmtToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
