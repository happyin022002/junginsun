/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : checkVVDCNTRVO.java
*@FileTitle : checkVVDCNTRVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.06.29 김상수
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class checkVVDCNTRVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<checkVVDCNTRVO> models = new ArrayList<checkVVDCNTRVO>();

	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pVvdcd = null;
	/* Column Info */
	private String pYardcd = null;
	/* Column Info */
	private String pVvdType = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public checkVVDCNTRVO() {}

	public checkVVDCNTRVO(String ibflag, String pagerows, String bkgNo, String pVvdType, String pYardcd, String pVvdcd) {
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.pVvdcd = pVvdcd;
		this.pYardcd = pYardcd;
		this.pVvdType = pVvdType;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_vvdcd", getPVvdcd());
		this.hashColumns.put("p_yardcd", getPYardcd());
		this.hashColumns.put("p_vvd_type", getPVvdType());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_vvdcd", "pVvdcd");
		this.hashFields.put("p_yardcd", "pYardcd");
		this.hashFields.put("p_vvd_type", "pVvdType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return pVvdcd
	 */
	public String getPVvdcd() {
		return this.pVvdcd;
	}

	/**
	 * Column Info
	 * @return pYardcd
	 */
	public String getPYardcd() {
		return this.pYardcd;
	}

	/**
	 * Column Info
	 * @return pVvdType
	 */
	public String getPVvdType() {
		return this.pVvdType;
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
	 * @param pVvdcd
	 */
	public void setPVvdcd(String pVvdcd) {
		this.pVvdcd = pVvdcd;
	}

	/**
	 * Column Info
	 * @param pYardcd
	 */
	public void setPYardcd(String pYardcd) {
		this.pYardcd = pYardcd;
	}

	/**
	 * Column Info
	 * @param pVvdType
	 */
	public void setPVvdType(String pVvdType) {
		this.pVvdType = pVvdType;
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
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPVvdcd(JSPUtil.getParameter(request, "p_vvdcd", ""));
		setPYardcd(JSPUtil.getParameter(request, "p_yardcd", ""));
		setPVvdType(JSPUtil.getParameter(request, "p_vvd_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return checkVVDCNTRVO[]
	 */
	public checkVVDCNTRVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return checkVVDCNTRVO[]
	 */
	public checkVVDCNTRVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		checkVVDCNTRVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pVvdcd = (JSPUtil.getParameter(request, prefix	+ "p_vvdcd", length));
			String[] pYardcd = (JSPUtil.getParameter(request, prefix	+ "p_yardcd", length));
			String[] pVvdType = (JSPUtil.getParameter(request, prefix	+ "p_vvd_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new checkVVDCNTRVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pVvdcd[i] != null)
					model.setPVvdcd(pVvdcd[i]);
				if (pYardcd[i] != null)
					model.setPYardcd(pYardcd[i]);
				if (pVvdType[i] != null)
					model.setPVvdType(pVvdType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getcheckVVDCNTRVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return checkVVDCNTRVO[]
	 */
	public checkVVDCNTRVO[] getcheckVVDCNTRVOs(){
		checkVVDCNTRVO[] vos = (checkVVDCNTRVO[])models.toArray(new checkVVDCNTRVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVvdcd = this.pVvdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYardcd = this.pYardcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVvdType = this.pVvdType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
