/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementINVO.java
*@FileTitle : AgreementINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.06.29 함형석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgreementINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtDisplayType = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String agmtPrifix = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agmtTypeTpsz = null;
	/* Column Info */
	private String isversionup = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String agmtEqType = null;
	/* Column Info */
	private String agmtDisType = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AgreementINVO() {}

	public AgreementINVO(String ibflag, String pagerows, String agmtSeq, String agmtDisplayType, String agmtNo, String agmtPrifix, String agmtTypeTpsz, String isversionup, String agmtOfcCtyCd, String agmtEqType, String agmtDisType, String agmtVerNo, String updUsrId) {
		this.agmtSeq = agmtSeq;
		this.agmtDisplayType = agmtDisplayType;
		this.agmtNo = agmtNo;
		this.agmtPrifix = agmtPrifix;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.agmtTypeTpsz = agmtTypeTpsz;
		this.isversionup = isversionup;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.agmtEqType = agmtEqType;
		this.agmtDisType = agmtDisType;
		this.agmtVerNo = agmtVerNo;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_display_type", getAgmtDisplayType());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("agmt_prifix", getAgmtPrifix());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agmt_type_tpsz", getAgmtTypeTpsz());
		this.hashColumns.put("isversionup", getIsversionup());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("agmt_eq_type", getAgmtEqType());
		this.hashColumns.put("agmt_dis_type", getAgmtDisType());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_display_type", "agmtDisplayType");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_prifix", "agmtPrifix");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agmt_type_tpsz", "agmtTypeTpsz");
		this.hashFields.put("isversionup", "isversionup");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("agmt_eq_type", "agmtEqType");
		this.hashFields.put("agmt_dis_type", "agmtDisType");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtDisplayType
	 */
	public String getAgmtDisplayType() {
		return this.agmtDisplayType;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return agmtPrifix
	 */
	public String getAgmtPrifix() {
		return this.agmtPrifix;
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
	 * @return agmtTypeTpsz
	 */
	public String getAgmtTypeTpsz() {
		return this.agmtTypeTpsz;
	}
	
	/**
	 * Column Info
	 * @return isversionup
	 */
	public String getIsversionup() {
		return this.isversionup;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return agmtEqType
	 */
	public String getAgmtEqType() {
		return this.agmtEqType;
	}
	
	/**
	 * Column Info
	 * @return agmtDisType
	 */
	public String getAgmtDisType() {
		return this.agmtDisType;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
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
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtDisplayType
	 */
	public void setAgmtDisplayType(String agmtDisplayType) {
		this.agmtDisplayType = agmtDisplayType;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param agmtPrifix
	 */
	public void setAgmtPrifix(String agmtPrifix) {
		this.agmtPrifix = agmtPrifix;
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
	 * @param agmtTypeTpsz
	 */
	public void setAgmtTypeTpsz(String agmtTypeTpsz) {
		this.agmtTypeTpsz = agmtTypeTpsz;
	}
	
	/**
	 * Column Info
	 * @param isversionup
	 */
	public void setIsversionup(String isversionup) {
		this.isversionup = isversionup;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param agmtEqType
	 */
	public void setAgmtEqType(String agmtEqType) {
		this.agmtEqType = agmtEqType;
	}
	
	/**
	 * Column Info
	 * @param agmtDisType
	 */
	public void setAgmtDisType(String agmtDisType) {
		this.agmtDisType = agmtDisType;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtDisplayType(JSPUtil.getParameter(request, "agmt_display_type", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setAgmtPrifix(JSPUtil.getParameter(request, "agmt_prifix", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAgmtTypeTpsz(JSPUtil.getParameter(request, "agmt_type_tpsz", ""));
		setIsversionup(JSPUtil.getParameter(request, "isversionup", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setAgmtEqType(JSPUtil.getParameter(request, "agmt_eq_type", ""));
		setAgmtDisType(JSPUtil.getParameter(request, "agmt_dis_type", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
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
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDisplayType = this.agmtDisplayType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtPrifix = this.agmtPrifix .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtTypeTpsz = this.agmtTypeTpsz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isversionup = this.isversionup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtEqType = this.agmtEqType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDisType = this.agmtDisType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
