/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : FACAuditDBDAOSearchFACCommListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.facommaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FACAuditDBDAOSearchFACCommListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchFACCommList
	  * </pre>
	  */
	public FACAuditDBDAOSearchFACCommListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("date_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ff_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmaudit.facommaudit.integration").append("\n"); 
		query.append("FileName : FACAuditDBDAOSearchFACCommListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      A.FAC_SEQ," ).append("\n"); 
		query.append("      CASE" ).append("\n"); 
		query.append("      WHEN A.BKG_FF_CNT_CD = ''" ).append("\n"); 
		query.append("        OR A.BKG_FF_CNT_CD = '*'" ).append("\n"); 
		query.append("      THEN ''" ).append("\n"); 
		query.append("      ELSE CONCAT(A.BKG_FF_CNT_CD, TO_CHAR (A.BKG_FF_SEQ, 'FM000000'))				" ).append("\n"); 
		query.append("       END                                                           AS FF_CNT_SEQ,				" ).append("\n"); 
		query.append("         (     SELECT				" ).append("\n"); 
		query.append("                      MAX (NVL (LTRIM (C.CUST_LGL_ENG_NM), ' '))				" ).append("\n"); 
		query.append("                 FROM MDM_CUSTOMER          C				" ).append("\n"); 
		query.append("                WHERE C.CUST_CNT_CD(+)      = A.BKG_FF_CNT_CD				" ).append("\n"); 
		query.append("                  AND C.CUST_SEQ(+)         = A.BKG_FF_SEQ				" ).append("\n"); 
		query.append("                  AND C.CNTR_DIV_FLG(+)     = 'Y'				" ).append("\n"); 
		query.append("         )                                                           AS CUST_LGL_ENG_NM,				" ).append("\n"); 
		query.append("           A.BKG_NO                                                  AS BKG_NO,				" ).append("\n"); 
		query.append("         (     SELECT				" ).append("\n"); 
		query.append("                    MAX (NVL (B.BL_NO, ' '))				" ).append("\n"); 
		query.append("             FROM ACM_AGN_BKG_INFO     B				" ).append("\n"); 
		query.append("            WHERE B.BKG_NO              = A.BKG_NO				" ).append("\n"); 
		query.append("         )                                                           AS BL_NO,				" ).append("\n"); 
		query.append("		(     SELECT		" ).append("\n"); 
		query.append("		MAX (NVL (B.BKG_STS_CD, ' '))		" ).append("\n"); 
		query.append("		FROM BKG_BOOKING     B		" ).append("\n"); 
		query.append("		WHERE B.BKG_NO              = A.BKG_NO		" ).append("\n"); 
		query.append("		)                                                       AS BKG_STS_CD, 		" ).append("\n"); 
		query.append("      A.FAC_VSL_CD|| A.FAC_SKD_VOY_NO|| A.FAC_SKD_DIR_CD|| A.FAC_REV_DIR_CD AS VVD,				" ).append("\n"); 
		query.append("      TO_CHAR (A.VSL_DEP_DT, 'YYYYMMDD')                        AS VSL_DEP_DT,				" ).append("\n"); 
		query.append("      CASE				" ).append("\n"); 
		query.append("      WHEN SUBSTR (A.FAC_DIV_CD, 1, 1) = 'B'				" ).append("\n"); 
		query.append("       AND A.FAC_DIV_CD = 'BL'				" ).append("\n"); 
		query.append("      THEN A.CRNT_AMT				" ).append("\n"); 
		query.append("      ELSE 0				" ).append("\n"); 
		query.append("       END                                                      AS BL_CRNT_AMT,				" ).append("\n"); 
		query.append("      A.CURR_CD,				" ).append("\n"); 
		query.append("      CASE				" ).append("\n"); 
		query.append("      WHEN SUBSTR (A.FAC_DIV_CD, 1, 1) = 'B'				" ).append("\n"); 
		query.append("       AND A.FAC_DIV_CD <> 'BL'				" ).append("\n"); 
		query.append("      THEN A.CRNT_AMT				" ).append("\n"); 
		query.append("      WHEN A.FAC_DIV_CD = 'DR'				" ).append("\n"); 
		query.append("      THEN A.CRNT_AMT				" ).append("\n"); 
		query.append("      ELSE 0				" ).append("\n"); 
		query.append("       END                                                           AS CRNT_AMT,				" ).append("\n"); 
		query.append("           NVL (A.BKG_BX_QTY, 0)                                     AS BKG_BX_QTY,				" ).append("\n"); 
		query.append("           NVL (A.FAC_BX_AMT, 0)                                     AS FAC_BX_AMT,				" ).append("\n"); 
		query.append("           NVL (A.BKG_DRY_TEU_QTY, 0)                                AS BKG_DRY_TEU_QTY,				" ).append("\n"); 
		query.append("           NVL (A.FAC_DRY_TEU_AMT, 0)                                AS FAC_DRY_TEU_AMT,				" ).append("\n"); 
		query.append("           NVL (A.BKG_DRY_FEU_QTY, 0)                                AS BKG_DRY_FEU_QTY,				" ).append("\n"); 
		query.append("           NVL (A.FAC_DRY_FEU_AMT, 0)                                AS FAC_DRY_FEU_AMT,				" ).append("\n"); 
		query.append("           NVL (A.BKG_RF_TEU_QTY, 0)                                 AS BKG_RF_TEU_QTY,				" ).append("\n"); 
		query.append("           NVL (A.FAC_RF_TEU_AMT, 0)                                 AS FAC_RF_TEU_AMT,				" ).append("\n"); 
		query.append("           NVL (A.BKG_RF_FEU_QTY, 0)                                 AS BKG_RF_FEU_QTY,				" ).append("\n"); 
		query.append("           NVL (A.FAC_RF_FEU_AMT, 0)                                 AS FAC_RF_FEU_AMT,				" ).append("\n"); 
		query.append("           NVL (A.BKG_SPCL_TEU_QTY, 0)                               AS BKG_SPCL_TEU_QTY,				" ).append("\n"); 
		query.append("           NVL (A.FAC_SPCL_TEU_AMT, 0)                               AS FAC_SPCL_TEU_AMT,				" ).append("\n"); 
		query.append("           NVL (A.BKG_SPCL_FEU_QTY, 0)                               AS BKG_SPCL_FEU_QTY,				" ).append("\n"); 
		query.append("           NVL (A.FAC_SPCL_FEU_AMT, 0)                               AS FAC_SPCL_FEU_AMT,				" ).append("\n"); 
		query.append("      CASE SUBSTR (A.FAC_DIV_CD, 1, 1)				" ).append("\n"); 
		query.append("      WHEN 'C'				" ).append("\n"); 
		query.append("      THEN A.CRNT_AMT				" ).append("\n"); 
		query.append("      ELSE 0				" ).append("\n"); 
		query.append("       END                                                  AS CNTR_CRNT_AMT,				" ).append("\n"); 
		query.append("           NVL (A.PPD_AMT, 0)                               AS PPD_AMT,				" ).append("\n"); 
		query.append("           NVL (A.IF_AMT, 0)                                AS IF_AMT,				" ).append("\n"); 
		query.append("           NVL (A.FAC_STS_CD, ' ')                          AS FAC_STS_CD,				" ).append("\n"); 
		query.append("           NVL(A.FAC_RMK,(SELECT COMM_PROC_RSLT_RSN FROM ACM_AGN_BKG_INFO WHERE BKG_NO = A.BKG_NO)) AS FAC_RMK,				" ).append("\n"); 
		query.append("           NVL (TO_CHAR (A.IF_DT, 'YYYYMMDD'), ' ')         AS IF_DT,				" ).append("\n"); 
		query.append("           A.SLS_OFC_CD,				" ).append("\n"); 
		query.append("           A.BKG_NO,				" ).append("\n"); 
		query.append("           A.FAC_OFC_CD,				" ).append("\n"); 
		query.append("           A.FF_CNT_CD,				" ).append("\n"); 
		query.append("           A.FF_SEQ,				" ).append("\n"); 
		query.append("           A.FAC_AGMT_SEQ,				" ).append("\n"); 
		query.append("           A.FAC_DIV_CD,				" ).append("\n"); 
		query.append("           SUBSTR (A.FAC_DIV_CD, 1, 1)                      AS FAC_DIV_CD_1,				" ).append("\n"); 
		query.append("           A.CRNT_AMT                                       AS OLD_CRNT_AMT				" ).append("\n"); 
		query.append("      FROM ACM_FAC_COMM A,				" ).append("\n"); 
		query.append("         (     SELECT				" ).append("\n"); 
		query.append("                      A.BKG_NO,				" ).append("\n"); 
		query.append("                      MIN (A.FAC_SEQ)     AS FAC_SEQ				" ).append("\n"); 
		query.append("                 FROM ACM_FAC_COMM         A				" ).append("\n"); 
		query.append("                WHERE 1=1			" ).append("\n"); 
		query.append("#if(${date_div} == 'E' && ${bl_no} == '')				" ).append("\n"); 
		query.append("                  AND A.VSL_DEP_DT				" ).append("\n"); 
		query.append("                         BETWEEN TO_DATE (NVL(REPLACE(@[date_fm],'-',''), '19000101'), 'YYYYMMDD')				" ).append("\n"); 
		query.append("                             AND TO_DATE (NVL(REPLACE(@[date_to],'-',''), '29990101'), 'YYYYMMDD')+0.99999				" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ofc_option} == 'A')" ).append("\n"); 
		query.append("AND A.AR_OFC_CD  = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.SLS_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ff_cnt_seq} != '')				" ).append("\n"); 
		query.append("                  AND A.BKG_FF_CNT_CD     = SUBSTR(@[ff_cnt_seq], 1, 2)				" ).append("\n"); 
		query.append("                  AND A.BKG_FF_SEQ        = SUBSTR(@[ff_cnt_seq], 3)				" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("#if(${curr_cd} != '')				" ).append("\n"); 
		query.append("                  AND A.CURR_CD             = @[curr_cd]				" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("#if(${vvd_cd} != '')				" ).append("\n"); 
		query.append("                  AND				" ).append("\n"); 
		query.append("                    ( A.FAC_VSL_CD 				" ).append("\n"); 
		query.append("                   || A.FAC_SKD_VOY_NO				" ).append("\n"); 
		query.append("                   || A.FAC_SKD_DIR_CD				" ).append("\n"); 
		query.append("                   || A.FAC_REV_DIR_CD				" ).append("\n"); 
		query.append("                    )				" ).append("\n"); 
		query.append("                    IN				" ).append("\n"); 
		query.append("                    ( 				" ).append("\n"); 
		query.append("                        ${vvd_cd}				" ).append("\n"); 
		query.append("                    )				" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("#if( ${bl_no} != '' || ${date_div} == 'C')				" ).append("\n"); 
		query.append("                  AND A.BKG_NO				" ).append("\n"); 
		query.append("                   IN				" ).append("\n"); 
		query.append("                    (     SELECT				" ).append("\n"); 
		query.append("                                 BKG_NO				" ).append("\n"); 
		query.append("                            FROM ACM_AGN_BKG_INFO				" ).append("\n"); 
		query.append("                           WHERE 1=1				" ).append("\n"); 
		query.append("#if( ${bl_no} != '')				" ).append("\n"); 
		query.append("                             AND BL_NO				" ).append("\n"); 
		query.append("                              IN" ).append("\n"); 
		query.append("                               (${bl_no})" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("#if(${date_div} == 'C' && ${bl_no} == '')" ).append("\n"); 
		query.append("                             AND BKG_CRE_DT				" ).append("\n"); 
		query.append("                         BETWEEN TO_DATE (NVL(REPLACE(@[date_fm],'-',''), '19000101'), 'YYYYMMDD')---?				" ).append("\n"); 
		query.append("                             AND TO_DATE (NVL(REPLACE(@[date_to],'-',''), '29990101'), 'YYYYMMDD')+0.99999				" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("                   )				" ).append("\n"); 
		query.append("#end				" ).append("\n"); 
		query.append("             GROUP BY A.BKG_NO				" ).append("\n"); 
		query.append("         )                       B				" ).append("\n"); 
		query.append("     WHERE A.BKG_NO              = B.BKG_NO				" ).append("\n"); 
		query.append("       AND A.FAC_SEQ             = B.FAC_SEQ				" ).append("\n"); 
		query.append("  ORDER BY CONCAT (A.FF_CNT_CD, A.FF_SEQ),				" ).append("\n"); 
		query.append("           CUST_LGL_ENG_NM" ).append("\n"); 

	}
}