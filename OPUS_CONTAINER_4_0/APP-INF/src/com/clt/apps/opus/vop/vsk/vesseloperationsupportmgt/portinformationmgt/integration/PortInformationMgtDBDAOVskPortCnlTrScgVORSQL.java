/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PortInformationMgtDBDAOVskPortCnlTrScgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortInformationMgtDBDAOVskPortCnlTrScgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public PortInformationMgtDBDAOVskPortCnlTrScgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.portinformationmgt.integration").append("\n"); 
		query.append("FileName : PortInformationMgtDBDAOVskPortCnlTrScgVORSQL").append("\n"); 
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
		query.append("SELECT    NVL(@[loc_cd],X.LOC_CD)		AS LOC_CD" ).append("\n"); 
		query.append("       ,  NVL(X.TR_SEQ,Y.TMP_SEQ)     	AS TR_SEQ" ).append("\n"); 
		query.append("       ,  X.TR_SCG_RTO" ).append("\n"); 
		query.append("FROM      VSK_PORT_CNL_TR_SCG  X" ).append("\n"); 
		query.append("       , (SELECT 1 TMP_SEQ FROM DUAL  	UNION ALL" ).append("\n"); 
		query.append("          SELECT 2 TMP_SEQ FROM DUAL  	UNION ALL" ).append("\n"); 
		query.append("          SELECT 3 TMP_SEQ FROM DUAL  	UNION ALL" ).append("\n"); 
		query.append("          SELECT 4 TMP_SEQ FROM DUAL  	UNION ALL" ).append("\n"); 
		query.append("          SELECT 5 TMP_SEQ FROM DUAL  	UNION ALL" ).append("\n"); 
		query.append("          SELECT 6 TMP_SEQ FROM DUAL  	UNION ALL" ).append("\n"); 
		query.append("          SELECT 7 TMP_SEQ FROM DUAL	UNION ALL" ).append("\n"); 
		query.append("          SELECT 8 TMP_SEQ FROM DUAL	UNION ALL" ).append("\n"); 
		query.append("          SELECT 9 TMP_SEQ FROM DUAL	" ).append("\n"); 
		query.append("          )  Y" ).append("\n"); 
		query.append("WHERE    X.LOC_CD  (+)            		= @[loc_cd]" ).append("\n"); 
		query.append("AND      X.TR_SEQ  (+)            		= Y.TMP_SEQ" ).append("\n"); 
		query.append("ORDER BY NVL(X.TR_SEQ,Y.TMP_SEQ)  		ASC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("----SELECT LOC_CD" ).append("\n"); 
		query.append("----,      TR_SEQ" ).append("\n"); 
		query.append("----,      TR_SCG_RTO" ).append("\n"); 
		query.append("----  FROM VSK_PORT_CNL_TR_SCG" ).append("\n"); 
		query.append("---- WHERE LOC_CD = [loc_cd]" ).append("\n"); 
		query.append("----ORDER BY TR_SEQ ASC" ).append("\n"); 

	}
}