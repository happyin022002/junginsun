/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PsaBkgQtyVO.java
*@FileTitle : PsaBkgQtyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.08
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.08
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PsaBkgQtyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PsaBkgQtyVO> models = new ArrayList<PsaBkgQtyVO>();

	/* Column Info */
	private String cntrtsCd = null;
	/* Column Info */
	private String cntrHeight = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String akQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rfQty = null;
	/* Column Info */
	private String dgQty = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrSz = null;
	/* Column Info */
	private String qty = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PsaBkgQtyVO() {}

	public PsaBkgQtyVO(String ibflag, String pagerows, String cntrtsCd, String cntrSz, String qty, String dgQty, String akQty, String rfQty, String cntrHeight, String cntrNo, String bkgNo) {
		this.cntrtsCd = cntrtsCd;
		this.cntrHeight = cntrHeight;
		this.bkgNo = bkgNo;
		this.akQty = akQty;
		this.ibflag = ibflag;
		this.rfQty = rfQty;
		this.dgQty = dgQty;
		this.cntrNo = cntrNo;
		this.cntrSz = cntrSz;
		this.qty = qty;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntrts_cd", getCntrtsCd());
		this.hashColumns.put("cntr_height", getCntrHeight());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ak_qty", getAkQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rf_qty", getRfQty());
		this.hashColumns.put("dg_qty", getDgQty());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_sz", getCntrSz());
		this.hashColumns.put("qty", getQty());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntrts_cd", "cntrtsCd");
		this.hashFields.put("cntr_height", "cntrHeight");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ak_qty", "akQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rf_qty", "rfQty");
		this.hashFields.put("dg_qty", "dgQty");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_sz", "cntrSz");
		this.hashFields.put("qty", "qty");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cntrtsCd
	 */
	public String getCntrtsCd() {
		return this.cntrtsCd;
	}

	/**
	 * Column Info
	 * @return cntrHeight
	 */
	public String getCntrHeight() {
		return this.cntrHeight;
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
	 * @return akQty
	 */
	public String getAkQty() {
		return this.akQty;
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
	 * @return rfQty
	 */
	public String getRfQty() {
		return this.rfQty;
	}

	/**
	 * Column Info
	 * @return dgQty
	 */
	public String getDgQty() {
		return this.dgQty;
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
	 * @return cntrSz
	 */
	public String getCntrSz() {
		return this.cntrSz;
	}

	/**
	 * Column Info
	 * @return qty
	 */
	public String getQty() {
		return this.qty;
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
	 * @param cntrtsCd
	 */
	public void setCntrtsCd(String cntrtsCd) {
		this.cntrtsCd = cntrtsCd;
	}

	/**
	 * Column Info
	 * @param cntrHeight
	 */
	public void setCntrHeight(String cntrHeight) {
		this.cntrHeight = cntrHeight;
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
	 * @param akQty
	 */
	public void setAkQty(String akQty) {
		this.akQty = akQty;
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
	 * @param rfQty
	 */
	public void setRfQty(String rfQty) {
		this.rfQty = rfQty;
	}

	/**
	 * Column Info
	 * @param dgQty
	 */
	public void setDgQty(String dgQty) {
		this.dgQty = dgQty;
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
	 * @param cntrSz
	 */
	public void setCntrSz(String cntrSz) {
		this.cntrSz = cntrSz;
	}

	/**
	 * Column Info
	 * @param qty
	 */
	public void setQty(String qty) {
		this.qty = qty;
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
		setCntrtsCd(JSPUtil.getParameter(request, prefix + "cntrts_cd", ""));
		setCntrHeight(JSPUtil.getParameter(request, prefix + "cntr_height", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setAkQty(JSPUtil.getParameter(request, prefix + "ak_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRfQty(JSPUtil.getParameter(request, prefix + "rf_qty", ""));
		setDgQty(JSPUtil.getParameter(request, prefix + "dg_qty", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrSz(JSPUtil.getParameter(request, prefix + "cntr_sz", ""));
		setQty(JSPUtil.getParameter(request, prefix + "qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsaBkgQtyVO[]
	 */
	public PsaBkgQtyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PsaBkgQtyVO[]
	 */
	public PsaBkgQtyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsaBkgQtyVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cntrtsCd = (JSPUtil.getParameter(request, prefix	+ "cntrts_cd", length));
			String[] cntrHeight = (JSPUtil.getParameter(request, prefix	+ "cntr_height", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] akQty = (JSPUtil.getParameter(request, prefix	+ "ak_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rfQty = (JSPUtil.getParameter(request, prefix	+ "rf_qty", length));
			String[] dgQty = (JSPUtil.getParameter(request, prefix	+ "dg_qty", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrSz = (JSPUtil.getParameter(request, prefix	+ "cntr_sz", length));
			String[] qty = (JSPUtil.getParameter(request, prefix	+ "qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new PsaBkgQtyVO();
				if (cntrtsCd[i] != null)
					model.setCntrtsCd(cntrtsCd[i]);
				if (cntrHeight[i] != null)
					model.setCntrHeight(cntrHeight[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (akQty[i] != null)
					model.setAkQty(akQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rfQty[i] != null)
					model.setRfQty(rfQty[i]);
				if (dgQty[i] != null)
					model.setDgQty(dgQty[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrSz[i] != null)
					model.setCntrSz(cntrSz[i]);
				if (qty[i] != null)
					model.setQty(qty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsaBkgQtyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsaBkgQtyVO[]
	 */
	public PsaBkgQtyVO[] getPsaBkgQtyVOs(){
		PsaBkgQtyVO[] vos = (PsaBkgQtyVO[])models.toArray(new PsaBkgQtyVO[models.size()]);
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
		this.cntrtsCd = this.cntrtsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHeight = this.cntrHeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akQty = this.akQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfQty = this.rfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgQty = this.dgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSz = this.cntrSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty = this.qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
