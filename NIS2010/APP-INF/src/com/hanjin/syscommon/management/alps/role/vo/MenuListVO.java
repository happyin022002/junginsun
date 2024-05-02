/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MenuListVO.java
*@FileTitle : MenuListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.23  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.management.alps.role.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MenuListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MenuListVO> models = new ArrayList<MenuListVO>();
	
	/* Column Info */
	private String pgmLevel = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String subSysCd = null;
	/* Column Info */
	private String menuNm = null;
	/* Column Info */
	private String prntPgmNo = null;
	/* Column Info */
	private String pgmNo = null;
	/* Column Info */
	private String subMenuNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MenuListVO() {}

	public MenuListVO(String ibflag, String pagerows, String menuNm, String subMenuNm, String subSysCd, String pgmNo, String prntPgmNo, String pgmLevel) {
		this.pgmLevel = pgmLevel;
		this.ibflag = ibflag;
		this.subSysCd = subSysCd;
		this.menuNm = menuNm;
		this.prntPgmNo = prntPgmNo;
		this.pgmNo = pgmNo;
		this.subMenuNm = subMenuNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pgm_level", getPgmLevel());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sub_sys_cd", getSubSysCd());
		this.hashColumns.put("menu_nm", getMenuNm());
		this.hashColumns.put("prnt_pgm_no", getPrntPgmNo());
		this.hashColumns.put("pgm_no", getPgmNo());
		this.hashColumns.put("sub_menu_nm", getSubMenuNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pgm_level", "pgmLevel");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sub_sys_cd", "subSysCd");
		this.hashFields.put("menu_nm", "menuNm");
		this.hashFields.put("prnt_pgm_no", "prntPgmNo");
		this.hashFields.put("pgm_no", "pgmNo");
		this.hashFields.put("sub_menu_nm", "subMenuNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pgmLevel
	 */
	public String getPgmLevel() {
		return this.pgmLevel;
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
	 * @return subSysCd
	 */
	public String getSubSysCd() {
		return this.subSysCd;
	}
	
	/**
	 * Column Info
	 * @return menuNm
	 */
	public String getMenuNm() {
		return this.menuNm;
	}
	
	/**
	 * Column Info
	 * @return prntPgmNo
	 */
	public String getPrntPgmNo() {
		return this.prntPgmNo;
	}
	
	/**
	 * Column Info
	 * @return pgmNo
	 */
	public String getPgmNo() {
		return this.pgmNo;
	}
	
	/**
	 * Column Info
	 * @return subMenuNm
	 */
	public String getSubMenuNm() {
		return this.subMenuNm;
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
	 * @param pgmLevel
	 */
	public void setPgmLevel(String pgmLevel) {
		this.pgmLevel = pgmLevel;
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
	 * @param subSysCd
	 */
	public void setSubSysCd(String subSysCd) {
		this.subSysCd = subSysCd;
	}
	
	/**
	 * Column Info
	 * @param menuNm
	 */
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	
	/**
	 * Column Info
	 * @param prntPgmNo
	 */
	public void setPrntPgmNo(String prntPgmNo) {
		this.prntPgmNo = prntPgmNo;
	}
	
	/**
	 * Column Info
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}
	
	/**
	 * Column Info
	 * @param subMenuNm
	 */
	public void setSubMenuNm(String subMenuNm) {
		this.subMenuNm = subMenuNm;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPgmLevel(JSPUtil.getParameter(request, prefix + "pgm_level", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSubSysCd(JSPUtil.getParameter(request, prefix + "sub_sys_cd", ""));
		setMenuNm(JSPUtil.getParameter(request, prefix + "menu_nm", ""));
		setPrntPgmNo(JSPUtil.getParameter(request, prefix + "prnt_pgm_no", ""));
		setPgmNo(JSPUtil.getParameter(request, prefix + "pgm_no", ""));
		setSubMenuNm(JSPUtil.getParameter(request, prefix + "sub_menu_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MenuListVO[]
	 */
	public MenuListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MenuListVO[]
	 */
	public MenuListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MenuListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pgmLevel = (JSPUtil.getParameter(request, prefix	+ "pgm_level", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] subSysCd = (JSPUtil.getParameter(request, prefix	+ "sub_sys_cd", length));
			String[] menuNm = (JSPUtil.getParameter(request, prefix	+ "menu_nm", length));
			String[] prntPgmNo = (JSPUtil.getParameter(request, prefix	+ "prnt_pgm_no", length));
			String[] pgmNo = (JSPUtil.getParameter(request, prefix	+ "pgm_no", length));
			String[] subMenuNm = (JSPUtil.getParameter(request, prefix	+ "sub_menu_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MenuListVO();
				if (pgmLevel[i] != null)
					model.setPgmLevel(pgmLevel[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (subSysCd[i] != null)
					model.setSubSysCd(subSysCd[i]);
				if (menuNm[i] != null)
					model.setMenuNm(menuNm[i]);
				if (prntPgmNo[i] != null)
					model.setPrntPgmNo(prntPgmNo[i]);
				if (pgmNo[i] != null)
					model.setPgmNo(pgmNo[i]);
				if (subMenuNm[i] != null)
					model.setSubMenuNm(subMenuNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMenuListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MenuListVO[]
	 */
	public MenuListVO[] getMenuListVOs(){
		MenuListVO[] vos = (MenuListVO[])models.toArray(new MenuListVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.pgmLevel = this.pgmLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysCd = this.subSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.menuNm = this.menuNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntPgmNo = this.prntPgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNo = this.pgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subMenuNm = this.subMenuNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
