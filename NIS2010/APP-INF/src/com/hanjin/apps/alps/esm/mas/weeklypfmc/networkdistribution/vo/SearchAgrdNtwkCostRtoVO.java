/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : SearchAgrdNtwkCostRtoVO.java
*@FileTitle : SearchAgrdNtwkCostRtoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.20
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.20 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class SearchAgrdNtwkCostRtoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAgrdNtwkCostRtoVO> models = new ArrayList<SearchAgrdNtwkCostRtoVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ovrUsdAlocChgFlg = null;
	/* Column Info */
	private String costYrmonSeq = null;
	/* Column Info */
	private String rlaneCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String grpSeq = null;
	/* Column Info */
	private String hulBndCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bzcAlocTpCd = null;
	/* Column Info */
	private String loclTsStsCd = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String bzcAlocFxAmt = null;
	/* Column Info */
	private String bzcAlocRto = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String ovrUsdAlocChgRto = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchAgrdNtwkCostRtoVO() {}

	public SearchAgrdNtwkCostRtoVO(String ibflag, String pagerows, String costYrmon, String costYrmonSeq, String grpSeq, String trdCd, String rlaneCd, String iocCd, String dirCd, String bzcAlocTpCd, String bzcAlocRto, String bzcAlocFxAmt, String ovrUsdAlocChgFlg, String ovrUsdAlocChgRto, String loclTsStsCd, String hulBndCd) {
		this.pagerows = pagerows;
		this.ovrUsdAlocChgFlg = ovrUsdAlocChgFlg;
		this.costYrmonSeq = costYrmonSeq;
		this.rlaneCd = rlaneCd;
		this.ibflag = ibflag;
		this.iocCd = iocCd;
		this.grpSeq = grpSeq;
		this.hulBndCd = hulBndCd;
		this.trdCd = trdCd;
		this.bzcAlocTpCd = bzcAlocTpCd;
		this.loclTsStsCd = loclTsStsCd;
		this.costYrmon = costYrmon;
		this.bzcAlocFxAmt = bzcAlocFxAmt;
		this.bzcAlocRto = bzcAlocRto;
		this.dirCd = dirCd;
		this.ovrUsdAlocChgRto = ovrUsdAlocChgRto;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ovr_usd_aloc_chg_flg", getOvrUsdAlocChgFlg());
		this.hashColumns.put("cost_yrmon_seq", getCostYrmonSeq());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("grp_seq", getGrpSeq());
		this.hashColumns.put("hul_bnd_cd", getHulBndCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bzc_aloc_tp_cd", getBzcAlocTpCd());
		this.hashColumns.put("locl_ts_sts_cd", getLoclTsStsCd());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("bzc_aloc_fx_amt", getBzcAlocFxAmt());
		this.hashColumns.put("bzc_aloc_rto", getBzcAlocRto());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("ovr_usd_aloc_chg_rto", getOvrUsdAlocChgRto());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ovr_usd_aloc_chg_flg", "ovrUsdAlocChgFlg");
		this.hashFields.put("cost_yrmon_seq", "costYrmonSeq");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("grp_seq", "grpSeq");
		this.hashFields.put("hul_bnd_cd", "hulBndCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bzc_aloc_tp_cd", "bzcAlocTpCd");
		this.hashFields.put("locl_ts_sts_cd", "loclTsStsCd");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("bzc_aloc_fx_amt", "bzcAlocFxAmt");
		this.hashFields.put("bzc_aloc_rto", "bzcAlocRto");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("ovr_usd_aloc_chg_rto", "ovrUsdAlocChgRto");
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
	 * Column Info
	 * @return ovrUsdAlocChgFlg
	 */
	public String getOvrUsdAlocChgFlg() {
		return this.ovrUsdAlocChgFlg;
	}
	
	/**
	 * Column Info
	 * @return costYrmonSeq
	 */
	public String getCostYrmonSeq() {
		return this.costYrmonSeq;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return grpSeq
	 */
	public String getGrpSeq() {
		return this.grpSeq;
	}
	
	/**
	 * Column Info
	 * @return hulBndCd
	 */
	public String getHulBndCd() {
		return this.hulBndCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return bzcAlocTpCd
	 */
	public String getBzcAlocTpCd() {
		return this.bzcAlocTpCd;
	}
	
	/**
	 * Column Info
	 * @return loclTsStsCd
	 */
	public String getLoclTsStsCd() {
		return this.loclTsStsCd;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return bzcAlocFxAmt
	 */
	public String getBzcAlocFxAmt() {
		return this.bzcAlocFxAmt;
	}
	
	/**
	 * Column Info
	 * @return bzcAlocRto
	 */
	public String getBzcAlocRto() {
		return this.bzcAlocRto;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return ovrUsdAlocChgRto
	 */
	public String getOvrUsdAlocChgRto() {
		return this.ovrUsdAlocChgRto;
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
	 * @param ovrUsdAlocChgFlg
	 */
	public void setOvrUsdAlocChgFlg(String ovrUsdAlocChgFlg) {
		this.ovrUsdAlocChgFlg = ovrUsdAlocChgFlg;
	}
	
	/**
	 * Column Info
	 * @param costYrmonSeq
	 */
	public void setCostYrmonSeq(String costYrmonSeq) {
		this.costYrmonSeq = costYrmonSeq;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param grpSeq
	 */
	public void setGrpSeq(String grpSeq) {
		this.grpSeq = grpSeq;
	}
	
	/**
	 * Column Info
	 * @param hulBndCd
	 */
	public void setHulBndCd(String hulBndCd) {
		this.hulBndCd = hulBndCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param bzcAlocTpCd
	 */
	public void setBzcAlocTpCd(String bzcAlocTpCd) {
		this.bzcAlocTpCd = bzcAlocTpCd;
	}
	
	/**
	 * Column Info
	 * @param loclTsStsCd
	 */
	public void setLoclTsStsCd(String loclTsStsCd) {
		this.loclTsStsCd = loclTsStsCd;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param bzcAlocFxAmt
	 */
	public void setBzcAlocFxAmt(String bzcAlocFxAmt) {
		this.bzcAlocFxAmt = bzcAlocFxAmt;
	}
	
	/**
	 * Column Info
	 * @param bzcAlocRto
	 */
	public void setBzcAlocRto(String bzcAlocRto) {
		this.bzcAlocRto = bzcAlocRto;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param ovrUsdAlocChgRto
	 */
	public void setOvrUsdAlocChgRto(String ovrUsdAlocChgRto) {
		this.ovrUsdAlocChgRto = ovrUsdAlocChgRto;
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
		setOvrUsdAlocChgFlg(JSPUtil.getParameter(request, prefix + "ovr_usd_aloc_chg_flg", ""));
		setCostYrmonSeq(JSPUtil.getParameter(request, prefix + "cost_yrmon_seq", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setGrpSeq(JSPUtil.getParameter(request, prefix + "grp_seq", ""));
		setHulBndCd(JSPUtil.getParameter(request, prefix + "hul_bnd_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setBzcAlocTpCd(JSPUtil.getParameter(request, prefix + "bzc_aloc_tp_cd", ""));
		setLoclTsStsCd(JSPUtil.getParameter(request, prefix + "locl_ts_sts_cd", ""));
		setCostYrmon(JSPUtil.getParameter(request, prefix + "cost_yrmon", ""));
		setBzcAlocFxAmt(JSPUtil.getParameter(request, prefix + "bzc_aloc_fx_amt", ""));
		setBzcAlocRto(JSPUtil.getParameter(request, prefix + "bzc_aloc_rto", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setOvrUsdAlocChgRto(JSPUtil.getParameter(request, prefix + "ovr_usd_aloc_chg_rto", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAgrdNtwkCostRtoVO[]
	 */
	public SearchAgrdNtwkCostRtoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAgrdNtwkCostRtoVO[]
	 */
	public SearchAgrdNtwkCostRtoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAgrdNtwkCostRtoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ovrUsdAlocChgFlg = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_aloc_chg_flg", length));
			String[] costYrmonSeq = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon_seq", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] grpSeq = (JSPUtil.getParameter(request, prefix	+ "grp_seq", length));
			String[] hulBndCd = (JSPUtil.getParameter(request, prefix	+ "hul_bnd_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bzcAlocTpCd = (JSPUtil.getParameter(request, prefix	+ "bzc_aloc_tp_cd", length));
			String[] loclTsStsCd = (JSPUtil.getParameter(request, prefix	+ "locl_ts_sts_cd", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] bzcAlocFxAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_aloc_fx_amt", length));
			String[] bzcAlocRto = (JSPUtil.getParameter(request, prefix	+ "bzc_aloc_rto", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] ovrUsdAlocChgRto = (JSPUtil.getParameter(request, prefix	+ "ovr_usd_aloc_chg_rto", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAgrdNtwkCostRtoVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ovrUsdAlocChgFlg[i] != null)
					model.setOvrUsdAlocChgFlg(ovrUsdAlocChgFlg[i]);
				if (costYrmonSeq[i] != null)
					model.setCostYrmonSeq(costYrmonSeq[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (grpSeq[i] != null)
					model.setGrpSeq(grpSeq[i]);
				if (hulBndCd[i] != null)
					model.setHulBndCd(hulBndCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bzcAlocTpCd[i] != null)
					model.setBzcAlocTpCd(bzcAlocTpCd[i]);
				if (loclTsStsCd[i] != null)
					model.setLoclTsStsCd(loclTsStsCd[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (bzcAlocFxAmt[i] != null)
					model.setBzcAlocFxAmt(bzcAlocFxAmt[i]);
				if (bzcAlocRto[i] != null)
					model.setBzcAlocRto(bzcAlocRto[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (ovrUsdAlocChgRto[i] != null)
					model.setOvrUsdAlocChgRto(ovrUsdAlocChgRto[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAgrdNtwkCostRtoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAgrdNtwkCostRtoVO[]
	 */
	public SearchAgrdNtwkCostRtoVO[] getSearchAgrdNtwkCostRtoVOs(){
		SearchAgrdNtwkCostRtoVO[] vos = (SearchAgrdNtwkCostRtoVO[])models.toArray(new SearchAgrdNtwkCostRtoVO[models.size()]);
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
		this.ovrUsdAlocChgFlg = this.ovrUsdAlocChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmonSeq = this.costYrmonSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpSeq = this.grpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hulBndCd = this.hulBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAlocTpCd = this.bzcAlocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTsStsCd = this.loclTsStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAlocFxAmt = this.bzcAlocFxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAlocRto = this.bzcAlocRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrUsdAlocChgRto = this.ovrUsdAlocChgRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
