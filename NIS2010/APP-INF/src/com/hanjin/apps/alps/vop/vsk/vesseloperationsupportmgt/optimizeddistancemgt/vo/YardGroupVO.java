/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : YardGroupVO.java
*@FileTitle : YardGroupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.13  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class YardGroupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<YardGroupVO> models = new ArrayList<YardGroupVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String ydGrpId = null;
	/* Column Info */
	private String portCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String tmnlCd = null;
	/* Column Info */
	private String fmYdCd = null;
	/* Column Info */
	private String toYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public YardGroupVO() {}

	public YardGroupVO(String ibflag, String pagerows, String portCd, String ydCd, String ydNm, String ydGrpId, String usrId, String tmnlCd, String fmYdCd, String toYdCd) {
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.ydNm = ydNm;
		this.ydGrpId = ydGrpId;
		this.portCd = portCd;
		this.pagerows = pagerows;
		this.usrId = usrId;
		this.tmnlCd = tmnlCd;
		this.fmYdCd = fmYdCd;
		this.toYdCd = toYdCd;



	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("yd_grp_id", getYdGrpId());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("tmnl_cd", getTmnlCd());
		this.hashColumns.put("fm_yd_cd", getFmYdCd());
		this.hashColumns.put("to_yd_cd", getToYdCd());



		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("yd_grp_id", "ydGrpId");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("tmnl_cd", "tmnlCd");
		this.hashFields.put("fm_yd_cd", "fmYdCd");
		this.hashFields.put("to_yd_cd", "toYdCd");




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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return ydGrpId
	 */
	public String getYdGrpId() {
		return this.ydGrpId;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return tmnlCd
	 */
	public String getTmnlCd() {
		return this.tmnlCd;
	}
	
	/**
	 * Column Info
	 * @return fmYdCd
	 */
	public String getFmYdCd() {
		return this.fmYdCd;
	}
	
	/**
	 * Column Info
	 * @return toYdCd
	 */
	public String getToYdCd() {
		return this.toYdCd;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param ydGrpId
	 */
	public void setYdGrpId(String ydGrpId) {
		this.ydGrpId = ydGrpId;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param tmnlCd
	 */
	public void setTmnlCd(String tmnlCd) {
		this.tmnlCd = tmnlCd;
	}
	
	/**
	 * Column Info
	 * @param fmYdCd
	 */
	public void setFmYdCd(String fmYdCd) {
		this.fmYdCd = fmYdCd;
	}
	
	/**
	 * Column Info
	 * @param toYdCd
	 */
	public void setToYdCd(String toYdCd) {
		this.toYdCd = toYdCd;
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
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setYdGrpId(JSPUtil.getParameter(request, prefix + "yd_grp_id", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setTmnlCd(JSPUtil.getParameter(request, prefix + "tmnl_cd", ""));
		setFmYdCd(JSPUtil.getParameter(request, prefix + "fm_yd_cd", ""));
		setToYdCd(JSPUtil.getParameter(request, prefix + "to_yd_cd", ""));


	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return YardGroupVO[]
	 */
	public YardGroupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return YardGroupVO[]
	 */
	public YardGroupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		YardGroupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] ydGrpId = (JSPUtil.getParameter(request, prefix	+ "yd_grp_id", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] tmnlCd = (JSPUtil.getParameter(request, prefix	+ "tmnl_cd", length));
			String[] fmYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_yd_cd", length));
			String[] toYdCd = (JSPUtil.getParameter(request, prefix	+ "to_yd_cd", length));



			
			for (int i = 0; i < length; i++) {
				model = new YardGroupVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (ydGrpId[i] != null)
					model.setYdGrpId(ydGrpId[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (tmnlCd[i] != null)
					model.setTmnlCd(tmnlCd[i]);
				if (fmYdCd[i] != null)
					model.setFmYdCd(fmYdCd[i]);
				if (toYdCd[i] != null)
					model.setToYdCd(toYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getYardGroupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return YardGroupVO[]
	 */
	public YardGroupVO[] getYardGroupVOs(){
		YardGroupVO[] vos = (YardGroupVO[])models.toArray(new YardGroupVO[models.size()]);
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
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydGrpId = this.ydGrpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmnlCd = this.tmnlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYdCd = this.fmYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYdCd = this.toYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");



	}
}
