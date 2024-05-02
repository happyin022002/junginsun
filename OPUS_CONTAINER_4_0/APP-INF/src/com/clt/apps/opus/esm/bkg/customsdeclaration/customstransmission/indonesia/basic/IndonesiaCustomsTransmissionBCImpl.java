/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : IndonesiaCustomsTransmissionBCBCImpl.java
 *@FileTitle : Indonesian Customs EDI
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.integration.IndonesiaCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IdManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaFFVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestCmdtHsCdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestDetail1VO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestDetail2VO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestDokVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestHeaderVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-TerminalDocumentation Business Logic Basic Command implementation<br>
 * - OPUS-TerminalDocumentation handling business logic<br>
 *
 * @author
 * @see
 * @since J2EE 1.6
 */
public class IndonesiaCustomsTransmissionBCImpl extends BasicCommandSupport implements IndonesiaCustomsTransmissionBC {

	// Database Access Object
	private transient IndonesiaCustomsTransmissionDBDAO dbDao = null;

	/**
	 * IndonesiaCustomsTransmissionBCBCImpl objects generate.<br>
	 * IndonesiaCustomsTransmissionBCDBDAO  is created.<br>
	 */
	public IndonesiaCustomsTransmissionBCImpl() {
		dbDao = new IndonesiaCustomsTransmissionDBDAO();
	}

