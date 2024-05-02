/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiRcvSndIdHldRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.17 
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

public class CargoReleaseOrderDBDAOsearchEdiRcvSndIdHldRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ...
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiRcvSndIdHldRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_knd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiRcvSndIdHldRSQL").append("\n"); 
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
		query.append("SELECT 'PA' AS EDI_MSG_ID, C.CUST_TRD_PRNR_ID AS EDI_RCV_ID," ).append("\n"); 
		query.append("       C.PROV_TRD_PRNR_ID AS EDI_SND_ID, A.POD_NOD_CD YD_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING      A," ).append("\n"); 
		query.append("       BKG_CUSTOMER     B," ).append("\n"); 
		query.append("       EDI_GROUP        C," ).append("\n"); 
		query.append("       EDI_GRP_CUST     D," ).append("\n"); 
		query.append("       EDI_GRP_CGO      E" ).append("\n"); 
		query.append(" WHERE A.BL_NO          = @[bl_no]    " ).append("\n"); 
		query.append("   AND A.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND B.CUST_CNT_CD    = D.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND B.CUST_SEQ       = D.CUST_SEQ" ).append("\n"); 
		query.append("   AND D.EDI_GRP_CD     = C.EDI_GRP_CD" ).append("\n"); 
		query.append("   AND D.CO_DIV_CD      = 'SML'" ).append("\n"); 
		query.append("   AND C.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("   AND C.EDI_GRP_CD     = E.EDI_GRP_CD  " ).append("\n"); 
		query.append("   AND C.CO_DIV_CD      = E.CO_DIV_CD        " ).append("\n"); 
		query.append("   AND E.CUST_EDI_STS_CD = 'PA'" ).append("\n"); 
		query.append("   AND ROWNUM           = 1" ).append("\n"); 
		query.append("   AND 'PA1'            = @[edi_knd] " ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 'PA' AS EDI_MSG_ID, C.CUST_TRD_PRNR_ID AS EDI_RCV_ID," ).append("\n"); 
		query.append("       C.PROV_TRD_PRNR_ID AS EDI_SND_ID, A.POD_NOD_CD YD_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING      A," ).append("\n"); 
		query.append("       EDI_GROUP        C," ).append("\n"); 
		query.append("       EDI_GRP_CUST     D," ).append("\n"); 
		query.append("       EDI_GRP_CGO      E" ).append("\n"); 
		query.append(" WHERE A.BL_NO          = @[bl_no]" ).append("\n"); 
		query.append("   AND A.SC_NO          = D.SC_NO" ).append("\n"); 
		query.append("   AND D.BKG_CTRT_DIV_CD = '1'" ).append("\n"); 
		query.append("   AND D.EDI_GRP_CD     = C.EDI_GRP_CD" ).append("\n"); 
		query.append("   AND D.CO_DIV_CD      = 'SML'" ).append("\n"); 
		query.append("   AND C.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("   AND C.EDI_GRP_CD     = E.EDI_GRP_CD" ).append("\n"); 
		query.append("   AND C.CO_DIV_CD      = E.CO_DIV_CD " ).append("\n"); 
		query.append("   AND E.CUST_EDI_STS_CD = 'PA'   " ).append("\n"); 
		query.append("   AND ROWNUM           = 1" ).append("\n"); 
		query.append("   AND 'PA1'            = @[edi_knd]  " ).append("\n"); 
		query.append("UNION   " ).append("\n"); 
		query.append("SELECT 'PA' AS EDI_MSG_ID, C.CUST_TRD_PRNR_ID AS EDI_RCV_ID," ).append("\n"); 
		query.append("       C.PROV_TRD_PRNR_ID AS EDI_SND_ID, A.POD_NOD_CD YD_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING      A," ).append("\n"); 
		query.append("       BKG_CUSTOMER     B," ).append("\n"); 
		query.append("       EDI_GROUP        C," ).append("\n"); 
		query.append("       EDI_GRP_CUST     D," ).append("\n"); 
		query.append("       EDI_GRP_CGO      E" ).append("\n"); 
		query.append(" WHERE A.BL_NO          = @[bl_no]  " ).append("\n"); 
		query.append("   AND A.BKG_NO         = B.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("   AND B.CUST_CNT_CD    = D.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND B.CUST_SEQ       = D.CUST_SEQ" ).append("\n"); 
		query.append("   AND D.EDI_GRP_CD     = C.EDI_GRP_CD" ).append("\n"); 
		query.append("   AND D.CO_DIV_CD      = 'SML'" ).append("\n"); 
		query.append("   AND C.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("   AND C.EDI_GRP_CD     = E.EDI_GRP_CD" ).append("\n"); 
		query.append("   AND C.CO_DIV_CD      = E.CO_DIV_CD " ).append("\n"); 
		query.append("   AND E.CUST_EDI_STS_CD = 'PQ'       " ).append("\n"); 
		query.append("   AND ROWNUM           = 1" ).append("\n"); 
		query.append("   AND 'PQ1'            = @[edi_knd] " ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 'PA' AS EDI_MSG_ID, C.CUST_TRD_PRNR_ID AS EDI_RCV_ID," ).append("\n"); 
		query.append("       C.PROV_TRD_PRNR_ID AS EDI_SND_ID, A.POD_NOD_CD YD_CD" ).append("\n"); 
		query.append("  FROM BKG_BOOKING      A," ).append("\n"); 
		query.append("       EDI_GROUP        C," ).append("\n"); 
		query.append("       EDI_GRP_CUST     D," ).append("\n"); 
		query.append("       EDI_GRP_CGO      E" ).append("\n"); 
		query.append(" WHERE A.BL_NO          = @[bl_no]" ).append("\n"); 
		query.append("   AND A.SC_NO          = D.SC_NO" ).append("\n"); 
		query.append("   AND D.BKG_CTRT_DIV_CD = '1'" ).append("\n"); 
		query.append("   AND D.EDI_GRP_CD    = C.EDI_GRP_CD" ).append("\n"); 
		query.append("   AND D.CO_DIV_CD      = 'SML'" ).append("\n"); 
		query.append("   AND C.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("   AND C.EDI_GRP_CD     = E.EDI_GRP_CD" ).append("\n"); 
		query.append("   AND C.CO_DIV_CD      = E.CO_DIV_CD " ).append("\n"); 
		query.append("   AND E.CUST_EDI_STS_CD = 'PQ'              " ).append("\n"); 
		query.append("   AND ROWNUM           = 1" ).append("\n"); 
		query.append("   AND 'PQ1'            = @[edi_knd]" ).append("\n"); 

	}
}