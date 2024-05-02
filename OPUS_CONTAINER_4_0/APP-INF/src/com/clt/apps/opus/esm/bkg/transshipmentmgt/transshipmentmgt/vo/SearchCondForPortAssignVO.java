/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SearchCondForPortAssignVO.java
*@FileTitle : SearchCondForPortAssignVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.04
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.03.04 Maeda Atsushi 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author Maeda Atsushi
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class SearchCondForPortAssignVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchCondForPortAssignVO> models = new ArrayList<SearchCondForPortAssignVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNos = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String multBkgNo = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String pod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchCondForPortAssignVO() {}

	public SearchCondForPortAssignVO(String ibflag, String pagerows, String vvd, String pol, String polYdCd, String pod, String podYdCd, String bkgOfcCd, String bkgNo, String multBkgNo, String bkgNos) {
		this.bkgOfcCd = bkgOfcCd;
		this.vvd = vvd;
		this.bkgNos = bkgNos;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.polYdCd = polYdCd;
		this.multBkgNo = multBkgNo;
		this.pol = pol;
		this.podYdCd = podYdCd;
		this.pod = pod;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_nos", getBkgNos());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("mult_bkg_no", getMultBkgNo());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_nos", "bkgNos");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("mult_bkg_no", "multBkgNo");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return bkgNos
	 */
	public String getBkgNos() {
		return this.bkgNos;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return multBkgNo
	 */
	public String getMultBkgNo() {
		return this.multBkgNo;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param bkgNos
	 */
	public void setBkgNos(String bkgNos) {
		this.bkgNos = bkgNos;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param multBkgNo
	 */
	public void setMultBkgNo(String multBkgNo) {
		this.multBkgNo = multBkgNo;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNos(JSPUtil.getParameter(request, prefix + "bkg_nos", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setMultBkgNo(JSPUtil.getParameter(request, prefix + "mult_bkg_no", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchCondForPortAssignVO[]
	 */
	public SearchCondForPortAssignVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchCondForPortAssignVO[]
	 */
	public SearchCondForPortAssignVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchCondForPortAssignVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNos = (JSPUtil.getParameter(request, prefix	+ "bkg_nos", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] multBkgNo = (JSPUtil.getParameter(request, prefix	+ "mult_bkg_no", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchCondForPortAssignVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNos[i] != null)
					model.setBkgNos(bkgNos[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (multBkgNo[i] != null)
					model.setMultBkgNo(multBkgNo[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchCondForPortAssignVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchCondForPortAssignVO[]
	 */
	public SearchCondForPortAssignVO[] getSearchCondForPortAssignVOs(){
		SearchCondForPortAssignVO[] vos = (SearchCondForPortAssignVO[])models.toArray(new SearchCondForPortAssignVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNos = this.bkgNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.multBkgNo = this.multBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
