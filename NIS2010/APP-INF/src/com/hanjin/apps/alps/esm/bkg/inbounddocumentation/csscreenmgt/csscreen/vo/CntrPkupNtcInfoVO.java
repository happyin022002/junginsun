/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrPkupNtcInfoVO.java
*@FileTitle : CntrPkupNtcInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrPkupNtcInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrPkupNtcInfoVO> models = new ArrayList<CntrPkupNtcInfoVO>();
	
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String pkupRmk = null;
	/* Column Info */
	private String pkupEvntDt = null;
	/* Column Info */
	private String freeDt = null;
	/* Column Info */
	private String pkupUpdDt = null;
	/* Column Info */
	private String tpszCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String pkupYd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String avalDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String ntcTp = null;
	/* Column Info */
	private String spc = null;
	/* Column Info */
	private String pkupNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrPkupNtcInfoVO() {}

	public CntrPkupNtcInfoVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String tpszCd, String pkupNo, String pkupYd, String avalDt, String freeDt, String ntcTp, String pkupEvntDt, String cntrWgt, String wgtUtCd, String pckQty, String pckTpCd, String spc, String pkupUpdDt, String ofcCd, String usrNm, String pkupRmk) {
		this.cntrWgt = cntrWgt;
		this.pkupRmk = pkupRmk;
		this.pkupEvntDt = pkupEvntDt;
		this.freeDt = freeDt;
		this.pkupUpdDt = pkupUpdDt;
		this.tpszCd = tpszCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.pkupYd = pkupYd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.usrNm = usrNm;
		this.avalDt = avalDt;
		this.cntrNo = cntrNo;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.ntcTp = ntcTp;
		this.spc = spc;
		this.pkupNo = pkupNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("pkup_rmk", getPkupRmk());
		this.hashColumns.put("pkup_evnt_dt", getPkupEvntDt());
		this.hashColumns.put("free_dt", getFreeDt());
		this.hashColumns.put("pkup_upd_dt", getPkupUpdDt());
		this.hashColumns.put("tpsz_cd", getTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("pkup_yd", getPkupYd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("aval_dt", getAvalDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("ntc_tp", getNtcTp());
		this.hashColumns.put("spc", getSpc());
		this.hashColumns.put("pkup_no", getPkupNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("pkup_rmk", "pkupRmk");
		this.hashFields.put("pkup_evnt_dt", "pkupEvntDt");
		this.hashFields.put("free_dt", "freeDt");
		this.hashFields.put("pkup_upd_dt", "pkupUpdDt");
		this.hashFields.put("tpsz_cd", "tpszCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("pkup_yd", "pkupYd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("aval_dt", "avalDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("ntc_tp", "ntcTp");
		this.hashFields.put("spc", "spc");
		this.hashFields.put("pkup_no", "pkupNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return pkupRmk
	 */
	public String getPkupRmk() {
		return this.pkupRmk;
	}
	
	/**
	 * Column Info
	 * @return pkupEvntDt
	 */
	public String getPkupEvntDt() {
		return this.pkupEvntDt;
	}
	
	/**
	 * Column Info
	 * @return freeDt
	 */
	public String getFreeDt() {
		return this.freeDt;
	}
	
	/**
	 * Column Info
	 * @return pkupUpdDt
	 */
	public String getPkupUpdDt() {
		return this.pkupUpdDt;
	}
	
	/**
	 * Column Info
	 * @return tpszCd
	 */
	public String getTpszCd() {
		return this.tpszCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return pkupYd
	 */
	public String getPkupYd() {
		return this.pkupYd;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return avalDt
	 */
	public String getAvalDt() {
		return this.avalDt;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return ntcTp
	 */
	public String getNtcTp() {
		return this.ntcTp;
	}
	
	/**
	 * Column Info
	 * @return spc
	 */
	public String getSpc() {
		return this.spc;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	

	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param pkupRmk
	 */
	public void setPkupRmk(String pkupRmk) {
		this.pkupRmk = pkupRmk;
	}
	
	/**
	 * Column Info
	 * @param pkupEvntDt
	 */
	public void setPkupEvntDt(String pkupEvntDt) {
		this.pkupEvntDt = pkupEvntDt;
	}
	
	/**
	 * Column Info
	 * @param freeDt
	 */
	public void setFreeDt(String freeDt) {
		this.freeDt = freeDt;
	}
	
	/**
	 * Column Info
	 * @param pkupUpdDt
	 */
	public void setPkupUpdDt(String pkupUpdDt) {
		this.pkupUpdDt = pkupUpdDt;
	}
	
	/**
	 * Column Info
	 * @param tpszCd
	 */
	public void setTpszCd(String tpszCd) {
		this.tpszCd = tpszCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param pkupYd
	 */
	public void setPkupYd(String pkupYd) {
		this.pkupYd = pkupYd;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param avalDt
	 */
	public void setAvalDt(String avalDt) {
		this.avalDt = avalDt;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param ntcTp
	 */
	public void setNtcTp(String ntcTp) {
		this.ntcTp = ntcTp;
	}
	
	/**
	 * Column Info
	 * @param spc
	 */
	public void setSpc(String spc) {
		this.spc = spc;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setPkupRmk(JSPUtil.getParameter(request, "pkup_rmk", ""));
		setPkupEvntDt(JSPUtil.getParameter(request, "pkup_evnt_dt", ""));
		setFreeDt(JSPUtil.getParameter(request, "free_dt", ""));
		setPkupUpdDt(JSPUtil.getParameter(request, "pkup_upd_dt", ""));
		setTpszCd(JSPUtil.getParameter(request, "tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setPkupYd(JSPUtil.getParameter(request, "pkup_yd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setAvalDt(JSPUtil.getParameter(request, "aval_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setNtcTp(JSPUtil.getParameter(request, "ntc_tp", ""));
		setSpc(JSPUtil.getParameter(request, "spc", ""));
		setPkupNo(JSPUtil.getParameter(request, "pkup_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrPkupNtcInfoVO[]
	 */
	public CntrPkupNtcInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrPkupNtcInfoVO[]
	 */
	public CntrPkupNtcInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrPkupNtcInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] pkupRmk = (JSPUtil.getParameter(request, prefix	+ "pkup_rmk", length));
			String[] pkupEvntDt = (JSPUtil.getParameter(request, prefix	+ "pkup_evnt_dt", length));
			String[] freeDt = (JSPUtil.getParameter(request, prefix	+ "free_dt", length));
			String[] pkupUpdDt = (JSPUtil.getParameter(request, prefix	+ "pkup_upd_dt", length));
			String[] tpszCd = (JSPUtil.getParameter(request, prefix	+ "tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] pkupYd = (JSPUtil.getParameter(request, prefix	+ "pkup_yd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] avalDt = (JSPUtil.getParameter(request, prefix	+ "aval_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] ntcTp = (JSPUtil.getParameter(request, prefix	+ "ntc_tp", length));
			String[] spc = (JSPUtil.getParameter(request, prefix	+ "spc", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrPkupNtcInfoVO();
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (pkupRmk[i] != null)
					model.setPkupRmk(pkupRmk[i]);
				if (pkupEvntDt[i] != null)
					model.setPkupEvntDt(pkupEvntDt[i]);
				if (freeDt[i] != null)
					model.setFreeDt(freeDt[i]);
				if (pkupUpdDt[i] != null)
					model.setPkupUpdDt(pkupUpdDt[i]);
				if (tpszCd[i] != null)
					model.setTpszCd(tpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (pkupYd[i] != null)
					model.setPkupYd(pkupYd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (avalDt[i] != null)
					model.setAvalDt(avalDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (ntcTp[i] != null)
					model.setNtcTp(ntcTp[i]);
				if (spc[i] != null)
					model.setSpc(spc[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrPkupNtcInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrPkupNtcInfoVO[]
	 */
	public CntrPkupNtcInfoVO[] getCntrPkupNtcInfoVOs(){
		CntrPkupNtcInfoVO[] vos = (CntrPkupNtcInfoVO[])models.toArray(new CntrPkupNtcInfoVO[models.size()]);
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
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupRmk = this.pkupRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupEvntDt = this.pkupEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDt = this.freeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupUpdDt = this.pkupUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCd = this.tpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupYd = this.pkupYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avalDt = this.avalDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcTp = this.ntcTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spc = this.spc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
