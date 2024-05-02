/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgtCommBasicInformationVO.java
*@FileTitle : AgtCommBasicInformationVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.09.21 이호진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo;

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
 * @author 이호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgtCommBasicInformationVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgtCommBasicInformationVO> models = new ArrayList<AgtCommBasicInformationVO>();
	
	/* Column Info */
	private String oftPpd = null;
	/* Column Info */
	private String post = null;
	/* Column Info */
	private String gross = null;
	/* Column Info */
	private String fdrVvd = null;
	/* Column Info */
	private String svcScp = null;
	/* Column Info */
	private String vendor = null;
	/* Column Info */
	private String por = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String trkVvd = null;
	/* Column Info */
	private String trkSlane = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String chargePpd = null;
	/* Column Info */
	private String agnCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String pre = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String chargeCct = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String oftCct = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AgtCommBasicInformationVO() {}

	public AgtCommBasicInformationVO(String ibflag, String pagerows, String blNo, String bkgNo, String vendor, String agmtNo, String agnCd, String trkVvd, String trkSlane, String fdrVvd, String scNo, String rfaNo, String svcScp, String por, String pol, String pre, String post, String pod, String del, String gross, String oftPpd, String oftCct, String chargePpd, String chargeCct) {
		this.oftPpd = oftPpd;
		this.post = post;
		this.gross = gross;
		this.fdrVvd = fdrVvd;
		this.svcScp = svcScp;
		this.vendor = vendor;
		this.por = por;
		this.agmtNo = agmtNo;
		this.trkVvd = trkVvd;
		this.trkSlane = trkSlane;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.chargePpd = chargePpd;
		this.agnCd = agnCd;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.pre = pre;
		this.scNo = scNo;
		this.chargeCct = chargeCct;
		this.pol = pol;
		this.oftCct = oftCct;
		this.del = del;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("oft_ppd", getOftPpd());
		this.hashColumns.put("post", getPost());
		this.hashColumns.put("gross", getGross());
		this.hashColumns.put("fdr_vvd", getFdrVvd());
		this.hashColumns.put("svc_scp", getSvcScp());
		this.hashColumns.put("vendor", getVendor());
		this.hashColumns.put("por", getPor());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("trk_vvd", getTrkVvd());
		this.hashColumns.put("trk_slane", getTrkSlane());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("charge_ppd", getChargePpd());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pre", getPre());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("charge_cct", getChargeCct());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("oft_cct", getOftCct());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("oft_ppd", "oftPpd");
		this.hashFields.put("post", "post");
		this.hashFields.put("gross", "gross");
		this.hashFields.put("fdr_vvd", "fdrVvd");
		this.hashFields.put("svc_scp", "svcScp");
		this.hashFields.put("vendor", "vendor");
		this.hashFields.put("por", "por");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("trk_vvd", "trkVvd");
		this.hashFields.put("trk_slane", "trkSlane");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("charge_ppd", "chargePpd");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pre", "pre");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("charge_cct", "chargeCct");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("oft_cct", "oftCct");
		this.hashFields.put("del", "del");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return oftPpd
	 */
	public String getOftPpd() {
		return this.oftPpd;
	}
	
	/**
	 * Column Info
	 * @return post
	 */
	public String getPost() {
		return this.post;
	}
	
	/**
	 * Column Info
	 * @return gross
	 */
	public String getGross() {
		return this.gross;
	}
	
	/**
	 * Column Info
	 * @return fdrVvd
	 */
	public String getFdrVvd() {
		return this.fdrVvd;
	}
	
	/**
	 * Column Info
	 * @return svcScp
	 */
	public String getSvcScp() {
		return this.svcScp;
	}
	
	/**
	 * Column Info
	 * @return vendor
	 */
	public String getVendor() {
		return this.vendor;
	}
	
	/**
	 * Column Info
	 * @return por
	 */
	public String getPor() {
		return this.por;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return trkVvd
	 */
	public String getTrkVvd() {
		return this.trkVvd;
	}
	
	/**
	 * Column Info
	 * @return trkSlane
	 */
	public String getTrkSlane() {
		return this.trkSlane;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return chargePpd
	 */
	public String getChargePpd() {
		return this.chargePpd;
	}
	
	/**
	 * Column Info
	 * @return agnCd
	 */
	public String getAgnCd() {
		return this.agnCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return pre
	 */
	public String getPre() {
		return this.pre;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return chargeCct
	 */
	public String getChargeCct() {
		return this.chargeCct;
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
	 * @return oftCct
	 */
	public String getOftCct() {
		return this.oftCct;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
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
	 * @param oftPpd
	 */
	public void setOftPpd(String oftPpd) {
		this.oftPpd = oftPpd;
	}
	
	/**
	 * Column Info
	 * @param post
	 */
	public void setPost(String post) {
		this.post = post;
	}
	
	/**
	 * Column Info
	 * @param gross
	 */
	public void setGross(String gross) {
		this.gross = gross;
	}
	
	/**
	 * Column Info
	 * @param fdrVvd
	 */
	public void setFdrVvd(String fdrVvd) {
		this.fdrVvd = fdrVvd;
	}
	
	/**
	 * Column Info
	 * @param svcScp
	 */
	public void setSvcScp(String svcScp) {
		this.svcScp = svcScp;
	}
	
	/**
	 * Column Info
	 * @param vendor
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	/**
	 * Column Info
	 * @param por
	 */
	public void setPor(String por) {
		this.por = por;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param trkVvd
	 */
	public void setTrkVvd(String trkVvd) {
		this.trkVvd = trkVvd;
	}
	
	/**
	 * Column Info
	 * @param trkSlane
	 */
	public void setTrkSlane(String trkSlane) {
		this.trkSlane = trkSlane;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param chargePpd
	 */
	public void setChargePpd(String chargePpd) {
		this.chargePpd = chargePpd;
	}
	
	/**
	 * Column Info
	 * @param agnCd
	 */
	public void setAgnCd(String agnCd) {
		this.agnCd = agnCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param pre
	 */
	public void setPre(String pre) {
		this.pre = pre;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param chargeCct
	 */
	public void setChargeCct(String chargeCct) {
		this.chargeCct = chargeCct;
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
	 * @param oftCct
	 */
	public void setOftCct(String oftCct) {
		this.oftCct = oftCct;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
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
		setOftPpd(JSPUtil.getParameter(request, "oft_ppd", ""));
		setPost(JSPUtil.getParameter(request, "post", ""));
		setGross(JSPUtil.getParameter(request, "gross", ""));
		setFdrVvd(JSPUtil.getParameter(request, "fdr_vvd", ""));
		setSvcScp(JSPUtil.getParameter(request, "svc_scp", ""));
		setVendor(JSPUtil.getParameter(request, "vendor", ""));
		setPor(JSPUtil.getParameter(request, "por", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setTrkVvd(JSPUtil.getParameter(request, "trk_vvd", ""));
		setTrkSlane(JSPUtil.getParameter(request, "trk_slane", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setChargePpd(JSPUtil.getParameter(request, "charge_ppd", ""));
		setAgnCd(JSPUtil.getParameter(request, "agn_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPre(JSPUtil.getParameter(request, "pre", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setChargeCct(JSPUtil.getParameter(request, "charge_cct", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setOftCct(JSPUtil.getParameter(request, "oft_cct", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgtCommBasicInformationVO[]
	 */
	public AgtCommBasicInformationVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgtCommBasicInformationVO[]
	 */
	public AgtCommBasicInformationVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgtCommBasicInformationVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] oftPpd = (JSPUtil.getParameter(request, prefix	+ "oft_ppd", length));
			String[] post = (JSPUtil.getParameter(request, prefix	+ "post", length));
			String[] gross = (JSPUtil.getParameter(request, prefix	+ "gross", length));
			String[] fdrVvd = (JSPUtil.getParameter(request, prefix	+ "fdr_vvd", length));
			String[] svcScp = (JSPUtil.getParameter(request, prefix	+ "svc_scp", length));
			String[] vendor = (JSPUtil.getParameter(request, prefix	+ "vendor", length));
			String[] por = (JSPUtil.getParameter(request, prefix	+ "por", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] trkVvd = (JSPUtil.getParameter(request, prefix	+ "trk_vvd", length));
			String[] trkSlane = (JSPUtil.getParameter(request, prefix	+ "trk_slane", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] chargePpd = (JSPUtil.getParameter(request, prefix	+ "charge_ppd", length));
			String[] agnCd = (JSPUtil.getParameter(request, prefix	+ "agn_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] pre = (JSPUtil.getParameter(request, prefix	+ "pre", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] chargeCct = (JSPUtil.getParameter(request, prefix	+ "charge_cct", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] oftCct = (JSPUtil.getParameter(request, prefix	+ "oft_cct", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new AgtCommBasicInformationVO();
				if (oftPpd[i] != null)
					model.setOftPpd(oftPpd[i]);
				if (post[i] != null)
					model.setPost(post[i]);
				if (gross[i] != null)
					model.setGross(gross[i]);
				if (fdrVvd[i] != null)
					model.setFdrVvd(fdrVvd[i]);
				if (svcScp[i] != null)
					model.setSvcScp(svcScp[i]);
				if (vendor[i] != null)
					model.setVendor(vendor[i]);
				if (por[i] != null)
					model.setPor(por[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (trkVvd[i] != null)
					model.setTrkVvd(trkVvd[i]);
				if (trkSlane[i] != null)
					model.setTrkSlane(trkSlane[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (chargePpd[i] != null)
					model.setChargePpd(chargePpd[i]);
				if (agnCd[i] != null)
					model.setAgnCd(agnCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (pre[i] != null)
					model.setPre(pre[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (chargeCct[i] != null)
					model.setChargeCct(chargeCct[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (oftCct[i] != null)
					model.setOftCct(oftCct[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgtCommBasicInformationVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgtCommBasicInformationVO[]
	 */
	public AgtCommBasicInformationVO[] getAgtCommBasicInformationVOs(){
		AgtCommBasicInformationVO[] vos = (AgtCommBasicInformationVO[])models.toArray(new AgtCommBasicInformationVO[models.size()]);
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
		this.oftPpd = this.oftPpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.post = this.post .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gross = this.gross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fdrVvd = this.fdrVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScp = this.svcScp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendor = this.vendor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por = this.por .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkVvd = this.trkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trkSlane = this.trkSlane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargePpd = this.chargePpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd = this.agnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pre = this.pre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeCct = this.chargeCct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftCct = this.oftCct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
