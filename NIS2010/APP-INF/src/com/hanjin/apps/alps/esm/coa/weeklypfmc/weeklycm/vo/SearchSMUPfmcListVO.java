/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSMUPfmcListVO.java
*@FileTitle : SearchSMUPfmcListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2009.10.14 박수훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo;

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
 * @author 박수훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSMUPfmcListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSMUPfmcListVO> models = new ArrayList<SearchSMUPfmcListVO>();
	
	/* Column Info */
	private String plcyPrcUtAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costLaneTpNm = null;
	/* Column Info */
	private String costYrmon = null;
	/* Column Info */
	private String bseUcAmt = null;
	/* Column Info */
	private String costLaneTpCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String vslSlanDirCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSMUPfmcListVO() {}

	public SearchSMUPfmcListVO(String ibflag, String pagerows, String costYrmon, String trdCd, String subTrdCd, String rlaneCd, String vslSlanDirCd, String costLaneTpCd, String costLaneTpNm, String bseUcAmt, String plcyPrcUtAmt) {
		this.plcyPrcUtAmt = plcyPrcUtAmt;
		this.ibflag = ibflag;
		this.costLaneTpNm = costLaneTpNm;
		this.costYrmon = costYrmon;
		this.bseUcAmt = bseUcAmt;
		this.costLaneTpCd = costLaneTpCd;
		this.trdCd = trdCd;
		this.vslSlanDirCd = vslSlanDirCd;
		this.rlaneCd = rlaneCd;
		this.subTrdCd = subTrdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("plcy_prc_ut_amt", getPlcyPrcUtAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_lane_tp_nm", getCostLaneTpNm());
		this.hashColumns.put("cost_yrmon", getCostYrmon());
		this.hashColumns.put("bse_uc_amt", getBseUcAmt());
		this.hashColumns.put("cost_lane_tp_cd", getCostLaneTpCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("vsl_slan_dir_cd", getVslSlanDirCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("plcy_prc_ut_amt", "plcyPrcUtAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_lane_tp_nm", "costLaneTpNm");
		this.hashFields.put("cost_yrmon", "costYrmon");
		this.hashFields.put("bse_uc_amt", "bseUcAmt");
		this.hashFields.put("cost_lane_tp_cd", "costLaneTpCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("vsl_slan_dir_cd", "vslSlanDirCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return plcyPrcUtAmt
	 */
	public String getPlcyPrcUtAmt() {
		return this.plcyPrcUtAmt;
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
	 * @return costLaneTpNm
	 */
	public String getCostLaneTpNm() {
		return this.costLaneTpNm;
	}
	
	/**
	 * Column Info
	 * @return costYrmon
	 */
	public String getCostYrmon() {
		return this.costYrmon;
	}
	
	/**
	 * Column Info
	 * @return bseUcAmt
	 */
	public String getBseUcAmt() {
		return this.bseUcAmt;
	}
	
	/**
	 * Column Info
	 * @return costLaneTpCd
	 */
	public String getCostLaneTpCd() {
		return this.costLaneTpCd;
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
	 * @return vslSlanDirCd
	 */
	public String getVslSlanDirCd() {
		return this.vslSlanDirCd;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @param plcyPrcUtAmt
	 */
	public void setPlcyPrcUtAmt(String plcyPrcUtAmt) {
		this.plcyPrcUtAmt = plcyPrcUtAmt;
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
	 * @param costLaneTpNm
	 */
	public void setCostLaneTpNm(String costLaneTpNm) {
		this.costLaneTpNm = costLaneTpNm;
	}
	
	/**
	 * Column Info
	 * @param costYrmon
	 */
	public void setCostYrmon(String costYrmon) {
		this.costYrmon = costYrmon;
	}
	
	/**
	 * Column Info
	 * @param bseUcAmt
	 */
	public void setBseUcAmt(String bseUcAmt) {
		this.bseUcAmt = bseUcAmt;
	}
	
	/**
	 * Column Info
	 * @param costLaneTpCd
	 */
	public void setCostLaneTpCd(String costLaneTpCd) {
		this.costLaneTpCd = costLaneTpCd;
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
	 * @param vslSlanDirCd
	 */
	public void setVslSlanDirCd(String vslSlanDirCd) {
		this.vslSlanDirCd = vslSlanDirCd;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setPlcyPrcUtAmt(JSPUtil.getParameter(request, "plcy_prc_ut_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCostLaneTpNm(JSPUtil.getParameter(request, "cost_lane_tp_nm", ""));
		setCostYrmon(JSPUtil.getParameter(request, "cost_yrmon", ""));
		setBseUcAmt(JSPUtil.getParameter(request, "bse_uc_amt", ""));
		setCostLaneTpCd(JSPUtil.getParameter(request, "cost_lane_tp_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setVslSlanDirCd(JSPUtil.getParameter(request, "vsl_slan_dir_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, "sub_trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSMUPfmcListVO[]
	 */
	public SearchSMUPfmcListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSMUPfmcListVO[]
	 */
	public SearchSMUPfmcListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSMUPfmcListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] plcyPrcUtAmt = (JSPUtil.getParameter(request, prefix	+ "plcy_prc_ut_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costLaneTpNm = (JSPUtil.getParameter(request, prefix	+ "cost_lane_tp_nm", length));
			String[] costYrmon = (JSPUtil.getParameter(request, prefix	+ "cost_yrmon", length));
			String[] bseUcAmt = (JSPUtil.getParameter(request, prefix	+ "bse_uc_amt", length));
			String[] costLaneTpCd = (JSPUtil.getParameter(request, prefix	+ "cost_lane_tp_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] vslSlanDirCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_dir_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSMUPfmcListVO();
				if (plcyPrcUtAmt[i] != null)
					model.setPlcyPrcUtAmt(plcyPrcUtAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costLaneTpNm[i] != null)
					model.setCostLaneTpNm(costLaneTpNm[i]);
				if (costYrmon[i] != null)
					model.setCostYrmon(costYrmon[i]);
				if (bseUcAmt[i] != null)
					model.setBseUcAmt(bseUcAmt[i]);
				if (costLaneTpCd[i] != null)
					model.setCostLaneTpCd(costLaneTpCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (vslSlanDirCd[i] != null)
					model.setVslSlanDirCd(vslSlanDirCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSMUPfmcListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSMUPfmcListVO[]
	 */
	public SearchSMUPfmcListVO[] getSearchSMUPfmcListVOs(){
		SearchSMUPfmcListVO[] vos = (SearchSMUPfmcListVO[])models.toArray(new SearchSMUPfmcListVO[models.size()]);
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
		this.plcyPrcUtAmt = this.plcyPrcUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costLaneTpNm = this.costLaneTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costYrmon = this.costYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseUcAmt = this.bseUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costLaneTpCd = this.costLaneTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanDirCd = this.vslSlanDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
