/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOmodifyEdoReviewFlagUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.07
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.08.07 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOmodifyEdoReviewFlagUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * E-DO Review Flag 를 Y 로 업데이트
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOmodifyEdoReviewFlagUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqstNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOmodifyEdoReviewFlagUSQL").append("\n"); 
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
		query.append("UPDATE BKG_EDO_MST" ).append("\n"); 
		query.append("   SET EDO_RVW_FLG    = 'Y'" ).append("\n"); 
		query.append("     , EDO_RVW_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("     , EDO_RVW_DT     =  SYSDATE" ).append("\n"); 
		query.append(" WHERE EDO_RQST_NO    =  @[rqstNo]" ).append("\n"); 
		query.append("   AND EDO_RQST_SEQ = ( SELECT MAX(EDO_RQST_SEQ)" ).append("\n"); 
		query.append("                            FROM BKG_EDO_MST" ).append("\n"); 
		query.append("                           WHERE EDO_RQST_NO  = @[rqstNo]" ).append("\n"); 
		query.append("                             AND EDO_TP_CD    = @[tpCd] )" ).append("\n"); 
		query.append("   AND EDO_TP_CD    = @[tpCd]" ).append("\n"); 

	}
}