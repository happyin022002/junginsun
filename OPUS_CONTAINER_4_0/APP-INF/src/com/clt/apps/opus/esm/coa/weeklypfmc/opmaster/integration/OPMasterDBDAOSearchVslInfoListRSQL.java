/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : OPMasterDBDAOSearchVslInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2011.03.14 전윤주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun-ju Jeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOSearchVslInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Info
	  * </pre>
	  */
	public OPMasterDBDAOSearchVslInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOSearchVslInfoListRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("      ,VSL_ENG_NM" ).append("\n"); 
		query.append("      ,CRR_CD" ).append("\n"); 
		query.append("      ,CNTR_DZN_CAPA" ).append("\n"); 
		query.append("      ,CNTR_VSL_CLSS_CAPA		" ).append("\n"); 
		query.append("  FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append(" WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '') " ).append("\n"); 
		query.append("   AND VSL_CD = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_crr_cd} != '') " ).append("\n"); 
		query.append("   AND CRR_CD = @[f_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}