/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CBFSummaryVO.java
*@FileTitle : CBFSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.02.18 김현욱 
* 1.0 Creation
* 2013.06.18 SKY [CHM-201324915}: [VOP-OPF] CBF – POD TMNL code로 구분
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김현욱
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CBFSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CBFSummaryVO> models = new ArrayList<CBFSummaryVO>();
	
	/* Column Info */
	private String bb2hOpr10 = null;
	/* Column Info */
	private String fm = null;
	/* Column Info */
	private String opr5Wgt4 = null;
	/* Column Info */
	private String opr5Wgt2 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String opr8Wgt4h = null;
	/* Column Info */
	private String opr10Wgt4 = null;
	/* Column Info */
	private String ak20Tot = null;
	/* Column Info */
	private String ak2hOpr10 = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String ak40Opr10 = null;
	/* Column Info */
	private String opr10Wgt2 = null;
	/* Column Info */
	private String opr8Wgt45 = null;
	/* Column Info */
	private String opr8Wgt2h = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String opr3Wgt2 = null;
	/* Column Info */
	private String rf2hTot = null;
	/* Column Info */
	private String opr3Wgt4 = null;
	/* Column Info */
	private String opr2Wgt2 = null;
	/* Column Info */
	private String ak20Opr10 = null;
	/* Column Info */
	private String opr5Teu = null;
	/* Column Info */
	private String totWgt45 = null;
	/* Column Info */
	private String opr2Wgt4 = null;
	/* Column Info */
	private String totWgt2h = null;
	/* Column Info */
	private String opr5Qty2 = null;
	/* Column Info */
	private String opr5Qty4 = null;
	/* Column Info */
	private String bb20Opr7 = null;
	/* Column Info */
	private String opr3Teu = null;
	/* Column Info */
	private String bb20Opr8 = null;
	/* Column Info */
	private String opr6Qty4h = null;
	/* Column Info */
	private String bb20Opr9 = null;
	/* Column Info */
	private String bb20Opr3 = null;
	/* Column Info */
	private String totWgt4h = null;
	/* Column Info */
	private String bb20Opr4 = null;
	/* Column Info */
	private String rf40Tot = null;
	/* Column Info */
	private String bb20Opr5 = null;
	/* Column Info */
	private String bb20Opr6 = null;
	/* Column Info */
	private String opr10Qty2h = null;
	/* Column Info */
	private String opr2Wgt2h = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String opr1Qty2 = null;
	/* Column Info */
	private String qty10 = null;
	/* Column Info */
	private String opr1Qty4 = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dg45Opr8 = null;
	/* Column Info */
	private String dg45Opr7 = null;
	/* Column Info */
	private String dg45Opr6 = null;
	/* Column Info */
	private String rf20Opr10 = null;
	/* Column Info */
	private String dg45Opr5 = null;
	/* Column Info */
	private String dg45Opr9 = null;
	/* Column Info */
	private String bb20Opr2 = null;
	/* Column Info */
	private String dg45Opr4 = null;
	/* Column Info */
	private String bb20Opr1 = null;
	/* Column Info */
	private String dg45Opr3 = null;
	/* Column Info */
	private String dg45Opr2 = null;
	/* Column Info */
	private String dg45Opr1 = null;
	/* Column Info */
	private String dg40Tot = null;
	/* Column Info */
	private String opr6Qty2h = null;
	/* Column Info */
	private String opr5Wgt4h = null;
	/* Column Info */
	private String bb45Opr10 = null;
	/* Column Info */
	private String dg40Opr10 = null;
	/* Column Info */
	private String totTeu = null;
	/* Column Info */
	private String stwgCgoFlg = null;
	/* Column Info */
	private String opr6Qty45 = null;
	/* Column Info */
	private String dg4hOpr10 = null;
	/* Column Info */
	private String opr8Wgt2 = null;
	/* Column Info */
	private String opr8Wgt4 = null;
	/* Column Info */
	private String cbfIndFlg = null;
	/* Column Info */
	private String rf4hOpr3 = null;
	/* Column Info */
	private String bb4hOpr9 = null;
	/* Column Info */
	private String rf4hOpr4 = null;
	/* Column Info */
	private String rf4hOpr1 = null;
	/* Column Info */
	private String rf4hOpr2 = null;
	/* Column Info */
	private String bb4hOpr5 = null;
	/* Column Info */
	private String rf4hOpr7 = null;
	/* Column Info */
	private String bb4hOpr6 = null;
	/* Column Info */
	private String rf4hOpr8 = null;
	/* Column Info */
	private String rf4hOpr5 = null;
	/* Column Info */
	private String bb4hOpr7 = null;
	/* Column Info */
	private String rf4hOpr6 = null;
	/* Column Info */
	private String bb4hOpr8 = null;
	/* Column Info */
	private String opr3Qty45 = null;
	/* Column Info */
	private String bb4hOpr1 = null;
	/* Column Info */
	private String bb4hOpr2 = null;
	/* Column Info */
	private String ak20Opr9 = null;
	/* Column Info */
	private String opr4Wgt2h = null;
	/* Column Info */
	private String bb4hOpr3 = null;
	/* Column Info */
	private String bb4hOpr4 = null;
	/* Column Info */
	private String opr9Qty2 = null;
	/* Column Info */
	private String opr9Qty4 = null;
	/* Column Info */
	private String ak20Opr1 = null;
	/* Column Info */
	private String ak20Opr2 = null;
	/* Column Info */
	private String ak20Opr3 = null;
	/* Column Info */
	private String ak20Opr4 = null;
	/* Column Info */
	private String ak20Opr5 = null;
	/* Column Info */
	private String ak20Opr6 = null;
	/* Column Info */
	private String opr3Qty2h = null;
	/* Column Info */
	private String ak20Opr7 = null;
	/* Column Info */
	private String ak20Opr8 = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String opr4Qty4h = null;
	/* Column Info */
	private String rf4hOpr9 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ak45Opr7 = null;
	/* Column Info */
	private String ak45Opr6 = null;
	/* Column Info */
	private String opr8Qty2h = null;
	/* Column Info */
	private String ak45Opr9 = null;
	/* Column Info */
	private String ak45Opr8 = null;
	/* Column Info */
	private String totTtl = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String opr8Qty45 = null;
	/* Column Info */
	private String ak45Opr1 = null;
	/* Column Info */
	private String ak45Opr2 = null;
	/* Column Info */
	private String ak45Opr3 = null;
	/* Column Info */
	private String ak45Opr4 = null;
	/* Column Info */
	private String ak45Opr5 = null;
	/* Column Info */
	private String bb2hOpr9 = null;
	/* Column Info */
	private String bb2hOpr8 = null;
	/* Column Info */
	private String bb2hOpr7 = null;
	/* Column Info */
	private String bb2hOpr6 = null;
	/* Column Info */
	private String bb2hOpr5 = null;
	/* Column Info */
	private String bb2hOpr4 = null;
	/* Column Info */
	private String bb2hOpr3 = null;
	/* Column Info */
	private String bb2hOpr2 = null;
	/* Column Info */
	private String bb2hOpr1 = null;
	/* Column Info */
	private String opr4Wgt4h = null;
	/* Column Info */
	private String opr10Qty45 = null;
	/* Column Info */
	private String opr3Qty4h = null;
	/* Column Info */
	private String opr6Wgt2 = null;
	/* Column Info */
	private String dg2hTot = null;
	/* Column Info */
	private String opr6Wgt4 = null;
	/* Column Info */
	private String ak45Tot = null;
	/* Column Info */
	private String rf4hTot = null;
	/* Column Info */
	private String opr10Qty4h = null;
	/* Column Info */
	private String rf45Opr3 = null;
	/* Column Info */
	private String rf45Opr2 = null;
	/* Column Info */
	private String rf45Opr1 = null;
	/* Column Info */
	private String opr4Wgt45 = null;
	/* Column Info */
	private String rf45Opr7 = null;
	/* Column Info */
	private String rf45Opr6 = null;
	/* Column Info */
	private String rf45Opr5 = null;
	/* Column Info */
	private String bb40Opr9 = null;
	/* Column Info */
	private String rf45Opr4 = null;
	/* Column Info */
	private String bb40Opr7 = null;
	/* Column Info */
	private String bb40Opr8 = null;
	/* Column Info */
	private String bb40Opr5 = null;
	/* Column Info */
	private String rf45Opr9 = null;
	/* Column Info */
	private String bb40Opr6 = null;
	/* Column Info */
	private String rf45Opr8 = null;
	/* Column Info */
	private String totQty2h = null;
	/* Column Info */
	private String opr1Qty4h = null;
	/* Column Info */
	private String rf40Opr1 = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String rf40Opr2 = null;
	/* Column Info */
	private String rf40Opr3 = null;
	/* Column Info */
	private String rf40Opr4 = null;
	/* Column Info */
	private String rf40Opr5 = null;
	/* Column Info */
	private String rf40Opr6 = null;
	/* Column Info */
	private String dg20Tot = null;
	/* Column Info */
	private String rf40Opr7 = null;
	/* Column Info */
	private String rf40Opr8 = null;
	/* Column Info */
	private String rf40Opr9 = null;
	/* Column Info */
	private String bb40Opr1 = null;
	/* Column Info */
	private String totQty45 = null;
	/* Column Info */
	private String bb40Opr2 = null;
	/* Column Info */
	private String bb40Opr3 = null;
	/* Column Info */
	private String bb40Opr4 = null;
	/* Column Info */
	private String bb40Tot = null;
	/* Column Info */
	private String opr7Qty2h = null;
	/* Column Info */
	private String bb20Opr10 = null;
	/* Column Info */
	private String opr7Qty45 = null;
	/* Column Info */
	private String rf45Opr10 = null;
	/* Column Info */
	private String bb20Tot = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String totQty2 = null;
	/* Column Info */
	private String totQty4 = null;
	/* Column Info */
	private String opr8Qty4h = null;
	/* Column Info */
	private String bkgShprOwnrFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String opr7Qty4h = null;
	/* Column Info */
	private String rf40Opr10 = null;
	/* Column Info */
	private String pcCgoFlg = null;
	/* Column Info */
	private String ak45Opr10 = null;
	/* Column Info */
	private String opr10Teu = null;
	/* Column Info */
	private String opr1Wgt2h = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String opr7Wgt45 = null;
	/* Column Info */
	private String ak4hOpr2 = null;
	/* Column Info */
	private String ak4hOpr1 = null;
	/* Column Info */
	private String opr10Wgt4h = null;
	/* Column Info */
	private String opr7Wgt2h = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String dg45Opr10 = null;
	/* Column Info */
	private String wg = null;
	/* Column Info */
	private String opr10Qty4 = null;
	/* Column Info */
	private String opr10Qty2 = null;
	/* Column Info */
	private String bb4hOpr10 = null;
	/* Column Info */
	private String ak4hOpr5 = null;
	/* Column Info */
	private String ak4hOpr6 = null;
	/* Column Info */
	private String ak4hOpr3 = null;
	/* Column Info */
	private String crrCd2 = null;
	/* Column Info */
	private String ak4hOpr4 = null;
	/* Column Info */
	private String ak4hOpr9 = null;
	/* Column Info */
	private String ak4hOpr7 = null;
	/* Column Info */
	private String opr1Qty45 = null;
	/* Column Info */
	private String ak4hOpr8 = null;
	/* Column Info */
	private String opr8Teu = null;
	/* Column Info */
	private String opr10 = null;
	/* Column Info */
	private String opr1Qty2h = null;
	/* Column Info */
	private String opr1Wgt45 = null;
	/* Column Info */
	private String sort = null;
	/* Column Info */
	private String opr1Teu = null;
	/* Column Info */
	private String rf45Tot = null;
	/* Column Info */
	private String opr7Wgt4h = null;
	/* Column Info */
	private String opr4Qty2 = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String totQty4h = null;
	/* Column Info */
	private String bb40Opr10 = null;
	/* Column Info */
	private String opr2Qty4 = null;
	/* Column Info */
	private String opr2Qty2 = null;
	/* Column Info */
	private String opr9Wgt2 = null;
	/* Column Info */
	private String stwgNm = null;
	/* Column Info */
	private String opr9Wgt4 = null;
	/* Column Info */
	private String opr1Wgt4 = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String opr1Wgt2 = null;
	/* Column Info */
	private String opr7Wgt4 = null;
	/* Column Info */
	private String opr7Wgt2 = null;
	/* Column Info */
	private String opr8Qty4 = null;
	/* Column Info */
	private String opr8Qty2 = null;
	/* Column Info */
	private String opr4Qty4 = null;
	/* Column Info */
	private String opr9Qty2h = null;
	/* Column Info */
	private String opr7Teu = null;
	/* Column Info */
	private String opr9Qty45 = null;
	/* Column Info */
	private String unit2 = null;
	/* Column Info */
	private String unit4 = null;
	/* Column Info */
	private String opr6Teu = null;
	/* Column Info */
	private String opr4Teu = null;
	/* Column Info */
	private String opr3Qty4 = null;
	/* Column Info */
	private String opr1Wgt4h = null;
	/* Column Info */
	private String opr10Wgt45 = null;
	/* Column Info */
	private String opr10Wgt2h = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String opr7 = null;
	/* Column Info */
	private String opr8 = null;
	/* Column Info */
	private String opr5 = null;
	/* Column Info */
	private String opr6 = null;
	/* Column Info */
	private String opr3 = null;
	/* Column Info */
	private String opr4 = null;
	/* Column Info */
	private String opr1 = null;
	/* Column Info */
	private String opr2 = null;
	/* Column Info */
	private String opr4Wgt4 = null;
	/* Column Info */
	private String opr4Wgt2 = null;
	/* Column Info */
	private String opr4Qty2h = null;
	/* Column Info */
	private String opr9 = null;
	/* Column Info */
	private String opr4Qty45 = null;
	/* Column Info */
	private String rf2hOpr2 = null;
	/* Column Info */
	private String opr6Qty4 = null;
	/* Column Info */
	private String rf2hOpr1 = null;
	/* Column Info */
	private String opr6Qty2 = null;
	/* Column Info */
	private String opr5Qty2h = null;
	/* Column Info */
	private String rf2hOpr6 = null;
	/* Column Info */
	private String opr2Qty2h = null;
	/* Column Info */
	private String rf2hOpr5 = null;
	/* Column Info */
	private String rf2hOpr4 = null;
	/* Column Info */
	private String rf4hOpr10 = null;
	/* Column Info */
	private String rf2hOpr3 = null;
	/* Column Info */
	private String rf20Opr8 = null;
	/* Column Info */
	private String rf20Opr7 = null;
	/* Column Info */
	private String rf20Opr9 = null;
	/* Column Info */
	private String rf20Opr4 = null;
	/* Column Info */
	private String dg40Opr5 = null;
	/* Column Info */
	private String rf2hOpr9 = null;
	/* Column Info */
	private String ak4hTot = null;
	/* Column Info */
	private String opr2Qty45 = null;
	/* Column Info */
	private String rf20Opr3 = null;
	/* Column Info */
	private String dg40Opr4 = null;
	/* Column Info */
	private String qty1 = null;
	/* Column Info */
	private String dg40Opr3 = null;
	/* Column Info */
	private String rf20Opr6 = null;
	/* Column Info */
	private String rf2hOpr7 = null;
	/* Column Info */
	private String dg40Opr2 = null;
	/* Column Info */
	private String rf20Opr5 = null;
	/* Column Info */
	private String rf2hOpr8 = null;
	/* Column Info */
	private String qty3 = null;
	/* Column Info */
	private String dg40Opr9 = null;
	/* Column Info */
	private String qty2 = null;
	/* Column Info */
	private String dg40Opr8 = null;
	/* Column Info */
	private String opr5Qty45 = null;
	/* Column Info */
	private String qty5 = null;
	/* Column Info */
	private String rf20Opr2 = null;
	/* Column Info */
	private String dg40Opr7 = null;
	/* Column Info */
	private String qty4 = null;
	/* Column Info */
	private String rf20Opr1 = null;
	/* Column Info */
	private String dg40Opr6 = null;
	/* Column Info */
	private String opr9Wgt45 = null;
	/* Column Info */
	private String dg4hOpr1 = null;
	/* Column Info */
	private String opr3Qty2 = null;
	/* Column Info */
	private String dg4hOpr7 = null;
	/* Column Info */
	private String dg4hOpr6 = null;
	/* Column Info */
	private String dg4hOpr9 = null;
	/* Column Info */
	private String dg4hOpr8 = null;
	/* Column Info */
	private String dg4hOpr3 = null;
	/* Column Info */
	private String opr2Teu = null;
	/* Column Info */
	private String dg4hOpr2 = null;
	/* Column Info */
	private String opr9Wgt2h = null;
	/* Column Info */
	private String dg4hOpr5 = null;
	/* Column Info */
	private String dg4hOpr4 = null;
	/* Column Info */
	private String ak4hOpr10 = null;
	/* Column Info */
	private String dg20Opr10 = null;
	/* Column Info */
	private String opr2Qty4h = null;
	/* Column Info */
	private String opr2Wgt4h = null;
	/* Column Info */
	private String opr7Qty4 = null;
	/* Column Info */
	private String opr7Qty2 = null;
	/* Column Info */
	private String dg20Opr1 = null;
	/* Column Info */
	private String dg20Opr3 = null;
	/* Column Info */
	private String dg20Opr2 = null;
	/* Column Info */
	private String dg2hOpr10 = null;
	/* Column Info */
	private String dg20Opr5 = null;
	/* Column Info */
	private String dg20Opr4 = null;
	/* Column Info */
	private String dg20Opr7 = null;
	/* Column Info */
	private String dg20Opr6 = null;
	/* Column Info */
	private String dg20Opr9 = null;
	/* Column Info */
	private String dg20Opr8 = null;
	/* Column Info */
	private String dg4hTot = null;
	/* Column Info */
	private String qty8 = null;
	/* Column Info */
	private String qty9 = null;
	/* Column Info */
	private String qty6 = null;
	/* Column Info */
	private String qty7 = null;
	/* Column Info */
	private String dg2hOpr4 = null;
	/* Column Info */
	private String dg2hOpr5 = null;
	/* Column Info */
	private String dg2hOpr6 = null;
	/* Column Info */
	private String dg2hOpr7 = null;
	/* Column Info */
	private String opr2Wgt45 = null;
	/* Column Info */
	private String dg2hOpr1 = null;
	/* Column Info */
	private String dg2hOpr2 = null;
	/* Column Info */
	private String dg2hOpr3 = null;
	/* Column Info */
	private String opr9Qty4h = null;
	/* Column Info */
	private String opr6Wgt2h = null;
	/* Column Info */
	private String opr6Wgt45 = null;
	/* Column Info */
	private String dg2hOpr8 = null;
	/* Column Info */
	private String dg2hOpr9 = null;
	/* Column Info */
	private String rf20Tot = null;
	/* Column Info */
	private String totWgt2 = null;
	/* Column Info */
	private String opr3Wgt2h = null;
	/* Column Info */
	private String totWgt4 = null;
	/* Column Info */
	private String mlb = null;
	/* Column Info */
	private String bb45Opr1 = null;
	/* Column Info */
	private String opr3Wgt45 = null;
	/* Column Info */
	private String bb45Opr3 = null;
	/* Column Info */
	private String bb45Opr2 = null;
	/* Column Info */
	private String bb45Opr5 = null;
	/* Column Info */
	private String bb45Opr4 = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String bb45Opr7 = null;
	/* Column Info */
	private String bb45Opr6 = null;
	/* Column Info */
	private String bb45Opr9 = null;
	/* Column Info */
	private String bb45Opr8 = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String opr6Wgt4h = null;
	/* Column Info */
	private String avWgt2 = null;
	/* Column Info */
	private String avWgt4 = null;
	/* Column Info */
	private String ak40Tot = null;
	/* Column Info */
	private String ak40Opr7 = null;
	/* Column Info */
	private String ak40Opr8 = null;
	/* Column Info */
	private String rf2hOpr10 = null;
	/* Column Info */
	private String ak40Opr9 = null;
	/* Column Info */
	private String opr5Wgt2h = null;
	/* Column Info */
	private String ak40Opr3 = null;
	/* Column Info */
	private String ak40Opr4 = null;
	/* Column Info */
	private String ak40Opr5 = null;
	/* Column Info */
	private String opr5Qty4h = null;
	/* Column Info */
	private String ak40Opr6 = null;
	/* Column Info */
	private String ak40Opr1 = null;
	/* Column Info */
	private String ak40Opr2 = null;
	/* Column Info */
	private String opr3Wgt4h = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String opr9Teu = null;
	/* Column Info */
	private String mlbCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String opr9Wgt4h = null;
	/* Column Info */
	private String dg40Opr1 = null;
	/* Column Info */
	private String opr5Wgt45 = null;
	/* Column Info */
	private String ak2hOpr2 = null;
	/* Column Info */
	private String ak2hOpr1 = null;
	/* Column Info */
	private String ak2hOpr4 = null;
	/* Column Info */
	private String ak2hOpr3 = null;
	/* Column Info */
	private String ak2hOpr6 = null;
	/* Column Info */
	private String ak2hOpr5 = null;
	/* Column Info */
	private String ak2hOpr8 = null;
	/* Column Info */
	private String ak2hOpr7 = null;
	/* Column Info */
	private String ak2hOpr9 = null;
	/* Column Info */
	private String dg45Tot = null;
	
	private String stwg20Opr1 = null;
	private String stwg2hOpr1 = null;
	private String stwg40Opr1 = null;
	private String stwg4hOpr1 = null;
	private String stwg45Opr1 = null;

	private String stwg20Opr2 = null;
	private String stwg2hOpr2 = null;
	private String stwg40Opr2 = null;
	private String stwg4hOpr2 = null;
	private String stwg45Opr2 = null;

	private String stwg20Opr3 = null;
	private String stwg2hOpr3 = null;
	private String stwg40Opr3 = null;
	private String stwg4hOpr3 = null;
	private String stwg45Opr3 = null;

	private String stwg20Opr4 = null;
	private String stwg2hOpr4 = null;
	private String stwg40Opr4 = null;
	private String stwg4hOpr4 = null;
	private String stwg45Opr4 = null;

	private String stwg20Opr5 = null;
	private String stwg2hOpr5 = null;
	private String stwg40Opr5 = null;
	private String stwg4hOpr5 = null;
	private String stwg45Opr5 = null;

	private String stwg20Tot = null;
	private String stwg2hTot = null;
	private String stwg40Tot = null;
	private String stwg4hTot = null;
	private String stwg45Tot = null;
	
	/* Column Info */
	private String podYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CBFSummaryVO() {}

//	public CBFSummaryVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String oprCd, String pod, String mlb, String wg, String fm, String ydCd, String ydNm, String unit2, String unit4, String locNm, String crrCd, String crrCd2, String podCd, String mlbCd, String dcgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String stwgCgoFlg, String pcCgoFlg, String stwgCd, String stwgNm, String bkgShprOwnrFlg, String cbfIndFlg, String creUsrId, String creDt, String updUsrId, String updDt, String sort, String totQty2, String totQty2h, String totQty4, String totQty4h, String totQty45, String totTtl, String totTeu, String totWgt2, String totWgt2h, String totWgt4, String totWgt4h, String totWgt45, String opr1, String opr2, String opr3, String opr4, String opr5, String opr6, String opr7, String opr8, String opr9, String opr10, String qty1, String qty2, String qty3, String qty4, String qty5, String qty6, String qty7, String qty8, String qty9, String qty10, String avWgt2, String avWgt4, String opr1Qty2, String opr1Qty2h, String opr1Qty4, String opr1Qty4h, String opr1Qty45, String opr1Teu, String opr1Wgt2, String opr1Wgt2h, String opr1Wgt4, String opr1Wgt4h, String opr1Wgt45, String opr2Qty2, String opr2Qty2h, String opr2Qty4, String opr2Qty4h, String opr2Qty45, String opr2Teu, String opr2Wgt2, String opr2Wgt2h, String opr2Wgt4, String opr2Wgt4h, String opr2Wgt45, String opr3Qty2, String opr3Qty2h, String opr3Qty4, String opr3Qty4h, String opr3Qty45, String opr3Teu, String opr3Wgt2, String opr3Wgt2h, String opr3Wgt4, String opr3Wgt4h, String opr3Wgt45, String opr4Qty2, String opr4Qty2h, String opr4Qty4, String opr4Qty4h, String opr4Qty45, String opr4Teu, String opr4Wgt2, String opr4Wgt2h, String opr4Wgt4, String opr4Wgt4h, String opr4Wgt45, String opr5Qty2, String opr5Qty2h, String opr5Qty4, String opr5Qty4h, String opr5Qty45, String opr5Teu, String opr5Wgt2, String opr5Wgt2h, String opr5Wgt4, String opr5Wgt4h, String opr5Wgt45, String opr6Qty2, String opr6Qty2h, String opr6Qty4, String opr6Qty4h, String opr6Qty45, String opr6Teu, String opr6Wgt2, String opr6Wgt2h, String opr6Wgt4, String opr6Wgt4h, String opr6Wgt45, String opr7Qty2, String opr7Qty2h, String opr7Qty4, String opr7Qty4h, String opr7Qty45, String opr7Teu, String opr7Wgt2, String opr7Wgt2h, String opr7Wgt4, String opr7Wgt4h, String opr7Wgt45, String opr8Qty2, String opr8Qty2h, String opr8Qty4, String opr8Qty4h, String opr8Qty45, String opr8Teu, String opr8Wgt2, String opr8Wgt2h, String opr8Wgt4, String opr8Wgt4h, String opr8Wgt45, String opr9Qty2, String opr9Qty2h, String opr9Qty4, String opr9Qty4h, String opr9Qty45, String opr9Teu, String opr9Wgt2, String opr9Wgt2h, String opr9Wgt4, String opr9Wgt4h, String opr9Wgt45, String opr10Qty2, String opr10Qty2h, String opr10Qty4, String opr10Qty4h, String opr10Qty45, String opr10Teu, String opr10Wgt2, String opr10Wgt2h, String opr10Wgt4, String opr10Wgt4h, String opr10Wgt45, String dg20Tot, String dg2hTot, String dg40Tot, String dg4hTot, String dg45Tot, String rf20Tot, String rf2hTot, String rf40Tot, String rf4hTot, String rf45Tot, String ak20Tot, String ak40Tot, String ak4hTot, String ak45Tot, String bb20Tot, String bb40Tot, String dg20Opr1, String dg2hOpr1, String dg40Opr1, String dg4hOpr1, String dg45Opr1, String rf20Opr1, String rf2hOpr1, String rf40Opr1, String rf4hOpr1, String rf45Opr1, String ak20Opr1, String ak2hOpr1, String ak40Opr1, String ak4hOpr1, String ak45Opr1, String bb20Opr1, String bb2hOpr1, String bb40Opr1, String bb4hOpr1, String bb45Opr1, String dg20Opr2, String dg2hOpr2, String dg40Opr2, String dg4hOpr2, String dg45Opr2, String rf20Opr2, String rf2hOpr2, String rf40Opr2, String rf4hOpr2, String rf45Opr2, String ak20Opr2, String ak2hOpr2, String ak40Opr2, String ak4hOpr2, String ak45Opr2, String bb20Opr2, String bb2hOpr2, String bb40Opr2, String bb4hOpr2, String bb45Opr2, String dg20Opr3, String dg2hOpr3, String dg40Opr3, String dg4hOpr3, String dg45Opr3, String rf20Opr3, String rf2hOpr3, String rf40Opr3, String rf4hOpr3, String rf45Opr3, String ak20Opr3, String ak2hOpr3, String ak40Opr3, String ak4hOpr3, String ak45Opr3, String bb20Opr3, String bb2hOpr3, String bb40Opr3, String bb4hOpr3, String bb45Opr3, String dg20Opr4, String dg2hOpr4, String dg40Opr4, String dg4hOpr4, String dg45Opr4, String rf20Opr4, String rf2hOpr4, String rf40Opr4, String rf4hOpr4, String rf45Opr4, String ak20Opr4, String ak2hOpr4, String ak40Opr4, String ak4hOpr4, String ak45Opr4, String bb20Opr4, String bb2hOpr4, String bb40Opr4, String bb4hOpr4, String bb45Opr4, String dg20Opr5, String dg2hOpr5, String dg40Opr5, String dg4hOpr5, String dg45Opr5, String rf20Opr5, String rf2hOpr5, String rf40Opr5, String rf4hOpr5, String rf45Opr5, String ak20Opr5, String ak2hOpr5, String ak40Opr5, String ak4hOpr5, String ak45Opr5, String bb20Opr5, String bb2hOpr5, String bb40Opr5, String bb4hOpr5, String bb45Opr5, String dg20Opr6, String dg2hOpr6, String dg40Opr6, String dg4hOpr6, String dg45Opr6, String rf20Opr6, String rf2hOpr6, String rf40Opr6, String rf4hOpr6, String rf45Opr6, String ak20Opr6, String ak2hOpr6, String ak40Opr6, String ak4hOpr6, String ak45Opr6, String bb20Opr6, String bb2hOpr6, String bb40Opr6, String bb4hOpr6, String bb45Opr6, String dg20Opr7, String dg2hOpr7, String dg40Opr7, String dg4hOpr7, String dg45Opr7, String rf20Opr7, String rf2hOpr7, String rf40Opr7, String rf4hOpr7, String rf45Opr7, String ak20Opr7, String ak2hOpr7, String ak40Opr7, String ak4hOpr7, String ak45Opr7, String bb20Opr7, String bb2hOpr7, String bb40Opr7, String bb4hOpr7, String bb45Opr7, String dg20Opr8, String dg2hOpr8, String dg40Opr8, String dg4hOpr8, String dg45Opr8, String rf20Opr8, String rf2hOpr8, String rf40Opr8, String rf4hOpr8, String rf45Opr8, String ak20Opr8, String ak2hOpr8, String ak40Opr8, String ak4hOpr8, String ak45Opr8, String bb20Opr8, String bb2hOpr8, String bb40Opr8, String bb4hOpr8, String bb45Opr8, String dg20Opr9, String dg2hOpr9, String dg40Opr9, String dg4hOpr9, String dg45Opr9, String rf20Opr9, String rf2hOpr9, String rf40Opr9, String rf4hOpr9, String rf45Opr9, String ak20Opr9, String ak2hOpr9, String ak40Opr9, String ak4hOpr9, String ak45Opr9, String bb20Opr9, String bb2hOpr9, String bb40Opr9, String bb4hOpr9, String bb45Opr9, String dg20Opr10, String dg2hOpr10, String dg40Opr10, String dg4hOpr10, String dg45Opr10, String rf20Opr10, String rf2hOpr10, String rf40Opr10, String rf4hOpr10, String rf45Opr10, String ak20Opr10, String ak2hOpr10, String ak40Opr10, String ak4hOpr10, String ak45Opr10, String bb20Opr10, String bb2hOpr10, String bb40Opr10, String bb4hOpr10, String bb45Opr10) {
//		this.bb2hOpr10 = bb2hOpr10;
//		this.fm = fm;
//		this.opr5Wgt4 = opr5Wgt4;
//		this.opr5Wgt2 = opr5Wgt2;
//		this.skdVoyNo = skdVoyNo;
//		this.opr8Wgt4h = opr8Wgt4h;
//		this.opr10Wgt4 = opr10Wgt4;
//		this.ak20Tot = ak20Tot;
//		this.ak2hOpr10 = ak2hOpr10;
//		this.rcFlg = rcFlg;
//		this.ak40Opr10 = ak40Opr10;
//		this.opr10Wgt2 = opr10Wgt2;
//		this.opr8Wgt45 = opr8Wgt45;
//		this.opr8Wgt2h = opr8Wgt2h;
//		this.oprCd = oprCd;
//		this.opr3Wgt2 = opr3Wgt2;
//		this.rf2hTot = rf2hTot;
//		this.opr3Wgt4 = opr3Wgt4;
//		this.opr2Wgt2 = opr2Wgt2;
//		this.ak20Opr10 = ak20Opr10;
//		this.opr5Teu = opr5Teu;
//		this.totWgt45 = totWgt45;
//		this.opr2Wgt4 = opr2Wgt4;
//		this.totWgt2h = totWgt2h;
//		this.opr5Qty2 = opr5Qty2;
//		this.opr5Qty4 = opr5Qty4;
//		this.bb20Opr7 = bb20Opr7;
//		this.opr3Teu = opr3Teu;
//		this.bb20Opr8 = bb20Opr8;
//		this.opr6Qty4h = opr6Qty4h;
//		this.bb20Opr9 = bb20Opr9;
//		this.bb20Opr3 = bb20Opr3;
//		this.totWgt4h = totWgt4h;
//		this.bb20Opr4 = bb20Opr4;
//		this.rf40Tot = rf40Tot;
//		this.bb20Opr5 = bb20Opr5;
//		this.bb20Opr6 = bb20Opr6;
//		this.opr10Qty2h = opr10Qty2h;
//		this.opr2Wgt2h = opr2Wgt2h;
//		this.creUsrId = creUsrId;
//		this.ydNm = ydNm;
//		this.opr1Qty2 = opr1Qty2;
//		this.qty10 = qty10;
//		this.opr1Qty4 = opr1Qty4;
//		this.creDt = creDt;
//		this.dg45Opr8 = dg45Opr8;
//		this.dg45Opr7 = dg45Opr7;
//		this.dg45Opr6 = dg45Opr6;
//		this.rf20Opr10 = rf20Opr10;
//		this.dg45Opr5 = dg45Opr5;
//		this.dg45Opr9 = dg45Opr9;
//		this.bb20Opr2 = bb20Opr2;
//		this.dg45Opr4 = dg45Opr4;
//		this.bb20Opr1 = bb20Opr1;
//		this.dg45Opr3 = dg45Opr3;
//		this.dg45Opr2 = dg45Opr2;
//		this.dg45Opr1 = dg45Opr1;
//		this.dg40Tot = dg40Tot;
//		this.opr6Qty2h = opr6Qty2h;
//		this.opr5Wgt4h = opr5Wgt4h;
//		this.bb45Opr10 = bb45Opr10;
//		this.dg40Opr10 = dg40Opr10;
//		this.totTeu = totTeu;
//		this.stwgCgoFlg = stwgCgoFlg;
//		this.opr6Qty45 = opr6Qty45;
//		this.dg4hOpr10 = dg4hOpr10;
//		this.opr8Wgt2 = opr8Wgt2;
//		this.opr8Wgt4 = opr8Wgt4;
//		this.cbfIndFlg = cbfIndFlg;
//		this.rf4hOpr3 = rf4hOpr3;
//		this.bb4hOpr9 = bb4hOpr9;
//		this.rf4hOpr4 = rf4hOpr4;
//		this.rf4hOpr1 = rf4hOpr1;
//		this.rf4hOpr2 = rf4hOpr2;
//		this.bb4hOpr5 = bb4hOpr5;
//		this.rf4hOpr7 = rf4hOpr7;
//		this.bb4hOpr6 = bb4hOpr6;
//		this.rf4hOpr8 = rf4hOpr8;
//		this.rf4hOpr5 = rf4hOpr5;
//		this.bb4hOpr7 = bb4hOpr7;
//		this.rf4hOpr6 = rf4hOpr6;
//		this.bb4hOpr8 = bb4hOpr8;
//		this.opr3Qty45 = opr3Qty45;
//		this.bb4hOpr1 = bb4hOpr1;
//		this.bb4hOpr2 = bb4hOpr2;
//		this.ak20Opr9 = ak20Opr9;
//		this.opr4Wgt2h = opr4Wgt2h;
//		this.bb4hOpr3 = bb4hOpr3;
//		this.bb4hOpr4 = bb4hOpr4;
//		this.opr9Qty2 = opr9Qty2;
//		this.opr9Qty4 = opr9Qty4;
//		this.ak20Opr1 = ak20Opr1;
//		this.ak20Opr2 = ak20Opr2;
//		this.ak20Opr3 = ak20Opr3;
//		this.ak20Opr4 = ak20Opr4;
//		this.ak20Opr5 = ak20Opr5;
//		this.ak20Opr6 = ak20Opr6;
//		this.opr3Qty2h = opr3Qty2h;
//		this.ak20Opr7 = ak20Opr7;
//		this.ak20Opr8 = ak20Opr8;
//		this.stwgCd = stwgCd;
//		this.opr4Qty4h = opr4Qty4h;
//		this.rf4hOpr9 = rf4hOpr9;
//		this.updUsrId = updUsrId;
//		this.ak45Opr7 = ak45Opr7;
//		this.ak45Opr6 = ak45Opr6;
//		this.opr8Qty2h = opr8Qty2h;
//		this.ak45Opr9 = ak45Opr9;
//		this.ak45Opr8 = ak45Opr8;
//		this.totTtl = totTtl;
//		this.podCd = podCd;
//		this.opr8Qty45 = opr8Qty45;
//		this.ak45Opr1 = ak45Opr1;
//		this.ak45Opr2 = ak45Opr2;
//		this.ak45Opr3 = ak45Opr3;
//		this.ak45Opr4 = ak45Opr4;
//		this.ak45Opr5 = ak45Opr5;
//		this.bb2hOpr9 = bb2hOpr9;
//		this.bb2hOpr8 = bb2hOpr8;
//		this.bb2hOpr7 = bb2hOpr7;
//		this.bb2hOpr6 = bb2hOpr6;
//		this.bb2hOpr5 = bb2hOpr5;
//		this.bb2hOpr4 = bb2hOpr4;
//		this.bb2hOpr3 = bb2hOpr3;
//		this.bb2hOpr2 = bb2hOpr2;
//		this.bb2hOpr1 = bb2hOpr1;
//		this.opr4Wgt4h = opr4Wgt4h;
//		this.opr10Qty45 = opr10Qty45;
//		this.opr3Qty4h = opr3Qty4h;
//		this.opr6Wgt2 = opr6Wgt2;
//		this.dg2hTot = dg2hTot;
//		this.opr6Wgt4 = opr6Wgt4;
//		this.ak45Tot = ak45Tot;
//		this.rf4hTot = rf4hTot;
//		this.opr10Qty4h = opr10Qty4h;
//		this.rf45Opr3 = rf45Opr3;
//		this.rf45Opr2 = rf45Opr2;
//		this.rf45Opr1 = rf45Opr1;
//		this.opr4Wgt45 = opr4Wgt45;
//		this.rf45Opr7 = rf45Opr7;
//		this.rf45Opr6 = rf45Opr6;
//		this.rf45Opr5 = rf45Opr5;
//		this.bb40Opr9 = bb40Opr9;
//		this.rf45Opr4 = rf45Opr4;
//		this.bb40Opr7 = bb40Opr7;
//		this.bb40Opr8 = bb40Opr8;
//		this.bb40Opr5 = bb40Opr5;
//		this.rf45Opr9 = rf45Opr9;
//		this.bb40Opr6 = bb40Opr6;
//		this.rf45Opr8 = rf45Opr8;
//		this.totQty2h = totQty2h;
//		this.opr1Qty4h = opr1Qty4h;
//		this.rf40Opr1 = rf40Opr1;
//		this.vslCd = vslCd;
//		this.rf40Opr2 = rf40Opr2;
//		this.rf40Opr3 = rf40Opr3;
//		this.rf40Opr4 = rf40Opr4;
//		this.rf40Opr5 = rf40Opr5;
//		this.rf40Opr6 = rf40Opr6;
//		this.dg20Tot = dg20Tot;
//		this.rf40Opr7 = rf40Opr7;
//		this.rf40Opr8 = rf40Opr8;
//		this.rf40Opr9 = rf40Opr9;
//		this.bb40Opr1 = bb40Opr1;
//		this.totQty45 = totQty45;
//		this.bb40Opr2 = bb40Opr2;
//		this.bb40Opr3 = bb40Opr3;
//		this.bb40Opr4 = bb40Opr4;
//		this.bb40Tot = bb40Tot;
//		this.opr7Qty2h = opr7Qty2h;
//		this.bb20Opr10 = bb20Opr10;
//		this.opr7Qty45 = opr7Qty45;
//		this.rf45Opr10 = rf45Opr10;
//		this.bb20Tot = bb20Tot;
//		this.dcgoFlg = dcgoFlg;
//		this.totQty2 = totQty2;
//		this.totQty4 = totQty4;
//		this.opr8Qty4h = opr8Qty4h;
//		this.bkgShprOwnrFlg = bkgShprOwnrFlg;
//		this.skdDirCd = skdDirCd;
//		this.opr7Qty4h = opr7Qty4h;
//		this.rf40Opr10 = rf40Opr10;
//		this.pcCgoFlg = pcCgoFlg;
//		this.ak45Opr10 = ak45Opr10;
//		this.opr10Teu = opr10Teu;
//		this.opr1Wgt2h = opr1Wgt2h;
//		this.pagerows = pagerows;
//		this.opr7Wgt45 = opr7Wgt45;
//		this.ak4hOpr2 = ak4hOpr2;
//		this.ak4hOpr1 = ak4hOpr1;
//		this.opr10Wgt4h = opr10Wgt4h;
//		this.opr7Wgt2h = opr7Wgt2h;
//		this.pod = pod;
//		this.dg45Opr10 = dg45Opr10;
//		this.wg = wg;
//		this.opr10Qty4 = opr10Qty4;
//		this.opr10Qty2 = opr10Qty2;
//		this.bb4hOpr10 = bb4hOpr10;
//		this.ak4hOpr5 = ak4hOpr5;
//		this.ak4hOpr6 = ak4hOpr6;
//		this.ak4hOpr3 = ak4hOpr3;
//		this.crrCd2 = crrCd2;
//		this.ak4hOpr4 = ak4hOpr4;
//		this.ak4hOpr9 = ak4hOpr9;
//		this.ak4hOpr7 = ak4hOpr7;
//		this.opr1Qty45 = opr1Qty45;
//		this.ak4hOpr8 = ak4hOpr8;
//		this.opr8Teu = opr8Teu;
//		this.opr10 = opr10;
//		this.opr1Qty2h = opr1Qty2h;
//		this.opr1Wgt45 = opr1Wgt45;
//		this.sort = sort;
//		this.opr1Teu = opr1Teu;
//		this.rf45Tot = rf45Tot;
//		this.opr7Wgt4h = opr7Wgt4h;
//		this.opr4Qty2 = opr4Qty2;
//		this.ydCd = ydCd;
//		this.totQty4h = totQty4h;
//		this.bb40Opr10 = bb40Opr10;
//		this.opr2Qty4 = opr2Qty4;
//		this.opr2Qty2 = opr2Qty2;
//		this.opr9Wgt2 = opr9Wgt2;
//		this.stwgNm = stwgNm;
//		this.opr9Wgt4 = opr9Wgt4;
//		this.opr1Wgt4 = opr1Wgt4;
//		this.crrCd = crrCd;
//		this.opr1Wgt2 = opr1Wgt2;
//		this.opr7Wgt4 = opr7Wgt4;
//		this.opr7Wgt2 = opr7Wgt2;
//		this.opr8Qty4 = opr8Qty4;
//		this.opr8Qty2 = opr8Qty2;
//		this.opr4Qty4 = opr4Qty4;
//		this.opr9Qty2h = opr9Qty2h;
//		this.opr7Teu = opr7Teu;
//		this.opr9Qty45 = opr9Qty45;
//		this.unit2 = unit2;
//		this.unit4 = unit4;
//		this.opr6Teu = opr6Teu;
//		this.opr4Teu = opr4Teu;
//		this.opr3Qty4 = opr3Qty4;
//		this.opr1Wgt4h = opr1Wgt4h;
//		this.opr10Wgt45 = opr10Wgt45;
//		this.opr10Wgt2h = opr10Wgt2h;
//		this.ibflag = ibflag;
//		this.opr7 = opr7;
//		this.opr8 = opr8;
//		this.opr5 = opr5;
//		this.opr6 = opr6;
//		this.opr3 = opr3;
//		this.opr4 = opr4;
//		this.opr1 = opr1;
//		this.opr2 = opr2;
//		this.opr4Wgt4 = opr4Wgt4;
//		this.opr4Wgt2 = opr4Wgt2;
//		this.opr4Qty2h = opr4Qty2h;
//		this.opr9 = opr9;
//		this.opr4Qty45 = opr4Qty45;
//		this.rf2hOpr2 = rf2hOpr2;
//		this.opr6Qty4 = opr6Qty4;
//		this.rf2hOpr1 = rf2hOpr1;
//		this.opr6Qty2 = opr6Qty2;
//		this.opr5Qty2h = opr5Qty2h;
//		this.rf2hOpr6 = rf2hOpr6;
//		this.opr2Qty2h = opr2Qty2h;
//		this.rf2hOpr5 = rf2hOpr5;
//		this.rf2hOpr4 = rf2hOpr4;
//		this.rf4hOpr10 = rf4hOpr10;
//		this.rf2hOpr3 = rf2hOpr3;
//		this.rf20Opr8 = rf20Opr8;
//		this.rf20Opr7 = rf20Opr7;
//		this.rf20Opr9 = rf20Opr9;
//		this.rf20Opr4 = rf20Opr4;
//		this.dg40Opr5 = dg40Opr5;
//		this.rf2hOpr9 = rf2hOpr9;
//		this.ak4hTot = ak4hTot;
//		this.opr2Qty45 = opr2Qty45;
//		this.rf20Opr3 = rf20Opr3;
//		this.dg40Opr4 = dg40Opr4;
//		this.qty1 = qty1;
//		this.dg40Opr3 = dg40Opr3;
//		this.rf20Opr6 = rf20Opr6;
//		this.rf2hOpr7 = rf2hOpr7;
//		this.dg40Opr2 = dg40Opr2;
//		this.rf20Opr5 = rf20Opr5;
//		this.rf2hOpr8 = rf2hOpr8;
//		this.qty3 = qty3;
//		this.dg40Opr9 = dg40Opr9;
//		this.qty2 = qty2;
//		this.dg40Opr8 = dg40Opr8;
//		this.opr5Qty45 = opr5Qty45;
//		this.qty5 = qty5;
//		this.rf20Opr2 = rf20Opr2;
//		this.dg40Opr7 = dg40Opr7;
//		this.qty4 = qty4;
//		this.rf20Opr1 = rf20Opr1;
//		this.dg40Opr6 = dg40Opr6;
//		this.opr9Wgt45 = opr9Wgt45;
//		this.dg4hOpr1 = dg4hOpr1;
//		this.opr3Qty2 = opr3Qty2;
//		this.dg4hOpr7 = dg4hOpr7;
//		this.dg4hOpr6 = dg4hOpr6;
//		this.dg4hOpr9 = dg4hOpr9;
//		this.dg4hOpr8 = dg4hOpr8;
//		this.dg4hOpr3 = dg4hOpr3;
//		this.opr2Teu = opr2Teu;
//		this.dg4hOpr2 = dg4hOpr2;
//		this.opr9Wgt2h = opr9Wgt2h;
//		this.dg4hOpr5 = dg4hOpr5;
//		this.dg4hOpr4 = dg4hOpr4;
//		this.ak4hOpr10 = ak4hOpr10;
//		this.dg20Opr10 = dg20Opr10;
//		this.opr2Qty4h = opr2Qty4h;
//		this.opr2Wgt4h = opr2Wgt4h;
//		this.opr7Qty4 = opr7Qty4;
//		this.opr7Qty2 = opr7Qty2;
//		this.dg20Opr1 = dg20Opr1;
//		this.dg20Opr3 = dg20Opr3;
//		this.dg20Opr2 = dg20Opr2;
//		this.dg2hOpr10 = dg2hOpr10;
//		this.dg20Opr5 = dg20Opr5;
//		this.dg20Opr4 = dg20Opr4;
//		this.dg20Opr7 = dg20Opr7;
//		this.dg20Opr6 = dg20Opr6;
//		this.dg20Opr9 = dg20Opr9;
//		this.dg20Opr8 = dg20Opr8;
//		this.dg4hTot = dg4hTot;
//		this.qty8 = qty8;
//		this.qty9 = qty9;
//		this.qty6 = qty6;
//		this.qty7 = qty7;
//		this.dg2hOpr4 = dg2hOpr4;
//		this.dg2hOpr5 = dg2hOpr5;
//		this.dg2hOpr6 = dg2hOpr6;
//		this.dg2hOpr7 = dg2hOpr7;
//		this.opr2Wgt45 = opr2Wgt45;
//		this.dg2hOpr1 = dg2hOpr1;
//		this.dg2hOpr2 = dg2hOpr2;
//		this.dg2hOpr3 = dg2hOpr3;
//		this.opr9Qty4h = opr9Qty4h;
//		this.opr6Wgt2h = opr6Wgt2h;
//		this.opr6Wgt45 = opr6Wgt45;
//		this.dg2hOpr8 = dg2hOpr8;
//		this.dg2hOpr9 = dg2hOpr9;
//		this.rf20Tot = rf20Tot;
//		this.totWgt2 = totWgt2;
//		this.opr3Wgt2h = opr3Wgt2h;
//		this.totWgt4 = totWgt4;
//		this.mlb = mlb;
//		this.bb45Opr1 = bb45Opr1;
//		this.opr3Wgt45 = opr3Wgt45;
//		this.bb45Opr3 = bb45Opr3;
//		this.bb45Opr2 = bb45Opr2;
//		this.bb45Opr5 = bb45Opr5;
//		this.bb45Opr4 = bb45Opr4;
//		this.awkCgoFlg = awkCgoFlg;
//		this.bb45Opr7 = bb45Opr7;
//		this.bb45Opr6 = bb45Opr6;
//		this.bb45Opr9 = bb45Opr9;
//		this.bb45Opr8 = bb45Opr8;
//		this.locNm = locNm;
//		this.opr6Wgt4h = opr6Wgt4h;
//		this.avWgt2 = avWgt2;
//		this.avWgt4 = avWgt4;
//		this.ak40Tot = ak40Tot;
//		this.ak40Opr7 = ak40Opr7;
//		this.ak40Opr8 = ak40Opr8;
//		this.rf2hOpr10 = rf2hOpr10;
//		this.ak40Opr9 = ak40Opr9;
//		this.opr5Wgt2h = opr5Wgt2h;
//		this.ak40Opr3 = ak40Opr3;
//		this.ak40Opr4 = ak40Opr4;
//		this.ak40Opr5 = ak40Opr5;
//		this.opr5Qty4h = opr5Qty4h;
//		this.ak40Opr6 = ak40Opr6;
//		this.ak40Opr1 = ak40Opr1;
//		this.ak40Opr2 = ak40Opr2;
//		this.opr3Wgt4h = opr3Wgt4h;
//		this.bbCgoFlg = bbCgoFlg;
//		this.opr9Teu = opr9Teu;
//		this.mlbCd = mlbCd;
//		this.updDt = updDt;
//		this.opr9Wgt4h = opr9Wgt4h;
//		this.dg40Opr1 = dg40Opr1;
//		this.opr5Wgt45 = opr5Wgt45;
//		this.ak2hOpr2 = ak2hOpr2;
//		this.ak2hOpr1 = ak2hOpr1;
//		this.ak2hOpr4 = ak2hOpr4;
//		this.ak2hOpr3 = ak2hOpr3;
//		this.ak2hOpr6 = ak2hOpr6;
//		this.ak2hOpr5 = ak2hOpr5;
//		this.ak2hOpr8 = ak2hOpr8;
//		this.ak2hOpr7 = ak2hOpr7;
//		this.ak2hOpr9 = ak2hOpr9;
//		this.dg45Tot = dg45Tot;
//	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bb_2h_opr10", getBb2hOpr10());
		this.hashColumns.put("fm", getFm());
		this.hashColumns.put("opr5_wgt_4", getOpr5Wgt4());
		this.hashColumns.put("opr5_wgt_2", getOpr5Wgt2());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("opr8_wgt_4h", getOpr8Wgt4h());
		this.hashColumns.put("opr10_wgt_4", getOpr10Wgt4());
		this.hashColumns.put("ak_20_tot", getAk20Tot());
		this.hashColumns.put("ak_2h_opr10", getAk2hOpr10());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("ak_40_opr10", getAk40Opr10());
		this.hashColumns.put("opr10_wgt_2", getOpr10Wgt2());
		this.hashColumns.put("opr8_wgt_45", getOpr8Wgt45());
		this.hashColumns.put("opr8_wgt_2h", getOpr8Wgt2h());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("opr3_wgt_2", getOpr3Wgt2());
		this.hashColumns.put("rf_2h_tot", getRf2hTot());
		this.hashColumns.put("opr3_wgt_4", getOpr3Wgt4());
		this.hashColumns.put("opr2_wgt_2", getOpr2Wgt2());
		this.hashColumns.put("ak_20_opr10", getAk20Opr10());
		this.hashColumns.put("opr5_teu", getOpr5Teu());
		this.hashColumns.put("tot_wgt_45", getTotWgt45());
		this.hashColumns.put("opr2_wgt_4", getOpr2Wgt4());
		this.hashColumns.put("tot_wgt_2h", getTotWgt2h());
		this.hashColumns.put("opr5_qty_2", getOpr5Qty2());
		this.hashColumns.put("opr5_qty_4", getOpr5Qty4());
		this.hashColumns.put("bb_20_opr7", getBb20Opr7());
		this.hashColumns.put("opr3_teu", getOpr3Teu());
		this.hashColumns.put("bb_20_opr8", getBb20Opr8());
		this.hashColumns.put("opr6_qty_4h", getOpr6Qty4h());
		this.hashColumns.put("bb_20_opr9", getBb20Opr9());
		this.hashColumns.put("bb_20_opr3", getBb20Opr3());
		this.hashColumns.put("tot_wgt_4h", getTotWgt4h());
		this.hashColumns.put("bb_20_opr4", getBb20Opr4());
		this.hashColumns.put("rf_40_tot", getRf40Tot());
		this.hashColumns.put("bb_20_opr5", getBb20Opr5());
		this.hashColumns.put("bb_20_opr6", getBb20Opr6());
		this.hashColumns.put("opr10_qty_2h", getOpr10Qty2h());
		this.hashColumns.put("opr2_wgt_2h", getOpr2Wgt2h());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("opr1_qty_2", getOpr1Qty2());
		this.hashColumns.put("qty10", getQty10());
		this.hashColumns.put("opr1_qty_4", getOpr1Qty4());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dg_45_opr8", getDg45Opr8());
		this.hashColumns.put("dg_45_opr7", getDg45Opr7());
		this.hashColumns.put("dg_45_opr6", getDg45Opr6());
		this.hashColumns.put("rf_20_opr10", getRf20Opr10());
		this.hashColumns.put("dg_45_opr5", getDg45Opr5());
		this.hashColumns.put("dg_45_opr9", getDg45Opr9());
		this.hashColumns.put("bb_20_opr2", getBb20Opr2());
		this.hashColumns.put("dg_45_opr4", getDg45Opr4());
		this.hashColumns.put("bb_20_opr1", getBb20Opr1());
		this.hashColumns.put("dg_45_opr3", getDg45Opr3());
		this.hashColumns.put("dg_45_opr2", getDg45Opr2());
		this.hashColumns.put("dg_45_opr1", getDg45Opr1());
		this.hashColumns.put("dg_40_tot", getDg40Tot());
		this.hashColumns.put("opr6_qty_2h", getOpr6Qty2h());
		this.hashColumns.put("opr5_wgt_4h", getOpr5Wgt4h());
		this.hashColumns.put("bb_45_opr10", getBb45Opr10());
		this.hashColumns.put("dg_40_opr10", getDg40Opr10());
		this.hashColumns.put("tot_teu", getTotTeu());
		this.hashColumns.put("stwg_cgo_flg", getStwgCgoFlg());
		this.hashColumns.put("opr6_qty_45", getOpr6Qty45());
		this.hashColumns.put("dg_4h_opr10", getDg4hOpr10());
		this.hashColumns.put("opr8_wgt_2", getOpr8Wgt2());
		this.hashColumns.put("opr8_wgt_4", getOpr8Wgt4());
		this.hashColumns.put("cbf_ind_flg", getCbfIndFlg());
		this.hashColumns.put("rf_4h_opr3", getRf4hOpr3());
		this.hashColumns.put("bb_4h_opr9", getBb4hOpr9());
		this.hashColumns.put("rf_4h_opr4", getRf4hOpr4());
		this.hashColumns.put("rf_4h_opr1", getRf4hOpr1());
		this.hashColumns.put("rf_4h_opr2", getRf4hOpr2());
		this.hashColumns.put("bb_4h_opr5", getBb4hOpr5());
		this.hashColumns.put("rf_4h_opr7", getRf4hOpr7());
		this.hashColumns.put("bb_4h_opr6", getBb4hOpr6());
		this.hashColumns.put("rf_4h_opr8", getRf4hOpr8());
		this.hashColumns.put("rf_4h_opr5", getRf4hOpr5());
		this.hashColumns.put("bb_4h_opr7", getBb4hOpr7());
		this.hashColumns.put("rf_4h_opr6", getRf4hOpr6());
		this.hashColumns.put("bb_4h_opr8", getBb4hOpr8());
		this.hashColumns.put("opr3_qty_45", getOpr3Qty45());
		this.hashColumns.put("bb_4h_opr1", getBb4hOpr1());
		this.hashColumns.put("bb_4h_opr2", getBb4hOpr2());
		this.hashColumns.put("ak_20_opr9", getAk20Opr9());
		this.hashColumns.put("opr4_wgt_2h", getOpr4Wgt2h());
		this.hashColumns.put("bb_4h_opr3", getBb4hOpr3());
		this.hashColumns.put("bb_4h_opr4", getBb4hOpr4());
		this.hashColumns.put("opr9_qty_2", getOpr9Qty2());
		this.hashColumns.put("opr9_qty_4", getOpr9Qty4());
		this.hashColumns.put("ak_20_opr1", getAk20Opr1());
		this.hashColumns.put("ak_20_opr2", getAk20Opr2());
		this.hashColumns.put("ak_20_opr3", getAk20Opr3());
		this.hashColumns.put("ak_20_opr4", getAk20Opr4());
		this.hashColumns.put("ak_20_opr5", getAk20Opr5());
		this.hashColumns.put("ak_20_opr6", getAk20Opr6());
		this.hashColumns.put("opr3_qty_2h", getOpr3Qty2h());
		this.hashColumns.put("ak_20_opr7", getAk20Opr7());
		this.hashColumns.put("ak_20_opr8", getAk20Opr8());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("opr4_qty_4h", getOpr4Qty4h());
		this.hashColumns.put("rf_4h_opr9", getRf4hOpr9());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ak_45_opr7", getAk45Opr7());
		this.hashColumns.put("ak_45_opr6", getAk45Opr6());
		this.hashColumns.put("opr8_qty_2h", getOpr8Qty2h());
		this.hashColumns.put("ak_45_opr9", getAk45Opr9());
		this.hashColumns.put("ak_45_opr8", getAk45Opr8());
		this.hashColumns.put("tot_ttl", getTotTtl());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("opr8_qty_45", getOpr8Qty45());
		this.hashColumns.put("ak_45_opr1", getAk45Opr1());
		this.hashColumns.put("ak_45_opr2", getAk45Opr2());
		this.hashColumns.put("ak_45_opr3", getAk45Opr3());
		this.hashColumns.put("ak_45_opr4", getAk45Opr4());
		this.hashColumns.put("ak_45_opr5", getAk45Opr5());
		this.hashColumns.put("bb_2h_opr9", getBb2hOpr9());
		this.hashColumns.put("bb_2h_opr8", getBb2hOpr8());
		this.hashColumns.put("bb_2h_opr7", getBb2hOpr7());
		this.hashColumns.put("bb_2h_opr6", getBb2hOpr6());
		this.hashColumns.put("bb_2h_opr5", getBb2hOpr5());
		this.hashColumns.put("bb_2h_opr4", getBb2hOpr4());
		this.hashColumns.put("bb_2h_opr3", getBb2hOpr3());
		this.hashColumns.put("bb_2h_opr2", getBb2hOpr2());
		this.hashColumns.put("bb_2h_opr1", getBb2hOpr1());
		this.hashColumns.put("opr4_wgt_4h", getOpr4Wgt4h());
		this.hashColumns.put("opr10_qty_45", getOpr10Qty45());
		this.hashColumns.put("opr3_qty_4h", getOpr3Qty4h());
		this.hashColumns.put("opr6_wgt_2", getOpr6Wgt2());
		this.hashColumns.put("dg_2h_tot", getDg2hTot());
		this.hashColumns.put("opr6_wgt_4", getOpr6Wgt4());
		this.hashColumns.put("ak_45_tot", getAk45Tot());
		this.hashColumns.put("rf_4h_tot", getRf4hTot());
		this.hashColumns.put("opr10_qty_4h", getOpr10Qty4h());
		this.hashColumns.put("rf_45_opr3", getRf45Opr3());
		this.hashColumns.put("rf_45_opr2", getRf45Opr2());
		this.hashColumns.put("rf_45_opr1", getRf45Opr1());
		this.hashColumns.put("opr4_wgt_45", getOpr4Wgt45());
		this.hashColumns.put("rf_45_opr7", getRf45Opr7());
		this.hashColumns.put("rf_45_opr6", getRf45Opr6());
		this.hashColumns.put("rf_45_opr5", getRf45Opr5());
		this.hashColumns.put("bb_40_opr9", getBb40Opr9());
		this.hashColumns.put("rf_45_opr4", getRf45Opr4());
		this.hashColumns.put("bb_40_opr7", getBb40Opr7());
		this.hashColumns.put("bb_40_opr8", getBb40Opr8());
		this.hashColumns.put("bb_40_opr5", getBb40Opr5());
		this.hashColumns.put("rf_45_opr9", getRf45Opr9());
		this.hashColumns.put("bb_40_opr6", getBb40Opr6());
		this.hashColumns.put("rf_45_opr8", getRf45Opr8());
		this.hashColumns.put("tot_qty_2h", getTotQty2h());
		this.hashColumns.put("opr1_qty_4h", getOpr1Qty4h());
		this.hashColumns.put("rf_40_opr1", getRf40Opr1());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rf_40_opr2", getRf40Opr2());
		this.hashColumns.put("rf_40_opr3", getRf40Opr3());
		this.hashColumns.put("rf_40_opr4", getRf40Opr4());
		this.hashColumns.put("rf_40_opr5", getRf40Opr5());
		this.hashColumns.put("rf_40_opr6", getRf40Opr6());
		this.hashColumns.put("dg_20_tot", getDg20Tot());
		this.hashColumns.put("rf_40_opr7", getRf40Opr7());
		this.hashColumns.put("rf_40_opr8", getRf40Opr8());
		this.hashColumns.put("rf_40_opr9", getRf40Opr9());
		this.hashColumns.put("bb_40_opr1", getBb40Opr1());
		this.hashColumns.put("tot_qty_45", getTotQty45());
		this.hashColumns.put("bb_40_opr2", getBb40Opr2());
		this.hashColumns.put("bb_40_opr3", getBb40Opr3());
		this.hashColumns.put("bb_40_opr4", getBb40Opr4());
		this.hashColumns.put("bb_40_tot", getBb40Tot());
		this.hashColumns.put("opr7_qty_2h", getOpr7Qty2h());
		this.hashColumns.put("bb_20_opr10", getBb20Opr10());
		this.hashColumns.put("opr7_qty_45", getOpr7Qty45());
		this.hashColumns.put("rf_45_opr10", getRf45Opr10());
		this.hashColumns.put("bb_20_tot", getBb20Tot());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("tot_qty_2", getTotQty2());
		this.hashColumns.put("tot_qty_4", getTotQty4());
		this.hashColumns.put("opr8_qty_4h", getOpr8Qty4h());
		this.hashColumns.put("bkg_shpr_ownr_flg", getBkgShprOwnrFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("opr7_qty_4h", getOpr7Qty4h());
		this.hashColumns.put("rf_40_opr10", getRf40Opr10());
		this.hashColumns.put("pc_cgo_flg", getPcCgoFlg());
		this.hashColumns.put("ak_45_opr10", getAk45Opr10());
		this.hashColumns.put("opr10_teu", getOpr10Teu());
		this.hashColumns.put("opr1_wgt_2h", getOpr1Wgt2h());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("opr7_wgt_45", getOpr7Wgt45());
		this.hashColumns.put("ak_4h_opr2", getAk4hOpr2());
		this.hashColumns.put("ak_4h_opr1", getAk4hOpr1());
		this.hashColumns.put("opr10_wgt_4h", getOpr10Wgt4h());
		this.hashColumns.put("opr7_wgt_2h", getOpr7Wgt2h());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("dg_45_opr10", getDg45Opr10());
		this.hashColumns.put("wg", getWg());
		this.hashColumns.put("opr10_qty_4", getOpr10Qty4());
		this.hashColumns.put("opr10_qty_2", getOpr10Qty2());
		this.hashColumns.put("bb_4h_opr10", getBb4hOpr10());
		this.hashColumns.put("ak_4h_opr5", getAk4hOpr5());
		this.hashColumns.put("ak_4h_opr6", getAk4hOpr6());
		this.hashColumns.put("ak_4h_opr3", getAk4hOpr3());
		this.hashColumns.put("crr_cd2", getCrrCd2());
		this.hashColumns.put("ak_4h_opr4", getAk4hOpr4());
		this.hashColumns.put("ak_4h_opr9", getAk4hOpr9());
		this.hashColumns.put("ak_4h_opr7", getAk4hOpr7());
		this.hashColumns.put("opr1_qty_45", getOpr1Qty45());
		this.hashColumns.put("ak_4h_opr8", getAk4hOpr8());
		this.hashColumns.put("opr8_teu", getOpr8Teu());
		this.hashColumns.put("opr10", getOpr10());
		this.hashColumns.put("opr1_qty_2h", getOpr1Qty2h());
		this.hashColumns.put("opr1_wgt_45", getOpr1Wgt45());
		this.hashColumns.put("sort", getSort());
		this.hashColumns.put("opr1_teu", getOpr1Teu());
		this.hashColumns.put("rf_45_tot", getRf45Tot());
		this.hashColumns.put("opr7_wgt_4h", getOpr7Wgt4h());
		this.hashColumns.put("opr4_qty_2", getOpr4Qty2());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("tot_qty_4h", getTotQty4h());
		this.hashColumns.put("bb_40_opr10", getBb40Opr10());
		this.hashColumns.put("opr2_qty_4", getOpr2Qty4());
		this.hashColumns.put("opr2_qty_2", getOpr2Qty2());
		this.hashColumns.put("opr9_wgt_2", getOpr9Wgt2());
		this.hashColumns.put("stwg_nm", getStwgNm());
		this.hashColumns.put("opr9_wgt_4", getOpr9Wgt4());
		this.hashColumns.put("opr1_wgt_4", getOpr1Wgt4());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("opr1_wgt_2", getOpr1Wgt2());
		this.hashColumns.put("opr7_wgt_4", getOpr7Wgt4());
		this.hashColumns.put("opr7_wgt_2", getOpr7Wgt2());
		this.hashColumns.put("opr8_qty_4", getOpr8Qty4());
		this.hashColumns.put("opr8_qty_2", getOpr8Qty2());
		this.hashColumns.put("opr4_qty_4", getOpr4Qty4());
		this.hashColumns.put("opr9_qty_2h", getOpr9Qty2h());
		this.hashColumns.put("opr7_teu", getOpr7Teu());
		this.hashColumns.put("opr9_qty_45", getOpr9Qty45());
		this.hashColumns.put("unit2", getUnit2());
		this.hashColumns.put("unit4", getUnit4());
		this.hashColumns.put("opr6_teu", getOpr6Teu());
		this.hashColumns.put("opr4_teu", getOpr4Teu());
		this.hashColumns.put("opr3_qty_4", getOpr3Qty4());
		this.hashColumns.put("opr1_wgt_4h", getOpr1Wgt4h());
		this.hashColumns.put("opr10_wgt_45", getOpr10Wgt45());
		this.hashColumns.put("opr10_wgt_2h", getOpr10Wgt2h());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("opr7", getOpr7());
		this.hashColumns.put("opr8", getOpr8());
		this.hashColumns.put("opr5", getOpr5());
		this.hashColumns.put("opr6", getOpr6());
		this.hashColumns.put("opr3", getOpr3());
		this.hashColumns.put("opr4", getOpr4());
		this.hashColumns.put("opr1", getOpr1());
		this.hashColumns.put("opr2", getOpr2());
		this.hashColumns.put("opr4_wgt_4", getOpr4Wgt4());
		this.hashColumns.put("opr4_wgt_2", getOpr4Wgt2());
		this.hashColumns.put("opr4_qty_2h", getOpr4Qty2h());
		this.hashColumns.put("opr9", getOpr9());
		this.hashColumns.put("opr4_qty_45", getOpr4Qty45());
		this.hashColumns.put("rf_2h_opr2", getRf2hOpr2());
		this.hashColumns.put("opr6_qty_4", getOpr6Qty4());
		this.hashColumns.put("rf_2h_opr1", getRf2hOpr1());
		this.hashColumns.put("opr6_qty_2", getOpr6Qty2());
		this.hashColumns.put("opr5_qty_2h", getOpr5Qty2h());
		this.hashColumns.put("rf_2h_opr6", getRf2hOpr6());
		this.hashColumns.put("opr2_qty_2h", getOpr2Qty2h());
		this.hashColumns.put("rf_2h_opr5", getRf2hOpr5());
		this.hashColumns.put("rf_2h_opr4", getRf2hOpr4());
		this.hashColumns.put("rf_4h_opr10", getRf4hOpr10());
		this.hashColumns.put("rf_2h_opr3", getRf2hOpr3());
		this.hashColumns.put("rf_20_opr8", getRf20Opr8());
		this.hashColumns.put("rf_20_opr7", getRf20Opr7());
		this.hashColumns.put("rf_20_opr9", getRf20Opr9());
		this.hashColumns.put("rf_20_opr4", getRf20Opr4());
		this.hashColumns.put("dg_40_opr5", getDg40Opr5());
		this.hashColumns.put("rf_2h_opr9", getRf2hOpr9());
		this.hashColumns.put("ak_4h_tot", getAk4hTot());
		this.hashColumns.put("opr2_qty_45", getOpr2Qty45());
		this.hashColumns.put("rf_20_opr3", getRf20Opr3());
		this.hashColumns.put("dg_40_opr4", getDg40Opr4());
		this.hashColumns.put("qty1", getQty1());
		this.hashColumns.put("dg_40_opr3", getDg40Opr3());
		this.hashColumns.put("rf_20_opr6", getRf20Opr6());
		this.hashColumns.put("rf_2h_opr7", getRf2hOpr7());
		this.hashColumns.put("dg_40_opr2", getDg40Opr2());
		this.hashColumns.put("rf_20_opr5", getRf20Opr5());
		this.hashColumns.put("rf_2h_opr8", getRf2hOpr8());
		this.hashColumns.put("qty3", getQty3());
		this.hashColumns.put("dg_40_opr9", getDg40Opr9());
		this.hashColumns.put("qty2", getQty2());
		this.hashColumns.put("dg_40_opr8", getDg40Opr8());
		this.hashColumns.put("opr5_qty_45", getOpr5Qty45());
		this.hashColumns.put("qty5", getQty5());
		this.hashColumns.put("rf_20_opr2", getRf20Opr2());
		this.hashColumns.put("dg_40_opr7", getDg40Opr7());
		this.hashColumns.put("qty4", getQty4());
		this.hashColumns.put("rf_20_opr1", getRf20Opr1());
		this.hashColumns.put("dg_40_opr6", getDg40Opr6());
		this.hashColumns.put("opr9_wgt_45", getOpr9Wgt45());
		this.hashColumns.put("dg_4h_opr1", getDg4hOpr1());
		this.hashColumns.put("opr3_qty_2", getOpr3Qty2());
		this.hashColumns.put("dg_4h_opr7", getDg4hOpr7());
		this.hashColumns.put("dg_4h_opr6", getDg4hOpr6());
		this.hashColumns.put("dg_4h_opr9", getDg4hOpr9());
		this.hashColumns.put("dg_4h_opr8", getDg4hOpr8());
		this.hashColumns.put("dg_4h_opr3", getDg4hOpr3());
		this.hashColumns.put("opr2_teu", getOpr2Teu());
		this.hashColumns.put("dg_4h_opr2", getDg4hOpr2());
		this.hashColumns.put("opr9_wgt_2h", getOpr9Wgt2h());
		this.hashColumns.put("dg_4h_opr5", getDg4hOpr5());
		this.hashColumns.put("dg_4h_opr4", getDg4hOpr4());
		this.hashColumns.put("ak_4h_opr10", getAk4hOpr10());
		this.hashColumns.put("dg_20_opr10", getDg20Opr10());
		this.hashColumns.put("opr2_qty_4h", getOpr2Qty4h());
		this.hashColumns.put("opr2_wgt_4h", getOpr2Wgt4h());
		this.hashColumns.put("opr7_qty_4", getOpr7Qty4());
		this.hashColumns.put("opr7_qty_2", getOpr7Qty2());
		this.hashColumns.put("dg_20_opr1", getDg20Opr1());
		this.hashColumns.put("dg_20_opr3", getDg20Opr3());
		this.hashColumns.put("dg_20_opr2", getDg20Opr2());
		this.hashColumns.put("dg_2h_opr10", getDg2hOpr10());
		this.hashColumns.put("dg_20_opr5", getDg20Opr5());
		this.hashColumns.put("dg_20_opr4", getDg20Opr4());
		this.hashColumns.put("dg_20_opr7", getDg20Opr7());
		this.hashColumns.put("dg_20_opr6", getDg20Opr6());
		this.hashColumns.put("dg_20_opr9", getDg20Opr9());
		this.hashColumns.put("dg_20_opr8", getDg20Opr8());
		this.hashColumns.put("dg_4h_tot", getDg4hTot());
		this.hashColumns.put("qty8", getQty8());
		this.hashColumns.put("qty9", getQty9());
		this.hashColumns.put("qty6", getQty6());
		this.hashColumns.put("qty7", getQty7());
		this.hashColumns.put("dg_2h_opr4", getDg2hOpr4());
		this.hashColumns.put("dg_2h_opr5", getDg2hOpr5());
		this.hashColumns.put("dg_2h_opr6", getDg2hOpr6());
		this.hashColumns.put("dg_2h_opr7", getDg2hOpr7());
		this.hashColumns.put("opr2_wgt_45", getOpr2Wgt45());
		this.hashColumns.put("dg_2h_opr1", getDg2hOpr1());
		this.hashColumns.put("dg_2h_opr2", getDg2hOpr2());
		this.hashColumns.put("dg_2h_opr3", getDg2hOpr3());
		this.hashColumns.put("opr9_qty_4h", getOpr9Qty4h());
		this.hashColumns.put("opr6_wgt_2h", getOpr6Wgt2h());
		this.hashColumns.put("opr6_wgt_45", getOpr6Wgt45());
		this.hashColumns.put("dg_2h_opr8", getDg2hOpr8());
		this.hashColumns.put("dg_2h_opr9", getDg2hOpr9());
		this.hashColumns.put("rf_20_tot", getRf20Tot());
		this.hashColumns.put("tot_wgt_2", getTotWgt2());
		this.hashColumns.put("opr3_wgt_2h", getOpr3Wgt2h());
		this.hashColumns.put("tot_wgt_4", getTotWgt4());
		this.hashColumns.put("mlb", getMlb());
		this.hashColumns.put("bb_45_opr1", getBb45Opr1());
		this.hashColumns.put("opr3_wgt_45", getOpr3Wgt45());
		this.hashColumns.put("bb_45_opr3", getBb45Opr3());
		this.hashColumns.put("bb_45_opr2", getBb45Opr2());
		this.hashColumns.put("bb_45_opr5", getBb45Opr5());
		this.hashColumns.put("bb_45_opr4", getBb45Opr4());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("bb_45_opr7", getBb45Opr7());
		this.hashColumns.put("bb_45_opr6", getBb45Opr6());
		this.hashColumns.put("bb_45_opr9", getBb45Opr9());
		this.hashColumns.put("bb_45_opr8", getBb45Opr8());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("opr6_wgt_4h", getOpr6Wgt4h());
		this.hashColumns.put("av_wgt_2", getAvWgt2());
		this.hashColumns.put("av_wgt_4", getAvWgt4());
		this.hashColumns.put("ak_40_tot", getAk40Tot());
		this.hashColumns.put("ak_40_opr7", getAk40Opr7());
		this.hashColumns.put("ak_40_opr8", getAk40Opr8());
		this.hashColumns.put("rf_2h_opr10", getRf2hOpr10());
		this.hashColumns.put("ak_40_opr9", getAk40Opr9());
		this.hashColumns.put("opr5_wgt_2h", getOpr5Wgt2h());
		this.hashColumns.put("ak_40_opr3", getAk40Opr3());
		this.hashColumns.put("ak_40_opr4", getAk40Opr4());
		this.hashColumns.put("ak_40_opr5", getAk40Opr5());
		this.hashColumns.put("opr5_qty_4h", getOpr5Qty4h());
		this.hashColumns.put("ak_40_opr6", getAk40Opr6());
		this.hashColumns.put("ak_40_opr1", getAk40Opr1());
		this.hashColumns.put("ak_40_opr2", getAk40Opr2());
		this.hashColumns.put("opr3_wgt_4h", getOpr3Wgt4h());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("opr9_teu", getOpr9Teu());
		this.hashColumns.put("mlb_cd", getMlbCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("opr9_wgt_4h", getOpr9Wgt4h());
		this.hashColumns.put("dg_40_opr1", getDg40Opr1());
		this.hashColumns.put("opr5_wgt_45", getOpr5Wgt45());
		this.hashColumns.put("ak_2h_opr2", getAk2hOpr2());
		this.hashColumns.put("ak_2h_opr1", getAk2hOpr1());
		this.hashColumns.put("ak_2h_opr4", getAk2hOpr4());
		this.hashColumns.put("ak_2h_opr3", getAk2hOpr3());
		this.hashColumns.put("ak_2h_opr6", getAk2hOpr6());
		this.hashColumns.put("ak_2h_opr5", getAk2hOpr5());
		this.hashColumns.put("ak_2h_opr8", getAk2hOpr8());
		this.hashColumns.put("ak_2h_opr7", getAk2hOpr7());
		this.hashColumns.put("ak_2h_opr9", getAk2hOpr9());
		this.hashColumns.put("dg_45_tot", getDg45Tot());
		
		this.hashColumns.put("dg_45_tot", getDg45Tot());
		
		this.hashColumns.put("stwg_20_opr1", getStwg20Opr1());
		this.hashColumns.put("stwg_2h_opr1", getStwg2hOpr1());
		this.hashColumns.put("stwg_40_opr1", getStwg40Opr1());
		this.hashColumns.put("stwg_4h_opr1", getStwg4hOpr1());
		this.hashColumns.put("stwg_45_opr1", getStwg45Opr1());

		this.hashColumns.put("stwg_20_opr2", getStwg20Opr2());
		this.hashColumns.put("stwg_2h_opr2", getStwg2hOpr2());
		this.hashColumns.put("stwg_40_opr2", getStwg40Opr2());
		this.hashColumns.put("stwg_4h_opr2", getStwg4hOpr2());
		this.hashColumns.put("stwg_45_opr2", getStwg45Opr2());

		this.hashColumns.put("stwg_20_opr3", getStwg20Opr3());
		this.hashColumns.put("stwg_2h_opr3", getStwg2hOpr3());
		this.hashColumns.put("stwg_40_opr3", getStwg40Opr3());
		this.hashColumns.put("stwg_4h_opr3", getStwg4hOpr3());
		this.hashColumns.put("stwg_45_opr3", getStwg45Opr3());

		this.hashColumns.put("stwg_20_opr4", getStwg20Opr4());
		this.hashColumns.put("stwg_2h_opr4", getStwg2hOpr4());
		this.hashColumns.put("stwg_40_opr4", getStwg40Opr4());
		this.hashColumns.put("stwg_4h_opr4", getStwg4hOpr4());
		this.hashColumns.put("stwg_45_opr4", getStwg45Opr4());

		this.hashColumns.put("stwg_20_opr5", getStwg20Opr5());
		this.hashColumns.put("stwg_2h_opr5", getStwg2hOpr5());
		this.hashColumns.put("stwg_40_opr5", getStwg40Opr5());
		this.hashColumns.put("stwg_4h_opr5", getStwg4hOpr5());
		this.hashColumns.put("stwg_45_opr5", getStwg45Opr5());

		this.hashColumns.put("stwg_20_tot", getStwg20Tot());
		this.hashColumns.put("stwg_2h_tot", getStwg2hTot());
		this.hashColumns.put("stwg_40_tot", getStwg40Tot());
		this.hashColumns.put("stwg_4h_tot", getStwg4hTot());
		this.hashColumns.put("stwg_45_tot", getStwg45Tot());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bb_2h_opr10", "bb2hOpr10");
		this.hashFields.put("fm", "fm");
		this.hashFields.put("opr5_wgt_4", "opr5Wgt4");
		this.hashFields.put("opr5_wgt_2", "opr5Wgt2");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("opr8_wgt_4h", "opr8Wgt4h");
		this.hashFields.put("opr10_wgt_4", "opr10Wgt4");
		this.hashFields.put("ak_20_tot", "ak20Tot");
		this.hashFields.put("ak_2h_opr10", "ak2hOpr10");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("ak_40_opr10", "ak40Opr10");
		this.hashFields.put("opr10_wgt_2", "opr10Wgt2");
		this.hashFields.put("opr8_wgt_45", "opr8Wgt45");
		this.hashFields.put("opr8_wgt_2h", "opr8Wgt2h");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("opr3_wgt_2", "opr3Wgt2");
		this.hashFields.put("rf_2h_tot", "rf2hTot");
		this.hashFields.put("opr3_wgt_4", "opr3Wgt4");
		this.hashFields.put("opr2_wgt_2", "opr2Wgt2");
		this.hashFields.put("ak_20_opr10", "ak20Opr10");
		this.hashFields.put("opr5_teu", "opr5Teu");
		this.hashFields.put("tot_wgt_45", "totWgt45");
		this.hashFields.put("opr2_wgt_4", "opr2Wgt4");
		this.hashFields.put("tot_wgt_2h", "totWgt2h");
		this.hashFields.put("opr5_qty_2", "opr5Qty2");
		this.hashFields.put("opr5_qty_4", "opr5Qty4");
		this.hashFields.put("bb_20_opr7", "bb20Opr7");
		this.hashFields.put("opr3_teu", "opr3Teu");
		this.hashFields.put("bb_20_opr8", "bb20Opr8");
		this.hashFields.put("opr6_qty_4h", "opr6Qty4h");
		this.hashFields.put("bb_20_opr9", "bb20Opr9");
		this.hashFields.put("bb_20_opr3", "bb20Opr3");
		this.hashFields.put("tot_wgt_4h", "totWgt4h");
		this.hashFields.put("bb_20_opr4", "bb20Opr4");
		this.hashFields.put("rf_40_tot", "rf40Tot");
		this.hashFields.put("bb_20_opr5", "bb20Opr5");
		this.hashFields.put("bb_20_opr6", "bb20Opr6");
		this.hashFields.put("opr10_qty_2h", "opr10Qty2h");
		this.hashFields.put("opr2_wgt_2h", "opr2Wgt2h");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("opr1_qty_2", "opr1Qty2");
		this.hashFields.put("qty10", "qty10");
		this.hashFields.put("opr1_qty_4", "opr1Qty4");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dg_45_opr8", "dg45Opr8");
		this.hashFields.put("dg_45_opr7", "dg45Opr7");
		this.hashFields.put("dg_45_opr6", "dg45Opr6");
		this.hashFields.put("rf_20_opr10", "rf20Opr10");
		this.hashFields.put("dg_45_opr5", "dg45Opr5");
		this.hashFields.put("dg_45_opr9", "dg45Opr9");
		this.hashFields.put("bb_20_opr2", "bb20Opr2");
		this.hashFields.put("dg_45_opr4", "dg45Opr4");
		this.hashFields.put("bb_20_opr1", "bb20Opr1");
		this.hashFields.put("dg_45_opr3", "dg45Opr3");
		this.hashFields.put("dg_45_opr2", "dg45Opr2");
		this.hashFields.put("dg_45_opr1", "dg45Opr1");
		this.hashFields.put("dg_40_tot", "dg40Tot");
		this.hashFields.put("opr6_qty_2h", "opr6Qty2h");
		this.hashFields.put("opr5_wgt_4h", "opr5Wgt4h");
		this.hashFields.put("bb_45_opr10", "bb45Opr10");
		this.hashFields.put("dg_40_opr10", "dg40Opr10");
		this.hashFields.put("tot_teu", "totTeu");
		this.hashFields.put("stwg_cgo_flg", "stwgCgoFlg");
		this.hashFields.put("opr6_qty_45", "opr6Qty45");
		this.hashFields.put("dg_4h_opr10", "dg4hOpr10");
		this.hashFields.put("opr8_wgt_2", "opr8Wgt2");
		this.hashFields.put("opr8_wgt_4", "opr8Wgt4");
		this.hashFields.put("cbf_ind_flg", "cbfIndFlg");
		this.hashFields.put("rf_4h_opr3", "rf4hOpr3");
		this.hashFields.put("bb_4h_opr9", "bb4hOpr9");
		this.hashFields.put("rf_4h_opr4", "rf4hOpr4");
		this.hashFields.put("rf_4h_opr1", "rf4hOpr1");
		this.hashFields.put("rf_4h_opr2", "rf4hOpr2");
		this.hashFields.put("bb_4h_opr5", "bb4hOpr5");
		this.hashFields.put("rf_4h_opr7", "rf4hOpr7");
		this.hashFields.put("bb_4h_opr6", "bb4hOpr6");
		this.hashFields.put("rf_4h_opr8", "rf4hOpr8");
		this.hashFields.put("rf_4h_opr5", "rf4hOpr5");
		this.hashFields.put("bb_4h_opr7", "bb4hOpr7");
		this.hashFields.put("rf_4h_opr6", "rf4hOpr6");
		this.hashFields.put("bb_4h_opr8", "bb4hOpr8");
		this.hashFields.put("opr3_qty_45", "opr3Qty45");
		this.hashFields.put("bb_4h_opr1", "bb4hOpr1");
		this.hashFields.put("bb_4h_opr2", "bb4hOpr2");
		this.hashFields.put("ak_20_opr9", "ak20Opr9");
		this.hashFields.put("opr4_wgt_2h", "opr4Wgt2h");
		this.hashFields.put("bb_4h_opr3", "bb4hOpr3");
		this.hashFields.put("bb_4h_opr4", "bb4hOpr4");
		this.hashFields.put("opr9_qty_2", "opr9Qty2");
		this.hashFields.put("opr9_qty_4", "opr9Qty4");
		this.hashFields.put("ak_20_opr1", "ak20Opr1");
		this.hashFields.put("ak_20_opr2", "ak20Opr2");
		this.hashFields.put("ak_20_opr3", "ak20Opr3");
		this.hashFields.put("ak_20_opr4", "ak20Opr4");
		this.hashFields.put("ak_20_opr5", "ak20Opr5");
		this.hashFields.put("ak_20_opr6", "ak20Opr6");
		this.hashFields.put("opr3_qty_2h", "opr3Qty2h");
		this.hashFields.put("ak_20_opr7", "ak20Opr7");
		this.hashFields.put("ak_20_opr8", "ak20Opr8");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("opr4_qty_4h", "opr4Qty4h");
		this.hashFields.put("rf_4h_opr9", "rf4hOpr9");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ak_45_opr7", "ak45Opr7");
		this.hashFields.put("ak_45_opr6", "ak45Opr6");
		this.hashFields.put("opr8_qty_2h", "opr8Qty2h");
		this.hashFields.put("ak_45_opr9", "ak45Opr9");
		this.hashFields.put("ak_45_opr8", "ak45Opr8");
		this.hashFields.put("tot_ttl", "totTtl");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("opr8_qty_45", "opr8Qty45");
		this.hashFields.put("ak_45_opr1", "ak45Opr1");
		this.hashFields.put("ak_45_opr2", "ak45Opr2");
		this.hashFields.put("ak_45_opr3", "ak45Opr3");
		this.hashFields.put("ak_45_opr4", "ak45Opr4");
		this.hashFields.put("ak_45_opr5", "ak45Opr5");
		this.hashFields.put("bb_2h_opr9", "bb2hOpr9");
		this.hashFields.put("bb_2h_opr8", "bb2hOpr8");
		this.hashFields.put("bb_2h_opr7", "bb2hOpr7");
		this.hashFields.put("bb_2h_opr6", "bb2hOpr6");
		this.hashFields.put("bb_2h_opr5", "bb2hOpr5");
		this.hashFields.put("bb_2h_opr4", "bb2hOpr4");
		this.hashFields.put("bb_2h_opr3", "bb2hOpr3");
		this.hashFields.put("bb_2h_opr2", "bb2hOpr2");
		this.hashFields.put("bb_2h_opr1", "bb2hOpr1");
		this.hashFields.put("opr4_wgt_4h", "opr4Wgt4h");
		this.hashFields.put("opr10_qty_45", "opr10Qty45");
		this.hashFields.put("opr3_qty_4h", "opr3Qty4h");
		this.hashFields.put("opr6_wgt_2", "opr6Wgt2");
		this.hashFields.put("dg_2h_tot", "dg2hTot");
		this.hashFields.put("opr6_wgt_4", "opr6Wgt4");
		this.hashFields.put("ak_45_tot", "ak45Tot");
		this.hashFields.put("rf_4h_tot", "rf4hTot");
		this.hashFields.put("opr10_qty_4h", "opr10Qty4h");
		this.hashFields.put("rf_45_opr3", "rf45Opr3");
		this.hashFields.put("rf_45_opr2", "rf45Opr2");
		this.hashFields.put("rf_45_opr1", "rf45Opr1");
		this.hashFields.put("opr4_wgt_45", "opr4Wgt45");
		this.hashFields.put("rf_45_opr7", "rf45Opr7");
		this.hashFields.put("rf_45_opr6", "rf45Opr6");
		this.hashFields.put("rf_45_opr5", "rf45Opr5");
		this.hashFields.put("bb_40_opr9", "bb40Opr9");
		this.hashFields.put("rf_45_opr4", "rf45Opr4");
		this.hashFields.put("bb_40_opr7", "bb40Opr7");
		this.hashFields.put("bb_40_opr8", "bb40Opr8");
		this.hashFields.put("bb_40_opr5", "bb40Opr5");
		this.hashFields.put("rf_45_opr9", "rf45Opr9");
		this.hashFields.put("bb_40_opr6", "bb40Opr6");
		this.hashFields.put("rf_45_opr8", "rf45Opr8");
		this.hashFields.put("tot_qty_2h", "totQty2h");
		this.hashFields.put("opr1_qty_4h", "opr1Qty4h");
		this.hashFields.put("rf_40_opr1", "rf40Opr1");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rf_40_opr2", "rf40Opr2");
		this.hashFields.put("rf_40_opr3", "rf40Opr3");
		this.hashFields.put("rf_40_opr4", "rf40Opr4");
		this.hashFields.put("rf_40_opr5", "rf40Opr5");
		this.hashFields.put("rf_40_opr6", "rf40Opr6");
		this.hashFields.put("dg_20_tot", "dg20Tot");
		this.hashFields.put("rf_40_opr7", "rf40Opr7");
		this.hashFields.put("rf_40_opr8", "rf40Opr8");
		this.hashFields.put("rf_40_opr9", "rf40Opr9");
		this.hashFields.put("bb_40_opr1", "bb40Opr1");
		this.hashFields.put("tot_qty_45", "totQty45");
		this.hashFields.put("bb_40_opr2", "bb40Opr2");
		this.hashFields.put("bb_40_opr3", "bb40Opr3");
		this.hashFields.put("bb_40_opr4", "bb40Opr4");
		this.hashFields.put("bb_40_tot", "bb40Tot");
		this.hashFields.put("opr7_qty_2h", "opr7Qty2h");
		this.hashFields.put("bb_20_opr10", "bb20Opr10");
		this.hashFields.put("opr7_qty_45", "opr7Qty45");
		this.hashFields.put("rf_45_opr10", "rf45Opr10");
		this.hashFields.put("bb_20_tot", "bb20Tot");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("tot_qty_2", "totQty2");
		this.hashFields.put("tot_qty_4", "totQty4");
		this.hashFields.put("opr8_qty_4h", "opr8Qty4h");
		this.hashFields.put("bkg_shpr_ownr_flg", "bkgShprOwnrFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("opr7_qty_4h", "opr7Qty4h");
		this.hashFields.put("rf_40_opr10", "rf40Opr10");
		this.hashFields.put("pc_cgo_flg", "pcCgoFlg");
		this.hashFields.put("ak_45_opr10", "ak45Opr10");
		this.hashFields.put("opr10_teu", "opr10Teu");
		this.hashFields.put("opr1_wgt_2h", "opr1Wgt2h");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("opr7_wgt_45", "opr7Wgt45");
		this.hashFields.put("ak_4h_opr2", "ak4hOpr2");
		this.hashFields.put("ak_4h_opr1", "ak4hOpr1");
		this.hashFields.put("opr10_wgt_4h", "opr10Wgt4h");
		this.hashFields.put("opr7_wgt_2h", "opr7Wgt2h");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("dg_45_opr10", "dg45Opr10");
		this.hashFields.put("wg", "wg");
		this.hashFields.put("opr10_qty_4", "opr10Qty4");
		this.hashFields.put("opr10_qty_2", "opr10Qty2");
		this.hashFields.put("bb_4h_opr10", "bb4hOpr10");
		this.hashFields.put("ak_4h_opr5", "ak4hOpr5");
		this.hashFields.put("ak_4h_opr6", "ak4hOpr6");
		this.hashFields.put("ak_4h_opr3", "ak4hOpr3");
		this.hashFields.put("crr_cd2", "crrCd2");
		this.hashFields.put("ak_4h_opr4", "ak4hOpr4");
		this.hashFields.put("ak_4h_opr9", "ak4hOpr9");
		this.hashFields.put("ak_4h_opr7", "ak4hOpr7");
		this.hashFields.put("opr1_qty_45", "opr1Qty45");
		this.hashFields.put("ak_4h_opr8", "ak4hOpr8");
		this.hashFields.put("opr8_teu", "opr8Teu");
		this.hashFields.put("opr10", "opr10");
		this.hashFields.put("opr1_qty_2h", "opr1Qty2h");
		this.hashFields.put("opr1_wgt_45", "opr1Wgt45");
		this.hashFields.put("sort", "sort");
		this.hashFields.put("opr1_teu", "opr1Teu");
		this.hashFields.put("rf_45_tot", "rf45Tot");
		this.hashFields.put("opr7_wgt_4h", "opr7Wgt4h");
		this.hashFields.put("opr4_qty_2", "opr4Qty2");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("tot_qty_4h", "totQty4h");
		this.hashFields.put("bb_40_opr10", "bb40Opr10");
		this.hashFields.put("opr2_qty_4", "opr2Qty4");
		this.hashFields.put("opr2_qty_2", "opr2Qty2");
		this.hashFields.put("opr9_wgt_2", "opr9Wgt2");
		this.hashFields.put("stwg_nm", "stwgNm");
		this.hashFields.put("opr9_wgt_4", "opr9Wgt4");
		this.hashFields.put("opr1_wgt_4", "opr1Wgt4");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("opr1_wgt_2", "opr1Wgt2");
		this.hashFields.put("opr7_wgt_4", "opr7Wgt4");
		this.hashFields.put("opr7_wgt_2", "opr7Wgt2");
		this.hashFields.put("opr8_qty_4", "opr8Qty4");
		this.hashFields.put("opr8_qty_2", "opr8Qty2");
		this.hashFields.put("opr4_qty_4", "opr4Qty4");
		this.hashFields.put("opr9_qty_2h", "opr9Qty2h");
		this.hashFields.put("opr7_teu", "opr7Teu");
		this.hashFields.put("opr9_qty_45", "opr9Qty45");
		this.hashFields.put("unit2", "unit2");
		this.hashFields.put("unit4", "unit4");
		this.hashFields.put("opr6_teu", "opr6Teu");
		this.hashFields.put("opr4_teu", "opr4Teu");
		this.hashFields.put("opr3_qty_4", "opr3Qty4");
		this.hashFields.put("opr1_wgt_4h", "opr1Wgt4h");
		this.hashFields.put("opr10_wgt_45", "opr10Wgt45");
		this.hashFields.put("opr10_wgt_2h", "opr10Wgt2h");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("opr7", "opr7");
		this.hashFields.put("opr8", "opr8");
		this.hashFields.put("opr5", "opr5");
		this.hashFields.put("opr6", "opr6");
		this.hashFields.put("opr3", "opr3");
		this.hashFields.put("opr4", "opr4");
		this.hashFields.put("opr1", "opr1");
		this.hashFields.put("opr2", "opr2");
		this.hashFields.put("opr4_wgt_4", "opr4Wgt4");
		this.hashFields.put("opr4_wgt_2", "opr4Wgt2");
		this.hashFields.put("opr4_qty_2h", "opr4Qty2h");
		this.hashFields.put("opr9", "opr9");
		this.hashFields.put("opr4_qty_45", "opr4Qty45");
		this.hashFields.put("rf_2h_opr2", "rf2hOpr2");
		this.hashFields.put("opr6_qty_4", "opr6Qty4");
		this.hashFields.put("rf_2h_opr1", "rf2hOpr1");
		this.hashFields.put("opr6_qty_2", "opr6Qty2");
		this.hashFields.put("opr5_qty_2h", "opr5Qty2h");
		this.hashFields.put("rf_2h_opr6", "rf2hOpr6");
		this.hashFields.put("opr2_qty_2h", "opr2Qty2h");
		this.hashFields.put("rf_2h_opr5", "rf2hOpr5");
		this.hashFields.put("rf_2h_opr4", "rf2hOpr4");
		this.hashFields.put("rf_4h_opr10", "rf4hOpr10");
		this.hashFields.put("rf_2h_opr3", "rf2hOpr3");
		this.hashFields.put("rf_20_opr8", "rf20Opr8");
		this.hashFields.put("rf_20_opr7", "rf20Opr7");
		this.hashFields.put("rf_20_opr9", "rf20Opr9");
		this.hashFields.put("rf_20_opr4", "rf20Opr4");
		this.hashFields.put("dg_40_opr5", "dg40Opr5");
		this.hashFields.put("rf_2h_opr9", "rf2hOpr9");
		this.hashFields.put("ak_4h_tot", "ak4hTot");
		this.hashFields.put("opr2_qty_45", "opr2Qty45");
		this.hashFields.put("rf_20_opr3", "rf20Opr3");
		this.hashFields.put("dg_40_opr4", "dg40Opr4");
		this.hashFields.put("qty1", "qty1");
		this.hashFields.put("dg_40_opr3", "dg40Opr3");
		this.hashFields.put("rf_20_opr6", "rf20Opr6");
		this.hashFields.put("rf_2h_opr7", "rf2hOpr7");
		this.hashFields.put("dg_40_opr2", "dg40Opr2");
		this.hashFields.put("rf_20_opr5", "rf20Opr5");
		this.hashFields.put("rf_2h_opr8", "rf2hOpr8");
		this.hashFields.put("qty3", "qty3");
		this.hashFields.put("dg_40_opr9", "dg40Opr9");
		this.hashFields.put("qty2", "qty2");
		this.hashFields.put("dg_40_opr8", "dg40Opr8");
		this.hashFields.put("opr5_qty_45", "opr5Qty45");
		this.hashFields.put("qty5", "qty5");
		this.hashFields.put("rf_20_opr2", "rf20Opr2");
		this.hashFields.put("dg_40_opr7", "dg40Opr7");
		this.hashFields.put("qty4", "qty4");
		this.hashFields.put("rf_20_opr1", "rf20Opr1");
		this.hashFields.put("dg_40_opr6", "dg40Opr6");
		this.hashFields.put("opr9_wgt_45", "opr9Wgt45");
		this.hashFields.put("dg_4h_opr1", "dg4hOpr1");
		this.hashFields.put("opr3_qty_2", "opr3Qty2");
		this.hashFields.put("dg_4h_opr7", "dg4hOpr7");
		this.hashFields.put("dg_4h_opr6", "dg4hOpr6");
		this.hashFields.put("dg_4h_opr9", "dg4hOpr9");
		this.hashFields.put("dg_4h_opr8", "dg4hOpr8");
		this.hashFields.put("dg_4h_opr3", "dg4hOpr3");
		this.hashFields.put("opr2_teu", "opr2Teu");
		this.hashFields.put("dg_4h_opr2", "dg4hOpr2");
		this.hashFields.put("opr9_wgt_2h", "opr9Wgt2h");
		this.hashFields.put("dg_4h_opr5", "dg4hOpr5");
		this.hashFields.put("dg_4h_opr4", "dg4hOpr4");
		this.hashFields.put("ak_4h_opr10", "ak4hOpr10");
		this.hashFields.put("dg_20_opr10", "dg20Opr10");
		this.hashFields.put("opr2_qty_4h", "opr2Qty4h");
		this.hashFields.put("opr2_wgt_4h", "opr2Wgt4h");
		this.hashFields.put("opr7_qty_4", "opr7Qty4");
		this.hashFields.put("opr7_qty_2", "opr7Qty2");
		this.hashFields.put("dg_20_opr1", "dg20Opr1");
		this.hashFields.put("dg_20_opr3", "dg20Opr3");
		this.hashFields.put("dg_20_opr2", "dg20Opr2");
		this.hashFields.put("dg_2h_opr10", "dg2hOpr10");
		this.hashFields.put("dg_20_opr5", "dg20Opr5");
		this.hashFields.put("dg_20_opr4", "dg20Opr4");
		this.hashFields.put("dg_20_opr7", "dg20Opr7");
		this.hashFields.put("dg_20_opr6", "dg20Opr6");
		this.hashFields.put("dg_20_opr9", "dg20Opr9");
		this.hashFields.put("dg_20_opr8", "dg20Opr8");
		this.hashFields.put("dg_4h_tot", "dg4hTot");
		this.hashFields.put("qty8", "qty8");
		this.hashFields.put("qty9", "qty9");
		this.hashFields.put("qty6", "qty6");
		this.hashFields.put("qty7", "qty7");
		this.hashFields.put("dg_2h_opr4", "dg2hOpr4");
		this.hashFields.put("dg_2h_opr5", "dg2hOpr5");
		this.hashFields.put("dg_2h_opr6", "dg2hOpr6");
		this.hashFields.put("dg_2h_opr7", "dg2hOpr7");
		this.hashFields.put("opr2_wgt_45", "opr2Wgt45");
		this.hashFields.put("dg_2h_opr1", "dg2hOpr1");
		this.hashFields.put("dg_2h_opr2", "dg2hOpr2");
		this.hashFields.put("dg_2h_opr3", "dg2hOpr3");
		this.hashFields.put("opr9_qty_4h", "opr9Qty4h");
		this.hashFields.put("opr6_wgt_2h", "opr6Wgt2h");
		this.hashFields.put("opr6_wgt_45", "opr6Wgt45");
		this.hashFields.put("dg_2h_opr8", "dg2hOpr8");
		this.hashFields.put("dg_2h_opr9", "dg2hOpr9");
		this.hashFields.put("rf_20_tot", "rf20Tot");
		this.hashFields.put("tot_wgt_2", "totWgt2");
		this.hashFields.put("opr3_wgt_2h", "opr3Wgt2h");
		this.hashFields.put("tot_wgt_4", "totWgt4");
		this.hashFields.put("mlb", "mlb");
		this.hashFields.put("bb_45_opr1", "bb45Opr1");
		this.hashFields.put("opr3_wgt_45", "opr3Wgt45");
		this.hashFields.put("bb_45_opr3", "bb45Opr3");
		this.hashFields.put("bb_45_opr2", "bb45Opr2");
		this.hashFields.put("bb_45_opr5", "bb45Opr5");
		this.hashFields.put("bb_45_opr4", "bb45Opr4");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("bb_45_opr7", "bb45Opr7");
		this.hashFields.put("bb_45_opr6", "bb45Opr6");
		this.hashFields.put("bb_45_opr9", "bb45Opr9");
		this.hashFields.put("bb_45_opr8", "bb45Opr8");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("opr6_wgt_4h", "opr6Wgt4h");
		this.hashFields.put("av_wgt_2", "avWgt2");
		this.hashFields.put("av_wgt_4", "avWgt4");
		this.hashFields.put("ak_40_tot", "ak40Tot");
		this.hashFields.put("ak_40_opr7", "ak40Opr7");
		this.hashFields.put("ak_40_opr8", "ak40Opr8");
		this.hashFields.put("rf_2h_opr10", "rf2hOpr10");
		this.hashFields.put("ak_40_opr9", "ak40Opr9");
		this.hashFields.put("opr5_wgt_2h", "opr5Wgt2h");
		this.hashFields.put("ak_40_opr3", "ak40Opr3");
		this.hashFields.put("ak_40_opr4", "ak40Opr4");
		this.hashFields.put("ak_40_opr5", "ak40Opr5");
		this.hashFields.put("opr5_qty_4h", "opr5Qty4h");
		this.hashFields.put("ak_40_opr6", "ak40Opr6");
		this.hashFields.put("ak_40_opr1", "ak40Opr1");
		this.hashFields.put("ak_40_opr2", "ak40Opr2");
		this.hashFields.put("opr3_wgt_4h", "opr3Wgt4h");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("opr9_teu", "opr9Teu");
		this.hashFields.put("mlb_cd", "mlbCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("opr9_wgt_4h", "opr9Wgt4h");
		this.hashFields.put("dg_40_opr1", "dg40Opr1");
		this.hashFields.put("opr5_wgt_45", "opr5Wgt45");
		this.hashFields.put("ak_2h_opr2", "ak2hOpr2");
		this.hashFields.put("ak_2h_opr1", "ak2hOpr1");
		this.hashFields.put("ak_2h_opr4", "ak2hOpr4");
		this.hashFields.put("ak_2h_opr3", "ak2hOpr3");
		this.hashFields.put("ak_2h_opr6", "ak2hOpr6");
		this.hashFields.put("ak_2h_opr5", "ak2hOpr5");
		this.hashFields.put("ak_2h_opr8", "ak2hOpr8");
		this.hashFields.put("ak_2h_opr7", "ak2hOpr7");
		this.hashFields.put("ak_2h_opr9", "ak2hOpr9");
		this.hashFields.put("dg_45_tot", "dg45Tot");
		
		this.hashFields.put("stwg_20_opr1", "stwg20Opr1");
		this.hashFields.put("stwg_2h_opr1", "stwg2hOpr1");
		this.hashFields.put("stwg_40_opr1", "stwg40Opr1");
		this.hashFields.put("stwg_4h_opr1", "stwg4hOpr1");
		this.hashFields.put("stwg_45_opr1", "stwg45Opr1");
		
		this.hashFields.put("stwg_20_opr2", "stwg20Opr2");
		this.hashFields.put("stwg_2h_opr2", "stwg2hOpr2");
		this.hashFields.put("stwg_40_opr2", "stwg40Opr2");
		this.hashFields.put("stwg_4h_opr2", "stwg4hOpr2");
		this.hashFields.put("stwg_45_opr2", "stwg45Opr2");
		
		this.hashFields.put("stwg_20_opr3", "stwg20Opr3");
		this.hashFields.put("stwg_2h_opr3", "stwg2hOpr3");
		this.hashFields.put("stwg_40_opr3", "stwg40Opr3");
		this.hashFields.put("stwg_4h_opr3", "stwg4hOpr3");
		this.hashFields.put("stwg_45_opr3", "stwg45Opr3");
		
		this.hashFields.put("stwg_20_opr4", "stwg20Opr4");
		this.hashFields.put("stwg_2h_opr4", "stwg2hOpr4");
		this.hashFields.put("stwg_40_opr4", "stwg40Opr4");
		this.hashFields.put("stwg_4h_opr4", "stwg4hOpr4");
		this.hashFields.put("stwg_45_opr4", "stwg45Opr4");
		
		this.hashFields.put("stwg_20_opr5", "stwg20Opr5");
		this.hashFields.put("stwg_2h_opr5", "stwg2hOpr5");
		this.hashFields.put("stwg_40_opr5", "stwg40Opr5");
		this.hashFields.put("stwg_4h_opr5", "stwg4hOpr5");
		this.hashFields.put("stwg_45_opr5", "stwg45Opr5");
		
		this.hashFields.put("stwg_20_tot", "stwg20Tot");
		this.hashFields.put("stwg_2h_tot", "stwg2hTot");
		this.hashFields.put("stwg_40_tot", "stwg40Tot");
		this.hashFields.put("stwg_4h_tot", "stwg4hTot");
		this.hashFields.put("stwg_45_tot", "stwg45Tot");
		
		this.hashFields.put("pod_yd_cd","podYdCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bb2hOpr10
	 */
	public String getBb2hOpr10() {
		return this.bb2hOpr10;
	}
	
	/**
	 * Column Info
	 * @return fm
	 */
	public String getFm() {
		return this.fm;
	}
	
	/**
	 * Column Info
	 * @return opr5Wgt4
	 */
	public String getOpr5Wgt4() {
		return this.opr5Wgt4;
	}
	
	/**
	 * Column Info
	 * @return opr5Wgt2
	 */
	public String getOpr5Wgt2() {
		return this.opr5Wgt2;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return opr8Wgt4h
	 */
	public String getOpr8Wgt4h() {
		return this.opr8Wgt4h;
	}
	
	/**
	 * Column Info
	 * @return opr10Wgt4
	 */
	public String getOpr10Wgt4() {
		return this.opr10Wgt4;
	}
	
	/**
	 * Column Info
	 * @return ak20Tot
	 */
	public String getAk20Tot() {
		return this.ak20Tot;
	}
	
	/**
	 * Column Info
	 * @return ak2hOpr10
	 */
	public String getAk2hOpr10() {
		return this.ak2hOpr10;
	}
	
	/**
	 * Column Info
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
	}
	
	/**
	 * Column Info
	 * @return ak40Opr10
	 */
	public String getAk40Opr10() {
		return this.ak40Opr10;
	}
	
	/**
	 * Column Info
	 * @return opr10Wgt2
	 */
	public String getOpr10Wgt2() {
		return this.opr10Wgt2;
	}
	
	/**
	 * Column Info
	 * @return opr8Wgt45
	 */
	public String getOpr8Wgt45() {
		return this.opr8Wgt45;
	}
	
	/**
	 * Column Info
	 * @return opr8Wgt2h
	 */
	public String getOpr8Wgt2h() {
		return this.opr8Wgt2h;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return opr3Wgt2
	 */
	public String getOpr3Wgt2() {
		return this.opr3Wgt2;
	}
	
	/**
	 * Column Info
	 * @return rf2hTot
	 */
	public String getRf2hTot() {
		return this.rf2hTot;
	}
	
	/**
	 * Column Info
	 * @return opr3Wgt4
	 */
	public String getOpr3Wgt4() {
		return this.opr3Wgt4;
	}
	
	/**
	 * Column Info
	 * @return opr2Wgt2
	 */
	public String getOpr2Wgt2() {
		return this.opr2Wgt2;
	}
	
	/**
	 * Column Info
	 * @return ak20Opr10
	 */
	public String getAk20Opr10() {
		return this.ak20Opr10;
	}
	
	/**
	 * Column Info
	 * @return opr5Teu
	 */
	public String getOpr5Teu() {
		return this.opr5Teu;
	}
	
	/**
	 * Column Info
	 * @return totWgt45
	 */
	public String getTotWgt45() {
		return this.totWgt45;
	}
	
	/**
	 * Column Info
	 * @return opr2Wgt4
	 */
	public String getOpr2Wgt4() {
		return this.opr2Wgt4;
	}
	
	/**
	 * Column Info
	 * @return totWgt2h
	 */
	public String getTotWgt2h() {
		return this.totWgt2h;
	}
	
	/**
	 * Column Info
	 * @return opr5Qty2
	 */
	public String getOpr5Qty2() {
		return this.opr5Qty2;
	}
	
	/**
	 * Column Info
	 * @return opr5Qty4
	 */
	public String getOpr5Qty4() {
		return this.opr5Qty4;
	}
	
	/**
	 * Column Info
	 * @return bb20Opr7
	 */
	public String getBb20Opr7() {
		return this.bb20Opr7;
	}
	
	/**
	 * Column Info
	 * @return opr3Teu
	 */
	public String getOpr3Teu() {
		return this.opr3Teu;
	}
	
	/**
	 * Column Info
	 * @return bb20Opr8
	 */
	public String getBb20Opr8() {
		return this.bb20Opr8;
	}
	
	/**
	 * Column Info
	 * @return opr6Qty4h
	 */
	public String getOpr6Qty4h() {
		return this.opr6Qty4h;
	}
	
	/**
	 * Column Info
	 * @return bb20Opr9
	 */
	public String getBb20Opr9() {
		return this.bb20Opr9;
	}
	
	/**
	 * Column Info
	 * @return bb20Opr3
	 */
	public String getBb20Opr3() {
		return this.bb20Opr3;
	}
	
	/**
	 * Column Info
	 * @return totWgt4h
	 */
	public String getTotWgt4h() {
		return this.totWgt4h;
	}
	
	/**
	 * Column Info
	 * @return bb20Opr4
	 */
	public String getBb20Opr4() {
		return this.bb20Opr4;
	}
	
	/**
	 * Column Info
	 * @return rf40Tot
	 */
	public String getRf40Tot() {
		return this.rf40Tot;
	}
	
	/**
	 * Column Info
	 * @return bb20Opr5
	 */
	public String getBb20Opr5() {
		return this.bb20Opr5;
	}
	
	/**
	 * Column Info
	 * @return bb20Opr6
	 */
	public String getBb20Opr6() {
		return this.bb20Opr6;
	}
	
	/**
	 * Column Info
	 * @return opr10Qty2h
	 */
	public String getOpr10Qty2h() {
		return this.opr10Qty2h;
	}
	
	/**
	 * Column Info
	 * @return opr2Wgt2h
	 */
	public String getOpr2Wgt2h() {
		return this.opr2Wgt2h;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return opr1Qty2
	 */
	public String getOpr1Qty2() {
		return this.opr1Qty2;
	}
	
	/**
	 * Column Info
	 * @return qty10
	 */
	public String getQty10() {
		return this.qty10;
	}
	
	/**
	 * Column Info
	 * @return opr1Qty4
	 */
	public String getOpr1Qty4() {
		return this.opr1Qty4;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return dg45Opr8
	 */
	public String getDg45Opr8() {
		return this.dg45Opr8;
	}
	
	/**
	 * Column Info
	 * @return dg45Opr7
	 */
	public String getDg45Opr7() {
		return this.dg45Opr7;
	}
	
	/**
	 * Column Info
	 * @return dg45Opr6
	 */
	public String getDg45Opr6() {
		return this.dg45Opr6;
	}
	
	/**
	 * Column Info
	 * @return rf20Opr10
	 */
	public String getRf20Opr10() {
		return this.rf20Opr10;
	}
	
	/**
	 * Column Info
	 * @return dg45Opr5
	 */
	public String getDg45Opr5() {
		return this.dg45Opr5;
	}
	
	/**
	 * Column Info
	 * @return dg45Opr9
	 */
	public String getDg45Opr9() {
		return this.dg45Opr9;
	}
	
	/**
	 * Column Info
	 * @return bb20Opr2
	 */
	public String getBb20Opr2() {
		return this.bb20Opr2;
	}
	
	/**
	 * Column Info
	 * @return dg45Opr4
	 */
	public String getDg45Opr4() {
		return this.dg45Opr4;
	}
	
	/**
	 * Column Info
	 * @return bb20Opr1
	 */
	public String getBb20Opr1() {
		return this.bb20Opr1;
	}
	
	/**
	 * Column Info
	 * @return dg45Opr3
	 */
	public String getDg45Opr3() {
		return this.dg45Opr3;
	}
	
	/**
	 * Column Info
	 * @return dg45Opr2
	 */
	public String getDg45Opr2() {
		return this.dg45Opr2;
	}
	
	/**
	 * Column Info
	 * @return dg45Opr1
	 */
	public String getDg45Opr1() {
		return this.dg45Opr1;
	}
	
	/**
	 * Column Info
	 * @return dg40Tot
	 */
	public String getDg40Tot() {
		return this.dg40Tot;
	}
	
	/**
	 * Column Info
	 * @return opr6Qty2h
	 */
	public String getOpr6Qty2h() {
		return this.opr6Qty2h;
	}
	
	/**
	 * Column Info
	 * @return opr5Wgt4h
	 */
	public String getOpr5Wgt4h() {
		return this.opr5Wgt4h;
	}
	
	/**
	 * Column Info
	 * @return bb45Opr10
	 */
	public String getBb45Opr10() {
		return this.bb45Opr10;
	}
	
	/**
	 * Column Info
	 * @return dg40Opr10
	 */
	public String getDg40Opr10() {
		return this.dg40Opr10;
	}
	
	/**
	 * Column Info
	 * @return totTeu
	 */
	public String getTotTeu() {
		return this.totTeu;
	}
	
	/**
	 * Column Info
	 * @return stwgCgoFlg
	 */
	public String getStwgCgoFlg() {
		return this.stwgCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return opr6Qty45
	 */
	public String getOpr6Qty45() {
		return this.opr6Qty45;
	}
	
	/**
	 * Column Info
	 * @return dg4hOpr10
	 */
	public String getDg4hOpr10() {
		return this.dg4hOpr10;
	}
	
	/**
	 * Column Info
	 * @return opr8Wgt2
	 */
	public String getOpr8Wgt2() {
		return this.opr8Wgt2;
	}
	
	/**
	 * Column Info
	 * @return opr8Wgt4
	 */
	public String getOpr8Wgt4() {
		return this.opr8Wgt4;
	}
	
	/**
	 * Column Info
	 * @return cbfIndFlg
	 */
	public String getCbfIndFlg() {
		return this.cbfIndFlg;
	}
	
	/**
	 * Column Info
	 * @return rf4hOpr3
	 */
	public String getRf4hOpr3() {
		return this.rf4hOpr3;
	}
	
	/**
	 * Column Info
	 * @return bb4hOpr9
	 */
	public String getBb4hOpr9() {
		return this.bb4hOpr9;
	}
	
	/**
	 * Column Info
	 * @return rf4hOpr4
	 */
	public String getRf4hOpr4() {
		return this.rf4hOpr4;
	}
	
	/**
	 * Column Info
	 * @return rf4hOpr1
	 */
	public String getRf4hOpr1() {
		return this.rf4hOpr1;
	}
	
	/**
	 * Column Info
	 * @return rf4hOpr2
	 */
	public String getRf4hOpr2() {
		return this.rf4hOpr2;
	}
	
	/**
	 * Column Info
	 * @return bb4hOpr5
	 */
	public String getBb4hOpr5() {
		return this.bb4hOpr5;
	}
	
	/**
	 * Column Info
	 * @return rf4hOpr7
	 */
	public String getRf4hOpr7() {
		return this.rf4hOpr7;
	}
	
	/**
	 * Column Info
	 * @return bb4hOpr6
	 */
	public String getBb4hOpr6() {
		return this.bb4hOpr6;
	}
	
	/**
	 * Column Info
	 * @return rf4hOpr8
	 */
	public String getRf4hOpr8() {
		return this.rf4hOpr8;
	}
	
	/**
	 * Column Info
	 * @return rf4hOpr5
	 */
	public String getRf4hOpr5() {
		return this.rf4hOpr5;
	}
	
	/**
	 * Column Info
	 * @return bb4hOpr7
	 */
	public String getBb4hOpr7() {
		return this.bb4hOpr7;
	}
	
	/**
	 * Column Info
	 * @return rf4hOpr6
	 */
	public String getRf4hOpr6() {
		return this.rf4hOpr6;
	}
	
	/**
	 * Column Info
	 * @return bb4hOpr8
	 */
	public String getBb4hOpr8() {
		return this.bb4hOpr8;
	}
	
	/**
	 * Column Info
	 * @return opr3Qty45
	 */
	public String getOpr3Qty45() {
		return this.opr3Qty45;
	}
	
	/**
	 * Column Info
	 * @return bb4hOpr1
	 */
	public String getBb4hOpr1() {
		return this.bb4hOpr1;
	}
	
	/**
	 * Column Info
	 * @return bb4hOpr2
	 */
	public String getBb4hOpr2() {
		return this.bb4hOpr2;
	}
	
	/**
	 * Column Info
	 * @return ak20Opr9
	 */
	public String getAk20Opr9() {
		return this.ak20Opr9;
	}
	
	/**
	 * Column Info
	 * @return opr4Wgt2h
	 */
	public String getOpr4Wgt2h() {
		return this.opr4Wgt2h;
	}
	
	/**
	 * Column Info
	 * @return bb4hOpr3
	 */
	public String getBb4hOpr3() {
		return this.bb4hOpr3;
	}
	
	/**
	 * Column Info
	 * @return bb4hOpr4
	 */
	public String getBb4hOpr4() {
		return this.bb4hOpr4;
	}
	
	/**
	 * Column Info
	 * @return opr9Qty2
	 */
	public String getOpr9Qty2() {
		return this.opr9Qty2;
	}
	
	/**
	 * Column Info
	 * @return opr9Qty4
	 */
	public String getOpr9Qty4() {
		return this.opr9Qty4;
	}
	
	/**
	 * Column Info
	 * @return ak20Opr1
	 */
	public String getAk20Opr1() {
		return this.ak20Opr1;
	}
	
	/**
	 * Column Info
	 * @return ak20Opr2
	 */
	public String getAk20Opr2() {
		return this.ak20Opr2;
	}
	
	/**
	 * Column Info
	 * @return ak20Opr3
	 */
	public String getAk20Opr3() {
		return this.ak20Opr3;
	}
	
	/**
	 * Column Info
	 * @return ak20Opr4
	 */
	public String getAk20Opr4() {
		return this.ak20Opr4;
	}
	
	/**
	 * Column Info
	 * @return ak20Opr5
	 */
	public String getAk20Opr5() {
		return this.ak20Opr5;
	}
	
	/**
	 * Column Info
	 * @return ak20Opr6
	 */
	public String getAk20Opr6() {
		return this.ak20Opr6;
	}
	
	/**
	 * Column Info
	 * @return opr3Qty2h
	 */
	public String getOpr3Qty2h() {
		return this.opr3Qty2h;
	}
	
	/**
	 * Column Info
	 * @return ak20Opr7
	 */
	public String getAk20Opr7() {
		return this.ak20Opr7;
	}
	
	/**
	 * Column Info
	 * @return ak20Opr8
	 */
	public String getAk20Opr8() {
		return this.ak20Opr8;
	}
	
	/**
	 * Column Info
	 * @return stwgCd
	 */
	public String getStwgCd() {
		return this.stwgCd;
	}
	
	/**
	 * Column Info
	 * @return opr4Qty4h
	 */
	public String getOpr4Qty4h() {
		return this.opr4Qty4h;
	}
	
	/**
	 * Column Info
	 * @return rf4hOpr9
	 */
	public String getRf4hOpr9() {
		return this.rf4hOpr9;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return ak45Opr7
	 */
	public String getAk45Opr7() {
		return this.ak45Opr7;
	}
	
	/**
	 * Column Info
	 * @return ak45Opr6
	 */
	public String getAk45Opr6() {
		return this.ak45Opr6;
	}
	
	/**
	 * Column Info
	 * @return opr8Qty2h
	 */
	public String getOpr8Qty2h() {
		return this.opr8Qty2h;
	}
	
	/**
	 * Column Info
	 * @return ak45Opr9
	 */
	public String getAk45Opr9() {
		return this.ak45Opr9;
	}
	
	/**
	 * Column Info
	 * @return ak45Opr8
	 */
	public String getAk45Opr8() {
		return this.ak45Opr8;
	}
	
	/**
	 * Column Info
	 * @return totTtl
	 */
	public String getTotTtl() {
		return this.totTtl;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return opr8Qty45
	 */
	public String getOpr8Qty45() {
		return this.opr8Qty45;
	}
	
	/**
	 * Column Info
	 * @return ak45Opr1
	 */
	public String getAk45Opr1() {
		return this.ak45Opr1;
	}
	
	/**
	 * Column Info
	 * @return ak45Opr2
	 */
	public String getAk45Opr2() {
		return this.ak45Opr2;
	}
	
	/**
	 * Column Info
	 * @return ak45Opr3
	 */
	public String getAk45Opr3() {
		return this.ak45Opr3;
	}
	
	/**
	 * Column Info
	 * @return ak45Opr4
	 */
	public String getAk45Opr4() {
		return this.ak45Opr4;
	}
	
	/**
	 * Column Info
	 * @return ak45Opr5
	 */
	public String getAk45Opr5() {
		return this.ak45Opr5;
	}
	
	/**
	 * Column Info
	 * @return bb2hOpr9
	 */
	public String getBb2hOpr9() {
		return this.bb2hOpr9;
	}
	
	/**
	 * Column Info
	 * @return bb2hOpr8
	 */
	public String getBb2hOpr8() {
		return this.bb2hOpr8;
	}
	
	/**
	 * Column Info
	 * @return bb2hOpr7
	 */
	public String getBb2hOpr7() {
		return this.bb2hOpr7;
	}
	
	/**
	 * Column Info
	 * @return bb2hOpr6
	 */
	public String getBb2hOpr6() {
		return this.bb2hOpr6;
	}
	
	/**
	 * Column Info
	 * @return bb2hOpr5
	 */
	public String getBb2hOpr5() {
		return this.bb2hOpr5;
	}
	
	/**
	 * Column Info
	 * @return bb2hOpr4
	 */
	public String getBb2hOpr4() {
		return this.bb2hOpr4;
	}
	
	/**
	 * Column Info
	 * @return bb2hOpr3
	 */
	public String getBb2hOpr3() {
		return this.bb2hOpr3;
	}
	
	/**
	 * Column Info
	 * @return bb2hOpr2
	 */
	public String getBb2hOpr2() {
		return this.bb2hOpr2;
	}
	
	/**
	 * Column Info
	 * @return bb2hOpr1
	 */
	public String getBb2hOpr1() {
		return this.bb2hOpr1;
	}
	
	/**
	 * Column Info
	 * @return opr4Wgt4h
	 */
	public String getOpr4Wgt4h() {
		return this.opr4Wgt4h;
	}
	
	/**
	 * Column Info
	 * @return opr10Qty45
	 */
	public String getOpr10Qty45() {
		return this.opr10Qty45;
	}
	
	/**
	 * Column Info
	 * @return opr3Qty4h
	 */
	public String getOpr3Qty4h() {
		return this.opr3Qty4h;
	}
	
	/**
	 * Column Info
	 * @return opr6Wgt2
	 */
	public String getOpr6Wgt2() {
		return this.opr6Wgt2;
	}
	
	/**
	 * Column Info
	 * @return dg2hTot
	 */
	public String getDg2hTot() {
		return this.dg2hTot;
	}
	
	/**
	 * Column Info
	 * @return opr6Wgt4
	 */
	public String getOpr6Wgt4() {
		return this.opr6Wgt4;
	}
	
	/**
	 * Column Info
	 * @return ak45Tot
	 */
	public String getAk45Tot() {
		return this.ak45Tot;
	}
	
	/**
	 * Column Info
	 * @return rf4hTot
	 */
	public String getRf4hTot() {
		return this.rf4hTot;
	}
	
	/**
	 * Column Info
	 * @return opr10Qty4h
	 */
	public String getOpr10Qty4h() {
		return this.opr10Qty4h;
	}
	
	/**
	 * Column Info
	 * @return rf45Opr3
	 */
	public String getRf45Opr3() {
		return this.rf45Opr3;
	}
	
	/**
	 * Column Info
	 * @return rf45Opr2
	 */
	public String getRf45Opr2() {
		return this.rf45Opr2;
	}
	
	/**
	 * Column Info
	 * @return rf45Opr1
	 */
	public String getRf45Opr1() {
		return this.rf45Opr1;
	}
	
	/**
	 * Column Info
	 * @return opr4Wgt45
	 */
	public String getOpr4Wgt45() {
		return this.opr4Wgt45;
	}
	
	/**
	 * Column Info
	 * @return rf45Opr7
	 */
	public String getRf45Opr7() {
		return this.rf45Opr7;
	}
	
	/**
	 * Column Info
	 * @return rf45Opr6
	 */
	public String getRf45Opr6() {
		return this.rf45Opr6;
	}
	
	/**
	 * Column Info
	 * @return rf45Opr5
	 */
	public String getRf45Opr5() {
		return this.rf45Opr5;
	}
	
	/**
	 * Column Info
	 * @return bb40Opr9
	 */
	public String getBb40Opr9() {
		return this.bb40Opr9;
	}
	
	/**
	 * Column Info
	 * @return rf45Opr4
	 */
	public String getRf45Opr4() {
		return this.rf45Opr4;
	}
	
	/**
	 * Column Info
	 * @return bb40Opr7
	 */
	public String getBb40Opr7() {
		return this.bb40Opr7;
	}
	
	/**
	 * Column Info
	 * @return bb40Opr8
	 */
	public String getBb40Opr8() {
		return this.bb40Opr8;
	}
	
	/**
	 * Column Info
	 * @return bb40Opr5
	 */
	public String getBb40Opr5() {
		return this.bb40Opr5;
	}
	
	/**
	 * Column Info
	 * @return rf45Opr9
	 */
	public String getRf45Opr9() {
		return this.rf45Opr9;
	}
	
	/**
	 * Column Info
	 * @return bb40Opr6
	 */
	public String getBb40Opr6() {
		return this.bb40Opr6;
	}
	
	/**
	 * Column Info
	 * @return rf45Opr8
	 */
	public String getRf45Opr8() {
		return this.rf45Opr8;
	}
	
	/**
	 * Column Info
	 * @return totQty2h
	 */
	public String getTotQty2h() {
		return this.totQty2h;
	}
	
	/**
	 * Column Info
	 * @return opr1Qty4h
	 */
	public String getOpr1Qty4h() {
		return this.opr1Qty4h;
	}
	
	/**
	 * Column Info
	 * @return rf40Opr1
	 */
	public String getRf40Opr1() {
		return this.rf40Opr1;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return rf40Opr2
	 */
	public String getRf40Opr2() {
		return this.rf40Opr2;
	}
	
	/**
	 * Column Info
	 * @return rf40Opr3
	 */
	public String getRf40Opr3() {
		return this.rf40Opr3;
	}
	
	/**
	 * Column Info
	 * @return rf40Opr4
	 */
	public String getRf40Opr4() {
		return this.rf40Opr4;
	}
	
	/**
	 * Column Info
	 * @return rf40Opr5
	 */
	public String getRf40Opr5() {
		return this.rf40Opr5;
	}
	
	/**
	 * Column Info
	 * @return rf40Opr6
	 */
	public String getRf40Opr6() {
		return this.rf40Opr6;
	}
	
	/**
	 * Column Info
	 * @return dg20Tot
	 */
	public String getDg20Tot() {
		return this.dg20Tot;
	}
	
	/**
	 * Column Info
	 * @return rf40Opr7
	 */
	public String getRf40Opr7() {
		return this.rf40Opr7;
	}
	
	/**
	 * Column Info
	 * @return rf40Opr8
	 */
	public String getRf40Opr8() {
		return this.rf40Opr8;
	}
	
	/**
	 * Column Info
	 * @return rf40Opr9
	 */
	public String getRf40Opr9() {
		return this.rf40Opr9;
	}
	
	/**
	 * Column Info
	 * @return bb40Opr1
	 */
	public String getBb40Opr1() {
		return this.bb40Opr1;
	}
	
	/**
	 * Column Info
	 * @return totQty45
	 */
	public String getTotQty45() {
		return this.totQty45;
	}
	
	/**
	 * Column Info
	 * @return bb40Opr2
	 */
	public String getBb40Opr2() {
		return this.bb40Opr2;
	}
	
	/**
	 * Column Info
	 * @return bb40Opr3
	 */
	public String getBb40Opr3() {
		return this.bb40Opr3;
	}
	
	/**
	 * Column Info
	 * @return bb40Opr4
	 */
	public String getBb40Opr4() {
		return this.bb40Opr4;
	}
	
	/**
	 * Column Info
	 * @return bb40Tot
	 */
	public String getBb40Tot() {
		return this.bb40Tot;
	}
	
	/**
	 * Column Info
	 * @return opr7Qty2h
	 */
	public String getOpr7Qty2h() {
		return this.opr7Qty2h;
	}
	
	/**
	 * Column Info
	 * @return bb20Opr10
	 */
	public String getBb20Opr10() {
		return this.bb20Opr10;
	}
	
	/**
	 * Column Info
	 * @return opr7Qty45
	 */
	public String getOpr7Qty45() {
		return this.opr7Qty45;
	}
	
	/**
	 * Column Info
	 * @return rf45Opr10
	 */
	public String getRf45Opr10() {
		return this.rf45Opr10;
	}
	
	/**
	 * Column Info
	 * @return bb20Tot
	 */
	public String getBb20Tot() {
		return this.bb20Tot;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return totQty2
	 */
	public String getTotQty2() {
		return this.totQty2;
	}
	
	/**
	 * Column Info
	 * @return totQty4
	 */
	public String getTotQty4() {
		return this.totQty4;
	}
	
	/**
	 * Column Info
	 * @return opr8Qty4h
	 */
	public String getOpr8Qty4h() {
		return this.opr8Qty4h;
	}
	
	/**
	 * Column Info
	 * @return bkgShprOwnrFlg
	 */
	public String getBkgShprOwnrFlg() {
		return this.bkgShprOwnrFlg;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return opr7Qty4h
	 */
	public String getOpr7Qty4h() {
		return this.opr7Qty4h;
	}
	
	/**
	 * Column Info
	 * @return rf40Opr10
	 */
	public String getRf40Opr10() {
		return this.rf40Opr10;
	}
	
	/**
	 * Column Info
	 * @return pcCgoFlg
	 */
	public String getPcCgoFlg() {
		return this.pcCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return ak45Opr10
	 */
	public String getAk45Opr10() {
		return this.ak45Opr10;
	}
	
	/**
	 * Column Info
	 * @return opr10Teu
	 */
	public String getOpr10Teu() {
		return this.opr10Teu;
	}
	
	/**
	 * Column Info
	 * @return opr1Wgt2h
	 */
	public String getOpr1Wgt2h() {
		return this.opr1Wgt2h;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return opr7Wgt45
	 */
	public String getOpr7Wgt45() {
		return this.opr7Wgt45;
	}
	
	/**
	 * Column Info
	 * @return ak4hOpr2
	 */
	public String getAk4hOpr2() {
		return this.ak4hOpr2;
	}
	
	/**
	 * Column Info
	 * @return ak4hOpr1
	 */
	public String getAk4hOpr1() {
		return this.ak4hOpr1;
	}
	
	/**
	 * Column Info
	 * @return opr10Wgt4h
	 */
	public String getOpr10Wgt4h() {
		return this.opr10Wgt4h;
	}
	
	/**
	 * Column Info
	 * @return opr7Wgt2h
	 */
	public String getOpr7Wgt2h() {
		return this.opr7Wgt2h;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return dg45Opr10
	 */
	public String getDg45Opr10() {
		return this.dg45Opr10;
	}
	
	/**
	 * Column Info
	 * @return wg
	 */
	public String getWg() {
		return this.wg;
	}
	
	/**
	 * Column Info
	 * @return opr10Qty4
	 */
	public String getOpr10Qty4() {
		return this.opr10Qty4;
	}
	
	/**
	 * Column Info
	 * @return opr10Qty2
	 */
	public String getOpr10Qty2() {
		return this.opr10Qty2;
	}
	
	/**
	 * Column Info
	 * @return bb4hOpr10
	 */
	public String getBb4hOpr10() {
		return this.bb4hOpr10;
	}
	
	/**
	 * Column Info
	 * @return ak4hOpr5
	 */
	public String getAk4hOpr5() {
		return this.ak4hOpr5;
	}
	
	/**
	 * Column Info
	 * @return ak4hOpr6
	 */
	public String getAk4hOpr6() {
		return this.ak4hOpr6;
	}
	
	/**
	 * Column Info
	 * @return ak4hOpr3
	 */
	public String getAk4hOpr3() {
		return this.ak4hOpr3;
	}
	
	/**
	 * Column Info
	 * @return crrCd2
	 */
	public String getCrrCd2() {
		return this.crrCd2;
	}
	
	/**
	 * Column Info
	 * @return ak4hOpr4
	 */
	public String getAk4hOpr4() {
		return this.ak4hOpr4;
	}
	
	/**
	 * Column Info
	 * @return ak4hOpr9
	 */
	public String getAk4hOpr9() {
		return this.ak4hOpr9;
	}
	
	/**
	 * Column Info
	 * @return ak4hOpr7
	 */
	public String getAk4hOpr7() {
		return this.ak4hOpr7;
	}
	
	/**
	 * Column Info
	 * @return opr1Qty45
	 */
	public String getOpr1Qty45() {
		return this.opr1Qty45;
	}
	
	/**
	 * Column Info
	 * @return ak4hOpr8
	 */
	public String getAk4hOpr8() {
		return this.ak4hOpr8;
	}
	
	/**
	 * Column Info
	 * @return opr8Teu
	 */
	public String getOpr8Teu() {
		return this.opr8Teu;
	}
	
	/**
	 * Column Info
	 * @return opr10
	 */
	public String getOpr10() {
		return this.opr10;
	}
	
	/**
	 * Column Info
	 * @return opr1Qty2h
	 */
	public String getOpr1Qty2h() {
		return this.opr1Qty2h;
	}
	
	/**
	 * Column Info
	 * @return opr1Wgt45
	 */
	public String getOpr1Wgt45() {
		return this.opr1Wgt45;
	}
	
	/**
	 * Column Info
	 * @return sort
	 */
	public String getSort() {
		return this.sort;
	}
	
	/**
	 * Column Info
	 * @return opr1Teu
	 */
	public String getOpr1Teu() {
		return this.opr1Teu;
	}
	
	/**
	 * Column Info
	 * @return rf45Tot
	 */
	public String getRf45Tot() {
		return this.rf45Tot;
	}
	
	/**
	 * Column Info
	 * @return opr7Wgt4h
	 */
	public String getOpr7Wgt4h() {
		return this.opr7Wgt4h;
	}
	
	/**
	 * Column Info
	 * @return opr4Qty2
	 */
	public String getOpr4Qty2() {
		return this.opr4Qty2;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return totQty4h
	 */
	public String getTotQty4h() {
		return this.totQty4h;
	}
	
	/**
	 * Column Info
	 * @return bb40Opr10
	 */
	public String getBb40Opr10() {
		return this.bb40Opr10;
	}
	
	/**
	 * Column Info
	 * @return opr2Qty4
	 */
	public String getOpr2Qty4() {
		return this.opr2Qty4;
	}
	
	/**
	 * Column Info
	 * @return opr2Qty2
	 */
	public String getOpr2Qty2() {
		return this.opr2Qty2;
	}
	
	/**
	 * Column Info
	 * @return opr9Wgt2
	 */
	public String getOpr9Wgt2() {
		return this.opr9Wgt2;
	}
	
	/**
	 * Column Info
	 * @return stwgNm
	 */
	public String getStwgNm() {
		return this.stwgNm;
	}
	
	/**
	 * Column Info
	 * @return opr9Wgt4
	 */
	public String getOpr9Wgt4() {
		return this.opr9Wgt4;
	}
	
	/**
	 * Column Info
	 * @return opr1Wgt4
	 */
	public String getOpr1Wgt4() {
		return this.opr1Wgt4;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
	}
	
	/**
	 * Column Info
	 * @return opr1Wgt2
	 */
	public String getOpr1Wgt2() {
		return this.opr1Wgt2;
	}
	
	/**
	 * Column Info
	 * @return opr7Wgt4
	 */
	public String getOpr7Wgt4() {
		return this.opr7Wgt4;
	}
	
	/**
	 * Column Info
	 * @return opr7Wgt2
	 */
	public String getOpr7Wgt2() {
		return this.opr7Wgt2;
	}
	
	/**
	 * Column Info
	 * @return opr8Qty4
	 */
	public String getOpr8Qty4() {
		return this.opr8Qty4;
	}
	
	/**
	 * Column Info
	 * @return opr8Qty2
	 */
	public String getOpr8Qty2() {
		return this.opr8Qty2;
	}
	
	/**
	 * Column Info
	 * @return opr4Qty4
	 */
	public String getOpr4Qty4() {
		return this.opr4Qty4;
	}
	
	/**
	 * Column Info
	 * @return opr9Qty2h
	 */
	public String getOpr9Qty2h() {
		return this.opr9Qty2h;
	}
	
	/**
	 * Column Info
	 * @return opr7Teu
	 */
	public String getOpr7Teu() {
		return this.opr7Teu;
	}
	
	/**
	 * Column Info
	 * @return opr9Qty45
	 */
	public String getOpr9Qty45() {
		return this.opr9Qty45;
	}
	
	/**
	 * Column Info
	 * @return unit2
	 */
	public String getUnit2() {
		return this.unit2;
	}
	
	/**
	 * Column Info
	 * @return unit4
	 */
	public String getUnit4() {
		return this.unit4;
	}
	
	/**
	 * Column Info
	 * @return opr6Teu
	 */
	public String getOpr6Teu() {
		return this.opr6Teu;
	}
	
	/**
	 * Column Info
	 * @return opr4Teu
	 */
	public String getOpr4Teu() {
		return this.opr4Teu;
	}
	
	/**
	 * Column Info
	 * @return opr3Qty4
	 */
	public String getOpr3Qty4() {
		return this.opr3Qty4;
	}
	
	/**
	 * Column Info
	 * @return opr1Wgt4h
	 */
	public String getOpr1Wgt4h() {
		return this.opr1Wgt4h;
	}
	
	/**
	 * Column Info
	 * @return opr10Wgt45
	 */
	public String getOpr10Wgt45() {
		return this.opr10Wgt45;
	}
	
	/**
	 * Column Info
	 * @return opr10Wgt2h
	 */
	public String getOpr10Wgt2h() {
		return this.opr10Wgt2h;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return opr7
	 */
	public String getOpr7() {
		return this.opr7;
	}
	
	/**
	 * Column Info
	 * @return opr8
	 */
	public String getOpr8() {
		return this.opr8;
	}
	
	/**
	 * Column Info
	 * @return opr5
	 */
	public String getOpr5() {
		return this.opr5;
	}
	
	/**
	 * Column Info
	 * @return opr6
	 */
	public String getOpr6() {
		return this.opr6;
	}
	
	/**
	 * Column Info
	 * @return opr3
	 */
	public String getOpr3() {
		return this.opr3;
	}
	
	/**
	 * Column Info
	 * @return opr4
	 */
	public String getOpr4() {
		return this.opr4;
	}
	
	/**
	 * Column Info
	 * @return opr1
	 */
	public String getOpr1() {
		return this.opr1;
	}
	
	/**
	 * Column Info
	 * @return opr2
	 */
	public String getOpr2() {
		return this.opr2;
	}
	
	/**
	 * Column Info
	 * @return opr4Wgt4
	 */
	public String getOpr4Wgt4() {
		return this.opr4Wgt4;
	}
	
	/**
	 * Column Info
	 * @return opr4Wgt2
	 */
	public String getOpr4Wgt2() {
		return this.opr4Wgt2;
	}
	
	/**
	 * Column Info
	 * @return opr4Qty2h
	 */
	public String getOpr4Qty2h() {
		return this.opr4Qty2h;
	}
	
	/**
	 * Column Info
	 * @return opr9
	 */
	public String getOpr9() {
		return this.opr9;
	}
	
	/**
	 * Column Info
	 * @return opr4Qty45
	 */
	public String getOpr4Qty45() {
		return this.opr4Qty45;
	}
	
	/**
	 * Column Info
	 * @return rf2hOpr2
	 */
	public String getRf2hOpr2() {
		return this.rf2hOpr2;
	}
	
	/**
	 * Column Info
	 * @return opr6Qty4
	 */
	public String getOpr6Qty4() {
		return this.opr6Qty4;
	}
	
	/**
	 * Column Info
	 * @return rf2hOpr1
	 */
	public String getRf2hOpr1() {
		return this.rf2hOpr1;
	}
	
	/**
	 * Column Info
	 * @return opr6Qty2
	 */
	public String getOpr6Qty2() {
		return this.opr6Qty2;
	}
	
	/**
	 * Column Info
	 * @return opr5Qty2h
	 */
	public String getOpr5Qty2h() {
		return this.opr5Qty2h;
	}
	
	/**
	 * Column Info
	 * @return rf2hOpr6
	 */
	public String getRf2hOpr6() {
		return this.rf2hOpr6;
	}
	
	/**
	 * Column Info
	 * @return opr2Qty2h
	 */
	public String getOpr2Qty2h() {
		return this.opr2Qty2h;
	}
	
	/**
	 * Column Info
	 * @return rf2hOpr5
	 */
	public String getRf2hOpr5() {
		return this.rf2hOpr5;
	}
	
	/**
	 * Column Info
	 * @return rf2hOpr4
	 */
	public String getRf2hOpr4() {
		return this.rf2hOpr4;
	}
	
	/**
	 * Column Info
	 * @return rf4hOpr10
	 */
	public String getRf4hOpr10() {
		return this.rf4hOpr10;
	}
	
	/**
	 * Column Info
	 * @return rf2hOpr3
	 */
	public String getRf2hOpr3() {
		return this.rf2hOpr3;
	}
	
	/**
	 * Column Info
	 * @return rf20Opr8
	 */
	public String getRf20Opr8() {
		return this.rf20Opr8;
	}
	
	/**
	 * Column Info
	 * @return rf20Opr7
	 */
	public String getRf20Opr7() {
		return this.rf20Opr7;
	}
	
	/**
	 * Column Info
	 * @return rf20Opr9
	 */
	public String getRf20Opr9() {
		return this.rf20Opr9;
	}
	
	/**
	 * Column Info
	 * @return rf20Opr4
	 */
	public String getRf20Opr4() {
		return this.rf20Opr4;
	}
	
	/**
	 * Column Info
	 * @return dg40Opr5
	 */
	public String getDg40Opr5() {
		return this.dg40Opr5;
	}
	
	/**
	 * Column Info
	 * @return rf2hOpr9
	 */
	public String getRf2hOpr9() {
		return this.rf2hOpr9;
	}
	
	/**
	 * Column Info
	 * @return ak4hTot
	 */
	public String getAk4hTot() {
		return this.ak4hTot;
	}
	
	/**
	 * Column Info
	 * @return opr2Qty45
	 */
	public String getOpr2Qty45() {
		return this.opr2Qty45;
	}
	
	/**
	 * Column Info
	 * @return rf20Opr3
	 */
	public String getRf20Opr3() {
		return this.rf20Opr3;
	}
	
	/**
	 * Column Info
	 * @return dg40Opr4
	 */
	public String getDg40Opr4() {
		return this.dg40Opr4;
	}
	
	/**
	 * Column Info
	 * @return qty1
	 */
	public String getQty1() {
		return this.qty1;
	}
	
	/**
	 * Column Info
	 * @return dg40Opr3
	 */
	public String getDg40Opr3() {
		return this.dg40Opr3;
	}
	
	/**
	 * Column Info
	 * @return rf20Opr6
	 */
	public String getRf20Opr6() {
		return this.rf20Opr6;
	}
	
	/**
	 * Column Info
	 * @return rf2hOpr7
	 */
	public String getRf2hOpr7() {
		return this.rf2hOpr7;
	}
	
	/**
	 * Column Info
	 * @return dg40Opr2
	 */
	public String getDg40Opr2() {
		return this.dg40Opr2;
	}
	
	/**
	 * Column Info
	 * @return rf20Opr5
	 */
	public String getRf20Opr5() {
		return this.rf20Opr5;
	}
	
	/**
	 * Column Info
	 * @return rf2hOpr8
	 */
	public String getRf2hOpr8() {
		return this.rf2hOpr8;
	}
	
	/**
	 * Column Info
	 * @return qty3
	 */
	public String getQty3() {
		return this.qty3;
	}
	
	/**
	 * Column Info
	 * @return dg40Opr9
	 */
	public String getDg40Opr9() {
		return this.dg40Opr9;
	}
	
	/**
	 * Column Info
	 * @return qty2
	 */
	public String getQty2() {
		return this.qty2;
	}
	
	/**
	 * Column Info
	 * @return dg40Opr8
	 */
	public String getDg40Opr8() {
		return this.dg40Opr8;
	}
	
	/**
	 * Column Info
	 * @return opr5Qty45
	 */
	public String getOpr5Qty45() {
		return this.opr5Qty45;
	}
	
	/**
	 * Column Info
	 * @return qty5
	 */
	public String getQty5() {
		return this.qty5;
	}
	
	/**
	 * Column Info
	 * @return rf20Opr2
	 */
	public String getRf20Opr2() {
		return this.rf20Opr2;
	}
	
	/**
	 * Column Info
	 * @return dg40Opr7
	 */
	public String getDg40Opr7() {
		return this.dg40Opr7;
	}
	
	/**
	 * Column Info
	 * @return qty4
	 */
	public String getQty4() {
		return this.qty4;
	}
	
	/**
	 * Column Info
	 * @return rf20Opr1
	 */
	public String getRf20Opr1() {
		return this.rf20Opr1;
	}
	
	/**
	 * Column Info
	 * @return dg40Opr6
	 */
	public String getDg40Opr6() {
		return this.dg40Opr6;
	}
	
	/**
	 * Column Info
	 * @return opr9Wgt45
	 */
	public String getOpr9Wgt45() {
		return this.opr9Wgt45;
	}
	
	/**
	 * Column Info
	 * @return dg4hOpr1
	 */
	public String getDg4hOpr1() {
		return this.dg4hOpr1;
	}
	
	/**
	 * Column Info
	 * @return opr3Qty2
	 */
	public String getOpr3Qty2() {
		return this.opr3Qty2;
	}
	
	/**
	 * Column Info
	 * @return dg4hOpr7
	 */
	public String getDg4hOpr7() {
		return this.dg4hOpr7;
	}
	
	/**
	 * Column Info
	 * @return dg4hOpr6
	 */
	public String getDg4hOpr6() {
		return this.dg4hOpr6;
	}
	
	/**
	 * Column Info
	 * @return dg4hOpr9
	 */
	public String getDg4hOpr9() {
		return this.dg4hOpr9;
	}
	
	/**
	 * Column Info
	 * @return dg4hOpr8
	 */
	public String getDg4hOpr8() {
		return this.dg4hOpr8;
	}
	
	/**
	 * Column Info
	 * @return dg4hOpr3
	 */
	public String getDg4hOpr3() {
		return this.dg4hOpr3;
	}
	
	/**
	 * Column Info
	 * @return opr2Teu
	 */
	public String getOpr2Teu() {
		return this.opr2Teu;
	}
	
	/**
	 * Column Info
	 * @return dg4hOpr2
	 */
	public String getDg4hOpr2() {
		return this.dg4hOpr2;
	}
	
	/**
	 * Column Info
	 * @return opr9Wgt2h
	 */
	public String getOpr9Wgt2h() {
		return this.opr9Wgt2h;
	}
	
	/**
	 * Column Info
	 * @return dg4hOpr5
	 */
	public String getDg4hOpr5() {
		return this.dg4hOpr5;
	}
	
	/**
	 * Column Info
	 * @return dg4hOpr4
	 */
	public String getDg4hOpr4() {
		return this.dg4hOpr4;
	}
	
	/**
	 * Column Info
	 * @return ak4hOpr10
	 */
	public String getAk4hOpr10() {
		return this.ak4hOpr10;
	}
	
	/**
	 * Column Info
	 * @return dg20Opr10
	 */
	public String getDg20Opr10() {
		return this.dg20Opr10;
	}
	
	/**
	 * Column Info
	 * @return opr2Qty4h
	 */
	public String getOpr2Qty4h() {
		return this.opr2Qty4h;
	}
	
	/**
	 * Column Info
	 * @return opr2Wgt4h
	 */
	public String getOpr2Wgt4h() {
		return this.opr2Wgt4h;
	}
	
	/**
	 * Column Info
	 * @return opr7Qty4
	 */
	public String getOpr7Qty4() {
		return this.opr7Qty4;
	}
	
	/**
	 * Column Info
	 * @return opr7Qty2
	 */
	public String getOpr7Qty2() {
		return this.opr7Qty2;
	}
	
	/**
	 * Column Info
	 * @return dg20Opr1
	 */
	public String getDg20Opr1() {
		return this.dg20Opr1;
	}
	
	/**
	 * Column Info
	 * @return dg20Opr3
	 */
	public String getDg20Opr3() {
		return this.dg20Opr3;
	}
	
	/**
	 * Column Info
	 * @return dg20Opr2
	 */
	public String getDg20Opr2() {
		return this.dg20Opr2;
	}
	
	/**
	 * Column Info
	 * @return dg2hOpr10
	 */
	public String getDg2hOpr10() {
		return this.dg2hOpr10;
	}
	
	/**
	 * Column Info
	 * @return dg20Opr5
	 */
	public String getDg20Opr5() {
		return this.dg20Opr5;
	}
	
	/**
	 * Column Info
	 * @return dg20Opr4
	 */
	public String getDg20Opr4() {
		return this.dg20Opr4;
	}
	
	/**
	 * Column Info
	 * @return dg20Opr7
	 */
	public String getDg20Opr7() {
		return this.dg20Opr7;
	}
	
	/**
	 * Column Info
	 * @return dg20Opr6
	 */
	public String getDg20Opr6() {
		return this.dg20Opr6;
	}
	
	/**
	 * Column Info
	 * @return dg20Opr9
	 */
	public String getDg20Opr9() {
		return this.dg20Opr9;
	}
	
	/**
	 * Column Info
	 * @return dg20Opr8
	 */
	public String getDg20Opr8() {
		return this.dg20Opr8;
	}
	
	/**
	 * Column Info
	 * @return dg4hTot
	 */
	public String getDg4hTot() {
		return this.dg4hTot;
	}
	
	/**
	 * Column Info
	 * @return qty8
	 */
	public String getQty8() {
		return this.qty8;
	}
	
	/**
	 * Column Info
	 * @return qty9
	 */
	public String getQty9() {
		return this.qty9;
	}
	
	/**
	 * Column Info
	 * @return qty6
	 */
	public String getQty6() {
		return this.qty6;
	}
	
	/**
	 * Column Info
	 * @return qty7
	 */
	public String getQty7() {
		return this.qty7;
	}
	
	/**
	 * Column Info
	 * @return dg2hOpr4
	 */
	public String getDg2hOpr4() {
		return this.dg2hOpr4;
	}
	
	/**
	 * Column Info
	 * @return dg2hOpr5
	 */
	public String getDg2hOpr5() {
		return this.dg2hOpr5;
	}
	
	/**
	 * Column Info
	 * @return dg2hOpr6
	 */
	public String getDg2hOpr6() {
		return this.dg2hOpr6;
	}
	
	/**
	 * Column Info
	 * @return dg2hOpr7
	 */
	public String getDg2hOpr7() {
		return this.dg2hOpr7;
	}
	
	/**
	 * Column Info
	 * @return opr2Wgt45
	 */
	public String getOpr2Wgt45() {
		return this.opr2Wgt45;
	}
	
	/**
	 * Column Info
	 * @return dg2hOpr1
	 */
	public String getDg2hOpr1() {
		return this.dg2hOpr1;
	}
	
	/**
	 * Column Info
	 * @return dg2hOpr2
	 */
	public String getDg2hOpr2() {
		return this.dg2hOpr2;
	}
	
	/**
	 * Column Info
	 * @return dg2hOpr3
	 */
	public String getDg2hOpr3() {
		return this.dg2hOpr3;
	}
	
	/**
	 * Column Info
	 * @return opr9Qty4h
	 */
	public String getOpr9Qty4h() {
		return this.opr9Qty4h;
	}
	
	/**
	 * Column Info
	 * @return opr6Wgt2h
	 */
	public String getOpr6Wgt2h() {
		return this.opr6Wgt2h;
	}
	
	/**
	 * Column Info
	 * @return opr6Wgt45
	 */
	public String getOpr6Wgt45() {
		return this.opr6Wgt45;
	}
	
	/**
	 * Column Info
	 * @return dg2hOpr8
	 */
	public String getDg2hOpr8() {
		return this.dg2hOpr8;
	}
	
	/**
	 * Column Info
	 * @return dg2hOpr9
	 */
	public String getDg2hOpr9() {
		return this.dg2hOpr9;
	}
	
	/**
	 * Column Info
	 * @return rf20Tot
	 */
	public String getRf20Tot() {
		return this.rf20Tot;
	}
	
	/**
	 * Column Info
	 * @return totWgt2
	 */
	public String getTotWgt2() {
		return this.totWgt2;
	}
	
	/**
	 * Column Info
	 * @return opr3Wgt2h
	 */
	public String getOpr3Wgt2h() {
		return this.opr3Wgt2h;
	}
	
	/**
	 * Column Info
	 * @return totWgt4
	 */
	public String getTotWgt4() {
		return this.totWgt4;
	}
	
	/**
	 * Column Info
	 * @return mlb
	 */
	public String getMlb() {
		return this.mlb;
	}
	
	/**
	 * Column Info
	 * @return bb45Opr1
	 */
	public String getBb45Opr1() {
		return this.bb45Opr1;
	}
	
	/**
	 * Column Info
	 * @return opr3Wgt45
	 */
	public String getOpr3Wgt45() {
		return this.opr3Wgt45;
	}
	
	/**
	 * Column Info
	 * @return bb45Opr3
	 */
	public String getBb45Opr3() {
		return this.bb45Opr3;
	}
	
	/**
	 * Column Info
	 * @return bb45Opr2
	 */
	public String getBb45Opr2() {
		return this.bb45Opr2;
	}
	
	/**
	 * Column Info
	 * @return bb45Opr5
	 */
	public String getBb45Opr5() {
		return this.bb45Opr5;
	}
	
	/**
	 * Column Info
	 * @return bb45Opr4
	 */
	public String getBb45Opr4() {
		return this.bb45Opr4;
	}
	
	/**
	 * Column Info
	 * @return awkCgoFlg
	 */
	public String getAwkCgoFlg() {
		return this.awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return bb45Opr7
	 */
	public String getBb45Opr7() {
		return this.bb45Opr7;
	}
	
	/**
	 * Column Info
	 * @return bb45Opr6
	 */
	public String getBb45Opr6() {
		return this.bb45Opr6;
	}
	
	/**
	 * Column Info
	 * @return bb45Opr9
	 */
	public String getBb45Opr9() {
		return this.bb45Opr9;
	}
	
	/**
	 * Column Info
	 * @return bb45Opr8
	 */
	public String getBb45Opr8() {
		return this.bb45Opr8;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
	}
	
	/**
	 * Column Info
	 * @return opr6Wgt4h
	 */
	public String getOpr6Wgt4h() {
		return this.opr6Wgt4h;
	}
	
	/**
	 * Column Info
	 * @return avWgt2
	 */
	public String getAvWgt2() {
		return this.avWgt2;
	}
	
	/**
	 * Column Info
	 * @return avWgt4
	 */
	public String getAvWgt4() {
		return this.avWgt4;
	}
	
	/**
	 * Column Info
	 * @return ak40Tot
	 */
	public String getAk40Tot() {
		return this.ak40Tot;
	}
	
	/**
	 * Column Info
	 * @return ak40Opr7
	 */
	public String getAk40Opr7() {
		return this.ak40Opr7;
	}
	
	/**
	 * Column Info
	 * @return ak40Opr8
	 */
	public String getAk40Opr8() {
		return this.ak40Opr8;
	}
	
	/**
	 * Column Info
	 * @return rf2hOpr10
	 */
	public String getRf2hOpr10() {
		return this.rf2hOpr10;
	}
	
	/**
	 * Column Info
	 * @return ak40Opr9
	 */
	public String getAk40Opr9() {
		return this.ak40Opr9;
	}
	
	/**
	 * Column Info
	 * @return opr5Wgt2h
	 */
	public String getOpr5Wgt2h() {
		return this.opr5Wgt2h;
	}
	
	/**
	 * Column Info
	 * @return ak40Opr3
	 */
	public String getAk40Opr3() {
		return this.ak40Opr3;
	}
	
	/**
	 * Column Info
	 * @return ak40Opr4
	 */
	public String getAk40Opr4() {
		return this.ak40Opr4;
	}
	
	/**
	 * Column Info
	 * @return ak40Opr5
	 */
	public String getAk40Opr5() {
		return this.ak40Opr5;
	}
	
	/**
	 * Column Info
	 * @return opr5Qty4h
	 */
	public String getOpr5Qty4h() {
		return this.opr5Qty4h;
	}
	
	/**
	 * Column Info
	 * @return ak40Opr6
	 */
	public String getAk40Opr6() {
		return this.ak40Opr6;
	}
	
	/**
	 * Column Info
	 * @return ak40Opr1
	 */
	public String getAk40Opr1() {
		return this.ak40Opr1;
	}
	
	/**
	 * Column Info
	 * @return ak40Opr2
	 */
	public String getAk40Opr2() {
		return this.ak40Opr2;
	}
	
	/**
	 * Column Info
	 * @return opr3Wgt4h
	 */
	public String getOpr3Wgt4h() {
		return this.opr3Wgt4h;
	}
	
	/**
	 * Column Info
	 * @return bbCgoFlg
	 */
	public String getBbCgoFlg() {
		return this.bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return opr9Teu
	 */
	public String getOpr9Teu() {
		return this.opr9Teu;
	}
	
	/**
	 * Column Info
	 * @return mlbCd
	 */
	public String getMlbCd() {
		return this.mlbCd;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return opr9Wgt4h
	 */
	public String getOpr9Wgt4h() {
		return this.opr9Wgt4h;
	}
	
	/**
	 * Column Info
	 * @return dg40Opr1
	 */
	public String getDg40Opr1() {
		return this.dg40Opr1;
	}
	
	/**
	 * Column Info
	 * @return opr5Wgt45
	 */
	public String getOpr5Wgt45() {
		return this.opr5Wgt45;
	}
	
	/**
	 * Column Info
	 * @return ak2hOpr2
	 */
	public String getAk2hOpr2() {
		return this.ak2hOpr2;
	}
	
	/**
	 * Column Info
	 * @return ak2hOpr1
	 */
	public String getAk2hOpr1() {
		return this.ak2hOpr1;
	}
	
	/**
	 * Column Info
	 * @return ak2hOpr4
	 */
	public String getAk2hOpr4() {
		return this.ak2hOpr4;
	}
	
	/**
	 * Column Info
	 * @return ak2hOpr3
	 */
	public String getAk2hOpr3() {
		return this.ak2hOpr3;
	}
	
	/**
	 * Column Info
	 * @return ak2hOpr6
	 */
	public String getAk2hOpr6() {
		return this.ak2hOpr6;
	}
	
	/**
	 * Column Info
	 * @return ak2hOpr5
	 */
	public String getAk2hOpr5() {
		return this.ak2hOpr5;
	}
	
	/**
	 * Column Info
	 * @return ak2hOpr8
	 */
	public String getAk2hOpr8() {
		return this.ak2hOpr8;
	}
	
	/**
	 * Column Info
	 * @return ak2hOpr7
	 */
	public String getAk2hOpr7() {
		return this.ak2hOpr7;
	}
	
	/**
	 * Column Info
	 * @return ak2hOpr9
	 */
	public String getAk2hOpr9() {
		return this.ak2hOpr9;
	}
	
	/**
	 * Column Info
	 * @return dg45Tot
	 */
	public String getDg45Tot() {
		return this.dg45Tot;
	}
	

	public String getStwg20Opr1() {
		return stwg20Opr1;
	}

	public void setStwg20Opr1(String stwg20Opr1) {
		this.stwg20Opr1 = stwg20Opr1;
	}

	public String getStwg2hOpr1() {
		return stwg2hOpr1;
	}

	public void setStwg2hOpr1(String stwg2hOpr1) {
		this.stwg2hOpr1 = stwg2hOpr1;
	}

	public String getStwg40Opr1() {
		return stwg40Opr1;
	}

	public void setStwg40Opr1(String stwg40Opr1) {
		this.stwg40Opr1 = stwg40Opr1;
	}

	public String getStwg4hOpr1() {
		return stwg4hOpr1;
	}

	public void setStwg4hOpr1(String stwg4hOpr1) {
		this.stwg4hOpr1 = stwg4hOpr1;
	}

	public String getStwg45Opr1() {
		return stwg45Opr1;
	}

	public void setStwg45Opr1(String stwg45Opr1) {
		this.stwg45Opr1 = stwg45Opr1;
	}

	public String getStwg20Opr2() {
		return stwg20Opr2;
	}

	public void setStwg20Opr2(String stwg20Opr2) {
		this.stwg20Opr2 = stwg20Opr2;
	}

	public String getStwg2hOpr2() {
		return stwg2hOpr2;
	}

	public void setStwg2hOpr2(String stwg2hOpr2) {
		this.stwg2hOpr2 = stwg2hOpr2;
	}

	public String getStwg40Opr2() {
		return stwg40Opr2;
	}

	public void setStwg40Opr2(String stwg40Opr2) {
		this.stwg40Opr2 = stwg40Opr2;
	}

	public String getStwg4hOpr2() {
		return stwg4hOpr2;
	}

	public void setStwg4hOpr2(String stwg4hOpr2) {
		this.stwg4hOpr2 = stwg4hOpr2;
	}

	public String getStwg45Opr2() {
		return stwg45Opr2;
	}

	public void setStwg45Opr2(String stwg45Opr2) {
		this.stwg45Opr2 = stwg45Opr2;
	}

	public String getStwg20Opr3() {
		return stwg20Opr3;
	}

	public void setStwg20Opr3(String stwg20Opr3) {
		this.stwg20Opr3 = stwg20Opr3;
	}

	public String getStwg2hOpr3() {
		return stwg2hOpr3;
	}

	public void setStwg2hOpr3(String stwg2hOpr3) {
		this.stwg2hOpr3 = stwg2hOpr3;
	}

	public String getStwg40Opr3() {
		return stwg40Opr3;
	}

	public void setStwg40Opr3(String stwg40Opr3) {
		this.stwg40Opr3 = stwg40Opr3;
	}

	public String getStwg4hOpr3() {
		return stwg4hOpr3;
	}

	public void setStwg4hOpr3(String stwg4hOpr3) {
		this.stwg4hOpr3 = stwg4hOpr3;
	}

	public String getStwg45Opr3() {
		return stwg45Opr3;
	}

	public void setStwg45Opr3(String stwg45Opr3) {
		this.stwg45Opr3 = stwg45Opr3;
	}

	public String getStwg20Opr4() {
		return stwg20Opr4;
	}

	public void setStwg20Opr4(String stwg20Opr4) {
		this.stwg20Opr4 = stwg20Opr4;
	}

	public String getStwg2hOpr4() {
		return stwg2hOpr4;
	}

	public void setStwg2hOpr4(String stwg2hOpr4) {
		this.stwg2hOpr4 = stwg2hOpr4;
	}

	public String getStwg40Opr4() {
		return stwg40Opr4;
	}

	public void setStwg40Opr4(String stwg40Opr4) {
		this.stwg40Opr4 = stwg40Opr4;
	}

	public String getStwg4hOpr4() {
		return stwg4hOpr4;
	}

	public void setStwg4hOpr4(String stwg4hOpr4) {
		this.stwg4hOpr4 = stwg4hOpr4;
	}

	public String getStwg45Opr4() {
		return stwg45Opr4;
	}

	public void setStwg45Opr4(String stwg45Opr4) {
		this.stwg45Opr4 = stwg45Opr4;
	}

	public String getStwg20Opr5() {
		return stwg20Opr5;
	}

	public void setStwg20Opr5(String stwg20Opr5) {
		this.stwg20Opr5 = stwg20Opr5;
	}

	public String getStwg2hOpr5() {
		return stwg2hOpr5;
	}

	public void setStwg2hOpr5(String stwg2hOpr5) {
		this.stwg2hOpr5 = stwg2hOpr5;
	}

	public String getStwg40Opr5() {
		return stwg40Opr5;
	}

	public void setStwg40Opr5(String stwg40Opr5) {
		this.stwg40Opr5 = stwg40Opr5;
	}

	public String getStwg4hOpr5() {
		return stwg4hOpr5;
	}

	public void setStwg4hOpr5(String stwg4hOpr5) {
		this.stwg4hOpr5 = stwg4hOpr5;
	}

	public String getStwg45Opr5() {
		return stwg45Opr5;
	}

	public void setStwg45Opr5(String stwg45Opr5) {
		this.stwg45Opr5 = stwg45Opr5;
	}

	public String getStwg20Tot() {
		return stwg20Tot;
	}

	public void setStwg20Tot(String stwg20Tot) {
		this.stwg20Tot = stwg20Tot;
	}

	public String getStwg2hTot() {
		return stwg2hTot;
	}

	public void setStwg2hTot(String stwg2hTot) {
		this.stwg2hTot = stwg2hTot;
	}

	public String getStwg40Tot() {
		return stwg40Tot;
	}

	public void setStwg40Tot(String stwg40Tot) {
		this.stwg40Tot = stwg40Tot;
	}

	public String getStwg4hTot() {
		return stwg4hTot;
	}

	public void setStwg4hTot(String stwg4hTot) {
		this.stwg4hTot = stwg4hTot;
	}

	public String getStwg45Tot() {
		return stwg45Tot;
	}

	public void setStwg45Tot(String stwg45Tot) {
		this.stwg45Tot = stwg45Tot;
	}
	
	
	/**
	 * Column Info
	 * 
	 * @return podYdCd
	 */
	public String getPodYdCd(){
		return this.podYdCd;
	}

	/**
	 * Column Info
	 * @param bb2hOpr10
	 */
	public void setBb2hOpr10(String bb2hOpr10) {
		this.bb2hOpr10 = bb2hOpr10;
	}
	
	/**
	 * Column Info
	 * @param fm
	 */
	public void setFm(String fm) {
		this.fm = fm;
	}
	
	/**
	 * Column Info
	 * @param opr5Wgt4
	 */
	public void setOpr5Wgt4(String opr5Wgt4) {
		this.opr5Wgt4 = opr5Wgt4;
	}
	
	/**
	 * Column Info
	 * @param opr5Wgt2
	 */
	public void setOpr5Wgt2(String opr5Wgt2) {
		this.opr5Wgt2 = opr5Wgt2;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param opr8Wgt4h
	 */
	public void setOpr8Wgt4h(String opr8Wgt4h) {
		this.opr8Wgt4h = opr8Wgt4h;
	}
	
	/**
	 * Column Info
	 * @param opr10Wgt4
	 */
	public void setOpr10Wgt4(String opr10Wgt4) {
		this.opr10Wgt4 = opr10Wgt4;
	}
	
	/**
	 * Column Info
	 * @param ak20Tot
	 */
	public void setAk20Tot(String ak20Tot) {
		this.ak20Tot = ak20Tot;
	}
	
	/**
	 * Column Info
	 * @param ak2hOpr10
	 */
	public void setAk2hOpr10(String ak2hOpr10) {
		this.ak2hOpr10 = ak2hOpr10;
	}
	
	/**
	 * Column Info
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
	}
	
	/**
	 * Column Info
	 * @param ak40Opr10
	 */
	public void setAk40Opr10(String ak40Opr10) {
		this.ak40Opr10 = ak40Opr10;
	}
	
	/**
	 * Column Info
	 * @param opr10Wgt2
	 */
	public void setOpr10Wgt2(String opr10Wgt2) {
		this.opr10Wgt2 = opr10Wgt2;
	}
	
	/**
	 * Column Info
	 * @param opr8Wgt45
	 */
	public void setOpr8Wgt45(String opr8Wgt45) {
		this.opr8Wgt45 = opr8Wgt45;
	}
	
	/**
	 * Column Info
	 * @param opr8Wgt2h
	 */
	public void setOpr8Wgt2h(String opr8Wgt2h) {
		this.opr8Wgt2h = opr8Wgt2h;
	}
	
	/**
	 * Column Info
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param opr3Wgt2
	 */
	public void setOpr3Wgt2(String opr3Wgt2) {
		this.opr3Wgt2 = opr3Wgt2;
	}
	
	/**
	 * Column Info
	 * @param rf2hTot
	 */
	public void setRf2hTot(String rf2hTot) {
		this.rf2hTot = rf2hTot;
	}
	
	/**
	 * Column Info
	 * @param opr3Wgt4
	 */
	public void setOpr3Wgt4(String opr3Wgt4) {
		this.opr3Wgt4 = opr3Wgt4;
	}
	
	/**
	 * Column Info
	 * @param opr2Wgt2
	 */
	public void setOpr2Wgt2(String opr2Wgt2) {
		this.opr2Wgt2 = opr2Wgt2;
	}
	
	/**
	 * Column Info
	 * @param ak20Opr10
	 */
	public void setAk20Opr10(String ak20Opr10) {
		this.ak20Opr10 = ak20Opr10;
	}
	
	/**
	 * Column Info
	 * @param opr5Teu
	 */
	public void setOpr5Teu(String opr5Teu) {
		this.opr5Teu = opr5Teu;
	}
	
	/**
	 * Column Info
	 * @param totWgt45
	 */
	public void setTotWgt45(String totWgt45) {
		this.totWgt45 = totWgt45;
	}
	
	/**
	 * Column Info
	 * @param opr2Wgt4
	 */
	public void setOpr2Wgt4(String opr2Wgt4) {
		this.opr2Wgt4 = opr2Wgt4;
	}
	
	/**
	 * Column Info
	 * @param totWgt2h
	 */
	public void setTotWgt2h(String totWgt2h) {
		this.totWgt2h = totWgt2h;
	}
	
	/**
	 * Column Info
	 * @param opr5Qty2
	 */
	public void setOpr5Qty2(String opr5Qty2) {
		this.opr5Qty2 = opr5Qty2;
	}
	
	/**
	 * Column Info
	 * @param opr5Qty4
	 */
	public void setOpr5Qty4(String opr5Qty4) {
		this.opr5Qty4 = opr5Qty4;
	}
	
	/**
	 * Column Info
	 * @param bb20Opr7
	 */
	public void setBb20Opr7(String bb20Opr7) {
		this.bb20Opr7 = bb20Opr7;
	}
	
	/**
	 * Column Info
	 * @param opr3Teu
	 */
	public void setOpr3Teu(String opr3Teu) {
		this.opr3Teu = opr3Teu;
	}
	
	/**
	 * Column Info
	 * @param bb20Opr8
	 */
	public void setBb20Opr8(String bb20Opr8) {
		this.bb20Opr8 = bb20Opr8;
	}
	
	/**
	 * Column Info
	 * @param opr6Qty4h
	 */
	public void setOpr6Qty4h(String opr6Qty4h) {
		this.opr6Qty4h = opr6Qty4h;
	}
	
	/**
	 * Column Info
	 * @param bb20Opr9
	 */
	public void setBb20Opr9(String bb20Opr9) {
		this.bb20Opr9 = bb20Opr9;
	}
	
	/**
	 * Column Info
	 * @param bb20Opr3
	 */
	public void setBb20Opr3(String bb20Opr3) {
		this.bb20Opr3 = bb20Opr3;
	}
	
	/**
	 * Column Info
	 * @param totWgt4h
	 */
	public void setTotWgt4h(String totWgt4h) {
		this.totWgt4h = totWgt4h;
	}
	
	/**
	 * Column Info
	 * @param bb20Opr4
	 */
	public void setBb20Opr4(String bb20Opr4) {
		this.bb20Opr4 = bb20Opr4;
	}
	
	/**
	 * Column Info
	 * @param rf40Tot
	 */
	public void setRf40Tot(String rf40Tot) {
		this.rf40Tot = rf40Tot;
	}
	
	/**
	 * Column Info
	 * @param bb20Opr5
	 */
	public void setBb20Opr5(String bb20Opr5) {
		this.bb20Opr5 = bb20Opr5;
	}
	
	/**
	 * Column Info
	 * @param bb20Opr6
	 */
	public void setBb20Opr6(String bb20Opr6) {
		this.bb20Opr6 = bb20Opr6;
	}
	
	/**
	 * Column Info
	 * @param opr10Qty2h
	 */
	public void setOpr10Qty2h(String opr10Qty2h) {
		this.opr10Qty2h = opr10Qty2h;
	}
	
	/**
	 * Column Info
	 * @param opr2Wgt2h
	 */
	public void setOpr2Wgt2h(String opr2Wgt2h) {
		this.opr2Wgt2h = opr2Wgt2h;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param opr1Qty2
	 */
	public void setOpr1Qty2(String opr1Qty2) {
		this.opr1Qty2 = opr1Qty2;
	}
	
	/**
	 * Column Info
	 * @param qty10
	 */
	public void setQty10(String qty10) {
		this.qty10 = qty10;
	}
	
	/**
	 * Column Info
	 * @param opr1Qty4
	 */
	public void setOpr1Qty4(String opr1Qty4) {
		this.opr1Qty4 = opr1Qty4;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param dg45Opr8
	 */
	public void setDg45Opr8(String dg45Opr8) {
		this.dg45Opr8 = dg45Opr8;
	}
	
	/**
	 * Column Info
	 * @param dg45Opr7
	 */
	public void setDg45Opr7(String dg45Opr7) {
		this.dg45Opr7 = dg45Opr7;
	}
	
	/**
	 * Column Info
	 * @param dg45Opr6
	 */
	public void setDg45Opr6(String dg45Opr6) {
		this.dg45Opr6 = dg45Opr6;
	}
	
	/**
	 * Column Info
	 * @param rf20Opr10
	 */
	public void setRf20Opr10(String rf20Opr10) {
		this.rf20Opr10 = rf20Opr10;
	}
	
	/**
	 * Column Info
	 * @param dg45Opr5
	 */
	public void setDg45Opr5(String dg45Opr5) {
		this.dg45Opr5 = dg45Opr5;
	}
	
	/**
	 * Column Info
	 * @param dg45Opr9
	 */
	public void setDg45Opr9(String dg45Opr9) {
		this.dg45Opr9 = dg45Opr9;
	}
	
	/**
	 * Column Info
	 * @param bb20Opr2
	 */
	public void setBb20Opr2(String bb20Opr2) {
		this.bb20Opr2 = bb20Opr2;
	}
	
	/**
	 * Column Info
	 * @param dg45Opr4
	 */
	public void setDg45Opr4(String dg45Opr4) {
		this.dg45Opr4 = dg45Opr4;
	}
	
	/**
	 * Column Info
	 * @param bb20Opr1
	 */
	public void setBb20Opr1(String bb20Opr1) {
		this.bb20Opr1 = bb20Opr1;
	}
	
	/**
	 * Column Info
	 * @param dg45Opr3
	 */
	public void setDg45Opr3(String dg45Opr3) {
		this.dg45Opr3 = dg45Opr3;
	}
	
	/**
	 * Column Info
	 * @param dg45Opr2
	 */
	public void setDg45Opr2(String dg45Opr2) {
		this.dg45Opr2 = dg45Opr2;
	}
	
	/**
	 * Column Info
	 * @param dg45Opr1
	 */
	public void setDg45Opr1(String dg45Opr1) {
		this.dg45Opr1 = dg45Opr1;
	}
	
	/**
	 * Column Info
	 * @param dg40Tot
	 */
	public void setDg40Tot(String dg40Tot) {
		this.dg40Tot = dg40Tot;
	}
	
	/**
	 * Column Info
	 * @param opr6Qty2h
	 */
	public void setOpr6Qty2h(String opr6Qty2h) {
		this.opr6Qty2h = opr6Qty2h;
	}
	
	/**
	 * Column Info
	 * @param opr5Wgt4h
	 */
	public void setOpr5Wgt4h(String opr5Wgt4h) {
		this.opr5Wgt4h = opr5Wgt4h;
	}
	
	/**
	 * Column Info
	 * @param bb45Opr10
	 */
	public void setBb45Opr10(String bb45Opr10) {
		this.bb45Opr10 = bb45Opr10;
	}
	
	/**
	 * Column Info
	 * @param dg40Opr10
	 */
	public void setDg40Opr10(String dg40Opr10) {
		this.dg40Opr10 = dg40Opr10;
	}
	
	/**
	 * Column Info
	 * @param totTeu
	 */
	public void setTotTeu(String totTeu) {
		this.totTeu = totTeu;
	}
	
	/**
	 * Column Info
	 * @param stwgCgoFlg
	 */
	public void setStwgCgoFlg(String stwgCgoFlg) {
		this.stwgCgoFlg = stwgCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param opr6Qty45
	 */
	public void setOpr6Qty45(String opr6Qty45) {
		this.opr6Qty45 = opr6Qty45;
	}
	
	/**
	 * Column Info
	 * @param dg4hOpr10
	 */
	public void setDg4hOpr10(String dg4hOpr10) {
		this.dg4hOpr10 = dg4hOpr10;
	}
	
	/**
	 * Column Info
	 * @param opr8Wgt2
	 */
	public void setOpr8Wgt2(String opr8Wgt2) {
		this.opr8Wgt2 = opr8Wgt2;
	}
	
	/**
	 * Column Info
	 * @param opr8Wgt4
	 */
	public void setOpr8Wgt4(String opr8Wgt4) {
		this.opr8Wgt4 = opr8Wgt4;
	}
	
	/**
	 * Column Info
	 * @param cbfIndFlg
	 */
	public void setCbfIndFlg(String cbfIndFlg) {
		this.cbfIndFlg = cbfIndFlg;
	}
	
	/**
	 * Column Info
	 * @param rf4hOpr3
	 */
	public void setRf4hOpr3(String rf4hOpr3) {
		this.rf4hOpr3 = rf4hOpr3;
	}
	
	/**
	 * Column Info
	 * @param bb4hOpr9
	 */
	public void setBb4hOpr9(String bb4hOpr9) {
		this.bb4hOpr9 = bb4hOpr9;
	}
	
	/**
	 * Column Info
	 * @param rf4hOpr4
	 */
	public void setRf4hOpr4(String rf4hOpr4) {
		this.rf4hOpr4 = rf4hOpr4;
	}
	
	/**
	 * Column Info
	 * @param rf4hOpr1
	 */
	public void setRf4hOpr1(String rf4hOpr1) {
		this.rf4hOpr1 = rf4hOpr1;
	}
	
	/**
	 * Column Info
	 * @param rf4hOpr2
	 */
	public void setRf4hOpr2(String rf4hOpr2) {
		this.rf4hOpr2 = rf4hOpr2;
	}
	
	/**
	 * Column Info
	 * @param bb4hOpr5
	 */
	public void setBb4hOpr5(String bb4hOpr5) {
		this.bb4hOpr5 = bb4hOpr5;
	}
	
	/**
	 * Column Info
	 * @param rf4hOpr7
	 */
	public void setRf4hOpr7(String rf4hOpr7) {
		this.rf4hOpr7 = rf4hOpr7;
	}
	
	/**
	 * Column Info
	 * @param bb4hOpr6
	 */
	public void setBb4hOpr6(String bb4hOpr6) {
		this.bb4hOpr6 = bb4hOpr6;
	}
	
	/**
	 * Column Info
	 * @param rf4hOpr8
	 */
	public void setRf4hOpr8(String rf4hOpr8) {
		this.rf4hOpr8 = rf4hOpr8;
	}
	
	/**
	 * Column Info
	 * @param rf4hOpr5
	 */
	public void setRf4hOpr5(String rf4hOpr5) {
		this.rf4hOpr5 = rf4hOpr5;
	}
	
	/**
	 * Column Info
	 * @param bb4hOpr7
	 */
	public void setBb4hOpr7(String bb4hOpr7) {
		this.bb4hOpr7 = bb4hOpr7;
	}
	
	/**
	 * Column Info
	 * @param rf4hOpr6
	 */
	public void setRf4hOpr6(String rf4hOpr6) {
		this.rf4hOpr6 = rf4hOpr6;
	}
	
	/**
	 * Column Info
	 * @param bb4hOpr8
	 */
	public void setBb4hOpr8(String bb4hOpr8) {
		this.bb4hOpr8 = bb4hOpr8;
	}
	
	/**
	 * Column Info
	 * @param opr3Qty45
	 */
	public void setOpr3Qty45(String opr3Qty45) {
		this.opr3Qty45 = opr3Qty45;
	}
	
	/**
	 * Column Info
	 * @param bb4hOpr1
	 */
	public void setBb4hOpr1(String bb4hOpr1) {
		this.bb4hOpr1 = bb4hOpr1;
	}
	
	/**
	 * Column Info
	 * @param bb4hOpr2
	 */
	public void setBb4hOpr2(String bb4hOpr2) {
		this.bb4hOpr2 = bb4hOpr2;
	}
	
	/**
	 * Column Info
	 * @param ak20Opr9
	 */
	public void setAk20Opr9(String ak20Opr9) {
		this.ak20Opr9 = ak20Opr9;
	}
	
	/**
	 * Column Info
	 * @param opr4Wgt2h
	 */
	public void setOpr4Wgt2h(String opr4Wgt2h) {
		this.opr4Wgt2h = opr4Wgt2h;
	}
	
	/**
	 * Column Info
	 * @param bb4hOpr3
	 */
	public void setBb4hOpr3(String bb4hOpr3) {
		this.bb4hOpr3 = bb4hOpr3;
	}
	
	/**
	 * Column Info
	 * @param bb4hOpr4
	 */
	public void setBb4hOpr4(String bb4hOpr4) {
		this.bb4hOpr4 = bb4hOpr4;
	}
	
	/**
	 * Column Info
	 * @param opr9Qty2
	 */
	public void setOpr9Qty2(String opr9Qty2) {
		this.opr9Qty2 = opr9Qty2;
	}
	
	/**
	 * Column Info
	 * @param opr9Qty4
	 */
	public void setOpr9Qty4(String opr9Qty4) {
		this.opr9Qty4 = opr9Qty4;
	}
	
	/**
	 * Column Info
	 * @param ak20Opr1
	 */
	public void setAk20Opr1(String ak20Opr1) {
		this.ak20Opr1 = ak20Opr1;
	}
	
	/**
	 * Column Info
	 * @param ak20Opr2
	 */
	public void setAk20Opr2(String ak20Opr2) {
		this.ak20Opr2 = ak20Opr2;
	}
	
	/**
	 * Column Info
	 * @param ak20Opr3
	 */
	public void setAk20Opr3(String ak20Opr3) {
		this.ak20Opr3 = ak20Opr3;
	}
	
	/**
	 * Column Info
	 * @param ak20Opr4
	 */
	public void setAk20Opr4(String ak20Opr4) {
		this.ak20Opr4 = ak20Opr4;
	}
	
	/**
	 * Column Info
	 * @param ak20Opr5
	 */
	public void setAk20Opr5(String ak20Opr5) {
		this.ak20Opr5 = ak20Opr5;
	}
	
	/**
	 * Column Info
	 * @param ak20Opr6
	 */
	public void setAk20Opr6(String ak20Opr6) {
		this.ak20Opr6 = ak20Opr6;
	}
	
	/**
	 * Column Info
	 * @param opr3Qty2h
	 */
	public void setOpr3Qty2h(String opr3Qty2h) {
		this.opr3Qty2h = opr3Qty2h;
	}
	
	/**
	 * Column Info
	 * @param ak20Opr7
	 */
	public void setAk20Opr7(String ak20Opr7) {
		this.ak20Opr7 = ak20Opr7;
	}
	
	/**
	 * Column Info
	 * @param ak20Opr8
	 */
	public void setAk20Opr8(String ak20Opr8) {
		this.ak20Opr8 = ak20Opr8;
	}
	
	/**
	 * Column Info
	 * @param stwgCd
	 */
	public void setStwgCd(String stwgCd) {
		this.stwgCd = stwgCd;
	}
	
	/**
	 * Column Info
	 * @param opr4Qty4h
	 */
	public void setOpr4Qty4h(String opr4Qty4h) {
		this.opr4Qty4h = opr4Qty4h;
	}
	
	/**
	 * Column Info
	 * @param rf4hOpr9
	 */
	public void setRf4hOpr9(String rf4hOpr9) {
		this.rf4hOpr9 = rf4hOpr9;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param ak45Opr7
	 */
	public void setAk45Opr7(String ak45Opr7) {
		this.ak45Opr7 = ak45Opr7;
	}
	
	/**
	 * Column Info
	 * @param ak45Opr6
	 */
	public void setAk45Opr6(String ak45Opr6) {
		this.ak45Opr6 = ak45Opr6;
	}
	
	/**
	 * Column Info
	 * @param opr8Qty2h
	 */
	public void setOpr8Qty2h(String opr8Qty2h) {
		this.opr8Qty2h = opr8Qty2h;
	}
	
	/**
	 * Column Info
	 * @param ak45Opr9
	 */
	public void setAk45Opr9(String ak45Opr9) {
		this.ak45Opr9 = ak45Opr9;
	}
	
	/**
	 * Column Info
	 * @param ak45Opr8
	 */
	public void setAk45Opr8(String ak45Opr8) {
		this.ak45Opr8 = ak45Opr8;
	}
	
	/**
	 * Column Info
	 * @param totTtl
	 */
	public void setTotTtl(String totTtl) {
		this.totTtl = totTtl;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param opr8Qty45
	 */
	public void setOpr8Qty45(String opr8Qty45) {
		this.opr8Qty45 = opr8Qty45;
	}
	
	/**
	 * Column Info
	 * @param ak45Opr1
	 */
	public void setAk45Opr1(String ak45Opr1) {
		this.ak45Opr1 = ak45Opr1;
	}
	
	/**
	 * Column Info
	 * @param ak45Opr2
	 */
	public void setAk45Opr2(String ak45Opr2) {
		this.ak45Opr2 = ak45Opr2;
	}
	
	/**
	 * Column Info
	 * @param ak45Opr3
	 */
	public void setAk45Opr3(String ak45Opr3) {
		this.ak45Opr3 = ak45Opr3;
	}
	
	/**
	 * Column Info
	 * @param ak45Opr4
	 */
	public void setAk45Opr4(String ak45Opr4) {
		this.ak45Opr4 = ak45Opr4;
	}
	
	/**
	 * Column Info
	 * @param ak45Opr5
	 */
	public void setAk45Opr5(String ak45Opr5) {
		this.ak45Opr5 = ak45Opr5;
	}
	
	/**
	 * Column Info
	 * @param bb2hOpr9
	 */
	public void setBb2hOpr9(String bb2hOpr9) {
		this.bb2hOpr9 = bb2hOpr9;
	}
	
	/**
	 * Column Info
	 * @param bb2hOpr8
	 */
	public void setBb2hOpr8(String bb2hOpr8) {
		this.bb2hOpr8 = bb2hOpr8;
	}
	
	/**
	 * Column Info
	 * @param bb2hOpr7
	 */
	public void setBb2hOpr7(String bb2hOpr7) {
		this.bb2hOpr7 = bb2hOpr7;
	}
	
	/**
	 * Column Info
	 * @param bb2hOpr6
	 */
	public void setBb2hOpr6(String bb2hOpr6) {
		this.bb2hOpr6 = bb2hOpr6;
	}
	
	/**
	 * Column Info
	 * @param bb2hOpr5
	 */
	public void setBb2hOpr5(String bb2hOpr5) {
		this.bb2hOpr5 = bb2hOpr5;
	}
	
	/**
	 * Column Info
	 * @param bb2hOpr4
	 */
	public void setBb2hOpr4(String bb2hOpr4) {
		this.bb2hOpr4 = bb2hOpr4;
	}
	
	/**
	 * Column Info
	 * @param bb2hOpr3
	 */
	public void setBb2hOpr3(String bb2hOpr3) {
		this.bb2hOpr3 = bb2hOpr3;
	}
	
	/**
	 * Column Info
	 * @param bb2hOpr2
	 */
	public void setBb2hOpr2(String bb2hOpr2) {
		this.bb2hOpr2 = bb2hOpr2;
	}
	
	/**
	 * Column Info
	 * @param bb2hOpr1
	 */
	public void setBb2hOpr1(String bb2hOpr1) {
		this.bb2hOpr1 = bb2hOpr1;
	}
	
	/**
	 * Column Info
	 * @param opr4Wgt4h
	 */
	public void setOpr4Wgt4h(String opr4Wgt4h) {
		this.opr4Wgt4h = opr4Wgt4h;
	}
	
	/**
	 * Column Info
	 * @param opr10Qty45
	 */
	public void setOpr10Qty45(String opr10Qty45) {
		this.opr10Qty45 = opr10Qty45;
	}
	
	/**
	 * Column Info
	 * @param opr3Qty4h
	 */
	public void setOpr3Qty4h(String opr3Qty4h) {
		this.opr3Qty4h = opr3Qty4h;
	}
	
	/**
	 * Column Info
	 * @param opr6Wgt2
	 */
	public void setOpr6Wgt2(String opr6Wgt2) {
		this.opr6Wgt2 = opr6Wgt2;
	}
	
	/**
	 * Column Info
	 * @param dg2hTot
	 */
	public void setDg2hTot(String dg2hTot) {
		this.dg2hTot = dg2hTot;
	}
	
	/**
	 * Column Info
	 * @param opr6Wgt4
	 */
	public void setOpr6Wgt4(String opr6Wgt4) {
		this.opr6Wgt4 = opr6Wgt4;
	}
	
	/**
	 * Column Info
	 * @param ak45Tot
	 */
	public void setAk45Tot(String ak45Tot) {
		this.ak45Tot = ak45Tot;
	}
	
	/**
	 * Column Info
	 * @param rf4hTot
	 */
	public void setRf4hTot(String rf4hTot) {
		this.rf4hTot = rf4hTot;
	}
	
	/**
	 * Column Info
	 * @param opr10Qty4h
	 */
	public void setOpr10Qty4h(String opr10Qty4h) {
		this.opr10Qty4h = opr10Qty4h;
	}
	
	/**
	 * Column Info
	 * @param rf45Opr3
	 */
	public void setRf45Opr3(String rf45Opr3) {
		this.rf45Opr3 = rf45Opr3;
	}
	
	/**
	 * Column Info
	 * @param rf45Opr2
	 */
	public void setRf45Opr2(String rf45Opr2) {
		this.rf45Opr2 = rf45Opr2;
	}
	
	/**
	 * Column Info
	 * @param rf45Opr1
	 */
	public void setRf45Opr1(String rf45Opr1) {
		this.rf45Opr1 = rf45Opr1;
	}
	
	/**
	 * Column Info
	 * @param opr4Wgt45
	 */
	public void setOpr4Wgt45(String opr4Wgt45) {
		this.opr4Wgt45 = opr4Wgt45;
	}
	
	/**
	 * Column Info
	 * @param rf45Opr7
	 */
	public void setRf45Opr7(String rf45Opr7) {
		this.rf45Opr7 = rf45Opr7;
	}
	
	/**
	 * Column Info
	 * @param rf45Opr6
	 */
	public void setRf45Opr6(String rf45Opr6) {
		this.rf45Opr6 = rf45Opr6;
	}
	
	/**
	 * Column Info
	 * @param rf45Opr5
	 */
	public void setRf45Opr5(String rf45Opr5) {
		this.rf45Opr5 = rf45Opr5;
	}
	
	/**
	 * Column Info
	 * @param bb40Opr9
	 */
	public void setBb40Opr9(String bb40Opr9) {
		this.bb40Opr9 = bb40Opr9;
	}
	
	/**
	 * Column Info
	 * @param rf45Opr4
	 */
	public void setRf45Opr4(String rf45Opr4) {
		this.rf45Opr4 = rf45Opr4;
	}
	
	/**
	 * Column Info
	 * @param bb40Opr7
	 */
	public void setBb40Opr7(String bb40Opr7) {
		this.bb40Opr7 = bb40Opr7;
	}
	
	/**
	 * Column Info
	 * @param bb40Opr8
	 */
	public void setBb40Opr8(String bb40Opr8) {
		this.bb40Opr8 = bb40Opr8;
	}
	
	/**
	 * Column Info
	 * @param bb40Opr5
	 */
	public void setBb40Opr5(String bb40Opr5) {
		this.bb40Opr5 = bb40Opr5;
	}
	
	/**
	 * Column Info
	 * @param rf45Opr9
	 */
	public void setRf45Opr9(String rf45Opr9) {
		this.rf45Opr9 = rf45Opr9;
	}
	
	/**
	 * Column Info
	 * @param bb40Opr6
	 */
	public void setBb40Opr6(String bb40Opr6) {
		this.bb40Opr6 = bb40Opr6;
	}
	
	/**
	 * Column Info
	 * @param rf45Opr8
	 */
	public void setRf45Opr8(String rf45Opr8) {
		this.rf45Opr8 = rf45Opr8;
	}
	
	/**
	 * Column Info
	 * @param totQty2h
	 */
	public void setTotQty2h(String totQty2h) {
		this.totQty2h = totQty2h;
	}
	
	/**
	 * Column Info
	 * @param opr1Qty4h
	 */
	public void setOpr1Qty4h(String opr1Qty4h) {
		this.opr1Qty4h = opr1Qty4h;
	}
	
	/**
	 * Column Info
	 * @param rf40Opr1
	 */
	public void setRf40Opr1(String rf40Opr1) {
		this.rf40Opr1 = rf40Opr1;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param rf40Opr2
	 */
	public void setRf40Opr2(String rf40Opr2) {
		this.rf40Opr2 = rf40Opr2;
	}
	
	/**
	 * Column Info
	 * @param rf40Opr3
	 */
	public void setRf40Opr3(String rf40Opr3) {
		this.rf40Opr3 = rf40Opr3;
	}
	
	/**
	 * Column Info
	 * @param rf40Opr4
	 */
	public void setRf40Opr4(String rf40Opr4) {
		this.rf40Opr4 = rf40Opr4;
	}
	
	/**
	 * Column Info
	 * @param rf40Opr5
	 */
	public void setRf40Opr5(String rf40Opr5) {
		this.rf40Opr5 = rf40Opr5;
	}
	
	/**
	 * Column Info
	 * @param rf40Opr6
	 */
	public void setRf40Opr6(String rf40Opr6) {
		this.rf40Opr6 = rf40Opr6;
	}
	
	/**
	 * Column Info
	 * @param dg20Tot
	 */
	public void setDg20Tot(String dg20Tot) {
		this.dg20Tot = dg20Tot;
	}
	
	/**
	 * Column Info
	 * @param rf40Opr7
	 */
	public void setRf40Opr7(String rf40Opr7) {
		this.rf40Opr7 = rf40Opr7;
	}
	
	/**
	 * Column Info
	 * @param rf40Opr8
	 */
	public void setRf40Opr8(String rf40Opr8) {
		this.rf40Opr8 = rf40Opr8;
	}
	
	/**
	 * Column Info
	 * @param rf40Opr9
	 */
	public void setRf40Opr9(String rf40Opr9) {
		this.rf40Opr9 = rf40Opr9;
	}
	
	/**
	 * Column Info
	 * @param bb40Opr1
	 */
	public void setBb40Opr1(String bb40Opr1) {
		this.bb40Opr1 = bb40Opr1;
	}
	
	/**
	 * Column Info
	 * @param totQty45
	 */
	public void setTotQty45(String totQty45) {
		this.totQty45 = totQty45;
	}
	
	/**
	 * Column Info
	 * @param bb40Opr2
	 */
	public void setBb40Opr2(String bb40Opr2) {
		this.bb40Opr2 = bb40Opr2;
	}
	
	/**
	 * Column Info
	 * @param bb40Opr3
	 */
	public void setBb40Opr3(String bb40Opr3) {
		this.bb40Opr3 = bb40Opr3;
	}
	
	/**
	 * Column Info
	 * @param bb40Opr4
	 */
	public void setBb40Opr4(String bb40Opr4) {
		this.bb40Opr4 = bb40Opr4;
	}
	
	/**
	 * Column Info
	 * @param bb40Tot
	 */
	public void setBb40Tot(String bb40Tot) {
		this.bb40Tot = bb40Tot;
	}
	
	/**
	 * Column Info
	 * @param opr7Qty2h
	 */
	public void setOpr7Qty2h(String opr7Qty2h) {
		this.opr7Qty2h = opr7Qty2h;
	}
	
	/**
	 * Column Info
	 * @param bb20Opr10
	 */
	public void setBb20Opr10(String bb20Opr10) {
		this.bb20Opr10 = bb20Opr10;
	}
	
	/**
	 * Column Info
	 * @param opr7Qty45
	 */
	public void setOpr7Qty45(String opr7Qty45) {
		this.opr7Qty45 = opr7Qty45;
	}
	
	/**
	 * Column Info
	 * @param rf45Opr10
	 */
	public void setRf45Opr10(String rf45Opr10) {
		this.rf45Opr10 = rf45Opr10;
	}
	
	/**
	 * Column Info
	 * @param bb20Tot
	 */
	public void setBb20Tot(String bb20Tot) {
		this.bb20Tot = bb20Tot;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param totQty2
	 */
	public void setTotQty2(String totQty2) {
		this.totQty2 = totQty2;
	}
	
	/**
	 * Column Info
	 * @param totQty4
	 */
	public void setTotQty4(String totQty4) {
		this.totQty4 = totQty4;
	}
	
	/**
	 * Column Info
	 * @param opr8Qty4h
	 */
	public void setOpr8Qty4h(String opr8Qty4h) {
		this.opr8Qty4h = opr8Qty4h;
	}
	
	/**
	 * Column Info
	 * @param bkgShprOwnrFlg
	 */
	public void setBkgShprOwnrFlg(String bkgShprOwnrFlg) {
		this.bkgShprOwnrFlg = bkgShprOwnrFlg;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param opr7Qty4h
	 */
	public void setOpr7Qty4h(String opr7Qty4h) {
		this.opr7Qty4h = opr7Qty4h;
	}
	
	/**
	 * Column Info
	 * @param rf40Opr10
	 */
	public void setRf40Opr10(String rf40Opr10) {
		this.rf40Opr10 = rf40Opr10;
	}
	
	/**
	 * Column Info
	 * @param pcCgoFlg
	 */
	public void setPcCgoFlg(String pcCgoFlg) {
		this.pcCgoFlg = pcCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param ak45Opr10
	 */
	public void setAk45Opr10(String ak45Opr10) {
		this.ak45Opr10 = ak45Opr10;
	}
	
	/**
	 * Column Info
	 * @param opr10Teu
	 */
	public void setOpr10Teu(String opr10Teu) {
		this.opr10Teu = opr10Teu;
	}
	
	/**
	 * Column Info
	 * @param opr1Wgt2h
	 */
	public void setOpr1Wgt2h(String opr1Wgt2h) {
		this.opr1Wgt2h = opr1Wgt2h;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param opr7Wgt45
	 */
	public void setOpr7Wgt45(String opr7Wgt45) {
		this.opr7Wgt45 = opr7Wgt45;
	}
	
	/**
	 * Column Info
	 * @param ak4hOpr2
	 */
	public void setAk4hOpr2(String ak4hOpr2) {
		this.ak4hOpr2 = ak4hOpr2;
	}
	
	/**
	 * Column Info
	 * @param ak4hOpr1
	 */
	public void setAk4hOpr1(String ak4hOpr1) {
		this.ak4hOpr1 = ak4hOpr1;
	}
	
	/**
	 * Column Info
	 * @param opr10Wgt4h
	 */
	public void setOpr10Wgt4h(String opr10Wgt4h) {
		this.opr10Wgt4h = opr10Wgt4h;
	}
	
	/**
	 * Column Info
	 * @param opr7Wgt2h
	 */
	public void setOpr7Wgt2h(String opr7Wgt2h) {
		this.opr7Wgt2h = opr7Wgt2h;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param dg45Opr10
	 */
	public void setDg45Opr10(String dg45Opr10) {
		this.dg45Opr10 = dg45Opr10;
	}
	
	/**
	 * Column Info
	 * @param wg
	 */
	public void setWg(String wg) {
		this.wg = wg;
	}
	
	/**
	 * Column Info
	 * @param opr10Qty4
	 */
	public void setOpr10Qty4(String opr10Qty4) {
		this.opr10Qty4 = opr10Qty4;
	}
	
	/**
	 * Column Info
	 * @param opr10Qty2
	 */
	public void setOpr10Qty2(String opr10Qty2) {
		this.opr10Qty2 = opr10Qty2;
	}
	
	/**
	 * Column Info
	 * @param bb4hOpr10
	 */
	public void setBb4hOpr10(String bb4hOpr10) {
		this.bb4hOpr10 = bb4hOpr10;
	}
	
	/**
	 * Column Info
	 * @param ak4hOpr5
	 */
	public void setAk4hOpr5(String ak4hOpr5) {
		this.ak4hOpr5 = ak4hOpr5;
	}
	
	/**
	 * Column Info
	 * @param ak4hOpr6
	 */
	public void setAk4hOpr6(String ak4hOpr6) {
		this.ak4hOpr6 = ak4hOpr6;
	}
	
	/**
	 * Column Info
	 * @param ak4hOpr3
	 */
	public void setAk4hOpr3(String ak4hOpr3) {
		this.ak4hOpr3 = ak4hOpr3;
	}
	
	/**
	 * Column Info
	 * @param crrCd2
	 */
	public void setCrrCd2(String crrCd2) {
		this.crrCd2 = crrCd2;
	}
	
	/**
	 * Column Info
	 * @param ak4hOpr4
	 */
	public void setAk4hOpr4(String ak4hOpr4) {
		this.ak4hOpr4 = ak4hOpr4;
	}
	
	/**
	 * Column Info
	 * @param ak4hOpr9
	 */
	public void setAk4hOpr9(String ak4hOpr9) {
		this.ak4hOpr9 = ak4hOpr9;
	}
	
	/**
	 * Column Info
	 * @param ak4hOpr7
	 */
	public void setAk4hOpr7(String ak4hOpr7) {
		this.ak4hOpr7 = ak4hOpr7;
	}
	
	/**
	 * Column Info
	 * @param opr1Qty45
	 */
	public void setOpr1Qty45(String opr1Qty45) {
		this.opr1Qty45 = opr1Qty45;
	}
	
	/**
	 * Column Info
	 * @param ak4hOpr8
	 */
	public void setAk4hOpr8(String ak4hOpr8) {
		this.ak4hOpr8 = ak4hOpr8;
	}
	
	/**
	 * Column Info
	 * @param opr8Teu
	 */
	public void setOpr8Teu(String opr8Teu) {
		this.opr8Teu = opr8Teu;
	}
	
	/**
	 * Column Info
	 * @param opr10
	 */
	public void setOpr10(String opr10) {
		this.opr10 = opr10;
	}
	
	/**
	 * Column Info
	 * @param opr1Qty2h
	 */
	public void setOpr1Qty2h(String opr1Qty2h) {
		this.opr1Qty2h = opr1Qty2h;
	}
	
	/**
	 * Column Info
	 * @param opr1Wgt45
	 */
	public void setOpr1Wgt45(String opr1Wgt45) {
		this.opr1Wgt45 = opr1Wgt45;
	}
	
	/**
	 * Column Info
	 * @param sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	/**
	 * Column Info
	 * @param opr1Teu
	 */
	public void setOpr1Teu(String opr1Teu) {
		this.opr1Teu = opr1Teu;
	}
	
	/**
	 * Column Info
	 * @param rf45Tot
	 */
	public void setRf45Tot(String rf45Tot) {
		this.rf45Tot = rf45Tot;
	}
	
	/**
	 * Column Info
	 * @param opr7Wgt4h
	 */
	public void setOpr7Wgt4h(String opr7Wgt4h) {
		this.opr7Wgt4h = opr7Wgt4h;
	}
	
	/**
	 * Column Info
	 * @param opr4Qty2
	 */
	public void setOpr4Qty2(String opr4Qty2) {
		this.opr4Qty2 = opr4Qty2;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param totQty4h
	 */
	public void setTotQty4h(String totQty4h) {
		this.totQty4h = totQty4h;
	}
	
	/**
	 * Column Info
	 * @param bb40Opr10
	 */
	public void setBb40Opr10(String bb40Opr10) {
		this.bb40Opr10 = bb40Opr10;
	}
	
	/**
	 * Column Info
	 * @param opr2Qty4
	 */
	public void setOpr2Qty4(String opr2Qty4) {
		this.opr2Qty4 = opr2Qty4;
	}
	
	/**
	 * Column Info
	 * @param opr2Qty2
	 */
	public void setOpr2Qty2(String opr2Qty2) {
		this.opr2Qty2 = opr2Qty2;
	}
	
	/**
	 * Column Info
	 * @param opr9Wgt2
	 */
	public void setOpr9Wgt2(String opr9Wgt2) {
		this.opr9Wgt2 = opr9Wgt2;
	}
	
	/**
	 * Column Info
	 * @param stwgNm
	 */
	public void setStwgNm(String stwgNm) {
		this.stwgNm = stwgNm;
	}
	
	/**
	 * Column Info
	 * @param opr9Wgt4
	 */
	public void setOpr9Wgt4(String opr9Wgt4) {
		this.opr9Wgt4 = opr9Wgt4;
	}
	
	/**
	 * Column Info
	 * @param opr1Wgt4
	 */
	public void setOpr1Wgt4(String opr1Wgt4) {
		this.opr1Wgt4 = opr1Wgt4;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Column Info
	 * @param opr1Wgt2
	 */
	public void setOpr1Wgt2(String opr1Wgt2) {
		this.opr1Wgt2 = opr1Wgt2;
	}
	
	/**
	 * Column Info
	 * @param opr7Wgt4
	 */
	public void setOpr7Wgt4(String opr7Wgt4) {
		this.opr7Wgt4 = opr7Wgt4;
	}
	
	/**
	 * Column Info
	 * @param opr7Wgt2
	 */
	public void setOpr7Wgt2(String opr7Wgt2) {
		this.opr7Wgt2 = opr7Wgt2;
	}
	
	/**
	 * Column Info
	 * @param opr8Qty4
	 */
	public void setOpr8Qty4(String opr8Qty4) {
		this.opr8Qty4 = opr8Qty4;
	}
	
	/**
	 * Column Info
	 * @param opr8Qty2
	 */
	public void setOpr8Qty2(String opr8Qty2) {
		this.opr8Qty2 = opr8Qty2;
	}
	
	/**
	 * Column Info
	 * @param opr4Qty4
	 */
	public void setOpr4Qty4(String opr4Qty4) {
		this.opr4Qty4 = opr4Qty4;
	}
	
	/**
	 * Column Info
	 * @param opr9Qty2h
	 */
	public void setOpr9Qty2h(String opr9Qty2h) {
		this.opr9Qty2h = opr9Qty2h;
	}
	
	/**
	 * Column Info
	 * @param opr7Teu
	 */
	public void setOpr7Teu(String opr7Teu) {
		this.opr7Teu = opr7Teu;
	}
	
	/**
	 * Column Info
	 * @param opr9Qty45
	 */
	public void setOpr9Qty45(String opr9Qty45) {
		this.opr9Qty45 = opr9Qty45;
	}
	
	/**
	 * Column Info
	 * @param unit2
	 */
	public void setUnit2(String unit2) {
		this.unit2 = unit2;
	}
	
	/**
	 * Column Info
	 * @param unit4
	 */
	public void setUnit4(String unit4) {
		this.unit4 = unit4;
	}
	
	/**
	 * Column Info
	 * @param opr6Teu
	 */
	public void setOpr6Teu(String opr6Teu) {
		this.opr6Teu = opr6Teu;
	}
	
	/**
	 * Column Info
	 * @param opr4Teu
	 */
	public void setOpr4Teu(String opr4Teu) {
		this.opr4Teu = opr4Teu;
	}
	
	/**
	 * Column Info
	 * @param opr3Qty4
	 */
	public void setOpr3Qty4(String opr3Qty4) {
		this.opr3Qty4 = opr3Qty4;
	}
	
	/**
	 * Column Info
	 * @param opr1Wgt4h
	 */
	public void setOpr1Wgt4h(String opr1Wgt4h) {
		this.opr1Wgt4h = opr1Wgt4h;
	}
	
	/**
	 * Column Info
	 * @param opr10Wgt45
	 */
	public void setOpr10Wgt45(String opr10Wgt45) {
		this.opr10Wgt45 = opr10Wgt45;
	}
	
	/**
	 * Column Info
	 * @param opr10Wgt2h
	 */
	public void setOpr10Wgt2h(String opr10Wgt2h) {
		this.opr10Wgt2h = opr10Wgt2h;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param opr7
	 */
	public void setOpr7(String opr7) {
		this.opr7 = opr7;
	}
	
	/**
	 * Column Info
	 * @param opr8
	 */
	public void setOpr8(String opr8) {
		this.opr8 = opr8;
	}
	
	/**
	 * Column Info
	 * @param opr5
	 */
	public void setOpr5(String opr5) {
		this.opr5 = opr5;
	}
	
	/**
	 * Column Info
	 * @param opr6
	 */
	public void setOpr6(String opr6) {
		this.opr6 = opr6;
	}
	
	/**
	 * Column Info
	 * @param opr3
	 */
	public void setOpr3(String opr3) {
		this.opr3 = opr3;
	}
	
	/**
	 * Column Info
	 * @param opr4
	 */
	public void setOpr4(String opr4) {
		this.opr4 = opr4;
	}
	
	/**
	 * Column Info
	 * @param opr1
	 */
	public void setOpr1(String opr1) {
		this.opr1 = opr1;
	}
	
	/**
	 * Column Info
	 * @param opr2
	 */
	public void setOpr2(String opr2) {
		this.opr2 = opr2;
	}
	
	/**
	 * Column Info
	 * @param opr4Wgt4
	 */
	public void setOpr4Wgt4(String opr4Wgt4) {
		this.opr4Wgt4 = opr4Wgt4;
	}
	
	/**
	 * Column Info
	 * @param opr4Wgt2
	 */
	public void setOpr4Wgt2(String opr4Wgt2) {
		this.opr4Wgt2 = opr4Wgt2;
	}
	
	/**
	 * Column Info
	 * @param opr4Qty2h
	 */
	public void setOpr4Qty2h(String opr4Qty2h) {
		this.opr4Qty2h = opr4Qty2h;
	}
	
	/**
	 * Column Info
	 * @param opr9
	 */
	public void setOpr9(String opr9) {
		this.opr9 = opr9;
	}
	
	/**
	 * Column Info
	 * @param opr4Qty45
	 */
	public void setOpr4Qty45(String opr4Qty45) {
		this.opr4Qty45 = opr4Qty45;
	}
	
	/**
	 * Column Info
	 * @param rf2hOpr2
	 */
	public void setRf2hOpr2(String rf2hOpr2) {
		this.rf2hOpr2 = rf2hOpr2;
	}
	
	/**
	 * Column Info
	 * @param opr6Qty4
	 */
	public void setOpr6Qty4(String opr6Qty4) {
		this.opr6Qty4 = opr6Qty4;
	}
	
	/**
	 * Column Info
	 * @param rf2hOpr1
	 */
	public void setRf2hOpr1(String rf2hOpr1) {
		this.rf2hOpr1 = rf2hOpr1;
	}
	
	/**
	 * Column Info
	 * @param opr6Qty2
	 */
	public void setOpr6Qty2(String opr6Qty2) {
		this.opr6Qty2 = opr6Qty2;
	}
	
	/**
	 * Column Info
	 * @param opr5Qty2h
	 */
	public void setOpr5Qty2h(String opr5Qty2h) {
		this.opr5Qty2h = opr5Qty2h;
	}
	
	/**
	 * Column Info
	 * @param rf2hOpr6
	 */
	public void setRf2hOpr6(String rf2hOpr6) {
		this.rf2hOpr6 = rf2hOpr6;
	}
	
	/**
	 * Column Info
	 * @param opr2Qty2h
	 */
	public void setOpr2Qty2h(String opr2Qty2h) {
		this.opr2Qty2h = opr2Qty2h;
	}
	
	/**
	 * Column Info
	 * @param rf2hOpr5
	 */
	public void setRf2hOpr5(String rf2hOpr5) {
		this.rf2hOpr5 = rf2hOpr5;
	}
	
	/**
	 * Column Info
	 * @param rf2hOpr4
	 */
	public void setRf2hOpr4(String rf2hOpr4) {
		this.rf2hOpr4 = rf2hOpr4;
	}
	
	/**
	 * Column Info
	 * @param rf4hOpr10
	 */
	public void setRf4hOpr10(String rf4hOpr10) {
		this.rf4hOpr10 = rf4hOpr10;
	}
	
	/**
	 * Column Info
	 * @param rf2hOpr3
	 */
	public void setRf2hOpr3(String rf2hOpr3) {
		this.rf2hOpr3 = rf2hOpr3;
	}
	
	/**
	 * Column Info
	 * @param rf20Opr8
	 */
	public void setRf20Opr8(String rf20Opr8) {
		this.rf20Opr8 = rf20Opr8;
	}
	
	/**
	 * Column Info
	 * @param rf20Opr7
	 */
	public void setRf20Opr7(String rf20Opr7) {
		this.rf20Opr7 = rf20Opr7;
	}
	
	/**
	 * Column Info
	 * @param rf20Opr9
	 */
	public void setRf20Opr9(String rf20Opr9) {
		this.rf20Opr9 = rf20Opr9;
	}
	
	/**
	 * Column Info
	 * @param rf20Opr4
	 */
	public void setRf20Opr4(String rf20Opr4) {
		this.rf20Opr4 = rf20Opr4;
	}
	
	/**
	 * Column Info
	 * @param dg40Opr5
	 */
	public void setDg40Opr5(String dg40Opr5) {
		this.dg40Opr5 = dg40Opr5;
	}
	
	/**
	 * Column Info
	 * @param rf2hOpr9
	 */
	public void setRf2hOpr9(String rf2hOpr9) {
		this.rf2hOpr9 = rf2hOpr9;
	}
	
	/**
	 * Column Info
	 * @param ak4hTot
	 */
	public void setAk4hTot(String ak4hTot) {
		this.ak4hTot = ak4hTot;
	}
	
	/**
	 * Column Info
	 * @param opr2Qty45
	 */
	public void setOpr2Qty45(String opr2Qty45) {
		this.opr2Qty45 = opr2Qty45;
	}
	
	/**
	 * Column Info
	 * @param rf20Opr3
	 */
	public void setRf20Opr3(String rf20Opr3) {
		this.rf20Opr3 = rf20Opr3;
	}
	
	/**
	 * Column Info
	 * @param dg40Opr4
	 */
	public void setDg40Opr4(String dg40Opr4) {
		this.dg40Opr4 = dg40Opr4;
	}
	
	/**
	 * Column Info
	 * @param qty1
	 */
	public void setQty1(String qty1) {
		this.qty1 = qty1;
	}
	
	/**
	 * Column Info
	 * @param dg40Opr3
	 */
	public void setDg40Opr3(String dg40Opr3) {
		this.dg40Opr3 = dg40Opr3;
	}
	
	/**
	 * Column Info
	 * @param rf20Opr6
	 */
	public void setRf20Opr6(String rf20Opr6) {
		this.rf20Opr6 = rf20Opr6;
	}
	
	/**
	 * Column Info
	 * @param rf2hOpr7
	 */
	public void setRf2hOpr7(String rf2hOpr7) {
		this.rf2hOpr7 = rf2hOpr7;
	}
	
	/**
	 * Column Info
	 * @param dg40Opr2
	 */
	public void setDg40Opr2(String dg40Opr2) {
		this.dg40Opr2 = dg40Opr2;
	}
	
	/**
	 * Column Info
	 * @param rf20Opr5
	 */
	public void setRf20Opr5(String rf20Opr5) {
		this.rf20Opr5 = rf20Opr5;
	}
	
	/**
	 * Column Info
	 * @param rf2hOpr8
	 */
	public void setRf2hOpr8(String rf2hOpr8) {
		this.rf2hOpr8 = rf2hOpr8;
	}
	
	/**
	 * Column Info
	 * @param qty3
	 */
	public void setQty3(String qty3) {
		this.qty3 = qty3;
	}
	
	/**
	 * Column Info
	 * @param dg40Opr9
	 */
	public void setDg40Opr9(String dg40Opr9) {
		this.dg40Opr9 = dg40Opr9;
	}
	
	/**
	 * Column Info
	 * @param qty2
	 */
	public void setQty2(String qty2) {
		this.qty2 = qty2;
	}
	
	/**
	 * Column Info
	 * @param dg40Opr8
	 */
	public void setDg40Opr8(String dg40Opr8) {
		this.dg40Opr8 = dg40Opr8;
	}
	
	/**
	 * Column Info
	 * @param opr5Qty45
	 */
	public void setOpr5Qty45(String opr5Qty45) {
		this.opr5Qty45 = opr5Qty45;
	}
	
	/**
	 * Column Info
	 * @param qty5
	 */
	public void setQty5(String qty5) {
		this.qty5 = qty5;
	}
	
	/**
	 * Column Info
	 * @param rf20Opr2
	 */
	public void setRf20Opr2(String rf20Opr2) {
		this.rf20Opr2 = rf20Opr2;
	}
	
	/**
	 * Column Info
	 * @param dg40Opr7
	 */
	public void setDg40Opr7(String dg40Opr7) {
		this.dg40Opr7 = dg40Opr7;
	}
	
	/**
	 * Column Info
	 * @param qty4
	 */
	public void setQty4(String qty4) {
		this.qty4 = qty4;
	}
	
	/**
	 * Column Info
	 * @param rf20Opr1
	 */
	public void setRf20Opr1(String rf20Opr1) {
		this.rf20Opr1 = rf20Opr1;
	}
	
	/**
	 * Column Info
	 * @param dg40Opr6
	 */
	public void setDg40Opr6(String dg40Opr6) {
		this.dg40Opr6 = dg40Opr6;
	}
	
	/**
	 * Column Info
	 * @param opr9Wgt45
	 */
	public void setOpr9Wgt45(String opr9Wgt45) {
		this.opr9Wgt45 = opr9Wgt45;
	}
	
	/**
	 * Column Info
	 * @param dg4hOpr1
	 */
	public void setDg4hOpr1(String dg4hOpr1) {
		this.dg4hOpr1 = dg4hOpr1;
	}
	
	/**
	 * Column Info
	 * @param opr3Qty2
	 */
	public void setOpr3Qty2(String opr3Qty2) {
		this.opr3Qty2 = opr3Qty2;
	}
	
	/**
	 * Column Info
	 * @param dg4hOpr7
	 */
	public void setDg4hOpr7(String dg4hOpr7) {
		this.dg4hOpr7 = dg4hOpr7;
	}
	
	/**
	 * Column Info
	 * @param dg4hOpr6
	 */
	public void setDg4hOpr6(String dg4hOpr6) {
		this.dg4hOpr6 = dg4hOpr6;
	}
	
	/**
	 * Column Info
	 * @param dg4hOpr9
	 */
	public void setDg4hOpr9(String dg4hOpr9) {
		this.dg4hOpr9 = dg4hOpr9;
	}
	
	/**
	 * Column Info
	 * @param dg4hOpr8
	 */
	public void setDg4hOpr8(String dg4hOpr8) {
		this.dg4hOpr8 = dg4hOpr8;
	}
	
	/**
	 * Column Info
	 * @param dg4hOpr3
	 */
	public void setDg4hOpr3(String dg4hOpr3) {
		this.dg4hOpr3 = dg4hOpr3;
	}
	
	/**
	 * Column Info
	 * @param opr2Teu
	 */
	public void setOpr2Teu(String opr2Teu) {
		this.opr2Teu = opr2Teu;
	}
	
	/**
	 * Column Info
	 * @param dg4hOpr2
	 */
	public void setDg4hOpr2(String dg4hOpr2) {
		this.dg4hOpr2 = dg4hOpr2;
	}
	
	/**
	 * Column Info
	 * @param opr9Wgt2h
	 */
	public void setOpr9Wgt2h(String opr9Wgt2h) {
		this.opr9Wgt2h = opr9Wgt2h;
	}
	
	/**
	 * Column Info
	 * @param dg4hOpr5
	 */
	public void setDg4hOpr5(String dg4hOpr5) {
		this.dg4hOpr5 = dg4hOpr5;
	}
	
	/**
	 * Column Info
	 * @param dg4hOpr4
	 */
	public void setDg4hOpr4(String dg4hOpr4) {
		this.dg4hOpr4 = dg4hOpr4;
	}
	
	/**
	 * Column Info
	 * @param ak4hOpr10
	 */
	public void setAk4hOpr10(String ak4hOpr10) {
		this.ak4hOpr10 = ak4hOpr10;
	}
	
	/**
	 * Column Info
	 * @param dg20Opr10
	 */
	public void setDg20Opr10(String dg20Opr10) {
		this.dg20Opr10 = dg20Opr10;
	}
	
	/**
	 * Column Info
	 * @param opr2Qty4h
	 */
	public void setOpr2Qty4h(String opr2Qty4h) {
		this.opr2Qty4h = opr2Qty4h;
	}
	
	/**
	 * Column Info
	 * @param opr2Wgt4h
	 */
	public void setOpr2Wgt4h(String opr2Wgt4h) {
		this.opr2Wgt4h = opr2Wgt4h;
	}
	
	/**
	 * Column Info
	 * @param opr7Qty4
	 */
	public void setOpr7Qty4(String opr7Qty4) {
		this.opr7Qty4 = opr7Qty4;
	}
	
	/**
	 * Column Info
	 * @param opr7Qty2
	 */
	public void setOpr7Qty2(String opr7Qty2) {
		this.opr7Qty2 = opr7Qty2;
	}
	
	/**
	 * Column Info
	 * @param dg20Opr1
	 */
	public void setDg20Opr1(String dg20Opr1) {
		this.dg20Opr1 = dg20Opr1;
	}
	
	/**
	 * Column Info
	 * @param dg20Opr3
	 */
	public void setDg20Opr3(String dg20Opr3) {
		this.dg20Opr3 = dg20Opr3;
	}
	
	/**
	 * Column Info
	 * @param dg20Opr2
	 */
	public void setDg20Opr2(String dg20Opr2) {
		this.dg20Opr2 = dg20Opr2;
	}
	
	/**
	 * Column Info
	 * @param dg2hOpr10
	 */
	public void setDg2hOpr10(String dg2hOpr10) {
		this.dg2hOpr10 = dg2hOpr10;
	}
	
	/**
	 * Column Info
	 * @param dg20Opr5
	 */
	public void setDg20Opr5(String dg20Opr5) {
		this.dg20Opr5 = dg20Opr5;
	}
	
	/**
	 * Column Info
	 * @param dg20Opr4
	 */
	public void setDg20Opr4(String dg20Opr4) {
		this.dg20Opr4 = dg20Opr4;
	}
	
	/**
	 * Column Info
	 * @param dg20Opr7
	 */
	public void setDg20Opr7(String dg20Opr7) {
		this.dg20Opr7 = dg20Opr7;
	}
	
	/**
	 * Column Info
	 * @param dg20Opr6
	 */
	public void setDg20Opr6(String dg20Opr6) {
		this.dg20Opr6 = dg20Opr6;
	}
	
	/**
	 * Column Info
	 * @param dg20Opr9
	 */
	public void setDg20Opr9(String dg20Opr9) {
		this.dg20Opr9 = dg20Opr9;
	}
	
	/**
	 * Column Info
	 * @param dg20Opr8
	 */
	public void setDg20Opr8(String dg20Opr8) {
		this.dg20Opr8 = dg20Opr8;
	}
	
	/**
	 * Column Info
	 * @param dg4hTot
	 */
	public void setDg4hTot(String dg4hTot) {
		this.dg4hTot = dg4hTot;
	}
	
	/**
	 * Column Info
	 * @param qty8
	 */
	public void setQty8(String qty8) {
		this.qty8 = qty8;
	}
	
	/**
	 * Column Info
	 * @param qty9
	 */
	public void setQty9(String qty9) {
		this.qty9 = qty9;
	}
	
	/**
	 * Column Info
	 * @param qty6
	 */
	public void setQty6(String qty6) {
		this.qty6 = qty6;
	}
	
	/**
	 * Column Info
	 * @param qty7
	 */
	public void setQty7(String qty7) {
		this.qty7 = qty7;
	}
	
	/**
	 * Column Info
	 * @param dg2hOpr4
	 */
	public void setDg2hOpr4(String dg2hOpr4) {
		this.dg2hOpr4 = dg2hOpr4;
	}
	
	/**
	 * Column Info
	 * @param dg2hOpr5
	 */
	public void setDg2hOpr5(String dg2hOpr5) {
		this.dg2hOpr5 = dg2hOpr5;
	}
	
	/**
	 * Column Info
	 * @param dg2hOpr6
	 */
	public void setDg2hOpr6(String dg2hOpr6) {
		this.dg2hOpr6 = dg2hOpr6;
	}
	
	/**
	 * Column Info
	 * @param dg2hOpr7
	 */
	public void setDg2hOpr7(String dg2hOpr7) {
		this.dg2hOpr7 = dg2hOpr7;
	}
	
	/**
	 * Column Info
	 * @param opr2Wgt45
	 */
	public void setOpr2Wgt45(String opr2Wgt45) {
		this.opr2Wgt45 = opr2Wgt45;
	}
	
	/**
	 * Column Info
	 * @param dg2hOpr1
	 */
	public void setDg2hOpr1(String dg2hOpr1) {
		this.dg2hOpr1 = dg2hOpr1;
	}
	
	/**
	 * Column Info
	 * @param dg2hOpr2
	 */
	public void setDg2hOpr2(String dg2hOpr2) {
		this.dg2hOpr2 = dg2hOpr2;
	}
	
	/**
	 * Column Info
	 * @param dg2hOpr3
	 */
	public void setDg2hOpr3(String dg2hOpr3) {
		this.dg2hOpr3 = dg2hOpr3;
	}
	
	/**
	 * Column Info
	 * @param opr9Qty4h
	 */
	public void setOpr9Qty4h(String opr9Qty4h) {
		this.opr9Qty4h = opr9Qty4h;
	}
	
	/**
	 * Column Info
	 * @param opr6Wgt2h
	 */
	public void setOpr6Wgt2h(String opr6Wgt2h) {
		this.opr6Wgt2h = opr6Wgt2h;
	}
	
	/**
	 * Column Info
	 * @param opr6Wgt45
	 */
	public void setOpr6Wgt45(String opr6Wgt45) {
		this.opr6Wgt45 = opr6Wgt45;
	}
	
	/**
	 * Column Info
	 * @param dg2hOpr8
	 */
	public void setDg2hOpr8(String dg2hOpr8) {
		this.dg2hOpr8 = dg2hOpr8;
	}
	
	/**
	 * Column Info
	 * @param dg2hOpr9
	 */
	public void setDg2hOpr9(String dg2hOpr9) {
		this.dg2hOpr9 = dg2hOpr9;
	}
	
	/**
	 * Column Info
	 * @param rf20Tot
	 */
	public void setRf20Tot(String rf20Tot) {
		this.rf20Tot = rf20Tot;
	}
	
	/**
	 * Column Info
	 * @param totWgt2
	 */
	public void setTotWgt2(String totWgt2) {
		this.totWgt2 = totWgt2;
	}
	
	/**
	 * Column Info
	 * @param opr3Wgt2h
	 */
	public void setOpr3Wgt2h(String opr3Wgt2h) {
		this.opr3Wgt2h = opr3Wgt2h;
	}
	
	/**
	 * Column Info
	 * @param totWgt4
	 */
	public void setTotWgt4(String totWgt4) {
		this.totWgt4 = totWgt4;
	}
	
	/**
	 * Column Info
	 * @param mlb
	 */
	public void setMlb(String mlb) {
		this.mlb = mlb;
	}
	
	/**
	 * Column Info
	 * @param bb45Opr1
	 */
	public void setBb45Opr1(String bb45Opr1) {
		this.bb45Opr1 = bb45Opr1;
	}
	
	/**
	 * Column Info
	 * @param opr3Wgt45
	 */
	public void setOpr3Wgt45(String opr3Wgt45) {
		this.opr3Wgt45 = opr3Wgt45;
	}
	
	/**
	 * Column Info
	 * @param bb45Opr3
	 */
	public void setBb45Opr3(String bb45Opr3) {
		this.bb45Opr3 = bb45Opr3;
	}
	
	/**
	 * Column Info
	 * @param bb45Opr2
	 */
	public void setBb45Opr2(String bb45Opr2) {
		this.bb45Opr2 = bb45Opr2;
	}
	
	/**
	 * Column Info
	 * @param bb45Opr5
	 */
	public void setBb45Opr5(String bb45Opr5) {
		this.bb45Opr5 = bb45Opr5;
	}
	
	/**
	 * Column Info
	 * @param bb45Opr4
	 */
	public void setBb45Opr4(String bb45Opr4) {
		this.bb45Opr4 = bb45Opr4;
	}
	
	/**
	 * Column Info
	 * @param awkCgoFlg
	 */
	public void setAwkCgoFlg(String awkCgoFlg) {
		this.awkCgoFlg = awkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param bb45Opr7
	 */
	public void setBb45Opr7(String bb45Opr7) {
		this.bb45Opr7 = bb45Opr7;
	}
	
	/**
	 * Column Info
	 * @param bb45Opr6
	 */
	public void setBb45Opr6(String bb45Opr6) {
		this.bb45Opr6 = bb45Opr6;
	}
	
	/**
	 * Column Info
	 * @param bb45Opr9
	 */
	public void setBb45Opr9(String bb45Opr9) {
		this.bb45Opr9 = bb45Opr9;
	}
	
	/**
	 * Column Info
	 * @param bb45Opr8
	 */
	public void setBb45Opr8(String bb45Opr8) {
		this.bb45Opr8 = bb45Opr8;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
	}
	
	/**
	 * Column Info
	 * @param opr6Wgt4h
	 */
	public void setOpr6Wgt4h(String opr6Wgt4h) {
		this.opr6Wgt4h = opr6Wgt4h;
	}
	
	/**
	 * Column Info
	 * @param avWgt2
	 */
	public void setAvWgt2(String avWgt2) {
		this.avWgt2 = avWgt2;
	}
	
	/**
	 * Column Info
	 * @param avWgt4
	 */
	public void setAvWgt4(String avWgt4) {
		this.avWgt4 = avWgt4;
	}
	
	/**
	 * Column Info
	 * @param ak40Tot
	 */
	public void setAk40Tot(String ak40Tot) {
		this.ak40Tot = ak40Tot;
	}
	
	/**
	 * Column Info
	 * @param ak40Opr7
	 */
	public void setAk40Opr7(String ak40Opr7) {
		this.ak40Opr7 = ak40Opr7;
	}
	
	/**
	 * Column Info
	 * @param ak40Opr8
	 */
	public void setAk40Opr8(String ak40Opr8) {
		this.ak40Opr8 = ak40Opr8;
	}
	
	/**
	 * Column Info
	 * @param rf2hOpr10
	 */
	public void setRf2hOpr10(String rf2hOpr10) {
		this.rf2hOpr10 = rf2hOpr10;
	}
	
	/**
	 * Column Info
	 * @param ak40Opr9
	 */
	public void setAk40Opr9(String ak40Opr9) {
		this.ak40Opr9 = ak40Opr9;
	}
	
	/**
	 * Column Info
	 * @param opr5Wgt2h
	 */
	public void setOpr5Wgt2h(String opr5Wgt2h) {
		this.opr5Wgt2h = opr5Wgt2h;
	}
	
	/**
	 * Column Info
	 * @param ak40Opr3
	 */
	public void setAk40Opr3(String ak40Opr3) {
		this.ak40Opr3 = ak40Opr3;
	}
	
	/**
	 * Column Info
	 * @param ak40Opr4
	 */
	public void setAk40Opr4(String ak40Opr4) {
		this.ak40Opr4 = ak40Opr4;
	}
	
	/**
	 * Column Info
	 * @param ak40Opr5
	 */
	public void setAk40Opr5(String ak40Opr5) {
		this.ak40Opr5 = ak40Opr5;
	}
	
	/**
	 * Column Info
	 * @param opr5Qty4h
	 */
	public void setOpr5Qty4h(String opr5Qty4h) {
		this.opr5Qty4h = opr5Qty4h;
	}
	
	/**
	 * Column Info
	 * @param ak40Opr6
	 */
	public void setAk40Opr6(String ak40Opr6) {
		this.ak40Opr6 = ak40Opr6;
	}
	
	/**
	 * Column Info
	 * @param ak40Opr1
	 */
	public void setAk40Opr1(String ak40Opr1) {
		this.ak40Opr1 = ak40Opr1;
	}
	
	/**
	 * Column Info
	 * @param ak40Opr2
	 */
	public void setAk40Opr2(String ak40Opr2) {
		this.ak40Opr2 = ak40Opr2;
	}
	
	/**
	 * Column Info
	 * @param opr3Wgt4h
	 */
	public void setOpr3Wgt4h(String opr3Wgt4h) {
		this.opr3Wgt4h = opr3Wgt4h;
	}
	
	/**
	 * Column Info
	 * @param bbCgoFlg
	 */
	public void setBbCgoFlg(String bbCgoFlg) {
		this.bbCgoFlg = bbCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param opr9Teu
	 */
	public void setOpr9Teu(String opr9Teu) {
		this.opr9Teu = opr9Teu;
	}
	
	/**
	 * Column Info
	 * @param mlbCd
	 */
	public void setMlbCd(String mlbCd) {
		this.mlbCd = mlbCd;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param opr9Wgt4h
	 */
	public void setOpr9Wgt4h(String opr9Wgt4h) {
		this.opr9Wgt4h = opr9Wgt4h;
	}
	
	/**
	 * Column Info
	 * @param dg40Opr1
	 */
	public void setDg40Opr1(String dg40Opr1) {
		this.dg40Opr1 = dg40Opr1;
	}
	
	/**
	 * Column Info
	 * @param opr5Wgt45
	 */
	public void setOpr5Wgt45(String opr5Wgt45) {
		this.opr5Wgt45 = opr5Wgt45;
	}
	
	/**
	 * Column Info
	 * @param ak2hOpr2
	 */
	public void setAk2hOpr2(String ak2hOpr2) {
		this.ak2hOpr2 = ak2hOpr2;
	}
	
	/**
	 * Column Info
	 * @param ak2hOpr1
	 */
	public void setAk2hOpr1(String ak2hOpr1) {
		this.ak2hOpr1 = ak2hOpr1;
	}
	
	/**
	 * Column Info
	 * @param ak2hOpr4
	 */
	public void setAk2hOpr4(String ak2hOpr4) {
		this.ak2hOpr4 = ak2hOpr4;
	}
	
	/**
	 * Column Info
	 * @param ak2hOpr3
	 */
	public void setAk2hOpr3(String ak2hOpr3) {
		this.ak2hOpr3 = ak2hOpr3;
	}
	
	/**
	 * Column Info
	 * @param ak2hOpr6
	 */
	public void setAk2hOpr6(String ak2hOpr6) {
		this.ak2hOpr6 = ak2hOpr6;
	}
	
	/**
	 * Column Info
	 * @param ak2hOpr5
	 */
	public void setAk2hOpr5(String ak2hOpr5) {
		this.ak2hOpr5 = ak2hOpr5;
	}
	
	/**
	 * Column Info
	 * @param ak2hOpr8
	 */
	public void setAk2hOpr8(String ak2hOpr8) {
		this.ak2hOpr8 = ak2hOpr8;
	}
	
	/**
	 * Column Info
	 * @param ak2hOpr7
	 */
	public void setAk2hOpr7(String ak2hOpr7) {
		this.ak2hOpr7 = ak2hOpr7;
	}
	
	/**
	 * Column Info
	 * @param ak2hOpr9
	 */
	public void setAk2hOpr9(String ak2hOpr9) {
		this.ak2hOpr9 = ak2hOpr9;
	}
	
	/**
	 * Column Info
	 * @param dg45Tot
	 */
	public void setDg45Tot(String dg45Tot) {
		this.dg45Tot = dg45Tot;
	}
	
	/**
	 * Column Info
	 * 
	 * @param podydcd
	 */
	public void setPodYdCd(String podYdCd){
		this.podYdCd = podYdCd;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setBb2hOpr10(JSPUtil.getParameter(request, prefix + "bb_2h_opr10", ""));
		setFm(JSPUtil.getParameter(request, prefix + "fm", ""));
		setOpr5Wgt4(JSPUtil.getParameter(request, prefix + "opr5_wgt_4", ""));
		setOpr5Wgt2(JSPUtil.getParameter(request, prefix + "opr5_wgt_2", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setOpr8Wgt4h(JSPUtil.getParameter(request, prefix + "opr8_wgt_4h", ""));
		setOpr10Wgt4(JSPUtil.getParameter(request, prefix + "opr10_wgt_4", ""));
		setAk20Tot(JSPUtil.getParameter(request, prefix + "ak_20_tot", ""));
		setAk2hOpr10(JSPUtil.getParameter(request, prefix + "ak_2h_opr10", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setAk40Opr10(JSPUtil.getParameter(request, prefix + "ak_40_opr10", ""));
		setOpr10Wgt2(JSPUtil.getParameter(request, prefix + "opr10_wgt_2", ""));
		setOpr8Wgt45(JSPUtil.getParameter(request, prefix + "opr8_wgt_45", ""));
		setOpr8Wgt2h(JSPUtil.getParameter(request, prefix + "opr8_wgt_2h", ""));
		setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
		setOpr3Wgt2(JSPUtil.getParameter(request, prefix + "opr3_wgt_2", ""));
		setRf2hTot(JSPUtil.getParameter(request, prefix + "rf_2h_tot", ""));
		setOpr3Wgt4(JSPUtil.getParameter(request, prefix + "opr3_wgt_4", ""));
		setOpr2Wgt2(JSPUtil.getParameter(request, prefix + "opr2_wgt_2", ""));
		setAk20Opr10(JSPUtil.getParameter(request, prefix + "ak_20_opr10", ""));
		setOpr5Teu(JSPUtil.getParameter(request, prefix + "opr5_teu", ""));
		setTotWgt45(JSPUtil.getParameter(request, prefix + "tot_wgt_45", ""));
		setOpr2Wgt4(JSPUtil.getParameter(request, prefix + "opr2_wgt_4", ""));
		setTotWgt2h(JSPUtil.getParameter(request, prefix + "tot_wgt_2h", ""));
		setOpr5Qty2(JSPUtil.getParameter(request, prefix + "opr5_qty_2", ""));
		setOpr5Qty4(JSPUtil.getParameter(request, prefix + "opr5_qty_4", ""));
		setBb20Opr7(JSPUtil.getParameter(request, prefix + "bb_20_opr7", ""));
		setOpr3Teu(JSPUtil.getParameter(request, prefix + "opr3_teu", ""));
		setBb20Opr8(JSPUtil.getParameter(request, prefix + "bb_20_opr8", ""));
		setOpr6Qty4h(JSPUtil.getParameter(request, prefix + "opr6_qty_4h", ""));
		setBb20Opr9(JSPUtil.getParameter(request, prefix + "bb_20_opr9", ""));
		setBb20Opr3(JSPUtil.getParameter(request, prefix + "bb_20_opr3", ""));
		setTotWgt4h(JSPUtil.getParameter(request, prefix + "tot_wgt_4h", ""));
		setBb20Opr4(JSPUtil.getParameter(request, prefix + "bb_20_opr4", ""));
		setRf40Tot(JSPUtil.getParameter(request, prefix + "rf_40_tot", ""));
		setBb20Opr5(JSPUtil.getParameter(request, prefix + "bb_20_opr5", ""));
		setBb20Opr6(JSPUtil.getParameter(request, prefix + "bb_20_opr6", ""));
		setOpr10Qty2h(JSPUtil.getParameter(request, prefix + "opr10_qty_2h", ""));
		setOpr2Wgt2h(JSPUtil.getParameter(request, prefix + "opr2_wgt_2h", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setOpr1Qty2(JSPUtil.getParameter(request, prefix + "opr1_qty_2", ""));
		setQty10(JSPUtil.getParameter(request, prefix + "qty10", ""));
		setOpr1Qty4(JSPUtil.getParameter(request, prefix + "opr1_qty_4", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDg45Opr8(JSPUtil.getParameter(request, prefix + "dg_45_opr8", ""));
		setDg45Opr7(JSPUtil.getParameter(request, prefix + "dg_45_opr7", ""));
		setDg45Opr6(JSPUtil.getParameter(request, prefix + "dg_45_opr6", ""));
		setRf20Opr10(JSPUtil.getParameter(request, prefix + "rf_20_opr10", ""));
		setDg45Opr5(JSPUtil.getParameter(request, prefix + "dg_45_opr5", ""));
		setDg45Opr9(JSPUtil.getParameter(request, prefix + "dg_45_opr9", ""));
		setBb20Opr2(JSPUtil.getParameter(request, prefix + "bb_20_opr2", ""));
		setDg45Opr4(JSPUtil.getParameter(request, prefix + "dg_45_opr4", ""));
		setBb20Opr1(JSPUtil.getParameter(request, prefix + "bb_20_opr1", ""));
		setDg45Opr3(JSPUtil.getParameter(request, prefix + "dg_45_opr3", ""));
		setDg45Opr2(JSPUtil.getParameter(request, prefix + "dg_45_opr2", ""));
		setDg45Opr1(JSPUtil.getParameter(request, prefix + "dg_45_opr1", ""));
		setDg40Tot(JSPUtil.getParameter(request, prefix + "dg_40_tot", ""));
		setOpr6Qty2h(JSPUtil.getParameter(request, prefix + "opr6_qty_2h", ""));
		setOpr5Wgt4h(JSPUtil.getParameter(request, prefix + "opr5_wgt_4h", ""));
		setBb45Opr10(JSPUtil.getParameter(request, prefix + "bb_45_opr10", ""));
		setDg40Opr10(JSPUtil.getParameter(request, prefix + "dg_40_opr10", ""));
		setTotTeu(JSPUtil.getParameter(request, prefix + "tot_teu", ""));
		setStwgCgoFlg(JSPUtil.getParameter(request, prefix + "stwg_cgo_flg", ""));
		setOpr6Qty45(JSPUtil.getParameter(request, prefix + "opr6_qty_45", ""));
		setDg4hOpr10(JSPUtil.getParameter(request, prefix + "dg_4h_opr10", ""));
		setOpr8Wgt2(JSPUtil.getParameter(request, prefix + "opr8_wgt_2", ""));
		setOpr8Wgt4(JSPUtil.getParameter(request, prefix + "opr8_wgt_4", ""));
		setCbfIndFlg(JSPUtil.getParameter(request, prefix + "cbf_ind_flg", ""));
		setRf4hOpr3(JSPUtil.getParameter(request, prefix + "rf_4h_opr3", ""));
		setBb4hOpr9(JSPUtil.getParameter(request, prefix + "bb_4h_opr9", ""));
		setRf4hOpr4(JSPUtil.getParameter(request, prefix + "rf_4h_opr4", ""));
		setRf4hOpr1(JSPUtil.getParameter(request, prefix + "rf_4h_opr1", ""));
		setRf4hOpr2(JSPUtil.getParameter(request, prefix + "rf_4h_opr2", ""));
		setBb4hOpr5(JSPUtil.getParameter(request, prefix + "bb_4h_opr5", ""));
		setRf4hOpr7(JSPUtil.getParameter(request, prefix + "rf_4h_opr7", ""));
		setBb4hOpr6(JSPUtil.getParameter(request, prefix + "bb_4h_opr6", ""));
		setRf4hOpr8(JSPUtil.getParameter(request, prefix + "rf_4h_opr8", ""));
		setRf4hOpr5(JSPUtil.getParameter(request, prefix + "rf_4h_opr5", ""));
		setBb4hOpr7(JSPUtil.getParameter(request, prefix + "bb_4h_opr7", ""));
		setRf4hOpr6(JSPUtil.getParameter(request, prefix + "rf_4h_opr6", ""));
		setBb4hOpr8(JSPUtil.getParameter(request, prefix + "bb_4h_opr8", ""));
		setOpr3Qty45(JSPUtil.getParameter(request, prefix + "opr3_qty_45", ""));
		setBb4hOpr1(JSPUtil.getParameter(request, prefix + "bb_4h_opr1", ""));
		setBb4hOpr2(JSPUtil.getParameter(request, prefix + "bb_4h_opr2", ""));
		setAk20Opr9(JSPUtil.getParameter(request, prefix + "ak_20_opr9", ""));
		setOpr4Wgt2h(JSPUtil.getParameter(request, prefix + "opr4_wgt_2h", ""));
		setBb4hOpr3(JSPUtil.getParameter(request, prefix + "bb_4h_opr3", ""));
		setBb4hOpr4(JSPUtil.getParameter(request, prefix + "bb_4h_opr4", ""));
		setOpr9Qty2(JSPUtil.getParameter(request, prefix + "opr9_qty_2", ""));
		setOpr9Qty4(JSPUtil.getParameter(request, prefix + "opr9_qty_4", ""));
		setAk20Opr1(JSPUtil.getParameter(request, prefix + "ak_20_opr1", ""));
		setAk20Opr2(JSPUtil.getParameter(request, prefix + "ak_20_opr2", ""));
		setAk20Opr3(JSPUtil.getParameter(request, prefix + "ak_20_opr3", ""));
		setAk20Opr4(JSPUtil.getParameter(request, prefix + "ak_20_opr4", ""));
		setAk20Opr5(JSPUtil.getParameter(request, prefix + "ak_20_opr5", ""));
		setAk20Opr6(JSPUtil.getParameter(request, prefix + "ak_20_opr6", ""));
		setOpr3Qty2h(JSPUtil.getParameter(request, prefix + "opr3_qty_2h", ""));
		setAk20Opr7(JSPUtil.getParameter(request, prefix + "ak_20_opr7", ""));
		setAk20Opr8(JSPUtil.getParameter(request, prefix + "ak_20_opr8", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setOpr4Qty4h(JSPUtil.getParameter(request, prefix + "opr4_qty_4h", ""));
		setRf4hOpr9(JSPUtil.getParameter(request, prefix + "rf_4h_opr9", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAk45Opr7(JSPUtil.getParameter(request, prefix + "ak_45_opr7", ""));
		setAk45Opr6(JSPUtil.getParameter(request, prefix + "ak_45_opr6", ""));
		setOpr8Qty2h(JSPUtil.getParameter(request, prefix + "opr8_qty_2h", ""));
		setAk45Opr9(JSPUtil.getParameter(request, prefix + "ak_45_opr9", ""));
		setAk45Opr8(JSPUtil.getParameter(request, prefix + "ak_45_opr8", ""));
		setTotTtl(JSPUtil.getParameter(request, prefix + "tot_ttl", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOpr8Qty45(JSPUtil.getParameter(request, prefix + "opr8_qty_45", ""));
		setAk45Opr1(JSPUtil.getParameter(request, prefix + "ak_45_opr1", ""));
		setAk45Opr2(JSPUtil.getParameter(request, prefix + "ak_45_opr2", ""));
		setAk45Opr3(JSPUtil.getParameter(request, prefix + "ak_45_opr3", ""));
		setAk45Opr4(JSPUtil.getParameter(request, prefix + "ak_45_opr4", ""));
		setAk45Opr5(JSPUtil.getParameter(request, prefix + "ak_45_opr5", ""));
		setBb2hOpr9(JSPUtil.getParameter(request, prefix + "bb_2h_opr9", ""));
		setBb2hOpr8(JSPUtil.getParameter(request, prefix + "bb_2h_opr8", ""));
		setBb2hOpr7(JSPUtil.getParameter(request, prefix + "bb_2h_opr7", ""));
		setBb2hOpr6(JSPUtil.getParameter(request, prefix + "bb_2h_opr6", ""));
		setBb2hOpr5(JSPUtil.getParameter(request, prefix + "bb_2h_opr5", ""));
		setBb2hOpr4(JSPUtil.getParameter(request, prefix + "bb_2h_opr4", ""));
		setBb2hOpr3(JSPUtil.getParameter(request, prefix + "bb_2h_opr3", ""));
		setBb2hOpr2(JSPUtil.getParameter(request, prefix + "bb_2h_opr2", ""));
		setBb2hOpr1(JSPUtil.getParameter(request, prefix + "bb_2h_opr1", ""));
		setOpr4Wgt4h(JSPUtil.getParameter(request, prefix + "opr4_wgt_4h", ""));
		setOpr10Qty45(JSPUtil.getParameter(request, prefix + "opr10_qty_45", ""));
		setOpr3Qty4h(JSPUtil.getParameter(request, prefix + "opr3_qty_4h", ""));
		setOpr6Wgt2(JSPUtil.getParameter(request, prefix + "opr6_wgt_2", ""));
		setDg2hTot(JSPUtil.getParameter(request, prefix + "dg_2h_tot", ""));
		setOpr6Wgt4(JSPUtil.getParameter(request, prefix + "opr6_wgt_4", ""));
		setAk45Tot(JSPUtil.getParameter(request, prefix + "ak_45_tot", ""));
		setRf4hTot(JSPUtil.getParameter(request, prefix + "rf_4h_tot", ""));
		setOpr10Qty4h(JSPUtil.getParameter(request, prefix + "opr10_qty_4h", ""));
		setRf45Opr3(JSPUtil.getParameter(request, prefix + "rf_45_opr3", ""));
		setRf45Opr2(JSPUtil.getParameter(request, prefix + "rf_45_opr2", ""));
		setRf45Opr1(JSPUtil.getParameter(request, prefix + "rf_45_opr1", ""));
		setOpr4Wgt45(JSPUtil.getParameter(request, prefix + "opr4_wgt_45", ""));
		setRf45Opr7(JSPUtil.getParameter(request, prefix + "rf_45_opr7", ""));
		setRf45Opr6(JSPUtil.getParameter(request, prefix + "rf_45_opr6", ""));
		setRf45Opr5(JSPUtil.getParameter(request, prefix + "rf_45_opr5", ""));
		setBb40Opr9(JSPUtil.getParameter(request, prefix + "bb_40_opr9", ""));
		setRf45Opr4(JSPUtil.getParameter(request, prefix + "rf_45_opr4", ""));
		setBb40Opr7(JSPUtil.getParameter(request, prefix + "bb_40_opr7", ""));
		setBb40Opr8(JSPUtil.getParameter(request, prefix + "bb_40_opr8", ""));
		setBb40Opr5(JSPUtil.getParameter(request, prefix + "bb_40_opr5", ""));
		setRf45Opr9(JSPUtil.getParameter(request, prefix + "rf_45_opr9", ""));
		setBb40Opr6(JSPUtil.getParameter(request, prefix + "bb_40_opr6", ""));
		setRf45Opr8(JSPUtil.getParameter(request, prefix + "rf_45_opr8", ""));
		setTotQty2h(JSPUtil.getParameter(request, prefix + "tot_qty_2h", ""));
		setOpr1Qty4h(JSPUtil.getParameter(request, prefix + "opr1_qty_4h", ""));
		setRf40Opr1(JSPUtil.getParameter(request, prefix + "rf_40_opr1", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setRf40Opr2(JSPUtil.getParameter(request, prefix + "rf_40_opr2", ""));
		setRf40Opr3(JSPUtil.getParameter(request, prefix + "rf_40_opr3", ""));
		setRf40Opr4(JSPUtil.getParameter(request, prefix + "rf_40_opr4", ""));
		setRf40Opr5(JSPUtil.getParameter(request, prefix + "rf_40_opr5", ""));
		setRf40Opr6(JSPUtil.getParameter(request, prefix + "rf_40_opr6", ""));
		setDg20Tot(JSPUtil.getParameter(request, prefix + "dg_20_tot", ""));
		setRf40Opr7(JSPUtil.getParameter(request, prefix + "rf_40_opr7", ""));
		setRf40Opr8(JSPUtil.getParameter(request, prefix + "rf_40_opr8", ""));
		setRf40Opr9(JSPUtil.getParameter(request, prefix + "rf_40_opr9", ""));
		setBb40Opr1(JSPUtil.getParameter(request, prefix + "bb_40_opr1", ""));
		setTotQty45(JSPUtil.getParameter(request, prefix + "tot_qty_45", ""));
		setBb40Opr2(JSPUtil.getParameter(request, prefix + "bb_40_opr2", ""));
		setBb40Opr3(JSPUtil.getParameter(request, prefix + "bb_40_opr3", ""));
		setBb40Opr4(JSPUtil.getParameter(request, prefix + "bb_40_opr4", ""));
		setBb40Tot(JSPUtil.getParameter(request, prefix + "bb_40_tot", ""));
		setOpr7Qty2h(JSPUtil.getParameter(request, prefix + "opr7_qty_2h", ""));
		setBb20Opr10(JSPUtil.getParameter(request, prefix + "bb_20_opr10", ""));
		setOpr7Qty45(JSPUtil.getParameter(request, prefix + "opr7_qty_45", ""));
		setRf45Opr10(JSPUtil.getParameter(request, prefix + "rf_45_opr10", ""));
		setBb20Tot(JSPUtil.getParameter(request, prefix + "bb_20_tot", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setTotQty2(JSPUtil.getParameter(request, prefix + "tot_qty_2", ""));
		setTotQty4(JSPUtil.getParameter(request, prefix + "tot_qty_4", ""));
		setOpr8Qty4h(JSPUtil.getParameter(request, prefix + "opr8_qty_4h", ""));
		setBkgShprOwnrFlg(JSPUtil.getParameter(request, prefix + "bkg_shpr_ownr_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setOpr7Qty4h(JSPUtil.getParameter(request, prefix + "opr7_qty_4h", ""));
		setRf40Opr10(JSPUtil.getParameter(request, prefix + "rf_40_opr10", ""));
		setPcCgoFlg(JSPUtil.getParameter(request, prefix + "pc_cgo_flg", ""));
		setAk45Opr10(JSPUtil.getParameter(request, prefix + "ak_45_opr10", ""));
		setOpr10Teu(JSPUtil.getParameter(request, prefix + "opr10_teu", ""));
		setOpr1Wgt2h(JSPUtil.getParameter(request, prefix + "opr1_wgt_2h", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOpr7Wgt45(JSPUtil.getParameter(request, prefix + "opr7_wgt_45", ""));
		setAk4hOpr2(JSPUtil.getParameter(request, prefix + "ak_4h_opr2", ""));
		setAk4hOpr1(JSPUtil.getParameter(request, prefix + "ak_4h_opr1", ""));
		setOpr10Wgt4h(JSPUtil.getParameter(request, prefix + "opr10_wgt_4h", ""));
		setOpr7Wgt2h(JSPUtil.getParameter(request, prefix + "opr7_wgt_2h", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setDg45Opr10(JSPUtil.getParameter(request, prefix + "dg_45_opr10", ""));
		setWg(JSPUtil.getParameter(request, prefix + "wg", ""));
		setOpr10Qty4(JSPUtil.getParameter(request, prefix + "opr10_qty_4", ""));
		setOpr10Qty2(JSPUtil.getParameter(request, prefix + "opr10_qty_2", ""));
		setBb4hOpr10(JSPUtil.getParameter(request, prefix + "bb_4h_opr10", ""));
		setAk4hOpr5(JSPUtil.getParameter(request, prefix + "ak_4h_opr5", ""));
		setAk4hOpr6(JSPUtil.getParameter(request, prefix + "ak_4h_opr6", ""));
		setAk4hOpr3(JSPUtil.getParameter(request, prefix + "ak_4h_opr3", ""));
		setCrrCd2(JSPUtil.getParameter(request, prefix + "crr_cd2", ""));
		setAk4hOpr4(JSPUtil.getParameter(request, prefix + "ak_4h_opr4", ""));
		setAk4hOpr9(JSPUtil.getParameter(request, prefix + "ak_4h_opr9", ""));
		setAk4hOpr7(JSPUtil.getParameter(request, prefix + "ak_4h_opr7", ""));
		setOpr1Qty45(JSPUtil.getParameter(request, prefix + "opr1_qty_45", ""));
		setAk4hOpr8(JSPUtil.getParameter(request, prefix + "ak_4h_opr8", ""));
		setOpr8Teu(JSPUtil.getParameter(request, prefix + "opr8_teu", ""));
		setOpr10(JSPUtil.getParameter(request, prefix + "opr10", ""));
		setOpr1Qty2h(JSPUtil.getParameter(request, prefix + "opr1_qty_2h", ""));
		setOpr1Wgt45(JSPUtil.getParameter(request, prefix + "opr1_wgt_45", ""));
		setSort(JSPUtil.getParameter(request, prefix + "sort", ""));
		setOpr1Teu(JSPUtil.getParameter(request, prefix + "opr1_teu", ""));
		setRf45Tot(JSPUtil.getParameter(request, prefix + "rf_45_tot", ""));
		setOpr7Wgt4h(JSPUtil.getParameter(request, prefix + "opr7_wgt_4h", ""));
		setOpr4Qty2(JSPUtil.getParameter(request, prefix + "opr4_qty_2", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setTotQty4h(JSPUtil.getParameter(request, prefix + "tot_qty_4h", ""));
		setBb40Opr10(JSPUtil.getParameter(request, prefix + "bb_40_opr10", ""));
		setOpr2Qty4(JSPUtil.getParameter(request, prefix + "opr2_qty_4", ""));
		setOpr2Qty2(JSPUtil.getParameter(request, prefix + "opr2_qty_2", ""));
		setOpr9Wgt2(JSPUtil.getParameter(request, prefix + "opr9_wgt_2", ""));
		setStwgNm(JSPUtil.getParameter(request, prefix + "stwg_nm", ""));
		setOpr9Wgt4(JSPUtil.getParameter(request, prefix + "opr9_wgt_4", ""));
		setOpr1Wgt4(JSPUtil.getParameter(request, prefix + "opr1_wgt_4", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setOpr1Wgt2(JSPUtil.getParameter(request, prefix + "opr1_wgt_2", ""));
		setOpr7Wgt4(JSPUtil.getParameter(request, prefix + "opr7_wgt_4", ""));
		setOpr7Wgt2(JSPUtil.getParameter(request, prefix + "opr7_wgt_2", ""));
		setOpr8Qty4(JSPUtil.getParameter(request, prefix + "opr8_qty_4", ""));
		setOpr8Qty2(JSPUtil.getParameter(request, prefix + "opr8_qty_2", ""));
		setOpr4Qty4(JSPUtil.getParameter(request, prefix + "opr4_qty_4", ""));
		setOpr9Qty2h(JSPUtil.getParameter(request, prefix + "opr9_qty_2h", ""));
		setOpr7Teu(JSPUtil.getParameter(request, prefix + "opr7_teu", ""));
		setOpr9Qty45(JSPUtil.getParameter(request, prefix + "opr9_qty_45", ""));
		setUnit2(JSPUtil.getParameter(request, prefix + "unit2", ""));
		setUnit4(JSPUtil.getParameter(request, prefix + "unit4", ""));
		setOpr6Teu(JSPUtil.getParameter(request, prefix + "opr6_teu", ""));
		setOpr4Teu(JSPUtil.getParameter(request, prefix + "opr4_teu", ""));
		setOpr3Qty4(JSPUtil.getParameter(request, prefix + "opr3_qty_4", ""));
		setOpr1Wgt4h(JSPUtil.getParameter(request, prefix + "opr1_wgt_4h", ""));
		setOpr10Wgt45(JSPUtil.getParameter(request, prefix + "opr10_wgt_45", ""));
		setOpr10Wgt2h(JSPUtil.getParameter(request, prefix + "opr10_wgt_2h", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOpr7(JSPUtil.getParameter(request, prefix + "opr7", ""));
		setOpr8(JSPUtil.getParameter(request, prefix + "opr8", ""));
		setOpr5(JSPUtil.getParameter(request, prefix + "opr5", ""));
		setOpr6(JSPUtil.getParameter(request, prefix + "opr6", ""));
		setOpr3(JSPUtil.getParameter(request, prefix + "opr3", ""));
		setOpr4(JSPUtil.getParameter(request, prefix + "opr4", ""));
		setOpr1(JSPUtil.getParameter(request, prefix + "opr1", ""));
		setOpr2(JSPUtil.getParameter(request, prefix + "opr2", ""));
		setOpr4Wgt4(JSPUtil.getParameter(request, prefix + "opr4_wgt_4", ""));
		setOpr4Wgt2(JSPUtil.getParameter(request, prefix + "opr4_wgt_2", ""));
		setOpr4Qty2h(JSPUtil.getParameter(request, prefix + "opr4_qty_2h", ""));
		setOpr9(JSPUtil.getParameter(request, prefix + "opr9", ""));
		setOpr4Qty45(JSPUtil.getParameter(request, prefix + "opr4_qty_45", ""));
		setRf2hOpr2(JSPUtil.getParameter(request, prefix + "rf_2h_opr2", ""));
		setOpr6Qty4(JSPUtil.getParameter(request, prefix + "opr6_qty_4", ""));
		setRf2hOpr1(JSPUtil.getParameter(request, prefix + "rf_2h_opr1", ""));
		setOpr6Qty2(JSPUtil.getParameter(request, prefix + "opr6_qty_2", ""));
		setOpr5Qty2h(JSPUtil.getParameter(request, prefix + "opr5_qty_2h", ""));
		setRf2hOpr6(JSPUtil.getParameter(request, prefix + "rf_2h_opr6", ""));
		setOpr2Qty2h(JSPUtil.getParameter(request, prefix + "opr2_qty_2h", ""));
		setRf2hOpr5(JSPUtil.getParameter(request, prefix + "rf_2h_opr5", ""));
		setRf2hOpr4(JSPUtil.getParameter(request, prefix + "rf_2h_opr4", ""));
		setRf4hOpr10(JSPUtil.getParameter(request, prefix + "rf_4h_opr10", ""));
		setRf2hOpr3(JSPUtil.getParameter(request, prefix + "rf_2h_opr3", ""));
		setRf20Opr8(JSPUtil.getParameter(request, prefix + "rf_20_opr8", ""));
		setRf20Opr7(JSPUtil.getParameter(request, prefix + "rf_20_opr7", ""));
		setRf20Opr9(JSPUtil.getParameter(request, prefix + "rf_20_opr9", ""));
		setRf20Opr4(JSPUtil.getParameter(request, prefix + "rf_20_opr4", ""));
		setDg40Opr5(JSPUtil.getParameter(request, prefix + "dg_40_opr5", ""));
		setRf2hOpr9(JSPUtil.getParameter(request, prefix + "rf_2h_opr9", ""));
		setAk4hTot(JSPUtil.getParameter(request, prefix + "ak_4h_tot", ""));
		setOpr2Qty45(JSPUtil.getParameter(request, prefix + "opr2_qty_45", ""));
		setRf20Opr3(JSPUtil.getParameter(request, prefix + "rf_20_opr3", ""));
		setDg40Opr4(JSPUtil.getParameter(request, prefix + "dg_40_opr4", ""));
		setQty1(JSPUtil.getParameter(request, prefix + "qty1", ""));
		setDg40Opr3(JSPUtil.getParameter(request, prefix + "dg_40_opr3", ""));
		setRf20Opr6(JSPUtil.getParameter(request, prefix + "rf_20_opr6", ""));
		setRf2hOpr7(JSPUtil.getParameter(request, prefix + "rf_2h_opr7", ""));
		setDg40Opr2(JSPUtil.getParameter(request, prefix + "dg_40_opr2", ""));
		setRf20Opr5(JSPUtil.getParameter(request, prefix + "rf_20_opr5", ""));
		setRf2hOpr8(JSPUtil.getParameter(request, prefix + "rf_2h_opr8", ""));
		setQty3(JSPUtil.getParameter(request, prefix + "qty3", ""));
		setDg40Opr9(JSPUtil.getParameter(request, prefix + "dg_40_opr9", ""));
		setQty2(JSPUtil.getParameter(request, prefix + "qty2", ""));
		setDg40Opr8(JSPUtil.getParameter(request, prefix + "dg_40_opr8", ""));
		setOpr5Qty45(JSPUtil.getParameter(request, prefix + "opr5_qty_45", ""));
		setQty5(JSPUtil.getParameter(request, prefix + "qty5", ""));
		setRf20Opr2(JSPUtil.getParameter(request, prefix + "rf_20_opr2", ""));
		setDg40Opr7(JSPUtil.getParameter(request, prefix + "dg_40_opr7", ""));
		setQty4(JSPUtil.getParameter(request, prefix + "qty4", ""));
		setRf20Opr1(JSPUtil.getParameter(request, prefix + "rf_20_opr1", ""));
		setDg40Opr6(JSPUtil.getParameter(request, prefix + "dg_40_opr6", ""));
		setOpr9Wgt45(JSPUtil.getParameter(request, prefix + "opr9_wgt_45", ""));
		setDg4hOpr1(JSPUtil.getParameter(request, prefix + "dg_4h_opr1", ""));
		setOpr3Qty2(JSPUtil.getParameter(request, prefix + "opr3_qty_2", ""));
		setDg4hOpr7(JSPUtil.getParameter(request, prefix + "dg_4h_opr7", ""));
		setDg4hOpr6(JSPUtil.getParameter(request, prefix + "dg_4h_opr6", ""));
		setDg4hOpr9(JSPUtil.getParameter(request, prefix + "dg_4h_opr9", ""));
		setDg4hOpr8(JSPUtil.getParameter(request, prefix + "dg_4h_opr8", ""));
		setDg4hOpr3(JSPUtil.getParameter(request, prefix + "dg_4h_opr3", ""));
		setOpr2Teu(JSPUtil.getParameter(request, prefix + "opr2_teu", ""));
		setDg4hOpr2(JSPUtil.getParameter(request, prefix + "dg_4h_opr2", ""));
		setOpr9Wgt2h(JSPUtil.getParameter(request, prefix + "opr9_wgt_2h", ""));
		setDg4hOpr5(JSPUtil.getParameter(request, prefix + "dg_4h_opr5", ""));
		setDg4hOpr4(JSPUtil.getParameter(request, prefix + "dg_4h_opr4", ""));
		setAk4hOpr10(JSPUtil.getParameter(request, prefix + "ak_4h_opr10", ""));
		setDg20Opr10(JSPUtil.getParameter(request, prefix + "dg_20_opr10", ""));
		setOpr2Qty4h(JSPUtil.getParameter(request, prefix + "opr2_qty_4h", ""));
		setOpr2Wgt4h(JSPUtil.getParameter(request, prefix + "opr2_wgt_4h", ""));
		setOpr7Qty4(JSPUtil.getParameter(request, prefix + "opr7_qty_4", ""));
		setOpr7Qty2(JSPUtil.getParameter(request, prefix + "opr7_qty_2", ""));
		setDg20Opr1(JSPUtil.getParameter(request, prefix + "dg_20_opr1", ""));
		setDg20Opr3(JSPUtil.getParameter(request, prefix + "dg_20_opr3", ""));
		setDg20Opr2(JSPUtil.getParameter(request, prefix + "dg_20_opr2", ""));
		setDg2hOpr10(JSPUtil.getParameter(request, prefix + "dg_2h_opr10", ""));
		setDg20Opr5(JSPUtil.getParameter(request, prefix + "dg_20_opr5", ""));
		setDg20Opr4(JSPUtil.getParameter(request, prefix + "dg_20_opr4", ""));
		setDg20Opr7(JSPUtil.getParameter(request, prefix + "dg_20_opr7", ""));
		setDg20Opr6(JSPUtil.getParameter(request, prefix + "dg_20_opr6", ""));
		setDg20Opr9(JSPUtil.getParameter(request, prefix + "dg_20_opr9", ""));
		setDg20Opr8(JSPUtil.getParameter(request, prefix + "dg_20_opr8", ""));
		setDg4hTot(JSPUtil.getParameter(request, prefix + "dg_4h_tot", ""));
		setQty8(JSPUtil.getParameter(request, prefix + "qty8", ""));
		setQty9(JSPUtil.getParameter(request, prefix + "qty9", ""));
		setQty6(JSPUtil.getParameter(request, prefix + "qty6", ""));
		setQty7(JSPUtil.getParameter(request, prefix + "qty7", ""));
		setDg2hOpr4(JSPUtil.getParameter(request, prefix + "dg_2h_opr4", ""));
		setDg2hOpr5(JSPUtil.getParameter(request, prefix + "dg_2h_opr5", ""));
		setDg2hOpr6(JSPUtil.getParameter(request, prefix + "dg_2h_opr6", ""));
		setDg2hOpr7(JSPUtil.getParameter(request, prefix + "dg_2h_opr7", ""));
		setOpr2Wgt45(JSPUtil.getParameter(request, prefix + "opr2_wgt_45", ""));
		setDg2hOpr1(JSPUtil.getParameter(request, prefix + "dg_2h_opr1", ""));
		setDg2hOpr2(JSPUtil.getParameter(request, prefix + "dg_2h_opr2", ""));
		setDg2hOpr3(JSPUtil.getParameter(request, prefix + "dg_2h_opr3", ""));
		setOpr9Qty4h(JSPUtil.getParameter(request, prefix + "opr9_qty_4h", ""));
		setOpr6Wgt2h(JSPUtil.getParameter(request, prefix + "opr6_wgt_2h", ""));
		setOpr6Wgt45(JSPUtil.getParameter(request, prefix + "opr6_wgt_45", ""));
		setDg2hOpr8(JSPUtil.getParameter(request, prefix + "dg_2h_opr8", ""));
		setDg2hOpr9(JSPUtil.getParameter(request, prefix + "dg_2h_opr9", ""));
		setRf20Tot(JSPUtil.getParameter(request, prefix + "rf_20_tot", ""));
		setTotWgt2(JSPUtil.getParameter(request, prefix + "tot_wgt_2", ""));
		setOpr3Wgt2h(JSPUtil.getParameter(request, prefix + "opr3_wgt_2h", ""));
		setTotWgt4(JSPUtil.getParameter(request, prefix + "tot_wgt_4", ""));
		setMlb(JSPUtil.getParameter(request, prefix + "mlb", ""));
		setBb45Opr1(JSPUtil.getParameter(request, prefix + "bb_45_opr1", ""));
		setOpr3Wgt45(JSPUtil.getParameter(request, prefix + "opr3_wgt_45", ""));
		setBb45Opr3(JSPUtil.getParameter(request, prefix + "bb_45_opr3", ""));
		setBb45Opr2(JSPUtil.getParameter(request, prefix + "bb_45_opr2", ""));
		setBb45Opr5(JSPUtil.getParameter(request, prefix + "bb_45_opr5", ""));
		setBb45Opr4(JSPUtil.getParameter(request, prefix + "bb_45_opr4", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setBb45Opr7(JSPUtil.getParameter(request, prefix + "bb_45_opr7", ""));
		setBb45Opr6(JSPUtil.getParameter(request, prefix + "bb_45_opr6", ""));
		setBb45Opr9(JSPUtil.getParameter(request, prefix + "bb_45_opr9", ""));
		setBb45Opr8(JSPUtil.getParameter(request, prefix + "bb_45_opr8", ""));
		setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
		setOpr6Wgt4h(JSPUtil.getParameter(request, prefix + "opr6_wgt_4h", ""));
		setAvWgt2(JSPUtil.getParameter(request, prefix + "av_wgt_2", ""));
		setAvWgt4(JSPUtil.getParameter(request, prefix + "av_wgt_4", ""));
		setAk40Tot(JSPUtil.getParameter(request, prefix + "ak_40_tot", ""));
		setAk40Opr7(JSPUtil.getParameter(request, prefix + "ak_40_opr7", ""));
		setAk40Opr8(JSPUtil.getParameter(request, prefix + "ak_40_opr8", ""));
		setRf2hOpr10(JSPUtil.getParameter(request, prefix + "rf_2h_opr10", ""));
		setAk40Opr9(JSPUtil.getParameter(request, prefix + "ak_40_opr9", ""));
		setOpr5Wgt2h(JSPUtil.getParameter(request, prefix + "opr5_wgt_2h", ""));
		setAk40Opr3(JSPUtil.getParameter(request, prefix + "ak_40_opr3", ""));
		setAk40Opr4(JSPUtil.getParameter(request, prefix + "ak_40_opr4", ""));
		setAk40Opr5(JSPUtil.getParameter(request, prefix + "ak_40_opr5", ""));
		setOpr5Qty4h(JSPUtil.getParameter(request, prefix + "opr5_qty_4h", ""));
		setAk40Opr6(JSPUtil.getParameter(request, prefix + "ak_40_opr6", ""));
		setAk40Opr1(JSPUtil.getParameter(request, prefix + "ak_40_opr1", ""));
		setAk40Opr2(JSPUtil.getParameter(request, prefix + "ak_40_opr2", ""));
		setOpr3Wgt4h(JSPUtil.getParameter(request, prefix + "opr3_wgt_4h", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setOpr9Teu(JSPUtil.getParameter(request, prefix + "opr9_teu", ""));
		setMlbCd(JSPUtil.getParameter(request, prefix + "mlb_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setOpr9Wgt4h(JSPUtil.getParameter(request, prefix + "opr9_wgt_4h", ""));
		setDg40Opr1(JSPUtil.getParameter(request, prefix + "dg_40_opr1", ""));
		setOpr5Wgt45(JSPUtil.getParameter(request, prefix + "opr5_wgt_45", ""));
		setAk2hOpr2(JSPUtil.getParameter(request, prefix + "ak_2h_opr2", ""));
		setAk2hOpr1(JSPUtil.getParameter(request, prefix + "ak_2h_opr1", ""));
		setAk2hOpr4(JSPUtil.getParameter(request, prefix + "ak_2h_opr4", ""));
		setAk2hOpr3(JSPUtil.getParameter(request, prefix + "ak_2h_opr3", ""));
		setAk2hOpr6(JSPUtil.getParameter(request, prefix + "ak_2h_opr6", ""));
		setAk2hOpr5(JSPUtil.getParameter(request, prefix + "ak_2h_opr5", ""));
		setAk2hOpr8(JSPUtil.getParameter(request, prefix + "ak_2h_opr8", ""));
		setAk2hOpr7(JSPUtil.getParameter(request, prefix + "ak_2h_opr7", ""));
		setAk2hOpr9(JSPUtil.getParameter(request, prefix + "ak_2h_opr9", ""));
		setDg45Tot(JSPUtil.getParameter(request, prefix + "dg_45_tot", ""));
		
		setStwg20Opr1(JSPUtil.getParameter(request, prefix + "dg_20_opr1", ""));
		setStwg2hOpr1(JSPUtil.getParameter(request, prefix + "dg_2h_opr1", ""));
		setStwg40Opr1(JSPUtil.getParameter(request, prefix + "dg_40_opr1", ""));
		setStwg4hOpr1(JSPUtil.getParameter(request, prefix + "dg_4h_opr1", ""));
		setStwg45Opr1(JSPUtil.getParameter(request, prefix + "dg_45_opr1", ""));
		
		setStwg20Opr2(JSPUtil.getParameter(request, prefix + "dg_20_opr2", ""));
		setStwg2hOpr2(JSPUtil.getParameter(request, prefix + "dg_2h_opr2", ""));
		setStwg40Opr2(JSPUtil.getParameter(request, prefix + "dg_40_opr2", ""));
		setStwg4hOpr2(JSPUtil.getParameter(request, prefix + "dg_4h_opr2", ""));
		setStwg45Opr2(JSPUtil.getParameter(request, prefix + "dg_45_opr2", ""));
		
		setStwg20Opr3(JSPUtil.getParameter(request, prefix + "dg_20_opr3", ""));
		setStwg2hOpr3(JSPUtil.getParameter(request, prefix + "dg_2h_opr3", ""));
		setStwg40Opr3(JSPUtil.getParameter(request, prefix + "dg_40_opr3", ""));
		setStwg4hOpr3(JSPUtil.getParameter(request, prefix + "dg_4h_opr3", ""));
		setStwg45Opr3(JSPUtil.getParameter(request, prefix + "dg_45_opr3", ""));
		
		setStwg20Opr4(JSPUtil.getParameter(request, prefix + "dg_20_opr4", ""));
		setStwg2hOpr4(JSPUtil.getParameter(request, prefix + "dg_2h_opr4", ""));
		setStwg40Opr4(JSPUtil.getParameter(request, prefix + "dg_40_opr4", ""));
		setStwg4hOpr4(JSPUtil.getParameter(request, prefix + "dg_4h_opr4", ""));
		setStwg45Opr4(JSPUtil.getParameter(request, prefix + "dg_45_opr4", ""));
		
		setStwg20Opr5(JSPUtil.getParameter(request, prefix + "dg_20_opr5", ""));
		setStwg2hOpr5(JSPUtil.getParameter(request, prefix + "dg_2h_opr5", ""));
		setStwg40Opr5(JSPUtil.getParameter(request, prefix + "dg_40_opr5", ""));
		setStwg4hOpr5(JSPUtil.getParameter(request, prefix + "dg_4h_opr5", ""));
		setStwg45Opr5(JSPUtil.getParameter(request, prefix + "dg_45_opr5", ""));
		
		setStwg20Tot(JSPUtil.getParameter(request, prefix + "dg_20_tot", ""));
		setStwg2hTot(JSPUtil.getParameter(request, prefix + "dg_2h_tot", ""));
		setStwg40Tot(JSPUtil.getParameter(request, prefix + "dg_40_tot", ""));
		setStwg4hTot(JSPUtil.getParameter(request, prefix + "dg_4h_tot", ""));
		setStwg45Tot(JSPUtil.getParameter(request, prefix + "dg_45_tot", ""));
		
		setPodYdCd(JSPUtil.getParameter(request,   prefix +  "pod_yd_cd", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CBFSummaryVO[]
	 */
	public CBFSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CBFSummaryVO[]
	 */
	public CBFSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CBFSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bb2hOpr10 = (JSPUtil.getParameter(request, prefix	+ "bb_2h_opr10", length));
			String[] fm = (JSPUtil.getParameter(request, prefix	+ "fm", length));
			String[] opr5Wgt4 = (JSPUtil.getParameter(request, prefix	+ "opr5_wgt_4", length));
			String[] opr5Wgt2 = (JSPUtil.getParameter(request, prefix	+ "opr5_wgt_2", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] opr8Wgt4h = (JSPUtil.getParameter(request, prefix	+ "opr8_wgt_4h", length));
			String[] opr10Wgt4 = (JSPUtil.getParameter(request, prefix	+ "opr10_wgt_4", length));
			String[] ak20Tot = (JSPUtil.getParameter(request, prefix	+ "ak_20_tot", length));
			String[] ak2hOpr10 = (JSPUtil.getParameter(request, prefix	+ "ak_2h_opr10", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] ak40Opr10 = (JSPUtil.getParameter(request, prefix	+ "ak_40_opr10", length));
			String[] opr10Wgt2 = (JSPUtil.getParameter(request, prefix	+ "opr10_wgt_2", length));
			String[] opr8Wgt45 = (JSPUtil.getParameter(request, prefix	+ "opr8_wgt_45", length));
			String[] opr8Wgt2h = (JSPUtil.getParameter(request, prefix	+ "opr8_wgt_2h", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] opr3Wgt2 = (JSPUtil.getParameter(request, prefix	+ "opr3_wgt_2", length));
			String[] rf2hTot = (JSPUtil.getParameter(request, prefix	+ "rf_2h_tot", length));
			String[] opr3Wgt4 = (JSPUtil.getParameter(request, prefix	+ "opr3_wgt_4", length));
			String[] opr2Wgt2 = (JSPUtil.getParameter(request, prefix	+ "opr2_wgt_2", length));
			String[] ak20Opr10 = (JSPUtil.getParameter(request, prefix	+ "ak_20_opr10", length));
			String[] opr5Teu = (JSPUtil.getParameter(request, prefix	+ "opr5_teu", length));
			String[] totWgt45 = (JSPUtil.getParameter(request, prefix	+ "tot_wgt_45", length));
			String[] opr2Wgt4 = (JSPUtil.getParameter(request, prefix	+ "opr2_wgt_4", length));
			String[] totWgt2h = (JSPUtil.getParameter(request, prefix	+ "tot_wgt_2h", length));
			String[] opr5Qty2 = (JSPUtil.getParameter(request, prefix	+ "opr5_qty_2", length));
			String[] opr5Qty4 = (JSPUtil.getParameter(request, prefix	+ "opr5_qty_4", length));
			String[] bb20Opr7 = (JSPUtil.getParameter(request, prefix	+ "bb_20_opr7", length));
			String[] opr3Teu = (JSPUtil.getParameter(request, prefix	+ "opr3_teu", length));
			String[] bb20Opr8 = (JSPUtil.getParameter(request, prefix	+ "bb_20_opr8", length));
			String[] opr6Qty4h = (JSPUtil.getParameter(request, prefix	+ "opr6_qty_4h", length));
			String[] bb20Opr9 = (JSPUtil.getParameter(request, prefix	+ "bb_20_opr9", length));
			String[] bb20Opr3 = (JSPUtil.getParameter(request, prefix	+ "bb_20_opr3", length));
			String[] totWgt4h = (JSPUtil.getParameter(request, prefix	+ "tot_wgt_4h", length));
			String[] bb20Opr4 = (JSPUtil.getParameter(request, prefix	+ "bb_20_opr4", length));
			String[] rf40Tot = (JSPUtil.getParameter(request, prefix	+ "rf_40_tot", length));
			String[] bb20Opr5 = (JSPUtil.getParameter(request, prefix	+ "bb_20_opr5", length));
			String[] bb20Opr6 = (JSPUtil.getParameter(request, prefix	+ "bb_20_opr6", length));
			String[] opr10Qty2h = (JSPUtil.getParameter(request, prefix	+ "opr10_qty_2h", length));
			String[] opr2Wgt2h = (JSPUtil.getParameter(request, prefix	+ "opr2_wgt_2h", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] opr1Qty2 = (JSPUtil.getParameter(request, prefix	+ "opr1_qty_2", length));
			String[] qty10 = (JSPUtil.getParameter(request, prefix	+ "qty10", length));
			String[] opr1Qty4 = (JSPUtil.getParameter(request, prefix	+ "opr1_qty_4", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dg45Opr8 = (JSPUtil.getParameter(request, prefix	+ "dg_45_opr8", length));
			String[] dg45Opr7 = (JSPUtil.getParameter(request, prefix	+ "dg_45_opr7", length));
			String[] dg45Opr6 = (JSPUtil.getParameter(request, prefix	+ "dg_45_opr6", length));
			String[] rf20Opr10 = (JSPUtil.getParameter(request, prefix	+ "rf_20_opr10", length));
			String[] dg45Opr5 = (JSPUtil.getParameter(request, prefix	+ "dg_45_opr5", length));
			String[] dg45Opr9 = (JSPUtil.getParameter(request, prefix	+ "dg_45_opr9", length));
			String[] bb20Opr2 = (JSPUtil.getParameter(request, prefix	+ "bb_20_opr2", length));
			String[] dg45Opr4 = (JSPUtil.getParameter(request, prefix	+ "dg_45_opr4", length));
			String[] bb20Opr1 = (JSPUtil.getParameter(request, prefix	+ "bb_20_opr1", length));
			String[] dg45Opr3 = (JSPUtil.getParameter(request, prefix	+ "dg_45_opr3", length));
			String[] dg45Opr2 = (JSPUtil.getParameter(request, prefix	+ "dg_45_opr2", length));
			String[] dg45Opr1 = (JSPUtil.getParameter(request, prefix	+ "dg_45_opr1", length));
			String[] dg40Tot = (JSPUtil.getParameter(request, prefix	+ "dg_40_tot", length));
			String[] opr6Qty2h = (JSPUtil.getParameter(request, prefix	+ "opr6_qty_2h", length));
			String[] opr5Wgt4h = (JSPUtil.getParameter(request, prefix	+ "opr5_wgt_4h", length));
			String[] bb45Opr10 = (JSPUtil.getParameter(request, prefix	+ "bb_45_opr10", length));
			String[] dg40Opr10 = (JSPUtil.getParameter(request, prefix	+ "dg_40_opr10", length));
			String[] totTeu = (JSPUtil.getParameter(request, prefix	+ "tot_teu", length));
			String[] stwgCgoFlg = (JSPUtil.getParameter(request, prefix	+ "stwg_cgo_flg", length));
			String[] opr6Qty45 = (JSPUtil.getParameter(request, prefix	+ "opr6_qty_45", length));
			String[] dg4hOpr10 = (JSPUtil.getParameter(request, prefix	+ "dg_4h_opr10", length));
			String[] opr8Wgt2 = (JSPUtil.getParameter(request, prefix	+ "opr8_wgt_2", length));
			String[] opr8Wgt4 = (JSPUtil.getParameter(request, prefix	+ "opr8_wgt_4", length));
			String[] cbfIndFlg = (JSPUtil.getParameter(request, prefix	+ "cbf_ind_flg", length));
			String[] rf4hOpr3 = (JSPUtil.getParameter(request, prefix	+ "rf_4h_opr3", length));
			String[] bb4hOpr9 = (JSPUtil.getParameter(request, prefix	+ "bb_4h_opr9", length));
			String[] rf4hOpr4 = (JSPUtil.getParameter(request, prefix	+ "rf_4h_opr4", length));
			String[] rf4hOpr1 = (JSPUtil.getParameter(request, prefix	+ "rf_4h_opr1", length));
			String[] rf4hOpr2 = (JSPUtil.getParameter(request, prefix	+ "rf_4h_opr2", length));
			String[] bb4hOpr5 = (JSPUtil.getParameter(request, prefix	+ "bb_4h_opr5", length));
			String[] rf4hOpr7 = (JSPUtil.getParameter(request, prefix	+ "rf_4h_opr7", length));
			String[] bb4hOpr6 = (JSPUtil.getParameter(request, prefix	+ "bb_4h_opr6", length));
			String[] rf4hOpr8 = (JSPUtil.getParameter(request, prefix	+ "rf_4h_opr8", length));
			String[] rf4hOpr5 = (JSPUtil.getParameter(request, prefix	+ "rf_4h_opr5", length));
			String[] bb4hOpr7 = (JSPUtil.getParameter(request, prefix	+ "bb_4h_opr7", length));
			String[] rf4hOpr6 = (JSPUtil.getParameter(request, prefix	+ "rf_4h_opr6", length));
			String[] bb4hOpr8 = (JSPUtil.getParameter(request, prefix	+ "bb_4h_opr8", length));
			String[] opr3Qty45 = (JSPUtil.getParameter(request, prefix	+ "opr3_qty_45", length));
			String[] bb4hOpr1 = (JSPUtil.getParameter(request, prefix	+ "bb_4h_opr1", length));
			String[] bb4hOpr2 = (JSPUtil.getParameter(request, prefix	+ "bb_4h_opr2", length));
			String[] ak20Opr9 = (JSPUtil.getParameter(request, prefix	+ "ak_20_opr9", length));
			String[] opr4Wgt2h = (JSPUtil.getParameter(request, prefix	+ "opr4_wgt_2h", length));
			String[] bb4hOpr3 = (JSPUtil.getParameter(request, prefix	+ "bb_4h_opr3", length));
			String[] bb4hOpr4 = (JSPUtil.getParameter(request, prefix	+ "bb_4h_opr4", length));
			String[] opr9Qty2 = (JSPUtil.getParameter(request, prefix	+ "opr9_qty_2", length));
			String[] opr9Qty4 = (JSPUtil.getParameter(request, prefix	+ "opr9_qty_4", length));
			String[] ak20Opr1 = (JSPUtil.getParameter(request, prefix	+ "ak_20_opr1", length));
			String[] ak20Opr2 = (JSPUtil.getParameter(request, prefix	+ "ak_20_opr2", length));
			String[] ak20Opr3 = (JSPUtil.getParameter(request, prefix	+ "ak_20_opr3", length));
			String[] ak20Opr4 = (JSPUtil.getParameter(request, prefix	+ "ak_20_opr4", length));
			String[] ak20Opr5 = (JSPUtil.getParameter(request, prefix	+ "ak_20_opr5", length));
			String[] ak20Opr6 = (JSPUtil.getParameter(request, prefix	+ "ak_20_opr6", length));
			String[] opr3Qty2h = (JSPUtil.getParameter(request, prefix	+ "opr3_qty_2h", length));
			String[] ak20Opr7 = (JSPUtil.getParameter(request, prefix	+ "ak_20_opr7", length));
			String[] ak20Opr8 = (JSPUtil.getParameter(request, prefix	+ "ak_20_opr8", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] opr4Qty4h = (JSPUtil.getParameter(request, prefix	+ "opr4_qty_4h", length));
			String[] rf4hOpr9 = (JSPUtil.getParameter(request, prefix	+ "rf_4h_opr9", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ak45Opr7 = (JSPUtil.getParameter(request, prefix	+ "ak_45_opr7", length));
			String[] ak45Opr6 = (JSPUtil.getParameter(request, prefix	+ "ak_45_opr6", length));
			String[] opr8Qty2h = (JSPUtil.getParameter(request, prefix	+ "opr8_qty_2h", length));
			String[] ak45Opr9 = (JSPUtil.getParameter(request, prefix	+ "ak_45_opr9", length));
			String[] ak45Opr8 = (JSPUtil.getParameter(request, prefix	+ "ak_45_opr8", length));
			String[] totTtl = (JSPUtil.getParameter(request, prefix	+ "tot_ttl", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] opr8Qty45 = (JSPUtil.getParameter(request, prefix	+ "opr8_qty_45", length));
			String[] ak45Opr1 = (JSPUtil.getParameter(request, prefix	+ "ak_45_opr1", length));
			String[] ak45Opr2 = (JSPUtil.getParameter(request, prefix	+ "ak_45_opr2", length));
			String[] ak45Opr3 = (JSPUtil.getParameter(request, prefix	+ "ak_45_opr3", length));
			String[] ak45Opr4 = (JSPUtil.getParameter(request, prefix	+ "ak_45_opr4", length));
			String[] ak45Opr5 = (JSPUtil.getParameter(request, prefix	+ "ak_45_opr5", length));
			String[] bb2hOpr9 = (JSPUtil.getParameter(request, prefix	+ "bb_2h_opr9", length));
			String[] bb2hOpr8 = (JSPUtil.getParameter(request, prefix	+ "bb_2h_opr8", length));
			String[] bb2hOpr7 = (JSPUtil.getParameter(request, prefix	+ "bb_2h_opr7", length));
			String[] bb2hOpr6 = (JSPUtil.getParameter(request, prefix	+ "bb_2h_opr6", length));
			String[] bb2hOpr5 = (JSPUtil.getParameter(request, prefix	+ "bb_2h_opr5", length));
			String[] bb2hOpr4 = (JSPUtil.getParameter(request, prefix	+ "bb_2h_opr4", length));
			String[] bb2hOpr3 = (JSPUtil.getParameter(request, prefix	+ "bb_2h_opr3", length));
			String[] bb2hOpr2 = (JSPUtil.getParameter(request, prefix	+ "bb_2h_opr2", length));
			String[] bb2hOpr1 = (JSPUtil.getParameter(request, prefix	+ "bb_2h_opr1", length));
			String[] opr4Wgt4h = (JSPUtil.getParameter(request, prefix	+ "opr4_wgt_4h", length));
			String[] opr10Qty45 = (JSPUtil.getParameter(request, prefix	+ "opr10_qty_45", length));
			String[] opr3Qty4h = (JSPUtil.getParameter(request, prefix	+ "opr3_qty_4h", length));
			String[] opr6Wgt2 = (JSPUtil.getParameter(request, prefix	+ "opr6_wgt_2", length));
			String[] dg2hTot = (JSPUtil.getParameter(request, prefix	+ "dg_2h_tot", length));
			String[] opr6Wgt4 = (JSPUtil.getParameter(request, prefix	+ "opr6_wgt_4", length));
			String[] ak45Tot = (JSPUtil.getParameter(request, prefix	+ "ak_45_tot", length));
			String[] rf4hTot = (JSPUtil.getParameter(request, prefix	+ "rf_4h_tot", length));
			String[] opr10Qty4h = (JSPUtil.getParameter(request, prefix	+ "opr10_qty_4h", length));
			String[] rf45Opr3 = (JSPUtil.getParameter(request, prefix	+ "rf_45_opr3", length));
			String[] rf45Opr2 = (JSPUtil.getParameter(request, prefix	+ "rf_45_opr2", length));
			String[] rf45Opr1 = (JSPUtil.getParameter(request, prefix	+ "rf_45_opr1", length));
			String[] opr4Wgt45 = (JSPUtil.getParameter(request, prefix	+ "opr4_wgt_45", length));
			String[] rf45Opr7 = (JSPUtil.getParameter(request, prefix	+ "rf_45_opr7", length));
			String[] rf45Opr6 = (JSPUtil.getParameter(request, prefix	+ "rf_45_opr6", length));
			String[] rf45Opr5 = (JSPUtil.getParameter(request, prefix	+ "rf_45_opr5", length));
			String[] bb40Opr9 = (JSPUtil.getParameter(request, prefix	+ "bb_40_opr9", length));
			String[] rf45Opr4 = (JSPUtil.getParameter(request, prefix	+ "rf_45_opr4", length));
			String[] bb40Opr7 = (JSPUtil.getParameter(request, prefix	+ "bb_40_opr7", length));
			String[] bb40Opr8 = (JSPUtil.getParameter(request, prefix	+ "bb_40_opr8", length));
			String[] bb40Opr5 = (JSPUtil.getParameter(request, prefix	+ "bb_40_opr5", length));
			String[] rf45Opr9 = (JSPUtil.getParameter(request, prefix	+ "rf_45_opr9", length));
			String[] bb40Opr6 = (JSPUtil.getParameter(request, prefix	+ "bb_40_opr6", length));
			String[] rf45Opr8 = (JSPUtil.getParameter(request, prefix	+ "rf_45_opr8", length));
			String[] totQty2h = (JSPUtil.getParameter(request, prefix	+ "tot_qty_2h", length));
			String[] opr1Qty4h = (JSPUtil.getParameter(request, prefix	+ "opr1_qty_4h", length));
			String[] rf40Opr1 = (JSPUtil.getParameter(request, prefix	+ "rf_40_opr1", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] rf40Opr2 = (JSPUtil.getParameter(request, prefix	+ "rf_40_opr2", length));
			String[] rf40Opr3 = (JSPUtil.getParameter(request, prefix	+ "rf_40_opr3", length));
			String[] rf40Opr4 = (JSPUtil.getParameter(request, prefix	+ "rf_40_opr4", length));
			String[] rf40Opr5 = (JSPUtil.getParameter(request, prefix	+ "rf_40_opr5", length));
			String[] rf40Opr6 = (JSPUtil.getParameter(request, prefix	+ "rf_40_opr6", length));
			String[] dg20Tot = (JSPUtil.getParameter(request, prefix	+ "dg_20_tot", length));
			String[] rf40Opr7 = (JSPUtil.getParameter(request, prefix	+ "rf_40_opr7", length));
			String[] rf40Opr8 = (JSPUtil.getParameter(request, prefix	+ "rf_40_opr8", length));
			String[] rf40Opr9 = (JSPUtil.getParameter(request, prefix	+ "rf_40_opr9", length));
			String[] bb40Opr1 = (JSPUtil.getParameter(request, prefix	+ "bb_40_opr1", length));
			String[] totQty45 = (JSPUtil.getParameter(request, prefix	+ "tot_qty_45", length));
			String[] bb40Opr2 = (JSPUtil.getParameter(request, prefix	+ "bb_40_opr2", length));
			String[] bb40Opr3 = (JSPUtil.getParameter(request, prefix	+ "bb_40_opr3", length));
			String[] bb40Opr4 = (JSPUtil.getParameter(request, prefix	+ "bb_40_opr4", length));
			String[] bb40Tot = (JSPUtil.getParameter(request, prefix	+ "bb_40_tot", length));
			String[] opr7Qty2h = (JSPUtil.getParameter(request, prefix	+ "opr7_qty_2h", length));
			String[] bb20Opr10 = (JSPUtil.getParameter(request, prefix	+ "bb_20_opr10", length));
			String[] opr7Qty45 = (JSPUtil.getParameter(request, prefix	+ "opr7_qty_45", length));
			String[] rf45Opr10 = (JSPUtil.getParameter(request, prefix	+ "rf_45_opr10", length));
			String[] bb20Tot = (JSPUtil.getParameter(request, prefix	+ "bb_20_tot", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] totQty2 = (JSPUtil.getParameter(request, prefix	+ "tot_qty_2", length));
			String[] totQty4 = (JSPUtil.getParameter(request, prefix	+ "tot_qty_4", length));
			String[] opr8Qty4h = (JSPUtil.getParameter(request, prefix	+ "opr8_qty_4h", length));
			String[] bkgShprOwnrFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_shpr_ownr_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] opr7Qty4h = (JSPUtil.getParameter(request, prefix	+ "opr7_qty_4h", length));
			String[] rf40Opr10 = (JSPUtil.getParameter(request, prefix	+ "rf_40_opr10", length));
			String[] pcCgoFlg = (JSPUtil.getParameter(request, prefix	+ "pc_cgo_flg", length));
			String[] ak45Opr10 = (JSPUtil.getParameter(request, prefix	+ "ak_45_opr10", length));
			String[] opr10Teu = (JSPUtil.getParameter(request, prefix	+ "opr10_teu", length));
			String[] opr1Wgt2h = (JSPUtil.getParameter(request, prefix	+ "opr1_wgt_2h", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] opr7Wgt45 = (JSPUtil.getParameter(request, prefix	+ "opr7_wgt_45", length));
			String[] ak4hOpr2 = (JSPUtil.getParameter(request, prefix	+ "ak_4h_opr2", length));
			String[] ak4hOpr1 = (JSPUtil.getParameter(request, prefix	+ "ak_4h_opr1", length));
			String[] opr10Wgt4h = (JSPUtil.getParameter(request, prefix	+ "opr10_wgt_4h", length));
			String[] opr7Wgt2h = (JSPUtil.getParameter(request, prefix	+ "opr7_wgt_2h", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] dg45Opr10 = (JSPUtil.getParameter(request, prefix	+ "dg_45_opr10", length));
			String[] wg = (JSPUtil.getParameter(request, prefix	+ "wg", length));
			String[] opr10Qty4 = (JSPUtil.getParameter(request, prefix	+ "opr10_qty_4", length));
			String[] opr10Qty2 = (JSPUtil.getParameter(request, prefix	+ "opr10_qty_2", length));
			String[] bb4hOpr10 = (JSPUtil.getParameter(request, prefix	+ "bb_4h_opr10", length));
			String[] ak4hOpr5 = (JSPUtil.getParameter(request, prefix	+ "ak_4h_opr5", length));
			String[] ak4hOpr6 = (JSPUtil.getParameter(request, prefix	+ "ak_4h_opr6", length));
			String[] ak4hOpr3 = (JSPUtil.getParameter(request, prefix	+ "ak_4h_opr3", length));
			String[] crrCd2 = (JSPUtil.getParameter(request, prefix	+ "crr_cd2", length));
			String[] ak4hOpr4 = (JSPUtil.getParameter(request, prefix	+ "ak_4h_opr4", length));
			String[] ak4hOpr9 = (JSPUtil.getParameter(request, prefix	+ "ak_4h_opr9", length));
			String[] ak4hOpr7 = (JSPUtil.getParameter(request, prefix	+ "ak_4h_opr7", length));
			String[] opr1Qty45 = (JSPUtil.getParameter(request, prefix	+ "opr1_qty_45", length));
			String[] ak4hOpr8 = (JSPUtil.getParameter(request, prefix	+ "ak_4h_opr8", length));
			String[] opr8Teu = (JSPUtil.getParameter(request, prefix	+ "opr8_teu", length));
			String[] opr10 = (JSPUtil.getParameter(request, prefix	+ "opr10", length));
			String[] opr1Qty2h = (JSPUtil.getParameter(request, prefix	+ "opr1_qty_2h", length));
			String[] opr1Wgt45 = (JSPUtil.getParameter(request, prefix	+ "opr1_wgt_45", length));
			String[] sort = (JSPUtil.getParameter(request, prefix	+ "sort", length));
			String[] opr1Teu = (JSPUtil.getParameter(request, prefix	+ "opr1_teu", length));
			String[] rf45Tot = (JSPUtil.getParameter(request, prefix	+ "rf_45_tot", length));
			String[] opr7Wgt4h = (JSPUtil.getParameter(request, prefix	+ "opr7_wgt_4h", length));
			String[] opr4Qty2 = (JSPUtil.getParameter(request, prefix	+ "opr4_qty_2", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] totQty4h = (JSPUtil.getParameter(request, prefix	+ "tot_qty_4h", length));
			String[] bb40Opr10 = (JSPUtil.getParameter(request, prefix	+ "bb_40_opr10", length));
			String[] opr2Qty4 = (JSPUtil.getParameter(request, prefix	+ "opr2_qty_4", length));
			String[] opr2Qty2 = (JSPUtil.getParameter(request, prefix	+ "opr2_qty_2", length));
			String[] opr9Wgt2 = (JSPUtil.getParameter(request, prefix	+ "opr9_wgt_2", length));
			String[] stwgNm = (JSPUtil.getParameter(request, prefix	+ "stwg_nm", length));
			String[] opr9Wgt4 = (JSPUtil.getParameter(request, prefix	+ "opr9_wgt_4", length));
			String[] opr1Wgt4 = (JSPUtil.getParameter(request, prefix	+ "opr1_wgt_4", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] opr1Wgt2 = (JSPUtil.getParameter(request, prefix	+ "opr1_wgt_2", length));
			String[] opr7Wgt4 = (JSPUtil.getParameter(request, prefix	+ "opr7_wgt_4", length));
			String[] opr7Wgt2 = (JSPUtil.getParameter(request, prefix	+ "opr7_wgt_2", length));
			String[] opr8Qty4 = (JSPUtil.getParameter(request, prefix	+ "opr8_qty_4", length));
			String[] opr8Qty2 = (JSPUtil.getParameter(request, prefix	+ "opr8_qty_2", length));
			String[] opr4Qty4 = (JSPUtil.getParameter(request, prefix	+ "opr4_qty_4", length));
			String[] opr9Qty2h = (JSPUtil.getParameter(request, prefix	+ "opr9_qty_2h", length));
			String[] opr7Teu = (JSPUtil.getParameter(request, prefix	+ "opr7_teu", length));
			String[] opr9Qty45 = (JSPUtil.getParameter(request, prefix	+ "opr9_qty_45", length));
			String[] unit2 = (JSPUtil.getParameter(request, prefix	+ "unit2", length));
			String[] unit4 = (JSPUtil.getParameter(request, prefix	+ "unit4", length));
			String[] opr6Teu = (JSPUtil.getParameter(request, prefix	+ "opr6_teu", length));
			String[] opr4Teu = (JSPUtil.getParameter(request, prefix	+ "opr4_teu", length));
			String[] opr3Qty4 = (JSPUtil.getParameter(request, prefix	+ "opr3_qty_4", length));
			String[] opr1Wgt4h = (JSPUtil.getParameter(request, prefix	+ "opr1_wgt_4h", length));
			String[] opr10Wgt45 = (JSPUtil.getParameter(request, prefix	+ "opr10_wgt_45", length));
			String[] opr10Wgt2h = (JSPUtil.getParameter(request, prefix	+ "opr10_wgt_2h", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] opr7 = (JSPUtil.getParameter(request, prefix	+ "opr7", length));
			String[] opr8 = (JSPUtil.getParameter(request, prefix	+ "opr8", length));
			String[] opr5 = (JSPUtil.getParameter(request, prefix	+ "opr5", length));
			String[] opr6 = (JSPUtil.getParameter(request, prefix	+ "opr6", length));
			String[] opr3 = (JSPUtil.getParameter(request, prefix	+ "opr3", length));
			String[] opr4 = (JSPUtil.getParameter(request, prefix	+ "opr4", length));
			String[] opr1 = (JSPUtil.getParameter(request, prefix	+ "opr1", length));
			String[] opr2 = (JSPUtil.getParameter(request, prefix	+ "opr2", length));
			String[] opr4Wgt4 = (JSPUtil.getParameter(request, prefix	+ "opr4_wgt_4", length));
			String[] opr4Wgt2 = (JSPUtil.getParameter(request, prefix	+ "opr4_wgt_2", length));
			String[] opr4Qty2h = (JSPUtil.getParameter(request, prefix	+ "opr4_qty_2h", length));
			String[] opr9 = (JSPUtil.getParameter(request, prefix	+ "opr9", length));
			String[] opr4Qty45 = (JSPUtil.getParameter(request, prefix	+ "opr4_qty_45", length));
			String[] rf2hOpr2 = (JSPUtil.getParameter(request, prefix	+ "rf_2h_opr2", length));
			String[] opr6Qty4 = (JSPUtil.getParameter(request, prefix	+ "opr6_qty_4", length));
			String[] rf2hOpr1 = (JSPUtil.getParameter(request, prefix	+ "rf_2h_opr1", length));
			String[] opr6Qty2 = (JSPUtil.getParameter(request, prefix	+ "opr6_qty_2", length));
			String[] opr5Qty2h = (JSPUtil.getParameter(request, prefix	+ "opr5_qty_2h", length));
			String[] rf2hOpr6 = (JSPUtil.getParameter(request, prefix	+ "rf_2h_opr6", length));
			String[] opr2Qty2h = (JSPUtil.getParameter(request, prefix	+ "opr2_qty_2h", length));
			String[] rf2hOpr5 = (JSPUtil.getParameter(request, prefix	+ "rf_2h_opr5", length));
			String[] rf2hOpr4 = (JSPUtil.getParameter(request, prefix	+ "rf_2h_opr4", length));
			String[] rf4hOpr10 = (JSPUtil.getParameter(request, prefix	+ "rf_4h_opr10", length));
			String[] rf2hOpr3 = (JSPUtil.getParameter(request, prefix	+ "rf_2h_opr3", length));
			String[] rf20Opr8 = (JSPUtil.getParameter(request, prefix	+ "rf_20_opr8", length));
			String[] rf20Opr7 = (JSPUtil.getParameter(request, prefix	+ "rf_20_opr7", length));
			String[] rf20Opr9 = (JSPUtil.getParameter(request, prefix	+ "rf_20_opr9", length));
			String[] rf20Opr4 = (JSPUtil.getParameter(request, prefix	+ "rf_20_opr4", length));
			String[] dg40Opr5 = (JSPUtil.getParameter(request, prefix	+ "dg_40_opr5", length));
			String[] rf2hOpr9 = (JSPUtil.getParameter(request, prefix	+ "rf_2h_opr9", length));
			String[] ak4hTot = (JSPUtil.getParameter(request, prefix	+ "ak_4h_tot", length));
			String[] opr2Qty45 = (JSPUtil.getParameter(request, prefix	+ "opr2_qty_45", length));
			String[] rf20Opr3 = (JSPUtil.getParameter(request, prefix	+ "rf_20_opr3", length));
			String[] dg40Opr4 = (JSPUtil.getParameter(request, prefix	+ "dg_40_opr4", length));
			String[] qty1 = (JSPUtil.getParameter(request, prefix	+ "qty1", length));
			String[] dg40Opr3 = (JSPUtil.getParameter(request, prefix	+ "dg_40_opr3", length));
			String[] rf20Opr6 = (JSPUtil.getParameter(request, prefix	+ "rf_20_opr6", length));
			String[] rf2hOpr7 = (JSPUtil.getParameter(request, prefix	+ "rf_2h_opr7", length));
			String[] dg40Opr2 = (JSPUtil.getParameter(request, prefix	+ "dg_40_opr2", length));
			String[] rf20Opr5 = (JSPUtil.getParameter(request, prefix	+ "rf_20_opr5", length));
			String[] rf2hOpr8 = (JSPUtil.getParameter(request, prefix	+ "rf_2h_opr8", length));
			String[] qty3 = (JSPUtil.getParameter(request, prefix	+ "qty3", length));
			String[] dg40Opr9 = (JSPUtil.getParameter(request, prefix	+ "dg_40_opr9", length));
			String[] qty2 = (JSPUtil.getParameter(request, prefix	+ "qty2", length));
			String[] dg40Opr8 = (JSPUtil.getParameter(request, prefix	+ "dg_40_opr8", length));
			String[] opr5Qty45 = (JSPUtil.getParameter(request, prefix	+ "opr5_qty_45", length));
			String[] qty5 = (JSPUtil.getParameter(request, prefix	+ "qty5", length));
			String[] rf20Opr2 = (JSPUtil.getParameter(request, prefix	+ "rf_20_opr2", length));
			String[] dg40Opr7 = (JSPUtil.getParameter(request, prefix	+ "dg_40_opr7", length));
			String[] qty4 = (JSPUtil.getParameter(request, prefix	+ "qty4", length));
			String[] rf20Opr1 = (JSPUtil.getParameter(request, prefix	+ "rf_20_opr1", length));
			String[] dg40Opr6 = (JSPUtil.getParameter(request, prefix	+ "dg_40_opr6", length));
			String[] opr9Wgt45 = (JSPUtil.getParameter(request, prefix	+ "opr9_wgt_45", length));
			String[] dg4hOpr1 = (JSPUtil.getParameter(request, prefix	+ "dg_4h_opr1", length));
			String[] opr3Qty2 = (JSPUtil.getParameter(request, prefix	+ "opr3_qty_2", length));
			String[] dg4hOpr7 = (JSPUtil.getParameter(request, prefix	+ "dg_4h_opr7", length));
			String[] dg4hOpr6 = (JSPUtil.getParameter(request, prefix	+ "dg_4h_opr6", length));
			String[] dg4hOpr9 = (JSPUtil.getParameter(request, prefix	+ "dg_4h_opr9", length));
			String[] dg4hOpr8 = (JSPUtil.getParameter(request, prefix	+ "dg_4h_opr8", length));
			String[] dg4hOpr3 = (JSPUtil.getParameter(request, prefix	+ "dg_4h_opr3", length));
			String[] opr2Teu = (JSPUtil.getParameter(request, prefix	+ "opr2_teu", length));
			String[] dg4hOpr2 = (JSPUtil.getParameter(request, prefix	+ "dg_4h_opr2", length));
			String[] opr9Wgt2h = (JSPUtil.getParameter(request, prefix	+ "opr9_wgt_2h", length));
			String[] dg4hOpr5 = (JSPUtil.getParameter(request, prefix	+ "dg_4h_opr5", length));
			String[] dg4hOpr4 = (JSPUtil.getParameter(request, prefix	+ "dg_4h_opr4", length));
			String[] ak4hOpr10 = (JSPUtil.getParameter(request, prefix	+ "ak_4h_opr10", length));
			String[] dg20Opr10 = (JSPUtil.getParameter(request, prefix	+ "dg_20_opr10", length));
			String[] opr2Qty4h = (JSPUtil.getParameter(request, prefix	+ "opr2_qty_4h", length));
			String[] opr2Wgt4h = (JSPUtil.getParameter(request, prefix	+ "opr2_wgt_4h", length));
			String[] opr7Qty4 = (JSPUtil.getParameter(request, prefix	+ "opr7_qty_4", length));
			String[] opr7Qty2 = (JSPUtil.getParameter(request, prefix	+ "opr7_qty_2", length));
			String[] dg20Opr1 = (JSPUtil.getParameter(request, prefix	+ "dg_20_opr1", length));
			String[] dg20Opr3 = (JSPUtil.getParameter(request, prefix	+ "dg_20_opr3", length));
			String[] dg20Opr2 = (JSPUtil.getParameter(request, prefix	+ "dg_20_opr2", length));
			String[] dg2hOpr10 = (JSPUtil.getParameter(request, prefix	+ "dg_2h_opr10", length));
			String[] dg20Opr5 = (JSPUtil.getParameter(request, prefix	+ "dg_20_opr5", length));
			String[] dg20Opr4 = (JSPUtil.getParameter(request, prefix	+ "dg_20_opr4", length));
			String[] dg20Opr7 = (JSPUtil.getParameter(request, prefix	+ "dg_20_opr7", length));
			String[] dg20Opr6 = (JSPUtil.getParameter(request, prefix	+ "dg_20_opr6", length));
			String[] dg20Opr9 = (JSPUtil.getParameter(request, prefix	+ "dg_20_opr9", length));
			String[] dg20Opr8 = (JSPUtil.getParameter(request, prefix	+ "dg_20_opr8", length));
			String[] dg4hTot = (JSPUtil.getParameter(request, prefix	+ "dg_4h_tot", length));
			String[] qty8 = (JSPUtil.getParameter(request, prefix	+ "qty8", length));
			String[] qty9 = (JSPUtil.getParameter(request, prefix	+ "qty9", length));
			String[] qty6 = (JSPUtil.getParameter(request, prefix	+ "qty6", length));
			String[] qty7 = (JSPUtil.getParameter(request, prefix	+ "qty7", length));
			String[] dg2hOpr4 = (JSPUtil.getParameter(request, prefix	+ "dg_2h_opr4", length));
			String[] dg2hOpr5 = (JSPUtil.getParameter(request, prefix	+ "dg_2h_opr5", length));
			String[] dg2hOpr6 = (JSPUtil.getParameter(request, prefix	+ "dg_2h_opr6", length));
			String[] dg2hOpr7 = (JSPUtil.getParameter(request, prefix	+ "dg_2h_opr7", length));
			String[] opr2Wgt45 = (JSPUtil.getParameter(request, prefix	+ "opr2_wgt_45", length));
			String[] dg2hOpr1 = (JSPUtil.getParameter(request, prefix	+ "dg_2h_opr1", length));
			String[] dg2hOpr2 = (JSPUtil.getParameter(request, prefix	+ "dg_2h_opr2", length));
			String[] dg2hOpr3 = (JSPUtil.getParameter(request, prefix	+ "dg_2h_opr3", length));
			String[] opr9Qty4h = (JSPUtil.getParameter(request, prefix	+ "opr9_qty_4h", length));
			String[] opr6Wgt2h = (JSPUtil.getParameter(request, prefix	+ "opr6_wgt_2h", length));
			String[] opr6Wgt45 = (JSPUtil.getParameter(request, prefix	+ "opr6_wgt_45", length));
			String[] dg2hOpr8 = (JSPUtil.getParameter(request, prefix	+ "dg_2h_opr8", length));
			String[] dg2hOpr9 = (JSPUtil.getParameter(request, prefix	+ "dg_2h_opr9", length));
			String[] rf20Tot = (JSPUtil.getParameter(request, prefix	+ "rf_20_tot", length));
			String[] totWgt2 = (JSPUtil.getParameter(request, prefix	+ "tot_wgt_2", length));
			String[] opr3Wgt2h = (JSPUtil.getParameter(request, prefix	+ "opr3_wgt_2h", length));
			String[] totWgt4 = (JSPUtil.getParameter(request, prefix	+ "tot_wgt_4", length));
			String[] mlb = (JSPUtil.getParameter(request, prefix	+ "mlb", length));
			String[] bb45Opr1 = (JSPUtil.getParameter(request, prefix	+ "bb_45_opr1", length));
			String[] opr3Wgt45 = (JSPUtil.getParameter(request, prefix	+ "opr3_wgt_45", length));
			String[] bb45Opr3 = (JSPUtil.getParameter(request, prefix	+ "bb_45_opr3", length));
			String[] bb45Opr2 = (JSPUtil.getParameter(request, prefix	+ "bb_45_opr2", length));
			String[] bb45Opr5 = (JSPUtil.getParameter(request, prefix	+ "bb_45_opr5", length));
			String[] bb45Opr4 = (JSPUtil.getParameter(request, prefix	+ "bb_45_opr4", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] bb45Opr7 = (JSPUtil.getParameter(request, prefix	+ "bb_45_opr7", length));
			String[] bb45Opr6 = (JSPUtil.getParameter(request, prefix	+ "bb_45_opr6", length));
			String[] bb45Opr9 = (JSPUtil.getParameter(request, prefix	+ "bb_45_opr9", length));
			String[] bb45Opr8 = (JSPUtil.getParameter(request, prefix	+ "bb_45_opr8", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] opr6Wgt4h = (JSPUtil.getParameter(request, prefix	+ "opr6_wgt_4h", length));
			String[] avWgt2 = (JSPUtil.getParameter(request, prefix	+ "av_wgt_2", length));
			String[] avWgt4 = (JSPUtil.getParameter(request, prefix	+ "av_wgt_4", length));
			String[] ak40Tot = (JSPUtil.getParameter(request, prefix	+ "ak_40_tot", length));
			String[] ak40Opr7 = (JSPUtil.getParameter(request, prefix	+ "ak_40_opr7", length));
			String[] ak40Opr8 = (JSPUtil.getParameter(request, prefix	+ "ak_40_opr8", length));
			String[] rf2hOpr10 = (JSPUtil.getParameter(request, prefix	+ "rf_2h_opr10", length));
			String[] ak40Opr9 = (JSPUtil.getParameter(request, prefix	+ "ak_40_opr9", length));
			String[] opr5Wgt2h = (JSPUtil.getParameter(request, prefix	+ "opr5_wgt_2h", length));
			String[] ak40Opr3 = (JSPUtil.getParameter(request, prefix	+ "ak_40_opr3", length));
			String[] ak40Opr4 = (JSPUtil.getParameter(request, prefix	+ "ak_40_opr4", length));
			String[] ak40Opr5 = (JSPUtil.getParameter(request, prefix	+ "ak_40_opr5", length));
			String[] opr5Qty4h = (JSPUtil.getParameter(request, prefix	+ "opr5_qty_4h", length));
			String[] ak40Opr6 = (JSPUtil.getParameter(request, prefix	+ "ak_40_opr6", length));
			String[] ak40Opr1 = (JSPUtil.getParameter(request, prefix	+ "ak_40_opr1", length));
			String[] ak40Opr2 = (JSPUtil.getParameter(request, prefix	+ "ak_40_opr2", length));
			String[] opr3Wgt4h = (JSPUtil.getParameter(request, prefix	+ "opr3_wgt_4h", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] opr9Teu = (JSPUtil.getParameter(request, prefix	+ "opr9_teu", length));
			String[] mlbCd = (JSPUtil.getParameter(request, prefix	+ "mlb_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] opr9Wgt4h = (JSPUtil.getParameter(request, prefix	+ "opr9_wgt_4h", length));
			String[] dg40Opr1 = (JSPUtil.getParameter(request, prefix	+ "dg_40_opr1", length));
			String[] opr5Wgt45 = (JSPUtil.getParameter(request, prefix	+ "opr5_wgt_45", length));
			String[] ak2hOpr2 = (JSPUtil.getParameter(request, prefix	+ "ak_2h_opr2", length));
			String[] ak2hOpr1 = (JSPUtil.getParameter(request, prefix	+ "ak_2h_opr1", length));
			String[] ak2hOpr4 = (JSPUtil.getParameter(request, prefix	+ "ak_2h_opr4", length));
			String[] ak2hOpr3 = (JSPUtil.getParameter(request, prefix	+ "ak_2h_opr3", length));
			String[] ak2hOpr6 = (JSPUtil.getParameter(request, prefix	+ "ak_2h_opr6", length));
			String[] ak2hOpr5 = (JSPUtil.getParameter(request, prefix	+ "ak_2h_opr5", length));
			String[] ak2hOpr8 = (JSPUtil.getParameter(request, prefix	+ "ak_2h_opr8", length));
			String[] ak2hOpr7 = (JSPUtil.getParameter(request, prefix	+ "ak_2h_opr7", length));
			String[] ak2hOpr9 = (JSPUtil.getParameter(request, prefix	+ "ak_2h_opr9", length));
			String[] dg45Tot = (JSPUtil.getParameter(request, prefix	+ "dg_45_tot", length));
			
			String[] stwg20Opr1 = (JSPUtil.getParameter(request, prefix	+ "stwg_20_opr1", length));
			String[] stwg2hOpr1 = (JSPUtil.getParameter(request, prefix	+ "stwg_2h_opr1", length));
			String[] stwg40Opr1 = (JSPUtil.getParameter(request, prefix	+ "stwg_40_opr1", length));
			String[] stwg4hOpr1 = (JSPUtil.getParameter(request, prefix	+ "stwg_4h_opr1", length));
			String[] stwg45Opr1 = (JSPUtil.getParameter(request, prefix	+ "stwg_45_opr1", length));
			
			String[] stwg20Opr2 = (JSPUtil.getParameter(request, prefix	+ "stwg_20_opr2", length));
			String[] stwg2hOpr2 = (JSPUtil.getParameter(request, prefix	+ "stwg_2h_opr2", length));
			String[] stwg40Opr2 = (JSPUtil.getParameter(request, prefix	+ "stwg_40_opr2", length));
			String[] stwg4hOpr2 = (JSPUtil.getParameter(request, prefix	+ "stwg_4h_opr2", length));
			String[] stwg45Opr2 = (JSPUtil.getParameter(request, prefix	+ "stwg_45_opr2", length));
			
			String[] stwg20Opr3 = (JSPUtil.getParameter(request, prefix	+ "stwg_20_opr3", length));
			String[] stwg2hOpr3 = (JSPUtil.getParameter(request, prefix	+ "stwg_2h_opr3", length));
			String[] stwg40Opr3 = (JSPUtil.getParameter(request, prefix	+ "stwg_40_opr3", length));
			String[] stwg4hOpr3 = (JSPUtil.getParameter(request, prefix	+ "stwg_4h_opr3", length));
			String[] stwg45Opr3 = (JSPUtil.getParameter(request, prefix	+ "stwg_45_opr3", length));
			
			String[] stwg20Opr4 = (JSPUtil.getParameter(request, prefix	+ "stwg_20_opr4", length));
			String[] stwg2hOpr4 = (JSPUtil.getParameter(request, prefix	+ "stwg_2h_opr4", length));
			String[] stwg40Opr4 = (JSPUtil.getParameter(request, prefix	+ "stwg_40_opr4", length));
			String[] stwg4hOpr4 = (JSPUtil.getParameter(request, prefix	+ "stwg_4h_opr4", length));
			String[] stwg45Opr4 = (JSPUtil.getParameter(request, prefix	+ "stwg_45_opr4", length));
			
			String[] stwg20Opr5 = (JSPUtil.getParameter(request, prefix	+ "stwg_20_opr5", length));
			String[] stwg2hOpr5 = (JSPUtil.getParameter(request, prefix	+ "stwg_2h_opr5", length));
			String[] stwg40Opr5 = (JSPUtil.getParameter(request, prefix	+ "stwg_40_opr5", length));
			String[] stwg4hOpr5 = (JSPUtil.getParameter(request, prefix	+ "stwg_4h_opr5", length));
			String[] stwg45Opr5 = (JSPUtil.getParameter(request, prefix	+ "stwg_45_opr5", length));
			
			String[] stwg20Tot = (JSPUtil.getParameter(request, prefix	+ "stwg_20_tot", length));
			String[] stwg2hTot = (JSPUtil.getParameter(request, prefix	+ "stwg_2h_tot", length));
			String[] stwg40Tot = (JSPUtil.getParameter(request, prefix	+ "stwg_40_tot", length));
			String[] stwg4hTot = (JSPUtil.getParameter(request, prefix	+ "stwg_4h_tot", length));
			String[] stwg45Tot = (JSPUtil.getParameter(request, prefix	+ "stwg_45_tot", length));
			
			String[] podYdCd = (JSPUtil.getParameter(request,   prefix  + "pod_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CBFSummaryVO();
				if (bb2hOpr10[i] != null)
					model.setBb2hOpr10(bb2hOpr10[i]);
				if (fm[i] != null)
					model.setFm(fm[i]);
				if (opr5Wgt4[i] != null)
					model.setOpr5Wgt4(opr5Wgt4[i]);
				if (opr5Wgt2[i] != null)
					model.setOpr5Wgt2(opr5Wgt2[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (opr8Wgt4h[i] != null)
					model.setOpr8Wgt4h(opr8Wgt4h[i]);
				if (opr10Wgt4[i] != null)
					model.setOpr10Wgt4(opr10Wgt4[i]);
				if (ak20Tot[i] != null)
					model.setAk20Tot(ak20Tot[i]);
				if (ak2hOpr10[i] != null)
					model.setAk2hOpr10(ak2hOpr10[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (ak40Opr10[i] != null)
					model.setAk40Opr10(ak40Opr10[i]);
				if (opr10Wgt2[i] != null)
					model.setOpr10Wgt2(opr10Wgt2[i]);
				if (opr8Wgt45[i] != null)
					model.setOpr8Wgt45(opr8Wgt45[i]);
				if (opr8Wgt2h[i] != null)
					model.setOpr8Wgt2h(opr8Wgt2h[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (opr3Wgt2[i] != null)
					model.setOpr3Wgt2(opr3Wgt2[i]);
				if (rf2hTot[i] != null)
					model.setRf2hTot(rf2hTot[i]);
				if (opr3Wgt4[i] != null)
					model.setOpr3Wgt4(opr3Wgt4[i]);
				if (opr2Wgt2[i] != null)
					model.setOpr2Wgt2(opr2Wgt2[i]);
				if (ak20Opr10[i] != null)
					model.setAk20Opr10(ak20Opr10[i]);
				if (opr5Teu[i] != null)
					model.setOpr5Teu(opr5Teu[i]);
				if (totWgt45[i] != null)
					model.setTotWgt45(totWgt45[i]);
				if (opr2Wgt4[i] != null)
					model.setOpr2Wgt4(opr2Wgt4[i]);
				if (totWgt2h[i] != null)
					model.setTotWgt2h(totWgt2h[i]);
				if (opr5Qty2[i] != null)
					model.setOpr5Qty2(opr5Qty2[i]);
				if (opr5Qty4[i] != null)
					model.setOpr5Qty4(opr5Qty4[i]);
				if (bb20Opr7[i] != null)
					model.setBb20Opr7(bb20Opr7[i]);
				if (opr3Teu[i] != null)
					model.setOpr3Teu(opr3Teu[i]);
				if (bb20Opr8[i] != null)
					model.setBb20Opr8(bb20Opr8[i]);
				if (opr6Qty4h[i] != null)
					model.setOpr6Qty4h(opr6Qty4h[i]);
				if (bb20Opr9[i] != null)
					model.setBb20Opr9(bb20Opr9[i]);
				if (bb20Opr3[i] != null)
					model.setBb20Opr3(bb20Opr3[i]);
				if (totWgt4h[i] != null)
					model.setTotWgt4h(totWgt4h[i]);
				if (bb20Opr4[i] != null)
					model.setBb20Opr4(bb20Opr4[i]);
				if (rf40Tot[i] != null)
					model.setRf40Tot(rf40Tot[i]);
				if (bb20Opr5[i] != null)
					model.setBb20Opr5(bb20Opr5[i]);
				if (bb20Opr6[i] != null)
					model.setBb20Opr6(bb20Opr6[i]);
				if (opr10Qty2h[i] != null)
					model.setOpr10Qty2h(opr10Qty2h[i]);
				if (opr2Wgt2h[i] != null)
					model.setOpr2Wgt2h(opr2Wgt2h[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (opr1Qty2[i] != null)
					model.setOpr1Qty2(opr1Qty2[i]);
				if (qty10[i] != null)
					model.setQty10(qty10[i]);
				if (opr1Qty4[i] != null)
					model.setOpr1Qty4(opr1Qty4[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dg45Opr8[i] != null)
					model.setDg45Opr8(dg45Opr8[i]);
				if (dg45Opr7[i] != null)
					model.setDg45Opr7(dg45Opr7[i]);
				if (dg45Opr6[i] != null)
					model.setDg45Opr6(dg45Opr6[i]);
				if (rf20Opr10[i] != null)
					model.setRf20Opr10(rf20Opr10[i]);
				if (dg45Opr5[i] != null)
					model.setDg45Opr5(dg45Opr5[i]);
				if (dg45Opr9[i] != null)
					model.setDg45Opr9(dg45Opr9[i]);
				if (bb20Opr2[i] != null)
					model.setBb20Opr2(bb20Opr2[i]);
				if (dg45Opr4[i] != null)
					model.setDg45Opr4(dg45Opr4[i]);
				if (bb20Opr1[i] != null)
					model.setBb20Opr1(bb20Opr1[i]);
				if (dg45Opr3[i] != null)
					model.setDg45Opr3(dg45Opr3[i]);
				if (dg45Opr2[i] != null)
					model.setDg45Opr2(dg45Opr2[i]);
				if (dg45Opr1[i] != null)
					model.setDg45Opr1(dg45Opr1[i]);
				if (dg40Tot[i] != null)
					model.setDg40Tot(dg40Tot[i]);
				if (opr6Qty2h[i] != null)
					model.setOpr6Qty2h(opr6Qty2h[i]);
				if (opr5Wgt4h[i] != null)
					model.setOpr5Wgt4h(opr5Wgt4h[i]);
				if (bb45Opr10[i] != null)
					model.setBb45Opr10(bb45Opr10[i]);
				if (dg40Opr10[i] != null)
					model.setDg40Opr10(dg40Opr10[i]);
				if (totTeu[i] != null)
					model.setTotTeu(totTeu[i]);
				if (stwgCgoFlg[i] != null)
					model.setStwgCgoFlg(stwgCgoFlg[i]);
				if (opr6Qty45[i] != null)
					model.setOpr6Qty45(opr6Qty45[i]);
				if (dg4hOpr10[i] != null)
					model.setDg4hOpr10(dg4hOpr10[i]);
				if (opr8Wgt2[i] != null)
					model.setOpr8Wgt2(opr8Wgt2[i]);
				if (opr8Wgt4[i] != null)
					model.setOpr8Wgt4(opr8Wgt4[i]);
				if (cbfIndFlg[i] != null)
					model.setCbfIndFlg(cbfIndFlg[i]);
				if (rf4hOpr3[i] != null)
					model.setRf4hOpr3(rf4hOpr3[i]);
				if (bb4hOpr9[i] != null)
					model.setBb4hOpr9(bb4hOpr9[i]);
				if (rf4hOpr4[i] != null)
					model.setRf4hOpr4(rf4hOpr4[i]);
				if (rf4hOpr1[i] != null)
					model.setRf4hOpr1(rf4hOpr1[i]);
				if (rf4hOpr2[i] != null)
					model.setRf4hOpr2(rf4hOpr2[i]);
				if (bb4hOpr5[i] != null)
					model.setBb4hOpr5(bb4hOpr5[i]);
				if (rf4hOpr7[i] != null)
					model.setRf4hOpr7(rf4hOpr7[i]);
				if (bb4hOpr6[i] != null)
					model.setBb4hOpr6(bb4hOpr6[i]);
				if (rf4hOpr8[i] != null)
					model.setRf4hOpr8(rf4hOpr8[i]);
				if (rf4hOpr5[i] != null)
					model.setRf4hOpr5(rf4hOpr5[i]);
				if (bb4hOpr7[i] != null)
					model.setBb4hOpr7(bb4hOpr7[i]);
				if (rf4hOpr6[i] != null)
					model.setRf4hOpr6(rf4hOpr6[i]);
				if (bb4hOpr8[i] != null)
					model.setBb4hOpr8(bb4hOpr8[i]);
				if (opr3Qty45[i] != null)
					model.setOpr3Qty45(opr3Qty45[i]);
				if (bb4hOpr1[i] != null)
					model.setBb4hOpr1(bb4hOpr1[i]);
				if (bb4hOpr2[i] != null)
					model.setBb4hOpr2(bb4hOpr2[i]);
				if (ak20Opr9[i] != null)
					model.setAk20Opr9(ak20Opr9[i]);
				if (opr4Wgt2h[i] != null)
					model.setOpr4Wgt2h(opr4Wgt2h[i]);
				if (bb4hOpr3[i] != null)
					model.setBb4hOpr3(bb4hOpr3[i]);
				if (bb4hOpr4[i] != null)
					model.setBb4hOpr4(bb4hOpr4[i]);
				if (opr9Qty2[i] != null)
					model.setOpr9Qty2(opr9Qty2[i]);
				if (opr9Qty4[i] != null)
					model.setOpr9Qty4(opr9Qty4[i]);
				if (ak20Opr1[i] != null)
					model.setAk20Opr1(ak20Opr1[i]);
				if (ak20Opr2[i] != null)
					model.setAk20Opr2(ak20Opr2[i]);
				if (ak20Opr3[i] != null)
					model.setAk20Opr3(ak20Opr3[i]);
				if (ak20Opr4[i] != null)
					model.setAk20Opr4(ak20Opr4[i]);
				if (ak20Opr5[i] != null)
					model.setAk20Opr5(ak20Opr5[i]);
				if (ak20Opr6[i] != null)
					model.setAk20Opr6(ak20Opr6[i]);
				if (opr3Qty2h[i] != null)
					model.setOpr3Qty2h(opr3Qty2h[i]);
				if (ak20Opr7[i] != null)
					model.setAk20Opr7(ak20Opr7[i]);
				if (ak20Opr8[i] != null)
					model.setAk20Opr8(ak20Opr8[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (opr4Qty4h[i] != null)
					model.setOpr4Qty4h(opr4Qty4h[i]);
				if (rf4hOpr9[i] != null)
					model.setRf4hOpr9(rf4hOpr9[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ak45Opr7[i] != null)
					model.setAk45Opr7(ak45Opr7[i]);
				if (ak45Opr6[i] != null)
					model.setAk45Opr6(ak45Opr6[i]);
				if (opr8Qty2h[i] != null)
					model.setOpr8Qty2h(opr8Qty2h[i]);
				if (ak45Opr9[i] != null)
					model.setAk45Opr9(ak45Opr9[i]);
				if (ak45Opr8[i] != null)
					model.setAk45Opr8(ak45Opr8[i]);
				if (totTtl[i] != null)
					model.setTotTtl(totTtl[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (opr8Qty45[i] != null)
					model.setOpr8Qty45(opr8Qty45[i]);
				if (ak45Opr1[i] != null)
					model.setAk45Opr1(ak45Opr1[i]);
				if (ak45Opr2[i] != null)
					model.setAk45Opr2(ak45Opr2[i]);
				if (ak45Opr3[i] != null)
					model.setAk45Opr3(ak45Opr3[i]);
				if (ak45Opr4[i] != null)
					model.setAk45Opr4(ak45Opr4[i]);
				if (ak45Opr5[i] != null)
					model.setAk45Opr5(ak45Opr5[i]);
				if (bb2hOpr9[i] != null)
					model.setBb2hOpr9(bb2hOpr9[i]);
				if (bb2hOpr8[i] != null)
					model.setBb2hOpr8(bb2hOpr8[i]);
				if (bb2hOpr7[i] != null)
					model.setBb2hOpr7(bb2hOpr7[i]);
				if (bb2hOpr6[i] != null)
					model.setBb2hOpr6(bb2hOpr6[i]);
				if (bb2hOpr5[i] != null)
					model.setBb2hOpr5(bb2hOpr5[i]);
				if (bb2hOpr4[i] != null)
					model.setBb2hOpr4(bb2hOpr4[i]);
				if (bb2hOpr3[i] != null)
					model.setBb2hOpr3(bb2hOpr3[i]);
				if (bb2hOpr2[i] != null)
					model.setBb2hOpr2(bb2hOpr2[i]);
				if (bb2hOpr1[i] != null)
					model.setBb2hOpr1(bb2hOpr1[i]);
				if (opr4Wgt4h[i] != null)
					model.setOpr4Wgt4h(opr4Wgt4h[i]);
				if (opr10Qty45[i] != null)
					model.setOpr10Qty45(opr10Qty45[i]);
				if (opr3Qty4h[i] != null)
					model.setOpr3Qty4h(opr3Qty4h[i]);
				if (opr6Wgt2[i] != null)
					model.setOpr6Wgt2(opr6Wgt2[i]);
				if (dg2hTot[i] != null)
					model.setDg2hTot(dg2hTot[i]);
				if (opr6Wgt4[i] != null)
					model.setOpr6Wgt4(opr6Wgt4[i]);
				if (ak45Tot[i] != null)
					model.setAk45Tot(ak45Tot[i]);
				if (rf4hTot[i] != null)
					model.setRf4hTot(rf4hTot[i]);
				if (opr10Qty4h[i] != null)
					model.setOpr10Qty4h(opr10Qty4h[i]);
				if (rf45Opr3[i] != null)
					model.setRf45Opr3(rf45Opr3[i]);
				if (rf45Opr2[i] != null)
					model.setRf45Opr2(rf45Opr2[i]);
				if (rf45Opr1[i] != null)
					model.setRf45Opr1(rf45Opr1[i]);
				if (opr4Wgt45[i] != null)
					model.setOpr4Wgt45(opr4Wgt45[i]);
				if (rf45Opr7[i] != null)
					model.setRf45Opr7(rf45Opr7[i]);
				if (rf45Opr6[i] != null)
					model.setRf45Opr6(rf45Opr6[i]);
				if (rf45Opr5[i] != null)
					model.setRf45Opr5(rf45Opr5[i]);
				if (bb40Opr9[i] != null)
					model.setBb40Opr9(bb40Opr9[i]);
				if (rf45Opr4[i] != null)
					model.setRf45Opr4(rf45Opr4[i]);
				if (bb40Opr7[i] != null)
					model.setBb40Opr7(bb40Opr7[i]);
				if (bb40Opr8[i] != null)
					model.setBb40Opr8(bb40Opr8[i]);
				if (bb40Opr5[i] != null)
					model.setBb40Opr5(bb40Opr5[i]);
				if (rf45Opr9[i] != null)
					model.setRf45Opr9(rf45Opr9[i]);
				if (bb40Opr6[i] != null)
					model.setBb40Opr6(bb40Opr6[i]);
				if (rf45Opr8[i] != null)
					model.setRf45Opr8(rf45Opr8[i]);
				if (totQty2h[i] != null)
					model.setTotQty2h(totQty2h[i]);
				if (opr1Qty4h[i] != null)
					model.setOpr1Qty4h(opr1Qty4h[i]);
				if (rf40Opr1[i] != null)
					model.setRf40Opr1(rf40Opr1[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (rf40Opr2[i] != null)
					model.setRf40Opr2(rf40Opr2[i]);
				if (rf40Opr3[i] != null)
					model.setRf40Opr3(rf40Opr3[i]);
				if (rf40Opr4[i] != null)
					model.setRf40Opr4(rf40Opr4[i]);
				if (rf40Opr5[i] != null)
					model.setRf40Opr5(rf40Opr5[i]);
				if (rf40Opr6[i] != null)
					model.setRf40Opr6(rf40Opr6[i]);
				if (dg20Tot[i] != null)
					model.setDg20Tot(dg20Tot[i]);
				if (rf40Opr7[i] != null)
					model.setRf40Opr7(rf40Opr7[i]);
				if (rf40Opr8[i] != null)
					model.setRf40Opr8(rf40Opr8[i]);
				if (rf40Opr9[i] != null)
					model.setRf40Opr9(rf40Opr9[i]);
				if (bb40Opr1[i] != null)
					model.setBb40Opr1(bb40Opr1[i]);
				if (totQty45[i] != null)
					model.setTotQty45(totQty45[i]);
				if (bb40Opr2[i] != null)
					model.setBb40Opr2(bb40Opr2[i]);
				if (bb40Opr3[i] != null)
					model.setBb40Opr3(bb40Opr3[i]);
				if (bb40Opr4[i] != null)
					model.setBb40Opr4(bb40Opr4[i]);
				if (bb40Tot[i] != null)
					model.setBb40Tot(bb40Tot[i]);
				if (opr7Qty2h[i] != null)
					model.setOpr7Qty2h(opr7Qty2h[i]);
				if (bb20Opr10[i] != null)
					model.setBb20Opr10(bb20Opr10[i]);
				if (opr7Qty45[i] != null)
					model.setOpr7Qty45(opr7Qty45[i]);
				if (rf45Opr10[i] != null)
					model.setRf45Opr10(rf45Opr10[i]);
				if (bb20Tot[i] != null)
					model.setBb20Tot(bb20Tot[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (totQty2[i] != null)
					model.setTotQty2(totQty2[i]);
				if (totQty4[i] != null)
					model.setTotQty4(totQty4[i]);
				if (opr8Qty4h[i] != null)
					model.setOpr8Qty4h(opr8Qty4h[i]);
				if (bkgShprOwnrFlg[i] != null)
					model.setBkgShprOwnrFlg(bkgShprOwnrFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (opr7Qty4h[i] != null)
					model.setOpr7Qty4h(opr7Qty4h[i]);
				if (rf40Opr10[i] != null)
					model.setRf40Opr10(rf40Opr10[i]);
				if (pcCgoFlg[i] != null)
					model.setPcCgoFlg(pcCgoFlg[i]);
				if (ak45Opr10[i] != null)
					model.setAk45Opr10(ak45Opr10[i]);
				if (opr10Teu[i] != null)
					model.setOpr10Teu(opr10Teu[i]);
				if (opr1Wgt2h[i] != null)
					model.setOpr1Wgt2h(opr1Wgt2h[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (opr7Wgt45[i] != null)
					model.setOpr7Wgt45(opr7Wgt45[i]);
				if (ak4hOpr2[i] != null)
					model.setAk4hOpr2(ak4hOpr2[i]);
				if (ak4hOpr1[i] != null)
					model.setAk4hOpr1(ak4hOpr1[i]);
				if (opr10Wgt4h[i] != null)
					model.setOpr10Wgt4h(opr10Wgt4h[i]);
				if (opr7Wgt2h[i] != null)
					model.setOpr7Wgt2h(opr7Wgt2h[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (dg45Opr10[i] != null)
					model.setDg45Opr10(dg45Opr10[i]);
				if (wg[i] != null)
					model.setWg(wg[i]);
				if (opr10Qty4[i] != null)
					model.setOpr10Qty4(opr10Qty4[i]);
				if (opr10Qty2[i] != null)
					model.setOpr10Qty2(opr10Qty2[i]);
				if (bb4hOpr10[i] != null)
					model.setBb4hOpr10(bb4hOpr10[i]);
				if (ak4hOpr5[i] != null)
					model.setAk4hOpr5(ak4hOpr5[i]);
				if (ak4hOpr6[i] != null)
					model.setAk4hOpr6(ak4hOpr6[i]);
				if (ak4hOpr3[i] != null)
					model.setAk4hOpr3(ak4hOpr3[i]);
				if (crrCd2[i] != null)
					model.setCrrCd2(crrCd2[i]);
				if (ak4hOpr4[i] != null)
					model.setAk4hOpr4(ak4hOpr4[i]);
				if (ak4hOpr9[i] != null)
					model.setAk4hOpr9(ak4hOpr9[i]);
				if (ak4hOpr7[i] != null)
					model.setAk4hOpr7(ak4hOpr7[i]);
				if (opr1Qty45[i] != null)
					model.setOpr1Qty45(opr1Qty45[i]);
				if (ak4hOpr8[i] != null)
					model.setAk4hOpr8(ak4hOpr8[i]);
				if (opr8Teu[i] != null)
					model.setOpr8Teu(opr8Teu[i]);
				if (opr10[i] != null)
					model.setOpr10(opr10[i]);
				if (opr1Qty2h[i] != null)
					model.setOpr1Qty2h(opr1Qty2h[i]);
				if (opr1Wgt45[i] != null)
					model.setOpr1Wgt45(opr1Wgt45[i]);
				if (sort[i] != null)
					model.setSort(sort[i]);
				if (opr1Teu[i] != null)
					model.setOpr1Teu(opr1Teu[i]);
				if (rf45Tot[i] != null)
					model.setRf45Tot(rf45Tot[i]);
				if (opr7Wgt4h[i] != null)
					model.setOpr7Wgt4h(opr7Wgt4h[i]);
				if (opr4Qty2[i] != null)
					model.setOpr4Qty2(opr4Qty2[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (totQty4h[i] != null)
					model.setTotQty4h(totQty4h[i]);
				if (bb40Opr10[i] != null)
					model.setBb40Opr10(bb40Opr10[i]);
				if (opr2Qty4[i] != null)
					model.setOpr2Qty4(opr2Qty4[i]);
				if (opr2Qty2[i] != null)
					model.setOpr2Qty2(opr2Qty2[i]);
				if (opr9Wgt2[i] != null)
					model.setOpr9Wgt2(opr9Wgt2[i]);
				if (stwgNm[i] != null)
					model.setStwgNm(stwgNm[i]);
				if (opr9Wgt4[i] != null)
					model.setOpr9Wgt4(opr9Wgt4[i]);
				if (opr1Wgt4[i] != null)
					model.setOpr1Wgt4(opr1Wgt4[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (opr1Wgt2[i] != null)
					model.setOpr1Wgt2(opr1Wgt2[i]);
				if (opr7Wgt4[i] != null)
					model.setOpr7Wgt4(opr7Wgt4[i]);
				if (opr7Wgt2[i] != null)
					model.setOpr7Wgt2(opr7Wgt2[i]);
				if (opr8Qty4[i] != null)
					model.setOpr8Qty4(opr8Qty4[i]);
				if (opr8Qty2[i] != null)
					model.setOpr8Qty2(opr8Qty2[i]);
				if (opr4Qty4[i] != null)
					model.setOpr4Qty4(opr4Qty4[i]);
				if (opr9Qty2h[i] != null)
					model.setOpr9Qty2h(opr9Qty2h[i]);
				if (opr7Teu[i] != null)
					model.setOpr7Teu(opr7Teu[i]);
				if (opr9Qty45[i] != null)
					model.setOpr9Qty45(opr9Qty45[i]);
				if (unit2[i] != null)
					model.setUnit2(unit2[i]);
				if (unit4[i] != null)
					model.setUnit4(unit4[i]);
				if (opr6Teu[i] != null)
					model.setOpr6Teu(opr6Teu[i]);
				if (opr4Teu[i] != null)
					model.setOpr4Teu(opr4Teu[i]);
				if (opr3Qty4[i] != null)
					model.setOpr3Qty4(opr3Qty4[i]);
				if (opr1Wgt4h[i] != null)
					model.setOpr1Wgt4h(opr1Wgt4h[i]);
				if (opr10Wgt45[i] != null)
					model.setOpr10Wgt45(opr10Wgt45[i]);
				if (opr10Wgt2h[i] != null)
					model.setOpr10Wgt2h(opr10Wgt2h[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (opr7[i] != null)
					model.setOpr7(opr7[i]);
				if (opr8[i] != null)
					model.setOpr8(opr8[i]);
				if (opr5[i] != null)
					model.setOpr5(opr5[i]);
				if (opr6[i] != null)
					model.setOpr6(opr6[i]);
				if (opr3[i] != null)
					model.setOpr3(opr3[i]);
				if (opr4[i] != null)
					model.setOpr4(opr4[i]);
				if (opr1[i] != null)
					model.setOpr1(opr1[i]);
				if (opr2[i] != null)
					model.setOpr2(opr2[i]);
				if (opr4Wgt4[i] != null)
					model.setOpr4Wgt4(opr4Wgt4[i]);
				if (opr4Wgt2[i] != null)
					model.setOpr4Wgt2(opr4Wgt2[i]);
				if (opr4Qty2h[i] != null)
					model.setOpr4Qty2h(opr4Qty2h[i]);
				if (opr9[i] != null)
					model.setOpr9(opr9[i]);
				if (opr4Qty45[i] != null)
					model.setOpr4Qty45(opr4Qty45[i]);
				if (rf2hOpr2[i] != null)
					model.setRf2hOpr2(rf2hOpr2[i]);
				if (opr6Qty4[i] != null)
					model.setOpr6Qty4(opr6Qty4[i]);
				if (rf2hOpr1[i] != null)
					model.setRf2hOpr1(rf2hOpr1[i]);
				if (opr6Qty2[i] != null)
					model.setOpr6Qty2(opr6Qty2[i]);
				if (opr5Qty2h[i] != null)
					model.setOpr5Qty2h(opr5Qty2h[i]);
				if (rf2hOpr6[i] != null)
					model.setRf2hOpr6(rf2hOpr6[i]);
				if (opr2Qty2h[i] != null)
					model.setOpr2Qty2h(opr2Qty2h[i]);
				if (rf2hOpr5[i] != null)
					model.setRf2hOpr5(rf2hOpr5[i]);
				if (rf2hOpr4[i] != null)
					model.setRf2hOpr4(rf2hOpr4[i]);
				if (rf4hOpr10[i] != null)
					model.setRf4hOpr10(rf4hOpr10[i]);
				if (rf2hOpr3[i] != null)
					model.setRf2hOpr3(rf2hOpr3[i]);
				if (rf20Opr8[i] != null)
					model.setRf20Opr8(rf20Opr8[i]);
				if (rf20Opr7[i] != null)
					model.setRf20Opr7(rf20Opr7[i]);
				if (rf20Opr9[i] != null)
					model.setRf20Opr9(rf20Opr9[i]);
				if (rf20Opr4[i] != null)
					model.setRf20Opr4(rf20Opr4[i]);
				if (dg40Opr5[i] != null)
					model.setDg40Opr5(dg40Opr5[i]);
				if (rf2hOpr9[i] != null)
					model.setRf2hOpr9(rf2hOpr9[i]);
				if (ak4hTot[i] != null)
					model.setAk4hTot(ak4hTot[i]);
				if (opr2Qty45[i] != null)
					model.setOpr2Qty45(opr2Qty45[i]);
				if (rf20Opr3[i] != null)
					model.setRf20Opr3(rf20Opr3[i]);
				if (dg40Opr4[i] != null)
					model.setDg40Opr4(dg40Opr4[i]);
				if (qty1[i] != null)
					model.setQty1(qty1[i]);
				if (dg40Opr3[i] != null)
					model.setDg40Opr3(dg40Opr3[i]);
				if (rf20Opr6[i] != null)
					model.setRf20Opr6(rf20Opr6[i]);
				if (rf2hOpr7[i] != null)
					model.setRf2hOpr7(rf2hOpr7[i]);
				if (dg40Opr2[i] != null)
					model.setDg40Opr2(dg40Opr2[i]);
				if (rf20Opr5[i] != null)
					model.setRf20Opr5(rf20Opr5[i]);
				if (rf2hOpr8[i] != null)
					model.setRf2hOpr8(rf2hOpr8[i]);
				if (qty3[i] != null)
					model.setQty3(qty3[i]);
				if (dg40Opr9[i] != null)
					model.setDg40Opr9(dg40Opr9[i]);
				if (qty2[i] != null)
					model.setQty2(qty2[i]);
				if (dg40Opr8[i] != null)
					model.setDg40Opr8(dg40Opr8[i]);
				if (opr5Qty45[i] != null)
					model.setOpr5Qty45(opr5Qty45[i]);
				if (qty5[i] != null)
					model.setQty5(qty5[i]);
				if (rf20Opr2[i] != null)
					model.setRf20Opr2(rf20Opr2[i]);
				if (dg40Opr7[i] != null)
					model.setDg40Opr7(dg40Opr7[i]);
				if (qty4[i] != null)
					model.setQty4(qty4[i]);
				if (rf20Opr1[i] != null)
					model.setRf20Opr1(rf20Opr1[i]);
				if (dg40Opr6[i] != null)
					model.setDg40Opr6(dg40Opr6[i]);
				if (opr9Wgt45[i] != null)
					model.setOpr9Wgt45(opr9Wgt45[i]);
				if (dg4hOpr1[i] != null)
					model.setDg4hOpr1(dg4hOpr1[i]);
				if (opr3Qty2[i] != null)
					model.setOpr3Qty2(opr3Qty2[i]);
				if (dg4hOpr7[i] != null)
					model.setDg4hOpr7(dg4hOpr7[i]);
				if (dg4hOpr6[i] != null)
					model.setDg4hOpr6(dg4hOpr6[i]);
				if (dg4hOpr9[i] != null)
					model.setDg4hOpr9(dg4hOpr9[i]);
				if (dg4hOpr8[i] != null)
					model.setDg4hOpr8(dg4hOpr8[i]);
				if (dg4hOpr3[i] != null)
					model.setDg4hOpr3(dg4hOpr3[i]);
				if (opr2Teu[i] != null)
					model.setOpr2Teu(opr2Teu[i]);
				if (dg4hOpr2[i] != null)
					model.setDg4hOpr2(dg4hOpr2[i]);
				if (opr9Wgt2h[i] != null)
					model.setOpr9Wgt2h(opr9Wgt2h[i]);
				if (dg4hOpr5[i] != null)
					model.setDg4hOpr5(dg4hOpr5[i]);
				if (dg4hOpr4[i] != null)
					model.setDg4hOpr4(dg4hOpr4[i]);
				if (ak4hOpr10[i] != null)
					model.setAk4hOpr10(ak4hOpr10[i]);
				if (dg20Opr10[i] != null)
					model.setDg20Opr10(dg20Opr10[i]);
				if (opr2Qty4h[i] != null)
					model.setOpr2Qty4h(opr2Qty4h[i]);
				if (opr2Wgt4h[i] != null)
					model.setOpr2Wgt4h(opr2Wgt4h[i]);
				if (opr7Qty4[i] != null)
					model.setOpr7Qty4(opr7Qty4[i]);
				if (opr7Qty2[i] != null)
					model.setOpr7Qty2(opr7Qty2[i]);
				if (dg20Opr1[i] != null)
					model.setDg20Opr1(dg20Opr1[i]);
				if (dg20Opr3[i] != null)
					model.setDg20Opr3(dg20Opr3[i]);
				if (dg20Opr2[i] != null)
					model.setDg20Opr2(dg20Opr2[i]);
				if (dg2hOpr10[i] != null)
					model.setDg2hOpr10(dg2hOpr10[i]);
				if (dg20Opr5[i] != null)
					model.setDg20Opr5(dg20Opr5[i]);
				if (dg20Opr4[i] != null)
					model.setDg20Opr4(dg20Opr4[i]);
				if (dg20Opr7[i] != null)
					model.setDg20Opr7(dg20Opr7[i]);
				if (dg20Opr6[i] != null)
					model.setDg20Opr6(dg20Opr6[i]);
				if (dg20Opr9[i] != null)
					model.setDg20Opr9(dg20Opr9[i]);
				if (dg20Opr8[i] != null)
					model.setDg20Opr8(dg20Opr8[i]);
				if (dg4hTot[i] != null)
					model.setDg4hTot(dg4hTot[i]);
				if (qty8[i] != null)
					model.setQty8(qty8[i]);
				if (qty9[i] != null)
					model.setQty9(qty9[i]);
				if (qty6[i] != null)
					model.setQty6(qty6[i]);
				if (qty7[i] != null)
					model.setQty7(qty7[i]);
				if (dg2hOpr4[i] != null)
					model.setDg2hOpr4(dg2hOpr4[i]);
				if (dg2hOpr5[i] != null)
					model.setDg2hOpr5(dg2hOpr5[i]);
				if (dg2hOpr6[i] != null)
					model.setDg2hOpr6(dg2hOpr6[i]);
				if (dg2hOpr7[i] != null)
					model.setDg2hOpr7(dg2hOpr7[i]);
				if (opr2Wgt45[i] != null)
					model.setOpr2Wgt45(opr2Wgt45[i]);
				if (dg2hOpr1[i] != null)
					model.setDg2hOpr1(dg2hOpr1[i]);
				if (dg2hOpr2[i] != null)
					model.setDg2hOpr2(dg2hOpr2[i]);
				if (dg2hOpr3[i] != null)
					model.setDg2hOpr3(dg2hOpr3[i]);
				if (opr9Qty4h[i] != null)
					model.setOpr9Qty4h(opr9Qty4h[i]);
				if (opr6Wgt2h[i] != null)
					model.setOpr6Wgt2h(opr6Wgt2h[i]);
				if (opr6Wgt45[i] != null)
					model.setOpr6Wgt45(opr6Wgt45[i]);
				if (dg2hOpr8[i] != null)
					model.setDg2hOpr8(dg2hOpr8[i]);
				if (dg2hOpr9[i] != null)
					model.setDg2hOpr9(dg2hOpr9[i]);
				if (rf20Tot[i] != null)
					model.setRf20Tot(rf20Tot[i]);
				if (totWgt2[i] != null)
					model.setTotWgt2(totWgt2[i]);
				if (opr3Wgt2h[i] != null)
					model.setOpr3Wgt2h(opr3Wgt2h[i]);
				if (totWgt4[i] != null)
					model.setTotWgt4(totWgt4[i]);
				if (mlb[i] != null)
					model.setMlb(mlb[i]);
				if (bb45Opr1[i] != null)
					model.setBb45Opr1(bb45Opr1[i]);
				if (opr3Wgt45[i] != null)
					model.setOpr3Wgt45(opr3Wgt45[i]);
				if (bb45Opr3[i] != null)
					model.setBb45Opr3(bb45Opr3[i]);
				if (bb45Opr2[i] != null)
					model.setBb45Opr2(bb45Opr2[i]);
				if (bb45Opr5[i] != null)
					model.setBb45Opr5(bb45Opr5[i]);
				if (bb45Opr4[i] != null)
					model.setBb45Opr4(bb45Opr4[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (bb45Opr7[i] != null)
					model.setBb45Opr7(bb45Opr7[i]);
				if (bb45Opr6[i] != null)
					model.setBb45Opr6(bb45Opr6[i]);
				if (bb45Opr9[i] != null)
					model.setBb45Opr9(bb45Opr9[i]);
				if (bb45Opr8[i] != null)
					model.setBb45Opr8(bb45Opr8[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (opr6Wgt4h[i] != null)
					model.setOpr6Wgt4h(opr6Wgt4h[i]);
				if (avWgt2[i] != null)
					model.setAvWgt2(avWgt2[i]);
				if (avWgt4[i] != null)
					model.setAvWgt4(avWgt4[i]);
				if (ak40Tot[i] != null)
					model.setAk40Tot(ak40Tot[i]);
				if (ak40Opr7[i] != null)
					model.setAk40Opr7(ak40Opr7[i]);
				if (ak40Opr8[i] != null)
					model.setAk40Opr8(ak40Opr8[i]);
				if (rf2hOpr10[i] != null)
					model.setRf2hOpr10(rf2hOpr10[i]);
				if (ak40Opr9[i] != null)
					model.setAk40Opr9(ak40Opr9[i]);
				if (opr5Wgt2h[i] != null)
					model.setOpr5Wgt2h(opr5Wgt2h[i]);
				if (ak40Opr3[i] != null)
					model.setAk40Opr3(ak40Opr3[i]);
				if (ak40Opr4[i] != null)
					model.setAk40Opr4(ak40Opr4[i]);
				if (ak40Opr5[i] != null)
					model.setAk40Opr5(ak40Opr5[i]);
				if (opr5Qty4h[i] != null)
					model.setOpr5Qty4h(opr5Qty4h[i]);
				if (ak40Opr6[i] != null)
					model.setAk40Opr6(ak40Opr6[i]);
				if (ak40Opr1[i] != null)
					model.setAk40Opr1(ak40Opr1[i]);
				if (ak40Opr2[i] != null)
					model.setAk40Opr2(ak40Opr2[i]);
				if (opr3Wgt4h[i] != null)
					model.setOpr3Wgt4h(opr3Wgt4h[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (opr9Teu[i] != null)
					model.setOpr9Teu(opr9Teu[i]);
				if (mlbCd[i] != null)
					model.setMlbCd(mlbCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (opr9Wgt4h[i] != null)
					model.setOpr9Wgt4h(opr9Wgt4h[i]);
				if (dg40Opr1[i] != null)
					model.setDg40Opr1(dg40Opr1[i]);
				if (opr5Wgt45[i] != null)
					model.setOpr5Wgt45(opr5Wgt45[i]);
				if (ak2hOpr2[i] != null)
					model.setAk2hOpr2(ak2hOpr2[i]);
				if (ak2hOpr1[i] != null)
					model.setAk2hOpr1(ak2hOpr1[i]);
				if (ak2hOpr4[i] != null)
					model.setAk2hOpr4(ak2hOpr4[i]);
				if (ak2hOpr3[i] != null)
					model.setAk2hOpr3(ak2hOpr3[i]);
				if (ak2hOpr6[i] != null)
					model.setAk2hOpr6(ak2hOpr6[i]);
				if (ak2hOpr5[i] != null)
					model.setAk2hOpr5(ak2hOpr5[i]);
				if (ak2hOpr8[i] != null)
					model.setAk2hOpr8(ak2hOpr8[i]);
				if (ak2hOpr7[i] != null)
					model.setAk2hOpr7(ak2hOpr7[i]);
				if (ak2hOpr9[i] != null)
					model.setAk2hOpr9(ak2hOpr9[i]);
				if (dg45Tot[i] != null)
					model.setDg45Tot(dg45Tot[i]);
				
				if (stwg20Opr1[i] != null)
					model.setStwg20Opr1(stwg20Opr1[i]);
				if (stwg2hOpr1[i] != null)
					model.setStwg2hOpr1(stwg2hOpr1[i]);
				if (stwg40Opr1[i] != null)
					model.setStwg40Opr1(stwg40Opr1[i]);
				if (stwg4hOpr1[i] != null)
					model.setStwg4hOpr1(stwg4hOpr1[i]);
				if (stwg45Opr1[i] != null)
					model.setStwg45Opr1(stwg45Opr1[i]);
				
				if (stwg20Opr2[i] != null)
					model.setStwg20Opr2(stwg20Opr2[i]);
				if (stwg2hOpr2[i] != null)
					model.setStwg2hOpr2(stwg2hOpr2[i]);
				if (stwg40Opr2[i] != null)
					model.setStwg40Opr2(stwg40Opr2[i]);
				if (stwg4hOpr2[i] != null)
					model.setStwg4hOpr2(stwg4hOpr2[i]);
				if (stwg45Opr2[i] != null)
					model.setStwg45Opr2(stwg45Opr2[i]);
				
				if (stwg20Opr3[i] != null)
					model.setStwg20Opr3(stwg20Opr3[i]);
				if (stwg2hOpr3[i] != null)
					model.setStwg2hOpr3(stwg2hOpr3[i]);
				if (stwg40Opr3[i] != null)
					model.setStwg40Opr3(stwg40Opr3[i]);
				if (stwg4hOpr3[i] != null)
					model.setStwg4hOpr3(stwg4hOpr3[i]);
				if (stwg45Opr3[i] != null)
					model.setStwg45Opr3(stwg45Opr3[i]);
				
				if (stwg20Opr4[i] != null)
					model.setStwg20Opr4(stwg20Opr4[i]);
				if (stwg2hOpr4[i] != null)
					model.setStwg2hOpr4(stwg2hOpr4[i]);
				if (stwg40Opr4[i] != null)
					model.setStwg40Opr4(stwg40Opr4[i]);
				if (stwg4hOpr4[i] != null)
					model.setStwg4hOpr4(stwg4hOpr4[i]);
				if (stwg45Opr4[i] != null)
					model.setStwg45Opr4(stwg45Opr4[i]);
				
				if (stwg20Opr5[i] != null)
					model.setStwg20Opr5(stwg20Opr5[i]);
				if (stwg2hOpr5[i] != null)
					model.setStwg2hOpr5(stwg2hOpr5[i]);
				if (stwg40Opr5[i] != null)
					model.setStwg40Opr5(stwg40Opr5[i]);
				if (stwg4hOpr5[i] != null)
					model.setStwg4hOpr5(stwg4hOpr5[i]);
				if (stwg45Opr5[i] != null)
					model.setStwg45Opr5(stwg45Opr5[i]);
				
				if (stwg20Tot[i] != null)
					model.setStwg20Tot(stwg20Tot[i]);
				if (stwg2hTot[i] != null)
					model.setStwg2hTot(stwg2hTot[i]);
				if (stwg40Tot[i] != null)
					model.setStwg40Tot(stwg40Tot[i]);
				if (stwg4hTot[i] != null)
					model.setStwg4hTot(stwg4hTot[i]);
				if (stwg45Tot[i] != null)
					model.setStwg45Tot(stwg45Tot[i]);
				
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCBFSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CBFSummaryVO[]
	 */
	public CBFSummaryVO[] getCBFSummaryVOs(){
		CBFSummaryVO[] vos = (CBFSummaryVO[])models.toArray(new CBFSummaryVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bb2hOpr10 = this.bb2hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm = this.fm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr5Wgt4 = this.opr5Wgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr5Wgt2 = this.opr5Wgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr8Wgt4h = this.opr8Wgt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr10Wgt4 = this.opr10Wgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak20Tot = this.ak20Tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak2hOpr10 = this.ak2hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40Opr10 = this.ak40Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr10Wgt2 = this.opr10Wgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr8Wgt45 = this.opr8Wgt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr8Wgt2h = this.opr8Wgt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr3Wgt2 = this.opr3Wgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf2hTot = this.rf2hTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr3Wgt4 = this.opr3Wgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr2Wgt2 = this.opr2Wgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak20Opr10 = this.ak20Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr5Teu = this.opr5Teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totWgt45 = this.totWgt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr2Wgt4 = this.opr2Wgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totWgt2h = this.totWgt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr5Qty2 = this.opr5Qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr5Qty4 = this.opr5Qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb20Opr7 = this.bb20Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr3Teu = this.opr3Teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb20Opr8 = this.bb20Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr6Qty4h = this.opr6Qty4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb20Opr9 = this.bb20Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb20Opr3 = this.bb20Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totWgt4h = this.totWgt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb20Opr4 = this.bb20Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Tot = this.rf40Tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb20Opr5 = this.bb20Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb20Opr6 = this.bb20Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr10Qty2h = this.opr10Qty2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr2Wgt2h = this.opr2Wgt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr1Qty2 = this.opr1Qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty10 = this.qty10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr1Qty4 = this.opr1Qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg45Opr8 = this.dg45Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg45Opr7 = this.dg45Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg45Opr6 = this.dg45Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Opr10 = this.rf20Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg45Opr5 = this.dg45Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg45Opr9 = this.dg45Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb20Opr2 = this.bb20Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg45Opr4 = this.dg45Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb20Opr1 = this.bb20Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg45Opr3 = this.dg45Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg45Opr2 = this.dg45Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg45Opr1 = this.dg45Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40Tot = this.dg40Tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr6Qty2h = this.opr6Qty2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr5Wgt4h = this.opr5Wgt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb45Opr10 = this.bb45Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40Opr10 = this.dg40Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTeu = this.totTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCgoFlg = this.stwgCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr6Qty45 = this.opr6Qty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg4hOpr10 = this.dg4hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr8Wgt2 = this.opr8Wgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr8Wgt4 = this.opr8Wgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbfIndFlg = this.cbfIndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf4hOpr3 = this.rf4hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb4hOpr9 = this.bb4hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf4hOpr4 = this.rf4hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf4hOpr1 = this.rf4hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf4hOpr2 = this.rf4hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb4hOpr5 = this.bb4hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf4hOpr7 = this.rf4hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb4hOpr6 = this.bb4hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf4hOpr8 = this.rf4hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf4hOpr5 = this.rf4hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb4hOpr7 = this.bb4hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf4hOpr6 = this.rf4hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb4hOpr8 = this.bb4hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr3Qty45 = this.opr3Qty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb4hOpr1 = this.bb4hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb4hOpr2 = this.bb4hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak20Opr9 = this.ak20Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr4Wgt2h = this.opr4Wgt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb4hOpr3 = this.bb4hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb4hOpr4 = this.bb4hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr9Qty2 = this.opr9Qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr9Qty4 = this.opr9Qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak20Opr1 = this.ak20Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak20Opr2 = this.ak20Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak20Opr3 = this.ak20Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak20Opr4 = this.ak20Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak20Opr5 = this.ak20Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak20Opr6 = this.ak20Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr3Qty2h = this.opr3Qty2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak20Opr7 = this.ak20Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak20Opr8 = this.ak20Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr4Qty4h = this.opr4Qty4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf4hOpr9 = this.rf4hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak45Opr7 = this.ak45Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak45Opr6 = this.ak45Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr8Qty2h = this.opr8Qty2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak45Opr9 = this.ak45Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak45Opr8 = this.ak45Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totTtl = this.totTtl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr8Qty45 = this.opr8Qty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak45Opr1 = this.ak45Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak45Opr2 = this.ak45Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak45Opr3 = this.ak45Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak45Opr4 = this.ak45Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak45Opr5 = this.ak45Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb2hOpr9 = this.bb2hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb2hOpr8 = this.bb2hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb2hOpr7 = this.bb2hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb2hOpr6 = this.bb2hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb2hOpr5 = this.bb2hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb2hOpr4 = this.bb2hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb2hOpr3 = this.bb2hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb2hOpr2 = this.bb2hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb2hOpr1 = this.bb2hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr4Wgt4h = this.opr4Wgt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr10Qty45 = this.opr10Qty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr3Qty4h = this.opr3Qty4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr6Wgt2 = this.opr6Wgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg2hTot = this.dg2hTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr6Wgt4 = this.opr6Wgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak45Tot = this.ak45Tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf4hTot = this.rf4hTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr10Qty4h = this.opr10Qty4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf45Opr3 = this.rf45Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf45Opr2 = this.rf45Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf45Opr1 = this.rf45Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr4Wgt45 = this.opr4Wgt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf45Opr7 = this.rf45Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf45Opr6 = this.rf45Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf45Opr5 = this.rf45Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb40Opr9 = this.bb40Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf45Opr4 = this.rf45Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb40Opr7 = this.bb40Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb40Opr8 = this.bb40Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb40Opr5 = this.bb40Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf45Opr9 = this.rf45Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb40Opr6 = this.bb40Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf45Opr8 = this.rf45Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totQty2h = this.totQty2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr1Qty4h = this.opr1Qty4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Opr1 = this.rf40Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Opr2 = this.rf40Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Opr3 = this.rf40Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Opr4 = this.rf40Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Opr5 = this.rf40Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Opr6 = this.rf40Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20Tot = this.dg20Tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Opr7 = this.rf40Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Opr8 = this.rf40Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Opr9 = this.rf40Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb40Opr1 = this.bb40Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totQty45 = this.totQty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb40Opr2 = this.bb40Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb40Opr3 = this.bb40Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb40Opr4 = this.bb40Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb40Tot = this.bb40Tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr7Qty2h = this.opr7Qty2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb20Opr10 = this.bb20Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr7Qty45 = this.opr7Qty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf45Opr10 = this.rf45Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb20Tot = this.bb20Tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totQty2 = this.totQty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totQty4 = this.totQty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr8Qty4h = this.opr8Qty4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgShprOwnrFlg = this.bkgShprOwnrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr7Qty4h = this.opr7Qty4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Opr10 = this.rf40Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pcCgoFlg = this.pcCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak45Opr10 = this.ak45Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr10Teu = this.opr10Teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr1Wgt2h = this.opr1Wgt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr7Wgt45 = this.opr7Wgt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak4hOpr2 = this.ak4hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak4hOpr1 = this.ak4hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr10Wgt4h = this.opr10Wgt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr7Wgt2h = this.opr7Wgt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg45Opr10 = this.dg45Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wg = this.wg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr10Qty4 = this.opr10Qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr10Qty2 = this.opr10Qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb4hOpr10 = this.bb4hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak4hOpr5 = this.ak4hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak4hOpr6 = this.ak4hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak4hOpr3 = this.ak4hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd2 = this.crrCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak4hOpr4 = this.ak4hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak4hOpr9 = this.ak4hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak4hOpr7 = this.ak4hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr1Qty45 = this.opr1Qty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak4hOpr8 = this.ak4hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr8Teu = this.opr8Teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr10 = this.opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr1Qty2h = this.opr1Qty2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr1Wgt45 = this.opr1Wgt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sort = this.sort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr1Teu = this.opr1Teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf45Tot = this.rf45Tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr7Wgt4h = this.opr7Wgt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr4Qty2 = this.opr4Qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totQty4h = this.totQty4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb40Opr10 = this.bb40Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr2Qty4 = this.opr2Qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr2Qty2 = this.opr2Qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr9Wgt2 = this.opr9Wgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgNm = this.stwgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr9Wgt4 = this.opr9Wgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr1Wgt4 = this.opr1Wgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr1Wgt2 = this.opr1Wgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr7Wgt4 = this.opr7Wgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr7Wgt2 = this.opr7Wgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr8Qty4 = this.opr8Qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr8Qty2 = this.opr8Qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr4Qty4 = this.opr4Qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr9Qty2h = this.opr9Qty2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr7Teu = this.opr7Teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr9Qty45 = this.opr9Qty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit2 = this.unit2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit4 = this.unit4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr6Teu = this.opr6Teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr4Teu = this.opr4Teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr3Qty4 = this.opr3Qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr1Wgt4h = this.opr1Wgt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr10Wgt45 = this.opr10Wgt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr10Wgt2h = this.opr10Wgt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr7 = this.opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr8 = this.opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr5 = this.opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr6 = this.opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr3 = this.opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr4 = this.opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr1 = this.opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr2 = this.opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr4Wgt4 = this.opr4Wgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr4Wgt2 = this.opr4Wgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr4Qty2h = this.opr4Qty2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr9 = this.opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr4Qty45 = this.opr4Qty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf2hOpr2 = this.rf2hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr6Qty4 = this.opr6Qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf2hOpr1 = this.rf2hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr6Qty2 = this.opr6Qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr5Qty2h = this.opr5Qty2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf2hOpr6 = this.rf2hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr2Qty2h = this.opr2Qty2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf2hOpr5 = this.rf2hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf2hOpr4 = this.rf2hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf4hOpr10 = this.rf4hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf2hOpr3 = this.rf2hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Opr8 = this.rf20Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Opr7 = this.rf20Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Opr9 = this.rf20Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Opr4 = this.rf20Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40Opr5 = this.dg40Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf2hOpr9 = this.rf2hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak4hTot = this.ak4hTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr2Qty45 = this.opr2Qty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Opr3 = this.rf20Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40Opr4 = this.dg40Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty1 = this.qty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40Opr3 = this.dg40Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Opr6 = this.rf20Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf2hOpr7 = this.rf2hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40Opr2 = this.dg40Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Opr5 = this.rf20Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf2hOpr8 = this.rf2hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty3 = this.qty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40Opr9 = this.dg40Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty2 = this.qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40Opr8 = this.dg40Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr5Qty45 = this.opr5Qty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty5 = this.qty5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Opr2 = this.rf20Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40Opr7 = this.dg40Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty4 = this.qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Opr1 = this.rf20Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40Opr6 = this.dg40Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr9Wgt45 = this.opr9Wgt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg4hOpr1 = this.dg4hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr3Qty2 = this.opr3Qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg4hOpr7 = this.dg4hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg4hOpr6 = this.dg4hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg4hOpr9 = this.dg4hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg4hOpr8 = this.dg4hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg4hOpr3 = this.dg4hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr2Teu = this.opr2Teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg4hOpr2 = this.dg4hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr9Wgt2h = this.opr9Wgt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg4hOpr5 = this.dg4hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg4hOpr4 = this.dg4hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak4hOpr10 = this.ak4hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20Opr10 = this.dg20Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr2Qty4h = this.opr2Qty4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr2Wgt4h = this.opr2Wgt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr7Qty4 = this.opr7Qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr7Qty2 = this.opr7Qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20Opr1 = this.dg20Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20Opr3 = this.dg20Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20Opr2 = this.dg20Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg2hOpr10 = this.dg2hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20Opr5 = this.dg20Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20Opr4 = this.dg20Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20Opr7 = this.dg20Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20Opr6 = this.dg20Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20Opr9 = this.dg20Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg20Opr8 = this.dg20Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg4hTot = this.dg4hTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty8 = this.qty8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty9 = this.qty9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty6 = this.qty6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty7 = this.qty7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg2hOpr4 = this.dg2hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg2hOpr5 = this.dg2hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg2hOpr6 = this.dg2hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg2hOpr7 = this.dg2hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr2Wgt45 = this.opr2Wgt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg2hOpr1 = this.dg2hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg2hOpr2 = this.dg2hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg2hOpr3 = this.dg2hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr9Qty4h = this.opr9Qty4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr6Wgt2h = this.opr6Wgt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr6Wgt45 = this.opr6Wgt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg2hOpr8 = this.dg2hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg2hOpr9 = this.dg2hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Tot = this.rf20Tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totWgt2 = this.totWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr3Wgt2h = this.opr3Wgt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totWgt4 = this.totWgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mlb = this.mlb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb45Opr1 = this.bb45Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr3Wgt45 = this.opr3Wgt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb45Opr3 = this.bb45Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb45Opr2 = this.bb45Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb45Opr5 = this.bb45Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb45Opr4 = this.bb45Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb45Opr7 = this.bb45Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb45Opr6 = this.bb45Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb45Opr9 = this.bb45Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb45Opr8 = this.bb45Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr6Wgt4h = this.opr6Wgt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avWgt2 = this.avWgt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avWgt4 = this.avWgt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40Tot = this.ak40Tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40Opr7 = this.ak40Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40Opr8 = this.ak40Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf2hOpr10 = this.rf2hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40Opr9 = this.ak40Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr5Wgt2h = this.opr5Wgt2h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40Opr3 = this.ak40Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40Opr4 = this.ak40Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40Opr5 = this.ak40Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr5Qty4h = this.opr5Qty4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40Opr6 = this.ak40Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40Opr1 = this.ak40Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak40Opr2 = this.ak40Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr3Wgt4h = this.opr3Wgt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr9Teu = this.opr9Teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mlbCd = this.mlbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr9Wgt4h = this.opr9Wgt4h .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg40Opr1 = this.dg40Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr5Wgt45 = this.opr5Wgt45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak2hOpr2 = this.ak2hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak2hOpr1 = this.ak2hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak2hOpr4 = this.ak2hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak2hOpr3 = this.ak2hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak2hOpr6 = this.ak2hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak2hOpr5 = this.ak2hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak2hOpr8 = this.ak2hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak2hOpr7 = this.ak2hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ak2hOpr9 = this.ak2hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg45Tot = this.dg45Tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.stwg20Opr1 = this.stwg20Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg2hOpr1 = this.stwg2hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg40Opr1 = this.stwg40Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg4hOpr1 = this.stwg4hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg45Opr1 = this.stwg45Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.stwg20Opr2 = this.stwg20Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg2hOpr2 = this.stwg2hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg40Opr2 = this.stwg40Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg4hOpr2 = this.stwg4hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg45Opr2 = this.stwg45Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.stwg20Opr3 = this.stwg20Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg2hOpr3 = this.stwg2hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg40Opr3 = this.stwg40Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg4hOpr3 = this.stwg4hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg45Opr3 = this.stwg45Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.stwg20Opr4 = this.stwg20Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg2hOpr4 = this.stwg2hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg40Opr4 = this.stwg40Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg4hOpr4 = this.stwg4hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg45Opr4 = this.stwg45Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.stwg20Opr5 = this.stwg20Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg2hOpr5 = this.stwg2hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg40Opr5 = this.stwg40Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg4hOpr5 = this.stwg4hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg45Opr5 = this.stwg45Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.stwg20Tot = this.stwg20Tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg2hTot = this.stwg2hTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg40Tot = this.stwg40Tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg4hTot = this.stwg4hTot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg45Tot = this.stwg45Tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.podYdCd   = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
