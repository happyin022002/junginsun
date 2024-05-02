/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OfficeCodeINVOVO.java
*@FileTitle : OfficeCodeINVOVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.05.26 정영훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo;

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
 * @author 정영훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OfficeCodeINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OfficeCodeINVO> models = new ArrayList<OfficeCodeINVO>();
	
	/* Column Info */
	private String ofc_cd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ofclevelcd = null;
	/* Column Info */
	private String boolhoofc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	/**
	 * 생성자
	 */
	public OfficeCodeINVO() {}
	/**
	 * 생성자
	 * @param ibflag
	 * @param pagerows
	 * @param ofcCd
	 * @param ofclevelcd
	 * @param boolhoofc
	 */
	public OfficeCodeINVO(String ibflag, String pagerows, String ofcCd, String ofclevelcd, String boolhoofc) {
		this.ofc_cd = ofcCd;
		this.ibflag = ibflag;
		this.ofclevelcd = ofclevelcd;
		this.boolhoofc = boolhoofc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ofclevelcd", getOfclevelcd());
		this.hashColumns.put("boolhoofc", getBoolhoofc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofc_cd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ofclevelcd", "ofclevelcd");
		this.hashFields.put("boolhoofc", "boolhoofc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofc_cd;
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
	 * @return ofclevelcd
	 */
	public String getOfclevelcd() {
		return this.ofclevelcd;
	}
	
	/**
	 * Column Info
	 * @return boolhoofc
	 */
	public String getBoolhoofc() {
		return this.boolhoofc;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofc_cd = ofcCd;
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
	 * @param ofclevelcd
	 */
	public void setOfclevelcd(String ofclevelcd) {
		this.ofclevelcd = ofclevelcd;
	}
	
	/**
	 * Column Info
	 * @param boolhoofc
	 */
	public void setBoolhoofc(String boolhoofc) {
		this.boolhoofc = boolhoofc;
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
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOfclevelcd(JSPUtil.getParameter(request, "ofclevelcd", ""));
		setBoolhoofc(JSPUtil.getParameter(request, "boolhoofc", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfficeCodeINVO[]
	 */
	public OfficeCodeINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfficeCodeINVO[]
	 */
	public OfficeCodeINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OfficeCodeINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ofclevelcd = (JSPUtil.getParameter(request, prefix	+ "ofclevelcd".trim(), length));
			String[] boolhoofc = (JSPUtil.getParameter(request, prefix	+ "boolhoofc".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new OfficeCodeINVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ofclevelcd[i] != null)
					model.setOfclevelcd(ofclevelcd[i]);
				if (boolhoofc[i] != null)
					model.setBoolhoofc(boolhoofc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOfficeCodeINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OfficeCodeINVOVO[]
	 */
	public OfficeCodeINVO[] getOfficeCodeINVOs(){
		OfficeCodeINVO[] vos = (OfficeCodeINVO[])models.toArray(new OfficeCodeINVO[models.size()]);
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
		this.ofc_cd = this.ofc_cd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofclevelcd = this.ofclevelcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boolhoofc = this.boolhoofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
