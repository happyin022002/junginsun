package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;

public class SearchJOInvoiceManageListVO {
	
	private static final long serialVersionUID = 1L;
	
	private Collection<SearchJOInvoiceManageListVO> models = new ArrayList<SearchJOInvoiceManageListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n3ptyCtrlOfcCd = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n3ptyArOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3ptyOfcTpCd = null;
	/* Column Info */
	private String n3ptyOfcCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String sOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchJOInvoiceManageListVO() {}

	public SearchJOInvoiceManageListVO(String ibflag, String pagerows, String n3ptyOfcTpCd, String ofcCd, String sOfcCd, String rhqCd, String n3ptyCtrlOfcCd, String n3ptyOfcCd, String n3ptyArOfcCd, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.n3ptyCtrlOfcCd = n3ptyCtrlOfcCd;
		this.rhqCd = rhqCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.n3ptyArOfcCd = n3ptyArOfcCd;
		this.pagerows = pagerows;
		this.n3ptyOfcTpCd = n3ptyOfcTpCd;
		this.n3ptyOfcCd = n3ptyOfcCd;
		this.ofcCd = ofcCd;
		this.sOfcCd = sOfcCd;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n3pty_ctrl_ofc_cd", getN3ptyCtrlOfcCd());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("n3pty_ar_ofc_cd", getN3ptyArOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3pty_ofc_tp_cd", getN3ptyOfcTpCd());
		this.hashColumns.put("n3pty_ofc_cd", getN3ptyOfcCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n3pty_ctrl_ofc_cd", "n3ptyCtrlOfcCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n3pty_ar_ofc_cd", "n3ptyArOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_ofc_tp_cd", "n3ptyOfcTpCd");
		this.hashFields.put("n3pty_ofc_cd", "n3ptyOfcCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
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
	 * @return n3ptyCtrlOfcCd
	 */
	public String getN3ptyCtrlOfcCd() {
		return this.n3ptyCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
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
	 * @return n3ptyArOfcCd
	 */
	public String getN3ptyArOfcCd() {
		return this.n3ptyArOfcCd;
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
	 * @return n3ptyOfcTpCd
	 */
	public String getN3ptyOfcTpCd() {
		return this.n3ptyOfcTpCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyOfcCd
	 */
	public String getN3ptyOfcCd() {
		return this.n3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
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
	 * @param n3ptyCtrlOfcCd
	 */
	public void setN3ptyCtrlOfcCd(String n3ptyCtrlOfcCd) {
		this.n3ptyCtrlOfcCd = n3ptyCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
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
	 * @param n3ptyArOfcCd
	 */
	public void setN3ptyArOfcCd(String n3ptyArOfcCd) {
		this.n3ptyArOfcCd = n3ptyArOfcCd;
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
	 * @param n3ptyOfcTpCd
	 */
	public void setN3ptyOfcTpCd(String n3ptyOfcTpCd) {
		this.n3ptyOfcTpCd = n3ptyOfcTpCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyOfcCd
	 */
	public void setN3ptyOfcCd(String n3ptyOfcCd) {
		this.n3ptyOfcCd = n3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
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
		setN3ptyCtrlOfcCd(JSPUtil.getParameter(request, "n3pty_ctrl_ofc_cd", ""));
		setRhqCd(JSPUtil.getParameter(request, "rhq_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setN3ptyArOfcCd(JSPUtil.getParameter(request, "n3pty_ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setN3ptyOfcTpCd(JSPUtil.getParameter(request, "n3pty_ofc_tp_cd", ""));
		setN3ptyOfcCd(JSPUtil.getParameter(request, "n3pty_ofc_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setSOfcCd(JSPUtil.getParameter(request, "s_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchJOInvoiceManageListVO[]
	 */
	public SearchJOInvoiceManageListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchJOInvoiceManageListVO[]
	 */
	public SearchJOInvoiceManageListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchJOInvoiceManageListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n3ptyCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ctrl_ofc_cd", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] n3ptyArOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ar_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3ptyOfcTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ofc_tp_cd", length));
			String[] n3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ofc_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchJOInvoiceManageListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n3ptyCtrlOfcCd[i] != null)
					model.setN3ptyCtrlOfcCd(n3ptyCtrlOfcCd[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n3ptyArOfcCd[i] != null)
					model.setN3ptyArOfcCd(n3ptyArOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3ptyOfcTpCd[i] != null)
					model.setN3ptyOfcTpCd(n3ptyOfcTpCd[i]);
				if (n3ptyOfcCd[i] != null)
					model.setN3ptyOfcCd(n3ptyOfcCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (sOfcCd[i] != null)
					model.setOfcCd(sOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchJOInvoiceManageListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchJOInvoiceManageListVO[]
	 */
	public SearchJOInvoiceManageListVO[] getSearchJOInvoiceManageListVOs(){
		SearchJOInvoiceManageListVO[] vos = (SearchJOInvoiceManageListVO[])models.toArray(new SearchJOInvoiceManageListVO[models.size()]);
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
		this.n3ptyCtrlOfcCd = this.n3ptyCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyArOfcCd = this.n3ptyArOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyOfcTpCd = this.n3ptyOfcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyOfcCd = this.n3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}