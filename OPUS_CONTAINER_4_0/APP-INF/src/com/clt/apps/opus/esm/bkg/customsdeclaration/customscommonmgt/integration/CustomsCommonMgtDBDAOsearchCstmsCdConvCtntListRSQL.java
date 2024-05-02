/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomsCommonMgtDBDAOsearchCstmsCdConvCtntListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.02.02 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomsCommonMgtDBDAOsearchCstmsCdConvCtntListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCstmsCdConvCtntList
	  * </pre>
	  */
	public CustomsCommonMgtDBDAOsearchCstmsCdConvCtntListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_cstms_div_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("attr_ctnt2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.integration").append("\n"); 
		query.append("FileName : CustomsCommonMgtDBDAOsearchCstmsCdConvCtntListRSQL").append("\n"); 
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
		query.append("       CSTMS_DIV_ID_SEQ," ).append("\n"); 
		query.append("       ATTR_CTNT1," ).append("\n"); 
		query.append("       ATTR_CTNT2," ).append("\n"); 
		query.append("       ATTR_CTNT3," ).append("\n"); 
		query.append("       ATTR_CTNT4," ).append("\n"); 
		query.append("       ATTR_CTNT5" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE CNT_CD = @[chk_cnt_cd]" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID = @[chk_cstms_div_id]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${attr_ctnt1} != '')" ).append("\n"); 
		query.append("AND ATTR_CTNT1 = @[attr_ctnt1]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${attr_ctnt2} != '')" ).append("\n"); 
		query.append("AND ATTR_CTNT2 = @[attr_ctnt2]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${order_by_col} != '')" ).append("\n"); 
		query.append("ORDER BY ${order_by_col}" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY CSTMS_DIV_ID_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}