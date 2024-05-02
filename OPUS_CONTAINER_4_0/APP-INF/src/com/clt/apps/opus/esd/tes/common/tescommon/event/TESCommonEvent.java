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
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tescommon.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.MdmYardVO;
import com.clt.syscommon.common.table.TesJbExePerfLogVO;
import com.clt.syscommon.common.table.TesLgsCostVO;
import com.clt.syscommon.common.table.TesTmlAgmtCostVO;
import com.clt.syscommon.common.table.TesTmlSoCostVO;
import com.clt.syscommon.common.table.TesTmlSoCrrVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;

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
	private TesLgsCostVO[]			tesLgsCostVOs		= null;
	private TesTmlSoHdrVO[]			tesTmlSoHdrVOs		= null;
	private TesTmlSoCostVO[]		tesTmlSoCostVOs		= null;
	private TesTmlSoCrrVO[]			tesTmlSoCrrVOs		= null;
	private TesTmlAgmtCostVO[]		tesTmlAgmtCostVOs	= null;
	private TesJbExePerfLogVO[]		tesJbExePerfLogVOs	= null;

	public TESCommonEvent(){}
	
	public void setMdmYardVO(MdmYardVO mdmYardVO){
		this. mdmYardVO = mdmYardVO;
	}

	public void setMdmYardVOS(MdmYardVO[] mdmYardVOs){
		if (mdmYardVOs != null) {
			MdmYardVO[] tempVo = Arrays.copyOf(mdmYardVOs, mdmYardVOs.length);
			this.mdmYardVOs = tempVo;
		}		
	}

	public MdmYardVO getMdmYardVO(){
		return mdmYardVO;
	}

	public MdmYardVO[] getMdmYardVOS(){
		MdmYardVO[] tempVOs = null;
		
		if (this.mdmYardVOs != null) {
			tempVOs = Arrays.copyOf(this.mdmYardVOs, this.mdmYardVOs.length);
		}
		return tempVOs;	
	}


	public void setVskVslPortSkdVO(VskVslPortSkdVO vskVslPortSkdVO){
		this. vskVslPortSkdVO = vskVslPortSkdVO;
	}

	public void setVskVslPortSkdVOS(VskVslPortSkdVO[] vskVslPortSkdVOs){
		if (vskVslPortSkdVOs != null) {
			VskVslPortSkdVO[] tempVo = Arrays.copyOf(vskVslPortSkdVOs, vskVslPortSkdVOs.length);
			this.vskVslPortSkdVOs = tempVo;
		}
	}

	public VskVslPortSkdVO getVskVslPortSkdVO(){
		return vskVslPortSkdVO;
	}

	public VskVslPortSkdVO[] getVskVslPortSkdVOS(){
		VskVslPortSkdVO[] tempVOs = null;
		
		if (this.vskVslPortSkdVOs != null) {
			tempVOs = Arrays.copyOf(this.vskVslPortSkdVOs, this.vskVslPortSkdVOs.length);
		}
		return tempVOs;	
	}

	
	public void setTesCommonVO(TesCommonVO tesCommonVO){
		this. tesCommonVO = tesCommonVO;
	}

	public void setTesCommonVOS(TesCommonVO[] tesCommonVOs){
		if (tesCommonVOs != null) {
			TesCommonVO[] tempVo = Arrays.copyOf(tesCommonVOs, tesCommonVOs.length);
			this.tesCommonVOs = tempVo;
		}
	}

	public TesCommonVO getTesCommonVO(){
		return tesCommonVO;
	}

	public TesCommonVO[] getTesCommonVOS(){
		TesCommonVO[] tempVOs = null;
		
		if (this.tesCommonVOs != null) {
			tempVOs = Arrays.copyOf(this.tesCommonVOs, this.tesCommonVOs.length);
		}
		return tempVOs;			
	}
	
	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO){
		this. tesTmlSoHdrVO = tesTmlSoHdrVO;
	}

	public void setTesTmlSoHdrVOS(TesTmlSoHdrVO[] tesTmlSoHdrVOs){
		if (tesTmlSoHdrVOs != null) {
			TesTmlSoHdrVO[] tempVo = Arrays.copyOf(tesTmlSoHdrVOs, tesTmlSoHdrVOs.length);
			this.tesTmlSoHdrVOs = tempVo;
		}		
	}

	public TesTmlSoHdrVO getTesTmlSoHdrVO(){
		return tesTmlSoHdrVO;
	}

	public TesTmlSoHdrVO[] getTesTmlSoHdrVOS(){
		TesTmlSoHdrVO[] tempVOs = null;
		
		if (this.tesTmlSoHdrVOs != null) {
			tempVOs = Arrays.copyOf(this.tesTmlSoHdrVOs, this.tesTmlSoHdrVOs.length);
		}
		return tempVOs;	
	}

	
	public void setTesLgsCostVO(TesLgsCostVO tesLgsCostVO){
		this. tesLgsCostVO = tesLgsCostVO;
	}

	public void setTesLgsCostVOS(TesLgsCostVO[] tesLgsCostVOs){
		if (tesLgsCostVOs != null) {
			TesLgsCostVO[] tempVo = Arrays.copyOf(tesLgsCostVOs, tesLgsCostVOs.length);
			this.tesLgsCostVOs = tempVo;
		}			
	}

	public TesLgsCostVO getTesLgsCostVO(){
		return tesLgsCostVO;
	}

	public TesLgsCostVO[] getTesLgsCostVOS(){
		TesLgsCostVO[] tempVOs = null;
		
		if (this.tesLgsCostVOs != null) {
			tempVOs = Arrays.copyOf(this.tesLgsCostVOs, this.tesLgsCostVOs.length);
		}
		return tempVOs;	
	}

	
	public void setTesTmlSoCostVO(TesTmlSoCostVO tesTmlSoCostVO){
		this. tesTmlSoCostVO = tesTmlSoCostVO;
	}

	public void setTesTmlSoCostVOS(TesTmlSoCostVO[] tesTmlSoCostVOs){
		if (tesTmlSoCostVOs != null) {
			TesTmlSoCostVO[] tempVo = Arrays.copyOf(tesTmlSoCostVOs, tesTmlSoCostVOs.length);
			this.tesTmlSoCostVOs = tempVo;
		}	
	}

	public TesTmlSoCostVO getTesTmlSoCostVO(){
		return tesTmlSoCostVO;
	}

	public TesTmlSoCostVO[] getTesTmlSoCostVOS(){
		TesTmlSoCostVO[] tempVOs = null;
		
		if (this.tesTmlSoCostVOs != null) {
			tempVOs = Arrays.copyOf(this.tesTmlSoCostVOs, this.tesTmlSoCostVOs.length);
		}
		return tempVOs;	
	}

	
	public void setTesTmlSoCrrVO(TesTmlSoCrrVO tesTmlSoCrrVO){
		this. tesTmlSoCrrVO = tesTmlSoCrrVO;
	}

	public void setTesTmlSoCrrVOS(TesTmlSoCrrVO[] tesTmlSoCrrVOs){
		if (tesTmlSoCrrVOs != null) {
			TesTmlSoCrrVO[] tempVo = Arrays.copyOf(tesTmlSoCrrVOs, tesTmlSoCrrVOs.length);
			this.tesTmlSoCrrVOs = tempVo;
		}			
	}

	public TesTmlSoCrrVO getTesTmlSoCrrVO(){
		return tesTmlSoCrrVO;
	}

	public TesTmlSoCrrVO[] getTesTmlSoCrrVOS(){
		TesTmlSoCrrVO[] tempVOs = null;
		
		if (this.tesTmlSoCrrVOs != null) {
			tempVOs = Arrays.copyOf(this.tesTmlSoCrrVOs, this.tesTmlSoCrrVOs.length);
		}
		return tempVOs;		
	}

	
	public void setTesTmlAgmtCostVO(TesTmlAgmtCostVO tesTmlAgmtCostVO){
		this. tesTmlAgmtCostVO = tesTmlAgmtCostVO;
	}

	public void setTesTmlAgmtCostVOS(TesTmlAgmtCostVO[] tesTmlAgmtCostVOs){
		if (tesTmlAgmtCostVOs != null) {
			TesTmlAgmtCostVO[] tempVo = Arrays.copyOf(tesTmlAgmtCostVOs, tesTmlAgmtCostVOs.length);
			this.tesTmlAgmtCostVOs = tempVo;
		}				
	}

	public TesTmlAgmtCostVO getTesTmlAgmtCostVO(){
		return tesTmlAgmtCostVO;
	}

	public TesTmlAgmtCostVO[] getTesTmlAgmtCostVOS(){
		TesTmlAgmtCostVO[] tempVOs = null;
		
		if (this.tesTmlAgmtCostVOs != null) {
			tempVOs = Arrays.copyOf(this.tesTmlAgmtCostVOs, this.tesTmlAgmtCostVOs.length);
		}
		return tempVOs;			
	}

	
	public void setTesJbExePerfLogVO(TesJbExePerfLogVO tesJbExePerfLogVO){
		this. tesJbExePerfLogVO = tesJbExePerfLogVO;
	}

	public void setTesJbExePerfLogVOS(TesJbExePerfLogVO[] tesJbExePerfLogVOs){
		if (tesJbExePerfLogVOs != null) {
			TesJbExePerfLogVO[] tempVo = Arrays.copyOf(tesJbExePerfLogVOs, tesJbExePerfLogVOs.length);
			this.tesJbExePerfLogVOs = tempVo;
		}				
	}

	public TesJbExePerfLogVO getTesJbExePerfLogVO(){
		return tesJbExePerfLogVO;
	}

	public TesJbExePerfLogVO[] getTesJbExePerfLogVOS(){
		TesJbExePerfLogVO[] tempVOs = null;
		
		if (this.tesJbExePerfLogVOs != null) {
			tempVOs = Arrays.copyOf(this.tesJbExePerfLogVOs, this.tesJbExePerfLogVOs.length);
		}
		return tempVOs;	
	}

}
