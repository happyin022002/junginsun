/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaDownloadSummaryVO.java
*@FileTitle : UsaDownloadSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.02 이수빈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

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
 * @author 이수빈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaDownloadSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaDownloadSummaryVO> models = new ArrayList<UsaDownloadSummaryVO>();
	
	/* Column Info */
	private String vpsEtdDt2 = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String fulCnt = null;
	/* Column Info */
	private String empCnt = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String totHbl = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String vpsEtaDt2 = null;
	/* Column Info */
	private String bdrDt = null;
	/* Column Info */
	private String trnkAutoBdrDt = null;
	/* Column Info */
	private String trnkMnlBdrDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaDownloadSummaryVO() {}

	public UsaDownloadSummaryVO(String ibflag, String pagerows, String vvd, String polCd, String vpsEtdDt, String vpsEtdDt2, String podCd, String vpsEtaDt, String vpsEtaDt2, String bdrFlg, String trnkAutoBdrDt, String trnkMnlBdrDt, String bdrDt, String fulCnt, String empCnt, String totHbl) {
		this.vpsEtdDt2 = vpsEtdDt2;
		this.vpsEtdDt = vpsEtdDt;
		this.bdrFlg = bdrFlg;
		this.fulCnt = fulCnt;
		this.empCnt = empCnt;
		this.vpsEtaDt = vpsEtaDt;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.totHbl = totHbl;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.vpsEtaDt2 = vpsEtaDt2;
		this.bdrDt = bdrDt;
		this.trnkAutoBdrDt = trnkAutoBdrDt;
		this.trnkMnlBdrDt = trnkMnlBdrDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vps_etd_dt2", getVpsEtdDt2());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("ful_cnt", getFulCnt());
		this.hashColumns.put("emp_cnt", getEmpCnt());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("tot_hbl", getTotHbl());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("vps_eta_dt2", getVpsEtaDt2());
		this.hashColumns.put("bdr_dt", getBdrDt());
		this.hashColumns.put("trnk_auto_bdr_dt", getTrnkAutoBdrDt());
		this.hashColumns.put("trnk_mnl_bdr_dt", getTrnkMnlBdrDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vps_etd_dt2", "vpsEtdDt2");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("ful_cnt", "fulCnt");
		this.hashFields.put("emp_cnt", "empCnt");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("tot_hbl", "totHbl");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vps_eta_dt2", "vpsEtaDt2");
		this.hashFields.put("bdr_dt", "bdrDt");
		this.hashFields.put("trnk_auto_bdr_dt", "trnkAutoBdrDt");
		this.hashFields.put("trnk_mnl_bdr_dt", "trnkMnlBdrDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt2
	 */
	public String getVpsEtdDt2() {
		return this.vpsEtdDt2;
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
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return fulCnt
	 */
	public String getFulCnt() {
		return this.fulCnt;
	}
	
	/**
	 * Column Info
	 * @return empCnt
	 */
	public String getEmpCnt() {
		return this.empCnt;
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
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return totHbl
	 */
	public String getTotHbl() {
		return this.totHbl;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt2
	 */
	public String getVpsEtaDt2() {
		return this.vpsEtaDt2;
	}
	
	/**
	 * Column Info
	 * @return bdrDt
	 */
	public String getBdrDt() {
		return this.bdrDt;
	}
	
	/**
	 * Column Info
	 * @return trnkAutoBdrDt
	 */
	public String getTrnkAutoBdrDt() {
		return this.trnkAutoBdrDt;
	}
	
	/**
	 * Column Info
	 * @return trnkMnlBdrDt
	 */
	public String getTrnkMnlBdrDt() {
		return this.trnkMnlBdrDt;
	}
	

	/**
	 * Column Info
	 * @param vpsEtdDt2
	 */
	public void setVpsEtdDt2(String vpsEtdDt2) {
		this.vpsEtdDt2 = vpsEtdDt2;
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
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param fulCnt
	 */
	public void setFulCnt(String fulCnt) {
		this.fulCnt = fulCnt;
	}
	
	/**
	 * Column Info
	 * @param empCnt
	 */
	public void setEmpCnt(String empCnt) {
		this.empCnt = empCnt;
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
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param totHbl
	 */
	public void setTotHbl(String totHbl) {
		this.totHbl = totHbl;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt2
	 */
	public void setVpsEtaDt2(String vpsEtaDt2) {
		this.vpsEtaDt2 = vpsEtaDt2;
	}
	
	/**
	 * Column Info
	 * @param bdrDt
	 */
	public void setBdrDt(String bdrDt) {
		this.bdrDt = bdrDt;
	}
	
	/**
	 * Column Info
	 * @param trnkAutoBdrDt
	 */
	public void setTrnkAutoBdrDt(String trnkAutoBdrDt) {
		this.trnkAutoBdrDt = trnkAutoBdrDt;
	}
	
	/**
	 * Column Info
	 * @param trnkMnlBdrDt
	 */
	public void setTrnkMnlBdrDt(String trnkMnlBdrDt) {
		this.trnkMnlBdrDt = trnkMnlBdrDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVpsEtdDt2(JSPUtil.getParameter(request, "vps_etd_dt2", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setBdrFlg(JSPUtil.getParameter(request, "bdr_flg", ""));
		setFulCnt(JSPUtil.getParameter(request, "ful_cnt", ""));
		setEmpCnt(JSPUtil.getParameter(request, "emp_cnt", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setTotHbl(JSPUtil.getParameter(request, "tot_hbl", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setVpsEtaDt2(JSPUtil.getParameter(request, "vps_eta_dt2", ""));
		setBdrDt(JSPUtil.getParameter(request, "bdr_dt", ""));
		setTrnkAutoBdrDt(JSPUtil.getParameter(request, "trnk_auto_bdr_dt", ""));
		setTrnkMnlBdrDt(JSPUtil.getParameter(request, "trnk_mnl_bdr_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaDownloadSummaryVO[]
	 */
	public UsaDownloadSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaDownloadSummaryVO[]
	 */
	public UsaDownloadSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaDownloadSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vpsEtdDt2 = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt2", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] fulCnt = (JSPUtil.getParameter(request, prefix	+ "ful_cnt", length));
			String[] empCnt = (JSPUtil.getParameter(request, prefix	+ "emp_cnt", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] totHbl = (JSPUtil.getParameter(request, prefix	+ "tot_hbl", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] vpsEtaDt2 = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt2", length));
			String[] bdrDt = (JSPUtil.getParameter(request, prefix	+ "bdr_dt", length));
			String[] trnkAutoBdrDt = (JSPUtil.getParameter(request, prefix	+ "trnk_auto_bdr_dt", length));
			String[] trnkMnlBdrDt = (JSPUtil.getParameter(request, prefix	+ "trnk_mnl_bdr_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaDownloadSummaryVO();
				if (vpsEtdDt2[i] != null)
					model.setVpsEtdDt2(vpsEtdDt2[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (fulCnt[i] != null)
					model.setFulCnt(fulCnt[i]);
				if (empCnt[i] != null)
					model.setEmpCnt(empCnt[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (totHbl[i] != null)
					model.setTotHbl(totHbl[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (vpsEtaDt2[i] != null)
					model.setVpsEtaDt2(vpsEtaDt2[i]);
				if (bdrDt[i] != null)
					model.setBdrDt(bdrDt[i]);
				if (trnkAutoBdrDt[i] != null)
					model.setTrnkAutoBdrDt(trnkAutoBdrDt[i]);
				if (trnkMnlBdrDt[i] != null)
					model.setTrnkMnlBdrDt(trnkMnlBdrDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaDownloadSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaDownloadSummaryVO[]
	 */
	public UsaDownloadSummaryVO[] getUsaDownloadSummaryVOs(){
		UsaDownloadSummaryVO[] vos = (UsaDownloadSummaryVO[])models.toArray(new UsaDownloadSummaryVO[models.size()]);
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
		this.vpsEtdDt2 = this.vpsEtdDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fulCnt = this.fulCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.empCnt = this.empCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totHbl = this.totHbl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt2 = this.vpsEtaDt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrDt = this.bdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkAutoBdrDt = this.trnkAutoBdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkMnlBdrDt = this.trnkMnlBdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
