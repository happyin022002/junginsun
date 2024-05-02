/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VvdBkgStsVO.java
*@FileTitle : VvdBkgStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.31
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.01 유혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author 유혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VvdBkgStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VvdBkgStsVO> models = new ArrayList<VvdBkgStsVO>();
	
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String startEta = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String updateFlag = null;
	/* Column Info */
	private String bkgStatus = null;
	/* Column Info */
	private String virBkgStatus = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String turnSkdVoyNo = null;
	/* Column Info */
	private String turnSkdDirCd = null;
	/* Column Info */
	private String ruseProhiFlg = null;
	/* Page Number */
	private String pagerows = null;
	
	private String actSkdInputFlg	= null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VvdBkgStsVO() {}

	public VvdBkgStsVO(String ibflag, String pagerows, String vslSlanCd, String vslCd, String skdVoyNo, String skdDirCd, String bkgStatus, String virBkgStatus, String startEta, String updateFlag, String turnSkdVoyNo, String turnSkdDirCd, String ruseProhiFlg, String actSkdInputFlg) {
		this.vslSlanCd = vslSlanCd;
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.startEta = startEta;
		this.skdVoyNo = skdVoyNo;
		this.updateFlag = updateFlag;
		this.bkgStatus = bkgStatus;
		this.virBkgStatus = virBkgStatus;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.turnSkdVoyNo = turnSkdVoyNo;
		this.turnSkdDirCd = turnSkdDirCd;
		this.ruseProhiFlg = ruseProhiFlg;
		this.actSkdInputFlg = actSkdInputFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("start_eta", getStartEta());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("turn_skd_voy_no", getTurnSkdVoyNo());
		this.hashColumns.put("update_flag", getUpdateFlag());
		this.hashColumns.put("bkg_status", getBkgStatus());
		this.hashColumns.put("vir_bkg_status", getVirBkgStatus());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("turn_skd_dir_cd", getTurnSkdDirCd());
		this.hashColumns.put("ruse_prohi_flg", getRuseProhiFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("act_skd_input_flg", getActSkdInputFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("start_eta", "startEta");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("turn_skd_voy_no", "turnSkdVoyNo");
		this.hashFields.put("update_flag", "updateFlag");
		this.hashFields.put("bkg_status", "bkgStatus");
		this.hashFields.put("vir_bkg_status", "virBkgStatus");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("turn_skd_dir_cd", "turnSkdDirCd");
		this.hashFields.put("ruse_prohi_flg", "ruseProhiFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("act_skd_input_flg", "actSkdInputFlg");
		return this.hashFields;
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return startEta
	 */
	public String getStartEta() {
		return this.startEta;
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
	 * @return turnSkdVoyNo
	 */
	public String getTurnSkdVoyNo() {
		return this.turnSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return updateFlag
	 */
	public String getUpdateFlag() {
		return this.updateFlag;
	}
	
	/**
	 * Column Info
	 * @return bkgStatus
	 */
	public String getBkgStatus() {
		return this.bkgStatus;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return turnSkdDirCd
	 */
	public String getTurnSkdDirCd() {
		return this.turnSkdDirCd;
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
	 * @return virBkgStatus
	 */
	public String getVirBkgStatus() {
		return this.virBkgStatus;
	}
	
	/**
	 * Column Info
	 * @return ruseProhiFlg
	 */
	public String getRuseProhiFlg() {
		return this.ruseProhiFlg;
	}
	
	/**
	 * Column Info
	 * @return actSkdInputFlg
	 */
	public String getActSkdInputFlg() {
		return this.actSkdInputFlg;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param startEta
	 */
	public void setStartEta(String startEta) {
		this.startEta = startEta;
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
	 * @param turnSkdVoyNo
	 */
	public void setTurnSkdVoyNo(String turnSkdVoyNo) {
		this.turnSkdVoyNo = turnSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param updateFlag
	 */
	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}
	
	/**
	 * Column Info
	 * @param bkgStatus
	 */
	public void setBkgStatus(String bkgStatus) {
		this.bkgStatus = bkgStatus;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param turnSkdDirCd
	 */
	public void setTurnSkdDirCd(String turnSkdDirCd) {
		this.turnSkdDirCd = turnSkdDirCd;
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
	 * @param virBkgStatus
	 */
	public void setVirBkgStatus(String virBkgStatus) {
		this.virBkgStatus = virBkgStatus;
	}
	
	/**
	 * Column Info
	 * @param ruseProhiFlg
	 */
	public void setRuseProhiFlg(String ruseProhiFlg) {
		this.ruseProhiFlg = ruseProhiFlg;
	}
	
	/**
	 * Column Info
	 * @param actSkdInputFlg
	 */
	public void setActSkdInputFlg(String actSkdInputFlg) {
		this.actSkdInputFlg = actSkdInputFlg;
	}	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setStartEta(JSPUtil.getParameter(request, "start_eta", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setTurnSkdVoyNo(JSPUtil.getParameter(request, "turn_skd_voy_no", ""));
		setUpdateFlag(JSPUtil.getParameter(request, "update_flag", ""));
		setBkgStatus(JSPUtil.getParameter(request, "bkg_status", ""));
		setVirBkgStatus(JSPUtil.getParameter(request, "vir_bkg_status", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setTurnSkdDirCd(JSPUtil.getParameter(request, "turn_skd_dir_cd", ""));
		setRuseProhiFlg(JSPUtil.getParameter(request, "ruse_prohi_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setActSkdInputFlg(JSPUtil.getParameter(request, "act_skd_input_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VvdBkgStsVO[]
	 */
	public VvdBkgStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VvdBkgStsVO[]
	 */
	public VvdBkgStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VvdBkgStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] startEta = (JSPUtil.getParameter(request, prefix	+ "start_eta".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));
			String[] turnSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "turn_skd_voy_no".trim(), length));
			String[] updateFlag = (JSPUtil.getParameter(request, prefix	+ "update_flag".trim(), length));
			String[] bkgStatus = (JSPUtil.getParameter(request, prefix	+ "bkg_status".trim(), length));
			String[] virBkgStatus = (JSPUtil.getParameter(request, prefix	+ "vir_bkg_status".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] turnSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "turn_skd_dir_cd".trim(), length));
			String[] ruseProhiFlg = (JSPUtil.getParameter(request, prefix	+ "ruse_prohi_flg".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] actSkdInputFlg = (JSPUtil.getParameter(request, prefix	+ "act_skd_input_flg".trim(), length));
			
			
			for (int i = 0; i < length; i++) {
				model = new VvdBkgStsVO();
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (startEta[i] != null)
					model.setStartEta(startEta[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (turnSkdVoyNo[i] != null)
					model.setTurnSkdVoyNo(turnSkdVoyNo[i]);
				if (updateFlag[i] != null)
					model.setUpdateFlag(updateFlag[i]);
				if (bkgStatus[i] != null)
					model.setBkgStatus(bkgStatus[i]);
				if (virBkgStatus[i] != null)
					model.setVirBkgStatus(virBkgStatus[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (turnSkdDirCd[i] != null)
					model.setTurnSkdDirCd(turnSkdDirCd[i]);
				if (ruseProhiFlg[i] != null)
					model.setRuseProhiFlg(ruseProhiFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (actSkdInputFlg[i] != null)
					model.setActSkdInputFlg(actSkdInputFlg[i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVvdBkgStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VvdBkgStsVO[]
	 */
	public VvdBkgStsVO[] getVvdBkgStsVOs(){
		VvdBkgStsVO[] vos = (VvdBkgStsVO[])models.toArray(new VvdBkgStsVO[models.size()]);
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
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startEta = this.startEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdVoyNo = this.turnSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateFlag = this.updateFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStatus = this.bkgStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.virBkgStatus = this.virBkgStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.turnSkdDirCd = this.turnSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ruseProhiFlg = this.ruseProhiFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actSkdInputFlg = this.actSkdInputFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
