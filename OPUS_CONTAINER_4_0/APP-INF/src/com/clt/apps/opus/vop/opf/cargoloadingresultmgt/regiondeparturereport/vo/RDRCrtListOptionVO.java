/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RDRCrtListOptionVO.java
*@FileTitle : RDRCrtListOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.10 장강철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo;

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
 * @author 장강철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDRCrtListOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RDRCrtListOptionVO> models = new ArrayList<RDRCrtListOptionVO>();
	
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String segment = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String etaCanal = null;
	/* Column Info */
	private String callInd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String movePortCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String nextCanal = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String updateUser = null;
	/* Column Info */
	private String nextPort = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RDRCrtListOptionVO() {}

	public RDRCrtListOptionVO(String ibflag, String pagerows, String vslCd, String voyNo, String dirCd, String region, String portCd, String nextPort, String eta, String nextCanal, String etaCanal, String remark, String segment, String updateUser, String movePortCd, String callInd) {
		this.region = region;
		this.vslCd = vslCd;
		this.voyNo = voyNo;
		this.eta = eta;
		this.remark = remark;
		this.segment = segment;
		this.pagerows = pagerows;
		this.etaCanal = etaCanal;
		this.callInd = callInd;
		this.ibflag = ibflag;
		this.movePortCd = movePortCd;
		this.dirCd = dirCd;
		this.nextCanal = nextCanal;
		this.portCd = portCd;
		this.updateUser = updateUser;
		this.nextPort = nextPort;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("segment", getSegment());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eta_canal", getEtaCanal());
		this.hashColumns.put("call_ind", getCallInd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("move_port_cd", getMovePortCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("next_canal", getNextCanal());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("update_user", getUpdateUser());
		this.hashColumns.put("next_port", getNextPort());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("region", "region");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("segment", "segment");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eta_canal", "etaCanal");
		this.hashFields.put("call_ind", "callInd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("move_port_cd", "movePortCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("next_canal", "nextCanal");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("update_user", "updateUser");
		this.hashFields.put("next_port", "nextPort");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
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
	 * @return voyNo
	 */
	public String getVoyNo() {
		return this.voyNo;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
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
	 * @return segment
	 */
	public String getSegment() {
		return this.segment;
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
	 * @return etaCanal
	 */
	public String getEtaCanal() {
		return this.etaCanal;
	}
	
	/**
	 * Column Info
	 * @return callInd
	 */
	public String getCallInd() {
		return this.callInd;
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
	 * @return movePortCd
	 */
	public String getMovePortCd() {
		return this.movePortCd;
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
	 * @return nextCanal
	 */
	public String getNextCanal() {
		return this.nextCanal;
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
	 * @return updateUser
	 */
	public String getUpdateUser() {
		return this.updateUser;
	}
	
	/**
	 * Column Info
	 * @return nextPort
	 */
	public String getNextPort() {
		return this.nextPort;
	}
	

	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
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
	 * @param voyNo
	 */
	public void setVoyNo(String voyNo) {
		this.voyNo = voyNo;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
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
	 * @param segment
	 */
	public void setSegment(String segment) {
		this.segment = segment;
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
	 * @param etaCanal
	 */
	public void setEtaCanal(String etaCanal) {
		this.etaCanal = etaCanal;
	}
	
	/**
	 * Column Info
	 * @param callInd
	 */
	public void setCallInd(String callInd) {
		this.callInd = callInd;
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
	 * @param movePortCd
	 */
	public void setMovePortCd(String movePortCd) {
		this.movePortCd = movePortCd;
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
	 * @param nextCanal
	 */
	public void setNextCanal(String nextCanal) {
		this.nextCanal = nextCanal;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	/**
	 * Column Info
	 * @param nextPort
	 */
	public void setNextPort(String nextPort) {
		this.nextPort = nextPort;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRegion(JSPUtil.getParameter(request, "region", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVoyNo(JSPUtil.getParameter(request, "voy_no", ""));
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setSegment(JSPUtil.getParameter(request, "segment", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEtaCanal(JSPUtil.getParameter(request, "eta_canal", ""));
		setCallInd(JSPUtil.getParameter(request, "call_ind", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMovePortCd(JSPUtil.getParameter(request, "move_port_cd", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setNextCanal(JSPUtil.getParameter(request, "next_canal", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setUpdateUser(JSPUtil.getParameter(request, "update_user", ""));
		setNextPort(JSPUtil.getParameter(request, "next_port", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RDRCrtListOptionVO[]
	 */
	public RDRCrtListOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RDRCrtListOptionVO[]
	 */
	public RDRCrtListOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDRCrtListOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] segment = (JSPUtil.getParameter(request, prefix	+ "segment", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] etaCanal = (JSPUtil.getParameter(request, prefix	+ "eta_canal", length));
			String[] callInd = (JSPUtil.getParameter(request, prefix	+ "call_ind", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] movePortCd = (JSPUtil.getParameter(request, prefix	+ "move_port_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] nextCanal = (JSPUtil.getParameter(request, prefix	+ "next_canal", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] updateUser = (JSPUtil.getParameter(request, prefix	+ "update_user", length));
			String[] nextPort = (JSPUtil.getParameter(request, prefix	+ "next_port", length));
			
			for (int i = 0; i < length; i++) {
				model = new RDRCrtListOptionVO();
				if (region[i] != null)
					model.setRegion(region[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (segment[i] != null)
					model.setSegment(segment[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (etaCanal[i] != null)
					model.setEtaCanal(etaCanal[i]);
				if (callInd[i] != null)
					model.setCallInd(callInd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (movePortCd[i] != null)
					model.setMovePortCd(movePortCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (nextCanal[i] != null)
					model.setNextCanal(nextCanal[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (updateUser[i] != null)
					model.setUpdateUser(updateUser[i]);
				if (nextPort[i] != null)
					model.setNextPort(nextPort[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDRCrtListOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RDRCrtListOptionVO[]
	 */
	public RDRCrtListOptionVO[] getRDRCrtListOptionVOs(){
		RDRCrtListOptionVO[] vos = (RDRCrtListOptionVO[])models.toArray(new RDRCrtListOptionVO[models.size()]);
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
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segment = this.segment .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaCanal = this.etaCanal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callInd = this.callInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.movePortCd = this.movePortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextCanal = this.nextCanal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateUser = this.updateUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPort = this.nextPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
