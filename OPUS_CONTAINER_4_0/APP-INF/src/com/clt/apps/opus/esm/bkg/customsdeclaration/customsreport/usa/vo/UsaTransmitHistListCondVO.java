/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaTransmitHistListCondVO.java
*@FileTitle : UsaTransmitHistListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.08.28  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistListCondVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaTransmitHistListCondVO extends TransmitHistListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaTransmitHistListCondVO> models = new ArrayList<UsaTransmitHistListCondVO>();
	
	/* Column Info */
	private String lstForPol = null;
	/* Column Info */
	private String endNo = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String sndOfcCd = null;
	/* Column Info */
	private String sndFromd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String sndTot = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String startNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String sndUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String trsmMsgTpId = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String sndFromt = null;
	/* Column Info */
	private String sndTod = null;
	/* Column Info */
	private String ofmFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaTransmitHistListCondVO() {}

	public UsaTransmitHistListCondVO(String ibflag, String pagerows, String vvd, String podCd, String polCd, String gubun, String sndFromd, String sndFromt, String sndTod, String sndTot, String blNo, String trsmMsgTpId, String ioBndCd, String startNo, String endNo, String pageNo, String sndOfcCd, String sndUsrId, String lstForPol, String ofmFlg) {
		this.lstForPol = lstForPol;
		this.endNo = endNo;
		this.gubun = gubun;
		this.sndOfcCd = sndOfcCd;
		this.sndFromd = sndFromd;
		this.ioBndCd = ioBndCd;
		this.blNo = blNo;
		this.sndTot = sndTot;
		this.pagerows = pagerows;
		this.startNo = startNo;
		this.vvd = vvd;
		this.podCd = podCd;
		this.sndUsrId = sndUsrId;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.trsmMsgTpId = trsmMsgTpId;
		this.pageNo = pageNo;
		this.sndFromt = sndFromt;
		this.sndTod = sndTod;
		this.ofmFlg = ofmFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lst_for_pol", getLstForPol());
		this.hashColumns.put("end_no", getEndNo());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("snd_ofc_cd", getSndOfcCd());
		this.hashColumns.put("snd_fromd", getSndFromd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("snd_tot", getSndTot());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("start_no", getStartNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("trsm_msg_tp_id", getTrsmMsgTpId());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("snd_fromt", getSndFromt());
		this.hashColumns.put("snd_tod", getSndTod());
		this.hashColumns.put("ofm_flg", getOfmFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lst_for_pol", "lstForPol");
		this.hashFields.put("end_no", "endNo");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("snd_ofc_cd", "sndOfcCd");
		this.hashFields.put("snd_fromd", "sndFromd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("snd_tot", "sndTot");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("start_no", "startNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("trsm_msg_tp_id", "trsmMsgTpId");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("snd_fromt", "sndFromt");
		this.hashFields.put("snd_tod", "sndTod");
		this.hashFields.put("ofm_flg", "ofmFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lstForPol
	 */
	public String getLstForPol() {
		return this.lstForPol;
	}
	
	/**
	 * Column Info
	 * @return endNo
	 */
	public String getEndNo() {
		return this.endNo;
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
	 * @return sndOfcCd
	 */
	public String getSndOfcCd() {
		return this.sndOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sndFromd
	 */
	public String getSndFromd() {
		return this.sndFromd;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return sndTot
	 */
	public String getSndTot() {
		return this.sndTot;
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
	 * @return startNo
	 */
	public String getStartNo() {
		return this.startNo;
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
	 * @return trsmMsgTpId
	 */
	public String getTrsmMsgTpId() {
		return this.trsmMsgTpId;
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
	 * @return sndFromt
	 */
	public String getSndFromt() {
		return this.sndFromt;
	}
	
	/**
	 * Column Info
	 * @return sndTod
	 */
	public String getSndTod() {
		return this.sndTod;
	}
	
	/**
	 * Column Info
	 * @return ofmFlg
	 */
	public String getOfmFlg() {
		return this.ofmFlg;
	}
	

	/**
	 * Column Info
	 * @param lstForPol
	 */
	public void setLstForPol(String lstForPol) {
		this.lstForPol = lstForPol;
	}
	
	/**
	 * Column Info
	 * @param endNo
	 */
	public void setEndNo(String endNo) {
		this.endNo = endNo;
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
	 * @param sndOfcCd
	 */
	public void setSndOfcCd(String sndOfcCd) {
		this.sndOfcCd = sndOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sndFromd
	 */
	public void setSndFromd(String sndFromd) {
		this.sndFromd = sndFromd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param sndTot
	 */
	public void setSndTot(String sndTot) {
		this.sndTot = sndTot;
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
	 * @param startNo
	 */
	public void setStartNo(String startNo) {
		this.startNo = startNo;
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
	 * @param trsmMsgTpId
	 */
	public void setTrsmMsgTpId(String trsmMsgTpId) {
		this.trsmMsgTpId = trsmMsgTpId;
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
	 * @param sndFromt
	 */
	public void setSndFromt(String sndFromt) {
		this.sndFromt = sndFromt;
	}
	
	/**
	 * Column Info
	 * @param sndTod
	 */
	public void setSndTod(String sndTod) {
		this.sndTod = sndTod;
	}
	
	/**
	 * Column Info
	 * @param ofmFlg
	 */
	public void setOfmFlg(String ofmFlg) {
		this.ofmFlg = ofmFlg;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLstForPol(JSPUtil.getParameter(request, "lst_for_pol", ""));
		setEndNo(JSPUtil.getParameter(request, "end_no", ""));
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setSndOfcCd(JSPUtil.getParameter(request, "snd_ofc_cd", ""));
		setSndFromd(JSPUtil.getParameter(request, "snd_fromd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSndTot(JSPUtil.getParameter(request, "snd_tot", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setStartNo(JSPUtil.getParameter(request, "start_no", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setSndUsrId(JSPUtil.getParameter(request, "snd_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setTrsmMsgTpId(JSPUtil.getParameter(request, "trsm_msg_tp_id", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setSndFromt(JSPUtil.getParameter(request, "snd_fromt", ""));
		setSndTod(JSPUtil.getParameter(request, "snd_tod", ""));
		setOfmFlg(JSPUtil.getParameter(request, "ofm_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaTransmitHistListCondVO[]
	 */
	public UsaTransmitHistListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaTransmitHistListCondVO[]
	 */
	public UsaTransmitHistListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaTransmitHistListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lstForPol = (JSPUtil.getParameter(request, prefix	+ "lst_for_pol", length));
			String[] endNo = (JSPUtil.getParameter(request, prefix	+ "end_no", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] sndOfcCd = (JSPUtil.getParameter(request, prefix	+ "snd_ofc_cd", length));
			String[] sndFromd = (JSPUtil.getParameter(request, prefix	+ "snd_fromd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] sndTot = (JSPUtil.getParameter(request, prefix	+ "snd_tot", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] startNo = (JSPUtil.getParameter(request, prefix	+ "start_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] trsmMsgTpId = (JSPUtil.getParameter(request, prefix	+ "trsm_msg_tp_id", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] sndFromt = (JSPUtil.getParameter(request, prefix	+ "snd_fromt", length));
			String[] sndTod = (JSPUtil.getParameter(request, prefix	+ "snd_tod", length));
			String[] ofmFlg = (JSPUtil.getParameter(request, prefix	+ "ofm_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaTransmitHistListCondVO();
				if (lstForPol[i] != null)
					model.setLstForPol(lstForPol[i]);
				if (endNo[i] != null)
					model.setEndNo(endNo[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (sndOfcCd[i] != null)
					model.setSndOfcCd(sndOfcCd[i]);
				if (sndFromd[i] != null)
					model.setSndFromd(sndFromd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (sndTot[i] != null)
					model.setSndTot(sndTot[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (startNo[i] != null)
					model.setStartNo(startNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (trsmMsgTpId[i] != null)
					model.setTrsmMsgTpId(trsmMsgTpId[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (sndFromt[i] != null)
					model.setSndFromt(sndFromt[i]);
				if (sndTod[i] != null)
					model.setSndTod(sndTod[i]);
				if (ofmFlg[i] != null)
					model.setOfmFlg(ofmFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaTransmitHistListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaTransmitHistListCondVO[]
	 */
	public UsaTransmitHistListCondVO[] getUsaTransmitHistListCondVOs(){
		UsaTransmitHistListCondVO[] vos = (UsaTransmitHistListCondVO[])models.toArray(new UsaTransmitHistListCondVO[models.size()]);
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
		this.lstForPol = this.lstForPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endNo = this.endNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndOfcCd = this.sndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndFromd = this.sndFromd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndTot = this.sndTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startNo = this.startNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmMsgTpId = this.trsmMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndFromt = this.sndFromt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndTod = this.sndTod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofmFlg = this.ofmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
