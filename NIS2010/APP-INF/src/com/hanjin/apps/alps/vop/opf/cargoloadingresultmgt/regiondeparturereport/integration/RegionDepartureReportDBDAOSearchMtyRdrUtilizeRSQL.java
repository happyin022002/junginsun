/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RegionDepartureReportDBDAOSearchMtyRdrUtilizeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.02 
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

public class RegionDepartureReportDBDAOSearchMtyRdrUtilizeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rdr Utilize 에 생성되지 않는 Type 이 존재하는지 조회한다.
	  * * 2011.09.02 김민아 [CHM-201113284-01] [OPF-RDR] RDR CREATION 화면 HC/RT ADD SLOT 저장로직보완 : 저장 시 RDR Utilize 에 누락된 데이터를 생성하는 로직을 추가
	  * </pre>
	  */
	public RegionDepartureReportDBDAOSearchMtyRdrUtilizeRSQL(){
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
		query.append("FileName : RegionDepartureReportDBDAOSearchMtyRdrUtilizeRSQL").append("\n"); 
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
		query.append("WITH UI_LIST AS (" ).append("\n"); 
		query.append("    SELECT  VSL_CD" ).append("\n"); 
		query.append("           ,VOY_NO" ).append("\n"); 
		query.append("           ,DIR_CD" ).append("\n"); 
		query.append("           ,REGION" ).append("\n"); 
		query.append("           ,OPR_CD" ).append("\n"); 
		query.append("           ,DECODE(B.NO, 1, TYPE_20," ).append("\n"); 
		query.append("                         2, TYPE_40," ).append("\n"); 
		query.append("                         3, TYPE_45" ).append("\n"); 
		query.append("            ) AS TYPE" ).append("\n"); 
		query.append("           ,DECODE(B.NO, 1, QTY_20," ).append("\n"); 
		query.append("                         2, QTY_40," ).append("\n"); 
		query.append("                         3, QTY_45" ).append("\n"); 
		query.append("            ) AS SLOT_QTY" ).append("\n"); 
		query.append("           ,UPDATE_USER" ).append("\n"); 
		query.append("      FROM  (" ).append("\n"); 
		query.append("            SELECT  VSL_CD" ).append("\n"); 
		query.append("                   ,VOY_NO" ).append("\n"); 
		query.append("                   ,DIR_CD" ).append("\n"); 
		query.append("                   ,REGION" ).append("\n"); 
		query.append("                   ,OPR_CD" ).append("\n"); 
		query.append("                   ,DECODE(TYPE_20, '', 'X', 0, 'X', '3') AS TYPE_20" ).append("\n"); 
		query.append("                   ,DECODE(TYPE_40, '', 'X', 0, 'X', 'H') AS TYPE_40" ).append("\n"); 
		query.append("                   ,DECODE(TYPE_45, '', 'X', 0, 'X', 'L') AS TYPE_45" ).append("\n"); 
		query.append("                   ,QTY_20" ).append("\n"); 
		query.append("                   ,QTY_40" ).append("\n"); 
		query.append("                   ,QTY_45" ).append("\n"); 
		query.append("                   ,UPDATE_USER" ).append("\n"); 
		query.append("            FROM    (" ).append("\n"); 
		query.append("                        #foreach( ${obj} in ${list_obj} )" ).append("\n"); 
		query.append("                            #if( $velocityCount != 1 )" ).append("\n"); 
		query.append("                                UNION ALL" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                                SELECT  DECODE('$obj.getVslCd()'  , NULL, 'NULL', '$obj.getVslCd()'  ) AS VSL_CD" ).append("\n"); 
		query.append("                                       ,DECODE('$obj.getVoyNo()'  , NULL, 'NULL', '$obj.getVoyNo()'  ) AS VOY_NO" ).append("\n"); 
		query.append("                                       ,DECODE('$obj.getDirCd()'  , NULL, 'NULL', '$obj.getDirCd()'  ) AS DIR_CD" ).append("\n"); 
		query.append("                                       ,DECODE('$obj.getRegion()' , NULL, 'NULL', '$obj.getRegion()' ) AS REGION" ).append("\n"); 
		query.append("                                       ,DECODE('$obj.getOprCd()'  , NULL, 'NULL', '$obj.getOprCd()'  ) AS OPR_CD" ).append("\n"); 
		query.append("                                       ,DECODE('$obj.getHc20Qty()', NULL, 'NULL', '$obj.getHc20Qty()') AS TYPE_20" ).append("\n"); 
		query.append("                                       ,DECODE('$obj.getHc40Qty()', NULL, 'NULL', '$obj.getHc40Qty()') AS TYPE_40" ).append("\n"); 
		query.append("                                       ,DECODE('$obj.getBsa45()'  , NULL, 'NULL', '$obj.getBsa45()'  ) AS TYPE_45" ).append("\n"); 
		query.append("                                       ,'$obj.getAdd20()' AS QTY_20" ).append("\n"); 
		query.append("                                       ,'$obj.getAdd40()' AS QTY_40" ).append("\n"); 
		query.append("                                       ,'$obj.getAdd45()' AS QTY_45" ).append("\n"); 
		query.append("                                       ,DECODE('$obj.getUpdateUser()', NULL, 'NULL', '$obj.getUpdateUser()') AS UPDATE_USER" ).append("\n"); 
		query.append("                                  FROM  DUAL" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("            ) A," ).append("\n"); 
		query.append("            (SELECT  1 AS NO FROM DUAL" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("             SELECT  2 FROM DUAL" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("             SELECT  3 FROM DUAL) B" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  B.VSL_CD" ).append("\n"); 
		query.append("       ,B.VOY_NO" ).append("\n"); 
		query.append("       ,B.DIR_CD" ).append("\n"); 
		query.append("       ,B.REGION" ).append("\n"); 
		query.append("       ,B.OPR_CD" ).append("\n"); 
		query.append("       ,B.TYPE" ).append("\n"); 
		query.append("       ,B.SLOT_QTY" ).append("\n"); 
		query.append("       ,B.UPDATE_USER" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  VSL_CD" ).append("\n"); 
		query.append("               ,VOY_NO" ).append("\n"); 
		query.append("               ,DIR_CD" ).append("\n"); 
		query.append("               ,REGION" ).append("\n"); 
		query.append("               ,OPR_CD" ).append("\n"); 
		query.append("               ,TYPE" ).append("\n"); 
		query.append("          FROM  UI_LIST" ).append("\n"); 
		query.append("         WHERE  1 = 1" ).append("\n"); 
		query.append("           AND  TYPE <> 'X'" ).append("\n"); 
		query.append("        MINUS" ).append("\n"); 
		query.append("        SELECT  VSL_CD" ).append("\n"); 
		query.append("               ,VOY_NO" ).append("\n"); 
		query.append("               ,DIR_CD" ).append("\n"); 
		query.append("               ,REGION" ).append("\n"); 
		query.append("               ,OPR_CD" ).append("\n"); 
		query.append("               ,TYPE" ).append("\n"); 
		query.append("          FROM  RDR_UTILIZE" ).append("\n"); 
		query.append("         WHERE  VSL_CD    = @[vsl_cd]" ).append("\n"); 
		query.append("           AND  VOY_NO    = @[voy_no]" ).append("\n"); 
		query.append("           AND  DIR_CD    = @[dir_cd]" ).append("\n"); 
		query.append("           AND  REGION    = @[region]" ).append("\n"); 
		query.append("        ) A," ).append("\n"); 
		query.append("        UI_LIST B" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("   AND  A.VOY_NO = B.VOY_NO" ).append("\n"); 
		query.append("   AND  A.DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("   AND  A.REGION = B.REGION" ).append("\n"); 
		query.append("   AND  A.OPR_CD = B.OPR_CD" ).append("\n"); 
		query.append("   AND  A.TYPE   = B.TYPE" ).append("\n"); 

	}
}