/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaTransmitCondVO.java
*@FileTitle : IndiaTransmitCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.02 경종윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IndiaTransmitCondVO extends ManifestTransmitVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<IndiaTransmitCondVO> models = new ArrayList<IndiaTransmitCondVO>();
	
	/* Column Info */
	private String idaAgnId = null;
	/* Column Info */
	private String genDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String processType = null;
	/* Column Info */
	private String sender = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String msgType = null;
	/* Column Info */
	private String tpFee = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String lineCd = null;
	/* Column Info */
	private String emptyCheck = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IndiaTransmitCondVO() {}

	public IndiaTransmitCondVO(String ibflag, String pagerows, String vvdCd, String polCd, String podCd, String lineCd, String msgType, String processType, String emptyCheck, String sender, String tpFee, String idaAgnId, String genDt, String creUsrId, String updUsrId) {
		this.idaAgnId = idaAgnId;
		this.genDt = genDt;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.processType = processType;
		this.sender = sender;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.vvdCd = vvdCd;
		this.msgType = msgType;
		this.tpFee = tpFee;
		this.updUsrId = updUsrId;
		this.lineCd = lineCd;
		this.emptyCheck = emptyCheck;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ida_agn_id", getIdaAgnId());
		this.hashColumns.put("gen_dt", getGenDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("process_type", getProcessType());
		this.hashColumns.put("sender", getSender());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("msg_type", getMsgType());
		this.hashColumns.put("tp_fee", getTpFee());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("line_cd", getLineCd());
		this.hashColumns.put("empty_check", getEmptyCheck());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ida_agn_id", "idaAgnId");
		this.hashFields.put("gen_dt", "genDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("process_type", "processType");
		this.hashFields.put("sender", "sender");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("msg_type", "msgType");
		this.hashFields.put("tp_fee", "tpFee");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("line_cd", "lineCd");
		this.hashFields.put("empty_check", "emptyCheck");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return idaAgnId
	 */
	public String getIdaAgnId() {
		return this.idaAgnId;
	}
	
	/**
	 * Column Info
	 * @return genDt
	 */
	public String getGenDt() {
		return this.genDt;
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
	 * Column Info
	 * @return processType
	 */
	public String getProcessType() {
		return this.processType;
	}
	
	/**
	 * Column Info
	 * @return sender
	 */
	public String getSender() {
		return this.sender;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return msgType
	 */
	public String getMsgType() {
		return this.msgType;
	}
	
	/**
	 * Column Info
	 * @return tpFee
	 */
	public String getTpFee() {
		return this.tpFee;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return lineCd
	 */
	public String getLineCd() {
		return this.lineCd;
	}
	
	/**
	 * Column Info
	 * @return emptyCheck
	 */
	public String getEmptyCheck() {
		return this.emptyCheck;
	}
	

	/**
	 * Column Info
	 * @param idaAgnId
	 */
	public void setIdaAgnId(String idaAgnId) {
		this.idaAgnId = idaAgnId;
	}
	
	/**
	 * Column Info
	 * @param genDt
	 */
	public void setGenDt(String genDt) {
		this.genDt = genDt;
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
	 * Column Info
	 * @param processType
	 */
	public void setProcessType(String processType) {
		this.processType = processType;
	}
	
	/**
	 * Column Info
	 * @param sender
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param msgType
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	/**
	 * Column Info
	 * @param tpFee
	 */
	public void setTpFee(String tpFee) {
		this.tpFee = tpFee;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param lineCd
	 */
	public void setLineCd(String lineCd) {
		this.lineCd = lineCd;
	}
	
	/**
	 * Column Info
	 * @param emptyCheck
	 */
	public void setEmptyCheck(String emptyCheck) {
		this.emptyCheck = emptyCheck;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIdaAgnId(JSPUtil.getParameter(request, "ida_agn_id", ""));
		setGenDt(JSPUtil.getParameter(request, "gen_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setProcessType(JSPUtil.getParameter(request, "process_type", ""));
		setSender(JSPUtil.getParameter(request, "sender", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setMsgType(JSPUtil.getParameter(request, "msg_type", ""));
		setTpFee(JSPUtil.getParameter(request, "tp_fee", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setLineCd(JSPUtil.getParameter(request, "line_cd", ""));
		setEmptyCheck(JSPUtil.getParameter(request, "empty_check", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IndiaTransmitCondVO[]
	 */
	public IndiaTransmitCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IndiaTransmitCondVO[]
	 */
	public IndiaTransmitCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IndiaTransmitCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] idaAgnId = (JSPUtil.getParameter(request, prefix	+ "ida_agn_id", length));
			String[] genDt = (JSPUtil.getParameter(request, prefix	+ "gen_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] processType = (JSPUtil.getParameter(request, prefix	+ "process_type", length));
			String[] sender = (JSPUtil.getParameter(request, prefix	+ "sender", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] msgType = (JSPUtil.getParameter(request, prefix	+ "msg_type", length));
			String[] tpFee = (JSPUtil.getParameter(request, prefix	+ "tp_fee", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] lineCd = (JSPUtil.getParameter(request, prefix	+ "line_cd", length));
			String[] emptyCheck = (JSPUtil.getParameter(request, prefix	+ "empty_check", length));
			
			for (int i = 0; i < length; i++) {
				model = new IndiaTransmitCondVO();
				if (idaAgnId[i] != null)
					model.setIdaAgnId(idaAgnId[i]);
				if (genDt[i] != null)
					model.setGenDt(genDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (processType[i] != null)
					model.setProcessType(processType[i]);
				if (sender[i] != null)
					model.setSender(sender[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (msgType[i] != null)
					model.setMsgType(msgType[i]);
				if (tpFee[i] != null)
					model.setTpFee(tpFee[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (lineCd[i] != null)
					model.setLineCd(lineCd[i]);
				if (emptyCheck[i] != null)
					model.setEmptyCheck(emptyCheck[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIndiaTransmitCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IndiaTransmitCondVO[]
	 */
	public IndiaTransmitCondVO[] getIndiaTransmitCondVOs(){
		IndiaTransmitCondVO[] vos = (IndiaTransmitCondVO[])models.toArray(new IndiaTransmitCondVO[models.size()]);
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
		this.idaAgnId = this.idaAgnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genDt = this.genDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.processType = this.processType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sender = this.sender .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgType = this.msgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpFee = this.tpFee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineCd = this.lineCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emptyCheck = this.emptyCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
