/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomsCommonMgtDBDAOsearchCstmsCdConvDescListSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2015.06.25 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomsCommonMgtDBDAOsearchCstmsCdConvDescListSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCstmsCdConvDescList
	  * </pre>
	  */
	public CustomsCommonMgtDBDAOsearchCstmsCdConvDescListSeqRSQL(){
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
		params.put("frm_cstms_div_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_cstms_cd_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration").append("\n"); 
		query.append("FileName : CustomsCommonMgtDBDAOsearchCstmsCdConvDescListSeqRSQL").append("\n"); 
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
		query.append("SELECT CTNT.ATTR_CTNT1 AS CNT_CD" ).append("\n"); 
		query.append("      ,CTNT.ATTR_CTNT2 AS CSTMS_DIV_ID" ).append("\n"); 
		query.append("      ,DES.HRD_CDG_DESC AS CSTMS_CD_DESC" ).append("\n"); 
		query.append("      ,DES.ATTR_NM1 AS ATTR_NM1" ).append("\n"); 
		query.append("      ,DES.ATTR_NM2 AS ATTR_NM2" ).append("\n"); 
		query.append("	  ,DES.ATTR_NM3 AS ATTR_NM3" ).append("\n"); 
		query.append("	  ,DES.ATTR_NM4 AS ATTR_NM4" ).append("\n"); 
		query.append("	  ,DES.ATTR_NM5 AS ATTR_NM5" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT CTNT, BKG_HRD_CDG_DESC DES" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CTNT.HRD_CDG_ID=DES.HRD_CDG_ID" ).append("\n"); 
		query.append("AND CTNT.ATTR_CTNT1 = @[frm_cnt_cd]" ).append("\n"); 
		query.append("#if (${frm_cstms_div_id} != '')" ).append("\n"); 
		query.append("    AND UPPER(CTNT.ATTR_CTNT2) LIKE UPPER('%'||@[frm_cstms_div_id]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${frm_cstms_cd_desc} != '')" ).append("\n"); 
		query.append("    AND UPPER(CTNT.ATTR_CTNT3) LIKE UPPER('%'||@[frm_cstms_cd_desc]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CNT_CD, CSTMS_DIV_ID" ).append("\n"); 

	}
}