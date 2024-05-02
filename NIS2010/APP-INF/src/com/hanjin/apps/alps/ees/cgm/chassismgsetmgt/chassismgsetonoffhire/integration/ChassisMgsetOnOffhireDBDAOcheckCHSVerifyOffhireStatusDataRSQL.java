/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOcheckCHSVerifyOffhireStatusDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.10.12 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOcheckCHSVerifyOffhireStatusDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOcheckCHSVerifyOffhireStatusDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOcheckCHSVerifyOffhireStatusDataRSQL").append("\n"); 
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
		query.append("CASE WHEN A.ACIAC_DIV_CD   != 'A' THEN" ).append("\n"); 
		query.append("'Inactive Status!'" ).append("\n"); 
		query.append("WHEN  (A.CHSS_OWNR_CO_CD  IS  NULL OR A.CHSS_OWNR_CO_CD != 'H')  THEN" ).append("\n"); 
		query.append("'No SM Line Owner!'" ).append("\n"); 
		query.append("WHEN  ( A.AGMT_LSTM_CD != 'ST' AND   A.AGMT_LSTM_CD != 'LT' ) THEN" ).append("\n"); 
		query.append("'No Lease Term!'" ).append("\n"); 
		query.append("WHEN  NOT EXISTS (SELECT" ).append("\n"); 
		query.append("'X'" ).append("\n"); 
		query.append("FROM MST_CNTR_PRE_STS A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("CNTR_STS_CD  ='LSO'" ).append("\n"); 
		query.append("AND A.CNTR_PRE_STS_CD =  B.EQ_ASET_STS_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("THEN" ).append("\n"); 
		query.append("'No valid Status!'" ).append("\n"); 
		query.append("WHEN EXISTS (SELECT 'X' from DUAL" ).append("\n"); 
		query.append("WHERE  @[sts_evnt_dt] <  to_char(B.STS_EVNT_DT,'RRRR-MM-DD')" ).append("\n"); 
		query.append(")  THEN" ).append("\n"); 
		query.append("'Check creation time of last status.'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'OK'" ).append("\n"); 
		query.append("END AS VERIFY" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A , CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD = 'Z'" ).append("\n"); 
		query.append("AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND B.ROWID = (SELECT /*+ INDEX_DESC(C XPKCGM_EQ_STS_HIS) */" ).append("\n"); 
		query.append("ROWID" ).append("\n"); 
		query.append("FROM CGM_EQ_STS_HIS C" ).append("\n"); 
		query.append("WHERE C.EQ_NO= A.EQ_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1)" ).append("\n"); 

	}
}