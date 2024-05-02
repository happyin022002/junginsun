/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RsltFicRateByRouteVO.java
*@FileTitle : RsltFicRateByRouteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.31
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2012.07.31 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltFicRateByRouteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltFicRateByRouteVO> models = new ArrayList<RsltFicRateByRouteVO>();
	
	/* Column Info */
	private String rf40ftAmt = null;
	/* Column Info */
	private String drLocl20ftAmt = null;
	/* Column Info */
	private String optmTrspModFlg = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String dgLocl20ftAmt = null;
	/* Column Info */
	private String ficRtUseStsCd = null;
	/* Column Info */
	private String dg40ftAmt = null;
	/* Column Info */
	private String rfLocl20ftAmt = null;
	/* Column Info */
	private String rfLocl40ftAmt = null;
	/* Column Info */
	private String rf20ftAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dgLocl40ftAmt = null;
	/* Column Info */
	private String dg20ftAmt = null;
	/* Column Info */
	private String drLocl40ftAmt = null;
	/* Column Info */
	private String dr20ftAmt = null;
	/* Column Info */
	private String dr40ftAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltFicRateByRouteVO() {}

	public RsltFicRateByRouteVO(String ibflag, String pagerows, String ficRtUseStsCd, String optmTrspModFlg, String dr20ftAmt, String rf20ftAmt, String dg20ftAmt, String dr40ftAmt, String rf40ftAmt, String dg40ftAmt, String loclCurrCd, String drLocl20ftAmt, String rfLocl20ftAmt, String dgLocl20ftAmt, String drLocl40ftAmt, String rfLocl40ftAmt, String dgLocl40ftAmt) {
		this.rf40ftAmt = rf40ftAmt;
		this.drLocl20ftAmt = drLocl20ftAmt;
		this.optmTrspModFlg = optmTrspModFlg;
		this.loclCurrCd = loclCurrCd;
		this.dgLocl20ftAmt = dgLocl20ftAmt;
		this.ficRtUseStsCd = ficRtUseStsCd;
		this.dg40ftAmt = dg40ftAmt;
		this.rfLocl20ftAmt = rfLocl20ftAmt;
		this.rfLocl40ftAmt = rfLocl40ftAmt;
		this.rf20ftAmt = rf20ftAmt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.dgLocl40ftAmt = dgLocl40ftAmt;
		this.dg20ftAmt = dg20ftAmt;
		this.drLocl40ftAmt = drLocl40ftAmt;
		this.dr20ftAmt = dr20ftAmt;
		this.dr40ftAmt = dr40ftAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rf_40ft_amt", getRf40ftAmt());
		this.hashColumns.put("dr_locl_20ft_amt", getDrLocl20ftAmt());
		this.hashColumns.put("optm_trsp_mod_flg", getOptmTrspModFlg());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("dg_locl_20ft_amt", getDgLocl20ftAmt());
		this.hashColumns.put("fic_rt_use_sts_cd", getFicRtUseStsCd());
		this.hashColumns.put("dg_40ft_amt", getDg40ftAmt());
		this.hashColumns.put("rf_locl_20ft_amt", getRfLocl20ftAmt());
		this.hashColumns.put("rf_locl_40ft_amt", getRfLocl40ftAmt());
		this.hashColumns.put("rf_20ft_amt", getRf20ftAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dg_locl_40ft_amt", getDgLocl40ftAmt());
		this.hashColumns.put("dg_20ft_amt", getDg20ftAmt());
		this.hashColumns.put("dr_locl_40ft_amt", getDrLocl40ftAmt());
		this.hashColumns.put("dr_20ft_amt", getDr20ftAmt());
		this.hashColumns.put("dr_40ft_amt", getDr40ftAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rf_40ft_amt", "rf40ftAmt");
		this.hashFields.put("dr_locl_20ft_amt", "drLocl20ftAmt");
		this.hashFields.put("optm_trsp_mod_flg", "optmTrspModFlg");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("dg_locl_20ft_amt", "dgLocl20ftAmt");
		this.hashFields.put("fic_rt_use_sts_cd", "ficRtUseStsCd");
		this.hashFields.put("dg_40ft_amt", "dg40ftAmt");
		this.hashFields.put("rf_locl_20ft_amt", "rfLocl20ftAmt");
		this.hashFields.put("rf_locl_40ft_amt", "rfLocl40ftAmt");
		this.hashFields.put("rf_20ft_amt", "rf20ftAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dg_locl_40ft_amt", "dgLocl40ftAmt");
		this.hashFields.put("dg_20ft_amt", "dg20ftAmt");
		this.hashFields.put("dr_locl_40ft_amt", "drLocl40ftAmt");
		this.hashFields.put("dr_20ft_amt", "dr20ftAmt");
		this.hashFields.put("dr_40ft_amt", "dr40ftAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rf40ftAmt
	 */
	public String getRf40ftAmt() {
		return this.rf40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return drLocl20ftAmt
	 */
	public String getDrLocl20ftAmt() {
		return this.drLocl20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return optmTrspModFlg
	 */
	public String getOptmTrspModFlg() {
		return this.optmTrspModFlg;
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
	 * @return dgLocl20ftAmt
	 */
	public String getDgLocl20ftAmt() {
		return this.dgLocl20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return ficRtUseStsCd
	 */
	public String getFicRtUseStsCd() {
		return this.ficRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @return dg40ftAmt
	 */
	public String getDg40ftAmt() {
		return this.dg40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return rfLocl20ftAmt
	 */
	public String getRfLocl20ftAmt() {
		return this.rfLocl20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return rfLocl40ftAmt
	 */
	public String getRfLocl40ftAmt() {
		return this.rfLocl40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return rf20ftAmt
	 */
	public String getRf20ftAmt() {
		return this.rf20ftAmt;
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
	
	/**
	 * Column Info
	 * @return dgLocl40ftAmt
	 */
	public String getDgLocl40ftAmt() {
		return this.dgLocl40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return dg20ftAmt
	 */
	public String getDg20ftAmt() {
		return this.dg20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return drLocl40ftAmt
	 */
	public String getDrLocl40ftAmt() {
		return this.drLocl40ftAmt;
	}
	
	/**
	 * Column Info
	 * @return dr20ftAmt
	 */
	public String getDr20ftAmt() {
		return this.dr20ftAmt;
	}
	
	/**
	 * Column Info
	 * @return dr40ftAmt
	 */
	public String getDr40ftAmt() {
		return this.dr40ftAmt;
	}
	

	/**
	 * Column Info
	 * @param rf40ftAmt
	 */
	public void setRf40ftAmt(String rf40ftAmt) {
		this.rf40ftAmt = rf40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param drLocl20ftAmt
	 */
	public void setDrLocl20ftAmt(String drLocl20ftAmt) {
		this.drLocl20ftAmt = drLocl20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param optmTrspModFlg
	 */
	public void setOptmTrspModFlg(String optmTrspModFlg) {
		this.optmTrspModFlg = optmTrspModFlg;
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
	 * @param dgLocl20ftAmt
	 */
	public void setDgLocl20ftAmt(String dgLocl20ftAmt) {
		this.dgLocl20ftAmt = dgLocl20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param ficRtUseStsCd
	 */
	public void setFicRtUseStsCd(String ficRtUseStsCd) {
		this.ficRtUseStsCd = ficRtUseStsCd;
	}
	
	/**
	 * Column Info
	 * @param dg40ftAmt
	 */
	public void setDg40ftAmt(String dg40ftAmt) {
		this.dg40ftAmt = dg40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param rfLocl20ftAmt
	 */
	public void setRfLocl20ftAmt(String rfLocl20ftAmt) {
		this.rfLocl20ftAmt = rfLocl20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param rfLocl40ftAmt
	 */
	public void setRfLocl40ftAmt(String rfLocl40ftAmt) {
		this.rfLocl40ftAmt = rfLocl40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param rf20ftAmt
	 */
	public void setRf20ftAmt(String rf20ftAmt) {
		this.rf20ftAmt = rf20ftAmt;
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
	
	/**
	 * Column Info
	 * @param dgLocl40ftAmt
	 */
	public void setDgLocl40ftAmt(String dgLocl40ftAmt) {
		this.dgLocl40ftAmt = dgLocl40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param dg20ftAmt
	 */
	public void setDg20ftAmt(String dg20ftAmt) {
		this.dg20ftAmt = dg20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param drLocl40ftAmt
	 */
	public void setDrLocl40ftAmt(String drLocl40ftAmt) {
		this.drLocl40ftAmt = drLocl40ftAmt;
	}
	
	/**
	 * Column Info
	 * @param dr20ftAmt
	 */
	public void setDr20ftAmt(String dr20ftAmt) {
		this.dr20ftAmt = dr20ftAmt;
	}
	
	/**
	 * Column Info
	 * @param dr40ftAmt
	 */
	public void setDr40ftAmt(String dr40ftAmt) {
		this.dr40ftAmt = dr40ftAmt;
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
		setRf40ftAmt(JSPUtil.getParameter(request, prefix + "rf_40ft_amt", ""));
		setDrLocl20ftAmt(JSPUtil.getParameter(request, prefix + "dr_locl_20ft_amt", ""));
		setOptmTrspModFlg(JSPUtil.getParameter(request, prefix + "optm_trsp_mod_flg", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, prefix + "locl_curr_cd", ""));
		setDgLocl20ftAmt(JSPUtil.getParameter(request, prefix + "dg_locl_20ft_amt", ""));
		setFicRtUseStsCd(JSPUtil.getParameter(request, prefix + "fic_rt_use_sts_cd", ""));
		setDg40ftAmt(JSPUtil.getParameter(request, prefix + "dg_40ft_amt", ""));
		setRfLocl20ftAmt(JSPUtil.getParameter(request, prefix + "rf_locl_20ft_amt", ""));
		setRfLocl40ftAmt(JSPUtil.getParameter(request, prefix + "rf_locl_40ft_amt", ""));
		setRf20ftAmt(JSPUtil.getParameter(request, prefix + "rf_20ft_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDgLocl40ftAmt(JSPUtil.getParameter(request, prefix + "dg_locl_40ft_amt", ""));
		setDg20ftAmt(JSPUtil.getParameter(request, prefix + "dg_20ft_amt", ""));
		setDrLocl40ftAmt(JSPUtil.getParameter(request, prefix + "dr_locl_40ft_amt", ""));
		setDr20ftAmt(JSPUtil.getParameter(request, prefix + "dr_20ft_amt", ""));
		setDr40ftAmt(JSPUtil.getParameter(request, prefix + "dr_40ft_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltFicRateByRouteVO[]
	 */
	public RsltFicRateByRouteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltFicRateByRouteVO[]
	 */
	public RsltFicRateByRouteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltFicRateByRouteVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rf40ftAmt = (JSPUtil.getParameter(request, prefix	+ "rf_40ft_amt", length));
			String[] drLocl20ftAmt = (JSPUtil.getParameter(request, prefix	+ "dr_locl_20ft_amt", length));
			String[] optmTrspModFlg = (JSPUtil.getParameter(request, prefix	+ "optm_trsp_mod_flg", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] dgLocl20ftAmt = (JSPUtil.getParameter(request, prefix	+ "dg_locl_20ft_amt", length));
			String[] ficRtUseStsCd = (JSPUtil.getParameter(request, prefix	+ "fic_rt_use_sts_cd", length));
			String[] dg40ftAmt = (JSPUtil.getParameter(request, prefix	+ "dg_40ft_amt", length));
			String[] rfLocl20ftAmt = (JSPUtil.getParameter(request, prefix	+ "rf_locl_20ft_amt", length));
			String[] rfLocl40ftAmt = (JSPUtil.getParameter(request, prefix	+ "rf_locl_40ft_amt", length));
			String[] rf20ftAmt = (JSPUtil.getParameter(request, prefix	+ "rf_20ft_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dgLocl40ftAmt = (JSPUtil.getParameter(request, prefix	+ "dg_locl_40ft_amt", length));
			String[] dg20ftAmt = (JSPUtil.getParameter(request, prefix	+ "dg_20ft_amt", length));
			String[] drLocl40ftAmt = (JSPUtil.getParameter(request, prefix	+ "dr_locl_40ft_amt", length));
			String[] dr20ftAmt = (JSPUtil.getParameter(request, prefix	+ "dr_20ft_amt", length));
			String[] dr40ftAmt = (JSPUtil.getParameter(request, prefix	+ "dr_40ft_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltFicRateByRouteVO();
				if (rf40ftAmt[i] != null)
					model.setRf40ftAmt(rf40ftAmt[i]);
				if (drLocl20ftAmt[i] != null)
					model.setDrLocl20ftAmt(drLocl20ftAmt[i]);
				if (optmTrspModFlg[i] != null)
					model.setOptmTrspModFlg(optmTrspModFlg[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (dgLocl20ftAmt[i] != null)
					model.setDgLocl20ftAmt(dgLocl20ftAmt[i]);
				if (ficRtUseStsCd[i] != null)
					model.setFicRtUseStsCd(ficRtUseStsCd[i]);
				if (dg40ftAmt[i] != null)
					model.setDg40ftAmt(dg40ftAmt[i]);
				if (rfLocl20ftAmt[i] != null)
					model.setRfLocl20ftAmt(rfLocl20ftAmt[i]);
				if (rfLocl40ftAmt[i] != null)
					model.setRfLocl40ftAmt(rfLocl40ftAmt[i]);
				if (rf20ftAmt[i] != null)
					model.setRf20ftAmt(rf20ftAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dgLocl40ftAmt[i] != null)
					model.setDgLocl40ftAmt(dgLocl40ftAmt[i]);
				if (dg20ftAmt[i] != null)
					model.setDg20ftAmt(dg20ftAmt[i]);
				if (drLocl40ftAmt[i] != null)
					model.setDrLocl40ftAmt(drLocl40ftAmt[i]);
				if (dr20ftAmt[i] != null)
					model.setDr20ftAmt(dr20ftAmt[i]);
				if (dr40ftAmt[i] != null)
					model.setDr40ftAmt(dr40ftAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltFicRateByRouteVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltFicRateByRouteVO[]
	 */
	public RsltFicRateByRouteVO[] getRsltFicRateByRouteVOs(){
		RsltFicRateByRouteVO[] vos = (RsltFicRateByRouteVO[])models.toArray(new RsltFicRateByRouteVO[models.size()]);
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
		this.rf40ftAmt = this.rf40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drLocl20ftAmt = this.drLocl20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmTrspModFlg = this.optmTrspModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgLocl20ftAmt = this.dgLocl20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ficRtUseStsCd = this.ficRtUseStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40ftAmt = this.dg40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfLocl20ftAmt = this.rfLocl20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfLocl40ftAmt = this.rfLocl40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20ftAmt = this.rf20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgLocl40ftAmt = this.dgLocl40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20ftAmt = this.dg20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drLocl40ftAmt = this.drLocl40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dr20ftAmt = this.dr20ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dr40ftAmt = this.dr40ftAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
