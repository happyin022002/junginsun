/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrDispTrfHdrVO.java
*@FileTitle : CustomMnrDispTrfHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo;

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

public class CustomMnrDispTrfHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrDispTrfHdrVO> models = new ArrayList<CustomMnrDispTrfHdrVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mnrDispTrfSeq = null;
	/* Column Info */
	private String mnrInpTpCd = null;
	/* Column Info */
	private String mnrDispTrfStsDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mnrDispTrfTpCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String mnrDispTrfLstVerFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrDispTrfStsCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String mnrTrfRmk = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mnrDispTrfTpNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrDispTrfHdrVO() {}

	public CustomMnrDispTrfHdrVO(String ibflag, String pagerows, String mnrDispTrfSeq, String effDt, String eqKndCd, String mnrDispTrfTpCd, String mnrDispTrfTpNm, String mnrInpTpCd, String mnrDispTrfStsCd, String mnrDispTrfStsDt, String mnrTrfRmk, String mnrDispTrfLstVerFlg, String creOfcCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.mnrDispTrfSeq = mnrDispTrfSeq;
		this.mnrInpTpCd = mnrInpTpCd;
		this.mnrDispTrfStsDt = mnrDispTrfStsDt;
		this.creDt = creDt;
		this.mnrDispTrfTpCd = mnrDispTrfTpCd;
		this.eqKndCd = eqKndCd;
		this.mnrDispTrfLstVerFlg = mnrDispTrfLstVerFlg;
		this.pagerows = pagerows;
		this.mnrDispTrfStsCd = mnrDispTrfStsCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.mnrTrfRmk = mnrTrfRmk;
		this.creOfcCd = creOfcCd;
		this.updUsrId = updUsrId;
		this.mnrDispTrfTpNm = mnrDispTrfTpNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mnr_disp_trf_seq", getMnrDispTrfSeq());
		this.hashColumns.put("mnr_inp_tp_cd", getMnrInpTpCd());
		this.hashColumns.put("mnr_disp_trf_sts_dt", getMnrDispTrfStsDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mnr_disp_trf_tp_cd", getMnrDispTrfTpCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("mnr_disp_trf_lst_ver_flg", getMnrDispTrfLstVerFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_disp_trf_sts_cd", getMnrDispTrfStsCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("mnr_trf_rmk", getMnrTrfRmk());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mnr_disp_trf_tp_nm", getMnrDispTrfTpNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mnr_disp_trf_seq", "mnrDispTrfSeq");
		this.hashFields.put("mnr_inp_tp_cd", "mnrInpTpCd");
		this.hashFields.put("mnr_disp_trf_sts_dt", "mnrDispTrfStsDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_disp_trf_tp_cd", "mnrDispTrfTpCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("mnr_disp_trf_lst_ver_flg", "mnrDispTrfLstVerFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_disp_trf_sts_cd", "mnrDispTrfStsCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("mnr_trf_rmk", "mnrTrfRmk");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mnr_disp_trf_tp_nm", "mnrDispTrfTpNm");
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
	 * @return mnrDispTrfSeq
	 */
	public String getMnrDispTrfSeq() {
		return this.mnrDispTrfSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrInpTpCd
	 */
	public String getMnrInpTpCd() {
		return this.mnrInpTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrDispTrfStsDt
	 */
	public String getMnrDispTrfStsDt() {
		return this.mnrDispTrfStsDt;
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
	 * @return mnrDispTrfTpCd
	 */
	public String getMnrDispTrfTpCd() {
		return this.mnrDispTrfTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return mnrDispTrfLstVerFlg
	 */
	public String getMnrDispTrfLstVerFlg() {
		return this.mnrDispTrfLstVerFlg;
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
	 * @return mnrDispTrfStsCd
	 */
	public String getMnrDispTrfStsCd() {
		return this.mnrDispTrfStsCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return mnrTrfRmk
	 */
	public String getMnrTrfRmk() {
		return this.mnrTrfRmk;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
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
	 * @return mnrDispTrfTpNm
	 */
	public String getMnrDispTrfTpNm() {
		return this.mnrDispTrfTpNm;
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
	 * @param mnrDispTrfSeq
	 */
	public void setMnrDispTrfSeq(String mnrDispTrfSeq) {
		this.mnrDispTrfSeq = mnrDispTrfSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrInpTpCd
	 */
	public void setMnrInpTpCd(String mnrInpTpCd) {
		this.mnrInpTpCd = mnrInpTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrDispTrfStsDt
	 */
	public void setMnrDispTrfStsDt(String mnrDispTrfStsDt) {
		this.mnrDispTrfStsDt = mnrDispTrfStsDt;
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
	 * @param mnrDispTrfTpCd
	 */
	public void setMnrDispTrfTpCd(String mnrDispTrfTpCd) {
		this.mnrDispTrfTpCd = mnrDispTrfTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param mnrDispTrfLstVerFlg
	 */
	public void setMnrDispTrfLstVerFlg(String mnrDispTrfLstVerFlg) {
		this.mnrDispTrfLstVerFlg = mnrDispTrfLstVerFlg;
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
	 * @param mnrDispTrfStsCd
	 */
	public void setMnrDispTrfStsCd(String mnrDispTrfStsCd) {
		this.mnrDispTrfStsCd = mnrDispTrfStsCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param mnrTrfRmk
	 */
	public void setMnrTrfRmk(String mnrTrfRmk) {
		this.mnrTrfRmk = mnrTrfRmk;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
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
	 * @param mnrDispTrfTpNm
	 */
	public void setMnrDispTrfTpNm(String mnrDispTrfTpNm) {
		this.mnrDispTrfTpNm = mnrDispTrfTpNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setMnrDispTrfSeq(JSPUtil.getParameter(request, "mnr_disp_trf_seq", ""));
		setMnrInpTpCd(JSPUtil.getParameter(request, "mnr_inp_tp_cd", ""));
		setMnrDispTrfStsDt(JSPUtil.getParameter(request, "mnr_disp_trf_sts_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMnrDispTrfTpCd(JSPUtil.getParameter(request, "mnr_disp_trf_tp_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setMnrDispTrfLstVerFlg(JSPUtil.getParameter(request, "mnr_disp_trf_lst_ver_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMnrDispTrfStsCd(JSPUtil.getParameter(request, "mnr_disp_trf_sts_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setMnrTrfRmk(JSPUtil.getParameter(request, "mnr_trf_rmk", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMnrDispTrfTpNm(JSPUtil.getParameter(request, "mnr_disp_trf_tp_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrDispTrfHdrVO[]
	 */
	public CustomMnrDispTrfHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrDispTrfHdrVO[]
	 */
	public CustomMnrDispTrfHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrDispTrfHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mnrDispTrfSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_seq", length));
			String[] mnrInpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inp_tp_cd", length));
			String[] mnrDispTrfStsDt = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_sts_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mnrDispTrfTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_tp_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] mnrDispTrfLstVerFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_lst_ver_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrDispTrfStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_sts_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] mnrTrfRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_rmk", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mnrDispTrfTpNm = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_tp_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrDispTrfHdrVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mnrDispTrfSeq[i] != null)
					model.setMnrDispTrfSeq(mnrDispTrfSeq[i]);
				if (mnrInpTpCd[i] != null)
					model.setMnrInpTpCd(mnrInpTpCd[i]);
				if (mnrDispTrfStsDt[i] != null)
					model.setMnrDispTrfStsDt(mnrDispTrfStsDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mnrDispTrfTpCd[i] != null)
					model.setMnrDispTrfTpCd(mnrDispTrfTpCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (mnrDispTrfLstVerFlg[i] != null)
					model.setMnrDispTrfLstVerFlg(mnrDispTrfLstVerFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrDispTrfStsCd[i] != null)
					model.setMnrDispTrfStsCd(mnrDispTrfStsCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (mnrTrfRmk[i] != null)
					model.setMnrTrfRmk(mnrTrfRmk[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mnrDispTrfTpNm[i] != null)
					model.setMnrDispTrfTpNm(mnrDispTrfTpNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrDispTrfHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrDispTrfHdrVO[]
	 */
	public CustomMnrDispTrfHdrVO[] getCustomMnrDispTrfHdrVOs(){
		CustomMnrDispTrfHdrVO[] vos = (CustomMnrDispTrfHdrVO[])models.toArray(new CustomMnrDispTrfHdrVO[models.size()]);
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
		this.mnrDispTrfSeq = this.mnrDispTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInpTpCd = this.mnrInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfStsDt = this.mnrDispTrfStsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfTpCd = this.mnrDispTrfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfLstVerFlg = this.mnrDispTrfLstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfStsCd = this.mnrDispTrfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfRmk = this.mnrTrfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfTpNm = this.mnrDispTrfTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
