/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PRICommonDBDAORsltCompensationChargeComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.02.17 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltCompensationChargeComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * compensationChargeComboList
	  * </pre>
	  */
	public PRICommonDBDAORsltCompensationChargeComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltCompensationChargeComboListRSQL").append("\n"); 
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
		query.append("SELECT  CHG_CD" ).append("\n"); 
		query.append("       ,CHG_NM" ).append("\n"); 
		query.append("       ,DELT_FLG                -- param" ).append("\n"); 
		query.append("       ,NULL AS PROG_ID         -- param" ).append("\n"); 
		query.append("FROM    MDM_CHARGE" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${delt_flg} != '') " ).append("\n"); 
		query.append("AND     DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${prog_id} == '4009' || ${prog_id} == '4010')" ).append("\n"); 
		query.append("AND     CHG_CD IN ('DHF','CMS','NMS','ODF')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${prog_id} == '4009' || ${prog_id} == '4010')" ).append("\n"); 
		query.append("ORDER BY DECODE(CHG_CD, 'DHF',1,'CMS',2,'NMS',3,'ODF',4)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("ORDER BY CHG_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}