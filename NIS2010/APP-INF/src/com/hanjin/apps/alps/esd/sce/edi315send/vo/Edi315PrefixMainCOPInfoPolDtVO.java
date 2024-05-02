/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315PrefixMainCOPInfoPolDtVO.java
*@FileTitle : Edi315PrefixMainCOPInfoPolDtVO
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

public class Edi315PrefixMainCOPInfoPolDtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315PrefixMainCOPInfoPolDtVO> models = new ArrayList<Edi315PrefixMainCOPInfoPolDtVO>();
	
	/* Column Info */
	private String polEtd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polEtaGmt = null;
	/* Column Info */
	private String polEtdGmt = null;
	/* Column Info */
	private String polAta = null;
	/* Column Info */
	private String polAtd = null;
	/* Column Info */
	private String polAtaGmt = null;
	/* Column Info */
	private String polEta = null;
	/* Column Info */
	private String polAtdGmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315PrefixMainCOPInfoPolDtVO() {}

	public Edi315PrefixMainCOPInfoPolDtVO(String ibflag, String pagerows, String polEta, String polEtaGmt, String polAta, String polAtaGmt, String polEtd, String polEtdGmt, String polAtd, String polAtdGmt) {
		this.polEtd = polEtd;
		this.ibflag = ibflag;
		this.polEtaGmt = polEtaGmt;
		this.polEtdGmt = polEtdGmt;
		this.polAta = polAta;
		this.polAtd = polAtd;
		this.polAtaGmt = polAtaGmt;
		this.polEta = polEta;
		this.polAtdGmt = polAtdGmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pol_etd", getPolEtd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_eta_gmt", getPolEtaGmt());
		this.hashColumns.put("pol_etd_gmt", getPolEtdGmt());
		this.hashColumns.put("pol_ata", getPolAta());
		this.hashColumns.put("pol_atd", getPolAtd());
		this.hashColumns.put("pol_ata_gmt", getPolAtaGmt());
		this.hashColumns.put("pol_eta", getPolEta());
		this.hashColumns.put("pol_atd_gmt", getPolAtdGmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_eta_gmt", "polEtaGmt");
		this.hashFields.put("pol_etd_gmt", "polEtdGmt");
		this.hashFields.put("pol_ata", "polAta");
		this.hashFields.put("pol_atd", "polAtd");
		this.hashFields.put("pol_ata_gmt", "polAtaGmt");
		this.hashFields.put("pol_eta", "polEta");
		this.hashFields.put("pol_atd_gmt", "polAtdGmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return polEtd
	 */
	public String getPolEtd() {
		return this.polEtd;
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
	 * @return polEtaGmt
	 */
	public String getPolEtaGmt() {
		return this.polEtaGmt;
	}
	
	/**
	 * Column Info
	 * @return polEtdGmt
	 */
	public String getPolEtdGmt() {
		return this.polEtdGmt;
	}
	
	/**
	 * Column Info
	 * @return polAta
	 */
	public String getPolAta() {
		return this.polAta;
	}
	
	/**
	 * Column Info
	 * @return polAtd
	 */
	public String getPolAtd() {
		return this.polAtd;
	}
	
	/**
	 * Column Info
	 * @return polAtaGmt
	 */
	public String getPolAtaGmt() {
		return this.polAtaGmt;
	}
	
	/**
	 * Column Info
	 * @return polEta
	 */
	public String getPolEta() {
		return this.polEta;
	}
	
	/**
	 * Column Info
	 * @return polAtdGmt
	 */
	public String getPolAtdGmt() {
		return this.polAtdGmt;
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
	 * @param polEtd
	 */
	public void setPolEtd(String polEtd) {
		this.polEtd = polEtd;
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
	 * @param polEtaGmt
	 */
	public void setPolEtaGmt(String polEtaGmt) {
		this.polEtaGmt = polEtaGmt;
	}
	
	/**
	 * Column Info
	 * @param polEtdGmt
	 */
	public void setPolEtdGmt(String polEtdGmt) {
		this.polEtdGmt = polEtdGmt;
	}
	
	/**
	 * Column Info
	 * @param polAta
	 */
	public void setPolAta(String polAta) {
		this.polAta = polAta;
	}
	
	/**
	 * Column Info
	 * @param polAtd
	 */
	public void setPolAtd(String polAtd) {
		this.polAtd = polAtd;
	}
	
	/**
	 * Column Info
	 * @param polAtaGmt
	 */
	public void setPolAtaGmt(String polAtaGmt) {
		this.polAtaGmt = polAtaGmt;
	}
	
	/**
	 * Column Info
	 * @param polEta
	 */
	public void setPolEta(String polEta) {
		this.polEta = polEta;
	}
	
	/**
	 * Column Info
	 * @param polAtdGmt
	 */
	public void setPolAtdGmt(String polAtdGmt) {
		this.polAtdGmt = polAtdGmt;
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
		setPolEtd(JSPUtil.getParameter(request, prefix + "pol_etd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolEtaGmt(JSPUtil.getParameter(request, prefix + "pol_eta_gmt", ""));
		setPolEtdGmt(JSPUtil.getParameter(request, prefix + "pol_etd_gmt", ""));
		setPolAta(JSPUtil.getParameter(request, prefix + "pol_ata", ""));
		setPolAtd(JSPUtil.getParameter(request, prefix + "pol_atd", ""));
		setPolAtaGmt(JSPUtil.getParameter(request, prefix + "pol_ata_gmt", ""));
		setPolEta(JSPUtil.getParameter(request, prefix + "pol_eta", ""));
		setPolAtdGmt(JSPUtil.getParameter(request, prefix + "pol_atd_gmt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315PrefixMainCOPInfoPolDtVO[]
	 */
	public Edi315PrefixMainCOPInfoPolDtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315PrefixMainCOPInfoPolDtVO[]
	 */
	public Edi315PrefixMainCOPInfoPolDtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315PrefixMainCOPInfoPolDtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polEtaGmt = (JSPUtil.getParameter(request, prefix	+ "pol_eta_gmt", length));
			String[] polEtdGmt = (JSPUtil.getParameter(request, prefix	+ "pol_etd_gmt", length));
			String[] polAta = (JSPUtil.getParameter(request, prefix	+ "pol_ata", length));
			String[] polAtd = (JSPUtil.getParameter(request, prefix	+ "pol_atd", length));
			String[] polAtaGmt = (JSPUtil.getParameter(request, prefix	+ "pol_ata_gmt", length));
			String[] polEta = (JSPUtil.getParameter(request, prefix	+ "pol_eta", length));
			String[] polAtdGmt = (JSPUtil.getParameter(request, prefix	+ "pol_atd_gmt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315PrefixMainCOPInfoPolDtVO();
				if (polEtd[i] != null)
					model.setPolEtd(polEtd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polEtaGmt[i] != null)
					model.setPolEtaGmt(polEtaGmt[i]);
				if (polEtdGmt[i] != null)
					model.setPolEtdGmt(polEtdGmt[i]);
				if (polAta[i] != null)
					model.setPolAta(polAta[i]);
				if (polAtd[i] != null)
					model.setPolAtd(polAtd[i]);
				if (polAtaGmt[i] != null)
					model.setPolAtaGmt(polAtaGmt[i]);
				if (polEta[i] != null)
					model.setPolEta(polEta[i]);
				if (polAtdGmt[i] != null)
					model.setPolAtdGmt(polAtdGmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315PrefixMainCOPInfoPolDtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315PrefixMainCOPInfoPolDtVO[]
	 */
	public Edi315PrefixMainCOPInfoPolDtVO[] getEdi315PrefixMainCOPInfoPolDtVOs(){
		Edi315PrefixMainCOPInfoPolDtVO[] vos = (Edi315PrefixMainCOPInfoPolDtVO[])models.toArray(new Edi315PrefixMainCOPInfoPolDtVO[models.size()]);
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
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtaGmt = this.polEtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdGmt = this.polEtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAta = this.polAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAtd = this.polAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAtaGmt = this.polAtaGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEta = this.polEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAtdGmt = this.polAtdGmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
