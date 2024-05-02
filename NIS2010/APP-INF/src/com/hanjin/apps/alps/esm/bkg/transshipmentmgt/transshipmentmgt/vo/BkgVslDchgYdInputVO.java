/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SqlNameBkgVslDchgYdInputVO.java
*@FileTitle : SqlNameBkgVslDchgYdInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.19 최영희 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 최영희
 * @since J2EE 1.5
 * @see ..
 */

public class BkgVslDchgYdInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgVslDchgYdInputVO> models = new ArrayList<BkgVslDchgYdInputVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String vpsEtbDt = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String vpsPortCds = null;
	/* Column Info */
	private String vpsOherPortCd = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgVslDchgYdInputVO() {}

	public BkgVslDchgYdInputVO(String ibflag, String pagerows, String vpsEtbDt, String vpsEtdDt, String vpsPortCd, String vpsOherPortCd, String vpsPortCds, String vvd, String lane, String crrCd) {
		this.vvd = vvd;
		this.vpsPortCd = vpsPortCd;
		this.vpsEtbDt = vpsEtbDt;
		this.ibflag = ibflag;
		this.vpsEtdDt = vpsEtdDt;
		this.vpsPortCds = vpsPortCds;
		this.vpsOherPortCd = vpsOherPortCd;
		this.crrCd = crrCd;
		this.lane = lane;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vps_port_cd", getvpsPortCd());
		this.hashColumns.put("vps_etb_dt", getVpsEtbDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("vps_port_cds", getVpsPortCds());
		this.hashColumns.put("vps_oher_port_cd", getVpsOherPortCd());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("vps_etb_dt", "vpsEtbDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("vps_port_cds", "vpsPortCds");
		this.hashFields.put("vps_oher_port_cd", "vpsOherPortCd");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getvpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtbDt
	 */
	public String getVpsEtbDt() {
		return this.vpsEtbDt;
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
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCds
	 */
	public String getVpsPortCds() {
		return this.vpsPortCds;
	}
	
	/**
	 * Column Info
	 * @return vpsOherPortCd
	 */
	public String getVpsOherPortCd() {
		return this.vpsOherPortCd;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setvpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtbDt
	 */
	public void setVpsEtbDt(String vpsEtbDt) {
		this.vpsEtbDt = vpsEtbDt;
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
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCds
	 */
	public void setVpsPortCds(String vpsPortCds) {
		this.vpsPortCds = vpsPortCds;
	}
	
	/**
	 * Column Info
	 * @param vpsOherPortCd
	 */
	public void setVpsOherPortCd(String vpsOherPortCd) {
		this.vpsOherPortCd = vpsOherPortCd;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setvpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setVpsEtbDt(JSPUtil.getParameter(request, "vps_etb_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setVpsPortCds(JSPUtil.getParameter(request, "vps_port_cds", ""));
		setVpsOherPortCd(JSPUtil.getParameter(request, "vps_oher_port_cd", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return SqlNameBkgVslDchgYdInputVO[]
	 */
	public BkgVslDchgYdInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SqlNameBkgVslDchgYdInputVO[]
	 */
	public BkgVslDchgYdInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgVslDchgYdInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd".trim(), length));
			String[] vpsEtbDt = (JSPUtil.getParameter(request, prefix	+ "vps_etb_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt".trim(), length));
			String[] vpsPortCds = (JSPUtil.getParameter(request, prefix	+ "vps_port_cds".trim(), length));
			String[] vpsOherPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_oher_port_cd".trim(), length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd".trim(), length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgVslDchgYdInputVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vpsPortCd[i] != null)
					model.setvpsPortCd(vpsPortCd[i]);
				if (vpsEtbDt[i] != null)
					model.setVpsEtbDt(vpsEtbDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (vpsPortCds[i] != null)
					model.setVpsPortCds(vpsPortCds[i]);
				if (vpsOherPortCd[i] != null)
					model.setVpsOherPortCd(vpsOherPortCd[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSqlNameBkgVslDchgYdInputVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return SqlNameBkgVslDchgYdInputVO[]
	 */
	public BkgVslDchgYdInputVO[] getSqlNameBkgVslDchgYdInputVOs(){
		BkgVslDchgYdInputVO[] vos = (BkgVslDchgYdInputVO[])models.toArray(new BkgVslDchgYdInputVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtbDt = this.vpsEtbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCds = this.vpsPortCds .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsOherPortCd = this.vpsOherPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
