/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RDRVslAllocVO.java
*@FileTitle : RDRVslAllocVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.11.17 장석현 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo;

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
 * @author 장석현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDRVslAllocVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRVslAllocVO> models = new ArrayList<RDRVslAllocVO>();
	
	/* Column Info */
	private String swapWgt = null;
	/* Column Info */
	private String basicSlot = null;
	/* Column Info */
	private String releaseWgt = null;
	/* Column Info */
	private String basicWgt = null;
	/* Column Info */
	private String totWgt = null;
	/* Column Info */
	private String totAlloc = null;
	/* Column Info */
	private String swapSlot = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String releaseSlot = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String teuWgt = null;
	/* Column Info */
	private String bsaType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRVslAllocVO() {}

	public RDRVslAllocVO(String ibflag, String pagerows, String oprCd, String basicSlot, String releaseSlot, String swapSlot, String totAlloc, String basicWgt, String releaseWgt, String swapWgt, String totWgt, String bsaType, String teuWgt) {
		this.swapWgt = swapWgt;
		this.basicSlot = basicSlot;
		this.releaseWgt = releaseWgt;
		this.basicWgt = basicWgt;
		this.totWgt = totWgt;
		this.totAlloc = totAlloc;
		this.swapSlot = swapSlot;
		this.pagerows = pagerows;
		this.releaseSlot = releaseSlot;
		this.ibflag = ibflag;
		this.oprCd = oprCd;
		this.teuWgt = teuWgt;
		this.bsaType = bsaType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("swap_wgt", getSwapWgt());
		this.hashColumns.put("basic_slot", getBasicSlot());
		this.hashColumns.put("release_wgt", getReleaseWgt());
		this.hashColumns.put("basic_wgt", getBasicWgt());
		this.hashColumns.put("tot_wgt", getTotWgt());
		this.hashColumns.put("tot_alloc", getTotAlloc());
		this.hashColumns.put("swap_slot", getSwapSlot());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("release_slot", getReleaseSlot());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("teu_wgt", getTeuWgt());
		this.hashColumns.put("bsa_type", getBsaType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("swap_wgt", "swapWgt");
		this.hashFields.put("basic_slot", "basicSlot");
		this.hashFields.put("release_wgt", "releaseWgt");
		this.hashFields.put("basic_wgt", "basicWgt");
		this.hashFields.put("tot_wgt", "totWgt");
		this.hashFields.put("tot_alloc", "totAlloc");
		this.hashFields.put("swap_slot", "swapSlot");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("release_slot", "releaseSlot");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("teu_wgt", "teuWgt");
		this.hashFields.put("bsa_type", "bsaType");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return swapWgt
	 */
	public String getSwapWgt() {
		return this.swapWgt;
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
	 * @return releaseWgt
	 */
	public String getReleaseWgt() {
		return this.releaseWgt;
	}
	
	/**
	 * Column Info
	 * @return basicWgt
	 */
	public String getBasicWgt() {
		return this.basicWgt;
	}
	
	/**
	 * Column Info
	 * @return totWgt
	 */
	public String getTotWgt() {
		return this.totWgt;
	}
	
	/**
	 * Column Info
	 * @return totAlloc
	 */
	public String getTotAlloc() {
		return this.totAlloc;
	}
	
	/**
	 * Column Info
	 * @return swapSlot
	 */
	public String getSwapSlot() {
		return this.swapSlot;
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
	 * @return releaseSlot
	 */
	public String getReleaseSlot() {
		return this.releaseSlot;
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
	 * @return teuWgt
	 */
	public String getTeuWgt() {
		return this.teuWgt;
	}
	
	/**
	 * Column Info
	 * @return bsaType
	 */
	public String getBsaType() {
		return this.bsaType;
	}
	

	/**
	 * Column Info
	 * @param swapWgt
	 */
	public void setSwapWgt(String swapWgt) {
		this.swapWgt = swapWgt;
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
	 * @param releaseWgt
	 */
	public void setReleaseWgt(String releaseWgt) {
		this.releaseWgt = releaseWgt;
	}
	
	/**
	 * Column Info
	 * @param basicWgt
	 */
	public void setBasicWgt(String basicWgt) {
		this.basicWgt = basicWgt;
	}
	
	/**
	 * Column Info
	 * @param totWgt
	 */
	public void setTotWgt(String totWgt) {
		this.totWgt = totWgt;
	}
	
	/**
	 * Column Info
	 * @param totAlloc
	 */
	public void setTotAlloc(String totAlloc) {
		this.totAlloc = totAlloc;
	}
	
	/**
	 * Column Info
	 * @param swapSlot
	 */
	public void setSwapSlot(String swapSlot) {
		this.swapSlot = swapSlot;
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
	 * @param releaseSlot
	 */
	public void setReleaseSlot(String releaseSlot) {
		this.releaseSlot = releaseSlot;
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
	 * @param teuWgt
	 */
	public void setTeuWgt(String teuWgt) {
		this.teuWgt = teuWgt;
	}
	
	/**
	 * Column Info
	 * @param bsaType
	 */
	public void setBsaType(String bsaType) {
		this.bsaType = bsaType;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSwapWgt(JSPUtil.getParameter(request, "swap_wgt", ""));
		setBasicSlot(JSPUtil.getParameter(request, "basic_slot", ""));
		setReleaseWgt(JSPUtil.getParameter(request, "release_wgt", ""));
		setBasicWgt(JSPUtil.getParameter(request, "basic_wgt", ""));
		setTotWgt(JSPUtil.getParameter(request, "tot_wgt", ""));
		setTotAlloc(JSPUtil.getParameter(request, "tot_alloc", ""));
		setSwapSlot(JSPUtil.getParameter(request, "swap_slot", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setReleaseSlot(JSPUtil.getParameter(request, "release_slot", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setTeuWgt(JSPUtil.getParameter(request, "teu_wgt", ""));
		setBsaType(JSPUtil.getParameter(request, "bsa_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRVslAllocVO[]
	 */
	public RDRVslAllocVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRVslAllocVO[]
	 */
	public RDRVslAllocVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRVslAllocVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] swapWgt = (JSPUtil.getParameter(request, prefix	+ "swap_wgt", length));
			String[] basicSlot = (JSPUtil.getParameter(request, prefix	+ "basic_slot", length));
			String[] releaseWgt = (JSPUtil.getParameter(request, prefix	+ "release_wgt", length));
			String[] basicWgt = (JSPUtil.getParameter(request, prefix	+ "basic_wgt", length));
			String[] totWgt = (JSPUtil.getParameter(request, prefix	+ "tot_wgt", length));
			String[] totAlloc = (JSPUtil.getParameter(request, prefix	+ "tot_alloc", length));
			String[] swapSlot = (JSPUtil.getParameter(request, prefix	+ "swap_slot", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] releaseSlot = (JSPUtil.getParameter(request, prefix	+ "release_slot", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] teuWgt = (JSPUtil.getParameter(request, prefix	+ "teu_wgt", length));
			String[] bsaType = (JSPUtil.getParameter(request, prefix	+ "bsa_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRVslAllocVO();
				if (swapWgt[i] != null)
					model.setSwapWgt(swapWgt[i]);
				if (basicSlot[i] != null)
					model.setBasicSlot(basicSlot[i]);
				if (releaseWgt[i] != null)
					model.setReleaseWgt(releaseWgt[i]);
				if (basicWgt[i] != null)
					model.setBasicWgt(basicWgt[i]);
				if (totWgt[i] != null)
					model.setTotWgt(totWgt[i]);
				if (totAlloc[i] != null)
					model.setTotAlloc(totAlloc[i]);
				if (swapSlot[i] != null)
					model.setSwapSlot(swapSlot[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (releaseSlot[i] != null)
					model.setReleaseSlot(releaseSlot[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (teuWgt[i] != null)
					model.setTeuWgt(teuWgt[i]);
				if (bsaType[i] != null)
					model.setBsaType(bsaType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRVslAllocVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRVslAllocVO[]
	 */
	public RDRVslAllocVO[] getRDRVslAllocVOs(){
		RDRVslAllocVO[] vos = (RDRVslAllocVO[])models.toArray(new RDRVslAllocVO[models.size()]);
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
		this.swapWgt = this.swapWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.basicSlot = this.basicSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.releaseWgt = this.releaseWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.basicWgt = this.basicWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totWgt = this.totWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAlloc = this.totAlloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.swapSlot = this.swapSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.releaseSlot = this.releaseSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuWgt = this.teuWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaType = this.bsaType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
