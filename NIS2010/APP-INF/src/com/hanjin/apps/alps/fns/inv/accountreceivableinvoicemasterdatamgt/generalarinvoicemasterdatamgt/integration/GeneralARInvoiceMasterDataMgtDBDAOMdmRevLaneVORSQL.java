/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralARInvoiceMasterDataMgtDBDAOMdmRevLaneVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceMasterDataMgtDBDAOMdmRevLaneVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralARInvoiceMasterDataMgtDBDAOMdmRevLaneVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cng_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.integration").append("\n"); 
		query.append("FileName : GeneralARInvoiceMasterDataMgtDBDAOMdmRevLaneVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("SLAN_CD," ).append("\n"); 
		query.append("SCONTI_CD," ).append("\n"); 
		query.append("SLAN_DIR_CD," ).append("\n"); 
		query.append("RLANE_DIR_CD," ).append("\n"); 
		query.append("DIR_CNG_CD," ).append("\n"); 
		query.append("DELT_FLG," ).append("\n"); 
		query.append("RLANE_CD," ).append("\n"); 
		query.append("POD_CONTI_CD," ).append("\n"); 
		query.append("(POD_SLANE_DIR_CD ||POD_RLANE_DIR_CD ) AS POD_RLANE_DIR_CD," ).append("\n"); 
		query.append("POD_RLANE_CD " ).append("\n"); 
		query.append("--POD_SLANE_DIR_CD " ).append("\n"); 
		query.append("FROM AR_FINC_DIR_CONV" ).append("\n"); 
		query.append("#if ((${slan_cd} != '')||(${dir_cng_cd} != '')||(${delt_flg} != '')) " ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("	SLAN_CD LIKE '%' ||@[slan_cd]|| '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${slan_cd} != '')&&(${dir_cng_cd} != '')) " ).append("\n"); 
		query.append("AND	DIR_CNG_CD = @[dir_cng_cd]" ).append("\n"); 
		query.append("#elseif((${slan_cd} == '')&&(${dir_cng_cd} != '')) " ).append("\n"); 
		query.append("DIR_CNG_CD = @[dir_cng_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (((${slan_cd} != '')||(${dir_cng_cd} != ''))&&(${delt_flg} != '')) " ).append("\n"); 
		query.append("AND	DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("#elseif ((${slan_cd} == '')&&(${dir_cng_cd} == '')&&(${delt_flg} != '')) " ).append("\n"); 
		query.append("DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SLAN_CD,SCONTI_CD,SLAN_DIR_CD,RLANE_DIR_CD,DIR_CNG_CD,DELT_FLG" ).append("\n"); 

	}
}