/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BsaYearlyPlanConditionVO.java
*@FileTitle : BSA Creation/Update
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.17 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.17 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
* 2011.07.15 이행지 [CHM-201112101-01] Currency Code 추가
=========================================================*/

package com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaYearlyPlanConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaYearlyPlanConditionVO> models = new ArrayList<BsaYearlyPlanConditionVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String txtsdate = null;
	/* Column Info */
	private String txtedate = null;
	/* Column Info */
	private String jHeader = null;
	/* Column Info */
	private String sHeader = null;
	/* Column Info */
	private String cobtrade = null;
	/* Column Info */
	private String coblane = null;
	/* Column Info */
	private String cobdir = null;
	/* Column Info */
	private String cobcurr = null;
	/* Page Number */
	private String rdoopcd = null;
	/* Column Info */
	private String rdotype = null;
	/* Column Info */
	private String crrcd = null;
	/* Column Info */
	private String bsaopjbcd = null;
	/* Column Info */
	private String bsaopjbcd2 = null;
	

	/* Column Info */
	private String chkprd = null;
	private String txtyear = null;
	private String txtfmweek = null;
	private String txttoweek = null;
	private String txtfmmonth = null;
	private String txttomonth = null;
	private String txtvslCd = null;
	private String txtskdVoyNo = null;
	private String txtdirCd = null;
	private String cobioc = null;
	
	private String eventName = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaYearlyPlanConditionVO() {}

	public BsaYearlyPlanConditionVO(
			String ibflag, String pagerows, String txtsdate, String txtedate, 
			String jHeader, String sHeader, String cobtrade, String coblane, String cobdir, String cobcurr,
			String rdoopcd, String rdotype, String crrcd, String bsaopjbcd, String bsaopjbcd2,
			String chkprd, String txtyear, String txtfmweek, String txttoweek, String txtfmmonth, String txttomonth,
			String txtvslCd, String txtskdVoyNo, String txtdirCd, String cobioc) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.txtsdate = txtsdate;
		this.txtedate = txtedate;
		this.jHeader = jHeader;
		this.sHeader = sHeader;
		this.cobtrade = cobtrade;
		this.coblane = coblane;
		this.cobdir = cobdir;
		this.cobcurr = cobcurr;
		this.rdoopcd = rdoopcd;
		this.rdotype = rdotype;
		this.crrcd = crrcd;
		this.bsaopjbcd = bsaopjbcd;
		this.bsaopjbcd2 = bsaopjbcd2;
		
		this.chkprd = chkprd;
		this.txtyear = txtyear;
		this.txtfmweek = txtfmweek;
		this.txttoweek = txttoweek;
		this.txtfmmonth = txtfmmonth;
		this.txttomonth = txttomonth;
		this.txtvslCd = txtvslCd;
		this.txtskdVoyNo = txtskdVoyNo;
		this.txtdirCd = txtdirCd;
		this.cobioc = cobioc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("txtedate", getTxtedate());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("coblane", getCoblane());
		this.hashColumns.put("txtsdate", getTxtsdate());
		this.hashColumns.put("jheader", getJHeader());
		this.hashColumns.put("sheader", getSHeader());
		this.hashColumns.put("cobdir", getCobdir());
		this.hashColumns.put("cobcurr", getCobcurr());
		this.hashColumns.put("cobtrade", getCobtrade());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rdoopcd", getRdoopcd());
		this.hashColumns.put("rdotype", getRdotype());
		this.hashColumns.put("crrcd", getCrrcd());
		this.hashColumns.put("bsaopjbcd", getBsaopjbcd());
		this.hashColumns.put("bsaopjbcd2", getBsaopjbcd2());
		this.hashColumns.put("txtyear", getTxtyear());
		this.hashColumns.put("txtfmweek", getTxtfmweek());
		this.hashColumns.put("txttoweek", getTxttoweek());
		this.hashColumns.put("txtfmmonth", getTxtfmmonth());
		this.hashColumns.put("txttomonth", getTxttomonth());
		this.hashColumns.put("txtvslCd", getTxtvslCd());
		this.hashColumns.put("txtskdVoyNo", getTxtskdVoyNo());
		this.hashColumns.put("txtdirCd", getTxtdirCd());
		this.hashColumns.put("chkprd", getChkprd());
		this.hashColumns.put("cobioc", getCobioc());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("txtsdate", "txtsdate");
		this.hashFields.put("txtedate", "txtedate");
		this.hashFields.put("jheader", "jheader");
		this.hashFields.put("sheader", "sheader");
		this.hashFields.put("cobtrade", "cobtrade");
		this.hashFields.put("coblane", "coblane");
		this.hashFields.put("cobdir", "cobdir");
		this.hashFields.put("cobcurr", "cobcurr");
		this.hashFields.put("rdoopcd", "rdoopcd");
		this.hashFields.put("rdotype", "rdotype");
		this.hashFields.put("crrcd", "crrcd");
		this.hashFields.put("bsaopjbcd", "bsaopjbcd");
		this.hashFields.put("bsaopjbcd2", "bsaopjbcd2");
		
		this.hashFields.put("chkprd", "chkprd");		
		this.hashFields.put("txtyear", "txtyear");
		this.hashFields.put("txtfmweek", "txtfmweek");
		this.hashFields.put("txttoweek", "txttoweek");
		this.hashFields.put("txtfmmonth", "txtfmmonth");
		this.hashFields.put("txttomonth", "txttomonth");
		this.hashFields.put("txtvslCd", "txtvslCd");
		this.hashFields.put("txtskdVoyNo", "txtskdVoyNo");
		this.hashFields.put("txtdirCd", "txtdirCd");
		this.hashFields.put("cobioc", "cobioc");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return txtedate
	 */
	public String getTxtedate() {
		return this.txtedate;
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
	 * @return coblane
	 */
	public String getCoblane() {
		return this.coblane;
	}
		
	/**
	 * Column Info
	 * @return txtsdate
	 */
	public String getTxtsdate() {
		return this.txtsdate;
	}
	
	/**
	 * Column Info
	 * @return cobdir
	 */
	public String getCobdir() {
		return this.cobdir;
	}
	
	/**
	 * Column Info
	 * @return cobtrade
	 */
	public String getCobtrade() {
		return this.cobtrade;
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
	 * @param txtedate
	 */
	public void setTxtedate(String txtedate) {
		this.txtedate = txtedate;
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
	 * @param coblane
	 */
	public void setCoblane(String coblane) {
		this.coblane = coblane;
	}
	
	/**
	 * Column Info
	 * @param txtsdate
	 */
	public void setTxtsdate(String txtsdate) {
		this.txtsdate = txtsdate;
	}
	
	/**
	 * Column Info
	 * @param cobdir
	 */
	public void setCobdir(String cobdir) {
		this.cobdir = cobdir;
	}
	
	/**
	 * Column Info
	 * @param cobtrade
	 */
	public void setCobtrade(String cobtrade) {
		this.cobtrade = cobtrade;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	public String getRdoopcd() {
		return rdoopcd;
	}

	public void setRdoopcd(String rdoopcd) {
		this.rdoopcd = rdoopcd;
	}
	
	public String getRdotype() {
		return rdotype;
	}

	public void setRdotype(String rdotype) {
		this.rdotype = rdotype;
	}
	
	
	public String getCrrcd() {
		return crrcd;
	}

	public void setCrrcd(String crrcd) {
		this.crrcd = crrcd;
	}

	public String getBsaopjbcd() {
		return bsaopjbcd;
	}

	public void setBsaopjbcd(String bsaopjbcd) {
		this.bsaopjbcd = bsaopjbcd;
	}
	
	

	public String getTxtyear() {
		return txtyear;
	}

	public void setTxtyear(String txtyear) {
		this.txtyear = txtyear;
	}

	public String getTxtfmweek() {
		return txtfmweek;
	}

	public void setTxtfmweek(String txtfmweek) {
		this.txtfmweek = txtfmweek;
	}

	public String getTxttoweek() {
		return txttoweek;
	}

	public void setTxttoweek(String txttoweek) {
		this.txttoweek = txttoweek;
	}

	public String getTxtvslCd() {
		return txtvslCd;
	}

	public void setTxtvslCd(String txtvslCd) {
		this.txtvslCd = txtvslCd;
	}

	public String getTxtskdVoyNo() {
		return txtskdVoyNo;
	}

	public void setTxtskdVoyNo(String txtskdVoyNo) {
		this.txtskdVoyNo = txtskdVoyNo;
	}

	public String getTxtdirCd() {
		return txtdirCd;
	}

	public void setTxtdirCd(String txtdirCd) {
		this.txtdirCd = txtdirCd;
	}

	public String getChkprd() {
		return chkprd;
	}

	public void setChkprd(String chkprd) {
		this.chkprd = chkprd;
	}

	public String getCobioc() {
		return cobioc;
	}

	public void setCobioc(String cobioc) {
		this.cobioc = cobioc;
	}

	public String getJHeader() {
		return jHeader;
	}

	public void setJHeader(String header) {
		jHeader = header;
	}

	public String getSHeader() {
		return sHeader;
	}

	public void setSHeader(String sheader) {
		sHeader = sheader;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getBsaopjbcd2() {
		return bsaopjbcd2;
	}

	public void setBsaopjbcd2(String bsaopjbcd2) {
		this.bsaopjbcd2 = bsaopjbcd2;
	}

	public String getTxtfmmonth() {
		return txtfmmonth;
	}

	public void setTxtfmmonth(String txtfmmonth) {
		this.txtfmmonth = txtfmmonth;
	}

	public String getTxttomonth() {
		return txttomonth;
	}

	public void setTxttomonth(String txttomonth) {
		this.txttomonth = txttomonth;
	}

	
	/**
	 * Column Info
	 * @return cobcurr
	 */
	public String getCobcurr() {
		return this.cobcurr;
	}

	public void setCobcurr(String cobcurr) {
		this.cobcurr = cobcurr;
	}

	public Collection<BsaYearlyPlanConditionVO> getModels() {
		return models;
	}

	public void setModels(Collection<BsaYearlyPlanConditionVO> models) {
		this.models = models;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTxtsdate(JSPUtil.getParameter(request, "txtSDate", ""));
		setTxtedate(JSPUtil.getParameter(request, "txtEDate", ""));
		setJHeader(JSPUtil.getParameter(request, "jHeader", ""));
		setSHeader(JSPUtil.getParameter(request, "sHeader", ""));
		setCobtrade(JSPUtil.getParameter(request, "cobTrade", ""));
		setCoblane(JSPUtil.getParameter(request, "cobLane", ""));
		setCobdir(JSPUtil.getParameter(request, "cobDir", ""));
		setCobcurr(JSPUtil.getParameter(request, "cobCurr", ""));
		setRdoopcd(JSPUtil.getParameter(request, "rdoOp_cd", ""));
		setRdotype(JSPUtil.getParameter(request, "rdoType", ""));
		setCrrcd(JSPUtil.getParameter(request, "crr_cd", ""));
		setBsaopjbcd(JSPUtil.getParameter(request, "bsa_op_jb_cd", ""));
		setBsaopjbcd2(JSPUtil.getParameter(request, "bsa_op_jb_cd2", ""));
		
		setChkprd(JSPUtil.getParameter(request, "chkPrd", ""));
		setTxtyear(JSPUtil.getParameter(request, "txtYear", ""));
		setTxtfmweek(JSPUtil.getParameter(request, "txtFmWeek", ""));
		setTxttoweek(JSPUtil.getParameter(request, "txtToWeek", ""));
		setTxtfmmonth(JSPUtil.getParameter(request, "txtFmMonth", ""));
		setTxttomonth(JSPUtil.getParameter(request, "txtToMonth", ""));		
		setTxtvslCd(JSPUtil.getParameter(request, "txtVsl_cd", ""));		
		setTxtskdVoyNo(JSPUtil.getParameter(request, "txtSkd_voy_no", ""));
		setTxtdirCd(JSPUtil.getParameter(request, "txtDir_cd", ""));
		setCobioc(JSPUtil.getParameter(request, "cobIOC", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSlotPrcConditionVO[]
	 */
	public BsaYearlyPlanConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSlotPrcConditionVO[]
	 */
	public BsaYearlyPlanConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaYearlyPlanConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] txtedate = (JSPUtil.getParameter(request, prefix	+ "txtedate", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] jheader = (JSPUtil.getParameter(request, prefix	+ "jheader", length));
			String[] sheader = (JSPUtil.getParameter(request, prefix	+ "sheader", length));
			String[] coblane = (JSPUtil.getParameter(request, prefix	+ "coblane", length));
			String[] txtsdate = (JSPUtil.getParameter(request, prefix	+ "txtsdate", length));
			String[] bsaopjbcd = (JSPUtil.getParameter(request, prefix	+ "bsaopjbcd", length));
			String[] bsaopjbcd2 = (JSPUtil.getParameter(request, prefix	+ "bsaopjbcd2", length));
			String[] cobdir = (JSPUtil.getParameter(request, prefix	+ "cobdir", length));
			String[] cobtrade = (JSPUtil.getParameter(request, prefix	+ "cobtrade", length));
			String[] cobcurr = (JSPUtil.getParameter(request, prefix	+ "cobcurr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rdotype = (JSPUtil.getParameter(request, prefix	+ "rdotype", length));
			String[] crrcd = (JSPUtil.getParameter(request, prefix	+ "crrcd", length));			

			String[] chkprd = (JSPUtil.getParameter(request, prefix	+ "chkPrd", length));
			String[] txtyear = (JSPUtil.getParameter(request, prefix	+ "txtyear", length));
			String[] txtfmweek = (JSPUtil.getParameter(request, prefix	+ "txtfmweek", length));
			String[] txttoweek = (JSPUtil.getParameter(request, prefix	+ "txttoweek", length));
			String[] txtfmmonth = (JSPUtil.getParameter(request, prefix	+ "txtfmmonth", length));
			String[] txttomonth = (JSPUtil.getParameter(request, prefix	+ "txttomonth", length));
			String[] txtvslCd = (JSPUtil.getParameter(request, prefix	+ "txtvsl_cd", length));
			String[] txtskdVoyNo = (JSPUtil.getParameter(request, prefix	+ "txtskd_voy_no", length));
			String[] txtdirCd = (JSPUtil.getParameter(request, prefix	+ "txtdir_cd", length));
			String[] cobioc = (JSPUtil.getParameter(request, prefix	+ "cobioc", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new BsaYearlyPlanConditionVO();
				if (txtedate[i] != null)
					model.setTxtedate(txtedate[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (jheader[i] != null)
					model.setJHeader(jheader[i]);
				if (sheader[i] != null)
					model.setSHeader(sheader[i]);
				if (coblane[i] != null)
					model.setCoblane(coblane[i]);
				if (txtsdate[i] != null)
					model.setTxtsdate(txtsdate[i]);
				if (cobdir[i] != null)
					model.setCobdir(cobdir[i]);
				if (bsaopjbcd[i] != null)
					model.setBsaopjbcd(bsaopjbcd[i]);
				if (bsaopjbcd2[i] != null)
					model.setBsaopjbcd2(bsaopjbcd2[i]);
				if (cobtrade[i] != null)
					model.setCobtrade(cobtrade[i]);
				if (cobcurr[i] != null)
					model.setCobcurr(cobcurr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rdotype[i] != null)
					model.setRdotype(rdotype[i]);
				if (crrcd[i] != null)
					model.setCrrcd(crrcd[i]);

				if (chkprd[i] != null)
					model.setChkprd(chkprd[i]);
				if (txtyear[i] != null)
					model.setTxtyear(txtyear[i]);
				if (txtfmweek[i] != null)
					model.setTxtfmweek(txtfmweek[i]);
				if (txttoweek[i] != null)
					model.setTxttoweek(txttoweek[i]);
				if (txtfmmonth[i] != null)
					model.setTxtfmmonth(txtfmmonth[i]);
				if (txttomonth[i] != null)
					model.setTxttomonth(txttomonth[i]);
				if (txtvslCd[i] != null)
					model.setTxtvslCd(txtvslCd[i]);
				if (txtskdVoyNo[i] != null)
					model.setTxtskdVoyNo(txtskdVoyNo[i]);
				if (txtdirCd[i] != null)
					model.setTxtdirCd(txtdirCd[i]);
				if (cobioc[i] != null)
					model.setCobioc(cobioc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSlotPrcConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSlotPrcConditionVO[]
	 */
	public BsaYearlyPlanConditionVO[] getSearchSlotPrcConditionVOs(){
		BsaYearlyPlanConditionVO[] vos = (BsaYearlyPlanConditionVO[])models.toArray(new BsaYearlyPlanConditionVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtsdate = this.txtsdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtedate = this.txtedate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jHeader = this.jHeader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sHeader = this.sHeader .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coblane = this.coblane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobdir = this.cobdir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobtrade = this.cobtrade .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobcurr = this.cobcurr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdotype = this.rdotype .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrcd = this.crrcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaopjbcd = this.bsaopjbcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaopjbcd2 = this.bsaopjbcd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.chkprd = this.chkprd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtyear = this.txtyear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtfmweek = this.txtfmweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txttoweek = this.txttoweek .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtfmmonth = this.txtfmmonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txttomonth = this.txttomonth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtvslCd = this.txtvslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtskdVoyNo = this.txtskdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.txtdirCd = this.txtdirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cobioc = this.cobioc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}