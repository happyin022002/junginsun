/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EmptyReleaseOrderBCBCImpl.java
*@FileTitle : esm_bkg-0913
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.06.15 이진서
* 1.0 Creation
* 2010.12.06 전성진 [CHM-201007381] BKG/DOC Email 전송시 User Information에 Email이 누락된 경우 IAM 메일주소로 처리
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration.EmptyReleaseOrderDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration.EmptyReleaseOrderEAIDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdDetailOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdSimpleOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdUsaOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.ComUserVO;

/**
 * ALPS-OutboundBLMgtSC Business Logic Basic Command implementation<br>
 * - ALPS-OutboundBLMgtSC에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Jin Seo
 * @see esm_bkg-0913EventResponse,EmptyReleaseOrderBCBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class EmptyReleaseOrderBCImpl extends BasicCommandSupport implements EmptyReleaseOrderBC {

	// Database Access Object
	private transient EmptyReleaseOrderDBDAO dbDao = null;
	private transient EmptyReleaseOrderEAIDAO dbEaiDao = null;

	/**
	 * EmptyReleaseOrderBCBCImpl 객체 생성<br>
	 * EmptyReleaseOrderBCDBDAO를 생성한다.<br>
	 */
	public EmptyReleaseOrderBCImpl() {
		dbDao = new EmptyReleaseOrderDBDAO();
		dbEaiDao = new EmptyReleaseOrderEAIDAO();
	}

	/**
     * ESM_BKG_0252 : Simple 조회 이벤트 처리<br>
     *
     * @param MtyRlseOrdInVO mtyRlseOrdIn
     * @author Choi Do Soon
     * @return List<MtyRlseOrdSimpleOutVO>
     * @exception EventException
     */
    public List<MtyRlseOrdSimpleOutVO> searchMtyRlseOrdForSimple(MtyRlseOrdInVO mtyRlseOrdIn) throws EventException {
        try {
            return dbDao.searchMtyRlseOrdForSimple(mtyRlseOrdIn);
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
    }

    /**
     * ESM_BKG_0252 : Detail 조회 이벤트 처리<br>
     *
     * @param MtyRlseOrdInVO mtyRlseOrdIn
     * @author Choi Do Soon
     * @return List<MtyRlseOrdDetailOutVO>
     * @exception EventException
     */
    public List<MtyRlseOrdDetailOutVO> searchMtyRlseOrdForDetail(MtyRlseOrdInVO mtyRlseOrdIn) throws EventException {
        try {
            return dbDao.searchMtyRlseOrdForDetail(mtyRlseOrdIn);
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
    }

    /**
     * ESM_BKG_0252 : Detail(USA) 조회 이벤트 처리<br>
     *
     * @param MtyRlseOrdInVO mtyRlseOrdIn
     * @author Choi Do Soon
     * @return List<MtyRlseOrdUsaOutVO>
     * @exception EventException
     */
    public List<MtyRlseOrdUsaOutVO> searchMtyRlseOrdForUsa(MtyRlseOrdInVO mtyRlseOrdIn) throws EventException {
        try {
            return dbDao.searchMtyRlseOrdForUsa(mtyRlseOrdIn);
        } catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
    }
    
    /**
     * ESM_BKG_0252 : 팩스 보내기 이벤트 처리
     * 
     * @param SendMtyRlseOrdVO[] sendMtyRlseOrdVOs
     * @param SignOnUserAccount account
     * @author Choi Do Soon
     * @return List<BkgNtcHisVO>
     * @throws EventException
     */
    public  List<BkgNtcHisVO> sendMtyRlseOrdByFax (SendMtyRlseOrdVO[] sendMtyRlseOrdVOs,SignOnUserAccount account)throws EventException {
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		BkgNtcHisVO bkgNtcHisVO = null;
		SendMtyRlseOrdVO sendMtyRlseOrdVO = null;	
		String rcvInfo = null;
		String sendId = null;
		try {
			for (int i=0; i<sendMtyRlseOrdVOs.length; i++) {
				rcvInfo = account.getUsr_nm() + ";" + sendMtyRlseOrdVOs[i].getNtcFaxNo();
				
				/* 3. Fax 전송 */
				sendMtyRlseOrdVO = new SendMtyRlseOrdVO();
				sendMtyRlseOrdVO.setSysCd("BKG");
				sendMtyRlseOrdVO.setTmplMrd("ESM_BKG_0861.mrd");
				sendMtyRlseOrdVO.setBatchFlg("N");
				sendMtyRlseOrdVO.setTitle("Empty Container Release Order");
				sendMtyRlseOrdVO.setTmplParam(sendMtyRlseOrdVOs[i].getTmplParam()); 
				sendMtyRlseOrdVO.setRcvInfo(rcvInfo);
				sendMtyRlseOrdVO.setOffice(account.getOfc_cd());
				sendMtyRlseOrdVO.setCrtUserId(account.getUsr_id());
				sendId = dbEaiDao.sendMtyRlseOrdByFax(sendMtyRlseOrdVO);				
				
				bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(sendMtyRlseOrdVOs[i].getBkgNo());
				bkgNtcHisVO.setNtcViaCd("F"); //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd("F".equalsIgnoreCase(sendMtyRlseOrdVOs[i].getYardType()) ? "FC" :("T".equalsIgnoreCase(sendMtyRlseOrdVOs[i].getYardType()) ?  "BT":"CN"));
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd("E0");
				bkgNtcHisVO.setNtcFaxNo(sendMtyRlseOrdVOs[i].getNtcFaxNo());
				bkgNtcHisVO.setSndId(sendId);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				bkgNtcHisVO.setDiffRmk(sendMtyRlseOrdVOs[i].getDiffRmk());
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
		} catch (DAOException ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		} catch (Exception ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		}
		
		return bkgNtcHisVOs;
    		 
    }
    
    
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
    public  List<BkgNtcHisVO> sendMtyRlseOrdByEmail (SendMtyRlseOrdVO[] sendMtyRlseOrdVOs,BkgEmlEdtVO bkgEmlEdtVO,SignOnUserAccount account)throws EventException {
    	List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		BkgNtcHisVO bkgNtcHisVO = null;
		SendMtyRlseOrdVO sendMtyRlseOrdVO = null;
		String sendId = null;
		BookingUtil util = null;
		String ntcKndCd = null;
		ComUserVO comUserVO = null;
		try {
			util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
			for (int i=0; i<sendMtyRlseOrdVOs.length; i++) {
				sendMtyRlseOrdVO = new SendMtyRlseOrdVO();
				String firstVVD = util.searchFirstVVD(sendMtyRlseOrdVOs[i].getBkgNo());
				ntcKndCd = "F".equalsIgnoreCase(sendMtyRlseOrdVO.getYardType()) ? "FC" :("T".equalsIgnoreCase(sendMtyRlseOrdVO.getYardType()) ?  "BT":"CN");
				sendMtyRlseOrdVO.setSysCd("BKG");
				sendMtyRlseOrdVO.setTmplMrd("ESM_BKG_0861.mrd");
				sendMtyRlseOrdVO.setBatchFlg("N");
				sendMtyRlseOrdVO.setTitle("SM Line Empty Release Order (BKG No : "+sendMtyRlseOrdVOs[i].getBkgNo()+" / 1st VVD : "+firstVVD+")");
				sendMtyRlseOrdVO.setContents("BKG No : "+sendMtyRlseOrdVOs[i].getBkgNo());  //html양식에들어갈데이타임
				sendMtyRlseOrdVO.setTmplParam(sendMtyRlseOrdVOs[i].getTmplParam());
				sendMtyRlseOrdVO.setSndNm(account.getUsr_nm());
//				sendMtyRlseOrdVO.setSndEml(account.getUsr_eml());
				sendMtyRlseOrdVO.setSndEml(sUsrEml);
				sendMtyRlseOrdVO.setRcvEml(sendMtyRlseOrdVOs[i].getNtcEml());
				sendMtyRlseOrdVO.setCrtUserId(account.getUsr_id());
				sendId = dbEaiDao.sendMtyRlseOrdByEmail(sendMtyRlseOrdVO,bkgEmlEdtVO,util.searchCcEmailAddrRSQL(ntcKndCd, account.getUsr_id()));
				bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(sendMtyRlseOrdVOs[i].getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M"); //F:Fax,M:Email
				bkgNtcHisVO.setNtcKndCd(ntcKndCd);
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd("E0");
				bkgNtcHisVO.setNtcEml(sendMtyRlseOrdVOs[i].getNtcEml());
				bkgNtcHisVO.setSndId(sendId);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				bkgNtcHisVO.setDiffRmk(sendMtyRlseOrdVOs[i].getDiffRmk());
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage());
		}
		return bkgNtcHisVOs;
    }

}
