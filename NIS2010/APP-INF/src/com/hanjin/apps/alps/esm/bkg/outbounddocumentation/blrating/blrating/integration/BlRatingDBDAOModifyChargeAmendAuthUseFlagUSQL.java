/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAOModifyChargeAmendAuthUseFlagUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOModifyChargeAmendAuthUseFlagUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge Amend 권한 사용여부를 업데이트 한다.
	  * </pre>
	  */
	public BlRatingDBDAOModifyChargeAmendAuthUseFlagUSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration ").append("\n"); 
		query.append("FileName : BlRatingDBDAOModifyChargeAmendAuthUseFlagUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CHG_AMD_AUTH U" ).append("\n"); 
		query.append("SET AUTH_USE_FLG = 'Y'," ).append("\n"); 
		query.append("    AUTH_USE_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])," ).append("\n"); 
		query.append("    UPD_USR_ID = @[usr_id]," ).append("\n"); 
		query.append("    UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE U.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND U.CHG_AMD_SEQ = (SELECT MAX(CHG_AMD_SEQ)" ).append("\n"); 
		query.append("                   FROM BKG_CHG_AMD_AUTH S" ).append("\n"); 
		query.append("                   WHERE S.BKG_NO = U.BKG_NO)" ).append("\n"); 
		query.append("AND U.CHG_AMD_RQST_STS_CD = 'A'" ).append("\n"); 
		query.append("AND AUTH_USE_FLG = 'N'" ).append("\n"); 

	}
}