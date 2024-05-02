/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : VIPDeductAgreementBCImpl.java
 * @FileTitle : VIP Deduct Agreement Creation.
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion :
 * 2016.05.19 김상현 1.0 Creation.
 */
package com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.integration.VIPDeductAgreementDBDAO;
import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo.MdmCustomerGroupVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo.VIPAgreementCntrVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo.VIPAgreementVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * VIP Agreement Creation. Business Logic Command Interface
 * - ALPS-ACMAgreement에 대한 비지니스 로직에 대한 인터페이스
 *
 * @author 김상현
 * @see Esm_Acm_0039Event 참조
 * @since J2EE 1.6
 */
public class VIPDeductAgreementBCImpl implements VIPDeductAgreementBC {

	private VIPDeductAgreementDBDAO dbDao = null;

	/**
	 * 생성자
	 */
	public VIPDeductAgreementBCImpl() {
		dbDao = new VIPDeductAgreementDBDAO();
	}

	/**
	 * VIP agreement list 조회.
	 * @param vipAgreementVO
	 * @return List<VIPAgreementVO>
	 * @throws EventException
	 */
	@Override
	public List<VIPAgreementVO> searchVIPAgreementList(VIPAgreementVO vipAgreementVO) throws EventException {
		List<VIPAgreementVO> list = null;

		try {
			list = dbDao.searchVIPAgreementList(vipAgreementVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * VIP Agreement 추가/수정/삭제 처리.
	 * @param vipAgreementVO
	 * @param vipAgreementVOs
	 * @throws EventException
	 */
	@Override
	public void multiVipAgreement(VIPAgreementVO vipAgreementVO, VIPAgreementVO[] vipAgreementVOs) throws EventException {
		try {
			for (int i=0; i<vipAgreementVOs.length; i++) {
				vipAgreementVOs[i].setCreUsrId(vipAgreementVO.getUpdUsrId());
				vipAgreementVOs[i].setUpdUsrId(vipAgreementVO.getUpdUsrId());

				if (vipAgreementVOs[i].getIbflag().equals("I")) {        // 추가
					String maxAgmtSeq = dbDao.searchMaxAgmtSeq(vipAgreementVOs[i]);
					vipAgreementVOs[i].setAgmtSeq(maxAgmtSeq);
					dbDao.addVIPAgreement(vipAgreementVOs[i]);
				} else if (vipAgreementVOs[i].getIbflag().equals("U")) { // 수정
					dbDao.modifyVIPAgreement(vipAgreementVOs[i]);
				} else if (vipAgreementVOs[i].getIbflag().equals("D")) { // 삭제
					dbDao.modifyDeleteFlag(vipAgreementVOs[i]);
				}

				if (vipAgreementVOs[i].getIbflag().equals("I") || vipAgreementVOs[i].getIbflag().equals("U")) {
					if (vipAgreementVOs[i].getCntrTpszGrpNm().length() > 0) {
						dbDao.removeVIPAgmtCntr(vipAgreementVOs[i]);
						String cntrTpszCds[] = vipAgreementVOs[i].getCntrTpszGrpNm().split("(,)");
						for (int t=0; t<cntrTpszCds.length; t++) {
							VIPAgreementCntrVO vipAgreementCntrVO = new VIPAgreementCntrVO();
							vipAgreementCntrVO.setCustGrpId(vipAgreementVOs[i].getCustGrpId());
							vipAgreementCntrVO.setAgmtSeq(vipAgreementVOs[i].getAgmtSeq());
							vipAgreementCntrVO.setCntrTpszCd(cntrTpszCds[t]);
							vipAgreementCntrVO.setCreUsrId(vipAgreementVOs[i].getCreUsrId());
							dbDao.addVIPAgmtCntr(vipAgreementCntrVO);
						}
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Sub trade code 조회.
	 * @param trdCd
	 * @return String
	 * @throws EventException
	 */
	@Override
	public String searchSubTradeList(String trdCd) throws EventException {
		String subTradeStr = null;

		try {
			String subTrdCds[] = dbDao.searchSubTradeList(trdCd);
			StringBuffer subTradeSB = new StringBuffer();
			for (int i=0; i<subTrdCds.length; i++) {
				subTradeSB.append(subTrdCds[i]);
				subTradeSB.append("|");
			}
			if (subTradeSB.length() > 0) {
				subTradeStr = subTradeSB.substring(0, subTradeSB.length() - 1);
			} else {
				subTradeStr = "";
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return subTradeStr;
	}

	/**
	 * Group Customer Code 조회.
	 * @param mdmCustomerGroupVO
	 * @return List<MdmCustomerGroupVO>
	 * @throws EventException
	 */
	public List<MdmCustomerGroupVO> searchGroupCustomerList(MdmCustomerGroupVO mdmCustomerGroupVO) throws EventException {
		List<MdmCustomerGroupVO> list = null;

		try {
			list = dbDao.searchGroupCustomerList(mdmCustomerGroupVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
}
