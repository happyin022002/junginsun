/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseOrderBC.java
*@FileTitle : esm_bkg-0913
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.15 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdDetailOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdSimpleOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdUsaOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;

/**
 * ALPS-Outboundblmgtsc Business Logic Command Interface<br>
 * - ALPS-Outboundblmgtsc에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Jin Seo
 * @see Esm_bkg-0913EventResponse 참조
 * @since J2EE 1.6
 */

public interface EmptyReleaseOrderBC {
	/**
	 * 조회 이벤트 처리<br>
	 * Emptyreleaseorderbc화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Esm_bkg-0913Event
	 * @return EventResponse Esm_bkg-0913EventResponse
	 * @exception EventException
	 */

	/**
	 * ESM_BKG_0252 : Simple 조회 이벤트 처리<br>
     *
     * @param MtyRlseOrdInVO mtyRlseOrdIn
     * @author Choi Do Soon
     * @return List<MtyRlseOrdSimpleOutVO>
	 * @throws EventException
	 */
    public  List<MtyRlseOrdSimpleOutVO> searchMtyRlseOrdForSimple(MtyRlseOrdInVO mtyRlseOrdIn) throws EventException;

    /**
	 * ESM_BKG_0252 : Detail 조회 이벤트 처리<br>
     *
     * @param MtyRlseOrdInVO mtyRlseOrdIn
     * @author Choi Do Soon
     * @return List<MtyRlseOrdDetailOutVO>
	 * @throws EventException
	 */
    public  List<MtyRlseOrdDetailOutVO> searchMtyRlseOrdForDetail(MtyRlseOrdInVO mtyRlseOrdIn) throws EventException;

    /**
	 * ESM_BKG_0252 : Detail(USA) 조회 이벤트 처리<br>
     *
     * @param MtyRlseOrdInVO mtyRlseOrdIn
     * @author Choi Do Soon
     * @return List<MtyRlseOrdUsaOutVO>
	 * @throws EventException
	 */
    public  List<MtyRlseOrdUsaOutVO> searchMtyRlseOrdForUsa(MtyRlseOrdInVO mtyRlseOrdIn) throws EventException;
    
    /**
     * ESM_BKG_0252 : 팩스 보내기 이벤트 처리
     * 
     * @param SendMtyRlseOrdVO[] sendMtyRlseOrdVOs
     * @param SignOnUserAccount account
     * @author Choi Do Soon
     * @return List<BkgNtcHisVO>
     * @throws EventException
     */
    public  List<BkgNtcHisVO> sendMtyRlseOrdByFax (SendMtyRlseOrdVO[] sendMtyRlseOrdVOs,SignOnUserAccount account)throws EventException;
    
    
    /**
     * ESM_BKG_0252 : 이메일 보내기 이벤트 처리
     * 
     * @param SendMtyRlseOrdVO[] sendMtyRlseOrdVOs
     * @param BkgEmlEdtVO bkgEmlEdtVO
     * @param SignOnUserAccount account
     * @author Choi Do Soon
     * @return List<BkgNtcHisVO>
     * @throws EventException
     */
    public  List<BkgNtcHisVO> sendMtyRlseOrdByEmail (SendMtyRlseOrdVO[] sendMtyRlseOrdVOs,BkgEmlEdtVO bkgEmlEdtVO,SignOnUserAccount account)throws EventException;

}