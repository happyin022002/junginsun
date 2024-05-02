/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Kor24ManifestListDownloadBCImpl.java
*@FileTitle : Kor24ea24 Manifest List Download BC Impl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.05.25 박상훈
* 1.0 Creation
* -----------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.DateVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24BkgCstmsVvdSmryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24DischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.vo.Kor24ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.DischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration.Kor24ManifestListDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.BkgCstmsKrBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.BkgCstmsKrCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.BkgCstmsKrVvdSmryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.BlSummaryCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.BlSummaryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.ElNoMakeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BizNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BkgCntrQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BkgCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BkgCustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BlCustInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BlInfoKorVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BondCdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CblCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CgoDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CntrDataVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CorrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CustExistVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CustInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24CustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24DlContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24DnHistVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24DownCheckVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24DownHistVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ElNoKorVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24EmpAmdManiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24EmpBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24EmptyCorrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ExistCntVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ExpDataVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ExportCheckInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ExportInfoDNVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ExportNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24FullEmpSumVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24IbMtInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24IbTransWhfVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24KcdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MailBoxVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManiSumCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestCrsChkInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestDNVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestSmryCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MrnInfoKorVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MrnVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MrnVslSysEtaEtdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MsnNoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MsnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ObTransWhfVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24OldExpChkVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24OrgBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24RateHeadVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24SubNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24SumVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24VslInfoNManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24VslInfoNManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.EmpAmdManiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManiSumCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestSmryCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MsnNoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.SndCorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VslInfoNManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VslInfoNManifestVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsKrBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsKrCustVO;
import com.hanjin.syscommon.common.table.BkgCstmsKrDlHisVO;
import com.hanjin.syscommon.common.table.BkgCstmsKrXptLicVO;
import com.hanjin.syscommon.common.table.BkgRateVO;


