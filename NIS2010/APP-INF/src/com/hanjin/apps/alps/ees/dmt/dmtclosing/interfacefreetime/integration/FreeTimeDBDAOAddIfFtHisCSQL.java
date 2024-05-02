/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : FreeTimeDBDAOAddIfFtHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FreeTimeDBDAOAddIfFtHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FreeTimeDBDAOAddIfFtHisCSQL
	  * </pre>
	  */
	public FreeTimeDBDAOAddIfFtHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ft_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_cmnc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ft_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_area_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.integration").append("\n"); 
		query.append("FileName : FreeTimeDBDAOAddIfFtHisCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_IF_FT_HIS" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        BKG_NO" ).append("\n"); 
		query.append("       ,CNTR_NO" ).append("\n"); 
		query.append("       ,IF_FT_HIS_SEQ" ).append("\n"); 
		query.append("       ,DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("       ,FM_MVMT_STS_CD" ).append("\n"); 
		query.append("       ,FM_MVMT_DT" ).append("\n"); 
		query.append("       ,FM_MVMT_YD_CD" ).append("\n"); 
		query.append("       ,FT_CMNC_DT" ).append("\n"); 
		query.append("       ,FT_END_DT" ).append("\n"); 
		query.append("       ,FT_DYS" ).append("\n"); 
		query.append("       ,SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("       ,DMDT_TRF_CD" ).append("\n"); 
		query.append("       ,TRF_SEQ" ).append("\n"); 
		query.append("       ,DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("       ,TRF_GRP_SEQ" ).append("\n"); 
		query.append("       ,FT_RMK" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("        @[bkg_no]" ).append("\n"); 
		query.append("       ,@[cntr_no]" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("			SELECT  NVL(MAX(IF_FT_HIS_SEQ), 0) + 1" ).append("\n"); 
		query.append("			  FROM  DMT_IF_FT_HIS" ).append("\n"); 
		query.append("			 WHERE  BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("			   AND  CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("       ,@[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("       ,@[fm_mvmt_sts_cd]" ).append("\n"); 
		query.append("       ,TO_DATE(@[fm_mvmt_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,@[fm_mvmt_yd_cd]" ).append("\n"); 
		query.append("       ,TO_DATE(@[ft_cmnc_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,TO_DATE(@[ft_end_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("       ,@[ft_dys]" ).append("\n"); 
		query.append("       ,@[sys_area_grp_id]" ).append("\n"); 
		query.append("       ,@[dmdt_trf_cd]" ).append("\n"); 
		query.append("       ,@[trf_seq]" ).append("\n"); 
		query.append("       ,@[dmdt_de_term_cd]" ).append("\n"); 
		query.append("       ,@[trf_grp_seq]" ).append("\n"); 
		query.append("       ,@[ft_rmk]" ).append("\n"); 
		query.append("       ,'SCE_BATCH'" ).append("\n"); 
		query.append("       ,SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}