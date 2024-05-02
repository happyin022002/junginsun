/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TrsActCostHdrVO.java
*@FileTitle : TrsActCostHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsActCostHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrsActCostHdrVO> models = new ArrayList<TrsActCostHdrVO>();
	
	/* Column Info */
	private String errRmk = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String exeFmDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String trspActCostSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String calcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String exeStsCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String exeToDt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TrsActCostHdrVO() {}

	public TrsActCostHdrVO(String ibflag, String pagerows, String trspActCostSeq, String exeFmDt, String exeToDt, String exeStsCd, String calcTpCd, String errRmk, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.errRmk = errRmk;
		this.updDt = updDt;
		this.exeFmDt = exeFmDt;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.trspActCostSeq = trspActCostSeq;
		this.pagerows = pagerows;
		this.calcTpCd = calcTpCd;
		this.ibflag = ibflag;
		this.exeStsCd = exeStsCd;
		this.creUsrId = creUsrId;
		this.exeToDt = exeToDt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("err_rmk", getErrRmk());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("exe_fm_dt", getExeFmDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trsp_act_cost_seq", getTrspActCostSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("exe_sts_cd", getExeStsCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("exe_to_dt", getExeToDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("err_rmk", "errRmk");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("exe_fm_dt", "exeFmDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trsp_act_cost_seq", "trspActCostSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("exe_sts_cd", "exeStsCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("exe_to_dt", "exeToDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return errRmk
	 */
	public String getErrRmk() {
		return this.errRmk;
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
	 * @return exeFmDt
	 */
	public String getExeFmDt() {
		return this.exeFmDt;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return trspActCostSeq
	 */
	public String getTrspActCostSeq() {
		return this.trspActCostSeq;
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
	 * @return calcTpCd
	 */
	public String getCalcTpCd() {
		return this.calcTpCd;
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
	 * @return exeStsCd
	 */
	public String getExeStsCd() {
		return this.exeStsCd;
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
	 * @return exeToDt
	 */
	public String getExeToDt() {
		return this.exeToDt;
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
	 * @param errRmk
	 */
	public void setErrRmk(String errRmk) {
		this.errRmk = errRmk;
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
	 * @param exeFmDt
	 */
	public void setExeFmDt(String exeFmDt) {
		this.exeFmDt = exeFmDt;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param trspActCostSeq
	 */
	public void setTrspActCostSeq(String trspActCostSeq) {
		this.trspActCostSeq = trspActCostSeq;
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
	 * @param calcTpCd
	 */
	public void setCalcTpCd(String calcTpCd) {
		this.calcTpCd = calcTpCd;
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
	 * @param exeStsCd
	 */
	public void setExeStsCd(String exeStsCd) {
		this.exeStsCd = exeStsCd;
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
	 * @param exeToDt
	 */
	public void setExeToDt(String exeToDt) {
		this.exeToDt = exeToDt;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setErrRmk(JSPUtil.getParameter(request, prefix + "err_rmk", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setExeFmDt(JSPUtil.getParameter(request, prefix + "exe_fm_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTrspActCostSeq(JSPUtil.getParameter(request, prefix + "trsp_act_cost_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCalcTpCd(JSPUtil.getParameter(request, prefix + "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExeStsCd(JSPUtil.getParameter(request, prefix + "exe_sts_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setExeToDt(JSPUtil.getParameter(request, prefix + "exe_to_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsActCostHdrVO[]
	 */
	public TrsActCostHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsActCostHdrVO[]
	 */
	public TrsActCostHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsActCostHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] errRmk = (JSPUtil.getParameter(request, prefix	+ "err_rmk", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] exeFmDt = (JSPUtil.getParameter(request, prefix	+ "exe_fm_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] trspActCostSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_act_cost_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] calcTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] exeStsCd = (JSPUtil.getParameter(request, prefix	+ "exe_sts_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] exeToDt = (JSPUtil.getParameter(request, prefix	+ "exe_to_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrsActCostHdrVO();
				if (errRmk[i] != null)
					model.setErrRmk(errRmk[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (exeFmDt[i] != null)
					model.setExeFmDt(exeFmDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (trspActCostSeq[i] != null)
					model.setTrspActCostSeq(trspActCostSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (calcTpCd[i] != null)
					model.setCalcTpCd(calcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (exeStsCd[i] != null)
					model.setExeStsCd(exeStsCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (exeToDt[i] != null)
					model.setExeToDt(exeToDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsActCostHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrsActCostHdrVO[]
	 */
	public TrsActCostHdrVO[] getTrsActCostHdrVOs(){
		TrsActCostHdrVO[] vos = (TrsActCostHdrVO[])models.toArray(new TrsActCostHdrVO[models.size()]);
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
		this.errRmk = this.errRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeFmDt = this.exeFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspActCostSeq = this.trspActCostSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd = this.calcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeStsCd = this.exeStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeToDt = this.exeToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
