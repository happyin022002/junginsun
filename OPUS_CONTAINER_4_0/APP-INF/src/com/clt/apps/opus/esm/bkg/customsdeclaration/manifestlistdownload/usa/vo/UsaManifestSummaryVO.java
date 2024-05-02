/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestSummaryVO.java
*@FileTitle : UsaManifestSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.10.07 김도완 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaManifestSummaryVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaManifestSummaryVO> models = new ArrayList<UsaManifestSummaryVO>();
	
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String cntrCount = null;
	/* Column Info */
	private String etd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sentTime = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String blCount = null;
	/* Column Info */
	private String mblCount01 = null;
	/* Column Info */
	private String hblCount = null;
	/* Column Info */
	private String bdrCount = null;
	/* Column Info */
	private String mblCount03 = null;
	/* Column Info */
	private String mblCount02 = null;
	/* Column Info */
	private String frob = null;
	/* Column Info */
	private String customs = null;
	/* Column Info */
	private String mi = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaManifestSummaryVO() {}

	public UsaManifestSummaryVO(String ibflag, String pagerows, String vvd, String pol, String pod, String eta, String frob, String customs, String sentTime, String mi, String cntrCount, String blCount, String mblCount01, String mblCount02, String mblCount03, String hblCount, String etd, String bdrCount) {
		this.eta = eta;
		this.cntrCount = cntrCount;
		this.etd = etd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.sentTime = sentTime;
		this.pol = pol;
		this.blCount = blCount;
		this.mblCount01 = mblCount01;
		this.hblCount = hblCount;
		this.bdrCount = bdrCount;
		this.mblCount03 = mblCount03;
		this.mblCount02 = mblCount02;
		this.frob = frob;
		this.customs = customs;
		this.mi = mi;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("cntr_count", getCntrCount());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sent_time", getSentTime());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("bl_count", getBlCount());
		this.hashColumns.put("mbl_count01", getMblCount01());
		this.hashColumns.put("hbl_count", getHblCount());
		this.hashColumns.put("bdr_count", getBdrCount());
		this.hashColumns.put("mbl_count03", getMblCount03());
		this.hashColumns.put("mbl_count02", getMblCount02());
		this.hashColumns.put("frob", getFrob());
		this.hashColumns.put("customs", getCustoms());
		this.hashColumns.put("mi", getMi());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta", "eta");
		this.hashFields.put("cntr_count", "cntrCount");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sent_time", "sentTime");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("bl_count", "blCount");
		this.hashFields.put("mbl_count01", "mblCount01");
		this.hashFields.put("hbl_count", "hblCount");
		this.hashFields.put("bdr_count", "bdrCount");
		this.hashFields.put("mbl_count03", "mblCount03");
		this.hashFields.put("mbl_count02", "mblCount02");
		this.hashFields.put("frob", "frob");
		this.hashFields.put("customs", "customs");
		this.hashFields.put("mi", "mi");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return cntrCount
	 */
	public String getCntrCount() {
		return this.cntrCount;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return sentTime
	 */
	public String getSentTime() {
		return this.sentTime;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return blCount
	 */
	public String getBlCount() {
		return this.blCount;
	}
	
	/**
	 * Column Info
	 * @return mblCount01
	 */
	public String getMblCount01() {
		return this.mblCount01;
	}
	
	/**
	 * Column Info
	 * @return hblCount
	 */
	public String getHblCount() {
		return this.hblCount;
	}
	
	/**
	 * Column Info
	 * @return bdrCount
	 */
	public String getBdrCount() {
		return this.bdrCount;
	}
	
	/**
	 * Column Info
	 * @return mblCount03
	 */
	public String getMblCount03() {
		return this.mblCount03;
	}
	
	/**
	 * Column Info
	 * @return mblCount02
	 */
	public String getMblCount02() {
		return this.mblCount02;
	}
	
	/**
	 * Column Info
	 * @return frob
	 */
	public String getFrob() {
		return this.frob;
	}
	
	/**
	 * Column Info
	 * @return customs
	 */
	public String getCustoms() {
		return this.customs;
	}
	
	/**
	 * Column Info
	 * @return mi
	 */
	public String getMi() {
		return this.mi;
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
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param cntrCount
	 */
	public void setCntrCount(String cntrCount) {
		this.cntrCount = cntrCount;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param sentTime
	 */
	public void setSentTime(String sentTime) {
		this.sentTime = sentTime;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param blCount
	 */
	public void setBlCount(String blCount) {
		this.blCount = blCount;
	}
	
	/**
	 * Column Info
	 * @param mblCount01
	 */
	public void setMblCount01(String mblCount01) {
		this.mblCount01 = mblCount01;
	}
	
	/**
	 * Column Info
	 * @param hblCount
	 */
	public void setHblCount(String hblCount) {
		this.hblCount = hblCount;
	}
	
	/**
	 * Column Info
	 * @param bdrCount
	 */
	public void setBdrCount(String bdrCount) {
		this.bdrCount = bdrCount;
	}
	
	/**
	 * Column Info
	 * @param mblCount03
	 */
	public void setMblCount03(String mblCount03) {
		this.mblCount03 = mblCount03;
	}
	
	/**
	 * Column Info
	 * @param mblCount02
	 */
	public void setMblCount02(String mblCount02) {
		this.mblCount02 = mblCount02;
	}
	
	/**
	 * Column Info
	 * @param frob
	 */
	public void setFrob(String frob) {
		this.frob = frob;
	}
	
	/**
	 * Column Info
	 * @param customs
	 */
	public void setCustoms(String customs) {
		this.customs = customs;
	}
	
	/**
	 * Column Info
	 * @param mi
	 */
	public void setMi(String mi) {
		this.mi = mi;
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
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setCntrCount(JSPUtil.getParameter(request, "cntr_count", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSentTime(JSPUtil.getParameter(request, "sent_time", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setBlCount(JSPUtil.getParameter(request, "bl_count", ""));
		setMblCount01(JSPUtil.getParameter(request, "mbl_count01", ""));
		setHblCount(JSPUtil.getParameter(request, "hbl_count", ""));
		setBdrCount(JSPUtil.getParameter(request, "bdr_count", ""));
		setMblCount03(JSPUtil.getParameter(request, "mbl_count03", ""));
		setMblCount02(JSPUtil.getParameter(request, "mbl_count02", ""));
		setFrob(JSPUtil.getParameter(request, "frob", ""));
		setCustoms(JSPUtil.getParameter(request, "customs", ""));
		setMi(JSPUtil.getParameter(request, "mi", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaManifestSummaryVO[]
	 */
	public UsaManifestSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaManifestSummaryVO[]
	 */
	public UsaManifestSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaManifestSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] cntrCount = (JSPUtil.getParameter(request, prefix	+ "cntr_count", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sentTime = (JSPUtil.getParameter(request, prefix	+ "sent_time", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] blCount = (JSPUtil.getParameter(request, prefix	+ "bl_count", length));
			String[] mblCount01 = (JSPUtil.getParameter(request, prefix	+ "mbl_count01", length));
			String[] hblCount = (JSPUtil.getParameter(request, prefix	+ "hbl_count", length));
			String[] bdrCount = (JSPUtil.getParameter(request, prefix	+ "bdr_count", length));
			String[] mblCount03 = (JSPUtil.getParameter(request, prefix	+ "mbl_count03", length));
			String[] mblCount02 = (JSPUtil.getParameter(request, prefix	+ "mbl_count02", length));
			String[] frob = (JSPUtil.getParameter(request, prefix	+ "frob", length));
			String[] customs = (JSPUtil.getParameter(request, prefix	+ "customs", length));
			String[] mi = (JSPUtil.getParameter(request, prefix	+ "mi", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaManifestSummaryVO();
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (cntrCount[i] != null)
					model.setCntrCount(cntrCount[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sentTime[i] != null)
					model.setSentTime(sentTime[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (blCount[i] != null)
					model.setBlCount(blCount[i]);
				if (mblCount01[i] != null)
					model.setMblCount01(mblCount01[i]);
				if (hblCount[i] != null)
					model.setHblCount(hblCount[i]);
				if (bdrCount[i] != null)
					model.setBdrCount(bdrCount[i]);
				if (mblCount03[i] != null)
					model.setMblCount03(mblCount03[i]);
				if (mblCount02[i] != null)
					model.setMblCount02(mblCount02[i]);
				if (frob[i] != null)
					model.setFrob(frob[i]);
				if (customs[i] != null)
					model.setCustoms(customs[i]);
				if (mi[i] != null)
					model.setMi(mi[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaManifestSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaManifestSummaryVO[]
	 */
	public UsaManifestSummaryVO[] getUsaManifestSummaryVOs(){
		UsaManifestSummaryVO[] vos = (UsaManifestSummaryVO[])models.toArray(new UsaManifestSummaryVO[models.size()]);
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
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCount = this.cntrCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sentTime = this.sentTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCount = this.blCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblCount01 = this.mblCount01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblCount = this.hblCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrCount = this.bdrCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblCount03 = this.mblCount03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mblCount02 = this.mblCount02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frob = this.frob .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customs = this.customs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mi = this.mi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
