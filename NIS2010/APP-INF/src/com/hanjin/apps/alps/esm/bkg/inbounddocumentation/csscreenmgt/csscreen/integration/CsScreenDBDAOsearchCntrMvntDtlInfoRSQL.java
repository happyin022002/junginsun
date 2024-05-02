/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CsScreenDBDAOsearchCntrMvntDtlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.16
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.10.16 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchCntrMvntDtlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Estimate + Actual Container Movement Detail 정보를 조회한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchCntrMvntDtlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchCntrMvntDtlInfoRSQL").append("\n"); 
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
		query.append("SELECT  STS_NM       " ).append("\n"); 
		query.append("       ,EVENT_DT     " ).append("\n"); 
		query.append("       ,ACT_NM       " ).append("\n"); 
		query.append("       ,LOC_CD       " ).append("\n"); 
		query.append("       ,VVD          " ).append("\n"); 
		query.append("       ,SEAL_NO      " ).append("\n"); 
		query.append("       ,MSG          " ).append("\n"); 
		query.append("       ,BL_NO        " ).append("\n"); 
		query.append("       ,UPD_DT       " ).append("\n"); 
		query.append("       ,CNTR_NO      " ).append("\n"); 
		query.append("       ,FCUS_FLG    " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("     -- ACTUAL --                                                                                                                              " ).append("\n"); 
		query.append("     SELECT  MAIN.STS_NM                AS STS_NM                                                                                              " ).append("\n"); 
		query.append("            ,MAIN.EVENT_DT             AS EVENT_DT                                                                                             " ).append("\n"); 
		query.append("            ,MAIN.ACT_NM                AS ACT_NM                                                                                              " ).append("\n"); 
		query.append("            ,MAIN.LOC_CD                 AS LOC_CD                                                                                             " ).append("\n"); 
		query.append("            ,MAIN.VVD || DECODE( MAIN.MVMT_STS_CD,'VD', CHR(13)||CHR(10)||'('||BPLN.BAY||BPLN.ROWW||BPLN.TIER||')',          " ).append("\n"); 
		query.append("                                                  'VL', CHR(13)||CHR(10)||'('||BPLN.BAY||BPLN.ROWW||BPLN.TIER||')','') AS VVD" ).append("\n"); 
		query.append("            ,MAIN.SEAL_NO                AS SEAL_NO                                                                                            " ).append("\n"); 
		query.append("            ,MAIN.MSG                     AS MSG                                                                                               " ).append("\n"); 
		query.append("            ,MAIN.BL_NO                  AS BL_NO                                                                                              " ).append("\n"); 
		query.append("            ,MAIN.UPD_DT              AS UPD_DT                                                                                                " ).append("\n"); 
		query.append("            ,MAIN.CNTR_NO             AS CNTR_NO                                                                                               " ).append("\n"); 
		query.append("            ,MAIN.FCUS_FLG            AS FCUS_FLG                                                                   " ).append("\n"); 
		query.append("     FROM (  SELECT STS_NM        " ).append("\n"); 
		query.append("      		   ,EVENT_DT    " ).append("\n"); 
		query.append("                   ,POD_CD			     " ).append("\n"); 
		query.append("                   ,ACT_NM        " ).append("\n"); 
		query.append("                   ,LOC_CD        " ).append("\n"); 
		query.append("                   ,VVD           " ).append("\n"); 
		query.append("                   ,SEAL_NO       " ).append("\n"); 
		query.append("                   ,MSG           " ).append("\n"); 
		query.append("                   ,BL_NO         " ).append("\n"); 
		query.append("                   ,UPD_DT        " ).append("\n"); 
		query.append("                   ,CNTR_NO       " ).append("\n"); 
		query.append("                   ,MVMT_STS_CD   " ).append("\n"); 
		query.append("                   ,DECODE(RNUM,1,'Y','N')    AS FCUS_FLG     " ).append("\n"); 
		query.append("			 FROM" ).append("\n"); 
		query.append("			 (           " ).append("\n"); 
		query.append("			     SELECT 'Actual'                                                    AS STS_NM  " ).append("\n"); 
		query.append("			            ,BKGM.POD_CD                                                AS POD_CD                                                        " ).append("\n"); 
		query.append("			            ,MVNT.CNMV_EVNT_DT                                          AS EVENT_DT                                                     " ).append("\n"); 
		query.append("			            ,STS.MVMT_STS_NM                                            AS ACT_NM                                                       " ).append("\n"); 
		query.append("			            ,DECODE(MVNT.MVMT_STS_CD,'TN',MVNT.DEST_YD_CD,                                                                             " ).append("\n"); 
		query.append("			                                     'EN',MVNT.DEST_YD_CD,                                                                             " ).append("\n"); 
		query.append("			                                          MVNT.ORG_YD_CD )              AS LOC_CD                                                       " ).append("\n"); 
		query.append("			           	,MVNT.CRNT_VSL_CD||                                                                                                        " ).append("\n"); 
		query.append("			            	 MVNT.CRNT_SKD_VOY_NO||                                                                                                    " ).append("\n"); 
		query.append("			            	 MVNT.CRNT_SKD_DIR_CD                                      AS VVD                                                          " ).append("\n"); 
		query.append("			           	,MVNT.CNTR_SEAL_NO                                          AS SEAL_NO                                                      " ).append("\n"); 
		query.append("			           	,MVNT.MVMT_EDI_MSG_TP_ID                                    AS MSG                                                          " ).append("\n"); 
		query.append("			           	,MVNT.BL_NO                                                 AS BL_NO                                                        " ).append("\n"); 
		query.append("			           	,MVNT.UPD_DT                                                AS UPD_DT                                                       " ).append("\n"); 
		query.append("			           	,MVNT.CNTR_NO                                               AS CNTR_NO                                                      " ).append("\n"); 
		query.append("			           	,MVNT.MVMT_STS_CD                                           AS MVMT_STS_CD                                                  " ).append("\n"); 
		query.append("			           	,ROW_NUMBER() OVER (PARTITION BY MVNT.BKG_NO,MVNT.CNTR_NO " ).append("\n"); 
		query.append("			                       			ORDER BY MVNT.CNMV_YR DESC" ).append("\n"); 
		query.append("			                       			        ,MVNT.CNMV_ID_NO DESC" ).append("\n"); 
		query.append("			                       			        ,MVNT.CNMV_SEQ DESC)            AS RNUM                                              " ).append("\n"); 
		query.append("			     FROM BKG_BOOKING BKGM" ).append("\n"); 
		query.append("			         ,BKG_CONTAINER BCNTR                                                                                                       " ).append("\n"); 
		query.append("			         ,CTM_MOVEMENT MVNT                                                                                                         " ).append("\n"); 
		query.append("			         ,MDM_MVMT_STS STS                                                                                                          " ).append("\n"); 
		query.append("			     WHERE BKGM.BKG_NO       =  @[bkg_no]   " ).append("\n"); 
		query.append("			       AND BKGM.BKG_NO       = BCNTR.BKG_NO" ).append("\n"); 
		query.append("			       AND MVNT.CNTR_NO      = BCNTR.CNTR_NO  " ).append("\n"); 
		query.append("			       AND MVNT.BKG_NO       LIKE SUBSTR(BCNTR.BKG_NO,1,10) ||'%'                             " ).append("\n"); 
		query.append("			       AND MVNT.MVMT_STS_CD  = STS.MVMT_STS_CD" ).append("\n"); 
		query.append("			 ) WHERE 1=1" ).append("\n"); 
		query.append("			   ORDER BY  RNUM DESC  ) MAIN                                                                                  " ).append("\n"); 
		query.append("             ,BAY_PLAN BPLN                                                                                                                " ).append("\n"); 
		query.append("     WHERE  BPLN.VSL_CD(+)      = SUBSTR(MAIN.VVD,1,4)                                                                                     " ).append("\n"); 
		query.append("        AND BPLN.VOY_NO(+)      = SUBSTR(MAIN.VVD,5,4)                                                                                     " ).append("\n"); 
		query.append("        AND BPLN.DIR_CD(+)      = SUBSTR(MAIN.VVD,9,1)                                                                                     " ).append("\n"); 
		query.append("        AND BPLN.ID(+)          = MAIN.CNTR_NO                                                                                             " ).append("\n"); 
		query.append("        AND BPLN.POD(+)         = MAIN.POD_CD    " ).append("\n"); 
		query.append("     UNION ALL                                                                                                                                 " ).append("\n"); 
		query.append("     -- EATIMATED --                                                                                                                           " ).append("\n"); 
		query.append("     SELECT /*+ INDEX_ASC(DTL XPKSCE_COP_DTL) */                                                                                               " ).append("\n"); 
		query.append("            'Estimate'                      AS STS_NM                                                                                          " ).append("\n"); 
		query.append("           ,(CASE WHEN TO_CHAR(dtl.ESTM_DT,'mi') >= '01' AND TO_CHAR(dtl.ESTM_DT,'mi') <= '30' " ).append("\n"); 
		query.append("                  THEN dtl.ESTM_DT + NUMTODSINTERVAL(30 - TO_NUMBER(TO_CHAR(dtl.ESTM_DT,'mi')), 'MINUTE') " ).append("\n"); 
		query.append("                  WHEN TO_CHAR(dtl.ESTM_DT,'mi') >= '31' AND TO_CHAR(dtl.ESTM_DT,'mi') <= '59' " ).append("\n"); 
		query.append("                  THEN dtl.ESTM_DT + NUMTODSINTERVAL(60 - TO_NUMBER(TO_CHAR(dtl.ESTM_DT,'mi')),'MINUTE') " ).append("\n"); 
		query.append("                  ELSE dtl.ESTM_DT " ).append("\n"); 
		query.append("             END) EVENT_DT                                                                                        " ).append("\n"); 
		query.append("           ,ACT.ACT_NM                      AS ACT_NM                                                                                          " ).append("\n"); 
		query.append("           ,DTL.NOD_CD                      AS LOC_CD                                                                                          " ).append("\n"); 
		query.append("           ,''                              AS VVD                                                                                             " ).append("\n"); 
		query.append("           ,''                              AS SEAL_NO                                                                                         " ).append("\n"); 
		query.append("           ,''                              AS MSG                                                                                             " ).append("\n"); 
		query.append("           ,BKG.BL_NO                       AS BL_NO                                                                                           " ).append("\n"); 
		query.append("           ,NVL(DTL.UPD_DT,'')              AS UPD_DT                                                                                          " ).append("\n"); 
		query.append("           ,HDR.CNTR_NO                     AS CNTR_NO                                                                                         " ).append("\n"); 
		query.append("           ,'N'                             AS FCUS_FLG                                                                                        " ).append("\n"); 
		query.append("     FROM  SCE_COP_HDR       HDR,                                                                                                              " ).append("\n"); 
		query.append("           SCE_COP_DTL       DTL,                                                                                                              " ).append("\n"); 
		query.append("           BKG_BOOKING       BKG,                                                                                                              " ).append("\n"); 
		query.append("           MDM_ACTIVITY      ACT                                                                                                               " ).append("\n"); 
		query.append("     WHERE HDR.BKG_NO      = @[bkg_no]                                                                                                         " ).append("\n"); 
		query.append("       AND HDR.CNTR_NO     IN (SELECT CNTR_NO                                                                                                  " ).append("\n"); 
		query.append("                                 FROM BKG_CONTAINER                                                                                            " ).append("\n"); 
		query.append("                                WHERE BKG_NO      = @[bkg_no])                                                                                 " ).append("\n"); 
		query.append("       AND HDR.COP_NO      = DTL.COP_NO                                                                                                        " ).append("\n"); 
		query.append("       AND HDR.COP_STS_CD  <> 'X'                                                                                                              " ).append("\n"); 
		query.append("       AND DTL.ACT_STS_CD  IN ( 'C','N')                                                                                                       " ).append("\n"); 
		query.append("       AND HDR.BKG_NO      = BKG.BKG_NO                                                                                                        " ).append("\n"); 
		query.append("       AND  DTL.ACT_CD     = ACT.ACT_CD        " ).append("\n"); 
		query.append(") ORDER BY STS_NM, EVENT_DT ASC" ).append("\n"); 

	}
}