/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSearchCntrConverionDefaultTpszRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSearchCntrConverionDefaultTpszRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Default TP/SZ & TP/SZ Search
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSearchCntrConverionDefaultTpszRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ppt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dft_tpsz_group",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration ").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSearchCntrConverionDefaultTpszRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.ATTR_CTNT1 AS DFT_TPSZ_GROUP" ).append("\n"); 
		query.append("     , A.ATTR_CTNT2 AS DFT_TPSZ" ).append("\n"); 
		query.append("     , A.ATTR_CTNT3 AS DFT_TEU_CNT" ).append("\n"); 
		query.append("     , A.ATTR_CTNT4 AS DFT_RF_PLUG_FLG" ).append("\n"); 
		query.append("     , A.LINE_SEQ" ).append("\n"); 
		query.append("  FROM JOO_COM_PPT A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.PPT_CD = @[ppt_cd]" ).append("\n"); 
		query.append("   AND A.ATTR_CTNT1 = @[dft_tpsz_group]" ).append("\n"); 
		query.append(" ORDER BY A.LINE_SEQ" ).append("\n"); 
		query.append("     , A.ATTR_CTNT1" ).append("\n"); 
		query.append("     , A.ATTR_CTNT2" ).append("\n"); 

	}
}