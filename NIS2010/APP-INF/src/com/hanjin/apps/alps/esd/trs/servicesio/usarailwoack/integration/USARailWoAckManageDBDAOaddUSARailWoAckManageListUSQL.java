/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USARailWoAckManageDBDAOaddUSARailWoAckManageListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.usarailwoack.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USARailWoAckManageDBDAOaddUSARailWoAckManageListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_EDI_RAIL_ORD테이블 update
	  * </pre>
	  */
	public USARailWoAckManageDBDAOaddUSARailWoAckManageListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_edi_ctrl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_edi_rcv_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.usarailwoack.integration").append("\n"); 
		query.append("FileName : USARailWoAckManageDBDAOaddUSARailWoAckManageListUSQL").append("\n"); 
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
		query.append("UPDATE    TRS_TRSP_EDI_RAIL_ORD      X" ).append("\n"); 
		query.append("SET       X.BIL_EDI_RCV_RSLT_CD		 = NVL2(X.BIL_EDI_RSND_DT, X.BIL_EDI_RCV_RSLT_CD, @[bil_edi_rcv_rslt_cd])" ).append("\n"); 
		query.append(",   X.BIL_EDI_RCV_RSLT_DT		 = NVL2(X.BIL_EDI_RSND_DT, X.BIL_EDI_RCV_RSLT_DT, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd]))" ).append("\n"); 
		query.append(",   X.BIL_EDI_RSND_RCV_RSLT_CD = NVL2(X.BIL_EDI_RSND_DT, @[bil_edi_rcv_rslt_cd], NULL)" ).append("\n"); 
		query.append(",   X.BIL_EDI_RSND_RCV_RSLT_DT = NVL2(X.BIL_EDI_RSND_DT, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[cre_ofc_cd])	, NULL)" ).append("\n"); 
		query.append("WHERE     X.BIL_EDI_CTRL_SEQ		 = TO_NUMBER(@[bil_edi_ctrl_seq])" ).append("\n"); 

	}
}