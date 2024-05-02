/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOaddCUSDMRSndLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.31
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOaddCUSDMRSndLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CUSDMR 전송기록을 남긴다.
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOaddCUSDMRSndLogCSQL(){
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
		params.put("corr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOaddCUSDMRSndLogCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_KR_SND_LOG (" ).append("\n"); 
		query.append("            MSG_LOG_TP_ID," ).append("\n"); 
		query.append("            SND_DT," ).append("\n"); 
		query.append("            OFC_CD," ).append("\n"); 
		query.append("            FLT_FILE_REF_NO, " ).append("\n"); 
		query.append("            TRSM_USR_ID," ).append("\n"); 
		query.append("            VSL_CD," ).append("\n"); 
		query.append("            SKD_VOY_NO," ).append("\n"); 
		query.append("            SKD_DIR_CD," ).append("\n"); 
		query.append("            POL_CD," ).append("\n"); 
		query.append("            BL_NO,    " ).append("\n"); 
		query.append("            SMT_AMD_NO, " ).append("\n"); 
		query.append("            CORR_CD1," ).append("\n"); 
		query.append("            MF_RCVR_USR_ID," ).append("\n"); 
		query.append("            MF_SND_SEQ," ).append("\n"); 
		query.append(" 			CRE_USR_ID," ).append("\n"); 
		query.append("			CRE_DT," ).append("\n"); 
		query.append("			UPD_USR_ID," ).append("\n"); 
		query.append("			UPD_DT )" ).append("\n"); 
		query.append("    SELECT  '5LK'," ).append("\n"); 
		query.append("            TO_DATE(@[snd_dt], 'YYYYMMDD HH24:MI:SS')," ).append("\n"); 
		query.append("            @[ofc_cd]," ).append("\n"); 
		query.append("            @[flt_file_ref_no]," ).append("\n"); 
		query.append("            @[user_id]," ).append("\n"); 
		query.append("            SUBSTR(@[vvd], 1, 4)," ).append("\n"); 
		query.append("            SUBSTR(@[vvd], 5, 4)," ).append("\n"); 
		query.append("            SUBSTR(@[vvd], 9, 1)," ).append("\n"); 
		query.append("            @[pol_cd]," ).append("\n"); 
		query.append("            @[bl_no]," ).append("\n"); 
		query.append("			@[sub_no]," ).append("\n"); 
		query.append("            @[corr_cd]," ).append("\n"); 
		query.append("            RPAD('KCS4G002', 20)," ).append("\n"); 
		query.append("            1," ).append("\n"); 
		query.append("			@[user_id]," ).append("\n"); 
		query.append("			SYSDATE," ).append("\n"); 
		query.append("			@[user_id]," ).append("\n"); 
		query.append("			SYSDATE" ).append("\n"); 
		query.append("    FROM    DUAL" ).append("\n"); 

	}
}