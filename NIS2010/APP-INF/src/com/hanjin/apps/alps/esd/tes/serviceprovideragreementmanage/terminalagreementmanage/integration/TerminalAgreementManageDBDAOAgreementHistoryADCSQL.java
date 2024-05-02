/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOAgreementHistoryADCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.12.22 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOAgreementHistoryADCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Apply Day Insert
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOAgreementHistoryADCSQL(){
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ver_no_new",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOAgreementHistoryADCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_TML_AGMT_APLY_DY  (" ).append("\n"); 
		query.append("TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(", TML_AGMT_SEQ" ).append("\n"); 
		query.append(", TML_AGMT_VER_NO" ).append("\n"); 
		query.append(", TML_AGMT_DTL_SEQ" ).append("\n"); 
		query.append(", TML_RT_DY_APLY_TP_CD" ).append("\n"); 
		query.append(", WKDY_FLG" ).append("\n"); 
		query.append(", SAT_FLG" ).append("\n"); 
		query.append(", SUN_FLG" ).append("\n"); 
		query.append(", HOL_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", LOCL_CRE_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  @[tml_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append(", @[tml_agmt_seq]" ).append("\n"); 
		query.append(", @[tml_agmt_ver_no_new]" ).append("\n"); 
		query.append(", tml_agmt_dtl_seq" ).append("\n"); 
		query.append(", tml_rt_dy_aply_tp_cd" ).append("\n"); 
		query.append(", wkdy_flg" ).append("\n"); 
		query.append(", sat_flg" ).append("\n"); 
		query.append(", sun_flg" ).append("\n"); 
		query.append(", hol_flg" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])" ).append("\n"); 
		query.append("FROM	TES_TML_AGMT_APLY_DY" ).append("\n"); 
		query.append("WHERE	tml_agmt_ofc_cty_cd	= @[tml_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND		tml_agmt_seq		= @[tml_agmt_seq]" ).append("\n"); 
		query.append("AND 	tml_agmt_ver_no		= @[tml_agmt_ver_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}