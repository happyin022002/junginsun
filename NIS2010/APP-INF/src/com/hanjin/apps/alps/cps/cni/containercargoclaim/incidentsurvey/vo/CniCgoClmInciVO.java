/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CniCgoClmInciVO.java
*@FileTitle : CniCgoClmInciVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 양정란
*@LastVersion : 1.0
* 2009.10.26 양정란 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.incidentsurvey.vo;

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
 * @author 양정란
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CniCgoClmInciVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CniCgoClmInciVO> models = new ArrayList<CniCgoClmInciVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String inciLocCd = null;
	/* Column Info */
	private String inciDevDesc = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String inciOccrDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inciSubjNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String cgoClmInciNo = null;
	/* Column Info */
	private String inciPlcTpCd = null;
	/* Column Info */
	private String inciRefVvdNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CniCgoClmInciVO() {}

	public CniCgoClmInciVO(String ibflag, String pagerows, String cgoClmInciNo, String inciPlcTpCd, String inciOccrDt, String inciLocCd, String inciSubjNm, String inciRefVvdNo, String inciDevDesc, String creOfcCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.inciLocCd = inciLocCd;
		this.inciDevDesc = inciDevDesc;
		this.creDt = creDt;
		this.inciOccrDt = inciOccrDt;
		this.pagerows = pagerows;
		this.inciSubjNm = inciSubjNm;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.creOfcCd = creOfcCd;
		this.cgoClmInciNo = cgoClmInciNo;
		this.inciPlcTpCd = inciPlcTpCd;
		this.inciRefVvdNo = inciRefVvdNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("inci_loc_cd", getInciLocCd());
		this.hashColumns.put("inci_dev_desc", getInciDevDesc());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("inci_occr_dt", getInciOccrDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inci_subj_nm", getInciSubjNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("cgo_clm_inci_no", getCgoClmInciNo());
		this.hashColumns.put("inci_plc_tp_cd", getInciPlcTpCd());
		this.hashColumns.put("inci_ref_vvd_no", getInciRefVvdNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inci_loc_cd", "inciLocCd");
		this.hashFields.put("inci_dev_desc", "inciDevDesc");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("inci_occr_dt", "inciOccrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inci_subj_nm", "inciSubjNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("cgo_clm_inci_no", "cgoClmInciNo");
		this.hashFields.put("inci_plc_tp_cd", "inciPlcTpCd");
		this.hashFields.put("inci_ref_vvd_no", "inciRefVvdNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return inciLocCd
	 */
	public String getInciLocCd() {
		return this.inciLocCd;
	}
	
	/**
	 * Column Info
	 * @return inciDevDesc
	 */
	public String getInciDevDesc() {
		return this.inciDevDesc;
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
	 * @return inciOccrDt
	 */
	public String getInciOccrDt() {
		return this.inciOccrDt;
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
	 * @return inciSubjNm
	 */
	public String getInciSubjNm() {
		return this.inciSubjNm;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return cgoClmInciNo
	 */
	public String getCgoClmInciNo() {
		return this.cgoClmInciNo;
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
	 * @return inciRefVvdNo
	 */
	public String getInciRefVvdNo() {
		return this.inciRefVvdNo;
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
	 * @param inciLocCd
	 */
	public void setInciLocCd(String inciLocCd) {
		this.inciLocCd = inciLocCd;
	}
	
	/**
	 * Column Info
	 * @param inciDevDesc
	 */
	public void setInciDevDesc(String inciDevDesc) {
		this.inciDevDesc = inciDevDesc;
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
	 * @param inciOccrDt
	 */
	public void setInciOccrDt(String inciOccrDt) {
		this.inciOccrDt = inciOccrDt;
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
	 * @param inciSubjNm
	 */
	public void setInciSubjNm(String inciSubjNm) {
		this.inciSubjNm = inciSubjNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param cgoClmInciNo
	 */
	public void setCgoClmInciNo(String cgoClmInciNo) {
		this.cgoClmInciNo = cgoClmInciNo;
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
	 * @param inciRefVvdNo
	 */
	public void setInciRefVvdNo(String inciRefVvdNo) {
		this.inciRefVvdNo = inciRefVvdNo;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setInciLocCd(JSPUtil.getParameter(request, "inci_loc_cd", ""));
		setInciDevDesc(JSPUtil.getParameter(request, "inci_dev_desc", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setInciOccrDt(JSPUtil.getParameter(request, "inci_occr_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInciSubjNm(JSPUtil.getParameter(request, "inci_subj_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setCgoClmInciNo(JSPUtil.getParameter(request, "cgo_clm_inci_no", ""));
		setInciPlcTpCd(JSPUtil.getParameter(request, "inci_plc_tp_cd", ""));
		setInciRefVvdNo(JSPUtil.getParameter(request, "inci_ref_vvd_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CniCgoClmInciVO[]
	 */
	public CniCgoClmInciVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CniCgoClmInciVO[]
	 */
	public CniCgoClmInciVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CniCgoClmInciVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] inciLocCd = (JSPUtil.getParameter(request, prefix	+ "inci_loc_cd", length));
			String[] inciDevDesc = (JSPUtil.getParameter(request, prefix	+ "inci_dev_desc", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] inciOccrDt = (JSPUtil.getParameter(request, prefix	+ "inci_occr_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inciSubjNm = (JSPUtil.getParameter(request, prefix	+ "inci_subj_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] cgoClmInciNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_inci_no", length));
			String[] inciPlcTpCd = (JSPUtil.getParameter(request, prefix	+ "inci_plc_tp_cd", length));
			String[] inciRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "inci_ref_vvd_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CniCgoClmInciVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (inciLocCd[i] != null)
					model.setInciLocCd(inciLocCd[i]);
				if (inciDevDesc[i] != null)
					model.setInciDevDesc(inciDevDesc[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (inciOccrDt[i] != null)
					model.setInciOccrDt(inciOccrDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inciSubjNm[i] != null)
					model.setInciSubjNm(inciSubjNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (cgoClmInciNo[i] != null)
					model.setCgoClmInciNo(cgoClmInciNo[i]);
				if (inciPlcTpCd[i] != null)
					model.setInciPlcTpCd(inciPlcTpCd[i]);
				if (inciRefVvdNo[i] != null)
					model.setInciRefVvdNo(inciRefVvdNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCniCgoClmInciVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CniCgoClmInciVO[]
	 */
	public CniCgoClmInciVO[] getCniCgoClmInciVOs(){
		CniCgoClmInciVO[] vos = (CniCgoClmInciVO[])models.toArray(new CniCgoClmInciVO[models.size()]);
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
		this.inciLocCd = this.inciLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciDevDesc = this.inciDevDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciOccrDt = this.inciOccrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciSubjNm = this.inciSubjNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmInciNo = this.cgoClmInciNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciPlcTpCd = this.inciPlcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciRefVvdNo = this.inciRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
