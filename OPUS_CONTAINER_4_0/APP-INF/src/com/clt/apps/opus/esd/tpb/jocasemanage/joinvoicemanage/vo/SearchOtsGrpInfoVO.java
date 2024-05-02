/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchOtsGrpInfoVO.java
*@FileTitle : SearchOtsGrpInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.11.10 박성진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOtsGrpInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOtsGrpInfoVO> models = new ArrayList<SearchOtsGrpInfoVO>();
	
	/* Column Info */
	private String n3ptyExpnTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String lengthN3ptyExpnTpCd = null;
	/* Column Info */
	private String trdParty = null;
	/* Column Info */
	private String lengthCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* Column Info */
	private String lengthN3ptyBilTpCd = null;
	/* Column Info */
	private String sDetailN3ptyNo = null;
	/* Column Info */
	private String lengthRevVvd = null;
	/* Column Info */
	private String lengthTrdParty = null;
	/* Column Info */
	private String revVvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchOtsGrpInfoVO() {}

	public SearchOtsGrpInfoVO(String ibflag, String pagerows, String n3ptyExpnTpCd, String currCd, String lengthN3ptyExpnTpCd, String trdParty, String lengthCurrCd, String n3ptyBilTpCd, String lengthN3ptyBilTpCd, String sDetailN3ptyNo, String lengthRevVvd, String lengthTrdParty, String revVvd) {
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
		this.currCd = currCd;
		this.lengthN3ptyExpnTpCd = lengthN3ptyExpnTpCd;
		this.trdParty = trdParty;
		this.lengthCurrCd = lengthCurrCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.lengthN3ptyBilTpCd = lengthN3ptyBilTpCd;
		this.sDetailN3ptyNo = sDetailN3ptyNo;
		this.lengthRevVvd = lengthRevVvd;
		this.lengthTrdParty = lengthTrdParty;
		this.revVvd = revVvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n3pty_expn_tp_cd", getN3ptyExpnTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("length_n3pty_expn_tp_cd", getLengthN3ptyExpnTpCd());
		this.hashColumns.put("trd_party", getTrdParty());
		this.hashColumns.put("length_curr_cd", getLengthCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("length_n3pty_bil_tp_cd", getLengthN3ptyBilTpCd());
		this.hashColumns.put("s_detail_n3pty_no", getSDetailN3ptyNo());
		this.hashColumns.put("length_rev_vvd", getLengthRevVvd());
		this.hashColumns.put("length_trd_party", getLengthTrdParty());
		this.hashColumns.put("rev_vvd", getRevVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n3pty_expn_tp_cd", "n3ptyExpnTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("length_n3pty_expn_tp_cd", "lengthN3ptyExpnTpCd");
		this.hashFields.put("trd_party", "trdParty");
		this.hashFields.put("length_curr_cd", "lengthCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("length_n3pty_bil_tp_cd", "lengthN3ptyBilTpCd");
		this.hashFields.put("s_detail_n3pty_no", "sDetailN3ptyNo");
		this.hashFields.put("length_rev_vvd", "lengthRevVvd");
		this.hashFields.put("length_trd_party", "lengthTrdParty");
		this.hashFields.put("rev_vvd", "revVvd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return n3ptyExpnTpCd
	 */
	public String getN3ptyExpnTpCd() {
		return this.n3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return lengthN3ptyExpnTpCd
	 */
	public String getLengthN3ptyExpnTpCd() {
		return this.lengthN3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @return trdParty
	 */
	public String getTrdParty() {
		return this.trdParty;
	}
	
	/**
	 * Column Info
	 * @return lengthCurrCd
	 */
	public String getLengthCurrCd() {
		return this.lengthCurrCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return n3ptyBilTpCd
	 */
	public String getN3ptyBilTpCd() {
		return this.n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return lengthN3ptyBilTpCd
	 */
	public String getLengthN3ptyBilTpCd() {
		return this.lengthN3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return sDetailN3ptyNo
	 */
	public String getSDetailN3ptyNo() {
		return this.sDetailN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return lengthRevVvd
	 */
	public String getLengthRevVvd() {
		return this.lengthRevVvd;
	}
	
	/**
	 * Column Info
	 * @return lengthTrdParty
	 */
	public String getLengthTrdParty() {
		return this.lengthTrdParty;
	}
	
	/**
	 * Column Info
	 * @return revVvd
	 */
	public String getRevVvd() {
		return this.revVvd;
	}
	

	/**
	 * Column Info
	 * @param n3ptyExpnTpCd
	 */
	public void setN3ptyExpnTpCd(String n3ptyExpnTpCd) {
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param lengthN3ptyExpnTpCd
	 */
	public void setLengthN3ptyExpnTpCd(String lengthN3ptyExpnTpCd) {
		this.lengthN3ptyExpnTpCd = lengthN3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @param trdParty
	 */
	public void setTrdParty(String trdParty) {
		this.trdParty = trdParty;
	}
	
	/**
	 * Column Info
	 * @param lengthCurrCd
	 */
	public void setLengthCurrCd(String lengthCurrCd) {
		this.lengthCurrCd = lengthCurrCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param n3ptyBilTpCd
	 */
	public void setN3ptyBilTpCd(String n3ptyBilTpCd) {
		this.n3ptyBilTpCd = n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param lengthN3ptyBilTpCd
	 */
	public void setLengthN3ptyBilTpCd(String lengthN3ptyBilTpCd) {
		this.lengthN3ptyBilTpCd = lengthN3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param sDetailN3ptyNo
	 */
	public void setSDetailN3ptyNo(String sDetailN3ptyNo) {
		this.sDetailN3ptyNo = sDetailN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param lengthRevVvd
	 */
	public void setLengthRevVvd(String lengthRevVvd) {
		this.lengthRevVvd = lengthRevVvd;
	}
	
	/**
	 * Column Info
	 * @param lengthTrdParty
	 */
	public void setLengthTrdParty(String lengthTrdParty) {
		this.lengthTrdParty = lengthTrdParty;
	}
	
	/**
	 * Column Info
	 * @param revVvd
	 */
	public void setRevVvd(String revVvd) {
		this.revVvd = revVvd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setN3ptyExpnTpCd(JSPUtil.getParameter(request, "n3pty_expn_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setLengthN3ptyExpnTpCd(JSPUtil.getParameter(request, "length_n3pty_expn_tp_cd", ""));
		setTrdParty(JSPUtil.getParameter(request, "trd_party", ""));
		setLengthCurrCd(JSPUtil.getParameter(request, "length_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, "n3pty_bil_tp_cd", ""));
		setLengthN3ptyBilTpCd(JSPUtil.getParameter(request, "length_n3pty_bil_tp_cd", ""));
		setSDetailN3ptyNo(JSPUtil.getParameter(request, "s_detail_n3pty_no", ""));
		setLengthRevVvd(JSPUtil.getParameter(request, "length_rev_vvd", ""));
		setLengthTrdParty(JSPUtil.getParameter(request, "length_trd_party", ""));
		setRevVvd(JSPUtil.getParameter(request, "rev_vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOtsGrpInfoVO[]
	 */
	public SearchOtsGrpInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOtsGrpInfoVO[]
	 */
	public SearchOtsGrpInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOtsGrpInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] n3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_expn_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] lengthN3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "length_n3pty_expn_tp_cd", length));
			String[] trdParty = (JSPUtil.getParameter(request, prefix	+ "trd_party", length));
			String[] lengthCurrCd = (JSPUtil.getParameter(request, prefix	+ "length_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] lengthN3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "length_n3pty_bil_tp_cd", length));
			String[] sDetailN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_detail_n3pty_no", length));
			String[] lengthRevVvd = (JSPUtil.getParameter(request, prefix	+ "length_rev_vvd", length));
			String[] lengthTrdParty = (JSPUtil.getParameter(request, prefix	+ "length_trd_party", length));
			String[] revVvd = (JSPUtil.getParameter(request, prefix	+ "rev_vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOtsGrpInfoVO();
				if (n3ptyExpnTpCd[i] != null)
					model.setN3ptyExpnTpCd(n3ptyExpnTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (lengthN3ptyExpnTpCd[i] != null)
					model.setLengthN3ptyExpnTpCd(lengthN3ptyExpnTpCd[i]);
				if (trdParty[i] != null)
					model.setTrdParty(trdParty[i]);
				if (lengthCurrCd[i] != null)
					model.setLengthCurrCd(lengthCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
				if (lengthN3ptyBilTpCd[i] != null)
					model.setLengthN3ptyBilTpCd(lengthN3ptyBilTpCd[i]);
				if (sDetailN3ptyNo[i] != null)
					model.setSDetailN3ptyNo(sDetailN3ptyNo[i]);
				if (lengthRevVvd[i] != null)
					model.setLengthRevVvd(lengthRevVvd[i]);
				if (lengthTrdParty[i] != null)
					model.setLengthTrdParty(lengthTrdParty[i]);
				if (revVvd[i] != null)
					model.setRevVvd(revVvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOtsGrpInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOtsGrpInfoVO[]
	 */
	public SearchOtsGrpInfoVO[] getSearchOtsGrpInfoVOs(){
		SearchOtsGrpInfoVO[] vos = (SearchOtsGrpInfoVO[])models.toArray(new SearchOtsGrpInfoVO[models.size()]);
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
		this.n3ptyExpnTpCd = this.n3ptyExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lengthN3ptyExpnTpCd = this.lengthN3ptyExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdParty = this.trdParty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lengthCurrCd = this.lengthCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lengthN3ptyBilTpCd = this.lengthN3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDetailN3ptyNo = this.sDetailN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lengthRevVvd = this.lengthRevVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lengthTrdParty = this.lengthTrdParty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd = this.revVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
