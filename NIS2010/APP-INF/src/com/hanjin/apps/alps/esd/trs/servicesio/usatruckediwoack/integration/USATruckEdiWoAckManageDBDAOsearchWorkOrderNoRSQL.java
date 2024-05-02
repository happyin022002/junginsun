/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : USATruckEdiWoAckManageDBDAOsearchWorkOrderNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2016.03.07 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.usatruckediwoack.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USATruckEdiWoAckManageDBDAOsearchWorkOrderNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderNo
	  * </pre>
	  */
	public USATruckEdiWoAckManageDBDAOsearchWorkOrderNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_ctrl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_so_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.usatruckediwoack.integration").append("\n"); 
		query.append("FileName : USATruckEdiWoAckManageDBDAOsearchWorkOrderNoRSQL").append("\n"); 
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
		query.append("SELECT TRSP_WO_OFC_CTY_CD||TRSP_WO_SEQ AS TRSP_WO_NO" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if(${ackhd} == '990') " ).append("\n"); 
		query.append("   AND TRSP_SO_OFC_CTY_CD = SUBSTR(@[edi_so_no],1,3)" ).append("\n"); 
		query.append("   AND TRSP_SO_SEQ        = TO_NUMBER(SUBSTR(@[edi_so_no],4,11))" ).append("\n"); 
		query.append("#else   " ).append("\n"); 
		query.append("   AND EDI_CTRL_SEQ       = TO_NUMBER(@[edi_ctrl_seq])" ).append("\n"); 
		query.append("#end " ).append("\n"); 

	}
}