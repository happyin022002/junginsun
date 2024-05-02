/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDisposalSeqDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.10.29 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 권영법
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDisposalSeqDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDisposalSeqData
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDisposalSeqDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDisposalSeqDataRSQL").append("\n"); 
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
		query.append("SELECT P2.PRE_DSP_NO||" ).append("\n"); 
		query.append("DECODE(LENGTH(P2.PRE_DSP_SEQ)," ).append("\n"); 
		query.append("1,'00'||P2.PRE_DSP_SEQ," ).append("\n"); 
		query.append("2,'0'||P2.PRE_DSP_SEQ," ).append("\n"); 
		query.append("P2.PRE_DSP_SEQ)  DISP_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT @[ofc_cd] || '-' || TO_CHAR(SYSDATE,'YYMM') || '-' AS PRE_DSP_NO" ).append("\n"); 
		query.append(",TO_CHAR(NVL(MAX(TO_NUMBER(SUBSTR(A.DISP_NO,LENGTH(A.DISP_NO)-2))),0)+1) PRE_DSP_SEQ" ).append("\n"); 
		query.append("FROM MNR_DISP_HDR A" ).append("\n"); 
		query.append("WHERE A.DISP_NO LIKE @[ofc_cd] || '-' || TO_CHAR(SYSDATE,'YYMM') || '-' ||'%'" ).append("\n"); 
		query.append(") P2" ).append("\n"); 

	}
}