/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InboundNoticeBackEndBC.java
*@FileTitle : Customer Code Validation Background Job
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.06.05 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.InboundNoticeBackEndDBDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.hanjin.framework.component.util.CheckUtils;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * ALPS-InboundNotice Back End Job Business Logic Basic Command implementation<br>
 * - ALPS-Inbound BackEnd작업을 처리하는 Business Class
 * @author Park Mangeon
 * @see UI-BKG_1054
 * @date 2009.06.05
 * @since J2EE 1.6
 */
public class CodeValidationBackEndJob extends BackEndCommandSupport {

	/**
	 * serializable ID
	 */
	private static final long serialVersionUID = -3584808021250066053L;
	
	/**
	 * Customer Code Validation을 위한 Value
	 */
	private ArrNtcSearchVO arrNtcSearchVO;
	
	/**
	 * Backend job을 위한 DAO
	 */
	private InboundNoticeBackEndDBDAO inboundNoticeBackEndDBDAO;
	
	/**
	 * Customer Code Validation을 위한 Value를 Setup 한다.
	 * @param ArrNtcSearchVO arrNtcSearchVO
	 * @param SignOnUserAccount account
	 */
	public void setArrNtcSearchVO(ArrNtcSearchVO arrNtcSearchVO) {
		this.arrNtcSearchVO = arrNtcSearchVO;
	}


	/**
	 * Customer code Validation을 실행한다.<br>
	 * @return Object
	 */
	public Object doStart() throws Exception {
		custCdValidation(this.arrNtcSearchVO); // Customer Code Validation을 할 경우 해당 method를 기동한다.
		return null;
	}
	
	/**
	 * UI_BKG-1054 Customer Code Validation<br>
	 * 자동 match 되는 고객정보를 찾고, arrival notice를 생성한다.
	 * @param ArrNtcSearchVO arrNtcSearch
	 * @exception EventException
	 */
	private void custCdValidation(ArrNtcSearchVO arrNtcSearch) throws EventException {
		this.inboundNoticeBackEndDBDAO = new InboundNoticeBackEndDBDAO();
		try {
			if(arrNtcSearch != null){
				// 1. 작업 시작 일시를 가져온다.
				String jobStartDate = inboundNoticeBackEndDBDAO.searchJobStartDate();
				arrNtcSearch.setValDtm(jobStartDate);
				
				// 2. Auto Match(AN보냄) / Co-Biz(AN안보냄)에 대한 처리작업을 수행
				GeneralBookingReceiptBC command = new GeneralBookingReceiptBCImpl();
				
				//@ pod_cd IN 조건 처리
	    		if ("V".equals(arrNtcSearch.getSchTp()) && !CheckUtils.isNullAndNullString(arrNtcSearch.getPodCd())){
	    			arrNtcSearch.setPodCd("'" + arrNtcSearch.getPodCd().replaceAll(",", "','") + "'");
	    		}
	    		
				command.modifyBkgCustValInfo(arrNtcSearch);  //책임 테이블 때문에 수정 20091215 윤윤한 수석 요청
				
				// 3. AN Send에 대해 Arrival Notice Master 생성
				inboundNoticeBackEndDBDAO.modifyArrNtc(arrNtcSearch);
				// 4. AN Send에 대해 Arrival Notice Detail 생성
				inboundNoticeBackEndDBDAO.modifyArrNtcDetail(arrNtcSearch);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
}
