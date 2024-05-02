/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContactPointVO.java
*@FileTitle : ContactPointVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.10.21 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ContactPointVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ContactPointVO> models = new ArrayList<ContactPointVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cntcPntEml = null;
	/* Column Info */
	private String cntcPntFaxNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String clmCntcPntSeq = null;
	/* Column Info */
	private String cntcPntPhnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clmPtyNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntcPntRmk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String cntcPntNm = null;
	/* Column Info */
	private String intlFaxNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String intlPhnNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ContactPointVO() {}

	public ContactPointVO(String ibflag, String pagerows, String clmPtyNo, String clmCntcPntSeq, String cntcPntNm, String intlPhnNo, String cntcPntPhnNo, String intlFaxNo, String cntcPntFaxNo, String cntcPntEml, String cntcPntRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.cntcPntEml = cntcPntEml;
		this.cntcPntFaxNo = cntcPntFaxNo;
		this.creDt = creDt;
		this.clmCntcPntSeq = clmCntcPntSeq;
		this.cntcPntPhnNo = cntcPntPhnNo;
		this.pagerows = pagerows;
		this.clmPtyNo = clmPtyNo;
		this.ibflag = ibflag;
		this.cntcPntRmk = cntcPntRmk;
		this.creUsrId = creUsrId;
		this.cntcPntNm = cntcPntNm;
		this.intlFaxNo = intlFaxNo;
		this.updUsrId = updUsrId;
		this.intlPhnNo = intlPhnNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cntc_pnt_eml", getCntcPntEml());
		this.hashColumns.put("cntc_pnt_fax_no", getCntcPntFaxNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("clm_cntc_pnt_seq", getClmCntcPntSeq());
		this.hashColumns.put("cntc_pnt_phn_no", getCntcPntPhnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clm_pty_no", getClmPtyNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntc_pnt_rmk", getCntcPntRmk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cntc_pnt_nm", getCntcPntNm());
		this.hashColumns.put("intl_fax_no", getIntlFaxNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cntc_pnt_eml", "cntcPntEml");
		this.hashFields.put("cntc_pnt_fax_no", "cntcPntFaxNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("clm_cntc_pnt_seq", "clmCntcPntSeq");
		this.hashFields.put("cntc_pnt_phn_no", "cntcPntPhnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clm_pty_no", "clmPtyNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntc_pnt_rmk", "cntcPntRmk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cntc_pnt_nm", "cntcPntNm");
		this.hashFields.put("intl_fax_no", "intlFaxNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("intl_phn_no", "intlPhnNo");
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
	 * @return cntcPntEml
	 */
	public String getCntcPntEml() {
		return this.cntcPntEml;
	}
	
	/**
	 * Column Info
	 * @return cntcPntFaxNo
	 */
	public String getCntcPntFaxNo() {
		return this.cntcPntFaxNo;
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
	 * @return clmCntcPntSeq
	 */
	public String getClmCntcPntSeq() {
		return this.clmCntcPntSeq;
	}
	
	/**
	 * Column Info
	 * @return cntcPntPhnNo
	 */
	public String getCntcPntPhnNo() {
		return this.cntcPntPhnNo;
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
	 * @return clmPtyNo
	 */
	public String getClmPtyNo() {
		return this.clmPtyNo;
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
	 * @return cntcPntRmk
	 */
	public String getCntcPntRmk() {
		return this.cntcPntRmk;
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
	 * @return cntcPntNm
	 */
	public String getCntcPntNm() {
		return this.cntcPntNm;
	}
	
	/**
	 * Column Info
	 * @return intlFaxNo
	 */
	public String getIntlFaxNo() {
		return this.intlFaxNo;
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
	 * @return intlPhnNo
	 */
	public String getIntlPhnNo() {
		return this.intlPhnNo;
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
	 * @param cntcPntEml
	 */
	public void setCntcPntEml(String cntcPntEml) {
		this.cntcPntEml = cntcPntEml;
	}
	
	/**
	 * Column Info
	 * @param cntcPntFaxNo
	 */
	public void setCntcPntFaxNo(String cntcPntFaxNo) {
		this.cntcPntFaxNo = cntcPntFaxNo;
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
	 * @param clmCntcPntSeq
	 */
	public void setClmCntcPntSeq(String clmCntcPntSeq) {
		this.clmCntcPntSeq = clmCntcPntSeq;
	}
	
	/**
	 * Column Info
	 * @param cntcPntPhnNo
	 */
	public void setCntcPntPhnNo(String cntcPntPhnNo) {
		this.cntcPntPhnNo = cntcPntPhnNo;
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
	 * @param clmPtyNo
	 */
	public void setClmPtyNo(String clmPtyNo) {
		this.clmPtyNo = clmPtyNo;
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
	 * @param cntcPntRmk
	 */
	public void setCntcPntRmk(String cntcPntRmk) {
		this.cntcPntRmk = cntcPntRmk;
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
	 * @param cntcPntNm
	 */
	public void setCntcPntNm(String cntcPntNm) {
		this.cntcPntNm = cntcPntNm;
	}
	
	/**
	 * Column Info
	 * @param intlFaxNo
	 */
	public void setIntlFaxNo(String intlFaxNo) {
		this.intlFaxNo = intlFaxNo;
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
	 * @param intlPhnNo
	 */
	public void setIntlPhnNo(String intlPhnNo) {
		this.intlPhnNo = intlPhnNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCntcPntEml(JSPUtil.getParameter(request, "cntc_pnt_eml", ""));
		setCntcPntFaxNo(JSPUtil.getParameter(request, "cntc_pnt_fax_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setClmCntcPntSeq(JSPUtil.getParameter(request, "clm_cntc_pnt_seq", ""));
		setCntcPntPhnNo(JSPUtil.getParameter(request, "cntc_pnt_phn_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setClmPtyNo(JSPUtil.getParameter(request, "clm_pty_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntcPntRmk(JSPUtil.getParameter(request, "cntc_pnt_rmk", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setCntcPntNm(JSPUtil.getParameter(request, "cntc_pnt_nm", ""));
		setIntlFaxNo(JSPUtil.getParameter(request, "intl_fax_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, "intl_phn_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ContactPointVO[]
	 */
	public ContactPointVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ContactPointVO[]
	 */
	public ContactPointVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ContactPointVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cntcPntEml = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_eml", length));
			String[] cntcPntFaxNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_fax_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] clmCntcPntSeq = (JSPUtil.getParameter(request, prefix	+ "clm_cntc_pnt_seq", length));
			String[] cntcPntPhnNo = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_phn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clm_pty_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntcPntRmk = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_rmk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] cntcPntNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pnt_nm", length));
			String[] intlFaxNo = (JSPUtil.getParameter(request, prefix	+ "intl_fax_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new ContactPointVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cntcPntEml[i] != null)
					model.setCntcPntEml(cntcPntEml[i]);
				if (cntcPntFaxNo[i] != null)
					model.setCntcPntFaxNo(cntcPntFaxNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (clmCntcPntSeq[i] != null)
					model.setClmCntcPntSeq(clmCntcPntSeq[i]);
				if (cntcPntPhnNo[i] != null)
					model.setCntcPntPhnNo(cntcPntPhnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clmPtyNo[i] != null)
					model.setClmPtyNo(clmPtyNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntcPntRmk[i] != null)
					model.setCntcPntRmk(cntcPntRmk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (cntcPntNm[i] != null)
					model.setCntcPntNm(cntcPntNm[i]);
				if (intlFaxNo[i] != null)
					model.setIntlFaxNo(intlFaxNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (intlPhnNo[i] != null)
					model.setIntlPhnNo(intlPhnNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getContactPointVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ContactPointVO[]
	 */
	public ContactPointVO[] getContactPointVOs(){
		ContactPointVO[] vos = (ContactPointVO[])models.toArray(new ContactPointVO[models.size()]);
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
		this.cntcPntEml = this.cntcPntEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntFaxNo = this.cntcPntFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCntcPntSeq = this.clmCntcPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntPhnNo = this.cntcPntPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyNo = this.clmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntRmk = this.cntcPntRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPntNm = this.cntcPntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlFaxNo = this.intlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
