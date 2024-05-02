/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DocQueueSummaryUrgencyVO.java
*@FileTitle : DocQueueSummaryUrgencyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.07
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.06.07 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocQueueSummaryUrgencyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueSummaryUrgencyVO> models = new ArrayList<DocQueueSummaryUrgencyVO>();
	
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String urgentPer = null;
	/* Column Info */
	private String vipPer = null;
	/* Column Info */
	private String urgent = null;
	/* Column Info */
	private String edi = null;
	/* Column Info */
	private String ediPer = null;
	/* Column Info */
	private String normal = null;
	/* Column Info */
	private String normalPer = null;
	/* Column Info */
	private String kind = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vip = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocQueueSummaryUrgencyVO() {}

	public DocQueueSummaryUrgencyVO(String ibflag, String pagerows, String region, String bkgOfcCd, String kind, String total, String normal, String normalPer, String vip, String vipPer, String urgent, String urgentPer, String edi, String ediPer) {
		this.region = region;
		this.bkgOfcCd = bkgOfcCd;
		this.total = total;
		this.urgentPer = urgentPer;
		this.vipPer = vipPer;
		this.urgent = urgent;
		this.edi = edi;
		this.ediPer = ediPer;
		this.normal = normal;
		this.normalPer = normalPer;
		this.kind = kind;
		this.pagerows = pagerows;
		this.vip = vip;
		this.ibflag = ibflag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("urgent_per", getUrgentPer());
		this.hashColumns.put("vip_per", getVipPer());
		this.hashColumns.put("urgent", getUrgent());
		this.hashColumns.put("edi", getEdi());
		this.hashColumns.put("edi_per", getEdiPer());
		this.hashColumns.put("normal", getNormal());
		this.hashColumns.put("normal_per", getNormalPer());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vip", getVip());
		this.hashColumns.put("ibflag", getIbflag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("region", "region");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("total", "total");
		this.hashFields.put("urgent_per", "urgentPer");
		this.hashFields.put("vip_per", "vipPer");
		this.hashFields.put("urgent", "urgent");
		this.hashFields.put("edi", "edi");
		this.hashFields.put("edi_per", "ediPer");
		this.hashFields.put("normal", "normal");
		this.hashFields.put("normal_per", "normalPer");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vip", "vip");
		this.hashFields.put("ibflag", "ibflag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return urgentPer
	 */
	public String getUrgentPer() {
		return this.urgentPer;
	}
	
	/**
	 * Column Info
	 * @return vipPer
	 */
	public String getVipPer() {
		return this.vipPer;
	}
	
	/**
	 * Column Info
	 * @return urgent
	 */
	public String getUrgent() {
		return this.urgent;
	}
	
	/**
	 * Column Info
	 * @return edi
	 */
	public String getEdi() {
		return this.edi;
	}
	
	/**
	 * Column Info
	 * @return ediPer
	 */
	public String getEdiPer() {
		return this.ediPer;
	}
	
	/**
	 * Column Info
	 * @return normal
	 */
	public String getNormal() {
		return this.normal;
	}
	
	/**
	 * Column Info
	 * @return normalPer
	 */
	public String getNormalPer() {
		return this.normalPer;
	}
	
	/**
	 * Column Info
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
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
	 * @return vip
	 */
	public String getVip() {
		return this.vip;
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
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param urgentPer
	 */
	public void setUrgentPer(String urgentPer) {
		this.urgentPer = urgentPer;
	}
	
	/**
	 * Column Info
	 * @param vipPer
	 */
	public void setVipPer(String vipPer) {
		this.vipPer = vipPer;
	}
	
	/**
	 * Column Info
	 * @param urgent
	 */
	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}
	
	/**
	 * Column Info
	 * @param edi
	 */
	public void setEdi(String edi) {
		this.edi = edi;
	}
	
	/**
	 * Column Info
	 * @param ediPer
	 */
	public void setEdiPer(String ediPer) {
		this.ediPer = ediPer;
	}
	
	/**
	 * Column Info
	 * @param normal
	 */
	public void setNormal(String normal) {
		this.normal = normal;
	}
	
	/**
	 * Column Info
	 * @param normalPer
	 */
	public void setNormalPer(String normalPer) {
		this.normalPer = normalPer;
	}
	
	/**
	 * Column Info
	 * @param kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
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
	 * @param vip
	 */
	public void setVip(String vip) {
		this.vip = vip;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
		setRegion(JSPUtil.getParameter(request, prefix + "region", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setUrgentPer(JSPUtil.getParameter(request, prefix + "urgent_per", ""));
		setVipPer(JSPUtil.getParameter(request, prefix + "vip_per", ""));
		setUrgent(JSPUtil.getParameter(request, prefix + "urgent", ""));
		setEdi(JSPUtil.getParameter(request, prefix + "edi", ""));
		setEdiPer(JSPUtil.getParameter(request, prefix + "edi_per", ""));
		setNormal(JSPUtil.getParameter(request, prefix + "normal", ""));
		setNormalPer(JSPUtil.getParameter(request, prefix + "normal_per", ""));
		setKind(JSPUtil.getParameter(request, prefix + "kind", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVip(JSPUtil.getParameter(request, prefix + "vip", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueSummaryUrgencyVO[]
	 */
	public DocQueueSummaryUrgencyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocQueueSummaryUrgencyVO[]
	 */
	public DocQueueSummaryUrgencyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocQueueSummaryUrgencyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] urgentPer = (JSPUtil.getParameter(request, prefix	+ "urgent_per", length));
			String[] vipPer = (JSPUtil.getParameter(request, prefix	+ "vip_per", length));
			String[] urgent = (JSPUtil.getParameter(request, prefix	+ "urgent", length));
			String[] edi = (JSPUtil.getParameter(request, prefix	+ "edi", length));
			String[] ediPer = (JSPUtil.getParameter(request, prefix	+ "edi_per", length));
			String[] normal = (JSPUtil.getParameter(request, prefix	+ "normal", length));
			String[] normalPer = (JSPUtil.getParameter(request, prefix	+ "normal_per", length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vip = (JSPUtil.getParameter(request, prefix	+ "vip", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueSummaryUrgencyVO();
				if (region[i] != null)
					model.setRegion(region[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (total[i] != null)
					model.setTotal(total[i]);
				if (urgentPer[i] != null)
					model.setUrgentPer(urgentPer[i]);
				if (vipPer[i] != null)
					model.setVipPer(vipPer[i]);
				if (urgent[i] != null)
					model.setUrgent(urgent[i]);
				if (edi[i] != null)
					model.setEdi(edi[i]);
				if (ediPer[i] != null)
					model.setEdiPer(ediPer[i]);
				if (normal[i] != null)
					model.setNormal(normal[i]);
				if (normalPer[i] != null)
					model.setNormalPer(normalPer[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vip[i] != null)
					model.setVip(vip[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocQueueSummaryUrgencyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocQueueSummaryUrgencyVO[]
	 */
	public DocQueueSummaryUrgencyVO[] getDocQueueSummaryUrgencyVOs(){
		DocQueueSummaryUrgencyVO[] vos = (DocQueueSummaryUrgencyVO[])models.toArray(new DocQueueSummaryUrgencyVO[models.size()]);
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
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.urgentPer = this.urgentPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vipPer = this.vipPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.urgent = this.urgent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi = this.edi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediPer = this.ediPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.normal = this.normal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.normalPer = this.normalPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vip = this.vip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
