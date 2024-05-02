/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmEdiSendDBDAOSearchEdiMsgToUsCaCntInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmEdiSendDBDAOSearchEdiMsgToUsCaCntInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container looping
	  * </pre>
	  */
	public CgmEdiSendDBDAOSearchEdiMsgToUsCaCntInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration").append("\n"); 
		query.append("FileName : CgmEdiSendDBDAOSearchEdiMsgToUsCaCntInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("      -- CNTR INFO" ).append("\n"); 
		query.append("       @[cntr_no] CNTRNBR" ).append("\n"); 
		query.append("      ,(SELECT CNTR_TPSZ_CD FROM MST_CONTAINER WHERE CNTR_NO = @[cntr_no] AND ROWNUM=1) CNTRTYPE" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("			SELECT                " ).append("\n"); 
		query.append("                ROUND(TO_NUMBER(CNTR_GRS_WGT) * 2.2046,0) TARE_WGT_LBS -- LBS 환산" ).append("\n"); 
		query.append("			FROM " ).append("\n"); 
		query.append("				MST_CNTR_SPEC B, " ).append("\n"); 
		query.append("				MST_CONTAINER C " ).append("\n"); 
		query.append("			WHERE 1 = 1" ).append("\n"); 
		query.append("			AND   C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("			AND   C.CNTR_SPEC_NO = B.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("            AND   ROWNUM=1" ).append("\n"); 
		query.append("       ) CNTR_TOTAL_WGT" ).append("\n"); 
		query.append("      ,'LBS'  CNTR_TOTAL_WGT_UNIT  -- 하드코딩" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_BOOKING  A" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}