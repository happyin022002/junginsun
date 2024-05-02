/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CreateResponsibleOfficeChangeApproveVO.java
*@FileTitle : CreateResponsibleOfficeChangeApproveVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.10.01 최 선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최 선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CreateWriteOffApproveVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreateWriteOffApproveVO> models = new ArrayList<CreateWriteOffApproveVO>();
	
	/* Column Info */
	private String sStlCltOfcCngAmt = null;
	/* Column Info */
	private String stlCltOfcCngAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sN3ptyNo = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String sUserId = null;
	/* Column Info */
	private String sRaRmk1 = null;
	/* Column Info */
	private String sStlFwrdOfcCd = null;
	/* Column Info */
	private String sChk = null;
	/* Column Info */
	private String sFileNo = null;
	/* Column Info */
	private String sUserOfcCd = null;
	/* Column Info */
	private String chkApp = null;
	/* Column Info */
	private String chkRej = null;
	/* Column Info */
	private String reviewStep = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sWrtfRsnCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CreateWriteOffApproveVO() {}

	public CreateWriteOffApproveVO(String ibflag, String pagerows, String sChk,  String sWrtfRsnCd, String sN3ptyNo, String n3ptyNo, String sStlCltOfcCngAmt, String stlCltOfcCngAmt, String sStlFwrdOfcCd, String sRaRmk1, String sUserOfcCd, String sUserId, String sFileNo, String chkApp, String chkRej, String reviewStep) {
		this.sStlCltOfcCngAmt = sStlCltOfcCngAmt;
		this.stlCltOfcCngAmt = stlCltOfcCngAmt;
		this.ibflag = ibflag;
		this.sN3ptyNo = sN3ptyNo;
		this.n3ptyNo = n3ptyNo;
		this.sUserId = sUserId;
		this.sRaRmk1 = sRaRmk1;
		this.sStlFwrdOfcCd = sStlFwrdOfcCd;
		this.sChk = sChk;
		this.sFileNo = sFileNo;
		this.sUserOfcCd = sUserOfcCd;
		this.chkApp = chkApp;
		this.chkRej = chkRej;
		this.reviewStep = reviewStep;
		this.pagerows = pagerows;
		this.sWrtfRsnCd = sWrtfRsnCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_stl_clt_ofc_cng_amt", getSStlCltOfcCngAmt());
		this.hashColumns.put("stl_clt_ofc_cng_amt", getStlCltOfcCngAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("s_user_id", getSUserId());
		this.hashColumns.put("s_ra_rmk1", getSRaRmk1());
		this.hashColumns.put("s_stl_fwrd_ofc_cd", getSStlFwrdOfcCd());
		this.hashColumns.put("s_chk", getSChk());
		this.hashColumns.put("s_file_no", getSFileNo());
		this.hashColumns.put("s_user_ofc_cd", getSUserOfcCd());
		this.hashColumns.put("chk_app", getChkApp());
		this.hashColumns.put("chk_rej", getChkRej());
		this.hashColumns.put("review_step", getReviewStep());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_wrtf_rsn_cd", getSWrtfRsnCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_stl_clt_ofc_cng_amt", "sStlCltOfcCngAmt");
		this.hashFields.put("stl_clt_ofc_cng_amt", "stlCltOfcCngAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_n3pty_no", "sN3ptyNo");
		this.hashFields.put("n3pty_no", "N3ptyNo");
		this.hashFields.put("s_user_id", "sUserId");
		this.hashFields.put("s_ra_rmk1", "sRaRmk1");
		this.hashFields.put("s_stl_fwrd_ofc_cd", "sStlFwrdOfcCd");
		this.hashFields.put("s_chk", "sChk");
		this.hashFields.put("s_file_no", "sFileNo");
		this.hashFields.put("s_user_ofc_cd", "sUserOfcCd");
		this.hashFields.put("chk_app", "chkApp");
		this.hashFields.put("chk_rej", "chkRej");
		this.hashFields.put("review_step", "reviewStep");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_wrtf_rsn_cd", "sWrtfRsnCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sStlCltOfcCngAmt
	 */
	public String getSStlCltOfcCngAmt() {
		return this.sStlCltOfcCngAmt;
	}
	
	/**
	 * Column Info
	 * @return stlCltOfcCngAmt
	 */
	public String getStlCltOfcCngAmt() {
		return this.stlCltOfcCngAmt;
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
	 * @return sN3ptyNo
	 */
	public String getSN3ptyNo() {
		return this.sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return sUserId
	 */
	public String getSUserId() {
		return this.sUserId;
	}
	
	/**
	 * Column Info
	 * @return sRaRmk1
	 */
	public String getSRaRmk1() {
		return this.sRaRmk1;
	}
	
	/**
	 * Column Info
	 * @return sStlFwrdOfcCd
	 */
	public String getSStlFwrdOfcCd() {
		return this.sStlFwrdOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sChk
	 */
	public String getSChk() {
		return this.sChk;
	}
	
	/**
	 * Column Info
	 * @return sFileNo
	 */
	public String getSFileNo() {
		return this.sFileNo;
	}
	
	/**
	 * Column Info
	 * @return sUserOfcCd
	 */
	public String getSUserOfcCd() {
		return this.sUserOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chkApp
	 */
	public String getChkApp() {
		return this.chkApp;
	}
	
	/**
	 * Column Info
	 * @return chkRej
	 */
	public String getChkRej() {
		return this.chkRej;
	}
	
	/**
	 * Column Info
	 * @return reviewStep
	 */
	public String getReviewStep() {
		return this.reviewStep;
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
	 * @return sWrtfRsnCd
	 */
	public String getSWrtfRsnCd() {
		return this.sWrtfRsnCd;
	}
	
	/**
	 * Column Info
	 * @param sStlCltOfcCngAmt
	 */
	public void setSStlCltOfcCngAmt(String sStlCltOfcCngAmt) {
		this.sStlCltOfcCngAmt = sStlCltOfcCngAmt;
	}
	
	/**
	 * Column Info
	 * @param stlCltOfcCngAmt
	 */
	public void setStlCltOfcCngAmt(String stlCltOfcCngAmt) {
		this.stlCltOfcCngAmt = stlCltOfcCngAmt;
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
	 * @param sN3ptyNo
	 */
	public void setSN3ptyNo(String sN3ptyNo) {
		this.sN3ptyNo = sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param sUserId
	 */
	public void setSUserId(String sUserId) {
		this.sUserId = sUserId;
	}
	
	/**
	 * Column Info
	 * @param sRaRmk1
	 */
	public void setSRaRmk1(String sRaRmk1) {
		this.sRaRmk1 = sRaRmk1;
	}
	
	/**
	 * Column Info
	 * @param sStlFwrdOfcCd
	 */
	public void setSStlFwrdOfcCd(String sStlFwrdOfcCd) {
		this.sStlFwrdOfcCd = sStlFwrdOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sChk
	 */
	public void setSChk(String sChk) {
		this.sChk = sChk;
	}
	
	/**
	 * Column Info
	 * @param sFileNo
	 */
	public void setSFileNo(String sFileNo) {
		this.sFileNo = sFileNo;
	}
	
	/**
	 * Column Info
	 * @param sUserOfcCd
	 */
	public void setSUserOfcCd(String sUserOfcCd) {
		this.sUserOfcCd = sUserOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chkApp
	 */
	public void setChkApp(String chkApp) {
		this.chkApp = chkApp;
	}
	
	/**
	 * Column Info
	 * @param chkRej
	 */
	public void setChkRej(String chkRej) {
		this.chkRej = chkRej;
	}
	
	/**
	 * Column Info
	 * @param reviewStep
	 */
	public void setReviewStep(String reviewStep) {
		this.reviewStep = reviewStep;
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
	 * @param sWrtfRsnCd
	 */
	public void setSWrtfRsnCd(String sWrtfRsnCd) {
		this.sWrtfRsnCd = sWrtfRsnCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSStlCltOfcCngAmt(JSPUtil.getParameter(request, "s_stl_clt_ofc_cng_amt", ""));
		setStlCltOfcCngAmt(JSPUtil.getParameter(request, "stl_clt_ofc_cng_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSN3ptyNo(JSPUtil.getParameter(request, "s_n3pty_no", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setSUserId(JSPUtil.getParameter(request, "s_user_id", ""));
		setSRaRmk1(JSPUtil.getParameter(request, "s_ra_rmk1", ""));
		setSStlFwrdOfcCd(JSPUtil.getParameter(request, "s_stl_fwrd_ofc_cd", ""));
		setSChk(JSPUtil.getParameter(request, "s_chk", ""));
		setSFileNo(JSPUtil.getParameter(request, "s_file_no", ""));
		setSUserOfcCd(JSPUtil.getParameter(request, "s_user_ofc_cd", ""));
		setChkApp(JSPUtil.getParameter(request, "chk_app", ""));
		setChkRej(JSPUtil.getParameter(request, "chk_rej", ""));
		setReviewStep(JSPUtil.getParameter(request, "review_step", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSWrtfRsnCd(JSPUtil.getParameter(request, "s_wrtf_rsn_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreateResponsibleOfficeChangeApproveVO[]
	 */
	public CreateWriteOffApproveVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreateResponsibleOfficeChangeApproveVO[]
	 */
	public CreateWriteOffApproveVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreateWriteOffApproveVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sStlCltOfcCngAmt = (JSPUtil.getParameter(request, prefix	+ "s_stl_clt_ofc_cng_amt", length));
			String[] stlCltOfcCngAmt = (JSPUtil.getParameter(request, prefix	+ "stl_clt_ofc_cng_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] sUserId = (JSPUtil.getParameter(request, prefix	+ "s_user_id", length));
			String[] sRaRmk1 = (JSPUtil.getParameter(request, prefix	+ "s_ra_rmk1", length));
			String[] sStlFwrdOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_stl_fwrd_ofc_cd", length));
			String[] sChk = (JSPUtil.getParameter(request, prefix	+ "s_chk", length));
			String[] sFileNo = (JSPUtil.getParameter(request, prefix	+ "s_file_no", length));
			String[] sUserOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_user_ofc_cd", length));
			String[] chkApp = (JSPUtil.getParameter(request, prefix	+ "chk_app", length));
			String[] chkRej = (JSPUtil.getParameter(request, prefix	+ "chk_rej", length));
			String[] reviewStep = (JSPUtil.getParameter(request, prefix	+ "review_step", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sWrtfRsnCd = (JSPUtil.getParameter(request, prefix	+ "s_wrtf_rsn_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CreateWriteOffApproveVO();
				if (sStlCltOfcCngAmt[i] != null)
					model.setSStlCltOfcCngAmt(sStlCltOfcCngAmt[i]);
				if (stlCltOfcCngAmt[i] != null)
					model.setStlCltOfcCngAmt(stlCltOfcCngAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sN3ptyNo[i] != null)
					model.setSN3ptyNo(sN3ptyNo[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (sUserId[i] != null)
					model.setSUserId(sUserId[i]);
				if (sRaRmk1[i] != null)
					model.setSRaRmk1(sRaRmk1[i]);
				if (sStlFwrdOfcCd[i] != null)
					model.setSStlFwrdOfcCd(sStlFwrdOfcCd[i]);
				if (sChk[i] != null)
					model.setSChk(sChk[i]);
				if (sFileNo[i] != null)
					model.setSFileNo(sFileNo[i]);
				if (sUserOfcCd[i] != null)
					model.setSUserOfcCd(sUserOfcCd[i]);
				if (chkApp[i] != null)
					model.setChkApp(chkApp[i]);
				if (chkRej[i] != null)
					model.setChkRej(chkRej[i]);
				if (reviewStep[i] != null)
					model.setReviewStep(reviewStep[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sWrtfRsnCd[i] != null)
					model.setSWrtfRsnCd(sWrtfRsnCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreateResponsibleOfficeChangeApproveVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreateResponsibleOfficeChangeApproveVO[]
	 */
	public CreateWriteOffApproveVO[] getCreateResponsibleOfficeChangeApproveVOs(){
		CreateWriteOffApproveVO[] vos = (CreateWriteOffApproveVO[])models.toArray(new CreateWriteOffApproveVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.sStlCltOfcCngAmt = this.sStlCltOfcCngAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCltOfcCngAmt = this.stlCltOfcCngAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNo = this.sN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUserId = this.sUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRaRmk1 = this.sRaRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sStlFwrdOfcCd = this.sStlFwrdOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChk = this.sChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFileNo = this.sFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUserOfcCd = this.sUserOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkApp = this.chkApp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkRej = this.chkRej .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reviewStep = this.reviewStep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sWrtfRsnCd = this.sWrtfRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
