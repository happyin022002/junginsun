/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VslSkdCngUpdateVO.java
*@FileTitle : VslSkdCngUpdateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.09.18 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VslSkdCngUpdateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VslSkdCngUpdateVO> models = new ArrayList<VslSkdCngUpdateVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String oldYdCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String newYdCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String oldClptIndSeq = null;
	/* Column Info */
	private String newClptIndSeq = null;
	/* Column Info */ 
	private String oldEtdDt = null;
	/* Column Info */ 
	private String oldEtaDt = null;
	/* Column Info */ 
	private String skdCngTpCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VslSkdCngUpdateVO() {}

	public VslSkdCngUpdateVO(String ibflag, String pagerows, String vvd, String portCd, String oldClptIndSeq, String newClptIndSeq, String oldYdCd, String newYdCd, String oldEtdDt, String oldEtaDt, String skdCngTpCd) {
		this.vvd = vvd;
		this.oldYdCd = oldYdCd;
		this.ibflag = ibflag;
		this.newYdCd = newYdCd;
		this.portCd = portCd;
		this.oldClptIndSeq = oldClptIndSeq;
		this.newClptIndSeq = newClptIndSeq;
		this.pagerows = pagerows;
		this.oldEtdDt = oldEtdDt;
		this.oldEtaDt = oldEtaDt;
		this.skdCngTpCd = skdCngTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("old_yd_cd", getOldYdCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("new_yd_cd", getNewYdCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("old_clpt_ind_seq", getOldClptIndSeq());
		this.hashColumns.put("new_clpt_ind_seq", getNewClptIndSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("old_etd_dt", getOldEtdDt());
		this.hashColumns.put("old_eta_dt", getOldEtaDt());
		this.hashColumns.put("skd_cng_tp_cd", getSkdCngTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("old_yd_cd", "oldYdCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("new_yd_cd", "newYdCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("old_clpt_ind_seq", "oldClptIndSeq");
		this.hashFields.put("new_clpt_ind_seq", "newClptIndSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("old_etd_dt", "oldEtdDt");
		this.hashFields.put("old_eta_dt", "oldEtaDt");
		this.hashFields.put("skd_cng_tp_cd", "skdCngTpCd");
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
	 * @return oldYdCd
	 */
	public String getOldYdCd() {
		return this.oldYdCd;
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
	 * @return newYdCd
	 */
	public String getNewYdCd() {
		return this.newYdCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return oldClptIndSeq
	 */
	public String getOldClptIndSeq() {
		return this.oldClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return newClptIndSeq
	 */
	public String getNewClptIndSeq() {
		return this.newClptIndSeq;
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
	 * @return oldEtdDt
	 */
	public String getOldEtdDt() {
		return oldEtdDt;
	}
	
	/**
	 * Column Info
	 * @return oldEtaDt
	 */
	public String getOldEtaDt() {
		return oldEtaDt;
	}
	
	/**
	 * Column Info
	 * @return skdCngTpCd
	 */
	public String getSkdCngTpCd() {
		return skdCngTpCd;
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
	 * @param oldYdCd
	 */
	public void setOldYdCd(String oldYdCd) {
		this.oldYdCd = oldYdCd;
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
	 * @param newYdCd
	 */
	public void setNewYdCd(String newYdCd) {
		this.newYdCd = newYdCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param oldClptIndSeq
	 */
	public void setOldClptIndSeq(String oldClptIndSeq) {
		this.oldClptIndSeq = oldClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param newClptIndSeq
	 */
	public void setNewClptIndSeq(String newClptIndSeq) {
		this.newClptIndSeq = newClptIndSeq;
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
	 * @param oldEtdDt
	 */
	public void setOldEtdDt(String oldEtdDt) {
		this.oldEtdDt = oldEtdDt;
	}
	
	/**
	 * Column Info
	 * @return oldEtaDt
	 */
	public void setOldEtaDt(String oldEtaDt) {
		this.oldEtaDt = oldEtaDt;
	}

	/**
	 * Column Info
	 * @return skdCngTpCd
	 */
	public void setSkdCngTpCd(String skdCngTpCd) {
		this.skdCngTpCd = skdCngTpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setOldYdCd(JSPUtil.getParameter(request, "old_yd_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNewYdCd(JSPUtil.getParameter(request, "new_yd_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setOldClptIndSeq(JSPUtil.getParameter(request, "old_clpt_ind_seq", ""));
		setNewClptIndSeq(JSPUtil.getParameter(request, "new_clpt_ind_seq", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOldEtdDt(JSPUtil.getParameter(request, "old_etd_dt", ""));
		setOldEtaDt(JSPUtil.getParameter(request, "old_eta_dt", ""));
		setSkdCngTpCd(JSPUtil.getParameter(request, "skd_cng_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VslSkdCngUpdateVO[]
	 */
	public VslSkdCngUpdateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VslSkdCngUpdateVO[]
	 */
	public VslSkdCngUpdateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VslSkdCngUpdateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] oldYdCd = (JSPUtil.getParameter(request, prefix	+ "old_yd_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] newYdCd = (JSPUtil.getParameter(request, prefix	+ "new_yd_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] oldClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "old_clpt_ind_seq", length));
			String[] newClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "new_clpt_ind_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oldEtdDt = (JSPUtil.getParameter(request, prefix	+ "old_etd_dt", length));
			String[] oldEtaDt = (JSPUtil.getParameter(request, prefix	+ "old_eta_dt", length));
			String[] skdCngTpCd = (JSPUtil.getParameter(request, prefix	+ "skd_cng_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new VslSkdCngUpdateVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (oldYdCd[i] != null)
					model.setOldYdCd(oldYdCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (newYdCd[i] != null)
					model.setNewYdCd(newYdCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (oldClptIndSeq[i] != null)
					model.setOldClptIndSeq(oldClptIndSeq[i]);
				if (newClptIndSeq[i] != null)
					model.setNewClptIndSeq(newClptIndSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oldEtdDt[i] != null)
					model.setOldEtdDt(oldEtdDt[i]);
				if (oldEtaDt[i] != null)
					model.setOldEtaDt(oldEtdDt[i]);
				if (skdCngTpCd[i] != null)
					model.setSkdCngTpCd(skdCngTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVslSkdCngUpdateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VslSkdCngUpdateVO[]
	 */
	public VslSkdCngUpdateVO[] getVslSkdCngUpdateVOs(){
		VslSkdCngUpdateVO[] vos = (VslSkdCngUpdateVO[])models.toArray(new VslSkdCngUpdateVO[models.size()]);
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
		this.oldYdCd = this.oldYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newYdCd = this.newYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldClptIndSeq = this.oldClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newClptIndSeq = this.newClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldEtdDt = this.oldEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldEtaDt = this.oldEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdCngTpCd = this.skdCngTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}