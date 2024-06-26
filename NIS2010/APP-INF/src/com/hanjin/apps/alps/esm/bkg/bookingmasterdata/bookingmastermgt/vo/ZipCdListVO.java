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

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author KIM HYUN HWA
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ZipCdListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ZipCdListVO> models = new ArrayList<ZipCdListVO>();
	
	/* Column Info */
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
	private String usrNm = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String evntGdt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String zipCdSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ZipCdListVO() {}

	public ZipCdListVO(String ibflag, String pagerows, String cntCd, String zipCd, String ctyNm, String steNm, String zipDtlAddr, String evntUsrId, String usrNm, String evntOfcCd, String evntDt, String evntGdt, String creUsrId, String creDt, String updUsrId, String updDt, String zipCdSeq, String deltFlg) {
		this.cntCd = cntCd;
		this.zipCd = zipCd;
		this.ctyNm = ctyNm;
		this.steNm = steNm;
		this.zipDtlAddr = zipDtlAddr;  
		this.evntUsrId = evntUsrId;
		this.usrNm = usrNm;
		this.evntOfcCd = evntOfcCd;
		this.evntDt = evntDt;
		this.evntGdt = evntGdt;
		this.deltFlg = deltFlg;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
	    this.updDt = updDt;
		this.updUsrId = updUsrId;
		this.zipCdSeq = zipCdSeq;
		this.pagerows = pagerows;
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
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("evnt_gdt", getEvntGdt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());	
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("zip_cd_seq", getZipCdSeq());
		this.hashColumns.put("pagerows", getPagerows());
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
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("evnt_gdt", "evntGdt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("zip_cd_seq", "zipCdSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * Column Info
	 * @return evntGdt
	 */
	public String getEvntGdt() {
		return this.evntGdt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	
	/**
	 * Column Info
	 * @return zipCdSeq
	 */
	public String getZipCdSeq() {
		return this.zipCdSeq;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * Column Info
	 * @param evntGdt
	 */
	public void setEvntGdt(String evntGdt) {
		this.evntGdt = evntGdt;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}
	
	/**
	 * Column Info
	 * @param zipCdSeq
	 */
	public void setZipCdSeq(String zipCdSeq) {
		this.zipCdSeq = zipCdSeq;
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
		setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setEvntGdt(JSPUtil.getParameter(request, "evnt_gdt", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));		
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_Dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setZipCdSeq(JSPUtil.getParameter(request, "zip_cd_seq", ""));

	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return ZipCdListVO[]
	 */
	public ZipCdListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchWareHouseVO[]
	 */
	public ZipCdListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ZipCdListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
		   	  String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			  String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd".trim(), length));
			  String[] ctyNm  = (JSPUtil.getParameter(request, prefix	+ "cty_nm".trim(), length));
			  String[] steNm = (JSPUtil.getParameter(request, prefix	+ "ste_nm".trim(), length));
			  String[] zipDtlAddr = (JSPUtil.getParameter(request, prefix	+ "zip_dtl_addr".trim(), length));
			  String[] evntUsrId  = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id".trim(), length));
			  String[] usrNm      = (JSPUtil.getParameter(request, prefix	+ "usr_nm".trim(), length));
			  String[] evntOfcCd   = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd".trim(), length));
			  String[] evntDt    = (JSPUtil.getParameter(request, prefix	+ "evnt_dt".trim(), length));
			  String[] evntGdt  = (JSPUtil.getParameter(request, prefix	+ "evnt_gdt".trim(), length));
			  String[] deltFlg   = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			  String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			  String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			  String[] updDt    = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			  String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			  String[] ibflag   = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			  String[] zipCdSeq = (JSPUtil.getParameter(request, prefix + "zip_cd_seq".trim(), length));
			for (int i = 0; i < length; i++) {
				model = new ZipCdListVO();
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (steNm[i] != null)
					model.setSteNm(steNm[i]);
				if (zipDtlAddr[i] != null)
					model.setZipDtlAddr(zipDtlAddr[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (evntGdt[i] != null)
					model.setEvntGdt(evntGdt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (zipCdSeq[i] != null)
					model.setZipCdSeq(zipCdSeq[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getZipCdListVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return ZipCdListVO[]
	 */
	public ZipCdListVO[] getZipCdListVOs(){
		ZipCdListVO[] vos = (ZipCdListVO[])models.toArray(new ZipCdListVO[models.size()]);
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
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steNm = this.steNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipDtlAddr = this.zipDtlAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId  = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm  = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd  = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt  = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntGdt = this.evntGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
     	this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	    this.updDt    = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag   = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCdSeq   = this.zipCdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
