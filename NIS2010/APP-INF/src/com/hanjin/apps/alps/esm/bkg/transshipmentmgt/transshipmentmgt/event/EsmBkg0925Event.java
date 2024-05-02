/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmsBkg0925Event.java
*@FileTitle : T/S List by 1st VSL & 2nd VSL T/S Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.04 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSSummaryVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EMS_BKG_0925 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EMS_BKG_0925HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0925HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0925Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TSSummaryVO tSSummaryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TSSummaryVO[] tSSummaryVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TSListBy1st2ndVVDListInputVO[] tSListBy1st2ndVVDListInputVOs = null;
	
	public EsmBkg0925Event(){}

	public TSSummaryVO getTSSummaryVO() {
		return tSSummaryVO;
	}

	public void setTSSummaryVO(TSSummaryVO summaryVO) {
		tSSummaryVO = summaryVO;
	}

	public TSSummaryVO[] getTSSummaryVOs() {
		return tSSummaryVOs;
	}

	public void setTSSummaryVOs(TSSummaryVO[] summaryVOs) {
		tSSummaryVOs = summaryVOs;
	}

	public TSListBy1st2ndVVDListInputVO getTSListBy1st2ndVVDListInputVO() {
		return tSListBy1st2ndVVDListInputVO;
	}

	public void setTSListBy1st2ndVVDListInputVO(
			TSListBy1st2ndVVDListInputVO listBy1st2ndVVDListInputVO) {
		tSListBy1st2ndVVDListInputVO = listBy1st2ndVVDListInputVO;
	}

	public TSListBy1st2ndVVDListInputVO[] getTSListBy1st2ndVVDListInputVOs() {
		return tSListBy1st2ndVVDListInputVOs;
	}

	public void setTSListBy1st2ndVVDListInputVOs(
			TSListBy1st2ndVVDListInputVO[] listBy1st2ndVVDListInputVOs) {
		tSListBy1st2ndVVDListInputVOs = listBy1st2ndVVDListInputVOs;
	}
	
	

}