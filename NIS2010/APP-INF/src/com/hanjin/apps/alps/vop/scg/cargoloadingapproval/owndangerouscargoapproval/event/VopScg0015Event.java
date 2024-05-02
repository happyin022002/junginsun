/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopScg0015Event.java
*@FileTitle : Dangerous CGO Application Details for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.07.13 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SegrGrpVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ScgDgCgoVO;


/**
 * VOP_SCG-0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_SCG-0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dohyoung Lee
 * @see VOP_SCG-0015HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopScg0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ScgDgCgoVO scgDgCgoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ScgDgCgoVO[] scgDgCgoVOs = null;

    private SegrGrpVO searchSegrGrpVO= null;
	
	private SegrGrpVO[] searchSegrGrpVOs= null;
	
	
	public VopScg0015Event(){}
	
	public ScgDgCgoVO getScgDgCgoVO() {
		return scgDgCgoVO;
	}


	public void setScgDgCgoVO(ScgDgCgoVO scgDgCgoVO) {
		this.scgDgCgoVO = scgDgCgoVO;
	}


	//2015.08.17 Secure Coding 적용 [CWE-495]
	public ScgDgCgoVO[] getScgDgCgoVOs() {
		ScgDgCgoVO[] rtnVOs = null;
		if (this.scgDgCgoVOs != null) {
			rtnVOs = new ScgDgCgoVO[scgDgCgoVOs.length];
			System.arraycopy(scgDgCgoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setScgDgCgoVOs(ScgDgCgoVO[] scgDgCgoVOs) {
		if (scgDgCgoVOs != null) {
			ScgDgCgoVO[] tmpVOs = new ScgDgCgoVO[scgDgCgoVOs.length];
			System.arraycopy(scgDgCgoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.scgDgCgoVOs = tmpVOs;
		}		
	}


	public SegrGrpVO getSearchSegrGrpVO() {
		return searchSegrGrpVO;
	}


	public void setSearchSegrGrpVO(SegrGrpVO searchSegrGrpVO) {
		this.searchSegrGrpVO = searchSegrGrpVO;
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public SegrGrpVO[] getSearchSegrGrpVOs() {
		SegrGrpVO[] rtnVOs = null;
		if (this.searchSegrGrpVOs != null) {
			rtnVOs = new SegrGrpVO[searchSegrGrpVOs.length];
			System.arraycopy(searchSegrGrpVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}

	//2015.08.17 Secure Coding 적용 [CWE-495]
	public void setSearchSegrGrpVOs(SegrGrpVO[] searchSegrGrpVOs) {
		if (searchSegrGrpVOs != null) {
			SegrGrpVO[] tmpVOs = new SegrGrpVO[searchSegrGrpVOs.length];
			System.arraycopy(searchSegrGrpVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSegrGrpVOs = tmpVOs;
		}
		
	}


	
	
	

}