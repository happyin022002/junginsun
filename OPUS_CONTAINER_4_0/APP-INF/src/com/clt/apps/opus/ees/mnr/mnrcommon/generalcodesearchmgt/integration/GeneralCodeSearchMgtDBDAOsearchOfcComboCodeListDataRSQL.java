/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchOfcComboCodeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchOfcComboCodeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOfcComboCodeListData
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchOfcComboCodeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("searchkey",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchOfcComboCodeListDataRSQL").append("\n"); 
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
		query.append("#if (${searchcon} != 'DISP')" ).append("\n"); 
		query.append("SELECT A.OFC_CD AS CD_ID,A.OFC_CD AS CD_DESC" ).append("\n"); 
		query.append("FROM MNR_OFC_GEN_INFO A" ).append("\n"); 
		query.append("WHERE A.UPPR_OFC_CD  = @[searchkey]" ).append("\n"); 
		query.append("	  AND A.MNR_GRP_TP_CD = 'OFC'" ).append("\n"); 
		query.append("      AND A.COST_CD       = 'RPROFC'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SELECT @[searchkey] AS CD_ID,@[searchkey] AS CD_DESC FROM DUAL" ).append("\n"); 

	}
}