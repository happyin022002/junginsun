/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQYARDManageConditionVO.java
*@FileTitle : EQYARDManageConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.31 신한성 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.common.popup.vo;

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
 * @author 신한성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EQYARDManageConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EQYARDManageConditionVO> models = new ArrayList<EQYARDManageConditionVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rccTxt = null;
	/* Column Info */
	private String lccTxt = null;
	/* Column Info */
	private String eccTxt = null;
	/* Column Info */
	private String cntTxt = null;
	/* Column Info */
	private String dist = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EQYARDManageConditionVO() {}

	public EQYARDManageConditionVO(String ibflag, String pagerows, String dist, String rccTxt, String eccTxt, String cntTxt, String lccTxt) {
		this.ibflag = ibflag;
		this.rccTxt = rccTxt;
		this.lccTxt = lccTxt;
		this.lccTxt = eccTxt;
		this.cntTxt = cntTxt;
		this.dist = dist;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcc_txt", getRccTxt());
		this.hashColumns.put("lcc_txt", getLccTxt());
		this.hashColumns.put("ecc_txt", getEccTxt());
		this.hashColumns.put("cnt_txt", getCntTxt());
		this.hashColumns.put("dist", getDist());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcc_txt", "rccTxt");
		this.hashFields.put("lcc_txt", "lccTxt");
		this.hashFields.put("ecc_txt", "eccTxt");
		this.hashFields.put("cnt_txt", "cntTxt");
		this.hashFields.put("dist", "dist");
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
	 * @return rccTxt
	 */
	public String getRccTxt() {
		return this.rccTxt;
	}
	
	/**
	 * Column Info
	 * @return lccTxt
	 */
	public String getLccTxt() {
		return this.lccTxt;
	}
	
	/**
	 * Column Info
	 * @return eccTxt
	 */
	public String getEccTxt() {
		return this.eccTxt;
	}
	
	/**
	 * Column Info
	 * @return cntTxt
	 */
	public String getCntTxt() {
		return this.cntTxt;
	}
	
	/**
	 * Column Info
	 * @return dist
	 */
	public String getDist() {
		return this.dist;
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
	 * @param rccTxt
	 */
	public void setRccTxt(String rccTxt) {
		this.rccTxt = rccTxt;
	}
	
	/**
	 * Column Info
	 * @param lccTxt
	 */
	public void setLccTxt(String lccTxt) {
		this.lccTxt = lccTxt;
	}
	
	/**
	 * Column Info
	 * @param eccTxt
	 */
	public void setEccTxt(String eccTxt) {
		this.eccTxt = eccTxt;
	}
	
	/**
	 * Column Info
	 * @param cntTxt
	 */
	public void setCntTxt(String cntTxt) {
		this.cntTxt = cntTxt;
	}
	
	/**
	 * Column Info
	 * @param dist
	 */
	public void setDist(String dist) {
		this.dist = dist;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRccTxt(JSPUtil.getParameter(request, "rcc_txt", ""));
		setLccTxt(JSPUtil.getParameter(request, "lcc_txt", ""));
		setEccTxt(JSPUtil.getParameter(request, "ecc_txt", ""));
		setCntTxt(JSPUtil.getParameter(request, "cnt_txt", ""));
		setDist(JSPUtil.getParameter(request, "dist", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EQYARDManageConditionVO[]
	 */
	public EQYARDManageConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EQYARDManageConditionVO[]
	 */
	public EQYARDManageConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EQYARDManageConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rccTxt = (JSPUtil.getParameter(request, prefix	+ "rcc_txt", length));
			String[] lccTxt = (JSPUtil.getParameter(request, prefix	+ "lcc_txt", length));
			String[] eccTxt = (JSPUtil.getParameter(request, prefix	+ "ecc_txt", length));
			String[] cntTxt = (JSPUtil.getParameter(request, prefix	+ "cnt_txt", length));
			String[] dist = (JSPUtil.getParameter(request, prefix	+ "dist", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EQYARDManageConditionVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rccTxt[i] != null)
					model.setRccTxt(rccTxt[i]);
				if (lccTxt[i] != null)
					model.setLccTxt(lccTxt[i]);
				if (eccTxt[i] != null)
					model.setEccTxt(eccTxt[i]);
				if (cntTxt[i] != null)
					model.setCntTxt(cntTxt[i]);
				if (dist[i] != null)
					model.setDist(dist[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEQYARDManageConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EQYARDManageConditionVO[]
	 */
	public EQYARDManageConditionVO[] getEQYARDManageConditionVOs(){
		EQYARDManageConditionVO[] vos = (EQYARDManageConditionVO[])models.toArray(new EQYARDManageConditionVO[models.size()]);
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
		this.rccTxt = this.rccTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccTxt = this.lccTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccTxt = this.eccTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntTxt = this.cntTxt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dist = this.dist .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
