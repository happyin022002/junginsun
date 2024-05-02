/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CreateTableArFinDirConvVO.java
*@FileTitle : CreateTableArFinDirConvVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.05
*@LastModifier : Lee, Yulkyu
*@LastVersion : 1.0
* 2009.09.22 최 선
* 2015.11.05 Lee, Yulkyu: Pendulum 노선 변경으로 인한 vo 추가 작업 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.common.tableSync.jms.vo;

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
 * @author 최 선 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */  

public class CreateArFincDirConvVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CreateArFincDirConvVO> models = new ArrayList<CreateArFincDirConvVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String rlaneDirCd = null;
	/* Column Info */
	private String slanDirCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String dirCngCd = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String scontiCd = null;
	/* Column Info */
	private String apMk = null;
	
	// 2015.10 newly added - start
	/* Column Info */
	private String podConti = null;
	/* Column Info */
	private String podRevLaneDir = null;
	/* Column Info */
	private String podRevLane = null;
	// 2015.10 newly added - end
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CreateArFincDirConvVO() {}

	public CreateArFincDirConvVO(String ibflag, String pagerows, String slanCd, String scontiCd, String slanDirCd, String rlaneDirCd, String dirCngCd, String deltFlg, String updUsrId, String creDt, String updDt, String eaiEvntDt, String rlaneCd, String apMk, String podConti, String podRevLaneDir, String podRevLane) {
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.rlaneDirCd = rlaneDirCd;
		this.slanDirCd = slanDirCd;
		this.slanCd = slanCd;
		this.dirCngCd = dirCngCd;
		this.eaiEvntDt = eaiEvntDt;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rlaneCd = rlaneCd;
		this.creDt = creDt;
		this.scontiCd = deltFlg;
		this.apMk = apMk;
		this.podConti = podConti;
		this.podRevLaneDir = podRevLaneDir;
		this.podRevLane = podRevLane;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("rlane_dir_cd", getRlaneDirCd());
		this.hashColumns.put("slan_dir_cd", getSlanDirCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("dir_cng_cd", getDirCngCd());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("ap_mk", getScontiCd());
		this.hashColumns.put("pod_conti", getPodConti());
		this.hashColumns.put("pod_rev_lane_dir", getPodRevLaneDir());
		this.hashColumns.put("pod_rev_lane", getPodRevLane());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("rlane_dir_cd", "rlaneDirCd");
		this.hashFields.put("slan_dir_cd", "slanDirCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("dir_cng_cd", "dirCngCd");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("ap_mk", "apMk");
		this.hashFields.put("pod_conti", "podConti");
		this.hashFields.put("pod_rev_lane_dir", "podRevLaneDir");
		this.hashFields.put("pod_rev_lane", "podRevLane");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return rlaneDirCd
	 */
	public String getRlaneDirCd() {
		return this.rlaneDirCd;
	}
	
	/**
	 * Column Info
	 * @return slanDirCd
	 */
	public String getSlanDirCd() {
		return this.slanDirCd;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return dirCngCd
	 */
	public String getDirCngCd() {
		return this.dirCngCd;
	}
	
	/**
	 * Column Info
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
	}
	
	/**
	 * Column Info
	 * @return apMk
	 */
	public String getApMk() {
		return this.apMk;
	}
	
	/**
	 * Column Info
	 * @return podConti
	 */
	public String getPodConti() {
		return this.podConti;
	}
	
	/**
	 * Column Info
	 * @return podRevLaneDir
	 */
	public String getPodRevLaneDir() {
		return this.podRevLaneDir;
	}
	
	/**
	 * Column Info
	 * @return podRevLane
	 */
	public String getPodRevLane() {
		return this.podRevLane;
	}

	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param rlaneDirCd
	 */
	public void setRlaneDirCd(String rlaneDirCd) {
		this.rlaneDirCd = rlaneDirCd;
	}
	
	/**
	 * Column Info
	 * @param slanDirCd
	 */
	public void setSlanDirCd(String slanDirCd) {
		this.slanDirCd = slanDirCd;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param dirCngCd
	 */
	public void setDirCngCd(String dirCngCd) {
		this.dirCngCd = dirCngCd;
	}
	
	/**
	 * Column Info
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
	}
	
	/**
	 * Column Info
	 * @param apMk
	 */
	public void setApMk(String apMk) {
		this.apMk = apMk;
	}
	
	/**
	 * Column Info
	 * @param podConti
	 */
	public void setPodConti(String podConti) {
		this.podConti = podConti;
	}
	
	/**
	 * Column Info
	 * @param podRevLaneDir
	 */
	public void setPodRevLaneDir(String podRevLaneDir) {
		this.podRevLaneDir = podRevLaneDir;
	}
	
	/**
	 * Column Info
	 * @param podRevLane
	 */
	public void setPodRevLane(String podRevLane) {
		this.podRevLane = podRevLane;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setRlaneDirCd(JSPUtil.getParameter(request, "rlane_dir_cd", ""));
		setSlanDirCd(JSPUtil.getParameter(request, "slan_dir_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setDirCngCd(JSPUtil.getParameter(request, "dir_cng_cd", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, "eai_evnt_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setScontiCd(JSPUtil.getParameter(request, "sconti_cd", ""));
		setApMk(JSPUtil.getParameter(request, "ap_mk", ""));
		setPodConti(JSPUtil.getParameter(request, "pod_conti", ""));
		setPodRevLaneDir(JSPUtil.getParameter(request, "pod_rev_lane_dir", ""));
		setPodRevLane(JSPUtil.getParameter(request, "pod_rev_lane", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CreateTableArFinDirConvVO[]
	 */
	public CreateArFincDirConvVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CreateTableArFinDirConvVO[]
	 */
	public CreateArFincDirConvVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CreateArFincDirConvVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] rlaneDirCd = (JSPUtil.getParameter(request, prefix	+ "rlane_dir_cd", length));
			String[] slanDirCd = (JSPUtil.getParameter(request, prefix	+ "slan_dir_cd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] dirCngCd = (JSPUtil.getParameter(request, prefix	+ "dir_cng_cd", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd", length));
			String[] apMk = (JSPUtil.getParameter(request, prefix	+ "ap_mk", length));
			String[] podConti = (JSPUtil.getParameter(request, prefix	+ "pod_conti", length));
			String[] podRevLaneDir = (JSPUtil.getParameter(request, prefix	+ "pod_rev_lane_dir", length));
			String[] podRevLane = (JSPUtil.getParameter(request, prefix	+ "pod_rev_lane", length));

			for (int i = 0; i < length; i++) {
				model = new CreateArFincDirConvVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (rlaneDirCd[i] != null)
					model.setRlaneDirCd(rlaneDirCd[i]);
				if (slanDirCd[i] != null)
					model.setSlanDirCd(slanDirCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (dirCngCd[i] != null)
					model.setDirCngCd(dirCngCd[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				if (apMk[i] != null)
					model.setApMk(apMk[i]);
				if (podConti[i] != null)
					model.setPodConti(podConti[i]);
				if (podRevLaneDir[i] != null)
					model.setPodRevLaneDir(podRevLaneDir[i]);
				if (podRevLane[i] != null)
					model.setPodRevLane(podRevLane[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCreateTableArFinDirConvVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CreateTableArFinDirConvVO[]
	 */
	public CreateArFincDirConvVO[] getCreateTableArFinDirConvVOs(){
		CreateArFincDirConvVO[] vos = (CreateArFincDirConvVO[])models.toArray(new CreateArFincDirConvVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneDirCd = this.rlaneDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanDirCd = this.slanDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCngCd = this.dirCngCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apMk = this.apMk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podConti = this.podConti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podRevLaneDir = this.podRevLaneDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podRevLane = this.podRevLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
