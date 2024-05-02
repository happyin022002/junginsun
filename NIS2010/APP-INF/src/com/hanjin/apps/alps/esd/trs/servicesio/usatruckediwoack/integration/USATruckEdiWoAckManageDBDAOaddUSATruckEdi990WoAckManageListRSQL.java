/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.usatruckediwoack.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRSP_SO_OFC_CTY_CD와 TRSP_SO_SEQ조건에 따른 TRS_TRSP_SVC_ORD테이블 조회
	  * </pre>
	  */
	public USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_so_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.usatruckediwoack.integration").append("\n"); 
		query.append("FileName : USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListRSQL").append("\n"); 
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
		query.append("SELECT  CRE_OFC_CD, EDI_RCV_MSG_TP_CD FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE	TRSP_SO_OFC_CTY_CD	 = SUBSTR(@[edi_so_no],1,3)" ).append("\n"); 
		query.append("AND 	TRSP_SO_SEQ	 = TO_NUMBER(SUBSTR(@[edi_so_no],4,11))" ).append("\n"); 

	}
}