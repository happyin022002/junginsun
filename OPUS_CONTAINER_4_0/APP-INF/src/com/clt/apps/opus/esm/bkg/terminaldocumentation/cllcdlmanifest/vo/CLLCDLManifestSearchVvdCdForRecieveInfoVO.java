/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CLLCDLManifestSearchVvdCdForRecieveInfoVO.java
*@FileTitle : CLLCDLManifestSearchVvdCdForRecieveInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier :
*@LastVersion : 1.0
* 2009.10.21
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CLLCDLManifestSearchVvdCdForRecieveInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CLLCDLManifestSearchVvdCdForRecieveInfoVO> models = new ArrayList<CLLCDLManifestSearchVvdCdForRecieveInfoVO>();

	/* Column Info */
	private String inVslvoy = null;
	/* Column Info */
	private String inVslcd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inVsldir = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public CLLCDLManifestSearchVvdCdForRecieveInfoVO() {}

	public CLLCDLManifestSearchVvdCdForRecieveInfoVO(String ibflag, String pagerows, String inVslcd, String inVslvoy, String inVsldir) {
		this.inVslvoy = inVslvoy;
		this.inVslcd = inVslcd;
		this.ibflag = ibflag;
		this.inVsldir = inVsldir;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("in_vslvoy", getInVslvoy());
		this.hashColumns.put("in_vslcd", getInVslcd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_vsldir", getInVsldir());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("in_vslvoy", "inVslvoy");
		this.hashFields.put("in_vslcd", "inVslcd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_vsldir", "inVsldir");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return inVslvoy
	 */
	public String getInVslvoy() {
		return this.inVslvoy;
	}

	/**
	 * Column Info
	 * @return inVslcd
	 */
	public String getInVslcd() {
		return this.inVslcd;
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
	 * @return inVsldir
	 */
	public String getInVsldir() {
		return this.inVsldir;
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
	 * @param inVslvoy
	 */
	public void setInVslvoy(String inVslvoy) {
		this.inVslvoy = inVslvoy;
	}

	/**
	 * Column Info
	 * @param inVslcd
	 */
	public void setInVslcd(String inVslcd) {
		this.inVslcd = inVslcd;
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
	 * @param inVsldir
	 */
	public void setInVsldir(String inVsldir) {
		this.inVsldir = inVsldir;
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
		setInVslvoy(JSPUtil.getParameter(request, "in_vslvoy", ""));
		setInVslcd(JSPUtil.getParameter(request, "in_vslcd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInVsldir(JSPUtil.getParameter(request, "in_vsldir", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CLLCDLManifestSearchVvdCdForRecieveInfoVO[]
	 */
	public CLLCDLManifestSearchVvdCdForRecieveInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CLLCDLManifestSearchVvdCdForRecieveInfoVO[]
	 */
	public CLLCDLManifestSearchVvdCdForRecieveInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CLLCDLManifestSearchVvdCdForRecieveInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] inVslvoy = (JSPUtil.getParameter(request, prefix	+ "in_vslvoy", length));
			String[] inVslcd = (JSPUtil.getParameter(request, prefix	+ "in_vslcd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inVsldir = (JSPUtil.getParameter(request, prefix	+ "in_vsldir", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new CLLCDLManifestSearchVvdCdForRecieveInfoVO();
				if (inVslvoy[i] != null)
					model.setInVslvoy(inVslvoy[i]);
				if (inVslcd[i] != null)
					model.setInVslcd(inVslcd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inVsldir[i] != null)
					model.setInVsldir(inVsldir[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCLLCDLManifestSearchVvdCdForRecieveInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CLLCDLManifestSearchVvdCdForRecieveInfoVO[]
	 */
	public CLLCDLManifestSearchVvdCdForRecieveInfoVO[] getCLLCDLManifestSearchVvdCdForRecieveInfoVOs(){
		CLLCDLManifestSearchVvdCdForRecieveInfoVO[] vos = (CLLCDLManifestSearchVvdCdForRecieveInfoVO[])models.toArray(new CLLCDLManifestSearchVvdCdForRecieveInfoVO[models.size()]);
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
		this.inVslvoy = this.inVslvoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslcd = this.inVslcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVsldir = this.inVsldir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
