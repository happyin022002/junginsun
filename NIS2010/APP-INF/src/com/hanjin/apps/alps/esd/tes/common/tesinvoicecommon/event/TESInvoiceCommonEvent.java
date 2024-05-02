/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESInvoiceCommonEvent.java
*@FileTitle : TES Common 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-31 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.event;

import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MdmYardVO;
import com.hanjin.syscommon.common.table.TesEdiSoFileVO;
import com.hanjin.syscommon.common.table.TesJbExePerfLogVO;
import com.hanjin.syscommon.common.table.TesLgsCostVO;
import com.hanjin.syscommon.common.table.TesTmlAgmtCostVO;
import com.hanjin.syscommon.common.table.TesTmlSoCostVO;
import com.hanjin.syscommon.common.table.TesTmlSoCrrVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;

//import com.hanjin.syscommon.common.table.MDM_CURRENCY;


/**
 * TESInvoiceCommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - TESInvoiceCommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class TESInvoiceCommonEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmYardVO 			mdmYardVO			= null;
	private VskVslPortSkdVO		vskVslPortSkdVO		= null;
	
	private TesCommonVO 		tesCommonVO			= null;
	private TesEdiSoFileVO		tesEdiSoFileVO		= null;
	private TesLgsCostVO		tesLgsCostVO		= null;
	private TesTmlSoHdrVO		tesTmlSoHdrVO		= null;
	private TesTmlSoCostVO		tesTmlSoCostVO		= null;
	private TesTmlSoCrrVO		tesTmlSoCrrVO		= null;
	private TesTmlAgmtCostVO	tesTmlAgmtCostVO	= null;
	private TesJbExePerfLogVO	tesJbExePerfLogVO	= null;

	/** Table Value Object Multi Data 처리 */
	private MdmYardVO[]				mdmYardVOs			= null;
	private VskVslPortSkdVO[]		vskVslPortSkdVOs	= null;
	
	private TesCommonVO[]			tesCommonVOs		= null;
	private TesEdiSoFileVO[]		tesEdiSoFileVOs		= null;
	private TesLgsCostVO[]			tesLgsCostVOs		= null;
	private TesTmlSoHdrVO[]			tesTmlSoHdrVOs		= null;
	private TesTmlSoCostVO[]		tesTmlSoCostVOs		= null;
	private TesTmlSoCrrVO[]			tesTmlSoCrrVOs		= null;
	private TesTmlAgmtCostVO[]		tesTmlAgmtCostVOs	= null;
	private TesJbExePerfLogVO[]		tesJbExePerfLogVOs	= null;

	public TESInvoiceCommonEvent(){}
	
	public void setMdmYardVO(MdmYardVO mdmYardVO){
		this. mdmYardVO = mdmYardVO;
	}

	public void setMdmYardVOS(MdmYardVO[] mdmYardVOs){
		this. mdmYardVOs = mdmYardVOs;
	}

	public MdmYardVO getMdmYardVO(){
		return mdmYardVO;
	}

	public MdmYardVO[] getMdmYardVOS(){
		return mdmYardVOs;
	}

	
	public void setVskVslPortSkdVO(VskVslPortSkdVO vskVslPortSkdVO){
		this. vskVslPortSkdVO = vskVslPortSkdVO;
	}

	public void setVskVslPortSkdVOS(VskVslPortSkdVO[] vskVslPortSkdVOs){
		this. vskVslPortSkdVOs = vskVslPortSkdVOs;
	}

	public VskVslPortSkdVO getVskVslPortSkdVO(){
		return vskVslPortSkdVO;
	}

	public VskVslPortSkdVO[] getVskVslPortSkdVOS(){
		return vskVslPortSkdVOs;
	}

	
	public void setTesCommonVO(TesCommonVO tesCommonVO){
		this. tesCommonVO = tesCommonVO;
	}

	public void setTesTmlSoHdrVOS(TesCommonVO[] tesCommonVOs){
		this. tesCommonVOs = tesCommonVOs;
	}

	public TesCommonVO getTesCommonVO(){
		return tesCommonVO;
	}

	public TesCommonVO[] getTesCommonVOS(){
		return tesCommonVOs;
	}

	public void setTesEdiSoFileVO(TesEdiSoFileVO tesEdiSoFileVO){
		this. tesEdiSoFileVO = tesEdiSoFileVO;
	}

	public void setTesEdiSoFileVOS(TesEdiSoFileVO[] tesEdiSoFileVOs){
		this. tesEdiSoFileVOs = tesEdiSoFileVOs;
	}

	public TesEdiSoFileVO getTesEdiSoFileVO(){
		return tesEdiSoFileVO;
	}

	public TesEdiSoFileVO[] getTesEdiSoFileVOS(){
		return tesEdiSoFileVOs;
	}

	
	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO){
		this. tesTmlSoHdrVO = tesTmlSoHdrVO;
	}

	public void setTesTmlSoHdrVOS(TesTmlSoHdrVO[] tesTmlSoHdrVOs){
		this. tesTmlSoHdrVOs = tesTmlSoHdrVOs;
	}

	public TesTmlSoHdrVO getTesTmlSoHdrVO(){
		return tesTmlSoHdrVO;
	}

	public TesTmlSoHdrVO[] getTesTmlSoHdrVOS(){
		return tesTmlSoHdrVOs;
	}

	
	public void setTesLgsCostVO(TesLgsCostVO tesLgsCostVO){
		this. tesLgsCostVO = tesLgsCostVO;
	}

	public void setTesLgsCostVOS(TesLgsCostVO[] tesLgsCostVOs){
		this. tesLgsCostVOs = tesLgsCostVOs;
	}

	public TesLgsCostVO getTesLgsCostVO(){
		return tesLgsCostVO;
	}

	public TesLgsCostVO[] getTesLgsCostVOS(){
		return tesLgsCostVOs;
	}

	
	public void setTesTmlSoCostVO(TesTmlSoCostVO tesTmlSoCostVO){
		this. tesTmlSoCostVO = tesTmlSoCostVO;
	}

	public void setTesTmlSoCostVOS(TesTmlSoCostVO[] tesTmlSoCostVOs){
		this. tesTmlSoCostVOs = tesTmlSoCostVOs;
	}

	public TesTmlSoCostVO getTesTmlSoCostVO(){
		return tesTmlSoCostVO;
	}

	public TesTmlSoCostVO[] getTesTmlSoCostVOS(){
		return tesTmlSoCostVOs;
	}

	
	public void setTesTmlSoCrrVO(TesTmlSoCrrVO tesTmlSoCrrVO){
		this. tesTmlSoCrrVO = tesTmlSoCrrVO;
	}

	public void setTesTmlSoCrrVOS(TesTmlSoCrrVO[] tesTmlSoCrrVOs){
		this. tesTmlSoCrrVOs = tesTmlSoCrrVOs;
	}

	public TesTmlSoCrrVO getTesTmlSoCrrVO(){
		return tesTmlSoCrrVO;
	}

	public TesTmlSoCrrVO[] getTesTmlSoCrrVOS(){
		return tesTmlSoCrrVOs;
	}

	
	public void setTesTmlAgmtCostVO(TesTmlAgmtCostVO tesTmlAgmtCostVO){
		this. tesTmlAgmtCostVO = tesTmlAgmtCostVO;
	}

	public void setTesTmlAgmtCostVOS(TesTmlAgmtCostVO[] tesTmlAgmtCostVOs){
		this. tesTmlAgmtCostVOs = tesTmlAgmtCostVOs;
	}

	public TesTmlAgmtCostVO getTesTmlAgmtCostVO(){
		return tesTmlAgmtCostVO;
	}

	public TesTmlAgmtCostVO[] getTesTmlAgmtCostVOS(){
		return tesTmlAgmtCostVOs;
	}

	
	public void setTesJbExePerfLogVO(TesJbExePerfLogVO tesJbExePerfLogVO){
		this. tesJbExePerfLogVO = tesJbExePerfLogVO;
	}

	public void setTesJbExePerfLogVOS(TesJbExePerfLogVO[] tesJbExePerfLogVOs){
		this. tesJbExePerfLogVOs = tesJbExePerfLogVOs;
	}

	public TesJbExePerfLogVO getTesJbExePerfLogVO(){
		return tesJbExePerfLogVO;
	}

	public TesJbExePerfLogVO[] getTesJbExePerfLogVOS(){
		return tesJbExePerfLogVOs;
	}
}
