/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Search315VEToBeSentVO.java
*@FileTitle : Search315VEToBeSentVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.30
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2009.11.30 김인수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.bkgcopmanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김인수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Search315VEToBeSentVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Search315VEToBeSentVO> models = new ArrayList<Search315VEToBeSentVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String copPodArrTime = null;
	/* Column Info */
	private String sendEdi = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String pcPodArrTime = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String copPod = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String copStsCd = null;
	/* Column Info */
	private String pcPod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Search315VEToBeSentVO() {}

	public Search315VEToBeSentVO(String ibflag, String pagerows, String bkgNo, String copNo, String cntrNo, String copStsCd, String cntrTpszCd, String copPod, String copPodArrTime, String pcPod, String pcPodArrTime, String vslCd, String skdVoyNo, String skdDirCd, String chk, String cnt, String sendEdi) {
		this.vslCd = vslCd;
		this.cnt = cnt;
		this.copPodArrTime = copPodArrTime;
		this.sendEdi = sendEdi;
		this.copNo = copNo;
		this.skdVoyNo = skdVoyNo;
		this.pcPodArrTime = pcPodArrTime;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.copPod = copPod;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.chk = chk;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.copStsCd = copStsCd;
		this.pcPod = pcPod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("cop_pod_arr_time", getCopPodArrTime());
		this.hashColumns.put("send_edi", getSendEdi());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("pc_pod_arr_time", getPcPodArrTime());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cop_pod", getCopPod());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cop_sts_cd", getCopStsCd());
		this.hashColumns.put("pc_pod", getPcPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("cop_pod_arr_time", "copPodArrTime");
		this.hashFields.put("send_edi", "sendEdi");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("pc_pod_arr_time", "pcPodArrTime");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cop_pod", "copPod");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cop_sts_cd", "copStsCd");
		this.hashFields.put("pc_pod", "pcPod");
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
	 * @return cnt
	 */
	public String getCnt() {
		return this.cnt;
	}
	
	/**
	 * Column Info
	 * @return copPodArrTime
	 */
	public String getCopPodArrTime() {
		return this.copPodArrTime;
	}
	
	/**
	 * Column Info
	 * @return sendEdi
	 */
	public String getSendEdi() {
		return this.sendEdi;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
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
	 * @return pcPodArrTime
	 */
	public String getPcPodArrTime() {
		return this.pcPodArrTime;
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
	 * @return copPod
	 */
	public String getCopPod() {
		return this.copPod;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return copStsCd
	 */
	public String getCopStsCd() {
		return this.copStsCd;
	}
	
	/**
	 * Column Info
	 * @return pcPod
	 */
	public String getPcPod() {
		return this.pcPod;
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
	 * @param cnt
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
	/**
	 * Column Info
	 * @param copPodArrTime
	 */
	public void setCopPodArrTime(String copPodArrTime) {
		this.copPodArrTime = copPodArrTime;
	}
	
	/**
	 * Column Info
	 * @param sendEdi
	 */
	public void setSendEdi(String sendEdi) {
		this.sendEdi = sendEdi;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
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
	 * @param pcPodArrTime
	 */
	public void setPcPodArrTime(String pcPodArrTime) {
		this.pcPodArrTime = pcPodArrTime;
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
	 * @param copPod
	 */
	public void setCopPod(String copPod) {
		this.copPod = copPod;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param copStsCd
	 */
	public void setCopStsCd(String copStsCd) {
		this.copStsCd = copStsCd;
	}
	
	/**
	 * Column Info
	 * @param pcPod
	 */
	public void setPcPod(String pcPod) {
		this.pcPod = pcPod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setCnt(JSPUtil.getParameter(request, "cnt", ""));
		setCopPodArrTime(JSPUtil.getParameter(request, "cop_pod_arr_time", ""));
		setSendEdi(JSPUtil.getParameter(request, "send_edi", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setPcPodArrTime(JSPUtil.getParameter(request, "pc_pod_arr_time", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCopPod(JSPUtil.getParameter(request, "cop_pod", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setChk(JSPUtil.getParameter(request, "chk", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCopStsCd(JSPUtil.getParameter(request, "cop_sts_cd", ""));
		setPcPod(JSPUtil.getParameter(request, "pc_pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Search315VEToBeSentVO[]
	 */
	public Search315VEToBeSentVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Search315VEToBeSentVO[]
	 */
	public Search315VEToBeSentVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Search315VEToBeSentVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));
			String[] copPodArrTime = (JSPUtil.getParameter(request, prefix	+ "cop_pod_arr_time", length));
			String[] sendEdi = (JSPUtil.getParameter(request, prefix	+ "send_edi", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] pcPodArrTime = (JSPUtil.getParameter(request, prefix	+ "pc_pod_arr_time", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] copPod = (JSPUtil.getParameter(request, prefix	+ "cop_pod", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] copStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sts_cd", length));
			String[] pcPod = (JSPUtil.getParameter(request, prefix	+ "pc_pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new Search315VEToBeSentVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				if (copPodArrTime[i] != null)
					model.setCopPodArrTime(copPodArrTime[i]);
				if (sendEdi[i] != null)
					model.setSendEdi(sendEdi[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (pcPodArrTime[i] != null)
					model.setPcPodArrTime(pcPodArrTime[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (copPod[i] != null)
					model.setCopPod(copPod[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (copStsCd[i] != null)
					model.setCopStsCd(copStsCd[i]);
				if (pcPod[i] != null)
					model.setPcPod(pcPod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearch315VEToBeSentVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Search315VEToBeSentVO[]
	 */
	public Search315VEToBeSentVO[] getSearch315VEToBeSentVOs(){
		Search315VEToBeSentVO[] vos = (Search315VEToBeSentVO[])models.toArray(new Search315VEToBeSentVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copPodArrTime = this.copPodArrTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendEdi = this.sendEdi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcPodArrTime = this.pcPodArrTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copPod = this.copPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStsCd = this.copStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcPod = this.pcPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
