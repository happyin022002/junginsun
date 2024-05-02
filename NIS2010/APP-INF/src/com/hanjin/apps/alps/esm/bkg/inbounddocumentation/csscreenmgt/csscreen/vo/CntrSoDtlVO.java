/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrSoDtlVO.java
*@FileTitle : CntrSoDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.31  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrSoDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrSoDtlVO> models = new ArrayList<CntrSoDtlVO>();
	
	/* Column Info */
	private String spName = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String woDate = null;
	/* Column Info */
	private String spTelNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String spCode = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String spFaxNo = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String nodCd = null;
	/* Column Info */
	private String soDate = null;
	/* Column Info */
	private String costMode = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrSoDtlVO() {}

	public CntrSoDtlVO(String ibflag, String pagerows, String spCode, String cntrNo, String spName, String spTelNo, String spFaxNo, String costMode, String nodCd, String stsCd, String ofcCd, String usrId, String soNo, String soDate, String woNo, String woDate, String usrNm) {
		this.spName = spName;
		this.soNo = soNo;
		this.woDate = woDate;
		this.spTelNo = spTelNo;
		this.pagerows = pagerows;
		this.spCode = spCode;
		this.stsCd = stsCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.usrNm = usrNm;
		this.usrId = usrId;
		this.cntrNo = cntrNo;
		this.spFaxNo = spFaxNo;
		this.woNo = woNo;
		this.nodCd = nodCd;
		this.soDate = soDate;
		this.costMode = costMode;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sp_name", getSpName());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("wo_date", getWoDate());
		this.hashColumns.put("sp_tel_no", getSpTelNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sp_code", getSpCode());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sp_fax_no", getSpFaxNo());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("nod_cd", getNodCd());
		this.hashColumns.put("so_date", getSoDate());
		this.hashColumns.put("cost_mode", getCostMode());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sp_name", "spName");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("wo_date", "woDate");
		this.hashFields.put("sp_tel_no", "spTelNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sp_code", "spCode");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sp_fax_no", "spFaxNo");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("nod_cd", "nodCd");
		this.hashFields.put("so_date", "soDate");
		this.hashFields.put("cost_mode", "costMode");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return spName
	 */
	public String getSpName() {
		return this.spName;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return woDate
	 */
	public String getWoDate() {
		return this.woDate;
	}
	
	/**
	 * Column Info
	 * @return spTelNo
	 */
	public String getSpTelNo() {
		return this.spTelNo;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return spCode
	 */
	public String getSpCode() {
		return this.spCode;
	}
	
	/**
	 * Column Info
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
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
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return spFaxNo
	 */
	public String getSpFaxNo() {
		return this.spFaxNo;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return nodCd
	 */
	public String getNodCd() {
		return this.nodCd;
	}
	
	/**
	 * Column Info
	 * @return soDate
	 */
	public String getSoDate() {
		return this.soDate;
	}
	
	/**
	 * Column Info
	 * @return costMode
	 */
	public String getCostMode() {
		return this.costMode;
	}
	

	/**
	 * Column Info
	 * @param spName
	 */
	public void setSpName(String spName) {
		this.spName = spName;
	}
	
	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param woDate
	 */
	public void setWoDate(String woDate) {
		this.woDate = woDate;
	}
	
	/**
	 * Column Info
	 * @param spTelNo
	 */
	public void setSpTelNo(String spTelNo) {
		this.spTelNo = spTelNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param spCode
	 */
	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}
	
	/**
	 * Column Info
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
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
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param spFaxNo
	 */
	public void setSpFaxNo(String spFaxNo) {
		this.spFaxNo = spFaxNo;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param nodCd
	 */
	public void setNodCd(String nodCd) {
		this.nodCd = nodCd;
	}
	
	/**
	 * Column Info
	 * @param soDate
	 */
	public void setSoDate(String soDate) {
		this.soDate = soDate;
	}
	
	/**
	 * Column Info
	 * @param costMode
	 */
	public void setCostMode(String costMode) {
		this.costMode = costMode;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSpName(JSPUtil.getParameter(request, "sp_name", ""));
		setSoNo(JSPUtil.getParameter(request, "so_no", ""));
		setWoDate(JSPUtil.getParameter(request, "wo_date", ""));
		setSpTelNo(JSPUtil.getParameter(request, "sp_tel_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSpCode(JSPUtil.getParameter(request, "sp_code", ""));
		setStsCd(JSPUtil.getParameter(request, "sts_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setSpFaxNo(JSPUtil.getParameter(request, "sp_fax_no", ""));
		setWoNo(JSPUtil.getParameter(request, "wo_no", ""));
		setNodCd(JSPUtil.getParameter(request, "nod_cd", ""));
		setSoDate(JSPUtil.getParameter(request, "so_date", ""));
		setCostMode(JSPUtil.getParameter(request, "cost_mode", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrSoDtlVO[]
	 */
	public CntrSoDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrSoDtlVO[]
	 */
	public CntrSoDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrSoDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] spName = (JSPUtil.getParameter(request, prefix	+ "sp_name", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] woDate = (JSPUtil.getParameter(request, prefix	+ "wo_date", length));
			String[] spTelNo = (JSPUtil.getParameter(request, prefix	+ "sp_tel_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] spCode = (JSPUtil.getParameter(request, prefix	+ "sp_code", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] spFaxNo = (JSPUtil.getParameter(request, prefix	+ "sp_fax_no", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] nodCd = (JSPUtil.getParameter(request, prefix	+ "nod_cd", length));
			String[] soDate = (JSPUtil.getParameter(request, prefix	+ "so_date", length));
			String[] costMode = (JSPUtil.getParameter(request, prefix	+ "cost_mode", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrSoDtlVO();
				if (spName[i] != null)
					model.setSpName(spName[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (woDate[i] != null)
					model.setWoDate(woDate[i]);
				if (spTelNo[i] != null)
					model.setSpTelNo(spTelNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (spCode[i] != null)
					model.setSpCode(spCode[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (spFaxNo[i] != null)
					model.setSpFaxNo(spFaxNo[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (nodCd[i] != null)
					model.setNodCd(nodCd[i]);
				if (soDate[i] != null)
					model.setSoDate(soDate[i]);
				if (costMode[i] != null)
					model.setCostMode(costMode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrSoDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrSoDtlVO[]
	 */
	public CntrSoDtlVO[] getCntrSoDtlVOs(){
		CntrSoDtlVO[] vos = (CntrSoDtlVO[])models.toArray(new CntrSoDtlVO[models.size()]);
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
		this.spName = this.spName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woDate = this.woDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spTelNo = this.spTelNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCode = this.spCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spFaxNo = this.spFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodCd = this.nodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soDate = this.soDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costMode = this.costMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
