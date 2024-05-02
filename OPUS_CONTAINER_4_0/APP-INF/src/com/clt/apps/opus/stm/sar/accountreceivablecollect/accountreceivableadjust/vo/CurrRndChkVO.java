/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CurrRndChkVO.java
*@FileTitle : CurrRndChkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CurrRndChkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CurrRndChkVO> models = new ArrayList<CurrRndChkVO>();
	
	/* Column Info */
	private String recAcctAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dtrbSrcTpCd = null;
	/* Column Info */
	private String convAdjAcctAmt = null;
	/* Column Info */
	private String currRound = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CurrRndChkVO() {}

	public CurrRndChkVO(String ibflag, String pagerows, String recAcctAmt, String convAdjAcctAmt, String currRound, String dtrbSrcTpCd) {
		this.recAcctAmt = recAcctAmt;
		this.ibflag = ibflag;
		this.dtrbSrcTpCd = dtrbSrcTpCd;
		this.convAdjAcctAmt = convAdjAcctAmt;
		this.currRound = currRound;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rec_acct_amt", getRecAcctAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dtrb_src_tp_cd", getDtrbSrcTpCd());
		this.hashColumns.put("conv_adj_acct_amt", getConvAdjAcctAmt());
		this.hashColumns.put("curr_round", getCurrRound());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rec_acct_amt", "recAcctAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dtrb_src_tp_cd", "dtrbSrcTpCd");
		this.hashFields.put("conv_adj_acct_amt", "convAdjAcctAmt");
		this.hashFields.put("curr_round", "currRound");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return recAcctAmt
	 */
	public String getRecAcctAmt() {
		return this.recAcctAmt;
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
	 * @return dtrbSrcTpCd
	 */
	public String getDtrbSrcTpCd() {
		return this.dtrbSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @return convAdjAcctAmt
	 */
	public String getConvAdjAcctAmt() {
		return this.convAdjAcctAmt;
	}
	
	/**
	 * Column Info
	 * @return currRound
	 */
	public String getCurrRound() {
		return this.currRound;
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
	 * @param recAcctAmt
	 */
	public void setRecAcctAmt(String recAcctAmt) {
		this.recAcctAmt = recAcctAmt;
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
	 * @param dtrbSrcTpCd
	 */
	public void setDtrbSrcTpCd(String dtrbSrcTpCd) {
		this.dtrbSrcTpCd = dtrbSrcTpCd;
	}
	
	/**
	 * Column Info
	 * @param convAdjAcctAmt
	 */
	public void setConvAdjAcctAmt(String convAdjAcctAmt) {
		this.convAdjAcctAmt = convAdjAcctAmt;
	}
	
	/**
	 * Column Info
	 * @param currRound
	 */
	public void setCurrRound(String currRound) {
		this.currRound = currRound;
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
		setRecAcctAmt(JSPUtil.getParameter(request, prefix + "rec_acct_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDtrbSrcTpCd(JSPUtil.getParameter(request, prefix + "dtrb_src_tp_cd", ""));
		setConvAdjAcctAmt(JSPUtil.getParameter(request, prefix + "conv_adj_acct_amt", ""));
		setCurrRound(JSPUtil.getParameter(request, prefix + "curr_round", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CurrRndChkVO[]
	 */
	public CurrRndChkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CurrRndChkVO[]
	 */
	public CurrRndChkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CurrRndChkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] recAcctAmt = (JSPUtil.getParameter(request, prefix	+ "rec_acct_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dtrbSrcTpCd = (JSPUtil.getParameter(request, prefix	+ "dtrb_src_tp_cd", length));
			String[] convAdjAcctAmt = (JSPUtil.getParameter(request, prefix	+ "conv_adj_acct_amt", length));
			String[] currRound = (JSPUtil.getParameter(request, prefix	+ "curr_round", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CurrRndChkVO();
				if (recAcctAmt[i] != null)
					model.setRecAcctAmt(recAcctAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dtrbSrcTpCd[i] != null)
					model.setDtrbSrcTpCd(dtrbSrcTpCd[i]);
				if (convAdjAcctAmt[i] != null)
					model.setConvAdjAcctAmt(convAdjAcctAmt[i]);
				if (currRound[i] != null)
					model.setCurrRound(currRound[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCurrRndChkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CurrRndChkVO[]
	 */
	public CurrRndChkVO[] getCurrRndChkVOs(){
		CurrRndChkVO[] vos = (CurrRndChkVO[])models.toArray(new CurrRndChkVO[models.size()]);
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
		this.recAcctAmt = this.recAcctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbSrcTpCd = this.dtrbSrcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convAdjAcctAmt = this.convAdjAcctAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currRound = this.currRound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
