/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchAgreementVO.java
*@FileTitle : SearchAgreementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.10 김상수
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

public class SearchAgreementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchAgreementVO> models = new ArrayList<SearchAgreementVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String agnAgmtNo = null;
	/* Column Info */
	private String agnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String agmtFmDtCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String agmtToDtCd = null;
	/* Column Info */
	private String agmtFmDt = null;
	/* Column Info */
	private String agmtToDt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchAgreementVO() {}

	public SearchAgreementVO(String ibflag, String pagerows, String agnCd, String agnAgmtNo, String agmtFmDtCd, String agmtFmDt, String agmtToDtCd, String agmtToDt, String deltFlg, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.agnAgmtNo = agnAgmtNo;
		this.agnCd = agnCd;
		this.ibflag = ibflag;
		this.deltFlg = deltFlg;
		this.agmtFmDtCd = agmtFmDtCd;
		this.updUsrId = updUsrId;
		this.agmtToDtCd = agmtToDtCd;
		this.agmtFmDt = agmtFmDt;
		this.agmtToDt = agmtToDt;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("agn_agmt_no", getAgnAgmtNo());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("agmt_fm_dt_cd", getAgmtFmDtCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("agmt_to_dt_cd", getAgmtToDtCd());
		this.hashColumns.put("agmt_fm_dt", getAgmtFmDt());
		this.hashColumns.put("agmt_to_dt", getAgmtToDt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("agn_agmt_no", "agnAgmtNo");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("agmt_fm_dt_cd", "agmtFmDtCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("agmt_to_dt_cd", "agmtToDtCd");
		this.hashFields.put("agmt_fm_dt", "agmtFmDt");
		this.hashFields.put("agmt_to_dt", "agmtToDt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}

	/**
	 * Column Info
	 * @return agmtToDtCd
	 */
	public String getAgmtToDtCd() {
		return this.agmtToDtCd;
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
	 * @return agmtToDt
	 */
	public String getAgmtToDt() {
		return this.agmtToDt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * Column Info
	 * @param agmtToDtCd
	 */
	public void setAgmtToDtCd(String agmtToDtCd) {
		this.agmtToDtCd = agmtToDtCd;
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
	 * @param agmtToDt
	 */
	public void setAgmtToDt(String agmtToDt) {
		this.agmtToDt = agmtToDt;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setAgnAgmtNo(JSPUtil.getParameter(request, prefix + "agn_agmt_no", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setAgmtFmDtCd(JSPUtil.getParameter(request, prefix + "agmt_fm_dt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAgmtToDtCd(JSPUtil.getParameter(request, prefix + "agmt_to_dt_cd", ""));
		setAgmtFmDt(JSPUtil.getParameter(request, prefix + "agmt_fm_dt", ""));
		setAgmtToDt(JSPUtil.getParameter(request, prefix + "agmt_to_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAgreementVO[]
	 */
	public SearchAgreementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchAgreementVO[]
	 */
	public SearchAgreementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAgreementVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] agnAgmtNo = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_no", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] agmtFmDtCd = (JSPUtil.getParameter(request, prefix	+ "agmt_fm_dt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] agmtToDtCd = (JSPUtil.getParameter(request, prefix	+ "agmt_to_dt_cd", length));
			String[] agmtFmDt = (JSPUtil.getParameter(request, prefix	+ "agmt_fm_dt", length));
			String[] agmtToDt = (JSPUtil.getParameter(request, prefix	+ "agmt_to_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new SearchAgreementVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (agnAgmtNo[i] != null)
					model.setAgnAgmtNo(agnAgmtNo[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (agmtFmDtCd[i] != null)
					model.setAgmtFmDtCd(agmtFmDtCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (agmtToDtCd[i] != null)
					model.setAgmtToDtCd(agmtToDtCd[i]);
				if (agmtFmDt[i] != null)
					model.setAgmtFmDt(agmtFmDt[i]);
				if (agmtToDt[i] != null)
					model.setAgmtToDt(agmtToDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAgreementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAgreementVO[]
	 */
	public SearchAgreementVO[] getSearchAgreementVOs(){
		SearchAgreementVO[] vos = (SearchAgreementVO[])models.toArray(new SearchAgreementVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtNo = this.agnAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtFmDtCd = this.agmtFmDtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtToDtCd = this.agmtToDtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtFmDt = this.agmtFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtToDt = this.agmtToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
