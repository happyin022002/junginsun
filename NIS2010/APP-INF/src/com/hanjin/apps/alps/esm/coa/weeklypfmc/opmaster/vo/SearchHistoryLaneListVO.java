/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchHistoryLaneListVO.java
*@FileTitle : SearchHistoryLaneListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.10.15 김기대 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.weeklypfmc.opmaster.vo;

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
 * @author 김기대
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchHistoryLaneListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchHistoryLaneListVO> models = new ArrayList<SearchHistoryLaneListVO>();
	
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String vslLaneTpCd = null;
	/* Column Info */
	private String laneAplyFomDt = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String laneAplyToDt = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String flag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String stupFlg = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String laneSeq = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchHistoryLaneListVO() {}

	public SearchHistoryLaneListVO(String ibflag, String pagerows, String flag, String laneSeq, String trdCd, String subTrdCd, String slanCd, String rlaneCd, String dirCd, String iocCd, String vslLaneTpCd, String stupFlg, String vvdCd, String laneAplyFomDt, String laneAplyToDt) {
		this.iocCd = iocCd;
		this.vslLaneTpCd = vslLaneTpCd;
		this.laneAplyFomDt = laneAplyFomDt;
		this.trdCd = trdCd;
		this.laneAplyToDt = laneAplyToDt;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.flag = flag;
		this.slanCd = slanCd;
		this.vvdCd = vvdCd;
		this.stupFlg = stupFlg;
		this.dirCd = dirCd;
		this.laneSeq = laneSeq;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("vsl_lane_tp_cd", getVslLaneTpCd());
		this.hashColumns.put("lane_aply_fom_dt", getLaneAplyFomDt());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("lane_aply_to_dt", getLaneAplyToDt());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("flag", getFlag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("stup_flg", getStupFlg());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("lane_seq", getLaneSeq());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("vsl_lane_tp_cd", "vslLaneTpCd");
		this.hashFields.put("lane_aply_fom_dt", "laneAplyFomDt");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("lane_aply_to_dt", "laneAplyToDt");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("flag", "flag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("stup_flg", "stupFlg");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("lane_seq", "laneSeq");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
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
	 * @return vslLaneTpCd
	 */
	public String getVslLaneTpCd() {
		return this.vslLaneTpCd;
	}
	
	/**
	 * Column Info
	 * @return laneAplyFomDt
	 */
	public String getLaneAplyFomDt() {
		return this.laneAplyFomDt;
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
	 * @return laneAplyToDt
	 */
	public String getLaneAplyToDt() {
		return this.laneAplyToDt;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return flag
	 */
	public String getFlag() {
		return this.flag;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return stupFlg
	 */
	public String getStupFlg() {
		return this.stupFlg;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return laneSeq
	 */
	public String getLaneSeq() {
		return this.laneSeq;
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
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param vslLaneTpCd
	 */
	public void setVslLaneTpCd(String vslLaneTpCd) {
		this.vslLaneTpCd = vslLaneTpCd;
	}
	
	/**
	 * Column Info
	 * @param laneAplyFomDt
	 */
	public void setLaneAplyFomDt(String laneAplyFomDt) {
		this.laneAplyFomDt = laneAplyFomDt;
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
	 * @param laneAplyToDt
	 */
	public void setLaneAplyToDt(String laneAplyToDt) {
		this.laneAplyToDt = laneAplyToDt;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param stupFlg
	 */
	public void setStupFlg(String stupFlg) {
		this.stupFlg = stupFlg;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param laneSeq
	 */
	public void setLaneSeq(String laneSeq) {
		this.laneSeq = laneSeq;
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
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setVslLaneTpCd(JSPUtil.getParameter(request, "vsl_lane_tp_cd", ""));
		setLaneAplyFomDt(JSPUtil.getParameter(request, "lane_aply_fom_dt", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setLaneAplyToDt(JSPUtil.getParameter(request, "lane_aply_to_dt", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFlag(JSPUtil.getParameter(request, "flag", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setStupFlg(JSPUtil.getParameter(request, "stup_flg", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setLaneSeq(JSPUtil.getParameter(request, "lane_seq", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchHistoryLaneListVO[]
	 */
	public SearchHistoryLaneListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchHistoryLaneListVO[]
	 */
	public SearchHistoryLaneListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchHistoryLaneListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] vslLaneTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_lane_tp_cd", length));
			String[] laneAplyFomDt = (JSPUtil.getParameter(request, prefix	+ "lane_aply_fom_dt", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] laneAplyToDt = (JSPUtil.getParameter(request, prefix	+ "lane_aply_to_dt", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] flag = (JSPUtil.getParameter(request, prefix	+ "flag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] stupFlg = (JSPUtil.getParameter(request, prefix	+ "stup_flg", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] laneSeq = (JSPUtil.getParameter(request, prefix	+ "lane_seq", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchHistoryLaneListVO();
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (vslLaneTpCd[i] != null)
					model.setVslLaneTpCd(vslLaneTpCd[i]);
				if (laneAplyFomDt[i] != null)
					model.setLaneAplyFomDt(laneAplyFomDt[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (laneAplyToDt[i] != null)
					model.setLaneAplyToDt(laneAplyToDt[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (flag[i] != null)
					model.setFlag(flag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (stupFlg[i] != null)
					model.setStupFlg(stupFlg[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (laneSeq[i] != null)
					model.setLaneSeq(laneSeq[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchHistoryLaneListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchHistoryLaneListVO[]
	 */
	public SearchHistoryLaneListVO[] getSearchHistoryLaneListVOs(){
		SearchHistoryLaneListVO[] vos = (SearchHistoryLaneListVO[])models.toArray(new SearchHistoryLaneListVO[models.size()]);
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
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneTpCd = this.vslLaneTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneAplyFomDt = this.laneAplyFomDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneAplyToDt = this.laneAplyToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flag = this.flag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stupFlg = this.stupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneSeq = this.laneSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
