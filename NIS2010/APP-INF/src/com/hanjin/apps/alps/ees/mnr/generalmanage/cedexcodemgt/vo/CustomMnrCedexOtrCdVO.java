/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MnrCedexOtrCdVO.java
*@FileTitle : MnrCedexOtrCdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.11 박명신 
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
 * @author 박명신
 * @since J2EE 1.5
 * @see ..
 */

public class CustomMnrCedexOtrCdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrCedexOtrCdVO> models = new ArrayList<CustomMnrCedexOtrCdVO>();
	
	/* Column Inpo */
	private String updDt = null;
	/* Column Inpo */
	private String creUsrId = null;
	/* Status */
	private String ibflag = null;
	/* Column Inpo */
	private String eqCedexOtrCdDesc = null;
	/* Column Inpo */
	private String eqCedexOtrCdNm = null;
	/* Column Inpo */
	private String creDt = null;
	/* Column Inpo */
	private String eqCedexOtrNumCd = null;
	/* Column Inpo */
	private String eqKndCd = null;
	/* Column Inpo */
	private String updUsrId = null;
	/* Column Inpo */
	private String eqCedexOtrTpCd = null;
	/* Column Inpo */
	private String eqCedexOtrCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrCedexOtrCdVO() {}

	/**
	 * CustomMnrCedexOtrCdVO 객체를 생성   
	 */
	public CustomMnrCedexOtrCdVO(String ibflag, String pagerows, String eqCedexOtrTpCd, String eqCedexOtrCd, String eqCedexOtrNumCd, String eqCedexOtrCdNm, String eqCedexOtrCdDesc, String eqKndCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.eqCedexOtrCdDesc = eqCedexOtrCdDesc;
		this.eqCedexOtrCdNm = eqCedexOtrCdNm;
		this.creDt = creDt;
		this.eqCedexOtrNumCd = eqCedexOtrNumCd;
		this.eqKndCd = eqKndCd;
		this.updUsrId = updUsrId;
		this.eqCedexOtrTpCd = eqCedexOtrTpCd;
		this.eqCedexOtrCd = eqCedexOtrCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_cedex_otr_cd_desc", getEqCedexOtrCdDesc());
		this.hashColumns.put("eq_cedex_otr_cd_nm", getEqCedexOtrCdNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eq_cedex_otr_num_cd", getEqCedexOtrNumCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eq_cedex_otr_tp_cd", getEqCedexOtrTpCd());
		this.hashColumns.put("eq_cedex_otr_cd", getEqCedexOtrCd());
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
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_cedex_otr_cd_desc", "eqCedexOtrCdDesc");
		this.hashFields.put("eq_cedex_otr_cd_nm", "eqCedexOtrCdNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eq_cedex_otr_num_cd", "eqCedexOtrNumCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eq_cedex_otr_tp_cd", "eqCedexOtrTpCd");
		this.hashFields.put("eq_cedex_otr_cd", "eqCedexOtrCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getUpdDt() {
		return this.updDt;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getEqCedexOtrCdDesc() {
		return this.eqCedexOtrCdDesc;
	}
	public String getEqCedexOtrCdNm() {
		return this.eqCedexOtrCdNm;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getEqCedexOtrNumCd() {
		return this.eqCedexOtrNumCd;
	}
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getEqCedexOtrTpCd() {
		return this.eqCedexOtrTpCd;
	}
	public String getEqCedexOtrCd() {
		return this.eqCedexOtrCd;
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
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setEqCedexOtrCdDesc(String eqCedexOtrCdDesc) {
		this.eqCedexOtrCdDesc = eqCedexOtrCdDesc;
		//this.eqCedexOtrCdDesc=true;
	}
	public void setEqCedexOtrCdNm(String eqCedexOtrCdNm) {
		this.eqCedexOtrCdNm = eqCedexOtrCdNm;
		//this.eqCedexOtrCdNm=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setEqCedexOtrNumCd(String eqCedexOtrNumCd) {
		this.eqCedexOtrNumCd = eqCedexOtrNumCd;
		//this.eqCedexOtrNumCd=true;
	}
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
		//this.eqKndCd=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setEqCedexOtrTpCd(String eqCedexOtrTpCd) {
		this.eqCedexOtrTpCd = eqCedexOtrTpCd;
		//this.eqCedexOtrTpCd=true;
	}
	public void setEqCedexOtrCd(String eqCedexOtrCd) {
		this.eqCedexOtrCd = eqCedexOtrCd;
		//this.eqCedexOtrCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	
	/**
	 * request로 받아온 화면값을 해당 VO로 매핑한다.
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqCedexOtrCdDesc(JSPUtil.getParameter(request, "eq_cedex_otr_cd_desc", ""));
		setEqCedexOtrCdNm(JSPUtil.getParameter(request, "eq_cedex_otr_cd_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setEqCedexOtrNumCd(JSPUtil.getParameter(request, "eq_cedex_otr_num_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setEqCedexOtrTpCd(JSPUtil.getParameter(request, "eq_cedex_otr_tp_cd", ""));
		setEqCedexOtrCd(JSPUtil.getParameter(request, "eq_cedex_otr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * 그리드값을 통채로 받아와 해당 VO배열로 리턴 
	 * @return	CustomMnrCedexOtrCdVO[]   VO배열로    
	 */
	public CustomMnrCedexOtrCdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * 그리드값을 통채로 받아와 해당 VO배열로 리턴 
	 * @return	ComponentCodeListINVO[]   VO배열로    
	 */
	public CustomMnrCedexOtrCdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrCedexOtrCdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] eqCedexOtrCdDesc = (JSPUtil.getParameter(request, prefix	+ "eq_cedex_otr_cd_desc".trim(), length));
			String[] eqCedexOtrCdNm = (JSPUtil.getParameter(request, prefix	+ "eq_cedex_otr_cd_nm".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] eqCedexOtrNumCd = (JSPUtil.getParameter(request, prefix	+ "eq_cedex_otr_num_cd".trim(), length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] eqCedexOtrTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_cedex_otr_tp_cd".trim(), length));
			String[] eqCedexOtrCd = (JSPUtil.getParameter(request, prefix	+ "eq_cedex_otr_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrCedexOtrCdVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqCedexOtrCdDesc[i] != null)
					model.setEqCedexOtrCdDesc(eqCedexOtrCdDesc[i]);
				if (eqCedexOtrCdNm[i] != null)
					model.setEqCedexOtrCdNm(eqCedexOtrCdNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eqCedexOtrNumCd[i] != null)
					model.setEqCedexOtrNumCd(eqCedexOtrNumCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (eqCedexOtrTpCd[i] != null)
					model.setEqCedexOtrTpCd(eqCedexOtrTpCd[i]);
				if (eqCedexOtrCd[i] != null)
					model.setEqCedexOtrCd(eqCedexOtrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMnrCedexOtrCdVOs();
	}

	/**
	 * getMnrCedexOtrCdVOs 
	 * @return	CustomMnrCedexOtrCdVO[]   VO배열로    
	 */
	public CustomMnrCedexOtrCdVO[] getMnrCedexOtrCdVOs(){
		CustomMnrCedexOtrCdVO[] vos = (CustomMnrCedexOtrCdVO[])models.toArray(new CustomMnrCedexOtrCdVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCedexOtrCdDesc = this.eqCedexOtrCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCedexOtrCdNm = this.eqCedexOtrCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCedexOtrNumCd = this.eqCedexOtrNumCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCedexOtrTpCd = this.eqCedexOtrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCedexOtrCd = this.eqCedexOtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
