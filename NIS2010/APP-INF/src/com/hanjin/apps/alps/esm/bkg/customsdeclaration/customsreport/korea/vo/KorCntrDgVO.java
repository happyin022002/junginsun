/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCntrDgVO.java
*@FileTitle : KorCntrDgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.18
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.11.18 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorCntrDgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorCntrDgVO> models = new ArrayList<KorCntrDgVO>();
	
	/* Column Info */
	private String cntrInfo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dgClss = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorCntrDgVO() {}

	public KorCntrDgVO(String ibflag, String pagerows, String cntrInfo, String dgClss) {
		this.cntrInfo = cntrInfo;
		this.ibflag = ibflag;
		this.dgClss = dgClss;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_info", getCntrInfo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dg_clss", getDgClss());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_info", "cntrInfo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dg_clss", "dgClss");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrInfo
	 */
	public String getCntrInfo() {
		return this.cntrInfo;
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
	 * @return dgClss
	 */
	public String getDgClss() {
		return this.dgClss;
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
	 * @param cntrInfo
	 */
	public void setCntrInfo(String cntrInfo) {
		this.cntrInfo = cntrInfo;
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
	 * @param dgClss
	 */
	public void setDgClss(String dgClss) {
		this.dgClss = dgClss;
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
		setCntrInfo(JSPUtil.getParameter(request, "cntr_info", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDgClss(JSPUtil.getParameter(request, "dg_clss", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorCntrDgVO[]
	 */
	public KorCntrDgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorCntrDgVO[]
	 */
	public KorCntrDgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorCntrDgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrInfo = (JSPUtil.getParameter(request, prefix	+ "cntr_info", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dgClss = (JSPUtil.getParameter(request, prefix	+ "dg_clss", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorCntrDgVO();
				if (cntrInfo[i] != null)
					model.setCntrInfo(cntrInfo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dgClss[i] != null)
					model.setDgClss(dgClss[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorCntrDgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorCntrDgVO[]
	 */
	public KorCntrDgVO[] getKorCntrDgVOs(){
		KorCntrDgVO[] vos = (KorCntrDgVO[])models.toArray(new KorCntrDgVO[models.size()]);
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
		this.cntrInfo = this.cntrInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgClss = this.dgClss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
