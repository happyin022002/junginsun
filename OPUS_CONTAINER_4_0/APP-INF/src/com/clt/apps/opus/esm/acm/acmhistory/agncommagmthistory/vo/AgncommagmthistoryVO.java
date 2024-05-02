/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgncommagmthistoryVO.java
*@FileTitle : AgncommagmthistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.04
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.07.04 김봉균
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgncommagmthistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<AgncommagmthistoryVO> models = new ArrayList<AgncommagmthistoryVO>();

	/* Column Info */
	private String loginOfc = null;
	/* Column Info */
	private String creLoclDtTm = null;
	/* Column Info */
	private String agmtHisNo = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String agmtFmDtCd = null;
	/* Column Info */
	private String creDt = null;
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
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creGdtTm = null;
	/* Column Info */
	private String creGdt = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String agnAgmtRmk = null;
	/* Column Info */
	private String agmtToDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public AgncommagmthistoryVO() {}

	public AgncommagmthistoryVO(String ibflag, String pagerows, String agnCd, String agnAgmtNo, String agmtHisNo, String agmtFmDtCd, String agmtFmDt, String agmtToDtCd, String agmtToDt, String agnAgmtRmk, String creDt, String creGdt, String creGdtTm, String creLoclDt, String creLoclDtTm, String loginOfc, String creUsrId, String deltFlg) {
		this.loginOfc = loginOfc;
		this.creLoclDtTm = creLoclDtTm;
		this.agmtHisNo = agmtHisNo;
		this.deltFlg = deltFlg;
		this.agmtFmDtCd = agmtFmDtCd;
		this.creDt = creDt;
		this.agmtFmDt = agmtFmDt;
		this.agmtToDtCd = agmtToDtCd;
		this.pagerows = pagerows;
		this.agnAgmtNo = agnAgmtNo;
		this.agnCd = agnCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.creGdtTm = creGdtTm;
		this.creGdt = creGdt;
		this.creLoclDt = creLoclDt;
		this.agnAgmtRmk = agnAgmtRmk;
		this.agmtToDt = agmtToDt;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("login_ofc", getLoginOfc());
		this.hashColumns.put("cre_locl_dt_tm", getCreLoclDtTm());
		this.hashColumns.put("agmt_his_no", getAgmtHisNo());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("agmt_fm_dt_cd", getAgmtFmDtCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("agmt_fm_dt", getAgmtFmDt());
		this.hashColumns.put("agmt_to_dt_cd", getAgmtToDtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_agmt_no", getAgnAgmtNo());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_gdt_tm", getCreGdtTm());
		this.hashColumns.put("cre_gdt", getCreGdt());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("agn_agmt_rmk", getAgnAgmtRmk());
		this.hashColumns.put("agmt_to_dt", getAgmtToDt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("login_ofc", "loginOfc");
		this.hashFields.put("cre_locl_dt_tm", "creLoclDtTm");
		this.hashFields.put("agmt_his_no", "agmtHisNo");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("agmt_fm_dt_cd", "agmtFmDtCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("agmt_fm_dt", "agmtFmDt");
		this.hashFields.put("agmt_to_dt_cd", "agmtToDtCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_agmt_no", "agnAgmtNo");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_gdt_tm", "creGdtTm");
		this.hashFields.put("cre_gdt", "creGdt");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("agn_agmt_rmk", "agnAgmtRmk");
		this.hashFields.put("agmt_to_dt", "agmtToDt");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return loginOfc
	 */
	public String getLoginOfc() {
		return this.loginOfc;
	}

	/**
	 * Column Info
	 * @return creLoclDtTm
	 */
	public String getCreLoclDtTm() {
		return this.creLoclDtTm;
	}

	/**
	 * Column Info
	 * @return agmtHisNo
	 */
	public String getAgmtHisNo() {
		return this.agmtHisNo;
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
	 * @return agmtFmDtCd
	 */
	public String getAgmtFmDtCd() {
		return this.agmtFmDtCd;
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
	 * @return creGdtTm
	 */
	public String getCreGdtTm() {
		return this.creGdtTm;
	}

	/**
	 * Column Info
	 * @return creGdt
	 */
	public String getCreGdt() {
		return this.creGdt;
	}

	/**
	 * Column Info
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
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
	 * @return agmtToDt
	 */
	public String getAgmtToDt() {
		return this.agmtToDt;
	}


	/**
	 * Column Info
	 * @param loginOfc
	 */
	public void setLoginOfc(String loginOfc) {
		this.loginOfc = loginOfc;
	}

	/**
	 * Column Info
	 * @param creLoclDtTm
	 */
	public void setCreLoclDtTm(String creLoclDtTm) {
		this.creLoclDtTm = creLoclDtTm;
	}

	/**
	 * Column Info
	 * @param agmtHisNo
	 */
	public void setAgmtHisNo(String agmtHisNo) {
		this.agmtHisNo = agmtHisNo;
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
	 * @param agmtFmDtCd
	 */
	public void setAgmtFmDtCd(String agmtFmDtCd) {
		this.agmtFmDtCd = agmtFmDtCd;
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
	 * @param creGdtTm
	 */
	public void setCreGdtTm(String creGdtTm) {
		this.creGdtTm = creGdtTm;
	}

	/**
	 * Column Info
	 * @param creGdt
	 */
	public void setCreGdt(String creGdt) {
		this.creGdt = creGdt;
	}

	/**
	 * Column Info
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
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
		setLoginOfc(JSPUtil.getParameter(request, prefix + "login_ofc", ""));
		setCreLoclDtTm(JSPUtil.getParameter(request, prefix + "cre_locl_dt_tm", ""));
		setAgmtHisNo(JSPUtil.getParameter(request, prefix + "agmt_his_no", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setAgmtFmDtCd(JSPUtil.getParameter(request, prefix + "agmt_fm_dt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setAgmtFmDt(JSPUtil.getParameter(request, prefix + "agmt_fm_dt", ""));
		setAgmtToDtCd(JSPUtil.getParameter(request, prefix + "agmt_to_dt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnAgmtNo(JSPUtil.getParameter(request, prefix + "agn_agmt_no", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreGdtTm(JSPUtil.getParameter(request, prefix + "cre_gdt_tm", ""));
		setCreGdt(JSPUtil.getParameter(request, prefix + "cre_gdt", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
		setAgnAgmtRmk(JSPUtil.getParameter(request, prefix + "agn_agmt_rmk", ""));
		setAgmtToDt(JSPUtil.getParameter(request, prefix + "agmt_to_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgncommagmthistoryVO[]
	 */
	public AgncommagmthistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AgncommagmthistoryVO[]
	 */
	public AgncommagmthistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgncommagmthistoryVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] loginOfc = (JSPUtil.getParameter(request, prefix	+ "login_ofc", length));
			String[] creLoclDtTm = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt_tm", length));
			String[] agmtHisNo = (JSPUtil.getParameter(request, prefix	+ "agmt_his_no", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] agmtFmDtCd = (JSPUtil.getParameter(request, prefix	+ "agmt_fm_dt_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] agmtFmDt = (JSPUtil.getParameter(request, prefix	+ "agmt_fm_dt", length));
			String[] agmtToDtCd = (JSPUtil.getParameter(request, prefix	+ "agmt_to_dt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnAgmtNo = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_no", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creGdtTm = (JSPUtil.getParameter(request, prefix	+ "cre_gdt_tm", length));
			String[] creGdt = (JSPUtil.getParameter(request, prefix	+ "cre_gdt", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] agnAgmtRmk = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_rmk", length));
			String[] agmtToDt = (JSPUtil.getParameter(request, prefix	+ "agmt_to_dt", length));

			for (int i = 0; i < length; i++) {
				model = new AgncommagmthistoryVO();
				if (loginOfc[i] != null)
					model.setLoginOfc(loginOfc[i]);
				if (creLoclDtTm[i] != null)
					model.setCreLoclDtTm(creLoclDtTm[i]);
				if (agmtHisNo[i] != null)
					model.setAgmtHisNo(agmtHisNo[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (agmtFmDtCd[i] != null)
					model.setAgmtFmDtCd(agmtFmDtCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
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
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creGdtTm[i] != null)
					model.setCreGdtTm(creGdtTm[i]);
				if (creGdt[i] != null)
					model.setCreGdt(creGdt[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (agnAgmtRmk[i] != null)
					model.setAgnAgmtRmk(agnAgmtRmk[i]);
				if (agmtToDt[i] != null)
					model.setAgmtToDt(agmtToDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgncommagmthistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgncommagmthistoryVO[]
	 */
	public AgncommagmthistoryVO[] getAgncommagmthistoryVOs(){
		AgncommagmthistoryVO[] vos = (AgncommagmthistoryVO[])models.toArray(new AgncommagmthistoryVO[models.size()]);
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
		this.loginOfc = this.loginOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDtTm = this.creLoclDtTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtHisNo = this.agmtHisNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtFmDtCd = this.agmtFmDtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtFmDt = this.agmtFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtToDtCd = this.agmtToDtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtNo = this.agnAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creGdtTm = this.creGdtTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creGdt = this.creGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtRmk = this.agnAgmtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtToDt = this.agmtToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
