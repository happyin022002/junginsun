/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchContainerListByWorkOrderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2010.04.08 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchContainerListByWorkOrderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchContainerListByWorkOrder
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchContainerListByWorkOrderRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchContainerListByWorkOrderRSQL").append("\n"); 
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
		query.append("SELECT  SO.EQ_NO CNTR_NO," ).append("\n"); 
		query.append("SO.EQ_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("SO.CGO_TP_CD CNTR_STY_CD," ).append("\n"); 
		query.append("@[io_bnd_cd] IO_BND_CD," ).append("\n"); 
		query.append("TO_CHAR(WO.LOCL_CRE_DT,'YYYYMMDD') WRK_DT" ).append("\n"); 
		query.append("FROM  TRS_TRSP_WRK_ORD WO, TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("WHERE WO.TRSP_WO_OFC_CTY_CD = SUBSTR(@[wo_no],1,3)" ).append("\n"); 
		query.append("AND WO.TRSP_WO_SEQ = SUBSTR(@[wo_no],4,LENGTH(@[wo_no])-3)" ).append("\n"); 
		query.append("AND WO.TRSP_WO_OFC_CTY_CD = SO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND WO.TRSP_WO_SEQ = SO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("--		AND INSTR(SO.TRSP_CRR_MOD_CD,'W') > 0" ).append("\n"); 
		query.append("--	부장님 요청으로 yard 조건은 넣지 않음." ).append("\n"); 
		query.append("--		AND (SO.FM_NOD_CD = ?" ).append("\n"); 
		query.append("--		    OR SO.TO_NOD_CD = ?" ).append("\n"); 
		query.append("--		    OR SO.VIA_NOD_CD = ?)" ).append("\n"); 
		query.append("--	AND SO.EQ_TP_CD = 'C'  -- 2010.0107 EQ_KND_CD로 통합됨" ).append("\n"); 
		query.append("AND SO.EQ_KND_CD = 'U'" ).append("\n"); 
		query.append("AND SO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND WO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND SO.EQ_NO IS NOT NULL" ).append("\n"); 

	}
}