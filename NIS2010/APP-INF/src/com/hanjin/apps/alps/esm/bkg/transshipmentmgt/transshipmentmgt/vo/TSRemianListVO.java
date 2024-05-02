/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TSRemianListVO.java
*@FileTitle : TSRemianListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.07.23 최영희 
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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TSRemianListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TSRemianListVO> models = new ArrayList<TSRemianListVO>();
	
	/* Column Info */
	private String frmrVvd = null;
	/* Column Info */
	private String stayDay = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fm = null;
	/* Column Info */
	private String cnmvStsCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String nextLane = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String frmrLane = null;
	/* Column Info */
	private String nextVvd = null;
	/* Column Info */
	private String special = null;
	/* Column Info */
	private String shNm = null;
	/* Column Info */
	private String act = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String cnNm = null;
	/* Column Info */
	private String nextPort = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TSRemianListVO() {}

	public TSRemianListVO(String ibflag, String pagerows, String podYdCd, String cntrNo, String cntrTpszCd, String fm, String cnmvStsCd, String blNo, String polCd, String podCd, String nextPort, String frmrVvd, String frmrLane, String act, String nextVvd, String nextLane, String etd, String special, String stayDay, String shNm, String cnNm) {
		this.frmrVvd = frmrVvd;
		this.stayDay = stayDay;
		this.etd = etd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.fm = fm;
		this.cnmvStsCd = cnmvStsCd;
		this.polCd = polCd;
		this.nextLane = nextLane;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.frmrLane = frmrLane;
		this.nextVvd = nextVvd;
		this.special = special;
		this.shNm = shNm;
		this.act = act;
		this.podYdCd = podYdCd;
		this.cnNm = cnNm;
		this.nextPort = nextPort;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frmr_vvd", getFrmrVvd());
		this.hashColumns.put("stay_day", getStayDay());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("fm", getFm());
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("next_lane", getNextLane());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("frmr_lane", getFrmrLane());
		this.hashColumns.put("next_vvd", getNextVvd());
		this.hashColumns.put("special", getSpecial());
		this.hashColumns.put("sh_nm", getShNm());
		this.hashColumns.put("act", getAct());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("cn_nm", getCnNm());
		this.hashColumns.put("next_port", getNextPort());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frmr_vvd", "frmrVvd");
		this.hashFields.put("stay_day", "stayDay");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("fm", "fm");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("next_lane", "nextLane");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("frmr_lane", "frmrLane");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("special", "special");
		this.hashFields.put("sh_nm", "shNm");
		this.hashFields.put("act", "act");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("cn_nm", "cnNm");
		this.hashFields.put("next_port", "nextPort");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frmrVvd
	 */
	public String getFrmrVvd() {
		return this.frmrVvd;
	}
	
	/**
	 * Column Info
	 * @return stayDay
	 */
	public String getStayDay() {
		return this.stayDay;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return fm
	 */
	public String getFm() {
		return this.fm;
	}
	
	/**
	 * Column Info
	 * @return cnmvStsCd
	 */
	public String getCnmvStsCd() {
		return this.cnmvStsCd;
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
	 * @return nextLane
	 */
	public String getNextLane() {
		return this.nextLane;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return frmrLane
	 */
	public String getFrmrLane() {
		return this.frmrLane;
	}
	
	/**
	 * Column Info
	 * @return nextVvd
	 */
	public String getNextVvd() {
		return this.nextVvd;
	}
	
	/**
	 * Column Info
	 * @return special
	 */
	public String getSpecial() {
		return this.special;
	}
	
	/**
	 * Column Info
	 * @return shNm
	 */
	public String getShNm() {
		return this.shNm;
	}
	
	/**
	 * Column Info
	 * @return act
	 */
	public String getAct() {
		return this.act;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return cnNm
	 */
	public String getCnNm() {
		return this.cnNm;
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
	 * @param frmrVvd
	 */
	public void setFrmrVvd(String frmrVvd) {
		this.frmrVvd = frmrVvd;
	}
	
	/**
	 * Column Info
	 * @param stayDay
	 */
	public void setStayDay(String stayDay) {
		this.stayDay = stayDay;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param fm
	 */
	public void setFm(String fm) {
		this.fm = fm;
	}
	
	/**
	 * Column Info
	 * @param cnmvStsCd
	 */
	public void setCnmvStsCd(String cnmvStsCd) {
		this.cnmvStsCd = cnmvStsCd;
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
	 * @param nextLane
	 */
	public void setNextLane(String nextLane) {
		this.nextLane = nextLane;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param frmrLane
	 */
	public void setFrmrLane(String frmrLane) {
		this.frmrLane = frmrLane;
	}
	
	/**
	 * Column Info
	 * @param nextVvd
	 */
	public void setNextVvd(String nextVvd) {
		this.nextVvd = nextVvd;
	}
	
	/**
	 * Column Info
	 * @param special
	 */
	public void setSpecial(String special) {
		this.special = special;
	}
	
	/**
	 * Column Info
	 * @param shNm
	 */
	public void setShNm(String shNm) {
		this.shNm = shNm;
	}
	
	/**
	 * Column Info
	 * @param act
	 */
	public void setAct(String act) {
		this.act = act;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param cnNm
	 */
	public void setCnNm(String cnNm) {
		this.cnNm = cnNm;
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
		setFrmrVvd(JSPUtil.getParameter(request, "frmr_vvd", ""));
		setStayDay(JSPUtil.getParameter(request, "stay_day", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFm(JSPUtil.getParameter(request, "fm", ""));
		setCnmvStsCd(JSPUtil.getParameter(request, "cnmv_sts_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setNextLane(JSPUtil.getParameter(request, "next_lane", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setFrmrLane(JSPUtil.getParameter(request, "frmr_lane", ""));
		setNextVvd(JSPUtil.getParameter(request, "next_vvd", ""));
		setSpecial(JSPUtil.getParameter(request, "special", ""));
		setShNm(JSPUtil.getParameter(request, "sh_nm", ""));
		setAct(JSPUtil.getParameter(request, "act", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setCnNm(JSPUtil.getParameter(request, "cn_nm", ""));
		setNextPort(JSPUtil.getParameter(request, "next_port", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TSRemianListVO[]
	 */
	public TSRemianListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TSRemianListVO[]
	 */
	public TSRemianListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TSRemianListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frmrVvd = (JSPUtil.getParameter(request, prefix	+ "frmr_vvd", length));
			String[] stayDay = (JSPUtil.getParameter(request, prefix	+ "stay_day", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fm = (JSPUtil.getParameter(request, prefix	+ "fm", length));
			String[] cnmvStsCd = (JSPUtil.getParameter(request, prefix	+ "cnmv_sts_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] nextLane = (JSPUtil.getParameter(request, prefix	+ "next_lane", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] frmrLane = (JSPUtil.getParameter(request, prefix	+ "frmr_lane", length));
			String[] nextVvd = (JSPUtil.getParameter(request, prefix	+ "next_vvd", length));
			String[] special = (JSPUtil.getParameter(request, prefix	+ "special", length));
			String[] shNm = (JSPUtil.getParameter(request, prefix	+ "sh_nm", length));
			String[] act = (JSPUtil.getParameter(request, prefix	+ "act", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] cnNm = (JSPUtil.getParameter(request, prefix	+ "cn_nm", length));
			String[] nextPort = (JSPUtil.getParameter(request, prefix	+ "next_port", length));
			
			for (int i = 0; i < length; i++) {
				model = new TSRemianListVO();
				if (frmrVvd[i] != null)
					model.setFrmrVvd(frmrVvd[i]);
				if (stayDay[i] != null)
					model.setStayDay(stayDay[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fm[i] != null)
					model.setFm(fm[i]);
				if (cnmvStsCd[i] != null)
					model.setCnmvStsCd(cnmvStsCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (nextLane[i] != null)
					model.setNextLane(nextLane[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (frmrLane[i] != null)
					model.setFrmrLane(frmrLane[i]);
				if (nextVvd[i] != null)
					model.setNextVvd(nextVvd[i]);
				if (special[i] != null)
					model.setSpecial(special[i]);
				if (shNm[i] != null)
					model.setShNm(shNm[i]);
				if (act[i] != null)
					model.setAct(act[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (cnNm[i] != null)
					model.setCnNm(cnNm[i]);
				if (nextPort[i] != null)
					model.setNextPort(nextPort[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTSRemianListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TSRemianListVO[]
	 */
	public TSRemianListVO[] getTSRemianListVOs(){
		TSRemianListVO[] vos = (TSRemianListVO[])models.toArray(new TSRemianListVO[models.size()]);
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
		this.frmrVvd = this.frmrVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDay = this.stayDay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm = this.fm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd = this.cnmvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextLane = this.nextLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmrLane = this.frmrLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd = this.nextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.special = this.special .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shNm = this.shNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.act = this.act .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnNm = this.cnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPort = this.nextPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
