/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : KrWharfageDecMgtBCImpl.java
 *@FileTitle : KrWharfageDecMgtBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.05.25 정재엽
 * 1.0 Creation
 * 2011.02.23 이수진 [CHM-201109020]  KOREA WHARFAGE 적용율 변경 요청
 * => OutBound이면서 부산인 경우 WHF 적용율을 192(할인되지 않은 적용율)로 Fix
 *    공통코드를 이용하는데 O/B인 경우는 할인된 적용율인 ATTR_CTNT4, I/B인 경우에는 할인되지 않은 적용율인 ATTR_CTNT3
 * 2015.08.20 정선용 [CHM-201537039] Split10-Split76-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.basic.KorCustomsTransmissionBackEndJob;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.basic.WharfageDecMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration.KrWharfageDecMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.integration.KrWharfageDecMgtEAIDAO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBkgCstmsLocVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBkgWhfCfmVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBlCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBlContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrBlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrCntrVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrCustVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfAplyPortRtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBerthCdCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBerthCdVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgKrWhfBlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlChkListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBkgChkListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExpInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExptInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlInfoContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCfmVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCgoClassCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgExpSumVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgGenVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfChgVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCntrExpInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfCommInvListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecBzcInfoForApIfVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecChkListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecEdiFfContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecEdiFfVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecEdiRtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecEdiVvdVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecExptVolVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecIfArInvVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfExemptInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfExemptInfoContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfLocCdListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfPortRtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfRateListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfRateVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoContainerVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVvdDtlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfDecCheckSendDtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.BlCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.VvdPortEtdEtaVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBerthCdCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBerthCdVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlChkListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBkgChkListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlChkVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBkgChkVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfBlVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfCgoClassCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfChgListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfChgVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfCommInvListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfCommInvListVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfCommInvVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfConfirmVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecChkListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecChkVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfDecVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExemptInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfExemptInfoVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfLocCdListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfLocCdVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfPortRtListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfPortRtVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfRateListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfRateVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfVslInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.vo.WhfVslInfoVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApSlipInterfaceListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApInvDtrbVO;
import com.hanjin.syscommon.common.table.ApInvHdrVO;
import com.hanjin.syscommon.common.table.BkgCstmsLocVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgKrWhfBlVO;
import com.hanjin.syscommon.common.table.BkgKrWhfBrthVO;
import com.hanjin.syscommon.common.table.BkgKrWhfCfmVO;
import com.hanjin.syscommon.common.table.BkgKrWhfCntrVO;
import com.hanjin.syscommon.common.table.BkgKrWhfCustVO;
import com.hanjin.syscommon.common.table.BkgKrWhfPortRtVO;
import com.hanjin.syscommon.common.table.BkgKrWhfRtVO;
import com.hanjin.syscommon.common.table.BkgKrWhfVolVO;
import com.hanjin.syscommon.common.table.BkgKrWhfVvdDtlVO;

/**
 * NIS2010-WharfageDecMgt Business Logic Basic Command implementation<br>
 * - NIS2010-WharfageDecMgt 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jeong jae yoeb
 * @see KrWharfageDecMgtDBDAO 참조
 * @since J2EE 1.4
 */
public class KrWharfageDecMgtBCImpl extends WharfageDecMgtBCImpl {



	// Database Access Object
	private transient KrWharfageDecMgtDBDAO  dbDao = null;
	private transient KrWharfageDecMgtEAIDAO eaiDao = null;

	/**
	 * KrWharfageDecMgtBCImpl 객체 생성<br>
	 * KrWharfageDecMgtDBDAO 생성한다.<br>
	 * KrWharfageDecMgtDBDAO 생성한다.<br>
	 */
	public KrWharfageDecMgtBCImpl() {
		dbDao  = new KrWharfageDecMgtDBDAO();
		eaiDao = new KrWharfageDecMgtEAIDAO();
	}


