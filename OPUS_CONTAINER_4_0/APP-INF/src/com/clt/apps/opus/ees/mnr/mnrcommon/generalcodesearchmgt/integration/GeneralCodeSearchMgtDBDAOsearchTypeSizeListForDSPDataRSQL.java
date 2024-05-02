/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchTypeSizeListForDSPDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.10.14 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchTypeSizeListForDSPDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Disposal 에서의 TypeSize 조회
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchTypeSizeListForDSPDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration ").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchTypeSizeListForDSPDataRSQL").append("\n"); 
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
		query.append("#if (${knd_cd} == 'U')" ).append("\n"); 
		query.append("SELECT A.MNR_CD_ID AS CD_ID" ).append("\n"); 
		query.append(", A.MNR_CD_DP_DESC AS CD_DESC" ).append("\n"); 
		query.append("FROM MNR_GEN_CD A" ).append("\n"); 
		query.append("WHERE A.MNR_CD_GRP_NO = '3'" ).append("\n"); 
		query.append("AND A.PRNT_CD_ID = 'UT'" ).append("\n"); 
		query.append("ORDER BY A.MNR_CD_DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT A.EQ_TPSZ_CD    CD_ID," ).append("\n"); 
		query.append("A.DIFF_DESC     CD_DESC" ).append("\n"); 
		query.append("FROM CGM_EQ_TP_SZ A" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD = @[knd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${order_by_col_nm} == 'Y')" ).append("\n"); 
		query.append("ORDER BY A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}