/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GemMonClzVO.java
*@FileTitle : GemMonClzVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.28 최정미 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemcommon.gemclosingschedulemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 최정미
 * @since J2EE 1.5
 */

public class GemMonClzVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemMonClzVO> models = new ArrayList<GemMonClzVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String clzDivCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String clzFlg = null;
	/* Column Info */
	private String clzDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String glIfFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String clzYrmon = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GemMonClzVO() {}

	public GemMonClzVO(String ibflag, String pagerows, String clzYrmon, String clzDivCd, String clzDt, String clzFlg, String glIfFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.clzDivCd = clzDivCd;
		this.ibflag = ibflag;
		this.clzFlg = clzFlg;
		this.clzDt = clzDt;
		this.creDt = creDt;
		this.glIfFlg = glIfFlg;
		this.updUsrId = updUsrId;
		this.clzYrmon = clzYrmon;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("clz_div_cd", getClzDivCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("clz_flg", getClzFlg());
		this.hashColumns.put("clz_dt", getClzDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("gl_if_flg", getGlIfFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("clz_yrmon", getClzYrmon());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("clz_div_cd", "clzDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("clz_flg", "clzFlg");
		this.hashFields.put("clz_dt", "clzDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("gl_if_flg", "glIfFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("clz_yrmon", "clzYrmon");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getUpdDt() {
		return this.updDt;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getClzDivCd() {
		return this.clzDivCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getClzFlg() {
		return this.clzFlg;
	}
	public String getClzDt() {
		return this.clzDt;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getGlIfFlg() {
		return this.glIfFlg;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getClzYrmon() {
		return this.clzYrmon;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setClzDivCd(String clzDivCd) {
		this.clzDivCd = clzDivCd;
		//this.clzDivCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setClzFlg(String clzFlg) {
		this.clzFlg = clzFlg;
		//this.clzFlg=true;
	}
	public void setClzDt(String clzDt) {
		this.clzDt = clzDt;
		//this.clzDt=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setGlIfFlg(String glIfFlg) {
		this.glIfFlg = glIfFlg;
		//this.glIfFlg=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setClzYrmon(String clzYrmon) {
		this.clzYrmon = clzYrmon;
		//this.clzYrmon=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setClzDivCd(JSPUtil.getParameter(request, "clz_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setClzFlg(JSPUtil.getParameter(request, "clz_flg", ""));
		setClzDt(JSPUtil.getParameter(request, "clz_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setGlIfFlg(JSPUtil.getParameter(request, "gl_if_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setClzYrmon(JSPUtil.getParameter(request, "clz_yrmon", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public GemMonClzVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public GemMonClzVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemMonClzVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] clzDivCd = (JSPUtil.getParameter(request, prefix	+ "clz_div_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] clzFlg = (JSPUtil.getParameter(request, prefix	+ "clz_flg".trim(), length));
			String[] clzDt = (JSPUtil.getParameter(request, prefix	+ "clz_dt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] glIfFlg = (JSPUtil.getParameter(request, prefix	+ "gl_if_flg".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] clzYrmon = (JSPUtil.getParameter(request, prefix	+ "clz_yrmon".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new GemMonClzVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (clzDivCd[i] != null)
					model.setClzDivCd(clzDivCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (clzFlg[i] != null)
					model.setClzFlg(clzFlg[i]);
				if (clzDt[i] != null)
					model.setClzDt(clzDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (glIfFlg[i] != null)
					model.setGlIfFlg(glIfFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (clzYrmon[i] != null)
					model.setClzYrmon(clzYrmon[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getGemMonClzVOs();
	}

	public GemMonClzVO[] getGemMonClzVOs(){
		GemMonClzVO[] vos = (GemMonClzVO[])models.toArray(new GemMonClzVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clzDivCd = this.clzDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clzFlg = this.clzFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clzDt = this.clzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glIfFlg = this.glIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clzYrmon = this.clzYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
