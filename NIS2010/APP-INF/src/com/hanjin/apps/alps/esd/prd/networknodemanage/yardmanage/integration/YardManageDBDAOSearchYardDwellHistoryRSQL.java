/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : YardManageDBDAOSearchYardDwellHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class YardManageDBDAOSearchYardDwellHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * YardManageDBDAOSearchYardDwellHistoryRSQL
	  * </pre>
	  */
	public YardManageDBDAOSearchYardDwellHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.integration ").append("\n"); 
		query.append("FileName : YardManageDBDAOSearchYardDwellHistoryRSQL").append("\n"); 
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
		query.append("select NOD_CD,substr(HIS_CRE_DT,1,6) his_month,HIS_CRE_DT," ).append("\n"); 
		query.append("IB_DRY_AVG_DWLL_HRS,IB_RF_AVG_DWLL_HRS,OB_DRY_AVG_DWLL_HRS,OB_RF_AVG_DWLL_HRS," ).append("\n"); 
		query.append("COP_IB_DRY_AVG_DWLL_HRS,COP_IB_RF_AVG_DWLL_HRS,COP_OB_DRY_AVG_DWLL_HRS,COP_OB_RF_AVG_DWLL_HRS," ).append("\n"); 
		query.append("IB_DRY_MIN_DWLL_HRS,IB_RF_MIN_DWLL_HRS,OB_DRY_MIN_DWLL_HRS,OB_RF_MIN_DWLL_HRS" ).append("\n"); 
		query.append("from PRD_DWLL_TM_HIS" ).append("\n"); 
		query.append("where nod_cd=@[search_nod_cd]" ).append("\n"); 
		query.append("order by HIS_CRE_DT desc" ).append("\n"); 

	}
}