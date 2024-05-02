/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TmnlPerformInputVO.java
*@FileTitle : TmnlPerformInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.08.25 김종옥 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TmnlPerformInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TmnlPerformInputVO> models = new ArrayList<TmnlPerformInputVO>();
	
	/* Column Info */
	private String etb = null;
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String atb = null;
	/* Column Info */
	private String rhRatio = null;
	/* Column Info */
	private String ata = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String depDelay = null;
	/* Column Info */
	private String gangGross = null;
	/* Column Info */
	private String gangPrdGross = null;
	/* Column Info */
	private String cgoFl = null;
	/* Column Info */
	private String lane = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String atd = null;
	/* Column Info */
	private String workPrdNet = null;
	/* Column Info */
	private String portDelay = null;
	/* Column Info */
	private String arrDelay = null;
	/* Column Info */
	private String workGross = null;
	/* Column Info */
	private String gangPrdNet = null;
	/* Column Info */
	private String rhMvs = null;
	/* Column Info */
	private String tugIn = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String workPrdGross = null;
	/* Column Info */
	private String workNet = null;
	/* Column Info */
	private String tugOut = null;
	/* Column Info */
	private String totMvs = null;
	/* Column Info */
	private String portWork = null;
	/* Column Info */
	private String gangNet = null;
	/* Column Info */
	private String arrWait = null;
	/* Column Info */
	private String cgoMt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TmnlPerformInputVO() {}

	public TmnlPerformInputVO(String ibflag, String pagerows, String port, String lane, String vvd, String etb, String etd, String ata, String atb, String atd, String arrDelay, String arrWait, String portDelay, String portWork, String depDelay, String tugIn, String tugOut, String cgoFl, String cgoMt, String rhMvs, String rhRatio, String totMvs, String workGross, String workNet, String gangGross, String gangNet, String workPrdGross, String workPrdNet, String gangPrdGross, String gangPrdNet) {
		this.etb = etb;
		this.port = port;
		this.atb = atb;
		this.rhRatio = rhRatio;
		this.ata = ata;
		this.etd = etd;
		this.depDelay = depDelay;
		this.gangGross = gangGross;
		this.gangPrdGross = gangPrdGross;
		this.cgoFl = cgoFl;
		this.lane = lane;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.atd = atd;
		this.workPrdNet = workPrdNet;
		this.portDelay = portDelay;
		this.arrDelay = arrDelay;
		this.workGross = workGross;
		this.gangPrdNet = gangPrdNet;
		this.rhMvs = rhMvs;
		this.tugIn = tugIn;
		this.vvd = vvd;
		this.workPrdGross = workPrdGross;
		this.workNet = workNet;
		this.tugOut = tugOut;
		this.totMvs = totMvs;
		this.portWork = portWork;
		this.gangNet = gangNet;
		this.arrWait = arrWait;
		this.cgoMt = cgoMt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etb", getEtb());
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("atb", getAtb());
		this.hashColumns.put("rh_ratio", getRhRatio());
		this.hashColumns.put("ata", getAta());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("dep_delay", getDepDelay());
		this.hashColumns.put("gang_gross", getGangGross());
		this.hashColumns.put("gang_prd_gross", getGangPrdGross());
		this.hashColumns.put("cgo_fl", getCgoFl());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("atd", getAtd());
		this.hashColumns.put("work_prd_net", getWorkPrdNet());
		this.hashColumns.put("port_delay", getPortDelay());
		this.hashColumns.put("arr_delay", getArrDelay());
		this.hashColumns.put("work_gross", getWorkGross());
		this.hashColumns.put("gang_prd_net", getGangPrdNet());
		this.hashColumns.put("rh_mvs", getRhMvs());
		this.hashColumns.put("tug_in", getTugIn());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("work_prd_gross", getWorkPrdGross());
		this.hashColumns.put("work_net", getWorkNet());
		this.hashColumns.put("tug_out", getTugOut());
		this.hashColumns.put("tot_mvs", getTotMvs());
		this.hashColumns.put("port_work", getPortWork());
		this.hashColumns.put("gang_net", getGangNet());
		this.hashColumns.put("arr_wait", getArrWait());
		this.hashColumns.put("cgo_mt", getCgoMt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etb", "etb");
		this.hashFields.put("port", "port");
		this.hashFields.put("atb", "atb");
		this.hashFields.put("rh_ratio", "rhRatio");
		this.hashFields.put("ata", "ata");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("dep_delay", "depDelay");
		this.hashFields.put("gang_gross", "gangGross");
		this.hashFields.put("gang_prd_gross", "gangPrdGross");
		this.hashFields.put("cgo_fl", "cgoFl");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("atd", "atd");
		this.hashFields.put("work_prd_net", "workPrdNet");
		this.hashFields.put("port_delay", "portDelay");
		this.hashFields.put("arr_delay", "arrDelay");
		this.hashFields.put("work_gross", "workGross");
		this.hashFields.put("gang_prd_net", "gangPrdNet");
		this.hashFields.put("rh_mvs", "rhMvs");
		this.hashFields.put("tug_in", "tugIn");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("work_prd_gross", "workPrdGross");
		this.hashFields.put("work_net", "workNet");
		this.hashFields.put("tug_out", "tugOut");
		this.hashFields.put("tot_mvs", "totMvs");
		this.hashFields.put("port_work", "portWork");
		this.hashFields.put("gang_net", "gangNet");
		this.hashFields.put("arr_wait", "arrWait");
		this.hashFields.put("cgo_mt", "cgoMt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etb
	 */
	public String getEtb() {
		return this.etb;
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
	 * @return atb
	 */
	public String getAtb() {
		return this.atb;
	}
	
	/**
	 * Column Info
	 * @return rhRatio
	 */
	public String getRhRatio() {
		return this.rhRatio;
	}
	
	/**
	 * Column Info
	 * @return ata
	 */
	public String getAta() {
		return this.ata;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return depDelay
	 */
	public String getDepDelay() {
		return this.depDelay;
	}
	
	/**
	 * Column Info
	 * @return gangGross
	 */
	public String getGangGross() {
		return this.gangGross;
	}
	
	/**
	 * Column Info
	 * @return gangPrdGross
	 */
	public String getGangPrdGross() {
		return this.gangPrdGross;
	}
	
	/**
	 * Column Info
	 * @return cgoFl
	 */
	public String getCgoFl() {
		return this.cgoFl;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return atd
	 */
	public String getAtd() {
		return this.atd;
	}
	
	/**
	 * Column Info
	 * @return workPrdNet
	 */
	public String getWorkPrdNet() {
		return this.workPrdNet;
	}
	
	/**
	 * Column Info
	 * @return portDelay
	 */
	public String getPortDelay() {
		return this.portDelay;
	}
	
	/**
	 * Column Info
	 * @return arrDelay
	 */
	public String getArrDelay() {
		return this.arrDelay;
	}
	
	/**
	 * Column Info
	 * @return workGross
	 */
	public String getWorkGross() {
		return this.workGross;
	}
	
	/**
	 * Column Info
	 * @return gangPrdNet
	 */
	public String getGangPrdNet() {
		return this.gangPrdNet;
	}
	
	/**
	 * Column Info
	 * @return rhMvs
	 */
	public String getRhMvs() {
		return this.rhMvs;
	}
	
	/**
	 * Column Info
	 * @return tugIn
	 */
	public String getTugIn() {
		return this.tugIn;
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
	 * @return workPrdGross
	 */
	public String getWorkPrdGross() {
		return this.workPrdGross;
	}
	
	/**
	 * Column Info
	 * @return workNet
	 */
	public String getWorkNet() {
		return this.workNet;
	}
	
	/**
	 * Column Info
	 * @return tugOut
	 */
	public String getTugOut() {
		return this.tugOut;
	}
	
	/**
	 * Column Info
	 * @return totMvs
	 */
	public String getTotMvs() {
		return this.totMvs;
	}
	
	/**
	 * Column Info
	 * @return portWork
	 */
	public String getPortWork() {
		return this.portWork;
	}
	
	/**
	 * Column Info
	 * @return gangNet
	 */
	public String getGangNet() {
		return this.gangNet;
	}
	
	/**
	 * Column Info
	 * @return arrWait
	 */
	public String getArrWait() {
		return this.arrWait;
	}
	
	/**
	 * Column Info
	 * @return cgoMt
	 */
	public String getCgoMt() {
		return this.cgoMt;
	}
	

	/**
	 * Column Info
	 * @param etb
	 */
	public void setEtb(String etb) {
		this.etb = etb;
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
	 * @param atb
	 */
	public void setAtb(String atb) {
		this.atb = atb;
	}
	
	/**
	 * Column Info
	 * @param rhRatio
	 */
	public void setRhRatio(String rhRatio) {
		this.rhRatio = rhRatio;
	}
	
	/**
	 * Column Info
	 * @param ata
	 */
	public void setAta(String ata) {
		this.ata = ata;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param depDelay
	 */
	public void setDepDelay(String depDelay) {
		this.depDelay = depDelay;
	}
	
	/**
	 * Column Info
	 * @param gangGross
	 */
	public void setGangGross(String gangGross) {
		this.gangGross = gangGross;
	}
	
	/**
	 * Column Info
	 * @param gangPrdGross
	 */
	public void setGangPrdGross(String gangPrdGross) {
		this.gangPrdGross = gangPrdGross;
	}
	
	/**
	 * Column Info
	 * @param cgoFl
	 */
	public void setCgoFl(String cgoFl) {
		this.cgoFl = cgoFl;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param atd
	 */
	public void setAtd(String atd) {
		this.atd = atd;
	}
	
	/**
	 * Column Info
	 * @param workPrdNet
	 */
	public void setWorkPrdNet(String workPrdNet) {
		this.workPrdNet = workPrdNet;
	}
	
	/**
	 * Column Info
	 * @param portDelay
	 */
	public void setPortDelay(String portDelay) {
		this.portDelay = portDelay;
	}
	
	/**
	 * Column Info
	 * @param arrDelay
	 */
	public void setArrDelay(String arrDelay) {
		this.arrDelay = arrDelay;
	}
	
	/**
	 * Column Info
	 * @param workGross
	 */
	public void setWorkGross(String workGross) {
		this.workGross = workGross;
	}
	
	/**
	 * Column Info
	 * @param gangPrdNet
	 */
	public void setGangPrdNet(String gangPrdNet) {
		this.gangPrdNet = gangPrdNet;
	}
	
	/**
	 * Column Info
	 * @param rhMvs
	 */
	public void setRhMvs(String rhMvs) {
		this.rhMvs = rhMvs;
	}
	
	/**
	 * Column Info
	 * @param tugIn
	 */
	public void setTugIn(String tugIn) {
		this.tugIn = tugIn;
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
	 * @param workPrdGross
	 */
	public void setWorkPrdGross(String workPrdGross) {
		this.workPrdGross = workPrdGross;
	}
	
	/**
	 * Column Info
	 * @param workNet
	 */
	public void setWorkNet(String workNet) {
		this.workNet = workNet;
	}
	
	/**
	 * Column Info
	 * @param tugOut
	 */
	public void setTugOut(String tugOut) {
		this.tugOut = tugOut;
	}
	
	/**
	 * Column Info
	 * @param totMvs
	 */
	public void setTotMvs(String totMvs) {
		this.totMvs = totMvs;
	}
	
	/**
	 * Column Info
	 * @param portWork
	 */
	public void setPortWork(String portWork) {
		this.portWork = portWork;
	}
	
	/**
	 * Column Info
	 * @param gangNet
	 */
	public void setGangNet(String gangNet) {
		this.gangNet = gangNet;
	}
	
	/**
	 * Column Info
	 * @param arrWait
	 */
	public void setArrWait(String arrWait) {
		this.arrWait = arrWait;
	}
	
	/**
	 * Column Info
	 * @param cgoMt
	 */
	public void setCgoMt(String cgoMt) {
		this.cgoMt = cgoMt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEtb(JSPUtil.getParameter(request, "etb", ""));
		setPort(JSPUtil.getParameter(request, "port", ""));
		setAtb(JSPUtil.getParameter(request, "atb", ""));
		setRhRatio(JSPUtil.getParameter(request, "rh_ratio", ""));
		setAta(JSPUtil.getParameter(request, "ata", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setDepDelay(JSPUtil.getParameter(request, "dep_delay", ""));
		setGangGross(JSPUtil.getParameter(request, "gang_gross", ""));
		setGangPrdGross(JSPUtil.getParameter(request, "gang_prd_gross", ""));
		setCgoFl(JSPUtil.getParameter(request, "cgo_fl", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAtd(JSPUtil.getParameter(request, "atd", ""));
		setWorkPrdNet(JSPUtil.getParameter(request, "work_prd_net", ""));
		setPortDelay(JSPUtil.getParameter(request, "port_delay", ""));
		setArrDelay(JSPUtil.getParameter(request, "arr_delay", ""));
		setWorkGross(JSPUtil.getParameter(request, "work_gross", ""));
		setGangPrdNet(JSPUtil.getParameter(request, "gang_prd_net", ""));
		setRhMvs(JSPUtil.getParameter(request, "rh_mvs", ""));
		setTugIn(JSPUtil.getParameter(request, "tug_in", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setWorkPrdGross(JSPUtil.getParameter(request, "work_prd_gross", ""));
		setWorkNet(JSPUtil.getParameter(request, "work_net", ""));
		setTugOut(JSPUtil.getParameter(request, "tug_out", ""));
		setTotMvs(JSPUtil.getParameter(request, "tot_mvs", ""));
		setPortWork(JSPUtil.getParameter(request, "port_work", ""));
		setGangNet(JSPUtil.getParameter(request, "gang_net", ""));
		setArrWait(JSPUtil.getParameter(request, "arr_wait", ""));
		setCgoMt(JSPUtil.getParameter(request, "cgo_mt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TmnlPerformInputVO[]
	 */
	public TmnlPerformInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TmnlPerformInputVO[]
	 */
	public TmnlPerformInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TmnlPerformInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etb = (JSPUtil.getParameter(request, prefix	+ "etb", length));
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] atb = (JSPUtil.getParameter(request, prefix	+ "atb", length));
			String[] rhRatio = (JSPUtil.getParameter(request, prefix	+ "rh_ratio", length));
			String[] ata = (JSPUtil.getParameter(request, prefix	+ "ata", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] depDelay = (JSPUtil.getParameter(request, prefix	+ "dep_delay", length));
			String[] gangGross = (JSPUtil.getParameter(request, prefix	+ "gang_gross", length));
			String[] gangPrdGross = (JSPUtil.getParameter(request, prefix	+ "gang_prd_gross", length));
			String[] cgoFl = (JSPUtil.getParameter(request, prefix	+ "cgo_fl", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] atd = (JSPUtil.getParameter(request, prefix	+ "atd", length));
			String[] workPrdNet = (JSPUtil.getParameter(request, prefix	+ "work_prd_net", length));
			String[] portDelay = (JSPUtil.getParameter(request, prefix	+ "port_delay", length));
			String[] arrDelay = (JSPUtil.getParameter(request, prefix	+ "arr_delay", length));
			String[] workGross = (JSPUtil.getParameter(request, prefix	+ "work_gross", length));
			String[] gangPrdNet = (JSPUtil.getParameter(request, prefix	+ "gang_prd_net", length));
			String[] rhMvs = (JSPUtil.getParameter(request, prefix	+ "rh_mvs", length));
			String[] tugIn = (JSPUtil.getParameter(request, prefix	+ "tug_in", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] workPrdGross = (JSPUtil.getParameter(request, prefix	+ "work_prd_gross", length));
			String[] workNet = (JSPUtil.getParameter(request, prefix	+ "work_net", length));
			String[] tugOut = (JSPUtil.getParameter(request, prefix	+ "tug_out", length));
			String[] totMvs = (JSPUtil.getParameter(request, prefix	+ "tot_mvs", length));
			String[] portWork = (JSPUtil.getParameter(request, prefix	+ "port_work", length));
			String[] gangNet = (JSPUtil.getParameter(request, prefix	+ "gang_net", length));
			String[] arrWait = (JSPUtil.getParameter(request, prefix	+ "arr_wait", length));
			String[] cgoMt = (JSPUtil.getParameter(request, prefix	+ "cgo_mt", length));
			
			for (int i = 0; i < length; i++) {
				model = new TmnlPerformInputVO();
				if (etb[i] != null)
					model.setEtb(etb[i]);
				if (port[i] != null)
					model.setPort(port[i]);
				if (atb[i] != null)
					model.setAtb(atb[i]);
				if (rhRatio[i] != null)
					model.setRhRatio(rhRatio[i]);
				if (ata[i] != null)
					model.setAta(ata[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (depDelay[i] != null)
					model.setDepDelay(depDelay[i]);
				if (gangGross[i] != null)
					model.setGangGross(gangGross[i]);
				if (gangPrdGross[i] != null)
					model.setGangPrdGross(gangPrdGross[i]);
				if (cgoFl[i] != null)
					model.setCgoFl(cgoFl[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (atd[i] != null)
					model.setAtd(atd[i]);
				if (workPrdNet[i] != null)
					model.setWorkPrdNet(workPrdNet[i]);
				if (portDelay[i] != null)
					model.setPortDelay(portDelay[i]);
				if (arrDelay[i] != null)
					model.setArrDelay(arrDelay[i]);
				if (workGross[i] != null)
					model.setWorkGross(workGross[i]);
				if (gangPrdNet[i] != null)
					model.setGangPrdNet(gangPrdNet[i]);
				if (rhMvs[i] != null)
					model.setRhMvs(rhMvs[i]);
				if (tugIn[i] != null)
					model.setTugIn(tugIn[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (workPrdGross[i] != null)
					model.setWorkPrdGross(workPrdGross[i]);
				if (workNet[i] != null)
					model.setWorkNet(workNet[i]);
				if (tugOut[i] != null)
					model.setTugOut(tugOut[i]);
				if (totMvs[i] != null)
					model.setTotMvs(totMvs[i]);
				if (portWork[i] != null)
					model.setPortWork(portWork[i]);
				if (gangNet[i] != null)
					model.setGangNet(gangNet[i]);
				if (arrWait[i] != null)
					model.setArrWait(arrWait[i]);
				if (cgoMt[i] != null)
					model.setCgoMt(cgoMt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTmnlPerformInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TmnlPerformInputVO[]
	 */
	public TmnlPerformInputVO[] getTmnlPerformInputVOs(){
		TmnlPerformInputVO[] vos = (TmnlPerformInputVO[])models.toArray(new TmnlPerformInputVO[models.size()]);
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
		this.etb = this.etb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atb = this.atb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhRatio = this.rhRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ata = this.ata .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depDelay = this.depDelay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gangGross = this.gangGross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gangPrdGross = this.gangPrdGross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoFl = this.cgoFl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atd = this.atd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workPrdNet = this.workPrdNet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDelay = this.portDelay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDelay = this.arrDelay .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workGross = this.workGross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gangPrdNet = this.gangPrdNet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhMvs = this.rhMvs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tugIn = this.tugIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workPrdGross = this.workPrdGross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.workNet = this.workNet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tugOut = this.tugOut .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totMvs = this.totMvs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portWork = this.portWork .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gangNet = this.gangNet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrWait = this.arrWait .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoMt = this.cgoMt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
