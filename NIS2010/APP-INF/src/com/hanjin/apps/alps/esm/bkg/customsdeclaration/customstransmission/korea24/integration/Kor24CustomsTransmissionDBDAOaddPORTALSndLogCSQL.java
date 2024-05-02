/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAOaddPORTALSndLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.31
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24CustomsTransmissionDBDAOaddPORTALSndLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PORTAL Send Log를 add한다.
	  * </pre>
	  */
	public Kor24CustomsTransmissionDBDAOaddPORTALSndLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_cxl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_cxl_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_snd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_cxl_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration").append("\n"); 
		query.append("FileName : Kor24CustomsTransmissionDBDAOaddPORTALSndLogCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("  INTO BKG_CSTMS_KR_SND_LOG" ).append("\n"); 
		query.append("     ( MSG_LOG_TP_ID" ).append("\n"); 
		query.append("     , SND_DT" ).append("\n"); 
		query.append("     , OFC_CD" ).append("\n"); 
		query.append("     , FLT_FILE_REF_NO" ).append("\n"); 
		query.append("     , TRSM_USR_ID" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("	 , POD_CD" ).append("\n"); 
		query.append("     , BL_NO" ).append("\n"); 
		query.append("     , CORR_CD1" ).append("\n"); 
		query.append("     , MF_RCVR_USR_ID" ).append("\n"); 
		query.append("     , MF_SND_SEQ" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , SMT_AMD_NO" ).append("\n"); 
		query.append("	 , TRSM_CXL_TP_CD" ).append("\n"); 
		query.append("	 , TRSM_CXL_RSN_CD" ).append("\n"); 
		query.append("	 , TRSM_CXL_DESC" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("SELECT '5VD'" ).append("\n"); 
		query.append("     , TO_DATE(@[snd_dt], 'YYYYMMDD HH24:MI:SS')" ).append("\n"); 
		query.append("     , @[ofc_cd]" ).append("\n"); 
		query.append("     , @[flt_file_ref_no]" ).append("\n"); 
		query.append("     , @[user_id]" ).append("\n"); 
		query.append("     , SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("     , SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("     , SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("     , @[pol_cd]" ).append("\n"); 
		query.append("	 , @[pod_cd]" ).append("\n"); 
		query.append("     , NULL" ).append("\n"); 
		query.append("     , NULL" ).append("\n"); 
		query.append("     , 'KTNETULHS4G'" ).append("\n"); 
		query.append("     , @[mf_snd_seq]" ).append("\n"); 
		query.append("     , @[user_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[user_id]" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , @[sub_no]" ).append("\n"); 
		query.append("	 , @[trsm_cxl_tp_cd]" ).append("\n"); 
		query.append("	 , @[trsm_cxl_rsn_cd]" ).append("\n"); 
		query.append("	 , @[trsm_cxl_desc]" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}