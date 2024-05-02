/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorExpCorrVO.java
*@FileTitle : KorExpCorrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.18 박상훈 
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

public class KorExpCorrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorExpCorrVO> models = new ArrayList<KorExpCorrVO>();
	
	/* Column Info */
	private String smtAmdNo = null;
	/* Column Info */
	private String krXptPckId = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String trnsSeq = null;
	/* Column Info */
	private String krCstmsCorrId = null;
	/* Column Info */
	private String prtLodgFlg = null;
	/* Column Info */
	private String xptLicNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String divdPckQty = null;
	/* Column Info */
	private String preXptLicNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String corrRsn = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String divdPckUtCd = null;
	/* Column Info */
	private String prtLodgSeq = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String divdWgt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String divdWgtUtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorExpCorrVO() {}

	public KorExpCorrVO(String ibflag, String pagerows, String blNo, String smtAmdNo, String krXptPckId, String cntrWgt, String trnsSeq, String krCstmsCorrId, String prtLodgFlg, String xptLicNo, String divdPckQty, String preXptLicNo, String bkgNo, String corrRsn, String divdPckUtCd, String prtLodgSeq, String wgtUtCd, String pckQty, String divdWgt, String portCd, String pckTpCd, String divdWgtUtCd, String cstmsDeclTpCd) {
		this.smtAmdNo = smtAmdNo;
		this.krXptPckId = krXptPckId;
		this.cntrWgt = cntrWgt;
		this.trnsSeq = trnsSeq;
		this.krCstmsCorrId = krCstmsCorrId;
		this.prtLodgFlg = prtLodgFlg;
		this.xptLicNo = xptLicNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.divdPckQty = divdPckQty;
		this.preXptLicNo = preXptLicNo;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.corrRsn = corrRsn;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.divdPckUtCd = divdPckUtCd;
		this.prtLodgSeq = prtLodgSeq;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.divdWgt = divdWgt;
		this.portCd = portCd;
		this.pckTpCd = pckTpCd;
		this.divdWgtUtCd = divdWgtUtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("smt_amd_no", getSmtAmdNo());
		this.hashColumns.put("kr_xpt_pck_id", getKrXptPckId());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("trns_seq", getTrnsSeq());
		this.hashColumns.put("kr_cstms_corr_id", getKrCstmsCorrId());
		this.hashColumns.put("prt_lodg_flg", getPrtLodgFlg());
		this.hashColumns.put("xpt_lic_no", getXptLicNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("divd_pck_qty", getDivdPckQty());
		this.hashColumns.put("pre_xpt_lic_no", getPreXptLicNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("corr_rsn", getCorrRsn());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("divd_pck_ut_cd", getDivdPckUtCd());
		this.hashColumns.put("prt_lodg_seq", getPrtLodgSeq());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("divd_wgt", getDivdWgt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("divd_wgt_ut_cd", getDivdWgtUtCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("smt_amd_no", "smtAmdNo");
		this.hashFields.put("kr_xpt_pck_id", "krXptPckId");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("trns_seq", "trnsSeq");
		this.hashFields.put("kr_cstms_corr_id", "krCstmsCorrId");
		this.hashFields.put("prt_lodg_flg", "prtLodgFlg");
		this.hashFields.put("xpt_lic_no", "xptLicNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("divd_pck_qty", "divdPckQty");
		this.hashFields.put("pre_xpt_lic_no", "preXptLicNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("corr_rsn", "corrRsn");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("divd_pck_ut_cd", "divdPckUtCd");
		this.hashFields.put("prt_lodg_seq", "prtLodgSeq");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("divd_wgt", "divdWgt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("divd_wgt_ut_cd", "divdWgtUtCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return smtAmdNo
	 */
	public String getSmtAmdNo() {
		return this.smtAmdNo;
	}
	
	/**
	 * Column Info
	 * @return krXptPckId
	 */
	public String getKrXptPckId() {
		return this.krXptPckId;
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
	 * @return trnsSeq
	 */
	public String getTrnsSeq() {
		return this.trnsSeq;
	}
	
	/**
	 * Column Info
	 * @return krCstmsCorrId
	 */
	public String getKrCstmsCorrId() {
		return this.krCstmsCorrId;
	}
	
	/**
	 * Column Info
	 * @return prtLodgFlg
	 */
	public String getPrtLodgFlg() {
		return this.prtLodgFlg;
	}
	
	/**
	 * Column Info
	 * @return xptLicNo
	 */
	public String getXptLicNo() {
		return this.xptLicNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return divdPckQty
	 */
	public String getDivdPckQty() {
		return this.divdPckQty;
	}
	
	/**
	 * Column Info
	 * @return preXptLicNo
	 */
	public String getPreXptLicNo() {
		return this.preXptLicNo;
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
	 * @return corrRsn
	 */
	public String getCorrRsn() {
		return this.corrRsn;
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
	 * @return divdPckUtCd
	 */
	public String getDivdPckUtCd() {
		return this.divdPckUtCd;
	}
	
	/**
	 * Column Info
	 * @return prtLodgSeq
	 */
	public String getPrtLodgSeq() {
		return this.prtLodgSeq;
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
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return divdWgt
	 */
	public String getDivdWgt() {
		return this.divdWgt;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return divdWgtUtCd
	 */
	public String getDivdWgtUtCd() {
		return this.divdWgtUtCd;
	}
	

	/**
	 * Column Info
	 * @param smtAmdNo
	 */
	public void setSmtAmdNo(String smtAmdNo) {
		this.smtAmdNo = smtAmdNo;
	}
	
	/**
	 * Column Info
	 * @param krXptPckId
	 */
	public void setKrXptPckId(String krXptPckId) {
		this.krXptPckId = krXptPckId;
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
	 * @param trnsSeq
	 */
	public void setTrnsSeq(String trnsSeq) {
		this.trnsSeq = trnsSeq;
	}
	
	/**
	 * Column Info
	 * @param krCstmsCorrId
	 */
	public void setKrCstmsCorrId(String krCstmsCorrId) {
		this.krCstmsCorrId = krCstmsCorrId;
	}
	
	/**
	 * Column Info
	 * @param prtLodgFlg
	 */
	public void setPrtLodgFlg(String prtLodgFlg) {
		this.prtLodgFlg = prtLodgFlg;
	}
	
	/**
	 * Column Info
	 * @param xptLicNo
	 */
	public void setXptLicNo(String xptLicNo) {
		this.xptLicNo = xptLicNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param divdPckQty
	 */
	public void setDivdPckQty(String divdPckQty) {
		this.divdPckQty = divdPckQty;
	}
	
	/**
	 * Column Info
	 * @param preXptLicNo
	 */
	public void setPreXptLicNo(String preXptLicNo) {
		this.preXptLicNo = preXptLicNo;
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
	 * @param corrRsn
	 */
	public void setCorrRsn(String corrRsn) {
		this.corrRsn = corrRsn;
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
	 * @param divdPckUtCd
	 */
	public void setDivdPckUtCd(String divdPckUtCd) {
		this.divdPckUtCd = divdPckUtCd;
	}
	
	/**
	 * Column Info
	 * @param prtLodgSeq
	 */
	public void setPrtLodgSeq(String prtLodgSeq) {
		this.prtLodgSeq = prtLodgSeq;
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
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param divdWgt
	 */
	public void setDivdWgt(String divdWgt) {
		this.divdWgt = divdWgt;
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
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param divdWgtUtCd
	 */
	public void setDivdWgtUtCd(String divdWgtUtCd) {
		this.divdWgtUtCd = divdWgtUtCd;
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
		setSmtAmdNo(JSPUtil.getParameter(request, prefix + "smt_amd_no", ""));
		setKrXptPckId(JSPUtil.getParameter(request, prefix + "kr_xpt_pck_id", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setTrnsSeq(JSPUtil.getParameter(request, prefix + "trns_seq", ""));
		setKrCstmsCorrId(JSPUtil.getParameter(request, prefix + "kr_cstms_corr_id", ""));
		setPrtLodgFlg(JSPUtil.getParameter(request, prefix + "prt_lodg_flg", ""));
		setXptLicNo(JSPUtil.getParameter(request, prefix + "xpt_lic_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDivdPckQty(JSPUtil.getParameter(request, prefix + "divd_pck_qty", ""));
		setPreXptLicNo(JSPUtil.getParameter(request, prefix + "pre_xpt_lic_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCorrRsn(JSPUtil.getParameter(request, prefix + "corr_rsn", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, prefix + "cstms_decl_tp_cd", ""));
		setDivdPckUtCd(JSPUtil.getParameter(request, prefix + "divd_pck_ut_cd", ""));
		setPrtLodgSeq(JSPUtil.getParameter(request, prefix + "prt_lodg_seq", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setDivdWgt(JSPUtil.getParameter(request, prefix + "divd_wgt", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setDivdWgtUtCd(JSPUtil.getParameter(request, prefix + "divd_wgt_ut_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorExpCorrVO[]
	 */
	public KorExpCorrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorExpCorrVO[]
	 */
	public KorExpCorrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorExpCorrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] smtAmdNo = (JSPUtil.getParameter(request, prefix	+ "smt_amd_no", length));
			String[] krXptPckId = (JSPUtil.getParameter(request, prefix	+ "kr_xpt_pck_id", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] trnsSeq = (JSPUtil.getParameter(request, prefix	+ "trns_seq", length));
			String[] krCstmsCorrId = (JSPUtil.getParameter(request, prefix	+ "kr_cstms_corr_id", length));
			String[] prtLodgFlg = (JSPUtil.getParameter(request, prefix	+ "prt_lodg_flg", length));
			String[] xptLicNo = (JSPUtil.getParameter(request, prefix	+ "xpt_lic_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] divdPckQty = (JSPUtil.getParameter(request, prefix	+ "divd_pck_qty", length));
			String[] preXptLicNo = (JSPUtil.getParameter(request, prefix	+ "pre_xpt_lic_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] corrRsn = (JSPUtil.getParameter(request, prefix	+ "corr_rsn", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] divdPckUtCd = (JSPUtil.getParameter(request, prefix	+ "divd_pck_ut_cd", length));
			String[] prtLodgSeq = (JSPUtil.getParameter(request, prefix	+ "prt_lodg_seq", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] divdWgt = (JSPUtil.getParameter(request, prefix	+ "divd_wgt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] divdWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "divd_wgt_ut_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorExpCorrVO();
				if (smtAmdNo[i] != null)
					model.setSmtAmdNo(smtAmdNo[i]);
				if (krXptPckId[i] != null)
					model.setKrXptPckId(krXptPckId[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (trnsSeq[i] != null)
					model.setTrnsSeq(trnsSeq[i]);
				if (krCstmsCorrId[i] != null)
					model.setKrCstmsCorrId(krCstmsCorrId[i]);
				if (prtLodgFlg[i] != null)
					model.setPrtLodgFlg(prtLodgFlg[i]);
				if (xptLicNo[i] != null)
					model.setXptLicNo(xptLicNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (divdPckQty[i] != null)
					model.setDivdPckQty(divdPckQty[i]);
				if (preXptLicNo[i] != null)
					model.setPreXptLicNo(preXptLicNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (corrRsn[i] != null)
					model.setCorrRsn(corrRsn[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (divdPckUtCd[i] != null)
					model.setDivdPckUtCd(divdPckUtCd[i]);
				if (prtLodgSeq[i] != null)
					model.setPrtLodgSeq(prtLodgSeq[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (divdWgt[i] != null)
					model.setDivdWgt(divdWgt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (divdWgtUtCd[i] != null)
					model.setDivdWgtUtCd(divdWgtUtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorExpCorrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorExpCorrVO[]
	 */
	public KorExpCorrVO[] getKorExpCorrVOs(){
		KorExpCorrVO[] vos = (KorExpCorrVO[])models.toArray(new KorExpCorrVO[models.size()]);
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
		this.smtAmdNo = this.smtAmdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krXptPckId = this.krXptPckId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsSeq = this.trnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.krCstmsCorrId = this.krCstmsCorrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtLodgFlg = this.prtLodgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptLicNo = this.xptLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdPckQty = this.divdPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preXptLicNo = this.preXptLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRsn = this.corrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdPckUtCd = this.divdPckUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prtLodgSeq = this.prtLodgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdWgt = this.divdWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divdWgtUtCd = this.divdWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
