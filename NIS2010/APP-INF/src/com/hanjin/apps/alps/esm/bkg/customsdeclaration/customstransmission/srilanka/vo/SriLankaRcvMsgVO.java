/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SriLankaRcvMsgVO.java
*@FileTitle : SriLankaRcvMsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.25 임재택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SriLankaRcvMsgVO extends RcvMsgVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<SriLankaRcvMsgVO> models = new ArrayList<SriLankaRcvMsgVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String srStsCd = null;
	/* Column Info */
	private String vslRgstNo = null;
	/* Column Info */
	private String rspnDivCd = null;
	/* Column Info */
	private String srStsDesc = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String depDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rdate = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rtime = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String rjctDt = null;
	/* Column Info */
	private String rgstDt = null;
	/* Column Info */
	private String vslAuthNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SriLankaRcvMsgVO() {}

	public SriLankaRcvMsgVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String srStsCd, String vslNm, String vslAuthNo, String vslRgstNo, String depDt, String rgstDt, String rjctDt, String srStsDesc, String userId, String rspnDivCd, String rdate, String rtime) {
		this.vslCd = vslCd;
		this.srStsCd = srStsCd;
		this.vslRgstNo = vslRgstNo;
		this.rspnDivCd = rspnDivCd;
		this.srStsDesc = srStsDesc;
		this.skdVoyNo = skdVoyNo;
		this.vslNm = vslNm;
		this.depDt = depDt;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.rdate = rdate;
		this.ibflag = ibflag;
		this.rtime = rtime;
		this.userId = userId;
		this.rjctDt = rjctDt;
		this.rgstDt = rgstDt;
		this.vslAuthNo = vslAuthNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("sr_sts_cd", getSrStsCd());
		this.hashColumns.put("vsl_rgst_no", getVslRgstNo());
		this.hashColumns.put("rspn_div_cd", getRspnDivCd());
		this.hashColumns.put("sr_sts_desc", getSrStsDesc());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("dep_dt", getDepDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rdate", getRdate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rtime", getRtime());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("rjct_dt", getRjctDt());
		this.hashColumns.put("rgst_dt", getRgstDt());
		this.hashColumns.put("vsl_auth_no", getVslAuthNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("sr_sts_cd", "srStsCd");
		this.hashFields.put("vsl_rgst_no", "vslRgstNo");
		this.hashFields.put("rspn_div_cd", "rspnDivCd");
		this.hashFields.put("sr_sts_desc", "srStsDesc");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("dep_dt", "depDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rdate", "rdate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rtime", "rtime");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("rjct_dt", "rjctDt");
		this.hashFields.put("rgst_dt", "rgstDt");
		this.hashFields.put("vsl_auth_no", "vslAuthNo");
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
	 * @return srStsCd
	 */
	public String getSrStsCd() {
		return this.srStsCd;
	}
	
	/**
	 * Column Info
	 * @return vslRgstNo
	 */
	public String getVslRgstNo() {
		return this.vslRgstNo;
	}
	
	/**
	 * Column Info
	 * @return rspnDivCd
	 */
	public String getRspnDivCd() {
		return this.rspnDivCd;
	}
	
	/**
	 * Column Info
	 * @return srStsDesc
	 */
	public String getSrStsDesc() {
		return this.srStsDesc;
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
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return depDt
	 */
	public String getDepDt() {
		return this.depDt;
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
	 * @return rdate
	 */
	public String getRdate() {
		return this.rdate;
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
	 * @return rtime
	 */
	public String getRtime() {
		return this.rtime;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return rjctDt
	 */
	public String getRjctDt() {
		return this.rjctDt;
	}
	
	/**
	 * Column Info
	 * @return rgstDt
	 */
	public String getRgstDt() {
		return this.rgstDt;
	}
	
	/**
	 * Column Info
	 * @return vslAuthNo
	 */
	public String getVslAuthNo() {
		return this.vslAuthNo;
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
	 * @param srStsCd
	 */
	public void setSrStsCd(String srStsCd) {
		this.srStsCd = srStsCd;
	}
	
	/**
	 * Column Info
	 * @param vslRgstNo
	 */
	public void setVslRgstNo(String vslRgstNo) {
		this.vslRgstNo = vslRgstNo;
	}
	
	/**
	 * Column Info
	 * @param rspnDivCd
	 */
	public void setRspnDivCd(String rspnDivCd) {
		this.rspnDivCd = rspnDivCd;
	}
	
	/**
	 * Column Info
	 * @param srStsDesc
	 */
	public void setSrStsDesc(String srStsDesc) {
		this.srStsDesc = srStsDesc;
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
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param depDt
	 */
	public void setDepDt(String depDt) {
		this.depDt = depDt;
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
	 * @param rdate
	 */
	public void setRdate(String rdate) {
		this.rdate = rdate;
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
	 * @param rtime
	 */
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param rjctDt
	 */
	public void setRjctDt(String rjctDt) {
		this.rjctDt = rjctDt;
	}
	
	/**
	 * Column Info
	 * @param rgstDt
	 */
	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}
	
	/**
	 * Column Info
	 * @param vslAuthNo
	 */
	public void setVslAuthNo(String vslAuthNo) {
		this.vslAuthNo = vslAuthNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSrStsCd(JSPUtil.getParameter(request, "sr_sts_cd", ""));
		setVslRgstNo(JSPUtil.getParameter(request, "vsl_rgst_no", ""));
		setRspnDivCd(JSPUtil.getParameter(request, "rspn_div_cd", ""));
		setSrStsDesc(JSPUtil.getParameter(request, "sr_sts_desc", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setDepDt(JSPUtil.getParameter(request, "dep_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRdate(JSPUtil.getParameter(request, "rdate", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRtime(JSPUtil.getParameter(request, "rtime", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setRjctDt(JSPUtil.getParameter(request, "rjct_dt", ""));
		setRgstDt(JSPUtil.getParameter(request, "rgst_dt", ""));
		setVslAuthNo(JSPUtil.getParameter(request, "vsl_auth_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SriLankaRcvMsgVO[]
	 */
	public SriLankaRcvMsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SriLankaRcvMsgVO[]
	 */
	public SriLankaRcvMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SriLankaRcvMsgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] srStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_sts_cd", length));
			String[] vslRgstNo = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_no", length));
			String[] rspnDivCd = (JSPUtil.getParameter(request, prefix	+ "rspn_div_cd", length));
			String[] srStsDesc = (JSPUtil.getParameter(request, prefix	+ "sr_sts_desc", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] depDt = (JSPUtil.getParameter(request, prefix	+ "dep_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rdate = (JSPUtil.getParameter(request, prefix	+ "rdate", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rtime = (JSPUtil.getParameter(request, prefix	+ "rtime", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] rjctDt = (JSPUtil.getParameter(request, prefix	+ "rjct_dt", length));
			String[] rgstDt = (JSPUtil.getParameter(request, prefix	+ "rgst_dt", length));
			String[] vslAuthNo = (JSPUtil.getParameter(request, prefix	+ "vsl_auth_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SriLankaRcvMsgVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (srStsCd[i] != null)
					model.setSrStsCd(srStsCd[i]);
				if (vslRgstNo[i] != null)
					model.setVslRgstNo(vslRgstNo[i]);
				if (rspnDivCd[i] != null)
					model.setRspnDivCd(rspnDivCd[i]);
				if (srStsDesc[i] != null)
					model.setSrStsDesc(srStsDesc[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (depDt[i] != null)
					model.setDepDt(depDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rdate[i] != null)
					model.setRdate(rdate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rtime[i] != null)
					model.setRtime(rtime[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (rjctDt[i] != null)
					model.setRjctDt(rjctDt[i]);
				if (rgstDt[i] != null)
					model.setRgstDt(rgstDt[i]);
				if (vslAuthNo[i] != null)
					model.setVslAuthNo(vslAuthNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSriLankaRcvMsgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SriLankaRcvMsgVO[]
	 */
	public SriLankaRcvMsgVO[] getSriLankaRcvMsgVOs(){
		SriLankaRcvMsgVO[] vos = (SriLankaRcvMsgVO[])models.toArray(new SriLankaRcvMsgVO[models.size()]);
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
		this.srStsCd = this.srStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstNo = this.vslRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rspnDivCd = this.rspnDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srStsDesc = this.srStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDt = this.depDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdate = this.rdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtime = this.rtime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctDt = this.rjctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstDt = this.rgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAuthNo = this.vslAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
