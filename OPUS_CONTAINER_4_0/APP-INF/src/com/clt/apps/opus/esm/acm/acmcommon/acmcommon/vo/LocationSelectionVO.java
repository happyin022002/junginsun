/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : LocationSelectionVO.java
*@FileTitle : LocationSelectionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.21
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.06.21 김상수
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmcommon.acmcommon.vo;

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

public class LocationSelectionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<LocationSelectionVO> models = new ArrayList<LocationSelectionVO>();

	/* Column Info */
	private String scontiNm = null;
	/* Column Info */
	private String routRefDivCd = null;
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String agnAgmtNo = null;
	/* Column Info */
	private String agnAgmtSeq = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntNm = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String contiNm = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String agnAgmtRoutSeq = null;
	/* Column Info */
	private String acTpCd = null;
	/* Column Info */
	private String scontiCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public LocationSelectionVO() {}

	public LocationSelectionVO(String ibflag, String pagerows, String acTpCd, String agnAgmtNo, String agnAgmtRoutSeq, String agnAgmtSeq, String agnCd, String chk, String cntCd, String cntNm, String contiCd, String contiNm, String ioBndCd, String locCd, String locNm, String routRefDivCd, String scontiCd, String scontiNm, String usrId) {
		this.scontiNm = scontiNm;
		this.routRefDivCd = routRefDivCd;
		this.contiCd = contiCd;
		this.locNm = locNm;
		this.ioBndCd = ioBndCd;
		this.pagerows = pagerows;
		this.agnAgmtNo = agnAgmtNo;
		this.agnAgmtSeq = agnAgmtSeq;
		this.agnCd = agnCd;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.cntNm = cntNm;
		this.chk = chk;
		this.usrId = usrId;
		this.contiNm = contiNm;
		this.cntCd = cntCd;
		this.agnAgmtRoutSeq = agnAgmtRoutSeq;
		this.acTpCd = acTpCd;
		this.scontiCd = scontiCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sconti_nm", getScontiNm());
		this.hashColumns.put("rout_ref_div_cd", getRoutRefDivCd());
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("agn_agmt_no", getAgnAgmtNo());
		this.hashColumns.put("agn_agmt_seq", getAgnAgmtSeq());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_nm", getCntNm());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("conti_nm", getContiNm());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("agn_agmt_rout_seq", getAgnAgmtRoutSeq());
		this.hashColumns.put("ac_tp_cd", getAcTpCd());
		this.hashColumns.put("sconti_cd", getScontiCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sconti_nm", "scontiNm");
		this.hashFields.put("rout_ref_div_cd", "routRefDivCd");
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_agmt_no", "agnAgmtNo");
		this.hashFields.put("agn_agmt_seq", "agnAgmtSeq");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("conti_nm", "contiNm");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("agn_agmt_rout_seq", "agnAgmtRoutSeq");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("sconti_cd", "scontiCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return scontiNm
	 */
	public String getScontiNm() {
		return this.scontiNm;
	}

	/**
	 * Column Info
	 * @return routRefDivCd
	 */
	public String getRoutRefDivCd() {
		return this.routRefDivCd;
	}

	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
	}

	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
	}

	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return agnAgmtSeq
	 */
	public String getAgnAgmtSeq() {
		return this.agnAgmtSeq;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return cntNm
	 */
	public String getCntNm() {
		return this.cntNm;
	}

	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
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
	 * @return contiNm
	 */
	public String getContiNm() {
		return this.contiNm;
	}

	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}

	/**
	 * Column Info
	 * @return agnAgmtRoutSeq
	 */
	public String getAgnAgmtRoutSeq() {
		return this.agnAgmtRoutSeq;
	}

	/**
	 * Column Info
	 * @return acTpCd
	 */
	public String getAcTpCd() {
		return this.acTpCd;
	}

	/**
	 * Column Info
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
	}


	/**
	 * Column Info
	 * @param scontiNm
	 */
	public void setScontiNm(String scontiNm) {
		this.scontiNm = scontiNm;
	}

	/**
	 * Column Info
	 * @param routRefDivCd
	 */
	public void setRoutRefDivCd(String routRefDivCd) {
		this.routRefDivCd = routRefDivCd;
	}

	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}

	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}

	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param agnAgmtSeq
	 */
	public void setAgnAgmtSeq(String agnAgmtSeq) {
		this.agnAgmtSeq = agnAgmtSeq;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param cntNm
	 */
	public void setCntNm(String cntNm) {
		this.cntNm = cntNm;
	}

	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
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
	 * @param contiNm
	 */
	public void setContiNm(String contiNm) {
		this.contiNm = contiNm;
	}

	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	/**
	 * Column Info
	 * @param agnAgmtRoutSeq
	 */
	public void setAgnAgmtRoutSeq(String agnAgmtRoutSeq) {
		this.agnAgmtRoutSeq = agnAgmtRoutSeq;
	}

	/**
	 * Column Info
	 * @param acTpCd
	 */
	public void setAcTpCd(String acTpCd) {
		this.acTpCd = acTpCd;
	}

	/**
	 * Column Info
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
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
		setScontiNm(JSPUtil.getParameter(request, prefix + "sconti_nm", ""));
		setRoutRefDivCd(JSPUtil.getParameter(request, prefix + "rout_ref_div_cd", ""));
		setContiCd(JSPUtil.getParameter(request, prefix + "conti_cd", ""));
		setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAgnAgmtNo(JSPUtil.getParameter(request, prefix + "agn_agmt_no", ""));
		setAgnAgmtSeq(JSPUtil.getParameter(request, prefix + "agn_agmt_seq", ""));
		setAgnCd(JSPUtil.getParameter(request, prefix + "agn_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntNm(JSPUtil.getParameter(request, prefix + "cnt_nm", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setContiNm(JSPUtil.getParameter(request, prefix + "conti_nm", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setAgnAgmtRoutSeq(JSPUtil.getParameter(request, prefix + "agn_agmt_rout_seq", ""));
		setAcTpCd(JSPUtil.getParameter(request, prefix + "ac_tp_cd", ""));
		setScontiCd(JSPUtil.getParameter(request, prefix + "sconti_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LocationSelectionVO[]
	 */
	public LocationSelectionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return LocationSelectionVO[]
	 */
	public LocationSelectionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LocationSelectionVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] scontiNm = (JSPUtil.getParameter(request, prefix	+ "sconti_nm", length));
			String[] routRefDivCd = (JSPUtil.getParameter(request, prefix	+ "rout_ref_div_cd", length));
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] agnAgmtNo = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_no", length));
			String[] agnAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_seq", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntNm = (JSPUtil.getParameter(request, prefix	+ "cnt_nm", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] contiNm = (JSPUtil.getParameter(request, prefix	+ "conti_nm", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] agnAgmtRoutSeq = (JSPUtil.getParameter(request, prefix	+ "agn_agmt_rout_seq", length));
			String[] acTpCd = (JSPUtil.getParameter(request, prefix	+ "ac_tp_cd", length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd", length));

			for (int i = 0; i < length; i++) {
				model = new LocationSelectionVO();
				if (scontiNm[i] != null)
					model.setScontiNm(scontiNm[i]);
				if (routRefDivCd[i] != null)
					model.setRoutRefDivCd(routRefDivCd[i]);
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (agnAgmtNo[i] != null)
					model.setAgnAgmtNo(agnAgmtNo[i]);
				if (agnAgmtSeq[i] != null)
					model.setAgnAgmtSeq(agnAgmtSeq[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntNm[i] != null)
					model.setCntNm(cntNm[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (contiNm[i] != null)
					model.setContiNm(contiNm[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (agnAgmtRoutSeq[i] != null)
					model.setAgnAgmtRoutSeq(agnAgmtRoutSeq[i]);
				if (acTpCd[i] != null)
					model.setAcTpCd(acTpCd[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getLocationSelectionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LocationSelectionVO[]
	 */
	public LocationSelectionVO[] getLocationSelectionVOs(){
		LocationSelectionVO[] vos = (LocationSelectionVO[])models.toArray(new LocationSelectionVO[models.size()]);
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
		this.scontiNm = this.scontiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routRefDivCd = this.routRefDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtNo = this.agnAgmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtSeq = this.agnAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm = this.cntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contiNm = this.contiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnAgmtRoutSeq = this.agnAgmtRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd = this.acTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
