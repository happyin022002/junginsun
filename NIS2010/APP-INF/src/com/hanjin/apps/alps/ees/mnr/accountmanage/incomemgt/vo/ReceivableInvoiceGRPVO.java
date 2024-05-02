/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceivableInvoiceGRPVO
*@FileTitle : ReceivableInvoiceGRPVO
*Open Issues : 
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.22 함형석
** 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;

/**
 * ReceivableInvoiceGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 함형석
 * @since J2EE 1.5 
 * @see ..
 */ 
public class ReceivableInvoiceGRPVO { 

	//조회 결과를 받기 위한   	
	private List<CustomReceivableINVInquiryListVO> customReceivableINVInquiryListVOs = null; 
	
	//조회 결과를 받기 위한   	
	private List<CustomReceivableInvoiceDetailINVO> customReceivableInvoiceDetailINVOs = null; 

	private InvArIfMnVO invArIfMnVO = null;
	private List<InvArIfChgVO> invArIfChgVOs = null; 
	private List<InvArIfCntrVO> invArIfCntrVOs = null; 

	
	
	//조회 조건을 받기 위한 
	private ReceivableINVInquiryINVO receivableINVInquiryINVO = null;

	private CustomReceivableINVInquiryListVO[] arrayCustomReceivableINVInquiryListVOs = null;

	private CustomReceivableInvoiceDetailINVO[] arrayCustomReceivableInvoiceDetailINVOs = null;

	
	private List<CustomMnrDatVrfyVO> customMnrDatVrfyVOS = null;     
	 
	public List<CustomMnrDatVrfyVO> getCustomMnrDatVrfyVOS() {
		return customMnrDatVrfyVOS;
	} 

	public void setCustomMnrDatVrfyVOS(List<CustomMnrDatVrfyVO> customMnrDatVrfyVOS) {
		this.customMnrDatVrfyVOS = customMnrDatVrfyVOS; 
	}
	
	public List<CustomReceivableINVInquiryListVO> getCustomReceivableINVInquiryListVOs() {
		return customReceivableINVInquiryListVOs;
	}
	public void setCustomReceivableINVInquiryListVOs(
			List<CustomReceivableINVInquiryListVO> customReceivableINVInquiryListVOs) {
		this.customReceivableINVInquiryListVOs = customReceivableINVInquiryListVOs;
	}

	public List<CustomReceivableInvoiceDetailINVO> getCustomReceivableInvoiceDetailINVOs() {
		return customReceivableInvoiceDetailINVOs;
	}
	public void setCustomReceivableInvoiceDetailINVOs(
			List<CustomReceivableInvoiceDetailINVO> customReceivableInvoiceDetailINVOs) {
		this.customReceivableInvoiceDetailINVOs = customReceivableInvoiceDetailINVOs;
	}

	public ReceivableINVInquiryINVO getReceivableINVInquiryINVO() {
		return receivableINVInquiryINVO;
	}
	public void setReceivableINVInquiryINVO(ReceivableINVInquiryINVO receivableINVInquiryINVO) {
		this.receivableINVInquiryINVO = receivableINVInquiryINVO;
	}

	public CustomReceivableINVInquiryListVO[] getArrayCustomReceivableINVInquiryListVOs() {
		return arrayCustomReceivableINVInquiryListVOs;
	}
	public void setArrayCustomReceivableINVInquiryListVOs(
			CustomReceivableINVInquiryListVO[] arrayCustomReceivableINVInquiryListVOs) {
		this.arrayCustomReceivableINVInquiryListVOs = arrayCustomReceivableINVInquiryListVOs;
	}

	public CustomReceivableInvoiceDetailINVO[] getArrayCustomReceivableInvoiceDetailINVOs() {
		return arrayCustomReceivableInvoiceDetailINVOs;
	}
	public void setArrayCustomReceivableInvoiceDetailINVOs(
			CustomReceivableInvoiceDetailINVO[] arrayCustomReceivableInvoiceDetailINVOs) {
		this.arrayCustomReceivableInvoiceDetailINVOs = arrayCustomReceivableInvoiceDetailINVOs;
	}
	
	public InvArIfMnVO getInvArIfMnVO() {
		return invArIfMnVO;
	}
	public void setInvArIfMnVO(InvArIfMnVO invArIfMnVO) {
		this.invArIfMnVO = invArIfMnVO;
	}	

	public List<InvArIfChgVO> getInvArIfChgVOs() {
		return invArIfChgVOs;
	}
	public void setInvArIfChgVOs(
			List<InvArIfChgVO> invArIfChgVOs) {
		this.invArIfChgVOs = invArIfChgVOs;
	}
	
	public List<InvArIfCntrVO> getInvArIfCntrVOs() {
		return invArIfCntrVOs;
	}
	public void setInvArIfCntrVOs(
			List<InvArIfCntrVO> invArIfCntrVOs) {
		this.invArIfCntrVOs = invArIfCntrVOs;
	}	
}	
