/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OfcChgProcVO.java
*@FileTitle : OfcChgProcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo;

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

public class OfcChgProcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OfcChgProcVO> models = new ArrayList<OfcChgProcVO>();
	
	/* Column Info */
	private String ppdRcvOfcCd = null;
	/* Column Info */
	private String nfCustSeq = null;
	/* Column Info */
	private String shCustCntCd = null;
	/* Column Info */
	private String cltOfcCd = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String cnCustCntCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcChgCctProc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cnCustSeq = null;
	/* Column Info */
	private String shCustSeq = null;
	/* Column Info */
	private String caFlg = null;
	/* Column Info */
	private String custToOrdFlg = null;
	/* Column Info */
	private String ofcChgPpdProc = null;
	/* Column Info */
	private String nfCustCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OfcChgProcVO() {}

	public OfcChgProcVO(String ibflag, String pagerows, String type, String caFlg, String bkgNo, String ppdRcvOfcCd, String cltOfcCd, String custToOrdFlg, String shCustCntCd, String shCustSeq, String cnCustCntCd, String cnCustSeq, String nfCustCntCd, String nfCustSeq, String ofcChgPpdProc, String ofcChgCctProc) {
		this.ppdRcvOfcCd = ppdRcvOfcCd;
		this.nfCustSeq = nfCustSeq;
		this.shCustCntCd = shCustCntCd;
		this.cltOfcCd = cltOfcCd;
		this.type = type;
		this.cnCustCntCd = cnCustCntCd;
		this.pagerows = pagerows;
		this.ofcChgCctProc = ofcChgCctProc;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cnCustSeq = cnCustSeq;
		this.shCustSeq = shCustSeq;
		this.caFlg = caFlg;
		this.custToOrdFlg = custToOrdFlg;
		this.ofcChgPpdProc = ofcChgPpdProc;
		this.nfCustCntCd = nfCustCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ppd_rcv_ofc_cd", getPpdRcvOfcCd());
		this.hashColumns.put("nf_cust_seq", getNfCustSeq());
		this.hashColumns.put("sh_cust_cnt_cd", getShCustCntCd());
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("cn_cust_cnt_cd", getCnCustCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_chg_cct_proc", getOfcChgCctProc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cn_cust_seq", getCnCustSeq());
		this.hashColumns.put("sh_cust_seq", getShCustSeq());
		this.hashColumns.put("ca_flg", getCaFlg());
		this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());
		this.hashColumns.put("ofc_chg_ppd_proc", getOfcChgPpdProc());
		this.hashColumns.put("nf_cust_cnt_cd", getNfCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ppd_rcv_ofc_cd", "ppdRcvOfcCd");
		this.hashFields.put("nf_cust_seq", "nfCustSeq");
		this.hashFields.put("sh_cust_cnt_cd", "shCustCntCd");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("type", "type");
		this.hashFields.put("cn_cust_cnt_cd", "cnCustCntCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_chg_cct_proc", "ofcChgCctProc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cn_cust_seq", "cnCustSeq");
		this.hashFields.put("sh_cust_seq", "shCustSeq");
		this.hashFields.put("ca_flg", "caFlg");
		this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
		this.hashFields.put("ofc_chg_ppd_proc", "ofcChgPpdProc");
		this.hashFields.put("nf_cust_cnt_cd", "nfCustCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ppdRcvOfcCd
	 */
	public String getPpdRcvOfcCd() {
		return this.ppdRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @return nfCustSeq
	 */
	public String getNfCustSeq() {
		return this.nfCustSeq;
	}
	
	/**
	 * Column Info
	 * @return shCustCntCd
	 */
	public String getShCustCntCd() {
		return this.shCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return cltOfcCd
	 */
	public String getCltOfcCd() {
		return this.cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return cnCustCntCd
	 */
	public String getCnCustCntCd() {
		return this.cnCustCntCd;
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
	 * @return ofcChgCctProc
	 */
	public String getOfcChgCctProc() {
		return this.ofcChgCctProc;
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
	 * @return cnCustSeq
	 */
	public String getCnCustSeq() {
		return this.cnCustSeq;
	}
	
	/**
	 * Column Info
	 * @return shCustSeq
	 */
	public String getShCustSeq() {
		return this.shCustSeq;
	}
	
	/**
	 * Column Info
	 * @return caFlg
	 */
	public String getCaFlg() {
		return this.caFlg;
	}
	
	/**
	 * Column Info
	 * @return custToOrdFlg
	 */
	public String getCustToOrdFlg() {
		return this.custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcChgPpdProc
	 */
	public String getOfcChgPpdProc() {
		return this.ofcChgPpdProc;
	}
	
	/**
	 * Column Info
	 * @return nfCustCntCd
	 */
	public String getNfCustCntCd() {
		return this.nfCustCntCd;
	}
	

	/**
	 * Column Info
	 * @param ppdRcvOfcCd
	 */
	public void setPpdRcvOfcCd(String ppdRcvOfcCd) {
		this.ppdRcvOfcCd = ppdRcvOfcCd;
	}
	
	/**
	 * Column Info
	 * @param nfCustSeq
	 */
	public void setNfCustSeq(String nfCustSeq) {
		this.nfCustSeq = nfCustSeq;
	}
	
	/**
	 * Column Info
	 * @param shCustCntCd
	 */
	public void setShCustCntCd(String shCustCntCd) {
		this.shCustCntCd = shCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param cltOfcCd
	 */
	public void setCltOfcCd(String cltOfcCd) {
		this.cltOfcCd = cltOfcCd;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param cnCustCntCd
	 */
	public void setCnCustCntCd(String cnCustCntCd) {
		this.cnCustCntCd = cnCustCntCd;
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
	 * @param ofcChgCctProc
	 */
	public void setOfcChgCctProc(String ofcChgCctProc) {
		this.ofcChgCctProc = ofcChgCctProc;
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
	 * @param cnCustSeq
	 */
	public void setCnCustSeq(String cnCustSeq) {
		this.cnCustSeq = cnCustSeq;
	}
	
	/**
	 * Column Info
	 * @param shCustSeq
	 */
	public void setShCustSeq(String shCustSeq) {
		this.shCustSeq = shCustSeq;
	}
	
	/**
	 * Column Info
	 * @param caFlg
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}
	
	/**
	 * Column Info
	 * @param custToOrdFlg
	 */
	public void setCustToOrdFlg(String custToOrdFlg) {
		this.custToOrdFlg = custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcChgPpdProc
	 */
	public void setOfcChgPpdProc(String ofcChgPpdProc) {
		this.ofcChgPpdProc = ofcChgPpdProc;
	}
	
	/**
	 * Column Info
	 * @param nfCustCntCd
	 */
	public void setNfCustCntCd(String nfCustCntCd) {
		this.nfCustCntCd = nfCustCntCd;
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
		setPpdRcvOfcCd(JSPUtil.getParameter(request, prefix + "ppd_rcv_ofc_cd", ""));
		setNfCustSeq(JSPUtil.getParameter(request, prefix + "nf_cust_seq", ""));
		setShCustCntCd(JSPUtil.getParameter(request, prefix + "sh_cust_cnt_cd", ""));
		setCltOfcCd(JSPUtil.getParameter(request, prefix + "clt_ofc_cd", ""));
		setType(JSPUtil.getParameter(request, prefix + "type", ""));
		setCnCustCntCd(JSPUtil.getParameter(request, prefix + "cn_cust_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcChgCctProc(JSPUtil.getParameter(request, prefix + "ofc_chg_cct_proc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCnCustSeq(JSPUtil.getParameter(request, prefix + "cn_cust_seq", ""));
		setShCustSeq(JSPUtil.getParameter(request, prefix + "sh_cust_seq", ""));
		setCaFlg(JSPUtil.getParameter(request, prefix + "ca_flg", ""));
		setCustToOrdFlg(JSPUtil.getParameter(request, prefix + "cust_to_ord_flg", ""));
		setOfcChgPpdProc(JSPUtil.getParameter(request, prefix + "ofc_chg_ppd_proc", ""));
		setNfCustCntCd(JSPUtil.getParameter(request, prefix + "nf_cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfcChgProcVO[]
	 */
	public OfcChgProcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfcChgProcVO[]
	 */
	public OfcChgProcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OfcChgProcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ppdRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "ppd_rcv_ofc_cd", length));
			String[] nfCustSeq = (JSPUtil.getParameter(request, prefix	+ "nf_cust_seq", length));
			String[] shCustCntCd = (JSPUtil.getParameter(request, prefix	+ "sh_cust_cnt_cd", length));
			String[] cltOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_ofc_cd", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] cnCustCntCd = (JSPUtil.getParameter(request, prefix	+ "cn_cust_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcChgCctProc = (JSPUtil.getParameter(request, prefix	+ "ofc_chg_cct_proc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cnCustSeq = (JSPUtil.getParameter(request, prefix	+ "cn_cust_seq", length));
			String[] shCustSeq = (JSPUtil.getParameter(request, prefix	+ "sh_cust_seq", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));
			String[] custToOrdFlg = (JSPUtil.getParameter(request, prefix	+ "cust_to_ord_flg", length));
			String[] ofcChgPpdProc = (JSPUtil.getParameter(request, prefix	+ "ofc_chg_ppd_proc", length));
			String[] nfCustCntCd = (JSPUtil.getParameter(request, prefix	+ "nf_cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new OfcChgProcVO();
				if (ppdRcvOfcCd[i] != null)
					model.setPpdRcvOfcCd(ppdRcvOfcCd[i]);
				if (nfCustSeq[i] != null)
					model.setNfCustSeq(nfCustSeq[i]);
				if (shCustCntCd[i] != null)
					model.setShCustCntCd(shCustCntCd[i]);
				if (cltOfcCd[i] != null)
					model.setCltOfcCd(cltOfcCd[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (cnCustCntCd[i] != null)
					model.setCnCustCntCd(cnCustCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcChgCctProc[i] != null)
					model.setOfcChgCctProc(ofcChgCctProc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cnCustSeq[i] != null)
					model.setCnCustSeq(cnCustSeq[i]);
				if (shCustSeq[i] != null)
					model.setShCustSeq(shCustSeq[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				if (custToOrdFlg[i] != null)
					model.setCustToOrdFlg(custToOrdFlg[i]);
				if (ofcChgPpdProc[i] != null)
					model.setOfcChgPpdProc(ofcChgPpdProc[i]);
				if (nfCustCntCd[i] != null)
					model.setNfCustCntCd(nfCustCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOfcChgProcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OfcChgProcVO[]
	 */
	public OfcChgProcVO[] getOfcChgProcVOs(){
		OfcChgProcVO[] vos = (OfcChgProcVO[])models.toArray(new OfcChgProcVO[models.size()]);
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
		this.ppdRcvOfcCd = this.ppdRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustSeq = this.nfCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustCntCd = this.shCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd = this.cltOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustCntCd = this.cnCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcChgCctProc = this.ofcChgCctProc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnCustSeq = this.cnCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shCustSeq = this.shCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custToOrdFlg = this.custToOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcChgPpdProc = this.ofcChgPpdProc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nfCustCntCd = this.nfCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
