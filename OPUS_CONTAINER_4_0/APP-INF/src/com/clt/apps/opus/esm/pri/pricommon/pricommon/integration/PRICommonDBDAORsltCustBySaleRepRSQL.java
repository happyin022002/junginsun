/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PRICommonDBDAORsltCustBySaleRepRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2012.02.21 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAORsltCustBySaleRepRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * customer 별 sale rep
	  * </pre>
	  */
	public PRICommonDBDAORsltCustBySaleRepRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAORsltCustBySaleRepRSQL").append("\n"); 
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
		query.append("SELECT A.SREP_CD CD" ).append("\n"); 
		query.append("      ,A.SREP_NM NM" ).append("\n"); 
		query.append("FROM   MDM_SLS_REP A" ).append("\n"); 
		query.append("      ,BKG_CUST_SLS_REP B" ).append("\n"); 
		query.append("WHERE A.SREP_CD = B.SREP_CD" ).append("\n"); 
		query.append("AND B.CUST_CNT_CD = @[etc2]" ).append("\n"); 
		query.append("AND B.CUST_SEQ = @[etc3]" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.OFC_CD = @[etc1]" ).append("\n"); 
		query.append("AND A.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("ORDER BY A.SREP_CD" ).append("\n"); 

	}
}