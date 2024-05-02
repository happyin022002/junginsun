/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0240Event.java
*@FileTitle : Integrated Customer Data Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.05.20 박창준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IntgCustSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.RsltCdListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgCustTmpltVO;
import com.clt.syscommon.common.table.BkgIbCustCntcVO;
import com.clt.syscommon.common.table.BkgMdmCrCustVO;
import com.clt.syscommon.common.table.BkgTroActCustVO;

/**
 * esm_bkg_0240 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0240HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0240HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0240Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmCustomerVO mdmCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmCustomerVO[] mdmCustomerVOs = null;
	
	private IntgCustSearchVO intgCustSearchVO = null;
	private IntgCustSearchVO[] intgCustSearchVOs = null;
	
	private BkgIbCustCntcVO bkgIbCustCntcVO = null;
	private BkgIbCustCntcVO[] bkgIbCustCntcVOs = null;

	//O/B
	private BkgCustTmpltVO bkgCustTmpltVO = null;
	private BkgCustTmpltVO[] bkgCustTmpltVOs = null;
	
	//Invoice
	private BkgMdmCrCustVO mdmCrCustVO = null;
	private BkgMdmCrCustVO[] mdmCrCustVOs = null;
	
	//TRO
	private BkgTroActCustVO bkgTroActCustVO = null;
	private BkgTroActCustVO[] bkgTroActCustVOs = null;
	
	//코드값
	private RsltCdListVO rsltcdlistvo = null;
	

	public EsmBkg0240Event(){}
	
	public void setMdmCustomerVO(MdmCustomerVO mdmCustomerVO){
		this. mdmCustomerVO = mdmCustomerVO;
	}

//	public void setMdmCustomerVOS(MdmCustomerVO[] mdmCustomerVOs){
//		this. mdmCustomerVOs = mdmCustomerVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setMdmCustomerVOS(MdmCustomerVO[] mdmCustomerVOs){
		if (mdmCustomerVOs != null) {
			MdmCustomerVO[] tmpVOs = new MdmCustomerVO[mdmCustomerVOs.length];
			System.arraycopy(mdmCustomerVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmCustomerVOs = tmpVOs;
		}		
	} 

	public MdmCustomerVO getMdmCustomerVO(){
		return mdmCustomerVO;
	}

//	public MdmCustomerVO[] getMdmCustomerVOS(){
//		return mdmCustomerVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public MdmCustomerVO[] getMdmCustomerVOS(){
		MdmCustomerVO[] tmpVOs = null;
		if (this.mdmCustomerVOs != null) {
			tmpVOs = new MdmCustomerVO[mdmCustomerVOs.length];
			System.arraycopy(mdmCustomerVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 	
	
	
//	public MdmCustomerVO[] getMdmCustomerVOs() {
//		return mdmCustomerVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public MdmCustomerVO[] getMdmCustomerVOs() {
		MdmCustomerVO[] tmpVOs = null;
		if (this.mdmCustomerVOs != null) {
			tmpVOs = new MdmCustomerVO[mdmCustomerVOs.length];
			System.arraycopy(mdmCustomerVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 	


//	public void setMdmCustomerVOs(MdmCustomerVO[] mdmCustomerVOs) {
//		this.mdmCustomerVOs = mdmCustomerVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setMdmCustomerVOs(MdmCustomerVO[] mdmCustomerVOs) {
		if (mdmCustomerVOs != null) {
			MdmCustomerVO[] tmpVOs = new MdmCustomerVO[mdmCustomerVOs.length];
			System.arraycopy(mdmCustomerVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmCustomerVOs = tmpVOs;
		}		
	} 

	
	public IntgCustSearchVO getIntgCustSearchVO() {
		return intgCustSearchVO;
	}

	public void setIntgCustSearchVO(IntgCustSearchVO intgCustSearchVO) {
		this.intgCustSearchVO = intgCustSearchVO;
	}

//	public IntgCustSearchVO[] getIntgCustSearchVOs() {
//		return intgCustSearchVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public IntgCustSearchVO[] getIntgCustSearchVOs() {
		IntgCustSearchVO[] tmpVOs = null;
		if (this.intgCustSearchVOs != null) {
			tmpVOs = new IntgCustSearchVO[intgCustSearchVOs.length];
			System.arraycopy(intgCustSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 	

//	public void setIntgCustSearchVOs(IntgCustSearchVO[] intgCustSearchVOs) {
//		this.intgCustSearchVOs = intgCustSearchVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setIntgCustSearchVOs(IntgCustSearchVO[] intgCustSearchVOs) {
		if (intgCustSearchVOs != null) {
			IntgCustSearchVO[] tmpVOs = new IntgCustSearchVO[intgCustSearchVOs.length];
			System.arraycopy(intgCustSearchVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.intgCustSearchVOs = tmpVOs;
		}		
	} 


	public BkgIbCustCntcVO getBkgIbCustCntcVO() {
		return bkgIbCustCntcVO;
	}

	public void setBkgIbCustCntcVO(IntgCustSearchVO intgCustSearchVO) {
		this.intgCustSearchVO = intgCustSearchVO;
	}

//	public BkgIbCustCntcVO[] getBkgIbCustCntcVOs() {
//		return bkgIbCustCntcVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public BkgIbCustCntcVO[] getBkgIbCustCntcVOs() {
		BkgIbCustCntcVO[] tmpVOs = null;
		if (this.bkgIbCustCntcVOs != null) {
			tmpVOs = new BkgIbCustCntcVO[bkgIbCustCntcVOs.length];
			System.arraycopy(bkgIbCustCntcVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}
	
	
//	public void setBkgIbCustCntcVOs(BkgIbCustCntcVO[] bkgIbCustCntcVOs) {
//		this.bkgIbCustCntcVOs = bkgIbCustCntcVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setBkgIbCustCntcVOs(BkgIbCustCntcVO[] bkgIbCustCntcVOs) {
		if (bkgIbCustCntcVOs != null) {
			BkgIbCustCntcVO[] tmpVOs = new BkgIbCustCntcVO[bkgIbCustCntcVOs.length];
			System.arraycopy(bkgIbCustCntcVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgIbCustCntcVOs = tmpVOs;
		}		
	} 
	
// O/B
	public BkgCustTmpltVO getBkgCustTmpltVO() {
		return bkgCustTmpltVO;
	}

	public void setBkgCustTmpltVO(IntgCustSearchVO intgCustSearchVO) {
		this.intgCustSearchVO = intgCustSearchVO;
	}

//	public BkgCustTmpltVO[] getBkgCustTmpltVOs() {
//		return bkgCustTmpltVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public BkgCustTmpltVO[] getBkgCustTmpltVOs() {
		BkgCustTmpltVO[] tmpVOs = null;
		if (this.bkgCustTmpltVOs != null) {
			tmpVOs = new BkgCustTmpltVO[bkgCustTmpltVOs.length];
			System.arraycopy(bkgCustTmpltVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}

//	public void setBkgCustTmpltVOs(BkgCustTmpltVO[] bkgCustTmpltVOs) {
//		this.bkgCustTmpltVOs = bkgCustTmpltVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setBkgCustTmpltVOs(BkgCustTmpltVO[] bkgCustTmpltVOs) {
		if (bkgCustTmpltVOs != null) {
			BkgCustTmpltVO[] tmpVOs = new BkgCustTmpltVO[bkgCustTmpltVOs.length];
			System.arraycopy(bkgCustTmpltVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgCustTmpltVOs = tmpVOs;
		}		
	} 

	
	//Invoice
	
	public BkgMdmCrCustVO getMdmCrCustVO() {
		return mdmCrCustVO;
	}

	public void setMdmCrCustVO(IntgCustSearchVO vo) {
		this.intgCustSearchVO = vo;
	}

//	public BkgMdmCrCustVO[] getMdmCrCustVOs() {
//		return mdmCrCustVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public BkgMdmCrCustVO[] getMdmCrCustVOs() {
		BkgMdmCrCustVO[] tmpVOs = null;
		if (this.mdmCrCustVOs != null) {
			tmpVOs = new BkgMdmCrCustVO[mdmCrCustVOs.length];
			System.arraycopy(mdmCrCustVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}

//	public void setMdmCrCustVOs(BkgMdmCrCustVO[] mdmCrCustVOs) {
//		this.mdmCrCustVOs = mdmCrCustVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setMdmCrCustVOs(BkgMdmCrCustVO[] mdmCrCustVOs) {
		if (mdmCrCustVOs != null) {
			BkgMdmCrCustVO[] tmpVOs = new BkgMdmCrCustVO[mdmCrCustVOs.length];
			System.arraycopy(mdmCrCustVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.mdmCrCustVOs = tmpVOs;
		}		
	} 
//TRO
	public void setBkgTroActCustVO(IntgCustSearchVO vo) {
		// TODO Auto-generated method stub
		this.intgCustSearchVO = vo;
		
	}


	public BkgTroActCustVO getBkgTroActCustVO() {
		return bkgTroActCustVO;
	}

	public void setBkgTroActCustVO(BkgTroActCustVO bkgTroActCustVO) {
		this.bkgTroActCustVO = bkgTroActCustVO;
	}

//	public BkgTroActCustVO[] getBkgTroActCustVOs() {
//		return bkgTroActCustVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public BkgTroActCustVO[] getBkgTroActCustVOs() {
		BkgTroActCustVO[] tmpVOs = null;
		if (this.bkgTroActCustVOs != null) {
			tmpVOs = new BkgTroActCustVO[bkgTroActCustVOs.length];
			System.arraycopy(bkgTroActCustVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}

//	public void setBkgTroActCustVOs(BkgTroActCustVO[] bkgTroActCustVOs) {
//		this.bkgTroActCustVOs = bkgTroActCustVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setBkgTroActCustVOs(BkgTroActCustVO[] bkgTroActCustVOs) {
		if (bkgTroActCustVOs != null) {
			BkgTroActCustVO[] tmpVOs = new BkgTroActCustVO[bkgTroActCustVOs.length];
			System.arraycopy(bkgTroActCustVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgTroActCustVOs = tmpVOs;
		}		
	} 

	public RsltCdListVO getRsltcdlistvo() {
		return rsltcdlistvo;
	}

	public void setRsltcdlistvo(RsltCdListVO rsltcdlistvo) {
		this.rsltcdlistvo = rsltcdlistvo;
	}

	
}