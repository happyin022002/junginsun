/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MalaysiaCustomsTransmissionDBDAOgetBlNoForFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaCustomsTransmissionDBDAOgetBlNoForFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public MalaysiaCustomsTransmissionDBDAOgetBlNoForFlatFileRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaCustomsTransmissionDBDAOgetBlNoForFlatFileRSQL").append("\n"); 
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
		query.append("SELECT REPLACE(SUBSTR(MAX(SYS_CONNECT_BY_PATH(BL_NO, ';')),  2)||';' , ';', '') AS BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (SELECT B.BL_NO," ).append("\n"); 
		query.append("        ROWNUM RNUM" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER C," ).append("\n"); 
		query.append("               BKG_BOOKING B" ).append("\n"); 
		query.append("         WHERE (C.CNTR_NO, C.CNMV_CYC_NO) IN (SELECT D.CNTR_NO," ).append("\n"); 
		query.append("                                                     D.CNMV_CYC_NO" ).append("\n"); 
		query.append("                                                FROM BKG_CONTAINER D" ).append("\n"); 
		query.append("                                               WHERE D.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                                                 AND D.BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("           AND C.BKG_NO = B.BKG_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" START WITH RNUM = 1 CONNECT BY PRIOR RNUM = RNUM - 1" ).append("\n"); 

	}
}