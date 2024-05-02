/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCstmsVvdListCondVO.java
*@FileTitle : AncsCstmsVvdListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.05.22 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdListCondVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AncsCstmsVvdListCondVO extends CstmsVvdListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsCstmsVvdListCondVO> models = new ArrayList<AncsCstmsVvdListCondVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String svcRqstNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgCount = null;
	/* Column Info */
	private String eVpsEtaDt = null;
	/* Column Info */
	private String sVpsEtaDt = null;
	/* Column Info */
	private String msgStsCd = null;
	private String pod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AncsCstmsVvdListCondVO() {}

	public AncsCstmsVvdListCondVO(String ibflag, String pagerows, String sVpsEtaDt, String eVpsEtaDt, String vvd, String svcRqstNo, String msgStsCd, String bkgCount,String pod) {
		this.vvd = vvd;
		this.svcRqstNo = svcRqstNo;
		this.ibflag = ibflag;
		this.bkgCount = bkgCount;
		this.eVpsEtaDt = eVpsEtaDt;
		this.sVpsEtaDt = sVpsEtaDt;
		this.msgStsCd = msgStsCd;
		this.pod = pod;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("svc_rqst_no", getSvcRqstNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_count", getBkgCount());
		this.hashColumns.put("e_vps_eta_dt", getEVpsEtaDt());
		this.hashColumns.put("s_vps_eta_dt", getSVpsEtaDt());
		this.hashColumns.put("msg_sts_cd", getMsgStsCd());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("svc_rqst_no", "svcRqstNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_count", "bkgCount");
		this.hashFields.put("e_vps_eta_dt", "eVpsEtaDt");
		this.hashFields.put("s_vps_eta_dt", "sVpsEtaDt");
		this.hashFields.put("msg_sts_cd", "msgStsCd");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return svcRqstNo
	 */
	public String getSvcRqstNo() {
		return this.svcRqstNo;
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
	 * @return bkgCount
	 */
	public String getBkgCount() {
		return this.bkgCount;
	}
	
	/**
	 * Column Info
	 * @return eVpsEtaDt
	 */
	public String getEVpsEtaDt() {
		return this.eVpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return sVpsEtaDt
	 */
	public String getSVpsEtaDt() {
		return this.sVpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return msgStsCd
	 */
	public String getMsgStsCd() {
		return this.msgStsCd;
	}
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param svcRqstNo
	 */
	public void setSvcRqstNo(String svcRqstNo) {
		this.svcRqstNo = svcRqstNo;
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
	 * @param bkgCount
	 */
	public void setBkgCount(String bkgCount) {
		this.bkgCount = bkgCount;
	}
	
	/**
	 * Column Info
	 * @param eVpsEtaDt
	 */
	public void setEVpsEtaDt(String eVpsEtaDt) {
		this.eVpsEtaDt = eVpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param sVpsEtaDt
	 */
	public void setSVpsEtaDt(String sVpsEtaDt) {
		this.sVpsEtaDt = sVpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param msgStsCd
	 */
	public void setMsgStsCd(String msgStsCd) {
		this.msgStsCd = msgStsCd;
	}
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setSvcRqstNo(JSPUtil.getParameter(request, "svc_rqst_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgCount(JSPUtil.getParameter(request, "bkg_count", ""));
		setEVpsEtaDt(JSPUtil.getParameter(request, "e_vps_eta_dt", ""));
		setSVpsEtaDt(JSPUtil.getParameter(request, "s_vps_eta_dt", ""));
		setPod(JSPUtil.getParameter(request, "msg_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsVvdListCondVO[]
	 */
	public AncsCstmsVvdListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsVvdListCondVO[]
	 */
	public AncsCstmsVvdListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsCstmsVvdListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] svcRqstNo = (JSPUtil.getParameter(request, prefix	+ "svc_rqst_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] bkgCount = (JSPUtil.getParameter(request, prefix	+ "bkg_count".trim(), length));
			String[] eVpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "e_vps_eta_dt".trim(), length));
			String[] sVpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "s_vps_eta_dt".trim(), length));
			String[] msgStsCd = (JSPUtil.getParameter(request, prefix	+ "msg_sts_cd".trim(), length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsCstmsVvdListCondVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (svcRqstNo[i] != null)
					model.setSvcRqstNo(svcRqstNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgCount[i] != null)
					model.setBkgCount(bkgCount[i]);
				if (eVpsEtaDt[i] != null)
					model.setEVpsEtaDt(eVpsEtaDt[i]);
				if (sVpsEtaDt[i] != null)
					model.setSVpsEtaDt(sVpsEtaDt[i]);
				if (msgStsCd[i] != null)
					model.setMsgStsCd(msgStsCd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsVvdListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsVvdListCondVO[]
	 */
	public AncsCstmsVvdListCondVO[] getAncsCstmsVvdListCondVOs(){
		AncsCstmsVvdListCondVO[] vos = (AncsCstmsVvdListCondVO[])models.toArray(new AncsCstmsVvdListCondVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcRqstNo = this.svcRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCount = this.bkgCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eVpsEtaDt = this.eVpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVpsEtaDt = this.sVpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgStsCd = this.msgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
