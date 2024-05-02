/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : XterEtcInterfaceVO.java
*@FileTitle : XterEtcInterfaceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.26
*@LastModifier : 김진주
*@LastVersion : 1.0
* 2014.09.26 김진주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 김진주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XterEtcInterfaceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XterEtcInterfaceVO> models = new ArrayList<XterEtcInterfaceVO>();
	
	/* Column Info */
	private String saveTroFlag = null;
	/* Column Info */
	private String rqstNo = null;
	/* Column Info */
	private String saveAkFlag = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String mstBkgNo = null;
	/* Column Info */
	private String autoNotification = null;
	/* Column Info */
	private String saveCustFlag = null;
	/* Column Info */
	private String docTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pctlNo = null;
	/* Column Info */
	private String saveCmFlag = null;
	/* Column Info */
	private String saveDgFlag = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String saveRfFlag = null;
	/* Column Info */
	private String faxLogRefNo = null;
	/* Column Info */
	private String xterRqstViaCd = null;
	/* Column Info */
	private String saveHbl2Flag = null;
	/* Column Info */
	private String bkgCorrRmk = null;
	/* Column Info */
	private String caRsnCd = null;
	/* Column Info */
	private String rqstSeq = null;
	/* Column Info */
	private String saveBkgFlag = null;
	/* Column Info */
	private String senderId = null;
	/* Column Info */
	private String saveMndFlag = null;
	/* Column Info */
	private String saveHblFlag = null;
	/* Column Info */
	private String saveCntrFlag = null;
	/* Column Info */
	private String saveBbFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public XterEtcInterfaceVO() {}

	public XterEtcInterfaceVO(String ibflag, String pagerows, String saveBkgFlag, String saveCustFlag, String saveCntrFlag, String saveMndFlag, String saveCmFlag, String saveTroFlag, String saveRfFlag, String saveDgFlag, String saveAkFlag, String saveBbFlag, String saveHblFlag, String saveHbl2Flag, String rqstNo, String faxLogRefNo, String senderId, String xterRqstViaCd, String mstBkgNo, String rqstSeq, String docTpCd, String pctlNo, String caRsnCd, String bkgCorrRmk, String bdrFlg, String autoNotification) {
		this.saveTroFlag = saveTroFlag;
		this.rqstNo = rqstNo;
		this.saveAkFlag = saveAkFlag;
		this.bdrFlg = bdrFlg;
		this.mstBkgNo = mstBkgNo;
		this.autoNotification = autoNotification;
		this.saveCustFlag = saveCustFlag;
		this.docTpCd = docTpCd;
		this.pagerows = pagerows;
		this.pctlNo = pctlNo;
		this.saveCmFlag = saveCmFlag;
		this.saveDgFlag = saveDgFlag;
		this.ibflag = ibflag;
		this.saveRfFlag = saveRfFlag;
		this.faxLogRefNo = faxLogRefNo;
		this.xterRqstViaCd = xterRqstViaCd;
		this.saveHbl2Flag = saveHbl2Flag;
		this.bkgCorrRmk = bkgCorrRmk;
		this.caRsnCd = caRsnCd;
		this.rqstSeq = rqstSeq;
		this.saveBkgFlag = saveBkgFlag;
		this.senderId = senderId;
		this.saveMndFlag = saveMndFlag;
		this.saveHblFlag = saveHblFlag;
		this.saveCntrFlag = saveCntrFlag;
		this.saveBbFlag = saveBbFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("save_tro_flag", getSaveTroFlag());
		this.hashColumns.put("rqst_no", getRqstNo());
		this.hashColumns.put("save_ak_flag", getSaveAkFlag());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("mst_bkg_no", getMstBkgNo());
		this.hashColumns.put("auto_notification", getAutoNotification());
		this.hashColumns.put("save_cust_flag", getSaveCustFlag());
		this.hashColumns.put("doc_tp_cd", getDocTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("save_cm_flag", getSaveCmFlag());
		this.hashColumns.put("save_dg_flag", getSaveDgFlag());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("save_rf_flag", getSaveRfFlag());
		this.hashColumns.put("fax_log_ref_no", getFaxLogRefNo());
		this.hashColumns.put("xter_rqst_via_cd", getXterRqstViaCd());
		this.hashColumns.put("save_hbl2_flag", getSaveHbl2Flag());
		this.hashColumns.put("bkg_corr_rmk", getBkgCorrRmk());
		this.hashColumns.put("ca_rsn_cd", getCaRsnCd());
		this.hashColumns.put("rqst_seq", getRqstSeq());
		this.hashColumns.put("save_bkg_flag", getSaveBkgFlag());
		this.hashColumns.put("sender_id", getSenderId());
		this.hashColumns.put("save_mnd_flag", getSaveMndFlag());
		this.hashColumns.put("save_hbl_flag", getSaveHblFlag());
		this.hashColumns.put("save_cntr_flag", getSaveCntrFlag());
		this.hashColumns.put("save_bb_flag", getSaveBbFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("save_tro_flag", "saveTroFlag");
		this.hashFields.put("rqst_no", "rqstNo");
		this.hashFields.put("save_ak_flag", "saveAkFlag");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("mst_bkg_no", "mstBkgNo");
		this.hashFields.put("auto_notification", "autoNotification");
		this.hashFields.put("save_cust_flag", "saveCustFlag");
		this.hashFields.put("doc_tp_cd", "docTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("save_cm_flag", "saveCmFlag");
		this.hashFields.put("save_dg_flag", "saveDgFlag");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("save_rf_flag", "saveRfFlag");
		this.hashFields.put("fax_log_ref_no", "faxLogRefNo");
		this.hashFields.put("xter_rqst_via_cd", "xterRqstViaCd");
		this.hashFields.put("save_hbl2_flag", "saveHbl2Flag");
		this.hashFields.put("bkg_corr_rmk", "bkgCorrRmk");
		this.hashFields.put("ca_rsn_cd", "caRsnCd");
		this.hashFields.put("rqst_seq", "rqstSeq");
		this.hashFields.put("save_bkg_flag", "saveBkgFlag");
		this.hashFields.put("sender_id", "senderId");
		this.hashFields.put("save_mnd_flag", "saveMndFlag");
		this.hashFields.put("save_hbl_flag", "saveHblFlag");
		this.hashFields.put("save_cntr_flag", "saveCntrFlag");
		this.hashFields.put("save_bb_flag", "saveBbFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return saveTroFlag
	 */
	public String getSaveTroFlag() {
		return this.saveTroFlag;
	}
	
	/**
	 * Column Info
	 * @return rqstNo
	 */
	public String getRqstNo() {
		return this.rqstNo;
	}
	
	/**
	 * Column Info
	 * @return saveAkFlag
	 */
	public String getSaveAkFlag() {
		return this.saveAkFlag;
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
	 * @return mstBkgNo
	 */
	public String getMstBkgNo() {
		return this.mstBkgNo;
	}
	
	/**
	 * Column Info
	 * @return autoNotification
	 */
	public String getAutoNotification() {
		return this.autoNotification;
	}
	
	/**
	 * Column Info
	 * @return saveCustFlag
	 */
	public String getSaveCustFlag() {
		return this.saveCustFlag;
	}
	
	/**
	 * Column Info
	 * @return docTpCd
	 */
	public String getDocTpCd() {
		return this.docTpCd;
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
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
	}
	
	/**
	 * Column Info
	 * @return saveCmFlag
	 */
	public String getSaveCmFlag() {
		return this.saveCmFlag;
	}
	
	/**
	 * Column Info
	 * @return saveDgFlag
	 */
	public String getSaveDgFlag() {
		return this.saveDgFlag;
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
	 * @return saveRfFlag
	 */
	public String getSaveRfFlag() {
		return this.saveRfFlag;
	}
	
	/**
	 * Column Info
	 * @return faxLogRefNo
	 */
	public String getFaxLogRefNo() {
		return this.faxLogRefNo;
	}
	
	/**
	 * Column Info
	 * @return xterRqstViaCd
	 */
	public String getXterRqstViaCd() {
		return this.xterRqstViaCd;
	}
	
	/**
	 * Column Info
	 * @return saveHbl2Flag
	 */
	public String getSaveHbl2Flag() {
		return this.saveHbl2Flag;
	}
	
	/**
	 * Column Info
	 * @return bkgCorrRmk
	 */
	public String getBkgCorrRmk() {
		return this.bkgCorrRmk;
	}
	
	/**
	 * Column Info
	 * @return caRsnCd
	 */
	public String getCaRsnCd() {
		return this.caRsnCd;
	}
	
	/**
	 * Column Info
	 * @return rqstSeq
	 */
	public String getRqstSeq() {
		return this.rqstSeq;
	}
	
	/**
	 * Column Info
	 * @return saveBkgFlag
	 */
	public String getSaveBkgFlag() {
		return this.saveBkgFlag;
	}
	
	/**
	 * Column Info
	 * @return senderId
	 */
	public String getSenderId() {
		return this.senderId;
	}
	
	/**
	 * Column Info
	 * @return saveMndFlag
	 */
	public String getSaveMndFlag() {
		return this.saveMndFlag;
	}
	
	/**
	 * Column Info
	 * @return saveHblFlag
	 */
	public String getSaveHblFlag() {
		return this.saveHblFlag;
	}
	
	/**
	 * Column Info
	 * @return saveCntrFlag
	 */
	public String getSaveCntrFlag() {
		return this.saveCntrFlag;
	}
	
	/**
	 * Column Info
	 * @return saveBbFlag
	 */
	public String getSaveBbFlag() {
		return this.saveBbFlag;
	}
	

	/**
	 * Column Info
	 * @param saveTroFlag
	 */
	public void setSaveTroFlag(String saveTroFlag) {
		this.saveTroFlag = saveTroFlag;
	}
	
	/**
	 * Column Info
	 * @param rqstNo
	 */
	public void setRqstNo(String rqstNo) {
		this.rqstNo = rqstNo;
	}
	
	/**
	 * Column Info
	 * @param saveAkFlag
	 */
	public void setSaveAkFlag(String saveAkFlag) {
		this.saveAkFlag = saveAkFlag;
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
	 * @param mstBkgNo
	 */
	public void setMstBkgNo(String mstBkgNo) {
		this.mstBkgNo = mstBkgNo;
	}
	
	/**
	 * Column Info
	 * @param autoNotification
	 */
	public void setAutoNotification(String autoNotification) {
		this.autoNotification = autoNotification;
	}
	
	/**
	 * Column Info
	 * @param saveCustFlag
	 */
	public void setSaveCustFlag(String saveCustFlag) {
		this.saveCustFlag = saveCustFlag;
	}
	
	/**
	 * Column Info
	 * @param docTpCd
	 */
	public void setDocTpCd(String docTpCd) {
		this.docTpCd = docTpCd;
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
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}
	
	/**
	 * Column Info
	 * @param saveCmFlag
	 */
	public void setSaveCmFlag(String saveCmFlag) {
		this.saveCmFlag = saveCmFlag;
	}
	
	/**
	 * Column Info
	 * @param saveDgFlag
	 */
	public void setSaveDgFlag(String saveDgFlag) {
		this.saveDgFlag = saveDgFlag;
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
	 * @param saveRfFlag
	 */
	public void setSaveRfFlag(String saveRfFlag) {
		this.saveRfFlag = saveRfFlag;
	}
	
	/**
	 * Column Info
	 * @param faxLogRefNo
	 */
	public void setFaxLogRefNo(String faxLogRefNo) {
		this.faxLogRefNo = faxLogRefNo;
	}
	
	/**
	 * Column Info
	 * @param xterRqstViaCd
	 */
	public void setXterRqstViaCd(String xterRqstViaCd) {
		this.xterRqstViaCd = xterRqstViaCd;
	}
	
	/**
	 * Column Info
	 * @param saveHbl2Flag
	 */
	public void setSaveHbl2Flag(String saveHbl2Flag) {
		this.saveHbl2Flag = saveHbl2Flag;
	}
	
	/**
	 * Column Info
	 * @param bkgCorrRmk
	 */
	public void setBkgCorrRmk(String bkgCorrRmk) {
		this.bkgCorrRmk = bkgCorrRmk;
	}
	
	/**
	 * Column Info
	 * @param caRsnCd
	 */
	public void setCaRsnCd(String caRsnCd) {
		this.caRsnCd = caRsnCd;
	}
	
	/**
	 * Column Info
	 * @param rqstSeq
	 */
	public void setRqstSeq(String rqstSeq) {
		this.rqstSeq = rqstSeq;
	}
	
	/**
	 * Column Info
	 * @param saveBkgFlag
	 */
	public void setSaveBkgFlag(String saveBkgFlag) {
		this.saveBkgFlag = saveBkgFlag;
	}
	
	/**
	 * Column Info
	 * @param senderId
	 */
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	
	/**
	 * Column Info
	 * @param saveMndFlag
	 */
	public void setSaveMndFlag(String saveMndFlag) {
		this.saveMndFlag = saveMndFlag;
	}
	
	/**
	 * Column Info
	 * @param saveHblFlag
	 */
	public void setSaveHblFlag(String saveHblFlag) {
		this.saveHblFlag = saveHblFlag;
	}
	
	/**
	 * Column Info
	 * @param saveCntrFlag
	 */
	public void setSaveCntrFlag(String saveCntrFlag) {
		this.saveCntrFlag = saveCntrFlag;
	}
	
	/**
	 * Column Info
	 * @param saveBbFlag
	 */
	public void setSaveBbFlag(String saveBbFlag) {
		this.saveBbFlag = saveBbFlag;
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
		setSaveTroFlag(JSPUtil.getParameter(request, prefix + "save_tro_flag", ""));
		setRqstNo(JSPUtil.getParameter(request, prefix + "rqst_no", ""));
		setSaveAkFlag(JSPUtil.getParameter(request, prefix + "save_ak_flag", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setMstBkgNo(JSPUtil.getParameter(request, prefix + "mst_bkg_no", ""));
		setAutoNotification(JSPUtil.getParameter(request, prefix + "auto_notification", ""));
		setSaveCustFlag(JSPUtil.getParameter(request, prefix + "save_cust_flag", ""));
		setDocTpCd(JSPUtil.getParameter(request, prefix + "doc_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
		setSaveCmFlag(JSPUtil.getParameter(request, prefix + "save_cm_flag", ""));
		setSaveDgFlag(JSPUtil.getParameter(request, prefix + "save_dg_flag", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSaveRfFlag(JSPUtil.getParameter(request, prefix + "save_rf_flag", ""));
		setFaxLogRefNo(JSPUtil.getParameter(request, prefix + "fax_log_ref_no", ""));
		setXterRqstViaCd(JSPUtil.getParameter(request, prefix + "xter_rqst_via_cd", ""));
		setSaveHbl2Flag(JSPUtil.getParameter(request, prefix + "save_hbl2_flag", ""));
		setBkgCorrRmk(JSPUtil.getParameter(request, prefix + "bkg_corr_rmk", ""));
		setCaRsnCd(JSPUtil.getParameter(request, prefix + "ca_rsn_cd", ""));
		setRqstSeq(JSPUtil.getParameter(request, prefix + "rqst_seq", ""));
		setSaveBkgFlag(JSPUtil.getParameter(request, prefix + "save_bkg_flag", ""));
		setSenderId(JSPUtil.getParameter(request, prefix + "sender_id", ""));
		setSaveMndFlag(JSPUtil.getParameter(request, prefix + "save_mnd_flag", ""));
		setSaveHblFlag(JSPUtil.getParameter(request, prefix + "save_hbl_flag", ""));
		setSaveCntrFlag(JSPUtil.getParameter(request, prefix + "save_cntr_flag", ""));
		setSaveBbFlag(JSPUtil.getParameter(request, prefix + "save_bb_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterEtcInterfaceVO[]
	 */
	public XterEtcInterfaceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XterEtcInterfaceVO[]
	 */
	public XterEtcInterfaceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterEtcInterfaceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] saveTroFlag = (JSPUtil.getParameter(request, prefix	+ "save_tro_flag", length));
			String[] rqstNo = (JSPUtil.getParameter(request, prefix	+ "rqst_no", length));
			String[] saveAkFlag = (JSPUtil.getParameter(request, prefix	+ "save_ak_flag", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] mstBkgNo = (JSPUtil.getParameter(request, prefix	+ "mst_bkg_no", length));
			String[] autoNotification = (JSPUtil.getParameter(request, prefix	+ "auto_notification", length));
			String[] saveCustFlag = (JSPUtil.getParameter(request, prefix	+ "save_cust_flag", length));
			String[] docTpCd = (JSPUtil.getParameter(request, prefix	+ "doc_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] saveCmFlag = (JSPUtil.getParameter(request, prefix	+ "save_cm_flag", length));
			String[] saveDgFlag = (JSPUtil.getParameter(request, prefix	+ "save_dg_flag", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] saveRfFlag = (JSPUtil.getParameter(request, prefix	+ "save_rf_flag", length));
			String[] faxLogRefNo = (JSPUtil.getParameter(request, prefix	+ "fax_log_ref_no", length));
			String[] xterRqstViaCd = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_via_cd", length));
			String[] saveHbl2Flag = (JSPUtil.getParameter(request, prefix	+ "save_hbl2_flag", length));
			String[] bkgCorrRmk = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_rmk", length));
			String[] caRsnCd = (JSPUtil.getParameter(request, prefix	+ "ca_rsn_cd", length));
			String[] rqstSeq = (JSPUtil.getParameter(request, prefix	+ "rqst_seq", length));
			String[] saveBkgFlag = (JSPUtil.getParameter(request, prefix	+ "save_bkg_flag", length));
			String[] senderId = (JSPUtil.getParameter(request, prefix	+ "sender_id", length));
			String[] saveMndFlag = (JSPUtil.getParameter(request, prefix	+ "save_mnd_flag", length));
			String[] saveHblFlag = (JSPUtil.getParameter(request, prefix	+ "save_hbl_flag", length));
			String[] saveCntrFlag = (JSPUtil.getParameter(request, prefix	+ "save_cntr_flag", length));
			String[] saveBbFlag = (JSPUtil.getParameter(request, prefix	+ "save_bb_flag", length));
			
			for (int i = 0; i < length; i++) {
				model = new XterEtcInterfaceVO();
				if (saveTroFlag[i] != null)
					model.setSaveTroFlag(saveTroFlag[i]);
				if (rqstNo[i] != null)
					model.setRqstNo(rqstNo[i]);
				if (saveAkFlag[i] != null)
					model.setSaveAkFlag(saveAkFlag[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (mstBkgNo[i] != null)
					model.setMstBkgNo(mstBkgNo[i]);
				if (autoNotification[i] != null)
					model.setAutoNotification(autoNotification[i]);
				if (saveCustFlag[i] != null)
					model.setSaveCustFlag(saveCustFlag[i]);
				if (docTpCd[i] != null)
					model.setDocTpCd(docTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (saveCmFlag[i] != null)
					model.setSaveCmFlag(saveCmFlag[i]);
				if (saveDgFlag[i] != null)
					model.setSaveDgFlag(saveDgFlag[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (saveRfFlag[i] != null)
					model.setSaveRfFlag(saveRfFlag[i]);
				if (faxLogRefNo[i] != null)
					model.setFaxLogRefNo(faxLogRefNo[i]);
				if (xterRqstViaCd[i] != null)
					model.setXterRqstViaCd(xterRqstViaCd[i]);
				if (saveHbl2Flag[i] != null)
					model.setSaveHbl2Flag(saveHbl2Flag[i]);
				if (bkgCorrRmk[i] != null)
					model.setBkgCorrRmk(bkgCorrRmk[i]);
				if (caRsnCd[i] != null)
					model.setCaRsnCd(caRsnCd[i]);
				if (rqstSeq[i] != null)
					model.setRqstSeq(rqstSeq[i]);
				if (saveBkgFlag[i] != null)
					model.setSaveBkgFlag(saveBkgFlag[i]);
				if (senderId[i] != null)
					model.setSenderId(senderId[i]);
				if (saveMndFlag[i] != null)
					model.setSaveMndFlag(saveMndFlag[i]);
				if (saveHblFlag[i] != null)
					model.setSaveHblFlag(saveHblFlag[i]);
				if (saveCntrFlag[i] != null)
					model.setSaveCntrFlag(saveCntrFlag[i]);
				if (saveBbFlag[i] != null)
					model.setSaveBbFlag(saveBbFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterEtcInterfaceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterEtcInterfaceVO[]
	 */
	public XterEtcInterfaceVO[] getXterEtcInterfaceVOs(){
		XterEtcInterfaceVO[] vos = (XterEtcInterfaceVO[])models.toArray(new XterEtcInterfaceVO[models.size()]);
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
		this.saveTroFlag = this.saveTroFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstNo = this.rqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveAkFlag = this.saveAkFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBkgNo = this.mstBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoNotification = this.autoNotification .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveCustFlag = this.saveCustFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTpCd = this.docTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveCmFlag = this.saveCmFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveDgFlag = this.saveDgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveRfFlag = this.saveRfFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxLogRefNo = this.faxLogRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstViaCd = this.xterRqstViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveHbl2Flag = this.saveHbl2Flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrRmk = this.bkgCorrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caRsnCd = this.caRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstSeq = this.rqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveBkgFlag = this.saveBkgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderId = this.senderId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveMndFlag = this.saveMndFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveHblFlag = this.saveHblFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveCntrFlag = this.saveCntrFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saveBbFlag = this.saveBbFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
