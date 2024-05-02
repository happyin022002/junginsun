/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InvoiceCreationDetailDBDAOgetCntrNoFromSvcOrdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.12
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2012.01.12 윤권영
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

public class InvoiceCreationDetailDBDAOgetCntrNoFromSvcOrdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Service Order 테이블로부터 Cntr No 를 가져온다
	  * </pre>
	  */
	public InvoiceCreationDetailDBDAOgetCntrNoFromSvcOrdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WoVndrSeq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TrspWoOfcCtyCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TrspWoSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration").append("\n"); 
		query.append("FileName : InvoiceCreationDetailDBDAOgetCntrNoFromSvcOrdRSQL").append("\n"); 
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
		query.append("SELECT SO.EQ_NO EqNo," ).append("\n"); 
		query.append("SO.BKG_NO BkgNo," ).append("\n"); 
		query.append("SO.TRSP_BND_CD BndCd," ).append("\n"); 
		query.append("SO.TRSP_COST_DTL_MOD_CD CostDtlModCd" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD SO," ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD WO" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SO.TRSP_WO_OFC_CTY_CD = WO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND SO.TRSP_WO_SEQ = WO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND NVL(SO.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND WO.TRSP_WO_OFC_CTY_CD = @[TrspWoOfcCtyCd]" ).append("\n"); 
		query.append("AND WO.TRSP_WO_SEQ = @[TrspWoSeq]" ).append("\n"); 
		query.append("AND WO.WO_VNDR_SEQ = @[WoVndrSeq]" ).append("\n"); 
		query.append("AND NVL(WO.DELT_FLG,'N') = 'N'" ).append("\n"); 

	}
}