/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RASCommonDBDAOBkgRevUmchSubTpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RASCommonDBDAOBkgRevUmchSubTpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgRevUmchSubTp
	  * </pre>
	  */
	public RASCommonDBDAOBkgRevUmchSubTpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.integration").append("\n"); 
		query.append("FileName : RASCommonDBDAOBkgRevUmchSubTpRSQL").append("\n"); 
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
		query.append("SELECT UMCH_SUB_TP_CD AS CD" ).append("\n"); 
		query.append(",      UMCH_SUB_TP_DESC AS NM" ).append("\n"); 
		query.append("FROM BKG_REV_UMCH_SUB_TP" ).append("\n"); 
		query.append("WHERE UMCH_TP_CD = @[etc1]" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT SUB.UMCH_SUB_TP_CD AS CD" ).append("\n"); 
		query.append(",      SUB.UMCH_SUB_TP_DESC AS NM" ).append("\n"); 
		query.append("FROM BKG_REV_UMCH_SUB_TP SUB, BKG_REV_UMCH_TP MN" ).append("\n"); 
		query.append("WHERE SUB.UMCH_TP_CD = MN.UMCH_TP_CD" ).append("\n"); 
		query.append("AND MN.UMCH_TP_DESC = @[etc1]" ).append("\n"); 

	}
}