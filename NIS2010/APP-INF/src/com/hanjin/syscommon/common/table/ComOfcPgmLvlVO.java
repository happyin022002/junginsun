/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ComOfcPgmLvlVO.java
*@FileTitle : ComOfcPgmLvlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12
*@LastModifier : 이성욱
*@LastVersion : 1.0

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
 * @author 이성욱
 * @since J2EE 1.5
 */
public class ComOfcPgmLvlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComOfcPgmLvlVO> models = new ArrayList<ComOfcPgmLvlVO>();
	
	/* Column Inpo */
	private String updDt = null;
	/* Column Inpo */
	private String ofcLvl = null;
	/* Column Inpo */
	private String creUsrId = null;
	
	/* Column Inpo */
	private String creDt = null;
	/* Column Inpo */
	private String updUsrId = null;
	/* Column Inpo */
	private String pgmNo = null;
	
	private int cnt = 0;


	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComOfcPgmLvlVO() {}

	public ComOfcPgmLvlVO(String ibflag, String pagerows, String ofcLvl, String pgmNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.ofcLvl = ofcLvl;
		this.creUsrId = creUsrId;
		
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.pgmNo = pgmNo;
		
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ofc_lvl", getOfcLvl());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pgm_no", getPgmNo());
		
		
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ofc_lvl", "ofcLvl");
		this.hashFields.put("cre_usr_id", "creUsrId");
		
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pgm_no", "pgmNo");
		
		return this.hashFields;
	}
	
	public String getUpdDt() {
		return this.updDt;
	}
	public String getOfcLvl() {
		return this.ofcLvl;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	public String getCreDt() {
		return this.creDt;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getPgmNo() {
		return this.pgmNo;
	}
	
	public int getCnt() {
		return this.cnt;
	}
	
	public void setCnt(int cnt) {
		this.cnt = cnt;
		//this.updDt=true;
	}
	
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setOfcLvl(String ofcLvl) {
		this.ofcLvl = ofcLvl;
		//this.ofcLvl=true;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	
	public void setCreDt(String creDt) {
		this.creDt = creDt;
		//this.creDt=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
		//this.pgmNo=true;
	}
	
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setOfcLvl(JSPUtil.getParameter(request, "ofc_lvl", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
	
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPgmNo(JSPUtil.getParameter(request, "pgm_no", ""));
		
	}

	public ComOfcPgmLvlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public ComOfcPgmLvlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		
		ComOfcPgmLvlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  		
  		String ofc_lvl_str = request.getParameter("ofc_lvl").trim();
  		
  		setOfcLvl(ofc_lvl_str);
  		
  		String[] ofc_lvl_arr = (ofc_lvl_str.split(","));
  		
  
		try {
			
			
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), ofc_lvl_arr.length));
			
			String[] ofcLvl = (JSPUtil.getParameter(request, prefix	+ "ofc_lvl".trim(), ofc_lvl_arr.length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), ofc_lvl_arr.length));
		
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), ofc_lvl_arr.length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), ofc_lvl_arr.length));
			String[] pgmNo = (JSPUtil.getParameter(request, prefix	+ "pgm_no".trim(), ofc_lvl_arr.length));
		
			
		
			for (int i = 0; i < ofc_lvl_arr.length; i++) {
				
				model = new ComOfcPgmLvlVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ofcLvl[i] != null)
					model.setOfcLvl(ofcLvl[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pgmNo[i] != null)
					model.setPgmNo(pgmNo[i]);
				
				
				models.add(model);
			}
		

		} catch (Exception e) {}
		return getComOfcPgmLvlVOs();
	}

	public ComOfcPgmLvlVO[] getComOfcPgmLvlVOs(){
		ComOfcPgmLvlVO[] vos = (ComOfcPgmLvlVO[])models.toArray(new ComOfcPgmLvlVO[models.size()]);
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
		this.ofcLvl = this.ofcLvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNo = this.pgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}

	
}
