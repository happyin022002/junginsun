/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdTes0015Event.java
 *@FileTitle : Invoice Processing Audit Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014-06-19
 *@LastModifier : yOng hO lEE
 *@LastVersion : 1.0
 * 2014-06-19 yOng hO lEE
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.invoiceprocessingauditmanage.event;

import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;

/**
 * ESD_TES_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTes0015Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private TesTmlSoHdrVO 		tesTmlSoHdrVO			= null;
	private TesTmlSoDtlVO 		tesTmlSoDtlVO 		 	= null;
	private TesCommonVO 		tesCommonVo			= null;
	private MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO = null;

	private com.hanjin.framework.component.rowset.DBRowSet rowSet = null;

	private int iPage 			= 0;
	
	public int getIPage() {
		return iPage;
	}

	public void setIPage(int iPage) {
		this.iPage = iPage;
	}

	public EsdTes0015Event(){}

	@Override
	public String getEventName() {
		return "EsdTes0015Event";
	}

	@Override
	public String toString() {
		return "EsdTes0015Event";
	}

	public com.hanjin.framework.component.rowset.DBRowSet getRowSet(){
		return rowSet;
	}

	public void setRowSet(com.hanjin.framework.component.rowset.DBRowSet rowSet){
		this.rowSet = rowSet;
	}
	
	/**
	 * 
	 * @return
	 */
	public TesTmlSoHdrVO getTesTmlSoHdrVO() {
		return tesTmlSoHdrVO;
	}

	/**
	 * 
	 * @param tesTmlSoHdrVO
	 */
	public void setTesTmlSoHdrVO(TesTmlSoHdrVO tesTmlSoHdrVO) {
		this.tesTmlSoHdrVO = tesTmlSoHdrVO;
	}

	/**
	 * 
	 * @return
	 */
	public TesTmlSoDtlVO getTesTmlSoDtlVO() {
		return tesTmlSoDtlVO;
	}

	/**
	 * 
	 * @param tesTmlSoDtlVO
	 */
	public void setTesTmlSoDtlVO(TesTmlSoDtlVO tesTmlSoDtlVO) {
		this.tesTmlSoDtlVO = tesTmlSoDtlVO;
	}

	/**
	 * 
	 * @return
	 */
	public TesCommonVO getTesCommonVo() {
		return tesCommonVo;
	}

	/**
	 * 
	 * @param tesCommonVo
	 */
	public void setTesCommonVo(TesCommonVO tesCommonVo) {
		this.tesCommonVo = tesCommonVo;
	}

	/**
	 * 
	 * @return
	 */
	public MarineTerminalInvoiceCommonVO getMarineTerminalInvoiceCommonVO() {
		return marineTerminalInvoiceCommonVO;
	}

	/**
	 * 
	 * @param marineTerminalInvoiceCommonVO
	 */
	public void setMarineTerminalInvoiceCommonVO(
			MarineTerminalInvoiceCommonVO marineTerminalInvoiceCommonVO) {
		this.marineTerminalInvoiceCommonVO = marineTerminalInvoiceCommonVO;
	}


}
