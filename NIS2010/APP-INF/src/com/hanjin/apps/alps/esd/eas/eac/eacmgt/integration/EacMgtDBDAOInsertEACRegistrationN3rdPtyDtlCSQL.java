/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOInsertEACRegistrationN3rdPtyDtlCSQL.java
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

public class EacMgtDBDAOInsertEACRegistrationN3rdPtyDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eas_expn_aud_n3rd_pty_dtl 에저장
	  * </pre>
	  */
	public EacMgtDBDAOInsertEACRegistrationN3rdPtyDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eac_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("audr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOInsertEACRegistrationN3rdPtyDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO EAS_EXPN_AUD_N3RD_PTY_DTL(" ).append("\n"); 
		query.append("                                       EAC_NO" ).append("\n"); 
		query.append("                                     , EAC_DTL_SEQ" ).append("\n"); 
		query.append("                                     , EQ_KND_CD" ).append("\n"); 
		query.append("                                     , EQ_NO" ).append("\n"); 
		query.append("                                     , EQ_TPSZ_CD" ).append("\n"); 
		query.append("                                     , DIFF_INV_AMT" ).append("\n"); 
		query.append("                                     , CRE_USR_ID" ).append("\n"); 
		query.append("                                     , CRE_DT" ).append("\n"); 
		query.append("                                     , UPD_USR_ID" ).append("\n"); 
		query.append("                                     , UPD_DT" ).append("\n"); 
		query.append("                                     )values(" ).append("\n"); 
		query.append("                                       @[eac_no]" ).append("\n"); 
		query.append("                                     , (select count(1) +1 from eas_expn_aud_n3rd_pty_dtl where eac_no = @[eac_no])" ).append("\n"); 
		query.append("                                     , @[eq_knd_cd]" ).append("\n"); 
		query.append("                                     , @[eq_no]" ).append("\n"); 
		query.append("                                     , @[eq_tpsz_cd]" ).append("\n"); 
		query.append("                                     , @[diff_inv_amt]" ).append("\n"); 
		query.append("                                     , @[audr_usr_id]" ).append("\n"); 
		query.append("                                     , SYSDATE" ).append("\n"); 
		query.append("                                     , @[audr_usr_id]" ).append("\n"); 
		query.append("                                     , SYSDATE                                    " ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}