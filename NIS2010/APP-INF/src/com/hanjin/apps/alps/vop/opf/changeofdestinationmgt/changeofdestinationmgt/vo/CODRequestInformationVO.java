/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CODRequestInformationVO.java
*@FileTitle : CODRequestInformationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.06
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2010.09.06 원종규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo;

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
 * @author 원종규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CODRequestInformationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CODRequestInformationVO> models = new ArrayList<CODRequestInformationVO>();
	
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String condition = null;
	/* Column Info */
	private String newPodFullNm = null;
	/* Column Info */
	private String cntrStwgNo = null;
	/* Column Info */
	private String carrierCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTpszDesc = null;
	/* Column Info */
	private String oldPodCd = null;
	/* Column Info */
	private String oldPodFullNm = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String newPodCd = null;
	/* Column Info */
	private String picEml = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CODRequestInformationVO() {}

	public CODRequestInformationVO(String ibflag, String pagerows, String cntrNo, String cntrTpszCd, String cntrWgt, String condition, String cntrStwgNo, String cntrTpszDesc, String picEml, String carrierCd, String newPodCd, String newPodFullNm, String oldPodCd, String oldPodFullNm) {
		this.cntrWgt = cntrWgt;
		this.condition = condition;
		this.newPodFullNm = newPodFullNm;
		this.cntrStwgNo = cntrStwgNo;
		this.carrierCd = carrierCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.cntrTpszDesc = cntrTpszDesc;
		this.oldPodCd = oldPodCd;
		this.oldPodFullNm = oldPodFullNm;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.newPodCd = newPodCd;
		this.picEml = picEml;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("condition", getCondition());
		this.hashColumns.put("new_pod_full_nm", getNewPodFullNm());
		this.hashColumns.put("cntr_stwg_no", getCntrStwgNo());
		this.hashColumns.put("carrier_cd", getCarrierCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tpsz_desc", getCntrTpszDesc());
		this.hashColumns.put("old_pod_cd", getOldPodCd());
		this.hashColumns.put("old_pod_full_nm", getOldPodFullNm());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("new_pod_cd", getNewPodCd());
		this.hashColumns.put("pic_eml", getPicEml());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("condition", "condition");
		this.hashFields.put("new_pod_full_nm", "newPodFullNm");
		this.hashFields.put("cntr_stwg_no", "cntrStwgNo");
		this.hashFields.put("carrier_cd", "carrierCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tpsz_desc", "cntrTpszDesc");
		this.hashFields.put("old_pod_cd", "oldPodCd");
		this.hashFields.put("old_pod_full_nm", "oldPodFullNm");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("new_pod_cd", "newPodCd");
		this.hashFields.put("pic_eml", "picEml");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return condition
	 */
	public String getCondition() {
		return this.condition;
	}
	
	/**
	 * Column Info
	 * @return newPodFullNm
	 */
	public String getNewPodFullNm() {
		return this.newPodFullNm;
	}
	
	/**
	 * Column Info
	 * @return cntrStwgNo
	 */
	public String getCntrStwgNo() {
		return this.cntrStwgNo;
	}
	
	/**
	 * Column Info
	 * @return carrierCd
	 */
	public String getCarrierCd() {
		return this.carrierCd;
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
	 * @return cntrTpszDesc
	 */
	public String getCntrTpszDesc() {
		return this.cntrTpszDesc;
	}
	
	/**
	 * Column Info
	 * @return oldPodCd
	 */
	public String getOldPodCd() {
		return this.oldPodCd;
	}
	
	/**
	 * Column Info
	 * @return oldPodFullNm
	 */
	public String getOldPodFullNm() {
		return this.oldPodFullNm;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return newPodCd
	 */
	public String getNewPodCd() {
		return this.newPodCd;
	}
	
	/**
	 * Column Info
	 * @return picEml
	 */
	public String getPicEml() {
		return this.picEml;
	}
	

	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	/**
	 * Column Info
	 * @param newPodFullNm
	 */
	public void setNewPodFullNm(String newPodFullNm) {
		this.newPodFullNm = newPodFullNm;
	}
	
	/**
	 * Column Info
	 * @param cntrStwgNo
	 */
	public void setCntrStwgNo(String cntrStwgNo) {
		this.cntrStwgNo = cntrStwgNo;
	}
	
	/**
	 * Column Info
	 * @param carrierCd
	 */
	public void setCarrierCd(String carrierCd) {
		this.carrierCd = carrierCd;
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
	 * @param cntrTpszDesc
	 */
	public void setCntrTpszDesc(String cntrTpszDesc) {
		this.cntrTpszDesc = cntrTpszDesc;
	}
	
	/**
	 * Column Info
	 * @param oldPodCd
	 */
	public void setOldPodCd(String oldPodCd) {
		this.oldPodCd = oldPodCd;
	}
	
	/**
	 * Column Info
	 * @param oldPodFullNm
	 */
	public void setOldPodFullNm(String oldPodFullNm) {
		this.oldPodFullNm = oldPodFullNm;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param newPodCd
	 */
	public void setNewPodCd(String newPodCd) {
		this.newPodCd = newPodCd;
	}
	
	/**
	 * Column Info
	 * @param picEml
	 */
	public void setPicEml(String picEml) {
		this.picEml = picEml;
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
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setCondition(JSPUtil.getParameter(request, prefix + "condition", ""));
		setNewPodFullNm(JSPUtil.getParameter(request, prefix + "new_pod_full_nm", ""));
		setCntrStwgNo(JSPUtil.getParameter(request, prefix + "cntr_stwg_no", ""));
		setCarrierCd(JSPUtil.getParameter(request, prefix + "carrier_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrTpszDesc(JSPUtil.getParameter(request, prefix + "cntr_tpsz_desc", ""));
		setOldPodCd(JSPUtil.getParameter(request, prefix + "old_pod_cd", ""));
		setOldPodFullNm(JSPUtil.getParameter(request, prefix + "old_pod_full_nm", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setNewPodCd(JSPUtil.getParameter(request, prefix + "new_pod_cd", ""));
		setPicEml(JSPUtil.getParameter(request, prefix + "pic_eml", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CODRequestInformationVO[]
	 */
	public CODRequestInformationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CODRequestInformationVO[]
	 */
	public CODRequestInformationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CODRequestInformationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] condition = (JSPUtil.getParameter(request, prefix	+ "condition", length));
			String[] newPodFullNm = (JSPUtil.getParameter(request, prefix	+ "new_pod_full_nm", length));
			String[] cntrStwgNo = (JSPUtil.getParameter(request, prefix	+ "cntr_stwg_no", length));
			String[] carrierCd = (JSPUtil.getParameter(request, prefix	+ "carrier_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTpszDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_desc", length));
			String[] oldPodCd = (JSPUtil.getParameter(request, prefix	+ "old_pod_cd", length));
			String[] oldPodFullNm = (JSPUtil.getParameter(request, prefix	+ "old_pod_full_nm", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] newPodCd = (JSPUtil.getParameter(request, prefix	+ "new_pod_cd", length));
			String[] picEml = (JSPUtil.getParameter(request, prefix	+ "pic_eml", length));
			
			for (int i = 0; i < length; i++) {
				model = new CODRequestInformationVO();
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (condition[i] != null)
					model.setCondition(condition[i]);
				if (newPodFullNm[i] != null)
					model.setNewPodFullNm(newPodFullNm[i]);
				if (cntrStwgNo[i] != null)
					model.setCntrStwgNo(cntrStwgNo[i]);
				if (carrierCd[i] != null)
					model.setCarrierCd(carrierCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTpszDesc[i] != null)
					model.setCntrTpszDesc(cntrTpszDesc[i]);
				if (oldPodCd[i] != null)
					model.setOldPodCd(oldPodCd[i]);
				if (oldPodFullNm[i] != null)
					model.setOldPodFullNm(oldPodFullNm[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (newPodCd[i] != null)
					model.setNewPodCd(newPodCd[i]);
				if (picEml[i] != null)
					model.setPicEml(picEml[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCODRequestInformationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CODRequestInformationVO[]
	 */
	public CODRequestInformationVO[] getCODRequestInformationVOs(){
		CODRequestInformationVO[] vos = (CODRequestInformationVO[])models.toArray(new CODRequestInformationVO[models.size()]);
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
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condition = this.condition .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodFullNm = this.newPodFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStwgNo = this.cntrStwgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.carrierCd = this.carrierCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszDesc = this.cntrTpszDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodCd = this.oldPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodFullNm = this.oldPodFullNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodCd = this.newPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.picEml = this.picEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
