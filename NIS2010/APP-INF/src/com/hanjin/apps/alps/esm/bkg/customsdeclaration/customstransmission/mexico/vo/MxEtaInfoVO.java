/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MxEtaInfoVO.java
*@FileTitle : MxEtaInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MxEtaInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MxEtaInfoVO> models = new ArrayList<MxEtaInfoVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String compId = null;
	/* Column Info */
	private String vslFullname = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String prevportEtd = null;
	/* Column Info */
	private String nextport = null;
	/* Column Info */
	private String mrnName = null;
	/* Column Info */
	private String vslCallsign = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String vslFlag = null;
	/* Column Info */
	private String ioInd = null;
	/* Column Info */
	private String mrn = null;
	/* Column Info */
	private String prevport = null;
	/* Column Info */
	private String portname = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String brac = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdRefNo = null;
	/* Column Info */
	private String vslLloydcode = null;
	/* Column Info */
	private String nextportEta = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MxEtaInfoVO() {}

	public MxEtaInfoVO(String ibflag, String pagerows, String brac, String vvd, String vslCallsign, String vslLloydcode, String vslFullname, String vslFlag, String laneCd, String vvdRefNo, String port, String portname, String eta, String etd, String nextport, String nextportEta, String prevport, String prevportEtd, String ioInd, String compId, String mrn, String mrnName) {
		this.port = port;
		this.compId = compId;
		this.vslFullname = vslFullname;
		this.laneCd = laneCd;
		this.eta = eta;
		this.prevportEtd = prevportEtd;
		this.nextport = nextport;
		this.mrnName = mrnName;
		this.vslCallsign = vslCallsign;
		this.etd = etd;
		this.vslFlag = vslFlag;
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
		this.hashColumns.put("mrn_name", getMrnName());
		this.hashColumns.put("vsl_callsign", getVslCallsign());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("vsl_flag", getVslFlag());
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
		this.hashFields.put("mrn_name", "mrnName");
		this.hashFields.put("vsl_callsign", "vslCallsign");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("vsl_flag", "vslFlag");
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
	 * @return mrnName
	 */
	public String getMrnName() {
		return this.mrnName;
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
	 * @return vslFlag
	 */
	public String getVslFlag() {
		return this.vslFlag;
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
	 * @param mrnName
	 */
	public void setMrnName(String mrnName) {
		this.mrnName = mrnName;
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
	 * @param vslFlag
	 */
	public void setVslFlag(String vslFlag) {
		this.vslFlag = vslFlag;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPort(JSPUtil.getParameter(request, prefix + "port", ""));
		setCompId(JSPUtil.getParameter(request, prefix + "comp_id", ""));
		setVslFullname(JSPUtil.getParameter(request, prefix + "vsl_fullname", ""));
		setLaneCd(JSPUtil.getParameter(request, prefix + "lane_cd", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setPrevportEtd(JSPUtil.getParameter(request, prefix + "prevport_etd", ""));
		setNextport(JSPUtil.getParameter(request, prefix + "nextport", ""));
		setMrnName(JSPUtil.getParameter(request, prefix + "mrn_name", ""));
		setVslCallsign(JSPUtil.getParameter(request, prefix + "vsl_callsign", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setVslFlag(JSPUtil.getParameter(request, prefix + "vsl_flag", ""));
		setIoInd(JSPUtil.getParameter(request, prefix + "io_ind", ""));
		setMrn(JSPUtil.getParameter(request, prefix + "mrn", ""));
		setPrevport(JSPUtil.getParameter(request, prefix + "prevport", ""));
		setPortname(JSPUtil.getParameter(request, prefix + "portname", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBrac(JSPUtil.getParameter(request, prefix + "brac", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdRefNo(JSPUtil.getParameter(request, prefix + "vvd_ref_no", ""));
		setVslLloydcode(JSPUtil.getParameter(request, prefix + "vsl_lloydcode", ""));
		setNextportEta(JSPUtil.getParameter(request, prefix + "nextport_eta", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MxEtaInfoVO[]
	 */
	public MxEtaInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MxEtaInfoVO[]
	 */
	public MxEtaInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MxEtaInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] compId = (JSPUtil.getParameter(request, prefix	+ "comp_id", length));
			String[] vslFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] prevportEtd = (JSPUtil.getParameter(request, prefix	+ "prevport_etd", length));
			String[] nextport = (JSPUtil.getParameter(request, prefix	+ "nextport", length));
			String[] mrnName = (JSPUtil.getParameter(request, prefix	+ "mrn_name", length));
			String[] vslCallsign = (JSPUtil.getParameter(request, prefix	+ "vsl_callsign", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] vslFlag = (JSPUtil.getParameter(request, prefix	+ "vsl_flag", length));
			String[] ioInd = (JSPUtil.getParameter(request, prefix	+ "io_ind", length));
			String[] mrn = (JSPUtil.getParameter(request, prefix	+ "mrn", length));
			String[] prevport = (JSPUtil.getParameter(request, prefix	+ "prevport", length));
			String[] portname = (JSPUtil.getParameter(request, prefix	+ "portname", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] brac = (JSPUtil.getParameter(request, prefix	+ "brac", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdRefNo = (JSPUtil.getParameter(request, prefix	+ "vvd_ref_no", length));
			String[] vslLloydcode = (JSPUtil.getParameter(request, prefix	+ "vsl_lloydcode", length));
			String[] nextportEta = (JSPUtil.getParameter(request, prefix	+ "nextport_eta", length));
			
			for (int i = 0; i < length; i++) {
				model = new MxEtaInfoVO();
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
				if (mrnName[i] != null)
					model.setMrnName(mrnName[i]);
				if (vslCallsign[i] != null)
					model.setVslCallsign(vslCallsign[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (vslFlag[i] != null)
					model.setVslFlag(vslFlag[i]);
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
		return getMxEtaInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MxEtaInfoVO[]
	 */
	public MxEtaInfoVO[] getMxEtaInfoVOs(){
		MxEtaInfoVO[] vos = (MxEtaInfoVO[])models.toArray(new MxEtaInfoVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
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
		this.mrnName = this.mrnName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallsign = this.vslCallsign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFlag = this.vslFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
