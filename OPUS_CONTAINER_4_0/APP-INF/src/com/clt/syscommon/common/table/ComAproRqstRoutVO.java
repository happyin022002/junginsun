/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComAproRqstRoutVO.java
*@FileTitle : ComAproRqstRoutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.10 함대성 
* 1.0 Creation
=========================================================*/

package com.clt.syscommon.common.table;

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
 * @author 함대성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComAproRqstRoutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComAproRqstRoutVO> models = new ArrayList<ComAproRqstRoutVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String aproUsrJbTitNm = null;
	/* Column Info */
	private String aproRmk = null;
	/* Column Info */
	private String aproRqstSeq = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String aproOfcNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aproRqstNo = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String apstsCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComAproRqstRoutVO() {}

	public ComAproRqstRoutVO(String ibflag, String pagerows, String aproRqstNo, String aproRqstSeq, String aproUsrId, String aproUsrNm, String aproOfcCd, String aproOfcNm, String aproUsrJbTitNm, String aproDt, String apstsCd, String aproRmk, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.aproUsrJbTitNm = aproUsrJbTitNm;
		this.aproRmk = aproRmk;
		this.aproRqstSeq = aproRqstSeq;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.aproUsrNm = aproUsrNm;
		this.aproOfcCd = aproOfcCd;
		this.aproDt = aproDt;
		this.aproOfcNm = aproOfcNm;
		this.pagerows = pagerows;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.aproRqstNo = aproRqstNo;
		this.aproUsrId = aproUsrId;
		this.apstsCd = apstsCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("apro_usr_jb_tit_nm", getAproUsrJbTitNm());
		this.hashColumns.put("apro_rmk", getAproRmk());
		this.hashColumns.put("apro_rqst_seq", getAproRqstSeq());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("apro_ofc_nm", getAproOfcNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("apro_rqst_no", getAproRqstNo());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("apsts_cd", getApstsCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("apro_usr_jb_tit_nm", "aproUsrJbTitNm");
		this.hashFields.put("apro_rmk", "aproRmk");
		this.hashFields.put("apro_rqst_seq", "aproRqstSeq");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("apro_ofc_nm", "aproOfcNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("apro_rqst_no", "aproRqstNo");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("apsts_cd", "apstsCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
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
	 * @return aproUsrJbTitNm
	 */
	public String getAproUsrJbTitNm() {
		return this.aproUsrJbTitNm;
	}
	
	/**
	 * Column Info
	 * @return aproRmk
	 */
	public String getAproRmk() {
		return this.aproRmk;
	}
	
	/**
	 * Column Info
	 * @return aproRqstSeq
	 */
	public String getAproRqstSeq() {
		return this.aproRqstSeq;
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
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}
	
	/**
	 * Column Info
	 * @return aproOfcNm
	 */
	public String getAproOfcNm() {
		return this.aproOfcNm;
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
	 * @return aproRqstNo
	 */
	public String getAproRqstNo() {
		return this.aproRqstNo;
	}
	
	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return apstsCd
	 */
	public String getApstsCd() {
		return this.apstsCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param aproUsrJbTitNm
	 */
	public void setAproUsrJbTitNm(String aproUsrJbTitNm) {
		this.aproUsrJbTitNm = aproUsrJbTitNm;
	}
	
	/**
	 * Column Info
	 * @param aproRmk
	 */
	public void setAproRmk(String aproRmk) {
		this.aproRmk = aproRmk;
	}
	
	/**
	 * Column Info
	 * @param aproRqstSeq
	 */
	public void setAproRqstSeq(String aproRqstSeq) {
		this.aproRqstSeq = aproRqstSeq;
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
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}
	
	/**
	 * Column Info
	 * @param aproOfcNm
	 */
	public void setAproOfcNm(String aproOfcNm) {
		this.aproOfcNm = aproOfcNm;
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
	 * @param aproRqstNo
	 */
	public void setAproRqstNo(String aproRqstNo) {
		this.aproRqstNo = aproRqstNo;
	}
	
	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param apstsCd
	 */
	public void setApstsCd(String apstsCd) {
		this.apstsCd = apstsCd;
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
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setAproUsrJbTitNm(JSPUtil.getParameter(request, "apro_usr_jb_tit_nm", ""));
		setAproRmk(JSPUtil.getParameter(request, "apro_rmk", ""));
		setAproRqstSeq(JSPUtil.getParameter(request, "apro_rqst_seq", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAproUsrNm(JSPUtil.getParameter(request, "apro_usr_nm", ""));
		setAproOfcCd(JSPUtil.getParameter(request, "apro_ofc_cd", ""));
		setAproDt(JSPUtil.getParameter(request, "apro_dt", ""));
		setAproOfcNm(JSPUtil.getParameter(request, "apro_ofc_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAproRqstNo(JSPUtil.getParameter(request, "apro_rqst_no", ""));
		setAproUsrId(JSPUtil.getParameter(request, "apro_usr_id", ""));
		setApstsCd(JSPUtil.getParameter(request, "apsts_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComAproRqstRoutVO[]
	 */
	public ComAproRqstRoutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComAproRqstRoutVO[]
	 */
	public ComAproRqstRoutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComAproRqstRoutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] aproUsrJbTitNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_jb_tit_nm", length));
			String[] aproRmk = (JSPUtil.getParameter(request, prefix	+ "apro_rmk", length));
			String[] aproRqstSeq = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_seq", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] aproOfcNm = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aproRqstNo = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_no", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] apstsCd = (JSPUtil.getParameter(request, prefix	+ "apsts_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComAproRqstRoutVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (aproUsrJbTitNm[i] != null)
					model.setAproUsrJbTitNm(aproUsrJbTitNm[i]);
				if (aproRmk[i] != null)
					model.setAproRmk(aproRmk[i]);
				if (aproRqstSeq[i] != null)
					model.setAproRqstSeq(aproRqstSeq[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (aproOfcNm[i] != null)
					model.setAproOfcNm(aproOfcNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aproRqstNo[i] != null)
					model.setAproRqstNo(aproRqstNo[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (apstsCd[i] != null)
					model.setApstsCd(apstsCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComAproRqstRoutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComAproRqstRoutVO[]
	 */
	public ComAproRqstRoutVO[] getComAproRqstRoutVOs(){
		ComAproRqstRoutVO[] vos = (ComAproRqstRoutVO[])models.toArray(new ComAproRqstRoutVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrJbTitNm = this.aproUsrJbTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRmk = this.aproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstSeq = this.aproRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcNm = this.aproOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstNo = this.aproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apstsCd = this.apstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
