/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualVSKVO.java
*@FileTitle : ActualVSKVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김성일
*@LastVersion : 1.0
* 2009.09.25 김성일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copdetailreceive.vo;

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
 * @author 김성일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ActualVSKVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActualVSKVO> models = new ArrayList<ActualVSKVO>();
	
	/* Column Info */
	private String preCop = null;
	/* Column Info */
	private String inClptIndSeq = null;
	/* Column Info */
	private String inVpsPortCd = null;
	/* Column Info */
	private String inActDt = null;
	/* Column Info */
	private String inSkdVoyNo = null;
	/* Column Info */
	private String inSkdDirCd = null;
	/* Column Info */
	private String inActStsMapgCd = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String nxtCop = null;
	/* Column Info */
	private String inVslCd = null;
	/* Column Info */
	private String copDtlSeq = null;
	/* Column Info */
	private String inCntrNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inActRcvNo = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String outResultCd = null;
	/* Column Info */
	private String inActRcvDt = null;
	/* Column Info */
	private String outCopNo = null;
	/* Column Info */
	private String inBkgNo = null;
	/* Column Info */
	private String inCopNo = null;
	/* Column Info */
	private String inUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ActualVSKVO() {}

	public ActualVSKVO(String ibflag, String pagerows, String inActRcvDt, String inActRcvNo, String inVslCd, String inSkdVoyNo, String inSkdDirCd, String inVpsPortCd, String inClptIndSeq, String inActDt, String inActStsMapgCd, String inUsrId, String outResultCd, String outCopNo, String inCopNo, String inBkgNo, String inCntrNo, String copNo, String copDtlSeq, String preCop, String nxtCop, String actDt) {
		this.preCop = preCop;
		this.inClptIndSeq = inClptIndSeq;
		this.inVpsPortCd = inVpsPortCd;
		this.inActDt = inActDt;
		this.inSkdVoyNo = inSkdVoyNo;
		this.inSkdDirCd = inSkdDirCd;
		this.inActStsMapgCd = inActStsMapgCd;
		this.copNo = copNo;
		this.nxtCop = nxtCop;
		this.inVslCd = inVslCd;
		this.copDtlSeq = copDtlSeq;
		this.inCntrNo = inCntrNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.inActRcvNo = inActRcvNo;
		this.actDt = actDt;
		this.outResultCd = outResultCd;
		this.inActRcvDt = inActRcvDt;
		this.outCopNo = outCopNo;
		this.inBkgNo = inBkgNo;
		this.inCopNo = inCopNo;
		this.inUsrId = inUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pre_cop", getPreCop());
		this.hashColumns.put("in_clpt_ind_seq", getInClptIndSeq());
		this.hashColumns.put("in_vps_port_cd", getInVpsPortCd());
		this.hashColumns.put("in_act_dt", getInActDt());
		this.hashColumns.put("in_skd_voy_no", getInSkdVoyNo());
		this.hashColumns.put("in_skd_dir_cd", getInSkdDirCd());
		this.hashColumns.put("in_act_sts_mapg_cd", getInActStsMapgCd());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("nxt_cop", getNxtCop());
		this.hashColumns.put("in_vsl_cd", getInVslCd());
		this.hashColumns.put("cop_dtl_seq", getCopDtlSeq());
		this.hashColumns.put("in_cntr_no", getInCntrNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("in_act_rcv_no", getInActRcvNo());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("out_result_cd", getOutResultCd());
		this.hashColumns.put("in_act_rcv_dt", getInActRcvDt());
		this.hashColumns.put("out_cop_no", getOutCopNo());
		this.hashColumns.put("in_bkg_no", getInBkgNo());
		this.hashColumns.put("in_cop_no", getInCopNo());
		this.hashColumns.put("in_usr_id", getInUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pre_cop", "preCop");
		this.hashFields.put("in_clpt_ind_seq", "inClptIndSeq");
		this.hashFields.put("in_vps_port_cd", "inVpsPortCd");
		this.hashFields.put("in_act_dt", "inActDt");
		this.hashFields.put("in_skd_voy_no", "inSkdVoyNo");
		this.hashFields.put("in_skd_dir_cd", "inSkdDirCd");
		this.hashFields.put("in_act_sts_mapg_cd", "inActStsMapgCd");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("nxt_cop", "nxtCop");
		this.hashFields.put("in_vsl_cd", "inVslCd");
		this.hashFields.put("cop_dtl_seq", "copDtlSeq");
		this.hashFields.put("in_cntr_no", "inCntrNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("in_act_rcv_no", "inActRcvNo");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("out_result_cd", "outResultCd");
		this.hashFields.put("in_act_rcv_dt", "inActRcvDt");
		this.hashFields.put("out_cop_no", "outCopNo");
		this.hashFields.put("in_bkg_no", "inBkgNo");
		this.hashFields.put("in_cop_no", "inCopNo");
		this.hashFields.put("in_usr_id", "inUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return preCop
	 */
	public String getPreCop() {
		return this.preCop;
	}
	
	/**
	 * Column Info
	 * @return inClptIndSeq
	 */
	public String getInClptIndSeq() {
		return this.inClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return inVpsPortCd
	 */
	public String getInVpsPortCd() {
		return this.inVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return inActDt
	 */
	public String getInActDt() {
		return this.inActDt;
	}
	
	/**
	 * Column Info
	 * @return inSkdVoyNo
	 */
	public String getInSkdVoyNo() {
		return this.inSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return inSkdDirCd
	 */
	public String getInSkdDirCd() {
		return this.inSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return inActStsMapgCd
	 */
	public String getInActStsMapgCd() {
		return this.inActStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return nxtCop
	 */
	public String getNxtCop() {
		return this.nxtCop;
	}
	
	/**
	 * Column Info
	 * @return inVslCd
	 */
	public String getInVslCd() {
		return this.inVslCd;
	}
	
	/**
	 * Column Info
	 * @return copDtlSeq
	 */
	public String getCopDtlSeq() {
		return this.copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return inCntrNo
	 */
	public String getInCntrNo() {
		return this.inCntrNo;
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
	 * @return inActRcvNo
	 */
	public String getInActRcvNo() {
		return this.inActRcvNo;
	}
	
	/**
	 * Column Info
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}
	
	/**
	 * Column Info
	 * @return outResultCd
	 */
	public String getOutResultCd() {
		return this.outResultCd;
	}
	
	/**
	 * Column Info
	 * @return inActRcvDt
	 */
	public String getInActRcvDt() {
		return this.inActRcvDt;
	}
	
	/**
	 * Column Info
	 * @return outCopNo
	 */
	public String getOutCopNo() {
		return this.outCopNo;
	}
	
	/**
	 * Column Info
	 * @return inBkgNo
	 */
	public String getInBkgNo() {
		return this.inBkgNo;
	}
	
	/**
	 * Column Info
	 * @return inCopNo
	 */
	public String getInCopNo() {
		return this.inCopNo;
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
	 * @param preCop
	 */
	public void setPreCop(String preCop) {
		this.preCop = preCop;
	}
	
	/**
	 * Column Info
	 * @param inClptIndSeq
	 */
	public void setInClptIndSeq(String inClptIndSeq) {
		this.inClptIndSeq = inClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param inVpsPortCd
	 */
	public void setInVpsPortCd(String inVpsPortCd) {
		this.inVpsPortCd = inVpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param inActDt
	 */
	public void setInActDt(String inActDt) {
		this.inActDt = inActDt;
	}
	
	/**
	 * Column Info
	 * @param inSkdVoyNo
	 */
	public void setInSkdVoyNo(String inSkdVoyNo) {
		this.inSkdVoyNo = inSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param inSkdDirCd
	 */
	public void setInSkdDirCd(String inSkdDirCd) {
		this.inSkdDirCd = inSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param inActStsMapgCd
	 */
	public void setInActStsMapgCd(String inActStsMapgCd) {
		this.inActStsMapgCd = inActStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param nxtCop
	 */
	public void setNxtCop(String nxtCop) {
		this.nxtCop = nxtCop;
	}
	
	/**
	 * Column Info
	 * @param inVslCd
	 */
	public void setInVslCd(String inVslCd) {
		this.inVslCd = inVslCd;
	}
	
	/**
	 * Column Info
	 * @param copDtlSeq
	 */
	public void setCopDtlSeq(String copDtlSeq) {
		this.copDtlSeq = copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param inCntrNo
	 */
	public void setInCntrNo(String inCntrNo) {
		this.inCntrNo = inCntrNo;
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
	 * @param inActRcvNo
	 */
	public void setInActRcvNo(String inActRcvNo) {
		this.inActRcvNo = inActRcvNo;
	}
	
	/**
	 * Column Info
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}
	
	/**
	 * Column Info
	 * @param outResultCd
	 */
	public void setOutResultCd(String outResultCd) {
		this.outResultCd = outResultCd;
	}
	
	/**
	 * Column Info
	 * @param inActRcvDt
	 */
	public void setInActRcvDt(String inActRcvDt) {
		this.inActRcvDt = inActRcvDt;
	}
	
	/**
	 * Column Info
	 * @param outCopNo
	 */
	public void setOutCopNo(String outCopNo) {
		this.outCopNo = outCopNo;
	}
	
	/**
	 * Column Info
	 * @param inBkgNo
	 */
	public void setInBkgNo(String inBkgNo) {
		this.inBkgNo = inBkgNo;
	}
	
	/**
	 * Column Info
	 * @param inCopNo
	 */
	public void setInCopNo(String inCopNo) {
		this.inCopNo = inCopNo;
	}
	
	/**
	 * Column Info
	 * @param inUsrId
	 */
	public void setInUsrId(String inUsrId) {
		this.inUsrId = inUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPreCop(JSPUtil.getParameter(request, "pre_cop", ""));
		setInClptIndSeq(JSPUtil.getParameter(request, "in_clpt_ind_seq", ""));
		setInVpsPortCd(JSPUtil.getParameter(request, "in_vps_port_cd", ""));
		setInActDt(JSPUtil.getParameter(request, "in_act_dt", ""));
		setInSkdVoyNo(JSPUtil.getParameter(request, "in_skd_voy_no", ""));
		setInSkdDirCd(JSPUtil.getParameter(request, "in_skd_dir_cd", ""));
		setInActStsMapgCd(JSPUtil.getParameter(request, "in_act_sts_mapg_cd", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setNxtCop(JSPUtil.getParameter(request, "nxt_cop", ""));
		setInVslCd(JSPUtil.getParameter(request, "in_vsl_cd", ""));
		setCopDtlSeq(JSPUtil.getParameter(request, "cop_dtl_seq", ""));
		setInCntrNo(JSPUtil.getParameter(request, "in_cntr_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInActRcvNo(JSPUtil.getParameter(request, "in_act_rcv_no", ""));
		setActDt(JSPUtil.getParameter(request, "act_dt", ""));
		setOutResultCd(JSPUtil.getParameter(request, "out_result_cd", ""));
		setInActRcvDt(JSPUtil.getParameter(request, "in_act_rcv_dt", ""));
		setOutCopNo(JSPUtil.getParameter(request, "out_cop_no", ""));
		setInBkgNo(JSPUtil.getParameter(request, "in_bkg_no", ""));
		setInCopNo(JSPUtil.getParameter(request, "in_cop_no", ""));
		setInUsrId(JSPUtil.getParameter(request, "in_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActualVSKVO[]
	 */
	public ActualVSKVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActualVSKVO[]
	 */
	public ActualVSKVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActualVSKVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] preCop = (JSPUtil.getParameter(request, prefix	+ "pre_cop", length));
			String[] inClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "in_clpt_ind_seq", length));
			String[] inVpsPortCd = (JSPUtil.getParameter(request, prefix	+ "in_vps_port_cd", length));
			String[] inActDt = (JSPUtil.getParameter(request, prefix	+ "in_act_dt", length));
			String[] inSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "in_skd_voy_no", length));
			String[] inSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "in_skd_dir_cd", length));
			String[] inActStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "in_act_sts_mapg_cd", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] nxtCop = (JSPUtil.getParameter(request, prefix	+ "nxt_cop", length));
			String[] inVslCd = (JSPUtil.getParameter(request, prefix	+ "in_vsl_cd", length));
			String[] copDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_seq", length));
			String[] inCntrNo = (JSPUtil.getParameter(request, prefix	+ "in_cntr_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inActRcvNo = (JSPUtil.getParameter(request, prefix	+ "in_act_rcv_no", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] outResultCd = (JSPUtil.getParameter(request, prefix	+ "out_result_cd", length));
			String[] inActRcvDt = (JSPUtil.getParameter(request, prefix	+ "in_act_rcv_dt", length));
			String[] outCopNo = (JSPUtil.getParameter(request, prefix	+ "out_cop_no", length));
			String[] inBkgNo = (JSPUtil.getParameter(request, prefix	+ "in_bkg_no", length));
			String[] inCopNo = (JSPUtil.getParameter(request, prefix	+ "in_cop_no", length));
			String[] inUsrId = (JSPUtil.getParameter(request, prefix	+ "in_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ActualVSKVO();
				if (preCop[i] != null)
					model.setPreCop(preCop[i]);
				if (inClptIndSeq[i] != null)
					model.setInClptIndSeq(inClptIndSeq[i]);
				if (inVpsPortCd[i] != null)
					model.setInVpsPortCd(inVpsPortCd[i]);
				if (inActDt[i] != null)
					model.setInActDt(inActDt[i]);
				if (inSkdVoyNo[i] != null)
					model.setInSkdVoyNo(inSkdVoyNo[i]);
				if (inSkdDirCd[i] != null)
					model.setInSkdDirCd(inSkdDirCd[i]);
				if (inActStsMapgCd[i] != null)
					model.setInActStsMapgCd(inActStsMapgCd[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (nxtCop[i] != null)
					model.setNxtCop(nxtCop[i]);
				if (inVslCd[i] != null)
					model.setInVslCd(inVslCd[i]);
				if (copDtlSeq[i] != null)
					model.setCopDtlSeq(copDtlSeq[i]);
				if (inCntrNo[i] != null)
					model.setInCntrNo(inCntrNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inActRcvNo[i] != null)
					model.setInActRcvNo(inActRcvNo[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (outResultCd[i] != null)
					model.setOutResultCd(outResultCd[i]);
				if (inActRcvDt[i] != null)
					model.setInActRcvDt(inActRcvDt[i]);
				if (outCopNo[i] != null)
					model.setOutCopNo(outCopNo[i]);
				if (inBkgNo[i] != null)
					model.setInBkgNo(inBkgNo[i]);
				if (inCopNo[i] != null)
					model.setInCopNo(inCopNo[i]);
				if (inUsrId[i] != null)
					model.setInUsrId(inUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActualVSKVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ActualVSKVO[]
	 */
	public ActualVSKVO[] getActualVSKVOs(){
		ActualVSKVO[] vos = (ActualVSKVO[])models.toArray(new ActualVSKVO[models.size()]);
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
		this.preCop = this.preCop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inClptIndSeq = this.inClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVpsPortCd = this.inVpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inActDt = this.inActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdVoyNo = this.inSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inSkdDirCd = this.inSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inActStsMapgCd = this.inActStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nxtCop = this.nxtCop .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inVslCd = this.inVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlSeq = this.copDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCntrNo = this.inCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inActRcvNo = this.inActRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outResultCd = this.outResultCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inActRcvDt = this.inActRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.outCopNo = this.outCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgNo = this.inBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inCopNo = this.inCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inUsrId = this.inUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
