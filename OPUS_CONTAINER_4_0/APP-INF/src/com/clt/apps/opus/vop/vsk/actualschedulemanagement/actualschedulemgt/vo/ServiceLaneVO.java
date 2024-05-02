/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceLaneVO.java
*@FileTitle : ServiceLaneVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.07.21 정진우 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo;

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
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ServiceLaneVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ServiceLaneVO> models = new ArrayList<ServiceLaneVO>();
	
	/* Column Info */
	private String vslSvcTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslSlanCd1 = null;
	/* Column Info */
	private String seq1 = null;
	/* Column Info */
	private String seq2 = null;
	/* Column Info */
	private String vslSlanNm2 = null;
	/* Column Info */
	private String vslSlanCd2 = null;
	/* Column Info */
	private String vslSlanNm1 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ServiceLaneVO() {}

	public ServiceLaneVO(String ibflag, String pagerows, String vslSvcTpCd, String seq1, String vslSlanCd1, String vslSlanNm1, String seq2, String vslSlanCd2, String vslSlanNm2) {
		this.vslSvcTpCd = vslSvcTpCd;
		this.ibflag = ibflag;
		this.vslSlanCd1 = vslSlanCd1;
		this.seq1 = seq1;
		this.seq2 = seq2;
		this.vslSlanNm2 = vslSlanNm2;
		this.vslSlanCd2 = vslSlanCd2;
		this.vslSlanNm1 = vslSlanNm1;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_svc_tp_cd", getVslSvcTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_slan_cd1", getVslSlanCd1());
		this.hashColumns.put("seq1", getSeq1());
		this.hashColumns.put("seq2", getSeq2());
		this.hashColumns.put("vsl_slan_nm2", getVslSlanNm2());
		this.hashColumns.put("vsl_slan_cd2", getVslSlanCd2());
		this.hashColumns.put("vsl_slan_nm1", getVslSlanNm1());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_svc_tp_cd", "vslSvcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_slan_cd1", "vslSlanCd1");
		this.hashFields.put("seq1", "seq1");
		this.hashFields.put("seq2", "seq2");
		this.hashFields.put("vsl_slan_nm2", "vslSlanNm2");
		this.hashFields.put("vsl_slan_cd2", "vslSlanCd2");
		this.hashFields.put("vsl_slan_nm1", "vslSlanNm1");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslSvcTpCd
	 */
	public String getVslSvcTpCd() {
		return this.vslSvcTpCd;
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
	 * @return vslSlanCd1
	 */
	public String getVslSlanCd1() {
		return this.vslSlanCd1;
	}
	
	/**
	 * Column Info
	 * @return seq1
	 */
	public String getSeq1() {
		return this.seq1;
	}
	
	/**
	 * Column Info
	 * @return seq2
	 */
	public String getSeq2() {
		return this.seq2;
	}
	
	/**
	 * Column Info
	 * @return vslSlanNm2
	 */
	public String getVslSlanNm2() {
		return this.vslSlanNm2;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd2
	 */
	public String getVslSlanCd2() {
		return this.vslSlanCd2;
	}
	
	/**
	 * Column Info
	 * @return vslSlanNm1
	 */
	public String getVslSlanNm1() {
		return this.vslSlanNm1;
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
	 * @param vslSvcTpCd
	 */
	public void setVslSvcTpCd(String vslSvcTpCd) {
		this.vslSvcTpCd = vslSvcTpCd;
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
	 * @param vslSlanCd1
	 */
	public void setVslSlanCd1(String vslSlanCd1) {
		this.vslSlanCd1 = vslSlanCd1;
	}
	
	/**
	 * Column Info
	 * @param seq1
	 */
	public void setSeq1(String seq1) {
		this.seq1 = seq1;
	}
	
	/**
	 * Column Info
	 * @param seq2
	 */
	public void setSeq2(String seq2) {
		this.seq2 = seq2;
	}
	
	/**
	 * Column Info
	 * @param vslSlanNm2
	 */
	public void setVslSlanNm2(String vslSlanNm2) {
		this.vslSlanNm2 = vslSlanNm2;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd2
	 */
	public void setVslSlanCd2(String vslSlanCd2) {
		this.vslSlanCd2 = vslSlanCd2;
	}
	
	/**
	 * Column Info
	 * @param vslSlanNm1
	 */
	public void setVslSlanNm1(String vslSlanNm1) {
		this.vslSlanNm1 = vslSlanNm1;
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
		setVslSvcTpCd(JSPUtil.getParameter(request, "vsl_svc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslSlanCd1(JSPUtil.getParameter(request, "vsl_slan_cd1", ""));
		setSeq1(JSPUtil.getParameter(request, "seq1", ""));
		setSeq2(JSPUtil.getParameter(request, "seq2", ""));
		setVslSlanNm2(JSPUtil.getParameter(request, "vsl_slan_nm2", ""));
		setVslSlanCd2(JSPUtil.getParameter(request, "vsl_slan_cd2", ""));
		setVslSlanNm1(JSPUtil.getParameter(request, "vsl_slan_nm1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ServiceLaneVO[]
	 */
	public ServiceLaneVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ServiceLaneVO[]
	 */
	public ServiceLaneVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ServiceLaneVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "vsl_svc_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslSlanCd1 = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd1", length));
			String[] seq1 = (JSPUtil.getParameter(request, prefix	+ "seq1", length));
			String[] seq2 = (JSPUtil.getParameter(request, prefix	+ "seq2", length));
			String[] vslSlanNm2 = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm2", length));
			String[] vslSlanCd2 = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd2", length));
			String[] vslSlanNm1 = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_nm1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ServiceLaneVO();
				if (vslSvcTpCd[i] != null)
					model.setVslSvcTpCd(vslSvcTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslSlanCd1[i] != null)
					model.setVslSlanCd1(vslSlanCd1[i]);
				if (seq1[i] != null)
					model.setSeq1(seq1[i]);
				if (seq2[i] != null)
					model.setSeq2(seq2[i]);
				if (vslSlanNm2[i] != null)
					model.setVslSlanNm2(vslSlanNm2[i]);
				if (vslSlanCd2[i] != null)
					model.setVslSlanCd2(vslSlanCd2[i]);
				if (vslSlanNm1[i] != null)
					model.setVslSlanNm1(vslSlanNm1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getServiceLaneVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ServiceLaneVO[]
	 */
	public ServiceLaneVO[] getServiceLaneVOs(){
		ServiceLaneVO[] vos = (ServiceLaneVO[])models.toArray(new ServiceLaneVO[models.size()]);
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
		this.vslSvcTpCd = this.vslSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd1 = this.vslSlanCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq1 = this.seq1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq2 = this.seq2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm2 = this.vslSlanNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd2 = this.vslSlanCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanNm1 = this.vslSlanNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
