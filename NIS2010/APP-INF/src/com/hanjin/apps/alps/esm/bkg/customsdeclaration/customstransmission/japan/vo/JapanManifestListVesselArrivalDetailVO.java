/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanManifestListVesselArrivalDetailVO.java
*@FileTitle : JapanManifestListVesselArrivalDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo;

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

public class JapanManifestListVesselArrivalDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapanManifestListVesselArrivalDetailVO> models = new ArrayList<JapanManifestListVesselArrivalDetailVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String mfRmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String data1 = null;
	/* Column Info */
	private String cstmsMfCd = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String data2 = null;
	/* Column Info */
	private String podSplit = null;
	/* Column Info */
	private String callSignNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapanManifestListVesselArrivalDetailVO() {}

	public JapanManifestListVesselArrivalDetailVO(String ibflag, String pagerows, String callSignNo, String podCd, String podSplit, String data1, String data2, String etaDt, String cstmsMfCd, String mfRmk) {
		this.podCd = podCd;
		this.mfRmk = mfRmk;
		this.ibflag = ibflag;
		this.data1 = data1;
		this.cstmsMfCd = cstmsMfCd;
		this.etaDt = etaDt;
		this.data2 = data2;
		this.podSplit = podSplit;
		this.callSignNo = callSignNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("mf_rmk", getMfRmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("data1", getData1());
		this.hashColumns.put("cstms_mf_cd", getCstmsMfCd());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("data2", getData2());
		this.hashColumns.put("pod_split", getPodSplit());
		this.hashColumns.put("call_sign_no", getCallSignNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("mf_rmk", "mfRmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("data1", "data1");
		this.hashFields.put("cstms_mf_cd", "cstmsMfCd");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("data2", "data2");
		this.hashFields.put("pod_split", "podSplit");
		this.hashFields.put("call_sign_no", "callSignNo");
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
	 * @return mfRmk
	 */
	public String getMfRmk() {
		return this.mfRmk;
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
	 * @return data1
	 */
	public String getData1() {
		return this.data1;
	}
	
	/**
	 * Column Info
	 * @return cstmsMfCd
	 */
	public String getCstmsMfCd() {
		return this.cstmsMfCd;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return data2
	 */
	public String getData2() {
		return this.data2;
	}
	
	/**
	 * Column Info
	 * @return podSplit
	 */
	public String getPodSplit() {
		return this.podSplit;
	}
	
	/**
	 * Column Info
	 * @return callSignNo
	 */
	public String getCallSignNo() {
		return this.callSignNo;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param mfRmk
	 */
	public void setMfRmk(String mfRmk) {
		this.mfRmk = mfRmk;
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
	 * @param data1
	 */
	public void setData1(String data1) {
		this.data1 = data1;
	}
	
	/**
	 * Column Info
	 * @param cstmsMfCd
	 */
	public void setCstmsMfCd(String cstmsMfCd) {
		this.cstmsMfCd = cstmsMfCd;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param data2
	 */
	public void setData2(String data2) {
		this.data2 = data2;
	}
	
	/**
	 * Column Info
	 * @param podSplit
	 */
	public void setPodSplit(String podSplit) {
		this.podSplit = podSplit;
	}
	
	/**
	 * Column Info
	 * @param callSignNo
	 */
	public void setCallSignNo(String callSignNo) {
		this.callSignNo = callSignNo;
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
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setMfRmk(JSPUtil.getParameter(request, "mf_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setData1(JSPUtil.getParameter(request, "data1", ""));
		setCstmsMfCd(JSPUtil.getParameter(request, "cstms_mf_cd", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setData2(JSPUtil.getParameter(request, "data2", ""));
		setPodSplit(JSPUtil.getParameter(request, "pod_split", ""));
		setCallSignNo(JSPUtil.getParameter(request, "call_sign_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapanManifestListVesselArrivalDetailVO[]
	 */
	public JapanManifestListVesselArrivalDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapanManifestListVesselArrivalDetailVO[]
	 */
	public JapanManifestListVesselArrivalDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapanManifestListVesselArrivalDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] mfRmk = (JSPUtil.getParameter(request, prefix	+ "mf_rmk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] data1 = (JSPUtil.getParameter(request, prefix	+ "data1", length));
			String[] cstmsMfCd = (JSPUtil.getParameter(request, prefix	+ "cstms_mf_cd", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] data2 = (JSPUtil.getParameter(request, prefix	+ "data2", length));
			String[] podSplit = (JSPUtil.getParameter(request, prefix	+ "pod_split", length));
			String[] callSignNo = (JSPUtil.getParameter(request, prefix	+ "call_sign_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapanManifestListVesselArrivalDetailVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (mfRmk[i] != null)
					model.setMfRmk(mfRmk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (data1[i] != null)
					model.setData1(data1[i]);
				if (cstmsMfCd[i] != null)
					model.setCstmsMfCd(cstmsMfCd[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (data2[i] != null)
					model.setData2(data2[i]);
				if (podSplit[i] != null)
					model.setPodSplit(podSplit[i]);
				if (callSignNo[i] != null)
					model.setCallSignNo(callSignNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapanManifestListVesselArrivalDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapanManifestListVesselArrivalDetailVO[]
	 */
	public JapanManifestListVesselArrivalDetailVO[] getJapanManifestListVesselArrivalDetailVOs(){
		JapanManifestListVesselArrivalDetailVO[] vos = (JapanManifestListVesselArrivalDetailVO[])models.toArray(new JapanManifestListVesselArrivalDetailVO[models.size()]);
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
		this.mfRmk = this.mfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data1 = this.data1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsMfCd = this.cstmsMfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data2 = this.data2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSplit = this.podSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSignNo = this.callSignNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
