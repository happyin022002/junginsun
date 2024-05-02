/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustSlsRepVO.java
*@FileTitle : CustSlsRepVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.07.22 강동윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustSlsRepVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustSlsRepVO> models = new ArrayList<CustSlsRepVO>();
	
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String srepCustClssCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String objRowId = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String parObjRowId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String msgEtt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usrKey = null;
	/* Column Info */
	private String opCd = null;
	/* Column Info */
	private String msgId = null;
	/* Column Info */
	private String srcSysCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String msgCreDt = null;
	/* Column Info */
	private String instanceId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustSlsRepVO() {}

	public CustSlsRepVO(String ibflag, String pagerows, String srepCd, String custCntCd, String custSeq, String deltFlg, String dpSeq, String srepCustClssCd, String creUsrId, String creDt, String updUsrId, String updDt, String msgId, String msgEtt, String srcSysCd, String msgCreDt, String instanceId, String opCd, String objRowId, String usrKey, String parObjRowId) {
		this.dpSeq = dpSeq;
		this.updDt = updDt;
		this.srepCustClssCd = srepCustClssCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.custSeq = custSeq;
		this.objRowId = objRowId;
		this.srepCd = srepCd;
		this.parObjRowId = parObjRowId;
		this.pagerows = pagerows;
		this.msgEtt = msgEtt;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.usrKey = usrKey;
		this.opCd = opCd;
		this.msgId = msgId;
		this.srcSysCd = srcSysCd;
		this.custCntCd = custCntCd;
		this.updUsrId = updUsrId;
		this.msgCreDt = msgCreDt;
		this.instanceId = instanceId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("srep_cust_clss_cd", getSrepCustClssCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("obj_row_id", getObjRowId());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("par_obj_row_id", getParObjRowId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("msg_ett", getMsgEtt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usr_key", getUsrKey());
		this.hashColumns.put("op_cd", getOpCd());
		this.hashColumns.put("msg_id", getMsgId());
		this.hashColumns.put("src_sys_cd", getSrcSysCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("msg_cre_dt", getMsgCreDt());
		this.hashColumns.put("instance_id", getInstanceId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("srep_cust_clss_cd", "srepCustClssCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("obj_row_id", "objRowId");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("par_obj_row_id", "parObjRowId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("msg_ett", "msgEtt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usr_key", "usrKey");
		this.hashFields.put("op_cd", "opCd");
		this.hashFields.put("msg_id", "msgId");
		this.hashFields.put("src_sys_cd", "srcSysCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("msg_cre_dt", "msgCreDt");
		this.hashFields.put("instance_id", "instanceId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return srepCustClssCd
	 */
	public String getSrepCustClssCd() {
		return this.srepCustClssCd;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return objRowId
	 */
	public String getObjRowId() {
		return this.objRowId;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 * Column Info
	 * @return parObjRowId
	 */
	public String getParObjRowId() {
		return this.parObjRowId;
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
	 * @return msgEtt
	 */
	public String getMsgEtt() {
		return this.msgEtt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return usrKey
	 */
	public String getUsrKey() {
		return this.usrKey;
	}
	
	/**
	 * Column Info
	 * @return opCd
	 */
	public String getOpCd() {
		return this.opCd;
	}
	
	/**
	 * Column Info
	 * @return msgId
	 */
	public String getMsgId() {
		return this.msgId;
	}
	
	/**
	 * Column Info
	 * @return srcSysCd
	 */
	public String getSrcSysCd() {
		return this.srcSysCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @return msgCreDt
	 */
	public String getMsgCreDt() {
		return this.msgCreDt;
	}
	
	/**
	 * Column Info
	 * @return instanceId
	 */
	public String getInstanceId() {
		return instanceId;
	}

	/**
	 * Column Info
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param srepCustClssCd
	 */
	public void setSrepCustClssCd(String srepCustClssCd) {
		this.srepCustClssCd = srepCustClssCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param objRowId
	 */
	public void setObjRowId(String objRowId) {
		this.objRowId = objRowId;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * Column Info
	 * @param parObjRowId
	 */
	public void setParObjRowId(String parObjRowId) {
		this.parObjRowId = parObjRowId;
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
	 * @param msgEtt
	 */
	public void setMsgEtt(String msgEtt) {
		this.msgEtt = msgEtt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param usrKey
	 */
	public void setUsrKey(String usrKey) {
		this.usrKey = usrKey;
	}
	
	/**
	 * Column Info
	 * @param opCd
	 */
	public void setOpCd(String opCd) {
		this.opCd = opCd;
	}
	
	/**
	 * Column Info
	 * @param msgId
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	/**
	 * Column Info
	 * @param srcSysCd
	 */
	public void setSrcSysCd(String srcSysCd) {
		this.srcSysCd = srcSysCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
	 * @param msgCreDt
	 */
	public void setMsgCreDt(String msgCreDt) {
		this.msgCreDt = msgCreDt;
	}
	
	/**
	 * Column Info
	 * @param instanceId
	 */
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDpSeq(JSPUtil.getParameter(request, "dp_seq", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setSrepCustClssCd(JSPUtil.getParameter(request, "srep_cust_clss_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setObjRowId(JSPUtil.getParameter(request, "obj_row_id", ""));
		setSrepCd(JSPUtil.getParameter(request, "srep_cd", ""));
		setParObjRowId(JSPUtil.getParameter(request, "par_obj_row_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMsgEtt(JSPUtil.getParameter(request, "msg_ett", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUsrKey(JSPUtil.getParameter(request, "usr_key", ""));
		setOpCd(JSPUtil.getParameter(request, "op_cd", ""));
		setMsgId(JSPUtil.getParameter(request, "msg_id", ""));
		setSrcSysCd(JSPUtil.getParameter(request, "src_sys_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMsgCreDt(JSPUtil.getParameter(request, "msg_cre_dt", ""));
		setInstanceId(JSPUtil.getParameter(request, "instance_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustSlsRepVO[]
	 */
	public CustSlsRepVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustSlsRepVO[]
	 */
	public CustSlsRepVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustSlsRepVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] srepCustClssCd = (JSPUtil.getParameter(request, prefix	+ "srep_cust_clss_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] objRowId = (JSPUtil.getParameter(request, prefix	+ "obj_row_id", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] parObjRowId = (JSPUtil.getParameter(request, prefix	+ "par_obj_row_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] msgEtt = (JSPUtil.getParameter(request, prefix	+ "msg_ett", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usrKey = (JSPUtil.getParameter(request, prefix	+ "usr_key", length));
			String[] opCd = (JSPUtil.getParameter(request, prefix	+ "op_cd", length));
			String[] msgId = (JSPUtil.getParameter(request, prefix	+ "msg_id", length));
			String[] srcSysCd = (JSPUtil.getParameter(request, prefix	+ "src_sys_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] msgCreDt = (JSPUtil.getParameter(request, prefix	+ "msg_cre_dt", length));
			String[] instanceId = (JSPUtil.getParameter(request, prefix	+ "instance_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustSlsRepVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (srepCustClssCd[i] != null)
					model.setSrepCustClssCd(srepCustClssCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (objRowId[i] != null)
					model.setObjRowId(objRowId[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (parObjRowId[i] != null)
					model.setParObjRowId(parObjRowId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (msgEtt[i] != null)
					model.setMsgEtt(msgEtt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usrKey[i] != null)
					model.setUsrKey(usrKey[i]);
				if (opCd[i] != null)
					model.setOpCd(opCd[i]);
				if (msgId[i] != null)
					model.setMsgId(msgId[i]);
				if (srcSysCd[i] != null)
					model.setSrcSysCd(srcSysCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (msgCreDt[i] != null)
					model.setMsgCreDt(msgCreDt[i]);
				if (instanceId[i] != null)
					model.setInstanceId(instanceId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustSlsRepVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustSlsRepVO[]
	 */
	public CustSlsRepVO[] getCustSlsRepVOs(){
		CustSlsRepVO[] vos = (CustSlsRepVO[])models.toArray(new CustSlsRepVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCustClssCd = this.srepCustClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objRowId = this.objRowId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.parObjRowId = this.parObjRowId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgEtt = this.msgEtt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrKey = this.usrKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCd = this.opCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgId = this.msgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcSysCd = this.srcSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgCreDt = this.msgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.instanceId = this.instanceId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
