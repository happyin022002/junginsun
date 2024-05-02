/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOcheckVerifyOnhireCountDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.10.27 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae-Shung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOcheckVerifyOnhireCountDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOcheckVerifyOnhireCountDataRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOcheckVerifyOnhireCountDataRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("-- 이 쿼리는 Off Hire Query 임!" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CASE WHEN A.ACIAC_DIV_CD != 'A' THEN" ).append("\n"); 
		query.append("'Inactive Status!'" ).append("\n"); 
		query.append("WHEN (A.CHSS_OWNR_CO_CD IS NULL OR A.CHSS_OWNR_CO_CD != 'H') THEN" ).append("\n"); 
		query.append("'No SM Line Owner!'" ).append("\n"); 
		query.append("WHEN  ( A.AGMT_LSTM_CD != 'ST' AND   A.AGMT_LSTM_CD != 'LT') THEN" ).append("\n"); 
		query.append("'No Lease Term!'" ).append("\n"); 
		query.append("WHEN  NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM MST_CNTR_PRE_STS A" ).append("\n"); 
		query.append("WHERE CNTR_STS_CD  ='LSO'" ).append("\n"); 
		query.append("AND A.CNTR_PRE_STS_CD =  B.EQ_ASET_STS_CD" ).append("\n"); 
		query.append(") THEN" ).append("\n"); 
		query.append("'No valid Status!'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'OK'" ).append("\n"); 
		query.append("END AS VERIFY" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A, CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("AND A.EQ_NO=@[eq_no]" ).append("\n"); 
		query.append("AND B.ROWID = (SELECT /*+ INDEX_DESC(C XPKCGM_EQ_STS_HIS) */" ).append("\n"); 
		query.append("ROWID" ).append("\n"); 
		query.append("FROM CGM_EQ_STS_HIS C" ).append("\n"); 
		query.append("WHERE C.EQ_NO= A.EQ_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 

	}
}