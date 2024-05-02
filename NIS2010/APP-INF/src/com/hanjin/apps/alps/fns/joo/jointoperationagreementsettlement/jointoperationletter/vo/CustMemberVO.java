/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustMemberVO.java
*@FileTitle : CustMemberVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.02
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.12.02 이준범 
* 1.0 Creation
----------------------------------------------------------------
* Histroy
* 2010.12.02 이준범 [CHM-201007349-01]
* 1. 보완 기능 
*   - JO Member Information Creation
*   - Inquiry of JO Member Information
* 2. 보완 요청 사항
*   - 컬럼 추가 : PIC of HJS(ID),  Name of PIC,  RHQ, Office, Start Date,  Creation Date 
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo;

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
 * @author 이준범
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustMemberVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustMemberVO> models = new ArrayList<CustMemberVO>();
	
	/* Column Info */
	private String crrNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fileCnt = null;
	/* Column Info */
	private String joCntcFaxNo = null;
	/* Column Info */
	private String svcInChgNm = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String rid = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String crrCntcSeq = null;
	/* Column Info */
	private String joCntcEml = null;
	/* Column Info */
	private String joCntcStDt = null;
	/* Column Info */
	private String joCntcPhnNo = null;
	/* Column Info */
	private String joCntcPicId = null;
	/* Column Info */
	private String joCntcOfcAddr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustMemberVO() {}

	public CustMemberVO(String ibflag, String pagerows, String joCrrCd, String rlaneCd, String crrCntcSeq, String rid, String fileCnt, String crrNm, String cntcPsonNm, String joCntcEml, String joCntcPhnNo, String joCntcFaxNo, String svcInChgNm, String joCntcOfcAddr, String usrId, String joCntcPicId, String usrNm, String arHdQtrOfcCd, String ofcCd, String joCntcStDt, String creDt) {
		this.crrNm = crrNm;
		this.creDt = creDt;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.joCrrCd = joCrrCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.fileCnt = fileCnt;
		this.joCntcFaxNo = joCntcFaxNo;
		this.svcInChgNm = svcInChgNm;
		this.usrNm = usrNm;
		this.usrId = usrId;
		this.rid = rid;
		this.cntcPsonNm = cntcPsonNm;
		this.crrCntcSeq = crrCntcSeq;
		this.joCntcEml = joCntcEml;
		this.joCntcStDt = joCntcStDt;
		this.joCntcPhnNo = joCntcPhnNo;
		this.joCntcPicId = joCntcPicId;
		this.joCntcOfcAddr = joCntcOfcAddr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("crr_nm", getCrrNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("file_cnt", getFileCnt());
		this.hashColumns.put("jo_cntc_fax_no", getJoCntcFaxNo());
		this.hashColumns.put("svc_in_chg_nm", getSvcInChgNm());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("rid", getRid());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("crr_cntc_seq", getCrrCntcSeq());
		this.hashColumns.put("jo_cntc_eml", getJoCntcEml());
		this.hashColumns.put("jo_cntc_st_dt", getJoCntcStDt());
		this.hashColumns.put("jo_cntc_phn_no", getJoCntcPhnNo());
		this.hashColumns.put("jo_cntc_pic_id", getJoCntcPicId());
		this.hashColumns.put("jo_cntc_ofc_addr", getJoCntcOfcAddr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("crr_nm", "crrNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("file_cnt", "fileCnt");
		this.hashFields.put("jo_cntc_fax_no", "joCntcFaxNo");
		this.hashFields.put("svc_in_chg_nm", "svcInChgNm");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("rid", "rid");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("crr_cntc_seq", "crrCntcSeq");
		this.hashFields.put("jo_cntc_eml", "joCntcEml");
		this.hashFields.put("jo_cntc_st_dt", "joCntcStDt");
		this.hashFields.put("jo_cntc_phn_no", "joCntcPhnNo");
		this.hashFields.put("jo_cntc_pic_id", "joCntcPicId");
		this.hashFields.put("jo_cntc_ofc_addr", "joCntcOfcAddr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return crrNm
	 */
	public String getCrrNm() {
		return this.crrNm;
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
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return fileCnt
	 */
	public String getFileCnt() {
		return this.fileCnt;
	}
	
	/**
	 * Column Info
	 * @return joCntcFaxNo
	 */
	public String getJoCntcFaxNo() {
		return this.joCntcFaxNo;
	}
	
	/**
	 * Column Info
	 * @return svcInChgNm
	 */
	public String getSvcInChgNm() {
		return this.svcInChgNm;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return rid
	 */
	public String getRid() {
		return this.rid;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return crrCntcSeq
	 */
	public String getCrrCntcSeq() {
		return this.crrCntcSeq;
	}
	
	/**
	 * Column Info
	 * @return joCntcEml
	 */
	public String getJoCntcEml() {
		return this.joCntcEml;
	}
	
	/**
	 * Column Info
	 * @return joCntcStDt
	 */
	public String getJoCntcStDt() {
		return this.joCntcStDt;
	}
	
	/**
	 * Column Info
	 * @return joCntcPhnNo
	 */
	public String getJoCntcPhnNo() {
		return this.joCntcPhnNo;
	}
	
	/**
	 * Column Info
	 * @return joCntcPicId
	 */
	public String getJoCntcPicId() {
		return this.joCntcPicId;
	}
	
	/**
	 * Column Info
	 * @return joCntcOfcAddr
	 */
	public String getJoCntcOfcAddr() {
		return this.joCntcOfcAddr;
	}
	

	/**
	 * Column Info
	 * @param crrNm
	 */
	public void setCrrNm(String crrNm) {
		this.crrNm = crrNm;
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
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param fileCnt
	 */
	public void setFileCnt(String fileCnt) {
		this.fileCnt = fileCnt;
	}
	
	/**
	 * Column Info
	 * @param joCntcFaxNo
	 */
	public void setJoCntcFaxNo(String joCntcFaxNo) {
		this.joCntcFaxNo = joCntcFaxNo;
	}
	
	/**
	 * Column Info
	 * @param svcInChgNm
	 */
	public void setSvcInChgNm(String svcInChgNm) {
		this.svcInChgNm = svcInChgNm;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param rid
	 */
	public void setRid(String rid) {
		this.rid = rid;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param crrCntcSeq
	 */
	public void setCrrCntcSeq(String crrCntcSeq) {
		this.crrCntcSeq = crrCntcSeq;
	}
	
	/**
	 * Column Info
	 * @param joCntcEml
	 */
	public void setJoCntcEml(String joCntcEml) {
		this.joCntcEml = joCntcEml;
	}
	
	/**
	 * Column Info
	 * @param joCntcStDt
	 */
	public void setJoCntcStDt(String joCntcStDt) {
		this.joCntcStDt = joCntcStDt;
	}
	
	/**
	 * Column Info
	 * @param joCntcPhnNo
	 */
	public void setJoCntcPhnNo(String joCntcPhnNo) {
		this.joCntcPhnNo = joCntcPhnNo;
	}
	
	/**
	 * Column Info
	 * @param joCntcPicId
	 */
	public void setJoCntcPicId(String joCntcPicId) {
		this.joCntcPicId = joCntcPicId;
	}
	
	/**
	 * Column Info
	 * @param joCntcOfcAddr
	 */
	public void setJoCntcOfcAddr(String joCntcOfcAddr) {
		this.joCntcOfcAddr = joCntcOfcAddr;
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
		setCrrNm(JSPUtil.getParameter(request, prefix + "crr_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, prefix + "ar_hd_qtr_ofc_cd", ""));
		setJoCrrCd(JSPUtil.getParameter(request, prefix + "jo_crr_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFileCnt(JSPUtil.getParameter(request, prefix + "file_cnt", ""));
		setJoCntcFaxNo(JSPUtil.getParameter(request, prefix + "jo_cntc_fax_no", ""));
		setSvcInChgNm(JSPUtil.getParameter(request, prefix + "svc_in_chg_nm", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setRid(JSPUtil.getParameter(request, prefix + "rid", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setCrrCntcSeq(JSPUtil.getParameter(request, prefix + "crr_cntc_seq", ""));
		setJoCntcEml(JSPUtil.getParameter(request, prefix + "jo_cntc_eml", ""));
		setJoCntcStDt(JSPUtil.getParameter(request, prefix + "jo_cntc_st_dt", ""));
		setJoCntcPhnNo(JSPUtil.getParameter(request, prefix + "jo_cntc_phn_no", ""));
		setJoCntcPicId(JSPUtil.getParameter(request, prefix + "jo_cntc_pic_id", ""));
		setJoCntcOfcAddr(JSPUtil.getParameter(request, prefix + "jo_cntc_ofc_addr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustMemberVO[]
	 */
	public CustMemberVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustMemberVO[]
	 */
	public CustMemberVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustMemberVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] crrNm = (JSPUtil.getParameter(request, prefix	+ "crr_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fileCnt = (JSPUtil.getParameter(request, prefix	+ "file_cnt", length));
			String[] joCntcFaxNo = (JSPUtil.getParameter(request, prefix	+ "jo_cntc_fax_no", length));
			String[] svcInChgNm = (JSPUtil.getParameter(request, prefix	+ "svc_in_chg_nm", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] rid = (JSPUtil.getParameter(request, prefix	+ "rid", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] crrCntcSeq = (JSPUtil.getParameter(request, prefix	+ "crr_cntc_seq", length));
			String[] joCntcEml = (JSPUtil.getParameter(request, prefix	+ "jo_cntc_eml", length));
			String[] joCntcStDt = (JSPUtil.getParameter(request, prefix	+ "jo_cntc_st_dt", length));
			String[] joCntcPhnNo = (JSPUtil.getParameter(request, prefix	+ "jo_cntc_phn_no", length));
			String[] joCntcPicId = (JSPUtil.getParameter(request, prefix	+ "jo_cntc_pic_id", length));
			String[] joCntcOfcAddr = (JSPUtil.getParameter(request, prefix	+ "jo_cntc_ofc_addr", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustMemberVO();
				if (crrNm[i] != null)
					model.setCrrNm(crrNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fileCnt[i] != null)
					model.setFileCnt(fileCnt[i]);
				if (joCntcFaxNo[i] != null)
					model.setJoCntcFaxNo(joCntcFaxNo[i]);
				if (svcInChgNm[i] != null)
					model.setSvcInChgNm(svcInChgNm[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (rid[i] != null)
					model.setRid(rid[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (crrCntcSeq[i] != null)
					model.setCrrCntcSeq(crrCntcSeq[i]);
				if (joCntcEml[i] != null)
					model.setJoCntcEml(joCntcEml[i]);
				if (joCntcStDt[i] != null)
					model.setJoCntcStDt(joCntcStDt[i]);
				if (joCntcPhnNo[i] != null)
					model.setJoCntcPhnNo(joCntcPhnNo[i]);
				if (joCntcPicId[i] != null)
					model.setJoCntcPicId(joCntcPicId[i]);
				if (joCntcOfcAddr[i] != null)
					model.setJoCntcOfcAddr(joCntcOfcAddr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustMemberVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustMemberVO[]
	 */
	public CustMemberVO[] getCustMemberVOs(){
		CustMemberVO[] vos = (CustMemberVO[])models.toArray(new CustMemberVO[models.size()]);
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
		this.crrNm = this.crrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileCnt = this.fileCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCntcFaxNo = this.joCntcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcInChgNm = this.svcInChgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rid = this.rid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCntcSeq = this.crrCntcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCntcEml = this.joCntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCntcStDt = this.joCntcStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCntcPhnNo = this.joCntcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCntcPicId = this.joCntcPicId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCntcOfcAddr = this.joCntcOfcAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
