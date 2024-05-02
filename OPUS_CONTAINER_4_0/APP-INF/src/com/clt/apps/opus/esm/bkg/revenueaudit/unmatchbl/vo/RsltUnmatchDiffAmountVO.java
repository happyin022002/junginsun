/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltUnmatchDiffAmountVO.java
*@FileTitle : RsltUnmatchDiffAmountVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.08 김대호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo;

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
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltUnmatchDiffAmountVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltUnmatchDiffAmountVO> models = new ArrayList<RsltUnmatchDiffAmountVO>();
	
	/* Column Info */
	private String umchBkgSeq = null;
	/* Column Info */
	private String amtB = null;
	/* Column Info */
	private String amtC = null;
	/* Column Info */
	private String amtD = null;
	/* Column Info */
	private String currCdD = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String currCdC = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chgCdB = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String currCdB = null;
	/* Column Info */
	private String usRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltUnmatchDiffAmountVO() {}

	public RsltUnmatchDiffAmountVO(String ibflag, String pagerows, String code, String currCdC, String amtC, String chgCdB, String currCdB, String amtB, String currCdD, String amtD, String usRt, String usdAmt, String bkgNo, String umchBkgSeq) {
		this.umchBkgSeq = umchBkgSeq;
		this.amtB = amtB;
		this.amtC = amtC;
		this.amtD = amtD;
		this.currCdD = currCdD;
		this.code = code;
		this.currCdC = currCdC;
		this.pagerows = pagerows;
		this.chgCdB = chgCdB;
		this.ibflag = ibflag;
		this.usdAmt = usdAmt;
		this.bkgNo = bkgNo;
		this.currCdB = currCdB;
		this.usRt = usRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("umch_bkg_seq", getUmchBkgSeq());
		this.hashColumns.put("amt_b", getAmtB());
		this.hashColumns.put("amt_c", getAmtC());
		this.hashColumns.put("amt_d", getAmtD());
		this.hashColumns.put("curr_cd_d", getCurrCdD());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("curr_cd_c", getCurrCdC());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chg_cd_b", getChgCdB());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("curr_cd_b", getCurrCdB());
		this.hashColumns.put("us_rt", getUsRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("umch_bkg_seq", "umchBkgSeq");
		this.hashFields.put("amt_b", "amtB");
		this.hashFields.put("amt_c", "amtC");
		this.hashFields.put("amt_d", "amtD");
		this.hashFields.put("curr_cd_d", "currCdD");
		this.hashFields.put("code", "code");
		this.hashFields.put("curr_cd_c", "currCdC");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chg_cd_b", "chgCdB");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("curr_cd_b", "currCdB");
		this.hashFields.put("us_rt", "usRt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return umchBkgSeq
	 */
	public String getUmchBkgSeq() {
		return this.umchBkgSeq;
	}
	
	/**
	 * Column Info
	 * @return amtB
	 */
	public String getAmtB() {
		return this.amtB;
	}
	
	/**
	 * Column Info
	 * @return amtC
	 */
	public String getAmtC() {
		return this.amtC;
	}
	
	/**
	 * Column Info
	 * @return amtD
	 */
	public String getAmtD() {
		return this.amtD;
	}
	
	/**
	 * Column Info
	 * @return currCdD
	 */
	public String getCurrCdD() {
		return this.currCdD;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Column Info
	 * @return currCdC
	 */
	public String getCurrCdC() {
		return this.currCdC;
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
	 * @return chgCdB
	 */
	public String getChgCdB() {
		return this.chgCdB;
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
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return currCdB
	 */
	public String getCurrCdB() {
		return this.currCdB;
	}
	
	/**
	 * Column Info
	 * @return usRt
	 */
	public String getUsRt() {
		return this.usRt;
	}
	

	/**
	 * Column Info
	 * @param umchBkgSeq
	 */
	public void setUmchBkgSeq(String umchBkgSeq) {
		this.umchBkgSeq = umchBkgSeq;
	}
	
	/**
	 * Column Info
	 * @param amtB
	 */
	public void setAmtB(String amtB) {
		this.amtB = amtB;
	}
	
	/**
	 * Column Info
	 * @param amtC
	 */
	public void setAmtC(String amtC) {
		this.amtC = amtC;
	}
	
	/**
	 * Column Info
	 * @param amtD
	 */
	public void setAmtD(String amtD) {
		this.amtD = amtD;
	}
	
	/**
	 * Column Info
	 * @param currCdD
	 */
	public void setCurrCdD(String currCdD) {
		this.currCdD = currCdD;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Column Info
	 * @param currCdC
	 */
	public void setCurrCdC(String currCdC) {
		this.currCdC = currCdC;
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
	 * @param chgCdB
	 */
	public void setChgCdB(String chgCdB) {
		this.chgCdB = chgCdB;
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
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param currCdB
	 */
	public void setCurrCdB(String currCdB) {
		this.currCdB = currCdB;
	}
	
	/**
	 * Column Info
	 * @param usRt
	 */
	public void setUsRt(String usRt) {
		this.usRt = usRt;
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
		setUmchBkgSeq(JSPUtil.getParameter(request, prefix + "umch_bkg_seq", ""));
		setAmtB(JSPUtil.getParameter(request, prefix + "amt_b", ""));
		setAmtC(JSPUtil.getParameter(request, prefix + "amt_c", ""));
		setAmtD(JSPUtil.getParameter(request, prefix + "amt_d", ""));
		setCurrCdD(JSPUtil.getParameter(request, prefix + "curr_cd_d", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setCurrCdC(JSPUtil.getParameter(request, prefix + "curr_cd_c", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setChgCdB(JSPUtil.getParameter(request, prefix + "chg_cd_b", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCurrCdB(JSPUtil.getParameter(request, prefix + "curr_cd_b", ""));
		setUsRt(JSPUtil.getParameter(request, prefix + "us_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltUnmatchDiffAmountVO[]
	 */
	public RsltUnmatchDiffAmountVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltUnmatchDiffAmountVO[]
	 */
	public RsltUnmatchDiffAmountVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltUnmatchDiffAmountVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] umchBkgSeq = (JSPUtil.getParameter(request, prefix	+ "umch_bkg_seq", length));
			String[] amtB = (JSPUtil.getParameter(request, prefix	+ "amt_b", length));
			String[] amtC = (JSPUtil.getParameter(request, prefix	+ "amt_c", length));
			String[] amtD = (JSPUtil.getParameter(request, prefix	+ "amt_d", length));
			String[] currCdD = (JSPUtil.getParameter(request, prefix	+ "curr_cd_d", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] currCdC = (JSPUtil.getParameter(request, prefix	+ "curr_cd_c", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chgCdB = (JSPUtil.getParameter(request, prefix	+ "chg_cd_b", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] currCdB = (JSPUtil.getParameter(request, prefix	+ "curr_cd_b", length));
			String[] usRt = (JSPUtil.getParameter(request, prefix	+ "us_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltUnmatchDiffAmountVO();
				if (umchBkgSeq[i] != null)
					model.setUmchBkgSeq(umchBkgSeq[i]);
				if (amtB[i] != null)
					model.setAmtB(amtB[i]);
				if (amtC[i] != null)
					model.setAmtC(amtC[i]);
				if (amtD[i] != null)
					model.setAmtD(amtD[i]);
				if (currCdD[i] != null)
					model.setCurrCdD(currCdD[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (currCdC[i] != null)
					model.setCurrCdC(currCdC[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chgCdB[i] != null)
					model.setChgCdB(chgCdB[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (currCdB[i] != null)
					model.setCurrCdB(currCdB[i]);
				if (usRt[i] != null)
					model.setUsRt(usRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltUnmatchDiffAmountVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltUnmatchDiffAmountVO[]
	 */
	public RsltUnmatchDiffAmountVO[] getRsltUnmatchDiffAmountVOs(){
		RsltUnmatchDiffAmountVO[] vos = (RsltUnmatchDiffAmountVO[])models.toArray(new RsltUnmatchDiffAmountVO[models.size()]);
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
		this.umchBkgSeq = this.umchBkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtB = this.amtB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtC = this.amtC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtD = this.amtD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCdD = this.currCdD .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCdC = this.currCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCdB = this.chgCdB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCdB = this.currCdB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usRt = this.usRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
