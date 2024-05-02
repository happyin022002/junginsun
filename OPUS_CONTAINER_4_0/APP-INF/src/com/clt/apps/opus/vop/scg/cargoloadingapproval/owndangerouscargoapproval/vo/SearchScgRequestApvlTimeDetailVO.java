/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchScgRequestApvlTimeDetailVO.java
*@FileTitle : SearchScgRequestApvlTimeDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.04.28 김현욱 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

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
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchScgRequestApvlTimeDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchScgRequestApvlTimeDetailVO> models = new ArrayList<SearchScgRequestApvlTimeDetailVO>();
	
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String authFlg = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String authDt = null;
	/* Column Info */
	private String spclCgoCateCd = null;
	/* Column Info */
	private String vslPrePstNm = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String tretGap = null;
	/* Column Info */
	private String spclCgoAproRqstSeq = null;
	/* Column Info */
	private String authUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchScgRequestApvlTimeDetailVO() {}

	public SearchScgRequestApvlTimeDetailVO(String ibflag, String pagerows, String slanCd, String vvdCd, String vslPrePstNm, String bkgNo, String spclCgoCateCd, String spclCgoAproRqstSeq, String rqstDt, String rqstUsrId, String authDt, String authUsrId, String authFlg, String tretGap) {
		this.rqstDt = rqstDt;
		this.authFlg = authFlg;
		this.rqstUsrId = rqstUsrId;
		this.authDt = authDt;
		this.spclCgoCateCd = spclCgoCateCd;
		this.vslPrePstNm = vslPrePstNm;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.slanCd = slanCd;
		this.vvdCd = vvdCd;
		this.tretGap = tretGap;
		this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
		this.authUsrId = authUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("auth_flg", getAuthFlg());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("auth_dt", getAuthDt());
		this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
		this.hashColumns.put("vsl_pre_pst_nm", getVslPrePstNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("tret_gap", getTretGap());
		this.hashColumns.put("spcl_cgo_apro_rqst_seq", getSpclCgoAproRqstSeq());
		this.hashColumns.put("auth_usr_id", getAuthUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("auth_flg", "authFlg");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("auth_dt", "authDt");
		this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
		this.hashFields.put("vsl_pre_pst_nm", "vslPrePstNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("tret_gap", "tretGap");
		this.hashFields.put("spcl_cgo_apro_rqst_seq", "spclCgoAproRqstSeq");
		this.hashFields.put("auth_usr_id", "authUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return authFlg
	 */
	public String getAuthFlg() {
		return this.authFlg;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return authDt
	 */
	public String getAuthDt() {
		return this.authDt;
	}
	
	/**
	 * Column Info
	 * @return spclCgoCateCd
	 */
	public String getSpclCgoCateCd() {
		return this.spclCgoCateCd;
	}
	
	/**
	 * Column Info
	 * @return vslPrePstNm
	 */
	public String getVslPrePstNm() {
		return this.vslPrePstNm;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return tretGap
	 */
	public String getTretGap() {
		return this.tretGap;
	}
	
	/**
	 * Column Info
	 * @return spclCgoAproRqstSeq
	 */
	public String getSpclCgoAproRqstSeq() {
		return this.spclCgoAproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return authUsrId
	 */
	public String getAuthUsrId() {
		return this.authUsrId;
	}
	

	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param authFlg
	 */
	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param authDt
	 */
	public void setAuthDt(String authDt) {
		this.authDt = authDt;
	}
	
	/**
	 * Column Info
	 * @param spclCgoCateCd
	 */
	public void setSpclCgoCateCd(String spclCgoCateCd) {
		this.spclCgoCateCd = spclCgoCateCd;
	}
	
	/**
	 * Column Info
	 * @param vslPrePstNm
	 */
	public void setVslPrePstNm(String vslPrePstNm) {
		this.vslPrePstNm = vslPrePstNm;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param tretGap
	 */
	public void setTretGap(String tretGap) {
		this.tretGap = tretGap;
	}
	
	/**
	 * Column Info
	 * @param spclCgoAproRqstSeq
	 */
	public void setSpclCgoAproRqstSeq(String spclCgoAproRqstSeq) {
		this.spclCgoAproRqstSeq = spclCgoAproRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param authUsrId
	 */
	public void setAuthUsrId(String authUsrId) {
		this.authUsrId = authUsrId;
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
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setAuthFlg(JSPUtil.getParameter(request, prefix + "auth_flg", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setAuthDt(JSPUtil.getParameter(request, prefix + "auth_dt", ""));
		setSpclCgoCateCd(JSPUtil.getParameter(request, prefix + "spcl_cgo_cate_cd", ""));
		setVslPrePstNm(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setTretGap(JSPUtil.getParameter(request, prefix + "tret_gap", ""));
		setSpclCgoAproRqstSeq(JSPUtil.getParameter(request, prefix + "spcl_cgo_apro_rqst_seq", ""));
		setAuthUsrId(JSPUtil.getParameter(request, prefix + "auth_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchScgRequestApvlTimeDetailVO[]
	 */
	public SearchScgRequestApvlTimeDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchScgRequestApvlTimeDetailVO[]
	 */
	public SearchScgRequestApvlTimeDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchScgRequestApvlTimeDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] authFlg = (JSPUtil.getParameter(request, prefix	+ "auth_flg", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] authDt = (JSPUtil.getParameter(request, prefix	+ "auth_dt", length));
			String[] spclCgoCateCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_cate_cd", length));
			String[] vslPrePstNm = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] tretGap = (JSPUtil.getParameter(request, prefix	+ "tret_gap", length));
			String[] spclCgoAproRqstSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_apro_rqst_seq", length));
			String[] authUsrId = (JSPUtil.getParameter(request, prefix	+ "auth_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchScgRequestApvlTimeDetailVO();
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (authFlg[i] != null)
					model.setAuthFlg(authFlg[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (authDt[i] != null)
					model.setAuthDt(authDt[i]);
				if (spclCgoCateCd[i] != null)
					model.setSpclCgoCateCd(spclCgoCateCd[i]);
				if (vslPrePstNm[i] != null)
					model.setVslPrePstNm(vslPrePstNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (tretGap[i] != null)
					model.setTretGap(tretGap[i]);
				if (spclCgoAproRqstSeq[i] != null)
					model.setSpclCgoAproRqstSeq(spclCgoAproRqstSeq[i]);
				if (authUsrId[i] != null)
					model.setAuthUsrId(authUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchScgRequestApvlTimeDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchScgRequestApvlTimeDetailVO[]
	 */
	public SearchScgRequestApvlTimeDetailVO[] getSearchScgRequestApvlTimeDetailVOs(){
		SearchScgRequestApvlTimeDetailVO[] vos = (SearchScgRequestApvlTimeDetailVO[])models.toArray(new SearchScgRequestApvlTimeDetailVO[models.size()]);
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
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authFlg = this.authFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authDt = this.authDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCateCd = this.spclCgoCateCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstNm = this.vslPrePstNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tretGap = this.tretGap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAproRqstSeq = this.spclCgoAproRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authUsrId = this.authUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
