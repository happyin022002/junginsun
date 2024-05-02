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
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgVslDchgYdInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslDischargingVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgVslDchgYdVO;
import com.hanjin.syscommon.common.table.MdmYardVO;


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

	public void setbkgVslDchgYdInputVOS(BkgVslDchgYdInputVO[] bkgVslDchgYdInputVOs){
		this. bkgVslDchgYdInputVOs = bkgVslDchgYdInputVOs;
	}

	public void setbkgVslDchgYdVO(BkgVslDchgYdVO bkgVslDchgYdVO){
		this. bkgVslDchgYdVO = bkgVslDchgYdVO;
	}

	public void setbkgVslDchgYdVOS(BkgVslDchgYdVO[] bkgVslDchgYdVOs){
		this. bkgVslDchgYdVOs = bkgVslDchgYdVOs;
	}

	public BkgVslDchgYdInputVO getbkgVslDchgYdInputVO(){
		return bkgVslDchgYdInputVO;
	}

	public BkgVslDchgYdInputVO[] getbkgVslDchgYdInputVOS(){
		return bkgVslDchgYdInputVOs;
	}

	public BkgVslDchgYdVO getbkgVslDchgYdVO(){
		return bkgVslDchgYdVO;
	}

	public BkgVslDchgYdVO[] getbkgVslDchgYdVOS(){
		return bkgVslDchgYdVOs;
	}

	public MdmYardVO getMdmYardVO() {
		return mdmYardVO;
	}

	public void setMdmYardVO(MdmYardVO mdmYardVO) {
		this.mdmYardVO = mdmYardVO;
	}

	public MdmYardVO[] getMdmYardVOS() {
		return mdmYardVOs;
	}

	public void setMdmYardVOS(MdmYardVO[] mdmYardVOs) {
		this.mdmYardVOs = mdmYardVOs;
	}

	public VslDischargingVO getVslDischargingVO() {
		return vslDischargingVO;
	}

	public void setVslDischargingVO(VslDischargingVO vslDischargingVO) {
		this.vslDischargingVO = vslDischargingVO;
	}

	public VslDischargingVO[] getVslDischargingVOs() {
		return vslDischargingVOs;
	}

	public void setVslDischargingVOs(VslDischargingVO[] vslDischargingVOs) {
		this.vslDischargingVOs = vslDischargingVOs;
	}

}