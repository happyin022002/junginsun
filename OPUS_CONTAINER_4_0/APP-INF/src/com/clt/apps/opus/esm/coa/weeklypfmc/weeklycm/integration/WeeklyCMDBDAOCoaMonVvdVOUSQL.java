/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WeeklyCMDBDAOCoaMonVvdVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.05.14 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOCoaMonVvdVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * B: BOTH, C: COA Only 일때 COA_MON_VVD Update  
	  *  
	  * History--------------------------------------------
	  * 2010.05.17  이행지 Ticket ID : CHM-201003818 - 월간 대상항차 REV month(Cost Mon)확정 logic 개선
	  * </pre>
	  */
	public WeeklyCMDBDAOCoaMonVvdVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rslt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibflag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOCoaMonVvdVOUSQL").append("\n"); 
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
		query.append("UPDATE COA_MON_VVD VVD" ).append("\n"); 
		query.append("   SET VVD.COST_YRMON     = DECODE(@[rslt_cd], 'B', @[f_cost_yr]||@[f_cost_fm_mon] , 'C', @[cost_yrmon] , VVD.COST_YRMON)" ).append("\n"); 
		query.append("      ,VVD.COST_WK        = DECODE(@[rslt_cd], 'C', @[cost_wk] , VVD.COST_WK)" ).append("\n"); 
		query.append("      ,VVD.WKY_TGT_FLG    = DECODE(@[rslt_cd], 'B', 'Y', 'C', DECODE(@[ibflag], 'U', 'Y', VVD.WKY_TGT_FLG), VVD.WKY_TGT_FLG)" ).append("\n"); 
		query.append("      ,VVD.MON_TGT_FLG    = DECODE(@[rslt_cd], 'B', 'Y', 'C', 'Y', VVD.MON_TGT_FLG) " ).append("\n"); 
		query.append("      ,VVD.DELT_FLG       = DECODE(@[rslt_cd], 'B', 'N', 'C', DECODE(@[ibflag], 'U', 'N', 'Y'), VVD.DELT_FLG) 	" ).append("\n"); 
		query.append("      ,VVD.IOC_RULE_DESC  = DECODE(@[rslt_cd], 'C', DECODE(@[ibflag], 'U', @[rslt]||'-MC', @[rslt]))" ).append("\n"); 
		query.append("      ,VVD.UPD_USR_ID 	  = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,VVD.UPD_DT 	      = SYSDATE" ).append("\n"); 
		query.append("      ,VVD.WKY_MNL_FLG 	  = DECODE(@[ibflag], 'U', 'M', WKY_MNL_FLG) " ).append("\n"); 
		query.append(" WHERE VVD.TRD_CD 	      = @[trd_cd]" ).append("\n"); 
		query.append("   AND VVD.RLANE_CD 	  = @[rlane_cd]" ).append("\n"); 
		query.append("   AND VVD.IOC_CD 	      = @[ioc_cd]" ).append("\n"); 
		query.append("   AND VVD.VSL_CD 	      = @[vsl_cd]" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO     = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND VVD.DIR_CD 	      = @[dir_cd]" ).append("\n"); 

	}
}