/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BasicTariffByGenerationVO.java
*@FileTitle : BasicTariffByGenerationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.06.04 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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

public class BasicTariffByGenerationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BasicTariffByGenerationVO> models = new ArrayList<BasicTariffByGenerationVO>();
	
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String xcldSatFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String dmdtChgCmncTpCd = null;
	/* Column Info */
	private String cmncHr = null;
	/* Column Info */
	private String dmdtTrfGrpTpCd = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String trfGrpSeq = null;
	/* Column Info */
	private String trfSeq = null;
	/* Column Number */
	private String pagerows = null;
	/* Column Number */
	private String dmdtDeTermCd = null;
	/* Column Number */
	private String dmdtDeTermNm = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BasicTariffByGenerationVO() {}

	public BasicTariffByGenerationVO(String ibflag, String pagerows, String trfSeq, String trfGrpSeq, String dmdtChgCmncTpCd, String cmncHr, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String currCd, String dmdtTrfGrpTpCd, String dmdtDeTermCd, String dmdtDeTermNm) {
		this.xcldSunFlg = xcldSunFlg;
		this.xcldSatFlg = xcldSatFlg;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.dmdtChgCmncTpCd = dmdtChgCmncTpCd;
		this.cmncHr = cmncHr;
		this.dmdtTrfGrpTpCd = dmdtTrfGrpTpCd;
		this.xcldHolFlg = xcldHolFlg;
		this.trfGrpSeq = trfGrpSeq;
		this.trfSeq = trfSeq;
		this.pagerows = pagerows;
		this.dmdtDeTermCd = dmdtDeTermCd;
		this.dmdtDeTermNm = dmdtDeTermNm;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("dmdt_chg_cmnc_tp_cd", getDmdtChgCmncTpCd());
		this.hashColumns.put("cmnc_hr", getCmncHr());
		this.hashColumns.put("dmdt_trf_grp_tp_cd", getDmdtTrfGrpTpCd());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("trf_grp_seq", getTrfGrpSeq());
		this.hashColumns.put("trf_seq", getTrfSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dmdt_de_term_cd", getDmdtDeTermCd());
		this.hashColumns.put("dmdt_de_term_nm", getDmdtDeTermNm());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("dmdt_chg_cmnc_tp_cd", "dmdtChgCmncTpCd");
		this.hashFields.put("cmnc_hr", "cmncHr");
		this.hashFields.put("dmdt_trf_grp_tp_cd", "dmdtTrfGrpTpCd");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("trf_grp_seq", "trfGrpSeq");
		this.hashFields.put("trf_seq", "trfSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dmdt_de_term_cd", "dmdtDeTermCd");
		this.hashFields.put("dmdt_de_term_nm", "dmdtDeTermNm");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xcldSunFlg
	 */
	public String getXcldSunFlg() {
		return this.xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldSatFlg
	 */
	public String getXcldSatFlg() {
		return this.xcldSatFlg;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgCmncTpCd
	 */
	public String getDmdtChgCmncTpCd() {
		return this.dmdtChgCmncTpCd;
	}
	
	/**
	 * Column Info
	 * @return cmncHr
	 */
	public String getCmncHr() {
		return this.cmncHr;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfGrpTpCd
	 */
	public String getDmdtTrfGrpTpCd() {
		return this.dmdtTrfGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @return trfGrpSeq
	 */
	public String getTrfGrpSeq() {
		return this.trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return trfSeq
	 */
	public String getTrfSeq() {
		return this.trfSeq;
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
	 * @return dmdtDeTermCd
	 */
	public String getDmdtDeTermCd() {
		return this.dmdtDeTermCd;
	}

	/**
	 * Column Info
	 * @return dmdtDeTermNm
	 */
	public String getDmdtDeTermNm() {
		return this.dmdtDeTermNm;
	}
	
	/**
	 * Column Info
	 * @param xcldSunFlg
	 */
	public void setXcldSunFlg(String xcldSunFlg) {
		this.xcldSunFlg = xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldSatFlg
	 */
	public void setXcldSatFlg(String xcldSatFlg) {
		this.xcldSatFlg = xcldSatFlg;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgCmncTpCd
	 */
	public void setDmdtChgCmncTpCd(String dmdtChgCmncTpCd) {
		this.dmdtChgCmncTpCd = dmdtChgCmncTpCd;
	}
	
	/**
	 * Column Info
	 * @param cmncHr
	 */
	public void setCmncHr(String cmncHr) {
		this.cmncHr = cmncHr;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfGrpTpCd
	 */
	public void setDmdtTrfGrpTpCd(String dmdtTrfGrpTpCd) {
		this.dmdtTrfGrpTpCd = dmdtTrfGrpTpCd;
	}
	
	/**
	 * Column Info
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @param trfGrpSeq
	 */
	public void setTrfGrpSeq(String trfGrpSeq) {
		this.trfGrpSeq = trfGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param trfSeq
	 */
	public void setTrfSeq(String trfSeq) {
		this.trfSeq = trfSeq;
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
	 * @param dmdtDeTermCd
	 */
	public void setDmdtDeTermCd(String dmdtDeTermCd) {
		this.dmdtDeTermCd = dmdtDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtDeTermNm
	 */
	public void setDmdtDeTermNm(String dmdtDeTermNm) {
		this.dmdtDeTermNm = dmdtDeTermNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXcldSunFlg(JSPUtil.getParameter(request, "xcld_sun_flg", ""));
		setXcldSatFlg(JSPUtil.getParameter(request, "xcld_sat_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setDmdtChgCmncTpCd(JSPUtil.getParameter(request, "dmdt_chg_cmnc_tp_cd", ""));
		setCmncHr(JSPUtil.getParameter(request, "cmnc_hr", ""));
		setDmdtTrfGrpTpCd(JSPUtil.getParameter(request, "dmdt_trf_grp_tp_cd", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
		setTrfGrpSeq(JSPUtil.getParameter(request, "trf_grp_seq", ""));
		setTrfSeq(JSPUtil.getParameter(request, "trf_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDmdtDeTermCd(JSPUtil.getParameter(request, "dmdt_de_term_cd", ""));
		setDmdtDeTermNm(JSPUtil.getParameter(request, "dmdt_de_term_nm", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BasicTariffByGenerationVO[]
	 */
	public BasicTariffByGenerationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BasicTariffByGenerationVO[]
	 */
	public BasicTariffByGenerationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BasicTariffByGenerationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg".trim(), length));
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd".trim(), length));
			String[] dmdtChgCmncTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_cmnc_tp_cd".trim(), length));
			String[] cmncHr = (JSPUtil.getParameter(request, prefix	+ "cmnc_hr".trim(), length));
			String[] dmdtTrfGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_grp_tp_cd".trim(), length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg".trim(), length));
			String[] trfGrpSeq = (JSPUtil.getParameter(request, prefix	+ "trf_grp_seq".trim(), length));
			String[] trfSeq = (JSPUtil.getParameter(request, prefix	+ "trf_seq".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] dmdtDeTermCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_cd", length));
			String[] dmdtDeTermNm = (JSPUtil.getParameter(request, prefix	+ "dmdt_de_term_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new BasicTariffByGenerationVO();
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (dmdtChgCmncTpCd[i] != null)
					model.setDmdtChgCmncTpCd(dmdtChgCmncTpCd[i]);
				if (cmncHr[i] != null)
					model.setCmncHr(cmncHr[i]);
				if (dmdtTrfGrpTpCd[i] != null)
					model.setDmdtTrfGrpTpCd(dmdtTrfGrpTpCd[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (trfGrpSeq[i] != null)
					model.setTrfGrpSeq(trfGrpSeq[i]);
				if (trfSeq[i] != null)
					model.setTrfSeq(trfSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dmdtDeTermCd[i] != null)
					model.setDmdtDeTermCd(dmdtDeTermCd[i]);
				if (dmdtDeTermNm[i] != null)
					model.setDmdtDeTermNm(dmdtDeTermNm[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBasicTariffByGenerationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BasicTariffByGenerationVO[]
	 */
	public BasicTariffByGenerationVO[] getBasicTariffByGenerationVOs(){
		BasicTariffByGenerationVO[] vos = (BasicTariffByGenerationVO[])models.toArray(new BasicTariffByGenerationVO[models.size()]);
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
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgCmncTpCd = this.dmdtChgCmncTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmncHr = this.cmncHr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfGrpTpCd = this.dmdtTrfGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfGrpSeq = this.trfGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfSeq = this.trfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermCd = this.dmdtDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtDeTermNm = this.dmdtDeTermNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
