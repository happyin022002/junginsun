/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMChinaOfficeInfoBCImpl.java
*@FileTitle : ACMChinaOfficeInfoBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.06
*@LastModifier : 源�긽��
*@LastVersion : 1.0
* 2012.03.06 源�긽��
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.integration.ACMChinaOfficeInfoDBDAO;
import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.vo.ChinaInfoForLaneVO;
import com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.vo.ChinaOfficeInfoVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMMaster Business Logic Command Interface<br>
 * - OPUS-ACMMaster����븳 鍮꾩��덉뒪 濡쒖쭅����븳 �명꽣�섏씠��br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0007Event,ACMChinaOfficeInfoBC 媛�DAO �대옒��李몄“
 * @since J2EE 1.6
 */
public class ACMChinaOfficeInfoBCImpl extends BasicCommandSupport implements ACMChinaOfficeInfoBC {

	// Database Access Object
	private transient ACMChinaOfficeInfoDBDAO dbDao = null;

	/**
	 * ACMChinaOfficeInfoBCImpl 媛앹껜 �앹꽦<br>
	 * ACMChinaOfficeInfoDBDAO瑜��앹꽦�쒕떎.<br>
	 */
	public ACMChinaOfficeInfoBCImpl() {
		dbDao = new ACMChinaOfficeInfoDBDAO();
	}

