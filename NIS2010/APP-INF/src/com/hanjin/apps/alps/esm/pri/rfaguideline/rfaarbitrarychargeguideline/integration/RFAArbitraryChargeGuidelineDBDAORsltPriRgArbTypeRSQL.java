/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAArbitraryChargeGuidelineDBDAORsltPriRgArbTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.31 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAArbitraryChargeGuidelineDBDAORsltPriRgArbTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * origin destination type
	  * </pre>
	  */
	public RFAArbitraryChargeGuidelineDBDAORsltPriRgArbTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaguideline.rfaarbitrarychargeguideline.integration").append("\n"); 
		query.append("FileName : RFAArbitraryChargeGuidelineDBDAORsltPriRgArbTypeRSQL").append("\n"); 
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
		query.append("SELECT TYPECD ," ).append("\n"); 
		query.append("nvl((SELECT 1 FROM PRI_RG_ARB" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   GLINE_SEQ  = @[gline_seq]" ).append("\n"); 
		query.append("AND   ORG_DEST_TP_CD = A.TYPECD" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append("),0)  TYPECOUNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'O' TYPECD  FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'D' FROM DUAL" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}