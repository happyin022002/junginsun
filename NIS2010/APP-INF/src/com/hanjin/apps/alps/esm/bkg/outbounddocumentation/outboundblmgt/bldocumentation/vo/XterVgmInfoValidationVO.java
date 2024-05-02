/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : XterVgmInfoValidationVO.java
*@FileTitle : XterVgmInfoValidationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class XterVgmInfoValidationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XterVgmInfoValidationVO> models = new ArrayList<XterVgmInfoValidationVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgCntrExists = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String rjctRsnRmk = null;
	/* Column Info */
	private String needAtchCntr = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String cntrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public XterVgmInfoValidationVO() {}

	public XterVgmInfoValidationVO(String ibflag, String pagerows, String bkgNo, String cntrNo, String bkgStsCd, String cnmvStsCd, String bkgCntrExists, String rjctRsnRmk, String needAtchCntr, String rcvTermCd, String deTermCd) {
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgCntrExists = bkgCntrExists;
		this.bkgNo = bkgNo;
		this.deTermCd = deTermCd;
		this.rjctRsnRmk = rjctRsnRmk;
		this.needAtchCntr = needAtchCntr;
		this.rcvTermCd = rcvTermCd;
		this.bkgStsCd = bkgStsCd;
		this.cnmvStsCd = cnmvStsCd;
		this.cntrNo = cntrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_cntr_exists", getBkgCntrExists());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("rjct_rsn_rmk", getRjctRsnRmk());
		this.hashColumns.put("need_atch_cntr", getNeedAtchCntr());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_cntr_exists", "bkgCntrExists");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("rjct_rsn_rmk", "rjctRsnRmk");
		this.hashFields.put("need_atch_cntr", "needAtchCntr");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("cntr_no", "cntrNo");
		return this.hashFields;
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
	 * @return bkgCntrExists
	 */
	public String getBkgCntrExists() {
		return this.bkgCntrExists;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return rjctRsnRmk
	 */
	public String getRjctRsnRmk() {
		return this.rjctRsnRmk;
	}
	
	/**
	 * Column Info
	 * @return needAtchCntr
	 */
	public String getNeedAtchCntr() {
		return this.needAtchCntr;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @param bkgCntrExists
	 */
	public void setBkgCntrExists(String bkgCntrExists) {
		this.bkgCntrExists = bkgCntrExists;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param rjctRsnRmk
	 */
	public void setRjctRsnRmk(String rjctRsnRmk) {
		this.rjctRsnRmk = rjctRsnRmk;
	}
	
	/**
	 * Column Info
	 * @param needAtchCntr
	 */
	public void setNeedAtchCntr(String needAtchCntr) {
		this.needAtchCntr = needAtchCntr;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgCntrExists(JSPUtil.getParameter(request, prefix + "bkg_cntr_exists", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setRjctRsnRmk(JSPUtil.getParameter(request, prefix + "rjct_rsn_rmk", ""));
		setNeedAtchCntr(JSPUtil.getParameter(request, prefix + "need_atch_cntr", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, prefix + "cnmv_sts_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterVgmInfoValidationVO[]
	 */
	public XterVgmInfoValidationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XterVgmInfoValidationVO[]
	 */
	public XterVgmInfoValidationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterVgmInfoValidationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgCntrExists = (JSPUtil.getParameter(request, prefix	+ "bkg_cntr_exists", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] rjctRsnRmk = (JSPUtil.getParameter(request, prefix	+ "rjct_rsn_rmk", length));
			String[] needAtchCntr = (JSPUtil.getParameter(request, prefix	+ "need_atch_cntr", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new XterVgmInfoValidationVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgCntrExists[i] != null)
					model.setBkgCntrExists(bkgCntrExists[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (rjctRsnRmk[i] != null)
					model.setRjctRsnRmk(rjctRsnRmk[i]);
				if (needAtchCntr[i] != null)
					model.setNeedAtchCntr(needAtchCntr[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterVgmInfoValidationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterVgmInfoValidationVO[]
	 */
	public XterVgmInfoValidationVO[] getXterVgmInfoValidationVOs(){
		XterVgmInfoValidationVO[] vos = (XterVgmInfoValidationVO[])models.toArray(new XterVgmInfoValidationVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCntrExists = this.bkgCntrExists .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctRsnRmk = this.rjctRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.needAtchCntr = this.needAtchCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
