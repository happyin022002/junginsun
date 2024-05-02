/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RenewalMasterDataMgtDBDAORemoveFinancialAffairsMtxDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RenewalMasterDataMgtDBDAORemoveFinancialAffairsMtxDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Financial Affairs Matrix Delete
	  * </pre>
	  */
	public RenewalMasterDataMgtDBDAORemoveFinancialAffairsMtxDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.renewalmasterdatamgt.integration").append("\n"); 
		query.append("FileName : RenewalMasterDataMgtDBDAORemoveFinancialAffairsMtxDSQL").append("\n"); 
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
		query.append("DELETE" ).append("\n"); 
		query.append("  FROM JOO_FINC_MTX" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND JO_CRR_CD        = @[jo_crr_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD         = @[rlane_cd]" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '') " ).append("\n"); 
		query.append("   AND RE_DIVR_CD       = @[re_divr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_stl_itm_cd} != '') " ).append("\n"); 
		query.append("   AND JO_STL_ITM_CD    = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}