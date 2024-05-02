/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchBDRTimeTableVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchBDRTimeTableVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDR의 기준이 되는 BDR Time을 등록하는 화면에서..
	  * Lane/Bound/From Location/To Location 기준으로 등록된 BDR Time을
	  * 조회한다.
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchBDRTimeTableVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_mnl_bdr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_mnl_bdr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchBDRTimeTableVOUSQL").append("\n"); 
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
		query.append("UPDATE BKG_VVD_BDR_LOG SET " ).append("\n"); 
		query.append("	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trnk_bdr_flg} == 'N') " ).append("\n"); 
		query.append("--,	TRNK_MNL_BDR_FLG = 'Y'" ).append("\n"); 
		query.append("	#if(${trnk_mnl_bdr_dt} != '')" ).append("\n"); 
		query.append("	,	TRNK_MNL_BDR_DT =  TO_DATE(@[trnk_mnl_bdr_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	, 	TRNK_MNL_BDR_DT =  null" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(",	TRNK_BDR_CRE_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fdr_bdr_flg} == 'N') " ).append("\n"); 
		query.append("--,	FDR_MNL_BDR_FLG = 'Y'" ).append("\n"); 
		query.append("	#if(${fdr_mnl_bdr_dt} != '')" ).append("\n"); 
		query.append("	,	FDR_MNL_BDR_DT = TO_DATE(@[fdr_mnl_bdr_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	,	FDR_MNL_BDR_DT = null" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(",	FDR_BDR_CRE_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("WHERE	VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("AND	POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("AND	POD_CLPT_IND_SEQ = @[pod_clpt_ind_seq]" ).append("\n"); 

	}
}