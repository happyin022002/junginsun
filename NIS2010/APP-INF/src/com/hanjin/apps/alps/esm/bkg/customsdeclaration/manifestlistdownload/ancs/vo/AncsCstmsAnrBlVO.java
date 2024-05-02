/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCstmsAnrBlVO.java
*@FileTitle : AncsCstmsAnrBlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.07.14 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.syscommon.common.table.BkgCstmsAnrBlVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AncsCstmsAnrBlVO extends BkgCstmsAnrBlVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsCstmsAnrBlVO> models = new ArrayList<AncsCstmsAnrBlVO>();
	
	/* Column Info */
	private String refSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String anrMsgStsCd = null;
	/* Column Info */
	private String msgTpCd = null;
	/* Column Info */
	private String anrDeclNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	
	private String rcv = null;

	private String sndSts = null;
	
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AncsCstmsAnrBlVO() {}

	public AncsCstmsAnrBlVO(String ibflag, String pagerows, String anrMsgStsCd, String updUsrId, String anrDeclNo, String msgTpCd, String refSeq, String rcv, String sndSts) {
		this.refSeq = refSeq;
		this.ibflag = ibflag;
		this.anrMsgStsCd = anrMsgStsCd;
		this.msgTpCd = msgTpCd;
		this.anrDeclNo = anrDeclNo;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
		this.rcv = rcv;
		this.sndSts = sndSts;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ref_seq", getRefSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("anr_msg_sts_cd", getAnrMsgStsCd());
		this.hashColumns.put("msg_tp_cd", getMsgTpCd());
		this.hashColumns.put("anr_decl_no", getAnrDeclNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rcv", getRcv());
		this.hashColumns.put("sndSts", getSndSts());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ref_seq", "refSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("anr_msg_sts_cd", "anrMsgStsCd");
		this.hashFields.put("msg_tp_cd", "msgTpCd");
		this.hashFields.put("anr_decl_no", "anrDeclNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rcv", "rcv");
		this.hashFields.put("rcv", "rcv");
		this.hashFields.put("sndSts", "sndSts");
		return this.hashFields;
	}
	
	
	
	public String getSndSts() {
		return sndSts;
	}

	public void setSndSts(String sndSts) {
		this.sndSts = sndSts;
	}

	public String getRcv() {
		return rcv;
	}

	public void setRcv(String rcv) {
		this.rcv = rcv;
	}

	/**
	 * Column Info
	 * @return refSeq
	 */
	public String getRefSeq() {
		return this.refSeq;
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
	 * @return anrMsgStsCd
	 */
	public String getAnrMsgStsCd() {
		return this.anrMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @return msgTpCd
	 */
	public String getMsgTpCd() {
		return this.msgTpCd;
	}
	
	/**
	 * Column Info
	 * @return anrDeclNo
	 */
	public String getAnrDeclNo() {
		return this.anrDeclNo;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
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
	 * @param anrMsgStsCd
	 */
	public void setAnrMsgStsCd(String anrMsgStsCd) {
		this.anrMsgStsCd = anrMsgStsCd;
	}
	
	/**
	 * Column Info
	 * @param msgTpCd
	 */
	public void setMsgTpCd(String msgTpCd) {
		this.msgTpCd = msgTpCd;
	}
	
	/**
	 * Column Info
	 * @param anrDeclNo
	 */
	public void setAnrDeclNo(String anrDeclNo) {
		this.anrDeclNo = anrDeclNo;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setRefSeq(JSPUtil.getParameter(request, "ref_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAnrMsgStsCd(JSPUtil.getParameter(request, "anr_msg_sts_cd", ""));
		setMsgTpCd(JSPUtil.getParameter(request, "msg_tp_cd", ""));
		setAnrDeclNo(JSPUtil.getParameter(request, "anr_decl_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRcv(JSPUtil.getParameter(request, "rcv", ""));
		setSndSts(JSPUtil.getParameter(request, "sndSts", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsAnrBlVO[]
	 */
	public AncsCstmsAnrBlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsAnrBlVO[]
	 */
	public AncsCstmsAnrBlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsCstmsAnrBlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] refSeq = (JSPUtil.getParameter(request, prefix	+ "ref_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] anrMsgStsCd = (JSPUtil.getParameter(request, prefix	+ "anr_msg_sts_cd", length));
			String[] msgTpCd = (JSPUtil.getParameter(request, prefix	+ "msg_tp_cd", length));
			String[] anrDeclNo = (JSPUtil.getParameter(request, prefix	+ "anr_decl_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rcv = (JSPUtil.getParameter(request, prefix	+ "rcv", length));
			String[] sndSts = (JSPUtil.getParameter(request, prefix	+ "sndSts", length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsCstmsAnrBlVO();
				if (refSeq[i] != null)
					model.setRefSeq(refSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (anrMsgStsCd[i] != null)
					model.setAnrMsgStsCd(anrMsgStsCd[i]);
				if (msgTpCd[i] != null)
					model.setMsgTpCd(msgTpCd[i]);
				if (anrDeclNo[i] != null)
					model.setAnrDeclNo(anrDeclNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rcv[i] != null)
					model.setRcv(rcv[i]);
				if (sndSts[i] != null)
					model.setSndSts(sndSts[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsAnrBlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsAnrBlVO[]
	 */
	public AncsCstmsAnrBlVO[] getAncsCstmsAnrBlVOs(){
		AncsCstmsAnrBlVO[] vos = (AncsCstmsAnrBlVO[])models.toArray(new AncsCstmsAnrBlVO[models.size()]);
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
		this.refSeq = this.refSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrMsgStsCd = this.anrMsgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgTpCd = this.msgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anrDeclNo = this.anrDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcv = this.rcv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndSts = this.sndSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
