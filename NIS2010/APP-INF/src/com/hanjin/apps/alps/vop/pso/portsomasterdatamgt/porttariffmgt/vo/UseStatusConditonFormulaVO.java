/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UseStatusConditonFormulaVO.java
*@FileTitle : UseStatusConditonFormulaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.07.06 박명종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

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
 * @author 박명종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UseStatusConditonFormulaVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UseStatusConditonFormulaVO> models = new ArrayList<UseStatusConditonFormulaVO>();
	
	/* Column Info */
	private String id = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsr = null;
	/* Column Info */
	private String link = null;
	/* Column Info */
	private String descript = null;
	/* Column Info */
	private String creDate = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String updMnuNoCond = null;		//[2009.10.16:jmh]
	/* Column Info */
	private String updMnuNoFoml = null;		//[2009.10.16:jmh]
	/* Column Info */
	private String fomlSysDesc = null;		//[2010.01.13:jmh]

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UseStatusConditonFormulaVO() {}

	public UseStatusConditonFormulaVO(String ibflag, String pagerows, String id, String descript, String link, String creDate, String creUsr, String updMnuNoCond, String updMnuNoFoml, String fomlSysDesc) {
		this.id = id;
		this.ibflag = ibflag;
		this.creUsr = creUsr;
		this.link = link;
		this.descript = descript;
		this.creDate = creDate;
		this.pagerows = pagerows;
		this.updMnuNoCond = updMnuNoCond;
		this.updMnuNoFoml = updMnuNoFoml;
		this.fomlSysDesc = fomlSysDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("id", getId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr", getCreUsr());
		this.hashColumns.put("link", getLink());
		this.hashColumns.put("descript", getDescript());
		this.hashColumns.put("cre_date", getCreDate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("upd_mnu_no_cond", getUpdMnuNoCond());
		this.hashColumns.put("foml_sys_desc", getFomlSysDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("id", "id");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr", "creUsr");
		this.hashFields.put("link", "link");
		this.hashFields.put("descript", "descript");
		this.hashFields.put("cre_date", "creDate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("upd_mnu_no_cond", "updMnuNoCond");
		this.hashFields.put("upd_mnu_no_foml", "updMnuNoFoml");
		this.hashFields.put("foml_sys_desc", "fomlSysDesc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return id
	 */
	public String getId() {
		return this.id;
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
	 * @return creUsr
	 */
	public String getCreUsr() {
		return this.creUsr;
	}
	
	/**
	 * Column Info
	 * @return link
	 */
	public String getLink() {
		return this.link;
	}
	
	/**
	 * Column Info
	 * @return descript
	 */
	public String getDescript() {
		return this.descript;
	}
	
	/**
	 * Column Info
	 * @return creDate
	 */
	public String getCreDate() {
		return this.creDate;
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
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @param creUsr
	 */
	public void setCreUsr(String creUsr) {
		this.creUsr = creUsr;
	}
	
	/**
	 * Column Info
	 * @param link
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 * Column Info
	 * @param descript
	 */
	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	/**
	 * Column Info
	 * @param creDate
	 */
	public void setCreDate(String creDate) {
		this.creDate = creDate;
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
		setId(JSPUtil.getParameter(request, "id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsr(JSPUtil.getParameter(request, "cre_usr", ""));
		setLink(JSPUtil.getParameter(request, "link", ""));
		setDescript(JSPUtil.getParameter(request, "descript", ""));
		setCreDate(JSPUtil.getParameter(request, "cre_date", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUpdMnuNoCond(JSPUtil.getParameter(request, "upd_mnu_no_cond", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UseStatusConditonFormulaVO[]
	 */
	public UseStatusConditonFormulaVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UseStatusConditonFormulaVO[]
	 */
	public UseStatusConditonFormulaVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UseStatusConditonFormulaVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] id = (JSPUtil.getParameter(request, prefix	+ "id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] creUsr = (JSPUtil.getParameter(request, prefix	+ "cre_usr".trim(), length));
			String[] link = (JSPUtil.getParameter(request, prefix	+ "link".trim(), length));
			String[] descript = (JSPUtil.getParameter(request, prefix	+ "descript".trim(), length));
			String[] creDate = (JSPUtil.getParameter(request, prefix	+ "cre_date".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] updMnuNoCond = (JSPUtil.getParameter(request, prefix	+ "upd_mnu_no_cond".trim(), length));
			String[] updMnuNoFoml = (JSPUtil.getParameter(request, prefix	+ "upd_mnu_no_foml".trim(), length));
			String[] fomlSysDesc = (JSPUtil.getParameter(request, prefix	+ "foml_sys_desc".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new UseStatusConditonFormulaVO();
				if (id[i] != null)
					model.setId(id[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsr[i] != null)
					model.setCreUsr(creUsr[i]);
				if (link[i] != null)
					model.setLink(link[i]);
				if (descript[i] != null)
					model.setDescript(descript[i]);
				if (creDate[i] != null)
					model.setCreDate(creDate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (updMnuNoCond[i] != null)
					model.setUpdMnuNoCond(updMnuNoCond[i]);
				if (updMnuNoFoml[i] != null)
					model.setUpdMnuNoFoml(updMnuNoFoml[i]);
				if (fomlSysDesc[i] != null)
					model.setFomlSysDesc(fomlSysDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUseStatusConditonFormulaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UseStatusConditonFormulaVO[]
	 */
	public UseStatusConditonFormulaVO[] getUseStatusConditonFormulaVOs(){
		UseStatusConditonFormulaVO[] vos = (UseStatusConditonFormulaVO[])models.toArray(new UseStatusConditonFormulaVO[models.size()]);
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
		this.id = this.id .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsr = this.creUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.link = this.link .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.descript = this.descript .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDate = this.creDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updMnuNoCond = this.updMnuNoCond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updMnuNoFoml = this.updMnuNoFoml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlSysDesc = this.fomlSysDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	/**
	 * @return the updMnuNoCond
	 */
	public String getUpdMnuNoCond() {
		return updMnuNoCond;
	}

	/**
	 * @param updMnuNoCond the updMnuNoCond to set
	 */
	public void setUpdMnuNoCond(String updMnuNoCond) {
		this.updMnuNoCond = updMnuNoCond;
	}

	/**
	 * @return the updMnuNoFoml
	 */
	public String getUpdMnuNoFoml() {
		return updMnuNoFoml;
	}

	/**
	 * @param updMnuNoFoml the updMnuNoFoml to set
	 */
	public void setUpdMnuNoFoml(String updMnuNoFoml) {
		this.updMnuNoFoml = updMnuNoFoml;
	}

	/**
	 * @return the fomlSysDesc
	 */
	public String getFomlSysDesc() {
		return fomlSysDesc;
	}

	/**
	 * @param fomlSysDesc the fomlSysDesc to set
	 */
	public void setFomlSysDesc(String fomlSysDesc) {
		this.fomlSysDesc = fomlSysDesc;
	}
}
