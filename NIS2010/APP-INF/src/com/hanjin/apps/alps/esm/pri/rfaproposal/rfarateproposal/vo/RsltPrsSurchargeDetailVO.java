/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPrsSurchargeDetailVO.java
*@FileTitle : RsltPrsSurchargeDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.11.25 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo;

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
	private String chgNm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String trfScgRmk = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String rtSeq = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String adjFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String routSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String adjScgAmt = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String trfScgAmt = null;
	/* Column Info */
	private String bkgRatUtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPrsSurchargeDetailVO() {}

	public RsltPrsSurchargeDetailVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String cmdtHdrSeq, String routSeq, String rtSeq, String chgCd, String bkgRatUtCd, String currCd, String adjScgAmt, String adjScgUsdAmt, String trfScgAmt, String trfScgRmk, String adjFlg, String chgNm) {
		this.adjScgUsdAmt = adjScgUsdAmt;
		this.chgNm = chgNm;
		this.currCd = currCd;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.trfScgRmk = trfScgRmk;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.rtSeq = rtSeq;
		this.chgCd = chgCd;
		this.adjFlg = adjFlg;
		this.pagerows = pagerows;
		this.routSeq = routSeq;
		this.ibflag = ibflag;
		this.adjScgAmt = adjScgAmt;
		this.propNo = propNo;
		this.trfScgAmt = trfScgAmt;
		this.bkgRatUtCd = bkgRatUtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("adj_scg_usd_amt", getAdjScgUsdAmt());
		this.hashColumns.put("chg_nm", getChgNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("trf_scg_rmk", getTrfScgRmk());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rt_seq", getRtSeq());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("adj_flg", getAdjFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("adj_scg_amt", getAdjScgAmt());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("trf_scg_amt", getTrfScgAmt());
		this.hashColumns.put("bkg_rat_ut_cd", getBkgRatUtCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("adj_scg_usd_amt", "adjScgUsdAmt");
		this.hashFields.put("chg_nm", "chgNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("trf_scg_rmk", "trfScgRmk");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rt_seq", "rtSeq");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("adj_flg", "adjFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("adj_scg_amt", "adjScgAmt");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("trf_scg_amt", "trfScgAmt");
		this.hashFields.put("bkg_rat_ut_cd", "bkgRatUtCd");
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
	 * @return chgNm
	 */
	public String getChgNm() {
		return this.chgNm;
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
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return rtSeq
	 */
	public String getRtSeq() {
		return this.rtSeq;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return adjFlg
	 */
	public String getAdjFlg() {
		return this.adjFlg;
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
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
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
	 * @return bkgRatUtCd
	 */
	public String getBkgRatUtCd() {
		return this.bkgRatUtCd;
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
	 * @param chgNm
	 */
	public void setChgNm(String chgNm) {
		this.chgNm = chgNm;
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
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param rtSeq
	 */
	public void setRtSeq(String rtSeq) {
		this.rtSeq = rtSeq;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param adjFlg
	 */
	public void setAdjFlg(String adjFlg) {
		this.adjFlg = adjFlg;
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
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param trfScgAmt
	 */
	public void setTrfScgAmt(String trfScgAmt) {
		this.trfScgAmt = trfScgAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgRatUtCd
	 */
	public void setBkgRatUtCd(String bkgRatUtCd) {
		this.bkgRatUtCd = bkgRatUtCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAdjScgUsdAmt(JSPUtil.getParameter(request, "adj_scg_usd_amt", ""));
		setChgNm(JSPUtil.getParameter(request, "chg_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setTrfScgRmk(JSPUtil.getParameter(request, "trf_scg_rmk", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setRtSeq(JSPUtil.getParameter(request, "rt_seq", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setAdjFlg(JSPUtil.getParameter(request, "adj_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAdjScgAmt(JSPUtil.getParameter(request, "adj_scg_amt", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setTrfScgAmt(JSPUtil.getParameter(request, "trf_scg_amt", ""));
		setBkgRatUtCd(JSPUtil.getParameter(request, "bkg_rat_ut_cd", ""));
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
			String[] chgNm = (JSPUtil.getParameter(request, prefix	+ "chg_nm", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] trfScgRmk = (JSPUtil.getParameter(request, prefix	+ "trf_scg_rmk", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] rtSeq = (JSPUtil.getParameter(request, prefix	+ "rt_seq", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] adjFlg = (JSPUtil.getParameter(request, prefix	+ "adj_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] adjScgAmt = (JSPUtil.getParameter(request, prefix	+ "adj_scg_amt", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] trfScgAmt = (JSPUtil.getParameter(request, prefix	+ "trf_scg_amt", length));
			String[] bkgRatUtCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rat_ut_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPrsSurchargeDetailVO();
				if (adjScgUsdAmt[i] != null)
					model.setAdjScgUsdAmt(adjScgUsdAmt[i]);
				if (chgNm[i] != null)
					model.setChgNm(chgNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (trfScgRmk[i] != null)
					model.setTrfScgRmk(trfScgRmk[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (rtSeq[i] != null)
					model.setRtSeq(rtSeq[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (adjFlg[i] != null)
					model.setAdjFlg(adjFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (adjScgAmt[i] != null)
					model.setAdjScgAmt(adjScgAmt[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (trfScgAmt[i] != null)
					model.setTrfScgAmt(trfScgAmt[i]);
				if (bkgRatUtCd[i] != null)
					model.setBkgRatUtCd(bkgRatUtCd[i]);
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
		this.chgNm = this.chgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfScgRmk = this.trfScgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtSeq = this.rtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjFlg = this.adjFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjScgAmt = this.adjScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfScgAmt = this.trfScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRatUtCd = this.bkgRatUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
