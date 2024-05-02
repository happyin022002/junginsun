package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PsoTrfAtchFileVO;

public class TariffAtchFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<TariffAtchFileVO> models = new ArrayList<TariffAtchFileVO>();

	private SignOnUserAccount account = null;
	
	private String[] Keys= null;
	
	private PsoTrfAtchFileVO[] psoTrfAtchFileVOs = null;
	

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydChgNo = null;
	/* Column Info */
	private String ydChgVerSeq = null;	
	/* Column Info */
	private String atchFileDivCd = null;		
	/* Page Number */
	private String pagerows = null;
	/* 첨부파일 권한 */
	private String ctrtScrFlg = null;
	
	private String atchFileAuth = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public TariffAtchFileVO() {}

	public TariffAtchFileVO(String ibflag, String ydChgNo, String ydChgVerSeq, String atchFileDivCd, String pagerows, String ctrtScrFlg, String atchFileAuth) {
		this.ibflag = ibflag;
		this.ydChgNo = ydChgNo;
		this.ydChgVerSeq = ydChgVerSeq;
		this.atchFileDivCd = atchFileDivCd;
		this.pagerows = pagerows;
		this.ctrtScrFlg = ctrtScrFlg;
		this.atchFileAuth = atchFileAuth;
	}
	

	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/**
	 * @return the keys
	 */
	public String[] getKeys() {
		return Keys;
	}

	/**
	 * @param keys the keys to set
	 */
	public void setKeys(String[] keys) {
		Keys = keys;
	}
	

	/**
	 * @return the psoTrfAtchFileVOs
	 */
	public PsoTrfAtchFileVO[] getPsoTrfAtchFileVOs() {
		return psoTrfAtchFileVOs;
	}

	/**
	 * @param psoTrfAtchFileVOs the psoTrfAtchFileVOs to set
	 */
	public void setPsoTrfAtchFileVOs(PsoTrfAtchFileVO[] psoTrfAtchFileVOs) {
		this.psoTrfAtchFileVOs = psoTrfAtchFileVOs;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_chg_no", getYdChgNo());
		this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
		this.hashColumns.put("atch_file_div_cd", getAtchFileDivCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_scr_flg", getCtrtScrFlg());
		this.hashColumns.put("atch_file_auth", getAtchFileAuth());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_chg_no", "ydChgNo");
		this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
		this.hashFields.put("atch_file_div_cd", "atchFileDivCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_scr_flg", ctrtScrFlg);
		this.hashFields.put("atch_file_auth", atchFileAuth);
		return this.hashFields;
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
	 * @return ydChgNo
	 */
	public String getYdChgNo() {
		return this.ydChgNo;
	}

	/**
	 * Column Info
	 * @return ydChgVerSeq
	 */
	public String getYdChgVerSeq() {
		return this.ydChgVerSeq;
	}

	/**
	 * Column Info
	 * @return atchFileDivCd
	 */
	public String getAtchFileDivCd() {
		return this.atchFileDivCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param ydChgNo
	 */
	public void setYdChgNo(String ydChgNo) {
		this.ydChgNo = ydChgNo;
	}

	/**
	 * Column Info
	 * @param ydChgVerSeq
	 */
	public void setYdChgVerSeq(String ydChgVerSeq) {
		this.ydChgVerSeq = ydChgVerSeq;
	}

	/**
	 * Column Info
	 * @param atchFileDivCd
	 */
	public void setAtchFileDivCd(String atchFileDivCd) {
		this.atchFileDivCd = atchFileDivCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public String getCtrtScrFlg() {
		return ctrtScrFlg;
	}

	public void setCtrtScrFlg(String ctrtScrFlg) {
		this.ctrtScrFlg = ctrtScrFlg;
	}
	
	public String getAtchFileAuth() {
		return atchFileAuth;
	}

	public void setAtchFileAuth(String atchFileAuth) {
		this.atchFileAuth = atchFileAuth;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYdChgNo(JSPUtil.getParameter(request, "yd_chg_no", ""));
		setYdChgVerSeq(JSPUtil.getParameter(request, "yd_chg_ver_seq", ""));
		setAtchFileDivCd(JSPUtil.getParameter(request, "atch_file_div_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCtrtScrFlg(JSPUtil.getParameter(request, "ctrt_scr_flg", ""));
		setAtchFileAuth(JSPUtil.getParameter(request, "atch_file_auth", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TariffUploadFileListVO[]
	 */
	public TariffAtchFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TariffUploadFileListVO[]
	 */
	public TariffAtchFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TariffAtchFileVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydChgNo = (JSPUtil.getParameter(request, prefix + "yd_chg_no", length));
			String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix + "yd_chg_ver_seq", length));
			String[] atchFileDivCd = (JSPUtil.getParameter(request, prefix + "atch_file_div_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] ctrtScrFlg = (JSPUtil.getParameter(request, prefix + "ctrtScrFlg", length));
			String[] atchFileAuth = (JSPUtil.getParameter(request, prefix + "atchFileAuth", length));

			for (int i = 0; i < length; i++) {
				model = new TariffAtchFileVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydChgNo[i] != null)
					model.setYdChgNo(ydChgNo[i]);
				if (ydChgVerSeq[i] != null)
					model.setYdChgVerSeq(ydChgVerSeq[i]);
				if (atchFileDivCd[i] != null)
					model.setAtchFileDivCd(atchFileDivCd[i]);				
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtScrFlg[i] != null)
					model.setCtrtScrFlg(ctrtScrFlg[i]);
				if (atchFileAuth[i] != null)
					model.setAtchFileAuth(atchFileAuth[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTariffAtchFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return getTariffAtchFileVOs[]
	 */
	public TariffAtchFileVO[] getTariffAtchFileVOs(){
		TariffAtchFileVO[] vos = (TariffAtchFileVO[])models.toArray(new TariffAtchFileVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgNo = this.ydChgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChgVerSeq = this.ydChgVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileDivCd = this.atchFileDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtScrFlg = this.ctrtScrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileAuth = this.atchFileAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
