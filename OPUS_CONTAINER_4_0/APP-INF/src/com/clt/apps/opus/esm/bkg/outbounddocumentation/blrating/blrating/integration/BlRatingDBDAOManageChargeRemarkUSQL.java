/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOManageChargeRemarkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOManageChargeRemarkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManageChargeRemark
	  * </pre>
	  */
	public BlRatingDBDAOManageChargeRemarkUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOManageChargeRemarkUSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	#if (${sql_type} == 'count') " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		SELECT COUNT(BKG_NO) FROM BKG_RT_HIS  WHERE BKG_NO= @[bkg_no] AND CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#elseif (${sql_type} == 'insert') " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		INSERT INTO BKG_RT_HIS(BKG_NO, CORR_NO, DIFF_RMK, RT_INTER_RMK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT,BKG_RT_WHF_EXPT_CD)" ).append("\n"); 
		query.append("		VALUES(@[bkg_no], 'TMP0000001', @[diff_rmk], @[inter_rmk], @[user_id], sysdate, @[user_id], sysdate, null)" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#elseif (${sql_type} == 'update') " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		UPDATE BKG_RT_HIS" ).append("\n"); 
		query.append("		SET DIFF_RMK = @[diff_rmk], RT_INTER_RMK = @[inter_rmk]" ).append("\n"); 
		query.append("		WHERE " ).append("\n"); 
		query.append("		BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		AND CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${sql_type} == 'count') " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		SELECT COUNT(BKG_NO) FROM BKG_RATE  WHERE BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#elseif (${sql_type} == 'insert') " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		INSERT INTO BKG_RATE(BKG_NO, DIFF_RMK, RT_INTER_RMK, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT,BKG_RT_WHF_EXPT_CD)" ).append("\n"); 
		query.append("		VALUES(@[bkg_no], @[diff_rmk], @[inter_rmk], @[user_id], sysdate, @[user_id], sysdate, null)" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#elseif (${sql_type} == 'update') " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		UPDATE BKG_RATE" ).append("\n"); 
		query.append("		SET DIFF_RMK = @[diff_rmk], RT_INTER_RMK = @[inter_rmk]" ).append("\n"); 
		query.append("		WHERE " ).append("\n"); 
		query.append("		BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end	" ).append("\n"); 

	}
}