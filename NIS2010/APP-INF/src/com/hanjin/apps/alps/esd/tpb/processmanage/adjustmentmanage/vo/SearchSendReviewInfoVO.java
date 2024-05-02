/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSendReviewInfoVO.java
*@FileTitle : SearchSendReviewInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.29  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo;

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

public class SearchSendReviewInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSendReviewInfoVO> models = new ArrayList<SearchSendReviewInfoVO>();
	
	/* Column Info */
	private String diffRhqChk = null;
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String adjStsSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpbNxtPrcChk = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String n2ndRvwChk = null;
	/* Column Info */
	private String nxtStpRocChk = null;
	/* Column Info */
	private String adjN2ndRvwStsCd = null;
	/* Column Info */
	private String adjN2ndRvwSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSendReviewInfoVO() {}

	public SearchSendReviewInfoVO(String ibflag, String pagerows, String n2ndRvwChk, String adjStsSeq, String adjN2ndRvwSeq, String adjN2ndRvwStsCd, String n3ptyNo, String userOfcCd, String tpbNxtPrcChk, String nxtStpRocChk, String diffRhqChk) {
		this.diffRhqChk = diffRhqChk;
		this.userOfcCd = userOfcCd;
		this.adjStsSeq = adjStsSeq;
		this.ibflag = ibflag;
		this.tpbNxtPrcChk = tpbNxtPrcChk;
		this.n3ptyNo = n3ptyNo;
		this.n2ndRvwChk = n2ndRvwChk;
		this.nxtStpRocChk = nxtStpRocChk;
		this.adjN2ndRvwStsCd = adjN2ndRvwStsCd;
		this.adjN2ndRvwSeq = adjN2ndRvwSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("diff_rhq_chk", getDiffRhqChk());
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("adj_sts_seq", getAdjStsSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpb_nxt_prc_chk", getTpbNxtPrcChk());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("n2nd_rvw_chk", getN2ndRvwChk());
		this.hashColumns.put("nxt_stp_roc_chk", getNxtStpRocChk());
		this.hashColumns.put("adj_n2nd_rvw_sts_cd", getAdjN2ndRvwStsCd());
		this.hashColumns.put("adj_n2nd_rvw_seq", getAdjN2ndRvwSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("diff_rhq_chk", "diffRhqChk");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("adj_sts_seq", "adjStsSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpb_nxt_prc_chk", "tpbNxtPrcChk");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("n2nd_rvw_chk", "n2ndRvwChk");
		this.hashFields.put("nxt_stp_roc_chk", "nxtStpRocChk");
		this.hashFields.put("adj_n2nd_rvw_sts_cd", "adjN2ndRvwStsCd");
		this.hashFields.put("adj_n2nd_rvw_seq", "adjN2ndRvwSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return diffRhqChk
	 */
	public String getDiffRhqChk() {
		return this.diffRhqChk;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
	}
	
	/**
	 * Column Info
	 * @return adjStsSeq
	 */
	public String getAdjStsSeq() {
		return this.adjStsSeq;
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
	 * @return tpbNxtPrcChk
	 */
	public String getTpbNxtPrcChk() {
		return this.tpbNxtPrcChk;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return n2ndRvwChk
	 */
	public String getN2ndRvwChk() {
		return this.n2ndRvwChk;
	}
	
	/**
	 * Column Info
	 * @return nxtStpRocChk
	 */
	public String getNxtStpRocChk() {
		return this.nxtStpRocChk;
	}
	
	/**
	 * Column Info
	 * @return adjN2ndRvwStsCd
	 */
	public String getAdjN2ndRvwStsCd() {
		return this.adjN2ndRvwStsCd;
	}
	
	/**
	 * Column Info
	 * @return adjN2ndRvwSeq
	 */
	public String getAdjN2ndRvwSeq() {
		return this.adjN2ndRvwSeq;
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
	 * @param diffRhqChk
	 */
	public void setDiffRhqChk(String diffRhqChk) {
		this.diffRhqChk = diffRhqChk;
	}
	
	/**
	 * Column Info
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * Column Info
	 * @param adjStsSeq
	 */
	public void setAdjStsSeq(String adjStsSeq) {
		this.adjStsSeq = adjStsSeq;
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
	 * @param tpbNxtPrcChk
	 */
	public void setTpbNxtPrcChk(String tpbNxtPrcChk) {
		this.tpbNxtPrcChk = tpbNxtPrcChk;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param n2ndRvwChk
	 */
	public void setN2ndRvwChk(String n2ndRvwChk) {
		this.n2ndRvwChk = n2ndRvwChk;
	}
	
	/**
	 * Column Info
	 * @param nxtStpRocChk
	 */
	public void setNxtStpRocChk(String nxtStpRocChk) {
		this.nxtStpRocChk = nxtStpRocChk;
	}
	
	/**
	 * Column Info
	 * @param adjN2ndRvwStsCd
	 */
	public void setAdjN2ndRvwStsCd(String adjN2ndRvwStsCd) {
		this.adjN2ndRvwStsCd = adjN2ndRvwStsCd;
	}
	
	/**
	 * Column Info
	 * @param adjN2ndRvwSeq
	 */
	public void setAdjN2ndRvwSeq(String adjN2ndRvwSeq) {
		this.adjN2ndRvwSeq = adjN2ndRvwSeq;
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
		setDiffRhqChk(JSPUtil.getParameter(request, prefix + "diff_rhq_chk", ""));
		setUserOfcCd(JSPUtil.getParameter(request, prefix + "user_ofc_cd", ""));
		setAdjStsSeq(JSPUtil.getParameter(request, prefix + "adj_sts_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTpbNxtPrcChk(JSPUtil.getParameter(request, prefix + "tpb_nxt_prc_chk", ""));
		setN3ptyNo(JSPUtil.getParameter(request, prefix + "n3pty_no", ""));
		setN2ndRvwChk(JSPUtil.getParameter(request, prefix + "n2nd_rvw_chk", ""));
		setNxtStpRocChk(JSPUtil.getParameter(request, prefix + "nxt_stp_roc_chk", ""));
		setAdjN2ndRvwStsCd(JSPUtil.getParameter(request, prefix + "adj_n2nd_rvw_sts_cd", ""));
		setAdjN2ndRvwSeq(JSPUtil.getParameter(request, prefix + "adj_n2nd_rvw_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSendReviewInfoVO[]
	 */
	public SearchSendReviewInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSendReviewInfoVO[]
	 */
	public SearchSendReviewInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSendReviewInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] diffRhqChk = (JSPUtil.getParameter(request, prefix	+ "diff_rhq_chk", length));
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] adjStsSeq = (JSPUtil.getParameter(request, prefix	+ "adj_sts_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpbNxtPrcChk = (JSPUtil.getParameter(request, prefix	+ "tpb_nxt_prc_chk", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] n2ndRvwChk = (JSPUtil.getParameter(request, prefix	+ "n2nd_rvw_chk", length));
			String[] nxtStpRocChk = (JSPUtil.getParameter(request, prefix	+ "nxt_stp_roc_chk", length));
			String[] adjN2ndRvwStsCd = (JSPUtil.getParameter(request, prefix	+ "adj_n2nd_rvw_sts_cd", length));
			String[] adjN2ndRvwSeq = (JSPUtil.getParameter(request, prefix	+ "adj_n2nd_rvw_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSendReviewInfoVO();
				if (diffRhqChk[i] != null)
					model.setDiffRhqChk(diffRhqChk[i]);
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (adjStsSeq[i] != null)
					model.setAdjStsSeq(adjStsSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpbNxtPrcChk[i] != null)
					model.setTpbNxtPrcChk(tpbNxtPrcChk[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (n2ndRvwChk[i] != null)
					model.setN2ndRvwChk(n2ndRvwChk[i]);
				if (nxtStpRocChk[i] != null)
					model.setNxtStpRocChk(nxtStpRocChk[i]);
				if (adjN2ndRvwStsCd[i] != null)
					model.setAdjN2ndRvwStsCd(adjN2ndRvwStsCd[i]);
				if (adjN2ndRvwSeq[i] != null)
					model.setAdjN2ndRvwSeq(adjN2ndRvwSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSendReviewInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSendReviewInfoVO[]
	 */
	public SearchSendReviewInfoVO[] getSearchSendReviewInfoVOs(){
		SearchSendReviewInfoVO[] vos = (SearchSendReviewInfoVO[])models.toArray(new SearchSendReviewInfoVO[models.size()]);
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
		this.diffRhqChk = this.diffRhqChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjStsSeq = this.adjStsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbNxtPrcChk = this.tpbNxtPrcChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndRvwChk = this.n2ndRvwChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtStpRocChk = this.nxtStpRocChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjN2ndRvwStsCd = this.adjN2ndRvwStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjN2ndRvwSeq = this.adjN2ndRvwSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
