/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgChemicalHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgChemicalHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chemical history를 조회하기 위함.
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgChemicalHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chem_abst_svc_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chem_abst_svc_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chem_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chem_abst_svc_no3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgChemicalHistoryRSQL").append("\n"); 
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
		query.append("SELECT chem_seq" ).append("\n"); 
		query.append("      ,chem_nm" ).append("\n"); 
		query.append("      ,substr(chem_abst_svc_no,-length(chem_abst_svc_no),length(chem_abst_svc_no)-3) AS chem_abst_svc_no1" ).append("\n"); 
		query.append("      ,substr(chem_abst_svc_no,-3,2) AS chem_abst_svc_no2" ).append("\n"); 
		query.append("      ,substr(chem_abst_svc_no,-1,1) AS chem_abst_svc_no3" ).append("\n"); 
		query.append("      ,spcl_cgo_flg" ).append("\n"); 
		query.append("      ,co_nm" ).append("\n"); 
		query.append("      ,chem_opin_knd_cd" ).append("\n"); 
		query.append("      ,cmt_ctnt" ).append("\n"); 
		query.append("      ,imdg_spcl_provi_no" ).append("\n"); 
		query.append("      ,rqst_ofc_cd" ).append("\n"); 
		query.append("      ,rqst_id" ).append("\n"); 
		query.append("      ,TO_CHAR(rqst_dt,'YYYY-MM-DD') AS rqst_dt" ).append("\n"); 
		query.append("      ,re_msg_id" ).append("\n"); 
		query.append("      ,TO_CHAR(re_msg_dt,'YYYY-MM-DD') AS re_msg_dt" ).append("\n"); 
		query.append("      ,cre_usr_id" ).append("\n"); 
		query.append("      ,cre_dt" ).append("\n"); 
		query.append("      ,upd_usr_id" ).append("\n"); 
		query.append("      ,upd_dt" ).append("\n"); 
		query.append("      ,( SELECT COUNT(1)" ).append("\n"); 
		query.append("          FROM SCG_CHEM_HIS_FILE" ).append("\n"); 
		query.append("         WHERE chem_seq = a.chem_seq" ).append("\n"); 
		query.append("           AND ATCH_FILE_DIV_CD = 'M'  ) AS file1" ).append("\n"); 
		query.append("      ,( SELECT COUNT(1)" ).append("\n"); 
		query.append("          FROM SCG_CHEM_HIS_FILE" ).append("\n"); 
		query.append("         WHERE chem_seq = a.chem_seq" ).append("\n"); 
		query.append("           AND ATCH_FILE_DIV_CD = 'P'  ) AS file2" ).append("\n"); 
		query.append("       ,( SELECT COUNT(1)" ).append("\n"); 
		query.append("          FROM SCG_CHEM_HIS_FILE" ).append("\n"); 
		query.append("         WHERE chem_seq = a.chem_seq" ).append("\n"); 
		query.append("           AND ATCH_FILE_DIV_CD = 'R'  ) AS file3    " ).append("\n"); 
		query.append(" FROM SCG_CHEM_HIS A" ).append("\n"); 
		query.append("WHERE A.chem_nm LIKE @[chem_nm]||'%'" ).append("\n"); 
		query.append("   #if (${chem_abst_svc_no1} !='' || ${chem_abst_svc_no1} !='' || ${chem_abst_svc_no3} !='') " ).append("\n"); 
		query.append("      AND A.chem_abst_svc_no LIKE @[chem_abst_svc_no1]||@[chem_abst_svc_no2]||@[chem_abst_svc_no3]||'%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("  AND A.rqst_dt BETWEEN to_date(@[rqst_fr_dt],'yyyy-mm-dd') AND to_date(@[rqst_to_dt],'yyyy-mm-dd') + 0.9999" ).append("\n"); 
		query.append("  #if (${answer_yn} == 'Y') " ).append("\n"); 
		query.append("                        		AND A.chem_opin_knd_cd IS NOT NULL" ).append("\n"); 
		query.append("  #elseif (${answer_yn} == 'N') " ).append("\n"); 
		query.append("								AND A.chem_opin_knd_cd IS NULL" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("ORDER BY chem_seq" ).append("\n"); 

	}
}