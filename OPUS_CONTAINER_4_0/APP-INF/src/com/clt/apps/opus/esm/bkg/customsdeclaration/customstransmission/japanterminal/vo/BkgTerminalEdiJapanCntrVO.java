/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BkgTerminalEdiJapanCntrVO.java
*@FileTitle : BkgTerminalEdiJapanCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.16
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.03.16 김종옥
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgTerminalEdiJapanCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BkgTerminalEdiJapanCntrVO> models = new ArrayList<BkgTerminalEdiJapanCntrVO>();

	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String cntrTpszIsoCd = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String cntrPrtSeq = null;
	/* Column Info */
	private String bkgSkdSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
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
	private String measUtCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String cntrVolQty = null;
	/* Column Info */
	private String count = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BkgTerminalEdiJapanCntrVO() {}

	public BkgTerminalEdiJapanCntrVO(String ibflag, String pagerows, String count, String bkgNo, String bkgSkdSeq, String cntrNo, String cntrTpszCd, String cntrVolQty, String cntrTpszIsoCd, String pckTpCd, String pckQty, String cntrWgt, String wgtUtCd, String measQty, String measUtCd, String cntrPrtFlg, String cntrPrtSeq) {
		this.cntrPrtFlg = cntrPrtFlg;
		this.cntrTpszIsoCd = cntrTpszIsoCd;
		this.cntrWgt = cntrWgt;
		this.cntrPrtSeq = cntrPrtSeq;
		this.bkgSkdSeq = bkgSkdSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.measUtCd = measUtCd;
		this.pckTpCd = pckTpCd;
		this.cntrVolQty = cntrVolQty;
		this.count = count;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("cntr_tpsz_iso_cd", getCntrTpszIsoCd());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("cntr_prt_seq", getCntrPrtSeq());
		this.hashColumns.put("bkg_skd_seq", getBkgSkdSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		this.hashColumns.put("count", getCount());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("cntr_tpsz_iso_cd", "cntrTpszIsoCd");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("cntr_prt_seq", "cntrPrtSeq");
		this.hashFields.put("bkg_skd_seq", "bkgSkdSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("count", "count");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg() {
		return this.cntrPrtFlg;
	}

	/**
	 * Column Info
	 * @return cntrTpszIsoCd
	 */
	public String getCntrTpszIsoCd() {
		return this.cntrTpszIsoCd;
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
	 * @return cntrPrtSeq
	 */
	public String getCntrPrtSeq() {
		return this.cntrPrtSeq;
	}

	/**
	 * Column Info
	 * @return bkgSkdSeq
	 */
	public String getBkgSkdSeq() {
		return this.bkgSkdSeq;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
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
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
	}

	/**
	 * Column Info
	 * @return count
	 */
	public String getCount() {
		return this.count;
	}


	/**
	 * Column Info
	 * @param cntrPrtFlg
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
	}

	/**
	 * Column Info
	 * @param cntrTpszIsoCd
	 */
	public void setCntrTpszIsoCd(String cntrTpszIsoCd) {
		this.cntrTpszIsoCd = cntrTpszIsoCd;
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
	 * @param cntrPrtSeq
	 */
	public void setCntrPrtSeq(String cntrPrtSeq) {
		this.cntrPrtSeq = cntrPrtSeq;
	}

	/**
	 * Column Info
	 * @param bkgSkdSeq
	 */
	public void setBkgSkdSeq(String bkgSkdSeq) {
		this.bkgSkdSeq = bkgSkdSeq;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
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
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
	}

	/**
	 * Column Info
	 * @param count
	 */
	public void setCount(String count) {
		this.count = count;
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
		setCntrPrtFlg(JSPUtil.getParameter(request, prefix + "cntr_prt_flg", ""));
		setCntrTpszIsoCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_iso_cd", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setCntrPrtSeq(JSPUtil.getParameter(request, prefix + "cntr_prt_seq", ""));
		setBkgSkdSeq(JSPUtil.getParameter(request, prefix + "bkg_skd_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setCntrVolQty(JSPUtil.getParameter(request, prefix + "cntr_vol_qty", ""));
		setCount(JSPUtil.getParameter(request, prefix + "count", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgTerminalEdiJapanCntrVO[]
	 */
	public BkgTerminalEdiJapanCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgTerminalEdiJapanCntrVO[]
	 */
	public BkgTerminalEdiJapanCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgTerminalEdiJapanCntrVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] cntrTpszIsoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_iso_cd", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] cntrPrtSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_seq", length));
			String[] bkgSkdSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_skd_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			String[] count = (JSPUtil.getParameter(request, prefix	+ "count", length));

			for (int i = 0; i < length; i++) {
				model = new BkgTerminalEdiJapanCntrVO();
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (cntrTpszIsoCd[i] != null)
					model.setCntrTpszIsoCd(cntrTpszIsoCd[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (cntrPrtSeq[i] != null)
					model.setCntrPrtSeq(cntrPrtSeq[i]);
				if (bkgSkdSeq[i] != null)
					model.setBkgSkdSeq(bkgSkdSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
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
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				if (count[i] != null)
					model.setCount(count[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgTerminalEdiJapanCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgTerminalEdiJapanCntrVO[]
	 */
	public BkgTerminalEdiJapanCntrVO[] getBkgTerminalEdiJapanCntrVOs(){
		BkgTerminalEdiJapanCntrVO[] vos = (BkgTerminalEdiJapanCntrVO[])models.toArray(new BkgTerminalEdiJapanCntrVO[models.size()]);
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
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszIsoCd = this.cntrTpszIsoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtSeq = this.cntrPrtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSkdSeq = this.bkgSkdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.count = this.count .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
