/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaInbondManifestListCondVO.java
*@FileTitle : UsaInbondManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.21 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondListCondVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaInbondManifestListCondVO extends InbondListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaInbondManifestListCondVO> models = new ArrayList<UsaInbondManifestListCondVO>();
	
	/* Column Info */
	private String tod = null;
	/* Column Info */
	private String fromd = null;
	/* Column Info */
	private String arrDt = null;
	/* Column Info */
	private String hPod = null;
	/* Column Info */
	private String ediError = null;
	/* Column Info */
	private String hub = null;
	/* Column Info */
	private String fromt = null;
	/* Column Info */
	private String hHub = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ibdTpCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String hVvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tot = null;
	/* Column Info */
	private String arrGubun = null;
	/* Column Info */
	private String blCntrGubun = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String xptDt = null;
	/* Column Info */
	private String hDel = null;
	/* Column Info */
	private String hCstms = null;
	/* Column Info */
	private String eqOfc = null;
	/* Column Info */
	private String pod = null;
	/** Table Value Object 단건 처리  */
	private UsaInbondManifestListVO usaInbondManifestListVO = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaInbondManifestListCondVO() {}

	public UsaInbondManifestListCondVO(String ibflag, String pagerows, String vvd, String pod, String hub, String fromd, String fromt, String tod, String tot, String ibdTpCd, String arrDt, String xptDt, String ediError, String arrGubun, String eqOfc, String blCntrGubun, String pageNo, String hVvd, String hPod, String hHub, String hDel, String hCstms) {
		this.tod = tod;
		this.fromd = fromd;
		this.arrDt = arrDt;
		this.hPod = hPod;
		this.ediError = ediError;
		this.hub = hub;
		this.fromt = fromt;
		this.hHub = hHub;
		this.pagerows = pagerows;
		this.ibdTpCd = ibdTpCd;
		this.vvd = vvd;
		this.hVvd = hVvd;
		this.ibflag = ibflag;
		this.tot = tot;
		this.arrGubun = arrGubun;
		this.blCntrGubun = blCntrGubun;
		this.pageNo = pageNo;
		this.xptDt = xptDt;
		this.hDel = hDel;
		this.hCstms = hCstms;
		this.eqOfc = eqOfc;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tod", getTod());
		this.hashColumns.put("fromd", getFromd());
		this.hashColumns.put("arr_dt", getArrDt());
		this.hashColumns.put("h_pod", getHPod());
		this.hashColumns.put("edi_error", getEdiError());
		this.hashColumns.put("hub", getHub());
		this.hashColumns.put("fromt", getFromt());
		this.hashColumns.put("h_hub", getHHub());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibd_tp_cd", getIbdTpCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("h_vvd", getHVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tot", getTot());
		this.hashColumns.put("arr_gubun", getArrGubun());
		this.hashColumns.put("bl_cntr_gubun", getBlCntrGubun());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("xpt_dt", getXptDt());
		this.hashColumns.put("h_del", getHDel());
		this.hashColumns.put("h_cstms", getHCstms());
		this.hashColumns.put("eq_ofc", getEqOfc());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tod", "tod");
		this.hashFields.put("fromd", "fromd");
		this.hashFields.put("arr_dt", "arrDt");
		this.hashFields.put("h_pod", "hPod");
		this.hashFields.put("edi_error", "ediError");
		this.hashFields.put("hub", "hub");
		this.hashFields.put("fromt", "fromt");
		this.hashFields.put("h_hub", "hHub");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibd_tp_cd", "ibdTpCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("h_vvd", "hVvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tot", "tot");
		this.hashFields.put("arr_gubun", "arrGubun");
		this.hashFields.put("bl_cntr_gubun", "blCntrGubun");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("xpt_dt", "xptDt");
		this.hashFields.put("h_del", "hDel");
		this.hashFields.put("h_cstms", "hCstms");
		this.hashFields.put("eq_ofc", "eqOfc");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public UsaInbondManifestListVO getUsaInbondManifestListVO() {
		return this.usaInbondManifestListVO;
	}
	
	/**
	 * Column Info
	 * @return tod
	 */
	public String getTod() {
		return this.tod;
	}
	
	/**
	 * Column Info
	 * @return fromd
	 */
	public String getFromd() {
		return this.fromd;
	}
	
	/**
	 * Column Info
	 * @return arrDt
	 */
	public String getArrDt() {
		return this.arrDt;
	}
	
	/**
	 * Column Info
	 * @return hPod
	 */
	public String getHPod() {
		return this.hPod;
	}
	
	/**
	 * Column Info
	 * @return ediError
	 */
	public String getEdiError() {
		return this.ediError;
	}
	
	/**
	 * Column Info
	 * @return hub
	 */
	public String getHub() {
		return this.hub;
	}
	
	/**
	 * Column Info
	 * @return fromt
	 */
	public String getFromt() {
		return this.fromt;
	}
	
	/**
	 * Column Info
	 * @return hHub
	 */
	public String getHHub() {
		return this.hHub;
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
	 * @return ibdTpCd
	 */
	public String getIbdTpCd() {
		return this.ibdTpCd;
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
	 * @return hVvd
	 */
	public String getHVvd() {
		return this.hVvd;
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
	 * @return tot
	 */
	public String getTot() {
		return this.tot;
	}
	
	/**
	 * Column Info
	 * @return arrGubun
	 */
	public String getArrGubun() {
		return this.arrGubun;
	}
	
	/**
	 * Column Info
	 * @return blCntrGubun
	 */
	public String getBlCntrGubun() {
		return this.blCntrGubun;
	}
	
	/**
	 * Column Info
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return xptDt
	 */
	public String getXptDt() {
		return this.xptDt;
	}
	
	/**
	 * Column Info
	 * @return hDel
	 */
	public String getHDel() {
		return this.hDel;
	}
	
	/**
	 * Column Info
	 * @return hCstms
	 */
	public String getHCstms() {
		return this.hCstms;
	}
	
	/**
	 * Column Info
	 * @return eqOfc
	 */
	public String getEqOfc() {
		return this.eqOfc;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	

	/**
	 * Column Info
	 * @param UsaInbondManifestListVO
	 */
	public void setUsaInbondManifestListVO(UsaInbondManifestListVO usaInbondManifestListVO){
		this.usaInbondManifestListVO = usaInbondManifestListVO;
	}
	
	/**
	 * Column Info
	 * @param tod
	 */
	public void setTod(String tod) {
		this.tod = tod;
	}
	
	/**
	 * Column Info
	 * @param fromd
	 */
	public void setFromd(String fromd) {
		this.fromd = fromd;
	}
	
	/**
	 * Column Info
	 * @param arrDt
	 */
	public void setArrDt(String arrDt) {
		this.arrDt = arrDt;
	}
	
	/**
	 * Column Info
	 * @param hPod
	 */
	public void setHPod(String hPod) {
		this.hPod = hPod;
	}
	
	/**
	 * Column Info
	 * @param ediError
	 */
	public void setEdiError(String ediError) {
		this.ediError = ediError;
	}
	
	/**
	 * Column Info
	 * @param hub
	 */
	public void setHub(String hub) {
		this.hub = hub;
	}
	
	/**
	 * Column Info
	 * @param fromt
	 */
	public void setFromt(String fromt) {
		this.fromt = fromt;
	}
	
	/**
	 * Column Info
	 * @param hHub
	 */
	public void setHHub(String hHub) {
		this.hHub = hHub;
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
	 * @param ibdTpCd
	 */
	public void setIbdTpCd(String ibdTpCd) {
		this.ibdTpCd = ibdTpCd;
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
	 * @param hVvd
	 */
	public void setHVvd(String hVvd) {
		this.hVvd = hVvd;
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
	 * @param tot
	 */
	public void setTot(String tot) {
		this.tot = tot;
	}
	
	/**
	 * Column Info
	 * @param arrGubun
	 */
	public void setArrGubun(String arrGubun) {
		this.arrGubun = arrGubun;
	}
	
	/**
	 * Column Info
	 * @param blCntrGubun
	 */
	public void setBlCntrGubun(String blCntrGubun) {
		this.blCntrGubun = blCntrGubun;
	}
	
	/**
	 * Column Info
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param xptDt
	 */
	public void setXptDt(String xptDt) {
		this.xptDt = xptDt;
	}
	
	/**
	 * Column Info
	 * @param hDel
	 */
	public void setHDel(String hDel) {
		this.hDel = hDel;
	}
	
	/**
	 * Column Info
	 * @param hCstms
	 */
	public void setHCstms(String hCstms) {
		this.hCstms = hCstms;
	}
	
	/**
	 * Column Info
	 * @param eqOfc
	 */
	public void setEqOfc(String eqOfc) {
		this.eqOfc = eqOfc;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTod(JSPUtil.getParameter(request, "tod", ""));
		setFromd(JSPUtil.getParameter(request, "fromd", ""));
		setArrDt(JSPUtil.getParameter(request, "arr_dt", ""));
		setHPod(JSPUtil.getParameter(request, "h_pod", ""));
		setEdiError(JSPUtil.getParameter(request, "edi_error", ""));
		setHub(JSPUtil.getParameter(request, "hub", ""));
		setFromt(JSPUtil.getParameter(request, "fromt", ""));
		setHHub(JSPUtil.getParameter(request, "h_hub", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbdTpCd(JSPUtil.getParameter(request, "ibd_tp_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setHVvd(JSPUtil.getParameter(request, "h_vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTot(JSPUtil.getParameter(request, "tot", ""));
		setArrGubun(JSPUtil.getParameter(request, "arr_gubun", ""));
		setBlCntrGubun(JSPUtil.getParameter(request, "bl_cntr_gubun", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setXptDt(JSPUtil.getParameter(request, "xpt_dt", ""));
		setHDel(JSPUtil.getParameter(request, "h_del", ""));
		setHCstms(JSPUtil.getParameter(request, "h_cstms", ""));
		setEqOfc(JSPUtil.getParameter(request, "eq_ofc", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaInbondManifestListCondVO[]
	 */
	public UsaInbondManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaInbondManifestListCondVO[]
	 */
	public UsaInbondManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaInbondManifestListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] tod = (JSPUtil.getParameter(request, prefix	+ "tod", length));
			String[] fromd = (JSPUtil.getParameter(request, prefix	+ "fromd", length));
			String[] arrDt = (JSPUtil.getParameter(request, prefix	+ "arr_dt", length));
			String[] hPod = (JSPUtil.getParameter(request, prefix	+ "h_pod", length));
			String[] ediError = (JSPUtil.getParameter(request, prefix	+ "edi_error", length));
			String[] hub = (JSPUtil.getParameter(request, prefix	+ "hub", length));
			String[] fromt = (JSPUtil.getParameter(request, prefix	+ "fromt", length));
			String[] hHub = (JSPUtil.getParameter(request, prefix	+ "h_hub", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibdTpCd = (JSPUtil.getParameter(request, prefix	+ "ibd_tp_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] hVvd = (JSPUtil.getParameter(request, prefix	+ "h_vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tot = (JSPUtil.getParameter(request, prefix	+ "tot", length));
			String[] arrGubun = (JSPUtil.getParameter(request, prefix	+ "arr_gubun", length));
			String[] blCntrGubun = (JSPUtil.getParameter(request, prefix	+ "bl_cntr_gubun", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] xptDt = (JSPUtil.getParameter(request, prefix	+ "xpt_dt", length));
			String[] hDel = (JSPUtil.getParameter(request, prefix	+ "h_del", length));
			String[] hCstms = (JSPUtil.getParameter(request, prefix	+ "h_cstms", length));
			String[] eqOfc = (JSPUtil.getParameter(request, prefix	+ "eq_ofc", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaInbondManifestListCondVO();
				if (tod[i] != null)
					model.setTod(tod[i]);
				if (fromd[i] != null)
					model.setFromd(fromd[i]);
				if (arrDt[i] != null)
					model.setArrDt(arrDt[i]);
				if (hPod[i] != null)
					model.setHPod(hPod[i]);
				if (ediError[i] != null)
					model.setEdiError(ediError[i]);
				if (hub[i] != null)
					model.setHub(hub[i]);
				if (fromt[i] != null)
					model.setFromt(fromt[i]);
				if (hHub[i] != null)
					model.setHHub(hHub[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibdTpCd[i] != null)
					model.setIbdTpCd(ibdTpCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (hVvd[i] != null)
					model.setHVvd(hVvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tot[i] != null)
					model.setTot(tot[i]);
				if (arrGubun[i] != null)
					model.setArrGubun(arrGubun[i]);
				if (blCntrGubun[i] != null)
					model.setBlCntrGubun(blCntrGubun[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (xptDt[i] != null)
					model.setXptDt(xptDt[i]);
				if (hDel[i] != null)
					model.setHDel(hDel[i]);
				if (hCstms[i] != null)
					model.setHCstms(hCstms[i]);
				if (eqOfc[i] != null)
					model.setEqOfc(eqOfc[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaInbondManifestListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaInbondManifestListCondVO[]
	 */
	public UsaInbondManifestListCondVO[] getUsaInbondManifestListCondVOs(){
		UsaInbondManifestListCondVO[] vos = (UsaInbondManifestListCondVO[])models.toArray(new UsaInbondManifestListCondVO[models.size()]);
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
		this.tod = this.tod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromd = this.fromd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt = this.arrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hPod = this.hPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediError = this.ediError .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hub = this.hub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromt = this.fromt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hHub = this.hHub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibdTpCd = this.ibdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hVvd = this.hVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot = this.tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrGubun = this.arrGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCntrGubun = this.blCntrGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xptDt = this.xptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hDel = this.hDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hCstms = this.hCstms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOfc = this.eqOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
