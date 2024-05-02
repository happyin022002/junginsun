/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTes0001Event.java
*@FileTitle : Marine Terminal Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-20
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2007-02-20 kimjinjoo
* 1.0 최초 생성
* 2009-03-12 [R200903110001] : TES_TML_SO_PAY_DYS 테이블 미사용 제거 주석처리 
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.bcm.fin.fincommon.fincommon.vo.CheckInvoiceNoVO;
import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;
import com.clt.syscommon.common.table.TesTmlSoAccmVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.syscommon.common.table.TesTmlSoRvisListVO;
import com.clt.syscommon.common.table.TesTmlSoVvdListVO;

/**
 * ESD_TES_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes0001Event extends EventSupport {
	
	private TesTmlSoAccmVO 		tesTmlSoAccmVO 		= null;
	private TesTmlSoCntrListVO 	tesTmlSoCntrListVO 	= null;
	private TesTmlSoDtlVO 		tesTmlSoDtlVO 		= null;
	private TesTmlSoRvisListVO 	tesTmlSoRvisListVO 	= null;
	private TesN3rdPtyIfVO		tesN3rdPtyIfVO		= null;		
	private TesTmlSoHdrVO 		tesTmlSoHdrVO 		= null; 
	private TesTmlSoVvdListVO	tesTmlSoVvdListVO   = null; 
	
	private TesCommonVO 		tesCommonVo 		= null;	
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null;
	
	private ApPayInvVO			ApPayInvVO			= null;
	
	private TesTmlSoAccmVO[] 			tesTmlSoAccmVOs 	= null;
	private TesTmlSoCntrListVO[]		tesTmlSoCntrListVOs = null;
	private TesTmlSoDtlVO[] 			tesTmlSoDtlVOs 		= null;
	private TesTmlSoRvisListVO[] 		tesTmlSoRvisListVOs = null;
	private TesN3rdPtyIfVO[]			tesN3rdPtyIfVOs		= null;
	private TesTmlSoHdrVO[] 			tesTmlSoHdrVOs 		= null;
	private TesTmlSoVvdListVO[]			tesTmlSoVvdListVOs	= null;
	
	private TesCommonVO[] 				tesCommonVos 		= null;	
	private MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs = null;

	private CheckInvoiceNoVO		checkInvoiceNoVO = null;
	
	private com.clt.framework.component.rowset.DBRowSet rowSet = null;

	public EsdTes0001Event(){}
	

	public String getEventName() { 
		return "EsdTes0001Event";
	}

	public String toString() {
		return "EsdTes0001Event";
	}
	
	public CheckInvoiceNoVO getCheckInvoiceNoVO() {
		return checkInvoiceNoVO;
	}

	public void setCheckInvoiceNoVO(CheckInvoiceNoVO checkInvoiceNoVO) {
		this.checkInvoiceNoVO = checkInvoiceNoVO;
	}

	public com.clt.framework.component.rowset.DBRowSet getRowSet(){
		return rowSet;
	}

	public void setRowSet(com.clt.framework.component.rowset.DBRowSet rowSet){
		this.rowSet = rowSet;
	}

	/**
	 * @return the tesTmlSoAccmVO
	 */
	public TesTmlSoAccmVO getTesTmlSoAccmVO() {
		return tesTmlSoAccmVO;
	}

	/**
	 * @param tesTmlSoAccmVO the tesTmlSoAccmVO to set
	 */
	public void setTesTmlSoAccmVO(TesTmlSoAccmVO tesTmlSoAccmVO) {
		this.tesTmlSoAccmVO = tesTmlSoAccmVO;
	}

	/**
	 * @return the tesTmlSoCntrListVO
	 */
	public TesTmlSoCntrListVO getTesTmlSoCntrListVO() {
		return tesTmlSoCntrListVO;
	}

	/**
	 * @param tesTmlSoCntrListVO the tesTmlSoCntrListVO to set
	 */
	public void setTesTmlSoCntrListVO(TesTmlSoCntrListVO tesTmlSoCntrListVO) {
		this.tesTmlSoCntrListVO = tesTmlSoCntrListVO;
	}

	/**
	 * @return the tesTmlSoDtlVO
	 */
	public TesTmlSoDtlVO getTesTmlSoDtlVO() {
		return tesTmlSoDtlVO;
	}

	/**
	 * @param tesTmlSoDtlVO the tesTmlSoDtlVO to set
	 */
	public void setTesTmlSoDtlVO(TesTmlSoDtlVO tesTmlSoDtlVO) {
		this.tesTmlSoDtlVO = tesTmlSoDtlVO;
	}

	/**
	 * @return the tesTmlSoRvisListVO
	 */
	public TesTmlSoRvisListVO getTesTmlSoRvisListVO() {
		return tesTmlSoRvisListVO;
	}

	/**
	 * @param tesTmlSoRvisListVO the tesTmlSoRvisListVO to set
	 */
	public void setTesTmlSoRvisListVO(TesTmlSoRvisListVO tesTmlSoRvisListVO) {
		this.tesTmlSoRvisListVO = tesTmlSoRvisListVO;
	}

	/**
	 * @return the tesN3rdPtyIfVO
	 */
	public TesN3rdPtyIfVO getTesN3rdPtyIfVO() {
		return tesN3rdPtyIfVO;
	}

	/**
	 * @param tesN3rdPtyIfVO the tesN3rdPtyIfVO to set
	 */
	public void setTesN3rdPtyIfVO(TesN3rdPtyIfVO tesN3rdPtyIfVO) {
		this.tesN3rdPtyIfVO = tesN3rdPtyIfVO;
	}

	/**
	 * @return the tesTmlSoHdrVO
	 */
	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	/**
	 * @param tesTmlSoHdrVO the tesTmlSoHdrVO to set
	 */
	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}

	/**
	 * @return the tesTmlSoVvdListVO
	 */
	public TesTmlSoVvdListVO getTesTmlSoVvdListVO() {
		return tesTmlSoVvdListVO;
	}

	/**
	 * @param tesTmlSoVvdListVO the tesTmlSoVvdListVO to set
	 */
	public void setTesTmlSoVvdListVO(TesTmlSoVvdListVO tesTmlSoVvdListVO) {
		this.tesTmlSoVvdListVO = tesTmlSoVvdListVO;
	}

	/**
	 * @return the tesCommonVo
	 */
	public TesCommonVO getTesCommonVo() {
		return tesCommonVo;
	}

	/**
	 * @param tesCommonVo the tesCommonVo to set
	 */
	public void setTesCommonVo(TesCommonVO tesCommonVo) {
		this.tesCommonVo = tesCommonVo;
	}

	/**
	 * @return the marineTerminalInvoiceCommonVO
	 */
	public MarineTerminalInvoiceCommonVO getMarineTerminalInvoiceCommonVO() {
		return marineTerminalInvoiceCommonVO;
	}

	/**
	 * @param marineTerminalInvoiceCommonVO the marineTerminalInvoiceCommonVO to set
	 */
	public void setMarineTerminalInvoiceCommonVO(
			MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO) {
		this.marineTerminalInvoiceCommonVO = marineTerminalInvoiceCommonVO;
	}
	
	/**
	 * 
	 * @return ApPayInvVO
	 */
    public ApPayInvVO getApPayInvVO() {
		return ApPayInvVO;
	}
    
    /**
     * 
     * @param apPayInvVO
     */
	public void setApPayInvVO(ApPayInvVO apPayInvVO) {
		ApPayInvVO = apPayInvVO;
	}

	/**
	 * @return the tesTmlSoAccmVOs
	 */
	public TesTmlSoAccmVO[] getTesTmlSoAccmVOs() {
		TesTmlSoAccmVO[] rtnVOs = null;
		if (this.tesTmlSoAccmVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoAccmVOs, tesTmlSoAccmVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesTmlSoAccmVOs the tesTmlSoAccmVOs to set
	 */
	public void setTesTmlSoAccmVOs(TesTmlSoAccmVO[] tesTmlSoAccmVOs){
		if(tesTmlSoAccmVOs != null){
			TesTmlSoAccmVO[] tmpVOs = Arrays.copyOf(tesTmlSoAccmVOs, tesTmlSoAccmVOs.length);
			this.tesTmlSoAccmVOs = tmpVOs;
		}
	}

	/**
	 * @return the tesTmlSoCntrListVOs
	 */
	public TesTmlSoCntrListVO[] getTesTmlSoCntrListVOs() {
		TesTmlSoCntrListVO[] rtnVOs = null;
		if (this.tesTmlSoCntrListVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoCntrListVOs, tesTmlSoCntrListVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesTmlSoCntrListVOs the tesTmlSoCntrListVOs to set
	 */
	public void setTesTmlSoCntrListVOs(TesTmlSoCntrListVO[] tesTmlSoCntrListVOs){
		if(tesTmlSoCntrListVOs != null){
			TesTmlSoCntrListVO[] tmpVOs = Arrays.copyOf(tesTmlSoCntrListVOs, tesTmlSoCntrListVOs.length);
			this.tesTmlSoCntrListVOs = tmpVOs;
		}
	}

	/**
	 * @return the tesTmlSoDtlVOs
	 */
	public TesTmlSoDtlVO[] getTesTmlSoDtlVOs() {
		TesTmlSoDtlVO[] rtnVOs = null;
		if (this.tesTmlSoDtlVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoDtlVOs, tesTmlSoDtlVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesTmlSoDtlVOs the tesTmlSoDtlVOs to set
	 */
	public void setTesTmlSoDtlVOs(TesTmlSoDtlVO[] tesTmlSoDtlVOs){
		if(tesTmlSoDtlVOs != null){
			TesTmlSoDtlVO[] tmpVOs = Arrays.copyOf(tesTmlSoDtlVOs, tesTmlSoDtlVOs.length);
			this.tesTmlSoDtlVOs = tmpVOs;
		}
	}

	/**
	 * @return the tesTmlSoRvisListVOs
	 */
	public TesTmlSoRvisListVO[] getTesTmlSoRvisListVOs() {
		TesTmlSoRvisListVO[] rtnVOs = null;
		if (this.tesTmlSoRvisListVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoRvisListVOs, tesTmlSoRvisListVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesTmlSoRvisListVOs the tesTmlSoRvisListVOs to set
	 */
	public void setTesTmlSoRvisListVOs(TesTmlSoRvisListVO[] tesTmlSoRvisListVOs){
		if(tesTmlSoRvisListVOs != null){
			TesTmlSoRvisListVO[] tmpVOs = Arrays.copyOf(tesTmlSoRvisListVOs, tesTmlSoRvisListVOs.length);
			this.tesTmlSoRvisListVOs = tmpVOs;
		}
	}

	/**
	 * @return the tesN3rdPtyIfVOs
	 */
	public TesN3rdPtyIfVO[] getTesN3rdPtyIfVOs() {
		TesN3rdPtyIfVO[] rtnVOs = null;
		if (this.tesN3rdPtyIfVOs != null) {
			rtnVOs = Arrays.copyOf(tesN3rdPtyIfVOs, tesN3rdPtyIfVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesN3rdPtyIfVOs the tesN3rdPtyIfVOs to set
	 */
	public void setTesN3rdPtyIfVOs(TesN3rdPtyIfVO[] tesN3rdPtyIfVOs){
		if(tesN3rdPtyIfVOs != null){
			TesN3rdPtyIfVO[] tmpVOs = Arrays.copyOf(tesN3rdPtyIfVOs, tesN3rdPtyIfVOs.length);
			this.tesN3rdPtyIfVOs = tmpVOs;
		}
	}

	/**
	 * @return the tesTmlSoHdrVOs
	 */
	public TesTmlSoHdrVO[] getTesTmlSoHdrVOs() {
		TesTmlSoHdrVO[] rtnVOs = null;
		if (this.tesTmlSoHdrVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoHdrVOs, tesTmlSoHdrVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesTmlSoHdrVOs the tesTmlSoHdrVOs to set
	 */
	public void setTesTmlSoHdrVOs(TesTmlSoHdrVO[] tesTmlSoHdrVOs){
		if(tesTmlSoHdrVOs != null){
			TesTmlSoHdrVO[] tmpVOs = Arrays.copyOf(tesTmlSoHdrVOs, tesTmlSoHdrVOs.length);
			this.tesTmlSoHdrVOs = tmpVOs;
		}
	}

	/**
	 * @return the tesTmlSoVvdListVOs
	 */
	public TesTmlSoVvdListVO[] getTesTmlSoVvdListVOs() {
		TesTmlSoVvdListVO[] rtnVOs = null;
		if (this.tesTmlSoVvdListVOs != null) {
			rtnVOs = Arrays.copyOf(tesTmlSoVvdListVOs, tesTmlSoVvdListVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesTmlSoVvdListVOs the tesTmlSoVvdListVOs to set
	 */
	public void setTesTmlSoVvdListVOs(TesTmlSoVvdListVO[] tesTmlSoVvdListVOs){
		if(tesTmlSoVvdListVOs != null){
			TesTmlSoVvdListVO[] tmpVOs = Arrays.copyOf(tesTmlSoVvdListVOs, tesTmlSoVvdListVOs.length);
			this.tesTmlSoVvdListVOs = tmpVOs;
		}
	}

	/**
	 * @return the tesCommonVos
	 */
	public TesCommonVO[] getTesCommonVos() {
		TesCommonVO[] rtnVOs = null;
		if (this.tesCommonVos != null) {
			rtnVOs = Arrays.copyOf(tesCommonVos, tesCommonVos.length);
		}
		return rtnVOs;
	}

	/**
	 * @param tesCommonVos the tesCommonVos to set
	 */
	public void setTesCommonVos(TesCommonVO[] tesCommonVos){
		if(tesCommonVos != null){
			TesCommonVO[] tmpVOs = Arrays.copyOf(tesCommonVos, tesCommonVos.length);
			this.tesCommonVos = tmpVOs;
		}
	}

	/**
	 * @return the marineTerminalInvoiceCommonVOs
	 */
	public MarineTerminalInvoiceCommonVO[] getMarineTerminalInvoiceCommonVOs() {
		MarineTerminalInvoiceCommonVO[] rtnVOs = null;
		if (this.marineTerminalInvoiceCommonVOs != null) {
			rtnVOs = Arrays.copyOf(marineTerminalInvoiceCommonVOs, marineTerminalInvoiceCommonVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param marineTerminalInvoiceCommonVOs the marineTerminalInvoiceCommonVOs to set
	 */
	public void setMarineTerminalInvoiceCommonVOs(MarineTerminalInvoiceCommonVO[] marineTerminalInvoiceCommonVOs){
		if(marineTerminalInvoiceCommonVOs != null){
			MarineTerminalInvoiceCommonVO[] tmpVOs = Arrays.copyOf(marineTerminalInvoiceCommonVOs, marineTerminalInvoiceCommonVOs.length);
			this.marineTerminalInvoiceCommonVOs = tmpVOs;
		}
	}

}
