/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsCommonMgtDBDAOsearchCstmsCdConvDescListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomsCommonMgtDBDAOsearchCstmsCdConvDescListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCstmsCdConvDescList
	  * </pre>
	  */
	public CustomsCommonMgtDBDAOsearchCstmsCdConvDescListRSQL(){
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
		params.put("frm_cstms_cd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_cstms_div_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.integration").append("\n"); 
		query.append("FileName : CustomsCommonMgtDBDAOsearchCstmsCdConvDescListRSQL").append("\n"); 
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
		query.append("       CSTMS_DIV_ID," ).append("\n"); 
		query.append("       CSTMS_CD_DESC," ).append("\n"); 
		query.append("       ATTR_NM1," ).append("\n"); 
		query.append("       ATTR_NM2," ).append("\n"); 
		query.append("       ATTR_NM3," ).append("\n"); 
		query.append("       ATTR_NM4," ).append("\n"); 
		query.append("       ATTR_NM5" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CD_CONV_DESC" ).append("\n"); 
		query.append("WHERE CNT_CD = @[frm_cnt_cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${frm_cstms_div_id} != '')" ).append("\n"); 
		query.append("    AND UPPER(CSTMS_DIV_ID) LIKE UPPER('%'||@[frm_cstms_div_id]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${frm_cstms_cd_desc} != '')" ).append("\n"); 
		query.append("    AND UPPER(CSTMS_CD_DESC) LIKE UPPER('%'||@[frm_cstms_cd_desc]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CNT_CD, CSTMS_DIV_ID" ).append("\n"); 

	}
}