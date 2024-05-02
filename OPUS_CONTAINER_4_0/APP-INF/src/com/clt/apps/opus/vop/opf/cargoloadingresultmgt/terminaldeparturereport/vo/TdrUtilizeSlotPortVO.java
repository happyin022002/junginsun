/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TdrUtilizeSlotPortVO.java
*@FileTitle : TdrUtilizeSlotPortVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2010.01.22 장석현 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장석현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TdrUtilizeSlotPortVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TdrUtilizeSlotPortVO> models = new ArrayList<TdrUtilizeSlotPortVO>();
	
	/* Column Info */
	private String tradeSubSlot = null;
	/* Column Info */
	private String bsaWgt = null;
	/* Column Info */
	private String tradeMt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String releaseSlot = null;
	/* Column Info */
	private String tradeSubWgt = null;
	/* Column Info */
	private String overSlot = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String interSubWgt = null;
	/* Column Info */
	private String interSubSlot = null;
	/* Column Info */
	private String bsaSlot = null;
	/* Column Info */
	private String inter45 = null;
	/* Column Info */
	private String tradeFull = null;
	/* Column Info */
	private String interMt = null;
	/* Column Info */
	private String bsaType = null;
	/* Column Info */
	private String interFull = null;
	/* Column Info */
	private String ratioType = null;
	/* Column Info */
	private String releaseWgt = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String overWgt = null;
	/* Column Info */
	private String overSettle = null;
	/* Column Info */
	private String grandTtlSlot = null;
	/* Column Info */
	private String tradeAb = null;
	/* Column Info */
	private String overSettleBy = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String grandTtlWgt = null;
	/* Column Info */
	private String trade45 = null;
	/* Column Info */
	private String interAb = null;
	/* Column Info */
	private String teu = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TdrUtilizeSlotPortVO() {}

	public TdrUtilizeSlotPortVO(String ibflag, String pagerows, String oprCd, String tradeFull, String tradeMt, String tradeAb, String trade45, String tradeSubSlot, String tradeSubWgt, String interFull, String interMt, String interAb, String inter45, String interSubSlot, String interSubWgt, String grandTtlSlot, String grandTtlWgt, String ratioType, String bsaType, String bsaSlot, String bsaWgt, String teu, String releaseSlot, String releaseWgt, String status, String overSlot, String overWgt, String overSettle, String overSettleBy) {
		this.tradeSubSlot = tradeSubSlot;
		this.bsaWgt = bsaWgt;
		this.tradeMt = tradeMt;
		this.pagerows = pagerows;
		this.releaseSlot = releaseSlot;
		this.tradeSubWgt = tradeSubWgt;
		this.overSlot = overSlot;
		this.ibflag = ibflag;
		this.interSubWgt = interSubWgt;
		this.interSubSlot = interSubSlot;
		this.bsaSlot = bsaSlot;
		this.inter45 = inter45;
		this.tradeFull = tradeFull;
		this.interMt = interMt;
		this.bsaType = bsaType;
		this.interFull = interFull;
		this.ratioType = ratioType;
		this.releaseWgt = releaseWgt;
		this.status = status;
		this.overWgt = overWgt;
		this.overSettle = overSettle;
		this.grandTtlSlot = grandTtlSlot;
		this.tradeAb = tradeAb;
		this.overSettleBy = overSettleBy;
		this.oprCd = oprCd;
		this.grandTtlWgt = grandTtlWgt;
		this.trade45 = trade45;
		this.interAb = interAb;
		this.teu = teu;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("trade_sub_slot", getTradeSubSlot());
		this.hashColumns.put("bsa_wgt", getBsaWgt());
		this.hashColumns.put("trade_mt", getTradeMt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("release_slot", getReleaseSlot());
		this.hashColumns.put("trade_sub_wgt", getTradeSubWgt());
		this.hashColumns.put("over_slot", getOverSlot());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inter_sub_wgt", getInterSubWgt());
		this.hashColumns.put("inter_sub_slot", getInterSubSlot());
		this.hashColumns.put("bsa_slot", getBsaSlot());
		this.hashColumns.put("inter_45", getInter45());
		this.hashColumns.put("trade_full", getTradeFull());
		this.hashColumns.put("inter_mt", getInterMt());
		this.hashColumns.put("bsa_type", getBsaType());
		this.hashColumns.put("inter_full", getInterFull());
		this.hashColumns.put("ratio_type", getRatioType());
		this.hashColumns.put("release_wgt", getReleaseWgt());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("over_wgt", getOverWgt());
		this.hashColumns.put("over_settle", getOverSettle());
		this.hashColumns.put("grand_ttl_slot", getGrandTtlSlot());
		this.hashColumns.put("trade_ab", getTradeAb());
		this.hashColumns.put("over_settle_by", getOverSettleBy());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("grand_ttl_wgt", getGrandTtlWgt());
		this.hashColumns.put("trade_45", getTrade45());
		this.hashColumns.put("inter_ab", getInterAb());
		this.hashColumns.put("teu", getTeu());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("trade_sub_slot", "tradeSubSlot");
		this.hashFields.put("bsa_wgt", "bsaWgt");
		this.hashFields.put("trade_mt", "tradeMt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("release_slot", "releaseSlot");
		this.hashFields.put("trade_sub_wgt", "tradeSubWgt");
		this.hashFields.put("over_slot", "overSlot");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inter_sub_wgt", "interSubWgt");
		this.hashFields.put("inter_sub_slot", "interSubSlot");
		this.hashFields.put("bsa_slot", "bsaSlot");
		this.hashFields.put("inter_45", "inter45");
		this.hashFields.put("trade_full", "tradeFull");
		this.hashFields.put("inter_mt", "interMt");
		this.hashFields.put("bsa_type", "bsaType");
		this.hashFields.put("inter_full", "interFull");
		this.hashFields.put("ratio_type", "ratioType");
		this.hashFields.put("release_wgt", "releaseWgt");
		this.hashFields.put("status", "status");
		this.hashFields.put("over_wgt", "overWgt");
		this.hashFields.put("over_settle", "overSettle");
		this.hashFields.put("grand_ttl_slot", "grandTtlSlot");
		this.hashFields.put("trade_ab", "tradeAb");
		this.hashFields.put("over_settle_by", "overSettleBy");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("grand_ttl_wgt", "grandTtlWgt");
		this.hashFields.put("trade_45", "trade45");
		this.hashFields.put("inter_ab", "interAb");
		this.hashFields.put("teu", "teu");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return tradeSubSlot
	 */
	public String getTradeSubSlot() {
		return this.tradeSubSlot;
	}
	
	/**
	 * Column Info
	 * @return bsaWgt
	 */
	public String getBsaWgt() {
		return this.bsaWgt;
	}
	
	/**
	 * Column Info
	 * @return tradeMt
	 */
	public String getTradeMt() {
		return this.tradeMt;
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
	 * @return releaseSlot
	 */
	public String getReleaseSlot() {
		return this.releaseSlot;
	}
	
	/**
	 * Column Info
	 * @return tradeSubWgt
	 */
	public String getTradeSubWgt() {
		return this.tradeSubWgt;
	}
	
	/**
	 * Column Info
	 * @return overSlot
	 */
	public String getOverSlot() {
		return this.overSlot;
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
	 * @return interSubWgt
	 */
	public String getInterSubWgt() {
		return this.interSubWgt;
	}
	
	/**
	 * Column Info
	 * @return interSubSlot
	 */
	public String getInterSubSlot() {
		return this.interSubSlot;
	}
	
	/**
	 * Column Info
	 * @return bsaSlot
	 */
	public String getBsaSlot() {
		return this.bsaSlot;
	}
	
	/**
	 * Column Info
	 * @return inter45
	 */
	public String getInter45() {
		return this.inter45;
	}
	
	/**
	 * Column Info
	 * @return tradeFull
	 */
	public String getTradeFull() {
		return this.tradeFull;
	}
	
	/**
	 * Column Info
	 * @return interMt
	 */
	public String getInterMt() {
		return this.interMt;
	}
	
	/**
	 * Column Info
	 * @return bsaType
	 */
	public String getBsaType() {
		return this.bsaType;
	}
	
	/**
	 * Column Info
	 * @return interFull
	 */
	public String getInterFull() {
		return this.interFull;
	}
	
	/**
	 * Column Info
	 * @return ratioType
	 */
	public String getRatioType() {
		return this.ratioType;
	}
	
	/**
	 * Column Info
	 * @return releaseWgt
	 */
	public String getReleaseWgt() {
		return this.releaseWgt;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return overWgt
	 */
	public String getOverWgt() {
		return this.overWgt;
	}
	
	/**
	 * Column Info
	 * @return overSettle
	 */
	public String getOverSettle() {
		return this.overSettle;
	}
	
	/**
	 * Column Info
	 * @return grandTtlSlot
	 */
	public String getGrandTtlSlot() {
		return this.grandTtlSlot;
	}
	
	/**
	 * Column Info
	 * @return tradeAb
	 */
	public String getTradeAb() {
		return this.tradeAb;
	}
	
	/**
	 * Column Info
	 * @return overSettleBy
	 */
	public String getOverSettleBy() {
		return this.overSettleBy;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return grandTtlWgt
	 */
	public String getGrandTtlWgt() {
		return this.grandTtlWgt;
	}
	
	/**
	 * Column Info
	 * @return trade45
	 */
	public String getTrade45() {
		return this.trade45;
	}
	
	/**
	 * Column Info
	 * @return interAb
	 */
	public String getInterAb() {
		return this.interAb;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	

	/**
	 * Column Info
	 * @param tradeSubSlot
	 */
	public void setTradeSubSlot(String tradeSubSlot) {
		this.tradeSubSlot = tradeSubSlot;
	}
	
	/**
	 * Column Info
	 * @param bsaWgt
	 */
	public void setBsaWgt(String bsaWgt) {
		this.bsaWgt = bsaWgt;
	}
	
	/**
	 * Column Info
	 * @param tradeMt
	 */
	public void setTradeMt(String tradeMt) {
		this.tradeMt = tradeMt;
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
	 * @param releaseSlot
	 */
	public void setReleaseSlot(String releaseSlot) {
		this.releaseSlot = releaseSlot;
	}
	
	/**
	 * Column Info
	 * @param tradeSubWgt
	 */
	public void setTradeSubWgt(String tradeSubWgt) {
		this.tradeSubWgt = tradeSubWgt;
	}
	
	/**
	 * Column Info
	 * @param overSlot
	 */
	public void setOverSlot(String overSlot) {
		this.overSlot = overSlot;
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
	 * @param interSubWgt
	 */
	public void setInterSubWgt(String interSubWgt) {
		this.interSubWgt = interSubWgt;
	}
	
	/**
	 * Column Info
	 * @param interSubSlot
	 */
	public void setInterSubSlot(String interSubSlot) {
		this.interSubSlot = interSubSlot;
	}
	
	/**
	 * Column Info
	 * @param bsaSlot
	 */
	public void setBsaSlot(String bsaSlot) {
		this.bsaSlot = bsaSlot;
	}
	
	/**
	 * Column Info
	 * @param inter45
	 */
	public void setInter45(String inter45) {
		this.inter45 = inter45;
	}
	
	/**
	 * Column Info
	 * @param tradeFull
	 */
	public void setTradeFull(String tradeFull) {
		this.tradeFull = tradeFull;
	}
	
	/**
	 * Column Info
	 * @param interMt
	 */
	public void setInterMt(String interMt) {
		this.interMt = interMt;
	}
	
	/**
	 * Column Info
	 * @param bsaType
	 */
	public void setBsaType(String bsaType) {
		this.bsaType = bsaType;
	}
	
	/**
	 * Column Info
	 * @param interFull
	 */
	public void setInterFull(String interFull) {
		this.interFull = interFull;
	}
	
	/**
	 * Column Info
	 * @param ratioType
	 */
	public void setRatioType(String ratioType) {
		this.ratioType = ratioType;
	}
	
	/**
	 * Column Info
	 * @param releaseWgt
	 */
	public void setReleaseWgt(String releaseWgt) {
		this.releaseWgt = releaseWgt;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param overWgt
	 */
	public void setOverWgt(String overWgt) {
		this.overWgt = overWgt;
	}
	
	/**
	 * Column Info
	 * @param overSettle
	 */
	public void setOverSettle(String overSettle) {
		this.overSettle = overSettle;
	}
	
	/**
	 * Column Info
	 * @param grandTtlSlot
	 */
	public void setGrandTtlSlot(String grandTtlSlot) {
		this.grandTtlSlot = grandTtlSlot;
	}
	
	/**
	 * Column Info
	 * @param tradeAb
	 */
	public void setTradeAb(String tradeAb) {
		this.tradeAb = tradeAb;
	}
	
	/**
	 * Column Info
	 * @param overSettleBy
	 */
	public void setOverSettleBy(String overSettleBy) {
		this.overSettleBy = overSettleBy;
	}
	
	/**
	 * Column Info
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param grandTtlWgt
	 */
	public void setGrandTtlWgt(String grandTtlWgt) {
		this.grandTtlWgt = grandTtlWgt;
	}
	
	/**
	 * Column Info
	 * @param trade45
	 */
	public void setTrade45(String trade45) {
		this.trade45 = trade45;
	}
	
	/**
	 * Column Info
	 * @param interAb
	 */
	public void setInterAb(String interAb) {
		this.interAb = interAb;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTradeSubSlot(JSPUtil.getParameter(request, "trade_sub_slot", ""));
		setBsaWgt(JSPUtil.getParameter(request, "bsa_wgt", ""));
		setTradeMt(JSPUtil.getParameter(request, "trade_mt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setReleaseSlot(JSPUtil.getParameter(request, "release_slot", ""));
		setTradeSubWgt(JSPUtil.getParameter(request, "trade_sub_wgt", ""));
		setOverSlot(JSPUtil.getParameter(request, "over_slot", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInterSubWgt(JSPUtil.getParameter(request, "inter_sub_wgt", ""));
		setInterSubSlot(JSPUtil.getParameter(request, "inter_sub_slot", ""));
		setBsaSlot(JSPUtil.getParameter(request, "bsa_slot", ""));
		setInter45(JSPUtil.getParameter(request, "inter_45", ""));
		setTradeFull(JSPUtil.getParameter(request, "trade_full", ""));
		setInterMt(JSPUtil.getParameter(request, "inter_mt", ""));
		setBsaType(JSPUtil.getParameter(request, "bsa_type", ""));
		setInterFull(JSPUtil.getParameter(request, "inter_full", ""));
		setRatioType(JSPUtil.getParameter(request, "ratio_type", ""));
		setReleaseWgt(JSPUtil.getParameter(request, "release_wgt", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setOverWgt(JSPUtil.getParameter(request, "over_wgt", ""));
		setOverSettle(JSPUtil.getParameter(request, "over_settle", ""));
		setGrandTtlSlot(JSPUtil.getParameter(request, "grand_ttl_slot", ""));
		setTradeAb(JSPUtil.getParameter(request, "trade_ab", ""));
		setOverSettleBy(JSPUtil.getParameter(request, "over_settle_by", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setGrandTtlWgt(JSPUtil.getParameter(request, "grand_ttl_wgt", ""));
		setTrade45(JSPUtil.getParameter(request, "trade_45", ""));
		setInterAb(JSPUtil.getParameter(request, "inter_ab", ""));
		setTeu(JSPUtil.getParameter(request, "teu", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TdrUtilizeSlotPortVO[]
	 */
	public TdrUtilizeSlotPortVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TdrUtilizeSlotPortVO[]
	 */
	public TdrUtilizeSlotPortVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TdrUtilizeSlotPortVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tradeSubSlot = (JSPUtil.getParameter(request, prefix	+ "trade_sub_slot", length));
			String[] bsaWgt = (JSPUtil.getParameter(request, prefix	+ "bsa_wgt", length));
			String[] tradeMt = (JSPUtil.getParameter(request, prefix	+ "trade_mt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] releaseSlot = (JSPUtil.getParameter(request, prefix	+ "release_slot", length));
			String[] tradeSubWgt = (JSPUtil.getParameter(request, prefix	+ "trade_sub_wgt", length));
			String[] overSlot = (JSPUtil.getParameter(request, prefix	+ "over_slot", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] interSubWgt = (JSPUtil.getParameter(request, prefix	+ "inter_sub_wgt", length));
			String[] interSubSlot = (JSPUtil.getParameter(request, prefix	+ "inter_sub_slot", length));
			String[] bsaSlot = (JSPUtil.getParameter(request, prefix	+ "bsa_slot", length));
			String[] inter45 = (JSPUtil.getParameter(request, prefix	+ "inter_45", length));
			String[] tradeFull = (JSPUtil.getParameter(request, prefix	+ "trade_full", length));
			String[] interMt = (JSPUtil.getParameter(request, prefix	+ "inter_mt", length));
			String[] bsaType = (JSPUtil.getParameter(request, prefix	+ "bsa_type", length));
			String[] interFull = (JSPUtil.getParameter(request, prefix	+ "inter_full", length));
			String[] ratioType = (JSPUtil.getParameter(request, prefix	+ "ratio_type", length));
			String[] releaseWgt = (JSPUtil.getParameter(request, prefix	+ "release_wgt", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] overWgt = (JSPUtil.getParameter(request, prefix	+ "over_wgt", length));
			String[] overSettle = (JSPUtil.getParameter(request, prefix	+ "over_settle", length));
			String[] grandTtlSlot = (JSPUtil.getParameter(request, prefix	+ "grand_ttl_slot", length));
			String[] tradeAb = (JSPUtil.getParameter(request, prefix	+ "trade_ab", length));
			String[] overSettleBy = (JSPUtil.getParameter(request, prefix	+ "over_settle_by", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] grandTtlWgt = (JSPUtil.getParameter(request, prefix	+ "grand_ttl_wgt", length));
			String[] trade45 = (JSPUtil.getParameter(request, prefix	+ "trade_45", length));
			String[] interAb = (JSPUtil.getParameter(request, prefix	+ "inter_ab", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			
			for (int i = 0; i < length; i++) {
				model = new TdrUtilizeSlotPortVO();
				if (tradeSubSlot[i] != null)
					model.setTradeSubSlot(tradeSubSlot[i]);
				if (bsaWgt[i] != null)
					model.setBsaWgt(bsaWgt[i]);
				if (tradeMt[i] != null)
					model.setTradeMt(tradeMt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (releaseSlot[i] != null)
					model.setReleaseSlot(releaseSlot[i]);
				if (tradeSubWgt[i] != null)
					model.setTradeSubWgt(tradeSubWgt[i]);
				if (overSlot[i] != null)
					model.setOverSlot(overSlot[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (interSubWgt[i] != null)
					model.setInterSubWgt(interSubWgt[i]);
				if (interSubSlot[i] != null)
					model.setInterSubSlot(interSubSlot[i]);
				if (bsaSlot[i] != null)
					model.setBsaSlot(bsaSlot[i]);
				if (inter45[i] != null)
					model.setInter45(inter45[i]);
				if (tradeFull[i] != null)
					model.setTradeFull(tradeFull[i]);
				if (interMt[i] != null)
					model.setInterMt(interMt[i]);
				if (bsaType[i] != null)
					model.setBsaType(bsaType[i]);
				if (interFull[i] != null)
					model.setInterFull(interFull[i]);
				if (ratioType[i] != null)
					model.setRatioType(ratioType[i]);
				if (releaseWgt[i] != null)
					model.setReleaseWgt(releaseWgt[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (overWgt[i] != null)
					model.setOverWgt(overWgt[i]);
				if (overSettle[i] != null)
					model.setOverSettle(overSettle[i]);
				if (grandTtlSlot[i] != null)
					model.setGrandTtlSlot(grandTtlSlot[i]);
				if (tradeAb[i] != null)
					model.setTradeAb(tradeAb[i]);
				if (overSettleBy[i] != null)
					model.setOverSettleBy(overSettleBy[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (grandTtlWgt[i] != null)
					model.setGrandTtlWgt(grandTtlWgt[i]);
				if (trade45[i] != null)
					model.setTrade45(trade45[i]);
				if (interAb[i] != null)
					model.setInterAb(interAb[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTdrUtilizeSlotPortVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TdrUtilizeSlotPortVO[]
	 */
	public TdrUtilizeSlotPortVO[] getTdrUtilizeSlotPortVOs(){
		TdrUtilizeSlotPortVO[] vos = (TdrUtilizeSlotPortVO[])models.toArray(new TdrUtilizeSlotPortVO[models.size()]);
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
		this.tradeSubSlot = this.tradeSubSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaWgt = this.bsaWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeMt = this.tradeMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.releaseSlot = this.releaseSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeSubWgt = this.tradeSubWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overSlot = this.overSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interSubWgt = this.interSubWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interSubSlot = this.interSubSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSlot = this.bsaSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inter45 = this.inter45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeFull = this.tradeFull .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interMt = this.interMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaType = this.bsaType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interFull = this.interFull .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratioType = this.ratioType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.releaseWgt = this.releaseWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overWgt = this.overWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overSettle = this.overSettle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandTtlSlot = this.grandTtlSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tradeAb = this.tradeAb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overSettleBy = this.overSettleBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandTtlWgt = this.grandTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade45 = this.trade45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interAb = this.interAb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
