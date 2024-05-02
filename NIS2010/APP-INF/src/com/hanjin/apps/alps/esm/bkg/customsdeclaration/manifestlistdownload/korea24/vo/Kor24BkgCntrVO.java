/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24BkgCntrVO.java
*@FileTitle : Kor24BkgCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.10
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.12.10 박상훈
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Kor24BkgCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<Kor24BkgCntrVO> models = new ArrayList<Kor24BkgCntrVO>();

	/* Column Info */
	private String bCntrMeaQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bCntrNo = null;
	/* Column Info */
	private String bCntrSealNo2 = null;
	/* Column Info */
	private String bCntrSealNo1 = null;
	/* Column Info */
	private String bCntrtsCd = null;
	/* Column Info */
	private String bCntrMeaTp = null;
	/* Column Info */
	private String bCntrPkgQty = null;
	/* Column Info */
	private String bCntrWgtTp = null;
	/* Column Info */
	private String bCntrPkgCd = null;
	/* Column Info */
	private String bCntrWgtQty = null;
	/* Column Info */
	private String bBbCgoFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public Kor24BkgCntrVO() {}

	public Kor24BkgCntrVO(String ibflag, String pagerows, String bCntrNo, String bCntrtsCd, String bCntrSealNo1, String bCntrSealNo2, String bCntrPkgQty, String bCntrPkgCd, String bCntrWgtQty, String bCntrWgtTp, String bCntrMeaQty, String bCntrMeaTp, String bBbCgoFlg) {
		this.bCntrMeaQty = bCntrMeaQty;
		this.ibflag = ibflag;
		this.bCntrNo = bCntrNo;
		this.bCntrSealNo2 = bCntrSealNo2;
		this.bCntrSealNo1 = bCntrSealNo1;
		this.bCntrtsCd = bCntrtsCd;
		this.bCntrMeaTp = bCntrMeaTp;
		this.bCntrPkgQty = bCntrPkgQty;
		this.bCntrWgtTp = bCntrWgtTp;
		this.bCntrPkgCd = bCntrPkgCd;
		this.bCntrWgtQty = bCntrWgtQty;
		this.bBbCgoFlg = bBbCgoFlg;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("b_cntr_mea_qty", getBCntrMeaQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("b_cntr_no", getBCntrNo());
		this.hashColumns.put("b_cntr_seal_no2", getBCntrSealNo2());
		this.hashColumns.put("b_cntr_seal_no1", getBCntrSealNo1());
		this.hashColumns.put("b_cntrts_cd", getBCntrtsCd());
		this.hashColumns.put("b_cntr_mea_tp", getBCntrMeaTp());
		this.hashColumns.put("b_cntr_pkg_qty", getBCntrPkgQty());
		this.hashColumns.put("b_cntr_wgt_tp", getBCntrWgtTp());
		this.hashColumns.put("b_cntr_pkg_cd", getBCntrPkgCd());
		this.hashColumns.put("b_cntr_wgt_qty", getBCntrWgtQty());
		this.hashColumns.put("b_bb_cgo_flg", getBBbCgoFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("b_cntr_mea_qty", "bCntrMeaQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("b_cntr_no", "bCntrNo");
		this.hashFields.put("b_cntr_seal_no2", "bCntrSealNo2");
		this.hashFields.put("b_cntr_seal_no1", "bCntrSealNo1");
		this.hashFields.put("b_cntrts_cd", "bCntrtsCd");
		this.hashFields.put("b_cntr_mea_tp", "bCntrMeaTp");
		this.hashFields.put("b_cntr_pkg_qty", "bCntrPkgQty");
		this.hashFields.put("b_cntr_wgt_tp", "bCntrWgtTp");
		this.hashFields.put("b_cntr_pkg_cd", "bCntrPkgCd");
		this.hashFields.put("b_cntr_wgt_qty", "bCntrWgtQty");
		this.hashFields.put("b_bb_cgo_flg", "bBbCgoFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return bCntrMeaQty
	 */
	public String getBCntrMeaQty() {
		return this.bCntrMeaQty;
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
	 * @return bCntrNo
	 */
	public String getBCntrNo() {
		return this.bCntrNo;
	}

	/**
	 * Column Info
	 * @return bCntrSealNo2
	 */
	public String getBCntrSealNo2() {
		return this.bCntrSealNo2;
	}

	/**
	 * Column Info
	 * @return bCntrSealNo1
	 */
	public String getBCntrSealNo1() {
		return this.bCntrSealNo1;
	}

	/**
	 * Column Info
	 * @return bCntrtsCd
	 */
	public String getBCntrtsCd() {
		return this.bCntrtsCd;
	}

	/**
	 * Column Info
	 * @return bCntrMeaTp
	 */
	public String getBCntrMeaTp() {
		return this.bCntrMeaTp;
	}

	/**
	 * Column Info
	 * @return bCntrPkgQty
	 */
	public String getBCntrPkgQty() {
		return this.bCntrPkgQty;
	}

	/**
	 * Column Info
	 * @return bCntrWgtTp
	 */
	public String getBCntrWgtTp() {
		return this.bCntrWgtTp;
	}

	/**
	 * Column Info
	 * @return bCntrPkgCd
	 */
	public String getBCntrPkgCd() {
		return this.bCntrPkgCd;
	}

	/**
	 * Column Info
	 * @return bCntrWgtQty
	 */
	public String getBCntrWgtQty() {
		return this.bCntrWgtQty;
	}

	/**
	 * Column Info
	 * @return bBbCgoFlg
	 */
	public String getBBbCgoFlg() {
		return this.bBbCgoFlg;
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
	 * @param bCntrMeaQty
	 */
	public void setBCntrMeaQty(String bCntrMeaQty) {
		this.bCntrMeaQty = bCntrMeaQty;
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
	 * @param bCntrNo
	 */
	public void setBCntrNo(String bCntrNo) {
		this.bCntrNo = bCntrNo;
	}

	/**
	 * Column Info
	 * @param bCntrSealNo2
	 */
	public void setBCntrSealNo2(String bCntrSealNo2) {
		this.bCntrSealNo2 = bCntrSealNo2;
	}

	/**
	 * Column Info
	 * @param bCntrSealNo1
	 */
	public void setBCntrSealNo1(String bCntrSealNo1) {
		this.bCntrSealNo1 = bCntrSealNo1;
	}

	/**
	 * Column Info
	 * @param bCntrtsCd
	 */
	public void setBCntrtsCd(String bCntrtsCd) {
		this.bCntrtsCd = bCntrtsCd;
	}

	/**
	 * Column Info
	 * @param bCntrMeaTp
	 */
	public void setBCntrMeaTp(String bCntrMeaTp) {
		this.bCntrMeaTp = bCntrMeaTp;
	}

	/**
	 * Column Info
	 * @param bCntrPkgQty
	 */
	public void setBCntrPkgQty(String bCntrPkgQty) {
		this.bCntrPkgQty = bCntrPkgQty;
	}

	/**
	 * Column Info
	 * @param bCntrWgtTp
	 */
	public void setBCntrWgtTp(String bCntrWgtTp) {
		this.bCntrWgtTp = bCntrWgtTp;
	}

	/**
	 * Column Info
	 * @param bCntrPkgCd
	 */
	public void setBCntrPkgCd(String bCntrPkgCd) {
		this.bCntrPkgCd = bCntrPkgCd;
	}

	/**
	 * Column Info
	 * @param bCntrWgtQty
	 */
	public void setBCntrWgtQty(String bCntrWgtQty) {
		this.bCntrWgtQty = bCntrWgtQty;
	}

	/**
	 * Column Info
	 * @param bBbCgoFlg
	 */
	public void setBBbCgoFlg(String bBbCgoFlg) {
		this.bBbCgoFlg = bBbCgoFlg;
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
		setBCntrMeaQty(JSPUtil.getParameter(request, "b_cntr_mea_qty", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBCntrNo(JSPUtil.getParameter(request, "b_cntr_no", ""));
		setBCntrSealNo2(JSPUtil.getParameter(request, "b_cntr_seal_no2", ""));
		setBCntrSealNo1(JSPUtil.getParameter(request, "b_cntr_seal_no1", ""));
		setBCntrtsCd(JSPUtil.getParameter(request, "b_cntrts_cd", ""));
		setBCntrMeaTp(JSPUtil.getParameter(request, "b_cntr_mea_tp", ""));
		setBCntrPkgQty(JSPUtil.getParameter(request, "b_cntr_pkg_qty", ""));
		setBCntrWgtTp(JSPUtil.getParameter(request, "b_cntr_wgt_tp", ""));
		setBCntrPkgCd(JSPUtil.getParameter(request, "b_cntr_pkg_cd", ""));
		setBCntrWgtQty(JSPUtil.getParameter(request, "b_cntr_wgt_qty", ""));
		setBBbCgoFlg(JSPUtil.getParameter(request, "b_bb_cgo_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Kor24BkgCntrVO[]
	 */
	public Kor24BkgCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return Kor24BkgCntrVO[]
	 */
	public Kor24BkgCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Kor24BkgCntrVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bCntrMeaQty = (JSPUtil.getParameter(request, prefix	+ "b_cntr_mea_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bCntrNo = (JSPUtil.getParameter(request, prefix	+ "b_cntr_no", length));
			String[] bCntrSealNo2 = (JSPUtil.getParameter(request, prefix	+ "b_cntr_seal_no2", length));
			String[] bCntrSealNo1 = (JSPUtil.getParameter(request, prefix	+ "b_cntr_seal_no1", length));
			String[] bCntrtsCd = (JSPUtil.getParameter(request, prefix	+ "b_cntrts_cd", length));
			String[] bCntrMeaTp = (JSPUtil.getParameter(request, prefix	+ "b_cntr_mea_tp", length));
			String[] bCntrPkgQty = (JSPUtil.getParameter(request, prefix	+ "b_cntr_pkg_qty", length));
			String[] bCntrWgtTp = (JSPUtil.getParameter(request, prefix	+ "b_cntr_wgt_tp", length));
			String[] bCntrPkgCd = (JSPUtil.getParameter(request, prefix	+ "b_cntr_pkg_cd", length));
			String[] bCntrWgtQty = (JSPUtil.getParameter(request, prefix	+ "b_cntr_wgt_qty", length));
			String[] bBbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "b_bb_cgo_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new Kor24BkgCntrVO();
				if (bCntrMeaQty[i] != null)
					model.setBCntrMeaQty(bCntrMeaQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bCntrNo[i] != null)
					model.setBCntrNo(bCntrNo[i]);
				if (bCntrSealNo2[i] != null)
					model.setBCntrSealNo2(bCntrSealNo2[i]);
				if (bCntrSealNo1[i] != null)
					model.setBCntrSealNo1(bCntrSealNo1[i]);
				if (bCntrtsCd[i] != null)
					model.setBCntrtsCd(bCntrtsCd[i]);
				if (bCntrMeaTp[i] != null)
					model.setBCntrMeaTp(bCntrMeaTp[i]);
				if (bCntrPkgQty[i] != null)
					model.setBCntrPkgQty(bCntrPkgQty[i]);
				if (bCntrWgtTp[i] != null)
					model.setBCntrWgtTp(bCntrWgtTp[i]);
				if (bCntrPkgCd[i] != null)
					model.setBCntrPkgCd(bCntrPkgCd[i]);
				if (bCntrWgtQty[i] != null)
					model.setBCntrWgtQty(bCntrWgtQty[i]);
				if (bBbCgoFlg[i] != null)
					model.setBBbCgoFlg(bBbCgoFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKor24BkgCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Kor24BkgCntrVO[]
	 */
	public Kor24BkgCntrVO[] getKor24BkgCntrVOs(){
		Kor24BkgCntrVO[] vos = (Kor24BkgCntrVO[])models.toArray(new Kor24BkgCntrVO[models.size()]);
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
		this.bCntrMeaQty = this.bCntrMeaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrNo = this.bCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrSealNo2 = this.bCntrSealNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrSealNo1 = this.bCntrSealNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrtsCd = this.bCntrtsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrMeaTp = this.bCntrMeaTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrPkgQty = this.bCntrPkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrWgtTp = this.bCntrWgtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrPkgCd = this.bCntrPkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bCntrWgtQty = this.bCntrWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bBbCgoFlg = this.bBbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
