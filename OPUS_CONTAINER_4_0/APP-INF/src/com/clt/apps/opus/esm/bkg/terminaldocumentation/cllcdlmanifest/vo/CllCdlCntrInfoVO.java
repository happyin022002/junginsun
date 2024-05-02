/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CllCdlCntrInfoVO.java
*@FileTitle : CllCdlCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.20
*@LastModifier :
*@LastVersion : 1.0
* 2011.01.20
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

public class CllCdlCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CllCdlCntrInfoVO> models = new ArrayList<CllCdlCntrInfoVO>();

	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrInfo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String cntrSealInfo = null;
	/* Page Number */
	private String cntrSpclInst = null;
	/* Page Number */
	private String cntrVgm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CllCdlCntrInfoVO() {}

	public CllCdlCntrInfoVO(String ibflag, String pagerows, String cntrInfo, String cntrSealNo, String cntrNo, String inVvdCd, String inPolCd, String bkgNo, String creUsrId, String blNo, String cntrSealInfo, String cntrSpclInst, String cntrVgm) {
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.cntrInfo = cntrInfo;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.inPolCd = inPolCd;
		this.inVvdCd = inVvdCd;
		this.cntrSealNo = cntrSealNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.cntrSealInfo = cntrSealInfo;
		this.cntrSpclInst = cntrSpclInst;
		this.cntrVgm = cntrVgm;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_info", getCntrInfo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_seal_info", getCntrSealInfo());
		this.hashColumns.put("cntr_spcl_inst", getCntrSpclInst());
		this.hashColumns.put("cntr_vgm", getCntrVgm());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_info", "cntrInfo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_seal_info", "cntrSealInfo");
		this.hashFields.put("cntr_spcl_inst", "cntrSpclInst");
		this.hashFields.put("cntr_vgm", "cntrVgm");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return cntrInfo
	 */
	public String getCntrInfo() {
		return this.cntrInfo;
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
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
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
	 * @return cntrSealInfo
	 */
	public String getCntrSealInfo() {
		return this.cntrSealInfo;
	}
	
	/**
	 * Column Info
	 * @return cntrSpclInst
	 */
	public String getCntrSpclInst() {
		return this.cntrSpclInst;
	}
	
	/**
	 * Column Info
	 * @return cntrVgm
	 */
	public String getCntrVgm() {
		return this.cntrVgm;
	}


	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param cntrInfo
	 */
	public void setCntrInfo(String cntrInfo) {
		this.cntrInfo = cntrInfo;
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
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
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
	 * @param cntrSealInfo
	 */
	public void setCntrSealInfo(String cntrSealInfo) {
		this.cntrSealInfo = cntrSealInfo;
	}
	
	/**
	 * Column Info
	 * @param cntrSpclInst
	 */
	public void setCntrSpclInst(String cntrSpclInst) {
		this.cntrSpclInst = cntrSpclInst;
	}
	
	/**
	 * Column Info
	 * @param cntrVgm
	 */
	public void setCntrVgm(String cntrVgm) {
		this.cntrVgm = cntrVgm;
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
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrInfo(JSPUtil.getParameter(request, prefix + "cntr_info", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setInPolCd(JSPUtil.getParameter(request, prefix + "in_pol_cd", ""));
		setInVvdCd(JSPUtil.getParameter(request, prefix + "in_vvd_cd", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrSealInfo(JSPUtil.getParameter(request, prefix + "cntr_seal_info", ""));
		setCntrSpclInst(JSPUtil.getParameter(request, prefix + "cntr_spcl_inst", ""));
		setCntrVgm(JSPUtil.getParameter(request, prefix + "cntr_vgm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CllCdlCntrInfoVO[]
	 */
	public CllCdlCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CllCdlCntrInfoVO[]
	 */
	public CllCdlCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CllCdlCntrInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrInfo = (JSPUtil.getParameter(request, prefix	+ "cntr_info", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrSealInfo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_info", length));
			String[] cntrSpclInst = (JSPUtil.getParameter(request, prefix	+ "cntr_spcl_inst", length));
			String[] cntrVgm = (JSPUtil.getParameter(request, prefix	+ "cntr_vgm", length));

			for (int i = 0; i < length; i++) {
				model = new CllCdlCntrInfoVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrInfo[i] != null)
					model.setCntrInfo(cntrInfo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrSealInfo[i] != null)
					model.setCntrSealInfo(cntrSealInfo[i]);
				if (cntrSpclInst[i] != null)
					model.setCntrSpclInst(cntrSpclInst[i]);
				if (cntrVgm[i] != null)
					model.setCntrVgm(cntrVgm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCllCdlCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CllCdlCntrInfoVO[]
	 */
	public CllCdlCntrInfoVO[] getCllCdlCntrInfoVOs(){
		CllCdlCntrInfoVO[] vos = (CllCdlCntrInfoVO[])models.toArray(new CllCdlCntrInfoVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrInfo = this.cntrInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealInfo = this.cntrSealInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSpclInst = this.cntrSpclInst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVgm = this.cntrVgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
