/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchSubsidiaryAccountMatrixInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOSearchSubsidiaryAccountMatrixInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.04.09 [CHM-201217079-01] 이준범
	  * 1.Expense Code Maintenance for subsidiary  신규 기능 추가
	  *   : 조회 SQL
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchSubsidiaryAccountMatrixInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_lvl3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_hohq_gbn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_office_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_lvl2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sch_lvl1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchSubsidiaryAccountMatrixInfoRSQL").append("\n"); 
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
		query.append("SELECT A.OFC_CD" ).append("\n"); 
		query.append("      ,A.SUBS_ACCT_CD" ).append("\n"); 
		query.append("      ,A.SUBS_ACCT_KRN_NM" ).append("\n"); 
		query.append("      ,A.SUBS_ACCT_ENG_NM" ).append("\n"); 
		query.append("      ,A.SUBS_ACCT_KRN_DESC" ).append("\n"); 
		query.append("      ,A.SUBS_ACCT_ENG_DESC" ).append("\n"); 
		query.append("      ,A.GEN_EXPN_CD" ).append("\n"); 
		query.append("      ,(SELECT B.TIC_CD FROM GEM_EXPENSE B WHERE B.GEN_EXPN_CD = A.GEN_EXPN_CD ) AS TIC_CD" ).append("\n"); 
		query.append("      ,A.DELT_FLG" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR (A.CRE_DT, 'YYYYMMDD') AS CRE_DT" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID" ).append("\n"); 
		query.append("      ,TO_CHAR (A.UPD_DT, 'YYYYMMDD') AS UPD_DT" ).append("\n"); 
		query.append("  FROM GEM_SUBS_ACCT_MTX A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${sch_hohq_gbn} != '')" ).append("\n"); 
		query.append("   AND A.OFC_CD IN (   " ).append("\n"); 
		query.append("                     SELECT DISTINCT L_4 AS CODE" ).append("\n"); 
		query.append("                       FROM GEM_OFC_LEVEL_V" ).append("\n"); 
		query.append("                      WHERE 1=1" ).append("\n"); 
		query.append("                     #if(${sch_hohq_gbn} != '')" ).append("\n"); 
		query.append("                        AND RGN_OFC_FLG LIKE @[sch_hohq_gbn]||'%'" ).append("\n"); 
		query.append("		             #end			" ).append("\n"); 
		query.append("		             #if(${sch_lvl1} != '' && ${sch_lvl2} != '' && ${sch_lvl3} != '')" ).append("\n"); 
		query.append("                        AND L_4 LIKE @[sch_lvl3]||'%' " ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("	              	 #if(${sch_lvl1} != '' && ${sch_lvl2} != '' && ${sch_lvl3} == '') " ).append("\n"); 
		query.append("                        AND L_3 LIKE @[sch_lvl2]||'%' " ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("		             #if(${sch_lvl1} != '' && ${sch_lvl2} == '' && ${sch_lvl3} == '') " ).append("\n"); 
		query.append("                        AND L_2 LIKE @[sch_lvl1]||'%' " ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_office_gbn} == 'Y')" ).append("\n"); 
		query.append("   #if(${sch_office_code} != '')" ).append("\n"); 
		query.append("   AND A.OFC_CD LIKE @[sch_office_code]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_office_gbn} == 'N')" ).append("\n"); 
		query.append("   #if(${sch_office_code} != '')" ).append("\n"); 
		query.append("   AND A.GEN_EXPN_CD LIKE @[sch_office_code]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${sch_delt_flg} == 'Y')" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}