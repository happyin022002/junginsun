/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusHJSVesselMainVO.java
*@FileTitle : StatusHJSVesselMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.09.29 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StatusHJSVesselMainVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StatusHJSVesselMainVO> models = new ArrayList<StatusHJSVesselMainVO>();
	
	/* Column Info */
	private String grp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oth = null;
	/* Column Info */
	private String vslClass = null;
	/* Column Info */
	private String own = null;
	/* Column Info */
	private String svcLane = null;
	/* Column Info */
	private String ttl = null;
	/* Column Info */
	private String cht = null;
	/* Column Info */
	private String opt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public StatusHJSVesselMainVO() {}

	public StatusHJSVesselMainVO(String ibflag, String pagerows, String grp, String svcLane, String opt, String vslClass, String own, String cht, String oth, String ttl) {
		this.grp = grp;
		this.ibflag = ibflag;
		this.oth = oth;
		this.vslClass = vslClass;
		this.own = own;
		this.svcLane = svcLane;
		this.ttl = ttl;
		this.cht = cht;
		this.opt = opt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("oth", getOth());
		this.hashColumns.put("vsl_class", getVslClass());
		this.hashColumns.put("own", getOwn());
		this.hashColumns.put("svc_lane", getSvcLane());
		this.hashColumns.put("ttl", getTtl());
		this.hashColumns.put("cht", getCht());
		this.hashColumns.put("opt", getOpt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("grp", "grp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("oth", "oth");
		this.hashFields.put("vsl_class", "vslClass");
		this.hashFields.put("own", "own");
		this.hashFields.put("svc_lane", "svcLane");
		this.hashFields.put("ttl", "ttl");
		this.hashFields.put("cht", "cht");
		this.hashFields.put("opt", "opt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return grp
	 */
	public String getGrp() {
		return this.grp;
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
	 * @return oth
	 */
	public String getOth() {
		return this.oth;
	}
	
	/**
	 * Column Info
	 * @return vslClass
	 */
	public String getVslClass() {
		return this.vslClass;
	}
	
	/**
	 * Column Info
	 * @return own
	 */
	public String getOwn() {
		return this.own;
	}
	
	/**
	 * Column Info
	 * @return svcLane
	 */
	public String getSvcLane() {
		return this.svcLane;
	}
	
	/**
	 * Column Info
	 * @return ttl
	 */
	public String getTtl() {
		return this.ttl;
	}
	
	/**
	 * Column Info
	 * @return cht
	 */
	public String getCht() {
		return this.cht;
	}
	
	/**
	 * Column Info
	 * @return opt
	 */
	public String getOpt() {
		return this.opt;
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
	 * @param grp
	 */
	public void setGrp(String grp) {
		this.grp = grp;
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
	 * @param oth
	 */
	public void setOth(String oth) {
		this.oth = oth;
	}
	
	/**
	 * Column Info
	 * @param vslClass
	 */
	public void setVslClass(String vslClass) {
		this.vslClass = vslClass;
	}
	
	/**
	 * Column Info
	 * @param own
	 */
	public void setOwn(String own) {
		this.own = own;
	}
	
	/**
	 * Column Info
	 * @param svcLane
	 */
	public void setSvcLane(String svcLane) {
		this.svcLane = svcLane;
	}
	
	/**
	 * Column Info
	 * @param ttl
	 */
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	
	/**
	 * Column Info
	 * @param cht
	 */
	public void setCht(String cht) {
		this.cht = cht;
	}
	
	/**
	 * Column Info
	 * @param opt
	 */
	public void setOpt(String opt) {
		this.opt = opt;
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
		setGrp(JSPUtil.getParameter(request, "grp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOth(JSPUtil.getParameter(request, "oth", ""));
		setVslClass(JSPUtil.getParameter(request, "vsl_class", ""));
		setOwn(JSPUtil.getParameter(request, "own", ""));
		setSvcLane(JSPUtil.getParameter(request, "svc_lane", ""));
		setTtl(JSPUtil.getParameter(request, "ttl", ""));
		setCht(JSPUtil.getParameter(request, "cht", ""));
		setOpt(JSPUtil.getParameter(request, "opt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StatusHJSVesselMainVO[]
	 */
	public StatusHJSVesselMainVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StatusHJSVesselMainVO[]
	 */
	public StatusHJSVesselMainVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StatusHJSVesselMainVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oth = (JSPUtil.getParameter(request, prefix	+ "oth", length));
			String[] vslClass = (JSPUtil.getParameter(request, prefix	+ "vsl_class", length));
			String[] own = (JSPUtil.getParameter(request, prefix	+ "own", length));
			String[] svcLane = (JSPUtil.getParameter(request, prefix	+ "svc_lane", length));
			String[] ttl = (JSPUtil.getParameter(request, prefix	+ "ttl", length));
			String[] cht = (JSPUtil.getParameter(request, prefix	+ "cht", length));
			String[] opt = (JSPUtil.getParameter(request, prefix	+ "opt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new StatusHJSVesselMainVO();
				if (grp[i] != null)
					model.setGrp(grp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oth[i] != null)
					model.setOth(oth[i]);
				if (vslClass[i] != null)
					model.setVslClass(vslClass[i]);
				if (own[i] != null)
					model.setOwn(own[i]);
				if (svcLane[i] != null)
					model.setSvcLane(svcLane[i]);
				if (ttl[i] != null)
					model.setTtl(ttl[i]);
				if (cht[i] != null)
					model.setCht(cht[i]);
				if (opt[i] != null)
					model.setOpt(opt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStatusHJSVesselMainVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StatusHJSVesselMainVO[]
	 */
	public StatusHJSVesselMainVO[] getStatusHJSVesselMainVOs(){
		StatusHJSVesselMainVO[] vos = (StatusHJSVesselMainVO[])models.toArray(new StatusHJSVesselMainVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oth = this.oth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClass = this.vslClass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.own = this.own .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcLane = this.svcLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl = this.ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cht = this.cht .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opt = this.opt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
