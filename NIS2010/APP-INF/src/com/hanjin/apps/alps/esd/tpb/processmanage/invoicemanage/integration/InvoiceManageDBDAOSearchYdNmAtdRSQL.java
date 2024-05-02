/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchYdNmAtdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchYdNmAtdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.11.29 변종건 [CHM-201220985-01] [TPB] PSO에 대한 3자구상 개발관련 - Yard Name, ATD 조회
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchYdNmAtdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchYdNmAtdRSQL").append("\n"); 
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
		query.append("SELECT  ( SELECT  YD_NM" ).append("\n"); 
		query.append("          FROM    MDM_YARD" ).append("\n"); 
		query.append("          WHERE   YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("        ) YD_NM" ).append("\n"); 
		query.append("      , TO_CHAR(TPB_GET_LCL_DATE_FNC(( SELECT  MIN(VPS_ETD_DT)" ).append("\n"); 
		query.append("                                       FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                       WHERE   VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("                                       AND     SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("                                       AND     SKD_DIR_CD  = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("                                       AND     YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("                                     ), @[s_ofc_cd]" ).append("\n"); 
		query.append("                                    ),'YYYY-MM-DD HH24:MI') ATD" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}