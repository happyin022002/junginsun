/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SendVslSkdCngNoticeBackEndJob.java
*@FileTitle : Charge Filtering
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.05.23 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration.GeneralBookingSplitCombineDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.integration.GeneralBookingSplitCombineEAIDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForVslSkdCngNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.VslSkdCngNoticeVO;

import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * Vessel Change Notice�� ����Ѵ�
 * 
 * @author Dae-Young, Ryu
 * @see GeneralBookingSplitCombineBCImpl
 * @since J2EE 1.6
 */
public class SendVslSkdCngNoticeBackEndJob extends BackEndCommandSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Database Access Object
	private transient GeneralBookingSplitCombineDBDAO dbDao = new GeneralBookingSplitCombineDBDAO();
	private transient GeneralBookingSplitCombineEAIDAO eaiDao = new GeneralBookingSplitCombineEAIDAO();


	/**
	 * 
	 */
	private List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs;
	public void setVslSkdCngNoticeVOs(List<VslSkdCngNoticeVO> vslSkdCngNoticeVOs) {
		this.vslSkdCngNoticeVOs = vslSkdCngNoticeVOs;
	}

	/**
	 * Vessel Change Notice�� ����Ѵ� <br>
	 *  
	 * @return String
	 * @exception Exception
	 */
	public String doStart() throws Exception {
		try {
			for(int icnt=0;icnt<vslSkdCngNoticeVOs.size();icnt++){
				VslSkdCngNoticeVO vslSkdCngNoticeVO = vslSkdCngNoticeVOs.get(icnt);
				
				//vslSkdCngNoticeVO.getTypeCd() : CD01831
				List<BkgListForVslSkdCngNoticeVO> bkgListForVslSkdCngNoticeVOs = dbDao.searchBkgListForVslSkdCngNotice(vslSkdCngNoticeVO);
				if(bkgListForVslSkdCngNoticeVOs != null && bkgListForVslSkdCngNoticeVOs.size() > 0){
					eaiDao.sendVslSkdCngNotice(bkgListForVslSkdCngNoticeVOs);
				}
			}
		} catch(Exception e) {
			throw e;
		}
		return null;
	}

}
