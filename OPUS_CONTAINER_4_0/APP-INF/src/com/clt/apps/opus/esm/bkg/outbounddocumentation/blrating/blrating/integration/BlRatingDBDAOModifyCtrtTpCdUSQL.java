/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlRatingDBDAOModifyCtrtTpCdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.01
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.06.01 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOModifyCtrtTpCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BlRatingDBDAOModifyCtrtTpCdUSQL
	  * </pre>
	  */
	public BlRatingDBDAOModifyCtrtTpCdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOModifyCtrtTpCdUSQL").append("\n"); 
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
		query.append("#if(${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	UPDATE BKG_RT_HIS" ).append("\n"); 
		query.append("	SET BKG_CTRT_TP_CD = @[ctrt_tp_cd], UPD_USR_ID = @[user_id], UPD_DT = SYSDATE " ).append("\n"); 
		query.append("	WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	UPDATE BKG_RATE" ).append("\n"); 
		query.append("	SET BKG_CTRT_TP_CD = @[ctrt_tp_cd], UPD_USR_ID = @[user_id], UPD_DT = SYSDATE " ).append("\n"); 
		query.append("	WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}