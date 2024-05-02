/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : YardManageDBDAOSearchNodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class YardManageDBDAOSearchNodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchNodeList
	  * </pre>
	  */
	public YardManageDBDAOSearchNodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("node_code_top",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subconti_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location_code_top",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("country_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.integration").append("\n"); 
		query.append("FileName : YardManageDBDAOSearchNodeListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(nod_tp_cd, 'Z', 'Z', 'Y') node_type_code" ).append("\n"); 
		query.append("      ,DECODE(nod_tp_cd, 'Z', 'Zone', 'Yard') node_div" ).append("\n"); 
		query.append("      ,nod_cd node_code" ).append("\n"); 
		query.append("      ,nod_nm node_name" ).append("\n"); 
		query.append("      ,DECODE(nod_tp_cd, 'Y', 'Yard', 'M', 'Marine Terminal', 'B', 'Barge Terminal', 'S', 'CFS', 'R', 'Rail Ramp', 'Z', 'Zone') node_type" ).append("\n"); 
		query.append("      ,'' node_remark" ).append("\n"); 
		query.append("  FROM prd_node t" ).append("\n"); 
		query.append(" WHERE t.nod_cd LIKE @[node_code_top] || '%'" ).append("\n"); 
		query.append("   AND exists (SELECT e.loc_cd" ).append("\n"); 
		query.append("          FROM mdm_location e" ).append("\n"); 
		query.append("         WHERE e.loc_cd = t.loc_cd" ).append("\n"); 
		query.append("           AND e.loc_cd LIKE @[location_code_top] || '%'" ).append("\n"); 
		query.append("           AND e.conti_cd LIKE @[conti_code] || '%'" ).append("\n"); 
		query.append("           AND e.sconti_cd LIKE @[subconti_code] || '%'" ).append("\n"); 
		query.append("           AND e.cnt_cd = @[country_code]" ).append("\n"); 
		query.append("           AND e.rgn_cd LIKE @[region_code] || '%'" ).append("\n"); 
		query.append("           AND NVL(e.delt_flg, 'N') <> 'Y')" ).append("\n"); 
		query.append("	AND NVL( delt_flg,'N') <> 'Y'" ).append("\n"); 
		query.append("#if(${node_type_div} == 'Y')" ).append("\n"); 
		query.append("	AND    nod_tp_cd <> 'Z'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${node_type_div} == 'Z')" ).append("\n"); 
		query.append("	AND    nod_tp_cd = 'Z'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}