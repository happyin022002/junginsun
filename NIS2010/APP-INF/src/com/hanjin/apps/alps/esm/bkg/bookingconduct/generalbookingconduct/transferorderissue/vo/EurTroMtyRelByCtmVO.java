/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurTroMtyRelByCtmVO.java
*@FileTitle : EurTroMtyRelByCtmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.10.28 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurTroMtyRelByCtmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurTroMtyRelByCtmVO> models = new ArrayList<EurTroMtyRelByCtmVO>();
	
	/* Column Info */
	private String boundCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String soSeq = null;
	/* Column Info */
	private String jobDivCd = null;
	/* Column Info */
	private String soCityCd = null;
	/* Column Info */
	private String jobDt = null;
	/* Column Info */
	private String haulageCd = null;
	/* Column Info */
	private String cfmFlag = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EurTroMtyRelByCtmVO() {}

	public EurTroMtyRelByCtmVO(String ibflag, String pagerows, String bkgNo, String boundCd, String haulageCd, String cfmFlag, String jobDivCd, String jobDt, String soCityCd, String soSeq, String troSeq, String ydCd) {
		this.boundCd = boundCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.ydCd = ydCd;
		this.troSeq = troSeq;
		this.soSeq = soSeq;
		this.jobDivCd = jobDivCd;
		this.soCityCd = soCityCd;
		this.jobDt = jobDt;
		this.haulageCd = haulageCd;
		this.cfmFlag = cfmFlag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bound_cd", getBoundCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("so_seq", getSoSeq());
		this.hashColumns.put("job_div_cd", getJobDivCd());
		this.hashColumns.put("so_city_cd", getSoCityCd());
		this.hashColumns.put("job_dt", getJobDt());
		this.hashColumns.put("haulage_cd", getHaulageCd());
		this.hashColumns.put("cfm_flag", getCfmFlag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bound_cd", "boundCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("so_seq", "soSeq");
		this.hashFields.put("job_div_cd", "jobDivCd");
		this.hashFields.put("so_city_cd", "soCityCd");
		this.hashFields.put("job_dt", "jobDt");
		this.hashFields.put("haulage_cd", "haulageCd");
		this.hashFields.put("cfm_flag", "cfmFlag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return boundCd
	 */
	public String getBoundCd() {
		return this.boundCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
	}
	
	/**
	 * Column Info
	 * @return soSeq
	 */
	public String getSoSeq() {
		return this.soSeq;
	}
	
	/**
	 * Column Info
	 * @return jobDivCd
	 */
	public String getJobDivCd() {
		return this.jobDivCd;
	}
	
	/**
	 * Column Info
	 * @return soCityCd
	 */
	public String getSoCityCd() {
		return this.soCityCd;
	}
	
	/**
	 * Column Info
	 * @return jobDt
	 */
	public String getJobDt() {
		return this.jobDt;
	}
	
	/**
	 * Column Info
	 * @return haulageCd
	 */
	public String getHaulageCd() {
		return this.haulageCd;
	}
	
	/**
	 * Column Info
	 * @return cfmFlag
	 */
	public String getCfmFlag() {
		return this.cfmFlag;
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
	 * @param boundCd
	 */
	public void setBoundCd(String boundCd) {
		this.boundCd = boundCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}
	
	/**
	 * Column Info
	 * @param soSeq
	 */
	public void setSoSeq(String soSeq) {
		this.soSeq = soSeq;
	}
	
	/**
	 * Column Info
	 * @param jobDivCd
	 */
	public void setJobDivCd(String jobDivCd) {
		this.jobDivCd = jobDivCd;
	}
	
	/**
	 * Column Info
	 * @param soCityCd
	 */
	public void setSoCityCd(String soCityCd) {
		this.soCityCd = soCityCd;
	}
	
	/**
	 * Column Info
	 * @param jobDt
	 */
	public void setJobDt(String jobDt) {
		this.jobDt = jobDt;
	}
	
	/**
	 * Column Info
	 * @param haulageCd
	 */
	public void setHaulageCd(String haulageCd) {
		this.haulageCd = haulageCd;
	}
	
	/**
	 * Column Info
	 * @param cfmFlag
	 */
	public void setCfmFlag(String cfmFlag) {
		this.cfmFlag = cfmFlag;
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
		setBoundCd(JSPUtil.getParameter(request, "bound_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setTroSeq(JSPUtil.getParameter(request, "tro_seq", ""));
		setSoSeq(JSPUtil.getParameter(request, "so_seq", ""));
		setJobDivCd(JSPUtil.getParameter(request, "job_div_cd", ""));
		setSoCityCd(JSPUtil.getParameter(request, "so_city_cd", ""));
		setJobDt(JSPUtil.getParameter(request, "job_dt", ""));
		setHaulageCd(JSPUtil.getParameter(request, "haulage_cd", ""));
		setCfmFlag(JSPUtil.getParameter(request, "cfm_flag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurTroMtyRelByCtmVO[]
	 */
	public EurTroMtyRelByCtmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurTroMtyRelByCtmVO[]
	 */
	public EurTroMtyRelByCtmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurTroMtyRelByCtmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] boundCd = (JSPUtil.getParameter(request, prefix	+ "bound_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] soSeq = (JSPUtil.getParameter(request, prefix	+ "so_seq", length));
			String[] jobDivCd = (JSPUtil.getParameter(request, prefix	+ "job_div_cd", length));
			String[] soCityCd = (JSPUtil.getParameter(request, prefix	+ "so_city_cd", length));
			String[] jobDt = (JSPUtil.getParameter(request, prefix	+ "job_dt", length));
			String[] haulageCd = (JSPUtil.getParameter(request, prefix	+ "haulage_cd", length));
			String[] cfmFlag = (JSPUtil.getParameter(request, prefix	+ "cfm_flag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurTroMtyRelByCtmVO();
				if (boundCd[i] != null)
					model.setBoundCd(boundCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (soSeq[i] != null)
					model.setSoSeq(soSeq[i]);
				if (jobDivCd[i] != null)
					model.setJobDivCd(jobDivCd[i]);
				if (soCityCd[i] != null)
					model.setSoCityCd(soCityCd[i]);
				if (jobDt[i] != null)
					model.setJobDt(jobDt[i]);
				if (haulageCd[i] != null)
					model.setHaulageCd(haulageCd[i]);
				if (cfmFlag[i] != null)
					model.setCfmFlag(cfmFlag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurTroMtyRelByCtmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurTroMtyRelByCtmVO[]
	 */
	public EurTroMtyRelByCtmVO[] getEurTroMtyRelByCtmVOs(){
		EurTroMtyRelByCtmVO[] vos = (EurTroMtyRelByCtmVO[])models.toArray(new EurTroMtyRelByCtmVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.boundCd = this.boundCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soSeq = this.soSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jobDivCd = this.jobDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCityCd = this.soCityCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jobDt = this.jobDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.haulageCd = this.haulageCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlag = this.cfmFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
