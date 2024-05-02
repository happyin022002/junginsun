/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffListGRPVO.java
*@FileTitle : TariffListGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.10.05 정명훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

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
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TariffListGRPVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TariffListGRPVO> models = new ArrayList<TariffListGRPVO>();
	
	/* Column Info */
	private String updMnuNo = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String cplsFlg = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String ver = null;
	/* Column Info */
	private String ydChgNo = null;
	/* Column Info */
	private String issCtyCd = null;
	/* Column Info */
	private String orgVndrNm = null;
	/* Column Info */
	private String portTrfUrl = null;
	/* Column Info */
	private String portTrfRmk = null;	
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TariffListGRPVO() {}

	public TariffListGRPVO(String ibflag, String pagerows, String ydChgNo, String ver, String effDt, String expDt, String currCd, String cplsFlg, String orgVndrNm, String issCtyCd, String updMnuNo, String portTrfUrl, String portTrfRmk) {
		this.updMnuNo = updMnuNo;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.currCd = currCd;
		this.cplsFlg = cplsFlg;
		this.expDt = expDt;
		this.ver = ver;
		this.ydChgNo = ydChgNo;
		this.issCtyCd = issCtyCd;
		this.orgVndrNm = orgVndrNm;
		this.portTrfUrl = portTrfUrl;
		this.portTrfRmk = portTrfRmk;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_mnu_no", getUpdMnuNo());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cpls_flg", getCplsFlg());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("ver", getVer());
		this.hashColumns.put("yd_chg_no", getYdChgNo());
		this.hashColumns.put("iss_cty_cd", getIssCtyCd());
		this.hashColumns.put("org_vndr_nm", getOrgVndrNm());
		this.hashColumns.put("port_trf_url", getPortTrfUrl());
		this.hashColumns.put("port_trf_rmk", getPortTrfRmk());		
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_mnu_no", "updMnuNo");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cpls_flg", "cplsFlg");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("ver", "ver");
		this.hashFields.put("yd_chg_no", "ydChgNo");
		this.hashFields.put("iss_cty_cd", "issCtyCd");
		this.hashFields.put("org_vndr_nm", "orgVndrNm");
		this.hashFields.put("port_trf_url", "portTrfUrl");
		this.hashFields.put("port_trf_rmk", "portTrfRmk");		
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updMnuNo
	 */
	public String getUpdMnuNo() {
		return this.updMnuNo;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return cplsFlg
	 */
	public String getCplsFlg() {
		return this.cplsFlg;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return ver
	 */
	public String getVer() {
		return this.ver;
	}
	
	/**
	 * Column Info
	 * @return ydChgNo
	 */
	public String getYdChgNo() {
		return this.ydChgNo;
	}
	
	/**
	 * Column Info
	 * @return issCtyCd
	 */
	public String getIssCtyCd() {
		return this.issCtyCd;
	}
	
	/**
	 * Column Info
	 * @return orgVndrNm
	 */
	public String getOrgVndrNm() {
		return this.orgVndrNm;
	}
	
	/**
	 * Column Info
	 * @return portTrfUrl
	 */
	public String getPortTrfUrl() {
		return this.portTrfUrl;
	}

	/**
	 * Column Info
	 * @return portTrfRmk
	 */
	public String getPortTrfRmk() {
		return this.portTrfRmk;
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
	 * @param updMnuNo
	 */
	public void setUpdMnuNo(String updMnuNo) {
		this.updMnuNo = updMnuNo;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param cplsFlg
	 */
	public void setCplsFlg(String cplsFlg) {
		this.cplsFlg = cplsFlg;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param ver
	 */
	public void setVer(String ver) {
		this.ver = ver;
	}
	
	/**
	 * Column Info
	 * @param ydChgNo
	 */
	public void setYdChgNo(String ydChgNo) {
		this.ydChgNo = ydChgNo;
	}
	
	/**
	 * Column Info
	 * @param issCtyCd
	 */
	public void setIssCtyCd(String issCtyCd) {
		this.issCtyCd = issCtyCd;
	}
	
	/**
	 * Column Info
	 * @param orgVndrNm
	 */
	public void setOrgVndrNm(String orgVndrNm) {
		this.orgVndrNm = orgVndrNm;
	}
	
	/**
	 * Column Info
	 * @param portTrfUrl
	 */
	public void setPortTrfUrl(String portTrfUrl) {
		this.portTrfUrl = portTrfUrl;
	}

	/**
	 * Column Info
	 * @param portTrfRmk
	 */
	public void setPortTrfRmk(String portTrfRmk) {
		this.portTrfRmk = portTrfRmk;
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
		setUpdMnuNo(JSPUtil.getParameter(request, "upd_mnu_no", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setCplsFlg(JSPUtil.getParameter(request, "cpls_flg", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setVer(JSPUtil.getParameter(request, "ver", ""));
		setYdChgNo(JSPUtil.getParameter(request, "yd_chg_no", ""));
		setIssCtyCd(JSPUtil.getParameter(request, "iss_cty_cd", ""));
		setOrgVndrNm(JSPUtil.getParameter(request, "org_vndr_nm", ""));
		setPortTrfUrl(JSPUtil.getParameter(request, "port_trf_url", ""));
		setPortTrfRmk(JSPUtil.getParameter(request, "port_trf_rmk", ""));		
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TariffListGRPVO[]
	 */
	public TariffListGRPVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TariffListGRPVO[]
	 */
	public TariffListGRPVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TariffListGRPVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updMnuNo = (JSPUtil.getParameter(request, prefix	+ "upd_mnu_no", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] cplsFlg = (JSPUtil.getParameter(request, prefix	+ "cpls_flg", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] ver = (JSPUtil.getParameter(request, prefix	+ "ver", length));
			String[] ydChgNo = (JSPUtil.getParameter(request, prefix	+ "yd_chg_no", length));
			String[] issCtyCd = (JSPUtil.getParameter(request, prefix	+ "iss_cty_cd", length));
			String[] orgVndrNm = (JSPUtil.getParameter(request, prefix	+ "org_vndr_nm", length));
			String[] portTrfUrl = (JSPUtil.getParameter(request, prefix	+ "port_trf_url", length));
			String[] portTrfRmk = (JSPUtil.getParameter(request, prefix	+ "port_trf_rmk", length));			
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TariffListGRPVO();
				if (updMnuNo[i] != null)
					model.setUpdMnuNo(updMnuNo[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (cplsFlg[i] != null)
					model.setCplsFlg(cplsFlg[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (ver[i] != null)
					model.setVer(ver[i]);
				if (ydChgNo[i] != null)
					model.setYdChgNo(ydChgNo[i]);
				if (issCtyCd[i] != null)
					model.setIssCtyCd(issCtyCd[i]);
				if (orgVndrNm[i] != null)
					model.setOrgVndrNm(orgVndrNm[i]);
				if (portTrfUrl[i] != null)
					model.setPortTrfUrl(portTrfUrl[i]);
				if (portTrfRmk[i] != null)
					model.setPortTrfRmk(portTrfRmk[i]);				
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTariffListGRPVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TariffListGRPVO[]
	 */
	public TariffListGRPVO[] getTariffListGRPVOs(){
		TariffListGRPVO[] vos = (TariffListGRPVO[])models.toArray(new TariffListGRPVO[models.size()]);
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
		this.updMnuNo = this.updMnuNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cplsFlg = this.cplsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ver = this.ver .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgNo = this.ydChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issCtyCd = this.issCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgVndrNm = this.orgVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTrfUrl = this.portTrfUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portTrfRmk = this.portTrfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}