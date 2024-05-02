/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BeforeExceptionDeleteVO.java
*@FileTitle : BeforeExceptionDeleteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.12  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BeforeExceptionDeleteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BeforeExceptionDeleteVO> models = new ArrayList<BeforeExceptionDeleteVO>();
	
	/* Column Info */
	private String delRfaExptMapgSeq = null;
	/* Column Info */
	private String delRfaExptVerSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String delRfaExptDarNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BeforeExceptionDeleteVO() {}

	public BeforeExceptionDeleteVO(String ibflag, String pagerows, String delRfaExptDarNo, String delRfaExptMapgSeq, String delRfaExptVerSeq) {
		this.delRfaExptMapgSeq = delRfaExptMapgSeq;
		this.delRfaExptVerSeq = delRfaExptVerSeq;
		this.ibflag = ibflag;
		this.delRfaExptDarNo = delRfaExptDarNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("del_rfa_expt_mapg_seq", getDelRfaExptMapgSeq());
		this.hashColumns.put("del_rfa_expt_ver_seq", getDelRfaExptVerSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("del_rfa_expt_dar_no", getDelRfaExptDarNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("del_rfa_expt_mapg_seq", "delRfaExptMapgSeq");
		this.hashFields.put("del_rfa_expt_ver_seq", "delRfaExptVerSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("del_rfa_expt_dar_no", "delRfaExptDarNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return delRfaExptMapgSeq
	 */
	public String getDelRfaExptMapgSeq() {
		return this.delRfaExptMapgSeq;
	}
	
	/**
	 * Column Info
	 * @return delRfaExptVerSeq
	 */
	public String getDelRfaExptVerSeq() {
		return this.delRfaExptVerSeq;
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
	 * @return delRfaExptDarNo
	 */
	public String getDelRfaExptDarNo() {
		return this.delRfaExptDarNo;
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
	 * @param delRfaExptMapgSeq
	 */
	public void setDelRfaExptMapgSeq(String delRfaExptMapgSeq) {
		this.delRfaExptMapgSeq = delRfaExptMapgSeq;
	}
	
	/**
	 * Column Info
	 * @param delRfaExptVerSeq
	 */
	public void setDelRfaExptVerSeq(String delRfaExptVerSeq) {
		this.delRfaExptVerSeq = delRfaExptVerSeq;
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
	 * @param delRfaExptDarNo
	 */
	public void setDelRfaExptDarNo(String delRfaExptDarNo) {
		this.delRfaExptDarNo = delRfaExptDarNo;
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
		setDelRfaExptMapgSeq(JSPUtil.getParameter(request, "del_rfa_expt_mapg_seq", ""));
		setDelRfaExptVerSeq(JSPUtil.getParameter(request, "del_rfa_expt_ver_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDelRfaExptDarNo(JSPUtil.getParameter(request, "del_rfa_expt_dar_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BeforeExceptionDeleteVO[]
	 */
	public BeforeExceptionDeleteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BeforeExceptionDeleteVO[]
	 */
	public BeforeExceptionDeleteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BeforeExceptionDeleteVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] delRfaExptMapgSeq = (JSPUtil.getParameter(request, prefix	+ "del_rfa_expt_mapg_seq", length));
			String[] delRfaExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "del_rfa_expt_ver_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] delRfaExptDarNo = (JSPUtil.getParameter(request, prefix	+ "del_rfa_expt_dar_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BeforeExceptionDeleteVO();
				if (delRfaExptMapgSeq[i] != null)
					model.setDelRfaExptMapgSeq(delRfaExptMapgSeq[i]);
				if (delRfaExptVerSeq[i] != null)
					model.setDelRfaExptVerSeq(delRfaExptVerSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (delRfaExptDarNo[i] != null)
					model.setDelRfaExptDarNo(delRfaExptDarNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBeforeExceptionDeleteVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BeforeExceptionDeleteVO[]
	 */
	public BeforeExceptionDeleteVO[] getBeforeExceptionDeleteVOs(){
		BeforeExceptionDeleteVO[] vos = (BeforeExceptionDeleteVO[])models.toArray(new BeforeExceptionDeleteVO[models.size()]);
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
		this.delRfaExptMapgSeq = this.delRfaExptMapgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delRfaExptVerSeq = this.delRfaExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delRfaExptDarNo = this.delRfaExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
