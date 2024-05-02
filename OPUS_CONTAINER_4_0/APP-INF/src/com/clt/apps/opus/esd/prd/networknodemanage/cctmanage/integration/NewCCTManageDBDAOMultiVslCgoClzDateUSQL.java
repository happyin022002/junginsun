/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewCCTManageDBDAOMultiVslCgoClzDateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewCCTManageDBDAOMultiVslCgoClzDateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NewCCTManageDBDAOMultiVslCgoClzDate
	  * </pre>
	  */
	public NewCCTManageDBDAOMultiVslCgoClzDateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.integration").append("\n"); 
		query.append("FileName : NewCCTManageDBDAOMultiVslCgoClzDateUSQL").append("\n"); 
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
		query.append("UPDATE 		VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("SET 		CGO_CLZ_DT  		= TO_DATE(@[cgo_clz_dt]		, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("		,	DCGO_CLZ_DT 		= TO_DATE(@[dcgo_clz_dt]	, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("		,	RC_CLZ_DT   		= TO_DATE(@[rc_clz_dt]		, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("		,	AWK_CGO_CLZ_DT  	= TO_DATE(@[awk_cgo_clz_dt]	, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("		,	BB_CGO_CLZ_DT   	= TO_DATE(@[bb_cgo_clz_dt]	, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("		,	VGM_CLZ_DT   		= TO_DATE(@[vgm_clz_dt]		, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("WHERE 		VSL_CD 				= @[vsl_cd]" ).append("\n"); 
		query.append("AND 		SKD_VOY_NO 			= @[skd_voy_no]" ).append("\n"); 
		query.append("AND 		SKD_DIR_CD 			= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND 		VPS_PORT_CD 		= @[vps_port_cd]" ).append("\n"); 
		query.append("AND 		CLPT_IND_SEQ 		= @[clpt_ind_seq]" ).append("\n"); 

	}
}