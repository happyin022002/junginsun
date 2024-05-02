/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UserSetupMgtDBDAOSearchChkPntItemTpRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.08.12 Do Soon Choi
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do Soon Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOSearchChkPntItemTpRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchChkPntItmTp
	  * </pre>
	  */
	public UserSetupMgtDBDAOSearchChkPntItemTpRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_pnt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_pnt_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOSearchChkPntItemTpRSQL").append("\n"); 
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
		query.append("SELECT CHK_PNT_TP_CD" ).append("\n"); 
		query.append("      ,CHK_PNT_ITM_SEQ" ).append("\n"); 
		query.append("      ,CHK_PNT_ITM_TP_SEQ" ).append("\n"); 
		query.append("      ,CHK_PNT_ITM_TP_NM" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("	  ,CRE_USR_ID" ).append("\n"); 
		query.append("	  ,CRE_DT" ).append("\n"); 
		query.append("	  ,UPD_USR_ID" ).append("\n"); 
		query.append("	  ,UPD_DT" ).append("\n"); 
		query.append("  FROM BKG_CHK_PNT_ITM_TP   " ).append("\n"); 
		query.append(" WHERE CHK_PNT_TP_CD = @[chk_pnt_tp_cd]" ).append("\n"); 
		query.append("   AND CHK_PNT_ITM_SEQ =  @[chk_pnt_itm_seq]" ).append("\n"); 
		query.append("   AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 

	}
}