/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SriLankaCustomsTransmissionDBDAOaddSriLankaResponseCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaCustomsTransmissionDBDAOaddSriLankaResponseCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receive Add
	  * </pre>
	  */
	public SriLankaCustomsTransmissionDBDAOaddSriLankaResponseCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_sts_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtime",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rspn_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaCustomsTransmissionDBDAOaddSriLankaResponseCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_SRI_RCV_LOG" ).append("\n"); 
		query.append("(VSL_CD," ).append("\n"); 
		query.append("SKD_VOY_NO," ).append("\n"); 
		query.append("SKD_DIR_CD," ).append("\n"); 
		query.append("SR_STS_CD," ).append("\n"); 
		query.append("VSL_NM," ).append("\n"); 
		query.append("VSL_AUTH_NO," ).append("\n"); 
		query.append("VSL_RGST_NO," ).append("\n"); 
		query.append("DEP_DT," ).append("\n"); 
		query.append("RGST_DT," ).append("\n"); 
		query.append("RJCT_DT," ).append("\n"); 
		query.append("DECL_BL_QTY," ).append("\n"); 
		query.append("SR_STS_DESC," ).append("\n"); 
		query.append("SR_CMT_DESC," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("LK_CSTMS_RSPN_DIV_CD)" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("(SELECT VSL_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_SRI_VVD" ).append("\n"); 
		query.append("WHERE VSL_NM = NVL(@[vsl_nm],''))," ).append("\n"); 
		query.append("@[skd_voy_no],@[skd_dir_cd] ,@[sr_sts_cd], NVL(@[vsl_nm],''),@[vsl_auth_no],@[vsl_rgst_no]," ).append("\n"); 
		query.append("TO_DATE(REPLACE((" ).append("\n"); 
		query.append("CASE WHEN LENGTH(@[dep_dt]) < 9 THEN  '0' || SUBSTR(@[dep_dt],0,2) || '0'||SUBSTR(@[dep_dt],3,2)||SUBSTR(@[dep_dt],5,4)" ).append("\n"); 
		query.append("WHEN LENGTH(@[dep_dt]) < 10 THEN '0'||@[dep_dt]" ).append("\n"); 
		query.append("WHEN LENGTH(@[dep_dt]) > 9 THEN @[dep_dt]  END),'/',''),'MMDDYYYY')," ).append("\n"); 
		query.append("#if (${sr_sts_cd}== '1')" ).append("\n"); 
		query.append("TO_DATE(REPLACE(TRIM(@[rdate]),'/','')|| REPLACE(REPLACE(REPLACE(TRIM(@[rtime]),':',''),'AM','오전'),'PM','오후'),'DDMMYYYY'||'HHMISS AM')," ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sr_sts_cd}== '2')" ).append("\n"); 
		query.append("''," ).append("\n"); 
		query.append("TO_DATE(REPLACE(TRIM(@[rdate]),'/','')|| REPLACE(REPLACE(REPLACE(TRIM(@[rtime]),':',''),'AM','오전'),'PM','오후'),'DDMMYYYY'||'HHMISS AM')," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("0," ).append("\n"); 
		query.append("@[sr_sts_desc],''," ).append("\n"); 
		query.append("@[user_id],SYSDATE, @[user_id],SYSDATE,@[rspn_div_cd])" ).append("\n"); 

	}
}