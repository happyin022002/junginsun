/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeForAuditParmVO.java
*@FileTitle : ChargeForAuditParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.02 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeForAuditParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeForAuditParmVO> models = new ArrayList<ChargeForAuditParmVO>();
	
	/* Column Info */
	private String tFromDt = null;
	/* Column Info */
	private String vessel = null;
	/* Column Info */
	private String tOver = null;
	/* Column Info */
	private String pLoadOptInput = null;
	/* Column Info */
	private String tCollection = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pFmMvmtYdCd = null;
	/* Column Info */
	private String pLoadInput = null;
	/* Column Info */
	private String pOfcCd = null;
	/* Column Info */
	private String voyage = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String tFtEnd = null;
	/* Column Info */
	private String pDmdtTrfCd = null;
	/* Column Info */
	private String tToDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ChargeForAuditParmVO() {}

	public ChargeForAuditParmVO(String ibflag, String pagerows, String pLoadInput, String pLoadOptInput, String pOfcCd, String pDmdtTrfCd, String pFmMvmtYdCd, String cntrNo, String tFromDt, String tToDt, String tFtEnd, String tOver, String tCollection, String vvd, String vessel, String voyage, String bkgNo, String blNo) {
		this.tFromDt = tFromDt;
		this.vessel = vessel;
		this.tOver = tOver;
		this.pLoadOptInput = pLoadOptInput;
		this.tCollection = tCollection;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.pFmMvmtYdCd = pFmMvmtYdCd;
		this.pLoadInput = pLoadInput;
		this.pOfcCd = pOfcCd;
		this.voyage = voyage;
		this.cntrNo = cntrNo;
		this.tFtEnd = tFtEnd;
		this.pDmdtTrfCd = pDmdtTrfCd;
		this.tToDt = tToDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("t_from_dt", getTFromDt());
		this.hashColumns.put("vessel", getVessel());
		this.hashColumns.put("t_over", getTOver());
		this.hashColumns.put("p_load_opt_input", getPLoadOptInput());
		this.hashColumns.put("t_collection", getTCollection());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p_fm_mvmt_yd_cd", getPFmMvmtYdCd());
		this.hashColumns.put("p_load_input", getPLoadInput());
		this.hashColumns.put("p_ofc_cd", getPOfcCd());
		this.hashColumns.put("voyage", getVoyage());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("t_ft_end", getTFtEnd());
		this.hashColumns.put("p_dmdt_trf_cd", getPDmdtTrfCd());
		this.hashColumns.put("t_to_dt", getTToDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("t_from_dt", "tFromDt");
		this.hashFields.put("vessel", "vessel");
		this.hashFields.put("t_over", "tOver");
		this.hashFields.put("p_load_opt_input", "pLoadOptInput");
		this.hashFields.put("t_collection", "tCollection");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p_fm_mvmt_yd_cd", "pFmMvmtYdCd");
		this.hashFields.put("p_load_input", "pLoadInput");
		this.hashFields.put("p_ofc_cd", "pOfcCd");
		this.hashFields.put("voyage", "voyage");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("t_ft_end", "tFtEnd");
		this.hashFields.put("p_dmdt_trf_cd", "pDmdtTrfCd");
		this.hashFields.put("t_to_dt", "tToDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tFromDt
	 */
	public String getTFromDt() {
		return this.tFromDt;
	}
	
	/**
	 * Column Info
	 * @return vessel
	 */
	public String getVessel() {
		return this.vessel;
	}
	
	/**
	 * Column Info
	 * @return tOver
	 */
	public String getTOver() {
		return this.tOver;
	}
	
	/**
	 * Column Info
	 * @return pLoadOptInput
	 */
	public String getPLoadOptInput() {
		return this.pLoadOptInput;
	}
	
	/**
	 * Column Info
	 * @return tCollection
	 */
	public String getTCollection() {
		return this.tCollection;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return pFmMvmtYdCd
	 */
	public String getPFmMvmtYdCd() {
		return this.pFmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @return pLoadInput
	 */
	public String getPLoadInput() {
		return this.pLoadInput;
	}
	
	/**
	 * Column Info
	 * @return pOfcCd
	 */
	public String getPOfcCd() {
		return this.pOfcCd;
	}
	
	/**
	 * Column Info
	 * @return voyage
	 */
	public String getVoyage() {
		return this.voyage;
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
	 * @return tFtEnd
	 */
	public String getTFtEnd() {
		return this.tFtEnd;
	}
	
	/**
	 * Column Info
	 * @return pDmdtTrfCd
	 */
	public String getPDmdtTrfCd() {
		return this.pDmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return tToDt
	 */
	public String getTToDt() {
		return this.tToDt;
	}
	

	/**
	 * Column Info
	 * @param tFromDt
	 */
	public void setTFromDt(String tFromDt) {
		this.tFromDt = tFromDt;
	}
	
	/**
	 * Column Info
	 * @param vessel
	 */
	public void setVessel(String vessel) {
		this.vessel = vessel;
	}
	
	/**
	 * Column Info
	 * @param tOver
	 */
	public void setTOver(String tOver) {
		this.tOver = tOver;
	}
	
	/**
	 * Column Info
	 * @param pLoadOptInput
	 */
	public void setPLoadOptInput(String pLoadOptInput) {
		this.pLoadOptInput = pLoadOptInput;
	}
	
	/**
	 * Column Info
	 * @param tCollection
	 */
	public void setTCollection(String tCollection) {
		this.tCollection = tCollection;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param pFmMvmtYdCd
	 */
	public void setPFmMvmtYdCd(String pFmMvmtYdCd) {
		this.pFmMvmtYdCd = pFmMvmtYdCd;
	}
	
	/**
	 * Column Info
	 * @param pLoadInput
	 */
	public void setPLoadInput(String pLoadInput) {
		this.pLoadInput = pLoadInput;
	}
	
	/**
	 * Column Info
	 * @param pOfcCd
	 */
	public void setPOfcCd(String pOfcCd) {
		this.pOfcCd = pOfcCd;
	}
	
	/**
	 * Column Info
	 * @param voyage
	 */
	public void setVoyage(String voyage) {
		this.voyage = voyage;
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
	 * @param tFtEnd
	 */
	public void setTFtEnd(String tFtEnd) {
		this.tFtEnd = tFtEnd;
	}
	
	/**
	 * Column Info
	 * @param pDmdtTrfCd
	 */
	public void setPDmdtTrfCd(String pDmdtTrfCd) {
		this.pDmdtTrfCd = pDmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param tToDt
	 */
	public void setTToDt(String tToDt) {
		this.tToDt = tToDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTFromDt(JSPUtil.getParameter(request, "t_from_dt", ""));
		setVessel(JSPUtil.getParameter(request, "vessel", ""));
		setTOver(JSPUtil.getParameter(request, "t_over", ""));
		setPLoadOptInput(JSPUtil.getParameter(request, "p_load_opt_input", ""));
		setTCollection(JSPUtil.getParameter(request, "t_collection", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPFmMvmtYdCd(JSPUtil.getParameter(request, "p_fm_mvmt_yd_cd", ""));
		setPLoadInput(JSPUtil.getParameter(request, "p_load_input", ""));
		setPOfcCd(JSPUtil.getParameter(request, "p_ofc_cd", ""));
		setVoyage(JSPUtil.getParameter(request, "voyage", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setTFtEnd(JSPUtil.getParameter(request, "t_ft_end", ""));
		setPDmdtTrfCd(JSPUtil.getParameter(request, "p_dmdt_trf_cd", ""));
		setTToDt(JSPUtil.getParameter(request, "t_to_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeForAuditParmVO[]
	 */
	public ChargeForAuditParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeForAuditParmVO[]
	 */
	public ChargeForAuditParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeForAuditParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tFromDt = (JSPUtil.getParameter(request, prefix	+ "t_from_dt", length));
			String[] vessel = (JSPUtil.getParameter(request, prefix	+ "vessel", length));
			String[] tOver = (JSPUtil.getParameter(request, prefix	+ "t_over", length));
			String[] pLoadOptInput = (JSPUtil.getParameter(request, prefix	+ "p_load_opt_input", length));
			String[] tCollection = (JSPUtil.getParameter(request, prefix	+ "t_collection", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pFmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "p_fm_mvmt_yd_cd", length));
			String[] pLoadInput = (JSPUtil.getParameter(request, prefix	+ "p_load_input", length));
			String[] pOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_ofc_cd", length));
			String[] voyage = (JSPUtil.getParameter(request, prefix	+ "voyage", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] tFtEnd = (JSPUtil.getParameter(request, prefix	+ "t_ft_end", length));
			String[] pDmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "p_dmdt_trf_cd", length));
			String[] tToDt = (JSPUtil.getParameter(request, prefix	+ "t_to_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeForAuditParmVO();
				if (tFromDt[i] != null)
					model.setTFromDt(tFromDt[i]);
				if (vessel[i] != null)
					model.setVessel(vessel[i]);
				if (tOver[i] != null)
					model.setTOver(tOver[i]);
				if (pLoadOptInput[i] != null)
					model.setPLoadOptInput(pLoadOptInput[i]);
				if (tCollection[i] != null)
					model.setTCollection(tCollection[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pFmMvmtYdCd[i] != null)
					model.setPFmMvmtYdCd(pFmMvmtYdCd[i]);
				if (pLoadInput[i] != null)
					model.setPLoadInput(pLoadInput[i]);
				if (pOfcCd[i] != null)
					model.setPOfcCd(pOfcCd[i]);
				if (voyage[i] != null)
					model.setVoyage(voyage[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (tFtEnd[i] != null)
					model.setTFtEnd(tFtEnd[i]);
				if (pDmdtTrfCd[i] != null)
					model.setPDmdtTrfCd(pDmdtTrfCd[i]);
				if (tToDt[i] != null)
					model.setTToDt(tToDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeForAuditParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeForAuditParmVO[]
	 */
	public ChargeForAuditParmVO[] getChargeForAuditParmVOs(){
		ChargeForAuditParmVO[] vos = (ChargeForAuditParmVO[])models.toArray(new ChargeForAuditParmVO[models.size()]);
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
		this.tFromDt = this.tFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vessel = this.vessel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tOver = this.tOver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLoadOptInput = this.pLoadOptInput .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCollection = this.tCollection .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pFmMvmtYdCd = this.pFmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pLoadInput = this.pLoadInput .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pOfcCd = this.pOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyage = this.voyage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tFtEnd = this.tFtEnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDmdtTrfCd = this.pDmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tToDt = this.tToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
