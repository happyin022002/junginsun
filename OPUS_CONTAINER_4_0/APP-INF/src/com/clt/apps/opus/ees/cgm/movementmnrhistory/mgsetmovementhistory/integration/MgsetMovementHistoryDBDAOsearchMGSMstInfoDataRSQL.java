/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MgsetMovementHistoryDBDAOsearchMGSMstInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MgsetMovementHistoryDBDAOsearchMGSMstInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MgsetMovementHistoryDBDAOsearchMGSMstInfoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration ").append("\n"); 
		query.append("FileName : MgsetMovementHistoryDBDAOsearchMGSMstInfoDataRSQL").append("\n"); 
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
		query.append("SELECT /*+ index(b XPKCGM_EQ_STS_HIS )  */" ).append("\n"); 
		query.append("       A.EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.AGMT_LSTM_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(B.STS_EVNT_DT,'YYYY-MM-DD') ONH_DT" ).append("\n"); 
		query.append("      ,A.EQ_NO" ).append("\n"); 
		query.append("      ,A.EQ_STS_SEQ" ).append("\n"); 
		query.append("      ,DECODE(A.ACIAC_DIV_CD,'A','Active','In Active') ACIAC_DIV_CD" ).append("\n"); 
		query.append(" FROM CGM_EQUIPMENT  A" ).append("\n"); 
		query.append("   ,  CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append(" WHERE A.EQ_KND_CD='G'" ).append("\n"); 
		query.append("   AND A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("   AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}