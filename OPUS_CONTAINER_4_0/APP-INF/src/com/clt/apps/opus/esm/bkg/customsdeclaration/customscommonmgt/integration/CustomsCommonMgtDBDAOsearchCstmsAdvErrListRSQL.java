/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomsCommonMgtDBDAOsearchCstmsAdvErrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomsCommonMgtDBDAOsearchCstmsAdvErrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCstmsAdvErrList
	  * </pre>
	  */
	public CustomsCommonMgtDBDAOsearchCstmsAdvErrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_cstms_err_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_err_cd_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration").append("\n"); 
		query.append("FileName : CustomsCommonMgtDBDAOsearchCstmsAdvErrListRSQL").append("\n"); 
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
		query.append("SELECT CNT_CD," ).append("\n"); 
		query.append("       CSTMS_ERR_CD," ).append("\n"); 
		query.append("       ERR_CD_DESC," ).append("\n"); 
		query.append("       ERR_TP_CTNT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_ERR" ).append("\n"); 
		query.append("WHERE CNT_CD = @[frm_cnt_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${frm_cstms_err_cd} != '')" ).append("\n"); 
		query.append("    AND UPPER(CSTMS_ERR_CD) LIKE UPPER('%'||@[frm_cstms_err_cd]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${frm_err_cd_desc} != '')" ).append("\n"); 
		query.append("    AND UPPER(ERR_CD_DESC) LIKE UPPER('%'||@[frm_err_cd_desc]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CNT_CD, CSTMS_ERR_CD" ).append("\n"); 

	}
}