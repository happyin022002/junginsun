/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaHistoryInfoVO.java
*@FileTitle : UsaHistoryInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.10.22 김도완 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo;

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
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaHistoryInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaHistoryInfoVO> models = new ArrayList<UsaHistoryInfoVO>();
	
	/* Column Info */
	private String hisTpId = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String preCtnt = null;
	/* Column Info */
	private String crntCtnt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hisItmCtnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaHistoryInfoVO() {}

	public UsaHistoryInfoVO(String ibflag, String pagerows, String cntCd, String blNo, String hisSeq, String creUsrId, String updUsrId, String hisTpId, String hisItmCtnt, String preCtnt, String crntCtnt) {
		this.hisTpId = hisTpId;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.cntCd = cntCd;
		this.hisSeq = hisSeq;
		this.preCtnt = preCtnt;
		this.crntCtnt = crntCtnt;
		this.blNo = blNo;
		this.updUsrId = updUsrId;
		this.hisItmCtnt = hisItmCtnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("his_tp_id", getHisTpId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("pre_ctnt", getPreCtnt());
		this.hashColumns.put("crnt_ctnt", getCrntCtnt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("his_itm_ctnt", getHisItmCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("his_tp_id", "hisTpId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("pre_ctnt", "preCtnt");
		this.hashFields.put("crnt_ctnt", "crntCtnt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("his_itm_ctnt", "hisItmCtnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hisTpId
	 */
	public String getHisTpId() {
		return this.hisTpId;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
	}
	
	/**
	 * Column Info
	 * @return preCtnt
	 */
	public String getPreCtnt() {
		return this.preCtnt;
	}
	
	/**
	 * Column Info
	 * @return crntCtnt
	 */
	public String getCrntCtnt() {
		return this.crntCtnt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return hisItmCtnt
	 */
	public String getHisItmCtnt() {
		return this.hisItmCtnt;
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
	 * @param hisTpId
	 */
	public void setHisTpId(String hisTpId) {
		this.hisTpId = hisTpId;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
	}
	
	/**
	 * Column Info
	 * @param preCtnt
	 */
	public void setPreCtnt(String preCtnt) {
		this.preCtnt = preCtnt;
	}
	
	/**
	 * Column Info
	 * @param crntCtnt
	 */
	public void setCrntCtnt(String crntCtnt) {
		this.crntCtnt = crntCtnt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param hisItmCtnt
	 */
	public void setHisItmCtnt(String hisItmCtnt) {
		this.hisItmCtnt = hisItmCtnt;
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
		setHisTpId(JSPUtil.getParameter(request, "his_tp_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setHisSeq(JSPUtil.getParameter(request, "his_seq", ""));
		setPreCtnt(JSPUtil.getParameter(request, "pre_ctnt", ""));
		setCrntCtnt(JSPUtil.getParameter(request, "crnt_ctnt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setHisItmCtnt(JSPUtil.getParameter(request, "his_itm_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaHistoryInfoVO[]
	 */
	public UsaHistoryInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaHistoryInfoVO[]
	 */
	public UsaHistoryInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaHistoryInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hisTpId = (JSPUtil.getParameter(request, prefix	+ "his_tp_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] preCtnt = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt", length));
			String[] crntCtnt = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hisItmCtnt = (JSPUtil.getParameter(request, prefix	+ "his_itm_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaHistoryInfoVO();
				if (hisTpId[i] != null)
					model.setHisTpId(hisTpId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (preCtnt[i] != null)
					model.setPreCtnt(preCtnt[i]);
				if (crntCtnt[i] != null)
					model.setCrntCtnt(crntCtnt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hisItmCtnt[i] != null)
					model.setHisItmCtnt(hisItmCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaHistoryInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaHistoryInfoVO[]
	 */
	public UsaHistoryInfoVO[] getUsaHistoryInfoVOs(){
		UsaHistoryInfoVO[] vos = (UsaHistoryInfoVO[])models.toArray(new UsaHistoryInfoVO[models.size()]);
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
		this.hisTpId = this.hisTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt = this.preCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt = this.crntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisItmCtnt = this.hisItmCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
