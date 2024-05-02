/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SubsPerfVO.java
*@FileTitle : SubsPerfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.03  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SubsPerfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SubsPerfVO> models = new ArrayList<SubsPerfVO>();
	
	/* Column Info */
	private String rsltYrmon = null;
	/* Column Info */
	private String genExpnAmt = null;
	/* Column Info */
	private String abbrNm = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String slpPerfAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String genExpnOvrRtoRsn = null;
	/* Column Info */
	private String subsSlpFlag = null;
	/* Column Info */
	private String perfAmt = null;
	/* Column Info */
	private String ratio = null;
	/* Column Info */
	private String slpPerfAmt01 = null;
	/* Column Info */
	private String rqstUtVal = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SubsPerfVO() {}

	public SubsPerfVO(String ibflag, String pagerows, String rsltYrmon, String genExpnAmt, String loclCurrCd, String creDt, String genExpnCd, String slpPerfAmt, String ofcCd, String genExpnOvrRtoRsn, String perfAmt, String ratio, String rqstUtVal, String abbrNm, String creUsrId, String updUsrId, String slpPerfAmt01, String subsSlpFlag) {
		this.rsltYrmon = rsltYrmon;
		this.genExpnAmt = genExpnAmt;
		this.abbrNm = abbrNm;
		this.loclCurrCd = loclCurrCd;
		this.creDt = creDt;
		this.genExpnCd = genExpnCd;
		this.slpPerfAmt = slpPerfAmt;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.genExpnOvrRtoRsn = genExpnOvrRtoRsn;
		this.subsSlpFlag = subsSlpFlag;
		this.perfAmt = perfAmt;
		this.ratio = ratio;
		this.slpPerfAmt01 = slpPerfAmt01;
		this.rqstUtVal = rqstUtVal;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rslt_yrmon", getRsltYrmon());
		this.hashColumns.put("gen_expn_amt", getGenExpnAmt());
		this.hashColumns.put("abbr_nm", getAbbrNm());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("slp_perf_amt", getSlpPerfAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gen_expn_ovr_rto_rsn", getGenExpnOvrRtoRsn());
		this.hashColumns.put("subs_slp_flag", getSubsSlpFlag());
		this.hashColumns.put("perf_amt", getPerfAmt());
		this.hashColumns.put("ratio", getRatio());
		this.hashColumns.put("slp_perf_amt01", getSlpPerfAmt01());
		this.hashColumns.put("rqst_ut_val", getRqstUtVal());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rslt_yrmon", "rsltYrmon");
		this.hashFields.put("gen_expn_amt", "genExpnAmt");
		this.hashFields.put("abbr_nm", "abbrNm");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("slp_perf_amt", "slpPerfAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gen_expn_ovr_rto_rsn", "genExpnOvrRtoRsn");
		this.hashFields.put("subs_slp_flag", "subsSlpFlag");
		this.hashFields.put("perf_amt", "perfAmt");
		this.hashFields.put("ratio", "ratio");
		this.hashFields.put("slp_perf_amt01", "slpPerfAmt01");
		this.hashFields.put("rqst_ut_val", "rqstUtVal");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rsltYrmon
	 */
	public String getRsltYrmon() {
		return this.rsltYrmon;
	}
	
	/**
	 * Column Info
	 * @return genExpnAmt
	 */
	public String getGenExpnAmt() {
		return this.genExpnAmt;
	}
	
	/**
	 * Column Info
	 * @return abbrNm
	 */
	public String getAbbrNm() {
		return this.abbrNm;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	
	/**
	 * Column Info
	 * @return slpPerfAmt
	 */
	public String getSlpPerfAmt() {
		return this.slpPerfAmt;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return genExpnOvrRtoRsn
	 */
	public String getGenExpnOvrRtoRsn() {
		return this.genExpnOvrRtoRsn;
	}
	
	/**
	 * Column Info
	 * @return subsSlpFlag
	 */
	public String getSubsSlpFlag() {
		return this.subsSlpFlag;
	}
	
	/**
	 * Column Info
	 * @return perfAmt
	 */
	public String getPerfAmt() {
		return this.perfAmt;
	}
	
	/**
	 * Column Info
	 * @return ratio
	 */
	public String getRatio() {
		return this.ratio;
	}
	
	/**
	 * Column Info
	 * @return slpPerfAmt01
	 */
	public String getSlpPerfAmt01() {
		return this.slpPerfAmt01;
	}
	
	/**
	 * Column Info
	 * @return rqstUtVal
	 */
	public String getRqstUtVal() {
		return this.rqstUtVal;
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
	 * @param rsltYrmon
	 */
	public void setRsltYrmon(String rsltYrmon) {
		this.rsltYrmon = rsltYrmon;
	}
	
	/**
	 * Column Info
	 * @param genExpnAmt
	 */
	public void setGenExpnAmt(String genExpnAmt) {
		this.genExpnAmt = genExpnAmt;
	}
	
	/**
	 * Column Info
	 * @param abbrNm
	 */
	public void setAbbrNm(String abbrNm) {
		this.abbrNm = abbrNm;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}
	
	/**
	 * Column Info
	 * @param slpPerfAmt
	 */
	public void setSlpPerfAmt(String slpPerfAmt) {
		this.slpPerfAmt = slpPerfAmt;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param genExpnOvrRtoRsn
	 */
	public void setGenExpnOvrRtoRsn(String genExpnOvrRtoRsn) {
		this.genExpnOvrRtoRsn = genExpnOvrRtoRsn;
	}
	
	/**
	 * Column Info
	 * @param subsSlpFlag
	 */
	public void setSubsSlpFlag(String subsSlpFlag) {
		this.subsSlpFlag = subsSlpFlag;
	}
	
	/**
	 * Column Info
	 * @param perfAmt
	 */
	public void setPerfAmt(String perfAmt) {
		this.perfAmt = perfAmt;
	}
	
	/**
	 * Column Info
	 * @param ratio
	 */
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}
	
	/**
	 * Column Info
	 * @param slpPerfAmt01
	 */
	public void setSlpPerfAmt01(String slpPerfAmt01) {
		this.slpPerfAmt01 = slpPerfAmt01;
	}
	
	/**
	 * Column Info
	 * @param rqstUtVal
	 */
	public void setRqstUtVal(String rqstUtVal) {
		this.rqstUtVal = rqstUtVal;
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
		setRsltYrmon(JSPUtil.getParameter(request, prefix + "rslt_yrmon", ""));
		setGenExpnAmt(JSPUtil.getParameter(request, prefix + "gen_expn_amt", ""));
		setAbbrNm(JSPUtil.getParameter(request, prefix + "abbr_nm", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setGenExpnCd(JSPUtil.getParameter(request, prefix + "gen_expn_cd", ""));
		setSlpPerfAmt(JSPUtil.getParameter(request, prefix + "slp_perf_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGenExpnOvrRtoRsn(JSPUtil.getParameter(request, prefix + "gen_expn_ovr_rto_rsn", ""));
		setSubsSlpFlag(JSPUtil.getParameter(request, prefix + "subs_slp_flag", ""));
		setPerfAmt(JSPUtil.getParameter(request, prefix + "perf_amt", ""));
		setRatio(JSPUtil.getParameter(request, prefix + "ratio", ""));
		setSlpPerfAmt01(JSPUtil.getParameter(request, prefix + "slp_perf_amt01", ""));
		setRqstUtVal(JSPUtil.getParameter(request, prefix + "rqst_ut_val", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SubsPerfVO[]
	 */
	public SubsPerfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SubsPerfVO[]
	 */
	public SubsPerfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SubsPerfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rsltYrmon = (JSPUtil.getParameter(request, prefix	+ "rslt_yrmon", length));
			String[] genExpnAmt = (JSPUtil.getParameter(request, prefix	+ "gen_expn_amt", length));
			String[] abbrNm = (JSPUtil.getParameter(request, prefix	+ "abbr_nm", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] slpPerfAmt = (JSPUtil.getParameter(request, prefix	+ "slp_perf_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] genExpnOvrRtoRsn = (JSPUtil.getParameter(request, prefix	+ "gen_expn_ovr_rto_rsn", length));
			String[] subsSlpFlag = (JSPUtil.getParameter(request, prefix	+ "subs_slp_flag", length));
			String[] perfAmt = (JSPUtil.getParameter(request, prefix	+ "perf_amt", length));
			String[] ratio = (JSPUtil.getParameter(request, prefix	+ "ratio", length));
			String[] slpPerfAmt01 = (JSPUtil.getParameter(request, prefix	+ "slp_perf_amt01", length));
			String[] rqstUtVal = (JSPUtil.getParameter(request, prefix	+ "rqst_ut_val", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SubsPerfVO();
				if (rsltYrmon[i] != null)
					model.setRsltYrmon(rsltYrmon[i]);
				if (genExpnAmt[i] != null)
					model.setGenExpnAmt(genExpnAmt[i]);
				if (abbrNm[i] != null)
					model.setAbbrNm(abbrNm[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (slpPerfAmt[i] != null)
					model.setSlpPerfAmt(slpPerfAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (genExpnOvrRtoRsn[i] != null)
					model.setGenExpnOvrRtoRsn(genExpnOvrRtoRsn[i]);
				if (subsSlpFlag[i] != null)
					model.setSubsSlpFlag(subsSlpFlag[i]);
				if (perfAmt[i] != null)
					model.setPerfAmt(perfAmt[i]);
				if (ratio[i] != null)
					model.setRatio(ratio[i]);
				if (slpPerfAmt01[i] != null)
					model.setSlpPerfAmt01(slpPerfAmt01[i]);
				if (rqstUtVal[i] != null)
					model.setRqstUtVal(rqstUtVal[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSubsPerfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SubsPerfVO[]
	 */
	public SubsPerfVO[] getSubsPerfVOs(){
		SubsPerfVO[] vos = (SubsPerfVO[])models.toArray(new SubsPerfVO[models.size()]);
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
		this.rsltYrmon = this.rsltYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnAmt = this.genExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.abbrNm = this.abbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpPerfAmt = this.slpPerfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnOvrRtoRsn = this.genExpnOvrRtoRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subsSlpFlag = this.subsSlpFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perfAmt = this.perfAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratio = this.ratio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpPerfAmt01 = this.slpPerfAmt01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUtVal = this.rqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
