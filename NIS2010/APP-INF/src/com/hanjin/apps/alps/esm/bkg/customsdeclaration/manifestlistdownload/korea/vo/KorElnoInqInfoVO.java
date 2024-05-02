/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorElnoInqInfoVO.java
*@FileTitle : KorElnoInqInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.22 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorElnoInqInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorElnoInqInfoVO> models = new ArrayList<KorElnoInqInfoVO>();
	
	/* Column Info */
	private String keDivdWgtUtCd = null;
	/* Column Info */
	private String keDivdWgt = null;
	/* Column Info */
	private String kePckTpCd = null;
	/* Column Info */
	private String keDivdPckUtCd = null;
	/* Column Info */
	private String kePrtLodgSeq = null;
	/* Column Info */
	private String keBkgNo = null;
	/* Column Info */
	private String kePrtLodgFlg = null;
	/* Column Info */
	private String kePckQty = null;
	/* Column Info */
	private String keDivdPckQty = null;
	/* Column Info */
	private String keKrXptPckId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String keWgtUtCd = null;
	/* Column Info */
	private String cstmsDeclTpCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String keXptLicNo = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String keTrnsSeq = null;
	/* Column Info */
	private String keCstmsDeclTpCd = null;
	/* Column Info */
	private String keCntrWgt = null;
	/* Column Info */
	private String blNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorElnoInqInfoVO() {}

	public KorElnoInqInfoVO(String ibflag, String pagerows, String keBkgNo, String keCstmsDeclTpCd, String keTrnsSeq, String keXptLicNo, String kePckQty, String kePckTpCd, String keCntrWgt, String keWgtUtCd, String kePrtLodgFlg, String kePrtLodgSeq, String keDivdPckQty, String keDivdPckUtCd, String keDivdWgt, String keDivdWgtUtCd, String keKrXptPckId, String userId, String bkgNo, String cstmsDeclTpCd, String portCd, String blNo) {
		this.keDivdWgtUtCd = keDivdWgtUtCd;
		this.keDivdWgt = keDivdWgt;
		this.kePckTpCd = kePckTpCd;
		this.keDivdPckUtCd = keDivdPckUtCd;
		this.kePrtLodgSeq = kePrtLodgSeq;
		this.keBkgNo = keBkgNo;
		this.kePrtLodgFlg = kePrtLodgFlg;
		this.kePckQty = kePckQty;
		this.keDivdPckQty = keDivdPckQty;
		this.keKrXptPckId = keKrXptPckId;
		this.pagerows = pagerows;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.keWgtUtCd = keWgtUtCd;
		this.cstmsDeclTpCd = cstmsDeclTpCd;
		this.userId = userId;
		this.keXptLicNo = keXptLicNo;
		this.portCd = portCd;
		this.keTrnsSeq = keTrnsSeq;
		this.keCstmsDeclTpCd = keCstmsDeclTpCd;
		this.keCntrWgt = keCntrWgt;
		this.blNo = blNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ke_divd_wgt_ut_cd", getKeDivdWgtUtCd());
		this.hashColumns.put("ke_divd_wgt", getKeDivdWgt());
		this.hashColumns.put("ke_pck_tp_cd", getKePckTpCd());
		this.hashColumns.put("ke_divd_pck_ut_cd", getKeDivdPckUtCd());
		this.hashColumns.put("ke_prt_lodg_seq", getKePrtLodgSeq());
		this.hashColumns.put("ke_bkg_no", getKeBkgNo());
		this.hashColumns.put("ke_prt_lodg_flg", getKePrtLodgFlg());
		this.hashColumns.put("ke_pck_qty", getKePckQty());
		this.hashColumns.put("ke_divd_pck_qty", getKeDivdPckQty());
		this.hashColumns.put("ke_kr_xpt_pck_id", getKeKrXptPckId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ke_wgt_ut_cd", getKeWgtUtCd());
		this.hashColumns.put("cstms_decl_tp_cd", getCstmsDeclTpCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("ke_xpt_lic_no", getKeXptLicNo());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("ke_trns_seq", getKeTrnsSeq());
		this.hashColumns.put("ke_cstms_decl_tp_cd", getKeCstmsDeclTpCd());
		this.hashColumns.put("ke_cntr_wgt", getKeCntrWgt());
		this.hashColumns.put("bl_no", getBlNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ke_divd_wgt_ut_cd", "keDivdWgtUtCd");
		this.hashFields.put("ke_divd_wgt", "keDivdWgt");
		this.hashFields.put("ke_pck_tp_cd", "kePckTpCd");
		this.hashFields.put("ke_divd_pck_ut_cd", "keDivdPckUtCd");
		this.hashFields.put("ke_prt_lodg_seq", "kePrtLodgSeq");
		this.hashFields.put("ke_bkg_no", "keBkgNo");
		this.hashFields.put("ke_prt_lodg_flg", "kePrtLodgFlg");
		this.hashFields.put("ke_pck_qty", "kePckQty");
		this.hashFields.put("ke_divd_pck_qty", "keDivdPckQty");
		this.hashFields.put("ke_kr_xpt_pck_id", "keKrXptPckId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ke_wgt_ut_cd", "keWgtUtCd");
		this.hashFields.put("cstms_decl_tp_cd", "cstmsDeclTpCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("ke_xpt_lic_no", "keXptLicNo");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("ke_trns_seq", "keTrnsSeq");
		this.hashFields.put("ke_cstms_decl_tp_cd", "keCstmsDeclTpCd");
		this.hashFields.put("ke_cntr_wgt", "keCntrWgt");
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
	 * @return keDivdWgtUtCd
	 */
	public String getKeDivdWgtUtCd() {
		return this.keDivdWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return keDivdWgt
	 */
	public String getKeDivdWgt() {
		return this.keDivdWgt;
	}
	
	/**
	 * Column Info
	 * @return kePckTpCd
	 */
	public String getKePckTpCd() {
		return this.kePckTpCd;
	}
	
	/**
	 * Column Info
	 * @return keDivdPckUtCd
	 */
	public String getKeDivdPckUtCd() {
		return this.keDivdPckUtCd;
	}
	
	/**
	 * Column Info
	 * @return kePrtLodgSeq
	 */
	public String getKePrtLodgSeq() {
		return this.kePrtLodgSeq;
	}
	
	/**
	 * Column Info
	 * @return keBkgNo
	 */
	public String getKeBkgNo() {
		return this.keBkgNo;
	}
	
	/**
	 * Column Info
	 * @return kePrtLodgFlg
	 */
	public String getKePrtLodgFlg() {
		return this.kePrtLodgFlg;
	}
	
	/**
	 * Column Info
	 * @return kePckQty
	 */
	public String getKePckQty() {
		return this.kePckQty;
	}
	
	/**
	 * Column Info
	 * @return keDivdPckQty
	 */
	public String getKeDivdPckQty() {
		return this.keDivdPckQty;
	}
	
	/**
	 * Column Info
	 * @return keKrXptPckId
	 */
	public String getKeKrXptPckId() {
		return this.keKrXptPckId;
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
	 * @return keWgtUtCd
	 */
	public String getKeWgtUtCd() {
		return this.keWgtUtCd;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return keXptLicNo
	 */
	public String getKeXptLicNo() {
		return this.keXptLicNo;
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
	 * @return keTrnsSeq
	 */
	public String getKeTrnsSeq() {
		return this.keTrnsSeq;
	}
	
	/**
	 * Column Info
	 * @return keCstmsDeclTpCd
	 */
	public String getKeCstmsDeclTpCd() {
		return this.keCstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @return keCntrWgt
	 */
	public String getKeCntrWgt() {
		return this.keCntrWgt;
	}
	

	/**
	 * Column Info
	 * @param keDivdWgtUtCd
	 */
	public void setKeDivdWgtUtCd(String keDivdWgtUtCd) {
		this.keDivdWgtUtCd = keDivdWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param keDivdWgt
	 */
	public void setKeDivdWgt(String keDivdWgt) {
		this.keDivdWgt = keDivdWgt;
	}
	
	/**
	 * Column Info
	 * @param kePckTpCd
	 */
	public void setKePckTpCd(String kePckTpCd) {
		this.kePckTpCd = kePckTpCd;
	}
	
	/**
	 * Column Info
	 * @param keDivdPckUtCd
	 */
	public void setKeDivdPckUtCd(String keDivdPckUtCd) {
		this.keDivdPckUtCd = keDivdPckUtCd;
	}
	
	/**
	 * Column Info
	 * @param kePrtLodgSeq
	 */
	public void setKePrtLodgSeq(String kePrtLodgSeq) {
		this.kePrtLodgSeq = kePrtLodgSeq;
	}
	
	/**
	 * Column Info
	 * @param keBkgNo
	 */
	public void setKeBkgNo(String keBkgNo) {
		this.keBkgNo = keBkgNo;
	}
	
	/**
	 * Column Info
	 * @param kePrtLodgFlg
	 */
	public void setKePrtLodgFlg(String kePrtLodgFlg) {
		this.kePrtLodgFlg = kePrtLodgFlg;
	}
	
	/**
	 * Column Info
	 * @param kePckQty
	 */
	public void setKePckQty(String kePckQty) {
		this.kePckQty = kePckQty;
	}
	
	/**
	 * Column Info
	 * @param keDivdPckQty
	 */
	public void setKeDivdPckQty(String keDivdPckQty) {
		this.keDivdPckQty = keDivdPckQty;
	}
	
	/**
	 * Column Info
	 * @param keKrXptPckId
	 */
	public void setKeKrXptPckId(String keKrXptPckId) {
		this.keKrXptPckId = keKrXptPckId;
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
	 * @param keWgtUtCd
	 */
	public void setKeWgtUtCd(String keWgtUtCd) {
		this.keWgtUtCd = keWgtUtCd;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param keXptLicNo
	 */
	public void setKeXptLicNo(String keXptLicNo) {
		this.keXptLicNo = keXptLicNo;
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
	 * @param keTrnsSeq
	 */
	public void setKeTrnsSeq(String keTrnsSeq) {
		this.keTrnsSeq = keTrnsSeq;
	}
	
	/**
	 * Column Info
	 * @param keCstmsDeclTpCd
	 */
	public void setKeCstmsDeclTpCd(String keCstmsDeclTpCd) {
		this.keCstmsDeclTpCd = keCstmsDeclTpCd;
	}
	
	/**
	 * Column Info
	 * @param keCntrWgt
	 */
	public void setKeCntrWgt(String keCntrWgt) {
		this.keCntrWgt = keCntrWgt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setKeDivdWgtUtCd(JSPUtil.getParameter(request, "ke_divd_wgt_ut_cd", ""));
		setKeDivdWgt(JSPUtil.getParameter(request, "ke_divd_wgt", ""));
		setKePckTpCd(JSPUtil.getParameter(request, "ke_pck_tp_cd", ""));
		setKeDivdPckUtCd(JSPUtil.getParameter(request, "ke_divd_pck_ut_cd", ""));
		setKePrtLodgSeq(JSPUtil.getParameter(request, "ke_prt_lodg_seq", ""));
		setKeBkgNo(JSPUtil.getParameter(request, "ke_bkg_no", ""));
		setKePrtLodgFlg(JSPUtil.getParameter(request, "ke_prt_lodg_flg", ""));
		setKePckQty(JSPUtil.getParameter(request, "ke_pck_qty", ""));
		setKeDivdPckQty(JSPUtil.getParameter(request, "ke_divd_pck_qty", ""));
		setKeKrXptPckId(JSPUtil.getParameter(request, "ke_kr_xpt_pck_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setKeWgtUtCd(JSPUtil.getParameter(request, "ke_wgt_ut_cd", ""));
		setCstmsDeclTpCd(JSPUtil.getParameter(request, "cstms_decl_tp_cd", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setKeXptLicNo(JSPUtil.getParameter(request, "ke_xpt_lic_no", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setKeTrnsSeq(JSPUtil.getParameter(request, "ke_trns_seq", ""));
		setKeCstmsDeclTpCd(JSPUtil.getParameter(request, "ke_cstms_decl_tp_cd", ""));
		setKeCntrWgt(JSPUtil.getParameter(request, "ke_cntr_wgt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorElnoInqInfoVO[]
	 */
	public KorElnoInqInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorElnoInqInfoVO[]
	 */
	public KorElnoInqInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorElnoInqInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] keDivdWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "ke_divd_wgt_ut_cd", length));
			String[] keDivdWgt = (JSPUtil.getParameter(request, prefix	+ "ke_divd_wgt", length));
			String[] kePckTpCd = (JSPUtil.getParameter(request, prefix	+ "ke_pck_tp_cd", length));
			String[] keDivdPckUtCd = (JSPUtil.getParameter(request, prefix	+ "ke_divd_pck_ut_cd", length));
			String[] kePrtLodgSeq = (JSPUtil.getParameter(request, prefix	+ "ke_prt_lodg_seq", length));
			String[] keBkgNo = (JSPUtil.getParameter(request, prefix	+ "ke_bkg_no", length));
			String[] kePrtLodgFlg = (JSPUtil.getParameter(request, prefix	+ "ke_prt_lodg_flg", length));
			String[] kePckQty = (JSPUtil.getParameter(request, prefix	+ "ke_pck_qty", length));
			String[] keDivdPckQty = (JSPUtil.getParameter(request, prefix	+ "ke_divd_pck_qty", length));
			String[] keKrXptPckId = (JSPUtil.getParameter(request, prefix	+ "ke_kr_xpt_pck_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] keWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "ke_wgt_ut_cd", length));
			String[] cstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_tp_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] keXptLicNo = (JSPUtil.getParameter(request, prefix	+ "ke_xpt_lic_no", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] keTrnsSeq = (JSPUtil.getParameter(request, prefix	+ "ke_trns_seq", length));
			String[] keCstmsDeclTpCd = (JSPUtil.getParameter(request, prefix	+ "ke_cstms_decl_tp_cd", length));
			String[] keCntrWgt = (JSPUtil.getParameter(request, prefix	+ "ke_cntr_wgt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorElnoInqInfoVO();
				if (keDivdWgtUtCd[i] != null)
					model.setKeDivdWgtUtCd(keDivdWgtUtCd[i]);
				if (keDivdWgt[i] != null)
					model.setKeDivdWgt(keDivdWgt[i]);
				if (kePckTpCd[i] != null)
					model.setKePckTpCd(kePckTpCd[i]);
				if (keDivdPckUtCd[i] != null)
					model.setKeDivdPckUtCd(keDivdPckUtCd[i]);
				if (kePrtLodgSeq[i] != null)
					model.setKePrtLodgSeq(kePrtLodgSeq[i]);
				if (keBkgNo[i] != null)
					model.setKeBkgNo(keBkgNo[i]);
				if (kePrtLodgFlg[i] != null)
					model.setKePrtLodgFlg(kePrtLodgFlg[i]);
				if (kePckQty[i] != null)
					model.setKePckQty(kePckQty[i]);
				if (keDivdPckQty[i] != null)
					model.setKeDivdPckQty(keDivdPckQty[i]);
				if (keKrXptPckId[i] != null)
					model.setKeKrXptPckId(keKrXptPckId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (keWgtUtCd[i] != null)
					model.setKeWgtUtCd(keWgtUtCd[i]);
				if (cstmsDeclTpCd[i] != null)
					model.setCstmsDeclTpCd(cstmsDeclTpCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (keXptLicNo[i] != null)
					model.setKeXptLicNo(keXptLicNo[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (keTrnsSeq[i] != null)
					model.setKeTrnsSeq(keTrnsSeq[i]);
				if (keCstmsDeclTpCd[i] != null)
					model.setKeCstmsDeclTpCd(keCstmsDeclTpCd[i]);
				if (keCntrWgt[i] != null)
					model.setKeCntrWgt(keCntrWgt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorElnoInqInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorElnoInqInfoVO[]
	 */
	public KorElnoInqInfoVO[] getKorElnoInqInfoVOs(){
		KorElnoInqInfoVO[] vos = (KorElnoInqInfoVO[])models.toArray(new KorElnoInqInfoVO[models.size()]);
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
		this.keDivdWgtUtCd = this.keDivdWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keDivdWgt = this.keDivdWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kePckTpCd = this.kePckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keDivdPckUtCd = this.keDivdPckUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kePrtLodgSeq = this.kePrtLodgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keBkgNo = this.keBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kePrtLodgFlg = this.kePrtLodgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kePckQty = this.kePckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keDivdPckQty = this.keDivdPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keKrXptPckId = this.keKrXptPckId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keWgtUtCd = this.keWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclTpCd = this.cstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keXptLicNo = this.keXptLicNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keTrnsSeq = this.keTrnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keCstmsDeclTpCd = this.keCstmsDeclTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keCntrWgt = this.keCntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
