/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCstmsVesselArrivalVOVO.java
*@FileTitle : AncsCstmsVesselArrivalVOVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.05.27 정재엽 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVesselArrivalVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AncsCstmsVesselArrivalVO extends CstmsVesselArrivalVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsCstmsVesselArrivalVO> models = new ArrayList<AncsCstmsVesselArrivalVO>();
	
	/* Column Info */
	private String userDate = null;
	/* Column Info */
	private String etaCallDate = null;
	/* Column Info */
	private String berthCode = null;
	/* Column Info */
	private String bkgTtl = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String vslFlag = null;
	/* Column Info */
	private String lloydType = null;
	/* Column Info */
	private String vslName = null;
	/* Column Info */
	private String crsrep = null;
	/* Column Info */
	private String lastEdi = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ssrNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String demdetFreeTime = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String dnldTtl = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String prvProt = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AncsCstmsVesselArrivalVO() {}

	public AncsCstmsVesselArrivalVO(String ibflag, String pagerows, String vvd, String ssrNo, String lloydType, String lloydNo, String vslFlag, String vslName, String prvProt, String berthCode, String pod, String etaCallDate, String demdetFreeTime, String remark, String crsrep, String lastEdi, String userId, String userDate, String bkgTtl, String dnldTtl) {
		this.userDate = userDate;
		this.etaCallDate = etaCallDate;
		this.berthCode = berthCode;
		this.bkgTtl = bkgTtl;
		this.remark = remark;
		this.vslFlag = vslFlag;
		this.lloydType = lloydType;
		this.vslName = vslName;
		this.crsrep = crsrep;
		this.lastEdi = lastEdi;
		this.pagerows = pagerows;
		this.ssrNo = ssrNo;
		this.vvd = vvd;
		this.demdetFreeTime = demdetFreeTime;
		this.ibflag = ibflag;
		this.lloydNo = lloydNo;
		this.dnldTtl = dnldTtl;
		this.userId = userId;
		this.prvProt = prvProt;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_date", getUserDate());
		this.hashColumns.put("eta_call_date", getEtaCallDate());
		this.hashColumns.put("berth_code", getBerthCode());
		this.hashColumns.put("bkg_ttl", getBkgTtl());
	    
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("vsl_flag", getVslFlag());
		this.hashColumns.put("lloyd_type", getLloydType());
		this.hashColumns.put("vsl_name", getVslName());
		
		this.hashColumns.put("crsrep", getCrsrep());
		this.hashColumns.put("last_edi", getLastEdi());
		this.hashColumns.put("pagerows", getPagerows());
		
		this.hashColumns.put("ssr_no", getSsrNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("demdet_free_time", getDemdetFreeTime());
		
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("dnld_ttl", getDnldTtl());
		
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("prv_prot", getPrvProt());
		this.hashColumns.put("pod", getPod());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_date", "userDate");
		this.hashFields.put("eta_call_date", "etaCallDate");
		this.hashFields.put("berth_code", "berthCode");
		this.hashFields.put("bkg_ttl", "bkgTtl");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("vsl_flag", "vslFlag");
		this.hashFields.put("lloyd_type", "lloydType");
		this.hashFields.put("vsl_name", "vslName");
		this.hashFields.put("crsrep", "crsrep");
		this.hashFields.put("last_edi", "lastEdi");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ssr_no", "ssrNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("demdet_free_time", "demdetFreeTime");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("dnld_ttl", "dnldTtl");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("prv_prot", "prvProt");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userDate
	 */
	public String getUserDate() {
		return this.userDate;
	}
	
	/**
	 * Column Info
	 * @return etaCallDate
	 */
	public String getEtaCallDate() {
		return this.etaCallDate;
	}
	
	/**
	 * Column Info
	 * @return berthCode
	 */
	public String getBerthCode() {
		return this.berthCode;
	}
	
	/**
	 * Column Info
	 * @return bkgTtl
	 */
	public String getBkgTtl() {
		return this.bkgTtl;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return vslFlag
	 */
	public String getVslFlag() {
		return this.vslFlag;
	}
	
	/**
	 * Column Info
	 * @return lloydType
	 */
	public String getLloydType() {
		return this.lloydType;
	}
	
	/**
	 * Column Info
	 * @return vslName
	 */
	public String getVslName() {
		return this.vslName;
	}
	
	/**
	 * Column Info
	 * @return crsrep
	 */
	public String getCrsrep() {
		return this.crsrep;
	}
	
	/**
	 * Column Info
	 * @return lastEdi
	 */
	public String getLastEdi() {
		return this.lastEdi;
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
	 * @return ssrNo
	 */
	public String getSsrNo() {
		return this.ssrNo;
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
	 * @return demdetFreeTime
	 */
	public String getDemdetFreeTime() {
		return this.demdetFreeTime;
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
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return dnldTtl
	 */
	public String getDnldTtl() {
		return this.dnldTtl;
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
	 * @return prvProt
	 */
	public String getPrvProt() {
		return this.prvProt;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	

	/**
	 * Column Info
	 * @param userDate
	 */
	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}
	
	/**
	 * Column Info
	 * @param etaCallDate
	 */
	public void setEtaCallDate(String etaCallDate) {
		this.etaCallDate = etaCallDate;
	}
	
	/**
	 * Column Info
	 * @param berthCode
	 */
	public void setBerthCode(String berthCode) {
		this.berthCode = berthCode;
	}
	
	/**
	 * Column Info
	 * @param bkgTtl
	 */
	public void setBkgTtl(String bkgTtl) {
		this.bkgTtl = bkgTtl;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param vslFlag
	 */
	public void setVslFlag(String vslFlag) {
		this.vslFlag = vslFlag;
	}
	
	/**
	 * Column Info
	 * @param lloydType
	 */
	public void setLloydType(String lloydType) {
		this.lloydType = lloydType;
	}
	
	/**
	 * Column Info
	 * @param vslName
	 */
	public void setVslName(String vslName) {
		this.vslName = vslName;
	}
	
	/**
	 * Column Info
	 * @param crsrep
	 */
	public void setCrsrep(String crsrep) {
		this.crsrep = crsrep;
	}
	
	/**
	 * Column Info
	 * @param lastEdi
	 */
	public void setLastEdi(String lastEdi) {
		this.lastEdi = lastEdi;
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
	 * @param ssrNo
	 */
	public void setSsrNo(String ssrNo) {
		this.ssrNo = ssrNo;
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
	 * @param demdetFreeTime
	 */
	public void setDemdetFreeTime(String demdetFreeTime) {
		this.demdetFreeTime = demdetFreeTime;
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
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param dnldTtl
	 */
	public void setDnldTtl(String dnldTtl) {
		this.dnldTtl = dnldTtl;
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
	 * @param prvProt
	 */
	public void setPrvProt(String prvProt) {
		this.prvProt = prvProt;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUserDate(JSPUtil.getParameter(request, "user_date", ""));
		setEtaCallDate(JSPUtil.getParameter(request, "eta_call_date", ""));
		setBerthCode(JSPUtil.getParameter(request, "berth_code", ""));
		setBkgTtl(JSPUtil.getParameter(request, "bkg_ttl", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setVslFlag(JSPUtil.getParameter(request, "vsl_flag", ""));
		setLloydType(JSPUtil.getParameter(request, "lloyd_type", ""));
		setVslName(JSPUtil.getParameter(request, "vsl_name", ""));
		setCrsrep(JSPUtil.getParameter(request, "crsrep", ""));
		setLastEdi(JSPUtil.getParameter(request, "last_edi", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSsrNo(JSPUtil.getParameter(request, "ssr_no", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setDemdetFreeTime(JSPUtil.getParameter(request, "demdet_free_time", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLloydNo(JSPUtil.getParameter(request, "lloyd_no", ""));
		setDnldTtl(JSPUtil.getParameter(request, "dnld_ttl", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setPrvProt(JSPUtil.getParameter(request, "prv_prot", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsVesselArrivalVOVO[]
	 */
	public AncsCstmsVesselArrivalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsVesselArrivalVOVO[]
	 */
	public AncsCstmsVesselArrivalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsCstmsVesselArrivalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userDate = (JSPUtil.getParameter(request, prefix	+ "user_date".trim(), length));
			String[] etaCallDate = (JSPUtil.getParameter(request, prefix	+ "eta_call_date".trim(), length));
			String[] berthCode = (JSPUtil.getParameter(request, prefix	+ "berth_code".trim(), length));
			String[] bkgTtl = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl".trim(), length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark".trim(), length));
			String[] vslFlag = (JSPUtil.getParameter(request, prefix	+ "vsl_flag".trim(), length));
			String[] lloydType = (JSPUtil.getParameter(request, prefix	+ "lloyd_type".trim(), length));
			String[] vslName = (JSPUtil.getParameter(request, prefix	+ "vsl_name".trim(), length));
			String[] crsrep = (JSPUtil.getParameter(request, prefix	+ "crsrep".trim(), length));
			String[] lastEdi = (JSPUtil.getParameter(request, prefix	+ "last_edi".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ssrNo = (JSPUtil.getParameter(request, prefix	+ "ssr_no".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] demdetFreeTime = (JSPUtil.getParameter(request, prefix	+ "demdet_free_time".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no".trim(), length));
			String[] dnldTtl = (JSPUtil.getParameter(request, prefix	+ "dnld_ttl".trim(), length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id".trim(), length));
			String[] prvProt = (JSPUtil.getParameter(request, prefix	+ "prv_prot".trim(), length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsCstmsVesselArrivalVO();
				if (userDate[i] != null)
					model.setUserDate(userDate[i]);
				if (etaCallDate[i] != null)
					model.setEtaCallDate(etaCallDate[i]);
				if (berthCode[i] != null)
					model.setBerthCode(berthCode[i]);
				if (bkgTtl[i] != null)
					model.setBkgTtl(bkgTtl[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (vslFlag[i] != null)
					model.setVslFlag(vslFlag[i]);
				if (lloydType[i] != null)
					model.setLloydType(lloydType[i]);
				if (vslName[i] != null)
					model.setVslName(vslName[i]);
				if (crsrep[i] != null)
					model.setCrsrep(crsrep[i]);
				if (lastEdi[i] != null)
					model.setLastEdi(lastEdi[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ssrNo[i] != null)
					model.setSsrNo(ssrNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (demdetFreeTime[i] != null)
					model.setDemdetFreeTime(demdetFreeTime[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (dnldTtl[i] != null)
					model.setDnldTtl(dnldTtl[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (prvProt[i] != null)
					model.setPrvProt(prvProt[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsVesselArrivalVOVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsVesselArrivalVOVO[]
	 */
	public AncsCstmsVesselArrivalVO[] getAncsCstmsVesselArrivalVOVOs(){
		AncsCstmsVesselArrivalVO[] vos = (AncsCstmsVesselArrivalVO[])models.toArray(new AncsCstmsVesselArrivalVO[models.size()]);
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
		this.userDate = this.userDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaCallDate = this.etaCallDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.berthCode = this.berthCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtl = this.bkgTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFlag = this.vslFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydType = this.lloydType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslName = this.vslName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crsrep = this.crsrep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastEdi = this.lastEdi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ssrNo = this.ssrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demdetFreeTime = this.demdetFreeTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dnldTtl = this.dnldTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prvProt = this.prvProt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
