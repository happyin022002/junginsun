/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBidVndrVO.java
*@FileTitle : SpotBidVndrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.26
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.08.26 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.vo;

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

public class SpotBidVndrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpotBidVndrVO> models = new ArrayList<SpotBidVndrVO>();
	
	/* Column Info */
	private String spotBidCnddtTermSeq = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String spotBidOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String vndrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sppFlg = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String vndrEmlAddr = null;
	/* Column Info */
	private String trspCrrModCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpotBidVndrVO() {}

	public SpotBidVndrVO(String ibflag, String pagerows, String spotBidCnddtTermSeq, String trspCrrModCd, String fmNodCd, String viaNodCd, String dorNodCd, String toNodCd, String vndrSeq, String vndrNm, String vndrEmlAddr, String sppFlg, String spotBidOfcCd) {
		this.spotBidCnddtTermSeq = spotBidCnddtTermSeq;
		this.toNodCd = toNodCd;
		this.spotBidOfcCd = spotBidOfcCd;
		this.pagerows = pagerows;
		this.fmNodCd = fmNodCd;
		this.vndrNm = vndrNm;
		this.ibflag = ibflag;
		this.sppFlg = sppFlg;
		this.vndrSeq = vndrSeq;
		this.viaNodCd = viaNodCd;
		this.dorNodCd = dorNodCd;
		this.vndrEmlAddr = vndrEmlAddr;
		this.trspCrrModCd = trspCrrModCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("spot_bid_cnddt_term_seq", getSpotBidCnddtTermSeq());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("spot_bid_ofc_cd", getSpotBidOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("spp_flg", getSppFlg());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("vndr_eml_addr", getVndrEmlAddr());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("spot_bid_cnddt_term_seq", "spotBidCnddtTermSeq");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("spot_bid_ofc_cd", "spotBidOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("spp_flg", "sppFlg");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("vndr_eml_addr", "vndrEmlAddr");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return spotBidCnddtTermSeq
	 */
	public String getSpotBidCnddtTermSeq() {
		return this.spotBidCnddtTermSeq;
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
	 * @return spotBidOfcCd
	 */
	public String getSpotBidOfcCd() {
		return this.spotBidOfcCd;
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
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
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
	 * @return sppFlg
	 */
	public String getSppFlg() {
		return this.sppFlg;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
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
	 * @return vndrEmlAddr
	 */
	public String getVndrEmlAddr() {
		return this.vndrEmlAddr;
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
	 * @param spotBidCnddtTermSeq
	 */
	public void setSpotBidCnddtTermSeq(String spotBidCnddtTermSeq) {
		this.spotBidCnddtTermSeq = spotBidCnddtTermSeq;
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
	 * @param spotBidOfcCd
	 */
	public void setSpotBidOfcCd(String spotBidOfcCd) {
		this.spotBidOfcCd = spotBidOfcCd;
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
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
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
	 * @param sppFlg
	 */
	public void setSppFlg(String sppFlg) {
		this.sppFlg = sppFlg;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
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
	 * @param vndrEmlAddr
	 */
	public void setVndrEmlAddr(String vndrEmlAddr) {
		this.vndrEmlAddr = vndrEmlAddr;
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
		setSpotBidCnddtTermSeq(JSPUtil.getParameter(request, prefix + "spot_bid_cnddt_term_seq", ""));
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setSpotBidOfcCd(JSPUtil.getParameter(request, prefix + "spot_bid_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSppFlg(JSPUtil.getParameter(request, prefix + "spp_flg", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setVndrEmlAddr(JSPUtil.getParameter(request, prefix + "vndr_eml_addr", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpotBidVndrVO[]
	 */
	public SpotBidVndrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpotBidVndrVO[]
	 */
	public SpotBidVndrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpotBidVndrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] spotBidCnddtTermSeq = (JSPUtil.getParameter(request, prefix	+ "spot_bid_cnddt_term_seq", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] spotBidOfcCd = (JSPUtil.getParameter(request, prefix	+ "spot_bid_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sppFlg = (JSPUtil.getParameter(request, prefix	+ "spp_flg", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] vndrEmlAddr = (JSPUtil.getParameter(request, prefix	+ "vndr_eml_addr", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpotBidVndrVO();
				if (spotBidCnddtTermSeq[i] != null)
					model.setSpotBidCnddtTermSeq(spotBidCnddtTermSeq[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (spotBidOfcCd[i] != null)
					model.setSpotBidOfcCd(spotBidOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sppFlg[i] != null)
					model.setSppFlg(sppFlg[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (vndrEmlAddr[i] != null)
					model.setVndrEmlAddr(vndrEmlAddr[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpotBidVndrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpotBidVndrVO[]
	 */
	public SpotBidVndrVO[] getSpotBidVndrVOs(){
		SpotBidVndrVO[] vos = (SpotBidVndrVO[])models.toArray(new SpotBidVndrVO[models.size()]);
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
		this.spotBidCnddtTermSeq = this.spotBidCnddtTermSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spotBidOfcCd = this.spotBidOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sppFlg = this.sppFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrEmlAddr = this.vndrEmlAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
