/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InvoiceCreationDetailDBDAOcheckExistWorkOrderNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.20
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2012.06.20 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yun kwon-young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceCreationDetailDBDAOcheckExistWorkOrderNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Submit to HJS 시 WorkOrder No 존재여부 체크
	  * </pre>
	  */
	public InvoiceCreationDetailDBDAOcheckExistWorkOrderNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WO_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration").append("\n"); 
		query.append("FileName : InvoiceCreationDetailDBDAOcheckExistWorkOrderNoRSQL").append("\n"); 
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
		query.append("SELECT --TRSP_WO_OFC_CTY_CD,TRSP_WO_SEQ,WO_ISS_STS_CD,WO_VNDR_SEQ,DELT_FLG,INTER_USE_FLG," ).append("\n"); 
		query.append("CASE WHEN WO_VNDR_SEQ != @[VNDR_SEQ]  THEN '1'" ).append("\n"); 
		query.append("WHEN WO_ISS_STS_CD = 'N' THEN '2'" ).append("\n"); 
		query.append("ELSE '0'" ).append("\n"); 
		query.append("END notExtFlg" ).append("\n"); 
		query.append("FROM TRS_TRSP_WRK_ORD" ).append("\n"); 
		query.append("WHERE TRSP_WO_OFC_CTY_CD = SUBSTR(@[WO_NO],1,3)" ).append("\n"); 
		query.append("AND TRSP_WO_SEQ = SUBSTR(@[WO_NO],4)" ).append("\n"); 
		query.append("AND NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(INTER_USE_FLG, 'N') = 'N'" ).append("\n"); 

	}
}