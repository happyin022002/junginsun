/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : RocsSearchCntrInfoVO.java
*@FileTitle : RocsSearchCntrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.rocs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocsSearchCntrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsSearchCntrInfoVO> models = new ArrayList<RocsSearchCntrInfoVO>();
	
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrSc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrtrw = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrFm = null;
	/* Column Info */
	private String cntrTs = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RocsSearchCntrInfoVO() {}

	public RocsSearchCntrInfoVO(String ibflag, String pagerows, String cntrNo, String cntrTs, String sealNo, String cntrSc, String cntrFm, String bkgNo, String cntrtrw) {
		this.sealNo = sealNo;
		this.bkgNo = bkgNo;
		this.cntrSc = cntrSc;
		this.ibflag = ibflag;
		this.cntrtrw = cntrtrw;
		this.cntrNo = cntrNo;
		this.cntrFm = cntrFm;
		this.cntrTs = cntrTs;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_sc", getCntrSc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntrtrw", getCntrtrw());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_fm", getCntrFm());
		this.hashColumns.put("cntr_ts", getCntrTs());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_sc", "cntrSc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntrtrw", "cntrtrw");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_fm", "cntrFm");
		this.hashFields.put("cntr_ts", "cntrTs");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sealNo
	 */
	public String getSealNo() {
		return this.sealNo;
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
	 * @return cntrSc
	 */
	public String getCntrSc() {
		return this.cntrSc;
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
	 * @return cntrtrw
	 */
	public String getCntrtrw() {
		return this.cntrtrw;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrFm
	 */
	public String getCntrFm() {
		return this.cntrFm;
	}
	
	/**
	 * Column Info
	 * @return cntrTs
	 */
	public String getCntrTs() {
		return this.cntrTs;
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
	 * @param sealNo
	 */
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
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
	 * @param cntrSc
	 */
	public void setCntrSc(String cntrSc) {
		this.cntrSc = cntrSc;
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
	 * @param cntrtrw
	 */
	public void setCntrtrw(String cntrtrw) {
		this.cntrtrw = cntrtrw;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrFm
	 */
	public void setCntrFm(String cntrFm) {
		this.cntrFm = cntrFm;
	}
	
	/**
	 * Column Info
	 * @param cntrTs
	 */
	public void setCntrTs(String cntrTs) {
		this.cntrTs = cntrTs;
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
		setSealNo(JSPUtil.getParameter(request, prefix + "seal_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrSc(JSPUtil.getParameter(request, prefix + "cntr_sc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrtrw(JSPUtil.getParameter(request, prefix + "cntrtrw", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrFm(JSPUtil.getParameter(request, prefix + "cntr_fm", ""));
		setCntrTs(JSPUtil.getParameter(request, prefix + "cntr_ts", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsSearchCntrInfoVO[]
	 */
	public RocsSearchCntrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsSearchCntrInfoVO[]
	 */
	public RocsSearchCntrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsSearchCntrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrSc = (JSPUtil.getParameter(request, prefix	+ "cntr_sc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrtrw = (JSPUtil.getParameter(request, prefix	+ "cntrtrw", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrFm = (JSPUtil.getParameter(request, prefix	+ "cntr_fm", length));
			String[] cntrTs = (JSPUtil.getParameter(request, prefix	+ "cntr_ts", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsSearchCntrInfoVO();
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrSc[i] != null)
					model.setCntrSc(cntrSc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrtrw[i] != null)
					model.setCntrtrw(cntrtrw[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrFm[i] != null)
					model.setCntrFm(cntrFm[i]);
				if (cntrTs[i] != null)
					model.setCntrTs(cntrTs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsSearchCntrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsSearchCntrInfoVO[]
	 */
	public RocsSearchCntrInfoVO[] getRocsSearchCntrInfoVOs(){
		RocsSearchCntrInfoVO[] vos = (RocsSearchCntrInfoVO[])models.toArray(new RocsSearchCntrInfoVO[models.size()]);
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
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSc = this.cntrSc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtrw = this.cntrtrw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFm = this.cntrFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTs = this.cntrTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
