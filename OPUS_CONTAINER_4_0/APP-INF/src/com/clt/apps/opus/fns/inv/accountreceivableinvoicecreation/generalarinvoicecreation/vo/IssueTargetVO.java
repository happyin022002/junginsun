/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IssueTargetVO.java
*@FileTitle : IssueTargetVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.08.19 정휘택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo;

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
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IssueTargetVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IssueTargetVO> models = new ArrayList<IssueTargetVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String revTpCd = null;
	/* Column Info */
	private String sailArrDt = null;
	/* Column Info */
	private String trspRqstOrdFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invSplitCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invIssTpCd = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String actCustCntCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String dueDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IssueTargetVO() {}

	public IssueTargetVO(String ibflag, String pagerows, String actCustCntCd, String actCustSeq, String vslCd, String skdVoyNo, String skdDirCd, String ioBndCd, String portCd, String invNo, String dueDt, String svcScpCd, String blSrcNo, String invSplitCd, String invIssTpCd, String invRmk, String sailArrDt, String bkgNo, String revTpCd, String trspRqstOrdFlg, String arIfNo) {
		this.vslCd = vslCd;
		this.blSrcNo = blSrcNo;
		this.svcScpCd = svcScpCd;
		this.actCustSeq = actCustSeq;
		this.skdVoyNo = skdVoyNo;
		this.ioBndCd = ioBndCd;
		this.revTpCd = revTpCd;
		this.sailArrDt = sailArrDt;
		this.trspRqstOrdFlg = trspRqstOrdFlg;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.invSplitCd = invSplitCd;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.invIssTpCd = invIssTpCd;
		this.arIfNo = arIfNo;
		this.invRmk = invRmk;
		this.actCustCntCd = actCustCntCd;
		this.portCd = portCd;
		this.invNo = invNo;
		this.dueDt = dueDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("rev_tp_cd", getRevTpCd());
		this.hashColumns.put("sail_arr_dt", getSailArrDt());
		this.hashColumns.put("trsp_rqst_ord_flg", getTrspRqstOrdFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_split_cd", getInvSplitCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_iss_tp_cd", getInvIssTpCd());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("due_dt", getDueDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("trsp_rqst_ord_flg", "trspRqstOrdFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_split_cd", "invSplitCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_iss_tp_cd", "invIssTpCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("due_dt", "dueDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return revTpCd
	 */
	public String getRevTpCd() {
		return this.revTpCd;
	}
	
	/**
	 * Column Info
	 * @return sailArrDt
	 */
	public String getSailArrDt() {
		return this.sailArrDt;
	}
	
	/**
	 * Column Info
	 * @return trspRqstOrdFlg
	 */
	public String getTrspRqstOrdFlg() {
		return this.trspRqstOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return invSplitCd
	 */
	public String getInvSplitCd() {
		return this.invSplitCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return invIssTpCd
	 */
	public String getInvIssTpCd() {
		return this.invIssTpCd;
	}
	
	/**
	 * Column Info
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
	}
	
	/**
	 * Column Info
	 * @return invRmk
	 */
	public String getInvRmk() {
		return this.invRmk;
	}
	
	/**
	 * Column Info
	 * @return actCustCntCd
	 */
	public String getActCustCntCd() {
		return this.actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * Column Info
	 * @param revTpCd
	 */
	public void setRevTpCd(String revTpCd) {
		this.revTpCd = revTpCd;
	}
	
	/**
	 * Column Info
	 * @param sailArrDt
	 */
	public void setSailArrDt(String sailArrDt) {
		this.sailArrDt = sailArrDt;
	}
	
	/**
	 * Column Info
	 * @param trspRqstOrdFlg
	 */
	public void setTrspRqstOrdFlg(String trspRqstOrdFlg) {
		this.trspRqstOrdFlg = trspRqstOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param invSplitCd
	 */
	public void setInvSplitCd(String invSplitCd) {
		this.invSplitCd = invSplitCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param invIssTpCd
	 */
	public void setInvIssTpCd(String invIssTpCd) {
		this.invIssTpCd = invIssTpCd;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	/**
	 * Column Info
	 * @param invRmk
	 */
	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}
	
	/**
	 * Column Info
	 * @param actCustCntCd
	 */
	public void setActCustCntCd(String actCustCntCd) {
		this.actCustCntCd = actCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
		
	/**
	 * @return the invNo
	 */
	public String getInvNo() {
		return invNo;
	}

	/**
	 * @param invNo the invNo to set
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	/**
	 * @return the dueDt
	 */
	public String getDueDt() {
		return dueDt;
	}

	/**
	 * @param dueDt the dueDt to set
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request, "act_cust_seq", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setRevTpCd(JSPUtil.getParameter(request, "rev_tp_cd", ""));
		setSailArrDt(JSPUtil.getParameter(request, "sail_arr_dt", ""));
		setTrspRqstOrdFlg(JSPUtil.getParameter(request, "trsp_rqst_ord_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvSplitCd(JSPUtil.getParameter(request, "inv_split_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setInvIssTpCd(JSPUtil.getParameter(request, "inv_iss_tp_cd", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setInvRmk(JSPUtil.getParameter(request, "inv_rmk", ""));
		setActCustCntCd(JSPUtil.getParameter(request, "act_cust_cnt_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setDueDt(JSPUtil.getParameter(request, "due_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IssueTargetVO[]
	 */
	public IssueTargetVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IssueTargetVO[]
	 */
	public IssueTargetVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IssueTargetVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] revTpCd = (JSPUtil.getParameter(request, prefix	+ "rev_tp_cd", length));
			String[] sailArrDt = (JSPUtil.getParameter(request, prefix	+ "sail_arr_dt", length));
			String[] trspRqstOrdFlg = (JSPUtil.getParameter(request, prefix	+ "trsp_rqst_ord_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invSplitCd = (JSPUtil.getParameter(request, prefix	+ "inv_split_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invIssTpCd = (JSPUtil.getParameter(request, prefix	+ "inv_iss_tp_cd", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] actCustCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cnt_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] dueDt = (JSPUtil.getParameter(request, prefix	+ "due_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new IssueTargetVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (revTpCd[i] != null)
					model.setRevTpCd(revTpCd[i]);
				if (sailArrDt[i] != null)
					model.setSailArrDt(sailArrDt[i]);
				if (trspRqstOrdFlg[i] != null)
					model.setTrspRqstOrdFlg(trspRqstOrdFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invSplitCd[i] != null)
					model.setInvSplitCd(invSplitCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invIssTpCd[i] != null)
					model.setInvIssTpCd(invIssTpCd[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (actCustCntCd[i] != null)
					model.setActCustCntCd(actCustCntCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (dueDt[i] != null)
					model.setDueDt(dueDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIssueTargetVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IssueTargetVO[]
	 */
	public IssueTargetVO[] getIssueTargetVOs(){
		IssueTargetVO[] vos = (IssueTargetVO[])models.toArray(new IssueTargetVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd = this.revTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt = this.sailArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspRqstOrdFlg = this.trspRqstOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSplitCd = this.invSplitCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssTpCd = this.invIssTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd = this.actCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt = this.dueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
