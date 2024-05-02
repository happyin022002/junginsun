/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CreateBSAVO.java
*@FileTitle : CreateBSAVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.03.29 남궁진호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CreateBSAVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreateBSAVO> models = new ArrayList<CreateBSAVO>();
	
	/* Column Info */
	private String pErrorCode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pFmYrwk = null;
	/* Column Info */
	private String pErrorMsg = null;
	/* Column Info */
	private String pDirCd = null;
	/* Column Info */
	private String pInd = null;
	/* Column Info */
	private String pUserId = null;
	/* Column Info */
	private String pToYrwk = null;
	/* Column Info */
	private String pRlaneCd = null;
	/* Column Info */
	private String pTrdCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CreateBSAVO() {}

	public CreateBSAVO(String ibflag, String pagerows, String pFmYrwk, String pToYrwk, String pInd, String pTrdCd, String pRlaneCd, String pDirCd, String pUserId, String pErrorCode, String pErrorMsg) {
		this.pErrorCode = pErrorCode;
		this.ibflag = ibflag;
		this.pFmYrwk = pFmYrwk;
		this.pErrorMsg = pErrorMsg;
		this.pDirCd = pDirCd;
		this.pInd = pInd;
		this.pUserId = pUserId;
		this.pToYrwk = pToYrwk;
		this.pRlaneCd = pRlaneCd;
		this.pTrdCd = pTrdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p_error_code", getPErrorCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_fm_yrwk", getPFmYrwk());
		this.hashColumns.put("p_error_msg", getPErrorMsg());
		this.hashColumns.put("p_dir_cd", getPDirCd());
		this.hashColumns.put("p_ind", getPInd());
		this.hashColumns.put("p_user_id", getPUserId());
		this.hashColumns.put("p_to_yrwk", getPToYrwk());
		this.hashColumns.put("p_rlane_cd", getPRlaneCd());
		this.hashColumns.put("p_trd_cd", getPTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p_error_code", "pErrorCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_fm_yrwk", "pFmYrwk");
		this.hashFields.put("p_error_msg", "pErrorMsg");
		this.hashFields.put("p_dir_cd", "pDirCd");
		this.hashFields.put("p_ind", "pInd");
		this.hashFields.put("p_user_id", "pUserId");
		this.hashFields.put("p_to_yrwk", "pToYrwk");
		this.hashFields.put("p_rlane_cd", "pRlaneCd");
		this.hashFields.put("p_trd_cd", "pTrdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pErrorCode
	 */
	public String getPErrorCode() {
		return this.pErrorCode;
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
	 * @return pFmYrwk
	 */
	public String getPFmYrwk() {
		return this.pFmYrwk;
	}
	
	/**
	 * Column Info
	 * @return pErrorMsg
	 */
	public String getPErrorMsg() {
		return this.pErrorMsg;
	}
	
	/**
	 * Column Info
	 * @return pDirCd
	 */
	public String getPDirCd() {
		return this.pDirCd;
	}
	
	/**
	 * Column Info
	 * @return pInd
	 */
	public String getPInd() {
		return this.pInd;
	}
	
	/**
	 * Column Info
	 * @return pUserId
	 */
	public String getPUserId() {
		return this.pUserId;
	}
	
	/**
	 * Column Info
	 * @return pToYrwk
	 */
	public String getPToYrwk() {
		return this.pToYrwk;
	}
	
	/**
	 * Column Info
	 * @return pRlaneCd
	 */
	public String getPRlaneCd() {
		return this.pRlaneCd;
	}
	
	/**
	 * Column Info
	 * @return pTrdCd
	 */
	public String getPTrdCd() {
		return this.pTrdCd;
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
	 * @param pErrorCode
	 */
	public void setPErrorCode(String pErrorCode) {
		this.pErrorCode = pErrorCode;
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
	 * @param pFmYrwk
	 */
	public void setPFmYrwk(String pFmYrwk) {
		this.pFmYrwk = pFmYrwk;
	}
	
	/**
	 * Column Info
	 * @param pErrorMsg
	 */
	public void setPErrorMsg(String pErrorMsg) {
		this.pErrorMsg = pErrorMsg;
	}
	
	/**
	 * Column Info
	 * @param pDirCd
	 */
	public void setPDirCd(String pDirCd) {
		this.pDirCd = pDirCd;
	}
	
	/**
	 * Column Info
	 * @param pInd
	 */
	public void setPInd(String pInd) {
		this.pInd = pInd;
	}
	
	/**
	 * Column Info
	 * @param pUserId
	 */
	public void setPUserId(String pUserId) {
		this.pUserId = pUserId;
	}
	
	/**
	 * Column Info
	 * @param pToYrwk
	 */
	public void setPToYrwk(String pToYrwk) {
		this.pToYrwk = pToYrwk;
	}
	
	/**
	 * Column Info
	 * @param pRlaneCd
	 */
	public void setPRlaneCd(String pRlaneCd) {
		this.pRlaneCd = pRlaneCd;
	}
	
	/**
	 * Column Info
	 * @param pTrdCd
	 */
	public void setPTrdCd(String pTrdCd) {
		this.pTrdCd = pTrdCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setPErrorCode(JSPUtil.getParameter(request, prefix + "p_error_code", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPFmYrwk(JSPUtil.getParameter(request, prefix + "p_fm_yrwk", ""));
		setPErrorMsg(JSPUtil.getParameter(request, prefix + "p_error_msg", ""));
		setPDirCd(JSPUtil.getParameter(request, prefix + "p_dir_cd", ""));
		setPInd(JSPUtil.getParameter(request, prefix + "p_ind", ""));
		setPUserId(JSPUtil.getParameter(request, prefix + "p_user_id", ""));
		setPToYrwk(JSPUtil.getParameter(request, prefix + "p_to_yrwk", ""));
		setPRlaneCd(JSPUtil.getParameter(request, prefix + "p_rlane_cd", ""));
		setPTrdCd(JSPUtil.getParameter(request, prefix + "p_trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreateBSAVO[]
	 */
	public CreateBSAVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreateBSAVO[]
	 */
	public CreateBSAVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreateBSAVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pErrorCode = (JSPUtil.getParameter(request, prefix	+ "p_error_code", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pFmYrwk = (JSPUtil.getParameter(request, prefix	+ "p_fm_yrwk", length));
			String[] pErrorMsg = (JSPUtil.getParameter(request, prefix	+ "p_error_msg", length));
			String[] pDirCd = (JSPUtil.getParameter(request, prefix	+ "p_dir_cd", length));
			String[] pInd = (JSPUtil.getParameter(request, prefix	+ "p_ind", length));
			String[] pUserId = (JSPUtil.getParameter(request, prefix	+ "p_user_id", length));
			String[] pToYrwk = (JSPUtil.getParameter(request, prefix	+ "p_to_yrwk", length));
			String[] pRlaneCd = (JSPUtil.getParameter(request, prefix	+ "p_rlane_cd", length));
			String[] pTrdCd = (JSPUtil.getParameter(request, prefix	+ "p_trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CreateBSAVO();
				if (pErrorCode[i] != null)
					model.setPErrorCode(pErrorCode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pFmYrwk[i] != null)
					model.setPFmYrwk(pFmYrwk[i]);
				if (pErrorMsg[i] != null)
					model.setPErrorMsg(pErrorMsg[i]);
				if (pDirCd[i] != null)
					model.setPDirCd(pDirCd[i]);
				if (pInd[i] != null)
					model.setPInd(pInd[i]);
				if (pUserId[i] != null)
					model.setPUserId(pUserId[i]);
				if (pToYrwk[i] != null)
					model.setPToYrwk(pToYrwk[i]);
				if (pRlaneCd[i] != null)
					model.setPRlaneCd(pRlaneCd[i]);
				if (pTrdCd[i] != null)
					model.setPTrdCd(pTrdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreateBSAVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreateBSAVO[]
	 */
	public CreateBSAVO[] getCreateBSAVOs(){
		CreateBSAVO[] vos = (CreateBSAVO[])models.toArray(new CreateBSAVO[models.size()]);
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
		this.pErrorCode = this.pErrorCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFmYrwk = this.pFmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pErrorMsg = this.pErrorMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDirCd = this.pDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pInd = this.pInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pUserId = this.pUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pToYrwk = this.pToYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pRlaneCd = this.pRlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pTrdCd = this.pTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
