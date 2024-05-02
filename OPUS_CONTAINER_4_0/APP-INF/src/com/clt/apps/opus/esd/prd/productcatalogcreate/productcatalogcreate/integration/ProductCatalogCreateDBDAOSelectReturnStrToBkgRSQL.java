/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSelectReturnStrToBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.09.15 정선용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSelectReturnStrToBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectReturnStrToBkg
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSelectReturnStrToBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSelectReturnStrToBkgRSQL").append("\n"); 
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
		query.append("DECODE (NOD_LNK_DIV_CD,'N',ORG_NOD_CD, ORG_NOD_CD || ' -> ' || DEST_NOD_CD) NODE_LINK," ).append("\n"); 
		query.append("'PLANNED' TRANS_ST," ).append("\n"); 
		query.append("DECODE(TRSP_MOD_CD,'X','',TRSP_MOD_CD) TRSP_MOD_CD," ).append("\n"); 
		query.append("LTRIM (TO_CHAR (TRUNC (TZ_DWLL_TM_HRS / 24, 0), '00'))|| LTRIM (TO_CHAR (MOD (TZ_DWLL_TM_HRS, 24), '00')) FMT_TZ_DWLL_TM," ).append("\n"); 
		query.append("TO_CHAR (ARR_ST_DT, 'MON DD HH24:MI') ARR_TIME," ).append("\n"); 
		query.append("TO_CHAR (DEP_FSH_DT, 'MON DD HH24:MI') DEP_TIME," ).append("\n"); 
		query.append("CASE WHEN VSL_CD IS NOT NULL AND  SKD_VOY_NO IS NOT NULL AND SKD_DIR_CD IS NOT NULL THEN" ).append("\n"); 
		query.append("VSL_CD || TRIM (TO_CHAR (SKD_VOY_NO, '0000')) || SKD_DIR_CD" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END VVD," ).append("\n"); 
		query.append("(select TRNK_VSL_CD||TRNK_SKD_VOY_NO||TRNK_SKD_DIR_CD from prd_prod_ctl_mst where pctl_no=@[pctl_no])t_vvd," ).append("\n"); 
		query.append("to_char(GEN_AVAL_SPC) GEN_AVAL_SPC, to_char(D7_AVAL_SPC) D7_AVAL_SPC, to_char(RF_AVAL_SPC) RF_AVAL_SPC," ).append("\n"); 
		query.append("--DECODE(:Bind1, '', CNST_FLG, :Bind2) REMARK," ).append("\n"); 
		query.append("PCTL_NO," ).append("\n"); 
		query.append("PCTL_SEQ," ).append("\n"); 
		query.append("VSL_SLAN_CD,ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD ," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN TRSP_MOD_CD IN ('WD', 'VD') AND NOD_LNK_DIV_CD = 'L' AND VSL_SLAN_CD > ' ' THEN 'T'" ).append("\n"); 
		query.append("ELSE 'F'" ).append("\n"); 
		query.append("END AS VVD_GB," ).append("\n"); 
		query.append("TO_CHAR (ARR_ST_DT, 'YYYYMMDDHH24MISS') ETD," ).append("\n"); 
		query.append("TO_CHAR (DEP_FSH_DT, 'YYYYMMDDHH24MISS') ETB," ).append("\n"); 
		query.append("ORG_NOD_CD, DEST_NOD_CD, PCTL_WTR_DIV_CD, NOD_LNK_DIV_CD, MTY_YD_FLG," ).append("\n"); 
		query.append("CASE WHEN NOD_LNK_DIV_CD='N' AND PCTL_IO_BND_CD='O' AND ORG_NOD_TP_CD ='Z' AND DEST_NOD_TP_CD ='Z' THEN 'Y'" ).append("\n"); 
		query.append("ELSE 'N'" ).append("\n"); 
		query.append("END AS DOOR_DT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT TO_CHAR(MAX(ARR_ST_DT),'YYYYMMDDHH24MISS') FROM PRD_PROD_CTL_ROUT_DTL WHERE" ).append("\n"); 
		query.append("PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'N'" ).append("\n"); 
		query.append(") AS DELIVERY_DT," ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT SUBSTR(MAX(DECODE(TRSP_MOD_CD,'TD','T'))||MAX(DECODE(TRSP_MOD_CD,'RD','R'))||" ).append("\n"); 
		query.append("MAX(DECODE(TRSP_MOD_CD,'WD','W'))||'D',1,2)  TRSP_MODE" ).append("\n"); 
		query.append("FROM PRD_INLND_ROUT_DTL" ).append("\n"); 
		query.append("WHERE (ROUT_ORG_NOD_CD , ROUT_DEST_NOD_CD , ROUT_SEQ ) =" ).append("\n"); 
		query.append("(SELECT ROUT_ORG_NOD_CD , ROUT_DEST_NOD_CD , ROUT_SEQ" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='O'" ).append("\n"); 
		query.append("AND ROUT_ORG_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY ROUT_ORG_NOD_CD , ROUT_DEST_NOD_CD , ROUT_SEQ" ).append("\n"); 
		query.append("),'AL') O_T_MODE," ).append("\n"); 
		query.append("NVL((" ).append("\n"); 
		query.append("SELECT SUBSTR(MAX(DECODE(TRSP_MOD_CD,'TD','T'))||MAX(DECODE(TRSP_MOD_CD,'RD','R'))||" ).append("\n"); 
		query.append("MAX(DECODE(TRSP_MOD_CD,'WD','W'))||'D',1,2)  TRSP_MODE" ).append("\n"); 
		query.append("FROM PRD_INLND_ROUT_DTL" ).append("\n"); 
		query.append("WHERE (ROUT_ORG_NOD_CD , ROUT_DEST_NOD_CD , ROUT_SEQ ) =" ).append("\n"); 
		query.append("(SELECT ROUT_ORG_NOD_CD , ROUT_DEST_NOD_CD , ROUT_SEQ" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='I'" ).append("\n"); 
		query.append("AND ROUT_ORG_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY ROUT_ORG_NOD_CD , ROUT_DEST_NOD_CD , ROUT_SEQ" ).append("\n"); 
		query.append("),'AL') I_T_MODE," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("AND TRSP_MOD_CD IN ('WD','VD')" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append(") LOAD_DT_PCTL_SEQ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select FULL_RTN_YD_CD from prd_prod_ctl_mst where pctl_no=@[pctl_no]" ).append("\n"); 
		query.append(") FL_RT_CY_PCTL_SEQ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select N1ST_NOD_CD from PRD_PROD_CTL_ACT_GRP_DTL where pctl_no =@[pctl_no]" ).append("\n"); 
		query.append("and COST_ACT_GRP_SEQ =(" ).append("\n"); 
		query.append("SELECT  MAX(COST_ACT_GRP_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ACT_GRP_DTL A" ).append("\n"); 
		query.append("WHERE A.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("AND A.PCTL_IO_BND_CD IN ('I','N')" ).append("\n"); 
		query.append("AND A.COST_ACT_GRP_SEQ > 600" ).append("\n"); 
		query.append("AND A.COST_ACT_GRP_TP_CD ='L')" ).append("\n"); 
		query.append(") FL_PU_CY_PCTL_SEQ ," ).append("\n"); 
		query.append("(CASE WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]	  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'Y'  ) THEN 'P/ UP'" ).append("\n"); 
		query.append("WHEN PCTL_SEQ = 1+ (SELECT  MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]	  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'Y'  )" ).append("\n"); 
		query.append("AND (SELECT BKG_RCV_TERM_CD FROM PRD_PROD_CTL_MST WHERE PCTL_NO = @[pctl_no] )  <> 'D'   THEN 'DUMMY'" ).append("\n"); 
		query.append("WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'N'  )" ).append("\n"); 
		query.append("AND  PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'N'  ) THEN 'POR/POL'" ).append("\n"); 
		query.append("WHEN PCTL_SEQ > (SELECT  MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'N'  )" ).append("\n"); 
		query.append("AND PCTL_SEQ < (SELECT  MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'N'  )" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'  THEN 'OB I/C'" ).append("\n"); 
		query.append("WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'N'  )  THEN 'POR'" ).append("\n"); 
		query.append("WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'N'  ) THEN 'POL'" ).append("\n"); 
		query.append("WHEN PCTL_SEQ  IN (SELECT  PCTL_SEQ" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append(") THEN 'T/S'" ).append("\n"); 
		query.append("WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'N'  )" ).append("\n"); 
		query.append("AND PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'N'  ) THEN 'POD/DEL'" ).append("\n"); 
		query.append("WHEN PCTL_SEQ > (SELECT  MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'N'  )" ).append("\n"); 
		query.append("AND PCTL_SEQ < (SELECT  MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'N'  )" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'  THEN 'IB I/C'" ).append("\n"); 
		query.append("WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'N'  ) THEN 'POD'" ).append("\n"); 
		query.append("WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'N'  ) THEN 'DEL'" ).append("\n"); 
		query.append("WHEN PCTL_SEQ = -1+ (SELECT  MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'Y'  )" ).append("\n"); 
		query.append("AND (SELECT BKG_DE_TERM_CD FROM PRD_PROD_CTL_MST WHERE PCTL_NO = @[pctl_no] )  <> 'D'    THEN 'DUMMY'" ).append("\n"); 
		query.append("WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE  PCTL_NO = @[pctl_no]  --'B0703070000000020002'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND MTY_YD_FLG = 'Y'  ) THEN 'RTN CY'" ).append("\n"); 
		query.append("END) LOC" ).append("\n"); 
		query.append("-- :Bind28 CNST_RMK" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE ((PCTL_NO = @[pctl_no] ))" ).append("\n"); 
		query.append("ORDER BY PCTL_SEQ" ).append("\n"); 

	}
}