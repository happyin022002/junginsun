/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceLaneListVO.java
*@FileTitle : ServiceLaneListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.16 박명종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.vo;

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
 * @author 박명종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ServiceLaneListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ServiceLaneListVO> models = new ArrayList<ServiceLaneListVO>();
	
	/* Column Info */
	private String rlaneDirCdB = null;
	/* Column Info */
	private String obRto = null;
	/* Column Info */
	private String rlaneCdB = null;
	/* Column Info */
	private String skdDirCdB = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String locCdB = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String rlaneDirCd = null;
	/* Column Info */
	private String ibRto = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ServiceLaneListVO() {}

	public ServiceLaneListVO(String ibflag, String pagerows, String rlaneCd, String rlaneDirCd, String skdDirCd, String locCd, String ibRto, String obRto, String slanCd, String portSeq, String rlaneCdB, String rlaneDirCdB, String skdDirCdB, String locCdB, String creUsrId) {
		this.rlaneDirCdB = rlaneDirCdB;
		this.obRto = obRto;
		this.rlaneCdB = rlaneCdB;
		this.skdDirCdB = skdDirCdB;
		this.rlaneCd = rlaneCd;
		this.locCdB = locCdB;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.portSeq = portSeq;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.slanCd = slanCd;
		this.rlaneDirCd = rlaneDirCd;
		this.ibRto = ibRto;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rlane_dir_cd_b", getRlaneDirCdB());
		this.hashColumns.put("ob_rto", getObRto());
		this.hashColumns.put("rlane_cd_b", getRlaneCdB());
		this.hashColumns.put("skd_dir_cd_b", getSkdDirCdB());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("loc_cd_b", getLocCdB());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("rlane_dir_cd", getRlaneDirCd());
		this.hashColumns.put("ib_rto", getIbRto());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rlane_dir_cd_b", "rlaneDirCdB");
		this.hashFields.put("ob_rto", "obRto");
		this.hashFields.put("rlane_cd_b", "rlaneCdB");
		this.hashFields.put("skd_dir_cd_b", "skdDirCdB");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("loc_cd_b", "locCdB");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("rlane_dir_cd", "rlaneDirCd");
		this.hashFields.put("ib_rto", "ibRto");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rlaneDirCdB
	 */
	public String getRlaneDirCdB() {
		return this.rlaneDirCdB;
	}
	
	/**
	 * Column Info
	 * @return obRto
	 */
	public String getObRto() {
		return this.obRto;
	}
	
	/**
	 * Column Info
	 * @return rlaneCdB
	 */
	public String getRlaneCdB() {
		return this.rlaneCdB;
	}
	
	/**
	 * Column Info
	 * @return skdDirCdB
	 */
	public String getSkdDirCdB() {
		return this.skdDirCdB;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return locCdB
	 */
	public String getLocCdB() {
		return this.locCdB;
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
	 * Column Info
	 * @return portSeq
	 */
	public String getPortSeq() {
		return this.portSeq;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneDirCd
	 */
	public String getRlaneDirCd() {
		return this.rlaneDirCd;
	}
	
	/**
	 * Column Info
	 * @return ibRto
	 */
	public String getIbRto() {
		return this.ibRto;
	}
	

	/**
	 * Column Info
	 * @param rlaneDirCdB
	 */
	public void setRlaneDirCdB(String rlaneDirCdB) {
		this.rlaneDirCdB = rlaneDirCdB;
	}
	
	/**
	 * Column Info
	 * @param obRto
	 */
	public void setObRto(String obRto) {
		this.obRto = obRto;
	}
	
	/**
	 * Column Info
	 * @param rlaneCdB
	 */
	public void setRlaneCdB(String rlaneCdB) {
		this.rlaneCdB = rlaneCdB;
	}
	
	/**
	 * Column Info
	 * @param skdDirCdB
	 */
	public void setSkdDirCdB(String skdDirCdB) {
		this.skdDirCdB = skdDirCdB;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param locCdB
	 */
	public void setLocCdB(String locCdB) {
		this.locCdB = locCdB;
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
	 * Column Info
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneDirCd
	 */
	public void setRlaneDirCd(String rlaneDirCd) {
		this.rlaneDirCd = rlaneDirCd;
	}
	
	/**
	 * Column Info
	 * @param ibRto
	 */
	public void setIbRto(String ibRto) {
		this.ibRto = ibRto;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRlaneDirCdB(JSPUtil.getParameter(request, "rlane_dir_cd_b", ""));
		setObRto(JSPUtil.getParameter(request, "ob_rto", ""));
		setRlaneCdB(JSPUtil.getParameter(request, "rlane_cd_b", ""));
		setSkdDirCdB(JSPUtil.getParameter(request, "skd_dir_cd_b", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setLocCdB(JSPUtil.getParameter(request, "loc_cd_b", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPortSeq(JSPUtil.getParameter(request, "port_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setRlaneDirCd(JSPUtil.getParameter(request, "rlane_dir_cd", ""));
		setIbRto(JSPUtil.getParameter(request, "ib_rto", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ServiceLaneListVO[]
	 */
	public ServiceLaneListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ServiceLaneListVO[]
	 */
	public ServiceLaneListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ServiceLaneListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rlaneDirCdB = (JSPUtil.getParameter(request, prefix	+ "rlane_dir_cd_b".trim(), length));
			String[] obRto = (JSPUtil.getParameter(request, prefix	+ "ob_rto".trim(), length));
			String[] rlaneCdB = (JSPUtil.getParameter(request, prefix	+ "rlane_cd_b".trim(), length));
			String[] skdDirCdB = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd_b".trim(), length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd".trim(), length));
			String[] locCdB = (JSPUtil.getParameter(request, prefix	+ "loc_cd_b".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd".trim(), length));
			String[] rlaneDirCd = (JSPUtil.getParameter(request, prefix	+ "rlane_dir_cd".trim(), length));
			String[] ibRto = (JSPUtil.getParameter(request, prefix	+ "ib_rto".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ServiceLaneListVO();
				if (rlaneDirCdB[i] != null)
					model.setRlaneDirCdB(rlaneDirCdB[i]);
				if (obRto[i] != null)
					model.setObRto(obRto[i]);
				if (rlaneCdB[i] != null)
					model.setRlaneCdB(rlaneCdB[i]);
				if (skdDirCdB[i] != null)
					model.setSkdDirCdB(skdDirCdB[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (locCdB[i] != null)
					model.setLocCdB(locCdB[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (rlaneDirCd[i] != null)
					model.setRlaneDirCd(rlaneDirCd[i]);
				if (ibRto[i] != null)
					model.setIbRto(ibRto[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getServiceLaneListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ServiceLaneListVO[]
	 */
	public ServiceLaneListVO[] getServiceLaneListVOs(){
		ServiceLaneListVO[] vos = (ServiceLaneListVO[])models.toArray(new ServiceLaneListVO[models.size()]);
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
		this.rlaneDirCdB = this.rlaneDirCdB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obRto = this.obRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCdB = this.rlaneCdB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCdB = this.skdDirCdB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCdB = this.locCdB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneDirCd = this.rlaneDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibRto = this.ibRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
