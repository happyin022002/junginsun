/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UnissuedInvoiceByAgingParmVO.java
*@FileTitle : UnissuedInvoiceByAgingParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.19
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.05.19 김기태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo;

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
 * @author 김기태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UnissuedInvoiceByAgingParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UnissuedInvoiceByAgingParmVO> models = new ArrayList<UnissuedInvoiceByAgingParmVO>();
	
	/* Column Info */
	private String endDt = null;
	/* Column Info */
	private String dmdtCntrTpCd = null;
	/* Column Info */
	private String chgFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcFlg = null;
	/* Column Info */
	private String ioBndFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String currFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grpFlg = null;
	/* Column Info */
	private String startDt = null;
	/* Column Info */
	private String dtlFlg = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String uclmFlg = null;
	/* Column Info */
	private String dmdtChgStsCd = null;
	
	/* Column Info */
	private String bzcTrfCurrCd  = null;
	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UnissuedInvoiceByAgingParmVO() {}

	public UnissuedInvoiceByAgingParmVO(String ibflag, String pagerows, String grpFlg, String ofcFlg, String dmdtCntrTpCd, String startDt, String endDt, String ofcCd, String currFlg, String dmdtTrfCd, String dtlFlg, String chgFlg, String ioBndFlg, String uclmFlg, String dmdtChgStsCd, String bzcTrfCurrCd ) {
		this.endDt = endDt;
		this.dmdtCntrTpCd = dmdtCntrTpCd;
		this.chgFlg = chgFlg;
		this.pagerows = pagerows;
		this.ofcFlg = ofcFlg;
		this.ioBndFlg = ioBndFlg;
		this.ofcCd = ofcCd;
		this.currFlg = currFlg;
		this.ibflag = ibflag;
		this.grpFlg = grpFlg;
		this.startDt = startDt;
		this.dtlFlg = dtlFlg;
		this.dmdtTrfCd = dmdtTrfCd;
		this.uclmFlg = uclmFlg;
		this.dmdtChgStsCd = dmdtChgStsCd;
		
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("end_dt", getEndDt());
		this.hashColumns.put("dmdt_cntr_tp_cd", getDmdtCntrTpCd());
		this.hashColumns.put("chg_flg", getChgFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_flg", getOfcFlg());
		this.hashColumns.put("io_bnd_flg", getIoBndFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("curr_flg", getCurrFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp_flg", getGrpFlg());
		this.hashColumns.put("start_dt", getStartDt());
		this.hashColumns.put("dtl_flg", getDtlFlg());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("uclm_flg", getUclmFlg());
		this.hashColumns.put("dmdt_chg_sts_cd", getDmdtChgStsCd());
		
		this.hashColumns.put("bzc_trf_curr_cd", getBzcTrfCurrCd ());
		
		return this.hashColumns;
	}
	

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("end_dt", "endDt");
		this.hashFields.put("dmdt_cntr_tp_cd", "dmdtCntrTpCd");
		this.hashFields.put("chg_flg", "chgFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_flg", "ofcFlg");
		this.hashFields.put("io_bnd_flg", "ioBndFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("curr_flg", "currFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp_flg", "grpFlg");
		this.hashFields.put("start_dt", "startDt");
		this.hashFields.put("dtl_flg", "dtlFlg");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("uclm_flg", "uclmFlg");
		this.hashFields.put("dmdt_chg_sts_cd", "dmdtChgStsCd");
		
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");

		return this.hashFields;
	}
	
	/**
	 * @return the bzcTrfCurrCd
	 */
	public String getBzcTrfCurrCd() {
		return bzcTrfCurrCd;
	}

	/**
	 * @param bzcTrfCurrCd the bzcTrfCurrCd to set
	 */
	public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
	}

	
	/**
	 * Column Info
	 * @return endDt
	 */
	public String getEndDt() {
		return this.endDt;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrTpCd
	 */
	public String getDmdtCntrTpCd() {
		return this.dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @return chgFlg
	 */
	public String getChgFlg() {
		return this.chgFlg;
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
	 * @return ofcFlg
	 */
	public String getOfcFlg() {
		return this.ofcFlg;
	}
	
	/**
	 * Column Info
	 * @return ioBndFlg
	 */
	public String getIoBndFlg() {
		return this.ioBndFlg;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return currFlg
	 */
	public String getCurrFlg() {
		return this.currFlg;
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
	 * @return grpFlg
	 */
	public String getGrpFlg() {
		return this.grpFlg;
	}
	
	/**
	 * Column Info
	 * @return startDt
	 */
	public String getStartDt() {
		return this.startDt;
	}
	
	/**
	 * Column Info
	 * @return dtlFlg
	 */
	public String getDtlFlg() {
		return this.dtlFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return uclmFlg
	 */
	public String getUclmFlg() {
		return this.uclmFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgStsCd
	 */	
	public String getDmdtChgStsCd() {
		return dmdtChgStsCd;
	}

	/**
	 * Column Info
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrTpCd
	 */
	public void setDmdtCntrTpCd(String dmdtCntrTpCd) {
		this.dmdtCntrTpCd = dmdtCntrTpCd;
	}
	
	/**
	 * Column Info
	 * @param chgFlg
	 */
	public void setChgFlg(String chgFlg) {
		this.chgFlg = chgFlg;
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
	 * @param ofcFlg
	 */
	public void setOfcFlg(String ofcFlg) {
		this.ofcFlg = ofcFlg;
	}
	
	/**
	 * Column Info
	 * @param ioBndFlg
	 */
	public void setIoBndFlg(String ioBndFlg) {
		this.ioBndFlg = ioBndFlg;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param currFlg
	 */
	public void setCurrFlg(String currFlg) {
		this.currFlg = currFlg;
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
	 * @param grpFlg
	 */
	public void setGrpFlg(String grpFlg) {
		this.grpFlg = grpFlg;
	}
	
	/**
	 * Column Info
	 * @param startDt
	 */
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	
	/**
	 * Column Info
	 * @param dtlFlg
	 */
	public void setDtlFlg(String dtlFlg) {
		this.dtlFlg = dtlFlg;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param uclmFlg
	 */
	public void setUclmFlg(String uclmFlg) {
		this.uclmFlg = uclmFlg;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgStsCd
	 */
	public void setDmdtChgStsCd(String dmdtChgStsCd) {
		this.dmdtChgStsCd = dmdtChgStsCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEndDt(JSPUtil.getParameter(request, "end_dt", ""));
		setDmdtCntrTpCd(JSPUtil.getParameter(request, "dmdt_cntr_tp_cd", ""));
		setChgFlg(JSPUtil.getParameter(request, "chg_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOfcFlg(JSPUtil.getParameter(request, "ofc_flg", ""));
		setIoBndFlg(JSPUtil.getParameter(request, "io_bnd_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCurrFlg(JSPUtil.getParameter(request, "curr_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGrpFlg(JSPUtil.getParameter(request, "grp_flg", ""));
		setStartDt(JSPUtil.getParameter(request, "start_dt", ""));
		setDtlFlg(JSPUtil.getParameter(request, "dtl_flg", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setUclmFlg(JSPUtil.getParameter(request, "uclm_flg", ""));
		setDmdtChgStsCd(JSPUtil.getParameter(request, "dmdt_chg_sts_cd", ""));
		
		setBzcTrfCurrCd(JSPUtil.getParameter(request, "bzc_trf_curr_cd", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CollectionReportParmVO[]
	 */
	public UnissuedInvoiceByAgingParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CollectionReportParmVO[]
	 */
	public UnissuedInvoiceByAgingParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UnissuedInvoiceByAgingParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] endDt = (JSPUtil.getParameter(request, prefix	+ "end_dt", length));
			String[] dmdtCntrTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_tp_cd", length));
			String[] chgFlg = (JSPUtil.getParameter(request, prefix	+ "chg_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_flg", length));
			String[] ioBndFlg = (JSPUtil.getParameter(request, prefix	+ "io_bnd_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] currFlg = (JSPUtil.getParameter(request, prefix	+ "curr_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grpFlg = (JSPUtil.getParameter(request, prefix	+ "grp_flg", length));
			String[] startDt = (JSPUtil.getParameter(request, prefix	+ "start_dt", length));
			String[] dtlFlg = (JSPUtil.getParameter(request, prefix	+ "dtl_flg", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] uclmFlg = (JSPUtil.getParameter(request, prefix	+ "uclm_flg", length));
			String[] dmdtChgStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_sts_cd", length));
			
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzc_trf_curr_cd", length));

			
			for (int i = 0; i < length; i++) {
				model = new UnissuedInvoiceByAgingParmVO();
				if (endDt[i] != null)
					model.setEndDt(endDt[i]);
				if (dmdtCntrTpCd[i] != null)
					model.setDmdtCntrTpCd(dmdtCntrTpCd[i]);
				if (chgFlg[i] != null)
					model.setChgFlg(chgFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcFlg[i] != null)
					model.setOfcFlg(ofcFlg[i]);
				if (ioBndFlg[i] != null)
					model.setIoBndFlg(ioBndFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (currFlg[i] != null)
					model.setCurrFlg(currFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grpFlg[i] != null)
					model.setGrpFlg(grpFlg[i]);
				if (startDt[i] != null)
					model.setStartDt(startDt[i]);
				if (dtlFlg[i] != null)
					model.setDtlFlg(dtlFlg[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (uclmFlg[i] != null)
					model.setUclmFlg(uclmFlg[i]);
				if (dmdtChgStsCd[i] != null)
					model.setDmdtChgStsCd(dmdtChgStsCd[i]);
				
				if (bzcTrfCurrCd [i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUnissuedInvoiceByAgingParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CollectionReportParmVO[]
	 */
	public UnissuedInvoiceByAgingParmVO[] getUnissuedInvoiceByAgingParmVOs(){
		UnissuedInvoiceByAgingParmVO[] vos = (UnissuedInvoiceByAgingParmVO[])models.toArray(new UnissuedInvoiceByAgingParmVO[models.size()]);
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
		this.endDt = this.endDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrTpCd = this.dmdtCntrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFlg = this.chgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFlg = this.ofcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndFlg = this.ioBndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currFlg = this.currFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpFlg = this.grpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startDt = this.startDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlFlg = this.dtlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmFlg = this.uclmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgStsCd = this.dmdtChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.bzcTrfCurrCd  = this.bzcTrfCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		
	}
}
