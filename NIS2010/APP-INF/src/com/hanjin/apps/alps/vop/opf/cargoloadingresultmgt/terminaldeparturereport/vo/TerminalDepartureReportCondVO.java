/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalDepartureReportCondVO.java
*@FileTitle : TerminalDepartureReportCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TerminalDepartureReportCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TerminalDepartureReportCondVO> models = new ArrayList<TerminalDepartureReportCondVO>();
	
	/* Column Info */
	private String contiCd = null;
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String sysCreate = null;
	/* Column Info */
	private String status1 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String scStatus2 = null;
	/* Column Info */
	private String scStatus3 = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slStatus2 = null;
	/* Column Info */
	private String scStatus1 = null;
	/* Column Info */
	private String slStatus1 = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String status2 = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String portCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TerminalDepartureReportCondVO() {}

	public TerminalDepartureReportCondVO(String ibflag, String pagerows, String portCd, String voyNo, String dirCd, String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String status1, String status2, String scStatus1, String scStatus2, String scStatus3, String sysCreate, String cntrNo, String slStatus1, String slStatus2, String contiCd, String clptIndSeq) {
		this.contiCd = contiCd;
		this.voyNo = voyNo;
		this.vslCd = vslCd;
		this.sysCreate = sysCreate;
		this.status1 = status1;
		this.skdVoyNo = skdVoyNo;
		this.scStatus2 = scStatus2;
		this.scStatus3 = scStatus3;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.slStatus2 = slStatus2;
		this.scStatus1 = scStatus1;
		this.slStatus1 = slStatus1;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.clptIndSeq = clptIndSeq;
		this.status2 = status2;
		this.dirCd = dirCd;
		this.portCd = portCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("conti_cd", getContiCd());
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("sys_create", getSysCreate());
		this.hashColumns.put("status1", getStatus1());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("sc_status2", getScStatus2());
		this.hashColumns.put("sc_status3", getScStatus3());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sl_status2", getSlStatus2());
		this.hashColumns.put("sc_status1", getScStatus1());
		this.hashColumns.put("sl_status1", getSlStatus1());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("status2", getStatus2());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("port_cd", getPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("conti_cd", "contiCd");
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("sys_create", "sysCreate");
		this.hashFields.put("status1", "status1");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("sc_status2", "scStatus2");
		this.hashFields.put("sc_status3", "scStatus3");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sl_status2", "slStatus2");
		this.hashFields.put("sc_status1", "scStatus1");
		this.hashFields.put("sl_status1", "slStatus1");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("status2", "status2");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("port_cd", "portCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return contiCd
	 */
	public String getContiCd() {
		return this.contiCd;
	}
	
	/**
	 * Column Info
	 * @return voyNo
	 */
	public String getVoyNo() {
		return this.voyNo;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return sysCreate
	 */
	public String getSysCreate() {
		return this.sysCreate;
	}
	
	/**
	 * Column Info
	 * @return status1
	 */
	public String getStatus1() {
		return this.status1;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return scStatus2
	 */
	public String getScStatus2() {
		return this.scStatus2;
	}
	
	/**
	 * Column Info
	 * @return scStatus3
	 */
	public String getScStatus3() {
		return this.scStatus3;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return slStatus2
	 */
	public String getSlStatus2() {
		return this.slStatus2;
	}
	
	/**
	 * Column Info
	 * @return scStatus1
	 */
	public String getScStatus1() {
		return this.scStatus1;
	}
	
	/**
	 * Column Info
	 * @return slStatus1
	 */
	public String getSlStatus1() {
		return this.slStatus1;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return status2
	 */
	public String getStatus2() {
		return this.status2;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	

	/**
	 * Column Info
	 * @param contiCd
	 */
	public void setContiCd(String contiCd) {
		this.contiCd = contiCd;
	}
	
	/**
	 * Column Info
	 * @param voyNo
	 */
	public void setVoyNo(String voyNo) {
		this.voyNo = voyNo;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param sysCreate
	 */
	public void setSysCreate(String sysCreate) {
		this.sysCreate = sysCreate;
	}
	
	/**
	 * Column Info
	 * @param status1
	 */
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param scStatus2
	 */
	public void setScStatus2(String scStatus2) {
		this.scStatus2 = scStatus2;
	}
	
	/**
	 * Column Info
	 * @param scStatus3
	 */
	public void setScStatus3(String scStatus3) {
		this.scStatus3 = scStatus3;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param slStatus2
	 */
	public void setSlStatus2(String slStatus2) {
		this.slStatus2 = slStatus2;
	}
	
	/**
	 * Column Info
	 * @param scStatus1
	 */
	public void setScStatus1(String scStatus1) {
		this.scStatus1 = scStatus1;
	}
	
	/**
	 * Column Info
	 * @param slStatus1
	 */
	public void setSlStatus1(String slStatus1) {
		this.slStatus1 = slStatus1;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param status2
	 */
	public void setStatus2(String status2) {
		this.status2 = status2;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setContiCd(JSPUtil.getParameter(request, "conti_cd", ""));
		setVoyNo(JSPUtil.getParameter(request, "voy_no", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSysCreate(JSPUtil.getParameter(request, "sys_create", ""));
		setStatus1(JSPUtil.getParameter(request, "status1", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setScStatus2(JSPUtil.getParameter(request, "sc_status2", ""));
		setScStatus3(JSPUtil.getParameter(request, "sc_status3", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlStatus2(JSPUtil.getParameter(request, "sl_status2", ""));
		setScStatus1(JSPUtil.getParameter(request, "sc_status1", ""));
		setSlStatus1(JSPUtil.getParameter(request, "sl_status1", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setStatus2(JSPUtil.getParameter(request, "status2", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TerminalDepartureReportCondVO[]
	 */
	public TerminalDepartureReportCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TerminalDepartureReportCondVO[]
	 */
	public TerminalDepartureReportCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TerminalDepartureReportCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] contiCd = (JSPUtil.getParameter(request, prefix	+ "conti_cd", length));
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] sysCreate = (JSPUtil.getParameter(request, prefix	+ "sys_create", length));
			String[] status1 = (JSPUtil.getParameter(request, prefix	+ "status1", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] scStatus2 = (JSPUtil.getParameter(request, prefix	+ "sc_status2", length));
			String[] scStatus3 = (JSPUtil.getParameter(request, prefix	+ "sc_status3", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slStatus2 = (JSPUtil.getParameter(request, prefix	+ "sl_status2", length));
			String[] scStatus1 = (JSPUtil.getParameter(request, prefix	+ "sc_status1", length));
			String[] slStatus1 = (JSPUtil.getParameter(request, prefix	+ "sl_status1", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] status2 = (JSPUtil.getParameter(request, prefix	+ "status2", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TerminalDepartureReportCondVO();
				if (contiCd[i] != null)
					model.setContiCd(contiCd[i]);
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (sysCreate[i] != null)
					model.setSysCreate(sysCreate[i]);
				if (status1[i] != null)
					model.setStatus1(status1[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (scStatus2[i] != null)
					model.setScStatus2(scStatus2[i]);
				if (scStatus3[i] != null)
					model.setScStatus3(scStatus3[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slStatus2[i] != null)
					model.setSlStatus2(slStatus2[i]);
				if (scStatus1[i] != null)
					model.setScStatus1(scStatus1[i]);
				if (slStatus1[i] != null)
					model.setSlStatus1(slStatus1[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (status2[i] != null)
					model.setStatus2(status2[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTerminalDepartureReportCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TerminalDepartureReportCondVO[]
	 */
	public TerminalDepartureReportCondVO[] getTerminalDepartureReportCondVOs(){
		TerminalDepartureReportCondVO[] vos = (TerminalDepartureReportCondVO[])models.toArray(new TerminalDepartureReportCondVO[models.size()]);
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
		this.contiCd = this.contiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysCreate = this.sysCreate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status1 = this.status1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scStatus2 = this.scStatus2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scStatus3 = this.scStatus3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slStatus2 = this.slStatus2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scStatus1 = this.scStatus1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slStatus1 = this.slStatus1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status2 = this.status2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
