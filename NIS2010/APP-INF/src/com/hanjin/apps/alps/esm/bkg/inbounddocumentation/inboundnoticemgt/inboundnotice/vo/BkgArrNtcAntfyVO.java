/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgArrNtcAntfyVO.java
*@FileTitle : BkgArrNtcAntfyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.11
*@LastModifier :
*@LastVersion : 1.0
* 2016.02.11
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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

public class BkgArrNtcAntfyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BkgArrNtcAntfyVO> models = new ArrayList<BkgArrNtcAntfyVO>();

	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String a2CntcEml = null;
	/* Column Info */
	private String custCntcTpCd = null;
	/* Column Info */
	private String antfyCustCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String cntcEml = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String a2FaxNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String a1CntcEml = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String a1FaxNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public BkgArrNtcAntfyVO() {}

	public BkgArrNtcAntfyVO(String ibflag, String pagerows, String scNo, String antfyCustCd, String podCd, String a1CntcEml, String a1FaxNo, String a2CntcEml, String a2FaxNo, String creUsrId, String creDt, String updUsrId, String updDt, String custCntcTpCd, String faxNo, String cntcEml) {
		this.updDt = updDt;
		this.a2CntcEml = a2CntcEml;
		this.custCntcTpCd = custCntcTpCd;
		this.antfyCustCd = antfyCustCd;
		this.creDt = creDt;
		this.cntcEml = cntcEml;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.a2FaxNo = a2FaxNo;
		this.scNo = scNo;
		this.a1CntcEml = a1CntcEml;
		this.faxNo = faxNo;
		this.a1FaxNo = a1FaxNo;
		this.updUsrId = updUsrId;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("a2_cntc_eml", getA2CntcEml());
		this.hashColumns.put("cust_cntc_tp_cd", getCustCntcTpCd());
		this.hashColumns.put("antfy_cust_cd", getAntfyCustCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cntc_eml", getCntcEml());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("a2_fax_no", getA2FaxNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("a1_cntc_eml", getA1CntcEml());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("a1_fax_no", getA1FaxNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("a2_cntc_eml", "a2CntcEml");
		this.hashFields.put("cust_cntc_tp_cd", "custCntcTpCd");
		this.hashFields.put("antfy_cust_cd", "antfyCustCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cntc_eml", "cntcEml");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("a2_fax_no", "a2FaxNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("a1_cntc_eml", "a1CntcEml");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("a1_fax_no", "a1FaxNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return a2CntcEml
	 */
	public String getA2CntcEml() {
		return this.a2CntcEml;
	}

	/**
	 * Column Info
	 * @return custCntcTpCd
	 */
	public String getCustCntcTpCd() {
		return this.custCntcTpCd;
	}

	/**
	 * Column Info
	 * @return antfyCustCd
	 */
	public String getAntfyCustCd() {
		return this.antfyCustCd;
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
	 * @return cntcEml
	 */
	public String getCntcEml() {
		return this.cntcEml;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}

	/**
	 * Column Info
	 * @return a2FaxNo
	 */
	public String getA2FaxNo() {
		return this.a2FaxNo;
	}

	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}

	/**
	 * Column Info
	 * @return a1CntcEml
	 */
	public String getA1CntcEml() {
		return this.a1CntcEml;
	}

	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}

	/**
	 * Column Info
	 * @return a1FaxNo
	 */
	public String getA1FaxNo() {
		return this.a1FaxNo;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * Column Info
	 * @param a2CntcEml
	 */
	public void setA2CntcEml(String a2CntcEml) {
		this.a2CntcEml = a2CntcEml;
	}

	/**
	 * Column Info
	 * @param custCntcTpCd
	 */
	public void setCustCntcTpCd(String custCntcTpCd) {
		this.custCntcTpCd = custCntcTpCd;
	}

	/**
	 * Column Info
	 * @param antfyCustCd
	 */
	public void setAntfyCustCd(String antfyCustCd) {
		this.antfyCustCd = antfyCustCd;
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
	 * @param cntcEml
	 */
	public void setCntcEml(String cntcEml) {
		this.cntcEml = cntcEml;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * Column Info
	 * @param a2FaxNo
	 */
	public void setA2FaxNo(String a2FaxNo) {
		this.a2FaxNo = a2FaxNo;
	}

	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	/**
	 * Column Info
	 * @param a1CntcEml
	 */
	public void setA1CntcEml(String a1CntcEml) {
		this.a1CntcEml = a1CntcEml;
	}

	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	/**
	 * Column Info
	 * @param a1FaxNo
	 */
	public void setA1FaxNo(String a1FaxNo) {
		this.a1FaxNo = a1FaxNo;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setA2CntcEml(JSPUtil.getParameter(request, prefix + "a2_cntc_eml", ""));
		setCustCntcTpCd(JSPUtil.getParameter(request, prefix + "cust_cntc_tp_cd", ""));
		setAntfyCustCd(JSPUtil.getParameter(request, prefix + "antfy_cust_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCntcEml(JSPUtil.getParameter(request, prefix + "cntc_eml", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setA2FaxNo(JSPUtil.getParameter(request, prefix + "a2_fax_no", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setA1CntcEml(JSPUtil.getParameter(request, prefix + "a1_cntc_eml", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setA1FaxNo(JSPUtil.getParameter(request, prefix + "a1_fax_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgArrNtcAntfyVO[]
	 */
	public BkgArrNtcAntfyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgArrNtcAntfyVO[]
	 */
	public BkgArrNtcAntfyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgArrNtcAntfyVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] a2CntcEml = (JSPUtil.getParameter(request, prefix	+ "a2_cntc_eml", length));
			String[] custCntcTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_tp_cd", length));
			String[] antfyCustCd = (JSPUtil.getParameter(request, prefix	+ "antfy_cust_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] cntcEml = (JSPUtil.getParameter(request, prefix	+ "cntc_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] a2FaxNo = (JSPUtil.getParameter(request, prefix	+ "a2_fax_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] a1CntcEml = (JSPUtil.getParameter(request, prefix	+ "a1_cntc_eml", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] a1FaxNo = (JSPUtil.getParameter(request, prefix	+ "a1_fax_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));

			for (int i = 0; i < length; i++) {
				model = new BkgArrNtcAntfyVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (a2CntcEml[i] != null)
					model.setA2CntcEml(a2CntcEml[i]);
				if (custCntcTpCd[i] != null)
					model.setCustCntcTpCd(custCntcTpCd[i]);
				if (antfyCustCd[i] != null)
					model.setAntfyCustCd(antfyCustCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (cntcEml[i] != null)
					model.setCntcEml(cntcEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (a2FaxNo[i] != null)
					model.setA2FaxNo(a2FaxNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (a1CntcEml[i] != null)
					model.setA1CntcEml(a1CntcEml[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (a1FaxNo[i] != null)
					model.setA1FaxNo(a1FaxNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgArrNtcAntfyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgArrNtcAntfyVO[]
	 */
	public BkgArrNtcAntfyVO[] getBkgArrNtcAntfyVOs(){
		BkgArrNtcAntfyVO[] vos = (BkgArrNtcAntfyVO[])models.toArray(new BkgArrNtcAntfyVO[models.size()]);
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
		this.a2CntcEml = this.a2CntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcTpCd = this.custCntcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.antfyCustCd = this.antfyCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcEml = this.cntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2FaxNo = this.a2FaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1CntcEml = this.a1CntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a1FaxNo = this.a1FaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
