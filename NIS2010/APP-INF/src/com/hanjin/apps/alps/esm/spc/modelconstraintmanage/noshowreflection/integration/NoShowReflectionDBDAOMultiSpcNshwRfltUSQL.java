/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : NoShowReflectionDBDAOMultiSpcNshwRfltUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NoShowReflectionDBDAOMultiSpcNshwRfltUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * No-Show 반영기준 데이터  UPDATE
	  * </pre>
	  */
	public NoShowReflectionDBDAOMultiSpcNshwRfltUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_ddct_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_ddct_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_ddct_mod_val",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_ddct_cs_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aloc_ddct_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelconstraintmanage.noshowreflection.integration").append("\n"); 
		query.append("FileName : NoShowReflectionDBDAOMultiSpcNshwRfltUSQL").append("\n"); 
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
		query.append("UPDATE SPC_NSHW_RFLT" ).append("\n"); 
		query.append("   SET TRD_CD            = @[trd_cd]           ," ).append("\n"); 
		query.append("       SUB_TRD_CD        = @[sub_trd_cd]       ," ).append("\n"); 
		query.append("       RLANE_CD          = @[rlane_cd]         ," ).append("\n"); 
		query.append("       DIR_CD            = @[dir_cd]           ," ).append("\n"); 
		query.append("       ALOC_DDCT_BSE_CD  = @[aloc_ddct_bse_cd] ," ).append("\n"); 
		query.append("       ALOC_DDCT_CS_CD   = @[aloc_ddct_cs_cd]  ," ).append("\n"); 
		query.append("       ALOC_DDCT_TGT_CD  = @[aloc_ddct_tgt_cd] ," ).append("\n"); 
		query.append("       ALOC_DDCT_MOD_CD  = @[aloc_ddct_mod_cd] ," ).append("\n"); 
		query.append("       ALOC_DDCT_MOD_VAL = @[aloc_ddct_mod_val]," ).append("\n"); 
		query.append("       UPD_USR_ID        = @[upd_usr_id]       ," ).append("\n"); 
		query.append("       UPD_DT            = SYSDATE" ).append("\n"); 
		query.append(" WHERE TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("   AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("   AND DIR_CD     = @[dir_cd]" ).append("\n"); 

	}
}