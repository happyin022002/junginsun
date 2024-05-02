/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalTariffINVO.java
*@FileTitle : DisposalTariffINVO
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

public class DisposalTariffINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DisposalTariffINVO> models = new ArrayList<DisposalTariffINVO>();
	
	/* Column Info */
	private String mnrDispTrfGrpCd = null;
	/* Column Info */
	private String mnrDispTrfStsCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String mnrTrfRmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mnrDispTrfSeq = null;
	/* Column Info */
	private String mnrInpTpCd = null;
	/* Column Info */
	private String mnrDispTrfTpCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String mnrDispTrfLstVerFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DisposalTariffINVO() {}

	public DisposalTariffINVO(String ibflag, String pagerows, String mnrDispTrfStsCd, String mnrTrfRmk, String effDt, String mnrDispTrfGrpCd, String mnrDispTrfSeq, String mnrInpTpCd, String mnrDispTrfTpCd, String eqKndCd, String mnrDispTrfLstVerFlg) {
		this.mnrDispTrfGrpCd = mnrDispTrfGrpCd;
		this.mnrDispTrfStsCd = mnrDispTrfStsCd;
		this.effDt = effDt;
		this.mnrTrfRmk = mnrTrfRmk;
		this.ibflag = ibflag;
		this.mnrDispTrfSeq = mnrDispTrfSeq;
		this.mnrInpTpCd = mnrInpTpCd;
		this.mnrDispTrfTpCd = mnrDispTrfTpCd;
		this.eqKndCd = eqKndCd;
		this.mnrDispTrfLstVerFlg = mnrDispTrfLstVerFlg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_disp_trf_grp_cd", getMnrDispTrfGrpCd());
		this.hashColumns.put("mnr_disp_trf_sts_cd", getMnrDispTrfStsCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("mnr_trf_rmk", getMnrTrfRmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mnr_disp_trf_seq", getMnrDispTrfSeq());
		this.hashColumns.put("mnr_inp_tp_cd", getMnrInpTpCd());
		this.hashColumns.put("mnr_disp_trf_tp_cd", getMnrDispTrfTpCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("mnr_disp_trf_lst_ver_flg", getMnrDispTrfLstVerFlg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_disp_trf_grp_cd", "mnrDispTrfGrpCd");
		this.hashFields.put("mnr_disp_trf_sts_cd", "mnrDispTrfStsCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("mnr_trf_rmk", "mnrTrfRmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mnr_disp_trf_seq", "mnrDispTrfSeq");
		this.hashFields.put("mnr_inp_tp_cd", "mnrInpTpCd");
		this.hashFields.put("mnr_disp_trf_tp_cd", "mnrDispTrfTpCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("mnr_disp_trf_lst_ver_flg", "mnrDispTrfLstVerFlg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrDispTrfGrpCd
	 */
	public String getMnrDispTrfGrpCd() {
		return this.mnrDispTrfGrpCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @param mnrDispTrfGrpCd
	 */
	public void setMnrDispTrfGrpCd(String mnrDispTrfGrpCd) {
		this.mnrDispTrfGrpCd = mnrDispTrfGrpCd;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMnrDispTrfGrpCd(JSPUtil.getParameter(request, "mnr_disp_trf_grp_cd", ""));
		setMnrDispTrfStsCd(JSPUtil.getParameter(request, "mnr_disp_trf_sts_cd", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setMnrTrfRmk(JSPUtil.getParameter(request, "mnr_trf_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMnrDispTrfSeq(JSPUtil.getParameter(request, "mnr_disp_trf_seq", ""));
		setMnrInpTpCd(JSPUtil.getParameter(request, "mnr_inp_tp_cd", ""));
		setMnrDispTrfTpCd(JSPUtil.getParameter(request, "mnr_disp_trf_tp_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setMnrDispTrfLstVerFlg(JSPUtil.getParameter(request, "mnr_disp_trf_lst_ver_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalTariffINVO[]
	 */
	public DisposalTariffINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DisposalTariffINVO[]
	 */
	public DisposalTariffINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalTariffINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrDispTrfGrpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_grp_cd", length));
			String[] mnrDispTrfStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_sts_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] mnrTrfRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_rmk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mnrDispTrfSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_seq", length));
			String[] mnrInpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inp_tp_cd", length));
			String[] mnrDispTrfTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_tp_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] mnrDispTrfLstVerFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_trf_lst_ver_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DisposalTariffINVO();
				if (mnrDispTrfGrpCd[i] != null)
					model.setMnrDispTrfGrpCd(mnrDispTrfGrpCd[i]);
				if (mnrDispTrfStsCd[i] != null)
					model.setMnrDispTrfStsCd(mnrDispTrfStsCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (mnrTrfRmk[i] != null)
					model.setMnrTrfRmk(mnrTrfRmk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mnrDispTrfSeq[i] != null)
					model.setMnrDispTrfSeq(mnrDispTrfSeq[i]);
				if (mnrInpTpCd[i] != null)
					model.setMnrInpTpCd(mnrInpTpCd[i]);
				if (mnrDispTrfTpCd[i] != null)
					model.setMnrDispTrfTpCd(mnrDispTrfTpCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (mnrDispTrfLstVerFlg[i] != null)
					model.setMnrDispTrfLstVerFlg(mnrDispTrfLstVerFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalTariffINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalTariffINVO[]
	 */
	public DisposalTariffINVO[] getDisposalTariffINVOs(){
		DisposalTariffINVO[] vos = (DisposalTariffINVO[])models.toArray(new DisposalTariffINVO[models.size()]);
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
		this.mnrDispTrfGrpCd = this.mnrDispTrfGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfStsCd = this.mnrDispTrfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfRmk = this.mnrTrfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfSeq = this.mnrDispTrfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInpTpCd = this.mnrInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfTpCd = this.mnrDispTrfTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispTrfLstVerFlg = this.mnrDispTrfLstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
