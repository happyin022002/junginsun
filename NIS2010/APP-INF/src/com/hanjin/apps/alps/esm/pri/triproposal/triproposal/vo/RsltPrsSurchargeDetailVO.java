/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltPrsSurchargeDetailVO.java
*@FileTitle : RsltPrsSurchargeDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.01.07 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPrsSurchargeDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPrsSurchargeDetailVO> models = new ArrayList<RsltPrsSurchargeDetailVO>();
	
	/* Column Info */
	private String adjScgUsdAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String chgNm = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String trfScgRmk = null;
	/* Column Info */
	private String triPropNo = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String adjFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String adjScgAmt = null;
	/* Column Info */
	private String bkgRatUtCd = null;
	/* Column Info */
	private String trfScgAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPrsSurchargeDetailVO() {}

	public RsltPrsSurchargeDetailVO(String ibflag, String pagerows, String triPropNo, String amdtSeq, String chgCd, String bkgRatUtCd, String currCd, String adjScgAmt, String adjScgUsdAmt, String trfScgAmt, String trfScgRmk, String adjFlg, String chgNm) {
		this.adjScgUsdAmt = adjScgUsdAmt;
		this.currCd = currCd;
		this.chgNm = chgNm;
		this.amdtSeq = amdtSeq;
		this.trfScgRmk = trfScgRmk;
		this.triPropNo = triPropNo;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.adjFlg = adjFlg;
		this.ibflag = ibflag;
		this.adjScgAmt = adjScgAmt;
		this.bkgRatUtCd = bkgRatUtCd;
		this.trfScgAmt = trfScgAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("adj_scg_usd_amt", getAdjScgUsdAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("chg_nm", getChgNm());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("trf_scg_rmk", getTrfScgRmk());
		this.hashColumns.put("tri_prop_no", getTriPropNo());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("adj_flg", getAdjFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("adj_scg_amt", getAdjScgAmt());
		this.hashColumns.put("bkg_rat_ut_cd", getBkgRatUtCd());
		this.hashColumns.put("trf_scg_amt", getTrfScgAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("adj_scg_usd_amt", "adjScgUsdAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("chg_nm", "chgNm");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("trf_scg_rmk", "trfScgRmk");
		this.hashFields.put("tri_prop_no", "triPropNo");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("adj_flg", "adjFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("adj_scg_amt", "adjScgAmt");
		this.hashFields.put("bkg_rat_ut_cd", "bkgRatUtCd");
		this.hashFields.put("trf_scg_amt", "trfScgAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return adjScgUsdAmt
	 */
	public String getAdjScgUsdAmt() {
		return this.adjScgUsdAmt;
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
	 * @return chgNm
	 */
	public String getChgNm() {
		return this.chgNm;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return trfScgRmk
	 */
	public String getTrfScgRmk() {
		return this.trfScgRmk;
	}
	
	/**
	 * Column Info
	 * @return triPropNo
	 */
	public String getTriPropNo() {
		return this.triPropNo;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return adjFlg
	 */
	public String getAdjFlg() {
		return this.adjFlg;
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
	 * @return adjScgAmt
	 */
	public String getAdjScgAmt() {
		return this.adjScgAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgRatUtCd
	 */
	public String getBkgRatUtCd() {
		return this.bkgRatUtCd;
	}
	
	/**
	 * Column Info
	 * @return trfScgAmt
	 */
	public String getTrfScgAmt() {
		return this.trfScgAmt;
	}
	

	/**
	 * Column Info
	 * @param adjScgUsdAmt
	 */
	public void setAdjScgUsdAmt(String adjScgUsdAmt) {
		this.adjScgUsdAmt = adjScgUsdAmt;
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
	 * @param chgNm
	 */
	public void setChgNm(String chgNm) {
		this.chgNm = chgNm;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param trfScgRmk
	 */
	public void setTrfScgRmk(String trfScgRmk) {
		this.trfScgRmk = trfScgRmk;
	}
	
	/**
	 * Column Info
	 * @param triPropNo
	 */
	public void setTriPropNo(String triPropNo) {
		this.triPropNo = triPropNo;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param adjFlg
	 */
	public void setAdjFlg(String adjFlg) {
		this.adjFlg = adjFlg;
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
	 * @param adjScgAmt
	 */
	public void setAdjScgAmt(String adjScgAmt) {
		this.adjScgAmt = adjScgAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgRatUtCd
	 */
	public void setBkgRatUtCd(String bkgRatUtCd) {
		this.bkgRatUtCd = bkgRatUtCd;
	}
	
	/**
	 * Column Info
	 * @param trfScgAmt
	 */
	public void setTrfScgAmt(String trfScgAmt) {
		this.trfScgAmt = trfScgAmt;
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
		setAdjScgUsdAmt(JSPUtil.getParameter(request, prefix + "adj_scg_usd_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setChgNm(JSPUtil.getParameter(request, prefix + "chg_nm", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setTrfScgRmk(JSPUtil.getParameter(request, prefix + "trf_scg_rmk", ""));
		setTriPropNo(JSPUtil.getParameter(request, prefix + "tri_prop_no", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAdjFlg(JSPUtil.getParameter(request, prefix + "adj_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAdjScgAmt(JSPUtil.getParameter(request, prefix + "adj_scg_amt", ""));
		setBkgRatUtCd(JSPUtil.getParameter(request, prefix + "bkg_rat_ut_cd", ""));
		setTrfScgAmt(JSPUtil.getParameter(request, prefix + "trf_scg_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPrsSurchargeDetailVO[]
	 */
	public RsltPrsSurchargeDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPrsSurchargeDetailVO[]
	 */
	public RsltPrsSurchargeDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPrsSurchargeDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] adjScgUsdAmt = (JSPUtil.getParameter(request, prefix	+ "adj_scg_usd_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] chgNm = (JSPUtil.getParameter(request, prefix	+ "chg_nm", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] trfScgRmk = (JSPUtil.getParameter(request, prefix	+ "trf_scg_rmk", length));
			String[] triPropNo = (JSPUtil.getParameter(request, prefix	+ "tri_prop_no", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] adjFlg = (JSPUtil.getParameter(request, prefix	+ "adj_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] adjScgAmt = (JSPUtil.getParameter(request, prefix	+ "adj_scg_amt", length));
			String[] bkgRatUtCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rat_ut_cd", length));
			String[] trfScgAmt = (JSPUtil.getParameter(request, prefix	+ "trf_scg_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPrsSurchargeDetailVO();
				if (adjScgUsdAmt[i] != null)
					model.setAdjScgUsdAmt(adjScgUsdAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (chgNm[i] != null)
					model.setChgNm(chgNm[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (trfScgRmk[i] != null)
					model.setTrfScgRmk(trfScgRmk[i]);
				if (triPropNo[i] != null)
					model.setTriPropNo(triPropNo[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (adjFlg[i] != null)
					model.setAdjFlg(adjFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (adjScgAmt[i] != null)
					model.setAdjScgAmt(adjScgAmt[i]);
				if (bkgRatUtCd[i] != null)
					model.setBkgRatUtCd(bkgRatUtCd[i]);
				if (trfScgAmt[i] != null)
					model.setTrfScgAmt(trfScgAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPrsSurchargeDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPrsSurchargeDetailVO[]
	 */
	public RsltPrsSurchargeDetailVO[] getRsltPrsSurchargeDetailVOs(){
		RsltPrsSurchargeDetailVO[] vos = (RsltPrsSurchargeDetailVO[])models.toArray(new RsltPrsSurchargeDetailVO[models.size()]);
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
		this.adjScgUsdAmt = this.adjScgUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgNm = this.chgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfScgRmk = this.trfScgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triPropNo = this.triPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjFlg = this.adjFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjScgAmt = this.adjScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRatUtCd = this.bkgRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfScgAmt = this.trfScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
