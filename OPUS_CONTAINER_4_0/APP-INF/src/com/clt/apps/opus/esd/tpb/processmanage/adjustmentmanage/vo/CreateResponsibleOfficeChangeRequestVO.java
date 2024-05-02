/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CreateResponsibleOfficeChangeRequestVO.java
*@FileTitle : CreateResponsibleOfficeChangeRequestVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.10.01 최 선 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.processmanage.adjustmentmanage.vo;

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
 * @author 최 선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CreateResponsibleOfficeChangeRequestVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreateResponsibleOfficeChangeRequestVO> models = new ArrayList<CreateResponsibleOfficeChangeRequestVO>();
	
	/* Column Info */
	private String sRaRmk2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sN3ptyNo = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String sRaRmk1 = null;
	/* Column Info */
	private String sUserId = null;
	/* Column Info */
	private String sStlToCltCngOfcCd = null;
	/* Column Info */
	private String stlToCltCngOfcCd = null;
	/* Column Info */
	private String sFileNo = null;
	/* Column Info */
	private String sUserOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CreateResponsibleOfficeChangeRequestVO() {}

	public CreateResponsibleOfficeChangeRequestVO(String ibflag, String pagerows, String sN3ptyNo, String n3ptyNo, String sUserOfcCd, String sUserId, String sRaRmk1, String sStlToCltCngOfcCd, String stlToCltCngOfcCd, String sFileNo, String sRaRmk2) {
		this.sRaRmk2 = sRaRmk2;
		this.ibflag = ibflag;
		this.sN3ptyNo = sN3ptyNo;
		this.n3ptyNo = n3ptyNo;
		this.sRaRmk1 = sRaRmk1;
		this.sUserId = sUserId;
		this.sStlToCltCngOfcCd = sStlToCltCngOfcCd;
		this.stlToCltCngOfcCd = stlToCltCngOfcCd;
		this.sFileNo = sFileNo;
		this.sUserOfcCd = sUserOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_ra_rmk2", getSRaRmk2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("s_ra_rmk1", getSRaRmk1());
		this.hashColumns.put("s_user_id", getSUserId());
		this.hashColumns.put("s_stl_to_clt_cng_ofc_cd", getSStlToCltCngOfcCd());
		this.hashColumns.put("stl_to_clt_cng_ofc_cd", getStlToCltCngOfcCd());
		this.hashColumns.put("s_file_no", getSFileNo());
		this.hashColumns.put("s_user_ofc_cd", getSUserOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_ra_rmk2", "sRaRmk2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_n3pty_no", "sN3ptyNo");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("s_ra_rmk1", "sRaRmk1");
		this.hashFields.put("s_user_id", "sUserId");
		this.hashFields.put("s_stl_to_clt_cng_ofc_cd", "sStlToCltCngOfcCd");
		this.hashFields.put("stl_to_clt_cng_ofc_cd", "stlToCltCngOfcCd");
		this.hashFields.put("s_file_no", "sFileNo");
		this.hashFields.put("s_user_ofc_cd", "sUserOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sRaRmk2
	 */
	public String getSRaRmk2() {
		return this.sRaRmk2;
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
	 * @return sRaRmk1
	 */
	public String getSRaRmk1() {
		return this.sRaRmk1;
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
	 * @return sStlToCltCngOfcCd
	 */
	public String getSStlToCltCngOfcCd() {
		return this.sStlToCltCngOfcCd;
	}
	
	/**
	 * Column Info
	 * @return stlToCltCngOfcCd
	 */
	public String getStlToCltCngOfcCd() {
		return this.stlToCltCngOfcCd;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	

	/**
	 * Column Info
	 * @param sRaRmk2
	 */
	public void setSRaRmk2(String sRaRmk2) {
		this.sRaRmk2 = sRaRmk2;
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
	 * @param sRaRmk1
	 */
	public void setSRaRmk1(String sRaRmk1) {
		this.sRaRmk1 = sRaRmk1;
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
	 * @param sStlToCltCngOfcCd
	 */
	public void setSStlToCltCngOfcCd(String sStlToCltCngOfcCd) {
		this.sStlToCltCngOfcCd = sStlToCltCngOfcCd;
	}
	
	/**
	 * Column Info
	 * @param stlToCltCngOfcCd
	 */
	public void setStlToCltCngOfcCd(String stlToCltCngOfcCd) {
		this.stlToCltCngOfcCd = stlToCltCngOfcCd;
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
		setSRaRmk2(JSPUtil.getParameter(request, "s_ra_rmk2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSN3ptyNo(JSPUtil.getParameter(request, "s_n3pty_no", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setSRaRmk1(JSPUtil.getParameter(request, "s_ra_rmk1", ""));
		setSUserId(JSPUtil.getParameter(request, "s_user_id", ""));
		setSStlToCltCngOfcCd(JSPUtil.getParameter(request, "s_stl_to_clt_cng_ofc_cd", ""));
		setStlToCltCngOfcCd(JSPUtil.getParameter(request, "stl_to_clt_cng_ofc_cd", ""));
		setSFileNo(JSPUtil.getParameter(request, "s_file_no", ""));
		setSUserOfcCd(JSPUtil.getParameter(request, "s_user_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreateResponsibleOfficeChangeRequestVO[]
	 */
	public CreateResponsibleOfficeChangeRequestVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreateResponsibleOfficeChangeRequestVO[]
	 */
	public CreateResponsibleOfficeChangeRequestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreateResponsibleOfficeChangeRequestVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sRaRmk2 = (JSPUtil.getParameter(request, prefix	+ "s_ra_rmk2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] sRaRmk1 = (JSPUtil.getParameter(request, prefix	+ "s_ra_rmk1", length));
			String[] sUserId = (JSPUtil.getParameter(request, prefix	+ "s_user_id", length));
			String[] sStlToCltCngOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_stl_to_clt_cng_ofc_cd", length));
			String[] stlToCltCngOfcCd = (JSPUtil.getParameter(request, prefix	+ "stl_to_clt_cng_ofc_cd", length));
			String[] sFileNo = (JSPUtil.getParameter(request, prefix	+ "s_file_no", length));
			String[] sUserOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_user_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CreateResponsibleOfficeChangeRequestVO();
				if (sRaRmk2[i] != null)
					model.setSRaRmk2(sRaRmk2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sN3ptyNo[i] != null)
					model.setSN3ptyNo(sN3ptyNo[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (sRaRmk1[i] != null)
					model.setSRaRmk1(sRaRmk1[i]);
				if (sUserId[i] != null)
					model.setSUserId(sUserId[i]);
				if (sStlToCltCngOfcCd[i] != null)
					model.setSStlToCltCngOfcCd(sStlToCltCngOfcCd[i]);
				if (stlToCltCngOfcCd[i] != null)
					model.setStlToCltCngOfcCd(stlToCltCngOfcCd[i]);
				if (sFileNo[i] != null)
					model.setSFileNo(sFileNo[i]);
				if (sUserOfcCd[i] != null)
					model.setSUserOfcCd(sUserOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreateResponsibleOfficeChangeRequestVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreateResponsibleOfficeChangeRequestVO[]
	 */
	public CreateResponsibleOfficeChangeRequestVO[] getCreateResponsibleOfficeChangeRequestVOs(){
		CreateResponsibleOfficeChangeRequestVO[] vos = (CreateResponsibleOfficeChangeRequestVO[])models.toArray(new CreateResponsibleOfficeChangeRequestVO[models.size()]);
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
		this.sRaRmk2 = this.sRaRmk2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNo = this.sN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRaRmk1 = this.sRaRmk1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUserId = this.sUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sStlToCltCngOfcCd = this.sStlToCltCngOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlToCltCngOfcCd = this.stlToCltCngOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFileNo = this.sFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUserOfcCd = this.sUserOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
