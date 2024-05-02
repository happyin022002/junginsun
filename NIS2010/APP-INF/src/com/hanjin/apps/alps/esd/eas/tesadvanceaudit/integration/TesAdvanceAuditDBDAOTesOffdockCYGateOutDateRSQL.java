/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesOffdockCYGateOutDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.26
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.05.26 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOTesOffdockCYGateOutDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesOffdockCYGateOutDate
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesOffdockCYGateOutDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration ").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesOffdockCYGateOutDateRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    TO_CHAR(MIN(MVMT_GATE_OUT_DT), 'YYYY-MM-DD') AS FM_GO_DT" ).append("\n"); 
		query.append("  , TO_CHAR(MAX(MVMT_GATE_OUT_DT), 'YYYY-MM-DD') AS TO_GO_DT" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H" ).append("\n"); 
		query.append("  , TES_TML_SO_CNTR_LIST C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND  H.TML_SO_OFC_CTY_CD = C.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND  H.TML_SO_SEQ  = C.TML_SO_SEQ" ).append("\n"); 
		query.append("AND  H.YD_CD    = @[s_yd_cd]" ).append("\n"); 
		query.append("AND  H.VNDR_SEQ = @[s_vndr_seq]" ).append("\n"); 
		query.append("AND  H.INV_NO   = @[s_inv_no]" ).append("\n"); 

	}
}