/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomsCommonMgtDBDAOsearchCstmsPckTpConvListRSQL.java
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

public class CustomsCommonMgtDBDAOsearchCstmsPckTpConvListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCstmsPckTpConvList
	  * </pre>
	  */
	public CustomsCommonMgtDBDAOsearchCstmsPckTpConvListRSQL(){
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
		params.put("frm_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_cstms_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.integration").append("\n"); 
		query.append("FileName : CustomsCommonMgtDBDAOsearchCstmsPckTpConvListRSQL").append("\n"); 
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
		query.append("       PCK_TP_CD," ).append("\n"); 
		query.append("       CSTMS_PCK_TP_CD," ).append("\n"); 
		query.append("       PCK_CD_DESC" ).append("\n"); 
		query.append("FROM BKG_CSTMS_PCK_TP_CONV" ).append("\n"); 
		query.append("WHERE CNT_CD = @[frm_cnt_cd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${frm_pck_tp_cd} != '')" ).append("\n"); 
		query.append("    AND UPPER(PCK_TP_CD) LIKE  UPPER('%'||@[frm_pck_tp_cd]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${frm_cstms_pck_tp_cd} != '')" ).append("\n"); 
		query.append("    AND UPPER(CSTMS_PCK_TP_CD) LIKE  UPPER('%'||@[frm_cstms_pck_tp_cd]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY CNT_CD, PCK_TP_CD, CSTMS_PCK_TP_CD" ).append("\n"); 

	}
}