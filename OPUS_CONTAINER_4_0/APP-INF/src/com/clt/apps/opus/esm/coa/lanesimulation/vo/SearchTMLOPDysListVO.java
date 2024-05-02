/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchTMLOPDysListVO.java
*@FileTitle : SearchTMLOPDysListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 윤진영
*@LastVersion : 1.0
* 2009.09.23 윤진영 
* 1.0 Creation
* 2010.02.18 윤진영 미사용 변수 삭제
=========================================================*/

package com.clt.apps.opus.esm.coa.lanesimulation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 윤진영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchTMLOPDysListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchTMLOPDysListVO> models = new ArrayList<SearchTMLOPDysListVO>();
	
	/* Column Info */
	private String portDys = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String simDt = null;
	/* Column Info */
	private String sectNo = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String simNo = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String seaDys = null;
	/* Column Info */
	private String portSeq = null;
	/* Column Info */
	private String aplyVoyRto = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslDblCallSeq = null;
	/* Column Info */
	private String ttlTzDys = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String sLanCd = null;
	

	public String getSLanCd() {
		return sLanCd;
	}

	public void setSLanCd(String sLanCd) {
		this.sLanCd = sLanCd;
	}

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
	
	public SearchTMLOPDysListVO() {}

	public SearchTMLOPDysListVO(String ibflag, String pagerows, String trdCd, String rlaneCd, String skdDirCd, String vslDblCallSeq, String portSeq, String tmlCd, String portDys, String ttlTzDys, String seaDys, String aplyVoyRto, String simDt, String simNo, String sectNo, String updUsrId) {
		this.portDys = portDys;
		this.trdCd = trdCd;
		this.simDt = simDt;
		this.sectNo = sectNo;
		this.rlaneCd = rlaneCd;
		this.simNo = simNo;
		this.tmlCd = tmlCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.seaDys = seaDys;
		this.portSeq = portSeq;
		this.aplyVoyRto = aplyVoyRto;
		this.ibflag = ibflag;
		this.vslDblCallSeq = vslDblCallSeq;
		this.ttlTzDys = ttlTzDys;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port_dys", getPortDys());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("f_sim_dt", getSimDt());
		this.hashColumns.put("sect_no", getSectNo());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("f_sim_no", getSimNo());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sea_dys", getSeaDys());
		this.hashColumns.put("port_seq", getPortSeq());
		this.hashColumns.put("aply_voy_rto", getAplyVoyRto());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_dbl_call_seq", getVslDblCallSeq());
		this.hashColumns.put("ttl_tz_dys", getTtlTzDys());
		this.hashColumns.put("upd_usr_id",getUpdUsrId());
		this.hashColumns.put("f_slan_cd",getSLanCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port_dys", "portDys");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("f_sim_dt", "simDt");
		this.hashFields.put("sect_no", "sectNo");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("f_sim_no", "simNo");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sea_dys", "seaDys");
		this.hashFields.put("port_seq", "portSeq");
		this.hashFields.put("aply_voy_rto", "aplyVoyRto");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_dbl_call_seq", "vslDblCallSeq");
		this.hashFields.put("ttl_tz_dys", "ttlTzDys");
		this.hashFields.put("upd_usr_id", "UpdUsrId");
		this.hashFields.put("f_slan_cd", "SLanCd");
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
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
	 * @return seaDys
	 */
	public String getSeaDys() {
		return this.seaDys;
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
	 * @return aplyVoyRto
	 */
	public String getAplyVoyRto() {
		return this.aplyVoyRto;
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
	 * @return vslDblCallSeq
	 */
	public String getVslDblCallSeq() {
		return this.vslDblCallSeq;
	}
	
	/**
	 * Column Info
	 * @return ttlTzDys
	 */
	public String getTtlTzDys() {
		return this.ttlTzDys;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
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
	 * @param seaDys
	 */
	public void setSeaDys(String seaDys) {
		this.seaDys = seaDys;
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
	 * @param aplyVoyRto
	 */
	public void setAplyVoyRto(String aplyVoyRto) {
		this.aplyVoyRto = aplyVoyRto;
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
	 * @param vslDblCallSeq
	 */
	public void setVslDblCallSeq(String vslDblCallSeq) {
		this.vslDblCallSeq = vslDblCallSeq;
	}
	
	/**
	 * Column Info
	 * @param ttlTzDys
	 */
	public void setTtlTzDys(String ttlTzDys) {
		this.ttlTzDys = ttlTzDys;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPortDys(JSPUtil.getParameter(request, "port_dys", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setSimDt(JSPUtil.getParameter(request, "f_sim_dt", ""));
		setSectNo(JSPUtil.getParameter(request, "f_sect_no", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setSimNo(JSPUtil.getParameter(request, "f_sim_no", ""));
		setTmlCd(JSPUtil.getParameter(request, "tml_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSeaDys(JSPUtil.getParameter(request, "sea_dys", ""));
		setPortSeq(JSPUtil.getParameter(request, "port_seq", ""));
		setAplyVoyRto(JSPUtil.getParameter(request, "aply_voy_rto", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslDblCallSeq(JSPUtil.getParameter(request, "vsl_dbl_call_seq", ""));
		setTtlTzDys(JSPUtil.getParameter(request, "ttl_tz_dys", ""));
		setSLanCd(JSPUtil.getParameter(request, "f_slan_cd"));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchTMLOPDysListVO[]
	 */
	public SearchTMLOPDysListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchTMLOPDysListVO[]
	 */
	public SearchTMLOPDysListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchTMLOPDysListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] portDys = (JSPUtil.getParameter(request, prefix	+ "port_dys", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] simDt = (JSPUtil.getParameter(request, prefix	+ "f_sim_dt", length));
			String[] sectNo = (JSPUtil.getParameter(request, prefix	+ "sect_no", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] simNo = (JSPUtil.getParameter(request, prefix	+ "f_sim_no", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] seaDys = (JSPUtil.getParameter(request, prefix	+ "sea_dys", length));
			String[] portSeq = (JSPUtil.getParameter(request, prefix	+ "port_seq", length));
			String[] aplyVoyRto = (JSPUtil.getParameter(request, prefix	+ "aply_voy_rto", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslDblCallSeq = (JSPUtil.getParameter(request, prefix	+ "vsl_dbl_call_seq", length));
			String[] ttlTzDys = (JSPUtil.getParameter(request, prefix	+ "ttl_tz_dys", length));
			String[] sLanCd = (JSPUtil.getParameter(request, prefix	+ "f_slan_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchTMLOPDysListVO();
				if (portDys[i] != null)
					model.setPortDys(portDys[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (simDt[i] != null)
					model.setSimDt(simDt[i]);
				if (sectNo[i] != null)
					model.setSectNo(sectNo[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (simNo[i] != null)
					model.setSimNo(simNo[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (seaDys[i] != null)
					model.setSeaDys(seaDys[i]);
				if (portSeq[i] != null)
					model.setPortSeq(portSeq[i]);
				if (aplyVoyRto[i] != null)
					model.setAplyVoyRto(aplyVoyRto[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslDblCallSeq[i] != null)
					model.setVslDblCallSeq(vslDblCallSeq[i]);
				if (ttlTzDys[i] != null)
					model.setTtlTzDys(ttlTzDys[i]);
				if (sLanCd[i] != null)
					model.setSLanCd(sLanCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchTMLOPDysListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchTMLOPDysListVO[]
	 */
	public SearchTMLOPDysListVO[] getSearchTMLOPDysListVOs(){
		SearchTMLOPDysListVO[] vos = (SearchTMLOPDysListVO[])models.toArray(new SearchTMLOPDysListVO[models.size()]);
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
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simDt = this.simDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sectNo = this.sectNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.simNo = this.simNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seaDys = this.seaDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portSeq = this.portSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyVoyRto = this.aplyVoyRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDblCallSeq = this.vslDblCallSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTzDys = this.ttlTzDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sLanCd = this.sLanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	/*	테이블 컬럼의  등록 값을 저장하는  List */
	private List updateList = null;	
	
	/** 등록 리스트 Getter */
	public List getMultiUpdateList(){	
		return updateList;
	}
	/** 등록 리스트 Setter */
	public void setMultiUpdateList(List list){	
		this.updateList = list;
	}			
}
