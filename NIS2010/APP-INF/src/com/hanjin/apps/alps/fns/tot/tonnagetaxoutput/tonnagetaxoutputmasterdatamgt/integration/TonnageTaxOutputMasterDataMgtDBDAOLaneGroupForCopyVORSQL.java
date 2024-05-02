/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TonnageTaxOutputMasterDataMgtDBDAOLaneGroupForCopyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2010.01.28 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Chang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TonnageTaxOutputMasterDataMgtDBDAOLaneGroupForCopyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당년월의 copy를 위한 순수데이터 조회
	  * </pre>
	  */
	public TonnageTaxOutputMasterDataMgtDBDAOLaneGroupForCopyVORSQL(){
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
		query.append("FileName : TonnageTaxOutputMasterDataMgtDBDAOLaneGroupForCopyVORSQL").append("\n"); 
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
		query.append("SELECT A.STL_YRMON" ).append("\n"); 
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

	}
}