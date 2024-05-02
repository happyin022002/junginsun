/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesDmt6012Event.java
*@FileTitle : Uncollected status by Aging
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.26
*@LastModifier : 정 운
*@LastVersion : 1.0
* 2013.11.26 정 운
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.event;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.TmnlVvdLfdVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo.TmnlContainerExceptionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DMT_6012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_6012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeong Un
 * @see EES_DMT_6012HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt6012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TmnlVvdLfdVO TmnlVvdLfdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TmnlVvdLfdVO[] tmnlVvdLfdVOs = null;
	private TmnlContainerExceptionVO[] tmnlContainerExceptionVOs = null;

	
	public EesDmt6012Event(){}

	public TmnlVvdLfdVO getTmnlVvdLfdVO() {
		return TmnlVvdLfdVO;
	}
	public void setTmnlVvdLfdVO(TmnlVvdLfdVO tmnlVvdLfdVO) {
		TmnlVvdLfdVO = tmnlVvdLfdVO;
	}

	public TmnlVvdLfdVO[] getTmnlVvdLfdVOs() {
		TmnlVvdLfdVO[] ret = null;
		
		if (this.tmnlVvdLfdVOs != null) {
			ret = new TmnlVvdLfdVO[tmnlVvdLfdVOs.length];
			
			for (int i=0; i<tmnlVvdLfdVOs.length; i++) {
				ret[i] = this.tmnlVvdLfdVOs[i];
			}
		}
		return ret;	
	}
	public void setTmnlVvdLfdVOs(TmnlVvdLfdVO[] tmnlVvdLfdVOs) {
		if (tmnlVvdLfdVOs != null) {
			this.tmnlVvdLfdVOs = new TmnlVvdLfdVO[tmnlVvdLfdVOs.length];
			
			for (int i=0; i<tmnlVvdLfdVOs.length; i++) {
				this.tmnlVvdLfdVOs[i] = tmnlVvdLfdVOs[i];
			}
		}
	}

	public TmnlContainerExceptionVO[] getTmnlContainerExceptionVOs() {
		TmnlContainerExceptionVO[] ret = null;
		
		if (this.tmnlContainerExceptionVOs != null) {
			ret = new TmnlContainerExceptionVO[tmnlContainerExceptionVOs.length];
			
			for (int i=0; i<tmnlContainerExceptionVOs.length; i++) {
				ret[i] = this.tmnlContainerExceptionVOs[i];
			}
		}
		return ret;	
	}
	public void setTmnlContainerExceptionVOs(
			TmnlContainerExceptionVO[] tmnlContainerExceptionVOs) {		
		if (tmnlContainerExceptionVOs != null) {
			this.tmnlContainerExceptionVOs = new TmnlContainerExceptionVO[tmnlContainerExceptionVOs.length];
			
			for (int i=0; i<tmnlContainerExceptionVOs.length; i++) {
				this.tmnlContainerExceptionVOs[i] = tmnlContainerExceptionVOs[i];
			}
		}
	}
}