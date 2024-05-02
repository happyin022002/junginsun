/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchErpInterfaceCheckDataVO.java
*@FileTitle : SearchErpInterfaceCheckDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.11.13 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.jocasemanage.joinvoicemanage.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchErpInterfaceCheckDataVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchErpInterfaceCheckDataVO> models = new ArrayList<SearchErpInterfaceCheckDataVO>();
	
	/* Column Info */
	private String revenueVvdCnt = null;
	/* Column Info */
	private String currCdMax = null;
	/* Column Info */
	private String currCdCnt = null;
	/* Column Info */
	private String csrNoCnt = null;
	/* Column Info */
	private String trdPartyCodeMax = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trdPartyCodeCnt = null;
	/* Column Info */
	private String n3ptyBilTpCdCnt = null;
	/* Column Info */
	private String glMonthMax = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String csrNoMax = null;
	/* Column Info */
	private String vvdCdMax = null;
	/* Column Info */
	private String revenueVvdMax = null;
	/* Column Info */
	private String glMonthCnt = null;
	/* Column Info */
	private String n3ptyExpnTpCdMax = null;
	/* Column Info */
	private String vvdCdCnt = null;
	/* Column Info */
	private String n3ptyExpnTpCdCnt = null;
	/* Column Info */
	private String n3ptyBilTpCdMax = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchErpInterfaceCheckDataVO() {}

	public SearchErpInterfaceCheckDataVO(String ibflag, String pagerows, String revenueVvdCnt, String currCdMax, String currCdCnt, String csrNoCnt, String trdPartyCodeMax, String trdPartyCodeCnt, String n3ptyBilTpCdCnt, String glMonthMax, String csrNoMax, String vvdCdMax, String revenueVvdMax, String glMonthCnt, String n3ptyExpnTpCdMax, String n3ptyExpnTpCdCnt, String vvdCdCnt, String n3ptyBilTpCdMax) {
		this.revenueVvdCnt = revenueVvdCnt;
		this.currCdMax = currCdMax;
		this.currCdCnt = currCdCnt;
		this.csrNoCnt = csrNoCnt;
		this.trdPartyCodeMax = trdPartyCodeMax;
		this.pagerows = pagerows;
		this.trdPartyCodeCnt = trdPartyCodeCnt;
		this.n3ptyBilTpCdCnt = n3ptyBilTpCdCnt;
		this.glMonthMax = glMonthMax;
		this.ibflag = ibflag;
		this.csrNoMax = csrNoMax;
		this.vvdCdMax = vvdCdMax;
		this.revenueVvdMax = revenueVvdMax;
		this.glMonthCnt = glMonthCnt;
		this.n3ptyExpnTpCdMax = n3ptyExpnTpCdMax;
		this.vvdCdCnt = vvdCdCnt;
		this.n3ptyExpnTpCdCnt = n3ptyExpnTpCdCnt;
		this.n3ptyBilTpCdMax = n3ptyBilTpCdMax;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("revenue_vvd_cnt", getRevenueVvdCnt());
		this.hashColumns.put("curr_cd_max", getCurrCdMax());
		this.hashColumns.put("curr_cd_cnt", getCurrCdCnt());
		this.hashColumns.put("csr_no_cnt", getCsrNoCnt());
		this.hashColumns.put("trd_party_code_max", getTrdPartyCodeMax());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trd_party_code_cnt", getTrdPartyCodeCnt());
		this.hashColumns.put("n3pty_bil_tp_cd_cnt", getN3ptyBilTpCdCnt());
		this.hashColumns.put("gl_month_max", getGlMonthMax());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("csr_no_max", getCsrNoMax());
		this.hashColumns.put("vvd_cd_max", getVvdCdMax());
		this.hashColumns.put("revenue_vvd_max", getRevenueVvdMax());
		this.hashColumns.put("gl_month_cnt", getGlMonthCnt());
		this.hashColumns.put("n3pty_expn_tp_cd_max", getN3ptyExpnTpCdMax());
		this.hashColumns.put("vvd_cd_cnt", getVvdCdCnt());
		this.hashColumns.put("n3pty_expn_tp_cd_cnt", getN3ptyExpnTpCdCnt());
		this.hashColumns.put("n3pty_bil_tp_cd_max", getN3ptyBilTpCdMax());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("revenue_vvd_cnt", "revenueVvdCnt");
		this.hashFields.put("curr_cd_max", "currCdMax");
		this.hashFields.put("curr_cd_cnt", "currCdCnt");
		this.hashFields.put("csr_no_cnt", "csrNoCnt");
		this.hashFields.put("trd_party_code_max", "trdPartyCodeMax");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trd_party_code_cnt", "trdPartyCodeCnt");
		this.hashFields.put("n3pty_bil_tp_cd_cnt", "n3ptyBilTpCdCnt");
		this.hashFields.put("gl_month_max", "glMonthMax");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("csr_no_max", "csrNoMax");
		this.hashFields.put("vvd_cd_max", "vvdCdMax");
		this.hashFields.put("revenue_vvd_max", "revenueVvdMax");
		this.hashFields.put("gl_month_cnt", "glMonthCnt");
		this.hashFields.put("n3pty_expn_tp_cd_max", "n3ptyExpnTpCdMax");
		this.hashFields.put("vvd_cd_cnt", "vvdCdCnt");
		this.hashFields.put("n3pty_expn_tp_cd_cnt", "n3ptyExpnTpCdCnt");
		this.hashFields.put("n3pty_bil_tp_cd_max", "n3ptyBilTpCdMax");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return revenueVvdCnt
	 */
	public String getRevenueVvdCnt() {
		return this.revenueVvdCnt;
	}
	
	/**
	 * Column Info
	 * @return currCdMax
	 */
	public String getCurrCdMax() {
		return this.currCdMax;
	}
	
	/**
	 * Column Info
	 * @return currCdCnt
	 */
	public String getCurrCdCnt() {
		return this.currCdCnt;
	}
	
	/**
	 * Column Info
	 * @return csrNoCnt
	 */
	public String getCsrNoCnt() {
		return this.csrNoCnt;
	}
	
	/**
	 * Column Info
	 * @return trdPartyCodeMax
	 */
	public String getTrdPartyCodeMax() {
		return this.trdPartyCodeMax;
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
	 * @return trdPartyCodeCnt
	 */
	public String getTrdPartyCodeCnt() {
		return this.trdPartyCodeCnt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpCdCnt
	 */
	public String getN3ptyBilTpCdCnt() {
		return this.n3ptyBilTpCdCnt;
	}
	
	/**
	 * Column Info
	 * @return glMonthMax
	 */
	public String getGlMonthMax() {
		return this.glMonthMax;
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
	 * @return csrNoMax
	 */
	public String getCsrNoMax() {
		return this.csrNoMax;
	}
	
	/**
	 * Column Info
	 * @return vvdCdMax
	 */
	public String getVvdCdMax() {
		return this.vvdCdMax;
	}
	
	/**
	 * Column Info
	 * @return revenueVvdMax
	 */
	public String getRevenueVvdMax() {
		return this.revenueVvdMax;
	}
	
	/**
	 * Column Info
	 * @return glMonthCnt
	 */
	public String getGlMonthCnt() {
		return this.glMonthCnt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyExpnTpCdMax
	 */
	public String getN3ptyExpnTpCdMax() {
		return this.n3ptyExpnTpCdMax;
	}
	
	/**
	 * Column Info
	 * @return vvdCdCnt
	 */
	public String getVvdCdCnt() {
		return this.vvdCdCnt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyExpnTpCdCnt
	 */
	public String getN3ptyExpnTpCdCnt() {
		return this.n3ptyExpnTpCdCnt;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpCdMax
	 */
	public String getN3ptyBilTpCdMax() {
		return this.n3ptyBilTpCdMax;
	}
	

	/**
	 * Column Info
	 * @param revenueVvdCnt
	 */
	public void setRevenueVvdCnt(String revenueVvdCnt) {
		this.revenueVvdCnt = revenueVvdCnt;
	}
	
	/**
	 * Column Info
	 * @param currCdMax
	 */
	public void setCurrCdMax(String currCdMax) {
		this.currCdMax = currCdMax;
	}
	
	/**
	 * Column Info
	 * @param currCdCnt
	 */
	public void setCurrCdCnt(String currCdCnt) {
		this.currCdCnt = currCdCnt;
	}
	
	/**
	 * Column Info
	 * @param csrNoCnt
	 */
	public void setCsrNoCnt(String csrNoCnt) {
		this.csrNoCnt = csrNoCnt;
	}
	
	/**
	 * Column Info
	 * @param trdPartyCodeMax
	 */
	public void setTrdPartyCodeMax(String trdPartyCodeMax) {
		this.trdPartyCodeMax = trdPartyCodeMax;
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
	 * @param trdPartyCodeCnt
	 */
	public void setTrdPartyCodeCnt(String trdPartyCodeCnt) {
		this.trdPartyCodeCnt = trdPartyCodeCnt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpCdCnt
	 */
	public void setN3ptyBilTpCdCnt(String n3ptyBilTpCdCnt) {
		this.n3ptyBilTpCdCnt = n3ptyBilTpCdCnt;
	}
	
	/**
	 * Column Info
	 * @param glMonthMax
	 */
	public void setGlMonthMax(String glMonthMax) {
		this.glMonthMax = glMonthMax;
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
	 * @param csrNoMax
	 */
	public void setCsrNoMax(String csrNoMax) {
		this.csrNoMax = csrNoMax;
	}
	
	/**
	 * Column Info
	 * @param vvdCdMax
	 */
	public void setVvdCdMax(String vvdCdMax) {
		this.vvdCdMax = vvdCdMax;
	}
	
	/**
	 * Column Info
	 * @param revenueVvdMax
	 */
	public void setRevenueVvdMax(String revenueVvdMax) {
		this.revenueVvdMax = revenueVvdMax;
	}
	
	/**
	 * Column Info
	 * @param glMonthCnt
	 */
	public void setGlMonthCnt(String glMonthCnt) {
		this.glMonthCnt = glMonthCnt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyExpnTpCdMax
	 */
	public void setN3ptyExpnTpCdMax(String n3ptyExpnTpCdMax) {
		this.n3ptyExpnTpCdMax = n3ptyExpnTpCdMax;
	}
	
	/**
	 * Column Info
	 * @param vvdCdCnt
	 */
	public void setVvdCdCnt(String vvdCdCnt) {
		this.vvdCdCnt = vvdCdCnt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyExpnTpCdCnt
	 */
	public void setN3ptyExpnTpCdCnt(String n3ptyExpnTpCdCnt) {
		this.n3ptyExpnTpCdCnt = n3ptyExpnTpCdCnt;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpCdMax
	 */
	public void setN3ptyBilTpCdMax(String n3ptyBilTpCdMax) {
		this.n3ptyBilTpCdMax = n3ptyBilTpCdMax;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRevenueVvdCnt(JSPUtil.getParameter(request, "revenue_vvd_cnt", ""));
		setCurrCdMax(JSPUtil.getParameter(request, "curr_cd_max", ""));
		setCurrCdCnt(JSPUtil.getParameter(request, "curr_cd_cnt", ""));
		setCsrNoCnt(JSPUtil.getParameter(request, "csr_no_cnt", ""));
		setTrdPartyCodeMax(JSPUtil.getParameter(request, "trd_party_code_max", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTrdPartyCodeCnt(JSPUtil.getParameter(request, "trd_party_code_cnt", ""));
		setN3ptyBilTpCdCnt(JSPUtil.getParameter(request, "n3pty_bil_tp_cd_cnt", ""));
		setGlMonthMax(JSPUtil.getParameter(request, "gl_month_max", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCsrNoMax(JSPUtil.getParameter(request, "csr_no_max", ""));
		setVvdCdMax(JSPUtil.getParameter(request, "vvd_cd_max", ""));
		setRevenueVvdMax(JSPUtil.getParameter(request, "revenue_vvd_max", ""));
		setGlMonthCnt(JSPUtil.getParameter(request, "gl_month_cnt", ""));
		setN3ptyExpnTpCdMax(JSPUtil.getParameter(request, "n3pty_expn_tp_cd_max", ""));
		setVvdCdCnt(JSPUtil.getParameter(request, "vvd_cd_cnt", ""));
		setN3ptyExpnTpCdCnt(JSPUtil.getParameter(request, "n3pty_expn_tp_cd_cnt", ""));
		setN3ptyBilTpCdMax(JSPUtil.getParameter(request, "n3pty_bil_tp_cd_max", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchErpInterfaceCheckDataVO[]
	 */
	public SearchErpInterfaceCheckDataVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchErpInterfaceCheckDataVO[]
	 */
	public SearchErpInterfaceCheckDataVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchErpInterfaceCheckDataVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] revenueVvdCnt = (JSPUtil.getParameter(request, prefix	+ "revenue_vvd_cnt", length));
			String[] currCdMax = (JSPUtil.getParameter(request, prefix	+ "curr_cd_max", length));
			String[] currCdCnt = (JSPUtil.getParameter(request, prefix	+ "curr_cd_cnt", length));
			String[] csrNoCnt = (JSPUtil.getParameter(request, prefix	+ "csr_no_cnt", length));
			String[] trdPartyCodeMax = (JSPUtil.getParameter(request, prefix	+ "trd_party_code_max", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trdPartyCodeCnt = (JSPUtil.getParameter(request, prefix	+ "trd_party_code_cnt", length));
			String[] n3ptyBilTpCdCnt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd_cnt", length));
			String[] glMonthMax = (JSPUtil.getParameter(request, prefix	+ "gl_month_max", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] csrNoMax = (JSPUtil.getParameter(request, prefix	+ "csr_no_max", length));
			String[] vvdCdMax = (JSPUtil.getParameter(request, prefix	+ "vvd_cd_max", length));
			String[] revenueVvdMax = (JSPUtil.getParameter(request, prefix	+ "revenue_vvd_max", length));
			String[] glMonthCnt = (JSPUtil.getParameter(request, prefix	+ "gl_month_cnt", length));
			String[] n3ptyExpnTpCdMax = (JSPUtil.getParameter(request, prefix	+ "n3pty_expn_tp_cd_max", length));
			String[] vvdCdCnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cd_cnt", length));
			String[] n3ptyExpnTpCdCnt = (JSPUtil.getParameter(request, prefix	+ "n3pty_expn_tp_cd_cnt", length));
			String[] n3ptyBilTpCdMax = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd_max", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchErpInterfaceCheckDataVO();
				if (revenueVvdCnt[i] != null)
					model.setRevenueVvdCnt(revenueVvdCnt[i]);
				if (currCdMax[i] != null)
					model.setCurrCdMax(currCdMax[i]);
				if (currCdCnt[i] != null)
					model.setCurrCdCnt(currCdCnt[i]);
				if (csrNoCnt[i] != null)
					model.setCsrNoCnt(csrNoCnt[i]);
				if (trdPartyCodeMax[i] != null)
					model.setTrdPartyCodeMax(trdPartyCodeMax[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trdPartyCodeCnt[i] != null)
					model.setTrdPartyCodeCnt(trdPartyCodeCnt[i]);
				if (n3ptyBilTpCdCnt[i] != null)
					model.setN3ptyBilTpCdCnt(n3ptyBilTpCdCnt[i]);
				if (glMonthMax[i] != null)
					model.setGlMonthMax(glMonthMax[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (csrNoMax[i] != null)
					model.setCsrNoMax(csrNoMax[i]);
				if (vvdCdMax[i] != null)
					model.setVvdCdMax(vvdCdMax[i]);
				if (revenueVvdMax[i] != null)
					model.setRevenueVvdMax(revenueVvdMax[i]);
				if (glMonthCnt[i] != null)
					model.setGlMonthCnt(glMonthCnt[i]);
				if (n3ptyExpnTpCdMax[i] != null)
					model.setN3ptyExpnTpCdMax(n3ptyExpnTpCdMax[i]);
				if (vvdCdCnt[i] != null)
					model.setVvdCdCnt(vvdCdCnt[i]);
				if (n3ptyExpnTpCdCnt[i] != null)
					model.setN3ptyExpnTpCdCnt(n3ptyExpnTpCdCnt[i]);
				if (n3ptyBilTpCdMax[i] != null)
					model.setN3ptyBilTpCdMax(n3ptyBilTpCdMax[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchErpInterfaceCheckDataVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchErpInterfaceCheckDataVO[]
	 */
	public SearchErpInterfaceCheckDataVO[] getSearchErpInterfaceCheckDataVOs(){
		SearchErpInterfaceCheckDataVO[] vos = (SearchErpInterfaceCheckDataVO[])models.toArray(new SearchErpInterfaceCheckDataVO[models.size()]);
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
		this.revenueVvdCnt = this.revenueVvdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCdMax = this.currCdMax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCdCnt = this.currCdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNoCnt = this.csrNoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyCodeMax = this.trdPartyCodeMax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyCodeCnt = this.trdPartyCodeCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCdCnt = this.n3ptyBilTpCdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glMonthMax = this.glMonthMax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNoMax = this.csrNoMax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCdMax = this.vvdCdMax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revenueVvdMax = this.revenueVvdMax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glMonthCnt = this.glMonthCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyExpnTpCdMax = this.n3ptyExpnTpCdMax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCdCnt = this.vvdCdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyExpnTpCdCnt = this.n3ptyExpnTpCdCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCdMax = this.n3ptyBilTpCdMax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
