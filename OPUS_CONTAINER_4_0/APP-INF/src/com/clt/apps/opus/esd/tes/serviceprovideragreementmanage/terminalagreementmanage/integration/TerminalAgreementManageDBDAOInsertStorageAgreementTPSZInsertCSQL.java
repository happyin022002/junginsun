/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOInsertStorageAgreementTPSZInsertCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOInsertStorageAgreementTPSZInsertCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * in
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOInsertStorageAgreementTPSZInsertCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_aply_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_dys",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOInsertStorageAgreementTPSZInsertCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_TML_AGMT_TP_SZ (   " ).append("\n"); 
		query.append("		  tml_agmt_ofc_cty_cd                " ).append("\n"); 
		query.append("		, tml_agmt_seq                       " ).append("\n"); 
		query.append("		, tml_agmt_ver_no                    " ).append("\n"); 
		query.append("		, tml_agmt_dtl_seq                   " ).append("\n"); 
		query.append("		, cntr_tpsz_cd                       " ).append("\n"); 
		query.append("		, cntr_aply_tp_cd                    " ).append("\n"); 
		query.append("		, agmt_rt                            " ).append("\n"); 
		query.append("		, agmt_dys                           " ).append("\n"); 
		query.append("		, cre_usr_id                          " ).append("\n"); 
		query.append("		, cre_dt                              " ).append("\n"); 
		query.append("		, upd_usr_id                          " ).append("\n"); 
		query.append("		, upd_dt                              " ).append("\n"); 
		query.append("		, locl_cre_dt " ).append("\n"); 
		query.append("		, eq_tpsz_cd" ).append("\n"); 
		query.append("		, eq_knd_cd                             " ).append("\n"); 
		query.append(" ) VALUES (                        " ).append("\n"); 
		query.append("		  @[tml_agmt_ofc_cty_cd]                " ).append("\n"); 
		query.append("		, @[tml_agmt_seq]                       " ).append("\n"); 
		query.append("		, @[tml_agmt_ver_no]                    " ).append("\n"); 
		query.append("		, @[tml_agmt_dtl_seq]                   " ).append("\n"); 
		query.append("		, @[cntr_tpsz_cd]                       " ).append("\n"); 
		query.append("		, @[cntr_aply_tp_cd]                    " ).append("\n"); 
		query.append("		, @[agmt_rt]                            " ).append("\n"); 
		query.append("		, @[agmt_dys]                           " ).append("\n"); 
		query.append("		, @[cre_usr_id]                          " ).append("\n"); 
		query.append("		, SYSDATE" ).append("\n"); 
		query.append("		, @[cre_usr_id]                          " ).append("\n"); 
		query.append("		, SYSDATE" ).append("\n"); 
		query.append("		, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("		, @[eq_tpsz_cd]" ).append("\n"); 
		query.append("		, @[eq_knd_cd]" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}