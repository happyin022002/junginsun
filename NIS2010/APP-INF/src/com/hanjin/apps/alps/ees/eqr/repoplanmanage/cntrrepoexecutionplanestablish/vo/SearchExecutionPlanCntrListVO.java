/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchExecutionPlanCntrListVO.java
*@FileTitle : SearchExecutionPlanCntrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.21 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;

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
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchExecutionPlanCntrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchExecutionPlanCntrListVO> models = new ArrayList<SearchExecutionPlanCntrListVO>();
	
	/* Column Info */
	private String cntrUseCoCd = null;
	/* Column Info */
	private String dmgFlg = null;
	/* Column Info */
	private String plstFlrFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dispFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String rfubFlg = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String rfTpCdC = null;
	/* Column Info */
	private String imdtExtFlg = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	/* Column Info */
	private String cntrHngrBarAtchKnt = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String rfTpCdH = null;
	/* Column Info */
	private String cntrHngrRckCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchExecutionPlanCntrListVO() {}

	public SearchExecutionPlanCntrListVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String lstmCd, String mvmtStsCd, String vndrAbbrNm, String cntrUseCoCd, String dmgFlg, String cntrHngrRckCd, String cntrHngrBarAtchKnt, String rfubFlg, String dispFlg, String plstFlrFlg, String imdtExtFlg, String rfTpCdC, String rfTpCdH) {
		this.cntrUseCoCd = cntrUseCoCd;
		this.dmgFlg = dmgFlg;
		this.plstFlrFlg = plstFlrFlg;
		this.pagerows = pagerows;
		this.dispFlg = dispFlg;
		this.ibflag = ibflag;
		this.mvmtStsCd = mvmtStsCd;
		this.rfubFlg = rfubFlg;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.rfTpCdC = rfTpCdC;
		this.imdtExtFlg = imdtExtFlg;
		this.vndrAbbrNm = vndrAbbrNm;
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
		this.lstmCd = lstmCd;
		this.rfTpCdH = rfTpCdH;
		this.cntrHngrRckCd = cntrHngrRckCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_use_co_cd", getCntrUseCoCd());
		this.hashColumns.put("dmg_flg", getDmgFlg());
		this.hashColumns.put("plst_flr_flg", getPlstFlrFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("disp_flg", getDispFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("rfub_flg", getRfubFlg());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("rf_tp_cd_c", getRfTpCdC());
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("rf_tp_cd_h", getRfTpCdH());
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_use_co_cd", "cntrUseCoCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("plst_flr_flg", "plstFlrFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("rfub_flg", "rfubFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("rf_tp_cd_c", "rfTpCdC");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("rf_tp_cd_h", "rfTpCdH");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrUseCoCd
	 */
	public String getCntrUseCoCd() {
		return this.cntrUseCoCd;
	}
	
	/**
	 * Column Info
	 * @return dmgFlg
	 */
	public String getDmgFlg() {
		return this.dmgFlg;
	}
	
	/**
	 * Column Info
	 * @return plstFlrFlg
	 */
	public String getPlstFlrFlg() {
		return this.plstFlrFlg;
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
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return this.dispFlg;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return rfubFlg
	 */
	public String getRfubFlg() {
		return this.rfubFlg;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return rfTpCdC
	 */
	public String getRfTpCdC() {
		return this.rfTpCdC;
	}
	
	/**
	 * Column Info
	 * @return imdtExtFlg
	 */
	public String getImdtExtFlg() {
		return this.imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrBarAtchKnt
	 */
	public String getCntrHngrBarAtchKnt() {
		return this.cntrHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return rfTpCdH
	 */
	public String getRfTpCdH() {
		return this.rfTpCdH;
	}
	
	/**
	 * Column Info
	 * @return cntrHngrRckCd
	 */
	public String getCntrHngrRckCd() {
		return this.cntrHngrRckCd;
	}
	

	/**
	 * Column Info
	 * @param cntrUseCoCd
	 */
	public void setCntrUseCoCd(String cntrUseCoCd) {
		this.cntrUseCoCd = cntrUseCoCd;
	}
	
	/**
	 * Column Info
	 * @param dmgFlg
	 */
	public void setDmgFlg(String dmgFlg) {
		this.dmgFlg = dmgFlg;
	}
	
	/**
	 * Column Info
	 * @param plstFlrFlg
	 */
	public void setPlstFlrFlg(String plstFlrFlg) {
		this.plstFlrFlg = plstFlrFlg;
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
	 * @param dispFlg
	 */
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param rfubFlg
	 */
	public void setRfubFlg(String rfubFlg) {
		this.rfubFlg = rfubFlg;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param rfTpCdC
	 */
	public void setRfTpCdC(String rfTpCdC) {
		this.rfTpCdC = rfTpCdC;
	}
	
	/**
	 * Column Info
	 * @param imdtExtFlg
	 */
	public void setImdtExtFlg(String imdtExtFlg) {
		this.imdtExtFlg = imdtExtFlg;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrBarAtchKnt
	 */
	public void setCntrHngrBarAtchKnt(String cntrHngrBarAtchKnt) {
		this.cntrHngrBarAtchKnt = cntrHngrBarAtchKnt;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param rfTpCdH
	 */
	public void setRfTpCdH(String rfTpCdH) {
		this.rfTpCdH = rfTpCdH;
	}
	
	/**
	 * Column Info
	 * @param cntrHngrRckCd
	 */
	public void setCntrHngrRckCd(String cntrHngrRckCd) {
		this.cntrHngrRckCd = cntrHngrRckCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntrUseCoCd(JSPUtil.getParameter(request, "cntr_use_co_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request, "dmg_flg", ""));
		setPlstFlrFlg(JSPUtil.getParameter(request, "plst_flr_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDispFlg(JSPUtil.getParameter(request, "disp_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setRfubFlg(JSPUtil.getParameter(request, "rfub_flg", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setRfTpCdC(JSPUtil.getParameter(request, "rf_tp_cd_c", ""));
		setImdtExtFlg(JSPUtil.getParameter(request, "imdt_ext_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request, "cntr_hngr_bar_atch_knt", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setRfTpCdH(JSPUtil.getParameter(request, "rf_tp_cd_h", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request, "cntr_hngr_rck_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchExecutionPlanCntrListVO[]
	 */
	public SearchExecutionPlanCntrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchExecutionPlanCntrListVO[]
	 */
	public SearchExecutionPlanCntrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchExecutionPlanCntrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrUseCoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_use_co_cd", length));
			String[] dmgFlg = (JSPUtil.getParameter(request, prefix	+ "dmg_flg", length));
			String[] plstFlrFlg = (JSPUtil.getParameter(request, prefix	+ "plst_flr_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dispFlg = (JSPUtil.getParameter(request, prefix	+ "disp_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] rfubFlg = (JSPUtil.getParameter(request, prefix	+ "rfub_flg", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] rfTpCdC = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd_c", length));
			String[] imdtExtFlg = (JSPUtil.getParameter(request, prefix	+ "imdt_ext_flg", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			String[] cntrHngrBarAtchKnt = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_bar_atch_knt", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] rfTpCdH = (JSPUtil.getParameter(request, prefix	+ "rf_tp_cd_h", length));
			String[] cntrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "cntr_hngr_rck_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchExecutionPlanCntrListVO();
				if (cntrUseCoCd[i] != null)
					model.setCntrUseCoCd(cntrUseCoCd[i]);
				if (dmgFlg[i] != null)
					model.setDmgFlg(dmgFlg[i]);
				if (plstFlrFlg[i] != null)
					model.setPlstFlrFlg(plstFlrFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dispFlg[i] != null)
					model.setDispFlg(dispFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (rfubFlg[i] != null)
					model.setRfubFlg(rfubFlg[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (rfTpCdC[i] != null)
					model.setRfTpCdC(rfTpCdC[i]);
				if (imdtExtFlg[i] != null)
					model.setImdtExtFlg(imdtExtFlg[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				if (cntrHngrBarAtchKnt[i] != null)
					model.setCntrHngrBarAtchKnt(cntrHngrBarAtchKnt[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (rfTpCdH[i] != null)
					model.setRfTpCdH(rfTpCdH[i]);
				if (cntrHngrRckCd[i] != null)
					model.setCntrHngrRckCd(cntrHngrRckCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchExecutionPlanCntrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchExecutionPlanCntrListVO[]
	 */
	public SearchExecutionPlanCntrListVO[] getSearchExecutionPlanCntrListVOs(){
		SearchExecutionPlanCntrListVO[] vos = (SearchExecutionPlanCntrListVO[])models.toArray(new SearchExecutionPlanCntrListVO[models.size()]);
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
		this.cntrUseCoCd = this.cntrUseCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg = this.dmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plstFlrFlg = this.plstFlrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg = this.dispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfubFlg = this.rfubFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCdC = this.rfTpCdC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg = this.imdtExtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt = this.cntrHngrBarAtchKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCdH = this.rfTpCdH .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd = this.cntrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