	/**
	 * Wharfage 신고 부두 코드 조회
	 *
	 * @param WhfBerthCdCondVO whfBerthCdCondVO 조회조건
	 * @return List<WhfBerthCdVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfBerthCdVO> searchWhfBerthCd(WhfBerthCdCondVO whfBerthCdCondVO ) throws EventException {

		try {
			List<BkgKrWhfBrthVO> list  = dbDao.searchKrWhfBerthCd( (KrWhfBerthCdCondVO)whfBerthCdCondVO );
			List<WhfBerthCdVO>    list2 = new ArrayList<WhfBerthCdVO>();

			KrWhfBerthCdVO krWhfBerthCdVO;
			BkgKrWhfBrthVO bkgKrWhfBrthVO;
			for (Iterator<BkgKrWhfBrthVO> iterator = list.iterator(); iterator.hasNext();) {

				krWhfBerthCdVO = new KrWhfBerthCdVO();
				bkgKrWhfBrthVO = iterator.next();
				ObjectCloner.build(bkgKrWhfBrthVO, krWhfBerthCdVO);
				list2.add(krWhfBerthCdVO);
			}

			return list2;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * Wharfage 신고 부두 코드 관리 (생성, 정정, 삭제)
	 *
	 * @param List<WhfBerthCdVO> whfBerthCdVOs 신고부두코드
	 * @param account 세션정보
	 * @throws EventException
	 */
	@Override
	public void manageWhfBerthCd( List<WhfBerthCdVO> whfBerthCdVOs , SignOnUserAccount account) throws EventException {

		try {

			List<BkgKrWhfBrthVO> ilist = new ArrayList<BkgKrWhfBrthVO>();
			List<BkgKrWhfBrthVO> ulist = new ArrayList<BkgKrWhfBrthVO>();
			List<BkgKrWhfBrthVO> dlist = new ArrayList<BkgKrWhfBrthVO>();

			for (Iterator<WhfBerthCdVO> iterator = whfBerthCdVOs.iterator(); iterator.hasNext();) {
				WhfBerthCdVO   whfBerthCdVO   = iterator.next();
				BkgKrWhfBrthVO bkgKrWhfBrthVO = new BkgKrWhfBrthVO();

				ObjectCloner.build(whfBerthCdVO, bkgKrWhfBrthVO);
				bkgKrWhfBrthVO.setCreUsrId( account.getUsr_id() );
				bkgKrWhfBrthVO.setUpdUsrId( account.getUsr_id() );

				if( "I".equals( bkgKrWhfBrthVO.getIbflag() ) )
					ilist.add( bkgKrWhfBrthVO );
				else if( "U".equals( bkgKrWhfBrthVO.getIbflag() ) )
					ulist.add( bkgKrWhfBrthVO );
				else if( "D".equals( bkgKrWhfBrthVO.getIbflag() ) )
					dlist.add( bkgKrWhfBrthVO );
			}

			if( ilist.size() > 0 ) dbDao.addBkgKrWhfBrth(ilist);
			if( ulist.size() > 0 ) dbDao.modifyBkgKrWhfBrth(ulist);
			if( dlist.size() > 0 ) dbDao.removeBkgKrWhfBrth(dlist);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}

	/**
	 * 항구 별 Wharfage 신고 요율 조회
	 *
	 * @param WhfPortRtListCondVO whfPortRtListCondVO 조회조건
	 * @return List<WhfPortRtVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfPortRtVO> searchWhfPortRtList( WhfPortRtListCondVO whfPortRtListCondVO ) throws EventException {

		try {
			KrWhfPortRtListCondVO krWhfPortRtListCondVO = (KrWhfPortRtListCondVO)whfPortRtListCondVO;
			List<BkgKrWhfPortRtVO> list  = dbDao.searchKrWhfPortRtList( krWhfPortRtListCondVO );
			List<WhfPortRtVO>      list2 = new ArrayList<WhfPortRtVO>();

			KrWhfPortRtVO krWhfPortRtVO;
			BkgKrWhfPortRtVO bkgKrWhfPortRtVO;
			for (Iterator<BkgKrWhfPortRtVO> iterator = list.iterator(); iterator.hasNext();) {

				krWhfPortRtVO = new KrWhfPortRtVO();
				bkgKrWhfPortRtVO = iterator.next();
				ObjectCloner.build(bkgKrWhfPortRtVO, krWhfPortRtVO);
				list2.add(krWhfPortRtVO);
			}

			return list2;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * Port별 Wharfage 신고 요율 수정
	 *
	 * @param WhfPortRtVO[] whfPortRtVOs 신고요율
	 * @param SignOnUserAccount account 세션정보
	 * @throws EventException
	 */
	@Override
	public void manageWhfPortRt( WhfPortRtVO[] whfPortRtVOs , SignOnUserAccount account) throws EventException {

		try {
			List<BkgKrWhfPortRtVO> checklist = null;
			List<BkgKrWhfPortRtVO> ilist = new ArrayList<BkgKrWhfPortRtVO>();
			List<BkgKrWhfPortRtVO> ulist = new ArrayList<BkgKrWhfPortRtVO>();
			List<BkgKrWhfPortRtVO> dlist = new ArrayList<BkgKrWhfPortRtVO>();

			for (int i = 0; i < whfPortRtVOs.length; i++) {
				WhfPortRtVO   whfPortRtVO   = whfPortRtVOs[i];
				BkgKrWhfPortRtVO bkgKrWhfPortRtVO = new BkgKrWhfPortRtVO();

				ObjectCloner.build(whfPortRtVO, bkgKrWhfPortRtVO);
				bkgKrWhfPortRtVO.setCreUsrId( account.getUsr_id() );
				bkgKrWhfPortRtVO.setUpdUsrId( account.getUsr_id() );

				if( "I".equals( bkgKrWhfPortRtVO.getIbflag() ) )
					ilist.add( bkgKrWhfPortRtVO );
				else if( "U".equals( bkgKrWhfPortRtVO.getIbflag() ) )
					ulist.add( bkgKrWhfPortRtVO );
				else if( "D".equals( bkgKrWhfPortRtVO.getIbflag() ) )
					dlist.add( bkgKrWhfPortRtVO );
			}

			//중복 체크

			if( dlist.size() > 0 ) dbDao.removeBkgKrWhfPortRt(dlist);

			if( ulist.size() > 0 ){

				dbDao.modifyBkgKrWhfPortRt(ulist);
				checklist = dbDao.checkIfPortRate(ulist);
				if ( checklist.size() != 1  ){
					BkgKrWhfPortRtVO bkgKrWhfPortRtVO = checklist.get(0);
					throw new EventException(new ErrorHandler("BKG06014",new String[]{bkgKrWhfPortRtVO.getCntrBlkDivCd() + ", " +
																					  bkgKrWhfPortRtVO.getPortCd()       + ", " +
																					  bkgKrWhfPortRtVO.getIoBndCd()      + ", " +
																					  bkgKrWhfPortRtVO.getDcRtoNo()      + "%인 데이터가 이미 존재합니다." }).getMessage());
				}
			}

			if( ilist.size() > 0 ){
				checklist = dbDao.checkIfPortRate(ilist);
				if ( checklist == null  ){
					dbDao.addBkgKrWhfPortRt(ilist);
				}else{
					BkgKrWhfPortRtVO bkgKrWhfPortRtVO = checklist.get(0);

					throw new EventException(new ErrorHandler("BKG06014",new String[]{bkgKrWhfPortRtVO.getCntrBlkDivCd() + ", " +
																					  bkgKrWhfPortRtVO.getPortCd()       + ", " +
																					  bkgKrWhfPortRtVO.getIoBndCd()      + ", " +
																					  bkgKrWhfPortRtVO.getDcRtoNo()      + "%인 데이터가 이미 존재합니다." }).getMessage());

				}
			}


		}catch( EventException ex){
			throw ex;
		}catch(DAOException dx) {
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), dx);
		}
	}

	/**
	 * Wharfage 신고 대상 B/L 및 운임 정보 조회
	 *
	 * @param WhfChgListCondVO whfChgListCondVO 조회조건
	 * @return List<WhfChgVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfChgVO> searchWhfChgList(WhfChgListCondVO whfChgListCondVO) throws EventException {

		try {

			List<WhfChgVO> whfChgVOs = new ArrayList<WhfChgVO>();
			KrWhfChgContainerVO krWhfChgContainerVO = new KrWhfChgContainerVO();
			KrWhfChgListCondVO krWhfChgListCondVO = (KrWhfChgListCondVO)whfChgListCondVO;

			VvdPortEtdEtaVO        vvdPortEtdEtaVO = dbDao.searchVvdPortEtdEta( krWhfChgListCondVO.getVvd(), ("S".equals(krWhfChgListCondVO.getBkgCustTpCd()) ? krWhfChgListCondVO.getPolCd() : krWhfChgListCondVO.getPodCd()) );
			List<KrWhfChgVO>       list1 = dbDao.searchKrWhfChgList( krWhfChgListCondVO );
			List<KrWhfChgGenVO>    list2 = dbDao.searchKrWhfChgListGenSum( krWhfChgListCondVO );
			List<KrWhfChgExpSumVO> list3 = dbDao.searchKrWhfChgListExpSum( krWhfChgListCondVO );
			BkgKrWhfCfmVO bkgKrWhfCfmVO  = dbDao.searchKrWhfCfmInfo( krWhfChgListCondVO );

			krWhfChgContainerVO.setVvdPortEtdEtaVO(vvdPortEtdEtaVO);
			krWhfChgContainerVO.setKrWhfChgVOs(list1);
			krWhfChgContainerVO.setKrWhfChgGenVOs(list2);
			krWhfChgContainerVO.setKrWhfChgExpSumVOs(list3);
			krWhfChgContainerVO.setKrWhfCfmVO((KrWhfCfmVO)bkgKrWhfCfmVO);

			whfChgVOs.add( (WhfChgVO)krWhfChgContainerVO );

			return whfChgVOs;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * Wharfage 선박 정보 (ETD, MRN) 조회
	 *
	 * @param WhfVslInfoCondVO whfVslInfoCondVO
	 * @return WhfVslInfoVO
	 * @throws EventException
	 */
	@Override
	public WhfVslInfoVO searchWhfVslEtdMrn(WhfVslInfoCondVO whfVslInfoCondVO) throws EventException {

		try {
			BookingUtil utilCmd = new BookingUtil();
			KrWhfVslInfoCondVO krWhfVslInfoCondVO = (KrWhfVslInfoCondVO)whfVslInfoCondVO;
			KrWhfVslInfoContainerVO krWhfVslInfoContainerVO = new KrWhfVslInfoContainerVO();

			KrWhfVslInfoVO krWhfVslInfoVO = dbDao.searchKrWhfVslEtdMrn( krWhfVslInfoCondVO );

			// 조건값의 port_cd 의 존재 여부에 따라
			if(  ! "".equals( krWhfVslInfoCondVO.getVpsPortCd() ) ) {
				BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("KR_WHF_VSL_INFO");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1(krWhfVslInfoCondVO.getVpsPortCd());
				List<BkgHrdCdgCtntVO> bkgHrdCdgCntnVOs = utilCmd.searchHardCoding(bkgHrdCdgCtntListCondVO);
				if (bkgHrdCdgCntnVOs.size() > 0) {
					if (krWhfVslInfoVO == null) {
						krWhfVslInfoVO = new KrWhfVslInfoVO();
						krWhfVslInfoVO.setMrnChkNo("");
						krWhfVslInfoVO.setMrnNo("");
						krWhfVslInfoVO.setVpsDt("");
					}

					krWhfVslInfoVO.setTmlCd(bkgHrdCdgCntnVOs.get(0).getAttrCtnt5());
					if (bkgHrdCdgCntnVOs.get(0).getAttrCtnt2().length() == 7) {
//						log.debug("bkgHrdCdgCntnVOs.get(0).getAttrCtnt2()=[" + bkgHrdCdgCntnVOs.get(0).getAttrCtnt2() + "]");
						krWhfVslInfoVO.setUnldAgnCd1(bkgHrdCdgCntnVOs.get(0).getAttrCtnt2().substring(0, 2));
						krWhfVslInfoVO.setUnldAgnCd2(bkgHrdCdgCntnVOs.get(0).getAttrCtnt2().substring(2, 3));
						krWhfVslInfoVO.setUnldAgnCd3(bkgHrdCdgCntnVOs.get(0).getAttrCtnt2().substring(3));
					}
//					log.debug("krWhfVslInfoCondVO.getIoBndCd().substring(0,1)=[" + krWhfVslInfoCondVO.getIoBndCd().substring(0,1) + "]");
					if (krWhfVslInfoCondVO.getIoBndCd().substring(0,1).equals("O")) {
						if("KRPUS".equals(krWhfVslInfoCondVO.getVpsPortCd())){
							krWhfVslInfoVO.setWhfRt(bkgHrdCdgCntnVOs.get(0).getAttrCtnt3());
						}else{
							krWhfVslInfoVO.setWhfRt(bkgHrdCdgCntnVOs.get(0).getAttrCtnt4());
						}
					}else{
						krWhfVslInfoVO.setWhfRt(bkgHrdCdgCntnVOs.get(0).getAttrCtnt3());
					}
				}
				krWhfVslInfoContainerVO.setKrWhfVslInfoVO(krWhfVslInfoVO);

				List<KrWhfVslInfoVO> krWhfVslInfoVOs = dbDao.searchKrWhfWharfList(krWhfVslInfoCondVO);
				krWhfVslInfoContainerVO.setKrWhfVslInfoVOs(krWhfVslInfoVOs);
			}



			return krWhfVslInfoContainerVO;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}

	}


	/**
	 * Wharfage 신고 대상 선박 정보 조회
	 *
	 * @param WhfVslInfoCondVO whfVslInfoCondVO
	 * @return WhfVslInfoVO
	 * @throws EventException
	 */
	@Override
	public WhfVslInfoVO searchWhfVslInfo(WhfVslInfoCondVO whfVslInfoCondVO) throws EventException {
		try {
			WhfVslInfoVO whfVslInfoVO = null;
			whfVslInfoVO = dbDao.searchKrWhfVslInfo( (KrWhfVslInfoCondVO)whfVslInfoCondVO );

			if( whfVslInfoVO == null )
				whfVslInfoVO = dbDao.searchKrWhfDfltVslInfo((KrWhfVslInfoCondVO)whfVslInfoCondVO);

			return whfVslInfoVO;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * Wharfage 신고 선박 정보 관리
	 *
	 * @param WhfVslInfoVO whfVslInfoVO 신고 선박 정보
	 * @param SignOnUserAccount account 세션정보
	 * @throws EventException
	 */
	@Override
	public void manageWhfVslInfo(WhfVslInfoVO whfVslInfoVO, SignOnUserAccount account) throws EventException {
		try {
			//WhfVslInfoVO whfVslInfoVO = null;
			List<BkgKrWhfVolVO> bkgKrWhfVolVOs = null;
			BkgKrWhfVolVO bkgKrWhfVolVO = null;
			KrWhfVslInfoVO krWhfVslInfoVO = (KrWhfVslInfoVO)whfVslInfoVO ;
			String vvd = krWhfVslInfoVO.getVvd();
			String vslCd    = vvd.substring(0, 4);
			String skdVoyNo = vvd.substring(4, 8);
			String skdDirCd = vvd.substring(8, 9);

			//CHECK 운항스케줄에 VVD 가 존재하는지 확인한다.
			Boolean boolean1 = dbDao.checkIfVvdExist( vslCd, skdVoyNo, skdDirCd );

			/*
			 * II인 경우 IT까지 동일하게 생성해 준다.
			 * OO인 경우 OT까지 동일하게 생성해 준다.
			 */
			if ( boolean1 == true ){

				bkgKrWhfVolVOs = new ArrayList<BkgKrWhfVolVO>();
				bkgKrWhfVolVO = new BkgKrWhfVolVO();
				ObjectCloner.build(krWhfVslInfoVO, bkgKrWhfVolVO);

				bkgKrWhfVolVO.setVslCd(vslCd);
				bkgKrWhfVolVO.setSkdVoyNo(skdVoyNo);
				bkgKrWhfVolVO.setSkdDirCd(skdDirCd);
				bkgKrWhfVolVO.setWhfBndCd(krWhfVslInfoVO.getWhfBndCd());
				bkgKrWhfVolVO.setUnldAgnCd(krWhfVslInfoVO.getUnldAgnCd1() + krWhfVslInfoVO.getUnldAgnCd2() + krWhfVslInfoVO.getUnldAgnCd3() );
				bkgKrWhfVolVO.setWhfPayDt( krWhfVslInfoVO.getWhfPayDt().replace("-", "") );
				bkgKrWhfVolVO.setMfRefNo(krWhfVslInfoVO.getMrnNo());
				bkgKrWhfVolVO.setSailDt(krWhfVslInfoVO.getVpsDt().replaceAll("-", ""));

				bkgKrWhfVolVO.setVslNm(krWhfVslInfoVO.getVslNm());
				bkgKrWhfVolVO.setCreUsrId(account.getUsr_id());
				bkgKrWhfVolVO.setUpdUsrId(account.getUsr_id());

				String[] whfBndCd = new String[3];

				if ( "II".equals( krWhfVslInfoVO.getWhfBndCd() ) ){

					whfBndCd[0] = "II";
					whfBndCd[1] = "IT";
					whfBndCd[2] = "IM";
				}else if ( "OO".equals( krWhfVslInfoVO.getWhfBndCd() ) ){
					whfBndCd[0] = "OO";
					whfBndCd[1] = "OT";
					whfBndCd[2] = "OM";
				}
				for (int i = 0; i < whfBndCd.length; i++) {
					bkgKrWhfVolVO.setWhfBndCd( whfBndCd[i] );
					bkgKrWhfVolVOs.add( bkgKrWhfVolVO );
					dbDao.addBkgKrWhfVol( bkgKrWhfVolVOs );
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}

	/**
	 * 한국 WHF BL 목록 조회
	 *
	 * @param SearchWhfBlListCondVO searchWhfBlListCondVO 조회조건
	 * @return List<WhfBlVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfBlVO> searchWhfBlList(WhfBlListCondVO whfBlListCondVO) throws EventException {
		KrWhfBlListCondVO krWhfBlListCondVO = (KrWhfBlListCondVO) whfBlListCondVO;
		log.info("krWhfBlListCondVO.getVvd()=[" + krWhfBlListCondVO.getVvd() + "]");
		log.info("krWhfBlListCondVO.getWhfPolCd()=[" + krWhfBlListCondVO.getWhfPolCd() + "]");
		log.info("krWhfBlListCondVO.getWhfBndCd()=[" + krWhfBlListCondVO.getWhfBndCd() + "]");
		try {
			// 이미 해당 VVD, Port, Bound 별 다운로드 받은 B/L 이 존재하는지 확인 후 Exception 처리
			String krWhfExistFlg = dbDao.searchKrWhfBlExistFlg(krWhfBlListCondVO);
			log.info("krWhfExistFlg=[" + krWhfExistFlg + "]");
			if ("Y".equals(krWhfExistFlg)) {
				throw new EventException(new ErrorHandler("BKG06063", new String[]{
						krWhfBlListCondVO.getVvd(),
						krWhfBlListCondVO.getWhfPolCd(),
						krWhfBlListCondVO.getWhfBndCd()}).getMessage());
			}

			// 이미 해당 VVD, Port, Bound 별 다운로드 받을 B/L 목록 조회
			List<KrWhfBlVO> list = dbDao.searchKrWhfBlList(krWhfBlListCondVO);
			WhfBlVO whfBlVO = null;
			List<WhfBlVO> list2 = new ArrayList<WhfBlVO>();
			if(list != null){
				for (Iterator<KrWhfBlVO> iterator = list.iterator(); iterator.hasNext();) {
					KrWhfBlVO krWhfBlVO = iterator.next();
					whfBlVO = (WhfBlVO)krWhfBlVO;
					list2.add(whfBlVO);
				}
			}
			return list2;

		} catch(DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch(EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}


	/**
	 * Wharfage Location Code 정보 조회
	 *
	 * @param WhfLocCdListCondVO whfLocCdListCondVO 조회조건
	 * @return List<WhfLocCdVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfLocCdVO> searchWhfLocCdList(WhfLocCdListCondVO whfLocCdListCondVO ) throws EventException {
		try {
			List<BkgCstmsLocVO> list = dbDao.searchKrWhfLocCdList( (KrWhfLocCdListCondVO)whfLocCdListCondVO );
			WhfLocCdVO whfLocCdVO = null;
			KrBkgCstmsLocVO krBkgCstmsLocVO = null;
			List<WhfLocCdVO> list2 = new ArrayList<WhfLocCdVO>();

			if(list != null){
				for (Iterator<BkgCstmsLocVO> iterator = list.iterator(); iterator.hasNext();) {
					BkgCstmsLocVO bkgCstmsLocVO = iterator.next();
					krBkgCstmsLocVO = new KrBkgCstmsLocVO();
					ObjectCloner.build(bkgCstmsLocVO, krBkgCstmsLocVO);

					krBkgCstmsLocVO.setOlocCd(bkgCstmsLocVO.getLocCd());
					krBkgCstmsLocVO.setOunLocId( bkgCstmsLocVO.getUnLocId() );

					whfLocCdVO = (WhfLocCdVO)krBkgCstmsLocVO;
					list2.add(whfLocCdVO);
				}
			}
			return list2;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * Wharfage Location Code 관리
	 *
	 * @param List<WhfLocCdVO> whfLocCdVOs Wharfage Location Code
	 * @param SignOnUserAccount account 세션정보
	 * @throws EventException
	 */
	@Override
	public void manageWhfLocCd( List<WhfLocCdVO> whfLocCdVOS, SignOnUserAccount account) throws EventException {

		try {

			List<KrBkgCstmsLocVO> ilist = new ArrayList<KrBkgCstmsLocVO>();
			List<KrBkgCstmsLocVO> ulist = new ArrayList<KrBkgCstmsLocVO>();
			List<KrBkgCstmsLocVO> dlist = new ArrayList<KrBkgCstmsLocVO>();

			for (Iterator<WhfLocCdVO> iterator = whfLocCdVOS.iterator(); iterator.hasNext();) {
				WhfLocCdVO   whfLocCdVO   = iterator.next();
				KrBkgCstmsLocVO krBkgKrWhfBrthVO =  (KrBkgCstmsLocVO)whfLocCdVO;

				krBkgKrWhfBrthVO.setCreUsrId( account.getUsr_id() );
				krBkgKrWhfBrthVO.setUpdUsrId( account.getUsr_id() );

				if( "I".equals( krBkgKrWhfBrthVO.getIbflag() ) )
					ilist.add( krBkgKrWhfBrthVO );
				else if( "U".equals( krBkgKrWhfBrthVO.getIbflag() ) )
					ulist.add( krBkgKrWhfBrthVO );
				else if( "D".equals( krBkgKrWhfBrthVO.getIbflag() ) )
					dlist.add( krBkgKrWhfBrthVO );
			}

			if( ilist.size() > 0 ) dbDao.addBkgCstmsLoc(ilist);
			if( ulist.size() > 0 ) dbDao.modifyBkgCstmsLoc(ulist);
			if( dlist.size() > 0 ) dbDao.deleteBkgCstmsLoc(dlist);

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}


	/**
	 * Wharfage 신고 내역 확정
	 *
	 * @param WhfConfirmVO whfConfirmVO Wharfage 신고 내역
	 * @param SignOnUserAccount account 세션정보
	 * @return BkgKrWhfCfmVO
	 * @throws EventException
	 */
	@Override
	public BkgKrWhfCfmVO makeWhfConfirm(WhfConfirmVO whfConfirmVO, SignOnUserAccount account) throws EventException {
		BkgKrWhfCfmVO outBkgKrWhfCfmVO = null;

		try {

			KrBkgWhfCfmVO krBkgWhfCfmVO = (KrBkgWhfCfmVO)whfConfirmVO;
			BkgKrWhfCfmVO bkgKrWhfCfmVO = new BkgKrWhfCfmVO();
			String sVvd = krBkgWhfCfmVO.getVvd();
			bkgKrWhfCfmVO.setVslCd(sVvd.substring(0, 4));
			bkgKrWhfCfmVO.setSkdVoyNo(sVvd.substring(4, 8));
			bkgKrWhfCfmVO.setSkdDirCd(sVvd.substring(8, 9));

			if( "S".equals(krBkgWhfCfmVO.getBkgCustTpCd()) )
				bkgKrWhfCfmVO.setPortCd(krBkgWhfCfmVO.getPolCd());
			else
				bkgKrWhfCfmVO.setPortCd(krBkgWhfCfmVO.getPodCd());

			bkgKrWhfCfmVO.setWhfBndCd(krBkgWhfCfmVO.getBkgCustTpCd());
			bkgKrWhfCfmVO.setCfmUsrId( account.getUsr_nm() );
			bkgKrWhfCfmVO.setCreUsrId( account.getUsr_id() );
			bkgKrWhfCfmVO.setUpdUsrId( account.getUsr_id() );

			// Confirm은 한번만 할 수 있으므로 Confirm되어 있는지 Check
			Boolean boolean1 = dbDao.checkWhfConfirm(bkgKrWhfCfmVO);

			if ( boolean1 == true ){
				dbDao.addBkgKrWhfCfm( bkgKrWhfCfmVO );

				KrWhfChgListCondVO krWhfChgListCondVO = new KrWhfChgListCondVO();
				krWhfChgListCondVO.setVvd(bkgKrWhfCfmVO.getVslCd() +
						bkgKrWhfCfmVO.getSkdVoyNo() +
						bkgKrWhfCfmVO.getSkdDirCd());
				krWhfChgListCondVO.setBkgCustTpCd(krBkgWhfCfmVO.getBkgCustTpCd());
				krWhfChgListCondVO.setPolCd(krBkgWhfCfmVO.getPolCd());
				krWhfChgListCondVO.setPodCd(krBkgWhfCfmVO.getPodCd());

				outBkgKrWhfCfmVO = dbDao.searchKrWhfCfmInfo(krWhfChgListCondVO);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return outBkgKrWhfCfmVO;
	}



	/**
	 * Wharfage 신고 대상 B/L 정보 추가 하기 위해 B/L 정보 조회 함
	 *
	 * @param BlCondVO blCondVO 조회조건
	 * @return BlVO
	 * @throws EventException
	 */
	@Override
	public BlVO searchBl(BlCondVO blCondVO) throws EventException {

		try {

			KrBlContainerVO krBlContainerVO = new KrBlContainerVO();

			KrBlCondVO krBlCondVO = ( KrBlCondVO )blCondVO;
			KrBlVO krBlVO            = dbDao.searchKrBl(krBlCondVO);
			List<KrCntrVO> krCntrVOs = dbDao.searchKrCntr(krBlCondVO);
			List<KrCustVO> krCustVOs = dbDao.searchKrCust(krBlCondVO);


			krBlContainerVO.setKrBlVO(krBlVO);
			krBlContainerVO.setKrCntrVOs(krCntrVOs);
			krBlContainerVO.setKrCustVOs(krCustVOs);

			return krBlContainerVO;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}

	}

	/**
	 * WHF charge code가 포함된 목록 조회
	 *
	 * @param WhfRateListCondVO whfRateListCondVO 조회조건
	 * @return List<WhfRateVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfRateVO> searchWhfRateList(WhfRateListCondVO whfRateListCondVO) throws EventException {

		try {

			List<WhfRateVO> list = new ArrayList<WhfRateVO>();
			List<KrWhfRateVO> krWhfRateVOs = dbDao.searchKrWhfRateList( (KrWhfRateListCondVO)whfRateListCondVO );
			for (Iterator<KrWhfRateVO> iterator = krWhfRateVOs.iterator(); iterator.hasNext();) {
				WhfRateVO whfRateVO = (WhfRateVO) iterator.next();
				list.add(whfRateVO);
			}

			return list;

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}


	/**
	 * 한국 세관에 신고 된 B/L 중 WHF 신고 누락 분이 있는지 조회
	 *
	 * @param WhfBlChkListCondVO whfBlChkListCondVO 조회조건
	 * @return List<WhfBlChkVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfBlChkVO> searchWhfBlChkList(WhfBlChkListCondVO whfBlChkListCondVO) throws EventException {
		try {

			return dbDao.searchKrWhfBlChkList( (KrWhfBlChkListCondVO)whfBlChkListCondVO );

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * BKG Master 중 WHF 신고 누락 분이 있는지 조회
	 *
	 * @param WhfBkgChkListCondVO whfBkgChkListCondVO 조회조건
	 * @return List<WhfBkgChkVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfBkgChkVO> searchWhfBkgChkList(WhfBkgChkListCondVO whfBkgChkListCondVO) throws EventException {
		try {

			return dbDao.searchKrWhfBkgChkList( (KrWhfBkgChkListCondVO)whfBkgChkListCondVO );

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * 다운로드 받은 WHF BL 정보 관리
	 *
	 * @param WhfBlVO[] whfBlVOs WHF BL 정보
	 * @param SignOnUserAccount account 세션정보
	 * @throws EventException
	 */
	@Override
	public void manageWhfBl(WhfBlVO[] whfBlVOs, SignOnUserAccount account) throws EventException {
		try {
			//GeneralEventResponse eventResponse = new GeneralEventResponse();
			KrWhfBlContainerVO krWhfBlContainerVO = (KrWhfBlContainerVO)whfBlVOs[0];


		if( !"EsmBkg0122Event".equals(krWhfBlContainerVO.getSvcGubunId()) )	{

			KrWhfVslInfoCondVO krWhfVslInfoCondVO = krWhfBlContainerVO.getKrWhfVslInfoCondVO();

			if (whfBlVOs != null) {
				String sVslCd    = "";
				String sSkdVoyNo = "";
				String sSkdDirCd = "";
				String sBlNo     = "";
				String sPortCd   = "";
				String sWhfBndCd = "";

				KrWhfBkgInfoVO krWhfBkgInfoVO = dbDao.searchBkgInfo(krWhfBlContainerVO.getKrWhfBkgInfoCondVO());

				KrWhfBkgKrWhfBlVO[] arry = krWhfBlContainerVO.getKrWhfBkgKrWhfBlVOs();
				List<KrWhfBkgKrWhfBlVO> list = new ArrayList<KrWhfBkgKrWhfBlVO>();
				for (int i = 0; i < arry.length; i++) {
					arry[i].setCreUsrId(account.getUsr_id());
					arry[i].setUpdUsrId(account.getUsr_id());

					arry[i].setPckQty( arry[i].getPckQty().replaceAll(",", "") );
					arry[i].setMeasQty( arry[i].getMeasQty().replaceAll(",", "") );
					arry[i].setActWgt( arry[i].getActWgt().replaceAll(",", "") );
					arry[i].setRevenue( arry[i].getRevenue().replaceAll(",", "") );
					arry[i].setWhfBlThruTsFlg(krWhfBkgInfoVO.getWhfBlThruTsFlg());
					arry[i].setBkgCgoTpCd(krWhfBkgInfoVO.getBkgCgoTpCd());
					arry[i].setObSlsOfcCd(krWhfBkgInfoVO.getObSlsOfcCd());
					arry[i].setSlanCd(krWhfBkgInfoVO.getSlanCd());

					sVslCd    = arry[i].getVslCd();
					sSkdVoyNo = arry[i].getSkdVoyNo();
					sSkdDirCd = arry[i].getSkdDirCd();
					sBlNo     = arry[i].getBlNo();
					sPortCd   = arry[i].getPortCd();
					sWhfBndCd = arry[i].getWhfBndCd();
					list.add(arry[i]);
				}
				krWhfVslInfoCondVO.setPortCd(sPortCd);
				krWhfVslInfoCondVO.setVvd(sVslCd + sSkdVoyNo + sSkdDirCd);
				krWhfVslInfoCondVO.setWhfBndCd(sWhfBndCd);

				if( ! dbDao.checkIfDecNoExist(krWhfVslInfoCondVO) ){
					dbDao.mergeBkgKrWhfBl(list);

					List<BkgKrWhfRtVO> bkgKrWhfRtVOs = new ArrayList<BkgKrWhfRtVO>();
					BkgKrWhfRtVO bkgKrWhfRtVO        = new BkgKrWhfRtVO();

					bkgKrWhfRtVO.setVslCd(sVslCd);
					bkgKrWhfRtVO.setSkdVoyNo(sSkdVoyNo);
					bkgKrWhfRtVO.setSkdDirCd(sSkdDirCd);
					bkgKrWhfRtVO.setWhfBndCd(sWhfBndCd);
					bkgKrWhfRtVO.setBlNo(sBlNo);

					bkgKrWhfRtVOs.add(bkgKrWhfRtVO);
					dbDao.removeBkgKrWhfRt(bkgKrWhfRtVOs);

					BkgKrWhfCustVO[] bkgKrWhfCustVOs = krWhfBlContainerVO.getBkgKrWhfCustVOs();

					if( bkgKrWhfCustVOs != null ){
						List<BkgKrWhfCustVO> ilist = new ArrayList<BkgKrWhfCustVO>();
						List<BkgKrWhfCustVO> dlist = new ArrayList<BkgKrWhfCustVO>();

						BkgKrWhfCustVO bkgKrWhfCustVO = new BkgKrWhfCustVO();
						bkgKrWhfCustVO.setBlNo(sBlNo);
						bkgKrWhfCustVO.setVslCd(sVslCd);
						bkgKrWhfCustVO.setSkdVoyNo(sSkdVoyNo);
						bkgKrWhfCustVO.setSkdDirCd(sSkdDirCd);
						dlist.add(bkgKrWhfCustVO);
						if( dlist.size() > 0 ) dbDao.removeBkgKrWhfCust(dlist);

						for (int i = 0; i < bkgKrWhfCustVOs.length; i++) {

							if( "I".equals( bkgKrWhfCustVOs[i].getIbflag() ) || "U".equals( bkgKrWhfCustVOs[i].getIbflag() ) ){
								bkgKrWhfCustVOs[i].setVslCd(sVslCd);
								bkgKrWhfCustVOs[i].setSkdVoyNo(sSkdVoyNo);
								bkgKrWhfCustVOs[i].setSkdDirCd(sSkdDirCd);
								bkgKrWhfCustVOs[i].setBlNo(sBlNo);
								bkgKrWhfCustVOs[i].setCreUsrId(account.getUsr_id());
								bkgKrWhfCustVOs[i].setUpdUsrId(account.getUsr_id());
								ilist.add( bkgKrWhfCustVOs[i] );
							}
						}
						if( ilist.size() > 0 ) dbDao.addBkgKrWhfCust(ilist);
					}

					BkgKrWhfCntrVO[] bkgKrWhfCntrVOs = krWhfBlContainerVO.getBkgKrWhfCntrVOs();

					if( bkgKrWhfCntrVOs != null ){
						List<BkgKrWhfCntrVO> ilist2 = new ArrayList<BkgKrWhfCntrVO>();
						List<BkgKrWhfCntrVO> dlist2 = new ArrayList<BkgKrWhfCntrVO>();

						BkgKrWhfCntrVO bkgKrWhfCntrVO = new BkgKrWhfCntrVO();
						bkgKrWhfCntrVO.setBlNo(sBlNo);
						bkgKrWhfCntrVO.setVslCd(sVslCd);
						bkgKrWhfCntrVO.setSkdVoyNo(sSkdVoyNo);
						bkgKrWhfCntrVO.setSkdDirCd(sSkdDirCd);
						dlist2.add(bkgKrWhfCntrVO);
						if( dlist2.size() > 0 ) dbDao.removeBkgKrWhfCntr(dlist2);

						for (int i = 0; i < bkgKrWhfCntrVOs.length; i++) {

							if( "I".equals( bkgKrWhfCntrVOs[i].getIbflag() ) || "U".equals( bkgKrWhfCntrVOs[i].getIbflag() ) ){
								bkgKrWhfCntrVOs[i].setVslCd(sVslCd);
								bkgKrWhfCntrVOs[i].setSkdVoyNo(sSkdVoyNo);
								bkgKrWhfCntrVOs[i].setSkdDirCd(sSkdDirCd);
								bkgKrWhfCntrVOs[i].setBlNo(sBlNo);
								bkgKrWhfCntrVOs[i].setCreUsrId(account.getUsr_id());
								bkgKrWhfCntrVOs[i].setUpdUsrId(account.getUsr_id());
								ilist2.add( bkgKrWhfCntrVOs[i] );
							}
						}
						if( ilist2.size() > 0 ) dbDao.addBkgKrWhfCntr(ilist2);
					}
				}
				else
				{
					throw new EventException(new ErrorHandler("BKG06103", new String[] {}).getMessage());
				}


			}
		} else {
			KrWhfVslInfoCondVO krWhfVslInfoCondVO = krWhfBlContainerVO.getKrWhfVslInfoCondVO();
			BkgKrWhfVolVO bkgKrWhfVolVO           = krWhfBlContainerVO.getBkgKrWhfVolVO();
			KrWhfBlInfoVO[] krWhfBlInfoVOs        = krWhfBlContainerVO.getKrWhfBlInfoVOs();
			if( ! dbDao.checkIfDecNoExist(krWhfVslInfoCondVO) ){

				String sVvd = krWhfVslInfoCondVO.getVvd();

				bkgKrWhfVolVO.setVslCd( sVvd.substring(0, 4) );
				bkgKrWhfVolVO.setSkdVoyNo( sVvd.substring(4, 8) );
				bkgKrWhfVolVO.setSkdDirCd( sVvd.substring(8, 9) );
				bkgKrWhfVolVO.setRtonWgt(bkgKrWhfVolVO.getRtonWgt().replace(",", ""));
				bkgKrWhfVolVO.setWhfRtAmt(bkgKrWhfVolVO.getWhfRtAmt().replace(",", ""));
				bkgKrWhfVolVO.setExptTonWgt(bkgKrWhfVolVO.getExptTonWgt().replace(",", ""));
				bkgKrWhfVolVO.setUpdUsrId(account.getUsr_id());
				List<BkgKrWhfVolVO> list = new ArrayList<BkgKrWhfVolVO>();
				list.add(bkgKrWhfVolVO);
				dbDao.modifyBkgKrWhfVol( list );

				KrWhfBlInfoVO krWhfBlInfoVO   = null;
				KrWhfVslInfoVO krWhfVslInfoVO = null;
				String sPortOfcCd = dbDao.searchPortOfc(krWhfVslInfoCondVO.getPortCd());
				List< BkgKrWhfBlVO > bkgKrWhfBlVOs = new ArrayList<BkgKrWhfBlVO>();
				for (int i = 0; i < krWhfBlInfoVOs.length; i++) {

					krWhfBlInfoVO = krWhfBlInfoVOs[i];
					krWhfVslInfoCondVO.setBlNo ( krWhfBlInfoVO.getBlNo() );

					String whfcd = "";
					whfcd = krWhfVslInfoCondVO.getWhfBndCd();
					krWhfVslInfoCondVO.setWhfBndCd(krWhfBlInfoVO.getWhfBndCd()); //2013.09.23 wharfage bound cd 조회조건이 아닌 조회된 data의 whfbndcd로 변경
					krWhfVslInfoVO = dbDao.searchLastKrWhfRtInfo( krWhfVslInfoCondVO );
					krWhfVslInfoCondVO.setWhfBndCd(whfcd); //2013.09.23 원래 조회 조건 whf bound cd로 복원

					/*
					 * 삭제 대상 B/L WHF Rate가 A/R I/F 된 경우 CONTINUE
					 */
					if ( null != krWhfVslInfoVO ){
						if( "D".equals( krWhfBlInfoVO.getIbflag() ) && "Y".equals(krWhfVslInfoVO.getArIfFlg())){
							continue ;
						}
					}

					/* TABLE VO에 값을 채움: BKG_KR_WHF_BL */
					BkgKrWhfBlVO bkgKrWhfBlVO = new BkgKrWhfBlVO();

					bkgKrWhfBlVO.setVslCd( sVvd.substring(0, 4) );
					bkgKrWhfBlVO.setSkdVoyNo( sVvd.substring(4, 8) );
					bkgKrWhfBlVO.setSkdDirCd( sVvd.substring(8, 9) );
					bkgKrWhfBlVO.setWhfBndCd(krWhfBlInfoVO.getWhfBndCd());
					bkgKrWhfBlVO.setBlNo(krWhfBlInfoVO.getBlNo());

//					bkgKrWhfBlVO.setWhfBndCd(krWhfVslInfoCondVO.getWhfBndCd());

					bkgKrWhfBlVO.setPolCd(krWhfBlInfoVO.getPolCd());
					bkgKrWhfBlVO.setPodCd(krWhfBlInfoVO.getPodCd());
					bkgKrWhfBlVO.setWfgExptCd(krWhfBlInfoVO.getWfgExptCd());
					bkgKrWhfBlVO.setCustRgstNo(krWhfBlInfoVO.getCustRgstNo());
					bkgKrWhfBlVO.setWgtQty(krWhfBlInfoVO.getWgtQty());
					bkgKrWhfBlVO.setMeasQty(krWhfBlInfoVO.getMeasQty());
					bkgKrWhfBlVO.setCstmsDeclTpCd( krWhfBlInfoVO.getT() );

					// 삭제 인 경우만 D로 업데이트
					if( "D".equals(krWhfBlInfoVO.getIbflag()))
						bkgKrWhfBlVO.setWhfBlStsCd( "D" );

					bkgKrWhfBlVO.setRtonWgt( krWhfBlInfoVO.getRtonWgt() );
					bkgKrWhfBlVO.setWhfAmt ( krWhfBlInfoVO.getWhfAmt() );
					bkgKrWhfBlVO.setCmdtCd ( krWhfBlInfoVO.getCmdtCd() );
					bkgKrWhfBlVO.setPckTpCd( krWhfBlInfoVO.getWhfPckTpCd() );
					bkgKrWhfBlVO.setUpdUsrId(account.getUsr_id());

					bkgKrWhfBlVOs.add(bkgKrWhfBlVO);

/*					if ( null != krWhfVslInfoVO ){
						newChgAmt = krWhfVslInfoVO.getNewChgAmt();
						chgRtSeq  = krWhfVslInfoVO.getChgRtSeq();
					}else{
						newChgAmt = "0";
						chgRtSeq  = "1";
					}*/
					String chgRtSeq  = krWhfVslInfoVO.getChgRtSeq();
					String oldChgAmt = krWhfVslInfoVO.getNewChgAmt();
					String newChgAmt = krWhfBlInfoVO.getWhfAmt();
					float diffAmt = (Float.parseFloat(newChgAmt)- Float.parseFloat(oldChgAmt));


					/*
					 * 금액 비교를 한다음
					 * "=" 이면 BKG_KR_WHF_RT 를 화면에서 가져온 값으로 업데이트 하고
					 * "<>" 이면 OLD_CHG_AMT, NEW_CHG_AMT, DIFF_AMT 값만 업데이트 한후 새로운 SEQ 딴후 데이터를 추가한다.
					 */
					List<BkgKrWhfRtVO> bkgKrWhfRtVOs = new ArrayList<BkgKrWhfRtVO>();
					List<BkgKrWhfRtVO> bkgKrWhfRtVOs2 = new ArrayList<BkgKrWhfRtVO>();
					BkgKrWhfRtVO bkgKrWhfRtVO        = new BkgKrWhfRtVO();
//					if( newChgAmt.equals( oldWhfAmt ) ){
					if (diffAmt == .0 && Integer.parseInt(chgRtSeq) > 0) {

						bkgKrWhfRtVO.setPortOfcCd(sPortOfcCd);
						bkgKrWhfRtVO.setCmdtCd  (krWhfBlInfoVO.getCmdtCd());
						bkgKrWhfRtVO.setBlCustNm(krWhfBlInfoVO.getCustNm());
						bkgKrWhfRtVO.setTaxCustNm( "" );
						bkgKrWhfRtVO.setKrWhfExptCd(krWhfBlInfoVO.getWfgExptCd());
						bkgKrWhfRtVO.setDeclRmk    (krWhfBlInfoVO.getCustRgstNo());

						// 면제 사유가 존재하면 tax로 시작하는 qty는 0이고 expt로 시작하는 qyt에 값을 넣음
						// 면제 사유가 존재하지 않으면 반대
						if (krWhfBlInfoVO.getWfgExptCd().equals("S") ||
							krWhfBlInfoVO.getWfgExptCd().equals("D") ||
							krWhfBlInfoVO.getWfgExptCd().equals("X") ||
							krWhfBlInfoVO.getWfgExptCd().equals("I") ||
							krWhfBlInfoVO.getWfgExptCd().equals("J") ||
							krWhfBlInfoVO.getWfgExptCd().equals("K")) {
							bkgKrWhfRtVO.setTaxTeuQty  ("0");
							bkgKrWhfRtVO.setTaxFeuQty  ("0");
							bkgKrWhfRtVO.setTax45ftQty ("0");

							bkgKrWhfRtVO.setExptTeuQty (krWhfBlInfoVO.getWhfCntr20ftQty());
							bkgKrWhfRtVO.setExptFeuQty (krWhfBlInfoVO.getWhfCntr40ftQty());
							bkgKrWhfRtVO.setExpt45ftQty(krWhfBlInfoVO.getWhfCntr45ftQty());
						}
						else {
							bkgKrWhfRtVO.setTaxTeuQty  (krWhfBlInfoVO.getWhfCntr20ftQty());
							bkgKrWhfRtVO.setTaxFeuQty  (krWhfBlInfoVO.getWhfCntr40ftQty());
							bkgKrWhfRtVO.setTax45ftQty (krWhfBlInfoVO.getWhfCntr45ftQty());

							bkgKrWhfRtVO.setExptTeuQty ("0");
							bkgKrWhfRtVO.setExptFeuQty ("0");
							bkgKrWhfRtVO.setExpt45ftQty("0");
						}


						bkgKrWhfRtVO.setCntrTeuQty (krWhfBlInfoVO.getWhfCntr20ftQty());
						bkgKrWhfRtVO.setCntrFeuQty (krWhfBlInfoVO.getWhfCntr40ftQty());
						bkgKrWhfRtVO.setCntr45ftQty(krWhfBlInfoVO.getWhfCntr45ftQty());

						/* 화면 상에 BKG 시리즈 */
						bkgKrWhfRtVO.setCntrTpszTeuQty (krWhfBlInfoVO.getWhfBkg20ftQty());
						bkgKrWhfRtVO.setCntrTpszFeuQty (krWhfBlInfoVO.getWhfBkg40ftQty());
						bkgKrWhfRtVO.setCntrTpsz45ftQty(krWhfBlInfoVO.getWhfBkg45ftQty());



						bkgKrWhfRtVO.setBlkTeuQty (krWhfBlInfoVO.getWhfBlk20ftQty());
						bkgKrWhfRtVO.setBlkFeuQty (krWhfBlInfoVO.getWhfBlk40ftQty());
						bkgKrWhfRtVO.setBlk45ftQty(krWhfBlInfoVO.getWhfBlk45ftQty());

						bkgKrWhfRtVO.setBbCgoWgt(krWhfBlInfoVO.getBlkWgtQty());
						bkgKrWhfRtVO.setBlkMeasQty(krWhfBlInfoVO.getBlkMeasQty());
//						bkgKrWhfRtVO.setBlkMeasQty(krWhfBlInfoVO.getMeasQty());

						bkgKrWhfRtVO.setKrCstmsFrtTpCd(krWhfBlInfoVO.getWhfPckTpCd());
						bkgKrWhfRtVO.setPortCd(krWhfVslInfoCondVO.getPortCd());
						bkgKrWhfRtVO.setUpdUsrId(account.getUsr_id());

						bkgKrWhfRtVO.setVslCd   ( sVvd.substring(0, 4) );
						bkgKrWhfRtVO.setSkdVoyNo( sVvd.substring(4, 8) );
						bkgKrWhfRtVO.setSkdDirCd( sVvd.substring(8, 9) );
//						bkgKrWhfRtVO.setWhfBndCd( krWhfVslInfoCondVO.getWhfBndCd() );
						bkgKrWhfRtVO.setWhfBndCd( krWhfBlInfoVO.getWhfBndCd() );
						bkgKrWhfRtVO.setBlNo    ( krWhfBlInfoVO.getBlNo() );
						bkgKrWhfRtVO.setChgRtSeq( chgRtSeq );

						bkgKrWhfRtVOs.add( bkgKrWhfRtVO );

						if( ! "D".equals(krWhfBlInfoVO.getIbflag())){
							dbDao.modifyBkgKrWhfRt(bkgKrWhfRtVOs);
							dbDao.modifyBkgKrWhfCntr(bkgKrWhfRtVOs);
						}else {
							dbDao.removeBkgKrWhfRt(bkgKrWhfRtVOs);
						}
					}
					else {
						/* TABLE VO에 값을 채움: BKG_KR_WHF_RT */
						/* 공통 KEY 값 */
						bkgKrWhfRtVO.setVslCd   ( sVvd.substring(0, 4) );
						bkgKrWhfRtVO.setSkdVoyNo( sVvd.substring(4, 8) );
						bkgKrWhfRtVO.setSkdDirCd( sVvd.substring(8, 9) );
						bkgKrWhfRtVO.setPortCd(krWhfVslInfoCondVO.getPortCd());
//						bkgKrWhfRtVO.setWhfBndCd( krWhfVslInfoCondVO.getWhfBndCd() );
						bkgKrWhfRtVO.setWhfBndCd( krWhfBlInfoVO.getWhfBndCd() );
						bkgKrWhfRtVO.setBlNo    ( krWhfBlInfoVO.getBlNo() );

						/* 공통으로 쓸 수 있는 값 */
						bkgKrWhfRtVO.setPortOfcCd(sPortOfcCd);
						bkgKrWhfRtVO.setUpdUsrId(account.getUsr_id());

						/* 이전 RT SEQ 값 지정 */
						bkgKrWhfRtVO.setChgRtSeq( chgRtSeq );

						bkgKrWhfRtVOs.add(bkgKrWhfRtVO);
						//dbDao.modifyBkgKrWhfRt2(bkgKrWhfRtVOs); 이전 seq에 ofc_cd를 업데이트 할 이유가 없는것으로 보임. 2010.05.31 ODH

						/* 새로운 RT SEQ 값 지정 */
						bkgKrWhfRtVO.setChgRtSeq(Integer.parseInt(chgRtSeq) + 1 + "");

						bkgKrWhfRtVO.setNewChgAmt(newChgAmt);
						bkgKrWhfRtVO.setOldChgAmt(oldChgAmt);
						bkgKrWhfRtVO.setDiffAmt ( diffAmt + "" );

						bkgKrWhfRtVO.setRtonWgt( krWhfBlInfoVO.getRtonWgt() );
						bkgKrWhfRtVO.setCntrWgt( krWhfBlInfoVO.getBlkWgtQty() );
						bkgKrWhfRtVO.setWgtUtCd( krWhfBlInfoVO.getWgtUtCd() );
						bkgKrWhfRtVO.setMeasQty( krWhfBlInfoVO.getMeasQty());
						bkgKrWhfRtVO.setMeasUtCd( krWhfBlInfoVO.getMeasUtCd() );
						bkgKrWhfRtVO.setCntrQty( "0" );
						bkgKrWhfRtVO.setKrWhfExptCd(krWhfBlInfoVO.getWfgExptCd());
						bkgKrWhfRtVO.setBlCustNm( krWhfBlInfoVO.getCustNm() );
						bkgKrWhfRtVO.setTaxCustNm("");

						bkgKrWhfRtVO.setCntrTeuQty (krWhfBlInfoVO.getWhfCntr20ftQty());
						bkgKrWhfRtVO.setCntrFeuQty (krWhfBlInfoVO.getWhfCntr40ftQty());
						bkgKrWhfRtVO.setCntr45ftQty(krWhfBlInfoVO.getWhfCntr45ftQty());

						bkgKrWhfRtVO.setCntrTpszTeuQty (krWhfBlInfoVO.getWhfBkg20ftQty());
						bkgKrWhfRtVO.setCntrTpszFeuQty (krWhfBlInfoVO.getWhfBkg40ftQty());
						bkgKrWhfRtVO.setCntrTpsz45ftQty(krWhfBlInfoVO.getWhfBkg45ftQty());

						// 면제 사유가 존재하면 tax로 시작하는 qty는 0이고 expt로 시작하는 qyt에 값을 넣음
						// 면제 사유가 존재하지 않으면 반대
						if (krWhfBlInfoVO.getWfgExptCd().equals("S") ||
							krWhfBlInfoVO.getWfgExptCd().equals("D") ||
							krWhfBlInfoVO.getWfgExptCd().equals("X") ||
							krWhfBlInfoVO.getWfgExptCd().equals("I") ||
							krWhfBlInfoVO.getWfgExptCd().equals("J") ||
							krWhfBlInfoVO.getWfgExptCd().equals("K")) {
							bkgKrWhfRtVO.setTaxTeuQty  ("0");
							bkgKrWhfRtVO.setTaxFeuQty  ("0");
							bkgKrWhfRtVO.setTax45ftQty ("0");

							bkgKrWhfRtVO.setExptTeuQty (krWhfBlInfoVO.getWhfCntr20ftQty());
							bkgKrWhfRtVO.setExptFeuQty (krWhfBlInfoVO.getWhfCntr40ftQty());
							bkgKrWhfRtVO.setExpt45ftQty(krWhfBlInfoVO.getWhfCntr45ftQty());
						}
						else {
							bkgKrWhfRtVO.setTaxTeuQty  (krWhfBlInfoVO.getWhfCntr20ftQty());
							bkgKrWhfRtVO.setTaxFeuQty  (krWhfBlInfoVO.getWhfCntr40ftQty());
							bkgKrWhfRtVO.setTax45ftQty (krWhfBlInfoVO.getWhfCntr45ftQty());

							bkgKrWhfRtVO.setExptTeuQty ("0");
							bkgKrWhfRtVO.setExptFeuQty ("0");
							bkgKrWhfRtVO.setExpt45ftQty("0");
						}

						bkgKrWhfRtVO.setBlkTeuQty (krWhfBlInfoVO.getWhfBlk20ftQty());
						bkgKrWhfRtVO.setBlkFeuQty (krWhfBlInfoVO.getWhfBlk40ftQty());
						bkgKrWhfRtVO.setBlk45ftQty(krWhfBlInfoVO.getWhfBlk45ftQty());
						bkgKrWhfRtVO.setBbCgoWgt(krWhfBlInfoVO.getBlkWgtQty());
						bkgKrWhfRtVO.setBlkMeasQty(krWhfBlInfoVO.getBlkMeasQty());
//						bkgKrWhfRtVO.setBlkMeasQty(krWhfBlInfoVO.getMeasQty());

						bkgKrWhfRtVO.setKrCstmsFrtTpCd(krWhfBlInfoVO.getWhfPckTpCd());

						bkgKrWhfRtVO.setCreUsrId(account.getUsr_id());

						bkgKrWhfRtVOs2.add(bkgKrWhfRtVO);
						if( ! "D".equals(krWhfBlInfoVO.getIbflag())){
							dbDao.addBkgKrWhfRt(bkgKrWhfRtVOs2);
						}else{
							dbDao.removeBkgKrWhfRt(bkgKrWhfRtVOs2);
						}
					}
				}
				dbDao.modifyBkgKrWhfBl( bkgKrWhfBlVOs );
			}
			else
			{
				throw new EventException(new ErrorHandler("BKG06103", new String[] {}).getMessage());
			}
		}

		}catch (EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}



	/**
	 * BKG와 WHF 정보 관리
	 *
	 * @param WhfBlVO[] whfBlVOs WHF BL 정보
	 * @param SignOnUserAccount account 세션정보
	 * @throws EventException
	 */
	@Override
	public void manageWhfBkg(WhfBlVO[] whfBlVOs, SignOnUserAccount account) throws EventException {

		try {
//			List<KrWhfBkgChkListCondVO> checklist = null;
			List<KrWhfBkgChkListCondVO> ilist = new ArrayList<KrWhfBkgChkListCondVO>();
			List<KrWhfBkgChkListCondVO> dlist = new ArrayList<KrWhfBkgChkListCondVO>();
			KrWhfBkgChkListCondVO krWhfBkgChkListCondVO = null;

			KrBlCondVO krBlCondVO = null;

			KrWhfBkgInfoCondVO krWhfBkgInfoCondVO = null;
			KrWhfBkgKrWhfBlVO[] krWhfBkgKrWhfBlVOs = null;
			BkgKrWhfCustVO[] bkgKrWhfCustVOs = null;
			BkgKrWhfCntrVO[] bkgKrWhfCntrVOs = null;
			KrWhfVslInfoCondVO krWhfVslInfoCondVO = null;

			KrBlVO krBlVO = null;
			KrCustVO[] krCustVOs = null;
			KrCntrVO[] krCntrVOs = null;

			KrWhfBlContainerVO krWhfBlContainerVO = (KrWhfBlContainerVO)whfBlVOs[0];
			krWhfVslInfoCondVO = krWhfBlContainerVO.getKrWhfVslInfoCondVO();
			BkgKrWhfVolVO bkgKrWhfVolVO           = krWhfBlContainerVO.getBkgKrWhfVolVO();
			KrWhfBkgChkListCondVO[] krWhfBkgChkListCondVOs = krWhfBlContainerVO.getKrWhfBkgChkListCondVOs();


			for (int i = 0; i < krWhfBkgChkListCondVOs.length; i++) {

				krWhfBkgChkListCondVO = krWhfBkgChkListCondVOs[i];

				if(i != 0) {
					krWhfBkgChkListCondVO.setVvd(krWhfBkgChkListCondVOs[0].getVvd());
					krWhfBkgChkListCondVO.setPortCd(krWhfBkgChkListCondVOs[0].getPortCd());
					krWhfBkgChkListCondVO.setWhfBndCd(krWhfBkgChkListCondVOs[0].getWhfBndCd());

				}

//				ObjectCloner.build(whfBkgChkListCondVO, krWhfBkgChkListCondVO);
				krWhfBkgChkListCondVO.setCreUsrId( account.getUsr_id() );
				krWhfBkgChkListCondVO.setUpdUsrId( account.getUsr_id() );

				if( "B".equals( krWhfBkgChkListCondVO.getDiff() ) )
					ilist.add( krWhfBkgChkListCondVO );
				else if( "W".equals( krWhfBkgChkListCondVO.getDiff() ) ){
					dlist.add( krWhfBkgChkListCondVO );

				}
			}

            //중복 체크
//			if( dlist.size() > 0 ) dbDao.removeBkgKrWhfPortRt(dlist);

			if(ilist.size() > 0){
				// BKG 정보 WHF SAVE
				KrWhfBkgChkListCondVO[] krWhfBkgChkListCondVOs2 = new KrWhfBkgChkListCondVO[ilist.size()];
				ilist.toArray(krWhfBkgChkListCondVOs2);

				for(int i = 0; i < krWhfBkgChkListCondVOs2.length; i++){

				krBlCondVO = new KrBlCondVO();
				ObjectCloner.build(krWhfBkgChkListCondVOs2[i], krBlCondVO);
				krBlCondVO.setWhfBndCd(krWhfBkgChkListCondVOs2[i].getCstmsDeclTpCd());

				KrBlContainerVO krBlContainerVO = (KrBlContainerVO)searchBl(krBlCondVO);

				krBlVO = krBlContainerVO.getKrBlVO();
				List <KrCustVO> krCustVOss = krBlContainerVO.getKrCustVOs();
				List <KrCntrVO> krCntrVOss = krBlContainerVO.getKrCntrVOs();

				krCustVOs = new KrCustVO[krCustVOss.size()];
				krCntrVOs = new KrCntrVO[krCntrVOss.size()];

				krCustVOss.toArray(krCustVOs);
				krCntrVOss.toArray(krCntrVOs);

				krWhfBkgKrWhfBlVOs = new KrWhfBkgKrWhfBlVO[1];

				KrWhfBkgKrWhfBlVO blVo ;
				BkgKrWhfCustVO custVo ;
				BkgKrWhfCntrVO cntrVo ;

				bkgKrWhfCustVOs = new BkgKrWhfCustVO[krCustVOs.length];
				bkgKrWhfCntrVOs = new BkgKrWhfCntrVO[krCntrVOs.length];

				for(int p = 0; p < krWhfBkgKrWhfBlVOs.length; p++){
					blVo = new KrWhfBkgKrWhfBlVO();
					ObjectCloner.build(krBlVO, blVo);
					krWhfBkgKrWhfBlVOs[p] = blVo;
					krWhfBkgKrWhfBlVOs[p].setPortCd(krWhfBkgChkListCondVOs[0].getPortCd());
//					krWhfBkgKrWhfBlVOs[p].setWhfBndCd(krWhfBkgChkListCondVOs[0].getCstmsDeclTpCd());
				}

				for(int n= 0; n < krCustVOs.length; n++){
					custVo = new BkgKrWhfCustVO();
					ObjectCloner.build(krCustVOs[n], custVo);
					bkgKrWhfCustVOs[n] = custVo;
				}

				for( int m = 0; m < krCntrVOs.length; m++){

					cntrVo = new BkgKrWhfCntrVO();
					ObjectCloner.build(krCntrVOs[m], cntrVo);
					bkgKrWhfCntrVOs[m] = cntrVo;
				}

				if(bkgKrWhfCustVOs != null){
					for(int j= 0 ; j < bkgKrWhfCustVOs.length ; j++)
						{
							bkgKrWhfCustVOs[j].setIbflag("I");
						}
				}

				if(bkgKrWhfCntrVOs != null){
					for(int k= 0 ; k < bkgKrWhfCntrVOs.length ; k++)
						{
							bkgKrWhfCntrVOs[k].setIbflag("I");
						}
				}

				KrWhfBlContainerVO[] krWhfBlContainerVOs1 = new KrWhfBlContainerVO[1];
				KrWhfBlContainerVO krWhfBlContainerVO1 = new KrWhfBlContainerVO();

				krWhfBkgInfoCondVO = new KrWhfBkgInfoCondVO();
				if(krBlVO.getAmount() == null || krBlVO.getAmount().equals("")) krBlVO.setAmount("0");
				krWhfBkgInfoCondVO.setAmount(krBlVO.getAmount());
				krWhfBkgInfoCondVO.setBkgNo(krBlVO.getBkgNo());
				krWhfBkgInfoCondVO.setWhfBndCd(krBlVO.getWhfBndCd());
				krWhfBkgInfoCondVO.setPortCd(krWhfVslInfoCondVO.getPortCd());


				krWhfBlContainerVO1.setKrWhfBkgInfoCondVO(krWhfBkgInfoCondVO);
				krWhfBlContainerVO1.setKrWhfBkgKrWhfBlVOs(krWhfBkgKrWhfBlVOs);
				krWhfBlContainerVO1.setBkgKrWhfCustVOs(bkgKrWhfCustVOs);
				krWhfBlContainerVO1.setBkgKrWhfCntrVOs(bkgKrWhfCntrVOs);
				krWhfBlContainerVO1.setKrWhfVslInfoCondVO(krWhfVslInfoCondVO);

				krWhfBlContainerVOs1[0] = krWhfBlContainerVO1;
				manageWhfBl(krWhfBlContainerVOs1, account);

				}
			}

			if(dlist.size() > 0){

				//기존 save 로직 call
				List<KrWhfBlInfoVO> krWhfBlInfoVOs = dbDao.searchKrWhfCgoClass2(dlist);

				KrWhfBlInfoVO[]  krWhfBlInfoVOss = new KrWhfBlInfoVO[krWhfBlInfoVOs.size()];
				krWhfBlInfoVOs.toArray(krWhfBlInfoVOss);

				for(int i = 0; i < krWhfBlInfoVOss.length; i++){

					krWhfBlInfoVOss[i].setIbflag("D");
					krWhfVslInfoCondVO.setWhfBndCd(krWhfBlInfoVOss[i].getWhfBndCd());
					bkgKrWhfVolVO.setWhfBndCd(krWhfBlInfoVOss[i].getWhfBndCd());

					KrWhfBlContainerVO[] krWhfBlContainerVOs2 = new KrWhfBlContainerVO[1];
					KrWhfBlContainerVO krWhfBlContainerVO2 = new KrWhfBlContainerVO();

					KrWhfBlInfoVO[]  krWhfBlInfoVOss2 = new KrWhfBlInfoVO[1];
					krWhfBlInfoVOss2[0] = krWhfBlInfoVOss[i];

					krWhfBlContainerVO2.setSvcGubunId("EsmBkg0122Event");
					krWhfBlContainerVO2.setBkgKrWhfVolVO(bkgKrWhfVolVO);
					krWhfBlContainerVO2.setKrWhfBlInfoVOs(krWhfBlInfoVOss2);
					krWhfBlContainerVO2.setKrWhfVslInfoCondVO(krWhfVslInfoCondVO);
					krWhfBlContainerVOs2[0] = krWhfBlContainerVO2;
	//
	//				command.manageWhfBl(krWhfBlContainerVOs, account);
					manageWhfBl(krWhfBlContainerVOs2, account);
				}
			}
			}catch(DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
			}

	}



	/**
	 * BL 및(또는) 한국 세관 테이블로 부터 한국 WHF 신고 대상 BL 목록을 한국 WHF 관리 테이블로 다운로드 받음
	 *
	 * @param WhfBlVO[] whfBlVOs BL정보
	 * @param SignOnUserAccount account 세션정보
	 * @throws EventException
	 */
	@Override
	public void downloadWhfBlList(WhfBlVO[] whfBlVOs, SignOnUserAccount account) throws EventException {
		try {

			if( whfBlVOs != null ){

				KrWhfBlContainerVO krWhfBlContainerVO = (KrWhfBlContainerVO)whfBlVOs[0];
				KrWhfBkgKrWhfBlVO krWhfBkgKrWhfBlVO = krWhfBlContainerVO.getKrWhfBkgKrWhfBlVO();
				List<KrWhfBkgKrWhfBlVO> list = new ArrayList<KrWhfBkgKrWhfBlVO>();

				String sVvd   = krWhfBkgKrWhfBlVO.getVvd();
				String sVslCd = sVvd.substring(0, 4);
				String sSkdVoyNo = sVvd.substring(4, 8);
				String sSkdDirCd = sVvd.substring(8, sVvd.length() );

				krWhfBkgKrWhfBlVO.setVslCd(sVslCd);
				krWhfBkgKrWhfBlVO.setSkdVoyNo(sSkdVoyNo);
				krWhfBkgKrWhfBlVO.setSkdDirCd(sSkdDirCd);

				krWhfBkgKrWhfBlVO.setCreUsrId(account.getUsr_id());
				krWhfBkgKrWhfBlVO.setUpdUsrId(account.getUsr_id());
				list.add( krWhfBkgKrWhfBlVO );
				dbDao.mergeSearchBkgKrWhfBl(list);

				BkgKrWhfCustVO bkgKrWhfCustVO = krWhfBlContainerVO.getBkgKrWhfCustVO();
				List<BkgKrWhfCustVO> bkgKrWhfCustVOs = new ArrayList<BkgKrWhfCustVO>();

				bkgKrWhfCustVO.setVslCd(sVslCd);
				bkgKrWhfCustVO.setSkdVoyNo(sSkdVoyNo);
				bkgKrWhfCustVO.setSkdDirCd(sSkdDirCd);
				bkgKrWhfCustVO.setFaxNo( krWhfBkgKrWhfBlVO.getBkgNo() );
				bkgKrWhfCustVO.setCreUsrId(account.getUsr_id());
				bkgKrWhfCustVO.setUpdUsrId(account.getUsr_id());

				bkgKrWhfCustVOs.add(bkgKrWhfCustVO);
				if( bkgKrWhfCustVOs.size() > 0 ) {

					dbDao.removeBkgKrWhfCust(bkgKrWhfCustVOs);
					dbDao.addSearchBkgKrWhfCust(bkgKrWhfCustVOs);
				}

				BkgKrWhfCntrVO bkgKrWhfCntrVO  = krWhfBlContainerVO.getBkgKrWhfCntrVO();
				List<BkgKrWhfCntrVO> bkgKrWhfCntrVOs = new ArrayList<BkgKrWhfCntrVO>();
				bkgKrWhfCntrVO.setVslCd(sVslCd);
				bkgKrWhfCntrVO.setSkdVoyNo(sSkdVoyNo);
				bkgKrWhfCntrVO.setSkdDirCd(sSkdDirCd);
				bkgKrWhfCntrVO.setCntrNo( krWhfBkgKrWhfBlVO.getBkgNo() );
				bkgKrWhfCntrVO.setCreUsrId(account.getUsr_id());
				bkgKrWhfCntrVO.setUpdUsrId(account.getUsr_id());
				bkgKrWhfCntrVOs.add(bkgKrWhfCntrVO);
				if( bkgKrWhfCntrVOs.size() > 0 ) {
					dbDao.removeBkgKrWhfCntr(bkgKrWhfCntrVOs);
					dbDao.addSearchBkgKrWhfCntr(bkgKrWhfCntrVOs);
				}

			}
		}catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}


	/**
	 * WHF 신고 현황 조회
	 *
	 * @param WhfDecChkListCondVO whfDecChkListCondVO 조회조건
	 * @return List<WhfDecChkVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfDecChkVO> searchWhfDecChkList(WhfDecChkListCondVO whfDecChkListCondVO) throws EventException {
		try {

			return dbDao.searchKrWhfDecChkList( (KrWhfDecChkListCondVO)whfDecChkListCondVO )  ;

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}


	/**
	 * 화물입항료 대납경비 청구서 조회
	 *
	 * @param WhfCommInvListCondVO whfCommInvListCondVO 조회조건
	 * @return List<WhfCommInvListVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfCommInvListVO> searchWhfCommInvList(WhfCommInvListCondVO whfCommInvListCondVO) throws EventException {
		try {

			KrWhfCommInvListCondVO krWhfCommInvListCondVO = (KrWhfCommInvListCondVO)whfCommInvListCondVO;
			krWhfCommInvListCondVO.setWhfNtcDt1( krWhfCommInvListCondVO.getWhfNtcDt1().replaceAll("-", "") );
			krWhfCommInvListCondVO.setWhfNtcDt2( krWhfCommInvListCondVO.getWhfNtcDt2().replaceAll("-", "") );

			return dbDao.searchKrWhfCommInvList( (KrWhfCommInvListCondVO)whfCommInvListCondVO )  ;

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * Wharfage 신고 물량 정보 업데이트
	 *
	 * @param WhfCommInvVO[] whfCommInvVOs Wharfage 신고 물량 정보
	 * @param SignOnUserAccount account 세션정보
	 * @throws EventException
	 */
	@Override
	public void manageWhfCommInv(WhfCommInvVO[] whfCommInvVOs, SignOnUserAccount account) throws EventException {
		try {

			/*
			 * 사용되지 않은 메서드. 구현이 되어 있지 않음
			 */
			List<BkgKrWhfVolVO> bkgKrWhfVolVOs = new ArrayList<BkgKrWhfVolVO>();
			dbDao.modifyBkgKrWhfVol(bkgKrWhfVolVOs);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}

	}


	/**
	 * 한국 WHF 신고 대상 BL을 분류 함 (면제 대상 등)
	 *
	 * @param WhfVslInfoCondVO whfVslInfoCondVO 조회조건
	 * @return List<WhfVslInfoVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfVslInfoVO> searchWhfMrnSailDt(WhfVslInfoCondVO whfVslInfoCondVO) throws EventException {
		try {

			return dbDao.searchKrWhfMrnSailDt( (KrWhfVslInfoCondVO)whfVslInfoCondVO )  ;

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * 한국 WHF 신고 대상 BL을 분류 함 (면제 대상 등)
	 *
	 * @param WhfCgoClassCondVO whfCgoClassCondVO 조회조건
	 * @return List<WhfBlInfoVO>
	 * @throws EventException
	 */
	@Override
	public List<WhfBlInfoVO> searchWhfCgoClass(WhfCgoClassCondVO whfCgoClassCondVO) throws EventException {
		try {

			KrWhfPortRtListCondVO krWhfPortRtListCondVO = new KrWhfPortRtListCondVO();

			ObjectCloner.build(whfCgoClassCondVO, krWhfPortRtListCondVO);

			List<KrWhfAplyPortRtVO> krWhfAplyPortRtVOs = dbDao.searchKrWhfAplyPortRt( krWhfPortRtListCondVO )  ;

			String sKrWhfBlkRt = "0" ;
			if( krWhfAplyPortRtVOs.size() > 0 ){
				sKrWhfBlkRt = krWhfAplyPortRtVOs.get(0).getKrWhfBlkRt();
				if( "".equals(sKrWhfBlkRt) ) sKrWhfBlkRt = "0" ;
			}
			List<KrWhfBlInfoVO> krWhfBlInfoVOs = dbDao.searchKrWhfCgoClass( (KrWhfCgoClassCondVO)whfCgoClassCondVO )  ;

			/*
			 "[CNTR Bulk Qty 20' > 0 OR CNTR Bulk Qty 40' > 0 OR CNTR Bulk Qty 45' > 0] {
			     [CNTR Bulk Weight * 0.999 < CNTR Bulk Measure * 0.883 + 0.999] {
			        ""E""
			     } ELSE {
			       ""W""
			     }
			  }"
			 */
			/*
			   "[Bulk Rton Appl Type = ""E""] {
				     CNTR Bulk Measure
				}
				[Bulk Rton Appl Type = ""W""] {
				     CNTR Bulk Weight
				}"
			 */
			List<KrWhfBlInfoVO> krWhfBlInfoVOs2 = new ArrayList<KrWhfBlInfoVO>();
			for (Iterator<KrWhfBlInfoVO> iterator = krWhfBlInfoVOs.iterator(); iterator.hasNext();) {
				KrWhfBlInfoVO krWhfBlInfoVO = iterator.next();

				// Null Exception 을 피하기 위해 초기 값을 setting 해 줌
				if (krWhfBlInfoVO.getRtonWgt() == null) krWhfBlInfoVO.setRtonWgt("0");

//				if (    Float.parseFloat( krWhfBlInfoVO.getWhfCntr20ftQty() ) > 0
//					 ||	Float.parseFloat( krWhfBlInfoVO.getWhfCntr40ftQty() ) > 0
//					 ||	Float.parseFloat( krWhfBlInfoVO.getWhfCntr45ftQty() ) > 0 ){
				if( "BLK".equals(krWhfBlInfoVO.getWhfPckTpCd()) ){
//					if( Float.parseFloat( krWhfBlInfoVO.getBlkWgtQty() ) * 0.999  <  ( Float.parseFloat( krWhfBlInfoVO.getBlkMeasQty() ) * 0.888) + 0.999 ) {
//					if( Float.parseFloat( krWhfBlInfoVO.getBlkWgtQty() )  <  ( Float.parseFloat( krWhfBlInfoVO.getBlkMeasQty() ))) {
//						krWhfBlInfoVO.setBulkRtonApplType("E");
//						krWhfBlInfoVO.setRtonWgt(krWhfBlInfoVO.getBlkMeasQty());
//					} else {
//						krWhfBlInfoVO.setBulkRtonApplType("W");
//						krWhfBlInfoVO.setRtonWgt(krWhfBlInfoVO.getBlkWgtQty());
//					}
				}
				/*
			   "[Grid_1에 T <> ""E"" AND
				 Grid_1에 T <> ""R""] {
				   Bulk Rton * Unit_Rate_Form.Bulk Rate
				}"
				 */

//				if( ( krWhfBlInfoVO.getT() != "E") && ( krWhfBlInfoVO.getT() != "R" ) ){
//					krWhfBlInfoVO.setBulkWharfageAmount( String.valueOf( Float.parseFloat(krWhfBlInfoVO.getBulkRton()) * Float.parseFloat( sKrWhfBlkRt ) ) );
//				}else{
//					krWhfBlInfoVO.setBulkWharfageAmount( "0" );
//				}
				krWhfBlInfoVO.setBulkWharfageAmount( String.valueOf( Float.parseFloat(krWhfBlInfoVO.getRtonWgt()) * Float.parseFloat( sKrWhfBlkRt ) ) );
				krWhfBlInfoVOs2.add(krWhfBlInfoVO);
			}

			/*
			 * 화면 그리드에서 F 에 해당하는 값을 하드코딩 테이블에서 가져온다.
			 */
			BookingUtil bkgUtil = new BookingUtil();
			BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
    		hrdCdgVO.setHrdCdgId("KR_WHF_EXEMPT_CD");
    		//hrdCdgVO.setAttrCtnt1( krWhfDecCondVO.getPortCd() );
    		List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = bkgUtil.searchHardCoding(hrdCdgVO);
//    		String sName = "";
//    		String sValue  = "";
//    		for (Iterator<BkgHrdCdgCtntVO> iterator = bkgHrdCdgCtntVOs.iterator(); iterator.hasNext();) {
//				BkgHrdCdgCtntVO bkgHrdCdgCtntVO = iterator.next();
//				sName = bkgHrdCdgCtntVO.getAttrCtnt5();
//				sValue  = bkgHrdCdgCtntVO.getAttrCtnt1();
//			}

			KrWhfBlInfoContainerVO krWhfBlInfoContainerVO = new KrWhfBlInfoContainerVO();
			krWhfBlInfoContainerVO.setKrWhfBlInfoVOs(krWhfBlInfoVOs2);
			krWhfBlInfoContainerVO.setKrWhfAplyPortRtVOs(krWhfAplyPortRtVOs);
			krWhfBlInfoContainerVO.setBkgHrdCdgCtntVOs(bkgHrdCdgCtntVOs);

			List<WhfBlInfoVO> whfBlInfoVOs = new ArrayList<WhfBlInfoVO>();
			WhfBlInfoVO whfBlInfoVO = (WhfBlInfoVO)krWhfBlInfoContainerVO;
			whfBlInfoVOs.add(whfBlInfoVO);

			return whfBlInfoVOs ;

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * B/L 별 Wharfage 면제 정보 (면제 사유 등) 조회
	 *
	 * @param WhfExemptInfoCondVO whfExemptInfoCondVO 조회조건
	 * @return WhfExemptInfoVO
	 * @throws EventException
	 */
	@Override
	public WhfExemptInfoVO searchWhfExemptInfo(WhfExemptInfoCondVO whfExemptInfoCondVO) throws EventException {

		try {
			KrWhfBlExpInfoVO  krWhfBlExpInfoVO           = dbDao.searchKrWhfBlInfo( (KrWhfExemptInfoCondVO)whfExemptInfoCondVO );
			List<KrWhfBlExptInfoVO> krWhfBlExptInfoVOs   = dbDao.searchKrWhfBlExptInfo((KrWhfExemptInfoCondVO)whfExemptInfoCondVO);
			List<KrWhfCntrExpInfoVO> krWhfCntrExpInfoVOs = dbDao.searchKrWhfCntrExpInfo( (KrWhfExemptInfoCondVO)whfExemptInfoCondVO );

			KrWhfExemptInfoContainerVO krWhfExemptInfoContainerVO = new KrWhfExemptInfoContainerVO();
			krWhfExemptInfoContainerVO.setKrWhfBlExpInfoVO(krWhfBlExpInfoVO);
			krWhfExemptInfoContainerVO.setKrWhfBlExptInfoVOs(krWhfBlExptInfoVOs);
			krWhfExemptInfoContainerVO.setKrWhfCntrExpInfoVOs(krWhfCntrExpInfoVOs);

			return krWhfExemptInfoContainerVO;

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}

	}

	/**
	 /**
	 * Wharfage 신고 대상 조회
	 *
	 * @param WhfDecCondVO whfDecCondVO 조회조건
	 * @return WhfDecVO
	 * @throws EventException
	 */
	@Override
	public WhfDecVO searchWhfDec(WhfDecCondVO whfDecCondVO) throws EventException {
		try {
			List<KrWhfVvdDtlVO> krWhfVvdDtlVOs = null ;
			KrWhfDecContainerVO krWhfDecContainerVO = new KrWhfDecContainerVO();

			/*
			 * 그리드 1 데이터
			 */
			KrWhfDecCondVO krWhfDecCondVO = ( KrWhfDecCondVO )whfDecCondVO;
			krWhfVvdDtlVOs = dbDao.searchKrWhfVvdDtlSavedList( krWhfDecCondVO );
			if( krWhfVvdDtlVOs.size() == 0 ){
				krWhfVvdDtlVOs = dbDao.searchKrWhfVvdDtlInitialList( krWhfDecCondVO );
			}

			if( krWhfVvdDtlVOs.size() == 0 )
				return krWhfDecContainerVO ;

			krWhfDecContainerVO.setKrWhfVvdDtlVOs(krWhfVvdDtlVOs);

			/*
			 * 폼 데이터
			 */
			BkgKrWhfVolVO bkgKrWhfVolVO = dbDao.searchKrWhfVol(krWhfDecCondVO);
			if( bkgKrWhfVolVO == null )
				return krWhfDecContainerVO ;

			String sWhfBndCd = krWhfDecCondVO.getWhfBndCd();
			String sWhfRtAmt = dbDao.searchKrWhfTtlAmt(krWhfDecCondVO);
			if( "OO".equals(sWhfBndCd) || "II".equals(sWhfBndCd) || "IN".equals(sWhfBndCd) || "ON".equals(sWhfBndCd) || "OT".equals(sWhfBndCd)){
				bkgKrWhfVolVO.setWhfRtAmt( sWhfRtAmt );
			}
			krWhfDecContainerVO.setBkgKrWhfVolVO(bkgKrWhfVolVO);

			KrWhfDecVO krWhfDecVO = dbDao.searchKrWhfDec(krWhfDecCondVO);
			String sDeclNoYr = "";
			if( krWhfDecVO == null ){
				sDeclNoYr = dbDao.searchYearAsYyyy(krWhfDecCondVO);
				krWhfDecVO = new KrWhfDecVO();
				krWhfDecVO.setWhfNtcNoYr(sDeclNoYr);
			}
			krWhfDecContainerVO.setKrWhfDecVO(krWhfDecVO);

			/*
			 * 그리드 2 데이터
			 */
			List<KrWhfDecExptVolVO> krWhfDecExptVolVOs = dbDao.searchKrWhfDecExptVolList(krWhfDecCondVO);

			String sRepoMt = "0";
			String sMtQty  = "0";
			String sBlkQty = "0";

			for (Iterator<KrWhfDecExptVolVO> iterator = krWhfDecExptVolVOs.iterator(); iterator.hasNext();) {
				KrWhfDecExptVolVO krWhfDecExptVolVO = iterator.next();

				sMtQty  = dbDao.searchKrWhfDecExptMtCntrVol(krWhfDecCondVO, krWhfDecExptVolVO.getSizeId());
				sBlkQty = dbDao.searchKrWhfDecExptBlkVol(krWhfDecCondVO, krWhfDecExptVolVO.getSizeId());
				if( sMtQty != "" || sBlkQty != "" )

				krWhfDecExptVolVO.setMtQty ( sMtQty );
				krWhfDecExptVolVO.setBlkQty( sBlkQty );

				if( sMtQty != "" && sBlkQty != ""){
					sRepoMt = Float.toString( Float.parseFloat( sMtQty ) + Float.parseFloat(sBlkQty) );
					krWhfDecExptVolVO.setRepoMt(sRepoMt);

					krWhfDecExptVolVO.setTsTotal(Float.toString((Float.parseFloat(krWhfDecExptVolVO.getThruTsQty()) + Float.parseFloat(krWhfDecExptVolVO.getCustTsQty()) ))) ;
					krWhfDecExptVolVO.setMtyTotal(Float.toString( Float.parseFloat(krWhfDecExptVolVO.getRevMtQty()) + Float.parseFloat(sRepoMt)));
					krWhfDecExptVolVO.setExemptTotal(  Float.toString((Float.parseFloat(krWhfDecExptVolVO.getHyoSungQty())
											                         + Float.parseFloat(krWhfDecExptVolVO.getDaeWooQty())
											                         + Float.parseFloat(krWhfDecExptVolVO.getDongBuQty())
											                         + Float.parseFloat(krWhfDecExptVolVO.getHyunDaiQty())
											                         + Float.parseFloat(krWhfDecExptVolVO.getDongKukQty())

													))) ;
			}

			}
			krWhfDecContainerVO.setKrWhfDecExptVolVOs(krWhfDecExptVolVOs);

			KrWhfPortRtVO krWhfPortRtVO  = dbDao.searchKrWhfCntrPortRt( krWhfDecCondVO.getPortCd(), krWhfDecCondVO.getWhfBndCd(), bkgKrWhfVolVO.getWhfVolDcCd(), krWhfDecCondVO.getVvd()  );
			KrWhfPortRtVO krWhfPortRtVO2 = dbDao.searchKrWhfBlkPortRt( krWhfDecCondVO.getPortCd(), krWhfDecCondVO.getWhfBndCd(), bkgKrWhfVolVO.getWhfVolDcCd(), krWhfDecCondVO.getVvd() );
			krWhfDecContainerVO.setCntr_KrWhfPortRtVO(krWhfPortRtVO);
			krWhfDecContainerVO.setBlk_KrWhfPortRtVO(krWhfPortRtVO2);

			return krWhfDecContainerVO;

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}


	/**
	 * Wharfage 신고
	 *
	 * @param whfDecVO Wharfage 신고
	 * @param SignOnUserAccount account 세션정보
	 * @throws EventException
	 */
	@Override
	public void manageWhfDec(WhfDecVO whfDecVO, SignOnUserAccount account) throws EventException {
		try {
			KrWhfDecContainerVO krWhfDecContainerVO = (KrWhfDecContainerVO)whfDecVO;
			BkgKrWhfVolVO  bkgKrWhfVolVO   = krWhfDecContainerVO.getBkgKrWhfVolVO();
			KrWhfDecVO     krWhfDecVO      = krWhfDecContainerVO.getKrWhfDecVO();
			KrWhfDecCondVO krWhfDecCondVO  = krWhfDecContainerVO.getKrWhfDecCondVO();
			KrWhfVvdDtlVO[] krWhfVvdDtlVOs = krWhfDecContainerVO.getKrWhfVvdDtlVOs2();
			String sVvd      = krWhfDecCondVO.getVvd();
			String sNtcNo    = krWhfDecVO.getWhfNtcNoYr() + krWhfDecVO.getWhfNtcNoMon() + krWhfDecVO.getWhfNtcNoSeq();
			String sWhfBndCd = krWhfDecCondVO.getWhfBndCd();

			/*
			 * 공지번호(whfNtcNo)가 12자리가 아니면 "" (Empty String)으로 바꿈
			 */
			if( sNtcNo.length() != 12 )
				sNtcNo = "";

			int iKrWhfDecKnt = dbDao.searchKrWhfDecKnt( krWhfDecCondVO );
			if( iKrWhfDecKnt != 0 ){
				bkgKrWhfVolVO.setVslCd   (sVvd.substring(0, 4));
				bkgKrWhfVolVO.setSkdVoyNo(sVvd.substring(4, 8));
				bkgKrWhfVolVO.setSkdDirCd(sVvd.substring(8, 9));
				bkgKrWhfVolVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyBkgKrWhfVolWhfCustKndSave(bkgKrWhfVolVO);
				//commit();
//				throw new EventException(new ErrorHandler("BKG06103").getMessage());
				krWhfDecContainerVO.setErrMsg("BKG06103");
				return;
			}

			/*
			 * 복수화주(C)이면서 면제화주가 아닌 distinct한 사업자 등록번호가 1이하거나
             * 단수 화주(U)이면서 면제화주가 아닌 distinct한 사업자 등록번호가 1 초과이면 에러
			 */
			String sCustKndCd = bkgKrWhfVolVO.getWhfCustKndCd();
			if( !"IN".equals( sWhfBndCd ) ){
				int iDistinctKnt = dbDao.searchKrWhfNoExptCustRgstNoDistinctKnt( krWhfDecCondVO );
				if( ("C".equals(sCustKndCd) && iDistinctKnt<=1) || ( "U".equals(sCustKndCd) && iDistinctKnt>1 ) ){
					throw new EventException(new ErrorHandler("BKG06047").getMessage());
				}
				bkgKrWhfVolVO.setVslCd   (sVvd.substring(0, 4));
				bkgKrWhfVolVO.setSkdVoyNo(sVvd.substring(4, 8));
				bkgKrWhfVolVO.setSkdDirCd(sVvd.substring(8, 9));
				bkgKrWhfVolVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyBkgKrWhfVolWhfDecSave(bkgKrWhfVolVO);
			}

			// 아래의 for 문은 add 할때 복수 VO 를 넘기기 때문에 없어도 될거 같음
			List<BkgKrWhfVvdDtlVO> addlist             = new ArrayList<BkgKrWhfVvdDtlVO>();
			List<BkgKrWhfVvdDtlVO> bkgKrWhfVvdDtlVOs = new ArrayList<BkgKrWhfVvdDtlVO>();
			if( krWhfVvdDtlVOs != null ) {
				for (int i=0; i<krWhfVvdDtlVOs.length; i++) {

					KrWhfVvdDtlVO krWhfVvdDtlVO = (KrWhfVvdDtlVO) krWhfVvdDtlVOs[i];
					BkgKrWhfVvdDtlVO bkgKrWhfVvdDtlVO = new BkgKrWhfVvdDtlVO();
					ObjectCloner.build(krWhfVvdDtlVO, bkgKrWhfVvdDtlVO);
					bkgKrWhfVvdDtlVO.setVslCd( sVvd.substring(0, 4) );
					bkgKrWhfVvdDtlVO.setSkdVoyNo(sVvd.substring(4, 8));
					bkgKrWhfVvdDtlVO.setSkdDirCd(sVvd.substring(8, 9));
					bkgKrWhfVvdDtlVO.setPortCd(krWhfDecCondVO.getPortCd());
					bkgKrWhfVvdDtlVO.setWhfBndCd(krWhfDecCondVO.getWhfBndCd());
					bkgKrWhfVvdDtlVO.setCreUsrId(account.getUsr_id());
					bkgKrWhfVvdDtlVO.setUpdUsrId(account.getUsr_id());

					if( "I".equals( bkgKrWhfVvdDtlVO.getIbflag() ) ){
						addlist.add( bkgKrWhfVvdDtlVO );
					}else if( "U".equals( bkgKrWhfVvdDtlVO.getIbflag() ) ){
						addlist.add( bkgKrWhfVvdDtlVO );
					}
					bkgKrWhfVvdDtlVOs.add(bkgKrWhfVvdDtlVO);

				}
			}
			/*
			 * VVD, Port, Bound별로 Detail 정보 삭제
			 */

			if( bkgKrWhfVvdDtlVOs.size()>0 ){
				dbDao.removeBkgKrWhfVvdDtlWhfDec(bkgKrWhfVvdDtlVOs);
			}

			dbDao.addBkgKrWhfVvdDtlWhfDec(addlist);

			if( !"IN".equals( sWhfBndCd ) ){
				dbDao.modifyBkgKrWhfRtWhfDec(krWhfDecCondVO, sNtcNo);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}

	/**
	 * Wharfage 신고 Check
	 *
	 * @param WhfDecCondVO whfDecCondVO 조회조건
	 * @param SignOnUserAccount account 세션정보
	 * @return String
	 * @throws EventException
	 */
	public String searchSendCheck(WhfDecCondVO whfDecCondVO, SignOnUserAccount account) throws EventException{
		KrWhfDecCondVO krWhfDecCondVO = null;

		String dtCheck = "";
		String etaDt = "";
		String frInDt = "";
		String retVal = "";
		String emptyCheck = "";
		try{
			krWhfDecCondVO = (KrWhfDecCondVO)whfDecCondVO;


			List<KrWhfDecCheckSendDtVO> krWhfDecCheckSendDtVOs = dbDao.checkSendDate(krWhfDecCondVO);

			dtCheck = krWhfDecCheckSendDtVOs.get(0).getDtChk();
			etaDt = krWhfDecCheckSendDtVOs.get(0).getEtaDt();
			frInDt = krWhfDecCheckSendDtVOs.get(0).getFrIndt();
			emptyCheck = krWhfDecCheckSendDtVOs.get(0).getEmptyChk();

			retVal = dtCheck + ":" + etaDt + ":" + frInDt + ":" + emptyCheck;

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}

		return retVal;
	}

	/**
	 * Wharfage 신고
	 *
	 * @param WhfDecCondVO whfDecCondVO 조회조건
	 * @param SignOnUserAccount account 세션정보
	 * @return String
	 * @throws EventException
	 */
	@Override
	public void sendWhfDec(WhfDecCondVO whfDecCondVO, SignOnUserAccount account) throws EventException {

		try {
			KrWhfDecCondVO krWhfDecCondVO = (KrWhfDecCondVO)whfDecCondVO;
			String sWhfBndCd = krWhfDecCondVO.getWhfBndCd();
			String sPrefixWhfBndCd = sWhfBndCd.substring(0, 1);
			String sPolCd = "";
			String sPodCd = "";
			if( "O".equals(sPrefixWhfBndCd) ){
				sPolCd = krWhfDecCondVO.getPortCd();
			} else if ( "I".equals( sPrefixWhfBndCd ) ) {
				sPodCd = krWhfDecCondVO.getPortCd();
			}

			KrWhfDecEdiFfContainerVO krWhfDecEdiFfContainerVO  = (KrWhfDecEdiFfContainerVO)searchKrWhfDecEdiFf(krWhfDecCondVO);
			KrWhfDecEdiVvdVO krWhfDecEdiVvdVO = krWhfDecEdiFfContainerVO.getKrWhfDecEdiVvdVO();
			List<KrWhfDecEdiRtVO> krWhfDecEdiRtVOs = krWhfDecEdiFfContainerVO.getKrWhfDecEdiRtVOs();

			/*
			 * Port별로 EDI sender ID, receiver ID, message type을 가져 옴
			 */
			BookingUtil bkgUtil = new BookingUtil();
			BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
    		hrdCdgVO.setHrdCdgId("KR_WHF_EDI_SND_INFO");
    		hrdCdgVO.setAttrCtnt1(krWhfDecCondVO.getPortCd());
    		List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = bkgUtil.searchHardCoding(hrdCdgVO);
    		String sSndrId = "";
    		String sRcvId  = "";
    		String sMsgId  = "";
    		for (Iterator<BkgHrdCdgCtntVO> iterator = bkgHrdCdgCtntVOs.iterator(); iterator.hasNext();) {
				BkgHrdCdgCtntVO bkgHrdCdgCtntVO = iterator.next();
				sSndrId = bkgHrdCdgCtntVO.getAttrCtnt3();
				sRcvId  = bkgHrdCdgCtntVO.getAttrCtnt4();
				sMsgId  = bkgHrdCdgCtntVO.getAttrCtnt2();
			}

    		/*
    		 * EDI 연동.
    		 * 데이터가 반복적으로 어떻게 들어갈수 있는지 설계자에게 질의해야함.
    		 */
    		BookingUtil command = new BookingUtil();
			String sEdiHeader = command.searchEdiHeader(sSndrId, sRcvId, sMsgId);
			StringBuffer flatFile = new StringBuffer();
			flatFile.append( sEdiHeader ).append("\n")
					.append("VVD:"         ).append( krWhfDecEdiVvdVO.getVvd()         ).append("\n")
					.append("VSL_CALLSIGN:").append( krWhfDecEdiVvdVO.getVslCallsign() ).append("\n")
					.append("VSL_FULLNAME:").append( krWhfDecEdiVvdVO.getVslFullname() ).append("\n")
					.append("VSL_COUNTRY:" ).append( krWhfDecEdiVvdVO.getVslCountry()  ).append("\n")
					.append("ETA:"         ).append( krWhfDecEdiVvdVO.getEta()         ).append("\n")
					.append("ETD:"         ).append( krWhfDecEdiVvdVO.getEtd()         ).append("\n")
					.append("POL:"         ).append( sPolCd         ).append("\n")
					.append("POD:"         ).append( sPodCd         ).append("\n")
					.append("IO_IND:"      ).append( krWhfDecEdiVvdVO.getIoInd()       ).append("\n")
					.append("SND_IND:"     ).append( krWhfDecCondVO.getSend()   		).append("\n")
					.append("PORT_CD:"     ).append( krWhfDecEdiVvdVO.getPortCd()      ).append("\n")
					.append("TMNL_CD:"     ).append( krWhfDecEdiVvdVO.getTmnlCd()      ).append("\n")
					.append("IN_SEQ:"      ).append( krWhfDecEdiVvdVO.getInSeq()       ).append("\n")
					.append("DSCH_COM:"    ).append( krWhfDecEdiVvdVO.getDschCom()     ).append("\n")
					.append("DSCH_IND:"    ).append( krWhfDecEdiVvdVO.getDschInd()     ).append("\n")
					.append("DSC_RATE:"    ).append( krWhfDecEdiVvdVO.getDscRate()     ).append("\n")
					.append("F45_TTL:"     ).append( krWhfDecEdiVvdVO.getF45Ttl()      ).append("\n")
					.append("F40_TTL:"     ).append( krWhfDecEdiVvdVO.getF40Ttl()      ).append("\n")
					.append("F35_TTL:"     ).append( krWhfDecEdiVvdVO.getF35Ttl()      ).append("\n")
					.append("F20_TTL:"     ).append( krWhfDecEdiVvdVO.getF20Ttl()      ).append("\n")
					.append("F10_TTL:"     ).append( krWhfDecEdiVvdVO.getF10Ttl()      ).append("\n")
					.append("FETC_TTL:"    ).append( krWhfDecEdiVvdVO.getFetcTtl()     ).append("\n")
					.append("E45_TTL:"     ).append( krWhfDecEdiVvdVO.getE45Ttl()      ).append("\n")
					.append("E40_TTL:"     ).append( krWhfDecEdiVvdVO.getE40Ttl()      ).append("\n")
					.append("E35_TTL:"     ).append( krWhfDecEdiVvdVO.getE35Ttl()      ).append("\n")
					.append("E20_TTL:"     ).append( krWhfDecEdiVvdVO.getE20Ttl()      ).append("\n")
					.append("E10_TTL:"     ).append( krWhfDecEdiVvdVO.getE10Ttl()      ).append("\n")
					.append("EETC_TTL:"    ).append( krWhfDecEdiVvdVO.getEetcTtl()     ).append("\n")
					.append("RTON:"        ).append( krWhfDecEdiVvdVO.getRton()        ).append("\n")
					.append("AMOUNT:"      ).append( krWhfDecEdiVvdVO.getAmount()      ).append("\n")
					.append("FREE_RTON:"   ).append( krWhfDecEdiVvdVO.getFreeRton()    ).append("\n")
					.append("FREE_AMOUNT:" ).append( krWhfDecEdiVvdVO.getFreeAmount()  ).append("\n")
					.append("RTON_TTL:"    ).append( krWhfDecEdiVvdVO.getRtonTtl()     ).append("\n")
					.append("AMOUNT_TTL:"  ).append( krWhfDecEdiVvdVO.getAmountTtl()   ).append("\n")
					.append("TAX_DATE:"    ).append( krWhfDecEdiVvdVO.getTaxDate()     ).append("\n")
					.append("EST_VOL:"     ).append( krWhfDecEdiVvdVO.getEstVol()      ).append("\n")
					.append("SUM_AMOUNT:"  ).append( krWhfDecEdiVvdVO.getSumAmount()   ).append("\n");
					//Wharfage Detail Loop Header [ start ]
					for (Iterator<KrWhfDecEdiRtVO> iterator = krWhfDecEdiRtVOs.iterator(); iterator.hasNext();) {
						KrWhfDecEdiRtVO krWhfDecEdiRtVO = iterator.next();
						flatFile.append("{WHF_DTL"     ).append("").append("\n")
								.append("RTON:"        ).append( krWhfDecEdiRtVO.getRton()    ).append("\n")
								.append("DSCH_IND:"    ).append( krWhfDecEdiRtVO.getDschInd() ).append("\n")
								.append("DC_CD:"       ).append( krWhfDecEdiRtVO.getDcCd()    ).append("\n")
								.append("DC_REASON:"   ).append( krWhfDecEdiRtVO.getDcReason()).append("\n")
								.append("UNIT:"        ).append( krWhfDecEdiRtVO.getUnit()    ).append("\n")
								.append("AMOUNT:"      ).append( krWhfDecEdiRtVO.getAmount()  ).append("\n")
								.append("}WHF_DTL"     ).append("").append("\n");
					}
			        //Wharfage Detail Loop Header [ end ]

			BkgKrWhfVolVO bkgKrWhfVolVO = new BkgKrWhfVolVO();
			String sVvd = krWhfDecCondVO.getVvd();
			ObjectCloner.build(krWhfDecCondVO, bkgKrWhfVolVO);
			bkgKrWhfVolVO.setUpdUsrId(account.getUsr_id());
			bkgKrWhfVolVO.setCreUsrId(account.getUsr_id());
			bkgKrWhfVolVO.setVslCd(sVvd.substring(0, 4));
			bkgKrWhfVolVO.setSkdVoyNo(sVvd.substring(4, 8));
			bkgKrWhfVolVO.setSkdDirCd(sVvd.substring(8, 9));
			bkgKrWhfVolVO.setEdiMsgSndId(krWhfDecCondVO.getSend());
			dbDao.modifyBkgKrWhfVolWhfDecSend(bkgKrWhfVolVO);

			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			log.info(flatFile.toString() );
			sendFlatFileVO.setFlatFile( flatFile.toString() );

			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_KRCUS_GENERAL.IBMMQ.QUEUE"));
			FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
			flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

			if ( flatFileAckVO.getAckStsCd().equals("E") )
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
		} catch( EventException ee ){
			log.error("err " + ee.toString(), ee);
			throw ee;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
	}

	/**
	 * Wharfage EDI 신고를 위한 VO들을 Container VO에 담아 온다
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @return KrWhfDecEdiFfVO
	 * @throws EventException
	 */
	private KrWhfDecEdiFfVO searchKrWhfDecEdiFf(KrWhfDecCondVO krWhfDecCondVO) throws EventException {
		try {
			KrWhfDecEdiFfContainerVO krWhfDecEdiFfContainerVO = new KrWhfDecEdiFfContainerVO();

			KrWhfDecEdiVvdVO krWhfDecEdiVvdVO  = dbDao.searchKrWhfDecEdiVvd(krWhfDecCondVO);
			KrWhfDecEdiVvdVO krWhfDecEdiVvdVO2 = dbDao.searchKrWhfDecEdiQty(krWhfDecCondVO);
			krWhfDecEdiVvdVO.setEstVol(krWhfDecEdiVvdVO2.getEstVol());
			krWhfDecEdiVvdVO.setSumAmount(krWhfDecEdiVvdVO2.getSumAmount());
			List<KrWhfDecEdiRtVO>  krWhfDecEdiRtVOs = dbDao.searchKrWhfDecEdiRtList (krWhfDecCondVO);
			krWhfDecEdiFfContainerVO.setKrWhfDecEdiVvdVO(krWhfDecEdiVvdVO);
			krWhfDecEdiFfContainerVO.setKrWhfDecEdiRtVOs(krWhfDecEdiRtVOs);

			return krWhfDecEdiFfContainerVO;

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * Wharfage 신고 인터페이스
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public String interfaceWhfDec(WhfDecCondVO whfDecCondVO, SignOnUserAccount account) throws EventException {
		try {

			KrWhfDecCondVO krWhfDecCondVO = (KrWhfDecCondVO)whfDecCondVO;

			String sOfcCd = "";

			String cancelFlag = krWhfDecCondVO.getCancelFlag();

			KrWhfDecCondVO krWhfDecCondVO2 = dbDao.searchKrWhfDecBzcInfo( krWhfDecCondVO );

			//2013.09.26 부산 요청 사항으로 서울 지점에서 부산 업무를 수행하기때문에 port가 부산일 경우 각자의 로그인 office를 사용
//			if(krWhfDecCondVO.getPortCd().equals("KRPUS")){ //jjang
//				sOfcCd = krWhfDecCondVO.getOfcCd();
//			}else{
//				sOfcCd = krWhfDecCondVO2.getWhfDeclOfcCd();
//			}

			sOfcCd = krWhfDecCondVO2.getWhfDeclOfcCd();


			krWhfDecCondVO.setWhfDeclOfcCd(sOfcCd);

			if(!"Y".equals(cancelFlag)){  // Dec I/F 시
				krWhfDecCondVO.setWhfDeclNo("");
				KrWhfDecCondVO krWhfDecCondVO3 = createKrWhfDecNo(krWhfDecCondVO, account);
				krWhfDecCondVO.setWhfDeclNo(krWhfDecCondVO3.getWhfDeclNo());

				krWhfDecCondVO = (KrWhfDecCondVO) manageWhfApIf( krWhfDecCondVO, account );

				dbDao.modifyBkgKrWhfRtIfDecNo(krWhfDecCondVO, account);

				krWhfDecCondVO = (KrWhfDecCondVO) manageWhfArInvIf(krWhfDecCondVO, account);
			}else{  // Dec Cancel I/F 시

				krWhfDecCondVO = (KrWhfDecCondVO) manageWhfApIf( krWhfDecCondVO, account );

				krWhfDecCondVO = (KrWhfDecCondVO) manageWhfArInvIf(krWhfDecCondVO, account);

				dbDao.modifyBkgKrWhfRtIfDecNo(krWhfDecCondVO, account);
			}

			dbDao.modifyWhfDecHis(krWhfDecCondVO, "", krWhfDecCondVO.getHisSeq(), "Y" );

//          수정
//			//dbDao.modifyBkgKrWhfRtIfDecNo(krWhfDecCondVO, account);
//
//			krWhfDecCondVO = (KrWhfDecCondVO) manageWhfApIf( krWhfDecCondVO, account );
//
//			dbDao.modifyBkgKrWhfRtIfDecNo(krWhfDecCondVO, account);
//
//			//dbDao.modifyBkgKrWhfRtIfCsrNo(krWhfDecCondVO, account);
//
//			krWhfDecCondVO = (KrWhfDecCondVO) manageWhfArInvIf(krWhfDecCondVO, account);
//
//			//dbDao.modifyBkgKrWhfRtIfCsrNo(krWhfDecCondVO, account);

			return "Y" ;

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		} catch(EventException ee){
			log.error("err " + ee.toString(), ee);
			throw ee;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
	}

	/**
	 * Declare Number 를 생성하는 메서드.
	 *
	 * @param KrWhfDecCondVO krWhfDecCondVO
	 * @param SignOnUserAccount account
	 * @return KrWhfDecCondVO
	 * @throws EventException
	 */
	private KrWhfDecCondVO createKrWhfDecNo(KrWhfDecCondVO krWhfDecCondVO, SignOnUserAccount account) throws EventException {
		try {
			KrWhfDecCondVO krWhfDecCondVO2 = dbDao.searchKrWhfDecBzcInfo(krWhfDecCondVO);
			String sOfcCd = krWhfDecCondVO2.getWhfDeclOfcCd();

			/*
			 *  각각의 테이블에 저장되어 있는 갯수 검증을 하여 같지 않으면 예외 처리를 하여준다.
			 */
			String sWhfAmtFmSmry = dbDao.searchKrWhfSumAmtFmSmry( krWhfDecCondVO ); //BKG_KR_WHF_RT
			String sWhfAmtFmDtl  = dbDao.searchKrWhfSumAmtFmDtl( krWhfDecCondVO );  //BKG_KR_WHF_VOL
//			if( Integer.parseInt( ( sWhfAmtFmSmry == "")?"0":sWhfAmtFmSmry ) != Integer.parseInt(sWhfAmtFmDtl) )
//				throw new EventException(new ErrorHandler("BKG06067",new String[]{}).getMessage());

			//울산일 경우 최저금액이 3000 원으로 신고 금액 설정
			if( Integer.parseInt( ( sWhfAmtFmSmry == "")?"0":sWhfAmtFmSmry ) != Integer.parseInt(sWhfAmtFmDtl) )
				throw new EventException(new ErrorHandler("BKG06067",new String[]{}).getMessage());
			/*
			 * 해당 VVD에 이미 Decl No가 존재하는지 확인한후, 존재하면 예외처리를 한다.
			 */
			String sWhfDeclNoExistFlg = dbDao.searchKrWhfDecDeclNoWithVvdExistFlg(krWhfDecCondVO);
			if( "Y".equals(sWhfDeclNoExistFlg) )
				throw new EventException(new ErrorHandler("BKG06068",new String[]{sWhfDeclNoExistFlg}).getMessage());

			/*
			 * 화면에 Dec No 가 있으면 예외처리를 한다.
			 */
			if( 0 != krWhfDecCondVO.getWhfDeclNo().length() )
				throw new EventException(new ErrorHandler("BKG06068",new String[]{krWhfDecCondVO.getWhfDeclNo()}).getMessage());

			BookingUtil BookingUtil = new BookingUtil();
			String sBkgDivCd = "KWD" ;
			String sOfficeCd = krWhfDecCondVO.getVvd() + "|" + krWhfDecCondVO.getPortCd() + "|" + sOfcCd ;
			BkgReferenceNoGenerationVO bkgReferenceNoGenerationVO
				=  BookingUtil.manageBkgReferenceNumberGeneration(sBkgDivCd, sOfficeCd, account.getUsr_id());
			String sWhfDeclNo = bkgReferenceNoGenerationVO.getKrWhfDeclNo();//getWhfDeclNo();
			String sWhfDeclNoExistFlg2 = dbDao.searchKrWhfDecDeclNoWithDiffVvdExistFlg(krWhfDecCondVO.getVvd(), sWhfDeclNo);
			if( "Y".equals(sWhfDeclNoExistFlg2) )
				throw new EventException(new ErrorHandler("BKG06069",new String[]{sWhfDeclNo}).getMessage());

			krWhfDecCondVO.setWhfDeclNo(sWhfDeclNo);
			return krWhfDecCondVO;
		} catch(EventException ee){
			log.error("err " + ee.toString(), ee);
			throw ee;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
	}

	/**
	 * AP Invoice 데이터를 ERP로 Interface한다
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	private WhfDecCondVO manageWhfApIf(WhfDecCondVO whfDecCondVO, SignOnUserAccount account) throws EventException {

		try {
			KrWhfDecCondVO krWhfDecCondVO = (KrWhfDecCondVO)whfDecCondVO ;

			List<ApInvHdrVO> apInvHdrVOs = new ArrayList<ApInvHdrVO>();
			ApInvHdrVO apInvHdrVO = new ApInvHdrVO();
			List<ApInvDtrbVO> apInvDtrbVOs = new ArrayList<ApInvDtrbVO>();
			String sCsrNo = "";


			if(krWhfDecCondVO.getPortCd().equals("KRINC") || krWhfDecCondVO.getPortCd().equals("KRPUS") || krWhfDecCondVO.getPortCd().equals("KRPTK") || krWhfDecCondVO.getPortCd().equals("KRUSN")
				|| krWhfDecCondVO.getPortCd().equals("KRGIN") || krWhfDecCondVO.getPortCd().equals("KRKAN"))
			{
				KrWhfDecBzcInfoForApIfVO krWhfDecBzcInfoForApIfVO   = dbDao.searchKrWhfDecBzcInfoForApIf( krWhfDecCondVO ); // 여기 입력되는 whf_decl_ofc_cd 는 (KRINC,KRPTK,KRGIN) 를 제외하고 mdm 의 FINC_CTRL_OFC_CD

				String sRevenueVvd = dbDao.searchRevVvd(krWhfDecCondVO); 	// 관통 테스트 "CNTC1605MM"

				BookingUtil BookingUtil = new BookingUtil();

				String sBkgDivCd = "KWC" ;


				String sOfficeCd = krWhfDecCondVO.getWhfDeclOfcCd() ;

				//2013.09.26 부산 요청 사항으로 서울 지점에서 부산 업무를 수행하기때문에 port가 부산일 경우 각자의 로그인 office를 사용
				//2016.06.20 인천,평택,경인,광양 업무가 부산으로 이관 됨에 따라 "DEC I/F (II)" 시 로그인 유저의 OFFICE가 를 AP 전표반영 필요함.
				if(krWhfDecCondVO.getPortCd().equals("KRPUS") || krWhfDecCondVO.getPortCd().equals("KRUSN")
					||krWhfDecCondVO.getPortCd().equals("KRINC") ||krWhfDecCondVO.getPortCd().equals("KRPTK")||krWhfDecCondVO.getPortCd().equals("KRGIN") ||krWhfDecCondVO.getPortCd().equals("KRKAN")){ //jjang
					sOfficeCd = krWhfDecCondVO.getOfcCd(); // login office cd

//					if(sOfficeCd.substring(0,3).equals("PUS")){ //부산 지역 2개의 오피스 사용(PUSBO, PUSBS), PUSBS사용
//						sOfficeCd = "PUSBS";
//					}else if(sOfficeCd.substring(0,3).equals("SEL")){
//						sOfficeCd = "SELBB";
//					}
					/* 2014.03.26 한국지점 office변경에 따른 수정
					 * PUSBO, PUSBS -> PUSBB 변경
					 * 2015.08.06 그룹사 표준 코드 시행
					 * PUSBB -> PUSSC
					 * SELBB -> SELSC
					 */
					/*** OFC_CHANGE S***/
					if(sOfficeCd.substring(0,3).equals("PUS")){
						sOfficeCd = "PUSSC";
					}else if(sOfficeCd.substring(0,3).equals("SEL")){
						sOfficeCd = "SELSC";
					}
					/*** OFC_CHANGE E***/
//				}else if(krWhfDecCondVO.getPortCd().equals("KRUSN")) {
//					String sPrefixWhfBndCd = krWhfDecCondVO.getWhfBndCd().substring(0, 1);
//					if( "O".equals(sPrefixWhfBndCd) ){
//						sOfficeCd = "SELSC";
//					} else if ( "I".equals( sPrefixWhfBndCd ) ) {
//						sOfficeCd = "PUSSC";
//					}

				}else{
					sOfficeCd = krWhfDecCondVO.getWhfDeclOfcCd();
				}



				String orgCsrNo = "";
				String totalAmount = krWhfDecCondVO.getWhfRtAmt().replaceAll(",", "");
				String ntcAmount = String.valueOf( Float.parseFloat(krWhfDecCondVO.getNtcAmt().replaceAll(",", "")) ) ;//jjang
				String rducAmt = "";
				int rducAmtNegaFlg = Integer.parseInt(krWhfDecCondVO.getRducAmt().replaceAll(",", ""));
				// 양수
				if(rducAmtNegaFlg > 0){
					rducAmt = String.valueOf( Float.parseFloat( krWhfDecCondVO.getRducAmt().replaceAll(",", "") ));
				// 음수
				}else{
					rducAmt = String.valueOf( Float.parseFloat( krWhfDecCondVO.getRducAmt().replaceAll(",", "") ) * -1 );
				}
				String invDt = krWhfDecCondVO.getWhfNtcDt().replaceAll("-", "");
				int payTerm = DateTime.daysBetween(krWhfDecCondVO.getWhfNtcDt().replaceAll("-", ""), krWhfDecCondVO.getWhfPayDt().replaceAll("-", ""));
				String invNo = krWhfDecCondVO.getWhfNtcNoYr() + krWhfDecCondVO.getWhfNtcNoMon() + krWhfDecCondVO.getWhfNtcNoSeq();
				String csrTypeCd = "STANDARD";

				// 울산 3000원 이하는 3000 원으로 셋팅. ntcAmount 신고금액
				// 평택 3000원 이하는 3000 원으로 셋팅. ntcAmount 신고금액 [2016.06.20]
				// 광양 3000원 이하는 3000 원으로 셋팅. ntcAmount 신고금액 [2018.02.09]
				if((krWhfDecCondVO.getPortCd().equals("KRUSN")||krWhfDecCondVO.getPortCd().equals("KRPTK")||krWhfDecCondVO.getPortCd().equals("KRKAN")) && Float.parseFloat(ntcAmount) < 3000 ) {
					totalAmount = "3000";
					ntcAmount 	= "3000";
				}

				
				
				if("Y".equals(krWhfDecCondVO.getCancelFlag())){
					totalAmount = (Integer.parseInt(totalAmount) * -1 ) + "";
					ntcAmount = (Float.parseFloat(ntcAmount) * -1 ) + "";
					rducAmt = (Float.parseFloat(rducAmt) * -1) + "";
					orgCsrNo = krWhfDecCondVO.getCsrNo();
					csrTypeCd = "CREDIT";
				}

				BkgReferenceNoGenerationVO bkgReferenceNoGenerationVO
					= BookingUtil.manageBkgReferenceNumberGeneration(sBkgDivCd, sOfficeCd, account.getUsr_id());
				sCsrNo = bkgReferenceNoGenerationVO.getKrWhfCsrNo();

				//Cancel 전표 생성시 03S로 발샌하던 기존 로진을 03C로 변경
				if("Y".equals(krWhfDecCondVO.getCancelFlag()) ){
					sCsrNo = sCsrNo.replaceAll("03S", "03C") ;
				}

				krWhfDecCondVO.setCsrNo(sCsrNo);

				/*
				 * Create Header [start]		 */
				apInvHdrVO.setCsrNo(sCsrNo);
				apInvHdrVO.setCsrTpCd(csrTypeCd);
				apInvHdrVO.setInvDt( invDt );//jjang
				apInvHdrVO.setInvTermDt( invDt );//jjang
				apInvHdrVO.setVndrTermNm(String.valueOf(payTerm));//jjang

				apInvHdrVO.setGlDt(krWhfDecBzcInfoForApIfVO.getGlDt());
				apInvHdrVO.setVndrNo(krWhfDecBzcInfoForApIfVO.getVndrNo());
				apInvHdrVO.setCsrAmt(ntcAmount);//jjang
				apInvHdrVO.setCsrCurrCd("KRW");
				//apInvHdrVO.setVndrTermNm(krWhfDecBzcInfoForApIfVO.getVndrTermNm());
				apInvHdrVO.setInvDesc( krWhfDecCondVO.getWhfDeclNo());
				apInvHdrVO.setAttrCateNm("기타");
				apInvHdrVO.setAttrCtnt10(krWhfDecCondVO.getWhfUsrNm());
				apInvHdrVO.setAttrCtnt15("N");		//jjang
				apInvHdrVO.setSrcCtnt("NIS AR");
				apInvHdrVO.setPayMzdLuCd("WIRE");
				apInvHdrVO.setPayGrpLuCd("대내지불");
				apInvHdrVO.setCoaCoCd("01");
				apInvHdrVO.setCoaRgnCd("11");
				apInvHdrVO.setCoaCtrCd(krWhfDecBzcInfoForApIfVO.getApCtrCd());
				apInvHdrVO.setCoaAcctCd("210111");
				apInvHdrVO.setCoaVvdCd("0000000000");
				apInvHdrVO.setCoaInterCoCd("00");
				apInvHdrVO.setCoaFtuN1stCd("000000");
				apInvHdrVO.setCoaFtuN2ndCd("000000");
				apInvHdrVO.setAproFlg("N"); //jjang
				apInvHdrVO.setErrCsrNo(" ");
				apInvHdrVO.setTjOfcCd(sOfficeCd); //sin
				//apInvHdrVO.setTjOfcCd(krWhfDecCondVO.getWhfDeclOfcCd()); 2013.12.18 ERP에 OFFICE 변경 추가
				apInvHdrVO.setCreDt(DateTime.getFormatDate( new Date(), "yyyyMMdd") );
				apInvHdrVO.setCreUsrId(account.getUsr_id());
				apInvHdrVO.setAttrCtnt11      (orgCsrNo);

				/*
				 * Create Header [end]
				 */
				apInvHdrVOs.add(apInvHdrVO);
				//////////////////////////////////////////////////////////////////////////////////


				/*
				 * Create Distribute [start] 1st
				 */
				String sDtrbCoaAcctCd = "211541";
				String sDtrbCoaAcctCdForTruncatedAmt = "422011";
				String sAttrCateNm    = "211541";
				String rducAmtCd = "582911";
				// Port Code 를 보내주어야 한다고 함.
	//			String sAttrCntt3     = krWhfDecCondVO.getWhfDeclNo().substring(0,5);
				String sAttrCntt3     = krWhfDecCondVO.getPortCd();


				ApInvDtrbVO apInvDtrbVO = new ApInvDtrbVO();
				apInvDtrbVO.setCsrNo           (sCsrNo);
				apInvDtrbVO.setLineSeq         ("0001");
				apInvDtrbVO.setLineNo          ("0001");
				apInvDtrbVO.setLineTpLuCd      ("ITEM");
				apInvDtrbVO.setInvAmt          ( totalAmount );
				apInvDtrbVO.setInvDesc         ( krWhfDecCondVO.getWhfDeclNo());
				apInvDtrbVO.setDtrbCoaCoCd     ("01");
				apInvDtrbVO.setDtrbCoaRgnCd    ("11");
				apInvDtrbVO.setDtrbCoaCtrCd    (krWhfDecBzcInfoForApIfVO.getApCtrCd());
				apInvDtrbVO.setDtrbCoaAcctCd   (sDtrbCoaAcctCd);
				apInvDtrbVO.setDtrbCoaVvdCd    ("0000000000");
				apInvDtrbVO.setDtrbCoaInterCoCd("00");
				apInvDtrbVO.setDtrbCoaFtuN1stCd("000000");
				apInvDtrbVO.setDtrbCoaFtuN2ndCd("000000");
				apInvDtrbVO.setAttrCateNm      (sAttrCateNm);
				apInvDtrbVO.setAttrCtnt3       (sAttrCntt3);
				apInvDtrbVO.setActVvdCd        (sRevenueVvd);
				apInvDtrbVO.setPlnSctrDivCd    (" ");
				apInvDtrbVO.setCreDt           ("SYSDATE");
				apInvDtrbVO.setCreUsrId        (account.getUsr_id());
	//			apInvDtrbVO.setAttrCtnt11      (orgCsrNo);		//jjang

				apInvDtrbVO.setAttrCtnt1       (invNo);//jjang
				/*
				 * Create Distribute [end]
				 */
				apInvDtrbVOs.add(apInvDtrbVO);
				///////////////////////////////////////////////////////////////////////////////////////


				/*
				 * Create Distribute [start] WHF 비관리청항만매출채권 INSERT
				 */
	//			ApInvDtrbVO apInvDtrbVO2 = new ApInvDtrbVO();
	//			apInvDtrbVO2.setCsrNo           (sCsrNo);
	//			apInvDtrbVO2.setLineSeq         ("0002");
	//			apInvDtrbVO2.setLineNo          ("0002");
	//			apInvDtrbVO2.setLineTpLuCd      ("ITEM");
	//			apInvDtrbVO2.setInvAmt          ( ntcAmount );
	//			apInvDtrbVO2.setInvDesc         ( krWhfDecCondVO.getWhfDeclNo());
	//			apInvDtrbVO2.setDtrbCoaCoCd     ("01");
	//			apInvDtrbVO2.setDtrbCoaRgnCd    ("11");
	//			apInvDtrbVO2.setDtrbCoaCtrCd    (krWhfDecBzcInfoForApIfVO.getApCtrCd());
	//			apInvDtrbVO2.setDtrbCoaAcctCd   ("111211");
	//			apInvDtrbVO2.setDtrbCoaVvdCd    ("0000000000");
	//			apInvDtrbVO2.setDtrbCoaInterCoCd("00");
	//			apInvDtrbVO2.setDtrbCoaFtuN1stCd("000000");
	//			apInvDtrbVO2.setDtrbCoaFtuN2ndCd("000000");
	//			apInvDtrbVO2.setAttrCateNm      ("111211");
	//			apInvDtrbVO2.setAttrCtnt3       (sAttrCntt3);
	//			apInvDtrbVO2.setActVvdCd        (sRevenueVvd);
	//			apInvDtrbVO2.setPlnSctrDivCd    (" ");
	//			apInvDtrbVO2.setCreDt           ("SYSDATE");
	//			apInvDtrbVO2.setCreUsrId        (account.getUsr_id());
	//			apInvDtrbVO2.setAttrCtnt11       (orgCsrNo);

				/*
				 * Create Distribute [end]
				 */
	//			apInvDtrbVOs.add(apInvDtrbVO2);
				////////////////////////////////////////////////////////////////////////////////////////////////////


				// 절사금액이 잇을 경우
				/*
				 * Create Distribute [start] 절사금액 INSERT
				 */

				//(울산항||평택항) 아니고 금액이 3000원 이하일때는 절사금액이 표시 안함 이유는 3000원으로 하드코딩하여 보내기 때문에 절사금액필요가 없음. [2016.06.20][2018.02.09]
				//Cancel할 경우 '-' 금액 으로 들어오기때문에 금액 절대값으로 비교 로직 추가 [2016.07.27]
				if(!((krWhfDecCondVO.getPortCd().equals("KRUSN")||krWhfDecCondVO.getPortCd().equals("KRPTK")||krWhfDecCondVO.getPortCd().equals("KRKAN")) && Math.abs(Float.parseFloat(totalAmount)) <= 3000) ) {
					// 절사값이 +이면 보낼 때 -로 보냄. 환차손이면 그대로 보냄.
					if( rducAmtNegaFlg > 0 )
					{
						ApInvDtrbVO apInvDtrbVO3 = new ApInvDtrbVO();
						apInvDtrbVO3.setCsrNo           (sCsrNo);
						apInvDtrbVO3.setLineSeq         ("0002");
						apInvDtrbVO3.setLineNo          ("0002");
						apInvDtrbVO3.setLineTpLuCd      ("ITEM");
						apInvDtrbVO3.setInvAmt          ( (Float.parseFloat(rducAmt) * -1) + "" );
						apInvDtrbVO3.setInvDesc         ( krWhfDecCondVO.getWhfDeclNo());
						apInvDtrbVO3.setDtrbCoaCoCd     ("01");
						apInvDtrbVO3.setDtrbCoaRgnCd    ("11");
						apInvDtrbVO3.setDtrbCoaCtrCd    (krWhfDecBzcInfoForApIfVO.getApCtrCd());
						apInvDtrbVO3.setDtrbCoaAcctCd   (sDtrbCoaAcctCdForTruncatedAmt);
						apInvDtrbVO3.setDtrbCoaVvdCd    (sRevenueVvd);
						apInvDtrbVO3.setDtrbCoaInterCoCd("00");
						apInvDtrbVO3.setDtrbCoaFtuN1stCd("000000");
						apInvDtrbVO3.setDtrbCoaFtuN2ndCd("000000");
						apInvDtrbVO3.setAttrCateNm      (sDtrbCoaAcctCdForTruncatedAmt);
						apInvDtrbVO3.setAttrCtnt3       (sAttrCntt3);
						apInvDtrbVO3.setActVvdCd        (sRevenueVvd);
						apInvDtrbVO3.setPlnSctrDivCd    (" ");
						apInvDtrbVO3.setCreDt           ("SYSDATE");
						apInvDtrbVO3.setCreUsrId        (account.getUsr_id());
			//			apInvDtrbVO3.setAttrCtnt11      (orgCsrNo); 	//jjang - 블럭

						apInvDtrbVO3.setAttrCtnt1       (invNo);		//jjang - 추가
						/*
						 * Create Distribute [end]
						 */
						apInvDtrbVOs.add(apInvDtrbVO3);

					}
				// 2018.02.13 iylee 광양발이고 3000원 이하면 잡손실 코드 전송.  	
				} else if(krWhfDecCondVO.getPortCd().equals("KRKAN") && Math.abs(Float.parseFloat(totalAmount)) <= 3000){
						// 절사값이 +이면 보낼 때 -로 보냄. 환차손이면 그대로 보냄.
						ApInvDtrbVO apInvDtrbVO3 = new ApInvDtrbVO();
						apInvDtrbVO3.setCsrNo           (sCsrNo);
						apInvDtrbVO3.setLineSeq         ("0002");
						apInvDtrbVO3.setLineNo          ("0002");
						apInvDtrbVO3.setLineTpLuCd      ("ITEM");
						apInvDtrbVO3.setInvAmt          ( rducAmt );
						apInvDtrbVO3.setInvDesc         ( krWhfDecCondVO.getWhfDeclNo());
						apInvDtrbVO3.setDtrbCoaCoCd     ("01");
						apInvDtrbVO3.setDtrbCoaRgnCd    ("11");
						apInvDtrbVO3.setDtrbCoaCtrCd    (krWhfDecBzcInfoForApIfVO.getApCtrCd());
						if( rducAmtNegaFlg > 0 ){
							apInvDtrbVO3.setDtrbCoaAcctCd   ((Float.parseFloat(rducAmt) * -1) + "");
						} else {
							apInvDtrbVO3.setDtrbCoaAcctCd   (rducAmtCd);
						}	
						apInvDtrbVO3.setDtrbCoaVvdCd    (sRevenueVvd);
						apInvDtrbVO3.setDtrbCoaInterCoCd("00");
						apInvDtrbVO3.setDtrbCoaFtuN1stCd("000000");
						apInvDtrbVO3.setDtrbCoaFtuN2ndCd("000000");
						if( rducAmtNegaFlg > 0 ){						
							apInvDtrbVO3.setAttrCateNm   ((Float.parseFloat(rducAmt) * -1) + "");
						} else {
							apInvDtrbVO3.setAttrCateNm   (rducAmtCd);
						}	
						apInvDtrbVO3.setAttrCtnt3       (sAttrCntt3);
						apInvDtrbVO3.setActVvdCd        (sRevenueVvd);
						apInvDtrbVO3.setPlnSctrDivCd    (" ");
						apInvDtrbVO3.setCreDt           ("SYSDATE");
						apInvDtrbVO3.setCreUsrId        (account.getUsr_id());
			//			apInvDtrbVO3.setAttrCtnt11      (orgCsrNo); 	//jjang - 블럭

						apInvDtrbVO3.setAttrCtnt1       (invNo);		//jjang - 추가
						/*
						 * Create Distribute [end]
						 */
						apInvDtrbVOs.add(apInvDtrbVO3);
				}
				/////////////////////////////////////////////////////////////////////////////////////////////////


				dbDao.addApInvHdrList(apInvHdrVOs);

				dbDao.addApInvDtrbList(apInvDtrbVOs);

				List<SearchApSlipInterfaceListVO> searchApSlipInterfaceListVOs = new ArrayList<SearchApSlipInterfaceListVO>();
				for (Iterator<ApInvDtrbVO> iterator = apInvDtrbVOs.iterator(); iterator.hasNext();) {
					ApInvDtrbVO tempApInvDtrbVO = iterator.next();
					SearchApSlipInterfaceListVO searchApSlipInterfaceListVO1 = new SearchApSlipInterfaceListVO();

					/*
					 * HEADER
					 */
					searchApSlipInterfaceListVO1.setHdrCsrNo       ( apInvHdrVO.getCsrNo       () );
					searchApSlipInterfaceListVO1.setHdrCsrTpCd     ( apInvHdrVO.getCsrTpCd     () );
					searchApSlipInterfaceListVO1.setHdrInvDt       ( apInvHdrVO.getInvDt       () );  //관통테스트 ("20150808");  //
					searchApSlipInterfaceListVO1.setHdrInvTermDt   ( apInvHdrVO.getInvTermDt   () );
					searchApSlipInterfaceListVO1.setHdrGlDt        ( apInvHdrVO.getGlDt        () );  //관통테스트 ("20150808");  // 반영시 원복해야 함 apInvHdrVO.getGlDt()
					searchApSlipInterfaceListVO1.setHdrVndrNo      ( apInvHdrVO.getVndrNo      () );
					searchApSlipInterfaceListVO1.setHdrCsrAmt      ( apInvHdrVO.getCsrAmt      () );
					searchApSlipInterfaceListVO1.setHdrCsrCurrCd   ( apInvHdrVO.getCsrCurrCd   () );
					searchApSlipInterfaceListVO1.setHdrVndrTermNm  ( apInvHdrVO.getVndrTermNm  () );
					searchApSlipInterfaceListVO1.setHdrInvDesc     ( apInvHdrVO.getInvDesc     () );
					searchApSlipInterfaceListVO1.setHdrAttrCateNm  ( apInvHdrVO.getAttrCateNm  () );
					searchApSlipInterfaceListVO1.setHdrAttrCtnt10  ( apInvHdrVO.getAttrCtnt10  () );
					searchApSlipInterfaceListVO1.setHdrAttrCtnt15  ( apInvHdrVO.getAttrCtnt15  () );
					searchApSlipInterfaceListVO1.setHdrSrcCtnt     ( apInvHdrVO.getSrcCtnt     () );
					searchApSlipInterfaceListVO1.setHdrPayMzdLuCd  ( apInvHdrVO.getPayMzdLuCd  () );
					searchApSlipInterfaceListVO1.setHdrPayGrpLuCd  ( apInvHdrVO.getPayGrpLuCd  () );
					searchApSlipInterfaceListVO1.setHdrCoaCoCd     ( apInvHdrVO.getCoaCoCd     () );
					searchApSlipInterfaceListVO1.setHdrCoaRgnCd    ( apInvHdrVO.getCoaRgnCd    () );
					searchApSlipInterfaceListVO1.setHdrCoaCtrCd    ( apInvHdrVO.getCoaCtrCd    () );
					searchApSlipInterfaceListVO1.setHdrCoaAcctCd   ( apInvHdrVO.getCoaAcctCd   () );
					searchApSlipInterfaceListVO1.setHdrCoaVvdCd    ( apInvHdrVO.getCoaVvdCd    () );
					searchApSlipInterfaceListVO1.setHdrCoaInterCoCd( apInvHdrVO.getCoaInterCoCd() );
					searchApSlipInterfaceListVO1.setHdrCoaFtuN1stCd( apInvHdrVO.getCoaFtuN1stCd() );
					searchApSlipInterfaceListVO1.setHdrCoaFtuN2ndCd( apInvHdrVO.getCoaFtuN2ndCd() );
					searchApSlipInterfaceListVO1.setHdrAproFlg     ( apInvHdrVO.getAproFlg     () );
					searchApSlipInterfaceListVO1.setHdrErrCsrNo    ( apInvHdrVO.getErrCsrNo    () );
					searchApSlipInterfaceListVO1.setHdrTjOfcCd     ( apInvHdrVO.getTjOfcCd     () );
					searchApSlipInterfaceListVO1.setHdrCreDt       ( apInvHdrVO.getCreDt       () );
					searchApSlipInterfaceListVO1.setHdrCreUsrId    ( apInvHdrVO.getCreUsrId    () );
					searchApSlipInterfaceListVO1.setHdrAttrCtnt11  ( apInvHdrVO.getAttrCtnt11  () );
					/*
					 * DETAIL
					 */
					searchApSlipInterfaceListVO1.setDCsrNo           ( tempApInvDtrbVO.getCsrNo           () );
					searchApSlipInterfaceListVO1.setDLineSeq         ( tempApInvDtrbVO.getLineSeq         () );
					searchApSlipInterfaceListVO1.setDLineNo          ( tempApInvDtrbVO.getLineNo          () );
					searchApSlipInterfaceListVO1.setDLineTpLuCd      ( tempApInvDtrbVO.getLineTpLuCd      () );
					searchApSlipInterfaceListVO1.setDInvAmt          ( tempApInvDtrbVO.getInvAmt          () );
					searchApSlipInterfaceListVO1.setDInvDesc         ( tempApInvDtrbVO.getInvDesc         () );
					searchApSlipInterfaceListVO1.setDDtrbCoaCoCd     ( tempApInvDtrbVO.getDtrbCoaCoCd     () );
					searchApSlipInterfaceListVO1.setDDtrbCoaRgnCd    ( tempApInvDtrbVO.getDtrbCoaRgnCd    () );
					searchApSlipInterfaceListVO1.setDDtrbCoaCtrCd    ( tempApInvDtrbVO.getDtrbCoaCtrCd    () );
					searchApSlipInterfaceListVO1.setDDtrbCoaAcctCd   ( tempApInvDtrbVO.getDtrbCoaAcctCd   () );
					searchApSlipInterfaceListVO1.setDDtrbCoaVvdCd    ( tempApInvDtrbVO.getDtrbCoaVvdCd    () );
					searchApSlipInterfaceListVO1.setDDtrbCoaInterCoCd( tempApInvDtrbVO.getDtrbCoaInterCoCd() );
					searchApSlipInterfaceListVO1.setDDtrbCoaFtuN1stCd( tempApInvDtrbVO.getDtrbCoaFtuN1stCd() );
					searchApSlipInterfaceListVO1.setDDtrbCoaFtuN2ndCd( tempApInvDtrbVO.getDtrbCoaFtuN2ndCd() );
					searchApSlipInterfaceListVO1.setDAttrCateNm      ( tempApInvDtrbVO.getAttrCateNm      () );
					searchApSlipInterfaceListVO1.setDAttrCtnt3       ( tempApInvDtrbVO.getAttrCtnt3       () );
					searchApSlipInterfaceListVO1.setDActVvdCd        ( tempApInvDtrbVO.getActVvdCd        () );
					searchApSlipInterfaceListVO1.setDPlnSctrDivCd    ( tempApInvDtrbVO.getPlnSctrDivCd    () );
					searchApSlipInterfaceListVO1.setDCreDt           ( tempApInvDtrbVO.getCreDt           () );
					searchApSlipInterfaceListVO1.setDCreUsrId        ( tempApInvDtrbVO.getCreUsrId        () );
					searchApSlipInterfaceListVO1.setDAttrCtnt11      ( tempApInvDtrbVO.getAttrCtnt11      () );

					searchApSlipInterfaceListVO1.setDAttrCtnt1       ( tempApInvDtrbVO.getAttrCtnt1       () ); //jjang

					searchApSlipInterfaceListVOs.add(searchApSlipInterfaceListVO1);
				}

				dbDao.addApInvIfSearch( sCsrNo, account.getUsr_id() );
				eaiDao.interfaceKrWhfToAp( sCsrNo, searchApSlipInterfaceListVOs );


			}else{


				KrWhfDecBzcInfoForApIfVO krWhfDecBzcInfoForApIfVO   = dbDao.searchKrWhfDecBzcInfoForApIf( krWhfDecCondVO );

				String sRevenueVvd = dbDao.searchRevVvd(krWhfDecCondVO);

				BookingUtil BookingUtil = new BookingUtil();
				String sBkgDivCd = "KWC" ;
				String sOfficeCd = krWhfDecCondVO.getWhfDeclOfcCd() ;

				String orgCsrNo = "";

				//
				String totalAmount = krWhfDecCondVO.getWhfRtAmt().replaceAll(",", "");
				//
				String ntcAmount = String.valueOf( Float.parseFloat(krWhfDecCondVO.getNtcAmt().replaceAll(",", "")) * -1) ;
				//
				String rducAmt = String.valueOf( Float.parseFloat( krWhfDecCondVO.getRducAmt() ) * -1 ) ;
				//


				if("Y".equals(krWhfDecCondVO.getCancelFlag())){
					totalAmount = (Integer.parseInt(totalAmount) * -1 ) + "";
					ntcAmount = (Float.parseFloat(ntcAmount) * -1 ) + "";
					rducAmt = (Float.parseFloat(rducAmt) * -1 ) + "";
					orgCsrNo = krWhfDecCondVO.getCsrNo();
				}



				BkgReferenceNoGenerationVO bkgReferenceNoGenerationVO
					= BookingUtil.manageBkgReferenceNumberGeneration(sBkgDivCd, sOfficeCd, account.getUsr_id());
				sCsrNo = bkgReferenceNoGenerationVO.getKrWhfCsrNo();
				krWhfDecCondVO.setCsrNo(sCsrNo);

//				apInvHdrVOs = new ArrayList<ApInvHdrVO>();
//				apInvHdrVO = new ApInvHdrVO();

				/*
				 * Create Header [start]
				 */

				apInvHdrVO.setCsrNo(sCsrNo);
				apInvHdrVO.setCsrTpCd("STANDARD");
				apInvHdrVO.setInvDt( DateTime.getFormatDate( new Date(), "yyyyMMdd") );
				apInvHdrVO.setInvTermDt( DateTime.getFormatDate( new Date(), "yyyyMMdd") );
				apInvHdrVO.setGlDt(krWhfDecBzcInfoForApIfVO.getGlDt());
				apInvHdrVO.setVndrNo(krWhfDecBzcInfoForApIfVO.getVndrNo());
				apInvHdrVO.setCsrAmt("0");
				apInvHdrVO.setCsrCurrCd("KRW");
				apInvHdrVO.setVndrTermNm(krWhfDecBzcInfoForApIfVO.getVndrTermNm());
				apInvHdrVO.setInvDesc( krWhfDecCondVO.getWhfDeclNo());
				apInvHdrVO.setAttrCateNm("기타");
				apInvHdrVO.setAttrCtnt10(krWhfDecCondVO.getWhfUsrNm());
				apInvHdrVO.setAttrCtnt15("Y");
				apInvHdrVO.setSrcCtnt("NIS AR");
				apInvHdrVO.setPayMzdLuCd("WIRE");
				apInvHdrVO.setPayGrpLuCd("ZERO PAYMENT");
				apInvHdrVO.setCoaCoCd("01");
				apInvHdrVO.setCoaRgnCd("11");
				apInvHdrVO.setCoaCtrCd(krWhfDecBzcInfoForApIfVO.getApCtrCd());
				apInvHdrVO.setCoaAcctCd("210111");
				apInvHdrVO.setCoaVvdCd("0000000000");
				apInvHdrVO.setCoaInterCoCd("00");
				apInvHdrVO.setCoaFtuN1stCd("000000");
				apInvHdrVO.setCoaFtuN2ndCd("000000");
				apInvHdrVO.setAproFlg("Y");
				apInvHdrVO.setErrCsrNo(" ");
				apInvHdrVO.setTjOfcCd(krWhfDecCondVO.getWhfDeclOfcCd());
				apInvHdrVO.setCreDt(DateTime.getFormatDate( new Date(), "yyyyMMdd") );
				apInvHdrVO.setCreUsrId(account.getUsr_id());
				apInvHdrVO.setAttrCtnt11      (orgCsrNo);
				/*
				 * Create Header [end]
				 */
				apInvHdrVOs.add(apInvHdrVO);

				/*
				 * Create Distribute [start] 1st
				 */
				String sDtrbCoaAcctCd = "211541";
				String sDtrbCoaAcctCdForTruncatedAmt = "422011";
				String sAttrCateNm    = "211541";
				// Port Code 를 보내주어야 한다고 함.
	//			String sAttrCntt3     = krWhfDecCondVO.getWhfDeclNo().substring(0,5);
				String sAttrCntt3     = krWhfDecCondVO.getPortCd();
//				List<ApInvDtrbVO> apInvDtrbVOs = new ArrayList<ApInvDtrbVO>();




				ApInvDtrbVO apInvDtrbVO = new ApInvDtrbVO();
				apInvDtrbVO.setCsrNo           (sCsrNo);
				apInvDtrbVO.setLineSeq         ("0001");
				apInvDtrbVO.setLineNo          ("0001");
				apInvDtrbVO.setLineTpLuCd      ("ITEM");
				apInvDtrbVO.setInvAmt          ( totalAmount );
				apInvDtrbVO.setInvDesc         ( krWhfDecCondVO.getWhfDeclNo());
				apInvDtrbVO.setDtrbCoaCoCd     ("01");
				apInvDtrbVO.setDtrbCoaRgnCd    ("11");
				apInvDtrbVO.setDtrbCoaCtrCd    (krWhfDecBzcInfoForApIfVO.getApCtrCd());
				apInvDtrbVO.setDtrbCoaAcctCd   (sDtrbCoaAcctCd);
				apInvDtrbVO.setDtrbCoaVvdCd    ("0000000000");
				apInvDtrbVO.setDtrbCoaInterCoCd("00");
				apInvDtrbVO.setDtrbCoaFtuN1stCd("000000");
				apInvDtrbVO.setDtrbCoaFtuN2ndCd("000000");
				apInvDtrbVO.setAttrCateNm      (sAttrCateNm);
				apInvDtrbVO.setAttrCtnt3       (sAttrCntt3);
				apInvDtrbVO.setActVvdCd        (sRevenueVvd);
				apInvDtrbVO.setPlnSctrDivCd    (" ");
				apInvDtrbVO.setCreDt           ("SYSDATE");
				apInvDtrbVO.setCreUsrId        (account.getUsr_id());
				apInvDtrbVO.setAttrCtnt11      (orgCsrNo);

				/*
				 * Create Distribute [end]
				 */
				apInvDtrbVOs.add(apInvDtrbVO);
				/*
				 * Create Distribute [start] WHF 비관리청항만매출채권 INSERT
				 */



				ApInvDtrbVO apInvDtrbVO2 = new ApInvDtrbVO();
				apInvDtrbVO2.setCsrNo           (sCsrNo);
				apInvDtrbVO2.setLineSeq         ("0002");
				apInvDtrbVO2.setLineNo          ("0002");
				apInvDtrbVO2.setLineTpLuCd      ("ITEM");
				apInvDtrbVO2.setInvAmt          ( ntcAmount );
				apInvDtrbVO2.setInvDesc         ( krWhfDecCondVO.getWhfDeclNo());
				apInvDtrbVO2.setDtrbCoaCoCd     ("01");
				apInvDtrbVO2.setDtrbCoaRgnCd    ("11");
				apInvDtrbVO2.setDtrbCoaCtrCd    (krWhfDecBzcInfoForApIfVO.getApCtrCd());
				apInvDtrbVO2.setDtrbCoaAcctCd   ("111211");
				apInvDtrbVO2.setDtrbCoaVvdCd    ("0000000000");
				apInvDtrbVO2.setDtrbCoaInterCoCd("00");
				apInvDtrbVO2.setDtrbCoaFtuN1stCd("000000");
				apInvDtrbVO2.setDtrbCoaFtuN2ndCd("000000");
				apInvDtrbVO2.setAttrCateNm      ("111211");
				apInvDtrbVO2.setAttrCtnt3       (sAttrCntt3);
				apInvDtrbVO2.setActVvdCd        (sRevenueVvd);
				apInvDtrbVO2.setPlnSctrDivCd    (" ");
				apInvDtrbVO2.setCreDt           ("SYSDATE");
				apInvDtrbVO2.setCreUsrId        (account.getUsr_id());
				apInvDtrbVO2.setAttrCtnt11       (orgCsrNo);

				/*
				 * Create Distribute [end]
				 */
				apInvDtrbVOs.add(apInvDtrbVO2);


				if( Float.parseFloat( krWhfDecCondVO.getRducAmt() ) > 0 ){

					/*
					 * Create Distribute [start] 절사금액 INSERT
					 */


					ApInvDtrbVO apInvDtrbVO3 = new ApInvDtrbVO();
					apInvDtrbVO3.setCsrNo           (sCsrNo);
					apInvDtrbVO3.setLineSeq         ("0003");
					apInvDtrbVO3.setLineNo          ("0003");
					apInvDtrbVO3.setLineTpLuCd      ("ITEM");
					apInvDtrbVO3.setInvAmt          ( rducAmt );
					apInvDtrbVO3.setInvDesc         ( krWhfDecCondVO.getWhfDeclNo());
					apInvDtrbVO3.setDtrbCoaCoCd     ("01");
					apInvDtrbVO3.setDtrbCoaRgnCd    ("11");
					apInvDtrbVO3.setDtrbCoaCtrCd    (krWhfDecBzcInfoForApIfVO.getApCtrCd());
					apInvDtrbVO3.setDtrbCoaAcctCd   (sDtrbCoaAcctCdForTruncatedAmt);
					apInvDtrbVO3.setDtrbCoaVvdCd    (sRevenueVvd);
					apInvDtrbVO3.setDtrbCoaInterCoCd("00");
					apInvDtrbVO3.setDtrbCoaFtuN1stCd("000000");
					apInvDtrbVO3.setDtrbCoaFtuN2ndCd("000000");
					apInvDtrbVO3.setAttrCateNm      (sDtrbCoaAcctCdForTruncatedAmt);
					apInvDtrbVO3.setAttrCtnt3       (sAttrCntt3);
					apInvDtrbVO3.setActVvdCd        (sRevenueVvd);
					apInvDtrbVO3.setPlnSctrDivCd    (" ");
					apInvDtrbVO3.setCreDt           ("SYSDATE");
					apInvDtrbVO3.setCreUsrId        (account.getUsr_id());
					apInvDtrbVO3.setAttrCtnt11      (orgCsrNo);
					/*
					 * Create Distribute [end]
					 */
					apInvDtrbVOs.add(apInvDtrbVO3);

				}

				dbDao.addApInvHdrList(apInvHdrVOs);

				dbDao.addApInvDtrbList(apInvDtrbVOs);

				List<SearchApSlipInterfaceListVO> searchApSlipInterfaceListVOs = new ArrayList<SearchApSlipInterfaceListVO>();
				for (Iterator<ApInvDtrbVO> iterator = apInvDtrbVOs.iterator(); iterator.hasNext();) {
					ApInvDtrbVO tempApInvDtrbVO = iterator.next();
					SearchApSlipInterfaceListVO searchApSlipInterfaceListVO1 = new SearchApSlipInterfaceListVO();

					/*
					 * HEADER
					 */
					searchApSlipInterfaceListVO1.setHdrCsrNo       ( apInvHdrVO.getCsrNo       () );
					searchApSlipInterfaceListVO1.setHdrCsrTpCd     ( apInvHdrVO.getCsrTpCd     () );
					searchApSlipInterfaceListVO1.setHdrInvDt       ( apInvHdrVO.getInvDt       () ); //관통 테스트  //("20150803");
					searchApSlipInterfaceListVO1.setHdrInvTermDt   ( apInvHdrVO.getInvTermDt   () );
					searchApSlipInterfaceListVO1.setHdrGlDt        ( apInvHdrVO.getGlDt        () ); //관통 테스트   //("20150803");
					searchApSlipInterfaceListVO1.setHdrVndrNo      ( apInvHdrVO.getVndrNo      () );
					searchApSlipInterfaceListVO1.setHdrCsrAmt      ( apInvHdrVO.getCsrAmt      () );
					searchApSlipInterfaceListVO1.setHdrCsrCurrCd   ( apInvHdrVO.getCsrCurrCd   () );
					searchApSlipInterfaceListVO1.setHdrVndrTermNm  ( apInvHdrVO.getVndrTermNm  () );
					searchApSlipInterfaceListVO1.setHdrInvDesc     ( apInvHdrVO.getInvDesc     () );
					searchApSlipInterfaceListVO1.setHdrAttrCateNm  ( apInvHdrVO.getAttrCateNm  () );
					searchApSlipInterfaceListVO1.setHdrAttrCtnt10  ( apInvHdrVO.getAttrCtnt10  () );
					searchApSlipInterfaceListVO1.setHdrAttrCtnt15  ( apInvHdrVO.getAttrCtnt15  () );
					searchApSlipInterfaceListVO1.setHdrSrcCtnt     ( apInvHdrVO.getSrcCtnt     () );
					searchApSlipInterfaceListVO1.setHdrPayMzdLuCd  ( apInvHdrVO.getPayMzdLuCd  () );
					searchApSlipInterfaceListVO1.setHdrPayGrpLuCd  ( apInvHdrVO.getPayGrpLuCd  () );
					searchApSlipInterfaceListVO1.setHdrCoaCoCd     ( apInvHdrVO.getCoaCoCd     () );
					searchApSlipInterfaceListVO1.setHdrCoaRgnCd    ( apInvHdrVO.getCoaRgnCd    () );
					searchApSlipInterfaceListVO1.setHdrCoaCtrCd    ( apInvHdrVO.getCoaCtrCd    () );
					searchApSlipInterfaceListVO1.setHdrCoaAcctCd   ( apInvHdrVO.getCoaAcctCd   () );
					searchApSlipInterfaceListVO1.setHdrCoaVvdCd    ( apInvHdrVO.getCoaVvdCd    () );
					searchApSlipInterfaceListVO1.setHdrCoaInterCoCd( apInvHdrVO.getCoaInterCoCd() );
					searchApSlipInterfaceListVO1.setHdrCoaFtuN1stCd( apInvHdrVO.getCoaFtuN1stCd() );
					searchApSlipInterfaceListVO1.setHdrCoaFtuN2ndCd( apInvHdrVO.getCoaFtuN2ndCd() );
					searchApSlipInterfaceListVO1.setHdrAproFlg     ( apInvHdrVO.getAproFlg     () );
					searchApSlipInterfaceListVO1.setHdrErrCsrNo    ( apInvHdrVO.getErrCsrNo    () );
					searchApSlipInterfaceListVO1.setHdrTjOfcCd     ( apInvHdrVO.getTjOfcCd     () );
					searchApSlipInterfaceListVO1.setHdrCreDt       ( apInvHdrVO.getCreDt       () );
					searchApSlipInterfaceListVO1.setHdrCreUsrId    ( apInvHdrVO.getCreUsrId    () );
					searchApSlipInterfaceListVO1.setHdrAttrCtnt11  ( apInvHdrVO.getAttrCtnt11  () );
					/*
					 * DETAIL
					 */
					searchApSlipInterfaceListVO1.setDCsrNo           ( tempApInvDtrbVO.getCsrNo           () );
					searchApSlipInterfaceListVO1.setDLineSeq         ( tempApInvDtrbVO.getLineSeq         () );
					searchApSlipInterfaceListVO1.setDLineNo          ( tempApInvDtrbVO.getLineNo          () );
					searchApSlipInterfaceListVO1.setDLineTpLuCd      ( tempApInvDtrbVO.getLineTpLuCd      () );
					searchApSlipInterfaceListVO1.setDInvAmt          ( tempApInvDtrbVO.getInvAmt          () );
					searchApSlipInterfaceListVO1.setDInvDesc         ( tempApInvDtrbVO.getInvDesc         () );
					searchApSlipInterfaceListVO1.setDDtrbCoaCoCd     ( tempApInvDtrbVO.getDtrbCoaCoCd     () );
					searchApSlipInterfaceListVO1.setDDtrbCoaRgnCd    ( tempApInvDtrbVO.getDtrbCoaRgnCd    () );
					searchApSlipInterfaceListVO1.setDDtrbCoaCtrCd    ( tempApInvDtrbVO.getDtrbCoaCtrCd    () );
					searchApSlipInterfaceListVO1.setDDtrbCoaAcctCd   ( tempApInvDtrbVO.getDtrbCoaAcctCd   () );
					searchApSlipInterfaceListVO1.setDDtrbCoaVvdCd    ( tempApInvDtrbVO.getDtrbCoaVvdCd    () );
					searchApSlipInterfaceListVO1.setDDtrbCoaInterCoCd( tempApInvDtrbVO.getDtrbCoaInterCoCd() );
					searchApSlipInterfaceListVO1.setDDtrbCoaFtuN1stCd( tempApInvDtrbVO.getDtrbCoaFtuN1stCd() );
					searchApSlipInterfaceListVO1.setDDtrbCoaFtuN2ndCd( tempApInvDtrbVO.getDtrbCoaFtuN2ndCd() );
					searchApSlipInterfaceListVO1.setDAttrCateNm      ( tempApInvDtrbVO.getAttrCateNm      () );
					searchApSlipInterfaceListVO1.setDAttrCtnt3       ( tempApInvDtrbVO.getAttrCtnt3       () );
					searchApSlipInterfaceListVO1.setDActVvdCd        ( tempApInvDtrbVO.getActVvdCd        () );
					searchApSlipInterfaceListVO1.setDPlnSctrDivCd    ( tempApInvDtrbVO.getPlnSctrDivCd    () );
					searchApSlipInterfaceListVO1.setDCreDt           ( tempApInvDtrbVO.getCreDt           () );
					searchApSlipInterfaceListVO1.setDCreUsrId        ( tempApInvDtrbVO.getCreUsrId        () );
					searchApSlipInterfaceListVO1.setDAttrCtnt11      ( tempApInvDtrbVO.getAttrCtnt11      () );

					searchApSlipInterfaceListVOs.add(searchApSlipInterfaceListVO1);
				}

				dbDao.addApInvIfSearch( sCsrNo, account.getUsr_id() );
				eaiDao.interfaceKrWhfToAp( sCsrNo, searchApSlipInterfaceListVOs );
			}


			return krWhfDecCondVO;

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG03061",new String[]{"AP"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG03061",new String[]{"AP"}).getMessage(), ex);
		}
	}

	/**
	 * Wharfage 신고 번호 변경 내역 인터페이스
	 *
	 * @param whfDecCondVO
	 * @param account
	 * @throws EventException
	 */
	@Override
	public void interfaceWhfCngNo(WhfDecCondVO whfDecCondVO, SignOnUserAccount account) throws EventException {
		try{

			dbDao.modifyBkgKrWhfRtWhfCngNo( (KrWhfDecCondVO)whfDecCondVO );

			manageWhfArInvIf( whfDecCondVO, account);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
	}

	/**
	 * Wharfage 신고 번호 변경 내역 인터페이스
	 *
	 * @param whfDecCondVO WhfDecCondVO
	 * @param account SignOnUserAccount
	 * @return
	 * @throws EventException
	 */
	private WhfDecCondVO manageWhfArInvIf(WhfDecCondVO whfDecCondVO, SignOnUserAccount account)throws EventException{
		try{

			KrWhfDecCondVO krWhfDecCondVO = (KrWhfDecCondVO)whfDecCondVO;
			List<KrWhfDecIfArInvVO> krWhfDecIfArInvVOs = dbDao.searchKrWhfDecIfArInv( krWhfDecCondVO );
			BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();

			String vvdCd = krWhfDecCondVO.getVvd();
			String whfBndCd =krWhfDecCondVO.getWhfBndCd();
			String portCd = krWhfDecCondVO.getPortCd();
			String cancelFlag = krWhfDecCondVO.getCancelFlag();

	        for (Iterator<KrWhfDecIfArInvVO> iterator = krWhfDecIfArInvVOs.iterator(); iterator.hasNext();) {
				KrWhfDecIfArInvVO krWhfDecIfArInvVO = iterator.next();


				BkgKrWhfRtVO bkgKrWhfRtVO = new BkgKrWhfRtVO();
				bkgKrWhfRtVO.setVslCd(krWhfDecIfArInvVO.getVslCd());
				bkgKrWhfRtVO.setSkdVoyNo(krWhfDecIfArInvVO.getSkdVoyNo());
				bkgKrWhfRtVO.setSkdDirCd(krWhfDecIfArInvVO.getSkdDirCd());
				bkgKrWhfRtVO.setWhfBndCd(krWhfDecIfArInvVO.getWhfBndCd());
				bkgKrWhfRtVO.setBlNo(krWhfDecIfArInvVO.getBlNo());
				bkgKrWhfRtVO.setChgRtSeq(krWhfDecIfArInvVO.getChgRtSeq());
				bkgKrWhfRtVO.setUpdUsrId(account.getUsr_id());

				bkgKrWhfRtVO.setPagerows(krWhfDecCondVO.getCancelFlag());

				dbDao.modifyBkgKrWhfRtIfArInv( bkgKrWhfRtVO );
			}


	        bookingARCreationBC.interfaceWHFARInvoiceToINV( vvdCd, whfBndCd, portCd, account.getUsr_id(), cancelFlag);


		} catch( EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return whfDecCondVO;
	}

	/**
	 * 확정된 한국 WHF 신고 금액을 AR로 인터페이스 함
	 *
	 * @param whfBlVOs WhfBlVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	@Override
	public String interfaceWhfToArInv(WhfBlVO[] whfBlVOs, SignOnUserAccount account) throws EventException {

		String sBAJobRtn = "";

		try{
			KrWhfBlContainerVO krWhfBlContainerVO = (KrWhfBlContainerVO)whfBlVOs[0];
			KrWhfBlInfoVO[] krWhfBlInfoVOs  = krWhfBlContainerVO.getKrWhfBlInfoVOs();
			KrWhfCgoClassCondVO krWhfCgoClassCondVO = krWhfBlContainerVO.getKrWhfCgoClassCondVO();
			BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
			KrWhfVslInfoCondVO krWhfVslInfoCondVO = new KrWhfVslInfoCondVO();
			ObjectCloner.build(krWhfCgoClassCondVO, krWhfVslInfoCondVO);

			if( dbDao.checkIfDecNoExist(krWhfVslInfoCondVO) ){
				throw new EventException(new ErrorHandler("BKG06103",new String[]{}).getMessage());
			}
			if( krWhfBlInfoVOs == null ){ // AL I/F ; Action 단에서 BL 정보를 담지 않으므로 사이즈가  0 이다.
				KrWhfDecCondVO krWhfDecCondVO = new KrWhfDecCondVO();
				ObjectCloner.build(krWhfCgoClassCondVO, krWhfDecCondVO);
				WhfDecCondVO condVO = manageWhfArInvIf((WhfDecCondVO)krWhfDecCondVO, account);
				sBAJobRtn = condVO.getSBAJobRtn();
			} else { // BL I/F
				BkgKrWhfRtVO bkgKrWhfRtVO = new BkgKrWhfRtVO();
				List<ARBkgInterfaceCreationVO> ListARBkgInterfaceCreationVO = new ArrayList<ARBkgInterfaceCreationVO>();
				for (int i = 0; i < krWhfBlInfoVOs.length; i++) {
					KrWhfBlInfoVO krWhfBlInfoVO = krWhfBlInfoVOs[i];
					ARBkgInterfaceCreationVO bkgInterfaceCreationVO = new ARBkgInterfaceCreationVO();
					bkgInterfaceCreationVO.setBkgNo(krWhfBlInfoVO.getBkgNo());
					bkgInterfaceCreationVO.setVvdCd(krWhfBlInfoVO.getVvd());
					bkgInterfaceCreationVO.setManDivInd("B");
					bkgInterfaceCreationVO.setUserId(account.getUsr_id());

					ListARBkgInterfaceCreationVO.add(bkgInterfaceCreationVO);

					bkgKrWhfRtVO.setVslCd(krWhfBlInfoVO.getVvd().substring(0, 4));
					bkgKrWhfRtVO.setSkdVoyNo(krWhfBlInfoVO.getVvd().substring(4, 8));
					bkgKrWhfRtVO.setSkdDirCd(krWhfBlInfoVO.getVvd().substring(8, 9));
					bkgKrWhfRtVO.setUpdUsrId(account.getUsr_id());
					bkgKrWhfRtVO.setWhfBndCd(krWhfBlInfoVO.getWhfBndCd());
					bkgKrWhfRtVO.setBlNo(krWhfBlInfoVO.getBlNo());
					dbDao.modifyBkgKrWhfRtIfArInv( bkgKrWhfRtVO );

				}
				sBAJobRtn = bookingARCreationBC.interfaceBKGARInvoiceToINV(ListARBkgInterfaceCreationVO);
			}
			return sBAJobRtn;

		} catch(DAOException dx) {
			log.error("err " + dx.toString(), dx);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), dx);
		} catch( EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), e);
		}

	}


	/**
	 * Wharfage 신고 인터페이스 History
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @param String returnValues
	 * @param String inUpCd
	 * @param String hisSeq
	 * @param SignOnUserAccount account
	 * @param String whfDeclIfFlg
	 * @throws EventException
	 */
	public String interfaceWhfDecHis (WhfDecCondVO whfDecCondVO , String returnValues, String inUpCd, String hisSeq, SignOnUserAccount account, String whfDeclIfFlg ) throws EventException {
		try {

			KrWhfDecCondVO krWhfDecCondVO = (KrWhfDecCondVO)whfDecCondVO;
			if ( "I".equals(inUpCd)){
				hisSeq = dbDao.addBkgKrWhfDecHis(krWhfDecCondVO, account);
			} else {
				dbDao.modifyWhfDecHis(krWhfDecCondVO, returnValues, hisSeq, whfDeclIfFlg );
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return hisSeq;
	}


	/**
	 * Wharfage 신고 인터페이스 구동중인지 Check
	 *
	 * @param WhfDecCondVO whfDecCondVO
	 * @throws EventException
	 */
	public String interfaceWhfDecChk (WhfDecCondVO whfDecCondVO) throws EventException {
		try {
			KrWhfDecCondVO krWhfDecCondVO = (KrWhfDecCondVO)whfDecCondVO;
			int iKrWhfDecKnt = 1;
			String actionFlg = dbDao.searchKrWhfDecHisChk(krWhfDecCondVO);
			if("Y".equals(krWhfDecCondVO.getCancelFlag())){  // Dec I/F 시
				iKrWhfDecKnt = dbDao.searchKrWhfDecKnt( krWhfDecCondVO );
				if ( iKrWhfDecKnt == 0 ){
					return "0";
				}
			}
			if ("Y".equals(actionFlg)){
				return "Y";
			}else{
				return "N";
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
	}
	/**
	 * BackEndJob을 실행.
	 *
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 *
	 */
	public String startBackEndJob(SignOnUserAccount account, WhfDecCondVO whfDecCondVO, String pgmNo )  throws EventException{

		String resultStr = "";

		if(pgmNo.equals("ESM_BKG_0557")) {
			KrWharfageDecMgtBackEndJob backEndJob = new KrWharfageDecMgtBackEndJob();
			backEndJob.setPgmNo(pgmNo);
			backEndJob.setWhfDecCondVO(whfDecCondVO);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "KOR EDI Transmit");
		}

		return resultStr;
	}
}