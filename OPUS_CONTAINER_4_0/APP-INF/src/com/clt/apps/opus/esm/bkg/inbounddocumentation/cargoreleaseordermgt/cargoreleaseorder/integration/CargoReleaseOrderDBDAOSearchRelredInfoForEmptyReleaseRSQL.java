/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchRelredInfoForEmptyReleaseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchRelredInfoForEmptyReleaseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COREOR 보낼때 RELRED를 같이 보내기 위한 정보
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchRelredInfoForEmptyReleaseRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_trns_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gubun",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_pkup_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchRelredInfoForEmptyReleaseRSQL").append("\n"); 
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
		query.append("SELECT   T.VENDOR                                         " ).append("\n"); 
		query.append("        ,T.TRANS_MODE									   " ).append("\n"); 
		query.append("	    ,T.PD_DT    						      	        " ).append("\n"); 
		query.append("	    ,T.SPCL_INST          							" ).append("\n"); 
		query.append("        ,T.CNTR_NO             							" ).append("\n"); 
		query.append("	    ,T.SLT_NO            		" ).append("\n"); 
		query.append("	    ,T.CNTR_TYPE							            " ).append("\n"); 
		query.append("	    ,T.CARGOTYPE                                      " ).append("\n"); 
		query.append("	    ,T.SEAL		         					        " ).append("\n"); 
		query.append("	    ,T.CNTR_QTY		                                " ).append("\n"); 
		query.append("	    ,T.DIND							                " ).append("\n"); 
		query.append("        ,T.RIND                           				" ).append("\n"); 
		query.append("        ,T.AIND    				                        " ).append("\n"); 
		query.append("	    ,T.TEMP_F							               " ).append("\n"); 
		query.append("	    ,T.TEMP_C				                            " ).append("\n"); 
		query.append("	    ,T.RF_VOLTAGE   							        		" ).append("\n"); 
		query.append("        ,T.VENT   									    	" ).append("\n"); 
		query.append("	    ,T.VENT_CMH							            " ).append("\n"); 
		query.append("	    ,T.VENT_PCT                                     " ).append("\n"); 
		query.append("	    ,T.HUMID		         					        " ).append("\n"); 
		query.append("	    ,T.GENSET		                                   " ).append("\n"); 
		query.append("	    ,T.RF_REMARK							           " ).append("\n"); 
		query.append("        ,T.RFDRY_IND                          			" ).append("\n"); 
		query.append("        ,T.RF_DRAIN    				                    " ).append("\n"); 
		query.append("	    ,T.OVF							                " ).append("\n"); 
		query.append("	    ,T.OVR				                            " ).append("\n"); 
		query.append("	    ,T.OVH   							               " ).append("\n"); 
		query.append("        ,T.OVLW             									" ).append("\n"); 
		query.append("	    ,T.OVRW							                " ).append("\n"); 
		query.append("	    ,T.OVWGT                                          " ).append("\n"); 
		query.append("	    ,T.VOID_SLOT		         					    " ).append("\n"); 
		query.append("	    ,T.STWG_REQ		                                " ).append("\n"); 
		query.append("	    ,T.TTL_DIM_LEN							        " ).append("\n"); 
		query.append("        ,T.TTL_DIM_WDT                           		" ).append("\n"); 
		query.append("        ,T.TTL_DIM_HGT    				                " ).append("\n"); 
		query.append("	 	,T.WGT_UNIT		                                AS GWGT_UNIT				                " ).append("\n"); 
		query.append("	    ,T.NWGT + T.TWGT	                            AS GWGT" ).append("\n"); 
		query.append("	    ,T.WGT_UNIT  							        AS NWGT_UNIT	    	" ).append("\n"); 
		query.append("        ,T.NWGT          							    AS NWGT" ).append("\n"); 
		query.append("	    ,T.WGT_UNIT							            AS TWGT_UNIT" ).append("\n"); 
		query.append("        ,T.TWGT    " ).append("\n"); 
		query.append("        ,T.CMD   				                            " ).append("\n"); 
		query.append("	    ,T.CMDD							                " ).append("\n"); 
		query.append("FROM (SELECT     '' AS VENDOR" ).append("\n"); 
		query.append("              , DECODE(@[gubun],'BKG',NVL(@[dest_trns_mod_cd],'N'),BKG.ORG_TRNS_MOD_CD) AS TRANS_MODE" ).append("\n"); 
		query.append("              , DECODE(@[gubun],'BKG',@[cgo_pkup_dt],(SELECT /*+ INDEX_ASC(D XPKSCE_COP_DTL)*/TO_CHAR(NVL(D.ACT_DT,D.ESTM_DT),'YYYY-MM-DD')" ).append("\n"); 
		query.append("                                                        FROM SCE_COP_HDR H," ).append("\n"); 
		query.append("                 										     SCE_COP_DTL D," ).append("\n"); 
		query.append("                 											 SCE_ACT_ACT_MAPG MPG" ).append("\n"); 
		query.append("          										       WHERE H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("             											 AND H.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("             											 AND H.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("             											 AND H.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("             											 AND D.ACT_CD = MPG.ACT_CD" ).append("\n"); 
		query.append("             											 AND MPG.ACT_STS_MAPG_CD = 'OP'" ).append("\n"); 
		query.append("             										     AND ROWNUM=1" ).append("\n"); 
		query.append("         												)) AS PD_DT" ).append("\n"); 
		query.append("              , EUR.SPCL_INSTR_RMK AS SPCL_INST" ).append("\n"); 
		query.append("              , B.CNTR_NO AS CNTR_NO" ).append("\n"); 
		query.append("              , BKG_GET_SLOT_NO_FNC(COP.COP_NO)  AS SLT_NO " ).append("\n"); 
		query.append("              , B.CNTR_TPSZ_CD AS CNTR_TYPE" ).append("\n"); 
		query.append("              , NVL(BKG.BKG_CGO_TP_CD, 'M') AS CARGOTYPE" ).append("\n"); 
		query.append("              ,(SELECT CNTR_SEAL_NO " ).append("\n"); 
		query.append("				  FROM BKG_CNTR_SEAL_NO " ).append("\n"); 
		query.append("                 WHERE BKG_NO = B.BKG_NO " ).append("\n"); 
		query.append("                   AND CNTR_NO = B.CNTR_NO " ).append("\n"); 
		query.append("                   AND ROWNUM = 1) AS SEAL" ).append("\n"); 
		query.append("              , 1 AS CNTR_QTY" ).append("\n"); 
		query.append("              , B.DCGO_FLG AS DIND" ).append("\n"); 
		query.append("              , B.RC_FLG AS RIND" ).append("\n"); 
		query.append("              , B.AWK_CGO_FLG AS AIND" ).append("\n"); 
		query.append("              ,RF.FDO_TEMP AS TEMP_F" ).append("\n"); 
		query.append("              ,RF.CDO_TEMP AS TEMP_C" ).append("\n"); 
		query.append("              ,RF.VLTG_NO AS RF_VOLTAGE" ).append("\n"); 
		query.append("              ,RF.CNTR_VENT_TP_CD AS VENT" ).append("\n"); 
		query.append("              ,RF.CBM_PER_HR_QTY AS VENT_CMH" ).append("\n"); 
		query.append("              ,RF.VENT_RTO AS VENT_PCT" ).append("\n"); 
		query.append("              ,RF.HUMID_NO AS HUMID" ).append("\n"); 
		query.append("              ,RF.PWR_SPL_CBL_FLG AS GENSET" ).append("\n"); 
		query.append("              ,REPLACE(REPLACE(RF.DIFF_RMK, CHR(13), ' '), CHR(10), ' ') AS RF_REMARK" ).append("\n"); 
		query.append("              ,B.RD_CGO_FLG AS RFDRY_IND" ).append("\n"); 
		query.append("              ,RF.CNTR_DRN_CD AS RF_DRAIN" ).append("\n"); 
		query.append("              ,AWK.OVR_BKWD_LEN AS OVF" ).append("\n"); 
		query.append("              ,AWK.OVR_FWRD_LEN AS OVR" ).append("\n"); 
		query.append("              ,AWK.OVR_HGT AS OVH" ).append("\n"); 
		query.append("              ,AWK.OVR_LF_LEN AS OVLW" ).append("\n"); 
		query.append("              ,AWK.OVR_RT_LEN AS OVRW" ).append("\n"); 
		query.append("              ,AWK.GRS_WGT || AWK.WGT_UT_CD AS OVWGT" ).append("\n"); 
		query.append("              ,AWK.OVR_VOID_SLT_QTY AS VOID_SLOT" ).append("\n"); 
		query.append("              ,AWK.STWG_RQST_DESC AS STWG_REQ" ).append("\n"); 
		query.append("              ,AWK.TTL_DIM_LEN AS TTL_DIM_LEN" ).append("\n"); 
		query.append("              ,AWK.TTL_DIM_WDT AS TTL_DIM_WDT" ).append("\n"); 
		query.append("              ,AWK.TTL_DIM_HGT AS TTL_DIM_HGT" ).append("\n"); 
		query.append("              ,BKG.CMDT_CD AS CMD" ).append("\n"); 
		query.append("              ,M.CMDT_NM CMDD" ).append("\n"); 
		query.append("              ,NVL(B.CNTR_WGT, 0) AS NWGT " ).append("\n"); 
		query.append("              ,CASE WHEN (  SELECT TARE_WGT FROM MST_CNTR_SPEC" ).append("\n"); 
		query.append("                    WHERE CNTR_SPEC_NO = (SELECT CNTR_SPEC_NO FROM MST_CONTAINER WHERE CNTR_NO = @[cntr_no])) IS NOT NULL" ).append("\n"); 
		query.append("                THEN" ).append("\n"); 
		query.append("                    (SELECT TARE_WGT FROM MST_CNTR_SPEC" ).append("\n"); 
		query.append("                    WHERE CNTR_SPEC_NO = (SELECT CNTR_SPEC_NO FROM MST_CONTAINER WHERE CNTR_NO = @[cntr_no]))" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                    (SELECT CNTR_TPSZ_TARE_WGT FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("                    WHERE CNTR_TPSZ_CD = (SELECT CNTR_TPSZ_CD FROM MST_CONTAINER WHERE CNTR_NO = @[cntr_no]))" ).append("\n"); 
		query.append("                END TWGT" ).append("\n"); 
		query.append("              ,NVL(B.WGT_UT_CD, 'KGS') AS WGT_UNIT" ).append("\n"); 
		query.append("          FROM BKG_BOOKING              BKG" ).append("\n"); 
		query.append("              ,BKG_EUR_TRO              EUR" ).append("\n"); 
		query.append("              ,BKG_RF_CGO               RF" ).append("\n"); 
		query.append("              ,BKG_AWK_CGO              AWK" ).append("\n"); 
		query.append("              ,MDM_COMMODITY            M" ).append("\n"); 
		query.append("              ,MDM_CNTR_TP_SZ           S" ).append("\n"); 
		query.append("              ,COM_INTG_CD_DTL          C" ).append("\n"); 
		query.append("              ,BKG_CONTAINER            B" ).append("\n"); 
		query.append("              , (SELECT COP_NO , BKG_NO, CNTR_NO, COP_STS_CD" ).append("\n"); 
		query.append("                  FROM SCE_COP_HDR SCHC" ).append("\n"); 
		query.append("           		 WHERE  SCHC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            	   AND  SCHC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("            	   AND  SCHC.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("            	   AND ROWNUM =1 ) COP" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("           AND B.BKG_NO = EUR.BKG_NO(+)" ).append("\n"); 
		query.append("           AND B.CNTR_NO = EUR.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND EUR.HLG_TP_CD(+) = 'M'" ).append("\n"); 
		query.append("           AND EUR.CXL_FLG(+) = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${gubun} == 'BKG') " ).append("\n"); 
		query.append("           AND EUR.IO_BND_CD (+) ='I' --------------------------if(gubun)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("           AND EUR.IO_BND_CD (+) ='O' --------------------------if(gubun)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND B.BKG_NO = RF.BKG_NO(+)" ).append("\n"); 
		query.append("           AND B.CNTR_NO = RF.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND B.BKG_NO = AWK.BKG_NO(+)" ).append("\n"); 
		query.append("           AND B.CNTR_NO = AWK.CNTR_NO(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND BKG.CMDT_CD = M.CMDT_CD(+)" ).append("\n"); 
		query.append("           AND AWK.CNTR_TPSZ_CD = S.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("           AND AWK.WGT_UT_CD = C.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("           AND C.INTG_CD_ID(+) = 'CD00582'" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND B.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("	       AND B.BKG_NO = COP.BKG_NO (+)" ).append("\n"); 
		query.append("	       AND B.CNTR_NO = COP.CNTR_NO (+)" ).append("\n"); 
		query.append("	       AND COP.COP_STS_CD (+) <> 'X'" ).append("\n"); 
		query.append(") T" ).append("\n"); 

	}
}