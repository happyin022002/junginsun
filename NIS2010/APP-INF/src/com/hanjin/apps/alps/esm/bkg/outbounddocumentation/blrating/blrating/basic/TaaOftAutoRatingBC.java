/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TaaOftAutoRatingBC.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.27
 *@LastModifier : 김태경
 *@LastVersion : 1.0
 * 2009.12.27 김태경
 * 1.0 Creation
 * 
 * 2012.11.29 조정민 [CHM-201221300] TAA 계약 존재시 bkg 생성및 변경시점 Rate 유무 체크 및 G/W 연계 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-TaaOftAutoRating Business Logic Command Interface<br>
 * - NIS2010-TaaOftAutoRating 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author LEE JINSEO
 * @see Esm_bkg_1076EventResponse 참조
 * @since J2EE 1.6
 */

public interface TaaOftAutoRatingBC {

	/**
	 * EsmBkg1076 조회 이벤트 처리<br>
	 * Booking TAA 화면에 대한  Surcharge 값을 구해옴 <br>
	 * 
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
	 * @param String scpCd
	 * @param String cmdtCd
	 * @param String ctrtTpCd
	 * @return List<SearchTaaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchTaaOftAutoratingListVO> searchSurchargeAutoratingList(String bkgNo, String caFlag, String scpCd, String cmdtCd, String ctrtTpCd) throws EventException;
	
	/**
	 * EsmBkg1076 조회 이벤트 처리<br>
	 * Booking TAA 화면에 대한  booking에 대해 운임을 표기해주며,INV System에 중간 Table에 넣어준다 <br>
	 * Booking no에 해당되는 TAA No중에서 미주향발 Cargo에 대한 운임 산정 서비스호출

	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String caFlag
 	 * @param String taaNo
	 * @param String rtaplydt
	 * @param String scpCd
	 * @param String cmdtCd
	 * @return List<SearchTaaOftAutoratingListVO>
	 * @exception EventException
	 */
	public List<SearchTaaOftAutoratingListVO> searchTaaOftAutoratingList (String bkgNo, String caFlag, String taaNo, String rtaplydt, String scpCd, String cmdtCd) throws EventException;

	
	/**
	 * EsmBkg007901 searchPreCheckRtAplyDt 조회 이벤트 처리
	 * Taa OFT계산 가능 여부를 확인하기를 위해 Rate Application Date를 YYYYMMDD 형식으로 조회
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return String
	 * @throws EventException
	 */
	public String searchPreCheckRtAplyDt(String bkgNo ,String caFlg ) throws EventException;
	
	/**
	 * EsmBkg007901 checkOftRateMatch 조회 이벤트 처리
	 * Taa OFT계산결과를 체크한다.
	 * @param String bkgNo
	 * @param String caFlg 
	 * @return String
	 * @throws EventException
	 */
	public String checkOftRateMatch(String bkgNo, String caFlg) throws EventException;
	
}