/**
 * Alps-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - Alps-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG_1329EventResponse,Kor24ManifestListDownloadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class Kor24ManifestListDownloadBCImpl extends BasicCommandSupport implements Kor24ManifestListDownloadBC {

	private transient Kor24ManifestListDBDAO dbDao = null;

	/**
	 * Kor24ManifestListDownloadBCImpl 객체 생성<br>
	 * Kor24ManifestListDBDAO 생성한다.<br>
	 */
	public Kor24ManifestListDownloadBCImpl()
	{
		dbDao = new Kor24ManifestListDBDAO();
	}

	/**
	 * VVD,Port 등 입력 후 세관 신고 대상 List를 조회한다.
	 * @param ManifestListCondVO paramVO
	 * @return ManifestListDetailVO
	 * @exception EventException
	 */
	public ManifestListDetailVO searchManifestInfo(ManifestListCondVO paramVO) throws EventException
	{
		Kor24MrnNoVO manifestInfoVO = (Kor24MrnNoVO)paramVO;
		BkgCstmsKrDlHisVO checkParam = new BkgCstmsKrDlHisVO();
		String bldl 	= manifestInfoVO.getBlDl();
		String in_bound = manifestInfoVO.getInBound();
		String sel_type = manifestInfoVO.getSelType();
		String in_pod 	= manifestInfoVO.getInPod();
		String in_pol 	= manifestInfoVO.getInPol();
		String port_cd 	= in_pol;
		if (in_bound.equals("I")) {
			port_cd = in_pod;
			if (manifestInfoVO.getInHn().trim().length() > 0) port_cd = port_cd + manifestInfoVO.getInHn();
		}

		int cntr_local 	= 0;
		int cntr_ts		= 0;
		int cntr_empty 	= 0;
		int cntr_total 	= 0;
		int bl_local 	= 0;
		int bl_ts 		= 0;
		int bl_empty 	= 0;
		int bl_total 	= 0;

		Kor24ContainerVO container = new Kor24ContainerVO();
		List<Kor24ManifestInfoVO> list = null;
		List<Kor24BkgCntrQtyInfoVO> bkgCntrQtyInfo = null;
		BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO = new BkgCstmsKrDlHisVO();

		if("O".equals(in_bound)) manifestInfoVO.setKtPort(in_pol);
		else					 manifestInfoVO.setKtPort(in_pod);

		try
		{

			Kor24MrnNoVO fromClient = null;
			if("bl".equals(bldl))
			{

				// REDOWN 여부 조회
				bkgCstmsKrDlHisVO.setVvd	(manifestInfoVO.getInVvd()	);
				bkgCstmsKrDlHisVO.setInBound(manifestInfoVO.getInBound());
				bkgCstmsKrDlHisVO.setKtPort	(port_cd					);
				bkgCstmsKrDlHisVO.setPolLoc	(in_pol						);
				bkgCstmsKrDlHisVO.setPodLoc	(in_pod						);

				fromClient = dbDao.searchMrnNo(manifestInfoVO);
				if(fromClient == null) return null;

				manifestInfoVO.setMrnNo(fromClient.getMrnNo());
				manifestInfoVO.setMrnChkNo(fromClient.getMrnChkNo());

				container.setKor24MrnNoVO(fromClient);
				list = dbDao.searchManifestInfoList( manifestInfoVO);
				container.setKor24ManifestInfoVOs(list);

				bl_total = list.size();
				for(int i=0;i<list.size();i++)
				{
					String cntr_cnt = "0";

					Kor24ManifestInfoVO node = (Kor24ManifestInfoVO)list.get(i);
					String fE = node.getFe();
					String tP = node.getTp();

					String vvd_pol 		= node.getHidden1().substring(0,5);
					String vvd_pod 		= node.getHidden2().substring(0,5);
					String bkg_pol 		= node.getPol().substring(0,5);
					String bkg_pod 		= node.getPod().substring(0,5);
					String bkg_pod2 	= node.getPod().substring(0,2);
					String bkg_cgo_tp2 	= node.getFe();
					String bkg_no    	= node.getABkgNo();
					String bkg_split 	= node.getABkgNoSplit();

					if("O".equals(in_bound))
					{

						if(vvd_pol.equals(bkg_pol)) node.setTp("E");
						else						node.setTp("R");

						if(!vvd_pol.equals(bkg_pol) || "P".equals(bkg_cgo_tp2))
						{
							node.setCreatedType("C");
						}
						else if("US".equals(bkg_pod2) || "CA".equals(bkg_pod2) ||
						   "MX".equals(bkg_pod2) || "GT".equals(bkg_pod2))
						{
							if("P".equals(bkg_cgo_tp2)){//"P".equals(bkg_cgo_tp2) -> M
								node.setCreatedType("M");
							}else{
							node.setCreatedType("A");
							}
						}
						else
						{
							if("P".equals(bkg_cgo_tp2)){
						    	 node.setCreatedType("M");
						     }else{
							   node.setCreatedType("B");//"P".equals(bkg_cgo_tp2) -> M
						     }
						}


						if("A".equals(sel_type))
						{
							if("B".equals(node.getCreatedType()) || "C".equals(node.getCreatedType())||"M".equals(node.getCreatedType()))
							{
								list.remove(i);
								i--;
								continue;
							}
						}
						else if("B".equals(sel_type))
						{
							if("A".equals(node.getCreatedType()) || "C".equals(node.getCreatedType())||"M".equals(node.getCreatedType()))
							{
								list.remove(i);
								i--;
								continue;
							}
						}
						else if("C".equals(sel_type))
						{
							if("A".equals(node.getCreatedType()) || "B".equals(node.getCreatedType())||"M".equals(node.getCreatedType()))
							{
								list.remove(i);
								i--;
								continue;
							}
						}

//						else if("M".equals(sel_type))
//						{
//							if("A".equals(node.getCreatedType()) || "B".equals(node.getCreatedType())||"C".equals(node.getCreatedType()))
//							{
//								list.remove(i);
//								i--;
//								continue;
//							}
//						}

						if("C".equals(sel_type))
						{
							node.setHidden4(" ");
						}
					}
					else if("I".equals(in_bound))
					{
//						node.setCreatedType("N");
						if(in_pod.equals(bkg_pod))
						{
							 if("P".equals(bkg_cgo_tp2)){
						    	 node.setCreatedType("M");
						     }else{

							     node.setCreatedType("A");//"P".equals(bkg_cgo_tp2) -> M
						     }
						}

						if("A".equals(sel_type))
						{
							if(!"A".equals(node.getCreatedType()))
							{
								list.remove(i);
								i--;
								continue;
							}else{
								if("P".equals(bkg_cgo_tp2)){
									list.remove(i);
									i--;
									continue;
								}
							}
						} else {
							node.setCreatedType("N");//type 선택 안됐을 때
						}

//						// Inbound이고 A:Local Type인 경우 T/S가 'I'인 데이터만 검색되게 설정한다.
						if("I".equals(in_bound) && "A".equals(sel_type)){

							node.setTp("I");
						} else {
							if(bkg_pod.equals(vvd_pod)) node.setTp("I");
							else						node.setTp("T");
						}

						node.setFrobCheck(" ");
					}

					// DOWNLOAD 여부 조회
					checkParam.setInBound	(manifestInfoVO.getInBound()	);
					checkParam.setVvdCd		(manifestInfoVO.getInVvd()		);
					checkParam.setPolLoc	(manifestInfoVO.getInPol()		);
					checkParam.setPodLoc	(manifestInfoVO.getInPod()		);
					checkParam.setBkgNo		(bkg_no							);
					checkParam.setKcdTp		(node.getTp()					);
					if (manifestInfoVO.getInBound().equals("O")) {
						checkParam.setKtPort(manifestInfoVO.getInPol()		);
					} else {
						checkParam.setKtPort(manifestInfoVO.getInPod()		);
					}
					String downCount = dbDao.searchDownHistCheck(checkParam);
					if (downCount==null || downCount.compareTo("0")==0) {
						node.setDownYn("N");
					}else {
						node.setDownYn("Y");
					}

					if (manifestInfoVO.getInBound().equals("O")) {
						// OutBound 경우 다른 항차로 다운로드 여부 체크
						Kor24DownCheckVO downCheckVO = new Kor24DownCheckVO();
						downCheckVO.setPolCd		(manifestInfoVO.getInPol()		);
						downCheckVO.setPodCd		(manifestInfoVO.getInPod()		);
						downCheckVO.setIoBndCd		(manifestInfoVO.getInBound()	);
						downCheckVO.setBkgNo		(bkg_no							);
						downCheckVO.setCstmsDeclTpCd(node.getTp()					);
						downCheckVO = dbDao.searchDownCheck(downCheckVO);

						// OUT BOUND 의 경우 화면의 VVD 와 쿼리결과 VVD 가 다르면 오류(X)로 처리
						if (downCheckVO!=null && !downCheckVO.getVvd().trim().equals(manifestInfoVO.getInVvd().trim())) {
							node.setRoChk("X");
							node.setOtherVvd(downCheckVO.getVvd());
						}else {
							node.setRoChk("");
						}
					}

					// CUSTOMER TYPE 조회
					String custType = dbDao.searchCustType(bkg_no);
					node.setCustType(custType);

					if ("O".equals(in_bound) && node.getSc().equals("N")) {
						if (custType.equals("N")) node.setSc("C");
						if (custType.equals("B")) node.setSc("S");
					}


					bkgCntrQtyInfo = dbDao.searchCntrInfo(bkg_no, bkg_split);
					container.addKor24BkgCntrQtyInfoVO(bkgCntrQtyInfo);
					//컨테이너 카운트
					cntr_total += bkgCntrQtyInfo.size();
					cntr_cnt = Integer.toString(bkgCntrQtyInfo.size());
					node.setCntr(Integer.toString(bkgCntrQtyInfo.size()));
					for(int m=0;m<bkgCntrQtyInfo.size();m++)
					{
						if("P".equals(bkg_cgo_tp2) || "R".equals(bkg_cgo_tp2))
						{
							bkgCntrQtyInfo.get(m).setCntrType("E");
							cntr_empty ++;
						}
						else
						{
							if("E".equals(node.getTp()) || "I".equals(node.getTp()))
							{
								bkgCntrQtyInfo.get(m).setCntrType("L");
								cntr_local ++;
							}
							else
							{
								bkgCntrQtyInfo.get(m).setCntrType("T");
								cntr_ts ++;
							}
						}
					}

					tP = node.getTp();
					if("P".equals(fE) || "R".equals(fE)) bl_empty++;
					else if("I".equals(tP) || "E".equals(tP)) bl_local++;
					else bl_ts++;

					if("R".equals(node.getTp())) node.setSc("S");

					if("E".equals(node.getTp()))
					{
						if("S".equals(node.getSc()))
						{
							Kor24ExportNoVO exportNoVO = dbDao.searchExportInfo(bkg_no, bkg_split);
							if(exportNoVO == null)
							{
								//1403
								node.setElnoWgtCheck("U");
							}
							else
							{
								String elno_wgt = exportNoVO.getMfWgt().substring(0, 8);
								node.setElNoCheck(exportNoVO.getXptLicNo());
								String act_wgt = node.getActWgt().substring(0, 8);

								if(elno_wgt.equals(act_wgt) && node.getPckQty().equals(exportNoVO.getPckQty()))
								{
									if("E".equals(exportNoVO.getXptLicNo())) node.setElnoWgtCheck("U");
									else									 node.setElnoWgtCheck("M");
								}
								else
								{
									node.setElnoWgtCheck("U");
								}
							}
						}
						else
						{
							Kor24ExportCheckInfoVO exportCheckVO = dbDao.searchExportCheckInfo(bkg_no, bkg_split);
							if(exportCheckVO != null)
							{
								if("".equals(exportCheckVO.getBkgCheck())) exportCheckVO.setBkgCheck(" ");
							}
							node.setElnoWgtCheck(" ");

							if("".equals(node.getElNoCheck())) node.setElNoCheck(" ");
							node.setElnoWgtCheck(" ");
						}
					}
					else
					{
						node.setElNoCheck(" ");
						node.setElnoWgtCheck(" ");
					}

					node.setElnoA(node.getElNoCheck());
					node.setElnoB(node.getElnoWgtCheck());

					Kor24CustInfoVO kor24CustInfoVO = dbDao.searchCustInfo(in_bound, bkg_no, bkg_split);
					if(kor24CustInfoVO != null)
					{
						node.setShprN(kor24CustInfoVO.getShprName());
						node.setShprA(kor24CustInfoVO.getShprAddr());
						node.setCneeN(kor24CustInfoVO.getCneeName());
						node.setCneeA(kor24CustInfoVO.getCneeAddr());
						node.setNtfyN(kor24CustInfoVO.getNtfyName());
						node.setNtfyA(kor24CustInfoVO.getNtfyAddr());
						node.setCustName(kor24CustInfoVO.getUsrs14().replaceAll("\r\n", " ").replaceAll("\n", " ").replaceAll("\r", " "));
					}
					Kor24CgoDescVO vo = new Kor24CgoDescVO();
					vo.setABkgNo(node.getABkgNo());
					String kor24CargoDescVO = dbDao.searchCargoDesc(vo);

					if("".equals(kor24CargoDescVO)) kor24CargoDescVO = "N";
					node.setDescCode(kor24CargoDescVO);

					String cnt_cd = "";
					String cust_cd = "";

					/*
					 *
					 * Congignee Name이 TO THE ORDER OF 이면
					 * Notify의 상호를 biz no로 셋팅 하기 위한 변수
					 */
					boolean notifyBzNoFlag = false;
					String custNm = "";

					if("E".equals(node.getTp()) || "R".equals(node.getTp()))
					{
						String biz_no = dbDao.searchOBBizNo(vo);
						if("".equals(biz_no) || biz_no == null)
						{
							Kor24CustVO biz_01 = dbDao.searchCntCdTpS(node.getABkgNo(), node.getABkgNoSplit());
							if(biz_01 != null)
							{
								cnt_cd = biz_01.getCntCd();
								cust_cd = biz_01.getCustCd();
							}
						}
					}
					else
					{
						Kor24CustVO biz_01 = dbDao.searchCntCdTpC(node.getABkgNo(), node.getABkgNoSplit());
						if(biz_01 != null)
						{
							cnt_cd = biz_01.getCntCd();
							cust_cd = biz_01.getCustCd();
							custNm = biz_01.getCustNm();

							/**
							 * 2010.11.15 경종윤 [CHM-201007078] 화주의 사업자등록번호 기재 보완요청
							 * 2011.11.15 김현화 [] TO THE ORDER OF 에서 ORDER로 변경 -AA안정선
							 */

							//if (Pattern.compile("TO.*ORDER.*", Pattern.CASE_INSENSITIVE).matcher(custNm.toUpperCase()).matches()){
							if (Pattern.compile(".*ORDER.*", Pattern.CASE_INSENSITIVE).matcher(custNm.toUpperCase()).matches()){

							//if(custNm.toUpperCase().trim().startsWith("TO THE ORDER OF")) {
								notifyBzNoFlag = true;
								biz_01 = dbDao.searchCntCdTpN(node.getABkgNo(), node.getABkgNoSplit());
								cnt_cd = biz_01.getCntCd();
								cust_cd = biz_01.getCustCd();
							}


							/*
							 * 추가 부분
							 */
						}
					}

					if(cnt_cd.length() == 2 || notifyBzNoFlag)
					{
						String rtn = dbDao.searchRegNo(cnt_cd, cust_cd);
						if(rtn == null) node.setBz("N");
						else			node.setBz(rtn);
					}
					else
					{
						node.setBz("N");
					}

					if("N".equals(node.getMsn()) ||
					   "N".equals(node.getDescCode()) ||
					   "N".equals(node.getShprA()) ||
					   "N".equals(node.getShprN()) ||
					   "N".equals(node.getCneeN()) ||
					   "N".equals(node.getCneeA()) ||
					   "N".equals(node.getBz()) ||
					   "0".equals(cntr_cnt) ||
					   "0".equals(node.getPkgValue()) ||
					   "0".equals(node.getWgtValue()) )
					{
						node.setErrChk("E");
					}
					else
					{
						if("I".equals(node.getTp()) || "T".equals(node.getTp()))
						{
							if ("I".equals(node.getTp()) && "N".equals(node.getWh())) {
								node.setErrChk("E");
							}else if("N".equals(node.getBac()) || "N".equals(node.getCneeA()) || "N".equals(node.getNtfyN()))
							{
								node.setErrChk("E");
							}
							else
							{
								node.setErrChk("N");
							}
						}
						else
						{
							if (node.getElnoA()!=null && node.getElnoB()!=null && node.getElnoA().equals("Y") && node.getElnoB().equals("U")) {
								node.setErrChk("E");
							} else 	if (node.getSc().equals("C") && node.getElnoA()!=null && node.getElnoA().equals("Y")) {
								node.setErrChk("E");
							} else if (node.getSc().equals("S") && node.getElnoA()!=null && node.getElnoA().equals("N")) {
								node.setErrChk("E");
							}else {
								node.setErrChk("N");
							}
						}
					}

				} // for Loop
			}
//			else if("dl".equals(bldl))
			else
			{
				if(!"A".equals(sel_type) && !"B".equals(sel_type) && !"C".equals(sel_type) && !"D".equals(sel_type) && !"M".equals(sel_type))
				{
					manifestInfoVO.setSelType("N");
					sel_type = "N";
				}

				manifestInfoVO.setInPodTmnl(manifestInfoVO.getInPod() + manifestInfoVO.getInHn());


				String etbDt = "";
				if("O".equals(in_bound)) {
					manifestInfoVO.setKtPort(in_pol);
					etbDt = dbDao.searchEtbDate(manifestInfoVO.getInVvd(), in_pol);
				} else {
					manifestInfoVO.setKtPort(in_pod);
					// * Inbound의 경우는 OB_DECL_TP_CD = 'N' 이므로 MRN No 검색을 위하여 임의로 sel_type을 N으로 설정한다.
					if(!"M".equals(sel_type)) manifestInfoVO.setSelType("N");
				}

				Kor24MrnVO kor24MrnVO = dbDao.searchMrnNoKor(manifestInfoVO);
				if(kor24MrnVO == null) return null;

				manifestInfoVO.setMrnNo(kor24MrnVO.getMrnNo());
				manifestInfoVO.setMrnChkNo(kor24MrnVO.getMrnChkNo());
				manifestInfoVO.setEtaEtd(kor24MrnVO.getEtaEtd());
				manifestInfoVO.setEtdDt(kor24MrnVO.getEtdDt());
				manifestInfoVO.setEtbDt(etbDt);

				container.setKor24MrnNoVO(manifestInfoVO);

				// Inbound의 경우 *에서 설정한 원래의 sel_type을 되돌린다.
				if("I".equals(in_bound)) {
					manifestInfoVO.setSelType(sel_type);
				}

				list = dbDao.searchManifestInfoKorList(manifestInfoVO);

				if(list == null) return null;
				container.setKor24ManifestInfoVOs(list);

				bl_total = list.size();
				for(int i=0;i<list.size();i++)
				{
					Kor24ManifestInfoVO node = (Kor24ManifestInfoVO)list.get(i);
					String kt_us_bound = node.getHidden5();
					node.setInVvd(manifestInfoVO.getInVvd());
					String fE = node.getFe();
					String tP = node.getTp();

					// Container 목록 조회
					bkgCntrQtyInfo =  dbDao.searchCNTRCntInfoList(node.getABkgNo(), node.getTp(), manifestInfoVO.getKtPort(), manifestInfoVO.getInVvd(), node.getCBlNo());
					container.addKor24BkgCntrQtyInfoVO(bkgCntrQtyInfo);

					if("O".equals(in_bound))
					{
						node.setKtPort(in_pol);

						if("A".equals(sel_type))
						{
							if(!"A".equals(kt_us_bound))
							{
								list.remove(i);
								i--;
								continue;
							}else{
								if("P".equals(fE)){
									list.remove(i);
									i--;
									continue;
								}
							}

						}
						else if("B".equals(sel_type))
						{
							if(!"B".equals(kt_us_bound))
							{
								list.remove(i);
								i--;
								continue;
							}else{
								if("P".equals(fE)){
									list.remove(i);
									i--;
									continue;
								}
							}
						}
						else if("C".equals(sel_type))
						{
							if(!"C".equals(kt_us_bound))
							{
								list.remove(i);
								i--;
								continue;
							}
						}
						else if("D".equals(sel_type))
						{
							if("N".equals(kt_us_bound))
							{
								list.remove(i);
								i--;
								continue;
							}
							if("C".equals(kt_us_bound)) node.setBac(" ");
						}

						if("C".equals(kt_us_bound)) node.setBac(" ");

						Kor24ManifestInfoVO iBManifest = dbDao.searchIBManifestInfoKor(in_pol, node);
						if(iBManifest != null)
						{
							node.setPkgValue(iBManifest.getPkgValue());
							node.setPkgCode(iBManifest.getPkgCode());
							node.setWgtValue(iBManifest.getWgtValue());
							node.setWgtCode(iBManifest.getWgtCode());
							node.setMatch(iBManifest.getMatch());
							node.setPreVvd(iBManifest.getPreVvd());
						}
					}
					else if("I".equals(in_bound))
					{
						if("A".equals(sel_type))
						{
							if(!node.getPod().equals(in_pod))
							{
								list.remove(i);
								i--;
								continue;
							}else{
								if("P".equals(fE)){
									list.remove(i);
									i--;
									continue;
								}
							}
						} else if("M".equals(sel_type))
						{
							node.setCreatedType("M");
						} else {
							node.setCreatedType("N");
						}

						node.setKtPort(in_pod);
						if("T".equals(node.getTp())) node.setWh(" ");
					}

					if("P".equals(fE) || "R".equals(fE)) bl_empty++;
					else if("I".equals(tP) || "E".equals(tP)) bl_local++;
					else bl_ts++;

					Kor24ManifestInfoVO custInfo = dbDao.searchCustInfoKor(node);

					if(custInfo != null)
					{
						node.setShprN(custInfo.getShprN());
						node.setShprA(custInfo.getShprA());
						node.setCneeN(custInfo.getCneeN());
						node.setCneeA(custInfo.getCneeA());
						node.setNtfyN(custInfo.getNtfyN());
						node.setNtfyA(custInfo.getNtfyA());
						node.setCustName(custInfo.getCustName());
					}

					// CUSTOMER TYPE 조회
					String custType = dbDao.searchCustType(node.getABkgNo());
					node.setCustType(custType);

					String checkValue = dbDao.searchCustInfoCheck(node);
					if("N".equals(checkValue)) node.setShprA("N");

					//컨테이너 토탈카운트
					String cntr_cnt = dbDao.searchCntrTtlCntKor(node);
					//컨테이너 Count
					node.setCntr(cntr_cnt);
					node.setCntrCnt(cntr_cnt);

					String elno_wgt_check = null;
					String elno_check = null;

					if("E".equals(node.getTp()))
					{
						if("S".equals(node.getSc()))
						{
							Kor24ExportNoVO pExportInfo = dbDao.searchExportInfoKor(node);

							if(pExportInfo == null)
							{
								elno_wgt_check = "U";
							}
							else if(node.getHidden4().substring(0, 8).equals(pExportInfo.getElnoWgt().substring(0, 8)) &&
									 node.getHidden6().equals(pExportInfo.getPckQty()))
							{
								elno_wgt_check = "M";
								elno_check = pExportInfo.getElnoCheck();
							}
							else
							{
								elno_wgt_check = "U";
								elno_check = pExportInfo.getElnoCheck();
							}
						}
						else
						{
							elno_wgt_check = " ";
							elno_check = " ";
						}
					}
					else
					{
						elno_wgt_check = " ";
						elno_check = " ";
					}

					node.setElnoWgtCheck(elno_wgt_check);
					node.setElNoCheck(elno_check);
					node.setElnoA(node.getElNoCheck());
					node.setElnoB(node.getElnoWgtCheck());

					//에러필드 체크
					if("N".equals(node.getMsn()) ||
					   "N".equals(node.getDescCode()) ||
					   "N".equals(node.getShprA()) ||
					   "N".equals(node.getShprN()) ||
					   "N".equals(node.getCneeA()) ||
					   "N".equals(node.getCneeN()) ||
					   "N".equals(node.getBz()) ||
					   "0".equals(cntr_cnt) ||
					   "0".equals(node.getPkgValue()) ||
					   "0".equals(node.getWgtValue()) )
					{
						node.setErrChk("E");
					}
					else
					{
						if("I".equals(node.getTp()) || "T".equals(node.getTp()))
						{
							if ("I".equals(node.getTp()) && "N".equals(node.getWh())) {
								node.setErrChk("E");
							}else if("N".equals(node.getBac()) || "N".equals(node.getCneeA()))
							{
								node.setErrChk("E");
							}
							else
							{
								node.setErrChk("N");
							}
						}
						else
						{
							if (node.getElnoA()!=null && node.getElnoB()!=null && node.getElnoA().equals("Y") && node.getElnoB().equals("U")) {
								node.setErrChk("E");
							} else 	if (node.getSc().equals("C") && node.getElnoA()!=null && node.getElnoA().equals("Y")) {
								node.setErrChk("E");
							} else if (node.getSc().equals("S") && node.getElnoA()!=null && node.getElnoA().equals("N")) {
								node.setErrChk("E");
							}else {
								node.setErrChk("N");
							}
						}
					}

				} //Main Query For Loop
			}

			manifestInfoVO.setCntrLocal(Integer.toString(cntr_local));
			manifestInfoVO.setCntrTs(Integer.toString(cntr_ts));
			manifestInfoVO.setCntrEmpty(Integer.toString(cntr_empty));
			manifestInfoVO.setCntrTotal(Integer.toString(cntr_total));
			manifestInfoVO.setBlLocal(Integer.toString(bl_local));
			manifestInfoVO.setBlEmpty(Integer.toString(bl_empty));
			manifestInfoVO.setBlTotal(Integer.toString(bl_total));
			manifestInfoVO.setBlTs(Integer.toString(bl_ts));

			// Manifest Check 인 경우, Diff(Package, Weight)가 발생한 경우만 List에 담는다.
			// 단, 패키지 포장 단위는 비교 대상에서 제외한다.
			if("mc".equals(bldl)){
				List<Kor24ManifestInfoVO> diffList = container.getKor24ManifestInfoVOs();
				List<Kor24ManifestInfoVO> diffNewList = new ArrayList<Kor24ManifestInfoVO>();

				if(diffList != null){
					for(int i=0; i<diffList.size(); i++){
						Kor24ManifestInfoVO diffVO = diffList.get(i);
						if("Y".equals(diffVO.getPckQtyChk()) || "Y".equals(diffVO.getCntrTtlWgtChk()) || "Y".equals(diffVO.getWgtUtCdChk())){
							diffNewList.add(diffVO);
						}
					}

					container.setKor24ManifestInfoVOs(diffNewList);
				}
			}
//			else if("cr".equals(bldl)){
//
//				List<Kor24ManifestCrsChkInfoVO> diffList = container.getKor24ManifestCrsChkInfoVOs();
//				List<Kor24ManifestCrsChkInfoVO> diffNewList = new ArrayList<Kor24ManifestCrsChkInfoVO>();
//
//				if(diffList != null){
//					for(int i=0; i<diffList.size(); i++){
//						Kor24ManifestCrsChkInfoVO diffVO = diffList.get(i);
//						//if("Y".equals(diffVO.getMfDlDiffFlg()) && "N".equals(diffVO.getMfSndFlg())){
//							diffNewList.add(diffVO);
//						//}
//					}
//
//					container.setKor24ManifestCrsChkInfoVOs(diffNewList);
//				}
//			}
		}
		catch (DAOException de)
		{
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return container;
	}	//End

	/**
	 * 이미 다운로드 되었던 Manifest에 대해서 만약 아직 전송이 되지 않은 상태일 경우에 대해서 manage한다.
	 * @param ManifestListCondVO manifestListCondVO
	 * @return int
	 * @exception EventException
	 */
	public int manageManifest(ManifestListCondVO manifestListCondVO)throws EventException
	{
		Kor24DlContainerVO condition = (Kor24DlContainerVO) manifestListCondVO;

		Kor24MrnNoVO condData = condition.getKor24MrnNoVO();
		Kor24ManifestInfoVO[] condList = condition.getKor24ManifestInfoVOs();
		int delcount = 0;

		try
		{
			if("dl".equals(condData.getBlDl()))
			{
				for(int i=0;i<condList.length;i++)
				{

					BkgCstmsKrBlVO bkgCstmsKrBlVO = new BkgCstmsKrBlVO();

					String kcd_tp = condList[i].getTp();
					String kt_port = "";
					String trans_seq = condList[i].getHidden3();

					if("O".equals(condData.getInBound())) kt_port = condData.getInPol();
					else								  kt_port = condData.getInPod();

					bkgCstmsKrBlVO.setBkgNo(condList[i].getABkgNo());
					bkgCstmsKrBlVO.setKcdTp(kcd_tp);
					bkgCstmsKrBlVO.setKtSeq(trans_seq);
					bkgCstmsKrBlVO.setKtPort(kt_port);
					bkgCstmsKrBlVO.setUsrId(condition.getUser_id());

					String cnt = dbDao.searchKor24MainSndCount(bkgCstmsKrBlVO);

					if("".equals(cnt)) cnt = "0";
					int i_cnt = Integer.parseInt(cnt);

					if(i_cnt > 0)
					{
						dbDao.modifyDelMarkKor(bkgCstmsKrBlVO);
						continue;
					}

					BkgCstmsKrCntrVO bkgCstmsKrCntrVO = new BkgCstmsKrCntrVO();
					bkgCstmsKrCntrVO.setBkgNo(condList[i].getABkgNo());
					bkgCstmsKrCntrVO.setKcdTp(kcd_tp);
					bkgCstmsKrCntrVO.setKtSeq(trans_seq);
					bkgCstmsKrCntrVO.setKtPort(kt_port);
					bkgCstmsKrCntrVO.setCBlNo(condList[i].getCBlNo());
					int deleteCount = dbDao.removeCNTRInfoKor(bkgCstmsKrCntrVO);

					BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO = new BkgCstmsKrXptLicVO();
					bkgCstmsKrXptLicVO.setBkgNo(condList[i].getABkgNo());
					bkgCstmsKrXptLicVO.setKcdTp(kcd_tp);
					bkgCstmsKrXptLicVO.setKtSeq(trans_seq);
					bkgCstmsKrXptLicVO.setKtPort(kt_port);
					deleteCount = dbDao.removeElNoInfoKor(bkgCstmsKrXptLicVO);

					BkgCstmsKrCustVO bkgCstmsKrCustVO = new BkgCstmsKrCustVO();
					bkgCstmsKrCustVO.setBkgNo(condList[i].getABkgNo());
					bkgCstmsKrCustVO.setKcdTp(kcd_tp);
					bkgCstmsKrCustVO.setKtSeq(trans_seq);
					bkgCstmsKrCustVO.setKtPort(kt_port);
					deleteCount = dbDao.removeCustInfoKor(bkgCstmsKrCustVO);
					deleteCount = dbDao.removeBlInfoKor(bkgCstmsKrBlVO);
					String maxseq = dbDao.searchMaxSeqDownHistKor(condData.getMrnNo() + condData.getMrnChkNo(), condData.getInVvd());

					if("".equals(maxseq) || maxseq == null)maxseq = "0";
					Long i_maxseq = Long.parseLong(maxseq);
					i_maxseq ++;
					BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO = new BkgCstmsKrDlHisVO();

					bkgCstmsKrDlHisVO.setMrnNbr(condData.getMrnNo());
					bkgCstmsKrDlHisVO.setMrnChk(condData.getMrnChkNo());
					bkgCstmsKrDlHisVO.setKdhSeq(Long.toString(i_maxseq));
					bkgCstmsKrDlHisVO.setPol(condData.getInPol());
					bkgCstmsKrDlHisVO.setPod(condData.getInPod());
					bkgCstmsKrDlHisVO.setUserName(condition.getUser_id());
					bkgCstmsKrDlHisVO.setDeleteBlCnt(Integer.toString(deleteCount));
					bkgCstmsKrDlHisVO.setVvd(condData.getInVvd());
					bkgCstmsKrDlHisVO.setUserName(condition.getUser_id());
					bkgCstmsKrDlHisVO.setOffice(condition.getOffice());
					//BKG_CSTMS_KR_DL_HIS
					dbDao.addDownHistKor(bkgCstmsKrDlHisVO);
					delcount++;
				}
			}
		}
		catch (DAOException de)
		{
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
		return delcount;
	}

	/**
	 * ManifestList 한국세관쪽으로 다운로드
	 * @param ManifestListCondVO manifestListCondVO
	 * @param SignOnUserAccount account
	 * @return List<ManifestListDetailVO>
	 * @exception EventException
	 */
	public List<ManifestListDetailVO> downloadCstmsBlList( ManifestListCondVO manifestListCondVO , SignOnUserAccount account) throws EventException {
		// 파라메터 객체 변환
		Kor24DlContainerVO condition = (Kor24DlContainerVO) manifestListCondVO;

		Kor24MrnNoVO condData = condition.getKor24MrnNoVO();
		// 화면에서 넘어온 ManifestList
		Kor24ManifestInfoVO[] condList = condition.getKor24ManifestInfoVOs();
		// PORT
		String kt_port = null;
		// Down 여부 판단
		String downCount = null;
		// DownLoad 전의 MRN, DATE 들 조회용
		Kor24MrnVslSysEtaEtdVO mrnVslSysEtaEtdCondVO = new Kor24MrnVslSysEtaEtdVO();
		Kor24MrnVslSysEtaEtdVO mrnVslSysEtaEtdVO = null;
		// Cargo Desc 조회용 객체
		Kor24CgoDescVO cargoParam = new Kor24CgoDescVO();
		// CREATE TYPE
		String createType = null;
		// Download 여부 CHECK
		BkgCstmsKrDlHisVO checkParam = new BkgCstmsKrDlHisVO();
		// KCD_TP
		String kcd_tp = null;
		// VVD, POL, POD 비교용 임시 변수
		String down_vvd_pol = null;
		String down_vvd_pod = null;
		String down_bkg_pol = null;
		String down_bkg_pod = null;
		String wh_whf_ind   = null;
		// 최초 DOWN 의 경우
		Kor24ManifestDNVO[] kor24MainfestDNVOs = null;
		Kor24ManifestDNVO down = null;
		// ReDown 의 경우
		Kor24ManifestInfoVO reDownNode = null;
		// 위험여부 정보 조회
		String dangerInfo[] = null;
		// Container 조회관련 객체
		Kor24BkgCntrVO paramNode = null;
		Kor24BkgCntrVO kor24BkgCntrVO = null;
		BkgCstmsKrCntrVO param1 = new BkgCstmsKrCntrVO();
		List<Kor24BkgCntrVO> kor24BkgCntrVOs = null;
		// Export Info 조회용 객체
		List<Kor24ExportInfoDNVO> exportList = null;
		// Customer Info 조회용 객체
		List<Kor24BkgCustVO> custInfoList = null;
		// VVD Summary 조회용 객체
		Kor24BkgCstmsVvdSmryVO paramVO = new Kor24BkgCstmsVvdSmryVO();
		// Transmit Check 용 객체
		BkgCstmsKrBlVO searchTransMit = null;
		BkgCstmsKrBlVO transParam = new BkgCstmsKrBlVO();
		BkgCstmsKrBlVO seqNSndHistParam = new BkgCstmsKrBlVO();
		BkgCstmsKrBlVO seqNSndHisKor24 = null;
		// 전송 SEQ 조회
		List<BkgCstmsKrBlVO> seqNSndHisKor24s = null;
		// BIZ No 조회
		Kor24BizNoVO kor24BizNoVO = new Kor24BizNoVO();
		// EL No 조회
		ElNoMakeVO elNoMakeVO = new ElNoMakeVO();
		// Trans Type 조회
		Kor24IbTransWhfVO ibTransWhfVO = null;
		Kor24ObTransWhfVO obTransWhfVO = null;
		String transTypeStr = null;
		String transTypeChg = null;
		// Container Full Empty Check
		String cntrFe = null;
		// Ts Empty 관련 객체
		Kor24IbMtInfoVO kor24IbMtInfoVO = null;
//		Kor24CblVO kor24CblVO = new Kor24CblVO();
//		String cntr_kcd_tp = null;
		Kor24KcdVO kor24kcdVO = new Kor24KcdVO();
		String[] cust_kcd_tp = null;
		Kor24CblCntrVO cblCntrVO = null;
		String newCBlNo = null;

		String bbChk = null;
		String bbBkgNo = null;
		String bbBlNo = null;

		// 다운로드 전체 건수
		long totalDownloadCnt = 0;
		// 삭제 전체 건수
		long totalDeleteCnt = 0;
		// Mrn Number Modify 여부
		boolean ifModifyMrnNo = false;

		try
		{
			// InBound, OutBound 에 따른 PORT
			kt_port = condData.getInPod();
			if("O".equals(condData.getInBound())) kt_port = condData.getInPol();

			// MRN No, Eta/Etd/Current Date 조회
			mrnVslSysEtaEtdCondVO.setInVvd	(condData.getInVvd()	);
			mrnVslSysEtaEtdCondVO.setInBound(condData.getInBound()	);
			mrnVslSysEtaEtdCondVO.setInPol	(condData.getInPol()	);
			mrnVslSysEtaEtdCondVO.setInPod	(condData.getInPod()	);
			// 조회
			mrnVslSysEtaEtdVO = dbDao.searchMrnVslSysDtEtaEtdDt(mrnVslSysEtaEtdCondVO);

			// 조회 결과가 없을 경우 MAX 값을 다시 조회
			if (mrnVslSysEtaEtdVO==null) {
				mrnVslSysEtaEtdVO = dbDao.searchMrnVslSysDtEtaEtdMaxDt(mrnVslSysEtaEtdCondVO);
			}

			// MRN 정보 셋팅
			condData.setMrnNo	(mrnVslSysEtaEtdVO.getMrnNo()	);
			condData.setMrnChkNo(mrnVslSysEtaEtdVO.getMrnChkNo());

			for(int idx=0; idx<condList.length; idx++)
			{
				Kor24ManifestInfoVO node = condList[idx];
				// BL, BKG No 셋팅
				condData.setBlNo	(node.getBlNo()		);
				condData.setInBkgNo	(node.getBkgNo()	);
				createType = "N";

				// DOWNLOAD 여부 조회
				checkParam.setInBound	(condData.getInBound()	);
				checkParam.setVvdCd		(condData.getInVvd()	);
				checkParam.setPolLoc	(condData.getInPol()	);
				checkParam.setPodLoc	(condData.getInPod()	);
				checkParam.setBkgNo		(node.getABkgNo()		);
				checkParam.setKcdTp		(node.getTp()			);
				checkParam.setKtPort	(kt_port				);
				downCount = dbDao.searchDownHistCheck(checkParam);

				if (downCount==null || downCount.compareTo("0") == 0)
				{
					// 최초DownLoad
					kcd_tp = "T";

					node.setInVvd		(condData.getInVvd()		);
					node.setInPol		(condData.getInPol()		);
					node.setInPod		(condData.getInPod()		);
					node.setInBound		(condData.getInBound()		);
					node.setInBlno		(condData.getBlNo()			);
					node.setMrnNbr		(condData.getMrnNo()		);
					node.setInPodTmnl	(condData.getInPodTmnl()	);
					node.setKtPort		(kt_port					);
					kor24MainfestDNVOs = dbDao.searchDownManifestInfo(node);

					if(kor24MainfestDNVOs == null)	continue;

					for(int idxDn=0; idxDn < kor24MainfestDNVOs.length; idxDn++) {

						down = kor24MainfestDNVOs[idxDn];

						down_vvd_pol = down.getHidden1().substring(0, 5);
						down_vvd_pod = down.getHidden2().substring(0, 5);
						down_bkg_pol = down.getPol().substring(0, 5);
						down_bkg_pod = down.getPod().substring(0, 5);
						wh_whf_ind = "";

						if("O".equals(condData.getInBound()))
						{
							//OutBound
							kt_port = down.getHidden1();

							if(down_vvd_pol.equals(down_bkg_pol))
							{
								Kor24RateHeadVO rh = dbDao.searchExemptWhf(node.getBkgNo());
								if(rh == null)
								{
									kcd_tp = "E";
								}
								else
								{
									wh_whf_ind = rh.getWhfInd();
									kcd_tp = rh.getKcdTp();
								}
							}
							else
							{
								kcd_tp = "R";
							}

							if ( down_vvd_pol.equals(down_bkg_pol) ) {
								if (down.getPod().startsWith("US") || down.getPod().startsWith("CA") ||
										  down.getPod().startsWith("MX") || down.getPod().startsWith("GT"))
								{
									if("P".equals(down.getFe())){
										down.setCreatedType("M");
										createType = "M";
									}else{
										down.setCreatedType("A");
										createType = "A";
									}
								}
								else
								{
									if("P".equals(down.getFe())){
										down.setCreatedType("M");
										createType = "M";
									}else{
										down.setCreatedType("B");
										createType = "B";
									}
								}
							} else if(!down_vvd_pol.equals(down_bkg_pol) || "P".equals(down.getFe()))
							{
								down.setCreatedType("C");
								createType = "C";
							}

							if("A".equals(condData.getSelType()))
							{
								if("B".equals(down.getCreatedType())) continue;
								if("C".equals(down.getCreatedType())) continue;
								if("M".equals(down.getCreatedType())) continue;
							}
							if("B".equals(condData.getSelType()))
							{
								if("A".equals(down.getCreatedType())) continue;
								if("C".equals(down.getCreatedType())) continue;
								if("M".equals(down.getCreatedType())) continue;
							}
							if("C".equals(condData.getSelType()) && !"P".equals(down.getFe()))
							{
								if("A".equals(down.getCreatedType())) continue;
								if("B".equals(down.getCreatedType())) continue;
								if("M".equals(down.getCreatedType())) continue;
								down.setBac("");
							}
							if("M".equals(condData.getSelType()))
							{
								if("A".equals(down.getCreatedType())) continue;
								if("B".equals(down.getCreatedType())) continue;
								if("C".equals(down.getCreatedType())) continue;
								down.setBac("");
							}

							String custType = dbDao.searchCustType(down.getABkgNo());

							if (down.getSc().equals("N")) {
								if (custType.equals("N")) down.setSc("C");
								if (custType.equals("B")) down.setSc("S");
							}
						}
						else
						{
							//InBound

							kt_port = down.getHidden2();

							if(down_vvd_pod.equals(down_bkg_pod))
							{
								kcd_tp = "I";
								down.setTp("I");
							}
							else
							{
								if("KRPUS".equals(down_vvd_pod) || "KRKAN".equals(down_vvd_pod))
								{
									if(down.getPod().startsWith("KR"))  {
										kcd_tp = "I";
										down.setTp("I");
									}
									else {
										kcd_tp = "T";
										down.setTp("T");
									}
								}
								else
								{
									kcd_tp = "T";
									down.setTp("T");
								}
							}
							//InBound의 경우 CreatedType은 항상 N
//							down.setCreatedType("N");
//							createType = "N";
							if("P".equals(down.getFe())){
								down.setCreatedType("M");
								createType = "M";
							}else{
								down.setCreatedType("N");
								createType = "N";
							}
							down.setFfordCd(" ");
							
							
							//jjang 2013/11/27 B/L Order Type에 따른 console/simple 구분(김대준 차장)
							//order인 경우 Notify       N-> 'Console' B-> 'Simple' 
							//             consignee
							String custType = dbDao.searchCustOrderType(down.getABkgNo());

							if (custType.equals("N")){
								down.setSc("C");
							}else{								
								down.setSc("S");
							}
							
						}

						dangerInfo = dbDao.searchDangerInfo(down.getABkgNo(), down.getABkgNoSplit());
						kor24BkgCntrVOs = dbDao.searchBKGCNTRList(down.getABkgNo(), down.getABkgNoSplit());

						if("P".equals(down.getFe()) || "R".equals(down.getFe())) {
							cntrFe = "E";
						}else {
							cntrFe = "F";
						}

						
					
						if("R".equals(kcd_tp) && !"Y".equals(wh_whf_ind))	down.setSc("S");
						
						//jjang 2013/11/27 inbound T/S는 무조건 Simple B/L로 처리(김대준 차장)
						if("T".equals(kcd_tp))	down.setSc("S");		
						
						

						exportList = null;
						if("E".equals(kcd_tp) && "S".equals(down.getSc()))
						{
							//OutBound Simple일 경우
							exportList = dbDao.searchExportInfoDNList(down.getABkgNo(), down.getABkgNoSplit());
						}

						custInfoList = dbDao.searchCustomerInfoList(down.getABkgNo(), down.getABkgNoSplit());


						cargoParam.setABkgNo(down.getABkgNo());
						cargoParam = dbDao.searchCargoDescDN(cargoParam);

						if("I".equals(kcd_tp) || "T".equals(kcd_tp)) 		kt_port = down.getHidden2();  //vvd_pod = Hidden2
						else if("E".equals(kcd_tp) || "R".equals(kcd_tp)) 	kt_port = down.getHidden1();	//vvd_pol = Hidden1

						String expt_kcd_tp = "";
						String temp_kcd_type = "";

						// 추가된 컨테이너 번호가 존재하고 KCD_TP 가 E이거나 R이면
						kor24IbMtInfoVO = null;
						if (down.getCntrNo()!=null && down.getCntrNo().length() > 1 &&
							(kcd_tp.equals("E") || kcd_tp.equals("R")) )
						{
							kor24IbMtInfoVO = dbDao.searchIbTsMtInfo(down.getCntrNo());

							// 조회 결과 세팅
							if (kor24IbMtInfoVO!=null && kor24IbMtInfoVO.getInCgoTp().equals("P")) {

								down.setIbMtyBkgNo		(kor24IbMtInfoVO.getInBkg()	);
								down.setIbMtyBlNo		(kor24IbMtInfoVO.getInCBl()	);
								down.setIbTrnsSeq		(kor24IbMtInfoVO.getInSeq()	);
								down.setIbCstmsDeclTpCd	(kor24IbMtInfoVO.getInTpCd()	);
								down.setIbDmstPortCd	(kor24IbMtInfoVO.getInPort()	);
								down.setIbVslCd			(kor24IbMtInfoVO.getInVsl()	);
								down.setIbSkdVoyNo		(kor24IbMtInfoVO.getInVoy()	);
								down.setIbSkdDirCd		(kor24IbMtInfoVO.getInDir()	);
								down.setIbEtaDt			(kor24IbMtInfoVO.getInEta()	);
							}

						}

						// 전송된 데이터의 SEQ 조회
						seqNSndHistParam.setBkgNo		(down.getABkgNo()		);
						if (kor24IbMtInfoVO!=null && kor24IbMtInfoVO.getInCgoTp().equals("P")) {
							seqNSndHistParam.setKcdTp	("R"					);
						} else {
							seqNSndHistParam.setKcdTp	(kcd_tp					);
						}
						seqNSndHistParam.setKtPort		(kt_port				);
						seqNSndHistParam.setCBlNo		(down.getCBlNo()		);
						seqNSndHisKor24s = dbDao.searchSeqNSndHistKor(seqNSndHistParam);

						int i_seq = 0;
						if(seqNSndHisKor24s != null)
						{
							if(seqNSndHisKor24s.size() > 0)
							{
								seqNSndHisKor24 = seqNSndHisKor24s.get(0);
								String seq = seqNSndHisKor24.getKtSeq();
								String chk = seqNSndHisKor24.getKtSndDtChk();

								if(seq==null || "".equals(seq)) seq = "0";
								if(chk==null || "".equals(chk)) chk = "0";

								i_seq = Integer.parseInt(seq);
								int i_chk = Integer.parseInt(chk);
								// FE 가 P 가 아니거나 P 이면 idxDN이 0인 경우만 처리
								if (!down.getFe().equals("P") || (down.getFe().equals("P") && idxDn==0)) {
									if (i_seq > 0 && i_chk == 0) continue;
								}
							}
						}

						if (i_seq > 0) {

							// TransType 및 ExemptWhf 조회
							if("O".equals(condData.getInBound())) {
								// OUT-Bound 시
								obTransWhfVO = new Kor24ObTransWhfVO();
								obTransWhfVO.setBkgNo	(down.getABkgNo()		);
								obTransWhfVO.setKcdTp	(kcd_tp					);
								obTransWhfVO.setKtSeq	(String.valueOf(i_seq)	);
								obTransWhfVO.setKtPort	(kt_port				);
								obTransWhfVO = dbDao.searchObTransTpExpWhf(obTransWhfVO);

								// 조회 값 저장
								if (obTransWhfVO!=null) {
									temp_kcd_type = obTransWhfVO.getTransType();
									expt_kcd_tp   = obTransWhfVO.getExptKcdTp();
								}
							}else {
								// IN-Bound 시
								ibTransWhfVO = new Kor24IbTransWhfVO();
								ibTransWhfVO.setBkgNo	(down.getABkgNo()		);
								ibTransWhfVO.setKcdTp	(kcd_tp					);
								ibTransWhfVO.setKtSeq	(String.valueOf(i_seq)	);
								ibTransWhfVO.setKtPort	(kt_port				);
								ibTransWhfVO = dbDao.searchIbTransTpExpWhf(ibTransWhfVO);

								// 조회 값 저장
								if (ibTransWhfVO!=null) {
									temp_kcd_type = ibTransWhfVO.getTransType();
									expt_kcd_tp   = ibTransWhfVO.getExptKcdTp();
								}
							}

							if(temp_kcd_type != null)
							{
								if(!temp_kcd_type.equals(kcd_tp) && !"".equals(temp_kcd_type))
								{
									kcd_tp = temp_kcd_type;
								}
							}

							if("R".equals(expt_kcd_tp) || "T".equals(expt_kcd_tp))
							{
								kcd_tp = expt_kcd_tp;
							}
						}

						// FE 가 P가 아니거나 P 이면서 처음1건만 + 처리
						if (!down.getFe().equals("P") || (down.getFe().equals("P") && kt_port.equals("KRPUS") && idxDn==0)
							|| (down.getFe().equals("P") && !kt_port.equals("KRPUS"))
							|| (i_seq == 0) ) i_seq++;

						// 추가된 컨테이너 번호가 존재하고 KCD_TP 가 E이거나 R이면
						if (down.getCntrNo()!=null && down.getCntrNo().length() > 1 &&
							(kcd_tp.equals("E") || kcd_tp.equals("R")) )
						{
							// 조회 결과 세팅
							if (kor24IbMtInfoVO!=null) {
								// 값이 존재하고 IN_CGO_TP가 P 이면 EXPT_KCD_TP를 R로 변경
								if (kor24IbMtInfoVO.getInCgoTp().equals("P")) expt_kcd_tp = "R";
							}
						}

						down.setAImoClass1(dangerInfo[0]);
						down.setAImoClass2(dangerInfo[1]);
						down.setAImoClass3(dangerInfo[2]);
						down.setDesc1(cargoParam.getDescCode1());
						down.setDesc2(cargoParam.getDescCode2());
						down.setKtSeq(Integer.toString(i_seq));
						down.setKcdTp(kcd_tp);
						down.setExptKcdTp(expt_kcd_tp);
						down.setKtPort(kt_port);
						down.setUsBound(down.getCreatedType());
						down.setUsername(account.getUsr_id());
						down.setVvdCd(condData.getInVvd());
						down.setVvdPod(down.getHidden2());
						down.setVvdPol(down.getHidden1());
						down.setBkgPol(node.getPol());
						down.setBkgPod(node.getPod());
						down.setMsnBltp(down.getSc());
						down.setBkgCgoTp(down.getFe());

						down.setBkgPkgCd(node.getPckTpCd());
						down.setBkgActwgtTp(node.getWgtUtCd());
						down.setBkgActwgtTp(down.getWgtUtCd());
						down.setBkgMeaTp(node.getMeasUtCd());
						//cmdt_rep
						down.setCmdtRep(down.getCm());
						down.setBondAreaCode(down.getBac());
						down.setWhouse(down.getWh());
						down.setWhouseDesc(down.getWhdesc());

						down.setEtaDt(mrnVslSysEtaEtdVO.getEtaDt());
						down.setEtdDt(mrnVslSysEtaEtdVO.getEtdDt());
						down.setKtSts("");
						down.setSelType(node.getSelType());
						
						//가상의 msn No 사용
						down.setMsn(node.getMsn());

						bbChk = dbDao.searchBreakBulkCheck(checkParam);  //break bulk 포함 여부 체크
						
						
						if (bbChk.compareTo("2") == 0){
							
							
							String tBkgNo = down.getBkgNo();
							String tBlNo = down.getBlNo();
							String tCBlNo = down.getCBlNo();
							String tBkgCgoTp = down.getBkgCgoTp();
//							String tExptKcdTp = down.getExptKcdTp();
							String tPckQty = down.getPckQty();
							String tActWgt = down.getActWgt();
							String tMeasQty = down.getMeasQty();
							String tMsnBltp = down.getMsnBltp();
//							String tKcdTp = down.getKcdTp();
							String tCgoDesc1 = down.getDesc1();
							String tCgoDesc2 = down.getDesc2();
							String tCmdtRep = down.getCmdtRep();
							
							//가상의 msn No 사용
							//String tMsn = down.getMsn();
							String tMsn = node.getMsn();
							
							String tBoundAreaCode = down.getBondAreaCode();
							String tWhouse = down.getWhouse();

							down.setBkgCgoTp("B");	  //Cargo Type: Break Bulk, Bulk WGT, Bulk MEA 추가
							dbDao.addBlInfoKor(down); // 기존  bkg no 생성 BKG_CSTMS_KR_BL

//							bbBkgNo = dbDao.searchFirstTmpBkgNoAssign(account.getOfc_cd(), account.getUsr_id());
//							bbBlNo = dbDao.searchFirstTmpBlNoAssign();

							bbBlNo = "SEM"+tBlNo.substring(3);
							bbBkgNo = bbBlNo;

							down.setBkgNo(bbBkgNo);
//							down.setBlNo(bbBlNo);
							down.setCBlNo(bbBlNo);
							down.setBkgCgoTp("R");
//							down.setExptKcdTp("E");
							down.setPckQty("0");
							down.setActWgt("0");
							down.setMeasQty("0");
							down.setMsnBltp("E");
//							down.setKcdTp("E");
							down.setDesc1("EMPTY CONTAINER");
							down.setDesc2("");
							down.setCmdtRep("860900");

							if(!"O".equals(condData.getInBound()))
							{
								down.setMsn("");
								down.setBondAreaCode("ST03077006");
								down.setWhouse("R");
							}


							dbDao.addBlInfoKor(down); //신규 bkg no, 신규bl no로 생성 BKG_CSTMS_KR_BL

							down.setBkgNo(tBkgNo);
//							down.setBlNo(tBlNo);
							down.setCBlNo(tCBlNo);
							down.setBkgCgoTp(tBkgCgoTp);
//							down.setExptKcdTp(tExptKcdTp);
							down.setPckQty(tPckQty);
							down.setActWgt(tActWgt);
							down.setMeasQty(tMeasQty);
							down.setMsnBltp(tMsnBltp);
//							down.setKcdTp(tKcdTp);
							down.setDesc1(tCgoDesc1);
							down.setDesc2(tCgoDesc2);
							down.setCmdtRep(tCmdtRep);

							if(!"O".equals(condData.getInBound()))
							{
								down.setMsn(tMsn);
								down.setBondAreaCode(tBoundAreaCode);
								down.setWhouse(tWhouse);
							}


						}else {
							
							dbDao.addBlInfoKor(down);
						}
						
						
						totalDownloadCnt++;

//						// C_BL 별 KCD_TP 재조회
//						kor24CblVO.setBkgNo		(down.getABkgNo()	);
//						kor24CblVO.setTrnsSeq		(down.getKtSeq()	);
//						kor24CblVO.setDmstPortCd	(down.getKtPort()	);
//						kor24CblVO.setCBlNo		(down.getCBlNo()	);
//						kor24CblVO.setVvd			(down.getVvdCd()	);
//
//						cntr_kcd_tp = dbDao.searchCblKcdTp(kor24CblVO);

						if (bbChk.equals("2")){	   //Break Bulk와 섞여 있는 경우

							if (down.getFe().equals("P") && down.getKtPort().equals("KRPUS")) {
								paramNode = kor24BkgCntrVOs.get(idxDn);
								if(paramNode.getBBbCgoFlg().equals("Y")){
									param1.setBkgNo		(bbBkgNo					);
									param1.setCBlNo		(bbBlNo						);
									param1.setFeInd		("E"						);
									param1.setCntrPkgQty("0"						);
									param1.setCntrWgtQty("0"						);
									param1.setCntrMeaQty("0"						);
									param1.setSealNo1	("");
									param1.setSealNo2	("");
								}else{
									param1.setBkgNo		(down.getABkgNo()			);
									param1.setCBlNo		(down.getCBlNo()			);
									param1.setFeInd		(cntrFe						);
									param1.setCntrPkgQty(paramNode.getBCntrPkgQty()	);
									param1.setCntrWgtQty(paramNode.getBCntrWgtQty()	);
									param1.setCntrMeaQty(paramNode.getBCntrMeaQty()	);
									param1.setSealNo1	(paramNode.getBCntrSealNo1());
									param1.setSealNo2	(paramNode.getBCntrSealNo2());
								}

								param1.setKtSeq		(down.getKtSeq()			);
								param1.setBkgNoSplit(down.getABkgNoSplit()		);
								param1.setExptKcdTp	(expt_kcd_tp				);
//								param1.setKcdTp		(cntr_kcd_tp				);
								param1.setKcdTp		(kcd_tp      				);
								param1.setCntrNo	(paramNode.getBCntrNo()		);
								param1.setCntrtsCd	(paramNode.getBCntrtsCd()	);
								param1.setCntrPkgCd	(paramNode.getBCntrPkgCd()	);
								param1.setCntrWgtTp	(paramNode.getBCntrWgtTp()	);
								param1.setCntrMeaTp	(paramNode.getBCntrMeaTp()	);
								param1.setKtPort	(kt_port					);
								param1.setUsername	(account.getUsr_id()		);

								dbDao.addCNTRInfoKor(param1);

							}else {

								for(int j=0;j<kor24BkgCntrVOs.size();j++)
								{
									paramNode = kor24BkgCntrVOs.get(j);

									if(paramNode.getBBbCgoFlg().equals("Y")){
										param1.setBkgNo		(bbBkgNo					);
										param1.setCBlNo		(bbBlNo			            );
										param1.setFeInd		("E"						);
										param1.setCntrPkgQty("0"						);
										param1.setCntrWgtQty("0"						);
										param1.setCntrMeaQty("0"						);
										param1.setSealNo1	("");
										param1.setSealNo2	("");
									}else{
										param1.setBkgNo		(down.getABkgNo()			);
										param1.setCBlNo		(down.getCBlNo()			);
										param1.setFeInd		(cntrFe						);
										param1.setCntrPkgQty(paramNode.getBCntrPkgQty()	);
										param1.setCntrWgtQty(paramNode.getBCntrWgtQty()	);
										param1.setCntrMeaQty(paramNode.getBCntrMeaQty()	);
										param1.setSealNo1	(paramNode.getBCntrSealNo1());
										param1.setSealNo2	(paramNode.getBCntrSealNo2());
									}
										param1.setKtSeq		(down.getKtSeq()			);
										param1.setBkgNoSplit(down.getABkgNoSplit()		);
										param1.setExptKcdTp	(expt_kcd_tp				);
//										param1.setKcdTp		(cntr_kcd_tp				);
										param1.setKcdTp		(kcd_tp      				);
										param1.setCntrNo	(paramNode.getBCntrNo()		);
										param1.setCntrtsCd	(paramNode.getBCntrtsCd()	);
										param1.setCntrPkgCd	(paramNode.getBCntrPkgCd()	);
										param1.setCntrWgtTp	(paramNode.getBCntrWgtTp()	);
										param1.setCntrMeaTp	(paramNode.getBCntrMeaTp()	);
										param1.setKtPort	(kt_port					);
										param1.setUsername	(account.getUsr_id()		);

										dbDao.addCNTRInfoKor(param1); //기존 컨테이너 추가

									}
								}

							param1.setBkgNo		(down.getABkgNo()			);
							param1.setCBlNo		(down.getCBlNo()			);
							param1.setKtSeq		(down.getKtSeq()			);
							param1.setBkgNoSplit(down.getABkgNoSplit()		);
							param1.setKtPort	(kt_port					);
							param1.setUsername	(account.getUsr_id()		);
							param1.setExptKcdTp	(expt_kcd_tp				);
							param1.setKcdTp		(kcd_tp      				);
							param1.setCntrNo	("IN BULK");
							param1.setFeInd		("");
							param1.setCntrPkgQty("0");
							param1.setCntrWgtQty("0");
							param1.setCntrMeaQty("0");
//							param1.setKcdTp		(cntr_kcd_tp				);
							param1.setSealNo1	("");
							param1.setSealNo2	("");
							param1.setCntrtsCd	("");
							param1.setCntrPkgCd	("");
							param1.setCntrWgtTp	("");
							param1.setCntrMeaTp	("");


							dbDao.addCNTRInfoKor(param1);


						}else {		//break Bulk가 섞여 있지 않은 경우
						// Empty BL 인경우 CNTR는 하나씩 할당
						if (down.getFe().equals("P") && down.getKtPort().equals("KRPUS")) {
							paramNode = kor24BkgCntrVOs.get(idxDn);

							param1.setKtSeq		(down.getKtSeq()			);
							param1.setBkgNo		(down.getABkgNo()			);
							param1.setBkgNoSplit(down.getABkgNoSplit()		);
							param1.setExptKcdTp	(expt_kcd_tp				);
//							param1.setKcdTp		(cntr_kcd_tp				);
							param1.setKcdTp		(kcd_tp      				);
							param1.setCntrNo	(paramNode.getBCntrNo()		);
							param1.setFeInd		(cntrFe						);
							param1.setSealNo1	(paramNode.getBCntrSealNo1());
							param1.setSealNo2	(paramNode.getBCntrSealNo2());
							param1.setCntrtsCd	(paramNode.getBCntrtsCd()	);
							param1.setCntrPkgQty(paramNode.getBCntrPkgQty()	);
							param1.setCntrPkgCd	(paramNode.getBCntrPkgCd()	);
							param1.setCntrWgtQty(paramNode.getBCntrWgtQty()	);
							param1.setCntrWgtTp	(paramNode.getBCntrWgtTp()	);
							param1.setCntrMeaQty(paramNode.getBCntrMeaQty()	);
							param1.setCntrMeaTp	(paramNode.getBCntrMeaTp()	);
							param1.setKtPort	(kt_port					);
							param1.setUsername	(account.getUsr_id()		);
							param1.setCBlNo		(down.getCBlNo()			);

							dbDao.addCNTRInfoKor(param1);

						}else {

							for(int j=0;j<kor24BkgCntrVOs.size();j++)
							{

								paramNode = kor24BkgCntrVOs.get(j);

									param1.setKtSeq		(down.getKtSeq()			);
									param1.setBkgNo		(down.getABkgNo()			);
									param1.setBkgNoSplit(down.getABkgNoSplit()		);
									param1.setExptKcdTp	(expt_kcd_tp				);
//									param1.setKcdTp		(cntr_kcd_tp				);
									param1.setKcdTp		(kcd_tp      				);
									param1.setCntrNo	(paramNode.getBCntrNo()		);
									param1.setFeInd		(cntrFe						);
									param1.setSealNo1	(paramNode.getBCntrSealNo1());
									param1.setSealNo2	(paramNode.getBCntrSealNo2());
									param1.setCntrtsCd	(paramNode.getBCntrtsCd()	);
									param1.setCntrPkgQty(paramNode.getBCntrPkgQty()	);
									param1.setCntrPkgCd	(paramNode.getBCntrPkgCd()	);
									param1.setCntrWgtQty(paramNode.getBCntrWgtQty()	);
									param1.setCntrWgtTp	(paramNode.getBCntrWgtTp()	);
									param1.setCntrMeaQty(paramNode.getBCntrMeaQty()	);
									param1.setCntrMeaTp	(paramNode.getBCntrMeaTp()	);
									param1.setKtPort	(kt_port					);
									param1.setUsername	(account.getUsr_id()		);
									param1.setCBlNo		(down.getCBlNo()			);

									dbDao.addCNTRInfoKor(param1); //기존 컨테이너 추가

								}

							}

						} //break Bulk가 섞여 있지 않은 경우

							if(!"MAIL BOX".equals(cargoParam.getDescCode1()))
							{
								if("O".equals(condData.getInBound()))
								{
									if("R".equals(kcd_tp))
									{
										Kor24ElNoKorVO elNoVO = new Kor24ElNoKorVO();
										elNoVO.setBkgNo(down.getABkgNo());
										elNoVO.setBkgNoSplit(down.getABkgNoSplit());
										elNoVO.setKtPort(kt_port);
										String elNo = dbDao.searchElNoKor(elNoVO);
										if(elNo !=null)
										{
											Kor24MailBoxVO kor24MailBoxVO = new Kor24MailBoxVO();
											kor24MailBoxVO.setBmeElno(elNo);
											kor24MailBoxVO.setBkgNo(down.getABkgNo());
											kor24MailBoxVO.setExptKdTp(expt_kcd_tp);
											kor24MailBoxVO.setKcdTp(kcd_tp);
											kor24MailBoxVO.setKtSeq(Integer.toString(i_seq));
											kor24MailBoxVO.setKtPort(kt_port);
											kor24MailBoxVO.setBkgPkgQty("");
											kor24MailBoxVO.setBkgActwgtQty(down.getActWgt());
											kor24MailBoxVO.setBkgActwgtTp(down.getWgtUtCd());
											kor24MailBoxVO.setBkgPkgQty(down.getPckQty());
											kor24MailBoxVO.setBkgPkgCd(down.getPckTpCd());
											kor24MailBoxVO.setCBlNo(down.getCBlNo());
											kor24MailBoxVO.setUsername(account.getUsr_id());
											dbDao.addExportNo(kor24MailBoxVO);



										} else {

											/*
											 * 2010년 6월 29일 화요일 경종윤
											 * 수출 T/S 화물의 면장은 아래와 같이 Other Reference No에 입력하면 적하목록 Download 시   Export License coulmn에 적용이 되게 적용
											 * (elNo 값이 없을시 TS_REF_NO값으로 대체한다.
											 */
											List<Kor24ExportInfoDNVO> exportList1 = null;
											exportList1 = dbDao.searchExportInfoDNList(down.getABkgNo(), down.getABkgNoSplit());

											if(exportList1 != null && exportList1.size() > 0) {

												elNo = exportList1.get(0).getEBmeElno();
												if(elNo != null && elNo.length() > 0) {

													Kor24MailBoxVO kor24MailBoxVO = new Kor24MailBoxVO();
													kor24MailBoxVO.setBmeElno(elNo);
													kor24MailBoxVO.setBkgNo(down.getABkgNo());
													kor24MailBoxVO.setExptKdTp(expt_kcd_tp);
													kor24MailBoxVO.setKcdTp(kcd_tp);
													kor24MailBoxVO.setKtSeq(Integer.toString(i_seq));
													kor24MailBoxVO.setKtPort(kt_port);
													kor24MailBoxVO.setBkgPkgQty("");
													kor24MailBoxVO.setBkgActwgtQty(down.getActWgt());
													kor24MailBoxVO.setBkgActwgtTp(down.getWgtUtCd());
													kor24MailBoxVO.setBkgPkgQty(down.getPckQty());
													kor24MailBoxVO.setBkgPkgCd(down.getPckTpCd());
													kor24MailBoxVO.setCBlNo(down.getCBlNo());
													kor24MailBoxVO.setUsername(account.getUsr_id());
													dbDao.addExportNo(kor24MailBoxVO);
												}
											}
										}
									}
								}
							}
							else
							{

								Kor24MailBoxVO kor24MailBoxVO = new Kor24MailBoxVO();
								kor24MailBoxVO.setBkgNo(down.getABkgNo());
								kor24MailBoxVO.setExptKdTp(expt_kcd_tp);
								kor24MailBoxVO.setKcdTp(kcd_tp);
								kor24MailBoxVO.setKtSeq(Integer.toString(i_seq));
								kor24MailBoxVO.setKtPort(kt_port);
								kor24MailBoxVO.setBkgPkgQty("");
								kor24MailBoxVO.setBkgActwgtQty(down.getActWgt());
								kor24MailBoxVO.setBkgActwgtTp(down.getWgtUtCd());
								kor24MailBoxVO.setBkgPkgQty(down.getPckQty());
								kor24MailBoxVO.setBkgPkgCd(down.getPckTpCd());
								kor24MailBoxVO.setBmeElno("NCV");
								kor24MailBoxVO.setUsername(account.getUsr_id());
								kor24MailBoxVO.setCBlNo(down.getCBlNo());
								dbDao.addExportNoMailBoxKor(kor24MailBoxVO);
							}


						if(exportList != null)
						{
							for(int j=0;j<exportList.size(); j++)
							{
								Kor24ExportInfoDNVO exportNode = exportList.get(j);
								// ELNO 가 없으면 SKIP 처리
								if (exportNode.getEBmeElno()==null || exportNode.getEBmeElno().trim().length() < 1) continue;
								BkgCstmsKrXptLicVO exportNoParam = new BkgCstmsKrXptLicVO();
								exportNoParam.setBkgNo	   (down.getABkgNo()			);
								exportNoParam.setExptKcdTp (expt_kcd_tp					);
								exportNoParam.setKcdTp	   (kcd_tp						);
								exportNoParam.setKtSeq	   (Integer.toString(i_seq)		);
								exportNoParam.setKtPort	   (kt_port						);
								exportNoParam.setBmeElno   (exportNode.getEBmeElno()	);
								exportNoParam.setBmePkgQty (exportNode.getEBmePkgQty()	);
								exportNoParam.setBmePkgCd  (exportNode.getEBmePkgTp()	);
								exportNoParam.setBmeWgtQty (exportNode.getEBmeWgtQty()	);
								exportNoParam.setBmeWgtTp  (exportNode.getEBmeWgtTp()	);
								exportNoParam.setBmeDivInd (exportNode.getEBmeDivInd()	);
								exportNoParam.setBmeDivSeq (exportNode.getEBmeDivSeq()	);
								exportNoParam.setBmeDpkgQty(exportNode.getEBmeDpkgQty()	);
								exportNoParam.setBmeDpkgCd (exportNode.getEBmeDpkgTp()	);
								exportNoParam.setBmeDwgtQty(exportNode.getEBmeDwgtQty()	);
								exportNoParam.setBmeDwgtTp (exportNode.getEBmeDwgtTp()	);
								exportNoParam.setBmeSmpSeq (exportNode.getEBmeSmpSeq()	);
								exportNoParam.setCBlNo	   (down.getCBlNo()          	);
								exportNoParam.setUsername  (account.getUsr_id()			);
								dbDao.addExportNoKor(exportNoParam);
							}
						}


						String biz_CntCd = "";
						String biz_CustCd = "";
						/*
						 *
						 * Congignee Name이 TO THE ORDER OF 이면
						 * Notify의 상호를 biz no로 셋팅 하기 위한 변수
						 */
						boolean notifyBzNoFlag = false;

						// KCD_TP 재조회
						kor24kcdVO.setBkgNo		(down.getABkgNo()	);
						kor24kcdVO.setTrnsSeq		(down.getKtSeq()	);
						kor24kcdVO.setDmstPortCd	(down.getKtPort()	);
						kor24kcdVO.setVvd			(down.getVvdCd()	);
						cust_kcd_tp = dbDao.searchKcdTpCust(kor24kcdVO);


						if(custInfoList != null)
						{

							for(int j=0;j<custInfoList.size();j++)
							{
								Kor24BkgCustVO custNode = custInfoList.get(j);
								BkgCstmsKrCustVO custParam = new BkgCstmsKrCustVO();
								custParam.setInBound(condData.getInBound());


								if("S".equals(custNode.getCBcsTp()) && " ".equals(custNode.getCCustAddr()))
								{
									custNode.setCCustAddr(".");
								}

								if (cust_kcd_tp!=null) {
									// 조회된 KCD_TP 만큼 LOOP
									for(int k=0; k < cust_kcd_tp.length; k++) {

										custParam.setBkgNo(down.getABkgNo());
										custParam.setExptKcdTp(expt_kcd_tp);
										custParam.setKcdTp(cust_kcd_tp[k]);
										custParam.setKtSeq(Integer.toString(i_seq));
										custParam.setBcsTp(custNode.getCBcsTp());
										custParam.setCntCd(custNode.getCCntCd());
										custParam.setCustCd(custNode.getCCustCd());
										custParam.setBkgCgoTp(down.getFe());

										custParam.setCustName((custNode.getCCustName().replaceAll("\r\n", " ").replaceAll("\n", " ")).replaceAll("\r", " "));
										custParam.setCustAddr((custNode.getCCustAddr().replaceAll("\r\n", " ").replaceAll("\n", " ")).replaceAll("\r", " "));
										custParam.setCustTel(custNode.getCCustTel());
										custParam.setKtPort(kt_port);
										custParam.setUsername(account.getUsr_id());


										// 존재여부를 체크하여 있으면 skip
										Kor24CustExistVO custExistVO = new Kor24CustExistVO();
										custExistVO.setBkgNo(down.getABkgNo());
										if (expt_kcd_tp!=null && (expt_kcd_tp.equals("R") || expt_kcd_tp.equals("T")) ) {
											custExistVO.setCstmsDeclTpCd(expt_kcd_tp);
										}else {
											custExistVO.setCstmsDeclTpCd(cust_kcd_tp[k]);
										}
										custExistVO.setDmstPortCd(kt_port);
										custExistVO.setTrnsSeq(String.valueOf(i_seq));
										custExistVO.setBkgCustTpCd(custNode.getCBcsTp());
										String custCnt = dbDao.searchCustExistCnt(custExistVO);
										if ( custCnt.equals("0") ) dbDao.addCustInfoKor(custParam);

										if (bbChk.equals("2")){
											custExistVO.setBkgNo(bbBkgNo);
											custParam.setBkgNo(bbBkgNo);
											String bcustCnt = dbDao.searchCustExistCnt(custExistVO);
											if ( bcustCnt.equals("0") ) dbDao.addBbCustInfoKor(custParam);
										}

									}
								}


								if("E".equals(kcd_tp) || "R".equals(kcd_tp))
								{
									if("S".equals(custNode.getCBcsTp()))
									{
										biz_CntCd = custParam.getCntCd();
										biz_CustCd = custParam.getCustCd();
									}
								}
								else
								{
									if("C".equals(custNode.getCBcsTp()))
									{
										biz_CntCd = custParam.getCntCd();
										biz_CustCd = custParam.getCustCd();

										/**
										 * 2010.11.15 경종윤 [CHM-201007078] 화주의 사업자등록번호 기재 보완요청
										 * 2011.11.15 김현화 [] TO THE ORDER OF 에서 ORDER로 변경 -AA안정선
										 */

										if (Pattern.compile(".*ORDER.*", Pattern.CASE_INSENSITIVE).matcher(custNode.getCCustName().toUpperCase()).matches()){
									  //if(custNode.getCCustName().toUpperCase().trim().startsWith("TO THE ORDER OF")) {
											notifyBzNoFlag = true;
										}
									}

									if(biz_CntCd.length() < 2 || notifyBzNoFlag)
									{
										if("N".equals(custNode.getCBcsTp()))
										{
											biz_CntCd = custParam.getCntCd();
											biz_CustCd = custParam.getCustCd();
										}
									}
								}
							}//for(int j=0;j<custInfoList.size();j++)
						}//if(custInfoList != null)



						BkgRateVO voParam = new BkgRateVO();
						voParam.setBkgNo(down.getABkgNo());

						String biz_no = "";
						if("E".equals(kcd_tp) || "R".equals(kcd_tp))
						{
							biz_no = dbDao.searchBizNo(voParam);
						}

						if("".equals(biz_no) || biz_no == null)
						{
							if(biz_CntCd.length() == 2)
							{
								kor24BizNoVO.setBizCntCd(biz_CntCd);
								kor24BizNoVO.setBizCustCd(biz_CustCd);
								biz_no = dbDao.searchCustRegNo(kor24BizNoVO);
							}
						}



						if(!"".equals(biz_no))
						{
							BkgCstmsKrBlVO updParam = new BkgCstmsKrBlVO();
							updParam.setBizNo(biz_no);
							updParam.setBkgNo(down.getABkgNo());
							updParam.setBkgNoSplit(down.getABkgNoSplit());
							updParam.setKcdTp(kcd_tp);
							updParam.setExptKcdTp(expt_kcd_tp);
							updParam.setKtPort(kt_port);
							updParam.setKtSeq(Integer.toString(i_seq));
							updParam.setUsername(account.getUsr_id());
							dbDao.modifyBizNo(updParam);
							if (bbChk.equals("2")){
								updParam.setBkgNo(bbBkgNo);
								dbDao.modifyBizNo(updParam);

							}
						}

						paramVO.setNewMrnNo(mrnVslSysEtaEtdVO.getMrnNo());
						paramVO.setNewMrnChkNo(mrnVslSysEtaEtdVO.getMrnChkNo());
						paramVO.setVvdCd(condData.getInVvd());
						paramVO.setBound(condData.getInBound());
						if(mrnVslSysEtaEtdVO.getEtaDt() != null)
						{
							paramVO.setEtaDt(mrnVslSysEtaEtdVO.getEtaDt());
							paramVO.setEtdDt(mrnVslSysEtaEtdVO.getEtdDt());
						}
						else
						{
							paramVO.setEtaDt(mrnVslSysEtaEtdVO.getActionTime());
							paramVO.setEtdDt(mrnVslSysEtaEtdVO.getActionTime());
						}

						paramVO.setVslCallSign(mrnVslSysEtaEtdVO.getVslCallSign());
						paramVO.setVslEngNm(mrnVslSysEtaEtdVO.getVslEngNm());
						paramVO.setVslFlag(mrnVslSysEtaEtdVO.getVslFlag());
						paramVO.setJointCnt("3");
						paramVO.setVvdPodTmnlCd(down.getVvdPodTmnlCd().trim());
						paramVO.setUsername(account.getUsr_id());
						paramVO.setMrnPort(kt_port);
						paramVO.setCreatedtype(createType);

						String max_seq = "";

						Kor24BkgCstmsVvdSmryVO kor24BkgCstmsVvdSmryVO = new Kor24BkgCstmsVvdSmryVO();
						kor24BkgCstmsVvdSmryVO.setVvdCd		(condData.getInVvd()			);
						kor24BkgCstmsVvdSmryVO.setMrnPort		(kt_port						);
						kor24BkgCstmsVvdSmryVO.setBound		(condData.getInBound()			);
						kor24BkgCstmsVvdSmryVO.setNewMrnNo	(mrnVslSysEtaEtdVO.getMrnNo()	);
						kor24BkgCstmsVvdSmryVO.setNewMrnChkNo	(mrnVslSysEtaEtdVO.getMrnChkNo());
						kor24BkgCstmsVvdSmryVO.setCreatedtype	(createType						);
						kor24BkgCstmsVvdSmryVO.setInBound		(condData.getInBound()			);
						kor24BkgCstmsVvdSmryVO.setPodTml		(down.getVvdPodTmnlCd()			);
						max_seq = dbDao.searchMaxSeqVVDKor(kor24BkgCstmsVvdSmryVO);

						if(max_seq == null || max_seq.equals("")) max_seq = "0";
						int i_max_seq = Integer.parseInt(max_seq);

						if(i_max_seq == 0)
						{
							i_max_seq ++;
							paramVO.setKvSeq(Integer.toString(i_max_seq));

							dbDao.addVVDInfo(paramVO);
						}
						else if(i_max_seq > 0)
						{
							String y_chk = dbDao.searchMaxSeqVVDYard(paramVO);
							if("N".equals(y_chk))
							{
								i_max_seq ++;
								paramVO.setKvSeq(Integer.toString(i_max_seq));
								dbDao.addVVDInfo(paramVO);
							}
							else
							{
								String mf_snd_dt = dbDao.searchMaxSendCheckKor(paramVO);
								if("Y".equals(mf_snd_dt))
								{
									i_max_seq ++;
									paramVO.setKvSeq(Integer.toString(i_max_seq));
									dbDao.addVVDInfo(paramVO);
								}
							}
						}

					} // END DOWNLOAD INFO LOOP
				}
				else
				{
					//ReDownLoad
					kcd_tp = "";
					wh_whf_ind = "";
					condData.setKtPort(kt_port);
					List<Kor24ManifestInfoVO> reDownList = dbDao.searchReManifestInfoList(condData);
					if(reDownList == null) continue;

//					reDownList.get(0).getWhouse().length();

					Kor24BkgCstmsVvdSmryVO mrnKor24Param = new Kor24BkgCstmsVvdSmryVO();
					Kor24BkgCstmsVvdSmryVO oldMrnKor24 = null;

					if (ifModifyMrnNo==false) {
						mrnKor24Param.setVvdCd(condData.getInVvd());
						mrnKor24Param.setMrnPort(kt_port);
						mrnKor24Param.setBound(condData.getInBound());
						oldMrnKor24 = dbDao.searchMrnKor(mrnKor24Param);

						if(oldMrnKor24 != null)
						{
							oldMrnKor24.setVvdCd(condData.getInVvd());
							oldMrnKor24.setMrnPort(kt_port);
							oldMrnKor24.setBound(condData.getInBound());
							oldMrnKor24.setNewMrnNo(mrnVslSysEtaEtdVO.getMrnNo());
							oldMrnKor24.setNewMrnChkNo(mrnVslSysEtaEtdVO.getMrnChkNo());

							if(!oldMrnKor24.getOldMrnNo().trim().equals(mrnVslSysEtaEtdVO.getMrnNo().trim()))
							{
								int updateCount = dbDao.modifyMrnNoKor(oldMrnKor24);
								String sHisSeq  = dbDao.searchMaxSeqDownHistKor(mrnVslSysEtaEtdVO.getMrnNo()+mrnVslSysEtaEtdVO.getMrnChkNo(), condData.getInVvd());
								Kor24DownHistVO kor24DownHistVO = new Kor24DownHistVO();
								kor24DownHistVO.setMrnNbr(mrnVslSysEtaEtdVO.getMrnNo());
								kor24DownHistVO.setMrnChk(mrnVslSysEtaEtdVO.getMrnChkNo());
								kor24DownHistVO.setVvdCd(condData.getInVvd());
								kor24DownHistVO.setKdhSeq(sHisSeq);
								kor24DownHistVO.setBound(condData.getInBound());
								kor24DownHistVO.setMrnPort(kt_port);
								kor24DownHistVO.setActionTime(mrnVslSysEtaEtdVO.getActionTime());
								kor24DownHistVO.setOffice(account.getOfc_cd());
								kor24DownHistVO.setUsername(account.getUsr_id());
								kor24DownHistVO.setMrnUpdateCnt(Integer.toString(updateCount));
								dbDao.addDownHist(kor24DownHistVO);
								ifModifyMrnNo = true;
							}
						}
					}

					for(int idxDn =0; idxDn < reDownList.size(); idxDn++)
					{
						reDownNode = reDownList.get(idxDn);

						bbChk = dbDao.searchBreakBulkCheck(checkParam);  //[ReDownload]break bulk 포함 여부 체크

						reDownNode.setInPodTmnl(condData.getInPodTmnl());
						// NODE 값 적용
						reDownNode.setPckTpCd(node.getPckTpCd());
						reDownNode.setPckQty(node.getPckQty());
						reDownNode.setWgtValue(node.getWgtValue());

						down_vvd_pol = reDownNode.getHidden1().substring(0, 5);
						down_vvd_pod = reDownNode.getHidden2().substring(0, 5);
						down_bkg_pol = reDownNode.getPol().substring(0, 5);
						down_bkg_pod = reDownNode.getPod().substring(0, 5);

						if("O".equals(condData.getInBound()))
						{

							//OutBound
							kt_port = reDownNode.getHidden1();

							if(down_vvd_pol.equals(down_bkg_pol))
							{
								Kor24RateHeadVO rh = dbDao.searchExemptWhf(node.getBkgNo());
								if(rh == null)
								{
									kcd_tp = "E";
								}
								else
								{
									wh_whf_ind = rh.getWhfInd();
									kcd_tp = rh.getKcdTp();
								}
							}
							else
							{
								kcd_tp = "R";
							}

							if (down_vvd_pol.equals(down_bkg_pol) ){
								if (reDownNode.getPod().startsWith("US") || reDownNode.getPod().startsWith("CA")
									   || reDownNode.getPod().startsWith("MX") || reDownNode.getPod().startsWith("GT"))
								{
									if("P".equals(reDownNode.getFe())){
										reDownNode.setCreatedType("M");
										createType = "M";
									}else{
										reDownNode.setCreatedType("A");
										createType = "A";
									}
								}
								else
								{
									if("P".equals(reDownNode.getFe())){
										down.setCreatedType("M");
										createType = "M";
									}else{
										reDownNode.setCreatedType("B");
										createType = "B";
									}
								}
							} else if(!down_vvd_pol.equals(down_bkg_pol) || "P".equals(reDownNode.getFe())) {
								reDownNode.setCreatedType("C");
								createType = "C";
							}



							if("A".equals(condData.getSelType()))
							{
								if("B".equals(reDownNode.getCreatedType())) continue;
								if("C".equals(reDownNode.getCreatedType())) continue;
								if("M".equals(reDownNode.getCreatedType())) continue;
							}
							if("B".equals(condData.getSelType()))
							{
								if("A".equals(reDownNode.getCreatedType())) continue;
								if("C".equals(reDownNode.getCreatedType())) continue;
								if("M".equals(reDownNode.getCreatedType())) continue;
							}
							if("C".equals(condData.getSelType()) && !"P".equals(reDownNode.getFe()))
							{
								if("A".equals(reDownNode.getCreatedType())) continue;
								if("B".equals(reDownNode.getCreatedType())) continue;
								if("M".equals(reDownNode.getCreatedType())) continue;
								reDownNode.setBac("");
							}
							if("M".equals(condData.getSelType()))
							{
								if("A".equals(reDownNode.getCreatedType())) continue;
								if("B".equals(reDownNode.getCreatedType())) continue;
								if("C".equals(reDownNode.getCreatedType())) continue;
								reDownNode.setBac("");
							}

							String custType = dbDao.searchCustType(reDownNode.getABkgNo());

							if (reDownNode.getSc().equals("N")) {
								if (custType.equals("N")) reDownNode.setSc("C");
								if (custType.equals("B")) reDownNode.setSc("S");
							}
						}
						else
						{
							//InBound

							kt_port = reDownNode.getHidden2();

							if(down_vvd_pod.equals(down_bkg_pod))
							{
								kcd_tp = "I";
								reDownNode.setTp("I");
							}
							else
							{
								kcd_tp = "T";
								reDownNode.setTp("T");
							}
							//InBound의 경우 CreatedType은 항상 N
							if("P".equals(reDownNode.getFe())){
								reDownNode.setCreatedType("M");
								createType = "M";
							}else{
								reDownNode.setCreatedType("N");
								createType = "N";
							}
														
							//jjang 2013/11/27 B/L Order Type에 따른 console/simple 구분(김대준 차장)
							//order인 경우 Notify       N-> 'Console' B-> 'Simple' 
							//             consignee    N-> 'Console' B-> 'Simple'
							String custType = dbDao.searchCustOrderType(reDownNode.getABkgNo());

							if (custType.equals("N")){
								reDownNode.setSc("C");
							}else{
								reDownNode.setSc("S");
							}
						}

						reDownNode.setKcdTp(kcd_tp);
						reDownNode.setKtPort(kt_port);
						reDownNode.setWh(wh_whf_ind);

						dangerInfo = dbDao.searchDangerInfo(reDownNode.getABkgNo(), reDownNode.getABkgNoSplit());
						kor24BkgCntrVOs = dbDao.searchBKGCNTRList(reDownNode.getABkgNo(), reDownNode.getABkgNoSplit());

						if("R".equals(reDownNode.getKcdTp()) && !"Y".equals(wh_whf_ind)) reDownNode.setSc("S");	//a_msn_bltp = sc
						
						//jjang 2013/11/27 inbound T/S는 무조건 Simple B/L로 처리(김대준 차장)
						if("T".equals(reDownNode.getKcdTp())) reDownNode.setSc("S");

						exportList = null;
						if("E".equals(reDownNode.getKcdTp()) && "S".equals(reDownNode.getSc()))
						{
							exportList = dbDao.searchExportInfoDNList(reDownNode.getABkgNo(), reDownNode.getABkgNoSplit());
						}

						custInfoList = dbDao.searchCustomerInfoList(reDownNode.getABkgNo(), reDownNode.getABkgNoSplit());

						cargoParam.setABkgNo(reDownNode.getABkgNo());
						cargoParam = dbDao.searchCargoDescDN(cargoParam);


						kor24IbMtInfoVO = null;
						if (reDownNode.getCntrNo()!=null && reDownNode.getCntrNo().length() > 1 &&
								(reDownNode.getKcdTp().equals("E") || reDownNode.getKcdTp().endsWith("R")) )
						{
							kor24IbMtInfoVO = dbDao.searchIbTsMtInfo(reDownNode.getCntrNo());
						}

						transParam.setBkgNo		(reDownNode.getABkgNo()		);
						transParam.setBlNo		(reDownNode.getBlNo()		);
						transParam.setKcdTp		(reDownNode.getKcdTp()		);
						transParam.setKtPort	(reDownNode.getKtPort()		);
						transParam.setInBound	(reDownNode.getInBound()	);
						transParam.setPodTml	(reDownNode.getInPodTmnl()	);
						transParam.setCBlNo		(reDownNode.getCBlNo()		);

						if (kor24IbMtInfoVO!=null && kor24IbMtInfoVO.getInCgoTp().equals("P")) transParam.setKcdTp("R");


						// EMPTY BL 인 경우 CSTMS_BL_NO 를 다시 조회하여 셋팅
						if (reDownNode.getFe().equals("P") && reDownNode.getKtPort().equals("KRPUS")) {

							cblCntrVO = new Kor24CblCntrVO();
							cblCntrVO.setBkgNo			(transParam.getBkgNo()	);
							cblCntrVO.setCstmsDeclTpCd	(transParam.getKcdTp()	);
							cblCntrVO.setDmstPortCd		(transParam.getKtPort()	);
							cblCntrVO.setCntrNo			(reDownNode.getCntrNo()	);
							newCBlNo = dbDao.searchCblNo(cblCntrVO);
							if (newCBlNo!=null) {
								reDownNode.setCBlNo(newCBlNo);
								transParam.setCBlNo(newCBlNo);
							}
						}

						searchTransMit = dbDao.searchTransmitCheckKor(transParam);
						String kt_seq = "0";
						int before_tr_count = 0;
						String kt_sts = "";
						String kt_vvd = condData.getInVvd();
						if (searchTransMit!=null) kt_vvd = searchTransMit.getVslCd();

						String kt_pkg_qty = "";
						String kt_wgt_qty = "";
						String kt_wgt_tp = "";
						String kt_pkg_cd = "";
						String bkg_pkg_qty = "";
						String bkg_actwgt_qty = "";
						String bkg_actwgt_tp = "";
						String bkg_pkg_cd = "";

						bkg_pkg_qty = reDownNode.getPckQty();
						bkg_actwgt_qty = reDownNode.getActWgt();
						bkg_actwgt_tp = reDownNode.getWgtUtCd();
						bkg_pkg_cd = reDownNode.getPckTpCd();

						if(searchTransMit != null)
						{
							kt_pkg_qty = searchTransMit.getPckQty();
							kt_wgt_qty = searchTransMit.getCntrTtlWgt();
							kt_wgt_tp = searchTransMit.getWgtUtCd();
							kt_pkg_cd = searchTransMit.getPckTpCd();
							kt_seq = searchTransMit.getTrnsSeq();

							if("".equals(kt_seq) || kt_seq == null) kt_seq = "0";
							before_tr_count = Integer.parseInt(kt_seq);
						}

						if(before_tr_count > 0)
						{
							if("X".equals(reDownNode.getBkgsts()))
							{
								kt_sts = "X";
								List<BkgCstmsKrBlVO> bkgStsKor24 = dbDao.searchBkgStsKorList(transParam);
								// 결과가 X 이면 SKIP
								if(bkgStsKor24 != null)
								{
									BkgCstmsKrBlVO stsNode = bkgStsKor24.get(0);
									if (stsNode!=null && stsNode.getKrBlAmdtStsCd()!=null && stsNode.getKrBlAmdtStsCd().equals("X")) {
										continue;
									}
								}
							}

							if("".equals(kt_sts) &&
						    	(!condData.getInVvd().equals(kt_vvd) ||
						    	 !searchTransMit.getTsPolCd().equals(reDownNode.getHidden1()) ||
						    	 !searchTransMit.getTsPodCd().equals(reDownNode.getHidden2())))
							{
					        	kt_sts = "V";
							}
					        else if("".equals(kt_sts) &&
					        	(!kt_pkg_qty.equals(bkg_pkg_qty) ||
					        	 !kt_wgt_qty.equals(bkg_actwgt_qty) ||
					        	 (kt_pkg_qty.equals(bkg_pkg_qty) && !kt_pkg_cd.equals(bkg_pkg_cd)) ||
					        	 (kt_wgt_qty.equals(bkg_actwgt_qty) && !kt_wgt_tp.equals(bkg_actwgt_tp))))
					        {
					        	kt_sts = "U";
					        }
					        else
					        {
						        if(exportList != null)
						        {
						        	BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO = new BkgCstmsKrXptLicVO();
						        	String changeflag = "N";
						        	for(int i=0;i<exportList.size();i++)
						        	{
						        		Kor24ExportInfoDNVO exNode = exportList.get(i);
						        		// ELNO 가 없으면 SKIP 처리
										if (exNode.getEBmeElno()==null || exNode.getEBmeElno().trim().length() < 1) continue;
						        		bkgCstmsKrXptLicVO.setBkgNo		(reDownNode.getABkgNo()	);
						        		bkgCstmsKrXptLicVO.setKcdTp		(reDownNode.getKcdTp()	);
						        		bkgCstmsKrXptLicVO.setKtPort	(reDownNode.getKtPort()	);
						        		bkgCstmsKrXptLicVO.setKtSeq		(kt_seq					);
						        		bkgCstmsKrXptLicVO.setBmeElno	(exNode.getEBmeElno()	);
						        		bkgCstmsKrXptLicVO.setBmePkgQty	(exNode.getEBmePkgQty()	);
						        		bkgCstmsKrXptLicVO.setBmePkgCd	(exNode.getEBmePkgTp()	);
						        		bkgCstmsKrXptLicVO.setBmeWgtQty	(exNode.getEBmeWgtQty()	);
						        		bkgCstmsKrXptLicVO.setBmeWgtTp	(exNode.getEBmeWgtTp()	);
						        		bkgCstmsKrXptLicVO.setCBlNo		(reDownNode.getCBlNo()	);

						        		String checkResult = dbDao.searchExportChk(bkgCstmsKrXptLicVO);
						        		if(!"X".equals(checkResult))
						        		{
						        			changeflag = "Y";
						        			break;
						        		}
						        	}
						        	if("Y".equals(changeflag)) kt_sts = "U";
						        }
						        // OLD CHECK 추가
						        Kor24OldExpChkVO oldExpChkVO = new Kor24OldExpChkVO();
						        oldExpChkVO.setBkgNo			(reDownNode.getABkgNo()		);
						        oldExpChkVO.setCstmsDeclTpCd	(reDownNode.getKcdTp()		);
						        oldExpChkVO.setDmstPortCd		(reDownNode.getKtPort()		);
						        oldExpChkVO.setTrnsSeq			(kt_seq						);
						        oldExpChkVO.setCstmsBlNo		(reDownNode.getCBlNo()		);
						        String oldExpChkCnt = dbDao.searchOldExportChk(oldExpChkVO);
						        if ("".equals(kt_sts) && oldExpChkCnt!=null && oldExpChkCnt.compareTo("0") > 0) kt_sts = "U";

					        }
						}
						else
						{
							if("X".equals(reDownNode.getBkgsts()))
							{
								kt_sts = "X";
							}
							else
							{
								kt_sts = "";
							}
						}
						transParam.setKtSts(kt_sts);

						int notTransCount = dbDao.searchNotTransmitCheck(transParam);
						int blDeleteCount = 0;
						if(notTransCount > 0)
						{
							String maxSeq = dbDao.searchMaxTransSeqKor(transParam);
							transParam.setKtSeq(maxSeq);

							BkgCstmsKrCntrVO bkgCstmsKrCntrVO = new BkgCstmsKrCntrVO();
							bkgCstmsKrCntrVO.setBkgNo	(transParam.getBkgNo()	);
							bkgCstmsKrCntrVO.setKcdTp	(transParam.getKcdTp()	);
							bkgCstmsKrCntrVO.setKtPort	(transParam.getKtPort()	);
							bkgCstmsKrCntrVO.setKtSeq	(transParam.getKtSeq()	);
							bkgCstmsKrCntrVO.setCBlNo	(transParam.getCBlNo()	);
							dbDao.removeCNTRMaxInfoKor(bkgCstmsKrCntrVO);

							BkgCstmsKrCustVO bkgCstmsKrCustVO = new BkgCstmsKrCustVO();
							bkgCstmsKrCustVO.setBkgNo(transParam.getBkgNo());
							bkgCstmsKrCustVO.setBkgNoSplit(transParam.getBkgNoSplit());
							bkgCstmsKrCustVO.setKcdTp(transParam.getKcdTp());
							bkgCstmsKrCustVO.setKtPort(transParam.getKtPort());
							bkgCstmsKrCustVO.setKtSeq(transParam.getKtSeq());
							dbDao.removeCustMaxInfoKor(bkgCstmsKrCustVO);

							BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO = new BkgCstmsKrXptLicVO();
							bkgCstmsKrXptLicVO.setBkgNo	(transParam.getBkgNo()	);
							bkgCstmsKrXptLicVO.setKcdTp	(transParam.getKcdTp()	);
							bkgCstmsKrXptLicVO.setKtPort(transParam.getKtPort()	);
							bkgCstmsKrXptLicVO.setKtSeq	(transParam.getKtSeq()	);
							bkgCstmsKrXptLicVO.setCBlNo	(transParam.getCBlNo()	);
							dbDao.removeElNoMaxInfoKor(bkgCstmsKrXptLicVO);

							blDeleteCount = dbDao.removeBlMaxInfoKor(transParam);
							totalDeleteCnt = totalDeleteCnt + blDeleteCount;

							if(searchTransMit != null)searchTransMit.setBKtSeq(Integer.toString(notTransCount));
						}


						if (bbChk.equals("2")){
							int bnotTransCount = dbDao.searchBbNotTransmitCheck(transParam);
							int bblDeleteCount = 0;
							if(bnotTransCount > 0)
							{
								String maxSeq = dbDao.searchBbMaxTransSeqKor(transParam);
								transParam.setKtSeq(maxSeq);

								BkgCstmsKrCntrVO bkgCstmsKrCntrVO = new BkgCstmsKrCntrVO();
								bkgCstmsKrCntrVO.setBkgNo	(transParam.getBkgNo()	);
								bkgCstmsKrCntrVO.setKcdTp	(transParam.getKcdTp()	);
								bkgCstmsKrCntrVO.setKtPort	(transParam.getKtPort()	);
								bkgCstmsKrCntrVO.setKtSeq	(transParam.getKtSeq()	);
								bkgCstmsKrCntrVO.setCBlNo	(transParam.getCBlNo()	);
								dbDao.removeBbCNTRMaxInfoKor(bkgCstmsKrCntrVO);

								BkgCstmsKrCustVO bkgCstmsKrCustVO = new BkgCstmsKrCustVO();
								bkgCstmsKrCustVO.setBkgNo(transParam.getBkgNo());
								bkgCstmsKrCustVO.setBkgNoSplit(transParam.getBkgNoSplit());
								bkgCstmsKrCustVO.setKcdTp(transParam.getKcdTp());
								bkgCstmsKrCustVO.setKtPort(transParam.getKtPort());
								bkgCstmsKrCustVO.setKtSeq(transParam.getKtSeq());
								dbDao.removeBbCustMaxInfoKor(bkgCstmsKrCustVO);

								BkgCstmsKrXptLicVO bkgCstmsKrXptLicVO = new BkgCstmsKrXptLicVO();
								bkgCstmsKrXptLicVO.setBkgNo	(transParam.getBkgNo()	);
								bkgCstmsKrXptLicVO.setKcdTp	(transParam.getKcdTp()	);
								bkgCstmsKrXptLicVO.setKtPort(transParam.getKtPort()	);
								bkgCstmsKrXptLicVO.setKtSeq	(transParam.getKtSeq()	);
								bkgCstmsKrXptLicVO.setCBlNo	(transParam.getCBlNo()	);
								dbDao.removeBbElNoMaxInfoKor(bkgCstmsKrXptLicVO);

								bblDeleteCount = dbDao.removeBbBlMaxInfoKor(transParam);
								totalDeleteCnt = totalDeleteCnt + bblDeleteCount;

//								if(searchTransMit != null)searchTransMit.setBKtSeq(Integer.toString(notTransCount));
							}
						}

						if(before_tr_count != 0 || !"X".equals(transParam.getKtSts()))
						{
							paramVO.setNewMrnNo(mrnVslSysEtaEtdVO.getMrnNo());
							paramVO.setNewMrnChkNo(mrnVslSysEtaEtdVO.getMrnChkNo());
							paramVO.setVvdCd(reDownNode.getInVvd());
							paramVO.setVslFlag(mrnVslSysEtaEtdVO.getVslFlag());
							paramVO.setVslEngNm(mrnVslSysEtaEtdVO.getVslEngNm());
							paramVO.setVslCallSign(mrnVslSysEtaEtdVO.getVslCallSign());
							paramVO.setEtaDt(mrnVslSysEtaEtdVO.getEtaDt());
							paramVO.setEtdDt(mrnVslSysEtaEtdVO.getEtdDt());
							paramVO.setMrnPort(kt_port);
							paramVO.setUsername(account.getUsr_id());
							paramVO.setVvdPodTmnlCd(reDownNode.getInPodTmnl());
							paramVO.setVvdCd(condData.getInVvd());
							paramVO.setInBound(condData.getInBound());
							paramVO.setBound(condData.getInBound());
							paramVO.setJointCnt("3");
							paramVO.setUsername(account.getUsr_id());
							paramVO.setMrnPort(kt_port);
							paramVO.setCreatedtype(createType);
							paramVO.setPodTml(reDownNode.getInPodTmnl());
							String max_seq = dbDao.searchMaxSeqVVDKor(paramVO);

							if("".equals(max_seq)) max_seq = "0";
							int seq_val = Integer.parseInt(max_seq);

							if(seq_val == 0)
							{
								paramVO.setKvSeq(Integer.toString(seq_val + 1));
								dbDao.addVVDInfo(paramVO);
							}
							else if(seq_val > 0)
							{
								paramVO.setKvSeq(max_seq);
								String y_chk = dbDao.searchMaxSeqVVDYard(paramVO);
								if("N".equals(y_chk))
								{
									paramVO.setKvSeq(Integer.toString(seq_val + 1));
									dbDao.addVVDInfo(paramVO);
								}else {
									String sendCheck = dbDao.searchSendCheckKor(paramVO);
									if("Y".equals(sendCheck))
									{
										paramVO.setKvSeq(Integer.toString(seq_val + 1));
										dbDao.addVVDInfo(paramVO);
									}
								}
							}

							transTypeStr = null;
							transTypeChg = null;

							if(searchTransMit != null) kt_seq=searchTransMit.getTrnsSeq();
							if(kt_seq == null || kt_seq.equals(""))kt_seq = "0";
							int i_kt_seq = Integer.parseInt(kt_seq);
							if(i_kt_seq > 0)
							{
								// TRANS TYPE, TRANS TYPE CHANGE 조회
								if("I".equals(kcd_tp) || "T".equals(kcd_tp))
								{
									ibTransWhfVO = new Kor24IbTransWhfVO();
									ibTransWhfVO.setBkgNo	(reDownNode.getABkgNo()		);
									ibTransWhfVO.setKtPort	(kt_port					);
									ibTransWhfVO.setKtSeq	(String.valueOf(i_kt_seq)	);
									ibTransWhfVO.setInBound	("I"						);
									ibTransWhfVO.setPodTml	(reDownNode.getInPodTmnl()	);
									ibTransWhfVO = dbDao.searchIBTransTypeChg(ibTransWhfVO);

									transTypeStr = ibTransWhfVO.getTransType();
									transTypeChg = ibTransWhfVO.getTransTypeChg();
								}
								else if("E".equals(kcd_tp) || "R".equals(kcd_tp))
								{
									obTransWhfVO = new Kor24ObTransWhfVO();
									obTransWhfVO.setBkgNo	(reDownNode.getABkgNo()		);
									obTransWhfVO.setKtPort	(kt_port					);
									obTransWhfVO.setKtSeq	(String.valueOf(i_kt_seq)	);
									obTransWhfVO = dbDao.searchOBTransTypeChg(obTransWhfVO);

									transTypeStr = obTransWhfVO.getTransType();
									transTypeChg = obTransWhfVO.getTransTypeChg();
								}

								if(!kcd_tp.equals(transTypeStr)) kcd_tp = transTypeStr;
								if("R".equals(transTypeChg) || "T".equals(transTypeChg))
								{
									if(!"".equals(transTypeChg)) kcd_tp = transTypeChg;
								}
							}

							i_kt_seq ++;

							// 추가된 컨테이너 번호가 존재하고 KCD_TP 가 E이거나 R이면
							if (reDownNode.getCntrNo()!=null && reDownNode.getCntrNo().length() > 1 &&
								(reDownNode.getKcdTp().equals("E") || reDownNode.getKcdTp().endsWith("R")) )
							{
								// 조회 결과 세팅
								if (kor24IbMtInfoVO!=null && kor24IbMtInfoVO.getInCgoTp().equals("P")) {

									reDownNode.setIbMtyBkgNo		(kor24IbMtInfoVO.getInBkg()	);
									reDownNode.setIbMtyBlNo			(kor24IbMtInfoVO.getInCBl()	);
									reDownNode.setIbTrnsSeq			(kor24IbMtInfoVO.getInSeq()	);
									reDownNode.setIbCstmsDeclTpCd	(kor24IbMtInfoVO.getInTpCd()	);
									reDownNode.setIbDmstPortCd		(kor24IbMtInfoVO.getInPort()	);
									reDownNode.setIbVslCd			(kor24IbMtInfoVO.getInVsl()	);
									reDownNode.setIbSkdVoyNo		(kor24IbMtInfoVO.getInVoy()	);
									reDownNode.setIbSkdDirCd		(kor24IbMtInfoVO.getInDir()	);
									reDownNode.setIbEtaDt			(kor24IbMtInfoVO.getInEta()	);

									// 값이 존재하고 IN_CGO_TP가 P 이면 EXPT_KCD_TP를 R로 변경
									if (kor24IbMtInfoVO.getInCgoTp().equals("P")) {
										transTypeChg = "R";
									}
								}

							}

							Kor24ManifestDNVO kor24ManifestDNVO = new Kor24ManifestDNVO();
							kor24ManifestDNVO.setABkgNo(reDownNode.getABkgNo());
							kor24ManifestDNVO.setBkgNo(reDownNode.getABkgNo());
							kor24ManifestDNVO.setABkgNoSplit(reDownNode.getABkgNoSplit());
							kor24ManifestDNVO.setExptKcdTp(transTypeChg);
							kor24ManifestDNVO.setKcdTp(kcd_tp);
							kor24ManifestDNVO.setKtSeq(Integer.toString(i_kt_seq));
							kor24ManifestDNVO.setKtSts(kt_sts);
							kor24ManifestDNVO.setBlNo(reDownNode.getBlNo());
							kor24ManifestDNVO.setBkgPor(reDownNode.getBkgPor());
							kor24ManifestDNVO.setBkgDel(reDownNode.getBkgDel());
							kor24ManifestDNVO.setMsnBltp(reDownNode.getSc());
							kor24ManifestDNVO.setPkgValue(reDownNode.getPkgValue());
							kor24ManifestDNVO.setBkgPol(reDownNode.getPol());
							kor24ManifestDNVO.setBkgPod(reDownNode.getPod());
							
							//가상의 msn No 사용
							//kor24ManifestDNVO.setMsnNbr(reDownNode.getMsn());
							kor24ManifestDNVO.setMsnNbr(node.getMsn());
							
							kor24ManifestDNVO.setVvdCd(condData.getInVvd());
							kor24ManifestDNVO.setVvdPol(reDownNode.getHidden1());
							kor24ManifestDNVO.setVvdPod(reDownNode.getHidden2());
							kor24ManifestDNVO.setVvdPodTmnlCd(condData.getInPodTmnl());
							kor24ManifestDNVO.setBkgPkgQty(reDownNode.getPckQty());
							kor24ManifestDNVO.setBkgPkgCd(reDownNode.getPckTpCd());
							kor24ManifestDNVO.setBkgActwgtQty(reDownNode.getActWgt());
							kor24ManifestDNVO.setBkgActwgtTp(reDownNode.getWgtUtCd());
							kor24ManifestDNVO.setBkgMeaQty(reDownNode.getMeasQty());
							kor24ManifestDNVO.setBkgMeaTp(reDownNode.getMeasUtCd());

							kor24ManifestDNVO.setBondAreaCode(reDownNode.getBac());

							kor24ManifestDNVO.setAImoClass1(dangerInfo[0]);
							kor24ManifestDNVO.setAImoClass2(dangerInfo[1]);
							kor24ManifestDNVO.setAImoClass3(dangerInfo[2]);
							kor24ManifestDNVO.setWhouse(reDownNode.getWhouse());
							kor24ManifestDNVO.setWhouseDesc(reDownNode.getWhouseDesc());
							kor24ManifestDNVO.setDesc1(cargoParam.getDescCode1());
							kor24ManifestDNVO.setDesc2(cargoParam.getDescCode2());
							kor24ManifestDNVO.setUsername(account.getUsr_id());
							kor24ManifestDNVO.setFfordCd("");
							kor24ManifestDNVO.setBkgCgoTp(reDownNode.getFe());
							kor24ManifestDNVO.setUsBound(reDownNode.getCreatedType());
							kor24ManifestDNVO.setKtPort(kt_port);
							kor24ManifestDNVO.setCmdtRep(reDownNode.getCm());
							kor24ManifestDNVO.setSc(reDownNode.getSc());
							kor24ManifestDNVO.setMsnBltp(reDownNode.getSc());

							kor24ManifestDNVO.setCBlNo(reDownNode.getCBlNo());
							kor24ManifestDNVO.setIbMtyBkgNo(reDownNode.getIbMtyBkgNo());
							kor24ManifestDNVO.setIbMtyBlNo(reDownNode.getIbMtyBlNo());
							kor24ManifestDNVO.setIbTrnsSeq(reDownNode.getIbTrnsSeq());
							kor24ManifestDNVO.setIbCstmsDeclTpCd(reDownNode.getIbCstmsDeclTpCd());
							kor24ManifestDNVO.setIbDmstPortCd(reDownNode.getIbDmstPortCd());
							kor24ManifestDNVO.setIbVslCd(reDownNode.getIbVslCd());
							kor24ManifestDNVO.setIbSkdVoyNo(reDownNode.getIbSkdVoyNo());
							kor24ManifestDNVO.setIbSkdDirCd(reDownNode.getIbSkdDirCd());
							kor24ManifestDNVO.setIbEtaDt(reDownNode.getIbEtaDt());
							kor24ManifestDNVO.setEtaDt(mrnVslSysEtaEtdVO.getEtaDt());
							kor24ManifestDNVO.setEtdDt(mrnVslSysEtaEtdVO.getEtdDt());


//							dbDao.addBlInfoKor(kor24ManifestDNVO);



							if (bbChk.compareTo("2") == 0){

								String tBkgNo = kor24ManifestDNVO.getBkgNo();
								String tBlNo = kor24ManifestDNVO.getBlNo();
								String tCBlNo = kor24ManifestDNVO.getCBlNo();
								String tBkgCgoTp = kor24ManifestDNVO.getBkgCgoTp();
//								String tExptKcdTp = kor24ManifestDNVO.getExptKcdTp();
								String tPckQty = kor24ManifestDNVO.getBkgPkgQty();
								String tActWgt = kor24ManifestDNVO.getBkgActwgtQty();
								String tMeasQty = kor24ManifestDNVO.getBkgMeaQty();
								String tMsnBltp = kor24ManifestDNVO.getMsnBltp();
//								String tKcdTp = kor24ManifestDNVO.getKcdTp();
								String tCgoDesc1 = kor24ManifestDNVO.getDesc1();
								String tCgoDesc2 = kor24ManifestDNVO.getDesc2();
								String tCmdtRep = kor24ManifestDNVO.getCmdtRep();
								String tMsnNbr = kor24ManifestDNVO.getMsnNbr();
								String tBoundAreaCode = kor24ManifestDNVO.getBondAreaCode();
								String tWhouse = kor24ManifestDNVO.getWhouse();


								kor24ManifestDNVO.setBkgCgoTp("B");	  //Cargo Type: Break Bulk, Bulk WGT, Bulk MEA 추가

								dbDao.addReBlInfoKor(kor24ManifestDNVO); // 기존  bkg no 생성 BKG_CSTMS_KR_BL

//								bbBkgNo = dbDao.searchFirstTmpBkgNoAssign(account.getOfc_cd(), account.getUsr_id());
//								bbBlNo = dbDao.searchFirstTmpBlNoAssign();

								bbBlNo = "SEM"+tBlNo.substring(3);
								bbBkgNo = bbBlNo;

								kor24ManifestDNVO.setBkgNo(bbBkgNo);
//								kor24ManifestDNVO.setBlNo(bbBlNo);
								kor24ManifestDNVO.setCBlNo(bbBlNo);
								kor24ManifestDNVO.setBkgCgoTp("R");
//								kor24ManifestDNVO.setExptKcdTp("E");
								kor24ManifestDNVO.setBkgPkgQty("0");
								kor24ManifestDNVO.setBkgActwgtQty("0");
								kor24ManifestDNVO.setBkgMeaQty("0");
								kor24ManifestDNVO.setMsnBltp("E");
//								kor24ManifestDNVO.setKcdTp("E");
								kor24ManifestDNVO.setDesc1("EMPTY CONTAINER");
								kor24ManifestDNVO.setDesc2("");
								kor24ManifestDNVO.setCmdtRep("860900");

								if(!"O".equals(condData.getInBound()))
								{
									kor24ManifestDNVO.setMsnNbr("");
									kor24ManifestDNVO.setBondAreaCode("ST03077006");
									kor24ManifestDNVO.setWhouse("R");
								}

								dbDao.addReBlInfoKor(kor24ManifestDNVO); //신규 bkg no, 신규bl no로 생성 BKG_CSTMS_KR_BL

								kor24ManifestDNVO.setBkgNo(tBkgNo);
//								kor24ManifestDNVO.setBlNo(tBlNo);
								kor24ManifestDNVO.setCBlNo(tCBlNo);
								kor24ManifestDNVO.setBkgCgoTp(tBkgCgoTp);
//								kor24ManifestDNVO.setExptKcdTp(tExptKcdTp);
								kor24ManifestDNVO.setBkgPkgQty(tPckQty);
								kor24ManifestDNVO.setBkgActwgtQty(tActWgt);
								kor24ManifestDNVO.setBkgMeaQty(tMeasQty);
								kor24ManifestDNVO.setMsnBltp(tMsnBltp);
//								kor24ManifestDNVO.setKcdTp(tKcdTp);
								kor24ManifestDNVO.setDesc1(tCgoDesc1);
								kor24ManifestDNVO.setDesc2(tCgoDesc2);
								kor24ManifestDNVO.setCmdtRep(tCmdtRep);

								if(!"O".equals(condData.getInBound()))
								{
									kor24ManifestDNVO.setMsnNbr(tMsnNbr);
									kor24ManifestDNVO.setBondAreaCode(tBoundAreaCode);
									kor24ManifestDNVO.setWhouse(tWhouse);
								}

							}else {

								dbDao.addReBlInfoKor(kor24ManifestDNVO);
							}
							totalDownloadCnt++;

//							// C_BL 별 KCD_TP 재조회
//							kor24CblVO.setBkgNo		(reDownNode.getABkgNo()		);
//							kor24CblVO.setTrnsSeq		(Integer.toString(i_kt_seq)	);
//							kor24CblVO.setDmstPortCd	(reDownNode.getKtPort()		);
//							kor24CblVO.setCBlNo		(reDownNode.getCBlNo()		);
//							kor24CblVO.setVvd			(reDownNode.getVvdCd()		);
//
//							cntr_kcd_tp = dbDao.searchCblKcdTp(kor24CblVO);

							if(kor24BkgCntrVOs != null)
							{

								if("P".equals(reDownNode.getFe()) || "R".equals(reDownNode.getFe())) {
									cntrFe = "E";
								}else {
									cntrFe = "F";
								}
								if (bbChk.equals("2")){	  //Break Bulk와 섞여 있는 경우
									if (reDownNode.getFe().equals("P") && reDownNode.getKtPort().equals("KRPUS")) {
										kor24BkgCntrVO = kor24BkgCntrVOs.get(idxDn);

										if(kor24BkgCntrVO.getBBbCgoFlg().equals("Y")){
											param1.setBkgNo		(bbBkgNo					);
											param1.setCBlNo		(bbBlNo						);
											param1.setFeInd		("E"						);
											param1.setCntrPkgQty("0"						);
											param1.setCntrWgtQty("0"						);
											param1.setCntrMeaQty("0"						);
											param1.setSealNo1("");
											param1.setSealNo2("");
										}else{
											param1.setBkgNo(reDownNode.getABkgNo());
											param1.setCBlNo(reDownNode.getCBlNo());
											param1.setFeInd		(cntrFe						);
											param1.setCntrPkgQty(kor24BkgCntrVO.getBCntrPkgQty());
											param1.setCntrWgtQty(kor24BkgCntrVO.getBCntrWgtQty());
											param1.setCntrMeaQty(kor24BkgCntrVO.getBCntrMeaQty());
											param1.setSealNo1(kor24BkgCntrVO.getBCntrSealNo1());
											param1.setSealNo2(kor24BkgCntrVO.getBCntrSealNo2());
										}

										param1.setBkgNoSplit(reDownNode.getABkgNoSplit());
										param1.setExptKcdTp(transTypeChg);
//										param1.setKcdTp(cntr_kcd_tp);
										param1.setKcdTp(kcd_tp);
										param1.setKtSeq(Integer.toString(i_kt_seq));
										param1.setCntrNo(kor24BkgCntrVO.getBCntrNo());
										param1.setCntrtsCd(kor24BkgCntrVO.getBCntrtsCd());
										param1.setCntrPkgCd(kor24BkgCntrVO.getBCntrPkgCd());
										param1.setCntrWgtTp(kor24BkgCntrVO.getBCntrWgtTp());
										param1.setCntrMeaTp(kor24BkgCntrVO.getBCntrMeaTp());
										param1.setKtPort(kt_port);
										param1.setUsername(account.getUsr_id());
										dbDao.addCNTRInfoKor(param1);
									}else {
										for(int m=0;m<kor24BkgCntrVOs.size();m++)
										{
											kor24BkgCntrVO = kor24BkgCntrVOs.get(m);

											if(kor24BkgCntrVO.getBBbCgoFlg().equals("Y")){
												param1.setBkgNo		(bbBkgNo					);
												param1.setCBlNo		(bbBlNo						);
												param1.setFeInd		("E"						);
												param1.setCntrPkgQty("0"						);
												param1.setCntrWgtQty("0"						);
												param1.setCntrMeaQty("0"						);
												param1.setSealNo1("");
												param1.setSealNo2("");
											}else{
												param1.setBkgNo(reDownNode.getABkgNo());
												param1.setCBlNo(reDownNode.getCBlNo());
												param1.setFeInd		(cntrFe						);
												param1.setCntrPkgQty(kor24BkgCntrVO.getBCntrPkgQty());
												param1.setCntrWgtQty(kor24BkgCntrVO.getBCntrWgtQty());
												param1.setCntrMeaQty(kor24BkgCntrVO.getBCntrMeaQty());
												param1.setSealNo1(kor24BkgCntrVO.getBCntrSealNo1());
												param1.setSealNo2(kor24BkgCntrVO.getBCntrSealNo2());
											}

											param1.setBkgNoSplit(reDownNode.getABkgNoSplit());
											param1.setExptKcdTp(transTypeChg);
//											param1.setKcdTp(cntr_kcd_tp);
											param1.setKcdTp(kcd_tp);
											param1.setKtSeq(Integer.toString(i_kt_seq));
											param1.setCntrNo(kor24BkgCntrVO.getBCntrNo());
											param1.setCntrtsCd(kor24BkgCntrVO.getBCntrtsCd());
											param1.setCntrPkgCd(kor24BkgCntrVO.getBCntrPkgCd());
											param1.setCntrWgtTp(kor24BkgCntrVO.getBCntrWgtTp());
											param1.setCntrMeaTp(kor24BkgCntrVO.getBCntrMeaTp());
											param1.setKtPort(kt_port);
											param1.setUsername(account.getUsr_id());
											dbDao.addCNTRInfoKor(param1);
										}
									}
									param1.setBkgNo(reDownNode.getABkgNo());
									param1.setCBlNo(reDownNode.getCBlNo());
									param1.setKtSeq(Integer.toString(i_kt_seq));
									param1.setKtPort	(kt_port					);
									param1.setKcdTp		(kcd_tp      				);
									param1.setUsername	(account.getUsr_id()		);
									param1.setCntrNo	("IN BULK");
									param1.setExptKcdTp	("");
									param1.setFeInd		("");
									param1.setCntrPkgQty("0");
									param1.setCntrWgtQty("0");
									param1.setCntrMeaQty("0");
//									param1.setKcdTp		(cntr_kcd_tp				);
									param1.setSealNo1	("");
									param1.setSealNo2	("");
									param1.setCntrtsCd	("");
									param1.setCntrPkgCd	("");
									param1.setCntrWgtTp	("");
									dbDao.addCNTRInfoKor(param1);

								}else{	//Break Bulk와 섞여 있지 않은 경우
									if (reDownNode.getFe().equals("P") && reDownNode.getKtPort().equals("KRPUS")) {
										kor24BkgCntrVO = kor24BkgCntrVOs.get(idxDn);
										param1.setBkgNo(reDownNode.getABkgNo());
										param1.setBkgNoSplit(reDownNode.getABkgNoSplit());
										param1.setExptKcdTp(transTypeChg);
//										param1.setKcdTp(cntr_kcd_tp);
										param1.setKcdTp(kcd_tp);
										param1.setKtSeq(Integer.toString(i_kt_seq));
										param1.setCntrNo(kor24BkgCntrVO.getBCntrNo());
										param1.setFeInd(cntrFe);
										param1.setSealNo1(kor24BkgCntrVO.getBCntrSealNo1());
										param1.setSealNo2(kor24BkgCntrVO.getBCntrSealNo2());
										param1.setCntrtsCd(kor24BkgCntrVO.getBCntrtsCd());
										param1.setCntrPkgQty(kor24BkgCntrVO.getBCntrPkgQty());
										param1.setCntrPkgCd(kor24BkgCntrVO.getBCntrPkgCd());
										param1.setCntrWgtQty(kor24BkgCntrVO.getBCntrWgtQty());
										param1.setCntrWgtTp(kor24BkgCntrVO.getBCntrWgtTp());
										param1.setCntrMeaQty(kor24BkgCntrVO.getBCntrMeaQty());
										param1.setCntrMeaTp(kor24BkgCntrVO.getBCntrMeaTp());
										param1.setKtPort(kt_port);
										param1.setUsername(account.getUsr_id());
										param1.setCBlNo(reDownNode.getCBlNo());
										dbDao.addCNTRInfoKor(param1);
									}else {
										for(int m=0;m<kor24BkgCntrVOs.size();m++)
										{
											kor24BkgCntrVO = kor24BkgCntrVOs.get(m);
											param1.setBkgNo(reDownNode.getABkgNo());
											param1.setBkgNoSplit(reDownNode.getABkgNoSplit());
											param1.setExptKcdTp(transTypeChg);
//											param1.setKcdTp(cntr_kcd_tp);
											param1.setKcdTp(kcd_tp);
											param1.setKtSeq(Integer.toString(i_kt_seq));
											param1.setCntrNo(kor24BkgCntrVO.getBCntrNo());
											param1.setFeInd(cntrFe);
											param1.setSealNo1(kor24BkgCntrVO.getBCntrSealNo1());
											param1.setSealNo2(kor24BkgCntrVO.getBCntrSealNo2());
											param1.setCntrtsCd(kor24BkgCntrVO.getBCntrtsCd());
											param1.setCntrPkgQty(kor24BkgCntrVO.getBCntrPkgQty());
											param1.setCntrPkgCd(kor24BkgCntrVO.getBCntrPkgCd());
											param1.setCntrWgtQty(kor24BkgCntrVO.getBCntrWgtQty());
											param1.setCntrWgtTp(kor24BkgCntrVO.getBCntrWgtTp());
											param1.setCntrMeaQty(kor24BkgCntrVO.getBCntrMeaQty());
											param1.setCntrMeaTp(kor24BkgCntrVO.getBCntrMeaTp());
											param1.setKtPort(kt_port);
											param1.setUsername(account.getUsr_id());
											param1.setCBlNo(reDownNode.getCBlNo());
											dbDao.addCNTRInfoKor(param1);
										}
									}
								}
							}

							String biz_CntCd = "";
							String biz_CustCd = "";
							/*
							 *
							 * Congignee Name이 TO THE ORDER OF 이면
							 * Notify의 상호를 biz no로 셋팅 하기 위한 변수
							 */
							boolean notifyBzNoFlag = false;
							if(custInfoList != null)
							{
								// KCD_TP 재조회
								kor24kcdVO.setBkgNo		(reDownNode.getABkgNo()		);
								kor24kcdVO.setTrnsSeq		(Integer.toString(i_kt_seq)	);
								kor24kcdVO.setDmstPortCd	(reDownNode.getKtPort()		);
								kor24kcdVO.setVvd			(reDownNode.getVvdCd()		);
								cust_kcd_tp = dbDao.searchKcdTpCust(kor24kcdVO);

								for(int i=0;i<custInfoList.size();i++)
								{
									Kor24BkgCustVO custNode = custInfoList.get(i);
									if("S".equals(custNode.getCBcsTp()) && " ".equals(custNode.getCCustAddr()))
									{
										custNode.setCCustAddr(".");
									}
									BkgCstmsKrCustVO custParam = new BkgCstmsKrCustVO();

									if (cust_kcd_tp!=null) {
										for(int k=0; k < cust_kcd_tp.length; k++) {

											custParam.setBkgNo(reDownNode.getABkgNo());
											custParam.setExptKcdTp(transTypeChg);
											custParam.setKcdTp(cust_kcd_tp[k]);
											custParam.setKtSeq(Integer.toString(i_kt_seq));
											custParam.setBcsTp(custNode.getCBcsTp());
											custParam.setCntCd(custNode.getCCntCd());
											custParam.setCustCd(custNode.getCCustCd());
											custParam.setBkgCgoTp(reDownNode.getFe());
											custParam.setCustName(custNode.getCCustName().replaceAll("\r\n", " ").replaceAll("\n", " ").replaceAll("\r", " "));
											custParam.setCustAddr(custNode.getCCustAddr().replaceAll("\r\n", " ").replaceAll("\n", " ").replaceAll("\r", " "));
											custParam.setCustTel(custNode.getCCustTel());
											custParam.setKtPort(kt_port);
											custParam.setUsername(account.getUsr_id());

											// 존재여부를 체크하여 있으면 skip
											Kor24CustExistVO custExistVO = new Kor24CustExistVO();
											custExistVO.setBkgNo(reDownNode.getABkgNo());
											if (transTypeChg!=null && (transTypeChg.equals("R") || transTypeChg.equals("T")) ) {
												custExistVO.setCstmsDeclTpCd(transTypeChg);
											}else {
												custExistVO.setCstmsDeclTpCd(cust_kcd_tp[k]);
											}
											custExistVO.setDmstPortCd(kt_port);
											custExistVO.setBkgCustTpCd(custNode.getCBcsTp());
											custExistVO.setTrnsSeq(String.valueOf(i_kt_seq));
											String custCnt = dbDao.searchCustExistCnt(custExistVO);
											if ( custCnt.equals("0") ) dbDao.addCustInfoKor(custParam);
											if (bbChk.equals("2")){
												custExistVO.setBkgNo(bbBkgNo);
												custParam.setBkgNo(bbBkgNo);
												String bcustCnt = dbDao.searchCustExistCnt(custExistVO);
												if ( bcustCnt.equals("0") ) dbDao.addBbCustInfoKor(custParam);
											}
										}
									}
									if("E".equals(kcd_tp) || "R".equals(kcd_tp))
									{
										if("S".equals(custNode.getCBcsTp()))
										{
											biz_CntCd = custParam.getCntCd();
											biz_CustCd = custParam.getCustCd();
										}
									}
									else
									{
										if("C".equals(custNode.getCBcsTp()))
										{
											biz_CntCd = custParam.getCntCd();
											biz_CustCd = custParam.getCustCd();
											/**
											 * 2010.11.15 경종윤 [CHM-201007078] 화주의 사업자등록번호 기재 보완요청
											 * 2011.11.15 김현화 [] TO THE ORDER OF 에서 ORDER로 변경 -AA안정선
											 */
											if (Pattern.compile(".*ORDER.*", Pattern.CASE_INSENSITIVE).matcher(custNode.getCCustName().toUpperCase()).matches()){
									  	  //if(custNode.getCCustName().toUpperCase().trim().startsWith("TO THE ORDER OF")) {
												notifyBzNoFlag = true;
											}

										}

										if(biz_CntCd.length() < 2 || notifyBzNoFlag)
										{
											if("N".equals(custNode.getCBcsTp()))
											{
												biz_CntCd = custParam.getCntCd();
												biz_CustCd = custParam.getCustCd();
											}
										}
									}
								}
							}

							BkgRateVO voParam = new BkgRateVO();
							voParam.setBkgNo(reDownNode.getABkgNo());
							String biz_no = "";
							if("E".equals(kcd_tp) || "R".equals(kcd_tp))
							{
								biz_no = dbDao.searchBizNo(voParam);
							}

							if("".equals(biz_no) || biz_no == null)
							{
								if(biz_CntCd.length() == 2)
								{
									kor24BizNoVO.setBizCntCd(biz_CntCd);
									kor24BizNoVO.setBizCustCd(biz_CustCd);
									biz_no = dbDao.searchCustRegNo(kor24BizNoVO);
								}
							}

							if(!"".equals(biz_no))
							{
								BkgCstmsKrBlVO updParam = new BkgCstmsKrBlVO();
								updParam.setBizNo(biz_no);
								updParam.setBizNo(biz_no);
								updParam.setBkgNo(reDownNode.getABkgNo());
								updParam.setBkgNoSplit(reDownNode.getABkgNoSplit());
								updParam.setKcdTp(kcd_tp);
								updParam.setExptKcdTp(transTypeChg);
								updParam.setKtPort(kt_port);
								updParam.setKtSeq(Integer.toString(i_kt_seq));
								updParam.setUsername(account.getUsr_id());
								dbDao.modifyBizNo(updParam);
								if (bbChk.equals("2")){
									updParam.setBkgNo(bbBkgNo);
									dbDao.modifyBizNo(updParam);

								}
							}


							if(!"MAIL BOX".equals(cargoParam.getDescCode1())) {

								if("R".equals(reDownNode.getKcdTp()))
								{
									elNoMakeVO.setBkgNo(reDownNode.getABkgNo());
									elNoMakeVO.setBkgNoSplit(reDownNode.getABkgNoSplit());
									elNoMakeVO.setKtPort(kt_port);
									String elno = dbDao.searchElNoMake(elNoMakeVO);
									if(elno != null)
									{
										BkgCstmsKrXptLicVO exportNoParam = new BkgCstmsKrXptLicVO();
										exportNoParam.setBkgNo		(reDownNode.getABkgNo()		);
										exportNoParam.setExptKcdTp	(transTypeChg				);
										exportNoParam.setKcdTp		(kcd_tp						);
										exportNoParam.setKtSeq		(Integer.toString(i_kt_seq) );
										exportNoParam.setBmeElno	(elno						);
										exportNoParam.setBmeWgtQty	(bkg_actwgt_qty				);
										exportNoParam.setBmePkgQty	(bkg_pkg_qty				);
										exportNoParam.setBmePkgCd	(bkg_pkg_cd					);
										exportNoParam.setBmeWgtTp	(bkg_actwgt_tp				);
										exportNoParam.setKtPort		(kt_port					);
										exportNoParam.setUsername	(account.getUsr_id()		);
										exportNoParam.setCBlNo		(reDownNode.getCBlNo()		);
										dbDao.addExportNoMake(exportNoParam);
									} else {
										/*
										 * 2010년 6월 29일 화요일 경종윤
										 * 수출 T/S 화물의 면장은 아래와 같이 Other Reference No에 입력하면 적하목록 Download 시   Export License coulmn에 적용이 되게 적용
										 * (elNo 값이 없을시 TS_REF_NO값으로 대체한다.
										 */
										List<Kor24ExportInfoDNVO> exportList1 = null;
										exportList1 = dbDao.searchExportInfoDNList(reDownNode.getABkgNo(), reDownNode.getABkgNoSplit());

										if(exportList1 != null && exportList1.size() > 0) {

											elno = exportList1.get(0).getEBmeElno();
											if(elno != null && elno.length() > 0) {

												BkgCstmsKrXptLicVO exportNoParam = new BkgCstmsKrXptLicVO();
												exportNoParam.setBkgNo		(reDownNode.getABkgNo()		);
												exportNoParam.setExptKcdTp	(transTypeChg				);
												exportNoParam.setKcdTp		(kcd_tp						);
												exportNoParam.setKtSeq		(Integer.toString(i_kt_seq) );
												exportNoParam.setBmeElno	(elno						);
												exportNoParam.setBmeWgtQty	(bkg_actwgt_qty				);
												exportNoParam.setBmePkgQty	(bkg_pkg_qty				);
												exportNoParam.setBmePkgCd	(bkg_pkg_cd					);
												exportNoParam.setBmeWgtTp	(bkg_actwgt_tp				);
												exportNoParam.setKtPort		(kt_port					);
												exportNoParam.setUsername	(account.getUsr_id()		);
												exportNoParam.setCBlNo		(reDownNode.getCBlNo()		);
												dbDao.addExportNoMake(exportNoParam);
											}
										}

									}
								}

							} else {

								/*
								 * 2010년 6월 29일 화요일 경종윤
								 * 재 다운로드시에도  Gargo Code1값이  "MAIL BOX"로 되어 있는 것들은 EXPORT LICENSE 번호에   NCV로 자동 입력 되게 수정
								 *
								 */
								Kor24MailBoxVO kor24MailBoxVO = new Kor24MailBoxVO();
								kor24MailBoxVO.setBkgNo(reDownNode.getABkgNo());
								kor24MailBoxVO.setExptKdTp(transTypeChg);
								kor24MailBoxVO.setKcdTp(kcd_tp);
								kor24MailBoxVO.setKtSeq(Integer.toString(i_kt_seq));
								kor24MailBoxVO.setKtPort(kt_port);
								kor24MailBoxVO.setBkgPkgQty("");
								kor24MailBoxVO.setBkgActwgtQty(reDownNode.getActWgt());
								kor24MailBoxVO.setBkgActwgtTp(reDownNode.getWgtUtCd());
								kor24MailBoxVO.setBkgPkgQty(reDownNode.getPckQty());
								kor24MailBoxVO.setBkgPkgCd(reDownNode.getPckTpCd());
								kor24MailBoxVO.setBmeElno("NCV");
								kor24MailBoxVO.setUsername(account.getUsr_id());
								kor24MailBoxVO.setCBlNo(reDownNode.getCBlNo());
								dbDao.addExportNoMailBoxKor(kor24MailBoxVO);

							}


							if(exportList != null)
							{
								Kor24ExportInfoDNVO kor24ExportInfoDNVO = null;
								BkgCstmsKrXptLicVO exportNoParam = new BkgCstmsKrXptLicVO();
								for(int i=0;i<exportList.size();i++)
								{
									kor24ExportInfoDNVO = exportList.get(i);
									// ELNO 없는 경우 SKIP 처리
									if (kor24ExportInfoDNVO.getEBmeElno()==null || kor24ExportInfoDNVO.getEBmeElno().trim().length() < 1) continue;
									exportNoParam.setBkgNo(reDownNode.getABkgNo());
									exportNoParam.setBkgNoSplit(reDownNode.getABkgNoSplit());
									exportNoParam.setExptKcdTp(transTypeChg);
									exportNoParam.setKcdTp(kcd_tp);
									exportNoParam.setKtSeq(Integer.toString(i_kt_seq));
									exportNoParam.setBmeElno(kor24ExportInfoDNVO.getEBmeElno());
									exportNoParam.setBmePkgQty(kor24ExportInfoDNVO.getEBmePkgQty());
									exportNoParam.setBmePkgCd(kor24ExportInfoDNVO.getEBmePkgTp());
									exportNoParam.setBmeWgtQty(kor24ExportInfoDNVO.getEBmeWgtQty());
									exportNoParam.setBmeWgtTp(kor24ExportInfoDNVO.getEBmeWgtTp());
									exportNoParam.setKtPort(kt_port);
									exportNoParam.setBmeDivInd(kor24ExportInfoDNVO.getEBmeDivInd());
									exportNoParam.setBmeDivSeq(kor24ExportInfoDNVO.getEBmeDivSeq());
									exportNoParam.setBmeDpkgQty(kor24ExportInfoDNVO.getEBmeDpkgQty());
									exportNoParam.setBmeDpkgCd(kor24ExportInfoDNVO.getEBmeDpkgTp());
									exportNoParam.setBmeDwgtQty(kor24ExportInfoDNVO.getEBmeDwgtQty());
									exportNoParam.setBmeDwgtTp(kor24ExportInfoDNVO.getEBmeDwgtTp());
									exportNoParam.setCBlNo(reDownNode.getCBlNo());
									exportNoParam.setBmeSmpSeq(kor24ExportInfoDNVO.getEBmeSmpSeq());
									exportNoParam.setUsername(account.getUsr_id());

									dbDao.addExportNoKor(exportNoParam);
								}
							}


						}
					}
				}

			} //MainFor Loop

			// History Add
			String maxSeq = dbDao.searchMaxSeqDownHistKor(paramVO.getNewMrnNo()+paramVO.getNewMrnChkNo(), paramVO.getVvdCd());
			if (totalDownloadCnt > 0) {
				Kor24DownHistVO addDownParam = new Kor24DownHistVO();
				addDownParam.setActionTime(mrnVslSysEtaEtdVO.getActionTime());
				addDownParam.setMrnNbr(paramVO.getNewMrnNo());
				addDownParam.setVvdCd(paramVO.getVvdCd());
				addDownParam.setMrnChk(paramVO.getNewMrnChkNo());
				addDownParam.setBound(paramVO.getBound());
				addDownParam.setMrnPort(paramVO.getMrnPort());
				addDownParam.setKdhSeq(maxSeq);
				addDownParam.setOffice(account.getOfc_cd());
				addDownParam.setUsername(account.getUsr_id());
				addDownParam.setBlKnt(Long.toString(totalDownloadCnt));
				dbDao.addDownHistSeq(addDownParam);
				maxSeq = String.valueOf(Integer.parseInt(maxSeq)+1);
			}

			// ADD DELETE History
			if (totalDeleteCnt > 0) {
				BkgCstmsKrDlHisVO bkgCstmsKrDlHisVO = new BkgCstmsKrDlHisVO();
				bkgCstmsKrDlHisVO.setMrnNbr(mrnVslSysEtaEtdVO.getMrnNo()+mrnVslSysEtaEtdVO.getMrnChkNo());
				bkgCstmsKrDlHisVO.setMrnChk(mrnVslSysEtaEtdVO.getMrnChkNo());
				bkgCstmsKrDlHisVO.setVvd(condData.getInVvd());
				bkgCstmsKrDlHisVO.setVvdCd(condData.getInVvd());
				bkgCstmsKrDlHisVO.setActionTime(mrnVslSysEtaEtdVO.getActionTime());
				bkgCstmsKrDlHisVO.setPol(condData.getInPol());
				bkgCstmsKrDlHisVO.setPod(condData.getInPod());
				bkgCstmsKrDlHisVO.setOffice(account.getOfc_cd());
				bkgCstmsKrDlHisVO.setUserName(account.getUsr_id());
				bkgCstmsKrDlHisVO.setDeleteBlCnt(Long.toString(totalDeleteCnt));
				bkgCstmsKrDlHisVO.setKdhSeq(maxSeq);
				dbDao.addDownHistKor(bkgCstmsKrDlHisVO);
			}
		}
		catch (DAOException de)
		{
			log.error("err " + de.toString(), de);
			if(de.getMessage().startsWith("BKG01125")) { // 무결성 에러일 경우
				throw new EventException(new ErrorHandler("BKG01125", new String[] { de.getMessage().split("@")[1] }).getMessage(), de);
			}
			throw new EventException(new ErrorHandler("BKG95019", new String[] {}).getMessage(), de);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG95019", new String[] {}).getMessage(), ex);
		}
		return null;
	}

	/**
	 * Manifest Summary 정보 수정
	 * @param ManifestSmryCondVO manifestSmryCondVO
	 * @exception EventException
	 */
	public void modifyManifestSummaryInfo(ManifestSmryCondVO manifestSmryCondVO) throws EventException {
		// 파라메터 변환
		Kor24ManifestSmryCondVO condVO = (Kor24ManifestSmryCondVO)manifestSmryCondVO;
		// POD TML 생성
		String podTml = "";
		if (condVO.getTmlCd()!=null && condVO.getTmlCd().length() > 0) podTml = condVO.getPodCd() + condVO.getTmlCd();
		// IN TYPE 처리
		String inType = condVO.getInType();
		if ("|A|B|C|D|M".indexOf(inType) < 1) inType = "N";
		// PORT CD 처리
		String portCd = condVO.getPodCd();
//		if ("|A|B|C|D".indexOf(inType) > 0) portCd = condVO.getPolCd();
		if ( "O".equals(condVO.getIoBndCd())){
			portCd = condVO.getPolCd();
		}
		// BOND CD UPDATE를 위한 객체
		Kor24BondCdVO kor24BondCdVO = new Kor24BondCdVO();
		// Summary UPDATE를 위한 객체
		BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();

		try {

			// TYPE에 따른 처리
			if (inType.equals("A")) {
				// A인 경우
				// 파라메터 셋팅
				kor24BondCdVO.setVvd		(condVO.getVvd()		);
				kor24BondCdVO.setBdAreaCd	(condVO.getBdAreaCd()	);
				kor24BondCdVO.setUserId	(condVO.getUserId()		);
				kor24BondCdVO.setPortCd	(portCd					);
				kor24BondCdVO.setInType	(inType					);
				kor24BondCdVO.setIoBndCd	(condVO.getIoBndCd()	);
				kor24BondCdVO.setPodCd	(condVO.getPodCd()		);
				kor24BondCdVO.setPolCd	(condVO.getPolCd()		);
				kor24BondCdVO.setPodTml	(podTml					);
				// UPDATE
				dbDao.modifyBondCdKor(kor24BondCdVO);

			}

			// 파라메터 셋팅
			bkgCstmsKrVvdSmryVO.setVvd			 (condVO.getVvd()			);
			bkgCstmsKrVvdSmryVO.setVslCntCd		 (condVO.getVslCntCd()		);
			bkgCstmsKrVvdSmryVO.setVslNm		 (condVO.getVslNm()			);
			bkgCstmsKrVvdSmryVO.setVslCallSgnCd	 (condVO.getVslCallSgnCd()	);
			bkgCstmsKrVvdSmryVO.setEtaDt		 (condVO.getEtaDt()			);
			bkgCstmsKrVvdSmryVO.setEtdDt		 (condVO.getEtdDt()			);
			bkgCstmsKrVvdSmryVO.setCstmsDchgCd	 (condVO.getCstmsDchgCd()	);
			bkgCstmsKrVvdSmryVO.setUserId		 (condVO.getUserId()		);
			bkgCstmsKrVvdSmryVO.setCallKnt		 (condVO.getCallKnt()		);
			bkgCstmsKrVvdSmryVO.setDchgMzdCd	 (condVO.getDchgMzdCd()		);
			bkgCstmsKrVvdSmryVO.setIoTmlLocCd	 (condVO.getIoTmlLocCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsCd	 (condVO.getLoclCstmsCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsPrtCd(condVO.getLoclCstmsPrtCd());
			bkgCstmsKrVvdSmryVO.setMrnNo		 (condVO.getMrnNo()			);
			bkgCstmsKrVvdSmryVO.setVvdSeq		 (condVO.getVvdSeq()		);
			bkgCstmsKrVvdSmryVO.setInType		 (inType					);
			// UPDATE
			dbDao.modifyManifestSmryInfo(bkgCstmsKrVvdSmryVO);

		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Manifest 정보 삭제
	 *
	 * @param ManiSumCondVO maniSumCondVO
	 * @throws EventException
	 */
	public void manageManifestSummaryInfo(ManiSumCondVO maniSumCondVO) throws EventException  {

		try {
			// 파라메터 객체 변환
			Kor24ManiSumCondVO condVO = (Kor24ManiSumCondVO)maniSumCondVO;
			// POD TML 생성
			String podTml = "";
			if (condVO.getTmlCd()!=null && condVO.getTmlCd().length() > 0) podTml = condVO.getPodCd() + condVO.getTmlCd();
			// IN TYPE 처리
			String inType = condVO.getInType();
			if ("|A|B|C|D|M".indexOf(inType) < 1) inType = "N";
			// PORT CD 처리
			String portCd = condVO.getPodCd();
//			if ("|A|B|C|D".indexOf(condVO.getInType()) > 0) portCd = condVO.getPolCd();
			if ( "O".equals(condVO.getIoBndCd())){
				portCd = condVO.getPolCd();
			}

			// VVD 삭제용 객체
			BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();
			// BL Info 삭제용 객체
			Kor24BlInfoKorVO kor24BlInfoKorVO = new Kor24BlInfoKorVO();
			// Container 삭제용 객체
			Kor24CntrDataVO kor24CntrDataVO = new Kor24CntrDataVO();
			// Customer 삭제용 객체
			Kor24BlCustInfoVO kor24BlCustInfoVO = new Kor24BlCustInfoVO();
			// Export License 삭제용 객체
			Kor24ExpDataVO kor24ExpDataVO = new Kor24ExpDataVO();
			// 삭제 SEQ
			String dlSeq = "0";
			// 삭제 건수
			int delCnt = 0;

			Kor24DnHistVO kor24DnHistVO = new Kor24DnHistVO();

			// VVD INFO 삭제
			bkgCstmsKrVvdSmryVO.setVvd		(condVO.getVvd()	);
			bkgCstmsKrVvdSmryVO.setMrnNo	(condVO.getMrnNo()	);
			bkgCstmsKrVvdSmryVO.setVvdSeq	(condVO.getVvdSeq()	);
			bkgCstmsKrVvdSmryVO.setInType	(inType				);
			// 삭제
			dbDao.removeVvdInfoKor(bkgCstmsKrVvdSmryVO);

			// Container DATA 삭제
			kor24CntrDataVO.setVvd	(condVO.getVvd()	);
			kor24CntrDataVO.setPortCd	(portCd				);
			kor24CntrDataVO.setInType	(inType				);
			kor24CntrDataVO.setIoBndCd(condVO.getIoBndCd());
			kor24CntrDataVO.setPodCd	(condVO.getPodCd()	);
			kor24CntrDataVO.setPolCd	(condVO.getPolCd()	);
			kor24CntrDataVO.setPodTml	(podTml				);
			// 삭제
			dbDao.removeCNTRDataKor(kor24CntrDataVO);

			// CUSTOMER 정보 삭제
			kor24BlCustInfoVO.setVvd		(condVO.getVvd()	);
			kor24BlCustInfoVO.setPortCd	(portCd				);
			kor24BlCustInfoVO.setInType	(inType				);
			kor24BlCustInfoVO.setIoBndCd	(condVO.getIoBndCd());
			kor24BlCustInfoVO.setPodCd	(condVO.getPodCd()	);
			kor24BlCustInfoVO.setPolCd	(condVO.getPolCd()	);
			kor24BlCustInfoVO.setPodTml	(podTml				);
			// 삭제
			dbDao.removeBlCustInfoKor(kor24BlCustInfoVO);

			// Export DATA 삭제
			kor24ExpDataVO.setVvd		(condVO.getVvd()	);
			kor24ExpDataVO.setPortCd	(portCd				);
			kor24ExpDataVO.setInType	(inType				);
			kor24ExpDataVO.setIoBndCd	(condVO.getIoBndCd());
			kor24ExpDataVO.setPodCd	(condVO.getPodCd()	);
			kor24ExpDataVO.setPolCd	(condVO.getPolCd()	);
			kor24ExpDataVO.setPodTml	(podTml				);
			// 삭제
			dbDao.removeExportDataKor(kor24ExpDataVO);

			// B/L INFO 삭제
			kor24BlInfoKorVO.setVvd		(condVO.getVvd()	);
			kor24BlInfoKorVO.setPortCd	(portCd				);
			kor24BlInfoKorVO.setInType	(inType				);
			kor24BlInfoKorVO.setIoBndCd	(condVO.getIoBndCd());
			kor24BlInfoKorVO.setPodCd		(condVO.getPodCd()	);
			kor24BlInfoKorVO.setPolCd		(condVO.getPolCd()	);
			kor24BlInfoKorVO.setPodTml	(podTml				);
			// 삭제
			delCnt = dbDao.removeBlInfo(kor24BlInfoKorVO);

			// 삭제 HISTORY 를 위한 SEQ 조회
			kor24DnHistVO.setMrnNo(condVO.getMrnNo()	);
			kor24DnHistVO.setVvd	(condVO.getVvd()	);
			// SEQ 조회
			dlSeq = dbDao.searchMaxSeqDnHistKor(kor24DnHistVO);
			if (dlSeq==null) dlSeq="1";
			// 조회 결과 담기
			kor24DnHistVO.setDlSeq	(dlSeq					);
			kor24DnHistVO.setDelCnt	(String.valueOf(delCnt)	);
			kor24DnHistVO.setUserId	(condVO.getUserId()		);
			kor24DnHistVO.setOfcCd	(condVO.getOfcCd()		);
			kor24DnHistVO.setPodCd	(condVO.getPodCd()		);
			kor24DnHistVO.setPolCd	(condVO.getPolCd()		);

			// Download History 에 삭제 기록을 남김
			dbDao.addDnHistKor(kor24DnHistVO);

		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG01020", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG01020", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * VSL, Manifest 정보 조회
	 *
	 * @param VslInfoNManifestCondVO vslInfoNManifestCondVO
	 * @return VslInfoNManifestVO
	 * @throws EventException
	 */
	public VslInfoNManifestVO manageVslInfoNManifestList(VslInfoNManifestCondVO vslInfoNManifestCondVO) throws EventException {
		// 최종 리턴 객체
		Kor24VslInfoNManifestVO kor24VslInfoNManifestVO = new Kor24VslInfoNManifestVO();
		// 파라메터 변환
		Kor24VslInfoNManifestCondVO condVO = (Kor24VslInfoNManifestCondVO)vslInfoNManifestCondVO;

		// POD TML 생성
		String podTml = "";
		if (condVO.getTmlCd()!=null && condVO.getTmlCd().length() > 0) podTml = condVO.getPodCd() + condVO.getTmlCd();
		// IN TYPE 처리
		String inType = condVO.getInType();
		if ("|A|B|C|D|M".indexOf(inType) < 1) inType = "N";
		// PORT CD 처리
		String portCd = condVO.getPodCd();
//		if ("|A|B|C|D".indexOf(inType) > 0) portCd = condVO.getPolCd();
		if ( "O".equals(condVO.getIoBndCd())){
			portCd = condVO.getPolCd();
		}

		// MRN INFO 조회용 객체
		Kor24MrnInfoKorVO kor24MrnInfoKorVO = new Kor24MrnInfoKorVO();
		// 전송할 데이터 체크용 객체
		Kor24ExistCntVO kor24ExistCntVO = new Kor24ExistCntVO();
		String dataCnt = "0";
		// SummaryInfo 조회용 객체
		Kor24SumVO kor24SumVO = new Kor24SumVO();
		Kor24SumVO kor24SumFullEmptyVO = new Kor24SumVO();
		// BL SummaryInfo 조회용 객체
		BlSummaryCondVO blSummaryCondVO = new BlSummaryCondVO();
		BlSummaryVO blSummaryVO = null;
		// VVD SEQ 조회 및 조회된 결과들을 담을  객체
		BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();
		bkgCstmsKrVvdSmryVO.setUserId(condVO.getUserId());
		// VVD SEQ
		String vvdSeq = "0";
		// VVD SEND CHECK
		String oldSndChk="N";
		// Bond Area Code 조회를 위한 객체
		BkgCstmsKrBlCondVO bkgCstmsKrBlCondVO = new BkgCstmsKrBlCondVO();
		String bondAreaCd = null;
		// SEND DATE 조회결과 객체
		DateVO dateVO = null;
		// C TYPE 전송기록
		String transPreCnt = "0";
		// 최종 화면으로 넘어갈 객체
		BkgCstmsKrVvdSmryVO outVO = null;
		// Full Empty 조회용
		Kor24FullEmpSumVO kor24FullEmpSumVO = null;

		try {

			// Type E의 경우 B/L 없는 공동 VVD 인지 체크
			if("E".equals(condVO.getInType())){
				String noneBlPortCd = condVO.getPolCd();
				if(noneBlPortCd == null || "".equals(noneBlPortCd)){
					noneBlPortCd = condVO.getPodCd();
				}
				int cntNoneBL = dbDao.searchNoneBLCheck(condVO.getVvd(), noneBlPortCd, condVO.getPolCd());

				// B/L 이 없는 공동 VVD일 경우
				if(cntNoneBL == 0){

					// VVD 정보 조회
					bkgCstmsKrVvdSmryVO.setPortCd(noneBlPortCd);
					bkgCstmsKrVvdSmryVO.setVvd(condVO.getVvd());
					bkgCstmsKrVvdSmryVO.setIoBndCd(condVO.getIoBndCd());


					outVO = dbDao.searchNoneBLInfo(bkgCstmsKrVvdSmryVO);

					if (outVO==null) {
						throw new EventException(new ErrorHandler("BKG00889").getMessage());
					}

					// Type 을 'E'로 설정
					outVO.setNoneBlInType("E");

				// Type E이고 공동 VVD가 아닌 경우 데이터가 없다는 에러
				} else {
					throw new EventException(new ErrorHandler("BKG00889").getMessage());
				}

			// Type E 이외의 경우
			}else{

				// MRN INFO 조회
				kor24MrnInfoKorVO.setPolCd	(condVO.getPolCd()	);
				kor24MrnInfoKorVO.setPodCd	(condVO.getPodCd()	);
				kor24MrnInfoKorVO.setVvd		(condVO.getVvd()	);
				kor24MrnInfoKorVO.setPodTml	(podTml				);
				kor24MrnInfoKorVO.setInType	(inType				);
				kor24MrnInfoKorVO = dbDao.searchMrnInfoKor(kor24MrnInfoKorVO);

				// 전송할 데이터 유무 체크
				kor24ExistCntVO.setVvd	(condVO.getVvd()	);
				kor24ExistCntVO.setPortCd	(portCd				);
				kor24ExistCntVO.setInType	(inType				);
				kor24ExistCntVO.setIoBndCd(condVO.getIoBndCd());
				kor24ExistCntVO.setPodCd	(condVO.getPodCd()	);
				kor24ExistCntVO.setPolCd	(condVO.getPolCd()	);
				kor24ExistCntVO.setPodTml	(podTml				);
				dataCnt = dbDao.searchExistCntKor(kor24ExistCntVO);
				if (kor24MrnInfoKorVO==null || dataCnt==null || dataCnt.equals("0")) {
					// 전송할 데이터 없음 예외 처리
					throw new EventException(new ErrorHandler("BKG00889").getMessage());
				}

				// Summary Info 조회
				kor24SumVO.setVvd		(condVO.getVvd()	);
				kor24SumVO.setInType	(inType				);
				kor24SumVO.setPortCd	(portCd				);
				kor24SumVO.setIoBndCd	(condVO.getIoBndCd());
				kor24SumVO.setPodCd	(condVO.getPodCd()	);
				kor24SumVO.setPolCd	(condVO.getPolCd()	);
				kor24SumVO.setPodTml	(podTml				);
				ObjectCloner.build(kor24SumVO, kor24SumFullEmptyVO);
				kor24SumVO = dbDao.searchSummaryInfo(kor24SumVO);

				// Full/Empty Info 조회
				kor24FullEmpSumVO = dbDao.searchFullEmpCntrSum(kor24SumFullEmptyVO);
				// 조회 결과 처리
				if (kor24FullEmpSumVO!=null) {
					kor24SumVO.setCntFull	(kor24FullEmpSumVO.getCntFull()	);
					kor24SumVO.setCntEmpty(kor24FullEmpSumVO.getCntEmpty()	);
				}

				// BL Summary Info 조회
				blSummaryCondVO.setVvd		(condVO.getVvd()	);
				blSummaryCondVO.setInType	(inType				);
				blSummaryCondVO.setPortCd	(portCd				);
				blSummaryCondVO.setIoBndCd	(condVO.getIoBndCd());
				blSummaryCondVO.setPodCd	(condVO.getPodCd()	);
				blSummaryCondVO.setPolCd	(condVO.getPolCd()	);
				blSummaryCondVO.setPodTml	(podTml				);
				blSummaryVO = dbDao.searchBlSummaryInfo(blSummaryCondVO);

				// VVD SEQ 조회
				bkgCstmsKrVvdSmryVO.setIoBndCd		(condVO.getIoBndCd()			);
				bkgCstmsKrVvdSmryVO.setVvd			(condVO.getVvd()				);
				bkgCstmsKrVvdSmryVO.setInType		(inType							);
				bkgCstmsKrVvdSmryVO.setPolCd		(condVO.getPolCd()				);
				bkgCstmsKrVvdSmryVO.setPodCd		(condVO.getPodCd()				);
				bkgCstmsKrVvdSmryVO.setPodTml		(podTml							);
				vvdSeq = dbDao.searchVVDSeqKor(bkgCstmsKrVvdSmryVO);
				if (vvdSeq==null || vvdSeq.trim().length()<1) vvdSeq = "0";

				// 조회된 정보들로 Summary Info 객체 값 매핑
				bkgCstmsKrVvdSmryVO.setMrnNo			(kor24MrnInfoKorVO.getMrnNo()		);
				bkgCstmsKrVvdSmryVO.setMrnChkNo			(kor24MrnInfoKorVO.getMrnChkNo()	);
				bkgCstmsKrVvdSmryVO.setVvdSeq			(vvdSeq							);
				// BL Summary Info 값 매핑
				bkgCstmsKrVvdSmryVO.setMstBlKnt			(blSummaryVO.getBlTotCnt()		);
				bkgCstmsKrVvdSmryVO.setCnslBlKnt		(blSummaryVO.getBlCCnt()		);
				bkgCstmsKrVvdSmryVO.setMtyBlKnt			(blSummaryVO.getBlECnt()		);
				bkgCstmsKrVvdSmryVO.setTtlWgt			(blSummaryVO.getWgtQty()		);
				bkgCstmsKrVvdSmryVO.setTtlMeasQty		(blSummaryVO.getMeasQty()		);
				bkgCstmsKrVvdSmryVO.setTtlPckQty		(blSummaryVO.getPckQty()		);
				// Summary Info 값 매핑
				bkgCstmsKrVvdSmryVO.setTtlFullKnt		(kor24SumVO.getCntFull()			);
				bkgCstmsKrVvdSmryVO.setTtlMtyKnt		(kor24SumVO.getCntEmpty()			);
				bkgCstmsKrVvdSmryVO.setTtlLcTeuQty		(kor24SumVO.getCntLc20()			);
				bkgCstmsKrVvdSmryVO.setTtlLcFeuQty		(kor24SumVO.getCntLc40()			);
				bkgCstmsKrVvdSmryVO.setTtlLc45ftQty		(kor24SumVO.getCntLc45()			);
				bkgCstmsKrVvdSmryVO.setTtlTsTeuQty		(kor24SumVO.getCntTs20()			);
				bkgCstmsKrVvdSmryVO.setTtlTsFeuQty		(kor24SumVO.getCntTs40()			);
				bkgCstmsKrVvdSmryVO.setTtlTs45ftQty		(kor24SumVO.getCntTs45()			);
				bkgCstmsKrVvdSmryVO.setTtlMtyTeuQty		(kor24SumVO.getCntEc20()			);
				bkgCstmsKrVvdSmryVO.setTtlMtyFeuQty		(kor24SumVO.getCntEc40()			);
				bkgCstmsKrVvdSmryVO.setTtlMty45ftQty	(kor24SumVO.getCntEc45()			);
				bkgCstmsKrVvdSmryVO.setTtlTsMtyTeuQty	(kor24SumVO.getCntTsEc20()		);
				bkgCstmsKrVvdSmryVO.setTtlTsMtyFeuQty	(kor24SumVO.getCntTsEc40()		);
				bkgCstmsKrVvdSmryVO.setTtlTsMty45ftQty	(kor24SumVO.getCntTsEc45()		);

				// VVD SEND CHECK
				oldSndChk = dbDao.searchVVDSendCheck(bkgCstmsKrVvdSmryVO);
				// 조회 결과가 없으면 INSER
				if (oldSndChk==null) {
					dbDao.addVVDInfoInKor24Cstm(bkgCstmsKrVvdSmryVO);
					// INSERT 후 SEQ 증가 처리
					vvdSeq = String.valueOf( Integer.parseInt(vvdSeq) + 1 );
					bkgCstmsKrVvdSmryVO.setVvdSeq(vvdSeq);
				}else {
					// 조회 결과가 있으면 UPDATE 처리
					dbDao.modifyVVDInfoKor(bkgCstmsKrVvdSmryVO);
				}

				// OUT-Bound 이고 TYPE이 'A' 인 경우  Bond Area Code 조회
				if (condVO.getIoBndCd().equals("O") && inType.equals("A")) {
					bkgCstmsKrBlCondVO.setVvd	(condVO.getVvd()	);
					bkgCstmsKrBlCondVO.setPortCd(portCd				);
					bkgCstmsKrBlCondVO.setPolCd	(condVO.getPolCd()	);
					bondAreaCd = dbDao.searchBondAreaCd(bkgCstmsKrBlCondVO);
				}
				bkgCstmsKrVvdSmryVO.setBdAreaCd(bondAreaCd);

				// SEND DATE 조회
				dateVO = dbDao.searchSendDate(bkgCstmsKrVvdSmryVO);
				if (dateVO!=null) {
					bkgCstmsKrVvdSmryVO.setFDate(dateVO.getFDate());
					bkgCstmsKrVvdSmryVO.setTDate(dateVO.getTDate());
					bkgCstmsKrVvdSmryVO.setMfSndRcvrId(dateVO.getMfSndRcvrId());
				}

				// A,B TYPE의 경우 C TYPE의 전송기록이 있는지 체크
				if (inType.equals("A") || inType.equals("B")) {
					transPreCnt = dbDao.searchTransPreCnt(bkgCstmsKrVvdSmryVO);
				}
				bkgCstmsKrVvdSmryVO.setTransPreCnt(transPreCnt);
				bkgCstmsKrVvdSmryVO.setSmpBlKnt(blSummaryVO.getBlSCnt());

				// 화면의 Inbound VVD 가 X 가 아닌 경우 조회
				if (!condVO.getIbVvd().equals("X")) {
					String whfNotice = dbDao.searchWhfNotice(condVO.getIbVvd());
					bkgCstmsKrVvdSmryVO.setWhfNotice(whfNotice);
				}

				// 화면에 넘어갈  VVD INFO 조회
				outVO = dbDao.searchVVDInfoKor(bkgCstmsKrVvdSmryVO);
				if (outVO==null) {
					throw new EventException(new ErrorHandler("BKG00889").getMessage());
				}

				outVO.setOldSndChk(oldSndChk);
			}
			kor24VslInfoNManifestVO.setBkgCstmsKrVvdSmryVO(outVO);
		}catch(EventException evx) {
			log.error("err " + evx.toString(), evx);
			throw evx;
		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return kor24VslInfoNManifestVO;
	}

	/**
	 * Manifest Trans Discharge SEND
	 * @param DischManifestTransmitVO dischManifestTransmitVO
	 * @exception EventException
	 */
	public void transmitDischManifest(DischManifestTransmitVO dischManifestTransmitVO) throws EventException {

		try {
			// 파라메터 변환
			Kor24DischManifestTransmitVO condVO = (Kor24DischManifestTransmitVO)dischManifestTransmitVO;

			// IN TYPE 처리
			String inType = condVO.getInType();
			if ("|A|B|C|D|M".indexOf(inType) < 1) inType = "N";
			// PORT CD 처리
			String portCd = condVO.getPodCd();
//			if ("|A|B|C|D".indexOf(inType) > 0) portCd = condVO.getPolCd();
			if ( "O".equals(condVO.getIoBndCd())){
				portCd = condVO.getPolCd();
			}
			String podTml = portCd + condVO.getPodTml();

			// VVD Summary Update용 객체
			BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();

			// SEND DATE UPDATE 용 객체
			Kor24BlInfoKorVO kor24BlInfoKorVO = new Kor24BlInfoKorVO();

			// VVD Summary 정보 UPDATE
			bkgCstmsKrVvdSmryVO.setVvd			 (condVO.getVvd()			);
			bkgCstmsKrVvdSmryVO.setVslCntCd		 (condVO.getVslCntCd()		);
			bkgCstmsKrVvdSmryVO.setVslNm		 (condVO.getVslNm()			);
			bkgCstmsKrVvdSmryVO.setVslCallSgnCd	 (condVO.getVslCallSgnCd()	);
			bkgCstmsKrVvdSmryVO.setEtaDt		 (condVO.getEtaDt()			);
			bkgCstmsKrVvdSmryVO.setEtdDt		 (condVO.getEtdDt()			);
			bkgCstmsKrVvdSmryVO.setCstmsDchgCd	 (condVO.getCstmsDchgCd()	);
			bkgCstmsKrVvdSmryVO.setUserId		 (condVO.getUserId()		);
			bkgCstmsKrVvdSmryVO.setCallKnt		 (condVO.getCallKnt()		);
			bkgCstmsKrVvdSmryVO.setDchgMzdCd	 (condVO.getDchgMzdCd()		);
			bkgCstmsKrVvdSmryVO.setIoTmlLocCd	 (condVO.getIoTmlLocCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsCd	 (condVO.getLoclCstmsCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsPrtCd(condVO.getLoclCstmsPrtCd());
			bkgCstmsKrVvdSmryVO.setMrnNo		 (condVO.getMrnNo()			);
			bkgCstmsKrVvdSmryVO.setVvdSeq		 (condVO.getVvdSeq()		);
			bkgCstmsKrVvdSmryVO.setInType		 (inType					);
			// UPDATE
			dbDao.modifyDiscVVDSmryKor24Info(bkgCstmsKrVvdSmryVO);

			// SEND DATE UPDATE
			kor24BlInfoKorVO.setVvd		(condVO.getVvd()	);
			kor24BlInfoKorVO.setInType	(inType				);
			kor24BlInfoKorVO.setPortCd	(portCd				);
			kor24BlInfoKorVO.setPolCd		(condVO.getPolCd()	);
			kor24BlInfoKorVO.setPodCd		(condVO.getPodCd()	);
			kor24BlInfoKorVO.setIoBndCd	(condVO.getIoBndCd());
			kor24BlInfoKorVO.setUserId	(condVO.getUserId()	);
			kor24BlInfoKorVO.setPodTml	(podTml				);
			dbDao.modifyDiscSendDate(kor24BlInfoKorVO);

		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Manifest를 전송 후 정보 UPDATE
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @exception EventException
	 */
	public void transmitManifest(ManifestTransmitVO manifestTransmitVO) throws EventException {

		try {

			// 파라메터 변환
			Kor24ManifestTransmitVO condVO = (Kor24ManifestTransmitVO)manifestTransmitVO;

			// POD TML 생성
			String podTml = condVO.getPodCd() + condVO.getTmlCd();
			// IN TYPE 처리
			String inType = condVO.getInType();
			if ("|A|B|C|D|M".indexOf(inType) < 1) inType = "N";
			// PORT CD 처리
			String portCd = condVO.getPodCd();
//			if ("|A|B|C|D".indexOf(inType) > 0) portCd = condVO.getPolCd();
			if ( "O".equals(condVO.getIoBndCd())){
				portCd = condVO.getPolCd();
			}

			// BOND CD UPDATE를 위한 객체
			Kor24BondCdVO kor24BondCdVO = new Kor24BondCdVO();
			BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = new BkgCstmsKrVvdSmryVO();

			kor24BondCdVO.setVvd		(condVO.getVvd()	);
			kor24BondCdVO.setPortCd	(portCd				);
			kor24BondCdVO.setInType	(inType				);
			kor24BondCdVO.setIoBndCd	(condVO.getIoBndCd());
			kor24BondCdVO.setPolCd	(condVO.getPolCd()	);
			kor24BondCdVO.setPodCd	(condVO.getPodCd()	);
			kor24BondCdVO.setPodTml	(podTml				);
			kor24BondCdVO.setUserId	(condVO.getUserId()	);
			kor24BondCdVO.setBdAreaCd (condVO.getBdAreaCd());
			kor24BondCdVO.setMfSndRcvrId (condVO.getInReceiver());

			// TYPE A 의 경우
			if (inType.equals("A")) {
				// Bond Code UPDATE
				dbDao.modifyBondCdKor(kor24BondCdVO);
			}

			// VVD Summary 정보 UPDATE
			bkgCstmsKrVvdSmryVO.setVvd			 (condVO.getVvd()			);
			bkgCstmsKrVvdSmryVO.setVslCntCd		 (condVO.getVslCntCd()		);
			bkgCstmsKrVvdSmryVO.setVslNm		 (condVO.getVslNm()			);
			bkgCstmsKrVvdSmryVO.setVslCallSgnCd	 (condVO.getVslCallSgnCd()	);
			bkgCstmsKrVvdSmryVO.setEtaDt		 (condVO.getEtaDt()			);
			bkgCstmsKrVvdSmryVO.setEtdDt		 (condVO.getEtdDt()			);
			bkgCstmsKrVvdSmryVO.setCstmsDchgCd	 (condVO.getCstmsDchgCd()	);
			bkgCstmsKrVvdSmryVO.setUserId		 (condVO.getUserId()		);
			bkgCstmsKrVvdSmryVO.setCallKnt		 (condVO.getCallKnt()		);
			bkgCstmsKrVvdSmryVO.setDchgMzdCd	 (condVO.getDchgMzdCd()		);
			bkgCstmsKrVvdSmryVO.setIoTmlLocCd	 (condVO.getIoTmlLocCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsCd	 (condVO.getLoclCstmsCd()	);
			bkgCstmsKrVvdSmryVO.setLoclCstmsPrtCd(condVO.getLoclCstmsPrtCd());
			bkgCstmsKrVvdSmryVO.setMrnNo		 (condVO.getMrnNo()			);
			bkgCstmsKrVvdSmryVO.setVvdSeq		 (condVO.getVvdSeq()		);
			bkgCstmsKrVvdSmryVO.setInType		 (inType					);
			bkgCstmsKrVvdSmryVO.setMfSndRcvrId   (condVO.getInReceiver());

			// UPDATE
			dbDao.modifyVVDSendKor(bkgCstmsKrVvdSmryVO);

			// 전송 일시, USERID UPDATE
			dbDao.modifyKor24ManiSndDateUser(kor24BondCdVO);

		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
     * 한국세관 InBound Empty Amend 전송을 위한 처리
     * @param EmpAmdManiVO[] empAmdManiVOs
     * @return EmpAmdManiVO[]
     * @throws EventException
     */
	public EmpAmdManiVO[] manageEmpAmdManifest(EmpAmdManiVO[] empAmdManiVOs) throws EventException {

		// 파라메터 변환
		Kor24EmpAmdManiVO[] kor24EmpAmdManiVOs = (Kor24EmpAmdManiVO[])empAmdManiVOs;
		// BL_NO, TML_CD 조회용 객체
		Kor24OrgBlVO kor24OrgBlVO = null;
		// SUB_NO 조회용
		Kor24SubNoVO kor24SubNoVO = new Kor24SubNoVO();
		String subNo = null;
		// Correction 추가용
		Kor24EmptyCorrInfoVO kor24EmptyCorrInfoVO = new Kor24EmptyCorrInfoVO();

		try {

			if (kor24EmpAmdManiVOs!=null) {
				for(int i=0; i < kor24EmpAmdManiVOs.length; i++) {

					// Original BL_NO 조회
					kor24OrgBlVO = dbDao.searchOrgBlNo(kor24EmpAmdManiVOs[i].getIbTsCblno());

					// SUB_NO 조회
					kor24SubNoVO.setInVvd		(kor24EmpAmdManiVOs[i].getIbTsVvd()	);
					kor24SubNoVO.setIbPort	(kor24EmpAmdManiVOs[i].getIbTsPort()	);
					kor24SubNoVO.setPodTmlCd	(kor24OrgBlVO.getPortTmlCd()			);
					subNo = dbDao.searchSubNo(kor24SubNoVO);

					// SUB_NO 삭제
					dbDao.removeSubNo(subNo);

					// CORRECTION 정보 추가
					kor24EmptyCorrInfoVO.setSubNo		(subNo								);
					kor24EmptyCorrInfoVO.setBkgNo		(kor24EmpAmdManiVOs[i].getIbTsBkgno()	);
					kor24EmptyCorrInfoVO.setBlNo		(kor24OrgBlVO.getBlNo()				);
					kor24EmptyCorrInfoVO.setUsrId		(kor24EmpAmdManiVOs[i].getUsrId()		);
					kor24EmptyCorrInfoVO.setCltSeq	(kor24EmpAmdManiVOs[i].getIbTsSeq()	);
					kor24EmptyCorrInfoVO.setPortCd	(kor24EmpAmdManiVOs[i].getIbTsPort()	);
					kor24EmptyCorrInfoVO.setVvdCd		(kor24EmpAmdManiVOs[i].getIbTsVvd()	);
					kor24EmptyCorrInfoVO.setCstmsBlNo	(kor24EmpAmdManiVOs[i].getIbTsCblno()	);
					kor24EmptyCorrInfoVO.setCorrCd	("B"								);
					kor24EmptyCorrInfoVO.setCorrReason("Empty B/L Type 정정"				);
					dbDao.addEmptyCorrInfo(kor24EmptyCorrInfoVO);

					// Transmit 전달을 위한 조회값 저장
					kor24EmpAmdManiVOs[i].setSubNo		(subNo					);
					kor24EmpAmdManiVOs[i].setBlNo			(kor24OrgBlVO.getBlNo()	);
					kor24EmpAmdManiVOs[i].setCorrCd		("B"					);
					kor24EmpAmdManiVOs[i].setCorrReason	("Empty B/L Type 정정"	);
				}
			}

		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}

		return kor24EmpAmdManiVOs;
	}

	/**
     * 한국세관 InBound Empty Amend 전송후 UPDATE 처리
     *
     * @param EmpAmdManiVO[] empAmdManiVOs
     * @throws EventException
     */
	public void transmitEmpAmdManifest(EmpAmdManiVO[] empAmdManiVOs) throws EventException {
		// 파라메터 변환
		Kor24EmpAmdManiVO[] kor24EmpAmdManiVOs = (Kor24EmpAmdManiVO[])empAmdManiVOs;

		// 전송일시 UPDATE 용
		Kor24EmpBlInfoVO kor24EmpBlInfoVO = new Kor24EmpBlInfoVO();

		try {

			if (kor24EmpAmdManiVOs!=null) {
				for(int i=0; i < kor24EmpAmdManiVOs.length; i++) {

					// BL 전송일시 UPDATE
					kor24EmpBlInfoVO.setUsrId			(kor24EmpAmdManiVOs[i].getUsrId()		);
					kor24EmpBlInfoVO.setCstmsBlNo		(kor24EmpAmdManiVOs[i].getIbTsCblno()	);
					kor24EmpBlInfoVO.setCstmsDeclTpCd	(kor24EmpAmdManiVOs[i].getIbTsType()	);
					kor24EmpBlInfoVO.setDmstPortCd	(kor24EmpAmdManiVOs[i].getIbTsPort()	);
					kor24EmpBlInfoVO.setTrnsSeq		(kor24EmpAmdManiVOs[i].getIbTsSeq()	);
					dbDao.modifyEmpTransmitDate(kor24EmpBlInfoVO);

					// CORR 전송일시 UPDATE
					kor24EmpBlInfoVO.setSubNo(kor24EmpAmdManiVOs[i].getSubNo());
					dbDao.modifyEmpCorrInfo(kor24EmpBlInfoVO);
				}
			}

		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

    /**
     * InBound Empty MSN 저장
     * @param MsnNoCondVO[] msnNoCondVOs
     * @throws EventException
	 */
	public void manageMsnNo(MsnNoCondVO[] msnNoCondVOs) throws EventException {
		// 화면에서 넘어온 데이터
		Kor24MsnNoCondVO[] condVOs = (Kor24MsnNoCondVO[])msnNoCondVOs;
		// MSN NO 객체
		Kor24MsnNoCondVO kor24MsnNoCondVO = null;
		// MSN NO
		int msnNo = 0;
		// MSN Count
		String msnExistCheck = "0";
		// MSN No Update 용 객체
		Kor24MsnNoVO kor24MsnNoVO = new Kor24MsnNoVO();


		if (condVOs!=null && condVOs.length > 0) {

			try {

				msnNo = Integer.parseInt(condVOs[0].getMsnStartNum());

				for(int i=0; i < condVOs.length; i++) {

					kor24MsnNoCondVO = condVOs[i];

					// MSN 에 이미 값이 있으면 SKIP
					if (kor24MsnNoCondVO.getMsn()!=null && kor24MsnNoCondVO.getMsn().trim().length() > 1) continue;

					// TP가 I이고 FE 가 P인 경우만 처리
					if (kor24MsnNoCondVO.getFe().equals("P") && kor24MsnNoCondVO.getTp().equals("I")) {

						// MSN 존재여부 체크
						msnExistCheck = dbDao.searchMsnExistCnt(kor24MsnNoCondVO.getInVvd(), kor24MsnNoCondVO.getPod(), String.valueOf(msnNo));
						// MSN 번호가 이미 존재하면 오류 처리
						if (!msnExistCheck.equals("0")) throw new EventException(new ErrorHandler("BKG95024", new String[] {String.valueOf(msnNo)}).getMessage());
						// 존재하지 않으면 UPDATE 처리
						ObjectCloner.build(kor24MsnNoCondVO, kor24MsnNoVO);
						kor24MsnNoVO.setMsnStartNum(String.valueOf(msnNo));
						dbDao.modifyMsnNo(kor24MsnNoVO);
						msnNo++;
					}
				}
			}catch(EventException evx) {
				log.error("err " + evx.toString(), evx);
				throw evx;
			}catch(DAOException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
			}catch(Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
			}

		}
	}

	/**
	 * Correction 전송후 SendDate Update
	 *
	 * @param SndCorrVO sndCorrVO
	 * @throws EventException
	 */
	public void addSndDtCorrInfo(SndCorrVO sndCorrVO) throws EventException {

		try {
			// Paramter 변환
			Kor24CorrInfoVO kor24CorrInfoVO = (Kor24CorrInfoVO)sndCorrVO;

			// INSERT
			dbDao.addCorrInfo(kor24CorrInfoVO);
			// UPDATE
			dbDao.modifySndDtCorrInfo(kor24CorrInfoVO.getUserId(), kor24CorrInfoVO.getSubNo());
		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * [ESM_BKG_1329]cross check 관련 result remark 저장<br>
	 * @param Kor24ManifestCrsChkInfoVO[] kor24ManifestCrsChkInfoVOs
	 * @param SignOnUserAccount account
	 * @return Kor24ManifestCrsChkInfoVO
	 * @exception EventException
	 */
	public Kor24ManifestCrsChkInfoVO manageCrossCheck(Kor24ManifestCrsChkInfoVO[] kor24ManifestCrsChkInfoVOs , SignOnUserAccount account) throws EventException{
		Kor24ManifestCrsChkInfoVO kor24ManifestCrsChkInfoVO = new Kor24ManifestCrsChkInfoVO();
		try {
			for ( int i=0; i<kor24ManifestCrsChkInfoVOs.length; i++ ) {
				if(kor24ManifestCrsChkInfoVOs[i].getIbflag().equals("U")){
					dbDao.modifyCrossInfoKor(kor24ManifestCrsChkInfoVOs[i]);
				}else if(kor24ManifestCrsChkInfoVOs[i].getIbflag().equals("I")){
					dbDao.addCrossInfoKor(kor24ManifestCrsChkInfoVOs[i], account);

				}
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}
		return kor24ManifestCrsChkInfoVO;

	}

	/**
	 * 한국세관에 Cross Chk 화면 조회
	 *
	 * @param Kor24MrnNoVO manifestInfoVO
	 * @return List<Kor24ManifestCrsChkInfoVO>
	 * @throws EventException
	 */
	public List<Kor24ManifestCrsChkInfoVO> searchManifestCrsChkInfoKorList(Kor24MrnNoVO manifestInfoVO) throws EventException {
		try {

			String in_bound = manifestInfoVO.getInBound();
			String sel_type = manifestInfoVO.getSelType();
			String in_pod 	= manifestInfoVO.getInPod();
			String in_pol 	= manifestInfoVO.getInPol();


			if("O".equals(in_bound)) {
				manifestInfoVO.setKtPort(in_pol);

			} else {
				manifestInfoVO.setKtPort(in_pod);
				// * Inbound의 경우는 OB_DECL_TP_CD = 'N' 이므로 MRN No 검색을 위하여 임의로 sel_type을 N으로 설정한다.
				if(!"M".equals(sel_type)) manifestInfoVO.setSelType("N");
			}
			return dbDao.searchManifestCrsChkInfoKorList(manifestInfoVO);

		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 한국세관에 Cross Chk 화면 Sum 조회
	 *
	 * @param Kor24MrnNoVO manifestInfoVO
	 * @return List<Kor24ManifestCrsChkInfoVO>
	 * @throws EventException
	 */
	public Kor24MrnNoVO searchManifestCrsChkInfoSumKorList(Kor24MrnNoVO manifestInfoVO) throws EventException {
		try {

			String in_bound = manifestInfoVO.getInBound();
			String sel_type = manifestInfoVO.getSelType();
			String in_pod 	= manifestInfoVO.getInPod();
			String in_pol 	= manifestInfoVO.getInPol();


			if("O".equals(in_bound)) {
				manifestInfoVO.setKtPort(in_pol);

			} else {
				manifestInfoVO.setKtPort(in_pod);
				// * Inbound의 경우는 OB_DECL_TP_CD = 'N' 이므로 MRN No 검색을 위하여 임의로 sel_type을 N으로 설정한다.
				if(!"M".equals(sel_type)) manifestInfoVO.setSelType("N");
			}
			return dbDao.searchManifestCrsChkInfoSumKorList(manifestInfoVO);

		}catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}
}