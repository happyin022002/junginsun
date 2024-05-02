/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComUsrRoleMtchVO.java
*@FileTitle : ComUsrRoleMtchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.02.17
*@LastModifier : 이승열
*@LastVersion : 1.0
* 2009.02.17 이승열 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 이승열
 * @since J2EE 1.5
 */

public class ComUsrJobMtchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComUsrJobMtchVO> models = new ArrayList<ComUsrJobMtchVO>();
	
	/* Column Inpo */
	/* mapping flag*/
	private String      checkVal   = "";
	
	private String updUsrId = null;
	/* Status */
	private String ibflag = null;
	/* Column Inpo */
	private String updDt = null;
	/* Column Inpo */
	private String creDt = null;
	/* Column Inpo */
	private String usrId = null;
	/* Column Inpo */
	private String creUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Inpo */
	private String usrJobCd = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComUsrJobMtchVO() {}

	public ComUsrJobMtchVO(String ibflag, String pagerows, String usrId, String usrJobCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updUsrId = updUsrId;
		this.ibflag = ibflag;
		this.updDt = updDt;
		this.creDt = creDt;
		this.usrId = usrId;
		this.creUsrId = creUsrId;
		this.pagerows = pagerows;
		this.usrJobCd = usrJobCd;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("usr_job_cd", getUsrJobCd());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usr_job_cd", "usrJobCd");
		return this.hashFields;
	}
	
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getUpdDt() {
		return this.updDt;
	}
	public String getCreDt() {
		return this.creDt;
	}
	public String getUsrId() {
		return this.usrId;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getUsrJobCd() {
		return this.usrJobCd;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
		//this.usrId=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setUsrJobCd(String usrJobCd) {
		this.usrJobCd = usrJobCd;
		//this.usrRoleCd=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setCheckVal(JSPUtil.getParameter(request, "check_val", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUsrJobCd(JSPUtil.getParameter(request, "usr_job_cd", ""));
	}

	public ComUsrJobMtchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public ComUsrJobMtchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComUsrJobMtchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] checkVal   =  (JSPUtil.getParameter(request, prefix	+ "check_val".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] usrJobCd = (JSPUtil.getParameter(request, prefix	+ "usr_job_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ComUsrJobMtchVO();
				if(checkVal[i]!=null)
					model.setCheckVal(checkVal[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (usrJobCd[i] != null)
					model.setUsrJobCd(usrJobCd[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getComUsrJobMtchVOs();
	}

	public ComUsrJobMtchVO[] getComUsrJobMtchVOs(){
		ComUsrJobMtchVO[] vos = (ComUsrJobMtchVO[])models.toArray(new ComUsrJobMtchVO[models.size()]);
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
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrJobCd = this.usrJobCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public void setCheckVal(String checkVal) {
		this.checkVal = checkVal;
	}

	public String getCheckVal() {
		return checkVal;
	}
}
