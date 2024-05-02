/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RegionDepartureReportDBDAOSearchHC45RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.17 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAOSearchHC45RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * HC45 조회
	  * </pre>
	  */
	public RegionDepartureReportDBDAOSearchHC45RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : RegionDepartureReportDBDAOSearchHC45RSQL").append("\n"); 
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
		query.append("/***SEARCH HIGH CUBIC****/" ).append("\n"); 
		query.append("/***EXT****/" ).append("\n"); 
		query.append("SELECT B.OPR_CD" ).append("\n"); 
		query.append(",    SUM(DECODE(M.TYPE,'F',M.SLOT_HC20,'E',M.SLOT_HC20,0)) LOAD_20" ).append("\n"); 
		query.append(",    NVL(B.HC20_QTY,0)                                	   HC20_QTY" ).append("\n"); 
		query.append(",    NVL(B.HC20_RAT,0)                                	   HC20_RATE" ).append("\n"); 
		query.append(",    SUM(DECODE(M.TYPE,'3',NVL(M.SLOT_QTY,0),0))           ADD_20" ).append("\n"); 
		query.append(",    SUM(NVL(M.SLOT_HC,0))                                 LOAD_40" ).append("\n"); 
		query.append(",    NVL(B.HC_QTY,0)                                  	 HC40_QTY" ).append("\n"); 
		query.append(",    NVL(B.HC_RAT,0)                                  	 HC40_RAT" ).append("\n"); 
		query.append(",    SUM(DECODE(M.TYPE,'H',NVL(M.SLOT_QTY,0),0))           ADD_40" ).append("\n"); 
		query.append(",    SUM(NVL(M.SLOT_45,0))                                 LOAD_45" ).append("\n"); 
		query.append(",    NVL(B.QTY_45,0)                                  	 BSA_45" ).append("\n"); 
		query.append(",    NVL(B.UN_RAT_45,0)                               	 UN_RAT_45" ).append("\n"); 
		query.append(",    NVL(B.OV_RAT_45,0)                               	 OV_RAT_45" ).append("\n"); 
		query.append(",    SUM(DECODE(M.TYPE,'L',NVL(M.SLOT_QTY,0),0))           ADD_45" ).append("\n"); 
		query.append(",    DECODE(B.TTL_RAT, 'R', 'Rate', 'V', 'Void', NULL) RATIO_TYPE" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_BSA B, RDR_UTILIZE M" ).append("\n"); 
		query.append("WHERE  H.VSL_CD  =  @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO  =  @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD  =  @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION  =  @[region]" ).append("\n"); 
		query.append("AND    H.VSL_CD    = B.VSL_CD(+)" ).append("\n"); 
		query.append("AND    H.VOY_NO    = B.VOY_NO(+)" ).append("\n"); 
		query.append("AND    H.DIR_CD    = B.DIR_CD(+)" ).append("\n"); 
		query.append("AND    H.REGION    = B.REGION(+)" ).append("\n"); 
		query.append("AND    H.VSL_CD    = M.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO    = M.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD    = M.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION    = M.REGION" ).append("\n"); 
		query.append("AND    DECODE(M.OPR_CD,NULL,'N',B.OPR_CD)    = NVL(M.OPR_CD,'N')" ).append("\n"); 
		query.append("--AND    H.UPDATE_SYS IS NULL" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("AND    H.PORT_CD  = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY B.OPR_CD, DECODE(B.TTL_RAT, 'R', 'Rate', 'V', 'Void', NULL), NVL(B.HC20_RAT,0), NVL(B.HC_RAT,0), NVL(B.UN_RAT_45,0), NVL(B.OV_RAT_45,0), NVL(B.HC20_QTY,0), NVL(B.HC_QTY,0),NVL(B.QTY_45,0)" ).append("\n"); 
		query.append("ORDER BY B.OPR_CD" ).append("\n"); 

	}
}