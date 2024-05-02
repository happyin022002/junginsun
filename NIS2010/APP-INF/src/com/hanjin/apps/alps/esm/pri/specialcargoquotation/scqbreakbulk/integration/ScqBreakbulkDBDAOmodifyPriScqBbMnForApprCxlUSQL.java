/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqBreakbulkDBDAOmodifyPriScqBbMnForApprCxlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.23
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.07.23 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqBreakbulkDBDAOmodifyPriScqBbMnForApprCxlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.07.22 송호진 [CHM-201325102] Special cargo Quotation System 추가 수정 요청건 -
	  * Approval Cancel 을 수행하기 위해
	  * PRI_SCQ_BB_MN 테이블의 Status 를 현재 최종 상태로 변경 한다.
	  * </pre>
	  */
	public ScqBreakbulkDBDAOmodifyPriScqBbMnForApprCxlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration").append("\n"); 
		query.append("FileName : ScqBreakbulkDBDAOmodifyPriScqBbMnForApprCxlUSQL").append("\n"); 
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
		query.append("UPDATE  PRI_SCQ_BB_MN" ).append("\n"); 
		query.append("SET     PROG_STS_CD = " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  PROG_STS_CD" ).append("\n"); 
		query.append("FROM    PRI_SCQ_PROG" ).append("\n"); 
		query.append("WHERE   SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("AND     SCQ_VER_NO  = @[scq_ver_no]" ).append("\n"); 
		query.append("AND     SPCL_CGO_TP_CD = 'BB'" ).append("\n"); 
		query.append("AND     PROG_SEQ = (    SELECT  MAX ( PROG_SEQ ) " ).append("\n"); 
		query.append("                        FROM    PRI_SCQ_PROG " ).append("\n"); 
		query.append("                        WHERE   SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("                        AND     SCQ_VER_NO  = @[scq_ver_no]" ).append("\n"); 
		query.append("                        AND     SPCL_CGO_TP_CD = 'BB' ) )" ).append("\n"); 
		query.append("	,	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	,	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE   SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("AND     SCQ_VER_NO  = @[scq_ver_no]" ).append("\n"); 

	}
}