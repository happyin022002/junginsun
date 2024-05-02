/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ConCBookingCountVO.java
*@FileTitle : ConCBookingCountVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.25 우경민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

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
 * @author 우경민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ConCBookingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ConCBookingVO> models = new ArrayList<ConCBookingVO>();
	
	/* Column Info */
	private String cgoType = null;
	/* Column Info */
	private String loclType = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String viewtype = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mvmtStsCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String mvType = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String flgrslt = null;
	/* Column Info */
	private String fullFg = null;
	/* Column Info */
	private String vlsCd = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String svrId = null;
	/* Column Info */
	private String pYard = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ConCBookingVO() {}

	public ConCBookingVO(String ibflag, String pagerows, String flgrslt, String viewtype, String cntrNo, String cntrTpszCd, String fullFg, String mvmtStsCd, String bkgNo, String vlsCd, String polCd, String mvType, String cgoType, String loclType, String orgYdCd, String evntDt, String svrId, String pYard) {
		this.cgoType = cgoType;
		this.loclType = loclType;
		this.pagerows = pagerows;
		this.viewtype = viewtype;
		this.ibflag = ibflag;
		this.mvmtStsCd = mvmtStsCd;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.mvType = mvType;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.flgrslt = flgrslt;
		this.fullFg = fullFg;
		this.vlsCd = vlsCd;
		this.orgYdCd = orgYdCd;
		this.evntDt = evntDt;
		this.svrId = svrId;
		this.pYard = pYard;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cgo_type", getCgoType());
		this.hashColumns.put("locl_type", getLoclType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("viewtype", getViewtype());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("mv_type", getMvType());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("flgrslt", getFlgrslt());
		this.hashColumns.put("full_fg", getFullFg());
		this.hashColumns.put("vls_cd", getVlsCd());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("p_yard", getPYard());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cgo_type", "cgoType");
		this.hashFields.put("locl_type", "loclType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("viewtype", "viewtype");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("mv_type", "mvType");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("flgrslt", "flgrslt");
		this.hashFields.put("full_fg", "fullFg");
		this.hashFields.put("vls_cd", "vlsCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("p_yard", "pYard");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cgoType
	 */
	public String getCgoType() {
		return this.cgoType;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}

	/**
	 * Column Info
	 * @return orgYdcd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}
	
	/**
	 * Column Info
	 * @return loclType
	 */
	public String getLoclType() {
		return this.loclType;
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
	 * @return viewtype
	 */
	public String getViewtype() {
		return this.viewtype;
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
	 * @return mvmtStsCd
	 */
	public String getMvmtStsCd() {
		return this.mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return mvType
	 */
	public String getMvType() {
		return this.mvType;
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
	 * @return flgrslt
	 */
	public String getFlgrslt() {
		return this.flgrslt;
	}
	
	/**
	 * Column Info
	 * @return fullFg
	 */
	public String getFullFg() {
		return this.fullFg;
	}
	
	/**
	 * Column Info
	 * @return vlsCd
	 */
	public String getVlsCd() {
		return this.vlsCd;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
	}
	/**
	 * Column Info
	 * @return pYard
	 */
	public String getPYard() {
		return this.pYard;
	}

	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}

	/**
	 * Column Info
	 * @param cgoType
	 */
	public void setCgoType(String cgoType) {
		this.cgoType = cgoType;
	}

	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}
	
	/**
	 * Column Info
	 * @param loclType
	 */
	public void setLoclType(String loclType) {
		this.loclType = loclType;
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
	 * @param viewtype
	 */
	public void setViewtype(String viewtype) {
		this.viewtype = viewtype;
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
	 * @param mvmtStsCd
	 */
	public void setMvmtStsCd(String mvmtStsCd) {
		this.mvmtStsCd = mvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param mvType
	 */
	public void setMvType(String mvType) {
		this.mvType = mvType;
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
	 * @param flgrslt
	 */
	public void setFlgrslt(String flgrslt) {
		this.flgrslt = flgrslt;
	}
	
	/**
	 * Column Info
	 * @param fullFg
	 */
	public void setFullFg(String fullFg) {
		this.fullFg = fullFg;
	}
	
	/**
	 * Column Info
	 * @param vlsCd
	 */
	public void setVlsCd(String vlsCd) {
		this.vlsCd = vlsCd;
	}
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
	}
	/**
	 * Column Info
	 * @param pYard
	 */
	public void setPYard(String pYard) {
		this.pYard = pYard;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCgoType(JSPUtil.getParameter(request, "cgo_type", ""));
		setLoclType(JSPUtil.getParameter(request, "locl_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setViewtype(JSPUtil.getParameter(request, "viewtype", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMvmtStsCd(JSPUtil.getParameter(request, "mvmt_sts_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setMvType(JSPUtil.getParameter(request, "mv_type", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setFlgrslt(JSPUtil.getParameter(request, "flgrslt", ""));
		setFullFg(JSPUtil.getParameter(request, "full_fg", ""));
		setVlsCd(JSPUtil.getParameter(request, "vls_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setSvrId(JSPUtil.getParameter(request, "svr_id", ""));
		setPYard(JSPUtil.getParameter(request, "p_yard", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ConCBookingVO[]
	 */
	public ConCBookingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ConCBookingVO[]
	 */
	public ConCBookingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ConCBookingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cgoType = (JSPUtil.getParameter(request, prefix	+ "cgo_type", length));
			String[] loclType = (JSPUtil.getParameter(request, prefix	+ "locl_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] viewtype = (JSPUtil.getParameter(request, prefix	+ "viewtype", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] mvType = (JSPUtil.getParameter(request, prefix	+ "mv_type", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] flgrslt = (JSPUtil.getParameter(request, prefix	+ "flgrslt", length));
			String[] fullFg = (JSPUtil.getParameter(request, prefix	+ "full_fg", length));
			String[] vlsCd = (JSPUtil.getParameter(request, prefix	+ "vls_cd", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] pYard = (JSPUtil.getParameter(request, prefix	+ "p_yard", length));
			for (int i = 0; i < length; i++) {
				model = new ConCBookingVO();
				if (cgoType[i] != null)
					model.setCgoType(cgoType[i]);
				if (loclType[i] != null)
					model.setLoclType(loclType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (viewtype[i] != null)
					model.setViewtype(viewtype[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mvmtStsCd[i] != null)
					model.setMvmtStsCd(mvmtStsCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (mvType[i] != null)
					model.setMvType(mvType[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (flgrslt[i] != null)
					model.setFlgrslt(flgrslt[i]);
				if (fullFg[i] != null)
					model.setFullFg(fullFg[i]);
				if (vlsCd[i] != null)
					model.setVlsCd(vlsCd[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (pYard[i] != null)
					model.setPYard(svrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getConCBookingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ConCBookingVO[]
	 */
	public ConCBookingVO[] getConCBookingVOs(){
		ConCBookingVO[] vos = (ConCBookingVO[])models.toArray(new ConCBookingVO[models.size()]);
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
		this.cgoType = this.cgoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclType = this.loclType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewtype = this.viewtype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd = this.mvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvType = this.mvType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flgrslt = this.flgrslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFg = this.fullFg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vlsCd = this.vlsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
