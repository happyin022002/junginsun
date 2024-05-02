/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxOutputMasterDataMgtDBDAOUnusedTotVesselVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2010.01.21 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Chang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxOutputMasterDataMgtDBDAOUnusedTotVesselVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Unused Vessel Over 30 Days search list
	  * </pre>
	  */
	public TonnageTaxOutputMasterDataMgtDBDAOUnusedTotVesselVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration").append("\n"); 
		query.append("FileName : TonnageTaxOutputMasterDataMgtDBDAOUnusedTotVesselVORSQL").append("\n"); 
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
		query.append("A.STL_YR" ).append("\n"); 
		query.append(",	A.VSL_CD" ).append("\n"); 
		query.append(",	A.VSL_SEQ" ).append("\n"); 
		query.append(",	A.TONG_FLET_TP_CD" ).append("\n"); 
		query.append(",	TO_CHAR(A.CTRT_ST_DT,'YYYYMMDD')  CTRT_ST_DT" ).append("\n"); 
		query.append(",	TO_CHAR(A.CTRT_END_DT,'YYYYMMDD') CTRT_END_DT" ).append("\n"); 
		query.append(",	A.LDB_CAPA_QTY" ).append("\n"); 
		query.append(",	A.DELT_FLG" ).append("\n"); 
		query.append(",	A.VSL_RMK" ).append("\n"); 
		query.append(",	TO_CHAR(A.CRE_DT,'YYYYMMDD')  CRE_DT" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(A.UPD_DT,'YYYYMMDD')  UPD_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(", NVL((SELECT DISTINCT VSL_ENG_NM FROM MDM_VSL_CNTR B WHERE B.VSL_CD = A.VSL_CD),'') VSL_ENG_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM TOT_VESSEL A" ).append("\n"); 
		query.append("WHERE	A.STL_YR = @[stl_yr]" ).append("\n"); 
		query.append("AND A.TONG_FLET_TP_CD = 'E'" ).append("\n"); 

	}
}