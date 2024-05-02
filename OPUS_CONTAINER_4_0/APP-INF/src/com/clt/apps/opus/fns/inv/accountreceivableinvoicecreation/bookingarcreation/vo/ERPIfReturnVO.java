/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ERPIfReturnVO.java
*@FileTitle : ERPIfReturnVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.09.15 정휘택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ERPIfReturnVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ERPIfReturnVO> models = new ArrayList<ERPIfReturnVO>();
	
	/* Column Info */
	private String lifid = null;
	/* Column Info */
	private String ifNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ifResult = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String totalCount = null;
	/* Column Info */
	private String ifSer = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String errorMsg = null;
	/* Column Info */
	private String rowCount = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ERPIfReturnVO() {}

	public ERPIfReturnVO(String ibflag, String pagerows, String lifid, String seq, String totalCount, String rowCount, String flag, String ifNo, String ifSer, String ifResult, String errorMsg) {
		this.lifid = lifid;
		this.ifNo = ifNo;
		this.ibflag = ibflag;
		this.ifResult = ifResult;
		this.flag = flag;
		this.totalCount = totalCount;
		this.ifSer = ifSer;
		this.seq = seq;
		this.errorMsg = errorMsg;
		this.rowCount = rowCount;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lifid", getLifid());
		this.hashColumns.put("if_no", getIfNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("if_result", getIfResult());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("total_count", getTotalCount());
		this.hashColumns.put("if_ser", getIfSer());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("error_msg", getErrorMsg());
		this.hashColumns.put("row_count", getRowCount());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lifid", "lifid");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("if_result", "ifResult");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("total_count", "totalCount");
		this.hashFields.put("if_ser", "ifSer");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("error_msg", "errorMsg");
		this.hashFields.put("row_count", "rowCount");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lifid
	 */
	public String getLifid() {
		return this.lifid;
	}
	
	/**
	 * Column Info
	 * @return ifNo
	 */
	public String getIfNo() {
		return this.ifNo;
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
	 * @return ifResult
	 */
	public String getIfResult() {
		return this.ifResult;
	}
	
	/**
	 * Column Info
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
	}
	
	/**
	 * Column Info
	 * @return totalCount
	 */
	public String getTotalCount() {
		return this.totalCount;
	}
	
	/**
	 * Column Info
	 * @return ifSer
	 */
	public String getIfSer() {
		return this.ifSer;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return errorMsg
	 */
	public String getErrorMsg() {
		return this.errorMsg;
	}
	
	/**
	 * Column Info
	 * @return rowCount
	 */
	public String getRowCount() {
		return this.rowCount;
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
	 * @param lifid
	 */
	public void setLifid(String lifid) {
		this.lifid = lifid;
	}
	
	/**
	 * Column Info
	 * @param ifNo
	 */
	public void setIfNo(String ifNo) {
		this.ifNo = ifNo;
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
	 * @param ifResult
	 */
	public void setIfResult(String ifResult) {
		this.ifResult = ifResult;
	}
	
	/**
	 * Column Info
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	/**
	 * Column Info
	 * @param totalCount
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * Column Info
	 * @param ifSer
	 */
	public void setIfSer(String ifSer) {
		this.ifSer = ifSer;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param errorMsg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	/**
	 * Column Info
	 * @param rowCount
	 */
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
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
		setLifid(JSPUtil.getParameter(request, "lifid", ""));
		setIfNo(JSPUtil.getParameter(request, "if_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIfResult(JSPUtil.getParameter(request, "if_result", ""));
		setFlag(JSPUtil.getParameter(request, "flag", ""));
		setTotalCount(JSPUtil.getParameter(request, "total_count", ""));
		setIfSer(JSPUtil.getParameter(request, "if_ser", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setErrorMsg(JSPUtil.getParameter(request, "error_msg", ""));
		setRowCount(JSPUtil.getParameter(request, "row_count", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ERPIfReturnVO[]
	 */
	public ERPIfReturnVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ERPIfReturnVO[]
	 */
	public ERPIfReturnVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ERPIfReturnVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lifid = (JSPUtil.getParameter(request, prefix	+ "lifid", length));
			String[] ifNo = (JSPUtil.getParameter(request, prefix	+ "if_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ifResult = (JSPUtil.getParameter(request, prefix	+ "if_result", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] totalCount = (JSPUtil.getParameter(request, prefix	+ "total_count", length));
			String[] ifSer = (JSPUtil.getParameter(request, prefix	+ "if_ser", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] errorMsg = (JSPUtil.getParameter(request, prefix	+ "error_msg", length));
			String[] rowCount = (JSPUtil.getParameter(request, prefix	+ "row_count", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ERPIfReturnVO();
				if (lifid[i] != null)
					model.setLifid(lifid[i]);
				if (ifNo[i] != null)
					model.setIfNo(ifNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ifResult[i] != null)
					model.setIfResult(ifResult[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (totalCount[i] != null)
					model.setTotalCount(totalCount[i]);
				if (ifSer[i] != null)
					model.setIfSer(ifSer[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (errorMsg[i] != null)
					model.setErrorMsg(errorMsg[i]);
				if (rowCount[i] != null)
					model.setRowCount(rowCount[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getERPIfReturnVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ERPIfReturnVO[]
	 */
	public ERPIfReturnVO[] getERPIfReturnVOs(){
		ERPIfReturnVO[] vos = (ERPIfReturnVO[])models.toArray(new ERPIfReturnVO[models.size()]);
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
		this.lifid = this.lifid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo = this.ifNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifResult = this.ifResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCount = this.totalCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifSer = this.ifSer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errorMsg = this.errorMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCount = this.rowCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
