/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MstCntrVO.java
*@FileTitle : MstCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.26  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo;

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

public class MstCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MstCntrVO> models = new ArrayList<MstCntrVO>();
	
	/* Column Info */
	private String temp1 = null;
	/* Column Info */
	private String uclmEndDt = null;
	/* Column Info */
	private String uclmDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String uclmLsDivCd = null;
	/* Column Info */
	private String ucRsnCd = null;
	/* Column Info */
	private String uclmRsn = null;
	/* Column Info */
	private String ucCsNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MstCntrVO() {}

	public MstCntrVO(String ibflag, String pagerows, String ucCsNo, String blNo, String cntrNo, String uclmLsDivCd, String uclmDt, String uclmRsn, String ucRsnCd, String uclmEndDt, String temp1) {
		this.temp1 = temp1;
		this.uclmEndDt = uclmEndDt;
		this.uclmDt = uclmDt;
		this.ibflag = ibflag;
		this.uclmLsDivCd = uclmLsDivCd;
		this.ucRsnCd = ucRsnCd;
		this.uclmRsn = uclmRsn;
		this.ucCsNo = ucCsNo;
		this.cntrNo = cntrNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("temp1", getTemp1());
		this.hashColumns.put("uclm_end_dt", getUclmEndDt());
		this.hashColumns.put("uclm_dt", getUclmDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("uclm_ls_div_cd", getUclmLsDivCd());
		this.hashColumns.put("uc_rsn_cd", getUcRsnCd());
		this.hashColumns.put("uclm_rsn", getUclmRsn());
		this.hashColumns.put("uc_cs_no", getUcCsNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("temp1", "temp1");
		this.hashFields.put("uclm_end_dt", "uclmEndDt");
		this.hashFields.put("uclm_dt", "uclmDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("uclm_ls_div_cd", "uclmLsDivCd");
		this.hashFields.put("uc_rsn_cd", "ucRsnCd");
		this.hashFields.put("uclm_rsn", "uclmRsn");
		this.hashFields.put("uc_cs_no", "ucCsNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return temp1
	 */
	public String getTemp1() {
		return this.temp1;
	}
	
	/**
	 * Column Info
	 * @return uclmEndDt
	 */
	public String getUclmEndDt() {
		return this.uclmEndDt;
	}
	
	/**
	 * Column Info
	 * @return uclmDt
	 */
	public String getUclmDt() {
		return this.uclmDt;
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
	 * @return uclmLsDivCd
	 */
	public String getUclmLsDivCd() {
		return this.uclmLsDivCd;
	}
	
	/**
	 * Column Info
	 * @return ucRsnCd
	 */
	public String getUcRsnCd() {
		return this.ucRsnCd;
	}
	
	/**
	 * Column Info
	 * @return uclmRsn
	 */
	public String getUclmRsn() {
		return this.uclmRsn;
	}
	
	/**
	 * Column Info
	 * @return ucCsNo
	 */
	public String getUcCsNo() {
		return this.ucCsNo;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @param temp1
	 */
	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}
	
	/**
	 * Column Info
	 * @param uclmEndDt
	 */
	public void setUclmEndDt(String uclmEndDt) {
		this.uclmEndDt = uclmEndDt;
	}
	
	/**
	 * Column Info
	 * @param uclmDt
	 */
	public void setUclmDt(String uclmDt) {
		this.uclmDt = uclmDt;
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
	 * @param uclmLsDivCd
	 */
	public void setUclmLsDivCd(String uclmLsDivCd) {
		this.uclmLsDivCd = uclmLsDivCd;
	}
	
	/**
	 * Column Info
	 * @param ucRsnCd
	 */
	public void setUcRsnCd(String ucRsnCd) {
		this.ucRsnCd = ucRsnCd;
	}
	
	/**
	 * Column Info
	 * @param uclmRsn
	 */
	public void setUclmRsn(String uclmRsn) {
		this.uclmRsn = uclmRsn;
	}
	
	/**
	 * Column Info
	 * @param ucCsNo
	 */
	public void setUcCsNo(String ucCsNo) {
		this.ucCsNo = ucCsNo;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
		setTemp1(JSPUtil.getParameter(request, prefix + "temp1", ""));
		setUclmEndDt(JSPUtil.getParameter(request, prefix + "uclm_end_dt", ""));
		setUclmDt(JSPUtil.getParameter(request, prefix + "uclm_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUclmLsDivCd(JSPUtil.getParameter(request, prefix + "uclm_ls_div_cd", ""));
		setUcRsnCd(JSPUtil.getParameter(request, prefix + "uc_rsn_cd", ""));
		setUclmRsn(JSPUtil.getParameter(request, prefix + "uclm_rsn", ""));
		setUcCsNo(JSPUtil.getParameter(request, prefix + "uc_cs_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MstCntrVO[]
	 */
	public MstCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MstCntrVO[]
	 */
	public MstCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MstCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] temp1 = (JSPUtil.getParameter(request, prefix	+ "temp1", length));
			String[] uclmEndDt = (JSPUtil.getParameter(request, prefix	+ "uclm_end_dt", length));
			String[] uclmDt = (JSPUtil.getParameter(request, prefix	+ "uclm_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] uclmLsDivCd = (JSPUtil.getParameter(request, prefix	+ "uclm_ls_div_cd", length));
			String[] ucRsnCd = (JSPUtil.getParameter(request, prefix	+ "uc_rsn_cd", length));
			String[] uclmRsn = (JSPUtil.getParameter(request, prefix	+ "uclm_rsn", length));
			String[] ucCsNo = (JSPUtil.getParameter(request, prefix	+ "uc_cs_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MstCntrVO();
				if (temp1[i] != null)
					model.setTemp1(temp1[i]);
				if (uclmEndDt[i] != null)
					model.setUclmEndDt(uclmEndDt[i]);
				if (uclmDt[i] != null)
					model.setUclmDt(uclmDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (uclmLsDivCd[i] != null)
					model.setUclmLsDivCd(uclmLsDivCd[i]);
				if (ucRsnCd[i] != null)
					model.setUcRsnCd(ucRsnCd[i]);
				if (uclmRsn[i] != null)
					model.setUclmRsn(uclmRsn[i]);
				if (ucCsNo[i] != null)
					model.setUcCsNo(ucCsNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMstCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MstCntrVO[]
	 */
	public MstCntrVO[] getMstCntrVOs(){
		MstCntrVO[] vos = (MstCntrVO[])models.toArray(new MstCntrVO[models.size()]);
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
		this.temp1 = this.temp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmEndDt = this.uclmEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmDt = this.uclmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsDivCd = this.uclmLsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucRsnCd = this.ucRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmRsn = this.uclmRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucCsNo = this.ucCsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
