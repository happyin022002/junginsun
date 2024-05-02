/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InterfaceScheduleToExternalDBDAOCreateVskVipsIfHdrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceScheduleToExternalDBDAOCreateVskVipsIfHdrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VIPS I/F HEADER 생성
	  * </pre>
	  */
	public InterfaceScheduleToExternalDBDAOCreateVskVipsIfHdrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insf_dv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vips_if_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vips_run_ut_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("insf_cnqe_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vips_if_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vips_if_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToExternalDBDAOCreateVskVipsIfHdrCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_VSL_SKD_VIPS_IF_HDR" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	 VSL_CD" ).append("\n"); 
		query.append("	,SKD_VOY_NO" ).append("\n"); 
		query.append("	,VIPS_IF_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 --::COLS FOR EAI I/F::--" ).append("\n"); 
		query.append("	,INSF_ID" ).append("\n"); 
		query.append("	,INSF_PRS_ID" ).append("\n"); 
		query.append("	----,INSF_DTTMIN" ).append("\n"); 
		query.append("	,INSF_CNQE_VAL" ).append("\n"); 
		query.append("	,INSF_DV_CD" ).append("\n"); 
		query.append("	,VIPS_RUN_UT_NO" ).append("\n"); 
		query.append("	 --::COLS FOR EAI I/F::--" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,VIPS_IF_TGT_FLG" ).append("\n"); 
		query.append("	,VIPS_IF_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     ( @[vsl_cd]" ).append("\n"); 
		query.append("     , @[skd_voy_no]" ).append("\n"); 
		query.append("     , @[vips_if_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 --::COLS FOR EAI I/F::--" ).append("\n"); 
		query.append("	 , 'OPVIPS01'" ).append("\n"); 
		query.append("     , ''" ).append("\n"); 
		query.append("     ----, SYSDATE --[insf_dttm]" ).append("\n"); 
		query.append("     , @[insf_cnqe_val]			--: 'S':SUCCESS, 'E':ERROR :--" ).append("\n"); 
		query.append("	 , @[insf_dv_cd]			--: 'I':INSERT , 'U':UPDATE, 'D':DELETE :--" ).append("\n"); 
		query.append("	 , @[vips_run_ut_no]		--: Run Unit Number :--" ).append("\n"); 
		query.append("	 --::COLS FOR EAI I/F::--" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , @[vips_if_tgt_flg]		--: VIPS I/F TARGET INDICATOR :--" ).append("\n"); 
		query.append("	 , @[vips_if_rmk]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , 'VIPS_IF'" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , 'VIPS_IF'" ).append("\n"); 
		query.append("     , SYSDATE	" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}