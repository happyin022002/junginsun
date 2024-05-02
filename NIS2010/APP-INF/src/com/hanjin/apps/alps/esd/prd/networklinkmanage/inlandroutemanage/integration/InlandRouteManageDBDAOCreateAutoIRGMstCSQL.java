/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InlandRouteManageDBDAOCreateAutoIRGMstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.23
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.05.23 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOCreateAutoIRGMstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * inland route를 생성해야 할 것의 마스터 정보를 생성
	  * </pre>
	  */
	public InlandRouteManageDBDAOCreateAutoIRGMstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration ").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOCreateAutoIRGMstCSQL").append("\n"); 
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
		query.append("INSERT INTO PRD_INLND_ROUT_MST" ).append("\n"); 
		query.append("( " ).append("\n"); 
		query.append("      ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("    , ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("    , ROUT_SEQ" ).append("\n"); 
		query.append("    , PRIO_SEQ" ).append("\n"); 
		query.append("    , INLND_ROUT_BKG_FLG" ).append("\n"); 
		query.append("    , PCTL_IO_BND_CD" ).append("\n"); 
		query.append("    , CRE_OFC_CD" ).append("\n"); 
		query.append("    , INLND_ROUT_TMP_FLG" ).append("\n"); 
		query.append("    , DELT_FLG" ).append("\n"); 
		query.append("    , HUB_NOD_CD" ).append("\n"); 
		query.append("    , TRSP_MOD_CD" ).append("\n"); 
		query.append("    , FULL_RTN_YD_CD" ).append("\n"); 
		query.append("    , FULL_PKUP_YD_CD" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append("    , AUTO_IRG_FLG" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT SUBQ.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("     , SUBQ.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("     , TO_NUMBER(@[rout_seq]) AS ROUT_SEQ" ).append("\n"); 
		query.append("     , 9999 AS PRIOR_SEQ  -- 가장 낮은 값을 기본으로 한다.(Park Mangeon 20100713)" ).append("\n"); 
		query.append("     , 'N' AS INLND_ROUT_BKG_FLG" ).append("\n"); 
		query.append("     , SUBQ.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("     , @[ofc_cd]" ).append("\n"); 
		query.append("     , 'Y' AS INLND_ROUT_TMP_FLG" ).append("\n"); 
		query.append("     , 'N' AS DELT_FLG" ).append("\n"); 
		query.append("     , (SELECT HLOC.HUB_LOC_CD" ).append("\n"); 
		query.append("         FROM PRD_HUB_LOC_MTCH HLOC" ).append("\n"); 
		query.append("        WHERE HLOC.PORT_CD = SUBSTR(DECODE(PCTL_IO_BND_CD, 'O', SUBQ.ROUT_DEST_NOD_CD, SUBQ.ROUT_ORG_NOD_CD), 1,5)" ).append("\n"); 
		query.append("          AND HLOC.LOC_CD = SUBSTR(DECODE(PCTL_IO_BND_CD, 'O', SUBQ.ROUT_ORG_NOD_CD, SUBQ.ROUT_DEST_NOD_CD), 1,5)" ).append("\n"); 
		query.append("        ) AS HUB_NOD_CD" ).append("\n"); 
		query.append("     , SUBQ.TRSP_MOD_CD" ).append("\n"); 
		query.append("     , SUBQ.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("     , SUBQ.FULL_PKUP_YD_CD" ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[usr_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , 'Y'" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("       SELECT MAX(RDTL.ROUT_ORG_NOD_CD) AS ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("             , MAX(RDTL.ROUT_DEST_NOD_CD) AS ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("             , RDTL.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("             , DECODE( MAX(DECODE(ERNK.TRSP_MOD_CD, 'TD', 100, 0))" ).append("\n"); 
		query.append("                     + MAX(DECODE(ERNK.TRSP_MOD_CD, 'RD',  10, 0))" ).append("\n"); 
		query.append("                     + MAX(DECODE(ERNK.TRSP_MOD_CD, 'WD',   1, 0))" ).append("\n"); 
		query.append("                     , 111, 'TR' -- 모델에 없는 경우로 해당 경우 TR로 임시처리 (Park Mangeon 20100713)" ).append("\n"); 
		query.append("                     , 110, 'TR', 101, 'TW', 100, 'TD'" ).append("\n"); 
		query.append("                     ,  11, 'RW',  10, 'RD'" ).append("\n"); 
		query.append("                     ,   1, 'WD', NULL ) AS TRSP_MOD_CD" ).append("\n"); 
		query.append("             , SUBSTR(MIN(LPAD(RDTL.PCTL_SEQ, 3, ' ') || RDTL.ORG_NOD_CD ),4, 7) AS FULL_RTN_YD_CD" ).append("\n"); 
		query.append("             , SUBSTR(MAX(LPAD(RDTL.PCTL_SEQ, 3, ' ') || RDTL.DEST_NOD_CD), 4,7) AS FULL_PKUP_YD_CD" ).append("\n"); 
		query.append("        FROM PRD_PROD_CTL_ROUT_DTL RDTL" ).append("\n"); 
		query.append("           , PRD_INLND_EACH_LNK ERNK" ).append("\n"); 
		query.append("        WHERE ( RDTL.PCTL_NO, RDTL.PCTL_SEQ )" ).append("\n"); 
		query.append("                 IN (SELECT PCTL_NO, PCTL_SEQ" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                        SELECT RDTL.PCTL_NO, RDTL.PCTL_SEQ" ).append("\n"); 
		query.append("                             , MIN(DECODE(RDTL.ROUT_ORG_NOD_CD, RDTL.ORG_NOD_CD, RDTL.PCTL_SEQ)) OVER (PARTITION BY RDTL.PCTL_IO_BND_CD) SEQ_FM" ).append("\n"); 
		query.append("                             , MAX(DECODE(RDTL.ROUT_DEST_NOD_CD, RDTL.DEST_NOD_CD, RDTL.PCTL_SEQ)) OVER (PARTITION BY RDTL.PCTL_IO_BND_CD) SEQ_TO" ).append("\n"); 
		query.append("                         FROM PRD_PROD_CTL_ROUT_DTL RDTL" ).append("\n"); 
		query.append("                         WHERE RDTL.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                         AND RDTL.PCTL_IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("                         AND RDTL.TRSP_MOD_CD <> 'X'" ).append("\n"); 
		query.append("                         AND RDTL.ROUT_SEQ = -1 )-- 향후 Sequence 반영을 감안해 999999999에서 -1로 대체함" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                       WHERE PCTL_SEQ BETWEEN SEQ_FM AND SEQ_TO )" ).append("\n"); 
		query.append("         AND PCTL_IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("         AND RDTL.TRSP_MOD_CD <> 'X'" ).append("\n"); 
		query.append("         AND ERNK.LNK_ORG_NOD_CD(+) = RDTL.ORG_NOD_CD" ).append("\n"); 
		query.append("         AND ERNK.LNK_DEST_NOD_CD(+) = RDTL.DEST_NOD_CD" ).append("\n"); 
		query.append("         AND ERNK.TRSP_MOD_CD(+) = RDTL.TRSP_MOD_CD" ).append("\n"); 
		query.append("         GROUP BY RDTL.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("     ) SUBQ" ).append("\n"); 

	}
}