/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GrpBlDtListVO.java
*@FileTitle : GrpBlDtListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.08.14 김영출 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김영출
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GrpBlDtListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GrpBlDtListVO> models = new ArrayList<GrpBlDtListVO>();
	
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String blObrdDtSd = null;
	/* Column Info */
	private String oblIssFlg = null;
	/* Column Info */
	private String oblIssDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blIssTpCd = null;
	/* Column Info */
	private String oblRlseFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String oblIssDtSd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String oblIssUsrId = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String blObrdTpCd = null;
	/* Column Info */
	private String blObrdDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String oblIssOfcCd = null;
	/* Column Info */
	private String creditChk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GrpBlDtListVO() {}

	public GrpBlDtListVO(String ibflag, String pagerows, String bkgNo, String blNo, String blIssTpCd, String custCd, String custNm, String blObrdTpCd, String blObrdDt, String blObrdDtSd, String oblIssFlg, String oblRlseFlg, String oblIssDt, String oblIssDtSd, String oblIssOfcCd, String oblIssUsrId, String creUsrId, String updUsrId, String creditChk) {
		this.custNm = custNm;
		this.blObrdDtSd = blObrdDtSd;
		this.oblIssFlg = oblIssFlg;
		this.oblIssDt = oblIssDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.blIssTpCd = blIssTpCd;
		this.oblRlseFlg = oblRlseFlg;
		this.creUsrId = creUsrId;
		this.oblIssDtSd = oblIssDtSd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.oblIssUsrId = oblIssUsrId;
		this.custCd = custCd;
		this.blObrdTpCd = blObrdTpCd;
		this.blObrdDt = blObrdDt;
		this.updUsrId = updUsrId;
		this.oblIssOfcCd = oblIssOfcCd;
		this.creditChk = creditChk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("bl_obrd_dt_sd", getBlObrdDtSd());
		this.hashColumns.put("obl_iss_flg", getOblIssFlg());
		this.hashColumns.put("obl_iss_dt", getOblIssDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_iss_tp_cd", getBlIssTpCd());
		this.hashColumns.put("obl_rlse_flg", getOblRlseFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("obl_iss_dt_sd", getOblIssDtSd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("obl_iss_usr_id", getOblIssUsrId());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("bl_obrd_tp_cd", getBlObrdTpCd());
		this.hashColumns.put("bl_obrd_dt", getBlObrdDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());
		this.hashColumns.put("credit_chk", getCreditChk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bl_obrd_dt_sd", "blObrdDtSd");
		this.hashFields.put("obl_iss_flg", "oblIssFlg");
		this.hashFields.put("obl_iss_dt", "oblIssDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_iss_tp_cd", "blIssTpCd");
		this.hashFields.put("obl_rlse_flg", "oblRlseFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("obl_iss_dt_sd", "oblIssDtSd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("obl_iss_usr_id", "oblIssUsrId");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("bl_obrd_tp_cd", "blObrdTpCd");
		this.hashFields.put("bl_obrd_dt", "blObrdDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		this.hashFields.put("credit_chk", "creditChk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return blObrdDtSd
	 */
	public String getBlObrdDtSd() {
		return this.blObrdDtSd;
	}
	
	/**
	 * Column Info
	 * @return oblIssFlg
	 */
	public String getOblIssFlg() {
		return this.oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @return oblIssDt
	 */
	public String getOblIssDt() {
		return this.oblIssDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return blIssTpCd
	 */
	public String getBlIssTpCd() {
		return this.blIssTpCd;
	}
	
	/**
	 * Column Info
	 * @return oblRlseFlg
	 */
	public String getOblRlseFlg() {
		return this.oblRlseFlg;
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
	 * @return oblIssDtSd
	 */
	public String getOblIssDtSd() {
		return this.oblIssDtSd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return oblIssUsrId
	 */
	public String getOblIssUsrId() {
		return this.oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return blObrdTpCd
	 */
	public String getBlObrdTpCd() {
		return this.blObrdTpCd;
	}
	
	/**
	 * Column Info
	 * @return blObrdDt
	 */
	public String getBlObrdDt() {
		return this.blObrdDt;
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
	 * @return oblIssOfcCd
	 */
	public String getOblIssOfcCd() {
		return this.oblIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return creditChk
	 */
	public String getCreditChk() {
		return this.creditChk;
	}
	

	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param blObrdDtSd
	 */
	public void setBlObrdDtSd(String blObrdDtSd) {
		this.blObrdDtSd = blObrdDtSd;
	}
	
	/**
	 * Column Info
	 * @param oblIssFlg
	 */
	public void setOblIssFlg(String oblIssFlg) {
		this.oblIssFlg = oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @param oblIssDt
	 */
	public void setOblIssDt(String oblIssDt) {
		this.oblIssDt = oblIssDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param blIssTpCd
	 */
	public void setBlIssTpCd(String blIssTpCd) {
		this.blIssTpCd = blIssTpCd;
	}
	
	/**
	 * Column Info
	 * @param oblRlseFlg
	 */
	public void setOblRlseFlg(String oblRlseFlg) {
		this.oblRlseFlg = oblRlseFlg;
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
	 * @param oblIssDtSd
	 */
	public void setOblIssDtSd(String oblIssDtSd) {
		this.oblIssDtSd = oblIssDtSd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param oblIssUsrId
	 */
	public void setOblIssUsrId(String oblIssUsrId) {
		this.oblIssUsrId = oblIssUsrId;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param blObrdTpCd
	 */
	public void setBlObrdTpCd(String blObrdTpCd) {
		this.blObrdTpCd = blObrdTpCd;
	}
	
	/**
	 * Column Info
	 * @param blObrdDt
	 */
	public void setBlObrdDt(String blObrdDt) {
		this.blObrdDt = blObrdDt;
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
	 * @param oblIssOfcCd
	 */
	public void setOblIssOfcCd(String oblIssOfcCd) {
		this.oblIssOfcCd = oblIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param creditChk
	 */
	public void setCreditChk(String creditChk) {
		this.creditChk = creditChk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setBlObrdDtSd(JSPUtil.getParameter(request, "bl_obrd_dt_sd", ""));
		setOblIssFlg(JSPUtil.getParameter(request, "obl_iss_flg", ""));
		setOblIssDt(JSPUtil.getParameter(request, "obl_iss_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlIssTpCd(JSPUtil.getParameter(request, "bl_iss_tp_cd", ""));
		setOblRlseFlg(JSPUtil.getParameter(request, "obl_rlse_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setOblIssDtSd(JSPUtil.getParameter(request, "obl_iss_dt_sd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setOblIssUsrId(JSPUtil.getParameter(request, "obl_iss_usr_id", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setBlObrdTpCd(JSPUtil.getParameter(request, "bl_obrd_tp_cd", ""));
		setBlObrdDt(JSPUtil.getParameter(request, "bl_obrd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request, "obl_iss_ofc_cd", ""));
		setCreditChk(JSPUtil.getParameter(request, "credit_chk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GrpBlDtListVO[]
	 */
	public GrpBlDtListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GrpBlDtListVO[]
	 */
	public GrpBlDtListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GrpBlDtListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] blObrdDtSd = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt_sd", length));
			String[] oblIssFlg = (JSPUtil.getParameter(request, prefix	+ "obl_iss_flg", length));
			String[] oblIssDt = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blIssTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_iss_tp_cd", length));
			String[] oblRlseFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rlse_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] oblIssDtSd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_dt_sd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] oblIssUsrId = (JSPUtil.getParameter(request, prefix	+ "obl_iss_usr_id", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] blObrdTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_tp_cd", length));
			String[] blObrdDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] oblIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "obl_iss_ofc_cd", length));
			String[] creditChk = (JSPUtil.getParameter(request, prefix	+ "credit_chk", length));
			
			for (int i = 0; i < length; i++) {
				model = new GrpBlDtListVO();
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (blObrdDtSd[i] != null)
					model.setBlObrdDtSd(blObrdDtSd[i]);
				if (oblIssFlg[i] != null)
					model.setOblIssFlg(oblIssFlg[i]);
				if (oblIssDt[i] != null)
					model.setOblIssDt(oblIssDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blIssTpCd[i] != null)
					model.setBlIssTpCd(blIssTpCd[i]);
				if (oblRlseFlg[i] != null)
					model.setOblRlseFlg(oblRlseFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (oblIssDtSd[i] != null)
					model.setOblIssDtSd(oblIssDtSd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (oblIssUsrId[i] != null)
					model.setOblIssUsrId(oblIssUsrId[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (blObrdTpCd[i] != null)
					model.setBlObrdTpCd(blObrdTpCd[i]);
				if (blObrdDt[i] != null)
					model.setBlObrdDt(blObrdDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (oblIssOfcCd[i] != null)
					model.setOblIssOfcCd(oblIssOfcCd[i]);
				if (creditChk[i] != null)
					model.setCreditChk(creditChk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGrpBlDtListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GrpBlDtListVO[]
	 */
	public GrpBlDtListVO[] getGrpBlDtListVOs(){
		GrpBlDtListVO[] vos = (GrpBlDtListVO[])models.toArray(new GrpBlDtListVO[models.size()]);
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
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDtSd = this.blObrdDtSd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssFlg = this.oblIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDt = this.oblIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssTpCd = this.blIssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRlseFlg = this.oblRlseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDtSd = this.oblIssDtSd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssUsrId = this.oblIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdTpCd = this.blObrdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDt = this.blObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd = this.oblIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creditChk = this.creditChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
