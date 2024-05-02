/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOChkBzcAgmtCrrVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOChkBzcAgmtCrrVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Carriers 중복조회
	  * 2012.06.01 : 김상근[CHM-201218057-01]
	  * Discription : Table의 Key변경 RLANE_CD, JO_REP_CRR_CD, JO_CRR_CD -> JO_REF_NO, JO_CRR_CD
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOChkBzcAgmtCrrVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOChkBzcAgmtCrrVORSQL").append("\n"); 
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
		query.append("SELECT JO_REF_NO, RLANE_CD, JO_REP_CRR_CD," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 1, JO_CRR_CD )) JO_CRR_CD1," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 2, JO_CRR_CD )) JO_CRR_CD2," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 3, JO_CRR_CD )) JO_CRR_CD3," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 4, JO_CRR_CD )) JO_CRR_CD4," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 5, JO_CRR_CD )) JO_CRR_CD5," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 6, JO_CRR_CD )) JO_CRR_CD6," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 7, JO_CRR_CD )) JO_CRR_CD7," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 8, JO_CRR_CD )) JO_CRR_CD8," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 9, JO_CRR_CD )) JO_CRR_CD9," ).append("\n"); 
		query.append("        MAX(DECODE(RN#, 10, JO_CRR_CD )) JO_CRR_CD10" ).append("\n"); 
		query.append("    FROM ( " ).append("\n"); 
		query.append("    SELECT A.JO_REF_NO, A.RLANE_CD, A.JO_CRR_CD AS JO_REP_CRR_CD, B.JO_CRR_CD," ).append("\n"); 
		query.append("    ROW_NUMBER() OVER( PARTITION BY B.JO_REF_NO ORDER BY B.JO_CRR_CD ) RN#" ).append("\n"); 
		query.append("    FROM JOO_BZC_AGMT A, JOO_BZC_AGMT_CRR B" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    #if (${jo_ref_no} != '')" ).append("\n"); 
		query.append("    AND A.JO_REF_NO = @[jo_ref_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("    AND A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND A.JO_REF_NO = B.JO_REF_NO" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY JO_REF_NO, RLANE_CD, JO_REP_CRR_CD" ).append("\n"); 

	}
}