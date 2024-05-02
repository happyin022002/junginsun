/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchCostCodeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchCostCodeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCostCodeData
	  * -- Container Cost Code 만 조회하도록 수정, 2014-07-15, 신용찬
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchCostCodeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmpo_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_sz",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchCostCodeDataRSQL").append("\n"); 
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
		query.append("SELECT C.EQ_CMPO_CD,C.EQ_CMPO_DESC,C.COST_CD FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT A.EQ_CMPO_CD, A.EQ_CMPO_DESC, DECODE(SUBSTR(@[tp_sz], 1, 1) ,'D', 'MRDRRC'" ).append("\n"); 
		query.append("                                                                   	   ,'R',  DECODE(B.EQ_PRNT_CMPO_CD, 'K6', 'MRRURC', 'MRRFRC')" ).append("\n"); 
		query.append("                                                                   	   ,'MRDSRC') AS COST_CD" ).append("\n"); 
		query.append("	FROM MNR_EQ_CMPO_CD A, MNR_EQ_CMPO_CD B" ).append("\n"); 
		query.append("    WHERE A.EQ_CMPO_GRP_TP_CD = 3" ).append("\n"); 
		query.append("    AND   A.EQ_PRNT_CMPO_GRP_TP_CD = B.EQ_CMPO_GRP_TP_CD" ).append("\n"); 
		query.append("	AND   A.EQ_PRNT_CMPO_CD = B.EQ_CMPO_CD" ).append("\n"); 
		query.append("    AND   A.EQ_CMPO_CD = @[cmpo_cd]" ).append("\n"); 
		query.append("    AND   SUBSTR(A.EQ_PRNT_CMPO_CD,1,2) IN ('K1','K4','K5','K6','K7') -- Container Cost Code 만 조회하도록 수정, 2014-07-15, 신용찬" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("GROUP BY C.EQ_CMPO_CD,C.EQ_CMPO_DESC,C.COST_CD" ).append("\n"); 

	}
}