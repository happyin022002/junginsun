/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxOutputMasterDataMgtDBDAOLaneGroupVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2010.02.01 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Chang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxOutputMasterDataMgtDBDAOLaneGroupVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane과 해당 Trade를 조회한다.
	  * </pre>
	  */
	public TonnageTaxOutputMasterDataMgtDBDAOLaneGroupVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration").append("\n"); 
		query.append("FileName : TonnageTaxOutputMasterDataMgtDBDAOLaneGroupVORSQL").append("\n"); 
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
		query.append("SELECT T.STL_YRMON" ).append("\n"); 
		query.append(",T.ERP_SLAN_CD" ).append("\n"); 
		query.append(",T.VSL_SLAN_CD" ).append("\n"); 
		query.append(",T.BSA_SLAN_CD" ).append("\n"); 
		query.append(",T.LANE_RMK" ).append("\n"); 
		query.append(",T.DELT_FLG" ).append("\n"); 
		query.append(",T.CRE_DT" ).append("\n"); 
		query.append(",T.CRE_USR_ID" ).append("\n"); 
		query.append(",T.UPD_DT" ).append("\n"); 
		query.append(",T.UPD_USR_ID" ).append("\n"); 
		query.append(",T.OLD_TRD_CD1" ).append("\n"); 
		query.append(",T.OLD_TRD_CD2" ).append("\n"); 
		query.append(",T.OLD_TRD_CD3" ).append("\n"); 
		query.append(",T.TRD_CD1" ).append("\n"); 
		query.append(",T.TRD_CD2" ).append("\n"); 
		query.append(",T.TRD_CD3" ).append("\n"); 
		query.append(",T.TRD_CD1_SEQ" ).append("\n"); 
		query.append(",T.TRD_CD2_SEQ" ).append("\n"); 
		query.append(",T.TRD_CD3_SEQ" ).append("\n"); 
		query.append(",T.TRD_CD" ).append("\n"); 
		query.append(",T.LANE_SEQ" ).append("\n"); 
		query.append(",T.STS_FLG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  @[stl_yrmon] STL_YRMON" ).append("\n"); 
		query.append(",T2.SLAN_CD  ERP_SLAN_CD" ).append("\n"); 
		query.append(",T1.VSL_SLAN_CD" ).append("\n"); 
		query.append(",T3.VSL_SLAN_CD BSA_SLAN_CD" ).append("\n"); 
		query.append(",T1.LANE_RMK" ).append("\n"); 
		query.append(",'N' DELT_FLG" ).append("\n"); 
		query.append(",TO_CHAR(T1.CRE_DT,'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append(",T1.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(T1.UPD_DT,'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append(",T1.UPD_USR_ID" ).append("\n"); 
		query.append(",T1.OLD_TRD_CD1" ).append("\n"); 
		query.append(",T1.OLD_TRD_CD2" ).append("\n"); 
		query.append(",T1.OLD_TRD_CD3" ).append("\n"); 
		query.append(",T1.TRD_CD1" ).append("\n"); 
		query.append(",T1.TRD_CD2" ).append("\n"); 
		query.append(",T1.TRD_CD3" ).append("\n"); 
		query.append(",T1.TRD_CD1_SEQ" ).append("\n"); 
		query.append(",T1.TRD_CD2_SEQ" ).append("\n"); 
		query.append(",T1.TRD_CD3_SEQ" ).append("\n"); 
		query.append(",T1.TRD_CD" ).append("\n"); 
		query.append(",T1.LANE_SEQ" ).append("\n"); 
		query.append(",'R' STS_FLG" ).append("\n"); 
		query.append("FROM (SELECT A.STL_YRMON" ).append("\n"); 
		query.append(",A.VSL_SLAN_CD" ).append("\n"); 
		query.append(",A.LANE_RMK" ).append("\n"); 
		query.append(",A.DELT_FLG" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",MAX(DECODE(ORD,1,TRD_CD)) OLD_TRD_CD1" ).append("\n"); 
		query.append(",MAX(DECODE(ORD,2,TRD_CD)) OLD_TRD_CD2" ).append("\n"); 
		query.append(",MAX(DECODE(ORD,3,TRD_CD)) OLD_TRD_CD3" ).append("\n"); 
		query.append(",MAX(DECODE(ORD,1,TRD_CD)) TRD_CD1" ).append("\n"); 
		query.append(",MAX(DECODE(ORD,2,TRD_CD)) TRD_CD2" ).append("\n"); 
		query.append(",MAX(DECODE(ORD,3,TRD_CD)) TRD_CD3" ).append("\n"); 
		query.append(",MAX(DECODE(ORD,1,LANE_SEQ)) TRD_CD1_SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(ORD,2,LANE_SEQ)) TRD_CD2_SEQ" ).append("\n"); 
		query.append(",MAX(DECODE(ORD,3,LANE_SEQ)) TRD_CD3_SEQ" ).append("\n"); 
		query.append(", '' TRD_CD" ).append("\n"); 
		query.append(", '' LANE_SEQ" ).append("\n"); 
		query.append("FROM (SELECT A.STL_YRMON" ).append("\n"); 
		query.append(", A.VSL_SLAN_CD" ).append("\n"); 
		query.append(", A.LANE_RMK" ).append("\n"); 
		query.append(", A.DELT_FLG" ).append("\n"); 
		query.append(", A.CRE_DT" ).append("\n"); 
		query.append(", A.CRE_USR_ID" ).append("\n"); 
		query.append(", A.UPD_DT" ).append("\n"); 
		query.append(", A.UPD_USR_ID" ).append("\n"); 
		query.append(", B.LANE_SEQ, B.TRD_CD" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER (PARTITION BY A.STL_YRMON,A.VSL_SLAN_CD ORDER BY B.LANE_SEQ) ORD" ).append("\n"); 
		query.append("FROM TOT_LANE A, TOT_LANE_TRD B" ).append("\n"); 
		query.append("WHERE  A.STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.STL_YRMON = B.STL_YRMON(+)" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD  = B.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY A.STL_YRMON" ).append("\n"); 
		query.append(",A.VSL_SLAN_CD" ).append("\n"); 
		query.append(",A.LANE_RMK" ).append("\n"); 
		query.append(",A.DELT_FLG" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(") T1," ).append("\n"); 
		query.append("( SELECT DISTINCT SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("FROM AR_ROUT_RNK" ).append("\n"); 
		query.append("WHERE DELT_FLG ='N'" ).append("\n"); 
		query.append(") T2," ).append("\n"); 
		query.append("(SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append(") T3" ).append("\n"); 
		query.append("WHERE T1.VSL_SLAN_CD = T2.SLAN_CD(+)" ).append("\n"); 
		query.append("AND  T1.VSL_SLAN_CD = T3.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT @[stl_yrmon] STL_YRMON" ).append("\n"); 
		query.append(",T4.SLAN_CD  ERP_SLAN_CD" ).append("\n"); 
		query.append(",''            VSL_SLAN_CD" ).append("\n"); 
		query.append(",T5.VSL_SLAN_CD BSA_SLAN_CD" ).append("\n"); 
		query.append(",'' LANE_RMK" ).append("\n"); 
		query.append(",'N' DELT_FLG" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' OLD_TRD_CD1" ).append("\n"); 
		query.append(",'' OLD_TRD_CD2" ).append("\n"); 
		query.append(",'' OLD_TRD_CD3" ).append("\n"); 
		query.append(",'' TRD_CD1" ).append("\n"); 
		query.append(",'' TRD_CD2" ).append("\n"); 
		query.append(",'' TRD_CD3" ).append("\n"); 
		query.append(",NULL TRD_CD1_SEQ" ).append("\n"); 
		query.append(",NULL TRD_CD2_SEQ" ).append("\n"); 
		query.append(",NULL TRD_CD3_SEQ" ).append("\n"); 
		query.append(",'' TRD_CD" ).append("\n"); 
		query.append(",'' LANE_SEQ" ).append("\n"); 
		query.append(",'I' STS_FLG" ).append("\n"); 
		query.append("FROM (SELECT DISTINCT SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("FROM AR_ROUT_RNK" ).append("\n"); 
		query.append("WHERE DELT_FLG ='N'" ).append("\n"); 
		query.append(") T4," ).append("\n"); 
		query.append("(SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM MDM_VSL_SVC_LANE" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append(") T5," ).append("\n"); 
		query.append("(SELECT COUNT(VSL_SLAN_CD) CNT" ).append("\n"); 
		query.append("FROM TOT_LANE" ).append("\n"); 
		query.append("WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND STL_YRMON = @[stl_yrmon]" ).append("\n"); 
		query.append(") T6" ).append("\n"); 
		query.append("WHERE T4.SLAN_CD NOT IN (SELECT VSL_SLAN_CD FROM TOT_LANE  WHERE DELT_FLG = 'N' AND STL_YRMON = @[stl_yrmon])" ).append("\n"); 
		query.append("AND  T4.SLAN_CD = T5.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("AND  T6.CNT > 0" ).append("\n"); 
		query.append(")T" ).append("\n"); 
		query.append("ORDER BY T.VSL_SLAN_CD , T.ERP_SLAN_CD" ).append("\n"); 

	}
}