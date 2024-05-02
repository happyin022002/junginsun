/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RailSoManageDBDAOSearch02RailSoManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2011.03.22 최 선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOSearch02RailSoManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * US Rail I/B Verify SQL 
	  * </pre>
	  */
	public RailSoManageDBDAOSearch02RailSoManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sofficeCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOSearch02RailSoManageRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("MAX(VERIFY_RESULT) VERIFY_RESULT," ).append("\n"); 
		query.append("MAX(VERIFY_YN) VERIFY_YN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("SUBSTR(  TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD')|| 'COMPANY - CNTR_NO: '||EQ_NO||' S/O created( '||TO_CHAR(LOCL_CRE_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("||DECODE(TRSP_BND_CD,'O', ' : Full )', ' : Mty )'||' ROUTE : '||FM_NOD_CD||'-->'||TO_NOD_CD),9,100) VERIFY_RESULT," ).append("\n"); 
		query.append("'Y' VERIFY_YN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD SO" ).append("\n"); 
		query.append("WHERE SO.TRSP_BND_CD ='I'" ).append("\n"); 
		query.append("AND   NVL(SO.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${eqNoVerify} != \"\")" ).append("\n"); 
		query.append("AND EQ_NO IN (" ).append("\n"); 
		query.append("#foreach($key IN ${eqNoVerify})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", '$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   SO.LOCL_CRE_DT BETWEEN (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sofficeCd]) - 15) AND GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[sofficeCd])" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY EQ_NO" ).append("\n"); 

	}
}