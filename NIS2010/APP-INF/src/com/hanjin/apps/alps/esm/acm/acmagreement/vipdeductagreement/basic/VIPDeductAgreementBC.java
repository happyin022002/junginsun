/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : VIPDeductAgreementBC.java
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

import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo.MdmCustomerGroupVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo.VIPAgreementVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * VIP Agreement Creation. Business Logic Command Interface
 * - ALPS-ACMAgreement에 대한 비지니스 로직에 대한 인터페이스
 *
 * @author 김상현
 * @see Esm_Acm_0039Event 참조
 * @since J2EE 1.6
 */
public interface VIPDeductAgreementBC {

	/**
	 * VIP agreement list 조회.
	 * @param vipAgreementVO
	 * @return List<VIPAgreementVO>
	 * @throws EventException
	 */
	public List<VIPAgreementVO> searchVIPAgreementList(VIPAgreementVO vipAgreementVO) throws EventException;

	/**
	 * VIP Agreement 추가/수정/삭제 처리.
	 * @param vipAgreementVO
	 * @param vipAgreementVOs
	 * @throws EventException
	 */
	public void multiVipAgreement(VIPAgreementVO vipAgreementVO, VIPAgreementVO[] vipAgreementVOs) throws EventException;

	/**
	 * Sub trade code 조회.
	 * @param trdCd
	 * @return String
	 * @throws EventException
	 */
	public String searchSubTradeList(String trdCd) throws EventException;

	/**
	 * Group Customer Code 조회.
	 * @param mdmCustomerGroupVO
	 * @return List<MdmCustomerGroupVO>
	 * @throws EventException
	 */
	public List<MdmCustomerGroupVO> searchGroupCustomerList(MdmCustomerGroupVO mdmCustomerGroupVO) throws EventException;
}
