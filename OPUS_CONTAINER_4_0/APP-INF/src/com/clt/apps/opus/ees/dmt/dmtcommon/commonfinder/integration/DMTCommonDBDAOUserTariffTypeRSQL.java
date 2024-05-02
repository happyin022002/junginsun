/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCommonDBDAOUserTariffTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.03.19 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAOUserTariffTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DMTCommonDBDAOUserTariffTypeRSQL
	  * </pre>
	  */
	public DMTCommonDBDAOUserTariffTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration").append("\n"); 
		query.append("FileName : DMTCommonDBDAOUserTariffTypeRSQL").append("\n"); 
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
		query.append("SELECT LTRIM(" ).append("\n"); 
		query.append("DECODE(DEM_IB_FLG, 'Y', 'DMIF', 'N', '')" ).append("\n"); 
		query.append("|| DECODE(DET_IB_FLG, 'Y', ',DTIC', 'N', '')" ).append("\n"); 
		query.append("|| DECODE(DEM_OB_FLG, 'Y', ',DMOF', 'N', '')" ).append("\n"); 
		query.append("|| DECODE(DET_OB_FLG, 'Y', ',DTOC', 'N', '')" ).append("\n"); 
		query.append("|| DECODE(CMB_IB_FLG, 'Y', ',CTIC', 'N', '')" ).append("\n"); 
		query.append("|| DECODE(CMB_OB_FLG, 'Y', ',CTOC', 'N', '')" ).append("\n"); 
		query.append("|| DECODE(ALL_TRF_TP_FLG, 'Y', 'All', 'N', '')" ).append("\n"); 
		query.append(", ',') AS USR_TRF_TP" ).append("\n"); 
		query.append("FROM DMT_OFC_USR_TRF_OPT" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND USR_ID = @[usr_id]" ).append("\n"); 

	}
}