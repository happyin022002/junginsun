/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InBondNumberDetailVO.java
*@FileTitle : InBondNumberDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.22 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class InBondNumberDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InBondNumberDetailVO> models = new ArrayList<InBondNumberDetailVO>();
	
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String entryType = null;
	/* Column Info */
	private String del = null;
	/* Column Info */
	private String lUsa = null;
	/* Column Info */
	private String hub = null;
	/* Column Info */
	private String inbondType = null;
	/* Column Info */
	private String pmibNo = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String cstms = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InBondNumberDetailVO() {}

	public InBondNumberDetailVO(String ibflag, String pagerows, String vvd, String pod, String cstms, String hub, String del, String pmibNo, String inbondType, String entryType, String lUsa) {
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.entryType = entryType;
		this.del = del;
		this.lUsa = lUsa;
		this.hub = hub;
		this.inbondType = inbondType;
		this.pmibNo = pmibNo;
		this.pod = pod;
		this.cstms = cstms;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("entry_type", getEntryType());
		this.hashColumns.put("del", getDel());
		this.hashColumns.put("l_usa", getLUsa());
		this.hashColumns.put("hub", getHub());
		this.hashColumns.put("inbond_type", getInbondType());
		this.hashColumns.put("pmib_no", getPmibNo());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("cstms", getCstms());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("entry_type", "entryType");
		this.hashFields.put("del", "del");
		this.hashFields.put("l_usa", "lUsa");
		this.hashFields.put("hub", "hub");
		this.hashFields.put("inbond_type", "inbondType");
		this.hashFields.put("pmib_no", "pmibNo");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("cstms", "cstms");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return entryType
	 */
	public String getEntryType() {
		return this.entryType;
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
	 * @return lUsa
	 */
	public String getLUsa() {
		return this.lUsa;
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
	 * @return inbondType
	 */
	public String getInbondType() {
		return this.inbondType;
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
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return cstms
	 */
	public String getCstms() {
		return this.cstms;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param entryType
	 */
	public void setEntryType(String entryType) {
		this.entryType = entryType;
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
	 * @param lUsa
	 */
	public void setLUsa(String lUsa) {
		this.lUsa = lUsa;
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
	 * @param inbondType
	 */
	public void setInbondType(String inbondType) {
		this.inbondType = inbondType;
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
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param cstms
	 */
	public void setCstms(String cstms) {
		this.cstms = cstms;
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
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEntryType(JSPUtil.getParameter(request, "entry_type", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
		setLUsa(JSPUtil.getParameter(request, "l_usa", ""));
		setHub(JSPUtil.getParameter(request, "hub", ""));
		setInbondType(JSPUtil.getParameter(request, "inbond_type", ""));
		setPmibNo(JSPUtil.getParameter(request, "pmib_no", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setCstms(JSPUtil.getParameter(request, "cstms", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InBondNumberDetailVO[]
	 */
	public InBondNumberDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InBondNumberDetailVO[]
	 */
	public InBondNumberDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InBondNumberDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] entryType = (JSPUtil.getParameter(request, prefix	+ "entry_type", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			String[] lUsa = (JSPUtil.getParameter(request, prefix	+ "l_usa", length));
			String[] hub = (JSPUtil.getParameter(request, prefix	+ "hub", length));
			String[] inbondType = (JSPUtil.getParameter(request, prefix	+ "inbond_type", length));
			String[] pmibNo = (JSPUtil.getParameter(request, prefix	+ "pmib_no", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] cstms = (JSPUtil.getParameter(request, prefix	+ "cstms", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new InBondNumberDetailVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (entryType[i] != null)
					model.setEntryType(entryType[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				if (lUsa[i] != null)
					model.setLUsa(lUsa[i]);
				if (hub[i] != null)
					model.setHub(hub[i]);
				if (inbondType[i] != null)
					model.setInbondType(inbondType[i]);
				if (pmibNo[i] != null)
					model.setPmibNo(pmibNo[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (cstms[i] != null)
					model.setCstms(cstms[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInBondNumberDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InBondNumberDetailVO[]
	 */
	public InBondNumberDetailVO[] getInBondNumberDetailVOs(){
		InBondNumberDetailVO[] vos = (InBondNumberDetailVO[])models.toArray(new InBondNumberDetailVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.entryType = this.entryType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lUsa = this.lUsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hub = this.hub .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inbondType = this.inbondType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pmibNo = this.pmibNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstms = this.cstms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
