/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TaaCustInformVO.java
*@FileTitle : TaaCustInformVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.12.18 김태경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
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
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TaaCustInformVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TaaCustInformVO> models = new ArrayList<TaaCustInformVO>();
	
	/* Column Info */
	private String nCustSeq = null;
	/* Column Info */
	private String pCustNm = null;
	/* Column Info */
	private String sCustSeq = null;
	/* Column Info */
	private String sCustNm = null;
	/* Column Info */
	private String aCustCntCd = null;
	/* Column Info */
	private String cCustNm = null;
	/* Column Info */
	private String pCustSeq = null;
	/* Column Info */
	private String pCustCntCd = null;
	/* Column Info */
	private String sCustCntCd = null;
	/* Column Info */
	private String cCustSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String nCustCntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String aCustNm = null;
	/* Column Info */
	private String nCustNm = null;
	/* Column Info */
	private String cCustCntCd = null;
	/* Column Info */
	private String aCustSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TaaCustInformVO() {}

	public TaaCustInformVO(String ibflag, String pagerows, String bkgNo, String sCustCntCd, String sCustSeq, String sCustNm, String cCustCntCd, String cCustSeq, String cCustNm, String nCustCntCd, String nCustSeq, String nCustNm, String aCustCntCd, String aCustSeq, String aCustNm, String pCustCntCd, String pCustSeq, String pCustNm) {
		this.nCustSeq = nCustSeq;
		this.pCustNm = pCustNm;
		this.sCustSeq = sCustSeq;
		this.sCustNm = sCustNm;
		this.aCustCntCd = aCustCntCd;
		this.cCustNm = cCustNm;
		this.pCustSeq = pCustSeq;
		this.pCustCntCd = pCustCntCd;
		this.sCustCntCd = sCustCntCd;
		this.cCustSeq = cCustSeq;
		this.pagerows = pagerows;
		this.nCustCntCd = nCustCntCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.aCustNm = aCustNm;
		this.nCustNm = nCustNm;
		this.cCustCntCd = cCustCntCd;
		this.aCustSeq = aCustSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n_cust_seq", getNCustSeq());
		this.hashColumns.put("p_cust_nm", getPCustNm());
		this.hashColumns.put("s_cust_seq", getSCustSeq());
		this.hashColumns.put("s_cust_nm", getSCustNm());
		this.hashColumns.put("a_cust_cnt_cd", getACustCntCd());
		this.hashColumns.put("c_cust_nm", getCCustNm());
		this.hashColumns.put("p_cust_seq", getPCustSeq());
		this.hashColumns.put("p_cust_cnt_cd", getPCustCntCd());
		this.hashColumns.put("s_cust_cnt_cd", getSCustCntCd());
		this.hashColumns.put("c_cust_seq", getCCustSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n_cust_cnt_cd", getNCustCntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("a_cust_nm", getACustNm());
		this.hashColumns.put("n_cust_nm", getNCustNm());
		this.hashColumns.put("c_cust_cnt_cd", getCCustCntCd());
		this.hashColumns.put("a_cust_seq", getACustSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n_cust_seq", "nCustSeq");
		this.hashFields.put("p_cust_nm", "pCustNm");
		this.hashFields.put("s_cust_seq", "sCustSeq");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("a_cust_cnt_cd", "aCustCntCd");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("p_cust_seq", "pCustSeq");
		this.hashFields.put("p_cust_cnt_cd", "pCustCntCd");
		this.hashFields.put("s_cust_cnt_cd", "sCustCntCd");
		this.hashFields.put("c_cust_seq", "cCustSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n_cust_cnt_cd", "nCustCntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("a_cust_nm", "aCustNm");
		this.hashFields.put("n_cust_nm", "nCustNm");
		this.hashFields.put("c_cust_cnt_cd", "cCustCntCd");
		this.hashFields.put("a_cust_seq", "aCustSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return nCustSeq
	 */
	public String getNCustSeq() {
		return this.nCustSeq;
	}
	
	/**
	 * Column Info
	 * @return pCustNm
	 */
	public String getPCustNm() {
		return this.pCustNm;
	}
	
	/**
	 * Column Info
	 * @return sCustSeq
	 */
	public String getSCustSeq() {
		return this.sCustSeq;
	}
	
	/**
	 * Column Info
	 * @return sCustNm
	 */
	public String getSCustNm() {
		return this.sCustNm;
	}
	
	/**
	 * Column Info
	 * @return aCustCntCd
	 */
	public String getACustCntCd() {
		return this.aCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return cCustNm
	 */
	public String getCCustNm() {
		return this.cCustNm;
	}
	
	/**
	 * Column Info
	 * @return pCustSeq
	 */
	public String getPCustSeq() {
		return this.pCustSeq;
	}
	
	/**
	 * Column Info
	 * @return pCustCntCd
	 */
	public String getPCustCntCd() {
		return this.pCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return sCustCntCd
	 */
	public String getSCustCntCd() {
		return this.sCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return cCustSeq
	 */
	public String getCCustSeq() {
		return this.cCustSeq;
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
	 * @return nCustCntCd
	 */
	public String getNCustCntCd() {
		return this.nCustCntCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return aCustNm
	 */
	public String getACustNm() {
		return this.aCustNm;
	}
	
	/**
	 * Column Info
	 * @return nCustNm
	 */
	public String getNCustNm() {
		return this.nCustNm;
	}
	
	/**
	 * Column Info
	 * @return cCustCntCd
	 */
	public String getCCustCntCd() {
		return this.cCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return aCustSeq
	 */
	public String getACustSeq() {
		return this.aCustSeq;
	}
	

	/**
	 * Column Info
	 * @param nCustSeq
	 */
	public void setNCustSeq(String nCustSeq) {
		this.nCustSeq = nCustSeq;
	}
	
	/**
	 * Column Info
	 * @param pCustNm
	 */
	public void setPCustNm(String pCustNm) {
		this.pCustNm = pCustNm;
	}
	
	/**
	 * Column Info
	 * @param sCustSeq
	 */
	public void setSCustSeq(String sCustSeq) {
		this.sCustSeq = sCustSeq;
	}
	
	/**
	 * Column Info
	 * @param sCustNm
	 */
	public void setSCustNm(String sCustNm) {
		this.sCustNm = sCustNm;
	}
	
	/**
	 * Column Info
	 * @param aCustCntCd
	 */
	public void setACustCntCd(String aCustCntCd) {
		this.aCustCntCd = aCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param cCustNm
	 */
	public void setCCustNm(String cCustNm) {
		this.cCustNm = cCustNm;
	}
	
	/**
	 * Column Info
	 * @param pCustSeq
	 */
	public void setPCustSeq(String pCustSeq) {
		this.pCustSeq = pCustSeq;
	}
	
	/**
	 * Column Info
	 * @param pCustCntCd
	 */
	public void setPCustCntCd(String pCustCntCd) {
		this.pCustCntCd = pCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param sCustCntCd
	 */
	public void setSCustCntCd(String sCustCntCd) {
		this.sCustCntCd = sCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param cCustSeq
	 */
	public void setCCustSeq(String cCustSeq) {
		this.cCustSeq = cCustSeq;
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
	 * @param nCustCntCd
	 */
	public void setNCustCntCd(String nCustCntCd) {
		this.nCustCntCd = nCustCntCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param aCustNm
	 */
	public void setACustNm(String aCustNm) {
		this.aCustNm = aCustNm;
	}
	
	/**
	 * Column Info
	 * @param nCustNm
	 */
	public void setNCustNm(String nCustNm) {
		this.nCustNm = nCustNm;
	}
	
	/**
	 * Column Info
	 * @param cCustCntCd
	 */
	public void setCCustCntCd(String cCustCntCd) {
		this.cCustCntCd = cCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param aCustSeq
	 */
	public void setACustSeq(String aCustSeq) {
		this.aCustSeq = aCustSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNCustSeq(JSPUtil.getParameter(request, "n_cust_seq", ""));
		setPCustNm(JSPUtil.getParameter(request, "p_cust_nm", ""));
		setSCustSeq(JSPUtil.getParameter(request, "s_cust_seq", ""));
		setSCustNm(JSPUtil.getParameter(request, "s_cust_nm", ""));
		setACustCntCd(JSPUtil.getParameter(request, "a_cust_cnt_cd", ""));
		setCCustNm(JSPUtil.getParameter(request, "c_cust_nm", ""));
		setPCustSeq(JSPUtil.getParameter(request, "p_cust_seq", ""));
		setPCustCntCd(JSPUtil.getParameter(request, "p_cust_cnt_cd", ""));
		setSCustCntCd(JSPUtil.getParameter(request, "s_cust_cnt_cd", ""));
		setCCustSeq(JSPUtil.getParameter(request, "c_cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setNCustCntCd(JSPUtil.getParameter(request, "n_cust_cnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setACustNm(JSPUtil.getParameter(request, "a_cust_nm", ""));
		setNCustNm(JSPUtil.getParameter(request, "n_cust_nm", ""));
		setCCustCntCd(JSPUtil.getParameter(request, "c_cust_cnt_cd", ""));
		setACustSeq(JSPUtil.getParameter(request, "a_cust_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TaaCustInformVO[]
	 */
	public TaaCustInformVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TaaCustInformVO[]
	 */
	public TaaCustInformVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TaaCustInformVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] nCustSeq = (JSPUtil.getParameter(request, prefix	+ "n_cust_seq", length));
			String[] pCustNm = (JSPUtil.getParameter(request, prefix	+ "p_cust_nm", length));
			String[] sCustSeq = (JSPUtil.getParameter(request, prefix	+ "s_cust_seq", length));
			String[] sCustNm = (JSPUtil.getParameter(request, prefix	+ "s_cust_nm", length));
			String[] aCustCntCd = (JSPUtil.getParameter(request, prefix	+ "a_cust_cnt_cd", length));
			String[] cCustNm = (JSPUtil.getParameter(request, prefix	+ "c_cust_nm", length));
			String[] pCustSeq = (JSPUtil.getParameter(request, prefix	+ "p_cust_seq", length));
			String[] pCustCntCd = (JSPUtil.getParameter(request, prefix	+ "p_cust_cnt_cd", length));
			String[] sCustCntCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cnt_cd", length));
			String[] cCustSeq = (JSPUtil.getParameter(request, prefix	+ "c_cust_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] nCustCntCd = (JSPUtil.getParameter(request, prefix	+ "n_cust_cnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] aCustNm = (JSPUtil.getParameter(request, prefix	+ "a_cust_nm", length));
			String[] nCustNm = (JSPUtil.getParameter(request, prefix	+ "n_cust_nm", length));
			String[] cCustCntCd = (JSPUtil.getParameter(request, prefix	+ "c_cust_cnt_cd", length));
			String[] aCustSeq = (JSPUtil.getParameter(request, prefix	+ "a_cust_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new TaaCustInformVO();
				if (nCustSeq[i] != null)
					model.setNCustSeq(nCustSeq[i]);
				if (pCustNm[i] != null)
					model.setPCustNm(pCustNm[i]);
				if (sCustSeq[i] != null)
					model.setSCustSeq(sCustSeq[i]);
				if (sCustNm[i] != null)
					model.setSCustNm(sCustNm[i]);
				if (aCustCntCd[i] != null)
					model.setACustCntCd(aCustCntCd[i]);
				if (cCustNm[i] != null)
					model.setCCustNm(cCustNm[i]);
				if (pCustSeq[i] != null)
					model.setPCustSeq(pCustSeq[i]);
				if (pCustCntCd[i] != null)
					model.setPCustCntCd(pCustCntCd[i]);
				if (sCustCntCd[i] != null)
					model.setSCustCntCd(sCustCntCd[i]);
				if (cCustSeq[i] != null)
					model.setCCustSeq(cCustSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (nCustCntCd[i] != null)
					model.setNCustCntCd(nCustCntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (aCustNm[i] != null)
					model.setACustNm(aCustNm[i]);
				if (nCustNm[i] != null)
					model.setNCustNm(nCustNm[i]);
				if (cCustCntCd[i] != null)
					model.setCCustCntCd(cCustCntCd[i]);
				if (aCustSeq[i] != null)
					model.setACustSeq(aCustSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTaaCustInformVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TaaCustInformVO[]
	 */
	public TaaCustInformVO[] getTaaCustInformVOs(){
		TaaCustInformVO[] vos = (TaaCustInformVO[])models.toArray(new TaaCustInformVO[models.size()]);
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
		this.nCustSeq = this.nCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCustNm = this.pCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustSeq = this.sCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm = this.sCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCustCntCd = this.aCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm = this.cCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCustSeq = this.pCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCustCntCd = this.pCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCntCd = this.sCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustSeq = this.cCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustCntCd = this.nCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCustNm = this.aCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nCustNm = this.nCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustCntCd = this.cCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aCustSeq = this.aCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
