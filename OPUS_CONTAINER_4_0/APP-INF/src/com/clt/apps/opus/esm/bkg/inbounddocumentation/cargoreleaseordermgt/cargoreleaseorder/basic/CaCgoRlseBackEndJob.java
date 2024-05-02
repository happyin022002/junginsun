/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : CaCgoRlseBackEndJob.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.04.30
*@LastModifier   :
*@LastVersion    : 1.0
* 2009.04.30
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration.CargoReleaseOrderDBDAO;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCgoRlseVO;

/**
 *   CargoReleaseOrderMgt Business Logic Basic Command implementation<br>
 * - CargoReleaseOrderMgt 대한 비지니스 로직을 처리한다.<br>
 *
 * @author
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CaCgoRlseBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = 1L;
	// Database Access Object
	private CargoReleaseOrderDBDAO dbDao = new CargoReleaseOrderDBDAO();

	private SignOnUserAccount account;
	private String multiSnd;
	private BkgCgoRlseVO[] bkgCgoRlseVOs;

	/**
	 * 데이터 세팅
	 *
	 * @param SignOnUserAccount signOnUserAccount
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/**
	 * 데이터 세팅
	 *
	 * @param String multiSnd
	 */
	public void setMultiSnd(String multiSnd) {
		this.multiSnd = multiSnd;
	}

	/**
	 * 데이터 세팅
	 *
	 * @param BkgCgoRlseVO[] bkgCgoRlseVOs
	 */
	public void setBkgCgoRlseVOs(BkgCgoRlseVO[] bkgCgoRlseVOs) {
		if (bkgCgoRlseVOs != null) {
			BkgCgoRlseVO[] tmpVOs = Arrays.copyOf(bkgCgoRlseVOs, bkgCgoRlseVOs.length);
			this.bkgCgoRlseVOs = tmpVOs;
		}
	}

	/**
	 * doStart
	 * @return String
	 * @exception Exception
	 */
	public String doStart() throws Exception {
		CACargoReleaseOrder caCargoReleaseOrder =  new CACargoReleaseOrder();

		for (BkgCgoRlseVO bkgCgoRlseVO : this.bkgCgoRlseVOs) {

			int modRowsByMaster = dbDao.modifyCaCgoRlseEdi(bkgCgoRlseVO, this.account);
			if (modRowsByMaster > 0) dbDao.addCaCgoRlseHisByMultiEdi(bkgCgoRlseVO, this.account);    // SUCCESS

//			if( !"X".equals(dbDao.checkCstmsEvnt(bkgCgoRlseVO.getBlNo()))){
				caCargoReleaseOrder.caCgoRlse(bkgCgoRlseVO.getBlNo(), this.multiSnd, this.account);
//			} else {
				log.debug("------------------ backendjob is executed!!!!");
//			}
		}
		return "Success";
	}

}

