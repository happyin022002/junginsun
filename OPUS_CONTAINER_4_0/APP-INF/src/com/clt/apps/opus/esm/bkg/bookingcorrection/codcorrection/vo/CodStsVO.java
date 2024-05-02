/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodStsVO.java
*@FileTitle : CodStsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.08.19 최영희 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CodStsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CodStsVO> models = new ArrayList<CodStsVO>();
	
	/* Column Info */
	private String oldTVvd = null;
	/* Column Info */
	private String newPor = null;
	/* Column Info */
	private String seqNo = null;
	/* Column Info */
	private String oldPod = null;
	/* Column Info */
	private String newPost = null;
	/* Column Info */
	private String approvalResult = null;
	/* Column Info */
	private String oldPre = null;
	/* Column Info */
	private String newTVvd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String oldDel = null;
	/* Column Info */
	private String oldPol = null;
	/* Column Info */
	private String oldPost = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String codRqstSeq = null;
	/* Column Info */
	private String newPre = null;
	/* Column Info */
	private String newPod = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String oldPor = null;
	/* Column Info */
	private String newPol = null;
	/* Column Info */
	private String newDel = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CodStsVO() {}

	public CodStsVO(String ibflag, String pagerows, String seqNo, String bkgNo, String codRqstSeq, String oldPor, String oldPol, String oldPod, String oldDel, String oldPre, String oldPost, String oldTVvd, String newPor, String newPol, String newPod, String newDel, String newPre, String newPost, String newTVvd, String cntrQty, String approvalResult) {
		this.oldTVvd = oldTVvd;
		this.newPor = newPor;
		this.seqNo = seqNo;
		this.oldPod = oldPod;
		this.newPost = newPost;
		this.approvalResult = approvalResult;
		this.oldPre = oldPre;
		this.newTVvd = newTVvd;
		this.pagerows = pagerows;
		this.oldDel = oldDel;
		this.oldPol = oldPol;
		this.oldPost = oldPost;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.codRqstSeq = codRqstSeq;
		this.newPre = newPre;
		this.newPod = newPod;
		this.cntrQty = cntrQty;
		this.oldPor = oldPor;
		this.newPol = newPol;
		this.newDel = newDel;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("old_t_vvd", getOldTVvd());
		this.hashColumns.put("new_por", getNewPor());
		this.hashColumns.put("seq_no", getSeqNo());
		this.hashColumns.put("old_pod", getOldPod());
		this.hashColumns.put("new_post", getNewPost());
		this.hashColumns.put("approval_result", getApprovalResult());
		this.hashColumns.put("old_pre", getOldPre());
		this.hashColumns.put("new_t_vvd", getNewTVvd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("old_del", getOldDel());
		this.hashColumns.put("old_pol", getOldPol());
		this.hashColumns.put("old_post", getOldPost());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cod_rqst_seq", getCodRqstSeq());
		this.hashColumns.put("new_pre", getNewPre());
		this.hashColumns.put("new_pod", getNewPod());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("old_por", getOldPor());
		this.hashColumns.put("new_pol", getNewPol());
		this.hashColumns.put("new_del", getNewDel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("old_t_vvd", "oldTVvd");
		this.hashFields.put("new_por", "newPor");
		this.hashFields.put("seq_no", "seqNo");
		this.hashFields.put("old_pod", "oldPod");
		this.hashFields.put("new_post", "newPost");
		this.hashFields.put("approval_result", "approvalResult");
		this.hashFields.put("old_pre", "oldPre");
		this.hashFields.put("new_t_vvd", "newTVvd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("old_del", "oldDel");
		this.hashFields.put("old_pol", "oldPol");
		this.hashFields.put("old_post", "oldPost");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cod_rqst_seq", "codRqstSeq");
		this.hashFields.put("new_pre", "newPre");
		this.hashFields.put("new_pod", "newPod");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("old_por", "oldPor");
		this.hashFields.put("new_pol", "newPol");
		this.hashFields.put("new_del", "newDel");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return oldTVvd
	 */
	public String getOldTVvd() {
		return this.oldTVvd;
	}
	
	/**
	 * Column Info
	 * @return newPor
	 */
	public String getNewPor() {
		return this.newPor;
	}
	
	/**
	 * Column Info
	 * @return seqNo
	 */
	public String getSeqNo() {
		return this.seqNo;
	}
	
	/**
	 * Column Info
	 * @return oldPod
	 */
	public String getOldPod() {
		return this.oldPod;
	}
	
	/**
	 * Column Info
	 * @return newPost
	 */
	public String getNewPost() {
		return this.newPost;
	}
	
	/**
	 * Column Info
	 * @return approvalResult
	 */
	public String getApprovalResult() {
		return this.approvalResult;
	}
	
	/**
	 * Column Info
	 * @return oldPre
	 */
	public String getOldPre() {
		return this.oldPre;
	}
	
	/**
	 * Column Info
	 * @return newTVvd
	 */
	public String getNewTVvd() {
		return this.newTVvd;
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
	 * @return oldDel
	 */
	public String getOldDel() {
		return this.oldDel;
	}
	
	/**
	 * Column Info
	 * @return oldPol
	 */
	public String getOldPol() {
		return this.oldPol;
	}
	
	/**
	 * Column Info
	 * @return oldPost
	 */
	public String getOldPost() {
		return this.oldPost;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return codRqstSeq
	 */
	public String getCodRqstSeq() {
		return this.codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return newPre
	 */
	public String getNewPre() {
		return this.newPre;
	}
	
	/**
	 * Column Info
	 * @return newPod
	 */
	public String getNewPod() {
		return this.newPod;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return oldPor
	 */
	public String getOldPor() {
		return this.oldPor;
	}
	
	/**
	 * Column Info
	 * @return newPol
	 */
	public String getNewPol() {
		return this.newPol;
	}
	
	/**
	 * Column Info
	 * @return newDel
	 */
	public String getNewDel() {
		return this.newDel;
	}
	

	/**
	 * Column Info
	 * @param oldTVvd
	 */
	public void setOldTVvd(String oldTVvd) {
		this.oldTVvd = oldTVvd;
	}
	
	/**
	 * Column Info
	 * @param newPor
	 */
	public void setNewPor(String newPor) {
		this.newPor = newPor;
	}
	
	/**
	 * Column Info
	 * @param seqNo
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	
	/**
	 * Column Info
	 * @param oldPod
	 */
	public void setOldPod(String oldPod) {
		this.oldPod = oldPod;
	}
	
	/**
	 * Column Info
	 * @param newPost
	 */
	public void setNewPost(String newPost) {
		this.newPost = newPost;
	}
	
	/**
	 * Column Info
	 * @param approvalResult
	 */
	public void setApprovalResult(String approvalResult) {
		this.approvalResult = approvalResult;
	}
	
	/**
	 * Column Info
	 * @param oldPre
	 */
	public void setOldPre(String oldPre) {
		this.oldPre = oldPre;
	}
	
	/**
	 * Column Info
	 * @param newTVvd
	 */
	public void setNewTVvd(String newTVvd) {
		this.newTVvd = newTVvd;
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
	 * @param oldDel
	 */
	public void setOldDel(String oldDel) {
		this.oldDel = oldDel;
	}
	
	/**
	 * Column Info
	 * @param oldPol
	 */
	public void setOldPol(String oldPol) {
		this.oldPol = oldPol;
	}
	
	/**
	 * Column Info
	 * @param oldPost
	 */
	public void setOldPost(String oldPost) {
		this.oldPost = oldPost;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param codRqstSeq
	 */
	public void setCodRqstSeq(String codRqstSeq) {
		this.codRqstSeq = codRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param newPre
	 */
	public void setNewPre(String newPre) {
		this.newPre = newPre;
	}
	
	/**
	 * Column Info
	 * @param newPod
	 */
	public void setNewPod(String newPod) {
		this.newPod = newPod;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param oldPor
	 */
	public void setOldPor(String oldPor) {
		this.oldPor = oldPor;
	}
	
	/**
	 * Column Info
	 * @param newPol
	 */
	public void setNewPol(String newPol) {
		this.newPol = newPol;
	}
	
	/**
	 * Column Info
	 * @param newDel
	 */
	public void setNewDel(String newDel) {
		this.newDel = newDel;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOldTVvd(JSPUtil.getParameter(request, "old_t_vvd", ""));
		setNewPor(JSPUtil.getParameter(request, "new_por", ""));
		setSeqNo(JSPUtil.getParameter(request, "seq_no", ""));
		setOldPod(JSPUtil.getParameter(request, "old_pod", ""));
		setNewPost(JSPUtil.getParameter(request, "new_post", ""));
		setApprovalResult(JSPUtil.getParameter(request, "approval_result", ""));
		setOldPre(JSPUtil.getParameter(request, "old_pre", ""));
		setNewTVvd(JSPUtil.getParameter(request, "new_t_vvd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setOldDel(JSPUtil.getParameter(request, "old_del", ""));
		setOldPol(JSPUtil.getParameter(request, "old_pol", ""));
		setOldPost(JSPUtil.getParameter(request, "old_post", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCodRqstSeq(JSPUtil.getParameter(request, "cod_rqst_seq", ""));
		setNewPre(JSPUtil.getParameter(request, "new_pre", ""));
		setNewPod(JSPUtil.getParameter(request, "new_pod", ""));
		setCntrQty(JSPUtil.getParameter(request, "cntr_qty", ""));
		setOldPor(JSPUtil.getParameter(request, "old_por", ""));
		setNewPol(JSPUtil.getParameter(request, "new_pol", ""));
		setNewDel(JSPUtil.getParameter(request, "new_del", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CodStsVO[]
	 */
	public CodStsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CodStsVO[]
	 */
	public CodStsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CodStsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] oldTVvd = (JSPUtil.getParameter(request, prefix	+ "old_t_vvd", length));
			String[] newPor = (JSPUtil.getParameter(request, prefix	+ "new_por", length));
			String[] seqNo = (JSPUtil.getParameter(request, prefix	+ "seq_no", length));
			String[] oldPod = (JSPUtil.getParameter(request, prefix	+ "old_pod", length));
			String[] newPost = (JSPUtil.getParameter(request, prefix	+ "new_post", length));
			String[] approvalResult = (JSPUtil.getParameter(request, prefix	+ "approval_result", length));
			String[] oldPre = (JSPUtil.getParameter(request, prefix	+ "old_pre", length));
			String[] newTVvd = (JSPUtil.getParameter(request, prefix	+ "new_t_vvd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] oldDel = (JSPUtil.getParameter(request, prefix	+ "old_del", length));
			String[] oldPol = (JSPUtil.getParameter(request, prefix	+ "old_pol", length));
			String[] oldPost = (JSPUtil.getParameter(request, prefix	+ "old_post", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] codRqstSeq = (JSPUtil.getParameter(request, prefix	+ "cod_rqst_seq", length));
			String[] newPre = (JSPUtil.getParameter(request, prefix	+ "new_pre", length));
			String[] newPod = (JSPUtil.getParameter(request, prefix	+ "new_pod", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] oldPor = (JSPUtil.getParameter(request, prefix	+ "old_por", length));
			String[] newPol = (JSPUtil.getParameter(request, prefix	+ "new_pol", length));
			String[] newDel = (JSPUtil.getParameter(request, prefix	+ "new_del", length));
			
			for (int i = 0; i < length; i++) {
				model = new CodStsVO();
				if (oldTVvd[i] != null)
					model.setOldTVvd(oldTVvd[i]);
				if (newPor[i] != null)
					model.setNewPor(newPor[i]);
				if (seqNo[i] != null)
					model.setSeqNo(seqNo[i]);
				if (oldPod[i] != null)
					model.setOldPod(oldPod[i]);
				if (newPost[i] != null)
					model.setNewPost(newPost[i]);
				if (approvalResult[i] != null)
					model.setApprovalResult(approvalResult[i]);
				if (oldPre[i] != null)
					model.setOldPre(oldPre[i]);
				if (newTVvd[i] != null)
					model.setNewTVvd(newTVvd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (oldDel[i] != null)
					model.setOldDel(oldDel[i]);
				if (oldPol[i] != null)
					model.setOldPol(oldPol[i]);
				if (oldPost[i] != null)
					model.setOldPost(oldPost[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (codRqstSeq[i] != null)
					model.setCodRqstSeq(codRqstSeq[i]);
				if (newPre[i] != null)
					model.setNewPre(newPre[i]);
				if (newPod[i] != null)
					model.setNewPod(newPod[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (oldPor[i] != null)
					model.setOldPor(oldPor[i]);
				if (newPol[i] != null)
					model.setNewPol(newPol[i]);
				if (newDel[i] != null)
					model.setNewDel(newDel[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCodStsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CodStsVO[]
	 */
	public CodStsVO[] getCodStsVOs(){
		CodStsVO[] vos = (CodStsVO[])models.toArray(new CodStsVO[models.size()]);
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
		this.oldTVvd = this.oldTVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPor = this.newPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqNo = this.seqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPod = this.oldPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPost = this.newPost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalResult = this.approvalResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPre = this.oldPre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newTVvd = this.newTVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDel = this.oldDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPol = this.oldPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPost = this.oldPost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstSeq = this.codRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPre = this.newPre .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPod = this.newPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPor = this.oldPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPol = this.newPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newDel = this.newDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
