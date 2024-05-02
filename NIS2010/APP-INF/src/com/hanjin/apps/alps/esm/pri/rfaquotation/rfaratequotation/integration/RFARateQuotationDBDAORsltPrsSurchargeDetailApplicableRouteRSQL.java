/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateQuotationDBDAORsltPrsSurchargeDetailApplicableRouteRSQL.java
*@FileTitle : RFA Quotation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.29 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFARateQuotationDBDAORsltPrsSurchargeDetailApplicableRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Applicable Rout List  ( UI_PRI_6018, UC-PRI-062 )
	  * </pre>
	  */
	public RFARateQuotationDBDAORsltPrsSurchargeDetailApplicableRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("qttn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration").append("\n"); 
		query.append("FileName : RFARateQuotationDBDAORsltPrsSurchargeDetailApplicableRouteRSQL").append("\n"); 
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
		query.append("SELECT 	PRI_ROUT.QTTN_NO, PRI_ROUT.QTTN_VER_NO," ).append("\n"); 
		query.append("PRI_ROUT.CMDT_HDR_SEQ, PRI_ROUT.ROUT_SEQ, PRI_ROUT.RT_SEQ," ).append("\n"); 
		query.append("PRI_ROUT.POR_CD, PRI_ROUT.POL_CD, PRI_ROUT.POD_CD, PRI_ROUT.DEL_CD," ).append("\n"); 
		query.append("PRI_ROUT.RCV_TERM_CD, PRI_ROUT.DE_TERM_CD,PRI_ROUT.CRE_DT," ).append("\n"); 
		query.append("TO_CHAR(PRI_ROUT.CRE_DT,'YYYY-MM-DD') CRE_YMD, PRI_ROUT.RCV_TERM_CD, PRI_ROUT.DE_TERM_CD," ).append("\n"); 
		query.append("( 	SELECT COM_CD.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL COM_CD" ).append("\n"); 
		query.append("WHERE COM_CD.INTG_CD_ID = 'CD02138'" ).append("\n"); 
		query.append("AND COM_CD.INTG_CD_VAL_CTNT = PRI_ROUT.RCV_TERM_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("|| '-' ||" ).append("\n"); 
		query.append("( 	SELECT COM_CD.INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL COM_CD" ).append("\n"); 
		query.append("WHERE COM_CD.INTG_CD_ID = 'CD02138'" ).append("\n"); 
		query.append("AND COM_CD.INTG_CD_VAL_CTNT = PRI_ROUT.DE_TERM_CD" ).append("\n"); 
		query.append(")  AS RD_TERM_CD" ).append("\n"); 
		query.append("FROM PRI_RQ_RT_SCG_ROUT PRI_ROUT" ).append("\n"); 
		query.append("WHERE   QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("AND ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("AND RT_SEQ = @[rt_seq]" ).append("\n"); 

	}
}