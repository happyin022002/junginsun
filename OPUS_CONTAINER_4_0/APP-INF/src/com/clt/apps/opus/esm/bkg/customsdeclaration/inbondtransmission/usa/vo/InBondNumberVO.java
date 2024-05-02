/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InBondNumberVO.java
*@FileTitle : InBondNumberVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.10 김도완 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InBondNumberVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InBondNumberVO> models = new ArrayList<InBondNumberVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String cstms = null;
	/* Column Info */
	private String hub = null;
	/* Column Info */
	private String pmibNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String pod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InBondNumberVO() {}

	public InBondNumberVO(String ibflag, String pagerows, String vvd, String pod, String hub, String del, String cstms, String blNo, String pmibNo, String userId, String ofcCd) {
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.userId = userId;
		this.del = del;
		this.cstms = cstms;
		this.hub = hub;
		this.pmibNo = pmibNo;
		this.blNo = blNo;
		this.pod = pod;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("cstms", getCstms());
		this.hashColumns.put("hub", getHub());
		this.hashColumns.put("pmib_no", getPmibNo());
		this.hashColumns.put("bl_no", getBlNo());
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
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("del", "del");
		this.hashFields.put("cstms", "cstms");
		this.hashFields.put("hub", "hub");
		this.hashFields.put("pmib_no", "pmibNo");
		this.hashFields.put("bl_no", "blNo");
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
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
	 * @return cstms
	 */
	public String getCstms() {
		return this.cstms;
	}
	
	/**
	 * Column Info
	 * @return hub
	 */
	public String getHub() {
		return this.hub;
	}
	
	/**
	 * Column Info
	 * @return pmibNo
	 */
	public String getPmibNo() {
		return this.pmibNo;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @param cstms
	 */
	public void setCstms(String cstms) {
		this.cstms = cstms;
	}
	
	/**
	 * Column Info
	 * @param hub
	 */
	public void setHub(String hub) {
		this.hub = hub;
	}
	
	/**
	 * Column Info
	 * @param pmibNo
	 */
	public void setPmibNo(String pmibNo) {
		this.pmibNo = pmibNo;
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
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setCstms(JSPUtil.getParameter(request, "cstms", ""));
		setHub(JSPUtil.getParameter(request, "hub", ""));
		setPmibNo(JSPUtil.getParameter(request, "pmib_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InBondNumberVO[]
	 */
	public InBondNumberVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InBondNumberVO[]
	 */
	public InBondNumberVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InBondNumberVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] cstms = (JSPUtil.getParameter(request, prefix	+ "cstms", length));
			String[] hub = (JSPUtil.getParameter(request, prefix	+ "hub", length));
			String[] pmibNo = (JSPUtil.getParameter(request, prefix	+ "pmib_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InBondNumberVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (cstms[i] != null)
					model.setCstms(cstms[i]);
				if (hub[i] != null)
					model.setHub(hub[i]);
				if (pmibNo[i] != null)
					model.setPmibNo(pmibNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInBondNumberVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InBondNumberVO[]
	 */
	public InBondNumberVO[] getInBondNumberVOs(){
		InBondNumberVO[] vos = (InBondNumberVO[])models.toArray(new InBondNumberVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstms = this.cstms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hub = this.hub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmibNo = this.pmibNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
