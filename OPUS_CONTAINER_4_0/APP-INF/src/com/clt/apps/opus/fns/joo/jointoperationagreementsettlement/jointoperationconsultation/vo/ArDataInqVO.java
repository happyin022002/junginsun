/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ArDataInqVO.java
*@FileTitle : ArDataInqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.01.15 장강철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo;

import java.lang.reflect.Field;
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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ArDataInqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ArDataInqVO> models = new ArrayList<ArDataInqVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cbOfcCd = null;
	/* Column Info */
	private String joBilNo = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String tranNo = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String sumYn = null;
	/* Column Info */
	private String yrmonTo = null;
	/* Column Info */
	private String joStlItmCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String csrLoclAmt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String yrmonType = null;
	/* Column Info */
	private String joCrrCdNm = null;
	/* Column Info */
	private String yrmonFr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ArDataInqVO() {}

	public ArDataInqVO(String ibflag, String pagerows, String acctYrmon, String joCrrCd, String rlaneCd, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String joCrrCdNm, String csrLoclAmt, String yrmonType, String yrmonFr, String yrmonTo, String sumYn, String reDivrCd, String loclCurrCd, String joStlItmCd, String joBilNo, String tranNo, String revYrmon, String vvd, String cbOfcCd) {
		this.vslCd = vslCd;
		this.cbOfcCd = cbOfcCd;
		this.joBilNo = joBilNo;
		this.revYrmon = revYrmon;
		this.loclCurrCd = loclCurrCd;
		this.tranNo = tranNo;
		this.joCrrCd = joCrrCd;
		this.skdVoyNo = skdVoyNo;
		this.rlaneCd = rlaneCd;
		this.sumYn = sumYn;
		this.yrmonTo = yrmonTo;
		this.joStlItmCd = joStlItmCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.csrLoclAmt = csrLoclAmt;
		this.vvd = vvd;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.acctYrmon = acctYrmon;
		this.reDivrCd = reDivrCd;
		this.yrmonType = yrmonType;
		this.joCrrCdNm = joCrrCdNm;
		this.yrmonFr = yrmonFr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cb_ofc_cd", getCbOfcCd());
		this.hashColumns.put("jo_bil_no", getJoBilNo());
		this.hashColumns.put("rev_yrmon", getRevYrmon());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("tran_no", getTranNo());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("sum_yn", getSumYn());
		this.hashColumns.put("yrmon_to", getYrmonTo());
		this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("csr_locl_amt", getCsrLoclAmt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("yrmon_type", getYrmonType());
		this.hashColumns.put("jo_crr_cd_nm", getJoCrrCdNm());
		this.hashColumns.put("yrmon_fr", getYrmonFr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cb_ofc_cd", "cbOfcCd");
		this.hashFields.put("jo_bil_no", "joBilNo");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("tran_no", "tranNo");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("sum_yn", "sumYn");
		this.hashFields.put("yrmon_to", "yrmonTo");
		this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("csr_locl_amt", "csrLoclAmt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("yrmon_type", "yrmonType");
		this.hashFields.put("jo_crr_cd_nm", "joCrrCdNm");
		this.hashFields.put("yrmon_fr", "yrmonFr");
		return this.hashFields;
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
	 * @return cbOfcCd
	 */
	public String getCbOfcCd() {
		return this.cbOfcCd;
	}
	
	/**
	 * Column Info
	 * @return joBilNo
	 */
	public String getJoBilNo() {
		return this.joBilNo;
	}
	
	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return tranNo
	 */
	public String getTranNo() {
		return this.tranNo;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return sumYn
	 */
	public String getSumYn() {
		return this.sumYn;
	}
	
	/**
	 * Column Info
	 * @return yrmonTo
	 */
	public String getYrmonTo() {
		return this.yrmonTo;
	}
	
	/**
	 * Column Info
	 * @return joStlItmCd
	 */
	public String getJoStlItmCd() {
		return this.joStlItmCd;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return csrLoclAmt
	 */
	public String getCsrLoclAmt() {
		return this.csrLoclAmt;
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
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
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
	 * @return acctYrmon
	 */
	public String getAcctYrmon() {
		return this.acctYrmon;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return yrmonType
	 */
	public String getYrmonType() {
		return this.yrmonType;
	}
	
	/**
	 * Column Info
	 * @return joCrrCdNm
	 */
	public String getJoCrrCdNm() {
		return this.joCrrCdNm;
	}
	
	/**
	 * Column Info
	 * @return yrmonFr
	 */
	public String getYrmonFr() {
		return this.yrmonFr;
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
	 * @param cbOfcCd
	 */
	public void setCbOfcCd(String cbOfcCd) {
		this.cbOfcCd = cbOfcCd;
	}
	
	/**
	 * Column Info
	 * @param joBilNo
	 */
	public void setJoBilNo(String joBilNo) {
		this.joBilNo = joBilNo;
	}
	
	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param tranNo
	 */
	public void setTranNo(String tranNo) {
		this.tranNo = tranNo;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param sumYn
	 */
	public void setSumYn(String sumYn) {
		this.sumYn = sumYn;
	}
	
	/**
	 * Column Info
	 * @param yrmonTo
	 */
	public void setYrmonTo(String yrmonTo) {
		this.yrmonTo = yrmonTo;
	}
	
	/**
	 * Column Info
	 * @param joStlItmCd
	 */
	public void setJoStlItmCd(String joStlItmCd) {
		this.joStlItmCd = joStlItmCd;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param csrLoclAmt
	 */
	public void setCsrLoclAmt(String csrLoclAmt) {
		this.csrLoclAmt = csrLoclAmt;
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
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
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
	 * @param acctYrmon
	 */
	public void setAcctYrmon(String acctYrmon) {
		this.acctYrmon = acctYrmon;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param yrmonType
	 */
	public void setYrmonType(String yrmonType) {
		this.yrmonType = yrmonType;
	}
	
	/**
	 * Column Info
	 * @param joCrrCdNm
	 */
	public void setJoCrrCdNm(String joCrrCdNm) {
		this.joCrrCdNm = joCrrCdNm;
	}
	
	/**
	 * Column Info
	 * @param yrmonFr
	 */
	public void setYrmonFr(String yrmonFr) {
		this.yrmonFr = yrmonFr;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCbOfcCd(JSPUtil.getParameter(request, "cb_ofc_cd", ""));
		setJoBilNo(JSPUtil.getParameter(request, "jo_bil_no", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setTranNo(JSPUtil.getParameter(request, "tran_no", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setSumYn(JSPUtil.getParameter(request, "sum_yn", ""));
		setYrmonTo(JSPUtil.getParameter(request, "yrmon_to", ""));
		setJoStlItmCd(JSPUtil.getParameter(request, "jo_stl_itm_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCsrLoclAmt(JSPUtil.getParameter(request, "csr_locl_amt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAcctYrmon(JSPUtil.getParameter(request, "acct_yrmon", ""));
		setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
		setYrmonType(JSPUtil.getParameter(request, "yrmon_type", ""));
		setJoCrrCdNm(JSPUtil.getParameter(request, "jo_crr_cd_nm", ""));
		setYrmonFr(JSPUtil.getParameter(request, "yrmon_fr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ArDataInqVO[]
	 */
	public ArDataInqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ArDataInqVO[]
	 */
	public ArDataInqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ArDataInqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cbOfcCd = (JSPUtil.getParameter(request, prefix	+ "cb_ofc_cd", length));
			String[] joBilNo = (JSPUtil.getParameter(request, prefix	+ "jo_bil_no", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] tranNo = (JSPUtil.getParameter(request, prefix	+ "tran_no", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] sumYn = (JSPUtil.getParameter(request, prefix	+ "sum_yn", length));
			String[] yrmonTo = (JSPUtil.getParameter(request, prefix	+ "yrmon_to", length));
			String[] joStlItmCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] csrLoclAmt = (JSPUtil.getParameter(request, prefix	+ "csr_locl_amt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] yrmonType = (JSPUtil.getParameter(request, prefix	+ "yrmon_type", length));
			String[] joCrrCdNm = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd_nm", length));
			String[] yrmonFr = (JSPUtil.getParameter(request, prefix	+ "yrmon_fr", length));
			
			for (int i = 0; i < length; i++) {
				model = new ArDataInqVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cbOfcCd[i] != null)
					model.setCbOfcCd(cbOfcCd[i]);
				if (joBilNo[i] != null)
					model.setJoBilNo(joBilNo[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (tranNo[i] != null)
					model.setTranNo(tranNo[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (sumYn[i] != null)
					model.setSumYn(sumYn[i]);
				if (yrmonTo[i] != null)
					model.setYrmonTo(yrmonTo[i]);
				if (joStlItmCd[i] != null)
					model.setJoStlItmCd(joStlItmCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (csrLoclAmt[i] != null)
					model.setCsrLoclAmt(csrLoclAmt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (yrmonType[i] != null)
					model.setYrmonType(yrmonType[i]);
				if (joCrrCdNm[i] != null)
					model.setJoCrrCdNm(joCrrCdNm[i]);
				if (yrmonFr[i] != null)
					model.setYrmonFr(yrmonFr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getArDataInqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ArDataInqVO[]
	 */
	public ArDataInqVO[] getArDataInqVOs(){
		ArDataInqVO[] vos = (ArDataInqVO[])models.toArray(new ArDataInqVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbOfcCd = this.cbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joBilNo = this.joBilNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tranNo = this.tranNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumYn = this.sumYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmonTo = this.yrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCd = this.joStlItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrLoclAmt = this.csrLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmonType = this.yrmonType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCdNm = this.joCrrCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrmonFr = this.yrmonFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
