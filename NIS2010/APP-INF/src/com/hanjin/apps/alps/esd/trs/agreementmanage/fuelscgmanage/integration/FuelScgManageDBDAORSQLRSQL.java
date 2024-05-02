/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FuelScgManageDBDAORSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.13
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2015.05.13 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FuelScgManageDBDAORSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Fuel Surcharge (FUA) Update List 조회
	  * </pre>
	  */
	public FuelScgManageDBDAORSQLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_trsp_cost_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_agmt_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.fuelscgmanage.integration ").append("\n"); 
		query.append("FileName : FuelScgManageDBDAORSQLRSQL").append("\n"); 
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
		query.append("SELECT X.*" ).append("\n"); 
		query.append("  FROM ( SELECT C.TRSP_AGMT_RT_TP_CD" ).append("\n"); 
		query.append("	       ,A.TRSP_AGMT_OFC_CTY_CD || A.TRSP_AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("	       ,B.VNDR_SEQ" ).append("\n"); 
		query.append("	       ,(SELECT MDM.VNDR_LGL_ENG_NM FROM MDM_VENDOR MDM WHERE MDM.VNDR_SEQ = B.VNDR_SEQ ) VNDR_NM" ).append("\n"); 
		query.append("	       ,C.TRSP_COST_MOD_CD" ).append("\n"); 
		query.append("	       ,C.AGMT_TRSP_TP_CD" ).append("\n"); 
		query.append("	       ,E.EQ_KND_CD" ).append("\n"); 
		query.append("	       ,C.CGO_TP_CD" ).append("\n"); 
		query.append("	       ,DECODE(C.CUST_CNT_CD||C.CUST_SEQ, 'XX0', NULL, C.CUST_CNT_CD||C.CUST_SEQ) CUST_CD" ).append("\n"); 
		query.append("	       ,DECODE(C.CMDT_GRP_CD, 'XXXX', NULL, C.CMDT_GRP_CD) CMDT_GRP_CD" ).append("\n"); 
		query.append("	       ,DECODE(C.RAIL_SVC_TP_CD, '00', NULL, C.RAIL_SVC_TP_CD) RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("	       ,D.AGMT_ROUT_ALL_FLG" ).append("\n"); 
		query.append("	       ,TO_CHAR(E.EFF_FM_DT,'YYYYMMDD')  AS EFF_FM_DT" ).append("\n"); 
		query.append("	       ,TO_CHAR(E.EFF_TO_DT,'YYYYMMDD')  AS EFF_TO_DT" ).append("\n"); 
		query.append("	       ,E.AGMT_SCG_RT_DIV_CD" ).append("\n"); 
		query.append("	       ,E.TRSP_ONE_WY_RT" ).append("\n"); 
		query.append("	       ,E.TRSP_RND_RT" ).append("\n"); 
		query.append("	       ,C.UPD_USR_ID" ).append("\n"); 
		query.append("	       ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = C.UPD_USR_ID) UPD_USR_NM" ).append("\n"); 
		query.append("	       ,C.UPD_OFC_CD" ).append("\n"); 
		query.append("	       ,(SELECT COUNT(*)" ).append("\n"); 
		query.append("	           FROM TRS_AGMT_EQ_RT X" ).append("\n"); 
		query.append("	          WHERE X.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	            AND X.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("	            AND X.TRSP_AGMT_RT_TP_SER_NO = C.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("	            AND NVL(X.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("		   #if (${fm_effective_agmt} != 'A' )" ).append("\n"); 
		query.append("	    	    AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD)  FROM DUAL ) BETWEEN E.EFF_FM_DT AND E.EFF_TO_DT" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("	        ) AS RATE_TOT_CNT " ).append("\n"); 
		query.append("	       ,A.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	       ,A.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("	       ,E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("	       ,E.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("	       ,E.TRSP_AGMT_SCG_RT_SEQ" ).append("\n"); 
		query.append("	       ,DECODE(SUBSTR(D.FM_NOD_CD,1,5), '00000', NULL, SUBSTR(D.FM_NOD_CD,1,5)) AS FM_NOD_CD" ).append("\n"); 
		query.append("	       ,DECODE(SUBSTR(D.FM_NOD_CD,6), '00', NULL, SUBSTR(D.FM_NOD_CD,6)) AS FM_NOD_YD" ).append("\n"); 
		query.append("	       ,DECODE(SUBSTR(D.VIA_NOD_CD,1,5), '00000', NULL, SUBSTR(D.VIA_NOD_CD,1,5)) AS VIA_NOD_CD" ).append("\n"); 
		query.append("	       ,DECODE(SUBSTR(D.VIA_NOD_CD,6), '00', NULL, SUBSTR(D.VIA_NOD_CD,6)) AS VIA_NOD_YD" ).append("\n"); 
		query.append("	       ,DECODE(SUBSTR(D.DOR_NOD_CD,1,5), '00000', NULL, SUBSTR(D.DOR_NOD_CD,1,5)) AS DOR_NOD_CD" ).append("\n"); 
		query.append("	       ,DECODE(SUBSTR(D.DOR_NOD_CD,6), '00', NULL, SUBSTR(D.DOR_NOD_CD,6)) AS DOR_NOD_YD" ).append("\n"); 
		query.append("	       ,DECODE(SUBSTR(D.TO_NOD_CD,1,5), '00000', NULL, SUBSTR(D.TO_NOD_CD,1,5)) AS TO_NOD_CD" ).append("\n"); 
		query.append("	       ,DECODE(SUBSTR(D.TO_NOD_CD,6), '00', NULL, SUBSTR(D.TO_NOD_CD,6)) AS TO_NOD_YD" ).append("\n"); 
		query.append("		   ,E.TO_WGT" ).append("\n"); 
		query.append("	       ,E.WGT_MEAS_UT_CD" ).append("\n"); 
		query.append("		   ,D.TRSP_SCG_CD" ).append("\n"); 
		query.append("	       ,E.CURR_CD       " ).append("\n"); 
		query.append("	  FROM  TRS_AGMT_HDR   A" ).append("\n"); 
		query.append("	       ,TRS_AGMT_APLY_VNDR B" ).append("\n"); 
		query.append("	       ,TRS_AGMT_RT_TP C" ).append("\n"); 
		query.append("	       ,TRS_AGMT_SCG_NOD   D" ).append("\n"); 
		query.append("	       ,TRS_AGMT_SCG_RT E" ).append("\n"); 
		query.append("	  WHERE A.TRSP_AGMT_OFC_CTY_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	    AND A.TRSP_AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("	    AND A.TRSP_AGMT_OFC_CTY_CD   = C.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	    AND A.TRSP_AGMT_SEQ          = C.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("	    AND C.TRSP_AGMT_OFC_CTY_CD   = D.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	    AND C.TRSP_AGMT_SEQ          = D.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("	    AND C.TRSP_AGMT_RT_TP_SER_NO = D.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("	    AND D.TRSP_AGMT_OFC_CTY_CD   = E.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("	    AND D.TRSP_AGMT_SEQ          = E.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("	    AND D.TRSP_AGMT_RT_TP_SER_NO = E.TRSP_AGMT_RT_TP_SER_NO" ).append("\n"); 
		query.append("	    AND D.TRSP_AGMT_SCG_NOD_SEQ  = E.TRSP_AGMT_SCG_NOD_SEQ" ).append("\n"); 
		query.append("	    AND B.AGMT_VNDR_PRMRY_FLG  = 'Y'" ).append("\n"); 
		query.append("	    AND D.TRSP_SCG_CD = 'FUA'" ).append("\n"); 
		query.append("	    AND D.AGMT_ROUT_ALL_FLG = 'Y'" ).append("\n"); 
		query.append("	#if ($arr_agmt_no.size() > 0) " ).append("\n"); 
		query.append("	    AND (A.TRSP_AGMT_OFC_CTY_CD,A.TRSP_AGMT_SEQ) IN (" ).append("\n"); 
		query.append("	    #foreach( ${key} in ${arr_agmt_no}) " ).append("\n"); 
		query.append("			#if($velocityCount < $arr_agmt_no.size()) " ).append("\n"); 
		query.append("				(SUBSTR('$key',1,3),SUBSTR('$key',4)), " ).append("\n"); 
		query.append("		    #else " ).append("\n"); 
		query.append("				(SUBSTR('$key',1,3),SUBSTR('$key',4)) " ).append("\n"); 
		query.append("		    #end " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	           )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if ($arr_vndr_seq.size() > 0 )" ).append("\n"); 
		query.append("	    AND (A.TRSP_AGMT_OFC_CTY_CD, A.TRSP_AGMT_SEQ) IN ( SELECT TRSP_AGMT_OFC_CTY_CD, TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("												             FROM TRS_AGMT_APLY_VNDR" ).append("\n"); 
		query.append("											                WHERE VNDR_SEQ IN (" ).append("\n"); 
		query.append("																			#if($velocityCount < $arr_vndr_seq.size()) " ).append("\n"); 
		query.append("																				'$key'," ).append("\n"); 
		query.append("																			#else" ).append("\n"); 
		query.append("																				'$key'" ).append("\n"); 
		query.append("	        	                                                            #end" ).append("\n"); 
		query.append("																			)" ).append("\n"); 
		query.append("														      AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("												          )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if ($arr_ctrt_office.size() > 0) " ).append("\n"); 
		query.append("	    AND A.CTRT_OFC_CD IN (" ).append("\n"); 
		query.append("	    #foreach( ${key} in ${arr_ctrt_office}) " ).append("\n"); 
		query.append("			#if($velocityCount < $arr_ctrt_office.size()) " ).append("\n"); 
		query.append("				'$key', " ).append("\n"); 
		query.append("		    #else " ).append("\n"); 
		query.append("				'$key' " ).append("\n"); 
		query.append("		    #end " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	           )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${fm_effective_agmt} != 'A' )" ).append("\n"); 
		query.append("	    AND (SELECT GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CTRT_OFC_CD)  FROM DUAL ) BETWEEN E.EFF_FM_DT AND E.EFF_TO_DT" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#if (${fm_trsp_cost_mod_cd} != '' )" ).append("\n"); 
		query.append("	 	AND C.TRSP_COST_MOD_CD =  @[fm_trsp_cost_mod_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${fm_agmt_trsp_tp_cd} != '' )" ).append("\n"); 
		query.append("		AND C.AGMT_TRSP_TP_CD = @[fm_agmt_trsp_tp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	    AND NVL(E.DELT_FLG, 'N')     = 'N'" ).append("\n"); 
		query.append("	    AND E.EQ_KND_CD = 'U'" ).append("\n"); 
		query.append("	) X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND X.RATE_TOT_CNT > 0" ).append("\n"); 

	}
}