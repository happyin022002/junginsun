/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOInsertEacPsnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOInsertEacPsnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Personnel Config 를 저장한다.
	  * </pre>
	  */
	public EacMgtDBDAOInsertEacPsnCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_subj_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_cc_rcv_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_aud_scp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOInsertEacPsnCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_EXPN_AUD_CS_PSON_CFG (EAC_USR_ID" ).append("\n"); 
		query.append("                                    , EAC_USR_NM" ).append("\n"); 
		query.append("                                    , PHN_NO" ).append("\n"); 
		query.append("                                    , FAX_NO" ).append("\n"); 
		query.append("                                    , USR_EML" ).append("\n"); 
		query.append("                                    , NTC_CC_RCV_EML" ).append("\n"); 
		query.append("                                    , EXPN_AUD_SCP_DESC" ).append("\n"); 
		query.append("                                    , EML_SUBJ_CTNT" ).append("\n"); 
		query.append("                                    , EML_CTNT" ).append("\n"); 
		query.append("                                    , DELT_FLG" ).append("\n"); 
		query.append("                                    , CRE_USR_ID" ).append("\n"); 
		query.append("                                    , CRE_DT" ).append("\n"); 
		query.append("                                    , UPD_USR_ID" ).append("\n"); 
		query.append("                                    , UPD_DT)" ).append("\n"); 
		query.append("                                    VALUES(" ).append("\n"); 
		query.append("                                      @[eac_usr_id]" ).append("\n"); 
		query.append("                                    , @[eac_usr_nm]" ).append("\n"); 
		query.append("                                    , @[phn_no]" ).append("\n"); 
		query.append("                                    , @[fax_no]" ).append("\n"); 
		query.append("                                    , @[usr_eml]" ).append("\n"); 
		query.append("                                    , @[ntc_cc_rcv_eml]" ).append("\n"); 
		query.append("                                    , @[expn_aud_scp_desc]" ).append("\n"); 
		query.append("                                    , @[eml_subj_ctnt]" ).append("\n"); 
		query.append("                                    , @[eml_ctnt]" ).append("\n"); 
		query.append("                                    , 'N'" ).append("\n"); 
		query.append("                                    , @[cre_usr_id]" ).append("\n"); 
		query.append("                                    , SYSDATE" ).append("\n"); 
		query.append("                                    , @[upd_usr_id]" ).append("\n"); 
		query.append("                                    , SYSDATE" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}