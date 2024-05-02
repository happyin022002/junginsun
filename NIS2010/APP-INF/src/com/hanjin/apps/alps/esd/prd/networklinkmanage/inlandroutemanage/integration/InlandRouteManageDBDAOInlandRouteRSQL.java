/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : InlandRouteManageDBDAOInlandRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOInlandRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * inland select
	  * </pre>
	  */
	public InlandRouteManageDBDAOInlandRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_org_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r_inbound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOInlandRouteRSQL").append("\n"); 
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
		query.append("SELECT ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, RN, INLND_ROUT_OPTM_FLG, INLND_ROUT_BKG_FLG  , INLND_ROUT_TMP_FLG,INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("       ORG_LOC,  ORG_LOC_TYPE," ).append("\n"); 
		query.append("       DEST_LOC,  DEST_LOC_TYPE," ).append("\n"); 
		query.append("       ROUT_SEQ, NVL(PRIO_SEQ,0) PRIO_SEQ, ROUTE," ).append("\n"); 
		query.append("       SUM_TT_TIME, SUM_DW_TT ," ).append("\n"); 
		query.append("       LTRIM(TO_CHAR(TRUNC(TOT_TT/24,0),'00'))||LTRIM(TO_CHAR(MOD(TOT_TT,24  ),'00'))  TOT_TT," ).append("\n"); 
		query.append("       PCTL_IO_BND_CD," ).append("\n"); 
		query.append("       N1ST_NOD_CD,N1ST_TRSP_MOD_CD,N1ST_VNDR_SEQ,N1ST_VNDR_NM,N1ST_AGMT_NO,N1ST_AGMT_CRE_OFC_CD,N1ST_AGMT_REF_NO," ).append("\n"); 
		query.append("       N2ND_NOD_CD,N2ND_TRSP_MOD_CD,N2ND_VNDR_SEQ,N2ND_VNDR_NM,N2ND_AGMT_NO,N2ND_AGMT_CRE_OFC_CD,N2ND_AGMT_REF_NO," ).append("\n"); 
		query.append("       N3RD_NOD_CD,N3RD_TRSP_MOD_CD,N3RD_VNDR_SEQ,N3RD_VNDR_NM,N3RD_AGMT_NO,N3RD_AGMT_CRE_OFC_CD,N3RD_AGMT_REF_NO," ).append("\n"); 
		query.append("       N4TH_NOD_CD,N4TH_TRSP_MOD_CD,N4TH_VNDR_SEQ,N4TH_VNDR_NM,N4TH_AGMT_NO,N4TH_AGMT_CRE_OFC_CD,N4TH_AGMT_REF_NO," ).append("\n"); 
		query.append("       N5TH_NOD_CD,N5TH_TRSP_MOD_CD,N5TH_VNDR_SEQ,N5TH_VNDR_NM,N5TH_AGMT_NO,N5TH_AGMT_CRE_OFC_CD,N5TH_AGMT_REF_NO," ).append("\n"); 
		query.append("       N6TH_NOD_CD,N6TH_TRSP_MOD_CD,N6TH_VNDR_SEQ,N6TH_VNDR_NM,N6TH_AGMT_NO,N6TH_AGMT_CRE_OFC_CD,N6TH_AGMT_REF_NO,N7TH_NOD_CD," ).append("\n"); 
		query.append("       CRE_OFC_CD,TO_CHAR(CRE_DT,'YYYY-MM-DD') CRE_DT,INLND_ROUT_RMK, CNST_RMK, DECODE(CNST_RMK,NULL,'1','0') CNST_FLG ," ).append("\n"); 
		query.append("       '' HUB_SEARCH_GB, '' FRONT_GB , '' UNDEFINE_NOD," ).append("\n"); 
		query.append("       MAX(RN) OVER (PARTITION BY ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD  ORDER BY ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD) AS GROUP_GUBUN" ).append("\n"); 
		query.append("       ,ALTN_OPTM_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("      SELECT ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, INLND_ROUT_OPTM_FLG, INLND_ROUT_BKG_FLG ,INLND_ROUT_TMP_FLG ,ROWNUM RN, INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("           SUBSTR( ROUT_ORG_NOD_CD,1,5) ORG_LOC, SUBSTR( ROUT_ORG_NOD_CD,6) ORG_LOC_TYPE," ).append("\n"); 
		query.append("           SUBSTR( ROUT_DEST_NOD_CD,1,5) DEST_LOC, SUBSTR( ROUT_DEST_NOD_CD,6) DEST_LOC_TYPE," ).append("\n"); 
		query.append("           ROUT_SEQ, PRIO_SEQ, ROUTE," ).append("\n"); 
		query.append("           SUM_TT_TIME, SUM_DW_TT , (SUM_TT_TIME + SUM_DW_TT) TOT_TT," ).append("\n"); 
		query.append("           N1ST_NOD_CD,N1ST_TRSP_MOD_CD,N1ST_VNDR_SEQ,N1ST_VNDR_NM,N1ST_AGMT_NO,N1ST_AGMT_CRE_OFC_CD,N1ST_AGMT_REF_NO," ).append("\n"); 
		query.append("           N2ND_NOD_CD,N2ND_TRSP_MOD_CD,N2ND_VNDR_SEQ,N2ND_VNDR_NM,N2ND_AGMT_NO,N2ND_AGMT_CRE_OFC_CD,N2ND_AGMT_REF_NO," ).append("\n"); 
		query.append("           N3RD_NOD_CD,N3RD_TRSP_MOD_CD,N3RD_VNDR_SEQ,N3RD_VNDR_NM,N3RD_AGMT_NO,N3RD_AGMT_CRE_OFC_CD,N3RD_AGMT_REF_NO," ).append("\n"); 
		query.append("           N4TH_NOD_CD,N4TH_TRSP_MOD_CD,N4TH_VNDR_SEQ,N4TH_VNDR_NM,N4TH_AGMT_NO,N4TH_AGMT_CRE_OFC_CD,N4TH_AGMT_REF_NO," ).append("\n"); 
		query.append("           N5TH_NOD_CD,N5TH_TRSP_MOD_CD,N5TH_VNDR_SEQ,N5TH_VNDR_NM,N5TH_AGMT_NO,N5TH_AGMT_CRE_OFC_CD,N5TH_AGMT_REF_NO," ).append("\n"); 
		query.append("           N6TH_NOD_CD,N6TH_TRSP_MOD_CD,N6TH_VNDR_SEQ,N6TH_VNDR_NM,N6TH_AGMT_NO,N6TH_AGMT_CRE_OFC_CD,N6TH_AGMT_REF_NO,N7TH_NOD_CD," ).append("\n"); 
		query.append("           PCTL_IO_BND_CD, CRE_OFC_CD,CRE_DT,INLND_ROUT_RMK, CNST_RMK,ALTN_OPTM_FLG" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("             SELECT ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ, PRIO_SEQ ,INLND_ROUT_OPTM_FLG,INLND_ROUT_BKG_FLG ,INLND_ROUT_TMP_FLG ,INLND_ROUT_INCL_STTL_FLG" ).append("\n"); 
		query.append("                    ,ROUT_ORG_NOD_CD || ' ( ' ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,(DECODE(ROUT_DTL_SEQ ,1 , TRSP_MOD , ''  ))," ).append("\n"); 
		query.append("                                              (DECODE(ROUT_DTL_SEQ ,1 , TRSP_MOD , ''  ))) ) || ' ) ' ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,1 ,'', DECODE(ROUT_DTL_SEQ, 1 , '-'||LNK_DEST_NOD_CD || ' ( '))))     ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,2 , TRSP_MOD  || ' ) ', ''  ))) )  ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,2 ,'', DECODE(ROUT_DTL_SEQ, 2 , '-'||LNK_DEST_NOD_CD || ' ( '))))     ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,3 , TRSP_MOD || ' ) ', ''  ))) )   ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,3 ,'', DECODE(ROUT_DTL_SEQ, 3 , '-'||LNK_DEST_NOD_CD  || ' ( '))))    ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,4 , TRSP_MOD  || ' ) ', ''  ))) )  ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,4 ,'', DECODE(ROUT_DTL_SEQ, 4 , '-'||LNK_DEST_NOD_CD  || ' ( '))))    ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,5 , TRSP_MOD || ' ) ', ''  ))) )  ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,5 ,'', DECODE(ROUT_DTL_SEQ, 5 , '-'||LNK_DEST_NOD_CD  || ' ( '))))    ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,6 , TRSP_MOD || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,6 ,'', DECODE(ROUT_DTL_SEQ, 6 , '-'||LNK_DEST_NOD_CD  || ' ( ' ))))   ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,7 , TRSP_MOD || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,7 ,'', DECODE(ROUT_DTL_SEQ, 7 , '-'||LNK_DEST_NOD_CD  || ' ( '))))    ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,8 , TRSP_MOD || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,8 ,'', DECODE(ROUT_DTL_SEQ, 8 , '-'||LNK_DEST_NOD_CD  || ' ( '))))    ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,9 , TRSP_MOD || ' ) ' , ''  ))) )  ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,9 ,'', DECODE(ROUT_DTL_SEQ, 9 , '-'||LNK_DEST_NOD_CD  || ' ( '))))    ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,10, TRSP_MOD || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,10,'', DECODE(ROUT_DTL_SEQ, 10, '-'||LNK_DEST_NOD_CD || ' ( '))))     ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,11, TRSP_MOD || ' ) ' , ''  ))) )  ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,11,'', DECODE(ROUT_DTL_SEQ, 11, '-'||LNK_DEST_NOD_CD || ' ( '))))     ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,12, TRSP_MOD || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,12,'', DECODE(ROUT_DTL_SEQ, 12, '-'||LNK_DEST_NOD_CD || ' ( '))))     ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,13, TRSP_MOD || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,13,'', DECODE(ROUT_DTL_SEQ, 13, '-'||LNK_DEST_NOD_CD || ' ( '))))     ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,14, TRSP_MOD || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,14,'', DECODE(ROUT_DTL_SEQ, 14, '-'||LNK_DEST_NOD_CD  || ' ( '))))    ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,15, TRSP_MOD || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,15,'', DECODE(ROUT_DTL_SEQ, 15, '-'||LNK_DEST_NOD_CD || ' ( '))))     ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,16, TRSP_MOD || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,16,'', DECODE(ROUT_DTL_SEQ, 16, '-'||LNK_DEST_NOD_CD  || ' ( ' ))))   ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,17, TRSP_MOD || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,17,'', DECODE(ROUT_DTL_SEQ, 17, '-'||LNK_DEST_NOD_CD || ' ( '))))     ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,18, TRSP_MOD || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,18,'', DECODE(ROUT_DTL_SEQ, 18, '-'||LNK_DEST_NOD_CD || ' ( '))))     ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,19, TRSP_MOD || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,19,'', DECODE(ROUT_DTL_SEQ, 19, '-'||LNK_DEST_NOD_CD || ' ( '))))     ||" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , '' , (DECODE(ROUT_DTL_SEQ ,20, TRSP_MOD || ' ) ', ''  ))) )    ||" ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,'', DECODE(CNT,20,'', DECODE(ROUT_DTL_SEQ, 20, '-'||LNK_DEST_NOD_CD))))" ).append("\n"); 
		query.append("                    ||  '-'||ROUT_DEST_NOD_CD AS ROUTE" ).append("\n"); 
		query.append("                    , ROUT_ORG_NOD_CD AS POD0" ).append("\n"); 
		query.append("                    , ROUT_DEST_NOD_CD AS DEL, SUM_TT_TIME," ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 , DECODE(ROUT_DTL_SEQ ,1 , DEST_DW_TIME , 0  )," ).append("\n"); 
		query.append("                                            DECODE(ROUT_DTL_SEQ ,1 , DEST_DW_TIME, 0  )) )  +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,2 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,3 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,4 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,5 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,6 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,7 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,8 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,9 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,10 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,11 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,12 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,13 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,14 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,15 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,16 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,17 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,18 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,19 , DEST_DW_TIME, 0  )) )   +" ).append("\n"); 
		query.append("                    MAX(DECODE ( CNT,1 ,0, DECODE(ROUT_DTL_SEQ ,20 , DEST_DW_TIME, 0  )) )   SUM_DW_TT ," ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,1,LNK_ORG_NOD_CD)) N1ST_NOD_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,1,TRSP_MOD_CD)) N1ST_TRSP_MOD_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,1,VNDR_SEQ)) N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,1,VNDR_NM)) N1ST_VNDR_NM," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,1,AGMT_NO)) N1ST_AGMT_NO," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,1,AGMT_CRE_OFC_CD)) N1ST_AGMT_CRE_OFC_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,1,AGMT_REF_NO)) N1ST_AGMT_REF_NO," ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,1,ROUT_DEST_NOD_CD,DECODE(ROUT_DTL_SEQ,2,LNK_ORG_NOD_CD))) N2ND_NOD_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,2,TRSP_MOD_CD)) N2ND_TRSP_MOD_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,2,VNDR_SEQ)) N2ND_VNDR_SEQ," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,2,VNDR_NM)) N2ND_VNDR_NM," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,2,AGMT_NO)) N2ND_AGMT_NO," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,2,AGMT_CRE_OFC_CD)) N2ND_AGMT_CRE_OFC_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,2,AGMT_REF_NO)) N2ND_AGMT_REF_NO," ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,2,ROUT_DEST_NOD_CD,DECODE(ROUT_DTL_SEQ,3,LNK_ORG_NOD_CD))) N3RD_NOD_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,3,TRSP_MOD_CD)) N3RD_TRSP_MOD_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,3,VNDR_SEQ)) N3RD_VNDR_SEQ," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,3,VNDR_NM)) N3RD_VNDR_NM," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,3,AGMT_NO)) N3RD_AGMT_NO," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,3,AGMT_CRE_OFC_CD)) N3RD_AGMT_CRE_OFC_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,3,AGMT_REF_NO)) N3RD_AGMT_REF_NO," ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,3,ROUT_DEST_NOD_CD,DECODE(ROUT_DTL_SEQ,4,LNK_ORG_NOD_CD))) N4TH_NOD_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,4,TRSP_MOD_CD)) N4TH_TRSP_MOD_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,4,VNDR_SEQ)) N4TH_VNDR_SEQ," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,4,VNDR_NM)) N4TH_VNDR_NM," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,4,AGMT_NO)) N4TH_AGMT_NO," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,4,AGMT_CRE_OFC_CD)) N4TH_AGMT_CRE_OFC_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,4,AGMT_REF_NO)) N4TH_AGMT_REF_NO," ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,4,ROUT_DEST_NOD_CD,DECODE(ROUT_DTL_SEQ,5,LNK_ORG_NOD_CD))) N5TH_NOD_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,5,TRSP_MOD_CD)) N5TH_TRSP_MOD_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,5,VNDR_SEQ)) N5TH_VNDR_SEQ," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,5,VNDR_NM)) N5TH_VNDR_NM," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,5,AGMT_NO)) N5TH_AGMT_NO," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,5,AGMT_CRE_OFC_CD)) N5TH_AGMT_CRE_OFC_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,5,AGMT_REF_NO)) N5TH_AGMT_REF_NO," ).append("\n"); 
		query.append("                    MAX(DECODE(CNT,5,ROUT_DEST_NOD_CD,DECODE(ROUT_DTL_SEQ,6,LNK_ORG_NOD_CD))) N6TH_NOD_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,6,TRSP_MOD_CD)) N6TH_TRSP_MOD_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,6,VNDR_SEQ)) N6TH_VNDR_SEQ," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,6,VNDR_NM)) N6TH_VNDR_NM," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,6,AGMT_NO)) N6TH_AGMT_NO," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,6,AGMT_CRE_OFC_CD)) N6TH_AGMT_CRE_OFC_CD," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,6,AGMT_REF_NO)) N6TH_AGMT_REF_NO," ).append("\n"); 
		query.append("                    MAX(DECODE(ROUT_DTL_SEQ,6,LNK_DEST_NOD_CD)) N7TH_NOD_CD," ).append("\n"); 
		query.append("                    PCTL_IO_BND_CD, CRE_OFC_CD,CRE_DT,INLND_ROUT_RMK,  MIN(CNST_RMK) CNST_RMK,ALTN_OPTM_FLG" ).append("\n"); 
		query.append("             FROM (" ).append("\n"); 
		query.append("                    SELECT ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ, PRIO_SEQ,INLND_ROUT_OPTM_FLG,INLND_ROUT_BKG_FLG,INLND_ROUT_TMP_FLG,INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("                           ROUT_DTL_SEQ, CNT,LNK_ORG_NOD_CD, LNK_DEST_NOD_CD,TRSP_MOD_CD," ).append("\n"); 
		query.append("                           DECODE(TRSP_MOD_CD,'TD','TRUCK','RD','RAIL','WD','WATER',TRSP_MOD_CD) TRSP_MOD," ).append("\n"); 
		query.append("                           TZTM_HRS LINK_TT_TIME ,SUM_TT_TIME, ORG_DW_TIME,NVL(DEST_DW_TIME,0) DEST_DW_TIME," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                           VNDR_SEQ,VNDR_NM,AGMT_NO,AGMT_REF_NO,AGMT_CRE_OFC_CD," ).append("\n"); 
		query.append("                           PCTL_IO_BND_CD, CRE_OFC_CD,CRE_DT,INLND_ROUT_RMK," ).append("\n"); 
		query.append("                           DECODE(LNK_CNST_RMK,'', '', LNK_CNST_RMK||CHR(13))||NOD_CNST_RMK CNST_RMK" ).append("\n"); 
		query.append("                           ,ALTN_OPTM_FLG" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                           SELECT M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ, DECODE(M.PRIO_SEQ,0,NULL,M.PRIO_SEQ) PRIO_SEQ,M.INLND_ROUT_OPTM_FLG,M.INLND_ROUT_BKG_FLG, INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("                                D.LNK_ORG_NOD_CD,D.LNK_DEST_NOD_CD, D.ROUT_DTL_SEQ,D.TRSP_MOD_CD,L.TZTM_HRS," ).append("\n"); 
		query.append("                                COUNT (1) OVER (PARTITION BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ" ).append("\n"); 
		query.append("                                   ORDER BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ) AS CNT" ).append("\n"); 
		query.append("                                ,SUM(L.TZTM_HRS) OVER(PARTITION BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ" ).append("\n"); 
		query.append("                                   ORDER BY M.ROUT_ORG_NOD_CD,M.ROUT_DEST_NOD_CD, M.ROUT_SEQ) AS SUM_TT_TIME," ).append("\n"); 
		query.append("                                NVL(DECODE(@[r_inbound], 'O', YFM.OB_DRY_AVG_DWLL_HRS,YFM.IB_DRY_AVG_DWLL_HRS),0) ORG_DW_TIME," ).append("\n"); 
		query.append("                                NVL(DECODE(@[r_inbound], 'O', YTO.OB_DRY_AVG_DWLL_HRS,YTO.IB_DRY_AVG_DWLL_HRS),0) DEST_DW_TIME" ).append("\n"); 
		query.append("                                ,INLND_ROUT_TMP_FLG" ).append("\n"); 
		query.append("                                ,LPAD(D.VNDR_SEQ,6,0) VNDR_SEQ, V.VNDR_LGL_ENG_NM VNDR_NM" ).append("\n"); 
		query.append("                                ,DECODE(D.TRSP_AGMT_OFC_CTY_CD, NULL, VD.AGMT_NO, A.TRSP_AGMT_OFC_CTY_CD||lpad(A.TRSP_AGMT_SEQ,6,'0')) AGMT_NO" ).append("\n"); 
		query.append("                                ,DECODE(D.TRSP_AGMT_OFC_CTY_CD, NULL, VD.AGMT_REF_NO, A.AGMT_REF_NO) AGMT_REF_NO" ).append("\n"); 
		query.append("                                ,DECODE(D.TRSP_AGMT_OFC_CTY_CD, NULL, VD.CRE_OFC_CD, A.CRE_OFC_CD) AGMT_CRE_OFC_CD" ).append("\n"); 
		query.append("                                ,M.PCTL_IO_BND_CD, M.CRE_OFC_CD,M.CRE_DT,M.INLND_ROUT_RMK," ).append("\n"); 
		query.append("                                (SELECT /*+ INDEX_DESC (C XPKPRD_LNK_CNST_MGMT) */ 'Link : '||" ).append("\n"); 
		query.append("                                        DECODE(SVC_USE_FLG, 'N'," ).append("\n"); 
		query.append("                                        'Your booking route is ''No Service'' area from Network Constraint. Please double check with your supervisor.'||CHR(13), '')||" ).append("\n"); 
		query.append("                                        CHR(9)||LNK_ORG_NOD_CD || ' - ' ||" ).append("\n"); 
		query.append("                                        LNK_DEST_NOD_CD || ' : ' ||" ).append("\n"); 
		query.append("                                        PCTL_CNST_ITM_NM || ' - ' ||LNK_CNST_RMK" ).append("\n"); 
		query.append("                                 FROM PRD_LNK_CNST_MGMT C" ).append("\n"); 
		query.append("                                 WHERE C.LNK_ORG_NOD_CD IN (SUBSTR(D.LNK_ORG_NOD_CD,1,2), SUBSTR(D.LNK_ORG_NOD_CD,1,5), SUBSTR(D.LNK_ORG_NOD_CD,1,7))" ).append("\n"); 
		query.append("                                 AND C.LNK_DEST_NOD_CD IN  (SUBSTR(D.LNK_DEST_NOD_CD,1,2), SUBSTR(D.LNK_DEST_NOD_CD,1,5), SUBSTR(D.LNK_DEST_NOD_CD,1,7))" ).append("\n"); 
		query.append("                                 AND NVL(C.DELT_FLG ,'N') <> 'Y'" ).append("\n"); 
		query.append("                                 AND D.TRSP_MOD_CD = C.TRSP_MOD_CD " ).append("\n"); 
		query.append("                                 AND ROWNUM = 1) LNK_CNST_RMK," ).append("\n"); 
		query.append("                                 NVL(" ).append("\n"); 
		query.append("                                     (SELECT /*+ INDEX_DESC (ORG XPKPRD_NOD_CNST_MGMT) */ 'Node : '||" ).append("\n"); 
		query.append("                                            DECODE(INSTR(D.LNK_ORG_NOD_CD,ORG.NOD_CD), 1," ).append("\n"); 
		query.append("                                                    DECODE(ORG.SVC_USE_FLG, 'N'," ).append("\n"); 
		query.append("                                                    'Your booking route is ''No Service'' area from Network Constraint. Please double check with your supervisor.'||CHR(13), '')||" ).append("\n"); 
		query.append("                                                    CHR(9)||ORG.NOD_CD || ' - ' ||" ).append("\n"); 
		query.append("                                                    ORG.PCTL_CNST_ITM_NM || ' - ' ||ORG.NOD_CNST_RMK||CHR(13), '')" ).append("\n"); 
		query.append("                                     FROM PRD_NOD_CNST_MGMT ORG" ).append("\n"); 
		query.append("                                     WHERE ORG.NOD_CD IN (SUBSTR(D.LNK_ORG_NOD_CD,1,2), SUBSTR(D.LNK_ORG_NOD_CD,1,5), SUBSTR(D.LNK_ORG_NOD_CD,1,7))" ).append("\n"); 
		query.append("                                     AND NVL(ORG.DELT_FLG ,'N') <> 'Y'" ).append("\n"); 
		query.append("                                     AND INSTR(DECODE(ORG.PORT_PNT_CD, 'ALL', 'IOB', 'POR','O','POL','O', 'POD' ,'I', 'DEL' ,'I') , M.PCTL_IO_BND_CD) > 0" ).append("\n"); 
		query.append("                                     AND ROWNUM = 1 ) " ).append("\n"); 
		query.append("                                     ,(SELECT /*+ INDEX_DESC ( DEST XPKPRD_NOD_CNST_MGMT) */ 'Node : '||" ).append("\n"); 
		query.append("                                            DECODE(INSTR(D.LNK_DEST_NOD_CD,DEST.NOD_CD), 1," ).append("\n"); 
		query.append("                                                DECODE(DEST.SVC_USE_FLG, 'N'," ).append("\n"); 
		query.append("                                                'Your booking route is ''No Service'' area from Network Constraint. Please double check with your supervisor.'||CHR(13), '')||" ).append("\n"); 
		query.append("                                                CHR(9)||DEST.NOD_CD || ' - ' ||" ).append("\n"); 
		query.append("                                                DEST.PCTL_CNST_ITM_NM || ' - ' ||DEST.NOD_CNST_RMK, '')" ).append("\n"); 
		query.append("                                     FROM PRD_NOD_CNST_MGMT DEST" ).append("\n"); 
		query.append("                                     WHERE DEST.NOD_CD IN  (SUBSTR(D.LNK_DEST_NOD_CD,1,2), SUBSTR(D.LNK_DEST_NOD_CD,1,5), SUBSTR(D.LNK_DEST_NOD_CD,1,7))" ).append("\n"); 
		query.append("                                     AND NVL(DEST.DELT_FLG ,'N') <> 'Y'" ).append("\n"); 
		query.append("                                     AND INSTR(DECODE(DEST.PORT_PNT_CD, 'ALL', 'IOB', 'POR','O','POL','O', 'POD' ,'I', 'DEL' ,'I') , M.PCTL_IO_BND_CD) > 0" ).append("\n"); 
		query.append("                                     AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                                 )  NOD_CNST_RMK" ).append("\n"); 
		query.append("                                 ,ALTN_OPTM_FLG" ).append("\n"); 
		query.append("                           FROM PRD_INLND_ROUT_MST M" ).append("\n"); 
		query.append("                              , PRD_INLND_ROUT_DTL D" ).append("\n"); 
		query.append("                              , PRD_INLND_EACH_LNK L" ).append("\n"); 
		query.append("                              , MDM_VENDOR V" ).append("\n"); 
		query.append("                              , TRS_AGMT_HDR A" ).append("\n"); 
		query.append("                              , PRD_NODE NO" ).append("\n"); 
		query.append("                              , PRD_NODE ND" ).append("\n"); 
		query.append("                              , (SELECT A.VNDR_SEQ, TRSP_AGMT_OFC_CTY_CD||LPAD(TRSP_AGMT_SEQ,6,'0') AGMT_NO, " ).append("\n"); 
		query.append("                                   AGMT_REF_NO, CRE_OFC_CD" ).append("\n"); 
		query.append("                                  FROM" ).append("\n"); 
		query.append("                                  (" ).append("\n"); 
		query.append("                                   SELECT VNDR_SEQ, SUBSTR(MAX(TRSP_AGMT_OFC_CTY_CD||LPAD(TRSP_AGMT_SEQ,6,'0')),1,3) TRSP_CD," ).append("\n"); 
		query.append("                                          TO_NUMBER(SUBSTR(MAX(TRSP_AGMT_OFC_CTY_CD||LPAD(TRSP_AGMT_SEQ,6,'0')),4,6)) AGMT_SEQ" ).append("\n"); 
		query.append("                                   FROM TRS_AGMT_APLY_VNDR" ).append("\n"); 
		query.append("                                   GROUP BY VNDR_SEQ" ).append("\n"); 
		query.append("                                   ) A, TRS_AGMT_HDR B" ).append("\n"); 
		query.append("                                   WHERE A.TRSP_CD = B.TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                                   AND A.AGMT_SEQ = B.TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("                                ) VD" ).append("\n"); 
		query.append("                              , MDM_YARD YFM" ).append("\n"); 
		query.append("                              , MDM_YARD YTO" ).append("\n"); 
		query.append("                           WHERE M.ROUT_ORG_NOD_CD LIKE DECODE(@[i_org_cd], NULL, 'XXXXXXXX',@[i_org_cd])||'%'" ).append("\n"); 
		query.append("                             AND M.ROUT_DEST_NOD_CD LIKE DECODE(@[i_dest_cd], NULL, 'XXXXXXXX', @[i_dest_cd])||'%'" ).append("\n"); 
		query.append("                             AND NVL(M.DELT_FLG,'N') ='N'" ).append("\n"); 
		query.append("                             AND M.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                             AND M.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                             AND M.ROUT_SEQ = D.ROUT_SEQ" ).append("\n"); 
		query.append("                             AND D.LNK_ORG_NOD_CD = L.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("                             AND D.LNK_DEST_NOD_CD = L.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("                             AND D.TRSP_MOD_CD = L.TRSP_MOD_CD" ).append("\n"); 
		query.append("                             AND D.TRSP_AGMT_OFC_CTY_CD = A.TRSP_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                             AND D.TRSP_AGMT_SEQ = A.TRSP_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                             AND D.VNDR_SEQ = V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("                             AND M.AUTO_IRG_FLG <> 'Y'" ).append("\n"); 
		query.append("                             AND M.PCTL_IO_BND_CD = @[r_inbound]" ).append("\n"); 
		query.append("#if ( ${r_inbound} == 'I' || ${r_inbound} == 'O')" ).append("\n"); 
		query.append("                             AND NO.NOD_CD = M.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                             AND ND.NOD_CD = M.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                             AND NO.NOD_CD(+) = M.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                             AND ND.NOD_CD(+) = M.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                             AND D.VNDR_SEQ = VD.VNDR_SEQ(+)" ).append("\n"); 
		query.append("                             AND YFM.YD_CD(+) = D.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("                             AND YTO.YD_CD(+) = D.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                  ) M" ).append("\n"); 
		query.append("           GROUP BY M.ROUT_ORG_NOD_CD, M.ROUT_DEST_NOD_CD, M.ROUT_SEQ, M.PRIO_SEQ,SUM_TT_TIME,INLND_ROUT_OPTM_FLG,INLND_ROUT_BKG_FLG,INLND_ROUT_TMP_FLG,M.INLND_ROUT_INCL_STTL_FLG," ).append("\n"); 
		query.append("                    M.PCTL_IO_BND_CD, M.CRE_OFC_CD,M.CRE_DT,M.INLND_ROUT_RMK, M.INLND_ROUT_OPTM_FLG,ALTN_OPTM_FLG" ).append("\n"); 
		query.append("           ORDER BY ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, PRIO_SEQ, M.INLND_ROUT_OPTM_FLG DESC, NVL(INLND_ROUT_BKG_FLG, 'N') DESC" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("ORDER BY   RN" ).append("\n"); 

	}
}