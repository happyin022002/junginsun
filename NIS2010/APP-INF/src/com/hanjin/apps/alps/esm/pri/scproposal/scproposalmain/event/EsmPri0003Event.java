/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0003Event.java
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.08 변영주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltMainStsVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPerformanceVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropProgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SchCustVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SchSaleLeadVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;
import com.hanjin.syscommon.common.table.PriSpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpProgVO;
import com.hanjin.syscommon.common.table.PriSpScpAmdtSmryVO;
import com.hanjin.syscommon.common.table.PriSpScpDurVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMqcVO;
import com.hanjin.syscommon.common.table.PriSpScpProgVO;


/**
 * ESM_PRI_0003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0003HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private String saleLeadOri = "";
	
	
	public String getSaleLeadOri() {
		return saleLeadOri;
	}

	public void setSaleLeadOri (String saleLeadOri) {
		this.saleLeadOri = saleLeadOri;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SchCustVO schCustVO = null;
	
	public SchCustVO getSchCustVO() {
		return schCustVO;
	}

	public void setSchCustVO(SchCustVO schCustVO) {
		this.schCustVO = schCustVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltMainStsVO rsltMainStsVO = null;
	
	public RsltMainStsVO getRsltMainStsVO() {
		return rsltMainStsVO;
	}

	public void setRsltMainStsVO(RsltMainStsVO rsltMainStsVO) {
		this.rsltMainStsVO = rsltMainStsVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPerformanceVO rsltPerformanceVO = null;
	
	public RsltPerformanceVO getRsltPerformanceVO() {
		return rsltPerformanceVO;
	}

	public void setRsltPerformanceVO(RsltPerformanceVO rsltPerformanceVO) {
		this.rsltPerformanceVO = rsltPerformanceVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;	
	
	
	public ComBakEndJbVO getComBakEndJbVO() {
		return comBakEndJbVO;
	}

	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO) {
		this.comBakEndJbVO = comBakEndJbVO;
	}

	public ComBakEndJbVO[] getComBakEndJbVOs() {
		return comBakEndJbVOs;
	}

	public void setComBakEndJbVOs(ComBakEndJbVO[] comBakEndJbVOs) {
		this.comBakEndJbVOs = comBakEndJbVOs;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SchSaleLeadVO schSaleLeadVO = null;
	
	
	public SchSaleLeadVO getSchSaleLeadVO() {
		return schSaleLeadVO;
	}

	public void setSchSaleLeadVO(SchSaleLeadVO schSaleLeadVO) {
		this.schSaleLeadVO = schSaleLeadVO;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpMnVO priSpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpMnVO[] priSpMnVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpMnVO priSpScpMnVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpMnVO[] priSpScpMnVOs = null;	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpHdrVO priSpHdrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpHdrVO[] priSpHdrVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpAmdtSmryVO priSpAmdtSmryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpAmdtSmryVO[] priSpAmdtSmryVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpProgVO priSpProgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpProgVO[] priSpProgVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpProgVO priSpScpProgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpProgVO[] priSpScpProgVOs = null;		
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpAmdtSmryVO priSpScpAmdtSmryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpAmdtSmryVO[] priSpScpAmdtSmryVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpDurVO priSpScpDurVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpDurVO[] priSpScpDurVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpMqcVO priSpScpMqcVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpMqcVO[] priSpScpMqcVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpCtrtPtyVO priSpCtrtPtyVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScPropMnVO scPropMnVO = null;
	
	private ScPropProgVO scPropProgVO = null;	
	
	public EsmPri0003Event(){}
	
	public void setScPropMnVO(ScPropMnVO scPropMnVO){
		this. scPropMnVO = scPropMnVO;
	}
	
	public void setScPropProgVO(ScPropProgVO scPropProgVO){
		this. scPropProgVO = scPropProgVO;
	}	
	
	public void setPriSpMnVO(PriSpMnVO priSpMnVO){
		this. priSpMnVO = priSpMnVO;
	}

	public void setPriSpMnVOS(PriSpMnVO[] priSpMnVOs){
		this. priSpMnVOs = priSpMnVOs;
	}
	
	public void setPriSpScpMnVO(PriSpScpMnVO priSpScpMnVO){
		this. priSpScpMnVO = priSpScpMnVO;
	}

	public void setPriSpScpMnVOS(PriSpScpMnVO[] priSpScpMnVOs){
		this. priSpScpMnVOs = priSpScpMnVOs;
	}	

	public void setPriSpHdrVO(PriSpHdrVO priSpHdrVO){
		this. priSpHdrVO = priSpHdrVO;
	}

	public void setPriSpHdrVOS(PriSpHdrVO[] priSpHdrVOs){
		this. priSpHdrVOs = priSpHdrVOs;
	}
	
	public void setPriSpAmdtSmryVO(PriSpAmdtSmryVO priSpAmdtSmryVO){
		this. priSpAmdtSmryVO = priSpAmdtSmryVO;
	}

	public void setPriSpAmdtSmryVOS(PriSpAmdtSmryVO[] priSpAmdtSmryVOs){
		this. priSpAmdtSmryVOs = priSpAmdtSmryVOs;
	}
	
	public void setPriSpProgVO(PriSpProgVO priSpProgVO){
		this. priSpProgVO = priSpProgVO;
	}

	public void setPriSpProgVOS(PriSpProgVO[] priSpProgVOs){
		this. priSpProgVOs = priSpProgVOs;
	}
	
	public void setPriSpScpProgVO(PriSpScpProgVO priSpScpProgVO){
		this. priSpScpProgVO = priSpScpProgVO;
	}

	public void setPriSpScpProgVOS(PriSpScpProgVO[] priSpScpProgVOs){
		this. priSpScpProgVOs = priSpScpProgVOs;
	}	
	
	public void setPriSpScpAmdtSmryVO(PriSpScpAmdtSmryVO priSpScpAmdtSmryVO){
		this. priSpScpAmdtSmryVO = priSpScpAmdtSmryVO;
	}

	public void setPriSpScpAmdtSmryVOS(PriSpScpAmdtSmryVO[] priSpScpAmdtSmryVOs){
		this. priSpScpAmdtSmryVOs = priSpScpAmdtSmryVOs;
	}	
	
	public void setPriSpScpMqcVOS(PriSpScpMqcVO[] priSpScpMqcVOs){
		this. priSpScpMqcVOs = priSpScpMqcVOs;
	}
	
	public void setPriSpScpDurVOS(PriSpScpDurVO[] priSpScpDurVOs){
		this. priSpScpDurVOs = priSpScpDurVOs;
	}	
	
	public void setPriSpCtrtPtyVO(PriSpCtrtPtyVO priSpCtrtPtyVO){
		this. priSpCtrtPtyVO = priSpCtrtPtyVO;
	}	

	public ScPropMnVO getScPropMnVO(){
		return scPropMnVO;
	}
	
	public ScPropProgVO getScPropProgVO(){
		return scPropProgVO;
	}	
	
	public PriSpMnVO getPriSpMnVO(){
		return priSpMnVO;
	}

	public PriSpMnVO[] getPriSpMnVOS(){
		return priSpMnVOs;
	}
	
	public PriSpScpMnVO getPriSpScpMnVO(){
		return priSpScpMnVO;
	}

	public PriSpScpMnVO[] getPriSpScpMnVOS(){
		return priSpScpMnVOs;
	}	

	public PriSpHdrVO getPriSpHdrVO(){
		return priSpHdrVO;
	}

	public PriSpHdrVO[] getPriSpHdrVOS(){
		return priSpHdrVOs;
	}
	
	public PriSpAmdtSmryVO getPriSpAmdtSmryVO(){
		return priSpAmdtSmryVO;
	}
	
	public PriSpAmdtSmryVO[] getPriSpAmdtSmryVOS(){
		return priSpAmdtSmryVOs;
	}
	
	public PriSpScpAmdtSmryVO getPriSpScpAmdtSmryVO(){
		return priSpScpAmdtSmryVO;
	}
	
	public PriSpScpAmdtSmryVO[] getPriSpScpAmdtSmryVOS(){
		return priSpScpAmdtSmryVOs;
	}
	
	public PriSpProgVO getPriSpProgVO(){
		return priSpProgVO;
	}
	
	public PriSpProgVO[] getPriSpProgVOS(){
		return priSpProgVOs;
	}		
	
	public PriSpScpProgVO getPriSpScpProgVO(){
		return priSpScpProgVO;
	}
	
	public PriSpScpProgVO[] getPriSpScpProgVOS(){
		return priSpScpProgVOs;
	}		
	
	public PriSpScpMqcVO getPriSpScpMqcVO(){
		return priSpScpMqcVO;
	}
	
	public PriSpScpMqcVO[] getPriSpScpMqcVOS(){
		return priSpScpMqcVOs;
	}
	
	public PriSpScpDurVO getPriSpScpDurVO(){
		return priSpScpDurVO;
	}
	
	public PriSpScpDurVO[] getPriSpScpDurVOS(){
		return priSpScpDurVOs;
	}	
	
	public PriSpCtrtPtyVO getPriSpCtrtPtyVO(){
		return priSpCtrtPtyVO;
	}
}