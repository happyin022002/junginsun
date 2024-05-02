/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RegionDepartureReportDBDAOSearchRDRRegionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.11.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAOSearchRDRRegionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 에 해당하는 Region Code를 조회한다.
	  * 2011.08.24 김민아 [CHM-201113050-01] [VOP-OPF] RDR Inquiry 로직 변경 : RDR이 생성된 region만 보일수 있도록 로직 변경
	  * 2013.11.22 임옥영 [CHM-201327237] [VOP-OPF] RDR Summary 화면 추가에 따라 VVD CODE가 있는 경우에만 VVD 걸어주게 수정
	  * </pre>
	  */
	public RegionDepartureReportDBDAOSearchRDRRegionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAOSearchRDRRegionListRSQL").append("\n"); 
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
		query.append("SELECT  INTG_CD_ID" ).append("\n"); 
		query.append("       ,INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("       ,INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("       ,INTG_CD_VAL_DESC" ).append("\n"); 
		query.append("       ,INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("       ,APLY_ST_DT" ).append("\n"); 
		query.append("       ,APLY_END_DT" ).append("\n"); 
		query.append("  FROM  COM_INTG_CD_DTL" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  INTG_CD_ID = 'CD02169'" ).append("\n"); 
		query.append("   AND  INTG_CD_VAL_CTNT IN (" ).append("\n"); 
		query.append("                            SELECT  REGION" ).append("\n"); 
		query.append("                              FROM  RDR_HEADER" ).append("\n"); 
		query.append("                             WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${vsl_cd} != '' && ${voy_no} != '' && ${dir_cd} != '')" ).append("\n"); 
		query.append("                               AND  VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                               AND  VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("                               AND  DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 

	}
}