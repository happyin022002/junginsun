/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdoTransLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdoTransLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI_BKG_0134 화면에서 사용하는 SQL
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdoTransLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdoTransLogRSQL").append("\n"); 
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
		query.append("SELECT A.EDO_SEQ," ).append("\n"); 
		query.append("       B.BL_NO," ).append("\n"); 
		query.append("       A.MF_REF_NO," ).append("\n"); 
		query.append("       A.MF_SEQ_NO," ).append("\n"); 
		query.append("       A.EDO_RSLT_CD," ).append("\n"); 
		query.append("       A.ACK_MSG," ).append("\n"); 
		query.append("       A.EDO_RCV_DT" ).append("\n"); 
		query.append("  FROM BKG_EDO_LOG A," ).append("\n"); 
		query.append("       BKG_BOOKING B" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rcv_fm_dt} != '')" ).append("\n"); 
		query.append("   AND A.EDO_RCV_DT BETWEEN TO_DATE(@[rcv_fm_dt], 'YYYYMMDD') " ).append("\n"); 
		query.append("                       AND (TO_DATE(@[rcv_to_dt], 'YYYYMMDD') + 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("   AND B.BL_NO  = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}