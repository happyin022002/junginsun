/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AncsCstmsVvdDtlListVO.java
*@FileTitle : AncsCstmsVvdDtlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdDtlVO;
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

public class AncsCstmsVvdDtlListVO extends CstmsVvdDtlVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsCstmsVvdDtlListVO> models = new ArrayList<AncsCstmsVvdDtlListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diff = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String podClptIndSeq = null;
	/* Column Info */
	private String polClptIndSeq = null;
	/* Column Info */
	private String bdrDate = null;
	/* Column Info */
	private String bdr = null;
	/* Column Info */
	private String bkgCnt = null;
	/* Column Info */
	private String dnld = null;
	/* Column Info */
	private String polAtd = null;
	/* Column Info */
	private String pod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AncsCstmsVvdDtlListVO() {}

	public AncsCstmsVvdDtlListVO(String ibflag, String pagerows, String pol, String polAtd, String pod, String bdr, String bdrDate, String bkgCnt, String dnld, String diff, String polClptIndSeq, String podClptIndSeq) {
		this.ibflag = ibflag;
		this.diff = diff;
		this.pol = pol;
		this.podClptIndSeq = podClptIndSeq;
		this.polClptIndSeq = polClptIndSeq;
		this.bdrDate = bdrDate;
		this.bdr = bdr;
		this.bkgCnt = bkgCnt;
		this.dnld = dnld;
		this.polAtd = polAtd;
		this.pod = pod;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff", getDiff());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("bdr_date", getBdrDate());
		this.hashColumns.put("bdr", getBdr());
		this.hashColumns.put("bkg_cnt", getBkgCnt());
		this.hashColumns.put("dnld", getDnld());
		this.hashColumns.put("pol_atd", getPolAtd());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff", "diff");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("bdr_date", "bdrDate");
		this.hashFields.put("bdr", "bdr");
		this.hashFields.put("bkg_cnt", "bkgCnt");
		this.hashFields.put("dnld", "dnld");
		this.hashFields.put("pol_atd", "polAtd");
		this.hashFields.put("pod", "pod");
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
	 * @return diff
	 */
	public String getDiff() {
		return this.diff;
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
	 * @return podClptIndSeq
	 */
	public String getPodClptIndSeq() {
		return this.podClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return polClptIndSeq
	 */
	public String getPolClptIndSeq() {
		return this.polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return bdrDate
	 */
	public String getBdrDate() {
		return this.bdrDate;
	}
	
	/**
	 * Column Info
	 * @return bdr
	 */
	public String getBdr() {
		return this.bdr;
	}
	
	/**
	 * Column Info
	 * @return bkgCnt
	 */
	public String getBkgCnt() {
		return this.bkgCnt;
	}
	
	/**
	 * Column Info
	 * @return dnld
	 */
	public String getDnld() {
		return this.dnld;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
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
	 * @param podClptIndSeq
	 */
	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param polClptIndSeq
	 */
	public void setPolClptIndSeq(String polClptIndSeq) {
		this.polClptIndSeq = polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param bdrDate
	 */
	public void setBdrDate(String bdrDate) {
		this.bdrDate = bdrDate;
	}
	
	/**
	 * Column Info
	 * @param bdr
	 */
	public void setBdr(String bdr) {
		this.bdr = bdr;
	}
	
	/**
	 * Column Info
	 * @param bkgCnt
	 */
	public void setBkgCnt(String bkgCnt) {
		this.bkgCnt = bkgCnt;
	}
	
	/**
	 * Column Info
	 * @param dnld
	 */
	public void setDnld(String dnld) {
		this.dnld = dnld;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDiff(JSPUtil.getParameter(request, prefix + "diff", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, prefix + "pod_clpt_ind_seq", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
		setBdrDate(JSPUtil.getParameter(request, prefix + "bdr_date", ""));
		setBdr(JSPUtil.getParameter(request, prefix + "bdr", ""));
		setBkgCnt(JSPUtil.getParameter(request, prefix + "bkg_cnt", ""));
		setDnld(JSPUtil.getParameter(request, prefix + "dnld", ""));
		setPolAtd(JSPUtil.getParameter(request, prefix + "pol_atd", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsVvdDtlListVO[]
	 */
	public AncsCstmsVvdDtlListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsVvdDtlListVO[]
	 */
	public AncsCstmsVvdDtlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsCstmsVvdDtlListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diff = (JSPUtil.getParameter(request, prefix	+ "diff", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));
			String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq", length));
			String[] bdrDate = (JSPUtil.getParameter(request, prefix	+ "bdr_date", length));
			String[] bdr = (JSPUtil.getParameter(request, prefix	+ "bdr", length));
			String[] bkgCnt = (JSPUtil.getParameter(request, prefix	+ "bkg_cnt", length));
			String[] dnld = (JSPUtil.getParameter(request, prefix	+ "dnld", length));
			String[] polAtd = (JSPUtil.getParameter(request, prefix	+ "pol_atd", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsCstmsVvdDtlListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diff[i] != null)
					model.setDiff(diff[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				if (polClptIndSeq[i] != null)
					model.setPolClptIndSeq(polClptIndSeq[i]);
				if (bdrDate[i] != null)
					model.setBdrDate(bdrDate[i]);
				if (bdr[i] != null)
					model.setBdr(bdr[i]);
				if (bkgCnt[i] != null)
					model.setBkgCnt(bkgCnt[i]);
				if (dnld[i] != null)
					model.setDnld(dnld[i]);
				if (polAtd[i] != null)
					model.setPolAtd(polAtd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsVvdDtlListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsVvdDtlListVO[]
	 */
	public AncsCstmsVvdDtlListVO[] getAncsCstmsVvdDtlListVOs(){
		AncsCstmsVvdDtlListVO[] vos = (AncsCstmsVvdDtlListVO[])models.toArray(new AncsCstmsVvdDtlListVO[models.size()]);
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
		this.diff = this.diff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq = this.polClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrDate = this.bdrDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdr = this.bdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCnt = this.bkgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dnld = this.dnld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAtd = this.polAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
