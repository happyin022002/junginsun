/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndCstmsVesselInfoVO.java
*@FileTitle : CndCstmsVesselInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.08.10 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselInfoVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CndCstmsVesselInfoVO extends VesselInfoVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsVesselInfoVO> models = new ArrayList<CndCstmsVesselInfoVO>();
	
	/* Column Info */
	private String netRgstTongWgt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String rgstPortCd = null;
	/* Column Info */
	private String expiryDt = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String loaLen = null;
	/* Column Info */
	private String grsRgstTongWgt = null;
	/* Column Info */
	private String dwtWgt = null;
	/* Column Info */
	private String crwKnt = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String vslSftEqCertiExpDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslDeratCertiExpDt = null;
	/* Column Info */
	private String vslSftCstruCertiExpDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String certCd = null;
	/* Column Info */
	private String vslLodLineCertiExpDt = null;
	/* Column Info */
	private String vslSftRdoCertiExpDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rgstNo = null;
	/* Column Info */
	private String rgstDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsVesselInfoVO() {}

	public CndCstmsVesselInfoVO(String ibflag, String pagerows, String vslCd, String lloydNo, String vslRgstCntCd, String vslEngNm, String rgstPortCd, String rgstNo, String rgstDt, String grsRgstTongWgt, String netRgstTongWgt, String dwtWgt, String crwKnt, String callSgnNo, String loaLen, String vslSftCstruCertiExpDt, String vslSftRdoCertiExpDt, String vslSftEqCertiExpDt, String vslLodLineCertiExpDt, String vslDeratCertiExpDt, String crrCd, String updUsrId, String expiryDt, String certCd) {
		this.netRgstTongWgt = netRgstTongWgt;
		this.vslCd = vslCd;
		this.rgstPortCd = rgstPortCd;
		this.expiryDt = expiryDt;
		this.callSgnNo = callSgnNo;
		this.loaLen = loaLen;
		this.grsRgstTongWgt = grsRgstTongWgt;
		this.dwtWgt = dwtWgt;
		this.crwKnt = crwKnt;
		this.crrCd = crrCd;
		this.vslSftEqCertiExpDt = vslSftEqCertiExpDt;
		this.pagerows = pagerows;
		this.vslDeratCertiExpDt = vslDeratCertiExpDt;
		this.vslSftCstruCertiExpDt = vslSftCstruCertiExpDt;
		this.ibflag = ibflag;
		this.lloydNo = lloydNo;
		this.vslRgstCntCd = vslRgstCntCd;
		this.vslEngNm = vslEngNm;
		this.certCd = certCd;
		this.vslLodLineCertiExpDt = vslLodLineCertiExpDt;
		this.vslSftRdoCertiExpDt = vslSftRdoCertiExpDt;
		this.updUsrId = updUsrId;
		this.rgstNo = rgstNo;
		this.rgstDt = rgstDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("net_rgst_tong_wgt", getNetRgstTongWgt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rgst_port_cd", getRgstPortCd());
		this.hashColumns.put("expiry_dt", getExpiryDt());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("loa_len", getLoaLen());
		this.hashColumns.put("grs_rgst_tong_wgt", getGrsRgstTongWgt());
		this.hashColumns.put("dwt_wgt", getDwtWgt());
		this.hashColumns.put("crw_knt", getCrwKnt());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("vsl_sft_eq_certi_exp_dt", getVslSftEqCertiExpDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_derat_certi_exp_dt", getVslDeratCertiExpDt());
		this.hashColumns.put("vsl_sft_cstru_certi_exp_dt", getVslSftCstruCertiExpDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("cert_cd", getCertCd());
		this.hashColumns.put("vsl_lod_line_certi_exp_dt", getVslLodLineCertiExpDt());
		this.hashColumns.put("vsl_sft_rdo_certi_exp_dt", getVslSftRdoCertiExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rgst_no", getRgstNo());
		this.hashColumns.put("rgst_dt", getRgstDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("net_rgst_tong_wgt", "netRgstTongWgt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rgst_port_cd", "rgstPortCd");
		this.hashFields.put("expiry_dt", "expiryDt");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("loa_len", "loaLen");
		this.hashFields.put("grs_rgst_tong_wgt", "grsRgstTongWgt");
		this.hashFields.put("dwt_wgt", "dwtWgt");
		this.hashFields.put("crw_knt", "crwKnt");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("vsl_sft_eq_certi_exp_dt", "vslSftEqCertiExpDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_derat_certi_exp_dt", "vslDeratCertiExpDt");
		this.hashFields.put("vsl_sft_cstru_certi_exp_dt", "vslSftCstruCertiExpDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("cert_cd", "certCd");
		this.hashFields.put("vsl_lod_line_certi_exp_dt", "vslLodLineCertiExpDt");
		this.hashFields.put("vsl_sft_rdo_certi_exp_dt", "vslSftRdoCertiExpDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rgst_no", "rgstNo");
		this.hashFields.put("rgst_dt", "rgstDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return netRgstTongWgt
	 */
	public String getNetRgstTongWgt() {
		return this.netRgstTongWgt;
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
	 * @return rgstPortCd
	 */
	public String getRgstPortCd() {
		return this.rgstPortCd;
	}
	
	/**
	 * Column Info
	 * @return expiryDt
	 */
	public String getExpiryDt() {
		return this.expiryDt;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return loaLen
	 */
	public String getLoaLen() {
		return this.loaLen;
	}
	
	/**
	 * Column Info
	 * @return grsRgstTongWgt
	 */
	public String getGrsRgstTongWgt() {
		return this.grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @return dwtWgt
	 */
	public String getDwtWgt() {
		return this.dwtWgt;
	}
	
	/**
	 * Column Info
	 * @return crwKnt
	 */
	public String getCrwKnt() {
		return this.crwKnt;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return vslSftEqCertiExpDt
	 */
	public String getVslSftEqCertiExpDt() {
		return this.vslSftEqCertiExpDt;
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
	 * @return vslDeratCertiExpDt
	 */
	public String getVslDeratCertiExpDt() {
		return this.vslDeratCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @return vslSftCstruCertiExpDt
	 */
	public String getVslSftCstruCertiExpDt() {
		return this.vslSftCstruCertiExpDt;
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
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return vslRgstCntCd
	 */
	public String getVslRgstCntCd() {
		return this.vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return certCd
	 */
	public String getCertCd() {
		return this.certCd;
	}
	
	/**
	 * Column Info
	 * @return vslLodLineCertiExpDt
	 */
	public String getVslLodLineCertiExpDt() {
		return this.vslLodLineCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @return vslSftRdoCertiExpDt
	 */
	public String getVslSftRdoCertiExpDt() {
		return this.vslSftRdoCertiExpDt;
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
	 * @return rgstNo
	 */
	public String getRgstNo() {
		return this.rgstNo;
	}
	
	/**
	 * Column Info
	 * @return rgstDt
	 */
	public String getRgstDt() {
		return this.rgstDt;
	}
	

	/**
	 * Column Info
	 * @param netRgstTongWgt
	 */
	public void setNetRgstTongWgt(String netRgstTongWgt) {
		this.netRgstTongWgt = netRgstTongWgt;
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
	 * @param rgstPortCd
	 */
	public void setRgstPortCd(String rgstPortCd) {
		this.rgstPortCd = rgstPortCd;
	}
	
	/**
	 * Column Info
	 * @param expiryDt
	 */
	public void setExpiryDt(String expiryDt) {
		this.expiryDt = expiryDt;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param loaLen
	 */
	public void setLoaLen(String loaLen) {
		this.loaLen = loaLen;
	}
	
	/**
	 * Column Info
	 * @param grsRgstTongWgt
	 */
	public void setGrsRgstTongWgt(String grsRgstTongWgt) {
		this.grsRgstTongWgt = grsRgstTongWgt;
	}
	
	/**
	 * Column Info
	 * @param dwtWgt
	 */
	public void setDwtWgt(String dwtWgt) {
		this.dwtWgt = dwtWgt;
	}
	
	/**
	 * Column Info
	 * @param crwKnt
	 */
	public void setCrwKnt(String crwKnt) {
		this.crwKnt = crwKnt;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param vslSftEqCertiExpDt
	 */
	public void setVslSftEqCertiExpDt(String vslSftEqCertiExpDt) {
		this.vslSftEqCertiExpDt = vslSftEqCertiExpDt;
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
	 * @param vslDeratCertiExpDt
	 */
	public void setVslDeratCertiExpDt(String vslDeratCertiExpDt) {
		this.vslDeratCertiExpDt = vslDeratCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @param vslSftCstruCertiExpDt
	 */
	public void setVslSftCstruCertiExpDt(String vslSftCstruCertiExpDt) {
		this.vslSftCstruCertiExpDt = vslSftCstruCertiExpDt;
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
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param vslRgstCntCd
	 */
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param certCd
	 */
	public void setCertCd(String certCd) {
		this.certCd = certCd;
	}
	
	/**
	 * Column Info
	 * @param vslLodLineCertiExpDt
	 */
	public void setVslLodLineCertiExpDt(String vslLodLineCertiExpDt) {
		this.vslLodLineCertiExpDt = vslLodLineCertiExpDt;
	}
	
	/**
	 * Column Info
	 * @param vslSftRdoCertiExpDt
	 */
	public void setVslSftRdoCertiExpDt(String vslSftRdoCertiExpDt) {
		this.vslSftRdoCertiExpDt = vslSftRdoCertiExpDt;
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
	 * @param rgstNo
	 */
	public void setRgstNo(String rgstNo) {
		this.rgstNo = rgstNo;
	}
	
	/**
	 * Column Info
	 * @param rgstDt
	 */
	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNetRgstTongWgt(JSPUtil.getParameter(request, "net_rgst_tong_wgt", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setRgstPortCd(JSPUtil.getParameter(request, "rgst_port_cd", ""));
		setExpiryDt(JSPUtil.getParameter(request, "expiry_dt", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setLoaLen(JSPUtil.getParameter(request, "loa_len", ""));
		setGrsRgstTongWgt(JSPUtil.getParameter(request, "grs_rgst_tong_wgt", ""));
		setDwtWgt(JSPUtil.getParameter(request, "dwt_wgt", ""));
		setCrwKnt(JSPUtil.getParameter(request, "crw_knt", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setVslSftEqCertiExpDt(JSPUtil.getParameter(request, "vsl_sft_eq_certi_exp_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVslDeratCertiExpDt(JSPUtil.getParameter(request, "vsl_derat_certi_exp_dt", ""));
		setVslSftCstruCertiExpDt(JSPUtil.getParameter(request, "vsl_sft_cstru_certi_exp_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLloydNo(JSPUtil.getParameter(request, "lloyd_no", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, "vsl_rgst_cnt_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setCertCd(JSPUtil.getParameter(request, "cert_cd", ""));
		setVslLodLineCertiExpDt(JSPUtil.getParameter(request, "vsl_lod_line_certi_exp_dt", ""));
		setVslSftRdoCertiExpDt(JSPUtil.getParameter(request, "vsl_sft_rdo_certi_exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRgstNo(JSPUtil.getParameter(request, "rgst_no", ""));
		setRgstDt(JSPUtil.getParameter(request, "rgst_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsVesselInfoVO[]
	 */
	public CndCstmsVesselInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsVesselInfoVO[]
	 */
	public CndCstmsVesselInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsVesselInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] netRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "net_rgst_tong_wgt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] rgstPortCd = (JSPUtil.getParameter(request, prefix	+ "rgst_port_cd", length));
			String[] expiryDt = (JSPUtil.getParameter(request, prefix	+ "expiry_dt", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] loaLen = (JSPUtil.getParameter(request, prefix	+ "loa_len", length));
			String[] grsRgstTongWgt = (JSPUtil.getParameter(request, prefix	+ "grs_rgst_tong_wgt", length));
			String[] dwtWgt = (JSPUtil.getParameter(request, prefix	+ "dwt_wgt", length));
			String[] crwKnt = (JSPUtil.getParameter(request, prefix	+ "crw_knt", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] vslSftEqCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_sft_eq_certi_exp_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vslDeratCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_derat_certi_exp_dt", length));
			String[] vslSftCstruCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_sft_cstru_certi_exp_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] certCd = (JSPUtil.getParameter(request, prefix	+ "cert_cd", length));
			String[] vslLodLineCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_lod_line_certi_exp_dt", length));
			String[] vslSftRdoCertiExpDt = (JSPUtil.getParameter(request, prefix	+ "vsl_sft_rdo_certi_exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rgstNo = (JSPUtil.getParameter(request, prefix	+ "rgst_no", length));
			String[] rgstDt = (JSPUtil.getParameter(request, prefix	+ "rgst_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsVesselInfoVO();
				if (netRgstTongWgt[i] != null)
					model.setNetRgstTongWgt(netRgstTongWgt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (rgstPortCd[i] != null)
					model.setRgstPortCd(rgstPortCd[i]);
				if (expiryDt[i] != null)
					model.setExpiryDt(expiryDt[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (loaLen[i] != null)
					model.setLoaLen(loaLen[i]);
				if (grsRgstTongWgt[i] != null)
					model.setGrsRgstTongWgt(grsRgstTongWgt[i]);
				if (dwtWgt[i] != null)
					model.setDwtWgt(dwtWgt[i]);
				if (crwKnt[i] != null)
					model.setCrwKnt(crwKnt[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (vslSftEqCertiExpDt[i] != null)
					model.setVslSftEqCertiExpDt(vslSftEqCertiExpDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslDeratCertiExpDt[i] != null)
					model.setVslDeratCertiExpDt(vslDeratCertiExpDt[i]);
				if (vslSftCstruCertiExpDt[i] != null)
					model.setVslSftCstruCertiExpDt(vslSftCstruCertiExpDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (certCd[i] != null)
					model.setCertCd(certCd[i]);
				if (vslLodLineCertiExpDt[i] != null)
					model.setVslLodLineCertiExpDt(vslLodLineCertiExpDt[i]);
				if (vslSftRdoCertiExpDt[i] != null)
					model.setVslSftRdoCertiExpDt(vslSftRdoCertiExpDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rgstNo[i] != null)
					model.setRgstNo(rgstNo[i]);
				if (rgstDt[i] != null)
					model.setRgstDt(rgstDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsVesselInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsVesselInfoVO[]
	 */
	public CndCstmsVesselInfoVO[] getCndCstmsVesselInfoVOs(){
		CndCstmsVesselInfoVO[] vos = (CndCstmsVesselInfoVO[])models.toArray(new CndCstmsVesselInfoVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.netRgstTongWgt = this.netRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstPortCd = this.rgstPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expiryDt = this.expiryDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loaLen = this.loaLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRgstTongWgt = this.grsRgstTongWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwtWgt = this.dwtWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crwKnt = this.crwKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSftEqCertiExpDt = this.vslSftEqCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDeratCertiExpDt = this.vslDeratCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSftCstruCertiExpDt = this.vslSftCstruCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certCd = this.certCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLodLineCertiExpDt = this.vslLodLineCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSftRdoCertiExpDt = this.vslSftRdoCertiExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstNo = this.rgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstDt = this.rgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
