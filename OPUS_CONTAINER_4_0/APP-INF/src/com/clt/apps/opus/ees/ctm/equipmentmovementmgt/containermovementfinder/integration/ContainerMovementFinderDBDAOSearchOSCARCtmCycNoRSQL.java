/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchOSCARCtmCycNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOSearchOSCARCtmCycNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOSCARCtmCycNo
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchOSCARCtmCycNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchOSCARCtmCycNoRSQL").append("\n"); 
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
		query.append("SELECT OSCAR_FLAG," ).append("\n"); 
		query.append("    BKG_NO," ).append("\n"); 
		query.append("    CNTR_NO," ).append("\n"); 
		query.append("    CNMV_CYC_NO," ).append("\n"); 
		query.append("    CNMV_STS_CD," ).append("\n"); 
		query.append("    CNMV_EVNT_DT," ).append("\n"); 
		query.append("    MAX_CNMV_CYC_NO," ).append("\n"); 
		query.append("    VPS_ETD_DT," ).append("\n"); 
		query.append("    TRUNK_VVD" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("select " ).append("\n"); 
		query.append("        'N' OSCAR_FLAG, BKG_NO, CNTR_NO, CNMV_CYC_NO, CNMV_STS_CD, CNMV_EVNT_DT" ).append("\n"); 
		query.append("        , nvl((" ).append("\n"); 
		query.append("                select max(CNMV_CYC_NO) CNMV_CYC_NO" ).append("\n"); 
		query.append("                from " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    select max(CNMV_CYC_NO) CNMV_CYC_NO from BKG_CONTAINER where 1=1  and CNTR_NO = @[cntr_no] and CNMV_CYC_NO <> 9999" ).append("\n"); 
		query.append("                    union all" ).append("\n"); 
		query.append("                    select max(CNMV_CYC_NO) CNMV_CYC_NO from CTM_BKG_CNTR where 1=1  and CNTR_NO = @[cntr_no] and CNMV_CYC_NO <> 9999" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("               ),0) MAX_CNMV_CYC_NO" ).append("\n"); 
		query.append("		, (SELECT POL_ETD_DT FROM BKG_BOOKING CB WHERE CB.BKG_NO=BC.BKG_NO ) VPS_ETD_DT" ).append("\n"); 
		query.append("		, (SELECT CBV.VSL_CD||CBV.SKD_VOY_NO||CBV.SKD_DIR_CD AS TRUNK_VVD" ).append("\n"); 
		query.append("           FROM BKG_VVD CBV" ).append("\n"); 
		query.append("           WHERE CBV.BKG_NO=BC.BKG_NO" ).append("\n"); 
		query.append("           AND CBV.VSL_PRE_PST_CD='T'" ).append("\n"); 
		query.append("           AND ROWNUM = 1) TRUNK_VVD" ).append("\n"); 
		query.append("from BKG_CONTAINER BC" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("        'Y' OSCAR_FLAG, BKG_NO, CNTR_NO, CNMV_CYC_NO, CNMV_STS_CD, CNMV_EVNT_DT" ).append("\n"); 
		query.append("        , nvl((" ).append("\n"); 
		query.append("                select max(CNMV_CYC_NO) CNMV_CYC_NO" ).append("\n"); 
		query.append("                from " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    select max(CNMV_CYC_NO) CNMV_CYC_NO from BKG_CONTAINER where 1=1  and CNTR_NO = @[cntr_no] and CNMV_CYC_NO <> 9999" ).append("\n"); 
		query.append("                    union all" ).append("\n"); 
		query.append("                    select max(CNMV_CYC_NO) CNMV_CYC_NO from CTM_BKG_CNTR where 1=1  and CNTR_NO = @[cntr_no] and CNMV_CYC_NO <> 9999" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("               ),0) MAX_CNMV_CYC_NO" ).append("\n"); 
		query.append("		, (SELECT VPS_ETD_DT FROM CTM_BOOKING CB WHERE CB.BKG_NO=CBC.BKG_NO ) VPS_ETD_DT" ).append("\n"); 
		query.append("		, (SELECT CBV.VSL_CD||CBV.SKD_VOY_NO||CBV.SKD_DIR_CD AS TRUNK_VVD" ).append("\n"); 
		query.append("           FROM CTM_BKG_VVD CBV" ).append("\n"); 
		query.append("           WHERE CBV.BKG_NO=CBC.BKG_NO" ).append("\n"); 
		query.append("           AND CBV.VSL_PRE_PST_CD='T'" ).append("\n"); 
		query.append("           AND ROWNUM = 1) TRUNK_VVD" ).append("\n"); 
		query.append("from CTM_BKG_CNTR CBC" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append("ORDER BY VPS_ETD_DT" ).append("\n"); 

	}
}