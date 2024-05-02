/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : IndonesiaCustomsTransmissionBCBCImpl.java
 *@FileTitle : Indonesian Customs EDI
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.29
 *@LastModifier : 민동진
 *@LastVersion : 1.0
 * 2009.09.29 민동진
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.integration.IndonesiaCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IdManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaFFVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestDetail1VO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestDetail2VO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestDokVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestHeaderVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**  
 * ALPS-CustomsTransmissionSC Business Logic Command Interface<br>
 * - ALPS-CustomsTransmissionSC에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Min, DongJin
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class IndonesiaCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {

	// Database Access Object
	private transient IndonesiaCustomsTransmissionDBDAO dbDao = null;

	/**
	 * IndonesiaCustomsTransmissionBCBCImpl 객체 생성<br>
	 * IndonesiaCustomsTransmissionBCDBDAO를 생성한다.<br>
	 */
	public IndonesiaCustomsTransmissionBCImpl() {
		dbDao = new IndonesiaCustomsTransmissionDBDAO();
	}

	/**
	 * Indonesia 세관에 Manifest 신고할 내용을 FlatFile로 생성한다. -- UI_BKG-0310, UI_BKG-0311 <br>
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return List<IndonesiaFFVO>
	 * @exception EventException
	 */
	public List<IndonesiaFFVO> transmitManifestForIndonesia(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account)
			throws EventException {
		String portCdbyLoginOfcCd = null;
		String blPrefix = "SMLM";
		StringBuffer flatFile = new StringBuffer();
		log.info("Indonesian Impl A");
		List<IndonesiaFFVO> indonesiaFFVOs = new ArrayList<IndonesiaFFVO>();
		int flatFileIndex = 0;

		try {

			if (account.getOfc_cd().equals("SRGBA"))
				portCdbyLoginOfcCd = "IDSRG";
			else if (account.getOfc_cd().equals("SUBBA"))
				portCdbyLoginOfcCd = "IDSUB";
			else if (account.getOfc_cd().equals("JKTBA"))
				portCdbyLoginOfcCd = "IDJKT";
			else if (account.getOfc_cd().equals("BLWBA"))
				portCdbyLoginOfcCd = "IDBLW";
			IdManifestListCondVO idManifestListCondVO = (IdManifestListCondVO) manifestTransmitVO;
			idManifestListCondVO.setPortCd(portCdbyLoginOfcCd);

			IndonesiaFFVO indonesiaFFVO = new IndonesiaFFVO();
			
			String actionFlag = idManifestListCondVO.getPagerows();
			
			if("TRUE".equals(actionFlag)) {
				// BL_ISSUE DATA가 없는 BKG 리스트 조회함( CONFIRM MSG 파라메터로 사용하기 위해)
				List<ManifestListVO> manifestListVOs = searchManifestListForEdi((ManifestTransmitVO) idManifestListCondVO);
				
				IndonesiaManifestListVO indonesiaManifestListVO = null;
				
				StringBuffer excludeBkgNoBuf = null;
				String bkgNo = "";
				int indonesiaManifestDetail1VOsSize = 0;
				IndonesiaManifestDetail1VO detailVO= null;
				
				excludeBkgNoBuf = new StringBuffer();
				indonesiaManifestDetail1VOsSize = manifestListVOs.size(); 
				
				for(int i = 0; i < indonesiaManifestDetail1VOsSize; i++) {
					indonesiaManifestListVO = (IndonesiaManifestListVO)manifestListVOs.get(i);
					
					detailVO = indonesiaManifestListVO.getIndonesiaManifestDetail1VO();
					bkgNo = detailVO.getBkgNo();
					if(bkgNo.startsWith("MSG:")) {
						excludeBkgNoBuf.append(bkgNo.split(":")[1]);
						//if(i < indonesiaManifestDetail1VOsSize-1) {
							excludeBkgNoBuf.append(", ");
						//}
					}
				}

				//excludeBkgNoBuf.toString().substring(0, excludeBkgNoBuf.toString().lastIndexOf(","));
				
				String msg = "";
				if(!"".equals(excludeBkgNoBuf.toString())) {
					msg = excludeBkgNoBuf.toString().substring(0, excludeBkgNoBuf.toString().lastIndexOf(","));
				}
				flatFile.append(msg);
				
				indonesiaFFVO = new IndonesiaFFVO();
				indonesiaFFVO.setFlatFile(flatFile.toString());
				indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
			} else {
				
				// EDI File Download 처리
			
				if (idManifestListCondVO.getBoundCd().equals("I")) {
					List<ManifestListVO> manifestListVOs = searchManifestListForEdi((ManifestTransmitVO) idManifestListCondVO);
					IndonesiaManifestHeaderVO indonesiaManifestHeaderVO = null;
					for (int i = 0; i < manifestListVOs.size(); i++) {
						log.info("Indonesian Impl Inbound");
						IndonesiaManifestListVO indonesiaManifestListVO = (IndonesiaManifestListVO) manifestListVOs.get(i);
	
						if (i == 0)
							indonesiaManifestHeaderVO = indonesiaManifestListVO.getIndonesiaManifestHeaderVO();
						IndonesiaManifestDetail1VO indonesiaManifestDetail1VO = indonesiaManifestListVO
								.getIndonesiaManifestDetail1VO();
						log.info("indonesiaManifestDetail1VO.getBkgNo() = [" + indonesiaManifestDetail1VO.getBkgNo() + "]");
						IndonesiaManifestDetail2VO indonesiaManifestDetail2VO = indonesiaManifestListVO
								.getIndonesiaManifestDetail2VO();
						List<IndonesiaManifestContainerVO> indonesiaManifestContainerVOs = indonesiaManifestListVO
								.getIndonesiaManifestContainerVOs();
						if (i == 0) {
	
							flatFile.append("HDR01").append("1").append("1").append("  ");
							flatFile.append(String.format("%-40s", indonesiaManifestHeaderVO.getVslEngNm()));
							flatFile.append(String.format("%-10s", indonesiaManifestHeaderVO.getCallSgnNo()));
							flatFile.append(indonesiaManifestHeaderVO.getVslRgstCntCd());
							flatFile.append(String.format("%-10s", indonesiaManifestHeaderVO.getSkdVoyNo()));
							flatFile.append("   ").append(indonesiaManifestHeaderVO.getFirstClptPortCd())
									.append(indonesiaManifestHeaderVO.getPreviousClptPortCd()).append(portCdbyLoginOfcCd)
									.append(indonesiaManifestHeaderVO.getNextClptPortCd());
	
							if (indonesiaManifestHeaderVO.getLastClptEtaDt().length() > 0) {
								flatFile.append(String.format("%-8.8s", indonesiaManifestHeaderVO.getLastClptEtaDt()
										.substring(0)));
								flatFile.append(String.format("%-6.6s", indonesiaManifestHeaderVO.getLastClptEtaDt()
										.substring(8)));
							}
							indonesiaFFVO.setFlatFile(flatFile.toString());
							indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
							flatFile = new StringBuffer();
							indonesiaFFVO = new IndonesiaFFVO();
						} 
	
	
						flatFile.append("DTL01").append(idManifestListCondVO.getMfTpCd()).append(
								String.format("%04d", i + 1)).append("00").append("00").append("   ")
								.append(indonesiaManifestDetail1VO.getPorCd()).append(indonesiaManifestDetail1VO.getPolCd())
								.append(portCdbyLoginOfcCd).append(indonesiaManifestDetail1VO.getPodCd())
								.append(String.format("%-40s", indonesiaManifestDetail1VO.getDtlVslEngNm()))
								.append(String.format("%-10s", indonesiaManifestDetail1VO.getDtlCallSgnNo()))
								.append(String.format("%-20s", blPrefix + indonesiaManifestDetail1VO.getBlNo()))
								.append(String.format("%-8s", indonesiaManifestDetail1VO.getOblIssDt()))
								.append("  ")
								.append(String.format("%-18s", indonesiaManifestDetail1VO.getActWgt()))
								.append(String.format("%-18s", indonesiaManifestDetail1VO.getMeasQty()))
								.append(String.format("%05d", indonesiaManifestContainerVOs.size())) // B/L별 CNTR 개수
								.append(String.format("%-8s", indonesiaManifestDetail1VO.getPckQty()))
								.append(String.format("%-2s", indonesiaManifestDetail1VO.getPckTpCd()));
	
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL02").append("SNM").append("  ")
								.append(String.format("%-200s", indonesiaManifestDetail2VO.getShprCustNm()));
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL02").append("SNA").append("  ")
								.append(String.format("%-200s", indonesiaManifestDetail2VO.getShprCustAddr()));
	
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL02").append("CNM").append("  ")
								.append(String.format("%-200s", indonesiaManifestDetail2VO.getCneeCustNm()));
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL02").append("CNA").append("  ")
								.append(String.format("%-200s", indonesiaManifestDetail2VO.getCneeCustAddr()));
	
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL02").append("NNM").append("  ")
								.append(String.format("%-200s", indonesiaManifestDetail2VO.getNtfyCustNm()));
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL02").append("NNA").append("  ")
								.append(String.format("%-200s", indonesiaManifestDetail2VO.getNtfyCustAddr()));
	
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL02").append("HSC").append("  ").append(String.format("%-200s", "-"));
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						
						String cmdtDesc = indonesiaManifestDetail2VO.getCmdtDesc();
	
						indonesiaFFVO = new IndonesiaFFVO();
						for (int j = 0; j < 10; j++) {
							// 200 글자씩 잘라서 값을 넣는다
							// DESCRIPTION OF GOODS의 경우 최대 2000자 (200*10) 까지 넣으며,
							// 200 글자씩 자르다가 뒤에 값이 없는 경우, 글자가 있는 곳 까지만 반복
							if (cmdtDesc.length() > 0) {	
								flatFile.append("DTL02").append("DES").append(String.format("%02d", j + 1))
										.append(String.format("%-200.200s", cmdtDesc));
								if ( cmdtDesc.length() > 200 )
									cmdtDesc = cmdtDesc.substring(200);
								else 
									cmdtDesc = "";
								indonesiaFFVO.setFlatFile(flatFile.toString());
								indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
								flatFile = new StringBuffer();
								indonesiaFFVO = new IndonesiaFFVO();				
								
							} else {
								break;
							}
						}
						
						flatFile.append("DTL02").append("SMR").append("  ");
						if (indonesiaManifestDetail2VO.getMkDesc().length() > 0) {
							// MARKS의 경우 앞 200자까지만 값을 넣는다.
							flatFile.append(String.format("%-200.200s", indonesiaManifestDetail2VO.getMkDesc().substring(0)));
							indonesiaFFVO.setFlatFile(flatFile.toString());
							indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
							flatFile = new StringBuffer();
							indonesiaFFVO = new IndonesiaFFVO();
						}
	
						for (int j = 0; j < indonesiaManifestContainerVOs.size(); j++) {
	
							flatFile.append("CNT01").append(String.format("%04d", i + 1))
									.append(String.format("%-20s", indonesiaManifestContainerVOs.get(j).getCntrNo()))
									.append("     ")
									.append(indonesiaManifestContainerVOs.get(j).getCntrTpszCd())
									.append(indonesiaManifestContainerVOs.get(j).getRcvTermCd())
									.append("  ")
									.append(String.format("%-15s", indonesiaManifestContainerVOs.get(j).getCntrSealNo()));
							indonesiaFFVO.setFlatFile(flatFile.toString());
							indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
							flatFile = new StringBuffer();
							indonesiaFFVO = new IndonesiaFFVO();
						}
					}
				} else if (idManifestListCondVO.getBoundCd().equals("O")) {
					List<ManifestListVO> manifestListVOs = searchManifestListForEdi((ManifestTransmitVO) idManifestListCondVO);
	
					IndonesiaManifestHeaderVO indonesiaManifestHeaderVO = null;
					for (int i = 0; i < manifestListVOs.size(); i++) {
						log.info("Indonesian Impl Outbound");
						IndonesiaManifestListVO indonesiaManifestListVO = (IndonesiaManifestListVO) manifestListVOs.get(i);
	
						if (i == 0)
							indonesiaManifestHeaderVO = indonesiaManifestListVO.getIndonesiaManifestHeaderVO();
						
						IndonesiaManifestDetail1VO indonesiaManifestDetail1VO = indonesiaManifestListVO
								.getIndonesiaManifestDetail1VO();
						log.info("indonesiaManifestDetail1VO.getBkgNo() = [" + indonesiaManifestDetail1VO.getBkgNo() + "]");
						IndonesiaManifestDetail2VO indonesiaManifestDetail2VO = indonesiaManifestListVO
								.getIndonesiaManifestDetail2VO();
						List<IndonesiaManifestContainerVO> indonesiaManifestContainerVOs = indonesiaManifestListVO
								.getIndonesiaManifestContainerVOs();
						List<IndonesiaManifestDokVO> indonesiaManifestDokVOs = indonesiaManifestListVO
								.getIndonesiaManifestDokVOs();
						if (i == 0) {
	
							flatFile.append("HDR01").append("1").append("1").append("OS");
							flatFile.append(String.format("%-40s", indonesiaManifestHeaderVO.getVslEngNm()));
							flatFile.append(String.format("%-10s", indonesiaManifestHeaderVO.getCallSgnNo()));
							flatFile.append(indonesiaManifestHeaderVO.getVslRgstCntCd());
							flatFile.append(String.format("%-10s", indonesiaManifestHeaderVO.getSkdVoyNo()));
							flatFile.append("   ").append(indonesiaManifestHeaderVO.getFirstClptPortCd())
									.append(indonesiaManifestHeaderVO.getPreviousClptPortCd())
									.append(portCdbyLoginOfcCd)
									.append(indonesiaManifestHeaderVO.getNextClptPortCd());
	
							if (indonesiaManifestHeaderVO.getLastClptEtaDt().length() > 0) {
								flatFile.append(String.format("%-8.8s", indonesiaManifestHeaderVO.getLastClptEtaDt()
										.substring(0)));
								flatFile.append(String.format("%-6.6s", indonesiaManifestHeaderVO.getLastClptEtaDt()
										.substring(8)));
								flatFile.append("V30MP40");
							}
							indonesiaFFVO.setFlatFile(flatFile.toString());
							indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
							flatFile = new StringBuffer();
							indonesiaFFVO = new IndonesiaFFVO();
						}
	
	
						flatFile.append("DTL01").append(idManifestListCondVO.getMfTpCd()).append(
								String.format("%04d", i + 1)).append("00").append("00").append("-- ").append(
								indonesiaManifestDetail1VO.getPorCd()).append(indonesiaManifestDetail1VO.getPolCd())
								.append(indonesiaManifestDetail1VO.getPodCd())
								.append(indonesiaManifestDetail1VO.getDelCd())
								.append(String.format("%-40s", indonesiaManifestDetail1VO.getDtlVslEngNm() + " "
												+ indonesiaManifestDetail1VO.getDtlSkdVoyNo()
												+ indonesiaManifestDetail1VO.getDtlSkdDirCd()))
								.append(String.format("%-10s", indonesiaManifestDetail1VO.getDtlCallSgnNo()))
								.append(String.format("%-30s", blPrefix + indonesiaManifestDetail1VO.getBlNo()))
								.append(String.format("%-46s", indonesiaManifestDetail1VO.getOblIssDt()))
								.append("  ")
								.append(String.format("%-18s", indonesiaManifestDetail1VO.getActWgt()))
								.append(String.format("%-18s", indonesiaManifestDetail1VO.getMeasQty()))
								.append(String.format("%05d", indonesiaManifestContainerVOs.size())) // B/L별 CNTR 개수
								.append(String.format("%-8s", indonesiaManifestDetail1VO.getPckQty()))
								.append("00000000000000000000000000")
								.append(String.format("%-2s", indonesiaManifestDetail1VO.getPckTpCd()));
	
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL02").append("SNM").append("  ")
								.append(String.format("%-200s", indonesiaManifestDetail2VO.getShprCustNm()));
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL02").append("SNA").append("  ")
								.append(String.format("%-200s", indonesiaManifestDetail2VO.getShprCustAddr()));
	
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL02").append("CNM").append("  ")
								.append(String.format("%-200s", indonesiaManifestDetail2VO.getCneeCustNm()));
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL02").append("CNA").append("  ")
								.append(String.format("%-200s", indonesiaManifestDetail2VO.getCneeCustAddr()));
	
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL02").append("NNM").append("  ").append(
								String.format("%-200s", indonesiaManifestDetail2VO.getNtfyCustNm()));
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL02").append("NNA").append("  ")
								.append(String.format("%-200s", indonesiaManifestDetail2VO.getNtfyCustAddr()));
	
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL02").append("HSC").append("  ").append(String.format("%-200s", "-"));
						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						
						String cmdtDesc = indonesiaManifestDetail2VO.getCmdtDesc();
						for (int j = 0; j < 10; j++) {
							// 200 글자씩 잘라서 값을 넣는다
							// DESCRIPTION OF GOODS의 경우 최대 2000자 (200*10) 까지 넣으며,
							// 200 글자씩 자르다가 뒤에 값이 없는 경우, 글자가 있는 곳 까지만 반복
							if (cmdtDesc.length() > 0) {							
								flatFile.append("DTL02").append("DES").append(String.format("%02d", j + 1))
										.append(String.format("%-200.200s", cmdtDesc));
								if ( cmdtDesc.length() > 200 )
									cmdtDesc = cmdtDesc.substring(200);
								else 
									cmdtDesc = "";
								indonesiaFFVO.setFlatFile(flatFile.toString());
								indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
								flatFile = new StringBuffer();
								indonesiaFFVO = new IndonesiaFFVO();
							} else {
								break;
							}
						}
	
						flatFile.append("DTL02").append("SMR").append("  ");
						if (indonesiaManifestDetail2VO.getMkDesc().length() > 0) {
							// MARKS의 경우 앞 200자까지만 값을 넣는다.
							flatFile.append(String.format("%-200.200s", indonesiaManifestDetail2VO.getMkDesc().substring(0)));
							indonesiaFFVO.setFlatFile(flatFile.toString());
							indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
							flatFile = new StringBuffer();
							indonesiaFFVO = new IndonesiaFFVO();
						}
	
						for (int j = 0; j < indonesiaManifestDokVOs.size(); j++) {
	
							flatFile.append("DOK01")
									.append(String.format("%-3.3s", indonesiaManifestDokVOs.get(j).getDok()))
									.append(String.format("%03d", i + 1))
									.append(String.format("%-20.20s", indonesiaManifestDokVOs.get(j).getDok().substring(3)));
							indonesiaFFVO.setFlatFile(flatFile.toString());
							indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
							flatFile = new StringBuffer();
							indonesiaFFVO = new IndonesiaFFVO();
						}
	
						for (int j = 0; j < indonesiaManifestContainerVOs.size(); j++) {
	
							flatFile.append("CNT01").append(String.format("%04d", i + 1))
									.append(String.format("%-20s", indonesiaManifestContainerVOs.get(j).getCntrNo()))
									.append("     ")
									.append(indonesiaManifestContainerVOs.get(j).getCntrTpszCd())
									.append(indonesiaManifestContainerVOs.get(j).getRcvTermCd())
									.append("  ")
									.append(String.format("%-15s", indonesiaManifestContainerVOs.get(j).getCntrSealNo()));
							indonesiaFFVO.setFlatFile(flatFile.toString());
							indonesiaFFVOs.add(flatFileIndex++,indonesiaFFVO);
							flatFile = new StringBuffer();
							indonesiaFFVO = new IndonesiaFFVO();						
						}
					}
				}
				
			}

		} catch (EventException ex) {
			log.error(ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

		return indonesiaFFVOs;
	}

	/**
	 * Indonesia 세관에 신고할 Manifest 내용을 FlatFile로 생성하기 위해<br>
	 * Manifest List 데이터를 조회한다. -- UI_BKG-0310, UI_BKG-0311 <br>
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return List<ManifestListVO>
	 * @exception EventException
	 */
	private List<ManifestListVO> searchManifestListForEdi(ManifestTransmitVO manifestTransmitVO) throws EventException {
		List<ManifestListVO> manifestListVOs = new ArrayList<ManifestListVO>();
		String mfTpCd = "";
		List<IndonesiaManifestDetail1VO> indonesiaManifestDetail1VOs = new ArrayList<IndonesiaManifestDetail1VO>();
		
		
		IndonesiaManifestDetail1VO detail1VO= null;
		String bkgNo = "";
		
		try {
			IdManifestListCondVO idManifestListCondVO = (IdManifestListCondVO) manifestTransmitVO;
			mfTpCd = idManifestListCondVO.getMfTpCd();
			if ( mfTpCd.equals("01I") || mfTpCd.equals("09E") || mfTpCd.equals("10E") )
				indonesiaManifestDetail1VOs = dbDao.searchManifestDetail1ListByOpt01(idManifestListCondVO);
			else if ( mfTpCd.equals("02I") || mfTpCd.equals("04E") )
				indonesiaManifestDetail1VOs = dbDao.searchManifestDetail1ListByOpt02(idManifestListCondVO);	
			else if ( mfTpCd.equals("03I") || mfTpCd.equals("05E") )
				indonesiaManifestDetail1VOs = dbDao.searchManifestDetail1ListByOpt03(idManifestListCondVO);		
			else if ( mfTpCd.equals("04I") || mfTpCd.equals("08X") )
				indonesiaManifestDetail1VOs = dbDao.searchManifestDetail1ListByOpt04(idManifestListCondVO);
			
			
			String actionFlag = idManifestListCondVO.getPagerows();
			
//			if (indonesiaManifestDetail1VOs.size() < 1) {
//				throw new EventException(new ErrorHandler("BKG00095", new String[] {}).getMessage());
//			}

//			log.info("indonesiaManifestDetail1VOs.size()=[" + indonesiaManifestDetail1VOs.size() + "]");
			for (int i = 0; i < indonesiaManifestDetail1VOs.size(); i++) {
				
				detail1VO = indonesiaManifestDetail1VOs.get(i);
				bkgNo = detail1VO.getBkgNo();
				if(!"TRUE".equals(actionFlag) && bkgNo.startsWith("MSG:")) {
					continue;
				}
				
				IndonesiaManifestListVO indonesiaManifestListVO = new IndonesiaManifestListVO();
				if (i == 0)
					indonesiaManifestListVO.setIndonesiaManifestHeaderVO(dbDao
							.searchManifestHeader(idManifestListCondVO));
				indonesiaManifestListVO.setIndonesiaManifestDetail1VO(indonesiaManifestDetail1VOs.get(i));
				idManifestListCondVO.setBkgNo(indonesiaManifestDetail1VOs.get(i).getBkgNo());
				log.info("idManifestListCondVO.getBkgNo()=[" + idManifestListCondVO.getBkgNo() + "]");
				indonesiaManifestListVO.setIndonesiaManifestDetail2VO(dbDao
						.searchManifestDetail2List(idManifestListCondVO));
				indonesiaManifestListVO.setIndonesiaManifestDokVOs(dbDao.searchManifestDOK(idManifestListCondVO));
				indonesiaManifestListVO.setIndonesiaManifestContainerVOs(dbDao
						.searchManifestContainerList(idManifestListCondVO));
				manifestListVOs.add((ManifestListVO) indonesiaManifestListVO);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return manifestListVOs;
	}
}