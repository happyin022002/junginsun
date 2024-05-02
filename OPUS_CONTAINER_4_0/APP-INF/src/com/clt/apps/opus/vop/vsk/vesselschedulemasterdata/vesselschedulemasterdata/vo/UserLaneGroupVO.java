/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UserLaneGroupVO.java
*@FileTitle : UserLaneGroupVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.09.03 유혁 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo;

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
 * @author 유혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UserLaneGroupVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UserLaneGroupVO> models = new ArrayList<UserLaneGroupVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslSlanNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String srcVslSlanCd = null;
	/* Column Info */
	private String laneGrpNm = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String srcLaneGrpNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UserLaneGroupVO() {}

	public UserLaneGroupVO(String ibflag, String pagerows, String usrId, String laneGrpNm, String srcLaneGrpNm, String vslSlanCd, String srcVslSlanCd, String vslSlanNm, String creUsrId, String updUsrId) {
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.vslSlanNm = vslSlanNm;
		this.usrId = usrId;
		this.srcVslSlanCd = srcVslSlanCd;
		this.laneGrpNm = laneGrpNm;
		this.vslSlanCd = vslSlanCd;
		this.updUsrId = updUsrId;
		this.srcLaneGrpNm = srcLaneGrpNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_slan_nm", getVslSlanNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("src_vsl_slan_cd", getSrcVslSlanCd());
		this.hashColumns.put("lane_grp_nm", getLaneGrpNm());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("src_lane_grp_nm", getSrcLaneGrpNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_slan_nm", "vslSlanNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("src_vsl_slan_cd", "srcVslSlanCd");
		this.hashFields.put("lane_grp_nm", "laneGrpNm");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("src_lane_grp_nm", "srcLaneGrpNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return vslSlanNm
	 */
	public String getVslSlanNm() {
		return this.vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return srcVslSlanCd
	 */
	public String getSrcVslSlanCd() {
		return this.srcVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return laneGrpNm
	 */
	public String getLaneGrpNm() {
		return this.laneGrpNm;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return srcLaneGrpNm
	 */
	public String getSrcLaneGrpNm() {
		return this.srcLaneGrpNm;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param vslSlanNm
	 */
	public void setVslSlanNm(String vslSlanNm) {
		this.vslSlanNm = vslSlanNm;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param srcVslSlanCd
	 */
	public void setSrcVslSlanCd(String srcVslSlanCd) {
		this.srcVslSlanCd = srcVslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param laneGrpNm
	 */
	public void setLaneGrpNm(String laneGrpNm) {
		this.laneGrpNm = laneGrpNm;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param srcLaneGrpNm
	 */
	public void setSrcLaneGrpNm(String srcLaneGrpNm) {
		this.srcLaneGrpNm = srcLaneGrpNm;
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
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslSlanNm(JSPUtil.getParameter(request, "vsl_slan_nm", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setSrcVslSlanCd(JSPUtil.getParameter(request, "src_vsl_slan_cd", ""));
		setLaneGrpNm(JSPUtil.getParameter(request, "lane_grp_nm", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setSrcLaneGrpNm(JSPUtil.getParameter(request, "src_lane_grp_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UserLaneGroupVO[]
	 */
	public UserLaneGroupVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UserLaneGroupVO[]
	 */
	public UserLaneGroupVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UserLaneGroupVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslSlanNm = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] srcVslSlanCd = (JSPUtil.getParameter(request, prefix	+ "src_vsl_slan_cd", length));
			String[] laneGrpNm = (JSPUtil.getParameter(request, prefix	+ "lane_grp_nm", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] srcLaneGrpNm = (JSPUtil.getParameter(request, prefix	+ "src_lane_grp_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UserLaneGroupVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslSlanNm[i] != null)
					model.setVslSlanNm(vslSlanNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (srcVslSlanCd[i] != null)
					model.setSrcVslSlanCd(srcVslSlanCd[i]);
				if (laneGrpNm[i] != null)
					model.setLaneGrpNm(laneGrpNm[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (srcLaneGrpNm[i] != null)
					model.setSrcLaneGrpNm(srcLaneGrpNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUserLaneGroupVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UserLaneGroupVO[]
	 */
	public UserLaneGroupVO[] getUserLaneGroupVOs(){
		UserLaneGroupVO[] vos = (UserLaneGroupVO[])models.toArray(new UserLaneGroupVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm = this.vslSlanNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcVslSlanCd = this.srcVslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneGrpNm = this.laneGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcLaneGrpNm = this.srcLaneGrpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
