/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315PrefixMainCOPInfoPodDtVO.java
*@FileTitle : Edi315PrefixMainCOPInfoPodDtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.18 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315PrefixMainCOPInfoPodDtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315PrefixMainCOPInfoPodDtVO> models = new ArrayList<Edi315PrefixMainCOPInfoPodDtVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podEtd = null;
	/* Column Info */
	private String podAtaGmt = null;
	/* Column Info */
	private String podEtaGmt = null;
	/* Column Info */
	private String podEtdGmt = null;
	/* Column Info */
	private String podAtdGmt = null;
	/* Column Info */
	private String podAtd = null;
	/* Column Info */
	private String podAta = null;
	/* Column Info */
	private String podEta = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315PrefixMainCOPInfoPodDtVO() {}

	public Edi315PrefixMainCOPInfoPodDtVO(String ibflag, String pagerows, String podEta, String podEtaGmt, String podAta, String podAtaGmt, String podEtd, String podEtdGmt, String podAtd, String podAtdGmt) {
		this.ibflag = ibflag;
		this.podEtd = podEtd;
		this.podAtaGmt = podAtaGmt;
		this.podEtaGmt = podEtaGmt;
		this.podEtdGmt = podEtdGmt;
		this.podAtdGmt = podAtdGmt;
		this.podAtd = podAtd;
		this.podAta = podAta;
		this.podEta = podEta;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_etd", getPodEtd());
		this.hashColumns.put("pod_ata_gmt", getPodAtaGmt());
		this.hashColumns.put("pod_eta_gmt", getPodEtaGmt());
		this.hashColumns.put("pod_etd_gmt", getPodEtdGmt());
		this.hashColumns.put("pod_atd_gmt", getPodAtdGmt());
		this.hashColumns.put("pod_atd", getPodAtd());
		this.hashColumns.put("pod_ata", getPodAta());
		this.hashColumns.put("pod_eta", getPodEta());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_etd", "podEtd");
		this.hashFields.put("pod_ata_gmt", "podAtaGmt");
		this.hashFields.put("pod_eta_gmt", "podEtaGmt");
		this.hashFields.put("pod_etd_gmt", "podEtdGmt");
		this.hashFields.put("pod_atd_gmt", "podAtdGmt");
		this.hashFields.put("pod_atd", "podAtd");
		this.hashFields.put("pod_ata", "podAta");
		this.hashFields.put("pod_eta", "podEta");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return podEtd
	 */
	public String getPodEtd() {
		return this.podEtd;
	}
	
	/**
	 * Column Info
	 * @return podAtaGmt
	 */
	public String getPodAtaGmt() {
		return this.podAtaGmt;
	}
	
	/**
	 * Column Info
	 * @return podEtaGmt
	 */
	public String getPodEtaGmt() {
		return this.podEtaGmt;
	}
	
	/**
	 * Column Info
	 * @return podEtdGmt
	 */
	public String getPodEtdGmt() {
		return this.podEtdGmt;
	}
	
	/**
	 * Column Info
	 * @return podAtdGmt
	 */
	public String getPodAtdGmt() {
		return this.podAtdGmt;
	}
	
	/**
	 * Column Info
	 * @return podAtd
	 */
	public String getPodAtd() {
		return this.podAtd;
	}
	
	/**
	 * Column Info
	 * @return podAta
	 */
	public String getPodAta() {
		return this.podAta;
	}
	
	/**
	 * Column Info
	 * @return podEta
	 */
	public String getPodEta() {
		return this.podEta;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param podEtd
	 */
	public void setPodEtd(String podEtd) {
		this.podEtd = podEtd;
	}
	
	/**
	 * Column Info
	 * @param podAtaGmt
	 */
	public void setPodAtaGmt(String podAtaGmt) {
		this.podAtaGmt = podAtaGmt;
	}
	
	/**
	 * Column Info
	 * @param podEtaGmt
	 */
	public void setPodEtaGmt(String podEtaGmt) {
		this.podEtaGmt = podEtaGmt;
	}
	
	/**
	 * Column Info
	 * @param podEtdGmt
	 */
	public void setPodEtdGmt(String podEtdGmt) {
		this.podEtdGmt = podEtdGmt;
	}
	
	/**
	 * Column Info
	 * @param podAtdGmt
	 */
	public void setPodAtdGmt(String podAtdGmt) {
		this.podAtdGmt = podAtdGmt;
	}
	
	/**
	 * Column Info
	 * @param podAtd
	 */
	public void setPodAtd(String podAtd) {
		this.podAtd = podAtd;
	}
	
	/**
	 * Column Info
	 * @param podAta
	 */
	public void setPodAta(String podAta) {
		this.podAta = podAta;
	}
	
	/**
	 * Column Info
	 * @param podEta
	 */
	public void setPodEta(String podEta) {
		this.podEta = podEta;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPodEtd(JSPUtil.getParameter(request, prefix + "pod_etd", ""));
		setPodAtaGmt(JSPUtil.getParameter(request, prefix + "pod_ata_gmt", ""));
		setPodEtaGmt(JSPUtil.getParameter(request, prefix + "pod_eta_gmt", ""));
		setPodEtdGmt(JSPUtil.getParameter(request, prefix + "pod_etd_gmt", ""));
		setPodAtdGmt(JSPUtil.getParameter(request, prefix + "pod_atd_gmt", ""));
		setPodAtd(JSPUtil.getParameter(request, prefix + "pod_atd", ""));
		setPodAta(JSPUtil.getParameter(request, prefix + "pod_ata", ""));
		setPodEta(JSPUtil.getParameter(request, prefix + "pod_eta", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315PrefixMainCOPInfoPodDtVO[]
	 */
	public Edi315PrefixMainCOPInfoPodDtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315PrefixMainCOPInfoPodDtVO[]
	 */
	public Edi315PrefixMainCOPInfoPodDtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315PrefixMainCOPInfoPodDtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podEtd = (JSPUtil.getParameter(request, prefix	+ "pod_etd", length));
			String[] podAtaGmt = (JSPUtil.getParameter(request, prefix	+ "pod_ata_gmt", length));
			String[] podEtaGmt = (JSPUtil.getParameter(request, prefix	+ "pod_eta_gmt", length));
			String[] podEtdGmt = (JSPUtil.getParameter(request, prefix	+ "pod_etd_gmt", length));
			String[] podAtdGmt = (JSPUtil.getParameter(request, prefix	+ "pod_atd_gmt", length));
			String[] podAtd = (JSPUtil.getParameter(request, prefix	+ "pod_atd", length));
			String[] podAta = (JSPUtil.getParameter(request, prefix	+ "pod_ata", length));
			String[] podEta = (JSPUtil.getParameter(request, prefix	+ "pod_eta", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315PrefixMainCOPInfoPodDtVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podEtd[i] != null)
					model.setPodEtd(podEtd[i]);
				if (podAtaGmt[i] != null)
					model.setPodAtaGmt(podAtaGmt[i]);
				if (podEtaGmt[i] != null)
					model.setPodEtaGmt(podEtaGmt[i]);
				if (podEtdGmt[i] != null)
					model.setPodEtdGmt(podEtdGmt[i]);
				if (podAtdGmt[i] != null)
					model.setPodAtdGmt(podAtdGmt[i]);
				if (podAtd[i] != null)
					model.setPodAtd(podAtd[i]);
				if (podAta[i] != null)
					model.setPodAta(podAta[i]);
				if (podEta[i] != null)
					model.setPodEta(podEta[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315PrefixMainCOPInfoPodDtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315PrefixMainCOPInfoPodDtVO[]
	 */
	public Edi315PrefixMainCOPInfoPodDtVO[] getEdi315PrefixMainCOPInfoPodDtVOs(){
		Edi315PrefixMainCOPInfoPodDtVO[] vos = (Edi315PrefixMainCOPInfoPodDtVO[])models.toArray(new Edi315PrefixMainCOPInfoPodDtVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtd = this.podEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtaGmt = this.podAtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtaGmt = this.podEtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtdGmt = this.podEtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtdGmt = this.podAtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAtd = this.podAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAta = this.podAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEta = this.podEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
