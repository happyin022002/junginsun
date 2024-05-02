/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RDROverUsedVO.java
*@FileTitle : RDROverUsedVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2010.01.06 장석현 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo;

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

public class RDROverUsedVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDROverUsedVO> models = new ArrayList<RDROverUsedVO>();
	
	/* Column Info */
	private String releaseWgt = null;
	/* Column Info */
	private String overSetBy = null;
	/* Column Info */
	private String usedWgt = null;
	/* Column Info */
	private String bsaWgt = null;
	/* Column Info */
	private String overWgt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String releaseSlot = null;
	/* Column Info */
	private String overSlot = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fromPod = null;
	/* Column Info */
	private String toPod = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String bsaSlot = null;
	/* Column Info */
	private String usedSlot = null;
	/* Column Info */
	private String overSetSlot = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDROverUsedVO() {}

	public RDROverUsedVO(String ibflag, String pagerows, String oprCd, String fromPod, String toPod, String bsaSlot, String bsaWgt, String usedSlot, String usedWgt, String overSlot, String overWgt, String releaseSlot, String releaseWgt, String overSetSlot, String overSetBy) {
		this.releaseWgt = releaseWgt;
		this.overSetBy = overSetBy;
		this.usedWgt = usedWgt;
		this.bsaWgt = bsaWgt;
		this.overWgt = overWgt;
		this.pagerows = pagerows;
		this.releaseSlot = releaseSlot;
		this.overSlot = overSlot;
		this.ibflag = ibflag;
		this.fromPod = fromPod;
		this.toPod = toPod;
		this.oprCd = oprCd;
		this.bsaSlot = bsaSlot;
		this.usedSlot = usedSlot;
		this.overSetSlot = overSetSlot;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("release_wgt", getReleaseWgt());
		this.hashColumns.put("over_set_by", getOverSetBy());
		this.hashColumns.put("used_wgt", getUsedWgt());
		this.hashColumns.put("bsa_wgt", getBsaWgt());
		this.hashColumns.put("over_wgt", getOverWgt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("release_slot", getReleaseSlot());
		this.hashColumns.put("over_slot", getOverSlot());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("from_pod", getFromPod());
		this.hashColumns.put("to_pod", getToPod());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("bsa_slot", getBsaSlot());
		this.hashColumns.put("used_slot", getUsedSlot());
		this.hashColumns.put("over_set_slot", getOverSetSlot());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("release_wgt", "releaseWgt");
		this.hashFields.put("over_set_by", "overSetBy");
		this.hashFields.put("used_wgt", "usedWgt");
		this.hashFields.put("bsa_wgt", "bsaWgt");
		this.hashFields.put("over_wgt", "overWgt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("release_slot", "releaseSlot");
		this.hashFields.put("over_slot", "overSlot");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("from_pod", "fromPod");
		this.hashFields.put("to_pod", "toPod");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("bsa_slot", "bsaSlot");
		this.hashFields.put("used_slot", "usedSlot");
		this.hashFields.put("over_set_slot", "overSetSlot");
		return this.hashFields;
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
	 * @return overSetBy
	 */
	public String getOverSetBy() {
		return this.overSetBy;
	}
	
	/**
	 * Column Info
	 * @return usedWgt
	 */
	public String getUsedWgt() {
		return this.usedWgt;
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
	 * @return overWgt
	 */
	public String getOverWgt() {
		return this.overWgt;
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
	 * Column Info
	 * @return overSlot
	 */
	public String getOverSlot() {
		return this.overSlot;
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
	 * @return fromPod
	 */
	public String getFromPod() {
		return this.fromPod;
	}
	
	/**
	 * Column Info
	 * @return toPod
	 */
	public String getToPod() {
		return this.toPod;
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
	 * @return usedSlot
	 */
	public String getUsedSlot() {
		return this.usedSlot;
	}
	
	/**
	 * Column Info
	 * @return overSetSlot
	 */
	public String getOverSetSlot() {
		return this.overSetSlot;
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
	 * @param overSetBy
	 */
	public void setOverSetBy(String overSetBy) {
		this.overSetBy = overSetBy;
	}
	
	/**
	 * Column Info
	 * @param usedWgt
	 */
	public void setUsedWgt(String usedWgt) {
		this.usedWgt = usedWgt;
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
	 * @param overWgt
	 */
	public void setOverWgt(String overWgt) {
		this.overWgt = overWgt;
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
	 * Column Info
	 * @param overSlot
	 */
	public void setOverSlot(String overSlot) {
		this.overSlot = overSlot;
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
	 * @param fromPod
	 */
	public void setFromPod(String fromPod) {
		this.fromPod = fromPod;
	}
	
	/**
	 * Column Info
	 * @param toPod
	 */
	public void setToPod(String toPod) {
		this.toPod = toPod;
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
	 * @param usedSlot
	 */
	public void setUsedSlot(String usedSlot) {
		this.usedSlot = usedSlot;
	}
	
	/**
	 * Column Info
	 * @param overSetSlot
	 */
	public void setOverSetSlot(String overSetSlot) {
		this.overSetSlot = overSetSlot;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setReleaseWgt(JSPUtil.getParameter(request, "release_wgt", ""));
		setOverSetBy(JSPUtil.getParameter(request, "over_set_by", ""));
		setUsedWgt(JSPUtil.getParameter(request, "used_wgt", ""));
		setBsaWgt(JSPUtil.getParameter(request, "bsa_wgt", ""));
		setOverWgt(JSPUtil.getParameter(request, "over_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setReleaseSlot(JSPUtil.getParameter(request, "release_slot", ""));
		setOverSlot(JSPUtil.getParameter(request, "over_slot", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFromPod(JSPUtil.getParameter(request, "from_pod", ""));
		setToPod(JSPUtil.getParameter(request, "to_pod", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setBsaSlot(JSPUtil.getParameter(request, "bsa_slot", ""));
		setUsedSlot(JSPUtil.getParameter(request, "used_slot", ""));
		setOverSetSlot(JSPUtil.getParameter(request, "over_set_slot", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDROverUsedVO[]
	 */
	public RDROverUsedVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDROverUsedVO[]
	 */
	public RDROverUsedVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDROverUsedVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] releaseWgt = (JSPUtil.getParameter(request, prefix	+ "release_wgt", length));
			String[] overSetBy = (JSPUtil.getParameter(request, prefix	+ "over_set_by", length));
			String[] usedWgt = (JSPUtil.getParameter(request, prefix	+ "used_wgt", length));
			String[] bsaWgt = (JSPUtil.getParameter(request, prefix	+ "bsa_wgt", length));
			String[] overWgt = (JSPUtil.getParameter(request, prefix	+ "over_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] releaseSlot = (JSPUtil.getParameter(request, prefix	+ "release_slot", length));
			String[] overSlot = (JSPUtil.getParameter(request, prefix	+ "over_slot", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fromPod = (JSPUtil.getParameter(request, prefix	+ "from_pod", length));
			String[] toPod = (JSPUtil.getParameter(request, prefix	+ "to_pod", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] bsaSlot = (JSPUtil.getParameter(request, prefix	+ "bsa_slot", length));
			String[] usedSlot = (JSPUtil.getParameter(request, prefix	+ "used_slot", length));
			String[] overSetSlot = (JSPUtil.getParameter(request, prefix	+ "over_set_slot", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDROverUsedVO();
				if (releaseWgt[i] != null)
					model.setReleaseWgt(releaseWgt[i]);
				if (overSetBy[i] != null)
					model.setOverSetBy(overSetBy[i]);
				if (usedWgt[i] != null)
					model.setUsedWgt(usedWgt[i]);
				if (bsaWgt[i] != null)
					model.setBsaWgt(bsaWgt[i]);
				if (overWgt[i] != null)
					model.setOverWgt(overWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (releaseSlot[i] != null)
					model.setReleaseSlot(releaseSlot[i]);
				if (overSlot[i] != null)
					model.setOverSlot(overSlot[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fromPod[i] != null)
					model.setFromPod(fromPod[i]);
				if (toPod[i] != null)
					model.setToPod(toPod[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (bsaSlot[i] != null)
					model.setBsaSlot(bsaSlot[i]);
				if (usedSlot[i] != null)
					model.setUsedSlot(usedSlot[i]);
				if (overSetSlot[i] != null)
					model.setOverSetSlot(overSetSlot[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDROverUsedVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDROverUsedVO[]
	 */
	public RDROverUsedVO[] getRDROverUsedVOs(){
		RDROverUsedVO[] vos = (RDROverUsedVO[])models.toArray(new RDROverUsedVO[models.size()]);
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
		this.releaseWgt = this.releaseWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overSetBy = this.overSetBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedWgt = this.usedWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaWgt = this.bsaWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overWgt = this.overWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.releaseSlot = this.releaseSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overSlot = this.overSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromPod = this.fromPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPod = this.toPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSlot = this.bsaSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedSlot = this.usedSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overSetSlot = this.overSetSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
