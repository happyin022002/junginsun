/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaBlHistoryVO.java
*@FileTitle : UsaBlHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.02 이수빈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

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
 * @author 이수빈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaBlHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaBlHistoryVO> models = new ArrayList<UsaBlHistoryVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String crntCtnt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hisTpId = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String hisSubSeq = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String rnum = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String preCtnt = null;
	/* Column Info */
	private String hisItmCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaBlHistoryVO() {}

	public UsaBlHistoryVO(String ibflag, String pagerows, String hisTpId, String hisSeq, String hisSubSeq, String hisItmCtnt, String preCtnt, String crntCtnt, String usrNm, String ofcCd, String creDt, String creUsrId, String rnum, String total) {
		this.total = total;
		this.creDt = creDt;
		this.crntCtnt = crntCtnt;
		this.pagerows = pagerows;
		this.hisTpId = hisTpId;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.hisSubSeq = hisSubSeq;
		this.usrNm = usrNm;
		this.rnum = rnum;
		this.hisSeq = hisSeq;
		this.preCtnt = preCtnt;
		this.hisItmCtnt = hisItmCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("crnt_ctnt", getCrntCtnt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("his_tp_id", getHisTpId());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("his_sub_seq", getHisSubSeq());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("rnum", getRnum());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("pre_ctnt", getPreCtnt());
		this.hashColumns.put("his_itm_ctnt", getHisItmCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("crnt_ctnt", "crntCtnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("his_tp_id", "hisTpId");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("his_sub_seq", "hisSubSeq");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("rnum", "rnum");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("pre_ctnt", "preCtnt");
		this.hashFields.put("his_itm_ctnt", "hisItmCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
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
	 * @return crntCtnt
	 */
	public String getCrntCtnt() {
		return this.crntCtnt;
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
	 * @return hisTpId
	 */
	public String getHisTpId() {
		return this.hisTpId;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return hisSubSeq
	 */
	public String getHisSubSeq() {
		return this.hisSubSeq;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return rnum
	 */
	public String getRnum() {
		return this.rnum;
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
	 * @return hisItmCtnt
	 */
	public String getHisItmCtnt() {
		return this.hisItmCtnt;
	}
	

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
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
	 * @param crntCtnt
	 */
	public void setCrntCtnt(String crntCtnt) {
		this.crntCtnt = crntCtnt;
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
	 * @param hisTpId
	 */
	public void setHisTpId(String hisTpId) {
		this.hisTpId = hisTpId;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param hisSubSeq
	 */
	public void setHisSubSeq(String hisSubSeq) {
		this.hisSubSeq = hisSubSeq;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param rnum
	 */
	public void setRnum(String rnum) {
		this.rnum = rnum;
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
	 * @param hisItmCtnt
	 */
	public void setHisItmCtnt(String hisItmCtnt) {
		this.hisItmCtnt = hisItmCtnt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCrntCtnt(JSPUtil.getParameter(request, "crnt_ctnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setHisTpId(JSPUtil.getParameter(request, "his_tp_id", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setHisSubSeq(JSPUtil.getParameter(request, "his_sub_seq", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setRnum(JSPUtil.getParameter(request, "rnum", ""));
		setHisSeq(JSPUtil.getParameter(request, "his_seq", ""));
		setPreCtnt(JSPUtil.getParameter(request, "pre_ctnt", ""));
		setHisItmCtnt(JSPUtil.getParameter(request, "his_itm_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaBlHistoryVO[]
	 */
	public UsaBlHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaBlHistoryVO[]
	 */
	public UsaBlHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaBlHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] crntCtnt = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hisTpId = (JSPUtil.getParameter(request, prefix	+ "his_tp_id", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] hisSubSeq = (JSPUtil.getParameter(request, prefix	+ "his_sub_seq", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] rnum = (JSPUtil.getParameter(request, prefix	+ "rnum", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] preCtnt = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt", length));
			String[] hisItmCtnt = (JSPUtil.getParameter(request, prefix	+ "his_itm_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaBlHistoryVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (crntCtnt[i] != null)
					model.setCrntCtnt(crntCtnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hisTpId[i] != null)
					model.setHisTpId(hisTpId[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (hisSubSeq[i] != null)
					model.setHisSubSeq(hisSubSeq[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (rnum[i] != null)
					model.setRnum(rnum[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (preCtnt[i] != null)
					model.setPreCtnt(preCtnt[i]);
				if (hisItmCtnt[i] != null)
					model.setHisItmCtnt(hisItmCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaBlHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaBlHistoryVO[]
	 */
	public UsaBlHistoryVO[] getUsaBlHistoryVOs(){
		UsaBlHistoryVO[] vos = (UsaBlHistoryVO[])models.toArray(new UsaBlHistoryVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt = this.crntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisTpId = this.hisTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSubSeq = this.hisSubSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnum = this.rnum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt = this.preCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisItmCtnt = this.hisItmCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
