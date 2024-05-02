/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSelectPrdOcnRoutRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2010.02.11 정선용
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

public class ProductCatalogCreateDBDAOSelectPrdOcnRoutRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectPrdOcnRout
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSelectPrdOcnRoutRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSelectPrdOcnRoutRSQL").append("\n"); 
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
		query.append("chk ,NO,PCTL_NO,SLS_OFC_CD,ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ," ).append("\n"); 
		query.append("UPD_IND_CD," ).append("\n"); 
		query.append("ord," ).append("\n"); 
		query.append("RK,VVD_LNK_NO," ).append("\n"); 
		query.append("TZTM_HRS, ORG_TZTM_HRS, LNK_KNT," ).append("\n"); 
		query.append("OCN_ROUT_PRIO_CD," ).append("\n"); 
		query.append("N1ST_VSL_SLAN_CD,N1ST_SLAN_CD,N1ST_VVD,N1ST_POL,N1ST_POD, N1ST_POL_N,N1ST_POD_N," ).append("\n"); 
		query.append("N1ST_POL_DC,N1ST_POD_DC,N1ST_TVVD_FLAG,N1ST_SPACE," ).append("\n"); 
		query.append("N2ND_VSL_SLAN_CD,N2ND_SLAN_CD,N2ND_VVD,N2ND_POL,N2ND_POD,N2ND_POL_N,N2ND_POD_N," ).append("\n"); 
		query.append("N2ND_POL_DC,N2ND_POD_DC,N2ND_TVVD_FLAG,N2ND_SPACE," ).append("\n"); 
		query.append("N3RD_VSL_SLAN_CD,N3RD_SLAN_CD,N3RD_VVD,N3RD_POL,N3RD_POD,N3RD_POL_N,N3RD_POD_N," ).append("\n"); 
		query.append("N3RD_POL_DC,N3RD_POD_DC,N3RD_TVVD_FLAG,N3RD_SPACE," ).append("\n"); 
		query.append("N4TH_VSL_SLAN_CD,N4TH_SLAN_CD,N4TH_VVD,N4TH_POL,N4TH_POD,N4TH_POL_N,N4TH_POD_N," ).append("\n"); 
		query.append("N4TH_POL_DC,N4TH_POD_DC,N4TH_TVVD_FLAG,N4TH_SPACE, TTL_EXPN_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT ''chk ,NO,PCTL_NO,SLS_OFC_CD,ORG_LOC_CD,DEST_LOC_CD,ROUT_SEQ," ).append("\n"); 
		query.append("DECODE(UPD_IND_CD, 'S', 'Standard', 'T', 'Temporary', 'V', 'Validation', 'N', 'Not Used', 'A', 'Add Call', 'D', 'Deleted', 'G', 'Guide')UPD_IND_CD," ).append("\n"); 
		query.append("DECODE(UPD_IND_CD, 'G',1, 'S', 1, 'T', 3, 'A', 4, 'V', 5, 'N', 6, 'D', 7) ord," ).append("\n"); 
		query.append("OCN_ROUT_PRIO_CD," ).append("\n"); 
		query.append("RANK() OVER(PARTITION BY SUBSTR(PCTL_NO,1,1) ORDER BY TTL_EXPN_AMT ,DECODE(UPD_IND_CD, 'G',1, 'S', 1, 'T', 3, 'A', 4, 'V', 5, 'N', 6, 'D', 7) ," ).append("\n"); 
		query.append("OCN_ROUT_PRIO_CD,LNK_KNT,TZTM_HRS,ROUT_SEQ ASC) RK,TZTM_HRS ORG_TZTM_HRS, LNK_KNT," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN N1ST_TVVD_FLAG='V' THEN '1'" ).append("\n"); 
		query.append("WHEN N2ND_TVVD_FLAG='V' THEN '2'" ).append("\n"); 
		query.append("WHEN N3RD_TVVD_FLAG='V' THEN '3'" ).append("\n"); 
		query.append("WHEN N4TH_TVVD_FLAG='V' THEN '4'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END VVD_LNK_NO," ).append("\n"); 
		query.append("LTRIM (TO_CHAR (TRUNC (TZTM_HRS / 24, 0), '00')||'D-')" ).append("\n"); 
		query.append("|| LTRIM (TO_CHAR (MOD (TZTM_HRS, 24), '00')||'H') TZTM_HRS," ).append("\n"); 
		query.append("N1ST_VSL_SLAN_CD,N1ST_SLAN_CD,N1ST_VVD,N1ST_POL,N1ST_POD, N1ST_POL_N,N1ST_POD_N,N1ST_TVVD_FLAG," ).append("\n"); 
		query.append("(CASE" ).append("\n"); 
		query.append("WHEN N1ST_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 1" ).append("\n"); 
		query.append("THEN (SELECT YD_CD" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N1ST_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N1ST_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N1ST_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N1ST_POL_N,1,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("WHEN N1ST_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 2" ).append("\n"); 
		query.append("THEN (SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N1ST_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N1ST_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N1ST_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N1ST_POL_N,1,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END) N1ST_POL_DC" ).append("\n"); 
		query.append(",(CASE" ).append("\n"); 
		query.append("WHEN N1ST_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 1" ).append("\n"); 
		query.append("THEN (SELECT YD_CD" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N1ST_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N1ST_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N1ST_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N1ST_POD_N,1,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("WHEN N1ST_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 2" ).append("\n"); 
		query.append("THEN (SELECT TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N1ST_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N1ST_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N1ST_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N1ST_POD_N,1,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END) N1ST_POD_DC," ).append("\n"); 
		query.append("DECODE(no,'1',PRD_GET_SPACE_FNC(PCTL_NO, N1ST_POL_N, N1ST_POD_N, N1ST_VVD, N1ST_TVVD_FLAG, SLS_OFC_CD),'') N1ST_SPACE," ).append("\n"); 
		query.append("N2ND_VSL_SLAN_CD,N2ND_SLAN_CD,N2ND_VVD,N2ND_POL,N2ND_POD,N2ND_POL_N,N2ND_POD_N,N2ND_TVVD_FLAG," ).append("\n"); 
		query.append("(CASE" ).append("\n"); 
		query.append("WHEN N2ND_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 1" ).append("\n"); 
		query.append("THEN (SELECT YD_CD" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N2ND_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N2ND_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N2ND_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N2ND_POL_N,1,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("WHEN N2ND_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 2" ).append("\n"); 
		query.append("THEN (SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N2ND_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N2ND_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N2ND_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N2ND_POL_N,1,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END) N2ND_POL_DC" ).append("\n"); 
		query.append(",(CASE" ).append("\n"); 
		query.append("WHEN N2ND_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 1" ).append("\n"); 
		query.append("THEN (SELECT YD_CD" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N2ND_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N2ND_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N2ND_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N2ND_POD_N,1,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("WHEN N2ND_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 2" ).append("\n"); 
		query.append("THEN (SELECT TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N2ND_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N2ND_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N2ND_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N2ND_POD_N,1,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END) N2ND_POD_DC," ).append("\n"); 
		query.append("DECODE(N2ND_POL_N, NULL,'', DECODE(no,'1',PRD_GET_SPACE_FNC(PCTL_NO, N2ND_POL_N, N2ND_POD_N, N2ND_VVD, N2ND_TVVD_FLAG, SLS_OFC_CD),'')) N2ND_SPACE," ).append("\n"); 
		query.append("N3RD_VSL_SLAN_CD,N3RD_SLAN_CD,N3RD_VVD,N3RD_POL,N3RD_POD,N3RD_POL_N,N3RD_POD_N,N3RD_TVVD_FLAG," ).append("\n"); 
		query.append("(CASE" ).append("\n"); 
		query.append("WHEN N3RD_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 1" ).append("\n"); 
		query.append("THEN (SELECT YD_CD" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N3RD_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N3RD_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N3RD_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N3RD_POL_N,1,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("WHEN N3RD_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 2" ).append("\n"); 
		query.append("THEN (SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N3RD_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N3RD_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N3RD_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N3RD_POL_N,1,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END) N3RD_POL_DC" ).append("\n"); 
		query.append(",(CASE" ).append("\n"); 
		query.append("WHEN N3RD_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 1" ).append("\n"); 
		query.append("THEN (SELECT YD_CD" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N3RD_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N3RD_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N3RD_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N3RD_POD_N,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("WHEN N3RD_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 2" ).append("\n"); 
		query.append("THEN (SELECT TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N3RD_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N3RD_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N3RD_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N3RD_POD_N,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END) N3RD_POD_DC," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("DECODE(N3RD_POL_N, NULL,'', DECODE(no,'1',PRD_GET_SPACE_FNC(PCTL_NO, N3RD_POL_N, N3RD_POD_N, N3RD_VVD, N3RD_TVVD_FLAG, SLS_OFC_CD),'')) N3RD_SPACE," ).append("\n"); 
		query.append("N4TH_VSL_SLAN_CD,N4TH_SLAN_CD,N4TH_VVD,N4TH_POL,N4TH_POD,N4TH_POL_N,N4TH_POD_N,N4TH_TVVD_FLAG," ).append("\n"); 
		query.append("(CASE" ).append("\n"); 
		query.append("WHEN N4TH_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 1" ).append("\n"); 
		query.append("THEN (SELECT YD_CD" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N4TH_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N4TH_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N4TH_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N4TH_POL_N,1,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("WHEN N4TH_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 2" ).append("\n"); 
		query.append("THEN (SELECT TO_CHAR(VPS_ETD_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N4TH_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N4TH_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N4TH_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N4TH_POL_N,1,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END) N4TH_POL_DC" ).append("\n"); 
		query.append(",(CASE" ).append("\n"); 
		query.append("WHEN N4TH_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 1" ).append("\n"); 
		query.append("THEN (SELECT YD_CD" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N4TH_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N4TH_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N4TH_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N4TH_POD_N,1,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("WHEN N4TH_VVD IS NOT NULL" ).append("\n"); 
		query.append("AND NO = 2" ).append("\n"); 
		query.append("THEN (SELECT TO_CHAR(VPS_ETA_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  V.VSL_CD = SUBSTR(N4TH_VVD,1,4)" ).append("\n"); 
		query.append("AND V.SKD_VOY_NO = SUBSTR(N4TH_VVD,5,4)" ).append("\n"); 
		query.append("AND V.SKD_DIR_CD = SUBSTR(N4TH_VVD,9,1)" ).append("\n"); 
		query.append("AND V.VPS_PORT_CD = SUBSTR(N4TH_POD_N,1,5)" ).append("\n"); 
		query.append("AND V.CALL_YD_IND_SEQ = 2)" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END) N4TH_POD_DC ," ).append("\n"); 
		query.append("DECODE(N4TH_POL_N,NULL,'',  DECODE(no,'1',PRD_GET_SPACE_FNC(PCTL_NO, N4TH_POL_N, N4TH_POD_N, N4TH_VVD, N4TH_TVVD_FLAG, SLS_OFC_CD),'')) N4TH_SPACE" ).append("\n"); 
		query.append(",TTL_EXPN_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  '1' NO," ).append("\n"); 
		query.append("PCTL_NO,ORG_LOC_CD,DEST_LOC_CD,O.ROUT_SEQ,LNK_KNT," ).append("\n"); 
		query.append("MAX(UPD_IND_CD) UPD_IND_CD," ).append("\n"); 
		query.append("MAX(OCN_ROUT_PRIO_CD) OCN_ROUT_PRIO_CD," ).append("\n"); 
		query.append("--MAX((DEP_FSH_DT-ARR_ST_DT))*24  TZTM_HRS," ).append("\n"); 
		query.append("(MAX(DEP_FSH_DT )-MIN(ARR_ST_DT ) ) *24 TZTM_HRS," ).append("\n"); 
		query.append("MAX(DECODE(R, 1 , VSL_SLAN_CD, '')) n1st_vsl_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 1 , VSL_SLAN_CD, '')) n1st_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 1 , VSL_CD||SKD_VOY_NO||SKD_DIR_CD, '')) n1st_vvd," ).append("\n"); 
		query.append("MAX(DECODE(R, 1 , ORG_NOD_CD, ''))  n1st_pol," ).append("\n"); 
		query.append("MAX(DECODE(R, 1 , DEST_NOD_CD, '')) n1st_pod," ).append("\n"); 
		query.append("MAX(DECODE(R, 1 , ORG_NOD_CD, ''))  n1st_pol_n," ).append("\n"); 
		query.append("MAX(DECODE(R, 1 , DEST_NOD_CD, '')) n1st_pod_n," ).append("\n"); 
		query.append("(CASE WHEN MAX(DECODE(R, 1 , T_VVD, ''))='V' THEN 'V'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") n1st_TVVD_FLAG," ).append("\n"); 
		query.append("'' n1st_space," ).append("\n"); 
		query.append("MAX(DECODE(R, 2 , VSL_SLAN_CD, '')) n2nd_vsl_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 2 , VSL_SLAN_CD, '')) n2nd_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 2 , VSL_CD||SKD_VOY_NO||SKD_DIR_CD, '')) n2nd_VVD," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("MAX(DECODE(R, 2 , ORG_NOD_CD, '')) n2nd_pol," ).append("\n"); 
		query.append("MAX(DECODE(R, 2 , DEST_NOD_CD, '')) n2nd_pod," ).append("\n"); 
		query.append("MAX(DECODE(R, 2 , ORG_NOD_CD, '')) n2nd_pol_n," ).append("\n"); 
		query.append("MAX(DECODE(R, 2 , DEST_NOD_CD, '')) n2nd_pod_n," ).append("\n"); 
		query.append("(CASE WHEN MAX(DECODE(R, 2 , T_VVD, ''))='V' THEN 'V'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") n2nd_tvvd_flag," ).append("\n"); 
		query.append("'' n2nd_space," ).append("\n"); 
		query.append("MAX(DECODE(R, 3 , VSL_SLAN_CD, '')) n3rd_vsl_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 3 , VSL_SLAN_CD, '')) n3rd_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 3 , VSL_CD||SKD_VOY_NO||SKD_DIR_CD, '')) n3rd_VVD," ).append("\n"); 
		query.append("MAX(DECODE(R, 3 , ORG_NOD_CD, '')) n3rd_pol," ).append("\n"); 
		query.append("MAX(DECODE(R, 3 , DEST_NOD_CD, '')) n3rd_pod," ).append("\n"); 
		query.append("MAX(DECODE(R, 3 , ORG_NOD_CD, '')) n3rd_pol_n," ).append("\n"); 
		query.append("MAX(DECODE(R, 3 , DEST_NOD_CD, '')) n3rd_pod_n," ).append("\n"); 
		query.append("(CASE WHEN MAX(DECODE(R, 3 , T_VVD, ''))='V' THEN 'V'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") n3rd_TVVD_FLAG," ).append("\n"); 
		query.append("'' n3rd_space," ).append("\n"); 
		query.append("MAX(DECODE(R, 4 , VSL_SLAN_CD, '')) n4th_vsl_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 4 , VSL_SLAN_CD, '')) n4th_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 4 , VSL_CD||SKD_VOY_NO||SKD_DIR_CD, '')) n4th_VVD," ).append("\n"); 
		query.append("MAX(DECODE(R, 4 , ORG_NOD_CD, '')) n4th_pol," ).append("\n"); 
		query.append("MAX(DECODE(R, 4 , DEST_NOD_CD, '')) n4th_pod," ).append("\n"); 
		query.append("MAX(DECODE(R, 4 , ORG_NOD_CD, '')) n4th_pol_n," ).append("\n"); 
		query.append("MAX(DECODE(R, 4 , DEST_NOD_CD, '')) n4th_pod_n," ).append("\n"); 
		query.append("(CASE WHEN MAX(DECODE(R, 4 , T_VVD, ''))='V' THEN 'V'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") n4th_TVVD_FLAG," ).append("\n"); 
		query.append("'' n4th_space ," ).append("\n"); 
		query.append("(SELECT SLS_OFC_CD FROM PRD_PROD_CTL_MST M WHERE M.PCTL_NO = P.PCTL_NO) SLS_OFC_CD" ).append("\n"); 
		query.append(",(SELECT TTL_EXPN_AMT FROM PRD_PROD_CTL_MST M WHERE M.PCTL_NO = P.PCTL_NO) TTL_EXPN_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select D.* , ROW_NUMBER() over (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) R," ).append("\n"); 
		query.append("(select 'V' from prd_prod_ctl_mst m where m.pctl_no = d.pctl_no and m.TRNK_VSL_CD = d.VSL_CD and m.TRNK_SKD_VOY_NO= d.SKD_VOY_NO and m.TRNK_SKD_DIR_CD =  d.SKD_DIR_CD) t_vvd" ).append("\n"); 
		query.append("from PRD_PROD_CTL_rout_dtl D" ).append("\n"); 
		query.append("where  PCTL_NO LIKE @[hd_pctl_no]||'%' --'J0001'" ).append("\n"); 
		query.append("and PCTL_IO_BND_CD='T'" ).append("\n"); 
		query.append("AND VSL_SLAN_CD IS NOT NULL" ).append("\n"); 
		query.append("AND PCTL_NO IN ( SELECT DISTINCT  (PCTL_NO) PCTL_NO" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_rout_dtl" ).append("\n"); 
		query.append("WHERE PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD='T'" ).append("\n"); 
		query.append("--GROUP BY ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") P, PRD_OCN_ROUT O" ).append("\n"); 
		query.append("WHERE O.ORG_LOC_CD = P.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND O.DEST_LOC_CD = P.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND O.ROUT_SEQ = P.ROUT_SEQ" ).append("\n"); 
		query.append("GROUP BY PCTL_NO,ORG_LOC_CD,DEST_LOC_CD,O.ROUT_SEQ,LNK_KNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT  '2' NO," ).append("\n"); 
		query.append("PCTL_NO,ORG_LOC_CD,DEST_LOC_CD,O.ROUT_SEQ,LNK_KNT," ).append("\n"); 
		query.append("MAX(UPD_IND_CD) UPD_IND_CD," ).append("\n"); 
		query.append("MAX(OCN_ROUT_PRIO_CD) OCN_ROUT_PRIO_CD," ).append("\n"); 
		query.append("--MAX((DEP_FSH_DT-ARR_ST_DT))*24  TZTM_HRS," ).append("\n"); 
		query.append("(MAX(DEP_FSH_DT )-MIN(ARR_ST_DT ) ) *24 TZTM_HRS," ).append("\n"); 
		query.append("MAX(DECODE(R, 1 , VSL_CD||SKD_VOY_NO||SKD_DIR_CD, '')) n1st_vsl_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 1 , VSL_SLAN_CD, '')) n1st_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 1 , VSL_CD||SKD_VOY_NO||SKD_DIR_CD, '')) n1st_VVD," ).append("\n"); 
		query.append("MAX(DECODE(R, 1 , TO_CHAR(ARR_ST_DT,'YYYY-MM-DD'), ''))n1st_pol," ).append("\n"); 
		query.append("MAX(DECODE(R, 1 , TO_CHAR(DEP_FSH_DT,'YYYY-MM-DD'), '')) n1st_pod," ).append("\n"); 
		query.append("MAX(DECODE(R, 1 , ORG_NOD_CD, ''))||'' n1st_pol_n," ).append("\n"); 
		query.append("MAX(DECODE(R, 1 , DEST_NOD_CD, ''))||'' n1st_pod_n," ).append("\n"); 
		query.append("(CASE WHEN MAX(DECODE(R, 1 , T_VVD, ''))='V' THEN 'V'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") n1st_TVVD_FLAG," ).append("\n"); 
		query.append("'' n1st_space," ).append("\n"); 
		query.append("MAX(DECODE(R, 2 , VSL_CD||SKD_VOY_NO||SKD_DIR_CD, '')) n2nd_vsl_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 2 , VSL_SLAN_CD, '')) n2nd_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 2 , VSL_CD||SKD_VOY_NO||SKD_DIR_CD, '')) n2nd_VVD," ).append("\n"); 
		query.append("MAX(DECODE(R, 2 , TO_CHAR(ARR_ST_DT,'YYYY-MM-DD'), '')) n2nd_pol," ).append("\n"); 
		query.append("MAX(DECODE(R, 2 , TO_CHAR(DEP_FSH_DT,'YYYY-MM-DD'), '')) n2nd_pod," ).append("\n"); 
		query.append("MAX(DECODE(R, 2 , ORG_NOD_CD, ''))||'' n2nd_pol_n," ).append("\n"); 
		query.append("MAX(DECODE(R, 2 , DEST_NOD_CD, ''))||'' n2nd_pod_n," ).append("\n"); 
		query.append("(CASE WHEN MAX(DECODE(R, 2 , T_VVD, ''))='V' THEN 'V'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") n2nd_TVVD_FLAG," ).append("\n"); 
		query.append("'' n2nd_space," ).append("\n"); 
		query.append("MAX(DECODE(R, 3 , VSL_CD||SKD_VOY_NO||SKD_DIR_CD, '')) n3rd_vsl_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 3 , VSL_SLAN_CD, '')) n3rd_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 3 , VSL_CD||SKD_VOY_NO||SKD_DIR_CD, '')) n3rd_VVD," ).append("\n"); 
		query.append("MAX(DECODE(R, 3 , TO_CHAR(ARR_ST_DT,'YYYY-MM-DD'), '')) n3rd_pol," ).append("\n"); 
		query.append("MAX(DECODE(R, 3 , TO_CHAR(DEP_FSH_DT,'YYYY-MM-DD'), '')) n3rd_pod," ).append("\n"); 
		query.append("MAX(DECODE(R, 3 , ORG_NOD_CD, ''))||'' n3rd_pol_n," ).append("\n"); 
		query.append("MAX(DECODE(R, 3 , DEST_NOD_CD, ''))||'' n3rd_pod_n," ).append("\n"); 
		query.append("(CASE WHEN MAX(DECODE(R, 3 , T_VVD, ''))='V' THEN 'V'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") n3rd_TVVD_FLAG," ).append("\n"); 
		query.append("'' n3rd_space," ).append("\n"); 
		query.append("MAX(DECODE(R, 4 , VSL_CD||SKD_VOY_NO||SKD_DIR_CD, '')) n4th_vsl_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 4 , VSL_SLAN_CD, '')) n4th_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 4 , VSL_CD||SKD_VOY_NO||SKD_DIR_CD, '')) n4th_vsl_slan_cd," ).append("\n"); 
		query.append("MAX(DECODE(R, 4 , TO_CHAR(ARR_ST_DT,'YYYY-MM-DD'), '')) n4th_pol," ).append("\n"); 
		query.append("MAX(DECODE(R, 4 , TO_CHAR(DEP_FSH_DT,'YYYY-MM-DD'), '')) n4th_pod," ).append("\n"); 
		query.append("MAX(DECODE(R, 4 , ORG_NOD_CD, ''))||'' n4th_pol_n," ).append("\n"); 
		query.append("MAX(DECODE(R, 4 , DEST_NOD_CD, ''))||'' n4th_pod_n," ).append("\n"); 
		query.append("(CASE WHEN MAX(DECODE(R, 4 , T_VVD, ''))='V' THEN 'V'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(") n4th_TVVD_FLAG," ).append("\n"); 
		query.append("'' n4th_space ," ).append("\n"); 
		query.append("(SELECT SLS_OFC_CD FROM PRD_PROD_CTL_MST M WHERE M.PCTL_NO = P.PCTL_NO) SLS_OFC_CD" ).append("\n"); 
		query.append(",(SELECT TTL_EXPN_AMT FROM PRD_PROD_CTL_MST M WHERE M.PCTL_NO = P.PCTL_NO) TTL_EXPN_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(select D.* , ROW_NUMBER() over (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) R," ).append("\n"); 
		query.append("(select 'V' from prd_prod_ctl_mst m where m.pctl_no = d.pctl_no and m.TRNK_VSL_CD = d.VSL_CD and m.TRNK_SKD_VOY_NO= d.SKD_VOY_NO and m.TRNK_SKD_DIR_CD =  d.SKD_DIR_CD) t_vvd" ).append("\n"); 
		query.append("from PRD_PROD_CTL_rout_dtl D" ).append("\n"); 
		query.append("where  PCTL_NO LIKE @[hd_pctl_no]||'%' --'J0001'" ).append("\n"); 
		query.append("and PCTL_IO_BND_CD='T'" ).append("\n"); 
		query.append("AND VSL_SLAN_CD IS NOT NULL  -- TD 등의 SHUTTLE 제거" ).append("\n"); 
		query.append("AND PCTL_NO IN ( SELECT DISTINCT  (PCTL_NO) PCTL_NO" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_rout_dtl" ).append("\n"); 
		query.append("WHERE PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD='T'" ).append("\n"); 
		query.append("--GROUP BY ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") P, PRD_OCN_ROUT O" ).append("\n"); 
		query.append("WHERE O.ORG_LOC_CD = P.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND O.DEST_LOC_CD = P.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND O.ROUT_SEQ = P.ROUT_SEQ" ).append("\n"); 
		query.append("GROUP BY PCTL_NO,ORG_LOC_CD,DEST_LOC_CD,O.ROUT_SEQ,LNK_KNT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY PCTL_NO,NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY RK,PCTL_NO,NO" ).append("\n"); 

	}
}