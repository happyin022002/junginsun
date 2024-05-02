/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSCurrentChassisDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.07
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.09.07 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSCurrentChassisDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MGS AT/DT History 변경에 따른 Chassis Equipment 정보의 동기화를 처리한다.
	  * </pre>
	  */
	public ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSCurrentChassisDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismgsetattachdetachhistory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetAttachDetachHistoryDBDAOmodifyMGSCurrentChassisDataUSQL").append("\n"); 
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
		query.append("UPDATE  CGM_EQUIPMENT A" ).append("\n"); 
		query.append("SET     ATCH_MGST_NO = (SELECT  /*+ INDEX_DESC(A XPKCGM_EQ_ATCH_DTCH_HIS) */" ).append("\n"); 
		query.append("                                NVL2(A.DTCH_YD_CD, NULL, A.EQ_NO)" ).append("\n"); 
		query.append("                        FROM    CGM_EQ_ATCH_DTCH_HIS A" ).append("\n"); 
		query.append("                        WHERE   EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("                        AND     ROWNUM = 1)," ).append("\n"); 
		query.append("        UPD_DT = SYSDATE," ).append("\n"); 
		query.append("        UPD_USR_ID = @[upd_usr_id]        " ).append("\n"); 
		query.append("WHERE   EQ_NO = (SELECT  /*+ INDEX_DESC(A XPKCGM_EQ_ATCH_DTCH_HIS) */" ).append("\n"); 
		query.append("                         CHSS_NO" ).append("\n"); 
		query.append("                 FROM    CGM_EQ_ATCH_DTCH_HIS A" ).append("\n"); 
		query.append("                 WHERE   EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("                 AND     ROWNUM = 1)" ).append("\n"); 

	}
}