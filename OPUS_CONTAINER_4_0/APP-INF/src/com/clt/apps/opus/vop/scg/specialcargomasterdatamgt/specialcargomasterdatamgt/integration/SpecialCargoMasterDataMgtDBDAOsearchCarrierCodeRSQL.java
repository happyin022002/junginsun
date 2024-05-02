/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOsearchCarrierCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOsearchCarrierCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkCarrier 체크
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOsearchCarrierCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOsearchCarrierCodeRSQL").append("\n"); 
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
		query.append("#if (${crr_cd} == 'COM') " ).append("\n"); 
		query.append("SELECT CASE WHEN CRR_CD IS NULL THEN 'COM' ELSE CRR_CD END CRR_CD" ).append("\n"); 
		query.append("     , CASE WHEN CRR_NM IS NULL THEN ''    ELSE CRR_NM END CRR_NM" ).append("\n"); 
		query.append("  FROM (SELECT MAX(CRR_CD) CRR_CD" ).append("\n"); 
		query.append("             , MAX(CRR_NM) CRR_NM " ).append("\n"); 
		query.append("             , COUNT(CRR_CD) CRR_CNT" ).append("\n"); 
		query.append("          FROM MDM_CARRIER" ).append("\n"); 
		query.append("         WHERE CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT CRR_CD" ).append("\n"); 
		query.append("     , CRR_NM" ).append("\n"); 
		query.append("  FROM MDM_CARRIER" ).append("\n"); 
		query.append(" WHERE CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}