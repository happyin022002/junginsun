/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonDBDAOSearchTgtOrzCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.common.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchTgtOrzCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CommonDBDAOSearchTgtOrzCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("orzType",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("orzCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("targetGrp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.common.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchTgtOrzCdListRSQL").append("\n"); 
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
		query.append("WITH PARAMS AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT" ).append("\n"); 
		query.append("         @[year] AS BSE_YR" ).append("\n"); 
		query.append("         ,@[bse_qtr_cd] AS BSE_QTR_CD" ).append("\n"); 
		query.append("         ,@[targetGrp] AS SAQ_TGT_GRP_CD" ).append("\n"); 
		query.append("         ,@[version] AS GLINE_VER_NO" ).append("\n"); 
		query.append("         ,@[orzType] AS ORZ_TYPE" ).append("\n"); 
		query.append("         ,@[orzCd] AS ORZ_CD" ).append("\n"); 
		query.append("   FROM  DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",CRE_OFC_CD AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT" ).append("\n"); 
		query.append("         OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("   FROM  SAQ_ORGANIZATION_V" ).append("\n"); 
		query.append("   WHERE 'HO' = (SELECT ORZ_TYPE FROM PARAMS)" ).append("\n"); 
		query.append("   AND   OFC_CD = (SELECT ORZ_CD FROM PARAMS)" ).append("\n"); 
		query.append("   UNION ALL" ).append("\n"); 
		query.append("   SELECT" ).append("\n"); 
		query.append("         N2ND_PRNT_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("   FROM  SAQ_ORGANIZATION_V" ).append("\n"); 
		query.append("   WHERE 'RHQ' = (SELECT ORZ_TYPE FROM PARAMS)" ).append("\n"); 
		query.append("   AND   OFC_CD = (SELECT ORZ_CD FROM PARAMS)" ).append("\n"); 
		query.append("   UNION ALL" ).append("\n"); 
		query.append("   SELECT" ).append("\n"); 
		query.append("         OFC_CD" ).append("\n"); 
		query.append("   FROM  SAQ_ORGANIZATION_V" ).append("\n"); 
		query.append("   WHERE 'OFC' = (SELECT ORZ_TYPE FROM PARAMS)" ).append("\n"); 
		query.append("   AND   OFC_CD = (SELECT ORZ_CD FROM PARAMS)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("      A.@[orzCd] AS CODE" ).append("\n"); 
		query.append("      ,INTG_CD_VAL_DP_DESC||'||'" ).append("\n"); 
		query.append("      	||TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC('GMT', SMRY_CRE_GDT, INP.ORZ_CD), 'YYYY-MM-DD HH24:MI') AS TEXT" ).append("\n"); 
		query.append("FROM  @[orzCd] a" ).append("\n"); 
		query.append("      JOIN" ).append("\n"); 
		query.append("      PARAMS INP" ).append("\n"); 
		query.append("      ON" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("         A.BSE_YR = INP.BSE_YR" ).append("\n"); 
		query.append("#if (${pType} == 'M' )" ).append("\n"); 
		query.append("	         AND A.BSE_QTR_CD = INP.BSE_QTR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND A.SAQ_TGT_GRP_CD = INP.SAQ_TGT_GRP_CD" ).append("\n"); 
		query.append("         AND A.GLINE_VER_NO = INP.GLINE_VER_NO" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("      JOIN" ).append("\n"); 
		query.append("      COM_INTG_CD_DTL COM" ).append("\n"); 
		query.append("      ON" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("         COM.INTG_CD_ID = 'CD00964'" ).append("\n"); 
		query.append("         AND A.@[orzCd] = COM.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND   (" ).append("\n"); 
		query.append("         CRE_OFC_CD = (SELECT OFC_CD FROM CRE_OFC_CD)" ).append("\n"); 
		query.append("         OR" ).append("\n"); 
		query.append("         CRE_OFC_CD = '000000'" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("ORDER BY SMRY_CRE_GDT DESC" ).append("\n"); 

	}
}