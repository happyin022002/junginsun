/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BrVvdSkdInfoVO.java
*@FileTitle : BrVvdSkdInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.27 경종윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.vo;

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
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BrVvdSkdInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BrVvdSkdInfoVO> models = new ArrayList<BrVvdSkdInfoVO>();
	
	/* Column Info */
	private String port = "";
	/* Column Info */
	private String compId = "";
	/* Column Info */
	private String vslFullname = "";
	/* Column Info */
	private String laneCd = "";
	/* Column Info */
	private String eta = "";
	/* Column Info */
	private String prevportEtd = "";
	/* Column Info */
	private String nextport = "";
	/* Column Info */
	private String vslCallsign = "";
	/* Column Info */
	private String etd = "";
	/* Column Info */
	private String ioInd = "";
	/* Column Info */
	private String mrn = "";
	/* Column Info */
	private String prevport = "";
	/* Column Info */
	private String portname = "";
	/* Page Number */
	private String pagerows = "";
	/* Column Info */
	private String brac = "";
	/* Column Info */
	private String vvd = "";
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = "";
	/* Column Info */
	private String vvdRefNo = "";
	/* Column Info */
	private String vslLloydcode = "";
	/* Column Info */
	private String nextportEta = "";

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BrVvdSkdInfoVO() {}

	public BrVvdSkdInfoVO(String ibflag, String pagerows, String brac, String vvd, String vslCallsign, String vslLloydcode, String vslFullname, String laneCd, String vvdRefNo, String port, String portname, String eta, String etd, String nextport, String nextportEta, String prevport, String prevportEtd, String ioInd, String compId, String mrn) {
		this.port = port;
		this.compId = compId;
		this.vslFullname = vslFullname;
		this.laneCd = laneCd;
		this.eta = eta;
		this.prevportEtd = prevportEtd;
		this.nextport = nextport;
		this.vslCallsign = vslCallsign;
		this.etd = etd;
		this.ioInd = ioInd;
		this.mrn = mrn;
		this.prevport = prevport;
		this.portname = portname;
		this.pagerows = pagerows;
		this.brac = brac;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.vvdRefNo = vvdRefNo;
		this.vslLloydcode = vslLloydcode;
		this.nextportEta = nextportEta;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("comp_id", getCompId());
		this.hashColumns.put("vsl_fullname", getVslFullname());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("prevport_etd", getPrevportEtd());
		this.hashColumns.put("nextport", getNextport());
		this.hashColumns.put("vsl_callsign", getVslCallsign());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("io_ind", getIoInd());
		this.hashColumns.put("mrn", getMrn());
		this.hashColumns.put("prevport", getPrevport());
		this.hashColumns.put("portname", getPortname());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("brac", getBrac());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_ref_no", getVvdRefNo());
		this.hashColumns.put("vsl_lloydcode", getVslLloydcode());
		this.hashColumns.put("nextport_eta", getNextportEta());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("comp_id", "compId");
		this.hashFields.put("vsl_fullname", "vslFullname");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("prevport_etd", "prevportEtd");
		this.hashFields.put("nextport", "nextport");
		this.hashFields.put("vsl_callsign", "vslCallsign");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("io_ind", "ioInd");
		this.hashFields.put("mrn", "mrn");
		this.hashFields.put("prevport", "prevport");
		this.hashFields.put("portname", "portname");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("brac", "brac");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_ref_no", "vvdRefNo");
		this.hashFields.put("vsl_lloydcode", "vslLloydcode");
		this.hashFields.put("nextport_eta", "nextportEta");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return compId
	 */
	public String getCompId() {
		return this.compId;
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
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
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
	 * @return vslCallsign
	 */
	public String getVslCallsign() {
		return this.vslCallsign;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return ioInd
	 */
	public String getIoInd() {
		return this.ioInd;
	}
	
	/**
	 * Column Info
	 * @return mrn
	 */
	public String getMrn() {
		return this.mrn;
	}
	
	/**
	 * Column Info
	 * @return prevport
	 */
	public String getPrevport() {
		return this.prevport;
	}
	
	/**
	 * Column Info
	 * @return portname
	 */
	public String getPortname() {
		return this.portname;
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
	 * @return brac
	 */
	public String getBrac() {
		return this.brac;
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
	 * @return vvdRefNo
	 */
	public String getVvdRefNo() {
		return this.vvdRefNo;
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
	 * @return nextportEta
	 */
	public String getNextportEta() {
		return this.nextportEta;
	}
	

	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param compId
	 */
	public void setCompId(String compId) {
		this.compId = compId;
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
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
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
	 * @param vslCallsign
	 */
	public void setVslCallsign(String vslCallsign) {
		this.vslCallsign = vslCallsign;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param ioInd
	 */
	public void setIoInd(String ioInd) {
		this.ioInd = ioInd;
	}
	
	/**
	 * Column Info
	 * @param mrn
	 */
	public void setMrn(String mrn) {
		this.mrn = mrn;
	}
	
	/**
	 * Column Info
	 * @param prevport
	 */
	public void setPrevport(String prevport) {
		this.prevport = prevport;
	}
	
	/**
	 * Column Info
	 * @param portname
	 */
	public void setPortname(String portname) {
		this.portname = portname;
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
	 * @param brac
	 */
	public void setBrac(String brac) {
		this.brac = brac;
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
	 * @param vvdRefNo
	 */
	public void setVvdRefNo(String vvdRefNo) {
		this.vvdRefNo = vvdRefNo;
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
		setPort(JSPUtil.getParameter(request, "port", ""));
		setCompId(JSPUtil.getParameter(request, "comp_id", ""));
		setVslFullname(JSPUtil.getParameter(request, "vsl_fullname", ""));
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setPrevportEtd(JSPUtil.getParameter(request, "prevport_etd", ""));
		setNextport(JSPUtil.getParameter(request, "nextport", ""));
		setVslCallsign(JSPUtil.getParameter(request, "vsl_callsign", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setIoInd(JSPUtil.getParameter(request, "io_ind", ""));
		setMrn(JSPUtil.getParameter(request, "mrn", ""));
		setPrevport(JSPUtil.getParameter(request, "prevport", ""));
		setPortname(JSPUtil.getParameter(request, "portname", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBrac(JSPUtil.getParameter(request, "brac", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdRefNo(JSPUtil.getParameter(request, "vvd_ref_no", ""));
		setVslLloydcode(JSPUtil.getParameter(request, "vsl_lloydcode", ""));
		setNextportEta(JSPUtil.getParameter(request, "nextport_eta", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BrVvdSkdInfoVO[]
	 */
	public BrVvdSkdInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BrVvdSkdInfoVO[]
	 */
	public BrVvdSkdInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BrVvdSkdInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port".trim(), length));
			String[] compId = (JSPUtil.getParameter(request, prefix	+ "comp_id".trim(), length));
			String[] vslFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname".trim(), length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd".trim(), length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta".trim(), length));
			String[] prevportEtd = (JSPUtil.getParameter(request, prefix	+ "prevport_etd".trim(), length));
			String[] nextport = (JSPUtil.getParameter(request, prefix	+ "nextport".trim(), length));
			String[] vslCallsign = (JSPUtil.getParameter(request, prefix	+ "vsl_callsign".trim(), length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd".trim(), length));
			String[] ioInd = (JSPUtil.getParameter(request, prefix	+ "io_ind".trim(), length));
			String[] mrn = (JSPUtil.getParameter(request, prefix	+ "mrn".trim(), length));
			String[] prevport = (JSPUtil.getParameter(request, prefix	+ "prevport".trim(), length));
			String[] portname = (JSPUtil.getParameter(request, prefix	+ "portname".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] brac = (JSPUtil.getParameter(request, prefix	+ "brac".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vvdRefNo = (JSPUtil.getParameter(request, prefix	+ "vvd_ref_no".trim(), length));
			String[] vslLloydcode = (JSPUtil.getParameter(request, prefix	+ "vsl_lloydcode".trim(), length));
			String[] nextportEta = (JSPUtil.getParameter(request, prefix	+ "nextport_eta".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BrVvdSkdInfoVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (compId[i] != null)
					model.setCompId(compId[i]);
				if (vslFullname[i] != null)
					model.setVslFullname(vslFullname[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (prevportEtd[i] != null)
					model.setPrevportEtd(prevportEtd[i]);
				if (nextport[i] != null)
					model.setNextport(nextport[i]);
				if (vslCallsign[i] != null)
					model.setVslCallsign(vslCallsign[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (ioInd[i] != null)
					model.setIoInd(ioInd[i]);
				if (mrn[i] != null)
					model.setMrn(mrn[i]);
				if (prevport[i] != null)
					model.setPrevport(prevport[i]);
				if (portname[i] != null)
					model.setPortname(portname[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (brac[i] != null)
					model.setBrac(brac[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdRefNo[i] != null)
					model.setVvdRefNo(vvdRefNo[i]);
				if (vslLloydcode[i] != null)
					model.setVslLloydcode(vslLloydcode[i]);
				if (nextportEta[i] != null)
					model.setNextportEta(nextportEta[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBrVvdSkdInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BrVvdSkdInfoVO[]
	 */
	public BrVvdSkdInfoVO[] getBrVvdSkdInfoVOs(){
		BrVvdSkdInfoVO[] vos = (BrVvdSkdInfoVO[])models.toArray(new BrVvdSkdInfoVO[models.size()]);
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
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.compId = this.compId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullname = this.vslFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevportEtd = this.prevportEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextport = this.nextport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallsign = this.vslCallsign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioInd = this.ioInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrn = this.mrn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevport = this.prevport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portname = this.portname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brac = this.brac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdRefNo = this.vvdRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLloydcode = this.vslLloydcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextportEta = this.nextportEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
