/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgBlNoDupChkVO.java
*@FileTitle : BkgBlNoDupChkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.04.23 김영출 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김영출
 * @since J2EE 1.5
 */

public class MdmLocationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MdmLocationVO> models = new ArrayList<MdmLocationVO>();
	
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String blNoTp = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String blNoAsgnDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String blNoChk = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MdmLocationVO() {}

	public MdmLocationVO(String ibflag, String pagerows, String blNo, String blNoTp, String blNoChk, String blNoAsgnDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updUsrId = updUsrId;
		this.blNoTp = blNoTp;
		this.ibflag = ibflag;
		this.updDt = updDt;
		this.creDt = creDt;
		this.creUsrId = creUsrId;
		this.blNoAsgnDt = blNoAsgnDt;
		this.blNo = blNo;
		this.blNoChk = blNoChk;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bl_no_asgn_dt", getBlNoAsgnDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bl_no_asgn_dt", "blNoAsgnDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getBlNoTp() {
		return this.blNoTp;
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
	public String getCreUsrId() {
		return this.creUsrId;
	}
	public String getBlNoAsgnDt() {
		return this.blNoAsgnDt;
	}
	public String getBlNo() {
		return this.blNo;
	}
	public String getBlNoChk() {
		return this.blNoChk;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
		//this.blNoTp=true;
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
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
		//this.creUsrId=true;
	}
	public void setBlNoAsgnDt(String blNoAsgnDt) {
		this.blNoAsgnDt = blNoAsgnDt;
		//this.blNoAsgnDt=true;
	}
	public void setBlNo(String blNo) {
		this.blNo = blNo;
		//this.blNo=true;
	}
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
		//this.blNoChk=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setBlNoAsgnDt(JSPUtil.getParameter(request, "bl_no_asgn_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public MdmLocationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public MdmLocationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MdmLocationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] blNoAsgnDt = (JSPUtil.getParameter(request, prefix	+ "bl_no_asgn_dt".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new MdmLocationVO();
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (blNoAsgnDt[i] != null)
					model.setBlNoAsgnDt(blNoAsgnDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getBkgBlNoDupChkVOs();
	}

	public MdmLocationVO[] getBkgBlNoDupChkVOs(){
		MdmLocationVO[] vos = (MdmLocationVO[])models.toArray(new MdmLocationVO[models.size()]);
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
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoAsgnDt = this.blNoAsgnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
