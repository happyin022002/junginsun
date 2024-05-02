/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ClzTmVO.java
*@FileTitle : ClzTmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.12 최영희
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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

public class ClzTmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ClzTmVO> models = new ArrayList<ClzTmVO>();

	/* Column Info */
	private String nmtp = null;
	/* Column Info */
	private String systemdate = null;
	/* Column Info */
	private String systemtime = null;
	/* Column Info */
	private String ntcFlg = null;
	/* Column Info */
	private String mnlSetUsrId = null;
	/* Column Info */
	private String clzTpCd = null;
	/* Column Info */
	private String manualupdatetime = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String updatebyname = null;
	/* Column Info */
	private String clzYdCd = null;
	/* Column Info */
	private String nm = null;
	/* Column Info */
	private String manualupdate = null;
	/* Column Info */
	private String sysSetDtDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ClzTmVO() {}

	public ClzTmVO(String ibflag, String pagerows, String nm, String nmtp, String clzTpCd, String clzYdCd, String systemdate, String systemtime, String manualupdate, String manualupdatetime, String mnlSetUsrId, String ntcFlg, String updatebyname, String sysSetDtDesc) {
		this.nmtp = nmtp;
		this.systemdate = systemdate;
		this.systemtime = systemtime;
		this.ntcFlg = ntcFlg;
		this.mnlSetUsrId = mnlSetUsrId;
		this.clzTpCd = clzTpCd;
		this.manualupdatetime = manualupdatetime;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.updatebyname = updatebyname;
		this.clzYdCd = clzYdCd;
		this.nm = nm;
		this.manualupdate = manualupdate;
		this.sysSetDtDesc = sysSetDtDesc;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("nmtp", getNmtp());
		this.hashColumns.put("systemdate", getSystemdate());
		this.hashColumns.put("systemtime", getSystemtime());
		this.hashColumns.put("ntc_flg", getNtcFlg());
		this.hashColumns.put("mnl_set_usr_id", getMnlSetUsrId());
		this.hashColumns.put("clz_tp_cd", getClzTpCd());
		this.hashColumns.put("manualupdatetime", getManualupdatetime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("updatebyname", getUpdatebyname());
		this.hashColumns.put("clz_yd_cd", getClzYdCd());
		this.hashColumns.put("nm", getNm());
		this.hashColumns.put("manualupdate", getManualupdate());
		this.hashColumns.put("sys_set_dt_desc", getSysSetDtDesc());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("nmtp", "nmtp");
		this.hashFields.put("systemdate", "systemdate");
		this.hashFields.put("systemtime", "systemtime");
		this.hashFields.put("ntc_flg", "ntcFlg");
		this.hashFields.put("mnl_set_usr_id", "mnlSetUsrId");
		this.hashFields.put("clz_tp_cd", "clzTpCd");
		this.hashFields.put("manualupdatetime", "manualupdatetime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("updatebyname", "updatebyname");
		this.hashFields.put("clz_yd_cd", "clzYdCd");
		this.hashFields.put("nm", "nm");
		this.hashFields.put("manualupdate", "manualupdate");
		this.hashFields.put("sys_set_dt_desc", "sysSetDtDesc");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return nmtp
	 */
	public String getNmtp() {
		return this.nmtp;
	}

	/**
	 * Column Info
	 * @return systemdate
	 */
	public String getSystemdate() {
		return this.systemdate;
	}

	/**
	 * Column Info
	 * @return systemtime
	 */
	public String getSystemtime() {
		return this.systemtime;
	}

	/**
	 * Column Info
	 * @return ntcFlg
	 */
	public String getNtcFlg() {
		return this.ntcFlg;
	}
	
	/**
	 * Column Info
	 * @return sysSetDtDesc
	 */
	public String getSysSetDtDesc() {
		return this.sysSetDtDesc;
	}

	/**
	 * Column Info
	 * @return mnlSetUsrId
	 */
	public String getMnlSetUsrId() {
		return this.mnlSetUsrId;
	}

	/**
	 * Column Info
	 * @return clzTpCd
	 */
	public String getClzTpCd() {
		return this.clzTpCd;
	}

	/**
	 * Column Info
	 * @return manualupdatetime
	 */
	public String getManualupdatetime() {
		return this.manualupdatetime;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return updatebyname
	 */
	public String getUpdatebyname() {
		return this.updatebyname;
	}

	/**
	 * Column Info
	 * @return clzYdCd
	 */
	public String getClzYdCd() {
		return this.clzYdCd;
	}

	/**
	 * Column Info
	 * @return nm
	 */
	public String getNm() {
		return this.nm;
	}

	/**
	 * Column Info
	 * @return manualupdate
	 */
	public String getManualupdate() {
		return this.manualupdate;
	}


	/**
	 * Column Info
	 * @param nmtp
	 */
	public void setNmtp(String nmtp) {
		this.nmtp = nmtp;
	}

	/**
	 * Column Info
	 * @param systemdate
	 */
	public void setSystemdate(String systemdate) {
		this.systemdate = systemdate;
	}

	/**
	 * Column Info
	 * @param systemtime
	 */
	public void setSystemtime(String systemtime) {
		this.systemtime = systemtime;
	}

	/**
	 * Column Info
	 * @param ntcFlg
	 */
	public void setNtcFlg(String ntcFlg) {
		this.ntcFlg = ntcFlg;
	}

	/**
	 * Column Info
	 * @param mnlSetUsrId
	 */
	public void setMnlSetUsrId(String mnlSetUsrId) {
		this.mnlSetUsrId = mnlSetUsrId;
	}

	/**
	 * Column Info
	 * @param clzTpCd
	 */
	public void setClzTpCd(String clzTpCd) {
		this.clzTpCd = clzTpCd;
	}

	/**
	 * Column Info
	 * @param manualupdatetime
	 */
	public void setManualupdatetime(String manualupdatetime) {
		this.manualupdatetime = manualupdatetime;
	}

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param updatebyname
	 */
	public void setUpdatebyname(String updatebyname) {
		this.updatebyname = updatebyname;
	}

	/**
	 * Column Info
	 * @param clzYdCd
	 */
	public void setClzYdCd(String clzYdCd) {
		this.clzYdCd = clzYdCd;
	}

	/**
	 * Column Info
	 * @param nm
	 */
	public void setNm(String nm) {
		this.nm = nm;
	}

	/**
	 * Column Info
	 * @param manualupdate
	 */
	public void setManualupdate(String manualupdate) {
		this.manualupdate = manualupdate;
	}
	
	/**
	 * Column Info
	 * @param sysSetDtDesc
	 */
	public void setSysSetDtDesc(String sysSetDtDesc) {
		this.sysSetDtDesc = sysSetDtDesc;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNmtp(JSPUtil.getParameter(request, "nmtp", ""));
		setSystemdate(JSPUtil.getParameter(request, "systemdate", ""));
		setSystemtime(JSPUtil.getParameter(request, "systemtime", ""));
		setNtcFlg(JSPUtil.getParameter(request, "ntc_flg", ""));
		setMnlSetUsrId(JSPUtil.getParameter(request, "mnl_set_usr_id", ""));
		setClzTpCd(JSPUtil.getParameter(request, "clz_tp_cd", ""));
		setManualupdatetime(JSPUtil.getParameter(request, "manualupdatetime", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUpdatebyname(JSPUtil.getParameter(request, "updatebyname", ""));
		setClzYdCd(JSPUtil.getParameter(request, "clz_yd_cd", ""));
		setNm(JSPUtil.getParameter(request, "nm", ""));
		setManualupdate(JSPUtil.getParameter(request, "manualupdate", ""));
		setSysSetDtDesc(JSPUtil.getParameter(request, "sys_set_dt_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ClzTmVO[]
	 */
	public ClzTmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ClzTmVO[]
	 */
	public ClzTmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ClzTmVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] nmtp = (JSPUtil.getParameter(request, prefix	+ "nmtp", length));
			String[] systemdate = (JSPUtil.getParameter(request, prefix	+ "systemdate", length));
			String[] systemtime = (JSPUtil.getParameter(request, prefix	+ "systemtime", length));
			String[] ntcFlg = (JSPUtil.getParameter(request, prefix	+ "ntc_flg", length));
			String[] mnlSetUsrId = (JSPUtil.getParameter(request, prefix	+ "mnl_set_usr_id", length));
			String[] clzTpCd = (JSPUtil.getParameter(request, prefix	+ "clz_tp_cd", length));
			String[] manualupdatetime = (JSPUtil.getParameter(request, prefix	+ "manualupdatetime", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] updatebyname = (JSPUtil.getParameter(request, prefix	+ "updatebyname", length));
			String[] clzYdCd = (JSPUtil.getParameter(request, prefix	+ "clz_yd_cd", length));
			String[] nm = (JSPUtil.getParameter(request, prefix	+ "nm", length));
			String[] manualupdate = (JSPUtil.getParameter(request, prefix	+ "manualupdate", length));
			String[] sysSetDtDesc = (JSPUtil.getParameter(request, prefix	+ "sys_set_dt_desc", length));

			for (int i = 0; i < length; i++) {
				model = new ClzTmVO();
				if (nmtp[i] != null)
					model.setNmtp(nmtp[i]);
				if (systemdate[i] != null)
					model.setSystemdate(systemdate[i]);
				if (systemtime[i] != null)
					model.setSystemtime(systemtime[i]);
				if (ntcFlg[i] != null)
					model.setNtcFlg(ntcFlg[i]);
				if (mnlSetUsrId[i] != null)
					model.setMnlSetUsrId(mnlSetUsrId[i]);
				if (clzTpCd[i] != null)
					model.setClzTpCd(clzTpCd[i]);
				if (manualupdatetime[i] != null)
					model.setManualupdatetime(manualupdatetime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (updatebyname[i] != null)
					model.setUpdatebyname(updatebyname[i]);
				if (clzYdCd[i] != null)
					model.setClzYdCd(clzYdCd[i]);
				if (nm[i] != null)
					model.setNm(nm[i]);
				if (manualupdate[i] != null)
					model.setManualupdate(manualupdate[i]);
				if (sysSetDtDesc[i] != null)
					model.setSysSetDtDesc(sysSetDtDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getClzTmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ClzTmVO[]
	 */
	public ClzTmVO[] getClzTmVOs(){
		ClzTmVO[] vos = (ClzTmVO[])models.toArray(new ClzTmVO[models.size()]);
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
		this.nmtp = this.nmtp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.systemdate = this.systemdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.systemtime = this.systemtime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcFlg = this.ntcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlSetUsrId = this.mnlSetUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clzTpCd = this.clzTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manualupdatetime = this.manualupdatetime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updatebyname = this.updatebyname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clzYdCd = this.clzYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nm = this.nm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manualupdate = this.manualupdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysSetDtDesc = this.sysSetDtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
