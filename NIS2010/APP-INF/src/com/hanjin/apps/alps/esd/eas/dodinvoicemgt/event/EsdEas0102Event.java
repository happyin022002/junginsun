/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESD_EAS_0102HTMLAction.java
*@FileTitle : DOD Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.12
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.09.12 이혜민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.event;
  
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceDetailVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceListVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.DODInvoiceMainVO;
import com.hanjin.apps.alps.esd.eas.dodinvoicemgt.vo.SearchDODInvoiceListInputVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_EAS_0102 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_EAS_0102HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hyemin Lee
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdEas0102Event extends EventSupport {

	private static final long serialVersionUID = 1L;  
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchDODInvoiceListInputVO searchDODInvoiceListInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchDODInvoiceListInputVO[] searchDODInvoiceListInputVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DODInvoiceListVO dODInvoiceListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DODInvoiceListVO[] dODInvoiceListVOs = null;
	
	public EsdEas0102Event(){}
	
	public SearchDODInvoiceListInputVO getSearchDODInvoiceListInputVO() {
		return searchDODInvoiceListInputVO;
	}

	public void setSearchDODInvoiceListInputVO(SearchDODInvoiceListInputVO searchDODInvoiceListInputVO) {
		this.searchDODInvoiceListInputVO = searchDODInvoiceListInputVO;
	}

	public SearchDODInvoiceListInputVO[] getSearchDODInvoiceListInputVOs() {
		return searchDODInvoiceListInputVOs;
	}

	public void setSearchDODInvoiceListInputVOs(SearchDODInvoiceListInputVO[] searchDODInvoiceListInputVOs) {
		this.searchDODInvoiceListInputVOs = searchDODInvoiceListInputVOs;
	}
	
  
	public DODInvoiceListVO getDODInvoiceListVO() {
		return dODInvoiceListVO;
	}

	public void setDODInvoiceListVO(DODInvoiceListVO dODInvoiceListVO) {
		this.dODInvoiceListVO = dODInvoiceListVO;
	}

	public DODInvoiceListVO[] getDODInvoiceListVOs() {
		return dODInvoiceListVOs;
	}

	public void setDODInvoiceListVOs(DODInvoiceListVO[] dODInvoiceListVOs) {
		this.dODInvoiceListVOs = dODInvoiceListVOs;
	}

}
