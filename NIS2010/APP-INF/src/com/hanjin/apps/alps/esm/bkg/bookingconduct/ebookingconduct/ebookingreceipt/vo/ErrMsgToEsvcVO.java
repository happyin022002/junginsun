/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ErrMsgToEsvcVO.java
*@FileTitle : ErrMsgToEsvcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.10.26 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ErrMsgToEsvcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ErrMsgToEsvcVO> models = new ArrayList<ErrMsgToEsvcVO>();
	
	/* Column Info */
	private String ibSeq = null;
	/* Column Info */
	private String ibEdiId = null;
	/* Column Info */
	private String ibCDate = null;
	/* Column Info */
	private String ibNuError = null;
	/* Column Info */
	private String eaiDt = null;
	/* Column Info */
	private String ibCfmInd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibRDate = null;
	/* Column Info */
	private String eaiSts = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ibBkgNo = null;
	/* Column Info */
	private String company = null;
	/* Column Info */
	private String ibBkgOfc = null;
	/* Column Info */
	private String ibMsgFlag = null;
	/* Column Info */
	private String ibCfmUsrId = null;
	/* Column Info */
	private String eaiIfTp = null;
	/* Column Info */
	private String ibFfRefNo = null;
	/* Column Info */
	private String ibNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ErrMsgToEsvcVO() {}

	public ErrMsgToEsvcVO(String ibflag, String pagerows, String eaiSts, String eaiDt, String company, String ibNo, String ibSeq, String ibEdiId, String ibFfRefNo, String ibBkgNo, String ibCfmInd, String ibBkgOfc, String ibCfmUsrId, String ibCDate, String ibRDate, String eaiIfTp, String ibNuError, String ibMsgFlag) {
		this.ibSeq = ibSeq;
		this.ibEdiId = ibEdiId;
		this.ibCDate = ibCDate;
		this.ibNuError = ibNuError;
		this.eaiDt = eaiDt;
		this.ibCfmInd = ibCfmInd;
		this.pagerows = pagerows;
		this.ibRDate = ibRDate;
		this.eaiSts = eaiSts;
		this.ibflag = ibflag;
		this.ibBkgNo = ibBkgNo;
		this.company = company;
		this.ibBkgOfc = ibBkgOfc;
		this.ibMsgFlag = ibMsgFlag;
		this.ibCfmUsrId = ibCfmUsrId;
		this.eaiIfTp = eaiIfTp;
		this.ibFfRefNo = ibFfRefNo;
		this.ibNo = ibNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ib_seq", getIbSeq());
		this.hashColumns.put("ib_edi_id", getIbEdiId());
		this.hashColumns.put("ib_c_date", getIbCDate());
		this.hashColumns.put("ib_nu_error", getIbNuError());
		this.hashColumns.put("eai_dt", getEaiDt());
		this.hashColumns.put("ib_cfm_ind", getIbCfmInd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ib_r_date", getIbRDate());
		this.hashColumns.put("eai_sts", getEaiSts());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ib_bkg_no", getIbBkgNo());
		this.hashColumns.put("company", getCompany());
		this.hashColumns.put("ib_bkg_ofc", getIbBkgOfc());
		this.hashColumns.put("ib_msg_flag", getIbMsgFlag());
		this.hashColumns.put("ib_cfm_usr_id", getIbCfmUsrId());
		this.hashColumns.put("eai_if_tp", getEaiIfTp());
		this.hashColumns.put("ib_ff_ref_no", getIbFfRefNo());
		this.hashColumns.put("ib_no", getIbNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ib_seq", "ibSeq");
		this.hashFields.put("ib_edi_id", "ibEdiId");
		this.hashFields.put("ib_c_date", "ibCDate");
		this.hashFields.put("ib_nu_error", "ibNuError");
		this.hashFields.put("eai_dt", "eaiDt");
		this.hashFields.put("ib_cfm_ind", "ibCfmInd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ib_r_date", "ibRDate");
		this.hashFields.put("eai_sts", "eaiSts");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ib_bkg_no", "ibBkgNo");
		this.hashFields.put("company", "company");
		this.hashFields.put("ib_bkg_ofc", "ibBkgOfc");
		this.hashFields.put("ib_msg_flag", "ibMsgFlag");
		this.hashFields.put("ib_cfm_usr_id", "ibCfmUsrId");
		this.hashFields.put("eai_if_tp", "eaiIfTp");
		this.hashFields.put("ib_ff_ref_no", "ibFfRefNo");
		this.hashFields.put("ib_no", "ibNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ibSeq
	 */
	public String getIbSeq() {
		return this.ibSeq;
	}
	
	/**
	 * Column Info
	 * @return ibEdiId
	 */
	public String getIbEdiId() {
		return this.ibEdiId;
	}
	
	/**
	 * Column Info
	 * @return ibCDate
	 */
	public String getIbCDate() {
		return this.ibCDate;
	}
	
	/**
	 * Column Info
	 * @return ibNuError
	 */
	public String getIbNuError() {
		return this.ibNuError;
	}
	
	/**
	 * Column Info
	 * @return eaiDt
	 */
	public String getEaiDt() {
		return this.eaiDt;
	}
	
	/**
	 * Column Info
	 * @return ibCfmInd
	 */
	public String getIbCfmInd() {
		return this.ibCfmInd;
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
	 * @return ibRDate
	 */
	public String getIbRDate() {
		return this.ibRDate;
	}
	
	/**
	 * Column Info
	 * @return eaiSts
	 */
	public String getEaiSts() {
		return this.eaiSts;
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
	 * @return ibBkgNo
	 */
	public String getIbBkgNo() {
		return this.ibBkgNo;
	}
	
	/**
	 * Column Info
	 * @return company
	 */
	public String getCompany() {
		return this.company;
	}
	
	/**
	 * Column Info
	 * @return ibBkgOfc
	 */
	public String getIbBkgOfc() {
		return this.ibBkgOfc;
	}
	
	/**
	 * Column Info
	 * @return ibMsgFlag
	 */
	public String getIbMsgFlag() {
		return this.ibMsgFlag;
	}
	
	/**
	 * Column Info
	 * @return ibCfmUsrId
	 */
	public String getIbCfmUsrId() {
		return this.ibCfmUsrId;
	}
	
	/**
	 * Column Info
	 * @return eaiIfTp
	 */
	public String getEaiIfTp() {
		return this.eaiIfTp;
	}
	
	/**
	 * Column Info
	 * @return ibFfRefNo
	 */
	public String getIbFfRefNo() {
		return this.ibFfRefNo;
	}
	
	/**
	 * Column Info
	 * @return ibNo
	 */
	public String getIbNo() {
		return this.ibNo;
	}
	

	/**
	 * Column Info
	 * @param ibSeq
	 */
	public void setIbSeq(String ibSeq) {
		this.ibSeq = ibSeq;
	}
	
	/**
	 * Column Info
	 * @param ibEdiId
	 */
	public void setIbEdiId(String ibEdiId) {
		this.ibEdiId = ibEdiId;
	}
	
	/**
	 * Column Info
	 * @param ibCDate
	 */
	public void setIbCDate(String ibCDate) {
		this.ibCDate = ibCDate;
	}
	
	/**
	 * Column Info
	 * @param ibNuError
	 */
	public void setIbNuError(String ibNuError) {
		this.ibNuError = ibNuError;
	}
	
	/**
	 * Column Info
	 * @param eaiDt
	 */
	public void setEaiDt(String eaiDt) {
		this.eaiDt = eaiDt;
	}
	
	/**
	 * Column Info
	 * @param ibCfmInd
	 */
	public void setIbCfmInd(String ibCfmInd) {
		this.ibCfmInd = ibCfmInd;
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
	 * @param ibRDate
	 */
	public void setIbRDate(String ibRDate) {
		this.ibRDate = ibRDate;
	}
	
	/**
	 * Column Info
	 * @param eaiSts
	 */
	public void setEaiSts(String eaiSts) {
		this.eaiSts = eaiSts;
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
	 * @param ibBkgNo
	 */
	public void setIbBkgNo(String ibBkgNo) {
		this.ibBkgNo = ibBkgNo;
	}
	
	/**
	 * Column Info
	 * @param company
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	/**
	 * Column Info
	 * @param ibBkgOfc
	 */
	public void setIbBkgOfc(String ibBkgOfc) {
		this.ibBkgOfc = ibBkgOfc;
	}
	
	/**
	 * Column Info
	 * @param ibMsgFlag
	 */
	public void setIbMsgFlag(String ibMsgFlag) {
		this.ibMsgFlag = ibMsgFlag;
	}
	
	/**
	 * Column Info
	 * @param ibCfmUsrId
	 */
	public void setIbCfmUsrId(String ibCfmUsrId) {
		this.ibCfmUsrId = ibCfmUsrId;
	}
	
	/**
	 * Column Info
	 * @param eaiIfTp
	 */
	public void setEaiIfTp(String eaiIfTp) {
		this.eaiIfTp = eaiIfTp;
	}
	
	/**
	 * Column Info
	 * @param ibFfRefNo
	 */
	public void setIbFfRefNo(String ibFfRefNo) {
		this.ibFfRefNo = ibFfRefNo;
	}
	
	/**
	 * Column Info
	 * @param ibNo
	 */
	public void setIbNo(String ibNo) {
		this.ibNo = ibNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbSeq(JSPUtil.getParameter(request, "ib_seq", ""));
		setIbEdiId(JSPUtil.getParameter(request, "ib_edi_id", ""));
		setIbCDate(JSPUtil.getParameter(request, "ib_c_date", ""));
		setIbNuError(JSPUtil.getParameter(request, "ib_nu_error", ""));
		setEaiDt(JSPUtil.getParameter(request, "eai_dt", ""));
		setIbCfmInd(JSPUtil.getParameter(request, "ib_cfm_ind", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbRDate(JSPUtil.getParameter(request, "ib_r_date", ""));
		setEaiSts(JSPUtil.getParameter(request, "eai_sts", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIbBkgNo(JSPUtil.getParameter(request, "ib_bkg_no", ""));
		setCompany(JSPUtil.getParameter(request, "company", ""));
		setIbBkgOfc(JSPUtil.getParameter(request, "ib_bkg_ofc", ""));
		setIbMsgFlag(JSPUtil.getParameter(request, "ib_msg_flag", ""));
		setIbCfmUsrId(JSPUtil.getParameter(request, "ib_cfm_usr_id", ""));
		setEaiIfTp(JSPUtil.getParameter(request, "eai_if_tp", ""));
		setIbFfRefNo(JSPUtil.getParameter(request, "ib_ff_ref_no", ""));
		setIbNo(JSPUtil.getParameter(request, "ib_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ErrMsgToEsvcVO[]
	 */
	public ErrMsgToEsvcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ErrMsgToEsvcVO[]
	 */
	public ErrMsgToEsvcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ErrMsgToEsvcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibSeq = (JSPUtil.getParameter(request, prefix	+ "ib_seq", length));
			String[] ibEdiId = (JSPUtil.getParameter(request, prefix	+ "ib_edi_id", length));
			String[] ibCDate = (JSPUtil.getParameter(request, prefix	+ "ib_c_date", length));
			String[] ibNuError = (JSPUtil.getParameter(request, prefix	+ "ib_nu_error", length));
			String[] eaiDt = (JSPUtil.getParameter(request, prefix	+ "eai_dt", length));
			String[] ibCfmInd = (JSPUtil.getParameter(request, prefix	+ "ib_cfm_ind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibRDate = (JSPUtil.getParameter(request, prefix	+ "ib_r_date", length));
			String[] eaiSts = (JSPUtil.getParameter(request, prefix	+ "eai_sts", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ibBkgNo = (JSPUtil.getParameter(request, prefix	+ "ib_bkg_no", length));
			String[] company = (JSPUtil.getParameter(request, prefix	+ "company", length));
			String[] ibBkgOfc = (JSPUtil.getParameter(request, prefix	+ "ib_bkg_ofc", length));
			String[] ibMsgFlag = (JSPUtil.getParameter(request, prefix	+ "ib_msg_flag", length));
			String[] ibCfmUsrId = (JSPUtil.getParameter(request, prefix	+ "ib_cfm_usr_id", length));
			String[] eaiIfTp = (JSPUtil.getParameter(request, prefix	+ "eai_if_tp", length));
			String[] ibFfRefNo = (JSPUtil.getParameter(request, prefix	+ "ib_ff_ref_no", length));
			String[] ibNo = (JSPUtil.getParameter(request, prefix	+ "ib_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new ErrMsgToEsvcVO();
				if (ibSeq[i] != null)
					model.setIbSeq(ibSeq[i]);
				if (ibEdiId[i] != null)
					model.setIbEdiId(ibEdiId[i]);
				if (ibCDate[i] != null)
					model.setIbCDate(ibCDate[i]);
				if (ibNuError[i] != null)
					model.setIbNuError(ibNuError[i]);
				if (eaiDt[i] != null)
					model.setEaiDt(eaiDt[i]);
				if (ibCfmInd[i] != null)
					model.setIbCfmInd(ibCfmInd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibRDate[i] != null)
					model.setIbRDate(ibRDate[i]);
				if (eaiSts[i] != null)
					model.setEaiSts(eaiSts[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ibBkgNo[i] != null)
					model.setIbBkgNo(ibBkgNo[i]);
				if (company[i] != null)
					model.setCompany(company[i]);
				if (ibBkgOfc[i] != null)
					model.setIbBkgOfc(ibBkgOfc[i]);
				if (ibMsgFlag[i] != null)
					model.setIbMsgFlag(ibMsgFlag[i]);
				if (ibCfmUsrId[i] != null)
					model.setIbCfmUsrId(ibCfmUsrId[i]);
				if (eaiIfTp[i] != null)
					model.setEaiIfTp(eaiIfTp[i]);
				if (ibFfRefNo[i] != null)
					model.setIbFfRefNo(ibFfRefNo[i]);
				if (ibNo[i] != null)
					model.setIbNo(ibNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getErrMsgToEsvcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ErrMsgToEsvcVO[]
	 */
	public ErrMsgToEsvcVO[] getErrMsgToEsvcVOs(){
		ErrMsgToEsvcVO[] vos = (ErrMsgToEsvcVO[])models.toArray(new ErrMsgToEsvcVO[models.size()]);
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
		this.ibSeq = this.ibSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibEdiId = this.ibEdiId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCDate = this.ibCDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibNuError = this.ibNuError .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiDt = this.eaiDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCfmInd = this.ibCfmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibRDate = this.ibRDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiSts = this.eaiSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBkgNo = this.ibBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company = this.company .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibBkgOfc = this.ibBkgOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibMsgFlag = this.ibMsgFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCfmUsrId = this.ibCfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfTp = this.eaiIfTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibFfRefNo = this.ibFfRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibNo = this.ibNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
