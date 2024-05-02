/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DocQueueSummarySRKindVO.java
*@FileTitle : DocQueueSummarySRKindVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.06.03 김상수 
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

public class DocQueueSummarySRKindVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueSummarySRKindVO> models = new ArrayList<DocQueueSummarySRKindVO>();
	
	/* Column Info */
	private String blConfirm = null;
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String amendPer = null;
	/* Column Info */
	private String additionPer = null;
	/* Column Info */
	private String addition = null;
	/* Column Info */
	private String originalPer = null;
	/* Column Info */
	private String kind = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String blConfirmPer = null;
	/* Column Info */
	private String original = null;
	/* Column Info */
	private String amend = null;
	/* Column Info */
	private String customs = null;
	/* Column Info */
	private String customsPer = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocQueueSummarySRKindVO() {}

	public DocQueueSummarySRKindVO(String ibflag, String pagerows, String region, String bkgOfcCd, String kind, String total, String original, String originalPer, String amend, String amendPer, String addition, String additionPer, String customs, String customsPer, String blConfirm, String blConfirmPer) {
		this.blConfirm = blConfirm;
		this.region = region;
		this.bkgOfcCd = bkgOfcCd;
		this.total = total;
		this.amendPer = amendPer;
		this.additionPer = additionPer;
		this.addition = addition;
		this.originalPer = originalPer;
		this.kind = kind;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.blConfirmPer = blConfirmPer;
		this.original = original;
		this.amend = amend;
		this.customs = customs;
		this.customsPer = customsPer;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_confirm", getBlConfirm());
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("amend_per", getAmendPer());
		this.hashColumns.put("addition_per", getAdditionPer());
		this.hashColumns.put("addition", getAddition());
		this.hashColumns.put("original_per", getOriginalPer());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bl_confirm_per", getBlConfirmPer());
		this.hashColumns.put("original", getOriginal());
		this.hashColumns.put("amend", getAmend());
		this.hashColumns.put("customs", getCustoms());
		this.hashColumns.put("customs_per", getCustomsPer());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_confirm", "blConfirm");
		this.hashFields.put("region", "region");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("total", "total");
		this.hashFields.put("amend_per", "amendPer");
		this.hashFields.put("addition_per", "additionPer");
		this.hashFields.put("addition", "addition");
		this.hashFields.put("original_per", "originalPer");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bl_confirm_per", "blConfirmPer");
		this.hashFields.put("original", "original");
		this.hashFields.put("amend", "amend");
		this.hashFields.put("customs", "customs");
		this.hashFields.put("customs_per", "customsPer");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blConfirm
	 */
	public String getBlConfirm() {
		return this.blConfirm;
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
	 * @return amendPer
	 */
	public String getAmendPer() {
		return this.amendPer;
	}
	
	/**
	 * Column Info
	 * @return additionPer
	 */
	public String getAdditionPer() {
		return this.additionPer;
	}
	
	/**
	 * Column Info
	 * @return addition
	 */
	public String getAddition() {
		return this.addition;
	}
	
	/**
	 * Column Info
	 * @return originalPer
	 */
	public String getOriginalPer() {
		return this.originalPer;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return blConfirmPer
	 */
	public String getBlConfirmPer() {
		return this.blConfirmPer;
	}
	
	/**
	 * Column Info
	 * @return original
	 */
	public String getOriginal() {
		return this.original;
	}
	
	/**
	 * Column Info
	 * @return amend
	 */
	public String getAmend() {
		return this.amend;
	}
	
	/**
	 * Column Info
	 * @return customs
	 */
	public String getCustoms() {
		return this.customs;
	}
	
	/**
	 * Column Info
	 * @return customsPer
	 */
	public String getCustomsPer() {
		return this.customsPer;
	}
	

	/**
	 * Column Info
	 * @param blConfirm
	 */
	public void setBlConfirm(String blConfirm) {
		this.blConfirm = blConfirm;
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
	 * @param amendPer
	 */
	public void setAmendPer(String amendPer) {
		this.amendPer = amendPer;
	}
	
	/**
	 * Column Info
	 * @param additionPer
	 */
	public void setAdditionPer(String additionPer) {
		this.additionPer = additionPer;
	}
	
	/**
	 * Column Info
	 * @param addition
	 */
	public void setAddition(String addition) {
		this.addition = addition;
	}
	
	/**
	 * Column Info
	 * @param originalPer
	 */
	public void setOriginalPer(String originalPer) {
		this.originalPer = originalPer;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param blConfirmPer
	 */
	public void setBlConfirmPer(String blConfirmPer) {
		this.blConfirmPer = blConfirmPer;
	}
	
	/**
	 * Column Info
	 * @param original
	 */
	public void setOriginal(String original) {
		this.original = original;
	}
	
	/**
	 * Column Info
	 * @param amend
	 */
	public void setAmend(String amend) {
		this.amend = amend;
	}
	
	/**
	 * Column Info
	 * @param customs
	 */
	public void setCustoms(String customs) {
		this.customs = customs;
	}
	
	/**
	 * Column Info
	 * @param customsPer
	 */
	public void setCustomsPer(String customsPer) {
		this.customsPer = customsPer;
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
		setBlConfirm(JSPUtil.getParameter(request, prefix + "bl_confirm", ""));
		setRegion(JSPUtil.getParameter(request, prefix + "region", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setAmendPer(JSPUtil.getParameter(request, prefix + "amend_per", ""));
		setAdditionPer(JSPUtil.getParameter(request, prefix + "addition_per", ""));
		setAddition(JSPUtil.getParameter(request, prefix + "addition", ""));
		setOriginalPer(JSPUtil.getParameter(request, prefix + "original_per", ""));
		setKind(JSPUtil.getParameter(request, prefix + "kind", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBlConfirmPer(JSPUtil.getParameter(request, prefix + "bl_confirm_per", ""));
		setOriginal(JSPUtil.getParameter(request, prefix + "original", ""));
		setAmend(JSPUtil.getParameter(request, prefix + "amend", ""));
		setCustoms(JSPUtil.getParameter(request, prefix + "customs", ""));
		setCustomsPer(JSPUtil.getParameter(request, prefix + "customs_per", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueSummarySRKindVO[]
	 */
	public DocQueueSummarySRKindVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocQueueSummarySRKindVO[]
	 */
	public DocQueueSummarySRKindVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocQueueSummarySRKindVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blConfirm = (JSPUtil.getParameter(request, prefix	+ "bl_confirm", length));
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] amendPer = (JSPUtil.getParameter(request, prefix	+ "amend_per", length));
			String[] additionPer = (JSPUtil.getParameter(request, prefix	+ "addition_per", length));
			String[] addition = (JSPUtil.getParameter(request, prefix	+ "addition", length));
			String[] originalPer = (JSPUtil.getParameter(request, prefix	+ "original_per", length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] blConfirmPer = (JSPUtil.getParameter(request, prefix	+ "bl_confirm_per", length));
			String[] original = (JSPUtil.getParameter(request, prefix	+ "original", length));
			String[] amend = (JSPUtil.getParameter(request, prefix	+ "amend", length));
			String[] customs = (JSPUtil.getParameter(request, prefix	+ "customs", length));
			String[] customsPer = (JSPUtil.getParameter(request, prefix	+ "customs_per", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueSummarySRKindVO();
				if (blConfirm[i] != null)
					model.setBlConfirm(blConfirm[i]);
				if (region[i] != null)
					model.setRegion(region[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (total[i] != null)
					model.setTotal(total[i]);
				if (amendPer[i] != null)
					model.setAmendPer(amendPer[i]);
				if (additionPer[i] != null)
					model.setAdditionPer(additionPer[i]);
				if (addition[i] != null)
					model.setAddition(addition[i]);
				if (originalPer[i] != null)
					model.setOriginalPer(originalPer[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (blConfirmPer[i] != null)
					model.setBlConfirmPer(blConfirmPer[i]);
				if (original[i] != null)
					model.setOriginal(original[i]);
				if (amend[i] != null)
					model.setAmend(amend[i]);
				if (customs[i] != null)
					model.setCustoms(customs[i]);
				if (customsPer[i] != null)
					model.setCustomsPer(customsPer[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocQueueSummarySRKindVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocQueueSummarySRKindVO[]
	 */
	public DocQueueSummarySRKindVO[] getDocQueueSummarySRKindVOs(){
		DocQueueSummarySRKindVO[] vos = (DocQueueSummarySRKindVO[])models.toArray(new DocQueueSummarySRKindVO[models.size()]);
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
		this.blConfirm = this.blConfirm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendPer = this.amendPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.additionPer = this.additionPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addition = this.addition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.originalPer = this.originalPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blConfirmPer = this.blConfirmPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.original = this.original .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amend = this.amend .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customs = this.customs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsPer = this.customsPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
