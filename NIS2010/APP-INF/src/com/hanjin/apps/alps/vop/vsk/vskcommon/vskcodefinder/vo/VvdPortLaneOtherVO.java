/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VvdPortLaneOtherVO.java
*@FileTitle : VvdPortLaneOtherVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.10.07 정진우 
* 1.0 Creation
* 2011.10.26 김민아 [CHM-201114112-01] VSL SKD History Inquiry 화면 로직 변경
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo;

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
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VvdPortLaneOtherVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VvdPortLaneOtherVO> models = new ArrayList<VvdPortLaneOtherVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String subTrdDirCd = null;
	/* Column Info */
	private String vskdTpCd = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String actInpYrmon = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String vskdCngTpCd = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String ctrlCd = null;
	/* Page Number */
	private String pageno = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VvdPortLaneOtherVO() {}

	public VvdPortLaneOtherVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String subTrdDirCd, String actInpYrmon, String diffRmk, String vskdTpCd, String vskdCngTpCd, String ctrlCd, String fmDt, String toDt, String skdDirCd, String vslSlanCd, String vpsPortCd, String vpsEtaDt, String pageno) {
		this.vslCd = vslCd;
		this.subTrdDirCd = subTrdDirCd;
		this.vskdTpCd = vskdTpCd;
		this.fmDt = fmDt;
		this.actInpYrmon = actInpYrmon;
		this.skdVoyNo = skdVoyNo;
		this.vslSlanCd = vslSlanCd;
		this.vpsEtaDt = vpsEtaDt;
		this.vskdCngTpCd = vskdCngTpCd;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.ctrlCd = ctrlCd;
		this.pageno = pageno;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("sub_trd_dir_cd", getSubTrdDirCd());
		this.hashColumns.put("vskd_tp_cd", getVskdTpCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("act_inp_yrmon", getActInpYrmon());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("vskd_cng_tp_cd", getVskdCngTpCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("ctrl_cd", getCtrlCd());
		this.hashColumns.put("page_no", getPageNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("sub_trd_dir_cd", "subTrdDirCd");
		this.hashFields.put("vskd_tp_cd", "vskdTpCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("act_inp_yrmon", "actInpYrmon");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("vskd_cng_tp_cd", "vskdCngTpCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("ctrl_cd", "ctrlCd");
		this.hashFields.put("page_no", "pageno");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdDirCd
	 */
	public String getSubTrdDirCd() {
		return this.subTrdDirCd;
	}
	
	/**
	 * Column Info
	 * @return vskdTpCd
	 */
	public String getVskdTpCd() {
		return this.vskdTpCd;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return actInpYrmon
	 */
	public String getActInpYrmon() {
		return this.actInpYrmon;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return vskdCngTpCd
	 */
	public String getVskdCngTpCd() {
		return this.vskdCngTpCd;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return ctrlCd
	 */
	public String getCtrlCd() {
		return this.ctrlCd;
	}
	
	/**
	 * Column Info
	 * @return pageno
	 */
	public String getPageNo() {
		return this.pageno;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdDirCd
	 */
	public void setSubTrdDirCd(String subTrdDirCd) {
		this.subTrdDirCd = subTrdDirCd;
	}
	
	/**
	 * Column Info
	 * @param vskdTpCd
	 */
	public void setVskdTpCd(String vskdTpCd) {
		this.vskdTpCd = vskdTpCd;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param actInpYrmon
	 */
	public void setActInpYrmon(String actInpYrmon) {
		this.actInpYrmon = actInpYrmon;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param vskdCngTpCd
	 */
	public void setVskdCngTpCd(String vskdCngTpCd) {
		this.vskdCngTpCd = vskdCngTpCd;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param ctrlCd
	 */
	public void setCtrlCd(String ctrlCd) {
		this.ctrlCd = ctrlCd;
	}
	
	/**
	 * Column Info
	 * @param pageno
	 */
	public void setPageNo(String pageno) {
		this.pageno = pageno;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSubTrdDirCd(JSPUtil.getParameter(request, "sub_trd_dir_cd", ""));
		setVskdTpCd(JSPUtil.getParameter(request, "vskd_tp_cd", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setActInpYrmon(JSPUtil.getParameter(request, "act_inp_yrmon", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setVskdCngTpCd(JSPUtil.getParameter(request, "vskd_cng_tp_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setCtrlCd(JSPUtil.getParameter(request, "ctrl_cd", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VvdPortLaneOtherVO[]
	 */
	public VvdPortLaneOtherVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VvdPortLaneOtherVO[]
	 */
	public VvdPortLaneOtherVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VvdPortLaneOtherVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] subTrdDirCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_dir_cd", length));
			String[] vskdTpCd = (JSPUtil.getParameter(request, prefix	+ "vskd_tp_cd", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] actInpYrmon = (JSPUtil.getParameter(request, prefix	+ "act_inp_yrmon", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] vskdCngTpCd = (JSPUtil.getParameter(request, prefix	+ "vskd_cng_tp_cd", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] ctrlCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_cd", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix + "page_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new VvdPortLaneOtherVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (subTrdDirCd[i] != null)
					model.setSubTrdDirCd(subTrdDirCd[i]);
				if (vskdTpCd[i] != null)
					model.setVskdTpCd(vskdTpCd[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (actInpYrmon[i] != null)
					model.setActInpYrmon(actInpYrmon[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (vskdCngTpCd[i] != null)
					model.setVskdCngTpCd(vskdCngTpCd[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (ctrlCd[i] != null)
					model.setCtrlCd(ctrlCd[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVvdPortLaneOtherVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VvdPortLaneOtherVO[]
	 */
	public VvdPortLaneOtherVO[] getVvdPortLaneOtherVOs(){
		VvdPortLaneOtherVO[] vos = (VvdPortLaneOtherVO[])models.toArray(new VvdPortLaneOtherVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdDirCd = this.subTrdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskdTpCd = this.vskdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInpYrmon = this.actInpYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskdCngTpCd = this.vskdCngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlCd = this.ctrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageno = this.pageno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
