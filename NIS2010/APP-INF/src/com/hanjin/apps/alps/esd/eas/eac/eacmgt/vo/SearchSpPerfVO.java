/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchSpPerfVO.java
*@FileTitle : SearchSpPerfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.03
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2014.12.03 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo;

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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */


public class SearchSpPerfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpPerfVO> models = new ArrayList<SearchSpPerfVO>();
	
	/* Column Info */
	private String eacCnt = null;
	/* Column Info */
	private String pndCnt = null;
	/* Column Info */
	private String cmplAmt = null;
	/* Column Info */
	private String eacAmt = null;
	/* Column Info */
	private String procAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String procCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmplCnt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String pndAmt = null;
	/* Column Info */
	private String tpbAmt = null;
	/* Column Info */
	private String rnk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchSpPerfVO() {}

	public SearchSpPerfVO(String ibflag, String pagerows, String rnk, String vndrSeq, String vndrNm, String eacCnt, String eacAmt, String tpbAmt, String procCnt, String procAmt, String pndCnt, String pndAmt, String cmplCnt, String cmplAmt) {
		this.eacCnt = eacCnt;
		this.pndCnt = pndCnt;
		this.cmplAmt = cmplAmt;
		this.eacAmt = eacAmt;
		this.procAmt = procAmt;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.procCnt = procCnt;
		this.ibflag = ibflag;
		this.cmplCnt = cmplCnt;
		this.vndrSeq = vndrSeq;
		this.pndAmt = pndAmt;
		this.tpbAmt = tpbAmt;
		this.rnk = rnk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eac_cnt", getEacCnt());
		this.hashColumns.put("pnd_cnt", getPndCnt());
		this.hashColumns.put("cmpl_amt", getCmplAmt());
		this.hashColumns.put("eac_amt", getEacAmt());
		this.hashColumns.put("proc_amt", getProcAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("proc_cnt", getProcCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmpl_cnt", getCmplCnt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("pnd_amt", getPndAmt());
		this.hashColumns.put("tpb_amt", getTpbAmt());
		this.hashColumns.put("rnk", getRnk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eac_cnt", "eacCnt");
		this.hashFields.put("pnd_cnt", "pndCnt");
		this.hashFields.put("cmpl_amt", "cmplAmt");
		this.hashFields.put("eac_amt", "eacAmt");
		this.hashFields.put("proc_amt", "procAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("proc_cnt", "procCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmpl_cnt", "cmplCnt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("pnd_amt", "pndAmt");
		this.hashFields.put("tpb_amt", "tpbAmt");
		this.hashFields.put("rnk", "rnk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eacCnt
	 */
	public String getEacCnt() {
		return this.eacCnt;
	}
	
	/**
	 * Column Info
	 * @return pndCnt
	 */
	public String getPndCnt() {
		return this.pndCnt;
	}
	
	/**
	 * Column Info
	 * @return cmplAmt
	 */
	public String getCmplAmt() {
		return this.cmplAmt;
	}
	
	/**
	 * Column Info
	 * @return eacAmt
	 */
	public String getEacAmt() {
		return this.eacAmt;
	}
	
	/**
	 * Column Info
	 * @return procAmt
	 */
	public String getProcAmt() {
		return this.procAmt;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return procCnt
	 */
	public String getProcCnt() {
		return this.procCnt;
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
	 * @return cmplCnt
	 */
	public String getCmplCnt() {
		return this.cmplCnt;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return pndAmt
	 */
	public String getPndAmt() {
		return this.pndAmt;
	}
	
	/**
	 * Column Info
	 * @return tpbAmt
	 */
	public String getTpbAmt() {
		return this.tpbAmt;
	}
	
	/**
	 * Column Info
	 * @return rnk
	 */
	public String getRnk() {
		return this.rnk;
	}
	

	/**
	 * Column Info
	 * @param eacCnt
	 */
	public void setEacCnt(String eacCnt) {
		this.eacCnt = eacCnt;
	}
	
	/**
	 * Column Info
	 * @param pndCnt
	 */
	public void setPndCnt(String pndCnt) {
		this.pndCnt = pndCnt;
	}
	
	/**
	 * Column Info
	 * @param cmplAmt
	 */
	public void setCmplAmt(String cmplAmt) {
		this.cmplAmt = cmplAmt;
	}
	
	/**
	 * Column Info
	 * @param eacAmt
	 */
	public void setEacAmt(String eacAmt) {
		this.eacAmt = eacAmt;
	}
	
	/**
	 * Column Info
	 * @param procAmt
	 */
	public void setProcAmt(String procAmt) {
		this.procAmt = procAmt;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param procCnt
	 */
	public void setProcCnt(String procCnt) {
		this.procCnt = procCnt;
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
	 * @param cmplCnt
	 */
	public void setCmplCnt(String cmplCnt) {
		this.cmplCnt = cmplCnt;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param pndAmt
	 */
	public void setPndAmt(String pndAmt) {
		this.pndAmt = pndAmt;
	}
	
	/**
	 * Column Info
	 * @param tpbAmt
	 */
	public void setTpbAmt(String tpbAmt) {
		this.tpbAmt = tpbAmt;
	}
	
	/**
	 * Column Info
	 * @param rnk
	 */
	public void setRnk(String rnk) {
		this.rnk = rnk;
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
		setEacCnt(JSPUtil.getParameter(request, prefix + "eac_cnt", ""));
		setPndCnt(JSPUtil.getParameter(request, prefix + "pnd_cnt", ""));
		setCmplAmt(JSPUtil.getParameter(request, prefix + "cmpl_amt", ""));
		setEacAmt(JSPUtil.getParameter(request, prefix + "eac_amt", ""));
		setProcAmt(JSPUtil.getParameter(request, prefix + "proc_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setProcCnt(JSPUtil.getParameter(request, prefix + "proc_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmplCnt(JSPUtil.getParameter(request, prefix + "cmpl_cnt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setPndAmt(JSPUtil.getParameter(request, prefix + "pnd_amt", ""));
		setTpbAmt(JSPUtil.getParameter(request, prefix + "tpb_amt", ""));
		setRnk(JSPUtil.getParameter(request, prefix + "rnk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpPerfVO[]
	 */
	public SearchSpPerfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpPerfVO[]
	 */
	public SearchSpPerfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpPerfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eacCnt = (JSPUtil.getParameter(request, prefix	+ "eac_cnt", length));
			String[] pndCnt = (JSPUtil.getParameter(request, prefix	+ "pnd_cnt", length));
			String[] cmplAmt = (JSPUtil.getParameter(request, prefix	+ "cmpl_amt", length));
			String[] eacAmt = (JSPUtil.getParameter(request, prefix	+ "eac_amt", length));
			String[] procAmt = (JSPUtil.getParameter(request, prefix	+ "proc_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] procCnt = (JSPUtil.getParameter(request, prefix	+ "proc_cnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmplCnt = (JSPUtil.getParameter(request, prefix	+ "cmpl_cnt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] pndAmt = (JSPUtil.getParameter(request, prefix	+ "pnd_amt", length));
			String[] tpbAmt = (JSPUtil.getParameter(request, prefix	+ "tpb_amt", length));
			String[] rnk = (JSPUtil.getParameter(request, prefix	+ "rnk", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpPerfVO();
				if (eacCnt[i] != null)
					model.setEacCnt(eacCnt[i]);
				if (pndCnt[i] != null)
					model.setPndCnt(pndCnt[i]);
				if (cmplAmt[i] != null)
					model.setCmplAmt(cmplAmt[i]);
				if (eacAmt[i] != null)
					model.setEacAmt(eacAmt[i]);
				if (procAmt[i] != null)
					model.setProcAmt(procAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (procCnt[i] != null)
					model.setProcCnt(procCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmplCnt[i] != null)
					model.setCmplCnt(cmplCnt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (pndAmt[i] != null)
					model.setPndAmt(pndAmt[i]);
				if (tpbAmt[i] != null)
					model.setTpbAmt(tpbAmt[i]);
				if (rnk[i] != null)
					model.setRnk(rnk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpPerfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpPerfVO[]
	 */
	public SearchSpPerfVO[] getSearchSpPerfVOs(){
		SearchSpPerfVO[] vos = (SearchSpPerfVO[])models.toArray(new SearchSpPerfVO[models.size()]);
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
		this.eacCnt = this.eacCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pndCnt = this.pndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmplAmt = this.cmplAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacAmt = this.eacAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.procAmt = this.procAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.procCnt = this.procCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmplCnt = this.cmplCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pndAmt = this.pndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbAmt = this.tpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnk = this.rnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
