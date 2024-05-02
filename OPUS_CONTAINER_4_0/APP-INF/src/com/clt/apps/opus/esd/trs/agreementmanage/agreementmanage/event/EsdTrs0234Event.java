/*=========================================================
 *@FileName : ESD_TRS_0234Event.java
 *@FileTitle : Agreement Rail Surcharge History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-05-25
 *@LastModifier : pjy
 *@LastVersion : 1.0
 * 2010-05-25 pjy
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import java.util.HashMap;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0234 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0234HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong hyek choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0234Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private String fmYard		= null;	
	private String toYard		= null;
	private String fmEffDate	= null;
	private String toEffDate	= null;
	private String routeAll		= null;
	private String selScg		= null;
	
	private String agmtNoPop	= null;
	private String vndrSeqPop	= null;
	private String trspRailScgCdPop	= null;
	private String agmtRoutAllFlgPop = null;
	private String fmNodCdPop	= null;
	private String toNodCdPop	= null;
	private String cgoTpCdPop	= null;
	
	public EsdTrs0234Event(){}
	
	
	public String getFmYard() {
		return fmYard;
	}

	public void setFmYard(String fmYard) {
		this.fmYard = fmYard;
	}

	public String getToYard() {
		return toYard;
	}

	public void setToYard(String toYard) {
		this.toYard = toYard;
	}

	public String getFmEffDate() {
		return fmEffDate;
	}

	public void setFmEffDate(String fmEffDate) {
		this.fmEffDate = fmEffDate;
	}

	public String getToEffDate() {
		return toEffDate;
	}

	public void setToEffDate(String toEffDate) {
		this.toEffDate = toEffDate;
	}

	public String getAgmtNoPop() {
		return agmtNoPop;
	}


	public void setAgmtNoPop(String agmtNoPop) {
		this.agmtNoPop = agmtNoPop;
	}


	public String getVndrSeqPop() {
		return vndrSeqPop;
	}


	public void setVndrSeqPop(String vndrSeqPop) {
		this.vndrSeqPop = vndrSeqPop;
	}


	public String getTrspRailScgCdPop() {
		return trspRailScgCdPop;
	}


	public void setTrspRailScgCdPop(String trspRailScgCdPop) {
		this.trspRailScgCdPop = trspRailScgCdPop;
	}


	public String getAgmtRoutAllFlgPop() {
		return agmtRoutAllFlgPop;
	}


	public void setAgmtRoutAllFlgPop(String agmtRoutAllFlgPop) {
		this.agmtRoutAllFlgPop = agmtRoutAllFlgPop;
	}


	public String getFmNodCdPop() {
		return fmNodCdPop;
	}


	public void setFmNodCdPop(String fmNodCdPop) {
		this.fmNodCdPop = fmNodCdPop;
	}


	public String getToNodCdPop() {
		return toNodCdPop;
	}


	public void setToNodCdPop(String toNodCdPop) {
		this.toNodCdPop = toNodCdPop;
	}


	public String getCgoTpCdPop() {
		return cgoTpCdPop;
	}


	public void setCgoTpCdPop(String cgoTpCdPop) {
		this.cgoTpCdPop = cgoTpCdPop;
	}

	public String getRouteAll() {
		return routeAll;
	}


	public void setRouteAll(String routeAll) {
		this.routeAll = routeAll;
	}


	public String getSelScg() {
		return selScg;
	}


	public void setSelScg(String selScg) {
		this.selScg = selScg;
	}

	/**	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		
		this.hashColumns.put("fmYard", 	this.getFmYard());
		this.hashColumns.put("toYard", 	this.getToYard());
		this.hashColumns.put("fmEffDate",	this.getFmEffDate());
		this.hashColumns.put("toEffDate", 	this.getToEffDate());
		this.hashColumns.put("agmtNoPop", 	this.getAgmtNoPop());
		this.hashColumns.put("vndrSeqPop", 	this.getVndrSeqPop());
		this.hashColumns.put("trspRailScgCdPop",	this.getTrspRailScgCdPop());
		this.hashColumns.put("agmtRoutAllFlgPop", 	this.getAgmtRoutAllFlgPop());
		this.hashColumns.put("fmNodCdPop", 	this.getFmNodCdPop());
		this.hashColumns.put("toNodCdPop", 	this.getToNodCdPop());
		this.hashColumns.put("cgoTpCdPop",	this.getCgoTpCdPop());
		this.hashColumns.put("routeAll", 	this.getRouteAll());
		this.hashColumns.put("selScg",	this.getSelScg());
		return this.hashColumns;
	}

	public String getEventName() {
		return "EsdTrs0234Event";
	}

	public String toString() {
		return "EsdTrs0234Event";
	}
}
