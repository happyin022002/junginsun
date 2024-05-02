/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESCommonEvent.java
*@FileTitle : TES Common 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-31 byungheeyoo
* 1.0 최초 생성
* 2011.08.08 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
* 2011.08.10 윤태승 [R4J 공지] 31주차 Java application 소스 품질 결함 조치 공지
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tescommon.event;

import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargomanage.vo.TesAwkCgoTrfMngVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
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
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;

/**
 * TESCommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - TESCommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author byungheeyoo
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class TESCommonEvent extends EventSupport {

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
	private TesTmlSoDtlVO		tesTmlSoDtlVO		= null;
	private TesAwkCgoTrfMngVO		tesAwkCgoTrfMngVO		= null;
	

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
	private TesAwkCgoTrfMngVO[]		tesAwkCgoTrfMngVOs	= null;
//	private TesTmlSoDtlVO[]			tesTmlSoDtlVOs		= null;
	
	public TESCommonEvent(){}
	
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
	
	public void setTesTmlSoDtlVO(TesTmlSoDtlVO tesTmlSoDtlVO){
		this. tesTmlSoDtlVO = tesTmlSoDtlVO;
	}

//	public void setTesTmlSoDtlVOS(TesTmlSoDtlVO[] tesTmlSoDtlVOs){
//		this. tesTmlSoDtlVOs = tesTmlSoDtlVOs;
//	}
	
	public TesTmlSoDtlVO getTesTmlSoDtlVO(){
		return tesTmlSoDtlVO;
	}

//	public TesTmlSoDtlVO[] getTesTmlSoDtlVOS(){
//		return tesTmlSoDtlVOs;
//	}

	
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

	public void setTesAwkCgoTrfMngVO(TesAwkCgoTrfMngVO tesAwkCgoTrfMngVO){
		this. tesAwkCgoTrfMngVO = tesAwkCgoTrfMngVO;
	}

	public void setTesAwkCgoTrfMngVOS(TesAwkCgoTrfMngVO[] tesAwkCgoTrfMngVOs){
		this. tesAwkCgoTrfMngVOs = tesAwkCgoTrfMngVOs;
	}

	public TesAwkCgoTrfMngVO getTesAwkCgoTrfMngVO(){
		return tesAwkCgoTrfMngVO;
	}

	public TesAwkCgoTrfMngVO[] getTesAwkCgoTrfMngVOS(){
		return tesAwkCgoTrfMngVOs;
	}
	
}
