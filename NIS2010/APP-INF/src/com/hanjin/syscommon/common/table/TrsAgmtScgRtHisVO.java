/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TrsAgmtScgRtHisVO.java
*@FileTitle : TrsAgmtScgRtHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.18
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2011.04.18 민정호 
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
 * @author 민정호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsAgmtScgRtHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrsAgmtScgRtHisVO> models = new ArrayList<TrsAgmtScgRtHisVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	private String trspAgmtOfcCtyCd = null;
	private String trspAgmtSeq = null;
	private String trspAgmtRtTpSerNo = null;
	private String trspAgmtScgNodSeq = null;
	private String trspAgmtScgRtSeq = null;
	private String trspAgmtRtHisSeq = null;
	private String trspAgmtEqTpSzCd = null;
	private String eqKndCd = null;
	private String toWgt = null;
	private String wgtMeasUtCd = null;
	private String effFmDt = null;
	private String effToDt = null;
	private String agmtScgRtDivCd = null;
	private String currCd = null;
	private String trspOneWyRt = null;
	private String trspRndRt = null;
	private String deltFlg = null;
	private String creUsrId = null;
	private String creDt = null;
	private String updUsrId = null;
	private String updDt = null;
		
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TrsAgmtScgRtHisVO() {}

	public TrsAgmtScgRtHisVO(String ibflag, String pagerows, String trspAgmtOfcCtyCd, String trspAgmtSeq, String trspAgmtRtTpSerNo, String trspAgmtScgNodSeq, String trspAgmtScgRtSeq,  String trspAgmtRtHisSeq, String trspAgmtEqTpSzCd, String eqKndCd, String toWgt, String wgtMeasUtCd, String effFmDt, String effToDt, String agmtScgRtDivCd, String currCd, String trspOneWyRt, String trspRndRt, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.pagerows	= pagerows;
		this.ibflag		= ibflag;
		this.trspAgmtOfcCtyCd	= trspAgmtOfcCtyCd;		
		this.trspAgmtSeq		= trspAgmtSeq;
		this.trspAgmtRtTpSerNo	= trspAgmtRtTpSerNo;
		this.trspAgmtScgNodSeq	= trspAgmtScgNodSeq;
		this.trspAgmtScgRtSeq	= trspAgmtScgRtSeq;
		this.trspAgmtRtHisSeq	= trspAgmtRtHisSeq;
		this.trspAgmtEqTpSzCd	= trspAgmtEqTpSzCd;
		this.eqKndCd			= eqKndCd;
		this.toWgt				= toWgt;
		this.wgtMeasUtCd		= wgtMeasUtCd;
		this.effFmDt			= effFmDt;
		this.effToDt			= effToDt;
		this.agmtScgRtDivCd		= agmtScgRtDivCd;
		this.currCd				= currCd;
		this.trspOneWyRt		= trspOneWyRt;	
		this.trspRndRt			= trspRndRt;
		this.deltFlg			= deltFlg;
		this.creUsrId			= creUsrId;
		this.creDt				= creDt;
		this.updUsrId		    = updUsrId;
		this.updDt				= updDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trsp_agmt_ofc_cty_cd",getTrspAgmtOfcCtyCd());
		this.hashColumns.put("trsp_agmt_seq",getTrspAgmtSeq());
		this.hashColumns.put("trsp_agmt_rt_tp_ser_no",getTrspAgmtRtTpSerNo());
		this.hashColumns.put("trsp_agmt_scg_nod_seq",getTrspAgmtScgNodSeq());
		this.hashColumns.put("trsp_agmt_scg_rt_seq",getTrspAgmtScgRtSeq());
		this.hashColumns.put("trsp_agmt_rt_his_seq",getTrspAgmtRtHisSeq());
		this.hashColumns.put("trsp_agmt_eq_tp_sz_cd",getTrspAgmtEqTpSzCd());
		this.hashColumns.put("eq_knd_cd",getEqKndCd());
		this.hashColumns.put("to_wgt",getToWgt());
		this.hashColumns.put("wgt_meas_ut_cd",getWgtMeasUtCd());
		this.hashColumns.put("eff_fm_dt",getEffFmDt());
		this.hashColumns.put("eff_to_dt",getEffToDt());
		this.hashColumns.put("agmt_scg_rt_div_cd",getAgmtScgRtDivCd());
		this.hashColumns.put("curr_cd",getCurrCd());
		this.hashColumns.put("trsp_one_wy_rt",getTrspOneWyRt());
		this.hashColumns.put("trsp_rnd_rt",getTrspRndRt());
		this.hashColumns.put("delt_flg",getDeltFlg());
		this.hashColumns.put("cre_usr_id",getCreUsrId());
		this.hashColumns.put("cre_dt",getCreDt());
		this.hashColumns.put("upd_usr_id",getUpdUsrId());
		this.hashColumns.put("upd_dt",getUpdDt());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trsp_agmt_ofc_cty_cd", "trspAgmtOfcCtyCd");
		this.hashFields.put("trsp_agmt_seq", "trspAgmtSeq");
		this.hashFields.put("trsp_agmt_rt_tp_ser_no", "trspAgmtRtTpSerNo");
		this.hashFields.put("trsp_agmt_scg_nod_seq", "trspAgmtScgNodSeq");
		this.hashFields.put("trsp_agmt_scg_rt_seq", "trspAgmtScgRtSeq");
		this.hashFields.put("trsp_agmt_rt_his_seq", "trspAgmtRtHisSeq");
		this.hashFields.put("trsp_agmt_eq_tp_sz_cd", "trspAgmtEqTpSzCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("to_wgt", "toWgt");
		this.hashFields.put("wgt_meas_ut_cd", "wgtMeasUtCd");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("eff_to_dt", "effToDt");
		this.hashFields.put("agmt_scg_rt_div_cd", "agmtScgRtDivCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("trsp_one_wy_rt", "trspOneWyRt");
		this.hashFields.put("trsp_rnd_rt", "trspRndRt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");		
		
		return this.hashFields;
	}	
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	public String getTrspAgmtOfcCtyCd() {		
		return this.trspAgmtOfcCtyCd;
	}
	
	public String getTrspAgmtSeq() {
		return this.trspAgmtSeq;
	}

	public String getTrspAgmtRtTpSerNo() {
		return this.trspAgmtRtTpSerNo;
	}

	public String getTrspAgmtScgNodSeq() {
		return this.trspAgmtScgNodSeq;
	}

	public String getTrspAgmtScgRtSeq() {
		return this.trspAgmtScgRtSeq;
	}

	public String getTrspAgmtRtHisSeq() {
		return this.trspAgmtRtHisSeq;
	}

	public String getTrspAgmtEqTpSzCd() {
		return this.trspAgmtEqTpSzCd;
	}

	public String getEqKndCd() {
		return this.eqKndCd;
	}

	public String getToWgt() {
		return this.toWgt;
	}

	public String getWgtMeasUtCd() {
		return this.wgtMeasUtCd;
	}

	public String getEffFmDt() {
		return this.effFmDt;
	}

	public String getEffToDt() {
		return this.effToDt;
	}

	public String getAgmtScgRtDivCd() {
		return this.agmtScgRtDivCd;
	}

	public String getCurrCd() {
		return this.currCd;
	}

	public String getTrspOneWyRt() {
		return this.trspOneWyRt;
	}

	public String getTrspRndRt() {
		return this.trspRndRt;
	}

	public String getDeltFlg() {
		return this.deltFlg;
	}

	public String getCreUsrId() {
		return this.creUsrId;
	}

	public String getCreDt() {
		return this.creDt;
	}

	public String getUpdUsrId() {
		return this.updUsrId;
	}

	public String getUpdDt() {  
		return this.updDt;
	}	
			
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
public void setTrspAgmtOfcCtyCd(String trspAgmtOfcCtyCd) {		
	this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
}

public void setTrspAgmtSeq(String trspAgmtSeq) {
	this.trspAgmtSeq = trspAgmtSeq;
}

public void setTrspAgmtRtTpSerNo(String trspAgmtRtTpSerNo) {
	this.trspAgmtRtTpSerNo = trspAgmtRtTpSerNo;
}

public void setTrspAgmtScgNodSeq(String trspAgmtScgNodSeq) {
	this.trspAgmtScgNodSeq = trspAgmtScgNodSeq;
}

public void setTrspAgmtScgRtSeq(String trspAgmtScgRtSeq) {
	this.trspAgmtScgRtSeq = trspAgmtScgRtSeq;
}

public void setTrspAgmtRtHisSeq(String trspAgmtRtHisSeq) {
	this.trspAgmtRtHisSeq = trspAgmtRtHisSeq;
}

public void setTrspAgmtEqTpSzCd(String trspAgmtEqTpSzCd) {
	this.trspAgmtEqTpSzCd = trspAgmtEqTpSzCd;
}

public void setEqKndCd(String eqKndCd) {
	this.eqKndCd = eqKndCd;
}

public void setToWgt(String toWgt) {
	this.toWgt = toWgt;
}

public void setWgtMeasUtCd(String wgtMeasUtCd) {
	this.wgtMeasUtCd = wgtMeasUtCd;
}

public void setEffFmDt(String effFmDt) {
	this.effFmDt = effFmDt;
}

public void setEffToDt(String effToDt) {
	this.effToDt = effToDt;
}

public void setAgmtScgRtDivCd(String agmtScgRtDivCd) {
	this.agmtScgRtDivCd = agmtScgRtDivCd;
}

public void setCurrCd(String currCd) {
	this.currCd = currCd;
}

public void setTrspOneWyRt(String trspOneWyRt) {
	this.trspOneWyRt = trspOneWyRt;
}

public void setTrspRndRt(String trspRndRt) {
	this.trspRndRt = trspRndRt;
}

public void setDeltFlg(String deltFlg) {
	this.deltFlg = deltFlg;
}

public void setCreUsrId(String creUsrId) {
	this.creUsrId = creUsrId;
}

public void setCreDt(String creDt) {
	this.creDt = creDt;
}

public void setUpdUsrId(String updUsrId) {
	this.updUsrId = updUsrId;
}

public void setUpdDt(String updDt) {  
	this.updDt = updDt;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrspAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_ofc_cty_cd", ""));		
		setTrspAgmtSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_seq", ""));
		setTrspAgmtRtTpSerNo(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_ser_no", ""));
		setTrspAgmtScgNodSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_scg_nod_seq", ""));
		setTrspAgmtScgRtSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_scg_rt_seq", ""));
		setTrspAgmtRtHisSeq(JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_his_seq", ""));
		setTrspAgmtEqTpSzCd(JSPUtil.getParameter(request, prefix + "trsp_agmt_eq_tp_sz_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setToWgt(JSPUtil.getParameter(request, prefix + "to_wgt", ""));
		setWgtMeasUtCd(JSPUtil.getParameter(request, prefix + "wgt_meas_ut_cd", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setAgmtScgRtDivCd(JSPUtil.getParameter(request, prefix + "agmt_scg_rt_div_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTrspOneWyRt(JSPUtil.getParameter(request, prefix + "trsp_one_wy_rt", ""));	
		setTrspRndRt(JSPUtil.getParameter(request, prefix + "trsp_rnd_rt", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));	
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsAgmtScgRtHisVO[]
	 */
	public TrsAgmtScgRtHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsAgmtScgRtHisVO[]
	 */
	public TrsAgmtScgRtHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsAgmtScgRtHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));

		String[] trspAgmtOfcCtyCd = (JSPUtil.getParameter(request, prefix + "trsp_agmt_ofc_cty_cd", length));		
		String[] trspAgmtSeq = (JSPUtil.getParameter(request, prefix + "trsp_agmt_seq", length));
		String[] trspAgmtRtTpSerNo = (JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_tp_ser_no", length));
		String[] trspAgmtScgNodSeq = (JSPUtil.getParameter(request, prefix + "trsp_agmt_scg_nod_seq", length));
		String[] trspAgmtScgRtSeq = (JSPUtil.getParameter(request, prefix + "trsp_agmt_scg_rt_seq", length));
		String[] trspAgmtRtHisSeq = (JSPUtil.getParameter(request, prefix + "trsp_agmt_rt_his_seq", length));
		String[] trspAgmtEqTpSzCd = (JSPUtil.getParameter(request, prefix + "trsp_agmt_eq_tp_sz_cd", length));
		String[] eqKndCd = (JSPUtil.getParameter(request, prefix + "eq_knd_cd", length));
		String[] toWgt = (JSPUtil.getParameter(request, prefix + "to_wgt", length));
		String[] wgtMeasUtCd = (JSPUtil.getParameter(request, prefix + "wgt_meas_ut_cd", length));
		String[] effFmDt = (JSPUtil.getParameter(request, prefix + "eff_fm_dt", length));
		String[] effToDt = (JSPUtil.getParameter(request, prefix + "eff_to_dt", length));
		String[] agmtScgRtDivCd = (JSPUtil.getParameter(request, prefix + "agmt_scg_rt_div_cd", length));
		String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
		String[] trspOneWyRt = (JSPUtil.getParameter(request, prefix + "trsp_one_wy_rt", length));	
		String[] trspRndRt = (JSPUtil.getParameter(request, prefix + "trsp_rnd_rt", length));
		String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg", length));
		String[] creUsrId = (JSPUtil.getParameter(request, prefix + "cre_usr_id", length));
		String[] creDt = (JSPUtil.getParameter(request, prefix + "cre_dt", length));
		String[] updUsrId = (JSPUtil.getParameter(request, prefix + "upd_usr_id", length));
		String[] updDt = (JSPUtil.getParameter(request, prefix + "upd_dt", length));	

			
			for (int i = 0; i < length; i++) {
				model = new TrsAgmtScgRtHisVO();

				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if(trspAgmtOfcCtyCd[i] != null)
							model.setTrspAgmtOfcCtyCd(trspAgmtOfcCtyCd[i]);
				if(trspAgmtSeq[i] != null)
							model.setTrspAgmtSeq(trspAgmtSeq[i]);
				if(trspAgmtRtTpSerNo[i] != null)
							model.setTrspAgmtRtTpSerNo(trspAgmtRtTpSerNo[i]);
				if(trspAgmtScgNodSeq[i] != null)
							model.setTrspAgmtScgNodSeq(trspAgmtScgNodSeq[i]);
				if(trspAgmtScgRtSeq[i] != null)
							model.setTrspAgmtScgRtSeq(trspAgmtScgRtSeq[i]);
				if(trspAgmtRtHisSeq[i] != null)
							model.setTrspAgmtRtHisSeq(trspAgmtRtHisSeq[i]);
				if(trspAgmtEqTpSzCd[i] != null)
							model.setTrspAgmtEqTpSzCd(trspAgmtEqTpSzCd[i]);
				if(eqKndCd[i] != null)
							model.setEqKndCd(eqKndCd[i]);
				if(toWgt[i] != null)
							model.setToWgt(toWgt[i]);
				if(wgtMeasUtCd[i] != null)
							model.setWgtMeasUtCd(wgtMeasUtCd[i]);
				if(effFmDt[i] != null)
							model.setEffFmDt(effFmDt[i]);
				if(effToDt[i] != null)
							model.setEffToDt(effToDt[i]);
				if(agmtScgRtDivCd[i] != null)
							model.setAgmtScgRtDivCd(agmtScgRtDivCd[i]);
				if(currCd[i] != null)
							model.setCurrCd(currCd[i]);
				if(trspOneWyRt[i] != null)
							model.setTrspOneWyRt(trspOneWyRt[i]);
				if(trspRndRt[i] != null)
							model.setTrspRndRt(trspRndRt[i]);
				if(deltFlg[i] != null)
							model.setDeltFlg(deltFlg[i]);
				if(creUsrId[i] != null)
							model.setCreUsrId(creUsrId[i]);
				if(creDt[i] != null)
							model.setCreDt(creDt[i]);
				if(updUsrId[i] != null)
							model.setUpdUsrId(updUsrId[i]);
				if(updDt[i] != null)
							model.setUpdDt(updDt[i]);
			
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsAgmtScgRtHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrsAgmtScgRtHisVO[]
	 */
	public TrsAgmtScgRtHisVO[] getTrsAgmtScgRtHisVOs(){
		TrsAgmtScgRtHisVO[] vos = (TrsAgmtScgRtHisVO[])models.toArray(new TrsAgmtScgRtHisVO[models.size()]);
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

		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtOfcCtyCd = this.trspAgmtOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");	
		this.trspAgmtSeq = this.trspAgmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtTpSerNo = this.trspAgmtRtTpSerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtScgNodSeq = this.trspAgmtScgNodSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtScgRtSeq = this.trspAgmtScgRtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtRtHisSeq = this.trspAgmtRtHisSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspAgmtEqTpSzCd = this.trspAgmtEqTpSzCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toWgt = this.toWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtMeasUtCd = this.wgtMeasUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtScgRtDivCd = this.agmtScgRtDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspOneWyRt = this.trspOneWyRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRndRt = this.trspRndRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	
	}
}
