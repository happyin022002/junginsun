/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CstmsAdvRsltsVO.java
*@FileTitle : CstmsAdvRsltsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstmsAdvRsltsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstmsAdvRsltsVO> models = new ArrayList<CstmsAdvRsltsVO>();
	
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String fFlg = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String yard = null;
	/* Column Info */
	private String sndOfcCd = null;
	/* Column Info */
	private String fmStsCd = null;
	/* Column Info */
	private String freeDt = null;
	/* Column Info */
	private String tpszCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String avalDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String oFlg = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String ntcTp = null;
	/* Column Info */
	private String spc = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String evntDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstmsAdvRsltsVO() {}

	public CstmsAdvRsltsVO(String ibflag, String pagerows, String cntrNo, String tpszCd, String pkupNo, String yard, String avalDt, String freeDt, String ntcTp, String evntDt, String cntrWgt, String wgtUtCd, String pckQty, String pckTpCd, String spc, String usrNm, String sndOfcCd, String rmk, String fFlg, String oFlg, String cFlg, String fmStsCd) {
		this.rmk = rmk;
		this.fFlg = fFlg;
		this.cntrWgt = cntrWgt;
		this.yard = yard;
		this.sndOfcCd = sndOfcCd;
		this.fmStsCd = fmStsCd;
		this.freeDt = freeDt;
		this.tpszCd = tpszCd;
		this.pagerows = pagerows;
		this.cFlg = cFlg;
		this.ibflag = ibflag;
		this.usrNm = usrNm;
		this.avalDt = avalDt;
		this.cntrNo = cntrNo;
		this.wgtUtCd = wgtUtCd;
		this.pckQty = pckQty;
		this.oFlg = oFlg;
		this.pckTpCd = pckTpCd;
		this.ntcTp = ntcTp;
		this.spc = spc;
		this.pkupNo = pkupNo;
		this.evntDt = evntDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("f_flg", getFFlg());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("yard", getYard());
		this.hashColumns.put("snd_ofc_cd", getSndOfcCd());
		this.hashColumns.put("fm_sts_cd", getFmStsCd());
		this.hashColumns.put("free_dt", getFreeDt());
		this.hashColumns.put("tpsz_cd", getTpszCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("c_flg", getCFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("aval_dt", getAvalDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("o_flg", getOFlg());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("ntc_tp", getNtcTp());
		this.hashColumns.put("spc", getSpc());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("evnt_dt", getEvntDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("f_flg", "fFlg");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("yard", "yard");
		this.hashFields.put("snd_ofc_cd", "sndOfcCd");
		this.hashFields.put("fm_sts_cd", "fmStsCd");
		this.hashFields.put("free_dt", "freeDt");
		this.hashFields.put("tpsz_cd", "tpszCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("c_flg", "cFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("aval_dt", "avalDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("o_flg", "oFlg");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("ntc_tp", "ntcTp");
		this.hashFields.put("spc", "spc");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("evnt_dt", "evntDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
	}
	
	/**
	 * Column Info
	 * @return fFlg
	 */
	public String getFFlg() {
		return this.fFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return yard
	 */
	public String getYard() {
		return this.yard;
	}
	
	/**
	 * Column Info
	 * @return sndOfcCd
	 */
	public String getSndOfcCd() {
		return this.sndOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fmStsCd
	 */
	public String getFmStsCd() {
		return this.fmStsCd;
	}
	
	/**
	 * Column Info
	 * @return freeDt
	 */
	public String getFreeDt() {
		return this.freeDt;
	}
	
	/**
	 * Column Info
	 * @return tpszCd
	 */
	public String getTpszCd() {
		return this.tpszCd;
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
	 * @return cFlg
	 */
	public String getCFlg() {
		return this.cFlg;
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
	 * @return avalDt
	 */
	public String getAvalDt() {
		return this.avalDt;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return oFlg
	 */
	public String getOFlg() {
		return this.oFlg;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return ntcTp
	 */
	public String getNtcTp() {
		return this.ntcTp;
	}
	
	/**
	 * Column Info
	 * @return spc
	 */
	public String getSpc() {
		return this.spc;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	

	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	/**
	 * Column Info
	 * @param fFlg
	 */
	public void setFFlg(String fFlg) {
		this.fFlg = fFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param yard
	 */
	public void setYard(String yard) {
		this.yard = yard;
	}
	
	/**
	 * Column Info
	 * @param sndOfcCd
	 */
	public void setSndOfcCd(String sndOfcCd) {
		this.sndOfcCd = sndOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fmStsCd
	 */
	public void setFmStsCd(String fmStsCd) {
		this.fmStsCd = fmStsCd;
	}
	
	/**
	 * Column Info
	 * @param freeDt
	 */
	public void setFreeDt(String freeDt) {
		this.freeDt = freeDt;
	}
	
	/**
	 * Column Info
	 * @param tpszCd
	 */
	public void setTpszCd(String tpszCd) {
		this.tpszCd = tpszCd;
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
	 * @param cFlg
	 */
	public void setCFlg(String cFlg) {
		this.cFlg = cFlg;
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
	 * @param avalDt
	 */
	public void setAvalDt(String avalDt) {
		this.avalDt = avalDt;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param oFlg
	 */
	public void setOFlg(String oFlg) {
		this.oFlg = oFlg;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param ntcTp
	 */
	public void setNtcTp(String ntcTp) {
		this.ntcTp = ntcTp;
	}
	
	/**
	 * Column Info
	 * @param spc
	 */
	public void setSpc(String spc) {
		this.spc = spc;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRmk(JSPUtil.getParameter(request, "rmk", ""));
		setFFlg(JSPUtil.getParameter(request, "f_flg", ""));
		setCntrWgt(JSPUtil.getParameter(request, "cntr_wgt", ""));
		setYard(JSPUtil.getParameter(request, "yard", ""));
		setSndOfcCd(JSPUtil.getParameter(request, "snd_ofc_cd", ""));
		setFmStsCd(JSPUtil.getParameter(request, "fm_sts_cd", ""));
		setFreeDt(JSPUtil.getParameter(request, "free_dt", ""));
		setTpszCd(JSPUtil.getParameter(request, "tpsz_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCFlg(JSPUtil.getParameter(request, "c_flg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setAvalDt(JSPUtil.getParameter(request, "aval_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setOFlg(JSPUtil.getParameter(request, "o_flg", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setNtcTp(JSPUtil.getParameter(request, "ntc_tp", ""));
		setSpc(JSPUtil.getParameter(request, "spc", ""));
		setPkupNo(JSPUtil.getParameter(request, "pkup_no", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstmsAdvRsltsVO[]
	 */
	public CstmsAdvRsltsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstmsAdvRsltsVO[]
	 */
	public CstmsAdvRsltsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstmsAdvRsltsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] fFlg = (JSPUtil.getParameter(request, prefix	+ "f_flg", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] yard = (JSPUtil.getParameter(request, prefix	+ "yard", length));
			String[] sndOfcCd = (JSPUtil.getParameter(request, prefix	+ "snd_ofc_cd", length));
			String[] fmStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_sts_cd", length));
			String[] freeDt = (JSPUtil.getParameter(request, prefix	+ "free_dt", length));
			String[] tpszCd = (JSPUtil.getParameter(request, prefix	+ "tpsz_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cFlg = (JSPUtil.getParameter(request, prefix	+ "c_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] avalDt = (JSPUtil.getParameter(request, prefix	+ "aval_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] oFlg = (JSPUtil.getParameter(request, prefix	+ "o_flg", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] ntcTp = (JSPUtil.getParameter(request, prefix	+ "ntc_tp", length));
			String[] spc = (JSPUtil.getParameter(request, prefix	+ "spc", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CstmsAdvRsltsVO();
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (fFlg[i] != null)
					model.setFFlg(fFlg[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (yard[i] != null)
					model.setYard(yard[i]);
				if (sndOfcCd[i] != null)
					model.setSndOfcCd(sndOfcCd[i]);
				if (fmStsCd[i] != null)
					model.setFmStsCd(fmStsCd[i]);
				if (freeDt[i] != null)
					model.setFreeDt(freeDt[i]);
				if (tpszCd[i] != null)
					model.setTpszCd(tpszCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cFlg[i] != null)
					model.setCFlg(cFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (avalDt[i] != null)
					model.setAvalDt(avalDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (oFlg[i] != null)
					model.setOFlg(oFlg[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (ntcTp[i] != null)
					model.setNtcTp(ntcTp[i]);
				if (spc[i] != null)
					model.setSpc(spc[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstmsAdvRsltsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstmsAdvRsltsVO[]
	 */
	public CstmsAdvRsltsVO[] getCstmsAdvRsltsVOs(){
		CstmsAdvRsltsVO[] vos = (CstmsAdvRsltsVO[])models.toArray(new CstmsAdvRsltsVO[models.size()]);
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
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fFlg = this.fFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yard = this.yard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndOfcCd = this.sndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmStsCd = this.fmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDt = this.freeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCd = this.tpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cFlg = this.cFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avalDt = this.avalDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oFlg = this.oFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcTp = this.ntcTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spc = this.spc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
