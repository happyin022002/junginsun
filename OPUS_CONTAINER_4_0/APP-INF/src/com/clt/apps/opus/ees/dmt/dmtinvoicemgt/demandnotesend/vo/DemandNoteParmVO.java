/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DemandNoteParmVO.java
*@FileTitle : DemandNoteParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.12.10 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DemandNoteParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DemandNoteParmVO> models = new ArrayList<DemandNoteParmVO>();
	
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String sGroupBy = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String sCntrNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dmdtChgStsCds = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sDmdtTrfCd = null;
	/* Column Info */
	private String sBlNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sScNo = null;
	/* Column Info */
	private String sCustCd = null;
	/* Column Info */
	private String sChgType = null;
	/* Column Info */
	private String sRfaNo = null;
	/* Column Info */
	private String sInvoiceNo = null;
	/* Column Info */
	private String usrCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DemandNoteParmVO() {}

	public DemandNoteParmVO(String ibflag, String pagerows, String sBkgNo, String sGroupBy, String sChgType, String sOfcCd, String ofcCd, String sDmdtTrfCd, String dmdtChgStsCds, String sCntrNo, String sScNo, String sRfaNo, String sBlNo, String sCustCd, String sInvoiceNo, String usrCntCd) {
		this.sBkgNo = sBkgNo;
		this.sGroupBy = sGroupBy;
		this.sOfcCd = sOfcCd;
		this.sCntrNo = sCntrNo;
		this.pagerows = pagerows;
		this.dmdtChgStsCds = dmdtChgStsCds;
		this.ofcCd = ofcCd;
		this.sDmdtTrfCd = sDmdtTrfCd;
		this.sBlNo = sBlNo;
		this.ibflag = ibflag;
		this.sScNo = sScNo;
		this.sCustCd = sCustCd;
		this.sChgType = sChgType;
		this.sRfaNo = sRfaNo;
		this.sInvoiceNo = sInvoiceNo;
		this.usrCntCd = usrCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("s_group_by", getSGroupBy());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("s_cntr_no", getSCntrNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmdt_chg_sts_cds", getDmdtChgStsCds());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("s_dmdt_trf_cd", getSDmdtTrfCd());
		this.hashColumns.put("s_bl_no", getSBlNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_sc_no", getSScNo());
		this.hashColumns.put("s_cust_cd", getSCustCd());
		this.hashColumns.put("s_chg_type", getSChgType());
		this.hashColumns.put("s_rfa_no", getSRfaNo());
		this.hashColumns.put("s_invoice_no", getSInvoiceNo());
		this.hashColumns.put("usr_cnt_cd", getUsrCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("s_group_by", "sGroupBy");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("s_cntr_no", "sCntrNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dmdt_chg_sts_cds", "dmdtChgStsCds");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("s_dmdt_trf_cd", "sDmdtTrfCd");
		this.hashFields.put("s_bl_no", "sBlNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_sc_no", "sScNo");
		this.hashFields.put("s_cust_cd", "sCustCd");
		this.hashFields.put("s_chg_type", "sChgType");
		this.hashFields.put("s_rfa_no", "sRfaNo");
		this.hashFields.put("s_invoice_no", "sInvoiceNo");
		this.hashFields.put("usr_cnt_cd", "usrCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sBkgNo
	 */
	public String getSBkgNo() {
		return this.sBkgNo;
	}
	
	/**
	 * Column Info
	 * @return sGroupBy
	 */
	public String getSGroupBy() {
		return this.sGroupBy;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sCntrNo
	 */
	public String getSCntrNo() {
		return this.sCntrNo;
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
	 * @return dmdtChgStsCds
	 */
	public String getDmdtChgStsCds() {
		return this.dmdtChgStsCds;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return sDmdtTrfCd
	 */
	public String getSDmdtTrfCd() {
		return this.sDmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return sBlNo
	 */
	public String getSBlNo() {
		return this.sBlNo;
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
	 * @return sScNo
	 */
	public String getSScNo() {
		return this.sScNo;
	}
	
	/**
	 * Column Info
	 * @return sCustCd
	 */
	public String getSCustCd() {
		return this.sCustCd;
	}
	
	/**
	 * Column Info
	 * @return sChgType
	 */
	public String getSChgType() {
		return this.sChgType;
	}
	
	/**
	 * Column Info
	 * @return sRfaNo
	 */
	public String getSRfaNo() {
		return this.sRfaNo;
	}
	
	/**
	 * Column Info
	 * @return sInvoiceNo
	 */
	public String getSInvoiceNo() {
		return this.sInvoiceNo;
	}
	

	/**
	 * Column Info
	 * @param sBkgNo
	 */
	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}
	
	/**
	 * Column Info
	 * @param sGroupBy
	 */
	public void setSGroupBy(String sGroupBy) {
		this.sGroupBy = sGroupBy;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sCntrNo
	 */
	public void setSCntrNo(String sCntrNo) {
		this.sCntrNo = sCntrNo;
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
	 * @param dmdtChgStsCds
	 */
	public void setDmdtChgStsCds(String dmdtChgStsCds) {
		this.dmdtChgStsCds = dmdtChgStsCds;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param sDmdtTrfCd
	 */
	public void setSDmdtTrfCd(String sDmdtTrfCd) {
		this.sDmdtTrfCd = sDmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param sBlNo
	 */
	public void setSBlNo(String sBlNo) {
		this.sBlNo = sBlNo;
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
	 * @param sScNo
	 */
	public void setSScNo(String sScNo) {
		this.sScNo = sScNo;
	}
	
	/**
	 * Column Info
	 * @param sCustCd
	 */
	public void setSCustCd(String sCustCd) {
		this.sCustCd = sCustCd;
	}
	
	/**
	 * Column Info
	 * @param sChgType
	 */
	public void setSChgType(String sChgType) {
		this.sChgType = sChgType;
	}
	
	/**
	 * Column Info
	 * @param sRfaNo
	 */
	public void setSRfaNo(String sRfaNo) {
		this.sRfaNo = sRfaNo;
	}
	
	/**
	 * Column Info
	 * @param sInvoiceNo
	 */
	public void setSInvoiceNo(String sInvoiceNo) {
		this.sInvoiceNo = sInvoiceNo;
	}

	public String getUsrCntCd() {
		return usrCntCd;
	}

	public void setUsrCntCd(String usrCntCd) {
		this.usrCntCd = usrCntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSBkgNo(JSPUtil.getParameter(request, "s_bkg_no", ""));
		setSGroupBy(JSPUtil.getParameter(request, "s_group_by", ""));
		setSOfcCd(JSPUtil.getParameter(request, "s_ofc_cd", ""));
		setSCntrNo(JSPUtil.getParameter(request, "s_cntr_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDmdtChgStsCds(JSPUtil.getParameter(request, "dmdt_chg_sts_cds", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSDmdtTrfCd(JSPUtil.getParameter(request, "s_dmdt_trf_cd", ""));
		setSBlNo(JSPUtil.getParameter(request, "s_bl_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSScNo(JSPUtil.getParameter(request, "s_sc_no", ""));
		setSCustCd(JSPUtil.getParameter(request, "s_cust_cd", ""));
		setSChgType(JSPUtil.getParameter(request, "s_chg_type", ""));
		setSRfaNo(JSPUtil.getParameter(request, "s_rfa_no", ""));
		setSInvoiceNo(JSPUtil.getParameter(request, "s_invoice_no", ""));
		setUsrCntCd(JSPUtil.getParameter(request, "usr_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DemandNoteParmVO[]
	 */
	public DemandNoteParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DemandNoteParmVO[]
	 */
	public DemandNoteParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DemandNoteParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] sGroupBy = (JSPUtil.getParameter(request, prefix	+ "s_group_by", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] sCntrNo = (JSPUtil.getParameter(request, prefix	+ "s_cntr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dmdtChgStsCds = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cds", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] sDmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "s_dmdt_trf_cd", length));
			String[] sBlNo = (JSPUtil.getParameter(request, prefix	+ "s_bl_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sScNo = (JSPUtil.getParameter(request, prefix	+ "s_sc_no", length));
			String[] sCustCd = (JSPUtil.getParameter(request, prefix	+ "s_cust_cd", length));
			String[] sChgType = (JSPUtil.getParameter(request, prefix	+ "s_chg_type", length));
			String[] sRfaNo = (JSPUtil.getParameter(request, prefix	+ "s_rfa_no", length));
			String[] sInvoiceNo = (JSPUtil.getParameter(request, prefix	+ "s_invoice_no", length));
			String[] usrCntCd = (JSPUtil.getParameter(request, prefix	+ "usr_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DemandNoteParmVO();
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (sGroupBy[i] != null)
					model.setSGroupBy(sGroupBy[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (sCntrNo[i] != null)
					model.setSCntrNo(sCntrNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dmdtChgStsCds[i] != null)
					model.setDmdtChgStsCds(dmdtChgStsCds[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (sDmdtTrfCd[i] != null)
					model.setSDmdtTrfCd(sDmdtTrfCd[i]);
				if (sBlNo[i] != null)
					model.setSBlNo(sBlNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sScNo[i] != null)
					model.setSScNo(sScNo[i]);
				if (sCustCd[i] != null)
					model.setSCustCd(sCustCd[i]);
				if (sChgType[i] != null)
					model.setSChgType(sChgType[i]);
				if (sRfaNo[i] != null)
					model.setSRfaNo(sRfaNo[i]);
				if (sInvoiceNo[i] != null)
					model.setSInvoiceNo(sInvoiceNo[i]);
				if (usrCntCd[i] != null)
					model.setUsrCntCd(usrCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDemandNoteParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DemandNoteParmVO[]
	 */
	public DemandNoteParmVO[] getDemandNoteParmVOs(){
		DemandNoteParmVO[] vos = (DemandNoteParmVO[])models.toArray(new DemandNoteParmVO[models.size()]);
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
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sGroupBy = this.sGroupBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntrNo = this.sCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCds = this.dmdtChgStsCds .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDmdtTrfCd = this.sDmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBlNo = this.sBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sScNo = this.sScNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCd = this.sCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChgType = this.sChgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRfaNo = this.sRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvoiceNo = this.sInvoiceNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrCntCd = this.usrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
