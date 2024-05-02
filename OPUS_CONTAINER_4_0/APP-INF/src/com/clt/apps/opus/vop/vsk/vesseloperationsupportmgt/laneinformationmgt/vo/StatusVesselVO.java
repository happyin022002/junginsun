/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusVesselVO
*@FileTitle : StatusVesselVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.07.02 장석현 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 장석현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StatusVesselVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<StatusVesselVO> models = new ArrayList<StatusVesselVO>();
	
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String vslClass = null;
	/* Column Info */
	private String svcLane = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String fre = null;
	/* Column Info */
	private String ttl = null;
	/* Column Info */
	private String svcOpenDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String grp = null;
	/* Column Info */
	private String oth = null;
	/* Column Info */
	private String own = null;
	/* Column Info */
	private String portRot = null;
	/* Column Info */
	private String cht = null;
	/* Column Info */
	private String opt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public StatusVesselVO() {}

	public StatusVesselVO(String ibflag, String pagerows, String grp, String svcLane, String vslNm, String opt, String vslClass, String own, String cht, String oth, String ttl, String svcOpenDt, String portRot, String fre, String remark) {
		this.remark = remark;
		this.vslClass = vslClass;
		this.svcLane = svcLane;
		this.vslNm = vslNm;
		this.fre = fre;
		this.ttl = ttl;
		this.svcOpenDt = svcOpenDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.grp = grp;
		this.oth = oth;
		this.own = own;
		this.portRot = portRot;
		this.cht = cht;
		this.opt = opt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("vsl_class", getVslClass());
		this.hashColumns.put("svc_lane", getSvcLane());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("fre", getFre());
		this.hashColumns.put("ttl", getTtl());
		this.hashColumns.put("svc_open_dt", getSvcOpenDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("oth", getOth());
		this.hashColumns.put("own", getOwn());
		this.hashColumns.put("port_rot", getPortRot());
		this.hashColumns.put("cht", getCht());
		this.hashColumns.put("opt", getOpt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("remark", "remark");
		this.hashFields.put("vsl_class", "vslClass");
		this.hashFields.put("svc_lane", "svcLane");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("fre", "fre");
		this.hashFields.put("ttl", "ttl");
		this.hashFields.put("svc_open_dt", "svcOpenDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grp", "grp");
		this.hashFields.put("oth", "oth");
		this.hashFields.put("own", "own");
		this.hashFields.put("port_rot", "portRot");
		this.hashFields.put("cht", "cht");
		this.hashFields.put("opt", "opt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
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
	 * @return svcLane
	 */
	public String getSvcLane() {
		return this.svcLane;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return fre
	 */
	public String getFre() {
		return this.fre;
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
	 * @return svcOpenDt
	 */
	public String getSvcOpenDt() {
		return this.svcOpenDt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return grp
	 */
	public String getGrp() {
		return this.grp;
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
	 * @return own
	 */
	public String getOwn() {
		return this.own;
	}
	
	/**
	 * Column Info
	 * @return portRot
	 */
	public String getPortRot() {
		return this.portRot;
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
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
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
	 * @param svcLane
	 */
	public void setSvcLane(String svcLane) {
		this.svcLane = svcLane;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param fre
	 */
	public void setFre(String fre) {
		this.fre = fre;
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
	 * @param svcOpenDt
	 */
	public void setSvcOpenDt(String svcOpenDt) {
		this.svcOpenDt = svcOpenDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param grp
	 */
	public void setGrp(String grp) {
		this.grp = grp;
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
	 * @param own
	 */
	public void setOwn(String own) {
		this.own = own;
	}
	
	/**
	 * Column Info
	 * @param portRot
	 */
	public void setPortRot(String portRot) {
		this.portRot = portRot;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setVslClass(JSPUtil.getParameter(request, "vsl_class", ""));
		setSvcLane(JSPUtil.getParameter(request, "svc_lane", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setFre(JSPUtil.getParameter(request, "fre", ""));
		setTtl(JSPUtil.getParameter(request, "ttl", ""));
		setSvcOpenDt(JSPUtil.getParameter(request, "svc_open_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGrp(JSPUtil.getParameter(request, "grp", ""));
		setOth(JSPUtil.getParameter(request, "oth", ""));
		setOwn(JSPUtil.getParameter(request, "own", ""));
		setPortRot(JSPUtil.getParameter(request, "port_rot", ""));
		setCht(JSPUtil.getParameter(request, "cht", ""));
		setOpt(JSPUtil.getParameter(request, "opt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return StatusVesselVO[]
	 */
	public StatusVesselVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return StatusVesselVO[]
	 */
	public StatusVesselVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		StatusVesselVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] vslClass = (JSPUtil.getParameter(request, prefix	+ "vsl_class", length));
			String[] svcLane = (JSPUtil.getParameter(request, prefix	+ "svc_lane", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] fre = (JSPUtil.getParameter(request, prefix	+ "fre", length));
			String[] ttl = (JSPUtil.getParameter(request, prefix	+ "ttl", length));
			String[] svcOpenDt = (JSPUtil.getParameter(request, prefix	+ "svc_open_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] oth = (JSPUtil.getParameter(request, prefix	+ "oth", length));
			String[] own = (JSPUtil.getParameter(request, prefix	+ "own", length));
			String[] portRot = (JSPUtil.getParameter(request, prefix	+ "port_rot", length));
			String[] cht = (JSPUtil.getParameter(request, prefix	+ "cht", length));
			String[] opt = (JSPUtil.getParameter(request, prefix	+ "opt", length));
			
			for (int i = 0; i < length; i++) {
				model = new StatusVesselVO();
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (vslClass[i] != null)
					model.setVslClass(vslClass[i]);
				if (svcLane[i] != null)
					model.setSvcLane(svcLane[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (fre[i] != null)
					model.setFre(fre[i]);
				if (ttl[i] != null)
					model.setTtl(ttl[i]);
				if (svcOpenDt[i] != null)
					model.setSvcOpenDt(svcOpenDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grp[i] != null)
					model.setGrp(grp[i]);
				if (oth[i] != null)
					model.setOth(oth[i]);
				if (own[i] != null)
					model.setOwn(own[i]);
				if (portRot[i] != null)
					model.setPortRot(portRot[i]);
				if (cht[i] != null)
					model.setCht(cht[i]);
				if (opt[i] != null)
					model.setOpt(opt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getStatusVesselVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return StatusVesselVO[]
	 */
	public StatusVesselVO[] getStatusVesselVOs(){
		StatusVesselVO[] vos = (StatusVesselVO[])models.toArray(new StatusVesselVO[models.size()]);
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
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClass = this.vslClass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcLane = this.svcLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fre = this.fre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl = this.ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcOpenDt = this.svcOpenDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oth = this.oth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.own = this.own .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portRot = this.portRot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cht = this.cht .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opt = this.opt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
