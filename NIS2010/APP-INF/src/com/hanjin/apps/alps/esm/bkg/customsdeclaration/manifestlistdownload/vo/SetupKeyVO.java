/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SetupKeyVO.java
*@FileTitle : SetupKeyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.04.30 이수빈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo;

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
 * @author 이수빈
 * @since J2EE 1.5
 */

public class SetupKeyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SetupKeyVO> models = new ArrayList<SetupKeyVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String locCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String frobFlg = null;
	/* Column Info */
	private String cstmsDivId = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SetupKeyVO() {}

	public SetupKeyVO(String ibflag, String pagerows, String deltFlg, String updUsrId, String updDt, String cntCd, String cstmsDivId, String locCd, String frobFlg) {
		this.updDt = updDt;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.frobFlg = frobFlg;
		this.cstmsDivId = cstmsDivId;
		this.deltFlg = deltFlg;
		this.cntCd = cntCd;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frob_flg", getFrobFlg());
		this.hashColumns.put("cstms_div_id", getCstmsDivId());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frob_flg", "frobFlg");
		this.hashFields.put("cstms_div_id", "cstmsDivId");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getUpdDt() {
		return this.updDt;
	}
	public String getLocCd() {
		return this.locCd;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getFrobFlg() {
		return this.frobFlg;
	}
	public String getCstmsDivId() {
		return this.cstmsDivId;
	}
	public String getDeltFlg() {
		return this.deltFlg;
	}
	public String getCntCd() {
		return this.cntCd;
	}
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setUpdDt(String updDt) {
		this.updDt = updDt;
		//this.updDt=true;
	}
	public void setLocCd(String locCd) {
		this.locCd = locCd;
		//this.locCd=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setFrobFlg(String frobFlg) {
		this.frobFlg = frobFlg;
		//this.frobFlg=true;
	}
	public void setCstmsDivId(String cstmsDivId) {
		this.cstmsDivId = cstmsDivId;
		//this.cstmsDivId=true;
	}
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
		//this.deltFlg=true;
	}
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
		//this.cntCd=true;
	}
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
		//this.updUsrId=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFrobFlg(JSPUtil.getParameter(request, "frob_flg", ""));
		setCstmsDivId(JSPUtil.getParameter(request, "cstms_div_id", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public SetupKeyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public SetupKeyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SetupKeyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] frobFlg = (JSPUtil.getParameter(request, prefix	+ "frob_flg".trim(), length));
			String[] cstmsDivId = (JSPUtil.getParameter(request, prefix	+ "cstms_div_id".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new SetupKeyVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frobFlg[i] != null)
					model.setFrobFlg(frobFlg[i]);
				if (cstmsDivId[i] != null)
					model.setCstmsDivId(cstmsDivId[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getSetupKeyVOs();
	}

	public SetupKeyVO[] getSetupKeyVOs(){
		SetupKeyVO[] vos = (SetupKeyVO[])models.toArray(new SetupKeyVO[models.size()]);
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
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frobFlg = this.frobFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDivId = this.cstmsDivId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
