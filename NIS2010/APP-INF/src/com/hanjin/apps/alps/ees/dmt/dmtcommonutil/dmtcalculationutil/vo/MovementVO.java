/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MovementVO.java
*@FileTitle : MovementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.07.07 최성환 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo;

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
 * @author 최성환
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MovementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MovementVO> models = new ArrayList<MovementVO>();
	
	/* Column Info */
	private String cnmsCd = null;
	/* Column Info */
	private String cnmvDtTm = null;
	/* Column Info */
	private String msgCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cnmvCycNo = null;
	/* Column Info */
	private String bhCnmvCycNo = null;
	/* Column Info */
	private String cnmvYy = null;
	/* Column Info */
	private String msgDesc = null;
	/* Column Info */
	private String cnmvSplit = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String fullFlg = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String bkgNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MovementVO() {}

	public MovementVO(String ibflag, String pagerows, String bkgNo, String cnmvYy, String cnmvSeq, String cnmvSplit, String cnmsCd, String orgYdCd, String cnmvDtTm, String fullFlg, String cnmvCycNo, String bhCnmvCycNo, String msgCd, String msgDesc) {
		this.cnmsCd = cnmsCd;
		this.cnmvDtTm = cnmvDtTm;
		this.msgCd = msgCd;
		this.ibflag = ibflag;
		this.cnmvCycNo = cnmvCycNo;
		this.bhCnmvCycNo = bhCnmvCycNo;
		this.cnmvYy = cnmvYy;
		this.msgDesc = msgDesc;
		this.cnmvSplit = cnmvSplit;
		this.cnmvSeq = cnmvSeq;
		this.fullFlg = fullFlg;
		this.orgYdCd = orgYdCd;
		this.pagerows = pagerows;
		this.bkgNo = bkgNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnms_cd", getCnmsCd());
		this.hashColumns.put("cnmv_dt_tm", getCnmvDtTm());
		this.hashColumns.put("msg_cd", getMsgCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnmv_cyc_no", getCnmvCycNo());
		this.hashColumns.put("bh_cnmv_cyc_no", getBhCnmvCycNo());
		this.hashColumns.put("cnmv_yy", getCnmvYy());
		this.hashColumns.put("msg_desc", getMsgDesc());
		this.hashColumns.put("cnmv_split", getCnmvSplit());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("full_flg", getFullFlg());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnms_cd", "cnmsCd");
		this.hashFields.put("cnmv_dt_tm", "cnmvDtTm");
		this.hashFields.put("msg_cd", "msgCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_cyc_no", "cnmvCycNo");
		this.hashFields.put("bh_cnmv_cyc_no", "bhCnmvCycNo");
		this.hashFields.put("cnmv_yy", "cnmvYy");
		this.hashFields.put("msg_desc", "msgDesc");
		this.hashFields.put("cnmv_split", "cnmvSplit");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cnmsCd
	 */
	public String getCnmsCd() {
		return this.cnmsCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvDtTm
	 */
	public String getCnmvDtTm() {
		return this.cnmvDtTm;
	}
	
	/**
	 * Column Info
	 * @return msgCd
	 */
	public String getMsgCd() {
		return this.msgCd;
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
	 * @return cnmvCycNo
	 */
	public String getCnmvCycNo() {
		return this.cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @return bhCnmvCycNo
	 */
	public String getBhCnmvCycNo() {
		return this.bhCnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvYy
	 */
	public String getCnmvYy() {
		return this.cnmvYy;
	}
	
	/**
	 * Column Info
	 * @return msgDesc
	 */
	public String getMsgDesc() {
		return this.msgDesc;
	}
	
	/**
	 * Column Info
	 * @return cnmvSplit
	 */
	public String getCnmvSplit() {
		return this.cnmvSplit;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cnmvSeq
	 */
	public String getCnmvSeq() {
		return this.cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @return fullFlg
	 */
	public String getFullFlg() {
		return this.fullFlg;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
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
	 * @param cnmsCd
	 */
	public void setCnmsCd(String cnmsCd) {
		this.cnmsCd = cnmsCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvDtTm
	 */
	public void setCnmvDtTm(String cnmvDtTm) {
		this.cnmvDtTm = cnmvDtTm;
	}
	
	/**
	 * Column Info
	 * @param msgCd
	 */
	public void setMsgCd(String msgCd) {
		this.msgCd = msgCd;
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
	 * @param cnmvCycNo
	 */
	public void setCnmvCycNo(String cnmvCycNo) {
		this.cnmvCycNo = cnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @param bhCnmvCycNo
	 */
	public void setBhCnmvCycNo(String bhCnmvCycNo) {
		this.bhCnmvCycNo = bhCnmvCycNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvYy
	 */
	public void setCnmvYy(String cnmvYy) {
		this.cnmvYy = cnmvYy;
	}
	
	/**
	 * Column Info
	 * @param msgDesc
	 */
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}
	
	/**
	 * Column Info
	 * @param cnmvSplit
	 */
	public void setCnmvSplit(String cnmvSplit) {
		this.cnmvSplit = cnmvSplit;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @param fullFlg
	 */
	public void setFullFlg(String fullFlg) {
		this.fullFlg = fullFlg;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
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
		setCnmsCd(JSPUtil.getParameter(request, "cnms_cd", ""));
		setCnmvDtTm(JSPUtil.getParameter(request, "cnmv_dt_tm", ""));
		setMsgCd(JSPUtil.getParameter(request, "msg_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCnmvCycNo(JSPUtil.getParameter(request, "cnmv_cyc_no", ""));
		setBhCnmvCycNo(JSPUtil.getParameter(request, "bh_cnmv_cyc_no", ""));
		setCnmvYy(JSPUtil.getParameter(request, "cnmv_yy", ""));
		setMsgDesc(JSPUtil.getParameter(request, "msg_desc", ""));
		setCnmvSplit(JSPUtil.getParameter(request, "cnmv_split", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCnmvSeq(JSPUtil.getParameter(request, "cnmv_seq", ""));
		setFullFlg(JSPUtil.getParameter(request, "full_flg", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MovementVO[]
	 */
	public MovementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MovementVO[]
	 */
	public MovementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MovementVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cnmsCd = (JSPUtil.getParameter(request, prefix	+ "cnms_cd", length));
			String[] cnmvDtTm = (JSPUtil.getParameter(request, prefix	+ "cnmv_dt_tm", length));
			String[] msgCd = (JSPUtil.getParameter(request, prefix	+ "msg_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "cnmv_cyc_no", length));
			String[] bhCnmvCycNo = (JSPUtil.getParameter(request, prefix	+ "bh_cnmv_cyc_no", length));
			String[] cnmvYy = (JSPUtil.getParameter(request, prefix	+ "cnmv_yy", length));
			String[] msgDesc = (JSPUtil.getParameter(request, prefix	+ "msg_desc", length));
			String[] cnmvSplit = (JSPUtil.getParameter(request, prefix	+ "cnmv_split", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] fullFlg = (JSPUtil.getParameter(request, prefix	+ "full_flg", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MovementVO();
				if (cnmsCd[i] != null)
					model.setCnmsCd(cnmsCd[i]);
				if (cnmvDtTm[i] != null)
					model.setCnmvDtTm(cnmvDtTm[i]);
				if (msgCd[i] != null)
					model.setMsgCd(msgCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cnmvCycNo[i] != null)
					model.setCnmvCycNo(cnmvCycNo[i]);
				if (bhCnmvCycNo[i] != null)
					model.setBhCnmvCycNo(bhCnmvCycNo[i]);
				if (cnmvYy[i] != null)
					model.setCnmvYy(cnmvYy[i]);
				if (msgDesc[i] != null)
					model.setMsgDesc(msgDesc[i]);
				if (cnmvSplit[i] != null)
					model.setCnmvSplit(cnmvSplit[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (fullFlg[i] != null)
					model.setFullFlg(fullFlg[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMovementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MovementVO[]
	 */
	public MovementVO[] getMovementVOs(){
		MovementVO[] vos = (MovementVO[])models.toArray(new MovementVO[models.size()]);
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
		this.cnmsCd = this.cnmsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDtTm = this.cnmvDtTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgCd = this.msgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvCycNo = this.cnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bhCnmvCycNo = this.bhCnmvCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYy = this.cnmvYy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgDesc = this.msgDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSplit = this.cnmvSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg = this.fullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
