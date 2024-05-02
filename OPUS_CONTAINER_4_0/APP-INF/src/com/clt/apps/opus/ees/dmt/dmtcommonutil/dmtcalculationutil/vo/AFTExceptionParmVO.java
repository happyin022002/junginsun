/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AFTExceptionParmVO.java
*@FileTitle : AFTExceptionParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.08 최성환 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AFTExceptionParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AFTExceptionParmVO> models = new ArrayList<AFTExceptionParmVO>();
	
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String dttCode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String locDiv = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AFTExceptionParmVO() {}

	public AFTExceptionParmVO(String ibflag, String pagerows, String dttCode, String bkgNo, String bkgNoSplit, String svrId, String cntrNo, String cnmvCycNo, String locDiv) {
		this.svrId = svrId;
		this.bkgNo = bkgNo;
		this.dttCode = dttCode;
		this.ibflag = ibflag;
		this.cnmvCycNo = cnmvCycNo;
		this.cntrNo = cntrNo;
		this.bkgNoSplit = bkgNoSplit;
		this.locDiv = locDiv;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dtt_code", getDttCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("loc_div", getLocDiv());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dtt_code", "dttCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("loc_div", "locDiv");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return dttCode
	 */
	public String getDttCode() {
		return this.dttCode;
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
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
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
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @return locDiv
	 */
	public String getLocDiv() {
		return this.locDiv;
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
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param dttCode
	 */
	public void setDttCode(String dttCode) {
		this.dttCode = dttCode;
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
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
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
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
	}
	
	/**
	 * Column Info
	 * @param locDiv
	 */
	public void setLocDiv(String locDiv) {
		this.locDiv = locDiv;
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
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDttCode(JSPUtil.getParameter(request, "dtt_code", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, "cnmv_cyc_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setLocDiv(JSPUtil.getParameter(request, "loc_div", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AFTExceptionParmVO[]
	 */
	public AFTExceptionParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AFTExceptionParmVO[]
	 */
	public AFTExceptionParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AFTExceptionParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] dttCode = (JSPUtil.getParameter(request, prefix	+ "dtt_code", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] locDiv = (JSPUtil.getParameter(request, prefix	+ "loc_div", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AFTExceptionParmVO();
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (dttCode[i] != null)
					model.setDttCode(dttCode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (locDiv[i] != null)
					model.setLocDiv(locDiv[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAFTExceptionParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AFTExceptionParmVO[]
	 */
	public AFTExceptionParmVO[] getAFTExceptionParmVOs(){
		AFTExceptionParmVO[] vos = (AFTExceptionParmVO[])models.toArray(new AFTExceptionParmVO[models.size()]);
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
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dttCode = this.dttCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locDiv = this.locDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
