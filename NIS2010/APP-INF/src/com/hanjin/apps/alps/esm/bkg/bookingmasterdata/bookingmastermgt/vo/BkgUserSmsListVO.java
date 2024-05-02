/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgUserSmsListVO.java
*@FileTitle : BkgUserSmsListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.08  
* 1.0 Creation
* -------------------------------------------------------
* History
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
* 2012.11.23 김보배 [CHM-201221561] [BKG] User SMS Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgUserSmsListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgUserSmsListVO> models = new ArrayList<BkgUserSmsListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String creSeq = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcvrEml = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rcvrUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String rcvrUsrNm = null;
	/* Column Info */
	private String ofcPhnNo = null;
	/* Column Info */
	private String ofcFaxNo = null;
	/* Column Info */
	private String loclTsIndCd = null;
	/* Column Info */
	private String portCd = null;
	
	private String fileAtchFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgUserSmsListVO() {}

	public BkgUserSmsListVO(String ibflag, String pagerows, String slanCd, String dirCd, String creSeq, String ofcCd, String rcvrUsrId, String rcvrEml, String phnNo, String creUsrId, String creDt, String updUsrId, String updDt, String usrNm, String rcvrUsrNm, String ofcPhnNo, String ofcFaxNo, String loclTsIndCd, String portCd, String fileAtchFlg) {
		this.updDt = updDt;
		this.phnNo = phnNo;
		this.creSeq = creSeq;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.rcvrEml = rcvrEml;
		this.creUsrId = creUsrId;
		this.slanCd = slanCd;
		this.dirCd = dirCd;
		this.rcvrUsrId = rcvrUsrId;
		this.updUsrId = updUsrId;
		this.usrNm = usrNm;
		this.rcvrUsrNm = rcvrUsrNm; 
		this.ofcPhnNo = ofcPhnNo;
		this.ofcFaxNo = ofcFaxNo;
		this.loclTsIndCd = loclTsIndCd;
		this.portCd = portCd;
		this.fileAtchFlg = fileAtchFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("cre_seq", getCreSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcvr_eml", getRcvrEml());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rcvr_usr_id", getRcvrUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("rcvr_usr_nm", getRcvrUsrNm());
		this.hashColumns.put("ofc_phn_no", getOfcPhnNo());
		this.hashColumns.put("ofc_fax_no", getOfcFaxNo());
		this.hashColumns.put("locl_ts_ind_cd", getLoclTsIndCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("file_atch_flg", getFileAtchFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("cre_seq", "creSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcvr_eml", "rcvrEml");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rcvr_usr_id", "rcvrUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("rcvr_usr_nm", "rcvrUsrNm");
		this.hashFields.put("ofc_phn_no", "ofcPhnNo");
		this.hashFields.put("ofc_fax_no", "ofcFaxNo");
		this.hashFields.put("locl_ts_ind_cd", "loclTsIndCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("file_atch_flg", "fileAtchFlg");
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
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return creSeq
	 */
	public String getCreSeq() {
		return this.creSeq;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return rcvrEml
	 */
	public String getRcvrEml() {
		return this.rcvrEml;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return rcvrUsrId
	 */
	public String getRcvrUsrId() {
		return this.rcvrUsrId;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return usrNm;
	}
	
	/**
	 * Column Info
	 * @return rcvrUsrNm
	 */
	public String getRcvrUsrNm() {
		return rcvrUsrNm;
	}
	
	/**
	 * Column Info
	 * @return ofcPhnNo
	 */
	public String getOfcPhnNo() {
		return ofcPhnNo;
	}
	
	/**
	 * Column Info
	 * @return ofcFaxNo
	 */
	public String getOfcFaxNo() {
		return ofcFaxNo;
	}
	
	/**
	 * Column Info
	 * @return loclTsIndCd
	 */
	public String getLoclTsIndCd() {
		return loclTsIndCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return portCd;
	}
	
	public String getFileAtchFlg() {
		return fileAtchFlg;
	}

	public void setFileAtchFlg(String fileAtchFlg) {
		this.fileAtchFlg = fileAtchFlg;
	}

	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param creSeq
	 */
	public void setCreSeq(String creSeq) {
		this.creSeq = creSeq;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param rcvrEml
	 */
	public void setRcvrEml(String rcvrEml) {
		this.rcvrEml = rcvrEml;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param rcvrUsrId
	 */
	public void setRcvrUsrId(String rcvrUsrId) {
		this.rcvrUsrId = rcvrUsrId;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param rcvrUsrNm
	 */
	public void setRcvrUsrNm(String rcvrUsrNm){
		this.rcvrUsrNm = rcvrUsrNm;
	}
	
	/**
	 * Column Info
	 * @param ofcPhnNo
	 */
	public void setOfcPhnNo(String ofcPhnNo) {
		this.ofcPhnNo = ofcPhnNo;
	}
	
	/**
	 * Column Info
	 * @param ofcFaxNo
	 */
	public void setOfcFaxNo(String ofcFaxNo) {
		this.ofcFaxNo = ofcFaxNo;
	}
	
	/**
	 * Column Info
	 * @param loclTsIndCd
	 */
	public void setLoclTsIndCd(String loclTsIndCd) {
		this.loclTsIndCd = loclTsIndCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
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
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setCreSeq(JSPUtil.getParameter(request, prefix + "cre_seq", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRcvrEml(JSPUtil.getParameter(request, prefix + "rcvr_eml", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setRcvrUsrId(JSPUtil.getParameter(request, prefix + "rcvr_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setRcvrUsrNm(JSPUtil.getParameter(request, prefix + "rcvr_usr_nm", ""));
		setOfcPhnNo(JSPUtil.getParameter(request, prefix + "ofc_phn_no", ""));
		setOfcFaxNo(JSPUtil.getParameter(request, prefix + "ofc_fax_no", ""));
		setLoclTsIndCd(JSPUtil.getParameter(request, prefix + "locl_ts_ind_cd", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setFileAtchFlg(JSPUtil.getParameter(request, prefix + "file_atch_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgUserSmsListVO[]
	 */
	public BkgUserSmsListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgUserSmsListVO[]
	 */
	public BkgUserSmsListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgUserSmsListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] creSeq = (JSPUtil.getParameter(request, prefix	+ "cre_seq", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rcvrEml = (JSPUtil.getParameter(request, prefix	+ "rcvr_eml", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rcvrUsrId = (JSPUtil.getParameter(request, prefix	+ "rcvr_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] rcvrUsrNm = (JSPUtil.getParameter(request, prefix	+ "rcvr_usr_nm", length));
			String[] ofcPhnNo = (JSPUtil.getParameter(request, prefix	+ "ofc_phn_no", length));
			String[] ofcFaxNo = (JSPUtil.getParameter(request, prefix	+ "ofc_fax_no", length));
			String[] loclTsIndCd = (JSPUtil.getParameter(request, prefix	+ "locl_ts_ind_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] fileAtchFlg = (JSPUtil.getParameter(request, prefix	+ "file_atch_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgUserSmsListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (creSeq[i] != null)
					model.setCreSeq(creSeq[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcvrEml[i] != null)
					model.setRcvrEml(rcvrEml[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rcvrUsrId[i] != null)
					model.setRcvrUsrId(rcvrUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (rcvrUsrNm[i] != null)
					model.setRcvrUsrNm(rcvrUsrNm[i]);
				if (ofcPhnNo[i] != null)
					model.setOfcPhnNo(ofcPhnNo[i]);
				if (ofcFaxNo[i] != null)
					model.setOfcFaxNo(ofcFaxNo[i]);
				if (loclTsIndCd[i] != null)
					model.setLoclTsIndCd(loclTsIndCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (fileAtchFlg[i] != null)
					model.setFileAtchFlg(fileAtchFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgUserSmsListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgUserSmsListVO[]
	 */
	public BkgUserSmsListVO[] getBkgUserSmsListVOs(){
		BkgUserSmsListVO[] vos = (BkgUserSmsListVO[])models.toArray(new BkgUserSmsListVO[models.size()]);
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
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creSeq = this.creSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrEml = this.rcvrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrUsrId = this.rcvrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrUsrNm = this.rcvrUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcPhnNo = this.ofcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFaxNo = this.ofcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTsIndCd = this.loclTsIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileAtchFlg = this.fileAtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
