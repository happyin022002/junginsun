/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandCostTariffInfoVO.java
*@FileTitle : InlandCostTariffInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.18
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.06.18 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.costmanage.inlandcostmanage.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InlandCostTariffInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InlandCostTariffInfoVO> models = new ArrayList<InlandCostTariffInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String costTrfStsNm = null;
	/* Column Info */
	private String costTrfStsCd = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String ioBndNm = null;
	/* Column Info */
	private String costTrfBatSeq = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String nextTrfFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InlandCostTariffInfoVO() {}

	public InlandCostTariffInfoVO(String ibflag, String pagerows, String ioBndCd, String ioBndNm, String costTrfStsCd, String costTrfStsNm, String currCd, String effFmDt, String updDt, String updUsrId, String nextTrfFlg, String costTrfBatSeq) {
		this.updDt = updDt;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.costTrfStsNm = costTrfStsNm;
		this.costTrfStsCd = costTrfStsCd;
		this.effFmDt = effFmDt;
		this.ioBndNm = ioBndNm;
		this.costTrfBatSeq = costTrfBatSeq;
		this.ioBndCd = ioBndCd;
		this.nextTrfFlg = nextTrfFlg;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cost_trf_sts_nm", getCostTrfStsNm());
		this.hashColumns.put("cost_trf_sts_cd", getCostTrfStsCd());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("io_bnd_nm", getIoBndNm());
		this.hashColumns.put("cost_trf_bat_seq", getCostTrfBatSeq());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("next_trf_flg", getNextTrfFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cost_trf_sts_nm", "costTrfStsNm");
		this.hashFields.put("cost_trf_sts_cd", "costTrfStsCd");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("io_bnd_nm", "ioBndNm");
		this.hashFields.put("cost_trf_bat_seq", "costTrfBatSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("next_trf_flg", "nextTrfFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return costTrfStsNm
	 */
	public String getCostTrfStsNm() {
		return this.costTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @return costTrfStsCd
	 */
	public String getCostTrfStsCd() {
		return this.costTrfStsCd;
	}
	
	/**
	 * Column Info
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
	}
	
	/**
	 * Column Info
	 * @return ioBndNm
	 */
	public String getIoBndNm() {
		return this.ioBndNm;
	}
	
	/**
	 * Column Info
	 * @return costTrfBatSeq
	 */
	public String getCostTrfBatSeq() {
		return this.costTrfBatSeq;
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
	 * @return nextTrfFlg
	 */
	public String getNextTrfFlg() {
		return this.nextTrfFlg;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param costTrfStsNm
	 */
	public void setCostTrfStsNm(String costTrfStsNm) {
		this.costTrfStsNm = costTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @param costTrfStsCd
	 */
	public void setCostTrfStsCd(String costTrfStsCd) {
		this.costTrfStsCd = costTrfStsCd;
	}
	
	/**
	 * Column Info
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
	}
	
	/**
	 * Column Info
	 * @param ioBndNm
	 */
	public void setIoBndNm(String ioBndNm) {
		this.ioBndNm = ioBndNm;
	}
	
	/**
	 * Column Info
	 * @param costTrfBatSeq
	 */
	public void setCostTrfBatSeq(String costTrfBatSeq) {
		this.costTrfBatSeq = costTrfBatSeq;
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
	 * @param nextTrfFlg
	 */
	public void setNextTrfFlg(String nextTrfFlg) {
		this.nextTrfFlg = nextTrfFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setCostTrfStsNm(JSPUtil.getParameter(request, prefix + "cost_trf_sts_nm", ""));
		setCostTrfStsCd(JSPUtil.getParameter(request, prefix + "cost_trf_sts_cd", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setIoBndNm(JSPUtil.getParameter(request, prefix + "io_bnd_nm", ""));
		setCostTrfBatSeq(JSPUtil.getParameter(request, prefix + "cost_trf_bat_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setNextTrfFlg(JSPUtil.getParameter(request, prefix + "next_trf_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InlandCostTariffInfoVO[]
	 */
	public InlandCostTariffInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InlandCostTariffInfoVO[]
	 */
	public InlandCostTariffInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InlandCostTariffInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] costTrfStsNm = (JSPUtil.getParameter(request, prefix	+ "cost_trf_sts_nm", length));
			String[] costTrfStsCd = (JSPUtil.getParameter(request, prefix	+ "cost_trf_sts_cd", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] ioBndNm = (JSPUtil.getParameter(request, prefix	+ "io_bnd_nm", length));
			String[] costTrfBatSeq = (JSPUtil.getParameter(request, prefix	+ "cost_trf_bat_seq", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] nextTrfFlg = (JSPUtil.getParameter(request, prefix	+ "next_trf_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InlandCostTariffInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (costTrfStsNm[i] != null)
					model.setCostTrfStsNm(costTrfStsNm[i]);
				if (costTrfStsCd[i] != null)
					model.setCostTrfStsCd(costTrfStsCd[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (ioBndNm[i] != null)
					model.setIoBndNm(ioBndNm[i]);
				if (costTrfBatSeq[i] != null)
					model.setCostTrfBatSeq(costTrfBatSeq[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (nextTrfFlg[i] != null)
					model.setNextTrfFlg(nextTrfFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInlandCostTariffInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InlandCostTariffInfoVO[]
	 */
	public InlandCostTariffInfoVO[] getInlandCostTariffInfoVOs(){
		InlandCostTariffInfoVO[] vos = (InlandCostTariffInfoVO[])models.toArray(new InlandCostTariffInfoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfStsNm = this.costTrfStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfStsCd = this.costTrfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndNm = this.ioBndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costTrfBatSeq = this.costTrfBatSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextTrfFlg = this.nextTrfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
