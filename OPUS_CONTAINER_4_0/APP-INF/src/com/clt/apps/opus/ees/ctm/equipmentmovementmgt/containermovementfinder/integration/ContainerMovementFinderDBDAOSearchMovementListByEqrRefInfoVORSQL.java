/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchMovementListByEqrRefInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.18 
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

public class ContainerMovementFinderDBDAOSearchMovementListByEqrRefInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMovementListByEqrRefInfoVO
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchMovementListByEqrRefInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pln_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchMovementListByEqrRefInfoVORSQL").append("\n"); 
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
		query.append("SELECT V.REPO_PLN_ID," ).append("\n"); 
		query.append("    V.REF_ID," ).append("\n"); 
		query.append("	V.REF_ID AS MTY_PLN_NO," ).append("\n"); 
		query.append("    V.PLN_YRWK," ).append("\n"); 
		query.append("    V.EQ_TYPE," ).append("\n"); 
		query.append("    V.ITEM," ).append("\n"); 
		query.append("    V.FM_YD," ).append("\n"); 
		query.append("    V.FM_DT," ).append("\n"); 
		query.append("    V.TO_YD," ).append("\n"); 
		query.append("    V.TO_DT," ).append("\n"); 
		query.append("    V.MTY_BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("FROM (SELECT VP.REPO_PLN_ID," ).append("\n"); 
		query.append("        VP.REF_ID," ).append("\n"); 
		query.append("        VP.PLN_YRWK," ).append("\n"); 
		query.append("        'T.VVD' AS EQ_TYPE," ).append("\n"); 
		query.append("        DECODE(VP.TRSP_MOD_CD, 'V', 'T.VVD', 'T', 'Truck', 'R', 'Rail', 'Water') AS ITEM," ).append("\n"); 
		query.append("        SUBSTR(VP.FM_YD_CD,1,5) AS FM_YD," ).append("\n"); 
		query.append("        VP.FM_ETD_DT AS FM_DT," ).append("\n"); 
		query.append("        SUBSTR(VP.TO_YD_CD,1,5) AS TO_YD," ).append("\n"); 
		query.append("        VP.TO_ETB_DT AS TO_DT," ).append("\n"); 
		query.append("        VP.MTY_BKG_NO" ).append("\n"); 
		query.append("    FROM EQR_VSL_LODG_DCHG_EXE_PLN VP" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT IP.REPO_PLN_ID," ).append("\n"); 
		query.append("        IP.REF_ID," ).append("\n"); 
		query.append("        IP.PLN_YRWK," ).append("\n"); 
		query.append("        'T/R/W' AS EQ_TYPE," ).append("\n"); 
		query.append("        DECODE(IP.TRSP_MOD_CD, 'V', 'T.VVD', 'T', 'Truck', 'R', 'Rail', 'Water') AS ITEM," ).append("\n"); 
		query.append("        SUBSTR(IP.FM_YD_CD,1,5) AS FM_YD," ).append("\n"); 
		query.append("        IP.FM_ETD_DT AS FM_DT," ).append("\n"); 
		query.append("        SUBSTR(IP.TO_YD_CD,1,5) AS TO_YD," ).append("\n"); 
		query.append("        IP.TO_ETA_DT AS TO_DT," ).append("\n"); 
		query.append("        IP.MTY_BKG_NO" ).append("\n"); 
		query.append("    FROM EQR_INLND_TRSP_EXE_PLN IP" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT EP.REPO_PLN_ID," ).append("\n"); 
		query.append("        EP.REF_ID," ).append("\n"); 
		query.append("        EP.PLN_YRWK," ).append("\n"); 
		query.append("        'LCC Int.' AS EQ_TYPE," ).append("\n"); 
		query.append("        DECODE(EP.TRSP_MOD_CD, 'V', 'T.VVD', 'T', 'Truck', 'R', 'Rail', 'Water') AS ITEM," ).append("\n"); 
		query.append("        SUBSTR(EP.FM_YD_CD,1,5) AS FM_YD," ).append("\n"); 
		query.append("        EP.FM_ETD_DT AS FM_DT," ).append("\n"); 
		query.append("        SUBSTR(EP.TO_YD_CD,1,5) AS TO_YD," ).append("\n"); 
		query.append("        EP.TO_ETA_DT AS TO_DT," ).append("\n"); 
		query.append("        '' AS MTY_BKG_NO" ).append("\n"); 
		query.append("    FROM EQR_ECC_INTER_EXE_PLN EP" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT OP.REPO_PLN_ID," ).append("\n"); 
		query.append("        OP.REF_ID," ).append("\n"); 
		query.append("        OP.PLN_YRWK," ).append("\n"); 
		query.append("        'ON/OFH' AS EQ_TYPE," ).append("\n"); 
		query.append("        '' AS ITEM," ).append("\n"); 
		query.append("        SUBSTR(OP.FM_YD_CD,1,5) AS FM_YD," ).append("\n"); 
		query.append("        TO_DATE(OP.FM_LOC_DT, 'YYYY/MM/DD HH24:MI:SS') AS FM_DT," ).append("\n"); 
		query.append("        SUBSTR(OP.TO_YD_CD,1,5) AS TO_YD," ).append("\n"); 
		query.append("        TO_DATE(OP.TO_LOC_DT, 'YYYY/MM/DD HH24:MI:SS') AS TO_DT," ).append("\n"); 
		query.append("        '' AS MTY_BKG_NO" ).append("\n"); 
		query.append("    FROM EQR_ONF_HIR_EXE_PLN OP) V" ).append("\n"); 
		query.append("WHERE V.REF_ID = @[mty_pln_no]" ).append("\n"); 

	}
}