/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrspSoSeqVO.java
*@FileTitle : TrspSoSeqVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.31
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.08.31 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.vo;

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
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrspSoSeqVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrspSoSeqVO> models = new ArrayList<TrspSoSeqVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String spotBidFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String spotBidDueDt = null;
	/* Column Info */
	private String spotBidDueDtHms = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String trspCrrModCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TrspSoSeqVO() {}

	public TrspSoSeqVO(String ibflag, String pagerows, String chk, String trspSoOfcCtyCd, String trspSoSeq, String spotBidFlg, String spotBidDueDt, String spotBidDueDtHms, String trspCrrModCd, String fmNodCd, String viaNodCd, String dorNodCd, String toNodCd) {
		this.toNodCd = toNodCd;
		this.trspSoSeq = trspSoSeq;
		this.spotBidFlg = spotBidFlg;
		this.pagerows = pagerows;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.fmNodCd = fmNodCd;
		this.ibflag = ibflag;
		this.spotBidDueDt = spotBidDueDt;
		this.spotBidDueDtHms = spotBidDueDtHms;
		this.chk = chk;
		this.viaNodCd = viaNodCd;
		this.dorNodCd = dorNodCd;
		this.trspCrrModCd = trspCrrModCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("spot_bid_flg", getSpotBidFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spot_bid_due_dt", getSpotBidDueDt());
		this.hashColumns.put("spot_bid_due_dt_hms", getSpotBidDueDtHms());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("spot_bid_flg", "spotBidFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spot_bid_due_dt", "spotBidDueDt");
		this.hashFields.put("spot_bid_due_dt_hms", "spotBidDueDtHms");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return spotBidFlg
	 */
	public String getSpotBidFlg() {
		return this.spotBidFlg;
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
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
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
	 * @return spotBidDueDt
	 */
	public String getSpotBidDueDt() {
		return this.spotBidDueDt;
	}
	
	/**
	 * Column Info
	 * @return spotBidDueDtHms
	 */
	public String getSpotBidDueDtHms() {
		return this.spotBidDueDtHms;
	}
	
	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param spotBidFlg
	 */
	public void setSpotBidFlg(String spotBidFlg) {
		this.spotBidFlg = spotBidFlg;
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
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
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
	 * @param spotBidDueDt
	 */
	public void setSpotBidDueDt(String spotBidDueDt) {
		this.spotBidDueDt = spotBidDueDt;
	}
	
	/**
	 * Column Info
	 * @param spotBidDueDtHms
	 */
	public void setSpotBidDueDtHms(String spotBidDueDtHms) {
		this.spotBidDueDtHms = spotBidDueDtHms;
	}
	
	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setSpotBidFlg(JSPUtil.getParameter(request, prefix + "spot_bid_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSpotBidDueDt(JSPUtil.getParameter(request, prefix + "spot_bid_due_dt", ""));
		setSpotBidDueDtHms(JSPUtil.getParameter(request, prefix + "spot_bid_due_dt_hms", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrspSoSeqVO[]
	 */
	public TrspSoSeqVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrspSoSeqVO[]
	 */
	public TrspSoSeqVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrspSoSeqVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] spotBidFlg = (JSPUtil.getParameter(request, prefix	+ "spot_bid_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] spotBidDueDt = (JSPUtil.getParameter(request, prefix	+ "spot_bid_due_dt", length));
			String[] spotBidDueDtHms = (JSPUtil.getParameter(request, prefix	+ "spot_bid_due_dt_hms", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrspSoSeqVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (spotBidFlg[i] != null)
					model.setSpotBidFlg(spotBidFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (spotBidDueDt[i] != null)
					model.setSpotBidDueDt(spotBidDueDt[i]);
				if (spotBidDueDtHms[i] != null)
					model.setSpotBidDueDtHms(spotBidDueDtHms[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrspSoSeqVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrspSoSeqVO[]
	 */
	public TrspSoSeqVO[] getTrspSoSeqVOs(){
		TrspSoSeqVO[] vos = (TrspSoSeqVO[])models.toArray(new TrspSoSeqVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidFlg = this.spotBidFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidDueDt = this.spotBidDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidDueDtHms = this.spotBidDueDtHms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
