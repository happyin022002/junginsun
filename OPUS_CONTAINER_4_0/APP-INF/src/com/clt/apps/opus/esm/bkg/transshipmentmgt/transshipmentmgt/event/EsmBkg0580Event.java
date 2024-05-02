/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0580Event.java
*@FileTitle : VVD Discharging Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.18 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgVslDchgYdInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslDischargingVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgVslDchgYdVO;
import com.clt.syscommon.common.table.MdmYardVO;


/**
 * ESM_BKG-0580 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0580HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG-0580HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0580Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgVslDchgYdInputVO bkgVslDchgYdInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgVslDchgYdInputVO[] bkgVslDchgYdInputVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgVslDchgYdVO bkgVslDchgYdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgVslDchgYdVO[] bkgVslDchgYdVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MdmYardVO mdmYardVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MdmYardVO[] mdmYardVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslDischargingVO vslDischargingVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VslDischargingVO[] vslDischargingVOs = null;

	public EsmBkg0580Event(){}
	
	public void setbkgVslDchgYdInputVO(BkgVslDchgYdInputVO bkgVslDchgYdInputVO){
		this. bkgVslDchgYdInputVO = bkgVslDchgYdInputVO;
	}

	public void setbkgVslDchgYdVO(BkgVslDchgYdVO bkgVslDchgYdVO){
		this. bkgVslDchgYdVO = bkgVslDchgYdVO;
	}

	public BkgVslDchgYdInputVO getbkgVslDchgYdInputVO(){
		return bkgVslDchgYdInputVO;
	}

	public BkgVslDchgYdVO getbkgVslDchgYdVO(){
		return bkgVslDchgYdVO;
	}

	public MdmYardVO getMdmYardVO() {
		return mdmYardVO;
	}

	public void setMdmYardVO(MdmYardVO mdmYardVO) {
		this.mdmYardVO = mdmYardVO;
	}

	public VslDischargingVO getVslDischargingVO() {
		return vslDischargingVO;
	}

	public void setVslDischargingVO(VslDischargingVO vslDischargingVO) {
		this.vslDischargingVO = vslDischargingVO;
	}

	public BkgVslDchgYdInputVO[] getBkgVslDchgYdInputVOs() {
		BkgVslDchgYdInputVO[] rtnVOs = null;
		if (this.bkgVslDchgYdInputVOs != null) {
			rtnVOs = Arrays.copyOf(bkgVslDchgYdInputVOs,bkgVslDchgYdInputVOs.length);
		}
		return rtnVOs;
	}

	public void setBkgVslDchgYdInputVOs(BkgVslDchgYdInputVO[] bkgVslDchgYdInputVOs) {
		if (bkgVslDchgYdInputVOs != null) {
			BkgVslDchgYdInputVO[] tmpVOs = Arrays.copyOf(bkgVslDchgYdInputVOs,bkgVslDchgYdInputVOs.length);
			this.bkgVslDchgYdInputVOs = tmpVOs;
		}
	}

	public BkgVslDchgYdVO[] getbkgVslDchgYdVOS() {
		BkgVslDchgYdVO[] rtnVOs = null;
		if (this.bkgVslDchgYdVOs != null) {
			rtnVOs = Arrays.copyOf(bkgVslDchgYdVOs, bkgVslDchgYdVOs.length);
		}
		return rtnVOs;
	}

	public void setbkgVslDchgYdVOS(BkgVslDchgYdVO[] bkgVslDchgYdVOs) {
		if (bkgVslDchgYdVOs != null) {
			BkgVslDchgYdVO[] tmpVOs = Arrays.copyOf(bkgVslDchgYdVOs, bkgVslDchgYdVOs.length);
			this.bkgVslDchgYdVOs = tmpVOs;
		}
	}

	public MdmYardVO[] getMdmYardVOS() {
		MdmYardVO[] rtnVOs = null;
		if (this.mdmYardVOs != null) {
			rtnVOs = Arrays.copyOf(mdmYardVOs, mdmYardVOs.length);
		}
		return rtnVOs;
	}

	public void setMdmYardVOS(MdmYardVO[] mdmYardVOs) {
		if (mdmYardVOs != null) {
			MdmYardVO[] tmpVOs = Arrays.copyOf(mdmYardVOs, mdmYardVOs.length);
			this.mdmYardVOs = tmpVOs;
		}
	}

	public VslDischargingVO[] getVslDischargingVOs() {
		VslDischargingVO[] rtnVOs = null;
		if (this.vslDischargingVOs != null) {
			rtnVOs = Arrays.copyOf(vslDischargingVOs, vslDischargingVOs.length);
		}
		return rtnVOs;
	}

	public void setVslDischargingVOs(VslDischargingVO[] vslDischargingVOs) {
		if (vslDischargingVOs != null) {
			VslDischargingVO[] tmpVOs = Arrays.copyOf(vslDischargingVOs, vslDischargingVOs.length);
			this.vslDischargingVOs = tmpVOs;
		}
	}
	
	

}