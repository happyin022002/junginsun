/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrClmInfosVO.java
*@FileTitle : CntrClmInfosVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrClmInfosVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrClmInfosVO> models = new ArrayList<CntrClmInfosVO>();
	
	/* Column Info */
	private String fcarNo = null;
	/* Column Info */
	private String trnNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String clmCrrNm = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String mvmtStsNm = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String mvmtEvntDt = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrClmInfosVO() {}

	public CntrClmInfosVO(String ibflag, String pagerows, String cntrNo, String mvmtStsNm, String mvmtEvntDt, String orgYdCd, String destYdCd, String clmCrrNm, String trnNo, String fcarNo) {
		this.fcarNo = fcarNo;
		this.trnNo = trnNo;
		this.ibflag = ibflag;
		this.clmCrrNm = clmCrrNm;
		this.cntrNo = cntrNo;
		this.mvmtStsNm = mvmtStsNm;
		this.destYdCd = destYdCd;
		this.mvmtEvntDt = mvmtEvntDt;
		this.orgYdCd = orgYdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fcar_no", getFcarNo());
		this.hashColumns.put("trn_no", getTrnNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("clm_crr_nm", getClmCrrNm());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("mvmt_sts_nm", getMvmtStsNm());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("mvmt_evnt_dt", getMvmtEvntDt());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fcar_no", "fcarNo");
		this.hashFields.put("trn_no", "trnNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("clm_crr_nm", "clmCrrNm");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("mvmt_sts_nm", "mvmtStsNm");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("mvmt_evnt_dt", "mvmtEvntDt");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fcarNo
	 */
	public String getFcarNo() {
		return this.fcarNo;
	}
	
	/**
	 * Column Info
	 * @return trnNo
	 */
	public String getTrnNo() {
		return this.trnNo;
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
	 * @return clmCrrNm
	 */
	public String getClmCrrNm() {
		return this.clmCrrNm;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtStsNm
	 */
	public String getMvmtStsNm() {
		return this.mvmtStsNm;
	}
	
	/**
	 * Column Info
	 * @return destYdCd
	 */
	public String getDestYdCd() {
		return this.destYdCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtEvntDt
	 */
	public String getMvmtEvntDt() {
		return this.mvmtEvntDt;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
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
	 * @param fcarNo
	 */
	public void setFcarNo(String fcarNo) {
		this.fcarNo = fcarNo;
	}
	
	/**
	 * Column Info
	 * @param trnNo
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
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
	 * @param clmCrrNm
	 */
	public void setClmCrrNm(String clmCrrNm) {
		this.clmCrrNm = clmCrrNm;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtStsNm
	 */
	public void setMvmtStsNm(String mvmtStsNm) {
		this.mvmtStsNm = mvmtStsNm;
	}
	
	/**
	 * Column Info
	 * @param destYdCd
	 */
	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtEvntDt
	 */
	public void setMvmtEvntDt(String mvmtEvntDt) {
		this.mvmtEvntDt = mvmtEvntDt;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
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
		setFcarNo(JSPUtil.getParameter(request, "fcar_no", ""));
		setTrnNo(JSPUtil.getParameter(request, "trn_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setClmCrrNm(JSPUtil.getParameter(request, "clm_crr_nm", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setMvmtStsNm(JSPUtil.getParameter(request, "mvmt_sts_nm", ""));
		setDestYdCd(JSPUtil.getParameter(request, "dest_yd_cd", ""));
		setMvmtEvntDt(JSPUtil.getParameter(request, "mvmt_evnt_dt", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrClmInfosVO[]
	 */
	public CntrClmInfosVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrClmInfosVO[]
	 */
	public CntrClmInfosVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrClmInfosVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fcarNo = (JSPUtil.getParameter(request, prefix	+ "fcar_no", length));
			String[] trnNo = (JSPUtil.getParameter(request, prefix	+ "trn_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] clmCrrNm = (JSPUtil.getParameter(request, prefix	+ "clm_crr_nm", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] mvmtStsNm = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts_nm", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] mvmtEvntDt = (JSPUtil.getParameter(request, prefix	+ "mvmt_evnt_dt", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrClmInfosVO();
				if (fcarNo[i] != null)
					model.setFcarNo(fcarNo[i]);
				if (trnNo[i] != null)
					model.setTrnNo(trnNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (clmCrrNm[i] != null)
					model.setClmCrrNm(clmCrrNm[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (mvmtStsNm[i] != null)
					model.setMvmtStsNm(mvmtStsNm[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (mvmtEvntDt[i] != null)
					model.setMvmtEvntDt(mvmtEvntDt[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrClmInfosVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrClmInfosVO[]
	 */
	public CntrClmInfosVO[] getCntrClmInfosVOs(){
		CntrClmInfosVO[] vos = (CntrClmInfosVO[])models.toArray(new CntrClmInfosVO[models.size()]);
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
		this.fcarNo = this.fcarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnNo = this.trnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCrrNm = this.clmCrrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsNm = this.mvmtStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEvntDt = this.mvmtEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
