/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RegionDepartureReportDBDAORDRLoadVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.28
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.08.28 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAORDRLoadVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDRLoadVO Select Query
	  * </pre>
	  */
	public RegionDepartureReportDBDAORDRLoadVORSQL(){
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
		params.put("opr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : RegionDepartureReportDBDAORDRLoadVORSQL").append("\n"); 
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
		query.append("SELECT 		OPR_CD," ).append("\n"); 
		query.append("POD_ISO as POD," ).append("\n"); 
		query.append("CNTR_TYPE," ).append("\n"); 
		query.append("CNTR_SIZE," ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount < 10)" ).append("\n"); 
		query.append("CASE WHEN  POD_ISO ='TOTAL'  AND CNTR_SIZE='WEIGHT' THEN" ).append("\n"); 
		query.append("TO_CHAR( NVL(POL_QTY_0$velocityCount, '0'),'fm999,999,990.0')" ).append("\n"); 
		query.append("ELSE TO_CHAR( NVL(POL_QTY_0$velocityCount, '0')) END  POL_QTY_0$velocityCount ," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("CASE WHEN  POD_ISO ='TOTAL'  AND CNTR_SIZE='WEIGHT' THEN" ).append("\n"); 
		query.append("TO_CHAR( NVL(POL_QTY_$velocityCount, '0'),'fm999,999,990.0')" ).append("\n"); 
		query.append("ELSE TO_CHAR( NVL(POL_QTY_$velocityCount, '0')) END  POL_QTY_$velocityCount ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("CASE WHEN  POD_ISO ='TOTAL'  AND CNTR_SIZE='WEIGHT' THEN  ''  ELSE NVL(TO_CHAR( TOTAL_VOL),'0') END TOTAL_VOL," ).append("\n"); 
		query.append("TOTAL_WGT" ).append("\n"); 
		query.append("FROM   		( 	SELECT OPR_CD," ).append("\n"); 
		query.append("POD_ISO," ).append("\n"); 
		query.append("CNTR_TYPE," ).append("\n"); 
		query.append("CNTR_SIZE," ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount < 10)" ).append("\n"); 
		query.append("POL_QTY_0$velocityCount," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("POL_QTY_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("TOTAL_VOL," ).append("\n"); 
		query.append("TOTAL_WGT" ).append("\n"); 
		query.append("FROM   ( 	SELECT OPR_CD, POD_ISO, CNTR_TYPE," ).append("\n"); 
		query.append("DECODE(CNTR_SIZE,'2','20','3','2H','4','40','H','4H','L','45') CNTR_SIZE," ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN GROUPING(OPR_CD)=0 AND GROUPING(POD_ISO)=0 AND GROUPING(CNTR_TYPE)=0 AND GROUPING(CNTR_SIZE)=0 THEN 1" ).append("\n"); 
		query.append("ELSE 0" ).append("\n"); 
		query.append("END C1," ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount < 10)" ).append("\n"); 
		query.append("MAX(DECODE(ROW_NUM, $velocityCount, QTY,0))    POL_QTY_0$velocityCount," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MAX(DECODE(ROW_NUM, $velocityCount, QTY,0))    POL_QTY_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("MAX(DECODE(ROW_NUM, $velocityCount,QTY,0))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("+ MAX(DECODE(ROW_NUM, $velocityCount,QTY,0))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AS TOTAL_VOL," ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("MAX(DECODE(ROW_NUM, $velocityCount,WGT,0))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("+ MAX(DECODE(ROW_NUM, $velocityCount,WGT,0))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AS TOTAL_WGT" ).append("\n"); 
		query.append("FROM   ( WITH S AS" ).append("\n"); 
		query.append("( SELECT M.OPR_CD, M.POD_ISO, M.CNTR_TYPE, M.CNTR_SIZE, M.QTY, M.WEIGHT WGT, POL" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_SUMMARY M" ).append("\n"); 
		query.append("WHERE  H.VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO  = @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD  = @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION  = @[region]" ).append("\n"); 
		query.append("#if (${opr_cd} != '' && ${opr_cd} != 'All')" ).append("\n"); 
		query.append("AND    M.OPR_CD    = @[opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD  = M.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO  = M.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD  = M.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION  = M.REGION" ).append("\n"); 
		query.append("AND    M.POL IN (" ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") ), --:pol_cd" ).append("\n"); 
		query.append("DUMY AS" ).append("\n"); 
		query.append("( 	SELECT 'F' CNTR_TYPE, '2' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'F' CNTR_TYPE, '3' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'F' CNTR_TYPE, '4' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'F' CNTR_TYPE, 'H' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'F' CNTR_TYPE, 'L' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'E' CNTR_TYPE, '2' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'E' CNTR_TYPE, '3' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'E' CNTR_TYPE, '4' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'E' CNTR_TYPE, 'H' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'E' CNTR_TYPE, 'L' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT S1.OPR_CD, S1.POD_ISO, S1.CNTR_TYPE, S1.CNTR_SIZE, NVL(S2.QTY,0) QTY, NVL(S2.WGT,0) WGT," ).append("\n"); 
		query.append("CASE 	#foreach($key IN ${pol})" ).append("\n"); 
		query.append("WHEN S1.POL = '$key' THEN $velocityCount" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("END ROW_NUM" ).append("\n"); 
		query.append("FROM   ( 	SELECT OPR_CD, POD_ISO, POL, CNTR_TYPE, CNTR_SIZE" ).append("\n"); 
		query.append("FROM   ( 	SELECT DISTINCT OPR_CD, POD_ISO, POL" ).append("\n"); 
		query.append("FROM S" ).append("\n"); 
		query.append(") S, DUMY ) S1, S S2" ).append("\n"); 
		query.append("WHERE S1.OPR_CD    = S2.OPR_CD(+)" ).append("\n"); 
		query.append("AND   S1.POD_ISO   = S2.POD_ISO(+)" ).append("\n"); 
		query.append("AND   S1.POL       = S2.POL(+)" ).append("\n"); 
		query.append("AND   S1.CNTR_TYPE = S2.CNTR_TYPE(+)" ).append("\n"); 
		query.append("AND   S1.CNTR_SIZE = S2.CNTR_SIZE(+) )" ).append("\n"); 
		query.append("GROUP BY CUBE(OPR_CD, POD_ISO, CNTR_TYPE, CNTR_SIZE ) )" ).append("\n"); 
		query.append("WHERE C1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT OPR_CD," ).append("\n"); 
		query.append("'Sub-TTL' POD_ISO," ).append("\n"); 
		query.append("CNTR_TYPE," ).append("\n"); 
		query.append("CNTR_SIZE," ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount < 10)" ).append("\n"); 
		query.append("POL_QTY_0$velocityCount," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("POL_QTY_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("TOTAL_VOL," ).append("\n"); 
		query.append("TOTAL_WGT" ).append("\n"); 
		query.append("FROM   ( SELECT OPR_CD, CNTR_TYPE," ).append("\n"); 
		query.append("DECODE(CNTR_SIZE,'2','20','3','2H','4','40','H','4H','L','45') CNTR_SIZE," ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount < 10)" ).append("\n"); 
		query.append("SUM(DECODE(ROW_NUM, $velocityCount, QTY,0))    POL_QTY_0$velocityCount," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SUM(DECODE(ROW_NUM, $velocityCount, QTY,0))    POL_QTY_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("SUM(DECODE(ROW_NUM, $velocityCount,QTY,0))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("+ SUM(DECODE(ROW_NUM, $velocityCount,QTY,0))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AS TOTAL_VOL," ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("SUM(DECODE(ROW_NUM, $velocityCount,WGT,0))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("+ SUM(DECODE(ROW_NUM, $velocityCount,WGT,0))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AS TOTAL_WGT" ).append("\n"); 
		query.append("FROM   ( WITH S AS" ).append("\n"); 
		query.append("( SELECT M.OPR_CD, M.CNTR_TYPE, M.CNTR_SIZE, M.QTY, M.WEIGHT WGT, POL" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_SUMMARY M" ).append("\n"); 
		query.append("WHERE  H.VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO  = @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD  = @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION  = @[region]" ).append("\n"); 
		query.append("#if (${opr_cd} != '' && ${opr_cd} != 'All')" ).append("\n"); 
		query.append("AND    M.OPR_CD    = @[opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD  = M.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO  = M.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD  = M.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION  = M.REGION" ).append("\n"); 
		query.append("AND    M.POL IN (" ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") ), --:pol_cd" ).append("\n"); 
		query.append("DUMY AS" ).append("\n"); 
		query.append("( SELECT 'F' CNTR_TYPE, '2' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'F' CNTR_TYPE, '3' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'F' CNTR_TYPE, '4' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'F' CNTR_TYPE, 'H' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'F' CNTR_TYPE, 'L' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'E' CNTR_TYPE, '2' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'E' CNTR_TYPE, '3' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'E' CNTR_TYPE, '4' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'E' CNTR_TYPE, 'H' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'E' CNTR_TYPE, 'L' CNTR_SIZE FROM DUAL )" ).append("\n"); 
		query.append("SELECT S1.OPR_CD, S1.CNTR_TYPE, S1.CNTR_SIZE, NVL(S2.QTY,0) QTY, NVL(S2.WGT,0) WGT," ).append("\n"); 
		query.append("CASE #foreach($key IN ${pol})" ).append("\n"); 
		query.append("WHEN S1.POL = '$key' THEN $velocityCount" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("END ROW_NUM" ).append("\n"); 
		query.append("FROM   ( SELECT OPR_CD, POL, CNTR_TYPE, CNTR_SIZE" ).append("\n"); 
		query.append("FROM   ( SELECT DISTINCT OPR_CD, POL" ).append("\n"); 
		query.append("FROM S ) S, DUMY ) S1, S S2" ).append("\n"); 
		query.append("WHERE S1.OPR_CD    = S2.OPR_CD(+)" ).append("\n"); 
		query.append("AND   S1.POL       = S2.POL(+)" ).append("\n"); 
		query.append("AND   S1.CNTR_TYPE = S2.CNTR_TYPE(+)" ).append("\n"); 
		query.append("AND   S1.CNTR_SIZE = S2.CNTR_SIZE(+) )" ).append("\n"); 
		query.append("GROUP BY OPR_CD,  CNTR_TYPE, CNTR_SIZE )" ).append("\n"); 
		query.append("UNION ALL  /*** TOTAL***/" ).append("\n"); 
		query.append("SELECT   D_S.OPR_CD," ).append("\n"); 
		query.append("'TOTAL' POD_ISO," ).append("\n"); 
		query.append("'F/E' CNTR_TYPE," ).append("\n"); 
		query.append("D_S.CNTR_SIZE," ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount < 10)" ).append("\n"); 
		query.append("POL_QTY_0$velocityCount," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("POL_QTY_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("TOTAL_VOL," ).append("\n"); 
		query.append("TOTAL_WGT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT 	  OPR_CD," ).append("\n"); 
		query.append("'TOTAL'  POD_ISO," ).append("\n"); 
		query.append("'F/E'   CNTR_TYPE," ).append("\n"); 
		query.append("CNTR_SIZE," ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount < 10)" ).append("\n"); 
		query.append("POL_QTY_0$velocityCount," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("POL_QTY_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("TOTAL_VOL," ).append("\n"); 
		query.append("TOTAL_WGT" ).append("\n"); 
		query.append("FROM   ( 	SELECT OPR_CD,DECODE(CNTR_SIZE,'2','20','3','2H','4','40','H','4H','L','45') CNTR_SIZE," ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount < 10)" ).append("\n"); 
		query.append("MAX(DECODE(ROW_NUM, $velocityCount, QTY,0))    POL_QTY_0$velocityCount," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MAX(DECODE(ROW_NUM, $velocityCount, QTY,0))    POL_QTY_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("MAX(DECODE(ROW_NUM, $velocityCount,QTY,0))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("+ MAX(DECODE(ROW_NUM, $velocityCount,QTY,0))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AS TOTAL_VOL," ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("MAX(DECODE(ROW_NUM, $velocityCount,WGT,0))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("+ MAX(DECODE(ROW_NUM, $velocityCount,WGT,0))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AS TOTAL_WGT" ).append("\n"); 
		query.append("FROM   ( WITH S AS" ).append("\n"); 
		query.append("( 	SELECT M.OPR_CD, M.POL, M.CNTR_SIZE, SUM(M.QTY) QTY, SUM(M.WEIGHT) WGT" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_SUMMARY M" ).append("\n"); 
		query.append("WHERE  H.VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO  = @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD  = @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION  = @[region]" ).append("\n"); 
		query.append("#if (${opr_cd} != '' && ${opr_cd} != 'All')" ).append("\n"); 
		query.append("AND    M.OPR_CD    = @[opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD  = M.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO  = M.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD  = M.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION  = M.REGION" ).append("\n"); 
		query.append("AND    M.POL IN (" ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") --:pol_cd" ).append("\n"); 
		query.append("GROUP by  M.POL, M.CNTR_SIZE ,M.OPR_CD )," ).append("\n"); 
		query.append("DUMY AS" ).append("\n"); 
		query.append("( 	SELECT '2' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '3' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '4' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'H' CNTR_SIZE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'L' CNTR_SIZE FROM DUAL )" ).append("\n"); 
		query.append("SELECT S1.POL, S1.CNTR_SIZE, NVL(S2.QTY,0) QTY, NVL(S2.WGT,0) WGT," ).append("\n"); 
		query.append("CASE  #foreach($key IN ${pol})" ).append("\n"); 
		query.append("WHEN S1.POL = '$key' THEN $velocityCount" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("END ROW_NUM, S2.OPR_CD" ).append("\n"); 
		query.append("FROM   ( 	SELECT POL, CNTR_SIZE" ).append("\n"); 
		query.append("FROM   ( SELECT DISTINCT POL" ).append("\n"); 
		query.append("FROM S ) S, DUMY ) S1, S S2" ).append("\n"); 
		query.append("WHERE  S1.POL       = S2.POL(+)" ).append("\n"); 
		query.append("AND    S1.CNTR_SIZE = S2.CNTR_SIZE(+)" ).append("\n"); 
		query.append("ORDER BY S1.POL, S1.CNTR_SIZE )" ).append("\n"); 
		query.append("GROUP BY OPR_CD,DECODE(CNTR_SIZE,'2','20','3','2H','4','40','H','4H','L','45')" ).append("\n"); 
		query.append("HAVING OPR_CD IS NOT NULL)" ).append("\n"); 
		query.append(")T," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(SELECT OPR.OPR_CD,  D_SIZE.CNTR_SIZE" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT M.OPR_CD" ).append("\n"); 
		query.append("FROM   RDR_HEADER H," ).append("\n"); 
		query.append("RDR_SUMMARY M" ).append("\n"); 
		query.append("WHERE  H.VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO  = @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD  = @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION  = @[region]" ).append("\n"); 
		query.append("#if (${opr_cd} != '' && ${opr_cd} != 'All')" ).append("\n"); 
		query.append("AND    M.OPR_CD    = @[opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD = M.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO = M.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD = M.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION = M.REGION" ).append("\n"); 
		query.append("AND    M.POL IN (" ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") --:pol_cd" ).append("\n"); 
		query.append("GROUP by M.OPR_CD ) OPR," ).append("\n"); 
		query.append("(SELECT '20' CNTR_SIZE FROM   DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT '2H' CNTR_SIZE FROM   DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT '40' CNTR_SIZE FROM   DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT '4H' CNTR_SIZE FROM   DUAL UNION ALL" ).append("\n"); 
		query.append("SELECT '45' CNTR_SIZE FROM   DUAL )  D_SIZE" ).append("\n"); 
		query.append(")  D_S" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("D_S.OPR_CD        = T.OPR_CD    (+)" ).append("\n"); 
		query.append("AND   D_S.CNTR_SIZE     = T.CNTR_SIZE (+)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 	 OPR_CD," ).append("\n"); 
		query.append("'TOTAL'    POD_ISO," ).append("\n"); 
		query.append("'WEIGHT' CNTR_TYPE," ).append("\n"); 
		query.append("'WEIGHT' CNTR_SIZE," ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount < 10)" ).append("\n"); 
		query.append("POL_QTY_0$velocityCount," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("POL_QTY_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("TOTAL_VOL," ).append("\n"); 
		query.append("TOTAL_WGT" ).append("\n"); 
		query.append("FROM   ( SELECT OPR_CD," ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount < 10)" ).append("\n"); 
		query.append("MAX(DECODE(ROW_NUM, $velocityCount, WGT,0))    POL_QTY_0$velocityCount," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MAX(DECODE(ROW_NUM, $velocityCount, WGT,0))    POL_QTY_$velocityCount," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("MAX(DECODE(ROW_NUM, $velocityCount,WGT,0))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("+ MAX(DECODE(ROW_NUM, $velocityCount,WGT,0))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AS TOTAL_VOL," ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("MAX(DECODE(ROW_NUM, $velocityCount,WGT,0))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("+ MAX(DECODE(ROW_NUM, $velocityCount,WGT,0))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AS TOTAL_WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM   ( SELECT M.POL, SUM(M.WEIGHT) WGT," ).append("\n"); 
		query.append("MIN(CASE #foreach($key IN ${pol})" ).append("\n"); 
		query.append("WHEN M.POL = '$key' THEN $velocityCount" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("END) ROW_NUM,M.OPR_CD" ).append("\n"); 
		query.append("FROM   RDR_HEADER H, RDR_SUMMARY M" ).append("\n"); 
		query.append("WHERE  H.VSL_CD  = @[vsl_cd]" ).append("\n"); 
		query.append("AND    H.VOY_NO  = @[voy_no]" ).append("\n"); 
		query.append("AND    H.DIR_CD  = @[dir_cd]" ).append("\n"); 
		query.append("AND    H.REGION  = @[region]" ).append("\n"); 
		query.append("#if (${opr_cd} != '' && ${opr_cd} != 'All')" ).append("\n"); 
		query.append("AND    M.OPR_CD    = @[opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    H.VSL_CD  = M.VSL_CD" ).append("\n"); 
		query.append("AND    H.VOY_NO  = M.VOY_NO" ).append("\n"); 
		query.append("AND    H.DIR_CD  = M.DIR_CD" ).append("\n"); 
		query.append("AND    H.REGION  = M.REGION" ).append("\n"); 
		query.append("AND    M.CNTR_SIZE IN ('2',  '3',  '4',  'H',  'L' )" ).append("\n"); 
		query.append("AND    M.POL IN (" ).append("\n"); 
		query.append("#foreach($key IN ${pol})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") --:pol_cd" ).append("\n"); 
		query.append("GROUP BY  M.POL ,M.OPR_CD )" ).append("\n"); 
		query.append("GROUP BY OPR_CD" ).append("\n"); 
		query.append(") )" ).append("\n"); 
		query.append("ORDER BY OPR_CD ," ).append("\n"); 
		query.append("DECODE(POD_ISO,'TOTAL','ZZZZZ','Sub-TTL','ZZZZY',POD_ISO)," ).append("\n"); 
		query.append("DECODE(CNTR_TYPE,NULL,'Z','F/E','Y','E','X','F','W')," ).append("\n"); 
		query.append("DECODE(CNTR_SIZE,'20',1,'2H',2,'40',3,'4H',4,'45',5,'WEIGHT',6)" ).append("\n"); 

	}
}