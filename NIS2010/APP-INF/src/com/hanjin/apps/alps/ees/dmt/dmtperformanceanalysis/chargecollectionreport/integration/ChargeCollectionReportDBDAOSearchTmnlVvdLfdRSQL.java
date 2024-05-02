/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeCollectionReportDBDAOSearchTmnlVvdLfdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCollectionReportDBDAOSearchTmnlVvdLfdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCollectionReportDBDAOSearchTmnlVvdLfdRSQL
	  * </pre>
	  */
	public ChargeCollectionReportDBDAOSearchTmnlVvdLfdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_tml_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecollectionreport.integration").append("\n"); 
		query.append("FileName : ChargeCollectionReportDBDAOSearchTmnlVvdLfdRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.YD_CD AS TML_YD_CD," ).append("\n"); 
		query.append("A.SLAN_CD TML_LAN_CD," ).append("\n"); 
		query.append("A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS TML_VVD," ).append("\n"); 
		query.append("B.VSL_ENG_NM AS TML_VSL_NM," ).append("\n"); 
		query.append("B.CRR_CD AS TML_OPR," ).append("\n"); 
		query.append("TO_CHAR(A.VPS_ETA_DT, 'YYYY-MM-DD') AS TML_VPS_ETA_DT," ).append("\n"); 
		query.append("TO_CHAR(A.VPS_ETB_DT, 'YYYY-MM-DD') AS TML_VPS_ETB_DT," ).append("\n"); 
		query.append("TO_CHAR(A.VPS_ETD_DT, 'YYYY-MM-DD') AS TML_VPS_ETD_DT," ).append("\n"); 
		query.append("A.CLPT_IND_SEQ AS TML_CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A, MDM_VSL_CNTR B" ).append("\n"); 
		query.append("WHERE YD_CD LIKE @[s_tml_yd_cd]||'%'" ).append("\n"); 
		query.append("AND VPS_ETA_DT BETWEEN TO_DATE(REPLACE(@[s_fm_dt],'-',''), 'YYYYMMDD') AND TO_DATE(REPLACE(@[s_to_dt],'-',''), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#if ( ${s_vvd} != '' )" ).append("\n"); 
		query.append("AND A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD LIKE @[s_vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 'Y' FROM BKG_BOOKING BB, BKG_VVD BV, BKG_CONTAINER BC" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BV.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND BV.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND BV.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND BV.POD_YD_CD = A.YD_CD" ).append("\n"); 
		query.append("AND BV.POD_CLPT_IND_SEQ = A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND BB.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND BB.POD_CD = BV.POD_CD" ).append("\n"); 
		query.append("AND BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BB.BKG_STS_CD = 'F'" ).append("\n"); 
		query.append("AND BB.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("AND ROWNUM = 1 )" ).append("\n"); 
		query.append("ORDER BY TML_YD_CD, TML_VVD, TML_VPS_ETA_DT" ).append("\n"); 

	}
}