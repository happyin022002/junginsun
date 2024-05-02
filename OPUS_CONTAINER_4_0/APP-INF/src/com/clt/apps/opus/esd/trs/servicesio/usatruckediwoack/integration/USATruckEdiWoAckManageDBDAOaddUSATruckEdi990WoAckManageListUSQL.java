/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.usatruckediwoack.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRSP_SO_OFC_CTY_CD와 TRSP_SO_SEQ에 따른 TRS_TRSP_SVC_ORD테이블 update
	  * </pre>
	  */
	public USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_so_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.usatruckediwoack.integration ").append("\n"); 
		query.append("FileName : USATruckEdiWoAckManageDBDAOaddUSATruckEdi990WoAckManageListUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD SET" ).append("\n"); 
		query.append("EDI_RCV_RSLT_CD				= NVL(@[edi_rcv_rslt_cd],'A')" ).append("\n"); 
		query.append(", EDI_RCV_RSLT_DT				= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])" ).append("\n"); 
		query.append(", EDI_RCV_MSG_TP_CD				= @[edi_rcv_msg_tp_cd]" ).append("\n"); 
		query.append("WHERE	TRSP_SO_OFC_CTY_CD	 = SUBSTR(@[edi_so_no],1,3)" ).append("\n"); 
		query.append("AND    	TRSP_SO_SEQ	 = SUBSTR(@[edi_so_no],4,11)" ).append("\n"); 

	}
}