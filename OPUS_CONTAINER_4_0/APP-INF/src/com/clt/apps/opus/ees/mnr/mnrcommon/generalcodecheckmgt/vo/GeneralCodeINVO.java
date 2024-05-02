/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeINVO.java
*@FileTitle : GeneralCodeINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.12.15 김완규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GeneralCodeINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GeneralCodeINVO> models = new ArrayList<GeneralCodeINVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String checkValue = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String tmpSeq = null;
	/* Column Info */
	private String checkType = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GeneralCodeINVO() {}

	public GeneralCodeINVO(String ibflag, String pagerows, String userOfcCd, String checkValue, String tmpSeq, String checkType, String eqKndCd) {
		this.userOfcCd = userOfcCd;
		this.checkValue = checkValue;
		this.ibflag = ibflag;
		this.eqKndCd = eqKndCd;
		this.tmpSeq = tmpSeq;
		this.checkType = checkType;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("check_value", getCheckValue());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("tmp_seq", getTmpSeq());
		this.hashColumns.put("check_type", getCheckType());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("check_value", "checkValue");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("tmp_seq", "tmpSeq");
		this.hashFields.put("check_type", "checkType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
	}
	
	/**
	 * Column Info
	 * @return checkValue
	 */
	public String getCheckValue() {
		return this.checkValue;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return tmpSeq
	 */
	public String getTmpSeq() {
		return this.tmpSeq;
	}
	
	/**
	 * Column Info
	 * @return checkType
	 */
	public String getCheckType() {
		return this.checkType;
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
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * Column Info
	 * @param checkValue
	 */
	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param tmpSeq
	 */
	public void setTmpSeq(String tmpSeq) {
		this.tmpSeq = tmpSeq;
	}
	
	/**
	 * Column Info
	 * @param checkType
	 */
	public void setCheckType(String checkType) {
		this.checkType = checkType;
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
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setCheckValue(JSPUtil.getParameter(request, "check_value", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setTmpSeq(JSPUtil.getParameter(request, "tmp_seq", ""));
		setCheckType(JSPUtil.getParameter(request, "check_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GeneralCodeINVO[]
	 */
	public GeneralCodeINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GeneralCodeINVO[]
	 */
	public GeneralCodeINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GeneralCodeINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] checkValue = (JSPUtil.getParameter(request, prefix	+ "check_value", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] tmpSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_seq", length));
			String[] checkType = (JSPUtil.getParameter(request, prefix	+ "check_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GeneralCodeINVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (checkValue[i] != null)
					model.setCheckValue(checkValue[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (tmpSeq[i] != null)
					model.setTmpSeq(tmpSeq[i]);
				if (checkType[i] != null)
					model.setCheckType(checkType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGeneralCodeINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GeneralCodeINVO[]
	 */
	public GeneralCodeINVO[] getGeneralCodeINVOs(){
		GeneralCodeINVO[] vos = (GeneralCodeINVO[])models.toArray(new GeneralCodeINVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkValue = this.checkValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpSeq = this.tmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkType = this.checkType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
