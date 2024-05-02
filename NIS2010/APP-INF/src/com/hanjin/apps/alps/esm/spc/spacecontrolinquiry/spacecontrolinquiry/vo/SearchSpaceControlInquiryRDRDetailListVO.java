/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SearchSpaceControlInquiryRDRDetailListVO.java
*@FileTitle : SearchSpaceControlInquiryRDRDetailListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.05
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2011.07.05 최윤성 
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
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSpaceControlInquiryRDRDetailListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSpaceControlInquiryRDRDetailListVO> models = new ArrayList<SearchSpaceControlInquiryRDRDetailListVO>();
	
	/* Column Info */
	private String cntr20 = null;
	/* Column Info */
	private String cntr40 = null;
	/* Column Info */
	private String fullWgt = null;
	/* Column Info */
	private String basicSlot = null;
	/* Column Info */
	private String cntr40h = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String cntr20h = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String cntr45 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrType = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String costWk = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String fullTeu = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String mtyWgt = null;
	/* Column Info */
	private String mtyTeu = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSpaceControlInquiryRDRDetailListVO() {}

	public SearchSpaceControlInquiryRDRDetailListVO(String ibflag, String pagerows, String oprCd, String costWk, String trdCd, String subTrdCd, String rlaneCd, String vvd, String dirCd, String basicSlot, String cntrType, String cntr20, String cntr20h, String cntr40, String cntr40h, String cntr45, String fullTeu, String fullWgt, String mtyTeu, String mtyWgt, String pol, String pod) {
		this.cntr20 = cntr20;
		this.cntr40 = cntr40;
		this.fullWgt = fullWgt;
		this.basicSlot = basicSlot;
		this.cntr40h = cntr40h;
		this.trdCd = trdCd;
		this.cntr20h = cntr20h;
		this.rlaneCd = rlaneCd;
		this.cntr45 = cntr45;
		this.pagerows = pagerows;
		this.cntrType = cntrType;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.oprCd = oprCd;
		this.costWk = costWk;
		this.pol = pol;
		this.fullTeu = fullTeu;
		this.dirCd = dirCd;
		this.mtyWgt = mtyWgt;
		this.mtyTeu = mtyTeu;
		this.subTrdCd = subTrdCd;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_20", getCntr20());
		this.hashColumns.put("cntr_40", getCntr40());
		this.hashColumns.put("full_wgt", getFullWgt());
		this.hashColumns.put("basic_slot", getBasicSlot());
		this.hashColumns.put("cntr_40h", getCntr40h());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("cntr_20h", getCntr20h());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("cntr_45", getCntr45());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("cost_wk", getCostWk());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("full_teu", getFullTeu());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("mty_wgt", getMtyWgt());
		this.hashColumns.put("mty_teu", getMtyTeu());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_20", "cntr20");
		this.hashFields.put("cntr_40", "cntr40");
		this.hashFields.put("full_wgt", "fullWgt");
		this.hashFields.put("basic_slot", "basicSlot");
		this.hashFields.put("cntr_40h", "cntr40h");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("cntr_20h", "cntr20h");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("cntr_45", "cntr45");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("cost_wk", "costWk");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("full_teu", "fullTeu");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("mty_wgt", "mtyWgt");
		this.hashFields.put("mty_teu", "mtyTeu");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntr20
	 */
	public String getCntr20() {
		return this.cntr20;
	}
	
	/**
	 * Column Info
	 * @return cntr40
	 */
	public String getCntr40() {
		return this.cntr40;
	}
	
	/**
	 * Column Info
	 * @return fullWgt
	 */
	public String getFullWgt() {
		return this.fullWgt;
	}
	
	/**
	 * Column Info
	 * @return basicSlot
	 */
	public String getBasicSlot() {
		return this.basicSlot;
	}
	
	/**
	 * Column Info
	 * @return cntr40h
	 */
	public String getCntr40h() {
		return this.cntr40h;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return cntr20h
	 */
	public String getCntr20h() {
		return this.cntr20h;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return cntr45
	 */
	public String getCntr45() {
		return this.cntr45;
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
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return costWk
	 */
	public String getCostWk() {
		return this.costWk;
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
	 * @return fullTeu
	 */
	public String getFullTeu() {
		return this.fullTeu;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return mtyWgt
	 */
	public String getMtyWgt() {
		return this.mtyWgt;
	}
	
	/**
	 * Column Info
	 * @return mtyTeu
	 */
	public String getMtyTeu() {
		return this.mtyTeu;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	

	/**
	 * Column Info
	 * @param cntr20
	 */
	public void setCntr20(String cntr20) {
		this.cntr20 = cntr20;
	}
	
	/**
	 * Column Info
	 * @param cntr40
	 */
	public void setCntr40(String cntr40) {
		this.cntr40 = cntr40;
	}
	
	/**
	 * Column Info
	 * @param fullWgt
	 */
	public void setFullWgt(String fullWgt) {
		this.fullWgt = fullWgt;
	}
	
	/**
	 * Column Info
	 * @param basicSlot
	 */
	public void setBasicSlot(String basicSlot) {
		this.basicSlot = basicSlot;
	}
	
	/**
	 * Column Info
	 * @param cntr40h
	 */
	public void setCntr40h(String cntr40h) {
		this.cntr40h = cntr40h;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param cntr20h
	 */
	public void setCntr20h(String cntr20h) {
		this.cntr20h = cntr20h;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param cntr45
	 */
	public void setCntr45(String cntr45) {
		this.cntr45 = cntr45;
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
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param costWk
	 */
	public void setCostWk(String costWk) {
		this.costWk = costWk;
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
	 * @param fullTeu
	 */
	public void setFullTeu(String fullTeu) {
		this.fullTeu = fullTeu;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param mtyWgt
	 */
	public void setMtyWgt(String mtyWgt) {
		this.mtyWgt = mtyWgt;
	}
	
	/**
	 * Column Info
	 * @param mtyTeu
	 */
	public void setMtyTeu(String mtyTeu) {
		this.mtyTeu = mtyTeu;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setCntr20(JSPUtil.getParameter(request, prefix + "cntr_20", ""));
		setCntr40(JSPUtil.getParameter(request, prefix + "cntr_40", ""));
		setFullWgt(JSPUtil.getParameter(request, prefix + "full_wgt", ""));
		setBasicSlot(JSPUtil.getParameter(request, prefix + "basic_slot", ""));
		setCntr40h(JSPUtil.getParameter(request, prefix + "cntr_40h", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setCntr20h(JSPUtil.getParameter(request, prefix + "cntr_20h", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setCntr45(JSPUtil.getParameter(request, prefix + "cntr_45", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCntrType(JSPUtil.getParameter(request, prefix + "cntr_type", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
		setCostWk(JSPUtil.getParameter(request, prefix + "cost_wk", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setFullTeu(JSPUtil.getParameter(request, prefix + "full_teu", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setMtyWgt(JSPUtil.getParameter(request, prefix + "mty_wgt", ""));
		setMtyTeu(JSPUtil.getParameter(request, prefix + "mty_teu", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSpaceControlInquiryRDRDetailListVO[]
	 */
	public SearchSpaceControlInquiryRDRDetailListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSpaceControlInquiryRDRDetailListVO[]
	 */
	public SearchSpaceControlInquiryRDRDetailListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSpaceControlInquiryRDRDetailListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntr20 = (JSPUtil.getParameter(request, prefix	+ "cntr_20", length));
			String[] cntr40 = (JSPUtil.getParameter(request, prefix	+ "cntr_40", length));
			String[] fullWgt = (JSPUtil.getParameter(request, prefix	+ "full_wgt", length));
			String[] basicSlot = (JSPUtil.getParameter(request, prefix	+ "basic_slot", length));
			String[] cntr40h = (JSPUtil.getParameter(request, prefix	+ "cntr_40h", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] cntr20h = (JSPUtil.getParameter(request, prefix	+ "cntr_20h", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] cntr45 = (JSPUtil.getParameter(request, prefix	+ "cntr_45", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] costWk = (JSPUtil.getParameter(request, prefix	+ "cost_wk", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] fullTeu = (JSPUtil.getParameter(request, prefix	+ "full_teu", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] mtyWgt = (JSPUtil.getParameter(request, prefix	+ "mty_wgt", length));
			String[] mtyTeu = (JSPUtil.getParameter(request, prefix	+ "mty_teu", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSpaceControlInquiryRDRDetailListVO();
				if (cntr20[i] != null)
					model.setCntr20(cntr20[i]);
				if (cntr40[i] != null)
					model.setCntr40(cntr40[i]);
				if (fullWgt[i] != null)
					model.setFullWgt(fullWgt[i]);
				if (basicSlot[i] != null)
					model.setBasicSlot(basicSlot[i]);
				if (cntr40h[i] != null)
					model.setCntr40h(cntr40h[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (cntr20h[i] != null)
					model.setCntr20h(cntr20h[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (cntr45[i] != null)
					model.setCntr45(cntr45[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (costWk[i] != null)
					model.setCostWk(costWk[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (fullTeu[i] != null)
					model.setFullTeu(fullTeu[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (mtyWgt[i] != null)
					model.setMtyWgt(mtyWgt[i]);
				if (mtyTeu[i] != null)
					model.setMtyTeu(mtyTeu[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSpaceControlInquiryRDRDetailListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSpaceControlInquiryRDRDetailListVO[]
	 */
	public SearchSpaceControlInquiryRDRDetailListVO[] getSearchSpaceControlInquiryRDRDetailListVOs(){
		SearchSpaceControlInquiryRDRDetailListVO[] vos = (SearchSpaceControlInquiryRDRDetailListVO[])models.toArray(new SearchSpaceControlInquiryRDRDetailListVO[models.size()]);
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
		this.cntr20 = this.cntr20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr40 = this.cntr40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullWgt = this.fullWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.basicSlot = this.basicSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr40h = this.cntr40h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20h = this.cntr20h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr45 = this.cntr45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costWk = this.costWk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullTeu = this.fullTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyWgt = this.mtyWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyTeu = this.mtyTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
