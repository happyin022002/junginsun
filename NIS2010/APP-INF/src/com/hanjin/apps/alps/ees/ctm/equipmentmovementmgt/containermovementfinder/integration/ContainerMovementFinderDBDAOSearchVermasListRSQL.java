/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchVermasListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOSearchVermasListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Inbound vermas EDI 조회.
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchVermasListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchVermasListRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO," ).append("\n"); 
		query.append("  DECODE(BKG_NO, 'NONE', '', BKG_NO) AS BKG_NO," ).append("\n"); 
		query.append("  VGM_WGT_QTY," ).append("\n"); 
		query.append("  VRFD_WGT_CD," ).append("\n"); 
		query.append("  PTY_NM," ).append("\n"); 
		query.append("  VGM_MZD_TP_CD," ).append("\n"); 
		query.append("  TO_CHAR(VGM_VRFY_DT, 'YYYY-MM-DD HH24:MI') AS VGM_VRFY_DT," ).append("\n"); 
		query.append("  REF_NO," ).append("\n"); 
		query.append("  PTY_FUNC_CD," ).append("\n"); 
		query.append("  PTY_PSON_NM," ).append("\n"); 
		query.append("  VGM_SEQ," ).append("\n"); 
		query.append("  POL_YD_CD," ).append("\n"); 
		query.append("  SMT_NM," ).append("\n"); 
		query.append("  CASE WHEN POL_YD_CD IS NOT NULL" ).append("\n"); 
		query.append("         THEN TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', CRE_DT, SUBSTR(POL_YD_CD, 0, 5)), 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("       ELSE TO_CHAR(CRE_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("  END AS CRE_LOCL_DT," ).append("\n"); 
		query.append("  'EDI' AS VIA," ).append("\n"); 
		query.append("  '' AS P_DATE1," ).append("\n"); 
		query.append("  '' AS P_DATE2," ).append("\n"); 
		query.append("  '' AS RCC_CD," ).append("\n"); 
		query.append("  '' AS LCC_CD," ).append("\n"); 
		query.append("  '' AS ORG_YD_CD," ).append("\n"); 
		query.append("  '' AS DIVFLAG" ).append("\n"); 
		query.append("FROM CTM_VRFD_GRS_MASS_EDI_MSG" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("  AND CNTR_NO IN (" ).append("\n"); 
		query.append("  #foreach ($cntr_cd in ${cntr_no_list})" ).append("\n"); 
		query.append("      #if ($velocityCount < $cntr_no_list.size()) '$cntr_cd', #else '$cntr_cd' #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '')" ).append("\n"); 
		query.append("  AND BKG_NO IN (" ).append("\n"); 
		query.append("  #foreach ($bkg_no in ${bkg_no_list})" ).append("\n"); 
		query.append("      #if ($velocityCount < $bkg_no_list.size()) '$bkg_no', #else '$bkg_no' #end" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_yd_cd} != '')" ).append("\n"); 
		query.append("  AND POL_YD_CD LIKE @[org_yd_cd] || '%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  #if (${rcc_cd} != '' && ${rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("  AND POL_YD_CD IN (SELECT YD_CD FROM MDM_YARD" ).append("\n"); 
		query.append("                    WHERE LOC_CD IN (SELECT LOC_CD" ).append("\n"); 
		query.append("                                     FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                     WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("                                       AND SCC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                                                      WHERE DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("    #if (${lcc_cd} != '' && ${lcc_cd} != 'ALL')" ).append("\n"); 
		query.append("                                                        AND LCC_CD IN (" ).append("\n"); 
		query.append("      #foreach ($lcc_cd in ${lcc_cd_list})" ).append("\n"); 
		query.append("        #if ($velocityCount < $lcc_cd_list.size()) '$lcc_cd', #else '$lcc_cd' #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("                                                                      )" ).append("\n"); 
		query.append("    #elseif (${rcc_cd} != '' && ${rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("                                                        AND RCC_CD = @[rcc_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                                                     )" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${divflag} == 1)" ).append("\n"); 
		query.append("  AND CRE_DT BETWEEN TO_DATE (@[p_date1], 'YYYYMMDD') AND TO_DATE (@[p_date2], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND VGM_VRFY_DT BETWEEN TO_DATE (@[p_date1], 'YYYYMMDD') AND TO_DATE (@[p_date2], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CRE_DT ASC" ).append("\n"); 

	}
}