/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementRatesVO.java
*@FileTitle : AgreementRatesVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.06.05 노정용 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 노정용
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AgreementRatesVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AgreementRatesVO> models = new ArrayList<AgreementRatesVO>();
	
	private String cntrSpecNo = null;
	/* Column Info */
	private String cntr23N2Amt = null;
	/* Column Info */
	private String cntr19N1Amt = null;
	/* Column Info */
	private String cntr28N1Amt = null;
	/* Column Info */
	private String cntr22N2Amt = null;
	/* Column Info */
	private String cntr21N2Amt = null;
	/* Column Info */
	private String cntr2N2Amt = null;
	/* Column Info */
	private String cntr5N2Amt = null;
	/* Column Info */
	private String cntr1N2Amt = null;
	/* Column Info */
	private String cntr20N2Amt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String cntr14ChgVal = null;
	/* Column Info */
	private String cntr25N1Amt = null;
	/* Column Info */
	private String cntr14N2Amt = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntr16N1Amt = null;
	/* Column Info */
	private String cntr25ChgVal = null;
	/* Column Info */
	private String cntr13N2Amt = null;
	/* Column Info */
	private String cntr24N2Amt = null;
	/* Column Info */
	private String cntr16N2Amt = null;
	/* Column Info */
	private String cntr4ChgVal = null;
	/* Column Info */
	private String cntr29ChgVal = null;
	/* Column Info */
	private String cntr16ChgVal = null;
	/* Column Info */
	private String cntr13N1Amt = null;
	/* Column Info */
	private String cntr1ChgVal = null;
	/* Column Info */
	private String cntr17N1Amt = null;
	/* Column Info */
	private String cntr9ChgVal = null;
	/* Column Info */
	private String cntr10ChgVal = null;
	/* Column Info */
	private String cntr26ChgVal = null;
	/* Column Info */
	private String cntr11N2Amt = null;
	/* Column Info */
	private String cntr23ChgVal = null;
	/* Column Info */
	private String cntr20N1Amt = null;
	/* Column Info */
	private String cntr21N1Amt = null;
	/* Column Info */
	private String cntr12N2Amt = null;
	/* Column Info */
	private String cntr27N1Amt = null;
	/* Column Info */
	private String cntr6N2Amt = null;
	/* Column Info */
	private String cntr15ChgVal = null;
	/* Column Info */
	private String cntrRntlChgTpCd = null;
	/* Column Info */
	private String cntr20ChgVal = null;
	/* Column Info */
	private String cntr18N2Amt = null;
	/* Column Info */
	private String cntr11N1Amt = null;
	/* Column Info */
	private String cntr3ChgVal = null;
	/* Column Info */
	private String cntr8ChgVal = null;
	/* Column Info */
	private String cntr14N1Amt = null;
	/* Column Info */
	private String cntr28ChgVal = null;
	/* Column Info */
	private String cntr26N2Amt = null;
	/* Column Info */
	private String cntr17N2Amt = null;
	/* Column Info */
	private String cntr4N1Amt = null;
	/* Column Info */
	private String cntr2N1Amt = null;
	/* Column Info */
	private String agmtChgVal = null;
	/* Column Info */
	private String cntr12ChgVal = null;
	/* Column Info */
	private String cntr23N1Amt = null;
	/* Column Info */
	private String cntr24ChgVal = null;
	/* Column Info */
	private String cntr2ChgVal = null;
	/* Column Info */
	private String cntr8N1Amt = null;
	/* Column Info */
	private String cntr13ChgVal = null;
	/* Column Info */
	private String cntr25N2Amt = null;
	/* Column Info */
	private String cntr6ChgVal = null;
	/* Column Info */
	private String cntr22N1Amt = null;
	/* Column Info */
	private String cntr30N1Amt = null;
	/* Column Info */
	private String cntr26N1Amt = null;
	/* Column Info */
	private String cntr7ChgVal = null;
	/* Column Info */
	private String cntr4N2Amt = null;
	/* Column Info */
	private String cntr22ChgVal = null;
	/* Column Info */
	private String cntr7N1Amt = null;
	/* Column Info */
	private String cntr3N2Amt = null;
	/* Column Info */
	private String cntr30ChgVal = null;
	/* Column Info */
	private String cntr27ChgVal = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String cntr7N2Amt = null;
	/* Column Info */
	private String cntr8N2Amt = null;
	/* Column Info */
	private String cntr24N1Amt = null;
	/* Column Info */
	private String cntr5ChgVal = null;
	/* Column Info */
	private String cntr11ChgVal = null;
	/* Column Info */
	private String cntr10N1Amt = null;
	/* Column Info */
	private String cntr27N2Amt = null;
	/* Column Info */
	private String cntr18ChgVal = null;
	/* Column Info */
	private String cntr3N1Amt = null;
	/* Column Info */
	private String cntr5N1Amt = null;
	/* Column Info */
	private String cntr30N2Amt = null;
	/* Column Info */
	private String cntr28N2Amt = null;
	/* Column Info */
	private String cntr19ChgVal = null;
	/* Column Info */
	private String cntr9N1Amt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntr1N1Amt = null;
	/* Column Info */
	private String cntr17ChgVal = null;
	/* Column Info */
	private String agmtCtyCd = null;
	/* Column Info */
	private String cntr9N2Amt = null;
	/* Column Info */
	private String cntr12N1Amt = null;
	/* Column Info */
	private String cntr29N2Amt = null;
	/* Column Info */
	private String cntr6N1Amt = null;
	/* Column Info */
	private String cntr19N2Amt = null;
	/* Column Info */
	private String cntr18N1Amt = null;
	/* Column Info */
	private String cntr15N1Amt = null;
	/* Column Info */
	private String cntr15N2Amt = null;
	/* Column Info */
	private String cntr21ChgVal = null;
	/* Column Info */
	private String cntr10N2Amt = null;
	/* Column Info */
	private String cntr29N1Amt = null;
	/*	Column Info	*/
	private  String	 eqLocTpCd   =  null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	/**
	 * Constructor
	 */
	public AgreementRatesVO() {}

	/**
	 * Constructor
	 */
	public AgreementRatesVO(String ibflag, String pagerows, String agmtCtyCd, String agmtSeq, String locCd, String cntrTpszCd, String cntrRntlChgTpCd, String agmtChgVal
						  , String cntr1ChgVal, String cntr2ChgVal, String cntr3ChgVal, String cntr4ChgVal, String cntr5ChgVal, String cntr6ChgVal, String cntr7ChgVal
						  , String cntr8ChgVal, String cntr9ChgVal, String cntr10ChgVal, String cntr11ChgVal, String cntr12ChgVal, String cntr13ChgVal
						  , String cntr14ChgVal, String cntr15ChgVal, String cntr16ChgVal, String cntr17ChgVal, String cntr18ChgVal, String cntr19ChgVal
						  , String cntr20ChgVal, String cntr21ChgVal, String cntr22ChgVal, String cntr23ChgVal, String cntr24ChgVal, String cntr25ChgVal
						  , String cntr26ChgVal, String cntr27ChgVal, String cntr28ChgVal, String cntr29ChgVal, String cntr30ChgVal
						  , String cntr1N1Amt, String cntr2N1Amt, String cntr3N1Amt, String cntr4N1Amt, String cntr5N1Amt, String cntr6N1Amt, String cntr7N1Amt
						  , String cntr8N1Amt, String cntr9N1Amt, String cntr10N1Amt, String cntr11N1Amt, String cntr12N1Amt, String cntr13N1Amt
						  , String cntr14N1Amt, String cntr15N1Amt, String cntr16N1Amt, String cntr17N1Amt, String cntr18N1Amt, String cntr19N1Amt
						  , String cntr20N1Amt, String cntr21N1Amt, String cntr22N1Amt, String cntr23N1Amt, String cntr24N1Amt, String cntr25N1Amt
						  , String cntr26N1Amt, String cntr27N1Amt, String cntr28N1Amt, String cntr29N1Amt, String cntr30N1Amt, String cntr1N2Amt
						  , String cntr2N2Amt, String cntr3N2Amt, String cntr4N2Amt, String cntr5N2Amt, String cntr6N2Amt, String cntr7N2Amt
						  , String cntr8N2Amt, String cntr9N2Amt, String cntr10N2Amt, String cntr11N2Amt, String cntr12N2Amt, String cntr13N2Amt
						  , String cntr14N2Amt, String cntr15N2Amt, String cntr16N2Amt, String cntr17N2Amt, String cntr18N2Amt, String cntr19N2Amt
						  , String cntr20N2Amt, String cntr21N2Amt, String cntr22N2Amt, String cntr23N2Amt, String cntr24N2Amt, String cntr25N2Amt
						  , String cntr26N2Amt, String cntr27N2Amt, String cntr28N2Amt, String cntr29N2Amt, String cntr30N2Amt, String cntrSpecNo,String eqLocTpCd) {
		this.cntr23N2Amt = cntr23N2Amt;
		this.cntr19N1Amt = cntr19N1Amt;
		this.cntr28N1Amt = cntr28N1Amt;
		this.cntr22N2Amt = cntr22N2Amt;
		this.cntr21N2Amt = cntr21N2Amt;
		this.cntr2N2Amt = cntr2N2Amt;
		this.cntr5N2Amt = cntr5N2Amt;
		this.cntr1N2Amt = cntr1N2Amt;
		this.cntr20N2Amt = cntr20N2Amt;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.cntr14ChgVal = cntr14ChgVal;
		this.cntr25N1Amt = cntr25N1Amt;
		this.cntr14N2Amt = cntr14N2Amt;
		this.cntrTpszCd = cntrTpszCd;
		this.cntr16N1Amt = cntr16N1Amt;
		this.cntr25ChgVal = cntr25ChgVal;
		this.cntr13N2Amt = cntr13N2Amt;
		this.cntr24N2Amt = cntr24N2Amt;
		this.cntr16N2Amt = cntr16N2Amt;
		this.cntr4ChgVal = cntr4ChgVal;
		this.cntr29ChgVal = cntr29ChgVal;
		this.cntr16ChgVal = cntr16ChgVal;
		this.cntr13N1Amt = cntr13N1Amt;
		this.cntr1ChgVal = cntr1ChgVal;
		this.cntr17N1Amt = cntr17N1Amt;
		this.cntr9ChgVal = cntr9ChgVal;
		this.cntr10ChgVal = cntr10ChgVal;
		this.cntr26ChgVal = cntr26ChgVal;
		this.cntr11N2Amt = cntr11N2Amt;
		this.cntr23ChgVal = cntr23ChgVal;
		this.cntr20N1Amt = cntr20N1Amt;
		this.cntr21N1Amt = cntr21N1Amt;
		this.cntr12N2Amt = cntr12N2Amt;
		this.cntr27N1Amt = cntr27N1Amt;
		this.cntr6N2Amt = cntr6N2Amt;
		this.cntr15ChgVal = cntr15ChgVal;
		this.cntrRntlChgTpCd = cntrRntlChgTpCd;
		this.cntr20ChgVal = cntr20ChgVal;
		this.cntr18N2Amt = cntr18N2Amt;
		this.cntr11N1Amt = cntr11N1Amt;
		this.cntr3ChgVal = cntr3ChgVal;
		this.cntr8ChgVal = cntr8ChgVal;
		this.cntr14N1Amt = cntr14N1Amt;
		this.cntr28ChgVal = cntr28ChgVal;
		this.cntr26N2Amt = cntr26N2Amt;
		this.cntr17N2Amt = cntr17N2Amt;
		this.cntr4N1Amt = cntr4N1Amt;
		this.cntr2N1Amt = cntr2N1Amt;
		this.agmtChgVal = agmtChgVal;
		this.cntr12ChgVal = cntr12ChgVal;
		this.cntr23N1Amt = cntr23N1Amt;
		this.cntr24ChgVal = cntr24ChgVal;
		this.cntr2ChgVal = cntr2ChgVal;
		this.cntr8N1Amt = cntr8N1Amt;
		this.cntr13ChgVal = cntr13ChgVal;
		this.cntr25N2Amt = cntr25N2Amt;
		this.cntr6ChgVal = cntr6ChgVal;
		this.cntr22N1Amt = cntr22N1Amt;
		this.cntr30N1Amt = cntr30N1Amt;
		this.cntr26N1Amt = cntr26N1Amt;
		this.cntr7ChgVal = cntr7ChgVal;
		this.cntr4N2Amt = cntr4N2Amt;
		this.cntr22ChgVal = cntr22ChgVal;
		this.cntr7N1Amt = cntr7N1Amt;
		this.cntr3N2Amt = cntr3N2Amt;
		this.cntr30ChgVal = cntr30ChgVal;
		this.cntr27ChgVal = cntr27ChgVal;
		this.agmtSeq = agmtSeq;
		this.cntr7N2Amt = cntr7N2Amt;
		this.cntr8N2Amt = cntr8N2Amt;
		this.cntr24N1Amt = cntr24N1Amt;
		this.cntr5ChgVal = cntr5ChgVal;
		this.cntr11ChgVal = cntr11ChgVal;
		this.cntr10N1Amt = cntr10N1Amt;
		this.cntr27N2Amt = cntr27N2Amt;
		this.cntr18ChgVal = cntr18ChgVal;
		this.cntr3N1Amt = cntr3N1Amt;
		this.cntr5N1Amt = cntr5N1Amt;
		this.cntr30N2Amt = cntr30N2Amt;
		this.cntr28N2Amt = cntr28N2Amt;
		this.cntr19ChgVal = cntr19ChgVal;
		this.cntr9N1Amt = cntr9N1Amt;
		this.ibflag = ibflag;
		this.cntr1N1Amt = cntr1N1Amt;
		this.cntr17ChgVal = cntr17ChgVal;
		this.agmtCtyCd = agmtCtyCd;
		this.cntr9N2Amt = cntr9N2Amt;
		this.cntr12N1Amt = cntr12N1Amt;
		this.cntr29N2Amt = cntr29N2Amt;
		this.cntr6N1Amt = cntr6N1Amt;
		this.cntr19N2Amt = cntr19N2Amt;
		this.cntr18N1Amt = cntr18N1Amt;
		this.cntr15N1Amt = cntr15N1Amt;
		this.cntr15N2Amt = cntr15N2Amt;
		this.cntr21ChgVal = cntr21ChgVal;
		this.cntr10N2Amt = cntr10N2Amt;
		this.cntr29N1Amt = cntr29N1Amt;
		this.cntrSpecNo = cntrSpecNo;
		this.eqLocTpCd  = eqLocTpCd ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr23_n2_amt", getCntr23N2Amt());
		this.hashColumns.put("cntr19_n1_amt", getCntr19N1Amt());
		this.hashColumns.put("cntr28_n1_amt", getCntr28N1Amt());
		this.hashColumns.put("cntr22_n2_amt", getCntr22N2Amt());
		this.hashColumns.put("cntr21_n2_amt", getCntr21N2Amt());
		this.hashColumns.put("cntr2_n2_amt", getCntr2N2Amt());
		this.hashColumns.put("cntr5_n2_amt", getCntr5N2Amt());
		this.hashColumns.put("cntr1_n2_amt", getCntr1N2Amt());
		this.hashColumns.put("cntr20_n2_amt", getCntr20N2Amt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("cntr14_chg_val", getCntr14ChgVal());
		this.hashColumns.put("cntr25_n1_amt", getCntr25N1Amt());
		this.hashColumns.put("cntr14_n2_amt", getCntr14N2Amt());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr16_n1_amt", getCntr16N1Amt());
		this.hashColumns.put("cntr25_chg_val", getCntr25ChgVal());
		this.hashColumns.put("cntr13_n2_amt", getCntr13N2Amt());
		this.hashColumns.put("cntr24_n2_amt", getCntr24N2Amt());
		this.hashColumns.put("cntr16_n2_amt", getCntr16N2Amt());
		this.hashColumns.put("cntr4_chg_val", getCntr4ChgVal());
		this.hashColumns.put("cntr29_chg_val", getCntr29ChgVal());
		this.hashColumns.put("cntr16_chg_val", getCntr16ChgVal());
		this.hashColumns.put("cntr13_n1_amt", getCntr13N1Amt());
		this.hashColumns.put("cntr1_chg_val", getCntr1ChgVal());
		this.hashColumns.put("cntr17_n1_amt", getCntr17N1Amt());
		this.hashColumns.put("cntr9_chg_val", getCntr9ChgVal());
		this.hashColumns.put("cntr10_chg_val", getCntr10ChgVal());
		this.hashColumns.put("cntr26_chg_val", getCntr26ChgVal());
		this.hashColumns.put("cntr11_n2_amt", getCntr11N2Amt());
		this.hashColumns.put("cntr23_chg_val", getCntr23ChgVal());
		this.hashColumns.put("cntr20_n1_amt", getCntr20N1Amt());
		this.hashColumns.put("cntr21_n1_amt", getCntr21N1Amt());
		this.hashColumns.put("cntr12_n2_amt", getCntr12N2Amt());
		this.hashColumns.put("cntr27_n1_amt", getCntr27N1Amt());
		this.hashColumns.put("cntr6_n2_amt", getCntr6N2Amt());
		this.hashColumns.put("cntr15_chg_val", getCntr15ChgVal());
		this.hashColumns.put("cntr_rntl_chg_tp_cd", getCntrRntlChgTpCd());
		this.hashColumns.put("cntr20_chg_val", getCntr20ChgVal());
		this.hashColumns.put("cntr18_n2_amt", getCntr18N2Amt());
		this.hashColumns.put("cntr11_n1_amt", getCntr11N1Amt());
		this.hashColumns.put("cntr3_chg_val", getCntr3ChgVal());
		this.hashColumns.put("cntr8_chg_val", getCntr8ChgVal());
		this.hashColumns.put("cntr14_n1_amt", getCntr14N1Amt());
		this.hashColumns.put("cntr28_chg_val", getCntr28ChgVal());
		this.hashColumns.put("cntr26_n2_amt", getCntr26N2Amt());
		this.hashColumns.put("cntr17_n2_amt", getCntr17N2Amt());
		this.hashColumns.put("cntr4_n1_amt", getCntr4N1Amt());
		this.hashColumns.put("cntr2_n1_amt", getCntr2N1Amt());
		this.hashColumns.put("agmt_chg_val", getAgmtChgVal());
		this.hashColumns.put("cntr12_chg_val", getCntr12ChgVal());
		this.hashColumns.put("cntr23_n1_amt", getCntr23N1Amt());
		this.hashColumns.put("cntr24_chg_val", getCntr24ChgVal());
		this.hashColumns.put("cntr2_chg_val", getCntr2ChgVal());
		this.hashColumns.put("cntr8_n1_amt", getCntr8N1Amt());
		this.hashColumns.put("cntr13_chg_val", getCntr13ChgVal());
		this.hashColumns.put("cntr25_n2_amt", getCntr25N2Amt());
		this.hashColumns.put("cntr6_chg_val", getCntr6ChgVal());
		this.hashColumns.put("cntr22_n1_amt", getCntr22N1Amt());
		this.hashColumns.put("cntr30_n1_amt", getCntr30N1Amt());
		this.hashColumns.put("cntr26_n1_amt", getCntr26N1Amt());
		this.hashColumns.put("cntr7_chg_val", getCntr7ChgVal());
		this.hashColumns.put("cntr4_n2_amt", getCntr4N2Amt());
		this.hashColumns.put("cntr22_chg_val", getCntr22ChgVal());
		this.hashColumns.put("cntr7_n1_amt", getCntr7N1Amt());
		this.hashColumns.put("cntr3_n2_amt", getCntr3N2Amt());
		this.hashColumns.put("cntr30_chg_val", getCntr30ChgVal());
		this.hashColumns.put("cntr27_chg_val", getCntr27ChgVal());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("cntr7_n2_amt", getCntr7N2Amt());
		this.hashColumns.put("cntr8_n2_amt", getCntr8N2Amt());
		this.hashColumns.put("cntr24_n1_amt", getCntr24N1Amt());
		this.hashColumns.put("cntr5_chg_val", getCntr5ChgVal());
		this.hashColumns.put("cntr11_chg_val", getCntr11ChgVal());
		this.hashColumns.put("cntr10_n1_amt", getCntr10N1Amt());
		this.hashColumns.put("cntr27_n2_amt", getCntr27N2Amt());
		this.hashColumns.put("cntr18_chg_val", getCntr18ChgVal());
		this.hashColumns.put("cntr3_n1_amt", getCntr3N1Amt());
		this.hashColumns.put("cntr5_n1_amt", getCntr5N1Amt());
		this.hashColumns.put("cntr30_n2_amt", getCntr30N2Amt());
		this.hashColumns.put("cntr28_n2_amt", getCntr28N2Amt());
		this.hashColumns.put("cntr19_chg_val", getCntr19ChgVal());
		this.hashColumns.put("cntr9_n1_amt", getCntr9N1Amt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr1_n1_amt", getCntr1N1Amt());
		this.hashColumns.put("cntr17_chg_val", getCntr17ChgVal());
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());
		this.hashColumns.put("cntr9_n2_amt", getCntr9N2Amt());
		this.hashColumns.put("cntr12_n1_amt", getCntr12N1Amt());
		this.hashColumns.put("cntr29_n2_amt", getCntr29N2Amt());
		this.hashColumns.put("cntr6_n1_amt", getCntr6N1Amt());
		this.hashColumns.put("cntr19_n2_amt", getCntr19N2Amt());
		this.hashColumns.put("cntr18_n1_amt", getCntr18N1Amt());
		this.hashColumns.put("cntr15_n1_amt", getCntr15N1Amt());
		this.hashColumns.put("cntr15_n2_amt", getCntr15N2Amt());
		this.hashColumns.put("cntr21_chg_val", getCntr21ChgVal());
		this.hashColumns.put("cntr10_n2_amt", getCntr10N2Amt());
		this.hashColumns.put("cntr29_n1_amt", getCntr29N1Amt());
		this.hashColumns.put("cntr_spec_no", getCntrSpecNo());
		this.hashColumns.put("eq_loc_tp_cd", getEqLocTpCd());		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr23_n2_amt", "cntr23N2Amt");
		this.hashFields.put("cntr19_n1_amt", "cntr19N1Amt");
		this.hashFields.put("cntr28_n1_amt", "cntr28N1Amt");
		this.hashFields.put("cntr22_n2_amt", "cntr22N2Amt");
		this.hashFields.put("cntr21_n2_amt", "cntr21N2Amt");
		this.hashFields.put("cntr2_n2_amt", "cntr2N2Amt");
		this.hashFields.put("cntr5_n2_amt", "cntr5N2Amt");
		this.hashFields.put("cntr1_n2_amt", "cntr1N2Amt");
		this.hashFields.put("cntr20_n2_amt", "cntr20N2Amt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("cntr14_chg_val", "cntr14ChgVal");
		this.hashFields.put("cntr25_n1_amt", "cntr25N1Amt");
		this.hashFields.put("cntr14_n2_amt", "cntr14N2Amt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr16_n1_amt", "cntr16N1Amt");
		this.hashFields.put("cntr25_chg_val", "cntr25ChgVal");
		this.hashFields.put("cntr13_n2_amt", "cntr13N2Amt");
		this.hashFields.put("cntr24_n2_amt", "cntr24N2Amt");
		this.hashFields.put("cntr16_n2_amt", "cntr16N2Amt");
		this.hashFields.put("cntr4_chg_val", "cntr4ChgVal");
		this.hashFields.put("cntr29_chg_val", "cntr29ChgVal");
		this.hashFields.put("cntr16_chg_val", "cntr16ChgVal");
		this.hashFields.put("cntr13_n1_amt", "cntr13N1Amt");
		this.hashFields.put("cntr40_n1_amt", "cntr40N1Amt");
		this.hashFields.put("cntr1_chg_val", "cntr1ChgVal");
		this.hashFields.put("cntr17_n1_amt", "cntr17N1Amt");
		this.hashFields.put("cntr9_chg_val", "cntr9ChgVal");
		this.hashFields.put("cntr10_chg_val", "cntr10ChgVal");
		this.hashFields.put("cntr26_chg_val", "cntr26ChgVal");
		this.hashFields.put("cntr11_n2_amt", "cntr11N2Amt");
		this.hashFields.put("cntr23_chg_val", "cntr23ChgVal");
		this.hashFields.put("cntr20_n1_amt", "cntr20N1Amt");
		this.hashFields.put("cntr21_n1_amt", "cntr21N1Amt");
		this.hashFields.put("cntr40_n2_amt", "cntr40N2Amt");
		this.hashFields.put("cntr12_n2_amt", "cntr12N2Amt");
		this.hashFields.put("cntr27_n1_amt", "cntr27N1Amt");
		this.hashFields.put("cntr6_n2_amt", "cntr6N2Amt");
		this.hashFields.put("cntr15_chg_val", "cntr15ChgVal");
		this.hashFields.put("cntr_rntl_chg_tp_cd", "cntrRntlChgTpCd");
		this.hashFields.put("cntr20_chg_val", "cntr20ChgVal");
		this.hashFields.put("cntr18_n2_amt", "cntr18N2Amt");
		this.hashFields.put("cntr11_n1_amt", "cntr11N1Amt");
		this.hashFields.put("cntr3_chg_val", "cntr3ChgVal");
		this.hashFields.put("cntr8_chg_val", "cntr8ChgVal");
		this.hashFields.put("cntr14_n1_amt", "cntr14N1Amt");
		this.hashFields.put("cntr28_chg_val", "cntr28ChgVal");
		this.hashFields.put("cntr26_n2_amt", "cntr26N2Amt");
		this.hashFields.put("cntr17_n2_amt", "cntr17N2Amt");
		this.hashFields.put("cntr4_n1_amt", "cntr4N1Amt");
		this.hashFields.put("cntr2_n1_amt", "cntr2N1Amt");
		this.hashFields.put("agmt_chg_val", "agmtChgVal");
		this.hashFields.put("cntr12_chg_val", "cntr12ChgVal");
		this.hashFields.put("cntr23_n1_amt", "cntr23N1Amt");
		this.hashFields.put("cntr24_chg_val", "cntr24ChgVal");
		this.hashFields.put("cntr2_chg_val", "cntr2ChgVal");
		this.hashFields.put("cntr8_n1_amt", "cntr8N1Amt");
		this.hashFields.put("cntr13_chg_val", "cntr13ChgVal");
		this.hashFields.put("cntr25_n2_amt", "cntr25N2Amt");
		this.hashFields.put("cntr6_chg_val", "cntr6ChgVal");
		this.hashFields.put("cntr22_n1_amt", "cntr22N1Amt");
		this.hashFields.put("cntr30_n1_amt", "cntr30N1Amt");
		this.hashFields.put("cntr26_n1_amt", "cntr26N1Amt");
		this.hashFields.put("cntr7_chg_val", "cntr7ChgVal");
		this.hashFields.put("cntr4_n2_amt", "cntr4N2Amt");
		this.hashFields.put("cntr22_chg_val", "cntr22ChgVal");
		this.hashFields.put("cntr7_n1_amt", "cntr7N1Amt");
		this.hashFields.put("cntr3_n2_amt", "cntr3N2Amt");
		this.hashFields.put("cntr30_chg_val", "cntr30ChgVal");
		this.hashFields.put("cntr27_chg_val", "cntr27ChgVal");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("cntr7_n2_amt", "cntr7N2Amt");
		this.hashFields.put("cntr8_n2_amt", "cntr8N2Amt");
		this.hashFields.put("cntr24_n1_amt", "cntr24N1Amt");
		this.hashFields.put("cntr5_chg_val", "cntr5ChgVal");
		this.hashFields.put("cntr11_chg_val", "cntr11ChgVal");
		this.hashFields.put("cntr10_n1_amt", "cntr10N1Amt");
		this.hashFields.put("cntr27_n2_amt", "cntr27N2Amt");
		this.hashFields.put("cntr18_chg_val", "cntr18ChgVal");
		this.hashFields.put("cntr3_n1_amt", "cntr3N1Amt");
		this.hashFields.put("cntr5_n1_amt", "cntr5N1Amt");
		this.hashFields.put("cntr30_n2_amt", "cntr30N2Amt");
		this.hashFields.put("cntr28_n2_amt", "cntr28N2Amt");
		this.hashFields.put("cntr19_chg_val", "cntr19ChgVal");
		this.hashFields.put("cntr9_n1_amt", "cntr9N1Amt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr1_n1_amt", "cntr1N1Amt");
		this.hashFields.put("cntr17_chg_val", "cntr17ChgVal");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr9_n2_amt", "cntr9N2Amt");
		this.hashFields.put("cntr12_n1_amt", "cntr12N1Amt");
		this.hashFields.put("cntr29_n2_amt", "cntr29N2Amt");
		this.hashFields.put("cntr6_n1_amt", "cntr6N1Amt");
		this.hashFields.put("cntr19_n2_amt", "cntr19N2Amt");
		this.hashFields.put("cntr18_n1_amt", "cntr18N1Amt");
		this.hashFields.put("cntr15_n1_amt", "cntr15N1Amt");
		this.hashFields.put("cntr15_n2_amt", "cntr15N2Amt");
		this.hashFields.put("cntr21_chg_val", "cntr21ChgVal");
		this.hashFields.put("cntr10_n2_amt", "cntr10N2Amt");
		this.hashFields.put("cntr29_n1_amt", "cntr29N1Amt");
		this.hashFields.put("cntr_spec_no", "cntrSpecNo");
		this.hashFields.put("eq_loc_tp_cd", "eqLocTpCd");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntr23N2Amt
	 */
	public String getCntr23N2Amt() {
		return this.cntr23N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr19N1Amt
	 */
	public String getCntr19N1Amt() {
		return this.cntr19N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr28N1Amt
	 */
	public String getCntr28N1Amt() {
		return this.cntr28N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr22N2Amt
	 */
	public String getCntr22N2Amt() {
		return this.cntr22N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr21N2Amt
	 */
	public String getCntr21N2Amt() {
		return this.cntr21N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr2N2Amt
	 */
	public String getCntr2N2Amt() {
		return this.cntr2N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr5N2Amt
	 */
	public String getCntr5N2Amt() {
		return this.cntr5N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr1N2Amt
	 */
	public String getCntr1N2Amt() {
		return this.cntr1N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr20N2Amt
	 */
	public String getCntr20N2Amt() {
		return this.cntr20N2Amt;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return cntr14ChgVal
	 */
	public String getCntr14ChgVal() {
		return this.cntr14ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr25N1Amt
	 */
	public String getCntr25N1Amt() {
		return this.cntr25N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr14N2Amt
	 */
	public String getCntr14N2Amt() {
		return this.cntr14N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntr16N1Amt
	 */
	public String getCntr16N1Amt() {
		return this.cntr16N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr25ChgVal
	 */
	public String getCntr25ChgVal() {
		return this.cntr25ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr13N2Amt
	 */
	public String getCntr13N2Amt() {
		return this.cntr13N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr24N2Amt
	 */
	public String getCntr24N2Amt() {
		return this.cntr24N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr16N2Amt
	 */
	public String getCntr16N2Amt() {
		return this.cntr16N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr4ChgVal
	 */
	public String getCntr4ChgVal() {
		return this.cntr4ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr29ChgVal
	 */
	public String getCntr29ChgVal() {
		return this.cntr29ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr16ChgVal
	 */
	public String getCntr16ChgVal() {
		return this.cntr16ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr13N1Amt
	 */
	public String getCntr13N1Amt() {
		return this.cntr13N1Amt;
	}
	

	/**
	 * Column Info
	 * @return cntr1ChgVal
	 */
	public String getCntr1ChgVal() {
		return this.cntr1ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr17N1Amt
	 */
	public String getCntr17N1Amt() {
		return this.cntr17N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr9ChgVal
	 */
	public String getCntr9ChgVal() {
		return this.cntr9ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr10ChgVal
	 */
	public String getCntr10ChgVal() {
		return this.cntr10ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr26ChgVal
	 */
	public String getCntr26ChgVal() {
		return this.cntr26ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr11N2Amt
	 */
	public String getCntr11N2Amt() {
		return this.cntr11N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr23ChgVal
	 */
	public String getCntr23ChgVal() {
		return this.cntr23ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr20N1Amt
	 */
	public String getCntr20N1Amt() {
		return this.cntr20N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr21N1Amt
	 */
	public String getCntr21N1Amt() {
		return this.cntr21N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr12N2Amt
	 */
	public String getCntr12N2Amt() {
		return this.cntr12N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr27N1Amt
	 */
	public String getCntr27N1Amt() {
		return this.cntr27N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr6N2Amt
	 */
	public String getCntr6N2Amt() {
		return this.cntr6N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr15ChgVal
	 */
	public String getCntr15ChgVal() {
		return this.cntr15ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntrRntlChgTpCd
	 */
	public String getCntrRntlChgTpCd() {
		return this.cntrRntlChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return cntr20ChgVal
	 */
	public String getCntr20ChgVal() {
		return this.cntr20ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr18N2Amt
	 */
	public String getCntr18N2Amt() {
		return this.cntr18N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr11N1Amt
	 */
	public String getCntr11N1Amt() {
		return this.cntr11N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr3ChgVal
	 */
	public String getCntr3ChgVal() {
		return this.cntr3ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr8ChgVal
	 */
	public String getCntr8ChgVal() {
		return this.cntr8ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr14N1Amt
	 */
	public String getCntr14N1Amt() {
		return this.cntr14N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr28ChgVal
	 */
	public String getCntr28ChgVal() {
		return this.cntr28ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr26N2Amt
	 */
	public String getCntr26N2Amt() {
		return this.cntr26N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr17N2Amt
	 */
	public String getCntr17N2Amt() {
		return this.cntr17N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr4N1Amt
	 */
	public String getCntr4N1Amt() {
		return this.cntr4N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr2N1Amt
	 */
	public String getCntr2N1Amt() {
		return this.cntr2N1Amt;
	}
	
	/**
	 * Column Info
	 * @return agmtChgVal
	 */
	public String getAgmtChgVal() {
		return this.agmtChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr12ChgVal
	 */
	public String getCntr12ChgVal() {
		return this.cntr12ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr23N1Amt
	 */
	public String getCntr23N1Amt() {
		return this.cntr23N1Amt;
	}

	/**
	 * Column Info
	 * @return cntr24ChgVal
	 */
	public String getCntr24ChgVal() {
		return this.cntr24ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr2ChgVal
	 */
	public String getCntr2ChgVal() {
		return this.cntr2ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr8N1Amt
	 */
	public String getCntr8N1Amt() {
		return this.cntr8N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr13ChgVal
	 */
	public String getCntr13ChgVal() {
		return this.cntr13ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr25N2Amt
	 */
	public String getCntr25N2Amt() {
		return this.cntr25N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr6ChgVal
	 */
	public String getCntr6ChgVal() {
		return this.cntr6ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr22N1Amt
	 */
	public String getCntr22N1Amt() {
		return this.cntr22N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr30N1Amt
	 */
	public String getCntr30N1Amt() {
		return this.cntr30N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr26N1Amt
	 */
	public String getCntr26N1Amt() {
		return this.cntr26N1Amt;
	}

	/**
	 * Column Info
	 * @return cntr7ChgVal
	 */
	public String getCntr7ChgVal() {
		return this.cntr7ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr4N2Amt
	 */
	public String getCntr4N2Amt() {
		return this.cntr4N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr22ChgVal
	 */
	public String getCntr22ChgVal() {
		return this.cntr22ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr7N1Amt
	 */
	public String getCntr7N1Amt() {
		return this.cntr7N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr3N2Amt
	 */
	public String getCntr3N2Amt() {
		return this.cntr3N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr30ChgVal
	 */
	public String getCntr30ChgVal() {
		return this.cntr30ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr27ChgVal
	 */
	public String getCntr27ChgVal() {
		return this.cntr27ChgVal;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return cntr7N2Amt
	 */
	public String getCntr7N2Amt() {
		return this.cntr7N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr8N2Amt
	 */
	public String getCntr8N2Amt() {
		return this.cntr8N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr24N1Amt
	 */
	public String getCntr24N1Amt() {
		return this.cntr24N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr5ChgVal
	 */
	public String getCntr5ChgVal() {
		return this.cntr5ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr11ChgVal
	 */
	public String getCntr11ChgVal() {
		return this.cntr11ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr10N1Amt
	 */
	public String getCntr10N1Amt() {
		return this.cntr10N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr27N2Amt
	 */
	public String getCntr27N2Amt() {
		return this.cntr27N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr18ChgVal
	 */
	public String getCntr18ChgVal() {
		return this.cntr18ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr3N1Amt
	 */
	public String getCntr3N1Amt() {
		return this.cntr3N1Amt;
	}

	/**
	 * Column Info
	 * @return cntr5N1Amt
	 */
	public String getCntr5N1Amt() {
		return this.cntr5N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr30N2Amt
	 */
	public String getCntr30N2Amt() {
		return this.cntr30N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr28N2Amt
	 */
	public String getCntr28N2Amt() {
		return this.cntr28N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr19ChgVal
	 */
	public String getCntr19ChgVal() {
		return this.cntr19ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr9N1Amt
	 */
	public String getCntr9N1Amt() {
		return this.cntr9N1Amt;
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
	 * @return cntr1N1Amt
	 */
	public String getCntr1N1Amt() {
		return this.cntr1N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr17ChgVal
	 */
	public String getCntr17ChgVal() {
		return this.cntr17ChgVal;
	}
	
	/**
	 * Column Info
	 * @return agmtCtyCd
	 */
	public String getAgmtCtyCd() {
		return this.agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @return cntr9N2Amt
	 */
	public String getCntr9N2Amt() {
		return this.cntr9N2Amt;
	}

	/**
	 * Column Info
	 * @return cntr12N1Amt
	 */
	public String getCntr12N1Amt() {
		return this.cntr12N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr29N2Amt
	 */
	public String getCntr29N2Amt() {
		return this.cntr29N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr6N1Amt
	 */
	public String getCntr6N1Amt() {
		return this.cntr6N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr19N2Amt
	 */
	public String getCntr19N2Amt() {
		return this.cntr19N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr18N1Amt
	 */
	public String getCntr18N1Amt() {
		return this.cntr18N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr15N1Amt
	 */
	public String getCntr15N1Amt() {
		return this.cntr15N1Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr15N2Amt
	 */
	public String getCntr15N2Amt() {
		return this.cntr15N2Amt;
	}
	
	/**
	 * Column Info
	 * @return cntr21ChgVal
	 */
	public String getCntr21ChgVal() {
		return this.cntr21ChgVal;
	}
	
	/**
	 * Column Info
	 * @return cntr10N2Amt
	 */
	public String getCntr10N2Amt() {
		return this.cntr10N2Amt;
	}

	/**
	 * Column Info
	 * @return cntr29N1Amt
	 */
	public String getCntr29N1Amt() {
		return this.cntr29N1Amt;
	}

	/**
	 * Column Info
	 * @return cntrSpecNo
	 */
	public String getCntrSpecNo() {
		return cntrSpecNo;
	}

	/**
	 * Column Info
	 * @param cntr23N2Amt
	 */
	public void setCntr23N2Amt(String cntr23N2Amt) {
		this.cntr23N2Amt = cntr23N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr19N1Amt
	 */
	public void setCntr19N1Amt(String cntr19N1Amt) {
		this.cntr19N1Amt = cntr19N1Amt;
	}

	/**
	 * Column Info
	 * @param cntr28N1Amt
	 */
	public void setCntr28N1Amt(String cntr28N1Amt) {
		this.cntr28N1Amt = cntr28N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr22N2Amt
	 */
	public void setCntr22N2Amt(String cntr22N2Amt) {
		this.cntr22N2Amt = cntr22N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr21N2Amt
	 */
	public void setCntr21N2Amt(String cntr21N2Amt) {
		this.cntr21N2Amt = cntr21N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr2N2Amt
	 */
	public void setCntr2N2Amt(String cntr2N2Amt) {
		this.cntr2N2Amt = cntr2N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr5N2Amt
	 */
	public void setCntr5N2Amt(String cntr5N2Amt) {
		this.cntr5N2Amt = cntr5N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr1N2Amt
	 */
	public void setCntr1N2Amt(String cntr1N2Amt) {
		this.cntr1N2Amt = cntr1N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr20N2Amt
	 */
	public void setCntr20N2Amt(String cntr20N2Amt) {
		this.cntr20N2Amt = cntr20N2Amt;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param cntr14ChgVal
	 */
	public void setCntr14ChgVal(String cntr14ChgVal) {
		this.cntr14ChgVal = cntr14ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr25N1Amt
	 */
	public void setCntr25N1Amt(String cntr25N1Amt) {
		this.cntr25N1Amt = cntr25N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr14N2Amt
	 */
	public void setCntr14N2Amt(String cntr14N2Amt) {
		this.cntr14N2Amt = cntr14N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntr16N1Amt
	 */
	public void setCntr16N1Amt(String cntr16N1Amt) {
		this.cntr16N1Amt = cntr16N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr25ChgVal
	 */
	public void setCntr25ChgVal(String cntr25ChgVal) {
		this.cntr25ChgVal = cntr25ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr13N2Amt
	 */
	public void setCntr13N2Amt(String cntr13N2Amt) {
		this.cntr13N2Amt = cntr13N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr24N2Amt
	 */
	public void setCntr24N2Amt(String cntr24N2Amt) {
		this.cntr24N2Amt = cntr24N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr16N2Amt
	 */
	public void setCntr16N2Amt(String cntr16N2Amt) {
		this.cntr16N2Amt = cntr16N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr4ChgVal
	 */
	public void setCntr4ChgVal(String cntr4ChgVal) {
		this.cntr4ChgVal = cntr4ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr29ChgVal
	 */
	public void setCntr29ChgVal(String cntr29ChgVal) {
		this.cntr29ChgVal = cntr29ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr16ChgVal
	 */
	public void setCntr16ChgVal(String cntr16ChgVal) {
		this.cntr16ChgVal = cntr16ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr13N1Amt
	 */
	public void setCntr13N1Amt(String cntr13N1Amt) {
		this.cntr13N1Amt = cntr13N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr1ChgVal
	 */
	public void setCntr1ChgVal(String cntr1ChgVal) {
		this.cntr1ChgVal = cntr1ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr17N1Amt
	 */
	public void setCntr17N1Amt(String cntr17N1Amt) {
		this.cntr17N1Amt = cntr17N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr9ChgVal
	 */
	public void setCntr9ChgVal(String cntr9ChgVal) {
		this.cntr9ChgVal = cntr9ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr10ChgVal
	 */
	public void setCntr10ChgVal(String cntr10ChgVal) {
		this.cntr10ChgVal = cntr10ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr26ChgVal
	 */
	public void setCntr26ChgVal(String cntr26ChgVal) {
		this.cntr26ChgVal = cntr26ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr11N2Amt
	 */
	public void setCntr11N2Amt(String cntr11N2Amt) {
		this.cntr11N2Amt = cntr11N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr23ChgVal
	 */
	public void setCntr23ChgVal(String cntr23ChgVal) {
		this.cntr23ChgVal = cntr23ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr20N1Amt
	 */
	public void setCntr20N1Amt(String cntr20N1Amt) {
		this.cntr20N1Amt = cntr20N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr21N1Amt
	 */
	public void setCntr21N1Amt(String cntr21N1Amt) {
		this.cntr21N1Amt = cntr21N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr12N2Amt
	 */
	public void setCntr12N2Amt(String cntr12N2Amt) {
		this.cntr12N2Amt = cntr12N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr27N1Amt
	 */
	public void setCntr27N1Amt(String cntr27N1Amt) {
		this.cntr27N1Amt = cntr27N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr6N2Amt
	 */
	public void setCntr6N2Amt(String cntr6N2Amt) {
		this.cntr6N2Amt = cntr6N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr15ChgVal
	 */
	public void setCntr15ChgVal(String cntr15ChgVal) {
		this.cntr15ChgVal = cntr15ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntrRntlChgTpCd
	 */
	public void setCntrRntlChgTpCd(String cntrRntlChgTpCd) {
		this.cntrRntlChgTpCd = cntrRntlChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param cntr20ChgVal
	 */
	public void setCntr20ChgVal(String cntr20ChgVal) {
		this.cntr20ChgVal = cntr20ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr18N2Amt
	 */
	public void setCntr18N2Amt(String cntr18N2Amt) {
		this.cntr18N2Amt = cntr18N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr11N1Amt
	 */
	public void setCntr11N1Amt(String cntr11N1Amt) {
		this.cntr11N1Amt = cntr11N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr3ChgVal
	 */
	public void setCntr3ChgVal(String cntr3ChgVal) {
		this.cntr3ChgVal = cntr3ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr8ChgVal
	 */
	public void setCntr8ChgVal(String cntr8ChgVal) {
		this.cntr8ChgVal = cntr8ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr14N1Amt
	 */
	public void setCntr14N1Amt(String cntr14N1Amt) {
		this.cntr14N1Amt = cntr14N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr28ChgVal
	 */
	public void setCntr28ChgVal(String cntr28ChgVal) {
		this.cntr28ChgVal = cntr28ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr26N2Amt
	 */
	public void setCntr26N2Amt(String cntr26N2Amt) {
		this.cntr26N2Amt = cntr26N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr17N2Amt
	 */
	public void setCntr17N2Amt(String cntr17N2Amt) {
		this.cntr17N2Amt = cntr17N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr4N1Amt
	 */
	public void setCntr4N1Amt(String cntr4N1Amt) {
		this.cntr4N1Amt = cntr4N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr2N1Amt
	 */
	public void setCntr2N1Amt(String cntr2N1Amt) {
		this.cntr2N1Amt = cntr2N1Amt;
	}
	
	/**
	 * Column Info
	 * @param agmtChgVal
	 */
	public void setAgmtChgVal(String agmtChgVal) {
		this.agmtChgVal = agmtChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr12ChgVal
	 */
	public void setCntr12ChgVal(String cntr12ChgVal) {
		this.cntr12ChgVal = cntr12ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr23N1Amt
	 */
	public void setCntr23N1Amt(String cntr23N1Amt) {
		this.cntr23N1Amt = cntr23N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr24ChgVal
	 */
	public void setCntr24ChgVal(String cntr24ChgVal) {
		this.cntr24ChgVal = cntr24ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr2ChgVal
	 */
	public void setCntr2ChgVal(String cntr2ChgVal) {
		this.cntr2ChgVal = cntr2ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr8N1Amt
	 */
	public void setCntr8N1Amt(String cntr8N1Amt) {
		this.cntr8N1Amt = cntr8N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr13ChgVal
	 */
	public void setCntr13ChgVal(String cntr13ChgVal) {
		this.cntr13ChgVal = cntr13ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr25N2Amt
	 */
	public void setCntr25N2Amt(String cntr25N2Amt) {
		this.cntr25N2Amt = cntr25N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr6ChgVal
	 */
	public void setCntr6ChgVal(String cntr6ChgVal) {
		this.cntr6ChgVal = cntr6ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr22N1Amt
	 */
	public void setCntr22N1Amt(String cntr22N1Amt) {
		this.cntr22N1Amt = cntr22N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr30N1Amt
	 */
	public void setCntr30N1Amt(String cntr30N1Amt) {
		this.cntr30N1Amt = cntr30N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr26N1Amt
	 */
	public void setCntr26N1Amt(String cntr26N1Amt) {
		this.cntr26N1Amt = cntr26N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr7ChgVal
	 */
	public void setCntr7ChgVal(String cntr7ChgVal) {
		this.cntr7ChgVal = cntr7ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr4N2Amt
	 */
	public void setCntr4N2Amt(String cntr4N2Amt) {
		this.cntr4N2Amt = cntr4N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr22ChgVal
	 */
	public void setCntr22ChgVal(String cntr22ChgVal) {
		this.cntr22ChgVal = cntr22ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr7N1Amt
	 */
	public void setCntr7N1Amt(String cntr7N1Amt) {
		this.cntr7N1Amt = cntr7N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr3N2Amt
	 */
	public void setCntr3N2Amt(String cntr3N2Amt) {
		this.cntr3N2Amt = cntr3N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr30ChgVal
	 */
	public void setCntr30ChgVal(String cntr30ChgVal) {
		this.cntr30ChgVal = cntr30ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr27ChgVal
	 */
	public void setCntr27ChgVal(String cntr27ChgVal) {
		this.cntr27ChgVal = cntr27ChgVal;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param cntr7N2Amt
	 */
	public void setCntr7N2Amt(String cntr7N2Amt) {
		this.cntr7N2Amt = cntr7N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr8N2Amt
	 */
	public void setCntr8N2Amt(String cntr8N2Amt) {
		this.cntr8N2Amt = cntr8N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr24N1Amt
	 */
	public void setCntr24N1Amt(String cntr24N1Amt) {
		this.cntr24N1Amt = cntr24N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr5ChgVal
	 */
	public void setCntr5ChgVal(String cntr5ChgVal) {
		this.cntr5ChgVal = cntr5ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr11ChgVal
	 */
	public void setCntr11ChgVal(String cntr11ChgVal) {
		this.cntr11ChgVal = cntr11ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr10N1Amt
	 */
	public void setCntr10N1Amt(String cntr10N1Amt) {
		this.cntr10N1Amt = cntr10N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr27N2Amt
	 */
	public void setCntr27N2Amt(String cntr27N2Amt) {
		this.cntr27N2Amt = cntr27N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr18ChgVal
	 */
	public void setCntr18ChgVal(String cntr18ChgVal) {
		this.cntr18ChgVal = cntr18ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr3N1Amt
	 */
	public void setCntr3N1Amt(String cntr3N1Amt) {
		this.cntr3N1Amt = cntr3N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr5N1Amt
	 */
	public void setCntr5N1Amt(String cntr5N1Amt) {
		this.cntr5N1Amt = cntr5N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr30N2Amt
	 */
	public void setCntr30N2Amt(String cntr30N2Amt) {
		this.cntr30N2Amt = cntr30N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr28N2Amt
	 */
	public void setCntr28N2Amt(String cntr28N2Amt) {
		this.cntr28N2Amt = cntr28N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr19ChgVal
	 */
	public void setCntr19ChgVal(String cntr19ChgVal) {
		this.cntr19ChgVal = cntr19ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr9N1Amt
	 */
	public void setCntr9N1Amt(String cntr9N1Amt) {
		this.cntr9N1Amt = cntr9N1Amt;
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
	 * @param cntr1N1Amt
	 */
	public void setCntr1N1Amt(String cntr1N1Amt) {
		this.cntr1N1Amt = cntr1N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr17ChgVal
	 */
	public void setCntr17ChgVal(String cntr17ChgVal) {
		this.cntr17ChgVal = cntr17ChgVal;
	}
	
	/**
	 * Column Info
	 * @param agmtCtyCd
	 */
	public void setAgmtCtyCd(String agmtCtyCd) {
		this.agmtCtyCd = agmtCtyCd;
	}
	
	/**
	 * Column Info
	 * @param cntr9N2Amt
	 */
	public void setCntr9N2Amt(String cntr9N2Amt) {
		this.cntr9N2Amt = cntr9N2Amt;
	}

	/**
	 * Column Info
	 * @param cntr12N1Amt
	 */
	public void setCntr12N1Amt(String cntr12N1Amt) {
		this.cntr12N1Amt = cntr12N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr29N2Amt
	 */
	public void setCntr29N2Amt(String cntr29N2Amt) {
		this.cntr29N2Amt = cntr29N2Amt;
	}

	/**
	 * Column Info
	 * @param cntr6N1Amt
	 */
	public void setCntr6N1Amt(String cntr6N1Amt) {
		this.cntr6N1Amt = cntr6N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr19N2Amt
	 */
	public void setCntr19N2Amt(String cntr19N2Amt) {
		this.cntr19N2Amt = cntr19N2Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr18N1Amt
	 */
	public void setCntr18N1Amt(String cntr18N1Amt) {
		this.cntr18N1Amt = cntr18N1Amt;
	}

	/**
	 * Column Info
	 * @param cntr15N1Amt
	 */
	public void setCntr15N1Amt(String cntr15N1Amt) {
		this.cntr15N1Amt = cntr15N1Amt;
	}
	
	/**
	 * Column Info
	 * @param cntr15N2Amt
	 */
	public void setCntr15N2Amt(String cntr15N2Amt) {
		this.cntr15N2Amt = cntr15N2Amt;
	}

	/**
	 * Column Info
	 * @param cntr21ChgVal
	 */
	public void setCntr21ChgVal(String cntr21ChgVal) {
		this.cntr21ChgVal = cntr21ChgVal;
	}
	
	/**
	 * Column Info
	 * @param cntr10N2Amt
	 */
	public void setCntr10N2Amt(String cntr10N2Amt) {
		this.cntr10N2Amt = cntr10N2Amt;
	}

	/**
	 * Column Info
	 * @param cntr29N1Amt
	 */
	public void setCntr29N1Amt(String cntr29N1Amt) {
		this.cntr29N1Amt = cntr29N1Amt;
	}

	/**
	 * Column Info
	 * @param cntrSpecNo
	 */
	public void setCntrSpecNo(String cntrSpecNo) {
		this.cntrSpecNo = cntrSpecNo;
	}

	/**
	* Column Info
	* @param  eqLocTpCd
	*/
	public void	setEqLocTpCd( String	eqLocTpCd ) {
		this.eqLocTpCd =	eqLocTpCd;
	}
 
	/**
	 * Column Info
	 * @return	eqLocTpCd
	 */
	 public	 String	getEqLocTpCd() {
		 return	this.eqLocTpCd;
	 } 
	 
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCntr23N2Amt(JSPUtil.getParameter(request, "cntr23_n2_amt", ""));
		setCntr19N1Amt(JSPUtil.getParameter(request, "cntr19_n1_amt", ""));
		setCntr28N1Amt(JSPUtil.getParameter(request, "cntr28_n1_amt", ""));
		setCntr22N2Amt(JSPUtil.getParameter(request, "cntr22_n2_amt", ""));
		setCntr21N2Amt(JSPUtil.getParameter(request, "cntr21_n2_amt", ""));
		setCntr2N2Amt(JSPUtil.getParameter(request, "cntr2_n2_amt", ""));
		setCntr5N2Amt(JSPUtil.getParameter(request, "cntr5_n2_amt", ""));
		setCntr1N2Amt(JSPUtil.getParameter(request, "cntr1_n2_amt", ""));
		setCntr20N2Amt(JSPUtil.getParameter(request, "cntr20_n2_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setCntr14ChgVal(JSPUtil.getParameter(request, "cntr14_chg_val", ""));
		setCntr25N1Amt(JSPUtil.getParameter(request, "cntr25_n1_amt", ""));
		setCntr14N2Amt(JSPUtil.getParameter(request, "cntr14_n2_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntr16N1Amt(JSPUtil.getParameter(request, "cntr16_n1_amt", ""));
		setCntr25ChgVal(JSPUtil.getParameter(request, "cntr25_chg_val", ""));
		setCntr13N2Amt(JSPUtil.getParameter(request, "cntr13_n2_amt", ""));
		setCntr24N2Amt(JSPUtil.getParameter(request, "cntr24_n2_amt", ""));
		setCntr16N2Amt(JSPUtil.getParameter(request, "cntr16_n2_amt", ""));
		setCntr4ChgVal(JSPUtil.getParameter(request, "cntr4_chg_val", ""));
		setCntr29ChgVal(JSPUtil.getParameter(request, "cntr29_chg_val", ""));
		setCntr16ChgVal(JSPUtil.getParameter(request, "cntr16_chg_val", ""));
		setCntr13N1Amt(JSPUtil.getParameter(request, "cntr13_n1_amt", ""));
		setCntr1ChgVal(JSPUtil.getParameter(request, "cntr1_chg_val", ""));
		setCntr17N1Amt(JSPUtil.getParameter(request, "cntr17_n1_amt", ""));
		setCntr9ChgVal(JSPUtil.getParameter(request, "cntr9_chg_val", ""));
		setCntr10ChgVal(JSPUtil.getParameter(request, "cntr10_chg_val", ""));
		setCntr26ChgVal(JSPUtil.getParameter(request, "cntr26_chg_val", ""));
		setCntr11N2Amt(JSPUtil.getParameter(request, "cntr11_n2_amt", ""));
		setCntr23ChgVal(JSPUtil.getParameter(request, "cntr23_chg_val", ""));
		setCntr20N1Amt(JSPUtil.getParameter(request, "cntr20_n1_amt", ""));
		setCntr21N1Amt(JSPUtil.getParameter(request, "cntr21_n1_amt", ""));
		setCntr12N2Amt(JSPUtil.getParameter(request, "cntr12_n2_amt", ""));
		setCntr27N1Amt(JSPUtil.getParameter(request, "cntr27_n1_amt", ""));
		setCntr6N2Amt(JSPUtil.getParameter(request, "cntr6_n2_amt", ""));
		setCntr15ChgVal(JSPUtil.getParameter(request, "cntr15_chg_val", ""));
		setCntrRntlChgTpCd(JSPUtil.getParameter(request, "cntr_rntl_chg_tp_cd", ""));
		setCntr20ChgVal(JSPUtil.getParameter(request, "cntr20_chg_val", ""));
		setCntr18N2Amt(JSPUtil.getParameter(request, "cntr18_n2_amt", ""));
		setCntr11N1Amt(JSPUtil.getParameter(request, "cntr11_n1_amt", ""));
		setCntr3ChgVal(JSPUtil.getParameter(request, "cntr3_chg_val", ""));
		setCntr8ChgVal(JSPUtil.getParameter(request, "cntr8_chg_val", ""));
		setCntr14N1Amt(JSPUtil.getParameter(request, "cntr14_n1_amt", ""));
		setCntr28ChgVal(JSPUtil.getParameter(request, "cntr28_chg_val", ""));
		setCntr26N2Amt(JSPUtil.getParameter(request, "cntr26_n2_amt", ""));
		setCntr17N2Amt(JSPUtil.getParameter(request, "cntr17_n2_amt", ""));
		setCntr4N1Amt(JSPUtil.getParameter(request, "cntr4_n1_amt", ""));
		setCntr2N1Amt(JSPUtil.getParameter(request, "cntr2_n1_amt", ""));
		setAgmtChgVal(JSPUtil.getParameter(request, "agmt_chg_val", ""));
		setCntr12ChgVal(JSPUtil.getParameter(request, "cntr12_chg_val", ""));
		setCntr23N1Amt(JSPUtil.getParameter(request, "cntr23_n1_amt", ""));
		setCntr24ChgVal(JSPUtil.getParameter(request, "cntr24_chg_val", ""));
		setCntr2ChgVal(JSPUtil.getParameter(request, "cntr2_chg_val", ""));
		setCntr8N1Amt(JSPUtil.getParameter(request, "cntr8_n1_amt", ""));
		setCntr13ChgVal(JSPUtil.getParameter(request, "cntr13_chg_val", ""));
		setCntr25N2Amt(JSPUtil.getParameter(request, "cntr25_n2_amt", ""));
		setCntr6ChgVal(JSPUtil.getParameter(request, "cntr6_chg_val", ""));
		setCntr22N1Amt(JSPUtil.getParameter(request, "cntr22_n1_amt", ""));
		setCntr30N1Amt(JSPUtil.getParameter(request, "cntr30_n1_amt", ""));
		setCntr26N1Amt(JSPUtil.getParameter(request, "cntr26_n1_amt", ""));
		setCntr7ChgVal(JSPUtil.getParameter(request, "cntr7_chg_val", ""));
		setCntr4N2Amt(JSPUtil.getParameter(request, "cntr4_n2_amt", ""));
		setCntr22ChgVal(JSPUtil.getParameter(request, "cntr22_chg_val", ""));
		setCntr7N1Amt(JSPUtil.getParameter(request, "cntr7_n1_amt", ""));
		setCntr3N2Amt(JSPUtil.getParameter(request, "cntr3_n2_amt", ""));
		setCntr30ChgVal(JSPUtil.getParameter(request, "cntr30_chg_val", ""));
		setCntr27ChgVal(JSPUtil.getParameter(request, "cntr27_chg_val", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setCntr7N2Amt(JSPUtil.getParameter(request, "cntr7_n2_amt", ""));
		setCntr8N2Amt(JSPUtil.getParameter(request, "cntr8_n2_amt", ""));
		setCntr24N1Amt(JSPUtil.getParameter(request, "cntr24_n1_amt", ""));
		setCntr5ChgVal(JSPUtil.getParameter(request, "cntr5_chg_val", ""));
		setCntr11ChgVal(JSPUtil.getParameter(request, "cntr11_chg_val", ""));
		setCntr10N1Amt(JSPUtil.getParameter(request, "cntr10_n1_amt", ""));
		setCntr27N2Amt(JSPUtil.getParameter(request, "cntr27_n2_amt", ""));
		setCntr18ChgVal(JSPUtil.getParameter(request, "cntr18_chg_val", ""));
		setCntr3N1Amt(JSPUtil.getParameter(request, "cntr3_n1_amt", ""));
		setCntr5N1Amt(JSPUtil.getParameter(request, "cntr5_n1_amt", ""));
		setCntr30N2Amt(JSPUtil.getParameter(request, "cntr30_n2_amt", ""));
		setCntr28N2Amt(JSPUtil.getParameter(request, "cntr28_n2_amt", ""));
		setCntr19ChgVal(JSPUtil.getParameter(request, "cntr19_chg_val", ""));
		setCntr9N1Amt(JSPUtil.getParameter(request, "cntr9_n1_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntr1N1Amt(JSPUtil.getParameter(request, "cntr1_n1_amt", ""));
		setCntr17ChgVal(JSPUtil.getParameter(request, "cntr17_chg_val", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request, "agmt_cty_cd", ""));
		setCntr9N2Amt(JSPUtil.getParameter(request, "cntr9_n2_amt", ""));
		setCntr12N1Amt(JSPUtil.getParameter(request, "cntr12_n1_amt", ""));
		setCntr29N2Amt(JSPUtil.getParameter(request, "cntr29_n2_amt", ""));
		setCntr6N1Amt(JSPUtil.getParameter(request, "cntr6_n1_amt", ""));
		setCntr19N2Amt(JSPUtil.getParameter(request, "cntr19_n2_amt", ""));
		setCntr18N1Amt(JSPUtil.getParameter(request, "cntr18_n1_amt", ""));
		setCntr15N1Amt(JSPUtil.getParameter(request, "cntr15_n1_amt", ""));
		setCntr15N2Amt(JSPUtil.getParameter(request, "cntr15_n2_amt", ""));
		setCntr21ChgVal(JSPUtil.getParameter(request, "cntr21_chg_val", ""));
		setCntr10N2Amt(JSPUtil.getParameter(request, "cntr10_n2_amt", ""));
		setCntr29N1Amt(JSPUtil.getParameter(request, "cntr29_n1_amt", ""));
		setCntrSpecNo(JSPUtil.getParameter(request, "cntr_spec_no", ""));
		setEqLocTpCd(JSPUtil.getParameter(request,	 "eq_loc_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AgreementRatesVO[]
	 */
	public AgreementRatesVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AgreementRatesVO[]
	 */
	public AgreementRatesVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AgreementRatesVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntr23N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr23_n2_amt".trim(), length));
			String[] cntr19N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr19_n1_amt".trim(), length));
			String[] cntr28N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr28_n1_amt".trim(), length));
			String[] cntr22N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr22_n2_amt".trim(), length));
			String[] cntr21N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr21_n2_amt".trim(), length));
			String[] cntr2N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr2_n2_amt".trim(), length));
			String[] cntr5N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr5_n2_amt".trim(), length));
			String[] cntr1N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr1_n2_amt".trim(), length));
			String[] cntr20N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr20_n2_amt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] cntr14ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr14_chg_val".trim(), length));
			String[] cntr25N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr25_n1_amt".trim(), length));
			String[] cntr14N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr14_n2_amt".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] cntr16N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr16_n1_amt".trim(), length));
			String[] cntr25ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr25_chg_val".trim(), length));
			String[] cntr13N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr13_n2_amt".trim(), length));
			String[] cntr24N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr24_n2_amt".trim(), length));
			String[] cntr16N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr16_n2_amt".trim(), length));
			String[] cntr4ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr4_chg_val".trim(), length));
			String[] cntr29ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr29_chg_val".trim(), length));
			String[] cntr16ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr16_chg_val".trim(), length));
			String[] cntr13N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr13_n1_amt".trim(), length));
			String[] cntr1ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr1_chg_val".trim(), length));
			String[] cntr17N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr17_n1_amt".trim(), length));
			String[] cntr9ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr9_chg_val".trim(), length));
			String[] cntr10ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr10_chg_val".trim(), length));
			String[] cntr26ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr26_chg_val".trim(), length));
			String[] cntr11N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr11_n2_amt".trim(), length));
			String[] cntr23ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr23_chg_val".trim(), length));
			String[] cntr20N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr20_n1_amt".trim(), length));
			String[] cntr21N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr21_n1_amt".trim(), length));
			String[] cntr12N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr12_n2_amt".trim(), length));
			String[] cntr27N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr27_n1_amt".trim(), length));
			String[] cntr6N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr6_n2_amt".trim(), length));
			String[] cntr15ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr15_chg_val".trim(), length));
			String[] cntrRntlChgTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_rntl_chg_tp_cd".trim(), length));
			String[] cntr20ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr20_chg_val".trim(), length));
			String[] cntr18N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr18_n2_amt".trim(), length));
			String[] cntr11N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr11_n1_amt".trim(), length));
			String[] cntr3ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr3_chg_val".trim(), length));
			String[] cntr8ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr8_chg_val".trim(), length));
			String[] cntr14N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr14_n1_amt".trim(), length));
			String[] cntr28ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr28_chg_val".trim(), length));
			String[] cntr26N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr26_n2_amt".trim(), length));
			String[] cntr17N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr17_n2_amt".trim(), length));
			String[] cntr4N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr4_n1_amt".trim(), length));
			String[] cntr2N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr2_n1_amt".trim(), length));
			String[] agmtChgVal = (JSPUtil.getParameter(request, prefix	+ "agmt_chg_val".trim(), length));
			String[] cntr12ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr12_chg_val".trim(), length));
			String[] cntr23N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr23_n1_amt".trim(), length));
			String[] cntr24ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr24_chg_val".trim(), length));
			String[] cntr2ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr2_chg_val".trim(), length));
			String[] cntr8N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr8_n1_amt".trim(), length));
			String[] cntr13ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr13_chg_val".trim(), length));
			String[] cntr25N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr25_n2_amt".trim(), length));
			String[] cntr6ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr6_chg_val".trim(), length));
			String[] cntr22N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr22_n1_amt".trim(), length));
			String[] cntr30N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr30_n1_amt".trim(), length));
			String[] cntr26N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr26_n1_amt".trim(), length));
			String[] cntr7ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr7_chg_val".trim(), length));
			String[] cntr4N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr4_n2_amt".trim(), length));
			String[] cntr22ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr22_chg_val".trim(), length));
			String[] cntr7N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr7_n1_amt".trim(), length));
			String[] cntr3N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr3_n2_amt".trim(), length));
			String[] cntr30ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr30_chg_val".trim(), length));
			String[] cntr27ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr27_chg_val".trim(), length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq".trim(), length));
			String[] cntr7N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr7_n2_amt".trim(), length));
			String[] cntr8N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr8_n2_amt".trim(), length));
			String[] cntr24N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr24_n1_amt".trim(), length));
			String[] cntr5ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr5_chg_val".trim(), length));
			String[] cntr11ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr11_chg_val".trim(), length));
			String[] cntr10N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr10_n1_amt".trim(), length));
			String[] cntr27N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr27_n2_amt".trim(), length));
			String[] cntr18ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr18_chg_val".trim(), length));
			String[] cntr3N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr3_n1_amt".trim(), length));
			String[] cntr5N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr5_n1_amt".trim(), length));
			String[] cntr30N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr30_n2_amt".trim(), length));
			String[] cntr28N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr28_n2_amt".trim(), length));
			String[] cntr19ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr19_chg_val".trim(), length));
			String[] cntr9N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr9_n1_amt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cntr1N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr1_n1_amt".trim(), length));
			String[] cntr17ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr17_chg_val".trim(), length));
			String[] agmtCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_cty_cd".trim(), length));
			String[] cntr9N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr9_n2_amt".trim(), length));
			String[] cntr12N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr12_n1_amt".trim(), length));
			String[] cntr29N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr29_n2_amt".trim(), length));
			String[] cntr6N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr6_n1_amt".trim(), length));
			String[] cntr19N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr19_n2_amt".trim(), length));
			String[] cntr18N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr18_n1_amt".trim(), length));
			String[] cntr15N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr15_n1_amt".trim(), length));
			String[] cntr15N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr15_n2_amt".trim(), length));
			String[] cntr21ChgVal = (JSPUtil.getParameter(request, prefix	+ "cntr21_chg_val".trim(), length));
			String[] cntr10N2Amt = (JSPUtil.getParameter(request, prefix	+ "cntr10_n2_amt".trim(), length));
			String[] cntr29N1Amt = (JSPUtil.getParameter(request, prefix	+ "cntr29_n1_amt".trim(), length));
			String[] cntrSpecNo = (JSPUtil.getParameter(request, prefix	+ "cntr_spec_no".trim(), length));
			String[] eqLocTpCd =	(JSPUtil.getParameter(request, prefix +	"eq_loc_tp_cd".trim(),	length));
			
			for (int i = 0; i < length; i++) {
				model = new AgreementRatesVO();
				if (cntr23N2Amt[i] != null)
					model.setCntr23N2Amt(cntr23N2Amt[i]);
				if (cntr19N1Amt[i] != null)
					model.setCntr19N1Amt(cntr19N1Amt[i]);
				if (cntr28N1Amt[i] != null)
					model.setCntr28N1Amt(cntr28N1Amt[i]);
				if (cntr22N2Amt[i] != null)
					model.setCntr22N2Amt(cntr22N2Amt[i]);
				if (cntr21N2Amt[i] != null)
					model.setCntr21N2Amt(cntr21N2Amt[i]);
				if (cntr2N2Amt[i] != null)
					model.setCntr2N2Amt(cntr2N2Amt[i]);
				if (cntr5N2Amt[i] != null)
					model.setCntr5N2Amt(cntr5N2Amt[i]);
				if (cntr1N2Amt[i] != null)
					model.setCntr1N2Amt(cntr1N2Amt[i]);
				if (cntr20N2Amt[i] != null)
					model.setCntr20N2Amt(cntr20N2Amt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (cntr14ChgVal[i] != null)
					model.setCntr14ChgVal(cntr14ChgVal[i]);
				if (cntr25N1Amt[i] != null)
					model.setCntr25N1Amt(cntr25N1Amt[i]);
				if (cntr14N2Amt[i] != null)
					model.setCntr14N2Amt(cntr14N2Amt[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntr16N1Amt[i] != null)
					model.setCntr16N1Amt(cntr16N1Amt[i]);
				if (cntr25ChgVal[i] != null)
					model.setCntr25ChgVal(cntr25ChgVal[i]);
				if (cntr13N2Amt[i] != null)
					model.setCntr13N2Amt(cntr13N2Amt[i]);
				if (cntr24N2Amt[i] != null)
					model.setCntr24N2Amt(cntr24N2Amt[i]);
				if (cntr16N2Amt[i] != null)
					model.setCntr16N2Amt(cntr16N2Amt[i]);
				if (cntr4ChgVal[i] != null)
					model.setCntr4ChgVal(cntr4ChgVal[i]);
				if (cntr29ChgVal[i] != null)
					model.setCntr29ChgVal(cntr29ChgVal[i]);
				if (cntr16ChgVal[i] != null)
					model.setCntr16ChgVal(cntr16ChgVal[i]);
				if (cntr13N1Amt[i] != null)
					model.setCntr13N1Amt(cntr13N1Amt[i]);
				if (cntr1ChgVal[i] != null)
					model.setCntr1ChgVal(cntr1ChgVal[i]);
				if (cntr17N1Amt[i] != null)
					model.setCntr17N1Amt(cntr17N1Amt[i]);
				if (cntr9ChgVal[i] != null)
					model.setCntr9ChgVal(cntr9ChgVal[i]);
				if (cntr10ChgVal[i] != null)
					model.setCntr10ChgVal(cntr10ChgVal[i]);
				if (cntr26ChgVal[i] != null)
					model.setCntr26ChgVal(cntr26ChgVal[i]);
				if (cntr11N2Amt[i] != null)
					model.setCntr11N2Amt(cntr11N2Amt[i]);
				if (cntr23ChgVal[i] != null)
					model.setCntr23ChgVal(cntr23ChgVal[i]);
				if (cntr20N1Amt[i] != null)
					model.setCntr20N1Amt(cntr20N1Amt[i]);
				if (cntr21N1Amt[i] != null)
					model.setCntr21N1Amt(cntr21N1Amt[i]);
				if (cntr12N2Amt[i] != null)
					model.setCntr12N2Amt(cntr12N2Amt[i]);
				if (cntr27N1Amt[i] != null)
					model.setCntr27N1Amt(cntr27N1Amt[i]);
				if (cntr6N2Amt[i] != null)
					model.setCntr6N2Amt(cntr6N2Amt[i]);
				if (cntr15ChgVal[i] != null)
					model.setCntr15ChgVal(cntr15ChgVal[i]);
				if (cntrRntlChgTpCd[i] != null)
					model.setCntrRntlChgTpCd(cntrRntlChgTpCd[i]);
				if (cntr20ChgVal[i] != null)
					model.setCntr20ChgVal(cntr20ChgVal[i]);
				if (cntr18N2Amt[i] != null)
					model.setCntr18N2Amt(cntr18N2Amt[i]);
				if (cntr11N1Amt[i] != null)
					model.setCntr11N1Amt(cntr11N1Amt[i]);
				if (cntr3ChgVal[i] != null)
					model.setCntr3ChgVal(cntr3ChgVal[i]);
				if (cntr8ChgVal[i] != null)
					model.setCntr8ChgVal(cntr8ChgVal[i]);
				if (cntr14N1Amt[i] != null)
					model.setCntr14N1Amt(cntr14N1Amt[i]);
				if (cntr28ChgVal[i] != null)
					model.setCntr28ChgVal(cntr28ChgVal[i]);
				if (cntr26N2Amt[i] != null)
					model.setCntr26N2Amt(cntr26N2Amt[i]);
				if (cntr17N2Amt[i] != null)
					model.setCntr17N2Amt(cntr17N2Amt[i]);
				if (cntr4N1Amt[i] != null)
					model.setCntr4N1Amt(cntr4N1Amt[i]);
				if (cntr2N1Amt[i] != null)
					model.setCntr2N1Amt(cntr2N1Amt[i]);
				if (agmtChgVal[i] != null)
					model.setAgmtChgVal(agmtChgVal[i]);
				if (cntr12ChgVal[i] != null)
					model.setCntr12ChgVal(cntr12ChgVal[i]);
				if (cntr23N1Amt[i] != null)
					model.setCntr23N1Amt(cntr23N1Amt[i]);
				if (cntr24ChgVal[i] != null)
					model.setCntr24ChgVal(cntr24ChgVal[i]);
				if (cntr2ChgVal[i] != null)
					model.setCntr2ChgVal(cntr2ChgVal[i]);
				if (cntr8N1Amt[i] != null)
					model.setCntr8N1Amt(cntr8N1Amt[i]);
				if (cntr13ChgVal[i] != null)
					model.setCntr13ChgVal(cntr13ChgVal[i]);
				if (cntr25N2Amt[i] != null)
					model.setCntr25N2Amt(cntr25N2Amt[i]);
				if (cntr6ChgVal[i] != null)
					model.setCntr6ChgVal(cntr6ChgVal[i]);
				if (cntr22N1Amt[i] != null)
					model.setCntr22N1Amt(cntr22N1Amt[i]);
				if (cntr30N1Amt[i] != null)
					model.setCntr30N1Amt(cntr30N1Amt[i]);
				if (cntr26N1Amt[i] != null)
					model.setCntr26N1Amt(cntr26N1Amt[i]);
				if (cntr7ChgVal[i] != null)
					model.setCntr7ChgVal(cntr7ChgVal[i]);
				if (cntr4N2Amt[i] != null)
					model.setCntr4N2Amt(cntr4N2Amt[i]);
				if (cntr22ChgVal[i] != null)
					model.setCntr22ChgVal(cntr22ChgVal[i]);
				if (cntr7N1Amt[i] != null)
					model.setCntr7N1Amt(cntr7N1Amt[i]);
				if (cntr3N2Amt[i] != null)
					model.setCntr3N2Amt(cntr3N2Amt[i]);
				if (cntr30ChgVal[i] != null)
					model.setCntr30ChgVal(cntr30ChgVal[i]);
				if (cntr27ChgVal[i] != null)
					model.setCntr27ChgVal(cntr27ChgVal[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (cntr7N2Amt[i] != null)
					model.setCntr7N2Amt(cntr7N2Amt[i]);
				if (cntr8N2Amt[i] != null)
					model.setCntr8N2Amt(cntr8N2Amt[i]);
				if (cntr24N1Amt[i] != null)
					model.setCntr24N1Amt(cntr24N1Amt[i]);
				if (cntr5ChgVal[i] != null)
					model.setCntr5ChgVal(cntr5ChgVal[i]);
				if (cntr11ChgVal[i] != null)
					model.setCntr11ChgVal(cntr11ChgVal[i]);
				if (cntr10N1Amt[i] != null)
					model.setCntr10N1Amt(cntr10N1Amt[i]);
				if (cntr27N2Amt[i] != null)
					model.setCntr27N2Amt(cntr27N2Amt[i]);
				if (cntr18ChgVal[i] != null)
					model.setCntr18ChgVal(cntr18ChgVal[i]);
				if (cntr3N1Amt[i] != null)
					model.setCntr3N1Amt(cntr3N1Amt[i]);
				if (cntr5N1Amt[i] != null)
					model.setCntr5N1Amt(cntr5N1Amt[i]);
				if (cntr30N2Amt[i] != null)
					model.setCntr30N2Amt(cntr30N2Amt[i]);
				if (cntr28N2Amt[i] != null)
					model.setCntr28N2Amt(cntr28N2Amt[i]);
				if (cntr19ChgVal[i] != null)
					model.setCntr19ChgVal(cntr19ChgVal[i]);
				if (cntr9N1Amt[i] != null)
					model.setCntr9N1Amt(cntr9N1Amt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntr1N1Amt[i] != null)
					model.setCntr1N1Amt(cntr1N1Amt[i]);
				if (cntr17ChgVal[i] != null)
					model.setCntr17ChgVal(cntr17ChgVal[i]);
				if (agmtCtyCd[i] != null)
					model.setAgmtCtyCd(agmtCtyCd[i]);
				if (cntr9N2Amt[i] != null)
					model.setCntr9N2Amt(cntr9N2Amt[i]);
				if (cntr12N1Amt[i] != null)
					model.setCntr12N1Amt(cntr12N1Amt[i]);
				if (cntr29N2Amt[i] != null)
					model.setCntr29N2Amt(cntr29N2Amt[i]);
				if (cntr6N1Amt[i] != null)
					model.setCntr6N1Amt(cntr6N1Amt[i]);
				if (cntr19N2Amt[i] != null)
					model.setCntr19N2Amt(cntr19N2Amt[i]);
				if (cntr18N1Amt[i] != null)
					model.setCntr18N1Amt(cntr18N1Amt[i]);
				if (cntr15N1Amt[i] != null)
					model.setCntr15N1Amt(cntr15N1Amt[i]);
				if (cntr15N2Amt[i] != null)
					model.setCntr15N2Amt(cntr15N2Amt[i]);
				if (cntr21ChgVal[i] != null)
					model.setCntr21ChgVal(cntr21ChgVal[i]);
				if (cntr10N2Amt[i] != null)
					model.setCntr10N2Amt(cntr10N2Amt[i]);
				if (cntr29N1Amt[i] != null)
					model.setCntr29N1Amt(cntr29N1Amt[i]);
				if (cntrSpecNo[i] != null)
					model.setCntrSpecNo(cntrSpecNo[i]);
				if ( eqLocTpCd[i] !=	null)
					model.setEqLocTpCd( eqLocTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAgreementRatesVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AgreementRatesVO[]
	 */
	public AgreementRatesVO[] getAgreementRatesVOs(){
		AgreementRatesVO[] vos = (AgreementRatesVO[])models.toArray(new AgreementRatesVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.cntr23N2Amt = this.cntr23N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr19N1Amt = this.cntr19N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr28N1Amt = this.cntr28N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr22N2Amt = this.cntr22N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr21N2Amt = this.cntr21N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr2N2Amt = this.cntr2N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr5N2Amt = this.cntr5N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr1N2Amt = this.cntr1N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20N2Amt = this.cntr20N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr14ChgVal = this.cntr14ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr25N1Amt = this.cntr25N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr14N2Amt = this.cntr14N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr16N1Amt = this.cntr16N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr25ChgVal = this.cntr25ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr13N2Amt = this.cntr13N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr24N2Amt = this.cntr24N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr16N2Amt = this.cntr16N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr4ChgVal = this.cntr4ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr29ChgVal = this.cntr29ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr16ChgVal = this.cntr16ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr13N1Amt = this.cntr13N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr1ChgVal = this.cntr1ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr17N1Amt = this.cntr17N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr9ChgVal = this.cntr9ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr10ChgVal = this.cntr10ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr26ChgVal = this.cntr26ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr11N2Amt = this.cntr11N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr23ChgVal = this.cntr23ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20N1Amt = this.cntr20N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr21N1Amt = this.cntr21N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr12N2Amt = this.cntr12N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr27N1Amt = this.cntr27N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr6N2Amt = this.cntr6N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr15ChgVal = this.cntr15ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRntlChgTpCd = this.cntrRntlChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20ChgVal = this.cntr20ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr18N2Amt = this.cntr18N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr11N1Amt = this.cntr11N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr3ChgVal = this.cntr3ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr8ChgVal = this.cntr8ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr14N1Amt = this.cntr14N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr28ChgVal = this.cntr28ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr26N2Amt = this.cntr26N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr17N2Amt = this.cntr17N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr4N1Amt = this.cntr4N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr2N1Amt = this.cntr2N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtChgVal = this.agmtChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr12ChgVal = this.cntr12ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr23N1Amt = this.cntr23N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr24ChgVal = this.cntr24ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr2ChgVal = this.cntr2ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr8N1Amt = this.cntr8N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr13ChgVal = this.cntr13ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr25N2Amt = this.cntr25N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr6ChgVal = this.cntr6ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr22N1Amt = this.cntr22N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr30N1Amt = this.cntr30N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr26N1Amt = this.cntr26N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr7ChgVal = this.cntr7ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr4N2Amt = this.cntr4N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr22ChgVal = this.cntr22ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr7N1Amt = this.cntr7N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr3N2Amt = this.cntr3N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr30ChgVal = this.cntr30ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr27ChgVal = this.cntr27ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr7N2Amt = this.cntr7N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr8N2Amt = this.cntr8N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr24N1Amt = this.cntr24N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr5ChgVal = this.cntr5ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr11ChgVal = this.cntr11ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr10N1Amt = this.cntr10N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr27N2Amt = this.cntr27N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr18ChgVal = this.cntr18ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr3N1Amt = this.cntr3N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr5N1Amt = this.cntr5N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr30N2Amt = this.cntr30N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr28N2Amt = this.cntr28N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr19ChgVal = this.cntr19ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr9N1Amt = this.cntr9N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr1N1Amt = this.cntr1N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr17ChgVal = this.cntr17ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd = this.agmtCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr9N2Amt = this.cntr9N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr12N1Amt = this.cntr12N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr29N2Amt = this.cntr29N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr6N1Amt = this.cntr6N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr19N2Amt = this.cntr19N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr18N1Amt = this.cntr18N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr15N1Amt = this.cntr15N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr15N2Amt = this.cntr15N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr21ChgVal = this.cntr21ChgVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr10N2Amt = this.cntr10N2Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr29N1Amt = this.cntr29N1Amt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSpecNo = this.cntrSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocTpCd =	this.eqLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}