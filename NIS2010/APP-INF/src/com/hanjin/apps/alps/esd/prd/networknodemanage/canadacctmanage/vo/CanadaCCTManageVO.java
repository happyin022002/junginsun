/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CanadaCCTManageVO.java
*@FileTitle : CanadaCCTManageVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.14
*@LastModifier : JunKun Lee
*@LastVersion : 1.0
* 2012.06.14 JunKun Lee
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author JunKun Lee
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CanadaCCTManageVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CanadaCCTManageVO> models = new ArrayList<CanadaCCTManageVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String arrThuDys = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String arrFriDys = null;
	/* Column Info */
	private String ltstRcvDyCd = null;
	/* Column Info */
	private String arrSunDys = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String arrMonDys = null;
	/* Column Info */
	private String eryRcvDyCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String arrTueDys = null;
	/* Column Info */
	private String arrSatDys = null;
	/* Column Info */
	private String rcvItvalDys = null;
	/* Column Info */
	private String arrWedDys = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String porNodCd = null;
	
	/* Column Info */
	private String cctHrmnt = null;
	private String usLtstRcvDyCd = null;
	private String usEryRcvDyCd = null;
	private String usRcvItvalDys = null;
	
	private String adjLtstRcvDyCd = null;
	private String usAdjLtstRcvDyCd = null;
  

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	/**
	 * 생성자
	 */
	public CanadaCCTManageVO() {}

	/**
	 * 생성자
	 * @param ibflag
	 * @param pagerows
	 * @param porCd
	 * @param polCd
	 * @param arrSunDys
	 * @param arrMonDys
	 * @param arrTueDys
	 * @param arrWedDys
	 * @param arrThuDys
	 * @param arrFriDys
	 * @param arrSatDys
	 * @param updUsrId
	 * @param updDt
	 * @param ltstRcvDyCd
	 * @param eryRcvDyCd
	 * @param rcvItvalDys
	 * @param creUsrId
	 * @param creDt
	 */
	public CanadaCCTManageVO(String ibflag, String pagerows, String porCd, String polCd, String arrSunDys, String arrMonDys, String arrTueDys, String arrWedDys, String arrThuDys, String arrFriDys, String arrSatDys, String updUsrId, String updDt, String ltstRcvDyCd, String eryRcvDyCd, String rcvItvalDys, String creUsrId, String creDt, String polNodCd, String cctHrmnt, String usLtstRcvDyCd, String usEryRcvDyCd , String usRcvItvalDys ,String adjLtstRcvDyCd, String usAdjLtstRcvDyCd, String porNodCd) {
		this.porCd = porCd;
		this.updDt = updDt;
		this.arrThuDys = arrThuDys;
		this.creDt = creDt;
		this.arrFriDys = arrFriDys;
		this.ltstRcvDyCd = ltstRcvDyCd;
		this.arrSunDys = arrSunDys;
		this.pagerows = pagerows;
		this.arrMonDys = arrMonDys;
		this.eryRcvDyCd = eryRcvDyCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.arrTueDys = arrTueDys;
		this.arrSatDys = arrSatDys;
		this.rcvItvalDys = rcvItvalDys;
		this.arrWedDys = arrWedDys;
		this.updUsrId = updUsrId;
		this.polNodCd = polNodCd;
		this.cctHrmnt  = cctHrmnt ;
		this.usLtstRcvDyCd   = usLtstRcvDyCd  ;
		this.usEryRcvDyCd   = usEryRcvDyCd  ;
		this.usRcvItvalDys   = usRcvItvalDys  ;
		this.adjLtstRcvDyCd   = adjLtstRcvDyCd  ;
		this.usAdjLtstRcvDyCd   = usAdjLtstRcvDyCd  ;
		this.porNodCd   = porNodCd  ;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("arr_thu_dys", getArrThuDys());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("arr_fri_dys", getArrFriDys());
		this.hashColumns.put("ltst_rcv_dy_cd", getLtstRcvDyCd());
		this.hashColumns.put("arr_sun_dys", getArrSunDys());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("arr_mon_dys", getArrMonDys());
		this.hashColumns.put("ery_rcv_dy_cd", getEryRcvDyCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("arr_tue_dys", getArrTueDys());
		this.hashColumns.put("arr_sat_dys", getArrSatDys());
		this.hashColumns.put("rcv_itval_dys", getRcvItvalDys());
		this.hashColumns.put("arr_wed_dys", getArrWedDys());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("cct_hrmnt", getCctHrmnt ());
		this.hashColumns.put("us_ltst_rcv_dy_cd", getUsLtstRcvDyCd  ());
		this.hashColumns.put("us_ery_rcv_dy_cd", getUsEryRcvDyCd  ());
		this.hashColumns.put("us_rcv_itval_dys", getUsRcvItvalDys  ());
		this.hashColumns.put("adj_ltst_rcv_dy_cd", getAdjLtstRcvDyCd  ());
		this.hashColumns.put("us_adj_ltst_rcv_dy_cd", getUsAdjLtstRcvDyCd  ());
		this.hashColumns.put("por_nod_cd", getPorNodCd  ());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("arr_thu_dys", "arrThuDys");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("arr_fri_dys", "arrFriDys");
		this.hashFields.put("ltst_rcv_dy_cd", "ltstRcvDyCd");
		this.hashFields.put("arr_sun_dys", "arrSunDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("arr_mon_dys", "arrMonDys");
		this.hashFields.put("ery_rcv_dy_cd", "eryRcvDyCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("arr_tue_dys", "arrTueDys");
		this.hashFields.put("arr_sat_dys", "arrSatDys");
		this.hashFields.put("rcv_itval_dys", "rcvItvalDys");
		this.hashFields.put("arr_wed_dys", "arrWedDys");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("cct_hrmnt", "cctHrmnt");
		this.hashFields.put("us_ltst_rcv_dy_cd", "usLtstRcvDyCd");
		this.hashFields.put("us_ery_rcv_dy_cd", "usEryRcvDyCd");
		this.hashFields.put("us_rcv_itval_dys", "usRcvItvalDys");
		this.hashFields.put("adj_ltst_rcv_dy_cd", "adjLtstRcvDyCd");
		this.hashFields.put("us_adj_ltst_rcv_dy_cd", "usAdjLtstRcvDyCd");
		this.hashFields.put("por_nod_cd", "porNodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return arrThuDys
	 */
	public String getArrThuDys() {
		return this.arrThuDys;
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
	 * @return arrFriDys
	 */
	public String getArrFriDys() {
		return this.arrFriDys;
	}
	
	/**
	 * Column Info
	 * @return ltstRcvDyCd
	 */
	public String getLtstRcvDyCd() {
		return this.ltstRcvDyCd;
	}
	
	/**
	 * Column Info
	 * @return arrSunDys
	 */
	public String getArrSunDys() {
		return this.arrSunDys;
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
	 * @return arrMonDys
	 */
	public String getArrMonDys() {
		return this.arrMonDys;
	}
	
	/**
	 * Column Info
	 * @return eryRcvDyCd
	 */
	public String getEryRcvDyCd() {
		return this.eryRcvDyCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return arrTueDys
	 */
	public String getArrTueDys() {
		return this.arrTueDys;
	}
	
	/**
	 * Column Info
	 * @return arrSatDys
	 */
	public String getArrSatDys() {
		return this.arrSatDys;
	}
	
	/**
	 * Column Info
	 * @return rcvItvalDys
	 */
	public String getRcvItvalDys() {
		return this.rcvItvalDys;
	}
	
	/**
	 * Column Info
	 * @return arrWedDys
	 */
	public String getArrWedDys() {
		return this.arrWedDys;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	public String getPolNodCd() {
		return polNodCd;
	}

	public String getCctHrmnt() {
		return cctHrmnt;
	}

	public String getUsLtstRcvDyCd() {
		return usLtstRcvDyCd;
	}

	public void setUsLtstRcvDyCd(String usLtstRcvDyCd) {
		this.usLtstRcvDyCd = usLtstRcvDyCd;
	}

	public String getUsEryRcvDyCd() {
		return usEryRcvDyCd;
	}

	public void setUsEryRcvDyCd(String usEryRcvDyCd) {
		this.usEryRcvDyCd = usEryRcvDyCd;
	}

	public String getUsRcvItvalDys() {
		return usRcvItvalDys;
	}

	public String getAdjLtstRcvDyCd() {
		return adjLtstRcvDyCd;
	}

	public void setAdjLtstRcvDyCd(String adjLtstRcvDyCd) {
		this.adjLtstRcvDyCd = adjLtstRcvDyCd;
	}

	public String getUsAdjLtstRcvDyCd() {
		return usAdjLtstRcvDyCd;
	}

	public String getPorNodCd() {
		return porNodCd;
	}

	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}

	public void setUsAdjLtstRcvDyCd(String usAdjLtstRcvDyCd) {
		this.usAdjLtstRcvDyCd = usAdjLtstRcvDyCd;
	}

	public void setUsRcvItvalDys(String usRcvItvalDys) {
		this.usRcvItvalDys = usRcvItvalDys;
	}

	public void setCctHrmnt(String cctHrmnt) {
		this.cctHrmnt = cctHrmnt;
	}

	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param arrThuDys
	 */
	public void setArrThuDys(String arrThuDys) {
		this.arrThuDys = arrThuDys;
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
	 * @param arrFriDys
	 */
	public void setArrFriDys(String arrFriDys) {
		this.arrFriDys = arrFriDys;
	}
	
	/**
	 * Column Info
	 * @param ltstRcvDyCd
	 */
	public void setLtstRcvDyCd(String ltstRcvDyCd) {
		this.ltstRcvDyCd = ltstRcvDyCd;
	}
	
	/**
	 * Column Info
	 * @param arrSunDys
	 */
	public void setArrSunDys(String arrSunDys) {
		this.arrSunDys = arrSunDys;
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
	 * @param arrMonDys
	 */
	public void setArrMonDys(String arrMonDys) {
		this.arrMonDys = arrMonDys;
	}
	
	/**
	 * Column Info
	 * @param eryRcvDyCd
	 */
	public void setEryRcvDyCd(String eryRcvDyCd) {
		this.eryRcvDyCd = eryRcvDyCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param arrTueDys
	 */
	public void setArrTueDys(String arrTueDys) {
		this.arrTueDys = arrTueDys;
	}
	
	/**
	 * Column Info
	 * @param arrSatDys
	 */
	public void setArrSatDys(String arrSatDys) {
		this.arrSatDys = arrSatDys;
	}
	
	/**
	 * Column Info
	 * @param rcvItvalDys
	 */
	public void setRcvItvalDys(String rcvItvalDys) {
		this.rcvItvalDys = rcvItvalDys;
	}
	
	/**
	 * Column Info
	 * @param arrWedDys
	 */
	public void setArrWedDys(String arrWedDys) {
		this.arrWedDys = arrWedDys;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setArrThuDys(JSPUtil.getParameter(request, prefix + "arr_thu_dys", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setArrFriDys(JSPUtil.getParameter(request, prefix + "arr_fri_dys", ""));
		setLtstRcvDyCd(JSPUtil.getParameter(request, prefix + "ltst_rcv_dy_cd", ""));
		setArrSunDys(JSPUtil.getParameter(request, prefix + "arr_sun_dys", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setArrMonDys(JSPUtil.getParameter(request, prefix + "arr_mon_dys", ""));
		setEryRcvDyCd(JSPUtil.getParameter(request, prefix + "ery_rcv_dy_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setArrTueDys(JSPUtil.getParameter(request, prefix + "arr_tue_dys", ""));
		setArrSatDys(JSPUtil.getParameter(request, prefix + "arr_sat_dys", ""));
		setRcvItvalDys(JSPUtil.getParameter(request, prefix + "rcv_itval_dys", ""));
		setArrWedDys(JSPUtil.getParameter(request, prefix + "arr_wed_dys", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setCctHrmnt(JSPUtil.getParameter(request, prefix + "cct_hrmnt", ""));
		setUsLtstRcvDyCd (JSPUtil.getParameter(request, prefix + "us_ltst_rcv_dy_cd", ""));
		setUsEryRcvDyCd (JSPUtil.getParameter(request, prefix + "us_ery_rcv_dy_cd", ""));
		setUsRcvItvalDys (JSPUtil.getParameter(request, prefix + "us_rcv_itval_dys", ""));
		setAdjLtstRcvDyCd (JSPUtil.getParameter(request, prefix + "adj_ltst_rcv_dy_cd", ""));
		setUsAdjLtstRcvDyCd (JSPUtil.getParameter(request, prefix + "us_adj_ltst_rcv_dy_cd", ""));
		setPorNodCd (JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CanadaCCTManageVO[]
	 */
	public CanadaCCTManageVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CanadaCCTManageVO[]
	 */
	public CanadaCCTManageVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CanadaCCTManageVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] arrThuDys = (JSPUtil.getParameter(request, prefix	+ "arr_thu_dys", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] arrFriDys = (JSPUtil.getParameter(request, prefix	+ "arr_fri_dys", length));
			String[] ltstRcvDyCd = (JSPUtil.getParameter(request, prefix	+ "ltst_rcv_dy_cd", length));
			String[] arrSunDys = (JSPUtil.getParameter(request, prefix	+ "arr_sun_dys", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] arrMonDys = (JSPUtil.getParameter(request, prefix	+ "arr_mon_dys", length));
			String[] eryRcvDyCd = (JSPUtil.getParameter(request, prefix	+ "ery_rcv_dy_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] arrTueDys = (JSPUtil.getParameter(request, prefix	+ "arr_tue_dys", length));
			String[] arrSatDys = (JSPUtil.getParameter(request, prefix	+ "arr_sat_dys", length));
			String[] rcvItvalDys = (JSPUtil.getParameter(request, prefix	+ "rcv_itval_dys", length));
			String[] arrWedDys = (JSPUtil.getParameter(request, prefix	+ "arr_wed_dys", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] cctHrmnt = (JSPUtil.getParameter(request, prefix	+ "cct_hrmnt", length));
			String[] usLtstRcvDyCd = (JSPUtil.getParameter(request, prefix	+ "us_ltst_rcv_dy_cd", length));
			String[] usEryRcvDyCd  = (JSPUtil.getParameter(request, prefix	+ "us_ery_rcv_dy_cd", length));
			String[] usRcvItvalDys  = (JSPUtil.getParameter(request, prefix	+ "us_rcv_itval_dys", length));
			String[] adjLtstRcvDyCd  = (JSPUtil.getParameter(request, prefix	+ "adj_ltst_rcv_dy_cd", length));
			String[] usAdjLtstRcvDyCd  = (JSPUtil.getParameter(request, prefix	+ "us_adj_ltst_rcv_dy_cd", length));
			String[] porNodCd  = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CanadaCCTManageVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (arrThuDys[i] != null)
					model.setArrThuDys(arrThuDys[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (arrFriDys[i] != null)
					model.setArrFriDys(arrFriDys[i]);
				if (ltstRcvDyCd[i] != null)
					model.setLtstRcvDyCd(ltstRcvDyCd[i]);
				if (arrSunDys[i] != null)
					model.setArrSunDys(arrSunDys[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (arrMonDys[i] != null)
					model.setArrMonDys(arrMonDys[i]);
				if (eryRcvDyCd[i] != null)
					model.setEryRcvDyCd(eryRcvDyCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (arrTueDys[i] != null)
					model.setArrTueDys(arrTueDys[i]);
				if (arrSatDys[i] != null)
					model.setArrSatDys(arrSatDys[i]);
				if (rcvItvalDys[i] != null)
					model.setRcvItvalDys(rcvItvalDys[i]);
				if (arrWedDys[i] != null)
					model.setArrWedDys(arrWedDys[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);				
				if (cctHrmnt[i] != null)
					model.setCctHrmnt(cctHrmnt[i]);				
				if (usLtstRcvDyCd [i] != null)
					model.setUsLtstRcvDyCd (usLtstRcvDyCd [i]);				
				if (usEryRcvDyCd [i] != null)
					model.setUsEryRcvDyCd (usEryRcvDyCd [i]);				
				if (usRcvItvalDys [i] != null)
					model.setUsRcvItvalDys (usRcvItvalDys [i]);				
				if (adjLtstRcvDyCd [i] != null)
					model.setAdjLtstRcvDyCd (adjLtstRcvDyCd [i]);				
				if (usAdjLtstRcvDyCd [i] != null)
					model.setUsAdjLtstRcvDyCd (usAdjLtstRcvDyCd [i]);				
				if (porNodCd [i] != null)
					model.setPorNodCd (porNodCd [i]);				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCanadaCCTManageVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CanadaCCTManageVO[]
	 */
	public CanadaCCTManageVO[] getCanadaCCTManageVOs(){
		CanadaCCTManageVO[] vos = (CanadaCCTManageVO[])models.toArray(new CanadaCCTManageVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrThuDys = this.arrThuDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrFriDys = this.arrFriDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltstRcvDyCd = this.ltstRcvDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrSunDys = this.arrSunDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrMonDys = this.arrMonDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eryRcvDyCd = this.eryRcvDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrTueDys = this.arrTueDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrSatDys = this.arrSatDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvItvalDys = this.rcvItvalDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrWedDys = this.arrWedDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctHrmnt = this.cctHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usLtstRcvDyCd  = this.usLtstRcvDyCd  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usEryRcvDyCd  = this.usEryRcvDyCd  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usRcvItvalDys  = this.usRcvItvalDys  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjLtstRcvDyCd  = this.adjLtstRcvDyCd  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usAdjLtstRcvDyCd  = this.usAdjLtstRcvDyCd  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd  = this.porNodCd  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
