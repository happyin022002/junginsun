/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestListCondForEdiVO.java
*@FileTitle : UsaManifestListCondForEdiVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.29 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondForEdiVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaManifestListCondForEdiVO extends ManifestListCondForEdiVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaManifestListCondForEdiVO> models = new ArrayList<UsaManifestListCondForEdiVO>();
	
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String miTransmitTime = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String miTransmit = null;
	/* Column Info */
	private String edaoreta = null;
	/* Column Info */
	private String atdTime = null;
	/* Column Info */
	private String hiSndYn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String etaTime = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sndUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String hiTransmitTime = null;
	/* Column Info */
	private String blCount = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String atd = null;
	/* Column Info */
	private String hiTransmit = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaManifestListCondForEdiVO() {}

	public UsaManifestListCondForEdiVO(String ibflag, String pagerows, String vvd, String podCd, String polCd, String blCount, String name, String atd, String eta, String atdTime, String etaTime, String miTransmit, String miTransmitTime, String usrId, String ofcCd, String hiSndYn, String fromDt, String toDt, String pageNo, String edaoreta, String hiTransmit, String hiTransmitTime, String sndUsrId) {
		this.eta = eta;
		this.miTransmitTime = miTransmitTime;
		this.fromDt = fromDt;
		this.miTransmit = miTransmit;
		this.edaoreta = edaoreta;
		this.atdTime = atdTime;
		this.hiSndYn = hiSndYn;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.vvd = vvd;
		this.podCd = podCd;
		this.etaTime = etaTime;
		this.ofcCd = ofcCd;
		this.sndUsrId = sndUsrId;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.usrId = usrId;
		this.pageNo = pageNo;
		this.hiTransmitTime = hiTransmitTime;
		this.blCount = blCount;
		this.name = name;
		this.atd = atd;
		this.hiTransmit = hiTransmit;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("mi_transmit_time", getMiTransmitTime());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("mi_transmit", getMiTransmit());
		this.hashColumns.put("edaoreta", getEdaoreta());
		this.hashColumns.put("atd_time", getAtdTime());
		this.hashColumns.put("hi_snd_yn", getHiSndYn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("eta_time", getEtaTime());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("hi_transmit_time", getHiTransmitTime());
		this.hashColumns.put("bl_count", getBlCount());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("atd", getAtd());
		this.hashColumns.put("hi_transmit", getHiTransmit());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta", "eta");
		this.hashFields.put("mi_transmit_time", "miTransmitTime");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("mi_transmit", "miTransmit");
		this.hashFields.put("edaoreta", "edaoreta");
		this.hashFields.put("atd_time", "atdTime");
		this.hashFields.put("hi_snd_yn", "hiSndYn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("eta_time", "etaTime");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("hi_transmit_time", "hiTransmitTime");
		this.hashFields.put("bl_count", "blCount");
		this.hashFields.put("name", "name");
		this.hashFields.put("atd", "atd");
		this.hashFields.put("hi_transmit", "hiTransmit");
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
	 * @return miTransmitTime
	 */
	public String getMiTransmitTime() {
		return this.miTransmitTime;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return miTransmit
	 */
	public String getMiTransmit() {
		return this.miTransmit;
	}
	
	/**
	 * Column Info
	 * @return edaoreta
	 */
	public String getEdaoreta() {
		return this.edaoreta;
	}
	
	/**
	 * Column Info
	 * @return atdTime
	 */
	public String getAtdTime() {
		return this.atdTime;
	}
	
	/**
	 * Column Info
	 * @return hiSndYn
	 */
	public String getHiSndYn() {
		return this.hiSndYn;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return etaTime
	 */
	public String getEtaTime() {
		return this.etaTime;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return hiTransmitTime
	 */
	public String getHiTransmitTime() {
		return this.hiTransmitTime;
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
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Column Info
	 * @return atd
	 */
	public String getAtd() {
		return this.atd;
	}
	
	/**
	 * Column Info
	 * @return hiTransmit
	 */
	public String getHiTransmit() {
		return this.hiTransmit;
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
	 * @param miTransmitTime
	 */
	public void setMiTransmitTime(String miTransmitTime) {
		this.miTransmitTime = miTransmitTime;
	}
	
	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param miTransmit
	 */
	public void setMiTransmit(String miTransmit) {
		this.miTransmit = miTransmit;
	}
	
	/**
	 * Column Info
	 * @param edaoreta
	 */
	public void setEdaoreta(String edaoreta) {
		this.edaoreta = edaoreta;
	}
	
	/**
	 * Column Info
	 * @param atdTime
	 */
	public void setAtdTime(String atdTime) {
		this.atdTime = atdTime;
	}
	
	/**
	 * Column Info
	 * @param hiSndYn
	 */
	public void setHiSndYn(String hiSndYn) {
		this.hiSndYn = hiSndYn;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param etaTime
	 */
	public void setEtaTime(String etaTime) {
		this.etaTime = etaTime;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param hiTransmitTime
	 */
	public void setHiTransmitTime(String hiTransmitTime) {
		this.hiTransmitTime = hiTransmitTime;
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
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Column Info
	 * @param atd
	 */
	public void setAtd(String atd) {
		this.atd = atd;
	}
	
	/**
	 * Column Info
	 * @param hiTransmit
	 */
	public void setHiTransmit(String hiTransmit) {
		this.hiTransmit = hiTransmit;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setMiTransmitTime(JSPUtil.getParameter(request, "mi_transmit_time", ""));
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setMiTransmit(JSPUtil.getParameter(request, "mi_transmit", ""));
		setEdaoreta(JSPUtil.getParameter(request, "edaoreta", ""));
		setAtdTime(JSPUtil.getParameter(request, "atd_time", ""));
		setHiSndYn(JSPUtil.getParameter(request, "hi_snd_yn", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setEtaTime(JSPUtil.getParameter(request, "eta_time", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSndUsrId(JSPUtil.getParameter(request, "snd_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setHiTransmitTime(JSPUtil.getParameter(request, "hi_transmit_time", ""));
		setBlCount(JSPUtil.getParameter(request, "bl_count", ""));
		setName(JSPUtil.getParameter(request, "name", ""));
		setAtd(JSPUtil.getParameter(request, "atd", ""));
		setHiTransmit(JSPUtil.getParameter(request, "hi_transmit", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaManifestListCondForEdiVO[]
	 */
	public UsaManifestListCondForEdiVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaManifestListCondForEdiVO[]
	 */
	public UsaManifestListCondForEdiVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaManifestListCondForEdiVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] miTransmitTime = (JSPUtil.getParameter(request, prefix	+ "mi_transmit_time", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] miTransmit = (JSPUtil.getParameter(request, prefix	+ "mi_transmit", length));
			String[] edaoreta = (JSPUtil.getParameter(request, prefix	+ "edaoreta", length));
			String[] atdTime = (JSPUtil.getParameter(request, prefix	+ "atd_time", length));
			String[] hiSndYn = (JSPUtil.getParameter(request, prefix	+ "hi_snd_yn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] etaTime = (JSPUtil.getParameter(request, prefix	+ "eta_time", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] hiTransmitTime = (JSPUtil.getParameter(request, prefix	+ "hi_transmit_time", length));
			String[] blCount = (JSPUtil.getParameter(request, prefix	+ "bl_count", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] atd = (JSPUtil.getParameter(request, prefix	+ "atd", length));
			String[] hiTransmit = (JSPUtil.getParameter(request, prefix	+ "hi_transmit", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaManifestListCondForEdiVO();
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (miTransmitTime[i] != null)
					model.setMiTransmitTime(miTransmitTime[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (miTransmit[i] != null)
					model.setMiTransmit(miTransmit[i]);
				if (edaoreta[i] != null)
					model.setEdaoreta(edaoreta[i]);
				if (atdTime[i] != null)
					model.setAtdTime(atdTime[i]);
				if (hiSndYn[i] != null)
					model.setHiSndYn(hiSndYn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (etaTime[i] != null)
					model.setEtaTime(etaTime[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (hiTransmitTime[i] != null)
					model.setHiTransmitTime(hiTransmitTime[i]);
				if (blCount[i] != null)
					model.setBlCount(blCount[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (atd[i] != null)
					model.setAtd(atd[i]);
				if (hiTransmit[i] != null)
					model.setHiTransmit(hiTransmit[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaManifestListCondForEdiVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaManifestListCondForEdiVO[]
	 */
	public UsaManifestListCondForEdiVO[] getUsaManifestListCondForEdiVOs(){
		UsaManifestListCondForEdiVO[] vos = (UsaManifestListCondForEdiVO[])models.toArray(new UsaManifestListCondForEdiVO[models.size()]);
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
		this.miTransmitTime = this.miTransmitTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.miTransmit = this.miTransmit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edaoreta = this.edaoreta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdTime = this.atdTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hiSndYn = this.hiSndYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaTime = this.etaTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hiTransmitTime = this.hiTransmitTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCount = this.blCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atd = this.atd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hiTransmit = this.hiTransmit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
