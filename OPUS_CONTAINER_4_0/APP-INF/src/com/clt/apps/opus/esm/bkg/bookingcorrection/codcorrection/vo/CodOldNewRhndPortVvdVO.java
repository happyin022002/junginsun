/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CodOldNewRhndPortVvdVO.java
*@FileTitle : CodOldNewRhndPortVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.07
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.07 류대영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CodOldNewRhndPortVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CodOldNewRhndPortVvdVO> models = new ArrayList<CodOldNewRhndPortVvdVO>();
	
	/* Column Info */
	private String codRhndPortYdCd = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oldPodYdCd = null;
	/* Column Info */
	private String newPodYdCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CodOldNewRhndPortVvdVO() {}

	public CodOldNewRhndPortVvdVO(String ibflag, String pagerows, String vvd, String newPodYdCd, String oldPodYdCd, String codRhndPortYdCd) {
		this.codRhndPortYdCd = codRhndPortYdCd;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.oldPodYdCd = oldPodYdCd;
		this.newPodYdCd = newPodYdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cod_rhnd_port_yd_cd", getCodRhndPortYdCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("old_pod_yd_cd", getOldPodYdCd());
		this.hashColumns.put("new_pod_yd_cd", getNewPodYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cod_rhnd_port_yd_cd", "codRhndPortYdCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("old_pod_yd_cd", "oldPodYdCd");
		this.hashFields.put("new_pod_yd_cd", "newPodYdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return codRhndPortYdCd
	 */
	public String getCodRhndPortYdCd() {
		return this.codRhndPortYdCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return oldPodYdCd
	 */
	public String getOldPodYdCd() {
		return this.oldPodYdCd;
	}
	
	/**
	 * Column Info
	 * @return newPodYdCd
	 */
	public String getNewPodYdCd() {
		return this.newPodYdCd;
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
	 * @param codRhndPortYdCd
	 */
	public void setCodRhndPortYdCd(String codRhndPortYdCd) {
		this.codRhndPortYdCd = codRhndPortYdCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param oldPodYdCd
	 */
	public void setOldPodYdCd(String oldPodYdCd) {
		this.oldPodYdCd = oldPodYdCd;
	}
	
	/**
	 * Column Info
	 * @param newPodYdCd
	 */
	public void setNewPodYdCd(String newPodYdCd) {
		this.newPodYdCd = newPodYdCd;
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
		setCodRhndPortYdCd(JSPUtil.getParameter(request, prefix + "cod_rhnd_port_yd_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOldPodYdCd(JSPUtil.getParameter(request, prefix + "old_pod_yd_cd", ""));
		setNewPodYdCd(JSPUtil.getParameter(request, prefix + "new_pod_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CodOldNewRhndPortVvdVO[]
	 */
	public CodOldNewRhndPortVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CodOldNewRhndPortVvdVO[]
	 */
	public CodOldNewRhndPortVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CodOldNewRhndPortVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] codRhndPortYdCd = (JSPUtil.getParameter(request, prefix	+ "cod_rhnd_port_yd_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oldPodYdCd = (JSPUtil.getParameter(request, prefix	+ "old_pod_yd_cd", length));
			String[] newPodYdCd = (JSPUtil.getParameter(request, prefix	+ "new_pod_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CodOldNewRhndPortVvdVO();
				if (codRhndPortYdCd[i] != null)
					model.setCodRhndPortYdCd(codRhndPortYdCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oldPodYdCd[i] != null)
					model.setOldPodYdCd(oldPodYdCd[i]);
				if (newPodYdCd[i] != null)
					model.setNewPodYdCd(newPodYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCodOldNewRhndPortVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CodOldNewRhndPortVvdVO[]
	 */
	public CodOldNewRhndPortVvdVO[] getCodOldNewRhndPortVvdVOs(){
		CodOldNewRhndPortVvdVO[] vos = (CodOldNewRhndPortVvdVO[])models.toArray(new CodOldNewRhndPortVvdVO[models.size()]);
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
		this.codRhndPortYdCd = this.codRhndPortYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodYdCd = this.oldPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPodYdCd = this.newPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
