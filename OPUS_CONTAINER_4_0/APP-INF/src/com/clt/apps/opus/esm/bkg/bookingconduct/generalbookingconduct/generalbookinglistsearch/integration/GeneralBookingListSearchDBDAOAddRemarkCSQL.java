/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOAddRemarkCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOAddRemarkCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Remark
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOAddRemarkCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("login_user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("btnTp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inter_rmk_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOAddRemarkCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_INTER_RMK( " ).append("\n"); 
		query.append("            BKG_NO" ).append("\n"); 
		query.append("            ,INTER_RMK_SEQ" ).append("\n"); 
		query.append("            ,INTER_RMK_CTNT" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID " ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("            ,INTER_RMK_CD" ).append("\n"); 
		query.append("            ,CRE_OFC_CD" ).append("\n"); 
		query.append("            ,LOCL_CRE_DT" ).append("\n"); 
		query.append("            ,LOCL_UPD_DT" ).append("\n"); 
		query.append("			,DELT_FLG)" ).append("\n"); 
		query.append("     VALUES (@[bkg_no] " ).append("\n"); 
		query.append("            ,NVL((SELECT MAX(INTER_RMK_SEQ) " ).append("\n"); 
		query.append("                    FROM TRS_INTER_RMK INTER" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                     AND INTER.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                     ), 0) + 1" ).append("\n"); 
		query.append("            ,@[inter_rmk_ctnt]" ).append("\n"); 
		query.append("            ,@[cre_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[cre_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[btnTp]" ).append("\n"); 
		query.append("            ,@[login_user_ofc_cd]" ).append("\n"); 
		query.append("            ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[login_user_ofc_cd])" ).append("\n"); 
		query.append("            ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[login_user_ofc_cd])" ).append("\n"); 
		query.append("			,'N')" ).append("\n"); 

	}
}