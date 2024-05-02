/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0085ConditionVO.java
*@FileTitle : EesEqr0085ConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.07 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo;

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
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0085ConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0085ConditionVO> models = new ArrayList<EesEqr0085ConditionVO>();
	
	/* Column Info */
	private String yyyyww = null;
	/* Column Info */
	private String searchvalue = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tpsz = null;
	/* Column Info */
	private String searchtype = null;
	/* Column Info */
	private String loctype = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String tpsztype = null;
	/* Column Info */
	private String loc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0085ConditionVO() {}

	public EesEqr0085ConditionVO(String ibflag, String pagerows, String searchtype, String searchvalue, String yyyyww, String seq, String loc, String loctype, String tpsz, String tpsztype) {
		this.yyyyww = yyyyww;
		this.searchvalue = searchvalue;
		this.ibflag = ibflag;
		this.tpsz = tpsz;
		this.searchtype = searchtype;
		this.loctype = loctype;
		this.seq = seq;
		this.tpsztype = tpsztype;
		this.loc = loc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yyyyww", getYyyyww());
		this.hashColumns.put("searchvalue", getSearchvalue());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tpsz", getTpsz());
		this.hashColumns.put("searchtype", getSearchtype());
		this.hashColumns.put("loctype", getLoctype());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("tpsztype", getTpsztype());
		this.hashColumns.put("loc", getLoc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("searchvalue", "searchvalue");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("searchtype", "searchtype");
		this.hashFields.put("loctype", "loctype");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("tpsztype", "tpsztype");
		this.hashFields.put("loc", "loc");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return yyyyww
	 */
	public String getYyyyww() {
		return this.yyyyww;
	}
	
	/**
	 * Column Info
	 * @return searchvalue
	 */
	public String getSearchvalue() {
		return this.searchvalue;
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
	 * @return tpsz
	 */
	public String getTpsz() {
		return this.tpsz;
	}
	
	/**
	 * Column Info
	 * @return searchtype
	 */
	public String getSearchtype() {
		return this.searchtype;
	}
	
	/**
	 * Column Info
	 * @return loctype
	 */
	public String getLoctype() {
		return this.loctype;
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
	 * @return tpsztype
	 */
	public String getTpsztype() {
		return this.tpsztype;
	}
	
	/**
	 * Column Info
	 * @return loc
	 */
	public String getLoc() {
		return this.loc;
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
	 * @param yyyyww
	 */
	public void setYyyyww(String yyyyww) {
		this.yyyyww = yyyyww;
	}
	
	/**
	 * Column Info
	 * @param searchvalue
	 */
	public void setSearchvalue(String searchvalue) {
		this.searchvalue = searchvalue;
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
	 * @param tpsz
	 */
	public void setTpsz(String tpsz) {
		this.tpsz = tpsz;
	}
	
	/**
	 * Column Info
	 * @param searchtype
	 */
	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}
	
	/**
	 * Column Info
	 * @param loctype
	 */
	public void setLoctype(String loctype) {
		this.loctype = loctype;
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
	 * @param tpsztype
	 */
	public void setTpsztype(String tpsztype) {
		this.tpsztype = tpsztype;
	}
	
	/**
	 * Column Info
	 * @param loc
	 */
	public void setLoc(String loc) {
		this.loc = loc;
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
		setYyyyww(JSPUtil.getParameter(request, "yyyyww", ""));
		setSearchvalue(JSPUtil.getParameter(request, "searchValue", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTpsz(JSPUtil.getParameter(request, "TPSZ", ""));
		setSearchtype(JSPUtil.getParameter(request, "searchType", ""));
		setLoctype(JSPUtil.getParameter(request, "loctype", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setTpsztype(JSPUtil.getParameter(request, "TPSZtype", ""));
		setLoc(JSPUtil.getParameter(request, "LOC", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0085ConditionVO[]
	 */
	public EesEqr0085ConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0085ConditionVO[]
	 */
	public EesEqr0085ConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0085ConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] yyyyww = (JSPUtil.getParameter(request, prefix	+ "yyyyww", length));
			String[] searchvalue = (JSPUtil.getParameter(request, prefix	+ "searchValue", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tpsz = (JSPUtil.getParameter(request, prefix	+ "TPSZ", length));
			String[] searchtype = (JSPUtil.getParameter(request, prefix	+ "searchType", length));
			String[] loctype = (JSPUtil.getParameter(request, prefix	+ "loctype", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] tpsztype = (JSPUtil.getParameter(request, prefix	+ "TPSZtype", length));
			String[] loc = (JSPUtil.getParameter(request, prefix	+ "LOC", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0085ConditionVO();
				if (yyyyww[i] != null)
					model.setYyyyww(yyyyww[i]);
				if (searchvalue[i] != null)
					model.setSearchvalue(searchvalue[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tpsz[i] != null)
					model.setTpsz(tpsz[i]);
				if (searchtype[i] != null)
					model.setSearchtype(searchtype[i]);
				if (loctype[i] != null)
					model.setLoctype(loctype[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (tpsztype[i] != null)
					model.setTpsztype(tpsztype[i]);
				if (loc[i] != null)
					model.setLoc(loc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0085ConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0085ConditionVO[]
	 */
	public EesEqr0085ConditionVO[] getEesEqr0085ConditionVOs(){
		EesEqr0085ConditionVO[] vos = (EesEqr0085ConditionVO[])models.toArray(new EesEqr0085ConditionVO[models.size()]);
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
		this.yyyyww = this.yyyyww .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchvalue = this.searchvalue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz = this.tpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchtype = this.searchtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loctype = this.loctype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsztype = this.tpsztype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loc = this.loc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
