/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0108ModifyCombineExecutionVO.java
*@FileTitle : EesEqr0108ModifyCombineExecutionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.08.19 정은호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정은호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr0108ModifyCombineExecutionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr0108ModifyCombineExecutionVO> models = new ArrayList<EesEqr0108ModifyCombineExecutionVO>();
	
	/* Column Info */
	private String coCd = null;
	/* Column Info */
	private String t1Cntrno = null;
	/* Column Info */
	private String reason = null;
	/* Column Info */
	private String dt1 = null;
	/* Column Info */
	private String plnYrwk = null;
	/* Column Info */
	private String dt2 = null;
	/* Column Info */
	private String dt3 = null;
	/* Column Info */
	private String t1Tpszno = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String ecc1 = null;
	/* Column Info */
	private String ecc2 = null;
	/* Column Info */
	private String ecc3 = null;
	/* Column Info */
	private String yd2 = null;
	/* Column Info */
	private String yd1 = null;
	/* Column Info */
	private String yd3 = null;
	/* Column Info */
	private String repoPlnFbRmk = null;
	/* Column Info */
	private String eqRepoPurpCd = null;
	/* Column Info */
	private String trspMode = null;
	/* input Param */
	private List<String> tpszArr = null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, Object> hashObject = new HashMap<String, Object>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr0108ModifyCombineExecutionVO() {}

	public EesEqr0108ModifyCombineExecutionVO(String ibflag, String pagerows , String plnYrwk, String coCd, String yd1, String yd2, String yd3, String dt1, String dt2, String dt3, String eqRepoPurpCd, String vvd, String reason, String repoPlnFbRmk, String ecc1, String ecc2, String ecc3, String trspMode, String lane, String t1Cntrno, String t1Tpszno) {
		this.coCd = coCd;
		this.t1Cntrno = t1Cntrno;
		this.reason = reason;
		this.dt1 = dt1;
		this.plnYrwk = plnYrwk;
		this.dt2 = dt2;
		this.dt3 = dt3;
		this.t1Tpszno = t1Tpszno;
		this.lane = lane;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.ecc1 = ecc1;
		this.ecc2 = ecc2;
		this.ecc3 = ecc3;
		this.yd2 = yd2;
		this.yd1 = yd1;
		this.yd3 = yd3;
		this.repoPlnFbRmk = repoPlnFbRmk;
		this.eqRepoPurpCd = eqRepoPurpCd;
		this.trspMode = trspMode;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("co_cd", getCoCd());
		this.hashColumns.put("t1_cntrno", getT1Cntrno());
		this.hashColumns.put("reason", getReason());
		this.hashColumns.put("dt1", getDt1());
		this.hashColumns.put("pln_yrwk", getPlnYrwk());
		this.hashColumns.put("dt2", getDt2());
		this.hashColumns.put("dt3", getDt3());
		this.hashColumns.put("t1_tpszno", getT1Tpszno());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ecc1", getEcc1());
		this.hashColumns.put("ecc2", getEcc2());
		this.hashColumns.put("ecc3", getEcc3());
		this.hashColumns.put("yd2", getYd2());
		this.hashColumns.put("yd1", getYd1());
		this.hashColumns.put("yd3", getYd3());
		this.hashColumns.put("repo_pln_fb_rmk", getRepoPlnFbRmk());
		this.hashColumns.put("eq_repo_purp_cd", getEqRepoPurpCd());
		this.hashColumns.put("trsp_mode", getTrspMode());
		return this.hashColumns;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, Object> getColumnObjectValues(){
		this.hashObject.put("co_cd", getCoCd());
		this.hashObject.put("t1_cntrno", getT1Cntrno());
		this.hashObject.put("reason", getReason());
		this.hashObject.put("dt1", getDt1());
		this.hashObject.put("pln_yrwk", getPlnYrwk());
		this.hashObject.put("dt2", getDt2());
		this.hashObject.put("dt3", getDt3());
		this.hashObject.put("t1_tpszno", getT1Tpszno());
		this.hashObject.put("lane", getLane());
		this.hashObject.put("pagerows", getPagerows());
		this.hashObject.put("vvd", getVvd());
		this.hashObject.put("ibflag", getIbflag());
		this.hashObject.put("ecc1", getEcc1());
		this.hashObject.put("ecc2", getEcc2());
		this.hashObject.put("ecc3", getEcc3());
		this.hashObject.put("yd2", getYd2());
		this.hashObject.put("yd1", getYd1());
		this.hashObject.put("yd3", getYd3());
		this.hashObject.put("repo_pln_fb_rmk", getRepoPlnFbRmk());
		this.hashObject.put("eq_repo_purp_cd", getEqRepoPurpCd());
		this.hashObject.put("trsp_mode", getTrspMode());
		this.hashObject.put("tpszArr", getTpszArr());
		return this.hashObject;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("t1_cntrno", "t1Cntrno");
		this.hashFields.put("reason", "reason");
		this.hashFields.put("dt1", "dt1");
		this.hashFields.put("pln_yrwk", "plnYrwk");
		this.hashFields.put("dt2", "dt2");
		this.hashFields.put("dt3", "dt3");
		this.hashFields.put("t1_tpszno", "t1Tpszno");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ecc1", "ecc1");
		this.hashFields.put("ecc2", "ecc2");
		this.hashFields.put("ecc3", "ecc3");
		this.hashFields.put("yd2", "yd2");
		this.hashFields.put("yd1", "yd1");
		this.hashFields.put("yd3", "yd3");
		this.hashFields.put("repo_pln_fb_rmk", "repoPlnFbRmk");
		this.hashFields.put("eq_repo_purp_cd", "eqRepoPurpCd");
		this.hashFields.put("trsp_mode", "trspMode");
		this.hashFields.put("tpszArr", "tpszArr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return coCd
	 */
	public String getCoCd() {
		return this.coCd;
	}
	
	/**
	 * Column Info
	 * @return t1Cntrno
	 */
	public String getT1Cntrno() {
		return this.t1Cntrno;
	}
	
	/**
	 * Column Info
	 * @return reason
	 */
	public String getReason() {
		return this.reason;
	}
	
	/**
	 * Column Info
	 * @return dt1
	 */
	public String getDt1() {
		return this.dt1;
	}
	
	/**
	 * Column Info
	 * @return plnYrwk
	 */
	public String getPlnYrwk() {
		return this.plnYrwk;
	}
	
	/**
	 * Column Info
	 * @return dt2
	 */
	public String getDt2() {
		return this.dt2;
	}
	
	/**
	 * Column Info
	 * @return dt3
	 */
	public String getDt3() {
		return this.dt3;
	}
	
	/**
	 * Column Info
	 * @return t1Tpszno
	 */
	public String getT1Tpszno() {
		return this.t1Tpszno;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return ecc1
	 */
	public String getEcc1() {
		return this.ecc1;
	}
	
	/**
	 * Column Info
	 * @return ecc2
	 */
	public String getEcc2() {
		return this.ecc2;
	}
	
	/**
	 * Column Info
	 * @return ecc3
	 */
	public String getEcc3() {
		return this.ecc3;
	}
	
	/**
	 * Column Info
	 * @return yd2
	 */
	public String getYd2() {
		return this.yd2;
	}
	
	/**
	 * Column Info
	 * @return yd1
	 */
	public String getYd1() {
		return this.yd1;
	}
	
	/**
	 * Column Info
	 * @return yd3
	 */
	public String getYd3() {
		return this.yd3;
	}
	
	/**
	 * Column Info
	 * @return repoPlnFbRmk
	 */
	public String getRepoPlnFbRmk() {
		return this.repoPlnFbRmk;
	}
	
	/**
	 * Column Info
	 * @return eqRepoPurpCd
	 */
	public String getEqRepoPurpCd() {
		return this.eqRepoPurpCd;
	}
	
	/**
	 * Column Info
	 * @return trspMode
	 */
	public String getTrspMode() {
		return this.trspMode;
	}
	

	/**
	 * Column Info
	 * @param coCd
	 */
	public void setCoCd(String coCd) {
		this.coCd = coCd;
	}
	
	/**
	 * Column Info
	 * @param t1Cntrno
	 */
	public void setT1Cntrno(String t1Cntrno) {
		this.t1Cntrno = t1Cntrno;
	}
	
	/**
	 * Column Info
	 * @param reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	/**
	 * Column Info
	 * @param dt1
	 */
	public void setDt1(String dt1) {
		this.dt1 = dt1;
	}
	
	/**
	 * Column Info
	 * @param plnYrwk
	 */
	public void setPlnYrwk(String plnYrwk) {
		this.plnYrwk = plnYrwk;
	}
	
	/**
	 * Column Info
	 * @param dt2
	 */
	public void setDt2(String dt2) {
		this.dt2 = dt2;
	}
	
	/**
	 * Column Info
	 * @param dt3
	 */
	public void setDt3(String dt3) {
		this.dt3 = dt3;
	}
	
	/**
	 * Column Info
	 * @param t1Tpszno
	 */
	public void setT1Tpszno(String t1Tpszno) {
		this.t1Tpszno = t1Tpszno;
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
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param ecc1
	 */
	public void setEcc1(String ecc1) {
		this.ecc1 = ecc1;
	}
	
	/**
	 * Column Info
	 * @param ecc2
	 */
	public void setEcc2(String ecc2) {
		this.ecc2 = ecc2;
	}
	
	/**
	 * Column Info
	 * @param ecc3
	 */
	public void setEcc3(String ecc3) {
		this.ecc3 = ecc3;
	}
	
	/**
	 * Column Info
	 * @param yd2
	 */
	public void setYd2(String yd2) {
		this.yd2 = yd2;
	}
	
	/**
	 * Column Info
	 * @param yd1
	 */
	public void setYd1(String yd1) {
		this.yd1 = yd1;
	}
	
	/**
	 * Column Info
	 * @param yd3
	 */
	public void setYd3(String yd3) {
		this.yd3 = yd3;
	}
	
	/**
	 * Column Info
	 * @param repoPlnFbRmk
	 */
	public void setRepoPlnFbRmk(String repoPlnFbRmk) {
		this.repoPlnFbRmk = repoPlnFbRmk;
	}
	
	/**
	 * Column Info
	 * @param eqRepoPurpCd
	 */
	public void setEqRepoPurpCd(String eqRepoPurpCd) {
		this.eqRepoPurpCd = eqRepoPurpCd;
	}
	
	/**
	 * Column Info
	 * @param trspMode
	 */
	public void setTrspMode(String trspMode) {
		this.trspMode = trspMode;
	}
	
	public List<String> getTpszArr() {
		return tpszArr;
	}

	public void setTpszArr(String tpsz) {
		
		this.tpszArr = Utils.replaceStrToList(tpsz);
	}


	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCoCd(JSPUtil.getParameter(request, "co_cd", ""));
		setT1Cntrno(JSPUtil.getParameter(request, "t1_cntrno", ""));
		setReason(JSPUtil.getParameter(request, "reason", ""));
		setDt1(JSPUtil.getParameter(request, "dt1", ""));
		setPlnYrwk(JSPUtil.getParameter(request, "pln_yrwk", ""));
		setDt2(JSPUtil.getParameter(request, "dt2", ""));
		setDt3(JSPUtil.getParameter(request, "dt3", ""));
		setT1Tpszno(JSPUtil.getParameter(request, "t1_tpszno", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEcc1(JSPUtil.getParameter(request, "ecc1", ""));
		setEcc2(JSPUtil.getParameter(request, "ecc2", ""));
		setEcc3(JSPUtil.getParameter(request, "ecc3", ""));
		setYd2(JSPUtil.getParameter(request, "yd2", ""));
		setYd1(JSPUtil.getParameter(request, "yd1", ""));
		setYd3(JSPUtil.getParameter(request, "yd3", ""));
		setRepoPlnFbRmk(JSPUtil.getParameter(request, "repo_pln_fb_rmk", ""));
		setEqRepoPurpCd(JSPUtil.getParameter(request, "eq_repo_purp_cd", ""));
		setTrspMode(JSPUtil.getParameter(request, "trsp_mode", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr0108ModifyCombineExecutionVO[]
	 */
	public EesEqr0108ModifyCombineExecutionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr0108ModifyCombineExecutionVO[]
	 */
	public EesEqr0108ModifyCombineExecutionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr0108ModifyCombineExecutionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] coCd = (JSPUtil.getParameter(request, prefix	+ "co_cd", length));
			String[] t1Cntrno = (JSPUtil.getParameter(request, prefix	+ "t1_cntrno", length));
			String[] reason = (JSPUtil.getParameter(request, prefix	+ "reason", length));
			String[] dt1 = (JSPUtil.getParameter(request, prefix	+ "dt1", length));
			String[] plnYrwk = (JSPUtil.getParameter(request, prefix	+ "pln_yrwk", length));
			String[] dt2 = (JSPUtil.getParameter(request, prefix	+ "dt2", length));
			String[] dt3 = (JSPUtil.getParameter(request, prefix	+ "dt3", length));
			String[] t1Tpszno = (JSPUtil.getParameter(request, prefix	+ "t1_tpszno", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ecc1 = (JSPUtil.getParameter(request, prefix	+ "ecc1", length));
			String[] ecc2 = (JSPUtil.getParameter(request, prefix	+ "ecc2", length));
			String[] ecc3 = (JSPUtil.getParameter(request, prefix	+ "ecc3", length));
			String[] yd2 = (JSPUtil.getParameter(request, prefix	+ "yd2", length));
			String[] yd1 = (JSPUtil.getParameter(request, prefix	+ "yd1", length));
			String[] yd3 = (JSPUtil.getParameter(request, prefix	+ "yd3", length));
			String[] repoPlnFbRmk = (JSPUtil.getParameter(request, prefix	+ "repo_pln_fb_rmk", length));
			String[] eqRepoPurpCd = (JSPUtil.getParameter(request, prefix	+ "eq_repo_purp_cd", length));
			String[] trspMode = (JSPUtil.getParameter(request, prefix	+ "trsp_mode", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr0108ModifyCombineExecutionVO();
				// TYPE SIZE
		    	String tpsztype  = JSPUtil.getParameter(request, "tpsz".trim(), "");  // tpsztype
		    	model.setTpszArr(tpsztype);
		    	
				if (coCd[i] != null)
					model.setCoCd(coCd[i]);
				if (t1Cntrno[i] != null)
					model.setT1Cntrno(t1Cntrno[i]);
				if (reason[i] != null)
					model.setReason(reason[i]);
				if (dt1[i] != null)
					model.setDt1(dt1[i]);
				if (plnYrwk[i] != null)
					model.setPlnYrwk(plnYrwk[i]);
				if (dt2[i] != null)
					model.setDt2(dt2[i]);
				if (dt3[i] != null)
					model.setDt3(dt3[i]);
				if (t1Tpszno[i] != null)
					model.setT1Tpszno(t1Tpszno[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ecc1[i] != null)
					model.setEcc1(ecc1[i]);
				if (ecc2[i] != null)
					model.setEcc2(ecc2[i]);
				if (ecc3[i] != null)
					model.setEcc3(ecc3[i]);
				if (yd2[i] != null)
					model.setYd2(yd2[i]);
				if (yd1[i] != null)
					model.setYd1(yd1[i]);
				if (yd3[i] != null)
					model.setYd3(yd3[i]);
				if (repoPlnFbRmk[i] != null)
					model.setRepoPlnFbRmk(repoPlnFbRmk[i]);
				if (eqRepoPurpCd[i] != null)
					model.setEqRepoPurpCd(eqRepoPurpCd[i]);
				if (trspMode[i] != null)
					model.setTrspMode(trspMode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr0108ModifyCombineExecutionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr0108ModifyCombineExecutionVO[]
	 */
	public EesEqr0108ModifyCombineExecutionVO[] getEesEqr0108ModifyCombineExecutionVOs(){
		EesEqr0108ModifyCombineExecutionVO[] vos = (EesEqr0108ModifyCombineExecutionVO[])models.toArray(new EesEqr0108ModifyCombineExecutionVO[models.size()]);
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
		this.coCd = this.coCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t1Cntrno = this.t1Cntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reason = this.reason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dt1 = this.dt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYrwk = this.plnYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dt2 = this.dt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dt3 = this.dt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t1Tpszno = this.t1Tpszno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecc1 = this.ecc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecc2 = this.ecc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ecc3 = this.ecc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yd2 = this.yd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yd1 = this.yd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yd3 = this.yd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnFbRmk = this.repoPlnFbRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRepoPurpCd = this.eqRepoPurpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMode = this.trspMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
