/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalMasterDataMgtDBDAOAddFinancialAffairsMtxCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RenewalMasterDataMgtDBDAOAddFinancialAffairsMtxCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Financial Affairs Matrix Insert
	  * </pre>
	  */
	public RenewalMasterDataMgtDBDAOAddFinancialAffairsMtxCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dr_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dr_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.integration ").append("\n"); 
		query.append("FileName : RenewalMasterDataMgtDBDAOAddFinancialAffairsMtxCSQL").append("\n"); 
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
		query.append("  INTO JOO_FINC_MTX ( " ).append("\n"); 
		query.append("               JO_CRR_CD" ).append("\n"); 
		query.append("             , RLANE_CD" ).append("\n"); 
		query.append("             , RE_DIVR_CD" ).append("\n"); 
		query.append("             , JO_STL_ITM_CD" ).append("\n"); 
		query.append("             , DR_CTR_CD" ).append("\n"); 
		query.append("             , DR_LOC_CD" ).append("\n"); 
		query.append("             , CR_CTR_CD" ).append("\n"); 
		query.append("             , CR_LOC_CD" ).append("\n"); 
		query.append("             , LOCL_CURR_CD" ).append("\n"); 
		query.append("             , CRE_DT" ).append("\n"); 
		query.append("             , CRE_USR_ID" ).append("\n"); 
		query.append("             , UPD_DT" ).append("\n"); 
		query.append("             , UPD_USR_ID " ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("               @[jo_crr_cd]" ).append("\n"); 
		query.append("             , @[rlane_cd]" ).append("\n"); 
		query.append("             , @[re_divr_cd]" ).append("\n"); 
		query.append("             , @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("             , @[dr_ctr_cd]" ).append("\n"); 
		query.append("             , @[dr_loc_cd]" ).append("\n"); 
		query.append("             , @[cr_ctr_cd]" ).append("\n"); 
		query.append("             , @[cr_loc_cd]" ).append("\n"); 
		query.append("             , @[locl_curr_cd]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("             , @[cre_usr_id]" ).append("\n"); 
		query.append("             , SYSDATE" ).append("\n"); 
		query.append("             , @[cre_usr_id] )" ).append("\n"); 

	}
}