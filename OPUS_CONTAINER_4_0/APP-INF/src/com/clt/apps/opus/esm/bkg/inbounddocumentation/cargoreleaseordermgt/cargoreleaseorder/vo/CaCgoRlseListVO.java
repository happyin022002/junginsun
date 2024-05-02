/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CaCgoRlseListVO.java
*@FileTitle : CaCgoRlseListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.10.08 김태경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 박성호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CaCgoRlseListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CaCgoRlseListVO> models = new ArrayList<CaCgoRlseListVO>();
	
	/* Column Info */
	private String lastUpDt = null;
	/* Column Info */
	private String prtInd = null;
	/* Column Info */
	private String cstmsClrCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String oLastDt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String oblRdemFlg = null;
	/* Column Info */
	private String cLastDt = null;
	/* Column Info */
	private String hubCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String doHldFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String tmlSnd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String pcsQty = null;
	/* Column Info */
	private String fLastDt = null;
	/* Column Info */
	private String oblTtlKnt = null;
	/* Column Info */
	private String tmlLastDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CaCgoRlseListVO() {}

	public CaCgoRlseListVO(String ibflag, String pagerows, String blNo, String bkgNo, String pcsQty, String vvdCd, String podCd, String delCd, String hubCd, String lastUpDt, String frtCltFlg, String fLastDt, String oblRdemFlg, String oLastDt, String cstmsClrCd, String cLastDt, String tmlSnd, String tmlLastDt, String prtInd, String custNm, String interRmk, String doHldFlg, String oblTtlKnt) {
		this.lastUpDt = lastUpDt;
		this.prtInd = prtInd;
		this.cstmsClrCd = cstmsClrCd;
		this.custNm = custNm;
		this.oLastDt = oLastDt;
		this.delCd = delCd;
		this.oblRdemFlg = oblRdemFlg;
		this.cLastDt = cLastDt;
		this.hubCd = hubCd;
		this.blNo = blNo;
		this.doHldFlg = doHldFlg;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.tmlSnd = tmlSnd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.frtCltFlg = frtCltFlg;
		this.interRmk = interRmk;
		this.vvdCd = vvdCd;
		this.pcsQty = pcsQty;
		this.fLastDt = fLastDt;
		this.oblTtlKnt = oblTtlKnt;
		this.tmlLastDt = tmlLastDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("last_up_dt", getLastUpDt());
		this.hashColumns.put("prt_ind", getPrtInd());
		this.hashColumns.put("cstms_clr_cd", getCstmsClrCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("o_last_dt", getOLastDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());
		this.hashColumns.put("c_last_dt", getCLastDt());
		this.hashColumns.put("hub_cd", getHubCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("do_hld_flg", getDoHldFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("tml_snd", getTmlSnd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("pcs_qty", getPcsQty());
		this.hashColumns.put("f_last_dt", getFLastDt());
		this.hashColumns.put("obl_ttl_knt", getOblTtlKnt());
		this.hashColumns.put("tml_last_dt", getTmlLastDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("last_up_dt", "lastUpDt");
		this.hashFields.put("prt_ind", "prtInd");
		this.hashFields.put("cstms_clr_cd", "cstmsClrCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("o_last_dt", "oLastDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("c_last_dt", "cLastDt");
		this.hashFields.put("hub_cd", "hubCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("do_hld_flg", "doHldFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("tml_snd", "tmlSnd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pcs_qty", "pcsQty");
		this.hashFields.put("f_last_dt", "fLastDt");
		this.hashFields.put("obl_ttl_knt", "oblTtlKnt");
		this.hashFields.put("tml_last_dt", "tmlLastDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lastUpDt
	 */
	public String getLastUpDt() {
		return this.lastUpDt;
	}
	
	/**
	 * Column Info
	 * @return prtInd
	 */
	public String getPrtInd() {
		return this.prtInd;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrCd
	 */
	public String getCstmsClrCd() {
		return this.cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return oLastDt
	 */
	public String getOLastDt() {
		return this.oLastDt;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return oblRdemFlg
	 */
	public String getOblRdemFlg() {
		return this.oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @return cLastDt
	 */
	public String getCLastDt() {
		return this.cLastDt;
	}
	
	/**
	 * Column Info
	 * @return hubCd
	 */
	public String getHubCd() {
		return this.hubCd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return doHldFlg
	 */
	public String getDoHldFlg() {
		return this.doHldFlg;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return tmlSnd
	 */
	public String getTmlSnd() {
		return this.tmlSnd;
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
	 * @return frtCltFlg
	 */
	public String getFrtCltFlg() {
		return this.frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return pcsQty
	 */
	public String getPcsQty() {
		return this.pcsQty;
	}
	
	/**
	 * Column Info
	 * @return fLastDt
	 */
	public String getFLastDt() {
		return this.fLastDt;
	}
	
	/**
	 * Column Info
	 * @return oblTtlKnt
	 */
	public String getOblTtlKnt() {
		return this.oblTtlKnt;
	}
	
	/**
	 * Column Info
	 * @return tmlLastDt
	 */
	public String getTmlLastDt() {
		return this.tmlLastDt;
	}
	

	/**
	 * Column Info
	 * @param lastUpDt
	 */
	public void setLastUpDt(String lastUpDt) {
		this.lastUpDt = lastUpDt;
	}
	
	/**
	 * Column Info
	 * @param prtInd
	 */
	public void setPrtInd(String prtInd) {
		this.prtInd = prtInd;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrCd
	 */
	public void setCstmsClrCd(String cstmsClrCd) {
		this.cstmsClrCd = cstmsClrCd;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param oLastDt
	 */
	public void setOLastDt(String oLastDt) {
		this.oLastDt = oLastDt;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param oblRdemFlg
	 */
	public void setOblRdemFlg(String oblRdemFlg) {
		this.oblRdemFlg = oblRdemFlg;
	}
	
	/**
	 * Column Info
	 * @param cLastDt
	 */
	public void setCLastDt(String cLastDt) {
		this.cLastDt = cLastDt;
	}
	
	/**
	 * Column Info
	 * @param hubCd
	 */
	public void setHubCd(String hubCd) {
		this.hubCd = hubCd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param doHldFlg
	 */
	public void setDoHldFlg(String doHldFlg) {
		this.doHldFlg = doHldFlg;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param tmlSnd
	 */
	public void setTmlSnd(String tmlSnd) {
		this.tmlSnd = tmlSnd;
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
	 * @param frtCltFlg
	 */
	public void setFrtCltFlg(String frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param pcsQty
	 */
	public void setPcsQty(String pcsQty) {
		this.pcsQty = pcsQty;
	}
	
	/**
	 * Column Info
	 * @param fLastDt
	 */
	public void setFLastDt(String fLastDt) {
		this.fLastDt = fLastDt;
	}
	
	/**
	 * Column Info
	 * @param oblTtlKnt
	 */
	public void setOblTtlKnt(String oblTtlKnt) {
		this.oblTtlKnt = oblTtlKnt;
	}
	
	/**
	 * Column Info
	 * @param tmlLastDt
	 */
	public void setTmlLastDt(String tmlLastDt) {
		this.tmlLastDt = tmlLastDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLastUpDt(JSPUtil.getParameter(request, "last_up_dt", ""));
		setPrtInd(JSPUtil.getParameter(request, "prt_ind", ""));
		setCstmsClrCd(JSPUtil.getParameter(request, "cstms_clr_cd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setOLastDt(JSPUtil.getParameter(request, "o_last_dt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setOblRdemFlg(JSPUtil.getParameter(request, "obl_rdem_flg", ""));
		setCLastDt(JSPUtil.getParameter(request, "c_last_dt", ""));
		setHubCd(JSPUtil.getParameter(request, "hub_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setDoHldFlg(JSPUtil.getParameter(request, "do_hld_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setTmlSnd(JSPUtil.getParameter(request, "tml_snd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, "frt_clt_flg", ""));
		setInterRmk(JSPUtil.getParameter(request, "inter_rmk", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setPcsQty(JSPUtil.getParameter(request, "pcs_qty", ""));
		setFLastDt(JSPUtil.getParameter(request, "f_last_dt", ""));
		setOblTtlKnt(JSPUtil.getParameter(request, "obl_ttl_knt", ""));
		setTmlLastDt(JSPUtil.getParameter(request, "tml_last_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CaCgoRlseListVO[]
	 */
	public CaCgoRlseListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CaCgoRlseListVO[]
	 */
	public CaCgoRlseListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CaCgoRlseListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lastUpDt = (JSPUtil.getParameter(request, prefix	+ "last_up_dt", length));
			String[] prtInd = (JSPUtil.getParameter(request, prefix	+ "prt_ind", length));
			String[] cstmsClrCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] oLastDt = (JSPUtil.getParameter(request, prefix	+ "o_last_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] oblRdemFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rdem_flg", length));
			String[] cLastDt = (JSPUtil.getParameter(request, prefix	+ "c_last_dt", length));
			String[] hubCd = (JSPUtil.getParameter(request, prefix	+ "hub_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] doHldFlg = (JSPUtil.getParameter(request, prefix	+ "do_hld_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] tmlSnd = (JSPUtil.getParameter(request, prefix	+ "tml_snd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] pcsQty = (JSPUtil.getParameter(request, prefix	+ "pcs_qty", length));
			String[] fLastDt = (JSPUtil.getParameter(request, prefix	+ "f_last_dt", length));
			String[] oblTtlKnt = (JSPUtil.getParameter(request, prefix	+ "obl_ttl_knt", length));
			String[] tmlLastDt = (JSPUtil.getParameter(request, prefix	+ "tml_last_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CaCgoRlseListVO();
				if (lastUpDt[i] != null)
					model.setLastUpDt(lastUpDt[i]);
				if (prtInd[i] != null)
					model.setPrtInd(prtInd[i]);
				if (cstmsClrCd[i] != null)
					model.setCstmsClrCd(cstmsClrCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (oLastDt[i] != null)
					model.setOLastDt(oLastDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (oblRdemFlg[i] != null)
					model.setOblRdemFlg(oblRdemFlg[i]);
				if (cLastDt[i] != null)
					model.setCLastDt(cLastDt[i]);
				if (hubCd[i] != null)
					model.setHubCd(hubCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (doHldFlg[i] != null)
					model.setDoHldFlg(doHldFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (tmlSnd[i] != null)
					model.setTmlSnd(tmlSnd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (pcsQty[i] != null)
					model.setPcsQty(pcsQty[i]);
				if (fLastDt[i] != null)
					model.setFLastDt(fLastDt[i]);
				if (oblTtlKnt[i] != null)
					model.setOblTtlKnt(oblTtlKnt[i]);
				if (tmlLastDt[i] != null)
					model.setTmlLastDt(tmlLastDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCaCgoRlseListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CaCgoRlseListVO[]
	 */
	public CaCgoRlseListVO[] getCaCgoRlseListVOs(){
		CaCgoRlseListVO[] vos = (CaCgoRlseListVO[])models.toArray(new CaCgoRlseListVO[models.size()]);
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
		this.lastUpDt = this.lastUpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtInd = this.prtInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrCd = this.cstmsClrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oLastDt = this.oLastDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg = this.oblRdemFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cLastDt = this.cLastDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hubCd = this.hubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doHldFlg = this.doHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSnd = this.tmlSnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcsQty = this.pcsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fLastDt = this.fLastDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblTtlKnt = this.oblTtlKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlLastDt = this.tmlLastDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
