/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchTransHistByVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.30
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.03.30 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchTransHistByVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD를 이용하여 Transmit History 조회
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchTransHistByVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_ks_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_msg_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n"); 
		query.append("FileName : KoreaCustomsReportDBDAOsearchTransHistByVVDRSQL").append("\n"); 
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
		query.append("SELECT MSG_LOG_TP_ID A_MSG_LOG_TP_ID" ).append("\n"); 
		query.append(", MF_RCVR_USR_ID A_MF_RCVR_USR_ID" ).append("\n"); 
		query.append(", ' ' A_RECEIVER" ).append("\n"); 
		query.append(", CORR_CD1 A_CORR_CD1" ).append("\n"); 
		query.append(", TO_CHAR(SND_DT, 'YYYYMMDD') A_SND_DT_DD" ).append("\n"); 
		query.append(", TO_CHAR(SND_DT, 'HH24:MI:SS') A_SND_DT_TT" ).append("\n"); 
		query.append(", VSL_CD||SKD_VOY_NO||SKD_DIR_CD A_VVD_CD" ).append("\n"); 
		query.append(", POL_CD A_POL_CD" ).append("\n"); 
		query.append(", POD_CD A_POD_CD" ).append("\n"); 
		query.append(", OFC_CD A_OFC_CD" ).append("\n"); 
		query.append(", BL_NO A_BL_NO" ).append("\n"); 
		query.append(", SMT_AMD_NO A_SUBMIT_NO" ).append("\n"); 
		query.append(", BL_KNT A_BL_KNT" ).append("\n"); 
		query.append(", ' ' A_FLD_40_FT" ).append("\n"); 
		query.append(", ' ' A_FLD_20_FT" ).append("\n"); 
		query.append(", TRSM_USR_ID A_TRSM_USR_ID" ).append("\n"); 
		query.append(", DECODE(KR_CSTMS_DECL_CD,'N',' ',KR_CSTMS_DECL_CD) A_KS_TYPE" ).append("\n"); 
		query.append(", ' ' A_C_TP" ).append("\n"); 
		query.append(", ' ' A_E_SVC_SEND_DATE" ).append("\n"); 
		query.append(", MF_SND_SEQ MF_SND_SEQ" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_SND_LOG" ).append("\n"); 
		query.append("WHERE VSL_CD = SUBSTR(@[in_vsl_cd], 1, 4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[in_vsl_cd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[in_vsl_cd], 9, 1)" ).append("\n"); 
		query.append("#if(${in_msg_type}!= '5CG')" ).append("\n"); 
		query.append("AND MSG_LOG_TP_ID = NVL(@[in_msg_type],MSG_LOG_TP_ID)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND MSG_LOG_TP_ID IN ( NVL(@[in_msg_type],MSG_LOG_TP_ID) , NVL('SCA',MSG_LOG_TP_ID))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${in_ks_type} != 'D')" ).append("\n"); 
		query.append("AND NVL(KR_CSTMS_DECL_CD,' ') LIKE @[in_ks_type]||'%'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND KR_CSTMS_DECL_CD <> 'E'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${in_pol_cd} != '')" ).append("\n"); 
		query.append("AND POL_CD LIKE @[in_pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${in_pod_cd} != '')" ).append("\n"); 
		query.append("AND POD_CD LIKE @[in_pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${in_ofc_cd} != '')" ).append("\n"); 
		query.append("AND OFC_CD LIKE @[in_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${in_usr_id} != '')" ).append("\n"); 
		query.append("AND TRSM_USR_ID LIKE @[in_usr_id]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}