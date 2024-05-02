/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MalaysiaManifestCmInfoVO.java
*@FileTitle : MalaysiaManifestCmInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.08.02 이영헌 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo;

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
 * @author 이영헌
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class MalaysiaManifestCmInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MalaysiaManifestCmInfoVO> models = new ArrayList<MalaysiaManifestCmInfoVO>();
	
	/* Column Info */
	private String cmMea = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmPkgUnit = null;
	/* Column Info */
	private String cmSeq = null;
	/* Column Info */
	private String hsCode = null;
	/* Column Info */
	private String cmMeaUnit = null;
	/* Column Info */
	private String cmWgtUnit = null;
	/* Column Info */
	private String cmWgt = null;
	/* Column Info */
	private String cmPkg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MalaysiaManifestCmInfoVO() {}

	public MalaysiaManifestCmInfoVO(String ibflag, String pagerows, String cmSeq, String cmPkg, String cmPkgUnit, String cmWgt, String cmWgtUnit, String cmMea, String cmMeaUnit, String hsCode) {
		this.cmMea = cmMea;
		this.ibflag = ibflag;
		this.cmPkgUnit = cmPkgUnit;
		this.cmSeq = cmSeq;
		this.hsCode = hsCode;
		this.cmMeaUnit = cmMeaUnit;
		this.cmWgtUnit = cmWgtUnit;
		this.cmWgt = cmWgt;
		this.cmPkg = cmPkg;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cm_mea", getCmMea());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cm_pkg_unit", getCmPkgUnit());
		this.hashColumns.put("cm_seq", getCmSeq());
		this.hashColumns.put("hs_code", getHsCode());
		this.hashColumns.put("cm_mea_unit", getCmMeaUnit());
		this.hashColumns.put("cm_wgt_unit", getCmWgtUnit());
		this.hashColumns.put("cm_wgt", getCmWgt());
		this.hashColumns.put("cm_pkg", getCmPkg());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cm_mea", "cmMea");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cm_pkg_unit", "cmPkgUnit");
		this.hashFields.put("cm_seq", "cmSeq");
		this.hashFields.put("hs_code", "hsCode");
		this.hashFields.put("cm_mea_unit", "cmMeaUnit");
		this.hashFields.put("cm_wgt_unit", "cmWgtUnit");
		this.hashFields.put("cm_wgt", "cmWgt");
		this.hashFields.put("cm_pkg", "cmPkg");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cmMea
	 */
	public String getCmMea() {
		return this.cmMea;
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
	 * @return cmPkgUnit
	 */
	public String getCmPkgUnit() {
		return this.cmPkgUnit;
	}
	
	/**
	 * Column Info
	 * @return cmSeq
	 */
	public String getCmSeq() {
		return this.cmSeq;
	}
	
	/**
	 * Column Info
	 * @return hsCode
	 */
	public String getHsCode() {
		return this.hsCode;
	}
	
	/**
	 * Column Info
	 * @return cmMeaUnit
	 */
	public String getCmMeaUnit() {
		return this.cmMeaUnit;
	}
	
	/**
	 * Column Info
	 * @return cmWgtUnit
	 */
	public String getCmWgtUnit() {
		return this.cmWgtUnit;
	}
	
	/**
	 * Column Info
	 * @return cmWgt
	 */
	public String getCmWgt() {
		return this.cmWgt;
	}
	
	/**
	 * Column Info
	 * @return cmPkg
	 */
	public String getCmPkg() {
		return this.cmPkg;
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
	 * @param cmMea
	 */
	public void setCmMea(String cmMea) {
		this.cmMea = cmMea;
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
	 * @param cmPkgUnit
	 */
	public void setCmPkgUnit(String cmPkgUnit) {
		this.cmPkgUnit = cmPkgUnit;
	}
	
	/**
	 * Column Info
	 * @param cmSeq
	 */
	public void setCmSeq(String cmSeq) {
		this.cmSeq = cmSeq;
	}
	
	/**
	 * Column Info
	 * @param hsCode
	 */
	public void setHsCode(String hsCode) {
		this.hsCode = hsCode;
	}
	
	/**
	 * Column Info
	 * @param cmMeaUnit
	 */
	public void setCmMeaUnit(String cmMeaUnit) {
		this.cmMeaUnit = cmMeaUnit;
	}
	
	/**
	 * Column Info
	 * @param cmWgtUnit
	 */
	public void setCmWgtUnit(String cmWgtUnit) {
		this.cmWgtUnit = cmWgtUnit;
	}
	
	/**
	 * Column Info
	 * @param cmWgt
	 */
	public void setCmWgt(String cmWgt) {
		this.cmWgt = cmWgt;
	}
	
	/**
	 * Column Info
	 * @param cmPkg
	 */
	public void setCmPkg(String cmPkg) {
		this.cmPkg = cmPkg;
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
		setCmMea(JSPUtil.getParameter(request, prefix + "cm_mea", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmPkgUnit(JSPUtil.getParameter(request, prefix + "cm_pkg_unit", ""));
		setCmSeq(JSPUtil.getParameter(request, prefix + "cm_seq", ""));
		setHsCode(JSPUtil.getParameter(request, prefix + "hs_code", ""));
		setCmMeaUnit(JSPUtil.getParameter(request, prefix + "cm_mea_unit", ""));
		setCmWgtUnit(JSPUtil.getParameter(request, prefix + "cm_wgt_unit", ""));
		setCmWgt(JSPUtil.getParameter(request, prefix + "cm_wgt", ""));
		setCmPkg(JSPUtil.getParameter(request, prefix + "cm_pkg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MalaysiaManifestCmInfoVO[]
	 */
	public MalaysiaManifestCmInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MalaysiaManifestCmInfoVO[]
	 */
	public MalaysiaManifestCmInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MalaysiaManifestCmInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cmMea = (JSPUtil.getParameter(request, prefix	+ "cm_mea", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmPkgUnit = (JSPUtil.getParameter(request, prefix	+ "cm_pkg_unit", length));
			String[] cmSeq = (JSPUtil.getParameter(request, prefix	+ "cm_seq", length));
			String[] hsCode = (JSPUtil.getParameter(request, prefix	+ "hs_code", length));
			String[] cmMeaUnit = (JSPUtil.getParameter(request, prefix	+ "cm_mea_unit", length));
			String[] cmWgtUnit = (JSPUtil.getParameter(request, prefix	+ "cm_wgt_unit", length));
			String[] cmWgt = (JSPUtil.getParameter(request, prefix	+ "cm_wgt", length));
			String[] cmPkg = (JSPUtil.getParameter(request, prefix	+ "cm_pkg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MalaysiaManifestCmInfoVO();
				if (cmMea[i] != null)
					model.setCmMea(cmMea[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmPkgUnit[i] != null)
					model.setCmPkgUnit(cmPkgUnit[i]);
				if (cmSeq[i] != null)
					model.setCmSeq(cmSeq[i]);
				if (hsCode[i] != null)
					model.setHsCode(hsCode[i]);
				if (cmMeaUnit[i] != null)
					model.setCmMeaUnit(cmMeaUnit[i]);
				if (cmWgtUnit[i] != null)
					model.setCmWgtUnit(cmWgtUnit[i]);
				if (cmWgt[i] != null)
					model.setCmWgt(cmWgt[i]);
				if (cmPkg[i] != null)
					model.setCmPkg(cmPkg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMalaysiaManifestCmInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MalaysiaManifestCmInfoVO[]
	 */
	public MalaysiaManifestCmInfoVO[] getMalaysiaManifestCmInfoVOs(){
		MalaysiaManifestCmInfoVO[] vos = (MalaysiaManifestCmInfoVO[])models.toArray(new MalaysiaManifestCmInfoVO[models.size()]);
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
		this.cmMea = this.cmMea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPkgUnit = this.cmPkgUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmSeq = this.cmSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hsCode = this.hsCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmMeaUnit = this.cmMeaUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmWgtUnit = this.cmWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmWgt = this.cmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmPkg = this.cmPkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
