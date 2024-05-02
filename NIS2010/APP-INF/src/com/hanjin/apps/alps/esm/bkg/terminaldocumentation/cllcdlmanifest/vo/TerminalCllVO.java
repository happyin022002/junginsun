/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalCllVO.java
*@FileTitle : TerminalCllVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.09.10 김승민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

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
 * @author 김승민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TerminalCllVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TerminalCllVO> models = new ArrayList<TerminalCllVO>();
	
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inPolTs = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String inQty = null;
	/* Column Info */
	private String inFeu = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String tbnSeq = null;
	/* Column Info */
	private String inPolCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String inVvdCd = null;
	/* Column Info */
	private String inTeu = null;
	/* Column Info */
	private String tbxSeq = null;
	/* Column Info */
	private String inUsrId = null;
	/* Column Info */
	private String polSplitNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TerminalCllVO() {}

	public TerminalCllVO(String ibflag, String pagerows, String inVvdCd, String inPolCd, String inPolTs, String bkgNo, String cntrNo, String cntrTpszCd, String inUsrId, String vpsEtaDt, String vpsEtdDt, String tbxSeq, String inQty, String tbnSeq, String inTeu, String inFeu, String polSplitNo) {
		this.vpsEtdDt = vpsEtdDt;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.inPolTs = inPolTs;
		this.bkgNo = bkgNo;
		this.inQty = inQty;
		this.inFeu = inFeu;
		this.cntrNo = cntrNo;
		this.tbnSeq = tbnSeq;
		this.inPolCd = inPolCd;
		this.cntrTpszCd = cntrTpszCd;
		this.inVvdCd = inVvdCd;
		this.inTeu = inTeu;
		this.tbxSeq = tbxSeq;
		this.inUsrId = inUsrId;
		this.polSplitNo = polSplitNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_pol_ts", getInPolTs());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("in_qty", getInQty());
		this.hashColumns.put("in_feu", getInFeu());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("tbn_seq", getTbnSeq());
		this.hashColumns.put("in_pol_cd", getInPolCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("in_vvd_cd", getInVvdCd());
		this.hashColumns.put("in_teu", getInTeu());
		this.hashColumns.put("tbx_seq", getTbxSeq());
		this.hashColumns.put("in_usr_id", getInUsrId());
		this.hashColumns.put("pol_split_no", getPolSplitNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_pol_ts", "inPolTs");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("in_qty", "inQty");
		this.hashFields.put("in_feu", "inFeu");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("tbn_seq", "tbnSeq");
		this.hashFields.put("in_pol_cd", "inPolCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("in_vvd_cd", "inVvdCd");
		this.hashFields.put("in_teu", "inTeu");
		this.hashFields.put("tbx_seq", "tbxSeq");
		this.hashFields.put("in_usr_id", "inUsrId");
		this.hashFields.put("pol_split_no", "polSplitNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return inPolTs
	 */
	public String getInPolTs() {
		return this.inPolTs;
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
	 * @return inQty
	 */
	public String getInQty() {
		return this.inQty;
	}
	
	/**
	 * Column Info
	 * @return inFeu
	 */
	public String getInFeu() {
		return this.inFeu;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return tbnSeq
	 */
	public String getTbnSeq() {
		return this.tbnSeq;
	}
	
	/**
	 * Column Info
	 * @return inPolCd
	 */
	public String getInPolCd() {
		return this.inPolCd;
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
	 * @return inVvdCd
	 */
	public String getInVvdCd() {
		return this.inVvdCd;
	}
	
	/**
	 * Column Info
	 * @return inTeu
	 */
	public String getInTeu() {
		return this.inTeu;
	}
	
	/**
	 * Column Info
	 * @return tbxSeq
	 */
	public String getTbxSeq() {
		return this.tbxSeq;
	}
	
	/**
	 * Column Info
	 * @return inUsrId
	 */
	public String getInUsrId() {
		return this.inUsrId;
	}
	
	/**
	 * Column Info
	 * @return polSplitNo
	 */
	public String getPolSplitNo() {
		return this.polSplitNo;
	}	

	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param inPolTs
	 */
	public void setInPolTs(String inPolTs) {
		this.inPolTs = inPolTs;
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
	 * @param inQty
	 */
	public void setInQty(String inQty) {
		this.inQty = inQty;
	}
	
	/**
	 * Column Info
	 * @param inFeu
	 */
	public void setInFeu(String inFeu) {
		this.inFeu = inFeu;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param tbnSeq
	 */
	public void setTbnSeq(String tbnSeq) {
		this.tbnSeq = tbnSeq;
	}
	
	/**
	 * Column Info
	 * @param inPolCd
	 */
	public void setInPolCd(String inPolCd) {
		this.inPolCd = inPolCd;
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
	 * @param inVvdCd
	 */
	public void setInVvdCd(String inVvdCd) {
		this.inVvdCd = inVvdCd;
	}
	
	/**
	 * Column Info
	 * @param inTeu
	 */
	public void setInTeu(String inTeu) {
		this.inTeu = inTeu;
	}
	
	/**
	 * Column Info
	 * @param tbxSeq
	 */
	public void setTbxSeq(String tbxSeq) {
		this.tbxSeq = tbxSeq;
	}
	
	/**
	 * Column Info
	 * @param inUsrId
	 */
	public void setInUsrId(String inUsrId) {
		this.inUsrId = inUsrId;
	}
	
	/**
	 * Column Info
	 * @param polSplitNo
	 */
	public void setPolSplitNo(String polSplitNo) {
		this.polSplitNo = polSplitNo;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInPolTs(JSPUtil.getParameter(request, "in_pol_ts", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setInQty(JSPUtil.getParameter(request, "in_qty", ""));
		setInFeu(JSPUtil.getParameter(request, "in_feu", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setTbnSeq(JSPUtil.getParameter(request, "tbn_seq", ""));
		setInPolCd(JSPUtil.getParameter(request, "in_pol_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setInVvdCd(JSPUtil.getParameter(request, "in_vvd_cd", ""));
		setInTeu(JSPUtil.getParameter(request, "in_teu", ""));
		setTbxSeq(JSPUtil.getParameter(request, "tbx_seq", ""));
		setInUsrId(JSPUtil.getParameter(request, "in_usr_id", ""));
		setPolSplitNo(JSPUtil.getParameter(request, "pol_split_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TerminalCllVO[]
	 */
	public TerminalCllVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TerminalCllVO[]
	 */
	public TerminalCllVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TerminalCllVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inPolTs = (JSPUtil.getParameter(request, prefix	+ "in_pol_ts", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] inQty = (JSPUtil.getParameter(request, prefix	+ "in_qty", length));
			String[] inFeu = (JSPUtil.getParameter(request, prefix	+ "in_feu", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] tbnSeq = (JSPUtil.getParameter(request, prefix	+ "tbn_seq", length));
			String[] inPolCd = (JSPUtil.getParameter(request, prefix	+ "in_pol_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] inVvdCd = (JSPUtil.getParameter(request, prefix	+ "in_vvd_cd", length));
			String[] inTeu = (JSPUtil.getParameter(request, prefix	+ "in_teu", length));
			String[] tbxSeq = (JSPUtil.getParameter(request, prefix	+ "tbx_seq", length));
			String[] inUsrId = (JSPUtil.getParameter(request, prefix	+ "in_usr_id", length));
			String[] polSplitNo = (JSPUtil.getParameter(request, prefix	+ "pol_split_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new TerminalCllVO();
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inPolTs[i] != null)
					model.setInPolTs(inPolTs[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (inQty[i] != null)
					model.setInQty(inQty[i]);
				if (inFeu[i] != null)
					model.setInFeu(inFeu[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (tbnSeq[i] != null)
					model.setTbnSeq(tbnSeq[i]);
				if (inPolCd[i] != null)
					model.setInPolCd(inPolCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (inVvdCd[i] != null)
					model.setInVvdCd(inVvdCd[i]);
				if (inTeu[i] != null)
					model.setInTeu(inTeu[i]);
				if (tbxSeq[i] != null)
					model.setTbxSeq(tbxSeq[i]);
				if (inUsrId[i] != null)
					model.setInUsrId(inUsrId[i]);
				if (polSplitNo[i] != null)
					model.setPolSplitNo(polSplitNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTerminalCllVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TerminalCllVO[]
	 */
	public TerminalCllVO[] getTerminalCllVOs(){
		TerminalCllVO[] vos = (TerminalCllVO[])models.toArray(new TerminalCllVO[models.size()]);
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
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolTs = this.inPolTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inQty = this.inQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inFeu = this.inFeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tbnSeq = this.tbnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inPolCd = this.inPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVvdCd = this.inVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inTeu = this.inTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tbxSeq = this.tbxSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inUsrId = this.inUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSplitNo = this.polSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
