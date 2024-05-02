/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_080Event.java
*@FileTitle : Distance Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-31 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TrsAgmtDistHisVO;
import com.hanjin.syscommon.common.table.TrsAgmtDistVO;


/**
 * ESD_TRS_080 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_080HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author juhyun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0080Event extends EventSupport {

	TrsAgmtDistVO [] trsAgmtDistVOs =	null;
	TrsAgmtDistHisVO [] trsAgmtDistHisVOs =	null;
	String hidFrmNode;
	String hidToNode;
	String frmZip;
	String toZip;
	String rowCount;
	
	String opnerFromNode;
	String opnerToNode;
	String opnerFromZipCode;
	String opnerToZipCode;
	
	String ofcCd;
	String hidCreUsrId;
	String hidCreDate;

	String hidUpdUsrId;
	String hidUpdDate;
	
	String delGubun;

	public TrsAgmtDistVO [] getTrsAgmtDistVOs(){
		return trsAgmtDistVOs;
	}
	
	public void setTrsAgmtDistVOs(TrsAgmtDistVO [] trsAgmtDistVOs){
		this.trsAgmtDistVOs = trsAgmtDistVOs;
	}
	
	public void setTrsAgmtDistHisVOs(TrsAgmtDistHisVO [] trsAgmtDistHisVOs){
		this.trsAgmtDistHisVOs = trsAgmtDistHisVOs;
	}
	
	public TrsAgmtDistHisVO [] getTrsAgmtDistHisVOs(){
		return trsAgmtDistHisVOs;
	}

	public void setHidFrmNode(String hidFrmNode){
		this.hidFrmNode = hidFrmNode;
	}

	public String getHidFrmNode(){
		return hidFrmNode;
	}
	
	public void setHidToNode(String hidToNode){
		this.hidToNode = hidToNode;
	}

	public String getHidToNode(){
		return hidToNode;
	}	
	
	public void setFrmZip(String frmZip){
		this.frmZip = frmZip;
	}
	
	public String getFrmZip(){
		return frmZip;
	}
	
	public void setToZip(String toZip){
		this.toZip = toZip;
	}
	
	public String getToZip(){
		return toZip;
	}
	
	public void setRowCount(String rowCount){
		this.rowCount = rowCount;
	}
	
	/**
	 * @return the opnerFromNode
	 */
	public String getOpnerFromNode() {
		return opnerFromNode;
	}

	/**
	 * @param opnerFromNode the opnerFromNode to set
	 */
	public void setOpnerFromNode(String opnerFromNode) {
		this.opnerFromNode = opnerFromNode;
	}

	/**
	 * @return the opnerToNode
	 */
	public String getOpnerToNode() {
		return opnerToNode;
	}

	/**
	 * @param opnerToNode the opnerToNode to set
	 */
	public void setOpnerToNode(String opnerToNode) {
		this.opnerToNode = opnerToNode;
	}

	/**
	 * @return the opnerFromZipCode
	 */
	public String getOpnerFromZipCode() {
		return opnerFromZipCode;
	}

	/**
	 * @param opnerFromZipCode the opnerFromZipCode to set
	 */
	public void setOpnerFromZipCode(String opnerFromZipCode) {
		this.opnerFromZipCode = opnerFromZipCode;
	}

	/**
	 * @return the opnerToZipCode
	 */
	public String getOpnerToZipCode() {
		return opnerToZipCode;
	}

	/**
	 * @param opnerToZipCode the opnerToZipCode to set
	 */
	public void setOpnerToZipCode(String opnerToZipCode) {
		this.opnerToZipCode = opnerToZipCode;
	}

	public String getRowCount(){
		return rowCount;
	}
	
	
	public void setOfcCd(String ofcCd){
		this.ofcCd = ofcCd;
	}
	
	public String getOfcCd(){
		return ofcCd;
	}
	
	public void setHidCreUsrId(String hidCreUsrId){
		this.hidCreUsrId = hidCreUsrId;
	}
	
	public String getHidCreUsrId(){
		return hidCreUsrId;
	}
	
	public void setHidCreDate(String hidCreDate){
		this.hidCreDate = hidCreDate;
	}
	
	public String getHidCreDate(){
		return hidCreDate;
	}

	public void setHidUpdUsrId(String hidUpdUsrId){
		this.hidUpdUsrId = hidUpdUsrId;
	}
	
	public String getHidUpdUsrId(){
		return hidUpdUsrId;
	}
	
	public void setHidUpdDate(String hidUpdDate){
		this.hidUpdDate = hidUpdDate;
	}
	
	public String getHidUpdDate(){
		return hidUpdDate;
	}
	
	public void setDelGubun(String delGubun){
		this.delGubun = delGubun;
	}
	
	public String getDelGubun(){
		return delGubun;
	}	
	
	/** getEventName */
	public String getEventName() {
		return "EsdTrs0080Event";
	}

	/** toString */
	public String toString() {
		return "EsdTrs0080Event";
	}

}
