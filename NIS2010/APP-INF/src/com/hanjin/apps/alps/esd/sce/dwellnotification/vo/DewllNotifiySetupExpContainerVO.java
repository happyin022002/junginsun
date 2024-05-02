/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DewllNotifiySetupExpContainerVO.java
*@FileTitle : DewllNotifiySetupExpContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2011.11.15 채창호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.dwellnotification.vo;

import java.lang.reflect.Field;
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
 * @author 채창호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DewllNotifiySetupExpContainerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DewllNotifiySetupExpContainerVO> models = new ArrayList<DewllNotifiySetupExpContainerVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dwllExptRmk = null;
	/* Column Info */
	private String cntrTmlDwllFlg = null;
	/* Column Info */
	private String cntrDestDwllFlg = null;
	/* Column Info */
	private String exptSetOfcCd = null;
	/* Column Info */
	private String exptSetUsrId = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mstBkgNo = null;
	/* Column Info */
	private String exptSetDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnmvIdNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrNo1 = null;
	/* Column Info */
	private String cntrVslDlayFlg = null;
	/* Column Info */
	private String cntrEnrDwllFlg = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dwellType = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String cntrDwllExptFlg = null;
	/* Column Info */
	private String row = null;
	/* Column Info */
	private String msg = null;
	


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DewllNotifiySetupExpContainerVO() {}

	public DewllNotifiySetupExpContainerVO(String ibflag, String pagerows, String cntrNo, String cnmvYr, String cnmvIdNo, String cnmvCycNo, String mstBkgNo, String cntrTmlDwllFlg, String cntrEnrDwllFlg, String cntrDestDwllFlg, String cntrVslDlayFlg, String exptSetOfcCd, String exptSetUsrId, String exptSetDt, String dwllExptRmk, String creUsrId, String creDt, String updUsrId, String updDt
			                              ,String dwellType ,String cntrDwllExptFlg,String row, String cntrNo1, String userId ,String msg ) {
		this.updDt = updDt;
		this.dwllExptRmk = dwllExptRmk;
		this.cntrTmlDwllFlg = cntrTmlDwllFlg;
		this.cntrDestDwllFlg = cntrDestDwllFlg;
		this.exptSetOfcCd = exptSetOfcCd;
		this.exptSetUsrId = exptSetUsrId;
		this.cnmvCycNo = cnmvCycNo;
		this.creDt = creDt;
		this.mstBkgNo = mstBkgNo;
		this.exptSetDt = exptSetDt;
		this.pagerows = pagerows;
		this.cnmvIdNo = cnmvIdNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.cntrNo1 = cntrNo1;
		this.cntrVslDlayFlg = cntrVslDlayFlg;
		this.cntrEnrDwllFlg = cntrEnrDwllFlg;
		this.cnmvYr = cnmvYr;
		this.updUsrId = updUsrId;
		this.dwellType = dwellType;
		this.cntrDwllExptFlg = cntrDwllExptFlg;
		this.row = row;
		this.userId = userId;
		this.msg = msg;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("dwll_expt_rmk", getDwllExptRmk());
		this.hashColumns.put("cntr_tml_dwll_flg", getCntrTmlDwllFlg());
		this.hashColumns.put("cntr_dest_dwll_flg", getCntrDestDwllFlg());
		this.hashColumns.put("expt_set_ofc_cd", getExptSetOfcCd());
		this.hashColumns.put("expt_set_usr_id", getExptSetUsrId());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mst_bkg_no", getMstBkgNo());
		this.hashColumns.put("expt_set_dt", getExptSetDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_no1", getCntrNo1());
		this.hashColumns.put("cntr_vsl_dlay_flg", getCntrVslDlayFlg());
		this.hashColumns.put("cntr_enr_dwll_flg", getCntrEnrDwllFlg());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dwell_type", getDwellType());
		this.hashColumns.put("cntr_dwll_expt_flg", getCntrDwllExptFlg());
		this.hashColumns.put("row", getRow());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("msg", getMsg());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("dwll_expt_rmk", "dwllExptRmk");
		this.hashFields.put("cntr_tml_dwll_flg", "cntrTmlDwllFlg");
		this.hashFields.put("cntr_dest_dwll_flg", "cntrDestDwllFlg");
		this.hashFields.put("expt_set_ofc_cd", "exptSetOfcCd");
		this.hashFields.put("expt_set_usr_id", "exptSetUsrId");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mst_bkg_no", "mstBkgNo");
		this.hashFields.put("expt_set_dt", "exptSetDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_no1", "cntrNo1");
		this.hashFields.put("cntr_vsl_dlay_flg", "cntrVslDlayFlg");
		this.hashFields.put("cntr_enr_dwll_flg", "cntrEnrDwllFlg");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dwell_type", "dwellType");
		this.hashFields.put("cntr_dwll_expt_flg", "cntrDwllExptFlg");
		this.hashFields.put("row", "row");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("msg", "msg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return dwllExptRmk
	 */
	public String getDwllExptRmk() {
		return this.dwllExptRmk;
	}
	
	/**
	 * Column Info
	 * @return cntrTmlDwllFlg
	 */
	public String getCntrTmlDwllFlg() {
		return this.cntrTmlDwllFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrDestDwllFlg
	 */
	public String getCntrDestDwllFlg() {
		return this.cntrDestDwllFlg;
	}
	
	/**
	 * Column Info
	 * @return exptSetOfcCd
	 */
	public String getExptSetOfcCd() {
		return this.exptSetOfcCd;
	}
	
	/**
	 * Column Info
	 * @return exptSetUsrId
	 */
	public String getExptSetUsrId() {
		return this.exptSetUsrId;
	}
	
	/**
	 * Column Info
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return exptSetDt
	 */
	public String getExptSetDt() {
		return this.exptSetDt;
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
	 * @return cnmvIdNo
	 */
	public String getCnmvIdNo() {
		return this.cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrVslDlayFlg
	 */
	public String getCntrVslDlayFlg() {
		return this.cntrVslDlayFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrEnrDwllFlg
	 */
	public String getCntrEnrDwllFlg() {
		return this.cntrEnrDwllFlg;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param dwllExptRmk
	 */
	public void setDwllExptRmk(String dwllExptRmk) {
		this.dwllExptRmk = dwllExptRmk;
	}
	
	/**
	 * Column Info
	 * @param cntrTmlDwllFlg
	 */
	public void setCntrTmlDwllFlg(String cntrTmlDwllFlg) {
		this.cntrTmlDwllFlg = cntrTmlDwllFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrDestDwllFlg
	 */
	public void setCntrDestDwllFlg(String cntrDestDwllFlg) {
		this.cntrDestDwllFlg = cntrDestDwllFlg;
	}
	
	/**
	 * Column Info
	 * @param exptSetOfcCd
	 */
	public void setExptSetOfcCd(String exptSetOfcCd) {
		this.exptSetOfcCd = exptSetOfcCd;
	}
	
	/**
	 * Column Info
	 * @param exptSetUsrId
	 */
	public void setExptSetUsrId(String exptSetUsrId) {
		this.exptSetUsrId = exptSetUsrId;
	}
	
	/**
	 * Column Info
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param exptSetDt
	 */
	public void setExptSetDt(String exptSetDt) {
		this.exptSetDt = exptSetDt;
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
	 * @param cnmvIdNo
	 */
	public void setCnmvIdNo(String cnmvIdNo) {
		this.cnmvIdNo = cnmvIdNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrVslDlayFlg
	 */
	public void setCntrVslDlayFlg(String cntrVslDlayFlg) {
		this.cntrVslDlayFlg = cntrVslDlayFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrEnrDwllFlg
	 */
	public void setCntrEnrDwllFlg(String cntrEnrDwllFlg) {
		this.cntrEnrDwllFlg = cntrEnrDwllFlg;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * @return the dwellType
	 */
	public String getDwellType() {
	return dwellType;
	}

	/**
	 * @param dwellType the dwellType to set
	 */
	public void setDwellType(String dwellType) {
	this.dwellType = dwellType;
	}

	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	/**
	 * @return the cntrDwllExptFlg
	 */
	public String getCntrDwllExptFlg() {
		return cntrDwllExptFlg;
	}

	/**
	 * @param cntrDwllExptFlg the cntrDwllExptFlg to set
	 */
	public void setCntrDwllExptFlg(String cntrDwllExptFlg) {
		this.cntrDwllExptFlg = cntrDwllExptFlg;
	}

	
	/**
	 * @return the row
	 */
	public String getRow() {
		return row;
	}

	/**
	 * @param row the row to set
	 */
	public void setRow(String row) {
		this.row = row;
	}

	
	/**
	 * @return the cntrNo1
	 */
	public String getCntrNo1() {
		return cntrNo1;
	}

	/**
	 * @param cntrNo1 the cntrNo1 to set
	 */
	public void setCntrNo1(String cntrNo1) {
		this.cntrNo1 = cntrNo1;
	}

	
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDwllExptRmk(JSPUtil.getParameter(request, prefix + "dwll_expt_rmk", ""));
		setCntrTmlDwllFlg(JSPUtil.getParameter(request, prefix + "cntr_tml_dwll_flg", ""));
		setCntrDestDwllFlg(JSPUtil.getParameter(request, prefix + "cntr_dest_dwll_flg", ""));
		setExptSetOfcCd(JSPUtil.getParameter(request, prefix + "expt_set_ofc_cd", ""));
		setExptSetUsrId(JSPUtil.getParameter(request, prefix + "expt_set_usr_id", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, prefix + "cnmv_cyc_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMstBkgNo(JSPUtil.getParameter(request, prefix + "mst_bkg_no", ""));
		setExptSetDt(JSPUtil.getParameter(request, prefix + "expt_set_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCnmvIdNo(JSPUtil.getParameter(request, prefix + "cnmv_id_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrNo1(JSPUtil.getParameter(request, prefix + "cntr_no1", ""));
		setCntrVslDlayFlg(JSPUtil.getParameter(request, prefix + "cntr_vsl_dlay_flg", ""));
		setCntrEnrDwllFlg(JSPUtil.getParameter(request, prefix + "cntr_enr_dwll_flg", ""));
		setCnmvYr(JSPUtil.getParameter(request, prefix + "cnmv_yr", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDwellType(JSPUtil.getParameter(request, prefix + "dwell_type", ""));
		setCntrDwllExptFlg(JSPUtil.getParameter(request, prefix + "cntr_dwll_expt_flg", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setRow(JSPUtil.getParameter(request, prefix + "row", ""));
		setMsg(JSPUtil.getParameter(request, prefix + "msg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DewllNotifiySetupExpContainerVO[]
	 */
	public DewllNotifiySetupExpContainerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DewllNotifiySetupExpContainerVO[]
	 */
	public DewllNotifiySetupExpContainerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DewllNotifiySetupExpContainerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dwllExptRmk = (JSPUtil.getParameter(request, prefix	+ "dwll_expt_rmk", length));
			String[] cntrTmlDwllFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_tml_dwll_flg", length));
			String[] cntrDestDwllFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dest_dwll_flg", length));
			String[] exptSetOfcCd = (JSPUtil.getParameter(request, prefix	+ "expt_set_ofc_cd", length));
			String[] exptSetUsrId = (JSPUtil.getParameter(request, prefix	+ "expt_set_usr_id", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mstBkgNo = (JSPUtil.getParameter(request, prefix	+ "mst_bkg_no", length));
			String[] exptSetDt = (JSPUtil.getParameter(request, prefix	+ "expt_set_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnmvIdNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_id_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_no1", length));
			String[] cntrVslDlayFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_vsl_dlay_flg", length));
			String[] cntrEnrDwllFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_enr_dwll_flg", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dwellType = (JSPUtil.getParameter(request, prefix	+ "dwell_type", length));
			String[] cntrDwllExptFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dwll_expt_flg", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] row    = (JSPUtil.getParameter(request, prefix	+ "row", length));
			String[] msg    = (JSPUtil.getParameter(request, prefix	+ "msg", length));
			
			for (int i = 0; i < length; i++) {
				model = new DewllNotifiySetupExpContainerVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dwllExptRmk[i] != null)
					model.setDwllExptRmk(dwllExptRmk[i]);
				if (cntrTmlDwllFlg[i] != null)
					model.setCntrTmlDwllFlg(cntrTmlDwllFlg[i]);
				if (cntrDestDwllFlg[i] != null)
					model.setCntrDestDwllFlg(cntrDestDwllFlg[i]);
				if (exptSetOfcCd[i] != null)
					model.setExptSetOfcCd(exptSetOfcCd[i]);
				if (exptSetUsrId[i] != null)
					model.setExptSetUsrId(exptSetUsrId[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mstBkgNo[i] != null)
					model.setMstBkgNo(mstBkgNo[i]);
				if (exptSetDt[i] != null)
					model.setExptSetDt(exptSetDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnmvIdNo[i] != null)
					model.setCnmvIdNo(cnmvIdNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrNo1[i] != null)
					model.setCntrNo1(cntrNo1[i]);
				if (cntrVslDlayFlg[i] != null)
					model.setCntrVslDlayFlg(cntrVslDlayFlg[i]);
				if (cntrEnrDwllFlg[i] != null)
					model.setCntrEnrDwllFlg(cntrEnrDwllFlg[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dwellType[i] != null)
					model.setDwellType(dwellType[i]);
				if (cntrDwllExptFlg[i] != null)
					model.setCntrDwllExptFlg(cntrDwllExptFlg[i]);
				if (row[i] != null)
					model.setRow(row[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (msg[i] != null)
					model.setMsg(msg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDewllNotifiySetupExpContainerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DewllNotifiySetupExpContainerVO[]
	 */
	public DewllNotifiySetupExpContainerVO[] getDewllNotifiySetupExpContainerVOs(){
		DewllNotifiySetupExpContainerVO[] vos = (DewllNotifiySetupExpContainerVO[])models.toArray(new DewllNotifiySetupExpContainerVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwllExptRmk = this.dwllExptRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTmlDwllFlg = this.cntrTmlDwllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDestDwllFlg = this.cntrDestDwllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptSetOfcCd = this.exptSetOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptSetUsrId = this.exptSetUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBkgNo = this.mstBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptSetDt = this.exptSetDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo = this.cnmvIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo1 = this.cntrNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVslDlayFlg = this.cntrVslDlayFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrEnrDwllFlg = this.cntrEnrDwllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwellType = this.dwellType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDwllExptFlg = this.cntrDwllExptFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row = this.row.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msg = this.msg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
