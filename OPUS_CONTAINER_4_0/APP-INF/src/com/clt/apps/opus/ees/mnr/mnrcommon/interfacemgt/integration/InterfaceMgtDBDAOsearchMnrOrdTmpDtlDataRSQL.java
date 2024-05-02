/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchMnrOrdTmpDtlDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchMnrOrdTmpDtlDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchMnrOrdTmpDtlDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_rcv_ord_inv_tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchMnrOrdTmpDtlDataRSQL").append("\n"); 
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
		query.append("SELECT MNR_RCV_ORD_INV_TMP_SEQ" ).append("\n"); 
		query.append("      ,MNR_RCV_ORD_INV_TMP_DTL_SEQ" ).append("\n"); 
		query.append("      ,MNR_ORD_SEQ" ).append("\n"); 
		query.append("      ,ORD_DTL_SEQ" ).append("\n"); 
		query.append("      ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("      ,EQ_NO" ).append("\n"); 
		query.append("      ,EQ_KND_CD" ).append("\n"); 
		query.append("      ,RPR_QTY" ).append("\n"); 
		query.append("      ,CURR_CD" ).append("\n"); 
		query.append("      ,INV_AMT" ).append("\n"); 
		query.append("      ,TO_CHAR(RPR_RSLT_DT, 'YYYYMMDD') RPR_RSLT_DT" ).append("\n"); 
		query.append("      ,YD_CD" ).append("\n"); 
		query.append("      ,COST_CD" ).append("\n"); 
		query.append("      ,VNDR_SEQ" ).append("\n"); 
		query.append("      ,RQST_REF_NO" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,VRFY_RSLT_DESC" ).append("\n"); 
		query.append("      ,COST_DTL_CD" ).append("\n"); 
		query.append("  FROM MNR_ORD_TMP_DTL" ).append("\n"); 
		query.append(" WHERE MNR_RCV_ORD_INV_TMP_SEQ = @[mnr_rcv_ord_inv_tmp_seq]" ).append("\n"); 

	}
}