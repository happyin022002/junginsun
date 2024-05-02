/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSpMnCpHdrVO.java
*@FileTitle : RsltPriSpMnCpHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.04 공백진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSpMnCpHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSpMnCpHdrVO> models = new ArrayList<RsltPriSpMnCpHdrVO>();
	
	/* Column Info */
	private String blplCnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String afilCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSpMnCpHdrVO() {}

	public RsltPriSpMnCpHdrVO(String ibflag, String pagerows, String afilCnt, String blplCnt) {
		this.blplCnt = blplCnt;
		this.ibflag = ibflag;
		this.afilCnt = afilCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("blpl_cnt", getBlplCnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("afil_cnt", getAfilCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("blpl_cnt", "blplCnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("afil_cnt", "afilCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blplCnt
	 */
	public String getBlplCnt() {
		return this.blplCnt;
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
	 * @return afilCnt
	 */
	public String getAfilCnt() {
		return this.afilCnt;
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
	 * @param blplCnt
	 */
	public void setBlplCnt(String blplCnt) {
		this.blplCnt = blplCnt;
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
	 * @param afilCnt
	 */
	public void setAfilCnt(String afilCnt) {
		this.afilCnt = afilCnt;
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
		setBlplCnt(JSPUtil.getParameter(request, "blpl_cnt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAfilCnt(JSPUtil.getParameter(request, "afil_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSpMnCpHdrVO[]
	 */
	public RsltPriSpMnCpHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSpMnCpHdrVO[]
	 */
	public RsltPriSpMnCpHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSpMnCpHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blplCnt = (JSPUtil.getParameter(request, prefix	+ "blpl_cnt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] afilCnt = (JSPUtil.getParameter(request, prefix	+ "afil_cnt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSpMnCpHdrVO();
				if (blplCnt[i] != null)
					model.setBlplCnt(blplCnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (afilCnt[i] != null)
					model.setAfilCnt(afilCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSpMnCpHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSpMnCpHdrVO[]
	 */
	public RsltPriSpMnCpHdrVO[] getRsltPriSpMnCpHdrVOs(){
		RsltPriSpMnCpHdrVO[] vos = (RsltPriSpMnCpHdrVO[])models.toArray(new RsltPriSpMnCpHdrVO[models.size()]);
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
		this.blplCnt = this.blplCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.afilCnt = this.afilCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
