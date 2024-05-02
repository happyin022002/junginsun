/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : authSetupListCondVO.java
*@FileTitle : authSetupListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.05.20 김도완 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.AuthSetupListCondVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김도완
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class UserAuthListCondVO extends AuthSetupListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UserAuthListCondVO> models = new ArrayList<UserAuthListCondVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String usrId = null;
	/* Page Number */
	private String pagerows = null;
	/* User Id that was changed */
	private String chUsrId = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UserAuthListCondVO() {}

	public UserAuthListCondVO(String ibflag, String pagerows, String usrId, String usrNm, String ofcCd, String chUsrId) {
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.usrNm = usrNm;
		this.usrId = usrId;
		this.pagerows = pagerows;
		this.chUsrId = chUsrId;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chUsrId", getChUsrId());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chUsrId", "chUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * User Id that was changed
	 * @return chUsrId
	 */
	public String getChUsrId() {
		return this.chUsrId;
	}
	

	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * User Id that was changed
	 * @return chUsrId
	 */
	public void setChUsrID(String chUsrId) {
		this.chUsrId = chUsrId;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChUsrID(JSPUtil.getParameter(request, "ch_usr_id", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return UserAuthListCondVO[]
	 */
	public UserAuthListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AuthSetupListCondVO[]
	 */
	public UserAuthListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UserAuthListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm".trim(), length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] chUsrId = (JSPUtil.getParameter(request, prefix	+ "ch_usr_id".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new UserAuthListCondVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pagerows[i] != null)
					model.setChUsrID(chUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAuthSetupListCondVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return AuthSetupListCondVO[]
	 */
	public UserAuthListCondVO[] getAuthSetupListCondVOs(){
		UserAuthListCondVO[] vos = (UserAuthListCondVO[])models.toArray(new UserAuthListCondVO[models.size()]);
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
	public void unDataFormat(){
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chUsrId = this.chUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
