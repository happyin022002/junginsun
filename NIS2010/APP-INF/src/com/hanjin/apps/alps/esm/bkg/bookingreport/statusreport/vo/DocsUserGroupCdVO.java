/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DocsUserGroupCdVO.java
*@FileTitle : DocsUserGroupCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.09.11 김경섭 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocsUserGroupCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocsUserGroupCdVO> models = new ArrayList<DocsUserGroupCdVO>();
	
	/* Column Info */
	private String srcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String beforeUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String changeUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String srKndCd = null;
	/* Column Info */
	private String rowsPerPage = null;
	/* Column Info */
	private String currPage = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String totalCnt = null;
	/* Column Info */
	private String srNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocsUserGroupCdVO() {}

	public DocsUserGroupCdVO(String ibflag, String pagerows, String changeUsrId, String usrId, String srcCd, String srNo, String bkgNo, String beforeUsrId, String srKndCd, String totalCnt, String rowsPerPage, String currPage, String rnum) {
		this.srcCd = srcCd;
		this.pagerows = pagerows;
		this.beforeUsrId = beforeUsrId;
		this.ibflag = ibflag;
		this.changeUsrId = changeUsrId;
		this.bkgNo = bkgNo;
		this.srKndCd = srKndCd;
		this.rowsPerPage = rowsPerPage;
		this.currPage = currPage;
		this.usrId = usrId;
		this.rnum = rnum;
		this.totalCnt = totalCnt;
		this.srNo = srNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("src_cd", getSrcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("before_usr_id", getBeforeUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("change_usr_id", getChangeUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sr_knd_cd", getSrKndCd());
		this.hashColumns.put("rows_per_page", getRowsPerPage());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("total_cnt", getTotalCnt());
		this.hashColumns.put("sr_no", getSrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("src_cd", "srcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("before_usr_id", "beforeUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("change_usr_id", "changeUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sr_knd_cd", "srKndCd");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("total_cnt", "totalCnt");
		this.hashFields.put("sr_no", "srNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return srcCd
	 */
	public String getSrcCd() {
		return this.srcCd;
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
	 * @return beforeUsrId
	 */
	public String getBeforeUsrId() {
		return this.beforeUsrId;
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
	 * @return changeUsrId
	 */
	public String getChangeUsrId() {
		return this.changeUsrId;
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
	 * @return srKndCd
	 */
	public String getSrKndCd() {
		return this.srKndCd;
	}
	
	/**
	 * Column Info
	 * @return rowsPerPage
	 */
	public String getRowsPerPage() {
		return this.rowsPerPage;
	}
	
	/**
	 * Column Info
	 * @return currPage
	 */
	public String getCurrPage() {
		return this.currPage;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
	}
	
	/**
	 * Column Info
	 * @return totalCnt
	 */
	public String getTotalCnt() {
		return this.totalCnt;
	}
	
	/**
	 * Column Info
	 * @return srNo
	 */
	public String getSrNo() {
		return this.srNo;
	}
	

	/**
	 * Column Info
	 * @param srcCd
	 */
	public void setSrcCd(String srcCd) {
		this.srcCd = srcCd;
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
	 * @param beforeUsrId
	 */
	public void setBeforeUsrId(String beforeUsrId) {
		this.beforeUsrId = beforeUsrId;
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
	 * @param changeUsrId
	 */
	public void setChangeUsrId(String changeUsrId) {
		this.changeUsrId = changeUsrId;
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
	 * @param srKndCd
	 */
	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
	}
	
	/**
	 * Column Info
	 * @param rowsPerPage
	 */
	public void setRowsPerPage(String rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	
	/**
	 * Column Info
	 * @param currPage
	 */
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * Column Info
	 * @param totalCnt
	 */
	public void setTotalCnt(String totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	/**
	 * Column Info
	 * @param srNo
	 */
	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSrcCd(JSPUtil.getParameter(request, "src_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBeforeUsrId(JSPUtil.getParameter(request, "before_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setChangeUsrId(JSPUtil.getParameter(request, "change_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSrKndCd(JSPUtil.getParameter(request, "sr_knd_cd", ""));
		setRowsPerPage(JSPUtil.getParameter(request, "rows_per_page", ""));
		setCurrPage(JSPUtil.getParameter(request, "curr_page", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setRnum(JSPUtil.getParameter(request, "rnum", ""));
		setTotalCnt(JSPUtil.getParameter(request, "total_cnt", ""));
		setSrNo(JSPUtil.getParameter(request, "sr_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocsUserGroupCdVO[]
	 */
	public DocsUserGroupCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocsUserGroupCdVO[]
	 */
	public DocsUserGroupCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocsUserGroupCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] srcCd = (JSPUtil.getParameter(request, prefix	+ "src_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] beforeUsrId = (JSPUtil.getParameter(request, prefix	+ "before_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] changeUsrId = (JSPUtil.getParameter(request, prefix	+ "change_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] srKndCd = (JSPUtil.getParameter(request, prefix	+ "sr_knd_cd", length));
			String[] rowsPerPage = (JSPUtil.getParameter(request, prefix	+ "rows_per_page", length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] totalCnt = (JSPUtil.getParameter(request, prefix	+ "total_cnt", length));
			String[] srNo = (JSPUtil.getParameter(request, prefix	+ "sr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocsUserGroupCdVO();
				if (srcCd[i] != null)
					model.setSrcCd(srcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (beforeUsrId[i] != null)
					model.setBeforeUsrId(beforeUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (changeUsrId[i] != null)
					model.setChangeUsrId(changeUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (srKndCd[i] != null)
					model.setSrKndCd(srKndCd[i]);
				if (rowsPerPage[i] != null)
					model.setRowsPerPage(rowsPerPage[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (totalCnt[i] != null)
					model.setTotalCnt(totalCnt[i]);
				if (srNo[i] != null)
					model.setSrNo(srNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocsUserGroupCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocsUserGroupCdVO[]
	 */
	public DocsUserGroupCdVO[] getDocsUserGroupCdVOs(){
		DocsUserGroupCdVO[] vos = (DocsUserGroupCdVO[])models.toArray(new DocsUserGroupCdVO[models.size()]);
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
		this.srcCd = this.srcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beforeUsrId = this.beforeUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.changeUsrId = this.changeUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srKndCd = this.srKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage = this.rowsPerPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt = this.totalCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srNo = this.srNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
