/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomEqCompCdVO.java
*@FileTitle : CustomEqCompCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.07.22 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomEqCompCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomEqCompCdVO> models = new ArrayList<CustomEqCompCdVO>();
	
	/* Column Info */
	private String eqCmpoNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fmRltCd = null;
	/* Column Info */
	private String eqCmpoCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomEqCompCdVO() {}

	public CustomEqCompCdVO(String ibflag, String pagerows, String fmRltCd, String eqCmpoCd, String eqCmpoNm) {
		this.eqCmpoNm = eqCmpoNm;
		this.ibflag = ibflag;
		this.fmRltCd = fmRltCd;
		this.eqCmpoCd = eqCmpoCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eq_cmpo_nm", getEqCmpoNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm_rlt_cd", getFmRltCd());
		this.hashColumns.put("eq_cmpo_cd", getEqCmpoCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eq_cmpo_nm", "eqCmpoNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm_rlt_cd", "fmRltCd");
		this.hashFields.put("eq_cmpo_cd", "eqCmpoCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eqCmpoNm
	 */
	public String getEqCmpoNm() {
		return this.eqCmpoNm;
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
	 * @return fmRltCd
	 */
	public String getFmRltCd() {
		return this.fmRltCd;
	}
	
	/**
	 * Column Info
	 * @return eqCmpoCd
	 */
	public String getEqCmpoCd() {
		return this.eqCmpoCd;
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
	 * @param eqCmpoNm
	 */
	public void setEqCmpoNm(String eqCmpoNm) {
		this.eqCmpoNm = eqCmpoNm;
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
	 * @param fmRltCd
	 */
	public void setFmRltCd(String fmRltCd) {
		this.fmRltCd = fmRltCd;
	}
	
	/**
	 * Column Info
	 * @param eqCmpoCd
	 */
	public void setEqCmpoCd(String eqCmpoCd) {
		this.eqCmpoCd = eqCmpoCd;
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
		setEqCmpoNm(JSPUtil.getParameter(request, "eq_cmpo_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFmRltCd(JSPUtil.getParameter(request, "fm_rlt_cd", ""));
		setEqCmpoCd(JSPUtil.getParameter(request, "eq_cmpo_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomEqCompCdVO[]
	 */
	public CustomEqCompCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomEqCompCdVO[]
	 */
	public CustomEqCompCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomEqCompCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eqCmpoNm = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fmRltCd = (JSPUtil.getParameter(request, prefix	+ "fm_rlt_cd", length));
			String[] eqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomEqCompCdVO();
				if (eqCmpoNm[i] != null)
					model.setEqCmpoNm(eqCmpoNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fmRltCd[i] != null)
					model.setFmRltCd(fmRltCd[i]);
				if (eqCmpoCd[i] != null)
					model.setEqCmpoCd(eqCmpoCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomEqCompCdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomEqCompCdVO[]
	 */
	public CustomEqCompCdVO[] getCustomEqCompCdVOs(){
		CustomEqCompCdVO[] vos = (CustomEqCompCdVO[])models.toArray(new CustomEqCompCdVO[models.size()]);
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
		this.eqCmpoNm = this.eqCmpoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRltCd = this.fmRltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCd = this.eqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
