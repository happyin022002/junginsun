/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TonnageTaxOutputMasterDataMgtDBDAOVesselVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxOutputMasterDataMgtDBDAOVesselVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TonnageTaxOutputMasterDataMgtDBDAOVesselVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tong_flet_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration").append("\n"); 
		query.append("FileName : TonnageTaxOutputMasterDataMgtDBDAOVesselVORSQL").append("\n"); 
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
		query.append("      A.STL_YR" ).append("\n"); 
		query.append("      ,	A.VSL_CD" ).append("\n"); 
		query.append("      ,	A.VSL_SEQ" ).append("\n"); 
		query.append("      ,	A.TONG_FLET_TP_CD" ).append("\n"); 
		query.append("      ,	TO_CHAR(A.CTRT_ST_DT,'YYYYMMDD')  CTRT_ST_DT" ).append("\n"); 
		query.append("      ,	TO_CHAR(A.CTRT_END_DT,'YYYYMMDD') CTRT_END_DT" ).append("\n"); 
		query.append("      ,	A.LDB_CAPA_QTY" ).append("\n"); 
		query.append("      ,	A.DELT_FLG" ).append("\n"); 
		query.append("      ,	A.VSL_RMK" ).append("\n"); 
		query.append("      ,	TO_CHAR(A.CRE_DT,'YYYYMMDD')  CRE_DT" ).append("\n"); 
		query.append("      ,	A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,	TO_CHAR(A.UPD_DT,'YYYYMMDD')  UPD_DT" ).append("\n"); 
		query.append("      ,	A.UPD_USR_ID" ).append("\n"); 
		query.append("      , NVL((SELECT DISTINCT VSL_ENG_NM FROM MDM_VSL_CNTR B WHERE B.VSL_CD = A.VSL_CD),'') VSL_ENG_NM" ).append("\n"); 
		query.append("      , TO_CHAR(C.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append("      , TO_CHAR(C.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("FROM TOT_VESSEL A," ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("          SELECT VSL_CD, EFF_DT, EXP_DT " ).append("\n"); 
		query.append("          FROM FMS_CONTRACT " ).append("\n"); 
		query.append("          WHERE FLET_CTRT_NO IN (" ).append("\n"); 
		query.append("              SELECT MAX(FLET_CTRT_NO) FLET_CTRT_NO FROM FMS_CONTRACT" ).append("\n"); 
		query.append("              WHERE DECODE(FLET_CTRT_TP_CD, 'TI', 'C', 'TO', 'T', 'OW', 'O') = @[tong_flet_tp_cd]" ).append("\n"); 
		query.append("              GROUP BY VSL_CD" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("     ) C " ).append("\n"); 
		query.append("WHERE	A.STL_YR = @[stl_yr]" ).append("\n"); 
		query.append("      AND	A.TONG_FLET_TP_CD = @[tong_flet_tp_cd]" ).append("\n"); 
		query.append("      AND A.TONG_FLET_TP_CD <> 'E'" ).append("\n"); 
		query.append("      AND A.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("     ORDER BY A.VSL_CD , A.VSL_SEQ" ).append("\n"); 

	}
}