/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HongKongSearchVslGeneralVO.java
*@FileTitle : HongKongSearchVslGeneralVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.17 임재택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.vo;

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
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HongKongSearchVslGeneralVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HongKongSearchVslGeneralVO> models = new ArrayList<HongKongSearchVslGeneralVO>();
	
	/* Column Info */
	private String vslFullname = null;
	/* Column Info */
	private String prevportEtd = null;
	/* Column Info */
	private String nextport = null;
	/* Column Info */
	private String declaration = null;
	/* Column Info */
	private String vslCallsign = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String amendVvd = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String prevport = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vslLloydcode = null;
	/* Column Info */
	private String ataDt = null;
	/* Column Info */
	private String vvdNumber = null;
	/* Column Info */
	private String nextportEta = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HongKongSearchVslGeneralVO() {}

	public HongKongSearchVslGeneralVO(String ibflag, String pagerows, String vvdNumber, String polCd, String podCd, String vslCallsign, String vslLloydcode, String vslFullname, String etaDt, String etdDt, String ataDt, String declaration, String amendVvd, String nextport, String nextportEta, String prevport, String prevportEtd) {
		this.vslFullname = vslFullname;
		this.prevportEtd = prevportEtd;
		this.nextport = nextport;
		this.declaration = declaration;
		this.vslCallsign = vslCallsign;
		this.etaDt = etaDt;
		this.amendVvd = amendVvd;
		this.etdDt = etdDt;
		this.prevport = prevport;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.vslLloydcode = vslLloydcode;
		this.ataDt = ataDt;
		this.vvdNumber = vvdNumber;
		this.nextportEta = nextportEta;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_fullname", getVslFullname());
		this.hashColumns.put("prevport_etd", getPrevportEtd());
		this.hashColumns.put("nextport", getNextport());
		this.hashColumns.put("declaration", getDeclaration());
		this.hashColumns.put("vsl_callsign", getVslCallsign());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("amend_vvd", getAmendVvd());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("prevport", getPrevport());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vsl_lloydcode", getVslLloydcode());
		this.hashColumns.put("ata_dt", getAtaDt());
		this.hashColumns.put("vvd_number", getVvdNumber());
		this.hashColumns.put("nextport_eta", getNextportEta());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_fullname", "vslFullname");
		this.hashFields.put("prevport_etd", "prevportEtd");
		this.hashFields.put("nextport", "nextport");
		this.hashFields.put("declaration", "declaration");
		this.hashFields.put("vsl_callsign", "vslCallsign");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("amend_vvd", "amendVvd");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("prevport", "prevport");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vsl_lloydcode", "vslLloydcode");
		this.hashFields.put("ata_dt", "ataDt");
		this.hashFields.put("vvd_number", "vvdNumber");
		this.hashFields.put("nextport_eta", "nextportEta");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslFullname
	 */
	public String getVslFullname() {
		return this.vslFullname;
	}
	
	/**
	 * Column Info
	 * @return prevportEtd
	 */
	public String getPrevportEtd() {
		return this.prevportEtd;
	}
	
	/**
	 * Column Info
	 * @return nextport
	 */
	public String getNextport() {
		return this.nextport;
	}
	
	/**
	 * Column Info
	 * @return declaration
	 */
	public String getDeclaration() {
		return this.declaration;
	}
	
	/**
	 * Column Info
	 * @return vslCallsign
	 */
	public String getVslCallsign() {
		return this.vslCallsign;
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
	 * @return amendVvd
	 */
	public String getAmendVvd() {
		return this.amendVvd;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return prevport
	 */
	public String getPrevport() {
		return this.prevport;
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
	 * @return vslLloydcode
	 */
	public String getVslLloydcode() {
		return this.vslLloydcode;
	}
	
	/**
	 * Column Info
	 * @return ataDt
	 */
	public String getAtaDt() {
		return this.ataDt;
	}
	
	/**
	 * Column Info
	 * @return vvdNumber
	 */
	public String getVvdNumber() {
		return this.vvdNumber;
	}
	
	/**
	 * Column Info
	 * @return nextportEta
	 */
	public String getNextportEta() {
		return this.nextportEta;
	}
	

	/**
	 * Column Info
	 * @param vslFullname
	 */
	public void setVslFullname(String vslFullname) {
		this.vslFullname = vslFullname;
	}
	
	/**
	 * Column Info
	 * @param prevportEtd
	 */
	public void setPrevportEtd(String prevportEtd) {
		this.prevportEtd = prevportEtd;
	}
	
	/**
	 * Column Info
	 * @param nextport
	 */
	public void setNextport(String nextport) {
		this.nextport = nextport;
	}
	
	/**
	 * Column Info
	 * @param declaration
	 */
	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}
	
	/**
	 * Column Info
	 * @param vslCallsign
	 */
	public void setVslCallsign(String vslCallsign) {
		this.vslCallsign = vslCallsign;
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
	 * @param amendVvd
	 */
	public void setAmendVvd(String amendVvd) {
		this.amendVvd = amendVvd;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param prevport
	 */
	public void setPrevport(String prevport) {
		this.prevport = prevport;
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
	 * @param vslLloydcode
	 */
	public void setVslLloydcode(String vslLloydcode) {
		this.vslLloydcode = vslLloydcode;
	}
	
	/**
	 * Column Info
	 * @param ataDt
	 */
	public void setAtaDt(String ataDt) {
		this.ataDt = ataDt;
	}
	
	/**
	 * Column Info
	 * @param vvdNumber
	 */
	public void setVvdNumber(String vvdNumber) {
		this.vvdNumber = vvdNumber;
	}
	
	/**
	 * Column Info
	 * @param nextportEta
	 */
	public void setNextportEta(String nextportEta) {
		this.nextportEta = nextportEta;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslFullname(JSPUtil.getParameter(request, "vsl_fullname", ""));
		setPrevportEtd(JSPUtil.getParameter(request, "prevport_etd", ""));
		setNextport(JSPUtil.getParameter(request, "nextport", ""));
		setDeclaration(JSPUtil.getParameter(request, "declaration", ""));
		setVslCallsign(JSPUtil.getParameter(request, "vsl_callsign", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setAmendVvd(JSPUtil.getParameter(request, "amend_vvd", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setPrevport(JSPUtil.getParameter(request, "prevport", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setVslLloydcode(JSPUtil.getParameter(request, "vsl_lloydcode", ""));
		setAtaDt(JSPUtil.getParameter(request, "ata_dt", ""));
		setVvdNumber(JSPUtil.getParameter(request, "vvd_number", ""));
		setNextportEta(JSPUtil.getParameter(request, "nextport_eta", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HongKongSearchVslGeneralVO[]
	 */
	public HongKongSearchVslGeneralVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HongKongSearchVslGeneralVO[]
	 */
	public HongKongSearchVslGeneralVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HongKongSearchVslGeneralVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname", length));
			String[] prevportEtd = (JSPUtil.getParameter(request, prefix	+ "prevport_etd", length));
			String[] nextport = (JSPUtil.getParameter(request, prefix	+ "nextport", length));
			String[] declaration = (JSPUtil.getParameter(request, prefix	+ "declaration", length));
			String[] vslCallsign = (JSPUtil.getParameter(request, prefix	+ "vsl_callsign", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] amendVvd = (JSPUtil.getParameter(request, prefix	+ "amend_vvd", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] prevport = (JSPUtil.getParameter(request, prefix	+ "prevport", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vslLloydcode = (JSPUtil.getParameter(request, prefix	+ "vsl_lloydcode", length));
			String[] ataDt = (JSPUtil.getParameter(request, prefix	+ "ata_dt", length));
			String[] vvdNumber = (JSPUtil.getParameter(request, prefix	+ "vvd_number", length));
			String[] nextportEta = (JSPUtil.getParameter(request, prefix	+ "nextport_eta", length));
			
			for (int i = 0; i < length; i++) {
				model = new HongKongSearchVslGeneralVO();
				if (vslFullname[i] != null)
					model.setVslFullname(vslFullname[i]);
				if (prevportEtd[i] != null)
					model.setPrevportEtd(prevportEtd[i]);
				if (nextport[i] != null)
					model.setNextport(nextport[i]);
				if (declaration[i] != null)
					model.setDeclaration(declaration[i]);
				if (vslCallsign[i] != null)
					model.setVslCallsign(vslCallsign[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (amendVvd[i] != null)
					model.setAmendVvd(amendVvd[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (prevport[i] != null)
					model.setPrevport(prevport[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vslLloydcode[i] != null)
					model.setVslLloydcode(vslLloydcode[i]);
				if (ataDt[i] != null)
					model.setAtaDt(ataDt[i]);
				if (vvdNumber[i] != null)
					model.setVvdNumber(vvdNumber[i]);
				if (nextportEta[i] != null)
					model.setNextportEta(nextportEta[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHongKongSearchVslGeneralVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HongKongSearchVslGeneralVO[]
	 */
	public HongKongSearchVslGeneralVO[] getHongKongSearchVslGeneralVOs(){
		HongKongSearchVslGeneralVO[] vos = (HongKongSearchVslGeneralVO[])models.toArray(new HongKongSearchVslGeneralVO[models.size()]);
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
		this.vslFullname = this.vslFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevportEtd = this.prevportEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextport = this.nextport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.declaration = this.declaration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallsign = this.vslCallsign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amendVvd = this.amendVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevport = this.prevport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLloydcode = this.vslLloydcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ataDt = this.ataDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNumber = this.vvdNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextportEta = this.nextportEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
