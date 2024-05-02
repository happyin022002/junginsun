/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ImmediateExitDBDAOImmediateExitCreationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ImmediateExitDBDAOImmediateExitCreationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Immediate Exit 관리 대상 장비목록을 조회한다.
	  * </pre>
	  */
	public ImmediateExitDBDAOImmediateExitCreationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.integration").append("\n"); 
		query.append("FileName : ImmediateExitDBDAOImmediateExitCreationListRSQL").append("\n"); 
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
		query.append("SELECT  A.IMDT_EXT_FLG, A.CNTR_NO, A.AGMT_SEQ, A.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("        TO_CHAR(A.ONH_DT, 'YYYYMMDD') AS ONH_DT, A.ONH_YD_CD, " ).append("\n"); 
		query.append("        A.CRNT_YD_CD, A.CNMV_STS_CD, A.ACIAC_DIV_CD, " ).append("\n"); 
		query.append("        TO_CHAR(A.CNMV_DT, 'YYYYMMDD') AS CNMV_DT, " ).append("\n"); 
		query.append("		DECODE(A.FULL_FLG, 'Y','F','M') AS FULL_FLG" ).append("\n"); 
		query.append("FROM    MST_CONTAINER A" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND 	A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("AND     A.CNTR_STS_CD NOT IN('LSO','DIO','TLL','SRO','SCR','SLD','DON')" ).append("\n"); 
		query.append("#if (${cntr_no_list} != '')" ).append("\n"); 
		query.append("AND A.CNTR_NO IN (" ).append("\n"); 
		query.append("	#foreach($key IN ${cntr_no_list_seq})" ).append("\n"); 
		query.append("		#if($velocityCount < $cntr_no_list_seq.size())" ).append("\n"); 
		query.append("			'$key'," ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			'$key'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("AND		A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != '')" ).append("\n"); 
		query.append("AND		A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("AND     DECODE(@[loc_tp], '1',A.RCC_CD,'2',A.LCC_CD," ).append("\n"); 
		query.append("            '4',A.SCC_CD,'5',A.CRNT_YD_CD) = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}