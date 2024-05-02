/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSimLaneRPBListVO.java
*@FileTitle : SearchSimLaneRPBListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.08.27 윤진영 
* 1.0 Creation
* 2010.02.18 윤진영 미사용 변수 삭제
=========================================================*/

package com.hanjin.apps.alps.esm.mas.lanesimulation.vo;

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
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSimLaneRPBListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSimLaneRPBListVO> models = new ArrayList<SearchSimLaneRPBListVO>();
	
	/* Column Info */
	private String portDys = null;
	/* Column Info */
	private String lodTtlQty = null;
	/* Column Info */
	private String freqNo = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String simDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String sectNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String simNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ldfRto = null;
	/* Column Info */
	private String bsaCapa = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grsRpbRev = null;
	/* Column Info */
	private String grsTtlRev = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String updUsrId = null;
	public String getUpdUsrId() {
		return updUsrId;
	}

	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSimLaneRPBListVO() {}

	public SearchSimLaneRPBListVO(String ibflag, String pagerows, String simDt, String simNo, String sectNo, String freqNo, String trdCd, String subTrdCd, String rlaneCd, String iocCd, String skdDirCd, String grsRpbRev, String grsTtlRev, String bsaCapa, String ldfRto, String lodTtlQty, String portDys) {
		this.portDys = portDys;
		this.lodTtlQty = lodTtlQty;
		this.freqNo = freqNo;
		this.iocCd = iocCd;
		this.simDt = simDt;
		this.trdCd = trdCd;
		this.sectNo = sectNo;
		this.rlaneCd = rlaneCd;
		this.simNo = simNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.ldfRto = ldfRto;
		this.bsaCapa = bsaCapa;
		this.ibflag = ibflag;
		this.grsRpbRev = grsRpbRev;
		this.grsTtlRev = grsTtlRev;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port_dys", getPortDys());
		this.hashColumns.put("lod_ttl_qty", getLodTtlQty());
		this.hashColumns.put("freq_no", getFreqNo());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("sim_dt", getSimDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("sect_no", getSectNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("sim_no", getSimNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ldf_rto", getLdfRto());
		this.hashColumns.put("bsa_capa", getBsaCapa());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grs_rpb_rev", getGrsRpbRev());
		this.hashColumns.put("grs_ttl_rev", getGrsTtlRev());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port_dys", "portDys");
		this.hashFields.put("lod_ttl_qty", "lodTtlQty");
		this.hashFields.put("freq_no", "freqNo");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("sim_dt", "simDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("sect_no", "sectNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("sim_no", "simNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ldf_rto", "ldfRto");
		this.hashFields.put("bsa_capa", "bsaCapa");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grs_rpb_rev", "grsRpbRev");
		this.hashFields.put("grs_ttl_rev", "grsTtlRev");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return portDys
	 */
	public String getPortDys() {
		return this.portDys;
	}
	
	/**
	 * Column Info
	 * @return lodTtlQty
	 */
	public String getLodTtlQty() {
		return this.lodTtlQty;
	}
	
	/**
	 * Column Info
	 * @return freqNo
	 */
	public String getFreqNo() {
		return this.freqNo;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return simDt
	 */
	public String getSimDt() {
		return this.simDt;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return sectNo
	 */
	public String getSectNo() {
		return this.sectNo;
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
	 * @return simNo
	 */
	public String getSimNo() {
		return this.simNo;
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
	 * @return ldfRto
	 */
	public String getLdfRto() {
		return this.ldfRto;
	}
	
	/**
	 * Column Info
	 * @return bsaCapa
	 */
	public String getBsaCapa() {
		return this.bsaCapa;
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
	 * @return grsRpbRev
	 */
	public String getGrsRpbRev() {
		return this.grsRpbRev;
	}
	
	/**
	 * Column Info
	 * @return grsTtlRev
	 */
	public String getGrsTtlRev() {
		return this.grsTtlRev;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param portDys
	 */
	public void setPortDys(String portDys) {
		this.portDys = portDys;
	}
	
	/**
	 * Column Info
	 * @param lodTtlQty
	 */
	public void setLodTtlQty(String lodTtlQty) {
		this.lodTtlQty = lodTtlQty;
	}
	
	/**
	 * Column Info
	 * @param freqNo
	 */
	public void setFreqNo(String freqNo) {
		this.freqNo = freqNo;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param simDt
	 */
	public void setSimDt(String simDt) {
		this.simDt = simDt;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param sectNo
	 */
	public void setSectNo(String sectNo) {
		this.sectNo = sectNo;
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
	 * @param simNo
	 */
	public void setSimNo(String simNo) {
		this.simNo = simNo;
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
	 * @param ldfRto
	 */
	public void setLdfRto(String ldfRto) {
		this.ldfRto = ldfRto;
	}
	
	/**
	 * Column Info
	 * @param bsaCapa
	 */
	public void setBsaCapa(String bsaCapa) {
		this.bsaCapa = bsaCapa;
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
	 * @param grsRpbRev
	 */
	public void setGrsRpbRev(String grsRpbRev) {
		this.grsRpbRev = grsRpbRev;
	}
	
	/**
	 * Column Info
	 * @param grsTtlRev
	 */
	public void setGrsTtlRev(String grsTtlRev) {
		this.grsTtlRev = grsTtlRev;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPortDys(JSPUtil.getParameter(request, "port_dys", ""));
		setLodTtlQty(JSPUtil.getParameter(request, "lod_ttl_qty", ""));
		setFreqNo(JSPUtil.getParameter(request, "freq_no", ""));
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setSimDt(JSPUtil.getParameter(request, "sim_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSectNo(JSPUtil.getParameter(request, "sect_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setSimNo(JSPUtil.getParameter(request, "sim_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLdfRto(JSPUtil.getParameter(request, "ldf_rto", ""));
		setBsaCapa(JSPUtil.getParameter(request, "bsa_capa", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGrsRpbRev(JSPUtil.getParameter(request, "grs_rpb_rev", ""));
		setGrsTtlRev(JSPUtil.getParameter(request, "grs_ttl_rev", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSimLaneRPBListVO[]
	 */
	public SearchSimLaneRPBListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSimLaneRPBListVO[]
	 */
	public SearchSimLaneRPBListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSimLaneRPBListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] portDys = (JSPUtil.getParameter(request, prefix	+ "port_dys", length));
			String[] lodTtlQty = (JSPUtil.getParameter(request, prefix	+ "lod_ttl_qty", length));
			String[] freqNo = (JSPUtil.getParameter(request, prefix	+ "freq_no", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] simDt = (JSPUtil.getParameter(request, prefix	+ "sim_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] sectNo = (JSPUtil.getParameter(request, prefix	+ "sect_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "sim_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ldfRto = (JSPUtil.getParameter(request, prefix	+ "ldf_rto", length));
			String[] bsaCapa = (JSPUtil.getParameter(request, prefix	+ "bsa_capa", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grsRpbRev = (JSPUtil.getParameter(request, prefix	+ "grs_rpb_rev", length));
			String[] grsTtlRev = (JSPUtil.getParameter(request, prefix	+ "grs_ttl_rev", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSimLaneRPBListVO();
				if (portDys[i] != null)
					model.setPortDys(portDys[i]);
				if (lodTtlQty[i] != null)
					model.setLodTtlQty(lodTtlQty[i]);
				if (freqNo[i] != null)
					model.setFreqNo(freqNo[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (simDt[i] != null)
					model.setSimDt(simDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (sectNo[i] != null)
					model.setSectNo(sectNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ldfRto[i] != null)
					model.setLdfRto(ldfRto[i]);
				if (bsaCapa[i] != null)
					model.setBsaCapa(bsaCapa[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grsRpbRev[i] != null)
					model.setGrsRpbRev(grsRpbRev[i]);
				if (grsTtlRev[i] != null)
					model.setGrsTtlRev(grsTtlRev[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSimLaneRPBListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSimLaneRPBListVO[]
	 */
	public SearchSimLaneRPBListVO[] getSearchSimLaneRPBListVOs(){
		SearchSimLaneRPBListVO[] vos = (SearchSimLaneRPBListVO[])models.toArray(new SearchSimLaneRPBListVO[models.size()]);
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
		this.portDys = this.portDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodTtlQty = this.lodTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freqNo = this.freqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simDt = this.simDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sectNo = this.sectNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ldfRto = this.ldfRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaCapa = this.bsaCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsRpbRev = this.grsRpbRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsTtlRev = this.grsTtlRev .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
