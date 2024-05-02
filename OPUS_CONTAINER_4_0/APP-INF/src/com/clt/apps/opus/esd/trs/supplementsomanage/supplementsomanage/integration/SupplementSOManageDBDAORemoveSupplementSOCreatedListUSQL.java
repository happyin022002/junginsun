/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SupplementSOManageDBDAORemoveSupplementSOCreatedListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SupplementSOManageDBDAORemoveSupplementSOCreatedListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 금액구분이 adjusted인 경우에 대해 생성된 SO 데이터를 삭제한다.
	  * </pre>
	  */
	public SupplementSOManageDBDAORemoveSupplementSOCreatedListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.supplementsomanage.supplementsomanage.integration").append("\n"); 
		query.append("FileName : SupplementSOManageDBDAORemoveSupplementSOCreatedListUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("SET   DELT_FLG 		= 'Y'" ).append("\n"); 
		query.append("    , UPD_USR_ID 	= @[upd_usr_id]" ).append("\n"); 
		query.append("    , UPD_DT 		= SYSDATE" ).append("\n"); 
		query.append("	, LOCL_UPD_DT 	= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(cre_ofc_cd)	" ).append("\n"); 
		query.append("	, LOCL_DELT_DT  = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(cre_ofc_cd)" ).append("\n"); 
		query.append("WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("	AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 

	}
}