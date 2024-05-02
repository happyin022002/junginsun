/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAOSearchImpVslMvmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.19 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAOSearchImpVslMvmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Import Vsl Movement List
	  * </pre>
	  */
	public RegionDepartureReportDBDAOSearchImpVslMvmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAOSearchImpVslMvmtRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT 'I'IBFLAG,A.VPS_PORT_CD PORT_CD" ).append("\n"); 
		query.append(",      A.CLPT_IND_SEQ" ).append("\n"); 
		query.append(",      A.VPS_ETA_DT AS  ARR_TIME" ).append("\n"); 
		query.append(",      A.VPS_ETB_DT AS  BERTH_TIME" ).append("\n"); 
		query.append(",      U.ACT_DEP_DT AS  UNBERTH_TIME" ).append("\n"); 
		query.append(",      A.VPS_ETD_DT AS  DEP_TIME" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD A," ).append("\n"); 
		query.append("( SELECT VPS_ETA_DT" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO  = @[voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD  = @[dir_cd]" ).append("\n"); 
		query.append("AND    VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND    CLPT_SEQ    = ( SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("WHERE  VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("AND    SKD_VOY_NO  = @[voy_no]" ).append("\n"); 
		query.append("AND    SKD_DIR_CD  = @[dir_cd]" ).append("\n"); 
		query.append("AND    VPS_PORT_CD = @[port_cd])" ).append("\n"); 
		query.append(") B," ).append("\n"); 
		query.append("VSK_ACT_PORT_SKD U" ).append("\n"); 
		query.append("WHERE  A.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND    A.VPS_ETA_DT > ( SELECT MAX(C.VPS_ETA_DT)" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD C, CD_PORT D," ).append("\n"); 
		query.append("( SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("FROM   ( SELECT B.REGION" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD A, CD_PORT B" ).append("\n"); 
		query.append("WHERE  A.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO  = @[voy_no]" ).append("\n"); 
		query.append("AND    A.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("GROUP BY B.REGION ) ) L" ).append("\n"); 
		query.append("WHERE C.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("AND   ( C.SKD_CNG_STS_CD IS NULL OR C.SKD_CNG_STS_CD <> 'S')" ).append("\n"); 
		query.append("AND   D.REGION           <> DECODE (L.CNT, 1, @[region] ||@[region], @[region])" ).append("\n"); 
		query.append("AND   ( C.SKD_VOY_NO     <  DECODE (L.CNT, 1, @[voy_no], '9999')" ).append("\n"); 
		query.append("OR C.SKD_DIR_CD  <> DECODE (L.CNT, 1, @[dir_cd], @[dir_cd] || @[dir_cd]) )" ).append("\n"); 
		query.append("AND   C.VPS_PORT_CD      =  D.PORT_CD" ).append("\n"); 
		query.append("AND   C.VPS_ETA_DT       <  B.VPS_ETA_DT)" ).append("\n"); 
		query.append("AND    A.VPS_ETA_DT     <= B.VPS_ETA_DT" ).append("\n"); 
		query.append("AND    ( A.SKD_CNG_STS_CD IS NULL OR A.SKD_CNG_STS_CD <> 'S')" ).append("\n"); 
		query.append("AND    A.VSL_CD          = U.VSL_CD(+)" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO      = U.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD      = U.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND    A.VPS_PORT_CD     = U.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND    A.CLPT_IND_SEQ    = U.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("AND    A.PORT_SKD_STS_CD = U.PORT_SKD_STS_CD(+)" ).append("\n"); 
		query.append("AND    NVL(U.ACT_ARR_DT,SYSDATE) > NVL(( SELECT MAX(C.VPS_ETA_DT)" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD C, CD_PORT D," ).append("\n"); 
		query.append("( SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("FROM   ( SELECT B.REGION" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD A, CD_PORT B" ).append("\n"); 
		query.append("WHERE  A.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO  = @[voy_no]" ).append("\n"); 
		query.append("AND    A.VPS_PORT_CD = B.PORT_CD" ).append("\n"); 
		query.append("GROUP BY B.REGION ) ) L" ).append("\n"); 
		query.append("WHERE C.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("AND   ( C.SKD_CNG_STS_CD IS NULL OR C.SKD_CNG_STS_CD <> 'S')" ).append("\n"); 
		query.append("AND   D.REGION           <> DECODE (L.CNT, 1, @[region] || @[region], @[region])" ).append("\n"); 
		query.append("AND   ( C.SKD_VOY_NO     <  DECODE (L.CNT, 1, @[voy_no], '9999')" ).append("\n"); 
		query.append("OR C.SKD_DIR_CD  <> DECODE (L.CNT, 1, @[dir_cd], @[dir_cd] || @[dir_cd]) )" ).append("\n"); 
		query.append("AND   C.VPS_PORT_CD      =  D.PORT_CD" ).append("\n"); 
		query.append("AND   C.VPS_ETA_DT       <  B.VPS_ETA_DT),SYSDATE -1)" ).append("\n"); 
		query.append("AND    NVL(U.ACT_ARR_DT,SYSDATE-1) <= NVL(B.VPS_ETA_DT,SYSDATE)" ).append("\n"); 
		query.append("ORDER BY  A.VPS_ETA_DT" ).append("\n"); 

	}
}