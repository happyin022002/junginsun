/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MxBkgVvdVO.java
*@FileTitle : MxBkgVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.23 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo;

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
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MxBkgVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MxBkgVvdVO> models = new ArrayList<MxBkgVvdVO>();
	
	/* Column Info */
	private String blpod1 = null;
	/* Column Info */
	private String bvvd1 = null;
	/* Column Info */
	private String poletd1 = null;
	/* Column Info */
	private String vslLloydcode1 = null;
	/* Column Info */
	private String blpol1 = null;
	/* Column Info */
	private String podeta1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podetd1 = null;
	/* Column Info */
	private String vslCallsign1 = null;
	/* Column Info */
	private String vslFullname1 = null;
	/* Column Info */
	private String opCode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polFullname1 = null;
	/* Column Info */
	private String poleta1 = null;
	/* Column Info */
	private String bvvdLane = null;
	/* Column Info */
	private String vvdRefNo1 = null;
	/* Column Info */
	private String podFullname1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MxBkgVvdVO() {}

	public MxBkgVvdVO(String ibflag, String pagerows, String bvvd1, String bvvdLane, String vslCallsign1, String vslLloydcode1, String vslFullname1, String vvdRefNo1, String blpol1, String polFullname1, String blpod1, String podFullname1, String poleta1, String poletd1, String podeta1, String podetd1, String opCode) {
		this.blpod1 = blpod1;
		this.bvvd1 = bvvd1;
		this.poletd1 = poletd1;
		this.vslLloydcode1 = vslLloydcode1;
		this.blpol1 = blpol1;
		this.podeta1 = podeta1;
		this.pagerows = pagerows;
		this.podetd1 = podetd1;
		this.vslCallsign1 = vslCallsign1;
		this.vslFullname1 = vslFullname1;
		this.opCode = opCode;
		this.ibflag = ibflag;
		this.polFullname1 = polFullname1;
		this.poleta1 = poleta1;
		this.bvvdLane = bvvdLane;
		this.vvdRefNo1 = vvdRefNo1;
		this.podFullname1 = podFullname1;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("blpod1", getBlpod1());
		this.hashColumns.put("bvvd1", getBvvd1());
		this.hashColumns.put("poletd1", getPoletd1());
		this.hashColumns.put("vsl_lloydcode1", getVslLloydcode1());
		this.hashColumns.put("blpol1", getBlpol1());
		this.hashColumns.put("podeta1", getPodeta1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("podetd1", getPodetd1());
		this.hashColumns.put("vsl_callsign1", getVslCallsign1());
		this.hashColumns.put("vsl_fullname1", getVslFullname1());
		this.hashColumns.put("op_code", getOpCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_fullname1", getPolFullname1());
		this.hashColumns.put("poleta1", getPoleta1());
		this.hashColumns.put("bvvd_lane", getBvvdLane());
		this.hashColumns.put("vvd_ref_no1", getVvdRefNo1());
		this.hashColumns.put("pod_fullname1", getPodFullname1());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("blpod1", "blpod1");
		this.hashFields.put("bvvd1", "bvvd1");
		this.hashFields.put("poletd1", "poletd1");
		this.hashFields.put("vsl_lloydcode1", "vslLloydcode1");
		this.hashFields.put("blpol1", "blpol1");
		this.hashFields.put("podeta1", "podeta1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("podetd1", "podetd1");
		this.hashFields.put("vsl_callsign1", "vslCallsign1");
		this.hashFields.put("vsl_fullname1", "vslFullname1");
		this.hashFields.put("op_code", "opCode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_fullname1", "polFullname1");
		this.hashFields.put("poleta1", "poleta1");
		this.hashFields.put("bvvd_lane", "bvvdLane");
		this.hashFields.put("vvd_ref_no1", "vvdRefNo1");
		this.hashFields.put("pod_fullname1", "podFullname1");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blpod1
	 */
	public String getBlpod1() {
		return this.blpod1;
	}
	
	/**
	 * Column Info
	 * @return bvvd1
	 */
	public String getBvvd1() {
		return this.bvvd1;
	}
	
	/**
	 * Column Info
	 * @return poletd1
	 */
	public String getPoletd1() {
		return this.poletd1;
	}
	
	/**
	 * Column Info
	 * @return vslLloydcode1
	 */
	public String getVslLloydcode1() {
		return this.vslLloydcode1;
	}
	
	/**
	 * Column Info
	 * @return blpol1
	 */
	public String getBlpol1() {
		return this.blpol1;
	}
	
	/**
	 * Column Info
	 * @return podeta1
	 */
	public String getPodeta1() {
		return this.podeta1;
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
	 * @return podetd1
	 */
	public String getPodetd1() {
		return this.podetd1;
	}
	
	/**
	 * Column Info
	 * @return vslCallsign1
	 */
	public String getVslCallsign1() {
		return this.vslCallsign1;
	}
	
	/**
	 * Column Info
	 * @return vslFullname1
	 */
	public String getVslFullname1() {
		return this.vslFullname1;
	}
	
	/**
	 * Column Info
	 * @return opCode
	 */
	public String getOpCode() {
		return this.opCode;
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
	 * @return polFullname1
	 */
	public String getPolFullname1() {
		return this.polFullname1;
	}
	
	/**
	 * Column Info
	 * @return poleta1
	 */
	public String getPoleta1() {
		return this.poleta1;
	}
	
	/**
	 * Column Info
	 * @return bvvdLane
	 */
	public String getBvvdLane() {
		return this.bvvdLane;
	}
	
	/**
	 * Column Info
	 * @return vvdRefNo1
	 */
	public String getVvdRefNo1() {
		return this.vvdRefNo1;
	}
	
	/**
	 * Column Info
	 * @return podFullname1
	 */
	public String getPodFullname1() {
		return this.podFullname1;
	}
	

	/**
	 * Column Info
	 * @param blpod1
	 */
	public void setBlpod1(String blpod1) {
		this.blpod1 = blpod1;
	}
	
	/**
	 * Column Info
	 * @param bvvd1
	 */
	public void setBvvd1(String bvvd1) {
		this.bvvd1 = bvvd1;
	}
	
	/**
	 * Column Info
	 * @param poletd1
	 */
	public void setPoletd1(String poletd1) {
		this.poletd1 = poletd1;
	}
	
	/**
	 * Column Info
	 * @param vslLloydcode1
	 */
	public void setVslLloydcode1(String vslLloydcode1) {
		this.vslLloydcode1 = vslLloydcode1;
	}
	
	/**
	 * Column Info
	 * @param blpol1
	 */
	public void setBlpol1(String blpol1) {
		this.blpol1 = blpol1;
	}
	
	/**
	 * Column Info
	 * @param podeta1
	 */
	public void setPodeta1(String podeta1) {
		this.podeta1 = podeta1;
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
	 * @param podetd1
	 */
	public void setPodetd1(String podetd1) {
		this.podetd1 = podetd1;
	}
	
	/**
	 * Column Info
	 * @param vslCallsign1
	 */
	public void setVslCallsign1(String vslCallsign1) {
		this.vslCallsign1 = vslCallsign1;
	}
	
	/**
	 * Column Info
	 * @param vslFullname1
	 */
	public void setVslFullname1(String vslFullname1) {
		this.vslFullname1 = vslFullname1;
	}
	
	/**
	 * Column Info
	 * @param opCode
	 */
	public void setOpCode(String opCode) {
		this.opCode = opCode;
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
	 * @param polFullname1
	 */
	public void setPolFullname1(String polFullname1) {
		this.polFullname1 = polFullname1;
	}
	
	/**
	 * Column Info
	 * @param poleta1
	 */
	public void setPoleta1(String poleta1) {
		this.poleta1 = poleta1;
	}
	
	/**
	 * Column Info
	 * @param bvvdLane
	 */
	public void setBvvdLane(String bvvdLane) {
		this.bvvdLane = bvvdLane;
	}
	
	/**
	 * Column Info
	 * @param vvdRefNo1
	 */
	public void setVvdRefNo1(String vvdRefNo1) {
		this.vvdRefNo1 = vvdRefNo1;
	}
	
	/**
	 * Column Info
	 * @param podFullname1
	 */
	public void setPodFullname1(String podFullname1) {
		this.podFullname1 = podFullname1;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBlpod1(JSPUtil.getParameter(request, "blpod1", ""));
		setBvvd1(JSPUtil.getParameter(request, "bvvd1", ""));
		setPoletd1(JSPUtil.getParameter(request, "poletd1", ""));
		setVslLloydcode1(JSPUtil.getParameter(request, "vsl_lloydcode1", ""));
		setBlpol1(JSPUtil.getParameter(request, "blpol1", ""));
		setPodeta1(JSPUtil.getParameter(request, "podeta1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodetd1(JSPUtil.getParameter(request, "podetd1", ""));
		setVslCallsign1(JSPUtil.getParameter(request, "vsl_callsign1", ""));
		setVslFullname1(JSPUtil.getParameter(request, "vsl_fullname1", ""));
		setOpCode(JSPUtil.getParameter(request, "op_code", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolFullname1(JSPUtil.getParameter(request, "pol_fullname1", ""));
		setPoleta1(JSPUtil.getParameter(request, "poleta1", ""));
		setBvvdLane(JSPUtil.getParameter(request, "bvvd_lane", ""));
		setVvdRefNo1(JSPUtil.getParameter(request, "vvd_ref_no1", ""));
		setPodFullname1(JSPUtil.getParameter(request, "pod_fullname1", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MxBkgVvdVO[]
	 */
	public MxBkgVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MxBkgVvdVO[]
	 */
	public MxBkgVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MxBkgVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blpod1 = (JSPUtil.getParameter(request, prefix	+ "blpod1", length));
			String[] bvvd1 = (JSPUtil.getParameter(request, prefix	+ "bvvd1", length));
			String[] poletd1 = (JSPUtil.getParameter(request, prefix	+ "poletd1", length));
			String[] vslLloydcode1 = (JSPUtil.getParameter(request, prefix	+ "vsl_lloydcode1", length));
			String[] blpol1 = (JSPUtil.getParameter(request, prefix	+ "blpol1", length));
			String[] podeta1 = (JSPUtil.getParameter(request, prefix	+ "podeta1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podetd1 = (JSPUtil.getParameter(request, prefix	+ "podetd1", length));
			String[] vslCallsign1 = (JSPUtil.getParameter(request, prefix	+ "vsl_callsign1", length));
			String[] vslFullname1 = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname1", length));
			String[] opCode = (JSPUtil.getParameter(request, prefix	+ "op_code", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polFullname1 = (JSPUtil.getParameter(request, prefix	+ "pol_fullname1", length));
			String[] poleta1 = (JSPUtil.getParameter(request, prefix	+ "poleta1", length));
			String[] bvvdLane = (JSPUtil.getParameter(request, prefix	+ "bvvd_lane", length));
			String[] vvdRefNo1 = (JSPUtil.getParameter(request, prefix	+ "vvd_ref_no1", length));
			String[] podFullname1 = (JSPUtil.getParameter(request, prefix	+ "pod_fullname1", length));
			
			for (int i = 0; i < length; i++) {
				model = new MxBkgVvdVO();
				if (blpod1[i] != null)
					model.setBlpod1(blpod1[i]);
				if (bvvd1[i] != null)
					model.setBvvd1(bvvd1[i]);
				if (poletd1[i] != null)
					model.setPoletd1(poletd1[i]);
				if (vslLloydcode1[i] != null)
					model.setVslLloydcode1(vslLloydcode1[i]);
				if (blpol1[i] != null)
					model.setBlpol1(blpol1[i]);
				if (podeta1[i] != null)
					model.setPodeta1(podeta1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podetd1[i] != null)
					model.setPodetd1(podetd1[i]);
				if (vslCallsign1[i] != null)
					model.setVslCallsign1(vslCallsign1[i]);
				if (vslFullname1[i] != null)
					model.setVslFullname1(vslFullname1[i]);
				if (opCode[i] != null)
					model.setOpCode(opCode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polFullname1[i] != null)
					model.setPolFullname1(polFullname1[i]);
				if (poleta1[i] != null)
					model.setPoleta1(poleta1[i]);
				if (bvvdLane[i] != null)
					model.setBvvdLane(bvvdLane[i]);
				if (vvdRefNo1[i] != null)
					model.setVvdRefNo1(vvdRefNo1[i]);
				if (podFullname1[i] != null)
					model.setPodFullname1(podFullname1[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMxBkgVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MxBkgVvdVO[]
	 */
	public MxBkgVvdVO[] getMxBkgVvdVOs(){
		MxBkgVvdVO[] vos = (MxBkgVvdVO[])models.toArray(new MxBkgVvdVO[models.size()]);
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
		this.blpod1 = this.blpod1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bvvd1 = this.bvvd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poletd1 = this.poletd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLloydcode1 = this.vslLloydcode1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blpol1 = this.blpol1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podeta1 = this.podeta1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podetd1 = this.podetd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallsign1 = this.vslCallsign1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullname1 = this.vslFullname1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCode = this.opCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polFullname1 = this.polFullname1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poleta1 = this.poleta1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bvvdLane = this.bvvdLane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdRefNo1 = this.vvdRefNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podFullname1 = this.podFullname1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
