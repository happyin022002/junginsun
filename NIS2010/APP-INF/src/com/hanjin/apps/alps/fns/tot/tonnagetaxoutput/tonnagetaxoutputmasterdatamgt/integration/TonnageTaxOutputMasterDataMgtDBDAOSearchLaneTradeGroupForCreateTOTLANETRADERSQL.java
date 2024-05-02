/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TonnageTaxOutputMasterDataMgtDBDAOSearchLaneTradeGroupForCreateTOTLANETRADERSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxOutputMasterDataMgtDBDAOSearchLaneTradeGroupForCreateTOTLANETRADERSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VSL 스케쥴에서 해당월별로 실제 운항한 LANE정보와 TRADE를 가져와 조회하고, 
	  *      유저가 LANE별 TRADE를 검토 및 수정하기 위해 데이터 조회
	  * </pre>
	  */
	public TonnageTaxOutputMasterDataMgtDBDAOSearchLaneTradeGroupForCreateTOTLANETRADERSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration ").append("\n"); 
		query.append("FileName : TonnageTaxOutputMasterDataMgtDBDAOSearchLaneTradeGroupForCreateTOTLANETRADERSQL").append("\n"); 
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
		query.append("SELECT M.REP_TRD_CD TRD_CD, M.VSL_SLAN_CD" ).append("\n"); 
		query.append(" FROM MDM_REV_LANE M" ).append("\n"); 
		query.append(" WHERE M.VSL_SLAN_CD IN " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("      SELECT DISTINCT S.SLAN_CD" ).append("\n"); 
		query.append("      FROM VSK_VSL_PORT_SKD S" ).append("\n"); 
		query.append("      WHERE S.VPS_ETD_DT >= TO_DATE(@[stl_yrmon]||'01', 'YYYYMMDD') " ).append("\n"); 
		query.append("		AND S.VPS_ETD_DT < ADD_MONTHS(TO_DATE(@[stl_yrmon]||'01', 'YYYYMMDD'), 1)" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}