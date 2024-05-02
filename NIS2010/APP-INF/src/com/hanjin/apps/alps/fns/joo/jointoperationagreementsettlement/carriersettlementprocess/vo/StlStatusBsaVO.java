/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StlStatusBsaVO.java
*@FileTitle : StlStatusBsaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.03.25 박희동 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StlStatusBsaVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StlStatusBsaVO> models = new ArrayList<StlStatusBsaVO>();
	
	/* Column Info */
	private String bsaEAmt = null;
	/* Column Info */
	private String jooEAmt = null;
	/* Column Info */
	private String diffRYn = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String acctYrmon = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String jooRAmt = null;
	/* Column Info */
	private String diffEYn = null;
	/* Column Info */
	private String bsaRAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public StlStatusBsaVO() {}

	public StlStatusBsaVO(String ibflag, String pagerows, String acctYrmon, String costYrmon, String joCrrCd, String vvd, String trdCd, String rlaneCd, String ofcCd, String jooRAmt, String jooEAmt, String bsaRAmt, String bsaEAmt, String diffRYn, String diffEYn) {
		this.bsaEAmt = bsaEAmt;
		this.jooEAmt = jooEAmt;
		this.diffRYn = diffRYn;
		this.joCrrCd = joCrrCd;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.acctYrmon = acctYrmon;
		this.costYrmon = costYrmon;
		this.jooRAmt = jooRAmt;
		this.diffEYn = diffEYn;
		this.bsaRAmt = bsaRAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bsa_e_amt", getBsaEAmt());
		this.hashColumns.put("joo_e_amt", getJooEAmt());
		this.hashColumns.put("diff_r_yn", getDiffRYn());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("acct_yrmon", getAcctYrmon());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("joo_r_amt", getJooRAmt());
		this.hashColumns.put("diff_e_yn", getDiffEYn());
		this.hashColumns.put("bsa_r_amt", getBsaRAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bsa_e_amt", "bsaEAmt");
		this.hashFields.put("joo_e_amt", "jooEAmt");
		this.hashFields.put("diff_r_yn", "diffRYn");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_yrmon", "acctYrmon");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("joo_r_amt", "jooRAmt");
		this.hashFields.put("diff_e_yn", "diffEYn");
		this.hashFields.put("bsa_r_amt", "bsaRAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bsaEAmt
	 */
	public String getBsaEAmt() {
		return this.bsaEAmt;
	}
	
	/**
	 * Column Info
	 * @return jooEAmt
	 */
	public String getJooEAmt() {
		return this.jooEAmt;
	}
	
	/**
	 * Column Info
	 * @return diffRYn
	 */
	public String getDiffRYn() {
		return this.diffRYn;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return jooRAmt
	 */
	public String getJooRAmt() {
		return this.jooRAmt;
	}
	
	/**
	 * Column Info
	 * @return diffEYn
	 */
	public String getDiffEYn() {
		return this.diffEYn;
	}
	
	/**
	 * Column Info
	 * @return bsaRAmt
	 */
	public String getBsaRAmt() {
		return this.bsaRAmt;
	}
	

	/**
	 * Column Info
	 * @param bsaEAmt
	 */
	public void setBsaEAmt(String bsaEAmt) {
		this.bsaEAmt = bsaEAmt;
	}
	
	/**
	 * Column Info
	 * @param jooEAmt
	 */
	public void setJooEAmt(String jooEAmt) {
		this.jooEAmt = jooEAmt;
	}
	
	/**
	 * Column Info
	 * @param diffRYn
	 */
	public void setDiffRYn(String diffRYn) {
		this.diffRYn = diffRYn;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param jooRAmt
	 */
	public void setJooRAmt(String jooRAmt) {
		this.jooRAmt = jooRAmt;
	}
	
	/**
	 * Column Info
	 * @param diffEYn
	 */
	public void setDiffEYn(String diffEYn) {
		this.diffEYn = diffEYn;
	}
	
	/**
	 * Column Info
	 * @param bsaRAmt
	 */
	public void setBsaRAmt(String bsaRAmt) {
		this.bsaRAmt = bsaRAmt;
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
		setBsaEAmt(JSPUtil.getParameter(request, prefix + "bsa_e_amt", ""));
		setJooEAmt(JSPUtil.getParameter(request, prefix + "joo_e_amt", ""));
		setDiffRYn(JSPUtil.getParameter(request, prefix + "diff_r_yn", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAcctYrmon(JSPUtil.getParameter(request, prefix + "acct_yrmon", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setJooRAmt(JSPUtil.getParameter(request, prefix + "joo_r_amt", ""));
		setDiffEYn(JSPUtil.getParameter(request, prefix + "diff_e_yn", ""));
		setBsaRAmt(JSPUtil.getParameter(request, prefix + "bsa_r_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StlStatusBsaVO[]
	 */
	public StlStatusBsaVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StlStatusBsaVO[]
	 */
	public StlStatusBsaVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StlStatusBsaVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bsaEAmt = (JSPUtil.getParameter(request, prefix	+ "bsa_e_amt", length));
			String[] jooEAmt = (JSPUtil.getParameter(request, prefix	+ "joo_e_amt", length));
			String[] diffRYn = (JSPUtil.getParameter(request, prefix	+ "diff_r_yn", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] acctYrmon = (JSPUtil.getParameter(request, prefix	+ "acct_yrmon", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] jooRAmt = (JSPUtil.getParameter(request, prefix	+ "joo_r_amt", length));
			String[] diffEYn = (JSPUtil.getParameter(request, prefix	+ "diff_e_yn", length));
			String[] bsaRAmt = (JSPUtil.getParameter(request, prefix	+ "bsa_r_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new StlStatusBsaVO();
				if (bsaEAmt[i] != null)
					model.setBsaEAmt(bsaEAmt[i]);
				if (jooEAmt[i] != null)
					model.setJooEAmt(jooEAmt[i]);
				if (diffRYn[i] != null)
					model.setDiffRYn(diffRYn[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (acctYrmon[i] != null)
					model.setAcctYrmon(acctYrmon[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (jooRAmt[i] != null)
					model.setJooRAmt(jooRAmt[i]);
				if (diffEYn[i] != null)
					model.setDiffEYn(diffEYn[i]);
				if (bsaRAmt[i] != null)
					model.setBsaRAmt(bsaRAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStlStatusBsaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StlStatusBsaVO[]
	 */
	public StlStatusBsaVO[] getStlStatusBsaVOs(){
		StlStatusBsaVO[] vos = (StlStatusBsaVO[])models.toArray(new StlStatusBsaVO[models.size()]);
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
		this.bsaEAmt = this.bsaEAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jooEAmt = this.jooEAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRYn = this.diffRYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctYrmon = this.acctYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jooRAmt = this.jooRAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffEYn = this.diffEYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaRAmt = this.bsaRAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
