/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : searchCodeRelationByDamageDataVO.java
*@FileTitle : searchCodeRelationByDamageDataVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.05.12 김완규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김완규
 * @since J2EE 1.5
 * @see ..
 */

public class CustomMnrCdRltByDmgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrCdRltByDmgVO> models = new ArrayList<CustomMnrCdRltByDmgVO>();
	
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String eqCmpoCd = null;
	/* Column Info */
	private String eqCedexRltTpCd = null;
	/* Column Info */
	private String g = null;
	/* Column Info */
	private String toRltCd = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String description = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fmRltCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrCdRltByDmgVO() {}

	/**
	 * CustomMnrCdRltByDmgVO 객체 생성
	 */
	public CustomMnrCdRltByDmgVO(String ibflag, String pagerows, String g, String code, String description, String eqCedexRltTpCd, String fmRltCd, String toRltCd, String creUsrId, String creDt, String updUsrId, String updDt, String eqCmpoCd) {
		this.ibflag = ibflag;
		this.eqCmpoCd = eqCmpoCd;
		this.eqCedexRltTpCd = eqCedexRltTpCd;
		this.g = g;
		this.toRltCd = toRltCd;
		this.code = code;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.creDt = creDt;
		this.description = description;
		this.creUsrId = creUsrId;
		this.fmRltCd = fmRltCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_cmpo_cd", getEqCmpoCd());
		this.hashColumns.put("eq_cedex_rlt_tp_cd", getEqCedexRltTpCd());
		this.hashColumns.put("g", getG());
		this.hashColumns.put("to_rlt_cd", getToRltCd());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("description", getDescription());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fm_rlt_cd", getFmRltCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_cmpo_cd", "eqCmpoCd");
		this.hashFields.put("eq_cedex_rlt_tp_cd", "eqCedexRltTpCd");
		this.hashFields.put("g", "g");
		this.hashFields.put("to_rlt_cd", "toRltCd");
		this.hashFields.put("code", "code");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("description", "description");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fm_rlt_cd", "fmRltCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getIbflag() {
		return this.ibflag;
	}
	public String getEqCmpoCd() {
		return this.eqCmpoCd;
	}
	public String getEqCedexRltTpCd() {
		return this.eqCedexRltTpCd;
	}
	public String getG() {
		return this.g;
	}
	public String getToRltCd() {
		return this.toRltCd;
	}
	public String getCode() {
		return this.code;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getUpdDt() {
		return this.updDt;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getDescription() {
		return this.description;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getFmRltCd() {
		return this.fmRltCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setEqCmpoCd(String eqCmpoCd) {
		this.eqCmpoCd = eqCmpoCd;
		//this.eqCmpoCd=true;
	}
	public void setEqCedexRltTpCd(String eqCedexRltTpCd) {
		this.eqCedexRltTpCd = eqCedexRltTpCd;
		//this.eqCedexRltTpCd=true;
	}
	public void setG(String g) {
		this.g = g;
		//this.g=true;
	}
	public void setToRltCd(String toRltCd) {
		this.toRltCd = toRltCd;
		//this.toRltCd=true;
	}
	public void setCode(String code) {
		this.code = code;
		//this.code=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setDescription(String description) {
		this.description = description;
		//this.description=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setFmRltCd(String fmRltCd) {
		this.fmRltCd = fmRltCd;
		//this.fmRltCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	/**
	 * request로 받아온 화면값을 해당 VO로 매핑한다.
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqCmpoCd(JSPUtil.getParameter(request, "eq_cmpo_cd", ""));
		setEqCedexRltTpCd(JSPUtil.getParameter(request, "eq_cedex_rlt_tp_cd", ""));
		setG(JSPUtil.getParameter(request, "g", ""));
		setToRltCd(JSPUtil.getParameter(request, "to_rlt_cd", ""));
		setCode(JSPUtil.getParameter(request, "code", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setDescription(JSPUtil.getParameter(request, "description", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setFmRltCd(JSPUtil.getParameter(request, "fm_rlt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}
	/**
	 * 그리드값을 통채로 받아와 해당 VO배열로 리턴 
	 * @return	CustomMnrCdRltByDmgVO[]   VO배열로    
	 */
	public CustomMnrCdRltByDmgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}
	/**
	 * 그리드값을 통채로 받아와 해당 VO배열로 리턴 
	 * @return	CustomMnrCdRltByDmgVO[]   VO배열로    
	 */
	public CustomMnrCdRltByDmgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrCdRltByDmgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] eqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd".trim(), length));
			String[] eqCedexRltTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_cedex_rlt_tp_cd".trim(), length));
			String[] g = (JSPUtil.getParameter(request, prefix	+ "g".trim(), length));
			String[] toRltCd = (JSPUtil.getParameter(request, prefix	+ "to_rlt_cd".trim(), length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] description = (JSPUtil.getParameter(request, prefix	+ "description".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] fmRltCd = (JSPUtil.getParameter(request, prefix	+ "fm_rlt_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrCdRltByDmgVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqCmpoCd[i] != null)
					model.setEqCmpoCd(eqCmpoCd[i]);
				if (eqCedexRltTpCd[i] != null)
					model.setEqCedexRltTpCd(eqCedexRltTpCd[i]);
				if (g[i] != null)
					model.setG(g[i]);
				if (toRltCd[i] != null)
					model.setToRltCd(toRltCd[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (description[i] != null)
					model.setDescription(description[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fmRltCd[i] != null)
					model.setFmRltCd(fmRltCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getsearchCodeRelationByDamageDataVOs();
	}
	/**
	 * getsearchCodeRelationByDamageDataVOs 
	 * @return	CustomMnrCdRltByDmgVO[]   VO배열로    
	 */
	public CustomMnrCdRltByDmgVO[] getsearchCodeRelationByDamageDataVOs(){
		CustomMnrCdRltByDmgVO[] vos = (CustomMnrCdRltByDmgVO[])models.toArray(new CustomMnrCdRltByDmgVO[models.size()]);
		return vos;
	}
	/**
	 * 전체 필드네임을 리턴  
	 * @return String
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCd = this.eqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCedexRltTpCd = this.eqCedexRltTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.g = this.g .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRltCd = this.toRltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.description = this.description .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRltCd = this.fmRltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
