/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TesActCostHdrVO.java
*@FileTitle : TesActCostHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.26  
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

public class TesActCostHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesActCostHdrVO> models = new ArrayList<TesActCostHdrVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String errRmk = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String exeFmDt = null;
	/* Column Info */
	private String creDt = null;
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
	private String tmlActCostSeq = null;
	/* Column Info */
	private String exeToDt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesActCostHdrVO() {}

	public TesActCostHdrVO(String ibflag, String pagerows, String tmlActCostSeq, String exeStsCd, String calcTpCd, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt, String exeFmDt, String exeToDt, String errRmk) {
		this.updDt = updDt;
		this.errRmk = errRmk;
		this.deltFlg = deltFlg;
		this.exeFmDt = exeFmDt;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.calcTpCd = calcTpCd;
		this.ibflag = ibflag;
		this.exeStsCd = exeStsCd;
		this.creUsrId = creUsrId;
		this.tmlActCostSeq = tmlActCostSeq;
		this.exeToDt = exeToDt;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("err_rmk", getErrRmk());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("exe_fm_dt", getExeFmDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("exe_sts_cd", getExeStsCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("tml_act_cost_seq", getTmlActCostSeq());
		this.hashColumns.put("exe_to_dt", getExeToDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("err_rmk", "errRmk");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("exe_fm_dt", "exeFmDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("exe_sts_cd", "exeStsCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("tml_act_cost_seq", "tmlActCostSeq");
		this.hashFields.put("exe_to_dt", "exeToDt");
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
	 * @return errRmk
	 */
	public String getErrRmk() {
		return this.errRmk;
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
	 * @return exeFmDt
	 */
	public String getExeFmDt() {
		return this.exeFmDt;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return tmlActCostSeq
	 */
	public String getTmlActCostSeq() {
		return this.tmlActCostSeq;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param tmlActCostSeq
	 */
	public void setTmlActCostSeq(String tmlActCostSeq) {
		this.tmlActCostSeq = tmlActCostSeq;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setErrRmk(JSPUtil.getParameter(request, prefix + "err_rmk", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setExeFmDt(JSPUtil.getParameter(request, prefix + "exe_fm_dt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCalcTpCd(JSPUtil.getParameter(request, prefix + "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExeStsCd(JSPUtil.getParameter(request, prefix + "exe_sts_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setTmlActCostSeq(JSPUtil.getParameter(request, prefix + "tml_act_cost_seq", ""));
		setExeToDt(JSPUtil.getParameter(request, prefix + "exe_to_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesActCostHdrVO[]
	 */
	public TesActCostHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesActCostHdrVO[]
	 */
	public TesActCostHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesActCostHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] errRmk = (JSPUtil.getParameter(request, prefix	+ "err_rmk", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] exeFmDt = (JSPUtil.getParameter(request, prefix	+ "exe_fm_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] calcTpCd = (JSPUtil.getParameter(request, prefix	+ "calc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] exeStsCd = (JSPUtil.getParameter(request, prefix	+ "exe_sts_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] tmlActCostSeq = (JSPUtil.getParameter(request, prefix	+ "tml_act_cost_seq", length));
			String[] exeToDt = (JSPUtil.getParameter(request, prefix	+ "exe_to_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesActCostHdrVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (errRmk[i] != null)
					model.setErrRmk(errRmk[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (exeFmDt[i] != null)
					model.setExeFmDt(exeFmDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
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
				if (tmlActCostSeq[i] != null)
					model.setTmlActCostSeq(tmlActCostSeq[i]);
				if (exeToDt[i] != null)
					model.setExeToDt(exeToDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesActCostHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesActCostHdrVO[]
	 */
	public TesActCostHdrVO[] getTesActCostHdrVOs(){
		TesActCostHdrVO[] vos = (TesActCostHdrVO[])models.toArray(new TesActCostHdrVO[models.size()]);
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
		this.errRmk = this.errRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeFmDt = this.exeFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd = this.calcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeStsCd = this.exeStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlActCostSeq = this.tmlActCostSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeToDt = this.exeToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
