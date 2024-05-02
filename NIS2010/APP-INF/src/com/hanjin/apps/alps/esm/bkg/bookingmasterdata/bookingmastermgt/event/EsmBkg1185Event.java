/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1185Event.java
*@FileTitle : booking master
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.20
*@LastModifier : 조창우
*@LastVersion : 1.0
* 2015.05.20 조창우
*  1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVgmClzSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVgmClzSetListVO;


/**
 * ESM_BKG_1185 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1185HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Cho Chang Woo
 * @see ESM_BKG_1185HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1185Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgVgmClzSetVO BkgVgmClzSetVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgVgmClzSetVO[] BkgVgmClzSetVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgVgmClzSetListVO BkgVgmClzSetListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgVgmClzSetListVO[] BkgVgmClzSetListVOs = null;

	public EsmBkg1185Event(){}
	
	public void setBkgVgmClzSetVO(BkgVgmClzSetVO BkgVgmClzSetVO){
		this. BkgVgmClzSetVO = BkgVgmClzSetVO;
	}

	public void setBkgVgmClzSetVOS(BkgVgmClzSetVO[] BkgVgmClzSetVOs){
		if(BkgVgmClzSetVOs != null){
			BkgVgmClzSetVO[] tmpVOs = new BkgVgmClzSetVO[BkgVgmClzSetVOs.length];
			System.arraycopy(BkgVgmClzSetVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.BkgVgmClzSetVOs = tmpVOs;
		}
	}

	public void setBkgVgmClzSetListVO(BkgVgmClzSetListVO BkgVgmClzSetListVO){
		this. BkgVgmClzSetListVO = BkgVgmClzSetListVO;
	}
 
	public void setBkgVgmClzSetListVOS(BkgVgmClzSetListVO[] BkgVgmClzSetListVOs){
		if(BkgVgmClzSetListVOs != null){
			BkgVgmClzSetListVO[] tmpVOs = new BkgVgmClzSetListVO[BkgVgmClzSetListVOs.length];
			System.arraycopy(BkgVgmClzSetListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.BkgVgmClzSetListVOs = tmpVOs;
		}
	}

	public BkgVgmClzSetVO getBkgVgmClzSetVO(){
		return BkgVgmClzSetVO;
	}

	public BkgVgmClzSetVO[] getBkgVgmClzSetVOS(){
		BkgVgmClzSetVO[] rtnVOs = null;
		if (this.BkgVgmClzSetVOs != null) {
			rtnVOs = new BkgVgmClzSetVO[BkgVgmClzSetVOs.length];
			System.arraycopy(BkgVgmClzSetVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public BkgVgmClzSetListVO getBkgVgmClzSetListVO(){
		return BkgVgmClzSetListVO;
	}

	public BkgVgmClzSetListVO[] getBkgVgmClzSetListVOS(){
		BkgVgmClzSetListVO[] rtnVOs = null;
		if (this.BkgVgmClzSetListVOs != null) {
			rtnVOs = new BkgVgmClzSetListVO[BkgVgmClzSetListVOs.length];
			System.arraycopy(BkgVgmClzSetListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}