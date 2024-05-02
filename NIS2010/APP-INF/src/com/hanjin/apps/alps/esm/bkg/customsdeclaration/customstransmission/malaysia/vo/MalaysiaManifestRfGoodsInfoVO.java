/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MalaysiaManifestRfGoodsInfoVO.java
*@FileTitle : MalaysiaManifestRfGoodsInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class MalaysiaManifestRfGoodsInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MalaysiaManifestRfGoodsInfoVO> models = new ArrayList<MalaysiaManifestRfGoodsInfoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrTmp = null;
	/* Column Info */
	private String cntrTmpUnit = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MalaysiaManifestRfGoodsInfoVO() {}

	public MalaysiaManifestRfGoodsInfoVO(String ibflag, String pagerows, String cntrTmp, String cntrTmpUnit) {
		this.ibflag = ibflag;
		this.cntrTmp = cntrTmp;
		this.cntrTmpUnit = cntrTmpUnit;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_tmp", getCntrTmp());
		this.hashColumns.put("cntr_tmp_unit", getCntrTmpUnit());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_tmp", "cntrTmp");
		this.hashFields.put("cntr_tmp_unit", "cntrTmpUnit");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return cntrTmp
	 */
	public String getCntrTmp() {
		return this.cntrTmp;
	}
	
	/**
	 * Column Info
	 * @return cntrTmpUnit
	 */
	public String getCntrTmpUnit() {
		return this.cntrTmpUnit;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param cntrTmp
	 */
	public void setCntrTmp(String cntrTmp) {
		this.cntrTmp = cntrTmp;
	}
	
	/**
	 * Column Info
	 * @param cntrTmpUnit
	 */
	public void setCntrTmpUnit(String cntrTmpUnit) {
		this.cntrTmpUnit = cntrTmpUnit;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrTmp(JSPUtil.getParameter(request, prefix + "cntr_tmp", ""));
		setCntrTmpUnit(JSPUtil.getParameter(request, prefix + "cntr_tmp_unit", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MalaysiaManifestRfGoodsInfoVO[]
	 */
	public MalaysiaManifestRfGoodsInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MalaysiaManifestRfGoodsInfoVO[]
	 */
	public MalaysiaManifestRfGoodsInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MalaysiaManifestRfGoodsInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrTmp = (JSPUtil.getParameter(request, prefix	+ "cntr_tmp", length));
			String[] cntrTmpUnit = (JSPUtil.getParameter(request, prefix	+ "cntr_tmp_unit", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MalaysiaManifestRfGoodsInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrTmp[i] != null)
					model.setCntrTmp(cntrTmp[i]);
				if (cntrTmpUnit[i] != null)
					model.setCntrTmpUnit(cntrTmpUnit[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMalaysiaManifestRfGoodsInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MalaysiaManifestRfGoodsInfoVO[]
	 */
	public MalaysiaManifestRfGoodsInfoVO[] getMalaysiaManifestRfGoodsInfoVOs(){
		MalaysiaManifestRfGoodsInfoVO[] vos = (MalaysiaManifestRfGoodsInfoVO[])models.toArray(new MalaysiaManifestRfGoodsInfoVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTmp = this.cntrTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTmpUnit = this.cntrTmpUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
