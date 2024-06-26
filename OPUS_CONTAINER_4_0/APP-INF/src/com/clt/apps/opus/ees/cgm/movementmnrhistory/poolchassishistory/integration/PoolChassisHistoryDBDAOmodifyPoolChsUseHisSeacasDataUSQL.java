/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PoolChassisHistoryDBDAOmodifyPoolChsUseHisSeacasDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.29 조재성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisHistoryDBDAOmodifyPoolChsUseHisSeacasDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PoolChassisHistoryDBDAOmodifyPoolChsUseHisSeacasDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pool_chss_usd_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("offh_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yyyy_mm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_pool_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ownr_co_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onh_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.integration").append("\n"); 
		query.append("FileName : PoolChassisHistoryDBDAOmodifyPoolChsUseHisSeacasDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_POOL_CO_CHSS_USE_HIS" ).append("\n"); 
		query.append("SET OFFH_DT             =   decode(@[offh_dt],null,null,'NULL',null,'null',null,'',null,to_date(@[offh_dt],'DD/MON/yy  HH24:MI:SS', 'NLS_DATE_LANGUAGE = American') )" ).append("\n"); 
		query.append(",POOL_CHSS_USD_DYS   =   @[pool_chss_usd_dys]" ).append("\n"); 
		query.append(",CHSS_OWNR_CO_CD     =    CASE WHEN EXISTS (SELECT 'X' FROM MST_CNTR_STS_HIS H" ).append("\n"); 
		query.append("WHERE H.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND H.CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("AND H.CNTR_STS_EVNT_DT BETWEEN  TO_DATE(@[yyyy_mm], 'YYYY-MM' ) AND ADD_MONTHS( TO_DATE(@[yyyy_mm], 'YYYY-MM' ),1)" ).append("\n"); 
		query.append(") THEN 'H'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NVL( (SELECT /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS  )  */" ).append("\n"); 
		query.append("CASE WHEN CNTR_STS_CD IN ('LSI','OWN') THEN 'H'" ).append("\n"); 
		query.append("ELSE 'O'" ).append("\n"); 
		query.append("END CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append("FROM MST_CNTR_STS_HIS H" ).append("\n"); 
		query.append("WHERE H.CNTR_NO =  @[cntr_no]" ).append("\n"); 
		query.append("AND H.CNTR_STS_CD IN ('LSI','OWN','LSO','TLL','SCR','SLD')" ).append("\n"); 
		query.append("AND H.CNTR_STS_EVNT_DT < TO_DATE(@[yyyy_mm], 'YYYY-MM' )" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append(",'O')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(",CNTR_NO             =   NVL(  (SELECT CNTR_NO FROM MST_CONTAINER" ).append("\n"); 
		query.append("WHERE CNTR_NO LIKE NVL( TRIM( SUBSTR( @[cntr_no],1,10) )  , '          ' )  ||'%'" ).append("\n"); 
		query.append("AND ROWNUM=1 ) , @[cntr_no]  )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",CNTR_OWNR_CO_CD     =   CASE WHEN EXISTS (SELECT 'X' FROM MST_CNTR_STS_HIS H" ).append("\n"); 
		query.append("WHERE H.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND H.CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("AND H.CNTR_STS_EVNT_DT BETWEEN  TO_DATE(@[yyyy_mm], 'YYYY-MM' ) AND ADD_MONTHS( TO_DATE(@[yyyy_mm], 'YYYY-MM' ),1)" ).append("\n"); 
		query.append(") THEN 'H'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("NVL( (SELECT /*+ INDEX_DESC(H XAK1MST_CNTR_STS_HIS  )  */" ).append("\n"); 
		query.append("CASE WHEN CNTR_STS_CD IN ('LSI','OWN') THEN 'H'" ).append("\n"); 
		query.append("ELSE 'O'" ).append("\n"); 
		query.append("END CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append("FROM MST_CNTR_STS_HIS H" ).append("\n"); 
		query.append("WHERE H.CNTR_NO =  @[cntr_no]" ).append("\n"); 
		query.append("AND H.CNTR_STS_CD IN ('LSI','OWN','LSO','TLL','SCR','SLD')" ).append("\n"); 
		query.append("AND H.CNTR_STS_EVNT_DT < TO_DATE(@[yyyy_mm], 'YYYY-MM' )" ).append("\n"); 
		query.append("AND ROWNUM =1)" ).append("\n"); 
		query.append(",'O')" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(",CNTR_OWNR_CO_NM     =  @[cntr_ownr_co_nm]" ).append("\n"); 
		query.append(",CHSS_POOL_CD        =  @[chss_pool_cd]" ).append("\n"); 
		query.append(",ONH_LOC_NM          =  @[onh_loc_nm]" ).append("\n"); 
		query.append(",OFFH_LOC_NM         =  @[offh_loc_nm]" ).append("\n"); 
		query.append(",UPD_USR_ID          =  @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT              =  SYSDATE" ).append("\n"); 
		query.append(",FILE_SEQ            =  @[file_seq]" ).append("\n"); 
		query.append("WHERE CHSS_NO    = @[chss_no]" ).append("\n"); 
		query.append("AND ONH_DT    =  to_date(@[onh_dt],'DD-MON-YY HH24:MI:SS', 'NLS_DATE_LANGUAGE = American')" ).append("\n"); 

	}
}