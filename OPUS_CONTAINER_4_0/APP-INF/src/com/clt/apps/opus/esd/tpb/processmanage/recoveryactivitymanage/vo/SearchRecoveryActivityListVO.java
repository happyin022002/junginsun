/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchRecoveryActivityListVO.java
*@FileTitle : SearchRecoveryActivityListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-28
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2009-09-28 Jong-Geon Byeon	1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 변종건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchRecoveryActivityListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchRecoveryActivityListVO> models = new ArrayList<SearchRecoveryActivityListVO>();
	
	/* Column Info */
	private String userOfcCd = null;
	/* Column Info */
	private String cltActUpdOfcCd = null;
	/* Column Info */
	private String sN3ptyNo = null;
	/* Column Info */
	private String n3ptyNoY = null;
	/* Column Info */
	private String otsGrpRcvrActSeq = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String fileCount = null;
	/* Column Info */
	private String n3ptyInvNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sortNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String n3ptyNoN = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String imgFileNo = null;
	/* Column Info */
	private String fileNo = null;
	/* Column Info */
	private String actRmk = null;
	/* Column Info */
	private String n3ptyCltRmkTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchRecoveryActivityListVO() {}

	public SearchRecoveryActivityListVO(String ibflag, String pagerows, String sortNo, String n3ptyNo, String otsGrpRcvrActSeq, String actRmk, String loclCreDt, String cltActUpdOfcCd, String updUsrId, String cntcPsonNm, String n3ptyNoY, String n3ptyNoN, String imgFileNo, String fileNo, String n3ptyInvNo, String n3ptyCltRmkTpCd, String fileCount, String userOfcCd, String sN3ptyNo, String creUsrId) {
		this.userOfcCd = userOfcCd;
		this.cltActUpdOfcCd = cltActUpdOfcCd;
		this.sN3ptyNo = sN3ptyNo;
		this.n3ptyNoY = n3ptyNoY;
		this.otsGrpRcvrActSeq = otsGrpRcvrActSeq;
		this.loclCreDt = loclCreDt;
		this.fileCount = fileCount;
		this.n3ptyInvNo = n3ptyInvNo;
		this.pagerows = pagerows;
		this.sortNo = sortNo;
		this.ibflag = ibflag;
		this.n3ptyNoN = n3ptyNoN;
		this.n3ptyNo = n3ptyNo;
		this.cntcPsonNm = cntcPsonNm;
		this.imgFileNo = imgFileNo;
		this.fileNo = fileNo;
		this.actRmk = actRmk;
		this.n3ptyCltRmkTpCd = n3ptyCltRmkTpCd;
		this.updUsrId = updUsrId;
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());
		this.hashColumns.put("clt_act_upd_ofc_cd", getCltActUpdOfcCd());
		this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
		this.hashColumns.put("n3pty_no_y", getN3ptyNoY());
		this.hashColumns.put("ots_grp_rcvr_act_seq", getOtsGrpRcvrActSeq());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("file_count", getFileCount());
		this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sortNo", getSortNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n3pty_no_n", getN3ptyNoN());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("img_file_no", getImgFileNo());
		this.hashColumns.put("file_no", getFileNo());
		this.hashColumns.put("act_rmk", getActRmk());
		this.hashColumns.put("n3pty_clt_rmk_tp_cd", getN3ptyCltRmkTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("clt_act_upd_ofc_cd", "cltActUpdOfcCd");
		this.hashFields.put("s_n3pty_no", "sN3ptyNo");
		this.hashFields.put("n3pty_no_y", "n3ptyNoY");
		this.hashFields.put("ots_grp_rcvr_act_seq", "otsGrpRcvrActSeq");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("file_count", "fileCount");
		this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sortNo", "sortNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n3pty_no_n", "n3ptyNoN");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("img_file_no", "imgFileNo");
		this.hashFields.put("file_no", "fileNo");
		this.hashFields.put("act_rmk", "actRmk");
		this.hashFields.put("n3pty_clt_rmk_tp_cd", "n3ptyCltRmkTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return userOfcCd
	 */
	public String getUserOfcCd() {
		return this.userOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cltActUpdOfcCd
	 */
	public String getCltActUpdOfcCd() {
		return this.cltActUpdOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyNo
	 */
	public String getSN3ptyNo() {
		return this.sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNoY
	 */
	public String getN3ptyNoY() {
		return this.n3ptyNoY;
	}
	
	/**
	 * Column Info
	 * @return otsGrpRcvrActSeq
	 */
	public String getOtsGrpRcvrActSeq() {
		return this.otsGrpRcvrActSeq;
	}
	
	/**
	 * Column Info
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
	}
	
	/**
	 * Column Info
	 * @return fileCount
	 */
	public String getFileCount() {
		return this.fileCount;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvNo
	 */
	public String getN3ptyInvNo() {
		return this.n3ptyInvNo;
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
	 * @return sortNo
	 */
	public String getSortNo() {
		return this.sortNo;
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
	 * @return n3ptyNoN
	 */
	public String getN3ptyNoN() {
		return this.n3ptyNoN;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return imgFileNo
	 */
	public String getImgFileNo() {
		return this.imgFileNo;
	}
	
	/**
	 * Column Info
	 * @return fileNo
	 */
	public String getFileNo() {
		return this.fileNo;
	}
	
	/**
	 * Column Info
	 * @return actRmk
	 */
	public String getActRmk() {
		return this.actRmk;
	}
	
	/**
	 * Column Info
	 * @return n3ptyCltRmkTpCd
	 */
	public String getN3ptyCltRmkTpCd() {
		return this.n3ptyCltRmkTpCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
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
	 * @param userOfcCd
	 */
	public void setUserOfcCd(String userOfcCd) {
		this.userOfcCd = userOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cltActUpdOfcCd
	 */
	public void setCltActUpdOfcCd(String cltActUpdOfcCd) {
		this.cltActUpdOfcCd = cltActUpdOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyNo
	 */
	public void setSN3ptyNo(String sN3ptyNo) {
		this.sN3ptyNo = sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNoY
	 */
	public void setN3ptyNoY(String n3ptyNoY) {
		this.n3ptyNoY = n3ptyNoY;
	}
	
	/**
	 * Column Info
	 * @param otsGrpRcvrActSeq
	 */
	public void setOtsGrpRcvrActSeq(String otsGrpRcvrActSeq) {
		this.otsGrpRcvrActSeq = otsGrpRcvrActSeq;
	}
	
	/**
	 * Column Info
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
	}
	
	/**
	 * Column Info
	 * @param fileCount
	 */
	public void setFileCount(String fileCount) {
		this.fileCount = fileCount;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvNo
	 */
	public void setN3ptyInvNo(String n3ptyInvNo) {
		this.n3ptyInvNo = n3ptyInvNo;
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
	 * @param sortNo
	 */
	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
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
	 * @param n3ptyNoN
	 */
	public void setN3ptyNoN(String n3ptyNoN) {
		this.n3ptyNoN = n3ptyNoN;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param imgFileNo
	 */
	public void setImgFileNo(String imgFileNo) {
		this.imgFileNo = imgFileNo;
	}
	
	/**
	 * Column Info
	 * @param fileNo
	 */
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	
	/**
	 * Column Info
	 * @param actRmk
	 */
	public void setActRmk(String actRmk) {
		this.actRmk = actRmk;
	}
	
	/**
	 * Column Info
	 * @param n3ptyCltRmkTpCd
	 */
	public void setN3ptyCltRmkTpCd(String n3ptyCltRmkTpCd) {
		this.n3ptyCltRmkTpCd = n3ptyCltRmkTpCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUserOfcCd(JSPUtil.getParameter(request, "user_ofc_cd", ""));
		setCltActUpdOfcCd(JSPUtil.getParameter(request, "clt_act_upd_ofc_cd", ""));
		setSN3ptyNo(JSPUtil.getParameter(request, "s_n3pty_no", ""));
		setN3ptyNoY(JSPUtil.getParameter(request, "n3pty_no_y", ""));
		setOtsGrpRcvrActSeq(JSPUtil.getParameter(request, "ots_grp_rcvr_act_seq", ""));
		setLoclCreDt(JSPUtil.getParameter(request, "locl_cre_dt", ""));
		setFileCount(JSPUtil.getParameter(request, "file_count", ""));
		setN3ptyInvNo(JSPUtil.getParameter(request, "n3pty_inv_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSortNo(JSPUtil.getParameter(request, "sortNo", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setN3ptyNoN(JSPUtil.getParameter(request, "n3pty_no_n", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, "cntc_pson_nm", ""));
		setImgFileNo(JSPUtil.getParameter(request, "img_file_no", ""));
		setFileNo(JSPUtil.getParameter(request, "file_no", ""));
		setActRmk(JSPUtil.getParameter(request, "act_rmk", ""));
		setN3ptyCltRmkTpCd(JSPUtil.getParameter(request, "n3pty_clt_rmk_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchRecoveryActivityListVO[]
	 */
	public SearchRecoveryActivityListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchRecoveryActivityListVO[]
	 */
	public SearchRecoveryActivityListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchRecoveryActivityListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] userOfcCd = (JSPUtil.getParameter(request, prefix	+ "user_ofc_cd", length));
			String[] cltActUpdOfcCd = (JSPUtil.getParameter(request, prefix	+ "clt_act_upd_ofc_cd", length));
			String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no", length));
			String[] n3ptyNoY = (JSPUtil.getParameter(request, prefix	+ "n3pty_no_y", length));
			String[] otsGrpRcvrActSeq = (JSPUtil.getParameter(request, prefix	+ "ots_grp_rcvr_act_seq", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] fileCount = (JSPUtil.getParameter(request, prefix	+ "file_count", length));
			String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sortNo = (JSPUtil.getParameter(request, prefix	+ "sortNo", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] n3ptyNoN = (JSPUtil.getParameter(request, prefix	+ "n3pty_no_n", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] imgFileNo = (JSPUtil.getParameter(request, prefix	+ "img_file_no", length));
			String[] fileNo = (JSPUtil.getParameter(request, prefix	+ "file_no", length));
			String[] actRmk = (JSPUtil.getParameter(request, prefix	+ "act_rmk", length));
			String[] n3ptyCltRmkTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_clt_rmk_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchRecoveryActivityListVO();
				if (userOfcCd[i] != null)
					model.setUserOfcCd(userOfcCd[i]);
				if (cltActUpdOfcCd[i] != null)
					model.setCltActUpdOfcCd(cltActUpdOfcCd[i]);
				if (sN3ptyNo[i] != null)
					model.setSN3ptyNo(sN3ptyNo[i]);
				if (n3ptyNoY[i] != null)
					model.setN3ptyNoY(n3ptyNoY[i]);
				if (otsGrpRcvrActSeq[i] != null)
					model.setOtsGrpRcvrActSeq(otsGrpRcvrActSeq[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (fileCount[i] != null)
					model.setFileCount(fileCount[i]);
				if (n3ptyInvNo[i] != null)
					model.setN3ptyInvNo(n3ptyInvNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sortNo[i] != null)
					model.setSortNo(sortNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (n3ptyNoN[i] != null)
					model.setN3ptyNoN(n3ptyNoN[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (imgFileNo[i] != null)
					model.setImgFileNo(imgFileNo[i]);
				if (fileNo[i] != null)
					model.setFileNo(fileNo[i]);
				if (actRmk[i] != null)
					model.setActRmk(actRmk[i]);
				if (n3ptyCltRmkTpCd[i] != null)
					model.setN3ptyCltRmkTpCd(n3ptyCltRmkTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchRecoveryActivityListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchRecoveryActivityListVO[]
	 */
	public SearchRecoveryActivityListVO[] getSearchRecoveryActivityListVOs(){
		SearchRecoveryActivityListVO[] vos = (SearchRecoveryActivityListVO[])models.toArray(new SearchRecoveryActivityListVO[models.size()]);
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
		this.userOfcCd = this.userOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltActUpdOfcCd = this.cltActUpdOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNo = this.sN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNoY = this.n3ptyNoY .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsGrpRcvrActSeq = this.otsGrpRcvrActSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileCount = this.fileCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNo = this.n3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sortNo = this.sortNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNoN = this.n3ptyNoN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFileNo = this.imgFileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNo = this.fileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRmk = this.actRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyCltRmkTpCd = this.n3ptyCltRmkTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
