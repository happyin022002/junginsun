/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchPsaEdoAckLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchPsaEdoAckLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA 터미널 EDI 전송 후 수신 받은 Ack 정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchPsaEdoAckLogRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchPsaEdoAckLogRSQL").append("\n"); 
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
		query.append("SELECT A.BL_NO" ).append("\n"); 
		query.append("       ,A.BKG_NO" ).append("\n"); 
		query.append("       ,B.CNTR_NO" ).append("\n"); 
		query.append("       ,B.DO_VSL_NM" ).append("\n"); 
		query.append("       ,B.DO_VSL_CD" ).append("\n"); 
		query.append("       ,B.DO_SKD_VOY_NO" ).append("\n"); 
		query.append("       ,B.DO_SKD_DIR_CD" ).append("\n"); 
		query.append("       ,B.PSA_DO_RCV_STS_CD" ).append("\n"); 
		query.append("       ,DECODE(B.PSA_DO_RCV_STS_CD,'A','Sucess','Fail')    AS PSA_DO_RCV_STS_NM" ).append("\n"); 
		query.append("       ,B.PSA_AUTH_NO" ).append("\n"); 
		query.append("       ,B.ERR_LOG_CTNT" ).append("\n"); 
		query.append("       ,B.RCV_DT" ).append("\n"); 
		query.append(" FROM  BKG_BOOKING           A" ).append("\n"); 
		query.append("      ,BKG_PSA_EDO_RCV_LOG   B" ).append("\n"); 
		query.append("WHERE A.BL_NO = substr(@[bl_no],1,12)" ).append("\n"); 
		query.append("AND   A.BL_NO = B.BL_NO" ).append("\n"); 

	}
}