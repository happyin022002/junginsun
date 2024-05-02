/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorDischCYVO.java
*@FileTitle : KorDischCYVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.14 박상훈
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.DischCYVO;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see DischCYVO
 */

public class KorDischCYVO extends DischCYVO {

	private static final long serialVersionUID = 1L;

	private Collection<KorDischCYVO> models = new ArrayList<KorDischCYVO>();

	/* Column Info */
	private String cstmsDchgLocWhCd = null;
	/* Column Info */
	private String bdrCngFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String custNNm = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String whName = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String blTp = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String krCstmsBlTpCd = null;
	/* Column Info */
	private String cstmsClrTpCd = null;
	/* Column Info */
	private String mfSeqNo = null;
	/* Column Info */
	private String mrnBlTsCd = null;
	/* Column Info */
	private String custCNm = null;
	/* Column Info */
	private String fnlPodCd= null;
	/* Column Info */
	private String cstmsDesc= null;
	/* Column Info */
	private String imdgClssCd= null;
	/* Column Info */
	private String mfRefNo= null;
	/* Column Info */
	private String mrnNo= null;
	/* Column Info */
	private String mrnChkNo= null;
	/* Column Info */
	private String vvd= null;
	/* Column Info */
	private String portCd= null;
	/* Column Info */
	private String conVvd= null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorDischCYVO() {}

