/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StlConditionVO.java
*@FileTitle : StlConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.17
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.11.17 박희동 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StlConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StlConditionVO> models = new ArrayList<StlConditionVO>();
	
	/* Column Info */
	private String diffOnlyYn = null;
	/* Column Info */
	private String acctYrmonFr = null;
	/* Column Info */
	private String rmkYn = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String joStlItmCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String acctYrmonTo = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String reopt = null;
	/* Column Info */
	private String stlCmbSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public StlConditionVO() {}

	public StlConditionVO(String ibflag, String pagerows, String acctYrmon, String acctYrmonFr, String acctYrmonTo, String joCrrCd, String trdCd, String revDirCd, String rlaneCd, String reDivrCd, String joStlItmCd, String reopt, String stlCmbSeq, String ofcCd, String diffOnlyYn, String rmkYn) {
		this.diffOnlyYn = diffOnlyYn;
		this.acctYrmonFr = acctYrmonFr;
		this.rmkYn = rmkYn;
		this.joCrrCd = joCrrCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.joStlItmCd = joStlItmCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.acctYrmon = acctYrmon;
		this.acctYrmonTo = acctYrmonTo;
		this.reDivrCd = reDivrCd;
		this.reopt = reopt;
		this.stlCmbSeq = stlCmbSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("diff_only_yn", getDiffOnlyYn());
		this.hashColumns.put("acct_yrmon_fr", getAcctYrmonFr());
		this.hashColumns.put("rmk_yn", getRmkYn());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("acct_yrmon_to", getAcctYrmonTo());
		this.hashColumns.put("re_divr_cd", getReDivrCd());
		this.hashColumns.put("reopt", getReopt());
		this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("diff_only_yn", "diffOnlyYn");
		this.hashFields.put("acct_yrmon_fr", "acctYrmonFr");
		this.hashFields.put("rmk_yn", "rmkYn");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("acct_yrmon_to", "acctYrmonTo");
		this.hashFields.put("re_divr_cd", "reDivrCd");
		this.hashFields.put("reopt", "reopt");
		this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return diffOnlyYn
	 */
	public String getDiffOnlyYn() {
		return this.diffOnlyYn;
	}
	
	/**
	 * Column Info
	 * @return acctYrmonFr
	 */
	public String getAcctYrmonFr() {
		return this.acctYrmonFr;
	}
	
	/**
	 * Column Info
	 * @return rmkYn
	 */
	public String getRmkYn() {
		return this.rmkYn;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return joStlItmCd
	 */
	public String getJoStlItmCd() {
		return this.joStlItmCd;
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
	 * @return acctYrmonTo
	 */
	public String getAcctYrmonTo() {
		return this.acctYrmonTo;
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
	 * @return reopt
	 */
	public String getReopt() {
		return this.reopt;
	}
	
	/**
	 * Column Info
	 * @return stlCmbSeq
	 */
	public String getStlCmbSeq() {
		return this.stlCmbSeq;
	}
	

	/**
	 * Column Info
	 * @param diffOnlyYn
	 */
	public void setDiffOnlyYn(String diffOnlyYn) {
		this.diffOnlyYn = diffOnlyYn;
	}
	
	/**
	 * Column Info
	 * @param acctYrmonFr
	 */
	public void setAcctYrmonFr(String acctYrmonFr) {
		this.acctYrmonFr = acctYrmonFr;
	}
	
	/**
	 * Column Info
	 * @param rmkYn
	 */
	public void setRmkYn(String rmkYn) {
		this.rmkYn = rmkYn;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param joStlItmCd
	 */
	public void setJoStlItmCd(String joStlItmCd) {
		this.joStlItmCd = joStlItmCd;
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
	 * @param acctYrmonTo
	 */
	public void setAcctYrmonTo(String acctYrmonTo) {
		this.acctYrmonTo = acctYrmonTo;
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
	 * @param reopt
	 */
	public void setReopt(String reopt) {
		this.reopt = reopt;
	}
	
	/**
	 * Column Info
	 * @param stlCmbSeq
	 */
	public void setStlCmbSeq(String stlCmbSeq) {
		this.stlCmbSeq = stlCmbSeq;
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
		setDiffOnlyYn(JSPUtil.getParameter(request, prefix + "diff_only_yn", ""));
		setAcctYrmonFr(JSPUtil.getParameter(request, prefix + "acct_yrmon_fr", ""));
		setRmkYn(JSPUtil.getParameter(request, prefix + "rmk_yn", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setJoStlItmCd(JSPUtil.getParameter(request, prefix + "jo_stl_itm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));
		setAcctYrmonTo(JSPUtil.getParameter(request, prefix + "acct_yrmon_to", ""));
		setReDivrCd(JSPUtil.getParameter(request, prefix + "re_divr_cd", ""));
		setReopt(JSPUtil.getParameter(request, prefix + "reopt", ""));
		setStlCmbSeq(JSPUtil.getParameter(request, prefix + "stl_cmb_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StlConditionVO[]
	 */
	public StlConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StlConditionVO[]
	 */
	public StlConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StlConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] diffOnlyYn = (JSPUtil.getParameter(request, prefix	+ "diff_only_yn", length));
			String[] acctYrmonFr = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon_fr", length));
			String[] rmkYn = (JSPUtil.getParameter(request, prefix	+ "rmk_yn", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] joStlItmCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] acctYrmonTo = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon_to", length));
			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));
			String[] reopt = (JSPUtil.getParameter(request, prefix	+ "reopt", length));
			String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix	+ "stl_cmb_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new StlConditionVO();
				if (diffOnlyYn[i] != null)
					model.setDiffOnlyYn(diffOnlyYn[i]);
				if (acctYrmonFr[i] != null)
					model.setAcctYrmonFr(acctYrmonFr[i]);
				if (rmkYn[i] != null)
					model.setRmkYn(rmkYn[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (joStlItmCd[i] != null)
					model.setJoStlItmCd(joStlItmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (acctYrmonTo[i] != null)
					model.setAcctYrmonTo(acctYrmonTo[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (reopt[i] != null)
					model.setReopt(reopt[i]);
				if (stlCmbSeq[i] != null)
					model.setStlCmbSeq(stlCmbSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStlConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StlConditionVO[]
	 */
	public StlConditionVO[] getStlConditionVOs(){
		StlConditionVO[] vos = (StlConditionVO[])models.toArray(new StlConditionVO[models.size()]);
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
		this.diffOnlyYn = this.diffOnlyYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmonFr = this.acctYrmonFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmkYn = this.rmkYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCd = this.joStlItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmonTo = this.acctYrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reopt = this.reopt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCmbSeq = this.stlCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