	/**
	 * [ESM_ACM_0007]
	 * O/B China Office Info 紐⑸줉��議고쉶<br>
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
	 * O/B China Office Info 紐⑸줉����옣�섍린 �꾪빐 BKG紐⑤뱢��VO Setting<br>
	 *
	 * @param ChinaOfficeInfoVO[] chinaOfficeInfoVOs
	 * @param account
	 * @return BkgChinaAgentVO[]
	 * @exception EventException
	 */
	public BkgChinaAgentVO[] manageOBChinaOfficeInfo(ChinaOfficeInfoVO[] chinaOfficeInfoVOs, SignOnUserAccount account) throws EventException {
		try {
			// BKG紐⑤뱢��蹂대궡��VOS��媛�닔瑜�泥섏쓬遺�꽣 �����놁쑝誘�줈,
			// 理쒖쥌 �앹꽦��VOList.size()留뚰듉 VOS瑜�Define
			List<ChinaOfficeInfoVO> chinaOfficeInfoVOList = new ArrayList<ChinaOfficeInfoVO>();
			List<ChinaOfficeInfoVO> updateVoList = new ArrayList<ChinaOfficeInfoVO>();
			
			for (int i=0; i<chinaOfficeInfoVOs.length; i++) {
				chinaOfficeInfoVOs[i].setUpdUsrId(account.getUsr_id());
				
				if ("I".equals(chinaOfficeInfoVOs[i].getIbflag())) {
					chinaOfficeInfoVOList.add(chinaOfficeInfoVOs[i]);

				} else if ("U".equals(chinaOfficeInfoVOs[i].getIbflag())) {
					updateVoList.add(chinaOfficeInfoVOs[i]);
					
					// delt_flag媛�Y硫�BKG紐⑤뱢��update硫붿꽌�쒖� delete硫붿꽌���묒そ���섍꺼吏�룄濡���
					if ("Y".equals(chinaOfficeInfoVOs[i].getDeltFlg())) {
						chinaOfficeInfoVOs[i].setIbflag("D");
						chinaOfficeInfoVOList.add(chinaOfficeInfoVOs[i]);
					}
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyOBChinaOfficeInfo(updateVoList);
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

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0005]
	 * I/B China Agent info 紐⑸줉��議고쉶<br>
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
	 * I/B China Agent info 紐⑸줉����옣<br>
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
					// POD��Lane��以묐났 泥댄겕
					if (dbDao.getPodLaneFromIBChinaInfoForLane(chinaInfoForLaneVOs[i]).size() > 0) {
						// [ACM00006] - $s are duplicated. Please check $s once again.
						throw new EventException(new ErrorHandler("ACM00006", new String[]{"POD [" + chinaInfoForLaneVOs[i].getPodCd() + "] and Lane [" + chinaInfoForLaneVOs[i].getSlanCd() + "]", "POD and Lane"}).getMessage());
					}
					// AGN_CD��VNDR_SEQ��以묐났 泥댄겕 (議고쉶嫄댁닔媛�0嫄댁씠嫄곕굹, �덈떎硫�湲곗〈 議고빀怨�留욎븘���뺤긽�곗씠��
					List<ChinaInfoForLaneVO> tempChinaInfoForLaneVOList = dbDao.getVendorFromIBChinaInfoForLane(chinaInfoForLaneVOs[i]);
					if (tempChinaInfoForLaneVOList.size() > 0 && !tempChinaInfoForLaneVOList.get(0).getVndrSeq().equals(chinaInfoForLaneVOs[i].getVndrSeq())) {
						// [ACM00011] - Different vendor code for the Agent [$s]. Please check vendor code again.
						throw new EventException(new ErrorHandler("ACM00011", new String[]{chinaInfoForLaneVOs[i].getAgnCd()}).getMessage());
					}
					insertVoList.add(chinaInfoForLaneVOs[i]);

				} else if ("U".equals(chinaInfoForLaneVOs[i].getIbflag())) {
					// POD��Lane��蹂�꼍�섏뿀�ㅻ㈃
					String podCd = chinaInfoForLaneVOs[i].getPodCd();
					String slanCd = chinaInfoForLaneVOs[i].getSlanCd();
					String orgPodCd = chinaInfoForLaneVOs[i].getOrgPodCd();
					String orgSlanCd = chinaInfoForLaneVOs[i].getOrgSlanCd();
					if (!podCd.equals(orgPodCd) || !slanCd.equals(orgSlanCd)) {
						// POD��Lane��以묐났 泥댄겕
						if (dbDao.getPodLaneFromIBChinaInfoForLane(chinaInfoForLaneVOs[i]).size() > 0) {
							// [ACM00006] - $s are duplicated. Please check $s once again.
							throw new EventException(new ErrorHandler("ACM00006", new String[]{"POD [" + podCd + "] and Lane [" + slanCd + "]", "POD and Lane"}).getMessage());
						}
					}
					// AGN_CD��VNDR_SEQ媛�蹂�꼍�섏뿀�ㅻ㈃
					String agnCd = chinaInfoForLaneVOs[i].getAgnCd();
					String vndrSeq = chinaInfoForLaneVOs[i].getVndrSeq();
					if (!agnCd.equals(chinaInfoForLaneVOs[i].getOrgAgnCd()) || !vndrSeq.equals(chinaInfoForLaneVOs[i].getOrgVndrSeq())) {
						// AGN_CD��VNDR_SEQ��以묐났 泥댄겕 (議고쉶嫄댁닔媛�0嫄댁씠嫄곕굹, �덈떎硫�湲곗〈 議고빀怨�留욎븘���뺤긽�곗씠��
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

	
	/**
	 * [ESM_ACM_0007]
	 * O/B China Office Info 에서 vendor code 중복 체크<br>
	 *
	 * @param ChinaOfficeInfoVO[] chinaOfficeInfoVOs
	 * @return result
	 * @exception EventException
	 */
	public String checkDupVendorCode(ChinaOfficeInfoVO[] chinaOfficeInfoVOs) throws EventException {
		String result = "";
		try {
			for (int i=0; i<chinaOfficeInfoVOs.length; i++) {
				List<ChinaOfficeInfoVO> tempChinaOfficeInfoVOList = dbDao.getOtherChinaAgentVendor(chinaOfficeInfoVOs[i]);
				if (tempChinaOfficeInfoVOList.size() > 0) {
					if("".equals(result)){
						result = tempChinaOfficeInfoVOList.get(0).getVndrSeq();
					}else{
						result += ", " + tempChinaOfficeInfoVOList.get(0).getVndrSeq();
					}
				}
			}
			
			return result;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}