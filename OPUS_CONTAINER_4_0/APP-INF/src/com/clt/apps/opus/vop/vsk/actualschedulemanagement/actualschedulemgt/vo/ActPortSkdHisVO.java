/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActPortSkdHisVO.java
*@FileTitle : ActPortSkdHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.10.07 정진우 
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

public class ActPortSkdHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActPortSkdHisVO> models = new ArrayList<ActPortSkdHisVO>();
	
	/* Column Info */
	private String newCre = null;
	/* Column Info */
	private String oldAtd = null;
	/* Column Info */
	private String newAta = null;
	/* Column Info */
	private String oldAtb = null;
	/* Column Info */
	private String newAtb = null;
	/* Column Info */
	private String oldAta = null;
	/* Column Info */
	private String newUserId = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String newAtd = null;
	/* Column Info */
	private String oldUserId = null;
	/* Column Info */
	private String oldCre = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ActPortSkdHisVO() {}

	public ActPortSkdHisVO(String ibflag, String pagerows, String vvd, String vslSlanCd, String vpsPortCd, String oldAta, String oldAtb, String oldAtd, String oldCre, String oldUserId, String newAta, String newAtb, String newAtd, String newCre, String newUserId) {
		this.newCre = newCre;
		this.oldAtd = oldAtd;
		this.newAta = newAta;
		this.oldAtb = oldAtb;
		this.newAtb = newAtb;
		this.oldAta = oldAta;
		this.newUserId = newUserId;
		this.vslSlanCd = vslSlanCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.newAtd = newAtd;
		this.oldUserId = oldUserId;
		this.oldCre = oldCre;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("new_cre", getNewCre());
		this.hashColumns.put("old_atd", getOldAtd());
		this.hashColumns.put("new_ata", getNewAta());
		this.hashColumns.put("old_atb", getOldAtb());
		this.hashColumns.put("new_atb", getNewAtb());
		this.hashColumns.put("old_ata", getOldAta());
		this.hashColumns.put("new_user_id", getNewUserId());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("new_atd", getNewAtd());
		this.hashColumns.put("old_user_id", getOldUserId());
		this.hashColumns.put("old_cre", getOldCre());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("new_cre", "newCre");
		this.hashFields.put("old_atd", "oldAtd");
		this.hashFields.put("new_ata", "newAta");
		this.hashFields.put("old_atb", "oldAtb");
		this.hashFields.put("new_atb", "newAtb");
		this.hashFields.put("old_ata", "oldAta");
		this.hashFields.put("new_user_id", "newUserId");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("new_atd", "newAtd");
		this.hashFields.put("old_user_id", "oldUserId");
		this.hashFields.put("old_cre", "oldCre");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return newCre
	 */
	public String getNewCre() {
		return this.newCre;
	}
	
	/**
	 * Column Info
	 * @return oldAtd
	 */
	public String getOldAtd() {
		return this.oldAtd;
	}
	
	/**
	 * Column Info
	 * @return newAta
	 */
	public String getNewAta() {
		return this.newAta;
	}
	
	/**
	 * Column Info
	 * @return oldAtb
	 */
	public String getOldAtb() {
		return this.oldAtb;
	}
	
	/**
	 * Column Info
	 * @return newAtb
	 */
	public String getNewAtb() {
		return this.newAtb;
	}
	
	/**
	 * Column Info
	 * @return oldAta
	 */
	public String getOldAta() {
		return this.oldAta;
	}
	
	/**
	 * Column Info
	 * @return newUserId
	 */
	public String getNewUserId() {
		return this.newUserId;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return newAtd
	 */
	public String getNewAtd() {
		return this.newAtd;
	}
	
	/**
	 * Column Info
	 * @return oldUserId
	 */
	public String getOldUserId() {
		return this.oldUserId;
	}
	
	/**
	 * Column Info
	 * @return oldCre
	 */
	public String getOldCre() {
		return this.oldCre;
	}
	

	/**
	 * Column Info
	 * @param newCre
	 */
	public void setNewCre(String newCre) {
		this.newCre = newCre;
	}
	
	/**
	 * Column Info
	 * @param oldAtd
	 */
	public void setOldAtd(String oldAtd) {
		this.oldAtd = oldAtd;
	}
	
	/**
	 * Column Info
	 * @param newAta
	 */
	public void setNewAta(String newAta) {
		this.newAta = newAta;
	}
	
	/**
	 * Column Info
	 * @param oldAtb
	 */
	public void setOldAtb(String oldAtb) {
		this.oldAtb = oldAtb;
	}
	
	/**
	 * Column Info
	 * @param newAtb
	 */
	public void setNewAtb(String newAtb) {
		this.newAtb = newAtb;
	}
	
	/**
	 * Column Info
	 * @param oldAta
	 */
	public void setOldAta(String oldAta) {
		this.oldAta = oldAta;
	}
	
	/**
	 * Column Info
	 * @param newUserId
	 */
	public void setNewUserId(String newUserId) {
		this.newUserId = newUserId;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param newAtd
	 */
	public void setNewAtd(String newAtd) {
		this.newAtd = newAtd;
	}
	
	/**
	 * Column Info
	 * @param oldUserId
	 */
	public void setOldUserId(String oldUserId) {
		this.oldUserId = oldUserId;
	}
	
	/**
	 * Column Info
	 * @param oldCre
	 */
	public void setOldCre(String oldCre) {
		this.oldCre = oldCre;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNewCre(JSPUtil.getParameter(request, "new_cre", ""));
		setOldAtd(JSPUtil.getParameter(request, "old_atd", ""));
		setNewAta(JSPUtil.getParameter(request, "new_ata", ""));
		setOldAtb(JSPUtil.getParameter(request, "old_atb", ""));
		setNewAtb(JSPUtil.getParameter(request, "new_atb", ""));
		setOldAta(JSPUtil.getParameter(request, "old_ata", ""));
		setNewUserId(JSPUtil.getParameter(request, "new_user_id", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNewAtd(JSPUtil.getParameter(request, "new_atd", ""));
		setOldUserId(JSPUtil.getParameter(request, "old_user_id", ""));
		setOldCre(JSPUtil.getParameter(request, "old_cre", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActPortSkdHisVO[]
	 */
	public ActPortSkdHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActPortSkdHisVO[]
	 */
	public ActPortSkdHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActPortSkdHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] newCre = (JSPUtil.getParameter(request, prefix	+ "new_cre", length));
			String[] oldAtd = (JSPUtil.getParameter(request, prefix	+ "old_atd", length));
			String[] newAta = (JSPUtil.getParameter(request, prefix	+ "new_ata", length));
			String[] oldAtb = (JSPUtil.getParameter(request, prefix	+ "old_atb", length));
			String[] newAtb = (JSPUtil.getParameter(request, prefix	+ "new_atb", length));
			String[] oldAta = (JSPUtil.getParameter(request, prefix	+ "old_ata", length));
			String[] newUserId = (JSPUtil.getParameter(request, prefix	+ "new_user_id", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] newAtd = (JSPUtil.getParameter(request, prefix	+ "new_atd", length));
			String[] oldUserId = (JSPUtil.getParameter(request, prefix	+ "old_user_id", length));
			String[] oldCre = (JSPUtil.getParameter(request, prefix	+ "old_cre", length));
			
			for (int i = 0; i < length; i++) {
				model = new ActPortSkdHisVO();
				if (newCre[i] != null)
					model.setNewCre(newCre[i]);
				if (oldAtd[i] != null)
					model.setOldAtd(oldAtd[i]);
				if (newAta[i] != null)
					model.setNewAta(newAta[i]);
				if (oldAtb[i] != null)
					model.setOldAtb(oldAtb[i]);
				if (newAtb[i] != null)
					model.setNewAtb(newAtb[i]);
				if (oldAta[i] != null)
					model.setOldAta(oldAta[i]);
				if (newUserId[i] != null)
					model.setNewUserId(newUserId[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (newAtd[i] != null)
					model.setNewAtd(newAtd[i]);
				if (oldUserId[i] != null)
					model.setOldUserId(oldUserId[i]);
				if (oldCre[i] != null)
					model.setOldCre(oldCre[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActPortSkdHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ActPortSkdHisVO[]
	 */
	public ActPortSkdHisVO[] getActPortSkdHisVOs(){
		ActPortSkdHisVO[] vos = (ActPortSkdHisVO[])models.toArray(new ActPortSkdHisVO[models.size()]);
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
		this.newCre = this.newCre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAtd = this.oldAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAta = this.newAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAtb = this.oldAtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAtb = this.newAtb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAta = this.oldAta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newUserId = this.newUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newAtd = this.newAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldUserId = this.oldUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldCre = this.oldCre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
