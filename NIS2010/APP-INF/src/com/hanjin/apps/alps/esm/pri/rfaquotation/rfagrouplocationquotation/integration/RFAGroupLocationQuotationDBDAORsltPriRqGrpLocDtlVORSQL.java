/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RFAGroupLocationQuotationDBDAORsltPriRqGrpLocDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.15
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.15 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupLocationQuotationDBDAORsltPriRqGrpLocDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public RFAGroupLocationQuotationDBDAORsltPriRqGrpLocDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_loc_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.integration").append("\n"); 
		query.append("FileName : RFAGroupLocationQuotationDBDAORsltPriRqGrpLocDtlVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	A.QTTN_NO" ).append("\n"); 
		query.append(",	A.QTTN_VER_NO" ).append("\n"); 
		query.append(",	A.GRP_LOC_SEQ" ).append("\n"); 
		query.append(",	A.GRP_LOC_DTL_SEQ" ).append("\n"); 
		query.append(",	A.LOC_CD" ).append("\n"); 
		query.append(",	B.LOC_NM" ).append("\n"); 
		query.append(",	A.SRC_INFO_CD" ).append("\n"); 
		query.append(",   (SELECT INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("    from COM_INTG_CD_DTL" ).append("\n"); 
		query.append("    WHERE INTG_CD_ID = 'CD02200'" ).append("\n"); 
		query.append("    AND   INTG_CD_VAL_CTNT = A.SRC_INFO_CD) AS SRC_INFO_NM" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append(",   MN.SVC_SCP_CD" ).append("\n"); 
		query.append("FROM PRI_RQ_GRP_LOC_DTL A" ).append("\n"); 
		query.append("	, PRI_RQ_MN MN" ).append("\n"); 
		query.append(",	 MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE	A.QTTN_NO = @[qttn_no]" ).append("\n"); 
		query.append("AND	A.QTTN_VER_NO = @[qttn_ver_no]" ).append("\n"); 
		query.append("AND	A.GRP_LOC_SEQ = @[grp_loc_seq]" ).append("\n"); 
		query.append("AND A.QTTN_NO = MN.QTTN_NO" ).append("\n"); 
		query.append("AND A.QTTN_VER_NO = MN.QTTN_VER_NO" ).append("\n"); 
		query.append("AND A.LOC_CD = B.LOC_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.LOC_CD, B.LOC_NM" ).append("\n"); 

	}
}