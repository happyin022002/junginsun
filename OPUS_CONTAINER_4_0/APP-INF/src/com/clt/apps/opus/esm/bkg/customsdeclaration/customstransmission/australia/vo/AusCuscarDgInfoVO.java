/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusCuscarDgInfoVO.java
*@FileTitle : AusCuscarDgInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.13  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AusCuscarDgInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AusCuscarDgInfoVO> models = new ArrayList<AusCuscarDgInfoVO>();
	
	/* Column Info */
	private String mfag = null;
	/* Column Info */
	private String flashPoint = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tremCardNo = null;
	/* Column Info */
	private String imdgPckGrpCd = null;
	/* Column Info */
	private String hazardCd = null;
	/* Column Info */
	private String imoPageNo = null;
	/* Column Info */
	private String emsNo = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String flashPointUnit = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AusCuscarDgInfoVO() {}

	public AusCuscarDgInfoVO(String ibflag, String pagerows, String imdgClssCd, String imoPageNo, String hazardCd, String imdgUnNo, String flashPoint, String flashPointUnit, String imdgPckGrpCd, String emsNo, String mfag, String tremCardNo) {
		this.mfag = mfag;
		this.flashPoint = flashPoint;
		this.ibflag = ibflag;
		this.tremCardNo = tremCardNo;
		this.imdgPckGrpCd = imdgPckGrpCd;
		this.hazardCd = hazardCd;
		this.imoPageNo = imoPageNo;
		this.emsNo = emsNo;
		this.imdgUnNo = imdgUnNo;
		this.imdgClssCd = imdgClssCd;
		this.flashPointUnit = flashPointUnit;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mfag", getMfag());
		this.hashColumns.put("flash_point", getFlashPoint());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trem_card_no", getTremCardNo());
		this.hashColumns.put("imdg_pck_grp_cd", getImdgPckGrpCd());
		this.hashColumns.put("hazard_cd", getHazardCd());
		this.hashColumns.put("imo_page_no", getImoPageNo());
		this.hashColumns.put("ems_no", getEmsNo());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("flash_point_unit", getFlashPointUnit());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mfag", "mfag");
		this.hashFields.put("flash_point", "flashPoint");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trem_card_no", "tremCardNo");
		this.hashFields.put("imdg_pck_grp_cd", "imdgPckGrpCd");
		this.hashFields.put("hazard_cd", "hazardCd");
		this.hashFields.put("imo_page_no", "imoPageNo");
		this.hashFields.put("ems_no", "emsNo");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("flash_point_unit", "flashPointUnit");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mfag
	 */
	public String getMfag() {
		return this.mfag;
	}
	
	/**
	 * Column Info
	 * @return flashPoint
	 */
	public String getFlashPoint() {
		return this.flashPoint;
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
	 * @return tremCardNo
	 */
	public String getTremCardNo() {
		return this.tremCardNo;
	}
	
	/**
	 * Column Info
	 * @return imdgPckGrpCd
	 */
	public String getImdgPckGrpCd() {
		return this.imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @return hazardCd
	 */
	public String getHazardCd() {
		return this.hazardCd;
	}
	
	/**
	 * Column Info
	 * @return imoPageNo
	 */
	public String getImoPageNo() {
		return this.imoPageNo;
	}
	
	/**
	 * Column Info
	 * @return emsNo
	 */
	public String getEmsNo() {
		return this.emsNo;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return flashPointUnit
	 */
	public String getFlashPointUnit() {
		return this.flashPointUnit;
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
	 * @param mfag
	 */
	public void setMfag(String mfag) {
		this.mfag = mfag;
	}
	
	/**
	 * Column Info
	 * @param flashPoint
	 */
	public void setFlashPoint(String flashPoint) {
		this.flashPoint = flashPoint;
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
	 * @param tremCardNo
	 */
	public void setTremCardNo(String tremCardNo) {
		this.tremCardNo = tremCardNo;
	}
	
	/**
	 * Column Info
	 * @param imdgPckGrpCd
	 */
	public void setImdgPckGrpCd(String imdgPckGrpCd) {
		this.imdgPckGrpCd = imdgPckGrpCd;
	}
	
	/**
	 * Column Info
	 * @param hazardCd
	 */
	public void setHazardCd(String hazardCd) {
		this.hazardCd = hazardCd;
	}
	
	/**
	 * Column Info
	 * @param imoPageNo
	 */
	public void setImoPageNo(String imoPageNo) {
		this.imoPageNo = imoPageNo;
	}
	
	/**
	 * Column Info
	 * @param emsNo
	 */
	public void setEmsNo(String emsNo) {
		this.emsNo = emsNo;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param flashPointUnit
	 */
	public void setFlashPointUnit(String flashPointUnit) {
		this.flashPointUnit = flashPointUnit;
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
		setMfag(JSPUtil.getParameter(request, prefix + "mfag", ""));
		setFlashPoint(JSPUtil.getParameter(request, prefix + "flash_point", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTremCardNo(JSPUtil.getParameter(request, prefix + "trem_card_no", ""));
		setImdgPckGrpCd(JSPUtil.getParameter(request, prefix + "imdg_pck_grp_cd", ""));
		setHazardCd(JSPUtil.getParameter(request, prefix + "hazard_cd", ""));
		setImoPageNo(JSPUtil.getParameter(request, prefix + "imo_page_no", ""));
		setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setFlashPointUnit(JSPUtil.getParameter(request, prefix + "flash_point_unit", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AusCuscarDgInfoVO[]
	 */
	public AusCuscarDgInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AusCuscarDgInfoVO[]
	 */
	public AusCuscarDgInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AusCuscarDgInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mfag = (JSPUtil.getParameter(request, prefix	+ "mfag", length));
			String[] flashPoint = (JSPUtil.getParameter(request, prefix	+ "flash_point", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tremCardNo = (JSPUtil.getParameter(request, prefix	+ "trem_card_no", length));
			String[] imdgPckGrpCd = (JSPUtil.getParameter(request, prefix	+ "imdg_pck_grp_cd", length));
			String[] hazardCd = (JSPUtil.getParameter(request, prefix	+ "hazard_cd", length));
			String[] imoPageNo = (JSPUtil.getParameter(request, prefix	+ "imo_page_no", length));
			String[] emsNo = (JSPUtil.getParameter(request, prefix	+ "ems_no", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] flashPointUnit = (JSPUtil.getParameter(request, prefix	+ "flash_point_unit", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AusCuscarDgInfoVO();
				if (mfag[i] != null)
					model.setMfag(mfag[i]);
				if (flashPoint[i] != null)
					model.setFlashPoint(flashPoint[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tremCardNo[i] != null)
					model.setTremCardNo(tremCardNo[i]);
				if (imdgPckGrpCd[i] != null)
					model.setImdgPckGrpCd(imdgPckGrpCd[i]);
				if (hazardCd[i] != null)
					model.setHazardCd(hazardCd[i]);
				if (imoPageNo[i] != null)
					model.setImoPageNo(imoPageNo[i]);
				if (emsNo[i] != null)
					model.setEmsNo(emsNo[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (flashPointUnit[i] != null)
					model.setFlashPointUnit(flashPointUnit[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAusCuscarDgInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AusCuscarDgInfoVO[]
	 */
	public AusCuscarDgInfoVO[] getAusCuscarDgInfoVOs(){
		AusCuscarDgInfoVO[] vos = (AusCuscarDgInfoVO[])models.toArray(new AusCuscarDgInfoVO[models.size()]);
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
		this.mfag = this.mfag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flashPoint = this.flashPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tremCardNo = this.tremCardNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgPckGrpCd = this.imdgPckGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hazardCd = this.hazardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoPageNo = this.imoPageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsNo = this.emsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flashPointUnit = this.flashPointUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
