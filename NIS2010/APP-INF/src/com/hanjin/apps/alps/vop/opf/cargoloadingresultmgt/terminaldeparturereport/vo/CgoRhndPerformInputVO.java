/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgoRhndPerformInputVO.java
*@FileTitle : CgoRhndPerformInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.08.07 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CgoRhndPerformInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CgoRhndPerformInputVO> models = new ArrayList<CgoRhndPerformInputVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String rsnIt = null;
	/* Column Info */
	private String rsnIw = null;
	/* Column Info */
	private String tl = null;
	/* Column Info */
	private String rsnIx = null;
	/* Column Info */
	private String othRhMove = null;
	/* Column Info */
	private String rsnIl = null;
	/* Column Info */
	private String rsnIo = null;
	/* Column Info */
	private String othRhUnit = null;
	/* Column Info */
	private String rsnIp = null;
	/* Column Info */
	private String hjsRhUnit = null;
	/* Column Info */
	private String rsnIs = null;
	/* Column Info */
	private String rsnIr = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rsnId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rsnIf = null;
	/* Column Info */
	private String fl = null;
	/* Column Info */
	private String rsnIg = null;
	/* Column Info */
	private String rsnIh = null;
	/* Column Info */
	private String rhUnitRatio = null;
	/* Column Info */
	private String rsnXx = null;
	/* Column Info */
	private String hjsRhMove = null;
	/* Column Info */
	private String opr = null;
	/* Column Info */
	private String rsnIc = null;
	/* Column Info */
	private String mt = null;
	/* Column Info */
	private String rsnCc = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ccMove = null;
	/* Column Info */
	private String cdcMove = null;
	/* Column Info */
	private String rhMoveRatio = null;
	/* Column Info */
	private String rsnCr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CgoRhndPerformInputVO() {}

	public CgoRhndPerformInputVO(String ibflag, String pagerows, String port, String lane, String vvd, String opr, String fl, String mt, String tl, String hjsRhUnit, String othRhUnit, String hjsRhMove, String othRhMove, String ccMove, String cdcMove, String rhUnitRatio, String rhMoveRatio, String rsnCc, String rsnCr, String rsnIc, String rsnId, String rsnIf, String rsnIg, String rsnIh, String rsnIl, String rsnIo, String rsnIp, String rsnIr, String rsnIs, String rsnIt, String rsnIw, String rsnIx, String rsnXx) {
		this.port = port;
		this.rsnIt = rsnIt;
		this.rsnIw = rsnIw;
		this.tl = tl;
		this.rsnIx = rsnIx;
		this.othRhMove = othRhMove;
		this.rsnIl = rsnIl;
		this.rsnIo = rsnIo;
		this.othRhUnit = othRhUnit;
		this.rsnIp = rsnIp;
		this.hjsRhUnit = hjsRhUnit;
		this.rsnIs = rsnIs;
		this.rsnIr = rsnIr;
		this.lane = lane;
		this.pagerows = pagerows;
		this.rsnId = rsnId;
		this.ibflag = ibflag;
		this.rsnIf = rsnIf;
		this.fl = fl;
		this.rsnIg = rsnIg;
		this.rsnIh = rsnIh;
		this.rhUnitRatio = rhUnitRatio;
		this.rsnXx = rsnXx;
		this.hjsRhMove = hjsRhMove;
		this.opr = opr;
		this.rsnIc = rsnIc;
		this.mt = mt;
		this.rsnCc = rsnCc;
		this.vvd = vvd;
		this.ccMove = ccMove;
		this.cdcMove = cdcMove;
		this.rhMoveRatio = rhMoveRatio;
		this.rsnCr = rsnCr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("rsn_it", getRsnIt());
		this.hashColumns.put("rsn_iw", getRsnIw());
		this.hashColumns.put("tl", getTl());
		this.hashColumns.put("rsn_ix", getRsnIx());
		this.hashColumns.put("oth_rh_move", getOthRhMove());
		this.hashColumns.put("rsn_il", getRsnIl());
		this.hashColumns.put("rsn_io", getRsnIo());
		this.hashColumns.put("oth_rh_unit", getOthRhUnit());
		this.hashColumns.put("rsn_ip", getRsnIp());
		this.hashColumns.put("hjs_rh_unit", getHjsRhUnit());
		this.hashColumns.put("rsn_is", getRsnIs());
		this.hashColumns.put("rsn_ir", getRsnIr());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rsn_id", getRsnId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rsn_if", getRsnIf());
		this.hashColumns.put("fl", getFl());
		this.hashColumns.put("rsn_ig", getRsnIg());
		this.hashColumns.put("rsn_ih", getRsnIh());
		this.hashColumns.put("rh_unit_ratio", getRhUnitRatio());
		this.hashColumns.put("rsn_xx", getRsnXx());
		this.hashColumns.put("hjs_rh_move", getHjsRhMove());
		this.hashColumns.put("opr", getOpr());
		this.hashColumns.put("rsn_ic", getRsnIc());
		this.hashColumns.put("mt", getMt());
		this.hashColumns.put("rsn_cc", getRsnCc());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cc_move", getCcMove());
		this.hashColumns.put("cdc_move", getCdcMove());
		this.hashColumns.put("rh_move_ratio", getRhMoveRatio());
		this.hashColumns.put("rsn_cr", getRsnCr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("rsn_it", "rsnIt");
		this.hashFields.put("rsn_iw", "rsnIw");
		this.hashFields.put("tl", "tl");
		this.hashFields.put("rsn_ix", "rsnIx");
		this.hashFields.put("oth_rh_move", "othRhMove");
		this.hashFields.put("rsn_il", "rsnIl");
		this.hashFields.put("rsn_io", "rsnIo");
		this.hashFields.put("oth_rh_unit", "othRhUnit");
		this.hashFields.put("rsn_ip", "rsnIp");
		this.hashFields.put("hjs_rh_unit", "hjsRhUnit");
		this.hashFields.put("rsn_is", "rsnIs");
		this.hashFields.put("rsn_ir", "rsnIr");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rsn_id", "rsnId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rsn_if", "rsnIf");
		this.hashFields.put("fl", "fl");
		this.hashFields.put("rsn_ig", "rsnIg");
		this.hashFields.put("rsn_ih", "rsnIh");
		this.hashFields.put("rh_unit_ratio", "rhUnitRatio");
		this.hashFields.put("rsn_xx", "rsnXx");
		this.hashFields.put("hjs_rh_move", "hjsRhMove");
		this.hashFields.put("opr", "opr");
		this.hashFields.put("rsn_ic", "rsnIc");
		this.hashFields.put("mt", "mt");
		this.hashFields.put("rsn_cc", "rsnCc");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cc_move", "ccMove");
		this.hashFields.put("cdc_move", "cdcMove");
		this.hashFields.put("rh_move_ratio", "rhMoveRatio");
		this.hashFields.put("rsn_cr", "rsnCr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return rsnIt
	 */
	public String getRsnIt() {
		return this.rsnIt;
	}
	
	/**
	 * Column Info
	 * @return rsnIw
	 */
	public String getRsnIw() {
		return this.rsnIw;
	}
	
	/**
	 * Column Info
	 * @return tl
	 */
	public String getTl() {
		return this.tl;
	}
	
	/**
	 * Column Info
	 * @return rsnIx
	 */
	public String getRsnIx() {
		return this.rsnIx;
	}
	
	/**
	 * Column Info
	 * @return othRhMove
	 */
	public String getOthRhMove() {
		return this.othRhMove;
	}
	
	/**
	 * Column Info
	 * @return rsnIl
	 */
	public String getRsnIl() {
		return this.rsnIl;
	}
	
	/**
	 * Column Info
	 * @return rsnIo
	 */
	public String getRsnIo() {
		return this.rsnIo;
	}
	
	/**
	 * Column Info
	 * @return othRhUnit
	 */
	public String getOthRhUnit() {
		return this.othRhUnit;
	}
	
	/**
	 * Column Info
	 * @return rsnIp
	 */
	public String getRsnIp() {
		return this.rsnIp;
	}
	
	/**
	 * Column Info
	 * @return hjsRhUnit
	 */
	public String getHjsRhUnit() {
		return this.hjsRhUnit;
	}
	
	/**
	 * Column Info
	 * @return rsnIs
	 */
	public String getRsnIs() {
		return this.rsnIs;
	}
	
	/**
	 * Column Info
	 * @return rsnIr
	 */
	public String getRsnIr() {
		return this.rsnIr;
	}
	
	/**
	 * Column Info
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
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
	 * @return rsnId
	 */
	public String getRsnId() {
		return this.rsnId;
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
	 * @return rsnIf
	 */
	public String getRsnIf() {
		return this.rsnIf;
	}
	
	/**
	 * Column Info
	 * @return fl
	 */
	public String getFl() {
		return this.fl;
	}
	
	/**
	 * Column Info
	 * @return rsnIg
	 */
	public String getRsnIg() {
		return this.rsnIg;
	}
	
	/**
	 * Column Info
	 * @return rsnIh
	 */
	public String getRsnIh() {
		return this.rsnIh;
	}
	
	/**
	 * Column Info
	 * @return rhUnitRatio
	 */
	public String getRhUnitRatio() {
		return this.rhUnitRatio;
	}
	
	/**
	 * Column Info
	 * @return rsnXx
	 */
	public String getRsnXx() {
		return this.rsnXx;
	}
	
	/**
	 * Column Info
	 * @return hjsRhMove
	 */
	public String getHjsRhMove() {
		return this.hjsRhMove;
	}
	
	/**
	 * Column Info
	 * @return opr
	 */
	public String getOpr() {
		return this.opr;
	}
	
	/**
	 * Column Info
	 * @return rsnIc
	 */
	public String getRsnIc() {
		return this.rsnIc;
	}
	
	/**
	 * Column Info
	 * @return mt
	 */
	public String getMt() {
		return this.mt;
	}
	
	/**
	 * Column Info
	 * @return rsnCc
	 */
	public String getRsnCc() {
		return this.rsnCc;
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
	 * @return ccMove
	 */
	public String getCcMove() {
		return this.ccMove;
	}
	
	/**
	 * Column Info
	 * @return cdcMove
	 */
	public String getCdcMove() {
		return this.cdcMove;
	}
	
	/**
	 * Column Info
	 * @return rhMoveRatio
	 */
	public String getRhMoveRatio() {
		return this.rhMoveRatio;
	}
	
	/**
	 * Column Info
	 * @return rsnCr
	 */
	public String getRsnCr() {
		return this.rsnCr;
	}
	

	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param rsnIt
	 */
	public void setRsnIt(String rsnIt) {
		this.rsnIt = rsnIt;
	}
	
	/**
	 * Column Info
	 * @param rsnIw
	 */
	public void setRsnIw(String rsnIw) {
		this.rsnIw = rsnIw;
	}
	
	/**
	 * Column Info
	 * @param tl
	 */
	public void setTl(String tl) {
		this.tl = tl;
	}
	
	/**
	 * Column Info
	 * @param rsnIx
	 */
	public void setRsnIx(String rsnIx) {
		this.rsnIx = rsnIx;
	}
	
	/**
	 * Column Info
	 * @param othRhMove
	 */
	public void setOthRhMove(String othRhMove) {
		this.othRhMove = othRhMove;
	}
	
	/**
	 * Column Info
	 * @param rsnIl
	 */
	public void setRsnIl(String rsnIl) {
		this.rsnIl = rsnIl;
	}
	
	/**
	 * Column Info
	 * @param rsnIo
	 */
	public void setRsnIo(String rsnIo) {
		this.rsnIo = rsnIo;
	}
	
	/**
	 * Column Info
	 * @param othRhUnit
	 */
	public void setOthRhUnit(String othRhUnit) {
		this.othRhUnit = othRhUnit;
	}
	
	/**
	 * Column Info
	 * @param rsnIp
	 */
	public void setRsnIp(String rsnIp) {
		this.rsnIp = rsnIp;
	}
	
	/**
	 * Column Info
	 * @param hjsRhUnit
	 */
	public void setHjsRhUnit(String hjsRhUnit) {
		this.hjsRhUnit = hjsRhUnit;
	}
	
	/**
	 * Column Info
	 * @param rsnIs
	 */
	public void setRsnIs(String rsnIs) {
		this.rsnIs = rsnIs;
	}
	
	/**
	 * Column Info
	 * @param rsnIr
	 */
	public void setRsnIr(String rsnIr) {
		this.rsnIr = rsnIr;
	}
	
	/**
	 * Column Info
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
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
	 * @param rsnId
	 */
	public void setRsnId(String rsnId) {
		this.rsnId = rsnId;
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
	 * @param rsnIf
	 */
	public void setRsnIf(String rsnIf) {
		this.rsnIf = rsnIf;
	}
	
	/**
	 * Column Info
	 * @param fl
	 */
	public void setFl(String fl) {
		this.fl = fl;
	}
	
	/**
	 * Column Info
	 * @param rsnIg
	 */
	public void setRsnIg(String rsnIg) {
		this.rsnIg = rsnIg;
	}
	
	/**
	 * Column Info
	 * @param rsnIh
	 */
	public void setRsnIh(String rsnIh) {
		this.rsnIh = rsnIh;
	}
	
	/**
	 * Column Info
	 * @param rhUnitRatio
	 */
	public void setRhUnitRatio(String rhUnitRatio) {
		this.rhUnitRatio = rhUnitRatio;
	}
	
	/**
	 * Column Info
	 * @param rsnXx
	 */
	public void setRsnXx(String rsnXx) {
		this.rsnXx = rsnXx;
	}
	
	/**
	 * Column Info
	 * @param hjsRhMove
	 */
	public void setHjsRhMove(String hjsRhMove) {
		this.hjsRhMove = hjsRhMove;
	}
	
	/**
	 * Column Info
	 * @param opr
	 */
	public void setOpr(String opr) {
		this.opr = opr;
	}
	
	/**
	 * Column Info
	 * @param rsnIc
	 */
	public void setRsnIc(String rsnIc) {
		this.rsnIc = rsnIc;
	}
	
	/**
	 * Column Info
	 * @param mt
	 */
	public void setMt(String mt) {
		this.mt = mt;
	}
	
	/**
	 * Column Info
	 * @param rsnCc
	 */
	public void setRsnCc(String rsnCc) {
		this.rsnCc = rsnCc;
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
	 * @param ccMove
	 */
	public void setCcMove(String ccMove) {
		this.ccMove = ccMove;
	}
	
	/**
	 * Column Info
	 * @param cdcMove
	 */
	public void setCdcMove(String cdcMove) {
		this.cdcMove = cdcMove;
	}
	
	/**
	 * Column Info
	 * @param rhMoveRatio
	 */
	public void setRhMoveRatio(String rhMoveRatio) {
		this.rhMoveRatio = rhMoveRatio;
	}
	
	/**
	 * Column Info
	 * @param rsnCr
	 */
	public void setRsnCr(String rsnCr) {
		this.rsnCr = rsnCr;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPort(JSPUtil.getParameter(request, "port", ""));
		setRsnIt(JSPUtil.getParameter(request, "rsn_it", ""));
		setRsnIw(JSPUtil.getParameter(request, "rsn_iw", ""));
		setTl(JSPUtil.getParameter(request, "tl", ""));
		setRsnIx(JSPUtil.getParameter(request, "rsn_ix", ""));
		setOthRhMove(JSPUtil.getParameter(request, "oth_rh_move", ""));
		setRsnIl(JSPUtil.getParameter(request, "rsn_il", ""));
		setRsnIo(JSPUtil.getParameter(request, "rsn_io", ""));
		setOthRhUnit(JSPUtil.getParameter(request, "oth_rh_unit", ""));
		setRsnIp(JSPUtil.getParameter(request, "rsn_ip", ""));
		setHjsRhUnit(JSPUtil.getParameter(request, "hjs_rh_unit", ""));
		setRsnIs(JSPUtil.getParameter(request, "rsn_is", ""));
		setRsnIr(JSPUtil.getParameter(request, "rsn_ir", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRsnId(JSPUtil.getParameter(request, "rsn_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRsnIf(JSPUtil.getParameter(request, "rsn_if", ""));
		setFl(JSPUtil.getParameter(request, "fl", ""));
		setRsnIg(JSPUtil.getParameter(request, "rsn_ig", ""));
		setRsnIh(JSPUtil.getParameter(request, "rsn_ih", ""));
		setRhUnitRatio(JSPUtil.getParameter(request, "rh_unit_ratio", ""));
		setRsnXx(JSPUtil.getParameter(request, "rsn_xx", ""));
		setHjsRhMove(JSPUtil.getParameter(request, "hjs_rh_move", ""));
		setOpr(JSPUtil.getParameter(request, "opr", ""));
		setRsnIc(JSPUtil.getParameter(request, "rsn_ic", ""));
		setMt(JSPUtil.getParameter(request, "mt", ""));
		setRsnCc(JSPUtil.getParameter(request, "rsn_cc", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCcMove(JSPUtil.getParameter(request, "cc_move", ""));
		setCdcMove(JSPUtil.getParameter(request, "cdc_move", ""));
		setRhMoveRatio(JSPUtil.getParameter(request, "rh_move_ratio", ""));
		setRsnCr(JSPUtil.getParameter(request, "rsn_cr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CgoRhndPerformInputVO[]
	 */
	public CgoRhndPerformInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CgoRhndPerformInputVO[]
	 */
	public CgoRhndPerformInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CgoRhndPerformInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] rsnIt = (JSPUtil.getParameter(request, prefix	+ "rsn_it", length));
			String[] rsnIw = (JSPUtil.getParameter(request, prefix	+ "rsn_iw", length));
			String[] tl = (JSPUtil.getParameter(request, prefix	+ "tl", length));
			String[] rsnIx = (JSPUtil.getParameter(request, prefix	+ "rsn_ix", length));
			String[] othRhMove = (JSPUtil.getParameter(request, prefix	+ "oth_rh_move", length));
			String[] rsnIl = (JSPUtil.getParameter(request, prefix	+ "rsn_il", length));
			String[] rsnIo = (JSPUtil.getParameter(request, prefix	+ "rsn_io", length));
			String[] othRhUnit = (JSPUtil.getParameter(request, prefix	+ "oth_rh_unit", length));
			String[] rsnIp = (JSPUtil.getParameter(request, prefix	+ "rsn_ip", length));
			String[] hjsRhUnit = (JSPUtil.getParameter(request, prefix	+ "hjs_rh_unit", length));
			String[] rsnIs = (JSPUtil.getParameter(request, prefix	+ "rsn_is", length));
			String[] rsnIr = (JSPUtil.getParameter(request, prefix	+ "rsn_ir", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rsnId = (JSPUtil.getParameter(request, prefix	+ "rsn_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rsnIf = (JSPUtil.getParameter(request, prefix	+ "rsn_if", length));
			String[] fl = (JSPUtil.getParameter(request, prefix	+ "fl", length));
			String[] rsnIg = (JSPUtil.getParameter(request, prefix	+ "rsn_ig", length));
			String[] rsnIh = (JSPUtil.getParameter(request, prefix	+ "rsn_ih", length));
			String[] rhUnitRatio = (JSPUtil.getParameter(request, prefix	+ "rh_unit_ratio", length));
			String[] rsnXx = (JSPUtil.getParameter(request, prefix	+ "rsn_xx", length));
			String[] hjsRhMove = (JSPUtil.getParameter(request, prefix	+ "hjs_rh_move", length));
			String[] opr = (JSPUtil.getParameter(request, prefix	+ "opr", length));
			String[] rsnIc = (JSPUtil.getParameter(request, prefix	+ "rsn_ic", length));
			String[] mt = (JSPUtil.getParameter(request, prefix	+ "mt", length));
			String[] rsnCc = (JSPUtil.getParameter(request, prefix	+ "rsn_cc", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ccMove = (JSPUtil.getParameter(request, prefix	+ "cc_move", length));
			String[] cdcMove = (JSPUtil.getParameter(request, prefix	+ "cdc_move", length));
			String[] rhMoveRatio = (JSPUtil.getParameter(request, prefix	+ "rh_move_ratio", length));
			String[] rsnCr = (JSPUtil.getParameter(request, prefix	+ "rsn_cr", length));
			
			for (int i = 0; i < length; i++) {
				model = new CgoRhndPerformInputVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (rsnIt[i] != null)
					model.setRsnIt(rsnIt[i]);
				if (rsnIw[i] != null)
					model.setRsnIw(rsnIw[i]);
				if (tl[i] != null)
					model.setTl(tl[i]);
				if (rsnIx[i] != null)
					model.setRsnIx(rsnIx[i]);
				if (othRhMove[i] != null)
					model.setOthRhMove(othRhMove[i]);
				if (rsnIl[i] != null)
					model.setRsnIl(rsnIl[i]);
				if (rsnIo[i] != null)
					model.setRsnIo(rsnIo[i]);
				if (othRhUnit[i] != null)
					model.setOthRhUnit(othRhUnit[i]);
				if (rsnIp[i] != null)
					model.setRsnIp(rsnIp[i]);
				if (hjsRhUnit[i] != null)
					model.setHjsRhUnit(hjsRhUnit[i]);
				if (rsnIs[i] != null)
					model.setRsnIs(rsnIs[i]);
				if (rsnIr[i] != null)
					model.setRsnIr(rsnIr[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rsnId[i] != null)
					model.setRsnId(rsnId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rsnIf[i] != null)
					model.setRsnIf(rsnIf[i]);
				if (fl[i] != null)
					model.setFl(fl[i]);
				if (rsnIg[i] != null)
					model.setRsnIg(rsnIg[i]);
				if (rsnIh[i] != null)
					model.setRsnIh(rsnIh[i]);
				if (rhUnitRatio[i] != null)
					model.setRhUnitRatio(rhUnitRatio[i]);
				if (rsnXx[i] != null)
					model.setRsnXx(rsnXx[i]);
				if (hjsRhMove[i] != null)
					model.setHjsRhMove(hjsRhMove[i]);
				if (opr[i] != null)
					model.setOpr(opr[i]);
				if (rsnIc[i] != null)
					model.setRsnIc(rsnIc[i]);
				if (mt[i] != null)
					model.setMt(mt[i]);
				if (rsnCc[i] != null)
					model.setRsnCc(rsnCc[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ccMove[i] != null)
					model.setCcMove(ccMove[i]);
				if (cdcMove[i] != null)
					model.setCdcMove(cdcMove[i]);
				if (rhMoveRatio[i] != null)
					model.setRhMoveRatio(rhMoveRatio[i]);
				if (rsnCr[i] != null)
					model.setRsnCr(rsnCr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCgoRhndPerformInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CgoRhndPerformInputVO[]
	 */
	public CgoRhndPerformInputVO[] getCgoRhndPerformInputVOs(){
		CgoRhndPerformInputVO[] vos = (CgoRhndPerformInputVO[])models.toArray(new CgoRhndPerformInputVO[models.size()]);
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
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnIt = this.rsnIt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnIw = this.rsnIw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tl = this.tl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnIx = this.rsnIx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othRhMove = this.othRhMove .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnIl = this.rsnIl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnIo = this.rsnIo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.othRhUnit = this.othRhUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnIp = this.rsnIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsRhUnit = this.hjsRhUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnIs = this.rsnIs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnIr = this.rsnIr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnId = this.rsnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnIf = this.rsnIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fl = this.fl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnIg = this.rsnIg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnIh = this.rsnIh .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhUnitRatio = this.rhUnitRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnXx = this.rsnXx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsRhMove = this.hjsRhMove .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr = this.opr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnIc = this.rsnIc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt = this.mt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnCc = this.rsnCc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccMove = this.ccMove .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdcMove = this.cdcMove .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhMoveRatio = this.rhMoveRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsnCr = this.rsnCr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
