/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComboInitDataINVO.java
*@FileTitle : ComboInitDataINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2009.07.09 이주현 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

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
 * @author 이주현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComboInitDataINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComboInitDataINVO> models = new ArrayList<ComboInitDataINVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String searchinfo = null;
	/* Column Info */
	private String searchkey = null;
	/* Column Info */
	private String searchcon = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ComboInitDataINVO() {}

	public ComboInitDataINVO(String ibflag, String pagerows, String searchinfo, String searchkey, String searchcon) {
		this.ibflag = ibflag;
		this.searchinfo = searchinfo;
		this.searchkey = searchkey;
		this.searchcon = searchcon;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("searchinfo", getSearchinfo());
		this.hashColumns.put("searchkey", getSearchkey());
		this.hashColumns.put("searchcon", getSearchcon());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("searchinfo", "searchinfo");
		this.hashFields.put("searchkey", "searchkey");
		this.hashFields.put("searchcon", "searchcon");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return searchinfo
	 */
	public String getSearchinfo() {
		return this.searchinfo;
	}
	
	/**
	 * Column Info
	 * @return searchkey
	 */
	public String getSearchkey() {
		return this.searchkey;
	}
	
	/**
	 * Column Info
	 * @return searchcon
	 */
	public String getSearchcon() {
		return this.searchcon;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param searchinfo
	 */
	public void setSearchinfo(String searchinfo) {
		this.searchinfo = searchinfo;
	}
	
	/**
	 * Column Info
	 * @param searchkey
	 */
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}
	
	/**
	 * Column Info
	 * @param searchcon
	 */
	public void setSearchcon(String searchcon) {
		this.searchcon = searchcon;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSearchinfo(JSPUtil.getParameter(request, "searchinfo", ""));
		setSearchkey(JSPUtil.getParameter(request, "searchkey", ""));
		setSearchcon(JSPUtil.getParameter(request, "searchcon", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComboInitDataINVO[]
	 */
	public ComboInitDataINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComboInitDataINVO[]
	 */
	public ComboInitDataINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComboInitDataINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] searchinfo = (JSPUtil.getParameter(request, prefix	+ "searchinfo", length));
			String[] searchkey = (JSPUtil.getParameter(request, prefix	+ "searchkey", length));
			String[] searchcon = (JSPUtil.getParameter(request, prefix	+ "searchcon", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComboInitDataINVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (searchinfo[i] != null)
					model.setSearchinfo(searchinfo[i]);
				if (searchkey[i] != null)
					model.setSearchkey(searchkey[i]);
				if (searchcon[i] != null)
					model.setSearchcon(searchcon[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComboInitDataINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComboInitDataINVO[]
	 */
	public ComboInitDataINVO[] getComboInitDataINVOs(){
		ComboInitDataINVO[] vos = (ComboInitDataINVO[])models.toArray(new ComboInitDataINVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchinfo = this.searchinfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchkey = this.searchkey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchcon = this.searchcon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
