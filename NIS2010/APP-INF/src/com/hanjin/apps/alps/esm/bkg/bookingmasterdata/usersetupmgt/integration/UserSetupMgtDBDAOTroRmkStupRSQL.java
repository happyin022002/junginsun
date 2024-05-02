/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : UserSetupMgtDBDAOTroRmkStupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.14
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.10.14 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOTroRmkStupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TroRmkStup
	  * </pre>
	  */
	public UserSetupMgtDBDAOTroRmkStupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_tro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOTroRmkStupRSQL").append("\n"); 
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
		query.append("      BKG_TRO_OFC_CD" ).append("\n"); 
		query.append(",     DIFF_RMK" ).append("\n"); 
		query.append(",     IO_BND_CD " ).append("\n"); 
		query.append("FROM   BKG_TRO_STUP" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${bkg_tro_ofc_cd} != '') " ).append("\n"); 
		query.append("AND    BKG_TRO_OFC_CD = @[bkg_tro_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}