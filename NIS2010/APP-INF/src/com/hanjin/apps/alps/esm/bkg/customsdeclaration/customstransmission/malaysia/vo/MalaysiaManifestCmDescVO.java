/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MalaysiaManifestCmDescVO.java
*@FileTitle : MalaysiaManifestCmDescVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.02
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.08.02 이영헌 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo;

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
 * @author 이영헌
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class MalaysiaManifestCmDescVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MalaysiaManifestCmDescVO> models = new ArrayList<MalaysiaManifestCmDescVO>();
	
	/* Column Info */
	private String cmDesc2 = null;
	/* Column Info */
	private String cmDesc1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmDesc5 = null;
	/* Column Info */
	private String cmDesc4 = null;
	/* Column Info */
	private String cmDesc3 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MalaysiaManifestCmDescVO() {}

	public MalaysiaManifestCmDescVO(String ibflag, String pagerows, String cmDesc1, String cmDesc2, String cmDesc3, String cmDesc4, String cmDesc5) {
		this.cmDesc2 = cmDesc2;
		this.cmDesc1 = cmDesc1;
		this.ibflag = ibflag;
		this.cmDesc5 = cmDesc5;
		this.cmDesc4 = cmDesc4;
		this.cmDesc3 = cmDesc3;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cm_desc2", getCmDesc2());
		this.hashColumns.put("cm_desc1", getCmDesc1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cm_desc5", getCmDesc5());
		this.hashColumns.put("cm_desc4", getCmDesc4());
		this.hashColumns.put("cm_desc3", getCmDesc3());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cm_desc2", "cmDesc2");
		this.hashFields.put("cm_desc1", "cmDesc1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cm_desc5", "cmDesc5");
		this.hashFields.put("cm_desc4", "cmDesc4");
		this.hashFields.put("cm_desc3", "cmDesc3");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cmDesc2
	 */
	public String getCmDesc2() {
		return this.cmDesc2;
	}
	
	/**
	 * Column Info
	 * @return cmDesc1
	 */
	public String getCmDesc1() {
		return this.cmDesc1;
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
	 * @return cmDesc5
	 */
	public String getCmDesc5() {
		return this.cmDesc5;
	}
	
	/**
	 * Column Info
	 * @return cmDesc4
	 */
	public String getCmDesc4() {
		return this.cmDesc4;
	}
	
	/**
	 * Column Info
	 * @return cmDesc3
	 */
	public String getCmDesc3() {
		return this.cmDesc3;
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
	 * @param cmDesc2
	 */
	public void setCmDesc2(String cmDesc2) {
		this.cmDesc2 = cmDesc2;
	}
	
	/**
	 * Column Info
	 * @param cmDesc1
	 */
	public void setCmDesc1(String cmDesc1) {
		this.cmDesc1 = cmDesc1;
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
	 * @param cmDesc5
	 */
	public void setCmDesc5(String cmDesc5) {
		this.cmDesc5 = cmDesc5;
	}
	
	/**
	 * Column Info
	 * @param cmDesc4
	 */
	public void setCmDesc4(String cmDesc4) {
		this.cmDesc4 = cmDesc4;
	}
	
	/**
	 * Column Info
	 * @param cmDesc3
	 */
	public void setCmDesc3(String cmDesc3) {
		this.cmDesc3 = cmDesc3;
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
		setCmDesc2(JSPUtil.getParameter(request, prefix + "cm_desc2", ""));
		setCmDesc1(JSPUtil.getParameter(request, prefix + "cm_desc1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmDesc5(JSPUtil.getParameter(request, prefix + "cm_desc5", ""));
		setCmDesc4(JSPUtil.getParameter(request, prefix + "cm_desc4", ""));
		setCmDesc3(JSPUtil.getParameter(request, prefix + "cm_desc3", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MalaysiaManifestCmDescVO[]
	 */
	public MalaysiaManifestCmDescVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MalaysiaManifestCmDescVO[]
	 */
	public MalaysiaManifestCmDescVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MalaysiaManifestCmDescVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cmDesc2 = (JSPUtil.getParameter(request, prefix	+ "cm_desc2", length));
			String[] cmDesc1 = (JSPUtil.getParameter(request, prefix	+ "cm_desc1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmDesc5 = (JSPUtil.getParameter(request, prefix	+ "cm_desc5", length));
			String[] cmDesc4 = (JSPUtil.getParameter(request, prefix	+ "cm_desc4", length));
			String[] cmDesc3 = (JSPUtil.getParameter(request, prefix	+ "cm_desc3", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MalaysiaManifestCmDescVO();
				if (cmDesc2[i] != null)
					model.setCmDesc2(cmDesc2[i]);
				if (cmDesc1[i] != null)
					model.setCmDesc1(cmDesc1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmDesc5[i] != null)
					model.setCmDesc5(cmDesc5[i]);
				if (cmDesc4[i] != null)
					model.setCmDesc4(cmDesc4[i]);
				if (cmDesc3[i] != null)
					model.setCmDesc3(cmDesc3[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMalaysiaManifestCmDescVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MalaysiaManifestCmDescVO[]
	 */
	public MalaysiaManifestCmDescVO[] getMalaysiaManifestCmDescVOs(){
		MalaysiaManifestCmDescVO[] vos = (MalaysiaManifestCmDescVO[])models.toArray(new MalaysiaManifestCmDescVO[models.size()]);
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
		this.cmDesc2 = this.cmDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmDesc1 = this.cmDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmDesc5 = this.cmDesc5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmDesc4 = this.cmDesc4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmDesc3 = this.cmDesc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
