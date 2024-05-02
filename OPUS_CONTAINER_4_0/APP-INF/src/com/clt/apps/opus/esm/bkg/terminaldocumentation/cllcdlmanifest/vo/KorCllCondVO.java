/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorCllCondVO.java
*@FileTitle : KorCllCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier :
*@LastVersion : 1.0
* 2010.02.18
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCllCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<KorCllCondVO> models = new ArrayList<KorCllCondVO>();

	/* Column Info */
	private String inRcvId = null;
	/* Column Info */
	private String inKtmlCd = null;
	/* Column Info */
	private String inSkdVoyNo = null;
	/* Column Info */
	private String inWhereGubun = null;
	/* Column Info */
	private String inSortType = null;
	/* Column Info */
	private String inSkdDirCd = null;
	/* Column Info */
	private String inBkgStsCd = null;
	/* Column Info */
	private String inPolYdCd = null;
	/* Column Info */
	private String inUiType = null;
	/* Column Info */
	private String inCntrCfmFlg = null;
	/* Column Info */
	private String inVslCd = null;
	/* Column Info */
	private String inCllType = null;
	/* Column Info */
	private String inBkgOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inPolCntCd = null;
	/* Column Info */
	private String inType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String inByType = null;
	/* Column Info */
	private String inFinalEdiFlg = null;
	/* Column Info */
	private String inPgmNo = null;
	/* Column Info */
	private String inBlCllData = null;
	/* Column Info */
	private String inEdiMsgTp = null;
	/* Column Info */
	private String bkgNoList = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public KorCllCondVO() {}

	public KorCllCondVO(String ibflag, String pagerows, String inRcvId, String inKtmlCd, String inSkdVoyNo, String inWhereGubun, String inSortType, String inSkdDirCd, String inBkgStsCd, String inPolYdCd, String inUiType, String inCntrCfmFlg, String inVslCd, String inBkgOfcCd, String inCllType, String inType, String inPolCd, String inVvdCd, String inByType, String inPolCntCd, String inFinalEdiFlg,String inPgmNo, String inBlCllData, String inEdiMsgTp, String bkgNoList) {
		this.inRcvId = inRcvId;
		this.inKtmlCd = inKtmlCd;
		this.inSkdVoyNo = inSkdVoyNo;
		this.inWhereGubun = inWhereGubun;
		this.inSortType = inSortType;
		this.inSkdDirCd = inSkdDirCd;
		this.inBkgStsCd = inBkgStsCd;
		this.inPolYdCd = inPolYdCd;
		this.inUiType = inUiType;
		this.inCntrCfmFlg = inCntrCfmFlg;
		this.inVslCd = inVslCd;
		this.inCllType = inCllType;
		this.inBkgOfcCd = inBkgOfcCd;
		this.pagerows = pagerows;
		this.inPolCntCd = inPolCntCd;
		this.inType = inType;
		this.ibflag = ibflag;
		this.inPolCd = inPolCd;
		this.inVvdCd = inVvdCd;
		this.inByType = inByType;
		this.inFinalEdiFlg = inFinalEdiFlg;
		this.inPgmNo = inPgmNo;
		this.inBlCllData = inBlCllData;
		this.inEdiMsgTp = inEdiMsgTp;
		this.bkgNoList = bkgNoList;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_rcv_id", getInRcvId());
		this.hashColumns.put("in_ktml_cd", getInKtmlCd());
		this.hashColumns.put("in_skd_voy_no", getInSkdVoyNo());
		this.hashColumns.put("in_where_gubun", getInWhereGubun());
		this.hashColumns.put("in_sort_type", getInSortType());
		this.hashColumns.put("in_skd_dir_cd", getInSkdDirCd());
		this.hashColumns.put("in_bkg_sts_cd", getInBkgStsCd());
		this.hashColumns.put("in_pol_yd_cd", getInPolYdCd());
		this.hashColumns.put("in_ui_type", getInUiType());
		this.hashColumns.put("in_cntr_cfm_flg", getInCntrCfmFlg());
		this.hashColumns.put("in_vsl_cd", getInVslCd());
		this.hashColumns.put("in_cll_type", getInCllType());
		this.hashColumns.put("in_bkg_ofc_cd", getInBkgOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("in_pol_cnt_cd", getInPolCntCd());
		this.hashColumns.put("in_type", getInType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("in_by_type", getInByType());
		this.hashColumns.put("in_final_edi_flg", getInFinalEdiFlg());
		this.hashColumns.put("in_pgm_no", getInPgmNo());
		this.hashColumns.put("in_bl_cll_data", getInBlCllData());
		this.hashColumns.put("in_edi_msg_tp", getInEdiMsgTp());
		this.hashColumns.put("bkg_no_list", getBkgNoList());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_rcv_id", "inRcvId");
		this.hashFields.put("in_ktml_cd", "inKtmlCd");
		this.hashFields.put("in_skd_voy_no", "inSkdVoyNo");
		this.hashFields.put("in_where_gubun", "inWhereGubun");
		this.hashFields.put("in_sort_type", "inSortType");
		this.hashFields.put("in_skd_dir_cd", "inSkdDirCd");
		this.hashFields.put("in_bkg_sts_cd", "inBkgStsCd");
		this.hashFields.put("in_pol_yd_cd", "inPolYdCd");
		this.hashFields.put("in_ui_type", "inUiType");
		this.hashFields.put("in_cntr_cfm_flg", "inCntrCfmFlg");
		this.hashFields.put("in_vsl_cd", "inVslCd");
		this.hashFields.put("in_cll_type", "inCllType");
		this.hashFields.put("in_bkg_ofc_cd", "inBkgOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("in_pol_cnt_cd", "inPolCntCd");
		this.hashFields.put("in_type", "inType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("in_by_type", "inByType");
		this.hashFields.put("in_final_edi_flg", "inFinalEdiFlg");
		this.hashFields.put("in_pgm_no", "inPgmNo");
		this.hashFields.put("in_bl_cll_data","inBlCllData");
		this.hashFields.put("in_edi_msg_tp","inEdiMsgTp");
		this.hashFields.put("bkg_no_list","bkgNoList");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return inRcvId
	 */
	public String getInRcvId() {
		return this.inRcvId;
	}

	/**
	 * Column Info
	 * @return inKtmlCd
	 */
	public String getInKtmlCd() {
		return this.inKtmlCd;
	}

	/**
	 * Column Info
	 * @return inSkdVoyNo
	 */
	public String getInSkdVoyNo() {
		return this.inSkdVoyNo;
	}

	/**
	 * Column Info
	 * @return inWhereGubun
	 */
	public String getInWhereGubun() {
		return this.inWhereGubun;
	}

	/**
	 * Column Info
	 * @return inSortType
	 */
	public String getInSortType() {
		return this.inSortType;
	}

	/**
	 * Column Info
	 * @return inSkdDirCd
	 */
	public String getInSkdDirCd() {
		return this.inSkdDirCd;
	}

	/**
	 * Column Info
	 * @return inBkgStsCd
	 */
	public String getInBkgStsCd() {
		return this.inBkgStsCd;
	}

	/**
	 * Column Info
	 * @return inPolYdCd
	 */
	public String getInPolYdCd() {
		return this.inPolYdCd;
	}

	/**
	 * Column Info
	 * @return inUiType
	 */
	public String getInUiType() {
		return this.inUiType;
	}

	/**
	 * Column Info
	 * @return inCntrCfmFlg
	 */
	public String getInCntrCfmFlg() {
		return this.inCntrCfmFlg;
	}

	/**
	 * Column Info
	 * @return inVslCd
	 */
	public String getInVslCd() {
		return this.inVslCd;
	}

	/**
	 * Column Info
	 * @return inCllType
	 */
	public String getInCllType() {
		return this.inCllType;
	}

	/**
	 * Column Info
	 * @return inBkgOfcCd
	 */
	public String getInBkgOfcCd() {
		return this.inBkgOfcCd;
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
	 * @return inPolCntCd
	 */
	public String getInPolCntCd() {
		return this.inPolCntCd;
	}

	/**
	 * Column Info
	 * @return inType
	 */
	public String getInType() {
		return this.inType;
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
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
	}

	/**
	 * Column Info
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}

	/**
	 * Column Info
	 * @return inByType
	 */
	public String getInByType() {
		return this.inByType;
	}

	/**
	 * Column Info
	 * @return inFinalEdiFlg
	 */
	public String getInFinalEdiFlg() {
		return this.inFinalEdiFlg;
	}
	/**
	 * Column Info
	 * @return inPgmNo
	 */
	public String getInPgmNo() {
		return this.inPgmNo;
	}

	/**
	 * Column Info
	 * @return inBlCllData
	 */
	public String getInBlCllData() {
		return this.inBlCllData;
	}
	
	/**
	 * Column Info
	 * @return inEdiMsgTp
	 */
	public String getInEdiMsgTp() {
		return this.inEdiMsgTp;
	}
	
	/**
	 * Column Info
	 * @return bkgNoList
	 */
	public String getBkgNoList() {
		return this.bkgNoList;
	}

	/**
	 * Column Info
	 * @param inRcvId
	 */
	public void setInRcvId(String inRcvId) {
		this.inRcvId = inRcvId;
	}

	/**
	 * Column Info
	 * @param inKtmlCd
	 */
	public void setInKtmlCd(String inKtmlCd) {
		this.inKtmlCd = inKtmlCd;
	}

	/**
	 * Column Info
	 * @param inSkdVoyNo
	 */
	public void setInSkdVoyNo(String inSkdVoyNo) {
		this.inSkdVoyNo = inSkdVoyNo;
	}

	/**
	 * Column Info
	 * @param inWhereGubun
	 */
	public void setInWhereGubun(String inWhereGubun) {
		this.inWhereGubun = inWhereGubun;
	}

	/**
	 * Column Info
	 * @param inSortType
	 */
	public void setInSortType(String inSortType) {
		this.inSortType = inSortType;
	}

	/**
	 * Column Info
	 * @param inSkdDirCd
	 */
	public void setInSkdDirCd(String inSkdDirCd) {
		this.inSkdDirCd = inSkdDirCd;
	}

	/**
	 * Column Info
	 * @param inBkgStsCd
	 */
	public void setInBkgStsCd(String inBkgStsCd) {
		this.inBkgStsCd = inBkgStsCd;
	}

	/**
	 * Column Info
	 * @param inPolYdCd
	 */
	public void setInPolYdCd(String inPolYdCd) {
		this.inPolYdCd = inPolYdCd;
	}

	/**
	 * Column Info
	 * @param inUiType
	 */
	public void setInUiType(String inUiType) {
		this.inUiType = inUiType;
	}

	/**
	 * Column Info
	 * @param inCntrCfmFlg
	 */
	public void setInCntrCfmFlg(String inCntrCfmFlg) {
		this.inCntrCfmFlg = inCntrCfmFlg;
	}

	/**
	 * Column Info
	 * @param inVslCd
	 */
	public void setInVslCd(String inVslCd) {
		this.inVslCd = inVslCd;
	}

	/**
	 * Column Info
	 * @param inCllType
	 */
	public void setInCllType(String inCllType) {
		this.inCllType = inCllType;
	}

	/**
	 * Column Info
	 * @param inBkgOfcCd
	 */
	public void setInBkgOfcCd(String inBkgOfcCd) {
		this.inBkgOfcCd = inBkgOfcCd;
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
	 * @param inPolCntCd
	 */
	public void setInPolCntCd(String inPolCntCd) {
		this.inPolCntCd = inPolCntCd;
	}

	/**
	 * Column Info
	 * @param inType
	 */
	public void setInType(String inType) {
		this.inType = inType;
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
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
	}

	/**
	 * Column Info
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}

	/**
	 * Column Info
	 * @param inByType
	 */
	public void setInByType(String inByType) {
		this.inByType = inByType;
	}

	/**
	 * Column Info
	 * @param inFinalEdiFlg
	 */
	public void setInFinalEdiFlg(String inFinalEdiFlg) {
		this.inFinalEdiFlg = inFinalEdiFlg;
	}
	/**
	 * Column Info
	 * @param inPgmNo
	 */
	public void setInPgmNo(String inPgmNo) {
		this.inPgmNo = inPgmNo;
	}
	
	/**
	 * Column Info
	 * @param inBlCllData
	 */
	public void setInBlCllData(String inBlCllData) {
		this.inBlCllData = inBlCllData;
	}
	
	/**
	 * Column Info
	 * @param inEdiMsgTp
	 */
	public void setInEdiMsgTp(String inEdiMsgTp) {
		this.inEdiMsgTp = inEdiMsgTp;
	}
	
	/**
	 * Column Info
	 * @param bkgNoList
	 */
	public void setBkgNoList(String bkgNoList) {
		this.bkgNoList = bkgNoList;
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
		setInRcvId(JSPUtil.getParameter(request, prefix + "in_rcv_id", ""));
		setInKtmlCd(JSPUtil.getParameter(request, prefix + "in_ktml_cd", ""));
		setInSkdVoyNo(JSPUtil.getParameter(request, prefix + "in_skd_voy_no", ""));
		setInWhereGubun(JSPUtil.getParameter(request, prefix + "in_where_gubun", ""));
		setInSortType(JSPUtil.getParameter(request, prefix + "in_sort_type", ""));
		setInSkdDirCd(JSPUtil.getParameter(request, prefix + "in_skd_dir_cd", ""));
		setInBkgStsCd(JSPUtil.getParameter(request, prefix + "in_bkg_sts_cd", ""));
		setInPolYdCd(JSPUtil.getParameter(request, prefix + "in_pol_yd_cd", ""));
		setInUiType(JSPUtil.getParameter(request, prefix + "in_ui_type", ""));
		setInCntrCfmFlg(JSPUtil.getParameter(request, prefix + "in_cntr_cfm_flg", ""));
		setInVslCd(JSPUtil.getParameter(request, prefix + "in_vsl_cd", ""));
		setInCllType(JSPUtil.getParameter(request, prefix + "in_cll_type", ""));
		setInBkgOfcCd(JSPUtil.getParameter(request, prefix + "in_bkg_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInPolCntCd(JSPUtil.getParameter(request, prefix + "in_pol_cnt_cd", ""));
		setInType(JSPUtil.getParameter(request, prefix + "in_type", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInPolCd(JSPUtil.getParameter(request, prefix + "in_pol_cd", ""));
		setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
		setInByType(JSPUtil.getParameter(request, prefix + "in_by_type", ""));
		setInFinalEdiFlg(JSPUtil.getParameter(request, prefix + "in_final_edi_flg", ""));
		setInPgmNo(JSPUtil.getParameter(request, prefix + "in_pgm_no", ""));
		setInBlCllData(JSPUtil.getParameter(request, prefix + "in_bl_cll_data", ""));
		setInEdiMsgTp(JSPUtil.getParameter(request, prefix + "in_edi_msg_tp", ""));
		setBkgNoList(JSPUtil.getParameter(request, prefix + "bkg_no_list", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCllCondVO[]
	 */
	public KorCllCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return KorCllCondVO[]
	 */
	public KorCllCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCllCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] inRcvId = (JSPUtil.getParameter(request, prefix	+ "in_rcv_id", length));
			String[] inKtmlCd = (JSPUtil.getParameter(request, prefix	+ "in_ktml_cd", length));
			String[] inSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "in_skd_voy_no", length));
			String[] inWhereGubun = (JSPUtil.getParameter(request, prefix	+ "in_where_gubun", length));
			String[] inSortType = (JSPUtil.getParameter(request, prefix	+ "in_sort_type", length));
			String[] inSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "in_skd_dir_cd", length));
			String[] inBkgStsCd = (JSPUtil.getParameter(request, prefix	+ "in_bkg_sts_cd", length));
			String[] inPolYdCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_yd_cd", length));
			String[] inUiType = (JSPUtil.getParameter(request, prefix	+ "in_ui_type", length));
			String[] inCntrCfmFlg = (JSPUtil.getParameter(request, prefix	+ "in_cntr_cfm_flg", length));
			String[] inVslCd = (JSPUtil.getParameter(request, prefix	+ "in_vsl_cd", length));
			String[] inCllType = (JSPUtil.getParameter(request, prefix	+ "in_cll_type", length));
			String[] inBkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "in_bkg_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inPolCntCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cnt_cd", length));
			String[] inType = (JSPUtil.getParameter(request, prefix	+ "in_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] inByType = (JSPUtil.getParameter(request, prefix	+ "in_by_type", length));
			String[] inFinalEdiFlg = (JSPUtil.getParameter(request, prefix	+ "in_final_edi_flg", length));
			String[] inPgmNo = (JSPUtil.getParameter(request, prefix	+ "in_pgm_no", length));
			String[] inBlCllData = (JSPUtil.getParameter(request, prefix + "in_bl_cll_data", length));
			String[] inEdiMsgTp = (JSPUtil.getParameter(request, prefix + "in_edi_msg_tp", length));
			String[] bkgNoList = (JSPUtil.getParameter(request, prefix + "bkg_no_list", length));

			for (int i = 0; i < length; i++) {
				model = new KorCllCondVO();
				if (inRcvId[i] != null)
					model.setInRcvId(inRcvId[i]);
				if (inKtmlCd[i] != null)
					model.setInKtmlCd(inKtmlCd[i]);
				if (inSkdVoyNo[i] != null)
					model.setInSkdVoyNo(inSkdVoyNo[i]);
				if (inWhereGubun[i] != null)
					model.setInWhereGubun(inWhereGubun[i]);
				if (inSortType[i] != null)
					model.setInSortType(inSortType[i]);
				if (inSkdDirCd[i] != null)
					model.setInSkdDirCd(inSkdDirCd[i]);
				if (inBkgStsCd[i] != null)
					model.setInBkgStsCd(inBkgStsCd[i]);
				if (inPolYdCd[i] != null)
					model.setInPolYdCd(inPolYdCd[i]);
				if (inUiType[i] != null)
					model.setInUiType(inUiType[i]);
				if (inCntrCfmFlg[i] != null)
					model.setInCntrCfmFlg(inCntrCfmFlg[i]);
				if (inVslCd[i] != null)
					model.setInVslCd(inVslCd[i]);
				if (inCllType[i] != null)
					model.setInCllType(inCllType[i]);
				if (inBkgOfcCd[i] != null)
					model.setInBkgOfcCd(inBkgOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inPolCntCd[i] != null)
					model.setInPolCntCd(inPolCntCd[i]);
				if (inType[i] != null)
					model.setInType(inType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (inByType[i] != null)
					model.setInByType(inByType[i]);
				if (inFinalEdiFlg[i] != null)
					model.setInFinalEdiFlg(inFinalEdiFlg[i]);
				if (inPgmNo[i] != null)
					model.setInPgmNo(inPgmNo[i]);
				if (inBlCllData[i] != null)
					model.setInBlCllData(inBlCllData[i]);
				if (inEdiMsgTp[i] != null)
					model.setInEdiMsgTp(inEdiMsgTp[i]);
				if (bkgNoList[i] != null)
					model.setBkgNoList(bkgNoList[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCllCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCllCondVO[]
	 */
	public KorCllCondVO[] getKorCllCondVOs(){
		KorCllCondVO[] vos = (KorCllCondVO[])models.toArray(new KorCllCondVO[models.size()]);
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
		this.inRcvId = this.inRcvId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inKtmlCd = this.inKtmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdVoyNo = this.inSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inWhereGubun = this.inWhereGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSortType = this.inSortType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdDirCd = this.inSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgStsCd = this.inBkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolYdCd = this.inPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inUiType = this.inUiType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrCfmFlg = this.inCntrCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslCd = this.inVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCllType = this.inCllType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgOfcCd = this.inBkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCntCd = this.inPolCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inType = this.inType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inByType = this.inByType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inFinalEdiFlg = this.inFinalEdiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPgmNo = this.inPgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBlCllData = this.inBlCllData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inEdiMsgTp = this.inEdiMsgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoList = this.bkgNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
