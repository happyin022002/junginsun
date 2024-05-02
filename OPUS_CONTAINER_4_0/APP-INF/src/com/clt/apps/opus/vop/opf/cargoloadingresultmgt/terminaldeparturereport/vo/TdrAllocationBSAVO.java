/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TdrAllocationBSAVO.java
*@FileTitle : TdrAllocationBSAVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2010.01.14 장석현 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장석현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TdrAllocationBSAVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TdrAllocationBSAVO> models = new ArrayList<TdrAllocationBSAVO>();
	
	/* Column Info */
	private String swapWgt = null;
	/* Column Info */
	private String ratioType = null;
	/* Column Info */
	private String releaseWgt = null;
	/* Column Info */
	private String ttlAlloc = null;
	/* Column Info */
	private String bsaWgt = null;
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
	private String bsaSlot = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String ttlWeight = null;
	/* Column Info */
	private String bsaType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TdrAllocationBSAVO() {}

	public TdrAllocationBSAVO(String ibflag, String pagerows, String oprCd, String bsaSlot, String releaseSlot, String swapSlot, String ttlAlloc, String bsaWgt, String releaseWgt, String swapWgt, String bsaType, String ttlWeight, String teu, String ratioType) {
		this.swapWgt = swapWgt;
		this.ratioType = ratioType;
		this.releaseWgt = releaseWgt;
		this.ttlAlloc = ttlAlloc;
		this.bsaWgt = bsaWgt;
		this.swapSlot = swapSlot;
		this.pagerows = pagerows;
		this.releaseSlot = releaseSlot;
		this.ibflag = ibflag;
		this.oprCd = oprCd;
		this.bsaSlot = bsaSlot;
		this.teu = teu;
		this.ttlWeight = ttlWeight;
		this.bsaType = bsaType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("swap_wgt", getSwapWgt());
		this.hashColumns.put("ratio_type", getRatioType());
		this.hashColumns.put("release_wgt", getReleaseWgt());
		this.hashColumns.put("ttl_alloc", getTtlAlloc());
		this.hashColumns.put("bsa_wgt", getBsaWgt());
		this.hashColumns.put("swap_slot", getSwapSlot());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("release_slot", getReleaseSlot());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("bsa_slot", getBsaSlot());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("ttl_weight", getTtlWeight());
		this.hashColumns.put("bsa_type", getBsaType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("swap_wgt", "swapWgt");
		this.hashFields.put("ratio_type", "ratioType");
		this.hashFields.put("release_wgt", "releaseWgt");
		this.hashFields.put("ttl_alloc", "ttlAlloc");
		this.hashFields.put("bsa_wgt", "bsaWgt");
		this.hashFields.put("swap_slot", "swapSlot");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("release_slot", "releaseSlot");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("bsa_slot", "bsaSlot");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("ttl_weight", "ttlWeight");
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
	 * @return ratioType
	 */
	public String getRatioType() {
		return this.ratioType;
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
	 * @return ttlAlloc
	 */
	public String getTtlAlloc() {
		return this.ttlAlloc;
	}
	
	/**
	 * Column Info
	 * @return bsaWgt
	 */
	public String getBsaWgt() {
		return this.bsaWgt;
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
	 * @return bsaSlot
	 */
	public String getBsaSlot() {
		return this.bsaSlot;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return ttlWeight
	 */
	public String getTtlWeight() {
		return this.ttlWeight;
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
	 * @param ratioType
	 */
	public void setRatioType(String ratioType) {
		this.ratioType = ratioType;
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
	 * @param ttlAlloc
	 */
	public void setTtlAlloc(String ttlAlloc) {
		this.ttlAlloc = ttlAlloc;
	}
	
	/**
	 * Column Info
	 * @param bsaWgt
	 */
	public void setBsaWgt(String bsaWgt) {
		this.bsaWgt = bsaWgt;
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
	 * @param bsaSlot
	 */
	public void setBsaSlot(String bsaSlot) {
		this.bsaSlot = bsaSlot;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param ttlWeight
	 */
	public void setTtlWeight(String ttlWeight) {
		this.ttlWeight = ttlWeight;
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
		setRatioType(JSPUtil.getParameter(request, "ratio_type", ""));
		setReleaseWgt(JSPUtil.getParameter(request, "release_wgt", ""));
		setTtlAlloc(JSPUtil.getParameter(request, "ttl_alloc", ""));
		setBsaWgt(JSPUtil.getParameter(request, "bsa_wgt", ""));
		setSwapSlot(JSPUtil.getParameter(request, "swap_slot", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setReleaseSlot(JSPUtil.getParameter(request, "release_slot", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setBsaSlot(JSPUtil.getParameter(request, "bsa_slot", ""));
		setTeu(JSPUtil.getParameter(request, "teu", ""));
		setTtlWeight(JSPUtil.getParameter(request, "ttl_weight", ""));
		setBsaType(JSPUtil.getParameter(request, "bsa_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TdrAllocationBSAVO[]
	 */
	public TdrAllocationBSAVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TdrAllocationBSAVO[]
	 */
	public TdrAllocationBSAVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TdrAllocationBSAVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] swapWgt = (JSPUtil.getParameter(request, prefix	+ "swap_wgt", length));
			String[] ratioType = (JSPUtil.getParameter(request, prefix	+ "ratio_type", length));
			String[] releaseWgt = (JSPUtil.getParameter(request, prefix	+ "release_wgt", length));
			String[] ttlAlloc = (JSPUtil.getParameter(request, prefix	+ "ttl_alloc", length));
			String[] bsaWgt = (JSPUtil.getParameter(request, prefix	+ "bsa_wgt", length));
			String[] swapSlot = (JSPUtil.getParameter(request, prefix	+ "swap_slot", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] releaseSlot = (JSPUtil.getParameter(request, prefix	+ "release_slot", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] bsaSlot = (JSPUtil.getParameter(request, prefix	+ "bsa_slot", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] ttlWeight = (JSPUtil.getParameter(request, prefix	+ "ttl_weight", length));
			String[] bsaType = (JSPUtil.getParameter(request, prefix	+ "bsa_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new TdrAllocationBSAVO();
				if (swapWgt[i] != null)
					model.setSwapWgt(swapWgt[i]);
				if (ratioType[i] != null)
					model.setRatioType(ratioType[i]);
				if (releaseWgt[i] != null)
					model.setReleaseWgt(releaseWgt[i]);
				if (ttlAlloc[i] != null)
					model.setTtlAlloc(ttlAlloc[i]);
				if (bsaWgt[i] != null)
					model.setBsaWgt(bsaWgt[i]);
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
				if (bsaSlot[i] != null)
					model.setBsaSlot(bsaSlot[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (ttlWeight[i] != null)
					model.setTtlWeight(ttlWeight[i]);
				if (bsaType[i] != null)
					model.setBsaType(bsaType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTdrAllocationBSAVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TdrAllocationBSAVO[]
	 */
	public TdrAllocationBSAVO[] getTdrAllocationBSAVOs(){
		TdrAllocationBSAVO[] vos = (TdrAllocationBSAVO[])models.toArray(new TdrAllocationBSAVO[models.size()]);
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
		this.ratioType = this.ratioType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.releaseWgt = this.releaseWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAlloc = this.ttlAlloc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaWgt = this.bsaWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.swapSlot = this.swapSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.releaseSlot = this.releaseSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSlot = this.bsaSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlWeight = this.ttlWeight .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaType = this.bsaType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
