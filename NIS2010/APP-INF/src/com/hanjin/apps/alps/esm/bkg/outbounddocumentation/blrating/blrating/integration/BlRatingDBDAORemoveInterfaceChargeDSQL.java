/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BlRatingDBDAORemoveInterfaceChargeDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.06 
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

public class BlRatingDBDAORemoveInterfaceChargeDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exempt Request 승인받은 Interface된 Charge를 삭제
	  * </pre>
	  */
	public BlRatingDBDAORemoveInterfaceChargeDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration ").append("\n"); 
		query.append("FileName : BlRatingDBDAORemoveInterfaceChargeDSQL").append("\n"); 
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
		query.append("DELETE FROM BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE (BKG_NO, RT_SEQ) IN (SELECT BKG_NO, RT_SEQ" ).append("\n"); 
		query.append("                           FROM BKG_CHG_RT R" ).append("\n"); 
		query.append("                           WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                           AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("                           AND AUTO_RAT_CD = 'I'" ).append("\n"); 
		query.append("                           AND CRE_DT = (SELECT MAX(CRE_DT)" ).append("\n"); 
		query.append("                                         FROM BKG_CHG_RT T" ).append("\n"); 
		query.append("                                         WHERE T.BKG_NO = R.BKG_NO" ).append("\n"); 
		query.append("                                         AND T.CHG_CD = R.CHG_CD)" ).append("\n"); 
		query.append("                           AND ROWNUM = 1)" ).append("\n"); 

	}
}