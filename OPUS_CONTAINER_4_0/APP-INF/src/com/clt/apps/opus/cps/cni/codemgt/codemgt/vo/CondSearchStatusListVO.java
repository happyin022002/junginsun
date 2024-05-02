/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CondSearchStatusListVO.java
*@FileTitle : CondSearchStatusListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.04.23 정행룡 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.codemgt.codemgt.vo;

import java.lang.reflect.Field;
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
 * @author 정행룡
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CondSearchStatusListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondSearchStatusListVO> models = new ArrayList<CondSearchStatusListVO>();
	
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String lablPtyClmPtyNo = null;
	/* Column Info */
	private String dwClmRefVvdNo = null;
	/* Column Info */
	private String deftClmPtyNo = null;
	/* Column Info */
	private String clmtClmPtyNo = null;
	/* Column Info */
	private String dateType = null;
	/* Column Info */
	private String dwClmTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dwCoCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String dwClmStsCd = null;
	/* Column Info */
	private String dwClmAttDefTpCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String insurClmPtyNo = null;
	/* Column Info */
	private String inciPlcTpCd = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String dwClmNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CondSearchStatusListVO() {}

	public CondSearchStatusListVO(String ibflag, String pagerows, String dwClmNo, String dwClmTpCd, String dwCoCd, String dwClmRefVvdNo, String vslEngNm, String inciPlcTpCd, String creOfcCd, String hdlrOfcCd, String hdlrUsrId, String dwClmStsCd, String dwClmAttDefTpCd, String clmtClmPtyNo, String insurClmPtyNo, String deftClmPtyNo, String lablPtyClmPtyNo, String creUsrId, String dateType, String fromDt, String toDt) {
		this.fromDt = fromDt;
		this.lablPtyClmPtyNo = lablPtyClmPtyNo;
		this.dwClmRefVvdNo = dwClmRefVvdNo;
		this.deftClmPtyNo = deftClmPtyNo;
		this.clmtClmPtyNo = clmtClmPtyNo;
		this.dateType = dateType;
		this.dwClmTpCd = dwClmTpCd;
		this.pagerows = pagerows;
		this.hdlrUsrId = hdlrUsrId;
		this.toDt = toDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.dwCoCd = dwCoCd;
		this.vslEngNm = vslEngNm;
		this.dwClmStsCd = dwClmStsCd;
		this.dwClmAttDefTpCd = dwClmAttDefTpCd;
		this.creOfcCd = creOfcCd;
		this.insurClmPtyNo = insurClmPtyNo;
		this.inciPlcTpCd = inciPlcTpCd;
		this.hdlrOfcCd = hdlrOfcCd;
		this.dwClmNo = dwClmNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("labl_pty_clm_pty_no", getLablPtyClmPtyNo());
		this.hashColumns.put("dw_clm_ref_vvd_no", getDwClmRefVvdNo());
		this.hashColumns.put("deft_clm_pty_no", getDeftClmPtyNo());
		this.hashColumns.put("clmt_clm_pty_no", getClmtClmPtyNo());
		this.hashColumns.put("date_type", getDateType());
		this.hashColumns.put("dw_clm_tp_cd", getDwClmTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dw_co_cd", getDwCoCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("dw_clm_sts_cd", getDwClmStsCd());
		this.hashColumns.put("dw_clm_att_def_tp_cd", getDwClmAttDefTpCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("insur_clm_pty_no", getInsurClmPtyNo());
		this.hashColumns.put("inci_plc_tp_cd", getInciPlcTpCd());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("dw_clm_no", getDwClmNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("labl_pty_clm_pty_no", "lablPtyClmPtyNo");
		this.hashFields.put("dw_clm_ref_vvd_no", "dwClmRefVvdNo");
		this.hashFields.put("deft_clm_pty_no", "deftClmPtyNo");
		this.hashFields.put("clmt_clm_pty_no", "clmtClmPtyNo");
		this.hashFields.put("date_type", "dateType");
		this.hashFields.put("dw_clm_tp_cd", "dwClmTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dw_co_cd", "dwCoCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("dw_clm_sts_cd", "dwClmStsCd");
		this.hashFields.put("dw_clm_att_def_tp_cd", "dwClmAttDefTpCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("insur_clm_pty_no", "insurClmPtyNo");
		this.hashFields.put("inci_plc_tp_cd", "inciPlcTpCd");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("dw_clm_no", "dwClmNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyClmPtyNo
	 */
	public String getLablPtyClmPtyNo() {
		return this.lablPtyClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return dwClmRefVvdNo
	 */
	public String getDwClmRefVvdNo() {
		return this.dwClmRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return deftClmPtyNo
	 */
	public String getDeftClmPtyNo() {
		return this.deftClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return clmtClmPtyNo
	 */
	public String getClmtClmPtyNo() {
		return this.clmtClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return dateType
	 */
	public String getDateType() {
		return this.dateType;
	}
	
	/**
	 * Column Info
	 * @return dwClmTpCd
	 */
	public String getDwClmTpCd() {
		return this.dwClmTpCd;
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
	 * @return hdlrUsrId
	 */
	public String getHdlrUsrId() {
		return this.hdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return dwCoCd
	 */
	public String getDwCoCd() {
		return this.dwCoCd;
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
	 * @return dwClmStsCd
	 */
	public String getDwClmStsCd() {
		return this.dwClmStsCd;
	}
	
	/**
	 * Column Info
	 * @return dwClmAttDefTpCd
	 */
	public String getDwClmAttDefTpCd() {
		return this.dwClmAttDefTpCd;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyNo
	 */
	public String getInsurClmPtyNo() {
		return this.insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return inciPlcTpCd
	 */
	public String getInciPlcTpCd() {
		return this.inciPlcTpCd;
	}
	
	/**
	 * Column Info
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dwClmNo
	 */
	public String getDwClmNo() {
		return this.dwClmNo;
	}
	

	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyClmPtyNo
	 */
	public void setLablPtyClmPtyNo(String lablPtyClmPtyNo) {
		this.lablPtyClmPtyNo = lablPtyClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param dwClmRefVvdNo
	 */
	public void setDwClmRefVvdNo(String dwClmRefVvdNo) {
		this.dwClmRefVvdNo = dwClmRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param deftClmPtyNo
	 */
	public void setDeftClmPtyNo(String deftClmPtyNo) {
		this.deftClmPtyNo = deftClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param clmtClmPtyNo
	 */
	public void setClmtClmPtyNo(String clmtClmPtyNo) {
		this.clmtClmPtyNo = clmtClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param dateType
	 */
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	
	/**
	 * Column Info
	 * @param dwClmTpCd
	 */
	public void setDwClmTpCd(String dwClmTpCd) {
		this.dwClmTpCd = dwClmTpCd;
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
	 * @param hdlrUsrId
	 */
	public void setHdlrUsrId(String hdlrUsrId) {
		this.hdlrUsrId = hdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param dwCoCd
	 */
	public void setDwCoCd(String dwCoCd) {
		this.dwCoCd = dwCoCd;
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
	 * @param dwClmStsCd
	 */
	public void setDwClmStsCd(String dwClmStsCd) {
		this.dwClmStsCd = dwClmStsCd;
	}
	
	/**
	 * Column Info
	 * @param dwClmAttDefTpCd
	 */
	public void setDwClmAttDefTpCd(String dwClmAttDefTpCd) {
		this.dwClmAttDefTpCd = dwClmAttDefTpCd;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyNo
	 */
	public void setInsurClmPtyNo(String insurClmPtyNo) {
		this.insurClmPtyNo = insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param inciPlcTpCd
	 */
	public void setInciPlcTpCd(String inciPlcTpCd) {
		this.inciPlcTpCd = inciPlcTpCd;
	}
	
	/**
	 * Column Info
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dwClmNo
	 */
	public void setDwClmNo(String dwClmNo) {
		this.dwClmNo = dwClmNo;
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
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setLablPtyClmPtyNo(JSPUtil.getParameter(request, prefix + "labl_pty_clm_pty_no", ""));
		setDwClmRefVvdNo(JSPUtil.getParameter(request, prefix + "dw_clm_ref_vvd_no", ""));
		setDeftClmPtyNo(JSPUtil.getParameter(request, prefix + "deft_clm_pty_no", ""));
		setClmtClmPtyNo(JSPUtil.getParameter(request, prefix + "clmt_clm_pty_no", ""));
		setDateType(JSPUtil.getParameter(request, prefix + "date_type", ""));
		setDwClmTpCd(JSPUtil.getParameter(request, prefix + "dw_clm_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, prefix + "hdlr_usr_id", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDwCoCd(JSPUtil.getParameter(request, prefix + "dw_co_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setDwClmStsCd(JSPUtil.getParameter(request, prefix + "dw_clm_sts_cd", ""));
		setDwClmAttDefTpCd(JSPUtil.getParameter(request, prefix + "dw_clm_att_def_tp_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setInsurClmPtyNo(JSPUtil.getParameter(request, prefix + "insur_clm_pty_no", ""));
		setInciPlcTpCd(JSPUtil.getParameter(request, prefix + "inci_plc_tp_cd", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
		setDwClmNo(JSPUtil.getParameter(request, prefix + "dw_clm_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CondSearchStatusListVO[]
	 */
	public CondSearchStatusListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CondSearchStatusListVO[]
	 */
	public CondSearchStatusListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondSearchStatusListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] lablPtyClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "labl_pty_clm_pty_no", length));
			String[] dwClmRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "dw_clm_ref_vvd_no", length));
			String[] deftClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "deft_clm_pty_no", length));
			String[] clmtClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_pty_no", length));
			String[] dateType = (JSPUtil.getParameter(request, prefix	+ "date_type", length));
			String[] dwClmTpCd = (JSPUtil.getParameter(request, prefix	+ "dw_clm_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dwCoCd = (JSPUtil.getParameter(request, prefix	+ "dw_co_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] dwClmStsCd = (JSPUtil.getParameter(request, prefix	+ "dw_clm_sts_cd", length));
			String[] dwClmAttDefTpCd = (JSPUtil.getParameter(request, prefix	+ "dw_clm_att_def_tp_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] insurClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no", length));
			String[] inciPlcTpCd = (JSPUtil.getParameter(request, prefix	+ "inci_plc_tp_cd", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] dwClmNo = (JSPUtil.getParameter(request, prefix	+ "dw_clm_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CondSearchStatusListVO();
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (lablPtyClmPtyNo[i] != null)
					model.setLablPtyClmPtyNo(lablPtyClmPtyNo[i]);
				if (dwClmRefVvdNo[i] != null)
					model.setDwClmRefVvdNo(dwClmRefVvdNo[i]);
				if (deftClmPtyNo[i] != null)
					model.setDeftClmPtyNo(deftClmPtyNo[i]);
				if (clmtClmPtyNo[i] != null)
					model.setClmtClmPtyNo(clmtClmPtyNo[i]);
				if (dateType[i] != null)
					model.setDateType(dateType[i]);
				if (dwClmTpCd[i] != null)
					model.setDwClmTpCd(dwClmTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dwCoCd[i] != null)
					model.setDwCoCd(dwCoCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (dwClmStsCd[i] != null)
					model.setDwClmStsCd(dwClmStsCd[i]);
				if (dwClmAttDefTpCd[i] != null)
					model.setDwClmAttDefTpCd(dwClmAttDefTpCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (insurClmPtyNo[i] != null)
					model.setInsurClmPtyNo(insurClmPtyNo[i]);
				if (inciPlcTpCd[i] != null)
					model.setInciPlcTpCd(inciPlcTpCd[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (dwClmNo[i] != null)
					model.setDwClmNo(dwClmNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCondSearchStatusListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CondSearchStatusListVO[]
	 */
	public CondSearchStatusListVO[] getCondSearchStatusListVOs(){
		CondSearchStatusListVO[] vos = (CondSearchStatusListVO[])models.toArray(new CondSearchStatusListVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyClmPtyNo = this.lablPtyClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmRefVvdNo = this.dwClmRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftClmPtyNo = this.deftClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmPtyNo = this.clmtClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateType = this.dateType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmTpCd = this.dwClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwCoCd = this.dwCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmStsCd = this.dwClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmAttDefTpCd = this.dwClmAttDefTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNo = this.insurClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciPlcTpCd = this.inciPlcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmNo = this.dwClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
