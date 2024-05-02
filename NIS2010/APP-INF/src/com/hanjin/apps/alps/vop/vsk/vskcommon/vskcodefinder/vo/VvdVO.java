/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VvdVO.java
*@FileTitle : VvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.11
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.14 서창열 
* 1.0 Creation
* History
* 2010.10.04 유혁 CHM-201006129-01 ALPS SKD 이 KTNET I/F 확인요청
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo;

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
 * @author 서창열
 * @since J2EE 1.5
 * @see ..
 */
public class VvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VvdVO> models = new ArrayList<VvdVO>();
	
	/* Column Info */
	private String turnSkdVoyNo = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String statusflag = null;
	/* Column Info */
	private String turnPortIndCd = null;
	/* Column Info */
	private String turnSkdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String creUsrId = null; 
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String incDelVsl = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VvdVO() {}

	public VvdVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String turnPortIndCd, String turnSkdVoyNo, String turnSkdDirCd, String statusflag, String vslSlanCd, String creUsrId, String updUsrId, String incDelVsl) {
		this.turnSkdVoyNo = turnSkdVoyNo;
		this.ibflag = ibflag;
		this.vslCd = vslCd;
		this.skdDirCd = skdDirCd;
		this.skdVoyNo = skdVoyNo;
		this.statusflag = statusflag;
		this.turnPortIndCd = turnPortIndCd;
		this.turnSkdDirCd = turnSkdDirCd;
		this.pagerows = pagerows;
		this.vslSlanCd = vslSlanCd;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
		this.incDelVsl = incDelVsl;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("turn_skd_voy_no", getTurnSkdVoyNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("statusflag", getStatusflag());
		this.hashColumns.put("turn_port_ind_cd", getTurnPortIndCd());
		this.hashColumns.put("turn_skd_dir_cd", getTurnSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inc_del_vsl", getIncDelVsl());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("statusflag", "statusflag");
		this.hashFields.put("turn_port_ind_cd", "turnPortIndCd");
		this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inc_del_vsl", "incDelVsl");
		return this.hashFields;
	}
	
	public String getTurnSkdVoyNo() {
		return this.turnSkdVoyNo;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	public String getStatusflag() {
		return this.statusflag;
	}
	public String getTurnPortIndCd() {
		return this.turnPortIndCd;
	}
	public String getTurnSkdDirCd() {
		return this.turnSkdDirCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	public String getIncDelVsl() {
		return this.incDelVsl;
	}

	public void setTurnSkdVoyNo(String turnSkdVoyNo) {
		this.turnSkdVoyNo = turnSkdVoyNo;
		//this.turnSkdVoyNo=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
		//this.skdDirCd=true;
	}
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
		//this.skdVoyNo=true;
	}
	public void setStatusflag(String statusflag) {
		this.statusflag = statusflag;
		//this.statusflag=true;
	}
	public void setTurnPortIndCd(String turnPortIndCd) {
		this.turnPortIndCd = turnPortIndCd;
		//this.turnPortIndCd=true;
	}
	public void setTurnSkdDirCd(String turnSkdDirCd) {
		this.turnSkdDirCd = turnSkdDirCd;
		//this.turnSkdDirCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	public void setIncDelVsl(String incDelVsl) {
		this.incDelVsl = incDelVsl;
	}
	public void fromRequest(HttpServletRequest request) {
		setTurnSkdVoyNo(JSPUtil.getParameter(request, "turn_skd_voy_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setStatusflag(JSPUtil.getParameter(request, "statusflag", ""));
		setTurnPortIndCd(JSPUtil.getParameter(request, "turn_port_ind_cd", ""));
		setTurnSkdDirCd(JSPUtil.getParameter(request, "turn_skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setIncDelVsl(JSPUtil.getParameter(request, "inc_del_vsl", ""));
	}

	public VvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public VvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] turnSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "turn_skd_voy_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));
			String[] statusflag = (JSPUtil.getParameter(request, prefix	+ "statusflag".trim(), length));
			String[] turnPortIndCd = (JSPUtil.getParameter(request, prefix	+ "turn_port_ind_cd".trim(), length));
			String[] turnSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "turn_skd_dir_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] incDelVsl = (JSPUtil.getParameter(request, prefix	+ "inc_del_vsl".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new VvdVO();
				if (turnSkdVoyNo[i] != null)
					model.setTurnSkdVoyNo(turnSkdVoyNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (statusflag[i] != null)
					model.setStatusflag(statusflag[i]);
				if (turnPortIndCd[i] != null)
					model.setTurnPortIndCd(turnPortIndCd[i]);
				if (turnSkdDirCd[i] != null)
					model.setTurnSkdDirCd(turnSkdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (incDelVsl[i] != null)
					model.setIncDelVsl(incDelVsl[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVvdVOs();
	}

	public VvdVO[] getVvdVOs(){
		VvdVO[] vos = (VvdVO[])models.toArray(new VvdVO[models.size()]);
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
		this.turnSkdVoyNo = this.turnSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusflag = this.statusflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnPortIndCd = this.turnPortIndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdDirCd = this.turnSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.incDelVsl = this.incDelVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}