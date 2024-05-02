/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingManageDBDAOSearchSendSpotBiddingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.16
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.10.16 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpotBiddingManageDBDAOSearchSendSpotBiddingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPP로 I/F해야할 Spot Bidding List 조회
	  * </pre>
	  */
	public SpotBiddingManageDBDAOSearchSendSpotBiddingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bid_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bid_fm_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bid_to_due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("win_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bid_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.integration").append("\n"); 
		query.append("FileName : SpotBiddingManageDBDAOSearchSendSpotBiddingListRSQL").append("\n"); 
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
		query.append("SELECT  A.SPOT_BID_NO BID_NO                  																																				" ).append("\n"); 
		query.append("       ,TO_CHAR(A.SPOT_BID_DUE_DT,'YYYY-MM-DD HH24:MI:SS') BID_DUE_DT" ).append("\n"); 
		query.append("	   ,C.BKG_NO                 																																				" ).append("\n"); 
		query.append("       ,C.TRSP_WO_OFC_CTY_CD || C.TRSP_WO_SEQ WO_NO                  																																				" ).append("\n"); 
		query.append("	   ,B.VNDR_SEQ BID_VNDR_SEQ           																																				" ).append("\n"); 
		query.append("	   ,C.EQ_NO EQ_NO                  																																				" ).append("\n"); 
		query.append("	   ,C.EQ_TPSZ_CD" ).append("\n"); 
		query.append("	   ,(SELECT INTG_CD_VAL_DP_DESC  FROM COM_INTG_CD_DTL WHERE INTG_CD_ID ='CD00594' AND INTG_CD_VAL_CTNT = C.TRSP_COST_DTL_MOD_CD ) TRSP_COST_DTL_MOD_CD    																																				" ).append("\n"); 
		query.append("	   ,(SELECT INTG_CD_VAL_DP_DESC  FROM COM_INTG_CD_DTL WHERE INTG_CD_ID ='CD00283' AND INTG_CD_VAL_CTNT = C.TRSP_CRR_MOD_CD ) TRSP_CRR_MOD_CD         																																				" ).append("\n"); 
		query.append("	   ,(CASE WHEN C.CGO_TP_CD = 'F' THEN 'FULL'" ).append("\n"); 
		query.append("	          WHEN C.CGO_TP_CD = 'M' THEN 'EMPTY'" ).append("\n"); 
		query.append("	          ELSE ''" ).append("\n"); 
		query.append("	     END) CGO_TP_CD              																																				" ).append("\n"); 
		query.append("	   ,C.SPCL_CGO_CNTR_TP_CD    																																				" ).append("\n"); 
		query.append("	   ,(SELECT INTG_CD_VAL_DP_DESC  FROM COM_INTG_CD_DTL WHERE INTG_CD_ID ='CD00591' AND INTG_CD_VAL_CTNT = C.TRSP_BND_CD) TRSP_BND_CD            																																				" ).append("\n"); 
		query.append("	   ,C.CNTR_KGS_WGT           																																				" ).append("\n"); 
		query.append("	   ,C.CNTR_LBS_WGT           																																				" ).append("\n"); 
		query.append("	   ,C.FM_NOD_CD              																																				" ).append("\n"); 
		query.append("	   ,(SELECT YD_NM FROM MDM_YARD WHERE YD_CD = C.FM_NOD_CD) FM_NOD_NM       																																				" ).append("\n"); 
		query.append("	   ,(SELECT YD_ADDR FROM MDM_YARD WHERE YD_CD = C.FM_NOD_CD) FM_NOD_ADDR        																																				" ).append("\n"); 
		query.append("	   ,C.VIA_NOD_CD" ).append("\n"); 
		query.append("	   ,(SELECT YD_NM FROM MDM_YARD WHERE YD_CD = C.VIA_NOD_CD) VIA_NOD_NM        																																				" ).append("\n"); 
		query.append("	   ,(SELECT YD_ADDR FROM MDM_YARD WHERE YD_CD = C.VIA_NOD_CD) VIA_NOD_ADDR               																																				         																																				" ).append("\n"); 
		query.append("	   ,C.DOR_NOD_CD" ).append("\n"); 
		query.append("	   ,(SELECT ZN_NM FROM MDM_ZONE WHERE ZN_CD = C.DOR_NOD_CD) DOR_NOD_NM        																																				" ).append("\n"); 
		query.append("	   ,C.DOR_DE_ADDR DOR_NOD_ADDR              																																				          																																				" ).append("\n"); 
		query.append("	   ,C.TO_NOD_CD" ).append("\n"); 
		query.append("	   ,(SELECT YD_NM FROM MDM_YARD WHERE YD_CD = C.TO_NOD_CD) TO_NOD_NM        																																				" ).append("\n"); 
		query.append("	   ,(SELECT YD_ADDR FROM MDM_YARD WHERE YD_CD = C.TO_NOD_CD) TO_NOD_ADDR" ).append("\n"); 
		query.append("       ,TO_CHAR(C.N1ST_NOD_PLN_DT,'YYYY-MM-DD HH24:MI:SS') FM_DEPT_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(C.LST_NOD_PLN_DT,'YYYY-MM-DD HH24:MI:SS') TO_ARVL_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(DECODE(C.CONTI_CD,'E',C.DOR_ARR_DT,C.DOR_NOD_PLN_DT),'YYYY-MM-DD HH24:MI:SS') DOR_ARVL_DT" ).append("\n"); 
		query.append("       ,(SELECT MIN(X.SPOT_BID_CURR_CD) KEEP(DENSE_RANK FIRST ORDER BY TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(X.SPOT_BID_CURR_CD,X.SPOT_BID_AMT,TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD),'YYYYMMDD')) ASC) AS SPOT_BID_AMT " ).append("\n"); 
		query.append("           FROM TRS_SPOT_BID_VNDR X" ).append("\n"); 
		query.append("          WHERE X.SPOT_BID_NO = A.SPOT_BID_NO" ).append("\n"); 
		query.append("            AND X.SPOT_BID_VNDR_STS_CD = 'S'" ).append("\n"); 
		query.append("			AND X.SPOT_BID_CURR_CD IS NOT NULL" ).append("\n"); 
		query.append("            AND X.SPOT_BID_AMT >= 0) LOCL_LOW_BID_CURR_CD  " ).append("\n"); 
		query.append("       ,(SELECT MIN(X.SPOT_BID_AMT) KEEP(DENSE_RANK FIRST ORDER BY TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(X.SPOT_BID_CURR_CD,X.SPOT_BID_AMT,TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD),'YYYYMMDD')) ASC) AS SPOT_BID_AMT " ).append("\n"); 
		query.append("           FROM TRS_SPOT_BID_VNDR X" ).append("\n"); 
		query.append("          WHERE X.SPOT_BID_NO = A.SPOT_BID_NO" ).append("\n"); 
		query.append("            AND X.SPOT_BID_VNDR_STS_CD = 'S'" ).append("\n"); 
		query.append("			AND X.SPOT_BID_CURR_CD IS NOT NULL" ).append("\n"); 
		query.append("            AND X.SPOT_BID_AMT >= 0) LOCL_LOW_BID_AMT         																																				      																																				" ).append("\n"); 
		query.append("	   ,ROUND((SELECT MIN(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC ( X.SPOT_BID_CURR_CD" ).append("\n"); 
		query.append("                                                           			 ,X.SPOT_BID_AMT" ).append("\n"); 
		query.append("                                                           			 ,TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD),'YYYYMM')" ).append("\n"); 
		query.append("		                                                            ) " ).append("\n"); 
		query.append("                     	   )" ).append("\n"); 
		query.append("           FROM TRS_SPOT_BID_VNDR X" ).append("\n"); 
		query.append("          WHERE X.SPOT_BID_NO = A.SPOT_BID_NO" ).append("\n"); 
		query.append("            AND X.SPOT_BID_VNDR_STS_CD = 'S'" ).append("\n"); 
		query.append("			AND X.SPOT_BID_CURR_CD IS NOT NULL" ).append("\n"); 
		query.append("            AND X.SPOT_BID_AMT >= 0),2) LOW_BID_AMT             																																				" ).append("\n"); 
		query.append("	   ,B.SPOT_BID_CURR_CD BID_CURR_CD            																																				" ).append("\n"); 
		query.append("	   ,B.SPOT_BID_AMT BID_AMT                																																				" ).append("\n"); 
		query.append("	   ,(CASE WHEN B.SCFL_BID_FLG = 'Y' THEN 'Yes'" ).append("\n"); 
		query.append("	          ELSE 'No'" ).append("\n"); 
		query.append("	     END) BID_WIN_FLG " ).append("\n"); 
		query.append("	   ,CASE WHEN A.SPOT_BID_STS_CD = 'P' AND A.SPOT_BID_DUE_DT < GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD) THEN 'F'" ).append("\n"); 
		query.append("             ELSE A.SPOT_BID_STS_CD" ).append("\n"); 
		query.append("         END AS BID_STS_CD           																																				" ).append("\n"); 
		query.append("	   ,(SELECT INTG_CD_VAL_DP_DESC  FROM COM_INTG_CD_DTL WHERE INTG_CD_ID ='CD03431' AND INTG_CD_VAL_CTNT = B.SPOT_BID_VNDR_STS_CD) BID_VNDR_STS_CD" ).append("\n"); 
		query.append("   FROM TRS_SPOT_BID A" ).append("\n"); 
		query.append("       ,TRS_SPOT_BID_VNDR B" ).append("\n"); 
		query.append("       ,TRS_TRSP_SVC_ORD C" ).append("\n"); 
		query.append("  WHERE A.SPOT_BID_NO = B.SPOT_BID_NO" ).append("\n"); 
		query.append("    AND A.SPOT_BID_NO = C.SPOT_BID_NO" ).append("\n"); 
		query.append("    AND A.TRSP_SO_OFC_CTY_CD = C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND A.TRSP_SO_SEQ = C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("    AND (B.SCFL_BID_FLG = 'Y' OR A.SPOT_BID_STS_CD = 'P' OR A.SPOT_BID_STS_CD = 'C' OR A.SPOT_BID_STS_CD = 'F')" ).append("\n"); 
		query.append("    AND B.VNDR_SEQ = @[bid_vndr_seq]" ).append("\n"); 
		query.append("#if(${arr_bid_fm_due_dt} != '' && ${arr_bid_to_due_dt})" ).append("\n"); 
		query.append("    AND A.SPOT_BID_DUE_DT BETWEEN TO_DATE(@[bid_fm_due_dt],'YYYYMMDD') AND TO_DATE(@[bid_to_due_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${arr_bid_sts_cd} != '')" ).append("\n"); 
		query.append("    #if(${arr_bid_sts_cd} == 'P')" ).append("\n"); 
		query.append("    AND A.SPOT_BID_STS_CD = 'P'" ).append("\n"); 
		query.append("    AND A.SPOT_BID_DUE_DT > GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT OFC_CD FROM MDM_VENDOR  WHERE VNDR_SEQ = @[bid_vndr_seq]))" ).append("\n"); 
		query.append("    #elseif(${arr_bid_sts_cd} == 'F')" ).append("\n"); 
		query.append("    AND (A.SPOT_BID_STS_CD = 'F' OR A.SPOT_BID_DUE_DT < GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC((SELECT OFC_CD FROM MDM_VENDOR  WHERE VNDR_SEQ = @[bid_vndr_seq])) )" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    AND A.SPOT_BID_STS_CD = @[bid_sts_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($arr_bid_no.size() > 0)" ).append("\n"); 
		query.append("	AND A.SPOT_BID_NO IN (" ).append("\n"); 
		query.append("	#foreach( ${key} in ${arr_bid_no}) " ).append("\n"); 
		query.append("		#if($velocityCount == 1)						" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	    	,'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($arr_bkg_no.size() > 0)" ).append("\n"); 
		query.append("	AND C.BKG_NO IN (" ).append("\n"); 
		query.append("	#foreach( ${key} in ${arr_bkg_no}) " ).append("\n"); 
		query.append("		#if($velocityCount == 1)						" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	    	,'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($arr_wo_no.size() > 0) " ).append("\n"); 
		query.append("    AND (C.TRSP_WO_OFC_CTY_CD,C.TRSP_WO_SEQ) in (" ).append("\n"); 
		query.append("	#foreach(${key} in ${arr_wo_no}) " ).append("\n"); 
		query.append("		#if($velocityCount == 1) " ).append("\n"); 
		query.append("			(substr('$key',0,3),to_number(substr('$key',4,length('$key'))))" ).append("\n"); 
		query.append("		#else " ).append("\n"); 
		query.append("			,(substr('$key',0,3),to_number(substr('$key',4,length('$key'))))" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${win_flg} != '')" ).append("\n"); 
		query.append("   AND B.SCFL_BID_FLG = @[win_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}