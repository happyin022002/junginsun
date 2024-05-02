/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchSpaceControlInquiry058QtyListVO.java
*@FileTitle : SearchSpaceControlInquiry048QtyListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

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

public class SearchSpaceControlInquiry058QtyListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquiry058QtyListVO> models = new ArrayList<SearchSpaceControlInquiry058QtyListVO>();
	
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String lodTtl = null;
	/* Column Info */
	private String flg = null;
	/* Column Info */
	private String past = null;
	/* Column Info */
	private String onHcTtl = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String onTtl = null;
	/* Column Info */
	private String portSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bsa = null;
	/* Column Info */
	private String disTtl = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String src = null;
	
	// 2013.11.21 Ja young Shin
	/* Column Info */
	private String baseVvd = null;
	/* Column Info */
	private String disSeq = null;
	/* Column Info */
	private String avgCmpb = null;
	/* Column Info */
	private String loadCapa = null;
	/* Column Info */
	private String utilRatio = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String podSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceControlInquiry058QtyListVO() {}

	public SearchSpaceControlInquiry058QtyListVO(String ibflag, String pagerows, String iocCd, String onTtl, String lodTtl, String portSeq, String flg, String bsa, String disTtl, String portCd, String src, String past, String onHcTtl, String baseVvd, String disSeq, String avgCmpb, String loadCapa, String utilRatio, String podCd, String podSeq) {
		this.iocCd = iocCd;
		this.lodTtl = lodTtl;
		this.flg = flg;
		this.past = past;
		this.onHcTtl = onHcTtl;
		this.pagerows = pagerows;
		this.onTtl = onTtl;
		this.portSeq = portSeq;
		this.ibflag = ibflag;
		this.bsa = bsa;
		this.disTtl = disTtl;
		this.portCd = portCd;
		this.src = src;
		
		this.baseVvd = baseVvd;
		this.disSeq = disSeq;
		this.avgCmpb = avgCmpb;
		this.loadCapa = loadCapa;
		this.utilRatio = utilRatio;
		this.podCd = podCd;
		this.podSeq = podSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("lod_ttl", getLodTtl());
		this.hashColumns.put("flg", getFlg());
		this.hashColumns.put("past", getPast());
		this.hashColumns.put("on_hc_ttl", getOnHcTtl());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("on_ttl", getOnTtl());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bsa", getBsa());
		this.hashColumns.put("dis_ttl", getDisTtl());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("src", getSrc());
		
		this.hashColumns.put("base_vvd", getBaseVvd());
		this.hashColumns.put("dis_seq", getDisSeq());
		this.hashColumns.put("avg_cmpb", getAvgCmpb());
		this.hashColumns.put("load_capa", getLoadCapa());
		this.hashColumns.put("util_ratio", getUtilRatio());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pod_seq", getPodSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("lod_ttl", "lodTtl");
		this.hashFields.put("flg", "flg");
		this.hashFields.put("past", "past");
		this.hashFields.put("on_hc_ttl", "onHcTtl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("on_ttl", "onTtl");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bsa", "bsa");
		this.hashFields.put("dis_ttl", "disTtl");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("src", "src");
		
		this.hashFields.put("base_vvd", "baseVvd");
		this.hashFields.put("dis_seq", "disSeq");
		this.hashFields.put("avg_cmpb", "avgCmpb");
		this.hashFields.put("load_capa", "loadCapa");
		this.hashFields.put("util_ratio", "utilRatio");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pod_seq", "podSeq");
		return this.hashFields;
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
	 * @return lodTtl
	 */
	public String getLodTtl() {
		return this.lodTtl;
	}
	
	/**
	 * Column Info
	 * @return flg
	 */
	public String getFlg() {
		return this.flg;
	}
	
	/**
	 * Column Info
	 * @return past
	 */
	public String getPast() {
		return this.past;
	}
	
	/**
	 * Column Info
	 * @return onHcTtl
	 */
	public String getOnHcTtl() {
		return this.onHcTtl;
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
	 * @return onTtl
	 */
	public String getOnTtl() {
		return this.onTtl;
	}
	
	/**
	 * Column Info
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
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
	 * @return bsa
	 */
	public String getBsa() {
		return this.bsa;
	}
	
	/**
	 * Column Info
	 * @return disTtl
	 */
	public String getDisTtl() {
		return this.disTtl;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return src
	 */
	public String getSrc() {
		return this.src;
	}
	
	
	
	/**
	 * Column Info
	 * @return baseVvd
	 */
	public String getBaseVvd() {
		return this.baseVvd;
	}
	
	/**
	 * Column Info
	 * @return disSeq
	 */
	public String getDisSeq() {
		return this.disSeq;
	}
	
	/**
	 * Column Info
	 * @return avgCmpb
	 */
	public String getAvgCmpb() {
		return this.avgCmpb;
	}
	
	/**
	 * Column Info
	 * @return loadCapa
	 */
	public String getLoadCapa() {
		return this.loadCapa;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return podSeq
	 */
	public String getPodSeq() {
		return this.podSeq;
	}
	
	/**
	 * Column Info
	 * @return utilRatio
	 */
	public String getUtilRatio() {
		return this.utilRatio;
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
	 * @param lodTtl
	 */
	public void setLodTtl(String lodTtl) {
		this.lodTtl = lodTtl;
	}
	
	/**
	 * Column Info
	 * @param flg
	 */
	public void setFlg(String flg) {
		this.flg = flg;
	}
	
	/**
	 * Column Info
	 * @param past
	 */
	public void setPast(String past) {
		this.past = past;
	}
	
	/**
	 * Column Info
	 * @param onHcTtl
	 */
	public void setOnHcTtl(String onHcTtl) {
		this.onHcTtl = onHcTtl;
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
	 * @param onTtl
	 */
	public void setOnTtl(String onTtl) {
		this.onTtl = onTtl;
	}
	
	/**
	 * Column Info
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
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
	 * @param bsa
	 */
	public void setBsa(String bsa) {
		this.bsa = bsa;
	}
	
	/**
	 * Column Info
	 * @param disTtl
	 */
	public void setDisTtl(String disTtl) {
		this.disTtl = disTtl;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param src
	 */
	public void setSrc(String src) {
		this.src = src;
	}
	
	
	
	/**
	 * Column Info
	 * @param baseVvd
	 */
	public void setBaseVvd(String baseVvd) {
		this.baseVvd = baseVvd;
	}
	
	/**
	 * Column Info
	 * @param disSeq
	 */
	public void setDisSeq(String disSeq) {
		this.disSeq = disSeq;
	}
	
	/**
	 * Column Info
	 * @param avgCmpb
	 */
	public void setAvgCmpb(String avgCmpb) {
		this.avgCmpb = avgCmpb;
	}
	
	/**
	 * Column Info
	 * @param loadCapa
	 */
	public void setLoadCapa(String loadCapa) {
		this.loadCapa = loadCapa;
	}
	
	/**
	 * Column Info
	 * @param utilRatio
	 */
	public void setUtilRatio(String utilRatio) {
		this.utilRatio = utilRatio;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param podSeq
	 */
	public void setPodSeq(String podSeq) {
		this.podSeq = podSeq;
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
		setIocCd(JSPUtil.getParameter(request, prefix + "ioc_cd", ""));
		setLodTtl(JSPUtil.getParameter(request, prefix + "lod_ttl", ""));
		setFlg(JSPUtil.getParameter(request, prefix + "flg", ""));
		setPast(JSPUtil.getParameter(request, prefix + "past", ""));
		setOnHcTtl(JSPUtil.getParameter(request, prefix + "on_hc_ttl", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOnTtl(JSPUtil.getParameter(request, prefix + "on_ttl", ""));
		setPortSeq(JSPUtil.getParameter(request, prefix + "port_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBsa(JSPUtil.getParameter(request, prefix + "bsa", ""));
		setDisTtl(JSPUtil.getParameter(request, prefix + "dis_ttl", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setSrc(JSPUtil.getParameter(request, prefix + "src", ""));
		
		setBaseVvd(JSPUtil.getParameter(request, prefix + "base_vvd", ""));
		setDisSeq(JSPUtil.getParameter(request, prefix + "dis_seq", ""));
		setAvgCmpb(JSPUtil.getParameter(request, prefix + "avg_cmpb", ""));
		setLoadCapa(JSPUtil.getParameter(request, prefix + "load_capa", ""));
		setUtilRatio(JSPUtil.getParameter(request, prefix + "util_ratio", ""));

		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPodSeq(JSPUtil.getParameter(request, prefix + "pod_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlInquiry058QtyListVO[]
	 */
	public SearchSpaceControlInquiry058QtyListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlInquiry058QtyListVO[]
	 */
	public SearchSpaceControlInquiry058QtyListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquiry058QtyListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] lodTtl = (JSPUtil.getParameter(request, prefix	+ "lod_ttl", length));
			String[] flg = (JSPUtil.getParameter(request, prefix	+ "flg", length));
			String[] past = (JSPUtil.getParameter(request, prefix	+ "past", length));
			String[] onHcTtl = (JSPUtil.getParameter(request, prefix	+ "on_hc_ttl", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] onTtl = (JSPUtil.getParameter(request, prefix	+ "on_ttl", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bsa = (JSPUtil.getParameter(request, prefix	+ "bsa", length));
			String[] disTtl = (JSPUtil.getParameter(request, prefix	+ "dis_ttl", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] src = (JSPUtil.getParameter(request, prefix	+ "src", length));
			
			String[] baseVvd = (JSPUtil.getParameter(request, prefix	+ "base_vvd", length));
			String[] disSeq = (JSPUtil.getParameter(request, prefix	+ "dis_seq", length));
			String[] avgCmpb = (JSPUtil.getParameter(request, prefix	+ "avg_cmpb", length));
			String[] loadCapa = (JSPUtil.getParameter(request, prefix	+ "load_capa", length));
			String[] utilRatio = (JSPUtil.getParameter(request, prefix	+ "util_ratio", length));
			
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] podSeq= (JSPUtil.getParameter(request, prefix	+ "pod_seq", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquiry058QtyListVO();
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (lodTtl[i] != null)
					model.setLodTtl(lodTtl[i]);
				if (flg[i] != null)
					model.setFlg(flg[i]);
				if (past[i] != null)
					model.setPast(past[i]);
				if (onHcTtl[i] != null)
					model.setOnHcTtl(onHcTtl[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (onTtl[i] != null)
					model.setOnTtl(onTtl[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bsa[i] != null)
					model.setBsa(bsa[i]);
				if (disTtl[i] != null)
					model.setDisTtl(disTtl[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (src[i] != null)
					model.setSrc(src[i]);
				
				
				if (baseVvd[i] != null)
					model.setBaseVvd(baseVvd[i]);
				if (disSeq[i] != null)
					model.setDisSeq(disSeq[i]);
				if (avgCmpb[i] != null)
					model.setAvgCmpb(avgCmpb[i]);
				if (loadCapa[i] != null)
					model.setLoadCapa(loadCapa[i]);
				if (utilRatio[i] != null)
					model.setUtilRatio(utilRatio[i]);
				
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (podSeq[i] != null)
					model.setPodSeq(podSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlInquiry058QtyListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquiry058QtyListVO[]
	 */
	public SearchSpaceControlInquiry058QtyListVO[] getSearchSpaceControlInquiry058QtyListVOs(){
		SearchSpaceControlInquiry058QtyListVO[] vos = (SearchSpaceControlInquiry058QtyListVO[])models.toArray(new SearchSpaceControlInquiry058QtyListVO[models.size()]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodTtl = this.lodTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flg = this.flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.past = this.past .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onHcTtl = this.onHcTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onTtl = this.onTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa = this.bsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disTtl = this.disTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.src = this.src .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
