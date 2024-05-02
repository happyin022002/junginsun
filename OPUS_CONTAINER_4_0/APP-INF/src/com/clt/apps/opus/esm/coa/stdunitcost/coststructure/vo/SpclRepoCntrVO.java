/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpclRepoCntrVO.java
*@FileTitle : SpclRepoCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 박은주
*@LastVersion : 1.0
* 2009.07.13 박은주 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo;

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
 * @author 박은주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpclRepoCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpclRepoCntrVO> models = new ArrayList<SpclRepoCntrVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String spclCntrTpszCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String repoFlg = null;
	/* Column Info */
	private String listBxDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpclRepoCntrVO() {}

	public SpclRepoCntrVO(String pagerows, String deltFlg, String ibflag, String seq, String cntrTpszCd, String spclCntrTpszCd, String repoFlg, String listBxDesc, String creUsrId, String updUsrId) {
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.deltFlg = deltFlg;
		this.spclCntrTpszCd = spclCntrTpszCd;
		this.cntrTpszCd = cntrTpszCd;
		this.seq = seq;
		this.repoFlg = repoFlg;
		this.listBxDesc = listBxDesc;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("spcl_cntr_tpsz_cd", getSpclCntrTpszCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("repo_flg", getRepoFlg());
		this.hashColumns.put("list_bx_desc", getListBxDesc());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("spcl_cntr_tpsz_cd", "spclCntrTpszCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("repo_flg", "repoFlg");
		this.hashFields.put("list_bx_desc", "listBxDesc");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return spclCntrTpszCd
	 */
	public String getSpclCntrTpszCd() {
		return this.spclCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return repoFlg
	 */
	public String getRepoFlg() {
		return this.repoFlg;
	}
	
	/**
	 * Column Info
	 * @return listBxDesc
	 */
	public String getListBxDesc() {
		return this.listBxDesc;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param spclCntrTpszCd
	 */
	public void setSpclCntrTpszCd(String spclCntrTpszCd) {
		this.spclCntrTpszCd = spclCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param repoFlg
	 */
	public void setRepoFlg(String repoFlg) {
		this.repoFlg = repoFlg;
	}
	
	/**
	 * Column Info
	 * @param listBxDesc
	 */
	public void setListBxDesc(String listBxDesc) {
		this.listBxDesc = listBxDesc;
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
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setSpclCntrTpszCd(JSPUtil.getParameter(request, "spcl_cntr_tpsz_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setRepoFlg(JSPUtil.getParameter(request, "repo_flg", ""));
		setListBxDesc(JSPUtil.getParameter(request, "list_bx_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpclRepoCntrVO[]
	 */
	public SpclRepoCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpclRepoCntrVO[]
	 */
	public SpclRepoCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpclRepoCntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] spclCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cntr_tpsz_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] repoFlg = (JSPUtil.getParameter(request, prefix	+ "repo_flg", length));
			String[] listBxDesc = (JSPUtil.getParameter(request, prefix	+ "list_bx_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpclRepoCntrVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (spclCntrTpszCd[i] != null)
					model.setSpclCntrTpszCd(spclCntrTpszCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (repoFlg[i] != null)
					model.setRepoFlg(repoFlg[i]);
				if (listBxDesc[i] != null)
					model.setListBxDesc(listBxDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpclRepoCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpclRepoCntrVO[]
	 */
	public SpclRepoCntrVO[] getSpclRepoCntrVOs(){
		SpclRepoCntrVO[] vos = (SpclRepoCntrVO[])models.toArray(new SpclRepoCntrVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCntrTpszCd = this.spclCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoFlg = this.repoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.listBxDesc = this.listBxDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
