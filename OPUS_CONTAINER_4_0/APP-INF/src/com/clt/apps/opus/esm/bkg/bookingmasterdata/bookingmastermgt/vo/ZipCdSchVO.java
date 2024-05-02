/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchWareHouseVO.java
*@FileTitle : SearchWareHouseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.05.20 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author KIM HYUN HWA
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ZipCdSchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ZipCdSchVO> models = new ArrayList<ZipCdSchVO>();
	
	
	private String cntCd = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String ctyNm = null;
	/* Column Info */
	private String steNm = null;
	/* Column Info */
	private String zipDtlAddr = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String evntOfcCd = null;	
	/* Column Info */
	private String deltFlg = null;	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;

	
	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ZipCdSchVO() {}

	public ZipCdSchVO(String ibflag, String pagerows, String cntCd, String whCd, String whNm, String whAddr, String locCd, String cstmsCd, String phnNo, String faxNo, String psonNm, String diffRmk, String creUsrId, String creDt, String updUsrId, String updDt, String locNm) {
		this.cntCd = cntCd;
		this.zipCd = zipCd;
		this.ctyNm = ctyNm;
		this.steNm = steNm;
		this.zipDtlAddr = zipDtlAddr;  
		this.evntUsrId = evntUsrId;
		this.evntOfcCd = evntOfcCd;
		this.deltFlg = deltFlg;
		this.ibflag = ibflag;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("ste_nm", getSteNm());
		this.hashColumns.put("zip_dtl_addr", getZipDtlAddr());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("ibflag", getIbflag());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("ste_nm", "steNm");
		this.hashFields.put("zip_dtl_addr", "zipDtlAddr");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("delt_flg", "deltFlg");

		this.hashFields.put("ibflag", "ibflag");
		return this.hashFields;
	}
	
		
	/**
	 * Column Info
	 * @return evntOfcCd
	 */
	public String getEvntOfcCd() {
		return this.evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return steNm
	 */
	public String getSteNm() {
		return this.steNm;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return evntUsrId
	 */
	public String getEvntUsrId() {
		return this.evntUsrId;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
	}
	
	/**
	 * Column Info
	 * @return zipDtlAddr
	 */
	public String getZipDtlAddr() {
		return this.zipDtlAddr;
	}

	/**
	 * Column Info
	 * @param evntOfcCd
	 */
	public void setEvntOfcCd(String evntOfcCd) {
		this.evntOfcCd = evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param steNm
	 */
	public void setSteNm(String steNm) {
		this.steNm = steNm;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param evntUsrId
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
	}
	
	/**
	 * Column Info
	 * @param zipDtlAddr
	 */
	public void setZipDtlAddr(String zipDtlAddr) {
		this.zipDtlAddr = zipDtlAddr;
	}
	

	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setZipCd(JSPUtil.getParameter(request, "zip_cd", ""));
		setCtyNm(JSPUtil.getParameter(request, "cty_nm", ""));
		setSteNm(JSPUtil.getParameter(request, "ste_nm", ""));
		setZipDtlAddr(JSPUtil.getParameter(request, "zip_dtl_addr", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		
	}


	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return SearchWareHouseVO[]
	 */
//	public ZipCdSchVO[] getZipCdSchVOs(){
//		ZipCdSchVO[] vos = (ZipCdSchVO[])models.toArray(new ZipCdSchVO[models.size()]);
//		return vos;
//	}
//	
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
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steNm = this.steNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipDtlAddr = this.zipDtlAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    	this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    	
	}
}
