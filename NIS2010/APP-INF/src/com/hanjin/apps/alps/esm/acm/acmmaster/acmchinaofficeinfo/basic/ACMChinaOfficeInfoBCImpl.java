/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMChinaOfficeInfoBCImpl.java
*@FileTitle : ACMChinaOfficeInfoBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.06
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.06 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.integration.ACMChinaOfficeInfoDBDAO;
import com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.vo.ChinaInfoForLaneVO;
import com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.vo.ChinaOfficeInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ACMMaster Business Logic Command Interface<br>
 * - ALPS-ACMMaster에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0007Event,ACMChinaOfficeInfoBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ACMChinaOfficeInfoBCImpl extends BasicCommandSupport implements ACMChinaOfficeInfoBC {

	// Database Access Object
	private transient ACMChinaOfficeInfoDBDAO dbDao = null;

	/**
	 * ACMChinaOfficeInfoBCImpl 객체 생성<br>
	 * ACMChinaOfficeInfoDBDAO를 생성한다.<br>
	 */
	public ACMChinaOfficeInfoBCImpl() {
		dbDao = new ACMChinaOfficeInfoDBDAO();
	}

	/**
	 * [ESM_ACM_0007]
	 * O/B China Office Info 목록을 조회<br>
	 *
	 * @param ChinaOfficeInfoVO chinaOfficeInfoVO
	 * @return List<ChinaOfficeInfoVO>
	 * @exception EventException
	 */
	public List<ChinaOfficeInfoVO> searchOBChinaOfficeInfo(ChinaOfficeInfoVO chinaOfficeInfoVO) throws EventException {
		try {
			return dbDao.searchOBChinaOfficeInfo(chinaOfficeInfoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0007]
	 * O/B China Office Info 목록을 저장하기 위해 BKG모듈의 VO Setting<br>
	 *
	 * @param ChinaOfficeInfoVO[] chinaOfficeInfoVOs
	 * @return BkgChinaAgentVO[]
	 * @exception EventException
	 */
	public BkgChinaAgentVO[] manageOBChinaOfficeInfo(ChinaOfficeInfoVO[] chinaOfficeInfoVOs) throws EventException {
		try {
			// BKG모듈에 보내는 VOS의 갯수를 처음부터 알 수 없으므로,
			// 최종 생성된 VOList.size()만튼 VOS를 Define
			List<ChinaOfficeInfoVO> chinaOfficeInfoVOList = new ArrayList<ChinaOfficeInfoVO>();
			for (int i=0; i<chinaOfficeInfoVOs.length; i++) {
				// 타 chn_agn_cd + Vendor Code의 조합이 있는지 체크
				List<ChinaOfficeInfoVO> tempChinaOfficeInfoVOList = dbDao.getOtherChinaAgentVendor(chinaOfficeInfoVOs[i]);
				if (tempChinaOfficeInfoVOList.size() > 0) {
					// [ACM00004] - $s is duplicated. Please check $s again!
					throw new EventException(new ErrorHandler("ACM00004", new String[]{"Vendor Code [" + chinaOfficeInfoVOs[i].getVndrSeq() + "]", "Vendor Code"}).getMessage());
				}

				if ("I".equals(chinaOfficeInfoVOs[i].getIbflag())) {
					chinaOfficeInfoVOList.add(chinaOfficeInfoVOs[i]);

				} else if ("U".equals(chinaOfficeInfoVOs[i].getIbflag())) {
					chinaOfficeInfoVOList.add(chinaOfficeInfoVOs[i]);

					// delt_flag가 Y면 BKG모듈의 update메서드와 delete메서드 양쪽에 넘겨지도록 함.
					if ("Y".equals(chinaOfficeInfoVOs[i].getDeltFlg())) {
						chinaOfficeInfoVOs[i].setIbflag("D");
						chinaOfficeInfoVOList.add(chinaOfficeInfoVOs[i]);
					}
				}
			}

			BkgChinaAgentVO[] bkgChinaAgentVOs = new BkgChinaAgentVO[chinaOfficeInfoVOList.size()];
			BkgChinaAgentVO bkgChinaAgentVO = null;
			for (int i=0; i<chinaOfficeInfoVOList.size(); i++) {
				bkgChinaAgentVO = new BkgChinaAgentVO();
				bkgChinaAgentVO.setIbflag(chinaOfficeInfoVOList.get(i).getIbflag());
				bkgChinaAgentVO.setChnAgnCd(chinaOfficeInfoVOList.get(i).getChnAgnCd());
				bkgChinaAgentVO.setAgnNm(chinaOfficeInfoVOList.get(i).getAgnNm());
				bkgChinaAgentVO.setFincOfcCd(chinaOfficeInfoVOList.get(i).getFincOfcCd());
				bkgChinaAgentVO.setVndrSeq(chinaOfficeInfoVOList.get(i).getVndrSeq());
				bkgChinaAgentVO.setBkgBlckFlg(chinaOfficeInfoVOList.get(i).getBkgBlckFlg());
				bkgChinaAgentVO.setVndrCntCd(chinaOfficeInfoVOList.get(i).getVndrCntCd());
				bkgChinaAgentVO.setOfcCd(chinaOfficeInfoVOList.get(i).getOfcCd());
				bkgChinaAgentVO.setDiffRmk(chinaOfficeInfoVOList.get(i).getDiffRmk());
				bkgChinaAgentVO.setCustCntCd(chinaOfficeInfoVOList.get(i).getCustCntCd());
				bkgChinaAgentVO.setCustSeq(chinaOfficeInfoVOList.get(i).getCustSeq());
				bkgChinaAgentVO.setAutoDpChkFlg(chinaOfficeInfoVOList.get(i).getAutoDpChkFlg());
				bkgChinaAgentVO.setAgnEml(chinaOfficeInfoVOList.get(i).getAgnEml());
				bkgChinaAgentVO.setArOfcCd(chinaOfficeInfoVOList.get(i).getArOfcCd());
				bkgChinaAgentVO.setDirPayOfcCd(chinaOfficeInfoVOList.get(i).getDirPayOfcCd());
				bkgChinaAgentVOs[i] = bkgChinaAgentVO;
			}
			return bkgChinaAgentVOs;

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0005]
	 * I/B China Agent info 목록을 조회<br>
	 *
	 * @param ChinaInfoForLaneVO chinaInfoForLaneVO
	 * @return List<ChinaInfoForLaneVO>
	 * @exception EventException
	 */
	public List<ChinaInfoForLaneVO> searchIBChinaInfoForLane(ChinaInfoForLaneVO chinaInfoForLaneVO) throws EventException {
		try {
			return dbDao.searchIBChinaInfoForLane(chinaInfoForLaneVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0005]
	 * I/B China Agent info 목록을 저장<br>
	 *
	 * @param ChinaInfoForLaneVO[] chinaInfoForLaneVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIBChinaInfoForLane(ChinaInfoForLaneVO[] chinaInfoForLaneVOs, SignOnUserAccount account) throws EventException {
		List<ChinaInfoForLaneVO> insertVoList = new ArrayList<ChinaInfoForLaneVO>();
		List<ChinaInfoForLaneVO> updateVoList = new ArrayList<ChinaInfoForLaneVO>();
		try {
			for (int i=0; i<chinaInfoForLaneVOs.length; i++) {
				chinaInfoForLaneVOs[i].setUsrId(account.getUsr_id());

				if ("I".equals(chinaInfoForLaneVOs[i].getIbflag())) {
					// POD와 Lane의 중복 체크
					if (dbDao.getPodLaneFromIBChinaInfoForLane(chinaInfoForLaneVOs[i]).size() > 0) {
						// [ACM00006] - $s are duplicated. Please check $s once again.
						throw new EventException(new ErrorHandler("ACM00006", new String[]{"POD [" + chinaInfoForLaneVOs[i].getPodCd() + "] and Lane [" + chinaInfoForLaneVOs[i].getSlanCd() + "]", "POD and Lane"}).getMessage());
					}
					// AGN_CD와 VNDR_SEQ의 중복 체크 (조회건수가 0건이거나, 있다면 기존 조합과 맞아야 정상데이터)
					List<ChinaInfoForLaneVO> tempChinaInfoForLaneVOList = dbDao.getVendorFromIBChinaInfoForLane(chinaInfoForLaneVOs[i]);
					if (tempChinaInfoForLaneVOList.size() > 0 && !tempChinaInfoForLaneVOList.get(0).getVndrSeq().equals(chinaInfoForLaneVOs[i].getVndrSeq())) {
						// [ACM00011] - Different vendor code for the Agent [$s]. Please check vendor code again.
						throw new EventException(new ErrorHandler("ACM00011", new String[]{chinaInfoForLaneVOs[i].getAgnCd()}).getMessage());
					}
					insertVoList.add(chinaInfoForLaneVOs[i]);

				} else if ("U".equals(chinaInfoForLaneVOs[i].getIbflag())) {
					// POD나 Lane이 변경되었다면
					String podCd = chinaInfoForLaneVOs[i].getPodCd();
					String slanCd = chinaInfoForLaneVOs[i].getSlanCd();
					String orgPodCd = chinaInfoForLaneVOs[i].getOrgPodCd();
					String orgSlanCd = chinaInfoForLaneVOs[i].getOrgSlanCd();
					if (!podCd.equals(orgPodCd) || !slanCd.equals(orgSlanCd)) {
						// POD와 Lane의 중복 체크
						if (dbDao.getPodLaneFromIBChinaInfoForLane(chinaInfoForLaneVOs[i]).size() > 0) {
							// [ACM00006] - $s are duplicated. Please check $s once again.
							throw new EventException(new ErrorHandler("ACM00006", new String[]{"POD [" + podCd + "] and Lane [" + slanCd + "]", "POD and Lane"}).getMessage());
						}
					}
					// AGN_CD나 VNDR_SEQ가 변경되었다면
					String agnCd = chinaInfoForLaneVOs[i].getAgnCd();
					String vndrSeq = chinaInfoForLaneVOs[i].getVndrSeq();
					if (!agnCd.equals(chinaInfoForLaneVOs[i].getOrgAgnCd()) || !vndrSeq.equals(chinaInfoForLaneVOs[i].getOrgVndrSeq())) {
						// AGN_CD와 VNDR_SEQ의 중복 체크 (조회건수가 0건이거나, 있다면 기존 조합과 맞아야 정상데이터)
						List<ChinaInfoForLaneVO> tempChinaInfoForLaneVOList = dbDao.getVendorFromIBChinaInfoForLane(chinaInfoForLaneVOs[i]);
						if (tempChinaInfoForLaneVOList.size() > 0 && !vndrSeq.equals(tempChinaInfoForLaneVOList.get(0).getVndrSeq())) {
							// [ACM00011] - Different vendor code for the Agent [$s]. Please check vendor code again.
							throw new EventException(new ErrorHandler("ACM00011", new String[]{agnCd}).getMessage());
						}
					}
					updateVoList.add(chinaInfoForLaneVOs[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addIBChinaInfoForLane(insertVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyIBChinaInfoForLane(updateVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}