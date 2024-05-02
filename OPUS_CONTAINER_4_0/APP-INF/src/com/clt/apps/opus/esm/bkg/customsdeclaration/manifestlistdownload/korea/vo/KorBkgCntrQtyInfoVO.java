/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorBkgCntrQtyInfoVO.java
*@FileTitle : KorBkgCntrQtyInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.12.10 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorBkgCntrQtyInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorBkgCntrQtyInfoVO> models = new ArrayList<KorBkgCntrQtyInfoVO>();

	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String cntrType = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String cntrSealNo1 = null;
	/* Column Info */
	private String cntrSealNo2 = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String sel = null;
	/* Column Info */
	private String cntrVolQty = null;
	/* Column Info */
	private String blNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorBkgCntrQtyInfoVO() {}

	public KorBkgCntrQtyInfoVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String cntrSealNo1, String cntrSealNo2, String pckQty, String pckTpCd, String cntrWgt, String wgtUtCd, String measQty, String measUtCd, String opCntrQty, String cntrVolQty, String bkgNo, String sel, String cntrType, String blNo) {
		this.cntrWgt = cntrWgt;
		this.cntrType = cntrType;
		this.pagerows = pagerows;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.opCntrQty = opCntrQty;
		this.cntrSealNo1 = cntrSealNo1;
		this.cntrSealNo2 = cntrSealNo2;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.sel = sel;
		this.cntrVolQty = cntrVolQty;
		this.blNo = blNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("cntr_seal_no1", getCntrSealNo1());
		this.hashColumns.put("cntr_seal_no2", getCntrSealNo2());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("sel", getSel());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		this.hashColumns.put("bl_no", getBlNo());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("cntr_seal_no1", "cntrSealNo1");
		this.hashFields.put("cntr_seal_no2", "cntrSealNo2");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("sel", "sel");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("bl_no", "blNo");
		return this.hashFields;
	}

	/**
	 * @return the blNo
	 */
	public String getBlNo() {
		return blNo;
	}

	/**
	 * @param blNo the blNo to set
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}

	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
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
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}

	/**
	 * Column Info
	 * @return cntrSealNo1
	 */
	public String getCntrSealNo1() {
		return this.cntrSealNo1;
	}

	/**
	 * Column Info
	 * @return cntrSealNo2
	 */
	public String getCntrSealNo2() {
		return this.cntrSealNo2;
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
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}

	/**
	 * Column Info
	 * @return sel
	 */
	public String getSel() {
		return this.sel;
	}

	/**
	 * Column Info
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
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
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
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
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}

	/**
	 * Column Info
	 * @param cntrSealNo1
	 */
	public void setCntrSealNo1(String cntrSealNo1) {
		this.cntrSealNo1 = cntrSealNo1;
	}

	/**
	 * Column Info
	 * @param cntrSealNo2
	 */
	public void setCntrSealNo2(String cntrSealNo2) {
		this.cntrSealNo2 = cntrSealNo2;
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
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}

	/**
	 * Column Info
	 * @param sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
	}

	/**
	 * Column Info
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setCntrType(JSPUtil.getParameter(request, "cntr_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setOpCntrQty(JSPUtil.getParameter(request, "op_cntr_qty", ""));
		setCntrSealNo1(JSPUtil.getParameter(request, "cntr_seal_no1", ""));
		setCntrSealNo2(JSPUtil.getParameter(request, "cntr_seal_no2", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setSel(JSPUtil.getParameter(request, "sel", ""));
		setCntrVolQty(JSPUtil.getParameter(request, "cntr_vol_qty", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorBkgCntrQtyInfoVO[]
	 */
	public KorBkgCntrQtyInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorBkgCntrQtyInfoVO[]
	 */
	public KorBkgCntrQtyInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorBkgCntrQtyInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] cntrSealNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no1", length));
			String[] cntrSealNo2 = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no2", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] sel = (JSPUtil.getParameter(request, prefix	+ "sel", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));

			for (int i = 0; i < length; i++) {
				model = new KorBkgCntrQtyInfoVO();
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (cntrSealNo1[i] != null)
					model.setCntrSealNo1(cntrSealNo1[i]);
				if (cntrSealNo2[i] != null)
					model.setCntrSealNo2(cntrSealNo2[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (sel[i] != null)
					model.setSel(sel[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorBkgCntrQtyInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorBkgCntrQtyInfoVO[]
	 */
	public KorBkgCntrQtyInfoVO[] getKorBkgCntrQtyInfoVOs(){
		KorBkgCntrQtyInfoVO[] vos = (KorBkgCntrQtyInfoVO[])models.toArray(new KorBkgCntrQtyInfoVO[models.size()]);
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
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo1 = this.cntrSealNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo2 = this.cntrSealNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sel = this.sel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
