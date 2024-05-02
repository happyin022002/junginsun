/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomWarrantyAlertListVO.java
*@FileTitle : CustomWarrantyAlertListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.08 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomWarrantyAlertListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomWarrantyAlertListVO> models = new ArrayList<CustomWarrantyAlertListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mnrGrpTpCd = null;
	/* Column Info */
	private String fmSerNo = null;
	/* Column Info */
	private String eqMdlNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String serFrefix = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toWarrDt = null;
	/* Column Info */
	private String fmWarrDt = null;
	/* Column Info */
	private String eqQty = null;
	/* Column Info */
	private String warrRmk = null;
	/* Column Info */
	private String lotEqPfxCd = null;
	/* Column Info */
	private String mnrDispSelFlg = null;
	/* Column Info */
	private String toSerNo = null;
	/* Column Info */
	private String mftYr = null;
	/* Column Info */
	private String eqMkrNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomWarrantyAlertListVO() {}

	/**
	 * CustomWarrantyAlertListVO을 생성함 
	 */    
	public CustomWarrantyAlertListVO(String ibflag, String pagerows, String lotEqPfxCd, String fmSerNo, String serFrefix, String toSerNo, String mnrGrpTpCd, String eqKndCd, String eqTpszCd, String eqMkrNm, String eqMdlNm, String mnrDispSelFlg, String fmWarrDt, String toWarrDt, String warrRmk, String mftYr, String eqQty, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.mnrGrpTpCd = mnrGrpTpCd;
		this.fmSerNo = fmSerNo;
		this.eqMdlNm = eqMdlNm;
		this.creDt = creDt;
		this.serFrefix = serFrefix;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
		this.eqTpszCd = eqTpszCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.toWarrDt = toWarrDt;
		this.fmWarrDt = fmWarrDt;
		this.eqQty = eqQty;
		this.warrRmk = warrRmk;
		this.lotEqPfxCd = lotEqPfxCd;
		this.mnrDispSelFlg = mnrDispSelFlg;
		this.toSerNo = toSerNo;
		this.mftYr = mftYr;
		this.eqMkrNm = eqMkrNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mnr_grp_tp_cd", getMnrGrpTpCd());
		this.hashColumns.put("fm_ser_no", getFmSerNo());
		this.hashColumns.put("eq_mdl_nm", getEqMdlNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ser_frefix", getSerFrefix());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_warr_dt", getToWarrDt());
		this.hashColumns.put("fm_warr_dt", getFmWarrDt());
		this.hashColumns.put("eq_qty", getEqQty());
		this.hashColumns.put("warr_rmk", getWarrRmk());
		this.hashColumns.put("lot_eq_pfx_cd", getLotEqPfxCd());
		this.hashColumns.put("mnr_disp_sel_flg", getMnrDispSelFlg());
		this.hashColumns.put("to_ser_no", getToSerNo());
		this.hashColumns.put("mft_yr", getMftYr());
		this.hashColumns.put("eq_mkr_nm", getEqMkrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mnr_grp_tp_cd", "mnrGrpTpCd");
		this.hashFields.put("fm_ser_no", "fmSerNo");
		this.hashFields.put("eq_mdl_nm", "eqMdlNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ser_frefix", "serFrefix");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_warr_dt", "toWarrDt");
		this.hashFields.put("fm_warr_dt", "fmWarrDt");
		this.hashFields.put("eq_qty", "eqQty");
		this.hashFields.put("warr_rmk", "warrRmk");
		this.hashFields.put("lot_eq_pfx_cd", "lotEqPfxCd");
		this.hashFields.put("mnr_disp_sel_flg", "mnrDispSelFlg");
		this.hashFields.put("to_ser_no", "toSerNo");
		this.hashFields.put("mft_yr", "mftYr");
		this.hashFields.put("eq_mkr_nm", "eqMkrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
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
	 * @return mnrGrpTpCd
	 */
	public String getMnrGrpTpCd() {
		return this.mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return fmSerNo
	 */
	public String getFmSerNo() {
		return this.fmSerNo;
	}
	
	/**
	 * Column Info
	 * @return eqMdlNm
	 */
	public String getEqMdlNm() {
		return this.eqMdlNm;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return serFrefix
	 */
	public String getSerFrefix() {
		return this.serFrefix;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return toWarrDt
	 */
	public String getToWarrDt() {
		return this.toWarrDt;
	}
	
	/**
	 * Column Info
	 * @return fmWarrDt
	 */
	public String getFmWarrDt() {
		return this.fmWarrDt;
	}
	
	/**
	 * Column Info
	 * @return eqQty
	 */
	public String getEqQty() {
		return this.eqQty;
	}
	
	/**
	 * Column Info
	 * @return warrRmk
	 */
	public String getWarrRmk() {
		return this.warrRmk;
	}
	
	/**
	 * Column Info
	 * @return lotEqPfxCd
	 */
	public String getLotEqPfxCd() {
		return this.lotEqPfxCd;
	}
	
	/**
	 * Column Info
	 * @return mnrDispSelFlg
	 */
	public String getMnrDispSelFlg() {
		return this.mnrDispSelFlg;
	}
	
	/**
	 * Column Info
	 * @return toSerNo
	 */
	public String getToSerNo() {
		return this.toSerNo;
	}
	
	/**
	 * Column Info
	 * @return mftYr
	 */
	public String getMftYr() {
		return this.mftYr;
	}
	
	/**
	 * Column Info
	 * @return eqMkrNm
	 */
	public String getEqMkrNm() {
		return this.eqMkrNm;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param mnrGrpTpCd
	 */
	public void setMnrGrpTpCd(String mnrGrpTpCd) {
		this.mnrGrpTpCd = mnrGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param fmSerNo
	 */
	public void setFmSerNo(String fmSerNo) {
		this.fmSerNo = fmSerNo;
	}
	
	/**
	 * Column Info
	 * @param eqMdlNm
	 */
	public void setEqMdlNm(String eqMdlNm) {
		this.eqMdlNm = eqMdlNm;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param serFrefix
	 */
	public void setSerFrefix(String serFrefix) {
		this.serFrefix = serFrefix;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param toWarrDt
	 */
	public void setToWarrDt(String toWarrDt) {
		this.toWarrDt = toWarrDt;
	}
	
	/**
	 * Column Info
	 * @param fmWarrDt
	 */
	public void setFmWarrDt(String fmWarrDt) {
		this.fmWarrDt = fmWarrDt;
	}
	
	/**
	 * Column Info
	 * @param eqQty
	 */
	public void setEqQty(String eqQty) {
		this.eqQty = eqQty;
	}
	
	/**
	 * Column Info
	 * @param warrRmk
	 */
	public void setWarrRmk(String warrRmk) {
		this.warrRmk = warrRmk;
	}
	
	/**
	 * Column Info
	 * @param lotEqPfxCd
	 */
	public void setLotEqPfxCd(String lotEqPfxCd) {
		this.lotEqPfxCd = lotEqPfxCd;
	}
	
	/**
	 * Column Info
	 * @param mnrDispSelFlg
	 */
	public void setMnrDispSelFlg(String mnrDispSelFlg) {
		this.mnrDispSelFlg = mnrDispSelFlg;
	}
	
	/**
	 * Column Info
	 * @param toSerNo
	 */
	public void setToSerNo(String toSerNo) {
		this.toSerNo = toSerNo;
	}
	
	/**
	 * Column Info
	 * @param mftYr
	 */
	public void setMftYr(String mftYr) {
		this.mftYr = mftYr;
	}
	
	/**
	 * Column Info
	 * @param eqMkrNm
	 */
	public void setEqMkrNm(String eqMkrNm) {
		this.eqMkrNm = eqMkrNm;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setMnrGrpTpCd(JSPUtil.getParameter(request, "mnr_grp_tp_cd", ""));
		setFmSerNo(JSPUtil.getParameter(request, "fm_ser_no", ""));
		setEqMdlNm(JSPUtil.getParameter(request, "eq_mdl_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setSerFrefix(JSPUtil.getParameter(request, "ser_frefix", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToWarrDt(JSPUtil.getParameter(request, "to_warr_dt", ""));
		setFmWarrDt(JSPUtil.getParameter(request, "fm_warr_dt", ""));
		setEqQty(JSPUtil.getParameter(request, "eq_qty", ""));
		setWarrRmk(JSPUtil.getParameter(request, "warr_rmk", ""));
		setLotEqPfxCd(JSPUtil.getParameter(request, "lot_eq_pfx_cd", ""));
		setMnrDispSelFlg(JSPUtil.getParameter(request, "mnr_disp_sel_flg", ""));
		setToSerNo(JSPUtil.getParameter(request, "to_ser_no", ""));
		setMftYr(JSPUtil.getParameter(request, "mft_yr", ""));
		setEqMkrNm(JSPUtil.getParameter(request, "eq_mkr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomWarrantyAlertListVO[]
	 */
	public CustomWarrantyAlertListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomWarrantyAlertListVO[]
	 */
	public CustomWarrantyAlertListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomWarrantyAlertListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] mnrGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_grp_tp_cd".trim(), length));
			String[] fmSerNo = (JSPUtil.getParameter(request, prefix	+ "fm_ser_no".trim(), length));
			String[] eqMdlNm = (JSPUtil.getParameter(request, prefix	+ "eq_mdl_nm".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] serFrefix = (JSPUtil.getParameter(request, prefix	+ "ser_frefix".trim(), length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] toWarrDt = (JSPUtil.getParameter(request, prefix	+ "to_warr_dt".trim(), length));
			String[] fmWarrDt = (JSPUtil.getParameter(request, prefix	+ "fm_warr_dt".trim(), length));
			String[] eqQty = (JSPUtil.getParameter(request, prefix	+ "eq_qty".trim(), length));
			String[] warrRmk = (JSPUtil.getParameter(request, prefix	+ "warr_rmk".trim(), length));
			String[] lotEqPfxCd = (JSPUtil.getParameter(request, prefix	+ "lot_eq_pfx_cd".trim(), length));
			String[] mnrDispSelFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_sel_flg".trim(), length));
			String[] toSerNo = (JSPUtil.getParameter(request, prefix	+ "to_ser_no".trim(), length));
			String[] mftYr = (JSPUtil.getParameter(request, prefix	+ "mft_yr".trim(), length));
			String[] eqMkrNm = (JSPUtil.getParameter(request, prefix	+ "eq_mkr_nm".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomWarrantyAlertListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mnrGrpTpCd[i] != null)
					model.setMnrGrpTpCd(mnrGrpTpCd[i]);
				if (fmSerNo[i] != null)
					model.setFmSerNo(fmSerNo[i]);
				if (eqMdlNm[i] != null)
					model.setEqMdlNm(eqMdlNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (serFrefix[i] != null)
					model.setSerFrefix(serFrefix[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toWarrDt[i] != null)
					model.setToWarrDt(toWarrDt[i]);
				if (fmWarrDt[i] != null)
					model.setFmWarrDt(fmWarrDt[i]);
				if (eqQty[i] != null)
					model.setEqQty(eqQty[i]);
				if (warrRmk[i] != null)
					model.setWarrRmk(warrRmk[i]);
				if (lotEqPfxCd[i] != null)
					model.setLotEqPfxCd(lotEqPfxCd[i]);
				if (mnrDispSelFlg[i] != null)
					model.setMnrDispSelFlg(mnrDispSelFlg[i]);
				if (toSerNo[i] != null)
					model.setToSerNo(toSerNo[i]);
				if (mftYr[i] != null)
					model.setMftYr(mftYr[i]);
				if (eqMkrNm[i] != null)
					model.setEqMkrNm(eqMkrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomWarrantyAlertListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomWarrantyAlertListVO[]
	 */
	public CustomWarrantyAlertListVO[] getCustomWarrantyAlertListVOs(){
		CustomWarrantyAlertListVO[] vos = (CustomWarrantyAlertListVO[])models.toArray(new CustomWarrantyAlertListVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrGrpTpCd = this.mnrGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSerNo = this.fmSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqMdlNm = this.eqMdlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serFrefix = this.serFrefix .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWarrDt = this.toWarrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmWarrDt = this.fmWarrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqQty = this.eqQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.warrRmk = this.warrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotEqPfxCd = this.lotEqPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispSelFlg = this.mnrDispSelFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSerNo = this.toSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftYr = this.mftYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqMkrNm = this.eqMkrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
