/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireBackEndJob.java
*@FileTitle : Lease Term Change Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.15
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.10.15 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration.ChassisMgsetOnOffhireDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ChassisMgsetAgreementInvoice Business Logic Command Interface<br>
 * - OPUS-ChassisMgsetAgreementInvoice에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author Jang Jun-Woo
 * @see ees_cgm_1026EventResponse,ChassisMgsetOnOffhireBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ChassisMgsetOnOffhireBackEndJob extends BackEndCommandSupport {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 3299150605186851611L;

	private ChassisMgsetOnOffhireDBDAO dbDao = new ChassisMgsetOnOffhireDBDAO();

	private String jobType = null;

	private CHSTermStatusINVO[] cHSTermStatusINVOs = null;

	private CHSTermStatusINVO cHSTermStatusINVO = null;

	private SignOnUserAccount account = null;

	/**
	 * 요청작업의 수행을 BackEndJob으로 처리합니다.<br>
	 *
	 * @return Object result
	 * @exception Exception
	 */
	public Object doStart() throws Exception {
		Object result = null;

		try {
			if(getJobType().equals("manageCHSTermChangeList")) {
				List<CHSTermStatusINVO> eqList = new ArrayList<CHSTermStatusINVO>();
	            CHSTermStatusINVO chsTerm = new CHSTermStatusINVO();
	            chsTerm = dbDao.checkCHSTermChangeEffDateData(cHSTermStatusINVO);
				if(chsTerm==null || !chsTerm.getVerify().equals("OK")){
					throw new EventException(new ErrorHandler("CGM10072",new String[]{chsTerm.getAgmtEffDt(),chsTerm.getAgmtExpDt()}).getMessage());
				}

				int cnt = dbDao.checkCHSTermChangeChgCreationData(cHSTermStatusINVO);
				if(cnt>0){
					throw new EventException(new ErrorHandler("CGM10075",new String[]{}).getMessage());
				}
				/*---------------------------------------------
					 CGM_EQ_STS_HIS, CGM_EQUIPMENT 등록 및 수정
				 ----------------------------------------------*/
				for(int i=0; i < cHSTermStatusINVOs.length; i++){
					CHSTermStatusINVO historyINVO = new CHSTermStatusINVO();

					String eqStsSeq1 = "";	// 첫번째  Insert 시 생성된 Sequence
					String eqStsSeq2 = "";	// 두번째  Insert 시 생성된 Sequence

					/*----------------------------------------
						 CGM_EQ_STS_HIS 등록
					 -----------------------------------------*/
					// 첫번째는 LSO 입력, 두번째는 LSI 입력
					for(int k=1; k <= 2; k++){
						// Sequnece 생성
						String eqStsSeq = dbDao.searchCHSEqHistorySeqData();

						// VO 설정
						if(k == 1){
							eqStsSeq1 = eqStsSeq;
							historyINVO.setAgmtOfcCtyCd(cHSTermStatusINVOs[i].getAgmtOfcCtyCd());
							historyINVO.setAgmtSeq(cHSTermStatusINVOs[i].getAgmtSeq());
							historyINVO.setAgmtVerNo(cHSTermStatusINVOs[i].getAgmtVerNo());
							historyINVO.setEqAsetStsCd("LSO");
						} else if(k == 2){
							eqStsSeq2 = eqStsSeq;
							historyINVO.setAgmtOfcCtyCd(cHSTermStatusINVO.getNewAgmtOfcCtyCd());
							historyINVO.setAgmtSeq(cHSTermStatusINVO.getNewAgmtSeq());
							historyINVO.setAgmtVerNo(cHSTermStatusINVO.getNewAgmtVerNo());
							historyINVO.setEqAsetStsCd("LSI");
						}

						historyINVO.setEqNo(cHSTermStatusINVOs[i].getEqNo());
						historyINVO.setEqStsSeq(eqStsSeq);
						historyINVO.setEqKndCd(cHSTermStatusINVO.getEqKndCd());
						historyINVO.setStsEvntYdCd(cHSTermStatusINVOs[i].getStsEvntYdCd());
						historyINVO.setStsEvntLocCd(cHSTermStatusINVOs[i].getStsEvntLocCd());
						historyINVO.setStsEvntOfcCd(cHSTermStatusINVO.getStsEvntOfcCd());
						historyINVO.setStsEvntDt(cHSTermStatusINVO.getStsEvntDt().replaceAll("-", ""));
						historyINVO.setTermCngSeq(eqStsSeq);
						historyINVO.setCreUsrId(account.getUsr_id());
						historyINVO.setUpdUsrId(account.getUsr_id());

						// CGM_EQ_STS_HIS 에 데이터 저장
						dbDao.addCHSTermChangeEqHistoryData(historyINVO);
					}


					// CGM_EQ_STS_HIS 수정 ==> LSO, LSI Term Change Sequence 를 맞추기 위해
					historyINVO.setTermCngSeq(eqStsSeq2);
					historyINVO.setEqStsSeq(eqStsSeq1);

					dbDao.modifyCHSTermChangeEqHistoryData(historyINVO);

					/*----------------------------------------
				 		CGM_EQUIPMENT 수정
				 	----------------------------------------*/
					CHSTermStatusINVO eqINVO = new CHSTermStatusINVO();

					eqINVO.setEqNo(cHSTermStatusINVOs[i].getEqNo());
					eqINVO.setAgmtOfcCtyCd(cHSTermStatusINVO.getNewAgmtOfcCtyCd());
					eqINVO.setAgmtSeq(cHSTermStatusINVO.getNewAgmtSeq());
					eqINVO.setAgmtVerNo(cHSTermStatusINVO.getNewAgmtVerNo());
					eqINVO.setVndrSeq(cHSTermStatusINVO.getNewVndrSeq());
					eqINVO.setAgmtLstmCd(cHSTermStatusINVO.getNewAgmtLstmCd());
					eqINVO.setOnhOfcCd(cHSTermStatusINVO.getStsEvntOfcCd());
					eqINVO.setOnhDt(cHSTermStatusINVO.getStsEvntDt().replaceAll("-", ""));
					eqINVO.setUpdUsrId(account.getUsr_id());
					eqINVO.setEqTpszCd(cHSTermStatusINVOs[i].getEqTpszCd());
					eqINVO.setEqStsSeq(eqStsSeq2);

					eqList.add(eqINVO);

					int cnt2 = dbDao.checkCHSTermChangeTypeSizeData(eqINVO);
					if((cnt2==0)
					 &&
					 !cHSTermStatusINVO.getNewAgmtLstmCd().equals("OW")
					){

						String agmtNo = eqINVO.getAgmtOfcCtyCd() + JSPUtil.getLPAD(eqINVO.getAgmtSeq(), 6, "0") ;
						throw new EventException(new ErrorHandler("CGM10073",new String[]{agmtNo,eqINVO.getEqTpszCd()}).getMessage());
					}
				}

				// CGM_EQUIPMENT 수정
				dbDao.modifyCHSTermChangeEqMasterData(eqList);
				result = eqList;
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}

		return result;
	}

	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	/**
	 * @return the cHSTermStatusINVOs
	 */
	public CHSTermStatusINVO[] getCHSTermStatusINVOs() {
		CHSTermStatusINVO[] rtnVOs = null;
		if (this.cHSTermStatusINVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(cHSTermStatusINVOs, cHSTermStatusINVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param termStatusINVOs the cHSTermStatusINVOs to set
	 */
	public void setCHSTermStatusINVOs(CHSTermStatusINVO[] termStatusINVOs){
		if(termStatusINVOs != null){
			CHSTermStatusINVO[] tmpVOs = java.util.Arrays.copyOf(termStatusINVOs, termStatusINVOs.length);
			this.cHSTermStatusINVOs = tmpVOs;
		}
	}

	/**
	 * @return the cHSTermStatusINVO
	 */
	public CHSTermStatusINVO getCHSTermStatusINVO() {
		return cHSTermStatusINVO;
	}

	/**
	 * @param termStatusINVO the cHSTermStatusINVO to set
	 */
	public void setCHSTermStatusINVO(CHSTermStatusINVO termStatusINVO) {
		cHSTermStatusINVO = termStatusINVO;
	}

	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}
}
