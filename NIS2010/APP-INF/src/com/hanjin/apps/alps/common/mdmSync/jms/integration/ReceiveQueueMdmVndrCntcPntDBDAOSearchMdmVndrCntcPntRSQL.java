/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceiveQueueMdmVndrCntcPntDBDAOSearchMdmVndrCntcPntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.09.22 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmVndrCntcPntDBDAOSearchMdmVndrCntcPntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMdmVndrCntcPnt
	  * </pre>
	  */
	public ReceiveQueueMdmVndrCntcPntDBDAOSearchMdmVndrCntcPntRSQL(){
		SetQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cntc_pnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration ").append("\n"); 
		query.append("FileName : ReceiveQueueMdmVndrCntcPntDBDAOSearchMdmVndrCntcPntRSQL").append("\n"); 
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
	public void SetQuery(){
		query.append("SELECT vndr_seq" ).append("\n");
		query.append("  FROM MDM_VNDR_CNTC_PNT" ).append("\n");
		query.append(" WHERE vndr_seq = TO_NUMBER(@[vndr_seq])" ).append("\n");
		query.append("   AND vndr_cntc_pnt_seq = TO_NUMBER(@[vndr_cntc_pnt_seq])" ).append("\n");  
	}
}