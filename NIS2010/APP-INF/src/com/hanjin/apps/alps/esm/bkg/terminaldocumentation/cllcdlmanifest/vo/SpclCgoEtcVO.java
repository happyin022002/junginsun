/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpclCgoEtcVO.java
*@FileTitle : SpclCgoEtcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpclCgoEtcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpclCgoEtcVO> models = new ArrayList<SpclCgoEtcVO>();
	
	/* Column Info */
	private String eDetail = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eMlb = null;
	/* Column Info */
	private String ePod = null;
	/* Column Info */
	private String eTp = null;
	/* Column Info */
	private String eCntrNo = null;
	/* Column Info */
	private String eCgoType = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpclCgoEtcVO() {}

	public SpclCgoEtcVO(String ibflag, String pagerows, String eCgoType, String ePod, String eMlb, String eCntrNo, String eTp, String eDetail) {
		this.eDetail = eDetail;
		this.ibflag = ibflag;
		this.eMlb = eMlb;
		this.ePod = ePod;
		this.eTp = eTp;
		this.eCntrNo = eCntrNo;
		this.eCgoType = eCgoType;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("e_detail", getEDetail());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("e_mlb", getEMlb());
		this.hashColumns.put("e_pod", getEPod());
		this.hashColumns.put("e_tp", getETp());
		this.hashColumns.put("e_cntr_no", getECntrNo());
		this.hashColumns.put("e_cgo_type", getECgoType());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("e_detail", "eDetail");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("e_mlb", "eMlb");
		this.hashFields.put("e_pod", "ePod");
		this.hashFields.put("e_tp", "eTp");
		this.hashFields.put("e_cntr_no", "eCntrNo");
		this.hashFields.put("e_cgo_type", "eCgoType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eDetail
	 */
	public String getEDetail() {
		return this.eDetail;
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
	 * @return eMlb
	 */
	public String getEMlb() {
		return this.eMlb;
	}
	
	/**
	 * Column Info
	 * @return ePod
	 */
	public String getEPod() {
		return this.ePod;
	}
	
	/**
	 * Column Info
	 * @return eTp
	 */
	public String getETp() {
		return this.eTp;
	}
	
	/**
	 * Column Info
	 * @return eCntrNo
	 */
	public String getECntrNo() {
		return this.eCntrNo;
	}
	
	/**
	 * Column Info
	 * @return eCgoType
	 */
	public String getECgoType() {
		return this.eCgoType;
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
	 * @param eDetail
	 */
	public void setEDetail(String eDetail) {
		this.eDetail = eDetail;
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
	 * @param eMlb
	 */
	public void setEMlb(String eMlb) {
		this.eMlb = eMlb;
	}
	
	/**
	 * Column Info
	 * @param ePod
	 */
	public void setEPod(String ePod) {
		this.ePod = ePod;
	}
	
	/**
	 * Column Info
	 * @param eTp
	 */
	public void setETp(String eTp) {
		this.eTp = eTp;
	}
	
	/**
	 * Column Info
	 * @param eCntrNo
	 */
	public void setECntrNo(String eCntrNo) {
		this.eCntrNo = eCntrNo;
	}
	
	/**
	 * Column Info
	 * @param eCgoType
	 */
	public void setECgoType(String eCgoType) {
		this.eCgoType = eCgoType;
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
		setEDetail(JSPUtil.getParameter(request, prefix + "e_detail", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEMlb(JSPUtil.getParameter(request, prefix + "e_mlb", ""));
		setEPod(JSPUtil.getParameter(request, prefix + "e_pod", ""));
		setETp(JSPUtil.getParameter(request, prefix + "e_tp", ""));
		setECntrNo(JSPUtil.getParameter(request, prefix + "e_cntr_no", ""));
		setECgoType(JSPUtil.getParameter(request, prefix + "e_cgo_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpclCgoEtcVO[]
	 */
	public SpclCgoEtcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpclCgoEtcVO[]
	 */
	public SpclCgoEtcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpclCgoEtcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eDetail = (JSPUtil.getParameter(request, prefix	+ "e_detail", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eMlb = (JSPUtil.getParameter(request, prefix	+ "e_mlb", length));
			String[] ePod = (JSPUtil.getParameter(request, prefix	+ "e_pod", length));
			String[] eTp = (JSPUtil.getParameter(request, prefix	+ "e_tp", length));
			String[] eCntrNo = (JSPUtil.getParameter(request, prefix	+ "e_cntr_no", length));
			String[] eCgoType = (JSPUtil.getParameter(request, prefix	+ "e_cgo_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpclCgoEtcVO();
				if (eDetail[i] != null)
					model.setEDetail(eDetail[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eMlb[i] != null)
					model.setEMlb(eMlb[i]);
				if (ePod[i] != null)
					model.setEPod(ePod[i]);
				if (eTp[i] != null)
					model.setETp(eTp[i]);
				if (eCntrNo[i] != null)
					model.setECntrNo(eCntrNo[i]);
				if (eCgoType[i] != null)
					model.setECgoType(eCgoType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpclCgoEtcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpclCgoEtcVO[]
	 */
	public SpclCgoEtcVO[] getSpclCgoEtcVOs(){
		SpclCgoEtcVO[] vos = (SpclCgoEtcVO[])models.toArray(new SpclCgoEtcVO[models.size()]);
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
		this.eDetail = this.eDetail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eMlb = this.eMlb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ePod = this.ePod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eTp = this.eTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eCntrNo = this.eCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eCgoType = this.eCgoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
