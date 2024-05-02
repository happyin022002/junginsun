/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RlyVslGrpAssignInputVO.java
*@FileTitle : RlyVslGrpAssignInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.15 최영희 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RlyVslGrpAssignInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RlyVslGrpAssignInputVO> models = new ArrayList<RlyVslGrpAssignInputVO>();
	
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String relayportCd = null;
	/* Column Info */
	private String formerVvd = null;
	/* Column Info */
	private String nextVvd = null;
	/* Column Info */
	private String etbFrom = null;
	/* Column Info */
	private String etbTo = null;
	/* Column Info */
	private String relayportYardCd = null;
	/* Column Info */
	private String nextPort = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RlyVslGrpAssignInputVO() {}

	public RlyVslGrpAssignInputVO(String ibflag, String pagerows, String relayportCd, String relayportYardCd, String etbFrom, String etbTo, String formerVvd, String nextVvd, String nextPort, String polCd, String podCd) {
		this.podCd = podCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.relayportCd = relayportCd;
		this.formerVvd = formerVvd;
		this.nextVvd = nextVvd;
		this.etbFrom = etbFrom;
		this.etbTo = etbTo;
		this.relayportYardCd = relayportYardCd;
		this.nextPort = nextPort;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("relayport_cd", getRelayportCd());
		this.hashColumns.put("former_vvd", getFormerVvd());
		this.hashColumns.put("next_vvd", getNextVvd());
		this.hashColumns.put("etb_from", getEtbFrom());
		this.hashColumns.put("etb_to", getEtbTo());
		this.hashColumns.put("relayport_yard_cd", getRelayportYardCd());
		this.hashColumns.put("next_port", getNextPort());
		this.hashColumns.put("pagerows", getPagerows());
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
		this.hashFields.put("relayport_cd", "relayportCd");
		this.hashFields.put("former_vvd", "formerVvd");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("etb_from", "etbFrom");
		this.hashFields.put("etb_to", "etbTo");
		this.hashFields.put("relayport_yard_cd", "relayportYardCd");
		this.hashFields.put("next_port", "nextPort");
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
	 * @return relayportCd
	 */
	public String getRelayportCd() {
		return this.relayportCd;
	}
	
	/**
	 * Column Info
	 * @return formerVvd
	 */
	public String getFormerVvd() {
		return this.formerVvd;
	}
	
	/**
	 * Column Info
	 * @return nextVvd
	 */
	public String getNextVvd() {
		return this.nextVvd;
	}
	
	/**
	 * Column Info
	 * @return etbFrom
	 */
	public String getEtbFrom() {
		return this.etbFrom;
	}
	
	/**
	 * Column Info
	 * @return etbTo
	 */
	public String getEtbTo() {
		return this.etbTo;
	}
	
	/**
	 * Column Info
	 * @return relayportYardCd
	 */
	public String getRelayportYardCd() {
		return this.relayportYardCd;
	}
	
	/**
	 * Column Info
	 * @return nextPort
	 */
	public String getNextPort() {
		return this.nextPort;
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
	 * @param relayportCd
	 */
	public void setRelayportCd(String relayportCd) {
		this.relayportCd = relayportCd;
	}
	
	/**
	 * Column Info
	 * @param formerVvd
	 */
	public void setFormerVvd(String formerVvd) {
		this.formerVvd = formerVvd;
	}
	
	/**
	 * Column Info
	 * @param nextVvd
	 */
	public void setNextVvd(String nextVvd) {
		this.nextVvd = nextVvd;
	}
	
	/**
	 * Column Info
	 * @param etbFrom
	 */
	public void setEtbFrom(String etbFrom) {
		this.etbFrom = etbFrom;
	}
	
	/**
	 * Column Info
	 * @param etbTo
	 */
	public void setEtbTo(String etbTo) {
		this.etbTo = etbTo;
	}
	
	/**
	 * Column Info
	 * @param relayportYardCd
	 */
	public void setRelayportYardCd(String relayportYardCd) {
		this.relayportYardCd = relayportYardCd;
	}
	
	/**
	 * Column Info
	 * @param nextPort
	 */
	public void setNextPort(String nextPort) {
		this.nextPort = nextPort;
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
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRelayportCd(JSPUtil.getParameter(request, "relayport_cd", ""));
		setFormerVvd(JSPUtil.getParameter(request, "former_vvd", ""));
		setNextVvd(JSPUtil.getParameter(request, "next_vvd", ""));
		setEtbFrom(JSPUtil.getParameter(request, "etb_from", ""));
		setEtbTo(JSPUtil.getParameter(request, "etb_to", ""));
		setRelayportYardCd(JSPUtil.getParameter(request, "relayport_yard_cd", ""));
		setNextPort(JSPUtil.getParameter(request, "next_port", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RlyVslGrpAssignInputVO[]
	 */
	public RlyVslGrpAssignInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RlyVslGrpAssignInputVO[]
	 */
	public RlyVslGrpAssignInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RlyVslGrpAssignInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] relayportCd = (JSPUtil.getParameter(request, prefix	+ "relayport_cd", length));
			String[] formerVvd = (JSPUtil.getParameter(request, prefix	+ "former_vvd", length));
			String[] nextVvd = (JSPUtil.getParameter(request, prefix	+ "next_vvd", length));
			String[] etbFrom = (JSPUtil.getParameter(request, prefix	+ "etb_from", length));
			String[] etbTo = (JSPUtil.getParameter(request, prefix	+ "etb_to", length));
			String[] relayportYardCd = (JSPUtil.getParameter(request, prefix	+ "relayport_yard_cd", length));
			String[] nextPort = (JSPUtil.getParameter(request, prefix	+ "next_port", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RlyVslGrpAssignInputVO();
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (relayportCd[i] != null)
					model.setRelayportCd(relayportCd[i]);
				if (formerVvd[i] != null)
					model.setFormerVvd(formerVvd[i]);
				if (nextVvd[i] != null)
					model.setNextVvd(nextVvd[i]);
				if (etbFrom[i] != null)
					model.setEtbFrom(etbFrom[i]);
				if (etbTo[i] != null)
					model.setEtbTo(etbTo[i]);
				if (relayportYardCd[i] != null)
					model.setRelayportYardCd(relayportYardCd[i]);
				if (nextPort[i] != null)
					model.setNextPort(nextPort[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRlyVslGrpAssignInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RlyVslGrpAssignInputVO[]
	 */
	public RlyVslGrpAssignInputVO[] getRlyVslGrpAssignInputVOs(){
		RlyVslGrpAssignInputVO[] vos = (RlyVslGrpAssignInputVO[])models.toArray(new RlyVslGrpAssignInputVO[models.size()]);
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
		this.relayportCd = this.relayportCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formerVvd = this.formerVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd = this.nextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbFrom = this.etbFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbTo = this.etbTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.relayportYardCd = this.relayportYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPort = this.nextPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
