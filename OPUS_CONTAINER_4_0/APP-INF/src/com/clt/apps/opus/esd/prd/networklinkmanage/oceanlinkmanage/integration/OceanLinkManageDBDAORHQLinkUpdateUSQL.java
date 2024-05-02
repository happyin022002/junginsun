/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OceanLinkManageDBDAORHQLinkUpdateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.17 김귀진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanLinkManageDBDAORHQLinkUpdateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQLinkUpdate
	  * </pre>
	  */
	public OceanLinkManageDBDAORHQLinkUpdateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fqc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_tu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sp_bd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_wb",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_st",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fi",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_mn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_t_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_te",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.integration ").append("\n"); 
		query.append("FileName : OceanLinkManageDBDAORHQLinkUpdateUSQL").append("\n"); 
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
		query.append("UPDATE PRD_FDR_LNK" ).append("\n"); 
		query.append("SET    VSL_SLAN_CD     = @[s_lane] ," ).append("\n"); 
		query.append("LNK_ORG_LOC_CD  = @[h_from] ," ).append("\n"); 
		query.append("LNK_DEST_LOC_CD = @[h_to] ," ).append("\n"); 
		query.append("TZTM_HRS        = TO_NUMBER(@[s_t_time]) ," ).append("\n"); 
		query.append("FDR_FREQ_KNT    = TO_NUMBER(@[s_fqc]) ," ).append("\n"); 
		query.append("VNDR_SEQ        = TO_NUMBER(@[s_sp_bd]) ," ).append("\n"); 
		query.append("PCTL_IO_BND_CD  = @[s_bd] ," ).append("\n"); 
		query.append("LNK_RMK         = '' ," ).append("\n"); 
		query.append("UPD_USR_ID      = @[upd_usr_id] ," ).append("\n"); 
		query.append("UPD_DT          = sysdate," ).append("\n"); 
		query.append("SKD_DIR_CD      = @[s_dr] ," ).append("\n"); 
		query.append("SUN_ST_FLG      = DECODE(@[s_sn],'1','Y','N') ," ).append("\n"); 
		query.append("MON_ST_FLG      = DECODE(@[s_mn],'1','Y','N') ," ).append("\n"); 
		query.append("TUE_ST_FLG      = DECODE(@[s_te],'1','Y','N') ," ).append("\n"); 
		query.append("WED_ST_FLG      = DECODE(@[s_wb],'1','Y','N') ," ).append("\n"); 
		query.append("THU_ST_FLG      = DECODE(@[s_tu],'1','Y','N') ," ).append("\n"); 
		query.append("FRI_ST_FLG      = DECODE(@[s_fi],'1','Y','N') ," ).append("\n"); 
		query.append("SAT_ST_FLG      = DECODE(@[s_st],'1','Y','N')" ).append("\n"); 
		query.append("WHERE  LNK_ORG_LOC_CD  = @[h_from]" ).append("\n"); 
		query.append("AND    LNK_DEST_LOC_CD = @[h_to]" ).append("\n"); 

	}
}