/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RegionDepartureReportDBDAOComIntgCdDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.20 이선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SunyoungLee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAOComIntgCdDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ComIntgCdDtlVO Select Query
	  * </pre>
	  */
	public RegionDepartureReportDBDAOComIntgCdDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intg_cd_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAOComIntgCdDtlVORSQL").append("\n"); 
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
		query.append("INTG_CD_ID" ).append("\n"); 
		query.append(",	INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append(",	INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append(",	INTG_CD_VAL_DESC" ).append("\n"); 
		query.append(",	INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append(",	APLY_ST_DT" ).append("\n"); 
		query.append(",	APLY_END_DT" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE	INTG_CD_ID = @[intg_cd_id]" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}