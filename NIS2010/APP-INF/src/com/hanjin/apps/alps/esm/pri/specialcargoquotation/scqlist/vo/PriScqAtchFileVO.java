/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PriScqAtchFileVO.java
*@FileTitle : PriScqAtchFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.08
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.04.08 문동선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo;

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
 * @author 문동선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriScqAtchFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriScqAtchFileVO> models = new ArrayList<PriScqAtchFileVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String spclCgoTpCd = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String savPathNm = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fileSize = null;
	/* Column Info */
	private String savFileNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String orgFileNm = null;
	/* Column Info */
	private String preScqRqstNo = null;
	/* Column Info */
	private String scqRqstNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriScqAtchFileVO() {}

	public PriScqAtchFileVO(String ibflag, String pagerows, String scqRqstNo, String spclCgoTpCd, String fileSavId, String orgFileNm, String savFileNm, String savPathNm, String creUsrId, String creDt, String updUsrId, String updDt, String fileSize, String preScqRqstNo) {
		this.updDt = updDt;
		this.spclCgoTpCd = spclCgoTpCd;
		this.fileSavId = fileSavId;
		this.savPathNm = savPathNm;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.fileSize = fileSize;
		this.savFileNm = savFileNm;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.orgFileNm = orgFileNm;
		this.preScqRqstNo = preScqRqstNo;
		this.scqRqstNo = scqRqstNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("spcl_cgo_tp_cd", getSpclCgoTpCd());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("sav_path_nm", getSavPathNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("file_size", getFileSize());
		this.hashColumns.put("sav_file_nm", getSavFileNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("org_file_nm", getOrgFileNm());
		this.hashColumns.put("pre_scq_rqst_no", getPreScqRqstNo());
		this.hashColumns.put("scq_rqst_no", getScqRqstNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("spcl_cgo_tp_cd", "spclCgoTpCd");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("sav_path_nm", "savPathNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("file_size", "fileSize");
		this.hashFields.put("sav_file_nm", "savFileNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("org_file_nm", "orgFileNm");
		this.hashFields.put("pre_scq_rqst_no", "preScqRqstNo");
		this.hashFields.put("scq_rqst_no", "scqRqstNo");
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
	 * @return spclCgoTpCd
	 */
	public String getSpclCgoTpCd() {
		return this.spclCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
	}
	
	/**
	 * Column Info
	 * @return savPathNm
	 */
	public String getSavPathNm() {
		return this.savPathNm;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return fileSize
	 */
	public String getFileSize() {
		return this.fileSize;
	}
	
	/**
	 * Column Info
	 * @return savFileNm
	 */
	public String getSavFileNm() {
		return this.savFileNm;
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
	 * @return orgFileNm
	 */
	public String getOrgFileNm() {
		return this.orgFileNm;
	}
	
	/**
	 * Column Info
	 * @return preScqRqstNo
	 */
	public String getPreScqRqstNo() {
		return this.preScqRqstNo;
	}
	
	/**
	 * Column Info
	 * @return scqRqstNo
	 */
	public String getScqRqstNo() {
		return this.scqRqstNo;
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
	 * @param spclCgoTpCd
	 */
	public void setSpclCgoTpCd(String spclCgoTpCd) {
		this.spclCgoTpCd = spclCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
	}
	
	/**
	 * Column Info
	 * @param savPathNm
	 */
	public void setSavPathNm(String savPathNm) {
		this.savPathNm = savPathNm;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param fileSize
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
	/**
	 * Column Info
	 * @param savFileNm
	 */
	public void setSavFileNm(String savFileNm) {
		this.savFileNm = savFileNm;
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
	 * @param orgFileNm
	 */
	public void setOrgFileNm(String orgFileNm) {
		this.orgFileNm = orgFileNm;
	}
	
	/**
	 * Column Info
	 * @param preScqRqstNo
	 */
	public void setPreScqRqstNo(String preScqRqstNo) {
		this.preScqRqstNo = preScqRqstNo;
	}
	
	/**
	 * Column Info
	 * @param scqRqstNo
	 */
	public void setScqRqstNo(String scqRqstNo) {
		this.scqRqstNo = scqRqstNo;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setSpclCgoTpCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_tp_cd", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setSavPathNm(JSPUtil.getParameter(request, prefix + "sav_path_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFileSize(JSPUtil.getParameter(request, prefix + "file_size", ""));
		setSavFileNm(JSPUtil.getParameter(request, prefix + "sav_file_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setOrgFileNm(JSPUtil.getParameter(request, prefix + "org_file_nm", ""));
		setPreScqRqstNo(JSPUtil.getParameter(request, prefix + "pre_scq_rqst_no", ""));
		setScqRqstNo(JSPUtil.getParameter(request, prefix + "scq_rqst_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriScqAtchFileVO[]
	 */
	public PriScqAtchFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriScqAtchFileVO[]
	 */
	public PriScqAtchFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriScqAtchFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] spclCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_tp_cd", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] savPathNm = (JSPUtil.getParameter(request, prefix	+ "sav_path_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fileSize = (JSPUtil.getParameter(request, prefix	+ "file_size", length));
			String[] savFileNm = (JSPUtil.getParameter(request, prefix	+ "sav_file_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] orgFileNm = (JSPUtil.getParameter(request, prefix	+ "org_file_nm", length));
			String[] preScqRqstNo = (JSPUtil.getParameter(request, prefix	+ "pre_scq_rqst_no", length));
			String[] scqRqstNo = (JSPUtil.getParameter(request, prefix	+ "scq_rqst_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriScqAtchFileVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (spclCgoTpCd[i] != null)
					model.setSpclCgoTpCd(spclCgoTpCd[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (savPathNm[i] != null)
					model.setSavPathNm(savPathNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fileSize[i] != null)
					model.setFileSize(fileSize[i]);
				if (savFileNm[i] != null)
					model.setSavFileNm(savFileNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (orgFileNm[i] != null)
					model.setOrgFileNm(orgFileNm[i]);
				if (preScqRqstNo[i] != null)
					model.setPreScqRqstNo(preScqRqstNo[i]);
				if (scqRqstNo[i] != null)
					model.setScqRqstNo(scqRqstNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriScqAtchFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriScqAtchFileVO[]
	 */
	public PriScqAtchFileVO[] getPriScqAtchFileVOs(){
		PriScqAtchFileVO[] vos = (PriScqAtchFileVO[])models.toArray(new PriScqAtchFileVO[models.size()]);
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
		this.spclCgoTpCd = this.spclCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savPathNm = this.savPathNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSize = this.fileSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savFileNm = this.savFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgFileNm = this.orgFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preScqRqstNo = this.preScqRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scqRqstNo = this.scqRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
