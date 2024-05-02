/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialSOCheckDBDAOsearchSpecialSOCheckListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.01.21 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialSOCheckDBDAOsearchSpecialSOCheckListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Special S/O of Transport에서 Supplement S/O sheet조회
	  * </pre>
	  */
	public SpecialSOCheckDBDAOsearchSpecialSOCheckListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_so_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_so_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : SpecialSOCheckDBDAOsearchSpecialSOCheckListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT      	X.EQ_NO" ).append("\n"); 
		query.append(",	DECODE(X.EQ_TPSZ_CD           , NULL, '  ', EQ_TPSZ_CD             ) EQ_TPSZ_CD" ).append("\n"); 
		query.append(",	DECODE(X.TRSP_BND_CD          , 'I', 'In','O','Out','T','T/S','',' ', TRSP_BND_CD ) IO_BOUND" ).append("\n"); 
		query.append(",	DECODE(X.BKG_TERM      		  , NULL, '  ', BKG_TERM               ) BKG_TERM" ).append("\n"); 
		query.append(",	DECODE(X.TRSP_COST_DTL_MOD_CD , NULL, '  ', TRSP_COST_DTL_MOD_CD   ) TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append(",	DECODE(X.TRSP_CRR_MOD_CD      , NULL, '  ', TRSP_CRR_MOD_CD        ) TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(",	DECODE(X.FM_LOC            	  , NULL, '  ', FM_LOC                 ) FM_LOC" ).append("\n"); 
		query.append(",	DECODE(X.FM_YARD			  , NULL, '  ', FM_YARD                ) FM_YARD" ).append("\n"); 
		query.append(",	DECODE(X.VIA_LOC              , NULL, '  ', VIA_LOC		           ) VIA_LOC" ).append("\n"); 
		query.append(",	DECODE(X.VIA_YARD       	  , NULL, '  ', VIA_YARD     		   ) VIA_YARD" ).append("\n"); 
		query.append(",	DECODE(X.TO_LOC            	  , NULL, '  ', TO_LOC                 ) TO_LOC" ).append("\n"); 
		query.append(",	DECODE(X.TO_YARD        	  , NULL, '  ', TO_YARD                ) TO_YARD" ).append("\n"); 
		query.append(",	DECODE(X.DOR_LOC           	  , NULL, '  ', DOR_LOC                ) DOR_LOC" ).append("\n"); 
		query.append(",	DECODE(X.DOR_ZONE       	  , NULL, '  ', DOR_ZONE               ) DOR_ZONE" ).append("\n"); 
		query.append(",	DECODE(X.CUST_VAL             , NULL, '  ', CUST_VAL               ) CUST_VAL" ).append("\n"); 
		query.append(",	DECODE(X.DOR_DE_ADDR          , NULL, '  ', DOR_DE_ADDR            ) DOR_DE_ADDR" ).append("\n"); 
		query.append(",	DECODE(X.VNDR_SEQ             , NULL, '  ', VNDR_SEQ               ) VNDR_SEQ" ).append("\n"); 
		query.append(",	DECODE(X.VNDR_SEQ             , NULL, '  ', TRS_COMMON_PKG.GET_VNDR_FULL_NM_FNC(VNDR_SEQ)) VNDR_NM" ).append("\n"); 
		query.append(",	DECODE(X.BKG_SQ               , NULL, '  ', BKG_SQ                 ) BKG_SQ" ).append("\n"); 
		query.append(",	DECODE(X.BL_NO                , NULL, '  ', BL_NO                  ) BL_NO" ).append("\n"); 
		query.append(",	DECODE(X.TRUCK_VVD            , NULL, '  ', TRUCK_VVD              ) TRUCK_VVD" ).append("\n"); 
		query.append(",	DECODE(X.SO_NUMBER            , NULL, '  ', SO_NUMBER              ) SO_NUMBER" ).append("\n"); 
		query.append(",	DECODE(X.WO_NUMBER            , NULL, '  ', WO_NUMBER              ) WO_NUMBER" ).append("\n"); 
		query.append(",	DECODE(X.CRE_DT               , NULL, '  ', TO_CHAR(CRE_DT,'YYYY-MM-DD HH24:MI')                 ) 	CRE_DT" ).append("\n"); 
		query.append(",	DECODE(X.INV_NO               , NULL, '  ', INV_NO                 ) INV_NO" ).append("\n"); 
		query.append(",	DECODE(X.INV_CFM_DT           , NULL, '  ', TO_CHAR(INV_CFM_DT,'YYYY-MM-DD HH24:MI')             ) 	INV_CFM_DT" ).append("\n"); 
		query.append(",	DECODE(X.SPL_ISS_RSN          , NULL, '  ', SPL_ISS_RSN            ) SPL_ISS_RSN" ).append("\n"); 
		query.append(", 	DECODE(Z.BASIS_NO2,1,'WorkOrder',2,'Invoiced',3,'Adjusted')          AMOUNT_KIND" ).append("\n"); 
		query.append(",	NVL(X.TRSP_DFLT_VNDR_FLG,'N') TRSP_DFLT_VNDR_FLG" ).append("\n"); 
		query.append(",	DECODE(X.CUST_NOMI_TRKR_FLG,'Y','CNT', 'HJS') SP_TYPE" ).append("\n"); 
		query.append(",	DECODE(BASIS_NO2, 1, X.TRSP_AGMT_RT_TP_CD , 2, X.TRSP_AGMT_RT_TP_CD) AGMT_RATE_TYPE_NM" ).append("\n"); 
		query.append(",	DECODE(BASIS_NO2, 1, X.TRSP_AGMT_WY_TP_CD , 2, X.TRSP_AGMT_WY_TP_CD) WAY_TYPE" ).append("\n"); 
		query.append(",	DECODE(BASIS_NO2, 1, X.WO_CURR_CD        	  , 2, X.INV_CURR_CD	, 3, X.SO_CURR_CD           		) CURR_CD" ).append("\n"); 
		query.append(",	NVL(DECODE(BASIS_NO2, 1, X.WO_BZC_AMT         , 2, X.INV_BZC_AMT    , 3, X.SO_BZC_AMT                ),0) BZC_AMT" ).append("\n"); 
		query.append(",	NVL(DECODE(BASIS_NO2, 1, X.WO_NEGO_AMT        , 2, 0 , 3, X.SO_NEGO_AMT   	  	 	 ),0) NEGO_AMT" ).append("\n"); 
		query.append(",	NVL(DECODE(BASIS_NO2, 1, X.WO_FUEL_SCG_AMT    , 2, 0 , 3, X.SO_FUEL_SCG_AMT   	 ),0) FUEL_SCG_AMT" ).append("\n"); 
		query.append(",  (NVL(DECODE(BASIS_NO2, 1, X.WO_OVR_WGT_SCG_AMT , 2, 0 , 3, X.SO_OVR_WGT_SCG_AMT   ),0) + NVL(DECODE(BASIS_NO2, 1, X.WO_ETC_ADD_AMT, 2, X.INV_ETC_ADD_AMT, 3, X.SO_ETC_ADD_AMT),0)) ETC_ADD_AMT" ).append("\n"); 
		query.append(",	NVL(DECODE(BASIS_NO2, 1, X.WO_TOT_AMT         , 2, X.TOT_INV_AMT      , 3, X.SO_TOT_AMT     ),0) TOT_AMT" ).append("\n"); 
		query.append(",	X.BASIS_NO" ).append("\n"); 
		query.append(", 	Z.BASIS_NO2" ).append("\n"); 
		query.append("FROM 		(" ).append("\n"); 
		query.append("SELECT    	ROWNUM BASIS_NO" ).append("\n"); 
		query.append(", 	A.TRSP_SO_CMB_TP_CD" ).append("\n"); 
		query.append(", 	TO_CHAR(A.TRSP_SO_CMB_SEQ) TRSP_SO_CMB_SEQ" ).append("\n"); 
		query.append(", 	A.TRSP_SO_CMB_SRT_NO" ).append("\n"); 
		query.append(",	A.EQ_NO" ).append("\n"); 
		query.append(",	A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",	A.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append(",	A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(",	A.FM_NOD_CD" ).append("\n"); 
		query.append(",	A.VIA_NOD_CD" ).append("\n"); 
		query.append(",	A.TO_NOD_CD" ).append("\n"); 
		query.append(",	A.DOR_NOD_CD" ).append("\n"); 
		query.append(",	SUBSTR(A.FM_NOD_CD , 1, 5) FM_LOC" ).append("\n"); 
		query.append(",	SUBSTR(A.FM_NOD_CD , 6, 2) FM_YARD" ).append("\n"); 
		query.append(",	SUBSTR(A.VIA_NOD_CD, 1, 5) VIA_LOC" ).append("\n"); 
		query.append(",	SUBSTR(A.VIA_NOD_CD, 6, 2) VIA_YARD" ).append("\n"); 
		query.append(",	SUBSTR(A.TO_NOD_CD , 1, 5) TO_LOC" ).append("\n"); 
		query.append(",	SUBSTR(A.TO_NOD_CD , 6, 2) TO_YARD" ).append("\n"); 
		query.append(",	SUBSTR(A.DOR_NOD_CD, 1, 5) DOR_LOC" ).append("\n"); 
		query.append(",	SUBSTR(A.DOR_NOD_CD, 6, 2) DOR_ZONE" ).append("\n"); 
		query.append(",	A.CUST_CNT_CD||A.CUST_SEQ  CUST_VAL" ).append("\n"); 
		query.append(",	A.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append(",	A.CUST_CNT_CD" ).append("\n"); 
		query.append(",	A.CUST_SEQ" ).append("\n"); 
		query.append(",	A.DOR_DE_ADDR" ).append("\n"); 
		query.append(",	A.VNDR_SEQ" ).append("\n"); 
		query.append(",	A.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append(",	A.TRSP_AGMT_WY_TP_CD" ).append("\n"); 
		query.append(",	AA.CURR_CD                WO_CURR_CD" ).append("\n"); 
		query.append(",	AA.BZC_AMT                WO_BZC_AMT" ).append("\n"); 
		query.append(",	AA.FUEL_SCG_AMT           WO_FUEL_SCG_AMT" ).append("\n"); 
		query.append(",	AA.OVR_WGT_SCG_AMT        WO_OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append(",	AA.ETC_ADD_AMT            WO_ETC_ADD_AMT" ).append("\n"); 
		query.append(",	AA.NEGO_AMT               WO_NEGO_AMT" ).append("\n"); 
		query.append(",	NVL(AA.BZC_AMT,0)+NVL(AA.FUEL_SCG_AMT,0)+NVL(AA.OVR_WGT_SCG_AMT,0)+NVL(AA.ETC_ADD_AMT,0)+NVL(AA.NEGO_AMT,0) WO_TOT_AMT" ).append("\n"); 
		query.append(", 	AA.INV_CURR_CD" ).append("\n"); 
		query.append(", 	AA.INV_BZC_AMT" ).append("\n"); 
		query.append(", 	AA.INV_ETC_ADD_AMT" ).append("\n"); 
		query.append(", 	NVL(AA.INV_BZC_AMT,0)+NVL(AA.INV_ETC_ADD_AMT,0) TOT_INV_AMT" ).append("\n"); 
		query.append(",	A.CURR_CD                SO_CURR_CD" ).append("\n"); 
		query.append(",	A.BZC_AMT                SO_BZC_AMT" ).append("\n"); 
		query.append(",	A.FUEL_SCG_AMT           SO_FUEL_SCG_AMT" ).append("\n"); 
		query.append(",	A.OVR_WGT_SCG_AMT        SO_OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append(",	A.ETC_ADD_AMT            SO_ETC_ADD_AMT" ).append("\n"); 
		query.append(",	A.NEGO_AMT               SO_NEGO_AMT" ).append("\n"); 
		query.append(",	NVL(A.BZC_AMT,0)+NVL(A.FUEL_SCG_AMT,0)+NVL(A.OVR_WGT_SCG_AMT,0)+NVL(A.ETC_ADD_AMT,0)+NVL(A.NEGO_AMT,0) SO_TOT_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	A.BKG_NO  BKG_SQ" ).append("\n"); 
		query.append(",	A.BL_NO" ).append("\n"); 
		query.append(",	AA.VSL_CD||AA.SKD_VOY_NO||AA.SKD_DIR_CD   TRUCK_VVD" ).append("\n"); 
		query.append(",	A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ    SO_NUMBER" ).append("\n"); 
		query.append(",	AA.TRSP_WO_OFC_CTY_CD||AA.TRSP_WO_SEQ    WO_NUMBER" ).append("\n"); 
		query.append(",	B.CRE_DT" ).append("\n"); 
		query.append(",	AA.INV_NO" ).append("\n"); 
		query.append(",	C.INV_CFM_DT" ).append("\n"); 
		query.append(",	A.SPL_ISS_RSN" ).append("\n"); 
		query.append(",	A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",	A.TRSP_SO_SEQ" ).append("\n"); 
		query.append(",	A.TRSP_SO_TP_CD" ).append("\n"); 
		query.append(",	A.TRSP_BND_CD" ).append("\n"); 
		query.append(",	A.EQ_KND_CD" ).append("\n"); 
		query.append(",	A.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 	CASE WHEN A.EQ_KND_CD = 'Z' AND A.TRSP_SO_CMB_TP_CD = 'BD'" ).append("\n"); 
		query.append("THEN COUNT(*) OVER (PARTITION BY A.TRSP_SO_CMB_TP_CD, A.TRSP_SO_CMB_SEQ)" ).append("\n"); 
		query.append("WHEN A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("WHEN A.EQ_KND_CD = 'U' AND SUBSTR(A.EQ_TPSZ_CD,1,1) = 'F' AND A.TRSP_SO_CMB_TP_CD = 'BD'" ).append("\n"); 
		query.append("THEN COUNT(*) OVER (PARTITION BY A.TRSP_SO_CMB_TP_CD, A.TRSP_SO_CMB_SEQ)" ).append("\n"); 
		query.append("WHEN A.EQ_KND_CD = 'U' AND SUBSTR(A.EQ_TPSZ_CD,1,1) = 'F'" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END BDL_KNT" ).append("\n"); 
		query.append(", 	A.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append(", 	A.CNTR_WGT" ).append("\n"); 
		query.append(", 	A.CRE_OFC_CD" ).append("\n"); 
		query.append(", 	A.CGO_TP_CD" ).append("\n"); 
		query.append(", 	A.CMDT_CD" ).append("\n"); 
		query.append(", 	NVL(A.TRSP_DFLT_VNDR_FLG,'N')		TRSP_DFLT_VNDR_FLG" ).append("\n"); 
		query.append(", 	DECODE(A.TRSP_BND_CD,'I', D.DE_TERM_CD, 'O', D.RCV_TERM_CD, '') BKG_TERM" ).append("\n"); 
		query.append("FROM 		  	TRS_TRSP_SVC_ORD AA" ).append("\n"); 
		query.append(", 	TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append(", 	TRS_TRSP_WRK_ORD B" ).append("\n"); 
		query.append(", 	TRS_TRSP_INV_WRK C" ).append("\n"); 
		query.append(", 	BKG_CONTAINER D" ).append("\n"); 
		query.append("WHERE 	  		AA.TRSP_SO_OFC_CTY_CD     				= A.PRNT_TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND 		  	AA.TRSP_SO_SEQ            				= A.PRNT_TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND 		  	AA.TRSP_WO_OFC_CTY_CD 			  		= B.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND 		  	AA.TRSP_WO_SEQ 			  				= B.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND 		  	AA.INV_NO 								= C.INV_NO" ).append("\n"); 
		query.append("AND 		  	AA.INV_VNDR_SEQ 			  			= C.INV_VNDR_SEQ" ).append("\n"); 
		query.append("AND 		  	A.BKG_NO 								= D.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND 		  	A.EQ_NO  					  			= D.CNTR_NO" ).append("\n"); 
		query.append("AND 		  	NVL(A.DELT_FLG,'N') 					= 'N'" ).append("\n"); 
		query.append("AND 		  	A.TRSP_SO_TP_CD 		  	    		= 'S'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${so_ofc_cd}!='')" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD  = @[so_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${io_bound}!='A')" ).append("\n"); 
		query.append("AND NVL(A.TRSP_BND_CD, 'N/A')	= NVL(@[io_bound], NVL(A.TRSP_BND_CD, 'N/A'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${so_month}!='' && ${so_month}!='YYYYMM')" ).append("\n"); 
		query.append("AND TO_CHAR(A.LOCL_CRE_DT, 'YYYYMM')  = @[so_month]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ((${fm_so_date}!='') && (${to_so_date}!='')&& (${fm_so_date}!='YYYYMMDD')&& (${to_so_date}!='YYYYMMDD'))" ).append("\n"); 
		query.append("AND A.LOCL_CRE_DT >= TO_DATE(NVL( @[fm_so_date], @[to_so_date]),'YYYYMMDD')" ).append("\n"); 
		query.append("AND A.LOCL_CRE_DT <= TO_DATE(NVL( @[to_so_date], @[fm_so_date]),'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--	    ORDER BY   EQ_NO                 ASC" ).append("\n"); 
		query.append("--		     , EQ_TPSZ_CD            ASC" ).append("\n"); 
		query.append("--		     , TRSP_COST_DTL_MOD_CD  ASC" ).append("\n"); 
		query.append("--		     , TRSP_CRR_MOD_CD       ASC" ).append("\n"); 
		query.append("--		     , WO_NUMBER             ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT    	ROWNUM BASIS_NO" ).append("\n"); 
		query.append(", 	A.TRSP_SO_CMB_TP_CD" ).append("\n"); 
		query.append(", 	TO_CHAR(A.TRSP_SO_CMB_SEQ) TRSP_SO_CMB_SEQ" ).append("\n"); 
		query.append(", 	A.TRSP_SO_CMB_SRT_NO" ).append("\n"); 
		query.append(",	A.EQ_NO" ).append("\n"); 
		query.append(",	A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(",	A.TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append(",	A.TRSP_CRR_MOD_CD" ).append("\n"); 
		query.append(",	A.FM_NOD_CD" ).append("\n"); 
		query.append(",	A.VIA_NOD_CD" ).append("\n"); 
		query.append(",	A.TO_NOD_CD" ).append("\n"); 
		query.append(",	A.DOR_NOD_CD" ).append("\n"); 
		query.append(",	SUBSTR(A.FM_NOD_CD , 1, 5) FM_LOC" ).append("\n"); 
		query.append(",	SUBSTR(A.FM_NOD_CD , 6, 2) FM_YARD" ).append("\n"); 
		query.append(",	SUBSTR(A.VIA_NOD_CD, 1, 5) VIA_LOC" ).append("\n"); 
		query.append(",	SUBSTR(A.VIA_NOD_CD, 6, 2) VIA_YARD" ).append("\n"); 
		query.append(",	SUBSTR(A.TO_NOD_CD , 1, 5) TO_LOC" ).append("\n"); 
		query.append(",	SUBSTR(A.TO_NOD_CD , 6, 2) TO_YARD" ).append("\n"); 
		query.append(",	SUBSTR(A.DOR_NOD_CD, 1, 5) DOR_LOC" ).append("\n"); 
		query.append(",	SUBSTR(A.DOR_NOD_CD, 6, 2) DOR_ZONE" ).append("\n"); 
		query.append(",	A.CUST_CNT_CD||A.CUST_SEQ  CUST_VAL" ).append("\n"); 
		query.append(",	A.CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append(",	A.CUST_CNT_CD" ).append("\n"); 
		query.append(",	A.CUST_SEQ" ).append("\n"); 
		query.append(",	A.DOR_DE_ADDR" ).append("\n"); 
		query.append(",	A.VNDR_SEQ" ).append("\n"); 
		query.append(",	A.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append(",	A.TRSP_AGMT_WY_TP_CD" ).append("\n"); 
		query.append(",	AA.CURR_CD                WO_CURR_CD" ).append("\n"); 
		query.append(",	AA.BZC_AMT                WO_BZC_AMT" ).append("\n"); 
		query.append(",	AA.FUEL_SCG_AMT           WO_FUEL_SCG_AMT" ).append("\n"); 
		query.append(",	AA.OVR_WGT_SCG_AMT        WO_OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append(",	AA.ETC_ADD_AMT            WO_ETC_ADD_AMT" ).append("\n"); 
		query.append(",	AA.NEGO_AMT               WO_NEGO_AMT" ).append("\n"); 
		query.append(",	NVL(AA.BZC_AMT,0)+NVL(AA.FUEL_SCG_AMT,0)+NVL(AA.OVR_WGT_SCG_AMT,0)+NVL(AA.ETC_ADD_AMT,0)+NVL(AA.NEGO_AMT,0) WO_TOT_AMT" ).append("\n"); 
		query.append(", 	AA.INV_CURR_CD" ).append("\n"); 
		query.append(", 	AA.INV_BZC_AMT" ).append("\n"); 
		query.append(", 	AA.INV_ETC_ADD_AMT" ).append("\n"); 
		query.append(", 	NVL(AA.INV_BZC_AMT,0)+NVL(AA.INV_ETC_ADD_AMT,0) TOT_INV_AMT" ).append("\n"); 
		query.append(",	A.CURR_CD                SO_CURR_CD" ).append("\n"); 
		query.append(",	A.BZC_AMT                SO_BZC_AMT" ).append("\n"); 
		query.append(",	A.FUEL_SCG_AMT           SO_FUEL_SCG_AMT" ).append("\n"); 
		query.append(",	A.OVR_WGT_SCG_AMT        SO_OVR_WGT_SCG_AMT" ).append("\n"); 
		query.append(",	A.ETC_ADD_AMT            SO_ETC_ADD_AMT" ).append("\n"); 
		query.append(",	A.NEGO_AMT               SO_NEGO_AMT" ).append("\n"); 
		query.append(",	NVL(A.BZC_AMT,0)+NVL(A.FUEL_SCG_AMT,0)+NVL(A.OVR_WGT_SCG_AMT,0)+NVL(A.ETC_ADD_AMT,0)+NVL(A.NEGO_AMT,0) SO_TOT_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	A.BKG_NO  BKG_SQ" ).append("\n"); 
		query.append(",	A.BL_NO" ).append("\n"); 
		query.append(",	AA.VSL_CD||AA.SKD_VOY_NO||AA.SKD_DIR_CD   TRUCK_VVD" ).append("\n"); 
		query.append(",	A.TRSP_SO_OFC_CTY_CD||A.TRSP_SO_SEQ    SO_NUMBER" ).append("\n"); 
		query.append(",	AA.TRSP_WO_OFC_CTY_CD||AA.TRSP_WO_SEQ    WO_NUMBER" ).append("\n"); 
		query.append(",	B.CRE_DT" ).append("\n"); 
		query.append(",	AA.INV_NO" ).append("\n"); 
		query.append(",	C.INV_CFM_DT" ).append("\n"); 
		query.append(",	A.SPL_ISS_RSN" ).append("\n"); 
		query.append(",	A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",	A.TRSP_SO_SEQ" ).append("\n"); 
		query.append(",	A.TRSP_SO_TP_CD" ).append("\n"); 
		query.append(",	A.TRSP_BND_CD" ).append("\n"); 
		query.append(",	A.EQ_KND_CD" ).append("\n"); 
		query.append(",	A.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 	CASE WHEN A.EQ_KND_CD = 'Z' AND A.TRSP_SO_CMB_TP_CD = 'BD'" ).append("\n"); 
		query.append("THEN COUNT(*) OVER (PARTITION BY A.TRSP_SO_CMB_TP_CD, A.TRSP_SO_CMB_SEQ)" ).append("\n"); 
		query.append("WHEN A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("WHEN A.EQ_KND_CD = 'U' AND SUBSTR(A.EQ_TPSZ_CD,1,1) = 'F' AND A.TRSP_SO_CMB_TP_CD = 'BD'" ).append("\n"); 
		query.append("THEN COUNT(*) OVER (PARTITION BY A.TRSP_SO_CMB_TP_CD, A.TRSP_SO_CMB_SEQ)" ).append("\n"); 
		query.append("WHEN A.EQ_KND_CD = 'U' AND SUBSTR(A.EQ_TPSZ_CD,1,1) = 'F'" ).append("\n"); 
		query.append("THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END BDL_KNT" ).append("\n"); 
		query.append(", 	A.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append(", 	A.CNTR_WGT" ).append("\n"); 
		query.append(", 	A.CRE_OFC_CD" ).append("\n"); 
		query.append(", 	A.CGO_TP_CD" ).append("\n"); 
		query.append(", 	A.CMDT_CD" ).append("\n"); 
		query.append(", 	NVL(A.TRSP_DFLT_VNDR_FLG,'N')		TRSP_DFLT_VNDR_FLG" ).append("\n"); 
		query.append(", 	'-'  BKG_TERM" ).append("\n"); 
		query.append("FROM 		  	TRS_TRSP_SVC_ORD AA" ).append("\n"); 
		query.append(", 	TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append(", 	TRS_TRSP_WRK_ORD B" ).append("\n"); 
		query.append(", 	TRS_TRSP_INV_WRK C" ).append("\n"); 
		query.append("WHERE 	  		AA.TRSP_SO_OFC_CTY_CD     				= A.PRNT_TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND 		  	AA.TRSP_SO_SEQ            				= A.PRNT_TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND 		  	AA.TRSP_WO_OFC_CTY_CD 			  		= B.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND 		  	AA.TRSP_WO_SEQ 			  				= B.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND 		  	AA.INV_NO 								= C.INV_NO" ).append("\n"); 
		query.append("AND 		  	AA.INV_VNDR_SEQ 			  			= C.INV_VNDR_SEQ" ).append("\n"); 
		query.append("AND 	        A.TRSP_COST_DTL_MOD_CD                  = 'ER'" ).append("\n"); 
		query.append("AND 		  	NVL(A.DELT_FLG,'N') 					= 'N'" ).append("\n"); 
		query.append("AND 		  	A.TRSP_SO_TP_CD 		  	    		= 'S'" ).append("\n"); 
		query.append("#if(${so_ofc_cd}!='')" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD  = @[so_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${io_bound}!='A')" ).append("\n"); 
		query.append("AND NVL(A.TRSP_BND_CD, 'N/A')	= NVL(@[io_bound], NVL(A.TRSP_BND_CD, 'N/A'))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${so_month}!='' && ${so_month}!='YYYYMM')" ).append("\n"); 
		query.append("AND TO_CHAR(A.LOCL_CRE_DT, 'YYYYMM')  = @[so_month]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ((${fm_so_date}!='') && (${to_so_date}!='')&& (${fm_so_date}!='YYYYMMDD')&& (${to_so_date}!='YYYYMMDD'))" ).append("\n"); 
		query.append("AND A.LOCL_CRE_DT >= TO_DATE(NVL( @[fm_so_date], @[to_so_date]),'YYYYMMDD')" ).append("\n"); 
		query.append("AND A.LOCL_CRE_DT <= TO_DATE(NVL( @[to_so_date], @[fm_so_date]),'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--	    ORDER BY   EQ_NO                 ASC" ).append("\n"); 
		query.append("--		     , EQ_TPSZ_CD            ASC" ).append("\n"); 
		query.append("--		     , TRSP_COST_DTL_MOD_CD  ASC" ).append("\n"); 
		query.append("--		     , TRSP_CRR_MOD_CD       ASC" ).append("\n"); 
		query.append("--		     , WO_NUMBER             ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT '1' BASIS_NO2 FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT '2' BASIS_NO2 FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT '3' BASIS_NO2 FROM DUAL" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append("ORDER BY  X.EQ_NO" ).append("\n"); 
		query.append(", X.BASIS_NO  ASC" ).append("\n"); 
		query.append(", Z.BASIS_NO2 ASC" ).append("\n"); 

	}
}