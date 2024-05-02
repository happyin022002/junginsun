/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsaCustomsTransmissionBackEndJob.java
 *@FileTitle : UsaCustomsTransmissionBackEndJob
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.basic;

import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.StiDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTmlBlByVvdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBC;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlTransmitVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Do Wan
 * @see ESM_BKG_1023EventResponse,UsaCustomsTransmissionBackEndBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class UsaCustomsTransmissionBackEndJob extends BackEndCommandSupport {
	private static final long serialVersionUID = -3034414164961318353L;
	private StiDetailVO[] detailVOs;
	private UsaManifestSearchDetailVO[] usaManifestSearchDetailVOs;
	private String pgmNo;
	private SignOnUserAccount account;

	/**
	 * 다운로드 할 데이터 세팅 1023화면.
	 *
	 * @param StiDetailVO[] detailVOs
	 * @return void
	 */
	public void setStiDetailVO(StiDetailVO[] detailVOs) {
		if (detailVOs != null)
			this.detailVOs = Arrays.copyOf(detailVOs, detailVOs.length);
	}

	/**
	 * 다운로드 할 데이터 세팅 0613화면.
	 *
	 * @param UsaManifestSearchDetailVO[] usaManifestSearchDetailVOs
	 * @return void
	 */
	public void setUsaManifestSearchDetailVO(UsaManifestSearchDetailVO[] usaManifestSearchDetailVOs) {
		if (usaManifestSearchDetailVOs != null)
			this.usaManifestSearchDetailVOs = Arrays.copyOf(usaManifestSearchDetailVOs, usaManifestSearchDetailVOs.length);
	}

	/**
	 * 세션정보 세팅
	 * @param account
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}

	/**
	 * 화면ID세팅
	 *
	 * @param String pgmNo
	 * @return void
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}

	/**
	 * BackEndCommand Start
	 * @return DBRowSet
	 * @throws Exception
	 */
	public DBRowSet doStart() throws Exception {
		if (pgmNo.startsWith("ESM_BKG_1023"))
		{
			UsaCustomsTransmissionBCImpl command = new UsaCustomsTransmissionBCImpl();
			command.transmitStowageManifest(detailVOs);
		}
		else if(pgmNo.startsWith("ESM_BKG_0613"))
		{
			UsaCustomsTransmissionBCImpl command = new UsaCustomsTransmissionBCImpl();
			command.transmitManifest(usaManifestSearchDetailVOs);
		}
		else if(pgmNo.startsWith("ESM_BKG_0408"))
		{
			UsaCustomsTransmissionBCImpl command = new UsaCustomsTransmissionBCImpl();
			command.transmitManifest(usaManifestSearchDetailVOs);

			// CDL 자동전송
			BlInfoCondVO blInfoCondVO = new BlInfoCondVO();
			blInfoCondVO.setUsaManifestSearchDetailVOs(usaManifestSearchDetailVOs);
			List<BlInfoVO> blInfos = command.searchTmlBlByVvd(blInfoCondVO);
			if (blInfos.size() > 0)
			{
				CllCdlTransmitVO[] cllCdlTransmitVOs = new CllCdlTransmitVO[blInfos.size()];
				for (int i = 0; i < blInfos.size(); i++)
				{
					UsaTmlBlByVvdVO usaTmlBlByVvdVO = (UsaTmlBlByVvdVO) blInfos.get(i);
					cllCdlTransmitVOs[i] = new CllCdlTransmitVO();
					cllCdlTransmitVOs[i].setBkgNo(usaTmlBlByVvdVO.getBkgNo());
					cllCdlTransmitVOs[i].setBlNo(usaTmlBlByVvdVO.getBlNo());
					cllCdlTransmitVOs[i].setCntrNo(usaTmlBlByVvdVO.getCntrNo());
					cllCdlTransmitVOs[i].setBkgCgoTpCd(usaTmlBlByVvdVO.getBkgCgoTpCd());
					cllCdlTransmitVOs[i].setInListType("D");
					cllCdlTransmitVOs[i].setInVvdCd(usaTmlBlByVvdVO.getVslCd() + usaTmlBlByVvdVO.getSkdVoyNo()
							+ usaTmlBlByVvdVO.getSkdDirCd());
					cllCdlTransmitVOs[i].setInPolCd(usaTmlBlByVvdVO.getCstmsPolCd());
					cllCdlTransmitVOs[i].setInPodCd(usaTmlBlByVvdVO.getCstmsPodCd());
					cllCdlTransmitVOs[i].setInSndId(usaTmlBlByVvdVO.getSndId());
					cllCdlTransmitVOs[i].setInRcvId(usaTmlBlByVvdVO.getRcvId());
					cllCdlTransmitVOs[i].setInYdCd(usaTmlBlByVvdVO.getYdCd());
					cllCdlTransmitVOs[i].setInAreaId("USA");
					cllCdlTransmitVOs[i].setInDestSvrCd("USA");
					cllCdlTransmitVOs[i].setInWhereGubun("DL");
					cllCdlTransmitVOs[i].setInEdiMsgFunc("REPLACE");
				}
				CLLCDLManifestBC cLLCDLManifestBC = new CLLCDLManifestBCImpl();
				cLLCDLManifestBC.transmitCllCdl(cllCdlTransmitVOs, account);
			}
		}
		return null;
	}
}