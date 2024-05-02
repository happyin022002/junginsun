/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CBFSpecialStwgVO.java
*@FileTitle : CBFSpecialStwgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2010.02.01 김현욱 
* 1.0 Creation
* 2013.06.18 SKY [CHM-201324915}: [VOP-OPF] CBF – POD TMNL code로 구분
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo;

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

public class CBFSpecialStwgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CBFSpecialStwgVO> models = new ArrayList<CBFSpecialStwgVO>();
	
	/* Column Info */
	private String st720Opr10 = null;
	/* Column Info */
	private String st740Opr7 = null;
	/* Column Info */
	private String st1445Opr10 = null;
	/* Column Info */
	private String st740Opr8 = null;
	/* Column Info */
	private String st740Opr9 = null;
	/* Column Info */
	private String st140Opr10 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String st740Opr1 = null;
	/* Column Info */
	private String st740Opr2 = null;
	/* Column Info */
	private String st740Opr3 = null;
	/* Column Info */
	private String st740Opr4 = null;
	/* Column Info */
	private String st740Opr5 = null;
	/* Column Info */
	private String st740Opr6 = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String st145Opr10 = null;
	/* Column Info */
	private String st1545Opr10 = null;
	/* Column Info */
	private String st640Opr10 = null;
	/* Column Info */
	private String st1340Opr10 = null;
	/* Column Info */
	private String st520Opr10 = null;
	/* Column Info */
	private String st154hOpr10 = null;
	/* Column Info */
	private String st82hOpr10 = null;
	/* Column Info */
	private String st845Opr10 = null;
	/* Column Info */
	private String st645Opr3 = null;
	/* Column Info */
	private String st645Opr4 = null;
	/* Column Info */
	private String st645Opr5 = null;
	/* Column Info */
	private String st545Opr8 = null;
	/* Column Info */
	private String st645Opr6 = null;
	/* Column Info */
	private String st545Opr9 = null;
	/* Column Info */
	private String st545Opr6 = null;
	/* Column Info */
	private String st645Opr7 = null;
	/* Column Info */
	private String st545Opr7 = null;
	/* Column Info */
	private String st645Opr8 = null;
	/* Column Info */
	private String st545Opr4 = null;
	/* Column Info */
	private String st645Opr9 = null;
	/* Column Info */
	private String st545Opr5 = null;
	/* Column Info */
	private String st545Opr2 = null;
	/* Column Info */
	private String st545Opr3 = null;
	/* Column Info */
	private String st1145Opr10 = null;
	/* Column Info */
	private String st545Opr1 = null;
	/* Column Info */
	private String st645Opr1 = null;
	/* Column Info */
	private String st645Opr2 = null;
	/* Column Info */
	private String st114hOpr8 = null;
	/* Column Info */
	private String st114hOpr9 = null;
	/* Column Info */
	private String st114hOpr4 = null;
	/* Column Info */
	private String st114hOpr5 = null;
	/* Column Info */
	private String st114hOpr6 = null;
	/* Column Info */
	private String st114hOpr7 = null;
	/* Column Info */
	private String st114hOpr1 = null;
	/* Column Info */
	private String st114hOpr2 = null;
	/* Column Info */
	private String st114hOpr3 = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String st745Opr10 = null;
	/* Column Info */
	private String st1320Opr10 = null;
	/* Column Info */
	private String st122hOpr1 = null;
	/* Column Info */
	private String st122hOpr2 = null;
	/* Column Info */
	private String st122hOpr3 = null;
	/* Column Info */
	private String st122hOpr4 = null;
	/* Column Info */
	private String st122hOpr5 = null;
	/* Column Info */
	private String st122hOpr6 = null;
	/* Column Info */
	private String st122hOpr7 = null;
	/* Column Info */
	private String st122hOpr8 = null;
	/* Column Info */
	private String st845Opr5 = null;
	/* Column Info */
	private String st104hOpr6 = null;
	/* Column Info */
	private String st1445Opr9 = null;
	/* Column Info */
	private String st104hOpr5 = null;
	/* Column Info */
	private String st845Opr6 = null;
	/* Column Info */
	private String st1445Opr8 = null;
	/* Column Info */
	private String st1145Opr1 = null;
	/* Column Info */
	private String st845Opr7 = null;
	/* Column Info */
	private String st104hOpr8 = null;
	/* Column Info */
	private String st1145Opr2 = null;
	/* Column Info */
	private String st104hOpr7 = null;
	/* Column Info */
	private String st845Opr8 = null;
	/* Column Info */
	private String st1145Opr3 = null;
	/* Column Info */
	private String st845Opr1 = null;
	/* Column Info */
	private String st1445Opr5 = null;
	/* Column Info */
	private String st1445Opr4 = null;
	/* Column Info */
	private String st1145Opr4 = null;
	/* Column Info */
	private String st845Opr2 = null;
	/* Column Info */
	private String st104hOpr9 = null;
	/* Column Info */
	private String st845Opr3 = null;
	/* Column Info */
	private String st1145Opr5 = null;
	/* Column Info */
	private String st1445Opr7 = null;
	/* Column Info */
	private String st845Opr4 = null;
	/* Column Info */
	private String st1145Opr6 = null;
	/* Column Info */
	private String st1445Opr6 = null;
	/* Column Info */
	private String st1445Opr1 = null;
	/* Column Info */
	private String st1145Opr7 = null;
	/* Column Info */
	private String st1145Opr8 = null;
	/* Column Info */
	private String st1445Opr3 = null;
	/* Column Info */
	private String st1145Opr9 = null;
	/* Column Info */
	private String st1445Opr2 = null;
	/* Column Info */
	private String st104hOpr2 = null;
	/* Column Info */
	private String st104hOpr1 = null;
	/* Column Info */
	private String st104hOpr4 = null;
	/* Column Info */
	private String st104hOpr3 = null;
	/* Column Info */
	private String st845Opr9 = null;
	/* Column Info */
	private String st34hOpr2 = null;
	/* Column Info */
	private String st34hOpr1 = null;
	/* Column Info */
	private String st34hOpr4 = null;
	/* Column Info */
	private String st34hOpr3 = null;
	/* Column Info */
	private String st34hOpr6 = null;
	/* Column Info */
	private String st34hOpr5 = null;
	/* Column Info */
	private String st34hOpr8 = null;
	/* Column Info */
	private String st34hOpr7 = null;
	/* Column Info */
	private String st34hOpr9 = null;
	/* Column Info */
	private String st1345Opr3 = null;
	/* Column Info */
	private String st1345Opr4 = null;
	/* Column Info */
	private String st1345Opr1 = null;
	/* Column Info */
	private String st1345Opr2 = null;
	/* Column Info */
	private String st1345Opr9 = null;
	/* Column Info */
	private String st1345Opr7 = null;
	/* Column Info */
	private String st1345Opr8 = null;
	/* Column Info */
	private String st1345Opr5 = null;
	/* Column Info */
	private String st1345Opr6 = null;
	/* Column Info */
	private String st12hOpr10 = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String st545Opr10 = null;
	/* Column Info */
	private String st152hOpr8 = null;
	/* Column Info */
	private String st152hOpr9 = null;
	/* Column Info */
	private String st152hOpr6 = null;
	/* Column Info */
	private String st152hOpr7 = null;
	/* Column Info */
	private String st1140Opr1 = null;
	/* Column Info */
	private String st1140Opr2 = null;
	/* Column Info */
	private String st1140Opr3 = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String st1420Opr10 = null;
	/* Column Info */
	private String st142hOpr8 = null;
	/* Column Info */
	private String st142hOpr7 = null;
	/* Column Info */
	private String st142hOpr9 = null;
	/* Column Info */
	private String st74hOpr9 = null;
	/* Column Info */
	private String st74hOpr7 = null;
	/* Column Info */
	private String st74hOpr8 = null;
	/* Column Info */
	private String st74hOpr6 = null;
	/* Column Info */
	private String st1220Opr9 = null;
	/* Column Info */
	private String st74hOpr5 = null;
	/* Column Info */
	private String st74hOpr4 = null;
	/* Column Info */
	private String st74hOpr3 = null;
	/* Column Info */
	private String st74hOpr2 = null;
	/* Column Info */
	private String st74hOpr1 = null;
	/* Column Info */
	private String opr10 = null;
	/* Column Info */
	private String st1220Opr1 = null;
	/* Column Info */
	private String st1220Opr2 = null;
	/* Column Info */
	private String st1220Opr3 = null;
	/* Column Info */
	private String st1220Opr4 = null;
	/* Column Info */
	private String st1220Opr5 = null;
	/* Column Info */
	private String st1220Opr6 = null;
	/* Column Info */
	private String st1220Opr7 = null;
	/* Column Info */
	private String st124hOpr10 = null;
	/* Column Info */
	private String st1220Opr8 = null;
	/* Column Info */
	private String st82hOpr7 = null;
	/* Column Info */
	private String st82hOpr6 = null;
	/* Column Info */
	private String st82hOpr5 = null;
	/* Column Info */
	private String st82hOpr4 = null;
	/* Column Info */
	private String st82hOpr9 = null;
	/* Column Info */
	private String st82hOpr8 = null;
	/* Column Info */
	private String st82hOpr2 = null;
	/* Column Info */
	private String st82hOpr3 = null;
	/* Column Info */
	private String st82hOpr1 = null;
	/* Column Info */
	private String st92hOpr3 = null;
	/* Column Info */
	private String st92hOpr4 = null;
	/* Column Info */
	private String st92hOpr5 = null;
	/* Column Info */
	private String st92hOpr6 = null;
	/* Column Info */
	private String st92hOpr7 = null;
	/* Column Info */
	private String st92hOpr8 = null;
	/* Column Info */
	private String st92hOpr9 = null;
	/* Column Info */
	private String st1020Opr10 = null;
	/* Column Info */
	private String st1140Opr9 = null;
	/* Column Info */
	private String st1140Opr8 = null;
	/* Column Info */
	private String st1140Opr7 = null;
	/* Column Info */
	private String st1140Opr6 = null;
	/* Column Info */
	private String st1140Opr5 = null;
	/* Column Info */
	private String st1140Opr4 = null;
	/* Column Info */
	private String st245Opr3 = null;
	/* Column Info */
	private String st245Opr4 = null;
	/* Column Info */
	private String st740Opr10 = null;
	/* Column Info */
	private String st245Opr5 = null;
	/* Column Info */
	private String st152hOpr1 = null;
	/* Column Info */
	private String st245Opr6 = null;
	/* Column Info */
	private String st152hOpr3 = null;
	/* Column Info */
	private String st152hOpr2 = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String st245Opr1 = null;
	/* Column Info */
	private String st152hOpr5 = null;
	/* Column Info */
	private String st152hOpr4 = null;
	/* Column Info */
	private String st245Opr2 = null;
	/* Column Info */
	private String st245Opr7 = null;
	/* Column Info */
	private String st920Opr10 = null;
	/* Column Info */
	private String st245Opr8 = null;
	/* Column Info */
	private String st92hOpr2 = null;
	/* Column Info */
	private String st245Opr9 = null;
	/* Column Info */
	private String st92hOpr1 = null;
	/* Column Info */
	private String st52hOpr2 = null;
	/* Column Info */
	private String st52hOpr1 = null;
	/* Column Info */
	private String st52hOpr6 = null;
	/* Column Info */
	private String st52hOpr5 = null;
	/* Column Info */
	private String st52hOpr4 = null;
	/* Column Info */
	private String st52hOpr3 = null;
	/* Column Info */
	private String st144hOpr10 = null;
	/* Column Info */
	private String crrCd = null;
	/* Column Info */
	private String st52hOpr9 = null;
	/* Column Info */
	private String st52hOpr7 = null;
	/* Column Info */
	private String st52hOpr8 = null;
	/* Column Info */
	private String st122hOpr9 = null;
	/* Column Info */
	private String st124hOpr4 = null;
	/* Column Info */
	private String st940Opr2 = null;
	/* Column Info */
	private String st124hOpr3 = null;
	/* Column Info */
	private String st940Opr1 = null;
	/* Column Info */
	private String st940Opr4 = null;
	/* Column Info */
	private String st124hOpr6 = null;
	/* Column Info */
	private String st940Opr3 = null;
	/* Column Info */
	private String st124hOpr5 = null;
	/* Column Info */
	private String st124hOpr8 = null;
	/* Column Info */
	private String st124hOpr7 = null;
	/* Column Info */
	private String st245Opr10 = null;
	/* Column Info */
	private String st124hOpr9 = null;
	/* Column Info */
	private String st940Opr9 = null;
	/* Column Info */
	private String st940Opr6 = null;
	/* Column Info */
	private String st940Opr5 = null;
	/* Column Info */
	private String st124hOpr2 = null;
	/* Column Info */
	private String st940Opr8 = null;
	/* Column Info */
	private String st32hOpr10 = null;
	/* Column Info */
	private String st124hOpr1 = null;
	/* Column Info */
	private String st940Opr7 = null;
	/* Column Info */
	private String st142hOpr6 = null;
	/* Column Info */
	private String st142hOpr5 = null;
	/* Column Info */
	private String st142hOpr4 = null;
	/* Column Info */
	private String st142hOpr3 = null;
	/* Column Info */
	private String st142hOpr2 = null;
	/* Column Info */
	private String st142hOpr1 = null;
	/* Column Info */
	private String st94hOpr1 = null;
	/* Column Info */
	private String st94hOpr2 = null;
	/* Column Info */
	private String st94hOpr3 = null;
	/* Column Info */
	private String st94hOpr4 = null;
	/* Column Info */
	private String st1520Opr1 = null;
	/* Column Info */
	private String st94hOpr9 = null;
	/* Column Info */
	private String st112hOpr1 = null;
	/* Column Info */
	private String st1520Opr5 = null;
	/* Column Info */
	private String st94hOpr6 = null;
	/* Column Info */
	private String st1520Opr4 = null;
	/* Column Info */
	private String st94hOpr5 = null;
	/* Column Info */
	private String st1520Opr3 = null;
	/* Column Info */
	private String st94hOpr8 = null;
	/* Column Info */
	private String st1520Opr2 = null;
	/* Column Info */
	private String st94hOpr7 = null;
	/* Column Info */
	private String st112hOpr6 = null;
	/* Column Info */
	private String st1520Opr9 = null;
	/* Column Info */
	private String st112hOpr7 = null;
	/* Column Info */
	private String st1520Opr8 = null;
	/* Column Info */
	private String st1520Opr7 = null;
	/* Column Info */
	private String st112hOpr8 = null;
	/* Column Info */
	private String st1520Opr6 = null;
	/* Column Info */
	private String st112hOpr9 = null;
	/* Column Info */
	private String st112hOpr2 = null;
	/* Column Info */
	private String st112hOpr3 = null;
	/* Column Info */
	private String st340Opr10 = null;
	/* Column Info */
	private String st112hOpr4 = null;
	/* Column Info */
	private String st112hOpr5 = null;
	/* Column Info */
	private String st1120Opr7 = null;
	/* Column Info */
	private String st1120Opr6 = null;
	/* Column Info */
	private String st1120Opr9 = null;
	/* Column Info */
	private String st1120Opr8 = null;
	/* Column Info */
	private String st1120Opr3 = null;
	/* Column Info */
	private String st1120Opr2 = null;
	/* Column Info */
	private String st1120Opr5 = null;
	/* Column Info */
	private String st1120Opr4 = null;
	/* Column Info */
	private String st132hOpr4 = null;
	/* Column Info */
	private String st132hOpr5 = null;
	/* Column Info */
	private String st132hOpr6 = null;
	/* Column Info */
	private String st132hOpr7 = null;
	/* Column Info */
	private String st132hOpr1 = null;
	/* Column Info */
	private String st132hOpr2 = null;
	/* Column Info */
	private String st132hOpr3 = null;
	/* Column Info */
	private String st24hOpr10 = null;
	/* Column Info */
	private String st345Opr10 = null;
	/* Column Info */
	private String qty1 = null;
	/* Column Info */
	private String qty3 = null;
	/* Column Info */
	private String qty2 = null;
	/* Column Info */
	private String qty5 = null;
	/* Column Info */
	private String qty4 = null;
	/* Column Info */
	private String st720Opr7 = null;
	/* Column Info */
	private String st720Opr8 = null;
	/* Column Info */
	private String st720Opr5 = null;
	/* Column Info */
	private String st720Opr6 = null;
	/* Column Info */
	private String st720Opr9 = null;
	/* Column Info */
	private String st34hOpr10 = null;
	/* Column Info */
	private String st62hOpr10 = null;
	/* Column Info */
	private String st1440Opr10 = null;
	/* Column Info */
	private String st720Opr3 = null;
	/* Column Info */
	private String st720Opr4 = null;
	/* Column Info */
	private String st720Opr1 = null;
	/* Column Info */
	private String st720Opr2 = null;
	/* Column Info */
	private String st1045Opr10 = null;
	/* Column Info */
	private String st1540Opr1 = null;
	/* Column Info */
	private String st1540Opr2 = null;
	/* Column Info */
	private String st1540Opr3 = null;
	/* Column Info */
	private String st1540Opr4 = null;
	/* Column Info */
	private String st1540Opr5 = null;
	/* Column Info */
	private String st1540Opr6 = null;
	/* Column Info */
	private String st1540Opr7 = null;
	/* Column Info */
	private String st1540Opr8 = null;
	/* Column Info */
	private String st1540Opr9 = null;
	/* Column Info */
	private String qty8 = null;
	/* Column Info */
	private String st1545Opr1 = null;
	/* Column Info */
	private String st1545Opr2 = null;
	/* Column Info */
	private String qty9 = null;
	/* Column Info */
	private String qty6 = null;
	/* Column Info */
	private String st420Opr10 = null;
	/* Column Info */
	private String qty7 = null;
	/* Column Info */
	private String st1545Opr5 = null;
	/* Column Info */
	private String st1545Opr6 = null;
	/* Column Info */
	private String st1545Opr3 = null;
	/* Column Info */
	private String st1545Opr4 = null;
	/* Column Info */
	private String st1545Opr9 = null;
	/* Column Info */
	private String st1545Opr7 = null;
	/* Column Info */
	private String st1545Opr8 = null;
	/* Column Info */
	private String st1320Opr1 = null;
	/* Column Info */
	private String st1320Opr3 = null;
	/* Column Info */
	private String st132hOpr9 = null;
	/* Column Info */
	private String st1320Opr2 = null;
	/* Column Info */
	private String st132hOpr8 = null;
	/* Column Info */
	private String st1320Opr5 = null;
	/* Column Info */
	private String st1320Opr4 = null;
	/* Column Info */
	private String st1320Opr7 = null;
	/* Column Info */
	private String st1320Opr6 = null;
	/* Column Info */
	private String st1320Opr9 = null;
	/* Column Info */
	private String st1320Opr8 = null;
	/* Column Info */
	private String st340Opr1 = null;
	/* Column Info */
	private String st340Opr2 = null;
	/* Column Info */
	private String st340Opr9 = null;
	/* Column Info */
	private String st340Opr8 = null;
	/* Column Info */
	private String st340Opr7 = null;
	/* Column Info */
	private String st340Opr6 = null;
	/* Column Info */
	private String st340Opr5 = null;
	/* Column Info */
	private String st340Opr4 = null;
	/* Column Info */
	private String st340Opr3 = null;
	/* Column Info */
	private String allFlg = null;
	/* Column Info */
	private String st445Opr10 = null;
	/* Column Info */
	private String st120Opr1 = null;
	/* Column Info */
	private String st120Opr2 = null;
	/* Column Info */
	private String st120Opr10 = null;
	/* Column Info */
	private String st132hOpr10 = null;
	/* Column Info */
	private String st120Opr4 = null;
	/* Column Info */
	private String st120Opr3 = null;
	/* Column Info */
	private String st120Opr6 = null;
	/* Column Info */
	private String st120Opr5 = null;
	/* Column Info */
	private String st120Opr8 = null;
	/* Column Info */
	private String st120Opr7 = null;
	/* Column Info */
	private String st120Opr9 = null;
	/* Column Info */
	private String st1040Opr10 = null;
	/* Column Info */
	private String st92hOpr10 = null;
	/* Column Info */
	private String st1045Opr5 = null;
	/* Column Info */
	private String st1045Opr4 = null;
	/* Column Info */
	private String st1045Opr7 = null;
	/* Column Info */
	private String st1045Opr6 = null;
	/* Column Info */
	private String st1045Opr1 = null;
	/* Column Info */
	private String st540Opr10 = null;
	/* Column Info */
	private String st1045Opr3 = null;
	/* Column Info */
	private String bbCgoFlg = null;
	/* Column Info */
	private String st1045Opr2 = null;
	/* Column Info */
	private String st1045Opr9 = null;
	/* Column Info */
	private String st1045Opr8 = null;
	/* Column Info */
	private String mlbCd = null;
	/* Column Info */
	private String st1520Opr10 = null;
	/* Column Info */
	private String st345Opr7 = null;
	/* Column Info */
	private String st345Opr6 = null;
	/* Column Info */
	private String st345Opr9 = null;
	/* Column Info */
	private String st345Opr8 = null;
	/* Column Info */
	private String st1120Opr1 = null;
	/* Column Info */
	private String st345Opr1 = null;
	/* Column Info */
	private String st345Opr3 = null;
	/* Column Info */
	private String st345Opr2 = null;
	/* Column Info */
	private String st345Opr5 = null;
	/* Column Info */
	private String st345Opr4 = null;
	/* Column Info */
	private String st12hOpr2 = null;
	/* Column Info */
	private String st12hOpr1 = null;
	/* Column Info */
	private String st1340Opr1 = null;
	/* Column Info */
	private String st12hOpr8 = null;
	/* Column Info */
	private String st12hOpr7 = null;
	/* Column Info */
	private String st12hOpr9 = null;
	/* Column Info */
	private String st12hOpr4 = null;
	/* Column Info */
	private String st12hOpr3 = null;
	/* Column Info */
	private String st12hOpr6 = null;
	/* Column Info */
	private String st12hOpr5 = null;
	/* Column Info */
	private String st1420Opr6 = null;
	/* Column Info */
	private String st1420Opr5 = null;
	/* Column Info */
	private String st1420Opr4 = null;
	/* Column Info */
	private String st1420Opr3 = null;
	/* Column Info */
	private String st1420Opr2 = null;
	/* Column Info */
	private String st1420Opr1 = null;
	/* Column Info */
	private String st1420Opr9 = null;
	/* Column Info */
	private String st1420Opr8 = null;
	/* Column Info */
	private String st1420Opr7 = null;
	/* Column Info */
	private String st84hOpr1 = null;
	/* Column Info */
	private String st84hOpr3 = null;
	/* Column Info */
	private String st84hOpr2 = null;
	/* Column Info */
	private String st84hOpr5 = null;
	/* Column Info */
	private String st84hOpr4 = null;
	/* Column Info */
	private String st152hOpr10 = null;
	/* Column Info */
	private String st84hOpr6 = null;
	/* Column Info */
	private String st84hOpr7 = null;
	/* Column Info */
	private String st84hOpr8 = null;
	/* Column Info */
	private String st84hOpr9 = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String st14hOpr10 = null;
	/* Column Info */
	private String st640Opr8 = null;
	/* Column Info */
	private String st1245Opr9 = null;
	/* Column Info */
	private String st1245Opr8 = null;
	/* Column Info */
	private String st640Opr9 = null;
	/* Column Info */
	private String st1245Opr7 = null;
	/* Column Info */
	private String st1245Opr6 = null;
	/* Column Info */
	private String st640Opr4 = null;
	/* Column Info */
	private String st1245Opr5 = null;
	/* Column Info */
	private String st640Opr5 = null;
	/* Column Info */
	private String st1245Opr4 = null;
	/* Column Info */
	private String st1245Opr3 = null;
	/* Column Info */
	private String st640Opr6 = null;
	/* Column Info */
	private String st1245Opr2 = null;
	/* Column Info */
	private String st640Opr7 = null;
	/* Column Info */
	private String st1245Opr1 = null;
	/* Column Info */
	private String st640Opr1 = null;
	/* Column Info */
	private String st640Opr2 = null;
	/* Column Info */
	private String st640Opr3 = null;
	/* Column Info */
	private String st52hOpr10 = null;
	/* Column Info */
	private String st1340Opr2 = null;
	/* Column Info */
	private String st1340Opr3 = null;
	/* Column Info */
	private String st1340Opr4 = null;
	/* Column Info */
	private String st1340Opr5 = null;
	/* Column Info */
	private String st1340Opr6 = null;
	/* Column Info */
	private String st1340Opr7 = null;
	/* Column Info */
	private String st1340Opr8 = null;
	/* Column Info */
	private String st1340Opr9 = null;
	/* Column Info */
	private String st945Opr1 = null;
	/* Column Info */
	private String st945Opr3 = null;
	/* Column Info */
	private String st945Opr2 = null;
	/* Column Info */
	private String st945Opr5 = null;
	/* Column Info */
	private String st945Opr4 = null;
	/* Column Info */
	private String st945Opr7 = null;
	/* Column Info */
	private String st945Opr6 = null;
	/* Column Info */
	private String st64hOpr10 = null;
	/* Column Info */
	private String st520Opr1 = null;
	/* Column Info */
	private String st540Opr2 = null;
	/* Column Info */
	private String st540Opr1 = null;
	/* Column Info */
	private String st520Opr2 = null;
	/* Column Info */
	private String st540Opr4 = null;
	/* Column Info */
	private String st540Opr3 = null;
	/* Column Info */
	private String qty10 = null;
	/* Column Info */
	private String st520Opr5 = null;
	/* Column Info */
	private String st540Opr6 = null;
	/* Column Info */
	private String st540Opr5 = null;
	/* Column Info */
	private String st520Opr6 = null;
	/* Column Info */
	private String st520Opr3 = null;
	/* Column Info */
	private String st540Opr8 = null;
	/* Column Info */
	private String st520Opr4 = null;
	/* Column Info */
	private String st540Opr7 = null;
	/* Column Info */
	private String st520Opr9 = null;
	/* Column Info */
	private String st540Opr9 = null;
	/* Column Info */
	private String st520Opr7 = null;
	/* Column Info */
	private String st520Opr8 = null;
	/* Column Info */
	private String st945Opr10 = null;
	/* Column Info */
	private String st94hOpr10 = null;
	/* Column Info */
	private String stwgCgoFlg = null;
	/* Column Info */
	private String st1540Opr10 = null;
	/* Column Info */
	private String st945Opr8 = null;
	/* Column Info */
	private String st945Opr9 = null;
	/* Column Info */
	private String st32hOpr9 = null;
	/* Column Info */
	private String st24hOpr1 = null;
	/* Column Info */
	private String st920Opr9 = null;
	/* Column Info */
	private String st24hOpr3 = null;
	/* Column Info */
	private String st920Opr8 = null;
	/* Column Info */
	private String st24hOpr2 = null;
	/* Column Info */
	private String st920Opr7 = null;
	/* Column Info */
	private String st920Opr6 = null;
	/* Column Info */
	private String st920Opr5 = null;
	/* Column Info */
	private String st920Opr4 = null;
	/* Column Info */
	private String st920Opr3 = null;
	/* Column Info */
	private String st32hOpr4 = null;
	/* Column Info */
	private String st920Opr2 = null;
	/* Column Info */
	private String st24hOpr9 = null;
	/* Column Info */
	private String st32hOpr3 = null;
	/* Column Info */
	private String st920Opr1 = null;
	/* Column Info */
	private String stwgCd = null;
	/* Column Info */
	private String st24hOpr8 = null;
	/* Column Info */
	private String st240Opr10 = null;
	/* Column Info */
	private String st32hOpr2 = null;
	/* Column Info */
	private String st32hOpr1 = null;
	/* Column Info */
	private String st24hOpr5 = null;
	/* Column Info */
	private String st32hOpr8 = null;
	/* Column Info */
	private String st24hOpr4 = null;
	/* Column Info */
	private String st32hOpr7 = null;
	/* Column Info */
	private String st32hOpr6 = null;
	/* Column Info */
	private String st24hOpr7 = null;
	/* Column Info */
	private String st32hOpr5 = null;
	/* Column Info */
	private String st24hOpr6 = null;
	/* Column Info */
	private String st240Opr4 = null;
	/* Column Info */
	private String st820Opr1 = null;
	/* Column Info */
	private String st112hOpr10 = null;
	/* Column Info */
	private String st240Opr5 = null;
	/* Column Info */
	private String st820Opr3 = null;
	/* Column Info */
	private String st240Opr6 = null;
	/* Column Info */
	private String st820Opr2 = null;
	/* Column Info */
	private String st240Opr7 = null;
	/* Column Info */
	private String st240Opr8 = null;
	/* Column Info */
	private String st240Opr9 = null;
	/* Column Info */
	private String st64hOpr7 = null;
	/* Column Info */
	private String st820Opr9 = null;
	/* Column Info */
	private String st64hOpr6 = null;
	/* Column Info */
	private String st820Opr8 = null;
	/* Column Info */
	private String st64hOpr5 = null;
	/* Column Info */
	private String st64hOpr4 = null;
	/* Column Info */
	private String st64hOpr3 = null;
	/* Column Info */
	private String st820Opr5 = null;
	/* Column Info */
	private String st820Opr4 = null;
	/* Column Info */
	private String st64hOpr2 = null;
	/* Column Info */
	private String st64hOpr1 = null;
	/* Column Info */
	private String st820Opr7 = null;
	/* Column Info */
	private String st820Opr6 = null;
	/* Column Info */
	private String st445Opr1 = null;
	/* Column Info */
	private String st445Opr2 = null;
	/* Column Info */
	private String st445Opr3 = null;
	/* Column Info */
	private String st64hOpr8 = null;
	/* Column Info */
	private String st445Opr4 = null;
	/* Column Info */
	private String st64hOpr9 = null;
	/* Column Info */
	private String st445Opr5 = null;
	/* Column Info */
	private String st445Opr6 = null;
	/* Column Info */
	private String st445Opr7 = null;
	/* Column Info */
	private String st445Opr8 = null;
	/* Column Info */
	private String st240Opr1 = null;
	/* Column Info */
	private String st445Opr9 = null;
	/* Column Info */
	private String st240Opr3 = null;
	/* Column Info */
	private String st240Opr2 = null;
	/* Column Info */
	private String st9 = null;
	/* Column Info */
	private String st7 = null;
	/* Column Info */
	private String st8 = null;
	/* Column Info */
	private String st5 = null;
	/* Column Info */
	private String st6 = null;
	/* Column Info */
	private String st3 = null;
	/* Column Info */
	private String st4 = null;
	/* Column Info */
	private String st1 = null;
	/* Column Info */
	private String st2 = null;
	/* Column Info */
	private String st940Opr10 = null;
	/* Column Info */
	private String st1220Opr10 = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String st320Opr9 = null;
	/* Column Info */
	private String st320Opr8 = null;
	/* Column Info */
	private String st320Opr7 = null;
	/* Column Info */
	private String st320Opr6 = null;
	/* Column Info */
	private String st320Opr5 = null;
	/* Column Info */
	private String st42hOpr10 = null;
	/* Column Info */
	private String st320Opr4 = null;
	/* Column Info */
	private String st320Opr3 = null;
	/* Column Info */
	private String st320Opr2 = null;
	/* Column Info */
	private String st320Opr1 = null;
	/* Column Info */
	private String st144hOpr9 = null;
	/* Column Info */
	private String st645Opr10 = null;
	/* Column Info */
	private String st22hOpr1 = null;
	/* Column Info */
	private String st22hOpr8 = null;
	/* Column Info */
	private String st22hOpr9 = null;
	/* Column Info */
	private String st22hOpr6 = null;
	/* Column Info */
	private String st22hOpr7 = null;
	/* Column Info */
	private String st122hOpr10 = null;
	/* Column Info */
	private String st104hOpr10 = null;
	/* Column Info */
	private String st22hOpr4 = null;
	/* Column Info */
	private String st22hOpr5 = null;
	/* Column Info */
	private String st22hOpr2 = null;
	/* Column Info */
	private String st22hOpr3 = null;
	/* Column Info */
	private String st440Opr10 = null;
	/* Column Info */
	private String st44hOpr6 = null;
	/* Column Info */
	private String st44hOpr7 = null;
	/* Column Info */
	private String st44hOpr8 = null;
	/* Column Info */
	private String st44hOpr9 = null;
	/* Column Info */
	private String st44hOpr2 = null;
	/* Column Info */
	private String st44hOpr3 = null;
	/* Column Info */
	private String st44hOpr4 = null;
	/* Column Info */
	private String st44hOpr5 = null;
	/* Column Info */
	private String st44hOpr1 = null;
	/* Column Info */
	private String bkgShprOwnrFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String st144hOpr1 = null;
	/* Column Info */
	private String st144hOpr2 = null;
	/* Column Info */
	private String st144hOpr3 = null;
	/* Column Info */
	private String st74hOpr10 = null;
	/* Column Info */
	private String st144hOpr4 = null;
	/* Column Info */
	private String st144hOpr5 = null;
	/* Column Info */
	private String st144hOpr6 = null;
	/* Column Info */
	private String st144hOpr7 = null;
	/* Column Info */
	private String st144hOpr8 = null;
	/* Column Info */
	private String st72hOpr10 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String st420Opr9 = null;
	/* Column Info */
	private String st420Opr8 = null;
	/* Column Info */
	private String st420Opr5 = null;
	/* Column Info */
	private String st420Opr4 = null;
	/* Column Info */
	private String st420Opr7 = null;
	/* Column Info */
	private String st420Opr6 = null;
	/* Column Info */
	private String st420Opr1 = null;
	/* Column Info */
	private String st420Opr3 = null;
	/* Column Info */
	private String st420Opr2 = null;
	/* Column Info */
	private String st840Opr9 = null;
	/* Column Info */
	private String st840Opr8 = null;
	/* Column Info */
	private String st840Opr7 = null;
	/* Column Info */
	private String st840Opr6 = null;
	/* Column Info */
	private String st22hOpr10 = null;
	/* Column Info */
	private String st840Opr1 = null;
	/* Column Info */
	private String st440Opr9 = null;
	/* Column Info */
	private String st440Opr8 = null;
	/* Column Info */
	private String st440Opr7 = null;
	/* Column Info */
	private String st440Opr6 = null;
	/* Column Info */
	private String st440Opr5 = null;
	/* Column Info */
	private String st840Opr5 = null;
	/* Column Info */
	private String st840Opr4 = null;
	/* Column Info */
	private String st440Opr4 = null;
	/* Column Info */
	private String st840Opr3 = null;
	/* Column Info */
	private String st440Opr3 = null;
	/* Column Info */
	private String st440Opr2 = null;
	/* Column Info */
	private String st840Opr2 = null;
	/* Column Info */
	private String st440Opr1 = null;
	/* Column Info */
	private String st820Opr10 = null;
	/* Column Info */
	private String st1120Opr10 = null;
	/* Column Info */
	private String st620Opr9 = null;
	/* Column Info */
	private String st620Opr8 = null;
	/* Column Info */
	private String st620Opr7 = null;
	/* Column Info */
	private String st620Opr6 = null;
	/* Column Info */
	private String st620Opr1 = null;
	/* Column Info */
	private String st620Opr5 = null;
	/* Column Info */
	private String st620Opr4 = null;
	/* Column Info */
	private String st620Opr3 = null;
	/* Column Info */
	private String st620Opr2 = null;
	/* Column Info */
	private String st1240Opr9 = null;
	/* Column Info */
	private String st62hOpr1 = null;
	/* Column Info */
	private String st1240Opr8 = null;
	/* Column Info */
	private String st1240Opr7 = null;
	/* Column Info */
	private String st62hOpr3 = null;
	/* Column Info */
	private String st1240Opr6 = null;
	/* Column Info */
	private String st62hOpr2 = null;
	/* Column Info */
	private String st1240Opr5 = null;
	/* Column Info */
	private String st62hOpr5 = null;
	/* Column Info */
	private String st1240Opr4 = null;
	/* Column Info */
	private String st62hOpr4 = null;
	/* Column Info */
	private String st1240Opr3 = null;
	/* Column Info */
	private String st62hOpr6 = null;
	/* Column Info */
	private String st62hOpr7 = null;
	/* Column Info */
	private String st62hOpr8 = null;
	/* Column Info */
	private String st62hOpr9 = null;
	/* Column Info */
	private String st134hOpr10 = null;
	/* Column Info */
	private String st620Opr10 = null;
	/* Column Info */
	private String st84hOpr10 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String st145Opr9 = null;
	/* Column Info */
	private String st1245Opr10 = null;
	/* Column Info */
	private String st145Opr8 = null;
	/* Column Info */
	private String st154hOpr9 = null;
	/* Column Info */
	private String st154hOpr8 = null;
	/* Column Info */
	private String st1345Opr10 = null;
	/* Column Info */
	private String st145Opr3 = null;
	/* Column Info */
	private String st145Opr2 = null;
	/* Column Info */
	private String st145Opr1 = null;
	/* Column Info */
	private String st145Opr7 = null;
	/* Column Info */
	private String st145Opr6 = null;
	/* Column Info */
	private String st145Opr5 = null;
	/* Column Info */
	private String st44hOpr10 = null;
	/* Column Info */
	private String st145Opr4 = null;
	/* Column Info */
	private String st54hOpr4 = null;
	/* Column Info */
	private String opr7 = null;
	/* Column Info */
	private String st54hOpr3 = null;
	/* Column Info */
	private String opr8 = null;
	/* Column Info */
	private String opr5 = null;
	/* Column Info */
	private String st54hOpr2 = null;
	/* Column Info */
	private String st54hOpr1 = null;
	/* Column Info */
	private String opr6 = null;
	/* Column Info */
	private String opr3 = null;
	/* Column Info */
	private String st54hOpr8 = null;
	/* Column Info */
	private String opr4 = null;
	/* Column Info */
	private String st54hOpr7 = null;
	/* Column Info */
	private String opr1 = null;
	/* Column Info */
	private String st54hOpr6 = null;
	/* Column Info */
	private String st54hOpr5 = null;
	/* Column Info */
	private String opr2 = null;
	/* Column Info */
	private String opr9 = null;
	/* Column Info */
	private String st54hOpr9 = null;
	/* Column Info */
	private String st220Opr6 = null;
	/* Column Info */
	private String st220Opr7 = null;
	/* Column Info */
	private String st220Opr8 = null;
	/* Column Info */
	private String st220Opr9 = null;
	/* Column Info */
	private String st220Opr2 = null;
	/* Column Info */
	private String st220Opr3 = null;
	/* Column Info */
	private String st220Opr4 = null;
	/* Column Info */
	private String st220Opr5 = null;
	/* Column Info */
	private String st1020Opr2 = null;
	/* Column Info */
	private String st1020Opr1 = null;
	/* Column Info */
	private String st220Opr1 = null;
	/* Column Info */
	private String st15 = null;
	/* Column Info */
	private String st14 = null;
	/* Column Info */
	private String st13 = null;
	/* Column Info */
	private String st12 = null;
	/* Column Info */
	private String st11 = null;
	/* Column Info */
	private String st10 = null;
	/* Column Info */
	private String st134hOpr1 = null;
	/* Column Info */
	private String st134hOpr2 = null;
	/* Column Info */
	private String st72hOpr5 = null;
	/* Column Info */
	private String st134hOpr3 = null;
	/* Column Info */
	private String st72hOpr6 = null;
	/* Column Info */
	private String st134hOpr4 = null;
	/* Column Info */
	private String st72hOpr7 = null;
	/* Column Info */
	private String st134hOpr5 = null;
	/* Column Info */
	private String st72hOpr8 = null;
	/* Column Info */
	private String st134hOpr6 = null;
	/* Column Info */
	private String st72hOpr9 = null;
	/* Column Info */
	private String st134hOpr7 = null;
	/* Column Info */
	private String st134hOpr8 = null;
	/* Column Info */
	private String st134hOpr9 = null;
	/* Column Info */
	private String st154hOpr1 = null;
	/* Column Info */
	private String st154hOpr3 = null;
	/* Column Info */
	private String st154hOpr2 = null;
	/* Column Info */
	private String st1440Opr9 = null;
	/* Column Info */
	private String st1040Opr4 = null;
	/* Column Info */
	private String st72hOpr2 = null;
	/* Column Info */
	private String st154hOpr5 = null;
	/* Column Info */
	private String st154hOpr4 = null;
	/* Column Info */
	private String st1040Opr3 = null;
	/* Column Info */
	private String st72hOpr1 = null;
	/* Column Info */
	private String st72hOpr4 = null;
	/* Column Info */
	private String st1040Opr2 = null;
	/* Column Info */
	private String st154hOpr7 = null;
	/* Column Info */
	private String st72hOpr3 = null;
	/* Column Info */
	private String st1040Opr1 = null;
	/* Column Info */
	private String st154hOpr6 = null;
	/* Column Info */
	private String st1440Opr4 = null;
	/* Column Info */
	private String st1440Opr3 = null;
	/* Column Info */
	private String st1440Opr2 = null;
	/* Column Info */
	private String st1440Opr1 = null;
	/* Column Info */
	private String st1440Opr8 = null;
	/* Column Info */
	private String st1440Opr7 = null;
	/* Column Info */
	private String st1440Opr6 = null;
	/* Column Info */
	private String st1440Opr5 = null;
	/* Column Info */
	private String st102hOpr1 = null;
	/* Column Info */
	private String st102hOpr2 = null;
	/* Column Info */
	private String st102hOpr7 = null;
	/* Column Info */
	private String st102hOpr8 = null;
	/* Column Info */
	private String st102hOpr9 = null;
	/* Column Info */
	private String st102hOpr3 = null;
	/* Column Info */
	private String st102hOpr4 = null;
	/* Column Info */
	private String st102hOpr5 = null;
	/* Column Info */
	private String st102hOpr6 = null;
	/* Column Info */
	private String st320Opr10 = null;
	/* Column Info */
	private String st1020Opr3 = null;
	/* Column Info */
	private String st1020Opr4 = null;
	/* Column Info */
	private String st1020Opr5 = null;
	/* Column Info */
	private String st1020Opr6 = null;
	/* Column Info */
	private String st1240Opr2 = null;
	/* Column Info */
	private String st1020Opr7 = null;
	/* Column Info */
	private String st1240Opr1 = null;
	/* Column Info */
	private String st1020Opr8 = null;
	/* Column Info */
	private String st1020Opr9 = null;
	/* Column Info */
	private String st1240Opr10 = null;
	/* Column Info */
	private String st14hOpr9 = null;
	/* Column Info */
	private String st1140Opr10 = null;
	/* Column Info */
	private String st14hOpr5 = null;
	/* Column Info */
	private String st14hOpr6 = null;
	/* Column Info */
	private String st14hOpr7 = null;
	/* Column Info */
	private String st14hOpr8 = null;
	/* Column Info */
	private String st14hOpr1 = null;
	/* Column Info */
	private String st14hOpr2 = null;
	/* Column Info */
	private String st14hOpr3 = null;
	/* Column Info */
	private String st14hOpr4 = null;
	/* Column Info */
	private String st840Opr10 = null;
	/* Column Info */
	private String mlb = null;
	/* Column Info */
	private String st102hOpr10 = null;
	/* Column Info */
	private String awkCgoFlg = null;
	/* Column Info */
	private String st42hOpr1 = null;
	/* Column Info */
	private String st1040Opr9 = null;
	/* Column Info */
	private String st42hOpr3 = null;
	/* Column Info */
	private String st42hOpr2 = null;
	/* Column Info */
	private String st42hOpr5 = null;
	/* Column Info */
	private String st1040Opr6 = null;
	/* Column Info */
	private String st220Opr10 = null;
	/* Column Info */
	private String st42hOpr4 = null;
	/* Column Info */
	private String st1040Opr5 = null;
	/* Column Info */
	private String st42hOpr7 = null;
	/* Column Info */
	private String st1040Opr8 = null;
	/* Column Info */
	private String st42hOpr6 = null;
	/* Column Info */
	private String st1040Opr7 = null;
	/* Column Info */
	private String st745Opr3 = null;
	/* Column Info */
	private String st745Opr2 = null;
	/* Column Info */
	private String st745Opr5 = null;
	/* Column Info */
	private String st745Opr4 = null;
	/* Column Info */
	private String st745Opr7 = null;
	/* Column Info */
	private String st745Opr6 = null;
	/* Column Info */
	private String st745Opr9 = null;
	/* Column Info */
	private String st745Opr8 = null;
	/* Column Info */
	private String st42hOpr8 = null;
	/* Column Info */
	private String st42hOpr9 = null;
	/* Column Info */
	private String st745Opr1 = null;
	/* Column Info */
	private String st114hOpr10 = null;
	/* Column Info */
	private String st140Opr6 = null;
	/* Column Info */
	private String st140Opr5 = null;
	/* Column Info */
	private String st140Opr8 = null;
	/* Column Info */
	private String st140Opr7 = null;
	/* Column Info */
	private String st140Opr9 = null;
	/* Column Info */
	private String st142hOpr10 = null;
	/* Column Info */
	private String st140Opr1 = null;
	/* Column Info */
	private String st140Opr2 = null;
	/* Column Info */
	private String st140Opr3 = null;
	/* Column Info */
	private String st54hOpr10 = null;
	/* Column Info */
	private String st140Opr4 = null;
	/* Column Info */
	private String podYdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CBFSpecialStwgVO() {}

//	public CBFSpecialStwgVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String ydCd, String pod, String podCd, String crrCd, String oprCd, String mlb, String mlbCd, String stwgCd, String dcgoFlg, String rcFlg, String awkCgoFlg, String bbCgoFlg, String stwgCgoFlg, String allFlg, String bkgShprOwnrFlg, String opr1, String opr2, String opr3, String opr4, String opr5, String opr6, String opr7, String opr8, String opr9, String opr10, String qty1, String qty2, String qty3, String qty4, String qty5, String qty6, String qty7, String qty8, String qty9, String qty10, String st1, String st2, String st3, String st4, String st5, String st6, String st7, String st8, String st9, String st10, String st11, String st12, String st13, String st14, String st15, String st120Opr1, String st12hOpr1, String st140Opr1, String st14hOpr1, String st145Opr1, String st220Opr1, String st22hOpr1, String st240Opr1, String st24hOpr1, String st245Opr1, String st320Opr1, String st32hOpr1, String st340Opr1, String st34hOpr1, String st345Opr1, String st420Opr1, String st42hOpr1, String st440Opr1, String st44hOpr1, String st445Opr1, String st520Opr1, String st52hOpr1, String st540Opr1, String st54hOpr1, String st545Opr1, String st620Opr1, String st62hOpr1, String st640Opr1, String st64hOpr1, String st645Opr1, String st720Opr1, String st72hOpr1, String st740Opr1, String st74hOpr1, String st745Opr1, String st820Opr1, String st82hOpr1, String st840Opr1, String st84hOpr1, String st845Opr1, String st920Opr1, String st92hOpr1, String st940Opr1, String st94hOpr1, String st945Opr1, String st1020Opr1, String st102hOpr1, String st1040Opr1, String st104hOpr1, String st1045Opr1, String st1120Opr1, String st112hOpr1, String st1140Opr1, String st114hOpr1, String st1145Opr1, String st1220Opr1, String st122hOpr1, String st1240Opr1, String st124hOpr1, String st1245Opr1, String st1320Opr1, String st132hOpr1, String st1340Opr1, String st134hOpr1, String st1345Opr1, String st1420Opr1, String st142hOpr1, String st1440Opr1, String st144hOpr1, String st1445Opr1, String st1520Opr1, String st152hOpr1, String st1540Opr1, String st154hOpr1, String st1545Opr1, String st120Opr2, String st12hOpr2, String st140Opr2, String st14hOpr2, String st145Opr2, String st220Opr2, String st22hOpr2, String st240Opr2, String st24hOpr2, String st245Opr2, String st320Opr2, String st32hOpr2, String st340Opr2, String st34hOpr2, String st345Opr2, String st420Opr2, String st42hOpr2, String st440Opr2, String st44hOpr2, String st445Opr2, String st520Opr2, String st52hOpr2, String st540Opr2, String st54hOpr2, String st545Opr2, String st620Opr2, String st62hOpr2, String st640Opr2, String st64hOpr2, String st645Opr2, String st720Opr2, String st72hOpr2, String st740Opr2, String st74hOpr2, String st745Opr2, String st820Opr2, String st82hOpr2, String st840Opr2, String st84hOpr2, String st845Opr2, String st920Opr2, String st92hOpr2, String st940Opr2, String st94hOpr2, String st945Opr2, String st1020Opr2, String st102hOpr2, String st1040Opr2, String st104hOpr2, String st1045Opr2, String st1120Opr2, String st112hOpr2, String st1140Opr2, String st114hOpr2, String st1145Opr2, String st1220Opr2, String st122hOpr2, String st1240Opr2, String st124hOpr2, String st1245Opr2, String st1320Opr2, String st132hOpr2, String st1340Opr2, String st134hOpr2, String st1345Opr2, String st1420Opr2, String st142hOpr2, String st1440Opr2, String st144hOpr2, String st1445Opr2, String st1520Opr2, String st152hOpr2, String st1540Opr2, String st154hOpr2, String st1545Opr2, String st120Opr3, String st12hOpr3, String st140Opr3, String st14hOpr3, String st145Opr3, String st220Opr3, String st22hOpr3, String st240Opr3, String st24hOpr3, String st245Opr3, String st320Opr3, String st32hOpr3, String st340Opr3, String st34hOpr3, String st345Opr3, String st420Opr3, String st42hOpr3, String st440Opr3, String st44hOpr3, String st445Opr3, String st520Opr3, String st52hOpr3, String st540Opr3, String st54hOpr3, String st545Opr3, String st620Opr3, String st62hOpr3, String st640Opr3, String st64hOpr3, String st645Opr3, String st720Opr3, String st72hOpr3, String st740Opr3, String st74hOpr3, String st745Opr3, String st820Opr3, String st82hOpr3, String st840Opr3, String st84hOpr3, String st845Opr3, String st920Opr3, String st92hOpr3, String st940Opr3, String st94hOpr3, String st945Opr3, String st1020Opr3, String st102hOpr3, String st1040Opr3, String st104hOpr3, String st1045Opr3, String st1120Opr3, String st112hOpr3, String st1140Opr3, String st114hOpr3, String st1145Opr3, String st1220Opr3, String st122hOpr3, String st1240Opr3, String st124hOpr3, String st1245Opr3, String st1320Opr3, String st132hOpr3, String st1340Opr3, String st134hOpr3, String st1345Opr3, String st1420Opr3, String st142hOpr3, String st1440Opr3, String st144hOpr3, String st1445Opr3, String st1520Opr3, String st152hOpr3, String st1540Opr3, String st154hOpr3, String st1545Opr3, String st120Opr4, String st12hOpr4, String st140Opr4, String st14hOpr4, String st145Opr4, String st220Opr4, String st22hOpr4, String st240Opr4, String st24hOpr4, String st245Opr4, String st320Opr4, String st32hOpr4, String st340Opr4, String st34hOpr4, String st345Opr4, String st420Opr4, String st42hOpr4, String st440Opr4, String st44hOpr4, String st445Opr4, String st520Opr4, String st52hOpr4, String st540Opr4, String st54hOpr4, String st545Opr4, String st620Opr4, String st62hOpr4, String st640Opr4, String st64hOpr4, String st645Opr4, String st720Opr4, String st72hOpr4, String st740Opr4, String st74hOpr4, String st745Opr4, String st820Opr4, String st82hOpr4, String st840Opr4, String st84hOpr4, String st845Opr4, String st920Opr4, String st92hOpr4, String st940Opr4, String st94hOpr4, String st945Opr4, String st1020Opr4, String st102hOpr4, String st1040Opr4, String st104hOpr4, String st1045Opr4, String st1120Opr4, String st112hOpr4, String st1140Opr4, String st114hOpr4, String st1145Opr4, String st1220Opr4, String st122hOpr4, String st1240Opr4, String st124hOpr4, String st1245Opr4, String st1320Opr4, String st132hOpr4, String st1340Opr4, String st134hOpr4, String st1345Opr4, String st1420Opr4, String st142hOpr4, String st1440Opr4, String st144hOpr4, String st1445Opr4, String st1520Opr4, String st152hOpr4, String st1540Opr4, String st154hOpr4, String st1545Opr4, String st120Opr5, String st12hOpr5, String st140Opr5, String st14hOpr5, String st145Opr5, String st220Opr5, String st22hOpr5, String st240Opr5, String st24hOpr5, String st245Opr5, String st320Opr5, String st32hOpr5, String st340Opr5, String st34hOpr5, String st345Opr5, String st420Opr5, String st42hOpr5, String st440Opr5, String st44hOpr5, String st445Opr5, String st520Opr5, String st52hOpr5, String st540Opr5, String st54hOpr5, String st545Opr5, String st620Opr5, String st62hOpr5, String st640Opr5, String st64hOpr5, String st645Opr5, String st720Opr5, String st72hOpr5, String st740Opr5, String st74hOpr5, String st745Opr5, String st820Opr5, String st82hOpr5, String st840Opr5, String st84hOpr5, String st845Opr5, String st920Opr5, String st92hOpr5, String st940Opr5, String st94hOpr5, String st945Opr5, String st1020Opr5, String st102hOpr5, String st1040Opr5, String st104hOpr5, String st1045Opr5, String st1120Opr5, String st112hOpr5, String st1140Opr5, String st114hOpr5, String st1145Opr5, String st1220Opr5, String st122hOpr5, String st1240Opr5, String st124hOpr5, String st1245Opr5, String st1320Opr5, String st132hOpr5, String st1340Opr5, String st134hOpr5, String st1345Opr5, String st1420Opr5, String st142hOpr5, String st1440Opr5, String st144hOpr5, String st1445Opr5, String st1520Opr5, String st152hOpr5, String st1540Opr5, String st154hOpr5, String st1545Opr5, String st120Opr6, String st12hOpr6, String st140Opr6, String st14hOpr6, String st145Opr6, String st220Opr6, String st22hOpr6, String st240Opr6, String st24hOpr6, String st245Opr6, String st320Opr6, String st32hOpr6, String st340Opr6, String st34hOpr6, String st345Opr6, String st420Opr6, String st42hOpr6, String st440Opr6, String st44hOpr6, String st445Opr6, String st520Opr6, String st52hOpr6, String st540Opr6, String st54hOpr6, String st545Opr6, String st620Opr6, String st62hOpr6, String st640Opr6, String st64hOpr6, String st645Opr6, String st720Opr6, String st72hOpr6, String st740Opr6, String st74hOpr6, String st745Opr6, String st820Opr6, String st82hOpr6, String st840Opr6, String st84hOpr6, String st845Opr6, String st920Opr6, String st92hOpr6, String st940Opr6, String st94hOpr6, String st945Opr6, String st1020Opr6, String st102hOpr6, String st1040Opr6, String st104hOpr6, String st1045Opr6, String st1120Opr6, String st112hOpr6, String st1140Opr6, String st114hOpr6, String st1145Opr6, String st1220Opr6, String st122hOpr6, String st1240Opr6, String st124hOpr6, String st1245Opr6, String st1320Opr6, String st132hOpr6, String st1340Opr6, String st134hOpr6, String st1345Opr6, String st1420Opr6, String st142hOpr6, String st1440Opr6, String st144hOpr6, String st1445Opr6, String st1520Opr6, String st152hOpr6, String st1540Opr6, String st154hOpr6, String st1545Opr6, String st120Opr7, String st12hOpr7, String st140Opr7, String st14hOpr7, String st145Opr7, String st220Opr7, String st22hOpr7, String st240Opr7, String st24hOpr7, String st245Opr7, String st320Opr7, String st32hOpr7, String st340Opr7, String st34hOpr7, String st345Opr7, String st420Opr7, String st42hOpr7, String st440Opr7, String st44hOpr7, String st445Opr7, String st520Opr7, String st52hOpr7, String st540Opr7, String st54hOpr7, String st545Opr7, String st620Opr7, String st62hOpr7, String st640Opr7, String st64hOpr7, String st645Opr7, String st720Opr7, String st72hOpr7, String st740Opr7, String st74hOpr7, String st745Opr7, String st820Opr7, String st82hOpr7, String st840Opr7, String st84hOpr7, String st845Opr7, String st920Opr7, String st92hOpr7, String st940Opr7, String st94hOpr7, String st945Opr7, String st1020Opr7, String st102hOpr7, String st1040Opr7, String st104hOpr7, String st1045Opr7, String st1120Opr7, String st112hOpr7, String st1140Opr7, String st114hOpr7, String st1145Opr7, String st1220Opr7, String st122hOpr7, String st1240Opr7, String st124hOpr7, String st1245Opr7, String st1320Opr7, String st132hOpr7, String st1340Opr7, String st134hOpr7, String st1345Opr7, String st1420Opr7, String st142hOpr7, String st1440Opr7, String st144hOpr7, String st1445Opr7, String st1520Opr7, String st152hOpr7, String st1540Opr7, String st154hOpr7, String st1545Opr7, String st120Opr8, String st12hOpr8, String st140Opr8, String st14hOpr8, String st145Opr8, String st220Opr8, String st22hOpr8, String st240Opr8, String st24hOpr8, String st245Opr8, String st320Opr8, String st32hOpr8, String st340Opr8, String st34hOpr8, String st345Opr8, String st420Opr8, String st42hOpr8, String st440Opr8, String st44hOpr8, String st445Opr8, String st520Opr8, String st52hOpr8, String st540Opr8, String st54hOpr8, String st545Opr8, String st620Opr8, String st62hOpr8, String st640Opr8, String st64hOpr8, String st645Opr8, String st720Opr8, String st72hOpr8, String st740Opr8, String st74hOpr8, String st745Opr8, String st820Opr8, String st82hOpr8, String st840Opr8, String st84hOpr8, String st845Opr8, String st920Opr8, String st92hOpr8, String st940Opr8, String st94hOpr8, String st945Opr8, String st1020Opr8, String st102hOpr8, String st1040Opr8, String st104hOpr8, String st1045Opr8, String st1120Opr8, String st112hOpr8, String st1140Opr8, String st114hOpr8, String st1145Opr8, String st1220Opr8, String st122hOpr8, String st1240Opr8, String st124hOpr8, String st1245Opr8, String st1320Opr8, String st132hOpr8, String st1340Opr8, String st134hOpr8, String st1345Opr8, String st1420Opr8, String st142hOpr8, String st1440Opr8, String st144hOpr8, String st1445Opr8, String st1520Opr8, String st152hOpr8, String st1540Opr8, String st154hOpr8, String st1545Opr8, String st120Opr9, String st12hOpr9, String st140Opr9, String st14hOpr9, String st145Opr9, String st220Opr9, String st22hOpr9, String st240Opr9, String st24hOpr9, String st245Opr9, String st320Opr9, String st32hOpr9, String st340Opr9, String st34hOpr9, String st345Opr9, String st420Opr9, String st42hOpr9, String st440Opr9, String st44hOpr9, String st445Opr9, String st520Opr9, String st52hOpr9, String st540Opr9, String st54hOpr9, String st545Opr9, String st620Opr9, String st62hOpr9, String st640Opr9, String st64hOpr9, String st645Opr9, String st720Opr9, String st72hOpr9, String st740Opr9, String st74hOpr9, String st745Opr9, String st820Opr9, String st82hOpr9, String st840Opr9, String st84hOpr9, String st845Opr9, String st920Opr9, String st92hOpr9, String st940Opr9, String st94hOpr9, String st945Opr9, String st1020Opr9, String st102hOpr9, String st1040Opr9, String st104hOpr9, String st1045Opr9, String st1120Opr9, String st112hOpr9, String st1140Opr9, String st114hOpr9, String st1145Opr9, String st1220Opr9, String st122hOpr9, String st1240Opr9, String st124hOpr9, String st1245Opr9, String st1320Opr9, String st132hOpr9, String st1340Opr9, String st134hOpr9, String st1345Opr9, String st1420Opr9, String st142hOpr9, String st1440Opr9, String st144hOpr9, String st1445Opr9, String st1520Opr9, String st152hOpr9, String st1540Opr9, String st154hOpr9, String st1545Opr9, String st120Opr10, String st12hOpr10, String st140Opr10, String st14hOpr10, String st145Opr10, String st220Opr10, String st22hOpr10, String st240Opr10, String st24hOpr10, String st245Opr10, String st320Opr10, String st32hOpr10, String st340Opr10, String st34hOpr10, String st345Opr10, String st420Opr10, String st42hOpr10, String st440Opr10, String st44hOpr10, String st445Opr10, String st520Opr10, String st52hOpr10, String st540Opr10, String st54hOpr10, String st545Opr10, String st620Opr10, String st62hOpr10, String st640Opr10, String st64hOpr10, String st645Opr10, String st720Opr10, String st72hOpr10, String st740Opr10, String st74hOpr10, String st745Opr10, String st820Opr10, String st82hOpr10, String st840Opr10, String st84hOpr10, String st845Opr10, String st920Opr10, String st92hOpr10, String st940Opr10, String st94hOpr10, String st945Opr10, String st1020Opr10, String st102hOpr10, String st1040Opr10, String st104hOpr10, String st1045Opr10, String st1120Opr10, String st112hOpr10, String st1140Opr10, String st114hOpr10, String st1145Opr10, String st1220Opr10, String st122hOpr10, String st1240Opr10, String st124hOpr10, String st1245Opr10, String st1320Opr10, String st132hOpr10, String st1340Opr10, String st134hOpr10, String st1345Opr10, String st1420Opr10, String st142hOpr10, String st1440Opr10, String st144hOpr10, String st1445Opr10, String st1520Opr10, String st152hOpr10, String st1540Opr10, String st154hOpr10, String st1545Opr10) {
//		this.st720Opr10 = st720Opr10;
//		this.st740Opr7 = st740Opr7;
//		this.st1445Opr10 = st1445Opr10;
//		this.st740Opr8 = st740Opr8;
//		this.st740Opr9 = st740Opr9;
//		this.st140Opr10 = st140Opr10;
//		this.skdVoyNo = skdVoyNo;
//		this.st740Opr1 = st740Opr1;
//		this.st740Opr2 = st740Opr2;
//		this.st740Opr3 = st740Opr3;
//		this.st740Opr4 = st740Opr4;
//		this.st740Opr5 = st740Opr5;
//		this.st740Opr6 = st740Opr6;
//		this.oprCd = oprCd;
//		this.st145Opr10 = st145Opr10;
//		this.st1545Opr10 = st1545Opr10;
//		this.st640Opr10 = st640Opr10;
//		this.st1340Opr10 = st1340Opr10;
//		this.st520Opr10 = st520Opr10;
//		this.st154hOpr10 = st154hOpr10;
//		this.st82hOpr10 = st82hOpr10;
//		this.st845Opr10 = st845Opr10;
//		this.st645Opr3 = st645Opr3;
//		this.st645Opr4 = st645Opr4;
//		this.st645Opr5 = st645Opr5;
//		this.st545Opr8 = st545Opr8;
//		this.st645Opr6 = st645Opr6;
//		this.st545Opr9 = st545Opr9;
//		this.st545Opr6 = st545Opr6;
//		this.st645Opr7 = st645Opr7;
//		this.st545Opr7 = st545Opr7;
//		this.st645Opr8 = st645Opr8;
//		this.st545Opr4 = st545Opr4;
//		this.st645Opr9 = st645Opr9;
//		this.st545Opr5 = st545Opr5;
//		this.st545Opr2 = st545Opr2;
//		this.st545Opr3 = st545Opr3;
//		this.st1145Opr10 = st1145Opr10;
//		this.st545Opr1 = st545Opr1;
//		this.st645Opr1 = st645Opr1;
//		this.st645Opr2 = st645Opr2;
//		this.st114hOpr8 = st114hOpr8;
//		this.st114hOpr9 = st114hOpr9;
//		this.st114hOpr4 = st114hOpr4;
//		this.st114hOpr5 = st114hOpr5;
//		this.st114hOpr6 = st114hOpr6;
//		this.st114hOpr7 = st114hOpr7;
//		this.st114hOpr1 = st114hOpr1;
//		this.st114hOpr2 = st114hOpr2;
//		this.st114hOpr3 = st114hOpr3;
//		this.podCd = podCd;
//		this.st745Opr10 = st745Opr10;
//		this.st1320Opr10 = st1320Opr10;
//		this.st122hOpr1 = st122hOpr1;
//		this.st122hOpr2 = st122hOpr2;
//		this.st122hOpr3 = st122hOpr3;
//		this.st122hOpr4 = st122hOpr4;
//		this.st122hOpr5 = st122hOpr5;
//		this.st122hOpr6 = st122hOpr6;
//		this.st122hOpr7 = st122hOpr7;
//		this.st122hOpr8 = st122hOpr8;
//		this.st845Opr5 = st845Opr5;
//		this.st104hOpr6 = st104hOpr6;
//		this.st1445Opr9 = st1445Opr9;
//		this.st104hOpr5 = st104hOpr5;
//		this.st845Opr6 = st845Opr6;
//		this.st1445Opr8 = st1445Opr8;
//		this.st1145Opr1 = st1145Opr1;
//		this.st845Opr7 = st845Opr7;
//		this.st104hOpr8 = st104hOpr8;
//		this.st1145Opr2 = st1145Opr2;
//		this.st104hOpr7 = st104hOpr7;
//		this.st845Opr8 = st845Opr8;
//		this.st1145Opr3 = st1145Opr3;
//		this.st845Opr1 = st845Opr1;
//		this.st1445Opr5 = st1445Opr5;
//		this.st1445Opr4 = st1445Opr4;
//		this.st1145Opr4 = st1145Opr4;
//		this.st845Opr2 = st845Opr2;
//		this.st104hOpr9 = st104hOpr9;
//		this.st845Opr3 = st845Opr3;
//		this.st1145Opr5 = st1145Opr5;
//		this.st1445Opr7 = st1445Opr7;
//		this.st845Opr4 = st845Opr4;
//		this.st1145Opr6 = st1145Opr6;
//		this.st1445Opr6 = st1445Opr6;
//		this.st1445Opr1 = st1445Opr1;
//		this.st1145Opr7 = st1145Opr7;
//		this.st1145Opr8 = st1145Opr8;
//		this.st1445Opr3 = st1445Opr3;
//		this.st1145Opr9 = st1145Opr9;
//		this.st1445Opr2 = st1445Opr2;
//		this.st104hOpr2 = st104hOpr2;
//		this.st104hOpr1 = st104hOpr1;
//		this.st104hOpr4 = st104hOpr4;
//		this.st104hOpr3 = st104hOpr3;
//		this.st845Opr9 = st845Opr9;
//		this.st34hOpr2 = st34hOpr2;
//		this.st34hOpr1 = st34hOpr1;
//		this.st34hOpr4 = st34hOpr4;
//		this.st34hOpr3 = st34hOpr3;
//		this.st34hOpr6 = st34hOpr6;
//		this.st34hOpr5 = st34hOpr5;
//		this.st34hOpr8 = st34hOpr8;
//		this.st34hOpr7 = st34hOpr7;
//		this.st34hOpr9 = st34hOpr9;
//		this.st1345Opr3 = st1345Opr3;
//		this.st1345Opr4 = st1345Opr4;
//		this.st1345Opr1 = st1345Opr1;
//		this.st1345Opr2 = st1345Opr2;
//		this.st1345Opr9 = st1345Opr9;
//		this.st1345Opr7 = st1345Opr7;
//		this.st1345Opr8 = st1345Opr8;
//		this.st1345Opr5 = st1345Opr5;
//		this.st1345Opr6 = st1345Opr6;
//		this.st12hOpr10 = st12hOpr10;
//		this.dcgoFlg = dcgoFlg;
//		this.st545Opr10 = st545Opr10;
//		this.st152hOpr8 = st152hOpr8;
//		this.st152hOpr9 = st152hOpr9;
//		this.st152hOpr6 = st152hOpr6;
//		this.st152hOpr7 = st152hOpr7;
//		this.st1140Opr1 = st1140Opr1;
//		this.st1140Opr2 = st1140Opr2;
//		this.st1140Opr3 = st1140Opr3;
//		this.pod = pod;
//		this.st1420Opr10 = st1420Opr10;
//		this.st142hOpr8 = st142hOpr8;
//		this.st142hOpr7 = st142hOpr7;
//		this.st142hOpr9 = st142hOpr9;
//		this.st74hOpr9 = st74hOpr9;
//		this.st74hOpr7 = st74hOpr7;
//		this.st74hOpr8 = st74hOpr8;
//		this.st74hOpr6 = st74hOpr6;
//		this.st1220Opr9 = st1220Opr9;
//		this.st74hOpr5 = st74hOpr5;
//		this.st74hOpr4 = st74hOpr4;
//		this.st74hOpr3 = st74hOpr3;
//		this.st74hOpr2 = st74hOpr2;
//		this.st74hOpr1 = st74hOpr1;
//		this.opr10 = opr10;
//		this.st1220Opr1 = st1220Opr1;
//		this.st1220Opr2 = st1220Opr2;
//		this.st1220Opr3 = st1220Opr3;
//		this.st1220Opr4 = st1220Opr4;
//		this.st1220Opr5 = st1220Opr5;
//		this.st1220Opr6 = st1220Opr6;
//		this.st1220Opr7 = st1220Opr7;
//		this.st124hOpr10 = st124hOpr10;
//		this.st1220Opr8 = st1220Opr8;
//		this.st82hOpr7 = st82hOpr7;
//		this.st82hOpr6 = st82hOpr6;
//		this.st82hOpr5 = st82hOpr5;
//		this.st82hOpr4 = st82hOpr4;
//		this.st82hOpr9 = st82hOpr9;
//		this.st82hOpr8 = st82hOpr8;
//		this.st82hOpr2 = st82hOpr2;
//		this.st82hOpr3 = st82hOpr3;
//		this.st82hOpr1 = st82hOpr1;
//		this.st92hOpr3 = st92hOpr3;
//		this.st92hOpr4 = st92hOpr4;
//		this.st92hOpr5 = st92hOpr5;
//		this.st92hOpr6 = st92hOpr6;
//		this.st92hOpr7 = st92hOpr7;
//		this.st92hOpr8 = st92hOpr8;
//		this.st92hOpr9 = st92hOpr9;
//		this.st1020Opr10 = st1020Opr10;
//		this.st1140Opr9 = st1140Opr9;
//		this.st1140Opr8 = st1140Opr8;
//		this.st1140Opr7 = st1140Opr7;
//		this.st1140Opr6 = st1140Opr6;
//		this.st1140Opr5 = st1140Opr5;
//		this.st1140Opr4 = st1140Opr4;
//		this.st245Opr3 = st245Opr3;
//		this.st245Opr4 = st245Opr4;
//		this.st740Opr10 = st740Opr10;
//		this.st245Opr5 = st245Opr5;
//		this.st152hOpr1 = st152hOpr1;
//		this.st245Opr6 = st245Opr6;
//		this.st152hOpr3 = st152hOpr3;
//		this.st152hOpr2 = st152hOpr2;
//		this.ydCd = ydCd;
//		this.st245Opr1 = st245Opr1;
//		this.st152hOpr5 = st152hOpr5;
//		this.st152hOpr4 = st152hOpr4;
//		this.st245Opr2 = st245Opr2;
//		this.st245Opr7 = st245Opr7;
//		this.st920Opr10 = st920Opr10;
//		this.st245Opr8 = st245Opr8;
//		this.st92hOpr2 = st92hOpr2;
//		this.st245Opr9 = st245Opr9;
//		this.st92hOpr1 = st92hOpr1;
//		this.st52hOpr2 = st52hOpr2;
//		this.st52hOpr1 = st52hOpr1;
//		this.st52hOpr6 = st52hOpr6;
//		this.st52hOpr5 = st52hOpr5;
//		this.st52hOpr4 = st52hOpr4;
//		this.st52hOpr3 = st52hOpr3;
//		this.st144hOpr10 = st144hOpr10;
//		this.crrCd = crrCd;
//		this.st52hOpr9 = st52hOpr9;
//		this.st52hOpr7 = st52hOpr7;
//		this.st52hOpr8 = st52hOpr8;
//		this.st122hOpr9 = st122hOpr9;
//		this.st124hOpr4 = st124hOpr4;
//		this.st940Opr2 = st940Opr2;
//		this.st124hOpr3 = st124hOpr3;
//		this.st940Opr1 = st940Opr1;
//		this.st940Opr4 = st940Opr4;
//		this.st124hOpr6 = st124hOpr6;
//		this.st940Opr3 = st940Opr3;
//		this.st124hOpr5 = st124hOpr5;
//		this.st124hOpr8 = st124hOpr8;
//		this.st124hOpr7 = st124hOpr7;
//		this.st245Opr10 = st245Opr10;
//		this.st124hOpr9 = st124hOpr9;
//		this.st940Opr9 = st940Opr9;
//		this.st940Opr6 = st940Opr6;
//		this.st940Opr5 = st940Opr5;
//		this.st124hOpr2 = st124hOpr2;
//		this.st940Opr8 = st940Opr8;
//		this.st32hOpr10 = st32hOpr10;
//		this.st124hOpr1 = st124hOpr1;
//		this.st940Opr7 = st940Opr7;
//		this.st142hOpr6 = st142hOpr6;
//		this.st142hOpr5 = st142hOpr5;
//		this.st142hOpr4 = st142hOpr4;
//		this.st142hOpr3 = st142hOpr3;
//		this.st142hOpr2 = st142hOpr2;
//		this.st142hOpr1 = st142hOpr1;
//		this.st94hOpr1 = st94hOpr1;
//		this.st94hOpr2 = st94hOpr2;
//		this.st94hOpr3 = st94hOpr3;
//		this.st94hOpr4 = st94hOpr4;
//		this.st1520Opr1 = st1520Opr1;
//		this.st94hOpr9 = st94hOpr9;
//		this.st112hOpr1 = st112hOpr1;
//		this.st1520Opr5 = st1520Opr5;
//		this.st94hOpr6 = st94hOpr6;
//		this.st1520Opr4 = st1520Opr4;
//		this.st94hOpr5 = st94hOpr5;
//		this.st1520Opr3 = st1520Opr3;
//		this.st94hOpr8 = st94hOpr8;
//		this.st1520Opr2 = st1520Opr2;
//		this.st94hOpr7 = st94hOpr7;
//		this.st112hOpr6 = st112hOpr6;
//		this.st1520Opr9 = st1520Opr9;
//		this.st112hOpr7 = st112hOpr7;
//		this.st1520Opr8 = st1520Opr8;
//		this.st1520Opr7 = st1520Opr7;
//		this.st112hOpr8 = st112hOpr8;
//		this.st1520Opr6 = st1520Opr6;
//		this.st112hOpr9 = st112hOpr9;
//		this.st112hOpr2 = st112hOpr2;
//		this.st112hOpr3 = st112hOpr3;
//		this.st340Opr10 = st340Opr10;
//		this.st112hOpr4 = st112hOpr4;
//		this.st112hOpr5 = st112hOpr5;
//		this.st1120Opr7 = st1120Opr7;
//		this.st1120Opr6 = st1120Opr6;
//		this.st1120Opr9 = st1120Opr9;
//		this.st1120Opr8 = st1120Opr8;
//		this.st1120Opr3 = st1120Opr3;
//		this.st1120Opr2 = st1120Opr2;
//		this.st1120Opr5 = st1120Opr5;
//		this.st1120Opr4 = st1120Opr4;
//		this.st132hOpr4 = st132hOpr4;
//		this.st132hOpr5 = st132hOpr5;
//		this.st132hOpr6 = st132hOpr6;
//		this.st132hOpr7 = st132hOpr7;
//		this.st132hOpr1 = st132hOpr1;
//		this.st132hOpr2 = st132hOpr2;
//		this.st132hOpr3 = st132hOpr3;
//		this.st24hOpr10 = st24hOpr10;
//		this.st345Opr10 = st345Opr10;
//		this.qty1 = qty1;
//		this.qty3 = qty3;
//		this.qty2 = qty2;
//		this.qty5 = qty5;
//		this.qty4 = qty4;
//		this.st720Opr7 = st720Opr7;
//		this.st720Opr8 = st720Opr8;
//		this.st720Opr5 = st720Opr5;
//		this.st720Opr6 = st720Opr6;
//		this.st720Opr9 = st720Opr9;
//		this.st34hOpr10 = st34hOpr10;
//		this.st62hOpr10 = st62hOpr10;
//		this.st1440Opr10 = st1440Opr10;
//		this.st720Opr3 = st720Opr3;
//		this.st720Opr4 = st720Opr4;
//		this.st720Opr1 = st720Opr1;
//		this.st720Opr2 = st720Opr2;
//		this.st1045Opr10 = st1045Opr10;
//		this.st1540Opr1 = st1540Opr1;
//		this.st1540Opr2 = st1540Opr2;
//		this.st1540Opr3 = st1540Opr3;
//		this.st1540Opr4 = st1540Opr4;
//		this.st1540Opr5 = st1540Opr5;
//		this.st1540Opr6 = st1540Opr6;
//		this.st1540Opr7 = st1540Opr7;
//		this.st1540Opr8 = st1540Opr8;
//		this.st1540Opr9 = st1540Opr9;
//		this.qty8 = qty8;
//		this.st1545Opr1 = st1545Opr1;
//		this.st1545Opr2 = st1545Opr2;
//		this.qty9 = qty9;
//		this.qty6 = qty6;
//		this.st420Opr10 = st420Opr10;
//		this.qty7 = qty7;
//		this.st1545Opr5 = st1545Opr5;
//		this.st1545Opr6 = st1545Opr6;
//		this.st1545Opr3 = st1545Opr3;
//		this.st1545Opr4 = st1545Opr4;
//		this.st1545Opr9 = st1545Opr9;
//		this.st1545Opr7 = st1545Opr7;
//		this.st1545Opr8 = st1545Opr8;
//		this.st1320Opr1 = st1320Opr1;
//		this.st1320Opr3 = st1320Opr3;
//		this.st132hOpr9 = st132hOpr9;
//		this.st1320Opr2 = st1320Opr2;
//		this.st132hOpr8 = st132hOpr8;
//		this.st1320Opr5 = st1320Opr5;
//		this.st1320Opr4 = st1320Opr4;
//		this.st1320Opr7 = st1320Opr7;
//		this.st1320Opr6 = st1320Opr6;
//		this.st1320Opr9 = st1320Opr9;
//		this.st1320Opr8 = st1320Opr8;
//		this.st340Opr1 = st340Opr1;
//		this.st340Opr2 = st340Opr2;
//		this.st340Opr9 = st340Opr9;
//		this.st340Opr8 = st340Opr8;
//		this.st340Opr7 = st340Opr7;
//		this.st340Opr6 = st340Opr6;
//		this.st340Opr5 = st340Opr5;
//		this.st340Opr4 = st340Opr4;
//		this.st340Opr3 = st340Opr3;
//		this.allFlg = allFlg;
//		this.st445Opr10 = st445Opr10;
//		this.st120Opr1 = st120Opr1;
//		this.st120Opr2 = st120Opr2;
//		this.st120Opr10 = st120Opr10;
//		this.st132hOpr10 = st132hOpr10;
//		this.st120Opr4 = st120Opr4;
//		this.st120Opr3 = st120Opr3;
//		this.st120Opr6 = st120Opr6;
//		this.st120Opr5 = st120Opr5;
//		this.st120Opr8 = st120Opr8;
//		this.st120Opr7 = st120Opr7;
//		this.st120Opr9 = st120Opr9;
//		this.st1040Opr10 = st1040Opr10;
//		this.st92hOpr10 = st92hOpr10;
//		this.st1045Opr5 = st1045Opr5;
//		this.st1045Opr4 = st1045Opr4;
//		this.st1045Opr7 = st1045Opr7;
//		this.st1045Opr6 = st1045Opr6;
//		this.st1045Opr1 = st1045Opr1;
//		this.st540Opr10 = st540Opr10;
//		this.st1045Opr3 = st1045Opr3;
//		this.bbCgoFlg = bbCgoFlg;
//		this.st1045Opr2 = st1045Opr2;
//		this.st1045Opr9 = st1045Opr9;
//		this.st1045Opr8 = st1045Opr8;
//		this.mlbCd = mlbCd;
//		this.st1520Opr10 = st1520Opr10;
//		this.st345Opr7 = st345Opr7;
//		this.st345Opr6 = st345Opr6;
//		this.st345Opr9 = st345Opr9;
//		this.st345Opr8 = st345Opr8;
//		this.st1120Opr1 = st1120Opr1;
//		this.st345Opr1 = st345Opr1;
//		this.st345Opr3 = st345Opr3;
//		this.st345Opr2 = st345Opr2;
//		this.st345Opr5 = st345Opr5;
//		this.st345Opr4 = st345Opr4;
//		this.st12hOpr2 = st12hOpr2;
//		this.st12hOpr1 = st12hOpr1;
//		this.st1340Opr1 = st1340Opr1;
//		this.st12hOpr8 = st12hOpr8;
//		this.st12hOpr7 = st12hOpr7;
//		this.st12hOpr9 = st12hOpr9;
//		this.st12hOpr4 = st12hOpr4;
//		this.st12hOpr3 = st12hOpr3;
//		this.st12hOpr6 = st12hOpr6;
//		this.st12hOpr5 = st12hOpr5;
//		this.st1420Opr6 = st1420Opr6;
//		this.st1420Opr5 = st1420Opr5;
//		this.st1420Opr4 = st1420Opr4;
//		this.st1420Opr3 = st1420Opr3;
//		this.st1420Opr2 = st1420Opr2;
//		this.st1420Opr1 = st1420Opr1;
//		this.st1420Opr9 = st1420Opr9;
//		this.st1420Opr8 = st1420Opr8;
//		this.st1420Opr7 = st1420Opr7;
//		this.st84hOpr1 = st84hOpr1;
//		this.st84hOpr3 = st84hOpr3;
//		this.st84hOpr2 = st84hOpr2;
//		this.st84hOpr5 = st84hOpr5;
//		this.st84hOpr4 = st84hOpr4;
//		this.st152hOpr10 = st152hOpr10;
//		this.st84hOpr6 = st84hOpr6;
//		this.st84hOpr7 = st84hOpr7;
//		this.st84hOpr8 = st84hOpr8;
//		this.st84hOpr9 = st84hOpr9;
//		this.rcFlg = rcFlg;
//		this.st14hOpr10 = st14hOpr10;
//		this.st640Opr8 = st640Opr8;
//		this.st1245Opr9 = st1245Opr9;
//		this.st1245Opr8 = st1245Opr8;
//		this.st640Opr9 = st640Opr9;
//		this.st1245Opr7 = st1245Opr7;
//		this.st1245Opr6 = st1245Opr6;
//		this.st640Opr4 = st640Opr4;
//		this.st1245Opr5 = st1245Opr5;
//		this.st640Opr5 = st640Opr5;
//		this.st1245Opr4 = st1245Opr4;
//		this.st1245Opr3 = st1245Opr3;
//		this.st640Opr6 = st640Opr6;
//		this.st1245Opr2 = st1245Opr2;
//		this.st640Opr7 = st640Opr7;
//		this.st1245Opr1 = st1245Opr1;
//		this.st640Opr1 = st640Opr1;
//		this.st640Opr2 = st640Opr2;
//		this.st640Opr3 = st640Opr3;
//		this.st52hOpr10 = st52hOpr10;
//		this.st1340Opr2 = st1340Opr2;
//		this.st1340Opr3 = st1340Opr3;
//		this.st1340Opr4 = st1340Opr4;
//		this.st1340Opr5 = st1340Opr5;
//		this.st1340Opr6 = st1340Opr6;
//		this.st1340Opr7 = st1340Opr7;
//		this.st1340Opr8 = st1340Opr8;
//		this.st1340Opr9 = st1340Opr9;
//		this.st945Opr1 = st945Opr1;
//		this.st945Opr3 = st945Opr3;
//		this.st945Opr2 = st945Opr2;
//		this.st945Opr5 = st945Opr5;
//		this.st945Opr4 = st945Opr4;
//		this.st945Opr7 = st945Opr7;
//		this.st945Opr6 = st945Opr6;
//		this.st64hOpr10 = st64hOpr10;
//		this.st520Opr1 = st520Opr1;
//		this.st540Opr2 = st540Opr2;
//		this.st540Opr1 = st540Opr1;
//		this.st520Opr2 = st520Opr2;
//		this.st540Opr4 = st540Opr4;
//		this.st540Opr3 = st540Opr3;
//		this.qty10 = qty10;
//		this.st520Opr5 = st520Opr5;
//		this.st540Opr6 = st540Opr6;
//		this.st540Opr5 = st540Opr5;
//		this.st520Opr6 = st520Opr6;
//		this.st520Opr3 = st520Opr3;
//		this.st540Opr8 = st540Opr8;
//		this.st520Opr4 = st520Opr4;
//		this.st540Opr7 = st540Opr7;
//		this.st520Opr9 = st520Opr9;
//		this.st540Opr9 = st540Opr9;
//		this.st520Opr7 = st520Opr7;
//		this.st520Opr8 = st520Opr8;
//		this.st945Opr10 = st945Opr10;
//		this.st94hOpr10 = st94hOpr10;
//		this.stwgCgoFlg = stwgCgoFlg;
//		this.st1540Opr10 = st1540Opr10;
//		this.st945Opr8 = st945Opr8;
//		this.st945Opr9 = st945Opr9;
//		this.st32hOpr9 = st32hOpr9;
//		this.st24hOpr1 = st24hOpr1;
//		this.st920Opr9 = st920Opr9;
//		this.st24hOpr3 = st24hOpr3;
//		this.st920Opr8 = st920Opr8;
//		this.st24hOpr2 = st24hOpr2;
//		this.st920Opr7 = st920Opr7;
//		this.st920Opr6 = st920Opr6;
//		this.st920Opr5 = st920Opr5;
//		this.st920Opr4 = st920Opr4;
//		this.st920Opr3 = st920Opr3;
//		this.st32hOpr4 = st32hOpr4;
//		this.st920Opr2 = st920Opr2;
//		this.st24hOpr9 = st24hOpr9;
//		this.st32hOpr3 = st32hOpr3;
//		this.st920Opr1 = st920Opr1;
//		this.stwgCd = stwgCd;
//		this.st24hOpr8 = st24hOpr8;
//		this.st240Opr10 = st240Opr10;
//		this.st32hOpr2 = st32hOpr2;
//		this.st32hOpr1 = st32hOpr1;
//		this.st24hOpr5 = st24hOpr5;
//		this.st32hOpr8 = st32hOpr8;
//		this.st24hOpr4 = st24hOpr4;
//		this.st32hOpr7 = st32hOpr7;
//		this.st32hOpr6 = st32hOpr6;
//		this.st24hOpr7 = st24hOpr7;
//		this.st32hOpr5 = st32hOpr5;
//		this.st24hOpr6 = st24hOpr6;
//		this.st240Opr4 = st240Opr4;
//		this.st820Opr1 = st820Opr1;
//		this.st112hOpr10 = st112hOpr10;
//		this.st240Opr5 = st240Opr5;
//		this.st820Opr3 = st820Opr3;
//		this.st240Opr6 = st240Opr6;
//		this.st820Opr2 = st820Opr2;
//		this.st240Opr7 = st240Opr7;
//		this.st240Opr8 = st240Opr8;
//		this.st240Opr9 = st240Opr9;
//		this.st64hOpr7 = st64hOpr7;
//		this.st820Opr9 = st820Opr9;
//		this.st64hOpr6 = st64hOpr6;
//		this.st820Opr8 = st820Opr8;
//		this.st64hOpr5 = st64hOpr5;
//		this.st64hOpr4 = st64hOpr4;
//		this.st64hOpr3 = st64hOpr3;
//		this.st820Opr5 = st820Opr5;
//		this.st820Opr4 = st820Opr4;
//		this.st64hOpr2 = st64hOpr2;
//		this.st64hOpr1 = st64hOpr1;
//		this.st820Opr7 = st820Opr7;
//		this.st820Opr6 = st820Opr6;
//		this.st445Opr1 = st445Opr1;
//		this.st445Opr2 = st445Opr2;
//		this.st445Opr3 = st445Opr3;
//		this.st64hOpr8 = st64hOpr8;
//		this.st445Opr4 = st445Opr4;
//		this.st64hOpr9 = st64hOpr9;
//		this.st445Opr5 = st445Opr5;
//		this.st445Opr6 = st445Opr6;
//		this.st445Opr7 = st445Opr7;
//		this.st445Opr8 = st445Opr8;
//		this.st240Opr1 = st240Opr1;
//		this.st445Opr9 = st445Opr9;
//		this.st240Opr3 = st240Opr3;
//		this.st240Opr2 = st240Opr2;
//		this.st9 = st9;
//		this.st7 = st7;
//		this.st8 = st8;
//		this.st5 = st5;
//		this.st6 = st6;
//		this.st3 = st3;
//		this.st4 = st4;
//		this.st1 = st1;
//		this.st2 = st2;
//		this.st940Opr10 = st940Opr10;
//		this.st1220Opr10 = st1220Opr10;
//		this.vslCd = vslCd;
//		this.st320Opr9 = st320Opr9;
//		this.st320Opr8 = st320Opr8;
//		this.st320Opr7 = st320Opr7;
//		this.st320Opr6 = st320Opr6;
//		this.st320Opr5 = st320Opr5;
//		this.st42hOpr10 = st42hOpr10;
//		this.st320Opr4 = st320Opr4;
//		this.st320Opr3 = st320Opr3;
//		this.st320Opr2 = st320Opr2;
//		this.st320Opr1 = st320Opr1;
//		this.st144hOpr9 = st144hOpr9;
//		this.st645Opr10 = st645Opr10;
//		this.st22hOpr1 = st22hOpr1;
//		this.st22hOpr8 = st22hOpr8;
//		this.st22hOpr9 = st22hOpr9;
//		this.st22hOpr6 = st22hOpr6;
//		this.st22hOpr7 = st22hOpr7;
//		this.st122hOpr10 = st122hOpr10;
//		this.st104hOpr10 = st104hOpr10;
//		this.st22hOpr4 = st22hOpr4;
//		this.st22hOpr5 = st22hOpr5;
//		this.st22hOpr2 = st22hOpr2;
//		this.st22hOpr3 = st22hOpr3;
//		this.st440Opr10 = st440Opr10;
//		this.st44hOpr6 = st44hOpr6;
//		this.st44hOpr7 = st44hOpr7;
//		this.st44hOpr8 = st44hOpr8;
//		this.st44hOpr9 = st44hOpr9;
//		this.st44hOpr2 = st44hOpr2;
//		this.st44hOpr3 = st44hOpr3;
//		this.st44hOpr4 = st44hOpr4;
//		this.st44hOpr5 = st44hOpr5;
//		this.st44hOpr1 = st44hOpr1;
//		this.bkgShprOwnrFlg = bkgShprOwnrFlg;
//		this.skdDirCd = skdDirCd;
//		this.st144hOpr1 = st144hOpr1;
//		this.st144hOpr2 = st144hOpr2;
//		this.st144hOpr3 = st144hOpr3;
//		this.st74hOpr10 = st74hOpr10;
//		this.st144hOpr4 = st144hOpr4;
//		this.st144hOpr5 = st144hOpr5;
//		this.st144hOpr6 = st144hOpr6;
//		this.st144hOpr7 = st144hOpr7;
//		this.st144hOpr8 = st144hOpr8;
//		this.st72hOpr10 = st72hOpr10;
//		this.pagerows = pagerows;
//		this.st420Opr9 = st420Opr9;
//		this.st420Opr8 = st420Opr8;
//		this.st420Opr5 = st420Opr5;
//		this.st420Opr4 = st420Opr4;
//		this.st420Opr7 = st420Opr7;
//		this.st420Opr6 = st420Opr6;
//		this.st420Opr1 = st420Opr1;
//		this.st420Opr3 = st420Opr3;
//		this.st420Opr2 = st420Opr2;
//		this.st840Opr9 = st840Opr9;
//		this.st840Opr8 = st840Opr8;
//		this.st840Opr7 = st840Opr7;
//		this.st840Opr6 = st840Opr6;
//		this.st22hOpr10 = st22hOpr10;
//		this.st840Opr1 = st840Opr1;
//		this.st440Opr9 = st440Opr9;
//		this.st440Opr8 = st440Opr8;
//		this.st440Opr7 = st440Opr7;
//		this.st440Opr6 = st440Opr6;
//		this.st440Opr5 = st440Opr5;
//		this.st840Opr5 = st840Opr5;
//		this.st840Opr4 = st840Opr4;
//		this.st440Opr4 = st440Opr4;
//		this.st840Opr3 = st840Opr3;
//		this.st440Opr3 = st440Opr3;
//		this.st440Opr2 = st440Opr2;
//		this.st840Opr2 = st840Opr2;
//		this.st440Opr1 = st440Opr1;
//		this.st820Opr10 = st820Opr10;
//		this.st1120Opr10 = st1120Opr10;
//		this.st620Opr9 = st620Opr9;
//		this.st620Opr8 = st620Opr8;
//		this.st620Opr7 = st620Opr7;
//		this.st620Opr6 = st620Opr6;
//		this.st620Opr1 = st620Opr1;
//		this.st620Opr5 = st620Opr5;
//		this.st620Opr4 = st620Opr4;
//		this.st620Opr3 = st620Opr3;
//		this.st620Opr2 = st620Opr2;
//		this.st1240Opr9 = st1240Opr9;
//		this.st62hOpr1 = st62hOpr1;
//		this.st1240Opr8 = st1240Opr8;
//		this.st1240Opr7 = st1240Opr7;
//		this.st62hOpr3 = st62hOpr3;
//		this.st1240Opr6 = st1240Opr6;
//		this.st62hOpr2 = st62hOpr2;
//		this.st1240Opr5 = st1240Opr5;
//		this.st62hOpr5 = st62hOpr5;
//		this.st1240Opr4 = st1240Opr4;
//		this.st62hOpr4 = st62hOpr4;
//		this.st1240Opr3 = st1240Opr3;
//		this.st62hOpr6 = st62hOpr6;
//		this.st62hOpr7 = st62hOpr7;
//		this.st62hOpr8 = st62hOpr8;
//		this.st62hOpr9 = st62hOpr9;
//		this.st134hOpr10 = st134hOpr10;
//		this.st620Opr10 = st620Opr10;
//		this.st84hOpr10 = st84hOpr10;
//		this.ibflag = ibflag;
//		this.st145Opr9 = st145Opr9;
//		this.st1245Opr10 = st1245Opr10;
//		this.st145Opr8 = st145Opr8;
//		this.st154hOpr9 = st154hOpr9;
//		this.st154hOpr8 = st154hOpr8;
//		this.st1345Opr10 = st1345Opr10;
//		this.st145Opr3 = st145Opr3;
//		this.st145Opr2 = st145Opr2;
//		this.st145Opr1 = st145Opr1;
//		this.st145Opr7 = st145Opr7;
//		this.st145Opr6 = st145Opr6;
//		this.st145Opr5 = st145Opr5;
//		this.st44hOpr10 = st44hOpr10;
//		this.st145Opr4 = st145Opr4;
//		this.st54hOpr4 = st54hOpr4;
//		this.opr7 = opr7;
//		this.st54hOpr3 = st54hOpr3;
//		this.opr8 = opr8;
//		this.opr5 = opr5;
//		this.st54hOpr2 = st54hOpr2;
//		this.st54hOpr1 = st54hOpr1;
//		this.opr6 = opr6;
//		this.opr3 = opr3;
//		this.st54hOpr8 = st54hOpr8;
//		this.opr4 = opr4;
//		this.st54hOpr7 = st54hOpr7;
//		this.opr1 = opr1;
//		this.st54hOpr6 = st54hOpr6;
//		this.st54hOpr5 = st54hOpr5;
//		this.opr2 = opr2;
//		this.opr9 = opr9;
//		this.st54hOpr9 = st54hOpr9;
//		this.st220Opr6 = st220Opr6;
//		this.st220Opr7 = st220Opr7;
//		this.st220Opr8 = st220Opr8;
//		this.st220Opr9 = st220Opr9;
//		this.st220Opr2 = st220Opr2;
//		this.st220Opr3 = st220Opr3;
//		this.st220Opr4 = st220Opr4;
//		this.st220Opr5 = st220Opr5;
//		this.st1020Opr2 = st1020Opr2;
//		this.st1020Opr1 = st1020Opr1;
//		this.st220Opr1 = st220Opr1;
//		this.st15 = st15;
//		this.st14 = st14;
//		this.st13 = st13;
//		this.st12 = st12;
//		this.st11 = st11;
//		this.st10 = st10;
//		this.st134hOpr1 = st134hOpr1;
//		this.st134hOpr2 = st134hOpr2;
//		this.st72hOpr5 = st72hOpr5;
//		this.st134hOpr3 = st134hOpr3;
//		this.st72hOpr6 = st72hOpr6;
//		this.st134hOpr4 = st134hOpr4;
//		this.st72hOpr7 = st72hOpr7;
//		this.st134hOpr5 = st134hOpr5;
//		this.st72hOpr8 = st72hOpr8;
//		this.st134hOpr6 = st134hOpr6;
//		this.st72hOpr9 = st72hOpr9;
//		this.st134hOpr7 = st134hOpr7;
//		this.st134hOpr8 = st134hOpr8;
//		this.st134hOpr9 = st134hOpr9;
//		this.st154hOpr1 = st154hOpr1;
//		this.st154hOpr3 = st154hOpr3;
//		this.st154hOpr2 = st154hOpr2;
//		this.st1440Opr9 = st1440Opr9;
//		this.st1040Opr4 = st1040Opr4;
//		this.st72hOpr2 = st72hOpr2;
//		this.st154hOpr5 = st154hOpr5;
//		this.st154hOpr4 = st154hOpr4;
//		this.st1040Opr3 = st1040Opr3;
//		this.st72hOpr1 = st72hOpr1;
//		this.st72hOpr4 = st72hOpr4;
//		this.st1040Opr2 = st1040Opr2;
//		this.st154hOpr7 = st154hOpr7;
//		this.st72hOpr3 = st72hOpr3;
//		this.st1040Opr1 = st1040Opr1;
//		this.st154hOpr6 = st154hOpr6;
//		this.st1440Opr4 = st1440Opr4;
//		this.st1440Opr3 = st1440Opr3;
//		this.st1440Opr2 = st1440Opr2;
//		this.st1440Opr1 = st1440Opr1;
//		this.st1440Opr8 = st1440Opr8;
//		this.st1440Opr7 = st1440Opr7;
//		this.st1440Opr6 = st1440Opr6;
//		this.st1440Opr5 = st1440Opr5;
//		this.st102hOpr1 = st102hOpr1;
//		this.st102hOpr2 = st102hOpr2;
//		this.st102hOpr7 = st102hOpr7;
//		this.st102hOpr8 = st102hOpr8;
//		this.st102hOpr9 = st102hOpr9;
//		this.st102hOpr3 = st102hOpr3;
//		this.st102hOpr4 = st102hOpr4;
//		this.st102hOpr5 = st102hOpr5;
//		this.st102hOpr6 = st102hOpr6;
//		this.st320Opr10 = st320Opr10;
//		this.st1020Opr3 = st1020Opr3;
//		this.st1020Opr4 = st1020Opr4;
//		this.st1020Opr5 = st1020Opr5;
//		this.st1020Opr6 = st1020Opr6;
//		this.st1240Opr2 = st1240Opr2;
//		this.st1020Opr7 = st1020Opr7;
//		this.st1240Opr1 = st1240Opr1;
//		this.st1020Opr8 = st1020Opr8;
//		this.st1020Opr9 = st1020Opr9;
//		this.st1240Opr10 = st1240Opr10;
//		this.st14hOpr9 = st14hOpr9;
//		this.st1140Opr10 = st1140Opr10;
//		this.st14hOpr5 = st14hOpr5;
//		this.st14hOpr6 = st14hOpr6;
//		this.st14hOpr7 = st14hOpr7;
//		this.st14hOpr8 = st14hOpr8;
//		this.st14hOpr1 = st14hOpr1;
//		this.st14hOpr2 = st14hOpr2;
//		this.st14hOpr3 = st14hOpr3;
//		this.st14hOpr4 = st14hOpr4;
//		this.st840Opr10 = st840Opr10;
//		this.mlb = mlb;
//		this.st102hOpr10 = st102hOpr10;
//		this.awkCgoFlg = awkCgoFlg;
//		this.st42hOpr1 = st42hOpr1;
//		this.st1040Opr9 = st1040Opr9;
//		this.st42hOpr3 = st42hOpr3;
//		this.st42hOpr2 = st42hOpr2;
//		this.st42hOpr5 = st42hOpr5;
//		this.st1040Opr6 = st1040Opr6;
//		this.st220Opr10 = st220Opr10;
//		this.st42hOpr4 = st42hOpr4;
//		this.st1040Opr5 = st1040Opr5;
//		this.st42hOpr7 = st42hOpr7;
//		this.st1040Opr8 = st1040Opr8;
//		this.st42hOpr6 = st42hOpr6;
//		this.st1040Opr7 = st1040Opr7;
//		this.st745Opr3 = st745Opr3;
//		this.st745Opr2 = st745Opr2;
//		this.st745Opr5 = st745Opr5;
//		this.st745Opr4 = st745Opr4;
//		this.st745Opr7 = st745Opr7;
//		this.st745Opr6 = st745Opr6;
//		this.st745Opr9 = st745Opr9;
//		this.st745Opr8 = st745Opr8;
//		this.st42hOpr8 = st42hOpr8;
//		this.st42hOpr9 = st42hOpr9;
//		this.st745Opr1 = st745Opr1;
//		this.st114hOpr10 = st114hOpr10;
//		this.st140Opr6 = st140Opr6;
//		this.st140Opr5 = st140Opr5;
//		this.st140Opr8 = st140Opr8;
//		this.st140Opr7 = st140Opr7;
//		this.st140Opr9 = st140Opr9;
//		this.st142hOpr10 = st142hOpr10;
//		this.st140Opr1 = st140Opr1;
//		this.st140Opr2 = st140Opr2;
//		this.st140Opr3 = st140Opr3;
//		this.st54hOpr10 = st54hOpr10;
//		this.st140Opr4 = st140Opr4;
//	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("st7_20_opr10", getSt720Opr10());
		this.hashColumns.put("st7_40_opr7", getSt740Opr7());
		this.hashColumns.put("st14_45_opr10", getSt1445Opr10());
		this.hashColumns.put("st7_40_opr8", getSt740Opr8());
		this.hashColumns.put("st7_40_opr9", getSt740Opr9());
		this.hashColumns.put("st1_40_opr10", getSt140Opr10());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("st7_40_opr1", getSt740Opr1());
		this.hashColumns.put("st7_40_opr2", getSt740Opr2());
		this.hashColumns.put("st7_40_opr3", getSt740Opr3());
		this.hashColumns.put("st7_40_opr4", getSt740Opr4());
		this.hashColumns.put("st7_40_opr5", getSt740Opr5());
		this.hashColumns.put("st7_40_opr6", getSt740Opr6());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("st1_45_opr10", getSt145Opr10());
		this.hashColumns.put("st15_45_opr10", getSt1545Opr10());
		this.hashColumns.put("st6_40_opr10", getSt640Opr10());
		this.hashColumns.put("st13_40_opr10", getSt1340Opr10());
		this.hashColumns.put("st5_20_opr10", getSt520Opr10());
		this.hashColumns.put("st15_4h_opr10", getSt154hOpr10());
		this.hashColumns.put("st8_2h_opr10", getSt82hOpr10());
		this.hashColumns.put("st8_45_opr10", getSt845Opr10());
		this.hashColumns.put("st6_45_opr3", getSt645Opr3());
		this.hashColumns.put("st6_45_opr4", getSt645Opr4());
		this.hashColumns.put("st6_45_opr5", getSt645Opr5());
		this.hashColumns.put("st5_45_opr8", getSt545Opr8());
		this.hashColumns.put("st6_45_opr6", getSt645Opr6());
		this.hashColumns.put("st5_45_opr9", getSt545Opr9());
		this.hashColumns.put("st5_45_opr6", getSt545Opr6());
		this.hashColumns.put("st6_45_opr7", getSt645Opr7());
		this.hashColumns.put("st5_45_opr7", getSt545Opr7());
		this.hashColumns.put("st6_45_opr8", getSt645Opr8());
		this.hashColumns.put("st5_45_opr4", getSt545Opr4());
		this.hashColumns.put("st6_45_opr9", getSt645Opr9());
		this.hashColumns.put("st5_45_opr5", getSt545Opr5());
		this.hashColumns.put("st5_45_opr2", getSt545Opr2());
		this.hashColumns.put("st5_45_opr3", getSt545Opr3());
		this.hashColumns.put("st11_45_opr10", getSt1145Opr10());
		this.hashColumns.put("st5_45_opr1", getSt545Opr1());
		this.hashColumns.put("st6_45_opr1", getSt645Opr1());
		this.hashColumns.put("st6_45_opr2", getSt645Opr2());
		this.hashColumns.put("st11_4h_opr8", getSt114hOpr8());
		this.hashColumns.put("st11_4h_opr9", getSt114hOpr9());
		this.hashColumns.put("st11_4h_opr4", getSt114hOpr4());
		this.hashColumns.put("st11_4h_opr5", getSt114hOpr5());
		this.hashColumns.put("st11_4h_opr6", getSt114hOpr6());
		this.hashColumns.put("st11_4h_opr7", getSt114hOpr7());
		this.hashColumns.put("st11_4h_opr1", getSt114hOpr1());
		this.hashColumns.put("st11_4h_opr2", getSt114hOpr2());
		this.hashColumns.put("st11_4h_opr3", getSt114hOpr3());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("st7_45_opr10", getSt745Opr10());
		this.hashColumns.put("st13_20_opr10", getSt1320Opr10());
		this.hashColumns.put("st12_2h_opr1", getSt122hOpr1());
		this.hashColumns.put("st12_2h_opr2", getSt122hOpr2());
		this.hashColumns.put("st12_2h_opr3", getSt122hOpr3());
		this.hashColumns.put("st12_2h_opr4", getSt122hOpr4());
		this.hashColumns.put("st12_2h_opr5", getSt122hOpr5());
		this.hashColumns.put("st12_2h_opr6", getSt122hOpr6());
		this.hashColumns.put("st12_2h_opr7", getSt122hOpr7());
		this.hashColumns.put("st12_2h_opr8", getSt122hOpr8());
		this.hashColumns.put("st8_45_opr5", getSt845Opr5());
		this.hashColumns.put("st10_4h_opr6", getSt104hOpr6());
		this.hashColumns.put("st14_45_opr9", getSt1445Opr9());
		this.hashColumns.put("st10_4h_opr5", getSt104hOpr5());
		this.hashColumns.put("st8_45_opr6", getSt845Opr6());
		this.hashColumns.put("st14_45_opr8", getSt1445Opr8());
		this.hashColumns.put("st11_45_opr1", getSt1145Opr1());
		this.hashColumns.put("st8_45_opr7", getSt845Opr7());
		this.hashColumns.put("st10_4h_opr8", getSt104hOpr8());
		this.hashColumns.put("st11_45_opr2", getSt1145Opr2());
		this.hashColumns.put("st10_4h_opr7", getSt104hOpr7());
		this.hashColumns.put("st8_45_opr8", getSt845Opr8());
		this.hashColumns.put("st11_45_opr3", getSt1145Opr3());
		this.hashColumns.put("st8_45_opr1", getSt845Opr1());
		this.hashColumns.put("st14_45_opr5", getSt1445Opr5());
		this.hashColumns.put("st14_45_opr4", getSt1445Opr4());
		this.hashColumns.put("st11_45_opr4", getSt1145Opr4());
		this.hashColumns.put("st8_45_opr2", getSt845Opr2());
		this.hashColumns.put("st10_4h_opr9", getSt104hOpr9());
		this.hashColumns.put("st8_45_opr3", getSt845Opr3());
		this.hashColumns.put("st11_45_opr5", getSt1145Opr5());
		this.hashColumns.put("st14_45_opr7", getSt1445Opr7());
		this.hashColumns.put("st8_45_opr4", getSt845Opr4());
		this.hashColumns.put("st11_45_opr6", getSt1145Opr6());
		this.hashColumns.put("st14_45_opr6", getSt1445Opr6());
		this.hashColumns.put("st14_45_opr1", getSt1445Opr1());
		this.hashColumns.put("st11_45_opr7", getSt1145Opr7());
		this.hashColumns.put("st11_45_opr8", getSt1145Opr8());
		this.hashColumns.put("st14_45_opr3", getSt1445Opr3());
		this.hashColumns.put("st11_45_opr9", getSt1145Opr9());
		this.hashColumns.put("st14_45_opr2", getSt1445Opr2());
		this.hashColumns.put("st10_4h_opr2", getSt104hOpr2());
		this.hashColumns.put("st10_4h_opr1", getSt104hOpr1());
		this.hashColumns.put("st10_4h_opr4", getSt104hOpr4());
		this.hashColumns.put("st10_4h_opr3", getSt104hOpr3());
		this.hashColumns.put("st8_45_opr9", getSt845Opr9());
		this.hashColumns.put("st3_4h_opr2", getSt34hOpr2());
		this.hashColumns.put("st3_4h_opr1", getSt34hOpr1());
		this.hashColumns.put("st3_4h_opr4", getSt34hOpr4());
		this.hashColumns.put("st3_4h_opr3", getSt34hOpr3());
		this.hashColumns.put("st3_4h_opr6", getSt34hOpr6());
		this.hashColumns.put("st3_4h_opr5", getSt34hOpr5());
		this.hashColumns.put("st3_4h_opr8", getSt34hOpr8());
		this.hashColumns.put("st3_4h_opr7", getSt34hOpr7());
		this.hashColumns.put("st3_4h_opr9", getSt34hOpr9());
		this.hashColumns.put("st13_45_opr3", getSt1345Opr3());
		this.hashColumns.put("st13_45_opr4", getSt1345Opr4());
		this.hashColumns.put("st13_45_opr1", getSt1345Opr1());
		this.hashColumns.put("st13_45_opr2", getSt1345Opr2());
		this.hashColumns.put("st13_45_opr9", getSt1345Opr9());
		this.hashColumns.put("st13_45_opr7", getSt1345Opr7());
		this.hashColumns.put("st13_45_opr8", getSt1345Opr8());
		this.hashColumns.put("st13_45_opr5", getSt1345Opr5());
		this.hashColumns.put("st13_45_opr6", getSt1345Opr6());
		this.hashColumns.put("st1_2h_opr10", getSt12hOpr10());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("st5_45_opr10", getSt545Opr10());
		this.hashColumns.put("st15_2h_opr8", getSt152hOpr8());
		this.hashColumns.put("st15_2h_opr9", getSt152hOpr9());
		this.hashColumns.put("st15_2h_opr6", getSt152hOpr6());
		this.hashColumns.put("st15_2h_opr7", getSt152hOpr7());
		this.hashColumns.put("st11_40_opr1", getSt1140Opr1());
		this.hashColumns.put("st11_40_opr2", getSt1140Opr2());
		this.hashColumns.put("st11_40_opr3", getSt1140Opr3());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("st14_20_opr10", getSt1420Opr10());
		this.hashColumns.put("st14_2h_opr8", getSt142hOpr8());
		this.hashColumns.put("st14_2h_opr7", getSt142hOpr7());
		this.hashColumns.put("st14_2h_opr9", getSt142hOpr9());
		this.hashColumns.put("st7_4h_opr9", getSt74hOpr9());
		this.hashColumns.put("st7_4h_opr7", getSt74hOpr7());
		this.hashColumns.put("st7_4h_opr8", getSt74hOpr8());
		this.hashColumns.put("st7_4h_opr6", getSt74hOpr6());
		this.hashColumns.put("st12_20_opr9", getSt1220Opr9());
		this.hashColumns.put("st7_4h_opr5", getSt74hOpr5());
		this.hashColumns.put("st7_4h_opr4", getSt74hOpr4());
		this.hashColumns.put("st7_4h_opr3", getSt74hOpr3());
		this.hashColumns.put("st7_4h_opr2", getSt74hOpr2());
		this.hashColumns.put("st7_4h_opr1", getSt74hOpr1());
		this.hashColumns.put("opr10", getOpr10());
		this.hashColumns.put("st12_20_opr1", getSt1220Opr1());
		this.hashColumns.put("st12_20_opr2", getSt1220Opr2());
		this.hashColumns.put("st12_20_opr3", getSt1220Opr3());
		this.hashColumns.put("st12_20_opr4", getSt1220Opr4());
		this.hashColumns.put("st12_20_opr5", getSt1220Opr5());
		this.hashColumns.put("st12_20_opr6", getSt1220Opr6());
		this.hashColumns.put("st12_20_opr7", getSt1220Opr7());
		this.hashColumns.put("st12_4h_opr10", getSt124hOpr10());
		this.hashColumns.put("st12_20_opr8", getSt1220Opr8());
		this.hashColumns.put("st8_2h_opr7", getSt82hOpr7());
		this.hashColumns.put("st8_2h_opr6", getSt82hOpr6());
		this.hashColumns.put("st8_2h_opr5", getSt82hOpr5());
		this.hashColumns.put("st8_2h_opr4", getSt82hOpr4());
		this.hashColumns.put("st8_2h_opr9", getSt82hOpr9());
		this.hashColumns.put("st8_2h_opr8", getSt82hOpr8());
		this.hashColumns.put("st8_2h_opr2", getSt82hOpr2());
		this.hashColumns.put("st8_2h_opr3", getSt82hOpr3());
		this.hashColumns.put("st8_2h_opr1", getSt82hOpr1());
		this.hashColumns.put("st9_2h_opr3", getSt92hOpr3());
		this.hashColumns.put("st9_2h_opr4", getSt92hOpr4());
		this.hashColumns.put("st9_2h_opr5", getSt92hOpr5());
		this.hashColumns.put("st9_2h_opr6", getSt92hOpr6());
		this.hashColumns.put("st9_2h_opr7", getSt92hOpr7());
		this.hashColumns.put("st9_2h_opr8", getSt92hOpr8());
		this.hashColumns.put("st9_2h_opr9", getSt92hOpr9());
		this.hashColumns.put("st10_20_opr10", getSt1020Opr10());
		this.hashColumns.put("st11_40_opr9", getSt1140Opr9());
		this.hashColumns.put("st11_40_opr8", getSt1140Opr8());
		this.hashColumns.put("st11_40_opr7", getSt1140Opr7());
		this.hashColumns.put("st11_40_opr6", getSt1140Opr6());
		this.hashColumns.put("st11_40_opr5", getSt1140Opr5());
		this.hashColumns.put("st11_40_opr4", getSt1140Opr4());
		this.hashColumns.put("st2_45_opr3", getSt245Opr3());
		this.hashColumns.put("st2_45_opr4", getSt245Opr4());
		this.hashColumns.put("st7_40_opr10", getSt740Opr10());
		this.hashColumns.put("st2_45_opr5", getSt245Opr5());
		this.hashColumns.put("st15_2h_opr1", getSt152hOpr1());
		this.hashColumns.put("st2_45_opr6", getSt245Opr6());
		this.hashColumns.put("st15_2h_opr3", getSt152hOpr3());
		this.hashColumns.put("st15_2h_opr2", getSt152hOpr2());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("st2_45_opr1", getSt245Opr1());
		this.hashColumns.put("st15_2h_opr5", getSt152hOpr5());
		this.hashColumns.put("st15_2h_opr4", getSt152hOpr4());
		this.hashColumns.put("st2_45_opr2", getSt245Opr2());
		this.hashColumns.put("st2_45_opr7", getSt245Opr7());
		this.hashColumns.put("st9_20_opr10", getSt920Opr10());
		this.hashColumns.put("st2_45_opr8", getSt245Opr8());
		this.hashColumns.put("st9_2h_opr2", getSt92hOpr2());
		this.hashColumns.put("st2_45_opr9", getSt245Opr9());
		this.hashColumns.put("st9_2h_opr1", getSt92hOpr1());
		this.hashColumns.put("st5_2h_opr2", getSt52hOpr2());
		this.hashColumns.put("st5_2h_opr1", getSt52hOpr1());
		this.hashColumns.put("st5_2h_opr6", getSt52hOpr6());
		this.hashColumns.put("st5_2h_opr5", getSt52hOpr5());
		this.hashColumns.put("st5_2h_opr4", getSt52hOpr4());
		this.hashColumns.put("st5_2h_opr3", getSt52hOpr3());
		this.hashColumns.put("st14_4h_opr10", getSt144hOpr10());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("st5_2h_opr9", getSt52hOpr9());
		this.hashColumns.put("st5_2h_opr7", getSt52hOpr7());
		this.hashColumns.put("st5_2h_opr8", getSt52hOpr8());
		this.hashColumns.put("st12_2h_opr9", getSt122hOpr9());
		this.hashColumns.put("st12_4h_opr4", getSt124hOpr4());
		this.hashColumns.put("st9_40_opr2", getSt940Opr2());
		this.hashColumns.put("st12_4h_opr3", getSt124hOpr3());
		this.hashColumns.put("st9_40_opr1", getSt940Opr1());
		this.hashColumns.put("st9_40_opr4", getSt940Opr4());
		this.hashColumns.put("st12_4h_opr6", getSt124hOpr6());
		this.hashColumns.put("st9_40_opr3", getSt940Opr3());
		this.hashColumns.put("st12_4h_opr5", getSt124hOpr5());
		this.hashColumns.put("st12_4h_opr8", getSt124hOpr8());
		this.hashColumns.put("st12_4h_opr7", getSt124hOpr7());
		this.hashColumns.put("st2_45_opr10", getSt245Opr10());
		this.hashColumns.put("st12_4h_opr9", getSt124hOpr9());
		this.hashColumns.put("st9_40_opr9", getSt940Opr9());
		this.hashColumns.put("st9_40_opr6", getSt940Opr6());
		this.hashColumns.put("st9_40_opr5", getSt940Opr5());
		this.hashColumns.put("st12_4h_opr2", getSt124hOpr2());
		this.hashColumns.put("st9_40_opr8", getSt940Opr8());
		this.hashColumns.put("st3_2h_opr10", getSt32hOpr10());
		this.hashColumns.put("st12_4h_opr1", getSt124hOpr1());
		this.hashColumns.put("st9_40_opr7", getSt940Opr7());
		this.hashColumns.put("st14_2h_opr6", getSt142hOpr6());
		this.hashColumns.put("st14_2h_opr5", getSt142hOpr5());
		this.hashColumns.put("st14_2h_opr4", getSt142hOpr4());
		this.hashColumns.put("st14_2h_opr3", getSt142hOpr3());
		this.hashColumns.put("st14_2h_opr2", getSt142hOpr2());
		this.hashColumns.put("st14_2h_opr1", getSt142hOpr1());
		this.hashColumns.put("st9_4h_opr1", getSt94hOpr1());
		this.hashColumns.put("st9_4h_opr2", getSt94hOpr2());
		this.hashColumns.put("st9_4h_opr3", getSt94hOpr3());
		this.hashColumns.put("st9_4h_opr4", getSt94hOpr4());
		this.hashColumns.put("st15_20_opr1", getSt1520Opr1());
		this.hashColumns.put("st9_4h_opr9", getSt94hOpr9());
		this.hashColumns.put("st11_2h_opr1", getSt112hOpr1());
		this.hashColumns.put("st15_20_opr5", getSt1520Opr5());
		this.hashColumns.put("st9_4h_opr6", getSt94hOpr6());
		this.hashColumns.put("st15_20_opr4", getSt1520Opr4());
		this.hashColumns.put("st9_4h_opr5", getSt94hOpr5());
		this.hashColumns.put("st15_20_opr3", getSt1520Opr3());
		this.hashColumns.put("st9_4h_opr8", getSt94hOpr8());
		this.hashColumns.put("st15_20_opr2", getSt1520Opr2());
		this.hashColumns.put("st9_4h_opr7", getSt94hOpr7());
		this.hashColumns.put("st11_2h_opr6", getSt112hOpr6());
		this.hashColumns.put("st15_20_opr9", getSt1520Opr9());
		this.hashColumns.put("st11_2h_opr7", getSt112hOpr7());
		this.hashColumns.put("st15_20_opr8", getSt1520Opr8());
		this.hashColumns.put("st15_20_opr7", getSt1520Opr7());
		this.hashColumns.put("st11_2h_opr8", getSt112hOpr8());
		this.hashColumns.put("st15_20_opr6", getSt1520Opr6());
		this.hashColumns.put("st11_2h_opr9", getSt112hOpr9());
		this.hashColumns.put("st11_2h_opr2", getSt112hOpr2());
		this.hashColumns.put("st11_2h_opr3", getSt112hOpr3());
		this.hashColumns.put("st3_40_opr10", getSt340Opr10());
		this.hashColumns.put("st11_2h_opr4", getSt112hOpr4());
		this.hashColumns.put("st11_2h_opr5", getSt112hOpr5());
		this.hashColumns.put("st11_20_opr7", getSt1120Opr7());
		this.hashColumns.put("st11_20_opr6", getSt1120Opr6());
		this.hashColumns.put("st11_20_opr9", getSt1120Opr9());
		this.hashColumns.put("st11_20_opr8", getSt1120Opr8());
		this.hashColumns.put("st11_20_opr3", getSt1120Opr3());
		this.hashColumns.put("st11_20_opr2", getSt1120Opr2());
		this.hashColumns.put("st11_20_opr5", getSt1120Opr5());
		this.hashColumns.put("st11_20_opr4", getSt1120Opr4());
		this.hashColumns.put("st13_2h_opr4", getSt132hOpr4());
		this.hashColumns.put("st13_2h_opr5", getSt132hOpr5());
		this.hashColumns.put("st13_2h_opr6", getSt132hOpr6());
		this.hashColumns.put("st13_2h_opr7", getSt132hOpr7());
		this.hashColumns.put("st13_2h_opr1", getSt132hOpr1());
		this.hashColumns.put("st13_2h_opr2", getSt132hOpr2());
		this.hashColumns.put("st13_2h_opr3", getSt132hOpr3());
		this.hashColumns.put("st2_4h_opr10", getSt24hOpr10());
		this.hashColumns.put("st3_45_opr10", getSt345Opr10());
		this.hashColumns.put("qty1", getQty1());
		this.hashColumns.put("qty3", getQty3());
		this.hashColumns.put("qty2", getQty2());
		this.hashColumns.put("qty5", getQty5());
		this.hashColumns.put("qty4", getQty4());
		this.hashColumns.put("st7_20_opr7", getSt720Opr7());
		this.hashColumns.put("st7_20_opr8", getSt720Opr8());
		this.hashColumns.put("st7_20_opr5", getSt720Opr5());
		this.hashColumns.put("st7_20_opr6", getSt720Opr6());
		this.hashColumns.put("st7_20_opr9", getSt720Opr9());
		this.hashColumns.put("st3_4h_opr10", getSt34hOpr10());
		this.hashColumns.put("st6_2h_opr10", getSt62hOpr10());
		this.hashColumns.put("st14_40_opr10", getSt1440Opr10());
		this.hashColumns.put("st7_20_opr3", getSt720Opr3());
		this.hashColumns.put("st7_20_opr4", getSt720Opr4());
		this.hashColumns.put("st7_20_opr1", getSt720Opr1());
		this.hashColumns.put("st7_20_opr2", getSt720Opr2());
		this.hashColumns.put("st10_45_opr10", getSt1045Opr10());
		this.hashColumns.put("st15_40_opr1", getSt1540Opr1());
		this.hashColumns.put("st15_40_opr2", getSt1540Opr2());
		this.hashColumns.put("st15_40_opr3", getSt1540Opr3());
		this.hashColumns.put("st15_40_opr4", getSt1540Opr4());
		this.hashColumns.put("st15_40_opr5", getSt1540Opr5());
		this.hashColumns.put("st15_40_opr6", getSt1540Opr6());
		this.hashColumns.put("st15_40_opr7", getSt1540Opr7());
		this.hashColumns.put("st15_40_opr8", getSt1540Opr8());
		this.hashColumns.put("st15_40_opr9", getSt1540Opr9());
		this.hashColumns.put("qty8", getQty8());
		this.hashColumns.put("st15_45_opr1", getSt1545Opr1());
		this.hashColumns.put("st15_45_opr2", getSt1545Opr2());
		this.hashColumns.put("qty9", getQty9());
		this.hashColumns.put("qty6", getQty6());
		this.hashColumns.put("st4_20_opr10", getSt420Opr10());
		this.hashColumns.put("qty7", getQty7());
		this.hashColumns.put("st15_45_opr5", getSt1545Opr5());
		this.hashColumns.put("st15_45_opr6", getSt1545Opr6());
		this.hashColumns.put("st15_45_opr3", getSt1545Opr3());
		this.hashColumns.put("st15_45_opr4", getSt1545Opr4());
		this.hashColumns.put("st15_45_opr9", getSt1545Opr9());
		this.hashColumns.put("st15_45_opr7", getSt1545Opr7());
		this.hashColumns.put("st15_45_opr8", getSt1545Opr8());
		this.hashColumns.put("st13_20_opr1", getSt1320Opr1());
		this.hashColumns.put("st13_20_opr3", getSt1320Opr3());
		this.hashColumns.put("st13_2h_opr9", getSt132hOpr9());
		this.hashColumns.put("st13_20_opr2", getSt1320Opr2());
		this.hashColumns.put("st13_2h_opr8", getSt132hOpr8());
		this.hashColumns.put("st13_20_opr5", getSt1320Opr5());
		this.hashColumns.put("st13_20_opr4", getSt1320Opr4());
		this.hashColumns.put("st13_20_opr7", getSt1320Opr7());
		this.hashColumns.put("st13_20_opr6", getSt1320Opr6());
		this.hashColumns.put("st13_20_opr9", getSt1320Opr9());
		this.hashColumns.put("st13_20_opr8", getSt1320Opr8());
		this.hashColumns.put("st3_40_opr1", getSt340Opr1());
		this.hashColumns.put("st3_40_opr2", getSt340Opr2());
		this.hashColumns.put("st3_40_opr9", getSt340Opr9());
		this.hashColumns.put("st3_40_opr8", getSt340Opr8());
		this.hashColumns.put("st3_40_opr7", getSt340Opr7());
		this.hashColumns.put("st3_40_opr6", getSt340Opr6());
		this.hashColumns.put("st3_40_opr5", getSt340Opr5());
		this.hashColumns.put("st3_40_opr4", getSt340Opr4());
		this.hashColumns.put("st3_40_opr3", getSt340Opr3());
		this.hashColumns.put("all_flg", getAllFlg());
		this.hashColumns.put("st4_45_opr10", getSt445Opr10());
		this.hashColumns.put("st1_20_opr1", getSt120Opr1());
		this.hashColumns.put("st1_20_opr2", getSt120Opr2());
		this.hashColumns.put("st1_20_opr10", getSt120Opr10());
		this.hashColumns.put("st13_2h_opr10", getSt132hOpr10());
		this.hashColumns.put("st1_20_opr4", getSt120Opr4());
		this.hashColumns.put("st1_20_opr3", getSt120Opr3());
		this.hashColumns.put("st1_20_opr6", getSt120Opr6());
		this.hashColumns.put("st1_20_opr5", getSt120Opr5());
		this.hashColumns.put("st1_20_opr8", getSt120Opr8());
		this.hashColumns.put("st1_20_opr7", getSt120Opr7());
		this.hashColumns.put("st1_20_opr9", getSt120Opr9());
		this.hashColumns.put("st10_40_opr10", getSt1040Opr10());
		this.hashColumns.put("st9_2h_opr10", getSt92hOpr10());
		this.hashColumns.put("st10_45_opr5", getSt1045Opr5());
		this.hashColumns.put("st10_45_opr4", getSt1045Opr4());
		this.hashColumns.put("st10_45_opr7", getSt1045Opr7());
		this.hashColumns.put("st10_45_opr6", getSt1045Opr6());
		this.hashColumns.put("st10_45_opr1", getSt1045Opr1());
		this.hashColumns.put("st5_40_opr10", getSt540Opr10());
		this.hashColumns.put("st10_45_opr3", getSt1045Opr3());
		this.hashColumns.put("bb_cgo_flg", getBbCgoFlg());
		this.hashColumns.put("st10_45_opr2", getSt1045Opr2());
		this.hashColumns.put("st10_45_opr9", getSt1045Opr9());
		this.hashColumns.put("st10_45_opr8", getSt1045Opr8());
		this.hashColumns.put("mlb_cd", getMlbCd());
		this.hashColumns.put("st15_20_opr10", getSt1520Opr10());
		this.hashColumns.put("st3_45_opr7", getSt345Opr7());
		this.hashColumns.put("st3_45_opr6", getSt345Opr6());
		this.hashColumns.put("st3_45_opr9", getSt345Opr9());
		this.hashColumns.put("st3_45_opr8", getSt345Opr8());
		this.hashColumns.put("st11_20_opr1", getSt1120Opr1());
		this.hashColumns.put("st3_45_opr1", getSt345Opr1());
		this.hashColumns.put("st3_45_opr3", getSt345Opr3());
		this.hashColumns.put("st3_45_opr2", getSt345Opr2());
		this.hashColumns.put("st3_45_opr5", getSt345Opr5());
		this.hashColumns.put("st3_45_opr4", getSt345Opr4());
		this.hashColumns.put("st1_2h_opr2", getSt12hOpr2());
		this.hashColumns.put("st1_2h_opr1", getSt12hOpr1());
		this.hashColumns.put("st13_40_opr1", getSt1340Opr1());
		this.hashColumns.put("st1_2h_opr8", getSt12hOpr8());
		this.hashColumns.put("st1_2h_opr7", getSt12hOpr7());
		this.hashColumns.put("st1_2h_opr9", getSt12hOpr9());
		this.hashColumns.put("st1_2h_opr4", getSt12hOpr4());
		this.hashColumns.put("st1_2h_opr3", getSt12hOpr3());
		this.hashColumns.put("st1_2h_opr6", getSt12hOpr6());
		this.hashColumns.put("st1_2h_opr5", getSt12hOpr5());
		this.hashColumns.put("st14_20_opr6", getSt1420Opr6());
		this.hashColumns.put("st14_20_opr5", getSt1420Opr5());
		this.hashColumns.put("st14_20_opr4", getSt1420Opr4());
		this.hashColumns.put("st14_20_opr3", getSt1420Opr3());
		this.hashColumns.put("st14_20_opr2", getSt1420Opr2());
		this.hashColumns.put("st14_20_opr1", getSt1420Opr1());
		this.hashColumns.put("st14_20_opr9", getSt1420Opr9());
		this.hashColumns.put("st14_20_opr8", getSt1420Opr8());
		this.hashColumns.put("st14_20_opr7", getSt1420Opr7());
		this.hashColumns.put("st8_4h_opr1", getSt84hOpr1());
		this.hashColumns.put("st8_4h_opr3", getSt84hOpr3());
		this.hashColumns.put("st8_4h_opr2", getSt84hOpr2());
		this.hashColumns.put("st8_4h_opr5", getSt84hOpr5());
		this.hashColumns.put("st8_4h_opr4", getSt84hOpr4());
		this.hashColumns.put("st15_2h_opr10", getSt152hOpr10());
		this.hashColumns.put("st8_4h_opr6", getSt84hOpr6());
		this.hashColumns.put("st8_4h_opr7", getSt84hOpr7());
		this.hashColumns.put("st8_4h_opr8", getSt84hOpr8());
		this.hashColumns.put("st8_4h_opr9", getSt84hOpr9());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("st1_4h_opr10", getSt14hOpr10());
		this.hashColumns.put("st6_40_opr8", getSt640Opr8());
		this.hashColumns.put("st12_45_opr9", getSt1245Opr9());
		this.hashColumns.put("st12_45_opr8", getSt1245Opr8());
		this.hashColumns.put("st6_40_opr9", getSt640Opr9());
		this.hashColumns.put("st12_45_opr7", getSt1245Opr7());
		this.hashColumns.put("st12_45_opr6", getSt1245Opr6());
		this.hashColumns.put("st6_40_opr4", getSt640Opr4());
		this.hashColumns.put("st12_45_opr5", getSt1245Opr5());
		this.hashColumns.put("st6_40_opr5", getSt640Opr5());
		this.hashColumns.put("st12_45_opr4", getSt1245Opr4());
		this.hashColumns.put("st12_45_opr3", getSt1245Opr3());
		this.hashColumns.put("st6_40_opr6", getSt640Opr6());
		this.hashColumns.put("st12_45_opr2", getSt1245Opr2());
		this.hashColumns.put("st6_40_opr7", getSt640Opr7());
		this.hashColumns.put("st12_45_opr1", getSt1245Opr1());
		this.hashColumns.put("st6_40_opr1", getSt640Opr1());
		this.hashColumns.put("st6_40_opr2", getSt640Opr2());
		this.hashColumns.put("st6_40_opr3", getSt640Opr3());
		this.hashColumns.put("st5_2h_opr10", getSt52hOpr10());
		this.hashColumns.put("st13_40_opr2", getSt1340Opr2());
		this.hashColumns.put("st13_40_opr3", getSt1340Opr3());
		this.hashColumns.put("st13_40_opr4", getSt1340Opr4());
		this.hashColumns.put("st13_40_opr5", getSt1340Opr5());
		this.hashColumns.put("st13_40_opr6", getSt1340Opr6());
		this.hashColumns.put("st13_40_opr7", getSt1340Opr7());
		this.hashColumns.put("st13_40_opr8", getSt1340Opr8());
		this.hashColumns.put("st13_40_opr9", getSt1340Opr9());
		this.hashColumns.put("st9_45_opr1", getSt945Opr1());
		this.hashColumns.put("st9_45_opr3", getSt945Opr3());
		this.hashColumns.put("st9_45_opr2", getSt945Opr2());
		this.hashColumns.put("st9_45_opr5", getSt945Opr5());
		this.hashColumns.put("st9_45_opr4", getSt945Opr4());
		this.hashColumns.put("st9_45_opr7", getSt945Opr7());
		this.hashColumns.put("st9_45_opr6", getSt945Opr6());
		this.hashColumns.put("st6_4h_opr10", getSt64hOpr10());
		this.hashColumns.put("st5_20_opr1", getSt520Opr1());
		this.hashColumns.put("st5_40_opr2", getSt540Opr2());
		this.hashColumns.put("st5_40_opr1", getSt540Opr1());
		this.hashColumns.put("st5_20_opr2", getSt520Opr2());
		this.hashColumns.put("st5_40_opr4", getSt540Opr4());
		this.hashColumns.put("st5_40_opr3", getSt540Opr3());
		this.hashColumns.put("qty10", getQty10());
		this.hashColumns.put("st5_20_opr5", getSt520Opr5());
		this.hashColumns.put("st5_40_opr6", getSt540Opr6());
		this.hashColumns.put("st5_40_opr5", getSt540Opr5());
		this.hashColumns.put("st5_20_opr6", getSt520Opr6());
		this.hashColumns.put("st5_20_opr3", getSt520Opr3());
		this.hashColumns.put("st5_40_opr8", getSt540Opr8());
		this.hashColumns.put("st5_20_opr4", getSt520Opr4());
		this.hashColumns.put("st5_40_opr7", getSt540Opr7());
		this.hashColumns.put("st5_20_opr9", getSt520Opr9());
		this.hashColumns.put("st5_40_opr9", getSt540Opr9());
		this.hashColumns.put("st5_20_opr7", getSt520Opr7());
		this.hashColumns.put("st5_20_opr8", getSt520Opr8());
		this.hashColumns.put("st9_45_opr10", getSt945Opr10());
		this.hashColumns.put("st9_4h_opr10", getSt94hOpr10());
		this.hashColumns.put("stwg_cgo_flg", getStwgCgoFlg());
		this.hashColumns.put("st15_40_opr10", getSt1540Opr10());
		this.hashColumns.put("st9_45_opr8", getSt945Opr8());
		this.hashColumns.put("st9_45_opr9", getSt945Opr9());
		this.hashColumns.put("st3_2h_opr9", getSt32hOpr9());
		this.hashColumns.put("st2_4h_opr1", getSt24hOpr1());
		this.hashColumns.put("st9_20_opr9", getSt920Opr9());
		this.hashColumns.put("st2_4h_opr3", getSt24hOpr3());
		this.hashColumns.put("st9_20_opr8", getSt920Opr8());
		this.hashColumns.put("st2_4h_opr2", getSt24hOpr2());
		this.hashColumns.put("st9_20_opr7", getSt920Opr7());
		this.hashColumns.put("st9_20_opr6", getSt920Opr6());
		this.hashColumns.put("st9_20_opr5", getSt920Opr5());
		this.hashColumns.put("st9_20_opr4", getSt920Opr4());
		this.hashColumns.put("st9_20_opr3", getSt920Opr3());
		this.hashColumns.put("st3_2h_opr4", getSt32hOpr4());
		this.hashColumns.put("st9_20_opr2", getSt920Opr2());
		this.hashColumns.put("st2_4h_opr9", getSt24hOpr9());
		this.hashColumns.put("st3_2h_opr3", getSt32hOpr3());
		this.hashColumns.put("st9_20_opr1", getSt920Opr1());
		this.hashColumns.put("stwg_cd", getStwgCd());
		this.hashColumns.put("st2_4h_opr8", getSt24hOpr8());
		this.hashColumns.put("st2_40_opr10", getSt240Opr10());
		this.hashColumns.put("st3_2h_opr2", getSt32hOpr2());
		this.hashColumns.put("st3_2h_opr1", getSt32hOpr1());
		this.hashColumns.put("st2_4h_opr5", getSt24hOpr5());
		this.hashColumns.put("st3_2h_opr8", getSt32hOpr8());
		this.hashColumns.put("st2_4h_opr4", getSt24hOpr4());
		this.hashColumns.put("st3_2h_opr7", getSt32hOpr7());
		this.hashColumns.put("st3_2h_opr6", getSt32hOpr6());
		this.hashColumns.put("st2_4h_opr7", getSt24hOpr7());
		this.hashColumns.put("st3_2h_opr5", getSt32hOpr5());
		this.hashColumns.put("st2_4h_opr6", getSt24hOpr6());
		this.hashColumns.put("st2_40_opr4", getSt240Opr4());
		this.hashColumns.put("st8_20_opr1", getSt820Opr1());
		this.hashColumns.put("st11_2h_opr10", getSt112hOpr10());
		this.hashColumns.put("st2_40_opr5", getSt240Opr5());
		this.hashColumns.put("st8_20_opr3", getSt820Opr3());
		this.hashColumns.put("st2_40_opr6", getSt240Opr6());
		this.hashColumns.put("st8_20_opr2", getSt820Opr2());
		this.hashColumns.put("st2_40_opr7", getSt240Opr7());
		this.hashColumns.put("st2_40_opr8", getSt240Opr8());
		this.hashColumns.put("st2_40_opr9", getSt240Opr9());
		this.hashColumns.put("st6_4h_opr7", getSt64hOpr7());
		this.hashColumns.put("st8_20_opr9", getSt820Opr9());
		this.hashColumns.put("st6_4h_opr6", getSt64hOpr6());
		this.hashColumns.put("st8_20_opr8", getSt820Opr8());
		this.hashColumns.put("st6_4h_opr5", getSt64hOpr5());
		this.hashColumns.put("st6_4h_opr4", getSt64hOpr4());
		this.hashColumns.put("st6_4h_opr3", getSt64hOpr3());
		this.hashColumns.put("st8_20_opr5", getSt820Opr5());
		this.hashColumns.put("st8_20_opr4", getSt820Opr4());
		this.hashColumns.put("st6_4h_opr2", getSt64hOpr2());
		this.hashColumns.put("st6_4h_opr1", getSt64hOpr1());
		this.hashColumns.put("st8_20_opr7", getSt820Opr7());
		this.hashColumns.put("st8_20_opr6", getSt820Opr6());
		this.hashColumns.put("st4_45_opr1", getSt445Opr1());
		this.hashColumns.put("st4_45_opr2", getSt445Opr2());
		this.hashColumns.put("st4_45_opr3", getSt445Opr3());
		this.hashColumns.put("st6_4h_opr8", getSt64hOpr8());
		this.hashColumns.put("st4_45_opr4", getSt445Opr4());
		this.hashColumns.put("st6_4h_opr9", getSt64hOpr9());
		this.hashColumns.put("st4_45_opr5", getSt445Opr5());
		this.hashColumns.put("st4_45_opr6", getSt445Opr6());
		this.hashColumns.put("st4_45_opr7", getSt445Opr7());
		this.hashColumns.put("st4_45_opr8", getSt445Opr8());
		this.hashColumns.put("st2_40_opr1", getSt240Opr1());
		this.hashColumns.put("st4_45_opr9", getSt445Opr9());
		this.hashColumns.put("st2_40_opr3", getSt240Opr3());
		this.hashColumns.put("st2_40_opr2", getSt240Opr2());
		this.hashColumns.put("st_9", getSt9());
		this.hashColumns.put("st_7", getSt7());
		this.hashColumns.put("st_8", getSt8());
		this.hashColumns.put("st_5", getSt5());
		this.hashColumns.put("st_6", getSt6());
		this.hashColumns.put("st_3", getSt3());
		this.hashColumns.put("st_4", getSt4());
		this.hashColumns.put("st_1", getSt1());
		this.hashColumns.put("st_2", getSt2());
		this.hashColumns.put("st9_40_opr10", getSt940Opr10());
		this.hashColumns.put("st12_20_opr10", getSt1220Opr10());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("st3_20_opr9", getSt320Opr9());
		this.hashColumns.put("st3_20_opr8", getSt320Opr8());
		this.hashColumns.put("st3_20_opr7", getSt320Opr7());
		this.hashColumns.put("st3_20_opr6", getSt320Opr6());
		this.hashColumns.put("st3_20_opr5", getSt320Opr5());
		this.hashColumns.put("st4_2h_opr10", getSt42hOpr10());
		this.hashColumns.put("st3_20_opr4", getSt320Opr4());
		this.hashColumns.put("st3_20_opr3", getSt320Opr3());
		this.hashColumns.put("st3_20_opr2", getSt320Opr2());
		this.hashColumns.put("st3_20_opr1", getSt320Opr1());
		this.hashColumns.put("st14_4h_opr9", getSt144hOpr9());
		this.hashColumns.put("st6_45_opr10", getSt645Opr10());
		this.hashColumns.put("st2_2h_opr1", getSt22hOpr1());
		this.hashColumns.put("st2_2h_opr8", getSt22hOpr8());
		this.hashColumns.put("st2_2h_opr9", getSt22hOpr9());
		this.hashColumns.put("st2_2h_opr6", getSt22hOpr6());
		this.hashColumns.put("st2_2h_opr7", getSt22hOpr7());
		this.hashColumns.put("st12_2h_opr10", getSt122hOpr10());
		this.hashColumns.put("st10_4h_opr10", getSt104hOpr10());
		this.hashColumns.put("st2_2h_opr4", getSt22hOpr4());
		this.hashColumns.put("st2_2h_opr5", getSt22hOpr5());
		this.hashColumns.put("st2_2h_opr2", getSt22hOpr2());
		this.hashColumns.put("st2_2h_opr3", getSt22hOpr3());
		this.hashColumns.put("st4_40_opr10", getSt440Opr10());
		this.hashColumns.put("st4_4h_opr6", getSt44hOpr6());
		this.hashColumns.put("st4_4h_opr7", getSt44hOpr7());
		this.hashColumns.put("st4_4h_opr8", getSt44hOpr8());
		this.hashColumns.put("st4_4h_opr9", getSt44hOpr9());
		this.hashColumns.put("st4_4h_opr2", getSt44hOpr2());
		this.hashColumns.put("st4_4h_opr3", getSt44hOpr3());
		this.hashColumns.put("st4_4h_opr4", getSt44hOpr4());
		this.hashColumns.put("st4_4h_opr5", getSt44hOpr5());
		this.hashColumns.put("st4_4h_opr1", getSt44hOpr1());
		this.hashColumns.put("bkg_shpr_ownr_flg", getBkgShprOwnrFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("st14_4h_opr1", getSt144hOpr1());
		this.hashColumns.put("st14_4h_opr2", getSt144hOpr2());
		this.hashColumns.put("st14_4h_opr3", getSt144hOpr3());
		this.hashColumns.put("st7_4h_opr10", getSt74hOpr10());
		this.hashColumns.put("st14_4h_opr4", getSt144hOpr4());
		this.hashColumns.put("st14_4h_opr5", getSt144hOpr5());
		this.hashColumns.put("st14_4h_opr6", getSt144hOpr6());
		this.hashColumns.put("st14_4h_opr7", getSt144hOpr7());
		this.hashColumns.put("st14_4h_opr8", getSt144hOpr8());
		this.hashColumns.put("st7_2h_opr10", getSt72hOpr10());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("st4_20_opr9", getSt420Opr9());
		this.hashColumns.put("st4_20_opr8", getSt420Opr8());
		this.hashColumns.put("st4_20_opr5", getSt420Opr5());
		this.hashColumns.put("st4_20_opr4", getSt420Opr4());
		this.hashColumns.put("st4_20_opr7", getSt420Opr7());
		this.hashColumns.put("st4_20_opr6", getSt420Opr6());
		this.hashColumns.put("st4_20_opr1", getSt420Opr1());
		this.hashColumns.put("st4_20_opr3", getSt420Opr3());
		this.hashColumns.put("st4_20_opr2", getSt420Opr2());
		this.hashColumns.put("st8_40_opr9", getSt840Opr9());
		this.hashColumns.put("st8_40_opr8", getSt840Opr8());
		this.hashColumns.put("st8_40_opr7", getSt840Opr7());
		this.hashColumns.put("st8_40_opr6", getSt840Opr6());
		this.hashColumns.put("st2_2h_opr10", getSt22hOpr10());
		this.hashColumns.put("st8_40_opr1", getSt840Opr1());
		this.hashColumns.put("st4_40_opr9", getSt440Opr9());
		this.hashColumns.put("st4_40_opr8", getSt440Opr8());
		this.hashColumns.put("st4_40_opr7", getSt440Opr7());
		this.hashColumns.put("st4_40_opr6", getSt440Opr6());
		this.hashColumns.put("st4_40_opr5", getSt440Opr5());
		this.hashColumns.put("st8_40_opr5", getSt840Opr5());
		this.hashColumns.put("st8_40_opr4", getSt840Opr4());
		this.hashColumns.put("st4_40_opr4", getSt440Opr4());
		this.hashColumns.put("st8_40_opr3", getSt840Opr3());
		this.hashColumns.put("st4_40_opr3", getSt440Opr3());
		this.hashColumns.put("st4_40_opr2", getSt440Opr2());
		this.hashColumns.put("st8_40_opr2", getSt840Opr2());
		this.hashColumns.put("st4_40_opr1", getSt440Opr1());
		this.hashColumns.put("st8_20_opr10", getSt820Opr10());
		this.hashColumns.put("st11_20_opr10", getSt1120Opr10());
		this.hashColumns.put("st6_20_opr9", getSt620Opr9());
		this.hashColumns.put("st6_20_opr8", getSt620Opr8());
		this.hashColumns.put("st6_20_opr7", getSt620Opr7());
		this.hashColumns.put("st6_20_opr6", getSt620Opr6());
		this.hashColumns.put("st6_20_opr1", getSt620Opr1());
		this.hashColumns.put("st6_20_opr5", getSt620Opr5());
		this.hashColumns.put("st6_20_opr4", getSt620Opr4());
		this.hashColumns.put("st6_20_opr3", getSt620Opr3());
		this.hashColumns.put("st6_20_opr2", getSt620Opr2());
		this.hashColumns.put("st12_40_opr9", getSt1240Opr9());
		this.hashColumns.put("st6_2h_opr1", getSt62hOpr1());
		this.hashColumns.put("st12_40_opr8", getSt1240Opr8());
		this.hashColumns.put("st12_40_opr7", getSt1240Opr7());
		this.hashColumns.put("st6_2h_opr3", getSt62hOpr3());
		this.hashColumns.put("st12_40_opr6", getSt1240Opr6());
		this.hashColumns.put("st6_2h_opr2", getSt62hOpr2());
		this.hashColumns.put("st12_40_opr5", getSt1240Opr5());
		this.hashColumns.put("st6_2h_opr5", getSt62hOpr5());
		this.hashColumns.put("st12_40_opr4", getSt1240Opr4());
		this.hashColumns.put("st6_2h_opr4", getSt62hOpr4());
		this.hashColumns.put("st12_40_opr3", getSt1240Opr3());
		this.hashColumns.put("st6_2h_opr6", getSt62hOpr6());
		this.hashColumns.put("st6_2h_opr7", getSt62hOpr7());
		this.hashColumns.put("st6_2h_opr8", getSt62hOpr8());
		this.hashColumns.put("st6_2h_opr9", getSt62hOpr9());
		this.hashColumns.put("st13_4h_opr10", getSt134hOpr10());
		this.hashColumns.put("st6_20_opr10", getSt620Opr10());
		this.hashColumns.put("st8_4h_opr10", getSt84hOpr10());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("st1_45_opr9", getSt145Opr9());
		this.hashColumns.put("st12_45_opr10", getSt1245Opr10());
		this.hashColumns.put("st1_45_opr8", getSt145Opr8());
		this.hashColumns.put("st15_4h_opr9", getSt154hOpr9());
		this.hashColumns.put("st15_4h_opr8", getSt154hOpr8());
		this.hashColumns.put("st13_45_opr10", getSt1345Opr10());
		this.hashColumns.put("st1_45_opr3", getSt145Opr3());
		this.hashColumns.put("st1_45_opr2", getSt145Opr2());
		this.hashColumns.put("st1_45_opr1", getSt145Opr1());
		this.hashColumns.put("st1_45_opr7", getSt145Opr7());
		this.hashColumns.put("st1_45_opr6", getSt145Opr6());
		this.hashColumns.put("st1_45_opr5", getSt145Opr5());
		this.hashColumns.put("st4_4h_opr10", getSt44hOpr10());
		this.hashColumns.put("st1_45_opr4", getSt145Opr4());
		this.hashColumns.put("st5_4h_opr4", getSt54hOpr4());
		this.hashColumns.put("opr7", getOpr7());
		this.hashColumns.put("st5_4h_opr3", getSt54hOpr3());
		this.hashColumns.put("opr8", getOpr8());
		this.hashColumns.put("opr5", getOpr5());
		this.hashColumns.put("st5_4h_opr2", getSt54hOpr2());
		this.hashColumns.put("st5_4h_opr1", getSt54hOpr1());
		this.hashColumns.put("opr6", getOpr6());
		this.hashColumns.put("opr3", getOpr3());
		this.hashColumns.put("st5_4h_opr8", getSt54hOpr8());
		this.hashColumns.put("opr4", getOpr4());
		this.hashColumns.put("st5_4h_opr7", getSt54hOpr7());
		this.hashColumns.put("opr1", getOpr1());
		this.hashColumns.put("st5_4h_opr6", getSt54hOpr6());
		this.hashColumns.put("st5_4h_opr5", getSt54hOpr5());
		this.hashColumns.put("opr2", getOpr2());
		this.hashColumns.put("opr9", getOpr9());
		this.hashColumns.put("st5_4h_opr9", getSt54hOpr9());
		this.hashColumns.put("st2_20_opr6", getSt220Opr6());
		this.hashColumns.put("st2_20_opr7", getSt220Opr7());
		this.hashColumns.put("st2_20_opr8", getSt220Opr8());
		this.hashColumns.put("st2_20_opr9", getSt220Opr9());
		this.hashColumns.put("st2_20_opr2", getSt220Opr2());
		this.hashColumns.put("st2_20_opr3", getSt220Opr3());
		this.hashColumns.put("st2_20_opr4", getSt220Opr4());
		this.hashColumns.put("st2_20_opr5", getSt220Opr5());
		this.hashColumns.put("st10_20_opr2", getSt1020Opr2());
		this.hashColumns.put("st10_20_opr1", getSt1020Opr1());
		this.hashColumns.put("st2_20_opr1", getSt220Opr1());
		this.hashColumns.put("st_15", getSt15());
		this.hashColumns.put("st_14", getSt14());
		this.hashColumns.put("st_13", getSt13());
		this.hashColumns.put("st_12", getSt12());
		this.hashColumns.put("st_11", getSt11());
		this.hashColumns.put("st_10", getSt10());
		this.hashColumns.put("st13_4h_opr1", getSt134hOpr1());
		this.hashColumns.put("st13_4h_opr2", getSt134hOpr2());
		this.hashColumns.put("st7_2h_opr5", getSt72hOpr5());
		this.hashColumns.put("st13_4h_opr3", getSt134hOpr3());
		this.hashColumns.put("st7_2h_opr6", getSt72hOpr6());
		this.hashColumns.put("st13_4h_opr4", getSt134hOpr4());
		this.hashColumns.put("st7_2h_opr7", getSt72hOpr7());
		this.hashColumns.put("st13_4h_opr5", getSt134hOpr5());
		this.hashColumns.put("st7_2h_opr8", getSt72hOpr8());
		this.hashColumns.put("st13_4h_opr6", getSt134hOpr6());
		this.hashColumns.put("st7_2h_opr9", getSt72hOpr9());
		this.hashColumns.put("st13_4h_opr7", getSt134hOpr7());
		this.hashColumns.put("st13_4h_opr8", getSt134hOpr8());
		this.hashColumns.put("st13_4h_opr9", getSt134hOpr9());
		this.hashColumns.put("st15_4h_opr1", getSt154hOpr1());
		this.hashColumns.put("st15_4h_opr3", getSt154hOpr3());
		this.hashColumns.put("st15_4h_opr2", getSt154hOpr2());
		this.hashColumns.put("st14_40_opr9", getSt1440Opr9());
		this.hashColumns.put("st10_40_opr4", getSt1040Opr4());
		this.hashColumns.put("st7_2h_opr2", getSt72hOpr2());
		this.hashColumns.put("st15_4h_opr5", getSt154hOpr5());
		this.hashColumns.put("st15_4h_opr4", getSt154hOpr4());
		this.hashColumns.put("st10_40_opr3", getSt1040Opr3());
		this.hashColumns.put("st7_2h_opr1", getSt72hOpr1());
		this.hashColumns.put("st7_2h_opr4", getSt72hOpr4());
		this.hashColumns.put("st10_40_opr2", getSt1040Opr2());
		this.hashColumns.put("st15_4h_opr7", getSt154hOpr7());
		this.hashColumns.put("st7_2h_opr3", getSt72hOpr3());
		this.hashColumns.put("st10_40_opr1", getSt1040Opr1());
		this.hashColumns.put("st15_4h_opr6", getSt154hOpr6());
		this.hashColumns.put("st14_40_opr4", getSt1440Opr4());
		this.hashColumns.put("st14_40_opr3", getSt1440Opr3());
		this.hashColumns.put("st14_40_opr2", getSt1440Opr2());
		this.hashColumns.put("st14_40_opr1", getSt1440Opr1());
		this.hashColumns.put("st14_40_opr8", getSt1440Opr8());
		this.hashColumns.put("st14_40_opr7", getSt1440Opr7());
		this.hashColumns.put("st14_40_opr6", getSt1440Opr6());
		this.hashColumns.put("st14_40_opr5", getSt1440Opr5());
		this.hashColumns.put("st10_2h_opr1", getSt102hOpr1());
		this.hashColumns.put("st10_2h_opr2", getSt102hOpr2());
		this.hashColumns.put("st10_2h_opr7", getSt102hOpr7());
		this.hashColumns.put("st10_2h_opr8", getSt102hOpr8());
		this.hashColumns.put("st10_2h_opr9", getSt102hOpr9());
		this.hashColumns.put("st10_2h_opr3", getSt102hOpr3());
		this.hashColumns.put("st10_2h_opr4", getSt102hOpr4());
		this.hashColumns.put("st10_2h_opr5", getSt102hOpr5());
		this.hashColumns.put("st10_2h_opr6", getSt102hOpr6());
		this.hashColumns.put("st3_20_opr10", getSt320Opr10());
		this.hashColumns.put("st10_20_opr3", getSt1020Opr3());
		this.hashColumns.put("st10_20_opr4", getSt1020Opr4());
		this.hashColumns.put("st10_20_opr5", getSt1020Opr5());
		this.hashColumns.put("st10_20_opr6", getSt1020Opr6());
		this.hashColumns.put("st12_40_opr2", getSt1240Opr2());
		this.hashColumns.put("st10_20_opr7", getSt1020Opr7());
		this.hashColumns.put("st12_40_opr1", getSt1240Opr1());
		this.hashColumns.put("st10_20_opr8", getSt1020Opr8());
		this.hashColumns.put("st10_20_opr9", getSt1020Opr9());
		this.hashColumns.put("st12_40_opr10", getSt1240Opr10());
		this.hashColumns.put("st1_4h_opr9", getSt14hOpr9());
		this.hashColumns.put("st11_40_opr10", getSt1140Opr10());
		this.hashColumns.put("st1_4h_opr5", getSt14hOpr5());
		this.hashColumns.put("st1_4h_opr6", getSt14hOpr6());
		this.hashColumns.put("st1_4h_opr7", getSt14hOpr7());
		this.hashColumns.put("st1_4h_opr8", getSt14hOpr8());
		this.hashColumns.put("st1_4h_opr1", getSt14hOpr1());
		this.hashColumns.put("st1_4h_opr2", getSt14hOpr2());
		this.hashColumns.put("st1_4h_opr3", getSt14hOpr3());
		this.hashColumns.put("st1_4h_opr4", getSt14hOpr4());
		this.hashColumns.put("st8_40_opr10", getSt840Opr10());
		this.hashColumns.put("mlb", getMlb());
		this.hashColumns.put("st10_2h_opr10", getSt102hOpr10());
		this.hashColumns.put("awk_cgo_flg", getAwkCgoFlg());
		this.hashColumns.put("st4_2h_opr1", getSt42hOpr1());
		this.hashColumns.put("st10_40_opr9", getSt1040Opr9());
		this.hashColumns.put("st4_2h_opr3", getSt42hOpr3());
		this.hashColumns.put("st4_2h_opr2", getSt42hOpr2());
		this.hashColumns.put("st4_2h_opr5", getSt42hOpr5());
		this.hashColumns.put("st10_40_opr6", getSt1040Opr6());
		this.hashColumns.put("st2_20_opr10", getSt220Opr10());
		this.hashColumns.put("st4_2h_opr4", getSt42hOpr4());
		this.hashColumns.put("st10_40_opr5", getSt1040Opr5());
		this.hashColumns.put("st4_2h_opr7", getSt42hOpr7());
		this.hashColumns.put("st10_40_opr8", getSt1040Opr8());
		this.hashColumns.put("st4_2h_opr6", getSt42hOpr6());
		this.hashColumns.put("st10_40_opr7", getSt1040Opr7());
		this.hashColumns.put("st7_45_opr3", getSt745Opr3());
		this.hashColumns.put("st7_45_opr2", getSt745Opr2());
		this.hashColumns.put("st7_45_opr5", getSt745Opr5());
		this.hashColumns.put("st7_45_opr4", getSt745Opr4());
		this.hashColumns.put("st7_45_opr7", getSt745Opr7());
		this.hashColumns.put("st7_45_opr6", getSt745Opr6());
		this.hashColumns.put("st7_45_opr9", getSt745Opr9());
		this.hashColumns.put("st7_45_opr8", getSt745Opr8());
		this.hashColumns.put("st4_2h_opr8", getSt42hOpr8());
		this.hashColumns.put("st4_2h_opr9", getSt42hOpr9());
		this.hashColumns.put("st7_45_opr1", getSt745Opr1());
		this.hashColumns.put("st11_4h_opr10", getSt114hOpr10());
		this.hashColumns.put("st1_40_opr6", getSt140Opr6());
		this.hashColumns.put("st1_40_opr5", getSt140Opr5());
		this.hashColumns.put("st1_40_opr8", getSt140Opr8());
		this.hashColumns.put("st1_40_opr7", getSt140Opr7());
		this.hashColumns.put("st1_40_opr9", getSt140Opr9());
		this.hashColumns.put("st14_2h_opr10", getSt142hOpr10());
		this.hashColumns.put("st1_40_opr1", getSt140Opr1());
		this.hashColumns.put("st1_40_opr2", getSt140Opr2());
		this.hashColumns.put("st1_40_opr3", getSt140Opr3());
		this.hashColumns.put("st5_4h_opr10", getSt54hOpr10());
		this.hashColumns.put("st1_40_opr4", getSt140Opr4());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("st7_20_opr10", "st720Opr10");
		this.hashFields.put("st7_40_opr7", "st740Opr7");
		this.hashFields.put("st14_45_opr10", "st1445Opr10");
		this.hashFields.put("st7_40_opr8", "st740Opr8");
		this.hashFields.put("st7_40_opr9", "st740Opr9");
		this.hashFields.put("st1_40_opr10", "st140Opr10");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("st7_40_opr1", "st740Opr1");
		this.hashFields.put("st7_40_opr2", "st740Opr2");
		this.hashFields.put("st7_40_opr3", "st740Opr3");
		this.hashFields.put("st7_40_opr4", "st740Opr4");
		this.hashFields.put("st7_40_opr5", "st740Opr5");
		this.hashFields.put("st7_40_opr6", "st740Opr6");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("st1_45_opr10", "st145Opr10");
		this.hashFields.put("st15_45_opr10", "st1545Opr10");
		this.hashFields.put("st6_40_opr10", "st640Opr10");
		this.hashFields.put("st13_40_opr10", "st1340Opr10");
		this.hashFields.put("st5_20_opr10", "st520Opr10");
		this.hashFields.put("st15_4h_opr10", "st154hOpr10");
		this.hashFields.put("st8_2h_opr10", "st82hOpr10");
		this.hashFields.put("st8_45_opr10", "st845Opr10");
		this.hashFields.put("st6_45_opr3", "st645Opr3");
		this.hashFields.put("st6_45_opr4", "st645Opr4");
		this.hashFields.put("st6_45_opr5", "st645Opr5");
		this.hashFields.put("st5_45_opr8", "st545Opr8");
		this.hashFields.put("st6_45_opr6", "st645Opr6");
		this.hashFields.put("st5_45_opr9", "st545Opr9");
		this.hashFields.put("st5_45_opr6", "st545Opr6");
		this.hashFields.put("st6_45_opr7", "st645Opr7");
		this.hashFields.put("st5_45_opr7", "st545Opr7");
		this.hashFields.put("st6_45_opr8", "st645Opr8");
		this.hashFields.put("st5_45_opr4", "st545Opr4");
		this.hashFields.put("st6_45_opr9", "st645Opr9");
		this.hashFields.put("st5_45_opr5", "st545Opr5");
		this.hashFields.put("st5_45_opr2", "st545Opr2");
		this.hashFields.put("st5_45_opr3", "st545Opr3");
		this.hashFields.put("st11_45_opr10", "st1145Opr10");
		this.hashFields.put("st5_45_opr1", "st545Opr1");
		this.hashFields.put("st6_45_opr1", "st645Opr1");
		this.hashFields.put("st6_45_opr2", "st645Opr2");
		this.hashFields.put("st11_4h_opr8", "st114hOpr8");
		this.hashFields.put("st11_4h_opr9", "st114hOpr9");
		this.hashFields.put("st11_4h_opr4", "st114hOpr4");
		this.hashFields.put("st11_4h_opr5", "st114hOpr5");
		this.hashFields.put("st11_4h_opr6", "st114hOpr6");
		this.hashFields.put("st11_4h_opr7", "st114hOpr7");
		this.hashFields.put("st11_4h_opr1", "st114hOpr1");
		this.hashFields.put("st11_4h_opr2", "st114hOpr2");
		this.hashFields.put("st11_4h_opr3", "st114hOpr3");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("st7_45_opr10", "st745Opr10");
		this.hashFields.put("st13_20_opr10", "st1320Opr10");
		this.hashFields.put("st12_2h_opr1", "st122hOpr1");
		this.hashFields.put("st12_2h_opr2", "st122hOpr2");
		this.hashFields.put("st12_2h_opr3", "st122hOpr3");
		this.hashFields.put("st12_2h_opr4", "st122hOpr4");
		this.hashFields.put("st12_2h_opr5", "st122hOpr5");
		this.hashFields.put("st12_2h_opr6", "st122hOpr6");
		this.hashFields.put("st12_2h_opr7", "st122hOpr7");
		this.hashFields.put("st12_2h_opr8", "st122hOpr8");
		this.hashFields.put("st8_45_opr5", "st845Opr5");
		this.hashFields.put("st10_4h_opr6", "st104hOpr6");
		this.hashFields.put("st14_45_opr9", "st1445Opr9");
		this.hashFields.put("st10_4h_opr5", "st104hOpr5");
		this.hashFields.put("st8_45_opr6", "st845Opr6");
		this.hashFields.put("st14_45_opr8", "st1445Opr8");
		this.hashFields.put("st11_45_opr1", "st1145Opr1");
		this.hashFields.put("st8_45_opr7", "st845Opr7");
		this.hashFields.put("st10_4h_opr8", "st104hOpr8");
		this.hashFields.put("st11_45_opr2", "st1145Opr2");
		this.hashFields.put("st10_4h_opr7", "st104hOpr7");
		this.hashFields.put("st8_45_opr8", "st845Opr8");
		this.hashFields.put("st11_45_opr3", "st1145Opr3");
		this.hashFields.put("st8_45_opr1", "st845Opr1");
		this.hashFields.put("st14_45_opr5", "st1445Opr5");
		this.hashFields.put("st14_45_opr4", "st1445Opr4");
		this.hashFields.put("st11_45_opr4", "st1145Opr4");
		this.hashFields.put("st8_45_opr2", "st845Opr2");
		this.hashFields.put("st10_4h_opr9", "st104hOpr9");
		this.hashFields.put("st8_45_opr3", "st845Opr3");
		this.hashFields.put("st11_45_opr5", "st1145Opr5");
		this.hashFields.put("st14_45_opr7", "st1445Opr7");
		this.hashFields.put("st8_45_opr4", "st845Opr4");
		this.hashFields.put("st11_45_opr6", "st1145Opr6");
		this.hashFields.put("st14_45_opr6", "st1445Opr6");
		this.hashFields.put("st14_45_opr1", "st1445Opr1");
		this.hashFields.put("st11_45_opr7", "st1145Opr7");
		this.hashFields.put("st11_45_opr8", "st1145Opr8");
		this.hashFields.put("st14_45_opr3", "st1445Opr3");
		this.hashFields.put("st11_45_opr9", "st1145Opr9");
		this.hashFields.put("st14_45_opr2", "st1445Opr2");
		this.hashFields.put("st10_4h_opr2", "st104hOpr2");
		this.hashFields.put("st10_4h_opr1", "st104hOpr1");
		this.hashFields.put("st10_4h_opr4", "st104hOpr4");
		this.hashFields.put("st10_4h_opr3", "st104hOpr3");
		this.hashFields.put("st8_45_opr9", "st845Opr9");
		this.hashFields.put("st3_4h_opr2", "st34hOpr2");
		this.hashFields.put("st3_4h_opr1", "st34hOpr1");
		this.hashFields.put("st3_4h_opr4", "st34hOpr4");
		this.hashFields.put("st3_4h_opr3", "st34hOpr3");
		this.hashFields.put("st3_4h_opr6", "st34hOpr6");
		this.hashFields.put("st3_4h_opr5", "st34hOpr5");
		this.hashFields.put("st3_4h_opr8", "st34hOpr8");
		this.hashFields.put("st3_4h_opr7", "st34hOpr7");
		this.hashFields.put("st3_4h_opr9", "st34hOpr9");
		this.hashFields.put("st13_45_opr3", "st1345Opr3");
		this.hashFields.put("st13_45_opr4", "st1345Opr4");
		this.hashFields.put("st13_45_opr1", "st1345Opr1");
		this.hashFields.put("st13_45_opr2", "st1345Opr2");
		this.hashFields.put("st13_45_opr9", "st1345Opr9");
		this.hashFields.put("st13_45_opr7", "st1345Opr7");
		this.hashFields.put("st13_45_opr8", "st1345Opr8");
		this.hashFields.put("st13_45_opr5", "st1345Opr5");
		this.hashFields.put("st13_45_opr6", "st1345Opr6");
		this.hashFields.put("st1_2h_opr10", "st12hOpr10");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("st5_45_opr10", "st545Opr10");
		this.hashFields.put("st15_2h_opr8", "st152hOpr8");
		this.hashFields.put("st15_2h_opr9", "st152hOpr9");
		this.hashFields.put("st15_2h_opr6", "st152hOpr6");
		this.hashFields.put("st15_2h_opr7", "st152hOpr7");
		this.hashFields.put("st11_40_opr1", "st1140Opr1");
		this.hashFields.put("st11_40_opr2", "st1140Opr2");
		this.hashFields.put("st11_40_opr3", "st1140Opr3");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("st14_20_opr10", "st1420Opr10");
		this.hashFields.put("st14_2h_opr8", "st142hOpr8");
		this.hashFields.put("st14_2h_opr7", "st142hOpr7");
		this.hashFields.put("st14_2h_opr9", "st142hOpr9");
		this.hashFields.put("st7_4h_opr9", "st74hOpr9");
		this.hashFields.put("st7_4h_opr7", "st74hOpr7");
		this.hashFields.put("st7_4h_opr8", "st74hOpr8");
		this.hashFields.put("st7_4h_opr6", "st74hOpr6");
		this.hashFields.put("st12_20_opr9", "st1220Opr9");
		this.hashFields.put("st7_4h_opr5", "st74hOpr5");
		this.hashFields.put("st7_4h_opr4", "st74hOpr4");
		this.hashFields.put("st7_4h_opr3", "st74hOpr3");
		this.hashFields.put("st7_4h_opr2", "st74hOpr2");
		this.hashFields.put("st7_4h_opr1", "st74hOpr1");
		this.hashFields.put("opr10", "opr10");
		this.hashFields.put("st12_20_opr1", "st1220Opr1");
		this.hashFields.put("st12_20_opr2", "st1220Opr2");
		this.hashFields.put("st12_20_opr3", "st1220Opr3");
		this.hashFields.put("st12_20_opr4", "st1220Opr4");
		this.hashFields.put("st12_20_opr5", "st1220Opr5");
		this.hashFields.put("st12_20_opr6", "st1220Opr6");
		this.hashFields.put("st12_20_opr7", "st1220Opr7");
		this.hashFields.put("st12_4h_opr10", "st124hOpr10");
		this.hashFields.put("st12_20_opr8", "st1220Opr8");
		this.hashFields.put("st8_2h_opr7", "st82hOpr7");
		this.hashFields.put("st8_2h_opr6", "st82hOpr6");
		this.hashFields.put("st8_2h_opr5", "st82hOpr5");
		this.hashFields.put("st8_2h_opr4", "st82hOpr4");
		this.hashFields.put("st8_2h_opr9", "st82hOpr9");
		this.hashFields.put("st8_2h_opr8", "st82hOpr8");
		this.hashFields.put("st8_2h_opr2", "st82hOpr2");
		this.hashFields.put("st8_2h_opr3", "st82hOpr3");
		this.hashFields.put("st8_2h_opr1", "st82hOpr1");
		this.hashFields.put("st9_2h_opr3", "st92hOpr3");
		this.hashFields.put("st9_2h_opr4", "st92hOpr4");
		this.hashFields.put("st9_2h_opr5", "st92hOpr5");
		this.hashFields.put("st9_2h_opr6", "st92hOpr6");
		this.hashFields.put("st9_2h_opr7", "st92hOpr7");
		this.hashFields.put("st9_2h_opr8", "st92hOpr8");
		this.hashFields.put("st9_2h_opr9", "st92hOpr9");
		this.hashFields.put("st10_20_opr10", "st1020Opr10");
		this.hashFields.put("st11_40_opr9", "st1140Opr9");
		this.hashFields.put("st11_40_opr8", "st1140Opr8");
		this.hashFields.put("st11_40_opr7", "st1140Opr7");
		this.hashFields.put("st11_40_opr6", "st1140Opr6");
		this.hashFields.put("st11_40_opr5", "st1140Opr5");
		this.hashFields.put("st11_40_opr4", "st1140Opr4");
		this.hashFields.put("st2_45_opr3", "st245Opr3");
		this.hashFields.put("st2_45_opr4", "st245Opr4");
		this.hashFields.put("st7_40_opr10", "st740Opr10");
		this.hashFields.put("st2_45_opr5", "st245Opr5");
		this.hashFields.put("st15_2h_opr1", "st152hOpr1");
		this.hashFields.put("st2_45_opr6", "st245Opr6");
		this.hashFields.put("st15_2h_opr3", "st152hOpr3");
		this.hashFields.put("st15_2h_opr2", "st152hOpr2");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("st2_45_opr1", "st245Opr1");
		this.hashFields.put("st15_2h_opr5", "st152hOpr5");
		this.hashFields.put("st15_2h_opr4", "st152hOpr4");
		this.hashFields.put("st2_45_opr2", "st245Opr2");
		this.hashFields.put("st2_45_opr7", "st245Opr7");
		this.hashFields.put("st9_20_opr10", "st920Opr10");
		this.hashFields.put("st2_45_opr8", "st245Opr8");
		this.hashFields.put("st9_2h_opr2", "st92hOpr2");
		this.hashFields.put("st2_45_opr9", "st245Opr9");
		this.hashFields.put("st9_2h_opr1", "st92hOpr1");
		this.hashFields.put("st5_2h_opr2", "st52hOpr2");
		this.hashFields.put("st5_2h_opr1", "st52hOpr1");
		this.hashFields.put("st5_2h_opr6", "st52hOpr6");
		this.hashFields.put("st5_2h_opr5", "st52hOpr5");
		this.hashFields.put("st5_2h_opr4", "st52hOpr4");
		this.hashFields.put("st5_2h_opr3", "st52hOpr3");
		this.hashFields.put("st14_4h_opr10", "st144hOpr10");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("st5_2h_opr9", "st52hOpr9");
		this.hashFields.put("st5_2h_opr7", "st52hOpr7");
		this.hashFields.put("st5_2h_opr8", "st52hOpr8");
		this.hashFields.put("st12_2h_opr9", "st122hOpr9");
		this.hashFields.put("st12_4h_opr4", "st124hOpr4");
		this.hashFields.put("st9_40_opr2", "st940Opr2");
		this.hashFields.put("st12_4h_opr3", "st124hOpr3");
		this.hashFields.put("st9_40_opr1", "st940Opr1");
		this.hashFields.put("st9_40_opr4", "st940Opr4");
		this.hashFields.put("st12_4h_opr6", "st124hOpr6");
		this.hashFields.put("st9_40_opr3", "st940Opr3");
		this.hashFields.put("st12_4h_opr5", "st124hOpr5");
		this.hashFields.put("st12_4h_opr8", "st124hOpr8");
		this.hashFields.put("st12_4h_opr7", "st124hOpr7");
		this.hashFields.put("st2_45_opr10", "st245Opr10");
		this.hashFields.put("st12_4h_opr9", "st124hOpr9");
		this.hashFields.put("st9_40_opr9", "st940Opr9");
		this.hashFields.put("st9_40_opr6", "st940Opr6");
		this.hashFields.put("st9_40_opr5", "st940Opr5");
		this.hashFields.put("st12_4h_opr2", "st124hOpr2");
		this.hashFields.put("st9_40_opr8", "st940Opr8");
		this.hashFields.put("st3_2h_opr10", "st32hOpr10");
		this.hashFields.put("st12_4h_opr1", "st124hOpr1");
		this.hashFields.put("st9_40_opr7", "st940Opr7");
		this.hashFields.put("st14_2h_opr6", "st142hOpr6");
		this.hashFields.put("st14_2h_opr5", "st142hOpr5");
		this.hashFields.put("st14_2h_opr4", "st142hOpr4");
		this.hashFields.put("st14_2h_opr3", "st142hOpr3");
		this.hashFields.put("st14_2h_opr2", "st142hOpr2");
		this.hashFields.put("st14_2h_opr1", "st142hOpr1");
		this.hashFields.put("st9_4h_opr1", "st94hOpr1");
		this.hashFields.put("st9_4h_opr2", "st94hOpr2");
		this.hashFields.put("st9_4h_opr3", "st94hOpr3");
		this.hashFields.put("st9_4h_opr4", "st94hOpr4");
		this.hashFields.put("st15_20_opr1", "st1520Opr1");
		this.hashFields.put("st9_4h_opr9", "st94hOpr9");
		this.hashFields.put("st11_2h_opr1", "st112hOpr1");
		this.hashFields.put("st15_20_opr5", "st1520Opr5");
		this.hashFields.put("st9_4h_opr6", "st94hOpr6");
		this.hashFields.put("st15_20_opr4", "st1520Opr4");
		this.hashFields.put("st9_4h_opr5", "st94hOpr5");
		this.hashFields.put("st15_20_opr3", "st1520Opr3");
		this.hashFields.put("st9_4h_opr8", "st94hOpr8");
		this.hashFields.put("st15_20_opr2", "st1520Opr2");
		this.hashFields.put("st9_4h_opr7", "st94hOpr7");
		this.hashFields.put("st11_2h_opr6", "st112hOpr6");
		this.hashFields.put("st15_20_opr9", "st1520Opr9");
		this.hashFields.put("st11_2h_opr7", "st112hOpr7");
		this.hashFields.put("st15_20_opr8", "st1520Opr8");
		this.hashFields.put("st15_20_opr7", "st1520Opr7");
		this.hashFields.put("st11_2h_opr8", "st112hOpr8");
		this.hashFields.put("st15_20_opr6", "st1520Opr6");
		this.hashFields.put("st11_2h_opr9", "st112hOpr9");
		this.hashFields.put("st11_2h_opr2", "st112hOpr2");
		this.hashFields.put("st11_2h_opr3", "st112hOpr3");
		this.hashFields.put("st3_40_opr10", "st340Opr10");
		this.hashFields.put("st11_2h_opr4", "st112hOpr4");
		this.hashFields.put("st11_2h_opr5", "st112hOpr5");
		this.hashFields.put("st11_20_opr7", "st1120Opr7");
		this.hashFields.put("st11_20_opr6", "st1120Opr6");
		this.hashFields.put("st11_20_opr9", "st1120Opr9");
		this.hashFields.put("st11_20_opr8", "st1120Opr8");
		this.hashFields.put("st11_20_opr3", "st1120Opr3");
		this.hashFields.put("st11_20_opr2", "st1120Opr2");
		this.hashFields.put("st11_20_opr5", "st1120Opr5");
		this.hashFields.put("st11_20_opr4", "st1120Opr4");
		this.hashFields.put("st13_2h_opr4", "st132hOpr4");
		this.hashFields.put("st13_2h_opr5", "st132hOpr5");
		this.hashFields.put("st13_2h_opr6", "st132hOpr6");
		this.hashFields.put("st13_2h_opr7", "st132hOpr7");
		this.hashFields.put("st13_2h_opr1", "st132hOpr1");
		this.hashFields.put("st13_2h_opr2", "st132hOpr2");
		this.hashFields.put("st13_2h_opr3", "st132hOpr3");
		this.hashFields.put("st2_4h_opr10", "st24hOpr10");
		this.hashFields.put("st3_45_opr10", "st345Opr10");
		this.hashFields.put("qty1", "qty1");
		this.hashFields.put("qty3", "qty3");
		this.hashFields.put("qty2", "qty2");
		this.hashFields.put("qty5", "qty5");
		this.hashFields.put("qty4", "qty4");
		this.hashFields.put("st7_20_opr7", "st720Opr7");
		this.hashFields.put("st7_20_opr8", "st720Opr8");
		this.hashFields.put("st7_20_opr5", "st720Opr5");
		this.hashFields.put("st7_20_opr6", "st720Opr6");
		this.hashFields.put("st7_20_opr9", "st720Opr9");
		this.hashFields.put("st3_4h_opr10", "st34hOpr10");
		this.hashFields.put("st6_2h_opr10", "st62hOpr10");
		this.hashFields.put("st14_40_opr10", "st1440Opr10");
		this.hashFields.put("st7_20_opr3", "st720Opr3");
		this.hashFields.put("st7_20_opr4", "st720Opr4");
		this.hashFields.put("st7_20_opr1", "st720Opr1");
		this.hashFields.put("st7_20_opr2", "st720Opr2");
		this.hashFields.put("st10_45_opr10", "st1045Opr10");
		this.hashFields.put("st15_40_opr1", "st1540Opr1");
		this.hashFields.put("st15_40_opr2", "st1540Opr2");
		this.hashFields.put("st15_40_opr3", "st1540Opr3");
		this.hashFields.put("st15_40_opr4", "st1540Opr4");
		this.hashFields.put("st15_40_opr5", "st1540Opr5");
		this.hashFields.put("st15_40_opr6", "st1540Opr6");
		this.hashFields.put("st15_40_opr7", "st1540Opr7");
		this.hashFields.put("st15_40_opr8", "st1540Opr8");
		this.hashFields.put("st15_40_opr9", "st1540Opr9");
		this.hashFields.put("qty8", "qty8");
		this.hashFields.put("st15_45_opr1", "st1545Opr1");
		this.hashFields.put("st15_45_opr2", "st1545Opr2");
		this.hashFields.put("qty9", "qty9");
		this.hashFields.put("qty6", "qty6");
		this.hashFields.put("st4_20_opr10", "st420Opr10");
		this.hashFields.put("qty7", "qty7");
		this.hashFields.put("st15_45_opr5", "st1545Opr5");
		this.hashFields.put("st15_45_opr6", "st1545Opr6");
		this.hashFields.put("st15_45_opr3", "st1545Opr3");
		this.hashFields.put("st15_45_opr4", "st1545Opr4");
		this.hashFields.put("st15_45_opr9", "st1545Opr9");
		this.hashFields.put("st15_45_opr7", "st1545Opr7");
		this.hashFields.put("st15_45_opr8", "st1545Opr8");
		this.hashFields.put("st13_20_opr1", "st1320Opr1");
		this.hashFields.put("st13_20_opr3", "st1320Opr3");
		this.hashFields.put("st13_2h_opr9", "st132hOpr9");
		this.hashFields.put("st13_20_opr2", "st1320Opr2");
		this.hashFields.put("st13_2h_opr8", "st132hOpr8");
		this.hashFields.put("st13_20_opr5", "st1320Opr5");
		this.hashFields.put("st13_20_opr4", "st1320Opr4");
		this.hashFields.put("st13_20_opr7", "st1320Opr7");
		this.hashFields.put("st13_20_opr6", "st1320Opr6");
		this.hashFields.put("st13_20_opr9", "st1320Opr9");
		this.hashFields.put("st13_20_opr8", "st1320Opr8");
		this.hashFields.put("st3_40_opr1", "st340Opr1");
		this.hashFields.put("st3_40_opr2", "st340Opr2");
		this.hashFields.put("st3_40_opr9", "st340Opr9");
		this.hashFields.put("st3_40_opr8", "st340Opr8");
		this.hashFields.put("st3_40_opr7", "st340Opr7");
		this.hashFields.put("st3_40_opr6", "st340Opr6");
		this.hashFields.put("st3_40_opr5", "st340Opr5");
		this.hashFields.put("st3_40_opr4", "st340Opr4");
		this.hashFields.put("st3_40_opr3", "st340Opr3");
		this.hashFields.put("all_flg", "allFlg");
		this.hashFields.put("st4_45_opr10", "st445Opr10");
		this.hashFields.put("st1_20_opr1", "st120Opr1");
		this.hashFields.put("st1_20_opr2", "st120Opr2");
		this.hashFields.put("st1_20_opr10", "st120Opr10");
		this.hashFields.put("st13_2h_opr10", "st132hOpr10");
		this.hashFields.put("st1_20_opr4", "st120Opr4");
		this.hashFields.put("st1_20_opr3", "st120Opr3");
		this.hashFields.put("st1_20_opr6", "st120Opr6");
		this.hashFields.put("st1_20_opr5", "st120Opr5");
		this.hashFields.put("st1_20_opr8", "st120Opr8");
		this.hashFields.put("st1_20_opr7", "st120Opr7");
		this.hashFields.put("st1_20_opr9", "st120Opr9");
		this.hashFields.put("st10_40_opr10", "st1040Opr10");
		this.hashFields.put("st9_2h_opr10", "st92hOpr10");
		this.hashFields.put("st10_45_opr5", "st1045Opr5");
		this.hashFields.put("st10_45_opr4", "st1045Opr4");
		this.hashFields.put("st10_45_opr7", "st1045Opr7");
		this.hashFields.put("st10_45_opr6", "st1045Opr6");
		this.hashFields.put("st10_45_opr1", "st1045Opr1");
		this.hashFields.put("st5_40_opr10", "st540Opr10");
		this.hashFields.put("st10_45_opr3", "st1045Opr3");
		this.hashFields.put("bb_cgo_flg", "bbCgoFlg");
		this.hashFields.put("st10_45_opr2", "st1045Opr2");
		this.hashFields.put("st10_45_opr9", "st1045Opr9");
		this.hashFields.put("st10_45_opr8", "st1045Opr8");
		this.hashFields.put("mlb_cd", "mlbCd");
		this.hashFields.put("st15_20_opr10", "st1520Opr10");
		this.hashFields.put("st3_45_opr7", "st345Opr7");
		this.hashFields.put("st3_45_opr6", "st345Opr6");
		this.hashFields.put("st3_45_opr9", "st345Opr9");
		this.hashFields.put("st3_45_opr8", "st345Opr8");
		this.hashFields.put("st11_20_opr1", "st1120Opr1");
		this.hashFields.put("st3_45_opr1", "st345Opr1");
		this.hashFields.put("st3_45_opr3", "st345Opr3");
		this.hashFields.put("st3_45_opr2", "st345Opr2");
		this.hashFields.put("st3_45_opr5", "st345Opr5");
		this.hashFields.put("st3_45_opr4", "st345Opr4");
		this.hashFields.put("st1_2h_opr2", "st12hOpr2");
		this.hashFields.put("st1_2h_opr1", "st12hOpr1");
		this.hashFields.put("st13_40_opr1", "st1340Opr1");
		this.hashFields.put("st1_2h_opr8", "st12hOpr8");
		this.hashFields.put("st1_2h_opr7", "st12hOpr7");
		this.hashFields.put("st1_2h_opr9", "st12hOpr9");
		this.hashFields.put("st1_2h_opr4", "st12hOpr4");
		this.hashFields.put("st1_2h_opr3", "st12hOpr3");
		this.hashFields.put("st1_2h_opr6", "st12hOpr6");
		this.hashFields.put("st1_2h_opr5", "st12hOpr5");
		this.hashFields.put("st14_20_opr6", "st1420Opr6");
		this.hashFields.put("st14_20_opr5", "st1420Opr5");
		this.hashFields.put("st14_20_opr4", "st1420Opr4");
		this.hashFields.put("st14_20_opr3", "st1420Opr3");
		this.hashFields.put("st14_20_opr2", "st1420Opr2");
		this.hashFields.put("st14_20_opr1", "st1420Opr1");
		this.hashFields.put("st14_20_opr9", "st1420Opr9");
		this.hashFields.put("st14_20_opr8", "st1420Opr8");
		this.hashFields.put("st14_20_opr7", "st1420Opr7");
		this.hashFields.put("st8_4h_opr1", "st84hOpr1");
		this.hashFields.put("st8_4h_opr3", "st84hOpr3");
		this.hashFields.put("st8_4h_opr2", "st84hOpr2");
		this.hashFields.put("st8_4h_opr5", "st84hOpr5");
		this.hashFields.put("st8_4h_opr4", "st84hOpr4");
		this.hashFields.put("st15_2h_opr10", "st152hOpr10");
		this.hashFields.put("st8_4h_opr6", "st84hOpr6");
		this.hashFields.put("st8_4h_opr7", "st84hOpr7");
		this.hashFields.put("st8_4h_opr8", "st84hOpr8");
		this.hashFields.put("st8_4h_opr9", "st84hOpr9");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("st1_4h_opr10", "st14hOpr10");
		this.hashFields.put("st6_40_opr8", "st640Opr8");
		this.hashFields.put("st12_45_opr9", "st1245Opr9");
		this.hashFields.put("st12_45_opr8", "st1245Opr8");
		this.hashFields.put("st6_40_opr9", "st640Opr9");
		this.hashFields.put("st12_45_opr7", "st1245Opr7");
		this.hashFields.put("st12_45_opr6", "st1245Opr6");
		this.hashFields.put("st6_40_opr4", "st640Opr4");
		this.hashFields.put("st12_45_opr5", "st1245Opr5");
		this.hashFields.put("st6_40_opr5", "st640Opr5");
		this.hashFields.put("st12_45_opr4", "st1245Opr4");
		this.hashFields.put("st12_45_opr3", "st1245Opr3");
		this.hashFields.put("st6_40_opr6", "st640Opr6");
		this.hashFields.put("st12_45_opr2", "st1245Opr2");
		this.hashFields.put("st6_40_opr7", "st640Opr7");
		this.hashFields.put("st12_45_opr1", "st1245Opr1");
		this.hashFields.put("st6_40_opr1", "st640Opr1");
		this.hashFields.put("st6_40_opr2", "st640Opr2");
		this.hashFields.put("st6_40_opr3", "st640Opr3");
		this.hashFields.put("st5_2h_opr10", "st52hOpr10");
		this.hashFields.put("st13_40_opr2", "st1340Opr2");
		this.hashFields.put("st13_40_opr3", "st1340Opr3");
		this.hashFields.put("st13_40_opr4", "st1340Opr4");
		this.hashFields.put("st13_40_opr5", "st1340Opr5");
		this.hashFields.put("st13_40_opr6", "st1340Opr6");
		this.hashFields.put("st13_40_opr7", "st1340Opr7");
		this.hashFields.put("st13_40_opr8", "st1340Opr8");
		this.hashFields.put("st13_40_opr9", "st1340Opr9");
		this.hashFields.put("st9_45_opr1", "st945Opr1");
		this.hashFields.put("st9_45_opr3", "st945Opr3");
		this.hashFields.put("st9_45_opr2", "st945Opr2");
		this.hashFields.put("st9_45_opr5", "st945Opr5");
		this.hashFields.put("st9_45_opr4", "st945Opr4");
		this.hashFields.put("st9_45_opr7", "st945Opr7");
		this.hashFields.put("st9_45_opr6", "st945Opr6");
		this.hashFields.put("st6_4h_opr10", "st64hOpr10");
		this.hashFields.put("st5_20_opr1", "st520Opr1");
		this.hashFields.put("st5_40_opr2", "st540Opr2");
		this.hashFields.put("st5_40_opr1", "st540Opr1");
		this.hashFields.put("st5_20_opr2", "st520Opr2");
		this.hashFields.put("st5_40_opr4", "st540Opr4");
		this.hashFields.put("st5_40_opr3", "st540Opr3");
		this.hashFields.put("qty10", "qty10");
		this.hashFields.put("st5_20_opr5", "st520Opr5");
		this.hashFields.put("st5_40_opr6", "st540Opr6");
		this.hashFields.put("st5_40_opr5", "st540Opr5");
		this.hashFields.put("st5_20_opr6", "st520Opr6");
		this.hashFields.put("st5_20_opr3", "st520Opr3");
		this.hashFields.put("st5_40_opr8", "st540Opr8");
		this.hashFields.put("st5_20_opr4", "st520Opr4");
		this.hashFields.put("st5_40_opr7", "st540Opr7");
		this.hashFields.put("st5_20_opr9", "st520Opr9");
		this.hashFields.put("st5_40_opr9", "st540Opr9");
		this.hashFields.put("st5_20_opr7", "st520Opr7");
		this.hashFields.put("st5_20_opr8", "st520Opr8");
		this.hashFields.put("st9_45_opr10", "st945Opr10");
		this.hashFields.put("st9_4h_opr10", "st94hOpr10");
		this.hashFields.put("stwg_cgo_flg", "stwgCgoFlg");
		this.hashFields.put("st15_40_opr10", "st1540Opr10");
		this.hashFields.put("st9_45_opr8", "st945Opr8");
		this.hashFields.put("st9_45_opr9", "st945Opr9");
		this.hashFields.put("st3_2h_opr9", "st32hOpr9");
		this.hashFields.put("st2_4h_opr1", "st24hOpr1");
		this.hashFields.put("st9_20_opr9", "st920Opr9");
		this.hashFields.put("st2_4h_opr3", "st24hOpr3");
		this.hashFields.put("st9_20_opr8", "st920Opr8");
		this.hashFields.put("st2_4h_opr2", "st24hOpr2");
		this.hashFields.put("st9_20_opr7", "st920Opr7");
		this.hashFields.put("st9_20_opr6", "st920Opr6");
		this.hashFields.put("st9_20_opr5", "st920Opr5");
		this.hashFields.put("st9_20_opr4", "st920Opr4");
		this.hashFields.put("st9_20_opr3", "st920Opr3");
		this.hashFields.put("st3_2h_opr4", "st32hOpr4");
		this.hashFields.put("st9_20_opr2", "st920Opr2");
		this.hashFields.put("st2_4h_opr9", "st24hOpr9");
		this.hashFields.put("st3_2h_opr3", "st32hOpr3");
		this.hashFields.put("st9_20_opr1", "st920Opr1");
		this.hashFields.put("stwg_cd", "stwgCd");
		this.hashFields.put("st2_4h_opr8", "st24hOpr8");
		this.hashFields.put("st2_40_opr10", "st240Opr10");
		this.hashFields.put("st3_2h_opr2", "st32hOpr2");
		this.hashFields.put("st3_2h_opr1", "st32hOpr1");
		this.hashFields.put("st2_4h_opr5", "st24hOpr5");
		this.hashFields.put("st3_2h_opr8", "st32hOpr8");
		this.hashFields.put("st2_4h_opr4", "st24hOpr4");
		this.hashFields.put("st3_2h_opr7", "st32hOpr7");
		this.hashFields.put("st3_2h_opr6", "st32hOpr6");
		this.hashFields.put("st2_4h_opr7", "st24hOpr7");
		this.hashFields.put("st3_2h_opr5", "st32hOpr5");
		this.hashFields.put("st2_4h_opr6", "st24hOpr6");
		this.hashFields.put("st2_40_opr4", "st240Opr4");
		this.hashFields.put("st8_20_opr1", "st820Opr1");
		this.hashFields.put("st11_2h_opr10", "st112hOpr10");
		this.hashFields.put("st2_40_opr5", "st240Opr5");
		this.hashFields.put("st8_20_opr3", "st820Opr3");
		this.hashFields.put("st2_40_opr6", "st240Opr6");
		this.hashFields.put("st8_20_opr2", "st820Opr2");
		this.hashFields.put("st2_40_opr7", "st240Opr7");
		this.hashFields.put("st2_40_opr8", "st240Opr8");
		this.hashFields.put("st2_40_opr9", "st240Opr9");
		this.hashFields.put("st6_4h_opr7", "st64hOpr7");
		this.hashFields.put("st8_20_opr9", "st820Opr9");
		this.hashFields.put("st6_4h_opr6", "st64hOpr6");
		this.hashFields.put("st8_20_opr8", "st820Opr8");
		this.hashFields.put("st6_4h_opr5", "st64hOpr5");
		this.hashFields.put("st6_4h_opr4", "st64hOpr4");
		this.hashFields.put("st6_4h_opr3", "st64hOpr3");
		this.hashFields.put("st8_20_opr5", "st820Opr5");
		this.hashFields.put("st8_20_opr4", "st820Opr4");
		this.hashFields.put("st6_4h_opr2", "st64hOpr2");
		this.hashFields.put("st6_4h_opr1", "st64hOpr1");
		this.hashFields.put("st8_20_opr7", "st820Opr7");
		this.hashFields.put("st8_20_opr6", "st820Opr6");
		this.hashFields.put("st4_45_opr1", "st445Opr1");
		this.hashFields.put("st4_45_opr2", "st445Opr2");
		this.hashFields.put("st4_45_opr3", "st445Opr3");
		this.hashFields.put("st6_4h_opr8", "st64hOpr8");
		this.hashFields.put("st4_45_opr4", "st445Opr4");
		this.hashFields.put("st6_4h_opr9", "st64hOpr9");
		this.hashFields.put("st4_45_opr5", "st445Opr5");
		this.hashFields.put("st4_45_opr6", "st445Opr6");
		this.hashFields.put("st4_45_opr7", "st445Opr7");
		this.hashFields.put("st4_45_opr8", "st445Opr8");
		this.hashFields.put("st2_40_opr1", "st240Opr1");
		this.hashFields.put("st4_45_opr9", "st445Opr9");
		this.hashFields.put("st2_40_opr3", "st240Opr3");
		this.hashFields.put("st2_40_opr2", "st240Opr2");
		this.hashFields.put("st_9", "st9");
		this.hashFields.put("st_7", "st7");
		this.hashFields.put("st_8", "st8");
		this.hashFields.put("st_5", "st5");
		this.hashFields.put("st_6", "st6");
		this.hashFields.put("st_3", "st3");
		this.hashFields.put("st_4", "st4");
		this.hashFields.put("st_1", "st1");
		this.hashFields.put("st_2", "st2");
		this.hashFields.put("st9_40_opr10", "st940Opr10");
		this.hashFields.put("st12_20_opr10", "st1220Opr10");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("st3_20_opr9", "st320Opr9");
		this.hashFields.put("st3_20_opr8", "st320Opr8");
		this.hashFields.put("st3_20_opr7", "st320Opr7");
		this.hashFields.put("st3_20_opr6", "st320Opr6");
		this.hashFields.put("st3_20_opr5", "st320Opr5");
		this.hashFields.put("st4_2h_opr10", "st42hOpr10");
		this.hashFields.put("st3_20_opr4", "st320Opr4");
		this.hashFields.put("st3_20_opr3", "st320Opr3");
		this.hashFields.put("st3_20_opr2", "st320Opr2");
		this.hashFields.put("st3_20_opr1", "st320Opr1");
		this.hashFields.put("st14_4h_opr9", "st144hOpr9");
		this.hashFields.put("st6_45_opr10", "st645Opr10");
		this.hashFields.put("st2_2h_opr1", "st22hOpr1");
		this.hashFields.put("st2_2h_opr8", "st22hOpr8");
		this.hashFields.put("st2_2h_opr9", "st22hOpr9");
		this.hashFields.put("st2_2h_opr6", "st22hOpr6");
		this.hashFields.put("st2_2h_opr7", "st22hOpr7");
		this.hashFields.put("st12_2h_opr10", "st122hOpr10");
		this.hashFields.put("st10_4h_opr10", "st104hOpr10");
		this.hashFields.put("st2_2h_opr4", "st22hOpr4");
		this.hashFields.put("st2_2h_opr5", "st22hOpr5");
		this.hashFields.put("st2_2h_opr2", "st22hOpr2");
		this.hashFields.put("st2_2h_opr3", "st22hOpr3");
		this.hashFields.put("st4_40_opr10", "st440Opr10");
		this.hashFields.put("st4_4h_opr6", "st44hOpr6");
		this.hashFields.put("st4_4h_opr7", "st44hOpr7");
		this.hashFields.put("st4_4h_opr8", "st44hOpr8");
		this.hashFields.put("st4_4h_opr9", "st44hOpr9");
		this.hashFields.put("st4_4h_opr2", "st44hOpr2");
		this.hashFields.put("st4_4h_opr3", "st44hOpr3");
		this.hashFields.put("st4_4h_opr4", "st44hOpr4");
		this.hashFields.put("st4_4h_opr5", "st44hOpr5");
		this.hashFields.put("st4_4h_opr1", "st44hOpr1");
		this.hashFields.put("bkg_shpr_ownr_flg", "bkgShprOwnrFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("st14_4h_opr1", "st144hOpr1");
		this.hashFields.put("st14_4h_opr2", "st144hOpr2");
		this.hashFields.put("st14_4h_opr3", "st144hOpr3");
		this.hashFields.put("st7_4h_opr10", "st74hOpr10");
		this.hashFields.put("st14_4h_opr4", "st144hOpr4");
		this.hashFields.put("st14_4h_opr5", "st144hOpr5");
		this.hashFields.put("st14_4h_opr6", "st144hOpr6");
		this.hashFields.put("st14_4h_opr7", "st144hOpr7");
		this.hashFields.put("st14_4h_opr8", "st144hOpr8");
		this.hashFields.put("st7_2h_opr10", "st72hOpr10");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("st4_20_opr9", "st420Opr9");
		this.hashFields.put("st4_20_opr8", "st420Opr8");
		this.hashFields.put("st4_20_opr5", "st420Opr5");
		this.hashFields.put("st4_20_opr4", "st420Opr4");
		this.hashFields.put("st4_20_opr7", "st420Opr7");
		this.hashFields.put("st4_20_opr6", "st420Opr6");
		this.hashFields.put("st4_20_opr1", "st420Opr1");
		this.hashFields.put("st4_20_opr3", "st420Opr3");
		this.hashFields.put("st4_20_opr2", "st420Opr2");
		this.hashFields.put("st8_40_opr9", "st840Opr9");
		this.hashFields.put("st8_40_opr8", "st840Opr8");
		this.hashFields.put("st8_40_opr7", "st840Opr7");
		this.hashFields.put("st8_40_opr6", "st840Opr6");
		this.hashFields.put("st2_2h_opr10", "st22hOpr10");
		this.hashFields.put("st8_40_opr1", "st840Opr1");
		this.hashFields.put("st4_40_opr9", "st440Opr9");
		this.hashFields.put("st4_40_opr8", "st440Opr8");
		this.hashFields.put("st4_40_opr7", "st440Opr7");
		this.hashFields.put("st4_40_opr6", "st440Opr6");
		this.hashFields.put("st4_40_opr5", "st440Opr5");
		this.hashFields.put("st8_40_opr5", "st840Opr5");
		this.hashFields.put("st8_40_opr4", "st840Opr4");
		this.hashFields.put("st4_40_opr4", "st440Opr4");
		this.hashFields.put("st8_40_opr3", "st840Opr3");
		this.hashFields.put("st4_40_opr3", "st440Opr3");
		this.hashFields.put("st4_40_opr2", "st440Opr2");
		this.hashFields.put("st8_40_opr2", "st840Opr2");
		this.hashFields.put("st4_40_opr1", "st440Opr1");
		this.hashFields.put("st8_20_opr10", "st820Opr10");
		this.hashFields.put("st11_20_opr10", "st1120Opr10");
		this.hashFields.put("st6_20_opr9", "st620Opr9");
		this.hashFields.put("st6_20_opr8", "st620Opr8");
		this.hashFields.put("st6_20_opr7", "st620Opr7");
		this.hashFields.put("st6_20_opr6", "st620Opr6");
		this.hashFields.put("st6_20_opr1", "st620Opr1");
		this.hashFields.put("st6_20_opr5", "st620Opr5");
		this.hashFields.put("st6_20_opr4", "st620Opr4");
		this.hashFields.put("st6_20_opr3", "st620Opr3");
		this.hashFields.put("st6_20_opr2", "st620Opr2");
		this.hashFields.put("st12_40_opr9", "st1240Opr9");
		this.hashFields.put("st6_2h_opr1", "st62hOpr1");
		this.hashFields.put("st12_40_opr8", "st1240Opr8");
		this.hashFields.put("st12_40_opr7", "st1240Opr7");
		this.hashFields.put("st6_2h_opr3", "st62hOpr3");
		this.hashFields.put("st12_40_opr6", "st1240Opr6");
		this.hashFields.put("st6_2h_opr2", "st62hOpr2");
		this.hashFields.put("st12_40_opr5", "st1240Opr5");
		this.hashFields.put("st6_2h_opr5", "st62hOpr5");
		this.hashFields.put("st12_40_opr4", "st1240Opr4");
		this.hashFields.put("st6_2h_opr4", "st62hOpr4");
		this.hashFields.put("st12_40_opr3", "st1240Opr3");
		this.hashFields.put("st6_2h_opr6", "st62hOpr6");
		this.hashFields.put("st6_2h_opr7", "st62hOpr7");
		this.hashFields.put("st6_2h_opr8", "st62hOpr8");
		this.hashFields.put("st6_2h_opr9", "st62hOpr9");
		this.hashFields.put("st13_4h_opr10", "st134hOpr10");
		this.hashFields.put("st6_20_opr10", "st620Opr10");
		this.hashFields.put("st8_4h_opr10", "st84hOpr10");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("st1_45_opr9", "st145Opr9");
		this.hashFields.put("st12_45_opr10", "st1245Opr10");
		this.hashFields.put("st1_45_opr8", "st145Opr8");
		this.hashFields.put("st15_4h_opr9", "st154hOpr9");
		this.hashFields.put("st15_4h_opr8", "st154hOpr8");
		this.hashFields.put("st13_45_opr10", "st1345Opr10");
		this.hashFields.put("st1_45_opr3", "st145Opr3");
		this.hashFields.put("st1_45_opr2", "st145Opr2");
		this.hashFields.put("st1_45_opr1", "st145Opr1");
		this.hashFields.put("st1_45_opr7", "st145Opr7");
		this.hashFields.put("st1_45_opr6", "st145Opr6");
		this.hashFields.put("st1_45_opr5", "st145Opr5");
		this.hashFields.put("st4_4h_opr10", "st44hOpr10");
		this.hashFields.put("st1_45_opr4", "st145Opr4");
		this.hashFields.put("st5_4h_opr4", "st54hOpr4");
		this.hashFields.put("opr7", "opr7");
		this.hashFields.put("st5_4h_opr3", "st54hOpr3");
		this.hashFields.put("opr8", "opr8");
		this.hashFields.put("opr5", "opr5");
		this.hashFields.put("st5_4h_opr2", "st54hOpr2");
		this.hashFields.put("st5_4h_opr1", "st54hOpr1");
		this.hashFields.put("opr6", "opr6");
		this.hashFields.put("opr3", "opr3");
		this.hashFields.put("st5_4h_opr8", "st54hOpr8");
		this.hashFields.put("opr4", "opr4");
		this.hashFields.put("st5_4h_opr7", "st54hOpr7");
		this.hashFields.put("opr1", "opr1");
		this.hashFields.put("st5_4h_opr6", "st54hOpr6");
		this.hashFields.put("st5_4h_opr5", "st54hOpr5");
		this.hashFields.put("opr2", "opr2");
		this.hashFields.put("opr9", "opr9");
		this.hashFields.put("st5_4h_opr9", "st54hOpr9");
		this.hashFields.put("st2_20_opr6", "st220Opr6");
		this.hashFields.put("st2_20_opr7", "st220Opr7");
		this.hashFields.put("st2_20_opr8", "st220Opr8");
		this.hashFields.put("st2_20_opr9", "st220Opr9");
		this.hashFields.put("st2_20_opr2", "st220Opr2");
		this.hashFields.put("st2_20_opr3", "st220Opr3");
		this.hashFields.put("st2_20_opr4", "st220Opr4");
		this.hashFields.put("st2_20_opr5", "st220Opr5");
		this.hashFields.put("st10_20_opr2", "st1020Opr2");
		this.hashFields.put("st10_20_opr1", "st1020Opr1");
		this.hashFields.put("st2_20_opr1", "st220Opr1");
		this.hashFields.put("st_15", "st15");
		this.hashFields.put("st_14", "st14");
		this.hashFields.put("st_13", "st13");
		this.hashFields.put("st_12", "st12");
		this.hashFields.put("st_11", "st11");
		this.hashFields.put("st_10", "st10");
		this.hashFields.put("st13_4h_opr1", "st134hOpr1");
		this.hashFields.put("st13_4h_opr2", "st134hOpr2");
		this.hashFields.put("st7_2h_opr5", "st72hOpr5");
		this.hashFields.put("st13_4h_opr3", "st134hOpr3");
		this.hashFields.put("st7_2h_opr6", "st72hOpr6");
		this.hashFields.put("st13_4h_opr4", "st134hOpr4");
		this.hashFields.put("st7_2h_opr7", "st72hOpr7");
		this.hashFields.put("st13_4h_opr5", "st134hOpr5");
		this.hashFields.put("st7_2h_opr8", "st72hOpr8");
		this.hashFields.put("st13_4h_opr6", "st134hOpr6");
		this.hashFields.put("st7_2h_opr9", "st72hOpr9");
		this.hashFields.put("st13_4h_opr7", "st134hOpr7");
		this.hashFields.put("st13_4h_opr8", "st134hOpr8");
		this.hashFields.put("st13_4h_opr9", "st134hOpr9");
		this.hashFields.put("st15_4h_opr1", "st154hOpr1");
		this.hashFields.put("st15_4h_opr3", "st154hOpr3");
		this.hashFields.put("st15_4h_opr2", "st154hOpr2");
		this.hashFields.put("st14_40_opr9", "st1440Opr9");
		this.hashFields.put("st10_40_opr4", "st1040Opr4");
		this.hashFields.put("st7_2h_opr2", "st72hOpr2");
		this.hashFields.put("st15_4h_opr5", "st154hOpr5");
		this.hashFields.put("st15_4h_opr4", "st154hOpr4");
		this.hashFields.put("st10_40_opr3", "st1040Opr3");
		this.hashFields.put("st7_2h_opr1", "st72hOpr1");
		this.hashFields.put("st7_2h_opr4", "st72hOpr4");
		this.hashFields.put("st10_40_opr2", "st1040Opr2");
		this.hashFields.put("st15_4h_opr7", "st154hOpr7");
		this.hashFields.put("st7_2h_opr3", "st72hOpr3");
		this.hashFields.put("st10_40_opr1", "st1040Opr1");
		this.hashFields.put("st15_4h_opr6", "st154hOpr6");
		this.hashFields.put("st14_40_opr4", "st1440Opr4");
		this.hashFields.put("st14_40_opr3", "st1440Opr3");
		this.hashFields.put("st14_40_opr2", "st1440Opr2");
		this.hashFields.put("st14_40_opr1", "st1440Opr1");
		this.hashFields.put("st14_40_opr8", "st1440Opr8");
		this.hashFields.put("st14_40_opr7", "st1440Opr7");
		this.hashFields.put("st14_40_opr6", "st1440Opr6");
		this.hashFields.put("st14_40_opr5", "st1440Opr5");
		this.hashFields.put("st10_2h_opr1", "st102hOpr1");
		this.hashFields.put("st10_2h_opr2", "st102hOpr2");
		this.hashFields.put("st10_2h_opr7", "st102hOpr7");
		this.hashFields.put("st10_2h_opr8", "st102hOpr8");
		this.hashFields.put("st10_2h_opr9", "st102hOpr9");
		this.hashFields.put("st10_2h_opr3", "st102hOpr3");
		this.hashFields.put("st10_2h_opr4", "st102hOpr4");
		this.hashFields.put("st10_2h_opr5", "st102hOpr5");
		this.hashFields.put("st10_2h_opr6", "st102hOpr6");
		this.hashFields.put("st3_20_opr10", "st320Opr10");
		this.hashFields.put("st10_20_opr3", "st1020Opr3");
		this.hashFields.put("st10_20_opr4", "st1020Opr4");
		this.hashFields.put("st10_20_opr5", "st1020Opr5");
		this.hashFields.put("st10_20_opr6", "st1020Opr6");
		this.hashFields.put("st12_40_opr2", "st1240Opr2");
		this.hashFields.put("st10_20_opr7", "st1020Opr7");
		this.hashFields.put("st12_40_opr1", "st1240Opr1");
		this.hashFields.put("st10_20_opr8", "st1020Opr8");
		this.hashFields.put("st10_20_opr9", "st1020Opr9");
		this.hashFields.put("st12_40_opr10", "st1240Opr10");
		this.hashFields.put("st1_4h_opr9", "st14hOpr9");
		this.hashFields.put("st11_40_opr10", "st1140Opr10");
		this.hashFields.put("st1_4h_opr5", "st14hOpr5");
		this.hashFields.put("st1_4h_opr6", "st14hOpr6");
		this.hashFields.put("st1_4h_opr7", "st14hOpr7");
		this.hashFields.put("st1_4h_opr8", "st14hOpr8");
		this.hashFields.put("st1_4h_opr1", "st14hOpr1");
		this.hashFields.put("st1_4h_opr2", "st14hOpr2");
		this.hashFields.put("st1_4h_opr3", "st14hOpr3");
		this.hashFields.put("st1_4h_opr4", "st14hOpr4");
		this.hashFields.put("st8_40_opr10", "st840Opr10");
		this.hashFields.put("mlb", "mlb");
		this.hashFields.put("st10_2h_opr10", "st102hOpr10");
		this.hashFields.put("awk_cgo_flg", "awkCgoFlg");
		this.hashFields.put("st4_2h_opr1", "st42hOpr1");
		this.hashFields.put("st10_40_opr9", "st1040Opr9");
		this.hashFields.put("st4_2h_opr3", "st42hOpr3");
		this.hashFields.put("st4_2h_opr2", "st42hOpr2");
		this.hashFields.put("st4_2h_opr5", "st42hOpr5");
		this.hashFields.put("st10_40_opr6", "st1040Opr6");
		this.hashFields.put("st2_20_opr10", "st220Opr10");
		this.hashFields.put("st4_2h_opr4", "st42hOpr4");
		this.hashFields.put("st10_40_opr5", "st1040Opr5");
		this.hashFields.put("st4_2h_opr7", "st42hOpr7");
		this.hashFields.put("st10_40_opr8", "st1040Opr8");
		this.hashFields.put("st4_2h_opr6", "st42hOpr6");
		this.hashFields.put("st10_40_opr7", "st1040Opr7");
		this.hashFields.put("st7_45_opr3", "st745Opr3");
		this.hashFields.put("st7_45_opr2", "st745Opr2");
		this.hashFields.put("st7_45_opr5", "st745Opr5");
		this.hashFields.put("st7_45_opr4", "st745Opr4");
		this.hashFields.put("st7_45_opr7", "st745Opr7");
		this.hashFields.put("st7_45_opr6", "st745Opr6");
		this.hashFields.put("st7_45_opr9", "st745Opr9");
		this.hashFields.put("st7_45_opr8", "st745Opr8");
		this.hashFields.put("st4_2h_opr8", "st42hOpr8");
		this.hashFields.put("st4_2h_opr9", "st42hOpr9");
		this.hashFields.put("st7_45_opr1", "st745Opr1");
		this.hashFields.put("st11_4h_opr10", "st114hOpr10");
		this.hashFields.put("st1_40_opr6", "st140Opr6");
		this.hashFields.put("st1_40_opr5", "st140Opr5");
		this.hashFields.put("st1_40_opr8", "st140Opr8");
		this.hashFields.put("st1_40_opr7", "st140Opr7");
		this.hashFields.put("st1_40_opr9", "st140Opr9");
		this.hashFields.put("st14_2h_opr10", "st142hOpr10");
		this.hashFields.put("st1_40_opr1", "st140Opr1");
		this.hashFields.put("st1_40_opr2", "st140Opr2");
		this.hashFields.put("st1_40_opr3", "st140Opr3");
		this.hashFields.put("st5_4h_opr10", "st54hOpr10");
		this.hashFields.put("st1_40_opr4", "st140Opr4");
		this.hashFields.put("pod_yd_cd","podYdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return st720Opr10
	 */
	public String getSt720Opr10() {
		return this.st720Opr10;
	}
	
	/**
	 * Column Info
	 * @return st740Opr7
	 */
	public String getSt740Opr7() {
		return this.st740Opr7;
	}
	
	/**
	 * Column Info
	 * @return st1445Opr10
	 */
	public String getSt1445Opr10() {
		return this.st1445Opr10;
	}
	
	/**
	 * Column Info
	 * @return st740Opr8
	 */
	public String getSt740Opr8() {
		return this.st740Opr8;
	}
	
	/**
	 * Column Info
	 * @return st740Opr9
	 */
	public String getSt740Opr9() {
		return this.st740Opr9;
	}
	
	/**
	 * Column Info
	 * @return st140Opr10
	 */
	public String getSt140Opr10() {
		return this.st140Opr10;
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
	 * @return st740Opr1
	 */
	public String getSt740Opr1() {
		return this.st740Opr1;
	}
	
	/**
	 * Column Info
	 * @return st740Opr2
	 */
	public String getSt740Opr2() {
		return this.st740Opr2;
	}
	
	/**
	 * Column Info
	 * @return st740Opr3
	 */
	public String getSt740Opr3() {
		return this.st740Opr3;
	}
	
	/**
	 * Column Info
	 * @return st740Opr4
	 */
	public String getSt740Opr4() {
		return this.st740Opr4;
	}
	
	/**
	 * Column Info
	 * @return st740Opr5
	 */
	public String getSt740Opr5() {
		return this.st740Opr5;
	}
	
	/**
	 * Column Info
	 * @return st740Opr6
	 */
	public String getSt740Opr6() {
		return this.st740Opr6;
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
	 * @return st145Opr10
	 */
	public String getSt145Opr10() {
		return this.st145Opr10;
	}
	
	/**
	 * Column Info
	 * @return st1545Opr10
	 */
	public String getSt1545Opr10() {
		return this.st1545Opr10;
	}
	
	/**
	 * Column Info
	 * @return st640Opr10
	 */
	public String getSt640Opr10() {
		return this.st640Opr10;
	}
	
	/**
	 * Column Info
	 * @return st1340Opr10
	 */
	public String getSt1340Opr10() {
		return this.st1340Opr10;
	}
	
	/**
	 * Column Info
	 * @return st520Opr10
	 */
	public String getSt520Opr10() {
		return this.st520Opr10;
	}
	
	/**
	 * Column Info
	 * @return st154hOpr10
	 */
	public String getSt154hOpr10() {
		return this.st154hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st82hOpr10
	 */
	public String getSt82hOpr10() {
		return this.st82hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st845Opr10
	 */
	public String getSt845Opr10() {
		return this.st845Opr10;
	}
	
	/**
	 * Column Info
	 * @return st645Opr3
	 */
	public String getSt645Opr3() {
		return this.st645Opr3;
	}
	
	/**
	 * Column Info
	 * @return st645Opr4
	 */
	public String getSt645Opr4() {
		return this.st645Opr4;
	}
	
	/**
	 * Column Info
	 * @return st645Opr5
	 */
	public String getSt645Opr5() {
		return this.st645Opr5;
	}
	
	/**
	 * Column Info
	 * @return st545Opr8
	 */
	public String getSt545Opr8() {
		return this.st545Opr8;
	}
	
	/**
	 * Column Info
	 * @return st645Opr6
	 */
	public String getSt645Opr6() {
		return this.st645Opr6;
	}
	
	/**
	 * Column Info
	 * @return st545Opr9
	 */
	public String getSt545Opr9() {
		return this.st545Opr9;
	}
	
	/**
	 * Column Info
	 * @return st545Opr6
	 */
	public String getSt545Opr6() {
		return this.st545Opr6;
	}
	
	/**
	 * Column Info
	 * @return st645Opr7
	 */
	public String getSt645Opr7() {
		return this.st645Opr7;
	}
	
	/**
	 * Column Info
	 * @return st545Opr7
	 */
	public String getSt545Opr7() {
		return this.st545Opr7;
	}
	
	/**
	 * Column Info
	 * @return st645Opr8
	 */
	public String getSt645Opr8() {
		return this.st645Opr8;
	}
	
	/**
	 * Column Info
	 * @return st545Opr4
	 */
	public String getSt545Opr4() {
		return this.st545Opr4;
	}
	
	/**
	 * Column Info
	 * @return st645Opr9
	 */
	public String getSt645Opr9() {
		return this.st645Opr9;
	}
	
	/**
	 * Column Info
	 * @return st545Opr5
	 */
	public String getSt545Opr5() {
		return this.st545Opr5;
	}
	
	/**
	 * Column Info
	 * @return st545Opr2
	 */
	public String getSt545Opr2() {
		return this.st545Opr2;
	}
	
	/**
	 * Column Info
	 * @return st545Opr3
	 */
	public String getSt545Opr3() {
		return this.st545Opr3;
	}
	
	/**
	 * Column Info
	 * @return st1145Opr10
	 */
	public String getSt1145Opr10() {
		return this.st1145Opr10;
	}
	
	/**
	 * Column Info
	 * @return st545Opr1
	 */
	public String getSt545Opr1() {
		return this.st545Opr1;
	}
	
	/**
	 * Column Info
	 * @return st645Opr1
	 */
	public String getSt645Opr1() {
		return this.st645Opr1;
	}
	
	/**
	 * Column Info
	 * @return st645Opr2
	 */
	public String getSt645Opr2() {
		return this.st645Opr2;
	}
	
	/**
	 * Column Info
	 * @return st114hOpr8
	 */
	public String getSt114hOpr8() {
		return this.st114hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st114hOpr9
	 */
	public String getSt114hOpr9() {
		return this.st114hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st114hOpr4
	 */
	public String getSt114hOpr4() {
		return this.st114hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st114hOpr5
	 */
	public String getSt114hOpr5() {
		return this.st114hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st114hOpr6
	 */
	public String getSt114hOpr6() {
		return this.st114hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st114hOpr7
	 */
	public String getSt114hOpr7() {
		return this.st114hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st114hOpr1
	 */
	public String getSt114hOpr1() {
		return this.st114hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st114hOpr2
	 */
	public String getSt114hOpr2() {
		return this.st114hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st114hOpr3
	 */
	public String getSt114hOpr3() {
		return this.st114hOpr3;
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
	 * @return st745Opr10
	 */
	public String getSt745Opr10() {
		return this.st745Opr10;
	}
	
	/**
	 * Column Info
	 * @return st1320Opr10
	 */
	public String getSt1320Opr10() {
		return this.st1320Opr10;
	}
	
	/**
	 * Column Info
	 * @return st122hOpr1
	 */
	public String getSt122hOpr1() {
		return this.st122hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st122hOpr2
	 */
	public String getSt122hOpr2() {
		return this.st122hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st122hOpr3
	 */
	public String getSt122hOpr3() {
		return this.st122hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st122hOpr4
	 */
	public String getSt122hOpr4() {
		return this.st122hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st122hOpr5
	 */
	public String getSt122hOpr5() {
		return this.st122hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st122hOpr6
	 */
	public String getSt122hOpr6() {
		return this.st122hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st122hOpr7
	 */
	public String getSt122hOpr7() {
		return this.st122hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st122hOpr8
	 */
	public String getSt122hOpr8() {
		return this.st122hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st845Opr5
	 */
	public String getSt845Opr5() {
		return this.st845Opr5;
	}
	
	/**
	 * Column Info
	 * @return st104hOpr6
	 */
	public String getSt104hOpr6() {
		return this.st104hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st1445Opr9
	 */
	public String getSt1445Opr9() {
		return this.st1445Opr9;
	}
	
	/**
	 * Column Info
	 * @return st104hOpr5
	 */
	public String getSt104hOpr5() {
		return this.st104hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st845Opr6
	 */
	public String getSt845Opr6() {
		return this.st845Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1445Opr8
	 */
	public String getSt1445Opr8() {
		return this.st1445Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1145Opr1
	 */
	public String getSt1145Opr1() {
		return this.st1145Opr1;
	}
	
	/**
	 * Column Info
	 * @return st845Opr7
	 */
	public String getSt845Opr7() {
		return this.st845Opr7;
	}
	
	/**
	 * Column Info
	 * @return st104hOpr8
	 */
	public String getSt104hOpr8() {
		return this.st104hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st1145Opr2
	 */
	public String getSt1145Opr2() {
		return this.st1145Opr2;
	}
	
	/**
	 * Column Info
	 * @return st104hOpr7
	 */
	public String getSt104hOpr7() {
		return this.st104hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st845Opr8
	 */
	public String getSt845Opr8() {
		return this.st845Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1145Opr3
	 */
	public String getSt1145Opr3() {
		return this.st1145Opr3;
	}
	
	/**
	 * Column Info
	 * @return st845Opr1
	 */
	public String getSt845Opr1() {
		return this.st845Opr1;
	}
	
	/**
	 * Column Info
	 * @return st1445Opr5
	 */
	public String getSt1445Opr5() {
		return this.st1445Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1445Opr4
	 */
	public String getSt1445Opr4() {
		return this.st1445Opr4;
	}
	
	/**
	 * Column Info
	 * @return st1145Opr4
	 */
	public String getSt1145Opr4() {
		return this.st1145Opr4;
	}
	
	/**
	 * Column Info
	 * @return st845Opr2
	 */
	public String getSt845Opr2() {
		return this.st845Opr2;
	}
	
	/**
	 * Column Info
	 * @return st104hOpr9
	 */
	public String getSt104hOpr9() {
		return this.st104hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st845Opr3
	 */
	public String getSt845Opr3() {
		return this.st845Opr3;
	}
	
	/**
	 * Column Info
	 * @return st1145Opr5
	 */
	public String getSt1145Opr5() {
		return this.st1145Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1445Opr7
	 */
	public String getSt1445Opr7() {
		return this.st1445Opr7;
	}
	
	/**
	 * Column Info
	 * @return st845Opr4
	 */
	public String getSt845Opr4() {
		return this.st845Opr4;
	}
	
	/**
	 * Column Info
	 * @return st1145Opr6
	 */
	public String getSt1145Opr6() {
		return this.st1145Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1445Opr6
	 */
	public String getSt1445Opr6() {
		return this.st1445Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1445Opr1
	 */
	public String getSt1445Opr1() {
		return this.st1445Opr1;
	}
	
	/**
	 * Column Info
	 * @return st1145Opr7
	 */
	public String getSt1145Opr7() {
		return this.st1145Opr7;
	}
	
	/**
	 * Column Info
	 * @return st1145Opr8
	 */
	public String getSt1145Opr8() {
		return this.st1145Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1445Opr3
	 */
	public String getSt1445Opr3() {
		return this.st1445Opr3;
	}
	
	/**
	 * Column Info
	 * @return st1145Opr9
	 */
	public String getSt1145Opr9() {
		return this.st1145Opr9;
	}
	
	/**
	 * Column Info
	 * @return st1445Opr2
	 */
	public String getSt1445Opr2() {
		return this.st1445Opr2;
	}
	
	/**
	 * Column Info
	 * @return st104hOpr2
	 */
	public String getSt104hOpr2() {
		return this.st104hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st104hOpr1
	 */
	public String getSt104hOpr1() {
		return this.st104hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st104hOpr4
	 */
	public String getSt104hOpr4() {
		return this.st104hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st104hOpr3
	 */
	public String getSt104hOpr3() {
		return this.st104hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st845Opr9
	 */
	public String getSt845Opr9() {
		return this.st845Opr9;
	}
	
	/**
	 * Column Info
	 * @return st34hOpr2
	 */
	public String getSt34hOpr2() {
		return this.st34hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st34hOpr1
	 */
	public String getSt34hOpr1() {
		return this.st34hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st34hOpr4
	 */
	public String getSt34hOpr4() {
		return this.st34hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st34hOpr3
	 */
	public String getSt34hOpr3() {
		return this.st34hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st34hOpr6
	 */
	public String getSt34hOpr6() {
		return this.st34hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st34hOpr5
	 */
	public String getSt34hOpr5() {
		return this.st34hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st34hOpr8
	 */
	public String getSt34hOpr8() {
		return this.st34hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st34hOpr7
	 */
	public String getSt34hOpr7() {
		return this.st34hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st34hOpr9
	 */
	public String getSt34hOpr9() {
		return this.st34hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st1345Opr3
	 */
	public String getSt1345Opr3() {
		return this.st1345Opr3;
	}
	
	/**
	 * Column Info
	 * @return st1345Opr4
	 */
	public String getSt1345Opr4() {
		return this.st1345Opr4;
	}
	
	/**
	 * Column Info
	 * @return st1345Opr1
	 */
	public String getSt1345Opr1() {
		return this.st1345Opr1;
	}
	
	/**
	 * Column Info
	 * @return st1345Opr2
	 */
	public String getSt1345Opr2() {
		return this.st1345Opr2;
	}
	
	/**
	 * Column Info
	 * @return st1345Opr9
	 */
	public String getSt1345Opr9() {
		return this.st1345Opr9;
	}
	
	/**
	 * Column Info
	 * @return st1345Opr7
	 */
	public String getSt1345Opr7() {
		return this.st1345Opr7;
	}
	
	/**
	 * Column Info
	 * @return st1345Opr8
	 */
	public String getSt1345Opr8() {
		return this.st1345Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1345Opr5
	 */
	public String getSt1345Opr5() {
		return this.st1345Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1345Opr6
	 */
	public String getSt1345Opr6() {
		return this.st1345Opr6;
	}
	
	/**
	 * Column Info
	 * @return st12hOpr10
	 */
	public String getSt12hOpr10() {
		return this.st12hOpr10;
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
	 * @return st545Opr10
	 */
	public String getSt545Opr10() {
		return this.st545Opr10;
	}
	
	/**
	 * Column Info
	 * @return st152hOpr8
	 */
	public String getSt152hOpr8() {
		return this.st152hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st152hOpr9
	 */
	public String getSt152hOpr9() {
		return this.st152hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st152hOpr6
	 */
	public String getSt152hOpr6() {
		return this.st152hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st152hOpr7
	 */
	public String getSt152hOpr7() {
		return this.st152hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st1140Opr1
	 */
	public String getSt1140Opr1() {
		return this.st1140Opr1;
	}
	
	/**
	 * Column Info
	 * @return st1140Opr2
	 */
	public String getSt1140Opr2() {
		return this.st1140Opr2;
	}
	
	/**
	 * Column Info
	 * @return st1140Opr3
	 */
	public String getSt1140Opr3() {
		return this.st1140Opr3;
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
	 * @return st1420Opr10
	 */
	public String getSt1420Opr10() {
		return this.st1420Opr10;
	}
	
	/**
	 * Column Info
	 * @return st142hOpr8
	 */
	public String getSt142hOpr8() {
		return this.st142hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st142hOpr7
	 */
	public String getSt142hOpr7() {
		return this.st142hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st142hOpr9
	 */
	public String getSt142hOpr9() {
		return this.st142hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st74hOpr9
	 */
	public String getSt74hOpr9() {
		return this.st74hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st74hOpr7
	 */
	public String getSt74hOpr7() {
		return this.st74hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st74hOpr8
	 */
	public String getSt74hOpr8() {
		return this.st74hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st74hOpr6
	 */
	public String getSt74hOpr6() {
		return this.st74hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st1220Opr9
	 */
	public String getSt1220Opr9() {
		return this.st1220Opr9;
	}
	
	/**
	 * Column Info
	 * @return st74hOpr5
	 */
	public String getSt74hOpr5() {
		return this.st74hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st74hOpr4
	 */
	public String getSt74hOpr4() {
		return this.st74hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st74hOpr3
	 */
	public String getSt74hOpr3() {
		return this.st74hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st74hOpr2
	 */
	public String getSt74hOpr2() {
		return this.st74hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st74hOpr1
	 */
	public String getSt74hOpr1() {
		return this.st74hOpr1;
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
	 * @return st1220Opr1
	 */
	public String getSt1220Opr1() {
		return this.st1220Opr1;
	}
	
	/**
	 * Column Info
	 * @return st1220Opr2
	 */
	public String getSt1220Opr2() {
		return this.st1220Opr2;
	}
	
	/**
	 * Column Info
	 * @return st1220Opr3
	 */
	public String getSt1220Opr3() {
		return this.st1220Opr3;
	}
	
	/**
	 * Column Info
	 * @return st1220Opr4
	 */
	public String getSt1220Opr4() {
		return this.st1220Opr4;
	}
	
	/**
	 * Column Info
	 * @return st1220Opr5
	 */
	public String getSt1220Opr5() {
		return this.st1220Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1220Opr6
	 */
	public String getSt1220Opr6() {
		return this.st1220Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1220Opr7
	 */
	public String getSt1220Opr7() {
		return this.st1220Opr7;
	}
	
	/**
	 * Column Info
	 * @return st124hOpr10
	 */
	public String getSt124hOpr10() {
		return this.st124hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st1220Opr8
	 */
	public String getSt1220Opr8() {
		return this.st1220Opr8;
	}
	
	/**
	 * Column Info
	 * @return st82hOpr7
	 */
	public String getSt82hOpr7() {
		return this.st82hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st82hOpr6
	 */
	public String getSt82hOpr6() {
		return this.st82hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st82hOpr5
	 */
	public String getSt82hOpr5() {
		return this.st82hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st82hOpr4
	 */
	public String getSt82hOpr4() {
		return this.st82hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st82hOpr9
	 */
	public String getSt82hOpr9() {
		return this.st82hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st82hOpr8
	 */
	public String getSt82hOpr8() {
		return this.st82hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st82hOpr2
	 */
	public String getSt82hOpr2() {
		return this.st82hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st82hOpr3
	 */
	public String getSt82hOpr3() {
		return this.st82hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st82hOpr1
	 */
	public String getSt82hOpr1() {
		return this.st82hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st92hOpr3
	 */
	public String getSt92hOpr3() {
		return this.st92hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st92hOpr4
	 */
	public String getSt92hOpr4() {
		return this.st92hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st92hOpr5
	 */
	public String getSt92hOpr5() {
		return this.st92hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st92hOpr6
	 */
	public String getSt92hOpr6() {
		return this.st92hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st92hOpr7
	 */
	public String getSt92hOpr7() {
		return this.st92hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st92hOpr8
	 */
	public String getSt92hOpr8() {
		return this.st92hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st92hOpr9
	 */
	public String getSt92hOpr9() {
		return this.st92hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st1020Opr10
	 */
	public String getSt1020Opr10() {
		return this.st1020Opr10;
	}
	
	/**
	 * Column Info
	 * @return st1140Opr9
	 */
	public String getSt1140Opr9() {
		return this.st1140Opr9;
	}
	
	/**
	 * Column Info
	 * @return st1140Opr8
	 */
	public String getSt1140Opr8() {
		return this.st1140Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1140Opr7
	 */
	public String getSt1140Opr7() {
		return this.st1140Opr7;
	}
	
	/**
	 * Column Info
	 * @return st1140Opr6
	 */
	public String getSt1140Opr6() {
		return this.st1140Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1140Opr5
	 */
	public String getSt1140Opr5() {
		return this.st1140Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1140Opr4
	 */
	public String getSt1140Opr4() {
		return this.st1140Opr4;
	}
	
	/**
	 * Column Info
	 * @return st245Opr3
	 */
	public String getSt245Opr3() {
		return this.st245Opr3;
	}
	
	/**
	 * Column Info
	 * @return st245Opr4
	 */
	public String getSt245Opr4() {
		return this.st245Opr4;
	}
	
	/**
	 * Column Info
	 * @return st740Opr10
	 */
	public String getSt740Opr10() {
		return this.st740Opr10;
	}
	
	/**
	 * Column Info
	 * @return st245Opr5
	 */
	public String getSt245Opr5() {
		return this.st245Opr5;
	}
	
	/**
	 * Column Info
	 * @return st152hOpr1
	 */
	public String getSt152hOpr1() {
		return this.st152hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st245Opr6
	 */
	public String getSt245Opr6() {
		return this.st245Opr6;
	}
	
	/**
	 * Column Info
	 * @return st152hOpr3
	 */
	public String getSt152hOpr3() {
		return this.st152hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st152hOpr2
	 */
	public String getSt152hOpr2() {
		return this.st152hOpr2;
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
	 * @return st245Opr1
	 */
	public String getSt245Opr1() {
		return this.st245Opr1;
	}
	
	/**
	 * Column Info
	 * @return st152hOpr5
	 */
	public String getSt152hOpr5() {
		return this.st152hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st152hOpr4
	 */
	public String getSt152hOpr4() {
		return this.st152hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st245Opr2
	 */
	public String getSt245Opr2() {
		return this.st245Opr2;
	}
	
	/**
	 * Column Info
	 * @return st245Opr7
	 */
	public String getSt245Opr7() {
		return this.st245Opr7;
	}
	
	/**
	 * Column Info
	 * @return st920Opr10
	 */
	public String getSt920Opr10() {
		return this.st920Opr10;
	}
	
	/**
	 * Column Info
	 * @return st245Opr8
	 */
	public String getSt245Opr8() {
		return this.st245Opr8;
	}
	
	/**
	 * Column Info
	 * @return st92hOpr2
	 */
	public String getSt92hOpr2() {
		return this.st92hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st245Opr9
	 */
	public String getSt245Opr9() {
		return this.st245Opr9;
	}
	
	/**
	 * Column Info
	 * @return st92hOpr1
	 */
	public String getSt92hOpr1() {
		return this.st92hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st52hOpr2
	 */
	public String getSt52hOpr2() {
		return this.st52hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st52hOpr1
	 */
	public String getSt52hOpr1() {
		return this.st52hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st52hOpr6
	 */
	public String getSt52hOpr6() {
		return this.st52hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st52hOpr5
	 */
	public String getSt52hOpr5() {
		return this.st52hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st52hOpr4
	 */
	public String getSt52hOpr4() {
		return this.st52hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st52hOpr3
	 */
	public String getSt52hOpr3() {
		return this.st52hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st144hOpr10
	 */
	public String getSt144hOpr10() {
		return this.st144hOpr10;
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
	 * @return st52hOpr9
	 */
	public String getSt52hOpr9() {
		return this.st52hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st52hOpr7
	 */
	public String getSt52hOpr7() {
		return this.st52hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st52hOpr8
	 */
	public String getSt52hOpr8() {
		return this.st52hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st122hOpr9
	 */
	public String getSt122hOpr9() {
		return this.st122hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st124hOpr4
	 */
	public String getSt124hOpr4() {
		return this.st124hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st940Opr2
	 */
	public String getSt940Opr2() {
		return this.st940Opr2;
	}
	
	/**
	 * Column Info
	 * @return st124hOpr3
	 */
	public String getSt124hOpr3() {
		return this.st124hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st940Opr1
	 */
	public String getSt940Opr1() {
		return this.st940Opr1;
	}
	
	/**
	 * Column Info
	 * @return st940Opr4
	 */
	public String getSt940Opr4() {
		return this.st940Opr4;
	}
	
	/**
	 * Column Info
	 * @return st124hOpr6
	 */
	public String getSt124hOpr6() {
		return this.st124hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st940Opr3
	 */
	public String getSt940Opr3() {
		return this.st940Opr3;
	}
	
	/**
	 * Column Info
	 * @return st124hOpr5
	 */
	public String getSt124hOpr5() {
		return this.st124hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st124hOpr8
	 */
	public String getSt124hOpr8() {
		return this.st124hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st124hOpr7
	 */
	public String getSt124hOpr7() {
		return this.st124hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st245Opr10
	 */
	public String getSt245Opr10() {
		return this.st245Opr10;
	}
	
	/**
	 * Column Info
	 * @return st124hOpr9
	 */
	public String getSt124hOpr9() {
		return this.st124hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st940Opr9
	 */
	public String getSt940Opr9() {
		return this.st940Opr9;
	}
	
	/**
	 * Column Info
	 * @return st940Opr6
	 */
	public String getSt940Opr6() {
		return this.st940Opr6;
	}
	
	/**
	 * Column Info
	 * @return st940Opr5
	 */
	public String getSt940Opr5() {
		return this.st940Opr5;
	}
	
	/**
	 * Column Info
	 * @return st124hOpr2
	 */
	public String getSt124hOpr2() {
		return this.st124hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st940Opr8
	 */
	public String getSt940Opr8() {
		return this.st940Opr8;
	}
	
	/**
	 * Column Info
	 * @return st32hOpr10
	 */
	public String getSt32hOpr10() {
		return this.st32hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st124hOpr1
	 */
	public String getSt124hOpr1() {
		return this.st124hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st940Opr7
	 */
	public String getSt940Opr7() {
		return this.st940Opr7;
	}
	
	/**
	 * Column Info
	 * @return st142hOpr6
	 */
	public String getSt142hOpr6() {
		return this.st142hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st142hOpr5
	 */
	public String getSt142hOpr5() {
		return this.st142hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st142hOpr4
	 */
	public String getSt142hOpr4() {
		return this.st142hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st142hOpr3
	 */
	public String getSt142hOpr3() {
		return this.st142hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st142hOpr2
	 */
	public String getSt142hOpr2() {
		return this.st142hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st142hOpr1
	 */
	public String getSt142hOpr1() {
		return this.st142hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st94hOpr1
	 */
	public String getSt94hOpr1() {
		return this.st94hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st94hOpr2
	 */
	public String getSt94hOpr2() {
		return this.st94hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st94hOpr3
	 */
	public String getSt94hOpr3() {
		return this.st94hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st94hOpr4
	 */
	public String getSt94hOpr4() {
		return this.st94hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st1520Opr1
	 */
	public String getSt1520Opr1() {
		return this.st1520Opr1;
	}
	
	/**
	 * Column Info
	 * @return st94hOpr9
	 */
	public String getSt94hOpr9() {
		return this.st94hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st112hOpr1
	 */
	public String getSt112hOpr1() {
		return this.st112hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st1520Opr5
	 */
	public String getSt1520Opr5() {
		return this.st1520Opr5;
	}
	
	/**
	 * Column Info
	 * @return st94hOpr6
	 */
	public String getSt94hOpr6() {
		return this.st94hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st1520Opr4
	 */
	public String getSt1520Opr4() {
		return this.st1520Opr4;
	}
	
	/**
	 * Column Info
	 * @return st94hOpr5
	 */
	public String getSt94hOpr5() {
		return this.st94hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st1520Opr3
	 */
	public String getSt1520Opr3() {
		return this.st1520Opr3;
	}
	
	/**
	 * Column Info
	 * @return st94hOpr8
	 */
	public String getSt94hOpr8() {
		return this.st94hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st1520Opr2
	 */
	public String getSt1520Opr2() {
		return this.st1520Opr2;
	}
	
	/**
	 * Column Info
	 * @return st94hOpr7
	 */
	public String getSt94hOpr7() {
		return this.st94hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st112hOpr6
	 */
	public String getSt112hOpr6() {
		return this.st112hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st1520Opr9
	 */
	public String getSt1520Opr9() {
		return this.st1520Opr9;
	}
	
	/**
	 * Column Info
	 * @return st112hOpr7
	 */
	public String getSt112hOpr7() {
		return this.st112hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st1520Opr8
	 */
	public String getSt1520Opr8() {
		return this.st1520Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1520Opr7
	 */
	public String getSt1520Opr7() {
		return this.st1520Opr7;
	}
	
	/**
	 * Column Info
	 * @return st112hOpr8
	 */
	public String getSt112hOpr8() {
		return this.st112hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st1520Opr6
	 */
	public String getSt1520Opr6() {
		return this.st1520Opr6;
	}
	
	/**
	 * Column Info
	 * @return st112hOpr9
	 */
	public String getSt112hOpr9() {
		return this.st112hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st112hOpr2
	 */
	public String getSt112hOpr2() {
		return this.st112hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st112hOpr3
	 */
	public String getSt112hOpr3() {
		return this.st112hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st340Opr10
	 */
	public String getSt340Opr10() {
		return this.st340Opr10;
	}
	
	/**
	 * Column Info
	 * @return st112hOpr4
	 */
	public String getSt112hOpr4() {
		return this.st112hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st112hOpr5
	 */
	public String getSt112hOpr5() {
		return this.st112hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st1120Opr7
	 */
	public String getSt1120Opr7() {
		return this.st1120Opr7;
	}
	
	/**
	 * Column Info
	 * @return st1120Opr6
	 */
	public String getSt1120Opr6() {
		return this.st1120Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1120Opr9
	 */
	public String getSt1120Opr9() {
		return this.st1120Opr9;
	}
	
	/**
	 * Column Info
	 * @return st1120Opr8
	 */
	public String getSt1120Opr8() {
		return this.st1120Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1120Opr3
	 */
	public String getSt1120Opr3() {
		return this.st1120Opr3;
	}
	
	/**
	 * Column Info
	 * @return st1120Opr2
	 */
	public String getSt1120Opr2() {
		return this.st1120Opr2;
	}
	
	/**
	 * Column Info
	 * @return st1120Opr5
	 */
	public String getSt1120Opr5() {
		return this.st1120Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1120Opr4
	 */
	public String getSt1120Opr4() {
		return this.st1120Opr4;
	}
	
	/**
	 * Column Info
	 * @return st132hOpr4
	 */
	public String getSt132hOpr4() {
		return this.st132hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st132hOpr5
	 */
	public String getSt132hOpr5() {
		return this.st132hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st132hOpr6
	 */
	public String getSt132hOpr6() {
		return this.st132hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st132hOpr7
	 */
	public String getSt132hOpr7() {
		return this.st132hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st132hOpr1
	 */
	public String getSt132hOpr1() {
		return this.st132hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st132hOpr2
	 */
	public String getSt132hOpr2() {
		return this.st132hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st132hOpr3
	 */
	public String getSt132hOpr3() {
		return this.st132hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st24hOpr10
	 */
	public String getSt24hOpr10() {
		return this.st24hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st345Opr10
	 */
	public String getSt345Opr10() {
		return this.st345Opr10;
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
	 * @return qty3
	 */
	public String getQty3() {
		return this.qty3;
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
	 * @return qty5
	 */
	public String getQty5() {
		return this.qty5;
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
	 * @return st720Opr7
	 */
	public String getSt720Opr7() {
		return this.st720Opr7;
	}
	
	/**
	 * Column Info
	 * @return st720Opr8
	 */
	public String getSt720Opr8() {
		return this.st720Opr8;
	}
	
	/**
	 * Column Info
	 * @return st720Opr5
	 */
	public String getSt720Opr5() {
		return this.st720Opr5;
	}
	
	/**
	 * Column Info
	 * @return st720Opr6
	 */
	public String getSt720Opr6() {
		return this.st720Opr6;
	}
	
	/**
	 * Column Info
	 * @return st720Opr9
	 */
	public String getSt720Opr9() {
		return this.st720Opr9;
	}
	
	/**
	 * Column Info
	 * @return st34hOpr10
	 */
	public String getSt34hOpr10() {
		return this.st34hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st62hOpr10
	 */
	public String getSt62hOpr10() {
		return this.st62hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st1440Opr10
	 */
	public String getSt1440Opr10() {
		return this.st1440Opr10;
	}
	
	/**
	 * Column Info
	 * @return st720Opr3
	 */
	public String getSt720Opr3() {
		return this.st720Opr3;
	}
	
	/**
	 * Column Info
	 * @return st720Opr4
	 */
	public String getSt720Opr4() {
		return this.st720Opr4;
	}
	
	/**
	 * Column Info
	 * @return st720Opr1
	 */
	public String getSt720Opr1() {
		return this.st720Opr1;
	}
	
	/**
	 * Column Info
	 * @return st720Opr2
	 */
	public String getSt720Opr2() {
		return this.st720Opr2;
	}
	
	/**
	 * Column Info
	 * @return st1045Opr10
	 */
	public String getSt1045Opr10() {
		return this.st1045Opr10;
	}
	
	/**
	 * Column Info
	 * @return st1540Opr1
	 */
	public String getSt1540Opr1() {
		return this.st1540Opr1;
	}
	
	/**
	 * Column Info
	 * @return st1540Opr2
	 */
	public String getSt1540Opr2() {
		return this.st1540Opr2;
	}
	
	/**
	 * Column Info
	 * @return st1540Opr3
	 */
	public String getSt1540Opr3() {
		return this.st1540Opr3;
	}
	
	/**
	 * Column Info
	 * @return st1540Opr4
	 */
	public String getSt1540Opr4() {
		return this.st1540Opr4;
	}
	
	/**
	 * Column Info
	 * @return st1540Opr5
	 */
	public String getSt1540Opr5() {
		return this.st1540Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1540Opr6
	 */
	public String getSt1540Opr6() {
		return this.st1540Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1540Opr7
	 */
	public String getSt1540Opr7() {
		return this.st1540Opr7;
	}
	
	/**
	 * Column Info
	 * @return st1540Opr8
	 */
	public String getSt1540Opr8() {
		return this.st1540Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1540Opr9
	 */
	public String getSt1540Opr9() {
		return this.st1540Opr9;
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
	 * @return st1545Opr1
	 */
	public String getSt1545Opr1() {
		return this.st1545Opr1;
	}
	
	/**
	 * Column Info
	 * @return st1545Opr2
	 */
	public String getSt1545Opr2() {
		return this.st1545Opr2;
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
	 * @return st420Opr10
	 */
	public String getSt420Opr10() {
		return this.st420Opr10;
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
	 * @return st1545Opr5
	 */
	public String getSt1545Opr5() {
		return this.st1545Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1545Opr6
	 */
	public String getSt1545Opr6() {
		return this.st1545Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1545Opr3
	 */
	public String getSt1545Opr3() {
		return this.st1545Opr3;
	}
	
	/**
	 * Column Info
	 * @return st1545Opr4
	 */
	public String getSt1545Opr4() {
		return this.st1545Opr4;
	}
	
	/**
	 * Column Info
	 * @return st1545Opr9
	 */
	public String getSt1545Opr9() {
		return this.st1545Opr9;
	}
	
	/**
	 * Column Info
	 * @return st1545Opr7
	 */
	public String getSt1545Opr7() {
		return this.st1545Opr7;
	}
	
	/**
	 * Column Info
	 * @return st1545Opr8
	 */
	public String getSt1545Opr8() {
		return this.st1545Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1320Opr1
	 */
	public String getSt1320Opr1() {
		return this.st1320Opr1;
	}
	
	/**
	 * Column Info
	 * @return st1320Opr3
	 */
	public String getSt1320Opr3() {
		return this.st1320Opr3;
	}
	
	/**
	 * Column Info
	 * @return st132hOpr9
	 */
	public String getSt132hOpr9() {
		return this.st132hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st1320Opr2
	 */
	public String getSt1320Opr2() {
		return this.st1320Opr2;
	}
	
	/**
	 * Column Info
	 * @return st132hOpr8
	 */
	public String getSt132hOpr8() {
		return this.st132hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st1320Opr5
	 */
	public String getSt1320Opr5() {
		return this.st1320Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1320Opr4
	 */
	public String getSt1320Opr4() {
		return this.st1320Opr4;
	}
	
	/**
	 * Column Info
	 * @return st1320Opr7
	 */
	public String getSt1320Opr7() {
		return this.st1320Opr7;
	}
	
	/**
	 * Column Info
	 * @return st1320Opr6
	 */
	public String getSt1320Opr6() {
		return this.st1320Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1320Opr9
	 */
	public String getSt1320Opr9() {
		return this.st1320Opr9;
	}
	
	/**
	 * Column Info
	 * @return st1320Opr8
	 */
	public String getSt1320Opr8() {
		return this.st1320Opr8;
	}
	
	/**
	 * Column Info
	 * @return st340Opr1
	 */
	public String getSt340Opr1() {
		return this.st340Opr1;
	}
	
	/**
	 * Column Info
	 * @return st340Opr2
	 */
	public String getSt340Opr2() {
		return this.st340Opr2;
	}
	
	/**
	 * Column Info
	 * @return st340Opr9
	 */
	public String getSt340Opr9() {
		return this.st340Opr9;
	}
	
	/**
	 * Column Info
	 * @return st340Opr8
	 */
	public String getSt340Opr8() {
		return this.st340Opr8;
	}
	
	/**
	 * Column Info
	 * @return st340Opr7
	 */
	public String getSt340Opr7() {
		return this.st340Opr7;
	}
	
	/**
	 * Column Info
	 * @return st340Opr6
	 */
	public String getSt340Opr6() {
		return this.st340Opr6;
	}
	
	/**
	 * Column Info
	 * @return st340Opr5
	 */
	public String getSt340Opr5() {
		return this.st340Opr5;
	}
	
	/**
	 * Column Info
	 * @return st340Opr4
	 */
	public String getSt340Opr4() {
		return this.st340Opr4;
	}
	
	/**
	 * Column Info
	 * @return st340Opr3
	 */
	public String getSt340Opr3() {
		return this.st340Opr3;
	}
	
	/**
	 * Column Info
	 * @return allFlg
	 */
	public String getAllFlg() {
		return this.allFlg;
	}
	
	/**
	 * Column Info
	 * @return st445Opr10
	 */
	public String getSt445Opr10() {
		return this.st445Opr10;
	}
	
	/**
	 * Column Info
	 * @return st120Opr1
	 */
	public String getSt120Opr1() {
		return this.st120Opr1;
	}
	
	/**
	 * Column Info
	 * @return st120Opr2
	 */
	public String getSt120Opr2() {
		return this.st120Opr2;
	}
	
	/**
	 * Column Info
	 * @return st120Opr10
	 */
	public String getSt120Opr10() {
		return this.st120Opr10;
	}
	
	/**
	 * Column Info
	 * @return st132hOpr10
	 */
	public String getSt132hOpr10() {
		return this.st132hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st120Opr4
	 */
	public String getSt120Opr4() {
		return this.st120Opr4;
	}
	
	/**
	 * Column Info
	 * @return st120Opr3
	 */
	public String getSt120Opr3() {
		return this.st120Opr3;
	}
	
	/**
	 * Column Info
	 * @return st120Opr6
	 */
	public String getSt120Opr6() {
		return this.st120Opr6;
	}
	
	/**
	 * Column Info
	 * @return st120Opr5
	 */
	public String getSt120Opr5() {
		return this.st120Opr5;
	}
	
	/**
	 * Column Info
	 * @return st120Opr8
	 */
	public String getSt120Opr8() {
		return this.st120Opr8;
	}
	
	/**
	 * Column Info
	 * @return st120Opr7
	 */
	public String getSt120Opr7() {
		return this.st120Opr7;
	}
	
	/**
	 * Column Info
	 * @return st120Opr9
	 */
	public String getSt120Opr9() {
		return this.st120Opr9;
	}
	
	/**
	 * Column Info
	 * @return st1040Opr10
	 */
	public String getSt1040Opr10() {
		return this.st1040Opr10;
	}
	
	/**
	 * Column Info
	 * @return st92hOpr10
	 */
	public String getSt92hOpr10() {
		return this.st92hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st1045Opr5
	 */
	public String getSt1045Opr5() {
		return this.st1045Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1045Opr4
	 */
	public String getSt1045Opr4() {
		return this.st1045Opr4;
	}
	
	/**
	 * Column Info
	 * @return st1045Opr7
	 */
	public String getSt1045Opr7() {
		return this.st1045Opr7;
	}
	
	/**
	 * Column Info
	 * @return st1045Opr6
	 */
	public String getSt1045Opr6() {
		return this.st1045Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1045Opr1
	 */
	public String getSt1045Opr1() {
		return this.st1045Opr1;
	}
	
	/**
	 * Column Info
	 * @return st540Opr10
	 */
	public String getSt540Opr10() {
		return this.st540Opr10;
	}
	
	/**
	 * Column Info
	 * @return st1045Opr3
	 */
	public String getSt1045Opr3() {
		return this.st1045Opr3;
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
	 * @return st1045Opr2
	 */
	public String getSt1045Opr2() {
		return this.st1045Opr2;
	}
	
	/**
	 * Column Info
	 * @return st1045Opr9
	 */
	public String getSt1045Opr9() {
		return this.st1045Opr9;
	}
	
	/**
	 * Column Info
	 * @return st1045Opr8
	 */
	public String getSt1045Opr8() {
		return this.st1045Opr8;
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
	 * @return st1520Opr10
	 */
	public String getSt1520Opr10() {
		return this.st1520Opr10;
	}
	
	/**
	 * Column Info
	 * @return st345Opr7
	 */
	public String getSt345Opr7() {
		return this.st345Opr7;
	}
	
	/**
	 * Column Info
	 * @return st345Opr6
	 */
	public String getSt345Opr6() {
		return this.st345Opr6;
	}
	
	/**
	 * Column Info
	 * @return st345Opr9
	 */
	public String getSt345Opr9() {
		return this.st345Opr9;
	}
	
	/**
	 * Column Info
	 * @return st345Opr8
	 */
	public String getSt345Opr8() {
		return this.st345Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1120Opr1
	 */
	public String getSt1120Opr1() {
		return this.st1120Opr1;
	}
	
	/**
	 * Column Info
	 * @return st345Opr1
	 */
	public String getSt345Opr1() {
		return this.st345Opr1;
	}
	
	/**
	 * Column Info
	 * @return st345Opr3
	 */
	public String getSt345Opr3() {
		return this.st345Opr3;
	}
	
	/**
	 * Column Info
	 * @return st345Opr2
	 */
	public String getSt345Opr2() {
		return this.st345Opr2;
	}
	
	/**
	 * Column Info
	 * @return st345Opr5
	 */
	public String getSt345Opr5() {
		return this.st345Opr5;
	}
	
	/**
	 * Column Info
	 * @return st345Opr4
	 */
	public String getSt345Opr4() {
		return this.st345Opr4;
	}
	
	/**
	 * Column Info
	 * @return st12hOpr2
	 */
	public String getSt12hOpr2() {
		return this.st12hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st12hOpr1
	 */
	public String getSt12hOpr1() {
		return this.st12hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st1340Opr1
	 */
	public String getSt1340Opr1() {
		return this.st1340Opr1;
	}
	
	/**
	 * Column Info
	 * @return st12hOpr8
	 */
	public String getSt12hOpr8() {
		return this.st12hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st12hOpr7
	 */
	public String getSt12hOpr7() {
		return this.st12hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st12hOpr9
	 */
	public String getSt12hOpr9() {
		return this.st12hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st12hOpr4
	 */
	public String getSt12hOpr4() {
		return this.st12hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st12hOpr3
	 */
	public String getSt12hOpr3() {
		return this.st12hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st12hOpr6
	 */
	public String getSt12hOpr6() {
		return this.st12hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st12hOpr5
	 */
	public String getSt12hOpr5() {
		return this.st12hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st1420Opr6
	 */
	public String getSt1420Opr6() {
		return this.st1420Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1420Opr5
	 */
	public String getSt1420Opr5() {
		return this.st1420Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1420Opr4
	 */
	public String getSt1420Opr4() {
		return this.st1420Opr4;
	}
	
	/**
	 * Column Info
	 * @return st1420Opr3
	 */
	public String getSt1420Opr3() {
		return this.st1420Opr3;
	}
	
	/**
	 * Column Info
	 * @return st1420Opr2
	 */
	public String getSt1420Opr2() {
		return this.st1420Opr2;
	}
	
	/**
	 * Column Info
	 * @return st1420Opr1
	 */
	public String getSt1420Opr1() {
		return this.st1420Opr1;
	}
	
	/**
	 * Column Info
	 * @return st1420Opr9
	 */
	public String getSt1420Opr9() {
		return this.st1420Opr9;
	}
	
	/**
	 * Column Info
	 * @return st1420Opr8
	 */
	public String getSt1420Opr8() {
		return this.st1420Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1420Opr7
	 */
	public String getSt1420Opr7() {
		return this.st1420Opr7;
	}
	
	/**
	 * Column Info
	 * @return st84hOpr1
	 */
	public String getSt84hOpr1() {
		return this.st84hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st84hOpr3
	 */
	public String getSt84hOpr3() {
		return this.st84hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st84hOpr2
	 */
	public String getSt84hOpr2() {
		return this.st84hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st84hOpr5
	 */
	public String getSt84hOpr5() {
		return this.st84hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st84hOpr4
	 */
	public String getSt84hOpr4() {
		return this.st84hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st152hOpr10
	 */
	public String getSt152hOpr10() {
		return this.st152hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st84hOpr6
	 */
	public String getSt84hOpr6() {
		return this.st84hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st84hOpr7
	 */
	public String getSt84hOpr7() {
		return this.st84hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st84hOpr8
	 */
	public String getSt84hOpr8() {
		return this.st84hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st84hOpr9
	 */
	public String getSt84hOpr9() {
		return this.st84hOpr9;
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
	 * @return st14hOpr10
	 */
	public String getSt14hOpr10() {
		return this.st14hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st640Opr8
	 */
	public String getSt640Opr8() {
		return this.st640Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1245Opr9
	 */
	public String getSt1245Opr9() {
		return this.st1245Opr9;
	}
	
	/**
	 * Column Info
	 * @return st1245Opr8
	 */
	public String getSt1245Opr8() {
		return this.st1245Opr8;
	}
	
	/**
	 * Column Info
	 * @return st640Opr9
	 */
	public String getSt640Opr9() {
		return this.st640Opr9;
	}
	
	/**
	 * Column Info
	 * @return st1245Opr7
	 */
	public String getSt1245Opr7() {
		return this.st1245Opr7;
	}
	
	/**
	 * Column Info
	 * @return st1245Opr6
	 */
	public String getSt1245Opr6() {
		return this.st1245Opr6;
	}
	
	/**
	 * Column Info
	 * @return st640Opr4
	 */
	public String getSt640Opr4() {
		return this.st640Opr4;
	}
	
	/**
	 * Column Info
	 * @return st1245Opr5
	 */
	public String getSt1245Opr5() {
		return this.st1245Opr5;
	}
	
	/**
	 * Column Info
	 * @return st640Opr5
	 */
	public String getSt640Opr5() {
		return this.st640Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1245Opr4
	 */
	public String getSt1245Opr4() {
		return this.st1245Opr4;
	}
	
	/**
	 * Column Info
	 * @return st1245Opr3
	 */
	public String getSt1245Opr3() {
		return this.st1245Opr3;
	}
	
	/**
	 * Column Info
	 * @return st640Opr6
	 */
	public String getSt640Opr6() {
		return this.st640Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1245Opr2
	 */
	public String getSt1245Opr2() {
		return this.st1245Opr2;
	}
	
	/**
	 * Column Info
	 * @return st640Opr7
	 */
	public String getSt640Opr7() {
		return this.st640Opr7;
	}
	
	/**
	 * Column Info
	 * @return st1245Opr1
	 */
	public String getSt1245Opr1() {
		return this.st1245Opr1;
	}
	
	/**
	 * Column Info
	 * @return st640Opr1
	 */
	public String getSt640Opr1() {
		return this.st640Opr1;
	}
	
	/**
	 * Column Info
	 * @return st640Opr2
	 */
	public String getSt640Opr2() {
		return this.st640Opr2;
	}
	
	/**
	 * Column Info
	 * @return st640Opr3
	 */
	public String getSt640Opr3() {
		return this.st640Opr3;
	}
	
	/**
	 * Column Info
	 * @return st52hOpr10
	 */
	public String getSt52hOpr10() {
		return this.st52hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st1340Opr2
	 */
	public String getSt1340Opr2() {
		return this.st1340Opr2;
	}
	
	/**
	 * Column Info
	 * @return st1340Opr3
	 */
	public String getSt1340Opr3() {
		return this.st1340Opr3;
	}
	
	/**
	 * Column Info
	 * @return st1340Opr4
	 */
	public String getSt1340Opr4() {
		return this.st1340Opr4;
	}
	
	/**
	 * Column Info
	 * @return st1340Opr5
	 */
	public String getSt1340Opr5() {
		return this.st1340Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1340Opr6
	 */
	public String getSt1340Opr6() {
		return this.st1340Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1340Opr7
	 */
	public String getSt1340Opr7() {
		return this.st1340Opr7;
	}
	
	/**
	 * Column Info
	 * @return st1340Opr8
	 */
	public String getSt1340Opr8() {
		return this.st1340Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1340Opr9
	 */
	public String getSt1340Opr9() {
		return this.st1340Opr9;
	}
	
	/**
	 * Column Info
	 * @return st945Opr1
	 */
	public String getSt945Opr1() {
		return this.st945Opr1;
	}
	
	/**
	 * Column Info
	 * @return st945Opr3
	 */
	public String getSt945Opr3() {
		return this.st945Opr3;
	}
	
	/**
	 * Column Info
	 * @return st945Opr2
	 */
	public String getSt945Opr2() {
		return this.st945Opr2;
	}
	
	/**
	 * Column Info
	 * @return st945Opr5
	 */
	public String getSt945Opr5() {
		return this.st945Opr5;
	}
	
	/**
	 * Column Info
	 * @return st945Opr4
	 */
	public String getSt945Opr4() {
		return this.st945Opr4;
	}
	
	/**
	 * Column Info
	 * @return st945Opr7
	 */
	public String getSt945Opr7() {
		return this.st945Opr7;
	}
	
	/**
	 * Column Info
	 * @return st945Opr6
	 */
	public String getSt945Opr6() {
		return this.st945Opr6;
	}
	
	/**
	 * Column Info
	 * @return st64hOpr10
	 */
	public String getSt64hOpr10() {
		return this.st64hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st520Opr1
	 */
	public String getSt520Opr1() {
		return this.st520Opr1;
	}
	
	/**
	 * Column Info
	 * @return st540Opr2
	 */
	public String getSt540Opr2() {
		return this.st540Opr2;
	}
	
	/**
	 * Column Info
	 * @return st540Opr1
	 */
	public String getSt540Opr1() {
		return this.st540Opr1;
	}
	
	/**
	 * Column Info
	 * @return st520Opr2
	 */
	public String getSt520Opr2() {
		return this.st520Opr2;
	}
	
	/**
	 * Column Info
	 * @return st540Opr4
	 */
	public String getSt540Opr4() {
		return this.st540Opr4;
	}
	
	/**
	 * Column Info
	 * @return st540Opr3
	 */
	public String getSt540Opr3() {
		return this.st540Opr3;
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
	 * @return st520Opr5
	 */
	public String getSt520Opr5() {
		return this.st520Opr5;
	}
	
	/**
	 * Column Info
	 * @return st540Opr6
	 */
	public String getSt540Opr6() {
		return this.st540Opr6;
	}
	
	/**
	 * Column Info
	 * @return st540Opr5
	 */
	public String getSt540Opr5() {
		return this.st540Opr5;
	}
	
	/**
	 * Column Info
	 * @return st520Opr6
	 */
	public String getSt520Opr6() {
		return this.st520Opr6;
	}
	
	/**
	 * Column Info
	 * @return st520Opr3
	 */
	public String getSt520Opr3() {
		return this.st520Opr3;
	}
	
	/**
	 * Column Info
	 * @return st540Opr8
	 */
	public String getSt540Opr8() {
		return this.st540Opr8;
	}
	
	/**
	 * Column Info
	 * @return st520Opr4
	 */
	public String getSt520Opr4() {
		return this.st520Opr4;
	}
	
	/**
	 * Column Info
	 * @return st540Opr7
	 */
	public String getSt540Opr7() {
		return this.st540Opr7;
	}
	
	/**
	 * Column Info
	 * @return st520Opr9
	 */
	public String getSt520Opr9() {
		return this.st520Opr9;
	}
	
	/**
	 * Column Info
	 * @return st540Opr9
	 */
	public String getSt540Opr9() {
		return this.st540Opr9;
	}
	
	/**
	 * Column Info
	 * @return st520Opr7
	 */
	public String getSt520Opr7() {
		return this.st520Opr7;
	}
	
	/**
	 * Column Info
	 * @return st520Opr8
	 */
	public String getSt520Opr8() {
		return this.st520Opr8;
	}
	
	/**
	 * Column Info
	 * @return st945Opr10
	 */
	public String getSt945Opr10() {
		return this.st945Opr10;
	}
	
	/**
	 * Column Info
	 * @return st94hOpr10
	 */
	public String getSt94hOpr10() {
		return this.st94hOpr10;
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
	 * @return st1540Opr10
	 */
	public String getSt1540Opr10() {
		return this.st1540Opr10;
	}
	
	/**
	 * Column Info
	 * @return st945Opr8
	 */
	public String getSt945Opr8() {
		return this.st945Opr8;
	}
	
	/**
	 * Column Info
	 * @return st945Opr9
	 */
	public String getSt945Opr9() {
		return this.st945Opr9;
	}
	
	/**
	 * Column Info
	 * @return st32hOpr9
	 */
	public String getSt32hOpr9() {
		return this.st32hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st24hOpr1
	 */
	public String getSt24hOpr1() {
		return this.st24hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st920Opr9
	 */
	public String getSt920Opr9() {
		return this.st920Opr9;
	}
	
	/**
	 * Column Info
	 * @return st24hOpr3
	 */
	public String getSt24hOpr3() {
		return this.st24hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st920Opr8
	 */
	public String getSt920Opr8() {
		return this.st920Opr8;
	}
	
	/**
	 * Column Info
	 * @return st24hOpr2
	 */
	public String getSt24hOpr2() {
		return this.st24hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st920Opr7
	 */
	public String getSt920Opr7() {
		return this.st920Opr7;
	}
	
	/**
	 * Column Info
	 * @return st920Opr6
	 */
	public String getSt920Opr6() {
		return this.st920Opr6;
	}
	
	/**
	 * Column Info
	 * @return st920Opr5
	 */
	public String getSt920Opr5() {
		return this.st920Opr5;
	}
	
	/**
	 * Column Info
	 * @return st920Opr4
	 */
	public String getSt920Opr4() {
		return this.st920Opr4;
	}
	
	/**
	 * Column Info
	 * @return st920Opr3
	 */
	public String getSt920Opr3() {
		return this.st920Opr3;
	}
	
	/**
	 * Column Info
	 * @return st32hOpr4
	 */
	public String getSt32hOpr4() {
		return this.st32hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st920Opr2
	 */
	public String getSt920Opr2() {
		return this.st920Opr2;
	}
	
	/**
	 * Column Info
	 * @return st24hOpr9
	 */
	public String getSt24hOpr9() {
		return this.st24hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st32hOpr3
	 */
	public String getSt32hOpr3() {
		return this.st32hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st920Opr1
	 */
	public String getSt920Opr1() {
		return this.st920Opr1;
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
	 * @return st24hOpr8
	 */
	public String getSt24hOpr8() {
		return this.st24hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st240Opr10
	 */
	public String getSt240Opr10() {
		return this.st240Opr10;
	}
	
	/**
	 * Column Info
	 * @return st32hOpr2
	 */
	public String getSt32hOpr2() {
		return this.st32hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st32hOpr1
	 */
	public String getSt32hOpr1() {
		return this.st32hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st24hOpr5
	 */
	public String getSt24hOpr5() {
		return this.st24hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st32hOpr8
	 */
	public String getSt32hOpr8() {
		return this.st32hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st24hOpr4
	 */
	public String getSt24hOpr4() {
		return this.st24hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st32hOpr7
	 */
	public String getSt32hOpr7() {
		return this.st32hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st32hOpr6
	 */
	public String getSt32hOpr6() {
		return this.st32hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st24hOpr7
	 */
	public String getSt24hOpr7() {
		return this.st24hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st32hOpr5
	 */
	public String getSt32hOpr5() {
		return this.st32hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st24hOpr6
	 */
	public String getSt24hOpr6() {
		return this.st24hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st240Opr4
	 */
	public String getSt240Opr4() {
		return this.st240Opr4;
	}
	
	/**
	 * Column Info
	 * @return st820Opr1
	 */
	public String getSt820Opr1() {
		return this.st820Opr1;
	}
	
	/**
	 * Column Info
	 * @return st112hOpr10
	 */
	public String getSt112hOpr10() {
		return this.st112hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st240Opr5
	 */
	public String getSt240Opr5() {
		return this.st240Opr5;
	}
	
	/**
	 * Column Info
	 * @return st820Opr3
	 */
	public String getSt820Opr3() {
		return this.st820Opr3;
	}
	
	/**
	 * Column Info
	 * @return st240Opr6
	 */
	public String getSt240Opr6() {
		return this.st240Opr6;
	}
	
	/**
	 * Column Info
	 * @return st820Opr2
	 */
	public String getSt820Opr2() {
		return this.st820Opr2;
	}
	
	/**
	 * Column Info
	 * @return st240Opr7
	 */
	public String getSt240Opr7() {
		return this.st240Opr7;
	}
	
	/**
	 * Column Info
	 * @return st240Opr8
	 */
	public String getSt240Opr8() {
		return this.st240Opr8;
	}
	
	/**
	 * Column Info
	 * @return st240Opr9
	 */
	public String getSt240Opr9() {
		return this.st240Opr9;
	}
	
	/**
	 * Column Info
	 * @return st64hOpr7
	 */
	public String getSt64hOpr7() {
		return this.st64hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st820Opr9
	 */
	public String getSt820Opr9() {
		return this.st820Opr9;
	}
	
	/**
	 * Column Info
	 * @return st64hOpr6
	 */
	public String getSt64hOpr6() {
		return this.st64hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st820Opr8
	 */
	public String getSt820Opr8() {
		return this.st820Opr8;
	}
	
	/**
	 * Column Info
	 * @return st64hOpr5
	 */
	public String getSt64hOpr5() {
		return this.st64hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st64hOpr4
	 */
	public String getSt64hOpr4() {
		return this.st64hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st64hOpr3
	 */
	public String getSt64hOpr3() {
		return this.st64hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st820Opr5
	 */
	public String getSt820Opr5() {
		return this.st820Opr5;
	}
	
	/**
	 * Column Info
	 * @return st820Opr4
	 */
	public String getSt820Opr4() {
		return this.st820Opr4;
	}
	
	/**
	 * Column Info
	 * @return st64hOpr2
	 */
	public String getSt64hOpr2() {
		return this.st64hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st64hOpr1
	 */
	public String getSt64hOpr1() {
		return this.st64hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st820Opr7
	 */
	public String getSt820Opr7() {
		return this.st820Opr7;
	}
	
	/**
	 * Column Info
	 * @return st820Opr6
	 */
	public String getSt820Opr6() {
		return this.st820Opr6;
	}
	
	/**
	 * Column Info
	 * @return st445Opr1
	 */
	public String getSt445Opr1() {
		return this.st445Opr1;
	}
	
	/**
	 * Column Info
	 * @return st445Opr2
	 */
	public String getSt445Opr2() {
		return this.st445Opr2;
	}
	
	/**
	 * Column Info
	 * @return st445Opr3
	 */
	public String getSt445Opr3() {
		return this.st445Opr3;
	}
	
	/**
	 * Column Info
	 * @return st64hOpr8
	 */
	public String getSt64hOpr8() {
		return this.st64hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st445Opr4
	 */
	public String getSt445Opr4() {
		return this.st445Opr4;
	}
	
	/**
	 * Column Info
	 * @return st64hOpr9
	 */
	public String getSt64hOpr9() {
		return this.st64hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st445Opr5
	 */
	public String getSt445Opr5() {
		return this.st445Opr5;
	}
	
	/**
	 * Column Info
	 * @return st445Opr6
	 */
	public String getSt445Opr6() {
		return this.st445Opr6;
	}
	
	/**
	 * Column Info
	 * @return st445Opr7
	 */
	public String getSt445Opr7() {
		return this.st445Opr7;
	}
	
	/**
	 * Column Info
	 * @return st445Opr8
	 */
	public String getSt445Opr8() {
		return this.st445Opr8;
	}
	
	/**
	 * Column Info
	 * @return st240Opr1
	 */
	public String getSt240Opr1() {
		return this.st240Opr1;
	}
	
	/**
	 * Column Info
	 * @return st445Opr9
	 */
	public String getSt445Opr9() {
		return this.st445Opr9;
	}
	
	/**
	 * Column Info
	 * @return st240Opr3
	 */
	public String getSt240Opr3() {
		return this.st240Opr3;
	}
	
	/**
	 * Column Info
	 * @return st240Opr2
	 */
	public String getSt240Opr2() {
		return this.st240Opr2;
	}
	
	/**
	 * Column Info
	 * @return st9
	 */
	public String getSt9() {
		return this.st9;
	}
	
	/**
	 * Column Info
	 * @return st7
	 */
	public String getSt7() {
		return this.st7;
	}
	
	/**
	 * Column Info
	 * @return st8
	 */
	public String getSt8() {
		return this.st8;
	}
	
	/**
	 * Column Info
	 * @return st5
	 */
	public String getSt5() {
		return this.st5;
	}
	
	/**
	 * Column Info
	 * @return st6
	 */
	public String getSt6() {
		return this.st6;
	}
	
	/**
	 * Column Info
	 * @return st3
	 */
	public String getSt3() {
		return this.st3;
	}
	
	/**
	 * Column Info
	 * @return st4
	 */
	public String getSt4() {
		return this.st4;
	}
	
	/**
	 * Column Info
	 * @return st1
	 */
	public String getSt1() {
		return this.st1;
	}
	
	/**
	 * Column Info
	 * @return st2
	 */
	public String getSt2() {
		return this.st2;
	}
	
	/**
	 * Column Info
	 * @return st940Opr10
	 */
	public String getSt940Opr10() {
		return this.st940Opr10;
	}
	
	/**
	 * Column Info
	 * @return st1220Opr10
	 */
	public String getSt1220Opr10() {
		return this.st1220Opr10;
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
	 * @return st320Opr9
	 */
	public String getSt320Opr9() {
		return this.st320Opr9;
	}
	
	/**
	 * Column Info
	 * @return st320Opr8
	 */
	public String getSt320Opr8() {
		return this.st320Opr8;
	}
	
	/**
	 * Column Info
	 * @return st320Opr7
	 */
	public String getSt320Opr7() {
		return this.st320Opr7;
	}
	
	/**
	 * Column Info
	 * @return st320Opr6
	 */
	public String getSt320Opr6() {
		return this.st320Opr6;
	}
	
	/**
	 * Column Info
	 * @return st320Opr5
	 */
	public String getSt320Opr5() {
		return this.st320Opr5;
	}
	
	/**
	 * Column Info
	 * @return st42hOpr10
	 */
	public String getSt42hOpr10() {
		return this.st42hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st320Opr4
	 */
	public String getSt320Opr4() {
		return this.st320Opr4;
	}
	
	/**
	 * Column Info
	 * @return st320Opr3
	 */
	public String getSt320Opr3() {
		return this.st320Opr3;
	}
	
	/**
	 * Column Info
	 * @return st320Opr2
	 */
	public String getSt320Opr2() {
		return this.st320Opr2;
	}
	
	/**
	 * Column Info
	 * @return st320Opr1
	 */
	public String getSt320Opr1() {
		return this.st320Opr1;
	}
	
	/**
	 * Column Info
	 * @return st144hOpr9
	 */
	public String getSt144hOpr9() {
		return this.st144hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st645Opr10
	 */
	public String getSt645Opr10() {
		return this.st645Opr10;
	}
	
	/**
	 * Column Info
	 * @return st22hOpr1
	 */
	public String getSt22hOpr1() {
		return this.st22hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st22hOpr8
	 */
	public String getSt22hOpr8() {
		return this.st22hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st22hOpr9
	 */
	public String getSt22hOpr9() {
		return this.st22hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st22hOpr6
	 */
	public String getSt22hOpr6() {
		return this.st22hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st22hOpr7
	 */
	public String getSt22hOpr7() {
		return this.st22hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st122hOpr10
	 */
	public String getSt122hOpr10() {
		return this.st122hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st104hOpr10
	 */
	public String getSt104hOpr10() {
		return this.st104hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st22hOpr4
	 */
	public String getSt22hOpr4() {
		return this.st22hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st22hOpr5
	 */
	public String getSt22hOpr5() {
		return this.st22hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st22hOpr2
	 */
	public String getSt22hOpr2() {
		return this.st22hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st22hOpr3
	 */
	public String getSt22hOpr3() {
		return this.st22hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st440Opr10
	 */
	public String getSt440Opr10() {
		return this.st440Opr10;
	}
	
	/**
	 * Column Info
	 * @return st44hOpr6
	 */
	public String getSt44hOpr6() {
		return this.st44hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st44hOpr7
	 */
	public String getSt44hOpr7() {
		return this.st44hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st44hOpr8
	 */
	public String getSt44hOpr8() {
		return this.st44hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st44hOpr9
	 */
	public String getSt44hOpr9() {
		return this.st44hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st44hOpr2
	 */
	public String getSt44hOpr2() {
		return this.st44hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st44hOpr3
	 */
	public String getSt44hOpr3() {
		return this.st44hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st44hOpr4
	 */
	public String getSt44hOpr4() {
		return this.st44hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st44hOpr5
	 */
	public String getSt44hOpr5() {
		return this.st44hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st44hOpr1
	 */
	public String getSt44hOpr1() {
		return this.st44hOpr1;
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
	 * @return st144hOpr1
	 */
	public String getSt144hOpr1() {
		return this.st144hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st144hOpr2
	 */
	public String getSt144hOpr2() {
		return this.st144hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st144hOpr3
	 */
	public String getSt144hOpr3() {
		return this.st144hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st74hOpr10
	 */
	public String getSt74hOpr10() {
		return this.st74hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st144hOpr4
	 */
	public String getSt144hOpr4() {
		return this.st144hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st144hOpr5
	 */
	public String getSt144hOpr5() {
		return this.st144hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st144hOpr6
	 */
	public String getSt144hOpr6() {
		return this.st144hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st144hOpr7
	 */
	public String getSt144hOpr7() {
		return this.st144hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st144hOpr8
	 */
	public String getSt144hOpr8() {
		return this.st144hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st72hOpr10
	 */
	public String getSt72hOpr10() {
		return this.st72hOpr10;
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
	 * @return st420Opr9
	 */
	public String getSt420Opr9() {
		return this.st420Opr9;
	}
	
	/**
	 * Column Info
	 * @return st420Opr8
	 */
	public String getSt420Opr8() {
		return this.st420Opr8;
	}
	
	/**
	 * Column Info
	 * @return st420Opr5
	 */
	public String getSt420Opr5() {
		return this.st420Opr5;
	}
	
	/**
	 * Column Info
	 * @return st420Opr4
	 */
	public String getSt420Opr4() {
		return this.st420Opr4;
	}
	
	/**
	 * Column Info
	 * @return st420Opr7
	 */
	public String getSt420Opr7() {
		return this.st420Opr7;
	}
	
	/**
	 * Column Info
	 * @return st420Opr6
	 */
	public String getSt420Opr6() {
		return this.st420Opr6;
	}
	
	/**
	 * Column Info
	 * @return st420Opr1
	 */
	public String getSt420Opr1() {
		return this.st420Opr1;
	}
	
	/**
	 * Column Info
	 * @return st420Opr3
	 */
	public String getSt420Opr3() {
		return this.st420Opr3;
	}
	
	/**
	 * Column Info
	 * @return st420Opr2
	 */
	public String getSt420Opr2() {
		return this.st420Opr2;
	}
	
	/**
	 * Column Info
	 * @return st840Opr9
	 */
	public String getSt840Opr9() {
		return this.st840Opr9;
	}
	
	/**
	 * Column Info
	 * @return st840Opr8
	 */
	public String getSt840Opr8() {
		return this.st840Opr8;
	}
	
	/**
	 * Column Info
	 * @return st840Opr7
	 */
	public String getSt840Opr7() {
		return this.st840Opr7;
	}
	
	/**
	 * Column Info
	 * @return st840Opr6
	 */
	public String getSt840Opr6() {
		return this.st840Opr6;
	}
	
	/**
	 * Column Info
	 * @return st22hOpr10
	 */
	public String getSt22hOpr10() {
		return this.st22hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st840Opr1
	 */
	public String getSt840Opr1() {
		return this.st840Opr1;
	}
	
	/**
	 * Column Info
	 * @return st440Opr9
	 */
	public String getSt440Opr9() {
		return this.st440Opr9;
	}
	
	/**
	 * Column Info
	 * @return st440Opr8
	 */
	public String getSt440Opr8() {
		return this.st440Opr8;
	}
	
	/**
	 * Column Info
	 * @return st440Opr7
	 */
	public String getSt440Opr7() {
		return this.st440Opr7;
	}
	
	/**
	 * Column Info
	 * @return st440Opr6
	 */
	public String getSt440Opr6() {
		return this.st440Opr6;
	}
	
	/**
	 * Column Info
	 * @return st440Opr5
	 */
	public String getSt440Opr5() {
		return this.st440Opr5;
	}
	
	/**
	 * Column Info
	 * @return st840Opr5
	 */
	public String getSt840Opr5() {
		return this.st840Opr5;
	}
	
	/**
	 * Column Info
	 * @return st840Opr4
	 */
	public String getSt840Opr4() {
		return this.st840Opr4;
	}
	
	/**
	 * Column Info
	 * @return st440Opr4
	 */
	public String getSt440Opr4() {
		return this.st440Opr4;
	}
	
	/**
	 * Column Info
	 * @return st840Opr3
	 */
	public String getSt840Opr3() {
		return this.st840Opr3;
	}
	
	/**
	 * Column Info
	 * @return st440Opr3
	 */
	public String getSt440Opr3() {
		return this.st440Opr3;
	}
	
	/**
	 * Column Info
	 * @return st440Opr2
	 */
	public String getSt440Opr2() {
		return this.st440Opr2;
	}
	
	/**
	 * Column Info
	 * @return st840Opr2
	 */
	public String getSt840Opr2() {
		return this.st840Opr2;
	}
	
	/**
	 * Column Info
	 * @return st440Opr1
	 */
	public String getSt440Opr1() {
		return this.st440Opr1;
	}
	
	/**
	 * Column Info
	 * @return st820Opr10
	 */
	public String getSt820Opr10() {
		return this.st820Opr10;
	}
	
	/**
	 * Column Info
	 * @return st1120Opr10
	 */
	public String getSt1120Opr10() {
		return this.st1120Opr10;
	}
	
	/**
	 * Column Info
	 * @return st620Opr9
	 */
	public String getSt620Opr9() {
		return this.st620Opr9;
	}
	
	/**
	 * Column Info
	 * @return st620Opr8
	 */
	public String getSt620Opr8() {
		return this.st620Opr8;
	}
	
	/**
	 * Column Info
	 * @return st620Opr7
	 */
	public String getSt620Opr7() {
		return this.st620Opr7;
	}
	
	/**
	 * Column Info
	 * @return st620Opr6
	 */
	public String getSt620Opr6() {
		return this.st620Opr6;
	}
	
	/**
	 * Column Info
	 * @return st620Opr1
	 */
	public String getSt620Opr1() {
		return this.st620Opr1;
	}
	
	/**
	 * Column Info
	 * @return st620Opr5
	 */
	public String getSt620Opr5() {
		return this.st620Opr5;
	}
	
	/**
	 * Column Info
	 * @return st620Opr4
	 */
	public String getSt620Opr4() {
		return this.st620Opr4;
	}
	
	/**
	 * Column Info
	 * @return st620Opr3
	 */
	public String getSt620Opr3() {
		return this.st620Opr3;
	}
	
	/**
	 * Column Info
	 * @return st620Opr2
	 */
	public String getSt620Opr2() {
		return this.st620Opr2;
	}
	
	/**
	 * Column Info
	 * @return st1240Opr9
	 */
	public String getSt1240Opr9() {
		return this.st1240Opr9;
	}
	
	/**
	 * Column Info
	 * @return st62hOpr1
	 */
	public String getSt62hOpr1() {
		return this.st62hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st1240Opr8
	 */
	public String getSt1240Opr8() {
		return this.st1240Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1240Opr7
	 */
	public String getSt1240Opr7() {
		return this.st1240Opr7;
	}
	
	/**
	 * Column Info
	 * @return st62hOpr3
	 */
	public String getSt62hOpr3() {
		return this.st62hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st1240Opr6
	 */
	public String getSt1240Opr6() {
		return this.st1240Opr6;
	}
	
	/**
	 * Column Info
	 * @return st62hOpr2
	 */
	public String getSt62hOpr2() {
		return this.st62hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st1240Opr5
	 */
	public String getSt1240Opr5() {
		return this.st1240Opr5;
	}
	
	/**
	 * Column Info
	 * @return st62hOpr5
	 */
	public String getSt62hOpr5() {
		return this.st62hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st1240Opr4
	 */
	public String getSt1240Opr4() {
		return this.st1240Opr4;
	}
	
	/**
	 * Column Info
	 * @return st62hOpr4
	 */
	public String getSt62hOpr4() {
		return this.st62hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st1240Opr3
	 */
	public String getSt1240Opr3() {
		return this.st1240Opr3;
	}
	
	/**
	 * Column Info
	 * @return st62hOpr6
	 */
	public String getSt62hOpr6() {
		return this.st62hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st62hOpr7
	 */
	public String getSt62hOpr7() {
		return this.st62hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st62hOpr8
	 */
	public String getSt62hOpr8() {
		return this.st62hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st62hOpr9
	 */
	public String getSt62hOpr9() {
		return this.st62hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st134hOpr10
	 */
	public String getSt134hOpr10() {
		return this.st134hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st620Opr10
	 */
	public String getSt620Opr10() {
		return this.st620Opr10;
	}
	
	/**
	 * Column Info
	 * @return st84hOpr10
	 */
	public String getSt84hOpr10() {
		return this.st84hOpr10;
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
	 * @return st145Opr9
	 */
	public String getSt145Opr9() {
		return this.st145Opr9;
	}
	
	/**
	 * Column Info
	 * @return st1245Opr10
	 */
	public String getSt1245Opr10() {
		return this.st1245Opr10;
	}
	
	/**
	 * Column Info
	 * @return st145Opr8
	 */
	public String getSt145Opr8() {
		return this.st145Opr8;
	}
	
	/**
	 * Column Info
	 * @return st154hOpr9
	 */
	public String getSt154hOpr9() {
		return this.st154hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st154hOpr8
	 */
	public String getSt154hOpr8() {
		return this.st154hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st1345Opr10
	 */
	public String getSt1345Opr10() {
		return this.st1345Opr10;
	}
	
	/**
	 * Column Info
	 * @return st145Opr3
	 */
	public String getSt145Opr3() {
		return this.st145Opr3;
	}
	
	/**
	 * Column Info
	 * @return st145Opr2
	 */
	public String getSt145Opr2() {
		return this.st145Opr2;
	}
	
	/**
	 * Column Info
	 * @return st145Opr1
	 */
	public String getSt145Opr1() {
		return this.st145Opr1;
	}
	
	/**
	 * Column Info
	 * @return st145Opr7
	 */
	public String getSt145Opr7() {
		return this.st145Opr7;
	}
	
	/**
	 * Column Info
	 * @return st145Opr6
	 */
	public String getSt145Opr6() {
		return this.st145Opr6;
	}
	
	/**
	 * Column Info
	 * @return st145Opr5
	 */
	public String getSt145Opr5() {
		return this.st145Opr5;
	}
	
	/**
	 * Column Info
	 * @return st44hOpr10
	 */
	public String getSt44hOpr10() {
		return this.st44hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st145Opr4
	 */
	public String getSt145Opr4() {
		return this.st145Opr4;
	}
	
	/**
	 * Column Info
	 * @return st54hOpr4
	 */
	public String getSt54hOpr4() {
		return this.st54hOpr4;
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
	 * @return st54hOpr3
	 */
	public String getSt54hOpr3() {
		return this.st54hOpr3;
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
	 * @return st54hOpr2
	 */
	public String getSt54hOpr2() {
		return this.st54hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st54hOpr1
	 */
	public String getSt54hOpr1() {
		return this.st54hOpr1;
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
	 * @return st54hOpr8
	 */
	public String getSt54hOpr8() {
		return this.st54hOpr8;
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
	 * @return st54hOpr7
	 */
	public String getSt54hOpr7() {
		return this.st54hOpr7;
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
	 * @return st54hOpr6
	 */
	public String getSt54hOpr6() {
		return this.st54hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st54hOpr5
	 */
	public String getSt54hOpr5() {
		return this.st54hOpr5;
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
	 * @return opr9
	 */
	public String getOpr9() {
		return this.opr9;
	}
	
	/**
	 * Column Info
	 * @return st54hOpr9
	 */
	public String getSt54hOpr9() {
		return this.st54hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st220Opr6
	 */
	public String getSt220Opr6() {
		return this.st220Opr6;
	}
	
	/**
	 * Column Info
	 * @return st220Opr7
	 */
	public String getSt220Opr7() {
		return this.st220Opr7;
	}
	
	/**
	 * Column Info
	 * @return st220Opr8
	 */
	public String getSt220Opr8() {
		return this.st220Opr8;
	}
	
	/**
	 * Column Info
	 * @return st220Opr9
	 */
	public String getSt220Opr9() {
		return this.st220Opr9;
	}
	
	/**
	 * Column Info
	 * @return st220Opr2
	 */
	public String getSt220Opr2() {
		return this.st220Opr2;
	}
	
	/**
	 * Column Info
	 * @return st220Opr3
	 */
	public String getSt220Opr3() {
		return this.st220Opr3;
	}
	
	/**
	 * Column Info
	 * @return st220Opr4
	 */
	public String getSt220Opr4() {
		return this.st220Opr4;
	}
	
	/**
	 * Column Info
	 * @return st220Opr5
	 */
	public String getSt220Opr5() {
		return this.st220Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1020Opr2
	 */
	public String getSt1020Opr2() {
		return this.st1020Opr2;
	}
	
	/**
	 * Column Info
	 * @return st1020Opr1
	 */
	public String getSt1020Opr1() {
		return this.st1020Opr1;
	}
	
	/**
	 * Column Info
	 * @return st220Opr1
	 */
	public String getSt220Opr1() {
		return this.st220Opr1;
	}
	
	/**
	 * Column Info
	 * @return st15
	 */
	public String getSt15() {
		return this.st15;
	}
	
	/**
	 * Column Info
	 * @return st14
	 */
	public String getSt14() {
		return this.st14;
	}
	
	/**
	 * Column Info
	 * @return st13
	 */
	public String getSt13() {
		return this.st13;
	}
	
	/**
	 * Column Info
	 * @return st12
	 */
	public String getSt12() {
		return this.st12;
	}
	
	/**
	 * Column Info
	 * @return st11
	 */
	public String getSt11() {
		return this.st11;
	}
	
	/**
	 * Column Info
	 * @return st10
	 */
	public String getSt10() {
		return this.st10;
	}
	
	/**
	 * Column Info
	 * @return st134hOpr1
	 */
	public String getSt134hOpr1() {
		return this.st134hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st134hOpr2
	 */
	public String getSt134hOpr2() {
		return this.st134hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st72hOpr5
	 */
	public String getSt72hOpr5() {
		return this.st72hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st134hOpr3
	 */
	public String getSt134hOpr3() {
		return this.st134hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st72hOpr6
	 */
	public String getSt72hOpr6() {
		return this.st72hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st134hOpr4
	 */
	public String getSt134hOpr4() {
		return this.st134hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st72hOpr7
	 */
	public String getSt72hOpr7() {
		return this.st72hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st134hOpr5
	 */
	public String getSt134hOpr5() {
		return this.st134hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st72hOpr8
	 */
	public String getSt72hOpr8() {
		return this.st72hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st134hOpr6
	 */
	public String getSt134hOpr6() {
		return this.st134hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st72hOpr9
	 */
	public String getSt72hOpr9() {
		return this.st72hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st134hOpr7
	 */
	public String getSt134hOpr7() {
		return this.st134hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st134hOpr8
	 */
	public String getSt134hOpr8() {
		return this.st134hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st134hOpr9
	 */
	public String getSt134hOpr9() {
		return this.st134hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st154hOpr1
	 */
	public String getSt154hOpr1() {
		return this.st154hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st154hOpr3
	 */
	public String getSt154hOpr3() {
		return this.st154hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st154hOpr2
	 */
	public String getSt154hOpr2() {
		return this.st154hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st1440Opr9
	 */
	public String getSt1440Opr9() {
		return this.st1440Opr9;
	}
	
	/**
	 * Column Info
	 * @return st1040Opr4
	 */
	public String getSt1040Opr4() {
		return this.st1040Opr4;
	}
	
	/**
	 * Column Info
	 * @return st72hOpr2
	 */
	public String getSt72hOpr2() {
		return this.st72hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st154hOpr5
	 */
	public String getSt154hOpr5() {
		return this.st154hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st154hOpr4
	 */
	public String getSt154hOpr4() {
		return this.st154hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st1040Opr3
	 */
	public String getSt1040Opr3() {
		return this.st1040Opr3;
	}
	
	/**
	 * Column Info
	 * @return st72hOpr1
	 */
	public String getSt72hOpr1() {
		return this.st72hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st72hOpr4
	 */
	public String getSt72hOpr4() {
		return this.st72hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st1040Opr2
	 */
	public String getSt1040Opr2() {
		return this.st1040Opr2;
	}
	
	/**
	 * Column Info
	 * @return st154hOpr7
	 */
	public String getSt154hOpr7() {
		return this.st154hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st72hOpr3
	 */
	public String getSt72hOpr3() {
		return this.st72hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st1040Opr1
	 */
	public String getSt1040Opr1() {
		return this.st1040Opr1;
	}
	
	/**
	 * Column Info
	 * @return st154hOpr6
	 */
	public String getSt154hOpr6() {
		return this.st154hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st1440Opr4
	 */
	public String getSt1440Opr4() {
		return this.st1440Opr4;
	}
	
	/**
	 * Column Info
	 * @return st1440Opr3
	 */
	public String getSt1440Opr3() {
		return this.st1440Opr3;
	}
	
	/**
	 * Column Info
	 * @return st1440Opr2
	 */
	public String getSt1440Opr2() {
		return this.st1440Opr2;
	}
	
	/**
	 * Column Info
	 * @return st1440Opr1
	 */
	public String getSt1440Opr1() {
		return this.st1440Opr1;
	}
	
	/**
	 * Column Info
	 * @return st1440Opr8
	 */
	public String getSt1440Opr8() {
		return this.st1440Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1440Opr7
	 */
	public String getSt1440Opr7() {
		return this.st1440Opr7;
	}
	
	/**
	 * Column Info
	 * @return st1440Opr6
	 */
	public String getSt1440Opr6() {
		return this.st1440Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1440Opr5
	 */
	public String getSt1440Opr5() {
		return this.st1440Opr5;
	}
	
	/**
	 * Column Info
	 * @return st102hOpr1
	 */
	public String getSt102hOpr1() {
		return this.st102hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st102hOpr2
	 */
	public String getSt102hOpr2() {
		return this.st102hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st102hOpr7
	 */
	public String getSt102hOpr7() {
		return this.st102hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st102hOpr8
	 */
	public String getSt102hOpr8() {
		return this.st102hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st102hOpr9
	 */
	public String getSt102hOpr9() {
		return this.st102hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st102hOpr3
	 */
	public String getSt102hOpr3() {
		return this.st102hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st102hOpr4
	 */
	public String getSt102hOpr4() {
		return this.st102hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st102hOpr5
	 */
	public String getSt102hOpr5() {
		return this.st102hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st102hOpr6
	 */
	public String getSt102hOpr6() {
		return this.st102hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st320Opr10
	 */
	public String getSt320Opr10() {
		return this.st320Opr10;
	}
	
	/**
	 * Column Info
	 * @return st1020Opr3
	 */
	public String getSt1020Opr3() {
		return this.st1020Opr3;
	}
	
	/**
	 * Column Info
	 * @return st1020Opr4
	 */
	public String getSt1020Opr4() {
		return this.st1020Opr4;
	}
	
	/**
	 * Column Info
	 * @return st1020Opr5
	 */
	public String getSt1020Opr5() {
		return this.st1020Opr5;
	}
	
	/**
	 * Column Info
	 * @return st1020Opr6
	 */
	public String getSt1020Opr6() {
		return this.st1020Opr6;
	}
	
	/**
	 * Column Info
	 * @return st1240Opr2
	 */
	public String getSt1240Opr2() {
		return this.st1240Opr2;
	}
	
	/**
	 * Column Info
	 * @return st1020Opr7
	 */
	public String getSt1020Opr7() {
		return this.st1020Opr7;
	}
	
	/**
	 * Column Info
	 * @return st1240Opr1
	 */
	public String getSt1240Opr1() {
		return this.st1240Opr1;
	}
	
	/**
	 * Column Info
	 * @return st1020Opr8
	 */
	public String getSt1020Opr8() {
		return this.st1020Opr8;
	}
	
	/**
	 * Column Info
	 * @return st1020Opr9
	 */
	public String getSt1020Opr9() {
		return this.st1020Opr9;
	}
	
	/**
	 * Column Info
	 * @return st1240Opr10
	 */
	public String getSt1240Opr10() {
		return this.st1240Opr10;
	}
	
	/**
	 * Column Info
	 * @return st14hOpr9
	 */
	public String getSt14hOpr9() {
		return this.st14hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st1140Opr10
	 */
	public String getSt1140Opr10() {
		return this.st1140Opr10;
	}
	
	/**
	 * Column Info
	 * @return st14hOpr5
	 */
	public String getSt14hOpr5() {
		return this.st14hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st14hOpr6
	 */
	public String getSt14hOpr6() {
		return this.st14hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st14hOpr7
	 */
	public String getSt14hOpr7() {
		return this.st14hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st14hOpr8
	 */
	public String getSt14hOpr8() {
		return this.st14hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st14hOpr1
	 */
	public String getSt14hOpr1() {
		return this.st14hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st14hOpr2
	 */
	public String getSt14hOpr2() {
		return this.st14hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st14hOpr3
	 */
	public String getSt14hOpr3() {
		return this.st14hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st14hOpr4
	 */
	public String getSt14hOpr4() {
		return this.st14hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st840Opr10
	 */
	public String getSt840Opr10() {
		return this.st840Opr10;
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
	 * @return st102hOpr10
	 */
	public String getSt102hOpr10() {
		return this.st102hOpr10;
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
	 * @return st42hOpr1
	 */
	public String getSt42hOpr1() {
		return this.st42hOpr1;
	}
	
	/**
	 * Column Info
	 * @return st1040Opr9
	 */
	public String getSt1040Opr9() {
		return this.st1040Opr9;
	}
	
	/**
	 * Column Info
	 * @return st42hOpr3
	 */
	public String getSt42hOpr3() {
		return this.st42hOpr3;
	}
	
	/**
	 * Column Info
	 * @return st42hOpr2
	 */
	public String getSt42hOpr2() {
		return this.st42hOpr2;
	}
	
	/**
	 * Column Info
	 * @return st42hOpr5
	 */
	public String getSt42hOpr5() {
		return this.st42hOpr5;
	}
	
	/**
	 * Column Info
	 * @return st1040Opr6
	 */
	public String getSt1040Opr6() {
		return this.st1040Opr6;
	}
	
	/**
	 * Column Info
	 * @return st220Opr10
	 */
	public String getSt220Opr10() {
		return this.st220Opr10;
	}
	
	/**
	 * Column Info
	 * @return st42hOpr4
	 */
	public String getSt42hOpr4() {
		return this.st42hOpr4;
	}
	
	/**
	 * Column Info
	 * @return st1040Opr5
	 */
	public String getSt1040Opr5() {
		return this.st1040Opr5;
	}
	
	/**
	 * Column Info
	 * @return st42hOpr7
	 */
	public String getSt42hOpr7() {
		return this.st42hOpr7;
	}
	
	/**
	 * Column Info
	 * @return st1040Opr8
	 */
	public String getSt1040Opr8() {
		return this.st1040Opr8;
	}
	
	/**
	 * Column Info
	 * @return st42hOpr6
	 */
	public String getSt42hOpr6() {
		return this.st42hOpr6;
	}
	
	/**
	 * Column Info
	 * @return st1040Opr7
	 */
	public String getSt1040Opr7() {
		return this.st1040Opr7;
	}
	
	/**
	 * Column Info
	 * @return st745Opr3
	 */
	public String getSt745Opr3() {
		return this.st745Opr3;
	}
	
	/**
	 * Column Info
	 * @return st745Opr2
	 */
	public String getSt745Opr2() {
		return this.st745Opr2;
	}
	
	/**
	 * Column Info
	 * @return st745Opr5
	 */
	public String getSt745Opr5() {
		return this.st745Opr5;
	}
	
	/**
	 * Column Info
	 * @return st745Opr4
	 */
	public String getSt745Opr4() {
		return this.st745Opr4;
	}
	
	/**
	 * Column Info
	 * @return st745Opr7
	 */
	public String getSt745Opr7() {
		return this.st745Opr7;
	}
	
	/**
	 * Column Info
	 * @return st745Opr6
	 */
	public String getSt745Opr6() {
		return this.st745Opr6;
	}
	
	/**
	 * Column Info
	 * @return st745Opr9
	 */
	public String getSt745Opr9() {
		return this.st745Opr9;
	}
	
	/**
	 * Column Info
	 * @return st745Opr8
	 */
	public String getSt745Opr8() {
		return this.st745Opr8;
	}
	
	/**
	 * Column Info
	 * @return st42hOpr8
	 */
	public String getSt42hOpr8() {
		return this.st42hOpr8;
	}
	
	/**
	 * Column Info
	 * @return st42hOpr9
	 */
	public String getSt42hOpr9() {
		return this.st42hOpr9;
	}
	
	/**
	 * Column Info
	 * @return st745Opr1
	 */
	public String getSt745Opr1() {
		return this.st745Opr1;
	}
	
	/**
	 * Column Info
	 * @return st114hOpr10
	 */
	public String getSt114hOpr10() {
		return this.st114hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st140Opr6
	 */
	public String getSt140Opr6() {
		return this.st140Opr6;
	}
	
	/**
	 * Column Info
	 * @return st140Opr5
	 */
	public String getSt140Opr5() {
		return this.st140Opr5;
	}
	
	/**
	 * Column Info
	 * @return st140Opr8
	 */
	public String getSt140Opr8() {
		return this.st140Opr8;
	}
	
	/**
	 * Column Info
	 * @return st140Opr7
	 */
	public String getSt140Opr7() {
		return this.st140Opr7;
	}
	
	/**
	 * Column Info
	 * @return st140Opr9
	 */
	public String getSt140Opr9() {
		return this.st140Opr9;
	}
	
	/**
	 * Column Info
	 * @return st142hOpr10
	 */
	public String getSt142hOpr10() {
		return this.st142hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st140Opr1
	 */
	public String getSt140Opr1() {
		return this.st140Opr1;
	}
	
	/**
	 * Column Info
	 * @return st140Opr2
	 */
	public String getSt140Opr2() {
		return this.st140Opr2;
	}
	
	/**
	 * Column Info
	 * @return st140Opr3
	 */
	public String getSt140Opr3() {
		return this.st140Opr3;
	}
	
	/**
	 * Column Info
	 * @return st54hOpr10
	 */
	public String getSt54hOpr10() {
		return this.st54hOpr10;
	}
	
	/**
	 * Column Info
	 * @return st140Opr4
	 */
	public String getSt140Opr4() {
		return this.st140Opr4;
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
	 * @param st720Opr10
	 */
	public void setSt720Opr10(String st720Opr10) {
		this.st720Opr10 = st720Opr10;
	}
	
	/**
	 * Column Info
	 * @param st740Opr7
	 */
	public void setSt740Opr7(String st740Opr7) {
		this.st740Opr7 = st740Opr7;
	}
	
	/**
	 * Column Info
	 * @param st1445Opr10
	 */
	public void setSt1445Opr10(String st1445Opr10) {
		this.st1445Opr10 = st1445Opr10;
	}
	
	/**
	 * Column Info
	 * @param st740Opr8
	 */
	public void setSt740Opr8(String st740Opr8) {
		this.st740Opr8 = st740Opr8;
	}
	
	/**
	 * Column Info
	 * @param st740Opr9
	 */
	public void setSt740Opr9(String st740Opr9) {
		this.st740Opr9 = st740Opr9;
	}
	
	/**
	 * Column Info
	 * @param st140Opr10
	 */
	public void setSt140Opr10(String st140Opr10) {
		this.st140Opr10 = st140Opr10;
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
	 * @param st740Opr1
	 */
	public void setSt740Opr1(String st740Opr1) {
		this.st740Opr1 = st740Opr1;
	}
	
	/**
	 * Column Info
	 * @param st740Opr2
	 */
	public void setSt740Opr2(String st740Opr2) {
		this.st740Opr2 = st740Opr2;
	}
	
	/**
	 * Column Info
	 * @param st740Opr3
	 */
	public void setSt740Opr3(String st740Opr3) {
		this.st740Opr3 = st740Opr3;
	}
	
	/**
	 * Column Info
	 * @param st740Opr4
	 */
	public void setSt740Opr4(String st740Opr4) {
		this.st740Opr4 = st740Opr4;
	}
	
	/**
	 * Column Info
	 * @param st740Opr5
	 */
	public void setSt740Opr5(String st740Opr5) {
		this.st740Opr5 = st740Opr5;
	}
	
	/**
	 * Column Info
	 * @param st740Opr6
	 */
	public void setSt740Opr6(String st740Opr6) {
		this.st740Opr6 = st740Opr6;
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
	 * @param st145Opr10
	 */
	public void setSt145Opr10(String st145Opr10) {
		this.st145Opr10 = st145Opr10;
	}
	
	/**
	 * Column Info
	 * @param st1545Opr10
	 */
	public void setSt1545Opr10(String st1545Opr10) {
		this.st1545Opr10 = st1545Opr10;
	}
	
	/**
	 * Column Info
	 * @param st640Opr10
	 */
	public void setSt640Opr10(String st640Opr10) {
		this.st640Opr10 = st640Opr10;
	}
	
	/**
	 * Column Info
	 * @param st1340Opr10
	 */
	public void setSt1340Opr10(String st1340Opr10) {
		this.st1340Opr10 = st1340Opr10;
	}
	
	/**
	 * Column Info
	 * @param st520Opr10
	 */
	public void setSt520Opr10(String st520Opr10) {
		this.st520Opr10 = st520Opr10;
	}
	
	/**
	 * Column Info
	 * @param st154hOpr10
	 */
	public void setSt154hOpr10(String st154hOpr10) {
		this.st154hOpr10 = st154hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st82hOpr10
	 */
	public void setSt82hOpr10(String st82hOpr10) {
		this.st82hOpr10 = st82hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st845Opr10
	 */
	public void setSt845Opr10(String st845Opr10) {
		this.st845Opr10 = st845Opr10;
	}
	
	/**
	 * Column Info
	 * @param st645Opr3
	 */
	public void setSt645Opr3(String st645Opr3) {
		this.st645Opr3 = st645Opr3;
	}
	
	/**
	 * Column Info
	 * @param st645Opr4
	 */
	public void setSt645Opr4(String st645Opr4) {
		this.st645Opr4 = st645Opr4;
	}
	
	/**
	 * Column Info
	 * @param st645Opr5
	 */
	public void setSt645Opr5(String st645Opr5) {
		this.st645Opr5 = st645Opr5;
	}
	
	/**
	 * Column Info
	 * @param st545Opr8
	 */
	public void setSt545Opr8(String st545Opr8) {
		this.st545Opr8 = st545Opr8;
	}
	
	/**
	 * Column Info
	 * @param st645Opr6
	 */
	public void setSt645Opr6(String st645Opr6) {
		this.st645Opr6 = st645Opr6;
	}
	
	/**
	 * Column Info
	 * @param st545Opr9
	 */
	public void setSt545Opr9(String st545Opr9) {
		this.st545Opr9 = st545Opr9;
	}
	
	/**
	 * Column Info
	 * @param st545Opr6
	 */
	public void setSt545Opr6(String st545Opr6) {
		this.st545Opr6 = st545Opr6;
	}
	
	/**
	 * Column Info
	 * @param st645Opr7
	 */
	public void setSt645Opr7(String st645Opr7) {
		this.st645Opr7 = st645Opr7;
	}
	
	/**
	 * Column Info
	 * @param st545Opr7
	 */
	public void setSt545Opr7(String st545Opr7) {
		this.st545Opr7 = st545Opr7;
	}
	
	/**
	 * Column Info
	 * @param st645Opr8
	 */
	public void setSt645Opr8(String st645Opr8) {
		this.st645Opr8 = st645Opr8;
	}
	
	/**
	 * Column Info
	 * @param st545Opr4
	 */
	public void setSt545Opr4(String st545Opr4) {
		this.st545Opr4 = st545Opr4;
	}
	
	/**
	 * Column Info
	 * @param st645Opr9
	 */
	public void setSt645Opr9(String st645Opr9) {
		this.st645Opr9 = st645Opr9;
	}
	
	/**
	 * Column Info
	 * @param st545Opr5
	 */
	public void setSt545Opr5(String st545Opr5) {
		this.st545Opr5 = st545Opr5;
	}
	
	/**
	 * Column Info
	 * @param st545Opr2
	 */
	public void setSt545Opr2(String st545Opr2) {
		this.st545Opr2 = st545Opr2;
	}
	
	/**
	 * Column Info
	 * @param st545Opr3
	 */
	public void setSt545Opr3(String st545Opr3) {
		this.st545Opr3 = st545Opr3;
	}
	
	/**
	 * Column Info
	 * @param st1145Opr10
	 */
	public void setSt1145Opr10(String st1145Opr10) {
		this.st1145Opr10 = st1145Opr10;
	}
	
	/**
	 * Column Info
	 * @param st545Opr1
	 */
	public void setSt545Opr1(String st545Opr1) {
		this.st545Opr1 = st545Opr1;
	}
	
	/**
	 * Column Info
	 * @param st645Opr1
	 */
	public void setSt645Opr1(String st645Opr1) {
		this.st645Opr1 = st645Opr1;
	}
	
	/**
	 * Column Info
	 * @param st645Opr2
	 */
	public void setSt645Opr2(String st645Opr2) {
		this.st645Opr2 = st645Opr2;
	}
	
	/**
	 * Column Info
	 * @param st114hOpr8
	 */
	public void setSt114hOpr8(String st114hOpr8) {
		this.st114hOpr8 = st114hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st114hOpr9
	 */
	public void setSt114hOpr9(String st114hOpr9) {
		this.st114hOpr9 = st114hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st114hOpr4
	 */
	public void setSt114hOpr4(String st114hOpr4) {
		this.st114hOpr4 = st114hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st114hOpr5
	 */
	public void setSt114hOpr5(String st114hOpr5) {
		this.st114hOpr5 = st114hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st114hOpr6
	 */
	public void setSt114hOpr6(String st114hOpr6) {
		this.st114hOpr6 = st114hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st114hOpr7
	 */
	public void setSt114hOpr7(String st114hOpr7) {
		this.st114hOpr7 = st114hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st114hOpr1
	 */
	public void setSt114hOpr1(String st114hOpr1) {
		this.st114hOpr1 = st114hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st114hOpr2
	 */
	public void setSt114hOpr2(String st114hOpr2) {
		this.st114hOpr2 = st114hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st114hOpr3
	 */
	public void setSt114hOpr3(String st114hOpr3) {
		this.st114hOpr3 = st114hOpr3;
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
	 * @param st745Opr10
	 */
	public void setSt745Opr10(String st745Opr10) {
		this.st745Opr10 = st745Opr10;
	}
	
	/**
	 * Column Info
	 * @param st1320Opr10
	 */
	public void setSt1320Opr10(String st1320Opr10) {
		this.st1320Opr10 = st1320Opr10;
	}
	
	/**
	 * Column Info
	 * @param st122hOpr1
	 */
	public void setSt122hOpr1(String st122hOpr1) {
		this.st122hOpr1 = st122hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st122hOpr2
	 */
	public void setSt122hOpr2(String st122hOpr2) {
		this.st122hOpr2 = st122hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st122hOpr3
	 */
	public void setSt122hOpr3(String st122hOpr3) {
		this.st122hOpr3 = st122hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st122hOpr4
	 */
	public void setSt122hOpr4(String st122hOpr4) {
		this.st122hOpr4 = st122hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st122hOpr5
	 */
	public void setSt122hOpr5(String st122hOpr5) {
		this.st122hOpr5 = st122hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st122hOpr6
	 */
	public void setSt122hOpr6(String st122hOpr6) {
		this.st122hOpr6 = st122hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st122hOpr7
	 */
	public void setSt122hOpr7(String st122hOpr7) {
		this.st122hOpr7 = st122hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st122hOpr8
	 */
	public void setSt122hOpr8(String st122hOpr8) {
		this.st122hOpr8 = st122hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st845Opr5
	 */
	public void setSt845Opr5(String st845Opr5) {
		this.st845Opr5 = st845Opr5;
	}
	
	/**
	 * Column Info
	 * @param st104hOpr6
	 */
	public void setSt104hOpr6(String st104hOpr6) {
		this.st104hOpr6 = st104hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st1445Opr9
	 */
	public void setSt1445Opr9(String st1445Opr9) {
		this.st1445Opr9 = st1445Opr9;
	}
	
	/**
	 * Column Info
	 * @param st104hOpr5
	 */
	public void setSt104hOpr5(String st104hOpr5) {
		this.st104hOpr5 = st104hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st845Opr6
	 */
	public void setSt845Opr6(String st845Opr6) {
		this.st845Opr6 = st845Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1445Opr8
	 */
	public void setSt1445Opr8(String st1445Opr8) {
		this.st1445Opr8 = st1445Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1145Opr1
	 */
	public void setSt1145Opr1(String st1145Opr1) {
		this.st1145Opr1 = st1145Opr1;
	}
	
	/**
	 * Column Info
	 * @param st845Opr7
	 */
	public void setSt845Opr7(String st845Opr7) {
		this.st845Opr7 = st845Opr7;
	}
	
	/**
	 * Column Info
	 * @param st104hOpr8
	 */
	public void setSt104hOpr8(String st104hOpr8) {
		this.st104hOpr8 = st104hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st1145Opr2
	 */
	public void setSt1145Opr2(String st1145Opr2) {
		this.st1145Opr2 = st1145Opr2;
	}
	
	/**
	 * Column Info
	 * @param st104hOpr7
	 */
	public void setSt104hOpr7(String st104hOpr7) {
		this.st104hOpr7 = st104hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st845Opr8
	 */
	public void setSt845Opr8(String st845Opr8) {
		this.st845Opr8 = st845Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1145Opr3
	 */
	public void setSt1145Opr3(String st1145Opr3) {
		this.st1145Opr3 = st1145Opr3;
	}
	
	/**
	 * Column Info
	 * @param st845Opr1
	 */
	public void setSt845Opr1(String st845Opr1) {
		this.st845Opr1 = st845Opr1;
	}
	
	/**
	 * Column Info
	 * @param st1445Opr5
	 */
	public void setSt1445Opr5(String st1445Opr5) {
		this.st1445Opr5 = st1445Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1445Opr4
	 */
	public void setSt1445Opr4(String st1445Opr4) {
		this.st1445Opr4 = st1445Opr4;
	}
	
	/**
	 * Column Info
	 * @param st1145Opr4
	 */
	public void setSt1145Opr4(String st1145Opr4) {
		this.st1145Opr4 = st1145Opr4;
	}
	
	/**
	 * Column Info
	 * @param st845Opr2
	 */
	public void setSt845Opr2(String st845Opr2) {
		this.st845Opr2 = st845Opr2;
	}
	
	/**
	 * Column Info
	 * @param st104hOpr9
	 */
	public void setSt104hOpr9(String st104hOpr9) {
		this.st104hOpr9 = st104hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st845Opr3
	 */
	public void setSt845Opr3(String st845Opr3) {
		this.st845Opr3 = st845Opr3;
	}
	
	/**
	 * Column Info
	 * @param st1145Opr5
	 */
	public void setSt1145Opr5(String st1145Opr5) {
		this.st1145Opr5 = st1145Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1445Opr7
	 */
	public void setSt1445Opr7(String st1445Opr7) {
		this.st1445Opr7 = st1445Opr7;
	}
	
	/**
	 * Column Info
	 * @param st845Opr4
	 */
	public void setSt845Opr4(String st845Opr4) {
		this.st845Opr4 = st845Opr4;
	}
	
	/**
	 * Column Info
	 * @param st1145Opr6
	 */
	public void setSt1145Opr6(String st1145Opr6) {
		this.st1145Opr6 = st1145Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1445Opr6
	 */
	public void setSt1445Opr6(String st1445Opr6) {
		this.st1445Opr6 = st1445Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1445Opr1
	 */
	public void setSt1445Opr1(String st1445Opr1) {
		this.st1445Opr1 = st1445Opr1;
	}
	
	/**
	 * Column Info
	 * @param st1145Opr7
	 */
	public void setSt1145Opr7(String st1145Opr7) {
		this.st1145Opr7 = st1145Opr7;
	}
	
	/**
	 * Column Info
	 * @param st1145Opr8
	 */
	public void setSt1145Opr8(String st1145Opr8) {
		this.st1145Opr8 = st1145Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1445Opr3
	 */
	public void setSt1445Opr3(String st1445Opr3) {
		this.st1445Opr3 = st1445Opr3;
	}
	
	/**
	 * Column Info
	 * @param st1145Opr9
	 */
	public void setSt1145Opr9(String st1145Opr9) {
		this.st1145Opr9 = st1145Opr9;
	}
	
	/**
	 * Column Info
	 * @param st1445Opr2
	 */
	public void setSt1445Opr2(String st1445Opr2) {
		this.st1445Opr2 = st1445Opr2;
	}
	
	/**
	 * Column Info
	 * @param st104hOpr2
	 */
	public void setSt104hOpr2(String st104hOpr2) {
		this.st104hOpr2 = st104hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st104hOpr1
	 */
	public void setSt104hOpr1(String st104hOpr1) {
		this.st104hOpr1 = st104hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st104hOpr4
	 */
	public void setSt104hOpr4(String st104hOpr4) {
		this.st104hOpr4 = st104hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st104hOpr3
	 */
	public void setSt104hOpr3(String st104hOpr3) {
		this.st104hOpr3 = st104hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st845Opr9
	 */
	public void setSt845Opr9(String st845Opr9) {
		this.st845Opr9 = st845Opr9;
	}
	
	/**
	 * Column Info
	 * @param st34hOpr2
	 */
	public void setSt34hOpr2(String st34hOpr2) {
		this.st34hOpr2 = st34hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st34hOpr1
	 */
	public void setSt34hOpr1(String st34hOpr1) {
		this.st34hOpr1 = st34hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st34hOpr4
	 */
	public void setSt34hOpr4(String st34hOpr4) {
		this.st34hOpr4 = st34hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st34hOpr3
	 */
	public void setSt34hOpr3(String st34hOpr3) {
		this.st34hOpr3 = st34hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st34hOpr6
	 */
	public void setSt34hOpr6(String st34hOpr6) {
		this.st34hOpr6 = st34hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st34hOpr5
	 */
	public void setSt34hOpr5(String st34hOpr5) {
		this.st34hOpr5 = st34hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st34hOpr8
	 */
	public void setSt34hOpr8(String st34hOpr8) {
		this.st34hOpr8 = st34hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st34hOpr7
	 */
	public void setSt34hOpr7(String st34hOpr7) {
		this.st34hOpr7 = st34hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st34hOpr9
	 */
	public void setSt34hOpr9(String st34hOpr9) {
		this.st34hOpr9 = st34hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st1345Opr3
	 */
	public void setSt1345Opr3(String st1345Opr3) {
		this.st1345Opr3 = st1345Opr3;
	}
	
	/**
	 * Column Info
	 * @param st1345Opr4
	 */
	public void setSt1345Opr4(String st1345Opr4) {
		this.st1345Opr4 = st1345Opr4;
	}
	
	/**
	 * Column Info
	 * @param st1345Opr1
	 */
	public void setSt1345Opr1(String st1345Opr1) {
		this.st1345Opr1 = st1345Opr1;
	}
	
	/**
	 * Column Info
	 * @param st1345Opr2
	 */
	public void setSt1345Opr2(String st1345Opr2) {
		this.st1345Opr2 = st1345Opr2;
	}
	
	/**
	 * Column Info
	 * @param st1345Opr9
	 */
	public void setSt1345Opr9(String st1345Opr9) {
		this.st1345Opr9 = st1345Opr9;
	}
	
	/**
	 * Column Info
	 * @param st1345Opr7
	 */
	public void setSt1345Opr7(String st1345Opr7) {
		this.st1345Opr7 = st1345Opr7;
	}
	
	/**
	 * Column Info
	 * @param st1345Opr8
	 */
	public void setSt1345Opr8(String st1345Opr8) {
		this.st1345Opr8 = st1345Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1345Opr5
	 */
	public void setSt1345Opr5(String st1345Opr5) {
		this.st1345Opr5 = st1345Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1345Opr6
	 */
	public void setSt1345Opr6(String st1345Opr6) {
		this.st1345Opr6 = st1345Opr6;
	}
	
	/**
	 * Column Info
	 * @param st12hOpr10
	 */
	public void setSt12hOpr10(String st12hOpr10) {
		this.st12hOpr10 = st12hOpr10;
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
	 * @param st545Opr10
	 */
	public void setSt545Opr10(String st545Opr10) {
		this.st545Opr10 = st545Opr10;
	}
	
	/**
	 * Column Info
	 * @param st152hOpr8
	 */
	public void setSt152hOpr8(String st152hOpr8) {
		this.st152hOpr8 = st152hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st152hOpr9
	 */
	public void setSt152hOpr9(String st152hOpr9) {
		this.st152hOpr9 = st152hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st152hOpr6
	 */
	public void setSt152hOpr6(String st152hOpr6) {
		this.st152hOpr6 = st152hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st152hOpr7
	 */
	public void setSt152hOpr7(String st152hOpr7) {
		this.st152hOpr7 = st152hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st1140Opr1
	 */
	public void setSt1140Opr1(String st1140Opr1) {
		this.st1140Opr1 = st1140Opr1;
	}
	
	/**
	 * Column Info
	 * @param st1140Opr2
	 */
	public void setSt1140Opr2(String st1140Opr2) {
		this.st1140Opr2 = st1140Opr2;
	}
	
	/**
	 * Column Info
	 * @param st1140Opr3
	 */
	public void setSt1140Opr3(String st1140Opr3) {
		this.st1140Opr3 = st1140Opr3;
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
	 * @param st1420Opr10
	 */
	public void setSt1420Opr10(String st1420Opr10) {
		this.st1420Opr10 = st1420Opr10;
	}
	
	/**
	 * Column Info
	 * @param st142hOpr8
	 */
	public void setSt142hOpr8(String st142hOpr8) {
		this.st142hOpr8 = st142hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st142hOpr7
	 */
	public void setSt142hOpr7(String st142hOpr7) {
		this.st142hOpr7 = st142hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st142hOpr9
	 */
	public void setSt142hOpr9(String st142hOpr9) {
		this.st142hOpr9 = st142hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st74hOpr9
	 */
	public void setSt74hOpr9(String st74hOpr9) {
		this.st74hOpr9 = st74hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st74hOpr7
	 */
	public void setSt74hOpr7(String st74hOpr7) {
		this.st74hOpr7 = st74hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st74hOpr8
	 */
	public void setSt74hOpr8(String st74hOpr8) {
		this.st74hOpr8 = st74hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st74hOpr6
	 */
	public void setSt74hOpr6(String st74hOpr6) {
		this.st74hOpr6 = st74hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st1220Opr9
	 */
	public void setSt1220Opr9(String st1220Opr9) {
		this.st1220Opr9 = st1220Opr9;
	}
	
	/**
	 * Column Info
	 * @param st74hOpr5
	 */
	public void setSt74hOpr5(String st74hOpr5) {
		this.st74hOpr5 = st74hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st74hOpr4
	 */
	public void setSt74hOpr4(String st74hOpr4) {
		this.st74hOpr4 = st74hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st74hOpr3
	 */
	public void setSt74hOpr3(String st74hOpr3) {
		this.st74hOpr3 = st74hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st74hOpr2
	 */
	public void setSt74hOpr2(String st74hOpr2) {
		this.st74hOpr2 = st74hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st74hOpr1
	 */
	public void setSt74hOpr1(String st74hOpr1) {
		this.st74hOpr1 = st74hOpr1;
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
	 * @param st1220Opr1
	 */
	public void setSt1220Opr1(String st1220Opr1) {
		this.st1220Opr1 = st1220Opr1;
	}
	
	/**
	 * Column Info
	 * @param st1220Opr2
	 */
	public void setSt1220Opr2(String st1220Opr2) {
		this.st1220Opr2 = st1220Opr2;
	}
	
	/**
	 * Column Info
	 * @param st1220Opr3
	 */
	public void setSt1220Opr3(String st1220Opr3) {
		this.st1220Opr3 = st1220Opr3;
	}
	
	/**
	 * Column Info
	 * @param st1220Opr4
	 */
	public void setSt1220Opr4(String st1220Opr4) {
		this.st1220Opr4 = st1220Opr4;
	}
	
	/**
	 * Column Info
	 * @param st1220Opr5
	 */
	public void setSt1220Opr5(String st1220Opr5) {
		this.st1220Opr5 = st1220Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1220Opr6
	 */
	public void setSt1220Opr6(String st1220Opr6) {
		this.st1220Opr6 = st1220Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1220Opr7
	 */
	public void setSt1220Opr7(String st1220Opr7) {
		this.st1220Opr7 = st1220Opr7;
	}
	
	/**
	 * Column Info
	 * @param st124hOpr10
	 */
	public void setSt124hOpr10(String st124hOpr10) {
		this.st124hOpr10 = st124hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st1220Opr8
	 */
	public void setSt1220Opr8(String st1220Opr8) {
		this.st1220Opr8 = st1220Opr8;
	}
	
	/**
	 * Column Info
	 * @param st82hOpr7
	 */
	public void setSt82hOpr7(String st82hOpr7) {
		this.st82hOpr7 = st82hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st82hOpr6
	 */
	public void setSt82hOpr6(String st82hOpr6) {
		this.st82hOpr6 = st82hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st82hOpr5
	 */
	public void setSt82hOpr5(String st82hOpr5) {
		this.st82hOpr5 = st82hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st82hOpr4
	 */
	public void setSt82hOpr4(String st82hOpr4) {
		this.st82hOpr4 = st82hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st82hOpr9
	 */
	public void setSt82hOpr9(String st82hOpr9) {
		this.st82hOpr9 = st82hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st82hOpr8
	 */
	public void setSt82hOpr8(String st82hOpr8) {
		this.st82hOpr8 = st82hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st82hOpr2
	 */
	public void setSt82hOpr2(String st82hOpr2) {
		this.st82hOpr2 = st82hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st82hOpr3
	 */
	public void setSt82hOpr3(String st82hOpr3) {
		this.st82hOpr3 = st82hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st82hOpr1
	 */
	public void setSt82hOpr1(String st82hOpr1) {
		this.st82hOpr1 = st82hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st92hOpr3
	 */
	public void setSt92hOpr3(String st92hOpr3) {
		this.st92hOpr3 = st92hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st92hOpr4
	 */
	public void setSt92hOpr4(String st92hOpr4) {
		this.st92hOpr4 = st92hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st92hOpr5
	 */
	public void setSt92hOpr5(String st92hOpr5) {
		this.st92hOpr5 = st92hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st92hOpr6
	 */
	public void setSt92hOpr6(String st92hOpr6) {
		this.st92hOpr6 = st92hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st92hOpr7
	 */
	public void setSt92hOpr7(String st92hOpr7) {
		this.st92hOpr7 = st92hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st92hOpr8
	 */
	public void setSt92hOpr8(String st92hOpr8) {
		this.st92hOpr8 = st92hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st92hOpr9
	 */
	public void setSt92hOpr9(String st92hOpr9) {
		this.st92hOpr9 = st92hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st1020Opr10
	 */
	public void setSt1020Opr10(String st1020Opr10) {
		this.st1020Opr10 = st1020Opr10;
	}
	
	/**
	 * Column Info
	 * @param st1140Opr9
	 */
	public void setSt1140Opr9(String st1140Opr9) {
		this.st1140Opr9 = st1140Opr9;
	}
	
	/**
	 * Column Info
	 * @param st1140Opr8
	 */
	public void setSt1140Opr8(String st1140Opr8) {
		this.st1140Opr8 = st1140Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1140Opr7
	 */
	public void setSt1140Opr7(String st1140Opr7) {
		this.st1140Opr7 = st1140Opr7;
	}
	
	/**
	 * Column Info
	 * @param st1140Opr6
	 */
	public void setSt1140Opr6(String st1140Opr6) {
		this.st1140Opr6 = st1140Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1140Opr5
	 */
	public void setSt1140Opr5(String st1140Opr5) {
		this.st1140Opr5 = st1140Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1140Opr4
	 */
	public void setSt1140Opr4(String st1140Opr4) {
		this.st1140Opr4 = st1140Opr4;
	}
	
	/**
	 * Column Info
	 * @param st245Opr3
	 */
	public void setSt245Opr3(String st245Opr3) {
		this.st245Opr3 = st245Opr3;
	}
	
	/**
	 * Column Info
	 * @param st245Opr4
	 */
	public void setSt245Opr4(String st245Opr4) {
		this.st245Opr4 = st245Opr4;
	}
	
	/**
	 * Column Info
	 * @param st740Opr10
	 */
	public void setSt740Opr10(String st740Opr10) {
		this.st740Opr10 = st740Opr10;
	}
	
	/**
	 * Column Info
	 * @param st245Opr5
	 */
	public void setSt245Opr5(String st245Opr5) {
		this.st245Opr5 = st245Opr5;
	}
	
	/**
	 * Column Info
	 * @param st152hOpr1
	 */
	public void setSt152hOpr1(String st152hOpr1) {
		this.st152hOpr1 = st152hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st245Opr6
	 */
	public void setSt245Opr6(String st245Opr6) {
		this.st245Opr6 = st245Opr6;
	}
	
	/**
	 * Column Info
	 * @param st152hOpr3
	 */
	public void setSt152hOpr3(String st152hOpr3) {
		this.st152hOpr3 = st152hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st152hOpr2
	 */
	public void setSt152hOpr2(String st152hOpr2) {
		this.st152hOpr2 = st152hOpr2;
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
	 * @param st245Opr1
	 */
	public void setSt245Opr1(String st245Opr1) {
		this.st245Opr1 = st245Opr1;
	}
	
	/**
	 * Column Info
	 * @param st152hOpr5
	 */
	public void setSt152hOpr5(String st152hOpr5) {
		this.st152hOpr5 = st152hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st152hOpr4
	 */
	public void setSt152hOpr4(String st152hOpr4) {
		this.st152hOpr4 = st152hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st245Opr2
	 */
	public void setSt245Opr2(String st245Opr2) {
		this.st245Opr2 = st245Opr2;
	}
	
	/**
	 * Column Info
	 * @param st245Opr7
	 */
	public void setSt245Opr7(String st245Opr7) {
		this.st245Opr7 = st245Opr7;
	}
	
	/**
	 * Column Info
	 * @param st920Opr10
	 */
	public void setSt920Opr10(String st920Opr10) {
		this.st920Opr10 = st920Opr10;
	}
	
	/**
	 * Column Info
	 * @param st245Opr8
	 */
	public void setSt245Opr8(String st245Opr8) {
		this.st245Opr8 = st245Opr8;
	}
	
	/**
	 * Column Info
	 * @param st92hOpr2
	 */
	public void setSt92hOpr2(String st92hOpr2) {
		this.st92hOpr2 = st92hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st245Opr9
	 */
	public void setSt245Opr9(String st245Opr9) {
		this.st245Opr9 = st245Opr9;
	}
	
	/**
	 * Column Info
	 * @param st92hOpr1
	 */
	public void setSt92hOpr1(String st92hOpr1) {
		this.st92hOpr1 = st92hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st52hOpr2
	 */
	public void setSt52hOpr2(String st52hOpr2) {
		this.st52hOpr2 = st52hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st52hOpr1
	 */
	public void setSt52hOpr1(String st52hOpr1) {
		this.st52hOpr1 = st52hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st52hOpr6
	 */
	public void setSt52hOpr6(String st52hOpr6) {
		this.st52hOpr6 = st52hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st52hOpr5
	 */
	public void setSt52hOpr5(String st52hOpr5) {
		this.st52hOpr5 = st52hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st52hOpr4
	 */
	public void setSt52hOpr4(String st52hOpr4) {
		this.st52hOpr4 = st52hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st52hOpr3
	 */
	public void setSt52hOpr3(String st52hOpr3) {
		this.st52hOpr3 = st52hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st144hOpr10
	 */
	public void setSt144hOpr10(String st144hOpr10) {
		this.st144hOpr10 = st144hOpr10;
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
	 * @param st52hOpr9
	 */
	public void setSt52hOpr9(String st52hOpr9) {
		this.st52hOpr9 = st52hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st52hOpr7
	 */
	public void setSt52hOpr7(String st52hOpr7) {
		this.st52hOpr7 = st52hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st52hOpr8
	 */
	public void setSt52hOpr8(String st52hOpr8) {
		this.st52hOpr8 = st52hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st122hOpr9
	 */
	public void setSt122hOpr9(String st122hOpr9) {
		this.st122hOpr9 = st122hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st124hOpr4
	 */
	public void setSt124hOpr4(String st124hOpr4) {
		this.st124hOpr4 = st124hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st940Opr2
	 */
	public void setSt940Opr2(String st940Opr2) {
		this.st940Opr2 = st940Opr2;
	}
	
	/**
	 * Column Info
	 * @param st124hOpr3
	 */
	public void setSt124hOpr3(String st124hOpr3) {
		this.st124hOpr3 = st124hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st940Opr1
	 */
	public void setSt940Opr1(String st940Opr1) {
		this.st940Opr1 = st940Opr1;
	}
	
	/**
	 * Column Info
	 * @param st940Opr4
	 */
	public void setSt940Opr4(String st940Opr4) {
		this.st940Opr4 = st940Opr4;
	}
	
	/**
	 * Column Info
	 * @param st124hOpr6
	 */
	public void setSt124hOpr6(String st124hOpr6) {
		this.st124hOpr6 = st124hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st940Opr3
	 */
	public void setSt940Opr3(String st940Opr3) {
		this.st940Opr3 = st940Opr3;
	}
	
	/**
	 * Column Info
	 * @param st124hOpr5
	 */
	public void setSt124hOpr5(String st124hOpr5) {
		this.st124hOpr5 = st124hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st124hOpr8
	 */
	public void setSt124hOpr8(String st124hOpr8) {
		this.st124hOpr8 = st124hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st124hOpr7
	 */
	public void setSt124hOpr7(String st124hOpr7) {
		this.st124hOpr7 = st124hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st245Opr10
	 */
	public void setSt245Opr10(String st245Opr10) {
		this.st245Opr10 = st245Opr10;
	}
	
	/**
	 * Column Info
	 * @param st124hOpr9
	 */
	public void setSt124hOpr9(String st124hOpr9) {
		this.st124hOpr9 = st124hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st940Opr9
	 */
	public void setSt940Opr9(String st940Opr9) {
		this.st940Opr9 = st940Opr9;
	}
	
	/**
	 * Column Info
	 * @param st940Opr6
	 */
	public void setSt940Opr6(String st940Opr6) {
		this.st940Opr6 = st940Opr6;
	}
	
	/**
	 * Column Info
	 * @param st940Opr5
	 */
	public void setSt940Opr5(String st940Opr5) {
		this.st940Opr5 = st940Opr5;
	}
	
	/**
	 * Column Info
	 * @param st124hOpr2
	 */
	public void setSt124hOpr2(String st124hOpr2) {
		this.st124hOpr2 = st124hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st940Opr8
	 */
	public void setSt940Opr8(String st940Opr8) {
		this.st940Opr8 = st940Opr8;
	}
	
	/**
	 * Column Info
	 * @param st32hOpr10
	 */
	public void setSt32hOpr10(String st32hOpr10) {
		this.st32hOpr10 = st32hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st124hOpr1
	 */
	public void setSt124hOpr1(String st124hOpr1) {
		this.st124hOpr1 = st124hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st940Opr7
	 */
	public void setSt940Opr7(String st940Opr7) {
		this.st940Opr7 = st940Opr7;
	}
	
	/**
	 * Column Info
	 * @param st142hOpr6
	 */
	public void setSt142hOpr6(String st142hOpr6) {
		this.st142hOpr6 = st142hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st142hOpr5
	 */
	public void setSt142hOpr5(String st142hOpr5) {
		this.st142hOpr5 = st142hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st142hOpr4
	 */
	public void setSt142hOpr4(String st142hOpr4) {
		this.st142hOpr4 = st142hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st142hOpr3
	 */
	public void setSt142hOpr3(String st142hOpr3) {
		this.st142hOpr3 = st142hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st142hOpr2
	 */
	public void setSt142hOpr2(String st142hOpr2) {
		this.st142hOpr2 = st142hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st142hOpr1
	 */
	public void setSt142hOpr1(String st142hOpr1) {
		this.st142hOpr1 = st142hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st94hOpr1
	 */
	public void setSt94hOpr1(String st94hOpr1) {
		this.st94hOpr1 = st94hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st94hOpr2
	 */
	public void setSt94hOpr2(String st94hOpr2) {
		this.st94hOpr2 = st94hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st94hOpr3
	 */
	public void setSt94hOpr3(String st94hOpr3) {
		this.st94hOpr3 = st94hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st94hOpr4
	 */
	public void setSt94hOpr4(String st94hOpr4) {
		this.st94hOpr4 = st94hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st1520Opr1
	 */
	public void setSt1520Opr1(String st1520Opr1) {
		this.st1520Opr1 = st1520Opr1;
	}
	
	/**
	 * Column Info
	 * @param st94hOpr9
	 */
	public void setSt94hOpr9(String st94hOpr9) {
		this.st94hOpr9 = st94hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st112hOpr1
	 */
	public void setSt112hOpr1(String st112hOpr1) {
		this.st112hOpr1 = st112hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st1520Opr5
	 */
	public void setSt1520Opr5(String st1520Opr5) {
		this.st1520Opr5 = st1520Opr5;
	}
	
	/**
	 * Column Info
	 * @param st94hOpr6
	 */
	public void setSt94hOpr6(String st94hOpr6) {
		this.st94hOpr6 = st94hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st1520Opr4
	 */
	public void setSt1520Opr4(String st1520Opr4) {
		this.st1520Opr4 = st1520Opr4;
	}
	
	/**
	 * Column Info
	 * @param st94hOpr5
	 */
	public void setSt94hOpr5(String st94hOpr5) {
		this.st94hOpr5 = st94hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st1520Opr3
	 */
	public void setSt1520Opr3(String st1520Opr3) {
		this.st1520Opr3 = st1520Opr3;
	}
	
	/**
	 * Column Info
	 * @param st94hOpr8
	 */
	public void setSt94hOpr8(String st94hOpr8) {
		this.st94hOpr8 = st94hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st1520Opr2
	 */
	public void setSt1520Opr2(String st1520Opr2) {
		this.st1520Opr2 = st1520Opr2;
	}
	
	/**
	 * Column Info
	 * @param st94hOpr7
	 */
	public void setSt94hOpr7(String st94hOpr7) {
		this.st94hOpr7 = st94hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st112hOpr6
	 */
	public void setSt112hOpr6(String st112hOpr6) {
		this.st112hOpr6 = st112hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st1520Opr9
	 */
	public void setSt1520Opr9(String st1520Opr9) {
		this.st1520Opr9 = st1520Opr9;
	}
	
	/**
	 * Column Info
	 * @param st112hOpr7
	 */
	public void setSt112hOpr7(String st112hOpr7) {
		this.st112hOpr7 = st112hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st1520Opr8
	 */
	public void setSt1520Opr8(String st1520Opr8) {
		this.st1520Opr8 = st1520Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1520Opr7
	 */
	public void setSt1520Opr7(String st1520Opr7) {
		this.st1520Opr7 = st1520Opr7;
	}
	
	/**
	 * Column Info
	 * @param st112hOpr8
	 */
	public void setSt112hOpr8(String st112hOpr8) {
		this.st112hOpr8 = st112hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st1520Opr6
	 */
	public void setSt1520Opr6(String st1520Opr6) {
		this.st1520Opr6 = st1520Opr6;
	}
	
	/**
	 * Column Info
	 * @param st112hOpr9
	 */
	public void setSt112hOpr9(String st112hOpr9) {
		this.st112hOpr9 = st112hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st112hOpr2
	 */
	public void setSt112hOpr2(String st112hOpr2) {
		this.st112hOpr2 = st112hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st112hOpr3
	 */
	public void setSt112hOpr3(String st112hOpr3) {
		this.st112hOpr3 = st112hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st340Opr10
	 */
	public void setSt340Opr10(String st340Opr10) {
		this.st340Opr10 = st340Opr10;
	}
	
	/**
	 * Column Info
	 * @param st112hOpr4
	 */
	public void setSt112hOpr4(String st112hOpr4) {
		this.st112hOpr4 = st112hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st112hOpr5
	 */
	public void setSt112hOpr5(String st112hOpr5) {
		this.st112hOpr5 = st112hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st1120Opr7
	 */
	public void setSt1120Opr7(String st1120Opr7) {
		this.st1120Opr7 = st1120Opr7;
	}
	
	/**
	 * Column Info
	 * @param st1120Opr6
	 */
	public void setSt1120Opr6(String st1120Opr6) {
		this.st1120Opr6 = st1120Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1120Opr9
	 */
	public void setSt1120Opr9(String st1120Opr9) {
		this.st1120Opr9 = st1120Opr9;
	}
	
	/**
	 * Column Info
	 * @param st1120Opr8
	 */
	public void setSt1120Opr8(String st1120Opr8) {
		this.st1120Opr8 = st1120Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1120Opr3
	 */
	public void setSt1120Opr3(String st1120Opr3) {
		this.st1120Opr3 = st1120Opr3;
	}
	
	/**
	 * Column Info
	 * @param st1120Opr2
	 */
	public void setSt1120Opr2(String st1120Opr2) {
		this.st1120Opr2 = st1120Opr2;
	}
	
	/**
	 * Column Info
	 * @param st1120Opr5
	 */
	public void setSt1120Opr5(String st1120Opr5) {
		this.st1120Opr5 = st1120Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1120Opr4
	 */
	public void setSt1120Opr4(String st1120Opr4) {
		this.st1120Opr4 = st1120Opr4;
	}
	
	/**
	 * Column Info
	 * @param st132hOpr4
	 */
	public void setSt132hOpr4(String st132hOpr4) {
		this.st132hOpr4 = st132hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st132hOpr5
	 */
	public void setSt132hOpr5(String st132hOpr5) {
		this.st132hOpr5 = st132hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st132hOpr6
	 */
	public void setSt132hOpr6(String st132hOpr6) {
		this.st132hOpr6 = st132hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st132hOpr7
	 */
	public void setSt132hOpr7(String st132hOpr7) {
		this.st132hOpr7 = st132hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st132hOpr1
	 */
	public void setSt132hOpr1(String st132hOpr1) {
		this.st132hOpr1 = st132hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st132hOpr2
	 */
	public void setSt132hOpr2(String st132hOpr2) {
		this.st132hOpr2 = st132hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st132hOpr3
	 */
	public void setSt132hOpr3(String st132hOpr3) {
		this.st132hOpr3 = st132hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st24hOpr10
	 */
	public void setSt24hOpr10(String st24hOpr10) {
		this.st24hOpr10 = st24hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st345Opr10
	 */
	public void setSt345Opr10(String st345Opr10) {
		this.st345Opr10 = st345Opr10;
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
	 * @param qty3
	 */
	public void setQty3(String qty3) {
		this.qty3 = qty3;
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
	 * @param qty5
	 */
	public void setQty5(String qty5) {
		this.qty5 = qty5;
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
	 * @param st720Opr7
	 */
	public void setSt720Opr7(String st720Opr7) {
		this.st720Opr7 = st720Opr7;
	}
	
	/**
	 * Column Info
	 * @param st720Opr8
	 */
	public void setSt720Opr8(String st720Opr8) {
		this.st720Opr8 = st720Opr8;
	}
	
	/**
	 * Column Info
	 * @param st720Opr5
	 */
	public void setSt720Opr5(String st720Opr5) {
		this.st720Opr5 = st720Opr5;
	}
	
	/**
	 * Column Info
	 * @param st720Opr6
	 */
	public void setSt720Opr6(String st720Opr6) {
		this.st720Opr6 = st720Opr6;
	}
	
	/**
	 * Column Info
	 * @param st720Opr9
	 */
	public void setSt720Opr9(String st720Opr9) {
		this.st720Opr9 = st720Opr9;
	}
	
	/**
	 * Column Info
	 * @param st34hOpr10
	 */
	public void setSt34hOpr10(String st34hOpr10) {
		this.st34hOpr10 = st34hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st62hOpr10
	 */
	public void setSt62hOpr10(String st62hOpr10) {
		this.st62hOpr10 = st62hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st1440Opr10
	 */
	public void setSt1440Opr10(String st1440Opr10) {
		this.st1440Opr10 = st1440Opr10;
	}
	
	/**
	 * Column Info
	 * @param st720Opr3
	 */
	public void setSt720Opr3(String st720Opr3) {
		this.st720Opr3 = st720Opr3;
	}
	
	/**
	 * Column Info
	 * @param st720Opr4
	 */
	public void setSt720Opr4(String st720Opr4) {
		this.st720Opr4 = st720Opr4;
	}
	
	/**
	 * Column Info
	 * @param st720Opr1
	 */
	public void setSt720Opr1(String st720Opr1) {
		this.st720Opr1 = st720Opr1;
	}
	
	/**
	 * Column Info
	 * @param st720Opr2
	 */
	public void setSt720Opr2(String st720Opr2) {
		this.st720Opr2 = st720Opr2;
	}
	
	/**
	 * Column Info
	 * @param st1045Opr10
	 */
	public void setSt1045Opr10(String st1045Opr10) {
		this.st1045Opr10 = st1045Opr10;
	}
	
	/**
	 * Column Info
	 * @param st1540Opr1
	 */
	public void setSt1540Opr1(String st1540Opr1) {
		this.st1540Opr1 = st1540Opr1;
	}
	
	/**
	 * Column Info
	 * @param st1540Opr2
	 */
	public void setSt1540Opr2(String st1540Opr2) {
		this.st1540Opr2 = st1540Opr2;
	}
	
	/**
	 * Column Info
	 * @param st1540Opr3
	 */
	public void setSt1540Opr3(String st1540Opr3) {
		this.st1540Opr3 = st1540Opr3;
	}
	
	/**
	 * Column Info
	 * @param st1540Opr4
	 */
	public void setSt1540Opr4(String st1540Opr4) {
		this.st1540Opr4 = st1540Opr4;
	}
	
	/**
	 * Column Info
	 * @param st1540Opr5
	 */
	public void setSt1540Opr5(String st1540Opr5) {
		this.st1540Opr5 = st1540Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1540Opr6
	 */
	public void setSt1540Opr6(String st1540Opr6) {
		this.st1540Opr6 = st1540Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1540Opr7
	 */
	public void setSt1540Opr7(String st1540Opr7) {
		this.st1540Opr7 = st1540Opr7;
	}
	
	/**
	 * Column Info
	 * @param st1540Opr8
	 */
	public void setSt1540Opr8(String st1540Opr8) {
		this.st1540Opr8 = st1540Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1540Opr9
	 */
	public void setSt1540Opr9(String st1540Opr9) {
		this.st1540Opr9 = st1540Opr9;
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
	 * @param st1545Opr1
	 */
	public void setSt1545Opr1(String st1545Opr1) {
		this.st1545Opr1 = st1545Opr1;
	}
	
	/**
	 * Column Info
	 * @param st1545Opr2
	 */
	public void setSt1545Opr2(String st1545Opr2) {
		this.st1545Opr2 = st1545Opr2;
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
	 * @param st420Opr10
	 */
	public void setSt420Opr10(String st420Opr10) {
		this.st420Opr10 = st420Opr10;
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
	 * @param st1545Opr5
	 */
	public void setSt1545Opr5(String st1545Opr5) {
		this.st1545Opr5 = st1545Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1545Opr6
	 */
	public void setSt1545Opr6(String st1545Opr6) {
		this.st1545Opr6 = st1545Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1545Opr3
	 */
	public void setSt1545Opr3(String st1545Opr3) {
		this.st1545Opr3 = st1545Opr3;
	}
	
	/**
	 * Column Info
	 * @param st1545Opr4
	 */
	public void setSt1545Opr4(String st1545Opr4) {
		this.st1545Opr4 = st1545Opr4;
	}
	
	/**
	 * Column Info
	 * @param st1545Opr9
	 */
	public void setSt1545Opr9(String st1545Opr9) {
		this.st1545Opr9 = st1545Opr9;
	}
	
	/**
	 * Column Info
	 * @param st1545Opr7
	 */
	public void setSt1545Opr7(String st1545Opr7) {
		this.st1545Opr7 = st1545Opr7;
	}
	
	/**
	 * Column Info
	 * @param st1545Opr8
	 */
	public void setSt1545Opr8(String st1545Opr8) {
		this.st1545Opr8 = st1545Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1320Opr1
	 */
	public void setSt1320Opr1(String st1320Opr1) {
		this.st1320Opr1 = st1320Opr1;
	}
	
	/**
	 * Column Info
	 * @param st1320Opr3
	 */
	public void setSt1320Opr3(String st1320Opr3) {
		this.st1320Opr3 = st1320Opr3;
	}
	
	/**
	 * Column Info
	 * @param st132hOpr9
	 */
	public void setSt132hOpr9(String st132hOpr9) {
		this.st132hOpr9 = st132hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st1320Opr2
	 */
	public void setSt1320Opr2(String st1320Opr2) {
		this.st1320Opr2 = st1320Opr2;
	}
	
	/**
	 * Column Info
	 * @param st132hOpr8
	 */
	public void setSt132hOpr8(String st132hOpr8) {
		this.st132hOpr8 = st132hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st1320Opr5
	 */
	public void setSt1320Opr5(String st1320Opr5) {
		this.st1320Opr5 = st1320Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1320Opr4
	 */
	public void setSt1320Opr4(String st1320Opr4) {
		this.st1320Opr4 = st1320Opr4;
	}
	
	/**
	 * Column Info
	 * @param st1320Opr7
	 */
	public void setSt1320Opr7(String st1320Opr7) {
		this.st1320Opr7 = st1320Opr7;
	}
	
	/**
	 * Column Info
	 * @param st1320Opr6
	 */
	public void setSt1320Opr6(String st1320Opr6) {
		this.st1320Opr6 = st1320Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1320Opr9
	 */
	public void setSt1320Opr9(String st1320Opr9) {
		this.st1320Opr9 = st1320Opr9;
	}
	
	/**
	 * Column Info
	 * @param st1320Opr8
	 */
	public void setSt1320Opr8(String st1320Opr8) {
		this.st1320Opr8 = st1320Opr8;
	}
	
	/**
	 * Column Info
	 * @param st340Opr1
	 */
	public void setSt340Opr1(String st340Opr1) {
		this.st340Opr1 = st340Opr1;
	}
	
	/**
	 * Column Info
	 * @param st340Opr2
	 */
	public void setSt340Opr2(String st340Opr2) {
		this.st340Opr2 = st340Opr2;
	}
	
	/**
	 * Column Info
	 * @param st340Opr9
	 */
	public void setSt340Opr9(String st340Opr9) {
		this.st340Opr9 = st340Opr9;
	}
	
	/**
	 * Column Info
	 * @param st340Opr8
	 */
	public void setSt340Opr8(String st340Opr8) {
		this.st340Opr8 = st340Opr8;
	}
	
	/**
	 * Column Info
	 * @param st340Opr7
	 */
	public void setSt340Opr7(String st340Opr7) {
		this.st340Opr7 = st340Opr7;
	}
	
	/**
	 * Column Info
	 * @param st340Opr6
	 */
	public void setSt340Opr6(String st340Opr6) {
		this.st340Opr6 = st340Opr6;
	}
	
	/**
	 * Column Info
	 * @param st340Opr5
	 */
	public void setSt340Opr5(String st340Opr5) {
		this.st340Opr5 = st340Opr5;
	}
	
	/**
	 * Column Info
	 * @param st340Opr4
	 */
	public void setSt340Opr4(String st340Opr4) {
		this.st340Opr4 = st340Opr4;
	}
	
	/**
	 * Column Info
	 * @param st340Opr3
	 */
	public void setSt340Opr3(String st340Opr3) {
		this.st340Opr3 = st340Opr3;
	}
	
	/**
	 * Column Info
	 * @param allFlg
	 */
	public void setAllFlg(String allFlg) {
		this.allFlg = allFlg;
	}
	
	/**
	 * Column Info
	 * @param st445Opr10
	 */
	public void setSt445Opr10(String st445Opr10) {
		this.st445Opr10 = st445Opr10;
	}
	
	/**
	 * Column Info
	 * @param st120Opr1
	 */
	public void setSt120Opr1(String st120Opr1) {
		this.st120Opr1 = st120Opr1;
	}
	
	/**
	 * Column Info
	 * @param st120Opr2
	 */
	public void setSt120Opr2(String st120Opr2) {
		this.st120Opr2 = st120Opr2;
	}
	
	/**
	 * Column Info
	 * @param st120Opr10
	 */
	public void setSt120Opr10(String st120Opr10) {
		this.st120Opr10 = st120Opr10;
	}
	
	/**
	 * Column Info
	 * @param st132hOpr10
	 */
	public void setSt132hOpr10(String st132hOpr10) {
		this.st132hOpr10 = st132hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st120Opr4
	 */
	public void setSt120Opr4(String st120Opr4) {
		this.st120Opr4 = st120Opr4;
	}
	
	/**
	 * Column Info
	 * @param st120Opr3
	 */
	public void setSt120Opr3(String st120Opr3) {
		this.st120Opr3 = st120Opr3;
	}
	
	/**
	 * Column Info
	 * @param st120Opr6
	 */
	public void setSt120Opr6(String st120Opr6) {
		this.st120Opr6 = st120Opr6;
	}
	
	/**
	 * Column Info
	 * @param st120Opr5
	 */
	public void setSt120Opr5(String st120Opr5) {
		this.st120Opr5 = st120Opr5;
	}
	
	/**
	 * Column Info
	 * @param st120Opr8
	 */
	public void setSt120Opr8(String st120Opr8) {
		this.st120Opr8 = st120Opr8;
	}
	
	/**
	 * Column Info
	 * @param st120Opr7
	 */
	public void setSt120Opr7(String st120Opr7) {
		this.st120Opr7 = st120Opr7;
	}
	
	/**
	 * Column Info
	 * @param st120Opr9
	 */
	public void setSt120Opr9(String st120Opr9) {
		this.st120Opr9 = st120Opr9;
	}
	
	/**
	 * Column Info
	 * @param st1040Opr10
	 */
	public void setSt1040Opr10(String st1040Opr10) {
		this.st1040Opr10 = st1040Opr10;
	}
	
	/**
	 * Column Info
	 * @param st92hOpr10
	 */
	public void setSt92hOpr10(String st92hOpr10) {
		this.st92hOpr10 = st92hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st1045Opr5
	 */
	public void setSt1045Opr5(String st1045Opr5) {
		this.st1045Opr5 = st1045Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1045Opr4
	 */
	public void setSt1045Opr4(String st1045Opr4) {
		this.st1045Opr4 = st1045Opr4;
	}
	
	/**
	 * Column Info
	 * @param st1045Opr7
	 */
	public void setSt1045Opr7(String st1045Opr7) {
		this.st1045Opr7 = st1045Opr7;
	}
	
	/**
	 * Column Info
	 * @param st1045Opr6
	 */
	public void setSt1045Opr6(String st1045Opr6) {
		this.st1045Opr6 = st1045Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1045Opr1
	 */
	public void setSt1045Opr1(String st1045Opr1) {
		this.st1045Opr1 = st1045Opr1;
	}
	
	/**
	 * Column Info
	 * @param st540Opr10
	 */
	public void setSt540Opr10(String st540Opr10) {
		this.st540Opr10 = st540Opr10;
	}
	
	/**
	 * Column Info
	 * @param st1045Opr3
	 */
	public void setSt1045Opr3(String st1045Opr3) {
		this.st1045Opr3 = st1045Opr3;
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
	 * @param st1045Opr2
	 */
	public void setSt1045Opr2(String st1045Opr2) {
		this.st1045Opr2 = st1045Opr2;
	}
	
	/**
	 * Column Info
	 * @param st1045Opr9
	 */
	public void setSt1045Opr9(String st1045Opr9) {
		this.st1045Opr9 = st1045Opr9;
	}
	
	/**
	 * Column Info
	 * @param st1045Opr8
	 */
	public void setSt1045Opr8(String st1045Opr8) {
		this.st1045Opr8 = st1045Opr8;
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
	 * @param st1520Opr10
	 */
	public void setSt1520Opr10(String st1520Opr10) {
		this.st1520Opr10 = st1520Opr10;
	}
	
	/**
	 * Column Info
	 * @param st345Opr7
	 */
	public void setSt345Opr7(String st345Opr7) {
		this.st345Opr7 = st345Opr7;
	}
	
	/**
	 * Column Info
	 * @param st345Opr6
	 */
	public void setSt345Opr6(String st345Opr6) {
		this.st345Opr6 = st345Opr6;
	}
	
	/**
	 * Column Info
	 * @param st345Opr9
	 */
	public void setSt345Opr9(String st345Opr9) {
		this.st345Opr9 = st345Opr9;
	}
	
	/**
	 * Column Info
	 * @param st345Opr8
	 */
	public void setSt345Opr8(String st345Opr8) {
		this.st345Opr8 = st345Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1120Opr1
	 */
	public void setSt1120Opr1(String st1120Opr1) {
		this.st1120Opr1 = st1120Opr1;
	}
	
	/**
	 * Column Info
	 * @param st345Opr1
	 */
	public void setSt345Opr1(String st345Opr1) {
		this.st345Opr1 = st345Opr1;
	}
	
	/**
	 * Column Info
	 * @param st345Opr3
	 */
	public void setSt345Opr3(String st345Opr3) {
		this.st345Opr3 = st345Opr3;
	}
	
	/**
	 * Column Info
	 * @param st345Opr2
	 */
	public void setSt345Opr2(String st345Opr2) {
		this.st345Opr2 = st345Opr2;
	}
	
	/**
	 * Column Info
	 * @param st345Opr5
	 */
	public void setSt345Opr5(String st345Opr5) {
		this.st345Opr5 = st345Opr5;
	}
	
	/**
	 * Column Info
	 * @param st345Opr4
	 */
	public void setSt345Opr4(String st345Opr4) {
		this.st345Opr4 = st345Opr4;
	}
	
	/**
	 * Column Info
	 * @param st12hOpr2
	 */
	public void setSt12hOpr2(String st12hOpr2) {
		this.st12hOpr2 = st12hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st12hOpr1
	 */
	public void setSt12hOpr1(String st12hOpr1) {
		this.st12hOpr1 = st12hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st1340Opr1
	 */
	public void setSt1340Opr1(String st1340Opr1) {
		this.st1340Opr1 = st1340Opr1;
	}
	
	/**
	 * Column Info
	 * @param st12hOpr8
	 */
	public void setSt12hOpr8(String st12hOpr8) {
		this.st12hOpr8 = st12hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st12hOpr7
	 */
	public void setSt12hOpr7(String st12hOpr7) {
		this.st12hOpr7 = st12hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st12hOpr9
	 */
	public void setSt12hOpr9(String st12hOpr9) {
		this.st12hOpr9 = st12hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st12hOpr4
	 */
	public void setSt12hOpr4(String st12hOpr4) {
		this.st12hOpr4 = st12hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st12hOpr3
	 */
	public void setSt12hOpr3(String st12hOpr3) {
		this.st12hOpr3 = st12hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st12hOpr6
	 */
	public void setSt12hOpr6(String st12hOpr6) {
		this.st12hOpr6 = st12hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st12hOpr5
	 */
	public void setSt12hOpr5(String st12hOpr5) {
		this.st12hOpr5 = st12hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st1420Opr6
	 */
	public void setSt1420Opr6(String st1420Opr6) {
		this.st1420Opr6 = st1420Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1420Opr5
	 */
	public void setSt1420Opr5(String st1420Opr5) {
		this.st1420Opr5 = st1420Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1420Opr4
	 */
	public void setSt1420Opr4(String st1420Opr4) {
		this.st1420Opr4 = st1420Opr4;
	}
	
	/**
	 * Column Info
	 * @param st1420Opr3
	 */
	public void setSt1420Opr3(String st1420Opr3) {
		this.st1420Opr3 = st1420Opr3;
	}
	
	/**
	 * Column Info
	 * @param st1420Opr2
	 */
	public void setSt1420Opr2(String st1420Opr2) {
		this.st1420Opr2 = st1420Opr2;
	}
	
	/**
	 * Column Info
	 * @param st1420Opr1
	 */
	public void setSt1420Opr1(String st1420Opr1) {
		this.st1420Opr1 = st1420Opr1;
	}
	
	/**
	 * Column Info
	 * @param st1420Opr9
	 */
	public void setSt1420Opr9(String st1420Opr9) {
		this.st1420Opr9 = st1420Opr9;
	}
	
	/**
	 * Column Info
	 * @param st1420Opr8
	 */
	public void setSt1420Opr8(String st1420Opr8) {
		this.st1420Opr8 = st1420Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1420Opr7
	 */
	public void setSt1420Opr7(String st1420Opr7) {
		this.st1420Opr7 = st1420Opr7;
	}
	
	/**
	 * Column Info
	 * @param st84hOpr1
	 */
	public void setSt84hOpr1(String st84hOpr1) {
		this.st84hOpr1 = st84hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st84hOpr3
	 */
	public void setSt84hOpr3(String st84hOpr3) {
		this.st84hOpr3 = st84hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st84hOpr2
	 */
	public void setSt84hOpr2(String st84hOpr2) {
		this.st84hOpr2 = st84hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st84hOpr5
	 */
	public void setSt84hOpr5(String st84hOpr5) {
		this.st84hOpr5 = st84hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st84hOpr4
	 */
	public void setSt84hOpr4(String st84hOpr4) {
		this.st84hOpr4 = st84hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st152hOpr10
	 */
	public void setSt152hOpr10(String st152hOpr10) {
		this.st152hOpr10 = st152hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st84hOpr6
	 */
	public void setSt84hOpr6(String st84hOpr6) {
		this.st84hOpr6 = st84hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st84hOpr7
	 */
	public void setSt84hOpr7(String st84hOpr7) {
		this.st84hOpr7 = st84hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st84hOpr8
	 */
	public void setSt84hOpr8(String st84hOpr8) {
		this.st84hOpr8 = st84hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st84hOpr9
	 */
	public void setSt84hOpr9(String st84hOpr9) {
		this.st84hOpr9 = st84hOpr9;
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
	 * @param st14hOpr10
	 */
	public void setSt14hOpr10(String st14hOpr10) {
		this.st14hOpr10 = st14hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st640Opr8
	 */
	public void setSt640Opr8(String st640Opr8) {
		this.st640Opr8 = st640Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1245Opr9
	 */
	public void setSt1245Opr9(String st1245Opr9) {
		this.st1245Opr9 = st1245Opr9;
	}
	
	/**
	 * Column Info
	 * @param st1245Opr8
	 */
	public void setSt1245Opr8(String st1245Opr8) {
		this.st1245Opr8 = st1245Opr8;
	}
	
	/**
	 * Column Info
	 * @param st640Opr9
	 */
	public void setSt640Opr9(String st640Opr9) {
		this.st640Opr9 = st640Opr9;
	}
	
	/**
	 * Column Info
	 * @param st1245Opr7
	 */
	public void setSt1245Opr7(String st1245Opr7) {
		this.st1245Opr7 = st1245Opr7;
	}
	
	/**
	 * Column Info
	 * @param st1245Opr6
	 */
	public void setSt1245Opr6(String st1245Opr6) {
		this.st1245Opr6 = st1245Opr6;
	}
	
	/**
	 * Column Info
	 * @param st640Opr4
	 */
	public void setSt640Opr4(String st640Opr4) {
		this.st640Opr4 = st640Opr4;
	}
	
	/**
	 * Column Info
	 * @param st1245Opr5
	 */
	public void setSt1245Opr5(String st1245Opr5) {
		this.st1245Opr5 = st1245Opr5;
	}
	
	/**
	 * Column Info
	 * @param st640Opr5
	 */
	public void setSt640Opr5(String st640Opr5) {
		this.st640Opr5 = st640Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1245Opr4
	 */
	public void setSt1245Opr4(String st1245Opr4) {
		this.st1245Opr4 = st1245Opr4;
	}
	
	/**
	 * Column Info
	 * @param st1245Opr3
	 */
	public void setSt1245Opr3(String st1245Opr3) {
		this.st1245Opr3 = st1245Opr3;
	}
	
	/**
	 * Column Info
	 * @param st640Opr6
	 */
	public void setSt640Opr6(String st640Opr6) {
		this.st640Opr6 = st640Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1245Opr2
	 */
	public void setSt1245Opr2(String st1245Opr2) {
		this.st1245Opr2 = st1245Opr2;
	}
	
	/**
	 * Column Info
	 * @param st640Opr7
	 */
	public void setSt640Opr7(String st640Opr7) {
		this.st640Opr7 = st640Opr7;
	}
	
	/**
	 * Column Info
	 * @param st1245Opr1
	 */
	public void setSt1245Opr1(String st1245Opr1) {
		this.st1245Opr1 = st1245Opr1;
	}
	
	/**
	 * Column Info
	 * @param st640Opr1
	 */
	public void setSt640Opr1(String st640Opr1) {
		this.st640Opr1 = st640Opr1;
	}
	
	/**
	 * Column Info
	 * @param st640Opr2
	 */
	public void setSt640Opr2(String st640Opr2) {
		this.st640Opr2 = st640Opr2;
	}
	
	/**
	 * Column Info
	 * @param st640Opr3
	 */
	public void setSt640Opr3(String st640Opr3) {
		this.st640Opr3 = st640Opr3;
	}
	
	/**
	 * Column Info
	 * @param st52hOpr10
	 */
	public void setSt52hOpr10(String st52hOpr10) {
		this.st52hOpr10 = st52hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st1340Opr2
	 */
	public void setSt1340Opr2(String st1340Opr2) {
		this.st1340Opr2 = st1340Opr2;
	}
	
	/**
	 * Column Info
	 * @param st1340Opr3
	 */
	public void setSt1340Opr3(String st1340Opr3) {
		this.st1340Opr3 = st1340Opr3;
	}
	
	/**
	 * Column Info
	 * @param st1340Opr4
	 */
	public void setSt1340Opr4(String st1340Opr4) {
		this.st1340Opr4 = st1340Opr4;
	}
	
	/**
	 * Column Info
	 * @param st1340Opr5
	 */
	public void setSt1340Opr5(String st1340Opr5) {
		this.st1340Opr5 = st1340Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1340Opr6
	 */
	public void setSt1340Opr6(String st1340Opr6) {
		this.st1340Opr6 = st1340Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1340Opr7
	 */
	public void setSt1340Opr7(String st1340Opr7) {
		this.st1340Opr7 = st1340Opr7;
	}
	
	/**
	 * Column Info
	 * @param st1340Opr8
	 */
	public void setSt1340Opr8(String st1340Opr8) {
		this.st1340Opr8 = st1340Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1340Opr9
	 */
	public void setSt1340Opr9(String st1340Opr9) {
		this.st1340Opr9 = st1340Opr9;
	}
	
	/**
	 * Column Info
	 * @param st945Opr1
	 */
	public void setSt945Opr1(String st945Opr1) {
		this.st945Opr1 = st945Opr1;
	}
	
	/**
	 * Column Info
	 * @param st945Opr3
	 */
	public void setSt945Opr3(String st945Opr3) {
		this.st945Opr3 = st945Opr3;
	}
	
	/**
	 * Column Info
	 * @param st945Opr2
	 */
	public void setSt945Opr2(String st945Opr2) {
		this.st945Opr2 = st945Opr2;
	}
	
	/**
	 * Column Info
	 * @param st945Opr5
	 */
	public void setSt945Opr5(String st945Opr5) {
		this.st945Opr5 = st945Opr5;
	}
	
	/**
	 * Column Info
	 * @param st945Opr4
	 */
	public void setSt945Opr4(String st945Opr4) {
		this.st945Opr4 = st945Opr4;
	}
	
	/**
	 * Column Info
	 * @param st945Opr7
	 */
	public void setSt945Opr7(String st945Opr7) {
		this.st945Opr7 = st945Opr7;
	}
	
	/**
	 * Column Info
	 * @param st945Opr6
	 */
	public void setSt945Opr6(String st945Opr6) {
		this.st945Opr6 = st945Opr6;
	}
	
	/**
	 * Column Info
	 * @param st64hOpr10
	 */
	public void setSt64hOpr10(String st64hOpr10) {
		this.st64hOpr10 = st64hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st520Opr1
	 */
	public void setSt520Opr1(String st520Opr1) {
		this.st520Opr1 = st520Opr1;
	}
	
	/**
	 * Column Info
	 * @param st540Opr2
	 */
	public void setSt540Opr2(String st540Opr2) {
		this.st540Opr2 = st540Opr2;
	}
	
	/**
	 * Column Info
	 * @param st540Opr1
	 */
	public void setSt540Opr1(String st540Opr1) {
		this.st540Opr1 = st540Opr1;
	}
	
	/**
	 * Column Info
	 * @param st520Opr2
	 */
	public void setSt520Opr2(String st520Opr2) {
		this.st520Opr2 = st520Opr2;
	}
	
	/**
	 * Column Info
	 * @param st540Opr4
	 */
	public void setSt540Opr4(String st540Opr4) {
		this.st540Opr4 = st540Opr4;
	}
	
	/**
	 * Column Info
	 * @param st540Opr3
	 */
	public void setSt540Opr3(String st540Opr3) {
		this.st540Opr3 = st540Opr3;
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
	 * @param st520Opr5
	 */
	public void setSt520Opr5(String st520Opr5) {
		this.st520Opr5 = st520Opr5;
	}
	
	/**
	 * Column Info
	 * @param st540Opr6
	 */
	public void setSt540Opr6(String st540Opr6) {
		this.st540Opr6 = st540Opr6;
	}
	
	/**
	 * Column Info
	 * @param st540Opr5
	 */
	public void setSt540Opr5(String st540Opr5) {
		this.st540Opr5 = st540Opr5;
	}
	
	/**
	 * Column Info
	 * @param st520Opr6
	 */
	public void setSt520Opr6(String st520Opr6) {
		this.st520Opr6 = st520Opr6;
	}
	
	/**
	 * Column Info
	 * @param st520Opr3
	 */
	public void setSt520Opr3(String st520Opr3) {
		this.st520Opr3 = st520Opr3;
	}
	
	/**
	 * Column Info
	 * @param st540Opr8
	 */
	public void setSt540Opr8(String st540Opr8) {
		this.st540Opr8 = st540Opr8;
	}
	
	/**
	 * Column Info
	 * @param st520Opr4
	 */
	public void setSt520Opr4(String st520Opr4) {
		this.st520Opr4 = st520Opr4;
	}
	
	/**
	 * Column Info
	 * @param st540Opr7
	 */
	public void setSt540Opr7(String st540Opr7) {
		this.st540Opr7 = st540Opr7;
	}
	
	/**
	 * Column Info
	 * @param st520Opr9
	 */
	public void setSt520Opr9(String st520Opr9) {
		this.st520Opr9 = st520Opr9;
	}
	
	/**
	 * Column Info
	 * @param st540Opr9
	 */
	public void setSt540Opr9(String st540Opr9) {
		this.st540Opr9 = st540Opr9;
	}
	
	/**
	 * Column Info
	 * @param st520Opr7
	 */
	public void setSt520Opr7(String st520Opr7) {
		this.st520Opr7 = st520Opr7;
	}
	
	/**
	 * Column Info
	 * @param st520Opr8
	 */
	public void setSt520Opr8(String st520Opr8) {
		this.st520Opr8 = st520Opr8;
	}
	
	/**
	 * Column Info
	 * @param st945Opr10
	 */
	public void setSt945Opr10(String st945Opr10) {
		this.st945Opr10 = st945Opr10;
	}
	
	/**
	 * Column Info
	 * @param st94hOpr10
	 */
	public void setSt94hOpr10(String st94hOpr10) {
		this.st94hOpr10 = st94hOpr10;
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
	 * @param st1540Opr10
	 */
	public void setSt1540Opr10(String st1540Opr10) {
		this.st1540Opr10 = st1540Opr10;
	}
	
	/**
	 * Column Info
	 * @param st945Opr8
	 */
	public void setSt945Opr8(String st945Opr8) {
		this.st945Opr8 = st945Opr8;
	}
	
	/**
	 * Column Info
	 * @param st945Opr9
	 */
	public void setSt945Opr9(String st945Opr9) {
		this.st945Opr9 = st945Opr9;
	}
	
	/**
	 * Column Info
	 * @param st32hOpr9
	 */
	public void setSt32hOpr9(String st32hOpr9) {
		this.st32hOpr9 = st32hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st24hOpr1
	 */
	public void setSt24hOpr1(String st24hOpr1) {
		this.st24hOpr1 = st24hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st920Opr9
	 */
	public void setSt920Opr9(String st920Opr9) {
		this.st920Opr9 = st920Opr9;
	}
	
	/**
	 * Column Info
	 * @param st24hOpr3
	 */
	public void setSt24hOpr3(String st24hOpr3) {
		this.st24hOpr3 = st24hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st920Opr8
	 */
	public void setSt920Opr8(String st920Opr8) {
		this.st920Opr8 = st920Opr8;
	}
	
	/**
	 * Column Info
	 * @param st24hOpr2
	 */
	public void setSt24hOpr2(String st24hOpr2) {
		this.st24hOpr2 = st24hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st920Opr7
	 */
	public void setSt920Opr7(String st920Opr7) {
		this.st920Opr7 = st920Opr7;
	}
	
	/**
	 * Column Info
	 * @param st920Opr6
	 */
	public void setSt920Opr6(String st920Opr6) {
		this.st920Opr6 = st920Opr6;
	}
	
	/**
	 * Column Info
	 * @param st920Opr5
	 */
	public void setSt920Opr5(String st920Opr5) {
		this.st920Opr5 = st920Opr5;
	}
	
	/**
	 * Column Info
	 * @param st920Opr4
	 */
	public void setSt920Opr4(String st920Opr4) {
		this.st920Opr4 = st920Opr4;
	}
	
	/**
	 * Column Info
	 * @param st920Opr3
	 */
	public void setSt920Opr3(String st920Opr3) {
		this.st920Opr3 = st920Opr3;
	}
	
	/**
	 * Column Info
	 * @param st32hOpr4
	 */
	public void setSt32hOpr4(String st32hOpr4) {
		this.st32hOpr4 = st32hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st920Opr2
	 */
	public void setSt920Opr2(String st920Opr2) {
		this.st920Opr2 = st920Opr2;
	}
	
	/**
	 * Column Info
	 * @param st24hOpr9
	 */
	public void setSt24hOpr9(String st24hOpr9) {
		this.st24hOpr9 = st24hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st32hOpr3
	 */
	public void setSt32hOpr3(String st32hOpr3) {
		this.st32hOpr3 = st32hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st920Opr1
	 */
	public void setSt920Opr1(String st920Opr1) {
		this.st920Opr1 = st920Opr1;
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
	 * @param st24hOpr8
	 */
	public void setSt24hOpr8(String st24hOpr8) {
		this.st24hOpr8 = st24hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st240Opr10
	 */
	public void setSt240Opr10(String st240Opr10) {
		this.st240Opr10 = st240Opr10;
	}
	
	/**
	 * Column Info
	 * @param st32hOpr2
	 */
	public void setSt32hOpr2(String st32hOpr2) {
		this.st32hOpr2 = st32hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st32hOpr1
	 */
	public void setSt32hOpr1(String st32hOpr1) {
		this.st32hOpr1 = st32hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st24hOpr5
	 */
	public void setSt24hOpr5(String st24hOpr5) {
		this.st24hOpr5 = st24hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st32hOpr8
	 */
	public void setSt32hOpr8(String st32hOpr8) {
		this.st32hOpr8 = st32hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st24hOpr4
	 */
	public void setSt24hOpr4(String st24hOpr4) {
		this.st24hOpr4 = st24hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st32hOpr7
	 */
	public void setSt32hOpr7(String st32hOpr7) {
		this.st32hOpr7 = st32hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st32hOpr6
	 */
	public void setSt32hOpr6(String st32hOpr6) {
		this.st32hOpr6 = st32hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st24hOpr7
	 */
	public void setSt24hOpr7(String st24hOpr7) {
		this.st24hOpr7 = st24hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st32hOpr5
	 */
	public void setSt32hOpr5(String st32hOpr5) {
		this.st32hOpr5 = st32hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st24hOpr6
	 */
	public void setSt24hOpr6(String st24hOpr6) {
		this.st24hOpr6 = st24hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st240Opr4
	 */
	public void setSt240Opr4(String st240Opr4) {
		this.st240Opr4 = st240Opr4;
	}
	
	/**
	 * Column Info
	 * @param st820Opr1
	 */
	public void setSt820Opr1(String st820Opr1) {
		this.st820Opr1 = st820Opr1;
	}
	
	/**
	 * Column Info
	 * @param st112hOpr10
	 */
	public void setSt112hOpr10(String st112hOpr10) {
		this.st112hOpr10 = st112hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st240Opr5
	 */
	public void setSt240Opr5(String st240Opr5) {
		this.st240Opr5 = st240Opr5;
	}
	
	/**
	 * Column Info
	 * @param st820Opr3
	 */
	public void setSt820Opr3(String st820Opr3) {
		this.st820Opr3 = st820Opr3;
	}
	
	/**
	 * Column Info
	 * @param st240Opr6
	 */
	public void setSt240Opr6(String st240Opr6) {
		this.st240Opr6 = st240Opr6;
	}
	
	/**
	 * Column Info
	 * @param st820Opr2
	 */
	public void setSt820Opr2(String st820Opr2) {
		this.st820Opr2 = st820Opr2;
	}
	
	/**
	 * Column Info
	 * @param st240Opr7
	 */
	public void setSt240Opr7(String st240Opr7) {
		this.st240Opr7 = st240Opr7;
	}
	
	/**
	 * Column Info
	 * @param st240Opr8
	 */
	public void setSt240Opr8(String st240Opr8) {
		this.st240Opr8 = st240Opr8;
	}
	
	/**
	 * Column Info
	 * @param st240Opr9
	 */
	public void setSt240Opr9(String st240Opr9) {
		this.st240Opr9 = st240Opr9;
	}
	
	/**
	 * Column Info
	 * @param st64hOpr7
	 */
	public void setSt64hOpr7(String st64hOpr7) {
		this.st64hOpr7 = st64hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st820Opr9
	 */
	public void setSt820Opr9(String st820Opr9) {
		this.st820Opr9 = st820Opr9;
	}
	
	/**
	 * Column Info
	 * @param st64hOpr6
	 */
	public void setSt64hOpr6(String st64hOpr6) {
		this.st64hOpr6 = st64hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st820Opr8
	 */
	public void setSt820Opr8(String st820Opr8) {
		this.st820Opr8 = st820Opr8;
	}
	
	/**
	 * Column Info
	 * @param st64hOpr5
	 */
	public void setSt64hOpr5(String st64hOpr5) {
		this.st64hOpr5 = st64hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st64hOpr4
	 */
	public void setSt64hOpr4(String st64hOpr4) {
		this.st64hOpr4 = st64hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st64hOpr3
	 */
	public void setSt64hOpr3(String st64hOpr3) {
		this.st64hOpr3 = st64hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st820Opr5
	 */
	public void setSt820Opr5(String st820Opr5) {
		this.st820Opr5 = st820Opr5;
	}
	
	/**
	 * Column Info
	 * @param st820Opr4
	 */
	public void setSt820Opr4(String st820Opr4) {
		this.st820Opr4 = st820Opr4;
	}
	
	/**
	 * Column Info
	 * @param st64hOpr2
	 */
	public void setSt64hOpr2(String st64hOpr2) {
		this.st64hOpr2 = st64hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st64hOpr1
	 */
	public void setSt64hOpr1(String st64hOpr1) {
		this.st64hOpr1 = st64hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st820Opr7
	 */
	public void setSt820Opr7(String st820Opr7) {
		this.st820Opr7 = st820Opr7;
	}
	
	/**
	 * Column Info
	 * @param st820Opr6
	 */
	public void setSt820Opr6(String st820Opr6) {
		this.st820Opr6 = st820Opr6;
	}
	
	/**
	 * Column Info
	 * @param st445Opr1
	 */
	public void setSt445Opr1(String st445Opr1) {
		this.st445Opr1 = st445Opr1;
	}
	
	/**
	 * Column Info
	 * @param st445Opr2
	 */
	public void setSt445Opr2(String st445Opr2) {
		this.st445Opr2 = st445Opr2;
	}
	
	/**
	 * Column Info
	 * @param st445Opr3
	 */
	public void setSt445Opr3(String st445Opr3) {
		this.st445Opr3 = st445Opr3;
	}
	
	/**
	 * Column Info
	 * @param st64hOpr8
	 */
	public void setSt64hOpr8(String st64hOpr8) {
		this.st64hOpr8 = st64hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st445Opr4
	 */
	public void setSt445Opr4(String st445Opr4) {
		this.st445Opr4 = st445Opr4;
	}
	
	/**
	 * Column Info
	 * @param st64hOpr9
	 */
	public void setSt64hOpr9(String st64hOpr9) {
		this.st64hOpr9 = st64hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st445Opr5
	 */
	public void setSt445Opr5(String st445Opr5) {
		this.st445Opr5 = st445Opr5;
	}
	
	/**
	 * Column Info
	 * @param st445Opr6
	 */
	public void setSt445Opr6(String st445Opr6) {
		this.st445Opr6 = st445Opr6;
	}
	
	/**
	 * Column Info
	 * @param st445Opr7
	 */
	public void setSt445Opr7(String st445Opr7) {
		this.st445Opr7 = st445Opr7;
	}
	
	/**
	 * Column Info
	 * @param st445Opr8
	 */
	public void setSt445Opr8(String st445Opr8) {
		this.st445Opr8 = st445Opr8;
	}
	
	/**
	 * Column Info
	 * @param st240Opr1
	 */
	public void setSt240Opr1(String st240Opr1) {
		this.st240Opr1 = st240Opr1;
	}
	
	/**
	 * Column Info
	 * @param st445Opr9
	 */
	public void setSt445Opr9(String st445Opr9) {
		this.st445Opr9 = st445Opr9;
	}
	
	/**
	 * Column Info
	 * @param st240Opr3
	 */
	public void setSt240Opr3(String st240Opr3) {
		this.st240Opr3 = st240Opr3;
	}
	
	/**
	 * Column Info
	 * @param st240Opr2
	 */
	public void setSt240Opr2(String st240Opr2) {
		this.st240Opr2 = st240Opr2;
	}
	
	/**
	 * Column Info
	 * @param st9
	 */
	public void setSt9(String st9) {
		this.st9 = st9;
	}
	
	/**
	 * Column Info
	 * @param st7
	 */
	public void setSt7(String st7) {
		this.st7 = st7;
	}
	
	/**
	 * Column Info
	 * @param st8
	 */
	public void setSt8(String st8) {
		this.st8 = st8;
	}
	
	/**
	 * Column Info
	 * @param st5
	 */
	public void setSt5(String st5) {
		this.st5 = st5;
	}
	
	/**
	 * Column Info
	 * @param st6
	 */
	public void setSt6(String st6) {
		this.st6 = st6;
	}
	
	/**
	 * Column Info
	 * @param st3
	 */
	public void setSt3(String st3) {
		this.st3 = st3;
	}
	
	/**
	 * Column Info
	 * @param st4
	 */
	public void setSt4(String st4) {
		this.st4 = st4;
	}
	
	/**
	 * Column Info
	 * @param st1
	 */
	public void setSt1(String st1) {
		this.st1 = st1;
	}
	
	/**
	 * Column Info
	 * @param st2
	 */
	public void setSt2(String st2) {
		this.st2 = st2;
	}
	
	/**
	 * Column Info
	 * @param st940Opr10
	 */
	public void setSt940Opr10(String st940Opr10) {
		this.st940Opr10 = st940Opr10;
	}
	
	/**
	 * Column Info
	 * @param st1220Opr10
	 */
	public void setSt1220Opr10(String st1220Opr10) {
		this.st1220Opr10 = st1220Opr10;
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
	 * @param st320Opr9
	 */
	public void setSt320Opr9(String st320Opr9) {
		this.st320Opr9 = st320Opr9;
	}
	
	/**
	 * Column Info
	 * @param st320Opr8
	 */
	public void setSt320Opr8(String st320Opr8) {
		this.st320Opr8 = st320Opr8;
	}
	
	/**
	 * Column Info
	 * @param st320Opr7
	 */
	public void setSt320Opr7(String st320Opr7) {
		this.st320Opr7 = st320Opr7;
	}
	
	/**
	 * Column Info
	 * @param st320Opr6
	 */
	public void setSt320Opr6(String st320Opr6) {
		this.st320Opr6 = st320Opr6;
	}
	
	/**
	 * Column Info
	 * @param st320Opr5
	 */
	public void setSt320Opr5(String st320Opr5) {
		this.st320Opr5 = st320Opr5;
	}
	
	/**
	 * Column Info
	 * @param st42hOpr10
	 */
	public void setSt42hOpr10(String st42hOpr10) {
		this.st42hOpr10 = st42hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st320Opr4
	 */
	public void setSt320Opr4(String st320Opr4) {
		this.st320Opr4 = st320Opr4;
	}
	
	/**
	 * Column Info
	 * @param st320Opr3
	 */
	public void setSt320Opr3(String st320Opr3) {
		this.st320Opr3 = st320Opr3;
	}
	
	/**
	 * Column Info
	 * @param st320Opr2
	 */
	public void setSt320Opr2(String st320Opr2) {
		this.st320Opr2 = st320Opr2;
	}
	
	/**
	 * Column Info
	 * @param st320Opr1
	 */
	public void setSt320Opr1(String st320Opr1) {
		this.st320Opr1 = st320Opr1;
	}
	
	/**
	 * Column Info
	 * @param st144hOpr9
	 */
	public void setSt144hOpr9(String st144hOpr9) {
		this.st144hOpr9 = st144hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st645Opr10
	 */
	public void setSt645Opr10(String st645Opr10) {
		this.st645Opr10 = st645Opr10;
	}
	
	/**
	 * Column Info
	 * @param st22hOpr1
	 */
	public void setSt22hOpr1(String st22hOpr1) {
		this.st22hOpr1 = st22hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st22hOpr8
	 */
	public void setSt22hOpr8(String st22hOpr8) {
		this.st22hOpr8 = st22hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st22hOpr9
	 */
	public void setSt22hOpr9(String st22hOpr9) {
		this.st22hOpr9 = st22hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st22hOpr6
	 */
	public void setSt22hOpr6(String st22hOpr6) {
		this.st22hOpr6 = st22hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st22hOpr7
	 */
	public void setSt22hOpr7(String st22hOpr7) {
		this.st22hOpr7 = st22hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st122hOpr10
	 */
	public void setSt122hOpr10(String st122hOpr10) {
		this.st122hOpr10 = st122hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st104hOpr10
	 */
	public void setSt104hOpr10(String st104hOpr10) {
		this.st104hOpr10 = st104hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st22hOpr4
	 */
	public void setSt22hOpr4(String st22hOpr4) {
		this.st22hOpr4 = st22hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st22hOpr5
	 */
	public void setSt22hOpr5(String st22hOpr5) {
		this.st22hOpr5 = st22hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st22hOpr2
	 */
	public void setSt22hOpr2(String st22hOpr2) {
		this.st22hOpr2 = st22hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st22hOpr3
	 */
	public void setSt22hOpr3(String st22hOpr3) {
		this.st22hOpr3 = st22hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st440Opr10
	 */
	public void setSt440Opr10(String st440Opr10) {
		this.st440Opr10 = st440Opr10;
	}
	
	/**
	 * Column Info
	 * @param st44hOpr6
	 */
	public void setSt44hOpr6(String st44hOpr6) {
		this.st44hOpr6 = st44hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st44hOpr7
	 */
	public void setSt44hOpr7(String st44hOpr7) {
		this.st44hOpr7 = st44hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st44hOpr8
	 */
	public void setSt44hOpr8(String st44hOpr8) {
		this.st44hOpr8 = st44hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st44hOpr9
	 */
	public void setSt44hOpr9(String st44hOpr9) {
		this.st44hOpr9 = st44hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st44hOpr2
	 */
	public void setSt44hOpr2(String st44hOpr2) {
		this.st44hOpr2 = st44hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st44hOpr3
	 */
	public void setSt44hOpr3(String st44hOpr3) {
		this.st44hOpr3 = st44hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st44hOpr4
	 */
	public void setSt44hOpr4(String st44hOpr4) {
		this.st44hOpr4 = st44hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st44hOpr5
	 */
	public void setSt44hOpr5(String st44hOpr5) {
		this.st44hOpr5 = st44hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st44hOpr1
	 */
	public void setSt44hOpr1(String st44hOpr1) {
		this.st44hOpr1 = st44hOpr1;
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
	 * @param st144hOpr1
	 */
	public void setSt144hOpr1(String st144hOpr1) {
		this.st144hOpr1 = st144hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st144hOpr2
	 */
	public void setSt144hOpr2(String st144hOpr2) {
		this.st144hOpr2 = st144hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st144hOpr3
	 */
	public void setSt144hOpr3(String st144hOpr3) {
		this.st144hOpr3 = st144hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st74hOpr10
	 */
	public void setSt74hOpr10(String st74hOpr10) {
		this.st74hOpr10 = st74hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st144hOpr4
	 */
	public void setSt144hOpr4(String st144hOpr4) {
		this.st144hOpr4 = st144hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st144hOpr5
	 */
	public void setSt144hOpr5(String st144hOpr5) {
		this.st144hOpr5 = st144hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st144hOpr6
	 */
	public void setSt144hOpr6(String st144hOpr6) {
		this.st144hOpr6 = st144hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st144hOpr7
	 */
	public void setSt144hOpr7(String st144hOpr7) {
		this.st144hOpr7 = st144hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st144hOpr8
	 */
	public void setSt144hOpr8(String st144hOpr8) {
		this.st144hOpr8 = st144hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st72hOpr10
	 */
	public void setSt72hOpr10(String st72hOpr10) {
		this.st72hOpr10 = st72hOpr10;
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
	 * @param st420Opr9
	 */
	public void setSt420Opr9(String st420Opr9) {
		this.st420Opr9 = st420Opr9;
	}
	
	/**
	 * Column Info
	 * @param st420Opr8
	 */
	public void setSt420Opr8(String st420Opr8) {
		this.st420Opr8 = st420Opr8;
	}
	
	/**
	 * Column Info
	 * @param st420Opr5
	 */
	public void setSt420Opr5(String st420Opr5) {
		this.st420Opr5 = st420Opr5;
	}
	
	/**
	 * Column Info
	 * @param st420Opr4
	 */
	public void setSt420Opr4(String st420Opr4) {
		this.st420Opr4 = st420Opr4;
	}
	
	/**
	 * Column Info
	 * @param st420Opr7
	 */
	public void setSt420Opr7(String st420Opr7) {
		this.st420Opr7 = st420Opr7;
	}
	
	/**
	 * Column Info
	 * @param st420Opr6
	 */
	public void setSt420Opr6(String st420Opr6) {
		this.st420Opr6 = st420Opr6;
	}
	
	/**
	 * Column Info
	 * @param st420Opr1
	 */
	public void setSt420Opr1(String st420Opr1) {
		this.st420Opr1 = st420Opr1;
	}
	
	/**
	 * Column Info
	 * @param st420Opr3
	 */
	public void setSt420Opr3(String st420Opr3) {
		this.st420Opr3 = st420Opr3;
	}
	
	/**
	 * Column Info
	 * @param st420Opr2
	 */
	public void setSt420Opr2(String st420Opr2) {
		this.st420Opr2 = st420Opr2;
	}
	
	/**
	 * Column Info
	 * @param st840Opr9
	 */
	public void setSt840Opr9(String st840Opr9) {
		this.st840Opr9 = st840Opr9;
	}
	
	/**
	 * Column Info
	 * @param st840Opr8
	 */
	public void setSt840Opr8(String st840Opr8) {
		this.st840Opr8 = st840Opr8;
	}
	
	/**
	 * Column Info
	 * @param st840Opr7
	 */
	public void setSt840Opr7(String st840Opr7) {
		this.st840Opr7 = st840Opr7;
	}
	
	/**
	 * Column Info
	 * @param st840Opr6
	 */
	public void setSt840Opr6(String st840Opr6) {
		this.st840Opr6 = st840Opr6;
	}
	
	/**
	 * Column Info
	 * @param st22hOpr10
	 */
	public void setSt22hOpr10(String st22hOpr10) {
		this.st22hOpr10 = st22hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st840Opr1
	 */
	public void setSt840Opr1(String st840Opr1) {
		this.st840Opr1 = st840Opr1;
	}
	
	/**
	 * Column Info
	 * @param st440Opr9
	 */
	public void setSt440Opr9(String st440Opr9) {
		this.st440Opr9 = st440Opr9;
	}
	
	/**
	 * Column Info
	 * @param st440Opr8
	 */
	public void setSt440Opr8(String st440Opr8) {
		this.st440Opr8 = st440Opr8;
	}
	
	/**
	 * Column Info
	 * @param st440Opr7
	 */
	public void setSt440Opr7(String st440Opr7) {
		this.st440Opr7 = st440Opr7;
	}
	
	/**
	 * Column Info
	 * @param st440Opr6
	 */
	public void setSt440Opr6(String st440Opr6) {
		this.st440Opr6 = st440Opr6;
	}
	
	/**
	 * Column Info
	 * @param st440Opr5
	 */
	public void setSt440Opr5(String st440Opr5) {
		this.st440Opr5 = st440Opr5;
	}
	
	/**
	 * Column Info
	 * @param st840Opr5
	 */
	public void setSt840Opr5(String st840Opr5) {
		this.st840Opr5 = st840Opr5;
	}
	
	/**
	 * Column Info
	 * @param st840Opr4
	 */
	public void setSt840Opr4(String st840Opr4) {
		this.st840Opr4 = st840Opr4;
	}
	
	/**
	 * Column Info
	 * @param st440Opr4
	 */
	public void setSt440Opr4(String st440Opr4) {
		this.st440Opr4 = st440Opr4;
	}
	
	/**
	 * Column Info
	 * @param st840Opr3
	 */
	public void setSt840Opr3(String st840Opr3) {
		this.st840Opr3 = st840Opr3;
	}
	
	/**
	 * Column Info
	 * @param st440Opr3
	 */
	public void setSt440Opr3(String st440Opr3) {
		this.st440Opr3 = st440Opr3;
	}
	
	/**
	 * Column Info
	 * @param st440Opr2
	 */
	public void setSt440Opr2(String st440Opr2) {
		this.st440Opr2 = st440Opr2;
	}
	
	/**
	 * Column Info
	 * @param st840Opr2
	 */
	public void setSt840Opr2(String st840Opr2) {
		this.st840Opr2 = st840Opr2;
	}
	
	/**
	 * Column Info
	 * @param st440Opr1
	 */
	public void setSt440Opr1(String st440Opr1) {
		this.st440Opr1 = st440Opr1;
	}
	
	/**
	 * Column Info
	 * @param st820Opr10
	 */
	public void setSt820Opr10(String st820Opr10) {
		this.st820Opr10 = st820Opr10;
	}
	
	/**
	 * Column Info
	 * @param st1120Opr10
	 */
	public void setSt1120Opr10(String st1120Opr10) {
		this.st1120Opr10 = st1120Opr10;
	}
	
	/**
	 * Column Info
	 * @param st620Opr9
	 */
	public void setSt620Opr9(String st620Opr9) {
		this.st620Opr9 = st620Opr9;
	}
	
	/**
	 * Column Info
	 * @param st620Opr8
	 */
	public void setSt620Opr8(String st620Opr8) {
		this.st620Opr8 = st620Opr8;
	}
	
	/**
	 * Column Info
	 * @param st620Opr7
	 */
	public void setSt620Opr7(String st620Opr7) {
		this.st620Opr7 = st620Opr7;
	}
	
	/**
	 * Column Info
	 * @param st620Opr6
	 */
	public void setSt620Opr6(String st620Opr6) {
		this.st620Opr6 = st620Opr6;
	}
	
	/**
	 * Column Info
	 * @param st620Opr1
	 */
	public void setSt620Opr1(String st620Opr1) {
		this.st620Opr1 = st620Opr1;
	}
	
	/**
	 * Column Info
	 * @param st620Opr5
	 */
	public void setSt620Opr5(String st620Opr5) {
		this.st620Opr5 = st620Opr5;
	}
	
	/**
	 * Column Info
	 * @param st620Opr4
	 */
	public void setSt620Opr4(String st620Opr4) {
		this.st620Opr4 = st620Opr4;
	}
	
	/**
	 * Column Info
	 * @param st620Opr3
	 */
	public void setSt620Opr3(String st620Opr3) {
		this.st620Opr3 = st620Opr3;
	}
	
	/**
	 * Column Info
	 * @param st620Opr2
	 */
	public void setSt620Opr2(String st620Opr2) {
		this.st620Opr2 = st620Opr2;
	}
	
	/**
	 * Column Info
	 * @param st1240Opr9
	 */
	public void setSt1240Opr9(String st1240Opr9) {
		this.st1240Opr9 = st1240Opr9;
	}
	
	/**
	 * Column Info
	 * @param st62hOpr1
	 */
	public void setSt62hOpr1(String st62hOpr1) {
		this.st62hOpr1 = st62hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st1240Opr8
	 */
	public void setSt1240Opr8(String st1240Opr8) {
		this.st1240Opr8 = st1240Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1240Opr7
	 */
	public void setSt1240Opr7(String st1240Opr7) {
		this.st1240Opr7 = st1240Opr7;
	}
	
	/**
	 * Column Info
	 * @param st62hOpr3
	 */
	public void setSt62hOpr3(String st62hOpr3) {
		this.st62hOpr3 = st62hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st1240Opr6
	 */
	public void setSt1240Opr6(String st1240Opr6) {
		this.st1240Opr6 = st1240Opr6;
	}
	
	/**
	 * Column Info
	 * @param st62hOpr2
	 */
	public void setSt62hOpr2(String st62hOpr2) {
		this.st62hOpr2 = st62hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st1240Opr5
	 */
	public void setSt1240Opr5(String st1240Opr5) {
		this.st1240Opr5 = st1240Opr5;
	}
	
	/**
	 * Column Info
	 * @param st62hOpr5
	 */
	public void setSt62hOpr5(String st62hOpr5) {
		this.st62hOpr5 = st62hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st1240Opr4
	 */
	public void setSt1240Opr4(String st1240Opr4) {
		this.st1240Opr4 = st1240Opr4;
	}
	
	/**
	 * Column Info
	 * @param st62hOpr4
	 */
	public void setSt62hOpr4(String st62hOpr4) {
		this.st62hOpr4 = st62hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st1240Opr3
	 */
	public void setSt1240Opr3(String st1240Opr3) {
		this.st1240Opr3 = st1240Opr3;
	}
	
	/**
	 * Column Info
	 * @param st62hOpr6
	 */
	public void setSt62hOpr6(String st62hOpr6) {
		this.st62hOpr6 = st62hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st62hOpr7
	 */
	public void setSt62hOpr7(String st62hOpr7) {
		this.st62hOpr7 = st62hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st62hOpr8
	 */
	public void setSt62hOpr8(String st62hOpr8) {
		this.st62hOpr8 = st62hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st62hOpr9
	 */
	public void setSt62hOpr9(String st62hOpr9) {
		this.st62hOpr9 = st62hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st134hOpr10
	 */
	public void setSt134hOpr10(String st134hOpr10) {
		this.st134hOpr10 = st134hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st620Opr10
	 */
	public void setSt620Opr10(String st620Opr10) {
		this.st620Opr10 = st620Opr10;
	}
	
	/**
	 * Column Info
	 * @param st84hOpr10
	 */
	public void setSt84hOpr10(String st84hOpr10) {
		this.st84hOpr10 = st84hOpr10;
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
	 * @param st145Opr9
	 */
	public void setSt145Opr9(String st145Opr9) {
		this.st145Opr9 = st145Opr9;
	}
	
	/**
	 * Column Info
	 * @param st1245Opr10
	 */
	public void setSt1245Opr10(String st1245Opr10) {
		this.st1245Opr10 = st1245Opr10;
	}
	
	/**
	 * Column Info
	 * @param st145Opr8
	 */
	public void setSt145Opr8(String st145Opr8) {
		this.st145Opr8 = st145Opr8;
	}
	
	/**
	 * Column Info
	 * @param st154hOpr9
	 */
	public void setSt154hOpr9(String st154hOpr9) {
		this.st154hOpr9 = st154hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st154hOpr8
	 */
	public void setSt154hOpr8(String st154hOpr8) {
		this.st154hOpr8 = st154hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st1345Opr10
	 */
	public void setSt1345Opr10(String st1345Opr10) {
		this.st1345Opr10 = st1345Opr10;
	}
	
	/**
	 * Column Info
	 * @param st145Opr3
	 */
	public void setSt145Opr3(String st145Opr3) {
		this.st145Opr3 = st145Opr3;
	}
	
	/**
	 * Column Info
	 * @param st145Opr2
	 */
	public void setSt145Opr2(String st145Opr2) {
		this.st145Opr2 = st145Opr2;
	}
	
	/**
	 * Column Info
	 * @param st145Opr1
	 */
	public void setSt145Opr1(String st145Opr1) {
		this.st145Opr1 = st145Opr1;
	}
	
	/**
	 * Column Info
	 * @param st145Opr7
	 */
	public void setSt145Opr7(String st145Opr7) {
		this.st145Opr7 = st145Opr7;
	}
	
	/**
	 * Column Info
	 * @param st145Opr6
	 */
	public void setSt145Opr6(String st145Opr6) {
		this.st145Opr6 = st145Opr6;
	}
	
	/**
	 * Column Info
	 * @param st145Opr5
	 */
	public void setSt145Opr5(String st145Opr5) {
		this.st145Opr5 = st145Opr5;
	}
	
	/**
	 * Column Info
	 * @param st44hOpr10
	 */
	public void setSt44hOpr10(String st44hOpr10) {
		this.st44hOpr10 = st44hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st145Opr4
	 */
	public void setSt145Opr4(String st145Opr4) {
		this.st145Opr4 = st145Opr4;
	}
	
	/**
	 * Column Info
	 * @param st54hOpr4
	 */
	public void setSt54hOpr4(String st54hOpr4) {
		this.st54hOpr4 = st54hOpr4;
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
	 * @param st54hOpr3
	 */
	public void setSt54hOpr3(String st54hOpr3) {
		this.st54hOpr3 = st54hOpr3;
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
	 * @param st54hOpr2
	 */
	public void setSt54hOpr2(String st54hOpr2) {
		this.st54hOpr2 = st54hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st54hOpr1
	 */
	public void setSt54hOpr1(String st54hOpr1) {
		this.st54hOpr1 = st54hOpr1;
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
	 * @param st54hOpr8
	 */
	public void setSt54hOpr8(String st54hOpr8) {
		this.st54hOpr8 = st54hOpr8;
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
	 * @param st54hOpr7
	 */
	public void setSt54hOpr7(String st54hOpr7) {
		this.st54hOpr7 = st54hOpr7;
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
	 * @param st54hOpr6
	 */
	public void setSt54hOpr6(String st54hOpr6) {
		this.st54hOpr6 = st54hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st54hOpr5
	 */
	public void setSt54hOpr5(String st54hOpr5) {
		this.st54hOpr5 = st54hOpr5;
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
	 * @param opr9
	 */
	public void setOpr9(String opr9) {
		this.opr9 = opr9;
	}
	
	/**
	 * Column Info
	 * @param st54hOpr9
	 */
	public void setSt54hOpr9(String st54hOpr9) {
		this.st54hOpr9 = st54hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st220Opr6
	 */
	public void setSt220Opr6(String st220Opr6) {
		this.st220Opr6 = st220Opr6;
	}
	
	/**
	 * Column Info
	 * @param st220Opr7
	 */
	public void setSt220Opr7(String st220Opr7) {
		this.st220Opr7 = st220Opr7;
	}
	
	/**
	 * Column Info
	 * @param st220Opr8
	 */
	public void setSt220Opr8(String st220Opr8) {
		this.st220Opr8 = st220Opr8;
	}
	
	/**
	 * Column Info
	 * @param st220Opr9
	 */
	public void setSt220Opr9(String st220Opr9) {
		this.st220Opr9 = st220Opr9;
	}
	
	/**
	 * Column Info
	 * @param st220Opr2
	 */
	public void setSt220Opr2(String st220Opr2) {
		this.st220Opr2 = st220Opr2;
	}
	
	/**
	 * Column Info
	 * @param st220Opr3
	 */
	public void setSt220Opr3(String st220Opr3) {
		this.st220Opr3 = st220Opr3;
	}
	
	/**
	 * Column Info
	 * @param st220Opr4
	 */
	public void setSt220Opr4(String st220Opr4) {
		this.st220Opr4 = st220Opr4;
	}
	
	/**
	 * Column Info
	 * @param st220Opr5
	 */
	public void setSt220Opr5(String st220Opr5) {
		this.st220Opr5 = st220Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1020Opr2
	 */
	public void setSt1020Opr2(String st1020Opr2) {
		this.st1020Opr2 = st1020Opr2;
	}
	
	/**
	 * Column Info
	 * @param st1020Opr1
	 */
	public void setSt1020Opr1(String st1020Opr1) {
		this.st1020Opr1 = st1020Opr1;
	}
	
	/**
	 * Column Info
	 * @param st220Opr1
	 */
	public void setSt220Opr1(String st220Opr1) {
		this.st220Opr1 = st220Opr1;
	}
	
	/**
	 * Column Info
	 * @param st15
	 */
	public void setSt15(String st15) {
		this.st15 = st15;
	}
	
	/**
	 * Column Info
	 * @param st14
	 */
	public void setSt14(String st14) {
		this.st14 = st14;
	}
	
	/**
	 * Column Info
	 * @param st13
	 */
	public void setSt13(String st13) {
		this.st13 = st13;
	}
	
	/**
	 * Column Info
	 * @param st12
	 */
	public void setSt12(String st12) {
		this.st12 = st12;
	}
	
	/**
	 * Column Info
	 * @param st11
	 */
	public void setSt11(String st11) {
		this.st11 = st11;
	}
	
	/**
	 * Column Info
	 * @param st10
	 */
	public void setSt10(String st10) {
		this.st10 = st10;
	}
	
	/**
	 * Column Info
	 * @param st134hOpr1
	 */
	public void setSt134hOpr1(String st134hOpr1) {
		this.st134hOpr1 = st134hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st134hOpr2
	 */
	public void setSt134hOpr2(String st134hOpr2) {
		this.st134hOpr2 = st134hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st72hOpr5
	 */
	public void setSt72hOpr5(String st72hOpr5) {
		this.st72hOpr5 = st72hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st134hOpr3
	 */
	public void setSt134hOpr3(String st134hOpr3) {
		this.st134hOpr3 = st134hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st72hOpr6
	 */
	public void setSt72hOpr6(String st72hOpr6) {
		this.st72hOpr6 = st72hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st134hOpr4
	 */
	public void setSt134hOpr4(String st134hOpr4) {
		this.st134hOpr4 = st134hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st72hOpr7
	 */
	public void setSt72hOpr7(String st72hOpr7) {
		this.st72hOpr7 = st72hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st134hOpr5
	 */
	public void setSt134hOpr5(String st134hOpr5) {
		this.st134hOpr5 = st134hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st72hOpr8
	 */
	public void setSt72hOpr8(String st72hOpr8) {
		this.st72hOpr8 = st72hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st134hOpr6
	 */
	public void setSt134hOpr6(String st134hOpr6) {
		this.st134hOpr6 = st134hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st72hOpr9
	 */
	public void setSt72hOpr9(String st72hOpr9) {
		this.st72hOpr9 = st72hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st134hOpr7
	 */
	public void setSt134hOpr7(String st134hOpr7) {
		this.st134hOpr7 = st134hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st134hOpr8
	 */
	public void setSt134hOpr8(String st134hOpr8) {
		this.st134hOpr8 = st134hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st134hOpr9
	 */
	public void setSt134hOpr9(String st134hOpr9) {
		this.st134hOpr9 = st134hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st154hOpr1
	 */
	public void setSt154hOpr1(String st154hOpr1) {
		this.st154hOpr1 = st154hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st154hOpr3
	 */
	public void setSt154hOpr3(String st154hOpr3) {
		this.st154hOpr3 = st154hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st154hOpr2
	 */
	public void setSt154hOpr2(String st154hOpr2) {
		this.st154hOpr2 = st154hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st1440Opr9
	 */
	public void setSt1440Opr9(String st1440Opr9) {
		this.st1440Opr9 = st1440Opr9;
	}
	
	/**
	 * Column Info
	 * @param st1040Opr4
	 */
	public void setSt1040Opr4(String st1040Opr4) {
		this.st1040Opr4 = st1040Opr4;
	}
	
	/**
	 * Column Info
	 * @param st72hOpr2
	 */
	public void setSt72hOpr2(String st72hOpr2) {
		this.st72hOpr2 = st72hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st154hOpr5
	 */
	public void setSt154hOpr5(String st154hOpr5) {
		this.st154hOpr5 = st154hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st154hOpr4
	 */
	public void setSt154hOpr4(String st154hOpr4) {
		this.st154hOpr4 = st154hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st1040Opr3
	 */
	public void setSt1040Opr3(String st1040Opr3) {
		this.st1040Opr3 = st1040Opr3;
	}
	
	/**
	 * Column Info
	 * @param st72hOpr1
	 */
	public void setSt72hOpr1(String st72hOpr1) {
		this.st72hOpr1 = st72hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st72hOpr4
	 */
	public void setSt72hOpr4(String st72hOpr4) {
		this.st72hOpr4 = st72hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st1040Opr2
	 */
	public void setSt1040Opr2(String st1040Opr2) {
		this.st1040Opr2 = st1040Opr2;
	}
	
	/**
	 * Column Info
	 * @param st154hOpr7
	 */
	public void setSt154hOpr7(String st154hOpr7) {
		this.st154hOpr7 = st154hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st72hOpr3
	 */
	public void setSt72hOpr3(String st72hOpr3) {
		this.st72hOpr3 = st72hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st1040Opr1
	 */
	public void setSt1040Opr1(String st1040Opr1) {
		this.st1040Opr1 = st1040Opr1;
	}
	
	/**
	 * Column Info
	 * @param st154hOpr6
	 */
	public void setSt154hOpr6(String st154hOpr6) {
		this.st154hOpr6 = st154hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st1440Opr4
	 */
	public void setSt1440Opr4(String st1440Opr4) {
		this.st1440Opr4 = st1440Opr4;
	}
	
	/**
	 * Column Info
	 * @param st1440Opr3
	 */
	public void setSt1440Opr3(String st1440Opr3) {
		this.st1440Opr3 = st1440Opr3;
	}
	
	/**
	 * Column Info
	 * @param st1440Opr2
	 */
	public void setSt1440Opr2(String st1440Opr2) {
		this.st1440Opr2 = st1440Opr2;
	}
	
	/**
	 * Column Info
	 * @param st1440Opr1
	 */
	public void setSt1440Opr1(String st1440Opr1) {
		this.st1440Opr1 = st1440Opr1;
	}
	
	/**
	 * Column Info
	 * @param st1440Opr8
	 */
	public void setSt1440Opr8(String st1440Opr8) {
		this.st1440Opr8 = st1440Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1440Opr7
	 */
	public void setSt1440Opr7(String st1440Opr7) {
		this.st1440Opr7 = st1440Opr7;
	}
	
	/**
	 * Column Info
	 * @param st1440Opr6
	 */
	public void setSt1440Opr6(String st1440Opr6) {
		this.st1440Opr6 = st1440Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1440Opr5
	 */
	public void setSt1440Opr5(String st1440Opr5) {
		this.st1440Opr5 = st1440Opr5;
	}
	
	/**
	 * Column Info
	 * @param st102hOpr1
	 */
	public void setSt102hOpr1(String st102hOpr1) {
		this.st102hOpr1 = st102hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st102hOpr2
	 */
	public void setSt102hOpr2(String st102hOpr2) {
		this.st102hOpr2 = st102hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st102hOpr7
	 */
	public void setSt102hOpr7(String st102hOpr7) {
		this.st102hOpr7 = st102hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st102hOpr8
	 */
	public void setSt102hOpr8(String st102hOpr8) {
		this.st102hOpr8 = st102hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st102hOpr9
	 */
	public void setSt102hOpr9(String st102hOpr9) {
		this.st102hOpr9 = st102hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st102hOpr3
	 */
	public void setSt102hOpr3(String st102hOpr3) {
		this.st102hOpr3 = st102hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st102hOpr4
	 */
	public void setSt102hOpr4(String st102hOpr4) {
		this.st102hOpr4 = st102hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st102hOpr5
	 */
	public void setSt102hOpr5(String st102hOpr5) {
		this.st102hOpr5 = st102hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st102hOpr6
	 */
	public void setSt102hOpr6(String st102hOpr6) {
		this.st102hOpr6 = st102hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st320Opr10
	 */
	public void setSt320Opr10(String st320Opr10) {
		this.st320Opr10 = st320Opr10;
	}
	
	/**
	 * Column Info
	 * @param st1020Opr3
	 */
	public void setSt1020Opr3(String st1020Opr3) {
		this.st1020Opr3 = st1020Opr3;
	}
	
	/**
	 * Column Info
	 * @param st1020Opr4
	 */
	public void setSt1020Opr4(String st1020Opr4) {
		this.st1020Opr4 = st1020Opr4;
	}
	
	/**
	 * Column Info
	 * @param st1020Opr5
	 */
	public void setSt1020Opr5(String st1020Opr5) {
		this.st1020Opr5 = st1020Opr5;
	}
	
	/**
	 * Column Info
	 * @param st1020Opr6
	 */
	public void setSt1020Opr6(String st1020Opr6) {
		this.st1020Opr6 = st1020Opr6;
	}
	
	/**
	 * Column Info
	 * @param st1240Opr2
	 */
	public void setSt1240Opr2(String st1240Opr2) {
		this.st1240Opr2 = st1240Opr2;
	}
	
	/**
	 * Column Info
	 * @param st1020Opr7
	 */
	public void setSt1020Opr7(String st1020Opr7) {
		this.st1020Opr7 = st1020Opr7;
	}
	
	/**
	 * Column Info
	 * @param st1240Opr1
	 */
	public void setSt1240Opr1(String st1240Opr1) {
		this.st1240Opr1 = st1240Opr1;
	}
	
	/**
	 * Column Info
	 * @param st1020Opr8
	 */
	public void setSt1020Opr8(String st1020Opr8) {
		this.st1020Opr8 = st1020Opr8;
	}
	
	/**
	 * Column Info
	 * @param st1020Opr9
	 */
	public void setSt1020Opr9(String st1020Opr9) {
		this.st1020Opr9 = st1020Opr9;
	}
	
	/**
	 * Column Info
	 * @param st1240Opr10
	 */
	public void setSt1240Opr10(String st1240Opr10) {
		this.st1240Opr10 = st1240Opr10;
	}
	
	/**
	 * Column Info
	 * @param st14hOpr9
	 */
	public void setSt14hOpr9(String st14hOpr9) {
		this.st14hOpr9 = st14hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st1140Opr10
	 */
	public void setSt1140Opr10(String st1140Opr10) {
		this.st1140Opr10 = st1140Opr10;
	}
	
	/**
	 * Column Info
	 * @param st14hOpr5
	 */
	public void setSt14hOpr5(String st14hOpr5) {
		this.st14hOpr5 = st14hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st14hOpr6
	 */
	public void setSt14hOpr6(String st14hOpr6) {
		this.st14hOpr6 = st14hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st14hOpr7
	 */
	public void setSt14hOpr7(String st14hOpr7) {
		this.st14hOpr7 = st14hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st14hOpr8
	 */
	public void setSt14hOpr8(String st14hOpr8) {
		this.st14hOpr8 = st14hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st14hOpr1
	 */
	public void setSt14hOpr1(String st14hOpr1) {
		this.st14hOpr1 = st14hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st14hOpr2
	 */
	public void setSt14hOpr2(String st14hOpr2) {
		this.st14hOpr2 = st14hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st14hOpr3
	 */
	public void setSt14hOpr3(String st14hOpr3) {
		this.st14hOpr3 = st14hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st14hOpr4
	 */
	public void setSt14hOpr4(String st14hOpr4) {
		this.st14hOpr4 = st14hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st840Opr10
	 */
	public void setSt840Opr10(String st840Opr10) {
		this.st840Opr10 = st840Opr10;
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
	 * @param st102hOpr10
	 */
	public void setSt102hOpr10(String st102hOpr10) {
		this.st102hOpr10 = st102hOpr10;
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
	 * @param st42hOpr1
	 */
	public void setSt42hOpr1(String st42hOpr1) {
		this.st42hOpr1 = st42hOpr1;
	}
	
	/**
	 * Column Info
	 * @param st1040Opr9
	 */
	public void setSt1040Opr9(String st1040Opr9) {
		this.st1040Opr9 = st1040Opr9;
	}
	
	/**
	 * Column Info
	 * @param st42hOpr3
	 */
	public void setSt42hOpr3(String st42hOpr3) {
		this.st42hOpr3 = st42hOpr3;
	}
	
	/**
	 * Column Info
	 * @param st42hOpr2
	 */
	public void setSt42hOpr2(String st42hOpr2) {
		this.st42hOpr2 = st42hOpr2;
	}
	
	/**
	 * Column Info
	 * @param st42hOpr5
	 */
	public void setSt42hOpr5(String st42hOpr5) {
		this.st42hOpr5 = st42hOpr5;
	}
	
	/**
	 * Column Info
	 * @param st1040Opr6
	 */
	public void setSt1040Opr6(String st1040Opr6) {
		this.st1040Opr6 = st1040Opr6;
	}
	
	/**
	 * Column Info
	 * @param st220Opr10
	 */
	public void setSt220Opr10(String st220Opr10) {
		this.st220Opr10 = st220Opr10;
	}
	
	/**
	 * Column Info
	 * @param st42hOpr4
	 */
	public void setSt42hOpr4(String st42hOpr4) {
		this.st42hOpr4 = st42hOpr4;
	}
	
	/**
	 * Column Info
	 * @param st1040Opr5
	 */
	public void setSt1040Opr5(String st1040Opr5) {
		this.st1040Opr5 = st1040Opr5;
	}
	
	/**
	 * Column Info
	 * @param st42hOpr7
	 */
	public void setSt42hOpr7(String st42hOpr7) {
		this.st42hOpr7 = st42hOpr7;
	}
	
	/**
	 * Column Info
	 * @param st1040Opr8
	 */
	public void setSt1040Opr8(String st1040Opr8) {
		this.st1040Opr8 = st1040Opr8;
	}
	
	/**
	 * Column Info
	 * @param st42hOpr6
	 */
	public void setSt42hOpr6(String st42hOpr6) {
		this.st42hOpr6 = st42hOpr6;
	}
	
	/**
	 * Column Info
	 * @param st1040Opr7
	 */
	public void setSt1040Opr7(String st1040Opr7) {
		this.st1040Opr7 = st1040Opr7;
	}
	
	/**
	 * Column Info
	 * @param st745Opr3
	 */
	public void setSt745Opr3(String st745Opr3) {
		this.st745Opr3 = st745Opr3;
	}
	
	/**
	 * Column Info
	 * @param st745Opr2
	 */
	public void setSt745Opr2(String st745Opr2) {
		this.st745Opr2 = st745Opr2;
	}
	
	/**
	 * Column Info
	 * @param st745Opr5
	 */
	public void setSt745Opr5(String st745Opr5) {
		this.st745Opr5 = st745Opr5;
	}
	
	/**
	 * Column Info
	 * @param st745Opr4
	 */
	public void setSt745Opr4(String st745Opr4) {
		this.st745Opr4 = st745Opr4;
	}
	
	/**
	 * Column Info
	 * @param st745Opr7
	 */
	public void setSt745Opr7(String st745Opr7) {
		this.st745Opr7 = st745Opr7;
	}
	
	/**
	 * Column Info
	 * @param st745Opr6
	 */
	public void setSt745Opr6(String st745Opr6) {
		this.st745Opr6 = st745Opr6;
	}
	
	/**
	 * Column Info
	 * @param st745Opr9
	 */
	public void setSt745Opr9(String st745Opr9) {
		this.st745Opr9 = st745Opr9;
	}
	
	/**
	 * Column Info
	 * @param st745Opr8
	 */
	public void setSt745Opr8(String st745Opr8) {
		this.st745Opr8 = st745Opr8;
	}
	
	/**
	 * Column Info
	 * @param st42hOpr8
	 */
	public void setSt42hOpr8(String st42hOpr8) {
		this.st42hOpr8 = st42hOpr8;
	}
	
	/**
	 * Column Info
	 * @param st42hOpr9
	 */
	public void setSt42hOpr9(String st42hOpr9) {
		this.st42hOpr9 = st42hOpr9;
	}
	
	/**
	 * Column Info
	 * @param st745Opr1
	 */
	public void setSt745Opr1(String st745Opr1) {
		this.st745Opr1 = st745Opr1;
	}
	
	/**
	 * Column Info
	 * @param st114hOpr10
	 */
	public void setSt114hOpr10(String st114hOpr10) {
		this.st114hOpr10 = st114hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st140Opr6
	 */
	public void setSt140Opr6(String st140Opr6) {
		this.st140Opr6 = st140Opr6;
	}
	
	/**
	 * Column Info
	 * @param st140Opr5
	 */
	public void setSt140Opr5(String st140Opr5) {
		this.st140Opr5 = st140Opr5;
	}
	
	/**
	 * Column Info
	 * @param st140Opr8
	 */
	public void setSt140Opr8(String st140Opr8) {
		this.st140Opr8 = st140Opr8;
	}
	
	/**
	 * Column Info
	 * @param st140Opr7
	 */
	public void setSt140Opr7(String st140Opr7) {
		this.st140Opr7 = st140Opr7;
	}
	
	/**
	 * Column Info
	 * @param st140Opr9
	 */
	public void setSt140Opr9(String st140Opr9) {
		this.st140Opr9 = st140Opr9;
	}
	
	/**
	 * Column Info
	 * @param st142hOpr10
	 */
	public void setSt142hOpr10(String st142hOpr10) {
		this.st142hOpr10 = st142hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st140Opr1
	 */
	public void setSt140Opr1(String st140Opr1) {
		this.st140Opr1 = st140Opr1;
	}
	
	/**
	 * Column Info
	 * @param st140Opr2
	 */
	public void setSt140Opr2(String st140Opr2) {
		this.st140Opr2 = st140Opr2;
	}
	
	/**
	 * Column Info
	 * @param st140Opr3
	 */
	public void setSt140Opr3(String st140Opr3) {
		this.st140Opr3 = st140Opr3;
	}
	
	/**
	 * Column Info
	 * @param st54hOpr10
	 */
	public void setSt54hOpr10(String st54hOpr10) {
		this.st54hOpr10 = st54hOpr10;
	}
	
	/**
	 * Column Info
	 * @param st140Opr4
	 */
	public void setSt140Opr4(String st140Opr4) {
		this.st140Opr4 = st140Opr4;
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
		setSt720Opr10(JSPUtil.getParameter(request, prefix + "st7_20_opr10", ""));
		setSt740Opr7(JSPUtil.getParameter(request, prefix + "st7_40_opr7", ""));
		setSt1445Opr10(JSPUtil.getParameter(request, prefix + "st14_45_opr10", ""));
		setSt740Opr8(JSPUtil.getParameter(request, prefix + "st7_40_opr8", ""));
		setSt740Opr9(JSPUtil.getParameter(request, prefix + "st7_40_opr9", ""));
		setSt140Opr10(JSPUtil.getParameter(request, prefix + "st1_40_opr10", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSt740Opr1(JSPUtil.getParameter(request, prefix + "st7_40_opr1", ""));
		setSt740Opr2(JSPUtil.getParameter(request, prefix + "st7_40_opr2", ""));
		setSt740Opr3(JSPUtil.getParameter(request, prefix + "st7_40_opr3", ""));
		setSt740Opr4(JSPUtil.getParameter(request, prefix + "st7_40_opr4", ""));
		setSt740Opr5(JSPUtil.getParameter(request, prefix + "st7_40_opr5", ""));
		setSt740Opr6(JSPUtil.getParameter(request, prefix + "st7_40_opr6", ""));
		setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
		setSt145Opr10(JSPUtil.getParameter(request, prefix + "st1_45_opr10", ""));
		setSt1545Opr10(JSPUtil.getParameter(request, prefix + "st15_45_opr10", ""));
		setSt640Opr10(JSPUtil.getParameter(request, prefix + "st6_40_opr10", ""));
		setSt1340Opr10(JSPUtil.getParameter(request, prefix + "st13_40_opr10", ""));
		setSt520Opr10(JSPUtil.getParameter(request, prefix + "st5_20_opr10", ""));
		setSt154hOpr10(JSPUtil.getParameter(request, prefix + "st15_4h_opr10", ""));
		setSt82hOpr10(JSPUtil.getParameter(request, prefix + "st8_2h_opr10", ""));
		setSt845Opr10(JSPUtil.getParameter(request, prefix + "st8_45_opr10", ""));
		setSt645Opr3(JSPUtil.getParameter(request, prefix + "st6_45_opr3", ""));
		setSt645Opr4(JSPUtil.getParameter(request, prefix + "st6_45_opr4", ""));
		setSt645Opr5(JSPUtil.getParameter(request, prefix + "st6_45_opr5", ""));
		setSt545Opr8(JSPUtil.getParameter(request, prefix + "st5_45_opr8", ""));
		setSt645Opr6(JSPUtil.getParameter(request, prefix + "st6_45_opr6", ""));
		setSt545Opr9(JSPUtil.getParameter(request, prefix + "st5_45_opr9", ""));
		setSt545Opr6(JSPUtil.getParameter(request, prefix + "st5_45_opr6", ""));
		setSt645Opr7(JSPUtil.getParameter(request, prefix + "st6_45_opr7", ""));
		setSt545Opr7(JSPUtil.getParameter(request, prefix + "st5_45_opr7", ""));
		setSt645Opr8(JSPUtil.getParameter(request, prefix + "st6_45_opr8", ""));
		setSt545Opr4(JSPUtil.getParameter(request, prefix + "st5_45_opr4", ""));
		setSt645Opr9(JSPUtil.getParameter(request, prefix + "st6_45_opr9", ""));
		setSt545Opr5(JSPUtil.getParameter(request, prefix + "st5_45_opr5", ""));
		setSt545Opr2(JSPUtil.getParameter(request, prefix + "st5_45_opr2", ""));
		setSt545Opr3(JSPUtil.getParameter(request, prefix + "st5_45_opr3", ""));
		setSt1145Opr10(JSPUtil.getParameter(request, prefix + "st11_45_opr10", ""));
		setSt545Opr1(JSPUtil.getParameter(request, prefix + "st5_45_opr1", ""));
		setSt645Opr1(JSPUtil.getParameter(request, prefix + "st6_45_opr1", ""));
		setSt645Opr2(JSPUtil.getParameter(request, prefix + "st6_45_opr2", ""));
		setSt114hOpr8(JSPUtil.getParameter(request, prefix + "st11_4h_opr8", ""));
		setSt114hOpr9(JSPUtil.getParameter(request, prefix + "st11_4h_opr9", ""));
		setSt114hOpr4(JSPUtil.getParameter(request, prefix + "st11_4h_opr4", ""));
		setSt114hOpr5(JSPUtil.getParameter(request, prefix + "st11_4h_opr5", ""));
		setSt114hOpr6(JSPUtil.getParameter(request, prefix + "st11_4h_opr6", ""));
		setSt114hOpr7(JSPUtil.getParameter(request, prefix + "st11_4h_opr7", ""));
		setSt114hOpr1(JSPUtil.getParameter(request, prefix + "st11_4h_opr1", ""));
		setSt114hOpr2(JSPUtil.getParameter(request, prefix + "st11_4h_opr2", ""));
		setSt114hOpr3(JSPUtil.getParameter(request, prefix + "st11_4h_opr3", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setSt745Opr10(JSPUtil.getParameter(request, prefix + "st7_45_opr10", ""));
		setSt1320Opr10(JSPUtil.getParameter(request, prefix + "st13_20_opr10", ""));
		setSt122hOpr1(JSPUtil.getParameter(request, prefix + "st12_2h_opr1", ""));
		setSt122hOpr2(JSPUtil.getParameter(request, prefix + "st12_2h_opr2", ""));
		setSt122hOpr3(JSPUtil.getParameter(request, prefix + "st12_2h_opr3", ""));
		setSt122hOpr4(JSPUtil.getParameter(request, prefix + "st12_2h_opr4", ""));
		setSt122hOpr5(JSPUtil.getParameter(request, prefix + "st12_2h_opr5", ""));
		setSt122hOpr6(JSPUtil.getParameter(request, prefix + "st12_2h_opr6", ""));
		setSt122hOpr7(JSPUtil.getParameter(request, prefix + "st12_2h_opr7", ""));
		setSt122hOpr8(JSPUtil.getParameter(request, prefix + "st12_2h_opr8", ""));
		setSt845Opr5(JSPUtil.getParameter(request, prefix + "st8_45_opr5", ""));
		setSt104hOpr6(JSPUtil.getParameter(request, prefix + "st10_4h_opr6", ""));
		setSt1445Opr9(JSPUtil.getParameter(request, prefix + "st14_45_opr9", ""));
		setSt104hOpr5(JSPUtil.getParameter(request, prefix + "st10_4h_opr5", ""));
		setSt845Opr6(JSPUtil.getParameter(request, prefix + "st8_45_opr6", ""));
		setSt1445Opr8(JSPUtil.getParameter(request, prefix + "st14_45_opr8", ""));
		setSt1145Opr1(JSPUtil.getParameter(request, prefix + "st11_45_opr1", ""));
		setSt845Opr7(JSPUtil.getParameter(request, prefix + "st8_45_opr7", ""));
		setSt104hOpr8(JSPUtil.getParameter(request, prefix + "st10_4h_opr8", ""));
		setSt1145Opr2(JSPUtil.getParameter(request, prefix + "st11_45_opr2", ""));
		setSt104hOpr7(JSPUtil.getParameter(request, prefix + "st10_4h_opr7", ""));
		setSt845Opr8(JSPUtil.getParameter(request, prefix + "st8_45_opr8", ""));
		setSt1145Opr3(JSPUtil.getParameter(request, prefix + "st11_45_opr3", ""));
		setSt845Opr1(JSPUtil.getParameter(request, prefix + "st8_45_opr1", ""));
		setSt1445Opr5(JSPUtil.getParameter(request, prefix + "st14_45_opr5", ""));
		setSt1445Opr4(JSPUtil.getParameter(request, prefix + "st14_45_opr4", ""));
		setSt1145Opr4(JSPUtil.getParameter(request, prefix + "st11_45_opr4", ""));
		setSt845Opr2(JSPUtil.getParameter(request, prefix + "st8_45_opr2", ""));
		setSt104hOpr9(JSPUtil.getParameter(request, prefix + "st10_4h_opr9", ""));
		setSt845Opr3(JSPUtil.getParameter(request, prefix + "st8_45_opr3", ""));
		setSt1145Opr5(JSPUtil.getParameter(request, prefix + "st11_45_opr5", ""));
		setSt1445Opr7(JSPUtil.getParameter(request, prefix + "st14_45_opr7", ""));
		setSt845Opr4(JSPUtil.getParameter(request, prefix + "st8_45_opr4", ""));
		setSt1145Opr6(JSPUtil.getParameter(request, prefix + "st11_45_opr6", ""));
		setSt1445Opr6(JSPUtil.getParameter(request, prefix + "st14_45_opr6", ""));
		setSt1445Opr1(JSPUtil.getParameter(request, prefix + "st14_45_opr1", ""));
		setSt1145Opr7(JSPUtil.getParameter(request, prefix + "st11_45_opr7", ""));
		setSt1145Opr8(JSPUtil.getParameter(request, prefix + "st11_45_opr8", ""));
		setSt1445Opr3(JSPUtil.getParameter(request, prefix + "st14_45_opr3", ""));
		setSt1145Opr9(JSPUtil.getParameter(request, prefix + "st11_45_opr9", ""));
		setSt1445Opr2(JSPUtil.getParameter(request, prefix + "st14_45_opr2", ""));
		setSt104hOpr2(JSPUtil.getParameter(request, prefix + "st10_4h_opr2", ""));
		setSt104hOpr1(JSPUtil.getParameter(request, prefix + "st10_4h_opr1", ""));
		setSt104hOpr4(JSPUtil.getParameter(request, prefix + "st10_4h_opr4", ""));
		setSt104hOpr3(JSPUtil.getParameter(request, prefix + "st10_4h_opr3", ""));
		setSt845Opr9(JSPUtil.getParameter(request, prefix + "st8_45_opr9", ""));
		setSt34hOpr2(JSPUtil.getParameter(request, prefix + "st3_4h_opr2", ""));
		setSt34hOpr1(JSPUtil.getParameter(request, prefix + "st3_4h_opr1", ""));
		setSt34hOpr4(JSPUtil.getParameter(request, prefix + "st3_4h_opr4", ""));
		setSt34hOpr3(JSPUtil.getParameter(request, prefix + "st3_4h_opr3", ""));
		setSt34hOpr6(JSPUtil.getParameter(request, prefix + "st3_4h_opr6", ""));
		setSt34hOpr5(JSPUtil.getParameter(request, prefix + "st3_4h_opr5", ""));
		setSt34hOpr8(JSPUtil.getParameter(request, prefix + "st3_4h_opr8", ""));
		setSt34hOpr7(JSPUtil.getParameter(request, prefix + "st3_4h_opr7", ""));
		setSt34hOpr9(JSPUtil.getParameter(request, prefix + "st3_4h_opr9", ""));
		setSt1345Opr3(JSPUtil.getParameter(request, prefix + "st13_45_opr3", ""));
		setSt1345Opr4(JSPUtil.getParameter(request, prefix + "st13_45_opr4", ""));
		setSt1345Opr1(JSPUtil.getParameter(request, prefix + "st13_45_opr1", ""));
		setSt1345Opr2(JSPUtil.getParameter(request, prefix + "st13_45_opr2", ""));
		setSt1345Opr9(JSPUtil.getParameter(request, prefix + "st13_45_opr9", ""));
		setSt1345Opr7(JSPUtil.getParameter(request, prefix + "st13_45_opr7", ""));
		setSt1345Opr8(JSPUtil.getParameter(request, prefix + "st13_45_opr8", ""));
		setSt1345Opr5(JSPUtil.getParameter(request, prefix + "st13_45_opr5", ""));
		setSt1345Opr6(JSPUtil.getParameter(request, prefix + "st13_45_opr6", ""));
		setSt12hOpr10(JSPUtil.getParameter(request, prefix + "st1_2h_opr10", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setSt545Opr10(JSPUtil.getParameter(request, prefix + "st5_45_opr10", ""));
		setSt152hOpr8(JSPUtil.getParameter(request, prefix + "st15_2h_opr8", ""));
		setSt152hOpr9(JSPUtil.getParameter(request, prefix + "st15_2h_opr9", ""));
		setSt152hOpr6(JSPUtil.getParameter(request, prefix + "st15_2h_opr6", ""));
		setSt152hOpr7(JSPUtil.getParameter(request, prefix + "st15_2h_opr7", ""));
		setSt1140Opr1(JSPUtil.getParameter(request, prefix + "st11_40_opr1", ""));
		setSt1140Opr2(JSPUtil.getParameter(request, prefix + "st11_40_opr2", ""));
		setSt1140Opr3(JSPUtil.getParameter(request, prefix + "st11_40_opr3", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setSt1420Opr10(JSPUtil.getParameter(request, prefix + "st14_20_opr10", ""));
		setSt142hOpr8(JSPUtil.getParameter(request, prefix + "st14_2h_opr8", ""));
		setSt142hOpr7(JSPUtil.getParameter(request, prefix + "st14_2h_opr7", ""));
		setSt142hOpr9(JSPUtil.getParameter(request, prefix + "st14_2h_opr9", ""));
		setSt74hOpr9(JSPUtil.getParameter(request, prefix + "st7_4h_opr9", ""));
		setSt74hOpr7(JSPUtil.getParameter(request, prefix + "st7_4h_opr7", ""));
		setSt74hOpr8(JSPUtil.getParameter(request, prefix + "st7_4h_opr8", ""));
		setSt74hOpr6(JSPUtil.getParameter(request, prefix + "st7_4h_opr6", ""));
		setSt1220Opr9(JSPUtil.getParameter(request, prefix + "st12_20_opr9", ""));
		setSt74hOpr5(JSPUtil.getParameter(request, prefix + "st7_4h_opr5", ""));
		setSt74hOpr4(JSPUtil.getParameter(request, prefix + "st7_4h_opr4", ""));
		setSt74hOpr3(JSPUtil.getParameter(request, prefix + "st7_4h_opr3", ""));
		setSt74hOpr2(JSPUtil.getParameter(request, prefix + "st7_4h_opr2", ""));
		setSt74hOpr1(JSPUtil.getParameter(request, prefix + "st7_4h_opr1", ""));
		setOpr10(JSPUtil.getParameter(request, prefix + "opr10", ""));
		setSt1220Opr1(JSPUtil.getParameter(request, prefix + "st12_20_opr1", ""));
		setSt1220Opr2(JSPUtil.getParameter(request, prefix + "st12_20_opr2", ""));
		setSt1220Opr3(JSPUtil.getParameter(request, prefix + "st12_20_opr3", ""));
		setSt1220Opr4(JSPUtil.getParameter(request, prefix + "st12_20_opr4", ""));
		setSt1220Opr5(JSPUtil.getParameter(request, prefix + "st12_20_opr5", ""));
		setSt1220Opr6(JSPUtil.getParameter(request, prefix + "st12_20_opr6", ""));
		setSt1220Opr7(JSPUtil.getParameter(request, prefix + "st12_20_opr7", ""));
		setSt124hOpr10(JSPUtil.getParameter(request, prefix + "st12_4h_opr10", ""));
		setSt1220Opr8(JSPUtil.getParameter(request, prefix + "st12_20_opr8", ""));
		setSt82hOpr7(JSPUtil.getParameter(request, prefix + "st8_2h_opr7", ""));
		setSt82hOpr6(JSPUtil.getParameter(request, prefix + "st8_2h_opr6", ""));
		setSt82hOpr5(JSPUtil.getParameter(request, prefix + "st8_2h_opr5", ""));
		setSt82hOpr4(JSPUtil.getParameter(request, prefix + "st8_2h_opr4", ""));
		setSt82hOpr9(JSPUtil.getParameter(request, prefix + "st8_2h_opr9", ""));
		setSt82hOpr8(JSPUtil.getParameter(request, prefix + "st8_2h_opr8", ""));
		setSt82hOpr2(JSPUtil.getParameter(request, prefix + "st8_2h_opr2", ""));
		setSt82hOpr3(JSPUtil.getParameter(request, prefix + "st8_2h_opr3", ""));
		setSt82hOpr1(JSPUtil.getParameter(request, prefix + "st8_2h_opr1", ""));
		setSt92hOpr3(JSPUtil.getParameter(request, prefix + "st9_2h_opr3", ""));
		setSt92hOpr4(JSPUtil.getParameter(request, prefix + "st9_2h_opr4", ""));
		setSt92hOpr5(JSPUtil.getParameter(request, prefix + "st9_2h_opr5", ""));
		setSt92hOpr6(JSPUtil.getParameter(request, prefix + "st9_2h_opr6", ""));
		setSt92hOpr7(JSPUtil.getParameter(request, prefix + "st9_2h_opr7", ""));
		setSt92hOpr8(JSPUtil.getParameter(request, prefix + "st9_2h_opr8", ""));
		setSt92hOpr9(JSPUtil.getParameter(request, prefix + "st9_2h_opr9", ""));
		setSt1020Opr10(JSPUtil.getParameter(request, prefix + "st10_20_opr10", ""));
		setSt1140Opr9(JSPUtil.getParameter(request, prefix + "st11_40_opr9", ""));
		setSt1140Opr8(JSPUtil.getParameter(request, prefix + "st11_40_opr8", ""));
		setSt1140Opr7(JSPUtil.getParameter(request, prefix + "st11_40_opr7", ""));
		setSt1140Opr6(JSPUtil.getParameter(request, prefix + "st11_40_opr6", ""));
		setSt1140Opr5(JSPUtil.getParameter(request, prefix + "st11_40_opr5", ""));
		setSt1140Opr4(JSPUtil.getParameter(request, prefix + "st11_40_opr4", ""));
		setSt245Opr3(JSPUtil.getParameter(request, prefix + "st2_45_opr3", ""));
		setSt245Opr4(JSPUtil.getParameter(request, prefix + "st2_45_opr4", ""));
		setSt740Opr10(JSPUtil.getParameter(request, prefix + "st7_40_opr10", ""));
		setSt245Opr5(JSPUtil.getParameter(request, prefix + "st2_45_opr5", ""));
		setSt152hOpr1(JSPUtil.getParameter(request, prefix + "st15_2h_opr1", ""));
		setSt245Opr6(JSPUtil.getParameter(request, prefix + "st2_45_opr6", ""));
		setSt152hOpr3(JSPUtil.getParameter(request, prefix + "st15_2h_opr3", ""));
		setSt152hOpr2(JSPUtil.getParameter(request, prefix + "st15_2h_opr2", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setSt245Opr1(JSPUtil.getParameter(request, prefix + "st2_45_opr1", ""));
		setSt152hOpr5(JSPUtil.getParameter(request, prefix + "st15_2h_opr5", ""));
		setSt152hOpr4(JSPUtil.getParameter(request, prefix + "st15_2h_opr4", ""));
		setSt245Opr2(JSPUtil.getParameter(request, prefix + "st2_45_opr2", ""));
		setSt245Opr7(JSPUtil.getParameter(request, prefix + "st2_45_opr7", ""));
		setSt920Opr10(JSPUtil.getParameter(request, prefix + "st9_20_opr10", ""));
		setSt245Opr8(JSPUtil.getParameter(request, prefix + "st2_45_opr8", ""));
		setSt92hOpr2(JSPUtil.getParameter(request, prefix + "st9_2h_opr2", ""));
		setSt245Opr9(JSPUtil.getParameter(request, prefix + "st2_45_opr9", ""));
		setSt92hOpr1(JSPUtil.getParameter(request, prefix + "st9_2h_opr1", ""));
		setSt52hOpr2(JSPUtil.getParameter(request, prefix + "st5_2h_opr2", ""));
		setSt52hOpr1(JSPUtil.getParameter(request, prefix + "st5_2h_opr1", ""));
		setSt52hOpr6(JSPUtil.getParameter(request, prefix + "st5_2h_opr6", ""));
		setSt52hOpr5(JSPUtil.getParameter(request, prefix + "st5_2h_opr5", ""));
		setSt52hOpr4(JSPUtil.getParameter(request, prefix + "st5_2h_opr4", ""));
		setSt52hOpr3(JSPUtil.getParameter(request, prefix + "st5_2h_opr3", ""));
		setSt144hOpr10(JSPUtil.getParameter(request, prefix + "st14_4h_opr10", ""));
		setCrrCd(JSPUtil.getParameter(request, prefix + "crr_cd", ""));
		setSt52hOpr9(JSPUtil.getParameter(request, prefix + "st5_2h_opr9", ""));
		setSt52hOpr7(JSPUtil.getParameter(request, prefix + "st5_2h_opr7", ""));
		setSt52hOpr8(JSPUtil.getParameter(request, prefix + "st5_2h_opr8", ""));
		setSt122hOpr9(JSPUtil.getParameter(request, prefix + "st12_2h_opr9", ""));
		setSt124hOpr4(JSPUtil.getParameter(request, prefix + "st12_4h_opr4", ""));
		setSt940Opr2(JSPUtil.getParameter(request, prefix + "st9_40_opr2", ""));
		setSt124hOpr3(JSPUtil.getParameter(request, prefix + "st12_4h_opr3", ""));
		setSt940Opr1(JSPUtil.getParameter(request, prefix + "st9_40_opr1", ""));
		setSt940Opr4(JSPUtil.getParameter(request, prefix + "st9_40_opr4", ""));
		setSt124hOpr6(JSPUtil.getParameter(request, prefix + "st12_4h_opr6", ""));
		setSt940Opr3(JSPUtil.getParameter(request, prefix + "st9_40_opr3", ""));
		setSt124hOpr5(JSPUtil.getParameter(request, prefix + "st12_4h_opr5", ""));
		setSt124hOpr8(JSPUtil.getParameter(request, prefix + "st12_4h_opr8", ""));
		setSt124hOpr7(JSPUtil.getParameter(request, prefix + "st12_4h_opr7", ""));
		setSt245Opr10(JSPUtil.getParameter(request, prefix + "st2_45_opr10", ""));
		setSt124hOpr9(JSPUtil.getParameter(request, prefix + "st12_4h_opr9", ""));
		setSt940Opr9(JSPUtil.getParameter(request, prefix + "st9_40_opr9", ""));
		setSt940Opr6(JSPUtil.getParameter(request, prefix + "st9_40_opr6", ""));
		setSt940Opr5(JSPUtil.getParameter(request, prefix + "st9_40_opr5", ""));
		setSt124hOpr2(JSPUtil.getParameter(request, prefix + "st12_4h_opr2", ""));
		setSt940Opr8(JSPUtil.getParameter(request, prefix + "st9_40_opr8", ""));
		setSt32hOpr10(JSPUtil.getParameter(request, prefix + "st3_2h_opr10", ""));
		setSt124hOpr1(JSPUtil.getParameter(request, prefix + "st12_4h_opr1", ""));
		setSt940Opr7(JSPUtil.getParameter(request, prefix + "st9_40_opr7", ""));
		setSt142hOpr6(JSPUtil.getParameter(request, prefix + "st14_2h_opr6", ""));
		setSt142hOpr5(JSPUtil.getParameter(request, prefix + "st14_2h_opr5", ""));
		setSt142hOpr4(JSPUtil.getParameter(request, prefix + "st14_2h_opr4", ""));
		setSt142hOpr3(JSPUtil.getParameter(request, prefix + "st14_2h_opr3", ""));
		setSt142hOpr2(JSPUtil.getParameter(request, prefix + "st14_2h_opr2", ""));
		setSt142hOpr1(JSPUtil.getParameter(request, prefix + "st14_2h_opr1", ""));
		setSt94hOpr1(JSPUtil.getParameter(request, prefix + "st9_4h_opr1", ""));
		setSt94hOpr2(JSPUtil.getParameter(request, prefix + "st9_4h_opr2", ""));
		setSt94hOpr3(JSPUtil.getParameter(request, prefix + "st9_4h_opr3", ""));
		setSt94hOpr4(JSPUtil.getParameter(request, prefix + "st9_4h_opr4", ""));
		setSt1520Opr1(JSPUtil.getParameter(request, prefix + "st15_20_opr1", ""));
		setSt94hOpr9(JSPUtil.getParameter(request, prefix + "st9_4h_opr9", ""));
		setSt112hOpr1(JSPUtil.getParameter(request, prefix + "st11_2h_opr1", ""));
		setSt1520Opr5(JSPUtil.getParameter(request, prefix + "st15_20_opr5", ""));
		setSt94hOpr6(JSPUtil.getParameter(request, prefix + "st9_4h_opr6", ""));
		setSt1520Opr4(JSPUtil.getParameter(request, prefix + "st15_20_opr4", ""));
		setSt94hOpr5(JSPUtil.getParameter(request, prefix + "st9_4h_opr5", ""));
		setSt1520Opr3(JSPUtil.getParameter(request, prefix + "st15_20_opr3", ""));
		setSt94hOpr8(JSPUtil.getParameter(request, prefix + "st9_4h_opr8", ""));
		setSt1520Opr2(JSPUtil.getParameter(request, prefix + "st15_20_opr2", ""));
		setSt94hOpr7(JSPUtil.getParameter(request, prefix + "st9_4h_opr7", ""));
		setSt112hOpr6(JSPUtil.getParameter(request, prefix + "st11_2h_opr6", ""));
		setSt1520Opr9(JSPUtil.getParameter(request, prefix + "st15_20_opr9", ""));
		setSt112hOpr7(JSPUtil.getParameter(request, prefix + "st11_2h_opr7", ""));
		setSt1520Opr8(JSPUtil.getParameter(request, prefix + "st15_20_opr8", ""));
		setSt1520Opr7(JSPUtil.getParameter(request, prefix + "st15_20_opr7", ""));
		setSt112hOpr8(JSPUtil.getParameter(request, prefix + "st11_2h_opr8", ""));
		setSt1520Opr6(JSPUtil.getParameter(request, prefix + "st15_20_opr6", ""));
		setSt112hOpr9(JSPUtil.getParameter(request, prefix + "st11_2h_opr9", ""));
		setSt112hOpr2(JSPUtil.getParameter(request, prefix + "st11_2h_opr2", ""));
		setSt112hOpr3(JSPUtil.getParameter(request, prefix + "st11_2h_opr3", ""));
		setSt340Opr10(JSPUtil.getParameter(request, prefix + "st3_40_opr10", ""));
		setSt112hOpr4(JSPUtil.getParameter(request, prefix + "st11_2h_opr4", ""));
		setSt112hOpr5(JSPUtil.getParameter(request, prefix + "st11_2h_opr5", ""));
		setSt1120Opr7(JSPUtil.getParameter(request, prefix + "st11_20_opr7", ""));
		setSt1120Opr6(JSPUtil.getParameter(request, prefix + "st11_20_opr6", ""));
		setSt1120Opr9(JSPUtil.getParameter(request, prefix + "st11_20_opr9", ""));
		setSt1120Opr8(JSPUtil.getParameter(request, prefix + "st11_20_opr8", ""));
		setSt1120Opr3(JSPUtil.getParameter(request, prefix + "st11_20_opr3", ""));
		setSt1120Opr2(JSPUtil.getParameter(request, prefix + "st11_20_opr2", ""));
		setSt1120Opr5(JSPUtil.getParameter(request, prefix + "st11_20_opr5", ""));
		setSt1120Opr4(JSPUtil.getParameter(request, prefix + "st11_20_opr4", ""));
		setSt132hOpr4(JSPUtil.getParameter(request, prefix + "st13_2h_opr4", ""));
		setSt132hOpr5(JSPUtil.getParameter(request, prefix + "st13_2h_opr5", ""));
		setSt132hOpr6(JSPUtil.getParameter(request, prefix + "st13_2h_opr6", ""));
		setSt132hOpr7(JSPUtil.getParameter(request, prefix + "st13_2h_opr7", ""));
		setSt132hOpr1(JSPUtil.getParameter(request, prefix + "st13_2h_opr1", ""));
		setSt132hOpr2(JSPUtil.getParameter(request, prefix + "st13_2h_opr2", ""));
		setSt132hOpr3(JSPUtil.getParameter(request, prefix + "st13_2h_opr3", ""));
		setSt24hOpr10(JSPUtil.getParameter(request, prefix + "st2_4h_opr10", ""));
		setSt345Opr10(JSPUtil.getParameter(request, prefix + "st3_45_opr10", ""));
		setQty1(JSPUtil.getParameter(request, prefix + "qty1", ""));
		setQty3(JSPUtil.getParameter(request, prefix + "qty3", ""));
		setQty2(JSPUtil.getParameter(request, prefix + "qty2", ""));
		setQty5(JSPUtil.getParameter(request, prefix + "qty5", ""));
		setQty4(JSPUtil.getParameter(request, prefix + "qty4", ""));
		setSt720Opr7(JSPUtil.getParameter(request, prefix + "st7_20_opr7", ""));
		setSt720Opr8(JSPUtil.getParameter(request, prefix + "st7_20_opr8", ""));
		setSt720Opr5(JSPUtil.getParameter(request, prefix + "st7_20_opr5", ""));
		setSt720Opr6(JSPUtil.getParameter(request, prefix + "st7_20_opr6", ""));
		setSt720Opr9(JSPUtil.getParameter(request, prefix + "st7_20_opr9", ""));
		setSt34hOpr10(JSPUtil.getParameter(request, prefix + "st3_4h_opr10", ""));
		setSt62hOpr10(JSPUtil.getParameter(request, prefix + "st6_2h_opr10", ""));
		setSt1440Opr10(JSPUtil.getParameter(request, prefix + "st14_40_opr10", ""));
		setSt720Opr3(JSPUtil.getParameter(request, prefix + "st7_20_opr3", ""));
		setSt720Opr4(JSPUtil.getParameter(request, prefix + "st7_20_opr4", ""));
		setSt720Opr1(JSPUtil.getParameter(request, prefix + "st7_20_opr1", ""));
		setSt720Opr2(JSPUtil.getParameter(request, prefix + "st7_20_opr2", ""));
		setSt1045Opr10(JSPUtil.getParameter(request, prefix + "st10_45_opr10", ""));
		setSt1540Opr1(JSPUtil.getParameter(request, prefix + "st15_40_opr1", ""));
		setSt1540Opr2(JSPUtil.getParameter(request, prefix + "st15_40_opr2", ""));
		setSt1540Opr3(JSPUtil.getParameter(request, prefix + "st15_40_opr3", ""));
		setSt1540Opr4(JSPUtil.getParameter(request, prefix + "st15_40_opr4", ""));
		setSt1540Opr5(JSPUtil.getParameter(request, prefix + "st15_40_opr5", ""));
		setSt1540Opr6(JSPUtil.getParameter(request, prefix + "st15_40_opr6", ""));
		setSt1540Opr7(JSPUtil.getParameter(request, prefix + "st15_40_opr7", ""));
		setSt1540Opr8(JSPUtil.getParameter(request, prefix + "st15_40_opr8", ""));
		setSt1540Opr9(JSPUtil.getParameter(request, prefix + "st15_40_opr9", ""));
		setQty8(JSPUtil.getParameter(request, prefix + "qty8", ""));
		setSt1545Opr1(JSPUtil.getParameter(request, prefix + "st15_45_opr1", ""));
		setSt1545Opr2(JSPUtil.getParameter(request, prefix + "st15_45_opr2", ""));
		setQty9(JSPUtil.getParameter(request, prefix + "qty9", ""));
		setQty6(JSPUtil.getParameter(request, prefix + "qty6", ""));
		setSt420Opr10(JSPUtil.getParameter(request, prefix + "st4_20_opr10", ""));
		setQty7(JSPUtil.getParameter(request, prefix + "qty7", ""));
		setSt1545Opr5(JSPUtil.getParameter(request, prefix + "st15_45_opr5", ""));
		setSt1545Opr6(JSPUtil.getParameter(request, prefix + "st15_45_opr6", ""));
		setSt1545Opr3(JSPUtil.getParameter(request, prefix + "st15_45_opr3", ""));
		setSt1545Opr4(JSPUtil.getParameter(request, prefix + "st15_45_opr4", ""));
		setSt1545Opr9(JSPUtil.getParameter(request, prefix + "st15_45_opr9", ""));
		setSt1545Opr7(JSPUtil.getParameter(request, prefix + "st15_45_opr7", ""));
		setSt1545Opr8(JSPUtil.getParameter(request, prefix + "st15_45_opr8", ""));
		setSt1320Opr1(JSPUtil.getParameter(request, prefix + "st13_20_opr1", ""));
		setSt1320Opr3(JSPUtil.getParameter(request, prefix + "st13_20_opr3", ""));
		setSt132hOpr9(JSPUtil.getParameter(request, prefix + "st13_2h_opr9", ""));
		setSt1320Opr2(JSPUtil.getParameter(request, prefix + "st13_20_opr2", ""));
		setSt132hOpr8(JSPUtil.getParameter(request, prefix + "st13_2h_opr8", ""));
		setSt1320Opr5(JSPUtil.getParameter(request, prefix + "st13_20_opr5", ""));
		setSt1320Opr4(JSPUtil.getParameter(request, prefix + "st13_20_opr4", ""));
		setSt1320Opr7(JSPUtil.getParameter(request, prefix + "st13_20_opr7", ""));
		setSt1320Opr6(JSPUtil.getParameter(request, prefix + "st13_20_opr6", ""));
		setSt1320Opr9(JSPUtil.getParameter(request, prefix + "st13_20_opr9", ""));
		setSt1320Opr8(JSPUtil.getParameter(request, prefix + "st13_20_opr8", ""));
		setSt340Opr1(JSPUtil.getParameter(request, prefix + "st3_40_opr1", ""));
		setSt340Opr2(JSPUtil.getParameter(request, prefix + "st3_40_opr2", ""));
		setSt340Opr9(JSPUtil.getParameter(request, prefix + "st3_40_opr9", ""));
		setSt340Opr8(JSPUtil.getParameter(request, prefix + "st3_40_opr8", ""));
		setSt340Opr7(JSPUtil.getParameter(request, prefix + "st3_40_opr7", ""));
		setSt340Opr6(JSPUtil.getParameter(request, prefix + "st3_40_opr6", ""));
		setSt340Opr5(JSPUtil.getParameter(request, prefix + "st3_40_opr5", ""));
		setSt340Opr4(JSPUtil.getParameter(request, prefix + "st3_40_opr4", ""));
		setSt340Opr3(JSPUtil.getParameter(request, prefix + "st3_40_opr3", ""));
		setAllFlg(JSPUtil.getParameter(request, prefix + "all_flg", ""));
		setSt445Opr10(JSPUtil.getParameter(request, prefix + "st4_45_opr10", ""));
		setSt120Opr1(JSPUtil.getParameter(request, prefix + "st1_20_opr1", ""));
		setSt120Opr2(JSPUtil.getParameter(request, prefix + "st1_20_opr2", ""));
		setSt120Opr10(JSPUtil.getParameter(request, prefix + "st1_20_opr10", ""));
		setSt132hOpr10(JSPUtil.getParameter(request, prefix + "st13_2h_opr10", ""));
		setSt120Opr4(JSPUtil.getParameter(request, prefix + "st1_20_opr4", ""));
		setSt120Opr3(JSPUtil.getParameter(request, prefix + "st1_20_opr3", ""));
		setSt120Opr6(JSPUtil.getParameter(request, prefix + "st1_20_opr6", ""));
		setSt120Opr5(JSPUtil.getParameter(request, prefix + "st1_20_opr5", ""));
		setSt120Opr8(JSPUtil.getParameter(request, prefix + "st1_20_opr8", ""));
		setSt120Opr7(JSPUtil.getParameter(request, prefix + "st1_20_opr7", ""));
		setSt120Opr9(JSPUtil.getParameter(request, prefix + "st1_20_opr9", ""));
		setSt1040Opr10(JSPUtil.getParameter(request, prefix + "st10_40_opr10", ""));
		setSt92hOpr10(JSPUtil.getParameter(request, prefix + "st9_2h_opr10", ""));
		setSt1045Opr5(JSPUtil.getParameter(request, prefix + "st10_45_opr5", ""));
		setSt1045Opr4(JSPUtil.getParameter(request, prefix + "st10_45_opr4", ""));
		setSt1045Opr7(JSPUtil.getParameter(request, prefix + "st10_45_opr7", ""));
		setSt1045Opr6(JSPUtil.getParameter(request, prefix + "st10_45_opr6", ""));
		setSt1045Opr1(JSPUtil.getParameter(request, prefix + "st10_45_opr1", ""));
		setSt540Opr10(JSPUtil.getParameter(request, prefix + "st5_40_opr10", ""));
		setSt1045Opr3(JSPUtil.getParameter(request, prefix + "st10_45_opr3", ""));
		setBbCgoFlg(JSPUtil.getParameter(request, prefix + "bb_cgo_flg", ""));
		setSt1045Opr2(JSPUtil.getParameter(request, prefix + "st10_45_opr2", ""));
		setSt1045Opr9(JSPUtil.getParameter(request, prefix + "st10_45_opr9", ""));
		setSt1045Opr8(JSPUtil.getParameter(request, prefix + "st10_45_opr8", ""));
		setMlbCd(JSPUtil.getParameter(request, prefix + "mlb_cd", ""));
		setSt1520Opr10(JSPUtil.getParameter(request, prefix + "st15_20_opr10", ""));
		setSt345Opr7(JSPUtil.getParameter(request, prefix + "st3_45_opr7", ""));
		setSt345Opr6(JSPUtil.getParameter(request, prefix + "st3_45_opr6", ""));
		setSt345Opr9(JSPUtil.getParameter(request, prefix + "st3_45_opr9", ""));
		setSt345Opr8(JSPUtil.getParameter(request, prefix + "st3_45_opr8", ""));
		setSt1120Opr1(JSPUtil.getParameter(request, prefix + "st11_20_opr1", ""));
		setSt345Opr1(JSPUtil.getParameter(request, prefix + "st3_45_opr1", ""));
		setSt345Opr3(JSPUtil.getParameter(request, prefix + "st3_45_opr3", ""));
		setSt345Opr2(JSPUtil.getParameter(request, prefix + "st3_45_opr2", ""));
		setSt345Opr5(JSPUtil.getParameter(request, prefix + "st3_45_opr5", ""));
		setSt345Opr4(JSPUtil.getParameter(request, prefix + "st3_45_opr4", ""));
		setSt12hOpr2(JSPUtil.getParameter(request, prefix + "st1_2h_opr2", ""));
		setSt12hOpr1(JSPUtil.getParameter(request, prefix + "st1_2h_opr1", ""));
		setSt1340Opr1(JSPUtil.getParameter(request, prefix + "st13_40_opr1", ""));
		setSt12hOpr8(JSPUtil.getParameter(request, prefix + "st1_2h_opr8", ""));
		setSt12hOpr7(JSPUtil.getParameter(request, prefix + "st1_2h_opr7", ""));
		setSt12hOpr9(JSPUtil.getParameter(request, prefix + "st1_2h_opr9", ""));
		setSt12hOpr4(JSPUtil.getParameter(request, prefix + "st1_2h_opr4", ""));
		setSt12hOpr3(JSPUtil.getParameter(request, prefix + "st1_2h_opr3", ""));
		setSt12hOpr6(JSPUtil.getParameter(request, prefix + "st1_2h_opr6", ""));
		setSt12hOpr5(JSPUtil.getParameter(request, prefix + "st1_2h_opr5", ""));
		setSt1420Opr6(JSPUtil.getParameter(request, prefix + "st14_20_opr6", ""));
		setSt1420Opr5(JSPUtil.getParameter(request, prefix + "st14_20_opr5", ""));
		setSt1420Opr4(JSPUtil.getParameter(request, prefix + "st14_20_opr4", ""));
		setSt1420Opr3(JSPUtil.getParameter(request, prefix + "st14_20_opr3", ""));
		setSt1420Opr2(JSPUtil.getParameter(request, prefix + "st14_20_opr2", ""));
		setSt1420Opr1(JSPUtil.getParameter(request, prefix + "st14_20_opr1", ""));
		setSt1420Opr9(JSPUtil.getParameter(request, prefix + "st14_20_opr9", ""));
		setSt1420Opr8(JSPUtil.getParameter(request, prefix + "st14_20_opr8", ""));
		setSt1420Opr7(JSPUtil.getParameter(request, prefix + "st14_20_opr7", ""));
		setSt84hOpr1(JSPUtil.getParameter(request, prefix + "st8_4h_opr1", ""));
		setSt84hOpr3(JSPUtil.getParameter(request, prefix + "st8_4h_opr3", ""));
		setSt84hOpr2(JSPUtil.getParameter(request, prefix + "st8_4h_opr2", ""));
		setSt84hOpr5(JSPUtil.getParameter(request, prefix + "st8_4h_opr5", ""));
		setSt84hOpr4(JSPUtil.getParameter(request, prefix + "st8_4h_opr4", ""));
		setSt152hOpr10(JSPUtil.getParameter(request, prefix + "st15_2h_opr10", ""));
		setSt84hOpr6(JSPUtil.getParameter(request, prefix + "st8_4h_opr6", ""));
		setSt84hOpr7(JSPUtil.getParameter(request, prefix + "st8_4h_opr7", ""));
		setSt84hOpr8(JSPUtil.getParameter(request, prefix + "st8_4h_opr8", ""));
		setSt84hOpr9(JSPUtil.getParameter(request, prefix + "st8_4h_opr9", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setSt14hOpr10(JSPUtil.getParameter(request, prefix + "st1_4h_opr10", ""));
		setSt640Opr8(JSPUtil.getParameter(request, prefix + "st6_40_opr8", ""));
		setSt1245Opr9(JSPUtil.getParameter(request, prefix + "st12_45_opr9", ""));
		setSt1245Opr8(JSPUtil.getParameter(request, prefix + "st12_45_opr8", ""));
		setSt640Opr9(JSPUtil.getParameter(request, prefix + "st6_40_opr9", ""));
		setSt1245Opr7(JSPUtil.getParameter(request, prefix + "st12_45_opr7", ""));
		setSt1245Opr6(JSPUtil.getParameter(request, prefix + "st12_45_opr6", ""));
		setSt640Opr4(JSPUtil.getParameter(request, prefix + "st6_40_opr4", ""));
		setSt1245Opr5(JSPUtil.getParameter(request, prefix + "st12_45_opr5", ""));
		setSt640Opr5(JSPUtil.getParameter(request, prefix + "st6_40_opr5", ""));
		setSt1245Opr4(JSPUtil.getParameter(request, prefix + "st12_45_opr4", ""));
		setSt1245Opr3(JSPUtil.getParameter(request, prefix + "st12_45_opr3", ""));
		setSt640Opr6(JSPUtil.getParameter(request, prefix + "st6_40_opr6", ""));
		setSt1245Opr2(JSPUtil.getParameter(request, prefix + "st12_45_opr2", ""));
		setSt640Opr7(JSPUtil.getParameter(request, prefix + "st6_40_opr7", ""));
		setSt1245Opr1(JSPUtil.getParameter(request, prefix + "st12_45_opr1", ""));
		setSt640Opr1(JSPUtil.getParameter(request, prefix + "st6_40_opr1", ""));
		setSt640Opr2(JSPUtil.getParameter(request, prefix + "st6_40_opr2", ""));
		setSt640Opr3(JSPUtil.getParameter(request, prefix + "st6_40_opr3", ""));
		setSt52hOpr10(JSPUtil.getParameter(request, prefix + "st5_2h_opr10", ""));
		setSt1340Opr2(JSPUtil.getParameter(request, prefix + "st13_40_opr2", ""));
		setSt1340Opr3(JSPUtil.getParameter(request, prefix + "st13_40_opr3", ""));
		setSt1340Opr4(JSPUtil.getParameter(request, prefix + "st13_40_opr4", ""));
		setSt1340Opr5(JSPUtil.getParameter(request, prefix + "st13_40_opr5", ""));
		setSt1340Opr6(JSPUtil.getParameter(request, prefix + "st13_40_opr6", ""));
		setSt1340Opr7(JSPUtil.getParameter(request, prefix + "st13_40_opr7", ""));
		setSt1340Opr8(JSPUtil.getParameter(request, prefix + "st13_40_opr8", ""));
		setSt1340Opr9(JSPUtil.getParameter(request, prefix + "st13_40_opr9", ""));
		setSt945Opr1(JSPUtil.getParameter(request, prefix + "st9_45_opr1", ""));
		setSt945Opr3(JSPUtil.getParameter(request, prefix + "st9_45_opr3", ""));
		setSt945Opr2(JSPUtil.getParameter(request, prefix + "st9_45_opr2", ""));
		setSt945Opr5(JSPUtil.getParameter(request, prefix + "st9_45_opr5", ""));
		setSt945Opr4(JSPUtil.getParameter(request, prefix + "st9_45_opr4", ""));
		setSt945Opr7(JSPUtil.getParameter(request, prefix + "st9_45_opr7", ""));
		setSt945Opr6(JSPUtil.getParameter(request, prefix + "st9_45_opr6", ""));
		setSt64hOpr10(JSPUtil.getParameter(request, prefix + "st6_4h_opr10", ""));
		setSt520Opr1(JSPUtil.getParameter(request, prefix + "st5_20_opr1", ""));
		setSt540Opr2(JSPUtil.getParameter(request, prefix + "st5_40_opr2", ""));
		setSt540Opr1(JSPUtil.getParameter(request, prefix + "st5_40_opr1", ""));
		setSt520Opr2(JSPUtil.getParameter(request, prefix + "st5_20_opr2", ""));
		setSt540Opr4(JSPUtil.getParameter(request, prefix + "st5_40_opr4", ""));
		setSt540Opr3(JSPUtil.getParameter(request, prefix + "st5_40_opr3", ""));
		setQty10(JSPUtil.getParameter(request, prefix + "qty10", ""));
		setSt520Opr5(JSPUtil.getParameter(request, prefix + "st5_20_opr5", ""));
		setSt540Opr6(JSPUtil.getParameter(request, prefix + "st5_40_opr6", ""));
		setSt540Opr5(JSPUtil.getParameter(request, prefix + "st5_40_opr5", ""));
		setSt520Opr6(JSPUtil.getParameter(request, prefix + "st5_20_opr6", ""));
		setSt520Opr3(JSPUtil.getParameter(request, prefix + "st5_20_opr3", ""));
		setSt540Opr8(JSPUtil.getParameter(request, prefix + "st5_40_opr8", ""));
		setSt520Opr4(JSPUtil.getParameter(request, prefix + "st5_20_opr4", ""));
		setSt540Opr7(JSPUtil.getParameter(request, prefix + "st5_40_opr7", ""));
		setSt520Opr9(JSPUtil.getParameter(request, prefix + "st5_20_opr9", ""));
		setSt540Opr9(JSPUtil.getParameter(request, prefix + "st5_40_opr9", ""));
		setSt520Opr7(JSPUtil.getParameter(request, prefix + "st5_20_opr7", ""));
		setSt520Opr8(JSPUtil.getParameter(request, prefix + "st5_20_opr8", ""));
		setSt945Opr10(JSPUtil.getParameter(request, prefix + "st9_45_opr10", ""));
		setSt94hOpr10(JSPUtil.getParameter(request, prefix + "st9_4h_opr10", ""));
		setStwgCgoFlg(JSPUtil.getParameter(request, prefix + "stwg_cgo_flg", ""));
		setSt1540Opr10(JSPUtil.getParameter(request, prefix + "st15_40_opr10", ""));
		setSt945Opr8(JSPUtil.getParameter(request, prefix + "st9_45_opr8", ""));
		setSt945Opr9(JSPUtil.getParameter(request, prefix + "st9_45_opr9", ""));
		setSt32hOpr9(JSPUtil.getParameter(request, prefix + "st3_2h_opr9", ""));
		setSt24hOpr1(JSPUtil.getParameter(request, prefix + "st2_4h_opr1", ""));
		setSt920Opr9(JSPUtil.getParameter(request, prefix + "st9_20_opr9", ""));
		setSt24hOpr3(JSPUtil.getParameter(request, prefix + "st2_4h_opr3", ""));
		setSt920Opr8(JSPUtil.getParameter(request, prefix + "st9_20_opr8", ""));
		setSt24hOpr2(JSPUtil.getParameter(request, prefix + "st2_4h_opr2", ""));
		setSt920Opr7(JSPUtil.getParameter(request, prefix + "st9_20_opr7", ""));
		setSt920Opr6(JSPUtil.getParameter(request, prefix + "st9_20_opr6", ""));
		setSt920Opr5(JSPUtil.getParameter(request, prefix + "st9_20_opr5", ""));
		setSt920Opr4(JSPUtil.getParameter(request, prefix + "st9_20_opr4", ""));
		setSt920Opr3(JSPUtil.getParameter(request, prefix + "st9_20_opr3", ""));
		setSt32hOpr4(JSPUtil.getParameter(request, prefix + "st3_2h_opr4", ""));
		setSt920Opr2(JSPUtil.getParameter(request, prefix + "st9_20_opr2", ""));
		setSt24hOpr9(JSPUtil.getParameter(request, prefix + "st2_4h_opr9", ""));
		setSt32hOpr3(JSPUtil.getParameter(request, prefix + "st3_2h_opr3", ""));
		setSt920Opr1(JSPUtil.getParameter(request, prefix + "st9_20_opr1", ""));
		setStwgCd(JSPUtil.getParameter(request, prefix + "stwg_cd", ""));
		setSt24hOpr8(JSPUtil.getParameter(request, prefix + "st2_4h_opr8", ""));
		setSt240Opr10(JSPUtil.getParameter(request, prefix + "st2_40_opr10", ""));
		setSt32hOpr2(JSPUtil.getParameter(request, prefix + "st3_2h_opr2", ""));
		setSt32hOpr1(JSPUtil.getParameter(request, prefix + "st3_2h_opr1", ""));
		setSt24hOpr5(JSPUtil.getParameter(request, prefix + "st2_4h_opr5", ""));
		setSt32hOpr8(JSPUtil.getParameter(request, prefix + "st3_2h_opr8", ""));
		setSt24hOpr4(JSPUtil.getParameter(request, prefix + "st2_4h_opr4", ""));
		setSt32hOpr7(JSPUtil.getParameter(request, prefix + "st3_2h_opr7", ""));
		setSt32hOpr6(JSPUtil.getParameter(request, prefix + "st3_2h_opr6", ""));
		setSt24hOpr7(JSPUtil.getParameter(request, prefix + "st2_4h_opr7", ""));
		setSt32hOpr5(JSPUtil.getParameter(request, prefix + "st3_2h_opr5", ""));
		setSt24hOpr6(JSPUtil.getParameter(request, prefix + "st2_4h_opr6", ""));
		setSt240Opr4(JSPUtil.getParameter(request, prefix + "st2_40_opr4", ""));
		setSt820Opr1(JSPUtil.getParameter(request, prefix + "st8_20_opr1", ""));
		setSt112hOpr10(JSPUtil.getParameter(request, prefix + "st11_2h_opr10", ""));
		setSt240Opr5(JSPUtil.getParameter(request, prefix + "st2_40_opr5", ""));
		setSt820Opr3(JSPUtil.getParameter(request, prefix + "st8_20_opr3", ""));
		setSt240Opr6(JSPUtil.getParameter(request, prefix + "st2_40_opr6", ""));
		setSt820Opr2(JSPUtil.getParameter(request, prefix + "st8_20_opr2", ""));
		setSt240Opr7(JSPUtil.getParameter(request, prefix + "st2_40_opr7", ""));
		setSt240Opr8(JSPUtil.getParameter(request, prefix + "st2_40_opr8", ""));
		setSt240Opr9(JSPUtil.getParameter(request, prefix + "st2_40_opr9", ""));
		setSt64hOpr7(JSPUtil.getParameter(request, prefix + "st6_4h_opr7", ""));
		setSt820Opr9(JSPUtil.getParameter(request, prefix + "st8_20_opr9", ""));
		setSt64hOpr6(JSPUtil.getParameter(request, prefix + "st6_4h_opr6", ""));
		setSt820Opr8(JSPUtil.getParameter(request, prefix + "st8_20_opr8", ""));
		setSt64hOpr5(JSPUtil.getParameter(request, prefix + "st6_4h_opr5", ""));
		setSt64hOpr4(JSPUtil.getParameter(request, prefix + "st6_4h_opr4", ""));
		setSt64hOpr3(JSPUtil.getParameter(request, prefix + "st6_4h_opr3", ""));
		setSt820Opr5(JSPUtil.getParameter(request, prefix + "st8_20_opr5", ""));
		setSt820Opr4(JSPUtil.getParameter(request, prefix + "st8_20_opr4", ""));
		setSt64hOpr2(JSPUtil.getParameter(request, prefix + "st6_4h_opr2", ""));
		setSt64hOpr1(JSPUtil.getParameter(request, prefix + "st6_4h_opr1", ""));
		setSt820Opr7(JSPUtil.getParameter(request, prefix + "st8_20_opr7", ""));
		setSt820Opr6(JSPUtil.getParameter(request, prefix + "st8_20_opr6", ""));
		setSt445Opr1(JSPUtil.getParameter(request, prefix + "st4_45_opr1", ""));
		setSt445Opr2(JSPUtil.getParameter(request, prefix + "st4_45_opr2", ""));
		setSt445Opr3(JSPUtil.getParameter(request, prefix + "st4_45_opr3", ""));
		setSt64hOpr8(JSPUtil.getParameter(request, prefix + "st6_4h_opr8", ""));
		setSt445Opr4(JSPUtil.getParameter(request, prefix + "st4_45_opr4", ""));
		setSt64hOpr9(JSPUtil.getParameter(request, prefix + "st6_4h_opr9", ""));
		setSt445Opr5(JSPUtil.getParameter(request, prefix + "st4_45_opr5", ""));
		setSt445Opr6(JSPUtil.getParameter(request, prefix + "st4_45_opr6", ""));
		setSt445Opr7(JSPUtil.getParameter(request, prefix + "st4_45_opr7", ""));
		setSt445Opr8(JSPUtil.getParameter(request, prefix + "st4_45_opr8", ""));
		setSt240Opr1(JSPUtil.getParameter(request, prefix + "st2_40_opr1", ""));
		setSt445Opr9(JSPUtil.getParameter(request, prefix + "st4_45_opr9", ""));
		setSt240Opr3(JSPUtil.getParameter(request, prefix + "st2_40_opr3", ""));
		setSt240Opr2(JSPUtil.getParameter(request, prefix + "st2_40_opr2", ""));
		setSt9(JSPUtil.getParameter(request, prefix + "st_9", ""));
		setSt7(JSPUtil.getParameter(request, prefix + "st_7", ""));
		setSt8(JSPUtil.getParameter(request, prefix + "st_8", ""));
		setSt5(JSPUtil.getParameter(request, prefix + "st_5", ""));
		setSt6(JSPUtil.getParameter(request, prefix + "st_6", ""));
		setSt3(JSPUtil.getParameter(request, prefix + "st_3", ""));
		setSt4(JSPUtil.getParameter(request, prefix + "st_4", ""));
		setSt1(JSPUtil.getParameter(request, prefix + "st_1", ""));
		setSt2(JSPUtil.getParameter(request, prefix + "st_2", ""));
		setSt940Opr10(JSPUtil.getParameter(request, prefix + "st9_40_opr10", ""));
		setSt1220Opr10(JSPUtil.getParameter(request, prefix + "st12_20_opr10", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSt320Opr9(JSPUtil.getParameter(request, prefix + "st3_20_opr9", ""));
		setSt320Opr8(JSPUtil.getParameter(request, prefix + "st3_20_opr8", ""));
		setSt320Opr7(JSPUtil.getParameter(request, prefix + "st3_20_opr7", ""));
		setSt320Opr6(JSPUtil.getParameter(request, prefix + "st3_20_opr6", ""));
		setSt320Opr5(JSPUtil.getParameter(request, prefix + "st3_20_opr5", ""));
		setSt42hOpr10(JSPUtil.getParameter(request, prefix + "st4_2h_opr10", ""));
		setSt320Opr4(JSPUtil.getParameter(request, prefix + "st3_20_opr4", ""));
		setSt320Opr3(JSPUtil.getParameter(request, prefix + "st3_20_opr3", ""));
		setSt320Opr2(JSPUtil.getParameter(request, prefix + "st3_20_opr2", ""));
		setSt320Opr1(JSPUtil.getParameter(request, prefix + "st3_20_opr1", ""));
		setSt144hOpr9(JSPUtil.getParameter(request, prefix + "st14_4h_opr9", ""));
		setSt645Opr10(JSPUtil.getParameter(request, prefix + "st6_45_opr10", ""));
		setSt22hOpr1(JSPUtil.getParameter(request, prefix + "st2_2h_opr1", ""));
		setSt22hOpr8(JSPUtil.getParameter(request, prefix + "st2_2h_opr8", ""));
		setSt22hOpr9(JSPUtil.getParameter(request, prefix + "st2_2h_opr9", ""));
		setSt22hOpr6(JSPUtil.getParameter(request, prefix + "st2_2h_opr6", ""));
		setSt22hOpr7(JSPUtil.getParameter(request, prefix + "st2_2h_opr7", ""));
		setSt122hOpr10(JSPUtil.getParameter(request, prefix + "st12_2h_opr10", ""));
		setSt104hOpr10(JSPUtil.getParameter(request, prefix + "st10_4h_opr10", ""));
		setSt22hOpr4(JSPUtil.getParameter(request, prefix + "st2_2h_opr4", ""));
		setSt22hOpr5(JSPUtil.getParameter(request, prefix + "st2_2h_opr5", ""));
		setSt22hOpr2(JSPUtil.getParameter(request, prefix + "st2_2h_opr2", ""));
		setSt22hOpr3(JSPUtil.getParameter(request, prefix + "st2_2h_opr3", ""));
		setSt440Opr10(JSPUtil.getParameter(request, prefix + "st4_40_opr10", ""));
		setSt44hOpr6(JSPUtil.getParameter(request, prefix + "st4_4h_opr6", ""));
		setSt44hOpr7(JSPUtil.getParameter(request, prefix + "st4_4h_opr7", ""));
		setSt44hOpr8(JSPUtil.getParameter(request, prefix + "st4_4h_opr8", ""));
		setSt44hOpr9(JSPUtil.getParameter(request, prefix + "st4_4h_opr9", ""));
		setSt44hOpr2(JSPUtil.getParameter(request, prefix + "st4_4h_opr2", ""));
		setSt44hOpr3(JSPUtil.getParameter(request, prefix + "st4_4h_opr3", ""));
		setSt44hOpr4(JSPUtil.getParameter(request, prefix + "st4_4h_opr4", ""));
		setSt44hOpr5(JSPUtil.getParameter(request, prefix + "st4_4h_opr5", ""));
		setSt44hOpr1(JSPUtil.getParameter(request, prefix + "st4_4h_opr1", ""));
		setBkgShprOwnrFlg(JSPUtil.getParameter(request, prefix + "bkg_shpr_ownr_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setSt144hOpr1(JSPUtil.getParameter(request, prefix + "st14_4h_opr1", ""));
		setSt144hOpr2(JSPUtil.getParameter(request, prefix + "st14_4h_opr2", ""));
		setSt144hOpr3(JSPUtil.getParameter(request, prefix + "st14_4h_opr3", ""));
		setSt74hOpr10(JSPUtil.getParameter(request, prefix + "st7_4h_opr10", ""));
		setSt144hOpr4(JSPUtil.getParameter(request, prefix + "st14_4h_opr4", ""));
		setSt144hOpr5(JSPUtil.getParameter(request, prefix + "st14_4h_opr5", ""));
		setSt144hOpr6(JSPUtil.getParameter(request, prefix + "st14_4h_opr6", ""));
		setSt144hOpr7(JSPUtil.getParameter(request, prefix + "st14_4h_opr7", ""));
		setSt144hOpr8(JSPUtil.getParameter(request, prefix + "st14_4h_opr8", ""));
		setSt72hOpr10(JSPUtil.getParameter(request, prefix + "st7_2h_opr10", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSt420Opr9(JSPUtil.getParameter(request, prefix + "st4_20_opr9", ""));
		setSt420Opr8(JSPUtil.getParameter(request, prefix + "st4_20_opr8", ""));
		setSt420Opr5(JSPUtil.getParameter(request, prefix + "st4_20_opr5", ""));
		setSt420Opr4(JSPUtil.getParameter(request, prefix + "st4_20_opr4", ""));
		setSt420Opr7(JSPUtil.getParameter(request, prefix + "st4_20_opr7", ""));
		setSt420Opr6(JSPUtil.getParameter(request, prefix + "st4_20_opr6", ""));
		setSt420Opr1(JSPUtil.getParameter(request, prefix + "st4_20_opr1", ""));
		setSt420Opr3(JSPUtil.getParameter(request, prefix + "st4_20_opr3", ""));
		setSt420Opr2(JSPUtil.getParameter(request, prefix + "st4_20_opr2", ""));
		setSt840Opr9(JSPUtil.getParameter(request, prefix + "st8_40_opr9", ""));
		setSt840Opr8(JSPUtil.getParameter(request, prefix + "st8_40_opr8", ""));
		setSt840Opr7(JSPUtil.getParameter(request, prefix + "st8_40_opr7", ""));
		setSt840Opr6(JSPUtil.getParameter(request, prefix + "st8_40_opr6", ""));
		setSt22hOpr10(JSPUtil.getParameter(request, prefix + "st2_2h_opr10", ""));
		setSt840Opr1(JSPUtil.getParameter(request, prefix + "st8_40_opr1", ""));
		setSt440Opr9(JSPUtil.getParameter(request, prefix + "st4_40_opr9", ""));
		setSt440Opr8(JSPUtil.getParameter(request, prefix + "st4_40_opr8", ""));
		setSt440Opr7(JSPUtil.getParameter(request, prefix + "st4_40_opr7", ""));
		setSt440Opr6(JSPUtil.getParameter(request, prefix + "st4_40_opr6", ""));
		setSt440Opr5(JSPUtil.getParameter(request, prefix + "st4_40_opr5", ""));
		setSt840Opr5(JSPUtil.getParameter(request, prefix + "st8_40_opr5", ""));
		setSt840Opr4(JSPUtil.getParameter(request, prefix + "st8_40_opr4", ""));
		setSt440Opr4(JSPUtil.getParameter(request, prefix + "st4_40_opr4", ""));
		setSt840Opr3(JSPUtil.getParameter(request, prefix + "st8_40_opr3", ""));
		setSt440Opr3(JSPUtil.getParameter(request, prefix + "st4_40_opr3", ""));
		setSt440Opr2(JSPUtil.getParameter(request, prefix + "st4_40_opr2", ""));
		setSt840Opr2(JSPUtil.getParameter(request, prefix + "st8_40_opr2", ""));
		setSt440Opr1(JSPUtil.getParameter(request, prefix + "st4_40_opr1", ""));
		setSt820Opr10(JSPUtil.getParameter(request, prefix + "st8_20_opr10", ""));
		setSt1120Opr10(JSPUtil.getParameter(request, prefix + "st11_20_opr10", ""));
		setSt620Opr9(JSPUtil.getParameter(request, prefix + "st6_20_opr9", ""));
		setSt620Opr8(JSPUtil.getParameter(request, prefix + "st6_20_opr8", ""));
		setSt620Opr7(JSPUtil.getParameter(request, prefix + "st6_20_opr7", ""));
		setSt620Opr6(JSPUtil.getParameter(request, prefix + "st6_20_opr6", ""));
		setSt620Opr1(JSPUtil.getParameter(request, prefix + "st6_20_opr1", ""));
		setSt620Opr5(JSPUtil.getParameter(request, prefix + "st6_20_opr5", ""));
		setSt620Opr4(JSPUtil.getParameter(request, prefix + "st6_20_opr4", ""));
		setSt620Opr3(JSPUtil.getParameter(request, prefix + "st6_20_opr3", ""));
		setSt620Opr2(JSPUtil.getParameter(request, prefix + "st6_20_opr2", ""));
		setSt1240Opr9(JSPUtil.getParameter(request, prefix + "st12_40_opr9", ""));
		setSt62hOpr1(JSPUtil.getParameter(request, prefix + "st6_2h_opr1", ""));
		setSt1240Opr8(JSPUtil.getParameter(request, prefix + "st12_40_opr8", ""));
		setSt1240Opr7(JSPUtil.getParameter(request, prefix + "st12_40_opr7", ""));
		setSt62hOpr3(JSPUtil.getParameter(request, prefix + "st6_2h_opr3", ""));
		setSt1240Opr6(JSPUtil.getParameter(request, prefix + "st12_40_opr6", ""));
		setSt62hOpr2(JSPUtil.getParameter(request, prefix + "st6_2h_opr2", ""));
		setSt1240Opr5(JSPUtil.getParameter(request, prefix + "st12_40_opr5", ""));
		setSt62hOpr5(JSPUtil.getParameter(request, prefix + "st6_2h_opr5", ""));
		setSt1240Opr4(JSPUtil.getParameter(request, prefix + "st12_40_opr4", ""));
		setSt62hOpr4(JSPUtil.getParameter(request, prefix + "st6_2h_opr4", ""));
		setSt1240Opr3(JSPUtil.getParameter(request, prefix + "st12_40_opr3", ""));
		setSt62hOpr6(JSPUtil.getParameter(request, prefix + "st6_2h_opr6", ""));
		setSt62hOpr7(JSPUtil.getParameter(request, prefix + "st6_2h_opr7", ""));
		setSt62hOpr8(JSPUtil.getParameter(request, prefix + "st6_2h_opr8", ""));
		setSt62hOpr9(JSPUtil.getParameter(request, prefix + "st6_2h_opr9", ""));
		setSt134hOpr10(JSPUtil.getParameter(request, prefix + "st13_4h_opr10", ""));
		setSt620Opr10(JSPUtil.getParameter(request, prefix + "st6_20_opr10", ""));
		setSt84hOpr10(JSPUtil.getParameter(request, prefix + "st8_4h_opr10", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSt145Opr9(JSPUtil.getParameter(request, prefix + "st1_45_opr9", ""));
		setSt1245Opr10(JSPUtil.getParameter(request, prefix + "st12_45_opr10", ""));
		setSt145Opr8(JSPUtil.getParameter(request, prefix + "st1_45_opr8", ""));
		setSt154hOpr9(JSPUtil.getParameter(request, prefix + "st15_4h_opr9", ""));
		setSt154hOpr8(JSPUtil.getParameter(request, prefix + "st15_4h_opr8", ""));
		setSt1345Opr10(JSPUtil.getParameter(request, prefix + "st13_45_opr10", ""));
		setSt145Opr3(JSPUtil.getParameter(request, prefix + "st1_45_opr3", ""));
		setSt145Opr2(JSPUtil.getParameter(request, prefix + "st1_45_opr2", ""));
		setSt145Opr1(JSPUtil.getParameter(request, prefix + "st1_45_opr1", ""));
		setSt145Opr7(JSPUtil.getParameter(request, prefix + "st1_45_opr7", ""));
		setSt145Opr6(JSPUtil.getParameter(request, prefix + "st1_45_opr6", ""));
		setSt145Opr5(JSPUtil.getParameter(request, prefix + "st1_45_opr5", ""));
		setSt44hOpr10(JSPUtil.getParameter(request, prefix + "st4_4h_opr10", ""));
		setSt145Opr4(JSPUtil.getParameter(request, prefix + "st1_45_opr4", ""));
		setSt54hOpr4(JSPUtil.getParameter(request, prefix + "st5_4h_opr4", ""));
		setOpr7(JSPUtil.getParameter(request, prefix + "opr7", ""));
		setSt54hOpr3(JSPUtil.getParameter(request, prefix + "st5_4h_opr3", ""));
		setOpr8(JSPUtil.getParameter(request, prefix + "opr8", ""));
		setOpr5(JSPUtil.getParameter(request, prefix + "opr5", ""));
		setSt54hOpr2(JSPUtil.getParameter(request, prefix + "st5_4h_opr2", ""));
		setSt54hOpr1(JSPUtil.getParameter(request, prefix + "st5_4h_opr1", ""));
		setOpr6(JSPUtil.getParameter(request, prefix + "opr6", ""));
		setOpr3(JSPUtil.getParameter(request, prefix + "opr3", ""));
		setSt54hOpr8(JSPUtil.getParameter(request, prefix + "st5_4h_opr8", ""));
		setOpr4(JSPUtil.getParameter(request, prefix + "opr4", ""));
		setSt54hOpr7(JSPUtil.getParameter(request, prefix + "st5_4h_opr7", ""));
		setOpr1(JSPUtil.getParameter(request, prefix + "opr1", ""));
		setSt54hOpr6(JSPUtil.getParameter(request, prefix + "st5_4h_opr6", ""));
		setSt54hOpr5(JSPUtil.getParameter(request, prefix + "st5_4h_opr5", ""));
		setOpr2(JSPUtil.getParameter(request, prefix + "opr2", ""));
		setOpr9(JSPUtil.getParameter(request, prefix + "opr9", ""));
		setSt54hOpr9(JSPUtil.getParameter(request, prefix + "st5_4h_opr9", ""));
		setSt220Opr6(JSPUtil.getParameter(request, prefix + "st2_20_opr6", ""));
		setSt220Opr7(JSPUtil.getParameter(request, prefix + "st2_20_opr7", ""));
		setSt220Opr8(JSPUtil.getParameter(request, prefix + "st2_20_opr8", ""));
		setSt220Opr9(JSPUtil.getParameter(request, prefix + "st2_20_opr9", ""));
		setSt220Opr2(JSPUtil.getParameter(request, prefix + "st2_20_opr2", ""));
		setSt220Opr3(JSPUtil.getParameter(request, prefix + "st2_20_opr3", ""));
		setSt220Opr4(JSPUtil.getParameter(request, prefix + "st2_20_opr4", ""));
		setSt220Opr5(JSPUtil.getParameter(request, prefix + "st2_20_opr5", ""));
		setSt1020Opr2(JSPUtil.getParameter(request, prefix + "st10_20_opr2", ""));
		setSt1020Opr1(JSPUtil.getParameter(request, prefix + "st10_20_opr1", ""));
		setSt220Opr1(JSPUtil.getParameter(request, prefix + "st2_20_opr1", ""));
		setSt15(JSPUtil.getParameter(request, prefix + "st_15", ""));
		setSt14(JSPUtil.getParameter(request, prefix + "st_14", ""));
		setSt13(JSPUtil.getParameter(request, prefix + "st_13", ""));
		setSt12(JSPUtil.getParameter(request, prefix + "st_12", ""));
		setSt11(JSPUtil.getParameter(request, prefix + "st_11", ""));
		setSt10(JSPUtil.getParameter(request, prefix + "st_10", ""));
		setSt134hOpr1(JSPUtil.getParameter(request, prefix + "st13_4h_opr1", ""));
		setSt134hOpr2(JSPUtil.getParameter(request, prefix + "st13_4h_opr2", ""));
		setSt72hOpr5(JSPUtil.getParameter(request, prefix + "st7_2h_opr5", ""));
		setSt134hOpr3(JSPUtil.getParameter(request, prefix + "st13_4h_opr3", ""));
		setSt72hOpr6(JSPUtil.getParameter(request, prefix + "st7_2h_opr6", ""));
		setSt134hOpr4(JSPUtil.getParameter(request, prefix + "st13_4h_opr4", ""));
		setSt72hOpr7(JSPUtil.getParameter(request, prefix + "st7_2h_opr7", ""));
		setSt134hOpr5(JSPUtil.getParameter(request, prefix + "st13_4h_opr5", ""));
		setSt72hOpr8(JSPUtil.getParameter(request, prefix + "st7_2h_opr8", ""));
		setSt134hOpr6(JSPUtil.getParameter(request, prefix + "st13_4h_opr6", ""));
		setSt72hOpr9(JSPUtil.getParameter(request, prefix + "st7_2h_opr9", ""));
		setSt134hOpr7(JSPUtil.getParameter(request, prefix + "st13_4h_opr7", ""));
		setSt134hOpr8(JSPUtil.getParameter(request, prefix + "st13_4h_opr8", ""));
		setSt134hOpr9(JSPUtil.getParameter(request, prefix + "st13_4h_opr9", ""));
		setSt154hOpr1(JSPUtil.getParameter(request, prefix + "st15_4h_opr1", ""));
		setSt154hOpr3(JSPUtil.getParameter(request, prefix + "st15_4h_opr3", ""));
		setSt154hOpr2(JSPUtil.getParameter(request, prefix + "st15_4h_opr2", ""));
		setSt1440Opr9(JSPUtil.getParameter(request, prefix + "st14_40_opr9", ""));
		setSt1040Opr4(JSPUtil.getParameter(request, prefix + "st10_40_opr4", ""));
		setSt72hOpr2(JSPUtil.getParameter(request, prefix + "st7_2h_opr2", ""));
		setSt154hOpr5(JSPUtil.getParameter(request, prefix + "st15_4h_opr5", ""));
		setSt154hOpr4(JSPUtil.getParameter(request, prefix + "st15_4h_opr4", ""));
		setSt1040Opr3(JSPUtil.getParameter(request, prefix + "st10_40_opr3", ""));
		setSt72hOpr1(JSPUtil.getParameter(request, prefix + "st7_2h_opr1", ""));
		setSt72hOpr4(JSPUtil.getParameter(request, prefix + "st7_2h_opr4", ""));
		setSt1040Opr2(JSPUtil.getParameter(request, prefix + "st10_40_opr2", ""));
		setSt154hOpr7(JSPUtil.getParameter(request, prefix + "st15_4h_opr7", ""));
		setSt72hOpr3(JSPUtil.getParameter(request, prefix + "st7_2h_opr3", ""));
		setSt1040Opr1(JSPUtil.getParameter(request, prefix + "st10_40_opr1", ""));
		setSt154hOpr6(JSPUtil.getParameter(request, prefix + "st15_4h_opr6", ""));
		setSt1440Opr4(JSPUtil.getParameter(request, prefix + "st14_40_opr4", ""));
		setSt1440Opr3(JSPUtil.getParameter(request, prefix + "st14_40_opr3", ""));
		setSt1440Opr2(JSPUtil.getParameter(request, prefix + "st14_40_opr2", ""));
		setSt1440Opr1(JSPUtil.getParameter(request, prefix + "st14_40_opr1", ""));
		setSt1440Opr8(JSPUtil.getParameter(request, prefix + "st14_40_opr8", ""));
		setSt1440Opr7(JSPUtil.getParameter(request, prefix + "st14_40_opr7", ""));
		setSt1440Opr6(JSPUtil.getParameter(request, prefix + "st14_40_opr6", ""));
		setSt1440Opr5(JSPUtil.getParameter(request, prefix + "st14_40_opr5", ""));
		setSt102hOpr1(JSPUtil.getParameter(request, prefix + "st10_2h_opr1", ""));
		setSt102hOpr2(JSPUtil.getParameter(request, prefix + "st10_2h_opr2", ""));
		setSt102hOpr7(JSPUtil.getParameter(request, prefix + "st10_2h_opr7", ""));
		setSt102hOpr8(JSPUtil.getParameter(request, prefix + "st10_2h_opr8", ""));
		setSt102hOpr9(JSPUtil.getParameter(request, prefix + "st10_2h_opr9", ""));
		setSt102hOpr3(JSPUtil.getParameter(request, prefix + "st10_2h_opr3", ""));
		setSt102hOpr4(JSPUtil.getParameter(request, prefix + "st10_2h_opr4", ""));
		setSt102hOpr5(JSPUtil.getParameter(request, prefix + "st10_2h_opr5", ""));
		setSt102hOpr6(JSPUtil.getParameter(request, prefix + "st10_2h_opr6", ""));
		setSt320Opr10(JSPUtil.getParameter(request, prefix + "st3_20_opr10", ""));
		setSt1020Opr3(JSPUtil.getParameter(request, prefix + "st10_20_opr3", ""));
		setSt1020Opr4(JSPUtil.getParameter(request, prefix + "st10_20_opr4", ""));
		setSt1020Opr5(JSPUtil.getParameter(request, prefix + "st10_20_opr5", ""));
		setSt1020Opr6(JSPUtil.getParameter(request, prefix + "st10_20_opr6", ""));
		setSt1240Opr2(JSPUtil.getParameter(request, prefix + "st12_40_opr2", ""));
		setSt1020Opr7(JSPUtil.getParameter(request, prefix + "st10_20_opr7", ""));
		setSt1240Opr1(JSPUtil.getParameter(request, prefix + "st12_40_opr1", ""));
		setSt1020Opr8(JSPUtil.getParameter(request, prefix + "st10_20_opr8", ""));
		setSt1020Opr9(JSPUtil.getParameter(request, prefix + "st10_20_opr9", ""));
		setSt1240Opr10(JSPUtil.getParameter(request, prefix + "st12_40_opr10", ""));
		setSt14hOpr9(JSPUtil.getParameter(request, prefix + "st1_4h_opr9", ""));
		setSt1140Opr10(JSPUtil.getParameter(request, prefix + "st11_40_opr10", ""));
		setSt14hOpr5(JSPUtil.getParameter(request, prefix + "st1_4h_opr5", ""));
		setSt14hOpr6(JSPUtil.getParameter(request, prefix + "st1_4h_opr6", ""));
		setSt14hOpr7(JSPUtil.getParameter(request, prefix + "st1_4h_opr7", ""));
		setSt14hOpr8(JSPUtil.getParameter(request, prefix + "st1_4h_opr8", ""));
		setSt14hOpr1(JSPUtil.getParameter(request, prefix + "st1_4h_opr1", ""));
		setSt14hOpr2(JSPUtil.getParameter(request, prefix + "st1_4h_opr2", ""));
		setSt14hOpr3(JSPUtil.getParameter(request, prefix + "st1_4h_opr3", ""));
		setSt14hOpr4(JSPUtil.getParameter(request, prefix + "st1_4h_opr4", ""));
		setSt840Opr10(JSPUtil.getParameter(request, prefix + "st8_40_opr10", ""));
		setMlb(JSPUtil.getParameter(request, prefix + "mlb", ""));
		setSt102hOpr10(JSPUtil.getParameter(request, prefix + "st10_2h_opr10", ""));
		setAwkCgoFlg(JSPUtil.getParameter(request, prefix + "awk_cgo_flg", ""));
		setSt42hOpr1(JSPUtil.getParameter(request, prefix + "st4_2h_opr1", ""));
		setSt1040Opr9(JSPUtil.getParameter(request, prefix + "st10_40_opr9", ""));
		setSt42hOpr3(JSPUtil.getParameter(request, prefix + "st4_2h_opr3", ""));
		setSt42hOpr2(JSPUtil.getParameter(request, prefix + "st4_2h_opr2", ""));
		setSt42hOpr5(JSPUtil.getParameter(request, prefix + "st4_2h_opr5", ""));
		setSt1040Opr6(JSPUtil.getParameter(request, prefix + "st10_40_opr6", ""));
		setSt220Opr10(JSPUtil.getParameter(request, prefix + "st2_20_opr10", ""));
		setSt42hOpr4(JSPUtil.getParameter(request, prefix + "st4_2h_opr4", ""));
		setSt1040Opr5(JSPUtil.getParameter(request, prefix + "st10_40_opr5", ""));
		setSt42hOpr7(JSPUtil.getParameter(request, prefix + "st4_2h_opr7", ""));
		setSt1040Opr8(JSPUtil.getParameter(request, prefix + "st10_40_opr8", ""));
		setSt42hOpr6(JSPUtil.getParameter(request, prefix + "st4_2h_opr6", ""));
		setSt1040Opr7(JSPUtil.getParameter(request, prefix + "st10_40_opr7", ""));
		setSt745Opr3(JSPUtil.getParameter(request, prefix + "st7_45_opr3", ""));
		setSt745Opr2(JSPUtil.getParameter(request, prefix + "st7_45_opr2", ""));
		setSt745Opr5(JSPUtil.getParameter(request, prefix + "st7_45_opr5", ""));
		setSt745Opr4(JSPUtil.getParameter(request, prefix + "st7_45_opr4", ""));
		setSt745Opr7(JSPUtil.getParameter(request, prefix + "st7_45_opr7", ""));
		setSt745Opr6(JSPUtil.getParameter(request, prefix + "st7_45_opr6", ""));
		setSt745Opr9(JSPUtil.getParameter(request, prefix + "st7_45_opr9", ""));
		setSt745Opr8(JSPUtil.getParameter(request, prefix + "st7_45_opr8", ""));
		setSt42hOpr8(JSPUtil.getParameter(request, prefix + "st4_2h_opr8", ""));
		setSt42hOpr9(JSPUtil.getParameter(request, prefix + "st4_2h_opr9", ""));
		setSt745Opr1(JSPUtil.getParameter(request, prefix + "st7_45_opr1", ""));
		setSt114hOpr10(JSPUtil.getParameter(request, prefix + "st11_4h_opr10", ""));
		setSt140Opr6(JSPUtil.getParameter(request, prefix + "st1_40_opr6", ""));
		setSt140Opr5(JSPUtil.getParameter(request, prefix + "st1_40_opr5", ""));
		setSt140Opr8(JSPUtil.getParameter(request, prefix + "st1_40_opr8", ""));
		setSt140Opr7(JSPUtil.getParameter(request, prefix + "st1_40_opr7", ""));
		setSt140Opr9(JSPUtil.getParameter(request, prefix + "st1_40_opr9", ""));
		setSt142hOpr10(JSPUtil.getParameter(request, prefix + "st14_2h_opr10", ""));
		setSt140Opr1(JSPUtil.getParameter(request, prefix + "st1_40_opr1", ""));
		setSt140Opr2(JSPUtil.getParameter(request, prefix + "st1_40_opr2", ""));
		setSt140Opr3(JSPUtil.getParameter(request, prefix + "st1_40_opr3", ""));
		setSt54hOpr10(JSPUtil.getParameter(request, prefix + "st5_4h_opr10", ""));
		setSt140Opr4(JSPUtil.getParameter(request, prefix + "st1_40_opr4", ""));
		setPodYdCd(JSPUtil.getParameter(request,   prefix +  "pod_yd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CBFSpecialStwgVO[]
	 */
	public CBFSpecialStwgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CBFSpecialStwgVO[]
	 */
	public CBFSpecialStwgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CBFSpecialStwgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] st720Opr10 = (JSPUtil.getParameter(request, prefix	+ "st7_20_opr10", length));
			String[] st740Opr7 = (JSPUtil.getParameter(request, prefix	+ "st7_40_opr7", length));
			String[] st1445Opr10 = (JSPUtil.getParameter(request, prefix	+ "st14_45_opr10", length));
			String[] st740Opr8 = (JSPUtil.getParameter(request, prefix	+ "st7_40_opr8", length));
			String[] st740Opr9 = (JSPUtil.getParameter(request, prefix	+ "st7_40_opr9", length));
			String[] st140Opr10 = (JSPUtil.getParameter(request, prefix	+ "st1_40_opr10", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] st740Opr1 = (JSPUtil.getParameter(request, prefix	+ "st7_40_opr1", length));
			String[] st740Opr2 = (JSPUtil.getParameter(request, prefix	+ "st7_40_opr2", length));
			String[] st740Opr3 = (JSPUtil.getParameter(request, prefix	+ "st7_40_opr3", length));
			String[] st740Opr4 = (JSPUtil.getParameter(request, prefix	+ "st7_40_opr4", length));
			String[] st740Opr5 = (JSPUtil.getParameter(request, prefix	+ "st7_40_opr5", length));
			String[] st740Opr6 = (JSPUtil.getParameter(request, prefix	+ "st7_40_opr6", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] st145Opr10 = (JSPUtil.getParameter(request, prefix	+ "st1_45_opr10", length));
			String[] st1545Opr10 = (JSPUtil.getParameter(request, prefix	+ "st15_45_opr10", length));
			String[] st640Opr10 = (JSPUtil.getParameter(request, prefix	+ "st6_40_opr10", length));
			String[] st1340Opr10 = (JSPUtil.getParameter(request, prefix	+ "st13_40_opr10", length));
			String[] st520Opr10 = (JSPUtil.getParameter(request, prefix	+ "st5_20_opr10", length));
			String[] st154hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st15_4h_opr10", length));
			String[] st82hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st8_2h_opr10", length));
			String[] st845Opr10 = (JSPUtil.getParameter(request, prefix	+ "st8_45_opr10", length));
			String[] st645Opr3 = (JSPUtil.getParameter(request, prefix	+ "st6_45_opr3", length));
			String[] st645Opr4 = (JSPUtil.getParameter(request, prefix	+ "st6_45_opr4", length));
			String[] st645Opr5 = (JSPUtil.getParameter(request, prefix	+ "st6_45_opr5", length));
			String[] st545Opr8 = (JSPUtil.getParameter(request, prefix	+ "st5_45_opr8", length));
			String[] st645Opr6 = (JSPUtil.getParameter(request, prefix	+ "st6_45_opr6", length));
			String[] st545Opr9 = (JSPUtil.getParameter(request, prefix	+ "st5_45_opr9", length));
			String[] st545Opr6 = (JSPUtil.getParameter(request, prefix	+ "st5_45_opr6", length));
			String[] st645Opr7 = (JSPUtil.getParameter(request, prefix	+ "st6_45_opr7", length));
			String[] st545Opr7 = (JSPUtil.getParameter(request, prefix	+ "st5_45_opr7", length));
			String[] st645Opr8 = (JSPUtil.getParameter(request, prefix	+ "st6_45_opr8", length));
			String[] st545Opr4 = (JSPUtil.getParameter(request, prefix	+ "st5_45_opr4", length));
			String[] st645Opr9 = (JSPUtil.getParameter(request, prefix	+ "st6_45_opr9", length));
			String[] st545Opr5 = (JSPUtil.getParameter(request, prefix	+ "st5_45_opr5", length));
			String[] st545Opr2 = (JSPUtil.getParameter(request, prefix	+ "st5_45_opr2", length));
			String[] st545Opr3 = (JSPUtil.getParameter(request, prefix	+ "st5_45_opr3", length));
			String[] st1145Opr10 = (JSPUtil.getParameter(request, prefix	+ "st11_45_opr10", length));
			String[] st545Opr1 = (JSPUtil.getParameter(request, prefix	+ "st5_45_opr1", length));
			String[] st645Opr1 = (JSPUtil.getParameter(request, prefix	+ "st6_45_opr1", length));
			String[] st645Opr2 = (JSPUtil.getParameter(request, prefix	+ "st6_45_opr2", length));
			String[] st114hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st11_4h_opr8", length));
			String[] st114hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st11_4h_opr9", length));
			String[] st114hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st11_4h_opr4", length));
			String[] st114hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st11_4h_opr5", length));
			String[] st114hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st11_4h_opr6", length));
			String[] st114hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st11_4h_opr7", length));
			String[] st114hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st11_4h_opr1", length));
			String[] st114hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st11_4h_opr2", length));
			String[] st114hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st11_4h_opr3", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] st745Opr10 = (JSPUtil.getParameter(request, prefix	+ "st7_45_opr10", length));
			String[] st1320Opr10 = (JSPUtil.getParameter(request, prefix	+ "st13_20_opr10", length));
			String[] st122hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st12_2h_opr1", length));
			String[] st122hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st12_2h_opr2", length));
			String[] st122hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st12_2h_opr3", length));
			String[] st122hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st12_2h_opr4", length));
			String[] st122hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st12_2h_opr5", length));
			String[] st122hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st12_2h_opr6", length));
			String[] st122hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st12_2h_opr7", length));
			String[] st122hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st12_2h_opr8", length));
			String[] st845Opr5 = (JSPUtil.getParameter(request, prefix	+ "st8_45_opr5", length));
			String[] st104hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st10_4h_opr6", length));
			String[] st1445Opr9 = (JSPUtil.getParameter(request, prefix	+ "st14_45_opr9", length));
			String[] st104hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st10_4h_opr5", length));
			String[] st845Opr6 = (JSPUtil.getParameter(request, prefix	+ "st8_45_opr6", length));
			String[] st1445Opr8 = (JSPUtil.getParameter(request, prefix	+ "st14_45_opr8", length));
			String[] st1145Opr1 = (JSPUtil.getParameter(request, prefix	+ "st11_45_opr1", length));
			String[] st845Opr7 = (JSPUtil.getParameter(request, prefix	+ "st8_45_opr7", length));
			String[] st104hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st10_4h_opr8", length));
			String[] st1145Opr2 = (JSPUtil.getParameter(request, prefix	+ "st11_45_opr2", length));
			String[] st104hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st10_4h_opr7", length));
			String[] st845Opr8 = (JSPUtil.getParameter(request, prefix	+ "st8_45_opr8", length));
			String[] st1145Opr3 = (JSPUtil.getParameter(request, prefix	+ "st11_45_opr3", length));
			String[] st845Opr1 = (JSPUtil.getParameter(request, prefix	+ "st8_45_opr1", length));
			String[] st1445Opr5 = (JSPUtil.getParameter(request, prefix	+ "st14_45_opr5", length));
			String[] st1445Opr4 = (JSPUtil.getParameter(request, prefix	+ "st14_45_opr4", length));
			String[] st1145Opr4 = (JSPUtil.getParameter(request, prefix	+ "st11_45_opr4", length));
			String[] st845Opr2 = (JSPUtil.getParameter(request, prefix	+ "st8_45_opr2", length));
			String[] st104hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st10_4h_opr9", length));
			String[] st845Opr3 = (JSPUtil.getParameter(request, prefix	+ "st8_45_opr3", length));
			String[] st1145Opr5 = (JSPUtil.getParameter(request, prefix	+ "st11_45_opr5", length));
			String[] st1445Opr7 = (JSPUtil.getParameter(request, prefix	+ "st14_45_opr7", length));
			String[] st845Opr4 = (JSPUtil.getParameter(request, prefix	+ "st8_45_opr4", length));
			String[] st1145Opr6 = (JSPUtil.getParameter(request, prefix	+ "st11_45_opr6", length));
			String[] st1445Opr6 = (JSPUtil.getParameter(request, prefix	+ "st14_45_opr6", length));
			String[] st1445Opr1 = (JSPUtil.getParameter(request, prefix	+ "st14_45_opr1", length));
			String[] st1145Opr7 = (JSPUtil.getParameter(request, prefix	+ "st11_45_opr7", length));
			String[] st1145Opr8 = (JSPUtil.getParameter(request, prefix	+ "st11_45_opr8", length));
			String[] st1445Opr3 = (JSPUtil.getParameter(request, prefix	+ "st14_45_opr3", length));
			String[] st1145Opr9 = (JSPUtil.getParameter(request, prefix	+ "st11_45_opr9", length));
			String[] st1445Opr2 = (JSPUtil.getParameter(request, prefix	+ "st14_45_opr2", length));
			String[] st104hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st10_4h_opr2", length));
			String[] st104hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st10_4h_opr1", length));
			String[] st104hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st10_4h_opr4", length));
			String[] st104hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st10_4h_opr3", length));
			String[] st845Opr9 = (JSPUtil.getParameter(request, prefix	+ "st8_45_opr9", length));
			String[] st34hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st3_4h_opr2", length));
			String[] st34hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st3_4h_opr1", length));
			String[] st34hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st3_4h_opr4", length));
			String[] st34hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st3_4h_opr3", length));
			String[] st34hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st3_4h_opr6", length));
			String[] st34hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st3_4h_opr5", length));
			String[] st34hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st3_4h_opr8", length));
			String[] st34hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st3_4h_opr7", length));
			String[] st34hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st3_4h_opr9", length));
			String[] st1345Opr3 = (JSPUtil.getParameter(request, prefix	+ "st13_45_opr3", length));
			String[] st1345Opr4 = (JSPUtil.getParameter(request, prefix	+ "st13_45_opr4", length));
			String[] st1345Opr1 = (JSPUtil.getParameter(request, prefix	+ "st13_45_opr1", length));
			String[] st1345Opr2 = (JSPUtil.getParameter(request, prefix	+ "st13_45_opr2", length));
			String[] st1345Opr9 = (JSPUtil.getParameter(request, prefix	+ "st13_45_opr9", length));
			String[] st1345Opr7 = (JSPUtil.getParameter(request, prefix	+ "st13_45_opr7", length));
			String[] st1345Opr8 = (JSPUtil.getParameter(request, prefix	+ "st13_45_opr8", length));
			String[] st1345Opr5 = (JSPUtil.getParameter(request, prefix	+ "st13_45_opr5", length));
			String[] st1345Opr6 = (JSPUtil.getParameter(request, prefix	+ "st13_45_opr6", length));
			String[] st12hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st1_2h_opr10", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] st545Opr10 = (JSPUtil.getParameter(request, prefix	+ "st5_45_opr10", length));
			String[] st152hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st15_2h_opr8", length));
			String[] st152hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st15_2h_opr9", length));
			String[] st152hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st15_2h_opr6", length));
			String[] st152hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st15_2h_opr7", length));
			String[] st1140Opr1 = (JSPUtil.getParameter(request, prefix	+ "st11_40_opr1", length));
			String[] st1140Opr2 = (JSPUtil.getParameter(request, prefix	+ "st11_40_opr2", length));
			String[] st1140Opr3 = (JSPUtil.getParameter(request, prefix	+ "st11_40_opr3", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] st1420Opr10 = (JSPUtil.getParameter(request, prefix	+ "st14_20_opr10", length));
			String[] st142hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st14_2h_opr8", length));
			String[] st142hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st14_2h_opr7", length));
			String[] st142hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st14_2h_opr9", length));
			String[] st74hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st7_4h_opr9", length));
			String[] st74hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st7_4h_opr7", length));
			String[] st74hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st7_4h_opr8", length));
			String[] st74hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st7_4h_opr6", length));
			String[] st1220Opr9 = (JSPUtil.getParameter(request, prefix	+ "st12_20_opr9", length));
			String[] st74hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st7_4h_opr5", length));
			String[] st74hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st7_4h_opr4", length));
			String[] st74hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st7_4h_opr3", length));
			String[] st74hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st7_4h_opr2", length));
			String[] st74hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st7_4h_opr1", length));
			String[] opr10 = (JSPUtil.getParameter(request, prefix	+ "opr10", length));
			String[] st1220Opr1 = (JSPUtil.getParameter(request, prefix	+ "st12_20_opr1", length));
			String[] st1220Opr2 = (JSPUtil.getParameter(request, prefix	+ "st12_20_opr2", length));
			String[] st1220Opr3 = (JSPUtil.getParameter(request, prefix	+ "st12_20_opr3", length));
			String[] st1220Opr4 = (JSPUtil.getParameter(request, prefix	+ "st12_20_opr4", length));
			String[] st1220Opr5 = (JSPUtil.getParameter(request, prefix	+ "st12_20_opr5", length));
			String[] st1220Opr6 = (JSPUtil.getParameter(request, prefix	+ "st12_20_opr6", length));
			String[] st1220Opr7 = (JSPUtil.getParameter(request, prefix	+ "st12_20_opr7", length));
			String[] st124hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st12_4h_opr10", length));
			String[] st1220Opr8 = (JSPUtil.getParameter(request, prefix	+ "st12_20_opr8", length));
			String[] st82hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st8_2h_opr7", length));
			String[] st82hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st8_2h_opr6", length));
			String[] st82hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st8_2h_opr5", length));
			String[] st82hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st8_2h_opr4", length));
			String[] st82hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st8_2h_opr9", length));
			String[] st82hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st8_2h_opr8", length));
			String[] st82hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st8_2h_opr2", length));
			String[] st82hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st8_2h_opr3", length));
			String[] st82hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st8_2h_opr1", length));
			String[] st92hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st9_2h_opr3", length));
			String[] st92hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st9_2h_opr4", length));
			String[] st92hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st9_2h_opr5", length));
			String[] st92hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st9_2h_opr6", length));
			String[] st92hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st9_2h_opr7", length));
			String[] st92hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st9_2h_opr8", length));
			String[] st92hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st9_2h_opr9", length));
			String[] st1020Opr10 = (JSPUtil.getParameter(request, prefix	+ "st10_20_opr10", length));
			String[] st1140Opr9 = (JSPUtil.getParameter(request, prefix	+ "st11_40_opr9", length));
			String[] st1140Opr8 = (JSPUtil.getParameter(request, prefix	+ "st11_40_opr8", length));
			String[] st1140Opr7 = (JSPUtil.getParameter(request, prefix	+ "st11_40_opr7", length));
			String[] st1140Opr6 = (JSPUtil.getParameter(request, prefix	+ "st11_40_opr6", length));
			String[] st1140Opr5 = (JSPUtil.getParameter(request, prefix	+ "st11_40_opr5", length));
			String[] st1140Opr4 = (JSPUtil.getParameter(request, prefix	+ "st11_40_opr4", length));
			String[] st245Opr3 = (JSPUtil.getParameter(request, prefix	+ "st2_45_opr3", length));
			String[] st245Opr4 = (JSPUtil.getParameter(request, prefix	+ "st2_45_opr4", length));
			String[] st740Opr10 = (JSPUtil.getParameter(request, prefix	+ "st7_40_opr10", length));
			String[] st245Opr5 = (JSPUtil.getParameter(request, prefix	+ "st2_45_opr5", length));
			String[] st152hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st15_2h_opr1", length));
			String[] st245Opr6 = (JSPUtil.getParameter(request, prefix	+ "st2_45_opr6", length));
			String[] st152hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st15_2h_opr3", length));
			String[] st152hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st15_2h_opr2", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] st245Opr1 = (JSPUtil.getParameter(request, prefix	+ "st2_45_opr1", length));
			String[] st152hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st15_2h_opr5", length));
			String[] st152hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st15_2h_opr4", length));
			String[] st245Opr2 = (JSPUtil.getParameter(request, prefix	+ "st2_45_opr2", length));
			String[] st245Opr7 = (JSPUtil.getParameter(request, prefix	+ "st2_45_opr7", length));
			String[] st920Opr10 = (JSPUtil.getParameter(request, prefix	+ "st9_20_opr10", length));
			String[] st245Opr8 = (JSPUtil.getParameter(request, prefix	+ "st2_45_opr8", length));
			String[] st92hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st9_2h_opr2", length));
			String[] st245Opr9 = (JSPUtil.getParameter(request, prefix	+ "st2_45_opr9", length));
			String[] st92hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st9_2h_opr1", length));
			String[] st52hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st5_2h_opr2", length));
			String[] st52hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st5_2h_opr1", length));
			String[] st52hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st5_2h_opr6", length));
			String[] st52hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st5_2h_opr5", length));
			String[] st52hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st5_2h_opr4", length));
			String[] st52hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st5_2h_opr3", length));
			String[] st144hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st14_4h_opr10", length));
			String[] crrCd = (JSPUtil.getParameter(request, prefix	+ "crr_cd", length));
			String[] st52hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st5_2h_opr9", length));
			String[] st52hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st5_2h_opr7", length));
			String[] st52hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st5_2h_opr8", length));
			String[] st122hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st12_2h_opr9", length));
			String[] st124hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st12_4h_opr4", length));
			String[] st940Opr2 = (JSPUtil.getParameter(request, prefix	+ "st9_40_opr2", length));
			String[] st124hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st12_4h_opr3", length));
			String[] st940Opr1 = (JSPUtil.getParameter(request, prefix	+ "st9_40_opr1", length));
			String[] st940Opr4 = (JSPUtil.getParameter(request, prefix	+ "st9_40_opr4", length));
			String[] st124hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st12_4h_opr6", length));
			String[] st940Opr3 = (JSPUtil.getParameter(request, prefix	+ "st9_40_opr3", length));
			String[] st124hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st12_4h_opr5", length));
			String[] st124hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st12_4h_opr8", length));
			String[] st124hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st12_4h_opr7", length));
			String[] st245Opr10 = (JSPUtil.getParameter(request, prefix	+ "st2_45_opr10", length));
			String[] st124hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st12_4h_opr9", length));
			String[] st940Opr9 = (JSPUtil.getParameter(request, prefix	+ "st9_40_opr9", length));
			String[] st940Opr6 = (JSPUtil.getParameter(request, prefix	+ "st9_40_opr6", length));
			String[] st940Opr5 = (JSPUtil.getParameter(request, prefix	+ "st9_40_opr5", length));
			String[] st124hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st12_4h_opr2", length));
			String[] st940Opr8 = (JSPUtil.getParameter(request, prefix	+ "st9_40_opr8", length));
			String[] st32hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st3_2h_opr10", length));
			String[] st124hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st12_4h_opr1", length));
			String[] st940Opr7 = (JSPUtil.getParameter(request, prefix	+ "st9_40_opr7", length));
			String[] st142hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st14_2h_opr6", length));
			String[] st142hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st14_2h_opr5", length));
			String[] st142hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st14_2h_opr4", length));
			String[] st142hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st14_2h_opr3", length));
			String[] st142hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st14_2h_opr2", length));
			String[] st142hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st14_2h_opr1", length));
			String[] st94hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st9_4h_opr1", length));
			String[] st94hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st9_4h_opr2", length));
			String[] st94hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st9_4h_opr3", length));
			String[] st94hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st9_4h_opr4", length));
			String[] st1520Opr1 = (JSPUtil.getParameter(request, prefix	+ "st15_20_opr1", length));
			String[] st94hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st9_4h_opr9", length));
			String[] st112hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st11_2h_opr1", length));
			String[] st1520Opr5 = (JSPUtil.getParameter(request, prefix	+ "st15_20_opr5", length));
			String[] st94hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st9_4h_opr6", length));
			String[] st1520Opr4 = (JSPUtil.getParameter(request, prefix	+ "st15_20_opr4", length));
			String[] st94hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st9_4h_opr5", length));
			String[] st1520Opr3 = (JSPUtil.getParameter(request, prefix	+ "st15_20_opr3", length));
			String[] st94hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st9_4h_opr8", length));
			String[] st1520Opr2 = (JSPUtil.getParameter(request, prefix	+ "st15_20_opr2", length));
			String[] st94hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st9_4h_opr7", length));
			String[] st112hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st11_2h_opr6", length));
			String[] st1520Opr9 = (JSPUtil.getParameter(request, prefix	+ "st15_20_opr9", length));
			String[] st112hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st11_2h_opr7", length));
			String[] st1520Opr8 = (JSPUtil.getParameter(request, prefix	+ "st15_20_opr8", length));
			String[] st1520Opr7 = (JSPUtil.getParameter(request, prefix	+ "st15_20_opr7", length));
			String[] st112hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st11_2h_opr8", length));
			String[] st1520Opr6 = (JSPUtil.getParameter(request, prefix	+ "st15_20_opr6", length));
			String[] st112hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st11_2h_opr9", length));
			String[] st112hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st11_2h_opr2", length));
			String[] st112hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st11_2h_opr3", length));
			String[] st340Opr10 = (JSPUtil.getParameter(request, prefix	+ "st3_40_opr10", length));
			String[] st112hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st11_2h_opr4", length));
			String[] st112hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st11_2h_opr5", length));
			String[] st1120Opr7 = (JSPUtil.getParameter(request, prefix	+ "st11_20_opr7", length));
			String[] st1120Opr6 = (JSPUtil.getParameter(request, prefix	+ "st11_20_opr6", length));
			String[] st1120Opr9 = (JSPUtil.getParameter(request, prefix	+ "st11_20_opr9", length));
			String[] st1120Opr8 = (JSPUtil.getParameter(request, prefix	+ "st11_20_opr8", length));
			String[] st1120Opr3 = (JSPUtil.getParameter(request, prefix	+ "st11_20_opr3", length));
			String[] st1120Opr2 = (JSPUtil.getParameter(request, prefix	+ "st11_20_opr2", length));
			String[] st1120Opr5 = (JSPUtil.getParameter(request, prefix	+ "st11_20_opr5", length));
			String[] st1120Opr4 = (JSPUtil.getParameter(request, prefix	+ "st11_20_opr4", length));
			String[] st132hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st13_2h_opr4", length));
			String[] st132hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st13_2h_opr5", length));
			String[] st132hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st13_2h_opr6", length));
			String[] st132hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st13_2h_opr7", length));
			String[] st132hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st13_2h_opr1", length));
			String[] st132hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st13_2h_opr2", length));
			String[] st132hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st13_2h_opr3", length));
			String[] st24hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st2_4h_opr10", length));
			String[] st345Opr10 = (JSPUtil.getParameter(request, prefix	+ "st3_45_opr10", length));
			String[] qty1 = (JSPUtil.getParameter(request, prefix	+ "qty1", length));
			String[] qty3 = (JSPUtil.getParameter(request, prefix	+ "qty3", length));
			String[] qty2 = (JSPUtil.getParameter(request, prefix	+ "qty2", length));
			String[] qty5 = (JSPUtil.getParameter(request, prefix	+ "qty5", length));
			String[] qty4 = (JSPUtil.getParameter(request, prefix	+ "qty4", length));
			String[] st720Opr7 = (JSPUtil.getParameter(request, prefix	+ "st7_20_opr7", length));
			String[] st720Opr8 = (JSPUtil.getParameter(request, prefix	+ "st7_20_opr8", length));
			String[] st720Opr5 = (JSPUtil.getParameter(request, prefix	+ "st7_20_opr5", length));
			String[] st720Opr6 = (JSPUtil.getParameter(request, prefix	+ "st7_20_opr6", length));
			String[] st720Opr9 = (JSPUtil.getParameter(request, prefix	+ "st7_20_opr9", length));
			String[] st34hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st3_4h_opr10", length));
			String[] st62hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st6_2h_opr10", length));
			String[] st1440Opr10 = (JSPUtil.getParameter(request, prefix	+ "st14_40_opr10", length));
			String[] st720Opr3 = (JSPUtil.getParameter(request, prefix	+ "st7_20_opr3", length));
			String[] st720Opr4 = (JSPUtil.getParameter(request, prefix	+ "st7_20_opr4", length));
			String[] st720Opr1 = (JSPUtil.getParameter(request, prefix	+ "st7_20_opr1", length));
			String[] st720Opr2 = (JSPUtil.getParameter(request, prefix	+ "st7_20_opr2", length));
			String[] st1045Opr10 = (JSPUtil.getParameter(request, prefix	+ "st10_45_opr10", length));
			String[] st1540Opr1 = (JSPUtil.getParameter(request, prefix	+ "st15_40_opr1", length));
			String[] st1540Opr2 = (JSPUtil.getParameter(request, prefix	+ "st15_40_opr2", length));
			String[] st1540Opr3 = (JSPUtil.getParameter(request, prefix	+ "st15_40_opr3", length));
			String[] st1540Opr4 = (JSPUtil.getParameter(request, prefix	+ "st15_40_opr4", length));
			String[] st1540Opr5 = (JSPUtil.getParameter(request, prefix	+ "st15_40_opr5", length));
			String[] st1540Opr6 = (JSPUtil.getParameter(request, prefix	+ "st15_40_opr6", length));
			String[] st1540Opr7 = (JSPUtil.getParameter(request, prefix	+ "st15_40_opr7", length));
			String[] st1540Opr8 = (JSPUtil.getParameter(request, prefix	+ "st15_40_opr8", length));
			String[] st1540Opr9 = (JSPUtil.getParameter(request, prefix	+ "st15_40_opr9", length));
			String[] qty8 = (JSPUtil.getParameter(request, prefix	+ "qty8", length));
			String[] st1545Opr1 = (JSPUtil.getParameter(request, prefix	+ "st15_45_opr1", length));
			String[] st1545Opr2 = (JSPUtil.getParameter(request, prefix	+ "st15_45_opr2", length));
			String[] qty9 = (JSPUtil.getParameter(request, prefix	+ "qty9", length));
			String[] qty6 = (JSPUtil.getParameter(request, prefix	+ "qty6", length));
			String[] st420Opr10 = (JSPUtil.getParameter(request, prefix	+ "st4_20_opr10", length));
			String[] qty7 = (JSPUtil.getParameter(request, prefix	+ "qty7", length));
			String[] st1545Opr5 = (JSPUtil.getParameter(request, prefix	+ "st15_45_opr5", length));
			String[] st1545Opr6 = (JSPUtil.getParameter(request, prefix	+ "st15_45_opr6", length));
			String[] st1545Opr3 = (JSPUtil.getParameter(request, prefix	+ "st15_45_opr3", length));
			String[] st1545Opr4 = (JSPUtil.getParameter(request, prefix	+ "st15_45_opr4", length));
			String[] st1545Opr9 = (JSPUtil.getParameter(request, prefix	+ "st15_45_opr9", length));
			String[] st1545Opr7 = (JSPUtil.getParameter(request, prefix	+ "st15_45_opr7", length));
			String[] st1545Opr8 = (JSPUtil.getParameter(request, prefix	+ "st15_45_opr8", length));
			String[] st1320Opr1 = (JSPUtil.getParameter(request, prefix	+ "st13_20_opr1", length));
			String[] st1320Opr3 = (JSPUtil.getParameter(request, prefix	+ "st13_20_opr3", length));
			String[] st132hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st13_2h_opr9", length));
			String[] st1320Opr2 = (JSPUtil.getParameter(request, prefix	+ "st13_20_opr2", length));
			String[] st132hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st13_2h_opr8", length));
			String[] st1320Opr5 = (JSPUtil.getParameter(request, prefix	+ "st13_20_opr5", length));
			String[] st1320Opr4 = (JSPUtil.getParameter(request, prefix	+ "st13_20_opr4", length));
			String[] st1320Opr7 = (JSPUtil.getParameter(request, prefix	+ "st13_20_opr7", length));
			String[] st1320Opr6 = (JSPUtil.getParameter(request, prefix	+ "st13_20_opr6", length));
			String[] st1320Opr9 = (JSPUtil.getParameter(request, prefix	+ "st13_20_opr9", length));
			String[] st1320Opr8 = (JSPUtil.getParameter(request, prefix	+ "st13_20_opr8", length));
			String[] st340Opr1 = (JSPUtil.getParameter(request, prefix	+ "st3_40_opr1", length));
			String[] st340Opr2 = (JSPUtil.getParameter(request, prefix	+ "st3_40_opr2", length));
			String[] st340Opr9 = (JSPUtil.getParameter(request, prefix	+ "st3_40_opr9", length));
			String[] st340Opr8 = (JSPUtil.getParameter(request, prefix	+ "st3_40_opr8", length));
			String[] st340Opr7 = (JSPUtil.getParameter(request, prefix	+ "st3_40_opr7", length));
			String[] st340Opr6 = (JSPUtil.getParameter(request, prefix	+ "st3_40_opr6", length));
			String[] st340Opr5 = (JSPUtil.getParameter(request, prefix	+ "st3_40_opr5", length));
			String[] st340Opr4 = (JSPUtil.getParameter(request, prefix	+ "st3_40_opr4", length));
			String[] st340Opr3 = (JSPUtil.getParameter(request, prefix	+ "st3_40_opr3", length));
			String[] allFlg = (JSPUtil.getParameter(request, prefix	+ "all_flg", length));
			String[] st445Opr10 = (JSPUtil.getParameter(request, prefix	+ "st4_45_opr10", length));
			String[] st120Opr1 = (JSPUtil.getParameter(request, prefix	+ "st1_20_opr1", length));
			String[] st120Opr2 = (JSPUtil.getParameter(request, prefix	+ "st1_20_opr2", length));
			String[] st120Opr10 = (JSPUtil.getParameter(request, prefix	+ "st1_20_opr10", length));
			String[] st132hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st13_2h_opr10", length));
			String[] st120Opr4 = (JSPUtil.getParameter(request, prefix	+ "st1_20_opr4", length));
			String[] st120Opr3 = (JSPUtil.getParameter(request, prefix	+ "st1_20_opr3", length));
			String[] st120Opr6 = (JSPUtil.getParameter(request, prefix	+ "st1_20_opr6", length));
			String[] st120Opr5 = (JSPUtil.getParameter(request, prefix	+ "st1_20_opr5", length));
			String[] st120Opr8 = (JSPUtil.getParameter(request, prefix	+ "st1_20_opr8", length));
			String[] st120Opr7 = (JSPUtil.getParameter(request, prefix	+ "st1_20_opr7", length));
			String[] st120Opr9 = (JSPUtil.getParameter(request, prefix	+ "st1_20_opr9", length));
			String[] st1040Opr10 = (JSPUtil.getParameter(request, prefix	+ "st10_40_opr10", length));
			String[] st92hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st9_2h_opr10", length));
			String[] st1045Opr5 = (JSPUtil.getParameter(request, prefix	+ "st10_45_opr5", length));
			String[] st1045Opr4 = (JSPUtil.getParameter(request, prefix	+ "st10_45_opr4", length));
			String[] st1045Opr7 = (JSPUtil.getParameter(request, prefix	+ "st10_45_opr7", length));
			String[] st1045Opr6 = (JSPUtil.getParameter(request, prefix	+ "st10_45_opr6", length));
			String[] st1045Opr1 = (JSPUtil.getParameter(request, prefix	+ "st10_45_opr1", length));
			String[] st540Opr10 = (JSPUtil.getParameter(request, prefix	+ "st5_40_opr10", length));
			String[] st1045Opr3 = (JSPUtil.getParameter(request, prefix	+ "st10_45_opr3", length));
			String[] bbCgoFlg = (JSPUtil.getParameter(request, prefix	+ "bb_cgo_flg", length));
			String[] st1045Opr2 = (JSPUtil.getParameter(request, prefix	+ "st10_45_opr2", length));
			String[] st1045Opr9 = (JSPUtil.getParameter(request, prefix	+ "st10_45_opr9", length));
			String[] st1045Opr8 = (JSPUtil.getParameter(request, prefix	+ "st10_45_opr8", length));
			String[] mlbCd = (JSPUtil.getParameter(request, prefix	+ "mlb_cd", length));
			String[] st1520Opr10 = (JSPUtil.getParameter(request, prefix	+ "st15_20_opr10", length));
			String[] st345Opr7 = (JSPUtil.getParameter(request, prefix	+ "st3_45_opr7", length));
			String[] st345Opr6 = (JSPUtil.getParameter(request, prefix	+ "st3_45_opr6", length));
			String[] st345Opr9 = (JSPUtil.getParameter(request, prefix	+ "st3_45_opr9", length));
			String[] st345Opr8 = (JSPUtil.getParameter(request, prefix	+ "st3_45_opr8", length));
			String[] st1120Opr1 = (JSPUtil.getParameter(request, prefix	+ "st11_20_opr1", length));
			String[] st345Opr1 = (JSPUtil.getParameter(request, prefix	+ "st3_45_opr1", length));
			String[] st345Opr3 = (JSPUtil.getParameter(request, prefix	+ "st3_45_opr3", length));
			String[] st345Opr2 = (JSPUtil.getParameter(request, prefix	+ "st3_45_opr2", length));
			String[] st345Opr5 = (JSPUtil.getParameter(request, prefix	+ "st3_45_opr5", length));
			String[] st345Opr4 = (JSPUtil.getParameter(request, prefix	+ "st3_45_opr4", length));
			String[] st12hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st1_2h_opr2", length));
			String[] st12hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st1_2h_opr1", length));
			String[] st1340Opr1 = (JSPUtil.getParameter(request, prefix	+ "st13_40_opr1", length));
			String[] st12hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st1_2h_opr8", length));
			String[] st12hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st1_2h_opr7", length));
			String[] st12hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st1_2h_opr9", length));
			String[] st12hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st1_2h_opr4", length));
			String[] st12hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st1_2h_opr3", length));
			String[] st12hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st1_2h_opr6", length));
			String[] st12hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st1_2h_opr5", length));
			String[] st1420Opr6 = (JSPUtil.getParameter(request, prefix	+ "st14_20_opr6", length));
			String[] st1420Opr5 = (JSPUtil.getParameter(request, prefix	+ "st14_20_opr5", length));
			String[] st1420Opr4 = (JSPUtil.getParameter(request, prefix	+ "st14_20_opr4", length));
			String[] st1420Opr3 = (JSPUtil.getParameter(request, prefix	+ "st14_20_opr3", length));
			String[] st1420Opr2 = (JSPUtil.getParameter(request, prefix	+ "st14_20_opr2", length));
			String[] st1420Opr1 = (JSPUtil.getParameter(request, prefix	+ "st14_20_opr1", length));
			String[] st1420Opr9 = (JSPUtil.getParameter(request, prefix	+ "st14_20_opr9", length));
			String[] st1420Opr8 = (JSPUtil.getParameter(request, prefix	+ "st14_20_opr8", length));
			String[] st1420Opr7 = (JSPUtil.getParameter(request, prefix	+ "st14_20_opr7", length));
			String[] st84hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st8_4h_opr1", length));
			String[] st84hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st8_4h_opr3", length));
			String[] st84hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st8_4h_opr2", length));
			String[] st84hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st8_4h_opr5", length));
			String[] st84hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st8_4h_opr4", length));
			String[] st152hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st15_2h_opr10", length));
			String[] st84hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st8_4h_opr6", length));
			String[] st84hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st8_4h_opr7", length));
			String[] st84hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st8_4h_opr8", length));
			String[] st84hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st8_4h_opr9", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] st14hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st1_4h_opr10", length));
			String[] st640Opr8 = (JSPUtil.getParameter(request, prefix	+ "st6_40_opr8", length));
			String[] st1245Opr9 = (JSPUtil.getParameter(request, prefix	+ "st12_45_opr9", length));
			String[] st1245Opr8 = (JSPUtil.getParameter(request, prefix	+ "st12_45_opr8", length));
			String[] st640Opr9 = (JSPUtil.getParameter(request, prefix	+ "st6_40_opr9", length));
			String[] st1245Opr7 = (JSPUtil.getParameter(request, prefix	+ "st12_45_opr7", length));
			String[] st1245Opr6 = (JSPUtil.getParameter(request, prefix	+ "st12_45_opr6", length));
			String[] st640Opr4 = (JSPUtil.getParameter(request, prefix	+ "st6_40_opr4", length));
			String[] st1245Opr5 = (JSPUtil.getParameter(request, prefix	+ "st12_45_opr5", length));
			String[] st640Opr5 = (JSPUtil.getParameter(request, prefix	+ "st6_40_opr5", length));
			String[] st1245Opr4 = (JSPUtil.getParameter(request, prefix	+ "st12_45_opr4", length));
			String[] st1245Opr3 = (JSPUtil.getParameter(request, prefix	+ "st12_45_opr3", length));
			String[] st640Opr6 = (JSPUtil.getParameter(request, prefix	+ "st6_40_opr6", length));
			String[] st1245Opr2 = (JSPUtil.getParameter(request, prefix	+ "st12_45_opr2", length));
			String[] st640Opr7 = (JSPUtil.getParameter(request, prefix	+ "st6_40_opr7", length));
			String[] st1245Opr1 = (JSPUtil.getParameter(request, prefix	+ "st12_45_opr1", length));
			String[] st640Opr1 = (JSPUtil.getParameter(request, prefix	+ "st6_40_opr1", length));
			String[] st640Opr2 = (JSPUtil.getParameter(request, prefix	+ "st6_40_opr2", length));
			String[] st640Opr3 = (JSPUtil.getParameter(request, prefix	+ "st6_40_opr3", length));
			String[] st52hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st5_2h_opr10", length));
			String[] st1340Opr2 = (JSPUtil.getParameter(request, prefix	+ "st13_40_opr2", length));
			String[] st1340Opr3 = (JSPUtil.getParameter(request, prefix	+ "st13_40_opr3", length));
			String[] st1340Opr4 = (JSPUtil.getParameter(request, prefix	+ "st13_40_opr4", length));
			String[] st1340Opr5 = (JSPUtil.getParameter(request, prefix	+ "st13_40_opr5", length));
			String[] st1340Opr6 = (JSPUtil.getParameter(request, prefix	+ "st13_40_opr6", length));
			String[] st1340Opr7 = (JSPUtil.getParameter(request, prefix	+ "st13_40_opr7", length));
			String[] st1340Opr8 = (JSPUtil.getParameter(request, prefix	+ "st13_40_opr8", length));
			String[] st1340Opr9 = (JSPUtil.getParameter(request, prefix	+ "st13_40_opr9", length));
			String[] st945Opr1 = (JSPUtil.getParameter(request, prefix	+ "st9_45_opr1", length));
			String[] st945Opr3 = (JSPUtil.getParameter(request, prefix	+ "st9_45_opr3", length));
			String[] st945Opr2 = (JSPUtil.getParameter(request, prefix	+ "st9_45_opr2", length));
			String[] st945Opr5 = (JSPUtil.getParameter(request, prefix	+ "st9_45_opr5", length));
			String[] st945Opr4 = (JSPUtil.getParameter(request, prefix	+ "st9_45_opr4", length));
			String[] st945Opr7 = (JSPUtil.getParameter(request, prefix	+ "st9_45_opr7", length));
			String[] st945Opr6 = (JSPUtil.getParameter(request, prefix	+ "st9_45_opr6", length));
			String[] st64hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st6_4h_opr10", length));
			String[] st520Opr1 = (JSPUtil.getParameter(request, prefix	+ "st5_20_opr1", length));
			String[] st540Opr2 = (JSPUtil.getParameter(request, prefix	+ "st5_40_opr2", length));
			String[] st540Opr1 = (JSPUtil.getParameter(request, prefix	+ "st5_40_opr1", length));
			String[] st520Opr2 = (JSPUtil.getParameter(request, prefix	+ "st5_20_opr2", length));
			String[] st540Opr4 = (JSPUtil.getParameter(request, prefix	+ "st5_40_opr4", length));
			String[] st540Opr3 = (JSPUtil.getParameter(request, prefix	+ "st5_40_opr3", length));
			String[] qty10 = (JSPUtil.getParameter(request, prefix	+ "qty10", length));
			String[] st520Opr5 = (JSPUtil.getParameter(request, prefix	+ "st5_20_opr5", length));
			String[] st540Opr6 = (JSPUtil.getParameter(request, prefix	+ "st5_40_opr6", length));
			String[] st540Opr5 = (JSPUtil.getParameter(request, prefix	+ "st5_40_opr5", length));
			String[] st520Opr6 = (JSPUtil.getParameter(request, prefix	+ "st5_20_opr6", length));
			String[] st520Opr3 = (JSPUtil.getParameter(request, prefix	+ "st5_20_opr3", length));
			String[] st540Opr8 = (JSPUtil.getParameter(request, prefix	+ "st5_40_opr8", length));
			String[] st520Opr4 = (JSPUtil.getParameter(request, prefix	+ "st5_20_opr4", length));
			String[] st540Opr7 = (JSPUtil.getParameter(request, prefix	+ "st5_40_opr7", length));
			String[] st520Opr9 = (JSPUtil.getParameter(request, prefix	+ "st5_20_opr9", length));
			String[] st540Opr9 = (JSPUtil.getParameter(request, prefix	+ "st5_40_opr9", length));
			String[] st520Opr7 = (JSPUtil.getParameter(request, prefix	+ "st5_20_opr7", length));
			String[] st520Opr8 = (JSPUtil.getParameter(request, prefix	+ "st5_20_opr8", length));
			String[] st945Opr10 = (JSPUtil.getParameter(request, prefix	+ "st9_45_opr10", length));
			String[] st94hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st9_4h_opr10", length));
			String[] stwgCgoFlg = (JSPUtil.getParameter(request, prefix	+ "stwg_cgo_flg", length));
			String[] st1540Opr10 = (JSPUtil.getParameter(request, prefix	+ "st15_40_opr10", length));
			String[] st945Opr8 = (JSPUtil.getParameter(request, prefix	+ "st9_45_opr8", length));
			String[] st945Opr9 = (JSPUtil.getParameter(request, prefix	+ "st9_45_opr9", length));
			String[] st32hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st3_2h_opr9", length));
			String[] st24hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st2_4h_opr1", length));
			String[] st920Opr9 = (JSPUtil.getParameter(request, prefix	+ "st9_20_opr9", length));
			String[] st24hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st2_4h_opr3", length));
			String[] st920Opr8 = (JSPUtil.getParameter(request, prefix	+ "st9_20_opr8", length));
			String[] st24hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st2_4h_opr2", length));
			String[] st920Opr7 = (JSPUtil.getParameter(request, prefix	+ "st9_20_opr7", length));
			String[] st920Opr6 = (JSPUtil.getParameter(request, prefix	+ "st9_20_opr6", length));
			String[] st920Opr5 = (JSPUtil.getParameter(request, prefix	+ "st9_20_opr5", length));
			String[] st920Opr4 = (JSPUtil.getParameter(request, prefix	+ "st9_20_opr4", length));
			String[] st920Opr3 = (JSPUtil.getParameter(request, prefix	+ "st9_20_opr3", length));
			String[] st32hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st3_2h_opr4", length));
			String[] st920Opr2 = (JSPUtil.getParameter(request, prefix	+ "st9_20_opr2", length));
			String[] st24hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st2_4h_opr9", length));
			String[] st32hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st3_2h_opr3", length));
			String[] st920Opr1 = (JSPUtil.getParameter(request, prefix	+ "st9_20_opr1", length));
			String[] stwgCd = (JSPUtil.getParameter(request, prefix	+ "stwg_cd", length));
			String[] st24hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st2_4h_opr8", length));
			String[] st240Opr10 = (JSPUtil.getParameter(request, prefix	+ "st2_40_opr10", length));
			String[] st32hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st3_2h_opr2", length));
			String[] st32hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st3_2h_opr1", length));
			String[] st24hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st2_4h_opr5", length));
			String[] st32hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st3_2h_opr8", length));
			String[] st24hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st2_4h_opr4", length));
			String[] st32hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st3_2h_opr7", length));
			String[] st32hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st3_2h_opr6", length));
			String[] st24hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st2_4h_opr7", length));
			String[] st32hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st3_2h_opr5", length));
			String[] st24hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st2_4h_opr6", length));
			String[] st240Opr4 = (JSPUtil.getParameter(request, prefix	+ "st2_40_opr4", length));
			String[] st820Opr1 = (JSPUtil.getParameter(request, prefix	+ "st8_20_opr1", length));
			String[] st112hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st11_2h_opr10", length));
			String[] st240Opr5 = (JSPUtil.getParameter(request, prefix	+ "st2_40_opr5", length));
			String[] st820Opr3 = (JSPUtil.getParameter(request, prefix	+ "st8_20_opr3", length));
			String[] st240Opr6 = (JSPUtil.getParameter(request, prefix	+ "st2_40_opr6", length));
			String[] st820Opr2 = (JSPUtil.getParameter(request, prefix	+ "st8_20_opr2", length));
			String[] st240Opr7 = (JSPUtil.getParameter(request, prefix	+ "st2_40_opr7", length));
			String[] st240Opr8 = (JSPUtil.getParameter(request, prefix	+ "st2_40_opr8", length));
			String[] st240Opr9 = (JSPUtil.getParameter(request, prefix	+ "st2_40_opr9", length));
			String[] st64hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st6_4h_opr7", length));
			String[] st820Opr9 = (JSPUtil.getParameter(request, prefix	+ "st8_20_opr9", length));
			String[] st64hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st6_4h_opr6", length));
			String[] st820Opr8 = (JSPUtil.getParameter(request, prefix	+ "st8_20_opr8", length));
			String[] st64hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st6_4h_opr5", length));
			String[] st64hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st6_4h_opr4", length));
			String[] st64hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st6_4h_opr3", length));
			String[] st820Opr5 = (JSPUtil.getParameter(request, prefix	+ "st8_20_opr5", length));
			String[] st820Opr4 = (JSPUtil.getParameter(request, prefix	+ "st8_20_opr4", length));
			String[] st64hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st6_4h_opr2", length));
			String[] st64hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st6_4h_opr1", length));
			String[] st820Opr7 = (JSPUtil.getParameter(request, prefix	+ "st8_20_opr7", length));
			String[] st820Opr6 = (JSPUtil.getParameter(request, prefix	+ "st8_20_opr6", length));
			String[] st445Opr1 = (JSPUtil.getParameter(request, prefix	+ "st4_45_opr1", length));
			String[] st445Opr2 = (JSPUtil.getParameter(request, prefix	+ "st4_45_opr2", length));
			String[] st445Opr3 = (JSPUtil.getParameter(request, prefix	+ "st4_45_opr3", length));
			String[] st64hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st6_4h_opr8", length));
			String[] st445Opr4 = (JSPUtil.getParameter(request, prefix	+ "st4_45_opr4", length));
			String[] st64hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st6_4h_opr9", length));
			String[] st445Opr5 = (JSPUtil.getParameter(request, prefix	+ "st4_45_opr5", length));
			String[] st445Opr6 = (JSPUtil.getParameter(request, prefix	+ "st4_45_opr6", length));
			String[] st445Opr7 = (JSPUtil.getParameter(request, prefix	+ "st4_45_opr7", length));
			String[] st445Opr8 = (JSPUtil.getParameter(request, prefix	+ "st4_45_opr8", length));
			String[] st240Opr1 = (JSPUtil.getParameter(request, prefix	+ "st2_40_opr1", length));
			String[] st445Opr9 = (JSPUtil.getParameter(request, prefix	+ "st4_45_opr9", length));
			String[] st240Opr3 = (JSPUtil.getParameter(request, prefix	+ "st2_40_opr3", length));
			String[] st240Opr2 = (JSPUtil.getParameter(request, prefix	+ "st2_40_opr2", length));
			String[] st9 = (JSPUtil.getParameter(request, prefix	+ "st_9", length));
			String[] st7 = (JSPUtil.getParameter(request, prefix	+ "st_7", length));
			String[] st8 = (JSPUtil.getParameter(request, prefix	+ "st_8", length));
			String[] st5 = (JSPUtil.getParameter(request, prefix	+ "st_5", length));
			String[] st6 = (JSPUtil.getParameter(request, prefix	+ "st_6", length));
			String[] st3 = (JSPUtil.getParameter(request, prefix	+ "st_3", length));
			String[] st4 = (JSPUtil.getParameter(request, prefix	+ "st_4", length));
			String[] st1 = (JSPUtil.getParameter(request, prefix	+ "st_1", length));
			String[] st2 = (JSPUtil.getParameter(request, prefix	+ "st_2", length));
			String[] st940Opr10 = (JSPUtil.getParameter(request, prefix	+ "st9_40_opr10", length));
			String[] st1220Opr10 = (JSPUtil.getParameter(request, prefix	+ "st12_20_opr10", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] st320Opr9 = (JSPUtil.getParameter(request, prefix	+ "st3_20_opr9", length));
			String[] st320Opr8 = (JSPUtil.getParameter(request, prefix	+ "st3_20_opr8", length));
			String[] st320Opr7 = (JSPUtil.getParameter(request, prefix	+ "st3_20_opr7", length));
			String[] st320Opr6 = (JSPUtil.getParameter(request, prefix	+ "st3_20_opr6", length));
			String[] st320Opr5 = (JSPUtil.getParameter(request, prefix	+ "st3_20_opr5", length));
			String[] st42hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st4_2h_opr10", length));
			String[] st320Opr4 = (JSPUtil.getParameter(request, prefix	+ "st3_20_opr4", length));
			String[] st320Opr3 = (JSPUtil.getParameter(request, prefix	+ "st3_20_opr3", length));
			String[] st320Opr2 = (JSPUtil.getParameter(request, prefix	+ "st3_20_opr2", length));
			String[] st320Opr1 = (JSPUtil.getParameter(request, prefix	+ "st3_20_opr1", length));
			String[] st144hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st14_4h_opr9", length));
			String[] st645Opr10 = (JSPUtil.getParameter(request, prefix	+ "st6_45_opr10", length));
			String[] st22hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st2_2h_opr1", length));
			String[] st22hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st2_2h_opr8", length));
			String[] st22hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st2_2h_opr9", length));
			String[] st22hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st2_2h_opr6", length));
			String[] st22hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st2_2h_opr7", length));
			String[] st122hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st12_2h_opr10", length));
			String[] st104hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st10_4h_opr10", length));
			String[] st22hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st2_2h_opr4", length));
			String[] st22hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st2_2h_opr5", length));
			String[] st22hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st2_2h_opr2", length));
			String[] st22hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st2_2h_opr3", length));
			String[] st440Opr10 = (JSPUtil.getParameter(request, prefix	+ "st4_40_opr10", length));
			String[] st44hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st4_4h_opr6", length));
			String[] st44hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st4_4h_opr7", length));
			String[] st44hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st4_4h_opr8", length));
			String[] st44hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st4_4h_opr9", length));
			String[] st44hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st4_4h_opr2", length));
			String[] st44hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st4_4h_opr3", length));
			String[] st44hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st4_4h_opr4", length));
			String[] st44hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st4_4h_opr5", length));
			String[] st44hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st4_4h_opr1", length));
			String[] bkgShprOwnrFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_shpr_ownr_flg", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] st144hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st14_4h_opr1", length));
			String[] st144hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st14_4h_opr2", length));
			String[] st144hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st14_4h_opr3", length));
			String[] st74hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st7_4h_opr10", length));
			String[] st144hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st14_4h_opr4", length));
			String[] st144hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st14_4h_opr5", length));
			String[] st144hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st14_4h_opr6", length));
			String[] st144hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st14_4h_opr7", length));
			String[] st144hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st14_4h_opr8", length));
			String[] st72hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st7_2h_opr10", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] st420Opr9 = (JSPUtil.getParameter(request, prefix	+ "st4_20_opr9", length));
			String[] st420Opr8 = (JSPUtil.getParameter(request, prefix	+ "st4_20_opr8", length));
			String[] st420Opr5 = (JSPUtil.getParameter(request, prefix	+ "st4_20_opr5", length));
			String[] st420Opr4 = (JSPUtil.getParameter(request, prefix	+ "st4_20_opr4", length));
			String[] st420Opr7 = (JSPUtil.getParameter(request, prefix	+ "st4_20_opr7", length));
			String[] st420Opr6 = (JSPUtil.getParameter(request, prefix	+ "st4_20_opr6", length));
			String[] st420Opr1 = (JSPUtil.getParameter(request, prefix	+ "st4_20_opr1", length));
			String[] st420Opr3 = (JSPUtil.getParameter(request, prefix	+ "st4_20_opr3", length));
			String[] st420Opr2 = (JSPUtil.getParameter(request, prefix	+ "st4_20_opr2", length));
			String[] st840Opr9 = (JSPUtil.getParameter(request, prefix	+ "st8_40_opr9", length));
			String[] st840Opr8 = (JSPUtil.getParameter(request, prefix	+ "st8_40_opr8", length));
			String[] st840Opr7 = (JSPUtil.getParameter(request, prefix	+ "st8_40_opr7", length));
			String[] st840Opr6 = (JSPUtil.getParameter(request, prefix	+ "st8_40_opr6", length));
			String[] st22hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st2_2h_opr10", length));
			String[] st840Opr1 = (JSPUtil.getParameter(request, prefix	+ "st8_40_opr1", length));
			String[] st440Opr9 = (JSPUtil.getParameter(request, prefix	+ "st4_40_opr9", length));
			String[] st440Opr8 = (JSPUtil.getParameter(request, prefix	+ "st4_40_opr8", length));
			String[] st440Opr7 = (JSPUtil.getParameter(request, prefix	+ "st4_40_opr7", length));
			String[] st440Opr6 = (JSPUtil.getParameter(request, prefix	+ "st4_40_opr6", length));
			String[] st440Opr5 = (JSPUtil.getParameter(request, prefix	+ "st4_40_opr5", length));
			String[] st840Opr5 = (JSPUtil.getParameter(request, prefix	+ "st8_40_opr5", length));
			String[] st840Opr4 = (JSPUtil.getParameter(request, prefix	+ "st8_40_opr4", length));
			String[] st440Opr4 = (JSPUtil.getParameter(request, prefix	+ "st4_40_opr4", length));
			String[] st840Opr3 = (JSPUtil.getParameter(request, prefix	+ "st8_40_opr3", length));
			String[] st440Opr3 = (JSPUtil.getParameter(request, prefix	+ "st4_40_opr3", length));
			String[] st440Opr2 = (JSPUtil.getParameter(request, prefix	+ "st4_40_opr2", length));
			String[] st840Opr2 = (JSPUtil.getParameter(request, prefix	+ "st8_40_opr2", length));
			String[] st440Opr1 = (JSPUtil.getParameter(request, prefix	+ "st4_40_opr1", length));
			String[] st820Opr10 = (JSPUtil.getParameter(request, prefix	+ "st8_20_opr10", length));
			String[] st1120Opr10 = (JSPUtil.getParameter(request, prefix	+ "st11_20_opr10", length));
			String[] st620Opr9 = (JSPUtil.getParameter(request, prefix	+ "st6_20_opr9", length));
			String[] st620Opr8 = (JSPUtil.getParameter(request, prefix	+ "st6_20_opr8", length));
			String[] st620Opr7 = (JSPUtil.getParameter(request, prefix	+ "st6_20_opr7", length));
			String[] st620Opr6 = (JSPUtil.getParameter(request, prefix	+ "st6_20_opr6", length));
			String[] st620Opr1 = (JSPUtil.getParameter(request, prefix	+ "st6_20_opr1", length));
			String[] st620Opr5 = (JSPUtil.getParameter(request, prefix	+ "st6_20_opr5", length));
			String[] st620Opr4 = (JSPUtil.getParameter(request, prefix	+ "st6_20_opr4", length));
			String[] st620Opr3 = (JSPUtil.getParameter(request, prefix	+ "st6_20_opr3", length));
			String[] st620Opr2 = (JSPUtil.getParameter(request, prefix	+ "st6_20_opr2", length));
			String[] st1240Opr9 = (JSPUtil.getParameter(request, prefix	+ "st12_40_opr9", length));
			String[] st62hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st6_2h_opr1", length));
			String[] st1240Opr8 = (JSPUtil.getParameter(request, prefix	+ "st12_40_opr8", length));
			String[] st1240Opr7 = (JSPUtil.getParameter(request, prefix	+ "st12_40_opr7", length));
			String[] st62hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st6_2h_opr3", length));
			String[] st1240Opr6 = (JSPUtil.getParameter(request, prefix	+ "st12_40_opr6", length));
			String[] st62hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st6_2h_opr2", length));
			String[] st1240Opr5 = (JSPUtil.getParameter(request, prefix	+ "st12_40_opr5", length));
			String[] st62hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st6_2h_opr5", length));
			String[] st1240Opr4 = (JSPUtil.getParameter(request, prefix	+ "st12_40_opr4", length));
			String[] st62hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st6_2h_opr4", length));
			String[] st1240Opr3 = (JSPUtil.getParameter(request, prefix	+ "st12_40_opr3", length));
			String[] st62hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st6_2h_opr6", length));
			String[] st62hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st6_2h_opr7", length));
			String[] st62hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st6_2h_opr8", length));
			String[] st62hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st6_2h_opr9", length));
			String[] st134hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st13_4h_opr10", length));
			String[] st620Opr10 = (JSPUtil.getParameter(request, prefix	+ "st6_20_opr10", length));
			String[] st84hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st8_4h_opr10", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] st145Opr9 = (JSPUtil.getParameter(request, prefix	+ "st1_45_opr9", length));
			String[] st1245Opr10 = (JSPUtil.getParameter(request, prefix	+ "st12_45_opr10", length));
			String[] st145Opr8 = (JSPUtil.getParameter(request, prefix	+ "st1_45_opr8", length));
			String[] st154hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st15_4h_opr9", length));
			String[] st154hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st15_4h_opr8", length));
			String[] st1345Opr10 = (JSPUtil.getParameter(request, prefix	+ "st13_45_opr10", length));
			String[] st145Opr3 = (JSPUtil.getParameter(request, prefix	+ "st1_45_opr3", length));
			String[] st145Opr2 = (JSPUtil.getParameter(request, prefix	+ "st1_45_opr2", length));
			String[] st145Opr1 = (JSPUtil.getParameter(request, prefix	+ "st1_45_opr1", length));
			String[] st145Opr7 = (JSPUtil.getParameter(request, prefix	+ "st1_45_opr7", length));
			String[] st145Opr6 = (JSPUtil.getParameter(request, prefix	+ "st1_45_opr6", length));
			String[] st145Opr5 = (JSPUtil.getParameter(request, prefix	+ "st1_45_opr5", length));
			String[] st44hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st4_4h_opr10", length));
			String[] st145Opr4 = (JSPUtil.getParameter(request, prefix	+ "st1_45_opr4", length));
			String[] st54hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st5_4h_opr4", length));
			String[] opr7 = (JSPUtil.getParameter(request, prefix	+ "opr7", length));
			String[] st54hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st5_4h_opr3", length));
			String[] opr8 = (JSPUtil.getParameter(request, prefix	+ "opr8", length));
			String[] opr5 = (JSPUtil.getParameter(request, prefix	+ "opr5", length));
			String[] st54hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st5_4h_opr2", length));
			String[] st54hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st5_4h_opr1", length));
			String[] opr6 = (JSPUtil.getParameter(request, prefix	+ "opr6", length));
			String[] opr3 = (JSPUtil.getParameter(request, prefix	+ "opr3", length));
			String[] st54hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st5_4h_opr8", length));
			String[] opr4 = (JSPUtil.getParameter(request, prefix	+ "opr4", length));
			String[] st54hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st5_4h_opr7", length));
			String[] opr1 = (JSPUtil.getParameter(request, prefix	+ "opr1", length));
			String[] st54hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st5_4h_opr6", length));
			String[] st54hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st5_4h_opr5", length));
			String[] opr2 = (JSPUtil.getParameter(request, prefix	+ "opr2", length));
			String[] opr9 = (JSPUtil.getParameter(request, prefix	+ "opr9", length));
			String[] st54hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st5_4h_opr9", length));
			String[] st220Opr6 = (JSPUtil.getParameter(request, prefix	+ "st2_20_opr6", length));
			String[] st220Opr7 = (JSPUtil.getParameter(request, prefix	+ "st2_20_opr7", length));
			String[] st220Opr8 = (JSPUtil.getParameter(request, prefix	+ "st2_20_opr8", length));
			String[] st220Opr9 = (JSPUtil.getParameter(request, prefix	+ "st2_20_opr9", length));
			String[] st220Opr2 = (JSPUtil.getParameter(request, prefix	+ "st2_20_opr2", length));
			String[] st220Opr3 = (JSPUtil.getParameter(request, prefix	+ "st2_20_opr3", length));
			String[] st220Opr4 = (JSPUtil.getParameter(request, prefix	+ "st2_20_opr4", length));
			String[] st220Opr5 = (JSPUtil.getParameter(request, prefix	+ "st2_20_opr5", length));
			String[] st1020Opr2 = (JSPUtil.getParameter(request, prefix	+ "st10_20_opr2", length));
			String[] st1020Opr1 = (JSPUtil.getParameter(request, prefix	+ "st10_20_opr1", length));
			String[] st220Opr1 = (JSPUtil.getParameter(request, prefix	+ "st2_20_opr1", length));
			String[] st15 = (JSPUtil.getParameter(request, prefix	+ "st_15", length));
			String[] st14 = (JSPUtil.getParameter(request, prefix	+ "st_14", length));
			String[] st13 = (JSPUtil.getParameter(request, prefix	+ "st_13", length));
			String[] st12 = (JSPUtil.getParameter(request, prefix	+ "st_12", length));
			String[] st11 = (JSPUtil.getParameter(request, prefix	+ "st_11", length));
			String[] st10 = (JSPUtil.getParameter(request, prefix	+ "st_10", length));
			String[] st134hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st13_4h_opr1", length));
			String[] st134hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st13_4h_opr2", length));
			String[] st72hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st7_2h_opr5", length));
			String[] st134hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st13_4h_opr3", length));
			String[] st72hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st7_2h_opr6", length));
			String[] st134hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st13_4h_opr4", length));
			String[] st72hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st7_2h_opr7", length));
			String[] st134hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st13_4h_opr5", length));
			String[] st72hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st7_2h_opr8", length));
			String[] st134hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st13_4h_opr6", length));
			String[] st72hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st7_2h_opr9", length));
			String[] st134hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st13_4h_opr7", length));
			String[] st134hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st13_4h_opr8", length));
			String[] st134hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st13_4h_opr9", length));
			String[] st154hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st15_4h_opr1", length));
			String[] st154hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st15_4h_opr3", length));
			String[] st154hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st15_4h_opr2", length));
			String[] st1440Opr9 = (JSPUtil.getParameter(request, prefix	+ "st14_40_opr9", length));
			String[] st1040Opr4 = (JSPUtil.getParameter(request, prefix	+ "st10_40_opr4", length));
			String[] st72hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st7_2h_opr2", length));
			String[] st154hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st15_4h_opr5", length));
			String[] st154hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st15_4h_opr4", length));
			String[] st1040Opr3 = (JSPUtil.getParameter(request, prefix	+ "st10_40_opr3", length));
			String[] st72hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st7_2h_opr1", length));
			String[] st72hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st7_2h_opr4", length));
			String[] st1040Opr2 = (JSPUtil.getParameter(request, prefix	+ "st10_40_opr2", length));
			String[] st154hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st15_4h_opr7", length));
			String[] st72hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st7_2h_opr3", length));
			String[] st1040Opr1 = (JSPUtil.getParameter(request, prefix	+ "st10_40_opr1", length));
			String[] st154hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st15_4h_opr6", length));
			String[] st1440Opr4 = (JSPUtil.getParameter(request, prefix	+ "st14_40_opr4", length));
			String[] st1440Opr3 = (JSPUtil.getParameter(request, prefix	+ "st14_40_opr3", length));
			String[] st1440Opr2 = (JSPUtil.getParameter(request, prefix	+ "st14_40_opr2", length));
			String[] st1440Opr1 = (JSPUtil.getParameter(request, prefix	+ "st14_40_opr1", length));
			String[] st1440Opr8 = (JSPUtil.getParameter(request, prefix	+ "st14_40_opr8", length));
			String[] st1440Opr7 = (JSPUtil.getParameter(request, prefix	+ "st14_40_opr7", length));
			String[] st1440Opr6 = (JSPUtil.getParameter(request, prefix	+ "st14_40_opr6", length));
			String[] st1440Opr5 = (JSPUtil.getParameter(request, prefix	+ "st14_40_opr5", length));
			String[] st102hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st10_2h_opr1", length));
			String[] st102hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st10_2h_opr2", length));
			String[] st102hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st10_2h_opr7", length));
			String[] st102hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st10_2h_opr8", length));
			String[] st102hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st10_2h_opr9", length));
			String[] st102hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st10_2h_opr3", length));
			String[] st102hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st10_2h_opr4", length));
			String[] st102hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st10_2h_opr5", length));
			String[] st102hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st10_2h_opr6", length));
			String[] st320Opr10 = (JSPUtil.getParameter(request, prefix	+ "st3_20_opr10", length));
			String[] st1020Opr3 = (JSPUtil.getParameter(request, prefix	+ "st10_20_opr3", length));
			String[] st1020Opr4 = (JSPUtil.getParameter(request, prefix	+ "st10_20_opr4", length));
			String[] st1020Opr5 = (JSPUtil.getParameter(request, prefix	+ "st10_20_opr5", length));
			String[] st1020Opr6 = (JSPUtil.getParameter(request, prefix	+ "st10_20_opr6", length));
			String[] st1240Opr2 = (JSPUtil.getParameter(request, prefix	+ "st12_40_opr2", length));
			String[] st1020Opr7 = (JSPUtil.getParameter(request, prefix	+ "st10_20_opr7", length));
			String[] st1240Opr1 = (JSPUtil.getParameter(request, prefix	+ "st12_40_opr1", length));
			String[] st1020Opr8 = (JSPUtil.getParameter(request, prefix	+ "st10_20_opr8", length));
			String[] st1020Opr9 = (JSPUtil.getParameter(request, prefix	+ "st10_20_opr9", length));
			String[] st1240Opr10 = (JSPUtil.getParameter(request, prefix	+ "st12_40_opr10", length));
			String[] st14hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st1_4h_opr9", length));
			String[] st1140Opr10 = (JSPUtil.getParameter(request, prefix	+ "st11_40_opr10", length));
			String[] st14hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st1_4h_opr5", length));
			String[] st14hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st1_4h_opr6", length));
			String[] st14hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st1_4h_opr7", length));
			String[] st14hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st1_4h_opr8", length));
			String[] st14hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st1_4h_opr1", length));
			String[] st14hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st1_4h_opr2", length));
			String[] st14hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st1_4h_opr3", length));
			String[] st14hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st1_4h_opr4", length));
			String[] st840Opr10 = (JSPUtil.getParameter(request, prefix	+ "st8_40_opr10", length));
			String[] mlb = (JSPUtil.getParameter(request, prefix	+ "mlb", length));
			String[] st102hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st10_2h_opr10", length));
			String[] awkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_flg", length));
			String[] st42hOpr1 = (JSPUtil.getParameter(request, prefix	+ "st4_2h_opr1", length));
			String[] st1040Opr9 = (JSPUtil.getParameter(request, prefix	+ "st10_40_opr9", length));
			String[] st42hOpr3 = (JSPUtil.getParameter(request, prefix	+ "st4_2h_opr3", length));
			String[] st42hOpr2 = (JSPUtil.getParameter(request, prefix	+ "st4_2h_opr2", length));
			String[] st42hOpr5 = (JSPUtil.getParameter(request, prefix	+ "st4_2h_opr5", length));
			String[] st1040Opr6 = (JSPUtil.getParameter(request, prefix	+ "st10_40_opr6", length));
			String[] st220Opr10 = (JSPUtil.getParameter(request, prefix	+ "st2_20_opr10", length));
			String[] st42hOpr4 = (JSPUtil.getParameter(request, prefix	+ "st4_2h_opr4", length));
			String[] st1040Opr5 = (JSPUtil.getParameter(request, prefix	+ "st10_40_opr5", length));
			String[] st42hOpr7 = (JSPUtil.getParameter(request, prefix	+ "st4_2h_opr7", length));
			String[] st1040Opr8 = (JSPUtil.getParameter(request, prefix	+ "st10_40_opr8", length));
			String[] st42hOpr6 = (JSPUtil.getParameter(request, prefix	+ "st4_2h_opr6", length));
			String[] st1040Opr7 = (JSPUtil.getParameter(request, prefix	+ "st10_40_opr7", length));
			String[] st745Opr3 = (JSPUtil.getParameter(request, prefix	+ "st7_45_opr3", length));
			String[] st745Opr2 = (JSPUtil.getParameter(request, prefix	+ "st7_45_opr2", length));
			String[] st745Opr5 = (JSPUtil.getParameter(request, prefix	+ "st7_45_opr5", length));
			String[] st745Opr4 = (JSPUtil.getParameter(request, prefix	+ "st7_45_opr4", length));
			String[] st745Opr7 = (JSPUtil.getParameter(request, prefix	+ "st7_45_opr7", length));
			String[] st745Opr6 = (JSPUtil.getParameter(request, prefix	+ "st7_45_opr6", length));
			String[] st745Opr9 = (JSPUtil.getParameter(request, prefix	+ "st7_45_opr9", length));
			String[] st745Opr8 = (JSPUtil.getParameter(request, prefix	+ "st7_45_opr8", length));
			String[] st42hOpr8 = (JSPUtil.getParameter(request, prefix	+ "st4_2h_opr8", length));
			String[] st42hOpr9 = (JSPUtil.getParameter(request, prefix	+ "st4_2h_opr9", length));
			String[] st745Opr1 = (JSPUtil.getParameter(request, prefix	+ "st7_45_opr1", length));
			String[] st114hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st11_4h_opr10", length));
			String[] st140Opr6 = (JSPUtil.getParameter(request, prefix	+ "st1_40_opr6", length));
			String[] st140Opr5 = (JSPUtil.getParameter(request, prefix	+ "st1_40_opr5", length));
			String[] st140Opr8 = (JSPUtil.getParameter(request, prefix	+ "st1_40_opr8", length));
			String[] st140Opr7 = (JSPUtil.getParameter(request, prefix	+ "st1_40_opr7", length));
			String[] st140Opr9 = (JSPUtil.getParameter(request, prefix	+ "st1_40_opr9", length));
			String[] st142hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st14_2h_opr10", length));
			String[] st140Opr1 = (JSPUtil.getParameter(request, prefix	+ "st1_40_opr1", length));
			String[] st140Opr2 = (JSPUtil.getParameter(request, prefix	+ "st1_40_opr2", length));
			String[] st140Opr3 = (JSPUtil.getParameter(request, prefix	+ "st1_40_opr3", length));
			String[] st54hOpr10 = (JSPUtil.getParameter(request, prefix	+ "st5_4h_opr10", length));
			String[] st140Opr4 = (JSPUtil.getParameter(request, prefix	+ "st1_40_opr4", length));
			String[] podYdCd = (JSPUtil.getParameter(request,   prefix  + "pod_yd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CBFSpecialStwgVO();
				if (st720Opr10[i] != null)
					model.setSt720Opr10(st720Opr10[i]);
				if (st740Opr7[i] != null)
					model.setSt740Opr7(st740Opr7[i]);
				if (st1445Opr10[i] != null)
					model.setSt1445Opr10(st1445Opr10[i]);
				if (st740Opr8[i] != null)
					model.setSt740Opr8(st740Opr8[i]);
				if (st740Opr9[i] != null)
					model.setSt740Opr9(st740Opr9[i]);
				if (st140Opr10[i] != null)
					model.setSt140Opr10(st140Opr10[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (st740Opr1[i] != null)
					model.setSt740Opr1(st740Opr1[i]);
				if (st740Opr2[i] != null)
					model.setSt740Opr2(st740Opr2[i]);
				if (st740Opr3[i] != null)
					model.setSt740Opr3(st740Opr3[i]);
				if (st740Opr4[i] != null)
					model.setSt740Opr4(st740Opr4[i]);
				if (st740Opr5[i] != null)
					model.setSt740Opr5(st740Opr5[i]);
				if (st740Opr6[i] != null)
					model.setSt740Opr6(st740Opr6[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (st145Opr10[i] != null)
					model.setSt145Opr10(st145Opr10[i]);
				if (st1545Opr10[i] != null)
					model.setSt1545Opr10(st1545Opr10[i]);
				if (st640Opr10[i] != null)
					model.setSt640Opr10(st640Opr10[i]);
				if (st1340Opr10[i] != null)
					model.setSt1340Opr10(st1340Opr10[i]);
				if (st520Opr10[i] != null)
					model.setSt520Opr10(st520Opr10[i]);
				if (st154hOpr10[i] != null)
					model.setSt154hOpr10(st154hOpr10[i]);
				if (st82hOpr10[i] != null)
					model.setSt82hOpr10(st82hOpr10[i]);
				if (st845Opr10[i] != null)
					model.setSt845Opr10(st845Opr10[i]);
				if (st645Opr3[i] != null)
					model.setSt645Opr3(st645Opr3[i]);
				if (st645Opr4[i] != null)
					model.setSt645Opr4(st645Opr4[i]);
				if (st645Opr5[i] != null)
					model.setSt645Opr5(st645Opr5[i]);
				if (st545Opr8[i] != null)
					model.setSt545Opr8(st545Opr8[i]);
				if (st645Opr6[i] != null)
					model.setSt645Opr6(st645Opr6[i]);
				if (st545Opr9[i] != null)
					model.setSt545Opr9(st545Opr9[i]);
				if (st545Opr6[i] != null)
					model.setSt545Opr6(st545Opr6[i]);
				if (st645Opr7[i] != null)
					model.setSt645Opr7(st645Opr7[i]);
				if (st545Opr7[i] != null)
					model.setSt545Opr7(st545Opr7[i]);
				if (st645Opr8[i] != null)
					model.setSt645Opr8(st645Opr8[i]);
				if (st545Opr4[i] != null)
					model.setSt545Opr4(st545Opr4[i]);
				if (st645Opr9[i] != null)
					model.setSt645Opr9(st645Opr9[i]);
				if (st545Opr5[i] != null)
					model.setSt545Opr5(st545Opr5[i]);
				if (st545Opr2[i] != null)
					model.setSt545Opr2(st545Opr2[i]);
				if (st545Opr3[i] != null)
					model.setSt545Opr3(st545Opr3[i]);
				if (st1145Opr10[i] != null)
					model.setSt1145Opr10(st1145Opr10[i]);
				if (st545Opr1[i] != null)
					model.setSt545Opr1(st545Opr1[i]);
				if (st645Opr1[i] != null)
					model.setSt645Opr1(st645Opr1[i]);
				if (st645Opr2[i] != null)
					model.setSt645Opr2(st645Opr2[i]);
				if (st114hOpr8[i] != null)
					model.setSt114hOpr8(st114hOpr8[i]);
				if (st114hOpr9[i] != null)
					model.setSt114hOpr9(st114hOpr9[i]);
				if (st114hOpr4[i] != null)
					model.setSt114hOpr4(st114hOpr4[i]);
				if (st114hOpr5[i] != null)
					model.setSt114hOpr5(st114hOpr5[i]);
				if (st114hOpr6[i] != null)
					model.setSt114hOpr6(st114hOpr6[i]);
				if (st114hOpr7[i] != null)
					model.setSt114hOpr7(st114hOpr7[i]);
				if (st114hOpr1[i] != null)
					model.setSt114hOpr1(st114hOpr1[i]);
				if (st114hOpr2[i] != null)
					model.setSt114hOpr2(st114hOpr2[i]);
				if (st114hOpr3[i] != null)
					model.setSt114hOpr3(st114hOpr3[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (st745Opr10[i] != null)
					model.setSt745Opr10(st745Opr10[i]);
				if (st1320Opr10[i] != null)
					model.setSt1320Opr10(st1320Opr10[i]);
				if (st122hOpr1[i] != null)
					model.setSt122hOpr1(st122hOpr1[i]);
				if (st122hOpr2[i] != null)
					model.setSt122hOpr2(st122hOpr2[i]);
				if (st122hOpr3[i] != null)
					model.setSt122hOpr3(st122hOpr3[i]);
				if (st122hOpr4[i] != null)
					model.setSt122hOpr4(st122hOpr4[i]);
				if (st122hOpr5[i] != null)
					model.setSt122hOpr5(st122hOpr5[i]);
				if (st122hOpr6[i] != null)
					model.setSt122hOpr6(st122hOpr6[i]);
				if (st122hOpr7[i] != null)
					model.setSt122hOpr7(st122hOpr7[i]);
				if (st122hOpr8[i] != null)
					model.setSt122hOpr8(st122hOpr8[i]);
				if (st845Opr5[i] != null)
					model.setSt845Opr5(st845Opr5[i]);
				if (st104hOpr6[i] != null)
					model.setSt104hOpr6(st104hOpr6[i]);
				if (st1445Opr9[i] != null)
					model.setSt1445Opr9(st1445Opr9[i]);
				if (st104hOpr5[i] != null)
					model.setSt104hOpr5(st104hOpr5[i]);
				if (st845Opr6[i] != null)
					model.setSt845Opr6(st845Opr6[i]);
				if (st1445Opr8[i] != null)
					model.setSt1445Opr8(st1445Opr8[i]);
				if (st1145Opr1[i] != null)
					model.setSt1145Opr1(st1145Opr1[i]);
				if (st845Opr7[i] != null)
					model.setSt845Opr7(st845Opr7[i]);
				if (st104hOpr8[i] != null)
					model.setSt104hOpr8(st104hOpr8[i]);
				if (st1145Opr2[i] != null)
					model.setSt1145Opr2(st1145Opr2[i]);
				if (st104hOpr7[i] != null)
					model.setSt104hOpr7(st104hOpr7[i]);
				if (st845Opr8[i] != null)
					model.setSt845Opr8(st845Opr8[i]);
				if (st1145Opr3[i] != null)
					model.setSt1145Opr3(st1145Opr3[i]);
				if (st845Opr1[i] != null)
					model.setSt845Opr1(st845Opr1[i]);
				if (st1445Opr5[i] != null)
					model.setSt1445Opr5(st1445Opr5[i]);
				if (st1445Opr4[i] != null)
					model.setSt1445Opr4(st1445Opr4[i]);
				if (st1145Opr4[i] != null)
					model.setSt1145Opr4(st1145Opr4[i]);
				if (st845Opr2[i] != null)
					model.setSt845Opr2(st845Opr2[i]);
				if (st104hOpr9[i] != null)
					model.setSt104hOpr9(st104hOpr9[i]);
				if (st845Opr3[i] != null)
					model.setSt845Opr3(st845Opr3[i]);
				if (st1145Opr5[i] != null)
					model.setSt1145Opr5(st1145Opr5[i]);
				if (st1445Opr7[i] != null)
					model.setSt1445Opr7(st1445Opr7[i]);
				if (st845Opr4[i] != null)
					model.setSt845Opr4(st845Opr4[i]);
				if (st1145Opr6[i] != null)
					model.setSt1145Opr6(st1145Opr6[i]);
				if (st1445Opr6[i] != null)
					model.setSt1445Opr6(st1445Opr6[i]);
				if (st1445Opr1[i] != null)
					model.setSt1445Opr1(st1445Opr1[i]);
				if (st1145Opr7[i] != null)
					model.setSt1145Opr7(st1145Opr7[i]);
				if (st1145Opr8[i] != null)
					model.setSt1145Opr8(st1145Opr8[i]);
				if (st1445Opr3[i] != null)
					model.setSt1445Opr3(st1445Opr3[i]);
				if (st1145Opr9[i] != null)
					model.setSt1145Opr9(st1145Opr9[i]);
				if (st1445Opr2[i] != null)
					model.setSt1445Opr2(st1445Opr2[i]);
				if (st104hOpr2[i] != null)
					model.setSt104hOpr2(st104hOpr2[i]);
				if (st104hOpr1[i] != null)
					model.setSt104hOpr1(st104hOpr1[i]);
				if (st104hOpr4[i] != null)
					model.setSt104hOpr4(st104hOpr4[i]);
				if (st104hOpr3[i] != null)
					model.setSt104hOpr3(st104hOpr3[i]);
				if (st845Opr9[i] != null)
					model.setSt845Opr9(st845Opr9[i]);
				if (st34hOpr2[i] != null)
					model.setSt34hOpr2(st34hOpr2[i]);
				if (st34hOpr1[i] != null)
					model.setSt34hOpr1(st34hOpr1[i]);
				if (st34hOpr4[i] != null)
					model.setSt34hOpr4(st34hOpr4[i]);
				if (st34hOpr3[i] != null)
					model.setSt34hOpr3(st34hOpr3[i]);
				if (st34hOpr6[i] != null)
					model.setSt34hOpr6(st34hOpr6[i]);
				if (st34hOpr5[i] != null)
					model.setSt34hOpr5(st34hOpr5[i]);
				if (st34hOpr8[i] != null)
					model.setSt34hOpr8(st34hOpr8[i]);
				if (st34hOpr7[i] != null)
					model.setSt34hOpr7(st34hOpr7[i]);
				if (st34hOpr9[i] != null)
					model.setSt34hOpr9(st34hOpr9[i]);
				if (st1345Opr3[i] != null)
					model.setSt1345Opr3(st1345Opr3[i]);
				if (st1345Opr4[i] != null)
					model.setSt1345Opr4(st1345Opr4[i]);
				if (st1345Opr1[i] != null)
					model.setSt1345Opr1(st1345Opr1[i]);
				if (st1345Opr2[i] != null)
					model.setSt1345Opr2(st1345Opr2[i]);
				if (st1345Opr9[i] != null)
					model.setSt1345Opr9(st1345Opr9[i]);
				if (st1345Opr7[i] != null)
					model.setSt1345Opr7(st1345Opr7[i]);
				if (st1345Opr8[i] != null)
					model.setSt1345Opr8(st1345Opr8[i]);
				if (st1345Opr5[i] != null)
					model.setSt1345Opr5(st1345Opr5[i]);
				if (st1345Opr6[i] != null)
					model.setSt1345Opr6(st1345Opr6[i]);
				if (st12hOpr10[i] != null)
					model.setSt12hOpr10(st12hOpr10[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (st545Opr10[i] != null)
					model.setSt545Opr10(st545Opr10[i]);
				if (st152hOpr8[i] != null)
					model.setSt152hOpr8(st152hOpr8[i]);
				if (st152hOpr9[i] != null)
					model.setSt152hOpr9(st152hOpr9[i]);
				if (st152hOpr6[i] != null)
					model.setSt152hOpr6(st152hOpr6[i]);
				if (st152hOpr7[i] != null)
					model.setSt152hOpr7(st152hOpr7[i]);
				if (st1140Opr1[i] != null)
					model.setSt1140Opr1(st1140Opr1[i]);
				if (st1140Opr2[i] != null)
					model.setSt1140Opr2(st1140Opr2[i]);
				if (st1140Opr3[i] != null)
					model.setSt1140Opr3(st1140Opr3[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (st1420Opr10[i] != null)
					model.setSt1420Opr10(st1420Opr10[i]);
				if (st142hOpr8[i] != null)
					model.setSt142hOpr8(st142hOpr8[i]);
				if (st142hOpr7[i] != null)
					model.setSt142hOpr7(st142hOpr7[i]);
				if (st142hOpr9[i] != null)
					model.setSt142hOpr9(st142hOpr9[i]);
				if (st74hOpr9[i] != null)
					model.setSt74hOpr9(st74hOpr9[i]);
				if (st74hOpr7[i] != null)
					model.setSt74hOpr7(st74hOpr7[i]);
				if (st74hOpr8[i] != null)
					model.setSt74hOpr8(st74hOpr8[i]);
				if (st74hOpr6[i] != null)
					model.setSt74hOpr6(st74hOpr6[i]);
				if (st1220Opr9[i] != null)
					model.setSt1220Opr9(st1220Opr9[i]);
				if (st74hOpr5[i] != null)
					model.setSt74hOpr5(st74hOpr5[i]);
				if (st74hOpr4[i] != null)
					model.setSt74hOpr4(st74hOpr4[i]);
				if (st74hOpr3[i] != null)
					model.setSt74hOpr3(st74hOpr3[i]);
				if (st74hOpr2[i] != null)
					model.setSt74hOpr2(st74hOpr2[i]);
				if (st74hOpr1[i] != null)
					model.setSt74hOpr1(st74hOpr1[i]);
				if (opr10[i] != null)
					model.setOpr10(opr10[i]);
				if (st1220Opr1[i] != null)
					model.setSt1220Opr1(st1220Opr1[i]);
				if (st1220Opr2[i] != null)
					model.setSt1220Opr2(st1220Opr2[i]);
				if (st1220Opr3[i] != null)
					model.setSt1220Opr3(st1220Opr3[i]);
				if (st1220Opr4[i] != null)
					model.setSt1220Opr4(st1220Opr4[i]);
				if (st1220Opr5[i] != null)
					model.setSt1220Opr5(st1220Opr5[i]);
				if (st1220Opr6[i] != null)
					model.setSt1220Opr6(st1220Opr6[i]);
				if (st1220Opr7[i] != null)
					model.setSt1220Opr7(st1220Opr7[i]);
				if (st124hOpr10[i] != null)
					model.setSt124hOpr10(st124hOpr10[i]);
				if (st1220Opr8[i] != null)
					model.setSt1220Opr8(st1220Opr8[i]);
				if (st82hOpr7[i] != null)
					model.setSt82hOpr7(st82hOpr7[i]);
				if (st82hOpr6[i] != null)
					model.setSt82hOpr6(st82hOpr6[i]);
				if (st82hOpr5[i] != null)
					model.setSt82hOpr5(st82hOpr5[i]);
				if (st82hOpr4[i] != null)
					model.setSt82hOpr4(st82hOpr4[i]);
				if (st82hOpr9[i] != null)
					model.setSt82hOpr9(st82hOpr9[i]);
				if (st82hOpr8[i] != null)
					model.setSt82hOpr8(st82hOpr8[i]);
				if (st82hOpr2[i] != null)
					model.setSt82hOpr2(st82hOpr2[i]);
				if (st82hOpr3[i] != null)
					model.setSt82hOpr3(st82hOpr3[i]);
				if (st82hOpr1[i] != null)
					model.setSt82hOpr1(st82hOpr1[i]);
				if (st92hOpr3[i] != null)
					model.setSt92hOpr3(st92hOpr3[i]);
				if (st92hOpr4[i] != null)
					model.setSt92hOpr4(st92hOpr4[i]);
				if (st92hOpr5[i] != null)
					model.setSt92hOpr5(st92hOpr5[i]);
				if (st92hOpr6[i] != null)
					model.setSt92hOpr6(st92hOpr6[i]);
				if (st92hOpr7[i] != null)
					model.setSt92hOpr7(st92hOpr7[i]);
				if (st92hOpr8[i] != null)
					model.setSt92hOpr8(st92hOpr8[i]);
				if (st92hOpr9[i] != null)
					model.setSt92hOpr9(st92hOpr9[i]);
				if (st1020Opr10[i] != null)
					model.setSt1020Opr10(st1020Opr10[i]);
				if (st1140Opr9[i] != null)
					model.setSt1140Opr9(st1140Opr9[i]);
				if (st1140Opr8[i] != null)
					model.setSt1140Opr8(st1140Opr8[i]);
				if (st1140Opr7[i] != null)
					model.setSt1140Opr7(st1140Opr7[i]);
				if (st1140Opr6[i] != null)
					model.setSt1140Opr6(st1140Opr6[i]);
				if (st1140Opr5[i] != null)
					model.setSt1140Opr5(st1140Opr5[i]);
				if (st1140Opr4[i] != null)
					model.setSt1140Opr4(st1140Opr4[i]);
				if (st245Opr3[i] != null)
					model.setSt245Opr3(st245Opr3[i]);
				if (st245Opr4[i] != null)
					model.setSt245Opr4(st245Opr4[i]);
				if (st740Opr10[i] != null)
					model.setSt740Opr10(st740Opr10[i]);
				if (st245Opr5[i] != null)
					model.setSt245Opr5(st245Opr5[i]);
				if (st152hOpr1[i] != null)
					model.setSt152hOpr1(st152hOpr1[i]);
				if (st245Opr6[i] != null)
					model.setSt245Opr6(st245Opr6[i]);
				if (st152hOpr3[i] != null)
					model.setSt152hOpr3(st152hOpr3[i]);
				if (st152hOpr2[i] != null)
					model.setSt152hOpr2(st152hOpr2[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (st245Opr1[i] != null)
					model.setSt245Opr1(st245Opr1[i]);
				if (st152hOpr5[i] != null)
					model.setSt152hOpr5(st152hOpr5[i]);
				if (st152hOpr4[i] != null)
					model.setSt152hOpr4(st152hOpr4[i]);
				if (st245Opr2[i] != null)
					model.setSt245Opr2(st245Opr2[i]);
				if (st245Opr7[i] != null)
					model.setSt245Opr7(st245Opr7[i]);
				if (st920Opr10[i] != null)
					model.setSt920Opr10(st920Opr10[i]);
				if (st245Opr8[i] != null)
					model.setSt245Opr8(st245Opr8[i]);
				if (st92hOpr2[i] != null)
					model.setSt92hOpr2(st92hOpr2[i]);
				if (st245Opr9[i] != null)
					model.setSt245Opr9(st245Opr9[i]);
				if (st92hOpr1[i] != null)
					model.setSt92hOpr1(st92hOpr1[i]);
				if (st52hOpr2[i] != null)
					model.setSt52hOpr2(st52hOpr2[i]);
				if (st52hOpr1[i] != null)
					model.setSt52hOpr1(st52hOpr1[i]);
				if (st52hOpr6[i] != null)
					model.setSt52hOpr6(st52hOpr6[i]);
				if (st52hOpr5[i] != null)
					model.setSt52hOpr5(st52hOpr5[i]);
				if (st52hOpr4[i] != null)
					model.setSt52hOpr4(st52hOpr4[i]);
				if (st52hOpr3[i] != null)
					model.setSt52hOpr3(st52hOpr3[i]);
				if (st144hOpr10[i] != null)
					model.setSt144hOpr10(st144hOpr10[i]);
				if (crrCd[i] != null)
					model.setCrrCd(crrCd[i]);
				if (st52hOpr9[i] != null)
					model.setSt52hOpr9(st52hOpr9[i]);
				if (st52hOpr7[i] != null)
					model.setSt52hOpr7(st52hOpr7[i]);
				if (st52hOpr8[i] != null)
					model.setSt52hOpr8(st52hOpr8[i]);
				if (st122hOpr9[i] != null)
					model.setSt122hOpr9(st122hOpr9[i]);
				if (st124hOpr4[i] != null)
					model.setSt124hOpr4(st124hOpr4[i]);
				if (st940Opr2[i] != null)
					model.setSt940Opr2(st940Opr2[i]);
				if (st124hOpr3[i] != null)
					model.setSt124hOpr3(st124hOpr3[i]);
				if (st940Opr1[i] != null)
					model.setSt940Opr1(st940Opr1[i]);
				if (st940Opr4[i] != null)
					model.setSt940Opr4(st940Opr4[i]);
				if (st124hOpr6[i] != null)
					model.setSt124hOpr6(st124hOpr6[i]);
				if (st940Opr3[i] != null)
					model.setSt940Opr3(st940Opr3[i]);
				if (st124hOpr5[i] != null)
					model.setSt124hOpr5(st124hOpr5[i]);
				if (st124hOpr8[i] != null)
					model.setSt124hOpr8(st124hOpr8[i]);
				if (st124hOpr7[i] != null)
					model.setSt124hOpr7(st124hOpr7[i]);
				if (st245Opr10[i] != null)
					model.setSt245Opr10(st245Opr10[i]);
				if (st124hOpr9[i] != null)
					model.setSt124hOpr9(st124hOpr9[i]);
				if (st940Opr9[i] != null)
					model.setSt940Opr9(st940Opr9[i]);
				if (st940Opr6[i] != null)
					model.setSt940Opr6(st940Opr6[i]);
				if (st940Opr5[i] != null)
					model.setSt940Opr5(st940Opr5[i]);
				if (st124hOpr2[i] != null)
					model.setSt124hOpr2(st124hOpr2[i]);
				if (st940Opr8[i] != null)
					model.setSt940Opr8(st940Opr8[i]);
				if (st32hOpr10[i] != null)
					model.setSt32hOpr10(st32hOpr10[i]);
				if (st124hOpr1[i] != null)
					model.setSt124hOpr1(st124hOpr1[i]);
				if (st940Opr7[i] != null)
					model.setSt940Opr7(st940Opr7[i]);
				if (st142hOpr6[i] != null)
					model.setSt142hOpr6(st142hOpr6[i]);
				if (st142hOpr5[i] != null)
					model.setSt142hOpr5(st142hOpr5[i]);
				if (st142hOpr4[i] != null)
					model.setSt142hOpr4(st142hOpr4[i]);
				if (st142hOpr3[i] != null)
					model.setSt142hOpr3(st142hOpr3[i]);
				if (st142hOpr2[i] != null)
					model.setSt142hOpr2(st142hOpr2[i]);
				if (st142hOpr1[i] != null)
					model.setSt142hOpr1(st142hOpr1[i]);
				if (st94hOpr1[i] != null)
					model.setSt94hOpr1(st94hOpr1[i]);
				if (st94hOpr2[i] != null)
					model.setSt94hOpr2(st94hOpr2[i]);
				if (st94hOpr3[i] != null)
					model.setSt94hOpr3(st94hOpr3[i]);
				if (st94hOpr4[i] != null)
					model.setSt94hOpr4(st94hOpr4[i]);
				if (st1520Opr1[i] != null)
					model.setSt1520Opr1(st1520Opr1[i]);
				if (st94hOpr9[i] != null)
					model.setSt94hOpr9(st94hOpr9[i]);
				if (st112hOpr1[i] != null)
					model.setSt112hOpr1(st112hOpr1[i]);
				if (st1520Opr5[i] != null)
					model.setSt1520Opr5(st1520Opr5[i]);
				if (st94hOpr6[i] != null)
					model.setSt94hOpr6(st94hOpr6[i]);
				if (st1520Opr4[i] != null)
					model.setSt1520Opr4(st1520Opr4[i]);
				if (st94hOpr5[i] != null)
					model.setSt94hOpr5(st94hOpr5[i]);
				if (st1520Opr3[i] != null)
					model.setSt1520Opr3(st1520Opr3[i]);
				if (st94hOpr8[i] != null)
					model.setSt94hOpr8(st94hOpr8[i]);
				if (st1520Opr2[i] != null)
					model.setSt1520Opr2(st1520Opr2[i]);
				if (st94hOpr7[i] != null)
					model.setSt94hOpr7(st94hOpr7[i]);
				if (st112hOpr6[i] != null)
					model.setSt112hOpr6(st112hOpr6[i]);
				if (st1520Opr9[i] != null)
					model.setSt1520Opr9(st1520Opr9[i]);
				if (st112hOpr7[i] != null)
					model.setSt112hOpr7(st112hOpr7[i]);
				if (st1520Opr8[i] != null)
					model.setSt1520Opr8(st1520Opr8[i]);
				if (st1520Opr7[i] != null)
					model.setSt1520Opr7(st1520Opr7[i]);
				if (st112hOpr8[i] != null)
					model.setSt112hOpr8(st112hOpr8[i]);
				if (st1520Opr6[i] != null)
					model.setSt1520Opr6(st1520Opr6[i]);
				if (st112hOpr9[i] != null)
					model.setSt112hOpr9(st112hOpr9[i]);
				if (st112hOpr2[i] != null)
					model.setSt112hOpr2(st112hOpr2[i]);
				if (st112hOpr3[i] != null)
					model.setSt112hOpr3(st112hOpr3[i]);
				if (st340Opr10[i] != null)
					model.setSt340Opr10(st340Opr10[i]);
				if (st112hOpr4[i] != null)
					model.setSt112hOpr4(st112hOpr4[i]);
				if (st112hOpr5[i] != null)
					model.setSt112hOpr5(st112hOpr5[i]);
				if (st1120Opr7[i] != null)
					model.setSt1120Opr7(st1120Opr7[i]);
				if (st1120Opr6[i] != null)
					model.setSt1120Opr6(st1120Opr6[i]);
				if (st1120Opr9[i] != null)
					model.setSt1120Opr9(st1120Opr9[i]);
				if (st1120Opr8[i] != null)
					model.setSt1120Opr8(st1120Opr8[i]);
				if (st1120Opr3[i] != null)
					model.setSt1120Opr3(st1120Opr3[i]);
				if (st1120Opr2[i] != null)
					model.setSt1120Opr2(st1120Opr2[i]);
				if (st1120Opr5[i] != null)
					model.setSt1120Opr5(st1120Opr5[i]);
				if (st1120Opr4[i] != null)
					model.setSt1120Opr4(st1120Opr4[i]);
				if (st132hOpr4[i] != null)
					model.setSt132hOpr4(st132hOpr4[i]);
				if (st132hOpr5[i] != null)
					model.setSt132hOpr5(st132hOpr5[i]);
				if (st132hOpr6[i] != null)
					model.setSt132hOpr6(st132hOpr6[i]);
				if (st132hOpr7[i] != null)
					model.setSt132hOpr7(st132hOpr7[i]);
				if (st132hOpr1[i] != null)
					model.setSt132hOpr1(st132hOpr1[i]);
				if (st132hOpr2[i] != null)
					model.setSt132hOpr2(st132hOpr2[i]);
				if (st132hOpr3[i] != null)
					model.setSt132hOpr3(st132hOpr3[i]);
				if (st24hOpr10[i] != null)
					model.setSt24hOpr10(st24hOpr10[i]);
				if (st345Opr10[i] != null)
					model.setSt345Opr10(st345Opr10[i]);
				if (qty1[i] != null)
					model.setQty1(qty1[i]);
				if (qty3[i] != null)
					model.setQty3(qty3[i]);
				if (qty2[i] != null)
					model.setQty2(qty2[i]);
				if (qty5[i] != null)
					model.setQty5(qty5[i]);
				if (qty4[i] != null)
					model.setQty4(qty4[i]);
				if (st720Opr7[i] != null)
					model.setSt720Opr7(st720Opr7[i]);
				if (st720Opr8[i] != null)
					model.setSt720Opr8(st720Opr8[i]);
				if (st720Opr5[i] != null)
					model.setSt720Opr5(st720Opr5[i]);
				if (st720Opr6[i] != null)
					model.setSt720Opr6(st720Opr6[i]);
				if (st720Opr9[i] != null)
					model.setSt720Opr9(st720Opr9[i]);
				if (st34hOpr10[i] != null)
					model.setSt34hOpr10(st34hOpr10[i]);
				if (st62hOpr10[i] != null)
					model.setSt62hOpr10(st62hOpr10[i]);
				if (st1440Opr10[i] != null)
					model.setSt1440Opr10(st1440Opr10[i]);
				if (st720Opr3[i] != null)
					model.setSt720Opr3(st720Opr3[i]);
				if (st720Opr4[i] != null)
					model.setSt720Opr4(st720Opr4[i]);
				if (st720Opr1[i] != null)
					model.setSt720Opr1(st720Opr1[i]);
				if (st720Opr2[i] != null)
					model.setSt720Opr2(st720Opr2[i]);
				if (st1045Opr10[i] != null)
					model.setSt1045Opr10(st1045Opr10[i]);
				if (st1540Opr1[i] != null)
					model.setSt1540Opr1(st1540Opr1[i]);
				if (st1540Opr2[i] != null)
					model.setSt1540Opr2(st1540Opr2[i]);
				if (st1540Opr3[i] != null)
					model.setSt1540Opr3(st1540Opr3[i]);
				if (st1540Opr4[i] != null)
					model.setSt1540Opr4(st1540Opr4[i]);
				if (st1540Opr5[i] != null)
					model.setSt1540Opr5(st1540Opr5[i]);
				if (st1540Opr6[i] != null)
					model.setSt1540Opr6(st1540Opr6[i]);
				if (st1540Opr7[i] != null)
					model.setSt1540Opr7(st1540Opr7[i]);
				if (st1540Opr8[i] != null)
					model.setSt1540Opr8(st1540Opr8[i]);
				if (st1540Opr9[i] != null)
					model.setSt1540Opr9(st1540Opr9[i]);
				if (qty8[i] != null)
					model.setQty8(qty8[i]);
				if (st1545Opr1[i] != null)
					model.setSt1545Opr1(st1545Opr1[i]);
				if (st1545Opr2[i] != null)
					model.setSt1545Opr2(st1545Opr2[i]);
				if (qty9[i] != null)
					model.setQty9(qty9[i]);
				if (qty6[i] != null)
					model.setQty6(qty6[i]);
				if (st420Opr10[i] != null)
					model.setSt420Opr10(st420Opr10[i]);
				if (qty7[i] != null)
					model.setQty7(qty7[i]);
				if (st1545Opr5[i] != null)
					model.setSt1545Opr5(st1545Opr5[i]);
				if (st1545Opr6[i] != null)
					model.setSt1545Opr6(st1545Opr6[i]);
				if (st1545Opr3[i] != null)
					model.setSt1545Opr3(st1545Opr3[i]);
				if (st1545Opr4[i] != null)
					model.setSt1545Opr4(st1545Opr4[i]);
				if (st1545Opr9[i] != null)
					model.setSt1545Opr9(st1545Opr9[i]);
				if (st1545Opr7[i] != null)
					model.setSt1545Opr7(st1545Opr7[i]);
				if (st1545Opr8[i] != null)
					model.setSt1545Opr8(st1545Opr8[i]);
				if (st1320Opr1[i] != null)
					model.setSt1320Opr1(st1320Opr1[i]);
				if (st1320Opr3[i] != null)
					model.setSt1320Opr3(st1320Opr3[i]);
				if (st132hOpr9[i] != null)
					model.setSt132hOpr9(st132hOpr9[i]);
				if (st1320Opr2[i] != null)
					model.setSt1320Opr2(st1320Opr2[i]);
				if (st132hOpr8[i] != null)
					model.setSt132hOpr8(st132hOpr8[i]);
				if (st1320Opr5[i] != null)
					model.setSt1320Opr5(st1320Opr5[i]);
				if (st1320Opr4[i] != null)
					model.setSt1320Opr4(st1320Opr4[i]);
				if (st1320Opr7[i] != null)
					model.setSt1320Opr7(st1320Opr7[i]);
				if (st1320Opr6[i] != null)
					model.setSt1320Opr6(st1320Opr6[i]);
				if (st1320Opr9[i] != null)
					model.setSt1320Opr9(st1320Opr9[i]);
				if (st1320Opr8[i] != null)
					model.setSt1320Opr8(st1320Opr8[i]);
				if (st340Opr1[i] != null)
					model.setSt340Opr1(st340Opr1[i]);
				if (st340Opr2[i] != null)
					model.setSt340Opr2(st340Opr2[i]);
				if (st340Opr9[i] != null)
					model.setSt340Opr9(st340Opr9[i]);
				if (st340Opr8[i] != null)
					model.setSt340Opr8(st340Opr8[i]);
				if (st340Opr7[i] != null)
					model.setSt340Opr7(st340Opr7[i]);
				if (st340Opr6[i] != null)
					model.setSt340Opr6(st340Opr6[i]);
				if (st340Opr5[i] != null)
					model.setSt340Opr5(st340Opr5[i]);
				if (st340Opr4[i] != null)
					model.setSt340Opr4(st340Opr4[i]);
				if (st340Opr3[i] != null)
					model.setSt340Opr3(st340Opr3[i]);
				if (allFlg[i] != null)
					model.setAllFlg(allFlg[i]);
				if (st445Opr10[i] != null)
					model.setSt445Opr10(st445Opr10[i]);
				if (st120Opr1[i] != null)
					model.setSt120Opr1(st120Opr1[i]);
				if (st120Opr2[i] != null)
					model.setSt120Opr2(st120Opr2[i]);
				if (st120Opr10[i] != null)
					model.setSt120Opr10(st120Opr10[i]);
				if (st132hOpr10[i] != null)
					model.setSt132hOpr10(st132hOpr10[i]);
				if (st120Opr4[i] != null)
					model.setSt120Opr4(st120Opr4[i]);
				if (st120Opr3[i] != null)
					model.setSt120Opr3(st120Opr3[i]);
				if (st120Opr6[i] != null)
					model.setSt120Opr6(st120Opr6[i]);
				if (st120Opr5[i] != null)
					model.setSt120Opr5(st120Opr5[i]);
				if (st120Opr8[i] != null)
					model.setSt120Opr8(st120Opr8[i]);
				if (st120Opr7[i] != null)
					model.setSt120Opr7(st120Opr7[i]);
				if (st120Opr9[i] != null)
					model.setSt120Opr9(st120Opr9[i]);
				if (st1040Opr10[i] != null)
					model.setSt1040Opr10(st1040Opr10[i]);
				if (st92hOpr10[i] != null)
					model.setSt92hOpr10(st92hOpr10[i]);
				if (st1045Opr5[i] != null)
					model.setSt1045Opr5(st1045Opr5[i]);
				if (st1045Opr4[i] != null)
					model.setSt1045Opr4(st1045Opr4[i]);
				if (st1045Opr7[i] != null)
					model.setSt1045Opr7(st1045Opr7[i]);
				if (st1045Opr6[i] != null)
					model.setSt1045Opr6(st1045Opr6[i]);
				if (st1045Opr1[i] != null)
					model.setSt1045Opr1(st1045Opr1[i]);
				if (st540Opr10[i] != null)
					model.setSt540Opr10(st540Opr10[i]);
				if (st1045Opr3[i] != null)
					model.setSt1045Opr3(st1045Opr3[i]);
				if (bbCgoFlg[i] != null)
					model.setBbCgoFlg(bbCgoFlg[i]);
				if (st1045Opr2[i] != null)
					model.setSt1045Opr2(st1045Opr2[i]);
				if (st1045Opr9[i] != null)
					model.setSt1045Opr9(st1045Opr9[i]);
				if (st1045Opr8[i] != null)
					model.setSt1045Opr8(st1045Opr8[i]);
				if (mlbCd[i] != null)
					model.setMlbCd(mlbCd[i]);
				if (st1520Opr10[i] != null)
					model.setSt1520Opr10(st1520Opr10[i]);
				if (st345Opr7[i] != null)
					model.setSt345Opr7(st345Opr7[i]);
				if (st345Opr6[i] != null)
					model.setSt345Opr6(st345Opr6[i]);
				if (st345Opr9[i] != null)
					model.setSt345Opr9(st345Opr9[i]);
				if (st345Opr8[i] != null)
					model.setSt345Opr8(st345Opr8[i]);
				if (st1120Opr1[i] != null)
					model.setSt1120Opr1(st1120Opr1[i]);
				if (st345Opr1[i] != null)
					model.setSt345Opr1(st345Opr1[i]);
				if (st345Opr3[i] != null)
					model.setSt345Opr3(st345Opr3[i]);
				if (st345Opr2[i] != null)
					model.setSt345Opr2(st345Opr2[i]);
				if (st345Opr5[i] != null)
					model.setSt345Opr5(st345Opr5[i]);
				if (st345Opr4[i] != null)
					model.setSt345Opr4(st345Opr4[i]);
				if (st12hOpr2[i] != null)
					model.setSt12hOpr2(st12hOpr2[i]);
				if (st12hOpr1[i] != null)
					model.setSt12hOpr1(st12hOpr1[i]);
				if (st1340Opr1[i] != null)
					model.setSt1340Opr1(st1340Opr1[i]);
				if (st12hOpr8[i] != null)
					model.setSt12hOpr8(st12hOpr8[i]);
				if (st12hOpr7[i] != null)
					model.setSt12hOpr7(st12hOpr7[i]);
				if (st12hOpr9[i] != null)
					model.setSt12hOpr9(st12hOpr9[i]);
				if (st12hOpr4[i] != null)
					model.setSt12hOpr4(st12hOpr4[i]);
				if (st12hOpr3[i] != null)
					model.setSt12hOpr3(st12hOpr3[i]);
				if (st12hOpr6[i] != null)
					model.setSt12hOpr6(st12hOpr6[i]);
				if (st12hOpr5[i] != null)
					model.setSt12hOpr5(st12hOpr5[i]);
				if (st1420Opr6[i] != null)
					model.setSt1420Opr6(st1420Opr6[i]);
				if (st1420Opr5[i] != null)
					model.setSt1420Opr5(st1420Opr5[i]);
				if (st1420Opr4[i] != null)
					model.setSt1420Opr4(st1420Opr4[i]);
				if (st1420Opr3[i] != null)
					model.setSt1420Opr3(st1420Opr3[i]);
				if (st1420Opr2[i] != null)
					model.setSt1420Opr2(st1420Opr2[i]);
				if (st1420Opr1[i] != null)
					model.setSt1420Opr1(st1420Opr1[i]);
				if (st1420Opr9[i] != null)
					model.setSt1420Opr9(st1420Opr9[i]);
				if (st1420Opr8[i] != null)
					model.setSt1420Opr8(st1420Opr8[i]);
				if (st1420Opr7[i] != null)
					model.setSt1420Opr7(st1420Opr7[i]);
				if (st84hOpr1[i] != null)
					model.setSt84hOpr1(st84hOpr1[i]);
				if (st84hOpr3[i] != null)
					model.setSt84hOpr3(st84hOpr3[i]);
				if (st84hOpr2[i] != null)
					model.setSt84hOpr2(st84hOpr2[i]);
				if (st84hOpr5[i] != null)
					model.setSt84hOpr5(st84hOpr5[i]);
				if (st84hOpr4[i] != null)
					model.setSt84hOpr4(st84hOpr4[i]);
				if (st152hOpr10[i] != null)
					model.setSt152hOpr10(st152hOpr10[i]);
				if (st84hOpr6[i] != null)
					model.setSt84hOpr6(st84hOpr6[i]);
				if (st84hOpr7[i] != null)
					model.setSt84hOpr7(st84hOpr7[i]);
				if (st84hOpr8[i] != null)
					model.setSt84hOpr8(st84hOpr8[i]);
				if (st84hOpr9[i] != null)
					model.setSt84hOpr9(st84hOpr9[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (st14hOpr10[i] != null)
					model.setSt14hOpr10(st14hOpr10[i]);
				if (st640Opr8[i] != null)
					model.setSt640Opr8(st640Opr8[i]);
				if (st1245Opr9[i] != null)
					model.setSt1245Opr9(st1245Opr9[i]);
				if (st1245Opr8[i] != null)
					model.setSt1245Opr8(st1245Opr8[i]);
				if (st640Opr9[i] != null)
					model.setSt640Opr9(st640Opr9[i]);
				if (st1245Opr7[i] != null)
					model.setSt1245Opr7(st1245Opr7[i]);
				if (st1245Opr6[i] != null)
					model.setSt1245Opr6(st1245Opr6[i]);
				if (st640Opr4[i] != null)
					model.setSt640Opr4(st640Opr4[i]);
				if (st1245Opr5[i] != null)
					model.setSt1245Opr5(st1245Opr5[i]);
				if (st640Opr5[i] != null)
					model.setSt640Opr5(st640Opr5[i]);
				if (st1245Opr4[i] != null)
					model.setSt1245Opr4(st1245Opr4[i]);
				if (st1245Opr3[i] != null)
					model.setSt1245Opr3(st1245Opr3[i]);
				if (st640Opr6[i] != null)
					model.setSt640Opr6(st640Opr6[i]);
				if (st1245Opr2[i] != null)
					model.setSt1245Opr2(st1245Opr2[i]);
				if (st640Opr7[i] != null)
					model.setSt640Opr7(st640Opr7[i]);
				if (st1245Opr1[i] != null)
					model.setSt1245Opr1(st1245Opr1[i]);
				if (st640Opr1[i] != null)
					model.setSt640Opr1(st640Opr1[i]);
				if (st640Opr2[i] != null)
					model.setSt640Opr2(st640Opr2[i]);
				if (st640Opr3[i] != null)
					model.setSt640Opr3(st640Opr3[i]);
				if (st52hOpr10[i] != null)
					model.setSt52hOpr10(st52hOpr10[i]);
				if (st1340Opr2[i] != null)
					model.setSt1340Opr2(st1340Opr2[i]);
				if (st1340Opr3[i] != null)
					model.setSt1340Opr3(st1340Opr3[i]);
				if (st1340Opr4[i] != null)
					model.setSt1340Opr4(st1340Opr4[i]);
				if (st1340Opr5[i] != null)
					model.setSt1340Opr5(st1340Opr5[i]);
				if (st1340Opr6[i] != null)
					model.setSt1340Opr6(st1340Opr6[i]);
				if (st1340Opr7[i] != null)
					model.setSt1340Opr7(st1340Opr7[i]);
				if (st1340Opr8[i] != null)
					model.setSt1340Opr8(st1340Opr8[i]);
				if (st1340Opr9[i] != null)
					model.setSt1340Opr9(st1340Opr9[i]);
				if (st945Opr1[i] != null)
					model.setSt945Opr1(st945Opr1[i]);
				if (st945Opr3[i] != null)
					model.setSt945Opr3(st945Opr3[i]);
				if (st945Opr2[i] != null)
					model.setSt945Opr2(st945Opr2[i]);
				if (st945Opr5[i] != null)
					model.setSt945Opr5(st945Opr5[i]);
				if (st945Opr4[i] != null)
					model.setSt945Opr4(st945Opr4[i]);
				if (st945Opr7[i] != null)
					model.setSt945Opr7(st945Opr7[i]);
				if (st945Opr6[i] != null)
					model.setSt945Opr6(st945Opr6[i]);
				if (st64hOpr10[i] != null)
					model.setSt64hOpr10(st64hOpr10[i]);
				if (st520Opr1[i] != null)
					model.setSt520Opr1(st520Opr1[i]);
				if (st540Opr2[i] != null)
					model.setSt540Opr2(st540Opr2[i]);
				if (st540Opr1[i] != null)
					model.setSt540Opr1(st540Opr1[i]);
				if (st520Opr2[i] != null)
					model.setSt520Opr2(st520Opr2[i]);
				if (st540Opr4[i] != null)
					model.setSt540Opr4(st540Opr4[i]);
				if (st540Opr3[i] != null)
					model.setSt540Opr3(st540Opr3[i]);
				if (qty10[i] != null)
					model.setQty10(qty10[i]);
				if (st520Opr5[i] != null)
					model.setSt520Opr5(st520Opr5[i]);
				if (st540Opr6[i] != null)
					model.setSt540Opr6(st540Opr6[i]);
				if (st540Opr5[i] != null)
					model.setSt540Opr5(st540Opr5[i]);
				if (st520Opr6[i] != null)
					model.setSt520Opr6(st520Opr6[i]);
				if (st520Opr3[i] != null)
					model.setSt520Opr3(st520Opr3[i]);
				if (st540Opr8[i] != null)
					model.setSt540Opr8(st540Opr8[i]);
				if (st520Opr4[i] != null)
					model.setSt520Opr4(st520Opr4[i]);
				if (st540Opr7[i] != null)
					model.setSt540Opr7(st540Opr7[i]);
				if (st520Opr9[i] != null)
					model.setSt520Opr9(st520Opr9[i]);
				if (st540Opr9[i] != null)
					model.setSt540Opr9(st540Opr9[i]);
				if (st520Opr7[i] != null)
					model.setSt520Opr7(st520Opr7[i]);
				if (st520Opr8[i] != null)
					model.setSt520Opr8(st520Opr8[i]);
				if (st945Opr10[i] != null)
					model.setSt945Opr10(st945Opr10[i]);
				if (st94hOpr10[i] != null)
					model.setSt94hOpr10(st94hOpr10[i]);
				if (stwgCgoFlg[i] != null)
					model.setStwgCgoFlg(stwgCgoFlg[i]);
				if (st1540Opr10[i] != null)
					model.setSt1540Opr10(st1540Opr10[i]);
				if (st945Opr8[i] != null)
					model.setSt945Opr8(st945Opr8[i]);
				if (st945Opr9[i] != null)
					model.setSt945Opr9(st945Opr9[i]);
				if (st32hOpr9[i] != null)
					model.setSt32hOpr9(st32hOpr9[i]);
				if (st24hOpr1[i] != null)
					model.setSt24hOpr1(st24hOpr1[i]);
				if (st920Opr9[i] != null)
					model.setSt920Opr9(st920Opr9[i]);
				if (st24hOpr3[i] != null)
					model.setSt24hOpr3(st24hOpr3[i]);
				if (st920Opr8[i] != null)
					model.setSt920Opr8(st920Opr8[i]);
				if (st24hOpr2[i] != null)
					model.setSt24hOpr2(st24hOpr2[i]);
				if (st920Opr7[i] != null)
					model.setSt920Opr7(st920Opr7[i]);
				if (st920Opr6[i] != null)
					model.setSt920Opr6(st920Opr6[i]);
				if (st920Opr5[i] != null)
					model.setSt920Opr5(st920Opr5[i]);
				if (st920Opr4[i] != null)
					model.setSt920Opr4(st920Opr4[i]);
				if (st920Opr3[i] != null)
					model.setSt920Opr3(st920Opr3[i]);
				if (st32hOpr4[i] != null)
					model.setSt32hOpr4(st32hOpr4[i]);
				if (st920Opr2[i] != null)
					model.setSt920Opr2(st920Opr2[i]);
				if (st24hOpr9[i] != null)
					model.setSt24hOpr9(st24hOpr9[i]);
				if (st32hOpr3[i] != null)
					model.setSt32hOpr3(st32hOpr3[i]);
				if (st920Opr1[i] != null)
					model.setSt920Opr1(st920Opr1[i]);
				if (stwgCd[i] != null)
					model.setStwgCd(stwgCd[i]);
				if (st24hOpr8[i] != null)
					model.setSt24hOpr8(st24hOpr8[i]);
				if (st240Opr10[i] != null)
					model.setSt240Opr10(st240Opr10[i]);
				if (st32hOpr2[i] != null)
					model.setSt32hOpr2(st32hOpr2[i]);
				if (st32hOpr1[i] != null)
					model.setSt32hOpr1(st32hOpr1[i]);
				if (st24hOpr5[i] != null)
					model.setSt24hOpr5(st24hOpr5[i]);
				if (st32hOpr8[i] != null)
					model.setSt32hOpr8(st32hOpr8[i]);
				if (st24hOpr4[i] != null)
					model.setSt24hOpr4(st24hOpr4[i]);
				if (st32hOpr7[i] != null)
					model.setSt32hOpr7(st32hOpr7[i]);
				if (st32hOpr6[i] != null)
					model.setSt32hOpr6(st32hOpr6[i]);
				if (st24hOpr7[i] != null)
					model.setSt24hOpr7(st24hOpr7[i]);
				if (st32hOpr5[i] != null)
					model.setSt32hOpr5(st32hOpr5[i]);
				if (st24hOpr6[i] != null)
					model.setSt24hOpr6(st24hOpr6[i]);
				if (st240Opr4[i] != null)
					model.setSt240Opr4(st240Opr4[i]);
				if (st820Opr1[i] != null)
					model.setSt820Opr1(st820Opr1[i]);
				if (st112hOpr10[i] != null)
					model.setSt112hOpr10(st112hOpr10[i]);
				if (st240Opr5[i] != null)
					model.setSt240Opr5(st240Opr5[i]);
				if (st820Opr3[i] != null)
					model.setSt820Opr3(st820Opr3[i]);
				if (st240Opr6[i] != null)
					model.setSt240Opr6(st240Opr6[i]);
				if (st820Opr2[i] != null)
					model.setSt820Opr2(st820Opr2[i]);
				if (st240Opr7[i] != null)
					model.setSt240Opr7(st240Opr7[i]);
				if (st240Opr8[i] != null)
					model.setSt240Opr8(st240Opr8[i]);
				if (st240Opr9[i] != null)
					model.setSt240Opr9(st240Opr9[i]);
				if (st64hOpr7[i] != null)
					model.setSt64hOpr7(st64hOpr7[i]);
				if (st820Opr9[i] != null)
					model.setSt820Opr9(st820Opr9[i]);
				if (st64hOpr6[i] != null)
					model.setSt64hOpr6(st64hOpr6[i]);
				if (st820Opr8[i] != null)
					model.setSt820Opr8(st820Opr8[i]);
				if (st64hOpr5[i] != null)
					model.setSt64hOpr5(st64hOpr5[i]);
				if (st64hOpr4[i] != null)
					model.setSt64hOpr4(st64hOpr4[i]);
				if (st64hOpr3[i] != null)
					model.setSt64hOpr3(st64hOpr3[i]);
				if (st820Opr5[i] != null)
					model.setSt820Opr5(st820Opr5[i]);
				if (st820Opr4[i] != null)
					model.setSt820Opr4(st820Opr4[i]);
				if (st64hOpr2[i] != null)
					model.setSt64hOpr2(st64hOpr2[i]);
				if (st64hOpr1[i] != null)
					model.setSt64hOpr1(st64hOpr1[i]);
				if (st820Opr7[i] != null)
					model.setSt820Opr7(st820Opr7[i]);
				if (st820Opr6[i] != null)
					model.setSt820Opr6(st820Opr6[i]);
				if (st445Opr1[i] != null)
					model.setSt445Opr1(st445Opr1[i]);
				if (st445Opr2[i] != null)
					model.setSt445Opr2(st445Opr2[i]);
				if (st445Opr3[i] != null)
					model.setSt445Opr3(st445Opr3[i]);
				if (st64hOpr8[i] != null)
					model.setSt64hOpr8(st64hOpr8[i]);
				if (st445Opr4[i] != null)
					model.setSt445Opr4(st445Opr4[i]);
				if (st64hOpr9[i] != null)
					model.setSt64hOpr9(st64hOpr9[i]);
				if (st445Opr5[i] != null)
					model.setSt445Opr5(st445Opr5[i]);
				if (st445Opr6[i] != null)
					model.setSt445Opr6(st445Opr6[i]);
				if (st445Opr7[i] != null)
					model.setSt445Opr7(st445Opr7[i]);
				if (st445Opr8[i] != null)
					model.setSt445Opr8(st445Opr8[i]);
				if (st240Opr1[i] != null)
					model.setSt240Opr1(st240Opr1[i]);
				if (st445Opr9[i] != null)
					model.setSt445Opr9(st445Opr9[i]);
				if (st240Opr3[i] != null)
					model.setSt240Opr3(st240Opr3[i]);
				if (st240Opr2[i] != null)
					model.setSt240Opr2(st240Opr2[i]);
				if (st9[i] != null)
					model.setSt9(st9[i]);
				if (st7[i] != null)
					model.setSt7(st7[i]);
				if (st8[i] != null)
					model.setSt8(st8[i]);
				if (st5[i] != null)
					model.setSt5(st5[i]);
				if (st6[i] != null)
					model.setSt6(st6[i]);
				if (st3[i] != null)
					model.setSt3(st3[i]);
				if (st4[i] != null)
					model.setSt4(st4[i]);
				if (st1[i] != null)
					model.setSt1(st1[i]);
				if (st2[i] != null)
					model.setSt2(st2[i]);
				if (st940Opr10[i] != null)
					model.setSt940Opr10(st940Opr10[i]);
				if (st1220Opr10[i] != null)
					model.setSt1220Opr10(st1220Opr10[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (st320Opr9[i] != null)
					model.setSt320Opr9(st320Opr9[i]);
				if (st320Opr8[i] != null)
					model.setSt320Opr8(st320Opr8[i]);
				if (st320Opr7[i] != null)
					model.setSt320Opr7(st320Opr7[i]);
				if (st320Opr6[i] != null)
					model.setSt320Opr6(st320Opr6[i]);
				if (st320Opr5[i] != null)
					model.setSt320Opr5(st320Opr5[i]);
				if (st42hOpr10[i] != null)
					model.setSt42hOpr10(st42hOpr10[i]);
				if (st320Opr4[i] != null)
					model.setSt320Opr4(st320Opr4[i]);
				if (st320Opr3[i] != null)
					model.setSt320Opr3(st320Opr3[i]);
				if (st320Opr2[i] != null)
					model.setSt320Opr2(st320Opr2[i]);
				if (st320Opr1[i] != null)
					model.setSt320Opr1(st320Opr1[i]);
				if (st144hOpr9[i] != null)
					model.setSt144hOpr9(st144hOpr9[i]);
				if (st645Opr10[i] != null)
					model.setSt645Opr10(st645Opr10[i]);
				if (st22hOpr1[i] != null)
					model.setSt22hOpr1(st22hOpr1[i]);
				if (st22hOpr8[i] != null)
					model.setSt22hOpr8(st22hOpr8[i]);
				if (st22hOpr9[i] != null)
					model.setSt22hOpr9(st22hOpr9[i]);
				if (st22hOpr6[i] != null)
					model.setSt22hOpr6(st22hOpr6[i]);
				if (st22hOpr7[i] != null)
					model.setSt22hOpr7(st22hOpr7[i]);
				if (st122hOpr10[i] != null)
					model.setSt122hOpr10(st122hOpr10[i]);
				if (st104hOpr10[i] != null)
					model.setSt104hOpr10(st104hOpr10[i]);
				if (st22hOpr4[i] != null)
					model.setSt22hOpr4(st22hOpr4[i]);
				if (st22hOpr5[i] != null)
					model.setSt22hOpr5(st22hOpr5[i]);
				if (st22hOpr2[i] != null)
					model.setSt22hOpr2(st22hOpr2[i]);
				if (st22hOpr3[i] != null)
					model.setSt22hOpr3(st22hOpr3[i]);
				if (st440Opr10[i] != null)
					model.setSt440Opr10(st440Opr10[i]);
				if (st44hOpr6[i] != null)
					model.setSt44hOpr6(st44hOpr6[i]);
				if (st44hOpr7[i] != null)
					model.setSt44hOpr7(st44hOpr7[i]);
				if (st44hOpr8[i] != null)
					model.setSt44hOpr8(st44hOpr8[i]);
				if (st44hOpr9[i] != null)
					model.setSt44hOpr9(st44hOpr9[i]);
				if (st44hOpr2[i] != null)
					model.setSt44hOpr2(st44hOpr2[i]);
				if (st44hOpr3[i] != null)
					model.setSt44hOpr3(st44hOpr3[i]);
				if (st44hOpr4[i] != null)
					model.setSt44hOpr4(st44hOpr4[i]);
				if (st44hOpr5[i] != null)
					model.setSt44hOpr5(st44hOpr5[i]);
				if (st44hOpr1[i] != null)
					model.setSt44hOpr1(st44hOpr1[i]);
				if (bkgShprOwnrFlg[i] != null)
					model.setBkgShprOwnrFlg(bkgShprOwnrFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (st144hOpr1[i] != null)
					model.setSt144hOpr1(st144hOpr1[i]);
				if (st144hOpr2[i] != null)
					model.setSt144hOpr2(st144hOpr2[i]);
				if (st144hOpr3[i] != null)
					model.setSt144hOpr3(st144hOpr3[i]);
				if (st74hOpr10[i] != null)
					model.setSt74hOpr10(st74hOpr10[i]);
				if (st144hOpr4[i] != null)
					model.setSt144hOpr4(st144hOpr4[i]);
				if (st144hOpr5[i] != null)
					model.setSt144hOpr5(st144hOpr5[i]);
				if (st144hOpr6[i] != null)
					model.setSt144hOpr6(st144hOpr6[i]);
				if (st144hOpr7[i] != null)
					model.setSt144hOpr7(st144hOpr7[i]);
				if (st144hOpr8[i] != null)
					model.setSt144hOpr8(st144hOpr8[i]);
				if (st72hOpr10[i] != null)
					model.setSt72hOpr10(st72hOpr10[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (st420Opr9[i] != null)
					model.setSt420Opr9(st420Opr9[i]);
				if (st420Opr8[i] != null)
					model.setSt420Opr8(st420Opr8[i]);
				if (st420Opr5[i] != null)
					model.setSt420Opr5(st420Opr5[i]);
				if (st420Opr4[i] != null)
					model.setSt420Opr4(st420Opr4[i]);
				if (st420Opr7[i] != null)
					model.setSt420Opr7(st420Opr7[i]);
				if (st420Opr6[i] != null)
					model.setSt420Opr6(st420Opr6[i]);
				if (st420Opr1[i] != null)
					model.setSt420Opr1(st420Opr1[i]);
				if (st420Opr3[i] != null)
					model.setSt420Opr3(st420Opr3[i]);
				if (st420Opr2[i] != null)
					model.setSt420Opr2(st420Opr2[i]);
				if (st840Opr9[i] != null)
					model.setSt840Opr9(st840Opr9[i]);
				if (st840Opr8[i] != null)
					model.setSt840Opr8(st840Opr8[i]);
				if (st840Opr7[i] != null)
					model.setSt840Opr7(st840Opr7[i]);
				if (st840Opr6[i] != null)
					model.setSt840Opr6(st840Opr6[i]);
				if (st22hOpr10[i] != null)
					model.setSt22hOpr10(st22hOpr10[i]);
				if (st840Opr1[i] != null)
					model.setSt840Opr1(st840Opr1[i]);
				if (st440Opr9[i] != null)
					model.setSt440Opr9(st440Opr9[i]);
				if (st440Opr8[i] != null)
					model.setSt440Opr8(st440Opr8[i]);
				if (st440Opr7[i] != null)
					model.setSt440Opr7(st440Opr7[i]);
				if (st440Opr6[i] != null)
					model.setSt440Opr6(st440Opr6[i]);
				if (st440Opr5[i] != null)
					model.setSt440Opr5(st440Opr5[i]);
				if (st840Opr5[i] != null)
					model.setSt840Opr5(st840Opr5[i]);
				if (st840Opr4[i] != null)
					model.setSt840Opr4(st840Opr4[i]);
				if (st440Opr4[i] != null)
					model.setSt440Opr4(st440Opr4[i]);
				if (st840Opr3[i] != null)
					model.setSt840Opr3(st840Opr3[i]);
				if (st440Opr3[i] != null)
					model.setSt440Opr3(st440Opr3[i]);
				if (st440Opr2[i] != null)
					model.setSt440Opr2(st440Opr2[i]);
				if (st840Opr2[i] != null)
					model.setSt840Opr2(st840Opr2[i]);
				if (st440Opr1[i] != null)
					model.setSt440Opr1(st440Opr1[i]);
				if (st820Opr10[i] != null)
					model.setSt820Opr10(st820Opr10[i]);
				if (st1120Opr10[i] != null)
					model.setSt1120Opr10(st1120Opr10[i]);
				if (st620Opr9[i] != null)
					model.setSt620Opr9(st620Opr9[i]);
				if (st620Opr8[i] != null)
					model.setSt620Opr8(st620Opr8[i]);
				if (st620Opr7[i] != null)
					model.setSt620Opr7(st620Opr7[i]);
				if (st620Opr6[i] != null)
					model.setSt620Opr6(st620Opr6[i]);
				if (st620Opr1[i] != null)
					model.setSt620Opr1(st620Opr1[i]);
				if (st620Opr5[i] != null)
					model.setSt620Opr5(st620Opr5[i]);
				if (st620Opr4[i] != null)
					model.setSt620Opr4(st620Opr4[i]);
				if (st620Opr3[i] != null)
					model.setSt620Opr3(st620Opr3[i]);
				if (st620Opr2[i] != null)
					model.setSt620Opr2(st620Opr2[i]);
				if (st1240Opr9[i] != null)
					model.setSt1240Opr9(st1240Opr9[i]);
				if (st62hOpr1[i] != null)
					model.setSt62hOpr1(st62hOpr1[i]);
				if (st1240Opr8[i] != null)
					model.setSt1240Opr8(st1240Opr8[i]);
				if (st1240Opr7[i] != null)
					model.setSt1240Opr7(st1240Opr7[i]);
				if (st62hOpr3[i] != null)
					model.setSt62hOpr3(st62hOpr3[i]);
				if (st1240Opr6[i] != null)
					model.setSt1240Opr6(st1240Opr6[i]);
				if (st62hOpr2[i] != null)
					model.setSt62hOpr2(st62hOpr2[i]);
				if (st1240Opr5[i] != null)
					model.setSt1240Opr5(st1240Opr5[i]);
				if (st62hOpr5[i] != null)
					model.setSt62hOpr5(st62hOpr5[i]);
				if (st1240Opr4[i] != null)
					model.setSt1240Opr4(st1240Opr4[i]);
				if (st62hOpr4[i] != null)
					model.setSt62hOpr4(st62hOpr4[i]);
				if (st1240Opr3[i] != null)
					model.setSt1240Opr3(st1240Opr3[i]);
				if (st62hOpr6[i] != null)
					model.setSt62hOpr6(st62hOpr6[i]);
				if (st62hOpr7[i] != null)
					model.setSt62hOpr7(st62hOpr7[i]);
				if (st62hOpr8[i] != null)
					model.setSt62hOpr8(st62hOpr8[i]);
				if (st62hOpr9[i] != null)
					model.setSt62hOpr9(st62hOpr9[i]);
				if (st134hOpr10[i] != null)
					model.setSt134hOpr10(st134hOpr10[i]);
				if (st620Opr10[i] != null)
					model.setSt620Opr10(st620Opr10[i]);
				if (st84hOpr10[i] != null)
					model.setSt84hOpr10(st84hOpr10[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (st145Opr9[i] != null)
					model.setSt145Opr9(st145Opr9[i]);
				if (st1245Opr10[i] != null)
					model.setSt1245Opr10(st1245Opr10[i]);
				if (st145Opr8[i] != null)
					model.setSt145Opr8(st145Opr8[i]);
				if (st154hOpr9[i] != null)
					model.setSt154hOpr9(st154hOpr9[i]);
				if (st154hOpr8[i] != null)
					model.setSt154hOpr8(st154hOpr8[i]);
				if (st1345Opr10[i] != null)
					model.setSt1345Opr10(st1345Opr10[i]);
				if (st145Opr3[i] != null)
					model.setSt145Opr3(st145Opr3[i]);
				if (st145Opr2[i] != null)
					model.setSt145Opr2(st145Opr2[i]);
				if (st145Opr1[i] != null)
					model.setSt145Opr1(st145Opr1[i]);
				if (st145Opr7[i] != null)
					model.setSt145Opr7(st145Opr7[i]);
				if (st145Opr6[i] != null)
					model.setSt145Opr6(st145Opr6[i]);
				if (st145Opr5[i] != null)
					model.setSt145Opr5(st145Opr5[i]);
				if (st44hOpr10[i] != null)
					model.setSt44hOpr10(st44hOpr10[i]);
				if (st145Opr4[i] != null)
					model.setSt145Opr4(st145Opr4[i]);
				if (st54hOpr4[i] != null)
					model.setSt54hOpr4(st54hOpr4[i]);
				if (opr7[i] != null)
					model.setOpr7(opr7[i]);
				if (st54hOpr3[i] != null)
					model.setSt54hOpr3(st54hOpr3[i]);
				if (opr8[i] != null)
					model.setOpr8(opr8[i]);
				if (opr5[i] != null)
					model.setOpr5(opr5[i]);
				if (st54hOpr2[i] != null)
					model.setSt54hOpr2(st54hOpr2[i]);
				if (st54hOpr1[i] != null)
					model.setSt54hOpr1(st54hOpr1[i]);
				if (opr6[i] != null)
					model.setOpr6(opr6[i]);
				if (opr3[i] != null)
					model.setOpr3(opr3[i]);
				if (st54hOpr8[i] != null)
					model.setSt54hOpr8(st54hOpr8[i]);
				if (opr4[i] != null)
					model.setOpr4(opr4[i]);
				if (st54hOpr7[i] != null)
					model.setSt54hOpr7(st54hOpr7[i]);
				if (opr1[i] != null)
					model.setOpr1(opr1[i]);
				if (st54hOpr6[i] != null)
					model.setSt54hOpr6(st54hOpr6[i]);
				if (st54hOpr5[i] != null)
					model.setSt54hOpr5(st54hOpr5[i]);
				if (opr2[i] != null)
					model.setOpr2(opr2[i]);
				if (opr9[i] != null)
					model.setOpr9(opr9[i]);
				if (st54hOpr9[i] != null)
					model.setSt54hOpr9(st54hOpr9[i]);
				if (st220Opr6[i] != null)
					model.setSt220Opr6(st220Opr6[i]);
				if (st220Opr7[i] != null)
					model.setSt220Opr7(st220Opr7[i]);
				if (st220Opr8[i] != null)
					model.setSt220Opr8(st220Opr8[i]);
				if (st220Opr9[i] != null)
					model.setSt220Opr9(st220Opr9[i]);
				if (st220Opr2[i] != null)
					model.setSt220Opr2(st220Opr2[i]);
				if (st220Opr3[i] != null)
					model.setSt220Opr3(st220Opr3[i]);
				if (st220Opr4[i] != null)
					model.setSt220Opr4(st220Opr4[i]);
				if (st220Opr5[i] != null)
					model.setSt220Opr5(st220Opr5[i]);
				if (st1020Opr2[i] != null)
					model.setSt1020Opr2(st1020Opr2[i]);
				if (st1020Opr1[i] != null)
					model.setSt1020Opr1(st1020Opr1[i]);
				if (st220Opr1[i] != null)
					model.setSt220Opr1(st220Opr1[i]);
				if (st15[i] != null)
					model.setSt15(st15[i]);
				if (st14[i] != null)
					model.setSt14(st14[i]);
				if (st13[i] != null)
					model.setSt13(st13[i]);
				if (st12[i] != null)
					model.setSt12(st12[i]);
				if (st11[i] != null)
					model.setSt11(st11[i]);
				if (st10[i] != null)
					model.setSt10(st10[i]);
				if (st134hOpr1[i] != null)
					model.setSt134hOpr1(st134hOpr1[i]);
				if (st134hOpr2[i] != null)
					model.setSt134hOpr2(st134hOpr2[i]);
				if (st72hOpr5[i] != null)
					model.setSt72hOpr5(st72hOpr5[i]);
				if (st134hOpr3[i] != null)
					model.setSt134hOpr3(st134hOpr3[i]);
				if (st72hOpr6[i] != null)
					model.setSt72hOpr6(st72hOpr6[i]);
				if (st134hOpr4[i] != null)
					model.setSt134hOpr4(st134hOpr4[i]);
				if (st72hOpr7[i] != null)
					model.setSt72hOpr7(st72hOpr7[i]);
				if (st134hOpr5[i] != null)
					model.setSt134hOpr5(st134hOpr5[i]);
				if (st72hOpr8[i] != null)
					model.setSt72hOpr8(st72hOpr8[i]);
				if (st134hOpr6[i] != null)
					model.setSt134hOpr6(st134hOpr6[i]);
				if (st72hOpr9[i] != null)
					model.setSt72hOpr9(st72hOpr9[i]);
				if (st134hOpr7[i] != null)
					model.setSt134hOpr7(st134hOpr7[i]);
				if (st134hOpr8[i] != null)
					model.setSt134hOpr8(st134hOpr8[i]);
				if (st134hOpr9[i] != null)
					model.setSt134hOpr9(st134hOpr9[i]);
				if (st154hOpr1[i] != null)
					model.setSt154hOpr1(st154hOpr1[i]);
				if (st154hOpr3[i] != null)
					model.setSt154hOpr3(st154hOpr3[i]);
				if (st154hOpr2[i] != null)
					model.setSt154hOpr2(st154hOpr2[i]);
				if (st1440Opr9[i] != null)
					model.setSt1440Opr9(st1440Opr9[i]);
				if (st1040Opr4[i] != null)
					model.setSt1040Opr4(st1040Opr4[i]);
				if (st72hOpr2[i] != null)
					model.setSt72hOpr2(st72hOpr2[i]);
				if (st154hOpr5[i] != null)
					model.setSt154hOpr5(st154hOpr5[i]);
				if (st154hOpr4[i] != null)
					model.setSt154hOpr4(st154hOpr4[i]);
				if (st1040Opr3[i] != null)
					model.setSt1040Opr3(st1040Opr3[i]);
				if (st72hOpr1[i] != null)
					model.setSt72hOpr1(st72hOpr1[i]);
				if (st72hOpr4[i] != null)
					model.setSt72hOpr4(st72hOpr4[i]);
				if (st1040Opr2[i] != null)
					model.setSt1040Opr2(st1040Opr2[i]);
				if (st154hOpr7[i] != null)
					model.setSt154hOpr7(st154hOpr7[i]);
				if (st72hOpr3[i] != null)
					model.setSt72hOpr3(st72hOpr3[i]);
				if (st1040Opr1[i] != null)
					model.setSt1040Opr1(st1040Opr1[i]);
				if (st154hOpr6[i] != null)
					model.setSt154hOpr6(st154hOpr6[i]);
				if (st1440Opr4[i] != null)
					model.setSt1440Opr4(st1440Opr4[i]);
				if (st1440Opr3[i] != null)
					model.setSt1440Opr3(st1440Opr3[i]);
				if (st1440Opr2[i] != null)
					model.setSt1440Opr2(st1440Opr2[i]);
				if (st1440Opr1[i] != null)
					model.setSt1440Opr1(st1440Opr1[i]);
				if (st1440Opr8[i] != null)
					model.setSt1440Opr8(st1440Opr8[i]);
				if (st1440Opr7[i] != null)
					model.setSt1440Opr7(st1440Opr7[i]);
				if (st1440Opr6[i] != null)
					model.setSt1440Opr6(st1440Opr6[i]);
				if (st1440Opr5[i] != null)
					model.setSt1440Opr5(st1440Opr5[i]);
				if (st102hOpr1[i] != null)
					model.setSt102hOpr1(st102hOpr1[i]);
				if (st102hOpr2[i] != null)
					model.setSt102hOpr2(st102hOpr2[i]);
				if (st102hOpr7[i] != null)
					model.setSt102hOpr7(st102hOpr7[i]);
				if (st102hOpr8[i] != null)
					model.setSt102hOpr8(st102hOpr8[i]);
				if (st102hOpr9[i] != null)
					model.setSt102hOpr9(st102hOpr9[i]);
				if (st102hOpr3[i] != null)
					model.setSt102hOpr3(st102hOpr3[i]);
				if (st102hOpr4[i] != null)
					model.setSt102hOpr4(st102hOpr4[i]);
				if (st102hOpr5[i] != null)
					model.setSt102hOpr5(st102hOpr5[i]);
				if (st102hOpr6[i] != null)
					model.setSt102hOpr6(st102hOpr6[i]);
				if (st320Opr10[i] != null)
					model.setSt320Opr10(st320Opr10[i]);
				if (st1020Opr3[i] != null)
					model.setSt1020Opr3(st1020Opr3[i]);
				if (st1020Opr4[i] != null)
					model.setSt1020Opr4(st1020Opr4[i]);
				if (st1020Opr5[i] != null)
					model.setSt1020Opr5(st1020Opr5[i]);
				if (st1020Opr6[i] != null)
					model.setSt1020Opr6(st1020Opr6[i]);
				if (st1240Opr2[i] != null)
					model.setSt1240Opr2(st1240Opr2[i]);
				if (st1020Opr7[i] != null)
					model.setSt1020Opr7(st1020Opr7[i]);
				if (st1240Opr1[i] != null)
					model.setSt1240Opr1(st1240Opr1[i]);
				if (st1020Opr8[i] != null)
					model.setSt1020Opr8(st1020Opr8[i]);
				if (st1020Opr9[i] != null)
					model.setSt1020Opr9(st1020Opr9[i]);
				if (st1240Opr10[i] != null)
					model.setSt1240Opr10(st1240Opr10[i]);
				if (st14hOpr9[i] != null)
					model.setSt14hOpr9(st14hOpr9[i]);
				if (st1140Opr10[i] != null)
					model.setSt1140Opr10(st1140Opr10[i]);
				if (st14hOpr5[i] != null)
					model.setSt14hOpr5(st14hOpr5[i]);
				if (st14hOpr6[i] != null)
					model.setSt14hOpr6(st14hOpr6[i]);
				if (st14hOpr7[i] != null)
					model.setSt14hOpr7(st14hOpr7[i]);
				if (st14hOpr8[i] != null)
					model.setSt14hOpr8(st14hOpr8[i]);
				if (st14hOpr1[i] != null)
					model.setSt14hOpr1(st14hOpr1[i]);
				if (st14hOpr2[i] != null)
					model.setSt14hOpr2(st14hOpr2[i]);
				if (st14hOpr3[i] != null)
					model.setSt14hOpr3(st14hOpr3[i]);
				if (st14hOpr4[i] != null)
					model.setSt14hOpr4(st14hOpr4[i]);
				if (st840Opr10[i] != null)
					model.setSt840Opr10(st840Opr10[i]);
				if (mlb[i] != null)
					model.setMlb(mlb[i]);
				if (st102hOpr10[i] != null)
					model.setSt102hOpr10(st102hOpr10[i]);
				if (awkCgoFlg[i] != null)
					model.setAwkCgoFlg(awkCgoFlg[i]);
				if (st42hOpr1[i] != null)
					model.setSt42hOpr1(st42hOpr1[i]);
				if (st1040Opr9[i] != null)
					model.setSt1040Opr9(st1040Opr9[i]);
				if (st42hOpr3[i] != null)
					model.setSt42hOpr3(st42hOpr3[i]);
				if (st42hOpr2[i] != null)
					model.setSt42hOpr2(st42hOpr2[i]);
				if (st42hOpr5[i] != null)
					model.setSt42hOpr5(st42hOpr5[i]);
				if (st1040Opr6[i] != null)
					model.setSt1040Opr6(st1040Opr6[i]);
				if (st220Opr10[i] != null)
					model.setSt220Opr10(st220Opr10[i]);
				if (st42hOpr4[i] != null)
					model.setSt42hOpr4(st42hOpr4[i]);
				if (st1040Opr5[i] != null)
					model.setSt1040Opr5(st1040Opr5[i]);
				if (st42hOpr7[i] != null)
					model.setSt42hOpr7(st42hOpr7[i]);
				if (st1040Opr8[i] != null)
					model.setSt1040Opr8(st1040Opr8[i]);
				if (st42hOpr6[i] != null)
					model.setSt42hOpr6(st42hOpr6[i]);
				if (st1040Opr7[i] != null)
					model.setSt1040Opr7(st1040Opr7[i]);
				if (st745Opr3[i] != null)
					model.setSt745Opr3(st745Opr3[i]);
				if (st745Opr2[i] != null)
					model.setSt745Opr2(st745Opr2[i]);
				if (st745Opr5[i] != null)
					model.setSt745Opr5(st745Opr5[i]);
				if (st745Opr4[i] != null)
					model.setSt745Opr4(st745Opr4[i]);
				if (st745Opr7[i] != null)
					model.setSt745Opr7(st745Opr7[i]);
				if (st745Opr6[i] != null)
					model.setSt745Opr6(st745Opr6[i]);
				if (st745Opr9[i] != null)
					model.setSt745Opr9(st745Opr9[i]);
				if (st745Opr8[i] != null)
					model.setSt745Opr8(st745Opr8[i]);
				if (st42hOpr8[i] != null)
					model.setSt42hOpr8(st42hOpr8[i]);
				if (st42hOpr9[i] != null)
					model.setSt42hOpr9(st42hOpr9[i]);
				if (st745Opr1[i] != null)
					model.setSt745Opr1(st745Opr1[i]);
				if (st114hOpr10[i] != null)
					model.setSt114hOpr10(st114hOpr10[i]);
				if (st140Opr6[i] != null)
					model.setSt140Opr6(st140Opr6[i]);
				if (st140Opr5[i] != null)
					model.setSt140Opr5(st140Opr5[i]);
				if (st140Opr8[i] != null)
					model.setSt140Opr8(st140Opr8[i]);
				if (st140Opr7[i] != null)
					model.setSt140Opr7(st140Opr7[i]);
				if (st140Opr9[i] != null)
					model.setSt140Opr9(st140Opr9[i]);
				if (st142hOpr10[i] != null)
					model.setSt142hOpr10(st142hOpr10[i]);
				if (st140Opr1[i] != null)
					model.setSt140Opr1(st140Opr1[i]);
				if (st140Opr2[i] != null)
					model.setSt140Opr2(st140Opr2[i]);
				if (st140Opr3[i] != null)
					model.setSt140Opr3(st140Opr3[i]);
				if (st54hOpr10[i] != null)
					model.setSt54hOpr10(st54hOpr10[i]);
				if (st140Opr4[i] != null)
					model.setSt140Opr4(st140Opr4[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCBFSpecialStwgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CBFSpecialStwgVO[]
	 */
	public CBFSpecialStwgVO[] getCBFSpecialStwgVOs(){
		CBFSpecialStwgVO[] vos = (CBFSpecialStwgVO[])models.toArray(new CBFSpecialStwgVO[models.size()]);
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
		this.st720Opr10 = this.st720Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st740Opr7 = this.st740Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1445Opr10 = this.st1445Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st740Opr8 = this.st740Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st740Opr9 = this.st740Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st140Opr10 = this.st140Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st740Opr1 = this.st740Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st740Opr2 = this.st740Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st740Opr3 = this.st740Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st740Opr4 = this.st740Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st740Opr5 = this.st740Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st740Opr6 = this.st740Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st145Opr10 = this.st145Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1545Opr10 = this.st1545Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st640Opr10 = this.st640Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1340Opr10 = this.st1340Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st520Opr10 = this.st520Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st154hOpr10 = this.st154hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st82hOpr10 = this.st82hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st845Opr10 = this.st845Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st645Opr3 = this.st645Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st645Opr4 = this.st645Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st645Opr5 = this.st645Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st545Opr8 = this.st545Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st645Opr6 = this.st645Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st545Opr9 = this.st545Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st545Opr6 = this.st545Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st645Opr7 = this.st645Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st545Opr7 = this.st545Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st645Opr8 = this.st645Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st545Opr4 = this.st545Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st645Opr9 = this.st645Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st545Opr5 = this.st545Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st545Opr2 = this.st545Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st545Opr3 = this.st545Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1145Opr10 = this.st1145Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st545Opr1 = this.st545Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st645Opr1 = this.st645Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st645Opr2 = this.st645Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st114hOpr8 = this.st114hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st114hOpr9 = this.st114hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st114hOpr4 = this.st114hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st114hOpr5 = this.st114hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st114hOpr6 = this.st114hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st114hOpr7 = this.st114hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st114hOpr1 = this.st114hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st114hOpr2 = this.st114hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st114hOpr3 = this.st114hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st745Opr10 = this.st745Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1320Opr10 = this.st1320Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st122hOpr1 = this.st122hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st122hOpr2 = this.st122hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st122hOpr3 = this.st122hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st122hOpr4 = this.st122hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st122hOpr5 = this.st122hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st122hOpr6 = this.st122hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st122hOpr7 = this.st122hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st122hOpr8 = this.st122hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st845Opr5 = this.st845Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st104hOpr6 = this.st104hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1445Opr9 = this.st1445Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st104hOpr5 = this.st104hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st845Opr6 = this.st845Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1445Opr8 = this.st1445Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1145Opr1 = this.st1145Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st845Opr7 = this.st845Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st104hOpr8 = this.st104hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1145Opr2 = this.st1145Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st104hOpr7 = this.st104hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st845Opr8 = this.st845Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1145Opr3 = this.st1145Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st845Opr1 = this.st845Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1445Opr5 = this.st1445Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1445Opr4 = this.st1445Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1145Opr4 = this.st1145Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st845Opr2 = this.st845Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st104hOpr9 = this.st104hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st845Opr3 = this.st845Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1145Opr5 = this.st1145Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1445Opr7 = this.st1445Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st845Opr4 = this.st845Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1145Opr6 = this.st1145Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1445Opr6 = this.st1445Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1445Opr1 = this.st1445Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1145Opr7 = this.st1145Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1145Opr8 = this.st1145Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1445Opr3 = this.st1445Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1145Opr9 = this.st1145Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1445Opr2 = this.st1445Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st104hOpr2 = this.st104hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st104hOpr1 = this.st104hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st104hOpr4 = this.st104hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st104hOpr3 = this.st104hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st845Opr9 = this.st845Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st34hOpr2 = this.st34hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st34hOpr1 = this.st34hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st34hOpr4 = this.st34hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st34hOpr3 = this.st34hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st34hOpr6 = this.st34hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st34hOpr5 = this.st34hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st34hOpr8 = this.st34hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st34hOpr7 = this.st34hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st34hOpr9 = this.st34hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1345Opr3 = this.st1345Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1345Opr4 = this.st1345Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1345Opr1 = this.st1345Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1345Opr2 = this.st1345Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1345Opr9 = this.st1345Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1345Opr7 = this.st1345Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1345Opr8 = this.st1345Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1345Opr5 = this.st1345Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1345Opr6 = this.st1345Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st12hOpr10 = this.st12hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st545Opr10 = this.st545Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st152hOpr8 = this.st152hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st152hOpr9 = this.st152hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st152hOpr6 = this.st152hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st152hOpr7 = this.st152hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1140Opr1 = this.st1140Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1140Opr2 = this.st1140Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1140Opr3 = this.st1140Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1420Opr10 = this.st1420Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st142hOpr8 = this.st142hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st142hOpr7 = this.st142hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st142hOpr9 = this.st142hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st74hOpr9 = this.st74hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st74hOpr7 = this.st74hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st74hOpr8 = this.st74hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st74hOpr6 = this.st74hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1220Opr9 = this.st1220Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st74hOpr5 = this.st74hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st74hOpr4 = this.st74hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st74hOpr3 = this.st74hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st74hOpr2 = this.st74hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st74hOpr1 = this.st74hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr10 = this.opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1220Opr1 = this.st1220Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1220Opr2 = this.st1220Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1220Opr3 = this.st1220Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1220Opr4 = this.st1220Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1220Opr5 = this.st1220Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1220Opr6 = this.st1220Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1220Opr7 = this.st1220Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st124hOpr10 = this.st124hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1220Opr8 = this.st1220Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st82hOpr7 = this.st82hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st82hOpr6 = this.st82hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st82hOpr5 = this.st82hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st82hOpr4 = this.st82hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st82hOpr9 = this.st82hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st82hOpr8 = this.st82hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st82hOpr2 = this.st82hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st82hOpr3 = this.st82hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st82hOpr1 = this.st82hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st92hOpr3 = this.st92hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st92hOpr4 = this.st92hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st92hOpr5 = this.st92hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st92hOpr6 = this.st92hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st92hOpr7 = this.st92hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st92hOpr8 = this.st92hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st92hOpr9 = this.st92hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1020Opr10 = this.st1020Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1140Opr9 = this.st1140Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1140Opr8 = this.st1140Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1140Opr7 = this.st1140Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1140Opr6 = this.st1140Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1140Opr5 = this.st1140Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1140Opr4 = this.st1140Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st245Opr3 = this.st245Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st245Opr4 = this.st245Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st740Opr10 = this.st740Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st245Opr5 = this.st245Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st152hOpr1 = this.st152hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st245Opr6 = this.st245Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st152hOpr3 = this.st152hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st152hOpr2 = this.st152hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st245Opr1 = this.st245Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st152hOpr5 = this.st152hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st152hOpr4 = this.st152hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st245Opr2 = this.st245Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st245Opr7 = this.st245Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st920Opr10 = this.st920Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st245Opr8 = this.st245Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st92hOpr2 = this.st92hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st245Opr9 = this.st245Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st92hOpr1 = this.st92hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st52hOpr2 = this.st52hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st52hOpr1 = this.st52hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st52hOpr6 = this.st52hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st52hOpr5 = this.st52hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st52hOpr4 = this.st52hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st52hOpr3 = this.st52hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st144hOpr10 = this.st144hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st52hOpr9 = this.st52hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st52hOpr7 = this.st52hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st52hOpr8 = this.st52hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st122hOpr9 = this.st122hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st124hOpr4 = this.st124hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st940Opr2 = this.st940Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st124hOpr3 = this.st124hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st940Opr1 = this.st940Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st940Opr4 = this.st940Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st124hOpr6 = this.st124hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st940Opr3 = this.st940Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st124hOpr5 = this.st124hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st124hOpr8 = this.st124hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st124hOpr7 = this.st124hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st245Opr10 = this.st245Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st124hOpr9 = this.st124hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st940Opr9 = this.st940Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st940Opr6 = this.st940Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st940Opr5 = this.st940Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st124hOpr2 = this.st124hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st940Opr8 = this.st940Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st32hOpr10 = this.st32hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st124hOpr1 = this.st124hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st940Opr7 = this.st940Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st142hOpr6 = this.st142hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st142hOpr5 = this.st142hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st142hOpr4 = this.st142hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st142hOpr3 = this.st142hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st142hOpr2 = this.st142hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st142hOpr1 = this.st142hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st94hOpr1 = this.st94hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st94hOpr2 = this.st94hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st94hOpr3 = this.st94hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st94hOpr4 = this.st94hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1520Opr1 = this.st1520Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st94hOpr9 = this.st94hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st112hOpr1 = this.st112hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1520Opr5 = this.st1520Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st94hOpr6 = this.st94hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1520Opr4 = this.st1520Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st94hOpr5 = this.st94hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1520Opr3 = this.st1520Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st94hOpr8 = this.st94hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1520Opr2 = this.st1520Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st94hOpr7 = this.st94hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st112hOpr6 = this.st112hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1520Opr9 = this.st1520Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st112hOpr7 = this.st112hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1520Opr8 = this.st1520Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1520Opr7 = this.st1520Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st112hOpr8 = this.st112hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1520Opr6 = this.st1520Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st112hOpr9 = this.st112hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st112hOpr2 = this.st112hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st112hOpr3 = this.st112hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st340Opr10 = this.st340Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st112hOpr4 = this.st112hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st112hOpr5 = this.st112hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1120Opr7 = this.st1120Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1120Opr6 = this.st1120Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1120Opr9 = this.st1120Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1120Opr8 = this.st1120Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1120Opr3 = this.st1120Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1120Opr2 = this.st1120Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1120Opr5 = this.st1120Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1120Opr4 = this.st1120Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st132hOpr4 = this.st132hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st132hOpr5 = this.st132hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st132hOpr6 = this.st132hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st132hOpr7 = this.st132hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st132hOpr1 = this.st132hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st132hOpr2 = this.st132hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st132hOpr3 = this.st132hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st24hOpr10 = this.st24hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st345Opr10 = this.st345Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty1 = this.qty1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty3 = this.qty3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty2 = this.qty2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty5 = this.qty5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty4 = this.qty4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st720Opr7 = this.st720Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st720Opr8 = this.st720Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st720Opr5 = this.st720Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st720Opr6 = this.st720Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st720Opr9 = this.st720Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st34hOpr10 = this.st34hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st62hOpr10 = this.st62hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1440Opr10 = this.st1440Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st720Opr3 = this.st720Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st720Opr4 = this.st720Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st720Opr1 = this.st720Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st720Opr2 = this.st720Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1045Opr10 = this.st1045Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1540Opr1 = this.st1540Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1540Opr2 = this.st1540Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1540Opr3 = this.st1540Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1540Opr4 = this.st1540Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1540Opr5 = this.st1540Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1540Opr6 = this.st1540Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1540Opr7 = this.st1540Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1540Opr8 = this.st1540Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1540Opr9 = this.st1540Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty8 = this.qty8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1545Opr1 = this.st1545Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1545Opr2 = this.st1545Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty9 = this.qty9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty6 = this.qty6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st420Opr10 = this.st420Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty7 = this.qty7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1545Opr5 = this.st1545Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1545Opr6 = this.st1545Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1545Opr3 = this.st1545Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1545Opr4 = this.st1545Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1545Opr9 = this.st1545Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1545Opr7 = this.st1545Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1545Opr8 = this.st1545Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1320Opr1 = this.st1320Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1320Opr3 = this.st1320Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st132hOpr9 = this.st132hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1320Opr2 = this.st1320Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st132hOpr8 = this.st132hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1320Opr5 = this.st1320Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1320Opr4 = this.st1320Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1320Opr7 = this.st1320Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1320Opr6 = this.st1320Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1320Opr9 = this.st1320Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1320Opr8 = this.st1320Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st340Opr1 = this.st340Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st340Opr2 = this.st340Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st340Opr9 = this.st340Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st340Opr8 = this.st340Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st340Opr7 = this.st340Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st340Opr6 = this.st340Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st340Opr5 = this.st340Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st340Opr4 = this.st340Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st340Opr3 = this.st340Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allFlg = this.allFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st445Opr10 = this.st445Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st120Opr1 = this.st120Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st120Opr2 = this.st120Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st120Opr10 = this.st120Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st132hOpr10 = this.st132hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st120Opr4 = this.st120Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st120Opr3 = this.st120Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st120Opr6 = this.st120Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st120Opr5 = this.st120Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st120Opr8 = this.st120Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st120Opr7 = this.st120Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st120Opr9 = this.st120Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1040Opr10 = this.st1040Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st92hOpr10 = this.st92hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1045Opr5 = this.st1045Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1045Opr4 = this.st1045Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1045Opr7 = this.st1045Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1045Opr6 = this.st1045Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1045Opr1 = this.st1045Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st540Opr10 = this.st540Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1045Opr3 = this.st1045Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbCgoFlg = this.bbCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1045Opr2 = this.st1045Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1045Opr9 = this.st1045Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1045Opr8 = this.st1045Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mlbCd = this.mlbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1520Opr10 = this.st1520Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st345Opr7 = this.st345Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st345Opr6 = this.st345Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st345Opr9 = this.st345Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st345Opr8 = this.st345Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1120Opr1 = this.st1120Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st345Opr1 = this.st345Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st345Opr3 = this.st345Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st345Opr2 = this.st345Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st345Opr5 = this.st345Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st345Opr4 = this.st345Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st12hOpr2 = this.st12hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st12hOpr1 = this.st12hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1340Opr1 = this.st1340Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st12hOpr8 = this.st12hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st12hOpr7 = this.st12hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st12hOpr9 = this.st12hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st12hOpr4 = this.st12hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st12hOpr3 = this.st12hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st12hOpr6 = this.st12hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st12hOpr5 = this.st12hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1420Opr6 = this.st1420Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1420Opr5 = this.st1420Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1420Opr4 = this.st1420Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1420Opr3 = this.st1420Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1420Opr2 = this.st1420Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1420Opr1 = this.st1420Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1420Opr9 = this.st1420Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1420Opr8 = this.st1420Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1420Opr7 = this.st1420Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st84hOpr1 = this.st84hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st84hOpr3 = this.st84hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st84hOpr2 = this.st84hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st84hOpr5 = this.st84hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st84hOpr4 = this.st84hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st152hOpr10 = this.st152hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st84hOpr6 = this.st84hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st84hOpr7 = this.st84hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st84hOpr8 = this.st84hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st84hOpr9 = this.st84hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st14hOpr10 = this.st14hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st640Opr8 = this.st640Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1245Opr9 = this.st1245Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1245Opr8 = this.st1245Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st640Opr9 = this.st640Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1245Opr7 = this.st1245Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1245Opr6 = this.st1245Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st640Opr4 = this.st640Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1245Opr5 = this.st1245Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st640Opr5 = this.st640Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1245Opr4 = this.st1245Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1245Opr3 = this.st1245Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st640Opr6 = this.st640Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1245Opr2 = this.st1245Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st640Opr7 = this.st640Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1245Opr1 = this.st1245Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st640Opr1 = this.st640Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st640Opr2 = this.st640Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st640Opr3 = this.st640Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st52hOpr10 = this.st52hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1340Opr2 = this.st1340Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1340Opr3 = this.st1340Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1340Opr4 = this.st1340Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1340Opr5 = this.st1340Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1340Opr6 = this.st1340Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1340Opr7 = this.st1340Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1340Opr8 = this.st1340Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1340Opr9 = this.st1340Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st945Opr1 = this.st945Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st945Opr3 = this.st945Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st945Opr2 = this.st945Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st945Opr5 = this.st945Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st945Opr4 = this.st945Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st945Opr7 = this.st945Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st945Opr6 = this.st945Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st64hOpr10 = this.st64hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st520Opr1 = this.st520Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st540Opr2 = this.st540Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st540Opr1 = this.st540Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st520Opr2 = this.st520Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st540Opr4 = this.st540Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st540Opr3 = this.st540Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty10 = this.qty10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st520Opr5 = this.st520Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st540Opr6 = this.st540Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st540Opr5 = this.st540Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st520Opr6 = this.st520Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st520Opr3 = this.st520Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st540Opr8 = this.st540Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st520Opr4 = this.st520Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st540Opr7 = this.st540Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st520Opr9 = this.st520Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st540Opr9 = this.st540Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st520Opr7 = this.st520Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st520Opr8 = this.st520Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st945Opr10 = this.st945Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st94hOpr10 = this.st94hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCgoFlg = this.stwgCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1540Opr10 = this.st1540Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st945Opr8 = this.st945Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st945Opr9 = this.st945Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st32hOpr9 = this.st32hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st24hOpr1 = this.st24hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st920Opr9 = this.st920Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st24hOpr3 = this.st24hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st920Opr8 = this.st920Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st24hOpr2 = this.st24hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st920Opr7 = this.st920Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st920Opr6 = this.st920Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st920Opr5 = this.st920Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st920Opr4 = this.st920Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st920Opr3 = this.st920Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st32hOpr4 = this.st32hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st920Opr2 = this.st920Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st24hOpr9 = this.st24hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st32hOpr3 = this.st32hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st920Opr1 = this.st920Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwgCd = this.stwgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st24hOpr8 = this.st24hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st240Opr10 = this.st240Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st32hOpr2 = this.st32hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st32hOpr1 = this.st32hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st24hOpr5 = this.st24hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st32hOpr8 = this.st32hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st24hOpr4 = this.st24hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st32hOpr7 = this.st32hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st32hOpr6 = this.st32hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st24hOpr7 = this.st24hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st32hOpr5 = this.st32hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st24hOpr6 = this.st24hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st240Opr4 = this.st240Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st820Opr1 = this.st820Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st112hOpr10 = this.st112hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st240Opr5 = this.st240Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st820Opr3 = this.st820Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st240Opr6 = this.st240Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st820Opr2 = this.st820Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st240Opr7 = this.st240Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st240Opr8 = this.st240Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st240Opr9 = this.st240Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st64hOpr7 = this.st64hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st820Opr9 = this.st820Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st64hOpr6 = this.st64hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st820Opr8 = this.st820Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st64hOpr5 = this.st64hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st64hOpr4 = this.st64hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st64hOpr3 = this.st64hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st820Opr5 = this.st820Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st820Opr4 = this.st820Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st64hOpr2 = this.st64hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st64hOpr1 = this.st64hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st820Opr7 = this.st820Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st820Opr6 = this.st820Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st445Opr1 = this.st445Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st445Opr2 = this.st445Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st445Opr3 = this.st445Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st64hOpr8 = this.st64hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st445Opr4 = this.st445Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st64hOpr9 = this.st64hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st445Opr5 = this.st445Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st445Opr6 = this.st445Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st445Opr7 = this.st445Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st445Opr8 = this.st445Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st240Opr1 = this.st240Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st445Opr9 = this.st445Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st240Opr3 = this.st240Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st240Opr2 = this.st240Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st9 = this.st9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st7 = this.st7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st8 = this.st8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st5 = this.st5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st6 = this.st6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st3 = this.st3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st4 = this.st4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1 = this.st1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st2 = this.st2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st940Opr10 = this.st940Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1220Opr10 = this.st1220Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st320Opr9 = this.st320Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st320Opr8 = this.st320Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st320Opr7 = this.st320Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st320Opr6 = this.st320Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st320Opr5 = this.st320Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st42hOpr10 = this.st42hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st320Opr4 = this.st320Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st320Opr3 = this.st320Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st320Opr2 = this.st320Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st320Opr1 = this.st320Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st144hOpr9 = this.st144hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st645Opr10 = this.st645Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st22hOpr1 = this.st22hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st22hOpr8 = this.st22hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st22hOpr9 = this.st22hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st22hOpr6 = this.st22hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st22hOpr7 = this.st22hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st122hOpr10 = this.st122hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st104hOpr10 = this.st104hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st22hOpr4 = this.st22hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st22hOpr5 = this.st22hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st22hOpr2 = this.st22hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st22hOpr3 = this.st22hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st440Opr10 = this.st440Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st44hOpr6 = this.st44hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st44hOpr7 = this.st44hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st44hOpr8 = this.st44hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st44hOpr9 = this.st44hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st44hOpr2 = this.st44hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st44hOpr3 = this.st44hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st44hOpr4 = this.st44hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st44hOpr5 = this.st44hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st44hOpr1 = this.st44hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgShprOwnrFlg = this.bkgShprOwnrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st144hOpr1 = this.st144hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st144hOpr2 = this.st144hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st144hOpr3 = this.st144hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st74hOpr10 = this.st74hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st144hOpr4 = this.st144hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st144hOpr5 = this.st144hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st144hOpr6 = this.st144hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st144hOpr7 = this.st144hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st144hOpr8 = this.st144hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st72hOpr10 = this.st72hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st420Opr9 = this.st420Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st420Opr8 = this.st420Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st420Opr5 = this.st420Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st420Opr4 = this.st420Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st420Opr7 = this.st420Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st420Opr6 = this.st420Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st420Opr1 = this.st420Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st420Opr3 = this.st420Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st420Opr2 = this.st420Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st840Opr9 = this.st840Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st840Opr8 = this.st840Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st840Opr7 = this.st840Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st840Opr6 = this.st840Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st22hOpr10 = this.st22hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st840Opr1 = this.st840Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st440Opr9 = this.st440Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st440Opr8 = this.st440Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st440Opr7 = this.st440Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st440Opr6 = this.st440Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st440Opr5 = this.st440Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st840Opr5 = this.st840Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st840Opr4 = this.st840Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st440Opr4 = this.st440Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st840Opr3 = this.st840Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st440Opr3 = this.st440Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st440Opr2 = this.st440Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st840Opr2 = this.st840Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st440Opr1 = this.st440Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st820Opr10 = this.st820Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1120Opr10 = this.st1120Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st620Opr9 = this.st620Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st620Opr8 = this.st620Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st620Opr7 = this.st620Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st620Opr6 = this.st620Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st620Opr1 = this.st620Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st620Opr5 = this.st620Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st620Opr4 = this.st620Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st620Opr3 = this.st620Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st620Opr2 = this.st620Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1240Opr9 = this.st1240Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st62hOpr1 = this.st62hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1240Opr8 = this.st1240Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1240Opr7 = this.st1240Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st62hOpr3 = this.st62hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1240Opr6 = this.st1240Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st62hOpr2 = this.st62hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1240Opr5 = this.st1240Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st62hOpr5 = this.st62hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1240Opr4 = this.st1240Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st62hOpr4 = this.st62hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1240Opr3 = this.st1240Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st62hOpr6 = this.st62hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st62hOpr7 = this.st62hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st62hOpr8 = this.st62hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st62hOpr9 = this.st62hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st134hOpr10 = this.st134hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st620Opr10 = this.st620Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st84hOpr10 = this.st84hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st145Opr9 = this.st145Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1245Opr10 = this.st1245Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st145Opr8 = this.st145Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st154hOpr9 = this.st154hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st154hOpr8 = this.st154hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1345Opr10 = this.st1345Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st145Opr3 = this.st145Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st145Opr2 = this.st145Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st145Opr1 = this.st145Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st145Opr7 = this.st145Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st145Opr6 = this.st145Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st145Opr5 = this.st145Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st44hOpr10 = this.st44hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st145Opr4 = this.st145Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st54hOpr4 = this.st54hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr7 = this.opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st54hOpr3 = this.st54hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr8 = this.opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr5 = this.opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st54hOpr2 = this.st54hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st54hOpr1 = this.st54hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr6 = this.opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr3 = this.opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st54hOpr8 = this.st54hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr4 = this.opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st54hOpr7 = this.st54hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr1 = this.opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st54hOpr6 = this.st54hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st54hOpr5 = this.st54hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr2 = this.opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opr9 = this.opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st54hOpr9 = this.st54hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st220Opr6 = this.st220Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st220Opr7 = this.st220Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st220Opr8 = this.st220Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st220Opr9 = this.st220Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st220Opr2 = this.st220Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st220Opr3 = this.st220Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st220Opr4 = this.st220Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st220Opr5 = this.st220Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1020Opr2 = this.st1020Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1020Opr1 = this.st1020Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st220Opr1 = this.st220Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st15 = this.st15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st14 = this.st14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st13 = this.st13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st12 = this.st12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st11 = this.st11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st10 = this.st10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st134hOpr1 = this.st134hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st134hOpr2 = this.st134hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st72hOpr5 = this.st72hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st134hOpr3 = this.st134hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st72hOpr6 = this.st72hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st134hOpr4 = this.st134hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st72hOpr7 = this.st72hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st134hOpr5 = this.st134hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st72hOpr8 = this.st72hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st134hOpr6 = this.st134hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st72hOpr9 = this.st72hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st134hOpr7 = this.st134hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st134hOpr8 = this.st134hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st134hOpr9 = this.st134hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st154hOpr1 = this.st154hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st154hOpr3 = this.st154hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st154hOpr2 = this.st154hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1440Opr9 = this.st1440Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1040Opr4 = this.st1040Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st72hOpr2 = this.st72hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st154hOpr5 = this.st154hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st154hOpr4 = this.st154hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1040Opr3 = this.st1040Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st72hOpr1 = this.st72hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st72hOpr4 = this.st72hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1040Opr2 = this.st1040Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st154hOpr7 = this.st154hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st72hOpr3 = this.st72hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1040Opr1 = this.st1040Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st154hOpr6 = this.st154hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1440Opr4 = this.st1440Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1440Opr3 = this.st1440Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1440Opr2 = this.st1440Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1440Opr1 = this.st1440Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1440Opr8 = this.st1440Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1440Opr7 = this.st1440Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1440Opr6 = this.st1440Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1440Opr5 = this.st1440Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st102hOpr1 = this.st102hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st102hOpr2 = this.st102hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st102hOpr7 = this.st102hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st102hOpr8 = this.st102hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st102hOpr9 = this.st102hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st102hOpr3 = this.st102hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st102hOpr4 = this.st102hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st102hOpr5 = this.st102hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st102hOpr6 = this.st102hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st320Opr10 = this.st320Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1020Opr3 = this.st1020Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1020Opr4 = this.st1020Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1020Opr5 = this.st1020Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1020Opr6 = this.st1020Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1240Opr2 = this.st1240Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1020Opr7 = this.st1020Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1240Opr1 = this.st1240Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1020Opr8 = this.st1020Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1020Opr9 = this.st1020Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1240Opr10 = this.st1240Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st14hOpr9 = this.st14hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1140Opr10 = this.st1140Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st14hOpr5 = this.st14hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st14hOpr6 = this.st14hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st14hOpr7 = this.st14hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st14hOpr8 = this.st14hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st14hOpr1 = this.st14hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st14hOpr2 = this.st14hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st14hOpr3 = this.st14hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st14hOpr4 = this.st14hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st840Opr10 = this.st840Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mlb = this.mlb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st102hOpr10 = this.st102hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoFlg = this.awkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st42hOpr1 = this.st42hOpr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1040Opr9 = this.st1040Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st42hOpr3 = this.st42hOpr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st42hOpr2 = this.st42hOpr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st42hOpr5 = this.st42hOpr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1040Opr6 = this.st1040Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st220Opr10 = this.st220Opr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st42hOpr4 = this.st42hOpr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1040Opr5 = this.st1040Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st42hOpr7 = this.st42hOpr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1040Opr8 = this.st1040Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st42hOpr6 = this.st42hOpr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st1040Opr7 = this.st1040Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st745Opr3 = this.st745Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st745Opr2 = this.st745Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st745Opr5 = this.st745Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st745Opr4 = this.st745Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st745Opr7 = this.st745Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st745Opr6 = this.st745Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st745Opr9 = this.st745Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st745Opr8 = this.st745Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st42hOpr8 = this.st42hOpr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st42hOpr9 = this.st42hOpr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st745Opr1 = this.st745Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st114hOpr10 = this.st114hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st140Opr6 = this.st140Opr6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st140Opr5 = this.st140Opr5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st140Opr8 = this.st140Opr8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st140Opr7 = this.st140Opr7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st140Opr9 = this.st140Opr9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st142hOpr10 = this.st142hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st140Opr1 = this.st140Opr1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st140Opr2 = this.st140Opr2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st140Opr3 = this.st140Opr3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st54hOpr10 = this.st54hOpr10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.st140Opr4 = this.st140Opr4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd   = this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
