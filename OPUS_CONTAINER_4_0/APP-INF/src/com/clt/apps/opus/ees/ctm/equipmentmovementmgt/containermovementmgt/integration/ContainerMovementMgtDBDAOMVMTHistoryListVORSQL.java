/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOMVMTHistoryListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOMVMTHistoryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOMVMTHistoryListVORSQL(){
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
		params.put("p_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOMVMTHistoryListVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT CTM.CNMV_CYC_NO," ).append("\n"); 
		query.append("       BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD AS VL," ).append("\n"); 
		query.append("       BKG.POR_CD," ).append("\n"); 
		query.append("       BKG.POL_CD," ).append("\n"); 
		query.append("       BKG.POD_CD," ).append("\n"); 
		query.append("       BKG.DEL_CD," ).append("\n"); 
		query.append("       BKG.BKG_NO," ).append("\n"); 
		query.append("       BKG.BL_NO," ).append("\n"); 
		query.append("       MDT.CMDT_NM AS REP_CMDT_NM," ).append("\n"); 
		query.append("       BKG.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       DECODE (BKG.POL_CD, BV.POL_CD, '', BV.POL_CD) AS RELAY" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("       BKG_CONTAINER BCNT," ).append("\n"); 
		query.append("       (SELECT DISTINCT CTR.BKG_NO," ).append("\n"); 
		query.append("               CTR.CNMV_CYC_NO," ).append("\n"); 
		query.append("               CTR.CNTR_NO" ).append("\n"); 
		query.append("          FROM CTM_MOVEMENT CTR" ).append("\n"); 
		query.append("         WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${p_cntrno} != '')" ).append("\n"); 
		query.append("   AND CTR.CNTR_NO = @[p_cntrno]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_date1} != '')" ).append("\n"); 
		query.append("   AND CTR.CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) CTM," ).append("\n"); 
		query.append("       MDM_COMMODITY MDT," ).append("\n"); 
		query.append("       BKG_VVD BV" ).append("\n"); 
		query.append(" WHERE CTM.CNTR_NO = BCNT.CNTR_NO" ).append("\n"); 
		query.append("   AND CTM.CNMV_CYC_NO = BCNT.CNMV_CYC_NO" ).append("\n"); 
		query.append("   AND BCNT.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.CMDT_CD = MDT.CMDT_CD(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.VSL_CD = BV.VSL_CD" ).append("\n"); 
		query.append("   AND BKG.SKD_VOY_NO = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND BKG.SKD_DIR_CD = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND BV.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append(" ORDER BY CTM.CNMV_CYC_NO ASC" ).append("\n"); 

	}
}