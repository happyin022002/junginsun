/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ExRateHistoryVO.java
*@FileTitle : ExRateHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class ExRateHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExRateHistoryVO> models = new ArrayList<ExRateHistoryVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String xchRtTpCd = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String cngRmk = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String chgCurrCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String currNm = null;
	/* Column Info */
	private String opStsNm = null;
	/* Column Info */
	private String ivsXchRt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String invXchRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ExRateHistoryVO() {}

	public ExRateHistoryVO(String ibflag, String pagerows, String ioBndCd, String fmDt, String toDt, String currNm, String chgCurrCd, String loclCurrCd, String xchRtTpCd, String arOfcCd, String invXchRt, String ivsXchRt, String cngRmk, String opStsNm, String loclCreDt, String creUsrId, String creDt, String updUsrId, String updDt, String usrId) {
		this.updDt = updDt;
		this.xchRtTpCd = xchRtTpCd;
		this.fmDt = fmDt;
		this.loclCurrCd = loclCurrCd;
		this.cngRmk = cngRmk;
		this.creDt = creDt;
		this.loclCreDt = loclCreDt;
		this.ioBndCd = ioBndCd;
		this.arOfcCd = arOfcCd;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.chgCurrCd = chgCurrCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.currNm = currNm;
		this.opStsNm = opStsNm;
		this.ivsXchRt = ivsXchRt;
		this.updUsrId = updUsrId;
		this.invXchRt = invXchRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("cng_rmk", getCngRmk());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("chg_curr_cd", getChgCurrCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("curr_nm", getCurrNm());
		this.hashColumns.put("op_sts_nm", getOpStsNm());
		this.hashColumns.put("ivs_xch_rt", getIvsXchRt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("cng_rmk", "cngRmk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("chg_curr_cd", "chgCurrCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("curr_nm", "currNm");
		this.hashFields.put("op_sts_nm", "opStsNm");
		this.hashFields.put("ivs_xch_rt", "ivsXchRt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_xch_rt", "invXchRt");
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
	 * @return xchRtTpCd
	 */
	public String getXchRtTpCd() {
		return this.xchRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return cngRmk
	 */
	public String getCngRmk() {
		return this.cngRmk;
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
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return chgCurrCd
	 */
	public String getChgCurrCd() {
		return this.chgCurrCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return currNm
	 */
	public String getCurrNm() {
		return this.currNm;
	}
	
	/**
	 * Column Info
	 * @return opStsNm
	 */
	public String getOpStsNm() {
		return this.opStsNm;
	}
	
	/**
	 * Column Info
	 * @return ivsXchRt
	 */
	public String getIvsXchRt() {
		return this.ivsXchRt;
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
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
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
	 * @param xchRtTpCd
	 */
	public void setXchRtTpCd(String xchRtTpCd) {
		this.xchRtTpCd = xchRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param cngRmk
	 */
	public void setCngRmk(String cngRmk) {
		this.cngRmk = cngRmk;
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
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param chgCurrCd
	 */
	public void setChgCurrCd(String chgCurrCd) {
		this.chgCurrCd = chgCurrCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param currNm
	 */
	public void setCurrNm(String currNm) {
		this.currNm = currNm;
	}
	
	/**
	 * Column Info
	 * @param opStsNm
	 */
	public void setOpStsNm(String opStsNm) {
		this.opStsNm = opStsNm;
	}
	
	/**
	 * Column Info
	 * @param ivsXchRt
	 */
	public void setIvsXchRt(String ivsXchRt) {
		this.ivsXchRt = ivsXchRt;
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
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setXchRtTpCd(JSPUtil.getParameter(request, prefix + "xch_rt_tp_cd", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setCngRmk(JSPUtil.getParameter(request, prefix + "cng_rmk", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setChgCurrCd(JSPUtil.getParameter(request, prefix + "chg_curr_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setCurrNm(JSPUtil.getParameter(request, prefix + "curr_nm", ""));
		setOpStsNm(JSPUtil.getParameter(request, prefix + "op_sts_nm", ""));
		setIvsXchRt(JSPUtil.getParameter(request, prefix + "ivs_xch_rt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setInvXchRt(JSPUtil.getParameter(request, prefix + "inv_xch_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExRateHistoryVO[]
	 */
	public ExRateHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExRateHistoryVO[]
	 */
	public ExRateHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExRateHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] xchRtTpCd = (JSPUtil.getParameter(request, prefix	+ "xch_rt_tp_cd", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] cngRmk = (JSPUtil.getParameter(request, prefix	+ "cng_rmk", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] chgCurrCd = (JSPUtil.getParameter(request, prefix	+ "chg_curr_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] currNm = (JSPUtil.getParameter(request, prefix	+ "curr_nm", length));
			String[] opStsNm = (JSPUtil.getParameter(request, prefix	+ "op_sts_nm", length));
			String[] ivsXchRt = (JSPUtil.getParameter(request, prefix	+ "ivs_xch_rt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new ExRateHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (xchRtTpCd[i] != null)
					model.setXchRtTpCd(xchRtTpCd[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (cngRmk[i] != null)
					model.setCngRmk(cngRmk[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (chgCurrCd[i] != null)
					model.setChgCurrCd(chgCurrCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (currNm[i] != null)
					model.setCurrNm(currNm[i]);
				if (opStsNm[i] != null)
					model.setOpStsNm(opStsNm[i]);
				if (ivsXchRt[i] != null)
					model.setIvsXchRt(ivsXchRt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExRateHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ExRateHistoryVO[]
	 */
	public ExRateHistoryVO[] getExRateHistoryVOs(){
		ExRateHistoryVO[] vos = (ExRateHistoryVO[])models.toArray(new ExRateHistoryVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpCd = this.xchRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngRmk = this.cngRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurrCd = this.chgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currNm = this.currNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opStsNm = this.opStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ivsXchRt = this.ivsXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