	/**
	 * Indonesia  generated to Customs Manifest content  FlatFile. -- UI_BKG-0310, UI_BKG-0311 <br>
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return List<IndonesiaFFVO>
	 * @exception EventException
	 */
	public List<IndonesiaFFVO> transmitManifestForIndonesia(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account) throws EventException {
		String blPrefix = ConstantMgr.getScacCode();
		StringBuffer flatFile = new StringBuffer();
		log.info("Indonesian Impl A");
		List<IndonesiaFFVO> indonesiaFFVOList = new ArrayList<IndonesiaFFVO>();
		int flatFileIndex = 0;

		try {
			IdManifestListCondVO idManifestListCondVO = (IdManifestListCondVO) manifestTransmitVO;
			IndonesiaFFVO indonesiaFFVO = new IndonesiaFFVO();

			String actionFlag = idManifestListCondVO.getPagerows();

			if("TRUE".equals(actionFlag)) {
				// Search the BKG without   BL_ISSUE DATA
				List<ManifestListVO> manifestListVOs = this.searchManifestListForEdi((ManifestTransmitVO) idManifestListCondVO);

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
				indonesiaFFVOList.add(flatFileIndex++,indonesiaFFVO);

			} else {

				// EDI File Download

				if (idManifestListCondVO.getBoundCd().equals("I")) {

					idManifestListCondVO.setPortCd(idManifestListCondVO.getPodCd());

					List<ManifestListVO> manifestListVOs = this.searchManifestListForEdi((ManifestTransmitVO) idManifestListCondVO);
					IndonesiaManifestHeaderVO indonesiaManifestHeaderVO = null;

					for (int i=0; i<manifestListVOs.size(); i++) {

						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();

						IndonesiaManifestListVO indonesiaManifestListVO = (IndonesiaManifestListVO) manifestListVOs.get(i);

						if (i == 0) indonesiaManifestHeaderVO = indonesiaManifestListVO.getIndonesiaManifestHeaderVO();
						IndonesiaManifestDetail1VO indonesiaManifestDetail1VO = indonesiaManifestListVO.getIndonesiaManifestDetail1VO();
						IndonesiaManifestDetail2VO indonesiaManifestDetail2VO = indonesiaManifestListVO.getIndonesiaManifestDetail2VO();
						List<IndonesiaManifestContainerVO> indonesiaManifestContainerVOList = indonesiaManifestListVO.getIndonesiaManifestContainerVOList();
						List<IndonesiaManifestCmdtHsCdVO> indonesiaManifestCmdtHsCdVOList = indonesiaManifestListVO.getIndonesiaManifestCmdtHsCdVOList();

						if (i == 0) {
							flatFile.append("HDR01").append("1").append("1").append("  ");
							flatFile.append(String.format("%-40s", indonesiaManifestHeaderVO.getVslEngNm()));
							flatFile.append(String.format("%-10s", indonesiaManifestHeaderVO.getCallSgnNo()));
							flatFile.append(indonesiaManifestHeaderVO.getVslRgstCntCd());
							flatFile.append(String.format("%-10s", indonesiaManifestHeaderVO.getSkdVoyNo()));
							flatFile.append("   ").append(indonesiaManifestHeaderVO.getFirstClptPortCd())
									.append(indonesiaManifestHeaderVO.getPreviousClptPortCd()).append(indonesiaManifestDetail1VO.getPodCd())
									.append(indonesiaManifestHeaderVO.getNextClptPortCd());

							if (indonesiaManifestHeaderVO.getLastClptEtaDt().length() > 0) {
								flatFile.append(String.format("%-8.8s", indonesiaManifestHeaderVO.getLastClptEtaDt().substring(0)));
								flatFile.append(String.format("%-6.6s", indonesiaManifestHeaderVO.getLastClptEtaDt().substring(8)));
							}
							indonesiaFFVO.setFlatFile(flatFile.toString());
							indonesiaFFVOList.add(flatFileIndex++,indonesiaFFVO);
						}

						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();
						flatFile.append("DTL01").append(idManifestListCondVO.getMfTpCd()).append(
							String.format("%04d", i + 1)).append("00").append("00").append("   ")
							.append(indonesiaManifestDetail1VO.getPorCd()).append(indonesiaManifestDetail1VO.getPolCd())
							.append(indonesiaManifestDetail1VO.getPodCd()).append(indonesiaManifestDetail1VO.getDelCd())
							.append(String.format("%-40s", indonesiaManifestDetail1VO.getDtlVslEngNm()))
							.append(String.format("%-10s", indonesiaManifestDetail1VO.getDtlCallSgnNo()))
							.append(String.format("%-20s", blPrefix + indonesiaManifestDetail1VO.getBlNo()))
							.append(String.format("%-8s", indonesiaManifestDetail1VO.getOblIssDt()))
							.append("  ")
							.append(String.format("%-18s", indonesiaManifestDetail1VO.getActWgt()))
							.append(String.format("%-18s", indonesiaManifestDetail1VO.getMeasQty()))
							.append(String.format("%05d", indonesiaManifestContainerVOList.size())) // B/L  CNTR count
							.append(String.format("%-8s", indonesiaManifestDetail1VO.getPckQty()))
							.append(String.format("%-2s", indonesiaManifestDetail1VO.getPckTpCd()));

						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOList.add(flatFileIndex++,indonesiaFFVO);

						String[] shprCustNmRowArr = indonesiaManifestDetail2VO.getShprCustNm().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<shprCustNmRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02SNM" + String.format("%02d", k+1) + String.format("%-200s", shprCustNmRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						String[] shprCustAddrRowArr = indonesiaManifestDetail2VO.getShprCustAddr().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<shprCustAddrRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02SNA" + String.format("%02d", k+1) + String.format("%-200s", shprCustAddrRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						String[] cneeCustNmRowArr = indonesiaManifestDetail2VO.getCneeCustNm().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<cneeCustNmRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02CNM" + String.format("%02d", k+1) + String.format("%-200s", cneeCustNmRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						String[] cneeCustAddrRowArr = indonesiaManifestDetail2VO.getCneeCustAddr().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<cneeCustAddrRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02CNA" + String.format("%02d", k+1) + String.format("%-200s", cneeCustAddrRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						String[] ntfyCustNmRowArr = indonesiaManifestDetail2VO.getNtfyCustNm().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<ntfyCustNmRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02NNM" + String.format("%02d", k+1) + String.format("%-200s", ntfyCustNmRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						String[] ntfyCustAddrRowArr = indonesiaManifestDetail2VO.getNtfyCustAddr().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<ntfyCustAddrRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02NNA" + String.format("%02d", k+1) + String.format("%-200s", ntfyCustAddrRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						if (indonesiaManifestCmdtHsCdVOList.size() > 0) {
							for (int k=0; k<indonesiaManifestCmdtHsCdVOList.size(); k++) {
								indonesiaFFVO = new IndonesiaFFVO();
								indonesiaFFVO.setFlatFile("DTL02HSC" + String.format("%02d", k+1) + String.format("%-200s", indonesiaManifestCmdtHsCdVOList.get(k).getCmdtHsCd()));
								indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
							}
						} else {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02HSC01" + String.format("%-200s", "-"));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						String[] mkDescRowArr = indonesiaManifestDetail2VO.getMkDesc().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<mkDescRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02SMR" + String.format("%02d", k+1) + String.format("%-200s", mkDescRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						String[] cmdtDescRowArr = indonesiaManifestDetail2VO.getCmdtDesc().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<cmdtDescRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02DES" + String.format("%02d", k+1) + String.format("%-200s", cmdtDescRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						for (int j = 0; j < indonesiaManifestContainerVOList.size(); j++) {
							flatFile = new StringBuffer();
							indonesiaFFVO = new IndonesiaFFVO();
							flatFile.append("CNT01").append(String.format("%04d", i + 1))
									.append(String.format("%-20s", indonesiaManifestContainerVOList.get(j).getCntrNo()))
									.append("     ")
									.append(indonesiaManifestContainerVOList.get(j).getCntrTpszCd())
									.append(indonesiaManifestContainerVOList.get(j).getRcvTermCd())
									.append(indonesiaManifestContainerVOList.get(j).getCntrTp())
									.append(String.format("%-15s", indonesiaManifestContainerVOList.get(j).getCntrSealNo()));
							indonesiaFFVO.setFlatFile(flatFile.toString());
							indonesiaFFVOList.add(flatFileIndex++,indonesiaFFVO);
						}
					}


				} else if (idManifestListCondVO.getBoundCd().equals("O")) {

					List<ManifestListVO> manifestListVOs = this.searchManifestListForEdi((ManifestTransmitVO) idManifestListCondVO);

					IndonesiaManifestHeaderVO indonesiaManifestHeaderVO = null;
					for (int i=0; i<manifestListVOs.size(); i++) {

						flatFile = new StringBuffer();
						indonesiaFFVO = new IndonesiaFFVO();

						IndonesiaManifestListVO indonesiaManifestListVO = (IndonesiaManifestListVO) manifestListVOs.get(i);

						if (i == 0) indonesiaManifestHeaderVO = indonesiaManifestListVO.getIndonesiaManifestHeaderVO();

						IndonesiaManifestDetail1VO indonesiaManifestDetail1VO = indonesiaManifestListVO.getIndonesiaManifestDetail1VO();
						IndonesiaManifestDetail2VO indonesiaManifestDetail2VO = indonesiaManifestListVO.getIndonesiaManifestDetail2VO();
						List<IndonesiaManifestContainerVO> indonesiaManifestContainerVOList = indonesiaManifestListVO.getIndonesiaManifestContainerVOList();
						List<IndonesiaManifestDokVO> indonesiaManifestDokVOList = indonesiaManifestListVO.getIndonesiaManifestDokVOList();
						List<IndonesiaManifestCmdtHsCdVO> indonesiaManifestCmdtHsCdVOList = indonesiaManifestListVO.getIndonesiaManifestCmdtHsCdVOList();

						if (i == 0) {
							flatFile.append("HDR01").append("1").append("1").append("OS");
							flatFile.append(String.format("%-40s", indonesiaManifestHeaderVO.getVslEngNm()));
							flatFile.append(String.format("%-10s", indonesiaManifestHeaderVO.getCallSgnNo()));
							flatFile.append(indonesiaManifestHeaderVO.getVslRgstCntCd());
							flatFile.append(String.format("%-10s", indonesiaManifestHeaderVO.getSkdVoyNo()));
							flatFile.append("   ").append(indonesiaManifestHeaderVO.getFirstClptPortCd())
									.append(indonesiaManifestHeaderVO.getPreviousClptPortCd())
									.append("     ")
									.append(indonesiaManifestHeaderVO.getNextClptPortCd());

							if (indonesiaManifestHeaderVO.getLastClptEtaDt().length() > 0) {
								flatFile.append(String.format("%-8.8s", indonesiaManifestHeaderVO.getLastClptEtaDt().substring(0)));
								flatFile.append(String.format("%-6.6s", indonesiaManifestHeaderVO.getLastClptEtaDt().substring(8)));
								flatFile.append("V30    ");
							}
							indonesiaFFVO.setFlatFile(flatFile.toString());
							indonesiaFFVOList.add(flatFileIndex++,indonesiaFFVO);
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
								.append(String.format("%05d", indonesiaManifestContainerVOList.size())) // B/L  CNTR count
								.append(String.format("%-8s", indonesiaManifestDetail1VO.getPckQty()))
								.append("00000000000000000000000000")
								.append(String.format("%-2s", indonesiaManifestDetail1VO.getPckTpCd()));

						indonesiaFFVO.setFlatFile(flatFile.toString());
						indonesiaFFVOList.add(flatFileIndex++,indonesiaFFVO);

						String[] shprCustNmRowArr = indonesiaManifestDetail2VO.getShprCustNm().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<shprCustNmRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02SNM" + String.format("%02d", k+1) + String.format("%-200s", shprCustNmRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						String[] shprCustAddrRowArr = indonesiaManifestDetail2VO.getShprCustAddr().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<shprCustAddrRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02SNA" + String.format("%02d", k+1) + String.format("%-200s", shprCustAddrRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						String[] cneeCustNmRowArr = indonesiaManifestDetail2VO.getCneeCustNm().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<cneeCustNmRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02CNM" + String.format("%02d", k+1) + String.format("%-200s", cneeCustNmRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						String[] cneeCustAddrRowArr = indonesiaManifestDetail2VO.getCneeCustAddr().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<cneeCustAddrRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02CNA" + String.format("%02d", k+1) + String.format("%-200s", cneeCustAddrRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						String[] ntfyCustNmRowArr = indonesiaManifestDetail2VO.getNtfyCustNm().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<ntfyCustNmRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02NNM" + String.format("%02d", k+1) + String.format("%-200s", ntfyCustNmRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						String[] ntfyCustAddrRowArr = indonesiaManifestDetail2VO.getNtfyCustAddr().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<ntfyCustAddrRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02NNA" + String.format("%02d", k+1) + String.format("%-200s", ntfyCustAddrRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						if (indonesiaManifestCmdtHsCdVOList.size() > 0) {
							for (int k=0; k<indonesiaManifestCmdtHsCdVOList.size(); k++) {
								indonesiaFFVO = new IndonesiaFFVO();
								indonesiaFFVO.setFlatFile("DTL02HSC" + String.format("%02d", k+1) + String.format("%-200s", indonesiaManifestCmdtHsCdVOList.get(k).getCmdtHsCd()));
								indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
							}
						} else {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02HSC01" + String.format("%-200s", "-"));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						String[] mkDescRowArr = indonesiaManifestDetail2VO.getMkDesc().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<mkDescRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02SMR" + String.format("%02d", k+1) + String.format("%-200s", mkDescRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						String[] cmdtDescRowArr = indonesiaManifestDetail2VO.getCmdtDesc().replaceAll("\r", "\n").split("\n");
						for(int k=0; k<cmdtDescRowArr.length; k++) {
							indonesiaFFVO = new IndonesiaFFVO();
							indonesiaFFVO.setFlatFile("DTL02DES" + String.format("%02d", k+1) + String.format("%-200s", cmdtDescRowArr[k]));
							indonesiaFFVOList.add(flatFileIndex++, indonesiaFFVO);
						}

						for (int j=0; j<indonesiaManifestDokVOList.size(); j++) {
							flatFile = new StringBuffer();
							indonesiaFFVO = new IndonesiaFFVO();
							flatFile.append("DOK01")
									.append(String.format("%-3.3s", indonesiaManifestDokVOList.get(j).getDok()))
									.append(String.format("%03d", j+1))
									.append(String.format("%-20.20s", indonesiaManifestDokVOList.get(j).getDok().substring(3)));
							indonesiaFFVO.setFlatFile(flatFile.toString());
							indonesiaFFVOList.add(flatFileIndex++,indonesiaFFVO);
						}

						for (int j=0; j<indonesiaManifestContainerVOList.size(); j++) {
							flatFile = new StringBuffer();
							indonesiaFFVO = new IndonesiaFFVO();
							flatFile.append("CNT01").append(String.format("%04d", i+1))
									.append(String.format("%-20s", indonesiaManifestContainerVOList.get(j).getCntrNo()))
									.append("     ")
									.append(indonesiaManifestContainerVOList.get(j).getCntrTpszCd())
									.append(indonesiaManifestContainerVOList.get(j).getRcvTermCd())
									.append(indonesiaManifestContainerVOList.get(j).getCntrTp())
									.append(String.format("%-15s", indonesiaManifestContainerVOList.get(j).getCntrSealNo()));
							indonesiaFFVO.setFlatFile(flatFile.toString());
							indonesiaFFVOList.add(flatFileIndex++,indonesiaFFVO);
						}
					}
				}
			}

			if (indonesiaFFVOList.size() > 0) {
				for (IndonesiaFFVO tempFFVO : indonesiaFFVOList)  {
					tempFFVO.setFlatFile(tempFFVO.getFlatFile().replaceAll("IDSUB", "IDTPE"));
					tempFFVO.setFlatFile(tempFFVO.getFlatFile().replaceAll("IDSRG", "IDTES"));
					tempFFVO.setFlatFile(tempFFVO.getFlatFile().replaceAll("USNIJ", "USNWL"));
				}
			}

		} catch (EventException ex) {
			log.error(ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

		return indonesiaFFVOList;
	}

	/**
	 * Indonesia   generated  to Customs Manifest content FlatFile<br>
	 * Manifest List Data search -- UI_BKG-0310, UI_BKG-0311 <br>
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return List<ManifestListVO>
	 * @exception EventException
	 */
	private List<ManifestListVO> searchManifestListForEdi(ManifestTransmitVO manifestTransmitVO) throws EventException {
		List<ManifestListVO> manifestListVOs = new ArrayList<ManifestListVO>();
		String mfTpCd = "";
		List<IndonesiaManifestDetail1VO> indonesiaManifestDetail1VOs = new ArrayList<IndonesiaManifestDetail1VO>();
		String bkgNo = "";

		try {
			IdManifestListCondVO idManifestListCondVO = (IdManifestListCondVO) manifestTransmitVO;
			mfTpCd = idManifestListCondVO.getMfTpCd();
			if (mfTpCd.equals("01I") || mfTpCd.equals("09E") || mfTpCd.equals("10E")) {
				indonesiaManifestDetail1VOs = dbDao.searchManifestDetail1ListByOpt01(idManifestListCondVO);
			} else if (mfTpCd.equals("02I") || mfTpCd.equals("04E")) {
				indonesiaManifestDetail1VOs = dbDao.searchManifestDetail1ListByOpt02(idManifestListCondVO);
			} else if (mfTpCd.equals("03I") || mfTpCd.equals("05E")) {
				indonesiaManifestDetail1VOs = dbDao.searchManifestDetail1ListByOpt03(idManifestListCondVO);
			} else if (mfTpCd.equals("04I") || mfTpCd.equals("08X")) {
				indonesiaManifestDetail1VOs = dbDao.searchManifestDetail1ListByOpt04(idManifestListCondVO);
			}

			String actionFlag = idManifestListCondVO.getPagerows();
			for (int i=0; i<indonesiaManifestDetail1VOs.size(); i++) {
				bkgNo = indonesiaManifestDetail1VOs.get(i).getBkgNo();
				if (!"TRUE".equals(actionFlag) && bkgNo.startsWith("MSG:")) continue;

				IndonesiaManifestListVO indonesiaManifestListVO = new IndonesiaManifestListVO();
				if (i == 0) indonesiaManifestListVO.setIndonesiaManifestHeaderVO(dbDao.searchManifestHeader(idManifestListCondVO));
				indonesiaManifestListVO.setIndonesiaManifestDetail1VO(indonesiaManifestDetail1VOs.get(i));
				idManifestListCondVO.setBkgNo(bkgNo);
				indonesiaManifestListVO.setIndonesiaManifestDetail2VO(dbDao.searchManifestDetail2List(idManifestListCondVO));
				indonesiaManifestListVO.setIndonesiaManifestCmdtHsCdVOList(dbDao.searchManifestCmdtHsCdList(idManifestListCondVO.getBkgNo()));
				indonesiaManifestListVO.setIndonesiaManifestDokVOList(dbDao.searchManifestDOK(idManifestListCondVO));
				indonesiaManifestListVO.setIndonesiaManifestContainerVOList(dbDao.searchManifestContainerList(idManifestListCondVO));

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