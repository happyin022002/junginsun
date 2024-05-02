package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestCondVO;
import com.hanjin.framework.component.util.JSPUtil;

public class CndCstmsManifestCondVO extends CstmsManifestCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<CndCstmsManifestCondVO> models = new ArrayList<CndCstmsManifestCondVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frobFlg = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String blType = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntrType = null;
	/* Column Info */
	private String atdPodCd = null;
	/* Column Info */
	private String atdToTm = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String atdToDt = null;
	/* Column Info */
	private String atdFromDt = null;
	/* Column Info */
	private String atdFromTm = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CndCstmsManifestCondVO() {}

	public CndCstmsManifestCondVO(String ibflag, String pagerows, String blNo, String podCd, String polCd, String vvdCd, String blType, String cntrType, String cstmsPortCd, String sndDt, String frobFlg,String lane, String gubun, String atdPodCd, String atdFromDt, String atdFromTm, String atdToDt, String atdToTm) {
		this.podCd = podCd;
		this.polCd = polCd;
		this.frobFlg = frobFlg;
		this.vvdCd = vvdCd;
		this.blType = blType;
		this.cstmsPortCd = cstmsPortCd;
		this.sndDt = sndDt;
		this.blNo = blNo;
		this.cntrType = cntrType;
		this.pagerows = pagerows;
		this.atdPodCd = atdPodCd;
		this.atdToTm = atdToTm;
		this.ibflag = ibflag;
		this.gubun = gubun;
		this.atdToDt = atdToDt;
		this.atdFromDt = atdFromDt;
		this.atdFromTm = atdFromTm;
		this.lane = lane;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frob_flg", getFrobFlg());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("bl_type", getBlType());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("atd_pod_cd", getAtdPodCd());
		this.hashColumns.put("atd_to_tm", getAtdToTm());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("atd_to_dt", getAtdToDt());
		this.hashColumns.put("atd_from_dt", getAtdFromDt());
		this.hashColumns.put("atd_from_tm", getAtdFromTm());
		this.hashColumns.put("lane", getLane());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frob_flg", "frobFlg");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("bl_type", "blType");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("atd_pod_cd", "atdPodCd");
		this.hashFields.put("atd_to_tm", "atdToTm");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("atd_to_dt", "atdToDt");
		this.hashFields.put("atd_from_dt", "atdFromDt");
		this.hashFields.put("atd_from_tm", "atdFromTm");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return frobFlg
	 */
	public String getFrobFlg() {
		return this.frobFlg;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return blType
	 */
	public String getBlType() {
		return this.blType;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
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
	 * @return atdPodCd
	 */
	public String getAtdPodCd() {
		return this.atdPodCd;
	}
	
	/**
	 * Column Info
	 * @return atdToTm
	 */
	public String getAtdToTm() {
		return this.atdToTm;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return atdToDt
	 */
	public String getAtdToDt() {
		return this.atdToDt;
	}
	
	/**
	 * Column Info
	 * @return atdFromDt
	 */
	public String getAtdFromDt() {
		return this.atdFromDt;
	}
	
	/**
	 * Column Info
	 * @return atdFromTm
	 */
	public String getAtdFromTm() {
		return this.atdFromTm;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param frobFlg
	 */
	public void setFrobFlg(String frobFlg) {
		this.frobFlg = frobFlg;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param blType
	 */
	public void setBlType(String blType) {
		this.blType = blType;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
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
	 * @param atdPodCd
	 */
	public void setAtdPodCd(String atdPodCd) {
		this.atdPodCd = atdPodCd;
	}
	
	/**
	 * Column Info
	 * @param atdToTm
	 */
	public void setAtdToTm(String atdToTm) {
		this.atdToTm = atdToTm;
	}
	
	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	/**
	 * Column Info
	 * @param atdToDt
	 */
	public void setAtdToDt(String atdToDt) {
		this.atdToDt = atdToDt;
	}
	
	/**
	 * Column Info
	 * @param atdFromDt
	 */
	public void setAtdFromDt(String atdFromDt) {
		this.atdFromDt = atdFromDt;
	}
	
	/**
	 * Column Info
	 * @param atdFromTm
	 */
	public void setAtdFromTm(String atdFromTm) {
		this.atdFromTm = atdFromTm;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFrobFlg(JSPUtil.getParameter(request, "frob_flg", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setBlType(JSPUtil.getParameter(request, "bl_type", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, "cstms_port_cd", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setCntrType(JSPUtil.getParameter(request, "cntr_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setAtdPodCd(JSPUtil.getParameter(request,  "atd_pod_cd", ""));
		setAtdToTm(JSPUtil.getParameter(request,  "atd_to_tm", ""));
		setGubun(JSPUtil.getParameter(request,  "gubun", ""));
		setAtdToDt(JSPUtil.getParameter(request,  "atd_to_dt", ""));
		setAtdFromDt(JSPUtil.getParameter(request,  "atd_from_dt", ""));
		setAtdFromTm(JSPUtil.getParameter(request,  "atd_from_tm", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CndCstmsManifestCondVO[]
	 */
	public CndCstmsManifestCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CndCstmsManifestCondVO[]
	 */
	public CndCstmsManifestCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CndCstmsManifestCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] frobFlg = (JSPUtil.getParameter(request, prefix	+ "frob_flg".trim(), length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd".trim(), length));
			String[] blType = (JSPUtil.getParameter(request, prefix	+ "bl_type".trim(), length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd".trim(), length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] atdPodCd = (JSPUtil.getParameter(request, prefix	+ "atd_pod_cd", length));
			String[] atdToTm = (JSPUtil.getParameter(request, prefix	+ "atd_to_tm", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] atdToDt = (JSPUtil.getParameter(request, prefix	+ "atd_to_dt", length));
			String[] atdFromDt = (JSPUtil.getParameter(request, prefix	+ "atd_from_dt", length));
			String[] atdFromTm = (JSPUtil.getParameter(request, prefix	+ "atd_from_tm", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			
			for (int i = 0; i < length; i++) {
				model = new CndCstmsManifestCondVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frobFlg[i] != null)
					model.setFrobFlg(frobFlg[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (blType[i] != null)
					model.setBlType(blType[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (atdPodCd[i] != null)
					model.setAtdPodCd(atdPodCd[i]);
				if (atdToTm[i] != null)
					model.setAtdToTm(atdToTm[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (atdToDt[i] != null)
					model.setAtdToDt(atdToDt[i]);
				if (atdFromDt[i] != null)
					model.setAtdFromDt(atdFromDt[i]);
				if (atdFromTm[i] != null)
					model.setAtdFromTm(atdFromTm[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCndCstmsManifestCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CndCstmsManifestCondVO[]
	 */
	public CndCstmsManifestCondVO[] getCndCstmsManifestCondVOs(){
		CndCstmsManifestCondVO[] vos = (CndCstmsManifestCondVO[])models.toArray(new CndCstmsManifestCondVO[models.size()]);
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
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frobFlg = this.frobFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blType = this.blType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdPodCd = this.atdPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdToTm = this.atdToTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdToDt = this.atdToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdFromDt = this.atdFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdFromTm = this.atdFromTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}