	public KorDischCYVO(String ibflag, String pagerows, String mfSeqNo, String bkgNo, String blNo, String mrnBlTsCd, String polCd, String podCd, String krCstmsBlTpCd, String cstmsDchgLocWhCd, String blTpCd, String blTp, String cstmsClrTpCd, String bdrFlg, String bdrCngFlg, String bkgStsCd, String custNNm, String custCNm, String whName, String fnlPodCd, String cstmsDesc, String imdgClssCd, String mfRefNo, String mrnNo, String mrnChkNo, String vvd, String portCd, String conVvd) {
		this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
		this.bdrCngFlg = bdrCngFlg;
		this.bkgStsCd = bkgStsCd;
		this.bdrFlg = bdrFlg;
		this.custNNm = custNNm;
		this.blNo = blNo;
		this.whName = whName;
		this.pagerows = pagerows;
		this.blTpCd = blTpCd;
		this.blTp = blTp;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.krCstmsBlTpCd = krCstmsBlTpCd;
		this.cstmsClrTpCd = cstmsClrTpCd;
		this.mfSeqNo = mfSeqNo;
		this.mrnBlTsCd = mrnBlTsCd;
		this.custCNm = custCNm;
		this.fnlPodCd = fnlPodCd;
		this.cstmsDesc = cstmsDesc;
		this.imdgClssCd = imdgClssCd;
		this.mfRefNo = mfRefNo;
		this.mrnNo = mrnNo;
		this.mrnChkNo = mrnChkNo;
		this.vvd = vvd;
		this.portCd = portCd;
		this.conVvd = conVvd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_dchg_loc_wh_cd", getCstmsDchgLocWhCd());
		this.hashColumns.put("bdr_cng_flg", getBdrCngFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("cust_n_nm", getCustNNm());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("wh_name", getWhName());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("bl_tp", getBlTp());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("kr_cstms_bl_tp_cd", getKrCstmsBlTpCd());
		this.hashColumns.put("cstms_clr_tp_cd", getCstmsClrTpCd());
		this.hashColumns.put("mf_seq_no", getMfSeqNo());
		this.hashColumns.put("mrn_bl_ts_cd", getMrnBlTsCd());
		this.hashColumns.put("cust_c_nm", getCustCNm());
		this.hashColumns.put("fnl_pod_cd", getFnlPodCd());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("mf_ref_no", getMfRefNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("mrn_chk_no", getMrnChkNo());
		this.hashColumns.put("con_vvd", getConVvd());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_dchg_loc_wh_cd", "cstmsDchgLocWhCd");
		this.hashFields.put("bdr_cng_flg", "bdrCngFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("cust_n_nm", "custNNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("wh_name", "whName");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("bl_tp", "blTp");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("kr_cstms_bl_tp_cd", "krCstmsBlTpCd");
		this.hashFields.put("cstms_clr_tp_cd", "cstmsClrTpCd");
		this.hashFields.put("mf_seq_no", "mfSeqNo");
		this.hashFields.put("mrn_bl_ts_cd", "mrnBlTsCd");
		this.hashFields.put("cust_c_nm", "custCNm");
		this.hashFields.put("fnl_pod_cd", "fnlPodCd");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("mf_ref_no", "mfRefNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("mrn_chk_no", "mrnChkNo");
		this.hashFields.put("con_vvd", "conVvd");

		return this.hashFields;
	}

	/**
	 * @return the mfRefNo
	 */
	public String getMfRefNo() {
		return mfRefNo;
	}

	/**
	 * @return the mrnNo
	 */
	public String getMrnNo() {
		return mrnNo;
	}

	/**
	 * @param mrnNo the mrnNo to set
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	/**
	 * @return the mrnChkNo
	 */
	public String getMrnChkNo() {
		return mrnChkNo;
	}

	/**
	 * @param mrnChkNo the mrnChkNo to set
	 */
	public void setMrnChkNo(String mrnChkNo) {
		this.mrnChkNo = mrnChkNo;
	}

	/**
	 * @return the vvd
	 */
	public String getVvd() {
		return vvd;
	}

	/**
	 * @param vvd the vvd to set
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * @return the portCd
	 */
	public String getPortCd() {
		return portCd;
	}

	/**
	 * @param portCd the portCd to set
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * @param mfRefNo the mfRefNo to set
	 */
	public void setMfRefNo(String mfRefNo) {
		this.mfRefNo = mfRefNo;
	}

	/**
	 * @return the imdgClssCd
	 */
	public String getImdgClssCd() {
		return imdgClssCd;
	}

	/**
	 * @param imdgClssCd the imdgClssCd to set
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}

	/**
	 * @return the fnlPodCd
	 */
	public String getFnlPodCd() {
		return fnlPodCd;
	}

	/**
	 * @param fnlPodCd the fnlPodCd to set
	 */
	public void setFnlPodCd(String fnlPodCd) {
		this.fnlPodCd = fnlPodCd;
	}

	/**
	 * @return the cstmsDesc
	 */
	public String getCstmsDesc() {
		return cstmsDesc;
	}

	/**
	 * @param cstmsDesc the cstmsDesc to set
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
	}

	/**
	 * Column Info
	 * @return cstmsDchgLocWhCd
	 */
	public String getCstmsDchgLocWhCd() {
		return this.cstmsDchgLocWhCd;
	}

	/**
	 * Column Info
	 * @return bdrCngFlg
	 */
	public String getBdrCngFlg() {
		return this.bdrCngFlg;
	}

	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}

	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}

	/**
	 * Column Info
	 * @return custNNm
	 */
	public String getCustNNm() {
		return this.custNNm;
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
	 * @return whName
	 */
	public String getWhName() {
		return this.whName;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}

	/**
	 * Column Info
	 * @return blTp
	 */
	public String getBlTp() {
		return this.blTp;
	}

	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * Column Info
	 * @return krCstmsBlTpCd
	 */
	public String getKrCstmsBlTpCd() {
		return this.krCstmsBlTpCd;
	}

	/**
	 * Column Info
	 * @return cstmsClrTpCd
	 */
	public String getCstmsClrTpCd() {
		return this.cstmsClrTpCd;
	}

	/**
	 * Column Info
	 * @return mfSeqNo
	 */
	public String getMfSeqNo() {
		return this.mfSeqNo;
	}

	/**
	 * Column Info
	 * @return mrnBlTsCd
	 */
	public String getMrnBlTsCd() {
		return this.mrnBlTsCd;
	}

	/**
	 * Column Info
	 * @return custCNm
	 */
	public String getCustCNm() {
		return this.custCNm;
	}

	/**
	 * Column Info
	 * @return custCNm
	 */
	public String getConVvd() {
		return this.conVvd;
	}

	/**
	 * Column Info
	 * @param cstmsDchgLocWhCd
	 */
	public void setCstmsDchgLocWhCd(String cstmsDchgLocWhCd) {
		this.cstmsDchgLocWhCd = cstmsDchgLocWhCd;
	}

	/**
	 * Column Info
	 * @param bdrCngFlg
	 */
	public void setBdrCngFlg(String bdrCngFlg) {
		this.bdrCngFlg = bdrCngFlg;
	}

	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}

	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}

	/**
	 * Column Info
	 * @param custNNm
	 */
	public void setCustNNm(String custNNm) {
		this.custNNm = custNNm;
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
	 * @param whName
	 */
	public void setWhName(String whName) {
		this.whName = whName;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}

	/**
	 * Column Info
	 * @param blTp
	 */
	public void setBlTp(String blTp) {
		this.blTp = blTp;
	}

	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Column Info
	 * @param krCstmsBlTpCd
	 */
	public void setKrCstmsBlTpCd(String krCstmsBlTpCd) {
		this.krCstmsBlTpCd = krCstmsBlTpCd;
	}

	/**
	 * Column Info
	 * @param cstmsClrTpCd
	 */
	public void setCstmsClrTpCd(String cstmsClrTpCd) {
		this.cstmsClrTpCd = cstmsClrTpCd;
	}

	/**
	 * Column Info
	 * @param mfSeqNo
	 */
	public void setMfSeqNo(String mfSeqNo) {
		this.mfSeqNo = mfSeqNo;
	}

	/**
	 * Column Info
	 * @param mrnBlTsCd
	 */
	public void setMrnBlTsCd(String mrnBlTsCd) {
		this.mrnBlTsCd = mrnBlTsCd;
	}

	/**
	 * Column Info
	 * @param custCNm
	 */
	public void setCustCNm(String custCNm) {
		this.custCNm = custCNm;
	}

	/**
	 * Column Info
	 * @param custCNm
	 */
	public void setConVvd(String conVvd) {
		this.conVvd = conVvd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCstmsDchgLocWhCd(JSPUtil.getParameter(request, "cstms_dchg_loc_wh_cd", ""));
		setBdrCngFlg(JSPUtil.getParameter(request, "bdr_cng_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, "bdr_flg", ""));
		setCustNNm(JSPUtil.getParameter(request, "cust_n_nm", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setWhName(JSPUtil.getParameter(request, "wh_name", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setBlTp(JSPUtil.getParameter(request, "bl_tp", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setKrCstmsBlTpCd(JSPUtil.getParameter(request, "kr_cstms_bl_tp_cd", ""));
		setCstmsClrTpCd(JSPUtil.getParameter(request, "cstms_clr_tp_cd", ""));
		setMfSeqNo(JSPUtil.getParameter(request, "mf_seq_no", ""));
		setMrnBlTsCd(JSPUtil.getParameter(request, "mrn_bl_ts_cd", ""));
		setCustCNm(JSPUtil.getParameter(request, "cust_c_nm", ""));
		setFnlPodCd(JSPUtil.getParameter(request, "fnl_pod_cd", ""));
		setCstmsDesc(JSPUtil.getParameter(request, "cstms_desc", ""));
		setImdgClssCd(JSPUtil.getParameter(request, "imdg_clss_cd", ""));
		setMfRefNo(JSPUtil.getParameter(request, "mf_ref_no", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setMrnChkNo(JSPUtil.getParameter(request, "mrn_chk_no", ""));
		setConVvd(JSPUtil.getParameter(request, "con_vvd", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorDischCYVO[]
	 */
	public KorDischCYVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorDischCYVO[]
	 */
	public KorDischCYVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorDischCYVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] cstmsDchgLocWhCd = (JSPUtil.getParameter(request, prefix	+ "cstms_dchg_loc_wh_cd", length));
			String[] bdrCngFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_cng_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] custNNm = (JSPUtil.getParameter(request, prefix	+ "cust_n_nm", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] whName = (JSPUtil.getParameter(request, prefix	+ "wh_name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] blTp = (JSPUtil.getParameter(request, prefix	+ "bl_tp", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] krCstmsBlTpCd = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_bl_tp_cd", length));
			String[] cstmsClrTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_tp_cd", length));
			String[] mfSeqNo = (JSPUtil.getParameter(request, prefix	+ "mf_seq_no", length));
			String[] mrnBlTsCd = (JSPUtil.getParameter(request, prefix	+ "mrn_bl_ts_cd", length));
			String[] custCNm = (JSPUtil.getParameter(request, prefix	+ "cust_c_nm", length));
			String[] fnlPodCd = (JSPUtil.getParameter(request, prefix	+ "fnl_pod_cd", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] mfRefNo = (JSPUtil.getParameter(request, prefix	+ "mf_ref_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] mrnChkNo = (JSPUtil.getParameter(request, prefix	+ "mrn_chk_no", length));
			String[] conVvd = (JSPUtil.getParameter(request, prefix	+ "con_vvd", length));

			for (int i = 0; i < length; i++) {
				model = new KorDischCYVO();
				if (cstmsDchgLocWhCd[i] != null)
					model.setCstmsDchgLocWhCd(cstmsDchgLocWhCd[i]);
				if (bdrCngFlg[i] != null)
					model.setBdrCngFlg(bdrCngFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (custNNm[i] != null)
					model.setCustNNm(custNNm[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (whName[i] != null)
					model.setWhName(whName[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (blTp[i] != null)
					model.setBlTp(blTp[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (krCstmsBlTpCd[i] != null)
					model.setKrCstmsBlTpCd(krCstmsBlTpCd[i]);
				if (cstmsClrTpCd[i] != null)
					model.setCstmsClrTpCd(cstmsClrTpCd[i]);
				if (mfSeqNo[i] != null)
					model.setMfSeqNo(mfSeqNo[i]);
				if (mrnBlTsCd[i] != null)
					model.setMrnBlTsCd(mrnBlTsCd[i]);
				if (custCNm[i] != null)
					model.setCustCNm(custCNm[i]);
				if (fnlPodCd[i] != null)
					model.setFnlPodCd(fnlPodCd[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (mfRefNo[i] != null)
					model.setMfRefNo(mfRefNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (mrnChkNo[i] != null)
					model.setMrnChkNo(mrnChkNo[i]);
				if (conVvd[i] != null)
					model.setConVvd(conVvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorDischCYVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorDischCYVO[]
	 */
	public KorDischCYVO[] getKorDischCYVOs(){
		KorDischCYVO[] vos = (KorDischCYVO[])models.toArray(new KorDischCYVO[models.size()]);
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
		this.cstmsDchgLocWhCd = this.cstmsDchgLocWhCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrCngFlg = this.bdrCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNNm = this.custNNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whName = this.whName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTp = this.blTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsBlTpCd = this.krCstmsBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrTpCd = this.cstmsClrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSeqNo = this.mfSeqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnBlTsCd = this.mrnBlTsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCNm = this.custCNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlPodCd = this.fnlPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfRefNo = this.mfRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conVvd = this.conVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
