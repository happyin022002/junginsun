/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MalaysiaManifestCntrSealNoInfoVO.java
*@FileTitle : MalaysiaManifestCntrSealNoInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.28  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.vo;

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

public class MalaysiaManifestCntrSealNoInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MalaysiaManifestCntrSealNoInfoVO> models = new ArrayList<MalaysiaManifestCntrSealNoInfoVO>();
	
	/* Column Info */
	private String sealNbr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sealType = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MalaysiaManifestCntrSealNoInfoVO() {}

	public MalaysiaManifestCntrSealNoInfoVO(String ibflag, String pagerows, String sealType, String sealNbr) {
		this.sealNbr = sealNbr;
		this.ibflag = ibflag;
		this.sealType = sealType;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("seal_nbr", getSealNbr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("seal_type", getSealType());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("seal_nbr", "sealNbr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("seal_type", "sealType");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sealNbr
	 */
	public String getSealNbr() {
		return this.sealNbr;
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
	 * @return sealType
	 */
	public String getSealType() {
		return this.sealType;
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
	 * @param sealNbr
	 */
	public void setSealNbr(String sealNbr) {
		this.sealNbr = sealNbr;
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
	 * @param sealType
	 */
	public void setSealType(String sealType) {
		this.sealType = sealType;
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
		setSealNbr(JSPUtil.getParameter(request, prefix + "seal_nbr", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSealType(JSPUtil.getParameter(request, prefix + "seal_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MalaysiaManifestCntrSealNoInfoVO[]
	 */
	public MalaysiaManifestCntrSealNoInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MalaysiaManifestCntrSealNoInfoVO[]
	 */
	public MalaysiaManifestCntrSealNoInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MalaysiaManifestCntrSealNoInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sealNbr = (JSPUtil.getParameter(request, prefix	+ "seal_nbr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sealType = (JSPUtil.getParameter(request, prefix	+ "seal_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MalaysiaManifestCntrSealNoInfoVO();
				if (sealNbr[i] != null)
					model.setSealNbr(sealNbr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sealType[i] != null)
					model.setSealType(sealType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMalaysiaManifestCntrSealNoInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MalaysiaManifestCntrSealNoInfoVO[]
	 */
	public MalaysiaManifestCntrSealNoInfoVO[] getMalaysiaManifestCntrSealNoInfoVOs(){
		MalaysiaManifestCntrSealNoInfoVO[] vos = (MalaysiaManifestCntrSealNoInfoVO[])models.toArray(new MalaysiaManifestCntrSealNoInfoVO[models.size()]);
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
		this.sealNbr = this.sealNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealType = this.sealType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
