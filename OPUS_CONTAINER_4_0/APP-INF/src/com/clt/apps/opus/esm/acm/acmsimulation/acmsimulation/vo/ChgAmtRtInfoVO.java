/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ChgAmtRtInfoVO.java
*@FileTitle : ChgAmtRtInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.01
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.01 김봉균 
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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChgAmtRtInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChgAmtRtInfoVO> models = new ArrayList<ChgAmtRtInfoVO>();
	
	/* Column Info */
	private String commAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ddctChg = null;
	/* Column Info */
	private String ddctSpcl = null;
	/* Column Info */
	private String ppdCrntAmt = null;
	/* Column Info */
	private String commRev = null;
	/* Column Info */
	private String ddctTrs = null;
	/* Column Info */
	private String ppdPayCrntAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChgAmtRtInfoVO() {}

	public ChgAmtRtInfoVO(String ibflag, String pagerows, String commRev, String ddctSpcl, String ddctChg, String ddctTrs, String commAmt, String ppdCrntAmt, String ppdPayCrntAmt) {
		this.commAmt = commAmt;
		this.ibflag = ibflag;
		this.ddctChg = ddctChg;
		this.ddctSpcl = ddctSpcl;
		this.ppdCrntAmt = ppdCrntAmt;
		this.commRev = commRev;
		this.ddctTrs = ddctTrs;
		this.ppdPayCrntAmt = ppdPayCrntAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("comm_amt", getCommAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ddct_chg", getDdctChg());
		this.hashColumns.put("ddct_spcl", getDdctSpcl());
		this.hashColumns.put("ppd_crnt_amt", getPpdCrntAmt());
		this.hashColumns.put("comm_rev", getCommRev());
		this.hashColumns.put("ddct_trs", getDdctTrs());
		this.hashColumns.put("ppd_pay_crnt_amt", getPpdPayCrntAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("comm_amt", "commAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ddct_chg", "ddctChg");
		this.hashFields.put("ddct_spcl", "ddctSpcl");
		this.hashFields.put("ppd_crnt_amt", "ppdCrntAmt");
		this.hashFields.put("comm_rev", "commRev");
		this.hashFields.put("ddct_trs", "ddctTrs");
		this.hashFields.put("ppd_pay_crnt_amt", "ppdPayCrntAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return commAmt
	 */
	public String getCommAmt() {
		return this.commAmt;
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
	 * @return ddctChg
	 */
	public String getDdctChg() {
		return this.ddctChg;
	}
	
	/**
	 * Column Info
	 * @return ddctSpcl
	 */
	public String getDdctSpcl() {
		return this.ddctSpcl;
	}
	
	/**
	 * Column Info
	 * @return ppdCrntAmt
	 */
	public String getPpdCrntAmt() {
		return this.ppdCrntAmt;
	}
	
	/**
	 * Column Info
	 * @return commRev
	 */
	public String getCommRev() {
		return this.commRev;
	}
	
	/**
	 * Column Info
	 * @return ddctTrs
	 */
	public String getDdctTrs() {
		return this.ddctTrs;
	}
	
	/**
	 * Column Info
	 * @return ppdPayCrntAmt
	 */
	public String getPpdPayCrntAmt() {
		return this.ppdPayCrntAmt;
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
	 * @param commAmt
	 */
	public void setCommAmt(String commAmt) {
		this.commAmt = commAmt;
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
	 * @param ddctChg
	 */
	public void setDdctChg(String ddctChg) {
		this.ddctChg = ddctChg;
	}
	
	/**
	 * Column Info
	 * @param ddctSpcl
	 */
	public void setDdctSpcl(String ddctSpcl) {
		this.ddctSpcl = ddctSpcl;
	}
	
	/**
	 * Column Info
	 * @param ppdCrntAmt
	 */
	public void setPpdCrntAmt(String ppdCrntAmt) {
		this.ppdCrntAmt = ppdCrntAmt;
	}
	
	/**
	 * Column Info
	 * @param commRev
	 */
	public void setCommRev(String commRev) {
		this.commRev = commRev;
	}
	
	/**
	 * Column Info
	 * @param ddctTrs
	 */
	public void setDdctTrs(String ddctTrs) {
		this.ddctTrs = ddctTrs;
	}
	
	/**
	 * Column Info
	 * @param ppdPayCrntAmt
	 */
	public void setPpdPayCrntAmt(String ppdPayCrntAmt) {
		this.ppdPayCrntAmt = ppdPayCrntAmt;
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
		setCommAmt(JSPUtil.getParameter(request, prefix + "comm_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDdctChg(JSPUtil.getParameter(request, prefix + "ddct_chg", ""));
		setDdctSpcl(JSPUtil.getParameter(request, prefix + "ddct_spcl", ""));
		setPpdCrntAmt(JSPUtil.getParameter(request, prefix + "ppd_crnt_amt", ""));
		setCommRev(JSPUtil.getParameter(request, prefix + "comm_rev", ""));
		setDdctTrs(JSPUtil.getParameter(request, prefix + "ddct_trs", ""));
		setPpdPayCrntAmt(JSPUtil.getParameter(request, prefix + "ppd_pay_crnt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChgAmtRtInfoVO[]
	 */
	public ChgAmtRtInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChgAmtRtInfoVO[]
	 */
	public ChgAmtRtInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChgAmtRtInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] commAmt = (JSPUtil.getParameter(request, prefix	+ "comm_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ddctChg = (JSPUtil.getParameter(request, prefix	+ "ddct_chg", length));
			String[] ddctSpcl = (JSPUtil.getParameter(request, prefix	+ "ddct_spcl", length));
			String[] ppdCrntAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_crnt_amt", length));
			String[] commRev = (JSPUtil.getParameter(request, prefix	+ "comm_rev", length));
			String[] ddctTrs = (JSPUtil.getParameter(request, prefix	+ "ddct_trs", length));
			String[] ppdPayCrntAmt = (JSPUtil.getParameter(request, prefix	+ "ppd_pay_crnt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChgAmtRtInfoVO();
				if (commAmt[i] != null)
					model.setCommAmt(commAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ddctChg[i] != null)
					model.setDdctChg(ddctChg[i]);
				if (ddctSpcl[i] != null)
					model.setDdctSpcl(ddctSpcl[i]);
				if (ppdCrntAmt[i] != null)
					model.setPpdCrntAmt(ppdCrntAmt[i]);
				if (commRev[i] != null)
					model.setCommRev(commRev[i]);
				if (ddctTrs[i] != null)
					model.setDdctTrs(ddctTrs[i]);
				if (ppdPayCrntAmt[i] != null)
					model.setPpdPayCrntAmt(ppdPayCrntAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChgAmtRtInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChgAmtRtInfoVO[]
	 */
	public ChgAmtRtInfoVO[] getChgAmtRtInfoVOs(){
		ChgAmtRtInfoVO[] vos = (ChgAmtRtInfoVO[])models.toArray(new ChgAmtRtInfoVO[models.size()]);
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
		this.commAmt = this.commAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctChg = this.ddctChg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctSpcl = this.ddctSpcl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdCrntAmt = this.ppdCrntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commRev = this.commRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctTrs = this.ddctTrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdPayCrntAmt = this.ppdPayCrntAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
