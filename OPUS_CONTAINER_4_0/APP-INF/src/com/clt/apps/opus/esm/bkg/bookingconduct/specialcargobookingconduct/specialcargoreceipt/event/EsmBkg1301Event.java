/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1301Event.java
*@FileTitle : DOT References
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2015.11.24 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1301 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1301HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see ESM_BKG_1301HTMLAction에서 참조
 * @since J2EE 1.6
 */

public class EsmBkg1301Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String dotExpNo = null;
	private String dotSpclAproNo = null;
	private String dotAuthNo = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DgCgoListVO dgCgoListVO = null;
	/** Table Value Object Multi Data 처리 */
	private DgCgoListVO[] dgCgoListVOs = null;
	
	public EsmBkg1301Event(){}

	/**
	 * @return the dotExpNo
	 */
	public String getDotExpNo() {
		return dotExpNo;
	}

	/**
	 * @param dotExpNo the dotExpNo to set
	 */
	public void setDotExpNo(String dotExpNo) {
		this.dotExpNo = dotExpNo;
	}

	/**
	 * @return the dotSpclAproNo
	 */
	public String getDotSpclAproNo() {
		return dotSpclAproNo;
	}

	/**
	 * @param dotSpclAproNo the dotSpclAproNo to set
	 */
	public void setDotSpclAproNo(String dotSpclAproNo) {
		this.dotSpclAproNo = dotSpclAproNo;
	}

	/**
	 * @return the dotAuthNo
	 */
	public String getDotAuthNo() {
		return dotAuthNo;
	}

	/**
	 * @param dotAuthNo the dotAuthNo to set
	 */
	public void setDotAuthNo(String dotAuthNo) {
		this.dotAuthNo = dotAuthNo;
	}

	/**
	 * @return the dgCgoListVO
	 */
	public DgCgoListVO getDgCgoListVO() {
		return dgCgoListVO;
	}

	/**
	 * @param dgCgoListVO the dgCgoListVO to set
	 */
	public void setDgCgoListVO(DgCgoListVO dgCgoListVO) {
		this.dgCgoListVO = dgCgoListVO;
	}

	/**
	 * @return the dgCgoListVOs
	 */
	public DgCgoListVO[] getDgCgoListVOs() {
		DgCgoListVO[] rtnVOs = null;
		if (this.dgCgoListVOs != null) {
			rtnVOs = Arrays.copyOf(dgCgoListVOs, dgCgoListVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param dgCgoListVOs the dgCgoListVOs to set
	 */
	public void setDgCgoListVOs(DgCgoListVO[] dgCgoListVOs) {
		if(dgCgoListVOs != null){
			DgCgoListVO[] tmpVOs = Arrays.copyOf(dgCgoListVOs, dgCgoListVOs.length);
			this.dgCgoListVOs = tmpVOs;
		}
	}
	
	
	

}