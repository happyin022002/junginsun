/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARBkgInterfaceCreationVO.java
*@FileTitle : ARBkgInterfaceCreationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.11.02 최우석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
 * @author 최우석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARBkgInterfaceCreationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARBkgInterfaceCreationVO> models = new ArrayList<ARBkgInterfaceCreationVO>();
	
	/* Column Info */
	private String bkgCorrDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String bkgCorrNo = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String manDivInd = null;
	/* Column Info */
	private String bkgDiv = null;
	/* Column Info */
	private String bkgSeq = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARBkgInterfaceCreationVO() {}

	public ARBkgInterfaceCreationVO(String ibflag, String pagerows, String bkgCorrDt, String bkgNo, String vvdCd, String bkgCorrNo, String manDivInd, String bkgDiv, String userId, String bkgSeq, String arIfNo) {
		this.bkgCorrDt = bkgCorrDt;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.arIfNo = arIfNo;
		this.bkgCorrNo = bkgCorrNo;
		this.userId = userId;
		this.manDivInd = manDivInd;
		this.bkgDiv = bkgDiv;
		this.bkgSeq = bkgSeq;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_corr_dt", getBkgCorrDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("bkg_corr_no", getBkgCorrNo());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("man_div_ind", getManDivInd());
		this.hashColumns.put("bkg_div", getBkgDiv());
		this.hashColumns.put("bkg_seq", getBkgSeq());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_corr_dt", "bkgCorrDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("bkg_corr_no", "bkgCorrNo");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("man_div_ind", "manDivInd");
		this.hashFields.put("bkg_div", "bkgDiv");
		this.hashFields.put("bkg_seq", "bkgSeq");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgCorrDt
	 */
	public String getBkgCorrDt() {
		return this.bkgCorrDt;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCorrNo
	 */
	public String getBkgCorrNo() {
		return this.bkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return manDivInd
	 */
	public String getManDivInd() {
		return this.manDivInd;
	}
	
	/**
	 * Column Info
	 * @return bkgDiv
	 */
	public String getBkgDiv() {
		return this.bkgDiv;
	}
	
	/**
	 * Column Info
	 * @return bkgSeq
	 */
	public String getBkgSeq() {
		return this.bkgSeq;
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
	 * @param bkgCorrDt
	 */
	public void setBkgCorrDt(String bkgCorrDt) {
		this.bkgCorrDt = bkgCorrDt;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCorrNo
	 */
	public void setBkgCorrNo(String bkgCorrNo) {
		this.bkgCorrNo = bkgCorrNo;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param manDivInd
	 */
	public void setManDivInd(String manDivInd) {
		this.manDivInd = manDivInd;
	}
	
	/**
	 * Column Info
	 * @param bkgDiv
	 */
	public void setBkgDiv(String bkgDiv) {
		this.bkgDiv = bkgDiv;
	}
	
	/**
	 * Column Info
	 * @param bkgSeq
	 */
	public void setBkgSeq(String bkgSeq) {
		this.bkgSeq = bkgSeq;
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
		setBkgCorrDt(JSPUtil.getParameter(request, "bkg_corr_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setBkgCorrNo(JSPUtil.getParameter(request, "bkg_corr_no", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setManDivInd(JSPUtil.getParameter(request, "man_div_ind", ""));
		setBkgDiv(JSPUtil.getParameter(request, "bkg_div", ""));
		setBkgSeq(JSPUtil.getParameter(request, "bkg_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARBkgInterfaceCreationVO[]
	 */
	public ARBkgInterfaceCreationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARBkgInterfaceCreationVO[]
	 */
	public ARBkgInterfaceCreationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARBkgInterfaceCreationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgCorrDt = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] bkgCorrNo = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_no", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] manDivInd = (JSPUtil.getParameter(request, prefix	+ "man_div_ind", length));
			String[] bkgDiv = (JSPUtil.getParameter(request, prefix	+ "bkg_div", length));
			String[] bkgSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARBkgInterfaceCreationVO();
				if (bkgCorrDt[i] != null)
					model.setBkgCorrDt(bkgCorrDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (bkgCorrNo[i] != null)
					model.setBkgCorrNo(bkgCorrNo[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (manDivInd[i] != null)
					model.setManDivInd(manDivInd[i]);
				if (bkgDiv[i] != null)
					model.setBkgDiv(bkgDiv[i]);
				if (bkgSeq[i] != null)
					model.setBkgSeq(bkgSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARBkgInterfaceCreationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARBkgInterfaceCreationVO[]
	 */
	public ARBkgInterfaceCreationVO[] getARBkgInterfaceCreationVOs(){
		ARBkgInterfaceCreationVO[] vos = (ARBkgInterfaceCreationVO[])models.toArray(new ARBkgInterfaceCreationVO[models.size()]);
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
		this.bkgCorrDt = this.bkgCorrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrNo = this.bkgCorrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manDivInd = this.manDivInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDiv = this.bkgDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSeq = this.bkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
