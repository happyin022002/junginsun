/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NextVvdAssignInputVO.java
*@FileTitle : NextVvdAssignInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.16 최영희 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NextVvdAssignInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NextVvdAssignInputVO> models = new ArrayList<NextVvdAssignInputVO>();
	
	/* Column Info */
	private String relayPort = null;
	/* Column Info */
	private String formerVvd = null;
	/* Column Info */
	private String rdCgoFlg = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String nextVvd = null;
	/* Column Info */
	private String relayPortYardCd = null;
	/* Column Info */
	private String etbFrom = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String etbTo = null;
	/* Column Info */
	private String nextPort = null;
	/* Column Info */
	private String nextVvdSelect = null;
	/* Column Info */
	private String invalidVvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NextVvdAssignInputVO() {}

	public NextVvdAssignInputVO(String ibflag, String pagerows, String relayPort, String relayPortYardCd, String formerVvd, String etbFrom, String etbTo, String polCd, String nextPort, String podCd, String nextVvd, String nextVvdSelect, String rcFlg, String dcgoFlg, String awkCgoFlg, String rdCgoFlg, String podYdCd, String invalidVvd) {
		this.relayPort = relayPort;
		this.formerVvd = formerVvd;
		this.rdCgoFlg = rdCgoFlg;
		this.awkCgoFlg = awkCgoFlg;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.dcgoFlg = dcgoFlg;
		this.nextVvd = nextVvd;
		this.relayPortYardCd = relayPortYardCd;
		this.etbFrom = etbFrom;
		this.podYdCd = podYdCd;
		this.rcFlg = rcFlg;
		this.etbTo = etbTo;
		this.nextPort = nextPort;
		this.nextVvdSelect = nextVvdSelect;
		this.invalidVvd = invalidVvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("relay_port", getRelayPort());
		this.hashColumns.put("former_vvd", getFormerVvd());
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("next_vvd", getNextVvd());
		this.hashColumns.put("relay_port_yard_cd", getRelayPortYardCd());
		this.hashColumns.put("etb_from", getEtbFrom());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("etb_to", getEtbTo());
		this.hashColumns.put("next_port", getNextPort());
		this.hashColumns.put("next_vvd_select", getNextVvdSelect());
		this.hashColumns.put("invalid_vvd", getInvalidVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("relay_port", "relayPort");
		this.hashFields.put("former_vvd", "formerVvd");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("relay_port_yard_cd", "relayPortYardCd");
		this.hashFields.put("etb_from", "etbFrom");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("etb_to", "etbTo");
		this.hashFields.put("next_port", "nextPort");
		this.hashFields.put("next_vvd_select", "nextVvdSelect");
		this.hashFields.put("invalid_vvd", "invalidVvd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return relayPort
	 */
	public String getRelayPort() {
		return this.relayPort;
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
	 * @return rdCgoFlg
	 */
	public String getRdCgoFlg() {
		return this.rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
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
	 * @return relayPortYardCd
	 */
	public String getRelayPortYardCd() {
		return this.relayPortYardCd;
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
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
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
	 * @return nextPort
	 */
	public String getNextPort() {
		return this.nextPort;
	}
	
	/**
	 * Column Info
	 * @return nextVvdSelect
	 */
	public String getNextVvdSelect() {
		return this.nextVvdSelect;
	}
	
	/**
	 * Column Info
	 * @return invalidVvd
	 */
	public String getInvalidVvd() {
		return this.invalidVvd;
	}
	

	/**
	 * Column Info
	 * @param relayPort
	 */
	public void setRelayPort(String relayPort) {
		this.relayPort = relayPort;
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
	 * @param rdCgoFlg
	 */
	public void setRdCgoFlg(String rdCgoFlg) {
		this.rdCgoFlg = rdCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
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
	 * @param relayPortYardCd
	 */
	public void setRelayPortYardCd(String relayPortYardCd) {
		this.relayPortYardCd = relayPortYardCd;
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
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
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
	 * @param nextPort
	 */
	public void setNextPort(String nextPort) {
		this.nextPort = nextPort;
	}
	
	/**
	 * Column Info
	 * @param nextVvdSelect
	 */
	public void setNextVvdSelect(String nextVvdSelect) {
		this.nextVvdSelect = nextVvdSelect;
	}
	
	/**
	 * Column Info
	 * @param invalidVvd
	 */
	public void setInvalidVvd(String invalidVvd) {
		this.invalidVvd = invalidVvd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRelayPort(JSPUtil.getParameter(request, "relay_port", ""));
		setFormerVvd(JSPUtil.getParameter(request, "former_vvd", ""));
		setRdCgoFlg(JSPUtil.getParameter(request, "rd_cgo_flg", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, "awk_cgo_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setDcgoFlg(JSPUtil.getParameter(request, "dcgo_flg", ""));
		setNextVvd(JSPUtil.getParameter(request, "next_vvd", ""));
		setRelayPortYardCd(JSPUtil.getParameter(request, "relay_port_yard_cd", ""));
		setEtbFrom(JSPUtil.getParameter(request, "etb_from", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setEtbTo(JSPUtil.getParameter(request, "etb_to", ""));
		setNextPort(JSPUtil.getParameter(request, "next_port", ""));
		setNextVvdSelect(JSPUtil.getParameter(request, "next_vvd_select", ""));
		setInvalidVvd(JSPUtil.getParameter(request, "invalid_vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NextVvdAssignInputVO[]
	 */
	public NextVvdAssignInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NextVvdAssignInputVO[]
	 */
	public NextVvdAssignInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NextVvdAssignInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] relayPort = (JSPUtil.getParameter(request, prefix	+ "relay_port", length));
			String[] formerVvd = (JSPUtil.getParameter(request, prefix	+ "former_vvd", length));
			String[] rdCgoFlg = (JSPUtil.getParameter(request, prefix	+ "rd_cgo_flg", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] nextVvd = (JSPUtil.getParameter(request, prefix	+ "next_vvd", length));
			String[] relayPortYardCd = (JSPUtil.getParameter(request, prefix	+ "relay_port_yard_cd", length));
			String[] etbFrom = (JSPUtil.getParameter(request, prefix	+ "etb_from", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] etbTo = (JSPUtil.getParameter(request, prefix	+ "etb_to", length));
			String[] nextPort = (JSPUtil.getParameter(request, prefix	+ "next_port", length));
			String[] nextVvdSelect = (JSPUtil.getParameter(request, prefix	+ "next_vvd_select", length));
			String[] invalidVvd = (JSPUtil.getParameter(request, prefix	+ "invalid_vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new NextVvdAssignInputVO();
				if (relayPort[i] != null)
					model.setRelayPort(relayPort[i]);
				if (formerVvd[i] != null)
					model.setFormerVvd(formerVvd[i]);
				if (rdCgoFlg[i] != null)
					model.setRdCgoFlg(rdCgoFlg[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (nextVvd[i] != null)
					model.setNextVvd(nextVvd[i]);
				if (relayPortYardCd[i] != null)
					model.setRelayPortYardCd(relayPortYardCd[i]);
				if (etbFrom[i] != null)
					model.setEtbFrom(etbFrom[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (etbTo[i] != null)
					model.setEtbTo(etbTo[i]);
				if (nextPort[i] != null)
					model.setNextPort(nextPort[i]);
				if (nextVvdSelect[i] != null)
					model.setNextVvdSelect(nextVvdSelect[i]);
				if (invalidVvd[i] != null)
					model.setInvalidVvd(invalidVvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNextVvdAssignInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NextVvdAssignInputVO[]
	 */
	public NextVvdAssignInputVO[] getNextVvdAssignInputVOs(){
		NextVvdAssignInputVO[] vos = (NextVvdAssignInputVO[])models.toArray(new NextVvdAssignInputVO[models.size()]);
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
		this.relayPort = this.relayPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formerVvd = this.formerVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg = this.rdCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd = this.nextVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.relayPortYardCd = this.relayPortYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbFrom = this.etbFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbTo = this.etbTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextPort = this.nextPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvdSelect = this.nextVvdSelect .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invalidVvd = this.invalidVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
