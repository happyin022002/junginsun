/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCntrInqInfoVO.java
*@FileTitle : KorCntrInqInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.12.11 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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

public class KorCntrInqInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorCntrInqInfoVO> models = new ArrayList<KorCntrInqInfoVO>();
	
	/* Column Info */
	private String kcMeasQty = null;
	/* Column Info */
	private String trnsSeq = null;
	/* Column Info */
	private String kcPckTpCd = null;
	/* Column Info */
	private String kcIbflag = null;
	/* Column Info */
	private String kcTrnsSeq = null;
	/* Column Info */
	private String kcMeasUtCd = null;
	/* Column Info */
	private String kcPckQty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String kcCntrWgt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String kcFullMtyCd = null;
	/* Column Info */
	private String kcCstmsDeclTpCd = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String kcBkgNo = null;
	/* Column Info */
	private String kcWgtUtCd = null;
	/* Column Info */
	private String kcCntrNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String kcCntrSealNo1 = null;
	/* Column Info */
	private String kcCntrSealNo2 = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String kcCntrTpszCd = null;
	/* Column Info */
	private String blNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorCntrInqInfoVO() {}

	public KorCntrInqInfoVO(String pagerows, String kcBkgNo, String kcCstmsDeclTpCd, String kcTrnsSeq, String kcCntrNo, String kcFullMtyCd, String kcCntrTpszCd, String kcCntrSealNo1, String kcCntrSealNo2, String kcPckQty, String kcPckTpCd, String kcCntrWgt, String kcWgtUtCd, String kcMeasQty, String kcMeasUtCd, String trnsSeq, String vvd, String bkgNo, String kcIbflag, String cstmsDeclTpCd, String userId, String portCd, String blNo) {
		this.kcMeasQty = kcMeasQty;
		this.trnsSeq = trnsSeq;
		this.kcPckTpCd = kcPckTpCd;
		this.kcIbflag = kcIbflag;
		this.kcTrnsSeq = kcTrnsSeq;
		this.kcMeasUtCd = kcMeasUtCd;
		this.kcPckQty = kcPckQty;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.kcCntrWgt = kcCntrWgt;
		this.bkgNo = bkgNo;
		this.kcFullMtyCd = kcFullMtyCd;
		this.kcCstmsDeclTpCd = kcCstmsDeclTpCd;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.kcBkgNo = kcBkgNo;
		this.kcWgtUtCd = kcWgtUtCd;
		this.kcCntrNo = kcCntrNo;
		this.userId = userId;
		this.kcCntrSealNo1 = kcCntrSealNo1;
		this.kcCntrSealNo2 = kcCntrSealNo2;
		this.portCd = portCd;
		this.kcCntrTpszCd = kcCntrTpszCd;
		this.blNo = blNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("kc_meas_qty", getKcMeasQty());
		this.hashColumns.put("trns_seq", getTrnsSeq());
		this.hashColumns.put("kc_pck_tp_cd", getKcPckTpCd());
		this.hashColumns.put("kc_ibflag", getKcIbflag());
		this.hashColumns.put("kc_trns_seq", getKcTrnsSeq());
		this.hashColumns.put("kc_meas_ut_cd", getKcMeasUtCd());
		this.hashColumns.put("kc_pck_qty", getKcPckQty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("kc_cntr_wgt", getKcCntrWgt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("kc_full_mty_cd", getKcFullMtyCd());
		this.hashColumns.put("kc_cstms_decl_tp_cd", getKcCstmsDeclTpCd());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("kc_bkg_no", getKcBkgNo());
		this.hashColumns.put("kc_wgt_ut_cd", getKcWgtUtCd());
		this.hashColumns.put("kc_cntr_no", getKcCntrNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("kc_cntr_seal_no1", getKcCntrSealNo1());
		this.hashColumns.put("kc_cntr_seal_no2", getKcCntrSealNo2());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("kc_cntr_tpsz_cd", getKcCntrTpszCd());
		this.hashColumns.put("bl_no", getBlNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("kc_meas_qty", "kcMeasQty");
		this.hashFields.put("trns_seq", "trnsSeq");
		this.hashFields.put("kc_pck_tp_cd", "kcPckTpCd");
		this.hashFields.put("kc_ibflag", "kcIbflag");
		this.hashFields.put("kc_trns_seq", "kcTrnsSeq");
		this.hashFields.put("kc_meas_ut_cd", "kcMeasUtCd");
		this.hashFields.put("kc_pck_qty", "kcPckQty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("kc_cntr_wgt", "kcCntrWgt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("kc_full_mty_cd", "kcFullMtyCd");
		this.hashFields.put("kc_cstms_decl_tp_cd", "kcCstmsDeclTpCd");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("kc_bkg_no", "kcBkgNo");
		this.hashFields.put("kc_wgt_ut_cd", "kcWgtUtCd");
		this.hashFields.put("kc_cntr_no", "kcCntrNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("kc_cntr_seal_no1", "kcCntrSealNo1");
		this.hashFields.put("kc_cntr_seal_no2", "kcCntrSealNo2");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("kc_cntr_tpsz_cd", "kcCntrTpszCd");
		this.hashFields.put("bl_no", "blNo");
		return this.hashFields;
	}
	
	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @return kcMeasQty
	 */
	public String getKcMeasQty() {
		return this.kcMeasQty;
	}
	
	/**
	 * Column Info
	 * @return trnsSeq
	 */
	public String getTrnsSeq() {
		return this.trnsSeq;
	}
	
	/**
	 * Column Info
	 * @return kcPckTpCd
	 */
	public String getKcPckTpCd() {
		return this.kcPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return kcIbflag
	 */
	public String getKcIbflag() {
		return this.kcIbflag;
	}
	
	/**
	 * Column Info
	 * @return kcTrnsSeq
	 */
	public String getKcTrnsSeq() {
		return this.kcTrnsSeq;
	}
	
	/**
	 * Column Info
	 * @return kcMeasUtCd
	 */
	public String getKcMeasUtCd() {
		return this.kcMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @return kcPckQty
	 */
	public String getKcPckQty() {
		return this.kcPckQty;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return kcCntrWgt
	 */
	public String getKcCntrWgt() {
		return this.kcCntrWgt;
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
	 * @return kcFullMtyCd
	 */
	public String getKcFullMtyCd() {
		return this.kcFullMtyCd;
	}
	
	/**
	 * Column Info
	 * @return kcCstmsDeclTpCd
	 */
	public String getKcCstmsDeclTpCd() {
		return this.kcCstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclTpCd
	 */
	public String getCstmsDeclTpCd() {
		return this.cstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return kcBkgNo
	 */
	public String getKcBkgNo() {
		return this.kcBkgNo;
	}
	
	/**
	 * Column Info
	 * @return kcWgtUtCd
	 */
	public String getKcWgtUtCd() {
		return this.kcWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return kcCntrNo
	 */
	public String getKcCntrNo() {
		return this.kcCntrNo;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return kcCntrSealNo1
	 */
	public String getKcCntrSealNo1() {
		return this.kcCntrSealNo1;
	}
	
	/**
	 * Column Info
	 * @return kcCntrSealNo2
	 */
	public String getKcCntrSealNo2() {
		return this.kcCntrSealNo2;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return kcCntrTpszCd
	 */
	public String getKcCntrTpszCd() {
		return this.kcCntrTpszCd;
	}
	

	/**
	 * Column Info
	 * @param kcMeasQty
	 */
	public void setKcMeasQty(String kcMeasQty) {
		this.kcMeasQty = kcMeasQty;
	}
	
	/**
	 * Column Info
	 * @param trnsSeq
	 */
	public void setTrnsSeq(String trnsSeq) {
		this.trnsSeq = trnsSeq;
	}
	
	/**
	 * Column Info
	 * @param kcPckTpCd
	 */
	public void setKcPckTpCd(String kcPckTpCd) {
		this.kcPckTpCd = kcPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param kcIbflag
	 */
	public void setKcIbflag(String kcIbflag) {
		this.kcIbflag = kcIbflag;
	}
	
	/**
	 * Column Info
	 * @param kcTrnsSeq
	 */
	public void setKcTrnsSeq(String kcTrnsSeq) {
		this.kcTrnsSeq = kcTrnsSeq;
	}
	
	/**
	 * Column Info
	 * @param kcMeasUtCd
	 */
	public void setKcMeasUtCd(String kcMeasUtCd) {
		this.kcMeasUtCd = kcMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param kcPckQty
	 */
	public void setKcPckQty(String kcPckQty) {
		this.kcPckQty = kcPckQty;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param kcCntrWgt
	 */
	public void setKcCntrWgt(String kcCntrWgt) {
		this.kcCntrWgt = kcCntrWgt;
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
	 * @param kcFullMtyCd
	 */
	public void setKcFullMtyCd(String kcFullMtyCd) {
		this.kcFullMtyCd = kcFullMtyCd;
	}
	
	/**
	 * Column Info
	 * @param kcCstmsDeclTpCd
	 */
	public void setKcCstmsDeclTpCd(String kcCstmsDeclTpCd) {
		this.kcCstmsDeclTpCd = kcCstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclTpCd
	 */
	public void setCstmsDeclTpCd(String cstmsDeclTpCd) {
		this.cstmsDeclTpCd = cstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param kcBkgNo
	 */
	public void setKcBkgNo(String kcBkgNo) {
		this.kcBkgNo = kcBkgNo;
	}
	
	/**
	 * Column Info
	 * @param kcWgtUtCd
	 */
	public void setKcWgtUtCd(String kcWgtUtCd) {
		this.kcWgtUtCd = kcWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param kcCntrNo
	 */
	public void setKcCntrNo(String kcCntrNo) {
		this.kcCntrNo = kcCntrNo;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param kcCntrSealNo1
	 */
	public void setKcCntrSealNo1(String kcCntrSealNo1) {
		this.kcCntrSealNo1 = kcCntrSealNo1;
	}
	
	/**
	 * Column Info
	 * @param kcCntrSealNo2
	 */
	public void setKcCntrSealNo2(String kcCntrSealNo2) {
		this.kcCntrSealNo2 = kcCntrSealNo2;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param kcCntrTpszCd
	 */
	public void setKcCntrTpszCd(String kcCntrTpszCd) {
		this.kcCntrTpszCd = kcCntrTpszCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setKcMeasQty(JSPUtil.getParameter(request, "kc_meas_qty", ""));
		setTrnsSeq(JSPUtil.getParameter(request, "trns_seq", ""));
		setKcPckTpCd(JSPUtil.getParameter(request, "kc_pck_tp_cd", ""));
		setKcIbflag(JSPUtil.getParameter(request, "kc_ibflag", ""));
		setKcTrnsSeq(JSPUtil.getParameter(request, "kc_trns_seq", ""));
		setKcMeasUtCd(JSPUtil.getParameter(request, "kc_meas_ut_cd", ""));
		setKcPckQty(JSPUtil.getParameter(request, "kc_pck_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setKcCntrWgt(JSPUtil.getParameter(request, "kc_cntr_wgt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setKcFullMtyCd(JSPUtil.getParameter(request, "kc_full_mty_cd", ""));
		setKcCstmsDeclTpCd(JSPUtil.getParameter(request, "kc_cstms_decl_tp_cd", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, "cstms_decl_tp_cd", ""));
		setKcBkgNo(JSPUtil.getParameter(request, "kc_bkg_no", ""));
		setKcWgtUtCd(JSPUtil.getParameter(request, "kc_wgt_ut_cd", ""));
		setKcCntrNo(JSPUtil.getParameter(request, "kc_cntr_no", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setKcCntrSealNo1(JSPUtil.getParameter(request, "kc_cntr_seal_no1", ""));
		setKcCntrSealNo2(JSPUtil.getParameter(request, "kc_cntr_seal_no2", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setKcCntrTpszCd(JSPUtil.getParameter(request, "kc_cntr_tpsz_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCntrInqInfoVO[]
	 */
	public KorCntrInqInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorCntrInqInfoVO[]
	 */
	public KorCntrInqInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCntrInqInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "kc_ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "kc_ibflag").length;
  
		try {
			String[] kcMeasQty = (JSPUtil.getParameter(request, prefix	+ "kc_meas_qty", length));
			String[] trnsSeq = (JSPUtil.getParameter(request, prefix	+ "trns_seq", length));
			String[] kcPckTpCd = (JSPUtil.getParameter(request, prefix	+ "kc_pck_tp_cd", length));
			String[] kcIbflag = (JSPUtil.getParameter(request, prefix	+ "kc_ibflag", length));
			String[] kcTrnsSeq = (JSPUtil.getParameter(request, prefix	+ "kc_trns_seq", length));
			String[] kcMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "kc_meas_ut_cd", length));
			String[] kcPckQty = (JSPUtil.getParameter(request, prefix	+ "kc_pck_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] kcCntrWgt = (JSPUtil.getParameter(request, prefix	+ "kc_cntr_wgt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] kcFullMtyCd = (JSPUtil.getParameter(request, prefix	+ "kc_full_mty_cd", length));
			String[] kcCstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "kc_cstms_decl_tp_cd", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] kcBkgNo = (JSPUtil.getParameter(request, prefix	+ "kc_bkg_no", length));
			String[] kcWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "kc_wgt_ut_cd", length));
			String[] kcCntrNo = (JSPUtil.getParameter(request, prefix	+ "kc_cntr_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] kcCntrSealNo1 = (JSPUtil.getParameter(request, prefix	+ "kc_cntr_seal_no1", length));
			String[] kcCntrSealNo2 = (JSPUtil.getParameter(request, prefix	+ "kc_cntr_seal_no2", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] kcCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "kc_cntr_tpsz_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorCntrInqInfoVO();
				if (kcMeasQty[i] != null)
					model.setKcMeasQty(kcMeasQty[i]);
				if (trnsSeq[i] != null)
					model.setTrnsSeq(trnsSeq[i]);
				if (kcPckTpCd[i] != null)
					model.setKcPckTpCd(kcPckTpCd[i]);
				if (kcIbflag[i] != null)
					model.setKcIbflag(kcIbflag[i]);
				if (kcTrnsSeq[i] != null)
					model.setKcTrnsSeq(kcTrnsSeq[i]);
				if (kcMeasUtCd[i] != null)
					model.setKcMeasUtCd(kcMeasUtCd[i]);
				if (kcPckQty[i] != null)
					model.setKcPckQty(kcPckQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (kcCntrWgt[i] != null)
					model.setKcCntrWgt(kcCntrWgt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (kcFullMtyCd[i] != null)
					model.setKcFullMtyCd(kcFullMtyCd[i]);
				if (kcCstmsDeclTpCd[i] != null)
					model.setKcCstmsDeclTpCd(kcCstmsDeclTpCd[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (kcBkgNo[i] != null)
					model.setKcBkgNo(kcBkgNo[i]);
				if (kcWgtUtCd[i] != null)
					model.setKcWgtUtCd(kcWgtUtCd[i]);
				if (kcCntrNo[i] != null)
					model.setKcCntrNo(kcCntrNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (kcCntrSealNo1[i] != null)
					model.setKcCntrSealNo1(kcCntrSealNo1[i]);
				if (kcCntrSealNo2[i] != null)
					model.setKcCntrSealNo2(kcCntrSealNo2[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (kcCntrTpszCd[i] != null)
					model.setKcCntrTpszCd(kcCntrTpszCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCntrInqInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCntrInqInfoVO[]
	 */
	public KorCntrInqInfoVO[] getKorCntrInqInfoVOs(){
		KorCntrInqInfoVO[] vos = (KorCntrInqInfoVO[])models.toArray(new KorCntrInqInfoVO[models.size()]);
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
		this.kcMeasQty = this.kcMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsSeq = this.trnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcPckTpCd = this.kcPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcIbflag = this.kcIbflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcTrnsSeq = this.kcTrnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcMeasUtCd = this.kcMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcPckQty = this.kcPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcCntrWgt = this.kcCntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcFullMtyCd = this.kcFullMtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcCstmsDeclTpCd = this.kcCstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcBkgNo = this.kcBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcWgtUtCd = this.kcWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcCntrNo = this.kcCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcCntrSealNo1 = this.kcCntrSealNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcCntrSealNo2 = this.kcCntrSealNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcCntrTpszCd = this.kcCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
