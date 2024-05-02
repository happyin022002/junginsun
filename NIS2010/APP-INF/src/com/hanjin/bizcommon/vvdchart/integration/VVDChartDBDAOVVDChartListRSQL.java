/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VVDChartDBDAOVVDChartListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.07
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2010.07.07 함대성
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.vvdchart.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HAM DAE SUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VVDChartDBDAOVVDChartListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVDChart의 모든 목록을 가져온다.
	  * </pre>
	  */
	public VVDChartDBDAOVVDChartListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scnr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.vvdchart.integration").append("\n"); 
		query.append("FileName : VVDChartDBDAOVVDChartListRSQL").append("\n"); 
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
		query.append("select level, id, name, decode(level, 1, '', substr(SYS_CONNECT_BY_PATH(id, '|'), 6,3) ) trade," ).append("\n"); 
		query.append("decode(level, 1, '', 2, '', substr(SYS_CONNECT_BY_PATH(id, '|'), 10,3) ) lane," ).append("\n"); 
		query.append("decode(level, 1, '', 2, '', 3, '', substr(SYS_CONNECT_BY_PATH(id, '|'), 14,9) ) vvd" ).append("\n"); 
		query.append("from (select 'All' id, '' depth, 'All' name, '' parent_id from dual" ).append("\n"); 
		query.append("union	all" ).append("\n"); 
		query.append("select trd_cd id, 'trade' depth, trd_nm name, 'All' parent_id from mdm_trade" ).append("\n"); 
		query.append("where vsl_tp_cd='C' and nvl(delt_flg, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${depth} != '1')" ).append("\n"); 
		query.append("union	all" ).append("\n"); 
		query.append("select distinct vsl_slan_cd id, 'lane' depth, vsl_slan_cd name, rep_trd_cd parent_id from mdm_rev_lane" ).append("\n"); 
		query.append("where nvl(delt_flg, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${scnr_id} != '')" ).append("\n"); 
		query.append("and vsl_slan_cd in (select distinct vsl_slan_cd from eqr_scnr_vsl_skd where scnr_id = @[scnr_id] )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${depth} == '3')" ).append("\n"); 
		query.append("union	all" ).append("\n"); 
		query.append("select distinct VSL_CD||SKD_VOY_NO||SKD_DIR_CD id, 'VVD' depth, '' name, vsl_slan_cd parent_id" ).append("\n"); 
		query.append("from eqr_scnr_vsl_skd" ).append("\n"); 
		query.append("where nvl(delt_flg, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${scnr_id} != '')" ).append("\n"); 
		query.append("and scnr_id = @[scnr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("connect by nocycle prior X.id = X.parent_id" ).append("\n"); 
		query.append("start with X.id='All'" ).append("\n"); 
		query.append("ORDER SIBLINGS BY id" ).append("\n"); 

	}
}