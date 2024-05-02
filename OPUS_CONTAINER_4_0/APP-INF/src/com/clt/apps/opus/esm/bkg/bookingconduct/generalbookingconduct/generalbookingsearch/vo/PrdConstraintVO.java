/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdConstraintVO.java
*@FileTitle : PrdConstraintVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.19 KimByungKyu
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author KimByungKyu
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class PrdConstraintVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<PrdConstraintVO> models = new ArrayList<PrdConstraintVO>();

	/* Column Info */
	private String n2ndLaneCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String n2ndTsPortCd = null;
	/* Column Info */
	private String n1stLaneCd = null;
	/* Column Info */
	private String n1stTsPortCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String routCnstRmk = null;
	/* Column Info */
	private String trnkLaneCd = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public PrdConstraintVO() {}

	public PrdConstraintVO(String ibflag, String pagerows, String slanCd, String polCd, String trnkLaneCd, String n1stLaneCd, String n1stTsPortCd, String n2ndLaneCd, String n2ndTsPortCd, String podCd, String podNodCd, String delCd, String routCnstRmk) {
		this.n2ndLaneCd = n2ndLaneCd;
		this.delCd = delCd;
		this.n2ndTsPortCd = n2ndTsPortCd;
		this.n1stLaneCd = n1stLaneCd;
		this.n1stTsPortCd = n1stTsPortCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.podNodCd = podNodCd;
		this.slanCd = slanCd;
		this.routCnstRmk = routCnstRmk;
		this.trnkLaneCd = trnkLaneCd;
	}

	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n2nd_lane_cd", getN2ndLaneCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("n2nd_ts_port_cd", getN2ndTsPortCd());
		this.hashColumns.put("n1st_lane_cd", getN1stLaneCd());
		this.hashColumns.put("n1st_ts_port_cd", getN1stTsPortCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("rout_cnst_rmk", getRoutCnstRmk());
		this.hashColumns.put("trnk_lane_cd", getTrnkLaneCd());
		return this.hashColumns;
	}

	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("n2nd_lane_cd", "n2ndLaneCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("n2nd_ts_port_cd", "n2ndTsPortCd");
		this.hashFields.put("n1st_lane_cd", "n1stLaneCd");
		this.hashFields.put("n1st_ts_port_cd", "n1stTsPortCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("rout_cnst_rmk", "routCnstRmk");
		this.hashFields.put("trnk_lane_cd", "trnkLaneCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return n2ndLaneCd
	 */
	public String getN2ndLaneCd() {
		return this.n2ndLaneCd;
	}

	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}

	/**
	 * Column Info
	 * @return n2ndTsPortCd
	 */
	public String getN2ndTsPortCd() {
		return this.n2ndTsPortCd;
	}

	/**
	 * Column Info
	 * @return n1stLaneCd
	 */
	public String getN1stLaneCd() {
		return this.n1stLaneCd;
	}

	/**
	 * Column Info
	 * @return n1stTsPortCd
	 */
	public String getN1stTsPortCd() {
		return this.n1stTsPortCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}

	/**
	 * Column Info
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
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
	 * @return routCnstRmk
	 */
	public String getRoutCnstRmk() {
		return this.routCnstRmk;
	}

	/**
	 * Column Info
	 * @return trnkLaneCd
	 */
	public String getTrnkLaneCd() {
		return this.trnkLaneCd;
	}


	/**
	 * Column Info
	 * @param n2ndLaneCd
	 */
	public void setN2ndLaneCd(String n2ndLaneCd) {
		this.n2ndLaneCd = n2ndLaneCd;
	}

	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	/**
	 * Column Info
	 * @param n2ndTsPortCd
	 */
	public void setN2ndTsPortCd(String n2ndTsPortCd) {
		this.n2ndTsPortCd = n2ndTsPortCd;
	}

	/**
	 * Column Info
	 * @param n1stLaneCd
	 */
	public void setN1stLaneCd(String n1stLaneCd) {
		this.n1stLaneCd = n1stLaneCd;
	}

	/**
	 * Column Info
	 * @param n1stTsPortCd
	 */
	public void setN1stTsPortCd(String n1stTsPortCd) {
		this.n1stTsPortCd = n1stTsPortCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}

	/**
	 * Column Info
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
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
	 * @param routCnstRmk
	 */
	public void setRoutCnstRmk(String routCnstRmk) {
		this.routCnstRmk = routCnstRmk;
	}

	/**
	 * Column Info
	 * @param trnkLaneCd
	 */
	public void setTrnkLaneCd(String trnkLaneCd) {
		this.trnkLaneCd = trnkLaneCd;
	}

	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setN2ndLaneCd(JSPUtil.getParameter(request, "n2nd_lane_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setN2ndTsPortCd(JSPUtil.getParameter(request, "n2nd_ts_port_cd", ""));
		setN1stLaneCd(JSPUtil.getParameter(request, "n1st_lane_cd", ""));
		setN1stTsPortCd(JSPUtil.getParameter(request, "n1st_ts_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPodNodCd(JSPUtil.getParameter(request, "pod_nod_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setRoutCnstRmk(JSPUtil.getParameter(request, "rout_cnst_rmk", ""));
		setTrnkLaneCd(JSPUtil.getParameter(request, "trnk_lane_cd", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return PrdConstraintVO[]
	 */
	public PrdConstraintVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PrdConstraintVO[]
	 */
	public PrdConstraintVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrdConstraintVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] n2ndLaneCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_lane_cd".trim(), length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd".trim(), length));
			String[] n2ndTsPortCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_ts_port_cd".trim(), length));
			String[] n1stLaneCd = (JSPUtil.getParameter(request, prefix	+ "n1st_lane_cd".trim(), length));
			String[] n1stTsPortCd = (JSPUtil.getParameter(request, prefix	+ "n1st_ts_port_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd".trim(), length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd".trim(), length));
			String[] routCnstRmk = (JSPUtil.getParameter(request, prefix	+ "rout_cnst_rmk".trim(), length));
			String[] trnkLaneCd = (JSPUtil.getParameter(request, prefix	+ "trnk_lane_cd".trim(), length));

			for (int i = 0; i < length; i++) {
				model = new PrdConstraintVO();
				if (n2ndLaneCd[i] != null)
					model.setN2ndLaneCd(n2ndLaneCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (n2ndTsPortCd[i] != null)
					model.setN2ndTsPortCd(n2ndTsPortCd[i]);
				if (n1stLaneCd[i] != null)
					model.setN1stLaneCd(n1stLaneCd[i]);
				if (n1stTsPortCd[i] != null)
					model.setN1stTsPortCd(n1stTsPortCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (routCnstRmk[i] != null)
					model.setRoutCnstRmk(routCnstRmk[i]);
				if (trnkLaneCd[i] != null)
					model.setTrnkLaneCd(trnkLaneCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrdConstraintVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다
	 * @return PrdConstraintVO[]
	 */
	public PrdConstraintVO[] getPrdConstraintVOs(){
		PrdConstraintVO[] vos = (PrdConstraintVO[])models.toArray(new PrdConstraintVO[models.size()]);
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
	public void unDataFormat(){
		this.n2ndLaneCd = this.n2ndLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndTsPortCd = this.n2ndTsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stLaneCd = this.n1stLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stTsPortCd = this.n1stTsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routCnstRmk = this.routCnstRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkLaneCd = this.trnkLaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
