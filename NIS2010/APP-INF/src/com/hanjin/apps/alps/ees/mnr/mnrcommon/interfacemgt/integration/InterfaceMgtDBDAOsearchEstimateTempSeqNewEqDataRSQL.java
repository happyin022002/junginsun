/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchEstimateTempSeqNewEqDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.12.01 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchEstimateTempSeqNewEqDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEstimateTempSeqNewEqData
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchEstimateTempSeqNewEqDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchEstimateTempSeqNewEqDataRSQL").append("\n"); 
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
		query.append("SELECT @[rqst_eq_no] AS RQST_EQ_NO," ).append("\n"); 
		query.append("NVL(MAX(B.RPR_RQST_TMP_SEQ) + 1, 1) AS RPR_RQST_TMP_SEQ," ).append("\n"); 
		query.append("'1' AS RPR_RQST_TMP_VER_NO" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_TMP_HDR B" ).append("\n"); 
		query.append("WHERE B.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 

	}
}