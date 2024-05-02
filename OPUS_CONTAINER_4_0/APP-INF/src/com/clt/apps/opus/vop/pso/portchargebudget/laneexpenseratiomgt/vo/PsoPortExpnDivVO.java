/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PsoPortExpnDivVO.java
*@FileTitle : PsoPortExpnDivVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.05.28 박명종 
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

public class PsoPortExpnDivVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PsoPortExpnDivVO> models = new ArrayList<PsoPortExpnDivVO>();
	
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String obRto = null;
	/* Column Info */
	private String locCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String rlaneDirCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String ibRto = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PsoPortExpnDivVO() {}

	public PsoPortExpnDivVO(String ibflag, String pagerows, String rlaneCd, String rlaneDirCd, String skdDirCd, String locCd, String ibRto, String obRto, String slanCd, String portSeq) {
		this.portSeq = portSeq;
		this.obRto = obRto;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.rlaneDirCd = rlaneDirCd;
		this.rlaneCd = rlaneCd;
		this.ibRto = ibRto;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("ob_rto", getObRto());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("rlane_dir_cd", getRlaneDirCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("ib_rto", getIbRto());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("ob_rto", "obRto");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("rlane_dir_cd", "rlaneDirCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("ib_rto", "ibRto");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return obRto
	 */
	public String getObRto() {
		return this.obRto;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @param portSeq
	 */
	public void setPortSeq(String portSeq) {
		this.portSeq = portSeq;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param ibRto
	 */
	public void setIbRto(String ibRto) {
		this.ibRto = ibRto;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPortSeq(JSPUtil.getParameter(request, "port_seq", ""));
		setObRto(JSPUtil.getParameter(request, "ob_rto", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setRlaneDirCd(JSPUtil.getParameter(request, "rlane_dir_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setIbRto(JSPUtil.getParameter(request, "ib_rto", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PsoPortExpnDivVO[]
	 */
	public PsoPortExpnDivVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PsoPortExpnDivVO[]
	 */
	public PsoPortExpnDivVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PsoPortExpnDivVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq".trim(), length));
			String[] obRto = (JSPUtil.getParameter(request, prefix	+ "ob_rto".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd".trim(), length));
			String[] rlaneDirCd = (JSPUtil.getParameter(request, prefix	+ "rlane_dir_cd".trim(), length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd".trim(), length));
			String[] ibRto = (JSPUtil.getParameter(request, prefix	+ "ib_rto".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new PsoPortExpnDivVO();
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (obRto[i] != null)
					model.setObRto(obRto[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (rlaneDirCd[i] != null)
					model.setRlaneDirCd(rlaneDirCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (ibRto[i] != null)
					model.setIbRto(ibRto[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPsoPortExpnDivVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PsoPortExpnDivVO[]
	 */
	public PsoPortExpnDivVO[] getPsoPortExpnDivVOs(){
		PsoPortExpnDivVO[] vos = (PsoPortExpnDivVO[])models.toArray(new PsoPortExpnDivVO[models.size()]);
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
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obRto = this.obRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneDirCd = this.rlaneDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibRto = this.ibRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
