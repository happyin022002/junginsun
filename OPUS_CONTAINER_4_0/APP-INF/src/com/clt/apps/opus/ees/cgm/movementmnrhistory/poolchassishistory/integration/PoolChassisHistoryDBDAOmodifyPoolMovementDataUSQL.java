/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PoolChassisHistoryDBDAOmodifyPoolMovementDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.05
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2014.12.05 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PoolChassisHistoryDBDAOmodifyPoolMovementDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PoolChassisHistoryDBDAOmodifyPoolMovementDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_use_co_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trkr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pool_co_gate_io_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pool_chss_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.integration").append("\n"); 
		query.append("FileName : PoolChassisHistoryDBDAOmodifyPoolMovementDataUSQL").append("\n"); 
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
		query.append("UPDATE CGM_POOL_MVMT_HIS" ).append("\n"); 
		query.append("	SET CHSS_OWNR_CO_CD=NVL(( SELECT CASE WHEN (A.ACIAC_DIV_CD = 'A' AND A.AGMT_LSTM_CD NOT IN ('NP','CP') )" ).append("\n"); 
		query.append("                 OR (A.ACIAC_DIV_CD <> 'A' AND B.EQ_ASET_STS_CD = 'LST')" ).append("\n"); 
		query.append("            THEN 'H' " ).append("\n"); 
		query.append("                     ELSE 'O' " ).append("\n"); 
		query.append("                END " ).append("\n"); 
		query.append("           FROM CGM_EQUIPMENT A , CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append("      WHERE A.EQ_NO= @[chss_no]" ).append("\n"); 
		query.append("       AND A.EQ_NO= B.EQ_NO" ).append("\n"); 
		query.append("       AND A.EQ_STS_SEQ = B.EQ_STS_SEQ" ).append("\n"); 
		query.append("		  ), 'O') " ).append("\n"); 
		query.append("      , VNDR_NM            = @[vndr_nm]" ).append("\n"); 
		query.append("      , CHSS_POOL_CD       = @[chss_pool_cd]" ).append("\n"); 
		query.append("      , CHSS_TPSZ_CD       = @[chss_tpsz_cd]" ).append("\n"); 
		query.append("      , EQ_TPSZ_REP_CD     = ''" ).append("\n"); 
		query.append("      , YD_CD              = @[yd_cd]" ).append("\n"); 
		query.append("      , YD_COM_FLG         = ''" ).append("\n"); 
		query.append("      , LOC_NM             = @[loc_nm]" ).append("\n"); 
		query.append("      , CNTR_NO            = @[cntr_no]" ).append("\n"); 
		query.append("      ,CNTR_OWNR_CO_CD     = decode(@[cntr_no],null,'','','',nvl((select  CASE WHEN  A.ACIAC_DIV_CD = 'A' OR  A.CNTR_STS_CD='LST' THEN 'H' " ).append("\n"); 
		query.append("               														 ELSE 'O'" ).append("\n"); 
		query.append("            													 END" ).append("\n"); 
		query.append("           														  from  MST_CONTAINER A" ).append("\n"); 
		query.append("        													 WHERE CNTR_NO =@[cntr_no]" ).append("\n"); 
		query.append("     														  ),'O'))" ).append("\n"); 
		query.append("      , POOL_CO_GATE_IO_CD = @[pool_co_gate_io_cd]" ).append("\n"); 
		query.append("      , CNTR_TPSZ_CD       = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("      , MGST_NO            = @[mgst_no]" ).append("\n"); 
		query.append("      , CHSS_USE_CO_NM     = @[chss_use_co_nm]" ).append("\n"); 
		query.append("      , UPD_USR_ID         = 'EDI_322'" ).append("\n"); 
		query.append("      , UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("      , POOL_CHSS_CO_CD     = @[pool_chss_co_cd]   " ).append("\n"); 
		query.append("	  , TRKR_NM				= @[trkr_nm]" ).append("\n"); 
		query.append("	  , MVMT_STS_NM			= @[mvmt_sts_nm] " ).append("\n"); 
		query.append("	  , CHSS_MVMT_ACT_CD	= @[act_cd]" ).append("\n"); 
		query.append(" WHERE CHSS_NO= @[chss_no]" ).append("\n"); 
		query.append("   AND MVMT_DT=TO_DATE(@[mvmt_dt],'RRRRMMDDHH24MI')" ).append("\n"); 

	}
}