/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCstmsFltFileCusrepVO.java
*@FileTitle : AncsCstmsFltFileCusrepVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.06.29 정재엽 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo;

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
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AncsCstmsFltFileCusrepVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsCstmsFltFileCusrepVO> models = new ArrayList<AncsCstmsFltFileCusrepVO>();
	
	/* Column Info */
	private String lloydCode = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String berth = null;
	/* Column Info */
	private String beginPort = null;
	/* Column Info */
	private String prevDocno = null;
	/* Column Info */
	private String updateInd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String vesselflag = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vesselname = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String dischargeInd = null;
	/* Column Info */
	private String gdNumber = null;

	private String msgSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AncsCstmsFltFileCusrepVO() {}

	public AncsCstmsFltFileCusrepVO(String ibflag, String pagerows, String gdNumber, String lloydCode, String seq, String updateInd, String prevDocno, String beginPort, String dischargeInd, String berth, String vvd, String vesselname, String vesselflag, String eta, String msgSeq) {
		this.lloydCode = lloydCode;
		this.eta = eta;
		this.berth = berth;
		this.beginPort = beginPort;
		this.prevDocno = prevDocno;
		this.updateInd = updateInd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.vesselflag = vesselflag;
		this.ibflag = ibflag;
		this.vesselname = vesselname;
		this.seq = seq;
		this.dischargeInd = dischargeInd;
		this.gdNumber = gdNumber;
		this.msgSeq   = msgSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lloyd_code", getLloydCode());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("berth", getBerth());
		this.hashColumns.put("begin_port", getBeginPort());
		this.hashColumns.put("prev_docno", getPrevDocno());
		this.hashColumns.put("update_ind", getUpdateInd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("vesselflag", getVesselflag());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vesselname", getVesselname());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("discharge_ind", getDischargeInd());
		this.hashColumns.put("gd_number", getGdNumber());
		this.hashColumns.put("msg_seq", getMsgSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lloyd_code", "lloydCode");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("berth", "berth");
		this.hashFields.put("begin_port", "beginPort");
		this.hashFields.put("prev_docno", "prevDocno");
		this.hashFields.put("update_ind", "updateInd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("vesselflag", "vesselflag");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vesselname", "vesselname");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("discharge_ind", "dischargeInd");
		this.hashFields.put("gd_number", "gdNumber");
		this.hashFields.put("msg_seq", "msgSeq");
		return this.hashFields;
	}
	
	
	
	public String getMsgSeq() {
		return msgSeq;
	}

	public void setMsgSeq(String msgSeq) {
		this.msgSeq = msgSeq;
	}

	/**
	 * Column Info
	 * @return lloydCode
	 */
	public String getLloydCode() {
		return this.lloydCode;
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
	 * @return berth
	 */
	public String getBerth() {
		return this.berth;
	}
	
	/**
	 * Column Info
	 * @return beginPort
	 */
	public String getBeginPort() {
		return this.beginPort;
	}
	
	/**
	 * Column Info
	 * @return prevDocno
	 */
	public String getPrevDocno() {
		return this.prevDocno;
	}
	
	/**
	 * Column Info
	 * @return updateInd
	 */
	public String getUpdateInd() {
		return this.updateInd;
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
	 * @return vesselflag
	 */
	public String getVesselflag() {
		return this.vesselflag;
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
	 * @return vesselname
	 */
	public String getVesselname() {
		return this.vesselname;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return dischargeInd
	 */
	public String getDischargeInd() {
		return this.dischargeInd;
	}
	
	/**
	 * Column Info
	 * @return gdNumber
	 */
	public String getGdNumber() {
		return this.gdNumber;
	}
	

	/**
	 * Column Info
	 * @param lloydCode
	 */
	public void setLloydCode(String lloydCode) {
		this.lloydCode = lloydCode;
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
	 * @param berth
	 */
	public void setBerth(String berth) {
		this.berth = berth;
	}
	
	/**
	 * Column Info
	 * @param beginPort
	 */
	public void setBeginPort(String beginPort) {
		this.beginPort = beginPort;
	}
	
	/**
	 * Column Info
	 * @param prevDocno
	 */
	public void setPrevDocno(String prevDocno) {
		this.prevDocno = prevDocno;
	}
	
	/**
	 * Column Info
	 * @param updateInd
	 */
	public void setUpdateInd(String updateInd) {
		this.updateInd = updateInd;
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
	 * @param vesselflag
	 */
	public void setVesselflag(String vesselflag) {
		this.vesselflag = vesselflag;
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
	 * @param vesselname
	 */
	public void setVesselname(String vesselname) {
		this.vesselname = vesselname;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param dischargeInd
	 */
	public void setDischargeInd(String dischargeInd) {
		this.dischargeInd = dischargeInd;
	}
	
	/**
	 * Column Info
	 * @param gdNumber
	 */
	public void setGdNumber(String gdNumber) {
		this.gdNumber = gdNumber;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLloydCode(JSPUtil.getParameter(request, "lloyd_code", ""));
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setBerth(JSPUtil.getParameter(request, "berth", ""));
		setBeginPort(JSPUtil.getParameter(request, "begin_port", ""));
		setPrevDocno(JSPUtil.getParameter(request, "prev_docno", ""));
		setUpdateInd(JSPUtil.getParameter(request, "update_ind", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setVesselflag(JSPUtil.getParameter(request, "vesselflag", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVesselname(JSPUtil.getParameter(request, "vesselname", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setDischargeInd(JSPUtil.getParameter(request, "discharge_ind", ""));
		setGdNumber(JSPUtil.getParameter(request, "gd_number", ""));
		setMsgSeq(JSPUtil.getParameter(request, "msg_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsFltFileCusrepVO[]
	 */
	public AncsCstmsFltFileCusrepVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsFltFileCusrepVO[]
	 */
	public AncsCstmsFltFileCusrepVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsCstmsFltFileCusrepVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lloydCode = (JSPUtil.getParameter(request, prefix	+ "lloyd_code", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] berth = (JSPUtil.getParameter(request, prefix	+ "berth", length));
			String[] beginPort = (JSPUtil.getParameter(request, prefix	+ "begin_port", length));
			String[] prevDocno = (JSPUtil.getParameter(request, prefix	+ "prev_docno", length));
			String[] updateInd = (JSPUtil.getParameter(request, prefix	+ "update_ind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] vesselflag = (JSPUtil.getParameter(request, prefix	+ "vesselflag", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vesselname = (JSPUtil.getParameter(request, prefix	+ "vesselname", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] dischargeInd = (JSPUtil.getParameter(request, prefix	+ "discharge_ind", length));
			String[] gdNumber = (JSPUtil.getParameter(request, prefix	+ "gd_number", length));
			String[] msgSeq = (JSPUtil.getParameter(request, prefix	+ "msg_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsCstmsFltFileCusrepVO();
				if (lloydCode[i] != null)
					model.setLloydCode(lloydCode[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (berth[i] != null)
					model.setBerth(berth[i]);
				if (beginPort[i] != null)
					model.setBeginPort(beginPort[i]);
				if (prevDocno[i] != null)
					model.setPrevDocno(prevDocno[i]);
				if (updateInd[i] != null)
					model.setUpdateInd(updateInd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (vesselflag[i] != null)
					model.setVesselflag(vesselflag[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vesselname[i] != null)
					model.setVesselname(vesselname[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (dischargeInd[i] != null)
					model.setDischargeInd(dischargeInd[i]);
				if (gdNumber[i] != null)
					model.setGdNumber(gdNumber[i]);
				if (msgSeq[i] != null)
					model.setMsgSeq(msgSeq[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsFltFileCusrepVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsFltFileCusrepVO[]
	 */
	public AncsCstmsFltFileCusrepVO[] getAncsCstmsFltFileCusrepVOs(){
		AncsCstmsFltFileCusrepVO[] vos = (AncsCstmsFltFileCusrepVO[])models.toArray(new AncsCstmsFltFileCusrepVO[models.size()]);
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
		this.lloydCode = this.lloydCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.berth = this.berth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beginPort = this.beginPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevDocno = this.prevDocno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateInd = this.updateInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselflag = this.vesselflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselname = this.vesselname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dischargeInd = this.dischargeInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gdNumber = this.gdNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSeq = this.msgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
