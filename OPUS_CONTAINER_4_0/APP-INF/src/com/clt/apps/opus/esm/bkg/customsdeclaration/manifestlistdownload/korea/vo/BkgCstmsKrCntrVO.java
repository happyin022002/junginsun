/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCstmsKrCntrVO.java
*@FileTitle : BkgCstmsKrCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.04 박상훈
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

public class BkgCstmsKrCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<BkgCstmsKrCntrVO> models = new ArrayList<BkgCstmsKrCntrVO>();

	/* Column Info */
	private String cntrWgtQty = null;
	/* Column Info */
	private String cntrtsCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cntrMeaTp = null;
	/* Column Info */
	private String trCd = null;
	/* Column Info */
	private String cntrMeaQty = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String cntrWgtTp = null;
	/* Column Info */
	private String kcdTp = null;
	/* Column Info */
	private String exptKcdTp = null;
	/* Column Info */
	private String feInd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ktSeq = null;
	/* Column Info */
	private String username = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sealNo2 = null;
	/* Column Info */
	private String sealNo1 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrPkgCd = null;
	/* Column Info */
	private String cntrPkgQty = null;
	/* Column Info */
	private String obType = null;
	/* Column Info */
	private String ktPort = null;
	/* Column Info */
	private String cBlNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public BkgCstmsKrCntrVO() {}

	public BkgCstmsKrCntrVO(String ibflag, String pagerows, String bkgNo, String bkgNoSplit, String exptKcdTp, String kcdTp, String ktSeq, String cntrNo, String feInd, String sealNo1, String sealNo2, String cntrtsCd, String cntrPkgQty, String cntrPkgCd, String cntrWgtQty, String cntrWgtTp, String cntrMeaQty, String cntrMeaTp, String ktPort, String trCd, String username, String vslCd, String obType, String cBlNo) {
		this.cntrWgtQty = cntrWgtQty;
		this.cntrtsCd = cntrtsCd;
		this.vslCd = vslCd;
		this.cntrMeaTp = cntrMeaTp;
		this.trCd = trCd;
		this.cntrMeaQty = cntrMeaQty;
		this.bkgNoSplit = bkgNoSplit;
		this.cntrWgtTp = cntrWgtTp;
		this.kcdTp = kcdTp;
		this.exptKcdTp = exptKcdTp;
		this.feInd = feInd;
		this.pagerows = pagerows;
		this.ktSeq = ktSeq;
		this.username = username;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.sealNo2 = sealNo2;
		this.sealNo1 = sealNo1;
		this.cntrNo = cntrNo;
		this.cntrPkgCd = cntrPkgCd;
		this.cntrPkgQty = cntrPkgQty;
		this.obType = obType;
		this.ktPort = ktPort;
		this.cBlNo = cBlNo;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_wgt_qty", getCntrWgtQty());
		this.hashColumns.put("cntrts_cd", getCntrtsCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cntr_mea_tp", getCntrMeaTp());
		this.hashColumns.put("tr_cd", getTrCd());
		this.hashColumns.put("cntr_mea_qty", getCntrMeaQty());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("cntr_wgt_tp", getCntrWgtTp());
		this.hashColumns.put("kcd_tp", getKcdTp());
		this.hashColumns.put("expt_kcd_tp", getExptKcdTp());
		this.hashColumns.put("fe_ind", getFeInd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("kt_seq", getKtSeq());
		this.hashColumns.put("username", getUsername());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("seal_no2", getSealNo2());
		this.hashColumns.put("seal_no1", getSealNo1());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_pkg_cd", getCntrPkgCd());
		this.hashColumns.put("cntr_pkg_qty", getCntrPkgQty());
		this.hashColumns.put("ob_type", getObType());
		this.hashColumns.put("kt_port", getKtPort());
		this.hashColumns.put("c_bl_no", getCBlNo());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_wgt_qty", "cntrWgtQty");
		this.hashFields.put("cntrts_cd", "cntrtsCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cntr_mea_tp", "cntrMeaTp");
		this.hashFields.put("tr_cd", "trCd");
		this.hashFields.put("cntr_mea_qty", "cntrMeaQty");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("cntr_wgt_tp", "cntrWgtTp");
		this.hashFields.put("kcd_tp", "kcdTp");
		this.hashFields.put("expt_kcd_tp", "exptKcdTp");
		this.hashFields.put("fe_ind", "feInd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("kt_seq", "ktSeq");
		this.hashFields.put("username", "username");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("seal_no2", "sealNo2");
		this.hashFields.put("seal_no1", "sealNo1");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_pkg_cd", "cntrPkgCd");
		this.hashFields.put("cntr_pkg_qty", "cntrPkgQty");
		this.hashFields.put("ob_type", "obType");
		this.hashFields.put("kt_port", "ktPort");
		this.hashFields.put("c_bl_no", "cBlNo");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return cntrWgtQty
	 */
	public String getCntrWgtQty() {
		return this.cntrWgtQty;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}

	/**
	 * Column Info
	 * @return cntrMeaTp
	 */
	public String getCntrMeaTp() {
		return this.cntrMeaTp;
	}

	/**
	 * Column Info
	 * @return trCd
	 */
	public String getTrCd() {
		return this.trCd;
	}

	/**
	 * Column Info
	 * @return cntrMeaQty
	 */
	public String getCntrMeaQty() {
		return this.cntrMeaQty;
	}

	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
	}

	/**
	 * Column Info
	 * @return cntrWgtTp
	 */
	public String getCntrWgtTp() {
		return this.cntrWgtTp;
	}

	/**
	 * Column Info
	 * @return kcdTp
	 */
	public String getKcdTp() {
		return this.kcdTp;
	}

	/**
	 * Column Info
	 * @return exptKcdTp
	 */
	public String getExptKcdTp() {
		return this.exptKcdTp;
	}

	/**
	 * Column Info
	 * @return feInd
	 */
	public String getFeInd() {
		return this.feInd;
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
	 * @return ktSeq
	 */
	public String getKtSeq() {
		return this.ktSeq;
	}

	/**
	 * Column Info
	 * @return username
	 */
	public String getUsername() {
		return this.username;
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
	 * @return sealNo2
	 */
	public String getSealNo2() {
		return this.sealNo2;
	}

	/**
	 * Column Info
	 * @return sealNo1
	 */
	public String getSealNo1() {
		return this.sealNo1;
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
	 * @return cntrPkgCd
	 */
	public String getCntrPkgCd() {
		return this.cntrPkgCd;
	}

	/**
	 * Column Info
	 * @return cntrPkgQty
	 */
	public String getCntrPkgQty() {
		return this.cntrPkgQty;
	}

	/**
	 * Column Info
	 * @return obType
	 */
	public String getObType() {
		return this.obType;
	}

	/**
	 * Column Info
	 * @return ktPort
	 */
	public String getKtPort() {
		return this.ktPort;
	}

	/**
	 * Column Info
	 * @return cBlNo
	 */
	public String getCBlNo() {
		return this.cBlNo;
	}


	/**
	 * Column Info
	 * @param cntrWgtQty
	 */
	public void setCntrWgtQty(String cntrWgtQty) {
		this.cntrWgtQty = cntrWgtQty;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * Column Info
	 * @param cntrMeaTp
	 */
	public void setCntrMeaTp(String cntrMeaTp) {
		this.cntrMeaTp = cntrMeaTp;
	}

	/**
	 * Column Info
	 * @param trCd
	 */
	public void setTrCd(String trCd) {
		this.trCd = trCd;
	}

	/**
	 * Column Info
	 * @param cntrMeaQty
	 */
	public void setCntrMeaQty(String cntrMeaQty) {
		this.cntrMeaQty = cntrMeaQty;
	}

	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}

	/**
	 * Column Info
	 * @param cntrWgtTp
	 */
	public void setCntrWgtTp(String cntrWgtTp) {
		this.cntrWgtTp = cntrWgtTp;
	}

	/**
	 * Column Info
	 * @param kcdTp
	 */
	public void setKcdTp(String kcdTp) {
		this.kcdTp = kcdTp;
	}

	/**
	 * Column Info
	 * @param exptKcdTp
	 */
	public void setExptKcdTp(String exptKcdTp) {
		this.exptKcdTp = exptKcdTp;
	}

	/**
	 * Column Info
	 * @param feInd
	 */
	public void setFeInd(String feInd) {
		this.feInd = feInd;
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
	 * @param ktSeq
	 */
	public void setKtSeq(String ktSeq) {
		this.ktSeq = ktSeq;
	}

	/**
	 * Column Info
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @param sealNo2
	 */
	public void setSealNo2(String sealNo2) {
		this.sealNo2 = sealNo2;
	}

	/**
	 * Column Info
	 * @param sealNo1
	 */
	public void setSealNo1(String sealNo1) {
		this.sealNo1 = sealNo1;
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
	 * @param cntrPkgCd
	 */
	public void setCntrPkgCd(String cntrPkgCd) {
		this.cntrPkgCd = cntrPkgCd;
	}

	/**
	 * Column Info
	 * @param cntrPkgQty
	 */
	public void setCntrPkgQty(String cntrPkgQty) {
		this.cntrPkgQty = cntrPkgQty;
	}

	/**
	 * Column Info
	 * @param obType
	 */
	public void setObType(String obType) {
		this.obType = obType;
	}

	/**
	 * Column Info
	 * @param ktPort
	 */
	public void setKtPort(String ktPort) {
		this.ktPort = ktPort;
	}

	/**
	 * Column Info
	 * @param cBlNo
	 */
	public void setCBlNo(String cBlNo) {
		this.cBlNo = cBlNo;
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
		setCntrWgtQty(JSPUtil.getParameter(request, prefix + "cntr_wgt_qty", ""));
		setCntrtsCd(JSPUtil.getParameter(request, prefix + "cntrts_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setCntrMeaTp(JSPUtil.getParameter(request, prefix + "cntr_mea_tp", ""));
		setTrCd(JSPUtil.getParameter(request, prefix + "tr_cd", ""));
		setCntrMeaQty(JSPUtil.getParameter(request, prefix + "cntr_mea_qty", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, prefix + "bkg_no_split", ""));
		setCntrWgtTp(JSPUtil.getParameter(request, prefix + "cntr_wgt_tp", ""));
		setKcdTp(JSPUtil.getParameter(request, prefix + "kcd_tp", ""));
		setExptKcdTp(JSPUtil.getParameter(request, prefix + "expt_kcd_tp", ""));
		setFeInd(JSPUtil.getParameter(request, prefix + "fe_ind", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setKtSeq(JSPUtil.getParameter(request, prefix + "kt_seq", ""));
		setUsername(JSPUtil.getParameter(request, prefix + "username", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSealNo2(JSPUtil.getParameter(request, prefix + "seal_no2", ""));
		setSealNo1(JSPUtil.getParameter(request, prefix + "seal_no1", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrPkgCd(JSPUtil.getParameter(request, prefix + "cntr_pkg_cd", ""));
		setCntrPkgQty(JSPUtil.getParameter(request, prefix + "cntr_pkg_qty", ""));
		setObType(JSPUtil.getParameter(request, prefix + "ob_type", ""));
		setKtPort(JSPUtil.getParameter(request, prefix + "kt_port", ""));
		setCBlNo(JSPUtil.getParameter(request, prefix + "c_bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsKrCntrVO[]
	 */
	public BkgCstmsKrCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgCstmsKrCntrVO[]
	 */
	public BkgCstmsKrCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsKrCntrVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cntrWgtQty = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_qty", length));
			String[] cntrtsCd = (JSPUtil.getParameter(request, prefix	+ "cntrts_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cntrMeaTp = (JSPUtil.getParameter(request, prefix	+ "cntr_mea_tp", length));
			String[] trCd = (JSPUtil.getParameter(request, prefix	+ "tr_cd", length));
			String[] cntrMeaQty = (JSPUtil.getParameter(request, prefix	+ "cntr_mea_qty", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] cntrWgtTp = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_tp", length));
			String[] kcdTp = (JSPUtil.getParameter(request, prefix	+ "kcd_tp", length));
			String[] exptKcdTp = (JSPUtil.getParameter(request, prefix	+ "expt_kcd_tp", length));
			String[] feInd = (JSPUtil.getParameter(request, prefix	+ "fe_ind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ktSeq = (JSPUtil.getParameter(request, prefix	+ "kt_seq", length));
			String[] username = (JSPUtil.getParameter(request, prefix	+ "username", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sealNo2 = (JSPUtil.getParameter(request, prefix	+ "seal_no2", length));
			String[] sealNo1 = (JSPUtil.getParameter(request, prefix	+ "seal_no1", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrPkgCd = (JSPUtil.getParameter(request, prefix	+ "cntr_pkg_cd", length));
			String[] cntrPkgQty = (JSPUtil.getParameter(request, prefix	+ "cntr_pkg_qty", length));
			String[] obType = (JSPUtil.getParameter(request, prefix	+ "ob_type", length));
			String[] ktPort = (JSPUtil.getParameter(request, prefix	+ "kt_port", length));
			String[] cBlNo = (JSPUtil.getParameter(request, prefix	+ "c_bl_no", length));

			for (int i = 0; i < length; i++) {
				model = new BkgCstmsKrCntrVO();
				if (cntrWgtQty[i] != null)
					model.setCntrWgtQty(cntrWgtQty[i]);
				if (cntrtsCd[i] != null)
					model.setCntrtsCd(cntrtsCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cntrMeaTp[i] != null)
					model.setCntrMeaTp(cntrMeaTp[i]);
				if (trCd[i] != null)
					model.setTrCd(trCd[i]);
				if (cntrMeaQty[i] != null)
					model.setCntrMeaQty(cntrMeaQty[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (cntrWgtTp[i] != null)
					model.setCntrWgtTp(cntrWgtTp[i]);
				if (kcdTp[i] != null)
					model.setKcdTp(kcdTp[i]);
				if (exptKcdTp[i] != null)
					model.setExptKcdTp(exptKcdTp[i]);
				if (feInd[i] != null)
					model.setFeInd(feInd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ktSeq[i] != null)
					model.setKtSeq(ktSeq[i]);
				if (username[i] != null)
					model.setUsername(username[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sealNo2[i] != null)
					model.setSealNo2(sealNo2[i]);
				if (sealNo1[i] != null)
					model.setSealNo1(sealNo1[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrPkgCd[i] != null)
					model.setCntrPkgCd(cntrPkgCd[i]);
				if (cntrPkgQty[i] != null)
					model.setCntrPkgQty(cntrPkgQty[i]);
				if (obType[i] != null)
					model.setObType(obType[i]);
				if (ktPort[i] != null)
					model.setKtPort(ktPort[i]);
				if (cBlNo[i] != null)
					model.setCBlNo(cBlNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsKrCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsKrCntrVO[]
	 */
	public BkgCstmsKrCntrVO[] getBkgCstmsKrCntrVOs(){
		BkgCstmsKrCntrVO[] vos = (BkgCstmsKrCntrVO[])models.toArray(new BkgCstmsKrCntrVO[models.size()]);
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
		this.cntrWgtQty = this.cntrWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtsCd = this.cntrtsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMeaTp = this.cntrMeaTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trCd = this.trCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMeaQty = this.cntrMeaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtTp = this.cntrWgtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcdTp = this.kcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptKcdTp = this.exptKcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.feInd = this.feInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktSeq = this.ktSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.username = this.username .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo2 = this.sealNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo1 = this.sealNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkgCd = this.cntrPkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkgQty = this.cntrPkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obType = this.obType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPort = this.ktPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cBlNo = this.cBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
