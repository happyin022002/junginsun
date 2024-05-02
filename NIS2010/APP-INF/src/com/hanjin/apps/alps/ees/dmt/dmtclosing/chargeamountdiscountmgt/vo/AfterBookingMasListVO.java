/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AfterBookingMasListVO.java
*@FileTitle : AfterBookingMasListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class AfterBookingMasListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBookingMasListVO> models = new ArrayList<AfterBookingMasListVO>();
	
	/* Column Info */
	private String aftBkgMasRqstSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String lodQty = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String cmAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String cmpbAmt = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String aftBkgCtrtNo = null;
	/* Column Info */
	private String retriveFlg = null;
	/* Column Info */
	private String lccFlg = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AfterBookingMasListVO() {}

	public AfterBookingMasListVO(String ibflag, String pagerows, String aftExptDarNo, String custCd, String custNm, String aftBkgCtrtNo, String bkgCtrtTpCd, String lodQty, String cmAmt, String cmpbAmt, String creUsrId, String creDt, String updUsrId, String updDt, String aftBkgMasRqstSeq, String custCntCd, String custSeq, String retriveFlg, String lccFlg) {
		this.aftBkgMasRqstSeq = aftBkgMasRqstSeq;
		this.updDt = updDt;
		this.lodQty = lodQty;
		this.custNm = custNm;
		this.creDt = creDt;
		this.custSeq = custSeq;
		this.cmAmt = cmAmt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.aftExptDarNo = aftExptDarNo;
		this.custCd = custCd;
		this.cmpbAmt = cmpbAmt;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.aftBkgCtrtNo = aftBkgCtrtNo;
		this.retriveFlg = retriveFlg;
		this.lccFlg = lccFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("aft_bkg_mas_rqst_seq", getAftBkgMasRqstSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("lod_qty", getLodQty());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cm_amt", getCmAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cmpb_amt", getCmpbAmt());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("aft_bkg_ctrt_no", getAftBkgCtrtNo());
		this.hashColumns.put("retrive_flg", getRetriveFlg());
		this.hashColumns.put("lcc_flg", getLccFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("aft_bkg_mas_rqst_seq", "aftBkgMasRqstSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("lod_qty", "lodQty");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cm_amt", "cmAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cmpb_amt", "cmpbAmt");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("aft_bkg_ctrt_no", "aftBkgCtrtNo");
		this.hashFields.put("retrive_flg", "retriveFlg");
		this.hashFields.put("lcc_flg", "lccFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aftBkgMasRqstSeq
	 */
	public String getAftBkgMasRqstSeq() {
		return this.aftBkgMasRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return lodQty
	 */
	public String getLodQty() {
		return this.lodQty;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return cmAmt
	 */
	public String getCmAmt() {
		return this.cmAmt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return cmpbAmt
	 */
	public String getCmpbAmt() {
		return this.cmpbAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return aftBkgCtrtNo
	 */
	public String getAftBkgCtrtNo() {
		return this.aftBkgCtrtNo;
	}
	

	/**
	 * Column Info
	 * @param aftBkgMasRqstSeq
	 */
	public void setAftBkgMasRqstSeq(String aftBkgMasRqstSeq) {
		this.aftBkgMasRqstSeq = aftBkgMasRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param lodQty
	 */
	public void setLodQty(String lodQty) {
		this.lodQty = lodQty;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param cmAmt
	 */
	public void setCmAmt(String cmAmt) {
		this.cmAmt = cmAmt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param cmpbAmt
	 */
	public void setCmpbAmt(String cmpbAmt) {
		this.cmpbAmt = cmpbAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param aftBkgCtrtNo
	 */
	public void setAftBkgCtrtNo(String aftBkgCtrtNo) {
		this.aftBkgCtrtNo = aftBkgCtrtNo;
	}
	
	public String getRetriveFlg() {
		return retriveFlg;
	}

	public void setRetriveFlg(String retriveFlg) {
		this.retriveFlg = retriveFlg;
	}

	public String getLccFlg() {
		return lccFlg;
	}

	public void setLccFlg(String lccFlg) {
		this.lccFlg = lccFlg;
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
		setAftBkgMasRqstSeq(JSPUtil.getParameter(request, prefix + "aft_bkg_mas_rqst_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setLodQty(JSPUtil.getParameter(request, prefix + "lod_qty", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCmAmt(JSPUtil.getParameter(request, prefix + "cm_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCmpbAmt(JSPUtil.getParameter(request, prefix + "cmpb_amt", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAftBkgCtrtNo(JSPUtil.getParameter(request, prefix + "aft_bkg_ctrt_no", ""));
		setRetriveFlg(JSPUtil.getParameter(request, prefix + "retrive_flg", ""));
		setLccFlg(JSPUtil.getParameter(request, prefix + "lcc_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBookingMasListVO[]
	 */
	public AfterBookingMasListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBookingMasListVO[]
	 */
	public AfterBookingMasListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBookingMasListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aftBkgMasRqstSeq = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_mas_rqst_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] lodQty = (JSPUtil.getParameter(request, prefix	+ "lod_qty", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] cmAmt = (JSPUtil.getParameter(request, prefix	+ "cm_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] cmpbAmt = (JSPUtil.getParameter(request, prefix	+ "cmpb_amt", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] aftBkgCtrtNo = (JSPUtil.getParameter(request, prefix	+ "aft_bkg_ctrt_no", length));
			String[] retriveFlg = (JSPUtil.getParameter(request, prefix	+ "retrive_flg", length));
			String[] lccFlg = (JSPUtil.getParameter(request, prefix	+ "lcc_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBookingMasListVO();
				if (aftBkgMasRqstSeq[i] != null)
					model.setAftBkgMasRqstSeq(aftBkgMasRqstSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (lodQty[i] != null)
					model.setLodQty(lodQty[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (cmAmt[i] != null)
					model.setCmAmt(cmAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (cmpbAmt[i] != null)
					model.setCmpbAmt(cmpbAmt[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (aftBkgCtrtNo[i] != null)
					model.setAftBkgCtrtNo(aftBkgCtrtNo[i]);
				if (retriveFlg[i] != null)
					model.setRetriveFlg(retriveFlg[i]);
				if (lccFlg[i] != null)
					model.setLccFlg(lccFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBookingMasListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBookingMasListVO[]
	 */
	public AfterBookingMasListVO[] getAfterBookingMasListVOs(){
		AfterBookingMasListVO[] vos = (AfterBookingMasListVO[])models.toArray(new AfterBookingMasListVO[models.size()]);
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
		this.aftBkgMasRqstSeq = this.aftBkgMasRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodQty = this.lodQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmAmt = this.cmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpbAmt = this.cmpbAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftBkgCtrtNo = this.aftBkgCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.retriveFlg = this.retriveFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccFlg = this.lccFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
